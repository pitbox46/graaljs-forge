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
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JavaScriptBaseNode;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.objects.JSAttributes;

public abstract class CreateDataPropertyNode extends JavaScriptBaseNode {
    protected final JSContext context;
    protected final Object key;
    protected final boolean enumerable;
    @Child protected IsJSObjectNode isObject;

    protected CreateDataPropertyNode(JSContext context, Object key, boolean enumerable) {
        this.context = context;
        this.key = key;
        this.isObject = IsJSObjectNode.create();
        this.enumerable = enumerable;
    }

    public static CreateDataPropertyNode create(JSContext context, Object key) {
        return CreateDataPropertyNodeGen.create(context, key, true);
    }

    public static CreateDataPropertyNode createNonEnumerable(JSContext context, Object key) {
        return CreateDataPropertyNodeGen.create(context, key, false);
    }

    public abstract void executeVoid(Object object, Object value);

    @Specialization(guards = {"context.getPropertyCacheLimit() > 0", "isObject.executeBoolean(object)"})
    protected static void doCached(Object object, Object value,
                    @Cached("makeDefinePropertyCache()") PropertySetNode propertyCache) {
        propertyCache.setValue(object, value);
    }

    @Specialization(guards = {"context.getPropertyCacheLimit() == 0", "isJSObject(object)"})
    protected final void doUncached(DynamicObject object, Object value) {
        if (enumerable) {
            JSRuntime.createDataPropertyOrThrow(object, key, value);
        } else {
            JSRuntime.createNonEnumerableDataPropertyOrThrow(object, key, value);
        }
    }

    @Specialization(guards = "!isJSObject(object)")
    protected final void doNonObject(Object object, @SuppressWarnings("unused") Object value) {
        throw Errors.createTypeErrorNotAnObject(object, this);
    }

    protected final PropertySetNode makeDefinePropertyCache() {
        if (enumerable) {
            return PropertySetNode.createImpl(key, false, context, true, true, JSAttributes.getDefault());
        } else {
            return PropertySetNode.createImpl(key, false, context, true, true, JSAttributes.getDefaultNotEnumerable());
        }
    }
}
