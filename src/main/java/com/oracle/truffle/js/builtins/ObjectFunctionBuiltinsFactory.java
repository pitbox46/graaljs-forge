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
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.AssignPropertiesNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectAssignNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectBindPropertiesNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectCreateNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectDefinePropertiesNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectDefinePropertyNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectFromEntriesNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectGetOwnPropertyDescriptorNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectGetOwnPropertyDescriptorsNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectGetOwnPropertyNamesOrSymbolsNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectGetPrototypeOfNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectHasOwnNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectIsExtensibleNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectIsNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectKeysNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectPreventExtensionsNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectSetIntegrityLevelNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectSetPrototypeOfNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectTestIntegrityLevelNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectValuesOrEntriesNode;
import com.oracle.truffle.js.builtins.helper.ListGetNode;
import com.oracle.truffle.js.builtins.helper.ListSizeNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.GetPrototypeNode;
import com.oracle.truffle.js.nodes.access.IsExtensibleNode;
import com.oracle.truffle.js.nodes.access.JSGetOwnPropertyNode;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.nodes.access.WriteElementNode;
import com.oracle.truffle.js.nodes.binary.JSIdenticalNode;
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSDynamicObject;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import com.oracle.truffle.js.runtime.objects.JSObject;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ObjectFunctionBuiltins.class)
@SuppressWarnings("unused")
public final class ObjectFunctionBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(ObjectGetPrototypeOfNode.class)
    public static final class ObjectGetPrototypeOfNodeGen extends ObjectGetPrototypeOfNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private GetPrototypeNode getPrototypeOfJSObject_getPrototypeNode_;

        private ObjectGetPrototypeOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 getPrototypeOfNonObject(Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return getPrototypeOfNonObject(arguments0Value_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 getPrototypeOfJSObject(DynamicObject, GetPrototypeNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return getPrototypeOfJSObject(arguments0Value__, this.getPrototypeOfJSObject_getPrototypeNode_);
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
                if ((!(JSGuards.isJSObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getPrototypeOfNonObject(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return getPrototypeOfNonObject(arguments0Value);
                }
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.getPrototypeOfJSObject_getPrototypeNode_ = super.insert((GetPrototypeNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getPrototypeOfJSObject(DynamicObject, GetPrototypeNode) */;
                        lock.unlock();
                        hasLock = false;
                        return getPrototypeOfJSObject(arguments0Value_, this.getPrototypeOfJSObject_getPrototypeNode_);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "getPrototypeOfNonObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 getPrototypeOfNonObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "getPrototypeOfJSObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 getPrototypeOfJSObject(DynamicObject, GetPrototypeNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.getPrototypeOfJSObject_getPrototypeNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ObjectGetPrototypeOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectGetPrototypeOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectGetOwnPropertyDescriptorNode.class)
    public static final class ObjectGetOwnPropertyDescriptorNodeGen extends ObjectGetOwnPropertyDescriptorNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private GetForeignObject0Data getForeignObject0_cache;
        @Child private ImportValueNode getForeignObject1_toJSType_;

        private ObjectGetOwnPropertyDescriptorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 getJSObject(DynamicObject, Object) || getForeignObject(Object, Object, InteropLibrary, ImportValueNode) || getForeignObject(Object, Object, InteropLibrary, ImportValueNode) || getDefault(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 getJSObject(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return getJSObject(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b1110) != 0 /* is-state_0 getForeignObject(Object, Object, InteropLibrary, ImportValueNode) || getForeignObject(Object, Object, InteropLibrary, ImportValueNode) || getDefault(Object, Object) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
                        GetForeignObject0Data s1_ = this.getForeignObject0_cache;
                        while (s1_ != null) {
                            if ((s1_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return getForeignObject(arguments0Value_, arguments1Value_, s1_.interop_, s1_.toJSType_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.getForeignObject1Boundary(state_0, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 getDefault(Object, Object) */) {
                        if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return getDefault(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object getForeignObject1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary getForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return getForeignObject(arguments0Value_, arguments1Value_, getForeignObject1_interop__, this.getForeignObject1_toJSType_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getJSObject(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return getJSObject(arguments0Value_, arguments1Value);
                    }
                }
                if ((exclude) == 0 /* is-not-exclude getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
                    int count1_ = 0;
                    GetForeignObject0Data s1_ = this.getForeignObject0_cache;
                    if ((state_0 & 0b10) != 0 /* is-state_0 getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
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
                            s1_ = super.insert(new GetForeignObject0Data(getForeignObject0_cache));
                            s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            s1_.toJSType_ = s1_.insertAccessor((ImportValueNode.create()));
                            MemoryFence.storeStore();
                            this.getForeignObject0_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return getForeignObject(arguments0Value, arguments1Value, s1_.interop_, s1_.toJSType_);
                    }
                }
                {
                    InteropLibrary getForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                getForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.getForeignObject1_toJSType_ = super.insert((ImportValueNode.create()));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */;
                                this.getForeignObject0_cache = null;
                                state_0 = state_0 & 0xfffffffd /* remove-state_0 getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */;
                                lock.unlock();
                                hasLock = false;
                                return getForeignObject(arguments0Value, arguments1Value, getForeignObject1_interop__, this.getForeignObject1_toJSType_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 getDefault(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return getDefault(arguments0Value, arguments1Value);
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
                    GetForeignObject0Data s1_ = this.getForeignObject0_cache;
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
            s[0] = "getJSObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 getJSObject(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "getForeignObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                GetForeignObject0Data s1_ = this.getForeignObject0_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.interop_, s1_.toJSType_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "getForeignObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.getForeignObject1_toJSType_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "getDefault";
            if ((state_0 & 0b1000) != 0 /* is-state_0 getDefault(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ObjectGetOwnPropertyDescriptorNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectGetOwnPropertyDescriptorNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ObjectGetOwnPropertyDescriptorNode.class)
        private static final class GetForeignObject0Data extends Node {

            @Child GetForeignObject0Data next_;
            @Child InteropLibrary interop_;
            @Child ImportValueNode toJSType_;

            GetForeignObject0Data(GetForeignObject0Data next_) {
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
    @GeneratedBy(ObjectGetOwnPropertyDescriptorsNode.class)
    public static final class ObjectGetOwnPropertyDescriptorsNodeGen extends ObjectGetOwnPropertyDescriptorsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private GetJSObjectData getJSObject_cache;
        @Child private GetForeignObject0Data getForeignObject0_cache;
        @Child private GetForeignObject1Data getForeignObject1_cache;
        @Child private ObjectGetOwnPropertyDescriptorsNode getDefault_recursive_;

        private ObjectGetOwnPropertyDescriptorsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @ExplodeLoop
        @Override
        protected DynamicObject executeEvaluated(Object arguments0Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 getJSObject(DynamicObject, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                GetJSObjectData s0_ = this.getJSObject_cache;
                if (s0_ != null) {
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        return getJSObject(arguments0Value_, s0_.getOwnPropertyNode_, s0_.listSize_, s0_.listGet_, s0_.classProfile_);
                    }
                }
            }
            if ((state_0 & 0b1110) != 0 /* is-state_0 getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) || getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) || getDefault(Object, ObjectGetOwnPropertyDescriptorsNode) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                    GetForeignObject0Data s1_ = this.getForeignObject0_cache;
                    while (s1_ != null) {
                        if ((s1_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                            return getForeignObject(arguments0Value, s1_.interop_, s1_.members_, s1_.toJSType_, s1_.errorBranch_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                    GetForeignObject1Data s2_ = this.getForeignObject1_cache;
                    if (s2_ != null) {
                        if ((JSGuards.isForeignObject(arguments0Value))) {
                            return this.getForeignObject1Boundary(state_0, s2_, arguments0Value);
                        }
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 getDefault(Object, ObjectGetOwnPropertyDescriptorsNode) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                        return getDefault(arguments0Value, this.getDefault_recursive_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private DynamicObject getForeignObject1Boundary(int state_0, GetForeignObject1Data s2_, Object arguments0Value) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                    return getForeignObject(arguments0Value, interop__, s2_.members_, s2_.toJSType_, s2_.errorBranch_);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 getJSObject(DynamicObject, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                GetJSObjectData s0_ = this.getJSObject_cache;
                if (s0_ != null) {
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return getJSObject(arguments0Value__, s0_.getOwnPropertyNode_, s0_.listSize_, s0_.listGet_, s0_.classProfile_);
                    }
                }
            }
            if ((state_0 & 0b1110) != 0 /* is-state_0 getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) || getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) || getDefault(Object, ObjectGetOwnPropertyDescriptorsNode) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                    GetForeignObject0Data s1_ = this.getForeignObject0_cache;
                    while (s1_ != null) {
                        if ((s1_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return getForeignObject(arguments0Value_, s1_.interop_, s1_.members_, s1_.toJSType_, s1_.errorBranch_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                    GetForeignObject1Data s2_ = this.getForeignObject1_cache;
                    if (s2_ != null) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.getForeignObject1Boundary0(state_0, s2_, arguments0Value_);
                        }
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 getDefault(Object, ObjectGetOwnPropertyDescriptorsNode) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                        return getDefault(arguments0Value_, this.getDefault_recursive_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object getForeignObject1Boundary0(int state_0, GetForeignObject1Data s2_, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return getForeignObject(arguments0Value_, interop__, s2_.members_, s2_.toJSType_, s2_.errorBranch_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        GetJSObjectData s0_ = super.insert(new GetJSObjectData());
                        s0_.getOwnPropertyNode_ = s0_.insertAccessor((JSGetOwnPropertyNode.create()));
                        s0_.listSize_ = s0_.insertAccessor((ListSizeNode.create()));
                        s0_.listGet_ = s0_.insertAccessor((ListGetNode.create()));
                        s0_.classProfile_ = (JSClassProfile.create());
                        MemoryFence.storeStore();
                        this.getJSObject_cache = s0_;
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getJSObject(DynamicObject, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return getJSObject(arguments0Value_, s0_.getOwnPropertyNode_, s0_.listSize_, s0_.listGet_, s0_.classProfile_);
                    }
                }
                if ((exclude) == 0 /* is-not-exclude getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                    int count1_ = 0;
                    GetForeignObject0Data s1_ = this.getForeignObject0_cache;
                    if ((state_0 & 0b10) != 0 /* is-state_0 getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
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
                            s1_ = super.insert(new GetForeignObject0Data(getForeignObject0_cache));
                            s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            s1_.members_ = s1_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                            s1_.toJSType_ = s1_.insertAccessor((ImportValueNode.create()));
                            s1_.errorBranch_ = (BranchProfile.create());
                            MemoryFence.storeStore();
                            this.getForeignObject0_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return getForeignObject(arguments0Value, s1_.interop_, s1_.members_, s1_.toJSType_, s1_.errorBranch_);
                    }
                }
                {
                    InteropLibrary interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                GetForeignObject1Data s2_ = super.insert(new GetForeignObject1Data());
                                interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                s2_.members_ = s2_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                s2_.toJSType_ = s2_.insertAccessor((ImportValueNode.create()));
                                s2_.errorBranch_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.getForeignObject1_cache = s2_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */;
                                this.getForeignObject0_cache = null;
                                state_0 = state_0 & 0xfffffffd /* remove-state_0 getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return getForeignObject(arguments0Value, interop__, s2_.members_, s2_.toJSType_, s2_.errorBranch_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.getDefault_recursive_ = super.insert((createRecursive()));
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 getDefault(Object, ObjectGetOwnPropertyDescriptorsNode) */;
                    lock.unlock();
                    hasLock = false;
                    return getDefault(arguments0Value, this.getDefault_recursive_);
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
                    GetForeignObject0Data s1_ = this.getForeignObject0_cache;
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
            s[0] = "getJSObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 getJSObject(DynamicObject, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                GetJSObjectData s0_ = this.getJSObject_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.getOwnPropertyNode_, s0_.listSize_, s0_.listGet_, s0_.classProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "getForeignObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                GetForeignObject0Data s1_ = this.getForeignObject0_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.interop_, s1_.members_, s1_.toJSType_, s1_.errorBranch_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "getForeignObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                GetForeignObject1Data s2_ = this.getForeignObject1_cache;
                if (s2_ != null) {
                    cached.add(Arrays.asList(s2_.members_, s2_.toJSType_, s2_.errorBranch_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "getDefault";
            if ((state_0 & 0b1000) != 0 /* is-state_0 getDefault(Object, ObjectGetOwnPropertyDescriptorsNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.getDefault_recursive_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ObjectGetOwnPropertyDescriptorsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectGetOwnPropertyDescriptorsNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ObjectGetOwnPropertyDescriptorsNode.class)
        private static final class GetJSObjectData extends Node {

            @Child JSGetOwnPropertyNode getOwnPropertyNode_;
            @Child ListSizeNode listSize_;
            @Child ListGetNode listGet_;
            @CompilationFinal JSClassProfile classProfile_;

            GetJSObjectData() {
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
        @GeneratedBy(ObjectGetOwnPropertyDescriptorsNode.class)
        private static final class GetForeignObject0Data extends Node {

            @Child GetForeignObject0Data next_;
            @Child InteropLibrary interop_;
            @Child InteropLibrary members_;
            @Child ImportValueNode toJSType_;
            @CompilationFinal BranchProfile errorBranch_;

            GetForeignObject0Data(GetForeignObject0Data next_) {
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
        @GeneratedBy(ObjectGetOwnPropertyDescriptorsNode.class)
        private static final class GetForeignObject1Data extends Node {

            @Child InteropLibrary members_;
            @Child ImportValueNode toJSType_;
            @CompilationFinal BranchProfile errorBranch_;

            GetForeignObject1Data() {
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
    @GeneratedBy(ObjectGetOwnPropertyNamesOrSymbolsNode.class)
    public static final class ObjectGetOwnPropertyNamesOrSymbolsNodeGen extends ObjectGetOwnPropertyNamesOrSymbolsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSClassProfile jsclassProfile;
        @Child private ListSizeNode listSize;
        @Child private GetForeignObjectNames0Data getForeignObjectNames0_cache;
        @Child private InteropLibrary getForeignObjectNames1_members_;
        @CompilationFinal private BranchProfile getForeignObjectNames1_errorBranch_;

        private ObjectGetOwnPropertyNamesOrSymbolsNodeGen(JSContext context, JSBuiltin builtin, boolean symbols, JavaScriptNode[] arguments) {
            super(context, builtin, symbols);
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
            if ((state_0 & 0b1) != 0 /* is-state_0 getJSObject(DynamicObject, JSClassProfile, ListSizeNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return getJSObject(arguments0Value__, this.jsclassProfile, this.listSize);
                }
            }
            if ((state_0 & 0b11110) != 0 /* is-state_0 getDefault(Object, JSClassProfile, ListSizeNode) || getForeignObjectSymbols(Object) || getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) || getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 getDefault(Object, JSClassProfile, ListSizeNode) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                        return getDefault(arguments0Value_, this.jsclassProfile, this.listSize);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 getForeignObjectSymbols(Object) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        assert (symbols);
                        return getForeignObjectSymbols(arguments0Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    GetForeignObjectNames0Data s3_ = this.getForeignObjectNames0_cache;
                    while (s3_ != null) {
                        if ((s3_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            assert (!(symbols));
                            return getForeignObjectNames(arguments0Value_, s3_.interop_, s3_.members_, s3_.errorBranch_);
                        }
                        s3_ = s3_.next_;
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        assert (!(symbols));
                        return this.getForeignObjectNames1Boundary(state_0, arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object getForeignObjectNames1Boundary(int state_0, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary getForeignObjectNames1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return getForeignObjectNames(arguments0Value_, getForeignObjectNames1_interop__, this.getForeignObjectNames1_members_, this.getForeignObjectNames1_errorBranch_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.jsclassProfile = this.jsclassProfile == null ? ((JSClassProfile.create())) : this.jsclassProfile;
                        this.listSize = super.insert(this.listSize == null ? ((ListSizeNode.create())) : this.listSize);
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getJSObject(DynamicObject, JSClassProfile, ListSizeNode) */;
                        lock.unlock();
                        hasLock = false;
                        return getJSObject(arguments0Value_, this.jsclassProfile, this.listSize);
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.jsclassProfile = this.jsclassProfile == null ? ((JSClassProfile.create())) : this.jsclassProfile;
                    this.listSize = super.insert(this.listSize == null ? ((ListSizeNode.create())) : this.listSize);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getDefault(Object, JSClassProfile, ListSizeNode) */;
                    lock.unlock();
                    hasLock = false;
                    return getDefault(arguments0Value, this.jsclassProfile, this.listSize);
                }
                if ((JSGuards.isForeignObject(arguments0Value)) && (symbols)) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 getForeignObjectSymbols(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return getForeignObjectSymbols(arguments0Value);
                }
                if ((exclude) == 0 /* is-not-exclude getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    int count3_ = 0;
                    GetForeignObjectNames0Data s3_ = this.getForeignObjectNames0_cache;
                    if ((state_0 & 0b1000) != 0 /* is-state_0 getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                        while (s3_ != null) {
                            if ((s3_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                assert (!(symbols));
                                break;
                            }
                            s3_ = s3_.next_;
                            count3_++;
                        }
                    }
                    if (s3_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && (!(symbols)) && count3_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s3_.interop_.accepts(arguments0Value));
                            s3_ = super.insert(new GetForeignObjectNames0Data(getForeignObjectNames0_cache));
                            s3_.interop_ = s3_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            s3_.members_ = s3_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                            s3_.errorBranch_ = (BranchProfile.create());
                            MemoryFence.storeStore();
                            this.getForeignObjectNames0_cache = s3_;
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                        }
                    }
                    if (s3_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return getForeignObjectNames(arguments0Value, s3_.interop_, s3_.members_, s3_.errorBranch_);
                    }
                }
                {
                    InteropLibrary getForeignObjectNames1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value)) && (!(symbols))) {
                                getForeignObjectNames1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.getForeignObjectNames1_members_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                this.getForeignObjectNames1_errorBranch_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                                this.getForeignObjectNames0_cache = null;
                                state_0 = state_0 & 0xfffffff7 /* remove-state_0 getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return getForeignObjectNames(arguments0Value, getForeignObjectNames1_interop__, this.getForeignObjectNames1_members_, this.getForeignObjectNames1_errorBranch_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
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
                    GetForeignObjectNames0Data s3_ = this.getForeignObjectNames0_cache;
                    if ((s3_ == null || s3_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
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
            s[0] = "getJSObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 getJSObject(DynamicObject, JSClassProfile, ListSizeNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.jsclassProfile, this.listSize));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "getDefault";
            if ((state_0 & 0b10) != 0 /* is-state_0 getDefault(Object, JSClassProfile, ListSizeNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.jsclassProfile, this.listSize));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "getForeignObjectSymbols";
            if ((state_0 & 0b100) != 0 /* is-state_0 getForeignObjectSymbols(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "getForeignObjectNames";
            if ((state_0 & 0b1000) != 0 /* is-state_0 getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                GetForeignObjectNames0Data s3_ = this.getForeignObjectNames0_cache;
                while (s3_ != null) {
                    cached.add(Arrays.asList(s3_.interop_, s3_.members_, s3_.errorBranch_));
                    s3_ = s3_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "getForeignObjectNames";
            if ((state_0 & 0b10000) != 0 /* is-state_0 getForeignObjectNames(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.getForeignObjectNames1_members_, this.getForeignObjectNames1_errorBranch_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static ObjectGetOwnPropertyNamesOrSymbolsNode create(JSContext context, JSBuiltin builtin, boolean symbols, JavaScriptNode[] arguments) {
            return new ObjectGetOwnPropertyNamesOrSymbolsNodeGen(context, builtin, symbols, arguments);
        }

        @GeneratedBy(ObjectGetOwnPropertyNamesOrSymbolsNode.class)
        private static final class GetForeignObjectNames0Data extends Node {

            @Child GetForeignObjectNames0Data next_;
            @Child InteropLibrary interop_;
            @Child InteropLibrary members_;
            @CompilationFinal BranchProfile errorBranch_;

            GetForeignObjectNames0Data(GetForeignObjectNames0Data next_) {
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
    @GeneratedBy(ObjectCreateNode.class)
    public static final class ObjectCreateNodeGen extends ObjectCreateNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private CreateForeignNullOrInvalidPrototype0Data createForeignNullOrInvalidPrototype0_cache;
        @CompilationFinal private ConditionProfile createForeignNullOrInvalidPrototype1_isNull_;

        private ObjectCreateNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b111) != 0 /* is-state_0 createPrototypeNull(Object, Object) || createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) || createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 createPrototypeNull(Object, Object) */) {
                    if ((JSGuards.isJSNull(arguments0Value_))) {
                        return createPrototypeNull(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) */) {
                    CreateForeignNullOrInvalidPrototype0Data s1_ = this.createForeignNullOrInvalidPrototype0_cache;
                    while (s1_ != null) {
                        if ((s1_.interop_.accepts(arguments0Value_)) && (!(JSGuards.isJSNull(arguments0Value_))) && (!(JSGuards.isJSObject(arguments0Value_)))) {
                            return createForeignNullOrInvalidPrototype(arguments0Value_, arguments1Value_, s1_.interop_, s1_.isNull_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) */) {
                    if ((!(JSGuards.isJSNull(arguments0Value_))) && (!(JSGuards.isJSObject(arguments0Value_)))) {
                        return this.createForeignNullOrInvalidPrototype1Boundary(state_0, arguments0Value_, arguments1Value_);
                    }
                }
            }
            if ((state_0 & 0b111000) != 0 /* is-state_0 createObjectObject(DynamicObject, DynamicObject) || createObjectNotNull(DynamicObject, Object) || createObjectNull(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 createObjectObject(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                        return createObjectObject(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b110000) != 0 /* is-state_0 createObjectNotNull(DynamicObject, Object) || createObjectNull(DynamicObject, Object) */) {
                    if ((state_0 & 0b10000) != 0 /* is-state_0 createObjectNotNull(DynamicObject, Object) */) {
                        if ((JSGuards.isJSObject(arguments0Value__)) && (!(JSGuards.isJSNull(arguments1Value_)))) {
                            return createObjectNotNull(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 createObjectNull(DynamicObject, Object) */) {
                        if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isJSNull(arguments1Value_))) {
                            return createObjectNull(arguments0Value__, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object createForeignNullOrInvalidPrototype1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary createForeignNullOrInvalidPrototype1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return createForeignNullOrInvalidPrototype(arguments0Value_, arguments1Value_, createForeignNullOrInvalidPrototype1_interop__, this.createForeignNullOrInvalidPrototype1_isNull_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((JSGuards.isJSNull(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 createPrototypeNull(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return createPrototypeNull(arguments0Value, arguments1Value);
                }
                if ((exclude) == 0 /* is-not-exclude createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) */) {
                    int count1_ = 0;
                    CreateForeignNullOrInvalidPrototype0Data s1_ = this.createForeignNullOrInvalidPrototype0_cache;
                    if ((state_0 & 0b10) != 0 /* is-state_0 createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) */) {
                        while (s1_ != null) {
                            if ((s1_.interop_.accepts(arguments0Value)) && (!(JSGuards.isJSNull(arguments0Value))) && (!(JSGuards.isJSObject(arguments0Value)))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        if ((!(JSGuards.isJSNull(arguments0Value))) && (!(JSGuards.isJSObject(arguments0Value))) && count1_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s1_.interop_.accepts(arguments0Value));
                            s1_ = super.insert(new CreateForeignNullOrInvalidPrototype0Data(createForeignNullOrInvalidPrototype0_cache));
                            s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            s1_.isNull_ = (ConditionProfile.createBinaryProfile());
                            MemoryFence.storeStore();
                            this.createForeignNullOrInvalidPrototype0_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return createForeignNullOrInvalidPrototype(arguments0Value, arguments1Value, s1_.interop_, s1_.isNull_);
                    }
                }
                {
                    InteropLibrary createForeignNullOrInvalidPrototype1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((!(JSGuards.isJSNull(arguments0Value))) && (!(JSGuards.isJSObject(arguments0Value)))) {
                                createForeignNullOrInvalidPrototype1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.createForeignNullOrInvalidPrototype1_isNull_ = (ConditionProfile.createBinaryProfile());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) */;
                                this.createForeignNullOrInvalidPrototype0_cache = null;
                                state_0 = state_0 & 0xfffffffd /* remove-state_0 createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return createForeignNullOrInvalidPrototype(arguments0Value, arguments1Value, createForeignNullOrInvalidPrototype1_interop__, this.createForeignNullOrInvalidPrototype1_isNull_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (JSTypes.isDynamicObject(arguments1Value)) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 createObjectObject(DynamicObject, DynamicObject) */;
                            lock.unlock();
                            hasLock = false;
                            return createObjectObject(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((JSGuards.isJSObject(arguments0Value_)) && (!(JSGuards.isJSNull(arguments1Value)))) {
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 createObjectNotNull(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return createObjectNotNull(arguments0Value_, arguments1Value);
                    }
                    if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isJSNull(arguments1Value))) {
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 createObjectNull(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return createObjectNull(arguments0Value_, arguments1Value);
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
                    CreateForeignNullOrInvalidPrototype0Data s1_ = this.createForeignNullOrInvalidPrototype0_cache;
                    if ((s1_ == null || s1_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
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
            s[0] = "createPrototypeNull";
            if ((state_0 & 0b1) != 0 /* is-state_0 createPrototypeNull(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "createForeignNullOrInvalidPrototype";
            if ((state_0 & 0b10) != 0 /* is-state_0 createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CreateForeignNullOrInvalidPrototype0Data s1_ = this.createForeignNullOrInvalidPrototype0_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.interop_, s1_.isNull_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "createForeignNullOrInvalidPrototype";
            if ((state_0 & 0b100) != 0 /* is-state_0 createForeignNullOrInvalidPrototype(Object, Object, InteropLibrary, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.createForeignNullOrInvalidPrototype1_isNull_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "createObjectObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 createObjectObject(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "createObjectNotNull";
            if ((state_0 & 0b10000) != 0 /* is-state_0 createObjectNotNull(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "createObjectNull";
            if ((state_0 & 0b100000) != 0 /* is-state_0 createObjectNull(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            return Provider.create(data);
        }

        public static ObjectCreateNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectCreateNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ObjectCreateNode.class)
        private static final class CreateForeignNullOrInvalidPrototype0Data extends Node {

            @Child CreateForeignNullOrInvalidPrototype0Data next_;
            @Child InteropLibrary interop_;
            @CompilationFinal ConditionProfile isNull_;

            CreateForeignNullOrInvalidPrototype0Data(CreateForeignNullOrInvalidPrototype0Data next_) {
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
    @GeneratedBy(ObjectDefinePropertyNode.class)
    public static final class ObjectDefinePropertyNodeGen extends ObjectDefinePropertyNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;
        @CompilationFinal private int exclude_;

        private ObjectDefinePropertyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b11) != 0 /* is-state_0 definePropertyJSObjectString(DynamicObject, String, Object) || definePropertyGeneric(Object, Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 definePropertyJSObjectString(DynamicObject, String, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if (JSTypesGen.isImplicitString((state_0 & 0b11100) >>> 2 /* extract-implicit-state_0 1:String */, arguments1Value_)) {
                        String arguments1Value__ = JSTypesGen.asImplicitString((state_0 & 0b11100) >>> 2 /* extract-implicit-state_0 1:String */, arguments1Value_);
                        if ((JSGuards.isJSObject(arguments0Value__))) {
                            return definePropertyJSObjectString(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 definePropertyGeneric(Object, Object, Object) */) {
                    return definePropertyGeneric(arguments0Value_, arguments1Value_, arguments2Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude definePropertyJSObjectString(DynamicObject, String, Object) */ && JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    int stringCast1;
                    if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                        String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            state_0 = (state_0 | (stringCast1 << 2) /* set-implicit-state_0 1:String */);
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 definePropertyJSObjectString(DynamicObject, String, Object) */;
                            lock.unlock();
                            hasLock = false;
                            return definePropertyJSObjectString(arguments0Value_, arguments1Value_, arguments2Value);
                        }
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude definePropertyJSObjectString(DynamicObject, String, Object) */;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 definePropertyJSObjectString(DynamicObject, String, Object) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 definePropertyGeneric(Object, Object, Object) */;
                lock.unlock();
                hasLock = false;
                return definePropertyGeneric(arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "definePropertyJSObjectString";
            if ((state_0 & 0b1) != 0 /* is-state_0 definePropertyJSObjectString(DynamicObject, String, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-exclude definePropertyJSObjectString(DynamicObject, String, Object) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "definePropertyGeneric";
            if ((state_0 & 0b10) != 0 /* is-state_0 definePropertyGeneric(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ObjectDefinePropertyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectDefinePropertyNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectDefinePropertiesNode.class)
    public static final class ObjectDefinePropertiesNodeGen extends ObjectDefinePropertiesNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;
        @CompilationFinal private int exclude_;

        private ObjectDefinePropertiesNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 definePropertiesObjectObject(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                        return definePropertiesObjectObject(arguments0Value__, arguments1Value__);
                    }
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 definePropertiesGeneric(Object, Object) */) {
                return definePropertiesGeneric(arguments0Value_, arguments1Value_);
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
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude definePropertiesObjectObject(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (JSTypes.isDynamicObject(arguments1Value)) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 definePropertiesObjectObject(DynamicObject, DynamicObject) */;
                            lock.unlock();
                            hasLock = false;
                            return definePropertiesObjectObject(arguments0Value_, arguments1Value_);
                        }
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude definePropertiesObjectObject(DynamicObject, DynamicObject) */;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 definePropertiesObjectObject(DynamicObject, DynamicObject) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 definePropertiesGeneric(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return definePropertiesGeneric(arguments0Value, arguments1Value);
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
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "definePropertiesObjectObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 definePropertiesObjectObject(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-exclude definePropertiesObjectObject(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "definePropertiesGeneric";
            if ((state_0 & 0b10) != 0 /* is-state_0 definePropertiesGeneric(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ObjectDefinePropertiesNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectDefinePropertiesNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectIsExtensibleNode.class)
    public static final class ObjectIsExtensibleNodeGen extends ObjectIsExtensibleNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private IsExtensibleNode isExtensibleObject_isExtensibleNode_;

        private ObjectIsExtensibleNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 isExtensibleObject(DynamicObject, IsExtensibleNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return isExtensibleObject(arguments0Value__, this.isExtensibleObject_isExtensibleNode_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isExtensibleNonObject(Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return isExtensibleNonObject(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 isExtensibleObject(DynamicObject, IsExtensibleNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return isExtensibleObject(arguments0Value__, this.isExtensibleObject_isExtensibleNode_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isExtensibleNonObject(Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return isExtensibleNonObject(arguments0Value_);
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.isExtensibleObject_isExtensibleNode_ = super.insert((IsExtensibleNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 isExtensibleObject(DynamicObject, IsExtensibleNode) */;
                        lock.unlock();
                        hasLock = false;
                        return isExtensibleObject(arguments0Value_, this.isExtensibleObject_isExtensibleNode_);
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 isExtensibleNonObject(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return isExtensibleNonObject(arguments0Value);
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
            s[0] = "isExtensibleObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 isExtensibleObject(DynamicObject, IsExtensibleNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isExtensibleObject_isExtensibleNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isExtensibleNonObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 isExtensibleNonObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ObjectIsExtensibleNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectIsExtensibleNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectPreventExtensionsNode.class)
    public static final class ObjectPreventExtensionsNodeGen extends ObjectPreventExtensionsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private ObjectPreventExtensionsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 preventExtensionsObject(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return preventExtensionsObject(arguments0Value__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 preventExtensionsNonObject(Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return preventExtensionsNonObject(arguments0Value_);
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
                if ((JSGuards.isJSObject(arguments0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 preventExtensionsObject(DynamicObject) */;
                    return preventExtensionsObject(arguments0Value_);
                }
            }
            if ((!(JSGuards.isJSObject(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 preventExtensionsNonObject(Object) */;
                return preventExtensionsNonObject(arguments0Value);
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
            s[0] = "preventExtensionsObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 preventExtensionsObject(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "preventExtensionsNonObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 preventExtensionsNonObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ObjectPreventExtensionsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPreventExtensionsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectTestIntegrityLevelNode.class)
    public static final class ObjectTestIntegrityLevelNodeGen extends ObjectTestIntegrityLevelNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private ObjectTestIntegrityLevelNodeGen(JSContext context, JSBuiltin builtin, boolean frozen, JavaScriptNode[] arguments) {
            super(context, builtin, frozen);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return testIntegrityLevel(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return testIntegrityLevel(arguments0Value_);
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
            s[0] = "testIntegrityLevel";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectTestIntegrityLevelNode create(JSContext context, JSBuiltin builtin, boolean frozen, JavaScriptNode[] arguments) {
            return new ObjectTestIntegrityLevelNodeGen(context, builtin, frozen, arguments);
        }

    }
    @GeneratedBy(ObjectSetIntegrityLevelNode.class)
    public static final class ObjectSetIntegrityLevelNodeGen extends ObjectSetIntegrityLevelNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private ObjectSetIntegrityLevelNodeGen(JSContext context, JSBuiltin builtin, boolean freeze, JavaScriptNode[] arguments) {
            super(context, builtin, freeze);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return setIntegrityLevel(arguments0Value_);
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
            s[0] = "setIntegrityLevel";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectSetIntegrityLevelNode create(JSContext context, JSBuiltin builtin, boolean freeze, JavaScriptNode[] arguments) {
            return new ObjectSetIntegrityLevelNodeGen(context, builtin, freeze, arguments);
        }

    }
    @GeneratedBy(ObjectKeysNode.class)
    public static final class ObjectKeysNodeGen extends ObjectKeysNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private KeysForeign0Data keysForeign0_cache;
        @Child private KeysForeign1Data keysForeign1_cache;

        private ObjectKeysNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 keysDynamicObject(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSDynamicObject(arguments0Value__))) {
                    return keysDynamicObject(arguments0Value__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 keysSymbol(Symbol) */ && arguments0Value_ instanceof Symbol) {
                Symbol arguments0Value__ = (Symbol) arguments0Value_;
                return keysSymbol(arguments0Value__);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 keysString(JSLazyString) */ && arguments0Value_ instanceof JSLazyString) {
                JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                return keysString(arguments0Value__);
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 keysSafeInt(SafeInteger) */ && arguments0Value_ instanceof SafeInteger) {
                SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                return keysSafeInt(arguments0Value__);
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 keysBigInt(BigInt) */ && arguments0Value_ instanceof BigInt) {
                BigInt arguments0Value__ = (BigInt) arguments0Value_;
                return keysBigInt(arguments0Value__);
            }
            if ((state_0 & 0b11100000) != 0 /* is-state_0 keysOther(Object) || keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) || keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) */) {
                if ((state_0 & 0b100000) != 0 /* is-state_0 keysOther(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                        return keysOther(arguments0Value_);
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) */) {
                    KeysForeign0Data s6_ = this.keysForeign0_cache;
                    while (s6_ != null) {
                        if ((s6_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return keysForeign(arguments0Value_, s6_.interop_, s6_.members_, s6_.growProfile_, s6_.errorBranch_);
                        }
                        s6_ = s6_.next_;
                    }
                }
                if ((state_0 & 0b10000000) != 0 /* is-state_0 keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) */) {
                    KeysForeign1Data s7_ = this.keysForeign1_cache;
                    if (s7_ != null) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.keysForeign1Boundary(state_0, s7_, arguments0Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object keysForeign1Boundary(int state_0, KeysForeign1Data s7_, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return keysForeign(arguments0Value_, interop__, s7_.members_, s7_.growProfile_, s7_.errorBranch_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSDynamicObject(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 keysDynamicObject(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return keysDynamicObject(arguments0Value_);
                    }
                }
                if (arguments0Value instanceof Symbol) {
                    Symbol arguments0Value_ = (Symbol) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 keysSymbol(Symbol) */;
                    lock.unlock();
                    hasLock = false;
                    return keysSymbol(arguments0Value_);
                }
                if (arguments0Value instanceof JSLazyString) {
                    JSLazyString arguments0Value_ = (JSLazyString) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 keysString(JSLazyString) */;
                    lock.unlock();
                    hasLock = false;
                    return keysString(arguments0Value_);
                }
                if (arguments0Value instanceof SafeInteger) {
                    SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 keysSafeInt(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return keysSafeInt(arguments0Value_);
                }
                if (arguments0Value instanceof BigInt) {
                    BigInt arguments0Value_ = (BigInt) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 keysBigInt(BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return keysBigInt(arguments0Value_);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 keysOther(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return keysOther(arguments0Value);
                }
                if ((exclude) == 0 /* is-not-exclude keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) */) {
                    int count6_ = 0;
                    KeysForeign0Data s6_ = this.keysForeign0_cache;
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) */) {
                        while (s6_ != null) {
                            if ((s6_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                break;
                            }
                            s6_ = s6_.next_;
                            count6_++;
                        }
                    }
                    if (s6_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && count6_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s6_.interop_.accepts(arguments0Value));
                            s6_ = super.insert(new KeysForeign0Data(keysForeign0_cache));
                            s6_.interop_ = s6_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            s6_.members_ = s6_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                            s6_.growProfile_ = (BranchProfile.create());
                            s6_.errorBranch_ = (BranchProfile.create());
                            MemoryFence.storeStore();
                            this.keysForeign0_cache = s6_;
                            this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) */;
                        }
                    }
                    if (s6_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return keysForeign(arguments0Value, s6_.interop_, s6_.members_, s6_.growProfile_, s6_.errorBranch_);
                    }
                }
                {
                    InteropLibrary interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                KeysForeign1Data s7_ = super.insert(new KeysForeign1Data());
                                interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                s7_.members_ = s7_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                s7_.growProfile_ = (BranchProfile.create());
                                s7_.errorBranch_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.keysForeign1_cache = s7_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) */;
                                this.keysForeign0_cache = null;
                                state_0 = state_0 & 0xffffffbf /* remove-state_0 keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return keysForeign(arguments0Value, interop__, s7_.members_, s7_.growProfile_, s7_.errorBranch_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
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
                    KeysForeign0Data s6_ = this.keysForeign0_cache;
                    if ((s6_ == null || s6_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[9];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "keysDynamicObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 keysDynamicObject(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "keysSymbol";
            if ((state_0 & 0b10) != 0 /* is-state_0 keysSymbol(Symbol) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "keysString";
            if ((state_0 & 0b100) != 0 /* is-state_0 keysString(JSLazyString) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "keysSafeInt";
            if ((state_0 & 0b1000) != 0 /* is-state_0 keysSafeInt(SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "keysBigInt";
            if ((state_0 & 0b10000) != 0 /* is-state_0 keysBigInt(BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "keysOther";
            if ((state_0 & 0b100000) != 0 /* is-state_0 keysOther(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "keysForeign";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                KeysForeign0Data s6_ = this.keysForeign0_cache;
                while (s6_ != null) {
                    cached.add(Arrays.asList(s6_.interop_, s6_.members_, s6_.growProfile_, s6_.errorBranch_));
                    s6_ = s6_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "keysForeign";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                KeysForeign1Data s7_ = this.keysForeign1_cache;
                if (s7_ != null) {
                    cached.add(Arrays.asList(s7_.members_, s7_.growProfile_, s7_.errorBranch_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            return Provider.create(data);
        }

        public static ObjectKeysNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectKeysNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ObjectKeysNode.class)
        private static final class KeysForeign0Data extends Node {

            @Child KeysForeign0Data next_;
            @Child InteropLibrary interop_;
            @Child InteropLibrary members_;
            @CompilationFinal BranchProfile growProfile_;
            @CompilationFinal BranchProfile errorBranch_;

            KeysForeign0Data(KeysForeign0Data next_) {
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
        @GeneratedBy(ObjectKeysNode.class)
        private static final class KeysForeign1Data extends Node {

            @Child InteropLibrary members_;
            @CompilationFinal BranchProfile growProfile_;
            @CompilationFinal BranchProfile errorBranch_;

            KeysForeign1Data() {
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
    @GeneratedBy(ObjectSetPrototypeOfNode.class)
    public static final class ObjectSetPrototypeOfNodeGen extends ObjectSetPrototypeOfNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private ObjectSetPrototypeOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b11) != 0 /* is-state_0 setPrototypeOfJSObject(JSObject, JSDynamicObject) || setPrototypeOfJSObjectToInvalidNewProto(JSObject, Object) */ && arguments0Value_ instanceof JSObject) {
                JSObject arguments0Value__ = (JSObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 setPrototypeOfJSObject(JSObject, JSDynamicObject) */ && arguments1Value_ instanceof JSDynamicObject) {
                    JSDynamicObject arguments1Value__ = (JSDynamicObject) arguments1Value_;
                    if ((JSGuards.isValidPrototype(arguments1Value__))) {
                        return setPrototypeOfJSObject(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 setPrototypeOfJSObjectToInvalidNewProto(JSObject, Object) */) {
                    if ((!(JSGuards.isValidPrototype(arguments1Value_)))) {
                        return ObjectSetPrototypeOfNode.setPrototypeOfJSObjectToInvalidNewProto(arguments0Value__, arguments1Value_);
                    }
                }
            }
            if ((state_0 & 0b11100) != 0 /* is-state_0 setPrototypeOfNonObjectCoercible(Object, Object) || setPrototypeOfValue(Object, Object) || setPrototypeOfForeignObject(Object, Object) */) {
                if ((state_0 & 0b100) != 0 /* is-state_0 setPrototypeOfNonObjectCoercible(Object, Object) */) {
                    if ((JSGuards.isNullOrUndefined(arguments0Value_))) {
                        return setPrototypeOfNonObjectCoercible(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 setPrototypeOfValue(Object, Object) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isNullOrUndefined(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                        return ObjectSetPrototypeOfNode.setPrototypeOfValue(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 setPrototypeOfForeignObject(Object, Object) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return setPrototypeOfForeignObject(arguments0Value_, arguments1Value_);
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
            if (arguments0Value instanceof JSObject) {
                JSObject arguments0Value_ = (JSObject) arguments0Value;
                if (arguments1Value instanceof JSDynamicObject) {
                    JSDynamicObject arguments1Value_ = (JSDynamicObject) arguments1Value;
                    if ((JSGuards.isValidPrototype(arguments1Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 setPrototypeOfJSObject(JSObject, JSDynamicObject) */;
                        return setPrototypeOfJSObject(arguments0Value_, arguments1Value_);
                    }
                }
                if ((!(JSGuards.isValidPrototype(arguments1Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 setPrototypeOfJSObjectToInvalidNewProto(JSObject, Object) */;
                    return ObjectSetPrototypeOfNode.setPrototypeOfJSObjectToInvalidNewProto(arguments0Value_, arguments1Value);
                }
            }
            if ((JSGuards.isNullOrUndefined(arguments0Value))) {
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 setPrototypeOfNonObjectCoercible(Object, Object) */;
                return setPrototypeOfNonObjectCoercible(arguments0Value, arguments1Value);
            }
            if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isNullOrUndefined(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 setPrototypeOfValue(Object, Object) */;
                return ObjectSetPrototypeOfNode.setPrototypeOfValue(arguments0Value, arguments1Value);
            }
            if ((JSGuards.isForeignObject(arguments0Value))) {
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 setPrototypeOfForeignObject(Object, Object) */;
                return setPrototypeOfForeignObject(arguments0Value, arguments1Value);
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
            Object[] data = new Object[6];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "setPrototypeOfJSObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 setPrototypeOfJSObject(JSObject, JSDynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "setPrototypeOfJSObjectToInvalidNewProto";
            if ((state_0 & 0b10) != 0 /* is-state_0 setPrototypeOfJSObjectToInvalidNewProto(JSObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "setPrototypeOfNonObjectCoercible";
            if ((state_0 & 0b100) != 0 /* is-state_0 setPrototypeOfNonObjectCoercible(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "setPrototypeOfValue";
            if ((state_0 & 0b1000) != 0 /* is-state_0 setPrototypeOfValue(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "setPrototypeOfForeignObject";
            if ((state_0 & 0b10000) != 0 /* is-state_0 setPrototypeOfForeignObject(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static ObjectSetPrototypeOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectSetPrototypeOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectIsNode.class)
    public static final class ObjectIsNodeGen extends ObjectIsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSIdenticalNode isNumberNumber_doIdenticalNode_;
        @Child private JSIdenticalNode isObject_doIdenticalNode_;

        private ObjectIsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1110) == 0 /* only-active isInt(int, int) */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                return execute_int_int0(state_0, frameValue);
            } else if ((state_0 & 0b1101) == 0 /* only-active isDouble(double, double) */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                return execute_double_double1(state_0, frameValue);
            } else {
                return execute_generic2(state_0, frameValue);
            }
        }

        private Object execute_int_int0(int state_0, VirtualFrame frameValue) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return executeAndSpecialize(ex.getResult(), arguments1Value);
            }
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, ex.getResult());
            }
            assert (state_0 & 0b1) != 0 /* is-state_0 isInt(int, int) */;
            return isInt(arguments0Value_, arguments1Value_);
        }

        private Object execute_double_double1(int state_0, VirtualFrame frameValue) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state_0 & 0b10110000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return executeAndSpecialize(ex.getResult(), arguments1Value);
            }
            int arguments1Value_int = 0;
            long arguments1Value_long = 0L;
            double arguments1Value_;
            try {
                if ((state_0 & 0b111000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                    arguments1Value_long = this.arguments1_.executeLong(frameValue);
                    arguments1Value_ = JSTypes.longToDouble(arguments1Value_long);
                } else if ((state_0 & 0b110100000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                    arguments1Value_int = this.arguments1_.executeInt(frameValue);
                    arguments1Value_ = JSTypes.intToDouble(arguments1Value_int);
                } else if ((state_0 & 0b101100000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                    arguments1Value_ = this.arguments1_.executeDouble(frameValue);
                } else {
                    Object arguments1Value__ = this.arguments1_.execute(frameValue);
                    arguments1Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 1:double */, arguments1Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) ? (Object) arguments0Value_long : ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) ? (Object) arguments0Value_int : (Object) arguments0Value_)), ex.getResult());
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 isDouble(double, double) */;
            return isDouble(arguments0Value_, arguments1Value_);
        }

        private Object execute_generic2(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 isInt(int, int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                if (arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    return isInt(arguments0Value__, arguments1Value__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_);
                if (JSTypesGen.isImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 1:double */, arguments1Value_)) {
                    double arguments1Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 1:double */, arguments1Value_);
                    return isDouble(arguments0Value__, arguments1Value__);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 isNumberNumber(Number, Number, JSIdenticalNode) */ && arguments0Value_ instanceof Number) {
                Number arguments0Value__ = (Number) arguments0Value_;
                if (arguments1Value_ instanceof Number) {
                    Number arguments1Value__ = (Number) arguments1Value_;
                    if ((isNumberNumber(arguments0Value__, arguments1Value__))) {
                        return isNumberNumber(arguments0Value__, arguments1Value__, this.isNumberNumber_doIdenticalNode_);
                    }
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 isObject(Object, Object, JSIdenticalNode) */) {
                if ((!(isNumberNumber(arguments0Value_, arguments1Value_)))) {
                    return isObject(arguments0Value_, arguments1Value_, this.isObject_doIdenticalNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1110) == 0 /* only-active isInt(int, int) */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                return executeBoolean_int_int3(state_0, frameValue);
            } else if ((state_0 & 0b1101) == 0 /* only-active isDouble(double, double) */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                return executeBoolean_double_double4(state_0, frameValue);
            } else {
                return executeBoolean_generic5(state_0, frameValue);
            }
        }

        private boolean executeBoolean_int_int3(int state_0, VirtualFrame frameValue) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return executeAndSpecialize(ex.getResult(), arguments1Value);
            }
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, ex.getResult());
            }
            assert (state_0 & 0b1) != 0 /* is-state_0 isInt(int, int) */;
            return isInt(arguments0Value_, arguments1Value_);
        }

        private boolean executeBoolean_double_double4(int state_0, VirtualFrame frameValue) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state_0 & 0b10110000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return executeAndSpecialize(ex.getResult(), arguments1Value);
            }
            int arguments1Value_int = 0;
            long arguments1Value_long = 0L;
            double arguments1Value_;
            try {
                if ((state_0 & 0b111000000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                    arguments1Value_long = this.arguments1_.executeLong(frameValue);
                    arguments1Value_ = JSTypes.longToDouble(arguments1Value_long);
                } else if ((state_0 & 0b110100000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                    arguments1Value_int = this.arguments1_.executeInt(frameValue);
                    arguments1Value_ = JSTypes.intToDouble(arguments1Value_int);
                } else if ((state_0 & 0b101100000000) == 0 /* only-active 1:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */)) {
                    arguments1Value_ = this.arguments1_.executeDouble(frameValue);
                } else {
                    Object arguments1Value__ = this.arguments1_.execute(frameValue);
                    arguments1Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 1:double */, arguments1Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) ? (Object) arguments0Value_long : ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) ? (Object) arguments0Value_int : (Object) arguments0Value_)), ex.getResult());
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 isDouble(double, double) */;
            return isDouble(arguments0Value_, arguments1Value_);
        }

        private boolean executeBoolean_generic5(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 isInt(int, int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                if (arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    return isInt(arguments0Value__, arguments1Value__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isDouble(double, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_);
                if (JSTypesGen.isImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 1:double */, arguments1Value_)) {
                    double arguments1Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000000) >>> 8 /* extract-implicit-state_0 1:double */, arguments1Value_);
                    return isDouble(arguments0Value__, arguments1Value__);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 isNumberNumber(Number, Number, JSIdenticalNode) */ && arguments0Value_ instanceof Number) {
                Number arguments0Value__ = (Number) arguments0Value_;
                if (arguments1Value_ instanceof Number) {
                    Number arguments1Value__ = (Number) arguments1Value_;
                    if ((isNumberNumber(arguments0Value__, arguments1Value__))) {
                        return isNumberNumber(arguments0Value__, arguments1Value__, this.isNumberNumber_doIdenticalNode_);
                    }
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 isObject(Object, Object, JSIdenticalNode) */) {
                if ((!(isNumberNumber(arguments0Value_, arguments1Value_)))) {
                    return isObject(arguments0Value_, arguments1Value_, this.isObject_doIdenticalNode_);
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
                if (arguments0Value instanceof Integer) {
                    int arguments0Value_ = (int) arguments0Value;
                    if (arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 isInt(int, int) */;
                        lock.unlock();
                        hasLock = false;
                        return isInt(arguments0Value_, arguments1Value_);
                    }
                }
                {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                        double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                        int doubleCast1;
                        if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(arguments1Value)) != 0) {
                            double arguments1Value_ = JSTypesGen.asImplicitDouble(doubleCast1, arguments1Value);
                            state_0 = (state_0 | (doubleCast0 << 4) /* set-implicit-state_0 0:double */);
                            state_0 = (state_0 | (doubleCast1 << 8) /* set-implicit-state_0 1:double */);
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 isDouble(double, double) */;
                            lock.unlock();
                            hasLock = false;
                            return isDouble(arguments0Value_, arguments1Value_);
                        }
                    }
                }
                if (arguments0Value instanceof Number) {
                    Number arguments0Value_ = (Number) arguments0Value;
                    if (arguments1Value instanceof Number) {
                        Number arguments1Value_ = (Number) arguments1Value;
                        if ((isNumberNumber(arguments0Value_, arguments1Value_))) {
                            this.isNumberNumber_doIdenticalNode_ = super.insert((JSIdenticalNode.createSameValue()));
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 isNumberNumber(Number, Number, JSIdenticalNode) */;
                            lock.unlock();
                            hasLock = false;
                            return isNumberNumber(arguments0Value_, arguments1Value_, this.isNumberNumber_doIdenticalNode_);
                        }
                    }
                }
                if ((!(isNumberNumber(arguments0Value, arguments1Value)))) {
                    this.isObject_doIdenticalNode_ = super.insert((JSIdenticalNode.createSameValue()));
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 isObject(Object, Object, JSIdenticalNode) */;
                    lock.unlock();
                    hasLock = false;
                    return isObject(arguments0Value, arguments1Value, this.isObject_doIdenticalNode_);
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
            if ((state_0 & 0b1111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b1111) & ((state_0 & 0b1111) - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "isInt";
            if ((state_0 & 0b1) != 0 /* is-state_0 isInt(int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isDouble";
            if ((state_0 & 0b10) != 0 /* is-state_0 isDouble(double, double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "isNumberNumber";
            if ((state_0 & 0b100) != 0 /* is-state_0 isNumberNumber(Number, Number, JSIdenticalNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isNumberNumber_doIdenticalNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "isObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 isObject(Object, Object, JSIdenticalNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isObject_doIdenticalNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ObjectIsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectIsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectAssignNode.class)
    public static final class ObjectAssignNodeGen extends ObjectAssignNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private AssignData assign_cache;

        private ObjectAssignNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 assign(Object, Object[], JSToObjectNode, WriteElementNode, AssignPropertiesNode) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                AssignData s0_ = this.assign_cache;
                if (s0_ != null) {
                    return assign(arguments0Value_, arguments1Value__, s0_.toObjectNode_, s0_.write_, s0_.assignProperties_);
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
                if (arguments1Value instanceof Object[]) {
                    Object[] arguments1Value_ = (Object[]) arguments1Value;
                    AssignData s0_ = super.insert(new AssignData());
                    s0_.toObjectNode_ = s0_.insertAccessor((JSToObjectNode.createToObject(getContext())));
                    s0_.write_ = s0_.insertAccessor((WriteElementNode.create(getContext(), ObjectAssignNode.STRICT)));
                    s0_.assignProperties_ = s0_.insertAccessor((AssignPropertiesNodeGen.create(getContext())));
                    MemoryFence.storeStore();
                    this.assign_cache = s0_;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 assign(Object, Object[], JSToObjectNode, WriteElementNode, AssignPropertiesNode) */;
                    lock.unlock();
                    hasLock = false;
                    return assign(arguments0Value, arguments1Value_, s0_.toObjectNode_, s0_.write_, s0_.assignProperties_);
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
            s[0] = "assign";
            if (state_0 != 0 /* is-state_0 assign(Object, Object[], JSToObjectNode, WriteElementNode, AssignPropertiesNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                AssignData s0_ = this.assign_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.toObjectNode_, s0_.write_, s0_.assignProperties_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectAssignNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectAssignNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ObjectAssignNode.class)
        private static final class AssignData extends Node {

            @Child JSToObjectNode toObjectNode_;
            @Child WriteElementNode write_;
            @Child AssignPropertiesNode assignProperties_;

            AssignData() {
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
    @GeneratedBy(AssignPropertiesNode.class)
    static final class AssignPropertiesNodeGen extends AssignPropertiesNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private CopyPropertiesFromJSObjectData copyPropertiesFromJSObject_cache;
        @Child private Object0Data object0_cache;
        @Child private InteropLibrary object1_keysInterop_;
        @Child private InteropLibrary object1_stringInterop_;

        private AssignPropertiesNodeGen(JSContext context) {
            super(context);
        }

        @ExplodeLoop
        @Override
        void executeVoid(Object arg0Value, Object arg1Value, WriteElementNode arg2Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 copyPropertiesFromJSObject(Object, DynamicObject, WriteElementNode, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) || doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) || doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 copyPropertiesFromJSObject(Object, DynamicObject, WriteElementNode, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */ && JSTypes.isDynamicObject(arg1Value)) {
                    DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                    CopyPropertiesFromJSObjectData s0_ = this.copyPropertiesFromJSObject_cache;
                    if (s0_ != null) {
                        if ((JSGuards.isJSObject(arg1Value_))) {
                            AssignPropertiesNode.copyPropertiesFromJSObject(arg0Value, arg1Value_, arg2Value, s0_.read_, s0_.getOwnProperty_, s0_.listSize_, s0_.listGet_, s0_.classProfile_);
                            return;
                        }
                    }
                }
                if ((state_0 & 0b110) != 0 /* is-state_0 doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) || doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                        Object0Data s1_ = this.object0_cache;
                        while (s1_ != null) {
                            if ((s1_.fromInterop_.accepts(arg1Value)) && (!(JSGuards.isJSObject(arg1Value)))) {
                                doObject(arg0Value, arg1Value, arg2Value, s1_.fromInterop_, s1_.keysInterop_, s1_.stringInterop_);
                                return;
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                        if ((!(JSGuards.isJSObject(arg1Value)))) {
                            this.object1Boundary(state_0, arg0Value, arg1Value, arg2Value);
                            return;
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arg0Value, arg1Value, arg2Value);
            return;
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private void object1Boundary(int state_0, Object arg0Value, Object arg1Value, WriteElementNode arg2Value) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary object1_fromInterop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                    doObject(arg0Value, arg1Value, arg2Value, object1_fromInterop__, this.object1_keysInterop_, this.object1_stringInterop_);
                    return;
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        private void executeAndSpecialize(Object arg0Value, Object arg1Value, WriteElementNode arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arg1Value)) {
                    DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                    if ((JSGuards.isJSObject(arg1Value_))) {
                        CopyPropertiesFromJSObjectData s0_ = super.insert(new CopyPropertiesFromJSObjectData());
                        s0_.read_ = s0_.insertAccessor((ReadElementNode.create(context)));
                        s0_.getOwnProperty_ = s0_.insertAccessor((JSGetOwnPropertyNode.create(false)));
                        s0_.listSize_ = s0_.insertAccessor((ListSizeNode.create()));
                        s0_.listGet_ = s0_.insertAccessor((ListGetNode.create()));
                        s0_.classProfile_ = (JSClassProfile.create());
                        MemoryFence.storeStore();
                        this.copyPropertiesFromJSObject_cache = s0_;
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 copyPropertiesFromJSObject(Object, DynamicObject, WriteElementNode, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */;
                        lock.unlock();
                        hasLock = false;
                        AssignPropertiesNode.copyPropertiesFromJSObject(arg0Value, arg1Value_, arg2Value, s0_.read_, s0_.getOwnProperty_, s0_.listSize_, s0_.listGet_, s0_.classProfile_);
                        return;
                    }
                }
                if ((exclude) == 0 /* is-not-exclude doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                    int count1_ = 0;
                    Object0Data s1_ = this.object0_cache;
                    if ((state_0 & 0b10) != 0 /* is-state_0 doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.fromInterop_.accepts(arg1Value)) && (!(JSGuards.isJSObject(arg1Value)))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        if ((!(JSGuards.isJSObject(arg1Value))) && count1_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s1_.fromInterop_.accepts(arg1Value));
                            s1_ = super.insert(new Object0Data(object0_cache));
                            s1_.fromInterop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                            s1_.keysInterop_ = s1_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                            s1_.stringInterop_ = s1_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                            MemoryFence.storeStore();
                            this.object0_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        doObject(arg0Value, arg1Value, arg2Value, s1_.fromInterop_, s1_.keysInterop_, s1_.stringInterop_);
                        return;
                    }
                }
                {
                    InteropLibrary object1_fromInterop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((!(JSGuards.isJSObject(arg1Value)))) {
                                object1_fromInterop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.object1_keysInterop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                this.object1_stringInterop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */;
                                this.object0_cache = null;
                                state_0 = state_0 & 0xfffffffd /* remove-state_0 doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                doObject(arg0Value, arg1Value, arg2Value, object1_fromInterop__, this.object1_keysInterop_, this.object1_stringInterop_);
                                return;
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
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
                    Object0Data s1_ = this.object0_cache;
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
            s[0] = "copyPropertiesFromJSObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 copyPropertiesFromJSObject(Object, DynamicObject, WriteElementNode, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CopyPropertiesFromJSObjectData s0_ = this.copyPropertiesFromJSObject_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.read_, s0_.getOwnProperty_, s0_.listSize_, s0_.listGet_, s0_.classProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                Object0Data s1_ = this.object0_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.fromInterop_, s1_.keysInterop_, s1_.stringInterop_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object1_keysInterop_, this.object1_stringInterop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static AssignPropertiesNode create(JSContext context) {
            return new AssignPropertiesNodeGen(context);
        }

        @GeneratedBy(AssignPropertiesNode.class)
        private static final class CopyPropertiesFromJSObjectData extends Node {

            @Child ReadElementNode read_;
            @Child JSGetOwnPropertyNode getOwnProperty_;
            @Child ListSizeNode listSize_;
            @Child ListGetNode listGet_;
            @CompilationFinal JSClassProfile classProfile_;

            CopyPropertiesFromJSObjectData() {
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
        @GeneratedBy(AssignPropertiesNode.class)
        private static final class Object0Data extends Node {

            @Child Object0Data next_;
            @Child InteropLibrary fromInterop_;
            @Child InteropLibrary keysInterop_;
            @Child InteropLibrary stringInterop_;

            Object0Data(Object0Data next_) {
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
    @GeneratedBy(ObjectValuesOrEntriesNode.class)
    public static final class ObjectValuesOrEntriesNodeGen extends ObjectValuesOrEntriesNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private ConditionProfile valuesOrEntriesJSObject_lengthZero_;
        @Child private EnumerableOwnPropertyNamesForeign0Data enumerableOwnPropertyNamesForeign0_cache;
        @Child private EnumerableOwnPropertyNamesForeign1Data enumerableOwnPropertyNamesForeign1_cache;
        @Child private ObjectValuesOrEntriesNode valuesOrEntriesGeneric_recursive_;

        private ObjectValuesOrEntriesNodeGen(JSContext context, JSBuiltin builtin, boolean entries, JavaScriptNode[] arguments) {
            super(context, builtin, entries);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @ExplodeLoop
        @Override
        protected DynamicObject executeEvaluated(Object arguments0Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 valuesOrEntriesJSObject(DynamicObject, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSObject(arguments0Value_))) {
                    return valuesOrEntriesJSObject(arguments0Value_, this.valuesOrEntriesJSObject_lengthZero_);
                }
            }
            if ((state_0 & 0b1110) != 0 /* is-state_0 enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) || enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) || valuesOrEntriesGeneric(Object, ObjectValuesOrEntriesNode) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */) {
                    EnumerableOwnPropertyNamesForeign0Data s1_ = this.enumerableOwnPropertyNamesForeign0_cache;
                    while (s1_ != null) {
                        if ((s1_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                            return enumerableOwnPropertyNamesForeign(arguments0Value, s1_.interop_, s1_.members_, s1_.importValue_, s1_.growProfile_, s1_.errorBranch_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */) {
                    EnumerableOwnPropertyNamesForeign1Data s2_ = this.enumerableOwnPropertyNamesForeign1_cache;
                    if (s2_ != null) {
                        if ((JSGuards.isForeignObject(arguments0Value))) {
                            return this.enumerableOwnPropertyNamesForeign1Boundary(state_0, s2_, arguments0Value);
                        }
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 valuesOrEntriesGeneric(Object, ObjectValuesOrEntriesNode) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                        return valuesOrEntriesGeneric(arguments0Value, this.valuesOrEntriesGeneric_recursive_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private DynamicObject enumerableOwnPropertyNamesForeign1Boundary(int state_0, EnumerableOwnPropertyNamesForeign1Data s2_, Object arguments0Value) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                    return enumerableOwnPropertyNamesForeign(arguments0Value, interop__, s2_.members_, s2_.importValue_, s2_.growProfile_, s2_.errorBranch_);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 valuesOrEntriesJSObject(DynamicObject, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return valuesOrEntriesJSObject(arguments0Value__, this.valuesOrEntriesJSObject_lengthZero_);
                }
            }
            if ((state_0 & 0b1110) != 0 /* is-state_0 enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) || enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) || valuesOrEntriesGeneric(Object, ObjectValuesOrEntriesNode) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */) {
                    EnumerableOwnPropertyNamesForeign0Data s1_ = this.enumerableOwnPropertyNamesForeign0_cache;
                    while (s1_ != null) {
                        if ((s1_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return enumerableOwnPropertyNamesForeign(arguments0Value_, s1_.interop_, s1_.members_, s1_.importValue_, s1_.growProfile_, s1_.errorBranch_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */) {
                    EnumerableOwnPropertyNamesForeign1Data s2_ = this.enumerableOwnPropertyNamesForeign1_cache;
                    if (s2_ != null) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.enumerableOwnPropertyNamesForeign1Boundary0(state_0, s2_, arguments0Value_);
                        }
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 valuesOrEntriesGeneric(Object, ObjectValuesOrEntriesNode) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                        return valuesOrEntriesGeneric(arguments0Value_, this.valuesOrEntriesGeneric_recursive_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object enumerableOwnPropertyNamesForeign1Boundary0(int state_0, EnumerableOwnPropertyNamesForeign1Data s2_, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return enumerableOwnPropertyNamesForeign(arguments0Value_, interop__, s2_.members_, s2_.importValue_, s2_.growProfile_, s2_.errorBranch_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.valuesOrEntriesJSObject_lengthZero_ = (ConditionProfile.createBinaryProfile());
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 valuesOrEntriesJSObject(DynamicObject, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return valuesOrEntriesJSObject(arguments0Value_, this.valuesOrEntriesJSObject_lengthZero_);
                    }
                }
                if ((exclude) == 0 /* is-not-exclude enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */) {
                    int count1_ = 0;
                    EnumerableOwnPropertyNamesForeign0Data s1_ = this.enumerableOwnPropertyNamesForeign0_cache;
                    if ((state_0 & 0b10) != 0 /* is-state_0 enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */) {
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
                            s1_ = super.insert(new EnumerableOwnPropertyNamesForeign0Data(enumerableOwnPropertyNamesForeign0_cache));
                            s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            s1_.members_ = s1_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                            s1_.importValue_ = s1_.insertAccessor((ImportValueNode.create()));
                            s1_.growProfile_ = (BranchProfile.create());
                            s1_.errorBranch_ = (BranchProfile.create());
                            MemoryFence.storeStore();
                            this.enumerableOwnPropertyNamesForeign0_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return enumerableOwnPropertyNamesForeign(arguments0Value, s1_.interop_, s1_.members_, s1_.importValue_, s1_.growProfile_, s1_.errorBranch_);
                    }
                }
                {
                    InteropLibrary interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                EnumerableOwnPropertyNamesForeign1Data s2_ = super.insert(new EnumerableOwnPropertyNamesForeign1Data());
                                interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                s2_.members_ = s2_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                s2_.importValue_ = s2_.insertAccessor((ImportValueNode.create()));
                                s2_.growProfile_ = (BranchProfile.create());
                                s2_.errorBranch_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.enumerableOwnPropertyNamesForeign1_cache = s2_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */;
                                this.enumerableOwnPropertyNamesForeign0_cache = null;
                                state_0 = state_0 & 0xfffffffd /* remove-state_0 enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return enumerableOwnPropertyNamesForeign(arguments0Value, interop__, s2_.members_, s2_.importValue_, s2_.growProfile_, s2_.errorBranch_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.valuesOrEntriesGeneric_recursive_ = super.insert((createRecursive()));
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 valuesOrEntriesGeneric(Object, ObjectValuesOrEntriesNode) */;
                    lock.unlock();
                    hasLock = false;
                    return valuesOrEntriesGeneric(arguments0Value, this.valuesOrEntriesGeneric_recursive_);
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
                    EnumerableOwnPropertyNamesForeign0Data s1_ = this.enumerableOwnPropertyNamesForeign0_cache;
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
            s[0] = "valuesOrEntriesJSObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 valuesOrEntriesJSObject(DynamicObject, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.valuesOrEntriesJSObject_lengthZero_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "enumerableOwnPropertyNamesForeign";
            if ((state_0 & 0b10) != 0 /* is-state_0 enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                EnumerableOwnPropertyNamesForeign0Data s1_ = this.enumerableOwnPropertyNamesForeign0_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.interop_, s1_.members_, s1_.importValue_, s1_.growProfile_, s1_.errorBranch_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "enumerableOwnPropertyNamesForeign";
            if ((state_0 & 0b100) != 0 /* is-state_0 enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                EnumerableOwnPropertyNamesForeign1Data s2_ = this.enumerableOwnPropertyNamesForeign1_cache;
                if (s2_ != null) {
                    cached.add(Arrays.asList(s2_.members_, s2_.importValue_, s2_.growProfile_, s2_.errorBranch_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "valuesOrEntriesGeneric";
            if ((state_0 & 0b1000) != 0 /* is-state_0 valuesOrEntriesGeneric(Object, ObjectValuesOrEntriesNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.valuesOrEntriesGeneric_recursive_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ObjectValuesOrEntriesNode create(JSContext context, JSBuiltin builtin, boolean entries, JavaScriptNode[] arguments) {
            return new ObjectValuesOrEntriesNodeGen(context, builtin, entries, arguments);
        }

        @GeneratedBy(ObjectValuesOrEntriesNode.class)
        private static final class EnumerableOwnPropertyNamesForeign0Data extends Node {

            @Child EnumerableOwnPropertyNamesForeign0Data next_;
            @Child InteropLibrary interop_;
            @Child InteropLibrary members_;
            @Child ImportValueNode importValue_;
            @CompilationFinal BranchProfile growProfile_;
            @CompilationFinal BranchProfile errorBranch_;

            EnumerableOwnPropertyNamesForeign0Data(EnumerableOwnPropertyNamesForeign0Data next_) {
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
        @GeneratedBy(ObjectValuesOrEntriesNode.class)
        private static final class EnumerableOwnPropertyNamesForeign1Data extends Node {

            @Child InteropLibrary members_;
            @Child ImportValueNode importValue_;
            @CompilationFinal BranchProfile growProfile_;
            @CompilationFinal BranchProfile errorBranch_;

            EnumerableOwnPropertyNamesForeign1Data() {
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
    @GeneratedBy(ObjectFromEntriesNode.class)
    public static final class ObjectFromEntriesNodeGen extends ObjectFromEntriesNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private ObjectFromEntriesNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return entries(arguments0Value_);
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
            s[0] = "entries";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectFromEntriesNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectFromEntriesNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectBindPropertiesNode.class)
    public static final class ObjectBindPropertiesNodeGen extends ObjectBindPropertiesNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private BindProperties5Data bindProperties5_cache;
        @Child private InteropLibrary bindProperties6_members_;

        private ObjectBindPropertiesNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 bindPropertiesInvalidTarget(Object, Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return bindPropertiesInvalidTarget(arguments0Value_, arguments1Value_);
                }
            }
            if ((state_0 & 0b111111110) != 0 /* is-state_0 bindPropertiesDynamicObject(DynamicObject, DynamicObject) || bindProperties(DynamicObject, Symbol) || bindProperties(DynamicObject, JSLazyString) || bindProperties(DynamicObject, SafeInteger) || bindProperties(DynamicObject, BigInt) || bindProperties(DynamicObject, Object) || bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) || bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b10) != 0 /* is-state_0 bindPropertiesDynamicObject(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isJSDynamicObject(arguments1Value__))) {
                        return bindPropertiesDynamicObject(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 bindProperties(DynamicObject, Symbol) */ && arguments1Value_ instanceof Symbol) {
                    Symbol arguments1Value__ = (Symbol) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return bindProperties(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 bindProperties(DynamicObject, JSLazyString) */ && arguments1Value_ instanceof JSLazyString) {
                    JSLazyString arguments1Value__ = (JSLazyString) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return bindProperties(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 bindProperties(DynamicObject, SafeInteger) */ && arguments1Value_ instanceof SafeInteger) {
                    SafeInteger arguments1Value__ = (SafeInteger) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return bindProperties(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 bindProperties(DynamicObject, BigInt) */ && arguments1Value_ instanceof BigInt) {
                    BigInt arguments1Value__ = (BigInt) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return bindProperties(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b111000000) != 0 /* is-state_0 bindProperties(DynamicObject, Object) || bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) || bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 bindProperties(DynamicObject, Object) */) {
                        if ((JSGuards.isJSObject(arguments0Value__)) && (!(JSGuards.isTruffleObject(arguments1Value_)))) {
                            return bindProperties(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                        BindProperties5Data s7_ = this.bindProperties5_cache;
                        while (s7_ != null) {
                            if ((s7_.interop_.accepts(arguments1Value_)) && (JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isForeignObject(arguments1Value_))) {
                                return bindProperties(arguments0Value__, arguments1Value_, s7_.interop_, s7_.members_);
                            }
                            s7_ = s7_.next_;
                        }
                    }
                    if ((state_0 & 0b100000000) != 0 /* is-state_0 bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                        if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isForeignObject(arguments1Value_))) {
                            return this.bindProperties6Boundary(state_0, arguments0Value__, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object bindProperties6Boundary(int state_0, DynamicObject arguments0Value__, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary bindProperties6_interop__ = (INTEROP_LIBRARY_.getUncached(arguments1Value_));
                    return bindProperties(arguments0Value__, arguments1Value_, bindProperties6_interop__, this.bindProperties6_members_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((!(JSGuards.isJSObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 bindPropertiesInvalidTarget(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return bindPropertiesInvalidTarget(arguments0Value, arguments1Value);
                }
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (JSTypes.isDynamicObject(arguments1Value)) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isJSDynamicObject(arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 bindPropertiesDynamicObject(DynamicObject, DynamicObject) */;
                            lock.unlock();
                            hasLock = false;
                            return bindPropertiesDynamicObject(arguments0Value_, arguments1Value_);
                        }
                    }
                    if (arguments1Value instanceof Symbol) {
                        Symbol arguments1Value_ = (Symbol) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 bindProperties(DynamicObject, Symbol) */;
                            lock.unlock();
                            hasLock = false;
                            return bindProperties(arguments0Value_, arguments1Value_);
                        }
                    }
                    if (arguments1Value instanceof JSLazyString) {
                        JSLazyString arguments1Value_ = (JSLazyString) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 bindProperties(DynamicObject, JSLazyString) */;
                            lock.unlock();
                            hasLock = false;
                            return bindProperties(arguments0Value_, arguments1Value_);
                        }
                    }
                    if (arguments1Value instanceof SafeInteger) {
                        SafeInteger arguments1Value_ = (SafeInteger) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 bindProperties(DynamicObject, SafeInteger) */;
                            lock.unlock();
                            hasLock = false;
                            return bindProperties(arguments0Value_, arguments1Value_);
                        }
                    }
                    if (arguments1Value instanceof BigInt) {
                        BigInt arguments1Value_ = (BigInt) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 bindProperties(DynamicObject, BigInt) */;
                            lock.unlock();
                            hasLock = false;
                            return bindProperties(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((JSGuards.isJSObject(arguments0Value_)) && (!(JSGuards.isTruffleObject(arguments1Value)))) {
                        this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 bindProperties(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return bindProperties(arguments0Value_, arguments1Value);
                    }
                    if ((exclude) == 0 /* is-not-exclude bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                        int count7_ = 0;
                        BindProperties5Data s7_ = this.bindProperties5_cache;
                        if ((state_0 & 0b10000000) != 0 /* is-state_0 bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                            while (s7_ != null) {
                                if ((s7_.interop_.accepts(arguments1Value)) && (JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isForeignObject(arguments1Value))) {
                                    break;
                                }
                                s7_ = s7_.next_;
                                count7_++;
                            }
                        }
                        if (s7_ == null) {
                            if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isForeignObject(arguments1Value)) && count7_ < (JSConfig.InteropLibraryLimit)) {
                                // assert (s7_.interop_.accepts(arguments1Value));
                                s7_ = super.insert(new BindProperties5Data(bindProperties5_cache));
                                s7_.interop_ = s7_.insertAccessor((INTEROP_LIBRARY_.create(arguments1Value)));
                                s7_.members_ = s7_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                MemoryFence.storeStore();
                                this.bindProperties5_cache = s7_;
                                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */;
                            }
                        }
                        if (s7_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return bindProperties(arguments0Value_, arguments1Value, s7_.interop_, s7_.members_);
                        }
                    }
                    {
                        InteropLibrary bindProperties6_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isForeignObject(arguments1Value))) {
                                    bindProperties6_interop__ = (INTEROP_LIBRARY_.getUncached(arguments1Value));
                                    this.bindProperties6_members_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */;
                                    this.bindProperties5_cache = null;
                                    state_0 = state_0 & 0xffffff7f /* remove-state_0 bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */;
                                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return bindProperties(arguments0Value_, arguments1Value, bindProperties6_interop__, this.bindProperties6_members_);
                                }
                            } finally {
                                encapsulating_.set(prev_);
                            }
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
                    BindProperties5Data s7_ = this.bindProperties5_cache;
                    if ((s7_ == null || s7_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[10];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "bindPropertiesInvalidTarget";
            if ((state_0 & 0b1) != 0 /* is-state_0 bindPropertiesInvalidTarget(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "bindPropertiesDynamicObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 bindPropertiesDynamicObject(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state_0 & 0b100) != 0 /* is-state_0 bindProperties(DynamicObject, Symbol) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state_0 & 0b1000) != 0 /* is-state_0 bindProperties(DynamicObject, JSLazyString) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state_0 & 0b10000) != 0 /* is-state_0 bindProperties(DynamicObject, SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state_0 & 0b100000) != 0 /* is-state_0 bindProperties(DynamicObject, BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 bindProperties(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                BindProperties5Data s7_ = this.bindProperties5_cache;
                while (s7_ != null) {
                    cached.add(Arrays.asList(s7_.interop_, s7_.members_));
                    s7_ = s7_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state_0 & 0b100000000) != 0 /* is-state_0 bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.bindProperties6_members_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            return Provider.create(data);
        }

        public static ObjectBindPropertiesNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectBindPropertiesNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ObjectBindPropertiesNode.class)
        private static final class BindProperties5Data extends Node {

            @Child BindProperties5Data next_;
            @Child InteropLibrary interop_;
            @Child InteropLibrary members_;

            BindProperties5Data(BindProperties5Data next_) {
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
    @GeneratedBy(ObjectHasOwnNode.class)
    public static final class ObjectHasOwnNodeGen extends ObjectHasOwnNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private ObjectHasOwnNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return hasOwn(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return hasOwn(arguments0Value_, arguments1Value_);
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
            s[0] = "hasOwn";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectHasOwnNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectHasOwnNodeGen(context, builtin, arguments);
        }

    }
}
