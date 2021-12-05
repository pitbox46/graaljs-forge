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
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(FloorNode.class)
public final class FloorNodeGen extends FloorNode implements Introspection.Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile isZero;
    @CompilationFinal private ConditionProfile fitsInt;
    @CompilationFinal private ConditionProfile fitsSafeLong;
    @CompilationFinal private ConditionProfile smaller;

    private FloorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if ((state_0 & 0b1110) == 0 /* only-active floorInt(int) */ && ((state_0 & 0b1111) != 0  /* is-not floorInt(int) && floorSafeInt(SafeInteger) && floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) && floorToDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */)) {
            return execute_int0(state_0, frameValue);
        } else if ((state_0 & 0b1011) == 0 /* only-active floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */ && ((state_0 & 0b1111) != 0  /* is-not floorInt(int) && floorSafeInt(SafeInteger) && floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) && floorToDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */)) {
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
        assert (state_0 & 0b1) != 0 /* is-state_0 floorInt(int) */;
        return FloorNode.floorInt(arguments0Value_);
    }

    private Object execute_double1(int state_0, VirtualFrame frameValue) {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not floorInt(int) && floorSafeInt(SafeInteger) && floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) && floorToDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */)) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not floorInt(int) && floorSafeInt(SafeInteger) && floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) && floorToDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */)) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state_0 & 0b10110000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not floorInt(int) && floorSafeInt(SafeInteger) && floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) && floorToDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */)) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */;
        return FloorNode.floorDouble(arguments0Value_, this.isZero, this.fitsInt, this.fitsSafeLong, this.smaller);
    }

    private Object execute_generic2(int state_0, VirtualFrame frameValue) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 floorInt(int) */ && arguments0Value_ instanceof Integer) {
            int arguments0Value__ = (int) arguments0Value_;
            return FloorNode.floorInt(arguments0Value__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 floorSafeInt(SafeInteger) */ && arguments0Value_ instanceof SafeInteger) {
            SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
            return FloorNode.floorSafeInt(arguments0Value__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_);
            return FloorNode.floorDouble(arguments0Value__, this.isZero, this.fitsInt, this.fitsSafeLong, this.smaller);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 floorToDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
            return floorToDouble(arguments0Value_, this.isZero, this.fitsInt, this.fitsSafeLong, this.smaller);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1100) != 0 /* is-state_0 floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) || floorToDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        if ((state_0 & 0b1) != 0 /* is-state_0 floorInt(int) */) {
            return FloorNode.floorInt(arguments0Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b1110) == 0 /* only-active floorInt(int) */ && ((state_0 & 0b1111) != 0  /* is-not floorInt(int) && floorSafeInt(SafeInteger) && floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) && floorToDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */)) {
                executeInt(frameValue);
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
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 floorInt(int) */;
                lock.unlock();
                hasLock = false;
                return FloorNode.floorInt(arguments0Value_);
            }
            if (arguments0Value instanceof SafeInteger) {
                SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 floorSafeInt(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return FloorNode.floorSafeInt(arguments0Value_);
            }
            if ((exclude) == 0 /* is-not-exclude floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    this.isZero = this.isZero == null ? ((ConditionProfile.createBinaryProfile())) : this.isZero;
                    this.fitsInt = this.fitsInt == null ? ((ConditionProfile.createBinaryProfile())) : this.fitsInt;
                    this.fitsSafeLong = this.fitsSafeLong == null ? ((ConditionProfile.createBinaryProfile())) : this.fitsSafeLong;
                    this.smaller = this.smaller == null ? ((ConditionProfile.createBinaryProfile())) : this.smaller;
                    state_0 = (state_0 | (doubleCast0 << 4) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return FloorNode.floorDouble(arguments0Value_, this.isZero, this.fitsInt, this.fitsSafeLong, this.smaller);
                }
            }
            this.isZero = this.isZero == null ? ((ConditionProfile.createBinaryProfile())) : this.isZero;
            this.fitsInt = this.fitsInt == null ? ((ConditionProfile.createBinaryProfile())) : this.fitsInt;
            this.fitsSafeLong = this.fitsSafeLong == null ? ((ConditionProfile.createBinaryProfile())) : this.fitsSafeLong;
            this.smaller = this.smaller == null ? ((ConditionProfile.createBinaryProfile())) : this.smaller;
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */;
            state_0 = state_0 & 0xfffffffb /* remove-state_0 floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */;
            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 floorToDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */;
            lock.unlock();
            hasLock = false;
            return floorToDouble(arguments0Value, this.isZero, this.fitsInt, this.fitsSafeLong, this.smaller);
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
        s[0] = "floorInt";
        if ((state_0 & 0b1) != 0 /* is-state_0 floorInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "floorSafeInt";
        if ((state_0 & 0b10) != 0 /* is-state_0 floorSafeInt(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "floorDouble";
        if ((state_0 & 0b100) != 0 /* is-state_0 floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.isZero, this.fitsInt, this.fitsSafeLong, this.smaller));
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude floorDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "floorToDouble";
        if ((state_0 & 0b1000) != 0 /* is-state_0 floorToDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.isZero, this.fitsInt, this.fitsSafeLong, this.smaller));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static FloorNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new FloorNodeGen(context, builtin, arguments);
    }

}
