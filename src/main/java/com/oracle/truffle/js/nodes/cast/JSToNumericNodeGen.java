// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;

@GeneratedBy(JSToNumericNode.class)
public final class JSToNumericNodeGen extends JSToNumericNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private JSToNumericNodeGen(boolean toNumericOperand) {
        super(toNumericOperand);
    }

    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return JSToNumericNode.doInt(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000) >>> 7 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000) >>> 7 /* extract-implicit-state_0 0:double */, arg0Value);
            return JSToNumericNode.doDouble(arg0Value_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doJSBigInt(Object) */) {
            if ((JSGuards.isJSBigInt(arg0Value))) {
                return doJSBigInt(arg0Value);
            }
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject) */ && arg0Value instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject arg0Value_ = (JSOverloadedOperatorsObject) arg0Value;
            assert (isToNumericOperand());
            return doOverloaded(arg0Value_);
        }
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doToNumericOperandOther(Object) || doToNumericOther(Object) */) {
            if ((state_0 & 0b100000) != 0 /* is-state_0 doToNumericOperandOther(Object) */) {
                assert (isToNumericOperand());
                if ((!(JSGuards.isJSBigInt(arg0Value))) && (!(JSGuards.hasOverloadedOperators(arg0Value)))) {
                    return doToNumericOperandOther(arg0Value);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doToNumericOther(Object) */) {
                assert (!(isToNumericOperand()));
                if ((!(JSGuards.isJSBigInt(arg0Value)))) {
                    return doToNumericOther(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object arg0Value) {
        int state_0 = this.state_0_;
        if (arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt(int) */;
            return JSToNumericNode.doInt(arg0Value_);
        }
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                state_0 = (state_0 | (doubleCast0 << 7) /* set-implicit-state_0 0:double */);
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDouble(double) */;
                return JSToNumericNode.doDouble(arg0Value_);
            }
        }
        if (arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doBigInt(BigInt) */;
            return doBigInt(arg0Value_);
        }
        if ((JSGuards.isJSBigInt(arg0Value))) {
            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doJSBigInt(Object) */;
            return doJSBigInt(arg0Value);
        }
        if (arg0Value instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject arg0Value_ = (JSOverloadedOperatorsObject) arg0Value;
            if ((isToNumericOperand())) {
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doOverloaded(JSOverloadedOperatorsObject) */;
                return doOverloaded(arg0Value_);
            }
        }
        if ((isToNumericOperand()) && (!(JSGuards.isJSBigInt(arg0Value))) && (!(JSGuards.hasOverloadedOperators(arg0Value)))) {
            this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doToNumericOperandOther(Object) */;
            return doToNumericOperandOther(arg0Value);
        }
        if ((!(isToNumericOperand())) && (!(JSGuards.isJSBigInt(arg0Value)))) {
            this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doToNumericOther(Object) */;
            return doToNumericOther(arg0Value);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111111) & ((state_0 & 0b1111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[8];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b100) != 0 /* is-state_0 doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doJSBigInt";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doJSBigInt(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doOverloaded";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doToNumericOperandOther";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doToNumericOperandOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doToNumericOther";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doToNumericOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static JSToNumericNode create(boolean toNumericOperand) {
        return new JSToNumericNodeGen(toNumericOperand);
    }

    @GeneratedBy(JSToNumericWrapperNode.class)
    public static final class JSToNumericWrapperNodeGen extends JSToNumericWrapperNode implements Introspection.Provider {

        private JSToNumericWrapperNodeGen(JavaScriptNode operand, boolean toNumericOperand) {
            super(operand, toNumericOperand);
        }

        @Override
        public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
            return doDefault(operandNodeValue);
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object operandNodeValue_ = super.operandNode.execute(frameValue);
            return doDefault(operandNodeValue_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "doDefault";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSToNumericWrapperNode create(JavaScriptNode operand, boolean toNumericOperand) {
            return new JSToNumericWrapperNodeGen(operand, toNumericOperand);
        }

    }
}
