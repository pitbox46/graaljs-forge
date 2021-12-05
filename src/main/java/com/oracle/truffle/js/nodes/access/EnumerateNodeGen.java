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
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(EnumerateNode.class)
@SuppressWarnings("unused")
public final class EnumerateNodeGen extends EnumerateNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile enumerateObject_isObject_;
    @Child private EnumerateNode enumerateJSAdapter_enumerateCallbackResultNode_;
    @Child private EnumerateTruffleObject0Data enumerateTruffleObject0_cache;
    @Child private InteropLibrary enumerateTruffleObject1_keysInterop_;
    @CompilationFinal private BranchProfile enumerateTruffleObject1_notIterable_;
    @Child private JSToObjectNode nonObject_toObjectNode_;
    @Child private EnumerateNode nonObject_enumerateNode_;

    private EnumerateNodeGen(JSContext context, boolean values, boolean requireIterable, JavaScriptNode targetNode) {
        super(context, values, requireIterable, targetNode);
    }

    @ExplodeLoop
    @Override
    public DynamicObject execute(Object targetNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 doEnumerateObject(DynamicObject, ConditionProfile) || doEnumerateJSAdapter(DynamicObject, EnumerateNode) */ && JSTypes.isDynamicObject(targetNodeValue)) {
            DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
            if ((state_0 & 0b1) != 0 /* is-state_0 doEnumerateObject(DynamicObject, ConditionProfile) */) {
                if ((JSGuards.isJSDynamicObject(targetNodeValue_)) && (!(JSGuards.isJSAdapter(targetNodeValue_)))) {
                    return doEnumerateObject(targetNodeValue_, this.enumerateObject_isObject_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doEnumerateJSAdapter(DynamicObject, EnumerateNode) */) {
                if ((JSGuards.isJSAdapter(targetNodeValue_))) {
                    return doEnumerateJSAdapter(targetNodeValue_, this.enumerateJSAdapter_enumerateCallbackResultNode_);
                }
            }
        }
        if ((state_0 & 0b11100) != 0 /* is-state_0 doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) || doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) || doNonObject(Object, JSToObjectNode, EnumerateNode) */) {
            if ((state_0 & 0b100) != 0 /* is-state_0 doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                EnumerateTruffleObject0Data s2_ = this.enumerateTruffleObject0_cache;
                while (s2_ != null) {
                    if ((s2_.interop_.accepts(targetNodeValue)) && (JSGuards.isForeignObject(targetNodeValue))) {
                        return doEnumerateTruffleObject(targetNodeValue, s2_.interop_, s2_.keysInterop_, s2_.notIterable_);
                    }
                    s2_ = s2_.next_;
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                if ((JSGuards.isForeignObject(targetNodeValue))) {
                    return this.enumerateTruffleObject1Boundary(state_0, targetNodeValue);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doNonObject(Object, JSToObjectNode, EnumerateNode) */) {
                if ((!(JSGuards.isJSObject(targetNodeValue))) && (!(JSGuards.isForeignObject(targetNodeValue)))) {
                    return doNonObject(targetNodeValue, this.nonObject_toObjectNode_, this.nonObject_enumerateNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private DynamicObject enumerateTruffleObject1Boundary(int state_0, Object targetNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary enumerateTruffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(targetNodeValue));
                return doEnumerateTruffleObject(targetNodeValue, enumerateTruffleObject1_interop__, this.enumerateTruffleObject1_keysInterop_, this.enumerateTruffleObject1_notIterable_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public DynamicObject execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object targetNodeValue_ = super.targetNode.execute(frameValue);
        if ((state_0 & 0b11) != 0 /* is-state_0 doEnumerateObject(DynamicObject, ConditionProfile) || doEnumerateJSAdapter(DynamicObject, EnumerateNode) */ && JSTypes.isDynamicObject(targetNodeValue_)) {
            DynamicObject targetNodeValue__ = (DynamicObject) targetNodeValue_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doEnumerateObject(DynamicObject, ConditionProfile) */) {
                if ((JSGuards.isJSDynamicObject(targetNodeValue__)) && (!(JSGuards.isJSAdapter(targetNodeValue__)))) {
                    return doEnumerateObject(targetNodeValue__, this.enumerateObject_isObject_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doEnumerateJSAdapter(DynamicObject, EnumerateNode) */) {
                if ((JSGuards.isJSAdapter(targetNodeValue__))) {
                    return doEnumerateJSAdapter(targetNodeValue__, this.enumerateJSAdapter_enumerateCallbackResultNode_);
                }
            }
        }
        if ((state_0 & 0b11100) != 0 /* is-state_0 doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) || doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) || doNonObject(Object, JSToObjectNode, EnumerateNode) */) {
            if ((state_0 & 0b100) != 0 /* is-state_0 doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                EnumerateTruffleObject0Data s2_ = this.enumerateTruffleObject0_cache;
                while (s2_ != null) {
                    if ((s2_.interop_.accepts(targetNodeValue_)) && (JSGuards.isForeignObject(targetNodeValue_))) {
                        return doEnumerateTruffleObject(targetNodeValue_, s2_.interop_, s2_.keysInterop_, s2_.notIterable_);
                    }
                    s2_ = s2_.next_;
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                if ((JSGuards.isForeignObject(targetNodeValue_))) {
                    return this.enumerateTruffleObject1Boundary0(state_0, targetNodeValue_);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doNonObject(Object, JSToObjectNode, EnumerateNode) */) {
                if ((!(JSGuards.isJSObject(targetNodeValue_))) && (!(JSGuards.isForeignObject(targetNodeValue_)))) {
                    return doNonObject(targetNodeValue_, this.nonObject_toObjectNode_, this.nonObject_enumerateNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private DynamicObject enumerateTruffleObject1Boundary0(int state_0, Object targetNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary enumerateTruffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(targetNodeValue_));
                return doEnumerateTruffleObject(targetNodeValue_, enumerateTruffleObject1_interop__, this.enumerateTruffleObject1_keysInterop_, this.enumerateTruffleObject1_notIterable_);
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

    private DynamicObject executeAndSpecialize(Object targetNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (JSTypes.isDynamicObject(targetNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSDynamicObject(targetNodeValue_)) && (!(JSGuards.isJSAdapter(targetNodeValue_)))) {
                    this.enumerateObject_isObject_ = (ConditionProfile.createBinaryProfile());
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doEnumerateObject(DynamicObject, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doEnumerateObject(targetNodeValue_, this.enumerateObject_isObject_);
                }
                if ((JSGuards.isJSAdapter(targetNodeValue_))) {
                    this.enumerateJSAdapter_enumerateCallbackResultNode_ = super.insert((createValues()));
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doEnumerateJSAdapter(DynamicObject, EnumerateNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doEnumerateJSAdapter(targetNodeValue_, this.enumerateJSAdapter_enumerateCallbackResultNode_);
                }
            }
            if ((exclude) == 0 /* is-not-exclude doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                int count2_ = 0;
                EnumerateTruffleObject0Data s2_ = this.enumerateTruffleObject0_cache;
                if ((state_0 & 0b100) != 0 /* is-state_0 doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    while (s2_ != null) {
                        if ((s2_.interop_.accepts(targetNodeValue)) && (JSGuards.isForeignObject(targetNodeValue))) {
                            break;
                        }
                        s2_ = s2_.next_;
                        count2_++;
                    }
                }
                if (s2_ == null) {
                    if ((JSGuards.isForeignObject(targetNodeValue)) && count2_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s2_.interop_.accepts(targetNodeValue));
                        s2_ = super.insert(new EnumerateTruffleObject0Data(enumerateTruffleObject0_cache));
                        s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(targetNodeValue)));
                        s2_.keysInterop_ = s2_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                        s2_.notIterable_ = (BranchProfile.create());
                        MemoryFence.storeStore();
                        this.enumerateTruffleObject0_cache = s2_;
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                    }
                }
                if (s2_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doEnumerateTruffleObject(targetNodeValue, s2_.interop_, s2_.keysInterop_, s2_.notIterable_);
                }
            }
            {
                InteropLibrary enumerateTruffleObject1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(targetNodeValue))) {
                            enumerateTruffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(targetNodeValue));
                            this.enumerateTruffleObject1_keysInterop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                            this.enumerateTruffleObject1_notIterable_ = (BranchProfile.create());
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                            this.enumerateTruffleObject0_cache = null;
                            state_0 = state_0 & 0xfffffffb /* remove-state_0 doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return doEnumerateTruffleObject(targetNodeValue, enumerateTruffleObject1_interop__, this.enumerateTruffleObject1_keysInterop_, this.enumerateTruffleObject1_notIterable_);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if ((!(JSGuards.isJSObject(targetNodeValue))) && (!(JSGuards.isForeignObject(targetNodeValue)))) {
                this.nonObject_toObjectNode_ = super.insert((JSToObjectNode.createToObjectNoCheck(context)));
                this.nonObject_enumerateNode_ = super.insert((copyRecursive()));
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doNonObject(Object, JSToObjectNode, EnumerateNode) */;
                lock.unlock();
                hasLock = false;
                return doNonObject(targetNodeValue, this.nonObject_toObjectNode_, this.nonObject_enumerateNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.targetNode}, targetNodeValue);
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
                EnumerateTruffleObject0Data s2_ = this.enumerateTruffleObject0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doEnumerateObject";
        if ((state_0 & 0b1) != 0 /* is-state_0 doEnumerateObject(DynamicObject, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.enumerateObject_isObject_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doEnumerateJSAdapter";
        if ((state_0 & 0b10) != 0 /* is-state_0 doEnumerateJSAdapter(DynamicObject, EnumerateNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.enumerateJSAdapter_enumerateCallbackResultNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doEnumerateTruffleObject";
        if ((state_0 & 0b100) != 0 /* is-state_0 doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            EnumerateTruffleObject0Data s2_ = this.enumerateTruffleObject0_cache;
            while (s2_ != null) {
                cached.add(Arrays.asList(s2_.interop_, s2_.keysInterop_, s2_.notIterable_));
                s2_ = s2_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doEnumerateTruffleObject";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.enumerateTruffleObject1_keysInterop_, this.enumerateTruffleObject1_notIterable_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doNonObject";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doNonObject(Object, JSToObjectNode, EnumerateNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.nonObject_toObjectNode_, this.nonObject_enumerateNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static EnumerateNode create(JSContext context, boolean values, boolean requireIterable, JavaScriptNode targetNode) {
        return new EnumerateNodeGen(context, values, requireIterable, targetNode);
    }

    @GeneratedBy(EnumerateNode.class)
    private static final class EnumerateTruffleObject0Data extends Node {

        @Child EnumerateTruffleObject0Data next_;
        @Child InteropLibrary interop_;
        @Child InteropLibrary keysInterop_;
        @CompilationFinal BranchProfile notIterable_;

        EnumerateTruffleObject0Data(EnumerateTruffleObject0Data next_) {
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
