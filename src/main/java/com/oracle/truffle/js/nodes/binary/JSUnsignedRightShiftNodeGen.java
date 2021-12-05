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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.nodes.cast.JSToUInt32Node;
import com.oracle.truffle.js.runtime.BigInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSUnsignedRightShiftNode.class)
public final class JSUnsignedRightShiftNodeGen extends JSUnsignedRightShiftNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private ConditionProfile double_returnType_;
    @Child private JSToUInt32Node intDouble_rvalToUint32Node_;
    @CompilationFinal private ConditionProfile intDouble_returnType_;
    @Child private JSOverloadedBinaryNode overloaded_overloadedOperatorNode_;
    @Child private GenericData generic_cache;

    private JSUnsignedRightShiftNodeGen(JavaScriptNode left, JavaScriptNode right) {
        super(left, right);
    }

    @Override
    public Object execute(Object leftNodeValue, Object rightNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11111) != 0 /* is-state_0 doIntegerFast(int, int) || doInteger(int, int) || doIntegerNegative(int, int) || doDoubleZero(double, int) || doDouble(double, int, ConditionProfile) */ && rightNodeValue instanceof Integer) {
            int rightNodeValue_ = (int) rightNodeValue;
            if ((state_0 & 0b111) != 0 /* is-state_0 doIntegerFast(int, int) || doInteger(int, int) || doIntegerNegative(int, int) */ && leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                if ((state_0 & 0b1) != 0 /* is-state_0 doIntegerFast(int, int) */) {
                    if ((JSUnsignedRightShiftNode.rvalZero(rightNodeValue_)) && (leftNodeValue_ >= 0)) {
                        return doIntegerFast(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(int, int) */) {
                    if ((leftNodeValue_ >= 0)) {
                        return doInteger(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doIntegerNegative(int, int) */) {
                    if ((!(JSUnsignedRightShiftNode.rvalZero(rightNodeValue_)))) {
                        return doIntegerNegative(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if ((state_0 & 0b11000) != 0 /* is-state_0 doDoubleZero(double, int) || doDouble(double, int, ConditionProfile) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue)) {
                double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue);
                if ((state_0 & 0b1000) != 0 /* is-state_0 doDoubleZero(double, int) */) {
                    if ((JSUnsignedRightShiftNode.rvalZero(rightNodeValue_))) {
                        return doDoubleZero(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double, int, ConditionProfile) */) {
                    if ((!(JSUnsignedRightShiftNode.rvalZero(rightNodeValue_)))) {
                        return doDouble(leftNodeValue_, rightNodeValue_, this.double_returnType_);
                    }
                }
            }
        }
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doIntDouble(int, double, JSToUInt32Node, ConditionProfile) || doDoubleDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c000) >>> 14 /* extract-implicit-state_0 1:double */, rightNodeValue)) {
            double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0x3c000) >>> 14 /* extract-implicit-state_0 1:double */, rightNodeValue);
            if ((state_0 & 0b100000) != 0 /* is-state_0 doIntDouble(int, double, JSToUInt32Node, ConditionProfile) */ && leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                return doIntDouble(leftNodeValue_, rightNodeValue_, this.intDouble_rvalToUint32Node_, this.intDouble_returnType_);
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doDoubleDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue)) {
                double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue);
                return doDoubleDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
                if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                    return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_);
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) {
                GenericData s9_ = this.generic_cache;
                if (s9_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(leftNodeValue))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue))) && (!(JSUnsignedRightShiftNode.isHandled(leftNodeValue, rightNodeValue)))) {
                        return doGeneric(leftNodeValue, rightNodeValue, s9_.lvalToNumericNode_, s9_.rvalToNumericNode_, s9_.innerShiftNode_, s9_.mixedNumericTypes_);
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
        if ((state_0 & 0b1111111000) == 0 /* only-active doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
            return execute_int_int0(state_0, frameValue);
        } else if ((state_0 & 0b1111100111) == 0 /* only-active doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
            return execute_double_int1(state_0, frameValue);
        } else if ((state_0 & 0b1111011111) == 0 /* only-active doIntDouble(int, double, JSToUInt32Node, ConditionProfile) */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
            return execute_int_double2(state_0, frameValue);
        } else if ((state_0 & 0b1110111111) == 0 /* only-active doDoubleDouble(double, double) */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
            return execute_double_double3(state_0, frameValue);
        } else {
            return execute_generic4(state_0, frameValue);
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doIntegerFast(int, int) */) {
            if ((JSUnsignedRightShiftNode.rvalZero(rightNodeValue_)) && (leftNodeValue_ >= 0)) {
                return doIntegerFast(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(int, int) */) {
            if ((leftNodeValue_ >= 0)) {
                return doInteger(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doIntegerNegative(int, int) */) {
            if ((!(JSUnsignedRightShiftNode.rvalZero(rightNodeValue_)))) {
                return doIntegerNegative(leftNodeValue_, rightNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_double_int1(int state_0, VirtualFrame frameValue) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0b10110000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doDoubleZero(double, int) */) {
            if ((JSUnsignedRightShiftNode.rvalZero(rightNodeValue_))) {
                return doDoubleZero(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double, int, ConditionProfile) */) {
            if ((!(JSUnsignedRightShiftNode.rvalZero(rightNodeValue_)))) {
                return doDouble(leftNodeValue_, rightNodeValue_, this.double_returnType_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), rightNodeValue_);
    }

    private Object execute_int_double2(int state_0, VirtualFrame frameValue) {
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
            if ((state_0 & 0x38000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0x34000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0x2c000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0x3c000) >>> 14 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state_0 & 0b100000) != 0 /* is-state_0 doIntDouble(int, double, JSToUInt32Node, ConditionProfile) */;
        return doIntDouble(leftNodeValue_, rightNodeValue_, this.intDouble_rvalToUint32Node_, this.intDouble_returnType_);
    }

    private Object execute_double_double3(int state_0, VirtualFrame frameValue) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0b10110000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
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
            if ((state_0 & 0x38000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0x34000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0x2c000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0x3c000) >>> 14 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state_0 & 0b1000000) != 0 /* is-state_0 doDoubleDouble(double, double) */;
        return doDoubleDouble(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_generic4(int state_0, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b11111) != 0 /* is-state_0 doIntegerFast(int, int) || doInteger(int, int) || doIntegerNegative(int, int) || doDoubleZero(double, int) || doDouble(double, int, ConditionProfile) */ && rightNodeValue_ instanceof Integer) {
            int rightNodeValue__ = (int) rightNodeValue_;
            if ((state_0 & 0b111) != 0 /* is-state_0 doIntegerFast(int, int) || doInteger(int, int) || doIntegerNegative(int, int) */ && leftNodeValue_ instanceof Integer) {
                int leftNodeValue__ = (int) leftNodeValue_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doIntegerFast(int, int) */) {
                    if ((JSUnsignedRightShiftNode.rvalZero(rightNodeValue__)) && (leftNodeValue__ >= 0)) {
                        return doIntegerFast(leftNodeValue__, rightNodeValue__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(int, int) */) {
                    if ((leftNodeValue__ >= 0)) {
                        return doInteger(leftNodeValue__, rightNodeValue__);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doIntegerNegative(int, int) */) {
                    if ((!(JSUnsignedRightShiftNode.rvalZero(rightNodeValue__)))) {
                        return doIntegerNegative(leftNodeValue__, rightNodeValue__);
                    }
                }
            }
            if ((state_0 & 0b11000) != 0 /* is-state_0 doDoubleZero(double, int) || doDouble(double, int, ConditionProfile) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue_)) {
                double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue_);
                if ((state_0 & 0b1000) != 0 /* is-state_0 doDoubleZero(double, int) */) {
                    if ((JSUnsignedRightShiftNode.rvalZero(rightNodeValue__))) {
                        return doDoubleZero(leftNodeValue__, rightNodeValue__);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double, int, ConditionProfile) */) {
                    if ((!(JSUnsignedRightShiftNode.rvalZero(rightNodeValue__)))) {
                        return doDouble(leftNodeValue__, rightNodeValue__, this.double_returnType_);
                    }
                }
            }
        }
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doIntDouble(int, double, JSToUInt32Node, ConditionProfile) || doDoubleDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c000) >>> 14 /* extract-implicit-state_0 1:double */, rightNodeValue_)) {
            double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0x3c000) >>> 14 /* extract-implicit-state_0 1:double */, rightNodeValue_);
            if ((state_0 & 0b100000) != 0 /* is-state_0 doIntDouble(int, double, JSToUInt32Node, ConditionProfile) */ && leftNodeValue_ instanceof Integer) {
                int leftNodeValue__ = (int) leftNodeValue_;
                return doIntDouble(leftNodeValue__, rightNodeValue__, this.intDouble_rvalToUint32Node_, this.intDouble_returnType_);
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doDoubleDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue_)) {
                double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue_);
                return doDoubleDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
                if ((JSGuards.hasOverloadedOperators(leftNodeValue_) || JSGuards.hasOverloadedOperators(rightNodeValue_))) {
                    return doOverloaded(leftNodeValue_, rightNodeValue_, this.overloaded_overloadedOperatorNode_);
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) {
                GenericData s9_ = this.generic_cache;
                if (s9_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(leftNodeValue_))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue_))) && (!(JSUnsignedRightShiftNode.isHandled(leftNodeValue_, rightNodeValue_)))) {
                        return doGeneric(leftNodeValue_, rightNodeValue_, s9_.lvalToNumericNode_, s9_.rvalToNumericNode_, s9_.innerShiftNode_, s9_.mixedNumericTypes_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1110110000) != 0 /* is-state_0 doDouble(double, int, ConditionProfile) || doIntDouble(int, double, JSToUInt32Node, ConditionProfile) || doBigInt(BigInt, BigInt) || doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        if ((state_0 & 0b1000000) == 0 /* only-active doDoubleZero(double, int) */ && ((state_0 & 0b1001000) != 0  /* is-not doDoubleZero(double, int) && doDoubleDouble(double, double) */)) {
            return executeDouble_double_int5(state_0, frameValue);
        } else if ((state_0 & 0b1000) == 0 /* only-active doDoubleDouble(double, double) */ && ((state_0 & 0b1001000) != 0  /* is-not doDoubleZero(double, int) && doDoubleDouble(double, double) */)) {
            return executeDouble_double_double6(state_0, frameValue);
        } else {
            return executeDouble_generic7(state_0, frameValue);
        }
    }

    private double executeDouble_double_int5(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0b10110000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult()));
        }
        assert (state_0 & 0b1000) != 0 /* is-state_0 doDoubleZero(double, int) */;
        if ((JSUnsignedRightShiftNode.rvalZero(rightNodeValue_))) {
            return doDoubleZero(leftNodeValue_, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), rightNodeValue_));
    }

    private double executeDouble_double_double6(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0b10110000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_0 & 0x38000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0x34000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0x2c000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0x3c000) >>> 14 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult()));
        }
        assert (state_0 & 0b1000000) != 0 /* is-state_0 doDoubleDouble(double, double) */;
        return doDoubleDouble(leftNodeValue_, rightNodeValue_);
    }

    private double executeDouble_generic7(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0b10110000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b1000) != 0 /* is-state_0 doDoubleZero(double, int) */ && rightNodeValue_ instanceof Integer) {
            int rightNodeValue__ = (int) rightNodeValue_;
            if ((JSUnsignedRightShiftNode.rvalZero(rightNodeValue__))) {
                return doDoubleZero(leftNodeValue_, rightNodeValue__);
            }
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doDoubleDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c000) >>> 14 /* extract-implicit-state_0 1:double */, rightNodeValue_)) {
            double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0x3c000) >>> 14 /* extract-implicit-state_0 1:double */, rightNodeValue_);
            return doDoubleDouble(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), rightNodeValue_));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1110110000) != 0 /* is-state_0 doDouble(double, int, ConditionProfile) || doIntDouble(int, double, JSToUInt32Node, ConditionProfile) || doBigInt(BigInt, BigInt) || doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, ex.getResult()));
        }
        if ((state_0 & 0b1) != 0 /* is-state_0 doIntegerFast(int, int) */) {
            if ((JSUnsignedRightShiftNode.rvalZero(rightNodeValue_)) && (leftNodeValue_ >= 0)) {
                return doIntegerFast(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(int, int) */) {
            if ((leftNodeValue_ >= 0)) {
                return doInteger(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doIntegerNegative(int, int) */) {
            if ((!(JSUnsignedRightShiftNode.rvalZero(rightNodeValue_)))) {
                return doIntegerNegative(leftNodeValue_, rightNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b1111111000) == 0 /* only-active doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b1110110111) == 0 /* only-active doDoubleZero(double, int) && doDoubleDouble(double, double) */ && ((state_0 & 0b1111111111) != 0  /* is-not doIntegerFast(int, int) && doInteger(int, int) && doIntegerNegative(int, int) && doDoubleZero(double, int) && doDouble(double, int, ConditionProfile) && doIntDouble(int, double, JSToUInt32Node, ConditionProfile) && doDoubleDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */)) {
                executeDouble(frameValue);
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
            if (rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                if (leftNodeValue instanceof Integer) {
                    int leftNodeValue_ = (int) leftNodeValue;
                    if ((JSUnsignedRightShiftNode.rvalZero(rightNodeValue_)) && (leftNodeValue_ >= 0)) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doIntegerFast(int, int) */;
                        lock.unlock();
                        hasLock = false;
                        return doIntegerFast(leftNodeValue_, rightNodeValue_);
                    }
                    if ((leftNodeValue_ >= 0)) {
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doInteger(int, int) */;
                        lock.unlock();
                        hasLock = false;
                        return doInteger(leftNodeValue_, rightNodeValue_);
                    }
                    if ((!(JSUnsignedRightShiftNode.rvalZero(rightNodeValue_)))) {
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doIntegerNegative(int, int) */;
                        lock.unlock();
                        hasLock = false;
                        return doIntegerNegative(leftNodeValue_, rightNodeValue_);
                    }
                }
                {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                        double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                        if ((JSUnsignedRightShiftNode.rvalZero(rightNodeValue_))) {
                            state_0 = (state_0 | (doubleCast0 << 10) /* set-implicit-state_0 0:double */);
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doDoubleZero(double, int) */;
                            lock.unlock();
                            hasLock = false;
                            return doDoubleZero(leftNodeValue_, rightNodeValue_);
                        }
                        if ((!(JSUnsignedRightShiftNode.rvalZero(rightNodeValue_)))) {
                            this.double_returnType_ = (ConditionProfile.createBinaryProfile());
                            state_0 = (state_0 | (doubleCast0 << 10) /* set-implicit-state_0 0:double */);
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doDouble(double, int, ConditionProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return doDouble(leftNodeValue_, rightNodeValue_, this.double_returnType_);
                        }
                    }
                }
            }
            {
                int doubleCast1;
                if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                    double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                    if (leftNodeValue instanceof Integer) {
                        int leftNodeValue_ = (int) leftNodeValue;
                        this.intDouble_rvalToUint32Node_ = super.insert((JSToUInt32Node.create()));
                        this.intDouble_returnType_ = (ConditionProfile.createBinaryProfile());
                        state_0 = (state_0 | (doubleCast1 << 14) /* set-implicit-state_0 1:double */);
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doIntDouble(int, double, JSToUInt32Node, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doIntDouble(leftNodeValue_, rightNodeValue_, this.intDouble_rvalToUint32Node_, this.intDouble_returnType_);
                    }
                    {
                        int doubleCast0;
                        if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                            double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                            state_0 = (state_0 | (doubleCast0 << 10) /* set-implicit-state_0 0:double */);
                            state_0 = (state_0 | (doubleCast1 << 14) /* set-implicit-state_0 1:double */);
                            this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doDoubleDouble(double, double) */;
                            lock.unlock();
                            hasLock = false;
                            return doDoubleDouble(leftNodeValue_, rightNodeValue_);
                        }
                    }
                }
            }
            if (leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doBigInt(BigInt, BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigInt(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                this.overloaded_overloadedOperatorNode_ = super.insert((JSOverloadedBinaryNode.createNumeric(getOverloadedOperatorName())));
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */;
                lock.unlock();
                hasLock = false;
                return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_);
            }
            if ((!(JSGuards.hasOverloadedOperators(leftNodeValue))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue))) && (!(JSUnsignedRightShiftNode.isHandled(leftNodeValue, rightNodeValue)))) {
                GenericData s9_ = super.insert(new GenericData());
                s9_.lvalToNumericNode_ = s9_.insertAccessor((JSToNumericNode.create()));
                s9_.rvalToNumericNode_ = s9_.insertAccessor((JSToNumericNode.create()));
                s9_.innerShiftNode_ = s9_.insertAccessor((JSUnsignedRightShiftNode.create()));
                s9_.mixedNumericTypes_ = (BranchProfile.create());
                MemoryFence.storeStore();
                this.generic_cache = s9_;
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(leftNodeValue, rightNodeValue, s9_.lvalToNumericNode_, s9_.rvalToNumericNode_, s9_.innerShiftNode_, s9_.mixedNumericTypes_);
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
        if ((state_0 & 0b1111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111111111) & ((state_0 & 0b1111111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[11];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doIntegerFast";
        if ((state_0 & 0b1) != 0 /* is-state_0 doIntegerFast(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doIntegerNegative";
        if ((state_0 & 0b100) != 0 /* is-state_0 doIntegerNegative(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doDoubleZero";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doDoubleZero(double, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double, int, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.double_returnType_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doIntDouble";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doIntDouble(int, double, JSToUInt32Node, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.intDouble_rvalToUint32Node_, this.intDouble_returnType_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doDoubleDouble";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doDoubleDouble(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doOverloaded";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.overloaded_overloadedOperatorNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSUnsignedRightShiftNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s9_ = this.generic_cache;
            if (s9_ != null) {
                cached.add(Arrays.asList(s9_.lvalToNumericNode_, s9_.rvalToNumericNode_, s9_.innerShiftNode_, s9_.mixedNumericTypes_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        return Provider.create(data);
    }

    public static JSUnsignedRightShiftNode create(JavaScriptNode left, JavaScriptNode right) {
        return new JSUnsignedRightShiftNodeGen(left, right);
    }

    @GeneratedBy(JSUnsignedRightShiftNode.class)
    private static final class GenericData extends Node {

        @Child JSToNumericNode lvalToNumericNode_;
        @Child JSToNumericNode rvalToNumericNode_;
        @Child JSUnsignedRightShiftNode innerShiftNode_;
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
