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
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberToExponentialNode;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberToFixedNode;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberToLocaleStringIntlNode;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberToLocaleStringNode;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberToPrecisionNode;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberToStringNode;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberValueOfNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToIntegerAsIntNode;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(NumberPrototypeBuiltins.class)
@SuppressWarnings("unused")
public final class NumberPrototypeBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(JSNumberToStringNode.class)
    public static final class JSNumberToStringNodeGen extends JSNumberToStringNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private JSToIntegerAsIntNode toInt;
        @Child private ToStringForeignObject0Data toStringForeignObject0_cache;
        @Child private JSToIntegerAsIntNode toStringForeignObject1_toIntegerNode_;

        private JSNumberToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1111011111) == 0 /* only-active toStringPrimitiveRadixInt(Number, int) */ && (state_0 != 0  /* is-not toStringIntRadix10(DynamicObject, Object) && toStringRadix10(DynamicObject, Object) && toString(DynamicObject, Object, JSToIntegerAsIntNode) && toStringPrimitiveIntRadix10(Object, Object) && toStringPrimitiveRadix10(Object, Object) && toStringPrimitiveRadixInt(Number, int) && toStringPrimitive(Number, Object, JSToIntegerAsIntNode) && toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) && toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) && toStringNoNumber(Object, Object) */)) {
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
            assert (state_0 & 0b100000) != 0 /* is-state_0 toStringPrimitiveRadixInt(Number, int) */;
            if (arguments0Value_ instanceof Number) {
                Number arguments0Value__ = (Number) arguments0Value_;
                return toStringPrimitiveRadixInt(arguments0Value__, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object toStringForeignObject1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary toStringForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return toStringForeignObject(arguments0Value_, arguments1Value_, this.toStringForeignObject1_toIntegerNode_, toStringForeignObject1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @ExplodeLoop
        private Object execute_generic1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b11111) != 0 /* is-state_0 toStringIntRadix10(DynamicObject, Object) || toStringRadix10(DynamicObject, Object) || toString(DynamicObject, Object, JSToIntegerAsIntNode) || toStringPrimitiveIntRadix10(Object, Object) || toStringPrimitiveRadix10(Object, Object) */) {
                if ((state_0 & 0b111) != 0 /* is-state_0 toStringIntRadix10(DynamicObject, Object) || toStringRadix10(DynamicObject, Object) || toString(DynamicObject, Object, JSToIntegerAsIntNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 toStringIntRadix10(DynamicObject, Object) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (JSGuards.isJSNumberInteger(arguments0Value__)) && (isRadix10(arguments1Value_))) {
                            return toStringIntRadix10(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 toStringRadix10(DynamicObject, Object) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (isRadix10(arguments1Value_))) {
                            return toStringRadix10(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 toString(DynamicObject, Object, JSToIntegerAsIntNode) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return toString(arguments0Value__, arguments1Value_, this.toInt);
                        }
                    }
                }
                if ((state_0 & 0b11000) != 0 /* is-state_0 toStringPrimitiveIntRadix10(Object, Object) || toStringPrimitiveRadix10(Object, Object) */) {
                    if ((state_0 & 0b1000) != 0 /* is-state_0 toStringPrimitiveIntRadix10(Object, Object) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_)) && (JSGuards.isNumberInteger(arguments0Value_)) && (isRadix10(arguments1Value_))) {
                            return toStringPrimitiveIntRadix10(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 toStringPrimitiveRadix10(Object, Object) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_)) && (isRadix10(arguments1Value_))) {
                            return toStringPrimitiveRadix10(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            if ((state_0 & 0b1100000) != 0 /* is-state_0 toStringPrimitiveRadixInt(Number, int) || toStringPrimitive(Number, Object, JSToIntegerAsIntNode) */ && arguments0Value_ instanceof Number) {
                Number arguments0Value__ = (Number) arguments0Value_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 toStringPrimitiveRadixInt(Number, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    return toStringPrimitiveRadixInt(arguments0Value__, arguments1Value__);
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 toStringPrimitive(Number, Object, JSToIntegerAsIntNode) */) {
                    if ((!(JSGuards.isUndefined(arguments1Value_)))) {
                        return toStringPrimitive(arguments0Value__, arguments1Value_, this.toInt);
                    }
                }
            }
            if ((state_0 & 0b1110000000) != 0 /* is-state_0 toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) || toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) || toStringNoNumber(Object, Object) */) {
                if ((state_0 & 0b10000000) != 0 /* is-state_0 toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                    ToStringForeignObject0Data s7_ = this.toStringForeignObject0_cache;
                    while (s7_ != null) {
                        if ((s7_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return toStringForeignObject(arguments0Value_, arguments1Value_, s7_.toIntegerNode_, s7_.interop_);
                        }
                        s7_ = s7_.next_;
                    }
                }
                if ((state_0 & 0b100000000) != 0 /* is-state_0 toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return this.toStringForeignObject1Boundary(state_0, arguments0Value_, arguments1Value_);
                    }
                }
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 toStringNoNumber(Object, Object) */) {
                    if ((!(JSGuards.isJSNumber(arguments0Value_))) && (!(JSGuards.isJavaNumber(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                        return toStringNoNumber(arguments0Value_, arguments1Value_);
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

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (JSGuards.isJSNumberInteger(arguments0Value_)) && (isRadix10(arguments1Value))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 toStringIntRadix10(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringIntRadix10(arguments0Value_, arguments1Value);
                    }
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (isRadix10(arguments1Value))) {
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 toStringRadix10(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringRadix10(arguments0Value_, arguments1Value);
                    }
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                        this.toInt = super.insert(this.toInt == null ? ((JSToIntegerAsIntNode.create())) : this.toInt);
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 toString(DynamicObject, Object, JSToIntegerAsIntNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toString(arguments0Value_, arguments1Value, this.toInt);
                    }
                }
                if ((JSGuards.isJavaNumber(arguments0Value)) && (JSGuards.isNumberInteger(arguments0Value)) && (isRadix10(arguments1Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 toStringPrimitiveIntRadix10(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toStringPrimitiveIntRadix10(arguments0Value, arguments1Value);
                }
                if ((JSGuards.isJavaNumber(arguments0Value)) && (isRadix10(arguments1Value))) {
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 toStringPrimitiveRadix10(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toStringPrimitiveRadix10(arguments0Value, arguments1Value);
                }
                if (arguments0Value instanceof Number) {
                    Number arguments0Value_ = (Number) arguments0Value;
                    if (((exclude & 0b1)) == 0 /* is-not-exclude toStringPrimitiveRadixInt(Number, int) */ && arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 toStringPrimitiveRadixInt(Number, int) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringPrimitiveRadixInt(arguments0Value_, arguments1Value_);
                    }
                    if ((!(JSGuards.isUndefined(arguments1Value)))) {
                        this.toInt = super.insert(this.toInt == null ? ((JSToIntegerAsIntNode.create())) : this.toInt);
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude toStringPrimitiveRadixInt(Number, int) */;
                        state_0 = state_0 & 0xffffffdf /* remove-state_0 toStringPrimitiveRadixInt(Number, int) */;
                        this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 toStringPrimitive(Number, Object, JSToIntegerAsIntNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringPrimitive(arguments0Value_, arguments1Value, this.toInt);
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-exclude toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                    int count7_ = 0;
                    ToStringForeignObject0Data s7_ = this.toStringForeignObject0_cache;
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                        while (s7_ != null) {
                            if ((s7_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                break;
                            }
                            s7_ = s7_.next_;
                            count7_++;
                        }
                    }
                    if (s7_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && count7_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s7_.interop_.accepts(arguments0Value));
                            s7_ = super.insert(new ToStringForeignObject0Data(toStringForeignObject0_cache));
                            s7_.toIntegerNode_ = s7_.insertAccessor((JSToIntegerAsIntNode.create()));
                            s7_.interop_ = s7_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.toStringForeignObject0_cache = s7_;
                            this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */;
                        }
                    }
                    if (s7_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return toStringForeignObject(arguments0Value, arguments1Value, s7_.toIntegerNode_, s7_.interop_);
                    }
                }
                {
                    InteropLibrary toStringForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                this.toStringForeignObject1_toIntegerNode_ = super.insert((JSToIntegerAsIntNode.create()));
                                toStringForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b10 /* add-exclude toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */;
                                this.toStringForeignObject0_cache = null;
                                state_0 = state_0 & 0xffffff7f /* remove-state_0 toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return toStringForeignObject(arguments0Value, arguments1Value, this.toStringForeignObject1_toIntegerNode_, toStringForeignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSNumber(arguments0Value))) && (!(JSGuards.isJavaNumber(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 toStringNoNumber(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toStringNoNumber(arguments0Value, arguments1Value);
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
                    ToStringForeignObject0Data s7_ = this.toStringForeignObject0_cache;
                    if ((s7_ == null || s7_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
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
            s[0] = "toStringIntRadix10";
            if ((state_0 & 0b1) != 0 /* is-state_0 toStringIntRadix10(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toStringRadix10";
            if ((state_0 & 0b10) != 0 /* is-state_0 toStringRadix10(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toString";
            if ((state_0 & 0b100) != 0 /* is-state_0 toString(DynamicObject, Object, JSToIntegerAsIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toInt));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toStringPrimitiveIntRadix10";
            if ((state_0 & 0b1000) != 0 /* is-state_0 toStringPrimitiveIntRadix10(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "toStringPrimitiveRadix10";
            if ((state_0 & 0b10000) != 0 /* is-state_0 toStringPrimitiveRadix10(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "toStringPrimitiveRadixInt";
            if ((state_0 & 0b100000) != 0 /* is-state_0 toStringPrimitiveRadixInt(Number, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b1) != 0 /* is-exclude toStringPrimitiveRadixInt(Number, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "toStringPrimitive";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 toStringPrimitive(Number, Object, JSToIntegerAsIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toInt));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "toStringForeignObject";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ToStringForeignObject0Data s7_ = this.toStringForeignObject0_cache;
                while (s7_ != null) {
                    cached.add(Arrays.asList(s7_.toIntegerNode_, s7_.interop_));
                    s7_ = s7_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b10) != 0 /* is-exclude toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "toStringForeignObject";
            if ((state_0 & 0b100000000) != 0 /* is-state_0 toStringForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toStringForeignObject1_toIntegerNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            s = new Object[3];
            s[0] = "toStringNoNumber";
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 toStringNoNumber(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[10] = s;
            return Provider.create(data);
        }

        public static JSNumberToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberToStringNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSNumberToStringNode.class)
        private static final class ToStringForeignObject0Data extends Node {

            @Child ToStringForeignObject0Data next_;
            @Child JSToIntegerAsIntNode toIntegerNode_;
            @Child InteropLibrary interop_;

            ToStringForeignObject0Data(ToStringForeignObject0Data next_) {
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
    @GeneratedBy(JSNumberToLocaleStringNode.class)
    public static final class JSNumberToLocaleStringNodeGen extends JSNumberToLocaleStringNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ToLocaleStringForeignObject0Data toLocaleStringForeignObject0_cache;

        private JSNumberToLocaleStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 toLocaleString(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSNumber(arguments0Value__))) {
                    return toLocaleString(arguments0Value__);
                }
            }
            if ((state_0 & 0b11110) != 0 /* is-state_0 toLocaleStringPrimitive(Object) || toLocaleStringForeignObject(Object, InteropLibrary) || toLocaleStringForeignObject(Object, InteropLibrary) || toLocaleStringOther(Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 toLocaleStringPrimitive(Object) */) {
                    if ((JSGuards.isJavaNumber(arguments0Value_))) {
                        return toLocaleStringPrimitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 toLocaleStringForeignObject(Object, InteropLibrary) */) {
                    ToLocaleStringForeignObject0Data s2_ = this.toLocaleStringForeignObject0_cache;
                    while (s2_ != null) {
                        if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return toLocaleStringForeignObject(arguments0Value_, s2_.interop_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 toLocaleStringForeignObject(Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return this.toLocaleStringForeignObject1Boundary(state_0, arguments0Value_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 toLocaleStringOther(Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_)) {
                        return toLocaleStringOther(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object toLocaleStringForeignObject1Boundary(int state_0, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary toLocaleStringForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return toLocaleStringForeignObject(arguments0Value_, toLocaleStringForeignObject1_interop__);
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
                    if ((JSGuards.isJSNumber(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 toLocaleString(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return toLocaleString(arguments0Value_);
                    }
                }
                if ((JSGuards.isJavaNumber(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 toLocaleStringPrimitive(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toLocaleStringPrimitive(arguments0Value);
                }
                if ((exclude) == 0 /* is-not-exclude toLocaleStringForeignObject(Object, InteropLibrary) */) {
                    int count2_ = 0;
                    ToLocaleStringForeignObject0Data s2_ = this.toLocaleStringForeignObject0_cache;
                    if ((state_0 & 0b100) != 0 /* is-state_0 toLocaleStringForeignObject(Object, InteropLibrary) */) {
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && count2_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s2_.interop_.accepts(arguments0Value));
                            s2_ = super.insert(new ToLocaleStringForeignObject0Data(toLocaleStringForeignObject0_cache));
                            s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.toLocaleStringForeignObject0_cache = s2_;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 toLocaleStringForeignObject(Object, InteropLibrary) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return toLocaleStringForeignObject(arguments0Value, s2_.interop_);
                    }
                }
                {
                    InteropLibrary toLocaleStringForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                toLocaleStringForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude toLocaleStringForeignObject(Object, InteropLibrary) */;
                                this.toLocaleStringForeignObject0_cache = null;
                                state_0 = state_0 & 0xfffffffb /* remove-state_0 toLocaleStringForeignObject(Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 toLocaleStringForeignObject(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return toLocaleStringForeignObject(arguments0Value, toLocaleStringForeignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 toLocaleStringOther(Object) */;
                lock.unlock();
                hasLock = false;
                return toLocaleStringOther(arguments0Value);
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
                    ToLocaleStringForeignObject0Data s2_ = this.toLocaleStringForeignObject0_cache;
                    if ((s2_ == null || s2_.next_ == null)) {
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
            s[0] = "toLocaleString";
            if ((state_0 & 0b1) != 0 /* is-state_0 toLocaleString(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toLocaleStringPrimitive";
            if ((state_0 & 0b10) != 0 /* is-state_0 toLocaleStringPrimitive(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toLocaleStringForeignObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 toLocaleStringForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ToLocaleStringForeignObject0Data s2_ = this.toLocaleStringForeignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude toLocaleStringForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toLocaleStringForeignObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 toLocaleStringForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "toLocaleStringOther";
            if ((state_0 & 0b10000) != 0 /* is-state_0 toLocaleStringOther(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSNumber(arguments0Value_))) {
                    return false;
                }
            }
            if (((state_0 & 0b10)) == 0 /* is-not-state_0 toLocaleStringPrimitive(Object) */ && (JSGuards.isJavaNumber(arguments0Value))) {
                return false;
            }
            if (((state_0 & 0b1000)) == 0 /* is-not-state_0 toLocaleStringForeignObject(Object, InteropLibrary) */ && (JSGuards.isForeignObject(arguments0Value))) {
                return false;
            }
            return true;
        }

        public static JSNumberToLocaleStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberToLocaleStringNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSNumberToLocaleStringNode.class)
        private static final class ToLocaleStringForeignObject0Data extends Node {

            @Child ToLocaleStringForeignObject0Data next_;
            @Child InteropLibrary interop_;

            ToLocaleStringForeignObject0Data(ToLocaleStringForeignObject0Data next_) {
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
    @GeneratedBy(JSNumberToLocaleStringIntlNode.class)
    public static final class JSNumberToLocaleStringIntlNodeGen extends JSNumberToLocaleStringIntlNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ToLocaleStringForeignObject0Data toLocaleStringForeignObject0_cache;

        private JSNumberToLocaleStringIntlNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 jsNumberToLocaleString(DynamicObject, Object, Object) || javaNumberToLocaleString(Object, Object, Object) || toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) || toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) || failForNonNumbers(Object, Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 jsNumberToLocaleString(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSNumber(arguments0Value__))) {
                        return jsNumberToLocaleString(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b11110) != 0 /* is-state_0 javaNumberToLocaleString(Object, Object, Object) || toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) || toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) || failForNonNumbers(Object, Object, Object) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 javaNumberToLocaleString(Object, Object, Object) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_))) {
                            return javaNumberToLocaleString(arguments0Value_, arguments1Value_, arguments2Value_);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) */) {
                        ToLocaleStringForeignObject0Data s2_ = this.toLocaleStringForeignObject0_cache;
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return toLocaleStringForeignObject(arguments0Value_, arguments1Value_, arguments2Value_, s2_.interop_);
                            }
                            s2_ = s2_.next_;
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.toLocaleStringForeignObject1Boundary(state_0, arguments0Value_, arguments1Value_, arguments2Value_);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 failForNonNumbers(Object, Object, Object) */) {
                        if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_, arguments2Value_)) {
                            return failForNonNumbers(arguments0Value_, arguments1Value_, arguments2Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object toLocaleStringForeignObject1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_, Object arguments2Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary toLocaleStringForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return toLocaleStringForeignObject(arguments0Value_, arguments1Value_, arguments2Value_, toLocaleStringForeignObject1_interop__);
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

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSNumber(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 jsNumberToLocaleString(DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return jsNumberToLocaleString(arguments0Value_, arguments1Value, arguments2Value);
                    }
                }
                if ((JSGuards.isJavaNumber(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 javaNumberToLocaleString(Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return javaNumberToLocaleString(arguments0Value, arguments1Value, arguments2Value);
                }
                if ((exclude) == 0 /* is-not-exclude toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) */) {
                    int count2_ = 0;
                    ToLocaleStringForeignObject0Data s2_ = this.toLocaleStringForeignObject0_cache;
                    if ((state_0 & 0b100) != 0 /* is-state_0 toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) */) {
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && count2_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s2_.interop_.accepts(arguments0Value));
                            s2_ = super.insert(new ToLocaleStringForeignObject0Data(toLocaleStringForeignObject0_cache));
                            s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.toLocaleStringForeignObject0_cache = s2_;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return toLocaleStringForeignObject(arguments0Value, arguments1Value, arguments2Value, s2_.interop_);
                    }
                }
                {
                    InteropLibrary toLocaleStringForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                toLocaleStringForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) */;
                                this.toLocaleStringForeignObject0_cache = null;
                                state_0 = state_0 & 0xfffffffb /* remove-state_0 toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return toLocaleStringForeignObject(arguments0Value, arguments1Value, arguments2Value, toLocaleStringForeignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 failForNonNumbers(Object, Object, Object) */;
                lock.unlock();
                hasLock = false;
                return failForNonNumbers(arguments0Value, arguments1Value, arguments2Value);
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
                    ToLocaleStringForeignObject0Data s2_ = this.toLocaleStringForeignObject0_cache;
                    if ((s2_ == null || s2_.next_ == null)) {
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
            s[0] = "jsNumberToLocaleString";
            if ((state_0 & 0b1) != 0 /* is-state_0 jsNumberToLocaleString(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "javaNumberToLocaleString";
            if ((state_0 & 0b10) != 0 /* is-state_0 javaNumberToLocaleString(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toLocaleStringForeignObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ToLocaleStringForeignObject0Data s2_ = this.toLocaleStringForeignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toLocaleStringForeignObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "failForNonNumbers";
            if ((state_0 & 0b10000) != 0 /* is-state_0 failForNonNumbers(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSNumber(arguments0Value_))) {
                    return false;
                }
            }
            if (((state_0 & 0b10)) == 0 /* is-not-state_0 javaNumberToLocaleString(Object, Object, Object) */ && (JSGuards.isJavaNumber(arguments0Value))) {
                return false;
            }
            if (((state_0 & 0b1000)) == 0 /* is-not-state_0 toLocaleStringForeignObject(Object, Object, Object, InteropLibrary) */ && (JSGuards.isForeignObject(arguments0Value))) {
                return false;
            }
            return true;
        }

        public static JSNumberToLocaleStringIntlNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberToLocaleStringIntlNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSNumberToLocaleStringIntlNode.class)
        private static final class ToLocaleStringForeignObject0Data extends Node {

            @Child ToLocaleStringForeignObject0Data next_;
            @Child InteropLibrary interop_;

            ToLocaleStringForeignObject0Data(ToLocaleStringForeignObject0Data next_) {
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
    @GeneratedBy(JSNumberValueOfNode.class)
    public static final class JSNumberValueOfNodeGen extends JSNumberValueOfNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ValueOfForeignObject0Data valueOfForeignObject0_cache;

        private JSNumberValueOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 valueOf(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSNumber(arguments0Value__))) {
                    return valueOf(arguments0Value__);
                }
            }
            if ((state_0 & 0b11110) != 0 /* is-state_0 valueOfPrimitive(Object) || valueOfForeignObject(Object, InteropLibrary) || valueOfForeignObject(Object, InteropLibrary) || valueOfOther(Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 valueOfPrimitive(Object) */) {
                    if ((JSGuards.isJavaNumber(arguments0Value_))) {
                        return valueOfPrimitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 valueOfForeignObject(Object, InteropLibrary) */) {
                    ValueOfForeignObject0Data s2_ = this.valueOfForeignObject0_cache;
                    while (s2_ != null) {
                        if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return valueOfForeignObject(arguments0Value_, s2_.interop_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 valueOfForeignObject(Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return this.valueOfForeignObject1Boundary(state_0, arguments0Value_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 valueOfOther(Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_)) {
                        return valueOfOther(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object valueOfForeignObject1Boundary(int state_0, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary valueOfForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return valueOfForeignObject(arguments0Value_, valueOfForeignObject1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @ExplodeLoop
        @Override
        public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b10001) != 0 /* is-state_0 valueOf(DynamicObject) || valueOfOther(Object) */) {
                return JSTypesGen.expectDouble(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1110) != 0 /* is-state_0 valueOfPrimitive(Object) || valueOfForeignObject(Object, InteropLibrary) || valueOfForeignObject(Object, InteropLibrary) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 valueOfPrimitive(Object) */) {
                    if ((JSGuards.isJavaNumber(arguments0Value_))) {
                        return valueOfPrimitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 valueOfForeignObject(Object, InteropLibrary) */) {
                    ValueOfForeignObject0Data s2_ = this.valueOfForeignObject0_cache;
                    while (s2_ != null) {
                        if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return valueOfForeignObject(arguments0Value_, s2_.interop_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 valueOfForeignObject(Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return this.valueOfForeignObject1Boundary0(state_0, arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_));
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private double valueOfForeignObject1Boundary0(int state_0, Object arguments0Value_) throws UnexpectedResultException {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary valueOfForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return valueOfForeignObject(arguments0Value_, valueOfForeignObject1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b10001) == 0 /* only-active valueOfPrimitive(Object) && valueOfForeignObject(Object, InteropLibrary) && valueOfForeignObject(Object, InteropLibrary) */ && (state_0 != 0  /* is-not valueOf(DynamicObject) && valueOfPrimitive(Object) && valueOfForeignObject(Object, InteropLibrary) && valueOfForeignObject(Object, InteropLibrary) && valueOfOther(Object) */)) {
                    executeDouble(frameValue);
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
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSNumber(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 valueOf(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return valueOf(arguments0Value_);
                    }
                }
                if ((JSGuards.isJavaNumber(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 valueOfPrimitive(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfPrimitive(arguments0Value);
                }
                if ((exclude) == 0 /* is-not-exclude valueOfForeignObject(Object, InteropLibrary) */) {
                    int count2_ = 0;
                    ValueOfForeignObject0Data s2_ = this.valueOfForeignObject0_cache;
                    if ((state_0 & 0b100) != 0 /* is-state_0 valueOfForeignObject(Object, InteropLibrary) */) {
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && count2_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s2_.interop_.accepts(arguments0Value));
                            s2_ = super.insert(new ValueOfForeignObject0Data(valueOfForeignObject0_cache));
                            s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.valueOfForeignObject0_cache = s2_;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 valueOfForeignObject(Object, InteropLibrary) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return valueOfForeignObject(arguments0Value, s2_.interop_);
                    }
                }
                {
                    InteropLibrary valueOfForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                valueOfForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude valueOfForeignObject(Object, InteropLibrary) */;
                                this.valueOfForeignObject0_cache = null;
                                state_0 = state_0 & 0xfffffffb /* remove-state_0 valueOfForeignObject(Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 valueOfForeignObject(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return valueOfForeignObject(arguments0Value, valueOfForeignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 valueOfOther(Object) */;
                lock.unlock();
                hasLock = false;
                return valueOfOther(arguments0Value);
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
                    ValueOfForeignObject0Data s2_ = this.valueOfForeignObject0_cache;
                    if ((s2_ == null || s2_.next_ == null)) {
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
            s[0] = "valueOf";
            if ((state_0 & 0b1) != 0 /* is-state_0 valueOf(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "valueOfPrimitive";
            if ((state_0 & 0b10) != 0 /* is-state_0 valueOfPrimitive(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "valueOfForeignObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 valueOfForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ValueOfForeignObject0Data s2_ = this.valueOfForeignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude valueOfForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "valueOfForeignObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 valueOfForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "valueOfOther";
            if ((state_0 & 0b10000) != 0 /* is-state_0 valueOfOther(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSNumber(arguments0Value_))) {
                    return false;
                }
            }
            if (((state_0 & 0b10)) == 0 /* is-not-state_0 valueOfPrimitive(Object) */ && (JSGuards.isJavaNumber(arguments0Value))) {
                return false;
            }
            if (((state_0 & 0b1000)) == 0 /* is-not-state_0 valueOfForeignObject(Object, InteropLibrary) */ && (JSGuards.isForeignObject(arguments0Value))) {
                return false;
            }
            return true;
        }

        public static JSNumberValueOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberValueOfNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSNumberValueOfNode.class)
        private static final class ValueOfForeignObject0Data extends Node {

            @Child ValueOfForeignObject0Data next_;
            @Child InteropLibrary interop_;

            ValueOfForeignObject0Data(ValueOfForeignObject0Data next_) {
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
    @GeneratedBy(JSNumberToFixedNode.class)
    public static final class JSNumberToFixedNodeGen extends JSNumberToFixedNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private JSToIntegerAsIntNode toInt;
        @Child private ToFixedForeignObject0Data toFixedForeignObject0_cache;
        @Child private JSToIntegerAsIntNode toFixedForeignObject1_toIntegerNode_;

        private JSNumberToFixedNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 toFixed(DynamicObject, Object, JSToIntegerAsIntNode) || toFixedJava(Object, Object, JSToIntegerAsIntNode) || toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) || toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) || toFixedGeneric(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 toFixed(DynamicObject, Object, JSToIntegerAsIntNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSNumber(arguments0Value__))) {
                        return toFixed(arguments0Value__, arguments1Value_, this.toInt);
                    }
                }
                if ((state_0 & 0b11110) != 0 /* is-state_0 toFixedJava(Object, Object, JSToIntegerAsIntNode) || toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) || toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) || toFixedGeneric(Object, Object) */) {
                    if ((state_0 & 0b10) != 0 /* is-state_0 toFixedJava(Object, Object, JSToIntegerAsIntNode) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_))) {
                            return toFixedJava(arguments0Value_, arguments1Value_, this.toInt);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                        ToFixedForeignObject0Data s2_ = this.toFixedForeignObject0_cache;
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return toFixedForeignObject(arguments0Value_, arguments1Value_, s2_.toIntegerNode_, s2_.interop_);
                            }
                            s2_ = s2_.next_;
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.toFixedForeignObject1Boundary(state_0, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 toFixedGeneric(Object, Object) */) {
                        if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_)) {
                            return toFixedGeneric(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object toFixedForeignObject1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary toFixedForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return toFixedForeignObject(arguments0Value_, arguments1Value_, this.toFixedForeignObject1_toIntegerNode_, toFixedForeignObject1_interop__);
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

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSNumber(arguments0Value_))) {
                        this.toInt = super.insert(this.toInt == null ? ((JSToIntegerAsIntNode.create())) : this.toInt);
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 toFixed(DynamicObject, Object, JSToIntegerAsIntNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toFixed(arguments0Value_, arguments1Value, this.toInt);
                    }
                }
                if ((JSGuards.isJavaNumber(arguments0Value))) {
                    this.toInt = super.insert(this.toInt == null ? ((JSToIntegerAsIntNode.create())) : this.toInt);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 toFixedJava(Object, Object, JSToIntegerAsIntNode) */;
                    lock.unlock();
                    hasLock = false;
                    return toFixedJava(arguments0Value, arguments1Value, this.toInt);
                }
                if ((exclude) == 0 /* is-not-exclude toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                    int count2_ = 0;
                    ToFixedForeignObject0Data s2_ = this.toFixedForeignObject0_cache;
                    if ((state_0 & 0b100) != 0 /* is-state_0 toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && count2_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s2_.interop_.accepts(arguments0Value));
                            s2_ = super.insert(new ToFixedForeignObject0Data(toFixedForeignObject0_cache));
                            s2_.toIntegerNode_ = s2_.insertAccessor((JSToIntegerAsIntNode.create()));
                            s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.toFixedForeignObject0_cache = s2_;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return toFixedForeignObject(arguments0Value, arguments1Value, s2_.toIntegerNode_, s2_.interop_);
                    }
                }
                {
                    InteropLibrary toFixedForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                this.toFixedForeignObject1_toIntegerNode_ = super.insert((JSToIntegerAsIntNode.create()));
                                toFixedForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */;
                                this.toFixedForeignObject0_cache = null;
                                state_0 = state_0 & 0xfffffffb /* remove-state_0 toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return toFixedForeignObject(arguments0Value, arguments1Value, this.toFixedForeignObject1_toIntegerNode_, toFixedForeignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 toFixedGeneric(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return toFixedGeneric(arguments0Value, arguments1Value);
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
                    ToFixedForeignObject0Data s2_ = this.toFixedForeignObject0_cache;
                    if ((s2_ == null || s2_.next_ == null)) {
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
            s[0] = "toFixed";
            if ((state_0 & 0b1) != 0 /* is-state_0 toFixed(DynamicObject, Object, JSToIntegerAsIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toInt));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toFixedJava";
            if ((state_0 & 0b10) != 0 /* is-state_0 toFixedJava(Object, Object, JSToIntegerAsIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toInt));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toFixedForeignObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ToFixedForeignObject0Data s2_ = this.toFixedForeignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.toIntegerNode_, s2_.interop_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toFixedForeignObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toFixedForeignObject1_toIntegerNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "toFixedGeneric";
            if ((state_0 & 0b10000) != 0 /* is-state_0 toFixedGeneric(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSNumber(arguments0Value_))) {
                    return false;
                }
            }
            if (((state_0 & 0b10)) == 0 /* is-not-state_0 toFixedJava(Object, Object, JSToIntegerAsIntNode) */ && (JSGuards.isJavaNumber(arguments0Value))) {
                return false;
            }
            if (((state_0 & 0b1000)) == 0 /* is-not-state_0 toFixedForeignObject(Object, Object, JSToIntegerAsIntNode, InteropLibrary) */ && (JSGuards.isForeignObject(arguments0Value))) {
                return false;
            }
            return true;
        }

        public static JSNumberToFixedNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberToFixedNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSNumberToFixedNode.class)
        private static final class ToFixedForeignObject0Data extends Node {

            @Child ToFixedForeignObject0Data next_;
            @Child JSToIntegerAsIntNode toIntegerNode_;
            @Child InteropLibrary interop_;

            ToFixedForeignObject0Data(ToFixedForeignObject0Data next_) {
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
    @GeneratedBy(JSNumberToExponentialNode.class)
    public static final class JSNumberToExponentialNodeGen extends JSNumberToExponentialNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private BranchProfile digitsError;
        @Child private JSToIntegerAsIntNode toInt;
        @Child private ToExponentialForeignObjectUndefined0Data toExponentialForeignObjectUndefined0_cache;
        @Child private ToExponentialForeignObject0Data toExponentialForeignObject0_cache;
        @CompilationFinal private BranchProfile toExponentialForeignObject1_digitsErrorBranch_;
        @Child private JSToIntegerAsIntNode toExponentialForeignObject1_toIntegerNode_;

        private JSNumberToExponentialNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 toExponentialUndefined(DynamicObject, Object) || toExponential(DynamicObject, Object, BranchProfile, JSToIntegerAsIntNode) || toExponentialPrimitiveUndefined(Object, Object) || toExponentialPrimitive(Object, Object, BranchProfile, JSToIntegerAsIntNode) || toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) || toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) || toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) || toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) || toExponentialOther(Object, Object) */) {
                if ((state_0 & 0b11) != 0 /* is-state_0 toExponentialUndefined(DynamicObject, Object) || toExponential(DynamicObject, Object, BranchProfile, JSToIntegerAsIntNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 toExponentialUndefined(DynamicObject, Object) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return toExponentialUndefined(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 toExponential(DynamicObject, Object, BranchProfile, JSToIntegerAsIntNode) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return toExponential(arguments0Value__, arguments1Value_, this.digitsError, this.toInt);
                        }
                    }
                }
                if ((state_0 & 0b111111100) != 0 /* is-state_0 toExponentialPrimitiveUndefined(Object, Object) || toExponentialPrimitive(Object, Object, BranchProfile, JSToIntegerAsIntNode) || toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) || toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) || toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) || toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) || toExponentialOther(Object, Object) */) {
                    if ((state_0 & 0b100) != 0 /* is-state_0 toExponentialPrimitiveUndefined(Object, Object) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return toExponentialPrimitiveUndefined(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 toExponentialPrimitive(Object, Object, BranchProfile, JSToIntegerAsIntNode) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return toExponentialPrimitive(arguments0Value_, arguments1Value_, this.digitsError, this.toInt);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) */) {
                        ToExponentialForeignObjectUndefined0Data s4_ = this.toExponentialForeignObjectUndefined0_cache;
                        while (s4_ != null) {
                            if ((s4_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                                return toExponentialForeignObjectUndefined(arguments0Value_, arguments1Value_, s4_.interop_);
                            }
                            s4_ = s4_.next_;
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return this.toExponentialForeignObjectUndefined1Boundary(state_0, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) */) {
                        ToExponentialForeignObject0Data s6_ = this.toExponentialForeignObject0_cache;
                        while (s6_ != null) {
                            if ((s6_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                                return toExponentialForeignObject(arguments0Value_, arguments1Value_, s6_.digitsErrorBranch_, s6_.toIntegerNode_, s6_.interop_);
                            }
                            s6_ = s6_.next_;
                        }
                    }
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return this.toExponentialForeignObject1Boundary(state_0, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b100000000) != 0 /* is-state_0 toExponentialOther(Object, Object) */) {
                        if ((!(JSGuards.isJSNumber(arguments0Value_))) && (!(JSGuards.isJavaNumber(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return toExponentialOther(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object toExponentialForeignObjectUndefined1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary toExponentialForeignObjectUndefined1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return toExponentialForeignObjectUndefined(arguments0Value_, arguments1Value_, toExponentialForeignObjectUndefined1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object toExponentialForeignObject1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary toExponentialForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return toExponentialForeignObject(arguments0Value_, arguments1Value_, this.toExponentialForeignObject1_digitsErrorBranch_, this.toExponentialForeignObject1_toIntegerNode_, toExponentialForeignObject1_interop__);
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

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 toExponentialUndefined(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return toExponentialUndefined(arguments0Value_, arguments1Value);
                    }
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                        this.digitsError = this.digitsError == null ? ((BranchProfile.create())) : this.digitsError;
                        this.toInt = super.insert(this.toInt == null ? ((JSToIntegerAsIntNode.create())) : this.toInt);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 toExponential(DynamicObject, Object, BranchProfile, JSToIntegerAsIntNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toExponential(arguments0Value_, arguments1Value, this.digitsError, this.toInt);
                    }
                }
                if ((JSGuards.isJavaNumber(arguments0Value)) && (JSGuards.isUndefined(arguments1Value))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 toExponentialPrimitiveUndefined(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toExponentialPrimitiveUndefined(arguments0Value, arguments1Value);
                }
                if ((JSGuards.isJavaNumber(arguments0Value)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                    this.digitsError = this.digitsError == null ? ((BranchProfile.create())) : this.digitsError;
                    this.toInt = super.insert(this.toInt == null ? ((JSToIntegerAsIntNode.create())) : this.toInt);
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 toExponentialPrimitive(Object, Object, BranchProfile, JSToIntegerAsIntNode) */;
                    lock.unlock();
                    hasLock = false;
                    return toExponentialPrimitive(arguments0Value, arguments1Value, this.digitsError, this.toInt);
                }
                if (((exclude & 0b1)) == 0 /* is-not-exclude toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) */) {
                    int count4_ = 0;
                    ToExponentialForeignObjectUndefined0Data s4_ = this.toExponentialForeignObjectUndefined0_cache;
                    if ((state_0 & 0b10000) != 0 /* is-state_0 toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) */) {
                        while (s4_ != null) {
                            if ((s4_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value)) && (JSGuards.isUndefined(arguments1Value))) {
                                break;
                            }
                            s4_ = s4_.next_;
                            count4_++;
                        }
                    }
                    if (s4_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && (JSGuards.isUndefined(arguments1Value)) && count4_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s4_.interop_.accepts(arguments0Value));
                            s4_ = super.insert(new ToExponentialForeignObjectUndefined0Data(toExponentialForeignObjectUndefined0_cache));
                            s4_.interop_ = s4_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.toExponentialForeignObjectUndefined0_cache = s4_;
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) */;
                        }
                    }
                    if (s4_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return toExponentialForeignObjectUndefined(arguments0Value, arguments1Value, s4_.interop_);
                    }
                }
                {
                    InteropLibrary toExponentialForeignObjectUndefined1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value)) && (JSGuards.isUndefined(arguments1Value))) {
                                toExponentialForeignObjectUndefined1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) */;
                                this.toExponentialForeignObjectUndefined0_cache = null;
                                state_0 = state_0 & 0xffffffef /* remove-state_0 toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return toExponentialForeignObjectUndefined(arguments0Value, arguments1Value, toExponentialForeignObjectUndefined1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-exclude toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) */) {
                    int count6_ = 0;
                    ToExponentialForeignObject0Data s6_ = this.toExponentialForeignObject0_cache;
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) */) {
                        while (s6_ != null) {
                            if ((s6_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                                break;
                            }
                            s6_ = s6_.next_;
                            count6_++;
                        }
                    }
                    if (s6_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && (!(JSGuards.isUndefined(arguments1Value))) && count6_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s6_.interop_.accepts(arguments0Value));
                            s6_ = super.insert(new ToExponentialForeignObject0Data(toExponentialForeignObject0_cache));
                            s6_.digitsErrorBranch_ = (BranchProfile.create());
                            s6_.toIntegerNode_ = s6_.insertAccessor((JSToIntegerAsIntNode.create()));
                            s6_.interop_ = s6_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.toExponentialForeignObject0_cache = s6_;
                            this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) */;
                        }
                    }
                    if (s6_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return toExponentialForeignObject(arguments0Value, arguments1Value, s6_.digitsErrorBranch_, s6_.toIntegerNode_, s6_.interop_);
                    }
                }
                {
                    InteropLibrary toExponentialForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                                this.toExponentialForeignObject1_digitsErrorBranch_ = (BranchProfile.create());
                                this.toExponentialForeignObject1_toIntegerNode_ = super.insert((JSToIntegerAsIntNode.create()));
                                toExponentialForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b10 /* add-exclude toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) */;
                                this.toExponentialForeignObject0_cache = null;
                                state_0 = state_0 & 0xffffffbf /* remove-state_0 toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return toExponentialForeignObject(arguments0Value, arguments1Value, this.toExponentialForeignObject1_digitsErrorBranch_, this.toExponentialForeignObject1_toIntegerNode_, toExponentialForeignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSNumber(arguments0Value))) && (!(JSGuards.isJavaNumber(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 toExponentialOther(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toExponentialOther(arguments0Value, arguments1Value);
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
                    ToExponentialForeignObjectUndefined0Data s4_ = this.toExponentialForeignObjectUndefined0_cache;
                    ToExponentialForeignObject0Data s6_ = this.toExponentialForeignObject0_cache;
                    if ((s4_ == null || s4_.next_ == null) && (s6_ == null || s6_.next_ == null)) {
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
            s[0] = "toExponentialUndefined";
            if ((state_0 & 0b1) != 0 /* is-state_0 toExponentialUndefined(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toExponential";
            if ((state_0 & 0b10) != 0 /* is-state_0 toExponential(DynamicObject, Object, BranchProfile, JSToIntegerAsIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.digitsError, this.toInt));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toExponentialPrimitiveUndefined";
            if ((state_0 & 0b100) != 0 /* is-state_0 toExponentialPrimitiveUndefined(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toExponentialPrimitive";
            if ((state_0 & 0b1000) != 0 /* is-state_0 toExponentialPrimitive(Object, Object, BranchProfile, JSToIntegerAsIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.digitsError, this.toInt));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "toExponentialForeignObjectUndefined";
            if ((state_0 & 0b10000) != 0 /* is-state_0 toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ToExponentialForeignObjectUndefined0Data s4_ = this.toExponentialForeignObjectUndefined0_cache;
                while (s4_ != null) {
                    cached.add(Arrays.asList(s4_.interop_));
                    s4_ = s4_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b1) != 0 /* is-exclude toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "toExponentialForeignObjectUndefined";
            if ((state_0 & 0b100000) != 0 /* is-state_0 toExponentialForeignObjectUndefined(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "toExponentialForeignObject";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ToExponentialForeignObject0Data s6_ = this.toExponentialForeignObject0_cache;
                while (s6_ != null) {
                    cached.add(Arrays.asList(s6_.digitsErrorBranch_, s6_.toIntegerNode_, s6_.interop_));
                    s6_ = s6_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b10) != 0 /* is-exclude toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "toExponentialForeignObject";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 toExponentialForeignObject(Object, Object, BranchProfile, JSToIntegerAsIntNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toExponentialForeignObject1_digitsErrorBranch_, this.toExponentialForeignObject1_toIntegerNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "toExponentialOther";
            if ((state_0 & 0b100000000) != 0 /* is-state_0 toExponentialOther(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            return Provider.create(data);
        }

        public static JSNumberToExponentialNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberToExponentialNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSNumberToExponentialNode.class)
        private static final class ToExponentialForeignObjectUndefined0Data extends Node {

            @Child ToExponentialForeignObjectUndefined0Data next_;
            @Child InteropLibrary interop_;

            ToExponentialForeignObjectUndefined0Data(ToExponentialForeignObjectUndefined0Data next_) {
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
        @GeneratedBy(JSNumberToExponentialNode.class)
        private static final class ToExponentialForeignObject0Data extends Node {

            @Child ToExponentialForeignObject0Data next_;
            @CompilationFinal BranchProfile digitsErrorBranch_;
            @Child JSToIntegerAsIntNode toIntegerNode_;
            @Child InteropLibrary interop_;

            ToExponentialForeignObject0Data(ToExponentialForeignObject0Data next_) {
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
    @GeneratedBy(JSNumberToPrecisionNode.class)
    public static final class JSNumberToPrecisionNodeGen extends JSNumberToPrecisionNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private JSToStringNode toString;
        @Child private JSToNumberNode toNumber;
        @Child private ToPrecisionForeignObjectUndefined0Data toPrecisionForeignObjectUndefined0_cache;
        @Child private JSToStringNode toPrecisionForeignObjectUndefined1_toStringNode_;
        @Child private ToPrecisionForeignObject0Data toPrecisionForeignObject0_cache;
        @Child private JSToNumberNode toPrecisionForeignObject1_toNumberNode_;

        private JSNumberToPrecisionNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 toPrecisionUndefined(DynamicObject, Object, JSToStringNode) || toPrecision(DynamicObject, Object, JSToNumberNode) || toPrecisionPrimitiveUndefined(Object, Object, JSToStringNode) || toPrecisionPrimitive(Object, Object, JSToNumberNode) || toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) || toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) || toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) || toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) || toPrecisionOther(Object, Object) */) {
                if ((state_0 & 0b11) != 0 /* is-state_0 toPrecisionUndefined(DynamicObject, Object, JSToStringNode) || toPrecision(DynamicObject, Object, JSToNumberNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 toPrecisionUndefined(DynamicObject, Object, JSToStringNode) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return toPrecisionUndefined(arguments0Value__, arguments1Value_, this.toString);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 toPrecision(DynamicObject, Object, JSToNumberNode) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return toPrecision(arguments0Value__, arguments1Value_, this.toNumber);
                        }
                    }
                }
                if ((state_0 & 0b111111100) != 0 /* is-state_0 toPrecisionPrimitiveUndefined(Object, Object, JSToStringNode) || toPrecisionPrimitive(Object, Object, JSToNumberNode) || toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) || toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) || toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) || toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) || toPrecisionOther(Object, Object) */) {
                    if ((state_0 & 0b100) != 0 /* is-state_0 toPrecisionPrimitiveUndefined(Object, Object, JSToStringNode) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return toPrecisionPrimitiveUndefined(arguments0Value_, arguments1Value_, this.toString);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 toPrecisionPrimitive(Object, Object, JSToNumberNode) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return toPrecisionPrimitive(arguments0Value_, arguments1Value_, this.toNumber);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) */) {
                        ToPrecisionForeignObjectUndefined0Data s4_ = this.toPrecisionForeignObjectUndefined0_cache;
                        while (s4_ != null) {
                            if ((s4_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                                return toPrecisionForeignObjectUndefined(arguments0Value_, arguments1Value_, s4_.toStringNode_, s4_.interop_);
                            }
                            s4_ = s4_.next_;
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return this.toPrecisionForeignObjectUndefined1Boundary(state_0, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) */) {
                        ToPrecisionForeignObject0Data s6_ = this.toPrecisionForeignObject0_cache;
                        while (s6_ != null) {
                            if ((s6_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                                return toPrecisionForeignObject(arguments0Value_, arguments1Value_, s6_.toNumberNode_, s6_.interop_);
                            }
                            s6_ = s6_.next_;
                        }
                    }
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return this.toPrecisionForeignObject1Boundary(state_0, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b100000000) != 0 /* is-state_0 toPrecisionOther(Object, Object) */) {
                        if ((!(JSGuards.isJSNumber(arguments0Value_))) && (!(JSGuards.isJavaNumber(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return toPrecisionOther(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object toPrecisionForeignObjectUndefined1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary toPrecisionForeignObjectUndefined1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return toPrecisionForeignObjectUndefined(arguments0Value_, arguments1Value_, this.toPrecisionForeignObjectUndefined1_toStringNode_, toPrecisionForeignObjectUndefined1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object toPrecisionForeignObject1Boundary(int state_0, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary toPrecisionForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return toPrecisionForeignObject(arguments0Value_, arguments1Value_, this.toPrecisionForeignObject1_toNumberNode_, toPrecisionForeignObject1_interop__);
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

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value))) {
                        this.toString = super.insert(this.toString == null ? ((JSToStringNode.create())) : this.toString);
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 toPrecisionUndefined(DynamicObject, Object, JSToStringNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toPrecisionUndefined(arguments0Value_, arguments1Value, this.toString);
                    }
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                        this.toNumber = super.insert(this.toNumber == null ? ((JSToNumberNode.create())) : this.toNumber);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 toPrecision(DynamicObject, Object, JSToNumberNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toPrecision(arguments0Value_, arguments1Value, this.toNumber);
                    }
                }
                if ((JSGuards.isJavaNumber(arguments0Value)) && (JSGuards.isUndefined(arguments1Value))) {
                    this.toString = super.insert(this.toString == null ? ((JSToStringNode.create())) : this.toString);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 toPrecisionPrimitiveUndefined(Object, Object, JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return toPrecisionPrimitiveUndefined(arguments0Value, arguments1Value, this.toString);
                }
                if ((JSGuards.isJavaNumber(arguments0Value)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                    this.toNumber = super.insert(this.toNumber == null ? ((JSToNumberNode.create())) : this.toNumber);
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 toPrecisionPrimitive(Object, Object, JSToNumberNode) */;
                    lock.unlock();
                    hasLock = false;
                    return toPrecisionPrimitive(arguments0Value, arguments1Value, this.toNumber);
                }
                if (((exclude & 0b1)) == 0 /* is-not-exclude toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) */) {
                    int count4_ = 0;
                    ToPrecisionForeignObjectUndefined0Data s4_ = this.toPrecisionForeignObjectUndefined0_cache;
                    if ((state_0 & 0b10000) != 0 /* is-state_0 toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) */) {
                        while (s4_ != null) {
                            if ((s4_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value)) && (JSGuards.isUndefined(arguments1Value))) {
                                break;
                            }
                            s4_ = s4_.next_;
                            count4_++;
                        }
                    }
                    if (s4_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && (JSGuards.isUndefined(arguments1Value)) && count4_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s4_.interop_.accepts(arguments0Value));
                            s4_ = super.insert(new ToPrecisionForeignObjectUndefined0Data(toPrecisionForeignObjectUndefined0_cache));
                            s4_.toStringNode_ = s4_.insertAccessor((JSToStringNode.create()));
                            s4_.interop_ = s4_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.toPrecisionForeignObjectUndefined0_cache = s4_;
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) */;
                        }
                    }
                    if (s4_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return toPrecisionForeignObjectUndefined(arguments0Value, arguments1Value, s4_.toStringNode_, s4_.interop_);
                    }
                }
                {
                    InteropLibrary toPrecisionForeignObjectUndefined1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value)) && (JSGuards.isUndefined(arguments1Value))) {
                                this.toPrecisionForeignObjectUndefined1_toStringNode_ = super.insert((JSToStringNode.create()));
                                toPrecisionForeignObjectUndefined1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) */;
                                this.toPrecisionForeignObjectUndefined0_cache = null;
                                state_0 = state_0 & 0xffffffef /* remove-state_0 toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return toPrecisionForeignObjectUndefined(arguments0Value, arguments1Value, this.toPrecisionForeignObjectUndefined1_toStringNode_, toPrecisionForeignObjectUndefined1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-exclude toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) */) {
                    int count6_ = 0;
                    ToPrecisionForeignObject0Data s6_ = this.toPrecisionForeignObject0_cache;
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) */) {
                        while (s6_ != null) {
                            if ((s6_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                                break;
                            }
                            s6_ = s6_.next_;
                            count6_++;
                        }
                    }
                    if (s6_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && (!(JSGuards.isUndefined(arguments1Value))) && count6_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s6_.interop_.accepts(arguments0Value));
                            s6_ = super.insert(new ToPrecisionForeignObject0Data(toPrecisionForeignObject0_cache));
                            s6_.toNumberNode_ = s6_.insertAccessor((JSToNumberNode.create()));
                            s6_.interop_ = s6_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.toPrecisionForeignObject0_cache = s6_;
                            this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) */;
                        }
                    }
                    if (s6_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return toPrecisionForeignObject(arguments0Value, arguments1Value, s6_.toNumberNode_, s6_.interop_);
                    }
                }
                {
                    InteropLibrary toPrecisionForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                                this.toPrecisionForeignObject1_toNumberNode_ = super.insert((JSToNumberNode.create()));
                                toPrecisionForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b10 /* add-exclude toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) */;
                                this.toPrecisionForeignObject0_cache = null;
                                state_0 = state_0 & 0xffffffbf /* remove-state_0 toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return toPrecisionForeignObject(arguments0Value, arguments1Value, this.toPrecisionForeignObject1_toNumberNode_, toPrecisionForeignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSNumber(arguments0Value))) && (!(JSGuards.isJavaNumber(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 toPrecisionOther(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toPrecisionOther(arguments0Value, arguments1Value);
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
                    ToPrecisionForeignObjectUndefined0Data s4_ = this.toPrecisionForeignObjectUndefined0_cache;
                    ToPrecisionForeignObject0Data s6_ = this.toPrecisionForeignObject0_cache;
                    if ((s4_ == null || s4_.next_ == null) && (s6_ == null || s6_.next_ == null)) {
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
            s[0] = "toPrecisionUndefined";
            if ((state_0 & 0b1) != 0 /* is-state_0 toPrecisionUndefined(DynamicObject, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toString));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toPrecision";
            if ((state_0 & 0b10) != 0 /* is-state_0 toPrecision(DynamicObject, Object, JSToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toNumber));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toPrecisionPrimitiveUndefined";
            if ((state_0 & 0b100) != 0 /* is-state_0 toPrecisionPrimitiveUndefined(Object, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toString));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toPrecisionPrimitive";
            if ((state_0 & 0b1000) != 0 /* is-state_0 toPrecisionPrimitive(Object, Object, JSToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toNumber));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "toPrecisionForeignObjectUndefined";
            if ((state_0 & 0b10000) != 0 /* is-state_0 toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ToPrecisionForeignObjectUndefined0Data s4_ = this.toPrecisionForeignObjectUndefined0_cache;
                while (s4_ != null) {
                    cached.add(Arrays.asList(s4_.toStringNode_, s4_.interop_));
                    s4_ = s4_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b1) != 0 /* is-exclude toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "toPrecisionForeignObjectUndefined";
            if ((state_0 & 0b100000) != 0 /* is-state_0 toPrecisionForeignObjectUndefined(Object, Object, JSToStringNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toPrecisionForeignObjectUndefined1_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "toPrecisionForeignObject";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ToPrecisionForeignObject0Data s6_ = this.toPrecisionForeignObject0_cache;
                while (s6_ != null) {
                    cached.add(Arrays.asList(s6_.toNumberNode_, s6_.interop_));
                    s6_ = s6_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b10) != 0 /* is-exclude toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "toPrecisionForeignObject";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 toPrecisionForeignObject(Object, Object, JSToNumberNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toPrecisionForeignObject1_toNumberNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "toPrecisionOther";
            if ((state_0 & 0b100000000) != 0 /* is-state_0 toPrecisionOther(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            return Provider.create(data);
        }

        public static JSNumberToPrecisionNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberToPrecisionNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSNumberToPrecisionNode.class)
        private static final class ToPrecisionForeignObjectUndefined0Data extends Node {

            @Child ToPrecisionForeignObjectUndefined0Data next_;
            @Child JSToStringNode toStringNode_;
            @Child InteropLibrary interop_;

            ToPrecisionForeignObjectUndefined0Data(ToPrecisionForeignObjectUndefined0Data next_) {
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
        @GeneratedBy(JSNumberToPrecisionNode.class)
        private static final class ToPrecisionForeignObject0Data extends Node {

            @Child ToPrecisionForeignObject0Data next_;
            @Child JSToNumberNode toNumberNode_;
            @Child InteropLibrary interop_;

            ToPrecisionForeignObject0Data(ToPrecisionForeignObject0Data next_) {
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
}
