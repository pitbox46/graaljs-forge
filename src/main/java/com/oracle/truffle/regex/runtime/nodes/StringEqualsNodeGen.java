// CheckStyle: start generated
package com.oracle.truffle.regex.runtime.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.concurrent.locks.Lock;

@GeneratedBy(StringEqualsNode.class)
public final class StringEqualsNodeGen extends StringEqualsNode {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CacheIdentityData cacheIdentity_cache;

    private StringEqualsNodeGen() {
    }

    @ExplodeLoop
    @Override
    public boolean execute(String arg0Value, String arg1Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 cacheIdentity(String, String, String) || doEquals(String, String) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 cacheIdentity(String, String, String) */) {
                CacheIdentityData s0_ = this.cacheIdentity_cache;
                while (s0_ != null) {
                    if ((arg0Value == s0_.cachedA_) && (s0_.cachedA_.equals(arg1Value))) {
                        return StringEqualsNode.cacheIdentity(arg0Value, arg1Value, s0_.cachedA_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doEquals(String, String) */) {
                return StringEqualsNode.doEquals(arg0Value, arg1Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private boolean executeAndSpecialize(String arg0Value, String arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude cacheIdentity(String, String, String) */) {
                int count0_ = 0;
                CacheIdentityData s0_ = this.cacheIdentity_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 cacheIdentity(String, String, String) */) {
                    while (s0_ != null) {
                        if ((arg0Value == s0_.cachedA_) && (s0_.cachedA_.equals(arg1Value))) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    {
                        String cachedA__ = (arg0Value);
                        // assert (arg0Value == s0_.cachedA_);
                        if ((cachedA__.equals(arg1Value)) && count0_ < (4)) {
                            s0_ = new CacheIdentityData(cacheIdentity_cache);
                            s0_.cachedA_ = cachedA__;
                            MemoryFence.storeStore();
                            this.cacheIdentity_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 cacheIdentity(String, String, String) */;
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return StringEqualsNode.cacheIdentity(arg0Value, arg1Value, s0_.cachedA_);
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude cacheIdentity(String, String, String) */;
            this.cacheIdentity_cache = null;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 cacheIdentity(String, String, String) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doEquals(String, String) */;
            lock.unlock();
            hasLock = false;
            return StringEqualsNode.doEquals(arg0Value, arg1Value);
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
                CacheIdentityData s0_ = this.cacheIdentity_cache;
                if ((s0_ == null || s0_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static StringEqualsNode create() {
        return new StringEqualsNodeGen();
    }

    public static StringEqualsNode getUncached() {
        return StringEqualsNodeGen.UNCACHED;
    }

    @GeneratedBy(StringEqualsNode.class)
    private static final class CacheIdentityData {

        @CompilationFinal CacheIdentityData next_;
        @CompilationFinal String cachedA_;

        CacheIdentityData(CacheIdentityData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(StringEqualsNode.class)
    private static final class Uncached extends StringEqualsNode {

        @TruffleBoundary
        @Override
        public boolean execute(String arg0Value, String arg1Value) {
            return StringEqualsNode.doEquals(arg0Value, arg1Value);
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
