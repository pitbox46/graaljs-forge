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

@GeneratedBy(ExpectStringOrTruffleObjectNode.class)
@SuppressWarnings("unused")
public final class ExpectStringOrTruffleObjectNodeGen extends ExpectStringOrTruffleObjectNode {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private BoxedString0Data boxedString0_cache;
    @Child private BoxedCharArray0Data boxedCharArray0_cache;

    private ExpectStringOrTruffleObjectNodeGen() {
    }

    @ExplodeLoop
    @Override
    public Object execute(Object arg0Value) throws UnsupportedTypeException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doString(String) */ && arg0Value instanceof String) {
            String arg0Value_ = (String) arg0Value;
            return ExpectStringOrTruffleObjectNode.doString(arg0Value_);
        }
        if ((state_0 & 0b11110) != 0 /* is-state_0 doBoxedString(Object, InteropLibrary) || doBoxedString(Object, InteropLibrary) || doBoxedCharArray(Object, InteropLibrary) || doBoxedCharArray(Object, InteropLibrary) */) {
            if ((state_0 & 0b10) != 0 /* is-state_0 doBoxedString(Object, InteropLibrary) */) {
                BoxedString0Data s1_ = this.boxedString0_cache;
                while (s1_ != null) {
                    if ((s1_.inputs_.accepts(arg0Value)) && (s1_.inputs_.isString(arg0Value))) {
                        return ExpectStringOrTruffleObjectNode.doBoxedString(arg0Value, s1_.inputs_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doBoxedString(Object, InteropLibrary) */) {
                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                Node prev_ = encapsulating_.set(this);
                try {
                    {
                        InteropLibrary boxedString1_inputs__ = (INTEROP_LIBRARY_.getUncached());
                        if ((boxedString1_inputs__.isString(arg0Value))) {
                            return this.boxedString1Boundary(state_0, arg0Value);
                        }
                    }
                } finally {
                    encapsulating_.set(prev_);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doBoxedCharArray(Object, InteropLibrary) */) {
                BoxedCharArray0Data s3_ = this.boxedCharArray0_cache;
                while (s3_ != null) {
                    if ((s3_.inputs_.accepts(arg0Value)) && (s3_.inputs_.hasArrayElements(arg0Value))) {
                        return ExpectStringOrTruffleObjectNode.doBoxedCharArray(arg0Value, s3_.inputs_);
                    }
                    s3_ = s3_.next_;
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doBoxedCharArray(Object, InteropLibrary) */) {
                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                Node prev_ = encapsulating_.set(this);
                try {
                    {
                        InteropLibrary boxedCharArray1_inputs__ = (INTEROP_LIBRARY_.getUncached());
                        if ((boxedCharArray1_inputs__.hasArrayElements(arg0Value))) {
                            return this.boxedCharArray1Boundary(state_0, arg0Value);
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
    private Object boxedString1Boundary(int state_0, Object arg0Value) throws UnsupportedTypeException {
        {
            InteropLibrary boxedString1_inputs__ = (INTEROP_LIBRARY_.getUncached());
            return ExpectStringOrTruffleObjectNode.doBoxedString(arg0Value, boxedString1_inputs__);
        }
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object boxedCharArray1Boundary(int state_0, Object arg0Value) throws UnsupportedTypeException {
        {
            InteropLibrary boxedCharArray1_inputs__ = (INTEROP_LIBRARY_.getUncached());
            return ExpectStringOrTruffleObjectNode.doBoxedCharArray(arg0Value, boxedCharArray1_inputs__);
        }
    }

    private Object executeAndSpecialize(Object arg0Value) throws UnsupportedTypeException {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doString(String) */;
                lock.unlock();
                hasLock = false;
                return ExpectStringOrTruffleObjectNode.doString(arg0Value_);
            }
            if (((exclude & 0b1)) == 0 /* is-not-exclude doBoxedString(Object, InteropLibrary) */) {
                int count1_ = 0;
                BoxedString0Data s1_ = this.boxedString0_cache;
                if ((state_0 & 0b10) != 0 /* is-state_0 doBoxedString(Object, InteropLibrary) */) {
                    while (s1_ != null) {
                        if ((s1_.inputs_.accepts(arg0Value)) && (s1_.inputs_.isString(arg0Value))) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        InteropLibrary inputs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                        // assert (s1_.inputs_.accepts(arg0Value));
                        if ((inputs__.isString(arg0Value)) && count1_ < (2)) {
                            s1_ = super.insert(new BoxedString0Data(boxedString0_cache));
                            s1_.inputs_ = s1_.insertAccessor(inputs__);
                            MemoryFence.storeStore();
                            this.boxedString0_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doBoxedString(Object, InteropLibrary) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return ExpectStringOrTruffleObjectNode.doBoxedString(arg0Value, s1_.inputs_);
                }
            }
            {
                InteropLibrary boxedString1_inputs__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            boxedString1_inputs__ = (INTEROP_LIBRARY_.getUncached());
                            if ((boxedString1_inputs__.isString(arg0Value))) {
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doBoxedString(Object, InteropLibrary) */;
                                this.boxedString0_cache = null;
                                state_0 = state_0 & 0xfffffffd /* remove-state_0 doBoxedString(Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doBoxedString(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return ExpectStringOrTruffleObjectNode.doBoxedString(arg0Value, boxedString1_inputs__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doBoxedCharArray(Object, InteropLibrary) */) {
                int count3_ = 0;
                BoxedCharArray0Data s3_ = this.boxedCharArray0_cache;
                if ((state_0 & 0b1000) != 0 /* is-state_0 doBoxedCharArray(Object, InteropLibrary) */) {
                    while (s3_ != null) {
                        if ((s3_.inputs_.accepts(arg0Value)) && (s3_.inputs_.hasArrayElements(arg0Value))) {
                            break;
                        }
                        s3_ = s3_.next_;
                        count3_++;
                    }
                }
                if (s3_ == null) {
                    {
                        InteropLibrary inputs__1 = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                        // assert (s3_.inputs_.accepts(arg0Value));
                        if ((inputs__1.hasArrayElements(arg0Value)) && count3_ < (2)) {
                            s3_ = super.insert(new BoxedCharArray0Data(boxedCharArray0_cache));
                            s3_.inputs_ = s3_.insertAccessor(inputs__1);
                            MemoryFence.storeStore();
                            this.boxedCharArray0_cache = s3_;
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doBoxedCharArray(Object, InteropLibrary) */;
                        }
                    }
                }
                if (s3_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return ExpectStringOrTruffleObjectNode.doBoxedCharArray(arg0Value, s3_.inputs_);
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
                                this.exclude_ = exclude = exclude | 0b10 /* add-exclude doBoxedCharArray(Object, InteropLibrary) */;
                                this.boxedCharArray0_cache = null;
                                state_0 = state_0 & 0xfffffff7 /* remove-state_0 doBoxedCharArray(Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doBoxedCharArray(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return ExpectStringOrTruffleObjectNode.doBoxedCharArray(arg0Value, boxedCharArray1_inputs__);
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
                BoxedString0Data s1_ = this.boxedString0_cache;
                BoxedCharArray0Data s3_ = this.boxedCharArray0_cache;
                if ((s1_ == null || s1_.next_ == null) && (s3_ == null || s3_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static ExpectStringOrTruffleObjectNode create() {
        return new ExpectStringOrTruffleObjectNodeGen();
    }

    public static ExpectStringOrTruffleObjectNode getUncached() {
        return ExpectStringOrTruffleObjectNodeGen.UNCACHED;
    }

    @GeneratedBy(ExpectStringOrTruffleObjectNode.class)
    private static final class BoxedString0Data extends Node {

        @Child BoxedString0Data next_;
        @Child InteropLibrary inputs_;

        BoxedString0Data(BoxedString0Data next_) {
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
    @GeneratedBy(ExpectStringOrTruffleObjectNode.class)
    private static final class BoxedCharArray0Data extends Node {

        @Child BoxedCharArray0Data next_;
        @Child InteropLibrary inputs_;

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
    @GeneratedBy(ExpectStringOrTruffleObjectNode.class)
    private static final class Uncached extends ExpectStringOrTruffleObjectNode {

        @TruffleBoundary
        @Override
        public Object execute(Object arg0Value) throws UnsupportedTypeException {
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                return ExpectStringOrTruffleObjectNode.doString(arg0Value_);
            }
            if (((INTEROP_LIBRARY_.getUncached(arg0Value)).isString(arg0Value))) {
                return ExpectStringOrTruffleObjectNode.doBoxedString(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
            }
            if (((INTEROP_LIBRARY_.getUncached(arg0Value)).hasArrayElements(arg0Value))) {
                return ExpectStringOrTruffleObjectNode.doBoxedCharArray(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
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
