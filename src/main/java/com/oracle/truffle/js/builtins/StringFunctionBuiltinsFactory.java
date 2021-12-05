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
import com.oracle.truffle.js.builtins.StringFunctionBuiltins.JSFromCharCodeNode;
import com.oracle.truffle.js.builtins.StringFunctionBuiltins.JSFromCodePointNode;
import com.oracle.truffle.js.builtins.StringFunctionBuiltins.StringRawNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(StringFunctionBuiltins.class)
public final class StringFunctionBuiltinsFactory {

    @GeneratedBy(JSFromCharCodeNode.class)
    public static final class JSFromCharCodeNodeGen extends JSFromCharCodeNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private JSFromCharCodeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 fromCharCode(Object[]) || fromCharCodeOneArg(Object[]) || fromCharCodeTwoOrMore(Object[]) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 fromCharCode(Object[]) */) {
                    if ((arguments0Value__.length == 0)) {
                        return fromCharCode(arguments0Value__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 fromCharCodeOneArg(Object[]) */) {
                    if ((arguments0Value__.length == 1)) {
                        return fromCharCodeOneArg(arguments0Value__);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 fromCharCodeTwoOrMore(Object[]) */) {
                    if ((arguments0Value__.length >= 2)) {
                        return fromCharCodeTwoOrMore(arguments0Value__);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof Object[]) {
                Object[] arguments0Value_ = (Object[]) arguments0Value;
                if ((arguments0Value_.length == 0)) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 fromCharCode(Object[]) */;
                    return fromCharCode(arguments0Value_);
                }
                if ((arguments0Value_.length == 1)) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 fromCharCodeOneArg(Object[]) */;
                    return fromCharCodeOneArg(arguments0Value_);
                }
                if ((arguments0Value_.length >= 2)) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 fromCharCodeTwoOrMore(Object[]) */;
                    return fromCharCodeTwoOrMore(arguments0Value_);
                }
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "fromCharCode";
            if ((state_0 & 0b1) != 0 /* is-state_0 fromCharCode(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "fromCharCodeOneArg";
            if ((state_0 & 0b10) != 0 /* is-state_0 fromCharCodeOneArg(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "fromCharCodeTwoOrMore";
            if ((state_0 & 0b100) != 0 /* is-state_0 fromCharCodeTwoOrMore(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSFromCharCodeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSFromCharCodeNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSFromCodePointNode.class)
    public static final class JSFromCodePointNodeGen extends JSFromCodePointNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToNumberNode toNumberNode_;

        private JSFromCodePointNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 fromCodePoint(Object[], JSToNumberNode) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                return fromCodePoint(arguments0Value__, this.toNumberNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arguments0Value instanceof Object[]) {
                    Object[] arguments0Value_ = (Object[]) arguments0Value;
                    this.toNumberNode_ = super.insert((JSToNumberNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 fromCodePoint(Object[], JSToNumberNode) */;
                    lock.unlock();
                    hasLock = false;
                    return fromCodePoint(arguments0Value_, this.toNumberNode_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "fromCodePoint";
            if (state_0 != 0 /* is-state_0 fromCodePoint(Object[], JSToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toNumberNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSFromCodePointNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSFromCodePointNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(StringRawNode.class)
    public static final class StringRawNodeGen extends StringRawNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private StringRawNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 raw(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return raw(arguments0Value_, arguments1Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state_0 = this.state_0_;
            if (arguments1Value instanceof Object[]) {
                Object[] arguments1Value_ = (Object[]) arguments1Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 raw(Object, Object[]) */;
                return raw(arguments0Value, arguments1Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "raw";
            if (state_0 != 0 /* is-state_0 raw(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static StringRawNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new StringRawNodeGen(context, builtin, arguments);
        }

    }
}
