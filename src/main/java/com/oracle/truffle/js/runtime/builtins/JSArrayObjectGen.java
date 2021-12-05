// CheckStyle: start generated
package com.oracle.truffle.js.runtime.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.nodes.access.WriteElementNode;
import com.oracle.truffle.js.nodes.interop.ArrayElementInfoNode;
import com.oracle.truffle.js.nodes.interop.ArrayElementInfoNodeGen;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.nodes.interop.JSInteropGetIteratorNode;
import com.oracle.truffle.js.nodes.interop.KeyInfoNode;
import com.oracle.truffle.js.runtime.builtins.JSArrayObject.GetMembers;
import com.oracle.truffle.js.runtime.objects.JSNonProxyObjectGen;
import com.oracle.truffle.js.runtime.objects.JSObject;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSArrayObject.class)
final class JSArrayObjectGen {

    static  {
        LibraryExport.register(JSArrayObject.class, new InteropLibraryExports());
    }

    private JSArrayObjectGen() {
    }

    @GeneratedBy(JSArrayObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, JSArrayObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JSArrayObject;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JSArrayObject;
            return new Cached(receiver);
        }

        @GeneratedBy(JSArrayObject.class)
        private static final class Cached extends JSNonProxyObjectGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @Child private KeyInfoNode keyInfo;
            @Child private JSInteropGetIteratorNode getIterator;
            @Child private ArrayElementInfoNode elementInfo;
            @Child private ReadElementNode readArrayElementNode__readArrayElement_readNode_;
            @Child private ExportValueNode readArrayElementNode__readArrayElement_exportNode_;
            @Child private ImportValueNode writeArrayElementNode__writeArrayElement_castValueNode_;
            @Child private WriteElementNode writeArrayElementNode__writeArrayElement_writeNode_;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) != 0 /* is-state_0 fastArray(JSArrayObject, boolean) || slowArray(JSArrayObject, boolean) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 fastArray(JSArrayObject, boolean) */) {
                        if ((JSGuards.isJSFastArray(arg0Value))) {
                            return GetMembers.fastArray(arg0Value, arg1Value);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 slowArray(JSArrayObject, boolean) */) {
                        if ((!(JSGuards.isJSFastArray(arg0Value)))) {
                            return GetMembers.slowArray(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getMembersAndSpecialize(arg0Value, arg1Value);
            }

            private Object getMembersAndSpecialize(JSArrayObject arg0Value, boolean arg1Value) {
                int state_0 = this.state_0_;
                if ((JSGuards.isJSFastArray(arg0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 fastArray(JSArrayObject, boolean) */;
                    return GetMembers.fastArray(arg0Value, arg1Value);
                }
                if ((!(JSGuards.isJSFastArray(arg0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 slowArray(JSArrayObject, boolean) */;
                    return GetMembers.slowArray(arg0Value, arg1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @Override
            public NodeCost getCost() {
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    if (((state_0 & 0b11) & ((state_0 & 0b11) - 1)) == 0 /* is-single-state_0  */) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSArrayObject) receiver)).hasArrayElements();
            }

            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSArrayObject) receiver)).getArraySize();
            }

            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100) != 0 /* is-state_0 readArrayElement(JSArrayObject, long, InteropLibrary, ReadElementNode, ExportValueNode) */) {
                    {
                        InteropLibrary readArrayElementNode__readArrayElement_self__ = (this);
                        return arg0Value.readArrayElement(arg1Value, readArrayElementNode__readArrayElement_self__, this.readArrayElementNode__readArrayElement_readNode_, this.readArrayElementNode__readArrayElement_exportNode_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readArrayElementNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readArrayElementNode_AndSpecialize(JSArrayObject arg0Value, long arg1Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary readArrayElementNode__readArrayElement_self__ = null;
                        readArrayElementNode__readArrayElement_self__ = (this);
                        this.readArrayElementNode__readArrayElement_readNode_ = super.insert((ReadElementNode.create(JSObject.language(readArrayElementNode__readArrayElement_self__).getJSContext())));
                        this.readArrayElementNode__readArrayElement_exportNode_ = super.insert((ExportValueNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 readArrayElement(JSArrayObject, long, InteropLibrary, ReadElementNode, ExportValueNode) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.readArrayElement(arg1Value, readArrayElementNode__readArrayElement_self__, this.readArrayElementNode__readArrayElement_readNode_, this.readArrayElementNode__readArrayElement_exportNode_);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                {
                    InteropLibrary isArrayElementReadableNode__isArrayElementReadable_thisLibrary__ = (this);
                    return arg0Value.isArrayElementReadable(arg1Value, isArrayElementReadableNode__isArrayElementReadable_thisLibrary__);
                }
            }

            @Override
            public void writeArrayElement(Object arg0Value_, long arg1Value, Object arg2Value) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 writeArrayElement(JSArrayObject, long, Object, ArrayElementInfoNode, ImportValueNode, WriteElementNode) */) {
                    arg0Value.writeArrayElement(arg1Value, arg2Value, this.elementInfo, this.writeArrayElementNode__writeArrayElement_castValueNode_, this.writeArrayElementNode__writeArrayElement_writeNode_);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeArrayElementNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeArrayElementNode_AndSpecialize(JSArrayObject arg0Value, long arg1Value, Object arg2Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.elementInfo = super.insert(this.elementInfo == null ? ((ArrayElementInfoNodeGen.create())) : this.elementInfo);
                    this.writeArrayElementNode__writeArrayElement_castValueNode_ = super.insert((ImportValueNode.create()));
                    this.writeArrayElementNode__writeArrayElement_writeNode_ = super.insert((WriteElementNode.createCachedInterop()));
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 writeArrayElement(JSArrayObject, long, Object, ArrayElementInfoNode, ImportValueNode, WriteElementNode) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeArrayElement(arg1Value, arg2Value, this.elementInfo, this.writeArrayElementNode__writeArrayElement_castValueNode_, this.writeArrayElementNode__writeArrayElement_writeNode_);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementModifiable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000) != 0 /* is-state_0 isArrayElementModifiable(JSArrayObject, long, ArrayElementInfoNode) */) {
                    return arg0Value.isArrayElementModifiable(arg1Value, this.elementInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementModifiableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementModifiableNode_AndSpecialize(JSArrayObject arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.elementInfo = super.insert(this.elementInfo == null ? ((ArrayElementInfoNodeGen.create())) : this.elementInfo);
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 isArrayElementModifiable(JSArrayObject, long, ArrayElementInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isArrayElementModifiable(arg1Value, this.elementInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementInsertable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 isArrayElementInsertable(JSArrayObject, long, ArrayElementInfoNode) */) {
                    return arg0Value.isArrayElementInsertable(arg1Value, this.elementInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementInsertableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementInsertableNode_AndSpecialize(JSArrayObject arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.elementInfo = super.insert(this.elementInfo == null ? ((ArrayElementInfoNodeGen.create())) : this.elementInfo);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 isArrayElementInsertable(JSArrayObject, long, ArrayElementInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isArrayElementInsertable(arg1Value, this.elementInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementRemovable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000) != 0 /* is-state_0 isArrayElementRemovable(JSArrayObject, long, ArrayElementInfoNode) */) {
                    return arg0Value.isArrayElementRemovable(arg1Value, this.elementInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementRemovableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementRemovableNode_AndSpecialize(JSArrayObject arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.elementInfo = super.insert(this.elementInfo == null ? ((ArrayElementInfoNodeGen.create())) : this.elementInfo);
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 isArrayElementRemovable(JSArrayObject, long, ArrayElementInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isArrayElementRemovable(arg1Value, this.elementInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void removeArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000) != 0 /* is-state_0 removeArrayElement(JSArrayObject, long, ArrayElementInfoNode) */) {
                    arg0Value.removeArrayElement(arg1Value, this.elementInfo);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                removeArrayElementNode_AndSpecialize(arg0Value, arg1Value);
                return;
            }

            private void removeArrayElementNode_AndSpecialize(JSArrayObject arg0Value, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.elementInfo = super.insert(this.elementInfo == null ? ((ArrayElementInfoNodeGen.create())) : this.elementInfo);
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 removeArrayElement(JSArrayObject, long, ArrayElementInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.removeArrayElement(arg1Value, this.elementInfo);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(JSArrayObject.class)
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
            public Object getMembers(Object arg0Value_, boolean arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                if ((JSGuards.isJSFastArray(arg0Value))) {
                    return GetMembers.fastArray(arg0Value, arg1Value);
                }
                if ((!(JSGuards.isJSFastArray(arg0Value)))) {
                    return GetMembers.slowArray(arg0Value, arg1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean hasArrayElements(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSArrayObject) receiver) .hasArrayElements();
            }

            @TruffleBoundary
            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSArrayObject) receiver) .getArraySize();
            }

            @TruffleBoundary
            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                return arg0Value.readArrayElement(arg1Value, (this), (JSObject.getUncachedRead()), (ExportValueNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                return arg0Value.isArrayElementReadable(arg1Value, (this));
            }

            @TruffleBoundary
            @Override
            public void writeArrayElement(Object arg0Value_, long arg1Value, Object arg2Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                arg0Value.writeArrayElement(arg1Value, arg2Value, (ArrayElementInfoNodeGen.getUncached()), (ImportValueNode.getUncached()), (JSObject.getUncachedWrite()));
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementModifiable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                return arg0Value.isArrayElementModifiable(arg1Value, (ArrayElementInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementInsertable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                return arg0Value.isArrayElementInsertable(arg1Value, (ArrayElementInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementRemovable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                return arg0Value.isArrayElementRemovable(arg1Value, (ArrayElementInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void removeArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSArrayObject arg0Value = ((JSArrayObject) arg0Value_);
                arg0Value.removeArrayElement(arg1Value, (ArrayElementInfoNodeGen.getUncached()));
                return;
            }

        }
    }
}
