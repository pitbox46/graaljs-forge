// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.FinalizationRegistryPrototypeBuiltins.JSFinalizationRegistryCleanupSomeNode;
import com.oracle.truffle.js.builtins.FinalizationRegistryPrototypeBuiltins.JSFinalizationRegistryRegisterNode;
import com.oracle.truffle.js.builtins.FinalizationRegistryPrototypeBuiltins.JSFinalizationRegistryUnregisterNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSFinalizationRegistryObject;

@GeneratedBy(FinalizationRegistryPrototypeBuiltins.class)
public final class FinalizationRegistryPrototypeBuiltinsFactory {

    @GeneratedBy(JSFinalizationRegistryRegisterNode.class)
    public static final class JSFinalizationRegistryRegisterNodeGen extends JSFinalizationRegistryRegisterNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;
        @CompilationFinal private int state_0_;

        private JSFinalizationRegistryRegisterNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
            this.arguments3_ = arguments != null && 3 < arguments.length ? arguments[3] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 register(JSFinalizationRegistryObject, Object, Object, Object) || notFinalizationRegistry(Object, Object, Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 register(JSFinalizationRegistryObject, Object, Object, Object) */ && arguments0Value_ instanceof JSFinalizationRegistryObject) {
                    JSFinalizationRegistryObject arguments0Value__ = (JSFinalizationRegistryObject) arguments0Value_;
                    return register(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 notFinalizationRegistry(Object, Object, Object, Object) */) {
                    if ((!(JSGuards.isJSFinalizationRegistry(arguments0Value_)))) {
                        return JSFinalizationRegistryRegisterNode.notFinalizationRegistry(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value, Object arguments3Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof JSFinalizationRegistryObject) {
                JSFinalizationRegistryObject arguments0Value_ = (JSFinalizationRegistryObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 register(JSFinalizationRegistryObject, Object, Object, Object) */;
                return register(arguments0Value_, arguments1Value, arguments2Value, arguments3Value);
            }
            if ((!(JSGuards.isJSFinalizationRegistry(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 notFinalizationRegistry(Object, Object, Object, Object) */;
                return JSFinalizationRegistryRegisterNode.notFinalizationRegistry(arguments0Value, arguments1Value, arguments2Value, arguments3Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_}, arguments0Value, arguments1Value, arguments2Value, arguments3Value);
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
            s[0] = "register";
            if ((state_0 & 0b1) != 0 /* is-state_0 register(JSFinalizationRegistryObject, Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "notFinalizationRegistry";
            if ((state_0 & 0b10) != 0 /* is-state_0 notFinalizationRegistry(Object, Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSFinalizationRegistryRegisterNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSFinalizationRegistryRegisterNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSFinalizationRegistryUnregisterNode.class)
    public static final class JSFinalizationRegistryUnregisterNodeGen extends JSFinalizationRegistryUnregisterNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private JSFinalizationRegistryUnregisterNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 unregister(JSFinalizationRegistryObject, Object) || notFinalizationRegistry(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 unregister(JSFinalizationRegistryObject, Object) */ && arguments0Value_ instanceof JSFinalizationRegistryObject) {
                    JSFinalizationRegistryObject arguments0Value__ = (JSFinalizationRegistryObject) arguments0Value_;
                    return unregister(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 notFinalizationRegistry(Object, Object) */) {
                    if ((!(JSGuards.isJSFinalizationRegistry(arguments0Value_)))) {
                        return JSFinalizationRegistryUnregisterNode.notFinalizationRegistry(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 unregister(JSFinalizationRegistryObject, Object) || notFinalizationRegistry(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 unregister(JSFinalizationRegistryObject, Object) */ && arguments0Value_ instanceof JSFinalizationRegistryObject) {
                    JSFinalizationRegistryObject arguments0Value__ = (JSFinalizationRegistryObject) arguments0Value_;
                    return unregister(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 notFinalizationRegistry(Object, Object) */) {
                    if ((!(JSGuards.isJSFinalizationRegistry(arguments0Value_)))) {
                        return JSFinalizationRegistryUnregisterNode.notFinalizationRegistry(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof JSFinalizationRegistryObject) {
                JSFinalizationRegistryObject arguments0Value_ = (JSFinalizationRegistryObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 unregister(JSFinalizationRegistryObject, Object) */;
                return unregister(arguments0Value_, arguments1Value);
            }
            if ((!(JSGuards.isJSFinalizationRegistry(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 notFinalizationRegistry(Object, Object) */;
                return JSFinalizationRegistryUnregisterNode.notFinalizationRegistry(arguments0Value, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "unregister";
            if ((state_0 & 0b1) != 0 /* is-state_0 unregister(JSFinalizationRegistryObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "notFinalizationRegistry";
            if ((state_0 & 0b10) != 0 /* is-state_0 notFinalizationRegistry(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSFinalizationRegistryUnregisterNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSFinalizationRegistryUnregisterNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSFinalizationRegistryCleanupSomeNode.class)
    public static final class JSFinalizationRegistryCleanupSomeNodeGen extends JSFinalizationRegistryCleanupSomeNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private JSFinalizationRegistryCleanupSomeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 cleanupSome(JSFinalizationRegistryObject, Object) || notFinalizationRegistry(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 cleanupSome(JSFinalizationRegistryObject, Object) */ && arguments0Value_ instanceof JSFinalizationRegistryObject) {
                    JSFinalizationRegistryObject arguments0Value__ = (JSFinalizationRegistryObject) arguments0Value_;
                    return cleanupSome(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 notFinalizationRegistry(Object, Object) */) {
                    if ((!(JSGuards.isJSFinalizationRegistry(arguments0Value_)))) {
                        return JSFinalizationRegistryCleanupSomeNode.notFinalizationRegistry(arguments0Value_, arguments1Value_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof JSFinalizationRegistryObject) {
                JSFinalizationRegistryObject arguments0Value_ = (JSFinalizationRegistryObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 cleanupSome(JSFinalizationRegistryObject, Object) */;
                return cleanupSome(arguments0Value_, arguments1Value);
            }
            if ((!(JSGuards.isJSFinalizationRegistry(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 notFinalizationRegistry(Object, Object) */;
                return JSFinalizationRegistryCleanupSomeNode.notFinalizationRegistry(arguments0Value, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "cleanupSome";
            if ((state_0 & 0b1) != 0 /* is-state_0 cleanupSome(JSFinalizationRegistryObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "notFinalizationRegistry";
            if ((state_0 & 0b10) != 0 /* is-state_0 notFinalizationRegistry(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSFinalizationRegistryCleanupSomeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSFinalizationRegistryCleanupSomeNodeGen(context, builtin, arguments);
        }

    }
}
