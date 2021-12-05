// CheckStyle: start generated
package com.oracle.truffle.host;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.host.HostContext.ToGuestValueNode;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HostContext.class)
final class HostContextFactory {

    @GeneratedBy(ToGuestValueNode.class)
    static final class ToGuestValueNodeGen extends ToGuestValueNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private ToGuestValueNodeGen() {
        }

        @ExplodeLoop
        @Override
        Object execute(HostContext arg0Value, Object arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doNull(HostContext, Object) || doCached(HostContext, Object, Class<>) || doUncached(HostContext, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doNull(HostContext, Object) */) {
                    if ((arg1Value == null)) {
                        return doNull(arg0Value, arg1Value);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doCached(HostContext, Object, Class<>) */ && (arg1Value != null)) {
                    CachedData s1_ = this.cached_cache;
                    while (s1_ != null) {
                        if ((arg1Value.getClass() == s1_.cachedReceiver_)) {
                            return doCached(arg0Value, arg1Value, s1_.cachedReceiver_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doUncached(HostContext, Object) */) {
                    return doUncached(arg0Value, arg1Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private Object executeAndSpecialize(HostContext arg0Value, Object arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((arg1Value == null)) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNull(HostContext, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNull(arg0Value, arg1Value);
                }
                if ((exclude) == 0 /* is-not-exclude doCached(HostContext, Object, Class<>) */ && (arg1Value != null)) {
                    int count1_ = 0;
                    CachedData s1_ = this.cached_cache;
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(HostContext, Object, Class<>) */) {
                        while (s1_ != null) {
                            if ((arg1Value.getClass() == s1_.cachedReceiver_)) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            Class<?> cachedReceiver__ = (arg1Value.getClass());
                            if ((arg1Value.getClass() == cachedReceiver__) && count1_ < (3)) {
                                s1_ = new CachedData(cached_cache);
                                s1_.cachedReceiver_ = cachedReceiver__;
                                MemoryFence.storeStore();
                                this.cached_cache = s1_;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(HostContext, Object, Class<>) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value, arg1Value, s1_.cachedReceiver_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(HostContext, Object, Class<>) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffd /* remove-state_0 doCached(HostContext, Object, Class<>) */;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doUncached(HostContext, Object) */;
                lock.unlock();
                hasLock = false;
                return doUncached(arg0Value, arg1Value);
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

        public static ToGuestValueNode create() {
            return new ToGuestValueNodeGen();
        }

        public static ToGuestValueNode getUncached() {
            return ToGuestValueNodeGen.UNCACHED;
        }

        @GeneratedBy(ToGuestValueNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal Class<?> cachedReceiver_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
        @GeneratedBy(ToGuestValueNode.class)
        private static final class Uncached extends ToGuestValueNode {

            @TruffleBoundary
            @Override
            Object execute(HostContext arg0Value, Object arg1Value) {
                if ((arg1Value == null)) {
                    return doNull(arg0Value, arg1Value);
                }
                return doUncached(arg0Value, arg1Value);
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
}
