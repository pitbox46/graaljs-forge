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
package com.oracle.truffle.js.nodes.promise;

import java.util.List;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleStackTraceElement;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.InstrumentableNode;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.instrumentation.StandardTags;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.HiddenKey;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JavaScriptBaseNode;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.access.PropertySetNode;
import com.oracle.truffle.js.nodes.control.AwaitNode;
import com.oracle.truffle.js.nodes.control.TryCatchNode;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.JSArguments;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSFrameUtil;
import com.oracle.truffle.js.runtime.JavaScriptRootNode;
import com.oracle.truffle.js.runtime.PromiseHook;
import com.oracle.truffle.js.runtime.builtins.JSFunction;
import com.oracle.truffle.js.runtime.builtins.JSFunctionData;
import com.oracle.truffle.js.runtime.objects.PromiseCapabilityRecord;
import com.oracle.truffle.js.runtime.objects.PromiseReactionRecord;
import com.oracle.truffle.js.runtime.objects.Undefined;

public class PromiseReactionJobNode extends JavaScriptBaseNode {
    static final HiddenKey REACTION_KEY = new HiddenKey("Reaction");
    static final HiddenKey ARGUMENT_KEY = new HiddenKey("Argument");

    private final JSContext context;
    @Child private PropertySetNode setReaction;
    @Child private PropertySetNode setArgument;

    protected PromiseReactionJobNode(JSContext context) {
        this.context = context;
        this.setReaction = PropertySetNode.createSetHidden(REACTION_KEY, context);
        this.setArgument = PropertySetNode.createSetHidden(ARGUMENT_KEY, context);
    }

    public static PromiseReactionJobNode create(JSContext context) {
        return new PromiseReactionJobNode(context);
    }

    public DynamicObject execute(Object reaction, Object argument) {
        JSFunctionData functionData = context.getOrCreateBuiltinFunctionData(JSContext.BuiltinFunctionKey.PromiseReactionJob, (c) -> createPromiseReactionJobImpl(c));
        DynamicObject function = JSFunction.create(getRealm(), functionData);
        setReaction.setValue(function, reaction);
        setArgument.setValue(function, argument);
        return function;
    }

    private static JSFunctionData createPromiseReactionJobImpl(JSContext context) {
        CallTarget callTarget = Truffle.getRuntime().createCallTarget(new PromiseReactionJobRootNode(context));
        return JSFunctionData.createCallOnly(context, callTarget, 0, "");
    }

    public static class PromiseReactionJobRootNode extends JavaScriptRootNode implements InstrumentableNode {
        private final JSContext context;
        @Child private PropertyGetNode getReaction;
        @Child private PropertyGetNode getArgument;
        @Child private JSFunctionCallNode callResolveNode;
        @Child private JSFunctionCallNode callRejectNode;
        @Child private JSFunctionCallNode callHandlerNode;
        @Child private TryCatchNode.GetErrorObjectNode getErrorObjectNode;
        @Child private InteropLibrary exceptions;
        private final ConditionProfile handlerProf = ConditionProfile.createBinaryProfile();

        PromiseReactionJobRootNode(JSContext context) {
            super(context.getLanguage(), null, null);
            this.context = context;
            this.getReaction = PropertyGetNode.createGetHidden(REACTION_KEY, context);
            this.getArgument = PropertyGetNode.createGetHidden(ARGUMENT_KEY, context);
        }

        @Override
        public Object execute(VirtualFrame frame) {
            DynamicObject functionObject = JSFrameUtil.getFunctionObject(frame);
            PromiseReactionRecord reaction = (PromiseReactionRecord) getReaction.getValue(functionObject);
            Object argument = getArgument.getValue(functionObject);

            PromiseCapabilityRecord promiseCapability = reaction.getCapability();
            Object handler = reaction.getHandler();
            assert promiseCapability != null || handler != Undefined.instance;

            if (promiseCapability != null) {
                context.notifyPromiseHook(PromiseHook.TYPE_BEFORE, promiseCapability.getPromise());
            }

            Object handlerResult;
            boolean fulfill;
            if (handlerProf.profile(handler == Undefined.instance)) {
                handlerResult = argument;
                fulfill = reaction.isFulfill();
            } else {
                try {
                    handlerResult = callHandler().executeCall(JSArguments.createOneArg(Undefined.instance, handler, argument));
                    // If promiseCapability is undefined, return NormalCompletion(empty).
                    if (promiseCapability == null) {
                        return Undefined.instance;
                    }
                    fulfill = true;
                } catch (Throwable ex) {
                    if (promiseCapability == null && context.isOptionTopLevelAwait()) {
                        // top-level-await evaluation: throw exception when error is generated but
                        // no capability is found in chain
                        throw ex;
                    }
                    if (shouldCatch(ex)) {
                        handlerResult = getErrorObjectNode.execute(ex);
                        fulfill = false;
                    } else {
                        throw ex;
                    }
                }
            }
            Object status;
            if (fulfill) {
                status = callResolve().executeCall(JSArguments.createOneArg(Undefined.instance, promiseCapability.getResolve(), handlerResult));
            } else {
                status = callReject().executeCall(JSArguments.createOneArg(Undefined.instance, promiseCapability.getReject(), handlerResult));
            }

            context.notifyPromiseHook(PromiseHook.TYPE_AFTER, promiseCapability.getPromise());
            return status;
        }

        private boolean shouldCatch(Throwable exception) {
            if (getErrorObjectNode == null || exceptions == null) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                getErrorObjectNode = insert(TryCatchNode.GetErrorObjectNode.create(context));
                exceptions = insert(InteropLibrary.getFactory().createDispatched(JSConfig.InteropLibraryLimit));
            }
            return TryCatchNode.shouldCatch(exception, exceptions);
        }

        private JSFunctionCallNode callResolve() {
            if (callResolveNode == null) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                callResolveNode = insert(JSFunctionCallNode.createCall());
            }
            return callResolveNode;
        }

        private JSFunctionCallNode callReject() {
            if (callRejectNode == null) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                callRejectNode = insert(JSFunctionCallNode.createCall());
            }
            return callRejectNode;
        }

        private JSFunctionCallNode callHandler() {
            if (callHandlerNode == null) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                callHandlerNode = insert(JSFunctionCallNode.createCall());
            }
            return callHandlerNode;
        }

        @Override
        public boolean isCaptureFramesForTrace() {
            return context.isOptionAsyncStackTraces();
        }

        @Override
        protected List<TruffleStackTraceElement> findAsynchronousFrames(Frame frame) {
            if (!context.isOptionAsyncStackTraces()) {
                return null;
            }

            DynamicObject functionObject = JSFrameUtil.getFunctionObject(frame);
            PromiseReactionRecord reaction = (PromiseReactionRecord) getReaction.getValue(functionObject);
            PromiseCapabilityRecord promiseCapability = reaction.getCapability();
            if (promiseCapability != null) {
                return AwaitNode.findAsyncStackFramesFromPromise(promiseCapability.getPromise());
            } else if (JSFunction.isJSFunction(reaction.getHandler())) {
                return AwaitNode.findAsyncStackFramesFromHandler((DynamicObject) reaction.getHandler());
            }
            return null;
        }

        @Override
        public boolean hasTag(Class<? extends Tag> tag) {
            return tag == StandardTags.RootTag.class;
        }

        @Override
        public boolean isInstrumentable() {
            return false;
        }

        @Override
        public WrapperNode createWrapper(ProbeNode probe) {
            throw Errors.shouldNotReachHere();
        }
    }
}
