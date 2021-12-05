// CheckStyle: start generated
package com.oracle.truffle.js.builtins.commonjs;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(CommonJSFilenameGetterBuiltin.class)
@SuppressWarnings("unused")
public final class CommonJSFilenameGetterBuiltinNodeGen extends CommonJSFilenameGetterBuiltin implements Introspection.Provider {

    private CommonJSFilenameGetterBuiltinNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        super(context, builtin);
    }

    @Override
    public JavaScriptNode[] getArguments() {
        return new JavaScriptNode[] {};
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        return getFileName();
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
        s[0] = "getFileName";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static CommonJSFilenameGetterBuiltin create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new CommonJSFilenameGetterBuiltinNodeGen(context, builtin, arguments);
    }

}
