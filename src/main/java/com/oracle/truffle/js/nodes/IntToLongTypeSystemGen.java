// CheckStyle: start generated
package com.oracle.truffle.js.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

@GeneratedBy(IntToLongTypeSystem.class)
public final class IntToLongTypeSystemGen extends IntToLongTypeSystem {

    @Deprecated public static final IntToLongTypeSystemGen INT_TO_LONG_TYPE_SYSTEM = new IntToLongTypeSystemGen();

    protected IntToLongTypeSystemGen() {
    }

    public static long expectImplicitLong(int state, Object value) throws UnexpectedResultException {
        if ((state & 0b1) != 0 && value instanceof Long) {
            return (long) value;
        } else if ((state & 0b10) != 0 && value instanceof Integer) {
            return intToLong((int) value);
        } else {
            throw new UnexpectedResultException(value);
        }
    }

    public static boolean isImplicitLong(int state, Object value) {
        return ((state & 0b1) != 0 && value instanceof Long)
             || ((state & 0b10) != 0 && value instanceof Integer);
    }

    public static boolean isImplicitLong(Object value) {
        return value instanceof Long
             || value instanceof Integer;
    }

    public static long asImplicitLong(int state, Object value) {
        if ((state & 0b1) != 0 && value instanceof Long) {
            return (long) value;
        } else if ((state & 0b10) != 0 && value instanceof Integer) {
            return intToLong((int) value);
        } else {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Illegal implicit source type.");
        }
    }

    public static long asImplicitLong(Object value) {
        if (value instanceof Long) {
            return (long) value;
        } else if (value instanceof Integer) {
            return intToLong((int) value);
        } else {
            throw new IllegalArgumentException("Illegal implicit source type.");
        }
    }

    public static int specializeImplicitLong(Object value) {
        if (value instanceof Long) {
            return 0b1;
        } else if (value instanceof Integer) {
            return 0b10;
        } else {
            return 0;
        }
    }

}
