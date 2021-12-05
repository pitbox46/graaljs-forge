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

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.runtime.JSArguments;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.JavaScriptRootNode;
import com.oracle.truffle.js.runtime.objects.Undefined;

public abstract class NewTargetRootNode extends JavaScriptRootNode {
    protected final CallTarget callTarget;

    @Child protected DirectCallNode callNode;

    protected NewTargetRootNode(JavaScriptLanguage lang, CallTarget callTarget) {
        super(lang, ((RootCallTarget) callTarget).getRootNode().getSourceSection(), null);
        this.callTarget = callTarget;
    }

    public static JavaScriptRootNode createNewTargetConstruct(JavaScriptLanguage lang, CallTarget callTarget) {
        return createNewTarget(lang, callTarget, true);
    }

    public static JavaScriptRootNode createNewTargetCall(JavaScriptLanguage lang, CallTarget callTarget) {
        return createNewTarget(lang, callTarget, false);
    }

    private static JavaScriptRootNode createNewTarget(JavaScriptLanguage lang, CallTarget callTarget, boolean construct) {
        return new InsertNewTargetRootNode(lang, callTarget, construct);
    }

    public static JavaScriptRootNode createDropNewTarget(JavaScriptLanguage lang, CallTarget callTarget) {
        return new DropNewTargetRootNode(lang, callTarget);
    }

    @Override
    public boolean isCloningAllowed() {
        return true;
    }

    @Override
    protected boolean isCloneUninitializedSupported() {
        return true;
    }

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    protected abstract JavaScriptRootNode cloneUninitialized();

    @Override
    @TruffleBoundary
    public String toString() {
        String callTargetName = ((RootCallTarget) callTarget).getRootNode().toString();
        return JSConfig.DetailedCallTargetNames ? JSRuntime.stringConcat("[NewTarget]", callTargetName) : callTargetName;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        if (callNode == null) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            this.callNode = insert(Truffle.getRuntime().createDirectCallNode(callTarget));
        }
        return doCall(frame);
    }

    @Override
    public String getName() {
        return ((RootCallTarget) callTarget).getRootNode().getName();
    }

    protected abstract Object doCall(VirtualFrame frame);

    public static class InsertNewTargetRootNode extends NewTargetRootNode {
        private final boolean construct;

        protected InsertNewTargetRootNode(JavaScriptLanguage lang, CallTarget callTarget, boolean construct) {
            super(lang, callTarget);
            this.construct = construct;
        }

        private static Object[] copyAndInsertArgument(Object[] arguments, int insertPosition, Object newTarget) {
            final int insertLength = 1;
            Object[] newArguments = new Object[arguments.length + insertLength];
            System.arraycopy(arguments, 0, newArguments, 0, insertPosition);
            newArguments[insertPosition] = newTarget;
            System.arraycopy(arguments, insertPosition, newArguments, insertPosition + insertLength, arguments.length - insertPosition);
            return newArguments;
        }

        @Override
        protected Object doCall(VirtualFrame frame) {
            Object[] arguments = frame.getArguments();
            Object newTarget = construct ? JSArguments.getFunctionObject(frame.getArguments()) : Undefined.instance;
            Object[] newArguments = copyAndInsertArgument(arguments, JSArguments.RUNTIME_ARGUMENT_COUNT, newTarget);
            return callNode.call(newArguments);
        }

        @Override
        protected JavaScriptRootNode cloneUninitialized() {
            return new InsertNewTargetRootNode(getLanguage(), callTarget, construct);
        }
    }

    public static class DropNewTargetRootNode extends NewTargetRootNode {
        protected DropNewTargetRootNode(JavaScriptLanguage lang, CallTarget callTarget) {
            super(lang, callTarget);
        }

        private static Object[] copyAndDropArgument(Object[] arguments, int dropPosition, int dropLength) {
            Object[] newArguments = new Object[arguments.length - dropLength];
            System.arraycopy(arguments, 0, newArguments, 0, dropPosition);
            System.arraycopy(arguments, dropPosition + dropLength, newArguments, dropPosition, arguments.length - dropPosition - dropLength);
            return newArguments;
        }

        @Override
        protected Object doCall(VirtualFrame frame) {
            Object[] arguments = frame.getArguments();
            Object[] newArguments = copyAndDropArgument(arguments, JSArguments.RUNTIME_ARGUMENT_COUNT, 1);
            return callNode.call(newArguments);
        }

        @Override
        protected JavaScriptRootNode cloneUninitialized() {
            return new DropNewTargetRootNode(getLanguage(), callTarget);
        }
    }
}
