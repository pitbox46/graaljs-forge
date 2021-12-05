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
package com.oracle.truffle.js.nodes.binary;

import java.util.Objects;
import java.util.Set;

import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.instrumentation.InstrumentableNode;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.JSConstantNode;
import com.oracle.truffle.js.nodes.access.JSConstantNode.JSConstantIntegerNode;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.nodes.cast.JSToUInt32Node;
import com.oracle.truffle.js.nodes.cast.JSToUInt32Node.JSToUInt32WrapperNode;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.BinaryOperationTag;
import com.oracle.truffle.js.nodes.unary.JSUnaryNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;

/**
 * 11.7.3 The Unsigned Right Shift Operator (>>>).
 */
@NodeInfo(shortName = ">>>")
public abstract class JSUnsignedRightShiftConstantNode extends JSUnaryNode {

    protected final int shiftValue;
    protected final int rightValue;

    protected JSUnsignedRightShiftConstantNode(JavaScriptNode operand, int shiftValue, int rightValue) {
        super(operand);
        assert shiftValue > 0;
        this.shiftValue = shiftValue;
        this.rightValue = rightValue;
    }

    public abstract int executeInt(Object a);

    public static JavaScriptNode create(JavaScriptNode left, JavaScriptNode right) {
        assert right instanceof JSConstantIntegerNode;
        int rightValue = ((JSConstantIntegerNode) right).executeInt(null);
        int shiftValue = rightValue & 0x1F;
        if (shiftValue == 0) {
            return JSToUInt32WrapperNode.create(left, true, rightValue);
        }
        if (left instanceof JSConstantIntegerNode) {
            int leftValue = ((JSConstantIntegerNode) left).executeInt(null);
            return JSConstantNode.createInt(leftValue >>> shiftValue);
        }
        return JSUnsignedRightShiftConstantNodeGen.create(left, shiftValue, rightValue);
    }

    @Override
    public boolean hasTag(Class<? extends Tag> tag) {
        if (tag == BinaryOperationTag.class) {
            return true;
        } else {
            return super.hasTag(tag);
        }
    }

    @Override
    public InstrumentableNode materializeInstrumentableNodes(Set<Class<? extends Tag>> materializedTags) {
        if (materializedTags.contains(BinaryOperationTag.class)) {
            // need to call the generated factory directly to avoid constant optimizations
            JSConstantNode constantNode = JSConstantNode.createInt(rightValue);
            JavaScriptNode node = JSUnsignedRightShiftNodeGen.create(cloneUninitialized(getOperand(), materializedTags), constantNode);
            transferSourceSectionAddExpressionTag(this, constantNode);
            transferSourceSectionAndTags(this, node);
            return node;
        } else {
            return this;
        }
    }

    @Specialization
    protected int doInteger(int a) {
        return a >>> shiftValue;
    }

    @Specialization
    protected int doSafeInteger(SafeInteger a) {
        return a.intValue() >>> shiftValue;
    }

    @Specialization
    protected int doDouble(double a,
                    @Cached("create()") JSToUInt32Node toUInt32Node) {
        assert shiftValue > 0;
        return (int) (toUInt32Node.executeLong(a) >>> shiftValue);
    }

    @Specialization
    protected int doBigInt(@SuppressWarnings("unused") BigInt a) {
        throw Errors.createTypeErrorCannotMixBigIntWithOtherTypes(this);
    }

    @Specialization
    protected Object doOverloaded(JSOverloadedOperatorsObject a,
                    @Cached("createNumeric(getOverloadedOperatorName())") JSOverloadedBinaryNode overloadedOperatorNode) {
        return overloadedOperatorNode.execute(a, rightValue);
    }

    protected String getOverloadedOperatorName() {
        return ">>>";
    }

    @Specialization(guards = {"!hasOverloadedOperators(lval)", "!isHandled(lval)"})
    protected int doGeneric(Object lval,
                    @Cached("create()") JSToNumericNode leftToNumeric,
                    @Cached("createInner()") JSUnsignedRightShiftConstantNode innerShiftNode) {
        Object leftOperand = leftToNumeric.execute(lval);
        return innerShiftNode.executeInt(leftOperand);
    }

    protected static boolean isHandled(Object lval) {
        return lval instanceof Integer || lval instanceof Double || lval instanceof SafeInteger || lval instanceof BigInt;
    }

    protected JSUnsignedRightShiftConstantNode createInner() {
        return JSUnsignedRightShiftConstantNodeGen.create(null, shiftValue, rightValue);
    }

    @Override
    protected JavaScriptNode copyUninitialized(Set<Class<? extends Tag>> materializedTags) {
        return JSUnsignedRightShiftConstantNodeGen.create(cloneUninitialized(getOperand(), materializedTags), shiftValue, rightValue);
    }

    @Override
    public String expressionToString() {
        if (getOperand() != null) {
            return "(" + Objects.toString(getOperand().expressionToString(), INTERMEDIATE_VALUE) + " >>> " + rightValue + ")";
        }
        return null;
    }
}
