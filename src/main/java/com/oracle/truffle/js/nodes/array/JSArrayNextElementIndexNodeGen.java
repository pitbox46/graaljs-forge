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

@GeneratedBy(JSArrayNextElementIndexNode.class)
public final class JSArrayNextElementIndexNodeGen extends JSArrayNextElementIndexNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private WithoutHolesCachedData withoutHolesCached_cache;
    @Child private NextWithHolesCachedData nextWithHolesCached_cache;
    @Child private NextWithHolesUncachedData nextWithHolesUncached_cache;
    @Child private JSHasPropertyNode nextObjectViaEnumeration_hasPropertyNode_;
    @Child private JSHasPropertyNode nextObjectViaFullEnumeration_hasPropertyNode_;
    @Child private JSHasPropertyNode nextObjectViaPolling_hasPropertyNode_;

    private JSArrayNextElementIndexNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    public long executeLong(Object arg0Value, long arg1Value, long arg2Value, boolean arg3Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doWithoutHolesCached(DynamicObject, long, long, boolean, ScriptArray) || doWithoutHolesUncached(DynamicObject, long, long, boolean) || nextWithHolesCached(DynamicObject, long, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) || nextWithHolesUncached(DynamicObject, long, long, boolean, JSArrayNextElementIndexNode, ConditionProfile, ValueProfile) || nextObjectViaEnumeration(DynamicObject, long, long, boolean, JSHasPropertyNode) || nextObjectViaFullEnumeration(DynamicObject, long, long, boolean, JSHasPropertyNode) || nextObjectViaPolling(Object, long, long, boolean, JSHasPropertyNode) */) {
            if ((state_0 & 0b111111) != 0 /* is-state_0 doWithoutHolesCached(DynamicObject, long, long, boolean, ScriptArray) || doWithoutHolesUncached(DynamicObject, long, long, boolean) || nextWithHolesCached(DynamicObject, long, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) || nextWithHolesUncached(DynamicObject, long, long, boolean, JSArrayNextElementIndexNode, ConditionProfile, ValueProfile) || nextObjectViaEnumeration(DynamicObject, long, long, boolean, JSHasPropertyNode) || nextObjectViaFullEnumeration(DynamicObject, long, long, boolean, JSHasPropertyNode) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((state_0 & 0b1) != 0 /* is-state_0 doWithoutHolesCached(DynamicObject, long, long, boolean, ScriptArray) */ && (arg3Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    WithoutHolesCachedData s0_ = this.withoutHolesCached_cache;
                    while (s0_ != null) {
                        if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == s0_.cachedArrayType_) && (!(s0_.cachedArrayType_.hasHoles(arg0Value_)))) {
                            return doWithoutHolesCached(arg0Value_, arg1Value, arg2Value, arg3Value, s0_.cachedArrayType_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doWithoutHolesUncached(DynamicObject, long, long, boolean) */) {
                    if ((arg3Value) && (!(hasPrototypeElements(arg0Value_))) && (!(JSArrayElementIndexNode.hasHoles(arg0Value_)))) {
                        return doWithoutHolesUncached(arg0Value_, arg1Value, arg2Value, arg3Value);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 nextWithHolesCached(DynamicObject, long, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */ && (arg3Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    NextWithHolesCachedData s2_ = this.nextWithHolesCached_cache;
                    while (s2_ != null) {
                        if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == s2_.cachedArrayType_) && (s2_.cachedArrayType_.hasHoles(arg0Value_))) {
                            return nextWithHolesCached(arg0Value_, arg1Value, arg2Value, arg3Value, s2_.cachedArrayType_, s2_.nextElementIndexNode_, s2_.isPlusOne_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 nextWithHolesUncached(DynamicObject, long, long, boolean, JSArrayNextElementIndexNode, ConditionProfile, ValueProfile) */) {
                    NextWithHolesUncachedData s3_ = this.nextWithHolesUncached_cache;
                    if (s3_ != null) {
                        if ((arg3Value) && (hasPrototypeElements(arg0Value_) || JSArrayElementIndexNode.hasHoles(arg0Value_))) {
                            return nextWithHolesUncached(arg0Value_, arg1Value, arg2Value, arg3Value, s3_.nextElementIndexNode_, s3_.isPlusOne_, s3_.arrayTypeProfile_);
                        }
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 nextObjectViaEnumeration(DynamicObject, long, long, boolean, JSHasPropertyNode) */) {
                    if ((!(arg3Value)) && (isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg2Value))) {
                        return nextObjectViaEnumeration(arg0Value_, arg1Value, arg2Value, arg3Value, this.nextObjectViaEnumeration_hasPropertyNode_);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 nextObjectViaFullEnumeration(DynamicObject, long, long, boolean, JSHasPropertyNode) */) {
                    if ((!(arg3Value)) && (!(isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg2Value))) && (JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value_, arg2Value))) {
                        return nextObjectViaFullEnumeration(arg0Value_, arg1Value, arg2Value, arg3Value, this.nextObjectViaFullEnumeration_hasPropertyNode_);
                    }
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 nextObjectViaPolling(Object, long, long, boolean, JSHasPropertyNode) */) {
                if ((!(arg3Value)) && (!(JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value, arg2Value)))) {
                    return nextObjectViaPolling(arg0Value, arg1Value, arg2Value, arg3Value, this.nextObjectViaPolling_hasPropertyNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
    }

    private long executeAndSpecialize(Object arg0Value, long arg1Value, long arg2Value, boolean arg3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if (((exclude & 0b1)) == 0 /* is-not-exclude doWithoutHolesCached(DynamicObject, long, long, boolean, ScriptArray) */ && (arg3Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    int count0_ = 0;
                    WithoutHolesCachedData s0_ = this.withoutHolesCached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doWithoutHolesCached(DynamicObject, long, long, boolean, ScriptArray) */) {
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
                            ScriptArray cachedArrayType__ = (JSArrayElementIndexNode.getArrayTypeIfArray(arg0Value_, arg3Value));
                            if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == cachedArrayType__) && (!(cachedArrayType__.hasHoles(arg0Value_))) && count0_ < (JSArrayElementIndexNode.MAX_CACHED_ARRAY_TYPES)) {
                                s0_ = new WithoutHolesCachedData(withoutHolesCached_cache);
                                s0_.cachedArrayType_ = cachedArrayType__;
                                MemoryFence.storeStore();
                                this.withoutHolesCached_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doWithoutHolesCached(DynamicObject, long, long, boolean, ScriptArray) */;
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doWithoutHolesCached(arg0Value_, arg1Value, arg2Value, arg3Value, s0_.cachedArrayType_);
                    }
                }
                if ((arg3Value) && (!(hasPrototypeElements(arg0Value_))) && (!(JSArrayElementIndexNode.hasHoles(arg0Value_)))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doWithoutHolesCached(DynamicObject, long, long, boolean, ScriptArray) */;
                    this.withoutHolesCached_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doWithoutHolesCached(DynamicObject, long, long, boolean, ScriptArray) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doWithoutHolesUncached(DynamicObject, long, long, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doWithoutHolesUncached(arg0Value_, arg1Value, arg2Value, arg3Value);
                }
                if (((exclude & 0b10)) == 0 /* is-not-exclude nextWithHolesCached(DynamicObject, long, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */ && (arg3Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    int count2_ = 0;
                    NextWithHolesCachedData s2_ = this.nextWithHolesCached_cache;
                    if ((state_0 & 0b100) != 0 /* is-state_0 nextWithHolesCached(DynamicObject, long, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */) {
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
                            ScriptArray cachedArrayType__1 = (JSArrayElementIndexNode.getArrayTypeIfArray(arg0Value_, arg3Value));
                            if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == cachedArrayType__1) && (cachedArrayType__1.hasHoles(arg0Value_)) && count2_ < (JSArrayElementIndexNode.MAX_CACHED_ARRAY_TYPES)) {
                                s2_ = super.insert(new NextWithHolesCachedData(nextWithHolesCached_cache));
                                s2_.cachedArrayType_ = cachedArrayType__1;
                                s2_.nextElementIndexNode_ = s2_.insertAccessor((JSArrayNextElementIndexNode.create(context)));
                                s2_.isPlusOne_ = (ConditionProfile.createBinaryProfile());
                                MemoryFence.storeStore();
                                this.nextWithHolesCached_cache = s2_;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 nextWithHolesCached(DynamicObject, long, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */;
                            }
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return nextWithHolesCached(arg0Value_, arg1Value, arg2Value, arg3Value, s2_.cachedArrayType_, s2_.nextElementIndexNode_, s2_.isPlusOne_);
                    }
                }
                if ((arg3Value) && (hasPrototypeElements(arg0Value_) || JSArrayElementIndexNode.hasHoles(arg0Value_))) {
                    NextWithHolesUncachedData s3_ = super.insert(new NextWithHolesUncachedData());
                    s3_.nextElementIndexNode_ = s3_.insertAccessor((JSArrayNextElementIndexNode.create(context)));
                    s3_.isPlusOne_ = (ConditionProfile.createBinaryProfile());
                    s3_.arrayTypeProfile_ = (ValueProfile.createClassProfile());
                    MemoryFence.storeStore();
                    this.nextWithHolesUncached_cache = s3_;
                    this.exclude_ = exclude = exclude | 0b10 /* add-exclude nextWithHolesCached(DynamicObject, long, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */;
                    this.nextWithHolesCached_cache = null;
                    state_0 = state_0 & 0xfffffffb /* remove-state_0 nextWithHolesCached(DynamicObject, long, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 nextWithHolesUncached(DynamicObject, long, long, boolean, JSArrayNextElementIndexNode, ConditionProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return nextWithHolesUncached(arg0Value_, arg1Value, arg2Value, arg3Value, s3_.nextElementIndexNode_, s3_.isPlusOne_, s3_.arrayTypeProfile_);
                }
                if ((!(arg3Value)) && (isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg2Value))) {
                    this.nextObjectViaEnumeration_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 nextObjectViaEnumeration(DynamicObject, long, long, boolean, JSHasPropertyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return nextObjectViaEnumeration(arg0Value_, arg1Value, arg2Value, arg3Value, this.nextObjectViaEnumeration_hasPropertyNode_);
                }
                if ((!(arg3Value)) && (!(isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg2Value))) && (JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value_, arg2Value))) {
                    this.nextObjectViaFullEnumeration_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 nextObjectViaFullEnumeration(DynamicObject, long, long, boolean, JSHasPropertyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return nextObjectViaFullEnumeration(arg0Value_, arg1Value, arg2Value, arg3Value, this.nextObjectViaFullEnumeration_hasPropertyNode_);
                }
            }
            if ((!(arg3Value)) && (!(JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value, arg2Value)))) {
                this.nextObjectViaPolling_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 nextObjectViaPolling(Object, long, long, boolean, JSHasPropertyNode) */;
                lock.unlock();
                hasLock = false;
                return nextObjectViaPolling(arg0Value, arg1Value, arg2Value, arg3Value, this.nextObjectViaPolling_hasPropertyNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value);
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
                NextWithHolesCachedData s2_ = this.nextWithHolesCached_cache;
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doWithoutHolesCached(DynamicObject, long, long, boolean, ScriptArray) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            WithoutHolesCachedData s0_ = this.withoutHolesCached_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedArrayType_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doWithoutHolesCached(DynamicObject, long, long, boolean, ScriptArray) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doWithoutHolesUncached";
        if ((state_0 & 0b10) != 0 /* is-state_0 doWithoutHolesUncached(DynamicObject, long, long, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "nextWithHolesCached";
        if ((state_0 & 0b100) != 0 /* is-state_0 nextWithHolesCached(DynamicObject, long, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            NextWithHolesCachedData s2_ = this.nextWithHolesCached_cache;
            while (s2_ != null) {
                cached.add(Arrays.asList(s2_.cachedArrayType_, s2_.nextElementIndexNode_, s2_.isPlusOne_));
                s2_ = s2_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude nextWithHolesCached(DynamicObject, long, long, boolean, ScriptArray, JSArrayNextElementIndexNode, ConditionProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "nextWithHolesUncached";
        if ((state_0 & 0b1000) != 0 /* is-state_0 nextWithHolesUncached(DynamicObject, long, long, boolean, JSArrayNextElementIndexNode, ConditionProfile, ValueProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            NextWithHolesUncachedData s3_ = this.nextWithHolesUncached_cache;
            if (s3_ != null) {
                cached.add(Arrays.asList(s3_.nextElementIndexNode_, s3_.isPlusOne_, s3_.arrayTypeProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "nextObjectViaEnumeration";
        if ((state_0 & 0b10000) != 0 /* is-state_0 nextObjectViaEnumeration(DynamicObject, long, long, boolean, JSHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.nextObjectViaEnumeration_hasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "nextObjectViaFullEnumeration";
        if ((state_0 & 0b100000) != 0 /* is-state_0 nextObjectViaFullEnumeration(DynamicObject, long, long, boolean, JSHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.nextObjectViaFullEnumeration_hasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "nextObjectViaPolling";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 nextObjectViaPolling(Object, long, long, boolean, JSHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.nextObjectViaPolling_hasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static JSArrayNextElementIndexNode create(JSContext context) {
        return new JSArrayNextElementIndexNodeGen(context);
    }

    @GeneratedBy(JSArrayNextElementIndexNode.class)
    private static final class WithoutHolesCachedData {

        @CompilationFinal WithoutHolesCachedData next_;
        @CompilationFinal ScriptArray cachedArrayType_;

        WithoutHolesCachedData(WithoutHolesCachedData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(JSArrayNextElementIndexNode.class)
    private static final class NextWithHolesCachedData extends Node {

        @Child NextWithHolesCachedData next_;
        @CompilationFinal ScriptArray cachedArrayType_;
        @Child JSArrayNextElementIndexNode nextElementIndexNode_;
        @CompilationFinal ConditionProfile isPlusOne_;

        NextWithHolesCachedData(NextWithHolesCachedData next_) {
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
    @GeneratedBy(JSArrayNextElementIndexNode.class)
    private static final class NextWithHolesUncachedData extends Node {

        @Child JSArrayNextElementIndexNode nextElementIndexNode_;
        @CompilationFinal ConditionProfile isPlusOne_;
        @CompilationFinal ValueProfile arrayTypeProfile_;

        NextWithHolesUncachedData() {
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
