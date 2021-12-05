// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ForeignObjectPrototypeNode.class)
@SuppressWarnings("unused")
public final class ForeignObjectPrototypeNodeGen extends ForeignObjectPrototypeNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private TruffleObject0Data truffleObject0_cache;

    private ForeignObjectPrototypeNodeGen() {
    }

    @ExplodeLoop
    @Override
    public DynamicObject executeDynamicObject(Object arg0Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) || doTruffleObject(Object, InteropLibrary) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
                TruffleObject0Data s0_ = this.truffleObject0_cache;
                while (s0_ != null) {
                    if ((s0_.interop_.accepts(arg0Value))) {
                        return doTruffleObject(arg0Value, s0_.interop_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
                return this.truffleObject1Boundary(state_0, arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private DynamicObject truffleObject1Boundary(int state_0, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return doTruffleObject(arg0Value, truffleObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private DynamicObject executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude doTruffleObject(Object, InteropLibrary) */) {
                int count0_ = 0;
                TruffleObject0Data s0_ = this.truffleObject0_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
                    while (s0_ != null) {
                        if ((s0_.interop_.accepts(arg0Value))) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    // assert (s0_.interop_.accepts(arg0Value));
                    if (count0_ < (JSConfig.InteropLibraryLimit)) {
                        s0_ = super.insert(new TruffleObject0Data(truffleObject0_cache));
                        s0_.interop_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        MemoryFence.storeStore();
                        this.truffleObject0_cache = s0_;
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doTruffleObject(Object, InteropLibrary) */;
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doTruffleObject(arg0Value, s0_.interop_);
                }
            }
            {
                InteropLibrary truffleObject1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude doTruffleObject(Object, InteropLibrary) */;
                        this.truffleObject0_cache = null;
                        state_0 = state_0 & 0xfffffffe /* remove-state_0 doTruffleObject(Object, InteropLibrary) */;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doTruffleObject(Object, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return doTruffleObject(arg0Value, truffleObject1_interop__);
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
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
                TruffleObject0Data s0_ = this.truffleObject0_cache;
                if ((s0_ == null || s0_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doTruffleObject";
        if ((state_0 & 0b1) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            TruffleObject0Data s0_ = this.truffleObject0_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.interop_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doTruffleObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doTruffleObject";
        if ((state_0 & 0b10) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static ForeignObjectPrototypeNode create() {
        return new ForeignObjectPrototypeNodeGen();
    }

    @GeneratedBy(ForeignObjectPrototypeNode.class)
    private static final class TruffleObject0Data extends Node {

        @Child TruffleObject0Data next_;
        @Child InteropLibrary interop_;

        TruffleObject0Data(TruffleObject0Data next_) {
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
