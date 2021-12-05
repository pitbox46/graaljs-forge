// CheckStyle: start generated
package com.oracle.truffle.js.builtins.intl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.intl.ListFormatPrototypeBuiltins.JSListFormatFormatNode;
import com.oracle.truffle.js.builtins.intl.ListFormatPrototypeBuiltins.JSListFormatFormatToPartsNode;
import com.oracle.truffle.js.builtins.intl.ListFormatPrototypeBuiltins.JSListFormatResolvedOptionsNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSStringListFromIterableNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ListFormatPrototypeBuiltins.class)
@SuppressWarnings("unused")
public final class ListFormatPrototypeBuiltinsFactory {

    @GeneratedBy(JSListFormatResolvedOptionsNode.class)
    public static final class JSListFormatResolvedOptionsNodeGen extends JSListFormatResolvedOptionsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private JSListFormatResolvedOptionsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
                if ((JSGuards.isJSListFormat(arguments0Value__))) {
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
                if (fallbackGuard_(arguments0Value_)) {
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
                if ((JSGuards.isJSListFormat(arguments0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doResolvedOptions(DynamicObject) */;
                    return doResolvedOptions(arguments0Value_);
                }
            }
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doResolvedOptions(Object) */;
            doResolvedOptions(arguments0Value);
            return null;
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

        private static boolean fallbackGuard_(Object arguments0Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSListFormat(arguments0Value_))) {
                    return false;
                }
            }
            return true;
        }

        public static JSListFormatResolvedOptionsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSListFormatResolvedOptionsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSListFormatFormatNode.class)
    public static final class JSListFormatFormatNodeGen extends JSListFormatFormatNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSStringListFromIterableNode format_strListFromIterableNode_;

        private JSListFormatFormatNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doFormat(DynamicObject, Object, JSStringListFromIterableNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSListFormat(arguments0Value__))) {
                    return doFormat(arguments0Value__, arguments1Value_, this.format_strListFromIterableNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doFormat(DynamicObject, Object, JSStringListFromIterableNode) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b10) != 0 /* is-state_0 throwTypeError(Object, Object) */) {
                if (fallbackGuard_(arguments0Value_, arguments1Value_)) {
                    throwTypeError(arguments0Value_, arguments1Value_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_, arguments1Value_);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSListFormat(arguments0Value_))) {
                        this.format_strListFromIterableNode_ = super.insert((JSStringListFromIterableNode.create(getContext())));
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doFormat(DynamicObject, Object, JSStringListFromIterableNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doFormat(arguments0Value_, arguments1Value, this.format_strListFromIterableNode_);
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 throwTypeError(Object, Object) */;
                lock.unlock();
                hasLock = false;
                throwTypeError(arguments0Value, arguments1Value);
                return null;
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doFormat(DynamicObject, Object, JSStringListFromIterableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.format_strListFromIterableNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "throwTypeError";
            if ((state_0 & 0b10) != 0 /* is-state_0 throwTypeError(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSListFormat(arguments0Value_))) {
                    return false;
                }
            }
            return true;
        }

        public static JSListFormatFormatNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSListFormatFormatNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSListFormatFormatToPartsNode.class)
    public static final class JSListFormatFormatToPartsNodeGen extends JSListFormatFormatToPartsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSStringListFromIterableNode formatToParts_strListFromIterableNode_;

        private JSListFormatFormatToPartsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doFormatToParts(DynamicObject, Object, JSStringListFromIterableNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSListFormat(arguments0Value__))) {
                    return doFormatToParts(arguments0Value__, arguments1Value_, this.formatToParts_strListFromIterableNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doFormatToParts(DynamicObject, Object, JSStringListFromIterableNode) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b10) != 0 /* is-state_0 throwTypeError(Object, Object) */) {
                if (fallbackGuard_(arguments0Value_, arguments1Value_)) {
                    throwTypeError(arguments0Value_, arguments1Value_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_, arguments1Value_);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSListFormat(arguments0Value_))) {
                        this.formatToParts_strListFromIterableNode_ = super.insert((JSStringListFromIterableNode.create(getContext())));
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doFormatToParts(DynamicObject, Object, JSStringListFromIterableNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doFormatToParts(arguments0Value_, arguments1Value, this.formatToParts_strListFromIterableNode_);
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 throwTypeError(Object, Object) */;
                lock.unlock();
                hasLock = false;
                throwTypeError(arguments0Value, arguments1Value);
                return null;
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doFormatToParts(DynamicObject, Object, JSStringListFromIterableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.formatToParts_strListFromIterableNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "throwTypeError";
            if ((state_0 & 0b10) != 0 /* is-state_0 throwTypeError(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSListFormat(arguments0Value_))) {
                    return false;
                }
            }
            return true;
        }

        public static JSListFormatFormatToPartsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSListFormatFormatToPartsNodeGen(context, builtin, arguments);
        }

    }
}
