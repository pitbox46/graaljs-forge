// CheckStyle: start generated
package com.oracle.truffle.regex;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.instrumentation.InstrumentableNode.WrapperNode;
import com.oracle.truffle.api.nodes.NodeCost;

@GeneratedBy(RegexBodyNode.class)
final class RegexBodyNodeWrapper extends RegexBodyNode implements WrapperNode {

    @Child private RegexBodyNode delegateNode;
    @Child private ProbeNode probeNode;

    RegexBodyNodeWrapper(RegexBodyNode copy, RegexBodyNode delegateNode, ProbeNode probeNode) {
        super(copy);
        this.delegateNode = delegateNode;
        this.probeNode = probeNode;
    }

    @Override
    public RegexBodyNode getDelegateNode() {
        return delegateNode;
    }

    @Override
    public ProbeNode getProbeNode() {
        return probeNode;
    }

    @Override
    public NodeCost getCost() {
        return NodeCost.NONE;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        Object returnValue;
        for (;;) {
            boolean wasOnReturnExecuted = false;
            try {
                probeNode.onEnter(frame);
                returnValue = delegateNode.execute(frame);
                wasOnReturnExecuted = true;
                probeNode.onReturnValue(frame, returnValue);
                break;
            } catch (Throwable t) {
                Object result = probeNode.onReturnExceptionalOrUnwind(frame, t, wasOnReturnExecuted);
                if (result == ProbeNode.UNWIND_ACTION_REENTER) {
                    continue;
                } else if (result != null) {
                    returnValue = result;
                    break;
                }
                throw t;
            }
        }
        return returnValue;
    }

}
