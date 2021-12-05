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
import com.oracle.truffle.js.nodes.cast.JSDoubleToStringNode;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.nodes.cast.JSToPrimitiveNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSAddNode.class)
public final class JSAddNodeGen extends JSAddNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSConcatStringsNode concatStringsNode;
    @Child private JSDoubleToStringNode doubleToStringNode;
    @Child private JSOverloadedBinaryNode overloaded_overloadedOperatorNode_;
    @Child private PrimitiveConversionData primitiveConversion_cache;

    private JSAddNodeGen(boolean truncate, JavaScriptNode left, JavaScriptNode right) {
        super(truncate, left, right);
    }

    @Override
    public Object execute(Object leftNodeValue, Object rightNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1111) != 0 /* is-state_0 doIntTruncate(int, int) || doInt(int, int) || doIntOverflow(int, int) || doIntSafeInteger(int, SafeInteger) */ && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if ((state_0 & 0b111) != 0 /* is-state_0 doIntTruncate(int, int) || doInt(int, int) || doIntOverflow(int, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                if ((state_0 & 0b1) != 0 /* is-state_0 doIntTruncate(int, int) */) {
                    assert (truncate);
                    return JSAddNode.doIntTruncate(leftNodeValue_, rightNodeValue_);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int, int) */) {
                    assert (!(truncate));
                    try {
                        return JSAddNode.doInt(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b10 /* add-exclude doInt(int, int) */;
                            this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int, int) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doIntOverflow(int, int) */) {
                    assert (!(truncate));
                    try {
                        return JSAddNode.doIntOverflow(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-exclude doIntOverflow(int, int) */;
                            this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 doIntOverflow(int, int) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doIntSafeInteger(int, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
                SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                try {
                    return JSAddNode.doIntSafeInteger(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1000 /* add-exclude doIntSafeInteger(int, SafeInteger) */;
                        this.state_0_ = this.state_0_ & 0xfffffff7 /* remove-state_0 doIntSafeInteger(int, SafeInteger) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if ((state_0 & 0b110000) != 0 /* is-state_0 doSafeIntegerInt(SafeInteger, int) || doSafeInteger(SafeInteger, SafeInteger) */ && leftNodeValue instanceof SafeInteger) {
            SafeInteger leftNodeValue_ = (SafeInteger) leftNodeValue;
            if ((state_0 & 0b10000) != 0 /* is-state_0 doSafeIntegerInt(SafeInteger, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                try {
                    return JSAddNode.doSafeIntegerInt(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10000 /* add-exclude doSafeIntegerInt(SafeInteger, int) */;
                        this.state_0_ = this.state_0_ & 0xffffffef /* remove-state_0 doSafeIntegerInt(SafeInteger, int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
                SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                try {
                    return JSAddNode.doSafeInteger(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b100000 /* add-exclude doSafeInteger(SafeInteger, SafeInteger) */;
                        this.state_0_ = this.state_0_ & 0xffffffdf /* remove-state_0 doSafeInteger(SafeInteger, SafeInteger) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x78000) >>> 15 /* extract-implicit-state_0 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0x78000) >>> 15 /* extract-implicit-state_0 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((state_0 & 0x780000) >>> 19 /* extract-implicit-state_0 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0x780000) >>> 19 /* extract-implicit-state_0 1:double */, rightNodeValue);
                return JSAddNode.doDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doString(CharSequence, CharSequence, JSConcatStringsNode) || doStringInt(CharSequence, int) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x3800000) >>> 23 /* extract-implicit-state_0 0:CharSequence */, leftNodeValue)) {
            CharSequence leftNodeValue_ = JSTypesGen.asImplicitCharSequence((state_0 & 0x3800000) >>> 23 /* extract-implicit-state_0 0:CharSequence */, leftNodeValue);
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doString(CharSequence, CharSequence, JSConcatStringsNode) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue)) {
                CharSequence rightNodeValue_ = JSTypesGen.asImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue);
                return doString(leftNodeValue_, rightNodeValue_, this.concatStringsNode);
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doStringInt(CharSequence, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return doStringInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doIntString(int, CharSequence) */ && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if (JSTypesGen.isImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue)) {
                CharSequence rightNodeValue_ = JSTypesGen.asImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue);
                return doIntString(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x3800000) >>> 23 /* extract-implicit-state_0 0:CharSequence */, leftNodeValue)) {
            CharSequence leftNodeValue_ = JSTypesGen.asImplicitCharSequence((state_0 & 0x3800000) >>> 23 /* extract-implicit-state_0 0:CharSequence */, leftNodeValue);
            if ((JSGuards.isNumber(rightNodeValue))) {
                return doStringNumber(leftNodeValue_, rightNodeValue, this.concatStringsNode, this.doubleToStringNode);
            }
        }
        if ((state_0 & 0b111000000000000) != 0 /* is-state_0 doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) || doOverloaded(Object, Object, JSOverloadedBinaryNode) || doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue)) {
                CharSequence rightNodeValue_ = JSTypesGen.asImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue);
                if ((JSGuards.isNumber(leftNodeValue))) {
                    return doNumberString(leftNodeValue, rightNodeValue_, this.concatStringsNode, this.doubleToStringNode);
                }
            }
            if ((state_0 & 0b110000000000000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
                    if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                        return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_);
                    }
                }
                if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                    PrimitiveConversionData s14_ = this.primitiveConversion_cache;
                    if (s14_ != null) {
                        if ((!(JSGuards.hasOverloadedOperators(leftNodeValue))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue)))) {
                            return doPrimitiveConversion(leftNodeValue, rightNodeValue, s14_.toPrimitiveA_, s14_.toPrimitiveB_, s14_.toNumericA_, s14_.toNumericB_, s14_.toStringA_, s14_.toStringB_, s14_.profileA_, s14_.profileB_, s14_.add_, s14_.mixedNumericTypes_);
                        }
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
        if ((state_0 & 0b111111111111000) == 0 /* only-active doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
            return execute_int_int0(state_0, frameValue);
        } else if ((state_0 & 0b111111110111111) == 0 /* only-active doDouble(double, double) */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
            return execute_double_double1(state_0, frameValue);
        } else if ((state_0 & 0b111101111110111) == 0 /* only-active doIntSafeInteger(int, SafeInteger) && doIntString(int, CharSequence) */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
            return execute_int2(state_0, frameValue);
        } else if ((state_0 & 0b111110111101111) == 0 /* only-active doSafeIntegerInt(SafeInteger, int) && doStringInt(CharSequence, int) */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
            return execute_int3(state_0, frameValue);
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doIntTruncate(int, int) */) {
            assert (truncate);
            return JSAddNode.doIntTruncate(leftNodeValue_, rightNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int, int) */) {
            assert (!(truncate));
            try {
                return JSAddNode.doInt(leftNodeValue_, rightNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b10 /* add-exclude doInt(int, int) */;
                    this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int, int) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doIntOverflow(int, int) */) {
            assert (!(truncate));
            try {
                return JSAddNode.doIntOverflow(leftNodeValue_, rightNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b100 /* add-exclude doIntOverflow(int, int) */;
                    this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 doIntOverflow(int, int) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
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
            if ((state_0 & 0x70000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0x68000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0x58000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0x78000) >>> 15 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_0 & 0x700000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0x680000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0x580000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0x780000) >>> 19 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state_0 & 0x70000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0x68000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state_0 & 0b1000000) != 0 /* is-state_0 doDouble(double, double) */;
        return JSAddNode.doDouble(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_int2(int state_0, VirtualFrame frameValue) {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b1000) != 0 /* is-state_0 doIntSafeInteger(int, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
            SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
            try {
                return JSAddNode.doIntSafeInteger(leftNodeValue_, rightNodeValue__);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1000 /* add-exclude doIntSafeInteger(int, SafeInteger) */;
                    this.state_0_ = this.state_0_ & 0xfffffff7 /* remove-state_0 doIntSafeInteger(int, SafeInteger) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(leftNodeValue_, rightNodeValue__);
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doIntString(int, CharSequence) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue_)) {
            CharSequence rightNodeValue__ = JSTypesGen.asImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue_);
            return doIntString(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_int3(int state_0, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doSafeIntegerInt(SafeInteger, int) */ && leftNodeValue_ instanceof SafeInteger) {
            SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
            try {
                return JSAddNode.doSafeIntegerInt(leftNodeValue__, rightNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b10000 /* add-exclude doSafeIntegerInt(SafeInteger, int) */;
                    this.state_0_ = this.state_0_ & 0xffffffef /* remove-state_0 doSafeIntegerInt(SafeInteger, int) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(leftNodeValue__, rightNodeValue_);
            }
        }
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doStringInt(CharSequence, int) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x3800000) >>> 23 /* extract-implicit-state_0 0:CharSequence */, leftNodeValue_)) {
            CharSequence leftNodeValue__ = JSTypesGen.asImplicitCharSequence((state_0 & 0x3800000) >>> 23 /* extract-implicit-state_0 0:CharSequence */, leftNodeValue_);
            return doStringInt(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_generic4(int state_0, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b1111) != 0 /* is-state_0 doIntTruncate(int, int) || doInt(int, int) || doIntOverflow(int, int) || doIntSafeInteger(int, SafeInteger) */ && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if ((state_0 & 0b111) != 0 /* is-state_0 doIntTruncate(int, int) || doInt(int, int) || doIntOverflow(int, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doIntTruncate(int, int) */) {
                    assert (truncate);
                    return JSAddNode.doIntTruncate(leftNodeValue__, rightNodeValue__);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int, int) */) {
                    assert (!(truncate));
                    try {
                        return JSAddNode.doInt(leftNodeValue__, rightNodeValue__);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b10 /* add-exclude doInt(int, int) */;
                            this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int, int) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doIntOverflow(int, int) */) {
                    assert (!(truncate));
                    try {
                        return JSAddNode.doIntOverflow(leftNodeValue__, rightNodeValue__);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-exclude doIntOverflow(int, int) */;
                            this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 doIntOverflow(int, int) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                    }
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doIntSafeInteger(int, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
                SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
                try {
                    return JSAddNode.doIntSafeInteger(leftNodeValue__, rightNodeValue__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1000 /* add-exclude doIntSafeInteger(int, SafeInteger) */;
                        this.state_0_ = this.state_0_ & 0xfffffff7 /* remove-state_0 doIntSafeInteger(int, SafeInteger) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if ((state_0 & 0b110000) != 0 /* is-state_0 doSafeIntegerInt(SafeInteger, int) || doSafeInteger(SafeInteger, SafeInteger) */ && leftNodeValue_ instanceof SafeInteger) {
            SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
            if ((state_0 & 0b10000) != 0 /* is-state_0 doSafeIntegerInt(SafeInteger, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                try {
                    return JSAddNode.doSafeIntegerInt(leftNodeValue__, rightNodeValue__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10000 /* add-exclude doSafeIntegerInt(SafeInteger, int) */;
                        this.state_0_ = this.state_0_ & 0xffffffef /* remove-state_0 doSafeIntegerInt(SafeInteger, int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
                SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
                try {
                    return JSAddNode.doSafeInteger(leftNodeValue__, rightNodeValue__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b100000 /* add-exclude doSafeInteger(SafeInteger, SafeInteger) */;
                        this.state_0_ = this.state_0_ & 0xffffffdf /* remove-state_0 doSafeInteger(SafeInteger, SafeInteger) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x78000) >>> 15 /* extract-implicit-state_0 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0x78000) >>> 15 /* extract-implicit-state_0 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((state_0 & 0x780000) >>> 19 /* extract-implicit-state_0 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0x780000) >>> 19 /* extract-implicit-state_0 1:double */, rightNodeValue_);
                return JSAddNode.doDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doString(CharSequence, CharSequence, JSConcatStringsNode) || doStringInt(CharSequence, int) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x3800000) >>> 23 /* extract-implicit-state_0 0:CharSequence */, leftNodeValue_)) {
            CharSequence leftNodeValue__ = JSTypesGen.asImplicitCharSequence((state_0 & 0x3800000) >>> 23 /* extract-implicit-state_0 0:CharSequence */, leftNodeValue_);
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doString(CharSequence, CharSequence, JSConcatStringsNode) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue_)) {
                CharSequence rightNodeValue__ = JSTypesGen.asImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue_);
                return doString(leftNodeValue__, rightNodeValue__, this.concatStringsNode);
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doStringInt(CharSequence, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return doStringInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doIntString(int, CharSequence) */ && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if (JSTypesGen.isImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue_)) {
                CharSequence rightNodeValue__ = JSTypesGen.asImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue_);
                return doIntString(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x3800000) >>> 23 /* extract-implicit-state_0 0:CharSequence */, leftNodeValue_)) {
            CharSequence leftNodeValue__ = JSTypesGen.asImplicitCharSequence((state_0 & 0x3800000) >>> 23 /* extract-implicit-state_0 0:CharSequence */, leftNodeValue_);
            if ((JSGuards.isNumber(rightNodeValue_))) {
                return doStringNumber(leftNodeValue__, rightNodeValue_, this.concatStringsNode, this.doubleToStringNode);
            }
        }
        if ((state_0 & 0b111000000000000) != 0 /* is-state_0 doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) || doOverloaded(Object, Object, JSOverloadedBinaryNode) || doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue_)) {
                CharSequence rightNodeValue__ = JSTypesGen.asImplicitCharSequence((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 1:CharSequence */, rightNodeValue_);
                if ((JSGuards.isNumber(leftNodeValue_))) {
                    return doNumberString(leftNodeValue_, rightNodeValue__, this.concatStringsNode, this.doubleToStringNode);
                }
            }
            if ((state_0 & 0b110000000000000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) || doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
                    if ((JSGuards.hasOverloadedOperators(leftNodeValue_) || JSGuards.hasOverloadedOperators(rightNodeValue_))) {
                        return doOverloaded(leftNodeValue_, rightNodeValue_, this.overloaded_overloadedOperatorNode_);
                    }
                }
                if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                    PrimitiveConversionData s14_ = this.primitiveConversion_cache;
                    if (s14_ != null) {
                        if ((!(JSGuards.hasOverloadedOperators(leftNodeValue_))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue_)))) {
                            return doPrimitiveConversion(leftNodeValue_, rightNodeValue_, s14_.toPrimitiveA_, s14_.toPrimitiveB_, s14_.toNumericA_, s14_.toNumericB_, s14_.toStringA_, s14_.toStringB_, s14_.profileA_, s14_.profileB_, s14_.add_, s14_.mixedNumericTypes_);
                        }
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
        if ((state_0 & 0b110000000000100) != 0 /* is-state_0 doIntOverflow(int, int) || doOverloaded(Object, Object, JSOverloadedBinaryNode) || doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0x70000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0x68000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0x58000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0x78000) >>> 15 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_0 & 0x700000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0x680000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0x580000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0x780000) >>> 19 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0x70000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0x68000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult()));
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doDouble(double, double) */) {
            return JSAddNode.doDouble(leftNodeValue_, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0x70000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) ? (Object) leftNodeValue_long : ((state_0 & 0x68000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ((state_0 & 0x700000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) ? (Object) rightNodeValue_long : ((state_0 & 0x680000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) ? (Object) rightNodeValue_int : (Object) rightNodeValue_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b110000000000100) != 0 /* is-state_0 doIntOverflow(int, int) || doOverloaded(Object, Object, JSOverloadedBinaryNode) || doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doIntTruncate(int, int) */) {
            assert (truncate);
            return JSAddNode.doIntTruncate(leftNodeValue_, rightNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int, int) */) {
            assert (!(truncate));
            try {
                return JSAddNode.doInt(leftNodeValue_, rightNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b10 /* add-exclude doInt(int, int) */;
                    this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int, int) */;
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
            if ((state_0 & 0b111111111111100) == 0 /* only-active doIntTruncate(int, int) && doInt(int, int) */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b111111110111111) == 0 /* only-active doDouble(double, double) */ && ((state_0 & 0b111111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doOverloaded(Object, Object, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */)) {
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
            if (leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    if (((exclude & 0b1)) == 0 /* is-not-exclude doIntTruncate(int, int) */) {
                        if ((truncate)) {
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doIntTruncate(int, int) */;
                            lock.unlock();
                            hasLock = false;
                            return JSAddNode.doIntTruncate(leftNodeValue_, rightNodeValue_);
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-exclude doInt(int, int) */) {
                        if ((!(truncate))) {
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doInt(int, int) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return JSAddNode.doInt(leftNodeValue_, rightNodeValue_);
                            } catch (ArithmeticException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b10 /* add-exclude doInt(int, int) */;
                                    this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int, int) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                            }
                        }
                    }
                    if (((exclude & 0b100)) == 0 /* is-not-exclude doIntOverflow(int, int) */) {
                        if ((!(truncate))) {
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doIntOverflow(int, int) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return JSAddNode.doIntOverflow(leftNodeValue_, rightNodeValue_);
                            } catch (ArithmeticException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b100 /* add-exclude doIntOverflow(int, int) */;
                                    this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 doIntOverflow(int, int) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                            }
                        }
                    }
                }
                if (((exclude & 0b1000)) == 0 /* is-not-exclude doIntSafeInteger(int, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
                    SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doIntSafeInteger(int, SafeInteger) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return JSAddNode.doIntSafeInteger(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b1000 /* add-exclude doIntSafeInteger(int, SafeInteger) */;
                            this.state_0_ = this.state_0_ & 0xfffffff7 /* remove-state_0 doIntSafeInteger(int, SafeInteger) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (leftNodeValue instanceof SafeInteger) {
                SafeInteger leftNodeValue_ = (SafeInteger) leftNodeValue;
                if (((exclude & 0b10000)) == 0 /* is-not-exclude doSafeIntegerInt(SafeInteger, int) */ && rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doSafeIntegerInt(SafeInteger, int) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return JSAddNode.doSafeIntegerInt(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b10000 /* add-exclude doSafeIntegerInt(SafeInteger, int) */;
                            this.state_0_ = this.state_0_ & 0xffffffef /* remove-state_0 doSafeIntegerInt(SafeInteger, int) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((exclude & 0b100000)) == 0 /* is-not-exclude doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
                    SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doSafeInteger(SafeInteger, SafeInteger) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return JSAddNode.doSafeInteger(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100000 /* add-exclude doSafeInteger(SafeInteger, SafeInteger) */;
                            this.state_0_ = this.state_0_ & 0xffffffdf /* remove-state_0 doSafeInteger(SafeInteger, SafeInteger) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((exclude & 0b1000000)) == 0 /* is-not-exclude doDouble(double, double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state_0 = (state_0 | (doubleCast0 << 15) /* set-implicit-state_0 0:double */);
                        state_0 = (state_0 | (doubleCast1 << 19) /* set-implicit-state_0 1:double */);
                        this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doDouble(double, double) */;
                        lock.unlock();
                        hasLock = false;
                        return JSAddNode.doDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((exclude & 0b10000000)) == 0 /* is-not-exclude doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doBigInt(BigInt, BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigInt(leftNodeValue_, rightNodeValue_);
                }
            }
            {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(leftNodeValue)) != 0) {
                    CharSequence leftNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, leftNodeValue);
                    if (((exclude & 0b100000000)) == 0 /* is-not-exclude doString(CharSequence, CharSequence, JSConcatStringsNode) */) {
                        int charSequenceCast1;
                        if ((charSequenceCast1 = JSTypesGen.specializeImplicitCharSequence(rightNodeValue)) != 0) {
                            CharSequence rightNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast1, rightNodeValue);
                            this.concatStringsNode = super.insert(this.concatStringsNode == null ? ((JSConcatStringsNode.create())) : this.concatStringsNode);
                            state_0 = (state_0 | (charSequenceCast0 << 23) /* set-implicit-state_0 0:CharSequence */);
                            state_0 = (state_0 | (charSequenceCast1 << 26) /* set-implicit-state_0 1:CharSequence */);
                            this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doString(CharSequence, CharSequence, JSConcatStringsNode) */;
                            lock.unlock();
                            hasLock = false;
                            return doString(leftNodeValue_, rightNodeValue_, this.concatStringsNode);
                        }
                    }
                    if (((exclude & 0b1000000000)) == 0 /* is-not-exclude doStringInt(CharSequence, int) */ && rightNodeValue instanceof Integer) {
                        int rightNodeValue_ = (int) rightNodeValue;
                        state_0 = (state_0 | (charSequenceCast0 << 23) /* set-implicit-state_0 0:CharSequence */);
                        this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doStringInt(CharSequence, int) */;
                        lock.unlock();
                        hasLock = false;
                        return doStringInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((exclude & 0b10000000000)) == 0 /* is-not-exclude doIntString(int, CharSequence) */ && leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                int charSequenceCast1;
                if ((charSequenceCast1 = JSTypesGen.specializeImplicitCharSequence(rightNodeValue)) != 0) {
                    CharSequence rightNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast1, rightNodeValue);
                    state_0 = (state_0 | (charSequenceCast1 << 26) /* set-implicit-state_0 1:CharSequence */);
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doIntString(int, CharSequence) */;
                    lock.unlock();
                    hasLock = false;
                    return doIntString(leftNodeValue_, rightNodeValue_);
                }
            }
            if (((exclude & 0b100000000000)) == 0 /* is-not-exclude doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) */) {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(leftNodeValue)) != 0) {
                    CharSequence leftNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, leftNodeValue);
                    if ((JSGuards.isNumber(rightNodeValue))) {
                        this.concatStringsNode = super.insert(this.concatStringsNode == null ? ((JSConcatStringsNode.create())) : this.concatStringsNode);
                        this.doubleToStringNode = super.insert(this.doubleToStringNode == null ? ((JSDoubleToStringNode.create())) : this.doubleToStringNode);
                        state_0 = (state_0 | (charSequenceCast0 << 23) /* set-implicit-state_0 0:CharSequence */);
                        this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doStringNumber(leftNodeValue_, rightNodeValue, this.concatStringsNode, this.doubleToStringNode);
                    }
                }
            }
            if (((exclude & 0b1000000000000)) == 0 /* is-not-exclude doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */) {
                int charSequenceCast1;
                if ((charSequenceCast1 = JSTypesGen.specializeImplicitCharSequence(rightNodeValue)) != 0) {
                    CharSequence rightNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast1, rightNodeValue);
                    if ((JSGuards.isNumber(leftNodeValue))) {
                        this.concatStringsNode = super.insert(this.concatStringsNode == null ? ((JSConcatStringsNode.create())) : this.concatStringsNode);
                        this.doubleToStringNode = super.insert(this.doubleToStringNode == null ? ((JSDoubleToStringNode.create())) : this.doubleToStringNode);
                        state_0 = (state_0 | (charSequenceCast1 << 26) /* set-implicit-state_0 1:CharSequence */);
                        this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doNumberString(leftNodeValue, rightNodeValue_, this.concatStringsNode, this.doubleToStringNode);
                    }
                }
            }
            if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                this.overloaded_overloadedOperatorNode_ = super.insert((JSOverloadedBinaryNode.createHintNone(getOverloadedOperatorName())));
                this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */;
                lock.unlock();
                hasLock = false;
                return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_);
            }
            if ((!(JSGuards.hasOverloadedOperators(leftNodeValue))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue)))) {
                PrimitiveConversionData s14_ = super.insert(new PrimitiveConversionData());
                s14_.toPrimitiveA_ = s14_.insertAccessor((JSToPrimitiveNode.createHintNone()));
                s14_.toPrimitiveB_ = s14_.insertAccessor((JSToPrimitiveNode.createHintNone()));
                s14_.toNumericA_ = s14_.insertAccessor((JSToNumericNode.create()));
                s14_.toNumericB_ = s14_.insertAccessor((JSToNumericNode.create()));
                s14_.toStringA_ = s14_.insertAccessor((JSToStringNode.create()));
                s14_.toStringB_ = s14_.insertAccessor((JSToStringNode.create()));
                s14_.profileA_ = (ConditionProfile.createBinaryProfile());
                s14_.profileB_ = (ConditionProfile.createBinaryProfile());
                s14_.add_ = s14_.insertAccessor((copyRecursive()));
                s14_.mixedNumericTypes_ = (BranchProfile.create());
                MemoryFence.storeStore();
                this.primitiveConversion_cache = s14_;
                this.exclude_ = exclude = exclude | 0b1111111111111 /* add-exclude doIntTruncate(int, int), doInt(int, int), doIntOverflow(int, int), doIntSafeInteger(int, SafeInteger), doSafeIntegerInt(SafeInteger, int), doSafeInteger(SafeInteger, SafeInteger), doDouble(double, double), doBigInt(BigInt, BigInt), doString(CharSequence, CharSequence, JSConcatStringsNode), doStringInt(CharSequence, int), doIntString(int, CharSequence), doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode), doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */;
                state_0 = state_0 & 0xffffe000 /* remove-state_0 doIntTruncate(int, int), doInt(int, int), doIntOverflow(int, int), doIntSafeInteger(int, SafeInteger), doSafeIntegerInt(SafeInteger, int), doSafeInteger(SafeInteger, SafeInteger), doDouble(double, double), doBigInt(BigInt, BigInt), doString(CharSequence, CharSequence, JSConcatStringsNode), doStringInt(CharSequence, int), doIntString(int, CharSequence), doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode), doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */;
                this.state_0_ = state_0 = state_0 | 0b100000000000000 /* add-state_0 doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doPrimitiveConversion(leftNodeValue, rightNodeValue, s14_.toPrimitiveA_, s14_.toPrimitiveB_, s14_.toNumericA_, s14_.toNumericB_, s14_.toStringA_, s14_.toStringB_, s14_.profileA_, s14_.profileB_, s14_.add_, s14_.mixedNumericTypes_);
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
        if ((state_0 & 0b111111111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b111111111111111) & ((state_0 & 0b111111111111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[16];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doIntTruncate";
        if ((state_0 & 0b1) != 0 /* is-state_0 doIntTruncate(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doIntTruncate(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-exclude doInt(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doIntOverflow";
        if ((state_0 & 0b100) != 0 /* is-state_0 doIntOverflow(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-exclude doIntOverflow(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doIntSafeInteger";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doIntSafeInteger(int, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doIntSafeInteger(int, SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doSafeIntegerInt";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doSafeIntegerInt(SafeInteger, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-exclude doSafeIntegerInt(SafeInteger, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doSafeInteger(SafeInteger, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000) != 0 /* is-exclude doSafeInteger(SafeInteger, SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doDouble(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000000) != 0 /* is-exclude doDouble(double, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000000) != 0 /* is-exclude doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doString(CharSequence, CharSequence, JSConcatStringsNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.concatStringsNode));
            s[2] = cached;
        } else if ((exclude & 0b100000000) != 0 /* is-exclude doString(CharSequence, CharSequence, JSConcatStringsNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doStringInt";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doStringInt(CharSequence, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000000000) != 0 /* is-exclude doStringInt(CharSequence, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doIntString";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doIntString(int, CharSequence) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000000000) != 0 /* is-exclude doIntString(int, CharSequence) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doStringNumber";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.concatStringsNode, this.doubleToStringNode));
            s[2] = cached;
        } else if ((exclude & 0b100000000000) != 0 /* is-exclude doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doNumberString";
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.concatStringsNode, this.doubleToStringNode));
            s[2] = cached;
        } else if ((exclude & 0b1000000000000) != 0 /* is-exclude doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doOverloaded";
        if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.overloaded_overloadedOperatorNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        s = new Object[3];
        s[0] = "doPrimitiveConversion";
        if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            PrimitiveConversionData s14_ = this.primitiveConversion_cache;
            if (s14_ != null) {
                cached.add(Arrays.asList(s14_.toPrimitiveA_, s14_.toPrimitiveB_, s14_.toNumericA_, s14_.toNumericB_, s14_.toStringA_, s14_.toStringB_, s14_.profileA_, s14_.profileB_, s14_.add_, s14_.mixedNumericTypes_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[15] = s;
        return Provider.create(data);
    }

    public static JSAddNode create(boolean truncate, JavaScriptNode left, JavaScriptNode right) {
        return new JSAddNodeGen(truncate, left, right);
    }

    @GeneratedBy(JSAddNode.class)
    private static final class PrimitiveConversionData extends Node {

        @Child JSToPrimitiveNode toPrimitiveA_;
        @Child JSToPrimitiveNode toPrimitiveB_;
        @Child JSToNumericNode toNumericA_;
        @Child JSToNumericNode toNumericB_;
        @Child JSToStringNode toStringA_;
        @Child JSToStringNode toStringB_;
        @CompilationFinal ConditionProfile profileA_;
        @CompilationFinal ConditionProfile profileB_;
        @Child JSAddNode add_;
        @CompilationFinal BranchProfile mixedNumericTypes_;

        PrimitiveConversionData() {
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
