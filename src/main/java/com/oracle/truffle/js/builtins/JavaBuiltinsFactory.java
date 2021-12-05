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
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaAddToClasspathNode;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaExtendNode;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaFromNode;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaIsJavaFunctionNode;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaIsJavaMethodNode;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaIsJavaObject;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaIsScriptFunctionNode;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaIsScriptObjectNode;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaIsTypeNode;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaSuperNode;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaSynchronizedNode;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaToNode;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaTypeNameNode;
import com.oracle.truffle.js.builtins.JavaBuiltins.JavaTypeNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JavaBuiltins.class)
@SuppressWarnings("unused")
public final class JavaBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(JavaTypeNode.class)
    static final class JavaTypeNodeGen extends JavaTypeNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private JavaTypeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 type(String) */ && JSTypesGen.isImplicitString((state_0 & 0b11100) >>> 2 /* extract-implicit-state_0 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state_0 & 0b11100) >>> 2 /* extract-implicit-state_0 0:String */, arguments0Value_);
                return type(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 typeNoString(Object) */) {
                if ((!(JSGuards.isString(arguments0Value_)))) {
                    return typeNoString(arguments0Value_);
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
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                    String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                    state_0 = (state_0 | (stringCast0 << 2) /* set-implicit-state_0 0:String */);
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 type(String) */;
                    return type(arguments0Value_);
                }
            }
            if ((!(JSGuards.isString(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 typeNoString(Object) */;
                return typeNoString(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b11) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b11) & ((state_0 & 0b11) - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "type";
            if ((state_0 & 0b1) != 0 /* is-state_0 type(String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "typeNoString";
            if ((state_0 & 0b10) != 0 /* is-state_0 typeNoString(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JavaTypeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaTypeNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JavaTypeNameNode.class)
    static final class JavaTypeNameNodeGen extends JavaTypeNameNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private JavaTypeNameNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        private boolean fallbackGuard_(int state_0, Object arguments0Value) {
            if (((state_0 & 0b1)) == 0 /* is-not-state_0 typeNameJavaInteropClass(Object) */ && (isJavaInteropClass(arguments0Value))) {
                return false;
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 typeNameJavaInteropClass(Object) || nonType(Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 typeNameJavaInteropClass(Object) */) {
                    if ((isJavaInteropClass(arguments0Value_))) {
                        return typeNameJavaInteropClass(arguments0Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 nonType(Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_)) {
                        return nonType(arguments0Value_);
                    }
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
            if ((isJavaInteropClass(arguments0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 typeNameJavaInteropClass(Object) */;
                return typeNameJavaInteropClass(arguments0Value);
            }
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 nonType(Object) */;
            return nonType(arguments0Value);
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
            s[0] = "typeNameJavaInteropClass";
            if ((state_0 & 0b1) != 0 /* is-state_0 typeNameJavaInteropClass(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "nonType";
            if ((state_0 & 0b10) != 0 /* is-state_0 nonType(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JavaTypeNameNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaTypeNameNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JavaExtendNode.class)
    static final class JavaExtendNodeGen extends JavaExtendNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private JavaExtendNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 extend(Object[]) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                return extend(arguments0Value__);
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
            if (arguments0Value instanceof Object[]) {
                Object[] arguments0Value_ = (Object[]) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 extend(Object[]) */;
                return extend(arguments0Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "extend";
            if (state_0 != 0 /* is-state_0 extend(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JavaExtendNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaExtendNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JavaFromNode.class)
    static final class JavaFromNodeGen extends JavaFromNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private JavaFromNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return from(arguments0Value_);
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
            s[0] = "from";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JavaFromNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaFromNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JavaToNode.class)
    static final class JavaToNodeGen extends JavaToNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ToNonObject0Data toNonObject0_cache;

        private JavaToNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 to(Object, Object) || toNonObject(Object, Object, InteropLibrary) || toNonObject(Object, Object, InteropLibrary) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 to(Object, Object) */) {
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        return to(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 toNonObject(Object, Object, InteropLibrary) */) {
                    ToNonObject0Data s1_ = this.toNonObject0_cache;
                    while (s1_ != null) {
                        if ((s1_.interop_.accepts(arguments0Value_)) && (!(JSGuards.isJSObject(arguments0Value_)))) {
                            return toNonObject(arguments0Value_, arguments1Value_, s1_.interop_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 toNonObject(Object, Object, InteropLibrary) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                        return this.toNonObject1Boundary(state_0, arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object toNonObject1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary toNonObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return toNonObject(arguments0Value_, arguments1Value_, toNonObject1_interop__);
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
                if ((JSGuards.isJSObject(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 to(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return to(arguments0Value, arguments1Value);
                }
                if ((exclude) == 0 /* is-not-exclude toNonObject(Object, Object, InteropLibrary) */) {
                    int count1_ = 0;
                    ToNonObject0Data s1_ = this.toNonObject0_cache;
                    if ((state_0 & 0b10) != 0 /* is-state_0 toNonObject(Object, Object, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.interop_.accepts(arguments0Value)) && (!(JSGuards.isJSObject(arguments0Value)))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        if ((!(JSGuards.isJSObject(arguments0Value))) && count1_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s1_.interop_.accepts(arguments0Value));
                            s1_ = super.insert(new ToNonObject0Data(toNonObject0_cache));
                            s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.toNonObject0_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 toNonObject(Object, Object, InteropLibrary) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return toNonObject(arguments0Value, arguments1Value, s1_.interop_);
                    }
                }
                {
                    InteropLibrary toNonObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((!(JSGuards.isJSObject(arguments0Value)))) {
                                toNonObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude toNonObject(Object, Object, InteropLibrary) */;
                                this.toNonObject0_cache = null;
                                state_0 = state_0 & 0xfffffffd /* remove-state_0 toNonObject(Object, Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 toNonObject(Object, Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return toNonObject(arguments0Value, arguments1Value, toNonObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
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
                    ToNonObject0Data s1_ = this.toNonObject0_cache;
                    if ((s1_ == null || s1_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
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
            s[0] = "to";
            if ((state_0 & 0b1) != 0 /* is-state_0 to(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toNonObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 toNonObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ToNonObject0Data s1_ = this.toNonObject0_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.interop_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude toNonObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toNonObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 toNonObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JavaToNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaToNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JavaToNode.class)
        private static final class ToNonObject0Data extends Node {

            @Child ToNonObject0Data next_;
            @Child InteropLibrary interop_;

            ToNonObject0Data(ToNonObject0Data next_) {
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
    @GeneratedBy(JavaSuperNode.class)
    static final class JavaSuperNodeGen extends JavaSuperNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private JavaSuperNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return superAdapter(arguments0Value_);
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
            s[0] = "superAdapter";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JavaSuperNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaSuperNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JavaIsTypeNode.class)
    static final class JavaIsTypeNodeGen extends JavaIsTypeNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private JavaIsTypeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return isType(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return isType(arguments0Value_);
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
            s[0] = "isType";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JavaIsTypeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaIsTypeNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JavaIsJavaObject.class)
    static final class JavaIsJavaObjectNodeGen extends JavaIsJavaObject implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private JavaIsJavaObjectNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return isJavaObject(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return isJavaObject(arguments0Value_);
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
            s[0] = "isJavaObject";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JavaIsJavaObject create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaIsJavaObjectNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JavaIsJavaMethodNode.class)
    static final class JavaIsJavaMethodNodeGen extends JavaIsJavaMethodNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private JavaIsJavaMethodNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return isJavaMethod(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return isJavaMethod(arguments0Value_);
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
            s[0] = "isJavaMethod";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JavaIsJavaMethodNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaIsJavaMethodNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JavaIsJavaFunctionNode.class)
    static final class JavaIsJavaFunctionNodeGen extends JavaIsJavaFunctionNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private JavaIsJavaFunctionNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return isJavaFunction(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return isJavaFunction(arguments0Value_);
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
            s[0] = "isJavaFunction";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JavaIsJavaFunctionNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaIsJavaFunctionNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JavaIsScriptFunctionNode.class)
    static final class JavaIsScriptFunctionNodeGen extends JavaIsScriptFunctionNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private JavaIsScriptFunctionNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return JavaIsScriptFunctionNode.isScriptFunction(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return JavaIsScriptFunctionNode.isScriptFunction(arguments0Value_);
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
            s[0] = "isScriptFunction";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JavaIsScriptFunctionNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaIsScriptFunctionNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JavaIsScriptObjectNode.class)
    static final class JavaIsScriptObjectNodeGen extends JavaIsScriptObjectNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private JavaIsScriptObjectNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return JavaIsScriptObjectNode.isScriptObject(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return JavaIsScriptObjectNode.isScriptObject(arguments0Value_);
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
            s[0] = "isScriptObject";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JavaIsScriptObjectNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaIsScriptObjectNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JavaSynchronizedNode.class)
    static final class JavaSynchronizedNodeGen extends JavaSynchronizedNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JavaSynchronizedNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return doSynchronize(frameValue, arguments0Value_, arguments1Value_);
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
            s[0] = "doSynchronize";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JavaSynchronizedNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaSynchronizedNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JavaAddToClasspathNode.class)
    static final class JavaAddToClasspathNodeGen extends JavaAddToClasspathNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private JSToStringNode object_toStringNode_;

        private JavaAddToClasspathNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doString(String) */ && JSTypesGen.isImplicitString((state_0 & 0b11100) >>> 2 /* extract-implicit-state_0 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state_0 & 0b11100) >>> 2 /* extract-implicit-state_0 0:String */, arguments0Value_);
                return doString(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doObject(Object, JSToStringNode) */) {
                return doObject(arguments0Value_, this.object_toStringNode_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doString(String) */) {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        state_0 = (state_0 | (stringCast0 << 2) /* set-implicit-state_0 0:String */);
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doString(String) */;
                        lock.unlock();
                        hasLock = false;
                        return doString(arguments0Value_);
                    }
                }
                this.object_toStringNode_ = super.insert((JSToStringNode.create()));
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doString(String) */;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doString(String) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doObject(Object, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return doObject(arguments0Value, this.object_toStringNode_);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b11) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b11) & ((state_0 & 0b11) - 1)) == 0 /* is-single-state_0  */) {
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
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "doString";
            if ((state_0 & 0b1) != 0 /* is-state_0 doString(String) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-exclude doString(String) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 doObject(Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JavaAddToClasspathNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JavaAddToClasspathNodeGen(context, builtin, arguments);
        }

    }
}
