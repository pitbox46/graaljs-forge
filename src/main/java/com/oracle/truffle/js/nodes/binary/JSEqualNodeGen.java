// CheckStyle: start generated
package com.oracle.truffle.js.nodes.binary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToBooleanNode;
import com.oracle.truffle.js.nodes.cast.JSToPrimitiveNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSEqualNode.class)
@SuppressWarnings("unused")
public final class JSEqualNodeGen extends JSEqualNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int state_1_;
    @CompilationFinal private volatile int exclude_;
    @Child private InteropLibrary bInterop;
    @Child private InteropLibrary aInterop;
    @Child private JSToPrimitiveNode toPrimitive;
    @Child private JSEqualNode equal;
    @Child private JSOverloadedBinaryNode overloaded_overloadedOperatorNode_;
    @Child private JSToBooleanNode overloaded_toBooleanNode_;
    @CompilationFinal private NumberCachedData numberCached_cache;

    private JSEqualNodeGen(JavaScriptNode left, JavaScriptNode right) {
        super(left, right);
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object leftNodeValue, Object rightNodeValue) {
        int state_0 = this.state_0_;
        int state_1 = this.state_1_;
        if (((state_0 & 0b11) != 0 /* is-state_0 doInt(int, int) || doIntBoolean(int, boolean) */) && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if (((state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */) && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return JSEqualNode.doInt(leftNodeValue_, rightNodeValue_);
            }
            if (((state_0 & 0b10) != 0 /* is-state_0 doIntBoolean(int, boolean) */) && rightNodeValue instanceof Boolean) {
                boolean rightNodeValue_ = (boolean) rightNodeValue;
                return JSEqualNode.doIntBoolean(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, double) */) && JSTypesGen.isImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue);
                return JSEqualNode.doDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0b1000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */) && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return JSEqualNode.doBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0b110000) != 0 /* is-state_0 doDoubleString(double, String) || doDoubleBoolean(double, boolean) */) && JSTypesGen.isImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue);
            if (((state_0 & 0b10000) != 0 /* is-state_0 doDoubleString(double, String) */) && JSTypesGen.isImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue)) {
                String rightNodeValue_ = JSTypesGen.asImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue);
                return doDoubleString(leftNodeValue_, rightNodeValue_);
            }
            if (((state_0 & 0b100000) != 0 /* is-state_0 doDoubleBoolean(double, boolean) */) && rightNodeValue instanceof Boolean) {
                boolean rightNodeValue_ = (boolean) rightNodeValue;
                return JSEqualNode.doDoubleBoolean(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0b1111000000) != 0 /* is-state_0 doBoolean(boolean, boolean) || doBooleanInt(boolean, int) || doBooleanDouble(boolean, double) || doBooleanString(boolean, String) */) && leftNodeValue instanceof Boolean) {
            boolean leftNodeValue_ = (boolean) leftNodeValue;
            if (((state_0 & 0b1000000) != 0 /* is-state_0 doBoolean(boolean, boolean) */) && rightNodeValue instanceof Boolean) {
                boolean rightNodeValue_ = (boolean) rightNodeValue;
                return JSEqualNode.doBoolean(leftNodeValue_, rightNodeValue_);
            }
            if (((state_0 & 0b10000000) != 0 /* is-state_0 doBooleanInt(boolean, int) */) && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return JSEqualNode.doBooleanInt(leftNodeValue_, rightNodeValue_);
            }
            if (((state_0 & 0b100000000) != 0 /* is-state_0 doBooleanDouble(boolean, double) */) && JSTypesGen.isImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue);
                return JSEqualNode.doBooleanDouble(leftNodeValue_, rightNodeValue_);
            }
            if (((state_0 & 0b1000000000) != 0 /* is-state_0 doBooleanString(boolean, String) */) && JSTypesGen.isImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue)) {
                String rightNodeValue_ = JSTypesGen.asImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue);
                return doBooleanString(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0b111110000000000) != 0 /* is-state_0 doStringIdentity(String, String) || doString(String, String) || doStringDouble(String, double) || doStringBoolean(String, boolean) || doStringBigInt(String, BigInt) */) && JSTypesGen.isImplicitString((state_1 & 0xe0000) >>> 17 /* extract-implicit-state_1 0:String */, leftNodeValue)) {
            String leftNodeValue_ = JSTypesGen.asImplicitString((state_1 & 0xe0000) >>> 17 /* extract-implicit-state_1 0:String */, leftNodeValue);
            if (((state_0 & 0b110000000000) != 0 /* is-state_0 doStringIdentity(String, String) || doString(String, String) */) && JSTypesGen.isImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue)) {
                String rightNodeValue_ = JSTypesGen.asImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue);
                if (((state_0 & 0b10000000000) != 0 /* is-state_0 doStringIdentity(String, String) */)) {
                    if ((JSGuards.isReferenceEquals(leftNodeValue_, rightNodeValue_))) {
                        return JSEqualNode.doStringIdentity(leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((state_0 & 0b100000000000) != 0 /* is-state_0 doString(String, String) */)) {
                    return JSEqualNode.doString(leftNodeValue_, rightNodeValue_);
                }
            }
            if (((state_0 & 0b1000000000000) != 0 /* is-state_0 doStringDouble(String, double) */) && JSTypesGen.isImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue);
                return doStringDouble(leftNodeValue_, rightNodeValue_);
            }
            if (((state_0 & 0b10000000000000) != 0 /* is-state_0 doStringBoolean(String, boolean) */) && rightNodeValue instanceof Boolean) {
                boolean rightNodeValue_ = (boolean) rightNodeValue;
                return doStringBoolean(leftNodeValue_, rightNodeValue_);
            }
            if (((state_0 & 0b100000000000000) != 0 /* is-state_0 doStringBigInt(String, BigInt) */) && rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doStringBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0b1000000000000000) != 0 /* is-state_0 doBigIntString(BigInt, String) */) && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (JSTypesGen.isImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue)) {
                String rightNodeValue_ = JSTypesGen.asImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue);
                return doBigIntString(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0x10000) != 0 /* is-state_0 doBooleanBigInt(boolean, BigInt) */) && leftNodeValue instanceof Boolean) {
            boolean leftNodeValue_ = (boolean) leftNodeValue;
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doBooleanBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0x20000) != 0 /* is-state_0 doBigIntBoolean(BigInt, boolean) */) && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (rightNodeValue instanceof Boolean) {
                boolean rightNodeValue_ = (boolean) rightNodeValue;
                return doBigIntBoolean(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0x7c0000) != 0 /* is-state_0 doBothNullOrUndefined(Object, Object) || doLeftNullOrUndefined(Object, Object, InteropLibrary) || doRightNullOrUndefined(Object, Object, InteropLibrary) || doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) || doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) */)) {
            if (((state_0 & 0x3c0000) != 0 /* is-state_0 doBothNullOrUndefined(Object, Object) || doLeftNullOrUndefined(Object, Object, InteropLibrary) || doRightNullOrUndefined(Object, Object, InteropLibrary) || doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) */)) {
                if (((state_0 & 0x40000) != 0 /* is-state_0 doBothNullOrUndefined(Object, Object) */)) {
                    if ((JSRuntime.isNullOrUndefined(leftNodeValue)) && (JSRuntime.isNullOrUndefined(rightNodeValue))) {
                        return JSEqualNode.doBothNullOrUndefined(leftNodeValue, rightNodeValue);
                    }
                }
                if (((state_0 & 0x80000) != 0 /* is-state_0 doLeftNullOrUndefined(Object, Object, InteropLibrary) */)) {
                    if ((JSRuntime.isNullOrUndefined(leftNodeValue))) {
                        return JSEqualNode.doLeftNullOrUndefined(leftNodeValue, rightNodeValue, this.bInterop);
                    }
                }
                if (((state_0 & 0x100000) != 0 /* is-state_0 doRightNullOrUndefined(Object, Object, InteropLibrary) */)) {
                    if ((JSRuntime.isNullOrUndefined(rightNodeValue))) {
                        return JSEqualNode.doRightNullOrUndefined(leftNodeValue, rightNodeValue, this.aInterop);
                    }
                }
                if (((state_0 & 0x200000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) */)) {
                    if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                        return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_, this.overloaded_toBooleanNode_);
                    }
                }
            }
            if (((state_0 & 0x400000) != 0 /* is-state_0 doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) */) && JSTypes.isDynamicObject(leftNodeValue)) {
                DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
                if ((JSRuntime.isObject(leftNodeValue_)) && (!(JSRuntime.isObject(rightNodeValue))) && (!(JSGuards.hasOverloadedOperators(leftNodeValue_)))) {
                    return doJSObject(leftNodeValue_, rightNodeValue, this.bInterop, this.toPrimitive, this.equal);
                }
            }
        }
        if (((state_0 & 0x800000) != 0 /* is-state_0 doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) */) && JSTypes.isDynamicObject(rightNodeValue)) {
            DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
            if ((!(JSRuntime.isObject(leftNodeValue))) && (JSRuntime.isObject(rightNodeValue_)) && (!(JSGuards.hasOverloadedOperators(rightNodeValue_)))) {
                return doJSObject(leftNodeValue, rightNodeValue_, this.aInterop, this.toPrimitive, this.equal);
            }
        }
        if (((state_0 & 0x3000000) != 0 /* is-state_0 doBigIntAndInt(BigInt, int) || doBigIntAndNumber(BigInt, double) */) && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (((state_0 & 0x1000000) != 0 /* is-state_0 doBigIntAndInt(BigInt, int) */) && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return doBigIntAndInt(leftNodeValue_, rightNodeValue_);
            }
            if (((state_0 & 0x2000000) != 0 /* is-state_0 doBigIntAndNumber(BigInt, double) */) && JSTypesGen.isImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue);
                return doBigIntAndNumber(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0xc000000) != 0 /* is-state_0 doIntAndBigInt(int, BigInt) || doNumberAndBigInt(double, BigInt) */) && rightNodeValue instanceof BigInt) {
            BigInt rightNodeValue_ = (BigInt) rightNodeValue;
            if (((state_0 & 0x4000000) != 0 /* is-state_0 doIntAndBigInt(int, BigInt) */) && leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                return doIntAndBigInt(leftNodeValue_, rightNodeValue_);
            }
            if (((state_0 & 0x8000000) != 0 /* is-state_0 doNumberAndBigInt(double, BigInt) */) && JSTypesGen.isImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue)) {
                double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue);
                return doNumberAndBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0x10000000) != 0 /* is-state_0 doJSObject(DynamicObject, DynamicObject) */) && JSTypes.isDynamicObject(leftNodeValue)) {
            DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
            if (JSTypes.isDynamicObject(rightNodeValue)) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                if ((!(JSRuntime.isNullOrUndefined(leftNodeValue_))) && (JSGuards.isJSDynamicObject(leftNodeValue_)) && (JSGuards.isJSDynamicObject(rightNodeValue_))) {
                    return JSEqualNode.doJSObject(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if (((state_0 & 0x60000000) != 0 /* is-state_0 doSymbol(Symbol, Symbol) || doSymbolNotSymbol(Symbol, Object) */) && leftNodeValue instanceof Symbol) {
            Symbol leftNodeValue_ = (Symbol) leftNodeValue;
            if (((state_0 & 0x20000000) != 0 /* is-state_0 doSymbol(Symbol, Symbol) */) && rightNodeValue instanceof Symbol) {
                Symbol rightNodeValue_ = (Symbol) rightNodeValue;
                return JSEqualNode.doSymbol(leftNodeValue_, rightNodeValue_);
            }
            if (((state_0 & 0x40000000) != 0 /* is-state_0 doSymbolNotSymbol(Symbol, Object) */)) {
                if ((!(JSGuards.isSymbol(rightNodeValue))) && (!(JSRuntime.isObject(rightNodeValue)))) {
                    return JSEqualNode.doSymbolNotSymbol(leftNodeValue_, rightNodeValue);
                }
            }
        }
        if (((state_0 & 0x80000000) != 0 /* is-state_0 doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b11) != 0 /* is-state_1 doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) || doNumberCached(Object, Object, Class<>, Class<>) */)) {
            if (((state_0 & 0x80000000) != 0 /* is-state_0 doSymbolNotSymbol(Object, Symbol) */) && rightNodeValue instanceof Symbol) {
                Symbol rightNodeValue_ = (Symbol) rightNodeValue;
                if ((!(JSGuards.isSymbol(leftNodeValue))) && (!(JSRuntime.isObject(leftNodeValue)))) {
                    return JSEqualNode.doSymbolNotSymbol(leftNodeValue, rightNodeValue_);
                }
            }
            if (((state_1 & 0b11) != 0 /* is-state_1 doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) || doNumberCached(Object, Object, Class<>, Class<>) */)) {
                if (((state_1 & 0b1) != 0 /* is-state_1 doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) */)) {
                    if ((JSRuntime.isForeignObject(leftNodeValue) || JSRuntime.isForeignObject(rightNodeValue))) {
                        return doForeign(leftNodeValue, rightNodeValue, this.aInterop, this.bInterop, this.equal);
                    }
                }
                if (((state_1 & 0b10) != 0 /* is-state_1 doNumberCached(Object, Object, Class<>, Class<>) */) && (leftNodeValue != null) && (rightNodeValue != null)) {
                    NumberCachedData s33_ = this.numberCached_cache;
                    while (s33_ != null) {
                        assert (s33_.cachedClassA_ != null);
                        assert (s33_.cachedClassB_ != null);
                        if ((leftNodeValue.getClass() == s33_.cachedClassA_) && (rightNodeValue.getClass() == s33_.cachedClassB_)) {
                            return JSEqualNode.doNumberCached(leftNodeValue, rightNodeValue, s33_.cachedClassA_, s33_.cachedClassB_);
                        }
                        s33_ = s33_.next_;
                    }
                }
            }
        }
        if (((state_1 & 0b100) != 0 /* is-state_1 doNumber(Number, Number) */) && leftNodeValue instanceof Number) {
            Number leftNodeValue_ = (Number) leftNodeValue;
            if (rightNodeValue instanceof Number) {
                Number rightNodeValue_ = (Number) rightNodeValue;
                if ((JSRuntime.isJavaNumber(leftNodeValue_)) && (JSRuntime.isJavaNumber(rightNodeValue_))) {
                    return JSEqualNode.doNumber(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if (((state_1 & 0b1000) != 0 /* is-state_1 doStringNumber(Object, String) */) && JSTypesGen.isImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue)) {
            String rightNodeValue_ = JSTypesGen.asImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue);
            if ((JSRuntime.isJavaNumber(leftNodeValue))) {
                return doStringNumber(leftNodeValue, rightNodeValue_);
            }
        }
        if (((state_1 & 0b110000) != 0 /* is-state_1 doStringNumber(String, Object) || doFallback(Object, Object) */)) {
            if (((state_1 & 0b10000) != 0 /* is-state_1 doStringNumber(String, Object) */) && JSTypesGen.isImplicitString((state_1 & 0xe0000) >>> 17 /* extract-implicit-state_1 0:String */, leftNodeValue)) {
                String leftNodeValue_ = JSTypesGen.asImplicitString((state_1 & 0xe0000) >>> 17 /* extract-implicit-state_1 0:String */, leftNodeValue);
                if ((JSRuntime.isJavaNumber(rightNodeValue))) {
                    return doStringNumber(leftNodeValue_, rightNodeValue);
                }
            }
            if (((state_1 & 0b100000) != 0 /* is-state_1 doFallback(Object, Object) */)) {
                if (fallbackGuard_(state_0, state_1, leftNodeValue, rightNodeValue)) {
                    return JSEqualNode.doFallback(leftNodeValue, rightNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue, rightNodeValue);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        int state_1 = this.state_1_;
        if ((state_0 & 0xfffffffe) == 0 /* only-active doInt(int, int) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_int_int0(state_0, state_1, frameValue);
        } else if ((state_0 & 0xfffffffd) == 0 /* only-active doIntBoolean(int, boolean) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_int_boolean1(state_0, state_1, frameValue);
        } else if ((state_0 & 0xfffffffb) == 0 /* only-active doDouble(double, double) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_double_double2(state_0, state_1, frameValue);
        } else if ((state_0 & 0xffffffdf) == 0 /* only-active doDoubleBoolean(double, boolean) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_double_boolean3(state_0, state_1, frameValue);
        } else if ((state_0 & 0xffffffbf) == 0 /* only-active doBoolean(boolean, boolean) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_boolean_boolean4(state_0, state_1, frameValue);
        } else if ((state_0 & 0xffffff7f) == 0 /* only-active doBooleanInt(boolean, int) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_boolean_int5(state_0, state_1, frameValue);
        } else if ((state_0 & 0xfffffeff) == 0 /* only-active doBooleanDouble(boolean, double) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_boolean_double6(state_0, state_1, frameValue);
        } else if ((state_0 & 0xf7ffffcf) == 0 /* only-active doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doNumberAndBigInt(double, BigInt) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_double7(state_0, state_1, frameValue);
        } else if ((state_0 & 0xfffefdff) == 0 /* only-active doBooleanString(boolean, String) && doBooleanBigInt(boolean, BigInt) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_boolean8(state_0, state_1, frameValue);
        } else if ((state_0 & 0xfdffefff) == 0 /* only-active doStringDouble(String, double) && doBigIntAndNumber(BigInt, double) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_double9(state_0, state_1, frameValue);
        } else if ((state_0 & 0xfffddfff) == 0 /* only-active doStringBoolean(String, boolean) && doBigIntBoolean(BigInt, boolean) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_boolean10(state_0, state_1, frameValue);
        } else if ((state_0 & 0xfeffffff) == 0 /* only-active doBigIntAndInt(BigInt, int) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_int11(state_0, state_1, frameValue);
        } else if ((state_0 & 0xfbffffff) == 0 /* only-active doIntAndBigInt(int, BigInt) */ && (state_1 & 0b111111) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
            return executeBoolean_int12(state_0, state_1, frameValue);
        } else {
            return executeBoolean_generic13(state_0, state_1, frameValue);
        }
    }

    private boolean executeBoolean_int_int0(int state_0, int state_1, VirtualFrame frameValue) {
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
        assert ((state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */);
        return JSEqualNode.doInt(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_int_boolean1(int state_0, int state_1, VirtualFrame frameValue) {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        boolean rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert ((state_0 & 0b10) != 0 /* is-state_0 doIntBoolean(int, boolean) */);
        return JSEqualNode.doIntBoolean(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_double_double2(int state_0, int state_1, VirtualFrame frameValue) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_1 & 0b1110000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_1 & 0b1101000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_1 & 0b1011000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_1 & 0b11100000000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_1 & 0b11010000000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_1 & 0b10110000000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state_1 & 0b1110000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */) ? (Object) leftNodeValue_long : ((state_1 & 0b1101000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, double) */);
        return JSEqualNode.doDouble(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_double_boolean3(int state_0, int state_1, VirtualFrame frameValue) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_1 & 0b1110000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_1 & 0b1101000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_1 & 0b1011000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        boolean rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state_1 & 0b1110000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */) ? (Object) leftNodeValue_long : ((state_1 & 0b1101000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert ((state_0 & 0b100000) != 0 /* is-state_0 doDoubleBoolean(double, boolean) */);
        return JSEqualNode.doDoubleBoolean(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_boolean_boolean4(int state_0, int state_1, VirtualFrame frameValue) {
        boolean leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        boolean rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert ((state_0 & 0b1000000) != 0 /* is-state_0 doBoolean(boolean, boolean) */);
        return JSEqualNode.doBoolean(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_boolean_int5(int state_0, int state_1, VirtualFrame frameValue) {
        boolean leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeBoolean(frameValue);
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
        assert ((state_0 & 0b10000000) != 0 /* is-state_0 doBooleanInt(boolean, int) */);
        return JSEqualNode.doBooleanInt(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_boolean_double6(int state_0, int state_1, VirtualFrame frameValue) {
        boolean leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_1 & 0b11100000000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_1 & 0b11010000000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_1 & 0b10110000000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert ((state_0 & 0b100000000) != 0 /* is-state_0 doBooleanDouble(boolean, double) */);
        return JSEqualNode.doBooleanDouble(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_double7(int state_0, int state_1, VirtualFrame frameValue) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_1 & 0b1110000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_1 & 0b1101000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_1 & 0b1011000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if (((state_0 & 0b10000) != 0 /* is-state_0 doDoubleString(double, String) */) && JSTypesGen.isImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_)) {
            String rightNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_);
            return doDoubleString(leftNodeValue_, rightNodeValue__);
        }
        if (((state_0 & 0b100000) != 0 /* is-state_0 doDoubleBoolean(double, boolean) */) && rightNodeValue_ instanceof Boolean) {
            boolean rightNodeValue__ = (boolean) rightNodeValue_;
            return JSEqualNode.doDoubleBoolean(leftNodeValue_, rightNodeValue__);
        }
        if (((state_0 & 0x8000000) != 0 /* is-state_0 doNumberAndBigInt(double, BigInt) */) && rightNodeValue_ instanceof BigInt) {
            BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
            return doNumberAndBigInt(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(((state_1 & 0b1110000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */) ? (Object) leftNodeValue_long : ((state_1 & 0b1101000000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), rightNodeValue_);
    }

    private boolean executeBoolean_boolean8(int state_0, int state_1, VirtualFrame frameValue) {
        boolean leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if (((state_0 & 0b1000000000) != 0 /* is-state_0 doBooleanString(boolean, String) */) && JSTypesGen.isImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_)) {
            String rightNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_);
            return doBooleanString(leftNodeValue_, rightNodeValue__);
        }
        if (((state_0 & 0x10000) != 0 /* is-state_0 doBooleanBigInt(boolean, BigInt) */) && rightNodeValue_ instanceof BigInt) {
            BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
            return doBooleanBigInt(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_double9(int state_0, int state_1, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_1 & 0b11100000000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_1 & 0b11010000000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_1 & 0b10110000000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        if (((state_0 & 0b1000000000000) != 0 /* is-state_0 doStringDouble(String, double) */) && JSTypesGen.isImplicitString((state_1 & 0xe0000) >>> 17 /* extract-implicit-state_1 0:String */, leftNodeValue_)) {
            String leftNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0xe0000) >>> 17 /* extract-implicit-state_1 0:String */, leftNodeValue_);
            return doStringDouble(leftNodeValue__, rightNodeValue_);
        }
        if (((state_0 & 0x2000000) != 0 /* is-state_0 doBigIntAndNumber(BigInt, double) */) && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            return doBigIntAndNumber(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, ((state_1 & 0b11100000000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */) ? (Object) rightNodeValue_long : ((state_1 & 0b11010000000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doIntBoolean(int, boolean) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doDoubleString(double, String) && doDoubleBoolean(double, boolean) && doBoolean(boolean, boolean) && doBooleanInt(boolean, int) && doBooleanDouble(boolean, double) && doBooleanString(boolean, String) && doStringIdentity(String, String) && doString(String, String) && doStringDouble(String, double) && doStringBoolean(String, boolean) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBooleanBigInt(boolean, BigInt) && doBigIntBoolean(BigInt, boolean) && doBothNullOrUndefined(Object, Object) && doLeftNullOrUndefined(Object, Object, InteropLibrary) && doRightNullOrUndefined(Object, Object, InteropLibrary) && doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) && doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJSObject(DynamicObject, DynamicObject) && doSymbol(Symbol, Symbol) && doSymbolNotSymbol(Symbol, Object) && doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b111111) != 0  /* is-not doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doStringNumber(Object, String) && doStringNumber(String, Object) && doFallback(Object, Object) */) ? (Object) rightNodeValue_int : (Object) rightNodeValue_)));
    }

    private boolean executeBoolean_boolean10(int state_0, int state_1, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        boolean rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        if (((state_0 & 0b10000000000000) != 0 /* is-state_0 doStringBoolean(String, boolean) */) && JSTypesGen.isImplicitString((state_1 & 0xe0000) >>> 17 /* extract-implicit-state_1 0:String */, leftNodeValue_)) {
            String leftNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0xe0000) >>> 17 /* extract-implicit-state_1 0:String */, leftNodeValue_);
            return doStringBoolean(leftNodeValue__, rightNodeValue_);
        }
        if (((state_0 & 0x20000) != 0 /* is-state_0 doBigIntBoolean(BigInt, boolean) */) && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            return doBigIntBoolean(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_int11(int state_0, int state_1, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert ((state_0 & 0x1000000) != 0 /* is-state_0 doBigIntAndInt(BigInt, int) */);
        if (leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            return doBigIntAndInt(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_int12(int state_0, int state_1, VirtualFrame frameValue) {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        assert ((state_0 & 0x4000000) != 0 /* is-state_0 doIntAndBigInt(int, BigInt) */);
        if (rightNodeValue_ instanceof BigInt) {
            BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
            return doIntAndBigInt(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @ExplodeLoop
    private boolean executeBoolean_generic13(int state_0, int state_1, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if (((state_0 & 0b11) != 0 /* is-state_0 doInt(int, int) || doIntBoolean(int, boolean) */) && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if (((state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */) && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return JSEqualNode.doInt(leftNodeValue__, rightNodeValue__);
            }
            if (((state_0 & 0b10) != 0 /* is-state_0 doIntBoolean(int, boolean) */) && rightNodeValue_ instanceof Boolean) {
                boolean rightNodeValue__ = (boolean) rightNodeValue_;
                return JSEqualNode.doIntBoolean(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, double) */) && JSTypesGen.isImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue_);
                return JSEqualNode.doDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0b1000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */) && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return JSEqualNode.doBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0b110000) != 0 /* is-state_0 doDoubleString(double, String) || doDoubleBoolean(double, boolean) */) && JSTypesGen.isImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue_);
            if (((state_0 & 0b10000) != 0 /* is-state_0 doDoubleString(double, String) */) && JSTypesGen.isImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_);
                return doDoubleString(leftNodeValue__, rightNodeValue__);
            }
            if (((state_0 & 0b100000) != 0 /* is-state_0 doDoubleBoolean(double, boolean) */) && rightNodeValue_ instanceof Boolean) {
                boolean rightNodeValue__ = (boolean) rightNodeValue_;
                return JSEqualNode.doDoubleBoolean(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0b1111000000) != 0 /* is-state_0 doBoolean(boolean, boolean) || doBooleanInt(boolean, int) || doBooleanDouble(boolean, double) || doBooleanString(boolean, String) */) && leftNodeValue_ instanceof Boolean) {
            boolean leftNodeValue__ = (boolean) leftNodeValue_;
            if (((state_0 & 0b1000000) != 0 /* is-state_0 doBoolean(boolean, boolean) */) && rightNodeValue_ instanceof Boolean) {
                boolean rightNodeValue__ = (boolean) rightNodeValue_;
                return JSEqualNode.doBoolean(leftNodeValue__, rightNodeValue__);
            }
            if (((state_0 & 0b10000000) != 0 /* is-state_0 doBooleanInt(boolean, int) */) && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return JSEqualNode.doBooleanInt(leftNodeValue__, rightNodeValue__);
            }
            if (((state_0 & 0b100000000) != 0 /* is-state_0 doBooleanDouble(boolean, double) */) && JSTypesGen.isImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue_);
                return JSEqualNode.doBooleanDouble(leftNodeValue__, rightNodeValue__);
            }
            if (((state_0 & 0b1000000000) != 0 /* is-state_0 doBooleanString(boolean, String) */) && JSTypesGen.isImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_);
                return doBooleanString(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0b111110000000000) != 0 /* is-state_0 doStringIdentity(String, String) || doString(String, String) || doStringDouble(String, double) || doStringBoolean(String, boolean) || doStringBigInt(String, BigInt) */) && JSTypesGen.isImplicitString((state_1 & 0xe0000) >>> 17 /* extract-implicit-state_1 0:String */, leftNodeValue_)) {
            String leftNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0xe0000) >>> 17 /* extract-implicit-state_1 0:String */, leftNodeValue_);
            if (((state_0 & 0b110000000000) != 0 /* is-state_0 doStringIdentity(String, String) || doString(String, String) */) && JSTypesGen.isImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_);
                if (((state_0 & 0b10000000000) != 0 /* is-state_0 doStringIdentity(String, String) */)) {
                    if ((JSGuards.isReferenceEquals(leftNodeValue__, rightNodeValue__))) {
                        return JSEqualNode.doStringIdentity(leftNodeValue__, rightNodeValue__);
                    }
                }
                if (((state_0 & 0b100000000000) != 0 /* is-state_0 doString(String, String) */)) {
                    return JSEqualNode.doString(leftNodeValue__, rightNodeValue__);
                }
            }
            if (((state_0 & 0b1000000000000) != 0 /* is-state_0 doStringDouble(String, double) */) && JSTypesGen.isImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue_);
                return doStringDouble(leftNodeValue__, rightNodeValue__);
            }
            if (((state_0 & 0b10000000000000) != 0 /* is-state_0 doStringBoolean(String, boolean) */) && rightNodeValue_ instanceof Boolean) {
                boolean rightNodeValue__ = (boolean) rightNodeValue_;
                return doStringBoolean(leftNodeValue__, rightNodeValue__);
            }
            if (((state_0 & 0b100000000000000) != 0 /* is-state_0 doStringBigInt(String, BigInt) */) && rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doStringBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0b1000000000000000) != 0 /* is-state_0 doBigIntString(BigInt, String) */) && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (JSTypesGen.isImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_);
                return doBigIntString(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0x10000) != 0 /* is-state_0 doBooleanBigInt(boolean, BigInt) */) && leftNodeValue_ instanceof Boolean) {
            boolean leftNodeValue__ = (boolean) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doBooleanBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0x20000) != 0 /* is-state_0 doBigIntBoolean(BigInt, boolean) */) && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof Boolean) {
                boolean rightNodeValue__ = (boolean) rightNodeValue_;
                return doBigIntBoolean(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0x7c0000) != 0 /* is-state_0 doBothNullOrUndefined(Object, Object) || doLeftNullOrUndefined(Object, Object, InteropLibrary) || doRightNullOrUndefined(Object, Object, InteropLibrary) || doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) || doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) */)) {
            if (((state_0 & 0x3c0000) != 0 /* is-state_0 doBothNullOrUndefined(Object, Object) || doLeftNullOrUndefined(Object, Object, InteropLibrary) || doRightNullOrUndefined(Object, Object, InteropLibrary) || doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) */)) {
                if (((state_0 & 0x40000) != 0 /* is-state_0 doBothNullOrUndefined(Object, Object) */)) {
                    if ((JSRuntime.isNullOrUndefined(leftNodeValue_)) && (JSRuntime.isNullOrUndefined(rightNodeValue_))) {
                        return JSEqualNode.doBothNullOrUndefined(leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((state_0 & 0x80000) != 0 /* is-state_0 doLeftNullOrUndefined(Object, Object, InteropLibrary) */)) {
                    if ((JSRuntime.isNullOrUndefined(leftNodeValue_))) {
                        return JSEqualNode.doLeftNullOrUndefined(leftNodeValue_, rightNodeValue_, this.bInterop);
                    }
                }
                if (((state_0 & 0x100000) != 0 /* is-state_0 doRightNullOrUndefined(Object, Object, InteropLibrary) */)) {
                    if ((JSRuntime.isNullOrUndefined(rightNodeValue_))) {
                        return JSEqualNode.doRightNullOrUndefined(leftNodeValue_, rightNodeValue_, this.aInterop);
                    }
                }
                if (((state_0 & 0x200000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) */)) {
                    if ((JSGuards.hasOverloadedOperators(leftNodeValue_) || JSGuards.hasOverloadedOperators(rightNodeValue_))) {
                        return doOverloaded(leftNodeValue_, rightNodeValue_, this.overloaded_overloadedOperatorNode_, this.overloaded_toBooleanNode_);
                    }
                }
            }
            if (((state_0 & 0x400000) != 0 /* is-state_0 doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) */) && JSTypes.isDynamicObject(leftNodeValue_)) {
                DynamicObject leftNodeValue__ = (DynamicObject) leftNodeValue_;
                if ((JSRuntime.isObject(leftNodeValue__)) && (!(JSRuntime.isObject(rightNodeValue_))) && (!(JSGuards.hasOverloadedOperators(leftNodeValue__)))) {
                    return doJSObject(leftNodeValue__, rightNodeValue_, this.bInterop, this.toPrimitive, this.equal);
                }
            }
        }
        if (((state_0 & 0x800000) != 0 /* is-state_0 doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) */) && JSTypes.isDynamicObject(rightNodeValue_)) {
            DynamicObject rightNodeValue__ = (DynamicObject) rightNodeValue_;
            if ((!(JSRuntime.isObject(leftNodeValue_))) && (JSRuntime.isObject(rightNodeValue__)) && (!(JSGuards.hasOverloadedOperators(rightNodeValue__)))) {
                return doJSObject(leftNodeValue_, rightNodeValue__, this.aInterop, this.toPrimitive, this.equal);
            }
        }
        if (((state_0 & 0x3000000) != 0 /* is-state_0 doBigIntAndInt(BigInt, int) || doBigIntAndNumber(BigInt, double) */) && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (((state_0 & 0x1000000) != 0 /* is-state_0 doBigIntAndInt(BigInt, int) */) && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return doBigIntAndInt(leftNodeValue__, rightNodeValue__);
            }
            if (((state_0 & 0x2000000) != 0 /* is-state_0 doBigIntAndNumber(BigInt, double) */) && JSTypesGen.isImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_1 & 0b11110000000000) >>> 10 /* extract-implicit-state_1 1:double */, rightNodeValue_);
                return doBigIntAndNumber(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0xc000000) != 0 /* is-state_0 doIntAndBigInt(int, BigInt) || doNumberAndBigInt(double, BigInt) */) && rightNodeValue_ instanceof BigInt) {
            BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
            if (((state_0 & 0x4000000) != 0 /* is-state_0 doIntAndBigInt(int, BigInt) */) && leftNodeValue_ instanceof Integer) {
                int leftNodeValue__ = (int) leftNodeValue_;
                return doIntAndBigInt(leftNodeValue__, rightNodeValue__);
            }
            if (((state_0 & 0x8000000) != 0 /* is-state_0 doNumberAndBigInt(double, BigInt) */) && JSTypesGen.isImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue_)) {
                double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 0:double */, leftNodeValue_);
                return doNumberAndBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0x10000000) != 0 /* is-state_0 doJSObject(DynamicObject, DynamicObject) */) && JSTypes.isDynamicObject(leftNodeValue_)) {
            DynamicObject leftNodeValue__ = (DynamicObject) leftNodeValue_;
            if (JSTypes.isDynamicObject(rightNodeValue_)) {
                DynamicObject rightNodeValue__ = (DynamicObject) rightNodeValue_;
                if ((!(JSRuntime.isNullOrUndefined(leftNodeValue__))) && (JSGuards.isJSDynamicObject(leftNodeValue__)) && (JSGuards.isJSDynamicObject(rightNodeValue__))) {
                    return JSEqualNode.doJSObject(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if (((state_0 & 0x60000000) != 0 /* is-state_0 doSymbol(Symbol, Symbol) || doSymbolNotSymbol(Symbol, Object) */) && leftNodeValue_ instanceof Symbol) {
            Symbol leftNodeValue__ = (Symbol) leftNodeValue_;
            if (((state_0 & 0x20000000) != 0 /* is-state_0 doSymbol(Symbol, Symbol) */) && rightNodeValue_ instanceof Symbol) {
                Symbol rightNodeValue__ = (Symbol) rightNodeValue_;
                return JSEqualNode.doSymbol(leftNodeValue__, rightNodeValue__);
            }
            if (((state_0 & 0x40000000) != 0 /* is-state_0 doSymbolNotSymbol(Symbol, Object) */)) {
                if ((!(JSGuards.isSymbol(rightNodeValue_))) && (!(JSRuntime.isObject(rightNodeValue_)))) {
                    return JSEqualNode.doSymbolNotSymbol(leftNodeValue__, rightNodeValue_);
                }
            }
        }
        if (((state_0 & 0x80000000) != 0 /* is-state_0 doSymbolNotSymbol(Object, Symbol) */ || (state_1 & 0b11) != 0 /* is-state_1 doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) || doNumberCached(Object, Object, Class<>, Class<>) */)) {
            if (((state_0 & 0x80000000) != 0 /* is-state_0 doSymbolNotSymbol(Object, Symbol) */) && rightNodeValue_ instanceof Symbol) {
                Symbol rightNodeValue__ = (Symbol) rightNodeValue_;
                if ((!(JSGuards.isSymbol(leftNodeValue_))) && (!(JSRuntime.isObject(leftNodeValue_)))) {
                    return JSEqualNode.doSymbolNotSymbol(leftNodeValue_, rightNodeValue__);
                }
            }
            if (((state_1 & 0b11) != 0 /* is-state_1 doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) || doNumberCached(Object, Object, Class<>, Class<>) */)) {
                if (((state_1 & 0b1) != 0 /* is-state_1 doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) */)) {
                    if ((JSRuntime.isForeignObject(leftNodeValue_) || JSRuntime.isForeignObject(rightNodeValue_))) {
                        return doForeign(leftNodeValue_, rightNodeValue_, this.aInterop, this.bInterop, this.equal);
                    }
                }
                if (((state_1 & 0b10) != 0 /* is-state_1 doNumberCached(Object, Object, Class<>, Class<>) */) && (leftNodeValue_ != null) && (rightNodeValue_ != null)) {
                    NumberCachedData s33_ = this.numberCached_cache;
                    while (s33_ != null) {
                        assert (s33_.cachedClassA_ != null);
                        assert (s33_.cachedClassB_ != null);
                        if ((leftNodeValue_.getClass() == s33_.cachedClassA_) && (rightNodeValue_.getClass() == s33_.cachedClassB_)) {
                            return JSEqualNode.doNumberCached(leftNodeValue_, rightNodeValue_, s33_.cachedClassA_, s33_.cachedClassB_);
                        }
                        s33_ = s33_.next_;
                    }
                }
            }
        }
        if (((state_1 & 0b100) != 0 /* is-state_1 doNumber(Number, Number) */) && leftNodeValue_ instanceof Number) {
            Number leftNodeValue__ = (Number) leftNodeValue_;
            if (rightNodeValue_ instanceof Number) {
                Number rightNodeValue__ = (Number) rightNodeValue_;
                if ((JSRuntime.isJavaNumber(leftNodeValue__)) && (JSRuntime.isJavaNumber(rightNodeValue__))) {
                    return JSEqualNode.doNumber(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if (((state_1 & 0b1000) != 0 /* is-state_1 doStringNumber(Object, String) */) && JSTypesGen.isImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_)) {
            String rightNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0x1c000) >>> 14 /* extract-implicit-state_1 1:String */, rightNodeValue_);
            if ((JSRuntime.isJavaNumber(leftNodeValue_))) {
                return doStringNumber(leftNodeValue_, rightNodeValue__);
            }
        }
        if (((state_1 & 0b110000) != 0 /* is-state_1 doStringNumber(String, Object) || doFallback(Object, Object) */)) {
            if (((state_1 & 0b10000) != 0 /* is-state_1 doStringNumber(String, Object) */) && JSTypesGen.isImplicitString((state_1 & 0xe0000) >>> 17 /* extract-implicit-state_1 0:String */, leftNodeValue_)) {
                String leftNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0xe0000) >>> 17 /* extract-implicit-state_1 0:String */, leftNodeValue_);
                if ((JSRuntime.isJavaNumber(rightNodeValue_))) {
                    return doStringNumber(leftNodeValue__, rightNodeValue_);
                }
            }
            if (((state_1 & 0b100000) != 0 /* is-state_1 doFallback(Object, Object) */)) {
                if (fallbackGuard_(state_0, state_1, leftNodeValue_, rightNodeValue_)) {
                    return JSEqualNode.doFallback(leftNodeValue_, rightNodeValue_);
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
            int state_1 = this.state_1_;
            int exclude = this.exclude_;
            if (leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt(int, int) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSEqualNode.doInt(leftNodeValue_, rightNodeValue_);
                }
                if (rightNodeValue instanceof Boolean) {
                    boolean rightNodeValue_ = (boolean) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doIntBoolean(int, boolean) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSEqualNode.doIntBoolean(leftNodeValue_, rightNodeValue_);
                }
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state_1 = (state_1 | (doubleCast0 << 6) /* set-implicit-state_1 0:double */);
                        state_1 = (state_1 | (doubleCast1 << 10) /* set-implicit-state_1 1:double */);
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doDouble(double, double) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return JSEqualNode.doDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doBigInt(BigInt, BigInt) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSEqualNode.doBigInt(leftNodeValue_, rightNodeValue_);
                }
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                            String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                            state_1 = (state_1 | (doubleCast0 << 6) /* set-implicit-state_1 0:double */);
                            state_1 = (state_1 | (stringCast1 << 14) /* set-implicit-state_1 1:String */);
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doDoubleString(double, String) */;
                            this.state_1_ = state_1;
                            lock.unlock();
                            hasLock = false;
                            return doDoubleString(leftNodeValue_, rightNodeValue_);
                        }
                    }
                    if (rightNodeValue instanceof Boolean) {
                        boolean rightNodeValue_ = (boolean) rightNodeValue;
                        state_1 = (state_1 | (doubleCast0 << 6) /* set-implicit-state_1 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doDoubleBoolean(double, boolean) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return JSEqualNode.doDoubleBoolean(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (leftNodeValue instanceof Boolean) {
                boolean leftNodeValue_ = (boolean) leftNodeValue;
                if (rightNodeValue instanceof Boolean) {
                    boolean rightNodeValue_ = (boolean) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doBoolean(boolean, boolean) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSEqualNode.doBoolean(leftNodeValue_, rightNodeValue_);
                }
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doBooleanInt(boolean, int) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSEqualNode.doBooleanInt(leftNodeValue_, rightNodeValue_);
                }
                {
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state_1 = (state_1 | (doubleCast1 << 10) /* set-implicit-state_1 1:double */);
                        this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doBooleanDouble(boolean, double) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return JSEqualNode.doBooleanDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
                {
                    int stringCast1;
                    if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                        String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                        state_1 = (state_1 | (stringCast1 << 14) /* set-implicit-state_1 1:String */);
                        this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doBooleanString(boolean, String) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return doBooleanString(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(leftNodeValue)) != 0) {
                    String leftNodeValue_ = JSTypesGen.asImplicitString(stringCast0, leftNodeValue);
                    {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                            String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                            if (((exclude & 0b1)) == 0 /* is-not-exclude doStringIdentity(String, String) */) {
                                if ((JSGuards.isReferenceEquals(leftNodeValue_, rightNodeValue_))) {
                                    state_1 = (state_1 | (stringCast0 << 17) /* set-implicit-state_1 0:String */);
                                    state_1 = (state_1 | (stringCast1 << 14) /* set-implicit-state_1 1:String */);
                                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doStringIdentity(String, String) */;
                                    this.state_1_ = state_1;
                                    lock.unlock();
                                    hasLock = false;
                                    return JSEqualNode.doStringIdentity(leftNodeValue_, rightNodeValue_);
                                }
                            }
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doStringIdentity(String, String) */;
                            state_0 = state_0 & 0xfffffbff /* remove-state_0 doStringIdentity(String, String) */;
                            state_1 = (state_1 | (stringCast0 << 17) /* set-implicit-state_1 0:String */);
                            state_1 = (state_1 | (stringCast1 << 14) /* set-implicit-state_1 1:String */);
                            this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doString(String, String) */;
                            this.state_1_ = state_1;
                            lock.unlock();
                            hasLock = false;
                            return JSEqualNode.doString(leftNodeValue_, rightNodeValue_);
                        }
                    }
                    {
                        int doubleCast1;
                        if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                            double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                            state_1 = (state_1 | (stringCast0 << 17) /* set-implicit-state_1 0:String */);
                            state_1 = (state_1 | (doubleCast1 << 10) /* set-implicit-state_1 1:double */);
                            this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doStringDouble(String, double) */;
                            this.state_1_ = state_1;
                            lock.unlock();
                            hasLock = false;
                            return doStringDouble(leftNodeValue_, rightNodeValue_);
                        }
                    }
                    if (rightNodeValue instanceof Boolean) {
                        boolean rightNodeValue_ = (boolean) rightNodeValue;
                        state_1 = (state_1 | (stringCast0 << 17) /* set-implicit-state_1 0:String */);
                        this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 doStringBoolean(String, boolean) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return doStringBoolean(leftNodeValue_, rightNodeValue_);
                    }
                    if (rightNodeValue instanceof BigInt) {
                        BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                        state_1 = (state_1 | (stringCast0 << 17) /* set-implicit-state_1 0:String */);
                        this.state_0_ = state_0 = state_0 | 0b100000000000000 /* add-state_0 doStringBigInt(String, BigInt) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return doStringBigInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                int stringCast1;
                if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                    String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                    state_1 = (state_1 | (stringCast1 << 14) /* set-implicit-state_1 1:String */);
                    this.state_0_ = state_0 = state_0 | 0b1000000000000000 /* add-state_0 doBigIntString(BigInt, String) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return doBigIntString(leftNodeValue_, rightNodeValue_);
                }
            }
            if (leftNodeValue instanceof Boolean) {
                boolean leftNodeValue_ = (boolean) leftNodeValue;
                if (rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0x10000 /* add-state_0 doBooleanBigInt(boolean, BigInt) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return doBooleanBigInt(leftNodeValue_, rightNodeValue_);
                }
            }
            if (leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof Boolean) {
                    boolean rightNodeValue_ = (boolean) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0x20000 /* add-state_0 doBigIntBoolean(BigInt, boolean) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return doBigIntBoolean(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((JSRuntime.isNullOrUndefined(leftNodeValue)) && (JSRuntime.isNullOrUndefined(rightNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0x40000 /* add-state_0 doBothNullOrUndefined(Object, Object) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return JSEqualNode.doBothNullOrUndefined(leftNodeValue, rightNodeValue);
            }
            if ((JSRuntime.isNullOrUndefined(leftNodeValue))) {
                this.bInterop = super.insert(this.bInterop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.bInterop);
                this.state_0_ = state_0 = state_0 | 0x80000 /* add-state_0 doLeftNullOrUndefined(Object, Object, InteropLibrary) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return JSEqualNode.doLeftNullOrUndefined(leftNodeValue, rightNodeValue, this.bInterop);
            }
            if ((JSRuntime.isNullOrUndefined(rightNodeValue))) {
                this.aInterop = super.insert(this.aInterop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.aInterop);
                this.state_0_ = state_0 = state_0 | 0x100000 /* add-state_0 doRightNullOrUndefined(Object, Object, InteropLibrary) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return JSEqualNode.doRightNullOrUndefined(leftNodeValue, rightNodeValue, this.aInterop);
            }
            if ((JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
                this.overloaded_overloadedOperatorNode_ = super.insert((JSOverloadedBinaryNode.createHintNone(getOverloadedOperatorName())));
                this.overloaded_toBooleanNode_ = super.insert((JSToBooleanNode.create()));
                this.state_0_ = state_0 = state_0 | 0x200000 /* add-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return doOverloaded(leftNodeValue, rightNodeValue, this.overloaded_overloadedOperatorNode_, this.overloaded_toBooleanNode_);
            }
            if (JSTypes.isDynamicObject(leftNodeValue)) {
                DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
                if ((JSRuntime.isObject(leftNodeValue_)) && (!(JSRuntime.isObject(rightNodeValue))) && (!(JSGuards.hasOverloadedOperators(leftNodeValue_)))) {
                    this.bInterop = super.insert(this.bInterop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.bInterop);
                    this.toPrimitive = super.insert(this.toPrimitive == null ? ((JSToPrimitiveNode.createHintNone())) : this.toPrimitive);
                    this.equal = super.insert(this.equal == null ? ((JSEqualNode.create())) : this.equal);
                    this.state_0_ = state_0 = state_0 | 0x400000 /* add-state_0 doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(leftNodeValue_, rightNodeValue, this.bInterop, this.toPrimitive, this.equal);
                }
            }
            if (JSTypes.isDynamicObject(rightNodeValue)) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                if ((!(JSRuntime.isObject(leftNodeValue))) && (JSRuntime.isObject(rightNodeValue_)) && (!(JSGuards.hasOverloadedOperators(rightNodeValue_)))) {
                    this.aInterop = super.insert(this.aInterop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.aInterop);
                    this.toPrimitive = super.insert(this.toPrimitive == null ? ((JSToPrimitiveNode.createHintNone())) : this.toPrimitive);
                    this.equal = super.insert(this.equal == null ? ((JSEqualNode.create())) : this.equal);
                    this.state_0_ = state_0 = state_0 | 0x800000 /* add-state_0 doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(leftNodeValue, rightNodeValue_, this.aInterop, this.toPrimitive, this.equal);
                }
            }
            if (leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0x1000000 /* add-state_0 doBigIntAndInt(BigInt, int) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return doBigIntAndInt(leftNodeValue_, rightNodeValue_);
                }
                {
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state_1 = (state_1 | (doubleCast1 << 10) /* set-implicit-state_1 1:double */);
                        this.state_0_ = state_0 = state_0 | 0x2000000 /* add-state_0 doBigIntAndNumber(BigInt, double) */;
                        this.state_1_ = state_1;
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
                    this.state_0_ = state_0 = state_0 | 0x4000000 /* add-state_0 doIntAndBigInt(int, BigInt) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return doIntAndBigInt(leftNodeValue_, rightNodeValue_);
                }
                {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                        double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                        state_1 = (state_1 | (doubleCast0 << 6) /* set-implicit-state_1 0:double */);
                        this.state_0_ = state_0 = state_0 | 0x8000000 /* add-state_0 doNumberAndBigInt(double, BigInt) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return doNumberAndBigInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (JSTypes.isDynamicObject(leftNodeValue)) {
                DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
                if (JSTypes.isDynamicObject(rightNodeValue)) {
                    DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                    if ((!(JSRuntime.isNullOrUndefined(leftNodeValue_))) && (JSGuards.isJSDynamicObject(leftNodeValue_)) && (JSGuards.isJSDynamicObject(rightNodeValue_))) {
                        this.state_0_ = state_0 = state_0 | 0x10000000 /* add-state_0 doJSObject(DynamicObject, DynamicObject) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return JSEqualNode.doJSObject(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (leftNodeValue instanceof Symbol) {
                Symbol leftNodeValue_ = (Symbol) leftNodeValue;
                if (rightNodeValue instanceof Symbol) {
                    Symbol rightNodeValue_ = (Symbol) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0x20000000 /* add-state_0 doSymbol(Symbol, Symbol) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSEqualNode.doSymbol(leftNodeValue_, rightNodeValue_);
                }
                if ((!(JSGuards.isSymbol(rightNodeValue))) && (!(JSRuntime.isObject(rightNodeValue)))) {
                    this.state_0_ = state_0 = state_0 | 0x40000000 /* add-state_0 doSymbolNotSymbol(Symbol, Object) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSEqualNode.doSymbolNotSymbol(leftNodeValue_, rightNodeValue);
                }
            }
            if (rightNodeValue instanceof Symbol) {
                Symbol rightNodeValue_ = (Symbol) rightNodeValue;
                if ((!(JSGuards.isSymbol(leftNodeValue))) && (!(JSRuntime.isObject(leftNodeValue)))) {
                    this.state_0_ = state_0 = state_0 | 0x80000000 /* add-state_0 doSymbolNotSymbol(Object, Symbol) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSEqualNode.doSymbolNotSymbol(leftNodeValue, rightNodeValue_);
                }
            }
            if ((JSRuntime.isForeignObject(leftNodeValue) || JSRuntime.isForeignObject(rightNodeValue))) {
                this.aInterop = super.insert(this.aInterop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.aInterop);
                this.bInterop = super.insert(this.bInterop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.bInterop);
                this.equal = super.insert(this.equal == null ? ((JSEqualNode.create())) : this.equal);
                this.state_0_ = state_0;
                this.state_1_ = state_1 = state_1 | 0b1 /* add-state_1 doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) */;
                lock.unlock();
                hasLock = false;
                return doForeign(leftNodeValue, rightNodeValue, this.aInterop, this.bInterop, this.equal);
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doNumberCached(Object, Object, Class<>, Class<>) */ && (leftNodeValue != null) && (rightNodeValue != null)) {
                int count33_ = 0;
                NumberCachedData s33_ = this.numberCached_cache;
                if (((state_1 & 0b10) != 0 /* is-state_1 doNumberCached(Object, Object, Class<>, Class<>) */)) {
                    while (s33_ != null) {
                        assert (s33_.cachedClassA_ != null);
                        assert (s33_.cachedClassB_ != null);
                        if ((leftNodeValue.getClass() == s33_.cachedClassA_) && (rightNodeValue.getClass() == s33_.cachedClassB_)) {
                            break;
                        }
                        s33_ = s33_.next_;
                        count33_++;
                    }
                }
                if (s33_ == null) {
                    {
                        Class<?> cachedClassA__ = (JSGuards.getJavaNumberClass(leftNodeValue));
                        if ((cachedClassA__ != null)) {
                            Class<?> cachedClassB__ = (JSGuards.getJavaNumberClass(rightNodeValue));
                            if ((cachedClassB__ != null) && (leftNodeValue.getClass() == cachedClassA__) && (rightNodeValue.getClass() == cachedClassB__) && count33_ < (JSEqualNode.MAX_CLASSES)) {
                                s33_ = new NumberCachedData(numberCached_cache);
                                s33_.cachedClassA_ = cachedClassA__;
                                s33_.cachedClassB_ = cachedClassB__;
                                MemoryFence.storeStore();
                                this.numberCached_cache = s33_;
                                this.state_0_ = state_0;
                                this.state_1_ = state_1 = state_1 | 0b10 /* add-state_1 doNumberCached(Object, Object, Class<>, Class<>) */;
                            }
                        }
                    }
                }
                if (s33_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return JSEqualNode.doNumberCached(leftNodeValue, rightNodeValue, s33_.cachedClassA_, s33_.cachedClassB_);
                }
            }
            if (leftNodeValue instanceof Number) {
                Number leftNodeValue_ = (Number) leftNodeValue;
                if (rightNodeValue instanceof Number) {
                    Number rightNodeValue_ = (Number) rightNodeValue;
                    if ((JSRuntime.isJavaNumber(leftNodeValue_)) && (JSRuntime.isJavaNumber(rightNodeValue_))) {
                        this.exclude_ = exclude = exclude | 0b10 /* add-exclude doNumberCached(Object, Object, Class<>, Class<>) */;
                        this.numberCached_cache = null;
                        state_1 = state_1 & 0xfffffffd /* remove-state_1 doNumberCached(Object, Object, Class<>, Class<>) */;
                        this.state_0_ = state_0;
                        this.state_1_ = state_1 = state_1 | 0b100 /* add-state_1 doNumber(Number, Number) */;
                        lock.unlock();
                        hasLock = false;
                        return JSEqualNode.doNumber(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            {
                int stringCast1;
                if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                    String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                    if ((JSRuntime.isJavaNumber(leftNodeValue))) {
                        state_1 = (state_1 | (stringCast1 << 14) /* set-implicit-state_1 1:String */);
                        this.state_0_ = state_0;
                        this.state_1_ = state_1 = state_1 | 0b1000 /* add-state_1 doStringNumber(Object, String) */;
                        lock.unlock();
                        hasLock = false;
                        return doStringNumber(leftNodeValue, rightNodeValue_);
                    }
                }
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(leftNodeValue)) != 0) {
                    String leftNodeValue_ = JSTypesGen.asImplicitString(stringCast0, leftNodeValue);
                    if ((JSRuntime.isJavaNumber(rightNodeValue))) {
                        state_1 = (state_1 | (stringCast0 << 17) /* set-implicit-state_1 0:String */);
                        this.state_0_ = state_0;
                        this.state_1_ = state_1 = state_1 | 0b10000 /* add-state_1 doStringNumber(String, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doStringNumber(leftNodeValue_, rightNodeValue);
                    }
                }
            }
            this.state_0_ = state_0;
            this.state_1_ = state_1 = state_1 | 0b100000 /* add-state_1 doFallback(Object, Object) */;
            lock.unlock();
            hasLock = false;
            return JSEqualNode.doFallback(leftNodeValue, rightNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        int state_1 = this.state_1_;
        if (state_0 == 0 && (state_1 & 0b111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            int counter = 0;
            counter += Integer.bitCount(state_0);
            counter += Integer.bitCount((state_1 & 0b111111));
            if (counter == 1) {
                NumberCachedData s33_ = this.numberCached_cache;
                if ((s33_ == null || s33_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[39];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int state_1 = this.state_1_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doInt";
        if (((state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doIntBoolean";
        if (((state_0 & 0b10) != 0 /* is-state_0 doIntBoolean(int, boolean) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if (((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, double) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if (((state_0 & 0b1000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDoubleString";
        if (((state_0 & 0b10000) != 0 /* is-state_0 doDoubleString(double, String) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doDoubleBoolean";
        if (((state_0 & 0b100000) != 0 /* is-state_0 doDoubleBoolean(double, boolean) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if (((state_0 & 0b1000000) != 0 /* is-state_0 doBoolean(boolean, boolean) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doBooleanInt";
        if (((state_0 & 0b10000000) != 0 /* is-state_0 doBooleanInt(boolean, int) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doBooleanDouble";
        if (((state_0 & 0b100000000) != 0 /* is-state_0 doBooleanDouble(boolean, double) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doBooleanString";
        if (((state_0 & 0b1000000000) != 0 /* is-state_0 doBooleanString(boolean, String) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doStringIdentity";
        if (((state_0 & 0b10000000000) != 0 /* is-state_0 doStringIdentity(String, String) */)) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doStringIdentity(String, String) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doString";
        if (((state_0 & 0b100000000000) != 0 /* is-state_0 doString(String, String) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doStringDouble";
        if (((state_0 & 0b1000000000000) != 0 /* is-state_0 doStringDouble(String, double) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doStringBoolean";
        if (((state_0 & 0b10000000000000) != 0 /* is-state_0 doStringBoolean(String, boolean) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        s = new Object[3];
        s[0] = "doStringBigInt";
        if (((state_0 & 0b100000000000000) != 0 /* is-state_0 doStringBigInt(String, BigInt) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[15] = s;
        s = new Object[3];
        s[0] = "doBigIntString";
        if (((state_0 & 0b1000000000000000) != 0 /* is-state_0 doBigIntString(BigInt, String) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[16] = s;
        s = new Object[3];
        s[0] = "doBooleanBigInt";
        if (((state_0 & 0x10000) != 0 /* is-state_0 doBooleanBigInt(boolean, BigInt) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[17] = s;
        s = new Object[3];
        s[0] = "doBigIntBoolean";
        if (((state_0 & 0x20000) != 0 /* is-state_0 doBigIntBoolean(BigInt, boolean) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[18] = s;
        s = new Object[3];
        s[0] = "doBothNullOrUndefined";
        if (((state_0 & 0x40000) != 0 /* is-state_0 doBothNullOrUndefined(Object, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[19] = s;
        s = new Object[3];
        s[0] = "doLeftNullOrUndefined";
        if (((state_0 & 0x80000) != 0 /* is-state_0 doLeftNullOrUndefined(Object, Object, InteropLibrary) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.bInterop));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[20] = s;
        s = new Object[3];
        s[0] = "doRightNullOrUndefined";
        if (((state_0 & 0x100000) != 0 /* is-state_0 doRightNullOrUndefined(Object, Object, InteropLibrary) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.aInterop));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[21] = s;
        s = new Object[3];
        s[0] = "doOverloaded";
        if (((state_0 & 0x200000) != 0 /* is-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.overloaded_overloadedOperatorNode_, this.overloaded_toBooleanNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[22] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if (((state_0 & 0x400000) != 0 /* is-state_0 doJSObject(DynamicObject, Object, InteropLibrary, JSToPrimitiveNode, JSEqualNode) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.bInterop, this.toPrimitive, this.equal));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[23] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if (((state_0 & 0x800000) != 0 /* is-state_0 doJSObject(Object, DynamicObject, InteropLibrary, JSToPrimitiveNode, JSEqualNode) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.aInterop, this.toPrimitive, this.equal));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[24] = s;
        s = new Object[3];
        s[0] = "doBigIntAndInt";
        if (((state_0 & 0x1000000) != 0 /* is-state_0 doBigIntAndInt(BigInt, int) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[25] = s;
        s = new Object[3];
        s[0] = "doBigIntAndNumber";
        if (((state_0 & 0x2000000) != 0 /* is-state_0 doBigIntAndNumber(BigInt, double) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[26] = s;
        s = new Object[3];
        s[0] = "doIntAndBigInt";
        if (((state_0 & 0x4000000) != 0 /* is-state_0 doIntAndBigInt(int, BigInt) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[27] = s;
        s = new Object[3];
        s[0] = "doNumberAndBigInt";
        if (((state_0 & 0x8000000) != 0 /* is-state_0 doNumberAndBigInt(double, BigInt) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[28] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if (((state_0 & 0x10000000) != 0 /* is-state_0 doJSObject(DynamicObject, DynamicObject) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[29] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if (((state_0 & 0x20000000) != 0 /* is-state_0 doSymbol(Symbol, Symbol) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[30] = s;
        s = new Object[3];
        s[0] = "doSymbolNotSymbol";
        if (((state_0 & 0x40000000) != 0 /* is-state_0 doSymbolNotSymbol(Symbol, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[31] = s;
        s = new Object[3];
        s[0] = "doSymbolNotSymbol";
        if (((state_0 & 0x80000000) != 0 /* is-state_0 doSymbolNotSymbol(Object, Symbol) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[32] = s;
        s = new Object[3];
        s[0] = "doForeign";
        if (((state_1 & 0b1) != 0 /* is-state_1 doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.aInterop, this.bInterop, this.equal));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[33] = s;
        s = new Object[3];
        s[0] = "doNumberCached";
        if (((state_1 & 0b10) != 0 /* is-state_1 doNumberCached(Object, Object, Class<>, Class<>) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            NumberCachedData s33_ = this.numberCached_cache;
            while (s33_ != null) {
                cached.add(Arrays.asList(s33_.cachedClassA_, s33_.cachedClassB_));
                s33_ = s33_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doNumberCached(Object, Object, Class<>, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[34] = s;
        s = new Object[3];
        s[0] = "doNumber";
        if (((state_1 & 0b100) != 0 /* is-state_1 doNumber(Number, Number) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[35] = s;
        s = new Object[3];
        s[0] = "doStringNumber";
        if (((state_1 & 0b1000) != 0 /* is-state_1 doStringNumber(Object, String) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[36] = s;
        s = new Object[3];
        s[0] = "doStringNumber";
        if (((state_1 & 0b10000) != 0 /* is-state_1 doStringNumber(String, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[37] = s;
        s = new Object[3];
        s[0] = "doFallback";
        if (((state_1 & 0b100000) != 0 /* is-state_1 doFallback(Object, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[38] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state_0, int state_1, Object leftNodeValue, Object rightNodeValue) {
        if (JSTypesGen.isImplicitDouble(leftNodeValue) && JSTypesGen.isImplicitDouble(rightNodeValue)) {
            return false;
        }
        if (((state_0 & 0b1000)) == 0 /* is-not-state_0 doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt && rightNodeValue instanceof BigInt) {
            return false;
        }
        if (JSTypesGen.isImplicitDouble(leftNodeValue)) {
            if (JSTypesGen.isImplicitString(rightNodeValue)) {
                return false;
            }
            if (((state_0 & 0b100000)) == 0 /* is-not-state_0 doDoubleBoolean(double, boolean) */ && rightNodeValue instanceof Boolean) {
                return false;
            }
        }
        if (leftNodeValue instanceof Boolean) {
            if (((state_0 & 0b1000000)) == 0 /* is-not-state_0 doBoolean(boolean, boolean) */ && rightNodeValue instanceof Boolean) {
                return false;
            }
            if (JSTypesGen.isImplicitDouble(rightNodeValue)) {
                return false;
            }
            if (JSTypesGen.isImplicitString(rightNodeValue)) {
                return false;
            }
        }
        if (JSTypesGen.isImplicitString(leftNodeValue)) {
            if (JSTypesGen.isImplicitString(rightNodeValue)) {
                return false;
            }
            if (JSTypesGen.isImplicitDouble(rightNodeValue)) {
                return false;
            }
            if (((state_0 & 0b10000000000000)) == 0 /* is-not-state_0 doStringBoolean(String, boolean) */ && rightNodeValue instanceof Boolean) {
                return false;
            }
            if (((state_0 & 0b100000000000000)) == 0 /* is-not-state_0 doStringBigInt(String, BigInt) */ && rightNodeValue instanceof BigInt) {
                return false;
            }
        }
        if (leftNodeValue instanceof BigInt && JSTypesGen.isImplicitString(rightNodeValue)) {
            return false;
        }
        if (((state_0 & 0x10000)) == 0 /* is-not-state_0 doBooleanBigInt(boolean, BigInt) */ && leftNodeValue instanceof Boolean && rightNodeValue instanceof BigInt) {
            return false;
        }
        if (((state_0 & 0x20000)) == 0 /* is-not-state_0 doBigIntBoolean(BigInt, boolean) */ && leftNodeValue instanceof BigInt && rightNodeValue instanceof Boolean) {
            return false;
        }
        if (((state_0 & 0x40000)) == 0 /* is-not-state_0 doBothNullOrUndefined(Object, Object) */ && (JSRuntime.isNullOrUndefined(leftNodeValue)) && (JSRuntime.isNullOrUndefined(rightNodeValue))) {
            return false;
        }
        if (((state_0 & 0x80000)) == 0 /* is-not-state_0 doLeftNullOrUndefined(Object, Object, InteropLibrary) */ && (JSRuntime.isNullOrUndefined(leftNodeValue))) {
            return false;
        }
        if (((state_0 & 0x100000)) == 0 /* is-not-state_0 doRightNullOrUndefined(Object, Object, InteropLibrary) */ && (JSRuntime.isNullOrUndefined(rightNodeValue))) {
            return false;
        }
        if (((state_0 & 0x200000)) == 0 /* is-not-state_0 doOverloaded(Object, Object, JSOverloadedBinaryNode, JSToBooleanNode) */ && (JSGuards.hasOverloadedOperators(leftNodeValue) || JSGuards.hasOverloadedOperators(rightNodeValue))) {
            return false;
        }
        if (JSTypes.isDynamicObject(leftNodeValue)) {
            DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
            if ((JSRuntime.isObject(leftNodeValue_)) && (!(JSRuntime.isObject(rightNodeValue))) && (!(JSGuards.hasOverloadedOperators(leftNodeValue_)))) {
                return false;
            }
        }
        if (JSTypes.isDynamicObject(rightNodeValue) && (!(JSRuntime.isObject(leftNodeValue)))) {
            DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
            if ((JSRuntime.isObject(rightNodeValue_)) && (!(JSGuards.hasOverloadedOperators(rightNodeValue_)))) {
                return false;
            }
        }
        if (leftNodeValue instanceof BigInt && JSTypesGen.isImplicitDouble(rightNodeValue)) {
            return false;
        }
        if (JSTypesGen.isImplicitDouble(leftNodeValue) && rightNodeValue instanceof BigInt) {
            return false;
        }
        if (JSTypes.isDynamicObject(leftNodeValue) && JSTypes.isDynamicObject(rightNodeValue)) {
            DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
            if ((!(JSRuntime.isNullOrUndefined(leftNodeValue_))) && (JSGuards.isJSDynamicObject(leftNodeValue_))) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                if ((JSGuards.isJSDynamicObject(rightNodeValue_))) {
                    return false;
                }
            }
        }
        if (leftNodeValue instanceof Symbol) {
            if (((state_0 & 0x20000000)) == 0 /* is-not-state_0 doSymbol(Symbol, Symbol) */ && rightNodeValue instanceof Symbol) {
                return false;
            }
            if (((state_0 & 0x40000000)) == 0 /* is-not-state_0 doSymbolNotSymbol(Symbol, Object) */ && (!(JSGuards.isSymbol(rightNodeValue))) && (!(JSRuntime.isObject(rightNodeValue)))) {
                return false;
            }
        }
        if (((state_0 & 0x80000000)) == 0 /* is-not-state_0 doSymbolNotSymbol(Object, Symbol) */ && rightNodeValue instanceof Symbol && (!(JSGuards.isSymbol(leftNodeValue))) && (!(JSRuntime.isObject(leftNodeValue)))) {
            return false;
        }
        if (((state_1 & 0b1)) == 0 /* is-not-state_1 doForeign(Object, Object, InteropLibrary, InteropLibrary, JSEqualNode) */ && (JSRuntime.isForeignObject(leftNodeValue) || JSRuntime.isForeignObject(rightNodeValue))) {
            return false;
        }
        if (leftNodeValue instanceof Number && rightNodeValue instanceof Number) {
            Number leftNodeValue_ = (Number) leftNodeValue;
            if ((JSRuntime.isJavaNumber(leftNodeValue_))) {
                Number rightNodeValue_ = (Number) rightNodeValue;
                if ((JSRuntime.isJavaNumber(rightNodeValue_))) {
                    return false;
                }
            }
        }
        if (JSTypesGen.isImplicitString(rightNodeValue) && (JSRuntime.isJavaNumber(leftNodeValue))) {
            return false;
        }
        if (JSTypesGen.isImplicitString(leftNodeValue) && (JSRuntime.isJavaNumber(rightNodeValue))) {
            return false;
        }
        return true;
    }

    public static JSEqualNode create(JavaScriptNode left, JavaScriptNode right) {
        return new JSEqualNodeGen(left, right);
    }

    @GeneratedBy(JSEqualNode.class)
    private static final class NumberCachedData {

        @CompilationFinal NumberCachedData next_;
        @CompilationFinal Class<?> cachedClassA_;
        @CompilationFinal Class<?> cachedClassB_;

        NumberCachedData(NumberCachedData next_) {
            this.next_ = next_;
        }

    }
}
