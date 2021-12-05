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
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GlobalScopeLookupNode.class)
public final class GlobalScopeLookupNodeGen extends GlobalScopeLookupNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private Assumption absent_assumption_;
    @CompilationFinal private Assumption absent_assumption0_;
    @CompilationFinal private CachedData cached_cache;
    @CompilationFinal private BranchProfile uncached_errorBranch_;

    private GlobalScopeLookupNodeGen(String varName, boolean write) {
        super(varName, write);
    }

    @ExplodeLoop
    @Override
    public boolean execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doAbsent(DynamicObject, Assumption) || doCached(DynamicObject, Shape, boolean, boolean, boolean, int) || doUncached(DynamicObject, BranchProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state_0 & 0b1) != 0 /* is-state_0 doAbsent(DynamicObject, Assumption) */) {
                if (!Assumption.isValidAssumption(this.absent_assumption0_)) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    removeAbsent_();
                    return executeAndSpecialize(arg0Value_);
                }
                return GlobalScopeLookupNode.doAbsent(arg0Value_, this.absent_assumption_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */) {
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    if (!Assumption.isValidAssumption(s1_.assumption0_)) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        removeCached_(s1_);
                        return executeAndSpecialize(arg0Value_);
                    }
                    if ((arg0Value_.getShape() == s1_.cachedShape_)) {
                        return doCached(arg0Value_, s1_.cachedShape_, s1_.exists_, s1_.dead_, s1_.constAssignment_, s1_.cacheLimit_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doUncached(DynamicObject, BranchProfile) */) {
                return doUncached(arg0Value_, this.uncached_errorBranch_);
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
                if (((exclude & 0b1)) == 0 /* is-not-exclude doAbsent(DynamicObject, Assumption) */) {
                    {
                        Assumption absent_assumption__ = (getAbsentPropertyAssumption(arg0Value_.getShape()));
                        Assumption absent_assumption0 = (absent_assumption__);
                        if (Assumption.isValidAssumption(absent_assumption0)) {
                            this.absent_assumption_ = absent_assumption__;
                            this.absent_assumption0_ = absent_assumption0;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doAbsent(DynamicObject, Assumption) */;
                            lock.unlock();
                            hasLock = false;
                            return GlobalScopeLookupNode.doAbsent(arg0Value_, absent_assumption__);
                        }
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-exclude doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */) {
                    int count1_ = 0;
                    CachedData s1_ = this.cached_cache;
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */) {
                        while (s1_ != null) {
                            if ((arg0Value_.getShape() == s1_.cachedShape_) && (s1_.assumption0_ == null || Assumption.isValidAssumption(s1_.assumption0_))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            Shape cachedShape__ = (arg0Value_.getShape());
                            if ((arg0Value_.getShape() == cachedShape__)) {
                                Assumption assumption0 = (cachedShape__.getValidAssumption());
                                if (Assumption.isValidAssumption(assumption0)) {
                                    int cacheLimit__ = (getPropertyCacheLimit());
                                    if (count1_ < (cacheLimit__)) {
                                        s1_ = new CachedData(cached_cache);
                                        s1_.cachedShape_ = cachedShape__;
                                        s1_.exists_ = (cachedShape__.hasProperty(varName));
                                        s1_.dead_ = (isDead(cachedShape__));
                                        s1_.constAssignment_ = (isConstAssignment(cachedShape__));
                                        s1_.cacheLimit_ = cacheLimit__;
                                        s1_.assumption0_ = assumption0;
                                        MemoryFence.storeStore();
                                        this.cached_cache = s1_;
                                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude doAbsent(DynamicObject, Assumption) */;
                                        state_0 = state_0 & 0xfffffffe /* remove-state_0 doAbsent(DynamicObject, Assumption) */;
                                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */;
                                    }
                                }
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value_, s1_.cachedShape_, s1_.exists_, s1_.dead_, s1_.constAssignment_, s1_.cacheLimit_);
                    }
                }
                this.uncached_errorBranch_ = (BranchProfile.create());
                this.exclude_ = exclude = exclude | 0b11 /* add-exclude doAbsent(DynamicObject, Assumption), doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffc /* remove-state_0 doAbsent(DynamicObject, Assumption), doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doUncached(DynamicObject, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doUncached(arg0Value_, this.uncached_errorBranch_);
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
                CachedData s1_ = this.cached_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    void removeCached_(Object s1_) {
        Lock lock = getLock();
        lock.lock();
        try {
            CachedData prev = null;
            CachedData cur = this.cached_cache;
            while (cur != null) {
                if (cur == s1_) {
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
                this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */;
            }
        } finally {
            lock.unlock();
        }
    }

    void removeAbsent_() {
        Lock lock = getLock();
        lock.lock();
        try {
            this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doAbsent(DynamicObject, Assumption) */;
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
        s[0] = "doAbsent";
        if ((state_0 & 0b1) != 0 /* is-state_0 doAbsent(DynamicObject, Assumption) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.absent_assumption_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doAbsent(DynamicObject, Assumption) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doCached";
        if ((state_0 & 0b10) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s1_ = this.cached_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedShape_, s1_.exists_, s1_.dead_, s1_.constAssignment_, s1_.cacheLimit_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state_0 & 0b100) != 0 /* is-state_0 doUncached(DynamicObject, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.uncached_errorBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static GlobalScopeLookupNode create(String varName, boolean write) {
        return new GlobalScopeLookupNodeGen(varName, write);
    }

    @GeneratedBy(GlobalScopeLookupNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean exists_;
        @CompilationFinal boolean dead_;
        @CompilationFinal boolean constAssignment_;
        @CompilationFinal int cacheLimit_;
        @CompilationFinal Assumption assumption0_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
}
