// CheckStyle: start generated
package com.oracle.truffle.js.nodes.intl;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.intl.JSNumberFormat.BasicInternalState;

@GeneratedBy(SetNumberFormatDigitOptionsNode.class)
public final class SetNumberFormatDigitOptionsNodeGen extends SetNumberFormatDigitOptionsNode implements Introspection.Provider {

    private SetNumberFormatDigitOptionsNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public Object execute(BasicInternalState arg0Value, Object arg1Value, int arg2Value, int arg3Value, boolean arg4Value) {
        return setNumberFormatDigitOptions(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
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
        s[0] = "setNumberFormatDigitOptions";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static SetNumberFormatDigitOptionsNode create(JSContext context) {
        return new SetNumberFormatDigitOptionsNodeGen(context);
    }

}
