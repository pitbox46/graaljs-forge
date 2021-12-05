// CheckStyle: start generated
package com.oracle.truffle.api.interop;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;

@GeneratedBy(ArrayIterator.class)
final class ArrayIteratorGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(ArrayIterator.class, new InteropLibraryExports());
    }

    private ArrayIteratorGen() {
    }

    @GeneratedBy(ArrayIterator.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private static final Uncached UNCACHED = new Uncached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, ArrayIterator.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof ArrayIterator;
            InteropLibrary uncached = InteropLibraryExports.UNCACHED;
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof ArrayIterator;
            return new Cached(receiver);
        }

        @GeneratedBy(ArrayIterator.class)
        private static final class Cached extends InteropLibrary {

            @Child private InteropLibrary receiverArrayInteropLibrary_;

            protected Cached(Object receiver) {
                ArrayIterator castReceiver = ((ArrayIterator) receiver) ;
                this.receiverArrayInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((castReceiver.array)));
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof ArrayIterator) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof ArrayIterator)) {
                    return false;
                } else if (!this.receiverArrayInteropLibrary_.accepts((((ArrayIterator) receiver).array))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean isIterator(Object receiver) {
                assert receiver instanceof ArrayIterator : "Invalid library usage. Library does not accept given receiver.";
                return (((ArrayIterator) receiver)).isIterator();
            }

            @Override
            public boolean hasIteratorNextElement(Object arg0Value_) throws UnsupportedMessageException {
                assert arg0Value_ instanceof ArrayIterator : "Invalid library usage. Library does not accept given receiver.";
                ArrayIterator arg0Value = ((ArrayIterator) arg0Value_);
                {
                    InteropLibrary hasIteratorNextElementNode__hasIteratorNextElement_arrays__ = this.receiverArrayInteropLibrary_;
                    return arg0Value.hasIteratorNextElement(hasIteratorNextElementNode__hasIteratorNextElement_arrays__);
                }
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MONOMORPHIC;
            }

            @Override
            public Object getIteratorNextElement(Object arg0Value_) throws UnsupportedMessageException, StopIterationException {
                assert arg0Value_ instanceof ArrayIterator : "Invalid library usage. Library does not accept given receiver.";
                ArrayIterator arg0Value = ((ArrayIterator) arg0Value_);
                {
                    InteropLibrary getIteratorNextElementNode__getIteratorNextElement_arrays__ = this.receiverArrayInteropLibrary_;
                    return arg0Value.getIteratorNextElement(getIteratorNextElementNode__getIteratorNextElement_arrays__);
                }
            }

        }
        @GeneratedBy(ArrayIterator.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof ArrayIterator) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof ArrayIterator;
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
                return ((ArrayIterator) receiver) .isIterator();
            }

            @TruffleBoundary
            @Override
            public boolean hasIteratorNextElement(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                ArrayIterator arg0Value = ((ArrayIterator) arg0Value_);
                return arg0Value.hasIteratorNextElement(INTEROP_LIBRARY_.getUncached((arg0Value.array)));
            }

            @TruffleBoundary
            @Override
            public Object getIteratorNextElement(Object arg0Value_) throws UnsupportedMessageException, StopIterationException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                ArrayIterator arg0Value = ((ArrayIterator) arg0Value_);
                return arg0Value.getIteratorNextElement(INTEROP_LIBRARY_.getUncached((arg0Value.array)));
            }

        }
    }
}
