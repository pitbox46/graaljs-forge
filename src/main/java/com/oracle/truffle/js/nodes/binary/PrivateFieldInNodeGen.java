// CheckStyle: start generated
package com.oracle.truffle.js.nodes.binary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.object.HiddenKey;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.IsObjectNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PrivateFieldInNode.class)
@SuppressWarnings("unused")
public final class PrivateFieldInNodeGen extends PrivateFieldInNode implements Introspection.Provider {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private Instance0Data instance0_cache;
    @Child private IsObjectNode fallback_isObjectNode_;

    private PrivateFieldInNodeGen(JavaScriptNode left, JavaScriptNode right) {
        super(left, right);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b111) != 0 /* is-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) || doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) || doStatic(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(rightNodeValue_)) {
            DynamicObject rightNodeValue__ = (DynamicObject) rightNodeValue_;
            if ((state_0 & 0b11) != 0 /* is-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) || doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */ && leftNodeValue_ instanceof HiddenKey) {
                HiddenKey leftNodeValue__ = (HiddenKey) leftNodeValue_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */) {
                    Instance0Data s0_ = this.instance0_cache;
                    while (s0_ != null) {
                        if ((s0_.access_.accepts(rightNodeValue__)) && (JSGuards.isJSObject(rightNodeValue__))) {
                            return doInstance(leftNodeValue__, rightNodeValue__, s0_.access_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */) {
                    if ((JSGuards.isJSObject(rightNodeValue__))) {
                        return this.instance1Boundary(state_0, leftNodeValue__, rightNodeValue__);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doStatic(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(leftNodeValue_)) {
                DynamicObject leftNodeValue__ = (DynamicObject) leftNodeValue_;
                if ((JSGuards.isJSObject(rightNodeValue__))) {
                    return doStatic(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doFallback(Object, Object, IsObjectNode) */) {
            if (fallbackGuard_(leftNodeValue_, rightNodeValue_)) {
                return doFallback(leftNodeValue_, rightNodeValue_, this.fallback_isObjectNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object instance1Boundary(int state_0, HiddenKey leftNodeValue__, DynamicObject rightNodeValue__) {
        {
            DynamicObjectLibrary instance1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(rightNodeValue__));
            return doInstance(leftNodeValue__, rightNodeValue__, instance1_access__);
        }
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b111) != 0 /* is-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) || doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) || doStatic(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(rightNodeValue_)) {
            DynamicObject rightNodeValue__ = (DynamicObject) rightNodeValue_;
            if ((state_0 & 0b11) != 0 /* is-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) || doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */ && leftNodeValue_ instanceof HiddenKey) {
                HiddenKey leftNodeValue__ = (HiddenKey) leftNodeValue_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */) {
                    Instance0Data s0_ = this.instance0_cache;
                    while (s0_ != null) {
                        if ((s0_.access_.accepts(rightNodeValue__)) && (JSGuards.isJSObject(rightNodeValue__))) {
                            return doInstance(leftNodeValue__, rightNodeValue__, s0_.access_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */) {
                    if ((JSGuards.isJSObject(rightNodeValue__))) {
                        return this.instance1Boundary0(state_0, leftNodeValue__, rightNodeValue__);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doStatic(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(leftNodeValue_)) {
                DynamicObject leftNodeValue__ = (DynamicObject) leftNodeValue_;
                if ((JSGuards.isJSObject(rightNodeValue__))) {
                    return doStatic(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doFallback(Object, Object, IsObjectNode) */) {
            if (fallbackGuard_(leftNodeValue_, rightNodeValue_)) {
                return doFallback(leftNodeValue_, rightNodeValue_, this.fallback_isObjectNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private boolean instance1Boundary0(int state_0, HiddenKey leftNodeValue__, DynamicObject rightNodeValue__) {
        {
            DynamicObjectLibrary instance1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(rightNodeValue__));
            return doInstance(leftNodeValue__, rightNodeValue__, instance1_access__);
        }
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    private boolean executeAndSpecialize(Object leftNodeValue, Object rightNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (JSTypes.isDynamicObject(rightNodeValue)) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                if (leftNodeValue instanceof HiddenKey) {
                    HiddenKey leftNodeValue_ = (HiddenKey) leftNodeValue;
                    if ((exclude) == 0 /* is-not-exclude doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */) {
                        int count0_ = 0;
                        Instance0Data s0_ = this.instance0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.access_.accepts(rightNodeValue_)) && (JSGuards.isJSObject(rightNodeValue_))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            if ((JSGuards.isJSObject(rightNodeValue_)) && count0_ < (3)) {
                                // assert (s0_.access_.accepts(rightNodeValue_));
                                s0_ = super.insert(new Instance0Data(instance0_cache));
                                s0_.access_ = s0_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.create(rightNodeValue_)));
                                MemoryFence.storeStore();
                                this.instance0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doInstance(leftNodeValue_, rightNodeValue_, s0_.access_);
                        }
                    }
                    {
                        DynamicObjectLibrary instance1_access__ = null;
                        if ((JSGuards.isJSObject(rightNodeValue_))) {
                            instance1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(rightNodeValue_));
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */;
                            this.instance0_cache = null;
                            state_0 = state_0 & 0xfffffffe /* remove-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return doInstance(leftNodeValue_, rightNodeValue_, instance1_access__);
                        }
                    }
                }
                if (JSTypes.isDynamicObject(leftNodeValue)) {
                    DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
                    if ((JSGuards.isJSObject(rightNodeValue_))) {
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doStatic(DynamicObject, DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return doStatic(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            this.fallback_isObjectNode_ = super.insert((IsObjectNode.create()));
            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doFallback(Object, Object, IsObjectNode) */;
            lock.unlock();
            hasLock = false;
            return doFallback(leftNodeValue, rightNodeValue, this.fallback_isObjectNode_);
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
                Instance0Data s0_ = this.instance0_cache;
                if ((s0_ == null || s0_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[5];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doInstance";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            Instance0Data s0_ = this.instance0_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.access_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInstance";
        if ((state_0 & 0b10) != 0 /* is-state_0 doInstance(HiddenKey, DynamicObject, DynamicObjectLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doStatic";
        if ((state_0 & 0b100) != 0 /* is-state_0 doStatic(DynamicObject, DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doFallback";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doFallback(Object, Object, IsObjectNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.fallback_isObjectNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(Object leftNodeValue, Object rightNodeValue) {
        if (JSTypes.isDynamicObject(rightNodeValue)) {
            if (leftNodeValue instanceof HiddenKey) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                if ((JSGuards.isJSObject(rightNodeValue_))) {
                    return false;
                }
            }
            if (JSTypes.isDynamicObject(leftNodeValue)) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                if ((JSGuards.isJSObject(rightNodeValue_))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static PrivateFieldInNode create(JavaScriptNode left, JavaScriptNode right) {
        return new PrivateFieldInNodeGen(left, right);
    }

    @GeneratedBy(PrivateFieldInNode.class)
    private static final class Instance0Data extends Node {

        @Child Instance0Data next_;
        @Child DynamicObjectLibrary access_;

        Instance0Data(Instance0Data next_) {
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
