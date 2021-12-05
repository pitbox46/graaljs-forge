// CheckStyle: start generated
package com.oracle.truffle.js.nodes.wasm;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;

@GeneratedBy(ToWebAssemblyIndexOrSizeNode.class)
public final class ToWebAssemblyIndexOrSizeNodeGen extends ToWebAssemblyIndexOrSizeNode implements Introspection.Provider {

    private ToWebAssemblyIndexOrSizeNodeGen(String errorMessagePrefix) {
        super(errorMessagePrefix);
    }

    @Override
    public double executeDouble(Object arg0Value) {
        return convert(arg0Value);
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
        s[0] = "convert";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static ToWebAssemblyIndexOrSizeNode create(String errorMessagePrefix) {
        return new ToWebAssemblyIndexOrSizeNodeGen(errorMessagePrefix);
    }

}
