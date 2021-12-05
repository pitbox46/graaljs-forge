// CheckStyle: start generated
package com.oracle.truffle.regex.runtime.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ToLongNode.class)
@SuppressWarnings("unused")
public final class ToLongNodeGen extends ToLongNode {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private Boxed0Data boxed0_cache;

    private ToLongNodeGen() {
    }

    @ExplodeLoop
    @Override
    public long execute(Object arg0Value) throws UnsupportedTypeException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doPrimitiveInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return ToLongNode.doPrimitiveInt(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doPrimitiveLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            return ToLongNode.doPrimitiveLong(arg0Value_);
        }
        if ((state_0 & 0b1100) != 0 /* is-state_0 doBoxed(Object, InteropLibrary) || doBoxed(Object, InteropLibrary) */) {
            if ((state_0 & 0b100) != 0 /* is-state_0 doBoxed(Object, InteropLibrary) */) {
                Boxed0Data s2_ = this.boxed0_cache;
                while (s2_ != null) {
                    if ((s2_.args_.accepts(arg0Value)) && (s2_.args_.fitsInLong(arg0Value))) {
                        return ToLongNode.doBoxed(arg0Value, s2_.args_);
                    }
                    s2_ = s2_.next_;
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doBoxed(Object, InteropLibrary) */) {
                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                Node prev_ = encapsulating_.set(this);
                try {
                    {
                        InteropLibrary boxed1_args__ = (INTEROP_LIBRARY_.getUncached());
                        if ((boxed1_args__.fitsInLong(arg0Value))) {
                            return this.boxed1Boundary(state_0, arg0Value);
                        }
                    }
                } finally {
                    encapsulating_.set(prev_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private long boxed1Boundary(int state_0, Object arg0Value) throws UnsupportedTypeException {
        {
            InteropLibrary boxed1_args__ = (INTEROP_LIBRARY_.getUncached());
            return ToLongNode.doBoxed(arg0Value, boxed1_args__);
        }
    }

    private long executeAndSpecialize(Object arg0Value) throws UnsupportedTypeException {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doPrimitiveInt(int) */;
                lock.unlock();
                hasLock = false;
                return ToLongNode.doPrimitiveInt(arg0Value_);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doPrimitiveLong(long) */;
                lock.unlock();
                hasLock = false;
                return ToLongNode.doPrimitiveLong(arg0Value_);
            }
            if ((exclude) == 0 /* is-not-exclude doBoxed(Object, InteropLibrary) */) {
                int count2_ = 0;
                Boxed0Data s2_ = this.boxed0_cache;
                if ((state_0 & 0b100) != 0 /* is-state_0 doBoxed(Object, InteropLibrary) */) {
                    while (s2_ != null) {
                        if ((s2_.args_.accepts(arg0Value)) && (s2_.args_.fitsInLong(arg0Value))) {
                            break;
                        }
                        s2_ = s2_.next_;
                        count2_++;
                    }
                }
                if (s2_ == null) {
                    {
                        InteropLibrary args__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                        // assert (s2_.args_.accepts(arg0Value));
                        if ((args__.fitsInLong(arg0Value)) && count2_ < (2)) {
                            s2_ = super.insert(new Boxed0Data(boxed0_cache));
                            s2_.args_ = s2_.insertAccessor(args__);
                            MemoryFence.storeStore();
                            this.boxed0_cache = s2_;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doBoxed(Object, InteropLibrary) */;
                        }
                    }
                }
                if (s2_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return ToLongNode.doBoxed(arg0Value, s2_.args_);
                }
            }
            {
                InteropLibrary boxed1_args__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            boxed1_args__ = (INTEROP_LIBRARY_.getUncached());
                            if ((boxed1_args__.fitsInLong(arg0Value))) {
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doBoxed(Object, InteropLibrary) */;
                                this.boxed0_cache = null;
                                state_0 = state_0 & 0xfffffffb /* remove-state_0 doBoxed(Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doBoxed(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return ToLongNode.doBoxed(arg0Value, boxed1_args__);
                            }
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
                Boxed0Data s2_ = this.boxed0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static ToLongNode create() {
        return new ToLongNodeGen();
    }

    public static ToLongNode getUncached() {
        return ToLongNodeGen.UNCACHED;
    }

    @GeneratedBy(ToLongNode.class)
    private static final class Boxed0Data extends Node {

        @Child Boxed0Data next_;
        @Child InteropLibrary args_;

        Boxed0Data(Boxed0Data next_) {
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
    @GeneratedBy(ToLongNode.class)
    private static final class Uncached extends ToLongNode {

        @TruffleBoundary
        @Override
        public long execute(Object arg0Value) throws UnsupportedTypeException {
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                return ToLongNode.doPrimitiveInt(arg0Value_);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                return ToLongNode.doPrimitiveLong(arg0Value_);
            }
            if (((INTEROP_LIBRARY_.getUncached(arg0Value)).fitsInLong(arg0Value))) {
                return ToLongNode.doBoxed(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
