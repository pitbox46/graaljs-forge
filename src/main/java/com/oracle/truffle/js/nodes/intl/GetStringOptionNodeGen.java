// CheckStyle: start generated
package com.oracle.truffle.js.nodes.intl;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(GetStringOptionNode.class)
public final class GetStringOptionNodeGen extends GetStringOptionNode implements Introspection.Provider {

    private GetStringOptionNodeGen(JSContext context, String property, String[] values, String fallback) {
        super(context, property, values, fallback);
    }

    @Override
    public String executeValue(Object arg0Value) {
        return getOption(arg0Value);
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

    public static GetStringOptionNode create(JSContext context, String property, String[] values, String fallback) {
        return new GetStringOptionNodeGen(context, property, values, fallback);
    }

}
