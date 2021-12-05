/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oracle.truffle.api.interop;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.source.SourceSection;

@SuppressWarnings("unused")
@ExportLibrary(value = InteropLibrary.class, receiverType = Float.class)
final class DefaultFloatExports {

    // slow method
    @ExportMessage
    static boolean fitsInByte(Float receiver) {
        float f = receiver;
        byte b = (byte) f;
        if (b == f && !NumberUtils.isNegativeZero(f)) {
            return true;
        }

        return false;
    }

    @ExportMessage
    static boolean fitsInInt(Float receiver) {
        float f = receiver;
        if (NumberUtils.inSafeIntegerRange(f) && !NumberUtils.isNegativeZero(f)) {
            int i = (int) f;
            if (i == f) {
                return true;
            }
        }
        return false;
    }

    @ExportMessage
    static boolean fitsInShort(Float receiver) {
        float f = receiver;
        short s = (short) f;
        if (s == f && !NumberUtils.isNegativeZero(f)) {
            return true;
        }
        return false;
    }

    @ExportMessage
    static boolean fitsInLong(Float receiver) {
        float f = receiver;
        if (NumberUtils.inSafeIntegerRange(f) && !NumberUtils.isNegativeZero(f)) {
            long l = (long) f;
            if (l == f) {
                return true;
            }
        }
        return false;
    }

    @ExportMessage
    static byte asByte(Float receiver) throws UnsupportedMessageException {
        float f = receiver;
        byte b = (byte) f;
        if (b == f && !NumberUtils.isNegativeZero(f)) {
            return b;
        }
        throw UnsupportedMessageException.create();
    }

    @ExportMessage
    static short asShort(Float receiver) throws UnsupportedMessageException {
        float f = receiver;
        short s = (short) f;
        if (s == f && !NumberUtils.isNegativeZero(f)) {
            return s;
        }
        throw UnsupportedMessageException.create();
    }

    @ExportMessage
    static int asInt(Float receiver) throws UnsupportedMessageException {

        float f = receiver;
        if (NumberUtils.inSafeIntegerRange(f) && !NumberUtils.isNegativeZero(f)) {
            int i = (int) f;
            if (i == f) {
                return i;
            }
        }
        throw UnsupportedMessageException.create();
    }

    @ExportMessage
    static long asLong(Float receiver) throws UnsupportedMessageException {
        float f = receiver;
        if (NumberUtils.inSafeIntegerRange(f) && !NumberUtils.isNegativeZero(f)) {
            long l = (long) f;
            if (l == f) {
                return l;
            }
        }
        throw UnsupportedMessageException.create();
    }

    // fast methods
    @ExportMessage
    static boolean isNumber(Float receiver) {
        return true;
    }

    @ExportMessage
    static boolean fitsInFloat(Float receiver) {
        return true;
    }

    @ExportMessage
    static float asFloat(Float receiver) {
        return receiver;
    }

    @ExportMessage
    static boolean fitsInDouble(Float receiver) {
        return true;
    }

    @ExportMessage
    static double asDouble(Float receiver) {
        return receiver;
    }

    /*
     * We export these messages explicitly because the legacy default is very costly. Remove with
     * the complicated legacy implementation in InteropLibrary.
     */
    @ExportMessage
    static boolean hasLanguage(Float receiver) {
        return false;
    }

    @ExportMessage
    static Class<? extends TruffleLanguage<?>> getLanguage(Float receiver) throws UnsupportedMessageException {
        throw UnsupportedMessageException.create();
    }

    @ExportMessage
    static boolean hasSourceLocation(Float receiver) {
        return false;
    }

    @ExportMessage
    static SourceSection getSourceLocation(Float receiver) throws UnsupportedMessageException {
        throw UnsupportedMessageException.create();
    }

    @ExportMessage
    static boolean hasMetaObject(Float receiver) {
        return false;
    }

    @ExportMessage
    static Object getMetaObject(Float receiver) throws UnsupportedMessageException {
        throw UnsupportedMessageException.create();
    }

    @ExportMessage
    @TruffleBoundary
    static Object toDisplayString(Float receiver, boolean allowSideEffects) {
        return receiver.toString();
    }

}
