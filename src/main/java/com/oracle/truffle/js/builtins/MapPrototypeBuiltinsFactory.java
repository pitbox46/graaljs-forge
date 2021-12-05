// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.builtins.MapPrototypeBuiltins.CreateMapIteratorNode;
import com.oracle.truffle.js.builtins.MapPrototypeBuiltins.JSMapClearNode;
import com.oracle.truffle.js.builtins.MapPrototypeBuiltins.JSMapDeleteNode;
import com.oracle.truffle.js.builtins.MapPrototypeBuiltins.JSMapForEachNode;
import com.oracle.truffle.js.builtins.MapPrototypeBuiltins.JSMapGetNode;
import com.oracle.truffle.js.builtins.MapPrototypeBuiltins.JSMapHasNode;
import com.oracle.truffle.js.builtins.MapPrototypeBuiltins.JSMapOperation;
import com.oracle.truffle.js.builtins.MapPrototypeBuiltins.JSMapSetNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.PropertySetNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(MapPrototypeBuiltins.class)
public final class MapPrototypeBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(JSMapClearNode.class)
    public static final class JSMapClearNodeGen extends JSMapClearNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary mapLib;
        @Child private InteropLibrary foreignMap_iteratorLib_;
        @CompilationFinal private BranchProfile foreignMap_growProfile_;

        private JSMapClearNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSMap(arguments0Value__))) {
                    return JSMapClearNode.doMap(arguments0Value__);
                }
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 doForeignMap(Object, InteropLibrary, InteropLibrary, BranchProfile) || notMap(Object, InteropLibrary) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    if ((!(JSGuards.isJSMap(arguments0Value_))) && (JSMapOperation.isForeignHash(arguments0Value_, this.mapLib))) {
                        return doForeignMap(arguments0Value_, this.mapLib, this.foreignMap_iteratorLib_, this.foreignMap_growProfile_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 notMap(Object, InteropLibrary) */) {
                    if ((!(JSGuards.isJSMap(arguments0Value_))) && (!(JSMapOperation.isForeignHash(arguments0Value_, this.mapLib)))) {
                        return JSMapClearNode.notMap(arguments0Value_, this.mapLib);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSMap(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doMap(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return JSMapClearNode.doMap(arguments0Value_);
                    }
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary foreignMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((JSMapOperation.isForeignHash(arguments0Value, foreignMap_mapLib__))) {
                        if (this.mapLib == null) {
                            InteropLibrary foreignMap_mapLib___check = super.insert(foreignMap_mapLib__);
                            if (foreignMap_mapLib___check == null) {
                                throw new AssertionError("Specialization 'doForeignMap(Object, InteropLibrary, InteropLibrary, BranchProfile)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = foreignMap_mapLib___check;
                        }
                        this.foreignMap_iteratorLib_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                        this.foreignMap_growProfile_ = (BranchProfile.create());
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignMap(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doForeignMap(arguments0Value, foreignMap_mapLib__, this.foreignMap_iteratorLib_, this.foreignMap_growProfile_);
                    }
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary notMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((!(JSMapOperation.isForeignHash(arguments0Value, notMap_mapLib__)))) {
                        if (this.mapLib == null) {
                            InteropLibrary notMap_mapLib___check = super.insert(notMap_mapLib__);
                            if (notMap_mapLib___check == null) {
                                throw new AssertionError("Specialization 'notMap(Object, InteropLibrary)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = notMap_mapLib___check;
                        }
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 notMap(Object, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return JSMapClearNode.notMap(arguments0Value, notMap_mapLib__);
                    }
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
            s[0] = "doMap";
            if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignMap";
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib, this.foreignMap_iteratorLib_, this.foreignMap_growProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "notMap";
            if ((state_0 & 0b100) != 0 /* is-state_0 notMap(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSMapClearNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSMapClearNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSMapDeleteNode.class)
    public static final class JSMapDeleteNodeGen extends JSMapDeleteNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary mapLib;

        private JSMapDeleteNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 doMap(DynamicObject, Object) || doForeignMap(Object, Object, InteropLibrary) || notMap(Object, Object, InteropLibrary) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSMap(arguments0Value__))) {
                        return doMap(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b110) != 0 /* is-state_0 doForeignMap(Object, Object, InteropLibrary) || notMap(Object, Object, InteropLibrary) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, InteropLibrary) */) {
                        if ((!(JSGuards.isJSMap(arguments0Value_))) && (JSMapOperation.isForeignHash(arguments0Value_, this.mapLib))) {
                            return doForeignMap(arguments0Value_, arguments1Value_, this.mapLib);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 notMap(Object, Object, InteropLibrary) */) {
                        if ((!(JSGuards.isJSMap(arguments0Value_))) && (!(JSMapOperation.isForeignHash(arguments0Value_, this.mapLib)))) {
                            return JSMapDeleteNode.notMap(arguments0Value_, arguments1Value_, this.mapLib);
                        }
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
            if (state_0 != 0 /* is-state_0 doMap(DynamicObject, Object) || doForeignMap(Object, Object, InteropLibrary) || notMap(Object, Object, InteropLibrary) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSMap(arguments0Value__))) {
                        return doMap(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b110) != 0 /* is-state_0 doForeignMap(Object, Object, InteropLibrary) || notMap(Object, Object, InteropLibrary) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, InteropLibrary) */) {
                        if ((!(JSGuards.isJSMap(arguments0Value_))) && (JSMapOperation.isForeignHash(arguments0Value_, this.mapLib))) {
                            return doForeignMap(arguments0Value_, arguments1Value_, this.mapLib);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 notMap(Object, Object, InteropLibrary) */) {
                        if ((!(JSGuards.isJSMap(arguments0Value_))) && (!(JSMapOperation.isForeignHash(arguments0Value_, this.mapLib)))) {
                            return JSMapDeleteNode.notMap(arguments0Value_, arguments1Value_, this.mapLib);
                        }
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSMap(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doMap(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doMap(arguments0Value_, arguments1Value);
                    }
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary foreignMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((JSMapOperation.isForeignHash(arguments0Value, foreignMap_mapLib__))) {
                        if (this.mapLib == null) {
                            InteropLibrary foreignMap_mapLib___check = super.insert(foreignMap_mapLib__);
                            if (foreignMap_mapLib___check == null) {
                                throw new AssertionError("Specialization 'doForeignMap(Object, Object, InteropLibrary)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = foreignMap_mapLib___check;
                        }
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignMap(Object, Object, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return doForeignMap(arguments0Value, arguments1Value, foreignMap_mapLib__);
                    }
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary notMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((!(JSMapOperation.isForeignHash(arguments0Value, notMap_mapLib__)))) {
                        if (this.mapLib == null) {
                            InteropLibrary notMap_mapLib___check = super.insert(notMap_mapLib__);
                            if (notMap_mapLib___check == null) {
                                throw new AssertionError("Specialization 'notMap(Object, Object, InteropLibrary)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = notMap_mapLib___check;
                        }
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 notMap(Object, Object, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return JSMapDeleteNode.notMap(arguments0Value, arguments1Value, notMap_mapLib__);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doMap";
            if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignMap";
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "notMap";
            if ((state_0 & 0b100) != 0 /* is-state_0 notMap(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSMapDeleteNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSMapDeleteNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSMapGetNode.class)
    public static final class JSMapGetNodeGen extends JSMapGetNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary mapLib;
        @Child private ImportValueNode foreignMap_importValue_;

        private JSMapGetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 doMap(DynamicObject, Object) || doForeignMap(Object, Object, InteropLibrary, ImportValueNode) || notMap(Object, Object, InteropLibrary) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSMap(arguments0Value__))) {
                        return doMap(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b110) != 0 /* is-state_0 doForeignMap(Object, Object, InteropLibrary, ImportValueNode) || notMap(Object, Object, InteropLibrary) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, InteropLibrary, ImportValueNode) */) {
                        if ((!(JSGuards.isJSMap(arguments0Value_))) && (JSMapOperation.isForeignHash(arguments0Value_, this.mapLib))) {
                            return doForeignMap(arguments0Value_, arguments1Value_, this.mapLib, this.foreignMap_importValue_);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 notMap(Object, Object, InteropLibrary) */) {
                        if ((!(JSGuards.isJSMap(arguments0Value_))) && (!(JSMapOperation.isForeignHash(arguments0Value_, this.mapLib)))) {
                            return JSMapGetNode.notMap(arguments0Value_, arguments1Value_, this.mapLib);
                        }
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSMap(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doMap(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doMap(arguments0Value_, arguments1Value);
                    }
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary foreignMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((JSMapOperation.isForeignHash(arguments0Value, foreignMap_mapLib__))) {
                        if (this.mapLib == null) {
                            InteropLibrary foreignMap_mapLib___check = super.insert(foreignMap_mapLib__);
                            if (foreignMap_mapLib___check == null) {
                                throw new AssertionError("Specialization 'doForeignMap(Object, Object, InteropLibrary, ImportValueNode)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = foreignMap_mapLib___check;
                        }
                        this.foreignMap_importValue_ = super.insert((ImportValueNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignMap(Object, Object, InteropLibrary, ImportValueNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doForeignMap(arguments0Value, arguments1Value, foreignMap_mapLib__, this.foreignMap_importValue_);
                    }
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary notMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((!(JSMapOperation.isForeignHash(arguments0Value, notMap_mapLib__)))) {
                        if (this.mapLib == null) {
                            InteropLibrary notMap_mapLib___check = super.insert(notMap_mapLib__);
                            if (notMap_mapLib___check == null) {
                                throw new AssertionError("Specialization 'notMap(Object, Object, InteropLibrary)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = notMap_mapLib___check;
                        }
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 notMap(Object, Object, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return JSMapGetNode.notMap(arguments0Value, arguments1Value, notMap_mapLib__);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doMap";
            if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignMap";
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib, this.foreignMap_importValue_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "notMap";
            if ((state_0 & 0b100) != 0 /* is-state_0 notMap(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSMapGetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSMapGetNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSMapSetNode.class)
    public static final class JSMapSetNodeGen extends JSMapSetNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary mapLib;
        @Child private ExportValueNode foreignMap_exportValueNode_;

        private JSMapSetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 doMap(DynamicObject, Object, Object) || doForeignMap(Object, Object, Object, InteropLibrary, ExportValueNode) || notMap(Object, Object, Object, InteropLibrary) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSMap(arguments0Value__))) {
                        return doMap(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b110) != 0 /* is-state_0 doForeignMap(Object, Object, Object, InteropLibrary, ExportValueNode) || notMap(Object, Object, Object, InteropLibrary) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, Object, InteropLibrary, ExportValueNode) */) {
                        if ((!(JSGuards.isJSMap(arguments0Value_))) && (JSMapOperation.isForeignHash(arguments0Value_, this.mapLib))) {
                            return doForeignMap(arguments0Value_, arguments1Value_, arguments2Value_, this.mapLib, this.foreignMap_exportValueNode_);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 notMap(Object, Object, Object, InteropLibrary) */) {
                        if ((!(JSGuards.isJSMap(arguments0Value_))) && (!(JSMapOperation.isForeignHash(arguments0Value_, this.mapLib)))) {
                            return JSMapSetNode.notMap(arguments0Value_, arguments1Value_, arguments2Value_, this.mapLib);
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSMap(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doMap(DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doMap(arguments0Value_, arguments1Value, arguments2Value);
                    }
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary foreignMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((JSMapOperation.isForeignHash(arguments0Value, foreignMap_mapLib__))) {
                        if (this.mapLib == null) {
                            InteropLibrary foreignMap_mapLib___check = super.insert(foreignMap_mapLib__);
                            if (foreignMap_mapLib___check == null) {
                                throw new AssertionError("Specialization 'doForeignMap(Object, Object, Object, InteropLibrary, ExportValueNode)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = foreignMap_mapLib___check;
                        }
                        this.foreignMap_exportValueNode_ = super.insert((ExportValueNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignMap(Object, Object, Object, InteropLibrary, ExportValueNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doForeignMap(arguments0Value, arguments1Value, arguments2Value, foreignMap_mapLib__, this.foreignMap_exportValueNode_);
                    }
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary notMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((!(JSMapOperation.isForeignHash(arguments0Value, notMap_mapLib__)))) {
                        if (this.mapLib == null) {
                            InteropLibrary notMap_mapLib___check = super.insert(notMap_mapLib__);
                            if (notMap_mapLib___check == null) {
                                throw new AssertionError("Specialization 'notMap(Object, Object, Object, InteropLibrary)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = notMap_mapLib___check;
                        }
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 notMap(Object, Object, Object, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return JSMapSetNode.notMap(arguments0Value, arguments1Value, arguments2Value, notMap_mapLib__);
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
            s[0] = "doMap";
            if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignMap";
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, Object, InteropLibrary, ExportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib, this.foreignMap_exportValueNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "notMap";
            if ((state_0 & 0b100) != 0 /* is-state_0 notMap(Object, Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSMapSetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSMapSetNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSMapHasNode.class)
    public static final class JSMapHasNodeGen extends JSMapHasNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary mapLib;

        private JSMapHasNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 doMap(DynamicObject, Object) || doForeignMap(Object, Object, InteropLibrary) || notMap(Object, Object, InteropLibrary) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSMap(arguments0Value__))) {
                        return doMap(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b110) != 0 /* is-state_0 doForeignMap(Object, Object, InteropLibrary) || notMap(Object, Object, InteropLibrary) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, InteropLibrary) */) {
                        if ((!(JSGuards.isJSMap(arguments0Value_))) && (JSMapOperation.isForeignHash(arguments0Value_, this.mapLib))) {
                            return doForeignMap(arguments0Value_, arguments1Value_, this.mapLib);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 notMap(Object, Object, InteropLibrary) */) {
                        if ((!(JSGuards.isJSMap(arguments0Value_))) && (!(JSMapOperation.isForeignHash(arguments0Value_, this.mapLib)))) {
                            return JSMapHasNode.notMap(arguments0Value_, arguments1Value_, this.mapLib);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, InteropLibrary) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b101) != 0 /* is-state_0 doMap(DynamicObject, Object) || notMap(Object, Object, InteropLibrary) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSMap(arguments0Value__))) {
                        return doMap(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 notMap(Object, Object, InteropLibrary) */) {
                    if ((!(JSGuards.isJSMap(arguments0Value_))) && (!(JSMapOperation.isForeignHash(arguments0Value_, this.mapLib)))) {
                        return JSMapHasNode.notMap(arguments0Value_, arguments1Value_, this.mapLib);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b10) == 0 /* only-active doMap(DynamicObject, Object) && notMap(Object, Object, InteropLibrary) */ && (state_0 != 0  /* is-not doMap(DynamicObject, Object) && doForeignMap(Object, Object, InteropLibrary) && notMap(Object, Object, InteropLibrary) */)) {
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSMap(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doMap(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doMap(arguments0Value_, arguments1Value);
                    }
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary foreignMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((JSMapOperation.isForeignHash(arguments0Value, foreignMap_mapLib__))) {
                        if (this.mapLib == null) {
                            InteropLibrary foreignMap_mapLib___check = super.insert(foreignMap_mapLib__);
                            if (foreignMap_mapLib___check == null) {
                                throw new AssertionError("Specialization 'doForeignMap(Object, Object, InteropLibrary)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = foreignMap_mapLib___check;
                        }
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignMap(Object, Object, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return doForeignMap(arguments0Value, arguments1Value, foreignMap_mapLib__);
                    }
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary notMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((!(JSMapOperation.isForeignHash(arguments0Value, notMap_mapLib__)))) {
                        if (this.mapLib == null) {
                            InteropLibrary notMap_mapLib___check = super.insert(notMap_mapLib__);
                            if (notMap_mapLib___check == null) {
                                throw new AssertionError("Specialization 'notMap(Object, Object, InteropLibrary)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = notMap_mapLib___check;
                        }
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 notMap(Object, Object, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return JSMapHasNode.notMap(arguments0Value, arguments1Value, notMap_mapLib__);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doMap";
            if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignMap";
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "notMap";
            if ((state_0 & 0b100) != 0 /* is-state_0 notMap(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSMapHasNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSMapHasNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSMapForEachNode.class)
    public static final class JSMapForEachNodeGen extends JSMapForEachNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private IsCallableNode isCallable;
        @Child private JSFunctionCallNode callNode;
        @Child private InteropLibrary mapLib;
        @Child private InteropLibrary foreignMap_iteratorLib_;
        @Child private InteropLibrary foreignMap_entryLib_;

        private JSMapForEachNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 doMap(DynamicObject, Object, Object, IsCallableNode, JSFunctionCallNode) || doForeignMap(Object, Object, Object, IsCallableNode, JSFunctionCallNode, InteropLibrary, InteropLibrary, InteropLibrary) || invalidCallback(Object, Object, Object, IsCallableNode, InteropLibrary) || notMap(Object, Object, Object, InteropLibrary) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object, Object, IsCallableNode, JSFunctionCallNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSMap(arguments0Value__)) && (this.isCallable.executeBoolean(arguments1Value_))) {
                        return doMap(arguments0Value__, arguments1Value_, arguments2Value_, this.isCallable, this.callNode);
                    }
                }
                if ((state_0 & 0b1110) != 0 /* is-state_0 doForeignMap(Object, Object, Object, IsCallableNode, JSFunctionCallNode, InteropLibrary, InteropLibrary, InteropLibrary) || invalidCallback(Object, Object, Object, IsCallableNode, InteropLibrary) || notMap(Object, Object, Object, InteropLibrary) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, Object, IsCallableNode, JSFunctionCallNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                        if ((!(JSGuards.isJSMap(arguments0Value_))) && (JSMapOperation.isForeignHash(arguments0Value_, this.mapLib)) && (this.isCallable.executeBoolean(arguments1Value_))) {
                            return doForeignMap(arguments0Value_, arguments1Value_, arguments2Value_, this.isCallable, this.callNode, this.mapLib, this.foreignMap_iteratorLib_, this.foreignMap_entryLib_);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 invalidCallback(Object, Object, Object, IsCallableNode, InteropLibrary) */) {
                        if ((JSGuards.isJSMap(arguments0Value_) || JSMapOperation.isForeignHash(arguments0Value_, this.mapLib)) && (!(this.isCallable.executeBoolean(arguments1Value_)))) {
                            return JSMapForEachNode.invalidCallback(arguments0Value_, arguments1Value_, arguments2Value_, this.isCallable, this.mapLib);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 notMap(Object, Object, Object, InteropLibrary) */) {
                        if ((!(JSGuards.isJSMap(arguments0Value_))) && (!(JSMapOperation.isForeignHash(arguments0Value_, this.mapLib)))) {
                            return JSMapForEachNode.notMap(arguments0Value_, arguments1Value_, arguments2Value_, this.mapLib);
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    boolean Map_duplicateFound_ = false;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object, Object, IsCallableNode, JSFunctionCallNode) */) {
                        if ((JSGuards.isJSMap(arguments0Value_)) && (this.isCallable.executeBoolean(arguments1Value))) {
                            Map_duplicateFound_ = true;
                        }
                    }
                    if (!Map_duplicateFound_) {
                        if ((JSGuards.isJSMap(arguments0Value_))) {
                            IsCallableNode map_isCallable__ = super.insert(this.isCallable == null ? ((IsCallableNode.create())) : this.isCallable);
                            if ((map_isCallable__.executeBoolean(arguments1Value)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 doMap(DynamicObject, Object, Object, IsCallableNode, JSFunctionCallNode) */) {
                                if (this.isCallable == null) {
                                    IsCallableNode map_isCallable___check = super.insert(map_isCallable__);
                                    if (map_isCallable___check == null) {
                                        throw new AssertionError("Specialization 'doMap(DynamicObject, Object, Object, IsCallableNode, JSFunctionCallNode)' contains a shared cache with name 'isCallable' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isCallable = map_isCallable___check;
                                }
                                this.callNode = super.insert(this.callNode == null ? ((JSFunctionCallNode.createCall())) : this.callNode);
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doMap(DynamicObject, Object, Object, IsCallableNode, JSFunctionCallNode) */;
                                Map_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Map_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return doMap(arguments0Value_, arguments1Value, arguments2Value, this.isCallable, this.callNode);
                    }
                }
                boolean ForeignMap_duplicateFound_ = false;
                if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, Object, IsCallableNode, JSFunctionCallNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                    if ((!(JSGuards.isJSMap(arguments0Value))) && (JSMapOperation.isForeignHash(arguments0Value, this.mapLib)) && (this.isCallable.executeBoolean(arguments1Value))) {
                        ForeignMap_duplicateFound_ = true;
                    }
                }
                if (!ForeignMap_duplicateFound_) {
                    if ((!(JSGuards.isJSMap(arguments0Value)))) {
                        InteropLibrary foreignMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                        if ((JSMapOperation.isForeignHash(arguments0Value, foreignMap_mapLib__))) {
                            IsCallableNode foreignMap_isCallable__ = super.insert(this.isCallable == null ? ((IsCallableNode.create())) : this.isCallable);
                            if ((foreignMap_isCallable__.executeBoolean(arguments1Value)) && ((state_0 & 0b10)) == 0 /* is-not-state_0 doForeignMap(Object, Object, Object, IsCallableNode, JSFunctionCallNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                                if (this.isCallable == null) {
                                    IsCallableNode foreignMap_isCallable___check = super.insert(foreignMap_isCallable__);
                                    if (foreignMap_isCallable___check == null) {
                                        throw new AssertionError("Specialization 'doForeignMap(Object, Object, Object, IsCallableNode, JSFunctionCallNode, InteropLibrary, InteropLibrary, InteropLibrary)' contains a shared cache with name 'isCallable' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isCallable = foreignMap_isCallable___check;
                                }
                                this.callNode = super.insert(this.callNode == null ? ((JSFunctionCallNode.createCall())) : this.callNode);
                                if (this.mapLib == null) {
                                    InteropLibrary foreignMap_mapLib___check = super.insert(foreignMap_mapLib__);
                                    if (foreignMap_mapLib___check == null) {
                                        throw new AssertionError("Specialization 'doForeignMap(Object, Object, Object, IsCallableNode, JSFunctionCallNode, InteropLibrary, InteropLibrary, InteropLibrary)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.mapLib = foreignMap_mapLib___check;
                                }
                                this.foreignMap_iteratorLib_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                this.foreignMap_entryLib_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignMap(Object, Object, Object, IsCallableNode, JSFunctionCallNode, InteropLibrary, InteropLibrary, InteropLibrary) */;
                                ForeignMap_duplicateFound_ = true;
                            }
                        }
                    }
                }
                if (ForeignMap_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return doForeignMap(arguments0Value, arguments1Value, arguments2Value, this.isCallable, this.callNode, this.mapLib, this.foreignMap_iteratorLib_, this.foreignMap_entryLib_);
                }
                boolean InvalidCallback_duplicateFound_ = false;
                if ((state_0 & 0b100) != 0 /* is-state_0 invalidCallback(Object, Object, Object, IsCallableNode, InteropLibrary) */) {
                    if ((JSGuards.isJSMap(arguments0Value) || JSMapOperation.isForeignHash(arguments0Value, this.mapLib)) && (!(this.isCallable.executeBoolean(arguments1Value)))) {
                        InvalidCallback_duplicateFound_ = true;
                    }
                }
                if (!InvalidCallback_duplicateFound_) {
                    {
                        InteropLibrary invalidCallback_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                        if ((JSGuards.isJSMap(arguments0Value) || JSMapOperation.isForeignHash(arguments0Value, invalidCallback_mapLib__))) {
                            IsCallableNode invalidCallback_isCallable__ = super.insert(this.isCallable == null ? ((IsCallableNode.create())) : this.isCallable);
                            if ((!(invalidCallback_isCallable__.executeBoolean(arguments1Value))) && ((state_0 & 0b100)) == 0 /* is-not-state_0 invalidCallback(Object, Object, Object, IsCallableNode, InteropLibrary) */) {
                                if (this.isCallable == null) {
                                    IsCallableNode invalidCallback_isCallable___check = super.insert(invalidCallback_isCallable__);
                                    if (invalidCallback_isCallable___check == null) {
                                        throw new AssertionError("Specialization 'invalidCallback(Object, Object, Object, IsCallableNode, InteropLibrary)' contains a shared cache with name 'isCallable' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isCallable = invalidCallback_isCallable___check;
                                }
                                if (this.mapLib == null) {
                                    InteropLibrary invalidCallback_mapLib___check = super.insert(invalidCallback_mapLib__);
                                    if (invalidCallback_mapLib___check == null) {
                                        throw new AssertionError("Specialization 'invalidCallback(Object, Object, Object, IsCallableNode, InteropLibrary)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.mapLib = invalidCallback_mapLib___check;
                                }
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 invalidCallback(Object, Object, Object, IsCallableNode, InteropLibrary) */;
                                InvalidCallback_duplicateFound_ = true;
                            }
                        }
                    }
                }
                if (InvalidCallback_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return JSMapForEachNode.invalidCallback(arguments0Value, arguments1Value, arguments2Value, this.isCallable, this.mapLib);
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary notMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((!(JSMapOperation.isForeignHash(arguments0Value, notMap_mapLib__)))) {
                        if (this.mapLib == null) {
                            InteropLibrary notMap_mapLib___check = super.insert(notMap_mapLib__);
                            if (notMap_mapLib___check == null) {
                                throw new AssertionError("Specialization 'notMap(Object, Object, Object, InteropLibrary)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = notMap_mapLib___check;
                        }
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 notMap(Object, Object, Object, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return JSMapForEachNode.notMap(arguments0Value, arguments1Value, arguments2Value, notMap_mapLib__);
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
                    return NodeCost.MONOMORPHIC;
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
            s = new Object[3];
            s[0] = "doMap";
            if ((state_0 & 0b1) != 0 /* is-state_0 doMap(DynamicObject, Object, Object, IsCallableNode, JSFunctionCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable, this.callNode));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignMap";
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, Object, Object, IsCallableNode, JSFunctionCallNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable, this.callNode, this.mapLib, this.foreignMap_iteratorLib_, this.foreignMap_entryLib_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "invalidCallback";
            if ((state_0 & 0b100) != 0 /* is-state_0 invalidCallback(Object, Object, Object, IsCallableNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable, this.mapLib));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "notMap";
            if ((state_0 & 0b1000) != 0 /* is-state_0 notMap(Object, Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSMapForEachNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSMapForEachNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(CreateMapIteratorNode.class)
    public static final class CreateMapIteratorNodeGen extends CreateMapIteratorNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary mapLib;
        @Child private PropertySetNode foreignMap_setEnumerateIteratorNode_;

        private CreateMapIteratorNodeGen(JSContext context, JSBuiltin builtin, int iterationKind, JavaScriptNode[] arguments) {
            super(context, builtin, iterationKind);
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doMap(VirtualFrame, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSMap(arguments0Value__))) {
                    return doMap(frameValue, arguments0Value__);
                }
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 doForeignMap(Object, InteropLibrary, PropertySetNode) || doIncompatibleReceiver(Object, InteropLibrary) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, InteropLibrary, PropertySetNode) */) {
                    if ((!(JSGuards.isJSMap(arguments0Value_))) && (JSMapOperation.isForeignHash(arguments0Value_, this.mapLib))) {
                        return doForeignMap(arguments0Value_, this.mapLib, this.foreignMap_setEnumerateIteratorNode_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doIncompatibleReceiver(Object, InteropLibrary) */) {
                    if ((!(JSGuards.isJSMap(arguments0Value_))) && (!(JSMapOperation.isForeignHash(arguments0Value_, this.mapLib)))) {
                        return doIncompatibleReceiver(arguments0Value_, this.mapLib);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSMap(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doMap(VirtualFrame, DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return doMap(frameValue, arguments0Value_);
                    }
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary foreignMap_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((JSMapOperation.isForeignHash(arguments0Value, foreignMap_mapLib__))) {
                        if (this.mapLib == null) {
                            InteropLibrary foreignMap_mapLib___check = super.insert(foreignMap_mapLib__);
                            if (foreignMap_mapLib___check == null) {
                                throw new AssertionError("Specialization 'doForeignMap(Object, InteropLibrary, PropertySetNode)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = foreignMap_mapLib___check;
                        }
                        this.foreignMap_setEnumerateIteratorNode_ = super.insert((PropertySetNode.createSetHidden(JSRuntime.ENUMERATE_ITERATOR_ID, getContext())));
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doForeignMap(Object, InteropLibrary, PropertySetNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doForeignMap(arguments0Value, foreignMap_mapLib__, this.foreignMap_setEnumerateIteratorNode_);
                    }
                }
                if ((!(JSGuards.isJSMap(arguments0Value)))) {
                    InteropLibrary incompatibleReceiver_mapLib__ = super.insert(this.mapLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.mapLib);
                    if ((!(JSMapOperation.isForeignHash(arguments0Value, incompatibleReceiver_mapLib__)))) {
                        if (this.mapLib == null) {
                            InteropLibrary incompatibleReceiver_mapLib___check = super.insert(incompatibleReceiver_mapLib__);
                            if (incompatibleReceiver_mapLib___check == null) {
                                throw new AssertionError("Specialization 'doIncompatibleReceiver(Object, InteropLibrary)' contains a shared cache with name 'mapLib' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.mapLib = incompatibleReceiver_mapLib___check;
                        }
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doIncompatibleReceiver(Object, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return doIncompatibleReceiver(arguments0Value, incompatibleReceiver_mapLib__);
                    }
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
            s[0] = "doMap";
            if ((state_0 & 0b1) != 0 /* is-state_0 doMap(VirtualFrame, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignMap";
            if ((state_0 & 0b10) != 0 /* is-state_0 doForeignMap(Object, InteropLibrary, PropertySetNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib, this.foreignMap_setEnumerateIteratorNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doIncompatibleReceiver";
            if ((state_0 & 0b100) != 0 /* is-state_0 doIncompatibleReceiver(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.mapLib));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static CreateMapIteratorNode create(JSContext context, JSBuiltin builtin, int iterationKind, JavaScriptNode[] arguments) {
            return new CreateMapIteratorNodeGen(context, builtin, iterationKind, arguments);
        }

    }
}
