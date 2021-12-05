// CheckStyle: start generated
package com.oracle.truffle.js.builtins.intl;

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
import com.oracle.truffle.js.builtins.intl.DisplayNamesPrototypeBuiltins.JSDisplayNamesOfNode;
import com.oracle.truffle.js.builtins.intl.DisplayNamesPrototypeBuiltins.JSDisplayNamesResolvedOptionsNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(DisplayNamesPrototypeBuiltins.class)
public final class DisplayNamesPrototypeBuiltinsFactory {

    @GeneratedBy(JSDisplayNamesResolvedOptionsNode.class)
    public static final class JSDisplayNamesResolvedOptionsNodeGen extends JSDisplayNamesResolvedOptionsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private JSDisplayNamesResolvedOptionsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doDisplayNames(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSDisplayNames(arguments0Value__))) {
                    return doDisplayNames(arguments0Value__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object) */) {
                if ((!(JSGuards.isJSDisplayNames(arguments0Value_)))) {
                    return doOther(arguments0Value_);
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
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSDisplayNames(arguments0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doDisplayNames(DynamicObject) */;
                    return doDisplayNames(arguments0Value_);
                }
            }
            if ((!(JSGuards.isJSDisplayNames(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doOther(Object) */;
                return doOther(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "doDisplayNames";
            if ((state_0 & 0b1) != 0 /* is-state_0 doDisplayNames(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doOther";
            if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSDisplayNamesResolvedOptionsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDisplayNamesResolvedOptionsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDisplayNamesOfNode.class)
    public static final class JSDisplayNamesOfNodeGen extends JSDisplayNamesOfNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private JSDisplayNamesOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 doDisplayNames(DynamicObject, Object) || doOther(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doDisplayNames(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSDisplayNames(arguments0Value__))) {
                        return doDisplayNames(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object, Object) */) {
                    if ((!(JSGuards.isJSDisplayNames(arguments0Value_)))) {
                        return doOther(arguments0Value_, arguments1Value_);
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
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSDisplayNames(arguments0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doDisplayNames(DynamicObject, Object) */;
                    return doDisplayNames(arguments0Value_, arguments1Value);
                }
            }
            if ((!(JSGuards.isJSDisplayNames(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doOther(Object, Object) */;
                return doOther(arguments0Value, arguments1Value);
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
            s[0] = "doDisplayNames";
            if ((state_0 & 0b1) != 0 /* is-state_0 doDisplayNames(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doOther";
            if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSDisplayNamesOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDisplayNamesOfNodeGen(context, builtin, arguments);
        }

    }
}
