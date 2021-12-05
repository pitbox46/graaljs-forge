// CheckStyle: start generated
package com.oracle.truffle.js.nodes.arguments;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(ArgumentsObjectNode.class)
public final class ArgumentsObjectNodeGen extends ArgumentsObjectNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private ArgumentsObjectNodeGen(JSContext context, boolean strict, int leadingArgCount, int trailingArgCount) {
        super(context, strict, leadingArgCount, trailingArgCount);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doStrict(VirtualFrame) */) {
            if ((isStrict(frameValue))) {
                return doStrict(frameValue);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doNonStrict(VirtualFrame) */) {
            if ((!(isStrict(frameValue)))) {
                return doNonStrict(frameValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private DynamicObject executeAndSpecialize(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((isStrict(frameValue))) {
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doStrict(VirtualFrame) */;
            return doStrict(frameValue);
        }
        if ((!(isStrict(frameValue)))) {
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doNonStrict(VirtualFrame) */;
            return doNonStrict(frameValue);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {});
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
        s[0] = "doStrict";
        if ((state_0 & 0b1) != 0 /* is-state_0 doStrict(VirtualFrame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doNonStrict";
        if ((state_0 & 0b10) != 0 /* is-state_0 doNonStrict(VirtualFrame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static ArgumentsObjectNode create(JSContext context, boolean strict, int leadingArgCount, int trailingArgCount) {
        return new ArgumentsObjectNodeGen(context, strict, leadingArgCount, trailingArgCount);
    }

}
