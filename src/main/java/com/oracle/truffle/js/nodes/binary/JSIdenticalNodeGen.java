// CheckStyle: start generated
package com.oracle.truffle.js.nodes.binary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSIdenticalNode.class)
@SuppressWarnings("unused")
public final class JSIdenticalNodeGen extends JSIdenticalNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int state_1_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile flattenA;
    @CompilationFinal private ConditionProfile flattenB;
    @CompilationFinal private ConditionProfile sameLen;
    @Child private NullA0Data nullA0_cache;
    @Child private NullB0Data nullB0_cache;
    @CompilationFinal private DifferentTypesCachedData differentTypesCached_cache;
    @CompilationFinal private NumberCachedData numberCached_cache;
    @Child private ForeignObject0Data foreignObject0_cache;

    private JSIdenticalNodeGen(JavaScriptNode left, JavaScriptNode right, int type) {
        super(left, right, type);
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object leftNodeValue, Object rightNodeValue) {
        int state_0 = this.state_0_;
        int state_1 = this.state_1_;
        if (((state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */) && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if (rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return JSIdenticalNode.doInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0b10) != 0 /* is-state_0 doDouble(double, double) */) && JSTypesGen.isImplicitDouble((state_1 & 0b111100) >>> 2 /* extract-implicit-state_1 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_1 & 0b111100) >>> 2 /* extract-implicit-state_1 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 1:double */, rightNodeValue);
                return doDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0b100) != 0 /* is-state_0 doBoolean(boolean, boolean) */) && leftNodeValue instanceof Boolean) {
            boolean leftNodeValue_ = (boolean) leftNodeValue;
            if (rightNodeValue instanceof Boolean) {
                boolean rightNodeValue_ = (boolean) rightNodeValue;
                return JSIdenticalNode.doBoolean(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0b11000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) || doBigIntDouble(BigInt, double) */) && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (((state_0 & 0b1000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */) && rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return JSIdenticalNode.doBigInt(leftNodeValue_, rightNodeValue_);
            }
            if (((state_0 & 0b10000) != 0 /* is-state_0 doBigIntDouble(BigInt, double) */) && JSTypesGen.isImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 1:double */, rightNodeValue);
                return JSIdenticalNode.doBigIntDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0b100000) != 0 /* is-state_0 doDoubleBigInt(double, BigInt) */) && JSTypesGen.isImplicitDouble((state_1 & 0b111100) >>> 2 /* extract-implicit-state_1 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state_1 & 0b111100) >>> 2 /* extract-implicit-state_1 0:double */, leftNodeValue);
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return JSIdenticalNode.doDoubleBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0b111000000) != 0 /* is-state_0 doUndefinedA(Object, Object) || doUndefinedB(Object, Object) || doJSObjectA(DynamicObject, Object) */)) {
            if (((state_0 & 0b11000000) != 0 /* is-state_0 doUndefinedA(Object, Object) || doUndefinedB(Object, Object) */)) {
                if (((state_0 & 0b1000000) != 0 /* is-state_0 doUndefinedA(Object, Object) */)) {
                    if ((JSGuards.isUndefined(leftNodeValue))) {
                        return JSIdenticalNode.doUndefinedA(leftNodeValue, rightNodeValue);
                    }
                }
                if (((state_0 & 0b10000000) != 0 /* is-state_0 doUndefinedB(Object, Object) */)) {
                    if ((JSGuards.isUndefined(rightNodeValue))) {
                        return JSIdenticalNode.doUndefinedB(leftNodeValue, rightNodeValue);
                    }
                }
            }
            if (((state_0 & 0b100000000) != 0 /* is-state_0 doJSObjectA(DynamicObject, Object) */) && JSTypes.isDynamicObject(leftNodeValue)) {
                DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
                if ((JSGuards.isJSObject(leftNodeValue_))) {
                    return JSIdenticalNode.doJSObjectA(leftNodeValue_, rightNodeValue);
                }
            }
        }
        if (((state_0 & 0x1fe00) != 0 /* is-state_0 doJSObjectB(Object, DynamicObject) || doNullNull(Object, Object) || doNullUndefined(Object, Object) || doUndefinedNull(Object, Object) || doNullA(Object, Object, InteropLibrary) || doNullA(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) */)) {
            if (((state_0 & 0b1000000000) != 0 /* is-state_0 doJSObjectB(Object, DynamicObject) */) && JSTypes.isDynamicObject(rightNodeValue)) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                if ((JSGuards.isJSObject(rightNodeValue_))) {
                    return JSIdenticalNode.doJSObjectB(leftNodeValue, rightNodeValue_);
                }
            }
            if (((state_0 & 0x1fc00) != 0 /* is-state_0 doNullNull(Object, Object) || doNullUndefined(Object, Object) || doUndefinedNull(Object, Object) || doNullA(Object, Object, InteropLibrary) || doNullA(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) */)) {
                if (((state_0 & 0b10000000000) != 0 /* is-state_0 doNullNull(Object, Object) */)) {
                    if ((JSGuards.isJSNull(leftNodeValue)) && (JSGuards.isJSNull(rightNodeValue))) {
                        return JSIdenticalNode.doNullNull(leftNodeValue, rightNodeValue);
                    }
                }
                if (((state_0 & 0b100000000000) != 0 /* is-state_0 doNullUndefined(Object, Object) */)) {
                    if ((JSGuards.isJSNull(leftNodeValue)) && (JSGuards.isUndefined(rightNodeValue))) {
                        return JSIdenticalNode.doNullUndefined(leftNodeValue, rightNodeValue);
                    }
                }
                if (((state_0 & 0b1000000000000) != 0 /* is-state_0 doUndefinedNull(Object, Object) */)) {
                    if ((JSGuards.isUndefined(leftNodeValue)) && (JSGuards.isJSNull(rightNodeValue))) {
                        return JSIdenticalNode.doUndefinedNull(leftNodeValue, rightNodeValue);
                    }
                }
                if (((state_0 & 0b10000000000000) != 0 /* is-state_0 doNullA(Object, Object, InteropLibrary) */)) {
                    NullA0Data s13_ = this.nullA0_cache;
                    while (s13_ != null) {
                        if ((s13_.bInterop_.accepts(rightNodeValue)) && (JSGuards.isJSNull(leftNodeValue)) && (!(JSGuards.isJSNull(rightNodeValue))) && (!(JSGuards.isUndefined(rightNodeValue)))) {
                            return JSIdenticalNode.doNullA(leftNodeValue, rightNodeValue, s13_.bInterop_);
                        }
                        s13_ = s13_.next_;
                    }
                }
                if (((state_0 & 0b100000000000000) != 0 /* is-state_0 doNullA(Object, Object, InteropLibrary) */)) {
                    if ((JSGuards.isJSNull(leftNodeValue)) && (!(JSGuards.isJSNull(rightNodeValue))) && (!(JSGuards.isUndefined(rightNodeValue)))) {
                        return this.nullA1Boundary(state_0, state_1, leftNodeValue, rightNodeValue);
                    }
                }
                if (((state_0 & 0b1000000000000000) != 0 /* is-state_0 doNullB(Object, Object, InteropLibrary) */)) {
                    NullB0Data s15_ = this.nullB0_cache;
                    while (s15_ != null) {
                        if ((s15_.aInterop_.accepts(leftNodeValue)) && (!(JSGuards.isJSNull(leftNodeValue))) && (!(JSGuards.isUndefined(leftNodeValue))) && (JSGuards.isJSNull(rightNodeValue))) {
                            return JSIdenticalNode.doNullB(leftNodeValue, rightNodeValue, s15_.aInterop_);
                        }
                        s15_ = s15_.next_;
                    }
                }
                if (((state_0 & 0x10000) != 0 /* is-state_0 doNullB(Object, Object, InteropLibrary) */)) {
                    if ((!(JSGuards.isJSNull(leftNodeValue))) && (!(JSGuards.isUndefined(leftNodeValue))) && (JSGuards.isJSNull(rightNodeValue))) {
                        return this.nullB1Boundary(state_0, state_1, leftNodeValue, rightNodeValue);
                    }
                }
            }
        }
        if (((state_0 & 0xe0000) != 0 /* is-state_0 doLazyStringReference(JSLazyString, JSLazyString) || doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) || doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) */) && rightNodeValue instanceof JSLazyString) {
            JSLazyString rightNodeValue_ = (JSLazyString) rightNodeValue;
            if (((state_0 & 0x60000) != 0 /* is-state_0 doLazyStringReference(JSLazyString, JSLazyString) || doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) */) && leftNodeValue instanceof JSLazyString) {
                JSLazyString leftNodeValue_ = (JSLazyString) leftNodeValue;
                if (((state_0 & 0x20000) != 0 /* is-state_0 doLazyStringReference(JSLazyString, JSLazyString) */)) {
                    if ((JSGuards.isReferenceEquals(leftNodeValue_, rightNodeValue_))) {
                        return JSIdenticalNode.doLazyStringReference(leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((state_0 & 0x40000) != 0 /* is-state_0 doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) */)) {
                    return JSIdenticalNode.doLazyString(leftNodeValue_, rightNodeValue_, this.flattenA, this.flattenB, this.sameLen);
                }
            }
            if (((state_0 & 0x80000) != 0 /* is-state_0 doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) */) && JSTypesGen.isImplicitString((state_1 & 0b1110000000000) >>> 10 /* extract-implicit-state_1 0:String */, leftNodeValue)) {
                String leftNodeValue_ = JSTypesGen.asImplicitString((state_1 & 0b1110000000000) >>> 10 /* extract-implicit-state_1 0:String */, leftNodeValue);
                return JSIdenticalNode.doStringLazyString(leftNodeValue_, rightNodeValue_, this.flattenB, this.sameLen);
            }
        }
        if (((state_0 & 0x700000) != 0 /* is-state_0 doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) || doStringIdentity(String, String) || doString(String, String) */) && JSTypesGen.isImplicitString((state_1 & 0b1110000000000000) >>> 13 /* extract-implicit-state_1 1:String */, rightNodeValue)) {
            String rightNodeValue_ = JSTypesGen.asImplicitString((state_1 & 0b1110000000000000) >>> 13 /* extract-implicit-state_1 1:String */, rightNodeValue);
            if (((state_0 & 0x100000) != 0 /* is-state_0 doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) */) && leftNodeValue instanceof JSLazyString) {
                JSLazyString leftNodeValue_ = (JSLazyString) leftNodeValue;
                return JSIdenticalNode.doLazyStringString(leftNodeValue_, rightNodeValue_, this.flattenA, this.sameLen);
            }
            if (((state_0 & 0x600000) != 0 /* is-state_0 doStringIdentity(String, String) || doString(String, String) */) && JSTypesGen.isImplicitString((state_1 & 0b1110000000000) >>> 10 /* extract-implicit-state_1 0:String */, leftNodeValue)) {
                String leftNodeValue_ = JSTypesGen.asImplicitString((state_1 & 0b1110000000000) >>> 10 /* extract-implicit-state_1 0:String */, leftNodeValue);
                if (((state_0 & 0x200000) != 0 /* is-state_0 doStringIdentity(String, String) */)) {
                    if ((JSGuards.isReferenceEquals(leftNodeValue_, rightNodeValue_))) {
                        return JSIdenticalNode.doStringIdentity(leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((state_0 & 0x400000) != 0 /* is-state_0 doString(String, String) */)) {
                    return JSIdenticalNode.doString(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if (((state_0 & 0x800000) != 0 /* is-state_0 doSymbol(Symbol, Symbol) */) && leftNodeValue instanceof Symbol) {
            Symbol leftNodeValue_ = (Symbol) leftNodeValue;
            if (rightNodeValue instanceof Symbol) {
                Symbol rightNodeValue_ = (Symbol) rightNodeValue;
                return JSIdenticalNode.doSymbol(leftNodeValue_, rightNodeValue_);
            }
        }
        if (((state_0 & 0x3f000000) != 0 /* is-state_0 doBooleanNotBoolean(Object, Object) || doSymbolNotSymbol(Object, Object) || doDifferentTypesCached(Object, Object, Class<>, Class<>) || doNumberNotNumber(Object, Object) || doStringNotString(Object, Object) || doNumberCached(Object, Object, Class<>, Class<>) */)) {
            if (((state_0 & 0x1000000) != 0 /* is-state_0 doBooleanNotBoolean(Object, Object) */)) {
                if ((JSGuards.isBoolean(leftNodeValue) != JSGuards.isBoolean(rightNodeValue))) {
                    return JSIdenticalNode.doBooleanNotBoolean(leftNodeValue, rightNodeValue);
                }
            }
            if (((state_0 & 0x2000000) != 0 /* is-state_0 doSymbolNotSymbol(Object, Object) */)) {
                if ((JSGuards.isSymbol(leftNodeValue) != JSGuards.isSymbol(rightNodeValue))) {
                    return JSIdenticalNode.doSymbolNotSymbol(leftNodeValue, rightNodeValue);
                }
            }
            if (((state_0 & 0x4000000) != 0 /* is-state_0 doDifferentTypesCached(Object, Object, Class<>, Class<>) */)) {
                DifferentTypesCachedData s26_ = this.differentTypesCached_cache;
                while (s26_ != null) {
                    if ((leftNodeValue.getClass() == s26_.cachedClassA_) && (rightNodeValue.getClass() == s26_.cachedClassB_)) {
                        assert (JSIdenticalNode.isNonObjectType(s26_.cachedClassA_) || JSIdenticalNode.isNonObjectType(s26_.cachedClassB_));
                        assert (JSIdenticalNode.differentNonObjectTypes(s26_.cachedClassA_, s26_.cachedClassB_));
                        return JSIdenticalNode.doDifferentTypesCached(leftNodeValue, rightNodeValue, s26_.cachedClassA_, s26_.cachedClassB_);
                    }
                    s26_ = s26_.next_;
                }
            }
            if (((state_0 & 0x8000000) != 0 /* is-state_0 doNumberNotNumber(Object, Object) */)) {
                if ((JSRuntime.isJavaNumber(leftNodeValue) != JSRuntime.isJavaNumber(rightNodeValue))) {
                    return JSIdenticalNode.doNumberNotNumber(leftNodeValue, rightNodeValue);
                }
            }
            if (((state_0 & 0x10000000) != 0 /* is-state_0 doStringNotString(Object, Object) */)) {
                if ((JSRuntime.isString(leftNodeValue) != JSRuntime.isString(rightNodeValue))) {
                    return JSIdenticalNode.doStringNotString(leftNodeValue, rightNodeValue);
                }
            }
            if (((state_0 & 0x20000000) != 0 /* is-state_0 doNumberCached(Object, Object, Class<>, Class<>) */)) {
                NumberCachedData s29_ = this.numberCached_cache;
                while (s29_ != null) {
                    assert (s29_.cachedClassA_ != null);
                    assert (s29_.cachedClassB_ != null);
                    if ((leftNodeValue.getClass() == s29_.cachedClassA_) && (rightNodeValue.getClass() == s29_.cachedClassB_)) {
                        return doNumberCached(leftNodeValue, rightNodeValue, s29_.cachedClassA_, s29_.cachedClassB_);
                    }
                    s29_ = s29_.next_;
                }
            }
        }
        if (((state_0 & 0x40000000) != 0 /* is-state_0 doNumber(Number, Number) */) && leftNodeValue instanceof Number) {
            Number leftNodeValue_ = (Number) leftNodeValue;
            if (rightNodeValue instanceof Number) {
                Number rightNodeValue_ = (Number) rightNodeValue;
                if ((JSRuntime.isJavaNumber(leftNodeValue_)) && (JSRuntime.isJavaNumber(rightNodeValue_))) {
                    return doNumber(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if (((state_0 & 0x80000000) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0 /* is-state_1 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) || doFallback(Object, Object) */)) {
            if (((state_0 & 0x80000000) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */)) {
                ForeignObject0Data s31_ = this.foreignObject0_cache;
                while (s31_ != null) {
                    if ((s31_.aInterop_.accepts(leftNodeValue)) && (s31_.bInterop_.accepts(rightNodeValue)) && (JSRuntime.isForeignObject(leftNodeValue)) && (JSRuntime.isForeignObject(rightNodeValue))) {
                        return JSIdenticalNode.doForeignObject(leftNodeValue, rightNodeValue, s31_.aInterop_, s31_.bInterop_);
                    }
                    s31_ = s31_.next_;
                }
            }
            if (((state_1 & 0b1) != 0 /* is-state_1 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */)) {
                if ((JSRuntime.isForeignObject(leftNodeValue)) && (JSRuntime.isForeignObject(rightNodeValue))) {
                    return this.foreignObject1Boundary(state_0, state_1, leftNodeValue, rightNodeValue);
                }
            }
            if (((state_1 & 0b10) != 0 /* is-state_1 doFallback(Object, Object) */)) {
                if (fallbackGuard_(state_0, state_1, leftNodeValue, rightNodeValue)) {
                    return JSIdenticalNode.doFallback(leftNodeValue, rightNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue, rightNodeValue);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private boolean nullA1Boundary(int state_0, int state_1, Object leftNodeValue, Object rightNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary nullA1_bInterop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue));
                return JSIdenticalNode.doNullA(leftNodeValue, rightNodeValue, nullA1_bInterop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private boolean nullB1Boundary(int state_0, int state_1, Object leftNodeValue, Object rightNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary nullB1_aInterop__ = (INTEROP_LIBRARY_.getUncached(leftNodeValue));
                return JSIdenticalNode.doNullB(leftNodeValue, rightNodeValue, nullB1_aInterop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private boolean foreignObject1Boundary(int state_0, int state_1, Object leftNodeValue, Object rightNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_aInterop__ = (INTEROP_LIBRARY_.getUncached(leftNodeValue));
                InteropLibrary foreignObject1_bInterop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue));
                return JSIdenticalNode.doForeignObject(leftNodeValue, rightNodeValue, foreignObject1_aInterop__, foreignObject1_bInterop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        int state_1 = this.state_1_;
        if ((state_0 & 0xfffffffe) == 0 /* only-active doInt(int, int) */ && (state_1 & 0b11) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
            return executeBoolean_int_int0(state_0, state_1, frameValue);
        } else if ((state_0 & 0xfffffffd) == 0 /* only-active doDouble(double, double) */ && (state_1 & 0b11) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
            return executeBoolean_double_double1(state_0, state_1, frameValue);
        } else if ((state_0 & 0xfffffffb) == 0 /* only-active doBoolean(boolean, boolean) */ && (state_1 & 0b11) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
            return executeBoolean_boolean_boolean2(state_0, state_1, frameValue);
        } else if ((state_0 & 0xffffffef) == 0 /* only-active doBigIntDouble(BigInt, double) */ && (state_1 & 0b11) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
            return executeBoolean_double3(state_0, state_1, frameValue);
        } else if ((state_0 & 0xffffffdf) == 0 /* only-active doDoubleBigInt(double, BigInt) */ && (state_1 & 0b11) == 0 /* only-active  */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
            return executeBoolean_double4(state_0, state_1, frameValue);
        } else {
            return executeBoolean_generic5(state_0, state_1, frameValue);
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
        return JSIdenticalNode.doInt(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_double_double1(int state_0, int state_1, VirtualFrame frameValue) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_1 & 0b111000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_1 & 0b110100) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_1 & 0b101100) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_1 & 0b111100) >>> 2 /* extract-implicit-state_1 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_1 & 0b1110000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_1 & 0b1101000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_1 & 0b1011000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state_1 & 0b111000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) ? (Object) leftNodeValue_long : ((state_1 & 0b110100) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double, double) */);
        return doDouble(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_boolean_boolean2(int state_0, int state_1, VirtualFrame frameValue) {
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
        assert ((state_0 & 0b100) != 0 /* is-state_0 doBoolean(boolean, boolean) */);
        return JSIdenticalNode.doBoolean(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_double3(int state_0, int state_1, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state_1 & 0b1110000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state_1 & 0b1101000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state_1 & 0b1011000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert ((state_0 & 0b10000) != 0 /* is-state_0 doBigIntDouble(BigInt, double) */);
        if (leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            return JSIdenticalNode.doBigIntDouble(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, ((state_1 & 0b1110000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) ? (Object) rightNodeValue_long : ((state_1 & 0b1101000000) == 0 /* only-active 1:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) ? (Object) rightNodeValue_int : (Object) rightNodeValue_)));
    }

    private boolean executeBoolean_double4(int state_0, int state_1, VirtualFrame frameValue) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state_1 & 0b111000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state_1 & 0b110100) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state_1 & 0b101100) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */)) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state_1 & 0b111100) >>> 2 /* extract-implicit-state_1 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        assert ((state_0 & 0b100000) != 0 /* is-state_0 doDoubleBigInt(double, BigInt) */);
        if (rightNodeValue_ instanceof BigInt) {
            BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
            return JSIdenticalNode.doDoubleBigInt(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(((state_1 & 0b111000) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) ? (Object) leftNodeValue_long : ((state_1 & 0b110100) == 0 /* only-active 0:double */ && (state_0 != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0  /* is-not doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), rightNodeValue_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private boolean nullA1Boundary0(int state_0, int state_1, Object leftNodeValue_, Object rightNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary nullA1_bInterop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue_));
                return JSIdenticalNode.doNullA(leftNodeValue_, rightNodeValue_, nullA1_bInterop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private boolean nullB1Boundary1(int state_0, int state_1, Object leftNodeValue_, Object rightNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary nullB1_aInterop__ = (INTEROP_LIBRARY_.getUncached(leftNodeValue_));
                return JSIdenticalNode.doNullB(leftNodeValue_, rightNodeValue_, nullB1_aInterop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private boolean foreignObject1Boundary2(int state_0, int state_1, Object leftNodeValue_, Object rightNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_aInterop__ = (INTEROP_LIBRARY_.getUncached(leftNodeValue_));
                InteropLibrary foreignObject1_bInterop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue_));
                return JSIdenticalNode.doForeignObject(leftNodeValue_, rightNodeValue_, foreignObject1_aInterop__, foreignObject1_bInterop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    private boolean executeBoolean_generic5(int state_0, int state_1, VirtualFrame frameValue) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if (((state_0 & 0b1) != 0 /* is-state_0 doInt(int, int) */) && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if (rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return JSIdenticalNode.doInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0b10) != 0 /* is-state_0 doDouble(double, double) */) && JSTypesGen.isImplicitDouble((state_1 & 0b111100) >>> 2 /* extract-implicit-state_1 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_1 & 0b111100) >>> 2 /* extract-implicit-state_1 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 1:double */, rightNodeValue_);
                return doDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0b100) != 0 /* is-state_0 doBoolean(boolean, boolean) */) && leftNodeValue_ instanceof Boolean) {
            boolean leftNodeValue__ = (boolean) leftNodeValue_;
            if (rightNodeValue_ instanceof Boolean) {
                boolean rightNodeValue__ = (boolean) rightNodeValue_;
                return JSIdenticalNode.doBoolean(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0b11000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) || doBigIntDouble(BigInt, double) */) && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (((state_0 & 0b1000) != 0 /* is-state_0 doBigInt(BigInt, BigInt) */) && rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return JSIdenticalNode.doBigInt(leftNodeValue__, rightNodeValue__);
            }
            if (((state_0 & 0b10000) != 0 /* is-state_0 doBigIntDouble(BigInt, double) */) && JSTypesGen.isImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state_1 & 0b1111000000) >>> 6 /* extract-implicit-state_1 1:double */, rightNodeValue_);
                return JSIdenticalNode.doBigIntDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0b100000) != 0 /* is-state_0 doDoubleBigInt(double, BigInt) */) && JSTypesGen.isImplicitDouble((state_1 & 0b111100) >>> 2 /* extract-implicit-state_1 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state_1 & 0b111100) >>> 2 /* extract-implicit-state_1 0:double */, leftNodeValue_);
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return JSIdenticalNode.doDoubleBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0b111000000) != 0 /* is-state_0 doUndefinedA(Object, Object) || doUndefinedB(Object, Object) || doJSObjectA(DynamicObject, Object) */)) {
            if (((state_0 & 0b11000000) != 0 /* is-state_0 doUndefinedA(Object, Object) || doUndefinedB(Object, Object) */)) {
                if (((state_0 & 0b1000000) != 0 /* is-state_0 doUndefinedA(Object, Object) */)) {
                    if ((JSGuards.isUndefined(leftNodeValue_))) {
                        return JSIdenticalNode.doUndefinedA(leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((state_0 & 0b10000000) != 0 /* is-state_0 doUndefinedB(Object, Object) */)) {
                    if ((JSGuards.isUndefined(rightNodeValue_))) {
                        return JSIdenticalNode.doUndefinedB(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((state_0 & 0b100000000) != 0 /* is-state_0 doJSObjectA(DynamicObject, Object) */) && JSTypes.isDynamicObject(leftNodeValue_)) {
                DynamicObject leftNodeValue__ = (DynamicObject) leftNodeValue_;
                if ((JSGuards.isJSObject(leftNodeValue__))) {
                    return JSIdenticalNode.doJSObjectA(leftNodeValue__, rightNodeValue_);
                }
            }
        }
        if (((state_0 & 0x1fe00) != 0 /* is-state_0 doJSObjectB(Object, DynamicObject) || doNullNull(Object, Object) || doNullUndefined(Object, Object) || doUndefinedNull(Object, Object) || doNullA(Object, Object, InteropLibrary) || doNullA(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) */)) {
            if (((state_0 & 0b1000000000) != 0 /* is-state_0 doJSObjectB(Object, DynamicObject) */) && JSTypes.isDynamicObject(rightNodeValue_)) {
                DynamicObject rightNodeValue__ = (DynamicObject) rightNodeValue_;
                if ((JSGuards.isJSObject(rightNodeValue__))) {
                    return JSIdenticalNode.doJSObjectB(leftNodeValue_, rightNodeValue__);
                }
            }
            if (((state_0 & 0x1fc00) != 0 /* is-state_0 doNullNull(Object, Object) || doNullUndefined(Object, Object) || doUndefinedNull(Object, Object) || doNullA(Object, Object, InteropLibrary) || doNullA(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) */)) {
                if (((state_0 & 0b10000000000) != 0 /* is-state_0 doNullNull(Object, Object) */)) {
                    if ((JSGuards.isJSNull(leftNodeValue_)) && (JSGuards.isJSNull(rightNodeValue_))) {
                        return JSIdenticalNode.doNullNull(leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((state_0 & 0b100000000000) != 0 /* is-state_0 doNullUndefined(Object, Object) */)) {
                    if ((JSGuards.isJSNull(leftNodeValue_)) && (JSGuards.isUndefined(rightNodeValue_))) {
                        return JSIdenticalNode.doNullUndefined(leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((state_0 & 0b1000000000000) != 0 /* is-state_0 doUndefinedNull(Object, Object) */)) {
                    if ((JSGuards.isUndefined(leftNodeValue_)) && (JSGuards.isJSNull(rightNodeValue_))) {
                        return JSIdenticalNode.doUndefinedNull(leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((state_0 & 0b10000000000000) != 0 /* is-state_0 doNullA(Object, Object, InteropLibrary) */)) {
                    NullA0Data s13_ = this.nullA0_cache;
                    while (s13_ != null) {
                        if ((s13_.bInterop_.accepts(rightNodeValue_)) && (JSGuards.isJSNull(leftNodeValue_)) && (!(JSGuards.isJSNull(rightNodeValue_))) && (!(JSGuards.isUndefined(rightNodeValue_)))) {
                            return JSIdenticalNode.doNullA(leftNodeValue_, rightNodeValue_, s13_.bInterop_);
                        }
                        s13_ = s13_.next_;
                    }
                }
                if (((state_0 & 0b100000000000000) != 0 /* is-state_0 doNullA(Object, Object, InteropLibrary) */)) {
                    if ((JSGuards.isJSNull(leftNodeValue_)) && (!(JSGuards.isJSNull(rightNodeValue_))) && (!(JSGuards.isUndefined(rightNodeValue_)))) {
                        return this.nullA1Boundary0(state_0, state_1, leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((state_0 & 0b1000000000000000) != 0 /* is-state_0 doNullB(Object, Object, InteropLibrary) */)) {
                    NullB0Data s15_ = this.nullB0_cache;
                    while (s15_ != null) {
                        if ((s15_.aInterop_.accepts(leftNodeValue_)) && (!(JSGuards.isJSNull(leftNodeValue_))) && (!(JSGuards.isUndefined(leftNodeValue_))) && (JSGuards.isJSNull(rightNodeValue_))) {
                            return JSIdenticalNode.doNullB(leftNodeValue_, rightNodeValue_, s15_.aInterop_);
                        }
                        s15_ = s15_.next_;
                    }
                }
                if (((state_0 & 0x10000) != 0 /* is-state_0 doNullB(Object, Object, InteropLibrary) */)) {
                    if ((!(JSGuards.isJSNull(leftNodeValue_))) && (!(JSGuards.isUndefined(leftNodeValue_))) && (JSGuards.isJSNull(rightNodeValue_))) {
                        return this.nullB1Boundary1(state_0, state_1, leftNodeValue_, rightNodeValue_);
                    }
                }
            }
        }
        if (((state_0 & 0xe0000) != 0 /* is-state_0 doLazyStringReference(JSLazyString, JSLazyString) || doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) || doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) */) && rightNodeValue_ instanceof JSLazyString) {
            JSLazyString rightNodeValue__ = (JSLazyString) rightNodeValue_;
            if (((state_0 & 0x60000) != 0 /* is-state_0 doLazyStringReference(JSLazyString, JSLazyString) || doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) */) && leftNodeValue_ instanceof JSLazyString) {
                JSLazyString leftNodeValue__ = (JSLazyString) leftNodeValue_;
                if (((state_0 & 0x20000) != 0 /* is-state_0 doLazyStringReference(JSLazyString, JSLazyString) */)) {
                    if ((JSGuards.isReferenceEquals(leftNodeValue__, rightNodeValue__))) {
                        return JSIdenticalNode.doLazyStringReference(leftNodeValue__, rightNodeValue__);
                    }
                }
                if (((state_0 & 0x40000) != 0 /* is-state_0 doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) */)) {
                    return JSIdenticalNode.doLazyString(leftNodeValue__, rightNodeValue__, this.flattenA, this.flattenB, this.sameLen);
                }
            }
            if (((state_0 & 0x80000) != 0 /* is-state_0 doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) */) && JSTypesGen.isImplicitString((state_1 & 0b1110000000000) >>> 10 /* extract-implicit-state_1 0:String */, leftNodeValue_)) {
                String leftNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0b1110000000000) >>> 10 /* extract-implicit-state_1 0:String */, leftNodeValue_);
                return JSIdenticalNode.doStringLazyString(leftNodeValue__, rightNodeValue__, this.flattenB, this.sameLen);
            }
        }
        if (((state_0 & 0x700000) != 0 /* is-state_0 doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) || doStringIdentity(String, String) || doString(String, String) */) && JSTypesGen.isImplicitString((state_1 & 0b1110000000000000) >>> 13 /* extract-implicit-state_1 1:String */, rightNodeValue_)) {
            String rightNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0b1110000000000000) >>> 13 /* extract-implicit-state_1 1:String */, rightNodeValue_);
            if (((state_0 & 0x100000) != 0 /* is-state_0 doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) */) && leftNodeValue_ instanceof JSLazyString) {
                JSLazyString leftNodeValue__ = (JSLazyString) leftNodeValue_;
                return JSIdenticalNode.doLazyStringString(leftNodeValue__, rightNodeValue__, this.flattenA, this.sameLen);
            }
            if (((state_0 & 0x600000) != 0 /* is-state_0 doStringIdentity(String, String) || doString(String, String) */) && JSTypesGen.isImplicitString((state_1 & 0b1110000000000) >>> 10 /* extract-implicit-state_1 0:String */, leftNodeValue_)) {
                String leftNodeValue__ = JSTypesGen.asImplicitString((state_1 & 0b1110000000000) >>> 10 /* extract-implicit-state_1 0:String */, leftNodeValue_);
                if (((state_0 & 0x200000) != 0 /* is-state_0 doStringIdentity(String, String) */)) {
                    if ((JSGuards.isReferenceEquals(leftNodeValue__, rightNodeValue__))) {
                        return JSIdenticalNode.doStringIdentity(leftNodeValue__, rightNodeValue__);
                    }
                }
                if (((state_0 & 0x400000) != 0 /* is-state_0 doString(String, String) */)) {
                    return JSIdenticalNode.doString(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if (((state_0 & 0x800000) != 0 /* is-state_0 doSymbol(Symbol, Symbol) */) && leftNodeValue_ instanceof Symbol) {
            Symbol leftNodeValue__ = (Symbol) leftNodeValue_;
            if (rightNodeValue_ instanceof Symbol) {
                Symbol rightNodeValue__ = (Symbol) rightNodeValue_;
                return JSIdenticalNode.doSymbol(leftNodeValue__, rightNodeValue__);
            }
        }
        if (((state_0 & 0x3f000000) != 0 /* is-state_0 doBooleanNotBoolean(Object, Object) || doSymbolNotSymbol(Object, Object) || doDifferentTypesCached(Object, Object, Class<>, Class<>) || doNumberNotNumber(Object, Object) || doStringNotString(Object, Object) || doNumberCached(Object, Object, Class<>, Class<>) */)) {
            if (((state_0 & 0x1000000) != 0 /* is-state_0 doBooleanNotBoolean(Object, Object) */)) {
                if ((JSGuards.isBoolean(leftNodeValue_) != JSGuards.isBoolean(rightNodeValue_))) {
                    return JSIdenticalNode.doBooleanNotBoolean(leftNodeValue_, rightNodeValue_);
                }
            }
            if (((state_0 & 0x2000000) != 0 /* is-state_0 doSymbolNotSymbol(Object, Object) */)) {
                if ((JSGuards.isSymbol(leftNodeValue_) != JSGuards.isSymbol(rightNodeValue_))) {
                    return JSIdenticalNode.doSymbolNotSymbol(leftNodeValue_, rightNodeValue_);
                }
            }
            if (((state_0 & 0x4000000) != 0 /* is-state_0 doDifferentTypesCached(Object, Object, Class<>, Class<>) */)) {
                DifferentTypesCachedData s26_ = this.differentTypesCached_cache;
                while (s26_ != null) {
                    if ((leftNodeValue_.getClass() == s26_.cachedClassA_) && (rightNodeValue_.getClass() == s26_.cachedClassB_)) {
                        assert (JSIdenticalNode.isNonObjectType(s26_.cachedClassA_) || JSIdenticalNode.isNonObjectType(s26_.cachedClassB_));
                        assert (JSIdenticalNode.differentNonObjectTypes(s26_.cachedClassA_, s26_.cachedClassB_));
                        return JSIdenticalNode.doDifferentTypesCached(leftNodeValue_, rightNodeValue_, s26_.cachedClassA_, s26_.cachedClassB_);
                    }
                    s26_ = s26_.next_;
                }
            }
            if (((state_0 & 0x8000000) != 0 /* is-state_0 doNumberNotNumber(Object, Object) */)) {
                if ((JSRuntime.isJavaNumber(leftNodeValue_) != JSRuntime.isJavaNumber(rightNodeValue_))) {
                    return JSIdenticalNode.doNumberNotNumber(leftNodeValue_, rightNodeValue_);
                }
            }
            if (((state_0 & 0x10000000) != 0 /* is-state_0 doStringNotString(Object, Object) */)) {
                if ((JSRuntime.isString(leftNodeValue_) != JSRuntime.isString(rightNodeValue_))) {
                    return JSIdenticalNode.doStringNotString(leftNodeValue_, rightNodeValue_);
                }
            }
            if (((state_0 & 0x20000000) != 0 /* is-state_0 doNumberCached(Object, Object, Class<>, Class<>) */)) {
                NumberCachedData s29_ = this.numberCached_cache;
                while (s29_ != null) {
                    assert (s29_.cachedClassA_ != null);
                    assert (s29_.cachedClassB_ != null);
                    if ((leftNodeValue_.getClass() == s29_.cachedClassA_) && (rightNodeValue_.getClass() == s29_.cachedClassB_)) {
                        return doNumberCached(leftNodeValue_, rightNodeValue_, s29_.cachedClassA_, s29_.cachedClassB_);
                    }
                    s29_ = s29_.next_;
                }
            }
        }
        if (((state_0 & 0x40000000) != 0 /* is-state_0 doNumber(Number, Number) */) && leftNodeValue_ instanceof Number) {
            Number leftNodeValue__ = (Number) leftNodeValue_;
            if (rightNodeValue_ instanceof Number) {
                Number rightNodeValue__ = (Number) rightNodeValue_;
                if ((JSRuntime.isJavaNumber(leftNodeValue__)) && (JSRuntime.isJavaNumber(rightNodeValue__))) {
                    return doNumber(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if (((state_0 & 0x80000000) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ || (state_1 & 0b11) != 0 /* is-state_1 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) || doFallback(Object, Object) */)) {
            if (((state_0 & 0x80000000) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */)) {
                ForeignObject0Data s31_ = this.foreignObject0_cache;
                while (s31_ != null) {
                    if ((s31_.aInterop_.accepts(leftNodeValue_)) && (s31_.bInterop_.accepts(rightNodeValue_)) && (JSRuntime.isForeignObject(leftNodeValue_)) && (JSRuntime.isForeignObject(rightNodeValue_))) {
                        return JSIdenticalNode.doForeignObject(leftNodeValue_, rightNodeValue_, s31_.aInterop_, s31_.bInterop_);
                    }
                    s31_ = s31_.next_;
                }
            }
            if (((state_1 & 0b1) != 0 /* is-state_1 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */)) {
                if ((JSRuntime.isForeignObject(leftNodeValue_)) && (JSRuntime.isForeignObject(rightNodeValue_))) {
                    return this.foreignObject1Boundary2(state_0, state_1, leftNodeValue_, rightNodeValue_);
                }
            }
            if (((state_1 & 0b10) != 0 /* is-state_1 doFallback(Object, Object) */)) {
                if (fallbackGuard_(state_0, state_1, leftNodeValue_, rightNodeValue_)) {
                    return JSIdenticalNode.doFallback(leftNodeValue_, rightNodeValue_);
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
                    return JSIdenticalNode.doInt(leftNodeValue_, rightNodeValue_);
                }
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state_1 = (state_1 | (doubleCast0 << 2) /* set-implicit-state_1 0:double */);
                        state_1 = (state_1 | (doubleCast1 << 6) /* set-implicit-state_1 1:double */);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDouble(double, double) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (leftNodeValue instanceof Boolean) {
                boolean leftNodeValue_ = (boolean) leftNodeValue;
                if (rightNodeValue instanceof Boolean) {
                    boolean rightNodeValue_ = (boolean) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doBoolean(boolean, boolean) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doBoolean(leftNodeValue_, rightNodeValue_);
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
                    return JSIdenticalNode.doBigInt(leftNodeValue_, rightNodeValue_);
                }
                {
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state_1 = (state_1 | (doubleCast1 << 6) /* set-implicit-state_1 1:double */);
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doBigIntDouble(BigInt, double) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return JSIdenticalNode.doBigIntDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    if (rightNodeValue instanceof BigInt) {
                        BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                        state_1 = (state_1 | (doubleCast0 << 2) /* set-implicit-state_1 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doDoubleBigInt(double, BigInt) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return JSIdenticalNode.doDoubleBigInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if ((JSGuards.isUndefined(leftNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doUndefinedA(Object, Object) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doUndefinedA(leftNodeValue, rightNodeValue);
            }
            if ((JSGuards.isUndefined(rightNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doUndefinedB(Object, Object) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doUndefinedB(leftNodeValue, rightNodeValue);
            }
            if (JSTypes.isDynamicObject(leftNodeValue)) {
                DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
                if ((JSGuards.isJSObject(leftNodeValue_))) {
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doJSObjectA(DynamicObject, Object) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doJSObjectA(leftNodeValue_, rightNodeValue);
                }
            }
            if (JSTypes.isDynamicObject(rightNodeValue)) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                if ((JSGuards.isJSObject(rightNodeValue_))) {
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doJSObjectB(Object, DynamicObject) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doJSObjectB(leftNodeValue, rightNodeValue_);
                }
            }
            if ((JSGuards.isJSNull(leftNodeValue)) && (JSGuards.isJSNull(rightNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doNullNull(Object, Object) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doNullNull(leftNodeValue, rightNodeValue);
            }
            if ((JSGuards.isJSNull(leftNodeValue)) && (JSGuards.isUndefined(rightNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doNullUndefined(Object, Object) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doNullUndefined(leftNodeValue, rightNodeValue);
            }
            if ((JSGuards.isUndefined(leftNodeValue)) && (JSGuards.isJSNull(rightNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doUndefinedNull(Object, Object) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doUndefinedNull(leftNodeValue, rightNodeValue);
            }
            if (((exclude & 0b1)) == 0 /* is-not-exclude doNullA(Object, Object, InteropLibrary) */) {
                int count13_ = 0;
                NullA0Data s13_ = this.nullA0_cache;
                if (((state_0 & 0b10000000000000) != 0 /* is-state_0 doNullA(Object, Object, InteropLibrary) */)) {
                    while (s13_ != null) {
                        if ((s13_.bInterop_.accepts(rightNodeValue)) && (JSGuards.isJSNull(leftNodeValue)) && (!(JSGuards.isJSNull(rightNodeValue))) && (!(JSGuards.isUndefined(rightNodeValue)))) {
                            break;
                        }
                        s13_ = s13_.next_;
                        count13_++;
                    }
                }
                if (s13_ == null) {
                    if ((JSGuards.isJSNull(leftNodeValue)) && (!(JSGuards.isJSNull(rightNodeValue))) && (!(JSGuards.isUndefined(rightNodeValue))) && count13_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s13_.bInterop_.accepts(rightNodeValue));
                        s13_ = super.insert(new NullA0Data(nullA0_cache));
                        s13_.bInterop_ = s13_.insertAccessor((INTEROP_LIBRARY_.create(rightNodeValue)));
                        MemoryFence.storeStore();
                        this.nullA0_cache = s13_;
                        this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 doNullA(Object, Object, InteropLibrary) */;
                        this.state_1_ = state_1;
                    }
                }
                if (s13_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doNullA(leftNodeValue, rightNodeValue, s13_.bInterop_);
                }
            }
            {
                InteropLibrary nullA1_bInterop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isJSNull(leftNodeValue)) && (!(JSGuards.isJSNull(rightNodeValue))) && (!(JSGuards.isUndefined(rightNodeValue)))) {
                            nullA1_bInterop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue));
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doNullA(Object, Object, InteropLibrary) */;
                            this.nullA0_cache = null;
                            state_0 = state_0 & 0xffffdfff /* remove-state_0 doNullA(Object, Object, InteropLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0b100000000000000 /* add-state_0 doNullA(Object, Object, InteropLibrary) */;
                            this.state_1_ = state_1;
                            lock.unlock();
                            hasLock = false;
                            return JSIdenticalNode.doNullA(leftNodeValue, rightNodeValue, nullA1_bInterop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doNullB(Object, Object, InteropLibrary) */) {
                int count15_ = 0;
                NullB0Data s15_ = this.nullB0_cache;
                if (((state_0 & 0b1000000000000000) != 0 /* is-state_0 doNullB(Object, Object, InteropLibrary) */)) {
                    while (s15_ != null) {
                        if ((s15_.aInterop_.accepts(leftNodeValue)) && (!(JSGuards.isJSNull(leftNodeValue))) && (!(JSGuards.isUndefined(leftNodeValue))) && (JSGuards.isJSNull(rightNodeValue))) {
                            break;
                        }
                        s15_ = s15_.next_;
                        count15_++;
                    }
                }
                if (s15_ == null) {
                    if ((!(JSGuards.isJSNull(leftNodeValue))) && (!(JSGuards.isUndefined(leftNodeValue))) && (JSGuards.isJSNull(rightNodeValue)) && count15_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s15_.aInterop_.accepts(leftNodeValue));
                        s15_ = super.insert(new NullB0Data(nullB0_cache));
                        s15_.aInterop_ = s15_.insertAccessor((INTEROP_LIBRARY_.create(leftNodeValue)));
                        MemoryFence.storeStore();
                        this.nullB0_cache = s15_;
                        this.state_0_ = state_0 = state_0 | 0b1000000000000000 /* add-state_0 doNullB(Object, Object, InteropLibrary) */;
                        this.state_1_ = state_1;
                    }
                }
                if (s15_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doNullB(leftNodeValue, rightNodeValue, s15_.aInterop_);
                }
            }
            {
                InteropLibrary nullB1_aInterop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((!(JSGuards.isJSNull(leftNodeValue))) && (!(JSGuards.isUndefined(leftNodeValue))) && (JSGuards.isJSNull(rightNodeValue))) {
                            nullB1_aInterop__ = (INTEROP_LIBRARY_.getUncached(leftNodeValue));
                            this.exclude_ = exclude = exclude | 0b10 /* add-exclude doNullB(Object, Object, InteropLibrary) */;
                            this.nullB0_cache = null;
                            state_0 = state_0 & 0xffff7fff /* remove-state_0 doNullB(Object, Object, InteropLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0x10000 /* add-state_0 doNullB(Object, Object, InteropLibrary) */;
                            this.state_1_ = state_1;
                            lock.unlock();
                            hasLock = false;
                            return JSIdenticalNode.doNullB(leftNodeValue, rightNodeValue, nullB1_aInterop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if (rightNodeValue instanceof JSLazyString) {
                JSLazyString rightNodeValue_ = (JSLazyString) rightNodeValue;
                if (leftNodeValue instanceof JSLazyString) {
                    JSLazyString leftNodeValue_ = (JSLazyString) leftNodeValue;
                    if (((exclude & 0b100)) == 0 /* is-not-exclude doLazyStringReference(JSLazyString, JSLazyString) */) {
                        if ((JSGuards.isReferenceEquals(leftNodeValue_, rightNodeValue_))) {
                            this.state_0_ = state_0 = state_0 | 0x20000 /* add-state_0 doLazyStringReference(JSLazyString, JSLazyString) */;
                            this.state_1_ = state_1;
                            lock.unlock();
                            hasLock = false;
                            return JSIdenticalNode.doLazyStringReference(leftNodeValue_, rightNodeValue_);
                        }
                    }
                    this.flattenA = this.flattenA == null ? ((ConditionProfile.createBinaryProfile())) : this.flattenA;
                    this.flattenB = this.flattenB == null ? ((ConditionProfile.createBinaryProfile())) : this.flattenB;
                    this.sameLen = this.sameLen == null ? ((ConditionProfile.createBinaryProfile())) : this.sameLen;
                    this.exclude_ = exclude = exclude | 0b100 /* add-exclude doLazyStringReference(JSLazyString, JSLazyString) */;
                    state_0 = state_0 & 0xfffdffff /* remove-state_0 doLazyStringReference(JSLazyString, JSLazyString) */;
                    this.state_0_ = state_0 = state_0 | 0x40000 /* add-state_0 doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doLazyString(leftNodeValue_, rightNodeValue_, this.flattenA, this.flattenB, this.sameLen);
                }
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(leftNodeValue)) != 0) {
                        String leftNodeValue_ = JSTypesGen.asImplicitString(stringCast0, leftNodeValue);
                        this.flattenB = this.flattenB == null ? ((ConditionProfile.createBinaryProfile())) : this.flattenB;
                        this.sameLen = this.sameLen == null ? ((ConditionProfile.createBinaryProfile())) : this.sameLen;
                        state_1 = (state_1 | (stringCast0 << 10) /* set-implicit-state_1 0:String */);
                        this.state_0_ = state_0 = state_0 | 0x80000 /* add-state_0 doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return JSIdenticalNode.doStringLazyString(leftNodeValue_, rightNodeValue_, this.flattenB, this.sameLen);
                    }
                }
            }
            {
                int stringCast1;
                if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                    String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                    if (leftNodeValue instanceof JSLazyString) {
                        JSLazyString leftNodeValue_ = (JSLazyString) leftNodeValue;
                        this.flattenA = this.flattenA == null ? ((ConditionProfile.createBinaryProfile())) : this.flattenA;
                        this.sameLen = this.sameLen == null ? ((ConditionProfile.createBinaryProfile())) : this.sameLen;
                        state_1 = (state_1 | (stringCast1 << 13) /* set-implicit-state_1 1:String */);
                        this.state_0_ = state_0 = state_0 | 0x100000 /* add-state_0 doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return JSIdenticalNode.doLazyStringString(leftNodeValue_, rightNodeValue_, this.flattenA, this.sameLen);
                    }
                    {
                        int stringCast0;
                        if ((stringCast0 = JSTypesGen.specializeImplicitString(leftNodeValue)) != 0) {
                            String leftNodeValue_ = JSTypesGen.asImplicitString(stringCast0, leftNodeValue);
                            if (((exclude & 0b1000)) == 0 /* is-not-exclude doStringIdentity(String, String) */) {
                                if ((JSGuards.isReferenceEquals(leftNodeValue_, rightNodeValue_))) {
                                    state_1 = (state_1 | (stringCast0 << 10) /* set-implicit-state_1 0:String */);
                                    state_1 = (state_1 | (stringCast1 << 13) /* set-implicit-state_1 1:String */);
                                    this.state_0_ = state_0 = state_0 | 0x200000 /* add-state_0 doStringIdentity(String, String) */;
                                    this.state_1_ = state_1;
                                    lock.unlock();
                                    hasLock = false;
                                    return JSIdenticalNode.doStringIdentity(leftNodeValue_, rightNodeValue_);
                                }
                            }
                            this.exclude_ = exclude = exclude | 0b1000 /* add-exclude doStringIdentity(String, String) */;
                            state_0 = state_0 & 0xffdfffff /* remove-state_0 doStringIdentity(String, String) */;
                            state_1 = (state_1 | (stringCast0 << 10) /* set-implicit-state_1 0:String */);
                            state_1 = (state_1 | (stringCast1 << 13) /* set-implicit-state_1 1:String */);
                            this.state_0_ = state_0 = state_0 | 0x400000 /* add-state_0 doString(String, String) */;
                            this.state_1_ = state_1;
                            lock.unlock();
                            hasLock = false;
                            return JSIdenticalNode.doString(leftNodeValue_, rightNodeValue_);
                        }
                    }
                }
            }
            if (leftNodeValue instanceof Symbol) {
                Symbol leftNodeValue_ = (Symbol) leftNodeValue;
                if (rightNodeValue instanceof Symbol) {
                    Symbol rightNodeValue_ = (Symbol) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0x800000 /* add-state_0 doSymbol(Symbol, Symbol) */;
                    this.state_1_ = state_1;
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doSymbol(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((JSGuards.isBoolean(leftNodeValue) != JSGuards.isBoolean(rightNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0x1000000 /* add-state_0 doBooleanNotBoolean(Object, Object) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doBooleanNotBoolean(leftNodeValue, rightNodeValue);
            }
            if ((JSGuards.isSymbol(leftNodeValue) != JSGuards.isSymbol(rightNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0x2000000 /* add-state_0 doSymbolNotSymbol(Object, Object) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doSymbolNotSymbol(leftNodeValue, rightNodeValue);
            }
            if (((exclude & 0b10000)) == 0 /* is-not-exclude doDifferentTypesCached(Object, Object, Class<>, Class<>) */) {
                int count26_ = 0;
                DifferentTypesCachedData s26_ = this.differentTypesCached_cache;
                if (((state_0 & 0x4000000) != 0 /* is-state_0 doDifferentTypesCached(Object, Object, Class<>, Class<>) */)) {
                    while (s26_ != null) {
                        if ((leftNodeValue.getClass() == s26_.cachedClassA_) && (rightNodeValue.getClass() == s26_.cachedClassB_)) {
                            assert (JSIdenticalNode.isNonObjectType(s26_.cachedClassA_) || JSIdenticalNode.isNonObjectType(s26_.cachedClassB_));
                            assert (JSIdenticalNode.differentNonObjectTypes(s26_.cachedClassA_, s26_.cachedClassB_));
                            break;
                        }
                        s26_ = s26_.next_;
                        count26_++;
                    }
                }
                if (s26_ == null) {
                    {
                        Class<?> cachedClassA__ = (leftNodeValue.getClass());
                        if ((leftNodeValue.getClass() == cachedClassA__)) {
                            Class<?> cachedClassB__ = (rightNodeValue.getClass());
                            if ((rightNodeValue.getClass() == cachedClassB__) && (JSIdenticalNode.isNonObjectType(cachedClassA__) || JSIdenticalNode.isNonObjectType(cachedClassB__)) && (JSIdenticalNode.differentNonObjectTypes(cachedClassA__, cachedClassB__)) && count26_ < (JSIdenticalNode.MAX_CLASSES)) {
                                s26_ = new DifferentTypesCachedData(differentTypesCached_cache);
                                s26_.cachedClassA_ = cachedClassA__;
                                s26_.cachedClassB_ = cachedClassB__;
                                MemoryFence.storeStore();
                                this.differentTypesCached_cache = s26_;
                                this.state_0_ = state_0 = state_0 | 0x4000000 /* add-state_0 doDifferentTypesCached(Object, Object, Class<>, Class<>) */;
                                this.state_1_ = state_1;
                            }
                        }
                    }
                }
                if (s26_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doDifferentTypesCached(leftNodeValue, rightNodeValue, s26_.cachedClassA_, s26_.cachedClassB_);
                }
            }
            if ((JSRuntime.isJavaNumber(leftNodeValue) != JSRuntime.isJavaNumber(rightNodeValue))) {
                this.exclude_ = exclude = exclude | 0b10000 /* add-exclude doDifferentTypesCached(Object, Object, Class<>, Class<>) */;
                this.differentTypesCached_cache = null;
                state_0 = state_0 & 0xfbffffff /* remove-state_0 doDifferentTypesCached(Object, Object, Class<>, Class<>) */;
                this.state_0_ = state_0 = state_0 | 0x8000000 /* add-state_0 doNumberNotNumber(Object, Object) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doNumberNotNumber(leftNodeValue, rightNodeValue);
            }
            if ((JSRuntime.isString(leftNodeValue) != JSRuntime.isString(rightNodeValue))) {
                this.exclude_ = exclude = exclude | 0b10000 /* add-exclude doDifferentTypesCached(Object, Object, Class<>, Class<>) */;
                this.differentTypesCached_cache = null;
                state_0 = state_0 & 0xfbffffff /* remove-state_0 doDifferentTypesCached(Object, Object, Class<>, Class<>) */;
                this.state_0_ = state_0 = state_0 | 0x10000000 /* add-state_0 doStringNotString(Object, Object) */;
                this.state_1_ = state_1;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doStringNotString(leftNodeValue, rightNodeValue);
            }
            if (((exclude & 0b100000)) == 0 /* is-not-exclude doNumberCached(Object, Object, Class<>, Class<>) */) {
                int count29_ = 0;
                NumberCachedData s29_ = this.numberCached_cache;
                if (((state_0 & 0x20000000) != 0 /* is-state_0 doNumberCached(Object, Object, Class<>, Class<>) */)) {
                    while (s29_ != null) {
                        assert (s29_.cachedClassA_ != null);
                        assert (s29_.cachedClassB_ != null);
                        if ((leftNodeValue.getClass() == s29_.cachedClassA_) && (rightNodeValue.getClass() == s29_.cachedClassB_)) {
                            break;
                        }
                        s29_ = s29_.next_;
                        count29_++;
                    }
                }
                if (s29_ == null) {
                    {
                        Class<?> cachedClassA__1 = (JSGuards.getJavaNumberClass(leftNodeValue));
                        if ((cachedClassA__1 != null)) {
                            Class<?> cachedClassB__1 = (JSGuards.getJavaNumberClass(rightNodeValue));
                            if ((cachedClassB__1 != null) && (leftNodeValue.getClass() == cachedClassA__1) && (rightNodeValue.getClass() == cachedClassB__1) && count29_ < (JSIdenticalNode.MAX_CLASSES)) {
                                s29_ = new NumberCachedData(numberCached_cache);
                                s29_.cachedClassA_ = cachedClassA__1;
                                s29_.cachedClassB_ = cachedClassB__1;
                                MemoryFence.storeStore();
                                this.numberCached_cache = s29_;
                                this.state_0_ = state_0 = state_0 | 0x20000000 /* add-state_0 doNumberCached(Object, Object, Class<>, Class<>) */;
                                this.state_1_ = state_1;
                            }
                        }
                    }
                }
                if (s29_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doNumberCached(leftNodeValue, rightNodeValue, s29_.cachedClassA_, s29_.cachedClassB_);
                }
            }
            if (leftNodeValue instanceof Number) {
                Number leftNodeValue_ = (Number) leftNodeValue;
                if (rightNodeValue instanceof Number) {
                    Number rightNodeValue_ = (Number) rightNodeValue;
                    if ((JSRuntime.isJavaNumber(leftNodeValue_)) && (JSRuntime.isJavaNumber(rightNodeValue_))) {
                        this.exclude_ = exclude = exclude | 0b100000 /* add-exclude doNumberCached(Object, Object, Class<>, Class<>) */;
                        this.numberCached_cache = null;
                        state_0 = state_0 & 0xdfffffff /* remove-state_0 doNumberCached(Object, Object, Class<>, Class<>) */;
                        this.state_0_ = state_0 = state_0 | 0x40000000 /* add-state_0 doNumber(Number, Number) */;
                        this.state_1_ = state_1;
                        lock.unlock();
                        hasLock = false;
                        return doNumber(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((exclude & 0b1000000)) == 0 /* is-not-exclude doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */) {
                int count31_ = 0;
                ForeignObject0Data s31_ = this.foreignObject0_cache;
                if (((state_0 & 0x80000000) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */)) {
                    while (s31_ != null) {
                        if ((s31_.aInterop_.accepts(leftNodeValue)) && (s31_.bInterop_.accepts(rightNodeValue)) && (JSRuntime.isForeignObject(leftNodeValue)) && (JSRuntime.isForeignObject(rightNodeValue))) {
                            break;
                        }
                        s31_ = s31_.next_;
                        count31_++;
                    }
                }
                if (s31_ == null) {
                    if ((JSRuntime.isForeignObject(leftNodeValue)) && (JSRuntime.isForeignObject(rightNodeValue)) && count31_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s31_.aInterop_.accepts(leftNodeValue));
                        // assert (s31_.bInterop_.accepts(rightNodeValue));
                        s31_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                        s31_.aInterop_ = s31_.insertAccessor((INTEROP_LIBRARY_.create(leftNodeValue)));
                        s31_.bInterop_ = s31_.insertAccessor((INTEROP_LIBRARY_.create(rightNodeValue)));
                        MemoryFence.storeStore();
                        this.foreignObject0_cache = s31_;
                        this.state_0_ = state_0 = state_0 | 0x80000000 /* add-state_0 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */;
                        this.state_1_ = state_1;
                    }
                }
                if (s31_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doForeignObject(leftNodeValue, rightNodeValue, s31_.aInterop_, s31_.bInterop_);
                }
            }
            {
                InteropLibrary foreignObject1_bInterop__ = null;
                InteropLibrary foreignObject1_aInterop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSRuntime.isForeignObject(leftNodeValue)) && (JSRuntime.isForeignObject(rightNodeValue))) {
                            foreignObject1_aInterop__ = (INTEROP_LIBRARY_.getUncached(leftNodeValue));
                            foreignObject1_bInterop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue));
                            this.exclude_ = exclude = exclude | 0b1000000 /* add-exclude doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */;
                            this.foreignObject0_cache = null;
                            state_0 = state_0 & 0x7fffffff /* remove-state_0 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */;
                            this.state_0_ = state_0;
                            this.state_1_ = state_1 = state_1 | 0b1 /* add-state_1 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return JSIdenticalNode.doForeignObject(leftNodeValue, rightNodeValue, foreignObject1_aInterop__, foreignObject1_bInterop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            this.state_0_ = state_0;
            this.state_1_ = state_1 = state_1 | 0b10 /* add-state_1 doFallback(Object, Object) */;
            lock.unlock();
            hasLock = false;
            return JSIdenticalNode.doFallback(leftNodeValue, rightNodeValue);
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
        if (state_0 == 0 && (state_1 & 0b11) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            int counter = 0;
            counter += Integer.bitCount(state_0);
            counter += Integer.bitCount((state_1 & 0b11));
            if (counter == 1) {
                NullA0Data s13_ = this.nullA0_cache;
                NullB0Data s15_ = this.nullB0_cache;
                DifferentTypesCachedData s26_ = this.differentTypesCached_cache;
                NumberCachedData s29_ = this.numberCached_cache;
                ForeignObject0Data s31_ = this.foreignObject0_cache;
                if ((s13_ == null || s13_.next_ == null) && (s15_ == null || s15_.next_ == null) && (s26_ == null || s26_.next_ == null) && (s29_ == null || s29_.next_ == null) && (s31_ == null || s31_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[35];
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
        s[0] = "doDouble";
        if (((state_0 & 0b10) != 0 /* is-state_0 doDouble(double, double) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if (((state_0 & 0b100) != 0 /* is-state_0 doBoolean(boolean, boolean) */)) {
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
        s[0] = "doBigIntDouble";
        if (((state_0 & 0b10000) != 0 /* is-state_0 doBigIntDouble(BigInt, double) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doDoubleBigInt";
        if (((state_0 & 0b100000) != 0 /* is-state_0 doDoubleBigInt(double, BigInt) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doUndefinedA";
        if (((state_0 & 0b1000000) != 0 /* is-state_0 doUndefinedA(Object, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doUndefinedB";
        if (((state_0 & 0b10000000) != 0 /* is-state_0 doUndefinedB(Object, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doJSObjectA";
        if (((state_0 & 0b100000000) != 0 /* is-state_0 doJSObjectA(DynamicObject, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doJSObjectB";
        if (((state_0 & 0b1000000000) != 0 /* is-state_0 doJSObjectB(Object, DynamicObject) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doNullNull";
        if (((state_0 & 0b10000000000) != 0 /* is-state_0 doNullNull(Object, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doNullUndefined";
        if (((state_0 & 0b100000000000) != 0 /* is-state_0 doNullUndefined(Object, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doUndefinedNull";
        if (((state_0 & 0b1000000000000) != 0 /* is-state_0 doUndefinedNull(Object, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doNullA";
        if (((state_0 & 0b10000000000000) != 0 /* is-state_0 doNullA(Object, Object, InteropLibrary) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            NullA0Data s13_ = this.nullA0_cache;
            while (s13_ != null) {
                cached.add(Arrays.asList(s13_.bInterop_));
                s13_ = s13_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doNullA(Object, Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        s = new Object[3];
        s[0] = "doNullA";
        if (((state_0 & 0b100000000000000) != 0 /* is-state_0 doNullA(Object, Object, InteropLibrary) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[15] = s;
        s = new Object[3];
        s[0] = "doNullB";
        if (((state_0 & 0b1000000000000000) != 0 /* is-state_0 doNullB(Object, Object, InteropLibrary) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            NullB0Data s15_ = this.nullB0_cache;
            while (s15_ != null) {
                cached.add(Arrays.asList(s15_.aInterop_));
                s15_ = s15_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doNullB(Object, Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[16] = s;
        s = new Object[3];
        s[0] = "doNullB";
        if (((state_0 & 0x10000) != 0 /* is-state_0 doNullB(Object, Object, InteropLibrary) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[17] = s;
        s = new Object[3];
        s[0] = "doLazyStringReference";
        if (((state_0 & 0x20000) != 0 /* is-state_0 doLazyStringReference(JSLazyString, JSLazyString) */)) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-exclude doLazyStringReference(JSLazyString, JSLazyString) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[18] = s;
        s = new Object[3];
        s[0] = "doLazyString";
        if (((state_0 & 0x40000) != 0 /* is-state_0 doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.flattenA, this.flattenB, this.sameLen));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[19] = s;
        s = new Object[3];
        s[0] = "doStringLazyString";
        if (((state_0 & 0x80000) != 0 /* is-state_0 doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.flattenB, this.sameLen));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[20] = s;
        s = new Object[3];
        s[0] = "doLazyStringString";
        if (((state_0 & 0x100000) != 0 /* is-state_0 doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.flattenA, this.sameLen));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[21] = s;
        s = new Object[3];
        s[0] = "doStringIdentity";
        if (((state_0 & 0x200000) != 0 /* is-state_0 doStringIdentity(String, String) */)) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doStringIdentity(String, String) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[22] = s;
        s = new Object[3];
        s[0] = "doString";
        if (((state_0 & 0x400000) != 0 /* is-state_0 doString(String, String) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[23] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if (((state_0 & 0x800000) != 0 /* is-state_0 doSymbol(Symbol, Symbol) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[24] = s;
        s = new Object[3];
        s[0] = "doBooleanNotBoolean";
        if (((state_0 & 0x1000000) != 0 /* is-state_0 doBooleanNotBoolean(Object, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[25] = s;
        s = new Object[3];
        s[0] = "doSymbolNotSymbol";
        if (((state_0 & 0x2000000) != 0 /* is-state_0 doSymbolNotSymbol(Object, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[26] = s;
        s = new Object[3];
        s[0] = "doDifferentTypesCached";
        if (((state_0 & 0x4000000) != 0 /* is-state_0 doDifferentTypesCached(Object, Object, Class<>, Class<>) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            DifferentTypesCachedData s26_ = this.differentTypesCached_cache;
            while (s26_ != null) {
                cached.add(Arrays.asList(s26_.cachedClassA_, s26_.cachedClassB_));
                s26_ = s26_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10000) != 0 /* is-exclude doDifferentTypesCached(Object, Object, Class<>, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[27] = s;
        s = new Object[3];
        s[0] = "doNumberNotNumber";
        if (((state_0 & 0x8000000) != 0 /* is-state_0 doNumberNotNumber(Object, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[28] = s;
        s = new Object[3];
        s[0] = "doStringNotString";
        if (((state_0 & 0x10000000) != 0 /* is-state_0 doStringNotString(Object, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[29] = s;
        s = new Object[3];
        s[0] = "doNumberCached";
        if (((state_0 & 0x20000000) != 0 /* is-state_0 doNumberCached(Object, Object, Class<>, Class<>) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            NumberCachedData s29_ = this.numberCached_cache;
            while (s29_ != null) {
                cached.add(Arrays.asList(s29_.cachedClassA_, s29_.cachedClassB_));
                s29_ = s29_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b100000) != 0 /* is-exclude doNumberCached(Object, Object, Class<>, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[30] = s;
        s = new Object[3];
        s[0] = "doNumber";
        if (((state_0 & 0x40000000) != 0 /* is-state_0 doNumber(Number, Number) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[31] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if (((state_0 & 0x80000000) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s31_ = this.foreignObject0_cache;
            while (s31_ != null) {
                cached.add(Arrays.asList(s31_.aInterop_, s31_.bInterop_));
                s31_ = s31_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1000000) != 0 /* is-exclude doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[32] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if (((state_1 & 0b1) != 0 /* is-state_1 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */)) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[33] = s;
        s = new Object[3];
        s[0] = "doFallback";
        if (((state_1 & 0b10) != 0 /* is-state_1 doFallback(Object, Object) */)) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[34] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state_0, int state_1, Object leftNodeValue, Object rightNodeValue) {
        if (JSTypesGen.isImplicitDouble(leftNodeValue) && JSTypesGen.isImplicitDouble(rightNodeValue)) {
            return false;
        }
        if (((state_0 & 0b100)) == 0 /* is-not-state_0 doBoolean(boolean, boolean) */ && leftNodeValue instanceof Boolean && rightNodeValue instanceof Boolean) {
            return false;
        }
        if (leftNodeValue instanceof BigInt) {
            if (((state_0 & 0b1000)) == 0 /* is-not-state_0 doBigInt(BigInt, BigInt) */ && rightNodeValue instanceof BigInt) {
                return false;
            }
            if (JSTypesGen.isImplicitDouble(rightNodeValue)) {
                return false;
            }
        }
        if (JSTypesGen.isImplicitDouble(leftNodeValue) && rightNodeValue instanceof BigInt) {
            return false;
        }
        if (((state_0 & 0b1000000)) == 0 /* is-not-state_0 doUndefinedA(Object, Object) */ && (JSGuards.isUndefined(leftNodeValue))) {
            return false;
        }
        if (((state_0 & 0b10000000)) == 0 /* is-not-state_0 doUndefinedB(Object, Object) */ && (JSGuards.isUndefined(rightNodeValue))) {
            return false;
        }
        if (JSTypes.isDynamicObject(leftNodeValue)) {
            DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
            if ((JSGuards.isJSObject(leftNodeValue_))) {
                return false;
            }
        }
        if (JSTypes.isDynamicObject(rightNodeValue)) {
            DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
            if ((JSGuards.isJSObject(rightNodeValue_))) {
                return false;
            }
        }
        if (((state_0 & 0b10000000000)) == 0 /* is-not-state_0 doNullNull(Object, Object) */ && (JSGuards.isJSNull(leftNodeValue)) && (JSGuards.isJSNull(rightNodeValue))) {
            return false;
        }
        if (((state_0 & 0b100000000000)) == 0 /* is-not-state_0 doNullUndefined(Object, Object) */ && (JSGuards.isJSNull(leftNodeValue)) && (JSGuards.isUndefined(rightNodeValue))) {
            return false;
        }
        if (((state_0 & 0b1000000000000)) == 0 /* is-not-state_0 doUndefinedNull(Object, Object) */ && (JSGuards.isUndefined(leftNodeValue)) && (JSGuards.isJSNull(rightNodeValue))) {
            return false;
        }
        if (((state_0 & 0b100000000000000)) == 0 /* is-not-state_0 doNullA(Object, Object, InteropLibrary) */ && (JSGuards.isJSNull(leftNodeValue)) && (!(JSGuards.isJSNull(rightNodeValue))) && (!(JSGuards.isUndefined(rightNodeValue)))) {
            return false;
        }
        if (((state_0 & 0x10000)) == 0 /* is-not-state_0 doNullB(Object, Object, InteropLibrary) */ && (!(JSGuards.isJSNull(leftNodeValue))) && (!(JSGuards.isUndefined(leftNodeValue))) && (JSGuards.isJSNull(rightNodeValue))) {
            return false;
        }
        if (JSTypesGen.isImplicitString(leftNodeValue) && JSTypesGen.isImplicitString(rightNodeValue)) {
            return false;
        }
        if (((state_0 & 0x800000)) == 0 /* is-not-state_0 doSymbol(Symbol, Symbol) */ && leftNodeValue instanceof Symbol && rightNodeValue instanceof Symbol) {
            return false;
        }
        if (((state_0 & 0x1000000)) == 0 /* is-not-state_0 doBooleanNotBoolean(Object, Object) */ && (JSGuards.isBoolean(leftNodeValue) != JSGuards.isBoolean(rightNodeValue))) {
            return false;
        }
        if (((state_0 & 0x2000000)) == 0 /* is-not-state_0 doSymbolNotSymbol(Object, Object) */ && (JSGuards.isSymbol(leftNodeValue) != JSGuards.isSymbol(rightNodeValue))) {
            return false;
        }
        if (((state_0 & 0x8000000)) == 0 /* is-not-state_0 doNumberNotNumber(Object, Object) */ && (JSRuntime.isJavaNumber(leftNodeValue) != JSRuntime.isJavaNumber(rightNodeValue))) {
            return false;
        }
        if (((state_0 & 0x10000000)) == 0 /* is-not-state_0 doStringNotString(Object, Object) */ && (JSRuntime.isString(leftNodeValue) != JSRuntime.isString(rightNodeValue))) {
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
        if (((state_1 & 0b1)) == 0 /* is-not-state_1 doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ && (JSRuntime.isForeignObject(leftNodeValue)) && (JSRuntime.isForeignObject(rightNodeValue))) {
            return false;
        }
        return true;
    }

    public static JSIdenticalNode create(JavaScriptNode left, JavaScriptNode right, int type) {
        return new JSIdenticalNodeGen(left, right, type);
    }

    @GeneratedBy(JSIdenticalNode.class)
    private static final class NullA0Data extends Node {

        @Child NullA0Data next_;
        @Child InteropLibrary bInterop_;

        NullA0Data(NullA0Data next_) {
            this.next_ = next_;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSIdenticalNode.class)
    private static final class NullB0Data extends Node {

        @Child NullB0Data next_;
        @Child InteropLibrary aInterop_;

        NullB0Data(NullB0Data next_) {
            this.next_ = next_;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSIdenticalNode.class)
    private static final class DifferentTypesCachedData {

        @CompilationFinal DifferentTypesCachedData next_;
        @CompilationFinal Class<?> cachedClassA_;
        @CompilationFinal Class<?> cachedClassB_;

        DifferentTypesCachedData(DifferentTypesCachedData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(JSIdenticalNode.class)
    private static final class NumberCachedData {

        @CompilationFinal NumberCachedData next_;
        @CompilationFinal Class<?> cachedClassA_;
        @CompilationFinal Class<?> cachedClassB_;

        NumberCachedData(NumberCachedData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(JSIdenticalNode.class)
    private static final class ForeignObject0Data extends Node {

        @Child ForeignObject0Data next_;
        @Child InteropLibrary aInterop_;
        @Child InteropLibrary bInterop_;

        ForeignObject0Data(ForeignObject0Data next_) {
            this.next_ = next_;
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
