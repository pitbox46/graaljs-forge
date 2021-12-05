// CheckStyle: start generated
package com.oracle.truffle.polyglot;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import java.lang.reflect.Type;
import java.util.concurrent.locks.Lock;
import org.graalvm.polyglot.impl.AbstractPolyglotImpl.AbstractHostService;

@GeneratedBy(PolyglotToHostNode.class)
final class PolyglotToHostNodeGen extends PolyglotToHostNode {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private AbstractHostService host_;
    @Child private Node toHostNode_;

    private PolyglotToHostNodeGen() {
    }

    @Override
    Object execute(PolyglotLanguageContext arg0Value, Object arg1Value, Class<?> arg2Value, Type arg3Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doDefault(PolyglotLanguageContext, Object, Class<>, Type, AbstractHostService, Node) */) {
            return PolyglotToHostNode.doDefault(arg0Value, arg1Value, arg2Value, arg3Value, this.host_, this.toHostNode_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
    }

    private Object executeAndSpecialize(PolyglotLanguageContext arg0Value, Object arg1Value, Class<?> arg2Value, Type arg3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            this.host_ = (arg0Value.context.engine.host);
            this.toHostNode_ = super.insert((PolyglotToHostNode.createToHostNode(this.host_)));
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doDefault(PolyglotLanguageContext, Object, Class<>, Type, AbstractHostService, Node) */;
            lock.unlock();
            hasLock = false;
            return PolyglotToHostNode.doDefault(arg0Value, arg1Value, arg2Value, arg3Value, this.host_, this.toHostNode_);
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

    public static PolyglotToHostNode create() {
        return new PolyglotToHostNodeGen();
    }

}
