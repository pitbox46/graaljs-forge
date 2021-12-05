// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.access.JSHasPropertyNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSArrayFirstElementIndexNode.class)
public final class JSArrayFirstElementIndexNodeGen extends JSArrayFirstElementIndexNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private WithoutHolesCachedData withoutHolesCached_cache;
    @Child private WithHolesCachedData withHolesCached_cache;
    @Child private WithHolesUncachedData withHolesUncached_cache;
    @Child private JSHasPropertyNode firstObjectViaEnumeration_hasPropertyNode_;
    @Child private JSHasPropertyNode firstObjectViaFullEnumeration_hasPropertyNode_;
    @Child private JSHasPropertyNode object_hasPropertyNode_;

    private JSArrayFirstElementIndexNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    public long executeLong(Object arg0Value, long arg1Value, boolean arg2Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) || doWithoutHolesUncached(DynamicObject, long, boolean) || doWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) || doWithHolesUncached(DynamicObject, long, boolean, JSArrayNextElementIndexNode, ConditionProfile, ValueProfile) || firstObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) || firstObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) || doObject(Object, long, boolean, JSHasPropertyNode) */) {
            if ((state_0 & 0b111111) != 0 /* is-state_0 doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) || doWithoutHolesUncached(DynamicObject, long, boolean) || doWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) || doWithHolesUncached(DynamicObject, long, boolean, JSArrayNextElementIndexNode, ConditionProfile, ValueProfile) || firstObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) || firstObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((state_0 & 0b1) != 0 /* is-state_0 doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */ && (arg2Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    WithoutHolesCachedData s0_ = this.withoutHolesCached_cache;
                    while (s0_ != null) {
                        if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == s0_.cachedArrayType_) && (!(s0_.cachedArrayType_.hasHoles(arg0Value_)))) {
                            return doWithoutHolesCached(arg0Value_, arg1Value, arg2Value, s0_.cachedArrayType_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doWithoutHolesUncached(DynamicObject, long, boolean) */) {
                    if ((arg2Value) && (!(hasPrototypeElements(arg0Value_))) && (!(JSArrayElementIndexNode.hasHoles(arg0Value_)))) {
                        return doWithoutHolesUncached(arg0Value_, arg1Value, arg2Value);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */ && (arg2Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    WithHolesCachedData s2_ = this.withHolesCached_cache;
                    while (s2_ != null) {
                        if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == s2_.cachedArrayType_) && (s2_.cachedArrayType_.hasHoles(arg0Value_))) {
                            return doWithHolesCached(arg0Value_, arg1Value, arg2Value, s2_.cachedArrayType_, s2_.nextElementIndexNode_, s2_.isZero_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doWithHolesUncached(DynamicObject, long, boolean, JSArrayNextElementIndexNode, ConditionProfile, ValueProfile) */) {
                    WithHolesUncachedData s3_ = this.withHolesUncached_cache;
                    if (s3_ != null) {
                        if ((arg2Value) && (hasPrototypeElements(arg0Value_) || JSArrayElementIndexNode.hasHoles(arg0Value_))) {
                            return doWithHolesUncached(arg0Value_, arg1Value, arg2Value, s3_.nextElementIndexNode_, s3_.isZero_, s3_.arrayTypeProfile_);
                        }
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 firstObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */) {
                    if ((!(arg2Value)) && (isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg1Value))) {
                        return firstObjectViaEnumeration(arg0Value_, arg1Value, arg2Value, this.firstObjectViaEnumeration_hasPropertyNode_);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 firstObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */) {
                    if ((!(arg2Value)) && (!(isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg1Value))) && (JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value_, arg1Value))) {
                        return firstObjectViaFullEnumeration(arg0Value_, arg1Value, arg2Value, this.firstObjectViaFullEnumeration_hasPropertyNode_);
                    }
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doObject(Object, long, boolean, JSHasPropertyNode) */) {
                if ((!(arg2Value)) && (!(JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value, arg1Value)))) {
                    return doObject(arg0Value, arg1Value, arg2Value, this.object_hasPropertyNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private long executeAndSpecialize(Object arg0Value, long arg1Value, boolean arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if (((exclude & 0b1)) == 0 /* is-not-exclude doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */ && (arg2Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    int count0_ = 0;
                    WithoutHolesCachedData s0_ = this.withoutHolesCached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */) {
                        while (s0_ != null) {
                            if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == s0_.cachedArrayType_) && (!(s0_.cachedArrayType_.hasHoles(arg0Value_)))) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        {
                            ScriptArray cachedArrayType__ = (JSArrayElementIndexNode.getArrayTypeIfArray(arg0Value_, arg2Value));
                            if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == cachedArrayType__) && (!(cachedArrayType__.hasHoles(arg0Value_))) && count0_ < (JSArrayElementIndexNode.MAX_CACHED_ARRAY_TYPES)) {
                                s0_ = new WithoutHolesCachedData(withoutHolesCached_cache);
                                s0_.cachedArrayType_ = cachedArrayType__;
                                MemoryFence.storeStore();
                                this.withoutHolesCached_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */;
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doWithoutHolesCached(arg0Value_, arg1Value, arg2Value, s0_.cachedArrayType_);
                    }
                }
                if ((arg2Value) && (!(hasPrototypeElements(arg0Value_))) && (!(JSArrayElementIndexNode.hasHoles(arg0Value_)))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */;
                    this.withoutHolesCached_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doWithoutHolesUncached(DynamicObject, long, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doWithoutHolesUncached(arg0Value_, arg1Value, arg2Value);
                }
                if (((exclude & 0b10)) == 0 /* is-not-exclude doWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */ && (arg2Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    int count2_ = 0;
                    WithHolesCachedData s2_ = this.withHolesCached_cache;
                    if ((state_0 & 0b100) != 0 /* is-state_0 doWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */) {
                        while (s2_ != null) {
                            if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == s2_.cachedArrayType_) && (s2_.cachedArrayType_.hasHoles(arg0Value_))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        {
                            ScriptArray cachedArrayType__1 = (JSArrayElementIndexNode.getArrayTypeIfArray(arg0Value_, arg2Value));
                            if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == cachedArrayType__1) && (cachedArrayType__1.hasHoles(arg0Value_)) && count2_ < (JSArrayElementIndexNode.MAX_CACHED_ARRAY_TYPES)) {
                                s2_ = super.insert(new WithHolesCachedData(withHolesCached_cache));
                                s2_.cachedArrayType_ = cachedArrayType__1;
                                s2_.nextElementIndexNode_ = s2_.insertAccessor((JSArrayNextElementIndexNode.create(context)));
                                s2_.isZero_ = (ConditionProfile.createBinaryProfile());
                                MemoryFence.storeStore();
                                this.withHolesCached_cache = s2_;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */;
                            }
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doWithHolesCached(arg0Value_, arg1Value, arg2Value, s2_.cachedArrayType_, s2_.nextElementIndexNode_, s2_.isZero_);
                    }
                }
                if ((arg2Value) && (hasPrototypeElements(arg0Value_) || JSArrayElementIndexNode.hasHoles(arg0Value_))) {
                    WithHolesUncachedData s3_ = super.insert(new WithHolesUncachedData());
                    s3_.nextElementIndexNode_ = s3_.insertAccessor((JSArrayNextElementIndexNode.create(context)));
                    s3_.isZero_ = (ConditionProfile.createBinaryProfile());
                    s3_.arrayTypeProfile_ = (ValueProfile.createClassProfile());
                    MemoryFence.storeStore();
                    this.withHolesUncached_cache = s3_;
                    this.exclude_ = exclude = exclude | 0b10 /* add-exclude doWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */;
                    this.withHolesCached_cache = null;
                    state_0 = state_0 & 0xfffffffb /* remove-state_0 doWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doWithHolesUncached(DynamicObject, long, boolean, JSArrayNextElementIndexNode, ConditionProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doWithHolesUncached(arg0Value_, arg1Value, arg2Value, s3_.nextElementIndexNode_, s3_.isZero_, s3_.arrayTypeProfile_);
                }
                if ((!(arg2Value)) && (isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg1Value))) {
                    this.firstObjectViaEnumeration_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 firstObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return firstObjectViaEnumeration(arg0Value_, arg1Value, arg2Value, this.firstObjectViaEnumeration_hasPropertyNode_);
                }
                if ((!(arg2Value)) && (!(isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg1Value))) && (JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value_, arg1Value))) {
                    this.firstObjectViaFullEnumeration_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 firstObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return firstObjectViaFullEnumeration(arg0Value_, arg1Value, arg2Value, this.firstObjectViaFullEnumeration_hasPropertyNode_);
                }
            }
            if ((!(arg2Value)) && (!(JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value, arg1Value)))) {
                this.object_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doObject(Object, long, boolean, JSHasPropertyNode) */;
                lock.unlock();
                hasLock = false;
                return doObject(arg0Value, arg1Value, arg2Value, this.object_hasPropertyNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if (state_0 == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                WithoutHolesCachedData s0_ = this.withoutHolesCached_cache;
                WithHolesCachedData s2_ = this.withHolesCached_cache;
                if ((s0_ == null || s0_.next_ == null) && (s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[8];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doWithoutHolesCached";
        if ((state_0 & 0b1) != 0 /* is-state_0 doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            WithoutHolesCachedData s0_ = this.withoutHolesCached_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedArrayType_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doWithoutHolesUncached";
        if ((state_0 & 0b10) != 0 /* is-state_0 doWithoutHolesUncached(DynamicObject, long, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doWithHolesCached";
        if ((state_0 & 0b100) != 0 /* is-state_0 doWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            WithHolesCachedData s2_ = this.withHolesCached_cache;
            while (s2_ != null) {
                cached.add(Arrays.asList(s2_.cachedArrayType_, s2_.nextElementIndexNode_, s2_.isZero_));
                s2_ = s2_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doWithHolesUncached";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doWithHolesUncached(DynamicObject, long, boolean, JSArrayNextElementIndexNode, ConditionProfile, ValueProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            WithHolesUncachedData s3_ = this.withHolesUncached_cache;
            if (s3_ != null) {
                cached.add(Arrays.asList(s3_.nextElementIndexNode_, s3_.isZero_, s3_.arrayTypeProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "firstObjectViaEnumeration";
        if ((state_0 & 0b10000) != 0 /* is-state_0 firstObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.firstObjectViaEnumeration_hasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "firstObjectViaFullEnumeration";
        if ((state_0 & 0b100000) != 0 /* is-state_0 firstObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.firstObjectViaFullEnumeration_hasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doObject(Object, long, boolean, JSHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.object_hasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static JSArrayFirstElementIndexNode create(JSContext context) {
        return new JSArrayFirstElementIndexNodeGen(context);
    }

    @GeneratedBy(JSArrayFirstElementIndexNode.class)
    private static final class WithoutHolesCachedData {

        @CompilationFinal WithoutHolesCachedData next_;
        @CompilationFinal ScriptArray cachedArrayType_;

        WithoutHolesCachedData(WithoutHolesCachedData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(JSArrayFirstElementIndexNode.class)
    private static final class WithHolesCachedData extends Node {

        @Child WithHolesCachedData next_;
        @CompilationFinal ScriptArray cachedArrayType_;
        @Child JSArrayNextElementIndexNode nextElementIndexNode_;
        @CompilationFinal ConditionProfile isZero_;

        WithHolesCachedData(WithHolesCachedData next_) {
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
    @GeneratedBy(JSArrayFirstElementIndexNode.class)
    private static final class WithHolesUncachedData extends Node {

        @Child JSArrayNextElementIndexNode nextElementIndexNode_;
        @CompilationFinal ConditionProfile isZero_;
        @CompilationFinal ValueProfile arrayTypeProfile_;

        WithHolesUncachedData() {
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
