// CheckStyle: start generated
package com.oracle.truffle.js.builtins.math;

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
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(HypotNode.class)
public final class HypotNodeGen extends HypotNode implements Introspection.Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private int state_0_;

    private HypotNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        super(context, builtin);
        this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
    }

    @Override
    public JavaScriptNode[] getArguments() {
        return new JavaScriptNode[] {this.arguments0_};
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if (state_0 != 0 /* is-state_0 hypot(Object[]) */ && arguments0Value_ instanceof Object[]) {
            Object[] arguments0Value__ = (Object[]) arguments0Value_;
            return hypot(arguments0Value__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if (state_0 != 0 /* is-state_0 hypot(Object[]) */ && arguments0Value_ instanceof Object[]) {
            Object[] arguments0Value__ = (Object[]) arguments0Value_;
            return hypot(arguments0Value__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeDouble(frameValue);
        return;
    }

    private double executeAndSpecialize(Object arguments0Value) {
        int state_0 = this.state_0_;
        if (arguments0Value instanceof Object[]) {
            Object[] arguments0Value_ = (Object[]) arguments0Value;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 hypot(Object[]) */;
            return hypot(arguments0Value_);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
        s[0] = "hypot";
        if (state_0 != 0 /* is-state_0 hypot(Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static HypotNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new HypotNodeGen(context, builtin, arguments);
    }

}
