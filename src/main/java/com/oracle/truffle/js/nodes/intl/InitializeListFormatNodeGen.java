// CheckStyle: start generated
package com.oracle.truffle.js.nodes.intl;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(InitializeListFormatNode.class)
public final class InitializeListFormatNodeGen extends InitializeListFormatNode implements Introspection.Provider {

    private InitializeListFormatNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public DynamicObject executeInit(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
        return initializeListFormat(arg0Value, arg1Value, arg2Value);
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
        s[0] = "initializeListFormat";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static InitializeListFormatNode create(JSContext context) {
        return new InitializeListFormatNodeGen(context);
    }

}
