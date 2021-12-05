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

@GeneratedBy(JSToObjectNode.class)
@SuppressWarnings("unused")
public final class JSToObjectNodeGen extends JSToObjectNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private Class<?> jSObjectCached_cachedClass_;
    @Child private ForeignObjectAllowed0Data foreignObjectAllowed0_cache;
    @Child private JSToObjectNode foreignObjectAllowed1_toObjectNode_;

    private JSToObjectNodeGen(JSContext context, boolean checkForNullOrUndefined, boolean fromWith, boolean allowForeign) {
        super(context, checkForNullOrUndefined, fromWith, allowForeign);
    }

    @ExplodeLoop
    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return doBoolean(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doJSLazyString(JSLazyString) */ && arg0Value instanceof JSLazyString) {
            JSLazyString arg0Value_ = (JSLazyString) arg0Value;
            return doJSLazyString(arg0Value_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doString(String) */ && JSTypesGen.isImplicitString((state_0 & 0x70000) >>> 16 /* extract-implicit-state_0 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state_0 & 0x70000) >>> 16 /* extract-implicit-state_0 0:String */, arg0Value);
            return doString(arg0Value_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return doInt(arg0Value_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x780000) >>> 19 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0x780000) >>> 19 /* extract-implicit-state_0 0:double */, arg0Value);
            return doDouble(arg0Value_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doNumber(Object) */) {
            if ((JSGuards.isJavaNumber(arg0Value))) {
                return doNumber(arg0Value);
            }
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state_0 & 0b11100000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) || doJSObjectNoCheck(Object) || doJSObjectCheck(Object) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
                assert (this.jSObjectCached_cachedClass_ != null);
                if ((this.jSObjectCached_cachedClass_.isInstance(arg0Value))) {
                    return JSToObjectNode.doJSObjectCached(arg0Value, this.jSObjectCached_cachedClass_);
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSObjectNoCheck(Object) */) {
                assert (!(isCheckForNullOrUndefined()));
                if ((JSGuards.isJSDynamicObject(arg0Value))) {
                    return doJSObjectNoCheck(arg0Value);
                }
            }
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doJSObjectCheck(Object) */) {
                assert (isCheckForNullOrUndefined());
                if ((JSGuards.isJSObject(arg0Value))) {
                    return doJSObjectCheck(arg0Value);
                }
            }
        }
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doNullOrUndefined(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            assert (isCheckForNullOrUndefined());
            if ((JSGuards.isNullOrUndefined(arg0Value_))) {
                return doNullOrUndefined(arg0Value_);
            }
        }
        if ((state_0 & 0b1111000000000000) != 0 /* is-state_0 doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) || doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) || doForeignObjectDisallowed(Object) || doJavaGeneric(Object) */) {
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) */) {
                ForeignObjectAllowed0Data s12_ = this.foreignObjectAllowed0_cache;
                while (s12_ != null) {
                    if ((s12_.interop_.accepts(arg0Value))) {
                        assert (isAllowForeign());
                        if ((JSGuards.isForeignObject(arg0Value))) {
                            return doForeignObjectAllowed(arg0Value, s12_.toObjectNode_, s12_.interop_);
                        }
                    }
                    s12_ = s12_.next_;
                }
            }
            if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) */) {
                assert (isAllowForeign());
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return this.foreignObjectAllowed1Boundary(state_0, arg0Value);
                }
            }
            if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doForeignObjectDisallowed(Object) */) {
                assert (!(isAllowForeign()));
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return doForeignObjectDisallowed(arg0Value);
                }
            }
            if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doJavaGeneric(Object) */) {
                if ((!(JSGuards.isBoolean(arg0Value))) && (!(JSGuards.isNumber(arg0Value))) && (!(JSGuards.isString(arg0Value))) && (!(JSGuards.isSymbol(arg0Value))) && (!(JSGuards.isJSObject(arg0Value))) && (!(JSGuards.isForeignObject(arg0Value)))) {
                    return doJavaGeneric(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object foreignObjectAllowed1Boundary(int state_0, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObjectAllowed1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return doForeignObjectAllowed(arg0Value, this.foreignObjectAllowed1_toObjectNode_, foreignObjectAllowed1_interop__);
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
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return doBoolean(arg0Value_);
            }
            if (arg0Value instanceof JSLazyString) {
                JSLazyString arg0Value_ = (JSLazyString) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doJSLazyString(JSLazyString) */;
                lock.unlock();
                hasLock = false;
                return doJSLazyString(arg0Value_);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    state_0 = (state_0 | (stringCast0 << 16) /* set-implicit-state_0 0:String */);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_);
                }
            }
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doInt(int) */;
                lock.unlock();
                hasLock = false;
                return doInt(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state_0 = (state_0 | (doubleCast0 << 19) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(arg0Value_);
                }
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(arg0Value_);
            }
            if ((JSGuards.isJavaNumber(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doNumber(Object) */;
                lock.unlock();
                hasLock = false;
                return doNumber(arg0Value);
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(arg0Value_);
            }
            if (((exclude & 0b1)) == 0 /* is-not-exclude doJSObjectCached(Object, Class<>) */) {
                boolean JSObjectCached_duplicateFound_ = false;
                if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
                    assert (this.jSObjectCached_cachedClass_ != null);
                    if ((this.jSObjectCached_cachedClass_.isInstance(arg0Value))) {
                        JSObjectCached_duplicateFound_ = true;
                    }
                }
                if (!JSObjectCached_duplicateFound_) {
                    {
                        Class<?> jSObjectCached_cachedClass__ = (getClassIfObject(arg0Value));
                        if ((jSObjectCached_cachedClass__ != null) && (jSObjectCached_cachedClass__.isInstance(arg0Value)) && ((state_0 & 0b100000000)) == 0 /* is-not-state_0 doJSObjectCached(Object, Class<>) */) {
                            this.jSObjectCached_cachedClass_ = jSObjectCached_cachedClass__;
                            this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doJSObjectCached(Object, Class<>) */;
                            JSObjectCached_duplicateFound_ = true;
                        }
                    }
                }
                if (JSObjectCached_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return JSToObjectNode.doJSObjectCached(arg0Value, this.jSObjectCached_cachedClass_);
                }
            }
            if ((!(isCheckForNullOrUndefined())) && (JSGuards.isJSDynamicObject(arg0Value))) {
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doJSObjectCached(Object, Class<>) */;
                state_0 = state_0 & 0xfffffeff /* remove-state_0 doJSObjectCached(Object, Class<>) */;
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doJSObjectNoCheck(Object) */;
                lock.unlock();
                hasLock = false;
                return doJSObjectNoCheck(arg0Value);
            }
            if ((isCheckForNullOrUndefined()) && (JSGuards.isJSObject(arg0Value))) {
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doJSObjectCached(Object, Class<>) */;
                state_0 = state_0 & 0xfffffeff /* remove-state_0 doJSObjectCached(Object, Class<>) */;
                this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doJSObjectCheck(Object) */;
                lock.unlock();
                hasLock = false;
                return doJSObjectCheck(arg0Value);
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((isCheckForNullOrUndefined()) && (JSGuards.isNullOrUndefined(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doNullOrUndefined(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doNullOrUndefined(arg0Value_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) */) {
                int count12_ = 0;
                ForeignObjectAllowed0Data s12_ = this.foreignObjectAllowed0_cache;
                if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) */) {
                    while (s12_ != null) {
                        if ((s12_.interop_.accepts(arg0Value))) {
                            assert (isAllowForeign());
                            if ((JSGuards.isForeignObject(arg0Value))) {
                                break;
                            }
                        }
                        s12_ = s12_.next_;
                        count12_++;
                    }
                }
                if (s12_ == null) {
                    if ((isAllowForeign()) && (JSGuards.isForeignObject(arg0Value)) && count12_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s12_.interop_.accepts(arg0Value));
                        s12_ = super.insert(new ForeignObjectAllowed0Data(foreignObjectAllowed0_cache));
                        s12_.toObjectNode_ = s12_.insertAccessor((JSToObjectNode.createToObject(context, checkForNullOrUndefined, fromWith, allowForeign)));
                        s12_.interop_ = s12_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        MemoryFence.storeStore();
                        this.foreignObjectAllowed0_cache = s12_;
                        this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) */;
                    }
                }
                if (s12_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doForeignObjectAllowed(arg0Value, s12_.toObjectNode_, s12_.interop_);
                }
            }
            {
                InteropLibrary foreignObjectAllowed1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((isAllowForeign()) && (JSGuards.isForeignObject(arg0Value))) {
                            this.foreignObjectAllowed1_toObjectNode_ = super.insert((JSToObjectNode.createToObject(context, checkForNullOrUndefined, fromWith, allowForeign)));
                            foreignObjectAllowed1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            this.exclude_ = exclude = exclude | 0b10 /* add-exclude doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) */;
                            this.foreignObjectAllowed0_cache = null;
                            state_0 = state_0 & 0xffffefff /* remove-state_0 doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return doForeignObjectAllowed(arg0Value, this.foreignObjectAllowed1_toObjectNode_, foreignObjectAllowed1_interop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if ((!(isAllowForeign())) && (JSGuards.isForeignObject(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b100000000000000 /* add-state_0 doForeignObjectDisallowed(Object) */;
                lock.unlock();
                hasLock = false;
                return doForeignObjectDisallowed(arg0Value);
            }
            if ((!(JSGuards.isBoolean(arg0Value))) && (!(JSGuards.isNumber(arg0Value))) && (!(JSGuards.isString(arg0Value))) && (!(JSGuards.isSymbol(arg0Value))) && (!(JSGuards.isJSObject(arg0Value))) && (!(JSGuards.isForeignObject(arg0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b1000000000000000 /* add-state_0 doJavaGeneric(Object) */;
                lock.unlock();
                hasLock = false;
                return doJavaGeneric(arg0Value);
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
        if ((state_0 & 0b1111111111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111111111111111) & ((state_0 & 0b1111111111111111) - 1)) == 0 /* is-single-state_0  */) {
                ForeignObjectAllowed0Data s12_ = this.foreignObjectAllowed0_cache;
                if ((s12_ == null || s12_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
        s[0] = "doBoolean";
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doJSLazyString";
        if ((state_0 & 0b10) != 0 /* is-state_0 doJSLazyString(JSLazyString) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b100) != 0 /* is-state_0 doString(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doNumber";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doNumber(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doJSObjectCached";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSObjectCached_cachedClass_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doJSObjectCached(Object, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doJSObjectNoCheck";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSObjectNoCheck(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doJSObjectCheck";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doJSObjectCheck(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doNullOrUndefined";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doNullOrUndefined(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doForeignObjectAllowed";
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObjectAllowed0Data s12_ = this.foreignObjectAllowed0_cache;
            while (s12_ != null) {
                cached.add(Arrays.asList(s12_.toObjectNode_, s12_.interop_));
                s12_ = s12_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doForeignObjectAllowed";
        if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doForeignObjectAllowed(Object, JSToObjectNode, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.foreignObjectAllowed1_toObjectNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        s = new Object[3];
        s[0] = "doForeignObjectDisallowed";
        if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doForeignObjectDisallowed(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[15] = s;
        s = new Object[3];
        s[0] = "doJavaGeneric";
        if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doJavaGeneric(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[16] = s;
        return Provider.create(data);
    }

    public static JSToObjectNode create(JSContext context, boolean checkForNullOrUndefined, boolean fromWith, boolean allowForeign) {
        return new JSToObjectNodeGen(context, checkForNullOrUndefined, fromWith, allowForeign);
    }

    @GeneratedBy(JSToObjectNode.class)
    private static final class ForeignObjectAllowed0Data extends Node {

        @Child ForeignObjectAllowed0Data next_;
        @Child JSToObjectNode toObjectNode_;
        @Child InteropLibrary interop_;

        ForeignObjectAllowed0Data(ForeignObjectAllowed0Data next_) {
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
    @GeneratedBy(JSToObjectWrapperNode.class)
    public static final class JSToObjectWrapperNodeGen extends JSToObjectWrapperNode implements Introspection.Provider {

        private JSToObjectWrapperNodeGen(JavaScriptNode operand, JSToObjectNode toObjectNode) {
            super(operand, toObjectNode);
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
        public DynamicObject executeDynamicObject(Object operandNodeValue) {
            return (DynamicObject) execute(null, operandNodeValue);
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

        public static JSToObjectWrapperNode create(JavaScriptNode operand, JSToObjectNode toObjectNode) {
            return new JSToObjectWrapperNodeGen(operand, toObjectNode);
        }

    }
}
