// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.SafeInteger;

@GeneratedBy(IsNumberNode.class)
public final class IsNumberNodeGen extends IsNumberNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private IsNumberNodeGen() {
    }

    @Override
    public boolean execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return IsNumberNode.doInt(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            return IsNumberNode.doLong(arg0Value_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            return IsNumberNode.doSafeInteger(arg0Value_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, arg0Value);
            return IsNumberNode.doDouble(arg0Value_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doOther(Object) */) {
            if (fallbackGuard_(arg0Value)) {
                return IsNumberNode.doOther(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private boolean executeAndSpecialize(Object arg0Value) {
        int state_0 = this.state_0_;
        if (arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt(int) */;
            return IsNumberNode.doInt(arg0Value_);
        }
        if (arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doLong(long) */;
            return IsNumberNode.doLong(arg0Value_);
        }
        if (arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doSafeInteger(SafeInteger) */;
            return IsNumberNode.doSafeInteger(arg0Value_);
        }
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                state_0 = (state_0 | (doubleCast0 << 5) /* set-implicit-state_0 0:double */);
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doDouble(double) */;
                return IsNumberNode.doDouble(arg0Value_);
            }
        }
        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doOther(Object) */;
        return IsNumberNode.doOther(arg0Value);
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b11111) & ((state_0 & 0b11111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state_0 & 0b10) != 0 /* is-state_0 doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b100) != 0 /* is-state_0 doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(Object arg0Value) {
        if (JSTypesGen.isImplicitDouble(arg0Value)) {
            return false;
        }
        return true;
    }

    public static IsNumberNode create() {
        return new IsNumberNodeGen();
    }

}
