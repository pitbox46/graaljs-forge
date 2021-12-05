/*
 * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.js.nodes.function;

import java.util.Set;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameUtil;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.InstrumentableNode;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.nodes.RepeatingNode;
import com.oracle.truffle.js.nodes.FrameDescriptorProvider;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.ScopeFrameNode;
import com.oracle.truffle.js.nodes.control.ResumableNode;
import com.oracle.truffle.js.nodes.control.YieldException;
import com.oracle.truffle.js.nodes.instrumentation.DeclareTagProvider;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.DeclareTag;
import com.oracle.truffle.js.runtime.JSFrameUtil;
import com.oracle.truffle.js.runtime.objects.Undefined;

public abstract class BlockScopeNode extends JavaScriptNode implements ResumableNode, RepeatingNode {
    @Child protected JavaScriptNode block;

    protected BlockScopeNode(JavaScriptNode block) {
        this.block = block;
    }

    public static BlockScopeNode create(JavaScriptNode block, FrameSlot blockScopeSlot, FrameDescriptor frameDescriptor, FrameSlot parentSlot, boolean functionBlock, boolean captureFunctionFrame) {
        return new FrameBlockScopeNode(block, blockScopeSlot, frameDescriptor, parentSlot, functionBlock, captureFunctionFrame);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        try {
            return block.execute(appendScopeFrame(frame));
        } finally {
            exitScope(frame);
        }
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        try {
            block.executeVoid(appendScopeFrame(frame));
        } finally {
            exitScope(frame);
        }
    }

    public abstract VirtualFrame appendScopeFrame(VirtualFrame frame);

    public abstract void exitScope(VirtualFrame frame);

    public abstract Object getBlockScope(VirtualFrame frame);

    public abstract void setBlockScope(VirtualFrame frame, Object state);

    @Override
    public boolean executeRepeating(VirtualFrame frame) {
        try {
            return ((RepeatingNode) block).executeRepeating(appendScopeFrame(frame));
        } finally {
            exitScope(frame);
        }
    }

    public JavaScriptNode getBlock() {
        return block;
    }

    public abstract boolean isFunctionBlock();

    @Override
    public boolean isResultAlwaysOfType(Class<?> clazz) {
        return block.isResultAlwaysOfType(clazz);
    }

    public static class FrameBlockScopeNode extends BlockScopeNode implements FrameDescriptorProvider {
        protected final FrameSlot blockScopeSlot;
        protected final FrameDescriptor frameDescriptor;
        protected final FrameSlot parentSlot;
        /** If true, this is the function-level block scope. */
        protected final boolean functionBlock;
        /** If true, put the virtual function frame in the parent scope slot. */
        protected final boolean captureFunctionFrame;

        protected FrameBlockScopeNode(JavaScriptNode block, FrameSlot blockScopeSlot, FrameDescriptor frameDescriptor, FrameSlot parentSlot, boolean functionBlock, boolean captureFunctionFrame) {
            super(block);
            this.blockScopeSlot = blockScopeSlot;
            this.frameDescriptor = frameDescriptor;
            this.parentSlot = parentSlot;
            this.functionBlock = functionBlock;
            this.captureFunctionFrame = captureFunctionFrame;
        }

        @Override
        public InstrumentableNode materializeInstrumentableNodes(Set<Class<? extends Tag>> materializedTags) {
            if (materializedTags.contains(DeclareTag.class) && !DeclareTagProvider.isMaterializedFrameProvider(this)) {
                JavaScriptNode materialized = DeclareTagProvider.createMaterializedBlockNode(cloneUninitialized(block, materializedTags),
                                blockScopeSlot, frameDescriptor, parentSlot, getSourceSection(), functionBlock, captureFunctionFrame);
                transferSourceSectionAndTags(this, materialized);
                return materialized;
            } else {
                return this;
            }
        }

        @Override
        public VirtualFrame appendScopeFrame(VirtualFrame frame) {
            Object parentScopeFrame = FrameUtil.getObjectSafe(frame, blockScopeSlot);
            if (captureFunctionFrame) {
                assert parentScopeFrame == Undefined.instance;
                parentScopeFrame = frame.materialize();
            }
            MaterializedFrame scopeFrame = Truffle.getRuntime().createVirtualFrame(frame.getArguments(), frameDescriptor).materialize();
            scopeFrame.setObject(parentSlot, parentScopeFrame);
            frame.setObject(blockScopeSlot, scopeFrame);
            return frame;
        }

        @Override
        public void exitScope(VirtualFrame frame) {
            MaterializedFrame blockScopeFrame = JSFrameUtil.castMaterializedFrame(FrameUtil.getObjectSafe(frame, blockScopeSlot));
            Object parentScopeFrame = FrameUtil.getObjectSafe(blockScopeFrame, parentSlot);
            if (captureFunctionFrame) {
                assert ((Frame) parentScopeFrame).getFrameDescriptor() == frame.getFrameDescriptor();
                // Avoid self reference
                parentScopeFrame = Undefined.instance;
            }
            frame.setObject(blockScopeSlot, parentScopeFrame);
            assert CompilerDirectives.inCompiledCode() || ScopeFrameNode.isBlockScopeFrame(blockScopeFrame);
        }

        @Override
        public FrameDescriptor getFrameDescriptor() {
            return frameDescriptor;
        }

        @Override
        public Object resume(VirtualFrame frame) {
            // Q: Why do we exit the scope when we yield even though we resume back into it anyway?
            // A: This is in order to allow (side-effect-free) uses of outer block frame slots
            // during resumption before we reach this block scope again.
            // A simple example would be an assignment that checks the frame slot type before it
            // executes/resumes the right hand side, e.g.:
            // `let C = <scope> class C { [await](){} } </scope>;`
            Object state = getStateAndReset(frame);
            if (state == Undefined.instance) {
                appendScopeFrame(frame);
            } else {
                setBlockScope(frame, state);
            }
            try {
                return block.execute(frame);
            } catch (YieldException e) {
                setState(frame, getBlockScope(frame));
                throw e;
            } finally {
                exitScope(frame);
            }
        }

        @Override
        public Object getBlockScope(VirtualFrame frame) {
            return FrameUtil.getObjectSafe(frame, blockScopeSlot);
        }

        @Override
        public void setBlockScope(VirtualFrame frame, Object state) {
            assert state instanceof MaterializedFrame;
            frame.setObject(blockScopeSlot, state);
        }

        @Override
        public boolean isFunctionBlock() {
            return functionBlock;
        }

        @Override
        protected JavaScriptNode copyUninitialized(Set<Class<? extends Tag>> materializedTags) {
            return new FrameBlockScopeNode(cloneUninitialized(block, materializedTags), blockScopeSlot, frameDescriptor, parentSlot, functionBlock, captureFunctionFrame);
        }
    }
}
