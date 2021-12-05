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

@GeneratedBy(SignNode.class)
public final class SignNodeGen extends SignNode implements Introspection.Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private int state_0_;

    private SignNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if ((state_0 & 0b110) == 0 /* only-active sign(int) */ && ((state_0 & 0b111) != 0  /* is-not sign(int) && sign(double) && sign(Object) */)) {
            return execute_int0(state_0, frameValue);
        } else if ((state_0 & 0b101) == 0 /* only-active sign(double) */ && ((state_0 & 0b111) != 0  /* is-not sign(int) && sign(double) && sign(Object) */)) {
            return execute_double1(state_0, frameValue);
        } else {
            return execute_generic2(state_0, frameValue);
        }
    }

    private Object execute_int0(int state_0, VirtualFrame frameValue) {
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 sign(int) */;
        return SignNode.sign(arguments0Value_);
    }

    private Object execute_double1(int state_0, VirtualFrame frameValue) {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state_0 & 0b1110000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not sign(int) && sign(double) && sign(Object) */)) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state_0 & 0b1101000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not sign(int) && sign(double) && sign(Object) */)) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state_0 & 0b1011000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not sign(int) && sign(double) && sign(Object) */)) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b10) != 0 /* is-state_0 sign(double) */;
        return SignNode.sign(arguments0Value_);
    }

    private Object execute_generic2(int state_0, VirtualFrame frameValue) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 sign(int) */ && arguments0Value_ instanceof Integer) {
            int arguments0Value__ = (int) arguments0Value_;
            return SignNode.sign(arguments0Value__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 sign(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value_);
            return SignNode.sign(arguments0Value__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 sign(Object) */) {
            return sign(arguments0Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b100) == 0 /* only-active sign(double) */ && ((state_0 & 0b110) != 0  /* is-not sign(double) && sign(Object) */)) {
            return executeDouble_double3(state_0, frameValue);
        } else {
            return executeDouble_generic4(state_0, frameValue);
        }
    }

    private double executeDouble_double3(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state_0 & 0b1110000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not sign(int) && sign(double) && sign(Object) */)) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state_0 & 0b1101000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not sign(int) && sign(double) && sign(Object) */)) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state_0 & 0b1011000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not sign(int) && sign(double) && sign(Object) */)) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult()));
        }
        assert (state_0 & 0b10) != 0 /* is-state_0 sign(double) */;
        return SignNode.sign(arguments0Value_);
    }

    private double executeDouble_generic4(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b10) != 0 /* is-state_0 sign(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value_);
            return SignNode.sign(arguments0Value__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 sign(Object) */) {
            return sign(arguments0Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        if ((state_0 & 0b1) != 0 /* is-state_0 sign(int) */) {
            return SignNode.sign(arguments0Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b110) == 0 /* only-active sign(int) */ && ((state_0 & 0b111) != 0  /* is-not sign(int) && sign(double) && sign(Object) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b1) == 0 /* only-active sign(double) && sign(Object) */ && ((state_0 & 0b111) != 0  /* is-not sign(int) && sign(double) && sign(Object) */)) {
                executeDouble(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Object arguments0Value) {
        int state_0 = this.state_0_;
        if (arguments0Value instanceof Integer) {
            int arguments0Value_ = (int) arguments0Value;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 sign(int) */;
            return SignNode.sign(arguments0Value_);
        }
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                state_0 = (state_0 | (doubleCast0 << 3) /* set-implicit-state_0 0:double */);
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 sign(double) */;
                return SignNode.sign(arguments0Value_);
            }
        }
        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 sign(Object) */;
        return sign(arguments0Value);
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
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
        s[0] = "sign";
        if ((state_0 & 0b1) != 0 /* is-state_0 sign(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "sign";
        if ((state_0 & 0b10) != 0 /* is-state_0 sign(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "sign";
        if ((state_0 & 0b100) != 0 /* is-state_0 sign(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static SignNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new SignNodeGen(context, builtin, arguments);
    }

}
