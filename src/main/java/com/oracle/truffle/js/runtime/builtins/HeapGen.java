// CheckStyle: start generated
package com.oracle.truffle.js.runtime.builtins;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidBufferOffsetException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.js.runtime.builtins.JSArrayBufferObject.Heap;
import com.oracle.truffle.js.runtime.objects.JSNonProxyObjectGen;
import java.nio.ByteOrder;

@GeneratedBy(Heap.class)
final class HeapGen {

    static  {
        LibraryExport.register(Heap.class, new InteropLibraryExports());
    }

    private HeapGen() {
    }

    @GeneratedBy(Heap.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, Heap.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof Heap;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof Heap;
            return new Cached(receiver);
        }

        @GeneratedBy(Heap.class)
        private static final class Cached extends JSNonProxyObjectGen.InteropLibraryExports.Cached {

            protected Cached(Object receiver) {
                super(receiver);
            }

            @Override
            public boolean hasBufferElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((Heap) receiver)).hasBufferElements();
            }

            @Override
            public long getBufferSize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((Heap) receiver)).getBufferSize();
            }

            @Override
            public byte readBufferByte(Object receiver, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((Heap) receiver)).readBufferByte(byteOffset);
            }

            @Override
            public short readBufferShort(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((Heap) receiver)).readBufferShort(order, byteOffset);
            }

            @Override
            public int readBufferInt(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((Heap) receiver)).readBufferInt(order, byteOffset);
            }

            @Override
            public long readBufferLong(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((Heap) receiver)).readBufferLong(order, byteOffset);
            }

            @Override
            public float readBufferFloat(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((Heap) receiver)).readBufferFloat(order, byteOffset);
            }

            @Override
            public double readBufferDouble(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((Heap) receiver)).readBufferDouble(order, byteOffset);
            }

            @Override
            public boolean isBufferWritable(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((Heap) receiver)).isBufferWritable();
            }

            @Override
            public void writeBufferByte(Object receiver, long byteOffset, byte arg2) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                (((Heap) receiver)).writeBufferByte(byteOffset, arg2);
                return;
            }

            @Override
            public void writeBufferShort(Object receiver, ByteOrder order, long byteOffset, short arg3) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                (((Heap) receiver)).writeBufferShort(order, byteOffset, arg3);
                return;
            }

            @Override
            public void writeBufferInt(Object receiver, ByteOrder order, long byteOffset, int arg3) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                (((Heap) receiver)).writeBufferInt(order, byteOffset, arg3);
                return;
            }

            @Override
            public void writeBufferLong(Object receiver, ByteOrder order, long byteOffset, long arg3) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                (((Heap) receiver)).writeBufferLong(order, byteOffset, arg3);
                return;
            }

            @Override
            public void writeBufferFloat(Object receiver, ByteOrder order, long byteOffset, float arg3) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                (((Heap) receiver)).writeBufferFloat(order, byteOffset, arg3);
                return;
            }

            @Override
            public void writeBufferDouble(Object receiver, ByteOrder order, long byteOffset, double arg3) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                (((Heap) receiver)).writeBufferDouble(order, byteOffset, arg3);
                return;
            }

        }
        @GeneratedBy(Heap.class)
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
                return ((Heap) receiver) .hasBufferElements();
            }

            @TruffleBoundary
            @Override
            public long getBufferSize(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Heap) receiver) .getBufferSize();
            }

            @TruffleBoundary
            @Override
            public byte readBufferByte(Object receiver, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Heap) receiver) .readBufferByte(byteOffset);
            }

            @TruffleBoundary
            @Override
            public short readBufferShort(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Heap) receiver) .readBufferShort(order, byteOffset);
            }

            @TruffleBoundary
            @Override
            public int readBufferInt(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Heap) receiver) .readBufferInt(order, byteOffset);
            }

            @TruffleBoundary
            @Override
            public long readBufferLong(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Heap) receiver) .readBufferLong(order, byteOffset);
            }

            @TruffleBoundary
            @Override
            public float readBufferFloat(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Heap) receiver) .readBufferFloat(order, byteOffset);
            }

            @TruffleBoundary
            @Override
            public double readBufferDouble(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Heap) receiver) .readBufferDouble(order, byteOffset);
            }

            @TruffleBoundary
            @Override
            public boolean isBufferWritable(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Heap) receiver) .isBufferWritable();
            }

            @TruffleBoundary
            @Override
            public void writeBufferByte(Object receiver, long byteOffset, byte arg2) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                ((Heap) receiver) .writeBufferByte(byteOffset, arg2);
                return;
            }

            @TruffleBoundary
            @Override
            public void writeBufferShort(Object receiver, ByteOrder order, long byteOffset, short arg3) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                ((Heap) receiver) .writeBufferShort(order, byteOffset, arg3);
                return;
            }

            @TruffleBoundary
            @Override
            public void writeBufferInt(Object receiver, ByteOrder order, long byteOffset, int arg3) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                ((Heap) receiver) .writeBufferInt(order, byteOffset, arg3);
                return;
            }

            @TruffleBoundary
            @Override
            public void writeBufferLong(Object receiver, ByteOrder order, long byteOffset, long arg3) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                ((Heap) receiver) .writeBufferLong(order, byteOffset, arg3);
                return;
            }

            @TruffleBoundary
            @Override
            public void writeBufferFloat(Object receiver, ByteOrder order, long byteOffset, float arg3) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                ((Heap) receiver) .writeBufferFloat(order, byteOffset, arg3);
                return;
            }

            @TruffleBoundary
            @Override
            public void writeBufferDouble(Object receiver, ByteOrder order, long byteOffset, double arg3) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                ((Heap) receiver) .writeBufferDouble(order, byteOffset, arg3);
                return;
            }

        }
    }
}
