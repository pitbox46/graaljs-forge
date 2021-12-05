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
package com.oracle.truffle.js.nodes;

import com.oracle.truffle.api.dsl.ImplicitCast;
import com.oracle.truffle.api.dsl.TypeCast;
import com.oracle.truffle.api.dsl.TypeCheck;
import com.oracle.truffle.api.dsl.TypeSystem;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.objects.JSDynamicObject;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import com.oracle.truffle.js.runtime.objects.JSLazyStringFlattened;
import com.oracle.truffle.js.runtime.objects.JSLazyStringRaw;

/**
 * @see JavaScriptNode
 */
@TypeSystem({boolean.class, int.class, double.class, long.class, SafeInteger.class, BigInt.class, String.class})
public class JSTypes {

    protected JSTypes() {
        // should not be constructed
    }

    @ImplicitCast
    public static double intToDouble(int value) {
        return value;
    }

    @ImplicitCast
    public static double safeIntegerToDouble(SafeInteger value) {
        return value.doubleValue();
    }

    @ImplicitCast
    public static double longToDouble(long value) {
        return value;
    }

    @TypeCheck(CharSequence.class)
    public static boolean isCharSequence(Object value) {
        return JSRuntime.isString(value);
    }

    @TypeCheck(DynamicObject.class)
    public static boolean isDynamicObject(Object value) {
        return JSDynamicObject.isJSDynamicObject(value);
    }

    @TypeCheck(JSLazyStringFlattened.class)
    public static boolean isLazyStringFlattened(Object object) {
        return object instanceof JSLazyString && ((JSLazyString) object).isFlat();
    }

    @TypeCast(JSLazyStringFlattened.class)
    public static JSLazyStringFlattened asLazyStringFlattened(Object object) {
        return (JSLazyString) object;
    }

    @TypeCheck(JSLazyStringRaw.class)
    public static boolean isLazyStringRaw(Object object) {
        return object instanceof JSLazyString && !((JSLazyString) object).isFlat();
    }

    @TypeCast(JSLazyStringRaw.class)
    public static JSLazyStringRaw asLazyStringRaw(Object object) {
        return (JSLazyString) object;
    }

    @ImplicitCast
    public static String convertLazyStringFlattened(JSLazyStringFlattened value) {
        return ((JSLazyString) value).getFlattenedString(); // avoid to have flatten() in the code
    }

    @ImplicitCast
    public static String convertLazyStringRaw(JSLazyStringRaw value) {
        return ((JSLazyString) value).toString();
    }

    @ImplicitCast
    public static CharSequence castCharSequence(String value) {
        return value;
    }

    @ImplicitCast
    public static CharSequence castCharSequence(JSLazyString value) {
        return value;
    }
}
