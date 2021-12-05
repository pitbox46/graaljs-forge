// CheckStyle: start generated
package com.oracle.truffle.js.nodes.binary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToInt32Node;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.nodes.cast.JSToUInt32Node;
import com.oracle.truffle.js.runtime.BigInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSRightShiftNode.class)
public final class JSRightShiftNodeGen extends JSRightShiftNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSLeftShiftNode bigInt_leftShift_;
    @Child private DoubleData double_cache;
    @Child private JSOverloadedBinaryNode overloaded_overloadedOperatorNode_;
    @Child private GenericData generic_cache;

    private JSRightShiftNodeGen(JavaScriptNode left, JavaScriptNode right) {
        super(left, right);
    }

    @Override
    public Object execute(Object leftNodeValue, Object rightNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int, int) */ && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if (rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return doInteger(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doBigInt(BigInt, BigInt, JSLeftShiftNode) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doBigInt(leftNodeValue_, rightNodeValue_, this.bigInt_leftShift_);
            }
        }
        if ((state_0 & 0b1100) != 0 /* is-state_0 doIntDouble(int, double) || doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rightNodeValue)) {
            double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rightNodeValue);
            if ((state_0 & 0b100) != 0 /* is-state_0 doIntDouble(int, double) */ && leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                if ((!(JSBinaryNode.largerThan2e32(rightNodeValue_)))) {
                    return doIntDouble(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue)) {
                double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue);
                DoubleData s3_ = this.double_cache;
                if (s3_ != null) {
                    return doDouble(leftNodeValue_, rightNodeValue_, s3_.rightShift_, s3_.leftInt32_, s3_.rightUInt32_);
                }
            }
        }
        if ((state_0 & 0b110000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            if ((state_0 & 0b10000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
                if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                    return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                GenericData s5_ = this.generic_cache;
                if (s5_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(leftNodeValue))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue)))) {
                        return doGeneric(leftNodeValue, rightNodeValue, s5_.rightShift_, s5_.leftToNumeric_, s5_.rightToNumeric_, s5_.mixedNumericTypes_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue, rightNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111110) == 0 /* only-active doInteger(int, int) */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
            return execute_int_int0(state_0, frameValue);
        } else if ((state_0 & 0b111011) == 0 /* only-active doIntDouble(int, double) */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
            return execute_int_double1(state_0, frameValue);
        } else if ((state_0 & 0b110111) == 0 /* only-active doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
            return execute_double_double2(state_0, frameValue);
        } else {
            return execute_generic3(state_0, frameValue);
        }
    }

    private Object execute_int_int0(int state_0, VirtualFrame frameValue) {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doInteger(int, int) */;
        return doInteger(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_int_double1(int state_0, VirtualFrame frameValue) {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_0 & 0b1110000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0b1101000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0b1011000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 doIntDouble(int, double) */;
        if ((!(JSBinaryNode.largerThan2e32(rightNodeValue_)))) {
            return doIntDouble(leftNodeValue_, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, ((state_0 & 0b1110000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) rightNodeValue_long : ((state_0 & 0b1101000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) rightNodeValue_int : (Object) rightNodeValue_)));
    }

    private Object execute_double_double2(int state_0, VirtualFrame frameValue) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0b10110000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_0 & 0b1110000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0b1101000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0b1011000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state_0 & 0b1000) != 0 /* is-state_0 doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) */;
        DoubleData s3_ = this.double_cache;
        if (s3_ != null) {
            return doDouble(leftNodeValue_, rightNodeValue_, s3_.rightShift_, s3_.leftInt32_, s3_.rightUInt32_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ((state_0 & 0b1110000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) rightNodeValue_long : ((state_0 & 0b1101000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) rightNodeValue_int : (Object) rightNodeValue_)));
    }

    private Object execute_generic3(int state_0, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int, int) */ && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if (rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return doInteger(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doBigInt(BigInt, BigInt, JSLeftShiftNode) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doBigInt(leftNodeValue__, rightNodeValue__, this.bigInt_leftShift_);
            }
        }
        if ((state_0 & 0b1100) != 0 /* is-state_0 doIntDouble(int, double) || doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rightNodeValue_)) {
            double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rightNodeValue_);
            if ((state_0 & 0b100) != 0 /* is-state_0 doIntDouble(int, double) */ && leftNodeValue_ instanceof Integer) {
                int leftNodeValue__ = (int) leftNodeValue_;
                if ((!(JSBinaryNode.largerThan2e32(rightNodeValue__)))) {
                    return doIntDouble(leftNodeValue__, rightNodeValue__);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue_)) {
                double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue_);
                DoubleData s3_ = this.double_cache;
                if (s3_ != null) {
                    return doDouble(leftNodeValue__, rightNodeValue__, s3_.rightShift_, s3_.leftInt32_, s3_.rightUInt32_);
                }
            }
        }
        if ((state_0 & 0b110000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            if ((state_0 & 0b10000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
                if ((JSGuards.hasOverloadedOperators(leftNodeValue_) || JSGuards.hasOverloadedOperators(rightNodeValue_))) {
                    return doOverloaded(leftNodeValue_, rightNodeValue_, this.overloaded_overloadedOperatorNode_);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                GenericData s5_ = this.generic_cache;
                if (s5_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(leftNodeValue_))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue_)))) {
                        return doGeneric(leftNodeValue_, rightNodeValue_, s5_.rightShift_, s5_.leftToNumeric_, s5_.rightToNumeric_, s5_.mixedNumericTypes_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111000) != 0 /* is-state_0 doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) || doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        if ((state_0 & 0b100) == 0 /* only-active doInteger(int, int) */ && ((state_0 & 0b101) != 0  /* is-not doInteger(int, int) && doIntDouble(int, double) */)) {
            return executeInt_int4(state_0, frameValue, leftNodeValue_);
        } else if ((state_0 & 0b1) == 0 /* only-active doIntDouble(int, double) */ && ((state_0 & 0b101) != 0  /* is-not doInteger(int, int) && doIntDouble(int, double) */)) {
            return executeInt_double5(state_0, frameValue, leftNodeValue_);
        } else {
            return executeInt_generic6(state_0, frameValue, leftNodeValue_);
        }
    }

    private int executeInt_int4(int state_0, VirtualFrame frameValue, int leftNodeValue_) throws UnexpectedResultException {
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, ex.getResult()));
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doInteger(int, int) */;
        return doInteger(leftNodeValue_, rightNodeValue_);
    }

    private int executeInt_double5(int state_0, VirtualFrame frameValue, int leftNodeValue_) throws UnexpectedResultException {
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_0 & 0b1110000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0b1101000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0b1011000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, ex.getResult()));
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 doIntDouble(int, double) */;
        if ((!(JSBinaryNode.largerThan2e32(rightNodeValue_)))) {
            return doIntDouble(leftNodeValue_, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, ((state_0 & 0b1110000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) rightNodeValue_long : ((state_0 & 0b1101000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) rightNodeValue_int : (Object) rightNodeValue_))));
    }

    private int executeInt_generic6(int state_0, VirtualFrame frameValue, int leftNodeValue_) throws UnexpectedResultException {
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int, int) */ && rightNodeValue_ instanceof Integer) {
            int rightNodeValue__ = (int) rightNodeValue_;
            return doInteger(leftNodeValue_, rightNodeValue__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doIntDouble(int, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rightNodeValue_)) {
            double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rightNodeValue_);
            if ((!(JSBinaryNode.largerThan2e32(rightNodeValue__)))) {
                return doIntDouble(leftNodeValue_, rightNodeValue__);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b111010) == 0 /* only-active doInteger(int, int) && doIntDouble(int, double) */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int, int) && doBigInt(BigInt, BigInt, JSLeftShiftNode) && doIntDouble(int, double) && doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                executeInt(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Object leftNodeValue, Object rightNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (((exclude & 0b1)) == 0 /* is-not-exclude doInteger(int, int) */ && leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInteger(int, int) */;
                    lock.unlock();
                    hasLock = false;
                    return doInteger(leftNodeValue_, rightNodeValue_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doBigInt(BigInt, BigInt, JSLeftShiftNode) */ && leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    this.bigInt_leftShift_ = super.insert((JSLeftShiftNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doBigInt(BigInt, BigInt, JSLeftShiftNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigInt(leftNodeValue_, rightNodeValue_, this.bigInt_leftShift_);
                }
            }
            {
                int doubleCast1;
                if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                    double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                    if (((exclude & 0b100)) == 0 /* is-not-exclude doIntDouble(int, double) */ && leftNodeValue instanceof Integer) {
                        int leftNodeValue_ = (int) leftNodeValue;
                        if ((!(JSBinaryNode.largerThan2e32(rightNodeValue_)))) {
                            state_0 = (state_0 | (doubleCast1 << 6) /* set-implicit-state_0 1:double */);
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doIntDouble(int, double) */;
                            lock.unlock();
                            hasLock = false;
                            return doIntDouble(leftNodeValue_, rightNodeValue_);
                        }
                    }
                    if (((exclude & 0b1000)) == 0 /* is-not-exclude doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) */) {
                        int doubleCast0;
                        if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                            double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                            DoubleData s3_ = super.insert(new DoubleData());
                            s3_.rightShift_ = s3_.insertAccessor((JSRightShiftNode.create()));
                            s3_.leftInt32_ = s3_.insertAccessor((JSToInt32Node.create()));
                            s3_.rightUInt32_ = s3_.insertAccessor((JSToUInt32Node.create()));
                            MemoryFence.storeStore();
                            this.double_cache = s3_;
                            state_0 = (state_0 | (doubleCast0 << 10) /* set-implicit-state_0 0:double */);
                            state_0 = (state_0 | (doubleCast1 << 6) /* set-implicit-state_0 1:double */);
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) */;
                            lock.unlock();
                            hasLock = false;
                            return doDouble(leftNodeValue_, rightNodeValue_, s3_.rightShift_, s3_.leftInt32_, s3_.rightUInt32_);
                        }
                    }
                }
            }
            if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                this.overloaded_overloadedOperatorNode_ = super.insert((JSOverloadedBinaryNode.createNumeric(getOverloadedOperatorName())));
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */;
                lock.unlock();
                hasLock = false;
                return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_);
            }
            if ((!(JSGuards.hasOverloadedOperators(leftNodeValue))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue)))) {
                GenericData s5_ = super.insert(new GenericData());
                s5_.rightShift_ = s5_.insertAccessor((JSRightShiftNode.create()));
                s5_.leftToNumeric_ = s5_.insertAccessor((JSToNumericNode.create()));
                s5_.rightToNumeric_ = s5_.insertAccessor((JSToNumericNode.create()));
                s5_.mixedNumericTypes_ = (BranchProfile.create());
                MemoryFence.storeStore();
                this.generic_cache = s5_;
                this.exclude_ = exclude = exclude | 0b1111 /* add-exclude doInteger(int, int), doBigInt(BigInt, BigInt, JSLeftShiftNode), doIntDouble(int, double), doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) */;
                this.double_cache = null;
                state_0 = state_0 & 0xfffffff0 /* remove-state_0 doInteger(int, int), doBigInt(BigInt, BigInt, JSLeftShiftNode), doIntDouble(int, double), doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) */;
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(leftNodeValue, rightNodeValue, s5_.rightShift_, s5_.leftToNumeric_, s5_.rightToNumeric_, s5_.mixedNumericTypes_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.leftNode, super.rightNode}, leftNodeValue, rightNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b111111) & ((state_0 & 0b111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[7];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doInteger(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b10) != 0 /* is-state_0 doBigInt(BigInt, BigInt, JSLeftShiftNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.bigInt_leftShift_));
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doBigInt(BigInt, BigInt, JSLeftShiftNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doIntDouble";
        if ((state_0 & 0b100) != 0 /* is-state_0 doIntDouble(int, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-exclude doIntDouble(int, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            DoubleData s3_ = this.double_cache;
            if (s3_ != null) {
                cached.add(Arrays.asList(s3_.rightShift_, s3_.leftInt32_, s3_.rightUInt32_));
            }
            s[2] = cached;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doDouble(double, double, JSRightShiftNode, JSToInt32Node, JSToUInt32Node) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doOverloaded";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.overloaded_overloadedOperatorNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doGeneric(Object, Object, JSRightShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s5_ = this.generic_cache;
            if (s5_ != null) {
                cached.add(Arrays.asList(s5_.rightShift_, s5_.leftToNumeric_, s5_.rightToNumeric_, s5_.mixedNumericTypes_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        return Provider.create(data);
    }

    public static JSRightShiftNode create(JavaScriptNode left, JavaScriptNode right) {
        return new JSRightShiftNodeGen(left, right);
    }

    @GeneratedBy(JSRightShiftNode.class)
    private static final class DoubleData extends Node {

        @Child JSRightShiftNode rightShift_;
        @Child JSToInt32Node leftInt32_;
        @Child JSToUInt32Node rightUInt32_;

        DoubleData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSRightShiftNode.class)
    private static final class GenericData extends Node {

        @Child JSRightShiftNode rightShift_;
        @Child JSToNumericNode leftToNumeric_;
        @Child JSToNumericNode rightToNumeric_;
        @CompilationFinal BranchProfile mixedNumericTypes_;

        GenericData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
}
