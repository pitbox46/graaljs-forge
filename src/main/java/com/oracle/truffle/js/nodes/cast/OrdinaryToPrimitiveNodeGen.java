// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.cast.JSToPrimitiveNode.Hint;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(OrdinaryToPrimitiveNode.class)
@SuppressWarnings("unused")
public final class OrdinaryToPrimitiveNodeGen extends OrdinaryToPrimitiveNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private Foreign0Data foreign0_cache;

    private OrdinaryToPrimitiveNodeGen(JSContext context, Hint hint) {
        super(context, hint);
    }

    @ExplodeLoop
    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSObject(arg0Value_))) {
                return doObject(arg0Value_);
            }
        }
        if ((state_0 & 0b110) != 0 /* is-state_0 doForeign(Object, InteropLibrary) || doForeign(Object, InteropLibrary) */) {
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeign(Object, InteropLibrary) */) {
                Foreign0Data s1_ = this.foreign0_cache;
                while (s1_ != null) {
                    if ((s1_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                        return doForeign(arg0Value, s1_.interop_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doForeign(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return this.foreign1Boundary(state_0, arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object foreign1Boundary(int state_0, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreign1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return doForeign(arg0Value, foreign1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSObject(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doObject(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doObject(arg0Value_);
                }
            }
            if ((exclude) == 0 /* is-not-exclude doForeign(Object, InteropLibrary) */) {
                int count1_ = 0;
                Foreign0Data s1_ = this.foreign0_cache;
                if ((state_0 & 0b10) != 0 /* is-state_0 doForeign(Object, InteropLibrary) */) {
                    while (s1_ != null) {
                        if ((s1_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    if ((JSGuards.isForeignObject(arg0Value)) && count1_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s1_.interop_.accepts(arg0Value));
                        s1_ = super.insert(new Foreign0Data(foreign0_cache));
                        s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        MemoryFence.storeStore();
                        this.foreign0_cache = s1_;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeign(Object, InteropLibrary) */;
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doForeign(arg0Value, s1_.interop_);
                }
            }
            {
                InteropLibrary foreign1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(arg0Value))) {
                            foreign1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doForeign(Object, InteropLibrary) */;
                            this.foreign0_cache = null;
                            state_0 = state_0 & 0xfffffffd /* remove-state_0 doForeign(Object, InteropLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doForeign(Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return doForeign(arg0Value, foreign1_interop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
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
                Foreign0Data s1_ = this.foreign0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doForeign";
        if ((state_0 & 0b10) != 0 /* is-state_0 doForeign(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            Foreign0Data s1_ = this.foreign0_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.interop_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doForeign(Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doForeign";
        if ((state_0 & 0b100) != 0 /* is-state_0 doForeign(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static OrdinaryToPrimitiveNode create(JSContext context, Hint hint) {
        return new OrdinaryToPrimitiveNodeGen(context, hint);
    }

    @GeneratedBy(OrdinaryToPrimitiveNode.class)
    private static final class Foreign0Data extends Node {

        @Child Foreign0Data next_;
        @Child InteropLibrary interop_;

        Foreign0Data(Foreign0Data next_) {
            this.next_ = next_;
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
