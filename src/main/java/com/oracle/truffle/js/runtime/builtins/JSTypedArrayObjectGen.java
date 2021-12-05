// CheckStyle: start generated
package com.oracle.truffle.js.runtime.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.nodes.access.WriteElementNode;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.nodes.interop.JSInteropGetIteratorNode;
import com.oracle.truffle.js.nodes.interop.KeyInfoNode;
import com.oracle.truffle.js.runtime.objects.JSNonProxyObjectGen;
import com.oracle.truffle.js.runtime.objects.JSObject;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSTypedArrayObject.class)
final class JSTypedArrayObjectGen {

    static  {
        LibraryExport.register(JSTypedArrayObject.class, new InteropLibraryExports());
    }

    private JSTypedArrayObjectGen() {
    }

    @GeneratedBy(JSTypedArrayObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, JSTypedArrayObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JSTypedArrayObject;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JSTypedArrayObject;
            return new Cached(receiver);
        }

        @GeneratedBy(JSTypedArrayObject.class)
        private static final class Cached extends JSNonProxyObjectGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @Child private KeyInfoNode keyInfo;
            @Child private JSInteropGetIteratorNode getIterator;
            @Child private ReadElementNode readArrayElementNode__readArrayElement_readNode_;
            @Child private ExportValueNode readArrayElementNode__readArrayElement_exportNode_;
            @Child private ImportValueNode writeArrayElementNode__writeArrayElement_castValueNode_;
            @Child private WriteElementNode writeArrayElementNode__writeArrayElement_writeNode_;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).getMembers(includeInternal);
            }

            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).hasArrayElements();
            }

            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).getArraySize();
            }

            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) != 0 /* is-state_0 readArrayElement(JSTypedArrayObject, long, InteropLibrary, ReadElementNode, ExportValueNode) */) {
                    {
                        InteropLibrary readArrayElementNode__readArrayElement_self__ = (this);
                        return arg0Value.readArrayElement(arg1Value, readArrayElementNode__readArrayElement_self__, this.readArrayElementNode__readArrayElement_readNode_, this.readArrayElementNode__readArrayElement_exportNode_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readArrayElementNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readArrayElementNode_AndSpecialize(JSTypedArrayObject arg0Value, long arg1Value) throws InvalidArrayIndexException, UnsupportedMessageException {
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
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 readArrayElement(JSTypedArrayObject, long, InteropLibrary, ReadElementNode, ExportValueNode) */;
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
            public NodeCost getCost() {
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    return NodeCost.MONOMORPHIC;
                }
            }

            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                {
                    InteropLibrary isArrayElementReadableNode__isArrayElementReadable_thisLibrary__ = (this);
                    return arg0Value.isArrayElementReadable(arg1Value, isArrayElementReadableNode__isArrayElementReadable_thisLibrary__);
                }
            }

            @Override
            public boolean isArrayElementModifiable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                {
                    InteropLibrary isArrayElementReadableNode__isArrayElementReadable_thisLibrary__ = (this);
                    return arg0Value.isArrayElementReadable(arg1Value, isArrayElementReadableNode__isArrayElementReadable_thisLibrary__);
                }
            }

            @Override
            public void writeArrayElement(Object arg0Value_, long arg1Value, Object arg2Value) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10) != 0 /* is-state_0 writeArrayElement(JSTypedArrayObject, long, Object, ImportValueNode, WriteElementNode, InteropLibrary) */) {
                    {
                        InteropLibrary writeArrayElementNode__writeArrayElement_thisLibrary__ = (this);
                        arg0Value.writeArrayElement(arg1Value, arg2Value, this.writeArrayElementNode__writeArrayElement_castValueNode_, this.writeArrayElementNode__writeArrayElement_writeNode_, writeArrayElementNode__writeArrayElement_thisLibrary__);
                        return;
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeArrayElementNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeArrayElementNode_AndSpecialize(JSTypedArrayObject arg0Value, long arg1Value, Object arg2Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary writeArrayElementNode__writeArrayElement_thisLibrary__ = null;
                        this.writeArrayElementNode__writeArrayElement_castValueNode_ = super.insert((ImportValueNode.create()));
                        this.writeArrayElementNode__writeArrayElement_writeNode_ = super.insert((WriteElementNode.createCachedInterop()));
                        writeArrayElementNode__writeArrayElement_thisLibrary__ = (this);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 writeArrayElement(JSTypedArrayObject, long, Object, ImportValueNode, WriteElementNode, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        arg0Value.writeArrayElement(arg1Value, arg2Value, this.writeArrayElementNode__writeArrayElement_castValueNode_, this.writeArrayElementNode__writeArrayElement_writeNode_, writeArrayElementNode__writeArrayElement_thisLibrary__);
                        return;
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementInsertable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).isArrayElementInsertable(index);
            }

        }
        @GeneratedBy(JSTypedArrayObject.class)
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
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSTypedArrayObject) receiver) .getMembers(includeInternal);
            }

            @TruffleBoundary
            @Override
            public boolean hasArrayElements(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSTypedArrayObject) receiver) .hasArrayElements();
            }

            @TruffleBoundary
            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSTypedArrayObject) receiver) .getArraySize();
            }

            @TruffleBoundary
            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                return arg0Value.readArrayElement(arg1Value, (this), (JSObject.getUncachedRead()), (ExportValueNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                return arg0Value.isArrayElementReadable(arg1Value, (this));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementModifiable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                return arg0Value.isArrayElementReadable(arg1Value, (this));
            }

            @TruffleBoundary
            @Override
            public void writeArrayElement(Object arg0Value_, long arg1Value, Object arg2Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                arg0Value.writeArrayElement(arg1Value, arg2Value, (ImportValueNode.getUncached()), (JSObject.getUncachedWrite()), (this));
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementInsertable(Object receiver, long index) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSTypedArrayObject) receiver) .isArrayElementInsertable(index);
            }

        }
    }
}
