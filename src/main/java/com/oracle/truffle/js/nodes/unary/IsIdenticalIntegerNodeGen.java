// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;

@GeneratedBy(IsIdenticalIntegerNode.class)
public final class IsIdenticalIntegerNodeGen extends IsIdenticalIntegerNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private IsIdenticalIntegerNodeGen(JavaScriptNode operand, int integer, boolean leftConstant) {
        super(operand, integer, leftConstant);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doInt(operandNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return doBigInt(operandNodeValue_);
        }
        if ((state_0 & 0b11000) != 0 /* is-state_0 doJavaNumber(Object) || doOther(Object) */) {
            if ((state_0 & 0b1000) != 0 /* is-state_0 doJavaNumber(Object) */) {
                if ((JSGuards.isJavaNumber(operandNodeValue))) {
                    return doJavaNumber(operandNodeValue);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doOther(Object) */) {
                if (fallbackGuard_(state_0, operandNodeValue)) {
                    return doOther(operandNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11110) == 0 /* only-active doInt(int) */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) && doOther(Object) */)) {
            return execute_int0(state_0, frameValue);
        } else if ((state_0 & 0b11101) == 0 /* only-active doDouble(double) */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) && doOther(Object) */)) {
            return execute_double1(state_0, frameValue);
        } else {
            return execute_generic2(state_0, frameValue);
        }
    }

    private Object execute_int0(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doInt(int) */;
        return doInt(operandNodeValue_);
    }

    private Object execute_double1(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0b111000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) && doOther(Object) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0b110100000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) && doOther(Object) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0b101100000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) && doOther(Object) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b10) != 0 /* is-state_0 doDouble(double) */;
        return doDouble(operandNodeValue_);
    }

    private Object execute_generic2(int state_0, VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            return doInt(operandNodeValue__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return doBigInt(operandNodeValue__);
        }
        if ((state_0 & 0b11000) != 0 /* is-state_0 doJavaNumber(Object) || doOther(Object) */) {
            if ((state_0 & 0b1000) != 0 /* is-state_0 doJavaNumber(Object) */) {
                if ((JSGuards.isJavaNumber(operandNodeValue_))) {
                    return doJavaNumber(operandNodeValue_);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doOther(Object) */) {
                if (fallbackGuard_(state_0, operandNodeValue_)) {
                    return doOther(operandNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11110) == 0 /* only-active doInt(int) */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) && doOther(Object) */)) {
            return executeBoolean_int3(state_0, frameValue);
        } else if ((state_0 & 0b11101) == 0 /* only-active doDouble(double) */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) && doOther(Object) */)) {
            return executeBoolean_double4(state_0, frameValue);
        } else {
            return executeBoolean_generic5(state_0, frameValue);
        }
    }

    private boolean executeBoolean_int3(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doInt(int) */;
        return doInt(operandNodeValue_);
    }

    private boolean executeBoolean_double4(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0b111000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) && doOther(Object) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0b110100000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) && doOther(Object) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0b101100000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) && doOther(Object) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b10) != 0 /* is-state_0 doDouble(double) */;
        return doDouble(operandNodeValue_);
    }

    private boolean executeBoolean_generic5(int state_0, VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            return doInt(operandNodeValue__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return doBigInt(operandNodeValue__);
        }
        if ((state_0 & 0b11000) != 0 /* is-state_0 doJavaNumber(Object) || doOther(Object) */) {
            if ((state_0 & 0b1000) != 0 /* is-state_0 doJavaNumber(Object) */) {
                if ((JSGuards.isJavaNumber(operandNodeValue_))) {
                    return doJavaNumber(operandNodeValue_);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doOther(Object) */) {
                if (fallbackGuard_(state_0, operandNodeValue_)) {
                    return doOther(operandNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    private boolean executeAndSpecialize(Object operandNodeValue) {
        int state_0 = this.state_0_;
        if (operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt(int) */;
            return doInt(operandNodeValue_);
        }
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                state_0 = (state_0 | (doubleCast0 << 5) /* set-implicit-state_0 0:double */);
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDouble(double) */;
                return doDouble(operandNodeValue_);
            }
        }
        if (operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doBigInt(BigInt) */;
            return doBigInt(operandNodeValue_);
        }
        if ((JSGuards.isJavaNumber(operandNodeValue))) {
            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doJavaNumber(Object) */;
            return doJavaNumber(operandNodeValue);
        }
        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doOther(Object) */;
        return doOther(operandNodeValue);
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b11111) & ((state_0 & 0b11111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[6];
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
        s[0] = "doJavaNumber";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doJavaNumber(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state_0, Object operandNodeValue) {
        if (JSTypesGen.isImplicitDouble(operandNodeValue)) {
            return false;
        }
        if (((state_0 & 0b100)) == 0 /* is-not-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            return false;
        }
        if (((state_0 & 0b1000)) == 0 /* is-not-state_0 doJavaNumber(Object) */ && (JSGuards.isJavaNumber(operandNodeValue))) {
            return false;
        }
        return true;
    }

    public static IsIdenticalIntegerNode create(JavaScriptNode operand, int integer, boolean leftConstant) {
        return new IsIdenticalIntegerNodeGen(operand, integer, leftConstant);
    }

}
