// CheckStyle: start generated
package com.oracle.truffle.js.nodes.intl;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(GetNumberOptionNode.class)
public final class GetNumberOptionNodeGen extends GetNumberOptionNode implements Introspection.Provider {

    private GetNumberOptionNodeGen(JSContext context, String property) {
        super(context, property);
    }

    @Override
    public int executeInt(Object arg0Value, int arg1Value, int arg2Value, int arg3Value) {
        return getOption(arg0Value, arg1Value, arg2Value, arg3Value);
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
        s[0] = "getOption";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static GetNumberOptionNode create(JSContext context, String property) {
        return new GetNumberOptionNodeGen(context, property);
    }

}
