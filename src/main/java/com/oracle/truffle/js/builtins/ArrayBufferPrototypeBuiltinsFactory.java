// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.ArrayBufferPrototypeBuiltins.ByteLengthGetterNode;
import com.oracle.truffle.js.builtins.ArrayBufferPrototypeBuiltins.JSArrayBufferSliceNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSArrayBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ArrayBufferPrototypeBuiltins.class)
@SuppressWarnings("unused")
public final class ArrayBufferPrototypeBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(ByteLengthGetterNode.class)
    public static final class ByteLengthGetterNodeGen extends ByteLengthGetterNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary interopArrayBuffer_interop_;

        private ByteLengthGetterNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 heapArrayBuffer(Object) || directArrayBuffer(Object) || interopArrayBuffer(Object, InteropLibrary) || error(Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 heapArrayBuffer(Object) */) {
                    if ((JSArrayBuffer.isJSHeapArrayBuffer(arguments0Value_))) {
                        return heapArrayBuffer(arguments0Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 directArrayBuffer(Object) */) {
                    if ((JSArrayBuffer.isJSDirectArrayBuffer(arguments0Value_))) {
                        return directArrayBuffer(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 interopArrayBuffer(Object, InteropLibrary) */) {
                    if ((JSArrayBuffer.isJSInteropArrayBuffer(arguments0Value_))) {
                        return interopArrayBuffer(arguments0Value_, this.interopArrayBuffer_interop_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 error(Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_)) {
                        return ByteLengthGetterNode.error(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 heapArrayBuffer(Object) || directArrayBuffer(Object) || interopArrayBuffer(Object, InteropLibrary) || error(Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 heapArrayBuffer(Object) */) {
                    if ((JSArrayBuffer.isJSHeapArrayBuffer(arguments0Value_))) {
                        return heapArrayBuffer(arguments0Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 directArrayBuffer(Object) */) {
                    if ((JSArrayBuffer.isJSDirectArrayBuffer(arguments0Value_))) {
                        return directArrayBuffer(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 interopArrayBuffer(Object, InteropLibrary) */) {
                    if ((JSArrayBuffer.isJSInteropArrayBuffer(arguments0Value_))) {
                        return interopArrayBuffer(arguments0Value_, this.interopArrayBuffer_interop_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 error(Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_)) {
                        return ByteLengthGetterNode.error(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeInt(frameValue);
            return;
        }

        private int executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if ((JSArrayBuffer.isJSHeapArrayBuffer(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 heapArrayBuffer(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return heapArrayBuffer(arguments0Value);
                }
                if ((JSArrayBuffer.isJSDirectArrayBuffer(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 directArrayBuffer(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return directArrayBuffer(arguments0Value);
                }
                if ((JSArrayBuffer.isJSInteropArrayBuffer(arguments0Value))) {
                    this.interopArrayBuffer_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 interopArrayBuffer(Object, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return interopArrayBuffer(arguments0Value, this.interopArrayBuffer_interop_);
                }
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 error(Object) */;
                lock.unlock();
                hasLock = false;
                return ByteLengthGetterNode.error(arguments0Value);
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
                if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "heapArrayBuffer";
            if ((state_0 & 0b1) != 0 /* is-state_0 heapArrayBuffer(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "directArrayBuffer";
            if ((state_0 & 0b10) != 0 /* is-state_0 directArrayBuffer(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "interopArrayBuffer";
            if ((state_0 & 0b100) != 0 /* is-state_0 interopArrayBuffer(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.interopArrayBuffer_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "error";
            if ((state_0 & 0b1000) != 0 /* is-state_0 error(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value) {
            if (((state_0 & 0b1)) == 0 /* is-not-state_0 heapArrayBuffer(Object) */ && (JSArrayBuffer.isJSHeapArrayBuffer(arguments0Value))) {
                return false;
            }
            if (((state_0 & 0b10)) == 0 /* is-not-state_0 directArrayBuffer(Object) */ && (JSArrayBuffer.isJSDirectArrayBuffer(arguments0Value))) {
                return false;
            }
            if (((state_0 & 0b100)) == 0 /* is-not-state_0 interopArrayBuffer(Object, InteropLibrary) */ && (JSArrayBuffer.isJSInteropArrayBuffer(arguments0Value))) {
                return false;
            }
            return true;
        }

        public static ByteLengthGetterNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ByteLengthGetterNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayBufferSliceNode.class)
    public static final class JSArrayBufferSliceNodeGen extends JSArrayBufferSliceNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private InteropLibrary srcBufferLib;
        @Child private InteropLibrary dstBufferLib;

        private JSArrayBufferSliceNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        private boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSArrayBuffer.isJSHeapArrayBuffer(arguments0Value_))) {
                        return false;
                    }
                }
                {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSArrayBuffer.isJSDirectArrayBuffer(arguments0Value_))) {
                        return false;
                    }
                }
                {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSArrayBuffer.isJSInteropArrayBuffer(arguments0Value_))) {
                        return false;
                    }
                }
            }
            if (((state_0 & 0b100000)) == 0 /* is-not-state_0 sliceTruffleBuffer(Object, Object, Object, InteropLibrary, InteropLibrary) */ && (!(JSGuards.isJSSharedArrayBuffer(arguments0Value))) && (((state_0 & 0b1000000)) == 0 /* is-not-state_0 Guard[(JSArrayBufferSliceNode.hasBufferElements(thisObj, srcBufferLib))] */ || (JSArrayBufferSliceNode.hasBufferElements(arguments0Value, this.srcBufferLib)))) {
                return false;
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b10111010) == 0 /* only-active sliceIntInt(DynamicObject, int, int) && sliceDirectIntInt(DynamicObject, int, int) */ && ((state_0 & 0b10111111) != 0  /* is-not sliceIntInt(DynamicObject, int, int) && slice(DynamicObject, Object, Object) && sliceDirectIntInt(DynamicObject, int, int) && sliceDirect(DynamicObject, Object, Object) && sliceInterop(DynamicObject, Object, Object, InteropLibrary, InteropLibrary) && sliceTruffleBuffer(Object, Object, Object, InteropLibrary, InteropLibrary) && error(Object, Object, Object) */)) {
                return execute_int_int0(state_0, frameValue);
            } else {
                return execute_generic1(state_0, frameValue);
            }
        }

        private Object execute_int_int0(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value);
            }
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            if ((state_0 & 0b101) != 0 /* is-state_0 sliceIntInt(DynamicObject, int, int) || sliceDirectIntInt(DynamicObject, int, int) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 sliceIntInt(DynamicObject, int, int) */) {
                    if ((JSArrayBuffer.isJSHeapArrayBuffer(arguments0Value__))) {
                        return sliceIntInt(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 sliceDirectIntInt(DynamicObject, int, int) */) {
                    if ((JSArrayBuffer.isJSDirectArrayBuffer(arguments0Value__))) {
                        return sliceDirectIntInt(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state_0 & 0b11111) != 0 /* is-state_0 sliceIntInt(DynamicObject, int, int) || slice(DynamicObject, Object, Object) || sliceDirectIntInt(DynamicObject, int, int) || sliceDirect(DynamicObject, Object, Object) || sliceInterop(DynamicObject, Object, Object, InteropLibrary, InteropLibrary) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 sliceIntInt(DynamicObject, int, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if (arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if ((JSArrayBuffer.isJSHeapArrayBuffer(arguments0Value__))) {
                            return sliceIntInt(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 slice(DynamicObject, Object, Object) */) {
                    if ((JSArrayBuffer.isJSHeapArrayBuffer(arguments0Value__))) {
                        return slice(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 sliceDirectIntInt(DynamicObject, int, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if (arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if ((JSArrayBuffer.isJSDirectArrayBuffer(arguments0Value__))) {
                            return sliceDirectIntInt(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                }
                if ((state_0 & 0b11000) != 0 /* is-state_0 sliceDirect(DynamicObject, Object, Object) || sliceInterop(DynamicObject, Object, Object, InteropLibrary, InteropLibrary) */) {
                    if ((state_0 & 0b1000) != 0 /* is-state_0 sliceDirect(DynamicObject, Object, Object) */) {
                        if ((JSArrayBuffer.isJSDirectArrayBuffer(arguments0Value__))) {
                            return sliceDirect(arguments0Value__, arguments1Value_, arguments2Value_);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 sliceInterop(DynamicObject, Object, Object, InteropLibrary, InteropLibrary) */) {
                        if ((JSArrayBuffer.isJSInteropArrayBuffer(arguments0Value__))) {
                            return sliceInterop(arguments0Value__, arguments1Value_, arguments2Value_, this.srcBufferLib, this.dstBufferLib);
                        }
                    }
                }
            }
            if ((state_0 & 0b10100000) != 0 /* is-state_0 sliceTruffleBuffer(Object, Object, Object, InteropLibrary, InteropLibrary) || error(Object, Object, Object) */) {
                if ((state_0 & 0b100000) != 0 /* is-state_0 sliceTruffleBuffer(Object, Object, Object, InteropLibrary, InteropLibrary) */) {
                    if ((!(JSGuards.isJSSharedArrayBuffer(arguments0Value_))) && (JSArrayBufferSliceNode.hasBufferElements(arguments0Value_, this.srcBufferLib))) {
                        return sliceTruffleBuffer(arguments0Value_, arguments1Value_, arguments2Value_, this.srcBufferLib, this.dstBufferLib);
                    }
                }
                if ((state_0 & 0b10000000) != 0 /* is-state_0 error(Object, Object, Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_, arguments2Value_)) {
                        return JSArrayBufferSliceNode.error(arguments0Value_, arguments1Value_, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (((exclude & 0b1)) == 0 /* is-not-exclude sliceIntInt(DynamicObject, int, int) */ && arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        if (arguments2Value instanceof Integer) {
                            int arguments2Value_ = (int) arguments2Value;
                            if ((JSArrayBuffer.isJSHeapArrayBuffer(arguments0Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 sliceIntInt(DynamicObject, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return sliceIntInt(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                        }
                    }
                    if ((JSArrayBuffer.isJSHeapArrayBuffer(arguments0Value_))) {
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude sliceIntInt(DynamicObject, int, int) */;
                        state_0 = state_0 & 0xfffffffe /* remove-state_0 sliceIntInt(DynamicObject, int, int) */;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 slice(DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return slice(arguments0Value_, arguments1Value, arguments2Value);
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-exclude sliceDirectIntInt(DynamicObject, int, int) */ && arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        if (arguments2Value instanceof Integer) {
                            int arguments2Value_ = (int) arguments2Value;
                            if ((JSArrayBuffer.isJSDirectArrayBuffer(arguments0Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 sliceDirectIntInt(DynamicObject, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return sliceDirectIntInt(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                        }
                    }
                    if ((JSArrayBuffer.isJSDirectArrayBuffer(arguments0Value_))) {
                        this.exclude_ = exclude = exclude | 0b10 /* add-exclude sliceDirectIntInt(DynamicObject, int, int) */;
                        state_0 = state_0 & 0xfffffffb /* remove-state_0 sliceDirectIntInt(DynamicObject, int, int) */;
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 sliceDirect(DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return sliceDirect(arguments0Value_, arguments1Value, arguments2Value);
                    }
                    if ((JSArrayBuffer.isJSInteropArrayBuffer(arguments0Value_))) {
                        this.srcBufferLib = super.insert(this.srcBufferLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.srcBufferLib);
                        this.dstBufferLib = super.insert(this.dstBufferLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.dstBufferLib);
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 sliceInterop(DynamicObject, Object, Object, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return sliceInterop(arguments0Value_, arguments1Value, arguments2Value, this.srcBufferLib, this.dstBufferLib);
                    }
                }
                if ((!(JSGuards.isJSSharedArrayBuffer(arguments0Value)))) {
                    if (((state_0 & 0b1000000)) == 0 /* is-not-state_0 Guard[(JSArrayBufferSliceNode.hasBufferElements(thisObj, srcBufferLib))] */) {
                        if (this.srcBufferLib == null) {
                            InteropLibrary sliceTruffleBuffer_srcBufferLib___check = super.insert(this.srcBufferLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.srcBufferLib);
                            if (sliceTruffleBuffer_srcBufferLib___check == null) {
                                throw new AssertionError("Specialization 'sliceTruffleBuffer(Object, Object, Object, InteropLibrary, InteropLibrary)' contains a shared cache with name 'srcBufferLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.srcBufferLib = sliceTruffleBuffer_srcBufferLib___check;
                        }
                        this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 Guard[(JSArrayBufferSliceNode.hasBufferElements(thisObj, srcBufferLib))] */;
                    }
                    if ((JSArrayBufferSliceNode.hasBufferElements(arguments0Value, this.srcBufferLib))) {
                        if (this.srcBufferLib == null) {
                            InteropLibrary sliceTruffleBuffer_srcBufferLib___check = super.insert(this.srcBufferLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.srcBufferLib);
                            if (sliceTruffleBuffer_srcBufferLib___check == null) {
                                throw new AssertionError("Specialization 'sliceTruffleBuffer(Object, Object, Object, InteropLibrary, InteropLibrary)' contains a shared cache with name 'srcBufferLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.srcBufferLib = sliceTruffleBuffer_srcBufferLib___check;
                        }
                        this.dstBufferLib = super.insert(this.dstBufferLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.dstBufferLib);
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 sliceTruffleBuffer(Object, Object, Object, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return sliceTruffleBuffer(arguments0Value, arguments1Value, arguments2Value, this.srcBufferLib, this.dstBufferLib);
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 error(Object, Object, Object) */;
                lock.unlock();
                hasLock = false;
                return JSArrayBufferSliceNode.error(arguments0Value, arguments1Value, arguments2Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b10111111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b10111111) & ((state_0 & 0b10111111) - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[8];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "sliceIntInt";
            if ((state_0 & 0b1) != 0 /* is-state_0 sliceIntInt(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b1) != 0 /* is-exclude sliceIntInt(DynamicObject, int, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "slice";
            if ((state_0 & 0b10) != 0 /* is-state_0 slice(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "sliceDirectIntInt";
            if ((state_0 & 0b100) != 0 /* is-state_0 sliceDirectIntInt(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b10) != 0 /* is-exclude sliceDirectIntInt(DynamicObject, int, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "sliceDirect";
            if ((state_0 & 0b1000) != 0 /* is-state_0 sliceDirect(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "sliceInterop";
            if ((state_0 & 0b10000) != 0 /* is-state_0 sliceInterop(DynamicObject, Object, Object, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.srcBufferLib, this.dstBufferLib));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "sliceTruffleBuffer";
            if ((state_0 & 0b100000) != 0 /* is-state_0 sliceTruffleBuffer(Object, Object, Object, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.srcBufferLib, this.dstBufferLib));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "error";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 error(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            return Provider.create(data);
        }

        public static JSArrayBufferSliceNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayBufferSliceNodeGen(context, builtin, arguments);
        }

    }
}
