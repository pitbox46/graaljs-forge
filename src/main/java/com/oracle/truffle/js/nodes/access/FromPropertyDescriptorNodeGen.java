// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.objects.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(FromPropertyDescriptorNode.class)
public final class FromPropertyDescriptorNodeGen extends FromPropertyDescriptorNode implements Introspection.Provider {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @Child private ToJSObjectData toJSObject_cache;

    private FromPropertyDescriptorNodeGen() {
    }

    @Override
    public DynamicObject execute(PropertyDescriptor arg0Value, JSContext arg1Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 toJSObject(PropertyDescriptor, JSContext, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary) */) {
            ToJSObjectData s0_ = this.toJSObject_cache;
            if (s0_ != null) {
                return toJSObject(arg0Value, arg1Value, s0_.putValueNode_, s0_.putWritableNode_, s0_.putGetNode_, s0_.putSetNode_, s0_.putEnumerableNode_, s0_.putConfigurableNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private DynamicObject executeAndSpecialize(PropertyDescriptor arg0Value, JSContext arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            ToJSObjectData s0_ = super.insert(new ToJSObjectData());
            s0_.putValueNode_ = s0_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.createDispatched(FromPropertyDescriptorNode.SHAPE_LIMIT)));
            s0_.putWritableNode_ = s0_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.createDispatched(FromPropertyDescriptorNode.SHAPE_LIMIT)));
            s0_.putGetNode_ = s0_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.createDispatched(FromPropertyDescriptorNode.SHAPE_LIMIT)));
            s0_.putSetNode_ = s0_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.createDispatched(FromPropertyDescriptorNode.SHAPE_LIMIT)));
            s0_.putEnumerableNode_ = s0_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.createDispatched(FromPropertyDescriptorNode.SHAPE_LIMIT)));
            s0_.putConfigurableNode_ = s0_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.createDispatched(FromPropertyDescriptorNode.SHAPE_LIMIT)));
            MemoryFence.storeStore();
            this.toJSObject_cache = s0_;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 toJSObject(PropertyDescriptor, JSContext, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary) */;
            lock.unlock();
            hasLock = false;
            return toJSObject(arg0Value, arg1Value, s0_.putValueNode_, s0_.putWritableNode_, s0_.putGetNode_, s0_.putSetNode_, s0_.putEnumerableNode_, s0_.putConfigurableNode_);
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
            return NodeCost.MONOMORPHIC;
        }
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[2];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "toJSObject";
        if (state_0 != 0 /* is-state_0 toJSObject(PropertyDescriptor, JSContext, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ToJSObjectData s0_ = this.toJSObject_cache;
            if (s0_ != null) {
                cached.add(Arrays.asList(s0_.putValueNode_, s0_.putWritableNode_, s0_.putGetNode_, s0_.putSetNode_, s0_.putEnumerableNode_, s0_.putConfigurableNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static FromPropertyDescriptorNode create() {
        return new FromPropertyDescriptorNodeGen();
    }

    public static FromPropertyDescriptorNode getUncached() {
        return FromPropertyDescriptorNodeGen.UNCACHED;
    }

    @GeneratedBy(FromPropertyDescriptorNode.class)
    private static final class ToJSObjectData extends Node {

        @Child DynamicObjectLibrary putValueNode_;
        @Child DynamicObjectLibrary putWritableNode_;
        @Child DynamicObjectLibrary putGetNode_;
        @Child DynamicObjectLibrary putSetNode_;
        @Child DynamicObjectLibrary putEnumerableNode_;
        @Child DynamicObjectLibrary putConfigurableNode_;

        ToJSObjectData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(FromPropertyDescriptorNode.class)
    private static final class Uncached extends FromPropertyDescriptorNode {

        @TruffleBoundary
        @Override
        public DynamicObject execute(PropertyDescriptor arg0Value, JSContext arg1Value) {
            return toJSObject(arg0Value, arg1Value, (DYNAMIC_OBJECT_LIBRARY_.getUncached()), (DYNAMIC_OBJECT_LIBRARY_.getUncached()), (DYNAMIC_OBJECT_LIBRARY_.getUncached()), (DYNAMIC_OBJECT_LIBRARY_.getUncached()), (DYNAMIC_OBJECT_LIBRARY_.getUncached()), (DYNAMIC_OBJECT_LIBRARY_.getUncached()));
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
}
