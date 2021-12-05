// CheckStyle: start generated
package com.oracle.truffle.js.builtins.math;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.SlowPathException;
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

@GeneratedBy(PowNode.class)
public final class PowNodeGen extends PowNode implements Introspection.Provider {

    @Child private JavaScriptNode arguments0_;
    @Child private JavaScriptNode arguments1_;
    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile pow3_branch1_;
    @CompilationFinal private ConditionProfile pow3_branch2_;
    @Child private PowNode pow1_powNode_;

    private PowNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if ((state_0 & 0b1000) == 0 /* only-active pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
            return execute_double_double0(state_0, frameValue);
        } else {
            return execute_generic1(state_0, frameValue);
        }
    }

    private Object execute_double_double0(int state_0, VirtualFrame frameValue) {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state_0 & 0b10110000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            Object arguments1Value = this.arguments1_.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), arguments1Value);
        }
        int arguments1Value_int = 0;
        long arguments1Value_long = 0L;
        double arguments1Value_;
        try {
            if ((state_0 & 0b111000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                arguments1Value_long = this.arguments1_.executeLong(frameValue);
                arguments1Value_ = JSTypes.longToDouble(arguments1Value_long);
            } else if ((state_0 & 0b110100000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                arguments1Value_int = this.arguments1_.executeInt(frameValue);
                arguments1Value_ = JSTypes.intToDouble(arguments1Value_int);
            } else if ((state_0 & 0b101100000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                arguments1Value_ = this.arguments1_.executeDouble(frameValue);
            } else {
                Object arguments1Value__ = this.arguments1_.execute(frameValue);
                arguments1Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 1:double */, arguments1Value__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */) ? (Object) arguments0Value_long : ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */) ? (Object) arguments0Value_int : (Object) arguments0Value_)), ex.getResult());
        }
        if ((state_0 & 0b1) != 0 /* is-state_0 pow(double, double) */) {
            try {
                return pow(arguments0Value_, arguments1Value_);
            } catch (SlowPathException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-exclude pow(double, double) */;
                    this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 pow(double, double) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(arguments0Value_, arguments1Value_);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 pow2(double, double) */) {
            try {
                return pow2(arguments0Value_, arguments1Value_);
            } catch (SlowPathException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b10 /* add-exclude pow2(double, double) */;
                    this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 pow2(double, double) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(arguments0Value_, arguments1Value_);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 pow3(double, double, ConditionProfile, ConditionProfile) */) {
            return pow3(arguments0Value_, arguments1Value_, this.pow3_branch1_, this.pow3_branch2_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */) ? (Object) arguments0Value_long : ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */) ? (Object) arguments0Value_int : (Object) arguments0Value_)), ((state_0 & 0b111000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */) ? (Object) arguments1Value_long : ((state_0 & 0b110100000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */) ? (Object) arguments1Value_int : (Object) arguments1Value_)));
    }

    private Object execute_generic1(int state_0, VirtualFrame frameValue) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        Object arguments1Value_ = this.arguments1_.execute(frameValue);
        if ((state_0 & 0b111) != 0 /* is-state_0 pow(double, double) || pow2(double, double) || pow3(double, double, ConditionProfile, ConditionProfile) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_);
            if (JSTypesGen.isImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 1:double */, arguments1Value_)) {
                double arguments1Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 1:double */, arguments1Value_);
                if ((state_0 & 0b1) != 0 /* is-state_0 pow(double, double) */) {
                    try {
                        return pow(arguments0Value__, arguments1Value__);
                    } catch (SlowPathException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b1 /* add-exclude pow(double, double) */;
                            this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 pow(double, double) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 pow2(double, double) */) {
                    try {
                        return pow2(arguments0Value__, arguments1Value__);
                    } catch (SlowPathException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b10 /* add-exclude pow2(double, double) */;
                            this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 pow2(double, double) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 pow3(double, double, ConditionProfile, ConditionProfile) */) {
                    return pow3(arguments0Value__, arguments1Value__, this.pow3_branch1_, this.pow3_branch2_);
                }
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 pow(Object, Object, PowNode) */) {
            return pow(arguments0Value_, arguments1Value_, this.pow1_powNode_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_, arguments1Value_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1000) != 0 /* is-state_0 pow(Object, Object, PowNode) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state_0 & 0b10110000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            Object arguments1Value = this.arguments1_.execute(frameValue);
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult(), arguments1Value));
        }
        int arguments1Value_int = 0;
        long arguments1Value_long = 0L;
        double arguments1Value_;
        try {
            if ((state_0 & 0b111000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                arguments1Value_long = this.arguments1_.executeLong(frameValue);
                arguments1Value_ = JSTypes.longToDouble(arguments1Value_long);
            } else if ((state_0 & 0b110100000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                arguments1Value_int = this.arguments1_.executeInt(frameValue);
                arguments1Value_ = JSTypes.intToDouble(arguments1Value_int);
            } else if ((state_0 & 0b101100000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                arguments1Value_ = this.arguments1_.executeDouble(frameValue);
            } else {
                Object arguments1Value__ = this.arguments1_.execute(frameValue);
                arguments1Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 1:double */, arguments1Value__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */) ? (Object) arguments0Value_long : ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */) ? (Object) arguments0Value_int : (Object) arguments0Value_)), ex.getResult()));
        }
        if ((state_0 & 0b1) != 0 /* is-state_0 pow(double, double) */) {
            try {
                return pow(arguments0Value_, arguments1Value_);
            } catch (SlowPathException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-exclude pow(double, double) */;
                    this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 pow(double, double) */;
                } finally {
                    lock.unlock();
                }
                return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_, arguments1Value_));
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 pow2(double, double) */) {
            try {
                return pow2(arguments0Value_, arguments1Value_);
            } catch (SlowPathException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b10 /* add-exclude pow2(double, double) */;
                    this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 pow2(double, double) */;
                } finally {
                    lock.unlock();
                }
                return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_, arguments1Value_));
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 pow3(double, double, ConditionProfile, ConditionProfile) */) {
            return pow3(arguments0Value_, arguments1Value_, this.pow3_branch1_, this.pow3_branch2_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */) ? (Object) arguments0Value_long : ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */) ? (Object) arguments0Value_int : (Object) arguments0Value_)), ((state_0 & 0b111000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */) ? (Object) arguments1Value_long : ((state_0 & 0b110100000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */) ? (Object) arguments1Value_int : (Object) arguments1Value_))));
    }

    @Override
    public double execute(Object arguments0Value, Object arguments1Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) != 0 /* is-state_0 pow(double, double) || pow2(double, double) || pow3(double, double, ConditionProfile, ConditionProfile) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value)) {
            double arguments0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value);
            if (JSTypesGen.isImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 1:double */, arguments1Value)) {
                double arguments1Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 1:double */, arguments1Value);
                if ((state_0 & 0b1) != 0 /* is-state_0 pow(double, double) */) {
                    try {
                        return pow(arguments0Value_, arguments1Value_);
                    } catch (SlowPathException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b1 /* add-exclude pow(double, double) */;
                            this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 pow(double, double) */;
                        } finally {
                            lock.unlock();
                        }
                        return (double) executeAndSpecialize(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 pow2(double, double) */) {
                    try {
                        return pow2(arguments0Value_, arguments1Value_);
                    } catch (SlowPathException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b10 /* add-exclude pow2(double, double) */;
                            this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 pow2(double, double) */;
                        } finally {
                            lock.unlock();
                        }
                        return (double) executeAndSpecialize(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 pow3(double, double, ConditionProfile, ConditionProfile) */) {
                    return pow3(arguments0Value_, arguments1Value_, this.pow3_branch1_, this.pow3_branch2_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return (double) executeAndSpecialize(arguments0Value, arguments1Value);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b1000) == 0 /* only-active pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) */ && ((state_0 & 0b1111) != 0  /* is-not pow(double, double) && pow2(double, double) && pow3(double, double, ConditionProfile, ConditionProfile) && pow(Object, Object, PowNode) */)) {
                executeDouble(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(arguments1Value)) != 0) {
                        double arguments1Value_ = JSTypesGen.asImplicitDouble(doubleCast1, arguments1Value);
                        if (((exclude & 0b1)) == 0 /* is-not-exclude pow(double, double) */) {
                            state_0 = (state_0 | (doubleCast0 << 4) /* set-implicit-state_0 0:double */);
                            state_0 = (state_0 | (doubleCast1 << 8) /* set-implicit-state_0 1:double */);
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 pow(double, double) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return pow(arguments0Value_, arguments1Value_);
                            } catch (SlowPathException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b1 /* add-exclude pow(double, double) */;
                                    this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 pow(double, double) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(arguments0Value_, arguments1Value_);
                            }
                        }
                        if (((exclude & 0b10)) == 0 /* is-not-exclude pow2(double, double) */) {
                            state_0 = (state_0 | (doubleCast0 << 4) /* set-implicit-state_0 0:double */);
                            state_0 = (state_0 | (doubleCast1 << 8) /* set-implicit-state_0 1:double */);
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 pow2(double, double) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return pow2(arguments0Value_, arguments1Value_);
                            } catch (SlowPathException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b10 /* add-exclude pow2(double, double) */;
                                    this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 pow2(double, double) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(arguments0Value_, arguments1Value_);
                            }
                        }
                        this.pow3_branch1_ = (ConditionProfile.createBinaryProfile());
                        this.pow3_branch2_ = (ConditionProfile.createBinaryProfile());
                        state_0 = (state_0 | (doubleCast0 << 4) /* set-implicit-state_0 0:double */);
                        state_0 = (state_0 | (doubleCast1 << 8) /* set-implicit-state_0 1:double */);
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 pow3(double, double, ConditionProfile, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return pow3(arguments0Value_, arguments1Value_, this.pow3_branch1_, this.pow3_branch2_);
                    }
                }
            }
            this.pow1_powNode_ = super.insert((create(getContext())));
            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 pow(Object, Object, PowNode) */;
            lock.unlock();
            hasLock = false;
            return pow(arguments0Value, arguments1Value, this.pow1_powNode_);
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
        s[0] = "pow";
        if ((state_0 & 0b1) != 0 /* is-state_0 pow(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude pow(double, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "pow2";
        if ((state_0 & 0b10) != 0 /* is-state_0 pow2(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-exclude pow2(double, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "pow3";
        if ((state_0 & 0b100) != 0 /* is-state_0 pow3(double, double, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.pow3_branch1_, this.pow3_branch2_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "pow";
        if ((state_0 & 0b1000) != 0 /* is-state_0 pow(Object, Object, PowNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.pow1_powNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static PowNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new PowNodeGen(context, builtin, arguments);
    }

}
