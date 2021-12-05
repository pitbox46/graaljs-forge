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
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.access.IsObjectNode;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.JavaScriptRootNode;
import com.oracle.truffle.js.runtime.builtins.JSFunction;
import com.oracle.truffle.js.runtime.builtins.JSFunctionData;
import com.oracle.truffle.js.runtime.builtins.JSOrdinary;
import com.oracle.truffle.js.runtime.objects.Undefined;

public final class ConstructorRootNode extends JavaScriptRootNode {
    private final JSFunctionData functionData;
    private final CallTarget callTarget;

    @Child private DirectCallNode callNode;
    @Child private SpecializedNewObjectNode newObjectNode;
    @Child private IsObjectNode isObjectNode;
    private final ConditionProfile isObject = ConditionProfile.createBinaryProfile();
    private final ConditionProfile isNotUndefined = ConditionProfile.createBinaryProfile();
    private final boolean newTarget;
    private final JSOrdinary instanceLayout;

    protected ConstructorRootNode(JSFunctionData functionData, CallTarget callTarget, boolean newTarget, JSOrdinary instanceLayout) {
        super(functionData.getContext().getLanguage(), ((RootCallTarget) callTarget).getRootNode().getSourceSection(), null);
        this.functionData = functionData;
        this.callTarget = callTarget;
        this.newTarget = newTarget;
        this.instanceLayout = instanceLayout;
    }

    public static ConstructorRootNode create(JSFunctionData functionData, CallTarget callTarget, boolean newTarget, JSOrdinary instanceLayout) {
        return new ConstructorRootNode(functionData, callTarget, newTarget, instanceLayout);
    }

    public static ConstructorRootNode create(JSFunctionData functionData, CallTarget callTarget, boolean newTarget) {
        return create(functionData, callTarget, newTarget, JSOrdinary.INSTANCE);
    }

    private Object allocateThisObject(VirtualFrame frame, Object[] arguments) {
        // Only base constructors allocate a new object. Derived constructors have to call the super
        // constructor to get the `this` object (which is then returned).
        Object thisObject;
        if (!getFunctionData().isDerived()) {
            Object functionObject = newTarget ? arguments[2] : arguments[1];
            thisObject = newObjectNode.execute(frame, (DynamicObject) functionObject);
        } else {
            thisObject = JSFunction.CONSTRUCT; // Just a placeholder value; not actually used.
        }
        arguments[0] = thisObject;
        return thisObject;
    }

    private Object filterConstructorResult(Object thisObject, Object result) {
        if (isObject.profile(isObjectNode.executeBoolean(result))) {
            return result;
        }
        // If [[ConstructorKind]] == "base" or result is undefined return this, otherwise throw
        if (getFunctionData().isDerived() && isNotUndefined.profile(result != Undefined.instance)) {
            // TypeError is thrown in caller context
            throw Errors.createTypeError("constructor result not as expected");
        }
        assert thisObject != JSFunction.CONSTRUCT;
        return thisObject;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        if (callNode == null || newObjectNode == null || isObjectNode == null) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            initialize();
        }
        Object[] arguments = frame.getArguments();
        Object thisObject = allocateThisObject(frame, arguments);
        Object result = callNode.call(arguments);
        return filterConstructorResult(thisObject, result);
    }

    private void initialize() {
        this.callNode = insert(Truffle.getRuntime().createDirectCallNode(callTarget));
        this.newObjectNode = insert(SpecializedNewObjectNode.create(functionData, instanceLayout));
        this.isObjectNode = insert(IsObjectNode.create());
    }

    private JSFunctionData getFunctionData() {
        return functionData;
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
    protected JavaScriptRootNode cloneUninitialized() {
        return new ConstructorRootNode(functionData, callTarget, newTarget, instanceLayout);
    }

    @Override
    @TruffleBoundary
    public String toString() {
        String callTargetName = ((RootCallTarget) callTarget).getRootNode().toString();
        return JSConfig.DetailedCallTargetNames ? JSRuntime.stringConcat("[Construct]", callTargetName) : callTargetName;
    }
}
