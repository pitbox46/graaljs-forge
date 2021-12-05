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
import com.oracle.truffle.js.nodes.cast.JSToInt32Node;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSBitwiseAndConstantNode.class)
public final class JSBitwiseAndConstantNodeGen extends JSBitwiseAndConstantNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSToInt32Node double_leftInt32_;
    @Child private JSOverloadedBinaryNode overloaded_overloadedOperatorNode_;
    @Child private GenericData generic_cache;
    @Child private JSToNumericNode genericBigIntCase_toNumeric_;
    @CompilationFinal private ConditionProfile genericBigIntCase_profileIsBigInt_;

    private JSBitwiseAndConstantNodeGen(JavaScriptNode left, Object rightValue) {
        super(left, rightValue);
    }

    @Override
    public Object executeObject(Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            assert (isInt);
            return doInteger(operandNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            assert (isInt);
            return doSafeInteger(operandNodeValue_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue);
            assert (isInt);
            return doDouble(operandNodeValue_, this.double_leftInt32_);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            assert (!(isInt));
            return doBigInt(operandNodeValue_);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */ && operandNodeValue instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject operandNodeValue_ = (JSOverloadedOperatorsObject) operandNodeValue;
            return doOverloaded(operandNodeValue_, this.overloaded_overloadedOperatorNode_);
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) || doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) */) {
                GenericData s8_ = this.generic_cache;
                if (s8_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(operandNodeValue)))) {
                        assert (isInt);
                        return doGeneric(operandNodeValue, s8_.toNumeric_, s8_.profileIsBigInt_, s8_.innerAndNode_);
                    }
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                if ((!(JSGuards.hasOverloadedOperators(operandNodeValue)))) {
                    assert (!(isInt()));
                    return doGenericBigIntCase(operandNodeValue, this.genericBigIntCase_toNumeric_, this.genericBigIntCase_profileIsBigInt_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            assert (isInt);
            return doInteger(operandNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            assert (isInt);
            return doSafeInteger(operandNodeValue_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue);
            assert (isInt);
            return doDouble(operandNodeValue_, this.double_leftInt32_);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            assert (!(isInt));
            return doBigInt(operandNodeValue_);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */ && operandNodeValue instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject operandNodeValue_ = (JSOverloadedOperatorsObject) operandNodeValue;
            return doOverloaded(operandNodeValue_, this.overloaded_overloadedOperatorNode_);
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) || doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) */) {
                GenericData s8_ = this.generic_cache;
                if (s8_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(operandNodeValue)))) {
                        assert (isInt);
                        return doGeneric(operandNodeValue, s8_.toNumeric_, s8_.profileIsBigInt_, s8_.innerAndNode_);
                    }
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                if ((!(JSGuards.hasOverloadedOperators(operandNodeValue)))) {
                    assert (!(isInt()));
                    return doGenericBigIntCase(operandNodeValue, this.genericBigIntCase_toNumeric_, this.genericBigIntCase_profileIsBigInt_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1111000110) == 0 /* only-active doInteger(int) */ && ((state_0 & 0b1111000111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */)) {
            return execute_int0(state_0, frameValue);
        } else if ((state_0 & 0b1111000011) == 0 /* only-active doDouble(double, JSToInt32Node) */ && ((state_0 & 0b1111000111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */)) {
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
        assert (state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */;
        assert (isInt);
        return doInteger(operandNodeValue_);
    }

    private Object execute_double1(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0b10110000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */;
        assert (isInt);
        return doDouble(operandNodeValue_, this.double_leftInt32_);
    }

    private Object execute_generic2(int state_0, VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            assert (isInt);
            return doInteger(operandNodeValue__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            assert (isInt);
            return doSafeInteger(operandNodeValue__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue_);
            assert (isInt);
            return doDouble(operandNodeValue__, this.double_leftInt32_);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            assert (!(isInt));
            return doBigInt(operandNodeValue__);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */ && operandNodeValue_ instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject operandNodeValue__ = (JSOverloadedOperatorsObject) operandNodeValue_;
            return doOverloaded(operandNodeValue__, this.overloaded_overloadedOperatorNode_);
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) || doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) */) {
                GenericData s8_ = this.generic_cache;
                if (s8_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(operandNodeValue_)))) {
                        assert (isInt);
                        return doGeneric(operandNodeValue_, s8_.toNumeric_, s8_.profileIsBigInt_, s8_.innerAndNode_);
                    }
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                if ((!(JSGuards.hasOverloadedOperators(operandNodeValue_)))) {
                    assert (!(isInt()));
                    return doGenericBigIntCase(operandNodeValue_, this.genericBigIntCase_toNumeric_, this.genericBigIntCase_profileIsBigInt_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b110000000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) || doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        if ((state_0 & 0b110) == 0 /* only-active doInteger(int) */ && ((state_0 & 0b111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) */)) {
            return executeInt_int3(state_0, frameValue);
        } else if ((state_0 & 0b11) == 0 /* only-active doDouble(double, JSToInt32Node) */ && ((state_0 & 0b111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) */)) {
            return executeInt_double4(state_0, frameValue);
        } else {
            return executeInt_generic5(state_0, frameValue);
        }
    }

    private int executeInt_int3(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */;
        assert (isInt);
        return doInteger(operandNodeValue_);
    }

    private int executeInt_double4(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0b10110000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */;
        assert (isInt);
        return doDouble(operandNodeValue_, this.double_leftInt32_);
    }

    private int executeInt_generic5(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            assert (isInt);
            return doInteger(operandNodeValue__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            assert (isInt);
            return doSafeInteger(operandNodeValue__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue_);
            assert (isInt);
            return doDouble(operandNodeValue__, this.double_leftInt32_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(operandNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b1111111000) == 0 /* only-active doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) */ && ((state_0 & 0b1111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b1111000111) != 0 /* is-state_0 doInteger(int) || doSafeInteger(SafeInteger) || doDouble(double, JSToInt32Node) || doBigInt(BigInt) || doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) || doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) || doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                execute(frameValue);
                return;
            }
        } catch (UnexpectedResultException ex) {
            return;
        }
        if ((state_0 & 0b110000) == 0 /* only-active doIntegerThrows(int) */ && ((state_0 & 0b111000) != 0  /* is-not doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) */)) {
            executeVoid_int6(state_0, frameValue);
            return;
        } else if ((state_0 & 0b101000) == 0 /* only-active doDoubleThrows(double) */ && ((state_0 & 0b111000) != 0  /* is-not doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) */)) {
            executeVoid_double7(state_0, frameValue);
            return;
        } else {
            executeVoid_generic8(state_0, frameValue);
            return;
        }
    }

    private void executeVoid_int6(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            executeAndSpecialize(ex.getResult());
            return;
        }
        assert (state_0 & 0b1000) != 0 /* is-state_0 doIntegerThrows(int) */;
        assert (!(isInt));
        doIntegerThrows(operandNodeValue_);
        return;
    }

    private void executeVoid_double7(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0b11100000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0b11010000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0b10110000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            executeAndSpecialize(ex.getResult());
            return;
        }
        assert (state_0 & 0b10000) != 0 /* is-state_0 doDoubleThrows(double) */;
        assert (!(isInt));
        doDoubleThrows(operandNodeValue_);
        return;
    }

    private void executeVoid_generic8(int state_0, VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1000) != 0 /* is-state_0 doIntegerThrows(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            assert (!(isInt));
            doIntegerThrows(operandNodeValue__);
            return;
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDoubleThrows(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, operandNodeValue_);
            assert (!(isInt));
            doDoubleThrows(operandNodeValue__);
            return;
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBigIntThrows(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            assert (isInt);
            doBigIntThrows(operandNodeValue__);
            return;
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(operandNodeValue_);
        return;
    }

    private Object executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (((exclude & 0b1)) == 0 /* is-not-exclude doInteger(int) */ && operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                if ((isInt)) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInteger(int) */;
                    lock.unlock();
                    hasLock = false;
                    return doInteger(operandNodeValue_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
                SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
                if ((isInt)) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doSafeInteger(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(operandNodeValue_);
                }
            }
            if (((exclude & 0b100)) == 0 /* is-not-exclude doDouble(double, JSToInt32Node) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    if ((isInt)) {
                        this.double_leftInt32_ = super.insert((JSToInt32Node.create()));
                        state_0 = (state_0 | (doubleCast0 << 10) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doDouble(double, JSToInt32Node) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(operandNodeValue_, this.double_leftInt32_);
                    }
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-exclude doIntegerThrows(int) */ && operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                if ((!(isInt))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doIntegerThrows(int) */;
                    lock.unlock();
                    hasLock = false;
                    doIntegerThrows(operandNodeValue_);
                    return null;
                }
            }
            if (((exclude & 0b10000)) == 0 /* is-not-exclude doDoubleThrows(double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    if ((!(isInt))) {
                        state_0 = (state_0 | (doubleCast0 << 10) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doDoubleThrows(double) */;
                        lock.unlock();
                        hasLock = false;
                        doDoubleThrows(operandNodeValue_);
                        return null;
                    }
                }
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                if (((exclude & 0b100000)) == 0 /* is-not-exclude doBigIntThrows(BigInt) */) {
                    if ((isInt)) {
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doBigIntThrows(BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        doBigIntThrows(operandNodeValue_);
                        return null;
                    }
                }
                if (((exclude & 0b1000000)) == 0 /* is-not-exclude doBigInt(BigInt) */) {
                    if ((!(isInt))) {
                        this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doBigInt(BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigInt(operandNodeValue_);
                    }
                }
            }
            if (operandNodeValue instanceof JSOverloadedOperatorsObject) {
                JSOverloadedOperatorsObject operandNodeValue_ = (JSOverloadedOperatorsObject) operandNodeValue;
                this.overloaded_overloadedOperatorNode_ = super.insert((JSOverloadedBinaryNode.createNumeric(getOverloadedOperatorName())));
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */;
                lock.unlock();
                hasLock = false;
                return doOverloaded(operandNodeValue_, this.overloaded_overloadedOperatorNode_);
            }
            if ((!(JSGuards.hasOverloadedOperators(operandNodeValue))) && (isInt)) {
                GenericData s8_ = super.insert(new GenericData());
                s8_.toNumeric_ = s8_.insertAccessor((JSToNumericNode.create()));
                s8_.profileIsBigInt_ = (ConditionProfile.createBinaryProfile());
                s8_.innerAndNode_ = s8_.insertAccessor((makeCopy()));
                MemoryFence.storeStore();
                this.generic_cache = s8_;
                this.exclude_ = exclude = exclude | 0b100111 /* add-exclude doInteger(int), doSafeInteger(SafeInteger), doDouble(double, JSToInt32Node), doBigIntThrows(BigInt) */;
                state_0 = state_0 & 0xffffffd8 /* remove-state_0 doInteger(int), doSafeInteger(SafeInteger), doDouble(double, JSToInt32Node), doBigIntThrows(BigInt) */;
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(operandNodeValue, s8_.toNumeric_, s8_.profileIsBigInt_, s8_.innerAndNode_);
            }
            if ((!(JSGuards.hasOverloadedOperators(operandNodeValue))) && (!(isInt()))) {
                this.genericBigIntCase_toNumeric_ = super.insert((JSToNumericNode.create()));
                this.genericBigIntCase_profileIsBigInt_ = (ConditionProfile.createBinaryProfile());
                this.exclude_ = exclude = exclude | 0b1011000 /* add-exclude doIntegerThrows(int), doDoubleThrows(double), doBigInt(BigInt) */;
                state_0 = state_0 & 0xffffffa7 /* remove-state_0 doIntegerThrows(int), doDoubleThrows(double), doBigInt(BigInt) */;
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doGenericBigIntCase(operandNodeValue, this.genericBigIntCase_toNumeric_, this.genericBigIntCase_profileIsBigInt_);
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
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doInteger(int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-exclude doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.double_leftInt32_));
            s[2] = cached;
        } else if ((exclude & 0b100) != 0 /* is-exclude doDouble(double, JSToInt32Node) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doIntegerThrows";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doIntegerThrows(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doIntegerThrows(int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDoubleThrows";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDoubleThrows(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-exclude doDoubleThrows(double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doBigIntThrows";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBigIntThrows(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000) != 0 /* is-exclude doBigIntThrows(BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000000) != 0 /* is-exclude doBigInt(BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doOverloaded";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.overloaded_overloadedOperatorNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s8_ = this.generic_cache;
            if (s8_ != null) {
                cached.add(Arrays.asList(s8_.toNumeric_, s8_.profileIsBigInt_, s8_.innerAndNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doGenericBigIntCase";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.genericBigIntCase_toNumeric_, this.genericBigIntCase_profileIsBigInt_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        return Provider.create(data);
    }

    public static JSBitwiseAndConstantNode create(JavaScriptNode left, Object rightValue) {
        return new JSBitwiseAndConstantNodeGen(left, rightValue);
    }

    @GeneratedBy(JSBitwiseAndConstantNode.class)
    private static final class GenericData extends Node {

        @Child JSToNumericNode toNumeric_;
        @CompilationFinal ConditionProfile profileIsBigInt_;
        @Child JavaScriptNode innerAndNode_;

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
