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
package com.oracle.truffle.js.runtime.builtins;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRealm;
import com.oracle.truffle.js.runtime.objects.JSObject;
import com.oracle.truffle.js.runtime.objects.Undefined;

public abstract class JSPrimitive extends JSNonProxy implements PrototypeSupplier {
    protected JSPrimitive() {
    }

    @TruffleBoundary
    @Override
    public final Object getHelper(DynamicObject store, Object thisObj, Object key, Node encapsulatingNode) {
        assert this == JSNumber.INSTANCE || this == JSString.INSTANCE || this == JSBoolean.INSTANCE || this == JSBigInt.INSTANCE;

        Object propertyValue = super.getHelper(store, thisObj, key, encapsulatingNode);

        if (key instanceof String && allowJavaMembersFor(thisObj)) {
            JSContext context = JSObject.getJSContext(store);
            if (context.isOptionNashornCompatibilityMode()) {
                JSRealm realm = JSRealm.get(null);
                if (realm.isJavaInteropEnabled()) {
                    if (propertyValue == null) {
                        return getJavaProperty(thisObj, (String) key, realm);
                    }
                }
            }
        }

        return propertyValue;
    }

    private static Object getJavaProperty(Object thisObj, String name, JSRealm realm) {
        String thisStr = (String) thisObj;
        Object boxedString = realm.getEnv().asBoxedGuestValue(thisStr);
        try {
            return InteropLibrary.getFactory().getUncached().readMember(boxedString, name);
        } catch (UnknownIdentifierException | UnsupportedMessageException e) {
            return Undefined.instance;
        }
    }

    @TruffleBoundary
    @Override
    public Object getMethodHelper(DynamicObject store, Object thisObj, Object key, Node encapsulatingNode) {
        if (key instanceof String && allowJavaMembersFor(thisObj)) {
            JSContext context = JSObject.getJSContext(store);
            if (context.isOptionNashornCompatibilityMode()) {
                JSRealm realm = JSRealm.get(null);
                if (realm.isJavaInteropEnabled()) {
                    if (hasOwnProperty(store, key)) {
                        Object method = getJavaMethod(thisObj, (String) key, realm);
                        if (method != null) {
                            return method;
                        }
                    }
                }
            }
        }

        return super.getMethodHelper(store, thisObj, key, encapsulatingNode);
    }

    private static Object getJavaMethod(Object thisObj, String name, JSRealm realm) {
        String thisStr = (String) thisObj;
        Object boxedString = realm.getEnv().asBoxedGuestValue(thisStr);
        try {
            return InteropLibrary.getFactory().getUncached().readMember(boxedString, name);
        } catch (UnknownIdentifierException | UnsupportedMessageException e) {
            return null;
        }
    }

    private static boolean allowJavaMembersFor(Object thisObj) {
        return thisObj instanceof String;
    }
}
