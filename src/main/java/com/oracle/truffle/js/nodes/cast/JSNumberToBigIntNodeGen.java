// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.BigInt;

@GeneratedBy(JSNumberToBigIntNode.class)
public final class JSNumberToBigIntNodeGen extends JSNumberToBigIntNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private JSNumberToBigIntNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return doInteger(arg0Value_);
        }
        if ((state_0 & 0b110) != 0 /* is-state_0 doDoubleAsLong(double) || doDoubleOther(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arg0Value);
            if ((state_0 & 0b10) != 0 /* is-state_0 doDoubleAsLong(double) */) {
                if ((JSGuards.isDoubleRepresentableAsLong(arg0Value_))) {
                    return doDoubleAsLong(arg0Value_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doDoubleOther(double) */) {
                if ((!(JSGuards.isDoubleRepresentableAsLong(arg0Value_)))) {
                    return doDoubleOther(arg0Value_);
                }
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doNull(Object) */) {
            if ((JSGuards.isJSNull(arg0Value))) {
                return JSNumberToBigIntNode.doNull(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private BigInt executeAndSpecialize(Object arg0Value) {
        int state_0 = this.state_0_;
        if (arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInteger(int) */;
            return doInteger(arg0Value_);
        }
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                if ((JSGuards.isDoubleRepresentableAsLong(arg0Value_))) {
                    state_0 = (state_0 | (doubleCast0 << 4) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDoubleAsLong(double) */;
                    return doDoubleAsLong(arg0Value_);
                }
                if ((!(JSGuards.isDoubleRepresentableAsLong(arg0Value_)))) {
                    state_0 = (state_0 | (doubleCast0 << 4) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doDoubleOther(double) */;
                    return doDoubleOther(arg0Value_);
                }
            }
        }
        if ((JSGuards.isJSNull(arg0Value))) {
            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doNull(Object) */;
            return JSNumberToBigIntNode.doNull(arg0Value);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111) & ((state_0 & 0b1111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[5];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDoubleAsLong";
        if ((state_0 & 0b10) != 0 /* is-state_0 doDoubleAsLong(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDoubleOther";
        if ((state_0 & 0b100) != 0 /* is-state_0 doDoubleOther(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doNull";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static JSNumberToBigIntNode create() {
        return new JSNumberToBigIntNodeGen();
    }

}
