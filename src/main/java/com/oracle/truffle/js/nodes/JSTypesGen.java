// CheckStyle: start generated
package com.oracle.truffle.js.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.objects.JSLazyString;

@GeneratedBy(JSTypes.class)
public final class JSTypesGen extends JSTypes {

    @Deprecated public static final JSTypesGen J_S_TYPES = new JSTypesGen();

    protected JSTypesGen() {
    }

    public static boolean isBoolean(Object value) {
        return value instanceof Boolean;
    }

    public static boolean asBoolean(Object value) {
        assert value instanceof Boolean : "JSTypesGen.asBoolean: boolean expected";
        return (boolean) value;
    }

    public static boolean expectBoolean(Object value) throws UnexpectedResultException {
        if (value instanceof Boolean) {
            return (boolean) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isInteger(Object value) {
        return value instanceof Integer;
    }

    public static int asInteger(Object value) {
        assert value instanceof Integer : "JSTypesGen.asInteger: int expected";
        return (int) value;
    }

    public static int expectInteger(Object value) throws UnexpectedResultException {
        if (value instanceof Integer) {
            return (int) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isDouble(Object value) {
        return value instanceof Double;
    }

    public static double asDouble(Object value) {
        assert value instanceof Double : "JSTypesGen.asDouble: double expected";
        return (double) value;
    }

    public static double expectDouble(Object value) throws UnexpectedResultException {
        if (value instanceof Double) {
            return (double) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isLong(Object value) {
        return value instanceof Long;
    }

    public static long asLong(Object value) {
        assert value instanceof Long : "JSTypesGen.asLong: long expected";
        return (long) value;
    }

    public static long expectLong(Object value) throws UnexpectedResultException {
        if (value instanceof Long) {
            return (long) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isSafeInteger(Object value) {
        return value instanceof SafeInteger;
    }

    public static SafeInteger asSafeInteger(Object value) {
        assert value instanceof SafeInteger : "JSTypesGen.asSafeInteger: SafeInteger expected";
        return (SafeInteger) value;
    }

    public static SafeInteger expectSafeInteger(Object value) throws UnexpectedResultException {
        if (value instanceof SafeInteger) {
            return (SafeInteger) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isBigInt(Object value) {
        return value instanceof BigInt;
    }

    public static BigInt asBigInt(Object value) {
        assert value instanceof BigInt : "JSTypesGen.asBigInt: BigInt expected";
        return (BigInt) value;
    }

    public static BigInt expectBigInt(Object value) throws UnexpectedResultException {
        if (value instanceof BigInt) {
            return (BigInt) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isString(Object value) {
        return value instanceof String;
    }

    public static String asString(Object value) {
        assert value instanceof String : "JSTypesGen.asString: String expected";
        return (String) value;
    }

    public static String expectString(Object value) throws UnexpectedResultException {
        if (value instanceof String) {
            return (String) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static double expectImplicitDouble(int state, Object value) throws UnexpectedResultException {
        if ((state & 0b1) != 0 && value instanceof Long) {
            return longToDouble((long) value);
        } else if ((state & 0b10) != 0 && value instanceof Integer) {
            return intToDouble((int) value);
        } else if ((state & 0b100) != 0 && value instanceof Double) {
            return (double) value;
        } else if ((state & 0b1000) != 0 && value instanceof SafeInteger) {
            return safeIntegerToDouble((SafeInteger) value);
        } else {
            throw new UnexpectedResultException(value);
        }
    }

    public static boolean isImplicitDouble(int state, Object value) {
        return ((state & 0b1) != 0 && value instanceof Long)
             || ((state & 0b10) != 0 && value instanceof Integer)
             || ((state & 0b100) != 0 && value instanceof Double)
             || ((state & 0b1000) != 0 && value instanceof SafeInteger);
    }

    public static boolean isImplicitDouble(Object value) {
        return value instanceof Long
             || value instanceof Integer
             || value instanceof Double
             || value instanceof SafeInteger;
    }

    public static double asImplicitDouble(int state, Object value) {
        if ((state & 0b1) != 0 && value instanceof Long) {
            return longToDouble((long) value);
        } else if ((state & 0b10) != 0 && value instanceof Integer) {
            return intToDouble((int) value);
        } else if ((state & 0b100) != 0 && value instanceof Double) {
            return (double) value;
        } else if ((state & 0b1000) != 0 && value instanceof SafeInteger) {
            return safeIntegerToDouble((SafeInteger) value);
        } else {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Illegal implicit source type.");
        }
    }

    public static double asImplicitDouble(Object value) {
        if (value instanceof Long) {
            return longToDouble((long) value);
        } else if (value instanceof Integer) {
            return intToDouble((int) value);
        } else if (value instanceof Double) {
            return (double) value;
        } else if (value instanceof SafeInteger) {
            return safeIntegerToDouble((SafeInteger) value);
        } else {
            throw new IllegalArgumentException("Illegal implicit source type.");
        }
    }

    public static int specializeImplicitDouble(Object value) {
        if (value instanceof Long) {
            return 0b1;
        } else if (value instanceof Integer) {
            return 0b10;
        } else if (value instanceof Double) {
            return 0b100;
        } else if (value instanceof SafeInteger) {
            return 0b1000;
        } else {
            return 0;
        }
    }

    public static String expectImplicitString(int state, Object value) throws UnexpectedResultException {
        if ((state & 0b1) != 0 && value instanceof String) {
            return (String) value;
        } else if ((state & 0b10) != 0 && JSTypes.isLazyStringRaw(value)) {
            return convertLazyStringRaw(JSTypes.asLazyStringRaw(value));
        } else if ((state & 0b100) != 0 && JSTypes.isLazyStringFlattened(value)) {
            return convertLazyStringFlattened(JSTypes.asLazyStringFlattened(value));
        } else {
            throw new UnexpectedResultException(value);
        }
    }

    public static boolean isImplicitString(int state, Object value) {
        return ((state & 0b1) != 0 && value instanceof String)
             || ((state & 0b10) != 0 && JSTypes.isLazyStringRaw(value))
             || ((state & 0b100) != 0 && JSTypes.isLazyStringFlattened(value));
    }

    public static boolean isImplicitString(Object value) {
        return value instanceof String
             || JSTypes.isLazyStringRaw(value)
             || JSTypes.isLazyStringFlattened(value);
    }

    public static String asImplicitString(int state, Object value) {
        if ((state & 0b1) != 0 && value instanceof String) {
            return (String) value;
        } else if ((state & 0b10) != 0 && JSTypes.isLazyStringRaw(value)) {
            return convertLazyStringRaw(JSTypes.asLazyStringRaw(value));
        } else if ((state & 0b100) != 0 && JSTypes.isLazyStringFlattened(value)) {
            return convertLazyStringFlattened(JSTypes.asLazyStringFlattened(value));
        } else {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Illegal implicit source type.");
        }
    }

    public static String asImplicitString(Object value) {
        if (value instanceof String) {
            return (String) value;
        } else if (JSTypes.isLazyStringRaw(value)) {
            return convertLazyStringRaw(JSTypes.asLazyStringRaw(value));
        } else if (JSTypes.isLazyStringFlattened(value)) {
            return convertLazyStringFlattened(JSTypes.asLazyStringFlattened(value));
        } else {
            throw new IllegalArgumentException("Illegal implicit source type.");
        }
    }

    public static int specializeImplicitString(Object value) {
        if (value instanceof String) {
            return 0b1;
        } else if (JSTypes.isLazyStringRaw(value)) {
            return 0b10;
        } else if (JSTypes.isLazyStringFlattened(value)) {
            return 0b100;
        } else {
            return 0;
        }
    }

    public static CharSequence expectImplicitCharSequence(int state, Object value) throws UnexpectedResultException {
        if ((state & 0b1) != 0 && value instanceof String) {
            return castCharSequence((String) value);
        } else if ((state & 0b10) != 0 && value instanceof JSLazyString) {
            return castCharSequence((JSLazyString) value);
        } else if ((state & 0b100) != 0 && JSTypes.isCharSequence(value)) {
            return (CharSequence) value;
        } else {
            throw new UnexpectedResultException(value);
        }
    }

    public static boolean isImplicitCharSequence(int state, Object value) {
        return ((state & 0b1) != 0 && value instanceof String)
             || ((state & 0b10) != 0 && value instanceof JSLazyString)
             || ((state & 0b100) != 0 && JSTypes.isCharSequence(value));
    }

    public static boolean isImplicitCharSequence(Object value) {
        return value instanceof String
             || value instanceof JSLazyString
             || JSTypes.isCharSequence(value);
    }

    public static CharSequence asImplicitCharSequence(int state, Object value) {
        if ((state & 0b1) != 0 && value instanceof String) {
            return castCharSequence((String) value);
        } else if ((state & 0b10) != 0 && value instanceof JSLazyString) {
            return castCharSequence((JSLazyString) value);
        } else if ((state & 0b100) != 0 && JSTypes.isCharSequence(value)) {
            return (CharSequence) value;
        } else {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Illegal implicit source type.");
        }
    }

    public static CharSequence asImplicitCharSequence(Object value) {
        if (value instanceof String) {
            return castCharSequence((String) value);
        } else if (value instanceof JSLazyString) {
            return castCharSequence((JSLazyString) value);
        } else if (JSTypes.isCharSequence(value)) {
            return (CharSequence) value;
        } else {
            throw new IllegalArgumentException("Illegal implicit source type.");
        }
    }

    public static int specializeImplicitCharSequence(Object value) {
        if (value instanceof String) {
            return 0b1;
        } else if (value instanceof JSLazyString) {
            return 0b10;
        } else if (JSTypes.isCharSequence(value)) {
            return 0b100;
        } else {
            return 0;
        }
    }

}
