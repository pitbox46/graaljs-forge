// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.FunctionPrototypeBuiltins.HasInstanceNode;
import com.oracle.truffle.js.builtins.FunctionPrototypeBuiltins.JSApplyNode;
import com.oracle.truffle.js.builtins.FunctionPrototypeBuiltins.JSBindNode;
import com.oracle.truffle.js.builtins.FunctionPrototypeBuiltins.JSCallNode;
import com.oracle.truffle.js.builtins.FunctionPrototypeBuiltins.JSFunctionToStringNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(FunctionPrototypeBuiltins.class)
@SuppressWarnings("unused")
public final class FunctionPrototypeBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(JSBindNode.class)
    public static final class JSBindNodeGen extends JSBindNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private JSBindNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 bindFunction(DynamicObject, Object, Object[]) || bindProxy(DynamicObject, Object, Object[]) || bindError(Object, Object, Object[]) */ && arguments2Value_ instanceof Object[]) {
                Object[] arguments2Value__ = (Object[]) arguments2Value_;
                if ((state_0 & 0b11) != 0 /* is-state_0 bindFunction(DynamicObject, Object, Object[]) || bindProxy(DynamicObject, Object, Object[]) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 bindFunction(DynamicObject, Object, Object[]) */) {
                        if ((JSGuards.isJSFunction(arguments0Value__))) {
                            return bindFunction(arguments0Value__, arguments1Value_, arguments2Value__);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 bindProxy(DynamicObject, Object, Object[]) */) {
                        if ((JSGuards.isJSProxy(arguments0Value__))) {
                            return bindProxy(arguments0Value__, arguments1Value_, arguments2Value__);
                        }
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 bindError(Object, Object, Object[]) */) {
                    if ((!(JSGuards.isJSFunction(arguments0Value_))) && (!(JSGuards.isJSProxy(arguments0Value_)))) {
                        return bindError(arguments0Value_, arguments1Value_, arguments2Value__);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (arguments2Value instanceof Object[]) {
                Object[] arguments2Value_ = (Object[]) arguments2Value;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSFunction(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 bindFunction(DynamicObject, Object, Object[]) */;
                        return bindFunction(arguments0Value_, arguments1Value, arguments2Value_);
                    }
                    if ((JSGuards.isJSProxy(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 bindProxy(DynamicObject, Object, Object[]) */;
                        return bindProxy(arguments0Value_, arguments1Value, arguments2Value_);
                    }
                }
                if ((!(JSGuards.isJSFunction(arguments0Value))) && (!(JSGuards.isJSProxy(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 bindError(Object, Object, Object[]) */;
                    return bindError(arguments0Value, arguments1Value, arguments2Value_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "bindFunction";
            if ((state_0 & 0b1) != 0 /* is-state_0 bindFunction(DynamicObject, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "bindProxy";
            if ((state_0 & 0b10) != 0 /* is-state_0 bindProxy(DynamicObject, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "bindError";
            if ((state_0 & 0b100) != 0 /* is-state_0 bindError(Object, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSBindNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSBindNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSFunctionToStringNode.class)
    public static final class JSFunctionToStringNodeGen extends JSFunctionToStringNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private IsCallableNode isCallable;
        @Child private InteropLibrary toStringCallable0_interop_;

        private JSFunctionToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b11) != 0 /* is-state_0 toStringDefault(DynamicObject) || toStringBound(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 toStringDefault(DynamicObject) */) {
                    if ((JSGuards.isJSFunction(arguments0Value__)) && (!(isBoundTarget(arguments0Value__)))) {
                        return toStringDefault(arguments0Value__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 toStringBound(DynamicObject) */) {
                    if ((JSGuards.isJSFunction(arguments0Value__)) && (isBoundTarget(arguments0Value__))) {
                        return toStringBound(arguments0Value__);
                    }
                }
            }
            if ((state_0 & 0b111100) != 0 /* is-state_0 toStringCallable(Object, IsCallableNode, InteropLibrary) || toStringCallable(Object, IsCallableNode, InteropLibrary) || toStringNotCallable(Object, IsCallableNode) || toStringNotFunction(Object) */) {
                if ((state_0 & 0b100) != 0 /* is-state_0 toStringCallable(Object, IsCallableNode, InteropLibrary) */) {
                    if ((this.toStringCallable0_interop_.accepts(arguments0Value_))) {
                        assert (isES2019OrLater());
                        if ((!(JSGuards.isJSFunction(arguments0Value_))) && (this.isCallable.executeBoolean(arguments0Value_))) {
                            return toStringCallable(arguments0Value_, this.isCallable, this.toStringCallable0_interop_);
                        }
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 toStringCallable(Object, IsCallableNode, InteropLibrary) */) {
                    assert (isES2019OrLater());
                    if ((!(JSGuards.isJSFunction(arguments0Value_))) && (this.isCallable.executeBoolean(arguments0Value_))) {
                        return this.toStringCallable1Boundary(state_0, arguments0Value_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 toStringNotCallable(Object, IsCallableNode) */) {
                    assert (isES2019OrLater());
                    if ((!(this.isCallable.executeBoolean(arguments0Value_)))) {
                        return toStringNotCallable(arguments0Value_, this.isCallable);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 toStringNotFunction(Object) */) {
                    assert (!(isES2019OrLater()));
                    if ((!(JSGuards.isJSFunction(arguments0Value_)))) {
                        return toStringNotFunction(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object toStringCallable1Boundary(int state_0, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary toStringCallable1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return toStringCallable(arguments0Value_, this.isCallable, toStringCallable1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSFunction(arguments0Value_)) && (!(isBoundTarget(arguments0Value_)))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 toStringDefault(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringDefault(arguments0Value_);
                    }
                    if ((JSGuards.isJSFunction(arguments0Value_)) && (isBoundTarget(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 toStringBound(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringBound(arguments0Value_);
                    }
                }
                if ((exclude) == 0 /* is-not-exclude toStringCallable(Object, IsCallableNode, InteropLibrary) */) {
                    boolean ToStringCallable0_duplicateFound_ = false;
                    if ((state_0 & 0b100) != 0 /* is-state_0 toStringCallable(Object, IsCallableNode, InteropLibrary) */) {
                        if ((this.toStringCallable0_interop_.accepts(arguments0Value))) {
                            assert (isES2019OrLater());
                            if ((!(JSGuards.isJSFunction(arguments0Value))) && (this.isCallable.executeBoolean(arguments0Value))) {
                                ToStringCallable0_duplicateFound_ = true;
                            }
                        }
                    }
                    if (!ToStringCallable0_duplicateFound_) {
                        if ((isES2019OrLater()) && (!(JSGuards.isJSFunction(arguments0Value)))) {
                            // assert (this.toStringCallable0_interop_.accepts(arguments0Value));
                            IsCallableNode toStringCallable0_isCallable__ = super.insert(this.isCallable == null ? ((IsCallableNode.create())) : this.isCallable);
                            if ((toStringCallable0_isCallable__.executeBoolean(arguments0Value)) && ((state_0 & 0b100)) == 0 /* is-not-state_0 toStringCallable(Object, IsCallableNode, InteropLibrary) */) {
                                if (this.isCallable == null) {
                                    IsCallableNode toStringCallable0_isCallable___check = super.insert(toStringCallable0_isCallable__);
                                    if (toStringCallable0_isCallable___check == null) {
                                        throw new AssertionError("Specialization 'toStringCallable(Object, IsCallableNode, InteropLibrary)' contains a shared cache with name 'isCallable' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isCallable = toStringCallable0_isCallable___check;
                                }
                                this.toStringCallable0_interop_ = super.insert((INTEROP_LIBRARY_.create(arguments0Value)));
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 toStringCallable(Object, IsCallableNode, InteropLibrary) */;
                                ToStringCallable0_duplicateFound_ = true;
                            }
                        }
                    }
                    if (ToStringCallable0_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return toStringCallable(arguments0Value, this.isCallable, this.toStringCallable0_interop_);
                    }
                }
                {
                    InteropLibrary toStringCallable1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            boolean ToStringCallable1_duplicateFound_ = false;
                            if ((state_0 & 0b1000) != 0 /* is-state_0 toStringCallable(Object, IsCallableNode, InteropLibrary) */) {
                                assert (isES2019OrLater());
                                if ((!(JSGuards.isJSFunction(arguments0Value))) && (this.isCallable.executeBoolean(arguments0Value))) {
                                    ToStringCallable1_duplicateFound_ = true;
                                    toStringCallable1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                }
                            }
                            if (!ToStringCallable1_duplicateFound_) {
                                if ((isES2019OrLater()) && (!(JSGuards.isJSFunction(arguments0Value)))) {
                                    IsCallableNode toStringCallable1_isCallable__ = super.insert(this.isCallable == null ? ((IsCallableNode.create())) : this.isCallable);
                                    if ((toStringCallable1_isCallable__.executeBoolean(arguments0Value)) && ((state_0 & 0b1000)) == 0 /* is-not-state_0 toStringCallable(Object, IsCallableNode, InteropLibrary) */) {
                                        if (this.isCallable == null) {
                                            IsCallableNode toStringCallable1_isCallable___check = super.insert(toStringCallable1_isCallable__);
                                            if (toStringCallable1_isCallable___check == null) {
                                                throw new AssertionError("Specialization 'toStringCallable(Object, IsCallableNode, InteropLibrary)' contains a shared cache with name 'isCallable' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isCallable = toStringCallable1_isCallable___check;
                                        }
                                        toStringCallable1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude toStringCallable(Object, IsCallableNode, InteropLibrary) */;
                                        state_0 = state_0 & 0xfffffffb /* remove-state_0 toStringCallable(Object, IsCallableNode, InteropLibrary) */;
                                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 toStringCallable(Object, IsCallableNode, InteropLibrary) */;
                                        ToStringCallable1_duplicateFound_ = true;
                                    }
                                }
                            }
                            if (ToStringCallable1_duplicateFound_) {
                                lock.unlock();
                                hasLock = false;
                                return toStringCallable(arguments0Value, this.isCallable, toStringCallable1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                boolean ToStringNotCallable_duplicateFound_ = false;
                if ((state_0 & 0b10000) != 0 /* is-state_0 toStringNotCallable(Object, IsCallableNode) */) {
                    assert (isES2019OrLater());
                    if ((!(this.isCallable.executeBoolean(arguments0Value)))) {
                        ToStringNotCallable_duplicateFound_ = true;
                    }
                }
                if (!ToStringNotCallable_duplicateFound_) {
                    if ((isES2019OrLater())) {
                        IsCallableNode toStringNotCallable_isCallable__ = super.insert(this.isCallable == null ? ((IsCallableNode.create())) : this.isCallable);
                        if ((!(toStringNotCallable_isCallable__.executeBoolean(arguments0Value))) && ((state_0 & 0b10000)) == 0 /* is-not-state_0 toStringNotCallable(Object, IsCallableNode) */) {
                            if (this.isCallable == null) {
                                IsCallableNode toStringNotCallable_isCallable___check = super.insert(toStringNotCallable_isCallable__);
                                if (toStringNotCallable_isCallable___check == null) {
                                    throw new AssertionError("Specialization 'toStringNotCallable(Object, IsCallableNode)' contains a shared cache with name 'isCallable' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                }
                                this.isCallable = toStringNotCallable_isCallable___check;
                            }
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 toStringNotCallable(Object, IsCallableNode) */;
                            ToStringNotCallable_duplicateFound_ = true;
                        }
                    }
                }
                if (ToStringNotCallable_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return toStringNotCallable(arguments0Value, this.isCallable);
                }
                if ((!(isES2019OrLater())) && (!(JSGuards.isJSFunction(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 toStringNotFunction(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toStringNotFunction(arguments0Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            Object[] data = new Object[7];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "toStringDefault";
            if ((state_0 & 0b1) != 0 /* is-state_0 toStringDefault(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toStringBound";
            if ((state_0 & 0b10) != 0 /* is-state_0 toStringBound(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toStringCallable";
            if ((state_0 & 0b100) != 0 /* is-state_0 toStringCallable(Object, IsCallableNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable, this.toStringCallable0_interop_));
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude toStringCallable(Object, IsCallableNode, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toStringCallable";
            if ((state_0 & 0b1000) != 0 /* is-state_0 toStringCallable(Object, IsCallableNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "toStringNotCallable";
            if ((state_0 & 0b10000) != 0 /* is-state_0 toStringNotCallable(Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "toStringNotFunction";
            if ((state_0 & 0b100000) != 0 /* is-state_0 toStringNotFunction(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            return Provider.create(data);
        }

        public static JSFunctionToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSFunctionToStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSApplyNode.class)
    public static final class JSApplyNodeGen extends JSApplyNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private IsCallableNode isCallable;

        private JSApplyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 applyFunction(DynamicObject, Object, Object) || applyCallable(Object, Object, Object, IsCallableNode) || error(Object, Object, Object, IsCallableNode) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 applyFunction(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSFunction(arguments0Value__))) {
                        return applyFunction(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b110) != 0 /* is-state_0 applyCallable(Object, Object, Object, IsCallableNode) || error(Object, Object, Object, IsCallableNode) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 applyCallable(Object, Object, Object, IsCallableNode) */) {
                        if ((this.isCallable.executeBoolean(arguments0Value_))) {
                            return applyCallable(arguments0Value_, arguments1Value_, arguments2Value_, this.isCallable);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 error(Object, Object, Object, IsCallableNode) */) {
                        if ((!(this.isCallable.executeBoolean(arguments0Value_)))) {
                            return error(arguments0Value_, arguments1Value_, arguments2Value_, this.isCallable);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude applyFunction(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSFunction(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 applyFunction(DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return applyFunction(arguments0Value_, arguments1Value, arguments2Value);
                    }
                }
                boolean ApplyCallable_duplicateFound_ = false;
                if ((state_0 & 0b10) != 0 /* is-state_0 applyCallable(Object, Object, Object, IsCallableNode) */) {
                    if ((this.isCallable.executeBoolean(arguments0Value))) {
                        ApplyCallable_duplicateFound_ = true;
                    }
                }
                if (!ApplyCallable_duplicateFound_) {
                    {
                        IsCallableNode applyCallable_isCallable__ = super.insert(this.isCallable == null ? ((IsCallableNode.create())) : this.isCallable);
                        if ((applyCallable_isCallable__.executeBoolean(arguments0Value)) && ((state_0 & 0b10)) == 0 /* is-not-state_0 applyCallable(Object, Object, Object, IsCallableNode) */) {
                            if (this.isCallable == null) {
                                IsCallableNode applyCallable_isCallable___check = super.insert(applyCallable_isCallable__);
                                if (applyCallable_isCallable___check == null) {
                                    throw new AssertionError("Specialization 'applyCallable(Object, Object, Object, IsCallableNode)' contains a shared cache with name 'isCallable' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                }
                                this.isCallable = applyCallable_isCallable___check;
                            }
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude applyFunction(DynamicObject, Object, Object) */;
                            state_0 = state_0 & 0xfffffffe /* remove-state_0 applyFunction(DynamicObject, Object, Object) */;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 applyCallable(Object, Object, Object, IsCallableNode) */;
                            ApplyCallable_duplicateFound_ = true;
                        }
                    }
                }
                if (ApplyCallable_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return applyCallable(arguments0Value, arguments1Value, arguments2Value, this.isCallable);
                }
                boolean Error_duplicateFound_ = false;
                if ((state_0 & 0b100) != 0 /* is-state_0 error(Object, Object, Object, IsCallableNode) */) {
                    if ((!(this.isCallable.executeBoolean(arguments0Value)))) {
                        Error_duplicateFound_ = true;
                    }
                }
                if (!Error_duplicateFound_) {
                    {
                        IsCallableNode error_isCallable__ = super.insert(this.isCallable == null ? ((IsCallableNode.create())) : this.isCallable);
                        if ((!(error_isCallable__.executeBoolean(arguments0Value))) && ((state_0 & 0b100)) == 0 /* is-not-state_0 error(Object, Object, Object, IsCallableNode) */) {
                            if (this.isCallable == null) {
                                IsCallableNode error_isCallable___check = super.insert(error_isCallable__);
                                if (error_isCallable___check == null) {
                                    throw new AssertionError("Specialization 'error(Object, Object, Object, IsCallableNode)' contains a shared cache with name 'isCallable' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                }
                                this.isCallable = error_isCallable___check;
                            }
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 error(Object, Object, Object, IsCallableNode) */;
                            Error_duplicateFound_ = true;
                        }
                    }
                }
                if (Error_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return error(arguments0Value, arguments1Value, arguments2Value, this.isCallable);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "applyFunction";
            if ((state_0 & 0b1) != 0 /* is-state_0 applyFunction(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-exclude applyFunction(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "applyCallable";
            if ((state_0 & 0b10) != 0 /* is-state_0 applyCallable(Object, Object, Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "error";
            if ((state_0 & 0b100) != 0 /* is-state_0 error(Object, Object, Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSApplyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSApplyNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSCallNode.class)
    public static final class JSCallNodeGen extends JSCallNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private JSCallNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 call(Object, Object, Object[]) */ && arguments2Value_ instanceof Object[]) {
                Object[] arguments2Value__ = (Object[]) arguments2Value_;
                return call(arguments0Value_, arguments1Value_, arguments2Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (arguments2Value instanceof Object[]) {
                Object[] arguments2Value_ = (Object[]) arguments2Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 call(Object, Object, Object[]) */;
                return call(arguments0Value, arguments1Value, arguments2Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if (state_0 == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                return NodeCost.MONOMORPHIC;
            }
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "call";
            if (state_0 != 0 /* is-state_0 call(Object, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSCallNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSCallNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(HasInstanceNode.class)
    public static final class HasInstanceNodeGen extends HasInstanceNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private HasInstanceNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return hasInstance(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return hasInstance(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "hasInstance";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static HasInstanceNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new HasInstanceNodeGen(context, builtin, arguments);
        }

    }
}
