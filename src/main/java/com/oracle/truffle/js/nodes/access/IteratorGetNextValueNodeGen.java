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
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.objects.IteratorRecord;

@GeneratedBy(IteratorGetNextValueNode.class)
public final class IteratorGetNextValueNodeGen extends IteratorGetNextValueNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private IteratorGetNextValueNodeGen(JSContext context, JavaScriptNode iteratorNode, JavaScriptNode doneNode, boolean setDone) {
        super(context, iteratorNode, doneNode, setDone);
    }

    @Override
    public Object execute(VirtualFrame frameValue, IteratorRecord iteratorNodeValue) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 iteratorStepAndGetValue(VirtualFrame, IteratorRecord) */) {
            return iteratorStepAndGetValue(frameValue, iteratorNodeValue);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, iteratorNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object iteratorNodeValue_ = super.iteratorNode.execute(frameValue);
        if (state_0 != 0 /* is-state_0 iteratorStepAndGetValue(VirtualFrame, IteratorRecord) */ && iteratorNodeValue_ instanceof IteratorRecord) {
            IteratorRecord iteratorNodeValue__ = (IteratorRecord) iteratorNodeValue_;
            return iteratorStepAndGetValue(frameValue, iteratorNodeValue__);
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
        int state_0 = this.state_0_;
        if (iteratorNodeValue instanceof IteratorRecord) {
            IteratorRecord iteratorNodeValue_ = (IteratorRecord) iteratorNodeValue;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 iteratorStepAndGetValue(VirtualFrame, IteratorRecord) */;
            return iteratorStepAndGetValue(frameValue, iteratorNodeValue_);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {super.iteratorNode}, iteratorNodeValue);
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
        s[0] = "iteratorStepAndGetValue";
        if (state_0 != 0 /* is-state_0 iteratorStepAndGetValue(VirtualFrame, IteratorRecord) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static IteratorGetNextValueNode create(JSContext context, JavaScriptNode iteratorNode, JavaScriptNode doneNode, boolean setDone) {
        return new IteratorGetNextValueNodeGen(context, iteratorNode, doneNode, setDone);
    }

}
