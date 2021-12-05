// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSGuardDisconnectedArgumentRead.class)
public final class JSGuardDisconnectedArgumentReadNodeGen extends JSGuardDisconnectedArgumentRead implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private ConditionProfile unconnected;
    @CompilationFinal private ConditionProfile objectDisconnected_wasDisconnected_;

    private JSGuardDisconnectedArgumentReadNodeGen(int index, ReadElementNode readElementNode, JavaScriptNode argumentsArray, FrameSlot slot) {
        super(index, readElementNode, argumentsArray, slot);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object argumentsArrayNodeValue_ = super.argumentsArrayNode.execute(frameValue);
        if (state_0 != 0 /* is-state_0 doObject(DynamicObject, ConditionProfile) || doObjectDisconnected(DynamicObject, ConditionProfile, ConditionProfile) */ && JSTypes.isDynamicObject(argumentsArrayNodeValue_)) {
            DynamicObject argumentsArrayNodeValue__ = (DynamicObject) argumentsArrayNodeValue_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject, ConditionProfile) */) {
                if ((!(JSGuards.isArgumentsDisconnected(argumentsArrayNodeValue__)))) {
                    return doObject(argumentsArrayNodeValue__, this.unconnected);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doObjectDisconnected(DynamicObject, ConditionProfile, ConditionProfile) */) {
                if ((JSGuards.isArgumentsDisconnected(argumentsArrayNodeValue__))) {
                    return doObjectDisconnected(argumentsArrayNodeValue__, this.objectDisconnected_wasDisconnected_, this.unconnected);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(argumentsArrayNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object argumentsArrayNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(argumentsArrayNodeValue)) {
                DynamicObject argumentsArrayNodeValue_ = (DynamicObject) argumentsArrayNodeValue;
                if ((!(JSGuards.isArgumentsDisconnected(argumentsArrayNodeValue_)))) {
                    this.unconnected = this.unconnected == null ? ((ConditionProfile.createBinaryProfile())) : this.unconnected;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doObject(DynamicObject, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doObject(argumentsArrayNodeValue_, this.unconnected);
                }
                if ((JSGuards.isArgumentsDisconnected(argumentsArrayNodeValue_))) {
                    this.objectDisconnected_wasDisconnected_ = (ConditionProfile.createBinaryProfile());
                    this.unconnected = this.unconnected == null ? ((ConditionProfile.createBinaryProfile())) : this.unconnected;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doObjectDisconnected(DynamicObject, ConditionProfile, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doObjectDisconnected(argumentsArrayNodeValue_, this.objectDisconnected_wasDisconnected_, this.unconnected);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.argumentsArrayNode}, argumentsArrayNodeValue);
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
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.unconnected));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doObjectDisconnected";
        if ((state_0 & 0b10) != 0 /* is-state_0 doObjectDisconnected(DynamicObject, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.objectDisconnected_wasDisconnected_, this.unconnected));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSGuardDisconnectedArgumentRead create(int index, ReadElementNode readElementNode, JavaScriptNode argumentsArray, FrameSlot slot) {
        return new JSGuardDisconnectedArgumentReadNodeGen(index, readElementNode, argumentsArray, slot);
    }

}
