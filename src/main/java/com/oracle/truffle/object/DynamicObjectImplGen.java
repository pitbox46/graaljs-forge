// CheckStyle: start generated
package com.oracle.truffle.object;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.ObjectType;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.object.DynamicObjectImpl.Accepts;
import com.oracle.truffle.object.DynamicObjectImpl.Dispatch;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DynamicObjectImpl.class)
@SuppressWarnings("unused")
public final class DynamicObjectImplGen {

    static  {
        LibraryExport.register(DynamicObjectImpl.class, new DynamicDispatchLibraryExports());
    }

    private DynamicObjectImplGen() {
    }

    @GeneratedBy(DynamicObjectImpl.class)
    public static class DynamicDispatchLibraryExports extends LibraryExport<DynamicDispatchLibrary> {

        private DynamicDispatchLibraryExports() {
            super(DynamicDispatchLibrary.class, DynamicObjectImpl.class, false, false, 0);
        }

        @Override
        protected DynamicDispatchLibrary createUncached(Object receiver) {
            assert receiver instanceof DynamicObjectImpl;
            DynamicDispatchLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected DynamicDispatchLibrary createCached(Object receiver) {
            assert receiver instanceof DynamicObjectImpl;
            return new Cached(receiver);
        }

        @GeneratedBy(DynamicObjectImpl.class)
        public static class Cached extends DynamicDispatchLibrary {

            private final Class<? extends DynamicObjectImpl> receiverClass_;
            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @CompilationFinal private Shape cachedShape;
            @CompilationFinal private Class<? extends ObjectType> cachedTypeClass;

            protected Cached(Object receiver) {
                DynamicObjectImpl castReceiver = ((DynamicObjectImpl) receiver) ;
                this.receiverClass_ = castReceiver.getClass();
            }

            @Override
            public Object cast(Object receiver) {
                return CompilerDirectives.castExact(receiver, receiverClass_);
            }

            @Override
            public boolean accepts(Object receiver) {
                return CompilerDirectives.isExact(receiver, this.receiverClass_) && accepts_(receiver);
            }

            private boolean accepts_(Object arg0Value_) {
                DynamicObjectImpl arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) != 0 /* is-state_0 doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) || doCachedTypeClass(DynamicObjectImpl, Class<? extends ObjectType>) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */) {
                        if ((this.cachedShape == arg0Value.getShape())) {
                            return Accepts.doCachedShape(arg0Value, this.cachedShape, this.cachedTypeClass);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCachedTypeClass(DynamicObjectImpl, Class<? extends ObjectType>) */) {
                        return Accepts.doCachedTypeClass(arg0Value, this.cachedTypeClass);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return acceptsAndSpecialize(arg0Value);
            }

            private boolean acceptsAndSpecialize(DynamicObjectImpl arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if (((exclude & 0b1)) == 0 /* is-not-exclude doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */) {
                        boolean CachedShape_duplicateFound_ = false;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */) {
                            if ((this.cachedShape == arg0Value.getShape())) {
                                CachedShape_duplicateFound_ = true;
                            }
                        }
                        if (!CachedShape_duplicateFound_) {
                            {
                                Shape accepts_cachedShape_cachedShape__ = this.cachedShape == null ? ((arg0Value.getShape())) : this.cachedShape;
                                if ((accepts_cachedShape_cachedShape__ == arg0Value.getShape()) && ((state_0 & 0b1)) == 0 /* is-not-state_0 doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */) {
                                    if (this.cachedShape == null) {
                                        Shape accepts_cachedShape_cachedShape___check = accepts_cachedShape_cachedShape__;
                                        if (accepts_cachedShape_cachedShape___check == null) {
                                            throw new AssertionError("Specialization 'doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>)' contains a shared cache with name 'cachedShape' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                        }
                                        this.cachedShape = accepts_cachedShape_cachedShape___check;
                                    }
                                    this.cachedTypeClass = this.cachedTypeClass == null ? ((DynamicObjectImpl.getObjectType(arg0Value.getShape()).getClass())) : this.cachedTypeClass;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */;
                                    CachedShape_duplicateFound_ = true;
                                }
                            }
                        }
                        if (CachedShape_duplicateFound_) {
                            lock.unlock();
                            hasLock = false;
                            return Accepts.doCachedShape(arg0Value, this.cachedShape, this.cachedTypeClass);
                        }
                    }
                    this.cachedTypeClass = this.cachedTypeClass == null ? ((DynamicObjectImpl.getObjectType(arg0Value.getShape()).getClass())) : this.cachedTypeClass;
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCachedTypeClass(DynamicObjectImpl, Class<? extends ObjectType>) */;
                    lock.unlock();
                    hasLock = false;
                    return Accepts.doCachedTypeClass(arg0Value, this.cachedTypeClass);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public NodeCost getCost() {
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    if (((state_0 & 0b11) & ((state_0 & 0b11) - 1)) == 0 /* is-single-state_0  */) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            @Override
            public Class<?> dispatch(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                DynamicObjectImpl arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1100) != 0 /* is-state_0 doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) || doCachedTypeClass(DynamicObjectImpl, Class<? extends ObjectType>) */) {
                    if ((state_0 & 0b100) != 0 /* is-state_0 doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */) {
                        if ((this.cachedShape == arg0Value.getShape())) {
                            return Dispatch.doCachedShape(arg0Value, this.cachedShape, this.cachedTypeClass);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doCachedTypeClass(DynamicObjectImpl, Class<? extends ObjectType>) */) {
                        return Dispatch.doCachedTypeClass(arg0Value, this.cachedTypeClass);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return dispatchAndSpecialize(arg0Value);
            }

            private Class<?> dispatchAndSpecialize(DynamicObjectImpl arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if (((exclude & 0b10)) == 0 /* is-not-exclude doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */) {
                        boolean CachedShape_duplicateFound_ = false;
                        if ((state_0 & 0b100) != 0 /* is-state_0 doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */) {
                            if ((this.cachedShape == arg0Value.getShape())) {
                                CachedShape_duplicateFound_ = true;
                            }
                        }
                        if (!CachedShape_duplicateFound_) {
                            {
                                Shape dispatch_cachedShape_cachedShape__ = this.cachedShape == null ? ((arg0Value.getShape())) : this.cachedShape;
                                if ((dispatch_cachedShape_cachedShape__ == arg0Value.getShape()) && ((state_0 & 0b100)) == 0 /* is-not-state_0 doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */) {
                                    if (this.cachedShape == null) {
                                        Shape dispatch_cachedShape_cachedShape___check = dispatch_cachedShape_cachedShape__;
                                        if (dispatch_cachedShape_cachedShape___check == null) {
                                            throw new AssertionError("Specialization 'doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>)' contains a shared cache with name 'cachedShape' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                        }
                                        this.cachedShape = dispatch_cachedShape_cachedShape___check;
                                    }
                                    this.cachedTypeClass = this.cachedTypeClass == null ? ((DynamicObjectImpl.getObjectType(arg0Value.getShape()).getClass())) : this.cachedTypeClass;
                                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */;
                                    CachedShape_duplicateFound_ = true;
                                }
                            }
                        }
                        if (CachedShape_duplicateFound_) {
                            lock.unlock();
                            hasLock = false;
                            return Dispatch.doCachedShape(arg0Value, this.cachedShape, this.cachedTypeClass);
                        }
                    }
                    this.cachedTypeClass = this.cachedTypeClass == null ? ((DynamicObjectImpl.getObjectType(arg0Value.getShape()).getClass())) : this.cachedTypeClass;
                    this.exclude_ = exclude = exclude | 0b10 /* add-exclude doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */;
                    state_0 = state_0 & 0xfffffffb /* remove-state_0 doCachedShape(DynamicObjectImpl, Shape, Class<? extends ObjectType>) */;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doCachedTypeClass(DynamicObjectImpl, Class<? extends ObjectType>) */;
                    lock.unlock();
                    hasLock = false;
                    return Dispatch.doCachedTypeClass(arg0Value, this.cachedTypeClass);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(DynamicObjectImpl.class)
        public static class Uncached extends DynamicDispatchLibrary {

            protected Uncached(Object receiver) {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                return receiver instanceof DynamicObjectImpl && accepts_(receiver);
            }

            @SuppressWarnings("cast")
            @TruffleBoundary
            @Override
            public Object cast(Object receiver) {
                return ((DynamicObjectImpl) receiver);
            }

            @Override
            public final boolean isAdoptable() {
                return false;
            }

            @Override
            public final NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public Class<?> dispatch(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObjectImpl arg0Value = ((DynamicObjectImpl) arg0Value_);
                return Dispatch.doCachedTypeClass(arg0Value, (DynamicObjectImpl.getObjectType(arg0Value.getShape()).getClass()));
            }

            @TruffleBoundary
            private static boolean accepts_(Object arg0Value_) {
                DynamicObjectImpl arg0Value = ((DynamicObjectImpl) arg0Value_);
                return Accepts.doCachedTypeClass(arg0Value, (DynamicObjectImpl.getObjectType(arg0Value.getShape()).getClass()));
            }

        }
    }
}
