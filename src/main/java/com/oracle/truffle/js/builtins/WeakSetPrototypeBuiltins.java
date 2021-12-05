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
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.WeakSetPrototypeBuiltinsFactory.JSWeakSetAddNodeGen;
import com.oracle.truffle.js.builtins.WeakSetPrototypeBuiltinsFactory.JSWeakSetDeleteNodeGen;
import com.oracle.truffle.js.builtins.WeakSetPrototypeBuiltinsFactory.JSWeakSetHasNodeGen;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSBuiltinNode;
import com.oracle.truffle.js.runtime.Boundaries;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.BuiltinEnum;
import com.oracle.truffle.js.runtime.builtins.JSWeakSet;

/**
 * Contains builtins for {@linkplain JSWeakSet}.prototype.
 */
public final class WeakSetPrototypeBuiltins extends JSBuiltinsContainer.SwitchEnum<WeakSetPrototypeBuiltins.WeakSetPrototype> {

    public static final JSBuiltinsContainer BUILTINS = new WeakSetPrototypeBuiltins();

    protected WeakSetPrototypeBuiltins() {
        super(JSWeakSet.PROTOTYPE_NAME, WeakSetPrototype.class);
    }

    public enum WeakSetPrototype implements BuiltinEnum<WeakSetPrototype> {
        delete(1),
        add(1),
        has(1);

        private final int length;

        WeakSetPrototype(int length) {
            this.length = length;
        }

        @Override
        public int getLength() {
            return length;
        }
    }

    @Override
    protected Object createNode(JSContext context, JSBuiltin builtin, boolean construct, boolean newTarget, WeakSetPrototype builtinEnum) {
        switch (builtinEnum) {
            case delete:
                return JSWeakSetDeleteNodeGen.create(context, builtin, args().withThis().fixedArgs(1).createArgumentNodes(context));
            case add:
                return JSWeakSetAddNodeGen.create(context, builtin, args().withThis().fixedArgs(1).createArgumentNodes(context));
            case has:
                return JSWeakSetHasNodeGen.create(context, builtin, args().withThis().fixedArgs(1).createArgumentNodes(context));
        }
        return null;
    }

    /** Dummy value to associate with a key in the backing map. */
    protected static final Object PRESENT = new Object();

    protected static RuntimeException typeErrorKeyIsNotObject() {
        throw Errors.createTypeError("WeakSet key must be an object");
    }

    protected static RuntimeException typeErrorWeakSetExpected() {
        throw Errors.createTypeError("WeakSet expected");
    }

    /**
     * Implementation of the WeakSet.prototype.delete().
     */
    public abstract static class JSWeakSetDeleteNode extends JSBuiltinNode {

        public JSWeakSetDeleteNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization(guards = {"isJSWeakSet(thisObj)", "isJSObject(key)"})
        protected static boolean delete(DynamicObject thisObj, DynamicObject key) {
            return Boundaries.mapRemove(JSWeakSet.getInternalWeakMap(thisObj), key) != null;
        }

        @SuppressWarnings("unused")
        @Specialization(guards = {"isJSWeakSet(thisObj)", "!isJSObject(key)"})
        protected static boolean deleteNonObjectKey(Object thisObj, Object key) {
            return false;
        }

        @SuppressWarnings("unused")
        @Specialization(guards = "!isJSWeakSet(thisObj)")
        protected static boolean notWeakSet(Object thisObj, Object key) {
            throw typeErrorWeakSetExpected();
        }
    }

    /**
     * Implementation of the WeakSet.prototype.add().
     */
    public abstract static class JSWeakSetAddNode extends JSBuiltinNode {

        public JSWeakSetAddNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization(guards = {"isJSWeakSet(thisObj)", "isJSObject(key)"})
        protected static DynamicObject add(DynamicObject thisObj, DynamicObject key) {
            Boundaries.mapPut(JSWeakSet.getInternalWeakMap(thisObj), key, PRESENT);
            return thisObj;
        }

        @SuppressWarnings("unused")
        @Specialization(guards = {"isJSWeakSet(thisObj)", "!isJSObject(key)"})
        protected static DynamicObject addNonObjectKey(Object thisObj, Object key) {
            throw typeErrorKeyIsNotObject();
        }

        @SuppressWarnings("unused")
        @Specialization(guards = "!isJSWeakSet(thisObj)")
        protected static DynamicObject notWeakSet(Object thisObj, Object key) {
            throw typeErrorWeakSetExpected();
        }
    }

    /**
     * Implementation of the WeakSet.prototype.has().
     */
    public abstract static class JSWeakSetHasNode extends JSBuiltinNode {

        public JSWeakSetHasNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization(guards = {"isJSWeakSet(thisObj)", "isJSObject(key)"})
        protected static boolean has(DynamicObject thisObj, DynamicObject key) {
            return Boundaries.mapContainsKey(JSWeakSet.getInternalWeakMap(thisObj), key);
        }

        @SuppressWarnings("unused")
        @Specialization(guards = {"isJSWeakSet(thisObj)", "!isJSObject(key)"})
        protected static boolean hasNonObjectKey(Object thisObj, Object key) {
            return false;
        }

        @SuppressWarnings("unused")
        @Specialization(guards = "!isJSWeakSet(thisObj)")
        protected static boolean notWeakSet(Object thisObj, Object key) {
            throw typeErrorWeakSetExpected();
        }
    }
}
