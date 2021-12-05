/*
 * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.js.builtins.wasm;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.InteropException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.js.builtins.JSBuiltinsContainer;
import com.oracle.truffle.js.builtins.wasm.WebAssemblyGlobalPrototypeBuiltinsFactory.WebAssemblyGlobalValueOfNodeGen;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSBuiltinNode;
import com.oracle.truffle.js.nodes.wasm.ToJSValueNode;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.BuiltinEnum;
import com.oracle.truffle.js.runtime.builtins.wasm.JSWebAssemblyGlobal;
import com.oracle.truffle.js.runtime.builtins.wasm.JSWebAssemblyGlobalObject;

public class WebAssemblyGlobalPrototypeBuiltins extends JSBuiltinsContainer.SwitchEnum<WebAssemblyGlobalPrototypeBuiltins.WebAssemblyGlobalPrototype> {

    public static final JSBuiltinsContainer BUILTINS = new WebAssemblyGlobalPrototypeBuiltins();

    protected WebAssemblyGlobalPrototypeBuiltins() {
        super(JSWebAssemblyGlobal.PROTOTYPE_NAME, WebAssemblyGlobalPrototype.class);
    }

    public enum WebAssemblyGlobalPrototype implements BuiltinEnum<WebAssemblyGlobalPrototype> {
        valueOf(0);

        private final int length;

        WebAssemblyGlobalPrototype(int length) {
            this.length = length;
        }

        @Override
        public int getLength() {
            return length;
        }

        @Override
        public boolean isEnumerable() {
            return true;
        }

    }

    @Override
    protected Object createNode(JSContext context, JSBuiltin builtin, boolean construct, boolean newTarget, WebAssemblyGlobalPrototype builtinEnum) {
        switch (builtinEnum) {
            case valueOf:
                return WebAssemblyGlobalValueOfNodeGen.create(context, builtin, args().withThis().createArgumentNodes(context));
        }
        return null;
    }

    public abstract static class WebAssemblyGlobalValueOfNode extends JSBuiltinNode {
        @Child ToJSValueNode toJSValueNode;
        @Child InteropLibrary globalReadLib;

        public WebAssemblyGlobalValueOfNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
            toJSValueNode = ToJSValueNode.create();
            globalReadLib = InteropLibrary.getFactory().createDispatched(JSConfig.InteropLibraryLimit);
        }

        @Specialization
        protected Object valueOf(Object thiz) {
            if (!JSWebAssemblyGlobal.isJSWebAssemblyGlobal(thiz)) {
                throw Errors.createTypeError("WebAssembly.Global.valueOf(): Receiver is not a WebAssembly.Global");
            }
            JSWebAssemblyGlobalObject object = (JSWebAssemblyGlobalObject) thiz;
            Object wasmGlobal = object.getWASMGlobal();
            try {
                Object globalRead = getRealm().getWASMGlobalRead();
                return toJSValueNode.convert(globalReadLib.execute(globalRead, wasmGlobal));
            } catch (InteropException ex) {
                throw Errors.shouldNotReachHere(ex);
            }
        }

    }

}
