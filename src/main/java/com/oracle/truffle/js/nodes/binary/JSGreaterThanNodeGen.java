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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToBooleanNode;
import com.oracle.truffle.js.nodes.cast.JSToPrimitiveNode;
import com.oracle.truffle.js.nodes.cast.JSToStringOrNumberNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSGreaterThanNode.class)
public final class JSGreaterThanNodeGen extends JSGreaterThanNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSOverloadedBinaryNode overloaded_overloadedOperatorNode_;
    @Child private JSToBooleanNode overloaded_toBooleanNode_;
    @Child private GenericData generic_cache;

    private JSGreaterThanNodeGen(JavaScriptNode left, JavaScriptNode right) {
        super(left, right);
    }

    @Override
    public boolean executeBoolean(Object leftNodeValue, Object rightNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 doInt(int, int) || doSafeInteger(int, SafeInteger) */ && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return doInt(leftNodeValue_, rightNodeValue_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(int, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
                SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                return doSafeInteger(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b1100) != 0 /* is-state_0 doSafeInteger(SafeInteger, int) || doSafeInteger(SafeInteger, SafeInteger) */ && leftNodeValue instanceof SafeInteger) {
            SafeInteger leftNodeValue_ = (SafeInteger) leftNodeValue;
            if ((state_0 & 0b100) != 0 /* is-state_0 doSafeInteger(SafeInteger, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return doSafeInteger(leftNodeValue_, rightNodeValue_);
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
                SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                return doSafeInteger(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue);
                return doDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doString(String, String) || doStringDouble(String, double) */ && JSTypesGen.isImplicitString((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 0:String */, leftNodeValue)) {
            String leftNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 0:String */, leftNodeValue);
            if ((state_0 & 0b100000) != 0 /* is-state_0 doString(String, String) */ && JSTypesGen.isImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue)) {
                String rightNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue);
                return doString(leftNodeValue_, rightNodeValue_);
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doStringDouble(String, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue);
                return doStringDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doDoubleString(double, String) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue)) {
                String rightNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue);
                return doDoubleString(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doStringBigInt(String, BigInt) */ && JSTypesGen.isImplicitString((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 0:String */, leftNodeValue)) {
            String leftNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 0:String */, leftNodeValue);
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doStringBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b1111000000000) != 0 /* is-state_0 doBigIntString(BigInt, String) || doBigInt(BigInt, BigInt) || doBigIntAndInt(BigInt, int) || doBigIntAndNumber(BigInt, double) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doBigIntString(BigInt, String) */ && JSTypesGen.isImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue)) {
                String rightNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue);
                return doBigIntString(leftNodeValue_, rightNodeValue_);
            }
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */ && rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doBigInt(leftNodeValue_, rightNodeValue_);
            }
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doBigIntAndInt(BigInt, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return doBigIntAndInt(leftNodeValue_, rightNodeValue_);
            }
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doBigIntAndNumber(BigInt, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue);
                return doBigIntAndNumber(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0b110000000000000) != 0 /* is-state_0 doIntAndBigInt(int, BigInt) || doNumberAndBigInt(double, BigInt) */ && rightNodeValue instanceof BigInt) {
            BigInt rightNodeValue_ = (BigInt) rightNodeValue;
            if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doIntAndBigInt(int, BigInt) */ && leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                return doIntAndBigInt(leftNodeValue_, rightNodeValue_);
            }
            if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doNumberAndBigInt(double, BigInt) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue)) {
                double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue);
                return doNumberAndBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state_0 & 0x38000) != 0 /* is-state_0 doJavaNumber(Object, Object) || doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) || doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */) {
            if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doJavaNumber(Object, Object) */) {
                if ((JSGuards.isJavaNumber(leftNodeValue)) && (JSGuards.isJavaNumber(rightNodeValue))) {
                    return doJavaNumber(leftNodeValue, rightNodeValue);
                }
            }
            if ((state_0 & 0x10000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) */) {
                if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                    return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_, this.overloaded_toBooleanNode_);
                }
            }
            if ((state_0 & 0x20000) != 0 /* is-state_0 doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */) {
                GenericData s17_ = this.generic_cache;
                if (s17_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(leftNodeValue))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue)))) {
                        return doGeneric(leftNodeValue, rightNodeValue, s17_.toStringOrNumber1_, s17_.toPrimitive1_, s17_.toStringOrNumber2_, s17_.toPrimitive2_, s17_.greaterThanNode_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue, rightNodeValue);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0x3fffe) == 0 /* only-active doInt(int, int) */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
            return executeBoolean_int_int0(state_0, frameValue);
        } else if ((state_0 & 0x3ffef) == 0 /* only-active doDouble(double, double) */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
            return executeBoolean_double_double1(state_0, frameValue);
        } else if ((state_0 & 0x3dffd) == 0 /* only-active doSafeInteger(int, SafeInteger) && doIntAndBigInt(int, BigInt) */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
            return executeBoolean_int2(state_0, frameValue);
        } else if ((state_0 & 0x3f7fb) == 0 /* only-active doSafeInteger(SafeInteger, int) && doBigIntAndInt(BigInt, int) */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
            return executeBoolean_int3(state_0, frameValue);
        } else if ((state_0 & 0x3efbf) == 0 /* only-active doStringDouble(String, double) && doBigIntAndNumber(BigInt, double) */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
            return executeBoolean_double4(state_0, frameValue);
        } else if ((state_0 & 0x3bf7f) == 0 /* only-active doDoubleString(double, String) && doNumberAndBigInt(double, BigInt) */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
            return executeBoolean_double5(state_0, frameValue);
        } else {
            return executeBoolean_generic6(state_0, frameValue);
        }
    }

    private boolean executeBoolean_int_int0(int state_0, VirtualFrame frameValue) {
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
        return doInt(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_double_double1(int state_0, VirtualFrame frameValue) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0x380000) == 0 /* only-active 0:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0x340000) == 0 /* only-active 0:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0x2c0000) == 0 /* only-active 0:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_0 & 0x3800000) == 0 /* only-active 1:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0x3400000) == 0 /* only-active 1:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0x2c00000) == 0 /* only-active 1:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state_0 & 0x380000) == 0 /* only-active 0:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */) ? (Object) leftNodeValue_long : ((state_0 & 0x340000) == 0 /* only-active 0:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state_0 & 0b10000) != 0 /* is-state_0 doDouble(double, double) */;
        return doDouble(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_int2(int state_0, VirtualFrame frameValue) {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(int, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
            SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
            return doSafeInteger(leftNodeValue_, rightNodeValue__);
        }
        if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doIntAndBigInt(int, BigInt) */ && rightNodeValue_ instanceof BigInt) {
            BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
            return doIntAndBigInt(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_int3(int state_0, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doSafeInteger(SafeInteger, int) */ && leftNodeValue_ instanceof SafeInteger) {
            SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
            return doSafeInteger(leftNodeValue__, rightNodeValue_);
        }
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doBigIntAndInt(BigInt, int) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            return doBigIntAndInt(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_double4(int state_0, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_0 & 0x3800000) == 0 /* only-active 1:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_0 & 0x3400000) == 0 /* only-active 1:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_0 & 0x2c00000) == 0 /* only-active 1:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doStringDouble(String, double) */ && JSTypesGen.isImplicitString((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 0:String */, leftNodeValue_)) {
            String leftNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 0:String */, leftNodeValue_);
            return doStringDouble(leftNodeValue__, rightNodeValue_);
        }
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doBigIntAndNumber(BigInt, double) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            return doBigIntAndNumber(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, ((state_0 & 0x3800000) == 0 /* only-active 1:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */) ? (Object) rightNodeValue_long : ((state_0 & 0x3400000) == 0 /* only-active 1:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */) ? (Object) rightNodeValue_int : (Object) rightNodeValue_)));
    }

    private boolean executeBoolean_double5(int state_0, VirtualFrame frameValue) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_0 & 0x380000) == 0 /* only-active 0:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_0 & 0x340000) == 0 /* only-active 0:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_0 & 0x2c0000) == 0 /* only-active 0:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doDoubleString(double, String) */ && JSTypesGen.isImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue_)) {
            String rightNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue_);
            return doDoubleString(leftNodeValue_, rightNodeValue__);
        }
        if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doNumberAndBigInt(double, BigInt) */ && rightNodeValue_ instanceof BigInt) {
            BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
            return doNumberAndBigInt(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(((state_0 & 0x380000) == 0 /* only-active 0:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */) ? (Object) leftNodeValue_long : ((state_0 & 0x340000) == 0 /* only-active 0:double */ && ((state_0 & 0x3ffff) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), rightNodeValue_);
    }

    private boolean executeBoolean_generic6(int state_0, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b11) != 0 /* is-state_0 doInt(int, int) || doSafeInteger(int, SafeInteger) */ && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return doInt(leftNodeValue__, rightNodeValue__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(int, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
                SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
                return doSafeInteger(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b1100) != 0 /* is-state_0 doSafeInteger(SafeInteger, int) || doSafeInteger(SafeInteger, SafeInteger) */ && leftNodeValue_ instanceof SafeInteger) {
            SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
            if ((state_0 & 0b100) != 0 /* is-state_0 doSafeInteger(SafeInteger, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return doSafeInteger(leftNodeValue__, rightNodeValue__);
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
                SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
                return doSafeInteger(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue_);
                return doDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doString(String, String) || doStringDouble(String, double) */ && JSTypesGen.isImplicitString((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 0:String */, leftNodeValue_)) {
            String leftNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 0:String */, leftNodeValue_);
            if ((state_0 & 0b100000) != 0 /* is-state_0 doString(String, String) */ && JSTypesGen.isImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue_);
                return doString(leftNodeValue__, rightNodeValue__);
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doStringDouble(String, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue_);
                return doStringDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doDoubleString(double, String) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue_);
                return doDoubleString(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doStringBigInt(String, BigInt) */ && JSTypesGen.isImplicitString((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 0:String */, leftNodeValue_)) {
            String leftNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0x1c000000) >>> 26 /* extract-implicit-state_0 0:String */, leftNodeValue_);
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doStringBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b1111000000000) != 0 /* is-state_0 doBigIntString(BigInt, String) || doBigInt(BigInt, BigInt) || doBigIntAndInt(BigInt, int) || doBigIntAndNumber(BigInt, double) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doBigIntString(BigInt, String) */ && JSTypesGen.isImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0xe0000000) >>> 29 /* extract-implicit-state_0 1:String */, rightNodeValue_);
                return doBigIntString(leftNodeValue__, rightNodeValue__);
            }
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */ && rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doBigInt(leftNodeValue__, rightNodeValue__);
            }
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doBigIntAndInt(BigInt, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return doBigIntAndInt(leftNodeValue__, rightNodeValue__);
            }
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doBigIntAndNumber(BigInt, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0x3c00000) >>> 22 /* extract-implicit-state_0 1:double */, rightNodeValue_);
                return doBigIntAndNumber(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b110000000000000) != 0 /* is-state_0 doIntAndBigInt(int, BigInt) || doNumberAndBigInt(double, BigInt) */ && rightNodeValue_ instanceof BigInt) {
            BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
            if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doIntAndBigInt(int, BigInt) */ && leftNodeValue_ instanceof Integer) {
                int leftNodeValue__ = (int) leftNodeValue_;
                return doIntAndBigInt(leftNodeValue__, rightNodeValue__);
            }
            if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doNumberAndBigInt(double, BigInt) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue_)) {
                double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0x3c0000) >>> 18 /* extract-implicit-state_0 0:double */, leftNodeValue_);
                return doNumberAndBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0x38000) != 0 /* is-state_0 doJavaNumber(Object, Object) || doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) || doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */) {
            if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doJavaNumber(Object, Object) */) {
                if ((JSGuards.isJavaNumber(leftNodeValue_)) && (JSGuards.isJavaNumber(rightNodeValue_))) {
                    return doJavaNumber(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((state_0 & 0x10000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) */) {
                if ((JSGuards.hasOverloadedOperators(leftNodeValue_) || JSGuards.hasOverloadedOperators(rightNodeValue_))) {
                    return doOverloaded(leftNodeValue_, rightNodeValue_, this.overloaded_overloadedOperatorNode_, this.overloaded_toBooleanNode_);
                }
            }
            if ((state_0 & 0x20000) != 0 /* is-state_0 doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */) {
                GenericData s17_ = this.generic_cache;
                if (s17_ != null) {
                    if ((!(JSGuards.hasOverloadedOperators(leftNodeValue_))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue_)))) {
                        return doGeneric(leftNodeValue_, rightNodeValue_, s17_.toStringOrNumber1_, s17_.toPrimitive1_, s17_.toStringOrNumber2_, s17_.toPrimitive2_, s17_.greaterThanNode_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    private boolean executeAndSpecialize(Object leftNodeValue, Object rightNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                if (((exclude & 0b1)) == 0 /* is-not-exclude doInt(int, int) */ && rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt(int, int) */;
                    lock.unlock();
                    hasLock = false;
                    return doInt(leftNodeValue_, rightNodeValue_);
                }
                if (rightNodeValue instanceof SafeInteger) {
                    SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doSafeInteger(int, SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(leftNodeValue_, rightNodeValue_);
                }
            }
            if (leftNodeValue instanceof SafeInteger) {
                SafeInteger leftNodeValue_ = (SafeInteger) leftNodeValue;
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doSafeInteger(SafeInteger, int) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(leftNodeValue_, rightNodeValue_);
                }
                if (rightNodeValue instanceof SafeInteger) {
                    SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doSafeInteger(SafeInteger, SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(leftNodeValue_, rightNodeValue_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doDouble(double, double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state_0 = (state_0 | (doubleCast0 << 18) /* set-implicit-state_0 0:double */);
                        state_0 = (state_0 | (doubleCast1 << 22) /* set-implicit-state_0 1:double */);
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doDouble(double, double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(leftNodeValue)) != 0) {
                    String leftNodeValue_ = JSTypesGen.asImplicitString(stringCast0, leftNodeValue);
                    if (((exclude & 0b100)) == 0 /* is-not-exclude doString(String, String) */) {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                            String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                            state_0 = (state_0 | (stringCast0 << 26) /* set-implicit-state_0 0:String */);
                            state_0 = (state_0 | (stringCast1 << 29) /* set-implicit-state_0 1:String */);
                            this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doString(String, String) */;
                            lock.unlock();
                            hasLock = false;
                            return doString(leftNodeValue_, rightNodeValue_);
                        }
                    }
                    if (((exclude & 0b1000)) == 0 /* is-not-exclude doStringDouble(String, double) */) {
                        int doubleCast1;
                        if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                            double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                            state_0 = (state_0 | (stringCast0 << 26) /* set-implicit-state_0 0:String */);
                            state_0 = (state_0 | (doubleCast1 << 22) /* set-implicit-state_0 1:double */);
                            this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doStringDouble(String, double) */;
                            lock.unlock();
                            hasLock = false;
                            return doStringDouble(leftNodeValue_, rightNodeValue_);
                        }
                    }
                }
            }
            if (((exclude & 0b10000)) == 0 /* is-not-exclude doDoubleString(double, String) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int stringCast1;
                    if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                        String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                        state_0 = (state_0 | (doubleCast0 << 18) /* set-implicit-state_0 0:double */);
                        state_0 = (state_0 | (stringCast1 << 29) /* set-implicit-state_0 1:String */);
                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doDoubleString(double, String) */;
                        lock.unlock();
                        hasLock = false;
                        return doDoubleString(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(leftNodeValue)) != 0) {
                    String leftNodeValue_ = JSTypesGen.asImplicitString(stringCast0, leftNodeValue);
                    if (rightNodeValue instanceof BigInt) {
                        BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                        state_0 = (state_0 | (stringCast0 << 26) /* set-implicit-state_0 0:String */);
                        this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doStringBigInt(String, BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        return doStringBigInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                {
                    int stringCast1;
                    if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                        String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                        state_0 = (state_0 | (stringCast1 << 29) /* set-implicit-state_0 1:String */);
                        this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doBigIntString(BigInt, String) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigIntString(leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((exclude & 0b100000)) == 0 /* is-not-exclude doBigInt(BigInt, BigInt) */ && rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doBigInt(BigInt, BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigInt(leftNodeValue_, rightNodeValue_);
                }
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doBigIntAndInt(BigInt, int) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigIntAndInt(leftNodeValue_, rightNodeValue_);
                }
                if (((exclude & 0b1000000)) == 0 /* is-not-exclude doBigIntAndNumber(BigInt, double) */) {
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state_0 = (state_0 | (doubleCast1 << 22) /* set-implicit-state_0 1:double */);
                        this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doBigIntAndNumber(BigInt, double) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigIntAndNumber(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                if (leftNodeValue instanceof Integer) {
                    int leftNodeValue_ = (int) leftNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 doIntAndBigInt(int, BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return doIntAndBigInt(leftNodeValue_, rightNodeValue_);
                }
                if (((exclude & 0b10000000)) == 0 /* is-not-exclude doNumberAndBigInt(double, BigInt) */) {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                        double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                        state_0 = (state_0 | (doubleCast0 << 18) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b100000000000000 /* add-state_0 doNumberAndBigInt(double, BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        return doNumberAndBigInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((exclude & 0b100000000)) == 0 /* is-not-exclude doJavaNumber(Object, Object) */) {
                if ((JSGuards.isJavaNumber(leftNodeValue)) && (JSGuards.isJavaNumber(rightNodeValue))) {
                    this.state_0_ = state_0 = state_0 | 0b1000000000000000 /* add-state_0 doJavaNumber(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doJavaNumber(leftNodeValue, rightNodeValue);
                }
            }
            if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                this.overloaded_overloadedOperatorNode_ = super.insert((JSOverloadedBinaryNode.createHintNumberRightToLeft(getOverloadedOperatorName())));
                this.overloaded_toBooleanNode_ = super.insert((JSToBooleanNode.create()));
                this.state_0_ = state_0 = state_0 | 0x10000 /* add-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) */;
                lock.unlock();
                hasLock = false;
                return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_, this.overloaded_toBooleanNode_);
            }
            if ((!(JSGuards.hasOverloadedOperators(leftNodeValue))) && (!(JSGuards.hasOverloadedOperators(rightNodeValue)))) {
                GenericData s17_ = super.insert(new GenericData());
                s17_.toStringOrNumber1_ = s17_.insertAccessor((JSToStringOrNumberNode.create()));
                s17_.toPrimitive1_ = s17_.insertAccessor((JSToPrimitiveNode.createHintNumber()));
                s17_.toStringOrNumber2_ = s17_.insertAccessor((JSToStringOrNumberNode.create()));
                s17_.toPrimitive2_ = s17_.insertAccessor((JSToPrimitiveNode.createHintNumber()));
                s17_.greaterThanNode_ = s17_.insertAccessor((JSGreaterThanNode.create()));
                MemoryFence.storeStore();
                this.generic_cache = s17_;
                this.exclude_ = exclude = exclude | 0b111111111 /* add-exclude doInt(int, int), doDouble(double, double), doString(String, String), doStringDouble(String, double), doDoubleString(double, String), doBigInt(BigInt, BigInt), doBigIntAndNumber(BigInt, double), doNumberAndBigInt(double, BigInt), doJavaNumber(Object, Object) */;
                state_0 = state_0 & 0xffff2b0e /* remove-state_0 doInt(int, int), doDouble(double, double), doString(String, String), doStringDouble(String, double), doDoubleString(double, String), doBigInt(BigInt, BigInt), doBigIntAndNumber(BigInt, double), doNumberAndBigInt(double, BigInt), doJavaNumber(Object, Object) */;
                this.state_0_ = state_0 = state_0 | 0x20000 /* add-state_0 doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(leftNodeValue, rightNodeValue, s17_.toStringOrNumber1_, s17_.toPrimitive1_, s17_.toStringOrNumber2_, s17_.toPrimitive2_, s17_.greaterThanNode_);
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
        if ((state_0 & 0x3ffff) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0x3ffff) & ((state_0 & 0x3ffff) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[19];
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
        s[0] = "doSafeInteger";
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(int, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b100) != 0 /* is-state_0 doSafeInteger(SafeInteger, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeInteger(SafeInteger, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-exclude doDouble(double, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doString(String, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-exclude doString(String, String) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doStringDouble";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doStringDouble(String, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doStringDouble(String, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doDoubleString";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doDoubleString(double, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-exclude doDoubleString(double, String) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doStringBigInt";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doStringBigInt(String, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doBigIntString";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doBigIntString(BigInt, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000) != 0 /* is-exclude doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doBigIntAndInt";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doBigIntAndInt(BigInt, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doBigIntAndNumber";
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doBigIntAndNumber(BigInt, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000000) != 0 /* is-exclude doBigIntAndNumber(BigInt, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doIntAndBigInt";
        if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doIntAndBigInt(int, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        s = new Object[3];
        s[0] = "doNumberAndBigInt";
        if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doNumberAndBigInt(double, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000000) != 0 /* is-exclude doNumberAndBigInt(double, BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[15] = s;
        s = new Object[3];
        s[0] = "doJavaNumber";
        if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doJavaNumber(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000000) != 0 /* is-exclude doJavaNumber(Object, Object) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[16] = s;
        s = new Object[3];
        s[0] = "doOverloaded";
        if ((state_0 & 0x10000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.overloaded_overloadedOperatorNode_, this.overloaded_toBooleanNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[17] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state_0 & 0x20000) != 0 /* is-state_0 doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSGreaterThanNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s17_ = this.generic_cache;
            if (s17_ != null) {
                cached.add(Arrays.asList(s17_.toStringOrNumber1_, s17_.toPrimitive1_, s17_.toStringOrNumber2_, s17_.toPrimitive2_, s17_.greaterThanNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[18] = s;
        return Provider.create(data);
    }

    public static JSGreaterThanNode create(JavaScriptNode left, JavaScriptNode right) {
        return new JSGreaterThanNodeGen(left, right);
    }

    @GeneratedBy(JSGreaterThanNode.class)
    private static final class GenericData extends Node {

        @Child JSToStringOrNumberNode toStringOrNumber1_;
        @Child JSToPrimitiveNode toPrimitive1_;
        @Child JSToStringOrNumberNode toStringOrNumber2_;
        @Child JSToPrimitiveNode toPrimitive2_;
        @Child JSGreaterThanNode greaterThanNode_;

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
