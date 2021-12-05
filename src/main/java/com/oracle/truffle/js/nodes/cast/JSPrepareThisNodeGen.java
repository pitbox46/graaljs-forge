// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSPrepareThisNode.class)
@SuppressWarnings("unused")
public final class JSPrepareThisNodeGen extends JSPrepareThisNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private Class<?> jSObjectCached_cachedClass_;
    @Child private ForeignObject0Data foreignObject0_cache;

    private JSPrepareThisNodeGen(JSContext context, JavaScriptNode child) {
        super(context, child);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 doJSObject(Object) || doJSObjectCached(Object, Class<>) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doJSObject(Object) */) {
                if ((JSGuards.isNullOrUndefined(operandNodeValue))) {
                    return doJSObject(operandNodeValue);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
                assert (this.jSObjectCached_cachedClass_ != null);
                if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue))) {
                    return doJSObjectCached(operandNodeValue, this.jSObjectCached_cachedClass_);
                }
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doJSObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            if ((JSGuards.isJSObject(operandNodeValue_))) {
                return doJSObject(operandNodeValue_);
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            return doBoolean(operandNodeValue_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doJSLazyString(JSLazyString) */ && operandNodeValue instanceof JSLazyString) {
            JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
            return doJSLazyString(operandNodeValue_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doString(String) */ && JSTypesGen.isImplicitString((state_0 & 0b1110000000000000) >>> 13 /* extract-implicit-state_0 0:String */, operandNodeValue)) {
            String operandNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0b1110000000000000) >>> 13 /* extract-implicit-state_0 0:String */, operandNodeValue);
            return doString(operandNodeValue_);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doInt(operandNodeValue_);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_);
        }
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return doBigInt(operandNodeValue_);
        }
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doNumber(Object) */) {
            if ((JSGuards.isJavaNumber(operandNodeValue))) {
                return doNumber(operandNodeValue);
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return doSymbol(operandNodeValue_);
        }
        if ((state_0 & 0b1100000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                ForeignObject0Data s11_ = this.foreignObject0_cache;
                while (s11_ != null) {
                    if ((s11_.interop_.accepts(operandNodeValue)) && (JSGuards.isForeignObject(operandNodeValue))) {
                        return doForeignObject(operandNodeValue, s11_.interop_);
                    }
                    s11_ = s11_.next_;
                }
            }
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(operandNodeValue))) {
                    return this.foreignObject1Boundary(state_0, operandNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object foreignObject1Boundary(int state_0, Object operandNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                return doForeignObject(operandNodeValue, foreignObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1111111110111) == 0 /* only-active doBoolean(boolean) */ && ((state_0 & 0b1111111111111) != 0  /* is-not doJSObject(Object) && doJSObjectCached(Object, Class<>) && doJSObject(DynamicObject) && doBoolean(boolean) && doJSLazyString(JSLazyString) && doString(String) && doInt(int) && doDouble(double) && doBigInt(BigInt) && doNumber(Object) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */)) {
            return execute_boolean0(state_0, frameValue);
        } else if ((state_0 & 0b1111110111111) == 0 /* only-active doInt(int) */ && ((state_0 & 0b1111111111111) != 0  /* is-not doJSObject(Object) && doJSObjectCached(Object, Class<>) && doJSObject(DynamicObject) && doBoolean(boolean) && doJSLazyString(JSLazyString) && doString(String) && doInt(int) && doDouble(double) && doBigInt(BigInt) && doNumber(Object) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */)) {
            return execute_int1(state_0, frameValue);
        } else if ((state_0 & 0b1111101111111) == 0 /* only-active doDouble(double) */ && ((state_0 & 0b1111111111111) != 0  /* is-not doJSObject(Object) && doJSObjectCached(Object, Class<>) && doJSObject(DynamicObject) && doBoolean(boolean) && doJSLazyString(JSLazyString) && doString(String) && doInt(int) && doDouble(double) && doBigInt(BigInt) && doNumber(Object) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */)) {
            return execute_double2(state_0, frameValue);
        } else {
            return execute_generic3(state_0, frameValue);
        }
    }

    private Object execute_boolean0(int state_0, VirtualFrame frameValue) {
        boolean operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1000) != 0 /* is-state_0 doBoolean(boolean) */;
        return doBoolean(operandNodeValue_);
    }

    private Object execute_int1(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1000000) != 0 /* is-state_0 doInt(int) */;
        return doInt(operandNodeValue_);
    }

    private Object execute_double2(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0xe0000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111111) != 0  /* is-not doJSObject(Object) && doJSObjectCached(Object, Class<>) && doJSObject(DynamicObject) && doBoolean(boolean) && doJSLazyString(JSLazyString) && doString(String) && doInt(int) && doDouble(double) && doBigInt(BigInt) && doNumber(Object) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0xd0000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111111) != 0  /* is-not doJSObject(Object) && doJSObjectCached(Object, Class<>) && doJSObject(DynamicObject) && doBoolean(boolean) && doJSLazyString(JSLazyString) && doString(String) && doInt(int) && doDouble(double) && doBigInt(BigInt) && doNumber(Object) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0xb0000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111111111111) != 0  /* is-not doJSObject(Object) && doJSObjectCached(Object, Class<>) && doJSObject(DynamicObject) && doBoolean(boolean) && doJSLazyString(JSLazyString) && doString(String) && doInt(int) && doDouble(double) && doBigInt(BigInt) && doNumber(Object) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b10000000) != 0 /* is-state_0 doDouble(double) */;
        return doDouble(operandNodeValue_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object foreignObject1Boundary0(int state_0, Object operandNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue_));
                return doForeignObject(operandNodeValue_, foreignObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    private Object execute_generic3(int state_0, VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b11) != 0 /* is-state_0 doJSObject(Object) || doJSObjectCached(Object, Class<>) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doJSObject(Object) */) {
                if ((JSGuards.isNullOrUndefined(operandNodeValue_))) {
                    return doJSObject(operandNodeValue_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
                assert (this.jSObjectCached_cachedClass_ != null);
                if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue_))) {
                    return doJSObjectCached(operandNodeValue_, this.jSObjectCached_cachedClass_);
                }
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doJSObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue_)) {
            DynamicObject operandNodeValue__ = (DynamicObject) operandNodeValue_;
            if ((JSGuards.isJSObject(operandNodeValue__))) {
                return doJSObject(operandNodeValue__);
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue_ instanceof Boolean) {
            boolean operandNodeValue__ = (boolean) operandNodeValue_;
            return doBoolean(operandNodeValue__);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doJSLazyString(JSLazyString) */ && operandNodeValue_ instanceof JSLazyString) {
            JSLazyString operandNodeValue__ = (JSLazyString) operandNodeValue_;
            return doJSLazyString(operandNodeValue__);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doString(String) */ && JSTypesGen.isImplicitString((state_0 & 0b1110000000000000) >>> 13 /* extract-implicit-state_0 0:String */, operandNodeValue_)) {
            String operandNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0b1110000000000000) >>> 13 /* extract-implicit-state_0 0:String */, operandNodeValue_);
            return doString(operandNodeValue__);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            return doInt(operandNodeValue__);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__);
        }
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return doBigInt(operandNodeValue__);
        }
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doNumber(Object) */) {
            if ((JSGuards.isJavaNumber(operandNodeValue_))) {
                return doNumber(operandNodeValue_);
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue_ instanceof Symbol) {
            Symbol operandNodeValue__ = (Symbol) operandNodeValue_;
            return doSymbol(operandNodeValue__);
        }
        if ((state_0 & 0b1100000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                ForeignObject0Data s11_ = this.foreignObject0_cache;
                while (s11_ != null) {
                    if ((s11_.interop_.accepts(operandNodeValue_)) && (JSGuards.isForeignObject(operandNodeValue_))) {
                        return doForeignObject(operandNodeValue_, s11_.interop_);
                    }
                    s11_ = s11_.next_;
                }
            }
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(operandNodeValue_))) {
                    return this.foreignObject1Boundary0(state_0, operandNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((JSGuards.isNullOrUndefined(operandNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doJSObject(Object) */;
                lock.unlock();
                hasLock = false;
                return doJSObject(operandNodeValue);
            }
            if (((exclude & 0b1)) == 0 /* is-not-exclude doJSObjectCached(Object, Class<>) */) {
                boolean JSObjectCached_duplicateFound_ = false;
                if ((state_0 & 0b10) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
                    assert (this.jSObjectCached_cachedClass_ != null);
                    if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue))) {
                        JSObjectCached_duplicateFound_ = true;
                    }
                }
                if (!JSObjectCached_duplicateFound_) {
                    {
                        Class<?> jSObjectCached_cachedClass__ = (JSGuards.getClassIfJSObject(operandNodeValue));
                        if ((jSObjectCached_cachedClass__ != null) && (jSObjectCached_cachedClass__.isInstance(operandNodeValue)) && ((state_0 & 0b10)) == 0 /* is-not-state_0 doJSObjectCached(Object, Class<>) */) {
                            this.jSObjectCached_cachedClass_ = jSObjectCached_cachedClass__;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doJSObjectCached(Object, Class<>) */;
                            JSObjectCached_duplicateFound_ = true;
                        }
                    }
                }
                if (JSObjectCached_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return doJSObjectCached(operandNodeValue, this.jSObjectCached_cachedClass_);
                }
            }
            if (JSTypes.isDynamicObject(operandNodeValue)) {
                DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
                if ((JSGuards.isJSObject(operandNodeValue_))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doJSObjectCached(Object, Class<>) */;
                    state_0 = state_0 & 0xfffffffd /* remove-state_0 doJSObjectCached(Object, Class<>) */;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doJSObject(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(operandNodeValue_);
                }
            }
            if (operandNodeValue instanceof Boolean) {
                boolean operandNodeValue_ = (boolean) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return doBoolean(operandNodeValue_);
            }
            if (operandNodeValue instanceof JSLazyString) {
                JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doJSLazyString(JSLazyString) */;
                lock.unlock();
                hasLock = false;
                return doJSLazyString(operandNodeValue_);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(operandNodeValue)) != 0) {
                    String operandNodeValue_ = JSTypesGen.asImplicitString(stringCast0, operandNodeValue);
                    state_0 = (state_0 | (stringCast0 << 13) /* set-implicit-state_0 0:String */);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(operandNodeValue_);
                }
            }
            if (operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doInt(int) */;
                lock.unlock();
                hasLock = false;
                return doInt(operandNodeValue_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    state_0 = (state_0 | (doubleCast0 << 16) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(operandNodeValue_);
                }
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(operandNodeValue_);
            }
            if ((JSGuards.isJavaNumber(operandNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doNumber(Object) */;
                lock.unlock();
                hasLock = false;
                return doNumber(operandNodeValue);
            }
            if (operandNodeValue instanceof Symbol) {
                Symbol operandNodeValue_ = (Symbol) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(operandNodeValue_);
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doForeignObject(Object, InteropLibrary) */) {
                int count11_ = 0;
                ForeignObject0Data s11_ = this.foreignObject0_cache;
                if ((state_0 & 0b100000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                    while (s11_ != null) {
                        if ((s11_.interop_.accepts(operandNodeValue)) && (JSGuards.isForeignObject(operandNodeValue))) {
                            break;
                        }
                        s11_ = s11_.next_;
                        count11_++;
                    }
                }
                if (s11_ == null) {
                    if ((JSGuards.isForeignObject(operandNodeValue)) && count11_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s11_.interop_.accepts(operandNodeValue));
                        s11_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                        s11_.interop_ = s11_.insertAccessor((INTEROP_LIBRARY_.create(operandNodeValue)));
                        MemoryFence.storeStore();
                        this.foreignObject0_cache = s11_;
                        this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doForeignObject(Object, InteropLibrary) */;
                    }
                }
                if (s11_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doForeignObject(operandNodeValue, s11_.interop_);
                }
            }
            {
                InteropLibrary foreignObject1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(operandNodeValue))) {
                            foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                            this.exclude_ = exclude = exclude | 0b10 /* add-exclude doForeignObject(Object, InteropLibrary) */;
                            this.foreignObject0_cache = null;
                            state_0 = state_0 & 0xfffff7ff /* remove-state_0 doForeignObject(Object, InteropLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doForeignObject(Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return doForeignObject(operandNodeValue, foreignObject1_interop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
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
        if ((state_0 & 0b1111111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111111111111) & ((state_0 & 0b1111111111111) - 1)) == 0 /* is-single-state_0  */) {
                ForeignObject0Data s11_ = this.foreignObject0_cache;
                if ((s11_ == null || s11_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[14];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state_0 & 0b1) != 0 /* is-state_0 doJSObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doJSObjectCached";
        if ((state_0 & 0b10) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSObjectCached_cachedClass_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doJSObjectCached(Object, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state_0 & 0b100) != 0 /* is-state_0 doJSObject(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doJSLazyString";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doJSLazyString(JSLazyString) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doString(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt(int) */) {
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
        s[0] = "doBigInt";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doNumber";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doNumber(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s11_ = this.foreignObject0_cache;
            while (s11_ != null) {
                cached.add(Arrays.asList(s11_.interop_));
                s11_ = s11_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        return Provider.create(data);
    }

    public static JSPrepareThisNode create(JSContext context, JavaScriptNode child) {
        return new JSPrepareThisNodeGen(context, child);
    }

    @GeneratedBy(JSPrepareThisNode.class)
    private static final class ForeignObject0Data extends Node {

        @Child ForeignObject0Data next_;
        @Child InteropLibrary interop_;

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
