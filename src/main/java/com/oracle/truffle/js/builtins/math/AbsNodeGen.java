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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(AbsNode.class)
public final class AbsNodeGen extends AbsNode implements Introspection.Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile absInt_negative_;

    private AbsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if ((state_0 & 0b1100) == 0 /* only-active absInt(int, ConditionProfile) && absIntSpecial(int) */ && ((state_0 & 0b1111) != 0  /* is-not absInt(int, ConditionProfile) && absIntSpecial(int) && absDouble(double) && absGeneric(Object) */)) {
            return execute_int0(state_0, frameValue);
        } else if ((state_0 & 0b1011) == 0 /* only-active absDouble(double) */ && ((state_0 & 0b1111) != 0  /* is-not absInt(int, ConditionProfile) && absIntSpecial(int) && absDouble(double) && absGeneric(Object) */)) {
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
        if ((state_0 & 0b1) != 0 /* is-state_0 absInt(int, ConditionProfile) */) {
            try {
                return AbsNode.absInt(arguments0Value_, this.absInt_negative_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-exclude absInt(int, ConditionProfile) */;
                    this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 absInt(int, ConditionProfile) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(arguments0Value_);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 absIntSpecial(int) */) {
            return AbsNode.absIntSpecial(arguments0Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    private Object execute_double1(int state_0, VirtualFrame frameValue) {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not absInt(int, ConditionProfile) && absIntSpecial(int) && absDouble(double) && absGeneric(Object) */)) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not absInt(int, ConditionProfile) && absIntSpecial(int) && absDouble(double) && absGeneric(Object) */)) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state_0 & 0b10110000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not absInt(int, ConditionProfile) && absIntSpecial(int) && absDouble(double) && absGeneric(Object) */)) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 absDouble(double) */;
        return AbsNode.absDouble(arguments0Value_);
    }

    private Object execute_generic2(int state_0, VirtualFrame frameValue) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b11) != 0 /* is-state_0 absInt(int, ConditionProfile) || absIntSpecial(int) */ && arguments0Value_ instanceof Integer) {
            int arguments0Value__ = (int) arguments0Value_;
            if ((state_0 & 0b1) != 0 /* is-state_0 absInt(int, ConditionProfile) */) {
                try {
                    return AbsNode.absInt(arguments0Value__, this.absInt_negative_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-exclude absInt(int, ConditionProfile) */;
                        this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 absInt(int, ConditionProfile) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(arguments0Value__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 absIntSpecial(int) */) {
                return AbsNode.absIntSpecial(arguments0Value__);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 absDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_);
            return AbsNode.absDouble(arguments0Value__);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 absGeneric(Object) */) {
            return absGeneric(arguments0Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1100) == 0 /* only-active absIntSpecial(int) */ && ((state_0 & 0b1110) != 0  /* is-not absIntSpecial(int) && absDouble(double) && absGeneric(Object) */)) {
            return executeDouble_int3(state_0, frameValue);
        } else if ((state_0 & 0b1010) == 0 /* only-active absDouble(double) */ && ((state_0 & 0b1110) != 0  /* is-not absIntSpecial(int) && absDouble(double) && absGeneric(Object) */)) {
            return executeDouble_double4(state_0, frameValue);
        } else {
            return executeDouble_generic5(state_0, frameValue);
        }
    }

    private double executeDouble_int3(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult()));
        }
        assert (state_0 & 0b10) != 0 /* is-state_0 absIntSpecial(int) */;
        return AbsNode.absIntSpecial(arguments0Value_);
    }

    private double executeDouble_double4(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not absInt(int, ConditionProfile) && absIntSpecial(int) && absDouble(double) && absGeneric(Object) */)) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not absInt(int, ConditionProfile) && absIntSpecial(int) && absDouble(double) && absGeneric(Object) */)) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state_0 & 0b10110000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not absInt(int, ConditionProfile) && absIntSpecial(int) && absDouble(double) && absGeneric(Object) */)) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult()));
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 absDouble(double) */;
        return AbsNode.absDouble(arguments0Value_);
    }

    private double executeDouble_generic5(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b10) != 0 /* is-state_0 absIntSpecial(int) */ && arguments0Value_ instanceof Integer) {
            int arguments0Value__ = (int) arguments0Value_;
            return AbsNode.absIntSpecial(arguments0Value__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 absDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_);
            return AbsNode.absDouble(arguments0Value__);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 absGeneric(Object) */) {
            return absGeneric(arguments0Value_);
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
        if ((state_0 & 0b1) != 0 /* is-state_0 absInt(int, ConditionProfile) */) {
            try {
                return AbsNode.absInt(arguments0Value_, this.absInt_negative_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-exclude absInt(int, ConditionProfile) */;
                    this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 absInt(int, ConditionProfile) */;
                } finally {
                    lock.unlock();
                }
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b1110) == 0 /* only-active absInt(int, ConditionProfile) */ && ((state_0 & 0b1111) != 0  /* is-not absInt(int, ConditionProfile) && absIntSpecial(int) && absDouble(double) && absGeneric(Object) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b1) == 0 /* only-active absIntSpecial(int) && absDouble(double) && absGeneric(Object) */ && ((state_0 & 0b1111) != 0  /* is-not absInt(int, ConditionProfile) && absIntSpecial(int) && absDouble(double) && absGeneric(Object) */)) {
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
                if ((exclude) == 0 /* is-not-exclude absInt(int, ConditionProfile) */) {
                    this.absInt_negative_ = (ConditionProfile.createBinaryProfile());
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 absInt(int, ConditionProfile) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return AbsNode.absInt(arguments0Value_, this.absInt_negative_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b1 /* add-exclude absInt(int, ConditionProfile) */;
                            this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 absInt(int, ConditionProfile) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(arguments0Value_);
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 absIntSpecial(int) */;
                lock.unlock();
                hasLock = false;
                return AbsNode.absIntSpecial(arguments0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    state_0 = (state_0 | (doubleCast0 << 4) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 absDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return AbsNode.absDouble(arguments0Value_);
                }
            }
            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 absGeneric(Object) */;
            lock.unlock();
            hasLock = false;
            return absGeneric(arguments0Value);
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
        s[0] = "absInt";
        if ((state_0 & 0b1) != 0 /* is-state_0 absInt(int, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.absInt_negative_));
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude absInt(int, ConditionProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "absIntSpecial";
        if ((state_0 & 0b10) != 0 /* is-state_0 absIntSpecial(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "absDouble";
        if ((state_0 & 0b100) != 0 /* is-state_0 absDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "absGeneric";
        if ((state_0 & 0b1000) != 0 /* is-state_0 absGeneric(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static AbsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new AbsNodeGen(context, builtin, arguments);
    }

}
