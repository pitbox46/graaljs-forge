// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.builtins.Test262Builtins.Test262AgentBroadcast;
import com.oracle.truffle.js.builtins.Test262Builtins.Test262AgentGetReport;
import com.oracle.truffle.js.builtins.Test262Builtins.Test262AgentLeaving;
import com.oracle.truffle.js.builtins.Test262Builtins.Test262AgentReceiveBroadcast;
import com.oracle.truffle.js.builtins.Test262Builtins.Test262AgentReport;
import com.oracle.truffle.js.builtins.Test262Builtins.Test262AgentSleep;
import com.oracle.truffle.js.builtins.Test262Builtins.Test262AgentStart;
import com.oracle.truffle.js.builtins.Test262Builtins.Test262CreateRealmNode;
import com.oracle.truffle.js.builtins.Test262Builtins.Test262EvalScriptNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSLoadNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(Test262Builtins.class)
@SuppressWarnings("unused")
public final class Test262BuiltinsFactory {

    @GeneratedBy(Test262EvalScriptNode.class)
    public static final class Test262EvalScriptNodeGen extends Test262EvalScriptNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSLoadNode loadNode_;

        private Test262EvalScriptNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 evalScript(Object, JSLoadNode) */) {
                return evalScript(arguments0Value_, this.loadNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                this.loadNode_ = super.insert((JSLoadNode.create(getContext())));
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 evalScript(Object, JSLoadNode) */;
                lock.unlock();
                hasLock = false;
                return evalScript(arguments0Value, this.loadNode_);
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
            s[0] = "evalScript";
            if (state_0 != 0 /* is-state_0 evalScript(Object, JSLoadNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.loadNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static Test262EvalScriptNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new Test262EvalScriptNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(Test262CreateRealmNode.class)
    public static final class Test262CreateRealmNodeGen extends Test262CreateRealmNode implements Introspection.Provider {

        private Test262CreateRealmNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return createRealm();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
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
            s[0] = "createRealm";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static Test262CreateRealmNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new Test262CreateRealmNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(Test262AgentStart.class)
    public static final class Test262AgentStartNodeGen extends Test262AgentStart implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private Test262AgentStartNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return start(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
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
            s[0] = "start";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static Test262AgentStart create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new Test262AgentStartNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(Test262AgentBroadcast.class)
    public static final class Test262AgentBroadcastNodeGen extends Test262AgentBroadcast implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private Test262AgentBroadcastNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return broadcast(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
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
            s[0] = "broadcast";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static Test262AgentBroadcast create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new Test262AgentBroadcastNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(Test262AgentGetReport.class)
    public static final class Test262AgentGetReportNodeGen extends Test262AgentGetReport implements Introspection.Provider {

        private Test262AgentGetReportNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return getReport();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
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
            s[0] = "getReport";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static Test262AgentGetReport create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new Test262AgentGetReportNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(Test262AgentSleep.class)
    public static final class Test262AgentSleepNodeGen extends Test262AgentSleep implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private Test262AgentSleepNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b10) == 0 /* only-active doSleep(int) */ && (state_0 != 0  /* is-not doSleep(int) && doSleep(Object) */)) {
                return execute_int0(state_0, frameValue);
            } else {
                return execute_generic1(state_0, frameValue);
            }
        }

        private Object execute_int0(int state_0, VirtualFrame frameValue) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b1) != 0 /* is-state_0 doSleep(int) */;
            return doSleep(arguments0Value_);
        }

        private Object execute_generic1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 doSleep(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return doSleep(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doSleep(Object) */) {
                if (fallbackGuard_(state_0, arguments0Value_)) {
                    return doSleep(arguments0Value_);
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

        private Object executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof Integer) {
                int arguments0Value_ = (int) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doSleep(int) */;
                return doSleep(arguments0Value_);
            }
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doSleep(Object) */;
            return doSleep(arguments0Value);
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
            s[0] = "doSleep";
            if ((state_0 & 0b1) != 0 /* is-state_0 doSleep(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doSleep";
            if ((state_0 & 0b10) != 0 /* is-state_0 doSleep(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value) {
            if (((state_0 & 0b1)) == 0 /* is-not-state_0 doSleep(int) */ && arguments0Value instanceof Integer) {
                return false;
            }
            return true;
        }

        public static Test262AgentSleep create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new Test262AgentSleepNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(Test262AgentReceiveBroadcast.class)
    public static final class Test262AgentReceiveBroadcastNodeGen extends Test262AgentReceiveBroadcast implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private Test262AgentReceiveBroadcastNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return receiveBroadcast(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
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
            s[0] = "receiveBroadcast";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static Test262AgentReceiveBroadcast create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new Test262AgentReceiveBroadcastNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(Test262AgentReport.class)
    public static final class Test262AgentReportNodeGen extends Test262AgentReport implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private Test262AgentReportNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return report(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
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
            s[0] = "report";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static Test262AgentReport create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new Test262AgentReportNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(Test262AgentLeaving.class)
    public static final class Test262AgentLeavingNodeGen extends Test262AgentLeaving implements Introspection.Provider {

        private Test262AgentLeavingNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return leaving();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
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
            s[0] = "leaving";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static Test262AgentLeaving create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new Test262AgentLeavingNodeGen(context, builtin, arguments);
        }

    }
}
