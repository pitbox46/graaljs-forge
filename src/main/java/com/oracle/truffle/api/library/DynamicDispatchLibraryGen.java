// CheckStyle: start generated
package com.oracle.truffle.api.library;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.FinalBitSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DynamicDispatchLibrary.class)
@SuppressWarnings("unused")
final class DynamicDispatchLibraryGen extends LibraryFactory<DynamicDispatchLibrary> {

    private static final Class<DynamicDispatchLibrary> LIBRARY_CLASS = DynamicDispatchLibraryGen.lazyLibraryClass();
    private static final Message DISPATCH = new MessageImpl("dispatch", 0, Class.class, Object.class);
    private static final DynamicDispatchLibraryGen INSTANCE = new DynamicDispatchLibraryGen();

    static  {
        LibraryExport.register(DynamicDispatchLibraryGen.LIBRARY_CLASS, new Default());
        LibraryFactory.register(DynamicDispatchLibraryGen.LIBRARY_CLASS, INSTANCE);
    }

    private DynamicDispatchLibraryGen() {
        super(DynamicDispatchLibraryGen.LIBRARY_CLASS, Collections.unmodifiableList(Arrays.asList(DynamicDispatchLibraryGen.DISPATCH)));
    }

    @Override
    protected Class<?> getDefaultClass(Object receiver) {
        return DynamicDispatchLibrary.class;
    }

    @Override
    protected DynamicDispatchLibrary createProxy(ReflectionLibrary library) {
        return new Proxy(library);
    }

    @Override
    protected FinalBitSet createMessageBitSet(@SuppressWarnings({"unused", "hiding"}) Message... messages) {
        BitSet bitSet = new BitSet(2);
        for (Message message : messages) {
            bitSet.set(((MessageImpl) message).index);
        }
        return FinalBitSet.valueOf(bitSet);
    }

    @Override
    protected DynamicDispatchLibrary createDelegate(DynamicDispatchLibrary delegateLibrary) {
        return new Delegate(delegateLibrary);
    }

    @Override
    protected Object genericDispatch(Library originalLib, Object receiver, Message message, Object[] args, int offset) throws Exception {
        DynamicDispatchLibrary lib = (DynamicDispatchLibrary) originalLib;
        MessageImpl messageImpl = (MessageImpl) message;
        if (messageImpl.getParameterCount() - 1 != args.length - offset) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Invalid number of arguments.");
        }
        switch (messageImpl.index) {
            case 0 :
                return lib.dispatch(receiver);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new AbstractMethodError(message.toString());
    }

    @Override
    protected DynamicDispatchLibrary createDispatchImpl(int limit) {
        return new CachedDispatchFirst(null, null, limit);
    }

    @Override
    protected DynamicDispatchLibrary createUncachedDispatch() {
        return new UncachedDispatch();
    }

    @SuppressWarnings("unchecked")
    private static Class<DynamicDispatchLibrary> lazyLibraryClass() {
        try {
            return (Class<DynamicDispatchLibrary>) Class.forName("com.oracle.truffle.api.library.DynamicDispatchLibrary", false, DynamicDispatchLibraryGen.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw CompilerDirectives.shouldNotReachHere(e);
        }
    }

    @GeneratedBy(DynamicDispatchLibrary.class)
    private static final class Default extends LibraryExport<DynamicDispatchLibrary> {

        private Default() {
            super(DynamicDispatchLibrary.class, Object.class, false, false, 0);
        }

        @Override
        protected DynamicDispatchLibrary createUncached(Object receiver) {
            DynamicDispatchLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected DynamicDispatchLibrary createCached(Object receiver) {
            return new Cached(receiver);
        }

        @GeneratedBy(DynamicDispatchLibrary.class)
        private static final class Cached extends DynamicDispatchLibrary {

            private final Class<? extends Object> receiverClass_;

            protected Cached(Object receiver) {
                this.receiverClass_ = receiver.getClass();
            }

            @Override
            public Object cast(Object receiver) {
                return CompilerDirectives.castExact(receiver, receiverClass_);
            }

            @Override
            public boolean accepts(Object receiver) {
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            public Class<?> dispatch(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.dispatch((CompilerDirectives.castExact(receiver, receiverClass_)));
            }

        }
        @GeneratedBy(DynamicDispatchLibrary.class)
        private static final class Uncached extends DynamicDispatchLibrary {

            protected Uncached(Object receiver) {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                return true;
            }

            @TruffleBoundary
            @Override
            public Object cast(Object receiver) {
                return (receiver);
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
            public Class<?> dispatch(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.dispatch(receiver);
            }

        }
    }
    @GeneratedBy(DynamicDispatchLibrary.class)
    private static class MessageImpl extends Message {

        final int index;

        MessageImpl(String name, int index, Class<?> returnType, Class<?>... parameters) {
            super(DynamicDispatchLibraryGen.LIBRARY_CLASS, name, returnType, parameters);
            this.index = index;
        }

    }
    @GeneratedBy(DynamicDispatchLibrary.class)
    private static final class Proxy extends DynamicDispatchLibrary {

        @Child private ReflectionLibrary lib;

        Proxy(ReflectionLibrary lib) {
            this.lib = lib;
        }

        @Override
        public Object cast(Object receiver) {
            return receiver;
        }

        @SuppressWarnings("unchecked")
        @Override
        public Class<?> dispatch(Object receiver_) {
            try {
                return (Class<?>) lib.send(receiver_, DynamicDispatchLibraryGen.DISPATCH);
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
    @GeneratedBy(DynamicDispatchLibrary.class)
    private static final class Delegate extends DynamicDispatchLibrary {

        @Child private DynamicDispatchLibrary delegateLibrary;

        Delegate(DynamicDispatchLibrary delegateLibrary) {
            this.delegateLibrary = delegateLibrary;
        }

        @Override
        public Object cast(Object receiver) {
            return delegateLibrary.cast(receiver);
        }

        @Override
        public Class<?> dispatch(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 0)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).dispatch(delegate);
            } else {
                return this.delegateLibrary.dispatch(receiver_);
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
    @GeneratedBy(DynamicDispatchLibrary.class)
    private static final class CachedToUncachedDispatch extends DynamicDispatchLibrary {

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @TruffleBoundary
        @Override
        public Class<?> dispatch(Object receiver_) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).dispatch(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

        @Override
        public Object cast(Object receiver) {
            return receiver;
        }

    }
    @GeneratedBy(DynamicDispatchLibrary.class)
    private static final class UncachedDispatch extends DynamicDispatchLibrary {

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @TruffleBoundary
        @Override
        public Class<?> dispatch(Object receiver_) {
            return INSTANCE.getUncached(receiver_).dispatch(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

        @Override
        public Object cast(Object receiver) {
            return receiver;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
    @GeneratedBy(DynamicDispatchLibrary.class)
    private static final class CachedDispatchNext extends CachedDispatch {

        CachedDispatchNext(DynamicDispatchLibrary library, CachedDispatch next) {
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
    @GeneratedBy(DynamicDispatchLibrary.class)
    private static final class CachedDispatchFirst extends CachedDispatch {

        private final int limit_;

        CachedDispatchFirst(DynamicDispatchLibrary library, CachedDispatch next, int limit_) {
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
    @GeneratedBy(DynamicDispatchLibrary.class)
    private abstract static class CachedDispatch extends DynamicDispatchLibrary {

        @Child DynamicDispatchLibrary library;
        @Child CachedDispatch next;

        CachedDispatch(DynamicDispatchLibrary library, CachedDispatch next) {
            this.library = library;
            this.next = next;
        }

        abstract int getLimit();

        @ExplodeLoop
        @Override
        public Class<?> dispatch(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    DynamicDispatchLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.dispatch(receiver_);
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

        @Override
        public Object cast(Object receiver) {
            return receiver;
        }

        private void specialize(Object receiver_) {
            Lock lock = getLock();
            lock.lock();
            try {
                CachedDispatch current = this;
                DynamicDispatchLibrary thisLibrary = current.library;
                if (thisLibrary == null) {
                    this.library = insert(INSTANCE.create(receiver_));
                } else {
                    int count = 0;
                    do {
                        DynamicDispatchLibrary currentLibrary = current.library;
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
