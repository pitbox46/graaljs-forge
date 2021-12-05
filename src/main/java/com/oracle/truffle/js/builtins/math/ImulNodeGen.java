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
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(ImulNode.class)
public final class ImulNodeGen extends ImulNode implements Introspection.Provider {

    @Child private JavaScriptNode arguments0_;
    @Child private JavaScriptNode arguments1_;
    @CompilationFinal private int state_0_;

    private ImulNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        super(context, builtin);
        this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
    }

    @Override
    public JavaScriptNode[] getArguments() {
        return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object arguments1Value = this.arguments1_.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), arguments1Value);
        }
        int arguments1Value_;
        try {
            arguments1Value_ = this.arguments1_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(arguments0Value_, ex.getResult());
        }
        if (state_0 != 0 /* is-state_0 imul(int, int) */) {
            return ImulNode.imul(arguments0Value_, arguments1Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_, arguments1Value_);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object arguments1Value = this.arguments1_.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), arguments1Value);
        }
        int arguments1Value_;
        try {
            arguments1Value_ = this.arguments1_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(arguments0Value_, ex.getResult());
        }
        if (state_0 != 0 /* is-state_0 imul(int, int) */) {
            return ImulNode.imul(arguments0Value_, arguments1Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_, arguments1Value_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeInt(frameValue);
        return;
    }

    private int executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
        int state_0 = this.state_0_;
        if (arguments0Value instanceof Integer) {
            int arguments0Value_ = (int) arguments0Value;
            if (arguments1Value instanceof Integer) {
                int arguments1Value_ = (int) arguments1Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 imul(int, int) */;
                return ImulNode.imul(arguments0Value_, arguments1Value_);
            }
        }
        throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
        s[0] = "imul";
        if (state_0 != 0 /* is-state_0 imul(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static ImulNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new ImulNodeGen(context, builtin, arguments);
    }

}
