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
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.GenerateUncached;
import com.oracle.truffle.api.dsl.ImportStatic;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.StopIterationException;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.cast.JSToBooleanNode;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.JSArguments;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.objects.IteratorRecord;
import com.oracle.truffle.js.runtime.objects.JSObject;
import com.oracle.truffle.js.runtime.objects.Undefined;

@ImportStatic({JSConfig.class, JSRuntime.class})
@GenerateUncached
public abstract class JSInteropGetIteratorNextNode extends JSInteropCallNode {
    JSInteropGetIteratorNextNode() {
    }

    public static JSInteropGetIteratorNextNode create() {
        return JSInteropGetIteratorNextNodeGen.create();
    }

    public final Object getIteratorNextElement(IteratorRecord receiver, JavaScriptLanguage language, Object stopValue) {
        try {
            return execute(receiver, language, stopValue);
        } catch (StopIterationException e) {
            throw Errors.shouldNotReachHere(e);
        }
    }

    public final Object getIteratorNextElement(IteratorRecord iterator, JavaScriptLanguage language) throws StopIterationException {
        return execute(iterator, language, null);
    }

    protected abstract Object execute(IteratorRecord iterator, JavaScriptLanguage language, Object stopValue) throws StopIterationException;

    @Specialization
    Object doDefault(IteratorRecord iterator, @SuppressWarnings("unused") JavaScriptLanguage language, Object stopValue,
                    @Cached(value = "createCall()", uncached = "getUncachedCall()") JSFunctionCallNode callNode,
                    @Cached(value = "create(DONE, language.getJSContext())", uncached = "getUncachedProperty()") PropertyGetNode donePropertyGetNode,
                    @Cached(value = "create(VALUE, language.getJSContext())", uncached = "getUncachedProperty()") PropertyGetNode valuePropertyGetNode,
                    @Cached JSToBooleanNode toBooleanNode,
                    @Cached ExportValueNode exportValueNode,
                    @Cached BranchProfile exceptionBranch) throws StopIterationException {
        Object iterResult = callNode.executeCall(JSArguments.createZeroArg(iterator.getIterator(), iterator.getNextMethod()));
        if (iterResult instanceof JSObject) {
            JSObject iterResultObject = (JSObject) iterResult;
            Object doneValue = getProperty(iterResultObject, donePropertyGetNode, JSRuntime.DONE, Boolean.FALSE);
            boolean done = toBooleanNode.executeBoolean(doneValue);
            if (done) {
                if (stopValue != null) {
                    return stopValue;
                } else {
                    throw StopIterationException.create();
                }
            } else {
                Object value = getProperty(iterResultObject, valuePropertyGetNode, JSRuntime.VALUE, Undefined.instance);
                return exportValueNode.execute(value);
            }
        }
        exceptionBranch.enter();
        throw Errors.createTypeErrorIteratorResultNotObject(iterResult, null);
    }

}
