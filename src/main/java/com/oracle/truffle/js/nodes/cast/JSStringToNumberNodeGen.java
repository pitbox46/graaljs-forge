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
import com.oracle.truffle.api.nodes.SlowPathException;
import com.oracle.truffle.api.profiles.ConditionProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSStringToNumberNode.class)
public final class JSStringToNumberNodeGen extends JSStringToNumberNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile infinity_endsWithInfinity_;

    private JSStringToNumberNodeGen() {
    }

    @Override
    protected double executeNoTrim(String arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111111111111) != 0 /* is-state_0 doLengthIsZero(String) || doInfinity(String, ConditionProfile) || doNaN(String) || doHexSafe(String) || doHex(String) || doOctalSafe(String) || doOctal(String) || doBinarySafe(String) || doBinary(String) || doSmallPosInt(String) || doInteger(String) || doDouble(String) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doLengthIsZero(String) */) {
                if ((arg0Value.length() == 0)) {
                    return doLengthIsZero(arg0Value);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doInfinity(String, ConditionProfile) */) {
                if ((JSStringToNumberNode.startsWithI(arg0Value))) {
                    return doInfinity(arg0Value, this.infinity_endsWithInfinity_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doNaN(String) */) {
                if ((arg0Value.length() > 0) && (!(JSStringToNumberNode.startsWithI(arg0Value))) && (!(JSStringToNumberNode.startsWithValidDouble(arg0Value))) && (!(JSStringToNumberNode.isHex(arg0Value))) && (!(JSStringToNumberNode.isOctal(arg0Value))) && (!(JSStringToNumberNode.isBinary(arg0Value)))) {
                    return doNaN(arg0Value);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doHexSafe(String) */) {
                if ((JSStringToNumberNode.isHex(arg0Value)) && (arg0Value.length() <= JSStringToNumberNode.SAFE_HEX_DIGITS)) {
                    return doHexSafe(arg0Value);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doHex(String) */) {
                if ((JSStringToNumberNode.isHex(arg0Value)) && (arg0Value.length() > JSStringToNumberNode.SAFE_HEX_DIGITS)) {
                    return doHex(arg0Value);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doOctalSafe(String) */) {
                if ((JSStringToNumberNode.isOctal(arg0Value)) && (arg0Value.length() <= JSStringToNumberNode.SAFE_OCTAL_DIGITS)) {
                    return doOctalSafe(arg0Value);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doOctal(String) */) {
                if ((JSStringToNumberNode.isOctal(arg0Value)) && (arg0Value.length() > JSStringToNumberNode.SAFE_OCTAL_DIGITS)) {
                    return doOctal(arg0Value);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doBinarySafe(String) */) {
                if ((JSStringToNumberNode.isBinary(arg0Value)) && (arg0Value.length() <= JSStringToNumberNode.SAFE_BINARY_DIGITS)) {
                    return doBinarySafe(arg0Value);
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doBinary(String) */) {
                if ((JSStringToNumberNode.isBinary(arg0Value)) && (arg0Value.length() > JSStringToNumberNode.SAFE_BINARY_DIGITS)) {
                    return doBinary(arg0Value);
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doSmallPosInt(String) */) {
                if ((arg0Value.length() > 0) && (arg0Value.length() <= JSStringToNumberNode.SMALL_INT_LENGTH) && (JSStringToNumberNode.allDigits(arg0Value, JSStringToNumberNode.SMALL_INT_LENGTH))) {
                    return doSmallPosInt(arg0Value);
                }
            }
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doInteger(String) */) {
                if ((arg0Value.length() > 0) && (arg0Value.length() <= JSStringToNumberNode.MAX_SAFE_INTEGER_LENGTH) && (JSStringToNumberNode.startsWithValidInt(arg0Value))) {
                    try {
                        return doInteger(arg0Value);
                    } catch (SlowPathException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b10 /* add-exclude doInteger(String) */;
                            this.state_0_ = this.state_0_ & 0xfffffbff /* remove-state_0 doInteger(String) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(arg0Value);
                    }
                }
            }
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doDouble(String) */) {
                if ((arg0Value.length() > 0) && (JSStringToNumberNode.startsWithValidDouble(arg0Value))) {
                    return doDouble(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private double executeAndSpecialize(String arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((arg0Value.length() == 0)) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doLengthIsZero(String) */;
                lock.unlock();
                hasLock = false;
                return doLengthIsZero(arg0Value);
            }
            if ((JSStringToNumberNode.startsWithI(arg0Value))) {
                this.infinity_endsWithInfinity_ = (ConditionProfile.createBinaryProfile());
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doInfinity(String, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doInfinity(arg0Value, this.infinity_endsWithInfinity_);
            }
            if ((arg0Value.length() > 0) && (!(JSStringToNumberNode.startsWithI(arg0Value))) && (!(JSStringToNumberNode.startsWithValidDouble(arg0Value))) && (!(JSStringToNumberNode.isHex(arg0Value))) && (!(JSStringToNumberNode.isOctal(arg0Value))) && (!(JSStringToNumberNode.isBinary(arg0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doNaN(String) */;
                lock.unlock();
                hasLock = false;
                return doNaN(arg0Value);
            }
            if ((JSStringToNumberNode.isHex(arg0Value)) && (arg0Value.length() <= JSStringToNumberNode.SAFE_HEX_DIGITS)) {
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doHexSafe(String) */;
                lock.unlock();
                hasLock = false;
                return doHexSafe(arg0Value);
            }
            if ((JSStringToNumberNode.isHex(arg0Value)) && (arg0Value.length() > JSStringToNumberNode.SAFE_HEX_DIGITS)) {
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doHex(String) */;
                lock.unlock();
                hasLock = false;
                return doHex(arg0Value);
            }
            if ((JSStringToNumberNode.isOctal(arg0Value)) && (arg0Value.length() <= JSStringToNumberNode.SAFE_OCTAL_DIGITS)) {
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doOctalSafe(String) */;
                lock.unlock();
                hasLock = false;
                return doOctalSafe(arg0Value);
            }
            if ((JSStringToNumberNode.isOctal(arg0Value)) && (arg0Value.length() > JSStringToNumberNode.SAFE_OCTAL_DIGITS)) {
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doOctal(String) */;
                lock.unlock();
                hasLock = false;
                return doOctal(arg0Value);
            }
            if ((JSStringToNumberNode.isBinary(arg0Value)) && (arg0Value.length() <= JSStringToNumberNode.SAFE_BINARY_DIGITS)) {
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doBinarySafe(String) */;
                lock.unlock();
                hasLock = false;
                return doBinarySafe(arg0Value);
            }
            if ((JSStringToNumberNode.isBinary(arg0Value)) && (arg0Value.length() > JSStringToNumberNode.SAFE_BINARY_DIGITS)) {
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doBinary(String) */;
                lock.unlock();
                hasLock = false;
                return doBinary(arg0Value);
            }
            if (((exclude & 0b1)) == 0 /* is-not-exclude doSmallPosInt(String) */) {
                if ((arg0Value.length() > 0) && (arg0Value.length() <= JSStringToNumberNode.SMALL_INT_LENGTH) && (JSStringToNumberNode.allDigits(arg0Value, JSStringToNumberNode.SMALL_INT_LENGTH))) {
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doSmallPosInt(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doSmallPosInt(arg0Value);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doInteger(String) */) {
                if ((arg0Value.length() > 0) && (arg0Value.length() <= JSStringToNumberNode.MAX_SAFE_INTEGER_LENGTH) && (JSStringToNumberNode.startsWithValidInt(arg0Value))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doSmallPosInt(String) */;
                    state_0 = state_0 & 0xfffffdff /* remove-state_0 doSmallPosInt(String) */;
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doInteger(String) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return doInteger(arg0Value);
                    } catch (SlowPathException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b10 /* add-exclude doInteger(String) */;
                            this.state_0_ = this.state_0_ & 0xfffffbff /* remove-state_0 doInteger(String) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(arg0Value);
                    }
                }
            }
            if ((arg0Value.length() > 0) && (JSStringToNumberNode.startsWithValidDouble(arg0Value))) {
                this.exclude_ = exclude = exclude | 0b11 /* add-exclude doSmallPosInt(String), doInteger(String) */;
                state_0 = state_0 & 0xfffff9ff /* remove-state_0 doSmallPosInt(String), doInteger(String) */;
                this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doDouble(String) */;
                lock.unlock();
                hasLock = false;
                return doDouble(arg0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b111111111111) & ((state_0 & 0b111111111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[13];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doLengthIsZero";
        if ((state_0 & 0b1) != 0 /* is-state_0 doLengthIsZero(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInfinity";
        if ((state_0 & 0b10) != 0 /* is-state_0 doInfinity(String, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.infinity_endsWithInfinity_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doNaN";
        if ((state_0 & 0b100) != 0 /* is-state_0 doNaN(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doHexSafe";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doHexSafe(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doHex";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doHex(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doOctalSafe";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doOctalSafe(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doOctal";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doOctal(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doBinarySafe";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doBinarySafe(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doBinary";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doBinary(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doSmallPosInt";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doSmallPosInt(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doSmallPosInt(String) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doInteger(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-exclude doInteger(String) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doDouble(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        return Provider.create(data);
    }

    public static JSStringToNumberNode create() {
        return new JSStringToNumberNodeGen();
    }

}
