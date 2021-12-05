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
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.objects.IteratorRecord;

@GeneratedBy(IteratorSetDoneNode.class)
public final class IteratorSetDoneNodeGen extends IteratorSetDoneNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private IteratorSetDoneNodeGen(JavaScriptNode iteratorNode, JavaScriptNode isDoneNode) {
        super(iteratorNode, isDoneNode);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object iteratorNodeValue_ = super.iteratorNode.execute(frameValue);
        boolean isDoneNodeValue_;
        try {
            isDoneNodeValue_ = super.isDoneNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(iteratorNodeValue_, ex.getResult());
        }
        if (state_0 != 0 /* is-state_0 doIteratorStep(IteratorRecord, boolean) */ && iteratorNodeValue_ instanceof IteratorRecord) {
            IteratorRecord iteratorNodeValue__ = (IteratorRecord) iteratorNodeValue_;
            return IteratorSetDoneNode.doIteratorStep(iteratorNodeValue__, isDoneNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(iteratorNodeValue_, isDoneNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object iteratorNodeValue_ = super.iteratorNode.execute(frameValue);
        boolean isDoneNodeValue_;
        try {
            isDoneNodeValue_ = super.isDoneNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(iteratorNodeValue_, ex.getResult());
        }
        if (state_0 != 0 /* is-state_0 doIteratorStep(IteratorRecord, boolean) */ && iteratorNodeValue_ instanceof IteratorRecord) {
            IteratorRecord iteratorNodeValue__ = (IteratorRecord) iteratorNodeValue_;
            return IteratorSetDoneNode.doIteratorStep(iteratorNodeValue__, isDoneNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(iteratorNodeValue_, isDoneNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    private boolean executeAndSpecialize(Object iteratorNodeValue, Object isDoneNodeValue) {
        int state_0 = this.state_0_;
        if (iteratorNodeValue instanceof IteratorRecord) {
            IteratorRecord iteratorNodeValue_ = (IteratorRecord) iteratorNodeValue;
            if (isDoneNodeValue instanceof Boolean) {
                boolean isDoneNodeValue_ = (boolean) isDoneNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doIteratorStep(IteratorRecord, boolean) */;
                return IteratorSetDoneNode.doIteratorStep(iteratorNodeValue_, isDoneNodeValue_);
            }
        }
        throw new UnsupportedSpecializationException(this, new Node[] {super.iteratorNode, super.isDoneNode}, iteratorNodeValue, isDoneNodeValue);
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
        s[0] = "doIteratorStep";
        if (state_0 != 0 /* is-state_0 doIteratorStep(IteratorRecord, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static IteratorSetDoneNode create(JavaScriptNode iteratorNode, JavaScriptNode isDoneNode) {
        return new IteratorSetDoneNodeGen(iteratorNode, isDoneNode);
    }

}
