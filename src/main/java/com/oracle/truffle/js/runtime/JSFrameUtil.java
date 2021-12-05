/*
 * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.js.runtime;

import com.oracle.js.parser.ir.Symbol;
import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.objects.Undefined;
import com.oracle.truffle.js.runtime.util.InternalSlotId;

public final class JSFrameUtil {
    public static final MaterializedFrame NULL_MATERIALIZED_FRAME = Truffle.getRuntime().createMaterializedFrame(JSArguments.createNullArguments());
    public static final Object DEFAULT_VALUE = Undefined.instance;

    private static final String THIS_SLOT_ID = "<this>";
    private static final Class<? extends MaterializedFrame> MATERIALIZED_FRAME_CLASS = NULL_MATERIALIZED_FRAME.getClass();
    private static final int IS_LET = Symbol.IS_LET;
    private static final int IS_CONST = Symbol.IS_CONST;
    private static final int HAS_TDZ = IS_LET | IS_CONST;
    private static final int IS_HOISTABLE_DECLARATION = Symbol.IS_HOISTABLE_DECLARATION;
    private static final int IS_IMPORT_BINDING = Symbol.IS_IMPORT_BINDING;
    private static final int IS_PRIVATE_NAME_STATIC = Symbol.IS_PRIVATE_NAME_STATIC;
    private static final int IS_PRIVATE_METHOD_OR_ACCESSOR = Symbol.IS_PRIVATE_NAME_METHOD | Symbol.IS_PRIVATE_NAME_ACCESSOR;
    private static final int IS_PARAM = Symbol.IS_PARAM;
    private static final int IS_ARGUMENTS = Symbol.IS_ARGUMENTS;
    public static final int SYMBOL_FLAG_MASK = HAS_TDZ | IS_HOISTABLE_DECLARATION | IS_IMPORT_BINDING | IS_PRIVATE_NAME_STATIC | IS_PRIVATE_METHOD_OR_ACCESSOR | IS_PARAM | IS_ARGUMENTS;

    private JSFrameUtil() {
        // this utility class should not be instantiated
    }

    public static Object getThisObj(Frame frame) {
        return JSArguments.getThisObject(frame.getArguments());
    }

    public static DynamicObject getFunctionObject(Frame frame) {
        return (DynamicObject) JSArguments.getFunctionObject(frame.getArguments());
    }

    public static Object[] getArgumentsArray(Frame frame) {
        return JSArguments.extractUserArguments(frame.getArguments());
    }

    public static int getFlags(FrameSlot frameSlot) {
        return frameSlot.getInfo() instanceof Integer ? (int) frameSlot.getInfo() : 0;
    }

    public static boolean hasTemporalDeadZone(FrameSlot frameSlot) {
        return (getFlags(frameSlot) & HAS_TDZ) != 0;
    }

    public static boolean needsTemporalDeadZoneCheck(FrameSlot frameSlot, int frameLevel) {
        return hasTemporalDeadZone(frameSlot) && frameLevel != 0;
    }

    public static boolean isConst(FrameSlot frameSlot) {
        return (getFlags(frameSlot) & IS_CONST) != 0;
    }

    public static boolean isLet(FrameSlot frameSlot) {
        return (getFlags(frameSlot) & IS_LET) != 0;
    }

    public static boolean isHoistable(FrameSlot frameSlot) {
        return (getFlags(frameSlot) & IS_HOISTABLE_DECLARATION) != 0;
    }

    public static boolean isImportBinding(FrameSlot frameSlot) {
        return (getFlags(frameSlot) & IS_IMPORT_BINDING) != 0;
    }

    public static boolean needsPrivateBrandCheck(FrameSlot frameSlot) {
        return (getFlags(frameSlot) & IS_PRIVATE_METHOD_OR_ACCESSOR) != 0;
    }

    public static boolean isPrivateNameStatic(FrameSlot frameSlot) {
        return (getFlags(frameSlot) & IS_PRIVATE_NAME_STATIC) != 0;
    }

    public static boolean isParam(FrameSlot frameSlot) {
        return (getFlags(frameSlot) & IS_PARAM) != 0;
    }

    public static boolean isArguments(FrameSlot frameSlot) {
        return (getFlags(frameSlot) & IS_ARGUMENTS) != 0;
    }

    public static MaterializedFrame getParentFrame(Frame frame) {
        return JSArguments.getEnclosingFrame(frame.getArguments());
    }

    public static MaterializedFrame castMaterializedFrame(Object frame) {
        return MATERIALIZED_FRAME_CLASS.cast(frame);
    }

    /**
     * Returns true if the frame slot is implementation-internal.
     */
    public static boolean isInternal(FrameSlot frameSlot) {
        CompilerAsserts.neverPartOfCompilation();
        if (frameSlot.getIdentifier() instanceof String) {
            String name = (String) frameSlot.getIdentifier();
            if (name.startsWith(":")) {
                return true;
            } else if (name.startsWith("<") && name.endsWith(">")) {
                return true;
            }
            return false;
        } else if (frameSlot.getIdentifier() instanceof InternalSlotId) {
            return true;
        }
        return true;
    }

    @TruffleBoundary
    public static String getPublicName(FrameSlot frameSlot) {
        CompilerAsserts.neverPartOfCompilation();
        Object identifier = frameSlot.getIdentifier();
        if (frameSlot.getIdentifier() instanceof String) {
            String name = (String) frameSlot.getIdentifier();
            if (name.startsWith(":")) {
                return name.substring(1);
            } else if (name.startsWith("<") && name.endsWith(">")) {
                return name.substring(1, name.length() - 1);
            } else {
                return name;
            }
        } else {
            return identifier.toString();
        }
    }

    public static boolean isThisSlot(FrameSlot frameSlot) {
        return frameSlot.getIdentifier().equals(THIS_SLOT_ID);
    }

    public static FrameSlot getThisSlot(FrameDescriptor frameDescriptor) {
        return frameDescriptor.findFrameSlot(THIS_SLOT_ID);
    }
}
