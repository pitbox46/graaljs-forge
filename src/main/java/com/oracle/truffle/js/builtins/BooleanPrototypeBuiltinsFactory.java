// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.BooleanPrototypeBuiltins.JSBooleanToStringNode;
import com.oracle.truffle.js.builtins.BooleanPrototypeBuiltins.JSBooleanValueOfNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(BooleanPrototypeBuiltins.class)
@SuppressWarnings("unused")
public final class BooleanPrototypeBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(JSBooleanToStringNode.class)
    public static final class JSBooleanToStringNodeGen extends JSBooleanToStringNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ToStringForeignObject0Data toStringForeignObject0_cache;

        private JSBooleanToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 toString(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSBoolean(arguments0Value__))) {
                    return toString(arguments0Value__);
                }
            }
            if ((state_0 & 0b11110) != 0 /* is-state_0 toStringPrimitive(Object) || toStringForeignObject(Object, InteropLibrary) || toStringForeignObject(Object, InteropLibrary) || toStringOther(Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 toStringPrimitive(Object) */) {
                    if ((JSGuards.isBoolean(arguments0Value_))) {
                        return toStringPrimitive(arguments0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 toStringForeignObject(Object, InteropLibrary) */) {
                    ToStringForeignObject0Data s2_ = this.toStringForeignObject0_cache;
                    while (s2_ != null) {
                        if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return toStringForeignObject(arguments0Value_, s2_.interop_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 toStringForeignObject(Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return this.toStringForeignObject1Boundary(state_0, arguments0Value_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 toStringOther(Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_)) {
                        return toStringOther(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object toStringForeignObject1Boundary(int state_0, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary toStringForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return toStringForeignObject(arguments0Value_, toStringForeignObject1_interop__);
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
                    if ((JSGuards.isJSBoolean(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 toString(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return toString(arguments0Value_);
                    }
                }
                if ((JSGuards.isBoolean(arguments0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 toStringPrimitive(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toStringPrimitive(arguments0Value);
                }
                if ((exclude) == 0 /* is-not-exclude toStringForeignObject(Object, InteropLibrary) */) {
                    int count2_ = 0;
                    ToStringForeignObject0Data s2_ = this.toStringForeignObject0_cache;
                    if ((state_0 & 0b100) != 0 /* is-state_0 toStringForeignObject(Object, InteropLibrary) */) {
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
                            s2_ = super.insert(new ToStringForeignObject0Data(toStringForeignObject0_cache));
                            s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            MemoryFence.storeStore();
                            this.toStringForeignObject0_cache = s2_;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 toStringForeignObject(Object, InteropLibrary) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return toStringForeignObject(arguments0Value, s2_.interop_);
                    }
                }
                {
                    InteropLibrary toStringForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                toStringForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude toStringForeignObject(Object, InteropLibrary) */;
                                this.toStringForeignObject0_cache = null;
                                state_0 = state_0 & 0xfffffffb /* remove-state_0 toStringForeignObject(Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 toStringForeignObject(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return toStringForeignObject(arguments0Value, toStringForeignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 toStringOther(Object) */;
                lock.unlock();
                hasLock = false;
                return toStringOther(arguments0Value);
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
                    ToStringForeignObject0Data s2_ = this.toStringForeignObject0_cache;
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
            s[0] = "toString";
            if ((state_0 & 0b1) != 0 /* is-state_0 toString(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toStringPrimitive";
            if ((state_0 & 0b10) != 0 /* is-state_0 toStringPrimitive(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toStringForeignObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 toStringForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ToStringForeignObject0Data s2_ = this.toStringForeignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude toStringForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toStringForeignObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 toStringForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "toStringOther";
            if ((state_0 & 0b10000) != 0 /* is-state_0 toStringOther(Object) */) {
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
                if ((JSGuards.isJSBoolean(arguments0Value_))) {
                    return false;
                }
            }
            if (((state_0 & 0b10)) == 0 /* is-not-state_0 toStringPrimitive(Object) */ && (JSGuards.isBoolean(arguments0Value))) {
                return false;
            }
            if (((state_0 & 0b1000)) == 0 /* is-not-state_0 toStringForeignObject(Object, InteropLibrary) */ && (JSGuards.isForeignObject(arguments0Value))) {
                return false;
            }
            return true;
        }

        public static JSBooleanToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSBooleanToStringNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSBooleanToStringNode.class)
        private static final class ToStringForeignObject0Data extends Node {

            @Child ToStringForeignObject0Data next_;
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
    @GeneratedBy(JSBooleanValueOfNode.class)
    public static final class JSBooleanValueOfNodeGen extends JSBooleanValueOfNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ValueOfForeignObject0Data valueOfForeignObject0_cache;

        private JSBooleanValueOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
                if ((JSGuards.isJSBoolean(arguments0Value__))) {
                    return valueOf(arguments0Value__);
                }
            }
            if ((state_0 & 0b11110) != 0 /* is-state_0 valueOfPrimitive(Object) || valueOfForeignObject(Object, InteropLibrary) || valueOfForeignObject(Object, InteropLibrary) || valueOfOther(Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 valueOfPrimitive(Object) */) {
                    if ((JSGuards.isBoolean(arguments0Value_))) {
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
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 valueOf(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSBoolean(arguments0Value__))) {
                    return valueOf(arguments0Value__);
                }
            }
            if ((state_0 & 0b11110) != 0 /* is-state_0 valueOfPrimitive(Object) || valueOfForeignObject(Object, InteropLibrary) || valueOfForeignObject(Object, InteropLibrary) || valueOfOther(Object) */) {
                if ((state_0 & 0b10) != 0 /* is-state_0 valueOfPrimitive(Object) */) {
                    if ((JSGuards.isBoolean(arguments0Value_))) {
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
        private boolean valueOfForeignObject1Boundary0(int state_0, Object arguments0Value_) {
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSBoolean(arguments0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 valueOf(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return valueOf(arguments0Value_);
                    }
                }
                if ((JSGuards.isBoolean(arguments0Value))) {
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
                if ((JSGuards.isJSBoolean(arguments0Value_))) {
                    return false;
                }
            }
            if (((state_0 & 0b10)) == 0 /* is-not-state_0 valueOfPrimitive(Object) */ && (JSGuards.isBoolean(arguments0Value))) {
                return false;
            }
            if (((state_0 & 0b1000)) == 0 /* is-not-state_0 valueOfForeignObject(Object, InteropLibrary) */ && (JSGuards.isForeignObject(arguments0Value))) {
                return false;
            }
            return true;
        }

        public static JSBooleanValueOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSBooleanValueOfNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSBooleanValueOfNode.class)
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
}
