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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.nodes.cast.JSToPrimitiveNode;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSAddConstantRightNumberNode.class)
public final class JSAddConstantRightNumberNodeGen extends JSAddConstantRightNumberNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private String stringNumber_rightString_;
    @Child private JSConcatStringsNode stringNumber_createLazyString_;
    @Child private JSOverloadedBinaryNode overloaded_overloadedOperatorNode_;
    @Child private PrimitiveConversionData primitiveConversion_cache;

    private JSAddConstantRightNumberNodeGen(JavaScriptNode left, Number rightValue, boolean truncate) {
        super(left, rightValue, truncate);
    }

    @Override
    public Object execute(Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) != 0 /* is-state_0 doIntTruncate(int) || doInt(int) || doIntOverflow(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            if ((state_0 & 0b1) != 0 /* is-state_0 doIntTruncate(int) */) {
                assert (truncate);
                assert (isInt);
                return doIntTruncate(operandNodeValue_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int) */) {
                assert (!(truncate));
                assert (isInt);
                try {
                    return doInt(operandNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-exclude doInt(int) */;
                        this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doIntOverflow(int) */) {
                assert (!(truncate));
                assert (isInt);
                try {
                    return doIntOverflow(operandNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10 /* add-exclude doIntOverflow(int) */;
                        this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 doIntOverflow(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue_);
                }
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            assert (isInt);
            try {
                return doSafeInteger(operandNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b100 /* add-exclude doSafeInteger(SafeInteger) */;
                    this.state_0_ = this.state_0_ & 0xfffffff7 /* remove-state_0 doSafeInteger(SafeInteger) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(operandNodeValue_);
            }
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doStringNumber(CharSequence, String, JSConcatStringsNode) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0b111000000000000) >>> 12 /* extract-implicit-state_0 0:CharSequence */, operandNodeValue)) {
            CharSequence operandNodeValue_ = JSTypesGen.asImplicitCharSequence((state_0 & 0b111000000000000) >>> 12 /* extract-implicit-state_0 0:CharSequence */, operandNodeValue);
            return doStringNumber(operandNodeValue_, this.stringNumber_rightString_, this.stringNumber_createLazyString_);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */ && operandNodeValue instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject operandNodeValue_ = (JSOverloadedOperatorsObject) operandNodeValue;
            return doOverloaded(operandNodeValue_, this.overloaded_overloadedOperatorNode_);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            PrimitiveConversionData s7_ = this.primitiveConversion_cache;
            if (s7_ != null) {
                if ((!(JSGuards.hasOverloadedOperators(operandNodeValue)))) {
                    return doPrimitiveConversion(operandNodeValue, s7_.toPrimitiveA_, s7_.toNumberA_, s7_.rightString_, s7_.createLazyString_, s7_.profileA_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) != 0 /* is-state_0 doIntTruncate(int) || doInt(int) || doIntOverflow(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            if ((state_0 & 0b1) != 0 /* is-state_0 doIntTruncate(int) */) {
                assert (truncate);
                assert (isInt);
                return doIntTruncate(operandNodeValue_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int) */) {
                assert (!(truncate));
                assert (isInt);
                try {
                    return doInt(operandNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-exclude doInt(int) */;
                        this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doIntOverflow(int) */) {
                assert (!(truncate));
                assert (isInt);
                try {
                    return doIntOverflow(operandNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10 /* add-exclude doIntOverflow(int) */;
                        this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 doIntOverflow(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue_);
                }
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            assert (isInt);
            try {
                return doSafeInteger(operandNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b100 /* add-exclude doSafeInteger(SafeInteger) */;
                    this.state_0_ = this.state_0_ & 0xfffffff7 /* remove-state_0 doSafeInteger(SafeInteger) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(operandNodeValue_);
            }
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doStringNumber(CharSequence, String, JSConcatStringsNode) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0b111000000000000) >>> 12 /* extract-implicit-state_0 0:CharSequence */, operandNodeValue)) {
            CharSequence operandNodeValue_ = JSTypesGen.asImplicitCharSequence((state_0 & 0b111000000000000) >>> 12 /* extract-implicit-state_0 0:CharSequence */, operandNodeValue);
            return doStringNumber(operandNodeValue_, this.stringNumber_rightString_, this.stringNumber_createLazyString_);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */ && operandNodeValue instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject operandNodeValue_ = (JSOverloadedOperatorsObject) operandNodeValue;
            return doOverloaded(operandNodeValue_, this.overloaded_overloadedOperatorNode_);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            PrimitiveConversionData s7_ = this.primitiveConversion_cache;
            if (s7_ != null) {
                if ((!(JSGuards.hasOverloadedOperators(operandNodeValue)))) {
                    return doPrimitiveConversion(operandNodeValue, s7_.toPrimitiveA_, s7_.toNumberA_, s7_.rightString_, s7_.createLazyString_, s7_.profileA_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11111000) == 0 /* only-active doIntTruncate(int) && doInt(int) && doIntOverflow(int) */ && ((state_0 & 0b11111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doStringNumber(CharSequence, String, JSConcatStringsNode) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */)) {
            return execute_int0(state_0, frameValue);
        } else if ((state_0 & 0b11101111) == 0 /* only-active doDouble(double) */ && ((state_0 & 0b11111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doStringNumber(CharSequence, String, JSConcatStringsNode) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */)) {
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doIntTruncate(int) */) {
            assert (truncate);
            assert (isInt);
            return doIntTruncate(operandNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int) */) {
            assert (!(truncate));
            assert (isInt);
            try {
                return doInt(operandNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-exclude doInt(int) */;
                    this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(operandNodeValue_);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doIntOverflow(int) */) {
            assert (!(truncate));
            assert (isInt);
            try {
                return doIntOverflow(operandNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b10 /* add-exclude doIntOverflow(int) */;
                    this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 doIntOverflow(int) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(operandNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    private Object execute_double1(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0b111000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doStringNumber(CharSequence, String, JSConcatStringsNode) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0b110100000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doStringNumber(CharSequence, String, JSConcatStringsNode) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0b101100000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doStringNumber(CharSequence, String, JSConcatStringsNode) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b10000) != 0 /* is-state_0 doDouble(double) */;
        return doDouble(operandNodeValue_);
    }

    private Object execute_generic2(int state_0, VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b111) != 0 /* is-state_0 doIntTruncate(int) || doInt(int) || doIntOverflow(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doIntTruncate(int) */) {
                assert (truncate);
                assert (isInt);
                return doIntTruncate(operandNodeValue__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int) */) {
                assert (!(truncate));
                assert (isInt);
                try {
                    return doInt(operandNodeValue__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-exclude doInt(int) */;
                        this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue__);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doIntOverflow(int) */) {
                assert (!(truncate));
                assert (isInt);
                try {
                    return doIntOverflow(operandNodeValue__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10 /* add-exclude doIntOverflow(int) */;
                        this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 doIntOverflow(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue__);
                }
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            assert (isInt);
            try {
                return doSafeInteger(operandNodeValue__);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b100 /* add-exclude doSafeInteger(SafeInteger) */;
                    this.state_0_ = this.state_0_ & 0xfffffff7 /* remove-state_0 doSafeInteger(SafeInteger) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(operandNodeValue__);
            }
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doStringNumber(CharSequence, String, JSConcatStringsNode) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0b111000000000000) >>> 12 /* extract-implicit-state_0 0:CharSequence */, operandNodeValue_)) {
            CharSequence operandNodeValue__ = JSTypesGen.asImplicitCharSequence((state_0 & 0b111000000000000) >>> 12 /* extract-implicit-state_0 0:CharSequence */, operandNodeValue_);
            return doStringNumber(operandNodeValue__, this.stringNumber_rightString_, this.stringNumber_createLazyString_);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */ && operandNodeValue_ instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject operandNodeValue__ = (JSOverloadedOperatorsObject) operandNodeValue_;
            return doOverloaded(operandNodeValue__, this.overloaded_overloadedOperatorNode_);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            PrimitiveConversionData s7_ = this.primitiveConversion_cache;
            if (s7_ != null) {
                if ((!(JSGuards.hasOverloadedOperators(operandNodeValue_)))) {
                    return doPrimitiveConversion(operandNodeValue_, s7_.toPrimitiveA_, s7_.toNumberA_, s7_.rightString_, s7_.createLazyString_, s7_.profileA_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11000100) != 0 /* is-state_0 doIntOverflow(int) || doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) || doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0b111000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doStringNumber(CharSequence, String, JSConcatStringsNode) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0b110100000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doStringNumber(CharSequence, String, JSConcatStringsNode) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0b101100000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doStringNumber(CharSequence, String, JSConcatStringsNode) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult()));
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double) */) {
            return doDouble(operandNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0b111000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doStringNumber(CharSequence, String, JSConcatStringsNode) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) ? (Object) operandNodeValue_long : ((state_0 & 0b110100000000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doStringNumber(CharSequence, String, JSConcatStringsNode) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) ? (Object) operandNodeValue_int : (Object) operandNodeValue_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11000100) != 0 /* is-state_0 doIntOverflow(int) || doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) || doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        if ((state_0 & 0b1) != 0 /* is-state_0 doIntTruncate(int) */) {
            assert (truncate);
            assert (isInt);
            return doIntTruncate(operandNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int) */) {
            assert (!(truncate));
            assert (isInt);
            try {
                return doInt(operandNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-exclude doInt(int) */;
                    this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int) */;
                } finally {
                    lock.unlock();
                }
                return JSTypesGen.expectInteger(executeAndSpecialize(operandNodeValue_));
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(operandNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b11111100) == 0 /* only-active doIntTruncate(int) && doInt(int) */ && ((state_0 & 0b11111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doStringNumber(CharSequence, String, JSConcatStringsNode) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b11101111) == 0 /* only-active doDouble(double) */ && ((state_0 & 0b11111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doStringNumber(CharSequence, String, JSConcatStringsNode) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */)) {
                executeDouble(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                if ((truncate) && (isInt)) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doIntTruncate(int) */;
                    lock.unlock();
                    hasLock = false;
                    return doIntTruncate(operandNodeValue_);
                }
                if (((exclude & 0b1)) == 0 /* is-not-exclude doInt(int) */) {
                    if ((!(truncate)) && (isInt)) {
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doInt(int) */;
                        try {
                            lock.unlock();
                            hasLock = false;
                            return doInt(operandNodeValue_);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b1 /* add-exclude doInt(int) */;
                                this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doInt(int) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(operandNodeValue_);
                        }
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-exclude doIntOverflow(int) */) {
                    if ((!(truncate)) && (isInt)) {
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doIntOverflow(int) */;
                        try {
                            lock.unlock();
                            hasLock = false;
                            return doIntOverflow(operandNodeValue_);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b10 /* add-exclude doIntOverflow(int) */;
                                this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 doIntOverflow(int) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(operandNodeValue_);
                        }
                    }
                }
            }
            if (((exclude & 0b100)) == 0 /* is-not-exclude doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
                SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
                if ((isInt)) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doSafeInteger(SafeInteger) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return doSafeInteger(operandNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-exclude doSafeInteger(SafeInteger) */;
                            this.state_0_ = this.state_0_ & 0xfffffff7 /* remove-state_0 doSafeInteger(SafeInteger) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(operandNodeValue_);
                    }
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-exclude doDouble(double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    state_0 = (state_0 | (doubleCast0 << 8) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(operandNodeValue_);
                }
            }
            if (((exclude & 0b10000)) == 0 /* is-not-exclude doStringNumber(CharSequence, String, JSConcatStringsNode) */) {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(operandNodeValue)) != 0) {
                    CharSequence operandNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, operandNodeValue);
                    this.stringNumber_rightString_ = (rightValueToString());
                    this.stringNumber_createLazyString_ = super.insert((JSConcatStringsNode.create()));
                    state_0 = (state_0 | (charSequenceCast0 << 12) /* set-implicit-state_0 0:CharSequence */);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doStringNumber(CharSequence, String, JSConcatStringsNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doStringNumber(operandNodeValue_, this.stringNumber_rightString_, this.stringNumber_createLazyString_);
                }
            }
            if (operandNodeValue instanceof JSOverloadedOperatorsObject) {
                JSOverloadedOperatorsObject operandNodeValue_ = (JSOverloadedOperatorsObject) operandNodeValue;
                this.overloaded_overloadedOperatorNode_ = super.insert((JSOverloadedBinaryNode.createHintNone(getOverloadedOperatorName())));
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */;
                lock.unlock();
                hasLock = false;
                return doOverloaded(operandNodeValue_, this.overloaded_overloadedOperatorNode_);
            }
            if ((!(JSGuards.hasOverloadedOperators(operandNodeValue)))) {
                PrimitiveConversionData s7_ = super.insert(new PrimitiveConversionData());
                s7_.toPrimitiveA_ = s7_.insertAccessor((JSToPrimitiveNode.createHintNone()));
                s7_.toNumberA_ = s7_.insertAccessor((JSToNumberNode.create()));
                s7_.rightString_ = (rightValueToString());
                s7_.createLazyString_ = s7_.insertAccessor((JSConcatStringsNode.create()));
                s7_.profileA_ = (ConditionProfile.createBinaryProfile());
                MemoryFence.storeStore();
                this.primitiveConversion_cache = s7_;
                this.exclude_ = exclude = exclude | 0b11001 /* add-exclude doInt(int), doDouble(double), doStringNumber(CharSequence, String, JSConcatStringsNode) */;
                state_0 = state_0 & 0xffffffcd /* remove-state_0 doInt(int), doDouble(double), doStringNumber(CharSequence, String, JSConcatStringsNode) */;
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doPrimitiveConversion(operandNodeValue, s7_.toPrimitiveA_, s7_.toNumberA_, s7_.rightString_, s7_.createLazyString_, s7_.profileA_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.operandNode}, operandNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b11111111) & ((state_0 & 0b11111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[9];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doIntTruncate";
        if ((state_0 & 0b1) != 0 /* is-state_0 doIntTruncate(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doInt(int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doIntOverflow";
        if ((state_0 & 0b100) != 0 /* is-state_0 doIntOverflow(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-exclude doIntOverflow(int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-exclude doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doDouble(double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doStringNumber";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doStringNumber(CharSequence, String, JSConcatStringsNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.stringNumber_rightString_, this.stringNumber_createLazyString_));
            s[2] = cached;
        } else if ((exclude & 0b10000) != 0 /* is-exclude doStringNumber(CharSequence, String, JSConcatStringsNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doOverloaded";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.overloaded_overloadedOperatorNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doPrimitiveConversion";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            PrimitiveConversionData s7_ = this.primitiveConversion_cache;
            if (s7_ != null) {
                cached.add(Arrays.asList(s7_.toPrimitiveA_, s7_.toNumberA_, s7_.rightString_, s7_.createLazyString_, s7_.profileA_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        return Provider.create(data);
    }

    public static JSAddConstantRightNumberNode create(JavaScriptNode left, Number rightValue, boolean truncate) {
        return new JSAddConstantRightNumberNodeGen(left, rightValue, truncate);
    }

    @GeneratedBy(JSAddConstantRightNumberNode.class)
    private static final class PrimitiveConversionData extends Node {

        @Child JSToPrimitiveNode toPrimitiveA_;
        @Child JSToNumberNode toNumberA_;
        @CompilationFinal String rightString_;
        @Child JSConcatStringsNode createLazyString_;
        @CompilationFinal ConditionProfile profileA_;

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
