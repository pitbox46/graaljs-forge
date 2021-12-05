// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

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
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RequireObjectCoercibleNode.class)
@SuppressWarnings("unused")
public final class RequireObjectCoercibleNodeGen extends RequireObjectCoercibleNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private Class<?> cachedJSClass_cachedClass_;
    @Child private ForeignObject0Data foreignObject0_cache;

    private RequireObjectCoercibleNodeGen() {
    }

    @ExplodeLoop
    @Override
    public void executeVoid(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            RequireObjectCoercibleNode.doInt(arg0Value_);
            return;
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            RequireObjectCoercibleNode.doSafeInteger(arg0Value_);
            return;
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            RequireObjectCoercibleNode.doLong(arg0Value_);
            return;
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x1e000) >>> 13 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0x1e000) >>> 13 /* extract-implicit-state_0 0:double */, arg0Value);
            RequireObjectCoercibleNode.doDouble(arg0Value_);
            return;
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doCharSequence(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0xe0000) >>> 17 /* extract-implicit-state_0 0:CharSequence */, arg0Value)) {
            CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence((state_0 & 0xe0000) >>> 17 /* extract-implicit-state_0 0:CharSequence */, arg0Value);
            RequireObjectCoercibleNode.doCharSequence(arg0Value_);
            return;
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            RequireObjectCoercibleNode.doBoolean(arg0Value_);
            return;
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            RequireObjectCoercibleNode.doSymbol(arg0Value_);
            return;
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            RequireObjectCoercibleNode.doBigInt(arg0Value_);
            return;
        }
        if ((state_0 & 0b111100000000) != 0 /* is-state_0 doCachedJSClass(Object, Class<>) || doJSObject(Object) || doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doCachedJSClass(Object, Class<>) */) {
                assert (this.cachedJSClass_cachedClass_ != null);
                if ((this.cachedJSClass_cachedClass_.isInstance(arg0Value))) {
                    RequireObjectCoercibleNode.doCachedJSClass(arg0Value, this.cachedJSClass_cachedClass_);
                    return;
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSObject(Object) */) {
                if ((JSGuards.isJSObject(arg0Value))) {
                    RequireObjectCoercibleNode.doJSObject(arg0Value);
                    return;
                }
            }
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                ForeignObject0Data s10_ = this.foreignObject0_cache;
                while (s10_ != null) {
                    if ((s10_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                        doForeignObject(arg0Value, s10_.interop_);
                        return;
                    }
                    s10_ = s10_.next_;
                }
            }
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    this.foreignObject1Boundary(state_0, arg0Value);
                    return;
                }
            }
        }
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doNullOrUndefined(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isNullOrUndefined(arg0Value_))) {
                doNullOrUndefined(arg0Value_);
                return;
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(arg0Value);
        return;
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private void foreignObject1Boundary(int state_0, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                doForeignObject(arg0Value, foreignObject1_interop__);
                return;
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private void executeAndSpecialize(Object arg0Value) {
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
                RequireObjectCoercibleNode.doInt(arg0Value_);
                return;
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doSafeInteger(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                RequireObjectCoercibleNode.doSafeInteger(arg0Value_);
                return;
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doLong(long) */;
                lock.unlock();
                hasLock = false;
                RequireObjectCoercibleNode.doLong(arg0Value_);
                return;
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state_0 = (state_0 | (doubleCast0 << 13) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    RequireObjectCoercibleNode.doDouble(arg0Value_);
                    return;
                }
            }
            {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(arg0Value)) != 0) {
                    CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, arg0Value);
                    state_0 = (state_0 | (charSequenceCast0 << 17) /* set-implicit-state_0 0:CharSequence */);
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doCharSequence(CharSequence) */;
                    lock.unlock();
                    hasLock = false;
                    RequireObjectCoercibleNode.doCharSequence(arg0Value_);
                    return;
                }
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                RequireObjectCoercibleNode.doBoolean(arg0Value_);
                return;
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                RequireObjectCoercibleNode.doSymbol(arg0Value_);
                return;
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                RequireObjectCoercibleNode.doBigInt(arg0Value_);
                return;
            }
            if (((exclude & 0b1)) == 0 /* is-not-exclude doCachedJSClass(Object, Class<>) */) {
                boolean CachedJSClass_duplicateFound_ = false;
                if ((state_0 & 0b100000000) != 0 /* is-state_0 doCachedJSClass(Object, Class<>) */) {
                    assert (this.cachedJSClass_cachedClass_ != null);
                    if ((this.cachedJSClass_cachedClass_.isInstance(arg0Value))) {
                        CachedJSClass_duplicateFound_ = true;
                    }
                }
                if (!CachedJSClass_duplicateFound_) {
                    {
                        Class<?> cachedJSClass_cachedClass__ = (JSGuards.getClassIfJSObject(arg0Value));
                        if ((cachedJSClass_cachedClass__ != null) && (cachedJSClass_cachedClass__.isInstance(arg0Value)) && ((state_0 & 0b100000000)) == 0 /* is-not-state_0 doCachedJSClass(Object, Class<>) */) {
                            this.cachedJSClass_cachedClass_ = cachedJSClass_cachedClass__;
                            this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doCachedJSClass(Object, Class<>) */;
                            CachedJSClass_duplicateFound_ = true;
                        }
                    }
                }
                if (CachedJSClass_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    RequireObjectCoercibleNode.doCachedJSClass(arg0Value, this.cachedJSClass_cachedClass_);
                    return;
                }
            }
            if ((JSGuards.isJSObject(arg0Value))) {
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCachedJSClass(Object, Class<>) */;
                state_0 = state_0 & 0xfffffeff /* remove-state_0 doCachedJSClass(Object, Class<>) */;
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doJSObject(Object) */;
                lock.unlock();
                hasLock = false;
                RequireObjectCoercibleNode.doJSObject(arg0Value);
                return;
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doForeignObject(Object, InteropLibrary) */) {
                int count10_ = 0;
                ForeignObject0Data s10_ = this.foreignObject0_cache;
                if ((state_0 & 0b10000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                    while (s10_ != null) {
                        if ((s10_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                            break;
                        }
                        s10_ = s10_.next_;
                        count10_++;
                    }
                }
                if (s10_ == null) {
                    if ((JSGuards.isForeignObject(arg0Value)) && count10_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s10_.interop_.accepts(arg0Value));
                        s10_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                        s10_.interop_ = s10_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        MemoryFence.storeStore();
                        this.foreignObject0_cache = s10_;
                        this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doForeignObject(Object, InteropLibrary) */;
                    }
                }
                if (s10_ != null) {
                    lock.unlock();
                    hasLock = false;
                    doForeignObject(arg0Value, s10_.interop_);
                    return;
                }
            }
            {
                InteropLibrary foreignObject1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(arg0Value))) {
                            foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            this.exclude_ = exclude = exclude | 0b10 /* add-exclude doForeignObject(Object, InteropLibrary) */;
                            this.foreignObject0_cache = null;
                            state_0 = state_0 & 0xfffffbff /* remove-state_0 doForeignObject(Object, InteropLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doForeignObject(Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            doForeignObject(arg0Value, foreignObject1_interop__);
                            return;
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isNullOrUndefined(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doNullOrUndefined(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    doNullOrUndefined(arg0Value_);
                    return;
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
                ForeignObject0Data s10_ = this.foreignObject0_cache;
                if ((s10_ == null || s10_.next_ == null)) {
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
        s[0] = "doCharSequence";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doCharSequence(CharSequence) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBoolean(boolean) */) {
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
        s[0] = "doCachedJSClass";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doCachedJSClass(Object, Class<>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cachedJSClass_cachedClass_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doCachedJSClass(Object, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s10_ = this.foreignObject0_cache;
            while (s10_ != null) {
                cached.add(Arrays.asList(s10_.interop_));
                s10_ = s10_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doNullOrUndefined";
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doNullOrUndefined(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        return Provider.create(data);
    }

    public static RequireObjectCoercibleNode create() {
        return new RequireObjectCoercibleNodeGen();
    }

    @GeneratedBy(RequireObjectCoercibleNode.class)
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
    @GeneratedBy(RequireObjectCoercibleWrapperNode.class)
    public static final class RequireObjectCoercibleWrapperNodeGen extends RequireObjectCoercibleWrapperNode implements Introspection.Provider {

        private RequireObjectCoercibleWrapperNodeGen(JavaScriptNode operand) {
            super(operand);
        }

        @Override
        public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
            return doDefault(operandNodeValue);
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object operandNodeValue_ = super.operandNode.execute(frameValue);
            return doDefault(operandNodeValue_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "doDefault";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static RequireObjectCoercibleWrapperNode create(JavaScriptNode operand) {
            return new RequireObjectCoercibleWrapperNodeGen(operand);
        }

    }
}
