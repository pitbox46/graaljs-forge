// CheckStyle: start generated
package com.oracle.truffle.js.nodes.intl;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(InitializeDateTimeFormatNode.class)
public final class InitializeDateTimeFormatNodeGen extends InitializeDateTimeFormatNode implements Introspection.Provider {

    private InitializeDateTimeFormatNodeGen(JSContext context, String required, String defaults) {
        super(context, required, defaults);
    }

    @Override
    public DynamicObject executeInit(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
        return initializeDateTimeFormat(arg0Value, arg1Value, arg2Value);
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
        s[0] = "initializeDateTimeFormat";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static InitializeDateTimeFormatNode create(JSContext context, String required, String defaults) {
        return new InitializeDateTimeFormatNodeGen(context, required, defaults);
    }

}
