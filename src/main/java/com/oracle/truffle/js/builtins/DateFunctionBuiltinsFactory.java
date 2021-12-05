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
import com.oracle.truffle.js.builtins.DateFunctionBuiltins.DateNowNode;
import com.oracle.truffle.js.builtins.DateFunctionBuiltins.DateParseNode;
import com.oracle.truffle.js.builtins.DateFunctionBuiltins.DateUTCNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DateFunctionBuiltins.class)
@SuppressWarnings("unused")
public final class DateFunctionBuiltinsFactory {

    @GeneratedBy(DateParseNode.class)
    public static final class DateParseNodeGen extends DateParseNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToStringNode toStringNode_;

        private DateParseNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 parse(Object, JSToStringNode) */) {
                return parse(arguments0Value_, this.toStringNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 parse(Object, JSToStringNode) */) {
                return parse(arguments0Value_, this.toStringNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeDouble(frameValue);
            return;
        }

        private double executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                this.toStringNode_ = super.insert((JSToStringNode.create()));
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 parse(Object, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return parse(arguments0Value, this.toStringNode_);
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
            s[0] = "parse";
            if (state_0 != 0 /* is-state_0 parse(Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static DateParseNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DateParseNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DateNowNode.class)
    public static final class DateNowNodeGen extends DateNowNode implements Introspection.Provider {

        private DateNowNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return now();
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            return now();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeDouble(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "now";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DateNowNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DateNowNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DateUTCNode.class)
    public static final class DateUTCNodeGen extends DateUTCNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToNumberNode toNumberNode_;

        private DateUTCNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 utc(Object[], JSToNumberNode) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                return utc(arguments0Value__, this.toNumberNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 utc(Object[], JSToNumberNode) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                return utc(arguments0Value__, this.toNumberNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeDouble(frameValue);
            return;
        }

        private double executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arguments0Value instanceof Object[]) {
                    Object[] arguments0Value_ = (Object[]) arguments0Value;
                    this.toNumberNode_ = super.insert((JSToNumberNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 utc(Object[], JSToNumberNode) */;
                    lock.unlock();
                    hasLock = false;
                    return utc(arguments0Value_, this.toNumberNode_);
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
            s[0] = "utc";
            if (state_0 != 0 /* is-state_0 utc(Object[], JSToNumberNode) */) {
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

        public static DateUTCNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DateUTCNodeGen(context, builtin, arguments);
        }

    }
}
