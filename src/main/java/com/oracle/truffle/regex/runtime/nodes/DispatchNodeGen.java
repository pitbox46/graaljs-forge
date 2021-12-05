// CheckStyle: start generated
package com.oracle.truffle.regex.runtime.nodes;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.regex.result.RegexResult;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DispatchNode.class)
public final class DispatchNodeGen extends DispatchNode {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private ExecuteDirectData executeDirect_cache;
    @Child private IndirectCallNode executeIndirect_callNode_;

    private DispatchNodeGen() {
    }

    @ExplodeLoop
    @Override
    public Object execute(CallTarget arg0Value, RegexResult arg1Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 executeDirect(CallTarget, RegexResult, CallTarget, DirectCallNode) || executeIndirect(CallTarget, RegexResult, IndirectCallNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 executeDirect(CallTarget, RegexResult, CallTarget, DirectCallNode) */) {
                ExecuteDirectData s0_ = this.executeDirect_cache;
                while (s0_ != null) {
                    if ((arg0Value == s0_.cachedTarget_)) {
                        return DispatchNode.executeDirect(arg0Value, arg1Value, s0_.cachedTarget_, s0_.callNode_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 executeIndirect(CallTarget, RegexResult, IndirectCallNode) */) {
                return DispatchNode.executeIndirect(arg0Value, arg1Value, this.executeIndirect_callNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private Object executeAndSpecialize(CallTarget arg0Value, RegexResult arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude executeDirect(CallTarget, RegexResult, CallTarget, DirectCallNode) */) {
                int count0_ = 0;
                ExecuteDirectData s0_ = this.executeDirect_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 executeDirect(CallTarget, RegexResult, CallTarget, DirectCallNode) */) {
                    while (s0_ != null) {
                        if ((arg0Value == s0_.cachedTarget_)) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    // assert (arg0Value == s0_.cachedTarget_);
                    if (count0_ < (3)) {
                        s0_ = super.insert(new ExecuteDirectData(executeDirect_cache));
                        s0_.cachedTarget_ = (arg0Value);
                        s0_.callNode_ = s0_.insertAccessor((DirectCallNode.create(s0_.cachedTarget_)));
                        MemoryFence.storeStore();
                        this.executeDirect_cache = s0_;
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 executeDirect(CallTarget, RegexResult, CallTarget, DirectCallNode) */;
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return DispatchNode.executeDirect(arg0Value, arg1Value, s0_.cachedTarget_, s0_.callNode_);
                }
            }
            this.executeIndirect_callNode_ = super.insert((IndirectCallNode.create()));
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude executeDirect(CallTarget, RegexResult, CallTarget, DirectCallNode) */;
            this.executeDirect_cache = null;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 executeDirect(CallTarget, RegexResult, CallTarget, DirectCallNode) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 executeIndirect(CallTarget, RegexResult, IndirectCallNode) */;
            lock.unlock();
            hasLock = false;
            return DispatchNode.executeIndirect(arg0Value, arg1Value, this.executeIndirect_callNode_);
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
                ExecuteDirectData s0_ = this.executeDirect_cache;
                if ((s0_ == null || s0_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static DispatchNode create() {
        return new DispatchNodeGen();
    }

    public static DispatchNode getUncached() {
        return DispatchNodeGen.UNCACHED;
    }

    @GeneratedBy(DispatchNode.class)
    private static final class ExecuteDirectData extends Node {

        @Child ExecuteDirectData next_;
        @CompilationFinal CallTarget cachedTarget_;
        @Child DirectCallNode callNode_;

        ExecuteDirectData(ExecuteDirectData next_) {
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
    @GeneratedBy(DispatchNode.class)
    private static final class Uncached extends DispatchNode {

        @TruffleBoundary
        @Override
        public Object execute(CallTarget arg0Value, RegexResult arg1Value) {
            return DispatchNode.executeIndirect(arg0Value, arg1Value, (IndirectCallNode.getUncached()));
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
