// CheckStyle: start generated
package com.oracle.truffle.js.builtins.helper;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(JSONStringifyStringNode.class)
public final class JSONStringifyStringNodeGen extends JSONStringifyStringNode implements Introspection.Provider {

    private JSONStringifyStringNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public Object execute(Object arg0Value, String arg1Value, DynamicObject arg2Value) {
        return jsonStrMain(arg0Value, arg1Value, arg2Value);
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
        s[0] = "jsonStrMain";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static JSONStringifyStringNode create(JSContext context) {
        return new JSONStringifyStringNodeGen(context);
    }

}
