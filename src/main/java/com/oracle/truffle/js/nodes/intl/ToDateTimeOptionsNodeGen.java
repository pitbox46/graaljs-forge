// CheckStyle: start generated
package com.oracle.truffle.js.nodes.intl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.access.CreateObjectNode;
import com.oracle.truffle.js.nodes.access.CreateObjectNode.CreateObjectWithPrototypeNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ToDateTimeOptionsNode.class)
public final class ToDateTimeOptionsNodeGen extends ToDateTimeOptionsNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private CreateObjectWithPrototypeNode fromOtherThenUndefined_createObjectNode_;

    private ToDateTimeOptionsNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public DynamicObject execute(Object arg0Value, String arg1Value, String arg2Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 fromUndefined(Object, String, String) || fromOtherThenUndefined(Object, String, String, CreateObjectWithPrototypeNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 fromUndefined(Object, String, String) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return fromUndefined(arg0Value, arg1Value, arg2Value);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 fromOtherThenUndefined(Object, String, String, CreateObjectWithPrototypeNode) */) {
                if ((!(JSGuards.isUndefined(arg0Value)))) {
                    return fromOtherThenUndefined(arg0Value, arg1Value, arg2Value, this.fromOtherThenUndefined_createObjectNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private DynamicObject executeAndSpecialize(Object arg0Value, String arg1Value, String arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 fromUndefined(Object, String, String) */;
                lock.unlock();
                hasLock = false;
                return fromUndefined(arg0Value, arg1Value, arg2Value);
            }
            if ((!(JSGuards.isUndefined(arg0Value)))) {
                this.fromOtherThenUndefined_createObjectNode_ = super.insert((CreateObjectNode.createOrdinaryWithPrototype(context)));
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 fromOtherThenUndefined(Object, String, String, CreateObjectWithPrototypeNode) */;
                lock.unlock();
                hasLock = false;
                return fromOtherThenUndefined(arg0Value, arg1Value, arg2Value, this.fromOtherThenUndefined_createObjectNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b11) & ((state_0 & 0b11) - 1)) == 0 /* is-single-state_0  */) {
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
        s[0] = "fromUndefined";
        if ((state_0 & 0b1) != 0 /* is-state_0 fromUndefined(Object, String, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "fromOtherThenUndefined";
        if ((state_0 & 0b10) != 0 /* is-state_0 fromOtherThenUndefined(Object, String, String, CreateObjectWithPrototypeNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.fromOtherThenUndefined_createObjectNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static ToDateTimeOptionsNode create(JSContext context) {
        return new ToDateTimeOptionsNodeGen(context);
    }

}
