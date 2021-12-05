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
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.object.Property;
import com.oracle.truffle.js.nodes.JavaScriptBaseNode;
import com.oracle.truffle.js.nodes.access.InitErrorObjectNodeFactory.DefineStackPropertyNodeGen;
import com.oracle.truffle.js.nodes.function.CreateMethodPropertyNode;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.GraalJSException;
import com.oracle.truffle.js.runtime.GraalJSException.JSStackTraceElement;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSError;
import com.oracle.truffle.js.runtime.objects.JSAttributes;
import com.oracle.truffle.js.runtime.objects.JSObjectUtil;
import com.oracle.truffle.js.runtime.objects.JSProperty;
import com.oracle.truffle.js.runtime.objects.Undefined;

public final class InitErrorObjectNode extends JavaScriptBaseNode {
    private final JSContext context;
    @Child private PropertySetNode setException;
    @Child private PropertySetNode setFormattedStack;
    @Child private DynamicObjectLibrary setMessage;
    @Child private DynamicObjectLibrary setErrors;
    @Child private DefineStackPropertyNode defineStackProperty;
    private final boolean defaultColumnNumber;
    @Child private CreateMethodPropertyNode setLineNumber;
    @Child private CreateMethodPropertyNode setColumnNumber;
    @Child private InstallErrorCauseNode installErrorCauseNode;

    private InitErrorObjectNode(JSContext context, boolean defaultColumnNumber) {
        this.context = context;
        this.setException = PropertySetNode.createSetHidden(JSError.EXCEPTION_PROPERTY_NAME, context);
        this.setFormattedStack = PropertySetNode.createSetHidden(JSError.FORMATTED_STACK_NAME, context);
        this.setMessage = JSObjectUtil.createDispatched(JSError.MESSAGE);
        this.defineStackProperty = DefineStackPropertyNode.create();
        this.defaultColumnNumber = defaultColumnNumber;
        if (context.isOptionNashornCompatibilityMode()) {
            this.setLineNumber = CreateMethodPropertyNode.create(context, JSError.LINE_NUMBER_PROPERTY_NAME);
            this.setColumnNumber = CreateMethodPropertyNode.create(context, JSError.COLUMN_NUMBER_PROPERTY_NAME);
        }
    }

    public static InitErrorObjectNode create(JSContext context) {
        return new InitErrorObjectNode(context, false);
    }

    public static InitErrorObjectNode create(JSContext context, boolean defaultColumnNumber) {
        return new InitErrorObjectNode(context, defaultColumnNumber);
    }

    public DynamicObject execute(DynamicObject errorObj, GraalJSException exception, String messageOpt) {
        return execute(errorObj, exception, messageOpt, null);
    }

    public DynamicObject execute(DynamicObject errorObj, GraalJSException exception, String messageOpt, DynamicObject errorsOpt) {
        return execute(errorObj, exception, messageOpt, errorsOpt, Undefined.instance);
    }

    public DynamicObject execute(DynamicObject errorObj, GraalJSException exception, String messageOpt, DynamicObject errorsOpt, Object options) {
        if (messageOpt != null) {
            setMessage.putWithFlags(errorObj, JSError.MESSAGE, messageOpt, JSError.MESSAGE_ATTRIBUTES);
        }
        if (errorsOpt != null) {
            setErrorsNode().putWithFlags(errorObj, JSError.ERRORS_NAME, errorsOpt, JSError.ERRORS_ATTRIBUTES);
        }
        if (context.getContextOptions().isErrorCauseEnabled() && options != Undefined.instance) {
            installErrorCause(errorObj, options);
        }

        setException.setValue(errorObj, exception);
        // stack is not formatted until it is accessed
        setFormattedStack.setValue(errorObj, null);
        defineStackProperty.execute(errorObj);

        if (setLineNumber != null && exception.getJSStackTrace().length > 0) {
            JSStackTraceElement topStackTraceElement = exception.getJSStackTrace()[0];
            setLineNumber.executeVoid(errorObj, topStackTraceElement.getLineNumber());
            setColumnNumber.executeVoid(errorObj, defaultColumnNumber ? JSError.DEFAULT_COLUMN_NUMBER : topStackTraceElement.getColumnNumber());
        }
        return errorObj;
    }

    private void installErrorCause(DynamicObject errorObj, Object options) {
        if (installErrorCauseNode == null) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            installErrorCauseNode = insert(new InstallErrorCauseNode(context));
        }
        installErrorCauseNode.executeVoid(errorObj, options);
    }

    private DynamicObjectLibrary setErrorsNode() {
        DynamicObjectLibrary errorsLib = setErrors;
        if (errorsLib == null) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            setErrors = errorsLib = insert(JSObjectUtil.createDispatched(JSError.ERRORS_NAME));
        }
        return errorsLib;
    }

    public abstract static class DefineStackPropertyNode extends JavaScriptBaseNode {
        static DefineStackPropertyNode create() {
            return DefineStackPropertyNodeGen.create();
        }

        abstract void execute(DynamicObject errorObj);

        @Specialization(limit = "3")
        void doCached(DynamicObject errorObj,
                        @CachedLibrary("errorObj") DynamicObjectLibrary objectLibrary) {
            Property stackProperty = objectLibrary.getProperty(errorObj, JSError.STACK_NAME);
            int attrs = JSAttributes.getDefaultNotEnumerable();
            if (stackProperty != null) {
                if (!JSProperty.isConfigurable(stackProperty)) {
                    throw Errors.createTypeErrorCannotRedefineProperty(JSError.STACK_NAME);
                }
                if (JSProperty.isEnumerable(stackProperty)) {
                    attrs = JSAttributes.getDefault();
                }
            }
            objectLibrary.putConstant(errorObj, JSError.STACK_NAME, JSError.STACK_PROXY, attrs | JSProperty.PROXY);
        }
    }
}
