// CheckStyle: start generated
package com.oracle.truffle.js.runtime.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidBufferOffsetException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.interop.JSInteropGetIteratorNode;
import com.oracle.truffle.js.nodes.interop.KeyInfoNode;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.builtins.JSArrayBufferObject.Interop;
import com.oracle.truffle.js.runtime.objects.JSNonProxyObjectGen;
import java.nio.ByteOrder;
import java.util.concurrent.locks.Lock;

@GeneratedBy(Interop.class)
final class InteropGen {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(Interop.class, new InteropLibraryExports());
    }

    private InteropGen() {
    }

    @GeneratedBy(Interop.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, Interop.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof Interop;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof Interop;
            return new Cached(receiver);
        }

        @GeneratedBy(Interop.class)
        private static final class Cached extends JSNonProxyObjectGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @Child private KeyInfoNode keyInfo;
            @Child private JSInteropGetIteratorNode getIterator;
            @CompilationFinal private BranchProfile errorBranch;
            @Child private InteropLibrary interop;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @Override
            public boolean hasBufferElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((Interop) receiver)).hasBufferElements();
            }

            @Override
            public long getBufferSize(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) != 0 /* is-state_0 getBufferSize(Interop, BranchProfile, InteropLibrary) */) {
                    return arg0Value.getBufferSize(this.errorBranch, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getBufferSizeNode_AndSpecialize(arg0Value);
            }

            private long getBufferSizeNode_AndSpecialize(Interop arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getBufferSize(Interop, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getBufferSize(this.errorBranch, this.interop);
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
            public byte readBufferByte(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10) != 0 /* is-state_0 readBufferByte(Interop, long, BranchProfile, InteropLibrary) */) {
                    return arg0Value.readBufferByte(arg1Value, this.errorBranch, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readBufferByteNode_AndSpecialize(arg0Value, arg1Value);
            }

            private byte readBufferByteNode_AndSpecialize(Interop arg0Value, long arg1Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 readBufferByte(Interop, long, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readBufferByte(arg1Value, this.errorBranch, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public short readBufferShort(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100) != 0 /* is-state_0 readBufferShort(Interop, ByteOrder, long, BranchProfile, InteropLibrary) */) {
                    return arg0Value.readBufferShort(arg1Value, arg2Value, this.errorBranch, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readBufferShortNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private short readBufferShortNode_AndSpecialize(Interop arg0Value, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 readBufferShort(Interop, ByteOrder, long, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readBufferShort(arg1Value, arg2Value, this.errorBranch, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public int readBufferInt(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 readBufferInt(Interop, ByteOrder, long, BranchProfile, InteropLibrary) */) {
                    return arg0Value.readBufferInt(arg1Value, arg2Value, this.errorBranch, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readBufferIntNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private int readBufferIntNode_AndSpecialize(Interop arg0Value, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 readBufferInt(Interop, ByteOrder, long, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readBufferInt(arg1Value, arg2Value, this.errorBranch, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public long readBufferLong(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000) != 0 /* is-state_0 readBufferLong(Interop, ByteOrder, long, BranchProfile, InteropLibrary) */) {
                    return arg0Value.readBufferLong(arg1Value, arg2Value, this.errorBranch, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readBufferLongNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private long readBufferLongNode_AndSpecialize(Interop arg0Value, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 readBufferLong(Interop, ByteOrder, long, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readBufferLong(arg1Value, arg2Value, this.errorBranch, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public float readBufferFloat(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 readBufferFloat(Interop, ByteOrder, long, BranchProfile, InteropLibrary) */) {
                    return arg0Value.readBufferFloat(arg1Value, arg2Value, this.errorBranch, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readBufferFloatNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private float readBufferFloatNode_AndSpecialize(Interop arg0Value, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 readBufferFloat(Interop, ByteOrder, long, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readBufferFloat(arg1Value, arg2Value, this.errorBranch, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public double readBufferDouble(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000) != 0 /* is-state_0 readBufferDouble(Interop, ByteOrder, long, BranchProfile, InteropLibrary) */) {
                    return arg0Value.readBufferDouble(arg1Value, arg2Value, this.errorBranch, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readBufferDoubleNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private double readBufferDoubleNode_AndSpecialize(Interop arg0Value, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 readBufferDouble(Interop, ByteOrder, long, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readBufferDouble(arg1Value, arg2Value, this.errorBranch, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isBufferWritable(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000) != 0 /* is-state_0 isBufferWritable(Interop, InteropLibrary) */) {
                    return arg0Value.isBufferWritable(this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isBufferWritableNode_AndSpecialize(arg0Value);
            }

            private boolean isBufferWritableNode_AndSpecialize(Interop arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 isBufferWritable(Interop, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isBufferWritable(this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeBufferByte(Object arg0Value_, long arg1Value, byte arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000) != 0 /* is-state_0 writeBufferByte(Interop, long, byte, BranchProfile, InteropLibrary) */) {
                    arg0Value.writeBufferByte(arg1Value, arg2Value, this.errorBranch, this.interop);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeBufferByteNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeBufferByteNode_AndSpecialize(Interop arg0Value, long arg1Value, byte arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 writeBufferByte(Interop, long, byte, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeBufferByte(arg1Value, arg2Value, this.errorBranch, this.interop);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeBufferShort(Object arg0Value_, ByteOrder arg1Value, long arg2Value, short arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 writeBufferShort(Interop, ByteOrder, long, short, BranchProfile, InteropLibrary) */) {
                    arg0Value.writeBufferShort(arg1Value, arg2Value, arg3Value, this.errorBranch, this.interop);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeBufferShortNode_AndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
                return;
            }

            private void writeBufferShortNode_AndSpecialize(Interop arg0Value, ByteOrder arg1Value, long arg2Value, short arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 writeBufferShort(Interop, ByteOrder, long, short, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeBufferShort(arg1Value, arg2Value, arg3Value, this.errorBranch, this.interop);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeBufferInt(Object arg0Value_, ByteOrder arg1Value, long arg2Value, int arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000000) != 0 /* is-state_0 writeBufferInt(Interop, ByteOrder, long, int, BranchProfile, InteropLibrary) */) {
                    arg0Value.writeBufferInt(arg1Value, arg2Value, arg3Value, this.errorBranch, this.interop);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeBufferIntNode_AndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
                return;
            }

            private void writeBufferIntNode_AndSpecialize(Interop arg0Value, ByteOrder arg1Value, long arg2Value, int arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 writeBufferInt(Interop, ByteOrder, long, int, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeBufferInt(arg1Value, arg2Value, arg3Value, this.errorBranch, this.interop);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeBufferLong(Object arg0Value_, ByteOrder arg1Value, long arg2Value, long arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000000) != 0 /* is-state_0 writeBufferLong(Interop, ByteOrder, long, long, BranchProfile, InteropLibrary) */) {
                    arg0Value.writeBufferLong(arg1Value, arg2Value, arg3Value, this.errorBranch, this.interop);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeBufferLongNode_AndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
                return;
            }

            private void writeBufferLongNode_AndSpecialize(Interop arg0Value, ByteOrder arg1Value, long arg2Value, long arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 writeBufferLong(Interop, ByteOrder, long, long, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeBufferLong(arg1Value, arg2Value, arg3Value, this.errorBranch, this.interop);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeBufferFloat(Object arg0Value_, ByteOrder arg1Value, long arg2Value, float arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000000) != 0 /* is-state_0 writeBufferFloat(Interop, ByteOrder, long, float, BranchProfile, InteropLibrary) */) {
                    arg0Value.writeBufferFloat(arg1Value, arg2Value, arg3Value, this.errorBranch, this.interop);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeBufferFloatNode_AndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
                return;
            }

            private void writeBufferFloatNode_AndSpecialize(Interop arg0Value, ByteOrder arg1Value, long arg2Value, float arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 writeBufferFloat(Interop, ByteOrder, long, float, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeBufferFloat(arg1Value, arg2Value, arg3Value, this.errorBranch, this.interop);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeBufferDouble(Object arg0Value_, ByteOrder arg1Value, long arg2Value, double arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                Interop arg0Value = ((Interop) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000000000) != 0 /* is-state_0 writeBufferDouble(Interop, ByteOrder, long, double, BranchProfile, InteropLibrary) */) {
                    arg0Value.writeBufferDouble(arg1Value, arg2Value, arg3Value, this.errorBranch, this.interop);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeBufferDoubleNode_AndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
                return;
            }

            private void writeBufferDoubleNode_AndSpecialize(Interop arg0Value, ByteOrder arg1Value, long arg2Value, double arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 writeBufferDouble(Interop, ByteOrder, long, double, BranchProfile, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeBufferDouble(arg1Value, arg2Value, arg3Value, this.errorBranch, this.interop);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(Interop.class)
        private static final class Uncached extends JSNonProxyObjectGen.InteropLibraryExports.Uncached {

            protected Uncached(Object receiver) {
                super(receiver);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                return super.accepts(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasBufferElements(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Interop) receiver) .hasBufferElements();
            }

            @TruffleBoundary
            @Override
            public long getBufferSize(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                return arg0Value.getBufferSize((BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public byte readBufferByte(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                return arg0Value.readBufferByte(arg1Value, (BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public short readBufferShort(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                return arg0Value.readBufferShort(arg1Value, arg2Value, (BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public int readBufferInt(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                return arg0Value.readBufferInt(arg1Value, arg2Value, (BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public long readBufferLong(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                return arg0Value.readBufferLong(arg1Value, arg2Value, (BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public float readBufferFloat(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                return arg0Value.readBufferFloat(arg1Value, arg2Value, (BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public double readBufferDouble(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                return arg0Value.readBufferDouble(arg1Value, arg2Value, (BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isBufferWritable(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                return arg0Value.isBufferWritable((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeBufferByte(Object arg0Value_, long arg1Value, byte arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                arg0Value.writeBufferByte(arg1Value, arg2Value, (BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public void writeBufferShort(Object arg0Value_, ByteOrder arg1Value, long arg2Value, short arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                arg0Value.writeBufferShort(arg1Value, arg2Value, arg3Value, (BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public void writeBufferInt(Object arg0Value_, ByteOrder arg1Value, long arg2Value, int arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                arg0Value.writeBufferInt(arg1Value, arg2Value, arg3Value, (BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public void writeBufferLong(Object arg0Value_, ByteOrder arg1Value, long arg2Value, long arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                arg0Value.writeBufferLong(arg1Value, arg2Value, arg3Value, (BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public void writeBufferFloat(Object arg0Value_, ByteOrder arg1Value, long arg2Value, float arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                arg0Value.writeBufferFloat(arg1Value, arg2Value, arg3Value, (BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public void writeBufferDouble(Object arg0Value_, ByteOrder arg1Value, long arg2Value, double arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                Interop arg0Value = ((Interop) arg0Value_);
                arg0Value.writeBufferDouble(arg1Value, arg2Value, arg3Value, (BranchProfile.getUncached()), (INTEROP_LIBRARY_.getUncached()));
                return;
            }

        }
    }
}
