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
import com.oracle.truffle.js.builtins.WeakSetPrototypeBuiltins.JSWeakSetAddNode;
import com.oracle.truffle.js.builtins.WeakSetPrototypeBuiltins.JSWeakSetDeleteNode;
import com.oracle.truffle.js.builtins.WeakSetPrototypeBuiltins.JSWeakSetHasNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(WeakSetPrototypeBuiltins.class)
public final class WeakSetPrototypeBuiltinsFactory {

    @GeneratedBy(JSWeakSetDeleteNode.class)
    public static final class JSWeakSetDeleteNodeGen extends JSWeakSetDeleteNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private JSWeakSetDeleteNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 delete(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSWeakSet(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                        return JSWeakSetDeleteNode.delete(arguments0Value__, arguments1Value__);
                    }
                }
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 deleteNonObjectKey(Object, Object) || notWeakSet(Object, Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 deleteNonObjectKey(Object, Object) */) {
                    if ((JSGuards.isJSWeakSet(arguments0Value_)) && (!(JSGuards.isJSObject(arguments1Value_)))) {
                        return JSWeakSetDeleteNode.deleteNonObjectKey(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 notWeakSet(Object, Object) */) {
                    if ((!(JSGuards.isJSWeakSet(arguments0Value_)))) {
                        return JSWeakSetDeleteNode.notWeakSet(arguments0Value_, arguments1Value_);
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
            if ((state_0 & 0b1) != 0 /* is-state_0 delete(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSWeakSet(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                        return JSWeakSetDeleteNode.delete(arguments0Value__, arguments1Value__);
                    }
                }
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 deleteNonObjectKey(Object, Object) || notWeakSet(Object, Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 deleteNonObjectKey(Object, Object) */) {
                    if ((JSGuards.isJSWeakSet(arguments0Value_)) && (!(JSGuards.isJSObject(arguments1Value_)))) {
                        return JSWeakSetDeleteNode.deleteNonObjectKey(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 notWeakSet(Object, Object) */) {
                    if ((!(JSGuards.isJSWeakSet(arguments0Value_)))) {
                        return JSWeakSetDeleteNode.notWeakSet(arguments0Value_, arguments1Value_);
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
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if ((JSGuards.isJSWeakSet(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 delete(DynamicObject, DynamicObject) */;
                        return JSWeakSetDeleteNode.delete(arguments0Value_, arguments1Value_);
                    }
                }
            }
            if ((JSGuards.isJSWeakSet(arguments0Value)) && (!(JSGuards.isJSObject(arguments1Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 deleteNonObjectKey(Object, Object) */;
                return JSWeakSetDeleteNode.deleteNonObjectKey(arguments0Value, arguments1Value);
            }
            if ((!(JSGuards.isJSWeakSet(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 notWeakSet(Object, Object) */;
                return JSWeakSetDeleteNode.notWeakSet(arguments0Value, arguments1Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "delete";
            if ((state_0 & 0b1) != 0 /* is-state_0 delete(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "deleteNonObjectKey";
            if ((state_0 & 0b10) != 0 /* is-state_0 deleteNonObjectKey(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "notWeakSet";
            if ((state_0 & 0b100) != 0 /* is-state_0 notWeakSet(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSWeakSetDeleteNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSWeakSetDeleteNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSWeakSetAddNode.class)
    public static final class JSWeakSetAddNodeGen extends JSWeakSetAddNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private JSWeakSetAddNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 add(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSWeakSet(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                        return JSWeakSetAddNode.add(arguments0Value__, arguments1Value__);
                    }
                }
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 addNonObjectKey(Object, Object) || notWeakSet(Object, Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 addNonObjectKey(Object, Object) */) {
                    if ((JSGuards.isJSWeakSet(arguments0Value_)) && (!(JSGuards.isJSObject(arguments1Value_)))) {
                        return JSWeakSetAddNode.addNonObjectKey(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 notWeakSet(Object, Object) */) {
                    if ((!(JSGuards.isJSWeakSet(arguments0Value_)))) {
                        return JSWeakSetAddNode.notWeakSet(arguments0Value_, arguments1Value_);
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
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if ((JSGuards.isJSWeakSet(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 add(DynamicObject, DynamicObject) */;
                        return JSWeakSetAddNode.add(arguments0Value_, arguments1Value_);
                    }
                }
            }
            if ((JSGuards.isJSWeakSet(arguments0Value)) && (!(JSGuards.isJSObject(arguments1Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 addNonObjectKey(Object, Object) */;
                return JSWeakSetAddNode.addNonObjectKey(arguments0Value, arguments1Value);
            }
            if ((!(JSGuards.isJSWeakSet(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 notWeakSet(Object, Object) */;
                return JSWeakSetAddNode.notWeakSet(arguments0Value, arguments1Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "add";
            if ((state_0 & 0b1) != 0 /* is-state_0 add(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "addNonObjectKey";
            if ((state_0 & 0b10) != 0 /* is-state_0 addNonObjectKey(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "notWeakSet";
            if ((state_0 & 0b100) != 0 /* is-state_0 notWeakSet(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSWeakSetAddNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSWeakSetAddNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSWeakSetHasNode.class)
    public static final class JSWeakSetHasNodeGen extends JSWeakSetHasNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private JSWeakSetHasNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 has(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSWeakSet(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                        return JSWeakSetHasNode.has(arguments0Value__, arguments1Value__);
                    }
                }
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 hasNonObjectKey(Object, Object) || notWeakSet(Object, Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 hasNonObjectKey(Object, Object) */) {
                    if ((JSGuards.isJSWeakSet(arguments0Value_)) && (!(JSGuards.isJSObject(arguments1Value_)))) {
                        return JSWeakSetHasNode.hasNonObjectKey(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 notWeakSet(Object, Object) */) {
                    if ((!(JSGuards.isJSWeakSet(arguments0Value_)))) {
                        return JSWeakSetHasNode.notWeakSet(arguments0Value_, arguments1Value_);
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
            if ((state_0 & 0b1) != 0 /* is-state_0 has(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSWeakSet(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                        return JSWeakSetHasNode.has(arguments0Value__, arguments1Value__);
                    }
                }
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 hasNonObjectKey(Object, Object) || notWeakSet(Object, Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 hasNonObjectKey(Object, Object) */) {
                    if ((JSGuards.isJSWeakSet(arguments0Value_)) && (!(JSGuards.isJSObject(arguments1Value_)))) {
                        return JSWeakSetHasNode.hasNonObjectKey(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 notWeakSet(Object, Object) */) {
                    if ((!(JSGuards.isJSWeakSet(arguments0Value_)))) {
                        return JSWeakSetHasNode.notWeakSet(arguments0Value_, arguments1Value_);
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
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if ((JSGuards.isJSWeakSet(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 has(DynamicObject, DynamicObject) */;
                        return JSWeakSetHasNode.has(arguments0Value_, arguments1Value_);
                    }
                }
            }
            if ((JSGuards.isJSWeakSet(arguments0Value)) && (!(JSGuards.isJSObject(arguments1Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 hasNonObjectKey(Object, Object) */;
                return JSWeakSetHasNode.hasNonObjectKey(arguments0Value, arguments1Value);
            }
            if ((!(JSGuards.isJSWeakSet(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 notWeakSet(Object, Object) */;
                return JSWeakSetHasNode.notWeakSet(arguments0Value, arguments1Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "has";
            if ((state_0 & 0b1) != 0 /* is-state_0 has(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "hasNonObjectKey";
            if ((state_0 & 0b10) != 0 /* is-state_0 hasNonObjectKey(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "notWeakSet";
            if ((state_0 & 0b100) != 0 /* is-state_0 notWeakSet(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSWeakSetHasNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSWeakSetHasNodeGen(context, builtin, arguments);
        }

    }
}
