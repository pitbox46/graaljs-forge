// CheckStyle: start generated
package com.oracle.truffle.js.builtins.math;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.memory.MemoryFence;
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

@GeneratedBy(MaxNode.class)
public final class MaxNodeGen extends MaxNode implements Introspection.Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private ConditionProfile max2ParamInt_maxProfile_;
    @Child private Max2ParamData max2Param_cache;

    private MaxNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if (state_0 != 0 /* is-state_0 max0Param(Object[]) || max1Param(Object[]) || max2ParamInt(Object[], ConditionProfile) || max2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) || max(Object[]) */ && arguments0Value_ instanceof Object[]) {
            Object[] arguments0Value__ = (Object[]) arguments0Value_;
            if ((state_0 & 0b1) != 0 /* is-state_0 max0Param(Object[]) */) {
                if ((arguments0Value__.length == 0)) {
                    return MaxNode.max0Param(arguments0Value__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 max1Param(Object[]) */) {
                if ((arguments0Value__.length == 1)) {
                    return max1Param(arguments0Value__);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 max2ParamInt(Object[], ConditionProfile) */) {
                if ((arguments0Value__.length == 2) && (MaxNode.caseIntInt(arguments0Value__))) {
                    return MaxNode.max2ParamInt(arguments0Value__, this.max2ParamInt_maxProfile_);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 max2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) */) {
                Max2ParamData s3_ = this.max2Param_cache;
                if (s3_ != null) {
                    if ((arguments0Value__.length == 2) && (!(MaxNode.caseIntInt(arguments0Value__)))) {
                        return max2Param(arguments0Value__, s3_.isIntBranch_, s3_.maxProfile_, s3_.toNumber1Node_, s3_.toNumber2Node_);
                    }
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 max(Object[]) */) {
                if ((arguments0Value__.length >= 3)) {
                    return max(arguments0Value__);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1000) != 0 /* is-state_0 max2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b10011) != 0 /* is-state_0 max0Param(Object[]) || max1Param(Object[]) || max(Object[]) */ && arguments0Value_ instanceof Object[]) {
            Object[] arguments0Value__ = (Object[]) arguments0Value_;
            if ((state_0 & 0b1) != 0 /* is-state_0 max0Param(Object[]) */) {
                if ((arguments0Value__.length == 0)) {
                    return MaxNode.max0Param(arguments0Value__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 max1Param(Object[]) */) {
                if ((arguments0Value__.length == 1)) {
                    return max1Param(arguments0Value__);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 max(Object[]) */) {
                if ((arguments0Value__.length >= 3)) {
                    return max(arguments0Value__);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1000) != 0 /* is-state_0 max2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state_0 & 0b100) != 0 /* is-state_0 max2ParamInt(Object[], ConditionProfile) */ && arguments0Value_ instanceof Object[]) {
            Object[] arguments0Value__ = (Object[]) arguments0Value_;
            if ((arguments0Value__.length == 2) && (MaxNode.caseIntInt(arguments0Value__))) {
                return MaxNode.max2ParamInt(arguments0Value__, this.max2ParamInt_maxProfile_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b11011) == 0 /* only-active max2ParamInt(Object[], ConditionProfile) */ && (state_0 != 0  /* is-not max0Param(Object[]) && max1Param(Object[]) && max2ParamInt(Object[], ConditionProfile) && max2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) && max(Object[]) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b1100) == 0 /* only-active max0Param(Object[]) && max1Param(Object[]) && max(Object[]) */ && (state_0 != 0  /* is-not max0Param(Object[]) && max1Param(Object[]) && max2ParamInt(Object[], ConditionProfile) && max2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) && max(Object[]) */)) {
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
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 max0Param(Object[]) */;
                    lock.unlock();
                    hasLock = false;
                    return MaxNode.max0Param(arguments0Value_);
                }
                if ((arguments0Value_.length == 1)) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 max1Param(Object[]) */;
                    lock.unlock();
                    hasLock = false;
                    return max1Param(arguments0Value_);
                }
                if ((arguments0Value_.length == 2) && (MaxNode.caseIntInt(arguments0Value_))) {
                    this.max2ParamInt_maxProfile_ = (ConditionProfile.createBinaryProfile());
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 max2ParamInt(Object[], ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return MaxNode.max2ParamInt(arguments0Value_, this.max2ParamInt_maxProfile_);
                }
                if ((arguments0Value_.length == 2) && (!(MaxNode.caseIntInt(arguments0Value_)))) {
                    Max2ParamData s3_ = super.insert(new Max2ParamData());
                    s3_.isIntBranch_ = (ConditionProfile.createBinaryProfile());
                    s3_.maxProfile_ = (ConditionProfile.createBinaryProfile());
                    s3_.toNumber1Node_ = s3_.insertAccessor((JSToNumberNode.create()));
                    s3_.toNumber2Node_ = s3_.insertAccessor((JSToNumberNode.create()));
                    MemoryFence.storeStore();
                    this.max2Param_cache = s3_;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 max2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) */;
                    lock.unlock();
                    hasLock = false;
                    return max2Param(arguments0Value_, s3_.isIntBranch_, s3_.maxProfile_, s3_.toNumber1Node_, s3_.toNumber2Node_);
                }
                if ((arguments0Value_.length >= 3)) {
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 max(Object[]) */;
                    lock.unlock();
                    hasLock = false;
                    return max(arguments0Value_);
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
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "max0Param";
        if ((state_0 & 0b1) != 0 /* is-state_0 max0Param(Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "max1Param";
        if ((state_0 & 0b10) != 0 /* is-state_0 max1Param(Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "max2ParamInt";
        if ((state_0 & 0b100) != 0 /* is-state_0 max2ParamInt(Object[], ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.max2ParamInt_maxProfile_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "max2Param";
        if ((state_0 & 0b1000) != 0 /* is-state_0 max2Param(Object[], ConditionProfile, ConditionProfile, JSToNumberNode, JSToNumberNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            Max2ParamData s3_ = this.max2Param_cache;
            if (s3_ != null) {
                cached.add(Arrays.asList(s3_.isIntBranch_, s3_.maxProfile_, s3_.toNumber1Node_, s3_.toNumber2Node_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "max";
        if ((state_0 & 0b10000) != 0 /* is-state_0 max(Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static MaxNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new MaxNodeGen(context, builtin, arguments);
    }

    @GeneratedBy(MaxNode.class)
    private static final class Max2ParamData extends Node {

        @CompilationFinal ConditionProfile isIntBranch_;
        @CompilationFinal ConditionProfile maxProfile_;
        @Child JSToNumberNode toNumber1Node_;
        @Child JSToNumberNode toNumber2Node_;

        Max2ParamData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
}
