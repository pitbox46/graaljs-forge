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

@GeneratedBy(ReflectionLibrary.class)
final class ReflectionLibraryGen extends LibraryFactory<ReflectionLibrary> {

    private static final Class<ReflectionLibrary> LIBRARY_CLASS = ReflectionLibraryGen.lazyLibraryClass();
    private static final Message SEND = new MessageImpl("send", 0, Object.class, Object.class, Message.class, Object[].class);
    private static final ReflectionLibraryGen INSTANCE = new ReflectionLibraryGen();

    static  {
        LibraryFactory.register(ReflectionLibraryGen.LIBRARY_CLASS, INSTANCE);
    }

    private ReflectionLibraryGen() {
        super(ReflectionLibraryGen.LIBRARY_CLASS, Collections.unmodifiableList(Arrays.asList(ReflectionLibraryGen.SEND)));
    }

    @Override
    protected Class<?> getDefaultClass(Object receiver) {
        return ReflectionLibraryDefault.class;
    }

    @Override
    protected ReflectionLibrary createProxy(ReflectionLibrary library) {
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
    protected ReflectionLibrary createDelegate(ReflectionLibrary delegateLibrary) {
        return new Delegate(delegateLibrary);
    }

    @Override
    protected Object genericDispatch(Library originalLib, Object receiver, Message message, Object[] args, int offset) throws Exception {
        ReflectionLibrary lib = (ReflectionLibrary) originalLib;
        MessageImpl messageImpl = (MessageImpl) message;
        if (messageImpl.getParameterCount() - 1 != args.length - offset) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Invalid number of arguments.");
        }
        switch (messageImpl.index) {
            case 0 :
                return lib.send(receiver, (Message) args[offset], (Object[]) args[offset + 1]);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new AbstractMethodError(message.toString());
    }

    @Override
    protected ReflectionLibrary createDispatchImpl(int limit) {
        return new CachedDispatchFirst(null, null, limit);
    }

    @Override
    protected ReflectionLibrary createUncachedDispatch() {
        return new UncachedDispatch();
    }

    @SuppressWarnings("unchecked")
    private static Class<ReflectionLibrary> lazyLibraryClass() {
        try {
            return (Class<ReflectionLibrary>) Class.forName("com.oracle.truffle.api.library.ReflectionLibrary", false, ReflectionLibraryGen.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw CompilerDirectives.shouldNotReachHere(e);
        }
    }

    @GeneratedBy(ReflectionLibrary.class)
    private static class MessageImpl extends Message {

        final int index;

        MessageImpl(String name, int index, Class<?> returnType, Class<?>... parameters) {
            super(ReflectionLibraryGen.LIBRARY_CLASS, name, returnType, parameters);
            this.index = index;
        }

    }
    @GeneratedBy(ReflectionLibrary.class)
    private static final class Proxy extends ReflectionLibrary {

        @Child private ReflectionLibrary lib;

        Proxy(ReflectionLibrary lib) {
            this.lib = lib;
        }

        @Override
        public Object send(Object receiver_, Message message, Object... args) throws Exception {
            try {
                return lib.send(receiver_, ReflectionLibraryGen.SEND, message, args);
            } catch (Exception e_) {
                throw e_;
            }
        }

        @Override
        public boolean accepts(Object receiver_) {
            return lib.accepts(receiver_);
        }

    }
    @GeneratedBy(ReflectionLibrary.class)
    private static final class Delegate extends ReflectionLibrary {

        @Child private ReflectionLibrary delegateLibrary;

        Delegate(ReflectionLibrary delegateLibrary) {
            this.delegateLibrary = delegateLibrary;
        }

        @Override
        public Object send(Object receiver_, Message message, Object... args) throws Exception {
            if (LibraryFactory.isDelegated(delegateLibrary, 0)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).send(delegate, message, args);
            } else {
                return this.delegateLibrary.send(receiver_, message, args);
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
    @GeneratedBy(ReflectionLibrary.class)
    private static final class CachedToUncachedDispatch extends ReflectionLibrary {

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @TruffleBoundary
        @Override
        public Object send(Object receiver_, Message message, Object... args) throws Exception {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).send(receiver_, message, args);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

    }
    @GeneratedBy(ReflectionLibrary.class)
    private static final class UncachedDispatch extends ReflectionLibrary {

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @TruffleBoundary
        @Override
        public Object send(Object receiver_, Message message, Object... args) throws Exception {
            return INSTANCE.getUncached(receiver_).send(receiver_, message, args);
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
    @GeneratedBy(ReflectionLibrary.class)
    private static final class CachedDispatchNext extends CachedDispatch {

        CachedDispatchNext(ReflectionLibrary library, CachedDispatch next) {
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
    @GeneratedBy(ReflectionLibrary.class)
    private static final class CachedDispatchFirst extends CachedDispatch {

        private final int limit_;

        CachedDispatchFirst(ReflectionLibrary library, CachedDispatch next, int limit_) {
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
    @GeneratedBy(ReflectionLibrary.class)
    private abstract static class CachedDispatch extends ReflectionLibrary {

        @Child ReflectionLibrary library;
        @Child CachedDispatch next;

        CachedDispatch(ReflectionLibrary library, CachedDispatch next) {
            this.library = library;
            this.next = next;
        }

        abstract int getLimit();

        @ExplodeLoop
        @Override
        public Object send(Object receiver_, Message message, Object... args) throws Exception {
            do {
                CachedDispatch current = this;
                do {
                    ReflectionLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.send(receiver_, message, args);
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

        private void specialize(Object receiver_) {
            Lock lock = getLock();
            lock.lock();
            try {
                CachedDispatch current = this;
                ReflectionLibrary thisLibrary = current.library;
                if (thisLibrary == null) {
                    this.library = insert(INSTANCE.create(receiver_));
                } else {
                    int count = 0;
                    do {
                        ReflectionLibrary currentLibrary = current.library;
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
