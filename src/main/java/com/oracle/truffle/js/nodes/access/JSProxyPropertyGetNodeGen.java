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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.cast.JSToPropertyKeyNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSProxyPropertyGetNode.class)
public final class JSProxyPropertyGetNodeGen extends JSProxyPropertyGetNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private GenericData generic_cache;

    private JSProxyPropertyGetNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public Object executeWithReceiver(Object arg0Value, Object arg1Value, Object arg2Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doGeneric(DynamicObject, Object, Object, JSToPropertyKeyNode, ConditionProfile, JSClassProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            GenericData s0_ = this.generic_cache;
            if (s0_ != null) {
                return doGeneric(arg0Value_, arg1Value, arg2Value, s0_.toPropertyKeyNode_, s0_.hasTrap_, s0_.targetClassProfile_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private Object executeAndSpecialize(Object arg0Value, Object arg1Value, Object arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                GenericData s0_ = super.insert(new GenericData());
                s0_.toPropertyKeyNode_ = s0_.insertAccessor((JSToPropertyKeyNode.create()));
                s0_.hasTrap_ = (ConditionProfile.createBinaryProfile());
                s0_.targetClassProfile_ = (JSClassProfile.create());
                MemoryFence.storeStore();
                this.generic_cache = s0_;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doGeneric(DynamicObject, Object, Object, JSToPropertyKeyNode, ConditionProfile, JSClassProfile) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(arg0Value_, arg1Value, arg2Value, s0_.toPropertyKeyNode_, s0_.hasTrap_, s0_.targetClassProfile_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[2];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doGeneric";
        if (state_0 != 0 /* is-state_0 doGeneric(DynamicObject, Object, Object, JSToPropertyKeyNode, ConditionProfile, JSClassProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s0_ = this.generic_cache;
            if (s0_ != null) {
                cached.add(Arrays.asList(s0_.toPropertyKeyNode_, s0_.hasTrap_, s0_.targetClassProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static JSProxyPropertyGetNode create(JSContext context) {
        return new JSProxyPropertyGetNodeGen(context);
    }

    @GeneratedBy(JSProxyPropertyGetNode.class)
    private static final class GenericData extends Node {

        @Child JSToPropertyKeyNode toPropertyKeyNode_;
        @CompilationFinal ConditionProfile hasTrap_;
        @CompilationFinal JSClassProfile targetClassProfile_;

        GenericData() {
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
