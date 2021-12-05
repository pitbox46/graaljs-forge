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
import com.oracle.truffle.js.builtins.intl.RelativeTimeFormatPrototypeBuiltins.JSRelativeTimeFormatFormatNode;
import com.oracle.truffle.js.builtins.intl.RelativeTimeFormatPrototypeBuiltins.JSRelativeTimeFormatFormatToPartsNode;
import com.oracle.truffle.js.builtins.intl.RelativeTimeFormatPrototypeBuiltins.JSRelativeTimeFormatResolvedOptionsNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RelativeTimeFormatPrototypeBuiltins.class)
public final class RelativeTimeFormatPrototypeBuiltinsFactory {

    @GeneratedBy(JSRelativeTimeFormatResolvedOptionsNode.class)
    public static final class JSRelativeTimeFormatResolvedOptionsNodeGen extends JSRelativeTimeFormatResolvedOptionsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private JSRelativeTimeFormatResolvedOptionsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doResolvedOptions(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSRelativeTimeFormat(arguments0Value__))) {
                    return doResolvedOptions(arguments0Value__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doResolvedOptions(DynamicObject) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b10) != 0 /* is-state_0 doResolvedOptions(Object) */) {
                if ((!(JSGuards.isJSRelativeTimeFormat(arguments0Value_)))) {
                    doResolvedOptions(arguments0Value_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSRelativeTimeFormat(arguments0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doResolvedOptions(DynamicObject) */;
                    return doResolvedOptions(arguments0Value_);
                }
            }
            if ((!(JSGuards.isJSRelativeTimeFormat(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doResolvedOptions(Object) */;
                doResolvedOptions(arguments0Value);
                return null;
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
            s[0] = "doResolvedOptions";
            if ((state_0 & 0b1) != 0 /* is-state_0 doResolvedOptions(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doResolvedOptions";
            if ((state_0 & 0b10) != 0 /* is-state_0 doResolvedOptions(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRelativeTimeFormatResolvedOptionsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRelativeTimeFormatResolvedOptionsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRelativeTimeFormatFormatNode.class)
    public static final class JSRelativeTimeFormatFormatNodeGen extends JSRelativeTimeFormatFormatNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToStringNode format_toStringNode_;
        @Child private JSToNumberNode format_toNumberNode_;

        private JSRelativeTimeFormatFormatNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 doFormat(DynamicObject, Object, Object, JSToStringNode, JSToNumberNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSRelativeTimeFormat(arguments0Value__))) {
                    return doFormat(arguments0Value__, arguments1Value_, arguments2Value_, this.format_toStringNode_, this.format_toNumberNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doFormat(DynamicObject, Object, Object, JSToStringNode, JSToNumberNode) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state_0 & 0b10) != 0 /* is-state_0 throwTypeError(Object, Object, Object) */) {
                if ((!(JSGuards.isJSRelativeTimeFormat(arguments0Value_)))) {
                    throwTypeError(arguments0Value_, arguments1Value_, arguments2Value_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSRelativeTimeFormat(arguments0Value_))) {
                        this.format_toStringNode_ = super.insert((JSToStringNode.create()));
                        this.format_toNumberNode_ = super.insert((JSToNumberNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doFormat(DynamicObject, Object, Object, JSToStringNode, JSToNumberNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doFormat(arguments0Value_, arguments1Value, arguments2Value, this.format_toStringNode_, this.format_toNumberNode_);
                    }
                }
                if ((!(JSGuards.isJSRelativeTimeFormat(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 throwTypeError(Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    throwTypeError(arguments0Value, arguments1Value, arguments2Value);
                    return null;
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            s[0] = "doFormat";
            if ((state_0 & 0b1) != 0 /* is-state_0 doFormat(DynamicObject, Object, Object, JSToStringNode, JSToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.format_toStringNode_, this.format_toNumberNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "throwTypeError";
            if ((state_0 & 0b10) != 0 /* is-state_0 throwTypeError(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRelativeTimeFormatFormatNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRelativeTimeFormatFormatNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRelativeTimeFormatFormatToPartsNode.class)
    public static final class JSRelativeTimeFormatFormatToPartsNodeGen extends JSRelativeTimeFormatFormatToPartsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToStringNode formatToParts_toStringNode_;
        @Child private JSToNumberNode formatToParts_toNumberNode_;

        private JSRelativeTimeFormatFormatToPartsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 doFormatToParts(DynamicObject, Object, Object, JSToStringNode, JSToNumberNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSRelativeTimeFormat(arguments0Value__))) {
                    return doFormatToParts(arguments0Value__, arguments1Value_, arguments2Value_, this.formatToParts_toStringNode_, this.formatToParts_toNumberNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doFormatToParts(DynamicObject, Object, Object, JSToStringNode, JSToNumberNode) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state_0 & 0b10) != 0 /* is-state_0 throwTypeError(Object, Object, Object) */) {
                if ((!(JSGuards.isJSRelativeTimeFormat(arguments0Value_)))) {
                    throwTypeError(arguments0Value_, arguments1Value_, arguments2Value_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSRelativeTimeFormat(arguments0Value_))) {
                        this.formatToParts_toStringNode_ = super.insert((JSToStringNode.create()));
                        this.formatToParts_toNumberNode_ = super.insert((JSToNumberNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doFormatToParts(DynamicObject, Object, Object, JSToStringNode, JSToNumberNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doFormatToParts(arguments0Value_, arguments1Value, arguments2Value, this.formatToParts_toStringNode_, this.formatToParts_toNumberNode_);
                    }
                }
                if ((!(JSGuards.isJSRelativeTimeFormat(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 throwTypeError(Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    throwTypeError(arguments0Value, arguments1Value, arguments2Value);
                    return null;
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            s[0] = "doFormatToParts";
            if ((state_0 & 0b1) != 0 /* is-state_0 doFormatToParts(DynamicObject, Object, Object, JSToStringNode, JSToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.formatToParts_toStringNode_, this.formatToParts_toNumberNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "throwTypeError";
            if ((state_0 & 0b10) != 0 /* is-state_0 throwTypeError(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRelativeTimeFormatFormatToPartsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRelativeTimeFormatFormatToPartsNodeGen(context, builtin, arguments);
        }

    }
}
