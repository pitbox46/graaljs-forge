// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.JSONBuiltins.JSONParseNode;
import com.oracle.truffle.js.builtins.JSONBuiltins.JSONStringifyNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.util.StringBuilderProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSONBuiltins.class)
public final class JSONBuiltinsFactory {

    @GeneratedBy(JSONParseNode.class)
    public static final class JSONParseNodeGen extends JSONParseNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private IsCallableNode isCallable;

        private JSONParseNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 parse(Object, Object, IsCallableNode) || parseUnfiltered(Object, Object, IsCallableNode) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 parse(Object, Object, IsCallableNode) */) {
                    if ((this.isCallable.executeBoolean(arguments1Value_))) {
                        return parse(arguments0Value_, arguments1Value_, this.isCallable);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 parseUnfiltered(Object, Object, IsCallableNode) */) {
                    if ((!(this.isCallable.executeBoolean(arguments1Value_)))) {
                        return parseUnfiltered(arguments0Value_, arguments1Value_, this.isCallable);
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
                boolean Parse_duplicateFound_ = false;
                if ((state_0 & 0b1) != 0 /* is-state_0 parse(Object, Object, IsCallableNode) */) {
                    if ((this.isCallable.executeBoolean(arguments1Value))) {
                        Parse_duplicateFound_ = true;
                    }
                }
                if (!Parse_duplicateFound_) {
                    {
                        IsCallableNode parse_isCallable__ = super.insert(this.isCallable == null ? ((IsCallableNode.create())) : this.isCallable);
                        if ((parse_isCallable__.executeBoolean(arguments1Value)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 parse(Object, Object, IsCallableNode) */) {
                            if (this.isCallable == null) {
                                IsCallableNode parse_isCallable___check = super.insert(parse_isCallable__);
                                if (parse_isCallable___check == null) {
                                    throw new AssertionError("Specialization 'parse(Object, Object, IsCallableNode)' contains a shared cache with name 'isCallable' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                }
                                this.isCallable = parse_isCallable___check;
                            }
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 parse(Object, Object, IsCallableNode) */;
                            Parse_duplicateFound_ = true;
                        }
                    }
                }
                if (Parse_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return parse(arguments0Value, arguments1Value, this.isCallable);
                }
                boolean ParseUnfiltered_duplicateFound_ = false;
                if ((state_0 & 0b10) != 0 /* is-state_0 parseUnfiltered(Object, Object, IsCallableNode) */) {
                    if ((!(this.isCallable.executeBoolean(arguments1Value)))) {
                        ParseUnfiltered_duplicateFound_ = true;
                    }
                }
                if (!ParseUnfiltered_duplicateFound_) {
                    {
                        IsCallableNode parseUnfiltered_isCallable__ = super.insert(this.isCallable == null ? ((IsCallableNode.create())) : this.isCallable);
                        if ((!(parseUnfiltered_isCallable__.executeBoolean(arguments1Value))) && ((state_0 & 0b10)) == 0 /* is-not-state_0 parseUnfiltered(Object, Object, IsCallableNode) */) {
                            if (this.isCallable == null) {
                                IsCallableNode parseUnfiltered_isCallable___check = super.insert(parseUnfiltered_isCallable__);
                                if (parseUnfiltered_isCallable___check == null) {
                                    throw new AssertionError("Specialization 'parseUnfiltered(Object, Object, IsCallableNode)' contains a shared cache with name 'isCallable' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                }
                                this.isCallable = parseUnfiltered_isCallable___check;
                            }
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 parseUnfiltered(Object, Object, IsCallableNode) */;
                            ParseUnfiltered_duplicateFound_ = true;
                        }
                    }
                }
                if (ParseUnfiltered_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return parseUnfiltered(arguments0Value, arguments1Value, this.isCallable);
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
            s[0] = "parse";
            if ((state_0 & 0b1) != 0 /* is-state_0 parse(Object, Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "parseUnfiltered";
            if ((state_0 & 0b10) != 0 /* is-state_0 parseUnfiltered(Object, Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSONParseNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSONParseNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSONStringifyNode.class)
    public static final class JSONStringifyNodeGen extends JSONStringifyNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private StringBuilderProfile stringifyAStringNoReplacer_stringBuilderProfile_;

        private JSONStringifyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 stringify(Object, DynamicObject, Object) || stringifyReplacerArray(Object, DynamicObject, Object) || stringifyAStringNoReplacer(Object, Object, Object, StringBuilderProfile) || stringifyNoReplacer(Object, Object, Object) */) {
                if ((state_0 & 0b11) != 0 /* is-state_0 stringify(Object, DynamicObject, Object) || stringifyReplacerArray(Object, DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 stringify(Object, DynamicObject, Object) */) {
                        if ((isCallable(arguments1Value__))) {
                            return stringify(arguments0Value_, arguments1Value__, arguments2Value_);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 stringifyReplacerArray(Object, DynamicObject, Object) */) {
                        if ((isArray(arguments1Value__))) {
                            return stringifyReplacerArray(arguments0Value_, arguments1Value__, arguments2Value_);
                        }
                    }
                }
                if ((state_0 & 0b1100) != 0 /* is-state_0 stringifyAStringNoReplacer(Object, Object, Object, StringBuilderProfile) || stringifyNoReplacer(Object, Object, Object) */) {
                    if ((state_0 & 0b100) != 0 /* is-state_0 stringifyAStringNoReplacer(Object, Object, Object, StringBuilderProfile) */) {
                        if ((JSGuards.isString(arguments0Value_)) && (!(isCallable(arguments1Value_))) && (!(isArray(arguments1Value_)))) {
                            return stringifyAStringNoReplacer(arguments0Value_, arguments1Value_, arguments2Value_, this.stringifyAStringNoReplacer_stringBuilderProfile_);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 stringifyNoReplacer(Object, Object, Object) */) {
                        if ((!(JSGuards.isString(arguments0Value_))) && (!(isCallable(arguments1Value_))) && (!(isArray(arguments1Value_)))) {
                            return stringifyNoReplacer(arguments0Value_, arguments1Value_, arguments2Value_);
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
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if ((isCallable(arguments1Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 stringify(Object, DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return stringify(arguments0Value, arguments1Value_, arguments2Value);
                    }
                    if ((isArray(arguments1Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 stringifyReplacerArray(Object, DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return stringifyReplacerArray(arguments0Value, arguments1Value_, arguments2Value);
                    }
                }
                if ((JSGuards.isString(arguments0Value)) && (!(isCallable(arguments1Value))) && (!(isArray(arguments1Value)))) {
                    this.stringifyAStringNoReplacer_stringBuilderProfile_ = (createStringBuilderProfile());
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 stringifyAStringNoReplacer(Object, Object, Object, StringBuilderProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return stringifyAStringNoReplacer(arguments0Value, arguments1Value, arguments2Value, this.stringifyAStringNoReplacer_stringBuilderProfile_);
                }
                if ((!(JSGuards.isString(arguments0Value))) && (!(isCallable(arguments1Value))) && (!(isArray(arguments1Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 stringifyNoReplacer(Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return stringifyNoReplacer(arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "stringify";
            if ((state_0 & 0b1) != 0 /* is-state_0 stringify(Object, DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "stringifyReplacerArray";
            if ((state_0 & 0b10) != 0 /* is-state_0 stringifyReplacerArray(Object, DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "stringifyAStringNoReplacer";
            if ((state_0 & 0b100) != 0 /* is-state_0 stringifyAStringNoReplacer(Object, Object, Object, StringBuilderProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.stringifyAStringNoReplacer_stringBuilderProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "stringifyNoReplacer";
            if ((state_0 & 0b1000) != 0 /* is-state_0 stringifyNoReplacer(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSONStringifyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSONStringifyNodeGen(context, builtin, arguments);
        }

    }
}
