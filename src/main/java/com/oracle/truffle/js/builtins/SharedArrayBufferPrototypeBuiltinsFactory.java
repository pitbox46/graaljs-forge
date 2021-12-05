// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.SharedArrayBufferPrototypeBuiltins.ByteLengthGetterNode;
import com.oracle.truffle.js.builtins.SharedArrayBufferPrototypeBuiltins.JSSharedArrayBufferSliceNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SharedArrayBufferPrototypeBuiltins.class)
public final class SharedArrayBufferPrototypeBuiltinsFactory {

    @GeneratedBy(JSSharedArrayBufferSliceNode.class)
    public static final class JSSharedArrayBufferSliceNodeGen extends JSSharedArrayBufferSliceNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;
        @CompilationFinal private int exclude_;

        private JSSharedArrayBufferSliceNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b110) == 0 /* only-active sliceSharedIntInt(DynamicObject, int, int) */ && (state_0 != 0  /* is-not sliceSharedIntInt(DynamicObject, int, int) && sliceShared(DynamicObject, Object, Object) && error(Object, Object, Object) */)) {
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
            assert (state_0 & 0b1) != 0 /* is-state_0 sliceSharedIntInt(DynamicObject, int, int) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSSharedArrayBuffer(arguments0Value__))) {
                    return sliceSharedIntInt(arguments0Value__, arguments1Value_, arguments2Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state_0 & 0b11) != 0 /* is-state_0 sliceSharedIntInt(DynamicObject, int, int) || sliceShared(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 sliceSharedIntInt(DynamicObject, int, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if (arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if ((JSGuards.isJSSharedArrayBuffer(arguments0Value__))) {
                            return sliceSharedIntInt(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 sliceShared(DynamicObject, Object, Object) */) {
                    if ((JSGuards.isJSSharedArrayBuffer(arguments0Value__))) {
                        return sliceShared(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 error(Object, Object, Object) */) {
                if ((!(JSGuards.isJSSharedArrayBuffer(arguments0Value_)))) {
                    return JSSharedArrayBufferSliceNode.error(arguments0Value_, arguments1Value_, arguments2Value_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((exclude) == 0 /* is-not-exclude sliceSharedIntInt(DynamicObject, int, int) */ && arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        if (arguments2Value instanceof Integer) {
                            int arguments2Value_ = (int) arguments2Value;
                            if ((JSGuards.isJSSharedArrayBuffer(arguments0Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 sliceSharedIntInt(DynamicObject, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return sliceSharedIntInt(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                        }
                    }
                    if ((JSGuards.isJSSharedArrayBuffer(arguments0Value_))) {
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude sliceSharedIntInt(DynamicObject, int, int) */;
                        state_0 = state_0 & 0xfffffffe /* remove-state_0 sliceSharedIntInt(DynamicObject, int, int) */;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 sliceShared(DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return sliceShared(arguments0Value_, arguments1Value, arguments2Value);
                    }
                }
                if ((!(JSGuards.isJSSharedArrayBuffer(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 error(Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return JSSharedArrayBufferSliceNode.error(arguments0Value, arguments1Value, arguments2Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "sliceSharedIntInt";
            if ((state_0 & 0b1) != 0 /* is-state_0 sliceSharedIntInt(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-exclude sliceSharedIntInt(DynamicObject, int, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "sliceShared";
            if ((state_0 & 0b10) != 0 /* is-state_0 sliceShared(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "error";
            if ((state_0 & 0b100) != 0 /* is-state_0 error(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSSharedArrayBufferSliceNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSSharedArrayBufferSliceNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ByteLengthGetterNode.class)
    public static final class ByteLengthGetterNodeGen extends ByteLengthGetterNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

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
            if (state_0 != 0 /* is-state_0 sharedArrayBuffer(Object) || error(Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 sharedArrayBuffer(Object) */) {
                    if ((JSGuards.isJSSharedArrayBuffer(arguments0Value_))) {
                        return ByteLengthGetterNode.sharedArrayBuffer(arguments0Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 error(Object) */) {
                    if ((!(JSGuards.isJSSharedArrayBuffer(arguments0Value_)))) {
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
            if (state_0 != 0 /* is-state_0 sharedArrayBuffer(Object) || error(Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 sharedArrayBuffer(Object) */) {
                    if ((JSGuards.isJSSharedArrayBuffer(arguments0Value_))) {
                        return ByteLengthGetterNode.sharedArrayBuffer(arguments0Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 error(Object) */) {
                    if ((!(JSGuards.isJSSharedArrayBuffer(arguments0Value_)))) {
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
            int state_0 = this.state_0_;
            if ((JSGuards.isJSSharedArrayBuffer(arguments0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 sharedArrayBuffer(Object) */;
                return ByteLengthGetterNode.sharedArrayBuffer(arguments0Value);
            }
            if ((!(JSGuards.isJSSharedArrayBuffer(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 error(Object) */;
                return ByteLengthGetterNode.error(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "sharedArrayBuffer";
            if ((state_0 & 0b1) != 0 /* is-state_0 sharedArrayBuffer(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "error";
            if ((state_0 & 0b10) != 0 /* is-state_0 error(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ByteLengthGetterNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ByteLengthGetterNodeGen(context, builtin, arguments);
        }

    }
}
