// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

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
import com.oracle.truffle.js.runtime.JSRuntime;

@GeneratedBy(ArrayCreateNode.class)
public final class ArrayCreateNodeGen extends ArrayCreateNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private ArrayCreateNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public DynamicObject execute(long arg0Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doDefault(long) || doLargeLength(long) || doInvalidLength(long) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doDefault(long) */) {
                if ((JSRuntime.isValidArrayLength(arg0Value)) && (arg0Value <= Integer.MAX_VALUE)) {
                    return doDefault(arg0Value);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doLargeLength(long) */) {
                if ((JSRuntime.isValidArrayLength(arg0Value)) && (arg0Value > Integer.MAX_VALUE)) {
                    return doLargeLength(arg0Value);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doInvalidLength(long) */) {
                if ((!(JSRuntime.isValidArrayLength(arg0Value)))) {
                    return doInvalidLength(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private DynamicObject executeAndSpecialize(long arg0Value) {
        int state_0 = this.state_0_;
        if ((JSRuntime.isValidArrayLength(arg0Value)) && (arg0Value <= Integer.MAX_VALUE)) {
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doDefault(long) */;
            return doDefault(arg0Value);
        }
        if ((JSRuntime.isValidArrayLength(arg0Value)) && (arg0Value > Integer.MAX_VALUE)) {
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doLargeLength(long) */;
            return doLargeLength(arg0Value);
        }
        if ((!(JSRuntime.isValidArrayLength(arg0Value)))) {
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doInvalidLength(long) */;
            return doInvalidLength(arg0Value);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
        s[0] = "doDefault";
        if ((state_0 & 0b1) != 0 /* is-state_0 doDefault(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doLargeLength";
        if ((state_0 & 0b10) != 0 /* is-state_0 doLargeLength(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doInvalidLength";
        if ((state_0 & 0b100) != 0 /* is-state_0 doInvalidLength(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static ArrayCreateNode create(JSContext context) {
        return new ArrayCreateNodeGen(context);
    }

}
