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
import com.oracle.truffle.regex.runtime.nodes.ToCharNode;
import com.oracle.truffle.regex.runtime.nodes.ToCharNodeGen;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InputReadNode.class)
@SuppressWarnings("unused")
public final class InputReadNodeGen extends InputReadNode {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private BoxedCharArray0Data boxedCharArray0_cache;
    @Child private ToCharNode boxedCharArray1_toCharNode_;

    private InputReadNodeGen() {
    }

    @ExplodeLoop
    @Override
    public int execute(Object arg0Value, int arg1Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doBytes(byte[], int) || doString(String, int) || doBoxedCharArray(Object, int, InteropLibrary, ToCharNode) || doBoxedCharArray(Object, int, InteropLibrary, ToCharNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doBytes(byte[], int) */ && arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                return InputReadNode.doBytes(arg0Value_, arg1Value);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doString(String, int) */ && arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                return InputReadNode.doString(arg0Value_, arg1Value);
            }
            if ((state_0 & 0b1100) != 0 /* is-state_0 doBoxedCharArray(Object, int, InteropLibrary, ToCharNode) || doBoxedCharArray(Object, int, InteropLibrary, ToCharNode) */) {
                if ((state_0 & 0b100) != 0 /* is-state_0 doBoxedCharArray(Object, int, InteropLibrary, ToCharNode) */) {
                    BoxedCharArray0Data s2_ = this.boxedCharArray0_cache;
                    while (s2_ != null) {
                        if ((s2_.inputs_.accepts(arg0Value)) && (s2_.inputs_.hasArrayElements(arg0Value))) {
                            return InputReadNode.doBoxedCharArray(arg0Value, arg1Value, s2_.inputs_, s2_.toCharNode_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doBoxedCharArray(Object, int, InteropLibrary, ToCharNode) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary boxedCharArray1_inputs__ = (INTEROP_LIBRARY_.getUncached());
                            if ((boxedCharArray1_inputs__.hasArrayElements(arg0Value))) {
                                return this.boxedCharArray1Boundary(state_0, arg0Value, arg1Value);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private int boxedCharArray1Boundary(int state_0, Object arg0Value, int arg1Value) {
        {
            InteropLibrary boxedCharArray1_inputs__ = (INTEROP_LIBRARY_.getUncached());
            return InputReadNode.doBoxedCharArray(arg0Value, arg1Value, boxedCharArray1_inputs__, this.boxedCharArray1_toCharNode_);
        }
    }

    private int executeAndSpecialize(Object arg0Value, int arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBytes(byte[], int) */;
                lock.unlock();
                hasLock = false;
                return InputReadNode.doBytes(arg0Value_, arg1Value);
            }
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doString(String, int) */;
                lock.unlock();
                hasLock = false;
                return InputReadNode.doString(arg0Value_, arg1Value);
            }
            if ((exclude) == 0 /* is-not-exclude doBoxedCharArray(Object, int, InteropLibrary, ToCharNode) */) {
                int count2_ = 0;
                BoxedCharArray0Data s2_ = this.boxedCharArray0_cache;
                if ((state_0 & 0b100) != 0 /* is-state_0 doBoxedCharArray(Object, int, InteropLibrary, ToCharNode) */) {
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
                            s2_ = super.insert(new BoxedCharArray0Data(boxedCharArray0_cache));
                            s2_.inputs_ = s2_.insertAccessor(inputs__);
                            s2_.toCharNode_ = s2_.insertAccessor((ToCharNode.create()));
                            MemoryFence.storeStore();
                            this.boxedCharArray0_cache = s2_;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doBoxedCharArray(Object, int, InteropLibrary, ToCharNode) */;
                        }
                    }
                }
                if (s2_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return InputReadNode.doBoxedCharArray(arg0Value, arg1Value, s2_.inputs_, s2_.toCharNode_);
                }
            }
            {
                InteropLibrary boxedCharArray1_inputs__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            boxedCharArray1_inputs__ = (INTEROP_LIBRARY_.getUncached());
                            if ((boxedCharArray1_inputs__.hasArrayElements(arg0Value))) {
                                this.boxedCharArray1_toCharNode_ = super.insert((ToCharNode.create()));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doBoxedCharArray(Object, int, InteropLibrary, ToCharNode) */;
                                this.boxedCharArray0_cache = null;
                                state_0 = state_0 & 0xfffffffb /* remove-state_0 doBoxedCharArray(Object, int, InteropLibrary, ToCharNode) */;
                                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doBoxedCharArray(Object, int, InteropLibrary, ToCharNode) */;
                                lock.unlock();
                                hasLock = false;
                                return InputReadNode.doBoxedCharArray(arg0Value, arg1Value, boxedCharArray1_inputs__, this.boxedCharArray1_toCharNode_);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                BoxedCharArray0Data s2_ = this.boxedCharArray0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static InputReadNode create() {
        return new InputReadNodeGen();
    }

    public static InputReadNode getUncached() {
        return InputReadNodeGen.UNCACHED;
    }

    @GeneratedBy(InputReadNode.class)
    private static final class BoxedCharArray0Data extends Node {

        @Child BoxedCharArray0Data next_;
        @Child InteropLibrary inputs_;
        @Child ToCharNode toCharNode_;

        BoxedCharArray0Data(BoxedCharArray0Data next_) {
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
    @GeneratedBy(InputReadNode.class)
    private static final class Uncached extends InputReadNode {

        @TruffleBoundary
        @Override
        public int execute(Object arg0Value, int arg1Value) {
            if (arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                return InputReadNode.doBytes(arg0Value_, arg1Value);
            }
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                return InputReadNode.doString(arg0Value_, arg1Value);
            }
            if (((INTEROP_LIBRARY_.getUncached(arg0Value)).hasArrayElements(arg0Value))) {
                return InputReadNode.doBoxedCharArray(arg0Value, arg1Value, (INTEROP_LIBRARY_.getUncached(arg0Value)), (ToCharNodeGen.getUncached()));
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
