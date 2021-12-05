// CheckStyle: start generated
package com.oracle.truffle.js.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.interop.NodeLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JavaScriptNode.class)
public final class JavaScriptNodeGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(JavaScriptNode.class, new NodeLibraryExports());
    }

    private JavaScriptNodeGen() {
    }

    @GeneratedBy(JavaScriptNode.class)
    public static class NodeLibraryExports extends LibraryExport<NodeLibrary> {

        private NodeLibraryExports() {
            super(NodeLibrary.class, JavaScriptNode.class, false, false, 0);
        }

        @Override
        protected NodeLibrary createUncached(Object receiver) {
            assert receiver instanceof JavaScriptNode;
            NodeLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected NodeLibrary createCached(Object receiver) {
            assert receiver instanceof JavaScriptNode;
            return new Cached(receiver);
        }

        @GeneratedBy(JavaScriptNode.class)
        public static class Cached extends NodeLibrary {

            private final Class<? extends JavaScriptNode> receiverClass_;
            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private JavaScriptNode acceptsNode__accepts_cachedNode_;
            @CompilationFinal private Node getScopeNode__getScope_block_;

            protected Cached(Object receiver) {
                JavaScriptNode castReceiver = ((JavaScriptNode) receiver) ;
                this.acceptsNode__accepts_cachedNode_ = (castReceiver);
                this.receiverClass_ = castReceiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_) && accepts_(receiver);
            }

            private boolean accepts_(Object arg0Value_) {
                JavaScriptNode arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                return arg0Value.accepts(this.acceptsNode__accepts_cachedNode_);
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MONOMORPHIC;
            }

            @Override
            public boolean hasScope(Object receiver, Frame frame) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).hasScope(frame);
            }

            @Override
            public Object getScope(Object arg0Value_, Frame arg1Value, boolean arg2Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                JavaScriptNode arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 getScope(JavaScriptNode, Frame, boolean, Node) */) {
                    return arg0Value.getScope(arg1Value, arg2Value, this.getScopeNode__getScope_block_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getScopeNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object getScopeNode_AndSpecialize(JavaScriptNode arg0Value, Frame arg1Value, boolean arg2Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.getScopeNode__getScope_block_ = (JavaScriptNode.findBlockScopeNode(arg0Value));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getScope(JavaScriptNode, Frame, boolean, Node) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getScope(arg1Value, arg2Value, this.getScopeNode__getScope_block_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasReceiverMember(Object receiver, Frame frame) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).hasReceiverMember(frame);
            }

            @Override
            public Object getReceiverMember(Object receiver, Frame frame) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).getReceiverMember(frame);
            }

            @Override
            public boolean hasRootInstance(Object receiver, Frame frame) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).hasRootInstance(frame);
            }

            @Override
            public Object getRootInstance(Object receiver, Frame frame) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).getRootInstance(frame);
            }

        }
        @GeneratedBy(JavaScriptNode.class)
        public static class Uncached extends NodeLibrary {

            private final Class<? extends JavaScriptNode> receiverClass_;

            protected Uncached(Object receiver) {
                this.receiverClass_ = ((JavaScriptNode) receiver).getClass();
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_) && accepts_(receiver);
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
            public boolean hasScope(Object receiver, Frame frame) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JavaScriptNode) receiver) .hasScope(frame);
            }

            @TruffleBoundary
            @Override
            public Object getScope(Object arg0Value_, Frame arg1Value, boolean arg2Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JavaScriptNode arg0Value = ((JavaScriptNode) arg0Value_);
                return arg0Value.getScope(arg1Value, arg2Value, (JavaScriptNode.findBlockScopeNode(arg0Value)));
            }

            @TruffleBoundary
            @Override
            public boolean hasReceiverMember(Object receiver, Frame frame) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JavaScriptNode) receiver) .hasReceiverMember(frame);
            }

            @TruffleBoundary
            @Override
            public Object getReceiverMember(Object receiver, Frame frame) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JavaScriptNode) receiver) .getReceiverMember(frame);
            }

            @TruffleBoundary
            @Override
            public boolean hasRootInstance(Object receiver, Frame frame) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JavaScriptNode) receiver) .hasRootInstance(frame);
            }

            @TruffleBoundary
            @Override
            public Object getRootInstance(Object receiver, Frame frame) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JavaScriptNode) receiver) .getRootInstance(frame);
            }

            @TruffleBoundary
            private static boolean accepts_(Object arg0Value_) {
                JavaScriptNode arg0Value = ((JavaScriptNode) arg0Value_);
                return arg0Value.accepts((arg0Value));
            }

        }
    }
}
