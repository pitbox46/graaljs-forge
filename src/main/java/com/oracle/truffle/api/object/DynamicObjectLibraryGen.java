// CheckStyle: start generated
package com.oracle.truffle.api.object;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.library.Message;
import com.oracle.truffle.api.library.ReflectionLibrary;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.utilities.FinalBitSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DynamicObjectLibrary.class)
final class DynamicObjectLibraryGen extends LibraryFactory<DynamicObjectLibrary> {

    private static final Class<DynamicObjectLibrary> LIBRARY_CLASS = DynamicObjectLibraryGen.lazyLibraryClass();
    private static final Message GET_SHAPE = new MessageImpl("getShape", 0, Shape.class, DynamicObject.class);
    private static final Message GET_OR_DEFAULT = new MessageImpl("getOrDefault", 1, Object.class, DynamicObject.class, Object.class, Object.class);
    private static final Message GET_INT_OR_DEFAULT = new MessageImpl("getIntOrDefault", 2, int.class, DynamicObject.class, Object.class, Object.class);
    private static final Message GET_DOUBLE_OR_DEFAULT = new MessageImpl("getDoubleOrDefault", 3, double.class, DynamicObject.class, Object.class, Object.class);
    private static final Message GET_LONG_OR_DEFAULT = new MessageImpl("getLongOrDefault", 4, long.class, DynamicObject.class, Object.class, Object.class);
    private static final Message PUT = new MessageImpl("put", 5, void.class, DynamicObject.class, Object.class, Object.class);
    private static final Message PUT_INT = new MessageImpl("putInt", 6, void.class, DynamicObject.class, Object.class, int.class);
    private static final Message PUT_DOUBLE = new MessageImpl("putDouble", 7, void.class, DynamicObject.class, Object.class, double.class);
    private static final Message PUT_LONG = new MessageImpl("putLong", 8, void.class, DynamicObject.class, Object.class, long.class);
    private static final Message PUT_IF_PRESENT = new MessageImpl("putIfPresent", 9, boolean.class, DynamicObject.class, Object.class, Object.class);
    private static final Message PUT_WITH_FLAGS = new MessageImpl("putWithFlags", 10, void.class, DynamicObject.class, Object.class, Object.class, int.class);
    private static final Message PUT_CONSTANT = new MessageImpl("putConstant", 11, void.class, DynamicObject.class, Object.class, Object.class, int.class);
    private static final Message REMOVE_KEY = new MessageImpl("removeKey", 12, boolean.class, DynamicObject.class, Object.class);
    private static final Message SET_DYNAMIC_TYPE = new MessageImpl("setDynamicType", 13, boolean.class, DynamicObject.class, Object.class);
    private static final Message GET_DYNAMIC_TYPE = new MessageImpl("getDynamicType", 14, Object.class, DynamicObject.class);
    private static final Message CONTAINS_KEY = new MessageImpl("containsKey", 15, boolean.class, DynamicObject.class, Object.class);
    private static final Message GET_SHAPE_FLAGS = new MessageImpl("getShapeFlags", 16, int.class, DynamicObject.class);
    private static final Message SET_SHAPE_FLAGS = new MessageImpl("setShapeFlags", 17, boolean.class, DynamicObject.class, int.class);
    private static final Message GET_PROPERTY = new MessageImpl("getProperty", 18, Property.class, DynamicObject.class, Object.class);
    private static final Message SET_PROPERTY_FLAGS = new MessageImpl("setPropertyFlags", 19, boolean.class, DynamicObject.class, Object.class, int.class);
    private static final Message MARK_SHARED = new MessageImpl("markShared", 20, void.class, DynamicObject.class);
    private static final Message IS_SHARED = new MessageImpl("isShared", 21, boolean.class, DynamicObject.class);
    private static final Message UPDATE_SHAPE = new MessageImpl("updateShape", 22, boolean.class, DynamicObject.class);
    private static final Message RESET_SHAPE = new MessageImpl("resetShape", 23, boolean.class, DynamicObject.class, Shape.class);
    private static final Message GET_KEY_ARRAY = new MessageImpl("getKeyArray", 24, Object[].class, DynamicObject.class);
    private static final Message GET_PROPERTY_ARRAY = new MessageImpl("getPropertyArray", 25, Property[].class, DynamicObject.class);
    private static final DynamicObjectLibraryGen INSTANCE = new DynamicObjectLibraryGen();

    static  {
        LibraryExport.register(DynamicObjectLibraryGen.LIBRARY_CLASS, new Default());
        LibraryFactory.register(DynamicObjectLibraryGen.LIBRARY_CLASS, INSTANCE);
    }

    private DynamicObjectLibraryGen() {
        super(DynamicObjectLibraryGen.LIBRARY_CLASS, Collections.unmodifiableList(Arrays.asList(DynamicObjectLibraryGen.GET_SHAPE, DynamicObjectLibraryGen.GET_OR_DEFAULT, DynamicObjectLibraryGen.GET_INT_OR_DEFAULT, DynamicObjectLibraryGen.GET_DOUBLE_OR_DEFAULT, DynamicObjectLibraryGen.GET_LONG_OR_DEFAULT, DynamicObjectLibraryGen.PUT, DynamicObjectLibraryGen.PUT_INT, DynamicObjectLibraryGen.PUT_DOUBLE, DynamicObjectLibraryGen.PUT_LONG, DynamicObjectLibraryGen.PUT_IF_PRESENT, DynamicObjectLibraryGen.PUT_WITH_FLAGS, DynamicObjectLibraryGen.PUT_CONSTANT, DynamicObjectLibraryGen.REMOVE_KEY, DynamicObjectLibraryGen.SET_DYNAMIC_TYPE, DynamicObjectLibraryGen.GET_DYNAMIC_TYPE, DynamicObjectLibraryGen.CONTAINS_KEY, DynamicObjectLibraryGen.GET_SHAPE_FLAGS, DynamicObjectLibraryGen.SET_SHAPE_FLAGS, DynamicObjectLibraryGen.GET_PROPERTY, DynamicObjectLibraryGen.SET_PROPERTY_FLAGS, DynamicObjectLibraryGen.MARK_SHARED, DynamicObjectLibraryGen.IS_SHARED, DynamicObjectLibraryGen.UPDATE_SHAPE, DynamicObjectLibraryGen.RESET_SHAPE, DynamicObjectLibraryGen.GET_KEY_ARRAY, DynamicObjectLibraryGen.GET_PROPERTY_ARRAY)));
    }

    @Override
    protected Class<?> getDefaultClass(Object receiver) {
        return DynamicObjectLibrary.class;
    }

    @Override
    protected DynamicObjectLibrary createProxy(ReflectionLibrary library) {
        return new Proxy(library);
    }

    @Override
    protected FinalBitSet createMessageBitSet(Message... messages) {
        BitSet bitSet = new BitSet(2);
        for (Message message : messages) {
            bitSet.set(((MessageImpl) message).index);
        }
        return FinalBitSet.valueOf(bitSet);
    }

    @Override
    protected DynamicObjectLibrary createDelegate(DynamicObjectLibrary delegateLibrary) {
        return new Delegate(delegateLibrary);
    }

    @Override
    protected Object genericDispatch(Library originalLib, Object receiver, Message message, Object[] args, int offset) throws Exception {
        DynamicObjectLibrary lib = (DynamicObjectLibrary) originalLib;
        MessageImpl messageImpl = (MessageImpl) message;
        if (messageImpl.getParameterCount() - 1 != args.length - offset) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Invalid number of arguments.");
        }
        switch (messageImpl.index) {
            case 0 :
                return lib.getShape((DynamicObject) receiver);
            case 1 :
                return lib.getOrDefault((DynamicObject) receiver, args[offset], args[offset + 1]);
            case 2 :
                return lib.getIntOrDefault((DynamicObject) receiver, args[offset], args[offset + 1]);
            case 3 :
                return lib.getDoubleOrDefault((DynamicObject) receiver, args[offset], args[offset + 1]);
            case 4 :
                return lib.getLongOrDefault((DynamicObject) receiver, args[offset], args[offset + 1]);
            case 5 :
                lib.put((DynamicObject) receiver, args[offset], args[offset + 1]);
                return null;
            case 6 :
                lib.putInt((DynamicObject) receiver, args[offset], (int) args[offset + 1]);
                return null;
            case 7 :
                lib.putDouble((DynamicObject) receiver, args[offset], (double) args[offset + 1]);
                return null;
            case 8 :
                lib.putLong((DynamicObject) receiver, args[offset], (long) args[offset + 1]);
                return null;
            case 9 :
                return lib.putIfPresent((DynamicObject) receiver, args[offset], args[offset + 1]);
            case 10 :
                lib.putWithFlags((DynamicObject) receiver, args[offset], args[offset + 1], (int) args[offset + 2]);
                return null;
            case 11 :
                lib.putConstant((DynamicObject) receiver, args[offset], args[offset + 1], (int) args[offset + 2]);
                return null;
            case 12 :
                return lib.removeKey((DynamicObject) receiver, args[offset]);
            case 13 :
                return lib.setDynamicType((DynamicObject) receiver, args[offset]);
            case 14 :
                return lib.getDynamicType((DynamicObject) receiver);
            case 15 :
                return lib.containsKey((DynamicObject) receiver, args[offset]);
            case 16 :
                return lib.getShapeFlags((DynamicObject) receiver);
            case 17 :
                return lib.setShapeFlags((DynamicObject) receiver, (int) args[offset]);
            case 18 :
                return lib.getProperty((DynamicObject) receiver, args[offset]);
            case 19 :
                return lib.setPropertyFlags((DynamicObject) receiver, args[offset], (int) args[offset + 1]);
            case 20 :
                lib.markShared((DynamicObject) receiver);
                return null;
            case 21 :
                return lib.isShared((DynamicObject) receiver);
            case 22 :
                return lib.updateShape((DynamicObject) receiver);
            case 23 :
                return lib.resetShape((DynamicObject) receiver, (Shape) args[offset]);
            case 24 :
                return lib.getKeyArray((DynamicObject) receiver);
            case 25 :
                return lib.getPropertyArray((DynamicObject) receiver);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new AbstractMethodError(message.toString());
    }

    @Override
    protected DynamicObjectLibrary createDispatchImpl(int limit) {
        return new CachedDispatchFirst(null, null, limit);
    }

    @Override
    protected DynamicObjectLibrary createUncachedDispatch() {
        return new UncachedDispatch();
    }

    @SuppressWarnings("unchecked")
    private static Class<DynamicObjectLibrary> lazyLibraryClass() {
        try {
            return (Class<DynamicObjectLibrary>) Class.forName("com.oracle.truffle.api.object.DynamicObjectLibrary", false, DynamicObjectLibraryGen.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw CompilerDirectives.shouldNotReachHere(e);
        }
    }

    @GeneratedBy(DynamicObjectLibrary.class)
    private static final class Default extends LibraryExport<DynamicObjectLibrary> {

        private Default() {
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

        @GeneratedBy(DynamicObjectLibrary.class)
        private static final class Cached extends DynamicObjectLibrary {

            private final Class<? extends DynamicObject> receiverClass_;

            protected Cached(Object receiver) {
                DynamicObject castReceiver = ((DynamicObject) receiver) ;
                this.receiverClass_ = castReceiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @TruffleBoundary
            @Override
            public Shape getShape(DynamicObject receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public Object getOrDefault(DynamicObject receiver, Object key, Object defaultValue) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @Override
            public int getIntOrDefault(DynamicObject receiver, Object key, Object defaultValue) throws UnexpectedResultException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getIntOrDefault((CompilerDirectives.castExact(receiver, receiverClass_)), key, defaultValue);
            }

            @Override
            public double getDoubleOrDefault(DynamicObject receiver, Object key, Object defaultValue) throws UnexpectedResultException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getDoubleOrDefault((CompilerDirectives.castExact(receiver, receiverClass_)), key, defaultValue);
            }

            @Override
            public long getLongOrDefault(DynamicObject receiver, Object key, Object defaultValue) throws UnexpectedResultException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getLongOrDefault((CompilerDirectives.castExact(receiver, receiverClass_)), key, defaultValue);
            }

            @TruffleBoundary
            @Override
            public void put(DynamicObject receiver, Object key, Object value) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @Override
            public void putInt(DynamicObject receiver, Object key, int value) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.putInt((CompilerDirectives.castExact(receiver, receiverClass_)), key, value);
                return;
            }

            @Override
            public void putDouble(DynamicObject receiver, Object key, double value) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.putDouble((CompilerDirectives.castExact(receiver, receiverClass_)), key, value);
                return;
            }

            @Override
            public void putLong(DynamicObject receiver, Object key, long value) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.putLong((CompilerDirectives.castExact(receiver, receiverClass_)), key, value);
                return;
            }

            @TruffleBoundary
            @Override
            public boolean putIfPresent(DynamicObject receiver, Object key, Object value) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public void putWithFlags(DynamicObject receiver, Object key, Object value, int flags) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public void putConstant(DynamicObject receiver, Object key, Object value, int flags) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean removeKey(DynamicObject receiver, Object key) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean setDynamicType(DynamicObject receiver, Object type) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public Object getDynamicType(DynamicObject receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean containsKey(DynamicObject receiver, Object key) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public int getShapeFlags(DynamicObject receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean setShapeFlags(DynamicObject receiver, int flags) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public Property getProperty(DynamicObject receiver, Object key) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean setPropertyFlags(DynamicObject receiver, Object key, int propertyFlags) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public void markShared(DynamicObject receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean isShared(DynamicObject receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean updateShape(DynamicObject receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean resetShape(DynamicObject receiver, Shape otherShape) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public Object[] getKeyArray(DynamicObject receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public Property[] getPropertyArray(DynamicObject receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

        }
        @GeneratedBy(DynamicObjectLibrary.class)
        private static final class Uncached extends DynamicObjectLibrary {

            private final Class<? extends DynamicObject> receiverClass_;

            protected Uncached(Object receiver) {
                this.receiverClass_ = ((DynamicObject) receiver).getClass();
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
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
            public Shape getShape(DynamicObject receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public Object getOrDefault(DynamicObject receiver, Object key, Object defaultValue) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public int getIntOrDefault(DynamicObject receiver, Object key, Object defaultValue) throws UnexpectedResultException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getIntOrDefault(receiver, key, defaultValue);
            }

            @TruffleBoundary
            @Override
            public double getDoubleOrDefault(DynamicObject receiver, Object key, Object defaultValue) throws UnexpectedResultException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getDoubleOrDefault(receiver, key, defaultValue);
            }

            @TruffleBoundary
            @Override
            public long getLongOrDefault(DynamicObject receiver, Object key, Object defaultValue) throws UnexpectedResultException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getLongOrDefault(receiver, key, defaultValue);
            }

            @TruffleBoundary
            @Override
            public void put(DynamicObject receiver, Object key, Object value) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public void putInt(DynamicObject receiver, Object key, int value) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.putInt(receiver, key, value);
                return;
            }

            @TruffleBoundary
            @Override
            public void putDouble(DynamicObject receiver, Object key, double value) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.putDouble(receiver, key, value);
                return;
            }

            @TruffleBoundary
            @Override
            public void putLong(DynamicObject receiver, Object key, long value) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.putLong(receiver, key, value);
                return;
            }

            @TruffleBoundary
            @Override
            public boolean putIfPresent(DynamicObject receiver, Object key, Object value) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public void putWithFlags(DynamicObject receiver, Object key, Object value, int flags) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public void putConstant(DynamicObject receiver, Object key, Object value, int flags) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean removeKey(DynamicObject receiver, Object key) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean setDynamicType(DynamicObject receiver, Object type) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public Object getDynamicType(DynamicObject receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean containsKey(DynamicObject receiver, Object key) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public int getShapeFlags(DynamicObject receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean setShapeFlags(DynamicObject receiver, int flags) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public Property getProperty(DynamicObject receiver, Object key) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean setPropertyFlags(DynamicObject receiver, Object key, int propertyFlags) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public void markShared(DynamicObject receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean isShared(DynamicObject receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean updateShape(DynamicObject receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public boolean resetShape(DynamicObject receiver, Shape otherShape) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public Object[] getKeyArray(DynamicObject receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

            @TruffleBoundary
            @Override
            public Property[] getPropertyArray(DynamicObject receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

        }
    }
    @GeneratedBy(DynamicObjectLibrary.class)
    private static class MessageImpl extends Message {

        final int index;

        MessageImpl(String name, int index, Class<?> returnType, Class<?>... parameters) {
            super(DynamicObjectLibraryGen.LIBRARY_CLASS, name, returnType, parameters);
            this.index = index;
        }

    }
    @GeneratedBy(DynamicObjectLibrary.class)
    private static final class Proxy extends DynamicObjectLibrary {

        @Child private ReflectionLibrary lib;

        Proxy(ReflectionLibrary lib) {
            this.lib = lib;
        }

        @Override
        public Shape getShape(DynamicObject receiver_) {
            try {
                return (Shape) lib.send(receiver_, DynamicObjectLibraryGen.GET_SHAPE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getOrDefault(DynamicObject receiver_, Object key, Object defaultValue) {
            try {
                return lib.send(receiver_, DynamicObjectLibraryGen.GET_OR_DEFAULT, key, defaultValue);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public int getIntOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            try {
                return (int) lib.send(receiver_, DynamicObjectLibraryGen.GET_INT_OR_DEFAULT, key, defaultValue);
            } catch (UnexpectedResultException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public double getDoubleOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            try {
                return (double) lib.send(receiver_, DynamicObjectLibraryGen.GET_DOUBLE_OR_DEFAULT, key, defaultValue);
            } catch (UnexpectedResultException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public long getLongOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            try {
                return (long) lib.send(receiver_, DynamicObjectLibraryGen.GET_LONG_OR_DEFAULT, key, defaultValue);
            } catch (UnexpectedResultException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void put(DynamicObject receiver_, Object key, Object value) {
            try {
                lib.send(receiver_, DynamicObjectLibraryGen.PUT, key, value);
                return;
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void putInt(DynamicObject receiver_, Object key, int value) {
            try {
                lib.send(receiver_, DynamicObjectLibraryGen.PUT_INT, key, value);
                return;
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void putDouble(DynamicObject receiver_, Object key, double value) {
            try {
                lib.send(receiver_, DynamicObjectLibraryGen.PUT_DOUBLE, key, value);
                return;
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void putLong(DynamicObject receiver_, Object key, long value) {
            try {
                lib.send(receiver_, DynamicObjectLibraryGen.PUT_LONG, key, value);
                return;
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean putIfPresent(DynamicObject receiver_, Object key, Object value) {
            try {
                return (boolean) lib.send(receiver_, DynamicObjectLibraryGen.PUT_IF_PRESENT, key, value);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void putWithFlags(DynamicObject receiver_, Object key, Object value, int flags) {
            try {
                lib.send(receiver_, DynamicObjectLibraryGen.PUT_WITH_FLAGS, key, value, flags);
                return;
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void putConstant(DynamicObject receiver_, Object key, Object value, int flags) {
            try {
                lib.send(receiver_, DynamicObjectLibraryGen.PUT_CONSTANT, key, value, flags);
                return;
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean removeKey(DynamicObject receiver_, Object key) {
            try {
                return (boolean) lib.send(receiver_, DynamicObjectLibraryGen.REMOVE_KEY, key);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean setDynamicType(DynamicObject receiver_, Object type) {
            try {
                return (boolean) lib.send(receiver_, DynamicObjectLibraryGen.SET_DYNAMIC_TYPE, type);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getDynamicType(DynamicObject receiver_) {
            try {
                return lib.send(receiver_, DynamicObjectLibraryGen.GET_DYNAMIC_TYPE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean containsKey(DynamicObject receiver_, Object key) {
            try {
                return (boolean) lib.send(receiver_, DynamicObjectLibraryGen.CONTAINS_KEY, key);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public int getShapeFlags(DynamicObject receiver_) {
            try {
                return (int) lib.send(receiver_, DynamicObjectLibraryGen.GET_SHAPE_FLAGS);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean setShapeFlags(DynamicObject receiver_, int flags) {
            try {
                return (boolean) lib.send(receiver_, DynamicObjectLibraryGen.SET_SHAPE_FLAGS, flags);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Property getProperty(DynamicObject receiver_, Object key) {
            try {
                return (Property) lib.send(receiver_, DynamicObjectLibraryGen.GET_PROPERTY, key);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean setPropertyFlags(DynamicObject receiver_, Object key, int propertyFlags) {
            try {
                return (boolean) lib.send(receiver_, DynamicObjectLibraryGen.SET_PROPERTY_FLAGS, key, propertyFlags);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void markShared(DynamicObject receiver_) {
            try {
                lib.send(receiver_, DynamicObjectLibraryGen.MARK_SHARED);
                return;
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isShared(DynamicObject receiver_) {
            try {
                return (boolean) lib.send(receiver_, DynamicObjectLibraryGen.IS_SHARED);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean updateShape(DynamicObject receiver_) {
            try {
                return (boolean) lib.send(receiver_, DynamicObjectLibraryGen.UPDATE_SHAPE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean resetShape(DynamicObject receiver_, Shape otherShape) {
            try {
                return (boolean) lib.send(receiver_, DynamicObjectLibraryGen.RESET_SHAPE, otherShape);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object[] getKeyArray(DynamicObject receiver_) {
            try {
                return (Object[]) lib.send(receiver_, DynamicObjectLibraryGen.GET_KEY_ARRAY);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Property[] getPropertyArray(DynamicObject receiver_) {
            try {
                return (Property[]) lib.send(receiver_, DynamicObjectLibraryGen.GET_PROPERTY_ARRAY);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean accepts(Object receiver_) {
            return lib.accepts(receiver_);
        }

    }
    @GeneratedBy(DynamicObjectLibrary.class)
    private static final class Delegate extends DynamicObjectLibrary {

        @Child private DynamicObjectLibrary delegateLibrary;

        Delegate(DynamicObjectLibrary delegateLibrary) {
            this.delegateLibrary = delegateLibrary;
        }

        @Override
        public Shape getShape(DynamicObject receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 0)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getShape((DynamicObject) delegate);
            } else {
                return this.delegateLibrary.getShape(receiver_);
            }
        }

        @Override
        public Object getOrDefault(DynamicObject receiver_, Object key, Object defaultValue) {
            if (LibraryFactory.isDelegated(delegateLibrary, 1)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getOrDefault((DynamicObject) delegate, key, defaultValue);
            } else {
                return this.delegateLibrary.getOrDefault(receiver_, key, defaultValue);
            }
        }

        @Override
        public int getIntOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            if (LibraryFactory.isDelegated(delegateLibrary, 2)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getIntOrDefault((DynamicObject) delegate, key, defaultValue);
            } else {
                return this.delegateLibrary.getIntOrDefault(receiver_, key, defaultValue);
            }
        }

        @Override
        public double getDoubleOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            if (LibraryFactory.isDelegated(delegateLibrary, 3)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getDoubleOrDefault((DynamicObject) delegate, key, defaultValue);
            } else {
                return this.delegateLibrary.getDoubleOrDefault(receiver_, key, defaultValue);
            }
        }

        @Override
        public long getLongOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            if (LibraryFactory.isDelegated(delegateLibrary, 4)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getLongOrDefault((DynamicObject) delegate, key, defaultValue);
            } else {
                return this.delegateLibrary.getLongOrDefault(receiver_, key, defaultValue);
            }
        }

        @Override
        public void put(DynamicObject receiver_, Object key, Object value) {
            if (LibraryFactory.isDelegated(delegateLibrary, 5)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).put((DynamicObject) delegate, key, value);
                return;
            } else {
                this.delegateLibrary.put(receiver_, key, value);
                return;
            }
        }

        @Override
        public void putInt(DynamicObject receiver_, Object key, int value) {
            if (LibraryFactory.isDelegated(delegateLibrary, 6)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).putInt((DynamicObject) delegate, key, value);
                return;
            } else {
                this.delegateLibrary.putInt(receiver_, key, value);
                return;
            }
        }

        @Override
        public void putDouble(DynamicObject receiver_, Object key, double value) {
            if (LibraryFactory.isDelegated(delegateLibrary, 7)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).putDouble((DynamicObject) delegate, key, value);
                return;
            } else {
                this.delegateLibrary.putDouble(receiver_, key, value);
                return;
            }
        }

        @Override
        public void putLong(DynamicObject receiver_, Object key, long value) {
            if (LibraryFactory.isDelegated(delegateLibrary, 8)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).putLong((DynamicObject) delegate, key, value);
                return;
            } else {
                this.delegateLibrary.putLong(receiver_, key, value);
                return;
            }
        }

        @Override
        public boolean putIfPresent(DynamicObject receiver_, Object key, Object value) {
            if (LibraryFactory.isDelegated(delegateLibrary, 9)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).putIfPresent((DynamicObject) delegate, key, value);
            } else {
                return this.delegateLibrary.putIfPresent(receiver_, key, value);
            }
        }

        @Override
        public void putWithFlags(DynamicObject receiver_, Object key, Object value, int flags) {
            if (LibraryFactory.isDelegated(delegateLibrary, 10)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).putWithFlags((DynamicObject) delegate, key, value, flags);
                return;
            } else {
                this.delegateLibrary.putWithFlags(receiver_, key, value, flags);
                return;
            }
        }

        @Override
        public void putConstant(DynamicObject receiver_, Object key, Object value, int flags) {
            if (LibraryFactory.isDelegated(delegateLibrary, 11)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).putConstant((DynamicObject) delegate, key, value, flags);
                return;
            } else {
                this.delegateLibrary.putConstant(receiver_, key, value, flags);
                return;
            }
        }

        @Override
        public boolean removeKey(DynamicObject receiver_, Object key) {
            if (LibraryFactory.isDelegated(delegateLibrary, 12)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).removeKey((DynamicObject) delegate, key);
            } else {
                return this.delegateLibrary.removeKey(receiver_, key);
            }
        }

        @Override
        public boolean setDynamicType(DynamicObject receiver_, Object type) {
            if (LibraryFactory.isDelegated(delegateLibrary, 13)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).setDynamicType((DynamicObject) delegate, type);
            } else {
                return this.delegateLibrary.setDynamicType(receiver_, type);
            }
        }

        @Override
        public Object getDynamicType(DynamicObject receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 14)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getDynamicType((DynamicObject) delegate);
            } else {
                return this.delegateLibrary.getDynamicType(receiver_);
            }
        }

        @Override
        public boolean containsKey(DynamicObject receiver_, Object key) {
            if (LibraryFactory.isDelegated(delegateLibrary, 15)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).containsKey((DynamicObject) delegate, key);
            } else {
                return this.delegateLibrary.containsKey(receiver_, key);
            }
        }

        @Override
        public int getShapeFlags(DynamicObject receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 16)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getShapeFlags((DynamicObject) delegate);
            } else {
                return this.delegateLibrary.getShapeFlags(receiver_);
            }
        }

        @Override
        public boolean setShapeFlags(DynamicObject receiver_, int flags) {
            if (LibraryFactory.isDelegated(delegateLibrary, 17)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).setShapeFlags((DynamicObject) delegate, flags);
            } else {
                return this.delegateLibrary.setShapeFlags(receiver_, flags);
            }
        }

        @Override
        public Property getProperty(DynamicObject receiver_, Object key) {
            if (LibraryFactory.isDelegated(delegateLibrary, 18)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getProperty((DynamicObject) delegate, key);
            } else {
                return this.delegateLibrary.getProperty(receiver_, key);
            }
        }

        @Override
        public boolean setPropertyFlags(DynamicObject receiver_, Object key, int propertyFlags) {
            if (LibraryFactory.isDelegated(delegateLibrary, 19)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).setPropertyFlags((DynamicObject) delegate, key, propertyFlags);
            } else {
                return this.delegateLibrary.setPropertyFlags(receiver_, key, propertyFlags);
            }
        }

        @Override
        public void markShared(DynamicObject receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 20)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).markShared((DynamicObject) delegate);
                return;
            } else {
                this.delegateLibrary.markShared(receiver_);
                return;
            }
        }

        @Override
        public boolean isShared(DynamicObject receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 21)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isShared((DynamicObject) delegate);
            } else {
                return this.delegateLibrary.isShared(receiver_);
            }
        }

        @Override
        public boolean updateShape(DynamicObject receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 22)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).updateShape((DynamicObject) delegate);
            } else {
                return this.delegateLibrary.updateShape(receiver_);
            }
        }

        @Override
        public boolean resetShape(DynamicObject receiver_, Shape otherShape) {
            if (LibraryFactory.isDelegated(delegateLibrary, 23)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).resetShape((DynamicObject) delegate, otherShape);
            } else {
                return this.delegateLibrary.resetShape(receiver_, otherShape);
            }
        }

        @Override
        public Object[] getKeyArray(DynamicObject receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 24)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getKeyArray((DynamicObject) delegate);
            } else {
                return this.delegateLibrary.getKeyArray(receiver_);
            }
        }

        @Override
        public Property[] getPropertyArray(DynamicObject receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 25)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getPropertyArray((DynamicObject) delegate);
            } else {
                return this.delegateLibrary.getPropertyArray(receiver_);
            }
        }

        @Override
        public boolean accepts(Object receiver_) {
            return delegateLibrary.accepts(receiver_);
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        @Override
        public boolean isAdoptable() {
            return this.delegateLibrary.isAdoptable();
        }

    }
    @GeneratedBy(DynamicObjectLibrary.class)
    private static final class CachedToUncachedDispatch extends DynamicObjectLibrary {

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @TruffleBoundary
        @Override
        public Shape getShape(DynamicObject receiver_) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).getShape(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getOrDefault(DynamicObject receiver_, Object key, Object defaultValue) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).getOrDefault(receiver_, key, defaultValue);
        }

        @TruffleBoundary
        @Override
        public int getIntOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).getIntOrDefault(receiver_, key, defaultValue);
        }

        @TruffleBoundary
        @Override
        public double getDoubleOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).getDoubleOrDefault(receiver_, key, defaultValue);
        }

        @TruffleBoundary
        @Override
        public long getLongOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).getLongOrDefault(receiver_, key, defaultValue);
        }

        @TruffleBoundary
        @Override
        public void put(DynamicObject receiver_, Object key, Object value) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            INSTANCE.getUncached(receiver_).put(receiver_, key, value);
            return;
        }

        @TruffleBoundary
        @Override
        public void putInt(DynamicObject receiver_, Object key, int value) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            INSTANCE.getUncached(receiver_).putInt(receiver_, key, value);
            return;
        }

        @TruffleBoundary
        @Override
        public void putDouble(DynamicObject receiver_, Object key, double value) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            INSTANCE.getUncached(receiver_).putDouble(receiver_, key, value);
            return;
        }

        @TruffleBoundary
        @Override
        public void putLong(DynamicObject receiver_, Object key, long value) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            INSTANCE.getUncached(receiver_).putLong(receiver_, key, value);
            return;
        }

        @TruffleBoundary
        @Override
        public boolean putIfPresent(DynamicObject receiver_, Object key, Object value) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).putIfPresent(receiver_, key, value);
        }

        @TruffleBoundary
        @Override
        public void putWithFlags(DynamicObject receiver_, Object key, Object value, int flags) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            INSTANCE.getUncached(receiver_).putWithFlags(receiver_, key, value, flags);
            return;
        }

        @TruffleBoundary
        @Override
        public void putConstant(DynamicObject receiver_, Object key, Object value, int flags) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            INSTANCE.getUncached(receiver_).putConstant(receiver_, key, value, flags);
            return;
        }

        @TruffleBoundary
        @Override
        public boolean removeKey(DynamicObject receiver_, Object key) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).removeKey(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public boolean setDynamicType(DynamicObject receiver_, Object type) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).setDynamicType(receiver_, type);
        }

        @TruffleBoundary
        @Override
        public Object getDynamicType(DynamicObject receiver_) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).getDynamicType(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean containsKey(DynamicObject receiver_, Object key) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).containsKey(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public int getShapeFlags(DynamicObject receiver_) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).getShapeFlags(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean setShapeFlags(DynamicObject receiver_, int flags) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).setShapeFlags(receiver_, flags);
        }

        @TruffleBoundary
        @Override
        public Property getProperty(DynamicObject receiver_, Object key) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).getProperty(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public boolean setPropertyFlags(DynamicObject receiver_, Object key, int propertyFlags) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).setPropertyFlags(receiver_, key, propertyFlags);
        }

        @TruffleBoundary
        @Override
        public void markShared(DynamicObject receiver_) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            INSTANCE.getUncached(receiver_).markShared(receiver_);
            return;
        }

        @TruffleBoundary
        @Override
        public boolean isShared(DynamicObject receiver_) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).isShared(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean updateShape(DynamicObject receiver_) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).updateShape(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean resetShape(DynamicObject receiver_, Shape otherShape) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).resetShape(receiver_, otherShape);
        }

        @TruffleBoundary
        @Override
        public Object[] getKeyArray(DynamicObject receiver_) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).getKeyArray(receiver_);
        }

        @TruffleBoundary
        @Override
        public Property[] getPropertyArray(DynamicObject receiver_) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            return INSTANCE.getUncached(receiver_).getPropertyArray(receiver_);
        }

        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

    }
    @GeneratedBy(DynamicObjectLibrary.class)
    private static final class UncachedDispatch extends DynamicObjectLibrary {

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @TruffleBoundary
        @Override
        public Shape getShape(DynamicObject receiver_) {
            return INSTANCE.getUncached(receiver_).getShape(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getOrDefault(DynamicObject receiver_, Object key, Object defaultValue) {
            return INSTANCE.getUncached(receiver_).getOrDefault(receiver_, key, defaultValue);
        }

        @TruffleBoundary
        @Override
        public int getIntOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            return INSTANCE.getUncached(receiver_).getIntOrDefault(receiver_, key, defaultValue);
        }

        @TruffleBoundary
        @Override
        public double getDoubleOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            return INSTANCE.getUncached(receiver_).getDoubleOrDefault(receiver_, key, defaultValue);
        }

        @TruffleBoundary
        @Override
        public long getLongOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            return INSTANCE.getUncached(receiver_).getLongOrDefault(receiver_, key, defaultValue);
        }

        @TruffleBoundary
        @Override
        public void put(DynamicObject receiver_, Object key, Object value) {
            INSTANCE.getUncached(receiver_).put(receiver_, key, value);
            return;
        }

        @TruffleBoundary
        @Override
        public void putInt(DynamicObject receiver_, Object key, int value) {
            INSTANCE.getUncached(receiver_).putInt(receiver_, key, value);
            return;
        }

        @TruffleBoundary
        @Override
        public void putDouble(DynamicObject receiver_, Object key, double value) {
            INSTANCE.getUncached(receiver_).putDouble(receiver_, key, value);
            return;
        }

        @TruffleBoundary
        @Override
        public void putLong(DynamicObject receiver_, Object key, long value) {
            INSTANCE.getUncached(receiver_).putLong(receiver_, key, value);
            return;
        }

        @TruffleBoundary
        @Override
        public boolean putIfPresent(DynamicObject receiver_, Object key, Object value) {
            return INSTANCE.getUncached(receiver_).putIfPresent(receiver_, key, value);
        }

        @TruffleBoundary
        @Override
        public void putWithFlags(DynamicObject receiver_, Object key, Object value, int flags) {
            INSTANCE.getUncached(receiver_).putWithFlags(receiver_, key, value, flags);
            return;
        }

        @TruffleBoundary
        @Override
        public void putConstant(DynamicObject receiver_, Object key, Object value, int flags) {
            INSTANCE.getUncached(receiver_).putConstant(receiver_, key, value, flags);
            return;
        }

        @TruffleBoundary
        @Override
        public boolean removeKey(DynamicObject receiver_, Object key) {
            return INSTANCE.getUncached(receiver_).removeKey(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public boolean setDynamicType(DynamicObject receiver_, Object type) {
            return INSTANCE.getUncached(receiver_).setDynamicType(receiver_, type);
        }

        @TruffleBoundary
        @Override
        public Object getDynamicType(DynamicObject receiver_) {
            return INSTANCE.getUncached(receiver_).getDynamicType(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean containsKey(DynamicObject receiver_, Object key) {
            return INSTANCE.getUncached(receiver_).containsKey(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public int getShapeFlags(DynamicObject receiver_) {
            return INSTANCE.getUncached(receiver_).getShapeFlags(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean setShapeFlags(DynamicObject receiver_, int flags) {
            return INSTANCE.getUncached(receiver_).setShapeFlags(receiver_, flags);
        }

        @TruffleBoundary
        @Override
        public Property getProperty(DynamicObject receiver_, Object key) {
            return INSTANCE.getUncached(receiver_).getProperty(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public boolean setPropertyFlags(DynamicObject receiver_, Object key, int propertyFlags) {
            return INSTANCE.getUncached(receiver_).setPropertyFlags(receiver_, key, propertyFlags);
        }

        @TruffleBoundary
        @Override
        public void markShared(DynamicObject receiver_) {
            INSTANCE.getUncached(receiver_).markShared(receiver_);
            return;
        }

        @TruffleBoundary
        @Override
        public boolean isShared(DynamicObject receiver_) {
            return INSTANCE.getUncached(receiver_).isShared(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean updateShape(DynamicObject receiver_) {
            return INSTANCE.getUncached(receiver_).updateShape(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean resetShape(DynamicObject receiver_, Shape otherShape) {
            return INSTANCE.getUncached(receiver_).resetShape(receiver_, otherShape);
        }

        @TruffleBoundary
        @Override
        public Object[] getKeyArray(DynamicObject receiver_) {
            return INSTANCE.getUncached(receiver_).getKeyArray(receiver_);
        }

        @TruffleBoundary
        @Override
        public Property[] getPropertyArray(DynamicObject receiver_) {
            return INSTANCE.getUncached(receiver_).getPropertyArray(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
    @GeneratedBy(DynamicObjectLibrary.class)
    private static final class CachedDispatchNext extends CachedDispatch {

        CachedDispatchNext(DynamicObjectLibrary library, CachedDispatch next) {
            super(library, next);
        }

        @Override
        int getLimit() {
            throw CompilerDirectives.shouldNotReachHere();
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

    }
    @GeneratedBy(DynamicObjectLibrary.class)
    private static final class CachedDispatchFirst extends CachedDispatch {

        private final int limit_;

        CachedDispatchFirst(DynamicObjectLibrary library, CachedDispatch next, int limit_) {
            super(library, next);
            this.limit_ = limit_;
        }

        @Override
        int getLimit() {
            return this.limit_;
        }

        @Override
        public NodeCost getCost() {
            if (this.library instanceof CachedToUncachedDispatch) {
                return NodeCost.MEGAMORPHIC;
            }
            CachedDispatch current = this;
            int count = 0;
            do {
                if (current.library != null) {
                    count++;
                }
                current = current.next;
            } while (current != null);
            return NodeCost.fromCount(count);
        }

    }
    @GeneratedBy(DynamicObjectLibrary.class)
    private abstract static class CachedDispatch extends DynamicObjectLibrary {

        @Child DynamicObjectLibrary library;
        @Child CachedDispatch next;

        CachedDispatch(DynamicObjectLibrary library, CachedDispatch next) {
            this.library = library;
            this.next = next;
        }

        abstract int getLimit();

        @ExplodeLoop
        @Override
        public Shape getShape(DynamicObject receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getShape(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getOrDefault(DynamicObject receiver_, Object key, Object defaultValue) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getOrDefault(receiver_, key, defaultValue);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public int getIntOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getIntOrDefault(receiver_, key, defaultValue);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public double getDoubleOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getDoubleOrDefault(receiver_, key, defaultValue);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public long getLongOrDefault(DynamicObject receiver_, Object key, Object defaultValue) throws UnexpectedResultException {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getLongOrDefault(receiver_, key, defaultValue);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void put(DynamicObject receiver_, Object key, Object value) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.put(receiver_, key, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void putInt(DynamicObject receiver_, Object key, int value) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.putInt(receiver_, key, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void putDouble(DynamicObject receiver_, Object key, double value) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.putDouble(receiver_, key, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void putLong(DynamicObject receiver_, Object key, long value) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.putLong(receiver_, key, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean putIfPresent(DynamicObject receiver_, Object key, Object value) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.putIfPresent(receiver_, key, value);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void putWithFlags(DynamicObject receiver_, Object key, Object value, int flags) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.putWithFlags(receiver_, key, value, flags);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void putConstant(DynamicObject receiver_, Object key, Object value, int flags) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.putConstant(receiver_, key, value, flags);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean removeKey(DynamicObject receiver_, Object key) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.removeKey(receiver_, key);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean setDynamicType(DynamicObject receiver_, Object type) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.setDynamicType(receiver_, type);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getDynamicType(DynamicObject receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getDynamicType(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean containsKey(DynamicObject receiver_, Object key) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.containsKey(receiver_, key);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public int getShapeFlags(DynamicObject receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getShapeFlags(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean setShapeFlags(DynamicObject receiver_, int flags) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.setShapeFlags(receiver_, flags);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Property getProperty(DynamicObject receiver_, Object key) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getProperty(receiver_, key);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean setPropertyFlags(DynamicObject receiver_, Object key, int propertyFlags) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.setPropertyFlags(receiver_, key, propertyFlags);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void markShared(DynamicObject receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.markShared(receiver_);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isShared(DynamicObject receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isShared(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean updateShape(DynamicObject receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.updateShape(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean resetShape(DynamicObject receiver_, Shape otherShape) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.resetShape(receiver_, otherShape);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object[] getKeyArray(DynamicObject receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getKeyArray(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Property[] getPropertyArray(DynamicObject receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicObjectLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getPropertyArray(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

        private void specialize(DynamicObject receiver_) {
            Lock lock = getLock();
            lock.lock();
            try {
                CachedDispatch current = this;
                DynamicObjectLibrary thisLibrary = current.library;
                if (thisLibrary == null) {
                    this.library = insert(INSTANCE.create(receiver_));
                } else {
                    int count = 0;
                    do {
                        DynamicObjectLibrary currentLibrary = current.library;
                        if (currentLibrary != null && currentLibrary.accepts(receiver_)) {
                            return;
                        }
                        count++;
                        current = current.next;
                    } while (current != null);
                    if (count >= getLimit()) {
                        this.library = insert(new CachedToUncachedDispatch());
                        this.next = null;
                    } else {
                        this.next = insert(new CachedDispatchNext(INSTANCE.create(receiver_), next));
                    }
                }
            } finally {
                lock.unlock();
            }
        }

    }
}
