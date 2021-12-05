// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GlobalScopeTDZCheckNode.class)
final class GlobalScopeTDZCheckNodeGen extends GlobalScopeTDZCheckNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedData cached_cache;
    @Child private PropertyGetNode uncached_getNode_;
    @CompilationFinal private BranchProfile uncached_deadBranch_;

    private GlobalScopeTDZCheckNodeGen(JSContext context, String varName) {
        super(context, varName);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object scopeNodeValue_ = super.scopeNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean) */ && JSTypes.isDynamicObject(scopeNodeValue_)) {
            DynamicObject scopeNodeValue__ = (DynamicObject) scopeNodeValue_;
            CachedData s0_ = this.cached_cache;
            while (s0_ != null) {
                if (!Assumption.isValidAssumption(s0_.assumption0_)) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    removeCached_(s0_);
                    return executeAndSpecialize(scopeNodeValue__);
                }
                if ((scopeNodeValue__.getShape() == s0_.cachedShape_)) {
                    return doCached(scopeNodeValue__, s0_.cachedShape_, s0_.dead_);
                }
                s0_ = s0_.next_;
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(Object, PropertyGetNode, BranchProfile) */) {
            return doUncached(scopeNodeValue_, this.uncached_getNode_, this.uncached_deadBranch_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object scopeNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude doCached(DynamicObject, Shape, boolean) */ && JSTypes.isDynamicObject(scopeNodeValue)) {
                DynamicObject scopeNodeValue_ = (DynamicObject) scopeNodeValue;
                int count0_ = 0;
                CachedData s0_ = this.cached_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean) */) {
                    while (s0_ != null) {
                        if ((scopeNodeValue_.getShape() == s0_.cachedShape_) && (s0_.assumption0_ == null || Assumption.isValidAssumption(s0_.assumption0_))) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    {
                        Shape cachedShape__ = (scopeNodeValue_.getShape());
                        if ((scopeNodeValue_.getShape() == cachedShape__)) {
                            Assumption assumption0 = (cachedShape__.getValidAssumption());
                            if (Assumption.isValidAssumption(assumption0)) {
                                if (count0_ < (context.getPropertyCacheLimit())) {
                                    s0_ = new CachedData(cached_cache);
                                    s0_.cachedShape_ = cachedShape__;
                                    s0_.dead_ = (isDead(cachedShape__));
                                    s0_.assumption0_ = assumption0;
                                    MemoryFence.storeStore();
                                    this.cached_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, Shape, boolean) */;
                                }
                            }
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doCached(scopeNodeValue_, s0_.cachedShape_, s0_.dead_);
                }
            }
            this.uncached_getNode_ = super.insert((PropertyGetNode.create(varName, context)));
            this.uncached_deadBranch_ = (BranchProfile.create());
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(DynamicObject, Shape, boolean) */;
            this.cached_cache = null;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(DynamicObject, Shape, boolean) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(Object, PropertyGetNode, BranchProfile) */;
            lock.unlock();
            hasLock = false;
            return doUncached(scopeNodeValue, this.uncached_getNode_, this.uncached_deadBranch_);
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
                this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doCached(DynamicObject, Shape, boolean) */;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s0_ = this.cached_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedShape_, s0_.dead_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doCached(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(Object, PropertyGetNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.uncached_getNode_, this.uncached_deadBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static GlobalScopeTDZCheckNode create(JSContext context, String varName) {
        return new GlobalScopeTDZCheckNodeGen(context, varName);
    }

    @GeneratedBy(GlobalScopeTDZCheckNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean dead_;
        @CompilationFinal Assumption assumption0_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
}
