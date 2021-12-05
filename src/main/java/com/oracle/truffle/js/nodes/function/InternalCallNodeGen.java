// CheckStyle: start generated
package com.oracle.truffle.js.nodes.function;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InternalCallNode.class)
public final class InternalCallNodeGen extends InternalCallNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private DirectCallData directCall_cache;
    @Child private IndirectCallNode indirectCall_indirectCallNode_;

    private InternalCallNodeGen() {
    }

    @ExplodeLoop
    @Override
    public Object execute(CallTarget arg0Value, Object[] arg1Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 directCall(CallTarget, Object[], CallTarget, DirectCallNode) || indirectCall(CallTarget, Object[], IndirectCallNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 directCall(CallTarget, Object[], CallTarget, DirectCallNode) */) {
                DirectCallData s0_ = this.directCall_cache;
                while (s0_ != null) {
                    if ((arg0Value == s0_.cachedCallTarget_)) {
                        return InternalCallNode.directCall(arg0Value, arg1Value, s0_.cachedCallTarget_, s0_.directCallNode_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 indirectCall(CallTarget, Object[], IndirectCallNode) */) {
                return InternalCallNode.indirectCall(arg0Value, arg1Value, this.indirectCall_indirectCallNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private Object executeAndSpecialize(CallTarget arg0Value, Object[] arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int count0_ = 0;
            DirectCallData s0_ = this.directCall_cache;
            if ((state_0 & 0b1) != 0 /* is-state_0 directCall(CallTarget, Object[], CallTarget, DirectCallNode) */) {
                while (s0_ != null) {
                    if ((arg0Value == s0_.cachedCallTarget_)) {
                        break;
                    }
                    s0_ = s0_.next_;
                    count0_++;
                }
            }
            if (s0_ == null) {
                // assert (arg0Value == s0_.cachedCallTarget_);
                if (count0_ < (InternalCallNode.LIMIT)) {
                    s0_ = super.insert(new DirectCallData(directCall_cache));
                    s0_.cachedCallTarget_ = (arg0Value);
                    s0_.directCallNode_ = s0_.insertAccessor((DirectCallNode.create(s0_.cachedCallTarget_)));
                    MemoryFence.storeStore();
                    this.directCall_cache = s0_;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 directCall(CallTarget, Object[], CallTarget, DirectCallNode) */;
                }
            }
            if (s0_ != null) {
                lock.unlock();
                hasLock = false;
                return InternalCallNode.directCall(arg0Value, arg1Value, s0_.cachedCallTarget_, s0_.directCallNode_);
            }
            this.indirectCall_indirectCallNode_ = super.insert((IndirectCallNode.create()));
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 indirectCall(CallTarget, Object[], IndirectCallNode) */;
            lock.unlock();
            hasLock = false;
            return InternalCallNode.indirectCall(arg0Value, arg1Value, this.indirectCall_indirectCallNode_);
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
                DirectCallData s0_ = this.directCall_cache;
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
        s = new Object[3];
        s[0] = "directCall";
        if ((state_0 & 0b1) != 0 /* is-state_0 directCall(CallTarget, Object[], CallTarget, DirectCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            DirectCallData s0_ = this.directCall_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedCallTarget_, s0_.directCallNode_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "indirectCall";
        if ((state_0 & 0b10) != 0 /* is-state_0 indirectCall(CallTarget, Object[], IndirectCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.indirectCall_indirectCallNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static InternalCallNode create() {
        return new InternalCallNodeGen();
    }

    @GeneratedBy(InternalCallNode.class)
    private static final class DirectCallData extends Node {

        @Child DirectCallData next_;
        @CompilationFinal CallTarget cachedCallTarget_;
        @Child DirectCallNode directCallNode_;

        DirectCallData(DirectCallData next_) {
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
}
