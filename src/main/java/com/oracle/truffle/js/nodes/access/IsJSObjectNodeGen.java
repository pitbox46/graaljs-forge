// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsJSObjectNode.class)
public final class IsJSObjectNodeGen extends IsJSObjectNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private IsObjectCachedData isObjectCached_cache;
    @CompilationFinal private ConditionProfile isObject_resultProfile_;

    private IsJSObjectNodeGen(boolean includeNullUndefined) {
        super(includeNullUndefined);
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object arg0Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 isObjectCached(Object, Class<>, boolean) || isObject(Object, ConditionProfile) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 isObjectCached(Object, Class<>, boolean) */) {
                IsObjectCachedData s0_ = this.isObjectCached_cache;
                while (s0_ != null) {
                    assert (s0_.cachedClass_ != null);
                    if ((s0_.cachedClass_.isInstance(arg0Value))) {
                        return IsJSObjectNode.isObjectCached(arg0Value, s0_.cachedClass_, s0_.cachedResult_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isObject(Object, ConditionProfile) */) {
                return isObject(arg0Value, this.isObject_resultProfile_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private boolean executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude isObjectCached(Object, Class<>, boolean) */) {
                int count0_ = 0;
                IsObjectCachedData s0_ = this.isObjectCached_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 isObjectCached(Object, Class<>, boolean) */) {
                    while (s0_ != null) {
                        assert (s0_.cachedClass_ != null);
                        if ((s0_.cachedClass_.isInstance(arg0Value))) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    {
                        Class<?> cachedClass__ = (JSGuards.getClassIfJSDynamicObject(arg0Value));
                        if ((cachedClass__ != null) && (cachedClass__.isInstance(arg0Value)) && count0_ < (IsJSObjectNode.MAX_CLASS_COUNT)) {
                            s0_ = new IsObjectCachedData(isObjectCached_cache);
                            s0_.cachedClass_ = cachedClass__;
                            s0_.cachedResult_ = (guardIsJSObject(arg0Value));
                            MemoryFence.storeStore();
                            this.isObjectCached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 isObjectCached(Object, Class<>, boolean) */;
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return IsJSObjectNode.isObjectCached(arg0Value, s0_.cachedClass_, s0_.cachedResult_);
                }
            }
            this.isObject_resultProfile_ = (ConditionProfile.createBinaryProfile());
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude isObjectCached(Object, Class<>, boolean) */;
            this.isObjectCached_cache = null;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 isObjectCached(Object, Class<>, boolean) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 isObject(Object, ConditionProfile) */;
            lock.unlock();
            hasLock = false;
            return isObject(arg0Value, this.isObject_resultProfile_);
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
                IsObjectCachedData s0_ = this.isObjectCached_cache;
                if ((s0_ == null || s0_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "isObjectCached";
        if ((state_0 & 0b1) != 0 /* is-state_0 isObjectCached(Object, Class<>, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            IsObjectCachedData s0_ = this.isObjectCached_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedClass_, s0_.cachedResult_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude isObjectCached(Object, Class<>, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "isObject";
        if ((state_0 & 0b10) != 0 /* is-state_0 isObject(Object, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.isObject_resultProfile_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static IsJSObjectNode create(boolean includeNullUndefined) {
        return new IsJSObjectNodeGen(includeNullUndefined);
    }

    @GeneratedBy(IsJSObjectNode.class)
    private static final class IsObjectCachedData {

        @CompilationFinal IsObjectCachedData next_;
        @CompilationFinal Class<?> cachedClass_;
        @CompilationFinal boolean cachedResult_;

        IsObjectCachedData(IsObjectCachedData next_) {
            this.next_ = next_;
        }

    }
}
