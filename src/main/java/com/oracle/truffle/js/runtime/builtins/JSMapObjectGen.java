// CheckStyle: start generated
package com.oracle.truffle.js.runtime.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownKeyException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.builtins.helper.JSCollectionsNormalizeNode;
import com.oracle.truffle.js.builtins.helper.JSCollectionsNormalizeNodeGen;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.nodes.interop.JSInteropGetIteratorNode;
import com.oracle.truffle.js.nodes.interop.KeyInfoNode;
import com.oracle.truffle.js.runtime.objects.JSNonProxyObjectGen;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSMapObject.class)
final class JSMapObjectGen {

    static  {
        LibraryExport.register(JSMapObject.class, new InteropLibraryExports());
    }

    private JSMapObjectGen() {
    }

    @GeneratedBy(JSMapObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, JSMapObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JSMapObject;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JSMapObject;
            return new Cached(receiver);
        }

        @GeneratedBy(JSMapObject.class)
        private static final class Cached extends JSNonProxyObjectGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @Child private KeyInfoNode keyInfo;
            @Child private JSInteropGetIteratorNode getIterator;
            @Child private ImportValueNode importKeyNode;
            @Child private JSCollectionsNormalizeNode normalizeKeyNode;
            @Child private ExportValueNode exportValueNode;
            @Child private ImportValueNode writeHashEntryNode__writeHashEntry_importValueNode_;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @Override
            public boolean hasHashEntries(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSMapObject) receiver)).hasHashEntries();
            }

            @Override
            public long getHashSize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSMapObject) receiver)).getHashSize();
            }

            @Override
            public Object getHashEntriesIterator(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSMapObject) receiver)).getHashEntriesIterator();
            }

            @Override
            public boolean isHashEntryReadable(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) != 0 /* is-state_0 isHashEntryReadable(JSMapObject, Object, ImportValueNode, JSCollectionsNormalizeNode) */) {
                    return arg0Value.isHashEntryReadable(arg1Value, this.importKeyNode, this.normalizeKeyNode);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isHashEntryReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isHashEntryReadableNode_AndSpecialize(JSMapObject arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.importKeyNode = super.insert(this.importKeyNode == null ? ((ImportValueNode.create())) : this.importKeyNode);
                    this.normalizeKeyNode = super.insert(this.normalizeKeyNode == null ? ((JSCollectionsNormalizeNode.create())) : this.normalizeKeyNode);
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 isHashEntryReadable(JSMapObject, Object, ImportValueNode, JSCollectionsNormalizeNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isHashEntryReadable(arg1Value, this.importKeyNode, this.normalizeKeyNode);
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
            public Object readHashValue(Object arg0Value_, Object arg1Value) throws UnsupportedMessageException, UnknownKeyException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10) != 0 /* is-state_0 readHashValue(JSMapObject, Object, ExportValueNode, ImportValueNode, JSCollectionsNormalizeNode) */) {
                    return arg0Value.readHashValue(arg1Value, this.exportValueNode, this.importKeyNode, this.normalizeKeyNode);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readHashValueNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readHashValueNode_AndSpecialize(JSMapObject arg0Value, Object arg1Value) throws UnknownKeyException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.exportValueNode = super.insert(this.exportValueNode == null ? ((ExportValueNode.create())) : this.exportValueNode);
                    this.importKeyNode = super.insert(this.importKeyNode == null ? ((ImportValueNode.create())) : this.importKeyNode);
                    this.normalizeKeyNode = super.insert(this.normalizeKeyNode == null ? ((JSCollectionsNormalizeNode.create())) : this.normalizeKeyNode);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 readHashValue(JSMapObject, Object, ExportValueNode, ImportValueNode, JSCollectionsNormalizeNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readHashValue(arg1Value, this.exportValueNode, this.importKeyNode, this.normalizeKeyNode);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object readHashValueOrDefault(Object arg0Value_, Object arg1Value, Object arg2Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100) != 0 /* is-state_0 readHashValueOrDefault(JSMapObject, Object, Object, ExportValueNode, ImportValueNode, JSCollectionsNormalizeNode) */) {
                    return arg0Value.readHashValueOrDefault(arg1Value, arg2Value, this.exportValueNode, this.importKeyNode, this.normalizeKeyNode);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readHashValueOrDefaultNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object readHashValueOrDefaultNode_AndSpecialize(JSMapObject arg0Value, Object arg1Value, Object arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.exportValueNode = super.insert(this.exportValueNode == null ? ((ExportValueNode.create())) : this.exportValueNode);
                    this.importKeyNode = super.insert(this.importKeyNode == null ? ((ImportValueNode.create())) : this.importKeyNode);
                    this.normalizeKeyNode = super.insert(this.normalizeKeyNode == null ? ((JSCollectionsNormalizeNode.create())) : this.normalizeKeyNode);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 readHashValueOrDefault(JSMapObject, Object, Object, ExportValueNode, ImportValueNode, JSCollectionsNormalizeNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readHashValueOrDefault(arg1Value, arg2Value, this.exportValueNode, this.importKeyNode, this.normalizeKeyNode);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isHashEntryModifiable(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 isHashEntryModifiable(JSMapObject, Object, ImportValueNode, JSCollectionsNormalizeNode) */) {
                    return arg0Value.isHashEntryModifiable(arg1Value, this.importKeyNode, this.normalizeKeyNode);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isHashEntryModifiableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isHashEntryModifiableNode_AndSpecialize(JSMapObject arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.importKeyNode = super.insert(this.importKeyNode == null ? ((ImportValueNode.create())) : this.importKeyNode);
                    this.normalizeKeyNode = super.insert(this.normalizeKeyNode == null ? ((JSCollectionsNormalizeNode.create())) : this.normalizeKeyNode);
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 isHashEntryModifiable(JSMapObject, Object, ImportValueNode, JSCollectionsNormalizeNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isHashEntryModifiable(arg1Value, this.importKeyNode, this.normalizeKeyNode);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isHashEntryRemovable(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 isHashEntryModifiable(JSMapObject, Object, ImportValueNode, JSCollectionsNormalizeNode) */) {
                    return arg0Value.isHashEntryModifiable(arg1Value, this.importKeyNode, this.normalizeKeyNode);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isHashEntryModifiableNode_AndSpecialize(arg0Value, arg1Value);
            }

            @Override
            public boolean isHashEntryInsertable(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                {
                    InteropLibrary isHashEntryInsertableNode__isHashEntryInsertable_thisLibrary__ = (this);
                    return arg0Value.isHashEntryInsertable(arg1Value, isHashEntryInsertableNode__isHashEntryInsertable_thisLibrary__);
                }
            }

            @Override
            public void writeHashEntry(Object arg0Value_, Object arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownKeyException, UnsupportedTypeException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000) != 0 /* is-state_0 writeHashEntry(JSMapObject, Object, Object, ImportValueNode, ImportValueNode, JSCollectionsNormalizeNode) */) {
                    arg0Value.writeHashEntry(arg1Value, arg2Value, this.importKeyNode, this.writeHashEntryNode__writeHashEntry_importValueNode_, this.normalizeKeyNode);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeHashEntryNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeHashEntryNode_AndSpecialize(JSMapObject arg0Value, Object arg1Value, Object arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.importKeyNode = super.insert(this.importKeyNode == null ? ((ImportValueNode.create())) : this.importKeyNode);
                    this.writeHashEntryNode__writeHashEntry_importValueNode_ = super.insert((ImportValueNode.create()));
                    this.normalizeKeyNode = super.insert(this.normalizeKeyNode == null ? ((JSCollectionsNormalizeNode.create())) : this.normalizeKeyNode);
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 writeHashEntry(JSMapObject, Object, Object, ImportValueNode, ImportValueNode, JSCollectionsNormalizeNode) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeHashEntry(arg1Value, arg2Value, this.importKeyNode, this.writeHashEntryNode__writeHashEntry_importValueNode_, this.normalizeKeyNode);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void removeHashEntry(Object arg0Value_, Object arg1Value) throws UnsupportedMessageException, UnknownKeyException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 removeHashEntry(JSMapObject, Object, ImportValueNode, JSCollectionsNormalizeNode) */) {
                    arg0Value.removeHashEntry(arg1Value, this.importKeyNode, this.normalizeKeyNode);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                removeHashEntryNode_AndSpecialize(arg0Value, arg1Value);
                return;
            }

            private void removeHashEntryNode_AndSpecialize(JSMapObject arg0Value, Object arg1Value) throws UnknownKeyException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.importKeyNode = super.insert(this.importKeyNode == null ? ((ImportValueNode.create())) : this.importKeyNode);
                    this.normalizeKeyNode = super.insert(this.normalizeKeyNode == null ? ((JSCollectionsNormalizeNode.create())) : this.normalizeKeyNode);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 removeHashEntry(JSMapObject, Object, ImportValueNode, JSCollectionsNormalizeNode) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.removeHashEntry(arg1Value, this.importKeyNode, this.normalizeKeyNode);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(JSMapObject.class)
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
            public boolean hasHashEntries(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSMapObject) receiver) .hasHashEntries();
            }

            @TruffleBoundary
            @Override
            public long getHashSize(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSMapObject) receiver) .getHashSize();
            }

            @TruffleBoundary
            @Override
            public Object getHashEntriesIterator(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSMapObject) receiver) .getHashEntriesIterator();
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryReadable(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                return arg0Value.isHashEntryReadable(arg1Value, (ImportValueNode.getUncached()), (JSCollectionsNormalizeNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object readHashValue(Object arg0Value_, Object arg1Value) throws UnknownKeyException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                return arg0Value.readHashValue(arg1Value, (ExportValueNode.getUncached()), (ImportValueNode.getUncached()), (JSCollectionsNormalizeNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object readHashValueOrDefault(Object arg0Value_, Object arg1Value, Object arg2Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                return arg0Value.readHashValueOrDefault(arg1Value, arg2Value, (ExportValueNode.getUncached()), (ImportValueNode.getUncached()), (JSCollectionsNormalizeNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryModifiable(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                return arg0Value.isHashEntryModifiable(arg1Value, (ImportValueNode.getUncached()), (JSCollectionsNormalizeNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryRemovable(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                return arg0Value.isHashEntryModifiable(arg1Value, (ImportValueNode.getUncached()), (JSCollectionsNormalizeNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryInsertable(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                return arg0Value.isHashEntryInsertable(arg1Value, (this));
            }

            @TruffleBoundary
            @Override
            public void writeHashEntry(Object arg0Value_, Object arg1Value, Object arg2Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                arg0Value.writeHashEntry(arg1Value, arg2Value, (ImportValueNode.getUncached()), (ImportValueNode.getUncached()), (JSCollectionsNormalizeNodeGen.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public void removeHashEntry(Object arg0Value_, Object arg1Value) throws UnknownKeyException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSMapObject arg0Value = ((JSMapObject) arg0Value_);
                arg0Value.removeHashEntry(arg1Value, (ImportValueNode.getUncached()), (JSCollectionsNormalizeNodeGen.getUncached()));
                return;
            }

        }
    }
}
