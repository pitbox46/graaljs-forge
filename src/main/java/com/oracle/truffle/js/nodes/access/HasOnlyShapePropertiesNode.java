/*
 * Copyright (c) 2020, 2020, Oracle and/or its affiliates. All rights reserved.
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
import com.oracle.truffle.api.dsl.ImportStatic;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JavaScriptBaseNode;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import com.oracle.truffle.js.runtime.builtins.JSObjectPrototype;
import com.oracle.truffle.js.runtime.objects.JSObject;

@ImportStatic({JSObject.class, JSConfig.class})
public abstract class HasOnlyShapePropertiesNode extends JavaScriptBaseNode {

    protected HasOnlyShapePropertiesNode() {
    }

    public static HasOnlyShapePropertiesNode create() {
        return HasOnlyShapePropertiesNodeGen.create();
    }

    public final boolean execute(DynamicObject object) {
        return execute(object, JSObject.getJSClass(object));
    }

    public abstract boolean execute(DynamicObject object, JSClass jsclass);

    @Specialization(guards = {"jsclass == cachedJSClass", "!isJSObjectPrototype(cachedJSClass)"}, limit = "InteropLibraryLimit")
    static boolean doCached(DynamicObject object, @SuppressWarnings("unused") JSClass jsclass,
                    @Cached(value = "jsclass") JSClass cachedJSClass) {
        return cachedJSClass.hasOnlyShapeProperties(object);
    }

    @Specialization(guards = {"isJSObjectPrototype(jsclass)"})
    static boolean doObjectPrototype(DynamicObject object, JSClass jsclass,
                    @Cached("getJSContext(object)") JSContext context) {
        if (context.getArrayPrototypeNoElementsAssumption().isValid()) {
            assert jsclass.hasOnlyShapeProperties(object);
            return true;
        }
        return JSObjectPrototype.INSTANCE.hasOnlyShapeProperties(object);
    }

    @Specialization(replaces = {"doCached", "doObjectPrototype"})
    static boolean doUncached(DynamicObject object, JSClass jsclass) {
        return jsclass.hasOnlyShapeProperties(object);
    }

    static boolean isJSObjectPrototype(JSClass jsclass) {
        return jsclass == JSObjectPrototype.INSTANCE;
    }
}
