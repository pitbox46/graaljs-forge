// CheckStyle: start generated
package com.oracle.truffle.js.nodes.wasm;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;

@GeneratedBy(ToJSValueNode.class)
public final class ToJSValueNodeGen extends ToJSValueNode implements Introspection.Provider {

    private static final Uncached UNCACHED = new Uncached();

    private ToJSValueNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value) {
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

    public static ToJSValueNode create() {
        return new ToJSValueNodeGen();
    }

    public static ToJSValueNode getUncached() {
        return ToJSValueNodeGen.UNCACHED;
    }

    @GeneratedBy(ToJSValueNode.class)
    private static final class Uncached extends ToJSValueNode {

        @TruffleBoundary
        @Override
        public Object execute(Object arg0Value) {
            return convert(arg0Value);
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
}
