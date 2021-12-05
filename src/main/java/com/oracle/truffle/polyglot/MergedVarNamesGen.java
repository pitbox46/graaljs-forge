// CheckStyle: start generated
package com.oracle.truffle.polyglot;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.polyglot.LegacyScopesBridge.MergedVarNames;
import java.util.concurrent.locks.Lock;

@GeneratedBy(MergedVarNames.class)
final class MergedVarNamesGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(MergedVarNames.class, new InteropLibraryExports());
    }

    private MergedVarNamesGen() {
    }

    @GeneratedBy(MergedVarNames.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, MergedVarNames.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof MergedVarNames;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof MergedVarNames;
            return new Cached();
        }

        @GeneratedBy(MergedVarNames.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_0_;
            @Child private InteropLibrary interop;

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof MergedVarNames) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof MergedVarNames;
            }

            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((MergedVarNames) receiver)).hasArrayElements();
            }

            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((MergedVarNames) receiver)).getArraySize();
            }

            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                MergedVarNames arg0Value = ((MergedVarNames) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) != 0 /* is-state_0 isArrayElementReadable(MergedVarNames, long, InteropLibrary) */) {
                    return arg0Value.isArrayElementReadable(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementReadableNode_AndSpecialize(MergedVarNames arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(5))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 isArrayElementReadable(MergedVarNames, long, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isArrayElementReadable(arg1Value, this.interop);
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
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                MergedVarNames arg0Value = ((MergedVarNames) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10) != 0 /* is-state_0 readArrayElement(MergedVarNames, long, InteropLibrary) */) {
                    return arg0Value.readArrayElement(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readArrayElementNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readArrayElementNode_AndSpecialize(MergedVarNames arg0Value, long arg1Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(5))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 readArrayElement(MergedVarNames, long, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readArrayElement(arg1Value, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(MergedVarNames.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof MergedVarNames) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof MergedVarNames;
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
            public boolean hasArrayElements(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((MergedVarNames) receiver) .hasArrayElements();
            }

            @TruffleBoundary
            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((MergedVarNames) receiver) .getArraySize();
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                MergedVarNames arg0Value = ((MergedVarNames) arg0Value_);
                return arg0Value.isArrayElementReadable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                MergedVarNames arg0Value = ((MergedVarNames) arg0Value_);
                return arg0Value.readArrayElement(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

        }
    }
}
