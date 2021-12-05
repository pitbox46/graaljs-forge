// CheckStyle: start generated
package com.oracle.truffle.api.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;

@GeneratedBy(LegacyNodeExports.class)
final class LegacyNodeExportsGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(LegacyNodeExports.class, new NodeLibraryExports());
    }

    private LegacyNodeExportsGen() {
    }

    @GeneratedBy(LegacyNodeExports.class)
    private static final class NodeLibraryExports extends LibraryExport<NodeLibrary> {

        private NodeLibraryExports() {
            super(NodeLibrary.class, Node.class, true, false, 0);
        }

        @Override
        protected NodeLibrary createUncached(Object receiver) {
            assert receiver instanceof Node;
            NodeLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected NodeLibrary createCached(Object receiver) {
            assert receiver instanceof Node;
            return new Cached(receiver);
        }

        @GeneratedBy(LegacyNodeExports.class)
        private static final class Cached extends NodeLibrary {

            private final Class<? extends Node> receiverClass_;

            protected Cached(Object receiver) {
                Node castReceiver = ((Node) receiver) ;
                this.receiverClass_ = castReceiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            public boolean hasScope(Object receiver, Frame frame) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.hasScope((CompilerDirectives.castExact(receiver, receiverClass_)), frame);
            }

            @Override
            public Object getScope(Object receiver, Frame frame, boolean nodeEnter) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.getScope((CompilerDirectives.castExact(receiver, receiverClass_)), frame, nodeEnter);
            }

            @Override
            public boolean hasReceiverMember(Object receiver, Frame frame) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.hasReceiverMember((CompilerDirectives.castExact(receiver, receiverClass_)), frame);
            }

            @Override
            public Object getReceiverMember(Object receiver, Frame frame) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.getReceiverMember((CompilerDirectives.castExact(receiver, receiverClass_)), frame);
            }

            @Override
            public boolean hasRootInstance(Object receiver, Frame frame) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.hasRootInstance((CompilerDirectives.castExact(receiver, receiverClass_)), frame);
            }

            @Override
            public Object getRootInstance(Object receiver, Frame frame) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.getRootInstance((CompilerDirectives.castExact(receiver, receiverClass_)), frame);
            }

            @Override
            public Object getView(Object receiver, Frame frame, Object value) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.getView((CompilerDirectives.castExact(receiver, receiverClass_)), frame, value);
            }

        }
        @GeneratedBy(LegacyNodeExports.class)
        private static final class Uncached extends NodeLibrary {

            private final Class<? extends Node> receiverClass_;

            protected Uncached(Object receiver) {
                this.receiverClass_ = ((Node) receiver).getClass();
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
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
            public boolean hasScope(Object receiver, Frame frame) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.hasScope(((Node) receiver) , frame);
            }

            @TruffleBoundary
            @Override
            public Object getScope(Object receiver, Frame frame, boolean nodeEnter) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.getScope(((Node) receiver) , frame, nodeEnter);
            }

            @TruffleBoundary
            @Override
            public boolean hasReceiverMember(Object receiver, Frame frame) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.hasReceiverMember(((Node) receiver) , frame);
            }

            @TruffleBoundary
            @Override
            public Object getReceiverMember(Object receiver, Frame frame) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.getReceiverMember(((Node) receiver) , frame);
            }

            @TruffleBoundary
            @Override
            public boolean hasRootInstance(Object receiver, Frame frame) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.hasRootInstance(((Node) receiver) , frame);
            }

            @TruffleBoundary
            @Override
            public Object getRootInstance(Object receiver, Frame frame) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.getRootInstance(((Node) receiver) , frame);
            }

            @TruffleBoundary
            @Override
            public Object getView(Object receiver, Frame frame, Object value) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return LegacyNodeExports.getView(((Node) receiver) , frame, value);
            }

        }
    }
}
