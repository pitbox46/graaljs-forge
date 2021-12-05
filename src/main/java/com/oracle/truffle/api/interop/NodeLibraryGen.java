// CheckStyle: start generated
package com.oracle.truffle.api.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.interop.NodeLibrary.Asserts;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.library.Message;
import com.oracle.truffle.api.library.ReflectionLibrary;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.FinalBitSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.concurrent.locks.Lock;

@GeneratedBy(NodeLibrary.class)
final class NodeLibraryGen extends LibraryFactory<NodeLibrary> {

    private static final Class<NodeLibrary> LIBRARY_CLASS = NodeLibraryGen.lazyLibraryClass();
    private static final Message HAS_SCOPE = new MessageImpl("hasScope", 0, boolean.class, Object.class, Frame.class);
    private static final Message GET_SCOPE = new MessageImpl("getScope", 1, Object.class, Object.class, Frame.class, boolean.class);
    private static final Message HAS_RECEIVER_MEMBER = new MessageImpl("hasReceiverMember", 2, boolean.class, Object.class, Frame.class);
    private static final Message GET_RECEIVER_MEMBER = new MessageImpl("getReceiverMember", 3, Object.class, Object.class, Frame.class);
    private static final Message HAS_ROOT_INSTANCE = new MessageImpl("hasRootInstance", 4, boolean.class, Object.class, Frame.class);
    private static final Message GET_ROOT_INSTANCE = new MessageImpl("getRootInstance", 5, Object.class, Object.class, Frame.class);
    private static final Message GET_VIEW = new MessageImpl("getView", 6, Object.class, Object.class, Frame.class, Object.class);
    private static final NodeLibraryGen INSTANCE = new NodeLibraryGen();
    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(NodeLibraryGen.LIBRARY_CLASS, new Default());
        LibraryFactory.register(NodeLibraryGen.LIBRARY_CLASS, INSTANCE);
    }

    private NodeLibraryGen() {
        super(NodeLibraryGen.LIBRARY_CLASS, Collections.unmodifiableList(Arrays.asList(NodeLibraryGen.HAS_SCOPE, NodeLibraryGen.GET_SCOPE, NodeLibraryGen.HAS_RECEIVER_MEMBER, NodeLibraryGen.GET_RECEIVER_MEMBER, NodeLibraryGen.HAS_ROOT_INSTANCE, NodeLibraryGen.GET_ROOT_INSTANCE, NodeLibraryGen.GET_VIEW)));
    }

    @Override
    protected Class<?> getDefaultClass(Object receiver) {
        if (receiver instanceof Node) {
            return LegacyNodeExports.class;
        } else {
            return NodeLibrary.class;
        }
    }

    @Override
    protected NodeLibrary createAssertions(NodeLibrary delegate) {
        return new Asserts(delegate);
    }

    @Override
    protected NodeLibrary createProxy(ReflectionLibrary library) {
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
    protected NodeLibrary createDelegate(NodeLibrary delegateLibrary) {
        return new Delegate(delegateLibrary);
    }

    @Override
    protected Object genericDispatch(Library originalLib, Object receiver, Message message, Object[] args, int offset) throws Exception {
        NodeLibrary lib = (NodeLibrary) originalLib;
        MessageImpl messageImpl = (MessageImpl) message;
        if (messageImpl.getParameterCount() - 1 != args.length - offset) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Invalid number of arguments.");
        }
        switch (messageImpl.index) {
            case 0 :
                return lib.hasScope(receiver, (Frame) args[offset]);
            case 1 :
                return lib.getScope(receiver, (Frame) args[offset], (boolean) args[offset + 1]);
            case 2 :
                return lib.hasReceiverMember(receiver, (Frame) args[offset]);
            case 3 :
                return lib.getReceiverMember(receiver, (Frame) args[offset]);
            case 4 :
                return lib.hasRootInstance(receiver, (Frame) args[offset]);
            case 5 :
                return lib.getRootInstance(receiver, (Frame) args[offset]);
            case 6 :
                return lib.getView(receiver, (Frame) args[offset], args[offset + 1]);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new AbstractMethodError(message.toString());
    }

    @Override
    protected NodeLibrary createDispatchImpl(int limit) {
        return new CachedDispatchFirst(null, null, limit);
    }

    @Override
    protected NodeLibrary createUncachedDispatch() {
        return new UncachedDispatch();
    }

    @SuppressWarnings("unchecked")
    private static Class<NodeLibrary> lazyLibraryClass() {
        try {
            return (Class<NodeLibrary>) Class.forName("com.oracle.truffle.api.interop.NodeLibrary", false, NodeLibraryGen.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw CompilerDirectives.shouldNotReachHere(e);
        }
    }

    @GeneratedBy(NodeLibrary.class)
    private static final class Default extends LibraryExport<NodeLibrary> {

        private Default() {
            super(NodeLibrary.class, Object.class, false, false, 0);
        }

        @Override
        protected NodeLibrary createUncached(Object receiver) {
            NodeLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected NodeLibrary createCached(Object receiver) {
            return new Cached(receiver);
        }

        @GeneratedBy(NodeLibrary.class)
        private static final class Cached extends NodeLibrary {

            @Child private DynamicDispatchLibrary dynamicDispatch_;
            private final Class<?> dynamicDispatchTarget_;

            protected Cached(Object receiver) {
                this.dynamicDispatch_ = insert(DYNAMIC_DISPATCH_LIBRARY_.create(receiver));
                this.dynamicDispatchTarget_ = DYNAMIC_DISPATCH_LIBRARY_.getUncached(receiver).dispatch(receiver);
            }

            @Override
            public boolean accepts(Object receiver) {
                return dynamicDispatch_.accepts(receiver) && dynamicDispatch_.dispatch(receiver) == dynamicDispatchTarget_;
            }

            @Override
            public boolean hasScope(Object receiver, Frame frame) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasScope((dynamicDispatch_.cast(receiver)), frame);
            }

            @Override
            public Object getScope(Object receiver, Frame frame, boolean nodeEnter) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getScope((dynamicDispatch_.cast(receiver)), frame, nodeEnter);
            }

            @Override
            public boolean hasReceiverMember(Object receiver, Frame frame) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasReceiverMember((dynamicDispatch_.cast(receiver)), frame);
            }

            @Override
            public Object getReceiverMember(Object receiver, Frame frame) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getReceiverMember((dynamicDispatch_.cast(receiver)), frame);
            }

            @Override
            public boolean hasRootInstance(Object receiver, Frame frame) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasRootInstance((dynamicDispatch_.cast(receiver)), frame);
            }

            @Override
            public Object getRootInstance(Object receiver, Frame frame) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getRootInstance((dynamicDispatch_.cast(receiver)), frame);
            }

            @Override
            public Object getView(Object receiver, Frame frame, Object value) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getView((dynamicDispatch_.cast(receiver)), frame, value);
            }

        }
        @GeneratedBy(NodeLibrary.class)
        private static final class Uncached extends NodeLibrary {

            @Child private DynamicDispatchLibrary dynamicDispatch_;
            private final Class<?> dynamicDispatchTarget_;

            protected Uncached(Object receiver) {
                this.dynamicDispatch_ = DYNAMIC_DISPATCH_LIBRARY_.getUncached(receiver);
                this.dynamicDispatchTarget_ = dynamicDispatch_.dispatch(receiver);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                return dynamicDispatch_.accepts(receiver) && dynamicDispatch_.dispatch(receiver) == dynamicDispatchTarget_;
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
            public boolean hasScope(Object receiver, Frame frame) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasScope(receiver, frame);
            }

            @TruffleBoundary
            @Override
            public Object getScope(Object receiver, Frame frame, boolean nodeEnter) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getScope(receiver, frame, nodeEnter);
            }

            @TruffleBoundary
            @Override
            public boolean hasReceiverMember(Object receiver, Frame frame) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasReceiverMember(receiver, frame);
            }

            @TruffleBoundary
            @Override
            public Object getReceiverMember(Object receiver, Frame frame) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getReceiverMember(receiver, frame);
            }

            @TruffleBoundary
            @Override
            public boolean hasRootInstance(Object receiver, Frame frame) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasRootInstance(receiver, frame);
            }

            @TruffleBoundary
            @Override
            public Object getRootInstance(Object receiver, Frame frame) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getRootInstance(receiver, frame);
            }

            @TruffleBoundary
            @Override
            public Object getView(Object receiver, Frame frame, Object value) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getView(receiver, frame, value);
            }

        }
    }
    @GeneratedBy(NodeLibrary.class)
    private static class MessageImpl extends Message {

        final int index;

        MessageImpl(String name, int index, Class<?> returnType, Class<?>... parameters) {
            super(NodeLibraryGen.LIBRARY_CLASS, name, returnType, parameters);
            this.index = index;
        }

    }
    @GeneratedBy(NodeLibrary.class)
    private static final class Proxy extends NodeLibrary {

        @Child private ReflectionLibrary lib;

        Proxy(ReflectionLibrary lib) {
            this.lib = lib;
        }

        @Override
        public boolean hasScope(Object receiver_, Frame frame) {
            try {
                return (boolean) lib.send(receiver_, NodeLibraryGen.HAS_SCOPE, frame);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getScope(Object receiver_, Frame frame, boolean nodeEnter) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, NodeLibraryGen.GET_SCOPE, frame, nodeEnter);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasReceiverMember(Object receiver_, Frame frame) {
            try {
                return (boolean) lib.send(receiver_, NodeLibraryGen.HAS_RECEIVER_MEMBER, frame);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getReceiverMember(Object receiver_, Frame frame) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, NodeLibraryGen.GET_RECEIVER_MEMBER, frame);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasRootInstance(Object receiver_, Frame frame) {
            try {
                return (boolean) lib.send(receiver_, NodeLibraryGen.HAS_ROOT_INSTANCE, frame);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getRootInstance(Object receiver_, Frame frame) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, NodeLibraryGen.GET_ROOT_INSTANCE, frame);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getView(Object receiver_, Frame frame, Object value) {
            try {
                return lib.send(receiver_, NodeLibraryGen.GET_VIEW, frame, value);
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
    @GeneratedBy(NodeLibrary.class)
    private static final class Delegate extends NodeLibrary {

        @Child private NodeLibrary delegateLibrary;

        Delegate(NodeLibrary delegateLibrary) {
            this.delegateLibrary = delegateLibrary;
        }

        @Override
        public boolean hasScope(Object receiver_, Frame frame) {
            if (LibraryFactory.isDelegated(delegateLibrary, 0)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasScope(delegate, frame);
            } else {
                return this.delegateLibrary.hasScope(receiver_, frame);
            }
        }

        @Override
        public Object getScope(Object receiver_, Frame frame, boolean nodeEnter) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 1)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getScope(delegate, frame, nodeEnter);
            } else {
                return this.delegateLibrary.getScope(receiver_, frame, nodeEnter);
            }
        }

        @Override
        public boolean hasReceiverMember(Object receiver_, Frame frame) {
            if (LibraryFactory.isDelegated(delegateLibrary, 2)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasReceiverMember(delegate, frame);
            } else {
                return this.delegateLibrary.hasReceiverMember(receiver_, frame);
            }
        }

        @Override
        public Object getReceiverMember(Object receiver_, Frame frame) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 3)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getReceiverMember(delegate, frame);
            } else {
                return this.delegateLibrary.getReceiverMember(receiver_, frame);
            }
        }

        @Override
        public boolean hasRootInstance(Object receiver_, Frame frame) {
            if (LibraryFactory.isDelegated(delegateLibrary, 4)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasRootInstance(delegate, frame);
            } else {
                return this.delegateLibrary.hasRootInstance(receiver_, frame);
            }
        }

        @Override
        public Object getRootInstance(Object receiver_, Frame frame) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 5)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getRootInstance(delegate, frame);
            } else {
                return this.delegateLibrary.getRootInstance(receiver_, frame);
            }
        }

        @Override
        public Object getView(Object receiver_, Frame frame, Object value) {
            if (LibraryFactory.isDelegated(delegateLibrary, 6)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getView(delegate, frame, value);
            } else {
                return this.delegateLibrary.getView(receiver_, frame, value);
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
    @GeneratedBy(NodeLibrary.class)
    private static final class CachedToUncachedDispatch extends NodeLibrary {

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @TruffleBoundary
        @Override
        public boolean hasScope(Object receiver_, Frame frame) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasScope(receiver_, frame);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getScope(Object receiver_, Frame frame, boolean nodeEnter) throws UnsupportedMessageException {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getScope(receiver_, frame, nodeEnter);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasReceiverMember(Object receiver_, Frame frame) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasReceiverMember(receiver_, frame);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getReceiverMember(Object receiver_, Frame frame) throws UnsupportedMessageException {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getReceiverMember(receiver_, frame);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasRootInstance(Object receiver_, Frame frame) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasRootInstance(receiver_, frame);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getRootInstance(Object receiver_, Frame frame) throws UnsupportedMessageException {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getRootInstance(receiver_, frame);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getView(Object receiver_, Frame frame, Object value) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getView(receiver_, frame, value);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

    }
    @GeneratedBy(NodeLibrary.class)
    private static final class UncachedDispatch extends NodeLibrary {

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @TruffleBoundary
        @Override
        public boolean hasScope(Object receiver_, Frame frame) {
            return INSTANCE.getUncached(receiver_).hasScope(receiver_, frame);
        }

        @TruffleBoundary
        @Override
        public Object getScope(Object receiver_, Frame frame, boolean nodeEnter) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getScope(receiver_, frame, nodeEnter);
        }

        @TruffleBoundary
        @Override
        public boolean hasReceiverMember(Object receiver_, Frame frame) {
            return INSTANCE.getUncached(receiver_).hasReceiverMember(receiver_, frame);
        }

        @TruffleBoundary
        @Override
        public Object getReceiverMember(Object receiver_, Frame frame) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getReceiverMember(receiver_, frame);
        }

        @TruffleBoundary
        @Override
        public boolean hasRootInstance(Object receiver_, Frame frame) {
            return INSTANCE.getUncached(receiver_).hasRootInstance(receiver_, frame);
        }

        @TruffleBoundary
        @Override
        public Object getRootInstance(Object receiver_, Frame frame) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getRootInstance(receiver_, frame);
        }

        @TruffleBoundary
        @Override
        public Object getView(Object receiver_, Frame frame, Object value) {
            return INSTANCE.getUncached(receiver_).getView(receiver_, frame, value);
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
    @GeneratedBy(NodeLibrary.class)
    private static final class CachedDispatchNext extends CachedDispatch {

        CachedDispatchNext(NodeLibrary library, CachedDispatch next) {
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
    @GeneratedBy(NodeLibrary.class)
    private static final class CachedDispatchFirst extends CachedDispatch {

        private final int limit_;

        CachedDispatchFirst(NodeLibrary library, CachedDispatch next, int limit_) {
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
    @GeneratedBy(NodeLibrary.class)
    private abstract static class CachedDispatch extends NodeLibrary {

        @Child NodeLibrary library;
        @Child CachedDispatch next;

        CachedDispatch(NodeLibrary library, CachedDispatch next) {
            this.library = library;
            this.next = next;
        }

        abstract int getLimit();

        @ExplodeLoop
        @Override
        public boolean hasScope(Object receiver_, Frame frame) {
            do {
                CachedDispatch current = this;
                do {
                    NodeLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasScope(receiver_, frame);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getScope(Object receiver_, Frame frame, boolean nodeEnter) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    NodeLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getScope(receiver_, frame, nodeEnter);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasReceiverMember(Object receiver_, Frame frame) {
            do {
                CachedDispatch current = this;
                do {
                    NodeLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasReceiverMember(receiver_, frame);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getReceiverMember(Object receiver_, Frame frame) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    NodeLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getReceiverMember(receiver_, frame);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasRootInstance(Object receiver_, Frame frame) {
            do {
                CachedDispatch current = this;
                do {
                    NodeLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasRootInstance(receiver_, frame);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getRootInstance(Object receiver_, Frame frame) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    NodeLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getRootInstance(receiver_, frame);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getView(Object receiver_, Frame frame, Object value) {
            do {
                CachedDispatch current = this;
                do {
                    NodeLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getView(receiver_, frame, value);
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
                NodeLibrary thisLibrary = current.library;
                if (thisLibrary == null) {
                    this.library = insert(INSTANCE.create(receiver_));
                } else {
                    int count = 0;
                    do {
                        NodeLibrary currentLibrary = current.library;
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
