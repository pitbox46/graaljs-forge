// CheckStyle: start generated
package com.oracle.truffle.object;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.library.DefaultExportProvider;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.object.Property;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.object.DynamicObjectLibraryImpl.KeyCacheNode;
import com.oracle.truffle.object.DynamicObjectLibraryImpl.MakeSharedNode;
import com.oracle.truffle.object.DynamicObjectLibraryImpl.ResetShapeNode;
import com.oracle.truffle.object.DynamicObjectLibraryImpl.SetDynamicTypeNode;
import com.oracle.truffle.object.DynamicObjectLibraryImpl.SetFlagsNode;
import com.oracle.truffle.object.DynamicObjectLibraryImplFactory.MakeSharedNodeGen;
import com.oracle.truffle.object.DynamicObjectLibraryImplFactory.ResetShapeNodeGen;
import com.oracle.truffle.object.DynamicObjectLibraryImplFactory.SetDynamicTypeNodeGen;
import com.oracle.truffle.object.DynamicObjectLibraryImplFactory.SetFlagsNodeGen;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DynamicObjectLibraryImpl.class)
@SuppressWarnings("unused")
public final class DynamicObjectLibraryImplGen {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    static  {
        LibraryExport.register(DynamicObjectLibraryImpl.class, new DynamicObjectLibraryExports());
    }

    private DynamicObjectLibraryImplGen() {
    }

    @GeneratedBy(DynamicObjectLibraryImpl.class)
    public static final class DynamicObjectLibraryProvider implements DefaultExportProvider {

        @Override
        public String getLibraryClassName() {
            return "com.oracle.truffle.api.object.DynamicObjectLibrary";
        }

        @Override
        public Class<?> getDefaultExport() {
            return DynamicObjectLibraryImpl.class;
        }

        @Override
        public Class<?> getReceiverClass() {
            return DynamicObject.class;
        }

        @Override
        public int getPriority() {
            return 10;
        }

    }
    @GeneratedBy(DynamicObjectLibraryImpl.class)
    private static final class DynamicObjectLibraryExports extends LibraryExport<DynamicObjectLibrary> {

        private DynamicObjectLibraryExports() {
            super(DynamicObjectLibrary.class, DynamicObject.class, false, false, 0);
        }

        @Override
        protected DynamicObjectLibrary createUncached(Object receiver) {
            assert receiver instanceof DynamicObject;
            DynamicObjectLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected DynamicObjectLibrary createCached(Object receiver) {
            assert receiver instanceof DynamicObject;
            return new Cached(receiver);
        }

        @GeneratedBy(DynamicObjectLibraryImpl.class)
        private static final class Cached extends DynamicObjectLibrary {

            private final Class<? extends DynamicObject> receiverClass_;
            @Child private DynamicObjectLibrary fallback_;
            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private Shape cachedShape;
            @Child private KeyCacheNode keyCache;
            @Child private SetDynamicTypeNode setDynamicTypeNode__setDynamicType_setCache_;
            @Child private SetFlagsNode setShapeFlagsNode__setShapeFlags_setCache_;
            @Child private MakeSharedNode markSharedNode__markShared_setCache_;
            @Child private ResetShapeNode resetShapeNode__resetShape_setCache_;

            protected Cached(Object receiver) {
                DynamicObject castReceiver = ((DynamicObject) receiver) ;
                this.cachedShape = (castReceiver.getShape());
                this.receiverClass_ = castReceiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                return CompilerDirectives.isExact(receiver, this.receiverClass_) && accepts_(receiver);
            }

            private DynamicObjectLibrary getFallback_(DynamicObject receiver) {
                DynamicObjectLibrary localFallback = this.fallback_;
                if (localFallback == null) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    this.fallback_ = localFallback = insert(DYNAMIC_OBJECT_LIBRARY_.createDispatched((5)));
                }
                return localFallback;
            }

            private boolean accepts_(Object arg0Value_) {
                DynamicObject arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                return DynamicObjectLibraryImpl.accepts(arg0Value, this.cachedShape);
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MONOMORPHIC;
            }

            @Override
            public Shape getShape(DynamicObject arg0Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    return DynamicObjectLibraryImpl.getShape(arg0Value, this.cachedShape);
                } else {
                    return getFallback_(arg0Value).getShape(arg0Value);
                }
            }

            @Override
            public Object getOrDefault(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 getOrDefault(DynamicObject, Object, Object, Shape, KeyCacheNode) */) {
                        return DynamicObjectLibraryImpl.getOrDefault(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    return getOrDefaultNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                } else {
                    return getFallback_(arg0Value).getOrDefault(arg0Value, arg1Value, arg2Value);
                }
            }

            private Object getOrDefaultNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getOrDefault(DynamicObject, Object, Object, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    return DynamicObjectLibraryImpl.getOrDefault(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public int getIntOrDefault(DynamicObject arg0Value, Object arg1Value, Object arg2Value) throws UnexpectedResultException {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b10) != 0 /* is-state_0 getIntOrDefault(DynamicObject, Object, Object, Shape, KeyCacheNode) */) {
                        return DynamicObjectLibraryImpl.getIntOrDefault(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    return getIntOrDefaultNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                } else {
                    return getFallback_(arg0Value).getIntOrDefault(arg0Value, arg1Value, arg2Value);
                }
            }

            private int getIntOrDefaultNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value, Object arg2Value) throws UnexpectedResultException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getIntOrDefault(DynamicObject, Object, Object, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    return DynamicObjectLibraryImpl.getIntOrDefault(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public double getDoubleOrDefault(DynamicObject arg0Value, Object arg1Value, Object arg2Value) throws UnexpectedResultException {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b100) != 0 /* is-state_0 getDoubleOrDefault(DynamicObject, Object, Object, Shape, KeyCacheNode) */) {
                        return DynamicObjectLibraryImpl.getDoubleOrDefault(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    return getDoubleOrDefaultNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                } else {
                    return getFallback_(arg0Value).getDoubleOrDefault(arg0Value, arg1Value, arg2Value);
                }
            }

            private double getDoubleOrDefaultNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value, Object arg2Value) throws UnexpectedResultException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 getDoubleOrDefault(DynamicObject, Object, Object, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    return DynamicObjectLibraryImpl.getDoubleOrDefault(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public long getLongOrDefault(DynamicObject arg0Value, Object arg1Value, Object arg2Value) throws UnexpectedResultException {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b1000) != 0 /* is-state_0 getLongOrDefault(DynamicObject, Object, Object, Shape, KeyCacheNode) */) {
                        return DynamicObjectLibraryImpl.getLongOrDefault(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    return getLongOrDefaultNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                } else {
                    return getFallback_(arg0Value).getLongOrDefault(arg0Value, arg1Value, arg2Value);
                }
            }

            private long getLongOrDefaultNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value, Object arg2Value) throws UnexpectedResultException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 getLongOrDefault(DynamicObject, Object, Object, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    return DynamicObjectLibraryImpl.getLongOrDefault(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean containsKey(DynamicObject arg0Value, Object arg1Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b10000) != 0 /* is-state_0 containsKey(DynamicObject, Object, Shape, KeyCacheNode) */) {
                        return DynamicObjectLibraryImpl.containsKey(arg0Value, arg1Value, this.cachedShape, this.keyCache);
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    return containsKeyNode_AndSpecialize(arg0Value, arg1Value);
                } else {
                    return getFallback_(arg0Value).containsKey(arg0Value, arg1Value);
                }
            }

            private boolean containsKeyNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 containsKey(DynamicObject, Object, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    return DynamicObjectLibraryImpl.containsKey(arg0Value, arg1Value, this.cachedShape, this.keyCache);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void put(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b100000) != 0 /* is-state_0 put(DynamicObject, Object, Object, Shape, KeyCacheNode) */) {
                        DynamicObjectLibraryImpl.put(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                        return;
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    putNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                    return;
                } else {
                    getFallback_(arg0Value).put(arg0Value, arg1Value, arg2Value);
                    return;
                }
            }

            private void putNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 put(DynamicObject, Object, Object, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    DynamicObjectLibraryImpl.put(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void putInt(DynamicObject arg0Value, Object arg1Value, int arg2Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 putInt(DynamicObject, Object, int, Shape, KeyCacheNode) */) {
                        DynamicObjectLibraryImpl.putInt(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                        return;
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    putIntNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                    return;
                } else {
                    getFallback_(arg0Value).putInt(arg0Value, arg1Value, arg2Value);
                    return;
                }
            }

            private void putIntNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value, int arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 putInt(DynamicObject, Object, int, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    DynamicObjectLibraryImpl.putInt(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void putLong(DynamicObject arg0Value, Object arg1Value, long arg2Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 putLong(DynamicObject, Object, long, Shape, KeyCacheNode) */) {
                        DynamicObjectLibraryImpl.putLong(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                        return;
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    putLongNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                    return;
                } else {
                    getFallback_(arg0Value).putLong(arg0Value, arg1Value, arg2Value);
                    return;
                }
            }

            private void putLongNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value, long arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 putLong(DynamicObject, Object, long, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    DynamicObjectLibraryImpl.putLong(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void putDouble(DynamicObject arg0Value, Object arg1Value, double arg2Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b100000000) != 0 /* is-state_0 putDouble(DynamicObject, Object, double, Shape, KeyCacheNode) */) {
                        DynamicObjectLibraryImpl.putDouble(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                        return;
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    putDoubleNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                    return;
                } else {
                    getFallback_(arg0Value).putDouble(arg0Value, arg1Value, arg2Value);
                    return;
                }
            }

            private void putDoubleNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value, double arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 putDouble(DynamicObject, Object, double, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    DynamicObjectLibraryImpl.putDouble(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean putIfPresent(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b1000000000) != 0 /* is-state_0 putIfPresent(DynamicObject, Object, Object, Shape, KeyCacheNode) */) {
                        return DynamicObjectLibraryImpl.putIfPresent(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    return putIfPresentNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                } else {
                    return getFallback_(arg0Value).putIfPresent(arg0Value, arg1Value, arg2Value);
                }
            }

            private boolean putIfPresentNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 putIfPresent(DynamicObject, Object, Object, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    return DynamicObjectLibraryImpl.putIfPresent(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void putWithFlags(DynamicObject arg0Value, Object arg1Value, Object arg2Value, int arg3Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b10000000000) != 0 /* is-state_0 putWithFlags(DynamicObject, Object, Object, int, Shape, KeyCacheNode) */) {
                        DynamicObjectLibraryImpl.putWithFlags(arg0Value, arg1Value, arg2Value, arg3Value, this.cachedShape, this.keyCache);
                        return;
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    putWithFlagsNode_AndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
                    return;
                } else {
                    getFallback_(arg0Value).putWithFlags(arg0Value, arg1Value, arg2Value, arg3Value);
                    return;
                }
            }

            private void putWithFlagsNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value, Object arg2Value, int arg3Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 putWithFlags(DynamicObject, Object, Object, int, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    DynamicObjectLibraryImpl.putWithFlags(arg0Value, arg1Value, arg2Value, arg3Value, this.cachedShape, this.keyCache);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void putConstant(DynamicObject arg0Value, Object arg1Value, Object arg2Value, int arg3Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b100000000000) != 0 /* is-state_0 putConstant(DynamicObject, Object, Object, int, Shape, KeyCacheNode) */) {
                        DynamicObjectLibraryImpl.putConstant(arg0Value, arg1Value, arg2Value, arg3Value, this.cachedShape, this.keyCache);
                        return;
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    putConstantNode_AndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
                    return;
                } else {
                    getFallback_(arg0Value).putConstant(arg0Value, arg1Value, arg2Value, arg3Value);
                    return;
                }
            }

            private void putConstantNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value, Object arg2Value, int arg3Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 putConstant(DynamicObject, Object, Object, int, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    DynamicObjectLibraryImpl.putConstant(arg0Value, arg1Value, arg2Value, arg3Value, this.cachedShape, this.keyCache);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Property getProperty(DynamicObject arg0Value, Object arg1Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b1000000000000) != 0 /* is-state_0 getProperty(DynamicObject, Object, Shape, KeyCacheNode) */) {
                        return DynamicObjectLibraryImpl.getProperty(arg0Value, arg1Value, this.cachedShape, this.keyCache);
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    return getPropertyNode_AndSpecialize(arg0Value, arg1Value);
                } else {
                    return getFallback_(arg0Value).getProperty(arg0Value, arg1Value);
                }
            }

            private Property getPropertyNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 getProperty(DynamicObject, Object, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    return DynamicObjectLibraryImpl.getProperty(arg0Value, arg1Value, this.cachedShape, this.keyCache);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean setPropertyFlags(DynamicObject arg0Value, Object arg1Value, int arg2Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b10000000000000) != 0 /* is-state_0 setPropertyFlags(DynamicObject, Object, int, Shape, KeyCacheNode) */) {
                        return DynamicObjectLibraryImpl.setPropertyFlags(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    return setPropertyFlagsNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                } else {
                    return getFallback_(arg0Value).setPropertyFlags(arg0Value, arg1Value, arg2Value);
                }
            }

            private boolean setPropertyFlagsNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value, int arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 setPropertyFlags(DynamicObject, Object, int, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    return DynamicObjectLibraryImpl.setPropertyFlags(arg0Value, arg1Value, arg2Value, this.cachedShape, this.keyCache);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean removeKey(DynamicObject arg0Value, Object arg1Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b100000000000000) != 0 /* is-state_0 removeKey(DynamicObject, Object, Shape, KeyCacheNode) */) {
                        return DynamicObjectLibraryImpl.removeKey(arg0Value, arg1Value, this.cachedShape, this.keyCache);
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    return removeKeyNode_AndSpecialize(arg0Value, arg1Value);
                } else {
                    return getFallback_(arg0Value).removeKey(arg0Value, arg1Value);
                }
            }

            private boolean removeKeyNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyCache = super.insert(this.keyCache == null ? ((KeyCacheNode.create(arg0Value.getShape(), arg1Value))) : this.keyCache);
                    this.state_0_ = state_0 = state_0 | 0b100000000000000 /* add-state_0 removeKey(DynamicObject, Object, Shape, KeyCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    return DynamicObjectLibraryImpl.removeKey(arg0Value, arg1Value, this.cachedShape, this.keyCache);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object getDynamicType(DynamicObject arg0Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    return DynamicObjectLibraryImpl.getDynamicType(arg0Value, this.cachedShape);
                } else {
                    return getFallback_(arg0Value).getDynamicType(arg0Value);
                }
            }

            @Override
            public boolean setDynamicType(DynamicObject arg0Value, Object arg1Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 setDynamicType(DynamicObject, Object, Shape, SetDynamicTypeNode) */) {
                        return DynamicObjectLibraryImpl.setDynamicType(arg0Value, arg1Value, this.cachedShape, this.setDynamicTypeNode__setDynamicType_setCache_);
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    return setDynamicTypeNode_AndSpecialize(arg0Value, arg1Value);
                } else {
                    return getFallback_(arg0Value).setDynamicType(arg0Value, arg1Value);
                }
            }

            private boolean setDynamicTypeNode_AndSpecialize(DynamicObject arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.setDynamicTypeNode__setDynamicType_setCache_ = super.insert((SetDynamicTypeNodeGen.create()));
                    this.state_0_ = state_0 = state_0 | 0b1000000000000000 /* add-state_0 setDynamicType(DynamicObject, Object, Shape, SetDynamicTypeNode) */;
                    lock.unlock();
                    hasLock = false;
                    return DynamicObjectLibraryImpl.setDynamicType(arg0Value, arg1Value, this.cachedShape, this.setDynamicTypeNode__setDynamicType_setCache_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public int getShapeFlags(DynamicObject arg0Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    return DynamicObjectLibraryImpl.getShapeFlags(arg0Value, this.cachedShape);
                } else {
                    return getFallback_(arg0Value).getShapeFlags(arg0Value);
                }
            }

            @Override
            public boolean setShapeFlags(DynamicObject arg0Value, int arg1Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0x10000) != 0 /* is-state_0 setShapeFlags(DynamicObject, int, Shape, SetFlagsNode) */) {
                        return DynamicObjectLibraryImpl.setShapeFlags(arg0Value, arg1Value, this.cachedShape, this.setShapeFlagsNode__setShapeFlags_setCache_);
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    return setShapeFlagsNode_AndSpecialize(arg0Value, arg1Value);
                } else {
                    return getFallback_(arg0Value).setShapeFlags(arg0Value, arg1Value);
                }
            }

            private boolean setShapeFlagsNode_AndSpecialize(DynamicObject arg0Value, int arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.setShapeFlagsNode__setShapeFlags_setCache_ = super.insert((SetFlagsNodeGen.create()));
                    this.state_0_ = state_0 = state_0 | 0x10000 /* add-state_0 setShapeFlags(DynamicObject, int, Shape, SetFlagsNode) */;
                    lock.unlock();
                    hasLock = false;
                    return DynamicObjectLibraryImpl.setShapeFlags(arg0Value, arg1Value, this.cachedShape, this.setShapeFlagsNode__setShapeFlags_setCache_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isShared(DynamicObject arg0Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    return DynamicObjectLibraryImpl.isShared(arg0Value, this.cachedShape);
                } else {
                    return getFallback_(arg0Value).isShared(arg0Value);
                }
            }

            @Override
            public void markShared(DynamicObject arg0Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0x20000) != 0 /* is-state_0 markShared(DynamicObject, Shape, MakeSharedNode) */) {
                        DynamicObjectLibraryImpl.markShared(arg0Value, this.cachedShape, this.markSharedNode__markShared_setCache_);
                        return;
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    markSharedNode_AndSpecialize(arg0Value);
                    return;
                } else {
                    getFallback_(arg0Value).markShared(arg0Value);
                    return;
                }
            }

            private void markSharedNode_AndSpecialize(DynamicObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.markSharedNode__markShared_setCache_ = super.insert((MakeSharedNodeGen.create()));
                    this.state_0_ = state_0 = state_0 | 0x20000 /* add-state_0 markShared(DynamicObject, Shape, MakeSharedNode) */;
                    lock.unlock();
                    hasLock = false;
                    DynamicObjectLibraryImpl.markShared(arg0Value, this.cachedShape, this.markSharedNode__markShared_setCache_);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean updateShape(DynamicObject arg0Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    return DynamicObjectLibraryImpl.updateShape(arg0Value, this.cachedShape);
                } else {
                    return getFallback_(arg0Value).updateShape(arg0Value);
                }
            }

            @Override
            public boolean resetShape(DynamicObject arg0Value, Shape arg1Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    int state_0 = this.state_0_;
                    if ((state_0 & 0x40000) != 0 /* is-state_0 resetShape(DynamicObject, Shape, Shape, ResetShapeNode) */) {
                        return DynamicObjectLibraryImpl.resetShape(arg0Value, arg1Value, this.cachedShape, this.resetShapeNode__resetShape_setCache_);
                    }
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    return resetShapeNode_AndSpecialize(arg0Value, arg1Value);
                } else {
                    return getFallback_(arg0Value).resetShape(arg0Value, arg1Value);
                }
            }

            private boolean resetShapeNode_AndSpecialize(DynamicObject arg0Value, Shape arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.resetShapeNode__resetShape_setCache_ = super.insert((ResetShapeNodeGen.create()));
                    this.state_0_ = state_0 = state_0 | 0x40000 /* add-state_0 resetShape(DynamicObject, Shape, Shape, ResetShapeNode) */;
                    lock.unlock();
                    hasLock = false;
                    return DynamicObjectLibraryImpl.resetShape(arg0Value, arg1Value, this.cachedShape, this.resetShapeNode__resetShape_setCache_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object[] getKeyArray(DynamicObject arg0Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    return DynamicObjectLibraryImpl.getKeyArray(arg0Value, this.cachedShape);
                } else {
                    return getFallback_(arg0Value).getKeyArray(arg0Value);
                }
            }

            @Override
            public Property[] getPropertyArray(DynamicObject arg0Value) {
                assert CompilerDirectives.isExact(arg0Value, this.receiverClass_) : "Invalid library usage. Library does not accept given receiver.";
                if (this.accepts(arg0Value)) {
                    assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                    return DynamicObjectLibraryImpl.getPropertyArray(arg0Value, this.cachedShape);
                } else {
                    return getFallback_(arg0Value).getPropertyArray(arg0Value);
                }
            }

        }
        @GeneratedBy(DynamicObjectLibraryImpl.class)
        private static final class Uncached extends DynamicObjectLibrary {

            private final Class<? extends DynamicObject> receiverClass_;

            protected Uncached(Object receiver) {
                this.receiverClass_ = ((DynamicObject) receiver).getClass();
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                return CompilerDirectives.isExact(receiver, this.receiverClass_) && accepts_(receiver);
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public Shape getShape(DynamicObject arg0Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.getShape(arg0Value, (arg0Value.getShape()));
            }

            @TruffleBoundary
            @Override
            public Object getOrDefault(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.getOrDefault(arg0Value, arg1Value, arg2Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public int getIntOrDefault(DynamicObject arg0Value, Object arg1Value, Object arg2Value) throws UnexpectedResultException {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.getIntOrDefault(arg0Value, arg1Value, arg2Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public double getDoubleOrDefault(DynamicObject arg0Value, Object arg1Value, Object arg2Value) throws UnexpectedResultException {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.getDoubleOrDefault(arg0Value, arg1Value, arg2Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public long getLongOrDefault(DynamicObject arg0Value, Object arg1Value, Object arg2Value) throws UnexpectedResultException {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.getLongOrDefault(arg0Value, arg1Value, arg2Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean containsKey(DynamicObject arg0Value, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.containsKey(arg0Value, arg1Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void put(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObjectLibraryImpl.put(arg0Value, arg1Value, arg2Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public void putInt(DynamicObject arg0Value, Object arg1Value, int arg2Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObjectLibraryImpl.putInt(arg0Value, arg1Value, arg2Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public void putLong(DynamicObject arg0Value, Object arg1Value, long arg2Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObjectLibraryImpl.putLong(arg0Value, arg1Value, arg2Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public void putDouble(DynamicObject arg0Value, Object arg1Value, double arg2Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObjectLibraryImpl.putDouble(arg0Value, arg1Value, arg2Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public boolean putIfPresent(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.putIfPresent(arg0Value, arg1Value, arg2Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void putWithFlags(DynamicObject arg0Value, Object arg1Value, Object arg2Value, int arg3Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObjectLibraryImpl.putWithFlags(arg0Value, arg1Value, arg2Value, arg3Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public void putConstant(DynamicObject arg0Value, Object arg1Value, Object arg2Value, int arg3Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObjectLibraryImpl.putConstant(arg0Value, arg1Value, arg2Value, arg3Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public Property getProperty(DynamicObject arg0Value, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.getProperty(arg0Value, arg1Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean setPropertyFlags(DynamicObject arg0Value, Object arg1Value, int arg2Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.setPropertyFlags(arg0Value, arg1Value, arg2Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean removeKey(DynamicObject arg0Value, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.removeKey(arg0Value, arg1Value, (arg0Value.getShape()), (KeyCacheNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object getDynamicType(DynamicObject arg0Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.getDynamicType(arg0Value, (arg0Value.getShape()));
            }

            @TruffleBoundary
            @Override
            public boolean setDynamicType(DynamicObject arg0Value, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.setDynamicType(arg0Value, arg1Value, (arg0Value.getShape()), (SetDynamicTypeNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public int getShapeFlags(DynamicObject arg0Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.getShapeFlags(arg0Value, (arg0Value.getShape()));
            }

            @TruffleBoundary
            @Override
            public boolean setShapeFlags(DynamicObject arg0Value, int arg1Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.setShapeFlags(arg0Value, arg1Value, (arg0Value.getShape()), (SetFlagsNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isShared(DynamicObject arg0Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.isShared(arg0Value, (arg0Value.getShape()));
            }

            @TruffleBoundary
            @Override
            public void markShared(DynamicObject arg0Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObjectLibraryImpl.markShared(arg0Value, (arg0Value.getShape()), (MakeSharedNodeGen.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public boolean updateShape(DynamicObject arg0Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.updateShape(arg0Value, (arg0Value.getShape()));
            }

            @TruffleBoundary
            @Override
            public boolean resetShape(DynamicObject arg0Value, Shape arg1Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.resetShape(arg0Value, arg1Value, (arg0Value.getShape()), (ResetShapeNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object[] getKeyArray(DynamicObject arg0Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.getKeyArray(arg0Value, (arg0Value.getShape()));
            }

            @TruffleBoundary
            @Override
            public Property[] getPropertyArray(DynamicObject arg0Value) {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return DynamicObjectLibraryImpl.getPropertyArray(arg0Value, (arg0Value.getShape()));
            }

            @TruffleBoundary
            private static boolean accepts_(Object arg0Value_) {
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return DynamicObjectLibraryImpl.accepts(arg0Value, (arg0Value.getShape()));
            }

        }
    }
}
