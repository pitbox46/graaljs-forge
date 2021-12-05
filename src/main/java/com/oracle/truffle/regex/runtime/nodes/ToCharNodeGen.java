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

@GeneratedBy(ToCharNode.class)
@SuppressWarnings("unused")
public final class ToCharNodeGen extends ToCharNode {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private Long0Data long0_cache;

    private ToCharNodeGen() {
    }

    @ExplodeLoop
    @Override
    public char execute(Object arg0Value) throws UnsupportedTypeException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doByte(byte) */ && arg0Value instanceof Byte) {
            byte arg0Value_ = (byte) arg0Value;
            return ToCharNode.doByte(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doChar(char) */ && arg0Value instanceof Character) {
            char arg0Value_ = (char) arg0Value;
            return ToCharNode.doChar(arg0Value_);
        }
        if ((state_0 & 0b1100) != 0 /* is-state_0 doLong(Object, InteropLibrary) || doLong(Object, InteropLibrary) */) {
            if ((state_0 & 0b100) != 0 /* is-state_0 doLong(Object, InteropLibrary) */) {
                Long0Data s2_ = this.long0_cache;
                while (s2_ != null) {
                    if ((s2_.args_.accepts(arg0Value)) && (s2_.args_.fitsInInt(arg0Value))) {
                        return ToCharNode.doLong(arg0Value, s2_.args_);
                    }
                    s2_ = s2_.next_;
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(Object, InteropLibrary) */) {
                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                Node prev_ = encapsulating_.set(this);
                try {
                    {
                        InteropLibrary long1_args__ = (INTEROP_LIBRARY_.getUncached());
                        if ((long1_args__.fitsInInt(arg0Value))) {
                            return this.long1Boundary(state_0, arg0Value);
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
    private char long1Boundary(int state_0, Object arg0Value) throws UnsupportedTypeException {
        {
            InteropLibrary long1_args__ = (INTEROP_LIBRARY_.getUncached());
            return ToCharNode.doLong(arg0Value, long1_args__);
        }
    }

    private char executeAndSpecialize(Object arg0Value) throws UnsupportedTypeException {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (arg0Value instanceof Byte) {
                byte arg0Value_ = (byte) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doByte(byte) */;
                lock.unlock();
                hasLock = false;
                return ToCharNode.doByte(arg0Value_);
            }
            if (arg0Value instanceof Character) {
                char arg0Value_ = (char) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doChar(char) */;
                lock.unlock();
                hasLock = false;
                return ToCharNode.doChar(arg0Value_);
            }
            if ((exclude) == 0 /* is-not-exclude doLong(Object, InteropLibrary) */) {
                int count2_ = 0;
                Long0Data s2_ = this.long0_cache;
                if ((state_0 & 0b100) != 0 /* is-state_0 doLong(Object, InteropLibrary) */) {
                    while (s2_ != null) {
                        if ((s2_.args_.accepts(arg0Value)) && (s2_.args_.fitsInInt(arg0Value))) {
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
                        if ((args__.fitsInInt(arg0Value)) && count2_ < (2)) {
                            s2_ = super.insert(new Long0Data(long0_cache));
                            s2_.args_ = s2_.insertAccessor(args__);
                            MemoryFence.storeStore();
                            this.long0_cache = s2_;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doLong(Object, InteropLibrary) */;
                        }
                    }
                }
                if (s2_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return ToCharNode.doLong(arg0Value, s2_.args_);
                }
            }
            {
                InteropLibrary long1_args__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            long1_args__ = (INTEROP_LIBRARY_.getUncached());
                            if ((long1_args__.fitsInInt(arg0Value))) {
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doLong(Object, InteropLibrary) */;
                                this.long0_cache = null;
                                state_0 = state_0 & 0xfffffffb /* remove-state_0 doLong(Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doLong(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return ToCharNode.doLong(arg0Value, long1_args__);
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
                Long0Data s2_ = this.long0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static ToCharNode create() {
        return new ToCharNodeGen();
    }

    public static ToCharNode getUncached() {
        return ToCharNodeGen.UNCACHED;
    }

    @GeneratedBy(ToCharNode.class)
    private static final class Long0Data extends Node {

        @Child Long0Data next_;
        @Child InteropLibrary args_;

        Long0Data(Long0Data next_) {
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
    @GeneratedBy(ToCharNode.class)
    private static final class Uncached extends ToCharNode {

        @TruffleBoundary
        @Override
        public char execute(Object arg0Value) throws UnsupportedTypeException {
            if (arg0Value instanceof Byte) {
                byte arg0Value_ = (byte) arg0Value;
                return ToCharNode.doByte(arg0Value_);
            }
            if (arg0Value instanceof Character) {
                char arg0Value_ = (char) arg0Value;
                return ToCharNode.doChar(arg0Value_);
            }
            if (((INTEROP_LIBRARY_.getUncached(arg0Value)).fitsInInt(arg0Value))) {
                return ToCharNode.doLong(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
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
