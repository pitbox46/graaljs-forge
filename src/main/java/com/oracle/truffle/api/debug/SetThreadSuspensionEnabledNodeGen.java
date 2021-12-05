// CheckStyle: start generated
package com.oracle.truffle.api.debug;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.debug.Breakpoint.SessionList;
import com.oracle.truffle.api.debug.DebuggerSession.ThreadSuspension;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SetThreadSuspensionEnabledNode.class)
final class SetThreadSuspensionEnabledNodeGen extends SetThreadSuspensionEnabledNode {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ExecuteCachedData executeCached_cache;

    private SetThreadSuspensionEnabledNodeGen() {
    }

    @ExplodeLoop
    @Override
    protected void execute(boolean arg0Value, SessionList arg1Value, long arg2Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 executeCached(boolean, SessionList, long, long, ThreadSuspension) || executeGeneric(boolean, SessionList, long) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 executeCached(boolean, SessionList, long, long, ThreadSuspension) */ && (arg1Value.next == null)) {
                ExecuteCachedData s0_ = this.executeCached_cache;
                while (s0_ != null) {
                    if ((arg2Value == s0_.currentThreadId_)) {
                        executeCached(arg0Value, arg1Value, arg2Value, s0_.currentThreadId_, s0_.threadSuspension_);
                        return;
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 executeGeneric(boolean, SessionList, long) */) {
                executeGeneric(arg0Value, arg1Value, arg2Value);
                return;
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        return;
    }

    private void executeAndSpecialize(boolean arg0Value, SessionList arg1Value, long arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude executeCached(boolean, SessionList, long, long, ThreadSuspension) */ && (arg1Value.next == null)) {
                int count0_ = 0;
                ExecuteCachedData s0_ = this.executeCached_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 executeCached(boolean, SessionList, long, long, ThreadSuspension) */) {
                    while (s0_ != null) {
                        if ((arg2Value == s0_.currentThreadId_)) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    {
                        long currentThreadId__ = (SetThreadSuspensionEnabledNode.currentThreadId());
                        if ((arg2Value == currentThreadId__) && count0_ < (SetThreadSuspensionEnabledNode.CACHE_LIMIT)) {
                            s0_ = new ExecuteCachedData(executeCached_cache);
                            s0_.currentThreadId_ = currentThreadId__;
                            s0_.threadSuspension_ = (getThreadSuspension(arg1Value));
                            MemoryFence.storeStore();
                            this.executeCached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 executeCached(boolean, SessionList, long, long, ThreadSuspension) */;
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    executeCached(arg0Value, arg1Value, arg2Value, s0_.currentThreadId_, s0_.threadSuspension_);
                    return;
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude executeCached(boolean, SessionList, long, long, ThreadSuspension) */;
            this.executeCached_cache = null;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 executeCached(boolean, SessionList, long, long, ThreadSuspension) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 executeGeneric(boolean, SessionList, long) */;
            lock.unlock();
            hasLock = false;
            executeGeneric(arg0Value, arg1Value, arg2Value);
            return;
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
                ExecuteCachedData s0_ = this.executeCached_cache;
                if ((s0_ == null || s0_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static SetThreadSuspensionEnabledNode create() {
        return new SetThreadSuspensionEnabledNodeGen();
    }

    @GeneratedBy(SetThreadSuspensionEnabledNode.class)
    private static final class ExecuteCachedData {

        @CompilationFinal ExecuteCachedData next_;
        @CompilationFinal long currentThreadId_;
        @CompilationFinal ThreadSuspension threadSuspension_;

        ExecuteCachedData(ExecuteCachedData next_) {
            this.next_ = next_;
        }

    }
}
