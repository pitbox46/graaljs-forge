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

@GeneratedBy(ToIntNode.class)
@SuppressWarnings("unused")
public final class ToIntNodeGen extends ToIntNode {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private Boxed0Data boxed0_cache;

    private ToIntNodeGen() {
    }

    @ExplodeLoop
    @Override
    public int execute(Object arg0Value) throws UnsupportedTypeException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doPrimitiveInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return ToIntNode.doPrimitiveInt(arg0Value_);
        }
        if ((state_0 & 0b110) != 0 /* is-state_0 doBoxed(Object, InteropLibrary) || doBoxed(Object, InteropLibrary) */) {
            if ((state_0 & 0b10) != 0 /* is-state_0 doBoxed(Object, InteropLibrary) */) {
                Boxed0Data s1_ = this.boxed0_cache;
                while (s1_ != null) {
                    if ((s1_.args_.accepts(arg0Value)) && (s1_.args_.fitsInInt(arg0Value))) {
                        return ToIntNode.doBoxed(arg0Value, s1_.args_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doBoxed(Object, InteropLibrary) */) {
                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                Node prev_ = encapsulating_.set(this);
                try {
                    {
                        InteropLibrary boxed1_args__ = (INTEROP_LIBRARY_.getUncached());
                        if ((boxed1_args__.fitsInInt(arg0Value))) {
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
    private int boxed1Boundary(int state_0, Object arg0Value) throws UnsupportedTypeException {
        {
            InteropLibrary boxed1_args__ = (INTEROP_LIBRARY_.getUncached());
            return ToIntNode.doBoxed(arg0Value, boxed1_args__);
        }
    }

    private int executeAndSpecialize(Object arg0Value) throws UnsupportedTypeException {
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
                return ToIntNode.doPrimitiveInt(arg0Value_);
            }
            if ((exclude) == 0 /* is-not-exclude doBoxed(Object, InteropLibrary) */) {
                int count1_ = 0;
                Boxed0Data s1_ = this.boxed0_cache;
                if ((state_0 & 0b10) != 0 /* is-state_0 doBoxed(Object, InteropLibrary) */) {
                    while (s1_ != null) {
                        if ((s1_.args_.accepts(arg0Value)) && (s1_.args_.fitsInInt(arg0Value))) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        InteropLibrary args__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                        // assert (s1_.args_.accepts(arg0Value));
                        if ((args__.fitsInInt(arg0Value)) && count1_ < (2)) {
                            s1_ = super.insert(new Boxed0Data(boxed0_cache));
                            s1_.args_ = s1_.insertAccessor(args__);
                            MemoryFence.storeStore();
                            this.boxed0_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doBoxed(Object, InteropLibrary) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return ToIntNode.doBoxed(arg0Value, s1_.args_);
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
                            if ((boxed1_args__.fitsInInt(arg0Value))) {
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doBoxed(Object, InteropLibrary) */;
                                this.boxed0_cache = null;
                                state_0 = state_0 & 0xfffffffd /* remove-state_0 doBoxed(Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doBoxed(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return ToIntNode.doBoxed(arg0Value, boxed1_args__);
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
                Boxed0Data s1_ = this.boxed0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static ToIntNode create() {
        return new ToIntNodeGen();
    }

    public static ToIntNode getUncached() {
        return ToIntNodeGen.UNCACHED;
    }

    @GeneratedBy(ToIntNode.class)
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
    @GeneratedBy(ToIntNode.class)
    private static final class Uncached extends ToIntNode {

        @TruffleBoundary
        @Override
        public int execute(Object arg0Value) throws UnsupportedTypeException {
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                return ToIntNode.doPrimitiveInt(arg0Value_);
            }
            if (((INTEROP_LIBRARY_.getUncached(arg0Value)).fitsInInt(arg0Value))) {
                return ToIntNode.doBoxed(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
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
