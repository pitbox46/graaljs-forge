// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.ArraySpeciesConstructorNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.CompiledRegexFlagPropertyAccessor;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.CompiledRegexPatternAccessor;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpCompileNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpExecES5Node;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpExecNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpMatchAllNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpMatchNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpReplaceNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpSearchNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpSplitNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpTestNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpToStringNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.RegExpFlagsGetterNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.CreateRegExpStringIteratorNode;
import com.oracle.truffle.js.builtins.helper.JSRegExpExecIntlNode;
import com.oracle.truffle.js.builtins.helper.ReplaceStringParser.Token;
import com.oracle.truffle.js.nodes.CompileRegexNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.IsJSObjectNode;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.access.PropertySetNode;
import com.oracle.truffle.js.nodes.cast.JSToLengthNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSRegExp;
import com.oracle.truffle.js.runtime.builtins.JSRegExpObject;
import com.oracle.truffle.js.runtime.util.TRegexUtil.TRegexCompiledRegexAccessor;
import com.oracle.truffle.js.runtime.util.TRegexUtil.TRegexFlagsAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RegExpPrototypeBuiltins.class)
@SuppressWarnings("unused")
public final class RegExpPrototypeBuiltinsFactory {

    @GeneratedBy(JSRegExpCompileNode.class)
    public static final class JSRegExpCompileNodeGen extends JSRegExpCompileNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private CompileData compile_cache;

        private JSRegExpCompileNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 compile(JSRegExpObject, Object, Object, CompileRegexNode, JSToStringNode, ConditionProfile, TRegexCompiledRegexAccessor, TRegexFlagsAccessor) || compile(Object, Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 compile(JSRegExpObject, Object, Object, CompileRegexNode, JSToStringNode, ConditionProfile, TRegexCompiledRegexAccessor, TRegexFlagsAccessor) */ && arguments0Value_ instanceof JSRegExpObject) {
                    JSRegExpObject arguments0Value__ = (JSRegExpObject) arguments0Value_;
                    CompileData s0_ = this.compile_cache;
                    if (s0_ != null) {
                        return compile(arguments0Value__, arguments1Value_, arguments2Value_, s0_.compileRegexNode_, s0_.toStringNode_, s0_.isRegExpProfile_, s0_.compiledRegexAccessor_, s0_.flagsAccessor_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 compile(Object, Object, Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_, arguments2Value_)) {
                        return compile(arguments0Value_, arguments1Value_, arguments2Value_);
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
                if (arguments0Value instanceof JSRegExpObject) {
                    JSRegExpObject arguments0Value_ = (JSRegExpObject) arguments0Value;
                    CompileData s0_ = super.insert(new CompileData());
                    s0_.compileRegexNode_ = s0_.insertAccessor((CompileRegexNode.create(getContext())));
                    s0_.toStringNode_ = s0_.insertAccessor((JSToStringNode.createUndefinedToEmpty()));
                    s0_.isRegExpProfile_ = (ConditionProfile.createBinaryProfile());
                    s0_.compiledRegexAccessor_ = s0_.insertAccessor((TRegexCompiledRegexAccessor.create()));
                    s0_.flagsAccessor_ = s0_.insertAccessor((TRegexFlagsAccessor.create()));
                    MemoryFence.storeStore();
                    this.compile_cache = s0_;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 compile(JSRegExpObject, Object, Object, CompileRegexNode, JSToStringNode, ConditionProfile, TRegexCompiledRegexAccessor, TRegexFlagsAccessor) */;
                    lock.unlock();
                    hasLock = false;
                    return compile(arguments0Value_, arguments1Value, arguments2Value, s0_.compileRegexNode_, s0_.toStringNode_, s0_.isRegExpProfile_, s0_.compiledRegexAccessor_, s0_.flagsAccessor_);
                }
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 compile(Object, Object, Object) */;
                lock.unlock();
                hasLock = false;
                return compile(arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "compile";
            if ((state_0 & 0b1) != 0 /* is-state_0 compile(JSRegExpObject, Object, Object, CompileRegexNode, JSToStringNode, ConditionProfile, TRegexCompiledRegexAccessor, TRegexFlagsAccessor) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CompileData s0_ = this.compile_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.compileRegexNode_, s0_.toStringNode_, s0_.isRegExpProfile_, s0_.compiledRegexAccessor_, s0_.flagsAccessor_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "compile";
            if ((state_0 & 0b10) != 0 /* is-state_0 compile(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            if (((state_0 & 0b1)) == 0 /* is-not-state_0 compile(JSRegExpObject, Object, Object, CompileRegexNode, JSToStringNode, ConditionProfile, TRegexCompiledRegexAccessor, TRegexFlagsAccessor) */ && arguments0Value instanceof JSRegExpObject) {
                return false;
            }
            return true;
        }

        public static JSRegExpCompileNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpCompileNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSRegExpCompileNode.class)
        private static final class CompileData extends Node {

            @Child CompileRegexNode compileRegexNode_;
            @Child JSToStringNode toStringNode_;
            @CompilationFinal ConditionProfile isRegExpProfile_;
            @Child TRegexCompiledRegexAccessor compiledRegexAccessor_;
            @Child TRegexFlagsAccessor flagsAccessor_;

            CompileData() {
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
    @GeneratedBy(JSRegExpExecNode.class)
    public static final class JSRegExpExecNodeGen extends JSRegExpExecNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private JSToStringNode object_toStringNode_;

        private JSRegExpExecNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b11) != 0 /* is-state_0 doString(JSRegExpObject, String) || doObject(JSRegExpObject, Object, JSToStringNode) */ && arguments0Value_ instanceof JSRegExpObject) {
                JSRegExpObject arguments0Value__ = (JSRegExpObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doString(JSRegExpObject, String) */ && JSTypesGen.isImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 1:String */, arguments1Value_);
                    return doString(arguments0Value__, arguments1Value__);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doObject(JSRegExpObject, Object, JSToStringNode) */) {
                    return doObject(arguments0Value__, arguments1Value_, this.object_toStringNode_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doNoRegExp(Object, Object) */) {
                if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_)) {
                    return doNoRegExp(arguments0Value_, arguments1Value_);
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
                if (arguments0Value instanceof JSRegExpObject) {
                    JSRegExpObject arguments0Value_ = (JSRegExpObject) arguments0Value;
                    if ((exclude) == 0 /* is-not-exclude doString(JSRegExpObject, String) */) {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            state_0 = (state_0 | (stringCast1 << 3) /* set-implicit-state_0 1:String */);
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doString(JSRegExpObject, String) */;
                            lock.unlock();
                            hasLock = false;
                            return doString(arguments0Value_, arguments1Value_);
                        }
                    }
                    this.object_toStringNode_ = super.insert((JSToStringNode.create()));
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doString(JSRegExpObject, String) */;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doString(JSRegExpObject, String) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doObject(JSRegExpObject, Object, JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doObject(arguments0Value_, arguments1Value, this.object_toStringNode_);
                }
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doNoRegExp(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return doNoRegExp(arguments0Value, arguments1Value);
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
            s[0] = "doString";
            if ((state_0 & 0b1) != 0 /* is-state_0 doString(JSRegExpObject, String) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-exclude doString(JSRegExpObject, String) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 doObject(JSRegExpObject, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doNoRegExp";
            if ((state_0 & 0b100) != 0 /* is-state_0 doNoRegExp(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value) {
            if (((state_0 & 0b10)) == 0 /* is-not-state_0 doObject(JSRegExpObject, Object, JSToStringNode) */ && arguments0Value instanceof JSRegExpObject) {
                return false;
            }
            return true;
        }

        public static JSRegExpExecNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpExecNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpExecES5Node.class)
    public static final class JSRegExpExecES5NodeGen extends JSRegExpExecES5Node implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private JSRegExpExecES5NodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 exec(JSRegExpObject, Object) || exec(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 exec(JSRegExpObject, Object) */ && arguments0Value_ instanceof JSRegExpObject) {
                    JSRegExpObject arguments0Value__ = (JSRegExpObject) arguments0Value_;
                    return exec(arguments0Value__, arguments1Value_);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 exec(Object, Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_)) {
                        return exec(arguments0Value_, arguments1Value_);
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
            if (arguments0Value instanceof JSRegExpObject) {
                JSRegExpObject arguments0Value_ = (JSRegExpObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 exec(JSRegExpObject, Object) */;
                return exec(arguments0Value_, arguments1Value);
            }
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 exec(Object, Object) */;
            return exec(arguments0Value, arguments1Value);
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
            s[0] = "exec";
            if ((state_0 & 0b1) != 0 /* is-state_0 exec(JSRegExpObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "exec";
            if ((state_0 & 0b10) != 0 /* is-state_0 exec(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value) {
            if (((state_0 & 0b1)) == 0 /* is-not-state_0 exec(JSRegExpObject, Object) */ && arguments0Value instanceof JSRegExpObject) {
                return false;
            }
            return true;
        }

        public static JSRegExpExecES5Node create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpExecES5NodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpTestNode.class)
    public static final class JSRegExpTestNodeGen extends JSRegExpTestNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private TestGenericData testGeneric_cache;

        private JSRegExpTestNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        private boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((((state_0 & 0b10)) == 0 /* is-not-state_0 Guard[(isObjectNode.executeBoolean(thisObj))] */ || (this.testGeneric_cache.isObjectNode_.executeBoolean(arguments0Value_)))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b101) != 0 /* is-state_0 testGeneric(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSRegExpExecIntlNode) || testError(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 testGeneric(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSRegExpExecIntlNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    TestGenericData s0_ = this.testGeneric_cache;
                    if (s0_ != null) {
                        if ((s0_.isObjectNode_.executeBoolean(arguments0Value__))) {
                            return testGeneric(arguments0Value__, arguments1Value_, s0_.isObjectNode_, s0_.toStringNode_, s0_.regExpNode_);
                        }
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 testError(Object, Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_)) {
                        return testError(arguments0Value_, arguments1Value_);
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
                    TestGenericData s0_ = this.testGeneric_cache;
                    boolean TestGeneric_duplicateFound_ = false;
                    if ((state_0 & 0b1) != 0 /* is-state_0 testGeneric(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSRegExpExecIntlNode) */) {
                        if ((s0_.isObjectNode_.executeBoolean(arguments0Value_))) {
                            TestGeneric_duplicateFound_ = true;
                        }
                    }
                    if (!TestGeneric_duplicateFound_) {
                        {
                            if (((state_0 & 0b10)) == 0 /* is-not-state_0 Guard[(isObjectNode.executeBoolean(thisObj))] */) {
                                s0_ = super.insert(new TestGenericData());
                                MemoryFence.storeStore();
                                this.testGeneric_cache = s0_;
                                s0_.isObjectNode_ = s0_.insertAccessor((IsJSObjectNode.create()));
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 Guard[(isObjectNode.executeBoolean(thisObj))] */;
                            }
                            if ((s0_.isObjectNode_.executeBoolean(arguments0Value_)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 testGeneric(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSRegExpExecIntlNode) */) {
                                s0_ = super.insert(new TestGenericData());
                                s0_.isObjectNode_ = s0_.insertAccessor((IsJSObjectNode.create()));
                                s0_.toStringNode_ = s0_.insertAccessor((JSToStringNode.create()));
                                s0_.regExpNode_ = s0_.insertAccessor((JSRegExpExecIntlNode.create(getContext())));
                                MemoryFence.storeStore();
                                this.testGeneric_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 testGeneric(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSRegExpExecIntlNode) */;
                                TestGeneric_duplicateFound_ = true;
                            }
                        }
                    }
                    if (TestGeneric_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return testGeneric(arguments0Value_, arguments1Value, s0_.isObjectNode_, s0_.toStringNode_, s0_.regExpNode_);
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 testError(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return testError(arguments0Value, arguments1Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b101) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b101) & ((state_0 & 0b101) - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "testGeneric";
            if ((state_0 & 0b1) != 0 /* is-state_0 testGeneric(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSRegExpExecIntlNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                TestGenericData s0_ = this.testGeneric_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.isObjectNode_, s0_.toStringNode_, s0_.regExpNode_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "testError";
            if ((state_0 & 0b100) != 0 /* is-state_0 testError(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpTestNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpTestNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSRegExpTestNode.class)
        private static final class TestGenericData extends Node {

            @Child IsJSObjectNode isObjectNode_;
            @Child JSToStringNode toStringNode_;
            @Child JSRegExpExecIntlNode regExpNode_;

            TestGenericData() {
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
    @GeneratedBy(JSRegExpToStringNode.class)
    public static final class JSRegExpToStringNodeGen extends JSRegExpToStringNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private ToStringData toString_cache;

        private JSRegExpToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        private boolean fallbackGuard_(int state_0, Object arguments0Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((((state_0 & 0b10)) == 0 /* is-not-state_0 Guard[(isObjectNode.executeBoolean(thisObj))] */ || (this.toString_cache.isObjectNode_.executeBoolean(arguments0Value_)))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 toString(DynamicObject, IsJSObjectNode, JSToStringNode, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                ToStringData s0_ = this.toString_cache;
                if (s0_ != null) {
                    if ((s0_.isObjectNode_.executeBoolean(arguments0Value__))) {
                        return toString(arguments0Value__, s0_.isObjectNode_, s0_.toString1Node_, s0_.toString2Node_);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 toString(Object) */) {
                if (fallbackGuard_(state_0, arguments0Value_)) {
                    return toString(arguments0Value_);
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
                    ToStringData s0_ = this.toString_cache;
                    boolean ToString_duplicateFound_ = false;
                    if ((state_0 & 0b1) != 0 /* is-state_0 toString(DynamicObject, IsJSObjectNode, JSToStringNode, JSToStringNode) */) {
                        if ((s0_.isObjectNode_.executeBoolean(arguments0Value_))) {
                            ToString_duplicateFound_ = true;
                        }
                    }
                    if (!ToString_duplicateFound_) {
                        {
                            if (((state_0 & 0b10)) == 0 /* is-not-state_0 Guard[(isObjectNode.executeBoolean(thisObj))] */) {
                                s0_ = super.insert(new ToStringData());
                                MemoryFence.storeStore();
                                this.toString_cache = s0_;
                                s0_.isObjectNode_ = s0_.insertAccessor((IsJSObjectNode.create()));
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 Guard[(isObjectNode.executeBoolean(thisObj))] */;
                            }
                            if ((s0_.isObjectNode_.executeBoolean(arguments0Value_)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 toString(DynamicObject, IsJSObjectNode, JSToStringNode, JSToStringNode) */) {
                                s0_ = super.insert(new ToStringData());
                                s0_.isObjectNode_ = s0_.insertAccessor((IsJSObjectNode.create()));
                                s0_.toString1Node_ = s0_.insertAccessor((JSToStringNode.create()));
                                s0_.toString2Node_ = s0_.insertAccessor((JSToStringNode.create()));
                                MemoryFence.storeStore();
                                this.toString_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 toString(DynamicObject, IsJSObjectNode, JSToStringNode, JSToStringNode) */;
                                ToString_duplicateFound_ = true;
                            }
                        }
                    }
                    if (ToString_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return toString(arguments0Value_, s0_.isObjectNode_, s0_.toString1Node_, s0_.toString2Node_);
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 toString(Object) */;
                lock.unlock();
                hasLock = false;
                return toString(arguments0Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b101) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b101) & ((state_0 & 0b101) - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "toString";
            if ((state_0 & 0b1) != 0 /* is-state_0 toString(DynamicObject, IsJSObjectNode, JSToStringNode, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ToStringData s0_ = this.toString_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.isObjectNode_, s0_.toString1Node_, s0_.toString2Node_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toString";
            if ((state_0 & 0b100) != 0 /* is-state_0 toString(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpToStringNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSRegExpToStringNode.class)
        private static final class ToStringData extends Node {

            @Child IsJSObjectNode isObjectNode_;
            @Child JSToStringNode toString1Node_;
            @Child JSToStringNode toString2Node_;

            ToStringData() {
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
    @GeneratedBy(JSRegExpSplitNode.class)
    public static final class JSRegExpSplitNodeGen extends JSRegExpSplitNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private JSRegExpSplitNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b11110) == 0 /* only-active splitIntLimit(DynamicObject, Object, int) */ && (state_0 != 0  /* is-not splitIntLimit(DynamicObject, Object, int) && splitLongLimit(DynamicObject, Object, long) && splitUndefinedLimit(DynamicObject, Object, Object) && splitObjectLimit(DynamicObject, Object, Object) && doNoObject(Object, Object, Object) */)) {
                return execute_int0(state_0, frameValue);
            } else if ((state_0 & 0b11101) == 0 /* only-active splitLongLimit(DynamicObject, Object, long) */ && (state_0 != 0  /* is-not splitIntLimit(DynamicObject, Object, int) && splitLongLimit(DynamicObject, Object, long) && splitUndefinedLimit(DynamicObject, Object, Object) && splitObjectLimit(DynamicObject, Object, Object) && doNoObject(Object, Object, Object) */)) {
                return execute_long1(state_0, frameValue);
            } else {
                return execute_generic2(state_0, frameValue);
            }
        }

        private Object execute_int0(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            assert (state_0 & 0b1) != 0 /* is-state_0 splitIntLimit(DynamicObject, Object, int) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return splitIntLimit(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_long1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            long arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeLong(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 splitLongLimit(DynamicObject, Object, long) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return splitLongLimit(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic2(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 splitIntLimit(DynamicObject, Object, int) || splitLongLimit(DynamicObject, Object, long) || splitUndefinedLimit(DynamicObject, Object, Object) || splitObjectLimit(DynamicObject, Object, Object) || doNoObject(Object, Object, Object) */) {
                if ((state_0 & 0b1111) != 0 /* is-state_0 splitIntLimit(DynamicObject, Object, int) || splitLongLimit(DynamicObject, Object, long) || splitUndefinedLimit(DynamicObject, Object, Object) || splitObjectLimit(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 splitIntLimit(DynamicObject, Object, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        return splitIntLimit(arguments0Value__, arguments1Value_, arguments2Value__);
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 splitLongLimit(DynamicObject, Object, long) */ && arguments2Value_ instanceof Long) {
                        long arguments2Value__ = (long) arguments2Value_;
                        return splitLongLimit(arguments0Value__, arguments1Value_, arguments2Value__);
                    }
                    if ((state_0 & 0b1100) != 0 /* is-state_0 splitUndefinedLimit(DynamicObject, Object, Object) || splitObjectLimit(DynamicObject, Object, Object) */) {
                        if ((state_0 & 0b100) != 0 /* is-state_0 splitUndefinedLimit(DynamicObject, Object, Object) */) {
                            if ((JSGuards.isUndefined(arguments2Value_))) {
                                return splitUndefinedLimit(arguments0Value__, arguments1Value_, arguments2Value_);
                            }
                        }
                        if ((state_0 & 0b1000) != 0 /* is-state_0 splitObjectLimit(DynamicObject, Object, Object) */) {
                            if ((!(JSGuards.isUndefined(arguments2Value_)))) {
                                return splitObjectLimit(arguments0Value__, arguments1Value_, arguments2Value_);
                            }
                        }
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doNoObject(Object, Object, Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_, arguments2Value_)) {
                        return doNoObject(arguments0Value_, arguments1Value_, arguments2Value_);
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
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if (arguments2Value instanceof Integer) {
                    int arguments2Value_ = (int) arguments2Value;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 splitIntLimit(DynamicObject, Object, int) */;
                    return splitIntLimit(arguments0Value_, arguments1Value, arguments2Value_);
                }
                if (arguments2Value instanceof Long) {
                    long arguments2Value_ = (long) arguments2Value;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 splitLongLimit(DynamicObject, Object, long) */;
                    return splitLongLimit(arguments0Value_, arguments1Value, arguments2Value_);
                }
                if ((JSGuards.isUndefined(arguments2Value))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 splitUndefinedLimit(DynamicObject, Object, Object) */;
                    return splitUndefinedLimit(arguments0Value_, arguments1Value, arguments2Value);
                }
                if ((!(JSGuards.isUndefined(arguments2Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 splitObjectLimit(DynamicObject, Object, Object) */;
                    return splitObjectLimit(arguments0Value_, arguments1Value, arguments2Value);
                }
            }
            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doNoObject(Object, Object, Object) */;
            return doNoObject(arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "splitIntLimit";
            if ((state_0 & 0b1) != 0 /* is-state_0 splitIntLimit(DynamicObject, Object, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "splitLongLimit";
            if ((state_0 & 0b10) != 0 /* is-state_0 splitLongLimit(DynamicObject, Object, long) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "splitUndefinedLimit";
            if ((state_0 & 0b100) != 0 /* is-state_0 splitUndefinedLimit(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "splitObjectLimit";
            if ((state_0 & 0b1000) != 0 /* is-state_0 splitObjectLimit(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "doNoObject";
            if ((state_0 & 0b10000) != 0 /* is-state_0 doNoObject(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                if (((state_0 & 0b1)) == 0 /* is-not-state_0 splitIntLimit(DynamicObject, Object, int) */ && arguments2Value instanceof Integer) {
                    return false;
                }
                if (((state_0 & 0b10)) == 0 /* is-not-state_0 splitLongLimit(DynamicObject, Object, long) */ && arguments2Value instanceof Long) {
                    return false;
                }
                if (((state_0 & 0b100)) == 0 /* is-not-state_0 splitUndefinedLimit(DynamicObject, Object, Object) */ && (JSGuards.isUndefined(arguments2Value))) {
                    return false;
                }
                if (((state_0 & 0b1000)) == 0 /* is-not-state_0 splitObjectLimit(DynamicObject, Object, Object) */ && (!(JSGuards.isUndefined(arguments2Value)))) {
                    return false;
                }
            }
            return true;
        }

        public static JSRegExpSplitNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpSplitNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpReplaceNode.class)
    public static final class JSRegExpReplaceNodeGen extends JSRegExpReplaceNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ReplaceCachedData replaceCached_cache;
        @Child private JSToStringNode replaceDynamic_toString1Node_;

        private JSRegExpReplaceNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b111) != 0 /* is-state_0 replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) || replaceDynamic(DynamicObject, Object, Object, JSToStringNode) || doNoObject(Object, Object, Object) */) {
                if ((state_0 & 0b11) != 0 /* is-state_0 replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) || replaceDynamic(DynamicObject, Object, Object, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */ && JSTypesGen.isImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 2:String */, arguments2Value_)) {
                        String arguments2Value__ = JSTypesGen.asImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 2:String */, arguments2Value_);
                        ReplaceCachedData s0_ = this.replaceCached_cache;
                        while (s0_ != null) {
                            if ((s0_.cachedReplaceValue_.equals(arguments2Value__))) {
                                return replaceCached(arguments0Value__, arguments1Value_, arguments2Value__, s0_.cachedReplaceValue_, s0_.cachedParsedReplaceValueWithNamedCG_, s0_.cachedParsedReplaceValueWithoutNamedCG_, s0_.toString1Node_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 replaceDynamic(DynamicObject, Object, Object, JSToStringNode) */) {
                        return replaceDynamic(arguments0Value__, arguments1Value_, arguments2Value_, this.replaceDynamic_toString1Node_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doNoObject(Object, Object, Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_, arguments2Value_)) {
                        return doNoObject(arguments0Value_, arguments1Value_, arguments2Value_);
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

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((exclude) == 0 /* is-not-exclude replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */) {
                        int stringCast2;
                        if ((stringCast2 = JSTypesGen.specializeImplicitString(arguments2Value)) != 0) {
                            String arguments2Value_ = JSTypesGen.asImplicitString(stringCast2, arguments2Value);
                            int count0_ = 0;
                            ReplaceCachedData s0_ = this.replaceCached_cache;
                            if ((state_0 & 0b1) != 0 /* is-state_0 replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */) {
                                while (s0_ != null) {
                                    if ((s0_.cachedReplaceValue_.equals(arguments2Value_))) {
                                        break;
                                    }
                                    s0_ = s0_.next_;
                                    count0_++;
                                }
                            }
                            if (s0_ == null) {
                                // assert (s0_.cachedReplaceValue_.equals(arguments2Value_));
                                if (count0_ < (3)) {
                                    s0_ = super.insert(new ReplaceCachedData(replaceCached_cache));
                                    s0_.cachedReplaceValue_ = (arguments2Value_);
                                    s0_.cachedParsedReplaceValueWithNamedCG_ = (JSRegExpReplaceNode.parseReplaceValueWithNCG(arguments2Value_));
                                    s0_.cachedParsedReplaceValueWithoutNamedCG_ = (JSRegExpReplaceNode.parseReplaceValueWithoutNCG(arguments2Value_));
                                    s0_.toString1Node_ = s0_.insertAccessor((JSToStringNode.create()));
                                    MemoryFence.storeStore();
                                    this.replaceCached_cache = s0_;
                                    state_0 = (state_0 | (stringCast2 << 3) /* set-implicit-state_0 2:String */);
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */;
                                }
                            } else {
                                state_0 = (state_0 | (stringCast2 << 3) /* set-implicit-state_0 2:String */);
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */;
                            }
                            if (s0_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return replaceCached(arguments0Value_, arguments1Value, arguments2Value_, s0_.cachedReplaceValue_, s0_.cachedParsedReplaceValueWithNamedCG_, s0_.cachedParsedReplaceValueWithoutNamedCG_, s0_.toString1Node_);
                            }
                        }
                    }
                    this.replaceDynamic_toString1Node_ = super.insert((JSToStringNode.create()));
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */;
                    this.replaceCached_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 replaceDynamic(DynamicObject, Object, Object, JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return replaceDynamic(arguments0Value_, arguments1Value, arguments2Value, this.replaceDynamic_toString1Node_);
                }
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doNoObject(Object, Object, Object) */;
                lock.unlock();
                hasLock = false;
                return doNoObject(arguments0Value, arguments1Value, arguments2Value);
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
                    ReplaceCachedData s0_ = this.replaceCached_cache;
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
            s[0] = "replaceCached";
            if ((state_0 & 0b1) != 0 /* is-state_0 replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ReplaceCachedData s0_ = this.replaceCached_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.cachedReplaceValue_, s0_.cachedParsedReplaceValueWithNamedCG_, s0_.cachedParsedReplaceValueWithoutNamedCG_, s0_.toString1Node_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "replaceDynamic";
            if ((state_0 & 0b10) != 0 /* is-state_0 replaceDynamic(DynamicObject, Object, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.replaceDynamic_toString1Node_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doNoObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 doNoObject(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            if (((state_0 & 0b10)) == 0 /* is-not-state_0 replaceDynamic(DynamicObject, Object, Object, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value)) {
                return false;
            }
            return true;
        }

        public static JSRegExpReplaceNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpReplaceNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSRegExpReplaceNode.class)
        private static final class ReplaceCachedData extends Node {

            @Child ReplaceCachedData next_;
            @CompilationFinal String cachedReplaceValue_;
            @CompilationFinal(dimensions = 1) Token[] cachedParsedReplaceValueWithNamedCG_;
            @CompilationFinal(dimensions = 1) Token[] cachedParsedReplaceValueWithoutNamedCG_;
            @Child JSToStringNode toString1Node_;

            ReplaceCachedData(ReplaceCachedData next_) {
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
    @GeneratedBy(JSRegExpMatchNode.class)
    public static final class JSRegExpMatchNodeGen extends JSRegExpMatchNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private MatchData match_cache;

        private JSRegExpMatchNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        private boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((((state_0 & 0b10)) == 0 /* is-not-state_0 Guard[(isObjectNode.executeBoolean(rx))] */ || (this.match_cache.isObjectNode_.executeBoolean(arguments0Value_)))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b101) != 0 /* is-state_0 match(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSToStringNode) || match(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 match(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    MatchData s0_ = this.match_cache;
                    if (s0_ != null) {
                        if ((s0_.isObjectNode_.executeBoolean(arguments0Value__))) {
                            return match(arguments0Value__, arguments1Value_, s0_.isObjectNode_, s0_.toString1Node_, s0_.toString2Node_);
                        }
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 match(Object, Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_)) {
                        return match(arguments0Value_, arguments1Value_);
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
                    MatchData s0_ = this.match_cache;
                    boolean Match_duplicateFound_ = false;
                    if ((state_0 & 0b1) != 0 /* is-state_0 match(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSToStringNode) */) {
                        if ((s0_.isObjectNode_.executeBoolean(arguments0Value_))) {
                            Match_duplicateFound_ = true;
                        }
                    }
                    if (!Match_duplicateFound_) {
                        {
                            if (((state_0 & 0b10)) == 0 /* is-not-state_0 Guard[(isObjectNode.executeBoolean(rx))] */) {
                                s0_ = super.insert(new MatchData());
                                MemoryFence.storeStore();
                                this.match_cache = s0_;
                                s0_.isObjectNode_ = s0_.insertAccessor((IsJSObjectNode.create()));
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 Guard[(isObjectNode.executeBoolean(rx))] */;
                            }
                            if ((s0_.isObjectNode_.executeBoolean(arguments0Value_)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 match(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSToStringNode) */) {
                                s0_ = super.insert(new MatchData());
                                s0_.isObjectNode_ = s0_.insertAccessor((IsJSObjectNode.create()));
                                s0_.toString1Node_ = s0_.insertAccessor((JSToStringNode.create()));
                                s0_.toString2Node_ = s0_.insertAccessor((JSToStringNode.create()));
                                MemoryFence.storeStore();
                                this.match_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 match(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSToStringNode) */;
                                Match_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Match_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return match(arguments0Value_, arguments1Value, s0_.isObjectNode_, s0_.toString1Node_, s0_.toString2Node_);
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 match(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return match(arguments0Value, arguments1Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b101) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b101) & ((state_0 & 0b101) - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "match";
            if ((state_0 & 0b1) != 0 /* is-state_0 match(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                MatchData s0_ = this.match_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.isObjectNode_, s0_.toString1Node_, s0_.toString2Node_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "match";
            if ((state_0 & 0b100) != 0 /* is-state_0 match(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpMatchNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpMatchNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSRegExpMatchNode.class)
        private static final class MatchData extends Node {

            @Child IsJSObjectNode isObjectNode_;
            @Child JSToStringNode toString1Node_;
            @Child JSToStringNode toString2Node_;

            MatchData() {
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
    @GeneratedBy(JSRegExpSearchNode.class)
    public static final class JSRegExpSearchNodeGen extends JSRegExpSearchNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private IsJSObjectNode search_isObjectNode_;
        @Child private JSToStringNode search_toString1Node_;

        private JSRegExpSearchNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        private boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((((state_0 & 0b10)) == 0 /* is-not-state_0 Guard[(isObjectNode.executeBoolean(rx))] */ || (this.search_isObjectNode_.executeBoolean(arguments0Value_)))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b101) != 0 /* is-state_0 search(DynamicObject, Object, IsJSObjectNode, JSToStringNode) || search(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 search(DynamicObject, Object, IsJSObjectNode, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((this.search_isObjectNode_.executeBoolean(arguments0Value__))) {
                        return search(arguments0Value__, arguments1Value_, this.search_isObjectNode_, this.search_toString1Node_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 search(Object, Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_)) {
                        return search(arguments0Value_, arguments1Value_);
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
                    boolean Search_duplicateFound_ = false;
                    if ((state_0 & 0b1) != 0 /* is-state_0 search(DynamicObject, Object, IsJSObjectNode, JSToStringNode) */) {
                        if ((this.search_isObjectNode_.executeBoolean(arguments0Value_))) {
                            Search_duplicateFound_ = true;
                        }
                    }
                    if (!Search_duplicateFound_) {
                        {
                            if (((state_0 & 0b10)) == 0 /* is-not-state_0 Guard[(isObjectNode.executeBoolean(rx))] */) {
                                this.search_isObjectNode_ = super.insert((IsJSObjectNode.create()));
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 Guard[(isObjectNode.executeBoolean(rx))] */;
                            }
                            if ((this.search_isObjectNode_.executeBoolean(arguments0Value_)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 search(DynamicObject, Object, IsJSObjectNode, JSToStringNode) */) {
                                this.search_isObjectNode_ = super.insert((IsJSObjectNode.create()));
                                this.search_toString1Node_ = super.insert((JSToStringNode.create()));
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 search(DynamicObject, Object, IsJSObjectNode, JSToStringNode) */;
                                Search_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Search_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return search(arguments0Value_, arguments1Value, this.search_isObjectNode_, this.search_toString1Node_);
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 search(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return search(arguments0Value, arguments1Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b101) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b101) & ((state_0 & 0b101) - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "search";
            if ((state_0 & 0b1) != 0 /* is-state_0 search(DynamicObject, Object, IsJSObjectNode, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.search_isObjectNode_, this.search_toString1Node_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "search";
            if ((state_0 & 0b100) != 0 /* is-state_0 search(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpSearchNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpSearchNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpMatchAllNode.class)
    public static final class JSRegExpMatchAllNodeGen extends JSRegExpMatchAllNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private MatchAllData matchAll_cache;

        private JSRegExpMatchAllNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        private boolean fallbackGuard_(int state_0, Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((((state_0 & 0b10)) == 0 /* is-not-state_0 Guard[(isObjectNode.executeBoolean(regex))] */ || (this.matchAll_cache.isObjectNode_.executeBoolean(arguments0Value_)))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b101) != 0 /* is-state_0 matchAll(VirtualFrame, DynamicObject, Object, JSToStringNode, ArraySpeciesConstructorNode, PropertyGetNode, JSToStringNode, PropertyGetNode, JSToLengthNode, PropertySetNode, CreateRegExpStringIteratorNode, IsJSObjectNode, ConditionProfile) || matchAll(Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 matchAll(VirtualFrame, DynamicObject, Object, JSToStringNode, ArraySpeciesConstructorNode, PropertyGetNode, JSToStringNode, PropertyGetNode, JSToLengthNode, PropertySetNode, CreateRegExpStringIteratorNode, IsJSObjectNode, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    MatchAllData s0_ = this.matchAll_cache;
                    if (s0_ != null) {
                        if ((s0_.isObjectNode_.executeBoolean(arguments0Value__))) {
                            return matchAll(frameValue, arguments0Value__, arguments1Value_, s0_.toStringNodeForInput_, s0_.speciesConstructNode_, s0_.getFlagsNode_, s0_.toStringNodeForFlags_, s0_.getLastIndexNode_, s0_.toLengthNode_, s0_.setLastIndexNode_, s0_.createRegExpStringIteratorNode_, s0_.isObjectNode_, s0_.indexInIntRangeProf_);
                        }
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 matchAll(Object, Object) */) {
                    if (fallbackGuard_(state_0, arguments0Value_, arguments1Value_)) {
                        return matchAll(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    MatchAllData s0_ = this.matchAll_cache;
                    boolean MatchAll_duplicateFound_ = false;
                    if ((state_0 & 0b1) != 0 /* is-state_0 matchAll(VirtualFrame, DynamicObject, Object, JSToStringNode, ArraySpeciesConstructorNode, PropertyGetNode, JSToStringNode, PropertyGetNode, JSToLengthNode, PropertySetNode, CreateRegExpStringIteratorNode, IsJSObjectNode, ConditionProfile) */) {
                        if ((s0_.isObjectNode_.executeBoolean(arguments0Value_))) {
                            MatchAll_duplicateFound_ = true;
                        }
                    }
                    if (!MatchAll_duplicateFound_) {
                        {
                            if (((state_0 & 0b10)) == 0 /* is-not-state_0 Guard[(isObjectNode.executeBoolean(regex))] */) {
                                s0_ = super.insert(new MatchAllData());
                                MemoryFence.storeStore();
                                this.matchAll_cache = s0_;
                                s0_.isObjectNode_ = s0_.insertAccessor((IsJSObjectNode.create()));
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 Guard[(isObjectNode.executeBoolean(regex))] */;
                            }
                            if ((s0_.isObjectNode_.executeBoolean(arguments0Value_)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 matchAll(VirtualFrame, DynamicObject, Object, JSToStringNode, ArraySpeciesConstructorNode, PropertyGetNode, JSToStringNode, PropertyGetNode, JSToLengthNode, PropertySetNode, CreateRegExpStringIteratorNode, IsJSObjectNode, ConditionProfile) */) {
                                s0_ = super.insert(new MatchAllData());
                                s0_.toStringNodeForInput_ = s0_.insertAccessor((JSToStringNode.create()));
                                s0_.speciesConstructNode_ = s0_.insertAccessor((createSpeciesConstructNode()));
                                s0_.getFlagsNode_ = s0_.insertAccessor((PropertyGetNode.create(JSRegExp.FLAGS, getContext())));
                                s0_.toStringNodeForFlags_ = s0_.insertAccessor((JSToStringNode.create()));
                                s0_.getLastIndexNode_ = s0_.insertAccessor((PropertyGetNode.create(JSRegExp.LAST_INDEX, getContext())));
                                s0_.toLengthNode_ = s0_.insertAccessor((JSToLengthNode.create()));
                                s0_.setLastIndexNode_ = s0_.insertAccessor((PropertySetNode.create(JSRegExp.LAST_INDEX, JSGuards.FALSE, getContext(), JSGuards.TRUE)));
                                s0_.createRegExpStringIteratorNode_ = s0_.insertAccessor((createCreateRegExpStringIteratorNode()));
                                s0_.isObjectNode_ = s0_.insertAccessor((IsJSObjectNode.create()));
                                s0_.indexInIntRangeProf_ = (ConditionProfile.createBinaryProfile());
                                MemoryFence.storeStore();
                                this.matchAll_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 matchAll(VirtualFrame, DynamicObject, Object, JSToStringNode, ArraySpeciesConstructorNode, PropertyGetNode, JSToStringNode, PropertyGetNode, JSToLengthNode, PropertySetNode, CreateRegExpStringIteratorNode, IsJSObjectNode, ConditionProfile) */;
                                MatchAll_duplicateFound_ = true;
                            }
                        }
                    }
                    if (MatchAll_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return matchAll(frameValue, arguments0Value_, arguments1Value, s0_.toStringNodeForInput_, s0_.speciesConstructNode_, s0_.getFlagsNode_, s0_.toStringNodeForFlags_, s0_.getLastIndexNode_, s0_.toLengthNode_, s0_.setLastIndexNode_, s0_.createRegExpStringIteratorNode_, s0_.isObjectNode_, s0_.indexInIntRangeProf_);
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 matchAll(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return matchAll(arguments0Value, arguments1Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b101) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b101) & ((state_0 & 0b101) - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "matchAll";
            if ((state_0 & 0b1) != 0 /* is-state_0 matchAll(VirtualFrame, DynamicObject, Object, JSToStringNode, ArraySpeciesConstructorNode, PropertyGetNode, JSToStringNode, PropertyGetNode, JSToLengthNode, PropertySetNode, CreateRegExpStringIteratorNode, IsJSObjectNode, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                MatchAllData s0_ = this.matchAll_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.toStringNodeForInput_, s0_.speciesConstructNode_, s0_.getFlagsNode_, s0_.toStringNodeForFlags_, s0_.getLastIndexNode_, s0_.toLengthNode_, s0_.setLastIndexNode_, s0_.createRegExpStringIteratorNode_, s0_.isObjectNode_, s0_.indexInIntRangeProf_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "matchAll";
            if ((state_0 & 0b100) != 0 /* is-state_0 matchAll(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpMatchAllNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpMatchAllNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSRegExpMatchAllNode.class)
        private static final class MatchAllData extends Node {

            @Child JSToStringNode toStringNodeForInput_;
            @Child ArraySpeciesConstructorNode speciesConstructNode_;
            @Child PropertyGetNode getFlagsNode_;
            @Child JSToStringNode toStringNodeForFlags_;
            @Child PropertyGetNode getLastIndexNode_;
            @Child JSToLengthNode toLengthNode_;
            @Child PropertySetNode setLastIndexNode_;
            @Child CreateRegExpStringIteratorNode createRegExpStringIteratorNode_;
            @Child IsJSObjectNode isObjectNode_;
            @CompilationFinal ConditionProfile indexInIntRangeProf_;

            MatchAllData() {
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
    @GeneratedBy(RegExpFlagsGetterNode.class)
    public static final class RegExpFlagsGetterNodeGen extends RegExpFlagsGetterNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private IsJSObjectNode object_isObjectNode_;

        private RegExpFlagsGetterNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        private boolean fallbackGuard_(int state_0, Object arguments0Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((((state_0 & 0b10)) == 0 /* is-not-state_0 Guard[(isObjectNode.executeBoolean(rx))] */ || (this.object_isObjectNode_.executeBoolean(arguments0Value_)))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject, IsJSObjectNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((this.object_isObjectNode_.executeBoolean(arguments0Value__))) {
                    return doObject(arguments0Value__, this.object_isObjectNode_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doNotObject(Object) */) {
                if (fallbackGuard_(state_0, arguments0Value_)) {
                    return doNotObject(arguments0Value_);
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

        private String executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    boolean Object_duplicateFound_ = false;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject, IsJSObjectNode) */) {
                        if ((this.object_isObjectNode_.executeBoolean(arguments0Value_))) {
                            Object_duplicateFound_ = true;
                        }
                    }
                    if (!Object_duplicateFound_) {
                        {
                            if (((state_0 & 0b10)) == 0 /* is-not-state_0 Guard[(isObjectNode.executeBoolean(rx))] */) {
                                this.object_isObjectNode_ = super.insert((IsJSObjectNode.create()));
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 Guard[(isObjectNode.executeBoolean(rx))] */;
                            }
                            if ((this.object_isObjectNode_.executeBoolean(arguments0Value_)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 doObject(DynamicObject, IsJSObjectNode) */) {
                                this.object_isObjectNode_ = super.insert((IsJSObjectNode.create()));
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doObject(DynamicObject, IsJSObjectNode) */;
                                Object_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Object_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return doObject(arguments0Value_, this.object_isObjectNode_);
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doNotObject(Object) */;
                lock.unlock();
                hasLock = false;
                return doNotObject(arguments0Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b101) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b101) & ((state_0 & 0b101) - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "doObject";
            if ((state_0 & 0b1) != 0 /* is-state_0 doObject(DynamicObject, IsJSObjectNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object_isObjectNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doNotObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 doNotObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static RegExpFlagsGetterNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new RegExpFlagsGetterNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(CompiledRegexFlagPropertyAccessor.class)
    static final class CompiledRegexFlagPropertyAccessorNodeGen extends CompiledRegexFlagPropertyAccessor implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private CompiledRegexFlagPropertyAccessorNodeGen(JSContext context, JSBuiltin builtin, String flagName, JavaScriptNode[] arguments) {
            super(context, builtin, flagName);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        private boolean fallbackGuard_(int state_0, Object arguments0Value) {
            if (((state_0 & 0b1)) == 0 /* is-not-state_0 doRegExp(JSRegExpObject) */ && arguments0Value instanceof JSRegExpObject) {
                return false;
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((isRegExpPrototype(arguments0Value_))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 doRegExp(JSRegExpObject) */ && arguments0Value_ instanceof JSRegExpObject) {
                JSRegExpObject arguments0Value__ = (JSRegExpObject) arguments0Value_;
                return doRegExp(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doPrototype(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((isRegExpPrototype(arguments0Value__))) {
                    return doPrototype(arguments0Value__);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doObject(Object) */) {
                if (fallbackGuard_(state_0, arguments0Value_)) {
                    return doObject(arguments0Value_);
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
            if (arguments0Value instanceof JSRegExpObject) {
                JSRegExpObject arguments0Value_ = (JSRegExpObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doRegExp(JSRegExpObject) */;
                return doRegExp(arguments0Value_);
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((isRegExpPrototype(arguments0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doPrototype(DynamicObject) */;
                    return doPrototype(arguments0Value_);
                }
            }
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doObject(Object) */;
            return doObject(arguments0Value);
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
            s[0] = "doRegExp";
            if ((state_0 & 0b1) != 0 /* is-state_0 doRegExp(JSRegExpObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doPrototype";
            if ((state_0 & 0b10) != 0 /* is-state_0 doPrototype(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 doObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static CompiledRegexFlagPropertyAccessor create(JSContext context, JSBuiltin builtin, String flagName, JavaScriptNode[] arguments) {
            return new CompiledRegexFlagPropertyAccessorNodeGen(context, builtin, flagName, arguments);
        }

    }
    @GeneratedBy(CompiledRegexPatternAccessor.class)
    static final class CompiledRegexPatternAccessorNodeGen extends CompiledRegexPatternAccessor implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private CompiledRegexPatternAccessorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        private boolean fallbackGuard_(int state_0, Object arguments0Value) {
            if (((state_0 & 0b1)) == 0 /* is-not-state_0 doRegExp(JSRegExpObject) */ && arguments0Value instanceof JSRegExpObject) {
                return false;
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((isRegExpPrototype(arguments0Value_))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 doRegExp(JSRegExpObject) */ && arguments0Value_ instanceof JSRegExpObject) {
                JSRegExpObject arguments0Value__ = (JSRegExpObject) arguments0Value_;
                return doRegExp(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doPrototype(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((isRegExpPrototype(arguments0Value__))) {
                    return doPrototype(arguments0Value__);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doObject(Object) */) {
                if (fallbackGuard_(state_0, arguments0Value_)) {
                    return doObject(arguments0Value_);
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
            if (arguments0Value instanceof JSRegExpObject) {
                JSRegExpObject arguments0Value_ = (JSRegExpObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doRegExp(JSRegExpObject) */;
                return doRegExp(arguments0Value_);
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((isRegExpPrototype(arguments0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doPrototype(DynamicObject) */;
                    return doPrototype(arguments0Value_);
                }
            }
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doObject(Object) */;
            return doObject(arguments0Value);
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
            s[0] = "doRegExp";
            if ((state_0 & 0b1) != 0 /* is-state_0 doRegExp(JSRegExpObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doPrototype";
            if ((state_0 & 0b10) != 0 /* is-state_0 doPrototype(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 doObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static CompiledRegexPatternAccessor create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CompiledRegexPatternAccessorNodeGen(context, builtin, arguments);
        }

    }
}
