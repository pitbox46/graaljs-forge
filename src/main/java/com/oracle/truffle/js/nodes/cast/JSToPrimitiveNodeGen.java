// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.access.IsPrimitiveNode;
import com.oracle.truffle.js.nodes.access.PropertyNode;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToPrimitiveNode.class)
@SuppressWarnings("unused")
public final class JSToPrimitiveNodeGen extends JSToPrimitiveNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSObjectData jSObject_cache;
    @Child private TruffleJavaObject0Data truffleJavaObject0_cache;
    @Child private ImportValueNode truffleJavaObject1_toJSType_;

    private JSToPrimitiveNodeGen(Hint hint) {
        super(hint);
    }

    @ExplodeLoop
    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return doInt(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            return doSafeInteger(arg0Value_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            return doLong(arg0Value_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x3c000) >>> 14 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0x3c000) >>> 14 /* extract-implicit-state_0 0:double */, arg0Value);
            return doDouble(arg0Value_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return doBoolean(arg0Value_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doString(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x1c0000) >>> 18 /* extract-implicit-state_0 0:CharSequence */, arg0Value)) {
            CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence((state_0 & 0x1c0000) >>> 18 /* extract-implicit-state_0 0:CharSequence */, arg0Value);
            return doString(arg0Value_);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doNull(Object) || doUndefined(Object) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(arg0Value))) {
                    return doNull(arg0Value);
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return doUndefined(arg0Value);
                }
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doJSObject(DynamicObject, PropertyNode, IsPrimitiveNode, OrdinaryToPrimitiveNode, ConditionProfile, JSFunctionCallNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            JSObjectData s10_ = this.jSObject_cache;
            if (s10_ != null) {
                if ((JSGuards.isJSObject(arg0Value_))) {
                    return doJSObject(arg0Value_, s10_.getToPrimitive_, s10_.isPrimitive_, s10_.ordinaryToPrimitive_, s10_.exoticToPrimProfile_, s10_.callExoticToPrim_);
                }
            }
        }
        if ((state_0 & 0b11100000000000) != 0 /* is-state_0 doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) || doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) || doFallback(Object) */) {
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) */) {
                TruffleJavaObject0Data s11_ = this.truffleJavaObject0_cache;
                while (s11_ != null) {
                    if ((s11_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                        return doTruffleJavaObject(arg0Value, s11_.interop_, s11_.toJSType_);
                    }
                    s11_ = s11_.next_;
                }
            }
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return this.truffleJavaObject1Boundary(state_0, arg0Value);
                }
            }
            if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doFallback(Object) */) {
                if (fallbackGuard_(state_0, arg0Value)) {
                    return doFallback(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object truffleJavaObject1Boundary(int state_0, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary truffleJavaObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return doTruffleJavaObject(arg0Value, truffleJavaObject1_interop__, this.truffleJavaObject1_toJSType_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt(int) */;
                lock.unlock();
                hasLock = false;
                return doInt(arg0Value_);
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doSafeInteger(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return doSafeInteger(arg0Value_);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doLong(long) */;
                lock.unlock();
                hasLock = false;
                return doLong(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state_0 = (state_0 | (doubleCast0 << 14) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(arg0Value_);
                }
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return doBoolean(arg0Value_);
            }
            {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(arg0Value)) != 0) {
                    CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, arg0Value);
                    state_0 = (state_0 | (charSequenceCast0 << 18) /* set-implicit-state_0 0:CharSequence */);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doString(CharSequence) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_);
                }
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(arg0Value_);
            }
            if ((JSGuards.isJSNull(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return doNull(arg0Value);
            }
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return doUndefined(arg0Value);
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSObject(arg0Value_))) {
                    JSObjectData s10_ = super.insert(new JSObjectData());
                    s10_.getToPrimitive_ = s10_.insertAccessor((JSToPrimitiveNode.createGetToPrimitive(arg0Value_)));
                    s10_.isPrimitive_ = s10_.insertAccessor((IsPrimitiveNode.create()));
                    s10_.ordinaryToPrimitive_ = s10_.insertAccessor((createOrdinaryToPrimitive(arg0Value_)));
                    s10_.exoticToPrimProfile_ = (ConditionProfile.createBinaryProfile());
                    s10_.callExoticToPrim_ = s10_.insertAccessor((JSFunctionCallNode.createCall()));
                    MemoryFence.storeStore();
                    this.jSObject_cache = s10_;
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doJSObject(DynamicObject, PropertyNode, IsPrimitiveNode, OrdinaryToPrimitiveNode, ConditionProfile, JSFunctionCallNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(arg0Value_, s10_.getToPrimitive_, s10_.isPrimitive_, s10_.ordinaryToPrimitive_, s10_.exoticToPrimProfile_, s10_.callExoticToPrim_);
                }
            }
            if ((exclude) == 0 /* is-not-exclude doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) */) {
                int count11_ = 0;
                TruffleJavaObject0Data s11_ = this.truffleJavaObject0_cache;
                if ((state_0 & 0b100000000000) != 0 /* is-state_0 doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) */) {
                    while (s11_ != null) {
                        if ((s11_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                            break;
                        }
                        s11_ = s11_.next_;
                        count11_++;
                    }
                }
                if (s11_ == null) {
                    if ((JSGuards.isForeignObject(arg0Value)) && count11_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s11_.interop_.accepts(arg0Value));
                        s11_ = super.insert(new TruffleJavaObject0Data(truffleJavaObject0_cache));
                        s11_.interop_ = s11_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        s11_.toJSType_ = s11_.insertAccessor((ImportValueNode.create()));
                        MemoryFence.storeStore();
                        this.truffleJavaObject0_cache = s11_;
                        this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) */;
                    }
                }
                if (s11_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doTruffleJavaObject(arg0Value, s11_.interop_, s11_.toJSType_);
                }
            }
            {
                InteropLibrary truffleJavaObject1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(arg0Value))) {
                            truffleJavaObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            this.truffleJavaObject1_toJSType_ = super.insert((ImportValueNode.create()));
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) */;
                            this.truffleJavaObject0_cache = null;
                            state_0 = state_0 & 0xfffff7ff /* remove-state_0 doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) */;
                            this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) */;
                            lock.unlock();
                            hasLock = false;
                            return doTruffleJavaObject(arg0Value, truffleJavaObject1_interop__, this.truffleJavaObject1_toJSType_);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 doFallback(Object) */;
            lock.unlock();
            hasLock = false;
            return doFallback(arg0Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11111111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b11111111111111) & ((state_0 & 0b11111111111111) - 1)) == 0 /* is-single-state_0  */) {
                TruffleJavaObject0Data s11_ = this.truffleJavaObject0_cache;
                if ((s11_ == null || s11_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[15];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */) {
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
        s[0] = "doLong";
        if ((state_0 & 0b100) != 0 /* is-state_0 doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doString(CharSequence) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doNull";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doJSObject(DynamicObject, PropertyNode, IsPrimitiveNode, OrdinaryToPrimitiveNode, ConditionProfile, JSFunctionCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            JSObjectData s10_ = this.jSObject_cache;
            if (s10_ != null) {
                cached.add(Arrays.asList(s10_.getToPrimitive_, s10_.isPrimitive_, s10_.ordinaryToPrimitive_, s10_.exoticToPrimProfile_, s10_.callExoticToPrim_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doTruffleJavaObject";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            TruffleJavaObject0Data s11_ = this.truffleJavaObject0_cache;
            while (s11_ != null) {
                cached.add(Arrays.asList(s11_.interop_, s11_.toJSType_));
                s11_ = s11_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doTruffleJavaObject";
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.truffleJavaObject1_toJSType_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doFallback";
        if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doFallback(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state_0, Object arg0Value) {
        if (JSTypesGen.isImplicitDouble(arg0Value)) {
            return false;
        }
        if (((state_0 & 0b10000)) == 0 /* is-not-state_0 doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            return false;
        }
        if (JSTypesGen.isImplicitCharSequence(arg0Value)) {
            return false;
        }
        if (((state_0 & 0b1000000)) == 0 /* is-not-state_0 doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            return false;
        }
        if (((state_0 & 0b10000000)) == 0 /* is-not-state_0 doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            return false;
        }
        if (((state_0 & 0b100000000)) == 0 /* is-not-state_0 doNull(Object) */ && (JSGuards.isJSNull(arg0Value))) {
            return false;
        }
        if (((state_0 & 0b1000000000)) == 0 /* is-not-state_0 doUndefined(Object) */ && (JSGuards.isUndefined(arg0Value))) {
            return false;
        }
        if (JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSObject(arg0Value_))) {
                return false;
            }
        }
        if (((state_0 & 0b1000000000000)) == 0 /* is-not-state_0 doTruffleJavaObject(Object, InteropLibrary, ImportValueNode) */ && (JSGuards.isForeignObject(arg0Value))) {
            return false;
        }
        return true;
    }

    public static JSToPrimitiveNode create(Hint hint) {
        return new JSToPrimitiveNodeGen(hint);
    }

    @GeneratedBy(JSToPrimitiveNode.class)
    private static final class JSObjectData extends Node {

        @Child PropertyNode getToPrimitive_;
        @Child IsPrimitiveNode isPrimitive_;
        @Child OrdinaryToPrimitiveNode ordinaryToPrimitive_;
        @CompilationFinal ConditionProfile exoticToPrimProfile_;
        @Child JSFunctionCallNode callExoticToPrim_;

        JSObjectData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSToPrimitiveNode.class)
    private static final class TruffleJavaObject0Data extends Node {

        @Child TruffleJavaObject0Data next_;
        @Child InteropLibrary interop_;
        @Child ImportValueNode toJSType_;

        TruffleJavaObject0Data(TruffleJavaObject0Data next_) {
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
