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

@GeneratedBy(JSSubtractNode.class)
public final class JSSubtractNodeGen extends JSSubtractNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSOverloadedBinaryNode overloaded_overloadedOperatorNode_;
    @Child private GenericData generic_cache;

    private JSSubtractNodeGen(boolean truncate, JavaScriptNode left, JavaScriptNode right) {
        super(truncate, left, right);
    }

    @Override
    public Object execute(Object leftNodeValue, Object rightNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */ && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if (rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                try {
                    return doInt(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-exclude doInt(int, int) */;
                        this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doInt(int, int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 1:double */, rightNodeValue);
                return doDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b11000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) {
            if ((state_0 & 0b1000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
                if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                    return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) {
                GenericData s4_ = this.generic_cache;
                if (s4_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(leftNodeValue))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue)))) {
                        return doGeneric(leftNodeValue, rightNodeValue, s4_.toNumericA_, s4_.toNumericB_, s4_.subtract_, s4_.mixedNumericTypes_);
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
        if ((state_0 & 0b11110) == 0 /* only-active doInt(int, int) */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
            return execute_int_int0(state_0, frameValue);
        } else if ((state_0 & 0b11101) == 0 /* only-active doDouble(double, double) */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
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
        assert (state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */;
        try {
            return doInt(leftNodeValue_, rightNodeValue_);
        } catch (ArithmeticException ex) {
            // implicit transferToInterpreterAndInvalidate()
            Lock lock = getLock();
            lock.lock();
            try {
                this.exclude_ = this.exclude_ | 0b1 /* add-exclude doInt(int, int) */;
                this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doInt(int, int) */;
            } finally {
                lock.unlock();
            }
            return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
        }
    }

    private Object execute_double_double1(int state_0, VirtualFrame frameValue) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0b111000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0b110100000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0b101100000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_0 & 0b1110000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0b1101000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0b1011000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state_0 & 0b111000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b110100000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state_0 & 0b10) != 0 /* is-state_0 doDouble(double, double) */;
        return doDouble(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_generic2(int state_0, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */ && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if (rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                try {
                    return doInt(leftNodeValue__, rightNodeValue__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-exclude doInt(int, int) */;
                        this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doInt(int, int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 1:double */, rightNodeValue_);
                return doDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b11000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) {
            if ((state_0 & 0b1000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
                if ((JSGuards.hasOverloadedOperators(leftNodeValue_) || JSGuards.hasOverloadedOperators(rightNodeValue_))) {
                    return doOverloaded(leftNodeValue_, rightNodeValue_, this.overloaded_overloadedOperatorNode_);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) {
                GenericData s4_ = this.generic_cache;
                if (s4_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(leftNodeValue_))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue_)))) {
                        return doGeneric(leftNodeValue_, rightNodeValue_, s4_.toNumericA_, s4_.toNumericB_, s4_.subtract_, s4_.mixedNumericTypes_);
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
        if ((state_0 & 0b11000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0b111000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0b110100000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0b101100000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_0 & 0b1110000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0b1101000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0b1011000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0b111000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b110100000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult()));
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double, double) */) {
            return doDouble(leftNodeValue_, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0b111000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0b110100000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ((state_0 & 0b1110000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) ? (Object) rightNodeValue_long : ((state_0 & 0b1101000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) ? (Object) rightNodeValue_int : (Object) rightNodeValue_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) {
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */) {
            try {
                return doInt(leftNodeValue_, rightNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-exclude doInt(int, int) */;
                    this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doInt(int, int) */;
                } finally {
                    lock.unlock();
                }
                return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b11110) == 0 /* only-active doInt(int, int) */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b11101) == 0 /* only-active doDouble(double, double) */ && ((state_0 & 0b11111) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */)) {
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
            int exclude = this.exclude_;
            if (((exclude & 0b1)) == 0 /* is-not-exclude doInt(int, int) */ && leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt(int, int) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return doInt(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b1 /* add-exclude doInt(int, int) */;
                            this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doInt(int, int) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doDouble(double, double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude doInt(int, int) */;
                        state_0 = state_0 & 0xfffffffe /* remove-state_0 doInt(int, int) */;
                        state_0 = (state_0 | (doubleCast0 << 5) /* set-implicit-state_0 0:double */);
                        state_0 = (state_0 | (doubleCast1 << 9) /* set-implicit-state_0 1:double */);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDouble(double, double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((exclude & 0b100)) == 0 /* is-not-exclude doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doBigInt(BigInt, BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigInt(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                this.overloaded_overloadedOperatorNode_ = super.insert((JSOverloadedBinaryNode.createNumeric(getOverloadedOperatorName())));
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */;
                lock.unlock();
                hasLock = false;
                return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_);
            }
            if ((!(JSGuards.hasOverloadedOperators(leftNodeValue))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue)))) {
                GenericData s4_ = super.insert(new GenericData());
                s4_.toNumericA_ = s4_.insertAccessor((JSToNumericNode.create()));
                s4_.toNumericB_ = s4_.insertAccessor((JSToNumericNode.create()));
                s4_.subtract_ = s4_.insertAccessor((copyRecursive()));
                s4_.mixedNumericTypes_ = (BranchProfile.create());
                MemoryFence.storeStore();
                this.generic_cache = s4_;
                this.exclude_ = exclude = exclude | 0b111 /* add-exclude doInt(int, int), doDouble(double, double), doBigInt(BigInt, BigInt) */;
                state_0 = state_0 & 0xfffffff8 /* remove-state_0 doInt(int, int), doDouble(double, double), doBigInt(BigInt, BigInt) */;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(leftNodeValue, rightNodeValue, s4_.toNumericA_, s4_.toNumericB_, s4_.subtract_, s4_.mixedNumericTypes_);
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
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doInt(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-exclude doDouble(double, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b100) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-exclude doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doOverloaded";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.overloaded_overloadedOperatorNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JavaScriptNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s4_ = this.generic_cache;
            if (s4_ != null) {
                cached.add(Arrays.asList(s4_.toNumericA_, s4_.toNumericB_, s4_.subtract_, s4_.mixedNumericTypes_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static JSSubtractNode create(boolean truncate, JavaScriptNode left, JavaScriptNode right) {
        return new JSSubtractNodeGen(truncate, left, right);
    }

    @GeneratedBy(JSSubtractNode.class)
    private static final class GenericData extends Node {

        @Child JSToNumericNode toNumericA_;
        @Child JSToNumericNode toNumericB_;
        @Child JavaScriptNode subtract_;
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
