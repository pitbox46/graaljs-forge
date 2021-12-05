// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(CreateIterResultObjectNode.class)
public final class CreateIterResultObjectNodeGen extends CreateIterResultObjectNode implements Introspection.Provider {

    private CreateIterResultObjectNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public DynamicObject execute(VirtualFrame frameValue, Object arg0Value, boolean arg1Value) {
        return doCreateIterResultObject(frameValue, arg0Value, arg1Value);
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
        s[0] = "doCreateIterResultObject";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static CreateIterResultObjectNode create(JSContext context) {
        return new CreateIterResultObjectNodeGen(context);
    }

}
