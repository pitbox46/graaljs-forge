/*
 * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oracle.truffle.js.runtime.interop;

import java.util.ArrayList;
import java.util.List;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameUtil;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.nodes.FrameDescriptorProvider;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.JSConstantNode;
import com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode;
import com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode;
import com.oracle.truffle.js.nodes.access.ScopeFrameNode;
import com.oracle.truffle.js.nodes.access.WriteNode;
import com.oracle.truffle.js.nodes.function.BlockScopeNode;
import com.oracle.truffle.js.runtime.JSArguments;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSFrameUtil;
import com.oracle.truffle.js.runtime.JSRealm;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.builtins.JSFunction;
import com.oracle.truffle.js.runtime.objects.Null;
import com.oracle.truffle.js.runtime.objects.Undefined;

@ExportLibrary(InteropLibrary.class)
public final class ScopeVariables implements TruffleObject {

    public static final String RECEIVER_MEMBER = "this";
    static final int LIMIT = 4;

    final Frame frame;
    final boolean nodeEnter;
    final Node blockOrRoot; // FrameBlockScopeNode or RootNode
    final Frame functionFrame;
    private ScopeMembers members;

    /**
     * @param frame Block scope or function frame
     * @param nodeEnter True if we are entering the node
     * @param blockOrRoot FrameBlockScopeNode or FunctionRootNode
     * @param functionFrame Optional function frame not accessible via parent chain
     */
    public ScopeVariables(Frame frame, boolean nodeEnter, /* FrameBlockScopeNode or RootNode */ Node blockOrRoot, Frame functionFrame) {
        this.frame = frame;
        this.nodeEnter = nodeEnter;
        this.blockOrRoot = blockOrRoot;
        this.functionFrame = functionFrame;
    }

    /**
     * Assure that we fix the current node and enter flag.
     */
    @ExportMessage
    boolean accepts(@Cached(value = "this.blockOrRoot", adopt = false) Node cachedNode,
                    @Cached(value = "this.nodeEnter") boolean cachedNodeEnter) {
        return this.blockOrRoot == cachedNode && this.nodeEnter == cachedNodeEnter;
    }

    @ExportMessage
    @SuppressWarnings("static-method")
    boolean isScope() {
        return true;
    }

    @ExportMessage
    @SuppressWarnings("static-method")
    boolean hasLanguage() {
        return true;
    }

    @ExportMessage
    @SuppressWarnings("static-method")
    Class<? extends TruffleLanguage<?>> getLanguage() {
        return JavaScriptLanguage.class;
    }

    @ExportMessage
    @TruffleBoundary
    boolean hasScopeParent() {
        if (blockOrRoot instanceof BlockScopeNode) {
            Node parentNode = JavaScriptNode.findBlockScopeNode(blockOrRoot.getParent());
            if (parentNode != null) {
                if (frame == null) {
                    return true;
                } else if (getParentFrame(((BlockScopeNode) blockOrRoot).isFunctionBlock()) != null) {
                    return true;
                }
            }
        } else {
            assert blockOrRoot instanceof RootNode;
            if (frame != null) {
                // For closures, we don't have any outer block nodes, only the RootNode.
                if (ScopeFrameNode.isBlockScopeFrame(frame)) {
                    if (getParentFrame(false) != null) {
                        return true;
                    }
                }
            }
        }
        if (frame != null) {
            Frame parentFrame = JSFrameUtil.getParentFrame(frame);
            return parentFrame != null && parentFrame != JSFrameUtil.NULL_MATERIALIZED_FRAME;
        }
        return false;
    }

    @ExportMessage
    @TruffleBoundary
    Object getScopeParent() throws UnsupportedMessageException {
        if (blockOrRoot instanceof BlockScopeNode) {
            Node parentBlock = JavaScriptNode.findBlockScopeNode(blockOrRoot.getParent());
            if (parentBlock != null) {
                if (frame == null) {
                    return new ScopeVariables(null, true, parentBlock, null);
                } else {
                    Frame enclosingFrame = getParentFrame(((BlockScopeNode) blockOrRoot).isFunctionBlock());
                    if (enclosingFrame != null) {
                        return new ScopeVariables(enclosingFrame, true, parentBlock, functionFrame);
                    }
                }
            }
        } else {
            assert blockOrRoot instanceof RootNode;
            if (frame != null) {
                // For closures, we don't have any outer block nodes, only the RootNode.
                if (ScopeFrameNode.isBlockScopeFrame(frame)) {
                    Frame parentBlockScope = getParentFrame(false);
                    if (parentBlockScope != null) {
                        return new ScopeVariables(parentBlockScope, true, blockOrRoot, null);
                    }
                }
            }
        }
        if (frame != null) {
            Frame parentFrame = JSFrameUtil.getParentFrame(frame);
            if (parentFrame != null && parentFrame != JSFrameUtil.NULL_MATERIALIZED_FRAME) {
                RootNode rootNode = ((RootCallTarget) JSFunction.getCallTarget(JSFrameUtil.getFunctionObject(parentFrame))).getRootNode();
                return new ScopeVariables(parentFrame, true, rootNode, null);
            }
        }
        throw UnsupportedMessageException.create();
    }

    @TruffleBoundary
    private Frame getParentFrame(boolean functionBlock) {
        FrameSlot parentSlot = frame.getFrameDescriptor().findFrameSlot(ScopeFrameNode.PARENT_SCOPE_IDENTIFIER);
        if (parentSlot != null) {
            Object parent = FrameUtil.getObjectSafe(frame, parentSlot);
            if (parent instanceof Frame) {
                return (Frame) parent;
            } else if (functionFrame != null && functionFrame != frame && !functionBlock) {
                return functionFrame;
            }
        }
        return null;
    }

    @ExportMessage
    @SuppressWarnings("static-method")
    boolean hasMembers() {
        return true;
    }

    @ExportMessage
    @TruffleBoundary
    Object getMembers(@SuppressWarnings("unused") boolean includeInternal) {
        ScopeMembers m = this.members;
        if (m == null) {
            m = new ScopeMembers(frame, blockOrRoot, functionFrame);
            this.members = m;
        }
        return m;
    }

    @ExportMessage
    static final class IsMemberReadable {

        @Specialization(guards = {"RECEIVER_MEMBER.equals(member)"})
        static boolean doReadThis(ScopeVariables receiver, @SuppressWarnings("unused") String member) {
            return receiver.frame != null;
        }

        @Specialization(guards = {"cachedMember.equals(member)", "!RECEIVER_MEMBER.equals(cachedMember)"}, limit = "LIMIT")
        static boolean doCached(ScopeVariables receiver, String member,
                        @Cached("member") @SuppressWarnings("unused") String cachedMember,
                        // We cache the member existence for fast-path access
                        @Cached("doGeneric(receiver, member)") boolean cachedResult) {
            assert cachedResult == doGeneric(receiver, member);
            return cachedResult;
        }

        @Specialization(guards = {"!RECEIVER_MEMBER.equals(member)"}, replaces = "doCached")
        @TruffleBoundary
        static boolean doGeneric(ScopeVariables receiver, String member) {
            return hasSlot(member, receiver);
        }
    }

    @ExportMessage
    static final class IsMemberModifiable {

        @Specialization(guards = {"RECEIVER_MEMBER.equals(member)"})
        static boolean doReadThis(ScopeVariables receiver, @SuppressWarnings("unused") String member) {
            return receiver.frame != null;
        }

        @Specialization(guards = {"cachedMember.equals(member)", "!RECEIVER_MEMBER.equals(cachedMember)"}, limit = "LIMIT")
        static boolean doCached(ScopeVariables receiver, String member,
                        @Cached("member") @SuppressWarnings("unused") String cachedMember,
                        // We cache the member existence for fast-path access
                        @Cached("doGeneric(receiver, member)") boolean cachedResult) {
            assert cachedResult == doGeneric(receiver, member);
            return cachedResult;
        }

        @Specialization(guards = {"!RECEIVER_MEMBER.equals(member)"}, replaces = "doCached")
        @TruffleBoundary
        static boolean doGeneric(ScopeVariables receiver, String member) {
            ResolvedSlot slot = findSlot(member, receiver);
            return slot != null && slot.isModifiable();
        }
    }

    @ExportMessage
    static final class ReadMember {

        @Specialization(guards = {"RECEIVER_MEMBER.equals(member)"})
        @TruffleBoundary
        static Object doReadThis(ScopeVariables receiver, String member) throws UnknownIdentifierException {
            if (receiver.frame != null) {
                return getThis(receiver.frame);
            } else {
                throw UnknownIdentifierException.create(member);
            }
        }

        @Specialization(guards = {"cachedMember.equals(member)", "!RECEIVER_MEMBER.equals(cachedMember)"}, limit = "LIMIT")
        static Object doCached(ScopeVariables receiver, @SuppressWarnings("unused") String member,
                        @Cached("member") String cachedMember,
                        // We cache the member's read node for fast-path access
                        @Cached(value = "findSlot(member, receiver)") ResolvedSlot resolvedSlot,
                        @Cached(value = "findReadNode(resolvedSlot)") JavaScriptNode readNode) throws UnknownIdentifierException {
            return doRead(receiver, cachedMember, readNode, resolvedSlot);
        }

        @Specialization(guards = {"!RECEIVER_MEMBER.equals(member)"}, replaces = "doCached")
        @TruffleBoundary
        static Object doGeneric(ScopeVariables receiver, String member) throws UnknownIdentifierException {
            ResolvedSlot resolvedSlot = findSlot(member, receiver);
            JavaScriptNode readNode = findReadNode(resolvedSlot);
            return doRead(receiver, member, readNode, resolvedSlot);
        }

        private static Object doRead(ScopeVariables receiver, String member, JavaScriptNode readNode, ResolvedSlot resolvedSlot) throws UnknownIdentifierException {
            if (readNode == null) {
                throw UnknownIdentifierException.create(member);
            }
            Frame frame = resolvedSlot.isFunctionFrame() ? receiver.functionFrame : receiver.frame;
            if (frame == null) {
                return Undefined.instance;
            } else {
                return readNode.execute((VirtualFrame) frame);
            }
        }
    }

    @ExportMessage
    static final class WriteMember {

        @Specialization(guards = {"RECEIVER_MEMBER.equals(member)"})
        @TruffleBoundary
        static void doWriteThis(@SuppressWarnings("unused") ScopeVariables receiver, String member, @SuppressWarnings("unused") Object value) throws UnknownIdentifierException {
            throw UnknownIdentifierException.create(member); // not modifiable
        }

        @Specialization(guards = {"cachedMember.equals(member)", "!RECEIVER_MEMBER.equals(cachedMember)"}, limit = "LIMIT")
        static void doCached(ScopeVariables receiver, @SuppressWarnings("unused") String member, Object value,
                        @Cached("member") String cachedMember,
                        // We cache the member's write node for fast-path access
                        @Cached(value = "findSlot(member, receiver)") ResolvedSlot resolvedSlot,
                        @Cached(value = "findWriteNode(resolvedSlot)") WriteNode writeNode) throws UnknownIdentifierException {
            doWrite(receiver, cachedMember, value, writeNode, resolvedSlot);
        }

        @Specialization(guards = {"!RECEIVER_MEMBER.equals(member)"}, replaces = "doCached")
        @TruffleBoundary
        static void doGeneric(ScopeVariables receiver, String member, Object value) throws UnknownIdentifierException {
            ResolvedSlot resolvedSlot = findSlot(member, receiver);
            WriteNode writeNode = findWriteNode(resolvedSlot);
            doWrite(receiver, member, value, writeNode, resolvedSlot);
        }

        private static void doWrite(ScopeVariables receiver, String member, Object value, WriteNode writeNode, ResolvedSlot resolvedSlot) throws UnknownIdentifierException {
            if (writeNode == null) {
                throw UnknownIdentifierException.create(member);
            }
            Frame frame = resolvedSlot.isFunctionFrame() ? receiver.functionFrame : receiver.frame;
            if (frame == null) {
                throw UnknownIdentifierException.create(member);
            }
            writeNode.executeWrite((VirtualFrame) frame, value);
        }
    }

    @SuppressWarnings("static-method")
    @ExportMessage
    boolean isMemberInsertable(@SuppressWarnings("unused") String member) {
        return false;
    }

    @ExportMessage
    @TruffleBoundary
    boolean hasSourceLocation() {
        return blockOrRoot.getEncapsulatingSourceSection() != null;
    }

    @ExportMessage
    @TruffleBoundary
    SourceSection getSourceLocation() throws UnsupportedMessageException {
        Node sourceSectionProvider = blockOrRoot;
        if (sourceSectionProvider instanceof BlockScopeNode && ((BlockScopeNode) sourceSectionProvider).isFunctionBlock()) {
            sourceSectionProvider = sourceSectionProvider.getRootNode();
        }
        SourceSection sourceLocation = sourceSectionProvider.getEncapsulatingSourceSection();
        if (sourceLocation == null) {
            throw UnsupportedMessageException.create();
        }
        return sourceLocation;
    }

    @SuppressWarnings("static-method")
    @ExportMessage
    @TruffleBoundary
    Object toDisplayString(@SuppressWarnings("unused") boolean allowSideEffects) {
        RootNode root;
        if (blockOrRoot instanceof BlockScopeNode) {
            if (((BlockScopeNode) blockOrRoot).isFunctionBlock()) {
                root = blockOrRoot.getRootNode();
            } else {
                return "block";
            }
        } else {
            root = (RootNode) blockOrRoot;
        }
        String name = root.getName();
        return (name == null) ? "" : name;
    }

    static class ResolvedSlot {
        final FrameSlot slot;
        final int frameLevel;
        final int scopeLevel;
        final FrameDescriptor descriptor;
        final FrameSlot[] parentSlots;

        ResolvedSlot(FrameSlot slot, int frameLevel, int scopeLevel, FrameDescriptor descriptor, List<FrameSlot> parentSlotList) {
            this.slot = slot;
            this.frameLevel = frameLevel;
            this.scopeLevel = scopeLevel;
            this.descriptor = descriptor;
            this.parentSlots = parentSlotList == null ? null : parentSlotList.toArray(ScopeFrameNode.EMPTY_FRAME_SLOT_ARRAY);
        }

        ResolvedSlot() {
            this(null, -1, -1, null, null);
        }

        JavaScriptNode createReadNode() {
            if (slot == null) {
                return JSConstantNode.createUndefined();
            }
            ScopeFrameNode scopeFrameNode = createScopeFrameNode();
            return JSReadFrameSlotNode.create(slot, scopeFrameNode, JSFrameUtil.hasTemporalDeadZone(slot));
        }

        WriteNode createWriteNode() {
            if (slot == null) {
                return null;
            }
            ScopeFrameNode scopeFrameNode = createScopeFrameNode();
            return JSWriteFrameSlotNode.create(slot, scopeFrameNode, null, descriptor, JSFrameUtil.hasTemporalDeadZone(slot));
        }

        ScopeFrameNode createScopeFrameNode() {
            if (isFunctionFrame()) {
                return ScopeFrameNode.createCurrent();
            }
            return ScopeFrameNode.create(frameLevel, scopeLevel, parentSlots, null);
        }

        boolean isModifiable() {
            return slot != null && !JSFrameUtil.isConst(slot);
        }

        boolean isFunctionFrame() {
            return scopeLevel < 0;
        }
    }

    static class DynamicScopeResolvedSlot extends ResolvedSlot {
        final Object key;

        DynamicScopeResolvedSlot(Object key, FrameSlot slot, int frameLevel, int scopeLevel, FrameDescriptor descriptor, List<FrameSlot> parentSlotList) {
            super(slot, frameLevel, scopeLevel, descriptor, parentSlotList);
            this.key = key;
        }

        @Override
        JavaScriptNode createReadNode() {
            JavaScriptNode readDynamicScope = super.createReadNode();

            class EvalRead extends JavaScriptNode {
                @Child JavaScriptNode getDynamicScope = readDynamicScope;
                @Child DynamicObjectLibrary objectLibrary;

                @Override
                public Object execute(VirtualFrame frame) {
                    DynamicObject scope = (DynamicObject) getDynamicScope.execute(frame);
                    DynamicObjectLibrary lib = objectLibrary;
                    if (lib == null) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        if (getParent() != null) {
                            lib = insert(DynamicObjectLibrary.getFactory().createDispatched(JSConfig.PropertyCacheLimit));
                        } else {
                            lib = DynamicObjectLibrary.getUncached();
                        }
                        objectLibrary = lib;
                    }
                    return lib.getOrDefault(scope, key, Undefined.instance);
                }
            }
            return new EvalRead();
        }

        @Override
        WriteNode createWriteNode() {
            JavaScriptNode readDynamicScope = super.createReadNode();

            class EvalWrite extends JavaScriptNode implements WriteNode {
                @Child JavaScriptNode getDynamicScope = readDynamicScope;
                @Child DynamicObjectLibrary objectLibrary;

                @Override
                public Object execute(VirtualFrame frame) {
                    throw CompilerDirectives.shouldNotReachHere();
                }

                @Override
                public Object executeWrite(VirtualFrame frame, Object value) {
                    DynamicObject scope = (DynamicObject) getDynamicScope.execute(frame);
                    DynamicObjectLibrary lib = objectLibrary;
                    if (lib == null) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        if (getParent() != null) {
                            lib = insert(DynamicObjectLibrary.getFactory().createDispatched(JSConfig.PropertyCacheLimit));
                        } else {
                            lib = DynamicObjectLibrary.getUncached();
                        }
                        objectLibrary = lib;
                    }
                    return lib.putIfPresent(scope, key, value);
                }

                @Override
                public JavaScriptNode getRhs() {
                    return null;
                }
            }
            return new EvalWrite();
        }
    }

    static ResolvedSlot findSlot(String member, ScopeVariables receiver) {
        CompilerAsserts.neverPartOfCompilation();
        if (receiver.frame == null) {
            return findSlotWithoutFrame(member, receiver.blockOrRoot);
        }

        Node descNode = receiver.blockOrRoot;
        Frame outerFrame = receiver.frame;
        Frame currentFunctionFrame = receiver.functionFrame;
        for (int frameLevel = 0;; frameLevel++) {
            Frame outerScope = outerFrame;

            List<FrameSlot> parentSlotList = new ArrayList<>();
            int scopeLevel = 0;
            while (true) {
                FrameDescriptor frameDescriptor = outerScope.getFrameDescriptor();
                FrameSlot slot = frameDescriptor.findFrameSlot(member);
                if (slot != null) {
                    if (JSFrameUtil.isInternal(slot)) {
                        return null;
                    }
                    return new ResolvedSlot(slot, frameLevel, scopeLevel, frameDescriptor, parentSlotList);
                }

                // look up direct eval scope variable
                FrameSlot evalScopeSlot = frameDescriptor.findFrameSlot(ScopeFrameNode.EVAL_SCOPE_IDENTIFIER);
                if (evalScopeSlot != null) {
                    DynamicObject evalScope = (DynamicObject) FrameUtil.getObjectSafe(outerScope, evalScopeSlot);
                    DynamicObjectLibrary objLib = DynamicObjectLibrary.getUncached();
                    if (objLib.containsKey(evalScope, member)) {
                        return new DynamicScopeResolvedSlot(member, evalScopeSlot, frameLevel, scopeLevel, frameDescriptor, parentSlotList);
                    }
                }

                FrameSlot parentSlot = frameDescriptor.findFrameSlot(ScopeFrameNode.PARENT_SCOPE_IDENTIFIER);
                if (parentSlot == null) {
                    break;
                }

                assert scopeLevel >= 0;
                Object parent = FrameUtil.getObjectSafe(outerScope, parentSlot);
                if (parent instanceof Frame) {
                    outerScope = (Frame) parent;
                    parentSlotList.add(parentSlot);
                    scopeLevel++;
                } else if (currentFunctionFrame != null && currentFunctionFrame != outerScope) {
                    outerScope = currentFunctionFrame;
                    scopeLevel = -1;
                } else {
                    break;
                }
                if (descNode != null) {
                    descNode = JavaScriptNode.findBlockScopeNode(descNode.getParent());
                }
            }

            outerFrame = JSArguments.getEnclosingFrame(outerFrame.getArguments());
            currentFunctionFrame = null;
            if (outerFrame == JSFrameUtil.NULL_MATERIALIZED_FRAME) {
                break;
            }
        }
        return null; // Not found
    }

    private static ResolvedSlot findSlotWithoutFrame(String member, Node blockOrRootNode) {
        Node descNode = blockOrRootNode;
        while (descNode != null) {
            if (!(descNode instanceof FrameDescriptorProvider)) {
                break;
            }
            FrameDescriptor desc = ((FrameDescriptorProvider) descNode).getFrameDescriptor();
            FrameSlot slot = desc.findFrameSlot(member);
            if (slot != null) {
                if (JSFrameUtil.isInternal(slot)) {
                    return null;
                }
                return new ResolvedSlot();
            }

            descNode = JavaScriptNode.findBlockScopeNode(descNode.getParent());
        }
        return null;
    }

    static boolean hasSlot(String member, ScopeVariables receiver) {
        return findSlot(member, receiver) != null;
    }

    static JavaScriptNode findReadNode(ResolvedSlot slot) {
        if (slot != null) {
            return slot.createReadNode();
        } else {
            return null;
        }
    }

    static WriteNode findWriteNode(ResolvedSlot slot) {
        if (slot != null && slot.isModifiable()) {
            return slot.createWriteNode();
        } else {
            return null;
        }
    }

    static Object getThis(Frame frame) {
        FrameSlot thisSlot = JSFrameUtil.getThisSlot(frame.getFrameDescriptor());
        if (thisSlot == null) {
            return thisFromArguments(frame.getArguments());
        } else {
            Object thiz = frame.getValue(thisSlot);
            if (thiz == Undefined.instance) {
                // this can be either undefined or not populated yet
                // => try to avoid returning undefined in the latter case
                Object[] args = frame.getArguments();
                Object function = JSArguments.getFunctionObject(args);
                if (JSFunction.isJSFunction(function)) {
                    DynamicObject jsFunction = (DynamicObject) function;
                    thiz = isArrowFunctionWithThisCaptured(jsFunction) ? JSFunction.getLexicalThis(jsFunction) : thisFromArguments(args);
                }
            }
            return thiz;
        }
    }

    private static Object thisFromArguments(Object[] args) {
        Object thisObject = JSArguments.getThisObject(args);
        Object function = JSArguments.getFunctionObject(args);
        if (JSFunction.isJSFunction(function) && !JSFunction.isStrict((DynamicObject) function)) {
            JSRealm realm = JavaScriptLanguage.getCurrentJSRealm();
            if (thisObject == Undefined.instance || thisObject == Null.instance) {
                thisObject = realm.getGlobalObject();
            } else {
                thisObject = JSRuntime.toObject(realm.getContext(), thisObject);
            }
        }
        return thisObject;
    }

    private static boolean isArrowFunctionWithThisCaptured(DynamicObject function) {
        return !JSFunction.isConstructor(function) && JSFunction.isClassPrototypeInitialized(function);
    }

}
