// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.js.nodes.JavaScriptNode;

@GeneratedBy(VoidNode.class)
public final class VoidNodeGen extends VoidNode implements Introspection.Provider {

    private VoidNodeGen(JavaScriptNode operand) {
        super(operand);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        return doGeneric(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        return doGeneric(operandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[2];
        Object[] s;
        data[0] = 0;
        s = new Object[3];
        s[0] = "doGeneric";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static VoidNode create(JavaScriptNode operand) {
        return new VoidNodeGen(operand);
    }

}
