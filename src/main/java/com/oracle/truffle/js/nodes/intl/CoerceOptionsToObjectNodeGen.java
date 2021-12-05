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
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(CoerceOptionsToObjectNode.class)
public final class CoerceOptionsToObjectNodeGen extends CoerceOptionsToObjectNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private JSToObjectNode fromOtherThanUndefined_toObjectNode_;

    private CoerceOptionsToObjectNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public DynamicObject execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 fromUndefined(Object) || fromOtherThanUndefined(Object, JSToObjectNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 fromUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return fromUndefined(arg0Value);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 fromOtherThanUndefined(Object, JSToObjectNode) */) {
                if ((!(JSGuards.isUndefined(arg0Value)))) {
                    return fromOtherThanUndefined(arg0Value, this.fromOtherThanUndefined_toObjectNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private DynamicObject executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 fromUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return fromUndefined(arg0Value);
            }
            if ((!(JSGuards.isUndefined(arg0Value)))) {
                this.fromOtherThanUndefined_toObjectNode_ = super.insert((JSToObjectNode.createToObject(getContext())));
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 fromOtherThanUndefined(Object, JSToObjectNode) */;
                lock.unlock();
                hasLock = false;
                return fromOtherThanUndefined(arg0Value, this.fromOtherThanUndefined_toObjectNode_);
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
        s[0] = "fromUndefined";
        if ((state_0 & 0b1) != 0 /* is-state_0 fromUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "fromOtherThanUndefined";
        if ((state_0 & 0b10) != 0 /* is-state_0 fromOtherThanUndefined(Object, JSToObjectNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.fromOtherThanUndefined_toObjectNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static CoerceOptionsToObjectNode create(JSContext context) {
        return new CoerceOptionsToObjectNodeGen(context);
    }

}
