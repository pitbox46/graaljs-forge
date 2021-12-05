// CheckStyle: start generated
package com.oracle.truffle.js.nodes.wasm;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;

@GeneratedBy(ToWebAssemblyValueNode.class)
public final class ToWebAssemblyValueNodeGen extends ToWebAssemblyValueNode implements Introspection.Provider {

    private ToWebAssemblyValueNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value, String arg1Value) {
        return convert(arg0Value, arg1Value);
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

    public static ToWebAssemblyValueNode create() {
        return new ToWebAssemblyValueNodeGen();
    }

    @GeneratedBy(Uncached.class)
    static final class UncachedNodeGen extends Uncached implements Introspection.Provider {

        private UncachedNodeGen() {
        }

        @Override
        public Object execute(Object arg0Value, String arg1Value) {
            return convert(arg0Value, arg1Value);
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

        public static Uncached create() {
            return new UncachedNodeGen();
        }

    }
}
