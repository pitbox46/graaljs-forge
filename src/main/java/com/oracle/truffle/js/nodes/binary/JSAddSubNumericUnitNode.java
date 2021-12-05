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

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.Truncatable;
import com.oracle.truffle.js.nodes.instrumentation.JSTags;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.UnaryOperationTag;
import com.oracle.truffle.js.nodes.unary.JSOverloadedUnaryNode;
import com.oracle.truffle.js.nodes.unary.JSUnaryNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;

import java.util.Set;

public abstract class JSAddSubNumericUnitNode extends JSUnaryNode implements Truncatable {

    private final boolean isAddition;
    @CompilationFinal boolean truncate;

    protected JSAddSubNumericUnitNode(JavaScriptNode operand, boolean isAddition, boolean truncate) {
        super(operand);
        this.isAddition = isAddition;
        this.truncate = truncate;
    }

    @Override
    public boolean hasTag(Class<? extends Tag> tag) {
        if (tag == UnaryOperationTag.class) {
            return true;
        } else {
            return super.hasTag(tag);
        }
    }

    @Override
    public Object getNodeObject() {
        return JSTags.createNodeObjectDescriptor("operator", isAddition ? "++" : "--");
    }

    public abstract Object execute(Object a);

    @Specialization(rewriteOn = ArithmeticException.class)
    protected int doInt(int a) {
        if (truncate) {
            return isAddition ? a + 1 : a - 1;
        } else {
            return isAddition ? Math.addExact(a, 1) : Math.subtractExact(a, 1);
        }
    }

    @Specialization(replaces = "doInt")
    protected double doDouble(double a) {
        return isAddition ? a + 1 : a - 1;
    }

    @Specialization
    protected BigInt doBigInt(BigInt a) {
        return isAddition ? a.add(BigInt.ONE) : a.subtract(BigInt.ONE);
    }

    // long etc could come via Interop
    @Specialization(guards = "isJavaNumber(a)")
    protected double doJavaNumber(Object a) {
        double doubleValue = JSRuntime.toDouble(a);
        return isAddition ? doubleValue + 1 : doubleValue - 1;
    }

    @Specialization
    protected Object doOverloaded(JSOverloadedOperatorsObject a,
                    @Cached("create(getOverloadedOperatorName())") JSOverloadedUnaryNode overloadedOperatorNode) {
        return overloadedOperatorNode.execute(a);
    }

    protected String getOverloadedOperatorName() {
        return isAddition ? "++" : "--";
    }

    @Override
    public void setTruncate() {
        CompilerAsserts.neverPartOfCompilation();
        if (truncate == false) {
            truncate = true;
        }
    }

    public static JSAddSubNumericUnitNode create(JavaScriptNode operand, boolean isAddition, boolean truncate) {
        return JSAddSubNumericUnitNodeGen.create(operand, isAddition, truncate);
    }

    @Override
    protected JavaScriptNode copyUninitialized(Set<Class<? extends Tag>> materializedTags) {
        return create(cloneUninitialized(getOperand(), materializedTags), isAddition, truncate);
    }
}
