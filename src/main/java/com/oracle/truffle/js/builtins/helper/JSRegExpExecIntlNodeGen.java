// CheckStyle: start generated
package com.oracle.truffle.js.builtins.helper;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.access.IsJSClassNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSObjectFactory;
import com.oracle.truffle.js.runtime.builtins.JSRegExp;
import com.oracle.truffle.js.runtime.builtins.JSRegExpObject;
import com.oracle.truffle.js.runtime.util.TRegexUtil.TRegexCompiledRegexAccessor;
import com.oracle.truffle.js.runtime.util.TRegexUtil.TRegexResultAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSRegExpExecIntlNode.class)
public final class JSRegExpExecIntlNodeGen extends JSRegExpExecIntlNode implements Introspection.Provider {

    private JSRegExpExecIntlNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public Object execute(DynamicObject arg0Value, String arg1Value) {
        return doGeneric(arg0Value, arg1Value);
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
        s[0] = "doGeneric";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static JSRegExpExecIntlNode create(JSContext context) {
        return new JSRegExpExecIntlNodeGen(context);
    }

    @GeneratedBy(JSRegExpExecIntlIgnoreLastIndexNode.class)
    public static final class JSRegExpExecIntlIgnoreLastIndexNodeGen extends JSRegExpExecIntlIgnoreLastIndexNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @Child private TRegexCompiledRegexAccessor compiledRegexAccessor_;
        @Child private TRegexResultAccessor regexResultAccessor_;

        private JSRegExpExecIntlIgnoreLastIndexNodeGen(JSContext context, boolean doStaticResultUpdate) {
            super(context, doStaticResultUpdate);
        }

        @Override
        public Object execute(DynamicObject arg0Value, String arg1Value, long arg2Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doGeneric(DynamicObject, String, long, TRegexCompiledRegexAccessor, TRegexResultAccessor) */) {
                return doGeneric(arg0Value, arg1Value, arg2Value, this.compiledRegexAccessor_, this.regexResultAccessor_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private Object executeAndSpecialize(DynamicObject arg0Value, String arg1Value, long arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                this.compiledRegexAccessor_ = super.insert((TRegexCompiledRegexAccessor.create()));
                this.regexResultAccessor_ = super.insert((TRegexResultAccessor.create()));
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doGeneric(DynamicObject, String, long, TRegexCompiledRegexAccessor, TRegexResultAccessor) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(arg0Value, arg1Value, arg2Value, this.compiledRegexAccessor_, this.regexResultAccessor_);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) == 0) {
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
            s[0] = "doGeneric";
            if ((state_0 & 0b1) != 0 /* is-state_0 doGeneric(DynamicObject, String, long, TRegexCompiledRegexAccessor, TRegexResultAccessor) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.compiledRegexAccessor_, this.regexResultAccessor_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSRegExpExecIntlIgnoreLastIndexNode create(JSContext context, boolean doStaticResultUpdate) {
            return new JSRegExpExecIntlIgnoreLastIndexNodeGen(context, doStaticResultUpdate);
        }

    }
    @GeneratedBy(BuildGroupsObjectNode.class)
    public static final class BuildGroupsObjectNodeGen extends BuildGroupsObjectNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @Child private CachedGroupsFactoryData cachedGroupsFactory_cache;

        private BuildGroupsObjectNodeGen() {
        }

        @ExplodeLoop
        @Override
        public DynamicObject execute(JSContext arg0Value, DynamicObject arg1Value, Object arg2Value, String arg3Value, boolean arg4Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b11) != 0 /* is-state_0 doCachedGroupsFactory(JSContext, DynamicObject, Object, String, boolean, Object, JSObjectFactory, IsJSClassNode) || doVaryingGroupsFactory(JSContext, DynamicObject, Object, String, boolean) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCachedGroupsFactory(JSContext, DynamicObject, Object, String, boolean, Object, JSObjectFactory, IsJSClassNode) */) {
                    CachedGroupsFactoryData s0_ = this.cachedGroupsFactory_cache;
                    while (s0_ != null) {
                        if ((JSRegExp.getGroupsFactory(arg1Value) == s0_.cachedGroupsFactory_ || JSRegExp.getCompiledRegex(arg1Value) == s0_.cachedCompiledRegex_)) {
                            return doCachedGroupsFactory(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, s0_.cachedCompiledRegex_, s0_.cachedGroupsFactory_, s0_.isJSRegExpNode_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doVaryingGroupsFactory(JSContext, DynamicObject, Object, String, boolean) */) {
                    return doVaryingGroupsFactory(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
        }

        private DynamicObject executeAndSpecialize(JSContext arg0Value, DynamicObject arg1Value, Object arg2Value, String arg3Value, boolean arg4Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int count0_ = 0;
                CachedGroupsFactoryData s0_ = this.cachedGroupsFactory_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 doCachedGroupsFactory(JSContext, DynamicObject, Object, String, boolean, Object, JSObjectFactory, IsJSClassNode) */) {
                    while (s0_ != null) {
                        if ((JSRegExp.getGroupsFactory(arg1Value) == s0_.cachedGroupsFactory_ || JSRegExp.getCompiledRegex(arg1Value) == s0_.cachedCompiledRegex_)) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    {
                        Object cachedCompiledRegex__ = (JSRegExp.getCompiledRegex(arg1Value));
                        JSObjectFactory cachedGroupsFactory__ = (JSRegExp.getGroupsFactory(arg1Value));
                        if ((JSRegExp.getGroupsFactory(arg1Value) == cachedGroupsFactory__ || JSRegExp.getCompiledRegex(arg1Value) == cachedCompiledRegex__) && count0_ < (3)) {
                            s0_ = super.insert(new CachedGroupsFactoryData(cachedGroupsFactory_cache));
                            s0_.cachedCompiledRegex_ = cachedCompiledRegex__;
                            s0_.cachedGroupsFactory_ = cachedGroupsFactory__;
                            s0_.isJSRegExpNode_ = s0_.insertAccessor((JSRegExpExecIntlNode.createIsJSRegExpNode()));
                            MemoryFence.storeStore();
                            this.cachedGroupsFactory_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCachedGroupsFactory(JSContext, DynamicObject, Object, String, boolean, Object, JSObjectFactory, IsJSClassNode) */;
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doCachedGroupsFactory(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, s0_.cachedCompiledRegex_, s0_.cachedGroupsFactory_, s0_.isJSRegExpNode_);
                }
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doVaryingGroupsFactory(JSContext, DynamicObject, Object, String, boolean) */;
                lock.unlock();
                hasLock = false;
                return doVaryingGroupsFactory(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
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
                    CachedGroupsFactoryData s0_ = this.cachedGroupsFactory_cache;
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
            s[0] = "doCachedGroupsFactory";
            if ((state_0 & 0b1) != 0 /* is-state_0 doCachedGroupsFactory(JSContext, DynamicObject, Object, String, boolean, Object, JSObjectFactory, IsJSClassNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedGroupsFactoryData s0_ = this.cachedGroupsFactory_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.cachedCompiledRegex_, s0_.cachedGroupsFactory_, s0_.isJSRegExpNode_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doVaryingGroupsFactory";
            if ((state_0 & 0b10) != 0 /* is-state_0 doVaryingGroupsFactory(JSContext, DynamicObject, Object, String, boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static BuildGroupsObjectNode create() {
            return new BuildGroupsObjectNodeGen();
        }

        @GeneratedBy(BuildGroupsObjectNode.class)
        private static final class CachedGroupsFactoryData extends Node {

            @Child CachedGroupsFactoryData next_;
            @CompilationFinal Object cachedCompiledRegex_;
            @CompilationFinal JSObjectFactory cachedGroupsFactory_;
            @Child IsJSClassNode isJSRegExpNode_;

            CachedGroupsFactoryData(CachedGroupsFactoryData next_) {
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
    @GeneratedBy(JSRegExpExecBuiltinNode.class)
    public static final class JSRegExpExecBuiltinNodeGen extends JSRegExpExecBuiltinNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private JSRegExpExecBuiltinNodeGen(JSContext context) {
            super(context);
        }

        @ExplodeLoop
        @Override
        public Object execute(JSRegExpObject arg0Value, String arg1Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b11) != 0 /* is-state_0 doCached(JSRegExpObject, String, Object) || doDynamic(JSRegExpObject, String) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(JSRegExpObject, String, Object) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((JSRegExp.getCompiledRegex(arg0Value) == s0_.cachedCompiledRegex_)) {
                            return doCached(arg0Value, arg1Value, s0_.cachedCompiledRegex_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doDynamic(JSRegExpObject, String) */) {
                    return doDynamic(arg0Value, arg1Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private Object executeAndSpecialize(JSRegExpObject arg0Value, String arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(JSRegExpObject, String, Object) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(JSRegExpObject, String, Object) */) {
                        while (s0_ != null) {
                            if ((JSRegExp.getCompiledRegex(arg0Value) == s0_.cachedCompiledRegex_)) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        {
                            Object cachedCompiledRegex__ = (JSRegExp.getCompiledRegex(arg0Value));
                            if ((JSRegExp.getCompiledRegex(arg0Value) == cachedCompiledRegex__) && count0_ < (3)) {
                                s0_ = new CachedData(cached_cache);
                                s0_.cachedCompiledRegex_ = cachedCompiledRegex__;
                                MemoryFence.storeStore();
                                this.cached_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(JSRegExpObject, String, Object) */;
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value, arg1Value, s0_.cachedCompiledRegex_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(JSRegExpObject, String, Object) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(JSRegExpObject, String, Object) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDynamic(JSRegExpObject, String) */;
                lock.unlock();
                hasLock = false;
                return doDynamic(arg0Value, arg1Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "doCached";
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(JSRegExpObject, String, Object) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.cachedCompiledRegex_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doCached(JSRegExpObject, String, Object) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doDynamic";
            if ((state_0 & 0b10) != 0 /* is-state_0 doDynamic(JSRegExpObject, String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpExecBuiltinNode create(JSContext context) {
            return new JSRegExpExecBuiltinNodeGen(context);
        }

        @GeneratedBy(JSRegExpExecBuiltinNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal Object cachedCompiledRegex_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
}
