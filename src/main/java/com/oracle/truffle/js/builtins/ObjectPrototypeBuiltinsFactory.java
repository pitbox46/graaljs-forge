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
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.FormatCacheNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.GetBuiltinToStringTagNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeDefineGetterOrSetterNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeHasOwnPropertyNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeIsPrototypeOfNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeLookupGetterOrSetterNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypePropertyIsEnumerableNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeToLocaleStringNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeToStringNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeValueOfNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ObjectPrototypeBuiltins.class)
@SuppressWarnings("unused")
public final class ObjectPrototypeBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(ObjectPrototypeValueOfNode.class)
    public static final class ObjectPrototypeValueOfNodeGen extends ObjectPrototypeValueOfNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private InteropLibrary valueOfForeign_interop_;

        private ObjectPrototypeValueOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 valueOfJSObject(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSDynamicObject(arguments0Value__))) {
                    return valueOfJSObject(arguments0Value__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 valueOfSymbol(Symbol) */ && arguments0Value_ instanceof Symbol) {
                Symbol arguments0Value__ = (Symbol) arguments0Value_;
                return valueOfSymbol(arguments0Value__);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 valueOfLazyString(JSLazyString) */ && arguments0Value_ instanceof JSLazyString) {
                JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                return valueOfLazyString(arguments0Value__);
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 valueOfSafeInteger(SafeInteger) */ && arguments0Value_ instanceof SafeInteger) {
                SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                return valueOfSafeInteger(arguments0Value__);
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 valueOfBigInt(BigInt) */ && arguments0Value_ instanceof BigInt) {
                BigInt arguments0Value__ = (BigInt) arguments0Value_;
                return valueOfBigInt(arguments0Value__);
            }
            if ((state_0 & 0b1100000) != 0 /* is-state_0 valueOfOther(Object) || valueOfForeign(Object, InteropLibrary) */) {
                if ((state_0 & 0b100000) != 0 /* is-state_0 valueOfOther(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                        return valueOfOther(arguments0Value_);
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 valueOfForeign(Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return valueOfForeign(arguments0Value_, this.valueOfForeign_interop_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSDynamicObject(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 valueOfJSObject(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return valueOfJSObject(arguments0Value_);
                    }
                }
                if (arguments0Value instanceof Symbol) {
                    Symbol arguments0Value_ = (Symbol) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 valueOfSymbol(Symbol) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfSymbol(arguments0Value_);
                }
                if (arguments0Value instanceof JSLazyString) {
                    JSLazyString arguments0Value_ = (JSLazyString) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 valueOfLazyString(JSLazyString) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfLazyString(arguments0Value_);
                }
                if (arguments0Value instanceof SafeInteger) {
                    SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 valueOfSafeInteger(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfSafeInteger(arguments0Value_);
                }
                if (arguments0Value instanceof BigInt) {
                    BigInt arguments0Value_ = (BigInt) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 valueOfBigInt(BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfBigInt(arguments0Value_);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 valueOfOther(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfOther(arguments0Value);
                }
                if ((JSGuards.isForeignObject(arguments0Value))) {
                    this.valueOfForeign_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 valueOfForeign(Object, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfForeign(arguments0Value, this.valueOfForeign_interop_);
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
            Object[] data = new Object[8];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "valueOfJSObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 valueOfJSObject(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "valueOfSymbol";
            if ((state_0 & 0b10) != 0 /* is-state_0 valueOfSymbol(Symbol) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "valueOfLazyString";
            if ((state_0 & 0b100) != 0 /* is-state_0 valueOfLazyString(JSLazyString) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "valueOfSafeInteger";
            if ((state_0 & 0b1000) != 0 /* is-state_0 valueOfSafeInteger(SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "valueOfBigInt";
            if ((state_0 & 0b10000) != 0 /* is-state_0 valueOfBigInt(BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "valueOfOther";
            if ((state_0 & 0b100000) != 0 /* is-state_0 valueOfOther(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "valueOfForeign";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 valueOfForeign(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.valueOfForeign_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeValueOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPrototypeValueOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectPrototypeToStringNode.class)
    public static final class ObjectPrototypeToStringNodeGen extends ObjectPrototypeToStringNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private GetBuiltinToStringTagNode builtinTag;
        @Child private InteropLibrary foreignObject0_interop_;

        private ObjectPrototypeToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b11) != 0 /* is-state_0 doJSObject(DynamicObject, GetBuiltinToStringTagNode) || doJSProxy(DynamicObject, GetBuiltinToStringTagNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doJSObject(DynamicObject, GetBuiltinToStringTagNode) */) {
                    if ((JSGuards.isJSObject(arguments0Value__)) && (!(JSGuards.isJSProxy(arguments0Value__)))) {
                        return doJSObject(arguments0Value__, this.builtinTag);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doJSProxy(DynamicObject, GetBuiltinToStringTagNode) */) {
                    if ((JSGuards.isJSProxy(arguments0Value__))) {
                        return doJSProxy(arguments0Value__, this.builtinTag);
                    }
                }
            }
            if ((state_0 & 0b111100) != 0 /* is-state_0 doNull(Object) || doUndefined(Object) || doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
                if ((state_0 & 0b100) != 0 /* is-state_0 doNull(Object) */) {
                    if ((JSGuards.isJSNull(arguments0Value_))) {
                        return doNull(arguments0Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doUndefined(Object) */) {
                    if ((JSGuards.isUndefined(arguments0Value_))) {
                        return doUndefined(arguments0Value_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                    if ((this.foreignObject0_interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                        return doForeignObject(arguments0Value_, this.foreignObject0_interop_);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return this.foreignObject1Boundary(state_0, arguments0Value_);
                    }
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doSymbol(Symbol) */ && arguments0Value_ instanceof Symbol) {
                Symbol arguments0Value__ = (Symbol) arguments0Value_;
                return doSymbol(arguments0Value__);
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doLazyString(JSLazyString) */ && arguments0Value_ instanceof JSLazyString) {
                JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                return doLazyString(arguments0Value__);
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && arguments0Value_ instanceof SafeInteger) {
                SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                return doSafeInteger(arguments0Value__);
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doBigInt(BigInt) */ && arguments0Value_ instanceof BigInt) {
                BigInt arguments0Value__ = (BigInt) arguments0Value_;
                return doBigInt(arguments0Value__);
            }
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doObject(Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return doObject(arguments0Value_);
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

        private String executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_)) && (!(JSGuards.isJSProxy(arguments0Value_)))) {
                        this.builtinTag = super.insert(this.builtinTag == null ? ((GetBuiltinToStringTagNode.create())) : this.builtinTag);
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doJSObject(DynamicObject, GetBuiltinToStringTagNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doJSObject(arguments0Value_, this.builtinTag);
                    }
                    if ((JSGuards.isJSProxy(arguments0Value_))) {
                        this.builtinTag = super.insert(this.builtinTag == null ? ((GetBuiltinToStringTagNode.create())) : this.builtinTag);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doJSProxy(DynamicObject, GetBuiltinToStringTagNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doJSProxy(arguments0Value_, this.builtinTag);
                    }
                }
                if ((JSGuards.isJSNull(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doNull(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNull(arguments0Value);
                }
                if ((JSGuards.isUndefined(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doUndefined(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doUndefined(arguments0Value);
                }
                if ((exclude) == 0 /* is-not-exclude doForeignObject(Object, InteropLibrary) */) {
                    boolean ForeignObject0_duplicateFound_ = false;
                    if ((state_0 & 0b10000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                        if ((this.foreignObject0_interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                            ForeignObject0_duplicateFound_ = true;
                        }
                    }
                    if (!ForeignObject0_duplicateFound_) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && ((state_0 & 0b10000)) == 0 /* is-not-state_0 doForeignObject(Object, InteropLibrary) */) {
                            // assert (this.foreignObject0_interop_.accepts(arguments0Value));
                            this.foreignObject0_interop_ = super.insert((INTEROP_LIBRARY_.create(arguments0Value)));
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doForeignObject(Object, InteropLibrary) */;
                            ForeignObject0_duplicateFound_ = true;
                        }
                    }
                    if (ForeignObject0_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return doForeignObject(arguments0Value, this.foreignObject0_interop_);
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
                                state_0 = state_0 & 0xffffffef /* remove-state_0 doForeignObject(Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doForeignObject(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return doForeignObject(arguments0Value, foreignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if (arguments0Value instanceof Symbol) {
                    Symbol arguments0Value_ = (Symbol) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doSymbol(Symbol) */;
                    lock.unlock();
                    hasLock = false;
                    return doSymbol(arguments0Value_);
                }
                if (arguments0Value instanceof JSLazyString) {
                    JSLazyString arguments0Value_ = (JSLazyString) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doLazyString(JSLazyString) */;
                    lock.unlock();
                    hasLock = false;
                    return doLazyString(arguments0Value_);
                }
                if (arguments0Value instanceof SafeInteger) {
                    SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doSafeInteger(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(arguments0Value_);
                }
                if (arguments0Value instanceof BigInt) {
                    BigInt arguments0Value_ = (BigInt) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doBigInt(BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigInt(arguments0Value_);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doObject(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doObject(arguments0Value);
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
            Object[] data = new Object[12];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "doJSObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 doJSObject(DynamicObject, GetBuiltinToStringTagNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.builtinTag));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doJSProxy";
            if ((state_0 & 0b10) != 0 /* is-state_0 doJSProxy(DynamicObject, GetBuiltinToStringTagNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.builtinTag));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doNull";
            if ((state_0 & 0b100) != 0 /* is-state_0 doNull(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doUndefined";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doUndefined(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state_0 & 0b10000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.foreignObject0_interop_));
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state_0 & 0b100000) != 0 /* is-state_0 doForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "doSymbol";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doSymbol(Symbol) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "doLazyString";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doLazyString(JSLazyString) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "doSafeInteger";
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doSafeInteger(SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            s = new Object[3];
            s[0] = "doBigInt";
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doBigInt(BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[10] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[11] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPrototypeToStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(GetBuiltinToStringTagNode.class)
    public static final class GetBuiltinToStringTagNodeGen extends GetBuiltinToStringTagNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private GetBuiltinToStringTagNodeGen() {
        }

        @ExplodeLoop
        @Override
        public String execute(Object arg0Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 cached(DynamicObject, JSClass) || uncached(DynamicObject) || foreign(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((state_0 & 0b1) != 0 /* is-state_0 cached(DynamicObject, JSClass) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        assert (s0_.cachedClass_ != null);
                        if ((s0_.cachedClass_.isInstance(arg0Value_))) {
                            return GetBuiltinToStringTagNode.cached(arg0Value_, s0_.cachedClass_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 uncached(DynamicObject) */) {
                    if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                        return GetBuiltinToStringTagNode.uncached(arg0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 foreign(DynamicObject) */) {
                    if ((!(JSGuards.isJSDynamicObject(arg0Value_)))) {
                        return GetBuiltinToStringTagNode.foreign(arg0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private String executeAndSpecialize(Object arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arg0Value)) {
                    DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                    if ((exclude) == 0 /* is-not-exclude cached(DynamicObject, JSClass) */) {
                        int count0_ = 0;
                        CachedData s0_ = this.cached_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 cached(DynamicObject, JSClass) */) {
                            while (s0_ != null) {
                                assert (s0_.cachedClass_ != null);
                                if ((s0_.cachedClass_.isInstance(arg0Value_))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                JSClass cachedClass__ = (JSGuards.getJSClassChecked(arg0Value_));
                                if ((cachedClass__ != null) && (cachedClass__.isInstance(arg0Value_)) && count0_ < (5)) {
                                    s0_ = new CachedData(cached_cache);
                                    s0_.cachedClass_ = cachedClass__;
                                    MemoryFence.storeStore();
                                    this.cached_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 cached(DynamicObject, JSClass) */;
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetBuiltinToStringTagNode.cached(arg0Value_, s0_.cachedClass_);
                        }
                    }
                    if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude cached(DynamicObject, JSClass) */;
                        this.cached_cache = null;
                        state_0 = state_0 & 0xfffffffe /* remove-state_0 cached(DynamicObject, JSClass) */;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 uncached(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return GetBuiltinToStringTagNode.uncached(arg0Value_);
                    }
                    if ((!(JSGuards.isJSDynamicObject(arg0Value_)))) {
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 foreign(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return GetBuiltinToStringTagNode.foreign(arg0Value_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
                    CachedData s0_ = this.cached_cache;
                    if ((s0_ == null || s0_.next_ == null)) {
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
            s[0] = "cached";
            if ((state_0 & 0b1) != 0 /* is-state_0 cached(DynamicObject, JSClass) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.cachedClass_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude cached(DynamicObject, JSClass) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "uncached";
            if ((state_0 & 0b10) != 0 /* is-state_0 uncached(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "foreign";
            if ((state_0 & 0b100) != 0 /* is-state_0 foreign(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static GetBuiltinToStringTagNode create() {
            return new GetBuiltinToStringTagNodeGen();
        }

        @GeneratedBy(GetBuiltinToStringTagNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal JSClass cachedClass_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
    @GeneratedBy(FormatCacheNode.class)
    public static final class FormatCacheNodeGen extends FormatCacheNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private ExecuteCachedData executeCached_cache;

        private FormatCacheNodeGen() {
        }

        @ExplodeLoop
        @Override
        public String execute(String arg0Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b11) != 0 /* is-state_0 executeCached(String, String, String) || executeUncached(String) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 executeCached(String, String, String) */) {
                    ExecuteCachedData s0_ = this.executeCached_cache;
                    while (s0_ != null) {
                        if ((s0_.cachedName_.equals(arg0Value))) {
                            return executeCached(arg0Value, s0_.cachedName_, s0_.cachedResult_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 executeUncached(String) */) {
                    return executeUncached(arg0Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private String executeAndSpecialize(String arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int count0_ = 0;
                ExecuteCachedData s0_ = this.executeCached_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 executeCached(String, String, String) */) {
                    while (s0_ != null) {
                        if ((s0_.cachedName_.equals(arg0Value))) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    // assert (s0_.cachedName_.equals(arg0Value));
                    if (count0_ < (10)) {
                        s0_ = new ExecuteCachedData(executeCached_cache);
                        s0_.cachedName_ = (arg0Value);
                        s0_.cachedResult_ = (executeUncached(arg0Value));
                        MemoryFence.storeStore();
                        this.executeCached_cache = s0_;
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 executeCached(String, String, String) */;
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return executeCached(arg0Value, s0_.cachedName_, s0_.cachedResult_);
                }
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 executeUncached(String) */;
                lock.unlock();
                hasLock = false;
                return executeUncached(arg0Value);
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
                    ExecuteCachedData s0_ = this.executeCached_cache;
                    if ((s0_ == null || s0_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
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
            s[0] = "executeCached";
            if ((state_0 & 0b1) != 0 /* is-state_0 executeCached(String, String, String) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ExecuteCachedData s0_ = this.executeCached_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.cachedName_, s0_.cachedResult_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "executeUncached";
            if ((state_0 & 0b10) != 0 /* is-state_0 executeUncached(String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static FormatCacheNode create() {
            return new FormatCacheNodeGen();
        }

        @GeneratedBy(FormatCacheNode.class)
        private static final class ExecuteCachedData {

            @CompilationFinal ExecuteCachedData next_;
            @CompilationFinal String cachedName_;
            @CompilationFinal String cachedResult_;

            ExecuteCachedData(ExecuteCachedData next_) {
                this.next_ = next_;
            }

        }
    }
    @GeneratedBy(ObjectPrototypeToLocaleStringNode.class)
    public static final class ObjectPrototypeToLocaleStringNodeGen extends ObjectPrototypeToLocaleStringNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private ObjectPrototypeToLocaleStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return toLocaleString(arguments0Value_);
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
            s[0] = "toLocaleString";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeToLocaleStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPrototypeToLocaleStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectPrototypePropertyIsEnumerableNode.class)
    public static final class ObjectPrototypePropertyIsEnumerableNodeGen extends ObjectPrototypePropertyIsEnumerableNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private ObjectPrototypePropertyIsEnumerableNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return propertyIsEnumerable(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return propertyIsEnumerable(arguments0Value_, arguments1Value_);
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
            s[0] = "propertyIsEnumerable";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypePropertyIsEnumerableNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPrototypePropertyIsEnumerableNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectPrototypeHasOwnPropertyNode.class)
    public static final class ObjectPrototypeHasOwnPropertyNodeGen extends ObjectPrototypeHasOwnPropertyNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;
        @CompilationFinal private int exclude_;

        private ObjectPrototypeHasOwnPropertyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1111111101) == 0 /* only-active doJSObjectIntKey(DynamicObject, int) */ && ((state_0 & 0b1111111111) != 0  /* is-not doJSObjectStringKey(DynamicObject, String) && doJSObjectIntKey(DynamicObject, int) && doJSObjectAnyKey(DynamicObject, Object) && hasOwnPropertyNullOrUndefined(DynamicObject, Object) && hasOwnPropertyLazyString(JSLazyString, Object) && hasOwnPropertyPrimitive(Object, Object) && hasOwnPropertySymbol(Symbol, Object) && hasOwnPropertySafeInteger(SafeInteger, Object) && hasOwnPropertyBigInt(BigInt, Object) && hasOwnPropertyForeign(Object, Object) */)) {
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
            assert (state_0 & 0b10) != 0 /* is-state_0 doJSObjectIntKey(DynamicObject, int) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return doJSObjectIntKey(arguments0Value__, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private Object execute_generic1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b1111) != 0 /* is-state_0 doJSObjectStringKey(DynamicObject, String) || doJSObjectIntKey(DynamicObject, int) || doJSObjectAnyKey(DynamicObject, Object) || hasOwnPropertyNullOrUndefined(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doJSObjectStringKey(DynamicObject, String) */ && JSTypesGen.isImplicitString((state_0 & 0b1110000000000) >>> 10 /* extract-implicit-state_0 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state_0 & 0b1110000000000) >>> 10 /* extract-implicit-state_0 1:String */, arguments1Value_);
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doJSObjectStringKey(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doJSObjectIntKey(DynamicObject, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doJSObjectIntKey(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b1100) != 0 /* is-state_0 doJSObjectAnyKey(DynamicObject, Object) || hasOwnPropertyNullOrUndefined(DynamicObject, Object) */) {
                    if ((state_0 & 0b100) != 0 /* is-state_0 doJSObjectAnyKey(DynamicObject, Object) */) {
                        if ((JSGuards.isJSObject(arguments0Value__))) {
                            return doJSObjectAnyKey(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 hasOwnPropertyNullOrUndefined(DynamicObject, Object) */) {
                        if ((JSGuards.isNullOrUndefined(arguments0Value__))) {
                            return hasOwnPropertyNullOrUndefined(arguments0Value__, arguments1Value_);
                        }
                    }
                }
            }
            if ((state_0 & 0b1111110000) != 0 /* is-state_0 hasOwnPropertyLazyString(JSLazyString, Object) || hasOwnPropertyPrimitive(Object, Object) || hasOwnPropertySymbol(Symbol, Object) || hasOwnPropertySafeInteger(SafeInteger, Object) || hasOwnPropertyBigInt(BigInt, Object) || hasOwnPropertyForeign(Object, Object) */) {
                if ((state_0 & 0b10000) != 0 /* is-state_0 hasOwnPropertyLazyString(JSLazyString, Object) */ && arguments0Value_ instanceof JSLazyString) {
                    JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                    return hasOwnPropertyLazyString(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 hasOwnPropertyPrimitive(Object, Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                        return hasOwnPropertyPrimitive(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 hasOwnPropertySymbol(Symbol, Object) */ && arguments0Value_ instanceof Symbol) {
                    Symbol arguments0Value__ = (Symbol) arguments0Value_;
                    return hasOwnPropertySymbol(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b10000000) != 0 /* is-state_0 hasOwnPropertySafeInteger(SafeInteger, Object) */ && arguments0Value_ instanceof SafeInteger) {
                    SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                    return hasOwnPropertySafeInteger(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b100000000) != 0 /* is-state_0 hasOwnPropertyBigInt(BigInt, Object) */ && arguments0Value_ instanceof BigInt) {
                    BigInt arguments0Value__ = (BigInt) arguments0Value_;
                    return hasOwnPropertyBigInt(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 hasOwnPropertyForeign(Object, Object) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return hasOwnPropertyForeign(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1111111101) == 0 /* only-active doJSObjectIntKey(DynamicObject, int) */ && ((state_0 & 0b1111111111) != 0  /* is-not doJSObjectStringKey(DynamicObject, String) && doJSObjectIntKey(DynamicObject, int) && doJSObjectAnyKey(DynamicObject, Object) && hasOwnPropertyNullOrUndefined(DynamicObject, Object) && hasOwnPropertyLazyString(JSLazyString, Object) && hasOwnPropertyPrimitive(Object, Object) && hasOwnPropertySymbol(Symbol, Object) && hasOwnPropertySafeInteger(SafeInteger, Object) && hasOwnPropertyBigInt(BigInt, Object) && hasOwnPropertyForeign(Object, Object) */)) {
                return executeBoolean_int2(state_0, frameValue);
            } else {
                return executeBoolean_generic3(state_0, frameValue);
            }
        }

        private boolean executeBoolean_int2(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, ex.getResult());
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 doJSObjectIntKey(DynamicObject, int) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return doJSObjectIntKey(arguments0Value__, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private boolean executeBoolean_generic3(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b1111) != 0 /* is-state_0 doJSObjectStringKey(DynamicObject, String) || doJSObjectIntKey(DynamicObject, int) || doJSObjectAnyKey(DynamicObject, Object) || hasOwnPropertyNullOrUndefined(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doJSObjectStringKey(DynamicObject, String) */ && JSTypesGen.isImplicitString((state_0 & 0b1110000000000) >>> 10 /* extract-implicit-state_0 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state_0 & 0b1110000000000) >>> 10 /* extract-implicit-state_0 1:String */, arguments1Value_);
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doJSObjectStringKey(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doJSObjectIntKey(DynamicObject, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doJSObjectIntKey(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state_0 & 0b1100) != 0 /* is-state_0 doJSObjectAnyKey(DynamicObject, Object) || hasOwnPropertyNullOrUndefined(DynamicObject, Object) */) {
                    if ((state_0 & 0b100) != 0 /* is-state_0 doJSObjectAnyKey(DynamicObject, Object) */) {
                        if ((JSGuards.isJSObject(arguments0Value__))) {
                            return doJSObjectAnyKey(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 hasOwnPropertyNullOrUndefined(DynamicObject, Object) */) {
                        if ((JSGuards.isNullOrUndefined(arguments0Value__))) {
                            return hasOwnPropertyNullOrUndefined(arguments0Value__, arguments1Value_);
                        }
                    }
                }
            }
            if ((state_0 & 0b1111110000) != 0 /* is-state_0 hasOwnPropertyLazyString(JSLazyString, Object) || hasOwnPropertyPrimitive(Object, Object) || hasOwnPropertySymbol(Symbol, Object) || hasOwnPropertySafeInteger(SafeInteger, Object) || hasOwnPropertyBigInt(BigInt, Object) || hasOwnPropertyForeign(Object, Object) */) {
                if ((state_0 & 0b10000) != 0 /* is-state_0 hasOwnPropertyLazyString(JSLazyString, Object) */ && arguments0Value_ instanceof JSLazyString) {
                    JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                    return hasOwnPropertyLazyString(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 hasOwnPropertyPrimitive(Object, Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                        return hasOwnPropertyPrimitive(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 hasOwnPropertySymbol(Symbol, Object) */ && arguments0Value_ instanceof Symbol) {
                    Symbol arguments0Value__ = (Symbol) arguments0Value_;
                    return hasOwnPropertySymbol(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b10000000) != 0 /* is-state_0 hasOwnPropertySafeInteger(SafeInteger, Object) */ && arguments0Value_ instanceof SafeInteger) {
                    SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                    return hasOwnPropertySafeInteger(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b100000000) != 0 /* is-state_0 hasOwnPropertyBigInt(BigInt, Object) */ && arguments0Value_ instanceof BigInt) {
                    BigInt arguments0Value__ = (BigInt) arguments0Value_;
                    return hasOwnPropertyBigInt(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 hasOwnPropertyForeign(Object, Object) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return hasOwnPropertyForeign(arguments0Value_, arguments1Value_);
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
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (((exclude & 0b1)) == 0 /* is-not-exclude doJSObjectStringKey(DynamicObject, String) */) {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            if ((JSGuards.isJSObject(arguments0Value_))) {
                                state_0 = (state_0 | (stringCast1 << 10) /* set-implicit-state_0 1:String */);
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doJSObjectStringKey(DynamicObject, String) */;
                                lock.unlock();
                                hasLock = false;
                                return doJSObjectStringKey(arguments0Value_, arguments1Value_);
                            }
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-exclude doJSObjectIntKey(DynamicObject, int) */ && arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doJSObjectIntKey(DynamicObject, int) */;
                            lock.unlock();
                            hasLock = false;
                            return doJSObjectIntKey(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.exclude_ = exclude = exclude | 0b11 /* add-exclude doJSObjectStringKey(DynamicObject, String), doJSObjectIntKey(DynamicObject, int) */;
                        state_0 = state_0 & 0xfffffffc /* remove-state_0 doJSObjectStringKey(DynamicObject, String), doJSObjectIntKey(DynamicObject, int) */;
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doJSObjectAnyKey(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doJSObjectAnyKey(arguments0Value_, arguments1Value);
                    }
                    if ((JSGuards.isNullOrUndefined(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 hasOwnPropertyNullOrUndefined(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return hasOwnPropertyNullOrUndefined(arguments0Value_, arguments1Value);
                    }
                }
                if (arguments0Value instanceof JSLazyString) {
                    JSLazyString arguments0Value_ = (JSLazyString) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 hasOwnPropertyLazyString(JSLazyString, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return hasOwnPropertyLazyString(arguments0Value_, arguments1Value);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 hasOwnPropertyPrimitive(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return hasOwnPropertyPrimitive(arguments0Value, arguments1Value);
                }
                if (arguments0Value instanceof Symbol) {
                    Symbol arguments0Value_ = (Symbol) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 hasOwnPropertySymbol(Symbol, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return hasOwnPropertySymbol(arguments0Value_, arguments1Value);
                }
                if (arguments0Value instanceof SafeInteger) {
                    SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 hasOwnPropertySafeInteger(SafeInteger, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return hasOwnPropertySafeInteger(arguments0Value_, arguments1Value);
                }
                if (arguments0Value instanceof BigInt) {
                    BigInt arguments0Value_ = (BigInt) arguments0Value;
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 hasOwnPropertyBigInt(BigInt, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return hasOwnPropertyBigInt(arguments0Value_, arguments1Value);
                }
                if ((JSGuards.isForeignObject(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 hasOwnPropertyForeign(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return hasOwnPropertyForeign(arguments0Value, arguments1Value);
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
            if ((state_0 & 0b1111111111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b1111111111) & ((state_0 & 0b1111111111) - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[11];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "doJSObjectStringKey";
            if ((state_0 & 0b1) != 0 /* is-state_0 doJSObjectStringKey(DynamicObject, String) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b1) != 0 /* is-exclude doJSObjectStringKey(DynamicObject, String) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doJSObjectIntKey";
            if ((state_0 & 0b10) != 0 /* is-state_0 doJSObjectIntKey(DynamicObject, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b10) != 0 /* is-exclude doJSObjectIntKey(DynamicObject, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doJSObjectAnyKey";
            if ((state_0 & 0b100) != 0 /* is-state_0 doJSObjectAnyKey(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertyNullOrUndefined";
            if ((state_0 & 0b1000) != 0 /* is-state_0 hasOwnPropertyNullOrUndefined(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertyLazyString";
            if ((state_0 & 0b10000) != 0 /* is-state_0 hasOwnPropertyLazyString(JSLazyString, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertyPrimitive";
            if ((state_0 & 0b100000) != 0 /* is-state_0 hasOwnPropertyPrimitive(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertySymbol";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 hasOwnPropertySymbol(Symbol, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertySafeInteger";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 hasOwnPropertySafeInteger(SafeInteger, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertyBigInt";
            if ((state_0 & 0b100000000) != 0 /* is-state_0 hasOwnPropertyBigInt(BigInt, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertyForeign";
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 hasOwnPropertyForeign(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[10] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeHasOwnPropertyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPrototypeHasOwnPropertyNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectPrototypeIsPrototypeOfNode.class)
    public static final class ObjectPrototypeIsPrototypeOfNodeGen extends ObjectPrototypeIsPrototypeOfNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private ObjectPrototypeIsPrototypeOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 isPrototypeOf(Object, DynamicObject) || isPrototypeOfNoObject(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 isPrototypeOf(Object, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments1Value__))) {
                        return isPrototypeOf(arguments0Value_, arguments1Value__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 isPrototypeOfNoObject(Object, Object) */) {
                    if ((!(JSGuards.isJSObject(arguments1Value_)))) {
                        return isPrototypeOfNoObject(arguments0Value_, arguments1Value_);
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
            if (state_0 != 0 /* is-state_0 isPrototypeOf(Object, DynamicObject) || isPrototypeOfNoObject(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 isPrototypeOf(Object, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments1Value__))) {
                        return isPrototypeOf(arguments0Value_, arguments1Value__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 isPrototypeOfNoObject(Object, Object) */) {
                    if ((!(JSGuards.isJSObject(arguments1Value_)))) {
                        return isPrototypeOfNoObject(arguments0Value_, arguments1Value_);
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
            if (JSTypes.isDynamicObject(arguments1Value)) {
                DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                if ((JSGuards.isJSObject(arguments1Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 isPrototypeOf(Object, DynamicObject) */;
                    return isPrototypeOf(arguments0Value, arguments1Value_);
                }
            }
            if ((!(JSGuards.isJSObject(arguments1Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 isPrototypeOfNoObject(Object, Object) */;
                return isPrototypeOfNoObject(arguments0Value, arguments1Value);
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
            s[0] = "isPrototypeOf";
            if ((state_0 & 0b1) != 0 /* is-state_0 isPrototypeOf(Object, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isPrototypeOfNoObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 isPrototypeOfNoObject(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeIsPrototypeOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPrototypeIsPrototypeOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectPrototypeDefineGetterOrSetterNode.class)
    public static final class ObjectPrototypeDefineGetterOrSetterNodeGen extends ObjectPrototypeDefineGetterOrSetterNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private ObjectPrototypeDefineGetterOrSetterNodeGen(JSContext context, JSBuiltin builtin, boolean getter, JavaScriptNode[] arguments) {
            super(context, builtin, getter);
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            return define(arguments0Value_, arguments1Value_, arguments2Value_);
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
            s[0] = "define";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeDefineGetterOrSetterNode create(JSContext context, JSBuiltin builtin, boolean getter, JavaScriptNode[] arguments) {
            return new ObjectPrototypeDefineGetterOrSetterNodeGen(context, builtin, getter, arguments);
        }

    }
    @GeneratedBy(ObjectPrototypeLookupGetterOrSetterNode.class)
    public static final class ObjectPrototypeLookupGetterOrSetterNodeGen extends ObjectPrototypeLookupGetterOrSetterNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private ObjectPrototypeLookupGetterOrSetterNodeGen(JSContext context, JSBuiltin builtin, boolean getter, JavaScriptNode[] arguments) {
            super(context, builtin, getter);
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
            return lookup(arguments0Value_, arguments1Value_);
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
            s[0] = "lookup";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeLookupGetterOrSetterNode create(JSContext context, JSBuiltin builtin, boolean getter, JavaScriptNode[] arguments) {
            return new ObjectPrototypeLookupGetterOrSetterNodeGen(context, builtin, getter, arguments);
        }

    }
}
