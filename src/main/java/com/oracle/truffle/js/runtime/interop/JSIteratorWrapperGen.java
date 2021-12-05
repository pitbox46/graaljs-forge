// CheckStyle: start generated
package com.oracle.truffle.js.runtime.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.StopIterationException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.FinalBitSet;
import com.oracle.truffle.js.nodes.interop.JSInteropGetIteratorNextNode;
import com.oracle.truffle.js.nodes.interop.JSInteropGetIteratorNextNodeGen;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSIteratorWrapper.class)
final class JSIteratorWrapperGen {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);
    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(JSIteratorWrapper.class, new InteropLibraryExports());
    }

    private JSIteratorWrapperGen() {
    }

    @GeneratedBy(JSIteratorWrapper.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        static final FinalBitSet ENABLED_MESSAGES = createMessageBitSet(INTEROP_LIBRARY_, "isIterator", "hasIteratorNextElement", "getIteratorNextElement");

        private InteropLibraryExports() {
            super(InteropLibrary.class, JSIteratorWrapper.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JSIteratorWrapper;
            InteropLibrary uncached = createDelegate(INTEROP_LIBRARY_, new Uncached());
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JSIteratorWrapper;
            return createDelegate(INTEROP_LIBRARY_, new Cached(receiver));
        }

        @GeneratedBy(JSIteratorWrapper.class)
        private static final class Cached extends InteropLibrary implements DelegateExport {

            @Child private InteropLibrary receiverIteratorInteropLibrary_;
            @CompilationFinal private volatile int state_0_;
            @Child private JSInteropGetIteratorNextNode getIteratorNext;

            protected Cached(Object receiver) {
                JSIteratorWrapper castReceiver = ((JSIteratorWrapper) receiver) ;
                this.receiverIteratorInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((castReceiver.iterator)));
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return ((JSIteratorWrapper) receiver_).iterator;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate) {
                return this.receiverIteratorInteropLibrary_;
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JSIteratorWrapper) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof JSIteratorWrapper)) {
                    return false;
                } else if (!this.receiverIteratorInteropLibrary_.accepts((((JSIteratorWrapper) receiver).iterator))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean isIterator(Object receiver) {
                assert receiver instanceof JSIteratorWrapper : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSIteratorWrapper) receiver)).isIterator();
            }

            @Override
            public boolean hasIteratorNextElement(Object arg0Value_) throws UnsupportedMessageException {
                assert arg0Value_ instanceof JSIteratorWrapper : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSIteratorWrapper arg0Value = ((JSIteratorWrapper) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) != 0 /* is-state_0 hasIteratorNextElement(JSIteratorWrapper, InteropLibrary, JSInteropGetIteratorNextNode) */) {
                    {
                        InteropLibrary hasIteratorNextElementNode__hasIteratorNextElement_self__ = (((InteropLibrary) this.getParent()));
                        return arg0Value.hasIteratorNextElement(hasIteratorNextElementNode__hasIteratorNextElement_self__, this.getIteratorNext);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasIteratorNextElementNode_AndSpecialize(arg0Value);
            }

            private boolean hasIteratorNextElementNode_AndSpecialize(JSIteratorWrapper arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary hasIteratorNextElementNode__hasIteratorNextElement_self__ = null;
                        hasIteratorNextElementNode__hasIteratorNextElement_self__ = (((InteropLibrary) this.getParent()));
                        this.getIteratorNext = super.insert(this.getIteratorNext == null ? ((JSInteropGetIteratorNextNode.create())) : this.getIteratorNext);
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 hasIteratorNextElement(JSIteratorWrapper, InteropLibrary, JSInteropGetIteratorNextNode) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.hasIteratorNextElement(hasIteratorNextElementNode__hasIteratorNextElement_self__, this.getIteratorNext);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public NodeCost getCost() {
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    return NodeCost.MONOMORPHIC;
                }
            }

            @Override
            public Object getIteratorNextElement(Object arg0Value_) throws UnsupportedMessageException, StopIterationException {
                assert arg0Value_ instanceof JSIteratorWrapper : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSIteratorWrapper arg0Value = ((JSIteratorWrapper) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10) != 0 /* is-state_0 getIteratorNextElement(JSIteratorWrapper, InteropLibrary, JSInteropGetIteratorNextNode) */) {
                    {
                        InteropLibrary getIteratorNextElementNode__getIteratorNextElement_self__ = (((InteropLibrary) this.getParent()));
                        return arg0Value.getIteratorNextElement(getIteratorNextElementNode__getIteratorNextElement_self__, this.getIteratorNext);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getIteratorNextElementNode_AndSpecialize(arg0Value);
            }

            private Object getIteratorNextElementNode_AndSpecialize(JSIteratorWrapper arg0Value) throws StopIterationException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary getIteratorNextElementNode__getIteratorNextElement_self__ = null;
                        getIteratorNextElementNode__getIteratorNextElement_self__ = (((InteropLibrary) this.getParent()));
                        this.getIteratorNext = super.insert(this.getIteratorNext == null ? ((JSInteropGetIteratorNextNode.create())) : this.getIteratorNext);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getIteratorNextElement(JSIteratorWrapper, InteropLibrary, JSInteropGetIteratorNextNode) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.getIteratorNextElement(getIteratorNextElementNode__getIteratorNextElement_self__, this.getIteratorNext);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(JSIteratorWrapper.class)
        private static final class Uncached extends InteropLibrary implements DelegateExport {

            protected Uncached() {
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return (((JSIteratorWrapper) receiver_)).iterator;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate_) {
                return INTEROP_LIBRARY_.getUncached(delegate_);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JSIteratorWrapper) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof JSIteratorWrapper;
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
            public boolean isIterator(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSIteratorWrapper) receiver) .isIterator();
            }

            @TruffleBoundary
            @Override
            public boolean hasIteratorNextElement(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSIteratorWrapper arg0Value = ((JSIteratorWrapper) arg0Value_);
                return arg0Value.hasIteratorNextElement((((InteropLibrary) this.getParent())), (JSInteropGetIteratorNextNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object getIteratorNextElement(Object arg0Value_) throws StopIterationException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSIteratorWrapper arg0Value = ((JSIteratorWrapper) arg0Value_);
                return arg0Value.getIteratorNextElement((((InteropLibrary) this.getParent())), (JSInteropGetIteratorNextNodeGen.getUncached()));
            }

        }
    }
}
