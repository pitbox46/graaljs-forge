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
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.js.builtins.NumberFunctionBuiltinsFactory.JSNumberIsFiniteNodeGen;
import com.oracle.truffle.js.builtins.NumberFunctionBuiltinsFactory.JSNumberIsIntegerNodeGen;
import com.oracle.truffle.js.builtins.NumberFunctionBuiltinsFactory.JSNumberIsNaNNodeGen;
import com.oracle.truffle.js.builtins.NumberFunctionBuiltinsFactory.JSNumberIsSafeIntegerNodeGen;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSBuiltinNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.builtins.BuiltinEnum;
import com.oracle.truffle.js.runtime.builtins.JSNumber;

/**
 * Contains builtins for {@linkplain JSNumber} function (constructor).
 */
public final class NumberFunctionBuiltins extends JSBuiltinsContainer.SwitchEnum<NumberFunctionBuiltins.NumberFunction> {

    public static final JSBuiltinsContainer BUILTINS = new NumberFunctionBuiltins();

    protected NumberFunctionBuiltins() {
        super(JSNumber.CLASS_NAME, NumberFunction.class);
    }

    public enum NumberFunction implements BuiltinEnum<NumberFunction> {
        isNaN(1),
        isFinite(1),
        isInteger(1),
        isSafeInteger(1);

        private final int length;

        NumberFunction(int length) {
            this.length = length;
        }

        @Override
        public int getLength() {
            return length;
        }

        @Override
        public int getECMAScriptVersion() {
            return 6;
        }
    }

    @Override
    protected Object createNode(JSContext context, JSBuiltin builtin, boolean construct, boolean newTarget, NumberFunction builtinEnum) {
        switch (builtinEnum) {
            case isNaN:
                return JSNumberIsNaNNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
            case isFinite:
                return JSNumberIsFiniteNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
            case isInteger:
                return JSNumberIsIntegerNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
            case isSafeInteger:
                return JSNumberIsSafeIntegerNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
        }
        return null;
    }

    public abstract static class JSNumberIsNaNNode extends JSBuiltinNode {

        public JSNumberIsNaNNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        protected boolean isDouble(Object arg) {
            return arg instanceof Double;
        }

        @Specialization(guards = "!isDouble(arg)")
        protected boolean isNaNNotDouble(@SuppressWarnings("unused") Object arg) {
            return false;
        }

        @Specialization
        protected boolean isNaNDouble(double arg) {
            return Double.isNaN(arg);
        }
    }

    public abstract static class JSNumberIsFiniteNode extends JSBuiltinNode {

        public JSNumberIsFiniteNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization
        protected boolean isFinite(@SuppressWarnings("unused") int arg) {
            return true;
        }

        @Specialization
        protected boolean isFinite(double arg) {
            return Double.isFinite(arg);
        }

        @Specialization(guards = "!isNumber(arg)")
        protected boolean isFinite(@SuppressWarnings("unused") Object arg) {
            return false;
        }
    }

    public abstract static class JSNumberIsIntegerNode extends JSBuiltinNode {

        public JSNumberIsIntegerNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @SuppressWarnings("unused")
        @Specialization
        protected static boolean isInteger(int arg) {
            return true;
        }

        @SuppressWarnings("unused")
        @Specialization
        protected static boolean isInteger(SafeInteger arg) {
            return true;
        }

        @Specialization
        protected static boolean isInteger(double arg) {
            // IsIntegralNumber is defined as:
            // If arg is NaN or +/-Infinity, return false.
            // Return floor(abs(arg)) == abs(arg).

            // floor(abs(arg)) == abs(arg) is equivalent to trunc(arg) == arg;
            // because (Infinity - Infinity) is NaN, IsIntegralNumber can be simplified to:
            // arg - trunc(arg) == 0.
            return arg - JSRuntime.truncateDouble(arg) == 0.0;
        }

        @SuppressWarnings("unused")
        @Specialization(guards = "!isNumber(arg)")
        protected static boolean isInteger(Object arg) {
            return false;
        }
    }

    public abstract static class JSNumberIsSafeIntegerNode extends JSBuiltinNode {

        public JSNumberIsSafeIntegerNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization
        protected boolean isSafeIntegerInt(@SuppressWarnings("unused") int arg) {
            return true;
        }

        @Specialization
        protected boolean isSafeIntegerDouble(double arg) {
            if (Double.isNaN(arg) || !Double.isFinite(arg)) {
                return false;
            }
            long l = (long) arg;
            if (l != arg) {
                return false;
            }
            return JSRuntime.MIN_SAFE_INTEGER <= l && l <= JSRuntime.MAX_SAFE_INTEGER;
        }

        @Specialization(guards = "!isNumber(arg)")
        protected boolean isSafeIntegerNotANumber(@SuppressWarnings("unused") Object arg) {
            return false;
        }
    }
}
