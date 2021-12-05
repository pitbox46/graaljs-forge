// CheckStyle: start generated
package com.oracle.truffle.js.builtins.helper;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
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
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSCollectionsNormalizeNode.class)
@SuppressWarnings("unused")
public final class JSCollectionsNormalizeNodeGen extends JSCollectionsNormalizeNode implements Introspection.Provider {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile jSLazyString_flatten_;
    @Child private ForeignObject0Data foreignObject0_cache;
    @CompilationFinal private ConditionProfile foreignObject1_primitiveProfile_;
    @Child private JSCollectionsNormalizeNode foreignObject1_nestedNormalizeNode_;

    private JSCollectionsNormalizeNodeGen() {
    }

    @ExplodeLoop
    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return doInt(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000000000) >>> 10 /* extract-implicit-state_0 0:double */, arg0Value);
            return doDouble(arg0Value_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doJSLazyString(JSLazyString, ConditionProfile) */ && arg0Value instanceof JSLazyString) {
            JSLazyString arg0Value_ = (JSLazyString) arg0Value;
            return doJSLazyString(arg0Value_, this.jSLazyString_flatten_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doString(String) */ && JSTypesGen.isImplicitString((state_0 & 0x1c000) >>> 14 /* extract-implicit-state_0 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state_0 & 0x1c000) >>> 14 /* extract-implicit-state_0 0:String */, arg0Value);
            return doString(arg0Value_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return doBoolean(arg0Value_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doDynamicObject(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                return doDynamicObject(arg0Value_);
            }
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) || doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
                ForeignObject0Data s8_ = this.foreignObject0_cache;
                while (s8_ != null) {
                    if ((s8_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                        return doForeignObject(arg0Value, s8_.interop_, s8_.primitiveProfile_, s8_.nestedNormalizeNode_);
                    }
                    s8_ = s8_.next_;
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return this.foreignObject1Boundary(state_0, arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object foreignObject1Boundary(int state_0, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return doForeignObject(arg0Value, foreignObject1_interop__, this.foreignObject1_primitiveProfile_, this.foreignObject1_nestedNormalizeNode_);
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
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state_0 = (state_0 | (doubleCast0 << 10) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(arg0Value_);
                }
            }
            if (arg0Value instanceof JSLazyString) {
                JSLazyString arg0Value_ = (JSLazyString) arg0Value;
                this.jSLazyString_flatten_ = (ConditionProfile.createBinaryProfile());
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doJSLazyString(JSLazyString, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doJSLazyString(arg0Value_, this.jSLazyString_flatten_);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    state_0 = (state_0 | (stringCast0 << 14) /* set-implicit-state_0 0:String */);
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_);
                }
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return doBoolean(arg0Value_);
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doDynamicObject(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doDynamicObject(arg0Value_);
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
            if ((exclude) == 0 /* is-not-exclude doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
                int count8_ = 0;
                ForeignObject0Data s8_ = this.foreignObject0_cache;
                if ((state_0 & 0b100000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
                    while (s8_ != null) {
                        if ((s8_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                            break;
                        }
                        s8_ = s8_.next_;
                        count8_++;
                    }
                }
                if (s8_ == null) {
                    if ((JSGuards.isForeignObject(arg0Value)) && count8_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s8_.interop_.accepts(arg0Value));
                        s8_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                        s8_.interop_ = s8_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        s8_.primitiveProfile_ = (ConditionProfile.createBinaryProfile());
                        s8_.nestedNormalizeNode_ = s8_.insertAccessor((JSCollectionsNormalizeNode.create()));
                        MemoryFence.storeStore();
                        this.foreignObject0_cache = s8_;
                        this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */;
                    }
                }
                if (s8_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doForeignObject(arg0Value, s8_.interop_, s8_.primitiveProfile_, s8_.nestedNormalizeNode_);
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
                            this.foreignObject1_primitiveProfile_ = (ConditionProfile.createBinaryProfile());
                            this.foreignObject1_nestedNormalizeNode_ = super.insert((JSCollectionsNormalizeNode.create()));
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */;
                            this.foreignObject0_cache = null;
                            state_0 = state_0 & 0xfffffeff /* remove-state_0 doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */;
                            this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */;
                            lock.unlock();
                            hasLock = false;
                            return doForeignObject(arg0Value, foreignObject1_interop__, this.foreignObject1_primitiveProfile_, this.foreignObject1_nestedNormalizeNode_);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
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
        if ((state_0 & 0b1111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111111111) & ((state_0 & 0b1111111111) - 1)) == 0 /* is-single-state_0  */) {
                ForeignObject0Data s8_ = this.foreignObject0_cache;
                if ((s8_ == null || s8_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
        s[0] = "doInt";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doJSLazyString";
        if ((state_0 & 0b100) != 0 /* is-state_0 doJSLazyString(JSLazyString, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSLazyString_flatten_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doString(String) */) {
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
        s[0] = "doDynamicObject";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doDynamicObject(DynamicObject) */) {
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
        s[0] = "doForeignObject";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s8_ = this.foreignObject0_cache;
            while (s8_ != null) {
                cached.add(Arrays.asList(s8_.interop_, s8_.primitiveProfile_, s8_.nestedNormalizeNode_));
                s8_ = s8_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.foreignObject1_primitiveProfile_, this.foreignObject1_nestedNormalizeNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        return Provider.create(data);
    }

    public static JSCollectionsNormalizeNode create() {
        return new JSCollectionsNormalizeNodeGen();
    }

    public static JSCollectionsNormalizeNode getUncached() {
        return JSCollectionsNormalizeNodeGen.UNCACHED;
    }

    @GeneratedBy(JSCollectionsNormalizeNode.class)
    private static final class ForeignObject0Data extends Node {

        @Child ForeignObject0Data next_;
        @Child InteropLibrary interop_;
        @CompilationFinal ConditionProfile primitiveProfile_;
        @Child JSCollectionsNormalizeNode nestedNormalizeNode_;

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
    @GeneratedBy(JSCollectionsNormalizeNode.class)
    private static final class Uncached extends JSCollectionsNormalizeNode {

        @TruffleBoundary
        @Override
        public Object execute(Object arg0Value) {
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                return doInt(arg0Value_);
            }
            if (JSTypesGen.isImplicitDouble(arg0Value)) {
                double arg0Value_ = JSTypesGen.asImplicitDouble(arg0Value);
                return doDouble(arg0Value_);
            }
            if (arg0Value instanceof JSLazyString) {
                JSLazyString arg0Value_ = (JSLazyString) arg0Value;
                return doJSLazyString(arg0Value_, (ConditionProfile.getUncached()));
            }
            if (JSTypesGen.isImplicitString(arg0Value)) {
                String arg0Value_ = JSTypesGen.asImplicitString(arg0Value);
                return doString(arg0Value_);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                return doBoolean(arg0Value_);
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                    return doDynamicObject(arg0Value_);
                }
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                return doSymbol(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                return doBigInt(arg0Value_);
            }
            if ((JSGuards.isForeignObject(arg0Value))) {
                return doForeignObject(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)), (ConditionProfile.getUncached()), (JSCollectionsNormalizeNodeGen.getUncached()));
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
}
