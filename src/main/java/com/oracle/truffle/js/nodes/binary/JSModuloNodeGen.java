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
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.runtime.BigInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSModuloNode.class)
public final class JSModuloNodeGen extends JSModuloNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private BranchProfile intPow2_negativeBranch_;
    @CompilationFinal private BranchProfile intPow2_negativeZeroBranch_;
    @CompilationFinal private BranchProfile int_specialBranch_;
    @Child private JSOverloadedBinaryNode overloaded_overloadedOperatorNode_;
    @Child private GenericData generic_cache;

    private JSModuloNodeGen(JavaScriptNode left, JavaScriptNode right) {
        super(left, right);
    }

    @Override
    public Object execute(Object leftNodeValue, Object rightNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) || doInt(int, int, BranchProfile) */ && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if (rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                if ((state_0 & 0b1) != 0 /* is-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) */) {
                    if ((JSModuloNode.isPowOf2(rightNodeValue_))) {
                        try {
                            return doIntPow2(leftNodeValue_, rightNodeValue_, this.intPow2_negativeBranch_, this.intPow2_negativeZeroBranch_);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            Lock lock = getLock();
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b1 /* add-exclude doIntPow2(int, int, BranchProfile, BranchProfile) */;
                                this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                        }
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int, int, BranchProfile) */) {
                    if ((!(JSModuloNode.isPowOf2(rightNodeValue_)))) {
                        try {
                            return doInt(leftNodeValue_, rightNodeValue_, this.int_specialBranch_);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            Lock lock = getLock();
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b10 /* add-exclude doInt(int, int, BranchProfile) */;
                                this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int, int, BranchProfile) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                        }
                    }
                }
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000) >>> 7 /* extract-implicit-state_0 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000) >>> 7 /* extract-implicit-state_0 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((state_0 & 0b111100000000000) >>> 11 /* extract-implicit-state_0 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000000000) >>> 11 /* extract-implicit-state_0 1:double */, rightNodeValue);
                return doDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doBigInteger(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                if ((!(JSGuards.isBigIntZero(rightNodeValue_)))) {
                    return doBigInteger(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            if ((state_0 & 0b100000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
                if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                    return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                GenericData s6_ = this.generic_cache;
                if (s6_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(leftNodeValue))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue)))) {
                        return doGeneric(leftNodeValue, rightNodeValue, s6_.nestedModuloNode_, s6_.toNumeric1Node_, s6_.toNumeric2Node_, s6_.mixedNumericTypes_);
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
        if ((state_0 & 0b1110100) == 0 /* only-active doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) */ && ((state_0 & 0b1110111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
            return execute_int_int0(state_0, frameValue);
        } else if ((state_0 & 0b1110011) == 0 /* only-active doDouble(double, double) */ && ((state_0 & 0b1110111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
            return execute_double_double1(state_0, frameValue);
        } else {
            return execute_generic2(state_0, frameValue);
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) */) {
            if ((JSModuloNode.isPowOf2(rightNodeValue_))) {
                try {
                    return doIntPow2(leftNodeValue_, rightNodeValue_, this.intPow2_negativeBranch_, this.intPow2_negativeZeroBranch_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-exclude doIntPow2(int, int, BranchProfile, BranchProfile) */;
                        this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int, int, BranchProfile) */) {
            if ((!(JSModuloNode.isPowOf2(rightNodeValue_)))) {
                try {
                    return doInt(leftNodeValue_, rightNodeValue_, this.int_specialBranch_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10 /* add-exclude doInt(int, int, BranchProfile) */;
                        this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int, int, BranchProfile) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_double_double1(int state_0, VirtualFrame frameValue) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0b11100000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0b11010000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0b10110000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000000) >>> 7 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_0 & 0b111000000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0b110100000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0b101100000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100000000000) >>> 11 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state_0 & 0b11100000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b11010000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 doDouble(double, double) */;
        return doDouble(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_generic2(int state_0, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b11) != 0 /* is-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) || doInt(int, int, BranchProfile) */ && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if (rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) */) {
                    if ((JSModuloNode.isPowOf2(rightNodeValue__))) {
                        try {
                            return doIntPow2(leftNodeValue__, rightNodeValue__, this.intPow2_negativeBranch_, this.intPow2_negativeZeroBranch_);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            Lock lock = getLock();
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b1 /* add-exclude doIntPow2(int, int, BranchProfile, BranchProfile) */;
                                this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                        }
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int, int, BranchProfile) */) {
                    if ((!(JSModuloNode.isPowOf2(rightNodeValue__)))) {
                        try {
                            return doInt(leftNodeValue__, rightNodeValue__, this.int_specialBranch_);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            Lock lock = getLock();
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b10 /* add-exclude doInt(int, int, BranchProfile) */;
                                this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int, int, BranchProfile) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                        }
                    }
                }
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000) >>> 7 /* extract-implicit-state_0 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000) >>> 7 /* extract-implicit-state_0 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((state_0 & 0b111100000000000) >>> 11 /* extract-implicit-state_0 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000000000) >>> 11 /* extract-implicit-state_0 1:double */, rightNodeValue_);
                return doDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doBigInteger(BigInt, BigInt) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                if ((!(JSGuards.isBigIntZero(rightNodeValue__)))) {
                    return doBigInteger(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            if ((state_0 & 0b100000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
                if ((JSGuards.hasOverloadedOperators(leftNodeValue_) || JSGuards.hasOverloadedOperators(rightNodeValue_))) {
                    return doOverloaded(leftNodeValue_, rightNodeValue_, this.overloaded_overloadedOperatorNode_);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                GenericData s6_ = this.generic_cache;
                if (s6_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(leftNodeValue_))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue_)))) {
                        return doGeneric(leftNodeValue_, rightNodeValue_, s6_.nestedModuloNode_, s6_.toNumeric1Node_, s6_.toNumeric2Node_, s6_.mixedNumericTypes_);
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
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0b11100000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0b11010000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0b10110000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000000) >>> 7 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_0 & 0b111000000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0b110100000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0b101100000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100000000000) >>> 11 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0b11100000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b11010000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult()));
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, double) */) {
            return doDouble(leftNodeValue_, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0b11100000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b11010000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ((state_0 & 0b111000000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) rightNodeValue_long : ((state_0 & 0b110100000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) ? (Object) rightNodeValue_int : (Object) rightNodeValue_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) */) {
            if ((JSModuloNode.isPowOf2(rightNodeValue_))) {
                try {
                    return doIntPow2(leftNodeValue_, rightNodeValue_, this.intPow2_negativeBranch_, this.intPow2_negativeZeroBranch_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-exclude doIntPow2(int, int, BranchProfile, BranchProfile) */;
                        this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) */;
                    } finally {
                        lock.unlock();
                    }
                    return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
                }
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int, int, BranchProfile) */) {
            if ((!(JSModuloNode.isPowOf2(rightNodeValue_)))) {
                try {
                    return doInt(leftNodeValue_, rightNodeValue_, this.int_specialBranch_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10 /* add-exclude doInt(int, int, BranchProfile) */;
                        this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int, int, BranchProfile) */;
                    } finally {
                        lock.unlock();
                    }
                    return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b1111100) == 0 /* only-active doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b1111011) == 0 /* only-active doDouble(double, double) */ && ((state_0 & 0b1111111) != 0  /* is-not doIntPow2(int, int, BranchProfile, BranchProfile) && doInt(int, int, BranchProfile) && doDouble(double, double) && doBigIntegerZeroDivision(BigInt, BigInt) && doBigInteger(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */)) {
                executeDouble(frameValue);
                return;
            } else if ((state_0 & 0b1110111) != 0 /* is-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) || doInt(int, int, BranchProfile) || doDouble(double, double) || doBigInteger(BigInt, BigInt) || doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                execute(frameValue);
                return;
            }
        } catch (UnexpectedResultException ex) {
            return;
        }
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b1000) != 0 /* is-state_0 doBigIntegerZeroDivision(BigInt, BigInt) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                if ((JSGuards.isBigIntZero(rightNodeValue__))) {
                    doBigIntegerZeroDivision(leftNodeValue__, rightNodeValue__);
                    return;
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(leftNodeValue_, rightNodeValue_);
        return;
    }

    private Object executeAndSpecialize(Object leftNodeValue, Object rightNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    if (((exclude & 0b1)) == 0 /* is-not-exclude doIntPow2(int, int, BranchProfile, BranchProfile) */) {
                        if ((JSModuloNode.isPowOf2(rightNodeValue_))) {
                            this.intPow2_negativeBranch_ = (BranchProfile.create());
                            this.intPow2_negativeZeroBranch_ = (BranchProfile.create());
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return doIntPow2(leftNodeValue_, rightNodeValue_, this.intPow2_negativeBranch_, this.intPow2_negativeZeroBranch_);
                            } catch (ArithmeticException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b1 /* add-exclude doIntPow2(int, int, BranchProfile, BranchProfile) */;
                                    this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                            }
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-exclude doInt(int, int, BranchProfile) */) {
                        if ((!(JSModuloNode.isPowOf2(rightNodeValue_)))) {
                            this.int_specialBranch_ = (BranchProfile.create());
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doInt(int, int, BranchProfile) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return doInt(leftNodeValue_, rightNodeValue_, this.int_specialBranch_);
                            } catch (ArithmeticException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b10 /* add-exclude doInt(int, int, BranchProfile) */;
                                    this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int, int, BranchProfile) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                            }
                        }
                    }
                }
            }
            if (((exclude & 0b100)) == 0 /* is-not-exclude doDouble(double, double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state_0 = (state_0 | (doubleCast0 << 7) /* set-implicit-state_0 0:double */);
                        state_0 = (state_0 | (doubleCast1 << 11) /* set-implicit-state_0 1:double */);
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doDouble(double, double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    if (((exclude & 0b1000)) == 0 /* is-not-exclude doBigIntegerZeroDivision(BigInt, BigInt) */) {
                        if ((JSGuards.isBigIntZero(rightNodeValue_))) {
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doBigIntegerZeroDivision(BigInt, BigInt) */;
                            lock.unlock();
                            hasLock = false;
                            doBigIntegerZeroDivision(leftNodeValue_, rightNodeValue_);
                            return null;
                        }
                    }
                    if (((exclude & 0b10000)) == 0 /* is-not-exclude doBigInteger(BigInt, BigInt) */) {
                        if ((!(JSGuards.isBigIntZero(rightNodeValue_)))) {
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doBigInteger(BigInt, BigInt) */;
                            lock.unlock();
                            hasLock = false;
                            return doBigInteger(leftNodeValue_, rightNodeValue_);
                        }
                    }
                }
            }
            if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                this.overloaded_overloadedOperatorNode_ = super.insert((JSOverloadedBinaryNode.createNumeric(getOverloadedOperatorName())));
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */;
                lock.unlock();
                hasLock = false;
                return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_);
            }
            if ((!(JSGuards.hasOverloadedOperators(leftNodeValue))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue)))) {
                GenericData s6_ = super.insert(new GenericData());
                s6_.nestedModuloNode_ = s6_.insertAccessor((JSModuloNode.create()));
                s6_.toNumeric1Node_ = s6_.insertAccessor((JSToNumericNode.create()));
                s6_.toNumeric2Node_ = s6_.insertAccessor((JSToNumericNode.create()));
                s6_.mixedNumericTypes_ = (BranchProfile.create());
                MemoryFence.storeStore();
                this.generic_cache = s6_;
                this.exclude_ = exclude = exclude | 0b11110 /* add-exclude doInt(int, int, BranchProfile), doDouble(double, double), doBigIntegerZeroDivision(BigInt, BigInt), doBigInteger(BigInt, BigInt) */;
                state_0 = state_0 & 0xffffffe1 /* remove-state_0 doInt(int, int, BranchProfile), doDouble(double, double), doBigIntegerZeroDivision(BigInt, BigInt), doBigInteger(BigInt, BigInt) */;
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(leftNodeValue, rightNodeValue, s6_.nestedModuloNode_, s6_.toNumeric1Node_, s6_.toNumeric2Node_, s6_.mixedNumericTypes_);
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
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doIntPow2";
        if ((state_0 & 0b1) != 0 /* is-state_0 doIntPow2(int, int, BranchProfile, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.intPow2_negativeBranch_, this.intPow2_negativeZeroBranch_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doIntPow2(int, int, BranchProfile, BranchProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int, int, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.int_specialBranch_));
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doInt(int, int, BranchProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-exclude doDouble(double, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBigIntegerZeroDivision";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doBigIntegerZeroDivision(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doBigIntegerZeroDivision(BigInt, BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doBigInteger";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doBigInteger(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-exclude doBigInteger(BigInt, BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doOverloaded";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.overloaded_overloadedOperatorNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doGeneric(Object, Object, JSModuloNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s6_ = this.generic_cache;
            if (s6_ != null) {
                cached.add(Arrays.asList(s6_.nestedModuloNode_, s6_.toNumeric1Node_, s6_.toNumeric2Node_, s6_.mixedNumericTypes_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static JSModuloNode create(JavaScriptNode left, JavaScriptNode right) {
        return new JSModuloNodeGen(left, right);
    }

    @GeneratedBy(JSModuloNode.class)
    private static final class GenericData extends Node {

        @Child JSModuloNode nestedModuloNode_;
        @Child JSToNumericNode toNumeric1Node_;
        @Child JSToNumericNode toNumeric2Node_;
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
