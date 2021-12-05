// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.builtins.RealmFunctionBuiltins.RealmCreateNode;
import com.oracle.truffle.js.builtins.RealmFunctionBuiltins.RealmCurrentNode;
import com.oracle.truffle.js.builtins.RealmFunctionBuiltins.RealmDisposeNode;
import com.oracle.truffle.js.builtins.RealmFunctionBuiltins.RealmEvalNode;
import com.oracle.truffle.js.builtins.RealmFunctionBuiltins.RealmGlobalNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(RealmFunctionBuiltins.class)
@SuppressWarnings("unused")
public final class RealmFunctionBuiltinsFactory {

    @GeneratedBy(RealmCreateNode.class)
    public static final class RealmCreateNodeGen extends RealmCreateNode implements Introspection.Provider {

        private RealmCreateNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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

        public static RealmCreateNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new RealmCreateNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(RealmDisposeNode.class)
    public static final class RealmDisposeNodeGen extends RealmDisposeNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private RealmDisposeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return dispose(arguments0Value_);
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
            s[0] = "dispose";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static RealmDisposeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new RealmDisposeNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(RealmGlobalNode.class)
    public static final class RealmGlobalNodeGen extends RealmGlobalNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private RealmGlobalNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return global(arguments0Value_);
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
            s[0] = "global";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static RealmGlobalNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new RealmGlobalNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(RealmCurrentNode.class)
    public static final class RealmCurrentNodeGen extends RealmCurrentNode implements Introspection.Provider {

        private RealmCurrentNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return current();
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
            s[0] = "current";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static RealmCurrentNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new RealmCurrentNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(RealmEvalNode.class)
    public static final class RealmEvalNodeGen extends RealmEvalNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private RealmEvalNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return eval(arguments0Value_, arguments1Value_);
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
            s[0] = "eval";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static RealmEvalNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new RealmEvalNodeGen(context, builtin, arguments);
        }

    }
}
