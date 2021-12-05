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
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.binary.JSOverloadedBinaryNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToInt32Node.class)
public final class JSToInt32NodeGen extends JSToInt32Node implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSStringToNumberNode string_stringToNumberNode_;
    @Child private JSOverloadedBinaryNode overloadedOperator_overloadedOperatorNode_;
    @Child private JSToDoubleNode jSObject_toDoubleNode_;
    @Child private JSToPrimitiveNode foreignObject_toPrimitiveNode_;
    @Child private JSToInt32Node foreignObject_toInt32Node_;

    private JSToInt32NodeGen(JavaScriptNode operand, boolean bitwiseOr) {
        super(operand, bitwiseOr);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doInteger(operandNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            return doSafeInteger(operandNodeValue_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            return doBoolean(operandNodeValue_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(long) */ && operandNodeValue instanceof Long) {
            long operandNodeValue_ = (long) operandNodeValue;
            if ((JSGuards.isLongRepresentableAsInt32(operandNodeValue_))) {
                return doLong(operandNodeValue_);
            }
        }
        if ((state_0 & 0b11110000) != 0 /* is-state_0 doDoubleFitsInt(double) || doDoubleRepresentableAsSafeInteger(double) || doDoubleRepresentableAsLong(double) || doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, operandNodeValue);
            if ((state_0 & 0b10000) != 0 /* is-state_0 doDoubleFitsInt(double) */) {
                if ((!(JSGuards.isDoubleLargerThan2e32(operandNodeValue_)))) {
                    return doDoubleFitsInt(operandNodeValue_);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doDoubleRepresentableAsSafeInteger(double) */) {
                if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue_)) && (JSGuards.isDoubleRepresentableAsLong(operandNodeValue_)) && (JSGuards.isDoubleSafeInteger(operandNodeValue_))) {
                    return doDoubleRepresentableAsSafeInteger(operandNodeValue_);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doDoubleRepresentableAsLong(double) */) {
                if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue_)) && (JSGuards.isDoubleRepresentableAsLong(operandNodeValue_))) {
                    return doDoubleRepresentableAsLong(operandNodeValue_);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doDouble(double) */) {
                if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue_)) && (!(JSGuards.isDoubleRepresentableAsLong(operandNodeValue_)))) {
                    return doDouble(operandNodeValue_);
                }
            }
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doUndefined(Object) || doNull(Object) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue))) {
                    return doUndefined(operandNodeValue);
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue))) {
                    return doNull(operandNodeValue);
                }
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doString(String, JSStringToNumberNode) */ && JSTypesGen.isImplicitString((state_0 & 0x700000) >>> 20 /* extract-implicit-state_0 0:String */, operandNodeValue)) {
            String operandNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0x700000) >>> 20 /* extract-implicit-state_0 0:String */, operandNodeValue);
            return doString(operandNodeValue_, this.string_stringToNumberNode_);
        }
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return doSymbol(operandNodeValue_);
        }
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return doBigInt(operandNodeValue_);
        }
        if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doOverloadedOperator(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */ && operandNodeValue instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject operandNodeValue_ = (JSOverloadedOperatorsObject) operandNodeValue;
            assert (isBitwiseOr());
            return doOverloadedOperator(operandNodeValue_, this.overloadedOperator_overloadedOperatorNode_);
        }
        if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doJSObject(DynamicObject, JSToDoubleNode) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            if ((JSGuards.isJSObject(operandNodeValue_)) && (!(isBitwiseOr()) || !(JSGuards.hasOverloadedOperators(operandNodeValue_)))) {
                return doJSObject(operandNodeValue_, this.jSObject_toDoubleNode_);
            }
        }
        if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */) {
            if ((JSGuards.isForeignObject(operandNodeValue))) {
                return JSToInt32Node.doForeignObject(operandNodeValue, this.foreignObject_toPrimitiveNode_, this.foreignObject_toInt32Node_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public int executeInt(Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doOverloadedOperator(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */) {
            return (int) execute(null, operandNodeValue);
        }
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doInteger(operandNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            return doSafeInteger(operandNodeValue_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            return doBoolean(operandNodeValue_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(long) */ && operandNodeValue instanceof Long) {
            long operandNodeValue_ = (long) operandNodeValue;
            if ((JSGuards.isLongRepresentableAsInt32(operandNodeValue_))) {
                return doLong(operandNodeValue_);
            }
        }
        if ((state_0 & 0b11110000) != 0 /* is-state_0 doDoubleFitsInt(double) || doDoubleRepresentableAsSafeInteger(double) || doDoubleRepresentableAsLong(double) || doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, operandNodeValue);
            if ((state_0 & 0b10000) != 0 /* is-state_0 doDoubleFitsInt(double) */) {
                if ((!(JSGuards.isDoubleLargerThan2e32(operandNodeValue_)))) {
                    return doDoubleFitsInt(operandNodeValue_);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doDoubleRepresentableAsSafeInteger(double) */) {
                if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue_)) && (JSGuards.isDoubleRepresentableAsLong(operandNodeValue_)) && (JSGuards.isDoubleSafeInteger(operandNodeValue_))) {
                    return doDoubleRepresentableAsSafeInteger(operandNodeValue_);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doDoubleRepresentableAsLong(double) */) {
                if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue_)) && (JSGuards.isDoubleRepresentableAsLong(operandNodeValue_))) {
                    return doDoubleRepresentableAsLong(operandNodeValue_);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doDouble(double) */) {
                if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue_)) && (!(JSGuards.isDoubleRepresentableAsLong(operandNodeValue_)))) {
                    return doDouble(operandNodeValue_);
                }
            }
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doUndefined(Object) || doNull(Object) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue))) {
                    return doUndefined(operandNodeValue);
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue))) {
                    return doNull(operandNodeValue);
                }
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doString(String, JSStringToNumberNode) */ && JSTypesGen.isImplicitString((state_0 & 0x700000) >>> 20 /* extract-implicit-state_0 0:String */, operandNodeValue)) {
            String operandNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0x700000) >>> 20 /* extract-implicit-state_0 0:String */, operandNodeValue);
            return doString(operandNodeValue_, this.string_stringToNumberNode_);
        }
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return doSymbol(operandNodeValue_);
        }
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return doBigInt(operandNodeValue_);
        }
        if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doJSObject(DynamicObject, JSToDoubleNode) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            if ((JSGuards.isJSObject(operandNodeValue_)) && (!(isBitwiseOr()) || !(JSGuards.hasOverloadedOperators(operandNodeValue_)))) {
                return doJSObject(operandNodeValue_, this.jSObject_toDoubleNode_);
            }
        }
        if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */) {
            if ((JSGuards.isForeignObject(operandNodeValue))) {
                return JSToInt32Node.doForeignObject(operandNodeValue, this.foreignObject_toPrimitiveNode_, this.foreignObject_toInt32Node_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return (int) executeAndSpecialize(operandNodeValue);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1101111111111110) == 0 /* only-active doInteger(int) */ && ((state_0 & 0b1101111111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doBoolean(boolean) && doLong(long) && doDoubleFitsInt(double) && doDoubleRepresentableAsSafeInteger(double) && doDoubleRepresentableAsLong(double) && doDouble(double) && doUndefined(Object) && doNull(Object) && doString(String, JSStringToNumberNode) && doSymbol(Symbol) && doBigInt(BigInt) && doJSObject(DynamicObject, JSToDoubleNode) && doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */)) {
            return executeInt_int0(state_0, frameValue);
        } else if ((state_0 & 0b1101111111111011) == 0 /* only-active doBoolean(boolean) */ && ((state_0 & 0b1101111111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doBoolean(boolean) && doLong(long) && doDoubleFitsInt(double) && doDoubleRepresentableAsSafeInteger(double) && doDoubleRepresentableAsLong(double) && doDouble(double) && doUndefined(Object) && doNull(Object) && doString(String, JSStringToNumberNode) && doSymbol(Symbol) && doBigInt(BigInt) && doJSObject(DynamicObject, JSToDoubleNode) && doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */)) {
            return executeInt_boolean1(state_0, frameValue);
        } else if ((state_0 & 0b1101111111110111) == 0 /* only-active doLong(long) */ && ((state_0 & 0b1101111111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doBoolean(boolean) && doLong(long) && doDoubleFitsInt(double) && doDoubleRepresentableAsSafeInteger(double) && doDoubleRepresentableAsLong(double) && doDouble(double) && doUndefined(Object) && doNull(Object) && doString(String, JSStringToNumberNode) && doSymbol(Symbol) && doBigInt(BigInt) && doJSObject(DynamicObject, JSToDoubleNode) && doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */)) {
            return executeInt_long2(state_0, frameValue);
        } else if ((state_0 & 0b1101111100001111) == 0 /* only-active doDoubleFitsInt(double) && doDoubleRepresentableAsSafeInteger(double) && doDoubleRepresentableAsLong(double) && doDouble(double) */ && ((state_0 & 0b1101111111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doBoolean(boolean) && doLong(long) && doDoubleFitsInt(double) && doDoubleRepresentableAsSafeInteger(double) && doDoubleRepresentableAsLong(double) && doDouble(double) && doUndefined(Object) && doNull(Object) && doString(String, JSStringToNumberNode) && doSymbol(Symbol) && doBigInt(BigInt) && doJSObject(DynamicObject, JSToDoubleNode) && doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */)) {
            return executeInt_double3(state_0, frameValue);
        } else {
            return executeInt_generic4(state_0, frameValue);
        }
    }

    private int executeInt_int0(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return (int) executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */;
        return doInteger(operandNodeValue_);
    }

    private int executeInt_boolean1(int state_0, VirtualFrame frameValue) {
        boolean operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return (int) executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 doBoolean(boolean) */;
        return doBoolean(operandNodeValue_);
    }

    private int executeInt_long2(int state_0, VirtualFrame frameValue) {
        long operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return (int) executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1000) != 0 /* is-state_0 doLong(long) */;
        if ((JSGuards.isLongRepresentableAsInt32(operandNodeValue_))) {
            return doLong(operandNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return (int) executeAndSpecialize(operandNodeValue_);
    }

    private int executeInt_double3(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0xe0000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doBoolean(boolean) && doLong(long) && doDoubleFitsInt(double) && doDoubleRepresentableAsSafeInteger(double) && doDoubleRepresentableAsLong(double) && doDouble(double) && doUndefined(Object) && doNull(Object) && doString(String, JSStringToNumberNode) && doSymbol(Symbol) && doBigInt(BigInt) && doOverloadedOperator(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doJSObject(DynamicObject, JSToDoubleNode) && doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0xd0000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doBoolean(boolean) && doLong(long) && doDoubleFitsInt(double) && doDoubleRepresentableAsSafeInteger(double) && doDoubleRepresentableAsLong(double) && doDouble(double) && doUndefined(Object) && doNull(Object) && doString(String, JSStringToNumberNode) && doSymbol(Symbol) && doBigInt(BigInt) && doOverloadedOperator(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doJSObject(DynamicObject, JSToDoubleNode) && doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0xb0000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doBoolean(boolean) && doLong(long) && doDoubleFitsInt(double) && doDoubleRepresentableAsSafeInteger(double) && doDoubleRepresentableAsLong(double) && doDouble(double) && doUndefined(Object) && doNull(Object) && doString(String, JSStringToNumberNode) && doSymbol(Symbol) && doBigInt(BigInt) && doOverloadedOperator(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doJSObject(DynamicObject, JSToDoubleNode) && doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return (int) executeAndSpecialize(ex.getResult());
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDoubleFitsInt(double) */) {
            if ((!(JSGuards.isDoubleLargerThan2e32(operandNodeValue_)))) {
                return doDoubleFitsInt(operandNodeValue_);
            }
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doDoubleRepresentableAsSafeInteger(double) */) {
            if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue_)) && (JSGuards.isDoubleRepresentableAsLong(operandNodeValue_)) && (JSGuards.isDoubleSafeInteger(operandNodeValue_))) {
                return doDoubleRepresentableAsSafeInteger(operandNodeValue_);
            }
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doDoubleRepresentableAsLong(double) */) {
            if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue_)) && (JSGuards.isDoubleRepresentableAsLong(operandNodeValue_))) {
                return doDoubleRepresentableAsLong(operandNodeValue_);
            }
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doDouble(double) */) {
            if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue_)) && (!(JSGuards.isDoubleRepresentableAsLong(operandNodeValue_)))) {
                return doDouble(operandNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return (int) executeAndSpecialize(((state_0 & 0xe0000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doBoolean(boolean) && doLong(long) && doDoubleFitsInt(double) && doDoubleRepresentableAsSafeInteger(double) && doDoubleRepresentableAsLong(double) && doDouble(double) && doUndefined(Object) && doNull(Object) && doString(String, JSStringToNumberNode) && doSymbol(Symbol) && doBigInt(BigInt) && doOverloadedOperator(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doJSObject(DynamicObject, JSToDoubleNode) && doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */) ? (Object) operandNodeValue_long : ((state_0 & 0xd0000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doBoolean(boolean) && doLong(long) && doDoubleFitsInt(double) && doDoubleRepresentableAsSafeInteger(double) && doDoubleRepresentableAsLong(double) && doDouble(double) && doUndefined(Object) && doNull(Object) && doString(String, JSStringToNumberNode) && doSymbol(Symbol) && doBigInt(BigInt) && doOverloadedOperator(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doJSObject(DynamicObject, JSToDoubleNode) && doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */) ? (Object) operandNodeValue_int : (Object) operandNodeValue_)));
    }

    private int executeInt_generic4(int state_0, VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            return doInteger(operandNodeValue__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            return doSafeInteger(operandNodeValue__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue_ instanceof Boolean) {
            boolean operandNodeValue__ = (boolean) operandNodeValue_;
            return doBoolean(operandNodeValue__);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(long) */ && operandNodeValue_ instanceof Long) {
            long operandNodeValue__ = (long) operandNodeValue_;
            if ((JSGuards.isLongRepresentableAsInt32(operandNodeValue__))) {
                return doLong(operandNodeValue__);
            }
        }
        if ((state_0 & 0b11110000) != 0 /* is-state_0 doDoubleFitsInt(double) || doDoubleRepresentableAsSafeInteger(double) || doDoubleRepresentableAsLong(double) || doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, operandNodeValue_);
            if ((state_0 & 0b10000) != 0 /* is-state_0 doDoubleFitsInt(double) */) {
                if ((!(JSGuards.isDoubleLargerThan2e32(operandNodeValue__)))) {
                    return doDoubleFitsInt(operandNodeValue__);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doDoubleRepresentableAsSafeInteger(double) */) {
                if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue__)) && (JSGuards.isDoubleRepresentableAsLong(operandNodeValue__)) && (JSGuards.isDoubleSafeInteger(operandNodeValue__))) {
                    return doDoubleRepresentableAsSafeInteger(operandNodeValue__);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doDoubleRepresentableAsLong(double) */) {
                if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue__)) && (JSGuards.isDoubleRepresentableAsLong(operandNodeValue__))) {
                    return doDoubleRepresentableAsLong(operandNodeValue__);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doDouble(double) */) {
                if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue__)) && (!(JSGuards.isDoubleRepresentableAsLong(operandNodeValue__)))) {
                    return doDouble(operandNodeValue__);
                }
            }
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doUndefined(Object) || doNull(Object) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue_))) {
                    return doUndefined(operandNodeValue_);
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue_))) {
                    return doNull(operandNodeValue_);
                }
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doString(String, JSStringToNumberNode) */ && JSTypesGen.isImplicitString((state_0 & 0x700000) >>> 20 /* extract-implicit-state_0 0:String */, operandNodeValue_)) {
            String operandNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0x700000) >>> 20 /* extract-implicit-state_0 0:String */, operandNodeValue_);
            return doString(operandNodeValue__, this.string_stringToNumberNode_);
        }
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue_ instanceof Symbol) {
            Symbol operandNodeValue__ = (Symbol) operandNodeValue_;
            return doSymbol(operandNodeValue__);
        }
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return doBigInt(operandNodeValue__);
        }
        if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doJSObject(DynamicObject, JSToDoubleNode) */ && JSTypes.isDynamicObject(operandNodeValue_)) {
            DynamicObject operandNodeValue__ = (DynamicObject) operandNodeValue_;
            if ((JSGuards.isJSObject(operandNodeValue__)) && (!(isBitwiseOr()) || !(JSGuards.hasOverloadedOperators(operandNodeValue__)))) {
                return doJSObject(operandNodeValue__, this.jSObject_toDoubleNode_);
            }
        }
        if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */) {
            if ((JSGuards.isForeignObject(operandNodeValue_))) {
                return JSToInt32Node.doForeignObject(operandNodeValue_, this.foreignObject_toPrimitiveNode_, this.foreignObject_toInt32Node_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return (int) executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b10000000000000) == 0 /* only-active doInteger(int) && doSafeInteger(SafeInteger) && doBoolean(boolean) && doLong(long) && doDoubleFitsInt(double) && doDoubleRepresentableAsSafeInteger(double) && doDoubleRepresentableAsLong(double) && doDouble(double) && doUndefined(Object) && doNull(Object) && doString(String, JSStringToNumberNode) && doSymbol(Symbol) && doBigInt(BigInt) && doJSObject(DynamicObject, JSToDoubleNode) && doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */ && ((state_0 & 0b1111111111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doBoolean(boolean) && doLong(long) && doDoubleFitsInt(double) && doDoubleRepresentableAsSafeInteger(double) && doDoubleRepresentableAsLong(double) && doDouble(double) && doUndefined(Object) && doNull(Object) && doString(String, JSStringToNumberNode) && doSymbol(Symbol) && doBigInt(BigInt) && doOverloadedOperator(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doJSObject(DynamicObject, JSToDoubleNode) && doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */)) {
            executeInt(frameValue);
            return;
        }
        executeInt(frameValue);
        return;
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
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInteger(int) */;
                lock.unlock();
                hasLock = false;
                return doInteger(operandNodeValue_);
            }
            if (operandNodeValue instanceof SafeInteger) {
                SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doSafeInteger(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return doSafeInteger(operandNodeValue_);
            }
            if (operandNodeValue instanceof Boolean) {
                boolean operandNodeValue_ = (boolean) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return doBoolean(operandNodeValue_);
            }
            if (operandNodeValue instanceof Long) {
                long operandNodeValue_ = (long) operandNodeValue;
                if ((JSGuards.isLongRepresentableAsInt32(operandNodeValue_))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doLong(long) */;
                    lock.unlock();
                    hasLock = false;
                    return doLong(operandNodeValue_);
                }
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    if ((!(JSGuards.isDoubleLargerThan2e32(operandNodeValue_)))) {
                        state_0 = (state_0 | (doubleCast0 << 16) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doDoubleFitsInt(double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDoubleFitsInt(operandNodeValue_);
                    }
                    if ((exclude) == 0 /* is-not-exclude doDoubleRepresentableAsSafeInteger(double) */) {
                        if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue_)) && (JSGuards.isDoubleRepresentableAsLong(operandNodeValue_)) && (JSGuards.isDoubleSafeInteger(operandNodeValue_))) {
                            state_0 = (state_0 | (doubleCast0 << 16) /* set-implicit-state_0 0:double */);
                            this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doDoubleRepresentableAsSafeInteger(double) */;
                            lock.unlock();
                            hasLock = false;
                            return doDoubleRepresentableAsSafeInteger(operandNodeValue_);
                        }
                    }
                    if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue_)) && (JSGuards.isDoubleRepresentableAsLong(operandNodeValue_))) {
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude doDoubleRepresentableAsSafeInteger(double) */;
                        state_0 = state_0 & 0xffffffdf /* remove-state_0 doDoubleRepresentableAsSafeInteger(double) */;
                        state_0 = (state_0 | (doubleCast0 << 16) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doDoubleRepresentableAsLong(double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDoubleRepresentableAsLong(operandNodeValue_);
                    }
                    if ((JSGuards.isDoubleLargerThan2e32(operandNodeValue_)) && (!(JSGuards.isDoubleRepresentableAsLong(operandNodeValue_)))) {
                        state_0 = (state_0 | (doubleCast0 << 16) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doDouble(double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(operandNodeValue_);
                    }
                }
            }
            if ((JSGuards.isUndefined(operandNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return doUndefined(operandNodeValue);
            }
            if ((JSGuards.isJSNull(operandNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return doNull(operandNodeValue);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(operandNodeValue)) != 0) {
                    String operandNodeValue_ = JSTypesGen.asImplicitString(stringCast0, operandNodeValue);
                    this.string_stringToNumberNode_ = super.insert((JSStringToNumberNode.create()));
                    state_0 = (state_0 | (stringCast0 << 20) /* set-implicit-state_0 0:String */);
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doString(String, JSStringToNumberNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(operandNodeValue_, this.string_stringToNumberNode_);
                }
            }
            if (operandNodeValue instanceof Symbol) {
                Symbol operandNodeValue_ = (Symbol) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(operandNodeValue_);
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(operandNodeValue_);
            }
            if (operandNodeValue instanceof JSOverloadedOperatorsObject) {
                JSOverloadedOperatorsObject operandNodeValue_ = (JSOverloadedOperatorsObject) operandNodeValue;
                if ((isBitwiseOr())) {
                    this.overloadedOperator_overloadedOperatorNode_ = super.insert((JSOverloadedBinaryNode.createNumeric(getOverloadedOperatorName())));
                    this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 doOverloadedOperator(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doOverloadedOperator(operandNodeValue_, this.overloadedOperator_overloadedOperatorNode_);
                }
            }
            if (JSTypes.isDynamicObject(operandNodeValue)) {
                DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
                if ((JSGuards.isJSObject(operandNodeValue_)) && (!(isBitwiseOr()) || !(JSGuards.hasOverloadedOperators(operandNodeValue_)))) {
                    this.jSObject_toDoubleNode_ = super.insert((JSToDoubleNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b100000000000000 /* add-state_0 doJSObject(DynamicObject, JSToDoubleNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(operandNodeValue_, this.jSObject_toDoubleNode_);
                }
            }
            if ((JSGuards.isForeignObject(operandNodeValue))) {
                this.foreignObject_toPrimitiveNode_ = super.insert((JSToPrimitiveNode.createHintNumber()));
                this.foreignObject_toInt32Node_ = super.insert((JSToInt32Node.create()));
                this.state_0_ = state_0 = state_0 | 0b1000000000000000 /* add-state_0 doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */;
                lock.unlock();
                hasLock = false;
                return JSToInt32Node.doForeignObject(operandNodeValue, this.foreignObject_toPrimitiveNode_, this.foreignObject_toInt32Node_);
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
        if ((state_0 & 0b1111111111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111111111111111) & ((state_0 & 0b1111111111111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[17];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state_0 & 0b100) != 0 /* is-state_0 doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDoubleFitsInt";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDoubleFitsInt(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doDoubleRepresentableAsSafeInteger";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doDoubleRepresentableAsSafeInteger(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if (exclude != 0 /* is-exclude doDoubleRepresentableAsSafeInteger(double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doDoubleRepresentableAsLong";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doDoubleRepresentableAsLong(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doNull";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doString(String, JSStringToNumberNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.string_stringToNumberNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doOverloadedOperator";
        if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doOverloadedOperator(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.overloadedOperator_overloadedOperatorNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doJSObject(DynamicObject, JSToDoubleNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSObject_toDoubleNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[15] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doForeignObject(Object, JSToPrimitiveNode, JSToInt32Node) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.foreignObject_toPrimitiveNode_, this.foreignObject_toInt32Node_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[16] = s;
        return Provider.create(data);
    }

    public static JSToInt32Node create(JavaScriptNode operand, boolean bitwiseOr) {
        return new JSToInt32NodeGen(operand, bitwiseOr);
    }

}
