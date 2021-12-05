// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.objects.IteratorRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GetAsyncIteratorNode.class)
public final class GetAsyncIteratorNodeGen extends GetAsyncIteratorNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private GetIteratorData getIterator_cache;

    private GetAsyncIteratorNodeGen(JSContext context, JavaScriptNode objectNode) {
        super(context, objectNode);
    }

    @Override
    public IteratorRecord execute(Object objectNodeValue) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doGetIterator(Object, IsCallableNode, JSFunctionCallNode, IsJSObjectNode) */) {
            GetIteratorData s0_ = this.getIterator_cache;
            if (s0_ != null) {
                return doGetIterator(objectNodeValue, s0_.isCallableNode_, s0_.methodCallNode_, s0_.isObjectNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(objectNodeValue);
    }

    @Override
    public IteratorRecord execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object objectNodeValue_ = super.objectNode.execute(frameValue);
        if (state_0 != 0 /* is-state_0 doGetIterator(Object, IsCallableNode, JSFunctionCallNode, IsJSObjectNode) */) {
            GetIteratorData s0_ = this.getIterator_cache;
            if (s0_ != null) {
                return doGetIterator(objectNodeValue_, s0_.isCallableNode_, s0_.methodCallNode_, s0_.isObjectNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(objectNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private IteratorRecord executeAndSpecialize(Object objectNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            GetIteratorData s0_ = super.insert(new GetIteratorData());
            s0_.isCallableNode_ = s0_.insertAccessor((IsCallableNode.create()));
            s0_.methodCallNode_ = s0_.insertAccessor((JSFunctionCallNode.createCall()));
            s0_.isObjectNode_ = s0_.insertAccessor((IsJSObjectNode.create()));
            MemoryFence.storeStore();
            this.getIterator_cache = s0_;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doGetIterator(Object, IsCallableNode, JSFunctionCallNode, IsJSObjectNode) */;
            lock.unlock();
            hasLock = false;
            return doGetIterator(objectNodeValue, s0_.isCallableNode_, s0_.methodCallNode_, s0_.isObjectNode_);
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
            return NodeCost.MONOMORPHIC;
        }
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[2];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doGetIterator";
        if (state_0 != 0 /* is-state_0 doGetIterator(Object, IsCallableNode, JSFunctionCallNode, IsJSObjectNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GetIteratorData s0_ = this.getIterator_cache;
            if (s0_ != null) {
                cached.add(Arrays.asList(s0_.isCallableNode_, s0_.methodCallNode_, s0_.isObjectNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static GetAsyncIteratorNode create(JSContext context, JavaScriptNode objectNode) {
        return new GetAsyncIteratorNodeGen(context, objectNode);
    }

    @GeneratedBy(GetAsyncIteratorNode.class)
    private static final class GetIteratorData extends Node {

        @Child IsCallableNode isCallableNode_;
        @Child JSFunctionCallNode methodCallNode_;
        @Child IsJSObjectNode isObjectNode_;

        GetIteratorData() {
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
