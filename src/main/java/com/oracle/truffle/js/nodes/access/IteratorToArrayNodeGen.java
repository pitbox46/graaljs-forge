// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.objects.IteratorRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IteratorToArrayNode.class)
public final class IteratorToArrayNodeGen extends IteratorToArrayNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private BranchProfile growProfile_;

    private IteratorToArrayNodeGen(JSContext context, JavaScriptNode iteratorNode, IteratorGetNextValueNode iteratorStepNode) {
        super(context, iteratorNode, iteratorStepNode);
    }

    @Override
    public Object execute(VirtualFrame frameValue, IteratorRecord iteratorNodeValue) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doIterator(VirtualFrame, IteratorRecord, BranchProfile) */) {
            return doIterator(frameValue, iteratorNodeValue, this.growProfile_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, iteratorNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object iteratorNodeValue_ = super.iteratorNode.execute(frameValue);
        if (state_0 != 0 /* is-state_0 doIterator(VirtualFrame, IteratorRecord, BranchProfile) */ && iteratorNodeValue_ instanceof IteratorRecord) {
            IteratorRecord iteratorNodeValue__ = (IteratorRecord) iteratorNodeValue_;
            return doIterator(frameValue, iteratorNodeValue__, this.growProfile_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, iteratorNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(VirtualFrame frameValue, Object iteratorNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (iteratorNodeValue instanceof IteratorRecord) {
                IteratorRecord iteratorNodeValue_ = (IteratorRecord) iteratorNodeValue;
                this.growProfile_ = (BranchProfile.create());
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doIterator(VirtualFrame, IteratorRecord, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doIterator(frameValue, iteratorNodeValue_, this.growProfile_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.iteratorNode}, iteratorNodeValue);
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
        s[0] = "doIterator";
        if (state_0 != 0 /* is-state_0 doIterator(VirtualFrame, IteratorRecord, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.growProfile_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static IteratorToArrayNode create(JSContext context, JavaScriptNode iteratorNode, IteratorGetNextValueNode iteratorStepNode) {
        return new IteratorToArrayNodeGen(context, iteratorNode, iteratorStepNode);
    }

}
