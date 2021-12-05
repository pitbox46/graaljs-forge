// CheckStyle: start generated
package com.oracle.truffle.host;

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
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.host.HostObject.KeysArray;
import java.util.concurrent.locks.Lock;

@GeneratedBy(KeysArray.class)
final class KeysArrayGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(KeysArray.class, new InteropLibraryExports());
    }

    private KeysArrayGen() {
    }

    @GeneratedBy(KeysArray.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, KeysArray.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof KeysArray;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof KeysArray;
            return new Cached();
        }

        @GeneratedBy(KeysArray.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private BranchProfile error_;

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof KeysArray) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof KeysArray;
            }

            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((KeysArray) receiver)).hasArrayElements();
            }

            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((KeysArray) receiver)).getArraySize();
            }

            @Override
            public boolean isArrayElementReadable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((KeysArray) receiver)).isArrayElementReadable(index);
            }

            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                KeysArray arg0Value = ((KeysArray) arg0Value_);
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 readArrayElement(KeysArray, long, BranchProfile) */) {
                    return arg0Value.readArrayElement(arg1Value, this.error_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value);
            }

            private String executeAndSpecialize(KeysArray arg0Value, long arg1Value) throws InvalidArrayIndexException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.error_ = (BranchProfile.create());
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 readArrayElement(KeysArray, long, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readArrayElement(arg1Value, this.error_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public NodeCost getCost() {
                int state_0 = this.state_0_;
                if (state_0 == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    return NodeCost.MONOMORPHIC;
                }
            }

        }
        @GeneratedBy(KeysArray.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof KeysArray) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof KeysArray;
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
                return ((KeysArray) receiver) .hasArrayElements();
            }

            @TruffleBoundary
            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((KeysArray) receiver) .getArraySize();
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementReadable(Object receiver, long index) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((KeysArray) receiver) .isArrayElementReadable(index);
            }

            @TruffleBoundary
            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws InvalidArrayIndexException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                KeysArray arg0Value = ((KeysArray) arg0Value_);
                return arg0Value.readArrayElement(arg1Value, (BranchProfile.getUncached()));
            }

        }
    }
}
