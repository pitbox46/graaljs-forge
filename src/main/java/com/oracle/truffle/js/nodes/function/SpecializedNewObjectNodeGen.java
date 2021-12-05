// CheckStyle: start generated
package com.oracle.truffle.js.nodes.function;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSOrdinary;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SpecializedNewObjectNode.class)
public final class SpecializedNewObjectNodeGen extends SpecializedNewObjectNode implements Introspection.Provider {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private DynamicObjectLibrary setProtoNode;
    @CompilationFinal private CachedProtoData cachedProto_cache;
    @CompilationFinal private BranchProfile uncachedProto_slowBranch_;
    @CompilationFinal private Class<?> createWithProtoCachedClass_prototypeClass_;
    @CompilationFinal private Shape createWithProtoCachedClass_cachedShape_;
    @CompilationFinal private Shape createWithProto_cachedShape_;

    private SpecializedNewObjectNodeGen(JSContext context, boolean isBuiltin, boolean isConstructor, boolean isGenerator, boolean isAsyncGenerator, JSOrdinary instanceLayout) {
        super(context, isBuiltin, isConstructor, isGenerator, isAsyncGenerator, instanceLayout);
    }

    @ExplodeLoop
    @Override
    protected DynamicObject execute(DynamicObject arg0Value, Object arg1Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doCachedProto(DynamicObject, Object, Object, Shape) || doUncachedProto(DynamicObject, DynamicObject, BranchProfile) || createWithProtoCachedClass(DynamicObject, Object, DynamicObjectLibrary, Class<>, Shape) || createWithProto(DynamicObject, DynamicObject, DynamicObjectLibrary, Shape) || createDefaultProto(DynamicObject, Object) || builtinConstructor(DynamicObject, Object) || throwNotConstructorFunctionTypeError(DynamicObject, Object) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doCachedProto(DynamicObject, Object, Object, Shape) */) {
                assert (!(isBuiltin));
                assert (isConstructor);
                assert (!(context.isMultiContext()));
                CachedProtoData s0_ = this.cachedProto_cache;
                while (s0_ != null) {
                    assert (JSGuards.isJSObject(s0_.cachedPrototype_));
                    if ((arg1Value == s0_.cachedPrototype_)) {
                        return doCachedProto(arg0Value, arg1Value, s0_.cachedPrototype_, s0_.shape_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doUncachedProto(DynamicObject, DynamicObject, BranchProfile) */ && JSTypes.isDynamicObject(arg1Value)) {
                DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                assert (!(isBuiltin));
                assert (isConstructor);
                assert (!(context.isMultiContext()));
                if ((JSGuards.isJSObject(arg1Value_))) {
                    return doUncachedProto(arg0Value, arg1Value_, this.uncachedProto_slowBranch_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 createWithProtoCachedClass(DynamicObject, Object, DynamicObjectLibrary, Class<>, Shape) */) {
                assert (!(isBuiltin));
                assert (isConstructor);
                assert (context.isMultiContext());
                assert (this.createWithProtoCachedClass_prototypeClass_ != null);
                if ((this.createWithProtoCachedClass_prototypeClass_.isInstance(arg1Value))) {
                    return createWithProtoCachedClass(arg0Value, arg1Value, this.setProtoNode, this.createWithProtoCachedClass_prototypeClass_, this.createWithProtoCachedClass_cachedShape_);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 createWithProto(DynamicObject, DynamicObject, DynamicObjectLibrary, Shape) */ && JSTypes.isDynamicObject(arg1Value)) {
                DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                assert (!(isBuiltin));
                assert (isConstructor);
                assert (context.isMultiContext());
                if ((JSGuards.isJSObject(arg1Value_))) {
                    return createWithProto(arg0Value, arg1Value_, this.setProtoNode, this.createWithProto_cachedShape_);
                }
            }
            if ((state_0 & 0b1110000) != 0 /* is-state_0 createDefaultProto(DynamicObject, Object) || builtinConstructor(DynamicObject, Object) || throwNotConstructorFunctionTypeError(DynamicObject, Object) */) {
                if ((state_0 & 0b10000) != 0 /* is-state_0 createDefaultProto(DynamicObject, Object) */) {
                    assert (!(isBuiltin));
                    assert (isConstructor);
                    if ((!(JSGuards.isJSObject(arg1Value)))) {
                        return createDefaultProto(arg0Value, arg1Value);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 builtinConstructor(DynamicObject, Object) */) {
                    assert (isBuiltin);
                    assert (isConstructor);
                    return SpecializedNewObjectNode.builtinConstructor(arg0Value, arg1Value);
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 throwNotConstructorFunctionTypeError(DynamicObject, Object) */) {
                    assert (!(isConstructor));
                    return throwNotConstructorFunctionTypeError(arg0Value, arg1Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private DynamicObject executeAndSpecialize(DynamicObject arg0Value, Object arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            int oldState_0 = state_0;
            try {
                if ((exclude) == 0 /* is-not-exclude doCachedProto(DynamicObject, Object, Object, Shape) */ && (!(isBuiltin)) && (isConstructor) && (!(context.isMultiContext()))) {
                    int count0_ = 0;
                    CachedProtoData s0_ = this.cachedProto_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCachedProto(DynamicObject, Object, Object, Shape) */) {
                        while (s0_ != null) {
                            assert (JSGuards.isJSObject(s0_.cachedPrototype_));
                            if ((arg1Value == s0_.cachedPrototype_)) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        {
                            Object cachedPrototype__ = (arg1Value);
                            if ((JSGuards.isJSObject(cachedPrototype__))) {
                                // assert (arg1Value == cachedPrototype__);
                                if (count0_ < (context.getPropertyCacheLimit())) {
                                    s0_ = new CachedProtoData(cachedProto_cache);
                                    s0_.cachedPrototype_ = cachedPrototype__;
                                    s0_.shape_ = (getProtoChildShape(arg1Value));
                                    MemoryFence.storeStore();
                                    this.cachedProto_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCachedProto(DynamicObject, Object, Object, Shape) */;
                                }
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCachedProto(arg0Value, arg1Value, s0_.cachedPrototype_, s0_.shape_);
                    }
                }
                if (JSTypes.isDynamicObject(arg1Value)) {
                    DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                    if ((!(isBuiltin)) && (isConstructor) && (!(context.isMultiContext())) && (JSGuards.isJSObject(arg1Value_))) {
                        this.uncachedProto_slowBranch_ = (BranchProfile.create());
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCachedProto(DynamicObject, Object, Object, Shape) */;
                        this.cachedProto_cache = null;
                        state_0 = state_0 & 0xfffffffe /* remove-state_0 doCachedProto(DynamicObject, Object, Object, Shape) */;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncachedProto(DynamicObject, DynamicObject, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doUncachedProto(arg0Value, arg1Value_, this.uncachedProto_slowBranch_);
                    }
                }
                boolean CreateWithProtoCachedClass_duplicateFound_ = false;
                if ((state_0 & 0b100) != 0 /* is-state_0 createWithProtoCachedClass(DynamicObject, Object, DynamicObjectLibrary, Class<>, Shape) */) {
                    assert (!(isBuiltin));
                    assert (isConstructor);
                    assert (context.isMultiContext());
                    assert (this.createWithProtoCachedClass_prototypeClass_ != null);
                    if ((this.createWithProtoCachedClass_prototypeClass_.isInstance(arg1Value))) {
                        CreateWithProtoCachedClass_duplicateFound_ = true;
                    }
                }
                if (!CreateWithProtoCachedClass_duplicateFound_) {
                    if ((!(isBuiltin)) && (isConstructor) && (context.isMultiContext())) {
                        Class<?> createWithProtoCachedClass_prototypeClass__ = (JSGuards.getClassIfJSObject(arg1Value));
                        if ((createWithProtoCachedClass_prototypeClass__ != null) && (createWithProtoCachedClass_prototypeClass__.isInstance(arg1Value)) && ((state_0 & 0b100)) == 0 /* is-not-state_0 createWithProtoCachedClass(DynamicObject, Object, DynamicObjectLibrary, Class<>, Shape) */) {
                            this.setProtoNode = super.insert(this.setProtoNode == null ? ((DYNAMIC_OBJECT_LIBRARY_.createDispatched(3))) : this.setProtoNode);
                            this.createWithProtoCachedClass_prototypeClass_ = createWithProtoCachedClass_prototypeClass__;
                            this.createWithProtoCachedClass_cachedShape_ = (getShapeWithoutProto());
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 createWithProtoCachedClass(DynamicObject, Object, DynamicObjectLibrary, Class<>, Shape) */;
                            CreateWithProtoCachedClass_duplicateFound_ = true;
                        }
                    }
                }
                if (CreateWithProtoCachedClass_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return createWithProtoCachedClass(arg0Value, arg1Value, this.setProtoNode, this.createWithProtoCachedClass_prototypeClass_, this.createWithProtoCachedClass_cachedShape_);
                }
                if (JSTypes.isDynamicObject(arg1Value)) {
                    DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                    if ((!(isBuiltin)) && (isConstructor) && (context.isMultiContext()) && (JSGuards.isJSObject(arg1Value_))) {
                        this.setProtoNode = super.insert(this.setProtoNode == null ? ((DYNAMIC_OBJECT_LIBRARY_.createDispatched(3))) : this.setProtoNode);
                        this.createWithProto_cachedShape_ = (getShapeWithoutProto());
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 createWithProto(DynamicObject, DynamicObject, DynamicObjectLibrary, Shape) */;
                        lock.unlock();
                        hasLock = false;
                        return createWithProto(arg0Value, arg1Value_, this.setProtoNode, this.createWithProto_cachedShape_);
                    }
                }
                if ((!(isBuiltin)) && (isConstructor) && (!(JSGuards.isJSObject(arg1Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 createDefaultProto(DynamicObject, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return createDefaultProto(arg0Value, arg1Value);
                }
                if ((isBuiltin) && (isConstructor)) {
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 builtinConstructor(DynamicObject, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return SpecializedNewObjectNode.builtinConstructor(arg0Value, arg1Value);
                }
                if ((!(isConstructor))) {
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 throwNotConstructorFunctionTypeError(DynamicObject, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return throwNotConstructorFunctionTypeError(arg0Value, arg1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            } finally {
                if (oldState_0 != 0) {
                    checkForPolymorphicSpecialize(oldState_0);
                }
            }
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    private void checkForPolymorphicSpecialize(int oldState_0) {
        if (((oldState_0 & 0b10) == 0 && (this.state_0_ & 0b10) != 0)) {
            this.reportPolymorphicSpecialize();
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if (state_0 == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                CachedProtoData s0_ = this.cachedProto_cache;
                if ((s0_ == null || s0_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[8];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doCachedProto";
        if ((state_0 & 0b1) != 0 /* is-state_0 doCachedProto(DynamicObject, Object, Object, Shape) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedProtoData s0_ = this.cachedProto_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedPrototype_, s0_.shape_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doCachedProto(DynamicObject, Object, Object, Shape) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncachedProto";
        if ((state_0 & 0b10) != 0 /* is-state_0 doUncachedProto(DynamicObject, DynamicObject, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.uncachedProto_slowBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "createWithProtoCachedClass";
        if ((state_0 & 0b100) != 0 /* is-state_0 createWithProtoCachedClass(DynamicObject, Object, DynamicObjectLibrary, Class<>, Shape) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.setProtoNode, this.createWithProtoCachedClass_prototypeClass_, this.createWithProtoCachedClass_cachedShape_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "createWithProto";
        if ((state_0 & 0b1000) != 0 /* is-state_0 createWithProto(DynamicObject, DynamicObject, DynamicObjectLibrary, Shape) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.setProtoNode, this.createWithProto_cachedShape_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "createDefaultProto";
        if ((state_0 & 0b10000) != 0 /* is-state_0 createDefaultProto(DynamicObject, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "builtinConstructor";
        if ((state_0 & 0b100000) != 0 /* is-state_0 builtinConstructor(DynamicObject, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "throwNotConstructorFunctionTypeError";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 throwNotConstructorFunctionTypeError(DynamicObject, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static SpecializedNewObjectNode create(JSContext context, boolean isBuiltin, boolean isConstructor, boolean isGenerator, boolean isAsyncGenerator, JSOrdinary instanceLayout) {
        return new SpecializedNewObjectNodeGen(context, isBuiltin, isConstructor, isGenerator, isAsyncGenerator, instanceLayout);
    }

    @GeneratedBy(SpecializedNewObjectNode.class)
    private static final class CachedProtoData {

        @CompilationFinal CachedProtoData next_;
        @CompilationFinal Object cachedPrototype_;
        @CompilationFinal Shape shape_;

        CachedProtoData(CachedProtoData next_) {
            this.next_ = next_;
        }

    }
}
