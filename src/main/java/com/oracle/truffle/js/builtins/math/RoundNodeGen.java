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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RoundNode.class)
public final class RoundNodeGen extends RoundNode implements Introspection.Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile roundDouble_profileA_;
    @CompilationFinal private ConditionProfile roundDouble_profileB_;

    private RoundNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if ((state_0 & 0b1110) == 0 /* only-active roundInt(int) */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
            return execute_int0(state_0, frameValue);
        } else if ((state_0 & 0b1) == 0 /* only-active roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
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
        assert (state_0 & 0b1) != 0 /* is-state_0 roundInt(int) */;
        return RoundNode.roundInt(arguments0Value_);
    }

    private Object execute_double1(int state_0, VirtualFrame frameValue) {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state_0 & 0b10110000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 roundCornercase(double) */) {
            if ((RoundNode.isCornercase(arguments0Value_))) {
                return RoundNode.roundCornercase(arguments0Value_);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 roundDoubleInt(double) */) {
            if ((!(RoundNode.isCornercase(arguments0Value_))) && (JSGuards.isDoubleInInt32Range(arguments0Value_))) {
                try {
                    return roundDoubleInt(arguments0Value_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-exclude roundDoubleInt(double) */;
                        this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 roundDoubleInt(double) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(arguments0Value_);
                }
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 roundDouble(double, ConditionProfile, ConditionProfile) */) {
            if ((!(RoundNode.isCornercase(arguments0Value_)))) {
                return roundDouble(arguments0Value_, this.roundDouble_profileA_, this.roundDouble_profileB_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) ? (Object) arguments0Value_long : ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) ? (Object) arguments0Value_int : (Object) arguments0Value_)));
    }

    private Object execute_generic2(int state_0, VirtualFrame frameValue) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 roundInt(int) */ && arguments0Value_ instanceof Integer) {
            int arguments0Value__ = (int) arguments0Value_;
            return RoundNode.roundInt(arguments0Value__);
        }
        if ((state_0 & 0b1110) != 0 /* is-state_0 roundCornercase(double) || roundDoubleInt(double) || roundDouble(double, ConditionProfile, ConditionProfile) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_);
            if ((state_0 & 0b10) != 0 /* is-state_0 roundCornercase(double) */) {
                if ((RoundNode.isCornercase(arguments0Value__))) {
                    return RoundNode.roundCornercase(arguments0Value__);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 roundDoubleInt(double) */) {
                if ((!(RoundNode.isCornercase(arguments0Value__))) && (JSGuards.isDoubleInInt32Range(arguments0Value__))) {
                    try {
                        return roundDoubleInt(arguments0Value__);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b1 /* add-exclude roundDoubleInt(double) */;
                            this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 roundDoubleInt(double) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(arguments0Value__);
                    }
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 roundDouble(double, ConditionProfile, ConditionProfile) */) {
                if ((!(RoundNode.isCornercase(arguments0Value__)))) {
                    return roundDouble(arguments0Value__, this.roundDouble_profileA_, this.roundDouble_profileB_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state_0 & 0b10110000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult()));
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 roundCornercase(double) */) {
            if ((RoundNode.isCornercase(arguments0Value_))) {
                return RoundNode.roundCornercase(arguments0Value_);
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 roundDouble(double, ConditionProfile, ConditionProfile) */) {
            if ((!(RoundNode.isCornercase(arguments0Value_)))) {
                return roundDouble(arguments0Value_, this.roundDouble_profileA_, this.roundDouble_profileB_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) ? (Object) arguments0Value_long : ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) ? (Object) arguments0Value_int : (Object) arguments0Value_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b100) == 0 /* only-active roundInt(int) */ && ((state_0 & 0b101) != 0  /* is-not roundInt(int) && roundDoubleInt(double) */)) {
            return executeInt_int3(state_0, frameValue);
        } else if ((state_0 & 0b1) == 0 /* only-active roundDoubleInt(double) */ && ((state_0 & 0b101) != 0  /* is-not roundInt(int) && roundDoubleInt(double) */)) {
            return executeInt_double4(state_0, frameValue);
        } else {
            return executeInt_generic5(state_0, frameValue);
        }
    }

    private int executeInt_int3(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 roundInt(int) */;
        return RoundNode.roundInt(arguments0Value_);
    }

    private int executeInt_double4(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state_0 & 0b10110000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 roundDoubleInt(double) */;
        if ((!(RoundNode.isCornercase(arguments0Value_))) && (JSGuards.isDoubleInInt32Range(arguments0Value_))) {
            try {
                return roundDoubleInt(arguments0Value_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-exclude roundDoubleInt(double) */;
                    this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 roundDoubleInt(double) */;
                } finally {
                    lock.unlock();
                }
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) ? (Object) arguments0Value_long : ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) ? (Object) arguments0Value_int : (Object) arguments0Value_))));
    }

    private int executeInt_generic5(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 roundInt(int) */ && arguments0Value_ instanceof Integer) {
            int arguments0Value__ = (int) arguments0Value_;
            return RoundNode.roundInt(arguments0Value__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 roundDoubleInt(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_);
            if ((!(RoundNode.isCornercase(arguments0Value__))) && (JSGuards.isDoubleInInt32Range(arguments0Value__))) {
                try {
                    return roundDoubleInt(arguments0Value__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-exclude roundDoubleInt(double) */;
                        this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 roundDoubleInt(double) */;
                    } finally {
                        lock.unlock();
                    }
                    return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value__));
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b1010) == 0 /* only-active roundInt(int) && roundDoubleInt(double) */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b101) == 0 /* only-active roundCornercase(double) && roundDouble(double, ConditionProfile, ConditionProfile) */ && ((state_0 & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */)) {
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
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (arguments0Value instanceof Integer) {
                int arguments0Value_ = (int) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 roundInt(int) */;
                lock.unlock();
                hasLock = false;
                return RoundNode.roundInt(arguments0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    if ((RoundNode.isCornercase(arguments0Value_))) {
                        state_0 = (state_0 | (doubleCast0 << 4) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 roundCornercase(double) */;
                        lock.unlock();
                        hasLock = false;
                        return RoundNode.roundCornercase(arguments0Value_);
                    }
                    if ((exclude) == 0 /* is-not-exclude roundDoubleInt(double) */) {
                        if ((!(RoundNode.isCornercase(arguments0Value_))) && (JSGuards.isDoubleInInt32Range(arguments0Value_))) {
                            state_0 = (state_0 | (doubleCast0 << 4) /* set-implicit-state_0 0:double */);
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 roundDoubleInt(double) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return roundDoubleInt(arguments0Value_);
                            } catch (ArithmeticException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b1 /* add-exclude roundDoubleInt(double) */;
                                    this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 roundDoubleInt(double) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(arguments0Value_);
                            }
                        }
                    }
                    if ((!(RoundNode.isCornercase(arguments0Value_)))) {
                        this.roundDouble_profileA_ = (ConditionProfile.createBinaryProfile());
                        this.roundDouble_profileB_ = (ConditionProfile.createBinaryProfile());
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude roundDoubleInt(double) */;
                        state_0 = state_0 & 0xfffffffb /* remove-state_0 roundDoubleInt(double) */;
                        state_0 = (state_0 | (doubleCast0 << 4) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 roundDouble(double, ConditionProfile, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return roundDouble(arguments0Value_, this.roundDouble_profileA_, this.roundDouble_profileB_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111) & ((state_0 & 0b1111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[5];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "roundInt";
        if ((state_0 & 0b1) != 0 /* is-state_0 roundInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "roundCornercase";
        if ((state_0 & 0b10) != 0 /* is-state_0 roundCornercase(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "roundDoubleInt";
        if ((state_0 & 0b100) != 0 /* is-state_0 roundDoubleInt(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if (exclude != 0 /* is-exclude roundDoubleInt(double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "roundDouble";
        if ((state_0 & 0b1000) != 0 /* is-state_0 roundDouble(double, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.roundDouble_profileA_, this.roundDouble_profileB_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static RoundNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new RoundNodeGen(context, builtin, arguments);
    }

}
