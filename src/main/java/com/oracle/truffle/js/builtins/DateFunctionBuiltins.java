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
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.builtins.DateFunctionBuiltinsFactory.DateNowNodeGen;
import com.oracle.truffle.js.builtins.DateFunctionBuiltinsFactory.DateParseNodeGen;
import com.oracle.truffle.js.builtins.DateFunctionBuiltinsFactory.DateUTCNodeGen;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSBuiltinNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.builtins.BuiltinEnum;
import com.oracle.truffle.js.runtime.builtins.JSDate;

/**
 * Contains builtins for {@linkplain JSDate} function (constructor).
 */
public final class DateFunctionBuiltins extends JSBuiltinsContainer.SwitchEnum<DateFunctionBuiltins.DateFunction> {

    public static final JSBuiltinsContainer BUILTINS = new DateFunctionBuiltins();

    protected DateFunctionBuiltins() {
        super(JSDate.CLASS_NAME, DateFunction.class);
    }

    public enum DateFunction implements BuiltinEnum<DateFunction> {
        parse(1),
        now(0),
        UTC(7);

        private final int length;

        DateFunction(int length) {
            this.length = length;
        }

        @Override
        public int getLength() {
            return length;
        }
    }

    @Override
    protected Object createNode(JSContext context, JSBuiltin builtin, boolean construct, boolean newTarget, DateFunction builtinEnum) {
        switch (builtinEnum) {
            case parse:
                return DateParseNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
            case now:
                return DateNowNodeGen.create(context, builtin, args().createArgumentNodes(context));
            case UTC:
                return DateUTCNodeGen.create(context, builtin, args().varArgs().createArgumentNodes(context));
        }
        return null;
    }

    public abstract static class DateParseNode extends JSBuiltinNode {
        private final ConditionProfile gotFieldsProfile = ConditionProfile.createBinaryProfile();

        public DateParseNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization
        protected double parse(Object parseDate,
                        @Cached("create()") JSToStringNode toStringNode) {
            String dateString = toStringNode.executeString(parseDate);
            Integer[] fields = getContext().getEvaluator().parseDate(getRealm(), dateString.trim());
            if (gotFieldsProfile.profile(fields != null)) {
                return JSDate.makeDate(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7]);
            }
            return Double.NaN;
        }

    }

    public abstract static class DateNowNode extends JSBuiltinNode {
        public DateNowNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization
        @TruffleBoundary
        protected double now() {
            return getRealm().currentTimeMillis();
        }
    }

    public abstract static class DateUTCNode extends JSBuiltinNode {
        public DateUTCNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization
        protected double utc(Object[] args,
                        @Cached("create()") JSToNumberNode toNumberNode) {
            double[] argsEvaluated = new double[args.length];
            boolean isNaN = false;
            for (int i = 0; i < args.length; i++) {
                double d = JSRuntime.doubleValue(toNumberNode.executeNumber(args[i]));
                if (Double.isNaN(d)) {
                    isNaN = true;
                }
                argsEvaluated[i] = d;
            }
            if (isNaN) {
                return Double.NaN;
            }
            return JSDate.executeConstructor(argsEvaluated, true);
        }
    }
}
