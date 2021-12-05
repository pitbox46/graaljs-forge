// CheckStyle: start generated
package com.oracle.truffle.js.runtime.interop;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.StopIterationException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;

@GeneratedBy(InteropMemberIterator.class)
final class InteropMemberIteratorGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(InteropMemberIterator.class, new InteropLibraryExports());
    }

    private InteropMemberIteratorGen() {
    }

    @GeneratedBy(InteropMemberIterator.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private static final Uncached UNCACHED = new Uncached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, InteropMemberIterator.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof InteropMemberIterator;
            InteropLibrary uncached = InteropLibraryExports.UNCACHED;
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof InteropMemberIterator;
            return new Cached(receiver);
        }

        @GeneratedBy(InteropMemberIterator.class)
        private static final class Cached extends InteropLibrary {

            @Child private InteropLibrary receiverIteratedObjectInteropLibrary_;
            @Child private InteropLibrary receiverKeysObjectInteropLibrary_;

            protected Cached(Object receiver) {
                InteropMemberIterator castReceiver = ((InteropMemberIterator) receiver) ;
                this.receiverIteratedObjectInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((castReceiver.iteratedObject)));
                this.receiverKeysObjectInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((castReceiver.keysObject)));
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof InteropMemberIterator) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof InteropMemberIterator)) {
                    return false;
                } else if (!this.receiverIteratedObjectInteropLibrary_.accepts((((InteropMemberIterator) receiver).iteratedObject))) {
                    return false;
                } else if (!this.receiverKeysObjectInteropLibrary_.accepts((((InteropMemberIterator) receiver).keysObject))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean isIterator(Object receiver) {
                assert receiver instanceof InteropMemberIterator : "Invalid library usage. Library does not accept given receiver.";
                return (((InteropMemberIterator) receiver)).isIterator();
            }

            @Override
            public boolean hasIteratorNextElement(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof InteropMemberIterator : "Invalid library usage. Library does not accept given receiver.";
                return (((InteropMemberIterator) receiver)).hasIteratorNextElement();
            }

            @Override
            public Object getIteratorNextElement(Object arg0Value_) throws UnsupportedMessageException, StopIterationException {
                assert arg0Value_ instanceof InteropMemberIterator : "Invalid library usage. Library does not accept given receiver.";
                InteropMemberIterator arg0Value = ((InteropMemberIterator) arg0Value_);
                {
                    InteropLibrary objInterop__ = this.receiverIteratedObjectInteropLibrary_;
                    InteropLibrary keysInterop__ = this.receiverKeysObjectInteropLibrary_;
                    return arg0Value.getIteratorNextElement(objInterop__, keysInterop__);
                }
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MONOMORPHIC;
            }

        }
        @GeneratedBy(InteropMemberIterator.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof InteropMemberIterator) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof InteropMemberIterator;
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
                return ((InteropMemberIterator) receiver) .isIterator();
            }

            @TruffleBoundary
            @Override
            public boolean hasIteratorNextElement(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InteropMemberIterator) receiver) .hasIteratorNextElement();
            }

            @TruffleBoundary
            @Override
            public Object getIteratorNextElement(Object arg0Value_) throws StopIterationException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                InteropMemberIterator arg0Value = ((InteropMemberIterator) arg0Value_);
                return arg0Value.getIteratorNextElement(INTEROP_LIBRARY_.getUncached((arg0Value.iteratedObject)), INTEROP_LIBRARY_.getUncached((arg0Value.keysObject)));
            }

        }
    }
}
