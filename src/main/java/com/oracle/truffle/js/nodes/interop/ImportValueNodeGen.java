// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.GraalJSException;
import com.oracle.truffle.js.runtime.interop.InteropFunction;

@GeneratedBy(ImportValueNode.class)
public final class ImportValueNodeGen extends ImportValueNode implements Introspection.Provider {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private int state_0_;

    private ImportValueNodeGen() {
    }

    @Override
    public Object executeWithTarget(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 fromInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return ImportValueNode.fromInt(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 fromString(String) */ && JSTypesGen.isImplicitString((state_0 & 0x70000) >>> 16 /* extract-implicit-state_0 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state_0 & 0x70000) >>> 16 /* extract-implicit-state_0 0:String */, arg0Value);
            return ImportValueNode.fromString(arg0Value_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 fromBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return ImportValueNode.fromBoolean(arg0Value_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 fromBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return ImportValueNode.fromBigInt(arg0Value_);
        }
        if ((state_0 & 0b110000) != 0 /* is-state_0 fromLongToInt(long) || fromLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            if ((state_0 & 0b10000) != 0 /* is-state_0 fromLongToInt(long) */) {
                if ((JSGuards.isLongRepresentableAsInt32(arg0Value_))) {
                    return ImportValueNode.fromLongToInt(arg0Value_);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 fromLong(long) */) {
                if ((!(JSGuards.isLongRepresentableAsInt32(arg0Value_)))) {
                    return ImportValueNode.fromLong(arg0Value_);
                }
            }
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 fromDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x780000) >>> 19 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0x780000) >>> 19 /* extract-implicit-state_0 0:double */, arg0Value);
            return ImportValueNode.fromDouble(arg0Value_);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 fromNumber(byte) */ && arg0Value instanceof Byte) {
            byte arg0Value_ = (byte) arg0Value;
            return ImportValueNode.fromNumber(arg0Value_);
        }
        if ((state_0 & 0b100000000) != 0 /* is-state_0 fromNumber(short) */ && arg0Value instanceof Short) {
            short arg0Value_ = (short) arg0Value;
            return ImportValueNode.fromNumber(arg0Value_);
        }
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 fromNumber(float) */ && arg0Value instanceof Float) {
            float arg0Value_ = (float) arg0Value;
            return ImportValueNode.fromNumber(arg0Value_);
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 fromChar(char) */ && arg0Value instanceof Character) {
            char arg0Value_ = (char) arg0Value;
            return ImportValueNode.fromChar(arg0Value_);
        }
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 fromDynamicObject(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            return ImportValueNode.fromDynamicObject(arg0Value_);
        }
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 fromInteropFunction(InteropFunction) */ && arg0Value instanceof InteropFunction) {
            InteropFunction arg0Value_ = (InteropFunction) arg0Value;
            return ImportValueNode.fromInteropFunction(arg0Value_);
        }
        if ((state_0 & 0b10000000000000) != 0 /* is-state_0 fromJSException(GraalJSException) */ && arg0Value instanceof GraalJSException) {
            GraalJSException arg0Value_ = (GraalJSException) arg0Value;
            return ImportValueNode.fromJSException(arg0Value_);
        }
        if ((state_0 & 0b100000000000000) != 0 /* is-state_0 fromTruffleObject(TruffleObject) */ && arg0Value instanceof TruffleObject) {
            TruffleObject arg0Value_ = (TruffleObject) arg0Value;
            if ((!(ImportValueNode.isSpecial(arg0Value_)))) {
                return ImportValueNode.fromTruffleObject(arg0Value_);
            }
        }
        if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 fallbackCase(Object) */) {
            if (fallbackGuard_(state_0, arg0Value)) {
                return ImportValueNode.fallbackCase(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object arg0Value) {
        int state_0 = this.state_0_;
        if (arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 fromInt(int) */;
            return ImportValueNode.fromInt(arg0Value_);
        }
        {
            int stringCast0;
            if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                state_0 = (state_0 | (stringCast0 << 16) /* set-implicit-state_0 0:String */);
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 fromString(String) */;
                return ImportValueNode.fromString(arg0Value_);
            }
        }
        if (arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 fromBoolean(boolean) */;
            return ImportValueNode.fromBoolean(arg0Value_);
        }
        if (arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 fromBigInt(BigInt) */;
            return ImportValueNode.fromBigInt(arg0Value_);
        }
        if (arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            if ((JSGuards.isLongRepresentableAsInt32(arg0Value_))) {
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 fromLongToInt(long) */;
                return ImportValueNode.fromLongToInt(arg0Value_);
            }
            if ((!(JSGuards.isLongRepresentableAsInt32(arg0Value_)))) {
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 fromLong(long) */;
                return ImportValueNode.fromLong(arg0Value_);
            }
        }
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                state_0 = (state_0 | (doubleCast0 << 19) /* set-implicit-state_0 0:double */);
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 fromDouble(double) */;
                return ImportValueNode.fromDouble(arg0Value_);
            }
        }
        if (arg0Value instanceof Byte) {
            byte arg0Value_ = (byte) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 fromNumber(byte) */;
            return ImportValueNode.fromNumber(arg0Value_);
        }
        if (arg0Value instanceof Short) {
            short arg0Value_ = (short) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 fromNumber(short) */;
            return ImportValueNode.fromNumber(arg0Value_);
        }
        if (arg0Value instanceof Float) {
            float arg0Value_ = (float) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 fromNumber(float) */;
            return ImportValueNode.fromNumber(arg0Value_);
        }
        if (arg0Value instanceof Character) {
            char arg0Value_ = (char) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 fromChar(char) */;
            return ImportValueNode.fromChar(arg0Value_);
        }
        if (JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 fromDynamicObject(DynamicObject) */;
            return ImportValueNode.fromDynamicObject(arg0Value_);
        }
        if (arg0Value instanceof InteropFunction) {
            InteropFunction arg0Value_ = (InteropFunction) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 fromInteropFunction(InteropFunction) */;
            return ImportValueNode.fromInteropFunction(arg0Value_);
        }
        if (arg0Value instanceof GraalJSException) {
            GraalJSException arg0Value_ = (GraalJSException) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 fromJSException(GraalJSException) */;
            return ImportValueNode.fromJSException(arg0Value_);
        }
        if (arg0Value instanceof TruffleObject) {
            TruffleObject arg0Value_ = (TruffleObject) arg0Value;
            if ((!(ImportValueNode.isSpecial(arg0Value_)))) {
                this.state_0_ = state_0 = state_0 | 0b100000000000000 /* add-state_0 fromTruffleObject(TruffleObject) */;
                return ImportValueNode.fromTruffleObject(arg0Value_);
            }
        }
        this.state_0_ = state_0 = state_0 | 0b1000000000000000 /* add-state_0 fallbackCase(Object) */;
        return ImportValueNode.fallbackCase(arg0Value);
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1111111111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111111111111111) & ((state_0 & 0b1111111111111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[17];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "fromInt";
        if ((state_0 & 0b1) != 0 /* is-state_0 fromInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "fromString";
        if ((state_0 & 0b10) != 0 /* is-state_0 fromString(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "fromBoolean";
        if ((state_0 & 0b100) != 0 /* is-state_0 fromBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "fromBigInt";
        if ((state_0 & 0b1000) != 0 /* is-state_0 fromBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "fromLongToInt";
        if ((state_0 & 0b10000) != 0 /* is-state_0 fromLongToInt(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "fromLong";
        if ((state_0 & 0b100000) != 0 /* is-state_0 fromLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "fromDouble";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 fromDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "fromNumber";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 fromNumber(byte) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "fromNumber";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 fromNumber(short) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "fromNumber";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 fromNumber(float) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "fromChar";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 fromChar(char) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "fromDynamicObject";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 fromDynamicObject(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "fromInteropFunction";
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 fromInteropFunction(InteropFunction) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "fromJSException";
        if ((state_0 & 0b10000000000000) != 0 /* is-state_0 fromJSException(GraalJSException) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        s = new Object[3];
        s[0] = "fromTruffleObject";
        if ((state_0 & 0b100000000000000) != 0 /* is-state_0 fromTruffleObject(TruffleObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[15] = s;
        s = new Object[3];
        s[0] = "fallbackCase";
        if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 fallbackCase(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[16] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state_0, Object arg0Value) {
        if (JSTypesGen.isImplicitString(arg0Value)) {
            return false;
        }
        if (((state_0 & 0b100)) == 0 /* is-not-state_0 fromBoolean(boolean) */ && arg0Value instanceof Boolean) {
            return false;
        }
        if (((state_0 & 0b1000)) == 0 /* is-not-state_0 fromBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            return false;
        }
        if (JSTypesGen.isImplicitDouble(arg0Value)) {
            return false;
        }
        if (((state_0 & 0b10000000)) == 0 /* is-not-state_0 fromNumber(byte) */ && arg0Value instanceof Byte) {
            return false;
        }
        if (((state_0 & 0b100000000)) == 0 /* is-not-state_0 fromNumber(short) */ && arg0Value instanceof Short) {
            return false;
        }
        if (((state_0 & 0b1000000000)) == 0 /* is-not-state_0 fromNumber(float) */ && arg0Value instanceof Float) {
            return false;
        }
        if (((state_0 & 0b10000000000)) == 0 /* is-not-state_0 fromChar(char) */ && arg0Value instanceof Character) {
            return false;
        }
        if (((state_0 & 0b100000000000)) == 0 /* is-not-state_0 fromDynamicObject(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            return false;
        }
        if (((state_0 & 0b1000000000000)) == 0 /* is-not-state_0 fromInteropFunction(InteropFunction) */ && arg0Value instanceof InteropFunction) {
            return false;
        }
        if (((state_0 & 0b10000000000000)) == 0 /* is-not-state_0 fromJSException(GraalJSException) */ && arg0Value instanceof GraalJSException) {
            return false;
        }
        if (arg0Value instanceof TruffleObject) {
            TruffleObject arg0Value_ = (TruffleObject) arg0Value;
            if ((!(ImportValueNode.isSpecial(arg0Value_)))) {
                return false;
            }
        }
        return true;
    }

    public static ImportValueNode create() {
        return new ImportValueNodeGen();
    }

    public static ImportValueNode getUncached() {
        return ImportValueNodeGen.UNCACHED;
    }

    @GeneratedBy(ImportValueNode.class)
    private static final class Uncached extends ImportValueNode {

        @TruffleBoundary
        @Override
        public Object executeWithTarget(Object arg0Value) {
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                return ImportValueNode.fromInt(arg0Value_);
            }
            if (JSTypesGen.isImplicitString(arg0Value)) {
                String arg0Value_ = JSTypesGen.asImplicitString(arg0Value);
                return ImportValueNode.fromString(arg0Value_);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                return ImportValueNode.fromBoolean(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                return ImportValueNode.fromBigInt(arg0Value_);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                if ((JSGuards.isLongRepresentableAsInt32(arg0Value_))) {
                    return ImportValueNode.fromLongToInt(arg0Value_);
                }
                if ((!(JSGuards.isLongRepresentableAsInt32(arg0Value_)))) {
                    return ImportValueNode.fromLong(arg0Value_);
                }
            }
            if (JSTypesGen.isImplicitDouble(arg0Value)) {
                double arg0Value_ = JSTypesGen.asImplicitDouble(arg0Value);
                return ImportValueNode.fromDouble(arg0Value_);
            }
            if (arg0Value instanceof Byte) {
                byte arg0Value_ = (byte) arg0Value;
                return ImportValueNode.fromNumber(arg0Value_);
            }
            if (arg0Value instanceof Short) {
                short arg0Value_ = (short) arg0Value;
                return ImportValueNode.fromNumber(arg0Value_);
            }
            if (arg0Value instanceof Float) {
                float arg0Value_ = (float) arg0Value;
                return ImportValueNode.fromNumber(arg0Value_);
            }
            if (arg0Value instanceof Character) {
                char arg0Value_ = (char) arg0Value;
                return ImportValueNode.fromChar(arg0Value_);
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                return ImportValueNode.fromDynamicObject(arg0Value_);
            }
            if (arg0Value instanceof InteropFunction) {
                InteropFunction arg0Value_ = (InteropFunction) arg0Value;
                return ImportValueNode.fromInteropFunction(arg0Value_);
            }
            if (arg0Value instanceof GraalJSException) {
                GraalJSException arg0Value_ = (GraalJSException) arg0Value;
                return ImportValueNode.fromJSException(arg0Value_);
            }
            if (arg0Value instanceof TruffleObject) {
                TruffleObject arg0Value_ = (TruffleObject) arg0Value;
                if ((!(ImportValueNode.isSpecial(arg0Value_)))) {
                    return ImportValueNode.fromTruffleObject(arg0Value_);
                }
            }
            return ImportValueNode.fallbackCase(arg0Value);
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
