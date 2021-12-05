// CheckStyle: start generated
package com.oracle.truffle.js.nodes.promise;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSPromise;

@GeneratedBy(UnwrapPromiseNode.class)
public final class UnwrapPromiseNodeGen extends UnwrapPromiseNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private UnwrapPromiseNodeGen(JSContext context) {
        super(context);
    }

    @Override
    protected Object execute(DynamicObject arg0Value, int arg1Value, Object arg2Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 fulfilled(DynamicObject, int, Object) || rejected(DynamicObject, int, Object) || pending(DynamicObject, int, Object) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 fulfilled(DynamicObject, int, Object) */) {
                if ((arg1Value == JSPromise.FULFILLED)) {
                    return UnwrapPromiseNode.fulfilled(arg0Value, arg1Value, arg2Value);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 rejected(DynamicObject, int, Object) */) {
                if ((arg1Value == JSPromise.REJECTED)) {
                    return UnwrapPromiseNode.rejected(arg0Value, arg1Value, arg2Value);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 pending(DynamicObject, int, Object) */) {
                if ((arg1Value == JSPromise.PENDING)) {
                    return UnwrapPromiseNode.pending(arg0Value, arg1Value, arg2Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private Object executeAndSpecialize(DynamicObject arg0Value, int arg1Value, Object arg2Value) {
        int state_0 = this.state_0_;
        if ((arg1Value == JSPromise.FULFILLED)) {
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 fulfilled(DynamicObject, int, Object) */;
            return UnwrapPromiseNode.fulfilled(arg0Value, arg1Value, arg2Value);
        }
        if ((arg1Value == JSPromise.REJECTED)) {
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 rejected(DynamicObject, int, Object) */;
            return UnwrapPromiseNode.rejected(arg0Value, arg1Value, arg2Value);
        }
        if ((arg1Value == JSPromise.PENDING)) {
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 pending(DynamicObject, int, Object) */;
            return UnwrapPromiseNode.pending(arg0Value, arg1Value, arg2Value);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
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
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "fulfilled";
        if ((state_0 & 0b1) != 0 /* is-state_0 fulfilled(DynamicObject, int, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "rejected";
        if ((state_0 & 0b10) != 0 /* is-state_0 rejected(DynamicObject, int, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "pending";
        if ((state_0 & 0b100) != 0 /* is-state_0 pending(DynamicObject, int, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static UnwrapPromiseNode create(JSContext context) {
        return new UnwrapPromiseNodeGen(context);
    }

}
