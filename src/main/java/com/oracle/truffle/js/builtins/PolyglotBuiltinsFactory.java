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
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotConstructNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotEvalFileNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotEvalNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotExecuteNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotExportNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotGetSizeNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotHasKeysNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotHasSizeNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotImportNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotIsBoxedPrimitiveNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotIsExecutableNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotIsInstantiableNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotIsNullNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotKeysNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotReadNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotRemoveNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotToJSValueNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotToPolyglotValueNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotUnboxValueNode;
import com.oracle.truffle.js.builtins.PolyglotBuiltins.PolyglotWriteNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PolyglotBuiltins.class)
@SuppressWarnings("unused")
public final class PolyglotBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(PolyglotExportNode.class)
    static final class PolyglotExportNodeGen extends PolyglotExportNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary interop;

        private PolyglotExportNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b111) != 0 /* is-state_0 doString(String, Object, InteropLibrary) || doMaybeUnbox(TruffleObject, Object, InteropLibrary) || doInvalid(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doString(String, Object, InteropLibrary) */ && JSTypesGen.isImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, arguments0Value_);
                    return doString(arguments0Value__, arguments1Value_, this.interop);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doMaybeUnbox(TruffleObject, Object, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                    TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                    if ((!(JSGuards.isString(arguments0Value__)))) {
                        return doMaybeUnbox(arguments0Value__, arguments1Value_, this.interop);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doInvalid(Object, Object) */) {
                    if ((!(JSGuards.isString(arguments0Value_)))) {
                        return doInvalid(arguments0Value_, arguments1Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                        state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doString(String, Object, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return doString(arguments0Value_, arguments1Value, this.interop);
                    }
                }
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    if ((!(JSGuards.isString(arguments0Value_)))) {
                        this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doMaybeUnbox(TruffleObject, Object, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return doMaybeUnbox(arguments0Value_, arguments1Value, this.interop);
                    }
                }
                if ((!(JSGuards.isString(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doInvalid(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doInvalid(arguments0Value, arguments1Value);
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
            if ((state_0 & 0b111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "doString";
            if ((state_0 & 0b1) != 0 /* is-state_0 doString(String, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.interop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doMaybeUnbox";
            if ((state_0 & 0b10) != 0 /* is-state_0 doMaybeUnbox(TruffleObject, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.interop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doInvalid";
            if ((state_0 & 0b100) != 0 /* is-state_0 doInvalid(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static PolyglotExportNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotExportNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotImportNode.class)
    static final class PolyglotImportNodeGen extends PolyglotImportNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary interop;
        @Child private ImportValueNode importValue;

        private PolyglotImportNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doString(String, InteropLibrary, ImportValueNode) */ && JSTypesGen.isImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, arguments0Value_);
                return doString(arguments0Value__, this.interop, this.importValue);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doMaybeUnbox(TruffleObject, InteropLibrary, ImportValueNode) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                if ((!(JSGuards.isString(arguments0Value__)))) {
                    return doMaybeUnbox(arguments0Value__, this.interop, this.importValue);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doInvalid(Object) */) {
                if ((!(JSGuards.isString(arguments0Value_))) && (!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return doInvalid(arguments0Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                        this.importValue = super.insert(this.importValue == null ? ((ImportValueNode.create())) : this.importValue);
                        state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doString(String, InteropLibrary, ImportValueNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doString(arguments0Value_, this.interop, this.importValue);
                    }
                }
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    if ((!(JSGuards.isString(arguments0Value_)))) {
                        this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                        this.importValue = super.insert(this.importValue == null ? ((ImportValueNode.create())) : this.importValue);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doMaybeUnbox(TruffleObject, InteropLibrary, ImportValueNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doMaybeUnbox(arguments0Value_, this.interop, this.importValue);
                    }
                }
                if ((!(JSGuards.isString(arguments0Value))) && (!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doInvalid(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doInvalid(arguments0Value);
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
            if ((state_0 & 0b111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "doString";
            if ((state_0 & 0b1) != 0 /* is-state_0 doString(String, InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.interop, this.importValue));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doMaybeUnbox";
            if ((state_0 & 0b10) != 0 /* is-state_0 doMaybeUnbox(TruffleObject, InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.interop, this.importValue));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doInvalid";
            if ((state_0 & 0b100) != 0 /* is-state_0 doInvalid(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static PolyglotImportNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotImportNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotIsExecutableNode.class)
    static final class PolyglotIsExecutableNodeGen extends PolyglotIsExecutableNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary truffleObject_interop_;

        private PolyglotIsExecutableNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return PolyglotIsExecutableNode.truffleObject(arguments0Value__, this.truffleObject_interop_);
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 primitive(Object) || unsupported(Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 primitive(Object) */) {
                    if ((JSGuards.isJavaPrimitive(arguments0Value_))) {
                        return PolyglotIsExecutableNode.primitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 unsupported(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_))) && (!(JSGuards.isJavaPrimitive(arguments0Value_)))) {
                        return PolyglotIsExecutableNode.unsupported(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return PolyglotIsExecutableNode.truffleObject(arguments0Value__, this.truffleObject_interop_);
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 primitive(Object) || unsupported(Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 primitive(Object) */) {
                    if ((JSGuards.isJavaPrimitive(arguments0Value_))) {
                        return PolyglotIsExecutableNode.primitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 unsupported(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_))) && (!(JSGuards.isJavaPrimitive(arguments0Value_)))) {
                        return PolyglotIsExecutableNode.unsupported(arguments0Value_);
                    }
                }
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
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    this.truffleObject_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 truffleObject(TruffleObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return PolyglotIsExecutableNode.truffleObject(arguments0Value_, this.truffleObject_interop_);
                }
                if ((JSGuards.isJavaPrimitive(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 primitive(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return PolyglotIsExecutableNode.primitive(arguments0Value);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value))) && (!(JSGuards.isJavaPrimitive(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 unsupported(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return PolyglotIsExecutableNode.unsupported(arguments0Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "truffleObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.truffleObject_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "primitive";
            if ((state_0 & 0b10) != 0 /* is-state_0 primitive(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b100) != 0 /* is-state_0 unsupported(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static PolyglotIsExecutableNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotIsExecutableNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotIsBoxedPrimitiveNode.class)
    static final class PolyglotIsBoxedPrimitiveNodeGen extends PolyglotIsBoxedPrimitiveNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private TruffleObject0Data truffleObject0_cache;

        private PolyglotIsBoxedPrimitiveNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b11) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) || truffleObject(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */) {
                    TruffleObject0Data s0_ = this.truffleObject0_cache;
                    while (s0_ != null) {
                        if ((s0_.interop_.accepts(arguments0Value__))) {
                            return PolyglotIsBoxedPrimitiveNode.truffleObject(arguments0Value__, s0_.interop_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */) {
                    return this.truffleObject1Boundary(state_0, arguments0Value__);
                }
            }
            if ((state_0 & 0b1100) != 0 /* is-state_0 primitive(Object) || unsupported(Object) */) {
                if ((state_0 & 0b100) != 0 /* is-state_0 primitive(Object) */) {
                    if ((JSGuards.isJavaPrimitive(arguments0Value_))) {
                        return PolyglotIsBoxedPrimitiveNode.primitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 unsupported(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_))) && (!(JSGuards.isJavaPrimitive(arguments0Value_)))) {
                        return PolyglotIsBoxedPrimitiveNode.unsupported(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object truffleObject1Boundary(int state_0, TruffleObject arguments0Value__) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value__));
                    return PolyglotIsBoxedPrimitiveNode.truffleObject(arguments0Value__, truffleObject1_interop__);
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
            if ((state_0 & 0b11) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) || truffleObject(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */) {
                    TruffleObject0Data s0_ = this.truffleObject0_cache;
                    while (s0_ != null) {
                        if ((s0_.interop_.accepts(arguments0Value__))) {
                            return PolyglotIsBoxedPrimitiveNode.truffleObject(arguments0Value__, s0_.interop_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */) {
                    return this.truffleObject1Boundary0(state_0, arguments0Value__);
                }
            }
            if ((state_0 & 0b1100) != 0 /* is-state_0 primitive(Object) || unsupported(Object) */) {
                if ((state_0 & 0b100) != 0 /* is-state_0 primitive(Object) */) {
                    if ((JSGuards.isJavaPrimitive(arguments0Value_))) {
                        return PolyglotIsBoxedPrimitiveNode.primitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 unsupported(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_))) && (!(JSGuards.isJavaPrimitive(arguments0Value_)))) {
                        return PolyglotIsBoxedPrimitiveNode.unsupported(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private boolean truffleObject1Boundary0(int state_0, TruffleObject arguments0Value__) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value__));
                    return PolyglotIsBoxedPrimitiveNode.truffleObject(arguments0Value__, truffleObject1_interop__);
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

        private boolean executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    if ((exclude) == 0 /* is-not-exclude truffleObject(TruffleObject, InteropLibrary) */) {
                        int count0_ = 0;
                        TruffleObject0Data s0_ = this.truffleObject0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.interop_.accepts(arguments0Value_))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.interop_.accepts(arguments0Value_));
                            if (count0_ < (JSConfig.InteropLibraryLimit)) {
                                s0_ = super.insert(new TruffleObject0Data(truffleObject0_cache));
                                s0_.interop_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value_)));
                                MemoryFence.storeStore();
                                this.truffleObject0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 truffleObject(TruffleObject, InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return PolyglotIsBoxedPrimitiveNode.truffleObject(arguments0Value_, s0_.interop_);
                        }
                    }
                    {
                        InteropLibrary truffleObject1_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude truffleObject(TruffleObject, InteropLibrary) */;
                                this.truffleObject0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 truffleObject(TruffleObject, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 truffleObject(TruffleObject, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return PolyglotIsBoxedPrimitiveNode.truffleObject(arguments0Value_, truffleObject1_interop__);
                            } finally {
                                encapsulating_.set(prev_);
                            }
                        }
                    }
                }
                if ((JSGuards.isJavaPrimitive(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 primitive(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return PolyglotIsBoxedPrimitiveNode.primitive(arguments0Value);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value))) && (!(JSGuards.isJavaPrimitive(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 unsupported(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return PolyglotIsBoxedPrimitiveNode.unsupported(arguments0Value);
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
                    TruffleObject0Data s0_ = this.truffleObject0_cache;
                    if ((s0_ == null || s0_.next_ == null)) {
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
            s[0] = "truffleObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                TruffleObject0Data s0_ = this.truffleObject0_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.interop_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude truffleObject(TruffleObject, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "truffleObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "primitive";
            if ((state_0 & 0b100) != 0 /* is-state_0 primitive(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b1000) != 0 /* is-state_0 unsupported(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static PolyglotIsBoxedPrimitiveNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotIsBoxedPrimitiveNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(PolyglotIsBoxedPrimitiveNode.class)
        private static final class TruffleObject0Data extends Node {

            @Child TruffleObject0Data next_;
            @Child InteropLibrary interop_;

            TruffleObject0Data(TruffleObject0Data next_) {
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
    @GeneratedBy(PolyglotIsNullNode.class)
    static final class PolyglotIsNullNodeGen extends PolyglotIsNullNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary truffleObject_interop_;

        private PolyglotIsNullNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return PolyglotIsNullNode.truffleObject(arguments0Value__, this.truffleObject_interop_);
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 primitive(Object) || unsupported(Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 primitive(Object) */) {
                    if ((JSGuards.isJavaPrimitive(arguments0Value_))) {
                        return PolyglotIsNullNode.primitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 unsupported(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_))) && (!(JSGuards.isJavaPrimitive(arguments0Value_)))) {
                        return PolyglotIsNullNode.unsupported(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return PolyglotIsNullNode.truffleObject(arguments0Value__, this.truffleObject_interop_);
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 primitive(Object) || unsupported(Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 primitive(Object) */) {
                    if ((JSGuards.isJavaPrimitive(arguments0Value_))) {
                        return PolyglotIsNullNode.primitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 unsupported(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_))) && (!(JSGuards.isJavaPrimitive(arguments0Value_)))) {
                        return PolyglotIsNullNode.unsupported(arguments0Value_);
                    }
                }
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
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    this.truffleObject_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 truffleObject(TruffleObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return PolyglotIsNullNode.truffleObject(arguments0Value_, this.truffleObject_interop_);
                }
                if ((JSGuards.isJavaPrimitive(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 primitive(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return PolyglotIsNullNode.primitive(arguments0Value);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value))) && (!(JSGuards.isJavaPrimitive(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 unsupported(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return PolyglotIsNullNode.unsupported(arguments0Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "truffleObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.truffleObject_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "primitive";
            if ((state_0 & 0b10) != 0 /* is-state_0 primitive(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b100) != 0 /* is-state_0 unsupported(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static PolyglotIsNullNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotIsNullNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotHasSizeNode.class)
    static final class PolyglotHasSizeNodeGen extends PolyglotHasSizeNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary truffleObject_interop_;

        private PolyglotHasSizeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return truffleObject(arguments0Value__, this.truffleObject_interop_);
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 primitive(Object) || unsupported(Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 primitive(Object) */) {
                    if ((JSGuards.isJavaPrimitive(arguments0Value_))) {
                        return primitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 unsupported(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_))) && (!(JSGuards.isJavaPrimitive(arguments0Value_)))) {
                        return unsupported(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return truffleObject(arguments0Value__, this.truffleObject_interop_);
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 primitive(Object) || unsupported(Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 primitive(Object) */) {
                    if ((JSGuards.isJavaPrimitive(arguments0Value_))) {
                        return primitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 unsupported(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_))) && (!(JSGuards.isJavaPrimitive(arguments0Value_)))) {
                        return unsupported(arguments0Value_);
                    }
                }
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
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    this.truffleObject_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 truffleObject(TruffleObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return truffleObject(arguments0Value_, this.truffleObject_interop_);
                }
                if ((JSGuards.isJavaPrimitive(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 primitive(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return primitive(arguments0Value);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value))) && (!(JSGuards.isJavaPrimitive(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 unsupported(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return unsupported(arguments0Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "truffleObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.truffleObject_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "primitive";
            if ((state_0 & 0b10) != 0 /* is-state_0 primitive(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b100) != 0 /* is-state_0 unsupported(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static PolyglotHasSizeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotHasSizeNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotReadNode.class)
    static final class PolyglotReadNodeGen extends PolyglotReadNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ImportValueNode importValue;
        @Child private InteropLibrary interop;
        @Child private InteropLibrary unsupportedKey_keyInterop_;

        private PolyglotReadNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b11101) == 0 /* only-active arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) */ && ((state_0 & 0b11111) != 0  /* is-not member(TruffleObject, String, ImportValueNode, InteropLibrary) && arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) && arrayElement(TruffleObject, Number, ImportValueNode, InteropLibrary) && unsupportedKey(TruffleObject, Object, ImportValueNode, InteropLibrary, InteropLibrary) && unsupported(Object, Object) */)) {
                return execute_int0(state_0, frameValue);
            } else {
                return execute_generic1(state_0, frameValue);
            }
        }

        private Object execute_int0(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, ex.getResult());
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) */;
            if (arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return arrayElementInt(arguments0Value__, arguments1Value_, this.importValue, this.interop);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private Object execute_generic1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b1111) != 0 /* is-state_0 member(TruffleObject, String, ImportValueNode, InteropLibrary) || arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) || arrayElement(TruffleObject, Number, ImportValueNode, InteropLibrary) || unsupportedKey(TruffleObject, Object, ImportValueNode, InteropLibrary, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 member(TruffleObject, String, ImportValueNode, InteropLibrary) */ && JSTypesGen.isImplicitString((state_0 & 0b11100000) >>> 5 /* extract-implicit-state_0 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state_0 & 0b11100000) >>> 5 /* extract-implicit-state_0 1:String */, arguments1Value_);
                    return member(arguments0Value__, arguments1Value__, this.importValue, this.interop);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    return arrayElementInt(arguments0Value__, arguments1Value__, this.importValue, this.interop);
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 arrayElement(TruffleObject, Number, ImportValueNode, InteropLibrary) */ && arguments1Value_ instanceof Number) {
                    Number arguments1Value__ = (Number) arguments1Value_;
                    if ((JSGuards.isNumber(arguments1Value__))) {
                        return arrayElement(arguments0Value__, arguments1Value__, this.importValue, this.interop);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 unsupportedKey(TruffleObject, Object, ImportValueNode, InteropLibrary, InteropLibrary) */) {
                    if ((!(JSGuards.isString(arguments1Value_))) && (!(JSGuards.isNumber(arguments1Value_)))) {
                        return unsupportedKey(arguments0Value__, arguments1Value_, this.importValue, this.interop, this.unsupportedKey_keyInterop_);
                    }
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 unsupported(Object, Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1111) != 0 /* is-state_0 member(TruffleObject, String, ImportValueNode, InteropLibrary) || arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) || arrayElement(TruffleObject, Number, ImportValueNode, InteropLibrary) || unsupportedKey(TruffleObject, Object, ImportValueNode, InteropLibrary, InteropLibrary) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b10000) != 0 /* is-state_0 unsupported(Object, Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b1111) == 0 /* only-active unsupported(Object, Object) */ && ((state_0 & 0b11111) != 0  /* is-not member(TruffleObject, String, ImportValueNode, InteropLibrary) && arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) && arrayElement(TruffleObject, Number, ImportValueNode, InteropLibrary) && unsupportedKey(TruffleObject, Object, ImportValueNode, InteropLibrary, InteropLibrary) && unsupported(Object, Object) */)) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            this.importValue = super.insert(this.importValue == null ? ((ImportValueNode.create())) : this.importValue);
                            this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                            state_0 = (state_0 | (stringCast1 << 5) /* set-implicit-state_0 1:String */);
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 member(TruffleObject, String, ImportValueNode, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return member(arguments0Value_, arguments1Value_, this.importValue, this.interop);
                        }
                    }
                    if ((exclude) == 0 /* is-not-exclude arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) */ && arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        this.importValue = super.insert(this.importValue == null ? ((ImportValueNode.create())) : this.importValue);
                        this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arrayElementInt(arguments0Value_, arguments1Value_, this.importValue, this.interop);
                    }
                    if (arguments1Value instanceof Number) {
                        Number arguments1Value_ = (Number) arguments1Value;
                        if ((JSGuards.isNumber(arguments1Value_))) {
                            this.importValue = super.insert(this.importValue == null ? ((ImportValueNode.create())) : this.importValue);
                            this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) */;
                            state_0 = state_0 & 0xfffffffd /* remove-state_0 arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 arrayElement(TruffleObject, Number, ImportValueNode, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return arrayElement(arguments0Value_, arguments1Value_, this.importValue, this.interop);
                        }
                    }
                    if ((!(JSGuards.isString(arguments1Value))) && (!(JSGuards.isNumber(arguments1Value)))) {
                        this.importValue = super.insert(this.importValue == null ? ((ImportValueNode.create())) : this.importValue);
                        this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                        this.unsupportedKey_keyInterop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 unsupportedKey(TruffleObject, Object, ImportValueNode, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return unsupportedKey(arguments0Value_, arguments1Value, this.importValue, this.interop, this.unsupportedKey_keyInterop_);
                    }
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 unsupported(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return unsupported(arguments0Value, arguments1Value);
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
            if ((state_0 & 0b11111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b11111) & ((state_0 & 0b11111) - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[6];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "member";
            if ((state_0 & 0b1) != 0 /* is-state_0 member(TruffleObject, String, ImportValueNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.importValue, this.interop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "arrayElementInt";
            if ((state_0 & 0b10) != 0 /* is-state_0 arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.importValue, this.interop));
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude arrayElementInt(TruffleObject, int, ImportValueNode, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "arrayElement";
            if ((state_0 & 0b100) != 0 /* is-state_0 arrayElement(TruffleObject, Number, ImportValueNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.importValue, this.interop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "unsupportedKey";
            if ((state_0 & 0b1000) != 0 /* is-state_0 unsupportedKey(TruffleObject, Object, ImportValueNode, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.importValue, this.interop, this.unsupportedKey_keyInterop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b10000) != 0 /* is-state_0 unsupported(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static PolyglotReadNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotReadNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotWriteNode.class)
    static final class PolyglotWriteNodeGen extends PolyglotWriteNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ExportValueNode exportValue;
        @Child private InteropLibrary interop;
        @Child private InteropLibrary unsupportedKey_keyInterop_;

        private PolyglotWriteNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b11101) == 0 /* only-active arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) */ && ((state_0 & 0b11111) != 0  /* is-not member(TruffleObject, String, Object, ExportValueNode, InteropLibrary) && arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) && arrayElement(TruffleObject, Number, Object, ExportValueNode, InteropLibrary) && unsupportedKey(TruffleObject, Object, Object, ExportValueNode, InteropLibrary, InteropLibrary) && unsupported(Object, Object, Object) */)) {
                return execute_int0(state_0, frameValue);
            } else {
                return execute_generic1(state_0, frameValue);
            }
        }

        private Object execute_int0(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value);
            }
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            assert (state_0 & 0b10) != 0 /* is-state_0 arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) */;
            if (arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return arrayElementInt(arguments0Value__, arguments1Value_, arguments2Value_, this.exportValue, this.interop);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state_0 & 0b11111) != 0 /* is-state_0 member(TruffleObject, String, Object, ExportValueNode, InteropLibrary) || arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) || arrayElement(TruffleObject, Number, Object, ExportValueNode, InteropLibrary) || unsupportedKey(TruffleObject, Object, Object, ExportValueNode, InteropLibrary, InteropLibrary) || unsupported(Object, Object, Object) */) {
                if ((state_0 & 0b1111) != 0 /* is-state_0 member(TruffleObject, String, Object, ExportValueNode, InteropLibrary) || arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) || arrayElement(TruffleObject, Number, Object, ExportValueNode, InteropLibrary) || unsupportedKey(TruffleObject, Object, Object, ExportValueNode, InteropLibrary, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                    TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 member(TruffleObject, String, Object, ExportValueNode, InteropLibrary) */ && JSTypesGen.isImplicitString((state_0 & 0b11100000) >>> 5 /* extract-implicit-state_0 1:String */, arguments1Value_)) {
                        String arguments1Value__ = JSTypesGen.asImplicitString((state_0 & 0b11100000) >>> 5 /* extract-implicit-state_0 1:String */, arguments1Value_);
                        return member(arguments0Value__, arguments1Value__, arguments2Value_, this.exportValue, this.interop);
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) */ && arguments1Value_ instanceof Integer) {
                        int arguments1Value__ = (int) arguments1Value_;
                        return arrayElementInt(arguments0Value__, arguments1Value__, arguments2Value_, this.exportValue, this.interop);
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 arrayElement(TruffleObject, Number, Object, ExportValueNode, InteropLibrary) */ && arguments1Value_ instanceof Number) {
                        Number arguments1Value__ = (Number) arguments1Value_;
                        if ((JSGuards.isNumber(arguments1Value__))) {
                            return arrayElement(arguments0Value__, arguments1Value__, arguments2Value_, this.exportValue, this.interop);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 unsupportedKey(TruffleObject, Object, Object, ExportValueNode, InteropLibrary, InteropLibrary) */) {
                        if ((!(JSGuards.isString(arguments1Value_))) && (!(JSGuards.isNumber(arguments1Value_)))) {
                            return unsupportedKey(arguments0Value__, arguments1Value_, arguments2Value_, this.exportValue, this.interop, this.unsupportedKey_keyInterop_);
                        }
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 unsupported(Object, Object, Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                        return unsupported(arguments0Value_, arguments1Value_, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1111) != 0 /* is-state_0 member(TruffleObject, String, Object, ExportValueNode, InteropLibrary) || arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) || arrayElement(TruffleObject, Number, Object, ExportValueNode, InteropLibrary) || unsupportedKey(TruffleObject, Object, Object, ExportValueNode, InteropLibrary, InteropLibrary) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state_0 & 0b10000) != 0 /* is-state_0 unsupported(Object, Object, Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_, arguments1Value_, arguments2Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b1111) == 0 /* only-active unsupported(Object, Object, Object) */ && ((state_0 & 0b11111) != 0  /* is-not member(TruffleObject, String, Object, ExportValueNode, InteropLibrary) && arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) && arrayElement(TruffleObject, Number, Object, ExportValueNode, InteropLibrary) && unsupportedKey(TruffleObject, Object, Object, ExportValueNode, InteropLibrary, InteropLibrary) && unsupported(Object, Object, Object) */)) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            this.exportValue = super.insert(this.exportValue == null ? ((ExportValueNode.create())) : this.exportValue);
                            this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                            state_0 = (state_0 | (stringCast1 << 5) /* set-implicit-state_0 1:String */);
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 member(TruffleObject, String, Object, ExportValueNode, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return member(arguments0Value_, arguments1Value_, arguments2Value, this.exportValue, this.interop);
                        }
                    }
                    if ((exclude) == 0 /* is-not-exclude arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) */ && arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        this.exportValue = super.insert(this.exportValue == null ? ((ExportValueNode.create())) : this.exportValue);
                        this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arrayElementInt(arguments0Value_, arguments1Value_, arguments2Value, this.exportValue, this.interop);
                    }
                    if (arguments1Value instanceof Number) {
                        Number arguments1Value_ = (Number) arguments1Value;
                        if ((JSGuards.isNumber(arguments1Value_))) {
                            this.exportValue = super.insert(this.exportValue == null ? ((ExportValueNode.create())) : this.exportValue);
                            this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) */;
                            state_0 = state_0 & 0xfffffffd /* remove-state_0 arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 arrayElement(TruffleObject, Number, Object, ExportValueNode, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return arrayElement(arguments0Value_, arguments1Value_, arguments2Value, this.exportValue, this.interop);
                        }
                    }
                    if ((!(JSGuards.isString(arguments1Value))) && (!(JSGuards.isNumber(arguments1Value)))) {
                        this.exportValue = super.insert(this.exportValue == null ? ((ExportValueNode.create())) : this.exportValue);
                        this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                        this.unsupportedKey_keyInterop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 unsupportedKey(TruffleObject, Object, Object, ExportValueNode, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return unsupportedKey(arguments0Value_, arguments1Value, arguments2Value, this.exportValue, this.interop, this.unsupportedKey_keyInterop_);
                    }
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 unsupported(Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return unsupported(arguments0Value, arguments1Value, arguments2Value);
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
            if ((state_0 & 0b11111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b11111) & ((state_0 & 0b11111) - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[6];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "member";
            if ((state_0 & 0b1) != 0 /* is-state_0 member(TruffleObject, String, Object, ExportValueNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.exportValue, this.interop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "arrayElementInt";
            if ((state_0 & 0b10) != 0 /* is-state_0 arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.exportValue, this.interop));
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude arrayElementInt(TruffleObject, int, Object, ExportValueNode, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "arrayElement";
            if ((state_0 & 0b100) != 0 /* is-state_0 arrayElement(TruffleObject, Number, Object, ExportValueNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.exportValue, this.interop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "unsupportedKey";
            if ((state_0 & 0b1000) != 0 /* is-state_0 unsupportedKey(TruffleObject, Object, Object, ExportValueNode, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.exportValue, this.interop, this.unsupportedKey_keyInterop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b10000) != 0 /* is-state_0 unsupported(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static PolyglotWriteNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotWriteNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotRemoveNode.class)
    static final class PolyglotRemoveNodeGen extends PolyglotRemoveNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private InteropLibrary interop;
        @Child private InteropLibrary unsupportedKey_keyInterop_;

        private PolyglotRemoveNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b11101) == 0 /* only-active arrayElementInt(TruffleObject, int, InteropLibrary) */ && ((state_0 & 0b11111) != 0  /* is-not member(TruffleObject, String, InteropLibrary) && arrayElementInt(TruffleObject, int, InteropLibrary) && arrayElement(TruffleObject, Number, InteropLibrary) && unsupportedKey(TruffleObject, Object, InteropLibrary, InteropLibrary) && unsupported(Object, Object) */)) {
                return execute_int0(state_0, frameValue);
            } else {
                return execute_generic1(state_0, frameValue);
            }
        }

        private Object execute_int0(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, ex.getResult());
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 arrayElementInt(TruffleObject, int, InteropLibrary) */;
            if (arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return arrayElementInt(arguments0Value__, arguments1Value_, this.interop);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private Object execute_generic1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b1111) != 0 /* is-state_0 member(TruffleObject, String, InteropLibrary) || arrayElementInt(TruffleObject, int, InteropLibrary) || arrayElement(TruffleObject, Number, InteropLibrary) || unsupportedKey(TruffleObject, Object, InteropLibrary, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 member(TruffleObject, String, InteropLibrary) */ && JSTypesGen.isImplicitString((state_0 & 0b11100000) >>> 5 /* extract-implicit-state_0 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state_0 & 0b11100000) >>> 5 /* extract-implicit-state_0 1:String */, arguments1Value_);
                    return member(arguments0Value__, arguments1Value__, this.interop);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 arrayElementInt(TruffleObject, int, InteropLibrary) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    return arrayElementInt(arguments0Value__, arguments1Value__, this.interop);
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 arrayElement(TruffleObject, Number, InteropLibrary) */ && arguments1Value_ instanceof Number) {
                    Number arguments1Value__ = (Number) arguments1Value_;
                    if ((JSGuards.isNumber(arguments1Value__))) {
                        return arrayElement(arguments0Value__, arguments1Value__, this.interop);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 unsupportedKey(TruffleObject, Object, InteropLibrary, InteropLibrary) */) {
                    if ((!(JSGuards.isString(arguments1Value_))) && (!(JSGuards.isNumber(arguments1Value_)))) {
                        return unsupportedKey(arguments0Value__, arguments1Value_, this.interop, this.unsupportedKey_keyInterop_);
                    }
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 unsupported(Object, Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1000) != 0 /* is-state_0 unsupportedKey(TruffleObject, Object, InteropLibrary, InteropLibrary) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            if ((state_0 & 0b10101) == 0 /* only-active arrayElementInt(TruffleObject, int, InteropLibrary) */ && ((state_0 & 0b10111) != 0  /* is-not member(TruffleObject, String, InteropLibrary) && arrayElementInt(TruffleObject, int, InteropLibrary) && arrayElement(TruffleObject, Number, InteropLibrary) && unsupported(Object, Object) */)) {
                return executeBoolean_int2(state_0, frameValue);
            } else {
                return executeBoolean_generic3(state_0, frameValue);
            }
        }

        private boolean executeBoolean_int2(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, ex.getResult()));
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 arrayElementInt(TruffleObject, int, InteropLibrary) */;
            if (arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return arrayElementInt(arguments0Value__, arguments1Value_, this.interop);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        private boolean executeBoolean_generic3(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b111) != 0 /* is-state_0 member(TruffleObject, String, InteropLibrary) || arrayElementInt(TruffleObject, int, InteropLibrary) || arrayElement(TruffleObject, Number, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 member(TruffleObject, String, InteropLibrary) */ && JSTypesGen.isImplicitString((state_0 & 0b11100000) >>> 5 /* extract-implicit-state_0 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state_0 & 0b11100000) >>> 5 /* extract-implicit-state_0 1:String */, arguments1Value_);
                    return member(arguments0Value__, arguments1Value__, this.interop);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 arrayElementInt(TruffleObject, int, InteropLibrary) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    return arrayElementInt(arguments0Value__, arguments1Value__, this.interop);
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 arrayElement(TruffleObject, Number, InteropLibrary) */ && arguments1Value_ instanceof Number) {
                    Number arguments1Value__ = (Number) arguments1Value_;
                    if ((JSGuards.isNumber(arguments1Value__))) {
                        return arrayElement(arguments0Value__, arguments1Value__, this.interop);
                    }
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 unsupported(Object, Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b1000) == 0 /* only-active member(TruffleObject, String, InteropLibrary) && arrayElementInt(TruffleObject, int, InteropLibrary) && arrayElement(TruffleObject, Number, InteropLibrary) && unsupported(Object, Object) */ && ((state_0 & 0b11111) != 0  /* is-not member(TruffleObject, String, InteropLibrary) && arrayElementInt(TruffleObject, int, InteropLibrary) && arrayElement(TruffleObject, Number, InteropLibrary) && unsupportedKey(TruffleObject, Object, InteropLibrary, InteropLibrary) && unsupported(Object, Object) */)) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                            state_0 = (state_0 | (stringCast1 << 5) /* set-implicit-state_0 1:String */);
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 member(TruffleObject, String, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return member(arguments0Value_, arguments1Value_, this.interop);
                        }
                    }
                    if ((exclude) == 0 /* is-not-exclude arrayElementInt(TruffleObject, int, InteropLibrary) */ && arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 arrayElementInt(TruffleObject, int, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arrayElementInt(arguments0Value_, arguments1Value_, this.interop);
                    }
                    if (arguments1Value instanceof Number) {
                        Number arguments1Value_ = (Number) arguments1Value;
                        if ((JSGuards.isNumber(arguments1Value_))) {
                            this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude arrayElementInt(TruffleObject, int, InteropLibrary) */;
                            state_0 = state_0 & 0xfffffffd /* remove-state_0 arrayElementInt(TruffleObject, int, InteropLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 arrayElement(TruffleObject, Number, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return arrayElement(arguments0Value_, arguments1Value_, this.interop);
                        }
                    }
                    if ((!(JSGuards.isString(arguments1Value))) && (!(JSGuards.isNumber(arguments1Value)))) {
                        this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                        this.unsupportedKey_keyInterop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 unsupportedKey(TruffleObject, Object, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return unsupportedKey(arguments0Value_, arguments1Value, this.interop, this.unsupportedKey_keyInterop_);
                    }
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 unsupported(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return unsupported(arguments0Value, arguments1Value);
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
            if ((state_0 & 0b11111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b11111) & ((state_0 & 0b11111) - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[6];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "member";
            if ((state_0 & 0b1) != 0 /* is-state_0 member(TruffleObject, String, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.interop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "arrayElementInt";
            if ((state_0 & 0b10) != 0 /* is-state_0 arrayElementInt(TruffleObject, int, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.interop));
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude arrayElementInt(TruffleObject, int, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "arrayElement";
            if ((state_0 & 0b100) != 0 /* is-state_0 arrayElement(TruffleObject, Number, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.interop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "unsupportedKey";
            if ((state_0 & 0b1000) != 0 /* is-state_0 unsupportedKey(TruffleObject, Object, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.interop, this.unsupportedKey_keyInterop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b10000) != 0 /* is-state_0 unsupported(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static PolyglotRemoveNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotRemoveNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotUnboxValueNode.class)
    static final class PolyglotUnboxValueNodeGen extends PolyglotUnboxValueNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary truffleObject_interop_;

        private PolyglotUnboxValueNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return truffleObject(arguments0Value__, this.truffleObject_interop_);
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 primitive(Object) || unsupported(Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 primitive(Object) */) {
                    if ((JSGuards.isJavaPrimitive(arguments0Value_))) {
                        return primitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 unsupported(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_))) && (!(JSGuards.isJavaPrimitive(arguments0Value_)))) {
                        return unsupported(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b11) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) || primitive(Object) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b100) != 0 /* is-state_0 unsupported(Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_))) && (!(JSGuards.isJavaPrimitive(arguments0Value_)))) {
                    return unsupported(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b11) == 0 /* only-active unsupported(Object) */ && (state_0 != 0  /* is-not truffleObject(TruffleObject, InteropLibrary) && primitive(Object) && unsupported(Object) */)) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    this.truffleObject_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 truffleObject(TruffleObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return truffleObject(arguments0Value_, this.truffleObject_interop_);
                }
                if ((JSGuards.isJavaPrimitive(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 primitive(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return primitive(arguments0Value);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value))) && (!(JSGuards.isJavaPrimitive(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 unsupported(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return unsupported(arguments0Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "truffleObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 truffleObject(TruffleObject, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.truffleObject_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "primitive";
            if ((state_0 & 0b10) != 0 /* is-state_0 primitive(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b100) != 0 /* is-state_0 unsupported(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static PolyglotUnboxValueNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotUnboxValueNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotExecuteNode.class)
    static final class PolyglotExecuteNodeGen extends PolyglotExecuteNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private ExportValueNode execute_exportValue_;
        @Child private InteropLibrary execute_interop_;

        private PolyglotExecuteNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 execute(TruffleObject, Object[], ExportValueNode, InteropLibrary) || unsupported(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 execute(TruffleObject, Object[], ExportValueNode, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                    TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                    return execute(arguments0Value__, arguments1Value__, this.execute_exportValue_, this.execute_interop_);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object, Object[]) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                        return unsupported(arguments0Value_, arguments1Value__);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 execute(TruffleObject, Object[], ExportValueNode, InteropLibrary) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_, arguments1Value__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b1) == 0 /* only-active unsupported(Object, Object[]) */ && (state_0 != 0  /* is-not execute(TruffleObject, Object[], ExportValueNode, InteropLibrary) && unsupported(Object, Object[]) */)) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arguments1Value instanceof Object[]) {
                    Object[] arguments1Value_ = (Object[]) arguments1Value;
                    if (arguments0Value instanceof TruffleObject) {
                        TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                        this.execute_exportValue_ = super.insert((ExportValueNode.create()));
                        this.execute_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 execute(TruffleObject, Object[], ExportValueNode, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return execute(arguments0Value_, arguments1Value_, this.execute_exportValue_, this.execute_interop_);
                    }
                    if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 unsupported(Object, Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return unsupported(arguments0Value, arguments1Value_);
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
            s[0] = "execute";
            if ((state_0 & 0b1) != 0 /* is-state_0 execute(TruffleObject, Object[], ExportValueNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.execute_exportValue_, this.execute_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static PolyglotExecuteNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotExecuteNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotConstructNode.class)
    static final class PolyglotConstructNodeGen extends PolyglotConstructNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private ExportValueNode new_exportValue_;
        @Child private InteropLibrary new_interop_;

        private PolyglotConstructNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 doNew(TruffleObject, Object[], ExportValueNode, InteropLibrary) || unsupported(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doNew(TruffleObject, Object[], ExportValueNode, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                    TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                    return doNew(arguments0Value__, arguments1Value__, this.new_exportValue_, this.new_interop_);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object, Object[]) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                        return unsupported(arguments0Value_, arguments1Value__);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doNew(TruffleObject, Object[], ExportValueNode, InteropLibrary) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_, arguments1Value__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b1) == 0 /* only-active unsupported(Object, Object[]) */ && (state_0 != 0  /* is-not doNew(TruffleObject, Object[], ExportValueNode, InteropLibrary) && unsupported(Object, Object[]) */)) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arguments1Value instanceof Object[]) {
                    Object[] arguments1Value_ = (Object[]) arguments1Value;
                    if (arguments0Value instanceof TruffleObject) {
                        TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                        this.new_exportValue_ = super.insert((ExportValueNode.create()));
                        this.new_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNew(TruffleObject, Object[], ExportValueNode, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return doNew(arguments0Value_, arguments1Value_, this.new_exportValue_, this.new_interop_);
                    }
                    if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 unsupported(Object, Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return unsupported(arguments0Value, arguments1Value_);
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
            s[0] = "doNew";
            if ((state_0 & 0b1) != 0 /* is-state_0 doNew(TruffleObject, Object[], ExportValueNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.new_exportValue_, this.new_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static PolyglotConstructNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotConstructNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotGetSizeNode.class)
    static final class PolyglotGetSizeNodeGen extends PolyglotGetSizeNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary getSize_interop_;

        private PolyglotGetSizeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 getSize(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return getSize(arguments0Value__, this.getSize_interop_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 getSize(TruffleObject, InteropLibrary) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b1) == 0 /* only-active unsupported(Object) */ && (state_0 != 0  /* is-not getSize(TruffleObject, InteropLibrary) && unsupported(Object) */)) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    this.getSize_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getSize(TruffleObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return getSize(arguments0Value_, this.getSize_interop_);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 unsupported(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return unsupported(arguments0Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "getSize";
            if ((state_0 & 0b1) != 0 /* is-state_0 getSize(TruffleObject, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.getSize_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static PolyglotGetSizeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotGetSizeNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotEvalNode.class)
    static final class PolyglotEvalNodeGen extends PolyglotEvalNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private IndirectCallNode callNode;
        @CompilationFinal private String evalCachedLanguage_cachedLanguage_;
        @CompilationFinal private Pair<String, String> evalCachedLanguage_languagePair_;

        private PolyglotEvalNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b11) != 0 /* is-state_0 evalCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) || evalString(String, String, IndirectCallNode) */ && JSTypesGen.isImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state_0 & 0b111000000) >>> 6 /* extract-implicit-state_0 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state_0 & 0b111000000) >>> 6 /* extract-implicit-state_0 1:String */, arguments1Value_);
                    if ((state_0 & 0b1) != 0 /* is-state_0 evalCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */) {
                        if ((arguments0Value__.equals(this.evalCachedLanguage_cachedLanguage_))) {
                            return evalCachedLanguage(arguments0Value__, arguments1Value__, this.evalCachedLanguage_cachedLanguage_, this.evalCachedLanguage_languagePair_, this.callNode);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 evalString(String, String, IndirectCallNode) */) {
                        return evalString(arguments0Value__, arguments1Value__, this.callNode);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 eval(Object, Object) */) {
                if ((!(JSGuards.isString(arguments0Value_)) || !(JSGuards.isString(arguments1Value_)))) {
                    return eval(arguments0Value_, arguments1Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            if ((exclude) == 0 /* is-not-exclude evalCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */) {
                                boolean EvalCachedLanguage_duplicateFound_ = false;
                                if ((state_0 & 0b1) != 0 /* is-state_0 evalCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */) {
                                    if ((arguments0Value_.equals(this.evalCachedLanguage_cachedLanguage_))) {
                                        EvalCachedLanguage_duplicateFound_ = true;
                                    }
                                }
                                if (!EvalCachedLanguage_duplicateFound_) {
                                    // assert (arguments0Value_.equals(this.evalCachedLanguage_cachedLanguage_));
                                    if (((state_0 & 0b1)) == 0 /* is-not-state_0 evalCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */) {
                                        this.evalCachedLanguage_cachedLanguage_ = (arguments0Value_);
                                        this.evalCachedLanguage_languagePair_ = (getLanguageIdAndMimeType(arguments0Value_));
                                        this.callNode = super.insert(this.callNode == null ? ((IndirectCallNode.create())) : this.callNode);
                                        state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                                        state_0 = (state_0 | (stringCast1 << 6) /* set-implicit-state_0 1:String */);
                                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 evalCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */;
                                        EvalCachedLanguage_duplicateFound_ = true;
                                    }
                                } else {
                                    state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                                    state_0 = (state_0 | (stringCast1 << 6) /* set-implicit-state_0 1:String */);
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 evalCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */;
                                }
                                if (EvalCachedLanguage_duplicateFound_) {
                                    lock.unlock();
                                    hasLock = false;
                                    return evalCachedLanguage(arguments0Value_, arguments1Value_, this.evalCachedLanguage_cachedLanguage_, this.evalCachedLanguage_languagePair_, this.callNode);
                                }
                            }
                            this.callNode = super.insert(this.callNode == null ? ((IndirectCallNode.create())) : this.callNode);
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude evalCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */;
                            state_0 = state_0 & 0xfffffffe /* remove-state_0 evalCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */;
                            state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                            state_0 = (state_0 | (stringCast1 << 6) /* set-implicit-state_0 1:String */);
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 evalString(String, String, IndirectCallNode) */;
                            lock.unlock();
                            hasLock = false;
                            return evalString(arguments0Value_, arguments1Value_, this.callNode);
                        }
                    }
                }
                if ((!(JSGuards.isString(arguments0Value)) || !(JSGuards.isString(arguments1Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 eval(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return eval(arguments0Value, arguments1Value);
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
            if ((state_0 & 0b111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "evalCachedLanguage";
            if ((state_0 & 0b1) != 0 /* is-state_0 evalCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.evalCachedLanguage_cachedLanguage_, this.evalCachedLanguage_languagePair_, this.callNode));
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude evalCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "evalString";
            if ((state_0 & 0b10) != 0 /* is-state_0 evalString(String, String, IndirectCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.callNode));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "eval";
            if ((state_0 & 0b100) != 0 /* is-state_0 eval(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static PolyglotEvalNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotEvalNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotEvalFileNode.class)
    static final class PolyglotEvalFileNodeGen extends PolyglotEvalFileNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private IndirectCallNode callNode;
        @CompilationFinal private String evalFileCachedLanguage_cachedLanguage_;
        @CompilationFinal private Pair<String, String> evalFileCachedLanguage_languagePair_;

        private PolyglotEvalFileNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b11) != 0 /* is-state_0 evalFileCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) || evalFileString(String, String, IndirectCallNode) */ && JSTypesGen.isImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state_0 & 0b111000000) >>> 6 /* extract-implicit-state_0 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state_0 & 0b111000000) >>> 6 /* extract-implicit-state_0 1:String */, arguments1Value_);
                    if ((state_0 & 0b1) != 0 /* is-state_0 evalFileCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */) {
                        if ((arguments0Value__.equals(this.evalFileCachedLanguage_cachedLanguage_))) {
                            return evalFileCachedLanguage(arguments0Value__, arguments1Value__, this.evalFileCachedLanguage_cachedLanguage_, this.evalFileCachedLanguage_languagePair_, this.callNode);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 evalFileString(String, String, IndirectCallNode) */) {
                        return evalFileString(arguments0Value__, arguments1Value__, this.callNode);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 eval(Object, Object) */) {
                if ((!(JSGuards.isString(arguments0Value_)) || !(JSGuards.isString(arguments1Value_)))) {
                    return eval(arguments0Value_, arguments1Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            if ((exclude) == 0 /* is-not-exclude evalFileCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */) {
                                boolean EvalFileCachedLanguage_duplicateFound_ = false;
                                if ((state_0 & 0b1) != 0 /* is-state_0 evalFileCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */) {
                                    if ((arguments0Value_.equals(this.evalFileCachedLanguage_cachedLanguage_))) {
                                        EvalFileCachedLanguage_duplicateFound_ = true;
                                    }
                                }
                                if (!EvalFileCachedLanguage_duplicateFound_) {
                                    // assert (arguments0Value_.equals(this.evalFileCachedLanguage_cachedLanguage_));
                                    if (((state_0 & 0b1)) == 0 /* is-not-state_0 evalFileCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */) {
                                        this.evalFileCachedLanguage_cachedLanguage_ = (arguments0Value_);
                                        this.evalFileCachedLanguage_languagePair_ = (getLanguageIdAndMimeType(arguments0Value_));
                                        this.callNode = super.insert(this.callNode == null ? ((IndirectCallNode.create())) : this.callNode);
                                        state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                                        state_0 = (state_0 | (stringCast1 << 6) /* set-implicit-state_0 1:String */);
                                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 evalFileCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */;
                                        EvalFileCachedLanguage_duplicateFound_ = true;
                                    }
                                } else {
                                    state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                                    state_0 = (state_0 | (stringCast1 << 6) /* set-implicit-state_0 1:String */);
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 evalFileCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */;
                                }
                                if (EvalFileCachedLanguage_duplicateFound_) {
                                    lock.unlock();
                                    hasLock = false;
                                    return evalFileCachedLanguage(arguments0Value_, arguments1Value_, this.evalFileCachedLanguage_cachedLanguage_, this.evalFileCachedLanguage_languagePair_, this.callNode);
                                }
                            }
                            this.callNode = super.insert(this.callNode == null ? ((IndirectCallNode.create())) : this.callNode);
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude evalFileCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */;
                            state_0 = state_0 & 0xfffffffe /* remove-state_0 evalFileCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */;
                            state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                            state_0 = (state_0 | (stringCast1 << 6) /* set-implicit-state_0 1:String */);
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 evalFileString(String, String, IndirectCallNode) */;
                            lock.unlock();
                            hasLock = false;
                            return evalFileString(arguments0Value_, arguments1Value_, this.callNode);
                        }
                    }
                }
                if ((!(JSGuards.isString(arguments0Value)) || !(JSGuards.isString(arguments1Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 eval(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return eval(arguments0Value, arguments1Value);
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
            if ((state_0 & 0b111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "evalFileCachedLanguage";
            if ((state_0 & 0b1) != 0 /* is-state_0 evalFileCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.evalFileCachedLanguage_cachedLanguage_, this.evalFileCachedLanguage_languagePair_, this.callNode));
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude evalFileCachedLanguage(String, String, String, Pair<String, String>, IndirectCallNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "evalFileString";
            if ((state_0 & 0b10) != 0 /* is-state_0 evalFileString(String, String, IndirectCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.callNode));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "eval";
            if ((state_0 & 0b100) != 0 /* is-state_0 eval(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static PolyglotEvalFileNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotEvalFileNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotHasKeysNode.class)
    static final class PolyglotHasKeysNodeGen extends PolyglotHasKeysNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary hasKeys_interop_;

        private PolyglotHasKeysNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 hasKeys(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return hasKeys(arguments0Value__, this.hasKeys_interop_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 hasKeys(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return hasKeys(arguments0Value__, this.hasKeys_interop_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_);
                }
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
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    this.hasKeys_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 hasKeys(TruffleObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return hasKeys(arguments0Value_, this.hasKeys_interop_);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 unsupported(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return unsupported(arguments0Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "hasKeys";
            if ((state_0 & 0b1) != 0 /* is-state_0 hasKeys(TruffleObject, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.hasKeys_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static PolyglotHasKeysNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotHasKeysNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotKeysNode.class)
    static final class PolyglotKeysNodeGen extends PolyglotKeysNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private PolyglotKeysNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 keys(TruffleObject) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return keys(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 keys(TruffleObject) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return unsupported(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b1) == 0 /* only-active unsupported(Object) */ && (state_0 != 0  /* is-not keys(TruffleObject) && unsupported(Object) */)) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof TruffleObject) {
                TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 keys(TruffleObject) */;
                return keys(arguments0Value_);
            }
            if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 unsupported(Object) */;
                return unsupported(arguments0Value);
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
            s[0] = "keys";
            if ((state_0 & 0b1) != 0 /* is-state_0 keys(TruffleObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static PolyglotKeysNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotKeysNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotIsInstantiableNode.class)
    static final class PolyglotIsInstantiableNodeGen extends PolyglotIsInstantiableNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary isInstantiable_interop_;

        private PolyglotIsInstantiableNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 isInstantiable(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return PolyglotIsInstantiableNode.isInstantiable(arguments0Value__, this.isInstantiable_interop_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return PolyglotIsInstantiableNode.unsupported(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 isInstantiable(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return PolyglotIsInstantiableNode.isInstantiable(arguments0Value__, this.isInstantiable_interop_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return PolyglotIsInstantiableNode.unsupported(arguments0Value_);
                }
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
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    this.isInstantiable_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 isInstantiable(TruffleObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return PolyglotIsInstantiableNode.isInstantiable(arguments0Value_, this.isInstantiable_interop_);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 unsupported(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return PolyglotIsInstantiableNode.unsupported(arguments0Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "isInstantiable";
            if ((state_0 & 0b1) != 0 /* is-state_0 isInstantiable(TruffleObject, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isInstantiable_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "unsupported";
            if ((state_0 & 0b10) != 0 /* is-state_0 unsupported(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static PolyglotIsInstantiableNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotIsInstantiableNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotToJSValueNode.class)
    static final class PolyglotToJSValueNodeGen extends PolyglotToJSValueNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary toJSValue0_interop_;

        private PolyglotToJSValueNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 toJSValue(TruffleObject, InteropLibrary) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                return toJSValue(arguments0Value__, this.toJSValue0_interop_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 toJSValue(Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return PolyglotToJSValueNode.toJSValue(arguments0Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    this.toJSValue0_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 toJSValue(TruffleObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return toJSValue(arguments0Value_, this.toJSValue0_interop_);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 toJSValue(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return PolyglotToJSValueNode.toJSValue(arguments0Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "toJSValue";
            if ((state_0 & 0b1) != 0 /* is-state_0 toJSValue(TruffleObject, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toJSValue0_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toJSValue";
            if ((state_0 & 0b10) != 0 /* is-state_0 toJSValue(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static PolyglotToJSValueNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotToJSValueNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PolyglotToPolyglotValueNode.class)
    static final class PolyglotToPolyglotValueNodeGen extends PolyglotToPolyglotValueNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private PolyglotToPolyglotValueNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return execute(arguments0Value_);
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
            s[0] = "execute";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static PolyglotToPolyglotValueNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PolyglotToPolyglotValueNodeGen(context, builtin, arguments);
        }

    }
}
