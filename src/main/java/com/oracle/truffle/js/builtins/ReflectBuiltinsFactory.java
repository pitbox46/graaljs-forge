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
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectApplyNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectConstructNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectDefinePropertyNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectDeletePropertyNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectGetNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectGetOwnPropertyDescriptorNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectGetPrototypeOfNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectHasNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectIsExtensibleNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectOwnKeysNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectPreventExtensionsNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectSetNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectSetPrototypeOfNode;
import com.oracle.truffle.js.builtins.helper.ListSizeNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.FromPropertyDescriptorNode;
import com.oracle.truffle.js.nodes.access.IsExtensibleNode;
import com.oracle.truffle.js.nodes.access.JSGetOwnPropertyNode;
import com.oracle.truffle.js.nodes.access.ToPropertyDescriptorNode;
import com.oracle.truffle.js.nodes.cast.JSToPropertyKeyNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.nodes.unary.IsConstructorNode;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ReflectBuiltins.class)
@SuppressWarnings("unused")
public final class ReflectBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(ReflectApplyNode.class)
    public static final class ReflectApplyNodeGen extends ReflectApplyNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private IsCallableNode isCallable;

        private ReflectApplyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
                            return ReflectApplyNode.error(arguments0Value_, arguments1Value_, arguments2Value_, this.isCallable);
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
                    return ReflectApplyNode.error(arguments0Value, arguments1Value, arguments2Value, this.isCallable);
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

        public static ReflectApplyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectApplyNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ReflectConstructNode.class)
    public static final class ReflectConstructNodeGen extends ReflectConstructNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private IsConstructorNode isConstructorNode_;

        private ReflectConstructNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 reflectConstruct(Object, Object, Object[], IsConstructorNode) */ && arguments2Value_ instanceof Object[]) {
                Object[] arguments2Value__ = (Object[]) arguments2Value_;
                return reflectConstruct(arguments0Value_, arguments1Value_, arguments2Value__, this.isConstructorNode_);
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
                if (arguments2Value instanceof Object[]) {
                    Object[] arguments2Value_ = (Object[]) arguments2Value;
                    this.isConstructorNode_ = super.insert((IsConstructorNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 reflectConstruct(Object, Object, Object[], IsConstructorNode) */;
                    lock.unlock();
                    hasLock = false;
                    return reflectConstruct(arguments0Value, arguments1Value, arguments2Value_, this.isConstructorNode_);
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
            s[0] = "reflectConstruct";
            if (state_0 != 0 /* is-state_0 reflectConstruct(Object, Object, Object[], IsConstructorNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isConstructorNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectConstructNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectConstructNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ReflectDefinePropertyNode.class)
    public static final class ReflectDefinePropertyNodeGen extends ReflectDefinePropertyNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToPropertyKeyNode toPropertyKeyNode_;
        @Child private ToPropertyDescriptorNode toPropertyDescriptorNode_;

        private ReflectDefinePropertyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 reflectDefineProperty(Object, Object, Object, JSToPropertyKeyNode, ToPropertyDescriptorNode) */) {
                return reflectDefineProperty(arguments0Value_, arguments1Value_, arguments2Value_, this.toPropertyKeyNode_, this.toPropertyDescriptorNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 reflectDefineProperty(Object, Object, Object, JSToPropertyKeyNode, ToPropertyDescriptorNode) */) {
                return reflectDefineProperty(arguments0Value_, arguments1Value_, arguments2Value_, this.toPropertyKeyNode_, this.toPropertyDescriptorNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                this.toPropertyKeyNode_ = super.insert((JSToPropertyKeyNode.create()));
                this.toPropertyDescriptorNode_ = super.insert((ToPropertyDescriptorNode.create(getContext())));
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 reflectDefineProperty(Object, Object, Object, JSToPropertyKeyNode, ToPropertyDescriptorNode) */;
                lock.unlock();
                hasLock = false;
                return reflectDefineProperty(arguments0Value, arguments1Value, arguments2Value, this.toPropertyKeyNode_, this.toPropertyDescriptorNode_);
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
            s[0] = "reflectDefineProperty";
            if (state_0 != 0 /* is-state_0 reflectDefineProperty(Object, Object, Object, JSToPropertyKeyNode, ToPropertyDescriptorNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toPropertyKeyNode_, this.toPropertyDescriptorNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectDefinePropertyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectDefinePropertyNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ReflectDeletePropertyNode.class)
    public static final class ReflectDeletePropertyNodeGen extends ReflectDeletePropertyNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSClassProfile object_classProfile_;
        @Child private ForeignObject0Data foreignObject0_cache;

        private ReflectDeletePropertyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 doObject(DynamicObject, Object, JSClassProfile) || doForeignObject(Object, Object, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary) || doNonObject(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject, Object, JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doObject(arguments0Value__, arguments1Value_, this.object_classProfile_);
                    }
                }
                if ((state_0 & 0b1110) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary) || doNonObject(Object, Object) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) */) {
                        ForeignObject0Data s1_ = this.foreignObject0_cache;
                        while (s1_ != null) {
                            if ((s1_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return doForeignObject(arguments0Value_, arguments1Value_, s1_.interop_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.foreignObject1Boundary(state_0, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object, Object) */) {
                        if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return doNonObject(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object foreignObject1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, arguments1Value_, foreignObject1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @ExplodeLoop
        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 doObject(DynamicObject, Object, JSClassProfile) || doForeignObject(Object, Object, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary) || doNonObject(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject, Object, JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doObject(arguments0Value__, arguments1Value_, this.object_classProfile_);
                    }
                }
                if ((state_0 & 0b1110) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary) || doNonObject(Object, Object) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) */) {
                        ForeignObject0Data s1_ = this.foreignObject0_cache;
                        while (s1_ != null) {
                            if ((s1_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return doForeignObject(arguments0Value_, arguments1Value_, s1_.interop_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.foreignObject1Boundary0(state_0, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object, Object) */) {
                        if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return doNonObject(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private boolean foreignObject1Boundary0(int state_0, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, arguments1Value_, foreignObject1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.object_classProfile_ = (JSClassProfile.create());
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doObject(DynamicObject, Object, JSClassProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doObject(arguments0Value_, arguments1Value, this.object_classProfile_);
                    }
                }
                if ((exclude) == 0 /* is-not-exclude doForeignObject(Object, Object, InteropLibrary) */) {
                    int count1_ = 0;
                    ForeignObject0Data s1_ = this.foreignObject0_cache;
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && count1_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s1_.interop_.accepts(arguments0Value));
                            s1_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                            s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.foreignObject0_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignObject(Object, Object, InteropLibrary) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doForeignObject(arguments0Value, arguments1Value, s1_.interop_);
                    }
                }
                {
                    InteropLibrary foreignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doForeignObject(Object, Object, InteropLibrary) */;
                                this.foreignObject0_cache = null;
                                state_0 = state_0 & 0xfffffffd /* remove-state_0 doForeignObject(Object, Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doForeignObject(Object, Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return doForeignObject(arguments0Value, arguments1Value, foreignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doNonObject(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNonObject(arguments0Value, arguments1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
                    ForeignObject0Data s1_ = this.foreignObject0_cache;
                    if ((s1_ == null || s1_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "doObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject, Object, JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object_classProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ForeignObject0Data s1_ = this.foreignObject0_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.interop_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doForeignObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNonObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ReflectDeletePropertyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectDeletePropertyNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ReflectDeletePropertyNode.class)
        private static final class ForeignObject0Data extends Node {

            @Child ForeignObject0Data next_;
            @Child InteropLibrary interop_;

            ForeignObject0Data(ForeignObject0Data next_) {
                this.next_ = next_;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
    }
    @GeneratedBy(ReflectGetNode.class)
    public static final class ReflectGetNodeGen extends ReflectGetNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSClassProfile object_classProfile_;
        @Child private ForeignObject0Data foreignObject0_cache;
        @Child private ImportValueNode foreignObject1_importValue_;

        private ReflectGetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 doObject(DynamicObject, Object, Object[], JSClassProfile) || doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) || doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) || doNonObject(Object, Object, Object[]) */ && arguments2Value_ instanceof Object[]) {
                Object[] arguments2Value__ = (Object[]) arguments2Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject, Object, Object[], JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doObject(arguments0Value__, arguments1Value_, arguments2Value__, this.object_classProfile_);
                    }
                }
                if ((state_0 & 0b1110) != 0 /* is-state_0 doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) || doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) || doNonObject(Object, Object, Object[]) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                        ForeignObject0Data s1_ = this.foreignObject0_cache;
                        while (s1_ != null) {
                            if ((s1_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return doForeignObject(arguments0Value_, arguments1Value_, arguments2Value__, s1_.interop_, s1_.importValue_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.foreignObject1Boundary(state_0, arguments0Value_, arguments1Value_, arguments2Value__);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object, Object, Object[]) */) {
                        if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return doNonObject(arguments0Value_, arguments1Value_, arguments2Value__);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object foreignObject1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_, Object[] arguments2Value__) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, arguments1Value_, arguments2Value__, foreignObject1_interop__, this.foreignObject1_importValue_);
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

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (arguments2Value instanceof Object[]) {
                    Object[] arguments2Value_ = (Object[]) arguments2Value;
                    if (JSTypes.isDynamicObject(arguments0Value)) {
                        DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.object_classProfile_ = (JSClassProfile.create());
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doObject(DynamicObject, Object, Object[], JSClassProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return doObject(arguments0Value_, arguments1Value, arguments2Value_, this.object_classProfile_);
                        }
                    }
                    if ((exclude) == 0 /* is-not-exclude doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                        int count1_ = 0;
                        ForeignObject0Data s1_ = this.foreignObject0_cache;
                        if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                            while (s1_ != null) {
                                if ((s1_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            if ((JSGuards.isForeignObject(arguments0Value)) && count1_ < (JSConfig.InteropLibraryLimit)) {
                                // assert (s1_.interop_.accepts(arguments0Value));
                                s1_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                                s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                                s1_.importValue_ = s1_.insertAccessor((ImportValueNode.create()));
                                MemoryFence.storeStore();
                                this.foreignObject0_cache = s1_;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */;
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doForeignObject(arguments0Value, arguments1Value, arguments2Value_, s1_.interop_, s1_.importValue_);
                        }
                    }
                    {
                        InteropLibrary foreignObject1_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                if ((JSGuards.isForeignObject(arguments0Value))) {
                                    foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                    this.foreignObject1_importValue_ = super.insert((ImportValueNode.create()));
                                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */;
                                    this.foreignObject0_cache = null;
                                    state_0 = state_0 & 0xfffffffd /* remove-state_0 doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */;
                                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doForeignObject(arguments0Value, arguments1Value, arguments2Value_, foreignObject1_interop__, this.foreignObject1_importValue_);
                                }
                            } finally {
                                encapsulating_.set(prev_);
                            }
                        }
                    }
                    if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doNonObject(Object, Object, Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return doNonObject(arguments0Value, arguments1Value, arguments2Value_);
                    }
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
                    ForeignObject0Data s1_ = this.foreignObject0_cache;
                    if ((s1_ == null || s1_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "doObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject, Object, Object[], JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object_classProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ForeignObject0Data s1_ = this.foreignObject0_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.interop_, s1_.importValue_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.foreignObject1_importValue_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNonObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ReflectGetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectGetNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ReflectGetNode.class)
        private static final class ForeignObject0Data extends Node {

            @Child ForeignObject0Data next_;
            @Child InteropLibrary interop_;
            @Child ImportValueNode importValue_;

            ForeignObject0Data(ForeignObject0Data next_) {
                this.next_ = next_;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
    }
    @GeneratedBy(ReflectGetOwnPropertyDescriptorNode.class)
    public static final class ReflectGetOwnPropertyDescriptorNodeGen extends ReflectGetOwnPropertyDescriptorNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private ReflectGetOwnPropertyDescriptorData reflectGetOwnPropertyDescriptor_cache;

        private ReflectGetOwnPropertyDescriptorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 reflectGetOwnPropertyDescriptor(Object, Object, JSToPropertyKeyNode, JSGetOwnPropertyNode, FromPropertyDescriptorNode) */) {
                ReflectGetOwnPropertyDescriptorData s0_ = this.reflectGetOwnPropertyDescriptor_cache;
                if (s0_ != null) {
                    return reflectGetOwnPropertyDescriptor(arguments0Value_, arguments1Value_, s0_.toPropertyKeyNode_, s0_.getOwnPropertyNode_, s0_.fromPropertyDescriptorNode_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                ReflectGetOwnPropertyDescriptorData s0_ = super.insert(new ReflectGetOwnPropertyDescriptorData());
                s0_.toPropertyKeyNode_ = s0_.insertAccessor((JSToPropertyKeyNode.create()));
                s0_.getOwnPropertyNode_ = s0_.insertAccessor((JSGetOwnPropertyNode.create()));
                s0_.fromPropertyDescriptorNode_ = s0_.insertAccessor((FromPropertyDescriptorNode.create()));
                MemoryFence.storeStore();
                this.reflectGetOwnPropertyDescriptor_cache = s0_;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 reflectGetOwnPropertyDescriptor(Object, Object, JSToPropertyKeyNode, JSGetOwnPropertyNode, FromPropertyDescriptorNode) */;
                lock.unlock();
                hasLock = false;
                return reflectGetOwnPropertyDescriptor(arguments0Value, arguments1Value, s0_.toPropertyKeyNode_, s0_.getOwnPropertyNode_, s0_.fromPropertyDescriptorNode_);
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
            s[0] = "reflectGetOwnPropertyDescriptor";
            if (state_0 != 0 /* is-state_0 reflectGetOwnPropertyDescriptor(Object, Object, JSToPropertyKeyNode, JSGetOwnPropertyNode, FromPropertyDescriptorNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ReflectGetOwnPropertyDescriptorData s0_ = this.reflectGetOwnPropertyDescriptor_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.toPropertyKeyNode_, s0_.getOwnPropertyNode_, s0_.fromPropertyDescriptorNode_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectGetOwnPropertyDescriptorNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectGetOwnPropertyDescriptorNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ReflectGetOwnPropertyDescriptorNode.class)
        private static final class ReflectGetOwnPropertyDescriptorData extends Node {

            @Child JSToPropertyKeyNode toPropertyKeyNode_;
            @Child JSGetOwnPropertyNode getOwnPropertyNode_;
            @Child FromPropertyDescriptorNode fromPropertyDescriptorNode_;

            ReflectGetOwnPropertyDescriptorData() {
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
    }
    @GeneratedBy(ReflectGetPrototypeOfNode.class)
    public static final class ReflectGetPrototypeOfNodeGen extends ReflectGetPrototypeOfNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private ReflectGetPrototypeOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return reflectGetPrototypeOf(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
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
            s[0] = "reflectGetPrototypeOf";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectGetPrototypeOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectGetPrototypeOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ReflectHasNode.class)
    public static final class ReflectHasNodeGen extends ReflectHasNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSClassProfile object_jsclassProfile_;
        @Child private ForeignObject0Data foreignObject0_cache;

        private ReflectHasNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 doObject(DynamicObject, Object, JSClassProfile) || doForeignObject(Object, Object, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary) || doNonObject(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject, Object, JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doObject(arguments0Value__, arguments1Value_, this.object_jsclassProfile_);
                    }
                }
                if ((state_0 & 0b1110) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary) || doNonObject(Object, Object) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) */) {
                        ForeignObject0Data s1_ = this.foreignObject0_cache;
                        while (s1_ != null) {
                            if ((s1_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return doForeignObject(arguments0Value_, arguments1Value_, s1_.interop_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.foreignObject1Boundary(state_0, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object, Object) */) {
                        if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return doNonObject(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object foreignObject1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, arguments1Value_, foreignObject1_interop__);
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

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.object_jsclassProfile_ = (JSClassProfile.create());
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doObject(DynamicObject, Object, JSClassProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doObject(arguments0Value_, arguments1Value, this.object_jsclassProfile_);
                    }
                }
                if ((exclude) == 0 /* is-not-exclude doForeignObject(Object, Object, InteropLibrary) */) {
                    int count1_ = 0;
                    ForeignObject0Data s1_ = this.foreignObject0_cache;
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && count1_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s1_.interop_.accepts(arguments0Value));
                            s1_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                            s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.foreignObject0_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignObject(Object, Object, InteropLibrary) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doForeignObject(arguments0Value, arguments1Value, s1_.interop_);
                    }
                }
                {
                    InteropLibrary foreignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doForeignObject(Object, Object, InteropLibrary) */;
                                this.foreignObject0_cache = null;
                                state_0 = state_0 & 0xfffffffd /* remove-state_0 doForeignObject(Object, Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doForeignObject(Object, Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return doForeignObject(arguments0Value, arguments1Value, foreignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doNonObject(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNonObject(arguments0Value, arguments1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
                    ForeignObject0Data s1_ = this.foreignObject0_cache;
                    if ((s1_ == null || s1_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "doObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject, Object, JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object_jsclassProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ForeignObject0Data s1_ = this.foreignObject0_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.interop_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doForeignObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNonObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ReflectHasNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectHasNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ReflectHasNode.class)
        private static final class ForeignObject0Data extends Node {

            @Child ForeignObject0Data next_;
            @Child InteropLibrary interop_;

            ForeignObject0Data(ForeignObject0Data next_) {
                this.next_ = next_;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
    }
    @GeneratedBy(ReflectIsExtensibleNode.class)
    public static final class ReflectIsExtensibleNodeGen extends ReflectIsExtensibleNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private IsExtensibleNode isExtensibleNode_;

        private ReflectIsExtensibleNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 reflectIsExtensible(Object, IsExtensibleNode) */) {
                return reflectIsExtensible(arguments0Value_, this.isExtensibleNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 reflectIsExtensible(Object, IsExtensibleNode) */) {
                return reflectIsExtensible(arguments0Value_, this.isExtensibleNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                this.isExtensibleNode_ = super.insert((IsExtensibleNode.create()));
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 reflectIsExtensible(Object, IsExtensibleNode) */;
                lock.unlock();
                hasLock = false;
                return reflectIsExtensible(arguments0Value, this.isExtensibleNode_);
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
            s[0] = "reflectIsExtensible";
            if (state_0 != 0 /* is-state_0 reflectIsExtensible(Object, IsExtensibleNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isExtensibleNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectIsExtensibleNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectIsExtensibleNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ReflectOwnKeysNode.class)
    public static final class ReflectOwnKeysNodeGen extends ReflectOwnKeysNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSClassProfile reflectOwnKeys_jsclassProfile_;
        @Child private ListSizeNode reflectOwnKeys_listSize_;
        @Child private ForeignObject0Data foreignObject0_cache;

        private ReflectOwnKeysNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 reflectOwnKeys(Object, JSClassProfile, ListSizeNode) || doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) || doNonObject(Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 reflectOwnKeys(Object, JSClassProfile, ListSizeNode) */) {
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        return reflectOwnKeys(arguments0Value_, this.reflectOwnKeys_jsclassProfile_, this.reflectOwnKeys_listSize_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                    ForeignObject0Data s1_ = this.foreignObject0_cache;
                    while (s1_ != null) {
                        if ((s1_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return doForeignObject(arguments0Value_, s1_.interop_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return this.foreignObject1Boundary(state_0, arguments0Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                        return doNonObject(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object foreignObject1Boundary(int state_0, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, foreignObject1_interop__);
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

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((JSGuards.isJSObject(arguments0Value))) {
                    this.reflectOwnKeys_jsclassProfile_ = (JSClassProfile.create());
                    this.reflectOwnKeys_listSize_ = super.insert((ListSizeNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 reflectOwnKeys(Object, JSClassProfile, ListSizeNode) */;
                    lock.unlock();
                    hasLock = false;
                    return reflectOwnKeys(arguments0Value, this.reflectOwnKeys_jsclassProfile_, this.reflectOwnKeys_listSize_);
                }
                if ((exclude) == 0 /* is-not-exclude doForeignObject(Object, InteropLibrary) */) {
                    int count1_ = 0;
                    ForeignObject0Data s1_ = this.foreignObject0_cache;
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && count1_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s1_.interop_.accepts(arguments0Value));
                            s1_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                            s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.foreignObject0_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignObject(Object, InteropLibrary) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doForeignObject(arguments0Value, s1_.interop_);
                    }
                }
                {
                    InteropLibrary foreignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doForeignObject(Object, InteropLibrary) */;
                                this.foreignObject0_cache = null;
                                state_0 = state_0 & 0xfffffffd /* remove-state_0 doForeignObject(Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doForeignObject(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return doForeignObject(arguments0Value, foreignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doNonObject(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNonObject(arguments0Value);
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
                    ForeignObject0Data s1_ = this.foreignObject0_cache;
                    if ((s1_ == null || s1_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "reflectOwnKeys";
            if ((state_0 & 0b1) != 0 /* is-state_0 reflectOwnKeys(Object, JSClassProfile, ListSizeNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.reflectOwnKeys_jsclassProfile_, this.reflectOwnKeys_listSize_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ForeignObject0Data s1_ = this.foreignObject0_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.interop_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNonObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ReflectOwnKeysNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectOwnKeysNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ReflectOwnKeysNode.class)
        private static final class ForeignObject0Data extends Node {

            @Child ForeignObject0Data next_;
            @Child InteropLibrary interop_;

            ForeignObject0Data(ForeignObject0Data next_) {
                this.next_ = next_;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
    }
    @GeneratedBy(ReflectPreventExtensionsNode.class)
    public static final class ReflectPreventExtensionsNodeGen extends ReflectPreventExtensionsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private ReflectPreventExtensionsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return reflectPreventExtensions(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return reflectPreventExtensions(arguments0Value_);
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
            s[0] = "reflectPreventExtensions";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectPreventExtensionsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectPreventExtensionsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ReflectSetNode.class)
    public static final class ReflectSetNodeGen extends ReflectSetNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSClassProfile reflectSet_jsclassProfile_;
        @Child private ForeignObject0Data foreignObject0_cache;
        @Child private ExportValueNode foreignObject1_exportValue_;

        private ReflectSetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) || doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) || doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) || doNonObject(Object, Object, Object, Object[]) */ && arguments3Value_ instanceof Object[]) {
                Object[] arguments3Value__ = (Object[]) arguments3Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return reflectSet(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value__, this.reflectSet_jsclassProfile_);
                    }
                }
                if ((state_0 & 0b1110) != 0 /* is-state_0 doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) || doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) || doNonObject(Object, Object, Object, Object[]) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                        ForeignObject0Data s1_ = this.foreignObject0_cache;
                        while (s1_ != null) {
                            if ((s1_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return doForeignObject(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value__, s1_.interop_, s1_.exportValue_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.foreignObject1Boundary(state_0, arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value__);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object, Object, Object, Object[]) */) {
                        if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return doNonObject(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value__);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object foreignObject1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_, Object arguments2Value_, Object[] arguments3Value__) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value__, foreignObject1_interop__, this.foreignObject1_exportValue_);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1110) != 0 /* is-state_0 doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) || doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) || doNonObject(Object, Object, Object, Object[]) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments3Value_ instanceof Object[]) {
                    Object[] arguments3Value__ = (Object[]) arguments3Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return reflectSet(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value__, this.reflectSet_jsclassProfile_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b1110) == 0 /* only-active reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) */ && (state_0 != 0  /* is-not reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) && doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) && doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) && doNonObject(Object, Object, Object, Object[]) */)) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value, Object arguments3Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (arguments3Value instanceof Object[]) {
                    Object[] arguments3Value_ = (Object[]) arguments3Value;
                    if (JSTypes.isDynamicObject(arguments0Value)) {
                        DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.reflectSet_jsclassProfile_ = (JSClassProfile.create());
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return reflectSet(arguments0Value_, arguments1Value, arguments2Value, arguments3Value_, this.reflectSet_jsclassProfile_);
                        }
                    }
                    if ((exclude) == 0 /* is-not-exclude doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                        int count1_ = 0;
                        ForeignObject0Data s1_ = this.foreignObject0_cache;
                        if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                            while (s1_ != null) {
                                if ((s1_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            if ((JSGuards.isForeignObject(arguments0Value)) && count1_ < (JSConfig.InteropLibraryLimit)) {
                                // assert (s1_.interop_.accepts(arguments0Value));
                                s1_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                                s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                                s1_.exportValue_ = s1_.insertAccessor((ExportValueNode.create()));
                                MemoryFence.storeStore();
                                this.foreignObject0_cache = s1_;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */;
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doForeignObject(arguments0Value, arguments1Value, arguments2Value, arguments3Value_, s1_.interop_, s1_.exportValue_);
                        }
                    }
                    {
                        InteropLibrary foreignObject1_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                if ((JSGuards.isForeignObject(arguments0Value))) {
                                    foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                    this.foreignObject1_exportValue_ = super.insert((ExportValueNode.create()));
                                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */;
                                    this.foreignObject0_cache = null;
                                    state_0 = state_0 & 0xfffffffd /* remove-state_0 doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */;
                                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doForeignObject(arguments0Value, arguments1Value, arguments2Value, arguments3Value_, foreignObject1_interop__, this.foreignObject1_exportValue_);
                                }
                            } finally {
                                encapsulating_.set(prev_);
                            }
                        }
                    }
                    if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doNonObject(Object, Object, Object, Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return doNonObject(arguments0Value, arguments1Value, arguments2Value, arguments3Value_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_}, arguments0Value, arguments1Value, arguments2Value, arguments3Value);
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
                    ForeignObject0Data s1_ = this.foreignObject0_cache;
                    if ((s1_ == null || s1_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "reflectSet";
            if ((state_0 & 0b1) != 0 /* is-state_0 reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.reflectSet_jsclassProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ForeignObject0Data s1_ = this.foreignObject0_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.interop_, s1_.exportValue_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.foreignObject1_exportValue_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNonObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object, Object, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ReflectSetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectSetNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ReflectSetNode.class)
        private static final class ForeignObject0Data extends Node {

            @Child ForeignObject0Data next_;
            @Child InteropLibrary interop_;
            @Child ExportValueNode exportValue_;

            ForeignObject0Data(ForeignObject0Data next_) {
                this.next_ = next_;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
    }
    @GeneratedBy(ReflectSetPrototypeOfNode.class)
    public static final class ReflectSetPrototypeOfNodeGen extends ReflectSetPrototypeOfNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private ReflectSetPrototypeOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return reflectSetPrototypeOf(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return reflectSetPrototypeOf(arguments0Value_, arguments1Value_);
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
            s[0] = "reflectSetPrototypeOf";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectSetPrototypeOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectSetPrototypeOfNodeGen(context, builtin, arguments);
        }

    }
}
