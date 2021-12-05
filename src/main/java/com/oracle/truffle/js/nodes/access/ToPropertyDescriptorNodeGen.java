// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ToPropertyDescriptorNode.class)
public final class ToPropertyDescriptorNodeGen extends ToPropertyDescriptorNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private DefaultData default_cache;
    @Child private JSToStringNode nonObject_toStringNode_;

    private ToPropertyDescriptorNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 nonSpecialized(DynamicObject) || doDefault(DynamicObject, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, IsCallableNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state_0 & 0b1) != 0 /* is-state_0 nonSpecialized(DynamicObject) */) {
                if ((!(wasExecuted(arg0Value_))) && (JSGuards.isJSObject(arg0Value_))) {
                    return nonSpecialized(arg0Value_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doDefault(DynamicObject, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, IsCallableNode) */) {
                DefaultData s1_ = this.default_cache;
                if (s1_ != null) {
                    if ((wasExecuted(arg0Value_)) && (JSGuards.isJSObject(arg0Value_))) {
                        return doDefault(arg0Value_, s1_.hasGetBranch_, s1_.hasSetBranch_, s1_.hasEnumerableBranch_, s1_.hasConfigurableBranch_, s1_.hasValueBranch_, s1_.hasWritableBranch_, s1_.isCallable_);
                    }
                }
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doNonObject(Object, JSToStringNode) */) {
            if ((!(JSGuards.isJSObject(arg0Value)))) {
                return doNonObject(arg0Value, this.nonObject_toStringNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((!(wasExecuted(arg0Value_))) && (JSGuards.isJSObject(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 nonSpecialized(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return nonSpecialized(arg0Value_);
                }
                if ((wasExecuted(arg0Value_)) && (JSGuards.isJSObject(arg0Value_))) {
                    DefaultData s1_ = super.insert(new DefaultData());
                    s1_.hasGetBranch_ = (BranchProfile.create());
                    s1_.hasSetBranch_ = (BranchProfile.create());
                    s1_.hasEnumerableBranch_ = (BranchProfile.create());
                    s1_.hasConfigurableBranch_ = (BranchProfile.create());
                    s1_.hasValueBranch_ = (BranchProfile.create());
                    s1_.hasWritableBranch_ = (BranchProfile.create());
                    s1_.isCallable_ = s1_.insertAccessor((IsCallableNode.create()));
                    MemoryFence.storeStore();
                    this.default_cache = s1_;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDefault(DynamicObject, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, IsCallableNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doDefault(arg0Value_, s1_.hasGetBranch_, s1_.hasSetBranch_, s1_.hasEnumerableBranch_, s1_.hasConfigurableBranch_, s1_.hasValueBranch_, s1_.hasWritableBranch_, s1_.isCallable_);
                }
            }
            if ((!(JSGuards.isJSObject(arg0Value)))) {
                this.nonObject_toStringNode_ = super.insert((JSToStringNode.create()));
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doNonObject(Object, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return doNonObject(arg0Value, this.nonObject_toStringNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "nonSpecialized";
        if ((state_0 & 0b1) != 0 /* is-state_0 nonSpecialized(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDefault";
        if ((state_0 & 0b10) != 0 /* is-state_0 doDefault(DynamicObject, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, IsCallableNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            DefaultData s1_ = this.default_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.hasGetBranch_, s1_.hasSetBranch_, s1_.hasEnumerableBranch_, s1_.hasConfigurableBranch_, s1_.hasValueBranch_, s1_.hasWritableBranch_, s1_.isCallable_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doNonObject";
        if ((state_0 & 0b100) != 0 /* is-state_0 doNonObject(Object, JSToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.nonObject_toStringNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static ToPropertyDescriptorNode create(JSContext context) {
        return new ToPropertyDescriptorNodeGen(context);
    }

    @GeneratedBy(ToPropertyDescriptorNode.class)
    private static final class DefaultData extends Node {

        @CompilationFinal BranchProfile hasGetBranch_;
        @CompilationFinal BranchProfile hasSetBranch_;
        @CompilationFinal BranchProfile hasEnumerableBranch_;
        @CompilationFinal BranchProfile hasConfigurableBranch_;
        @CompilationFinal BranchProfile hasValueBranch_;
        @CompilationFinal BranchProfile hasWritableBranch_;
        @Child IsCallableNode isCallable_;

        DefaultData() {
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
