// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.cast.JSToBooleanNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsRegExpNode.class)
public final class IsRegExpNodeGen extends IsRegExpNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private IsObjectData isObject_cache;

    private IsRegExpNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public boolean executeBoolean(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doIsObject(DynamicObject, IsJSObjectNode, JSToBooleanNode, IsJSClassNode, ConditionProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            IsObjectData s0_ = this.isObject_cache;
            if (s0_ != null) {
                return doIsObject(arg0Value_, s0_.isObjectNode_, s0_.toBooleanNode_, s0_.isJSRegExpNode_, s0_.hasMatchSymbol_);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doNonObject(Object) */) {
            if (fallbackGuard_(state_0, arg0Value)) {
                return doNonObject(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private boolean executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                IsObjectData s0_ = super.insert(new IsObjectData());
                s0_.isObjectNode_ = s0_.insertAccessor((IsJSObjectNode.create()));
                s0_.toBooleanNode_ = s0_.insertAccessor((JSToBooleanNode.create()));
                s0_.isJSRegExpNode_ = s0_.insertAccessor((IsRegExpNode.createIsJSRegExpNode()));
                s0_.hasMatchSymbol_ = (ConditionProfile.createBinaryProfile());
                MemoryFence.storeStore();
                this.isObject_cache = s0_;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doIsObject(DynamicObject, IsJSObjectNode, JSToBooleanNode, IsJSClassNode, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doIsObject(arg0Value_, s0_.isObjectNode_, s0_.toBooleanNode_, s0_.isJSRegExpNode_, s0_.hasMatchSymbol_);
            }
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doNonObject(Object) */;
            lock.unlock();
            hasLock = false;
            return doNonObject(arg0Value);
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
        s[0] = "doIsObject";
        if ((state_0 & 0b1) != 0 /* is-state_0 doIsObject(DynamicObject, IsJSObjectNode, JSToBooleanNode, IsJSClassNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            IsObjectData s0_ = this.isObject_cache;
            if (s0_ != null) {
                cached.add(Arrays.asList(s0_.isObjectNode_, s0_.toBooleanNode_, s0_.isJSRegExpNode_, s0_.hasMatchSymbol_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doNonObject";
        if ((state_0 & 0b10) != 0 /* is-state_0 doNonObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state_0, Object arg0Value) {
        if (((state_0 & 0b1)) == 0 /* is-not-state_0 doIsObject(DynamicObject, IsJSObjectNode, JSToBooleanNode, IsJSClassNode, ConditionProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
            return false;
        }
        return true;
    }

    public static IsRegExpNode create(JSContext context) {
        return new IsRegExpNodeGen(context);
    }

    @GeneratedBy(IsRegExpNode.class)
    private static final class IsObjectData extends Node {

        @Child IsJSObjectNode isObjectNode_;
        @Child JSToBooleanNode toBooleanNode_;
        @Child IsJSClassNode isJSRegExpNode_;
        @CompilationFinal ConditionProfile hasMatchSymbol_;

        IsObjectData() {
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
