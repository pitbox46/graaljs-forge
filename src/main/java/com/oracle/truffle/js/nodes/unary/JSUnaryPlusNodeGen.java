// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSUnaryPlusNode.class)
public final class JSUnaryPlusNodeGen extends JSUnaryPlusNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private JSOverloadedUnaryNode overloaded_overloadedOperatorNode_;
    @Child private JSToNumberNode default_toNumberNode_;

    private JSUnaryPlusNodeGen(JavaScriptNode operand) {
        super(operand);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedUnaryNode) */ && operandNodeValue instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject operandNodeValue_ = (JSOverloadedOperatorsObject) operandNodeValue;
            return doOverloaded(operandNodeValue_, this.overloaded_overloadedOperatorNode_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doDefault(Object, JSToNumberNode) */) {
            if ((!(JSGuards.hasOverloadedOperators(operandNodeValue)))) {
                return doDefault(operandNodeValue, this.default_toNumberNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedUnaryNode) */ && operandNodeValue_ instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject operandNodeValue__ = (JSOverloadedOperatorsObject) operandNodeValue_;
            return doOverloaded(operandNodeValue__, this.overloaded_overloadedOperatorNode_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doDefault(Object, JSToNumberNode) */) {
            if ((!(JSGuards.hasOverloadedOperators(operandNodeValue_)))) {
                return doDefault(operandNodeValue_, this.default_toNumberNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (operandNodeValue instanceof JSOverloadedOperatorsObject) {
                JSOverloadedOperatorsObject operandNodeValue_ = (JSOverloadedOperatorsObject) operandNodeValue;
                this.overloaded_overloadedOperatorNode_ = super.insert((JSOverloadedUnaryNode.create(getOverloadedOperatorName())));
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedUnaryNode) */;
                lock.unlock();
                hasLock = false;
                return doOverloaded(operandNodeValue_, this.overloaded_overloadedOperatorNode_);
            }
            if ((!(JSGuards.hasOverloadedOperators(operandNodeValue)))) {
                this.default_toNumberNode_ = super.insert((JSToNumberNode.create()));
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDefault(Object, JSToNumberNode) */;
                lock.unlock();
                hasLock = false;
                return doDefault(operandNodeValue, this.default_toNumberNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.operandNode}, operandNodeValue);
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedUnaryNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.overloaded_overloadedOperatorNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDefault";
        if ((state_0 & 0b10) != 0 /* is-state_0 doDefault(Object, JSToNumberNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.default_toNumberNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSUnaryPlusNode create(JavaScriptNode operand) {
        return new JSUnaryPlusNodeGen(operand);
    }

}
