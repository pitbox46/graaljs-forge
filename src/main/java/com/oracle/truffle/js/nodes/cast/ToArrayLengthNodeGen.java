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
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.SafeInteger;

@GeneratedBy(ToArrayLengthNode.class)
public final class ToArrayLengthNodeGen extends ToArrayLengthNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private ToArrayLengthNodeGen() {
    }

    @Override
    public long executeLong(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return ToArrayLengthNode.doInt(arg0Value_);
        }
        if ((state_0 & 0b110) != 0 /* is-state_0 doSafeInteger(SafeInteger) || rangeError(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */) {
                if ((JSRuntime.isValidArrayLength(arg0Value_.longValue()))) {
                    return ToArrayLengthNode.doSafeInteger(arg0Value_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 rangeError(SafeInteger) */) {
                if ((!(JSRuntime.isValidArrayLength(arg0Value_.longValue())))) {
                    return ToArrayLengthNode.rangeError(arg0Value_);
                }
            }
        }
        if ((state_0 & 0b11000) != 0 /* is-state_0 doLong(long) || rangeError(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(long) */) {
                if ((JSRuntime.isValidArrayLength(arg0Value_))) {
                    return ToArrayLengthNode.doLong(arg0Value_);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 rangeError(long) */) {
                if ((!(JSRuntime.isValidArrayLength(arg0Value_)))) {
                    return ToArrayLengthNode.rangeError(arg0Value_);
                }
            }
        }
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doDouble(double) || rangeError(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 0:double */, arg0Value);
            if ((state_0 & 0b100000) != 0 /* is-state_0 doDouble(double) */) {
                if ((JSRuntime.isValidArrayLength(arg0Value_))) {
                    return ToArrayLengthNode.doDouble(arg0Value_);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 rangeError(double) */) {
                if ((!(JSRuntime.isValidArrayLength(arg0Value_)))) {
                    return ToArrayLengthNode.rangeError(arg0Value_);
                }
            }
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 typeNotNumber(Object) */) {
            if ((!(JSRuntime.isNumber(arg0Value)))) {
                return ToArrayLengthNode.typeNotNumber(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private long executeAndSpecialize(Object arg0Value) {
        int state_0 = this.state_0_;
        if (arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt(int) */;
            return ToArrayLengthNode.doInt(arg0Value_);
        }
        if (arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            if ((JSRuntime.isValidArrayLength(arg0Value_.longValue()))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doSafeInteger(SafeInteger) */;
                return ToArrayLengthNode.doSafeInteger(arg0Value_);
            }
            if ((!(JSRuntime.isValidArrayLength(arg0Value_.longValue())))) {
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 rangeError(SafeInteger) */;
                return ToArrayLengthNode.rangeError(arg0Value_);
            }
        }
        if (arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            if ((JSRuntime.isValidArrayLength(arg0Value_))) {
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doLong(long) */;
                return ToArrayLengthNode.doLong(arg0Value_);
            }
            if ((!(JSRuntime.isValidArrayLength(arg0Value_)))) {
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 rangeError(long) */;
                return ToArrayLengthNode.rangeError(arg0Value_);
            }
        }
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                if ((JSRuntime.isValidArrayLength(arg0Value_))) {
                    state_0 = (state_0 | (doubleCast0 << 8) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doDouble(double) */;
                    return ToArrayLengthNode.doDouble(arg0Value_);
                }
                if ((!(JSRuntime.isValidArrayLength(arg0Value_)))) {
                    state_0 = (state_0 | (doubleCast0 << 8) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 rangeError(double) */;
                    return ToArrayLengthNode.rangeError(arg0Value_);
                }
            }
        }
        if ((!(JSRuntime.isNumber(arg0Value)))) {
            this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 typeNotNumber(Object) */;
            return ToArrayLengthNode.typeNotNumber(arg0Value);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b11111111) & ((state_0 & 0b11111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[9];
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
        s[0] = "doSafeInteger";
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "rangeError";
        if ((state_0 & 0b100) != 0 /* is-state_0 rangeError(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "rangeError";
        if ((state_0 & 0b10000) != 0 /* is-state_0 rangeError(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "rangeError";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 rangeError(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "typeNotNumber";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 typeNotNumber(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        return Provider.create(data);
    }

    public static ToArrayLengthNode create() {
        return new ToArrayLengthNodeGen();
    }

}
