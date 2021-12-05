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

@GeneratedBy(JSArrayPreviousElementIndexNode.class)
public final class JSArrayPreviousElementIndexNodeGen extends JSArrayPreviousElementIndexNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private WithoutHolesCachedData withoutHolesCached_cache;
    @Child private PreviousWithHolesCachedData previousWithHolesCached_cache;
    @Child private PreviousWithHolesUncachedData previousWithHolesUncached_cache;
    @Child private JSHasPropertyNode previousObjectViaEnumeration_hasPropertyNode_;
    @Child private JSHasPropertyNode previousObjectViaFullEnumeration_hasPropertyNode_;
    @Child private JSHasPropertyNode previousObjectViaIteration_hasPropertyNode_;

    private JSArrayPreviousElementIndexNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    public long executeLong(Object arg0Value, long arg1Value, boolean arg2Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) || doWithoutHolesUncached(DynamicObject, long, boolean) || previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) || previousWithHolesUncached(DynamicObject, long, boolean, JSArrayPreviousElementIndexNode, ConditionProfile, ValueProfile) || previousObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) || previousObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) || previousObjectViaIteration(Object, long, boolean, JSHasPropertyNode) */) {
            if ((state_0 & 0b111111) != 0 /* is-state_0 doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) || doWithoutHolesUncached(DynamicObject, long, boolean) || previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) || previousWithHolesUncached(DynamicObject, long, boolean, JSArrayPreviousElementIndexNode, ConditionProfile, ValueProfile) || previousObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) || previousObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */ && JSTypes.isDynamicObject(arg0Value)) {
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
                if ((state_0 & 0b100) != 0 /* is-state_0 previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */ && (arg2Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    PreviousWithHolesCachedData s2_ = this.previousWithHolesCached_cache;
                    while (s2_ != null) {
                        if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == s2_.cachedArrayType_) && (s2_.cachedArrayType_.hasHoles(arg0Value_))) {
                            return previousWithHolesCached(arg0Value_, arg1Value, arg2Value, s2_.cachedArrayType_, s2_.previousElementIndexNode_, s2_.isMinusOne_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 previousWithHolesUncached(DynamicObject, long, boolean, JSArrayPreviousElementIndexNode, ConditionProfile, ValueProfile) */) {
                    PreviousWithHolesUncachedData s3_ = this.previousWithHolesUncached_cache;
                    if (s3_ != null) {
                        if ((arg2Value) && (hasPrototypeElements(arg0Value_) || JSArrayElementIndexNode.hasHoles(arg0Value_))) {
                            return previousWithHolesUncached(arg0Value_, arg1Value, arg2Value, s3_.previousElementIndexNode_, s3_.isMinusOne_, s3_.arrayTypeProfile_);
                        }
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 previousObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */) {
                    if ((!(arg2Value)) && (isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg1Value))) {
                        return previousObjectViaEnumeration(arg0Value_, arg1Value, arg2Value, this.previousObjectViaEnumeration_hasPropertyNode_);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 previousObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */) {
                    if ((!(arg2Value)) && (!(isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg1Value))) && (JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value_, arg1Value))) {
                        return previousObjectViaFullEnumeration(arg0Value_, arg1Value, arg2Value, this.previousObjectViaFullEnumeration_hasPropertyNode_);
                    }
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 previousObjectViaIteration(Object, long, boolean, JSHasPropertyNode) */) {
                if ((!(arg2Value)) && (!(JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value, arg1Value)))) {
                    return previousObjectViaIteration(arg0Value, arg1Value, arg2Value, this.previousObjectViaIteration_hasPropertyNode_);
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
                if (((exclude & 0b10)) == 0 /* is-not-exclude previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */ && (arg2Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    int count2_ = 0;
                    PreviousWithHolesCachedData s2_ = this.previousWithHolesCached_cache;
                    if ((state_0 & 0b100) != 0 /* is-state_0 previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */) {
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
                                s2_ = super.insert(new PreviousWithHolesCachedData(previousWithHolesCached_cache));
                                s2_.cachedArrayType_ = cachedArrayType__1;
                                s2_.previousElementIndexNode_ = s2_.insertAccessor((JSArrayPreviousElementIndexNode.create(context)));
                                s2_.isMinusOne_ = (ConditionProfile.createBinaryProfile());
                                MemoryFence.storeStore();
                                this.previousWithHolesCached_cache = s2_;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */;
                            }
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return previousWithHolesCached(arg0Value_, arg1Value, arg2Value, s2_.cachedArrayType_, s2_.previousElementIndexNode_, s2_.isMinusOne_);
                    }
                }
                if ((arg2Value) && (hasPrototypeElements(arg0Value_) || JSArrayElementIndexNode.hasHoles(arg0Value_))) {
                    PreviousWithHolesUncachedData s3_ = super.insert(new PreviousWithHolesUncachedData());
                    s3_.previousElementIndexNode_ = s3_.insertAccessor((JSArrayPreviousElementIndexNode.create(context)));
                    s3_.isMinusOne_ = (ConditionProfile.createBinaryProfile());
                    s3_.arrayTypeProfile_ = (ValueProfile.createClassProfile());
                    MemoryFence.storeStore();
                    this.previousWithHolesUncached_cache = s3_;
                    this.exclude_ = exclude = exclude | 0b10 /* add-exclude previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */;
                    this.previousWithHolesCached_cache = null;
                    state_0 = state_0 & 0xfffffffb /* remove-state_0 previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 previousWithHolesUncached(DynamicObject, long, boolean, JSArrayPreviousElementIndexNode, ConditionProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return previousWithHolesUncached(arg0Value_, arg1Value, arg2Value, s3_.previousElementIndexNode_, s3_.isMinusOne_, s3_.arrayTypeProfile_);
                }
                if ((!(arg2Value)) && (isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg1Value))) {
                    this.previousObjectViaEnumeration_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 previousObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return previousObjectViaEnumeration(arg0Value_, arg1Value, arg2Value, this.previousObjectViaEnumeration_hasPropertyNode_);
                }
                if ((!(arg2Value)) && (!(isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg1Value))) && (JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value_, arg1Value))) {
                    this.previousObjectViaFullEnumeration_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 previousObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return previousObjectViaFullEnumeration(arg0Value_, arg1Value, arg2Value, this.previousObjectViaFullEnumeration_hasPropertyNode_);
                }
            }
            if ((!(arg2Value)) && (!(JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value, arg1Value)))) {
                this.previousObjectViaIteration_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 previousObjectViaIteration(Object, long, boolean, JSHasPropertyNode) */;
                lock.unlock();
                hasLock = false;
                return previousObjectViaIteration(arg0Value, arg1Value, arg2Value, this.previousObjectViaIteration_hasPropertyNode_);
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
                PreviousWithHolesCachedData s2_ = this.previousWithHolesCached_cache;
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
        s[0] = "previousWithHolesCached";
        if ((state_0 & 0b100) != 0 /* is-state_0 previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            PreviousWithHolesCachedData s2_ = this.previousWithHolesCached_cache;
            while (s2_ != null) {
                cached.add(Arrays.asList(s2_.cachedArrayType_, s2_.previousElementIndexNode_, s2_.isMinusOne_));
                s2_ = s2_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "previousWithHolesUncached";
        if ((state_0 & 0b1000) != 0 /* is-state_0 previousWithHolesUncached(DynamicObject, long, boolean, JSArrayPreviousElementIndexNode, ConditionProfile, ValueProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            PreviousWithHolesUncachedData s3_ = this.previousWithHolesUncached_cache;
            if (s3_ != null) {
                cached.add(Arrays.asList(s3_.previousElementIndexNode_, s3_.isMinusOne_, s3_.arrayTypeProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "previousObjectViaEnumeration";
        if ((state_0 & 0b10000) != 0 /* is-state_0 previousObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.previousObjectViaEnumeration_hasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "previousObjectViaFullEnumeration";
        if ((state_0 & 0b100000) != 0 /* is-state_0 previousObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.previousObjectViaFullEnumeration_hasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "previousObjectViaIteration";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 previousObjectViaIteration(Object, long, boolean, JSHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.previousObjectViaIteration_hasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static JSArrayPreviousElementIndexNode create(JSContext context) {
        return new JSArrayPreviousElementIndexNodeGen(context);
    }

    @GeneratedBy(JSArrayPreviousElementIndexNode.class)
    private static final class WithoutHolesCachedData {

        @CompilationFinal WithoutHolesCachedData next_;
        @CompilationFinal ScriptArray cachedArrayType_;

        WithoutHolesCachedData(WithoutHolesCachedData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(JSArrayPreviousElementIndexNode.class)
    private static final class PreviousWithHolesCachedData extends Node {

        @Child PreviousWithHolesCachedData next_;
        @CompilationFinal ScriptArray cachedArrayType_;
        @Child JSArrayPreviousElementIndexNode previousElementIndexNode_;
        @CompilationFinal ConditionProfile isMinusOne_;

        PreviousWithHolesCachedData(PreviousWithHolesCachedData next_) {
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
    @GeneratedBy(JSArrayPreviousElementIndexNode.class)
    private static final class PreviousWithHolesUncachedData extends Node {

        @Child JSArrayPreviousElementIndexNode previousElementIndexNode_;
        @CompilationFinal ConditionProfile isMinusOne_;
        @CompilationFinal ValueProfile arrayTypeProfile_;

        PreviousWithHolesUncachedData() {
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
