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
package com.oracle.truffle.js.nodes.control;

import java.util.Set;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleStackTrace;
import com.oracle.truffle.api.exception.AbstractTruffleException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.StandardTags.TryBlockTag;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.interop.ExceptionType;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.nodes.ControlFlowException;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JavaScriptBaseNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.InitErrorObjectNode;
import com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode;
import com.oracle.truffle.js.nodes.cast.JSToBooleanUnaryNode;
import com.oracle.truffle.js.nodes.function.BlockScopeNode;
import com.oracle.truffle.js.nodes.instrumentation.JSTags;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.ControlFlowRootTag;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.GraalJSException;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSErrorType;
import com.oracle.truffle.js.runtime.JSException;
import com.oracle.truffle.js.runtime.JSRealm;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.UserScriptException;
import com.oracle.truffle.js.runtime.builtins.JSError;
import com.oracle.truffle.js.runtime.objects.Undefined;

/**
 * 12.14 The try Statement.
 */
@NodeInfo(shortName = "try-catch")
public class TryCatchNode extends StatementNode implements ResumableNode {

    @Child private JavaScriptNode tryBlock;
    @Child private JavaScriptNode catchBlock;
    @Child private JSWriteFrameSlotNode writeErrorVar;
    @Child private BlockScopeNode blockScope;
    @Child private JavaScriptNode destructuring;
    @Child private JavaScriptNode conditionExpression; // non-standard extension
    @Child private GetErrorObjectNode getErrorObjectNode;
    @Child private InteropLibrary exceptions;
    private final JSContext context;

    protected TryCatchNode(JSContext context, JavaScriptNode tryBlock, JavaScriptNode catchBlock, JSWriteFrameSlotNode writeErrorVar, BlockScopeNode blockScope, JavaScriptNode destructuring,
                    JavaScriptNode conditionExpression) {
        this.context = context;
        this.tryBlock = tryBlock;
        this.writeErrorVar = writeErrorVar;
        this.catchBlock = catchBlock;
        this.blockScope = blockScope;
        this.destructuring = destructuring;
        this.conditionExpression = conditionExpression == null ? null : JSToBooleanUnaryNode.create(conditionExpression);
        assert blockScope != null || writeErrorVar == null;
    }

    public static TryCatchNode create(JSContext context, JavaScriptNode tryBlock, JavaScriptNode catchBlock, JSWriteFrameSlotNode writeErrorVar, BlockScopeNode blockScope,
                    JavaScriptNode destructuring, JavaScriptNode conditionExpression) {
        return new TryCatchNode(context, tryBlock, catchBlock, writeErrorVar, blockScope, destructuring, conditionExpression);
    }

    @Override
    public boolean hasTag(Class<? extends Tag> tag) {
        if (tag == ControlFlowRootTag.class || tag == TryBlockTag.class) {
            return true;
        }
        return super.hasTag(tag);
    }

    @Override
    public Object getNodeObject() {
        return JSTags.createNodeObjectDescriptor("type", ControlFlowRootTag.Type.ExceptionHandler.name());
    }

    @Override
    protected JavaScriptNode copyUninitialized(Set<Class<? extends Tag>> materializedTags) {
        return create(context, cloneUninitialized(tryBlock, materializedTags), cloneUninitialized(catchBlock, materializedTags), cloneUninitialized(writeErrorVar, materializedTags),
                        cloneUninitialized(blockScope, materializedTags), cloneUninitialized(destructuring, materializedTags),
                        cloneUninitialized(conditionExpression, materializedTags));
    }

    @Override
    public boolean isResultAlwaysOfType(Class<?> clazz) {
        return tryBlock.isResultAlwaysOfType(clazz) && catchBlock.isResultAlwaysOfType(clazz);
    }

    @Override
    public final Object execute(VirtualFrame frame) {
        try {
            return tryBlock.execute(frame);
        } catch (ControlFlowException cfe) {
            throw cfe;
        } catch (Throwable ex) {
            if (shouldCatch(ex, exceptions())) {
                return executeCatch(frame, ex);
            } else {
                throw ex;
            }
        }
    }

    @Override
    public final void executeVoid(VirtualFrame frame) {
        try {
            tryBlock.executeVoid(frame);
        } catch (ControlFlowException cfe) {
            throw cfe;
        } catch (Throwable ex) {
            if (shouldCatch(ex, exceptions())) {
                executeCatch(frame, ex);
            } else {
                throw ex;
            }
        }
    }

    public static boolean shouldCatch(Throwable ex, InteropLibrary exceptions) {
        if (exceptions.isException(ex)) {
            try {
                ExceptionType exceptionType = exceptions.getExceptionType(ex);
                return exceptionType != ExceptionType.EXIT && exceptionType != ExceptionType.INTERRUPT;
            } catch (UnsupportedMessageException e) {
                throw Errors.createTypeErrorInteropException(ex, e, "getExceptionType", null);
            }
        } else if (ex instanceof StackOverflowError) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean shouldCatch(Throwable ex) {
        return shouldCatch(ex, InteropLibrary.getUncached());
    }

    private Object executeCatch(VirtualFrame frame, Throwable ex) {
        if (blockScope != null) {
            blockScope.appendScopeFrame(frame);
        }
        try {
            if (prepareCatch(frame, ex)) {
                return catchBlock.execute(frame);
            } else {
                throw JSRuntime.rethrow(ex);
            }
        } finally {
            if (blockScope != null) {
                blockScope.exitScope(frame);
            }
        }
    }

    private boolean prepareCatch(VirtualFrame frame, Throwable ex) {
        if (writeErrorVar != null) {
            if (getErrorObjectNode == null) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                getErrorObjectNode = insert(GetErrorObjectNode.create(context));
            }
            Object exceptionObject = getErrorObjectNode.execute(ex);
            writeErrorVar.executeWrite(frame, exceptionObject);

            if (destructuring != null) {
                destructuring.execute(frame);
            }
        }

        return conditionExpression == null || executeConditionAsBoolean(frame, conditionExpression);
    }

    @Override
    public Object resume(VirtualFrame frame) {
        Object state = getStateAndReset(frame);
        if (state == Undefined.instance) {
            try {
                return tryBlock.execute(frame);
            } catch (ControlFlowException cfe) {
                throw cfe;
            } catch (Throwable ex) {
                if (shouldCatch(ex, exceptions())) {
                    if (blockScope != null) {
                        blockScope.appendScopeFrame(frame);
                    }
                    if (!prepareCatch(frame, ex)) {
                        throw JSRuntime.rethrow(ex);
                    }
                    // fall through to execute catch block
                } else {
                    throw ex;
                }
            }
        } else {
            if (blockScope != null) {
                blockScope.setBlockScope(frame, state);
            }
        }
        try {
            return catchBlock.execute(frame);
        } catch (YieldException e) {
            setState(frame, blockScope == null ? 1 : blockScope.getBlockScope(frame));
            throw e;
        } finally {
            if (blockScope != null) {
                blockScope.exitScope(frame);
            }
        }
    }

    private InteropLibrary exceptions() {
        InteropLibrary e = exceptions;
        if (e == null) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            exceptions = e = insert(InteropLibrary.getFactory().createDispatched(JSConfig.InteropLibraryLimit));
        }
        return e;
    }

    public static final class GetErrorObjectNode extends JavaScriptBaseNode {
        @Child private InitErrorObjectNode initErrorObjectNode;
        private final ConditionProfile isJSError = ConditionProfile.createBinaryProfile();
        private final ConditionProfile isJSException = ConditionProfile.createBinaryProfile();
        private final BranchProfile truffleExceptionBranch = BranchProfile.create();
        private final BranchProfile legacyTruffleExceptionBranch = BranchProfile.create();
        private final JSContext context;

        private GetErrorObjectNode(JSContext context) {
            this.context = context;
            this.initErrorObjectNode = InitErrorObjectNode.create(context, context.isOptionNashornCompatibilityMode());
        }

        public static GetErrorObjectNode create(JSContext context) {
            return new GetErrorObjectNode(context);
        }

        @SuppressWarnings("deprecation")
        public Object execute(Throwable ex) {
            if (isJSError.profile(ex instanceof JSException)) {
                // fill in any missing stack trace elements
                TruffleStackTrace.fillIn(ex);

                return doJSException((JSException) ex);
            } else if (isJSException.profile(ex instanceof UserScriptException)) {
                return ((UserScriptException) ex).getErrorObject();
            } else if (ex instanceof StackOverflowError) {
                CompilerDirectives.transferToInterpreter();
                JSException rangeException = Errors.createRangeErrorStackOverflow(ex, this);
                return doJSException(rangeException);
            } else {
                truffleExceptionBranch.enter();
                assert !(ex instanceof GraalJSException) && (ex instanceof AbstractTruffleException || ex instanceof com.oracle.truffle.api.TruffleException) : ex;
                if (ex instanceof AbstractTruffleException) {
                    return ex;
                } else {
                    legacyTruffleExceptionBranch.enter();
                    Object exceptionObject = ((com.oracle.truffle.api.TruffleException) ex).getExceptionObject();
                    if (exceptionObject != null) {
                        return exceptionObject;
                    }
                    // This should not happen in practice but if it does, we do not want to expose
                    // the exception itself, so we convert it to a best-effort JS Error.
                    return Errors.createErrorFromException(ex);
                }
            }
        }

        private Object doJSException(JSException exception) {
            DynamicObject errorObj = exception.getErrorObject();
            // not thread safe, but should be alright in this case
            if (errorObj == null) {
                JSRealm realm = exception.getRealm();
                if (realm == null) {
                    realm = getRealm();
                }
                String message = exception.getRawMessage();
                assert message != null;
                errorObj = createErrorFromJSException(context, realm, exception.getErrorType());
                initErrorObjectNode.execute(errorObj, exception, message);
                exception.setErrorObject(errorObj);
            }
            return errorObj;
        }

        @TruffleBoundary
        private static DynamicObject createErrorFromJSException(JSContext context, JSRealm realm, JSErrorType errorType) {
            return JSError.createErrorObject(context, realm, errorType);
        }
    }
}
