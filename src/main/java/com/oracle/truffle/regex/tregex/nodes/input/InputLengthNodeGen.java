// CheckStyle: start generated
package com.oracle.truffle.regex.tregex.nodes.input;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InputLengthNode.class)
@SuppressWarnings("unused")
public final class InputLengthNodeGen extends InputLengthNode {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private TruffleObj0Data truffleObj0_cache;

    private InputLengthNodeGen() {
    }

    @ExplodeLoop
    @Override
    public int execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doBytes(byte[]) */ && arg0Value instanceof byte[]) {
            byte[] arg0Value_ = (byte[]) arg0Value;
            return InputLengthNode.doBytes(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doString(String) */ && arg0Value instanceof String) {
            String arg0Value_ = (String) arg0Value;
            return InputLengthNode.doString(arg0Value_);
        }
        if ((state_0 & 0b1100) != 0 /* is-state_0 doTruffleObj(Object, InteropLibrary) || doTruffleObj(Object, InteropLibrary) */) {
            if ((state_0 & 0b100) != 0 /* is-state_0 doTruffleObj(Object, InteropLibrary) */) {
                TruffleObj0Data s2_ = this.truffleObj0_cache;
                while (s2_ != null) {
                    if ((s2_.inputs_.accepts(arg0Value)) && (s2_.inputs_.hasArrayElements(arg0Value))) {
                        return InputLengthNode.doTruffleObj(arg0Value, s2_.inputs_);
                    }
                    s2_ = s2_.next_;
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doTruffleObj(Object, InteropLibrary) */) {
                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                Node prev_ = encapsulating_.set(this);
                try {
                    {
                        InteropLibrary truffleObj1_inputs__ = (INTEROP_LIBRARY_.getUncached());
                        if ((truffleObj1_inputs__.hasArrayElements(arg0Value))) {
                            return this.truffleObj1Boundary(state_0, arg0Value);
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
    private int truffleObj1Boundary(int state_0, Object arg0Value) {
        {
            InteropLibrary truffleObj1_inputs__ = (INTEROP_LIBRARY_.getUncached());
            return InputLengthNode.doTruffleObj(arg0Value, truffleObj1_inputs__);
        }
    }

    private int executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBytes(byte[]) */;
                lock.unlock();
                hasLock = false;
                return InputLengthNode.doBytes(arg0Value_);
            }
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doString(String) */;
                lock.unlock();
                hasLock = false;
                return InputLengthNode.doString(arg0Value_);
            }
            if ((exclude) == 0 /* is-not-exclude doTruffleObj(Object, InteropLibrary) */) {
                int count2_ = 0;
                TruffleObj0Data s2_ = this.truffleObj0_cache;
                if ((state_0 & 0b100) != 0 /* is-state_0 doTruffleObj(Object, InteropLibrary) */) {
                    while (s2_ != null) {
                        if ((s2_.inputs_.accepts(arg0Value)) && (s2_.inputs_.hasArrayElements(arg0Value))) {
                            break;
                        }
                        s2_ = s2_.next_;
                        count2_++;
                    }
                }
                if (s2_ == null) {
                    {
                        InteropLibrary inputs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                        // assert (s2_.inputs_.accepts(arg0Value));
                        if ((inputs__.hasArrayElements(arg0Value)) && count2_ < (2)) {
                            s2_ = super.insert(new TruffleObj0Data(truffleObj0_cache));
                            s2_.inputs_ = s2_.insertAccessor(inputs__);
                            MemoryFence.storeStore();
                            this.truffleObj0_cache = s2_;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doTruffleObj(Object, InteropLibrary) */;
                        }
                    }
                }
                if (s2_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return InputLengthNode.doTruffleObj(arg0Value, s2_.inputs_);
                }
            }
            {
                InteropLibrary truffleObj1_inputs__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            truffleObj1_inputs__ = (INTEROP_LIBRARY_.getUncached());
                            if ((truffleObj1_inputs__.hasArrayElements(arg0Value))) {
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doTruffleObj(Object, InteropLibrary) */;
                                this.truffleObj0_cache = null;
                                state_0 = state_0 & 0xfffffffb /* remove-state_0 doTruffleObj(Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doTruffleObj(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return InputLengthNode.doTruffleObj(arg0Value, truffleObj1_inputs__);
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
                TruffleObj0Data s2_ = this.truffleObj0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static InputLengthNode create() {
        return new InputLengthNodeGen();
    }

    public static InputLengthNode getUncached() {
        return InputLengthNodeGen.UNCACHED;
    }

    @GeneratedBy(InputLengthNode.class)
    private static final class TruffleObj0Data extends Node {

        @Child TruffleObj0Data next_;
        @Child InteropLibrary inputs_;

        TruffleObj0Data(TruffleObj0Data next_) {
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
    @GeneratedBy(InputLengthNode.class)
    private static final class Uncached extends InputLengthNode {

        @TruffleBoundary
        @Override
        public int execute(Object arg0Value) {
            if (arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                return InputLengthNode.doBytes(arg0Value_);
            }
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                return InputLengthNode.doString(arg0Value_);
            }
            if (((INTEROP_LIBRARY_.getUncached(arg0Value)).hasArrayElements(arg0Value))) {
                return InputLengthNode.doTruffleObj(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
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
