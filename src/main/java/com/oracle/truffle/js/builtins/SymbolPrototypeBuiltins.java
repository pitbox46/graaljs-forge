/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.builtins.SymbolPrototypeBuiltinsFactory.SymbolToPrimitiveNodeGen;
import com.oracle.truffle.js.builtins.SymbolPrototypeBuiltinsFactory.SymbolToStringNodeGen;
import com.oracle.truffle.js.builtins.SymbolPrototypeBuiltinsFactory.SymbolValueOfNodeGen;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSBuiltinNode;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.builtins.BuiltinEnum;
import com.oracle.truffle.js.runtime.builtins.JSSymbol;

/**
 * Contains builtins for Symbol.prototype.
 */
public final class SymbolPrototypeBuiltins extends JSBuiltinsContainer.SwitchEnum<SymbolPrototypeBuiltins.SymbolPrototype> {

    public static final JSBuiltinsContainer BUILTINS = new SymbolPrototypeBuiltins();

    protected SymbolPrototypeBuiltins() {
        super(JSSymbol.PROTOTYPE_NAME, SymbolPrototype.class);
    }

    public enum SymbolPrototype implements BuiltinEnum<SymbolPrototype> {
        toString(0),
        valueOf(0),

        _toPrimitive(1) {
            @Override
            public Object getKey() {
                return Symbol.SYMBOL_TO_PRIMITIVE;
            }

            @Override
            public boolean isWritable() {
                return false;
            }
        };

        private final int length;

        SymbolPrototype(int length) {
            this.length = length;
        }

        @Override
        public int getLength() {
            return length;
        }
    }

    @Override
    protected Object createNode(JSContext context, JSBuiltin builtin, boolean construct, boolean newTarget, SymbolPrototype builtinEnum) {
        switch (builtinEnum) {
            case toString:
                return SymbolToStringNodeGen.create(context, builtin, args().withThis().createArgumentNodes(context));
            case valueOf:
                return SymbolValueOfNodeGen.create(context, builtin, args().withThis().createArgumentNodes(context));
            case _toPrimitive:
                return SymbolToPrimitiveNodeGen.create(context, builtin, args().withThis().createArgumentNodes(context));
        }
        return null;
    }

    public abstract static class SymbolToStringNode extends JSBuiltinNode {
        public SymbolToStringNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        private final ConditionProfile isSymbolObjectProfile = ConditionProfile.createBinaryProfile();
        private final ConditionProfile isPrimitiveSymbolProfile = ConditionProfile.createBinaryProfile();

        @Specialization
        protected String toString(Object thisObj) {
            if (isSymbolObjectProfile.profile(JSSymbol.isJSSymbol(thisObj))) {
                return JSSymbol.getSymbolData((DynamicObject) thisObj).toString();
            } else if (isPrimitiveSymbolProfile.profile(thisObj instanceof Symbol)) {
                return ((Symbol) thisObj).toString();
            } else {
                throw Errors.createTypeErrorIncompatibleReceiver(thisObj);
            }
        }
    }

    public abstract static class SymbolValueOfNode extends JSBuiltinNode {
        public SymbolValueOfNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        private final ConditionProfile isSymbolObjectProfile = ConditionProfile.createBinaryProfile();
        private final ConditionProfile isPrimitiveSymbolProfile = ConditionProfile.createBinaryProfile();

        @Specialization
        protected Symbol valueOf(Object thisObj) {
            if (isSymbolObjectProfile.profile(JSSymbol.isJSSymbol(thisObj))) {
                return JSSymbol.getSymbolData((DynamicObject) thisObj);
            } else if (isPrimitiveSymbolProfile.profile(thisObj instanceof Symbol)) {
                return (Symbol) thisObj;
            } else {
                throw Errors.createTypeErrorIncompatibleReceiver(thisObj);
            }
        }
    }

    public abstract static class SymbolToPrimitiveNode extends JSBuiltinNode {
        private final ConditionProfile isSymbolProfile = ConditionProfile.createBinaryProfile();
        private final ConditionProfile isSymbolObjectProfile = ConditionProfile.createBinaryProfile();

        public SymbolToPrimitiveNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization
        protected Symbol toPrimitive(Object thisObj) {
            if (isSymbolProfile.profile(thisObj instanceof Symbol)) {
                return (Symbol) thisObj;
            } else if (isSymbolObjectProfile.profile(JSSymbol.isJSSymbol(thisObj))) {
                return JSSymbol.getSymbolData((DynamicObject) thisObj);
            } else {
                throw Errors.createTypeErrorIncompatibleReceiver(thisObj);
            }
        }
    }
}
