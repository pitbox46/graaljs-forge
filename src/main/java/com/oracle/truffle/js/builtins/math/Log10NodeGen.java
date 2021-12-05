// CheckStyle: start generated
package com.oracle.truffle.js.builtins.math;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(Log10Node.class)
public final class Log10NodeGen extends Log10Node implements Introspection.Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private int state_0_;

    private Log10NodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if ((state_0 & 0b10) == 0 /* only-active log10(double) */ && ((state_0 & 0b11) != 0  /* is-not log10(double) && log10(Object) */)) {
            return execute_double0(state_0, frameValue);
        } else {
            return execute_generic1(state_0, frameValue);
        }
    }

    private Object execute_double0(int state_0, VirtualFrame frameValue) {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state_0 & 0b111000) == 0 /* only-active 0:double */ && ((state_0 & 0b11) != 0  /* is-not log10(double) && log10(Object) */)) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state_0 & 0b110100) == 0 /* only-active 0:double */ && ((state_0 & 0b11) != 0  /* is-not log10(double) && log10(Object) */)) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state_0 & 0b101100) == 0 /* only-active 0:double */ && ((state_0 & 0b11) != 0  /* is-not log10(double) && log10(Object) */)) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100) >>> 2 /* extract-implicit-state_0 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 log10(double) */;
        return Log10Node.log10(arguments0Value_);
    }

    private Object execute_generic1(int state_0, VirtualFrame frameValue) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 log10(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100) >>> 2 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b111100) >>> 2 /* extract-implicit-state_0 0:double */, arguments0Value_);
            return Log10Node.log10(arguments0Value__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 log10(Object) */) {
            return log10(arguments0Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b10) == 0 /* only-active log10(double) */ && ((state_0 & 0b11) != 0  /* is-not log10(double) && log10(Object) */)) {
            return executeDouble_double2(state_0, frameValue);
        } else {
            return executeDouble_generic3(state_0, frameValue);
        }
    }

    private double executeDouble_double2(int state_0, VirtualFrame frameValue) {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state_0 & 0b111000) == 0 /* only-active 0:double */ && ((state_0 & 0b11) != 0  /* is-not log10(double) && log10(Object) */)) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state_0 & 0b110100) == 0 /* only-active 0:double */ && ((state_0 & 0b11) != 0  /* is-not log10(double) && log10(Object) */)) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state_0 & 0b101100) == 0 /* only-active 0:double */ && ((state_0 & 0b11) != 0  /* is-not log10(double) && log10(Object) */)) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100) >>> 2 /* extract-implicit-state_0 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 log10(double) */;
        return Log10Node.log10(arguments0Value_);
    }

    private double executeDouble_generic3(int state_0, VirtualFrame frameValue) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 log10(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100) >>> 2 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b111100) >>> 2 /* extract-implicit-state_0 0:double */, arguments0Value_);
            return Log10Node.log10(arguments0Value__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 log10(Object) */) {
            return log10(arguments0Value_);
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
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                state_0 = (state_0 | (doubleCast0 << 2) /* set-implicit-state_0 0:double */);
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 log10(double) */;
                return Log10Node.log10(arguments0Value_);
            }
        }
        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 log10(Object) */;
        return log10(arguments0Value);
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
        s[0] = "log10";
        if ((state_0 & 0b1) != 0 /* is-state_0 log10(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "log10";
        if ((state_0 & 0b10) != 0 /* is-state_0 log10(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static Log10Node create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new Log10NodeGen(context, builtin, arguments);
    }

}
