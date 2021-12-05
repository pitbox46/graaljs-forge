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

import java.util.List;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.builtins.JSBuiltinsContainer;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins;
import com.oracle.truffle.js.runtime.Boundaries;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import com.oracle.truffle.js.runtime.array.dyn.ConstantEmptyPrototypeArray;
import com.oracle.truffle.js.runtime.objects.JSObject;
import com.oracle.truffle.js.runtime.objects.JSShape;
import com.oracle.truffle.js.runtime.objects.PropertyDescriptor;

public final class JSObjectPrototype extends JSNonProxy {

    public static final String CLASS_NAME = "Object";

    public static final JSObjectPrototype INSTANCE = new JSObjectPrototype();
    public static final JSBuiltinsContainer BUILTINS = ObjectPrototypeBuiltins.BUILTINS;

    private JSObjectPrototype() {
    }

    public static DynamicObject create(JSContext context) {
        return create(context.makeEmptyShapeWithNullPrototype(JSObjectPrototype.INSTANCE));
    }

    public static boolean isJSObjectPrototype(Object obj) {
        return obj instanceof Instance;
    }

    @Override
    public String getClassName(DynamicObject object) {
        return CLASS_NAME;
    }

    @Override
    public String toDisplayStringImpl(DynamicObject obj, int depth, boolean allowSideEffects) {
        return defaultToString(obj);
    }

    @TruffleBoundary
    @Override
    public boolean hasOwnProperty(DynamicObject thisObj, Object key) {
        if (super.hasOwnProperty(thisObj, key)) {
            return true;
        }
        long index = JSRuntime.propertyKeyToArrayIndex(key);
        if (JSRuntime.isArrayIndex(index)) {
            return JSObject.getArray(thisObj).hasElement(thisObj, index);
        }
        return false;
    }

    @TruffleBoundary
    @Override
    public boolean hasOwnProperty(DynamicObject thisObj, long index) {
        ScriptArray array = JSObject.getArray(thisObj);
        if (array.hasElement(thisObj, index)) {
            return true;
        }
        return super.hasOwnProperty(thisObj, Boundaries.stringValueOf(index));
    }

    @TruffleBoundary
    @Override
    public Object getOwnHelper(DynamicObject store, Object thisObj, long index, Node encapsulatingNode) {
        ScriptArray array = JSObject.getArray(store);
        if (array.hasElement(store, index)) {
            return array.getElement(store, index);
        }
        return super.getOwnHelper(store, thisObj, Boundaries.stringValueOf(index), encapsulatingNode);
    }

    @TruffleBoundary
    @Override
    public Object getOwnHelper(DynamicObject store, Object thisObj, Object key, Node encapsulatingNode) {
        long idx = JSRuntime.propertyKeyToArrayIndex(key);
        if (JSRuntime.isArrayIndex(idx)) {
            return getOwnHelper(store, thisObj, idx, encapsulatingNode);
        }
        return super.getOwnHelper(store, thisObj, key, encapsulatingNode);
    }

    @TruffleBoundary
    @Override
    public boolean delete(DynamicObject thisObj, Object key, boolean isStrict) {
        long index = JSRuntime.propertyKeyToArrayIndex(key);
        if (index >= 0) {
            return delete(thisObj, index, isStrict);
        } else {
            return super.delete(thisObj, key, isStrict);
        }
    }

    @TruffleBoundary
    @Override
    public boolean delete(DynamicObject thisObj, long index, boolean isStrict) {
        ScriptArray array = JSObject.getArray(thisObj);
        if (array.hasElement(thisObj, index)) {
            if (array.canDeleteElement(thisObj, index, isStrict)) {
                JSObject.setArray(thisObj, array.deleteElement(thisObj, index, isStrict));
                return true;
            } else {
                return false;
            }
        } else {
            return JSOrdinary.INSTANCE.delete(thisObj, index, isStrict);
        }
    }

    @Override
    public List<Object> getOwnPropertyKeys(DynamicObject thisObj, boolean strings, boolean symbols) {
        if (!strings || JSObject.getArray(thisObj).length(thisObj) == 0) {
            return super.getOwnPropertyKeys(thisObj, strings, symbols);
        }
        return JSAbstractArray.ownPropertyKeysSlowArray(thisObj, strings, symbols);
    }

    @Override
    public boolean hasOnlyShapeProperties(DynamicObject thisObj) {
        return JSObject.getArray(thisObj).length(thisObj) == 0;
    }

    @Override
    public PropertyDescriptor getOwnProperty(DynamicObject thisObj, Object key) {
        assert JSRuntime.isPropertyKey(key);
        return JSAbstractArray.ordinaryGetOwnPropertyArray(thisObj, key);
    }

    @Override
    public boolean usesOrdinaryGetOwnProperty() {
        return false;
    }

    /**
     * 9.4.7.2 SetImmutablePrototype ( O, V ).
     */
    @Override
    public boolean setPrototypeOf(DynamicObject thisObj, DynamicObject newPrototype) {
        return JSObject.getPrototype(thisObj) == newPrototype;
    }

    @Override
    public boolean set(DynamicObject thisObj, long index, Object value, Object receiver, boolean isStrict, Node encapsulatingNode) {
        boolean result = super.set(thisObj, index, value, receiver, isStrict, encapsulatingNode);
        JSObject.getJSContext(thisObj).getArrayPrototypeNoElementsAssumption().invalidate(JSAbstractArray.ARRAY_PROTOTYPE_NO_ELEMENTS_INVALIDATION);
        return result;
    }

    @Override
    public boolean set(DynamicObject thisObj, Object key, Object value, Object receiver, boolean isStrict, Node encapsulatingNode) {
        boolean result = super.set(thisObj, key, value, receiver, isStrict, encapsulatingNode);
        if (JSRuntime.isArrayIndex(key)) {
            JSObject.getJSContext(thisObj).getArrayPrototypeNoElementsAssumption().invalidate(JSAbstractArray.ARRAY_PROTOTYPE_NO_ELEMENTS_INVALIDATION);
        }
        return result;
    }

    @Override
    public boolean defineOwnProperty(DynamicObject thisObj, Object key, PropertyDescriptor desc, boolean doThrow) {
        boolean result = super.defineOwnProperty(thisObj, key, desc, doThrow);
        if (JSRuntime.isArrayIndex(key)) {
            JSObject.getJSContext(thisObj).getArrayPrototypeNoElementsAssumption().invalidate(JSAbstractArray.ARRAY_PROTOTYPE_NO_ELEMENTS_INVALIDATION);
        }
        return result;
    }

    public static DynamicObject create(Shape shape) {
        assert JSShape.getJSClassNoCast(shape) == JSObjectPrototype.INSTANCE;
        return new Instance(shape);
    }

    public static final class Instance extends JSArrayBase {
        protected Instance(Shape shape) {
            super(shape, ConstantEmptyPrototypeArray.createConstantEmptyPrototypeArray(), ScriptArray.EMPTY_OBJECT_ARRAY, null, 0, 0, 0, 0, 0);
        }
    }

}
