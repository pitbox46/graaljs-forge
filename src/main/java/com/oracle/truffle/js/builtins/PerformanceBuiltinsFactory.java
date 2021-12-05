// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.builtins.PerformanceBuiltins.JSPerformanceNowNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(PerformanceBuiltins.class)
@SuppressWarnings("unused")
public final class PerformanceBuiltinsFactory {

    @GeneratedBy(JSPerformanceNowNode.class)
    public static final class JSPerformanceNowNodeGen extends JSPerformanceNowNode implements Introspection.Provider {

        private JSPerformanceNowNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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

        public static JSPerformanceNowNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSPerformanceNowNodeGen(context, builtin, arguments);
        }

    }
}
