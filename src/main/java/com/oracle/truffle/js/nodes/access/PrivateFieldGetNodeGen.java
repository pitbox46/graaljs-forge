// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

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
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.objects.Accessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PrivateFieldGetNode.class)
@SuppressWarnings("unused")
public final class PrivateFieldGetNodeGen extends PrivateFieldGetNode implements Introspection.Provider {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private Field0Data field0_cache;
    @CompilationFinal private BranchProfile field1_errorBranch_;
    @Child private JSFunctionCallNode accessor_callNode_;
    @CompilationFinal private BranchProfile accessor_errorBranch_;

    private PrivateFieldGetNodeGen(JavaScriptNode targetNode, JavaScriptNode keyNode, JSContext context) {
        super(targetNode, keyNode, context);
    }

    @ExplodeLoop
    @Override
    public Object executeWithTarget(VirtualFrame frameValue, Object targetNodeValue) {
        int state_0 = this.state_0_;
        Object keyNodeValue_ = super.keyNode.execute(frameValue);
        if ((state_0 & 0b1111) != 0 /* is-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) || doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) || doMethod(DynamicObject, DynamicObject) || doAccessor(DynamicObject, Accessor, JSFunctionCallNode, BranchProfile) */ && JSTypes.isDynamicObject(targetNodeValue)) {
            DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
            if ((state_0 & 0b11) != 0 /* is-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) || doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */ && keyNodeValue_ instanceof HiddenKey) {
                HiddenKey keyNodeValue__ = (HiddenKey) keyNodeValue_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */) {
                    Field0Data s0_ = this.field0_cache;
                    while (s0_ != null) {
                        if ((s0_.access_.accepts(targetNodeValue_)) && (JSGuards.isJSObject(targetNodeValue_))) {
                            return doField(targetNodeValue_, keyNodeValue__, s0_.access_, s0_.errorBranch_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */) {
                    if ((JSGuards.isJSObject(targetNodeValue_))) {
                        return this.field1Boundary(state_0, targetNodeValue_, keyNodeValue__);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doMethod(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(keyNodeValue_)) {
                DynamicObject keyNodeValue__ = (DynamicObject) keyNodeValue_;
                if ((JSGuards.isJSObject(targetNodeValue_)) && (JSGuards.isJSFunction(keyNodeValue__))) {
                    return doMethod(targetNodeValue_, keyNodeValue__);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doAccessor(DynamicObject, Accessor, JSFunctionCallNode, BranchProfile) */ && keyNodeValue_ instanceof Accessor) {
                Accessor keyNodeValue__ = (Accessor) keyNodeValue_;
                if ((JSGuards.isJSObject(targetNodeValue_))) {
                    return doAccessor(targetNodeValue_, keyNodeValue__, this.accessor_callNode_, this.accessor_errorBranch_);
                }
            }
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 missing(Object, Object) */) {
            if (fallbackGuard_(targetNodeValue, keyNodeValue_)) {
                return missing(targetNodeValue, keyNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue, keyNodeValue_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object field1Boundary(int state_0, DynamicObject targetNodeValue_, HiddenKey keyNodeValue__) {
        {
            DynamicObjectLibrary field1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(targetNodeValue_));
            return doField(targetNodeValue_, keyNodeValue__, field1_access__, this.field1_errorBranch_);
        }
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object targetNodeValue_ = super.targetNode.execute(frameValue);
        Object keyNodeValue_ = super.keyNode.execute(frameValue);
        if ((state_0 & 0b1111) != 0 /* is-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) || doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) || doMethod(DynamicObject, DynamicObject) || doAccessor(DynamicObject, Accessor, JSFunctionCallNode, BranchProfile) */ && JSTypes.isDynamicObject(targetNodeValue_)) {
            DynamicObject targetNodeValue__ = (DynamicObject) targetNodeValue_;
            if ((state_0 & 0b11) != 0 /* is-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) || doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */ && keyNodeValue_ instanceof HiddenKey) {
                HiddenKey keyNodeValue__ = (HiddenKey) keyNodeValue_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */) {
                    Field0Data s0_ = this.field0_cache;
                    while (s0_ != null) {
                        if ((s0_.access_.accepts(targetNodeValue__)) && (JSGuards.isJSObject(targetNodeValue__))) {
                            return doField(targetNodeValue__, keyNodeValue__, s0_.access_, s0_.errorBranch_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */) {
                    if ((JSGuards.isJSObject(targetNodeValue__))) {
                        return this.field1Boundary0(state_0, targetNodeValue__, keyNodeValue__);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doMethod(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(keyNodeValue_)) {
                DynamicObject keyNodeValue__ = (DynamicObject) keyNodeValue_;
                if ((JSGuards.isJSObject(targetNodeValue__)) && (JSGuards.isJSFunction(keyNodeValue__))) {
                    return doMethod(targetNodeValue__, keyNodeValue__);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doAccessor(DynamicObject, Accessor, JSFunctionCallNode, BranchProfile) */ && keyNodeValue_ instanceof Accessor) {
                Accessor keyNodeValue__ = (Accessor) keyNodeValue_;
                if ((JSGuards.isJSObject(targetNodeValue__))) {
                    return doAccessor(targetNodeValue__, keyNodeValue__, this.accessor_callNode_, this.accessor_errorBranch_);
                }
            }
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 missing(Object, Object) */) {
            if (fallbackGuard_(targetNodeValue_, keyNodeValue_)) {
                return missing(targetNodeValue_, keyNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue_, keyNodeValue_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object field1Boundary0(int state_0, DynamicObject targetNodeValue__, HiddenKey keyNodeValue__) {
        {
            DynamicObjectLibrary field1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(targetNodeValue__));
            return doField(targetNodeValue__, keyNodeValue__, field1_access__, this.field1_errorBranch_);
        }
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object targetNodeValue, Object keyNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (JSTypes.isDynamicObject(targetNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if (keyNodeValue instanceof HiddenKey) {
                    HiddenKey keyNodeValue_ = (HiddenKey) keyNodeValue;
                    if ((exclude) == 0 /* is-not-exclude doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */) {
                        int count0_ = 0;
                        Field0Data s0_ = this.field0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.access_.accepts(targetNodeValue_)) && (JSGuards.isJSObject(targetNodeValue_))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            if ((JSGuards.isJSObject(targetNodeValue_)) && count0_ < (3)) {
                                // assert (s0_.access_.accepts(targetNodeValue_));
                                s0_ = super.insert(new Field0Data(field0_cache));
                                s0_.access_ = s0_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.create(targetNodeValue_)));
                                s0_.errorBranch_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.field0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doField(targetNodeValue_, keyNodeValue_, s0_.access_, s0_.errorBranch_);
                        }
                    }
                    {
                        DynamicObjectLibrary field1_access__ = null;
                        if ((JSGuards.isJSObject(targetNodeValue_))) {
                            field1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(targetNodeValue_));
                            this.field1_errorBranch_ = (BranchProfile.create());
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */;
                            this.field0_cache = null;
                            state_0 = state_0 & 0xfffffffe /* remove-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return doField(targetNodeValue_, keyNodeValue_, field1_access__, this.field1_errorBranch_);
                        }
                    }
                }
                if (JSTypes.isDynamicObject(keyNodeValue)) {
                    DynamicObject keyNodeValue_ = (DynamicObject) keyNodeValue;
                    if ((JSGuards.isJSObject(targetNodeValue_)) && (JSGuards.isJSFunction(keyNodeValue_))) {
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doMethod(DynamicObject, DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return doMethod(targetNodeValue_, keyNodeValue_);
                    }
                }
                if (keyNodeValue instanceof Accessor) {
                    Accessor keyNodeValue_ = (Accessor) keyNodeValue;
                    if ((JSGuards.isJSObject(targetNodeValue_))) {
                        this.accessor_callNode_ = super.insert((JSFunctionCallNode.createCall()));
                        this.accessor_errorBranch_ = (BranchProfile.create());
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doAccessor(DynamicObject, Accessor, JSFunctionCallNode, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doAccessor(targetNodeValue_, keyNodeValue_, this.accessor_callNode_, this.accessor_errorBranch_);
                    }
                }
            }
            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 missing(Object, Object) */;
            lock.unlock();
            hasLock = false;
            return missing(targetNodeValue, keyNodeValue);
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
                Field0Data s0_ = this.field0_cache;
                if ((s0_ == null || s0_.next_ == null)) {
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
        s[0] = "doField";
        if ((state_0 & 0b1) != 0 /* is-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            Field0Data s0_ = this.field0_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.access_, s0_.errorBranch_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doField";
        if ((state_0 & 0b10) != 0 /* is-state_0 doField(DynamicObject, HiddenKey, DynamicObjectLibrary, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.field1_errorBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doMethod";
        if ((state_0 & 0b100) != 0 /* is-state_0 doMethod(DynamicObject, DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doAccessor";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doAccessor(DynamicObject, Accessor, JSFunctionCallNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.accessor_callNode_, this.accessor_errorBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "missing";
        if ((state_0 & 0b10000) != 0 /* is-state_0 missing(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(Object targetNodeValue, Object keyNodeValue) {
        if (JSTypes.isDynamicObject(targetNodeValue)) {
            if (keyNodeValue instanceof HiddenKey) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSObject(targetNodeValue_))) {
                    return false;
                }
            }
            if (JSTypes.isDynamicObject(keyNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSObject(targetNodeValue_))) {
                    DynamicObject keyNodeValue_ = (DynamicObject) keyNodeValue;
                    if ((JSGuards.isJSFunction(keyNodeValue_))) {
                        return false;
                    }
                }
            }
            if (keyNodeValue instanceof Accessor) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSObject(targetNodeValue_))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static PrivateFieldGetNode create(JavaScriptNode targetNode, JavaScriptNode keyNode, JSContext context) {
        return new PrivateFieldGetNodeGen(targetNode, keyNode, context);
    }

    @GeneratedBy(PrivateFieldGetNode.class)
    private static final class Field0Data extends Node {

        @Child Field0Data next_;
        @Child DynamicObjectLibrary access_;
        @CompilationFinal BranchProfile errorBranch_;

        Field0Data(Field0Data next_) {
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
