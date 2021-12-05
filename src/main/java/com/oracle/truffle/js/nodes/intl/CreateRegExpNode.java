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
package com.oracle.truffle.js.nodes.intl;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.js.nodes.JavaScriptBaseNode;
import com.oracle.truffle.js.nodes.access.PropertySetNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSRegExp;
import com.oracle.truffle.js.runtime.builtins.JSRegExpObject;
import com.oracle.truffle.js.runtime.objects.JSAttributes;
import com.oracle.truffle.js.runtime.util.TRegexUtil;

public abstract class CreateRegExpNode extends JavaScriptBaseNode {

    @Child private TRegexUtil.InteropReadMemberNode readNamedCG = TRegexUtil.InteropReadMemberNode.create();
    @Child private TRegexUtil.InteropIsNullNode isNamedCGNull = TRegexUtil.InteropIsNullNode.create();
    @Child private PropertySetNode setLastIndex;
    private final JSContext context;

    protected CreateRegExpNode(JSContext context) {
        this.context = context;
        this.setLastIndex = PropertySetNode.createImpl(JSRegExp.LAST_INDEX, false, context, true, true, JSAttributes.notConfigurableNotEnumerableWritable());
    }

    public static CreateRegExpNode create(JSContext context) {
        return CreateRegExpNodeGen.create(context);
    }

    public JSRegExpObject createRegExp(Object compiledRegex) {
        return createRegExp(compiledRegex, true);
    }

    public JSRegExpObject createRegExp(Object compiledRegex, boolean legacyFeaturesEnabled) {
        return execute(compiledRegex, legacyFeaturesEnabled);
    }

    protected abstract JSRegExpObject execute(Object compiledRegex, boolean legacyFeaturesEnabled);

    @Specialization(guards = {"!hasNamedCG(compiledRegex)"})
    protected JSRegExpObject createWithoutNamedCG(Object compiledRegex, boolean legacyFeaturesEnabled) {
        JSRegExpObject reObj = JSRegExp.create(context, getRealm(), compiledRegex, null, legacyFeaturesEnabled);
        setLastIndex.setValueInt(reObj, 0);
        return reObj;
    }

    @Specialization(guards = {"hasNamedCG(compiledRegex)"})
    protected JSRegExpObject createWithNamedCG(Object compiledRegex, boolean legacyFeaturesEnabled) {
        Object namedCaptureGroups = readNamedCG.execute(compiledRegex, TRegexUtil.Props.CompiledRegex.GROUPS);
        JSRegExpObject reObj = JSRegExp.create(context, getRealm(), compiledRegex, JSRegExp.buildGroupsFactory(context, namedCaptureGroups), legacyFeaturesEnabled);
        setLastIndex.setValueInt(reObj, 0);
        return reObj;
    }

    protected boolean hasNamedCG(Object compiledRegex) {
        Object namedCaptureGroups = readNamedCG.execute(compiledRegex, TRegexUtil.Props.CompiledRegex.GROUPS);
        return !isNamedCGNull.execute(namedCaptureGroups);
    }
}
