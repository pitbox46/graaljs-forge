// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.access.FrequencyBasedPolymorphicAccessNode.FrequencyBasedPropertySetNode;
import com.oracle.truffle.js.nodes.cast.ToArrayIndexNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(CachedSetPropertyNode.class)
final class CachedSetPropertyNodeGen extends CachedSetPropertyNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private CachedKeyData cachedKey_cache;
    @CompilationFinal private JSClassProfile intIndex_jsclassProfile_;
    @Child private ArrayIndexData arrayIndex_cache;
    @Child private JSProxyPropertySetNode proxy_proxySet_;
    @Child private GenericData generic_cache;

    private CachedSetPropertyNodeGen(JSContext context, boolean strict, boolean setOwn, boolean superProperty) {
        super(context, strict, setOwn, superProperty);
    }

    @ExplodeLoop
    @Override
    public void execute(DynamicObject arg0Value, Object arg1Value, Object arg2Value, Object arg3Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) || doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) || doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) || doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) || doGeneric(DynamicObject, Object, Object, Object, ToArrayIndexNode, ConditionProfile, JSClassProfile, ConditionProfile, FrequencyBasedPropertySetNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) */) {
                CachedKeyData s0_ = this.cachedKey_cache;
                while (s0_ != null) {
                    assert (s0_.cachedKey_ != null);
                    assert (!(JSRuntime.isArrayIndex(s0_.cachedKey_)));
                    if ((JSRuntime.propertyKeyEquals(s0_.cachedKey_, arg1Value))) {
                        doCachedKey(arg0Value, arg1Value, arg2Value, arg3Value, s0_.cachedKey_, s0_.propertyNode_);
                        return;
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */ && arg1Value instanceof Integer) {
                int arg1Value_ = (int) arg1Value;
                if ((JSRuntime.isArrayIndex(arg1Value_)) && (!(JSGuards.isJSProxy(arg0Value)))) {
                    doIntIndex(arg0Value, arg1Value_, arg2Value, arg3Value, this.intIndex_jsclassProfile_);
                    return;
                }
            }
            if ((state_0 & 0b11100) != 0 /* is-state_0 doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) || doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) || doGeneric(DynamicObject, Object, Object, Object, ToArrayIndexNode, ConditionProfile, JSClassProfile, ConditionProfile, FrequencyBasedPropertySetNode) */) {
                if ((state_0 & 0b100) != 0 /* is-state_0 doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) */ && (!(JSGuards.isJSProxy(arg0Value)))) {
                    ArrayIndexData s2_ = this.arrayIndex_cache;
                    while (s2_ != null) {
                        {
                            Object maybeIndex__ = (s2_.toArrayIndexNode_.execute(arg1Value));
                            if ((s2_.toArrayIndexNode_.isResultArrayIndex(maybeIndex__))) {
                                doArrayIndex(arg0Value, arg1Value, arg2Value, arg3Value, s2_.toArrayIndexNode_, maybeIndex__, s2_.jsclassProfile_);
                                return;
                            }
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */) {
                    if ((JSGuards.isJSProxy(arg0Value))) {
                        doProxy(arg0Value, arg1Value, arg2Value, arg3Value, this.proxy_proxySet_);
                        return;
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doGeneric(DynamicObject, Object, Object, Object, ToArrayIndexNode, ConditionProfile, JSClassProfile, ConditionProfile, FrequencyBasedPropertySetNode) */) {
                    GenericData s4_ = this.generic_cache;
                    if (s4_ != null) {
                        doGeneric(arg0Value, arg1Value, arg2Value, arg3Value, s4_.toArrayIndexNode_, s4_.getType_, s4_.jsclassProfile_, s4_.highFrequency_, s4_.hotKey_);
                        return;
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
        return;
    }

    private void executeAndSpecialize(DynamicObject arg0Value, Object arg1Value, Object arg2Value, Object arg3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            int oldState_0 = state_0;
            try {
                if (((exclude & 0b1)) == 0 /* is-not-exclude doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) */) {
                    int count0_ = 0;
                    CachedKeyData s0_ = this.cachedKey_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) */) {
                        while (s0_ != null) {
                            assert (s0_.cachedKey_ != null);
                            assert (!(JSRuntime.isArrayIndex(s0_.cachedKey_)));
                            if ((JSRuntime.propertyKeyEquals(s0_.cachedKey_, arg1Value))) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        {
                            Object cachedKey__ = (CachedGetPropertyNode.cachedPropertyKey(arg1Value));
                            if ((cachedKey__ != null) && (!(JSRuntime.isArrayIndex(cachedKey__))) && (JSRuntime.propertyKeyEquals(cachedKey__, arg1Value)) && count0_ < (CachedSetPropertyNode.MAX_DEPTH)) {
                                s0_ = super.insert(new CachedKeyData(cachedKey_cache));
                                s0_.cachedKey_ = cachedKey__;
                                s0_.propertyNode_ = s0_.insertAccessor((createSet(cachedKey__)));
                                MemoryFence.storeStore();
                                this.cachedKey_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) */;
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        doCachedKey(arg0Value, arg1Value, arg2Value, arg3Value, s0_.cachedKey_, s0_.propertyNode_);
                        return;
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-exclude doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */ && arg1Value instanceof Integer) {
                    int arg1Value_ = (int) arg1Value;
                    if ((JSRuntime.isArrayIndex(arg1Value_)) && (!(JSGuards.isJSProxy(arg0Value)))) {
                        this.intIndex_jsclassProfile_ = (JSClassProfile.create());
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */;
                        lock.unlock();
                        hasLock = false;
                        doIntIndex(arg0Value, arg1Value_, arg2Value, arg3Value, this.intIndex_jsclassProfile_);
                        return;
                    }
                }
                {
                    Object maybeIndex__ = null;
                    if (((exclude & 0b100)) == 0 /* is-not-exclude doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) */ && (!(JSGuards.isJSProxy(arg0Value)))) {
                        int count2_ = 0;
                        ArrayIndexData s2_ = this.arrayIndex_cache;
                        if ((state_0 & 0b100) != 0 /* is-state_0 doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) */) {
                            while (s2_ != null) {
                                {
                                    maybeIndex__ = (s2_.toArrayIndexNode_.execute(arg1Value));
                                    if ((s2_.toArrayIndexNode_.isResultArrayIndex(maybeIndex__))) {
                                        break;
                                    }
                                }
                                s2_ = s2_.next_;
                                count2_++;
                            }
                        }
                        if (s2_ == null) {
                            {
                                ToArrayIndexNode toArrayIndexNode__ = super.insert((ToArrayIndexNode.createNoToPropertyKey()));
                                maybeIndex__ = (toArrayIndexNode__.execute(arg1Value));
                                if ((toArrayIndexNode__.isResultArrayIndex(maybeIndex__)) && count2_ < (3)) {
                                    s2_ = super.insert(new ArrayIndexData(arrayIndex_cache));
                                    s2_.toArrayIndexNode_ = s2_.insertAccessor(toArrayIndexNode__);
                                    s2_.jsclassProfile_ = (JSClassProfile.create());
                                    MemoryFence.storeStore();
                                    this.arrayIndex_cache = s2_;
                                    this.exclude_ = exclude = exclude | 0b10 /* add-exclude doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */;
                                    state_0 = state_0 & 0xfffffffd /* remove-state_0 doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */;
                                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) */;
                                }
                            }
                        }
                        if (s2_ != null) {
                            lock.unlock();
                            hasLock = false;
                            doArrayIndex(arg0Value, arg1Value, arg2Value, arg3Value, s2_.toArrayIndexNode_, maybeIndex__, s2_.jsclassProfile_);
                            return;
                        }
                    }
                }
                if (((exclude & 0b1000)) == 0 /* is-not-exclude doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */) {
                    if ((JSGuards.isJSProxy(arg0Value))) {
                        this.proxy_proxySet_ = super.insert((JSProxyPropertySetNode.create(context, strict)));
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */;
                        lock.unlock();
                        hasLock = false;
                        doProxy(arg0Value, arg1Value, arg2Value, arg3Value, this.proxy_proxySet_);
                        return;
                    }
                }
                GenericData s4_ = super.insert(new GenericData());
                s4_.toArrayIndexNode_ = s4_.insertAccessor((ToArrayIndexNode.create()));
                s4_.getType_ = (ConditionProfile.createBinaryProfile());
                s4_.jsclassProfile_ = (JSClassProfile.create());
                s4_.highFrequency_ = (ConditionProfile.createBinaryProfile());
                s4_.hotKey_ = s4_.insertAccessor((FrequencyBasedPolymorphicAccessNode.createFrequencyBasedPropertySet(context, setOwn, strict, superProperty)));
                MemoryFence.storeStore();
                this.generic_cache = s4_;
                this.exclude_ = exclude = exclude | 0b1111 /* add-exclude doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode), doIntIndex(DynamicObject, int, Object, Object, JSClassProfile), doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile), doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */;
                this.cachedKey_cache = null;
                this.arrayIndex_cache = null;
                state_0 = state_0 & 0xfffffff0 /* remove-state_0 doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode), doIntIndex(DynamicObject, int, Object, Object, JSClassProfile), doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile), doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doGeneric(DynamicObject, Object, Object, Object, ToArrayIndexNode, ConditionProfile, JSClassProfile, ConditionProfile, FrequencyBasedPropertySetNode) */;
                lock.unlock();
                hasLock = false;
                doGeneric(arg0Value, arg1Value, arg2Value, arg3Value, s4_.toArrayIndexNode_, s4_.getType_, s4_.jsclassProfile_, s4_.highFrequency_, s4_.hotKey_);
                return;
            } finally {
                if (oldState_0 != 0) {
                    checkForPolymorphicSpecialize(oldState_0);
                }
            }
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    private void checkForPolymorphicSpecialize(int oldState_0) {
        if (((oldState_0 & 0b10000) == 0 && (this.state_0_ & 0b10000) != 0)) {
            this.reportPolymorphicSpecialize();
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if (state_0 == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                CachedKeyData s0_ = this.cachedKey_cache;
                ArrayIndexData s2_ = this.arrayIndex_cache;
                if ((s0_ == null || s0_.next_ == null) && (s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doCachedKey";
        if ((state_0 & 0b1) != 0 /* is-state_0 doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedKeyData s0_ = this.cachedKey_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedKey_, s0_.propertyNode_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doIntIndex";
        if ((state_0 & 0b10) != 0 /* is-state_0 doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.intIndex_jsclassProfile_));
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doArrayIndex";
        if ((state_0 & 0b100) != 0 /* is-state_0 doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ArrayIndexData s2_ = this.arrayIndex_cache;
            while (s2_ != null) {
                cached.add(Arrays.asList(s2_.toArrayIndexNode_, s2_.jsclassProfile_));
                s2_ = s2_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b100) != 0 /* is-exclude doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doProxy";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.proxy_proxySet_));
            s[2] = cached;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doGeneric(DynamicObject, Object, Object, Object, ToArrayIndexNode, ConditionProfile, JSClassProfile, ConditionProfile, FrequencyBasedPropertySetNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s4_ = this.generic_cache;
            if (s4_ != null) {
                cached.add(Arrays.asList(s4_.toArrayIndexNode_, s4_.getType_, s4_.jsclassProfile_, s4_.highFrequency_, s4_.hotKey_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static CachedSetPropertyNode create(JSContext context, boolean strict, boolean setOwn, boolean superProperty) {
        return new CachedSetPropertyNodeGen(context, strict, setOwn, superProperty);
    }

    @GeneratedBy(CachedSetPropertyNode.class)
    private static final class CachedKeyData extends Node {

        @Child CachedKeyData next_;
        @CompilationFinal Object cachedKey_;
        @Child PropertySetNode propertyNode_;

        CachedKeyData(CachedKeyData next_) {
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
    @GeneratedBy(CachedSetPropertyNode.class)
    private static final class ArrayIndexData extends Node {

        @Child ArrayIndexData next_;
        @Child ToArrayIndexNode toArrayIndexNode_;
        @CompilationFinal JSClassProfile jsclassProfile_;

        ArrayIndexData(ArrayIndexData next_) {
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
    @GeneratedBy(CachedSetPropertyNode.class)
    private static final class GenericData extends Node {

        @Child ToArrayIndexNode toArrayIndexNode_;
        @CompilationFinal ConditionProfile getType_;
        @CompilationFinal JSClassProfile jsclassProfile_;
        @CompilationFinal ConditionProfile highFrequency_;
        @Child FrequencyBasedPropertySetNode hotKey_;

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
