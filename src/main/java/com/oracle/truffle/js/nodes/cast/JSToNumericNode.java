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
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.js.nodes.JavaScriptBaseNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.JSConstantNode;
import com.oracle.truffle.js.nodes.cast.JSToNumericNodeGen.JSToNumericWrapperNodeGen;
import com.oracle.truffle.js.nodes.unary.JSUnaryNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;

import java.util.Set;

import static com.oracle.truffle.js.builtins.OperatorsBuiltins.checkOverloadedOperatorsAllowed;

public abstract class JSToNumericNode extends JavaScriptBaseNode {

    @Child private JSToNumberNode toNumberNode;
    @Child private JSToPrimitiveNode toPrimitiveNode;

    /**
     * Whether this node implements the ToNumeric spec functions or the ToNumericOperand spec
     * function from the operator overloading proposal. The latter is identical except for the case
     * when the argument is an object with overloaded operators. In that case, it is not coerced to
     * a numeric type, but checked for whether its operators are enabled.
     */
    private final boolean toNumericOperand;

    public abstract Object execute(Object value);

    protected JSToNumericNode(boolean toNumericOperand) {
        super();
        this.toNumericOperand = toNumericOperand;
    }

    public static JSToNumericNode create(boolean toNumericOperand) {
        return JSToNumericNodeGen.create(toNumericOperand);
    }

    public static JSToNumericNode create() {
        return create(false);
    }

    public static JSToNumericNode createToNumericOperand() {
        return create(true);
    }

    public static JavaScriptNode create(JavaScriptNode child, boolean toNumericOperand) {
        if (child.isResultAlwaysOfType(Number.class) || child.isResultAlwaysOfType(int.class) || child.isResultAlwaysOfType(double.class)) {
            return child;
        }
        if (child instanceof JSConstantNode) {
            Object constantOperand = ((JSConstantNode) child).getValue();
            if (constantOperand != null && !(constantOperand instanceof Symbol) && JSRuntime.isJSPrimitive(constantOperand)) {
                return JSConstantNode.create(JSRuntime.toNumeric(constantOperand));
            }
        }
        return JSToNumericWrapperNodeGen.create(child, toNumericOperand);
    }

    public static JavaScriptNode create(JavaScriptNode child) {
        return create(child, false);
    }

    public static JavaScriptNode createToNumericOperand(JavaScriptNode child) {
        return create(child, true);
    }

    @Specialization
    protected static int doInt(int value) {
        return value;
    }

    @Specialization
    protected static double doDouble(double value) {
        return value;
    }

    @Specialization
    protected Object doBigInt(BigInt value) {
        return value;
    }

    @Specialization(guards = "isJSBigInt(value)")
    protected Object doJSBigInt(Object value) {
        return toPrimitive(value);
    }

    @Specialization(guards = {"isToNumericOperand()"})
    protected Object doOverloaded(JSOverloadedOperatorsObject arg) {
        checkOverloadedOperatorsAllowed(arg, this);
        return arg;
    }

    @Specialization(guards = {"isToNumericOperand()", "!isJSBigInt(value)", "!hasOverloadedOperators(value)"})
    protected Object doToNumericOperandOther(Object value) {
        Object primValue = toPrimitive(value);
        if (JSRuntime.isBigInt(primValue)) {
            return primValue;
        }
        return toNumber(primValue);
    }

    @Specialization(guards = {"!isToNumericOperand()", "!isJSBigInt(value)"})
    protected Object doToNumericOther(Object value) {
        Object primValue = toPrimitive(value);
        if (JSRuntime.isBigInt(primValue)) {
            return primValue;
        }
        return toNumber(primValue);
    }

    private Number toNumber(Object value) {
        if (toNumberNode == null) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            toNumberNode = insert(JSToNumberNode.create());
        }
        return toNumberNode.executeNumber(value);
    }

    private Object toPrimitive(Object value) {
        if (toPrimitiveNode == null) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            toPrimitiveNode = insert(JSToPrimitiveNode.createHintNumber());
        }
        return toPrimitiveNode.execute(value);
    }

    protected boolean isToNumericOperand() {
        return toNumericOperand;
    }

    public abstract static class JSToNumericWrapperNode extends JSUnaryNode {

        @Child private JSToNumericNode toNumericNode;

        private final boolean toNumericOperand;

        protected JSToNumericWrapperNode(JavaScriptNode operand, boolean toNumericOperand) {
            super(operand);
            this.toNumericOperand = toNumericOperand;
        }

        @Specialization
        protected Object doDefault(Object value) {
            if (toNumericNode == null) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                toNumericNode = insert(JSToNumericNode.create(toNumericOperand));
            }
            return toNumericNode.execute(value);
        }

        @Override
        protected JavaScriptNode copyUninitialized(Set<Class<? extends Tag>> materializedTags) {
            return create(cloneUninitialized(getOperand(), materializedTags), toNumericOperand);
        }

        @Override
        public String expressionToString() {
            return getOperand().expressionToString();
        }
    }
}
