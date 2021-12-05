// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.Assumption;
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
import com.oracle.truffle.api.object.HiddenKey;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HasHiddenKeyCacheNode.class)
public final class HasHiddenKeyCacheNodeGen extends HasHiddenKeyCacheNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedData cached_cache;

    private HasHiddenKeyCacheNodeGen(HiddenKey key) {
        super(key);
    }

    @ExplodeLoop
    @Override
    public boolean executeHasHiddenKey(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean, int) || doUncached(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean, int) */) {
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    if (!Assumption.isValidAssumption(s0_.assumption0_)) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        removeCached_(s0_);
                        return executeAndSpecialize(arg0Value_);
                    }
                    if ((s0_.cachedShape_.check(arg0Value_))) {
                        return HasHiddenKeyCacheNode.doCached(arg0Value_, s0_.cachedShape_, s0_.hasOwnProperty_, s0_.cacheLimit_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(DynamicObject) */) {
                if ((JSGuards.isJSObject(arg0Value_))) {
                    return doUncached(arg0Value_);
                }
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doNonObject(Object) */) {
            if ((!(JSGuards.isJSObject(arg0Value)))) {
                return HasHiddenKeyCacheNode.doNonObject(arg0Value);
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
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((exclude) == 0 /* is-not-exclude doCached(DynamicObject, Shape, boolean, int) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean, int) */) {
                        while (s0_ != null) {
                            if ((s0_.cachedShape_.check(arg0Value_)) && (s0_.assumption0_ == null || Assumption.isValidAssumption(s0_.assumption0_))) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        {
                            Shape cachedShape__ = (arg0Value_.getShape());
                            if ((cachedShape__.check(arg0Value_))) {
                                Assumption assumption0 = (cachedShape__.getValidAssumption());
                                if (Assumption.isValidAssumption(assumption0)) {
                                    int cacheLimit__ = (getPropertyCacheLimit());
                                    if (count0_ < (cacheLimit__)) {
                                        s0_ = new CachedData(cached_cache);
                                        s0_.cachedShape_ = cachedShape__;
                                        s0_.hasOwnProperty_ = (doUncached(arg0Value_));
                                        s0_.cacheLimit_ = cacheLimit__;
                                        s0_.assumption0_ = assumption0;
                                        MemoryFence.storeStore();
                                        this.cached_cache = s0_;
                                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, Shape, boolean, int) */;
                                    }
                                }
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return HasHiddenKeyCacheNode.doCached(arg0Value_, s0_.cachedShape_, s0_.hasOwnProperty_, s0_.cacheLimit_);
                    }
                }
                if ((JSGuards.isJSObject(arg0Value_))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(DynamicObject, Shape, boolean, int) */;
                    this.cached_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(DynamicObject, Shape, boolean, int) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doUncached(arg0Value_);
                }
            }
            if ((!(JSGuards.isJSObject(arg0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doNonObject(Object) */;
                lock.unlock();
                hasLock = false;
                return HasHiddenKeyCacheNode.doNonObject(arg0Value);
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
        if (state_0 == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                CachedData s0_ = this.cached_cache;
                if ((s0_ == null || s0_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    void removeCached_(Object s0_) {
        Lock lock = getLock();
        lock.lock();
        try {
            CachedData prev = null;
            CachedData cur = this.cached_cache;
            while (cur != null) {
                if (cur == s0_) {
                    if (prev == null) {
                        this.cached_cache = cur.next_;
                    } else {
                        prev.next_ = cur.next_;
                    }
                    break;
                }
                prev = cur;
                cur = cur.next_;
            }
            if (this.cached_cache == null) {
                this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doCached(DynamicObject, Shape, boolean, int) */;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean, int) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s0_ = this.cached_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedShape_, s0_.hasOwnProperty_, s0_.cacheLimit_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doCached(DynamicObject, Shape, boolean, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doNonObject";
        if ((state_0 & 0b100) != 0 /* is-state_0 doNonObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static HasHiddenKeyCacheNode create(HiddenKey key) {
        return new HasHiddenKeyCacheNodeGen(key);
    }

    @GeneratedBy(HasHiddenKeyCacheNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean hasOwnProperty_;
        @CompilationFinal int cacheLimit_;
        @CompilationFinal Assumption assumption0_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
}
