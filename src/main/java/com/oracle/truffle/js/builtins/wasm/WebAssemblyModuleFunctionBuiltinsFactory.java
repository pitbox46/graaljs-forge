// CheckStyle: start generated
package com.oracle.truffle.js.builtins.wasm;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.builtins.wasm.WebAssemblyModuleFunctionBuiltins.WebAssemblyModuleCustomSectionsNode;
import com.oracle.truffle.js.builtins.wasm.WebAssemblyModuleFunctionBuiltins.WebAssemblyModuleExportsNode;
import com.oracle.truffle.js.builtins.wasm.WebAssemblyModuleFunctionBuiltins.WebAssemblyModuleImportsNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.wasm.JSWebAssemblyModuleObject;

@GeneratedBy(WebAssemblyModuleFunctionBuiltins.class)
@SuppressWarnings("unused")
public final class WebAssemblyModuleFunctionBuiltinsFactory {

    @GeneratedBy(WebAssemblyModuleExportsNode.class)
    public static final class WebAssemblyModuleExportsNodeGen extends WebAssemblyModuleExportsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private WebAssemblyModuleExportsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 exportsOfModule(JSWebAssemblyModuleObject) */ && arguments0Value_ instanceof JSWebAssemblyModuleObject) {
                JSWebAssemblyModuleObject arguments0Value__ = (JSWebAssemblyModuleObject) arguments0Value_;
                return exportsOfModule(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 exportsOfOther(Object) */) {
                if (fallbackGuard_(state_0, arguments0Value_)) {
                    return exportsOfOther(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof JSWebAssemblyModuleObject) {
                JSWebAssemblyModuleObject arguments0Value_ = (JSWebAssemblyModuleObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 exportsOfModule(JSWebAssemblyModuleObject) */;
                return exportsOfModule(arguments0Value_);
            }
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 exportsOfOther(Object) */;
            return exportsOfOther(arguments0Value);
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if (state_0 == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "exportsOfModule";
            if ((state_0 & 0b1) != 0 /* is-state_0 exportsOfModule(JSWebAssemblyModuleObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "exportsOfOther";
            if ((state_0 & 0b10) != 0 /* is-state_0 exportsOfOther(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value) {
            if (((state_0 & 0b1)) == 0 /* is-not-state_0 exportsOfModule(JSWebAssemblyModuleObject) */ && arguments0Value instanceof JSWebAssemblyModuleObject) {
                return false;
            }
            return true;
        }

        public static WebAssemblyModuleExportsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new WebAssemblyModuleExportsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(WebAssemblyModuleImportsNode.class)
    public static final class WebAssemblyModuleImportsNodeGen extends WebAssemblyModuleImportsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private WebAssemblyModuleImportsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 importsOfModule(JSWebAssemblyModuleObject) */ && arguments0Value_ instanceof JSWebAssemblyModuleObject) {
                JSWebAssemblyModuleObject arguments0Value__ = (JSWebAssemblyModuleObject) arguments0Value_;
                return importsOfModule(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 importsOfOther(Object) */) {
                if (fallbackGuard_(state_0, arguments0Value_)) {
                    return importsOfOther(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof JSWebAssemblyModuleObject) {
                JSWebAssemblyModuleObject arguments0Value_ = (JSWebAssemblyModuleObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 importsOfModule(JSWebAssemblyModuleObject) */;
                return importsOfModule(arguments0Value_);
            }
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 importsOfOther(Object) */;
            return importsOfOther(arguments0Value);
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if (state_0 == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "importsOfModule";
            if ((state_0 & 0b1) != 0 /* is-state_0 importsOfModule(JSWebAssemblyModuleObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "importsOfOther";
            if ((state_0 & 0b10) != 0 /* is-state_0 importsOfOther(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value) {
            if (((state_0 & 0b1)) == 0 /* is-not-state_0 importsOfModule(JSWebAssemblyModuleObject) */ && arguments0Value instanceof JSWebAssemblyModuleObject) {
                return false;
            }
            return true;
        }

        public static WebAssemblyModuleImportsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new WebAssemblyModuleImportsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(WebAssemblyModuleCustomSectionsNode.class)
    public static final class WebAssemblyModuleCustomSectionsNodeGen extends WebAssemblyModuleCustomSectionsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private WebAssemblyModuleCustomSectionsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 customSectionsOfModule(JSWebAssemblyModuleObject, Object) || customSectionsOfOther(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 customSectionsOfModule(JSWebAssemblyModuleObject, Object) */ && arguments0Value_ instanceof JSWebAssemblyModuleObject) {
                    JSWebAssemblyModuleObject arguments0Value__ = (JSWebAssemblyModuleObject) arguments0Value_;
                    return customSectionsOfModule(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 customSectionsOfOther(Object, Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_)) {
                        return customSectionsOfOther(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof JSWebAssemblyModuleObject) {
                JSWebAssemblyModuleObject arguments0Value_ = (JSWebAssemblyModuleObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 customSectionsOfModule(JSWebAssemblyModuleObject, Object) */;
                return customSectionsOfModule(arguments0Value_, arguments1Value);
            }
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 customSectionsOfOther(Object, Object) */;
            return customSectionsOfOther(arguments0Value, arguments1Value);
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if (state_0 == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "customSectionsOfModule";
            if ((state_0 & 0b1) != 0 /* is-state_0 customSectionsOfModule(JSWebAssemblyModuleObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "customSectionsOfOther";
            if ((state_0 & 0b10) != 0 /* is-state_0 customSectionsOfOther(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value) {
            if (((state_0 & 0b1)) == 0 /* is-not-state_0 customSectionsOfModule(JSWebAssemblyModuleObject, Object) */ && arguments0Value instanceof JSWebAssemblyModuleObject) {
                return false;
            }
            return true;
        }

        public static WebAssemblyModuleCustomSectionsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new WebAssemblyModuleCustomSectionsNodeGen(context, builtin, arguments);
        }

    }
}
