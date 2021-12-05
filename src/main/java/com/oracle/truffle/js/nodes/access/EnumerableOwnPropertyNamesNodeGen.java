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
import com.oracle.truffle.js.builtins.helper.ListGetNode;
import com.oracle.truffle.js.builtins.helper.ListSizeNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import com.oracle.truffle.js.runtime.util.UnmodifiableArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(EnumerableOwnPropertyNamesNode.class)
public final class EnumerableOwnPropertyNamesNodeGen extends EnumerableOwnPropertyNamesNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private EnumerableOwnPropertyNamesData enumerableOwnPropertyNames_cache;

    private EnumerableOwnPropertyNamesNodeGen(JSContext context, boolean keys, boolean values) {
        super(context, keys, values);
    }

    @Override
    public UnmodifiableArrayList<? extends Object> execute(DynamicObject arg0Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 enumerableOwnPropertyNames(DynamicObject, JSClassProfile, ListSizeNode, ListGetNode, HasOnlyShapePropertiesNode) */) {
            EnumerableOwnPropertyNamesData s0_ = this.enumerableOwnPropertyNames_cache;
            if (s0_ != null) {
                return enumerableOwnPropertyNames(arg0Value, s0_.jsclassProfile_, s0_.listSize_, s0_.listGet_, s0_.hasOnlyShapeProperties_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private UnmodifiableArrayList<? extends Object> executeAndSpecialize(DynamicObject arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            EnumerableOwnPropertyNamesData s0_ = super.insert(new EnumerableOwnPropertyNamesData());
            s0_.jsclassProfile_ = (JSClassProfile.create());
            s0_.listSize_ = s0_.insertAccessor((ListSizeNode.create()));
            s0_.listGet_ = s0_.insertAccessor((ListGetNode.create()));
            s0_.hasOnlyShapeProperties_ = s0_.insertAccessor((HasOnlyShapePropertiesNode.create()));
            MemoryFence.storeStore();
            this.enumerableOwnPropertyNames_cache = s0_;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 enumerableOwnPropertyNames(DynamicObject, JSClassProfile, ListSizeNode, ListGetNode, HasOnlyShapePropertiesNode) */;
            lock.unlock();
            hasLock = false;
            return enumerableOwnPropertyNames(arg0Value, s0_.jsclassProfile_, s0_.listSize_, s0_.listGet_, s0_.hasOnlyShapeProperties_);
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
        s[0] = "enumerableOwnPropertyNames";
        if (state_0 != 0 /* is-state_0 enumerableOwnPropertyNames(DynamicObject, JSClassProfile, ListSizeNode, ListGetNode, HasOnlyShapePropertiesNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            EnumerableOwnPropertyNamesData s0_ = this.enumerableOwnPropertyNames_cache;
            if (s0_ != null) {
                cached.add(Arrays.asList(s0_.jsclassProfile_, s0_.listSize_, s0_.listGet_, s0_.hasOnlyShapeProperties_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static EnumerableOwnPropertyNamesNode create(JSContext context, boolean keys, boolean values) {
        return new EnumerableOwnPropertyNamesNodeGen(context, keys, values);
    }

    @GeneratedBy(EnumerableOwnPropertyNamesNode.class)
    private static final class EnumerableOwnPropertyNamesData extends Node {

        @CompilationFinal JSClassProfile jsclassProfile_;
        @Child ListSizeNode listSize_;
        @Child ListGetNode listGet_;
        @Child HasOnlyShapePropertiesNode hasOnlyShapeProperties_;

        EnumerableOwnPropertyNamesData() {
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
