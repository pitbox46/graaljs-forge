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
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(MinNode.class)
public final class MinNodeGen extends MinNode implements Introspection.Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private ConditionProfile minProfile;
    @CompilationFinal private ConditionProfile min2Param_isIntBranch_;
    @Child private JSToNumberNode min2Param_toNumber1Node_;
    @Child private JSToNumberNode min2Param_toNumber2Node_;

    private MinNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if (state_0 != 0 /* is-state_0 min0Param(Object[]) || min1Param(Object[]) || min2ParamInt(Object[], ConditionProfile) || min2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) || min3ParamInt(Object[]) || min3ParamOther(Object[]) || minGeneric(Object[]) */ && arguments0Value_ instanceof Object[]) {
            Object[] arguments0Value__ = (Object[]) arguments0Value_;
            if ((state_0 & 0b1) != 0 /* is-state_0 min0Param(Object[]) */) {
                if ((arguments0Value__.length == 0)) {
                    return MinNode.min0Param(arguments0Value__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 min1Param(Object[]) */) {
                if ((arguments0Value__.length == 1)) {
                    return min1Param(arguments0Value__);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 min2ParamInt(Object[], ConditionProfile) */) {
                if ((arguments0Value__.length == 2) && (MinNode.caseIntInt(arguments0Value__))) {
                    return MinNode.min2ParamInt(arguments0Value__, this.minProfile);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 min2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) */) {
                if ((arguments0Value__.length == 2) && (!(MinNode.caseIntInt(arguments0Value__)))) {
                    return min2Param(arguments0Value__, this.min2Param_isIntBranch_, this.minProfile, this.min2Param_toNumber1Node_, this.min2Param_toNumber2Node_);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 min3ParamInt(Object[]) */) {
                if ((arguments0Value__.length == 3) && (MinNode.caseIntIntInt(arguments0Value__))) {
                    return min3ParamInt(arguments0Value__);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 min3ParamOther(Object[]) */) {
                if ((arguments0Value__.length == 3) && (!(MinNode.caseIntIntInt(arguments0Value__)))) {
                    return min3ParamOther(arguments0Value__);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 minGeneric(Object[]) */) {
                if ((arguments0Value__.length >= 4)) {
                    return minGeneric(arguments0Value__);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1000) != 0 /* is-state_0 min2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b1100011) != 0 /* is-state_0 min0Param(Object[]) || min1Param(Object[]) || min3ParamOther(Object[]) || minGeneric(Object[]) */ && arguments0Value_ instanceof Object[]) {
            Object[] arguments0Value__ = (Object[]) arguments0Value_;
            if ((state_0 & 0b1) != 0 /* is-state_0 min0Param(Object[]) */) {
                if ((arguments0Value__.length == 0)) {
                    return MinNode.min0Param(arguments0Value__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 min1Param(Object[]) */) {
                if ((arguments0Value__.length == 1)) {
                    return min1Param(arguments0Value__);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 min3ParamOther(Object[]) */) {
                if ((arguments0Value__.length == 3) && (!(MinNode.caseIntIntInt(arguments0Value__)))) {
                    return min3ParamOther(arguments0Value__);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 minGeneric(Object[]) */) {
                if ((arguments0Value__.length >= 4)) {
                    return minGeneric(arguments0Value__);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1000) != 0 /* is-state_0 min2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b10100) != 0 /* is-state_0 min2ParamInt(Object[], ConditionProfile) || min3ParamInt(Object[]) */ && arguments0Value_ instanceof Object[]) {
            Object[] arguments0Value__ = (Object[]) arguments0Value_;
            if ((state_0 & 0b100) != 0 /* is-state_0 min2ParamInt(Object[], ConditionProfile) */) {
                if ((arguments0Value__.length == 2) && (MinNode.caseIntInt(arguments0Value__))) {
                    return MinNode.min2ParamInt(arguments0Value__, this.minProfile);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 min3ParamInt(Object[]) */) {
                if ((arguments0Value__.length == 3) && (MinNode.caseIntIntInt(arguments0Value__))) {
                    return min3ParamInt(arguments0Value__);
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
            if ((state_0 & 0b1101011) == 0 /* only-active min2ParamInt(Object[], ConditionProfile) && min3ParamInt(Object[]) */ && (state_0 != 0  /* is-not min0Param(Object[]) && min1Param(Object[]) && min2ParamInt(Object[], ConditionProfile) && min2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) && min3ParamInt(Object[]) && min3ParamOther(Object[]) && minGeneric(Object[]) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b11100) == 0 /* only-active min0Param(Object[]) && min1Param(Object[]) && min3ParamOther(Object[]) && minGeneric(Object[]) */ && (state_0 != 0  /* is-not min0Param(Object[]) && min1Param(Object[]) && min2ParamInt(Object[], ConditionProfile) && min2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) && min3ParamInt(Object[]) && min3ParamOther(Object[]) && minGeneric(Object[]) */)) {
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
            if (arguments0Value instanceof Object[]) {
                Object[] arguments0Value_ = (Object[]) arguments0Value;
                if ((arguments0Value_.length == 0)) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 min0Param(Object[]) */;
                    lock.unlock();
                    hasLock = false;
                    return MinNode.min0Param(arguments0Value_);
                }
                if ((arguments0Value_.length == 1)) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 min1Param(Object[]) */;
                    lock.unlock();
                    hasLock = false;
                    return min1Param(arguments0Value_);
                }
                if ((arguments0Value_.length == 2) && (MinNode.caseIntInt(arguments0Value_))) {
                    this.minProfile = this.minProfile == null ? ((ConditionProfile.createBinaryProfile())) : this.minProfile;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 min2ParamInt(Object[], ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return MinNode.min2ParamInt(arguments0Value_, this.minProfile);
                }
                if ((arguments0Value_.length == 2) && (!(MinNode.caseIntInt(arguments0Value_)))) {
                    this.min2Param_isIntBranch_ = (ConditionProfile.createBinaryProfile());
                    this.minProfile = this.minProfile == null ? ((ConditionProfile.createBinaryProfile())) : this.minProfile;
                    this.min2Param_toNumber1Node_ = super.insert((JSToNumberNode.create()));
                    this.min2Param_toNumber2Node_ = super.insert((JSToNumberNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 min2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) */;
                    lock.unlock();
                    hasLock = false;
                    return min2Param(arguments0Value_, this.min2Param_isIntBranch_, this.minProfile, this.min2Param_toNumber1Node_, this.min2Param_toNumber2Node_);
                }
                if ((arguments0Value_.length == 3) && (MinNode.caseIntIntInt(arguments0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 min3ParamInt(Object[]) */;
                    lock.unlock();
                    hasLock = false;
                    return min3ParamInt(arguments0Value_);
                }
                if ((arguments0Value_.length == 3) && (!(MinNode.caseIntIntInt(arguments0Value_)))) {
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 min3ParamOther(Object[]) */;
                    lock.unlock();
                    hasLock = false;
                    return min3ParamOther(arguments0Value_);
                }
                if ((arguments0Value_.length >= 4)) {
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 minGeneric(Object[]) */;
                    lock.unlock();
                    hasLock = false;
                    return minGeneric(arguments0Value_);
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
        Object[] data = new Object[8];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "min0Param";
        if ((state_0 & 0b1) != 0 /* is-state_0 min0Param(Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "min1Param";
        if ((state_0 & 0b10) != 0 /* is-state_0 min1Param(Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "min2ParamInt";
        if ((state_0 & 0b100) != 0 /* is-state_0 min2ParamInt(Object[], ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.minProfile));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "min2Param";
        if ((state_0 & 0b1000) != 0 /* is-state_0 min2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.min2Param_isIntBranch_, this.minProfile, this.min2Param_toNumber1Node_, this.min2Param_toNumber2Node_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "min3ParamInt";
        if ((state_0 & 0b10000) != 0 /* is-state_0 min3ParamInt(Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "min3ParamOther";
        if ((state_0 & 0b100000) != 0 /* is-state_0 min3ParamOther(Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "minGeneric";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 minGeneric(Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static MinNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new MinNodeGen(context, builtin, arguments);
    }

}
