// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.cast.JSToPrimitiveNode.Hint;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToOperandNode.class)
public final class JSToOperandNodeGen extends JSToOperandNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private JSToPrimitiveNode other_toPrimitiveNode_;

    private JSToOperandNodeGen(Hint hint, boolean checkOperatorAllowed) {
        super(hint, checkOperatorAllowed);
    }

    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject) */ && arg0Value instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject arg0Value_ = (JSOverloadedOperatorsObject) arg0Value;
            return doOverloaded(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object, JSToPrimitiveNode) */) {
            if ((!(JSGuards.hasOverloadedOperators(arg0Value)))) {
                return doOther(arg0Value, this.other_toPrimitiveNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (arg0Value instanceof JSOverloadedOperatorsObject) {
                JSOverloadedOperatorsObject arg0Value_ = (JSOverloadedOperatorsObject) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doOverloaded(JSOverloadedOperatorsObject) */;
                lock.unlock();
                hasLock = false;
                return doOverloaded(arg0Value_);
            }
            if ((!(JSGuards.hasOverloadedOperators(arg0Value)))) {
                this.other_toPrimitiveNode_ = super.insert((JSToPrimitiveNode.create(getHint())));
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doOther(Object, JSToPrimitiveNode) */;
                lock.unlock();
                hasLock = false;
                return doOther(arg0Value, this.other_toPrimitiveNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
                return NodeCost.MONOMORPHIC;
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
        s[0] = "doOverloaded";
        if ((state_0 & 0b1) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object, JSToPrimitiveNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.other_toPrimitiveNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSToOperandNode create(Hint hint, boolean checkOperatorAllowed) {
        return new JSToOperandNodeGen(hint, checkOperatorAllowed);
    }

}
