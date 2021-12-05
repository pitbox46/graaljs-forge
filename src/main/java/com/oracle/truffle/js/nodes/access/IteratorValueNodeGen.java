// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
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
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IteratorValueNode.class)
@SuppressWarnings("unused")
public final class IteratorValueNodeGen extends IteratorValueNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private ForeignObject0Data foreignObject0_cache;

    private IteratorValueNodeGen(JSContext context, JavaScriptNode iterResultNode) {
        super(context, iterResultNode);
    }

    @ExplodeLoop
    @Override
    public Object execute(Object iterResultNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doIteratorNext(DynamicObject) */ && JSTypes.isDynamicObject(iterResultNodeValue)) {
            DynamicObject iterResultNodeValue_ = (DynamicObject) iterResultNodeValue;
            return doIteratorNext(iterResultNodeValue_);
        }
        if ((state_0 & 0b110) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                ForeignObject0Data s1_ = this.foreignObject0_cache;
                while (s1_ != null) {
                    if ((s1_.interop_.accepts(iterResultNodeValue)) && (JSGuards.isForeignObject(iterResultNodeValue))) {
                        return doForeignObject(iterResultNodeValue, s1_.interop_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(iterResultNodeValue))) {
                    return this.foreignObject1Boundary(state_0, iterResultNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(iterResultNodeValue);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object foreignObject1Boundary(int state_0, Object iterResultNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(iterResultNodeValue));
                return doForeignObject(iterResultNodeValue, foreignObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object iterResultNodeValue_ = super.iterResultNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doIteratorNext(DynamicObject) */ && JSTypes.isDynamicObject(iterResultNodeValue_)) {
            DynamicObject iterResultNodeValue__ = (DynamicObject) iterResultNodeValue_;
            return doIteratorNext(iterResultNodeValue__);
        }
        if ((state_0 & 0b110) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                ForeignObject0Data s1_ = this.foreignObject0_cache;
                while (s1_ != null) {
                    if ((s1_.interop_.accepts(iterResultNodeValue_)) && (JSGuards.isForeignObject(iterResultNodeValue_))) {
                        return doForeignObject(iterResultNodeValue_, s1_.interop_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(iterResultNodeValue_))) {
                    return this.foreignObject1Boundary0(state_0, iterResultNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(iterResultNodeValue_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object foreignObject1Boundary0(int state_0, Object iterResultNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(iterResultNodeValue_));
                return doForeignObject(iterResultNodeValue_, foreignObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object iterResultNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (JSTypes.isDynamicObject(iterResultNodeValue)) {
                DynamicObject iterResultNodeValue_ = (DynamicObject) iterResultNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doIteratorNext(DynamicObject) */;
                lock.unlock();
                hasLock = false;
                return doIteratorNext(iterResultNodeValue_);
            }
            if ((exclude) == 0 /* is-not-exclude doForeignObject(Object, InteropLibrary) */) {
                int count1_ = 0;
                ForeignObject0Data s1_ = this.foreignObject0_cache;
                if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                    while (s1_ != null) {
                        if ((s1_.interop_.accepts(iterResultNodeValue)) && (JSGuards.isForeignObject(iterResultNodeValue))) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    if ((JSGuards.isForeignObject(iterResultNodeValue)) && count1_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s1_.interop_.accepts(iterResultNodeValue));
                        s1_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                        s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(iterResultNodeValue)));
                        MemoryFence.storeStore();
                        this.foreignObject0_cache = s1_;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignObject(Object, InteropLibrary) */;
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doForeignObject(iterResultNodeValue, s1_.interop_);
                }
            }
            {
                InteropLibrary foreignObject1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(iterResultNodeValue))) {
                            foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(iterResultNodeValue));
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doForeignObject(Object, InteropLibrary) */;
                            this.foreignObject0_cache = null;
                            state_0 = state_0 & 0xfffffffd /* remove-state_0 doForeignObject(Object, InteropLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doForeignObject(Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return doForeignObject(iterResultNodeValue, foreignObject1_interop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.iterResultNode}, iterResultNodeValue);
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
                ForeignObject0Data s1_ = this.foreignObject0_cache;
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
        s[0] = "doIteratorNext";
        if ((state_0 & 0b1) != 0 /* is-state_0 doIteratorNext(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s1_ = this.foreignObject0_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.interop_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
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

    public static IteratorValueNode create(JSContext context, JavaScriptNode iterResultNode) {
        return new IteratorValueNodeGen(context, iterResultNode);
    }

    @GeneratedBy(IteratorValueNode.class)
    private static final class ForeignObject0Data extends Node {

        @Child ForeignObject0Data next_;
        @Child InteropLibrary interop_;

        ForeignObject0Data(ForeignObject0Data next_) {
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
