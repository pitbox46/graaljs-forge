// CheckStyle: start generated
package com.oracle.truffle.js.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.AssumedValue;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(CompileRegexNode.class)
public final class CompileRegexNodeGen extends CompileRegexNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private GetCachedData getCached_cache;

    private CompileRegexNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    protected Object executeCompile(CharSequence arg0Value, String arg1Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) != 0 /* is-state_0 getCached(String, String, String, String, AssumedValue<Object>) || doCompileNoTrimCache(String, String) || doCompile(String, String) */ && JSTypesGen.isImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, arg0Value);
            if ((state_0 & 0b1) != 0 /* is-state_0 getCached(String, String, String, String, AssumedValue<Object>) */) {
                GetCachedData s0_ = this.getCached_cache;
                while (s0_ != null) {
                    if ((CompileRegexNode.stringEquals(arg0Value_, s0_.cachedPattern_)) && (CompileRegexNode.stringEquals(arg1Value, s0_.cachedFlags_))) {
                        return getCached(arg0Value_, arg1Value, s0_.cachedPattern_, s0_.cachedFlags_, s0_.cachedCompiledRegex_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doCompileNoTrimCache(String, String) */) {
                assert (!(JSConfig.TrimCompiledRegexCache));
                return doCompileNoTrimCache(arg0Value_, arg1Value);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doCompile(String, String) */) {
                return doCompile(arg0Value_, arg1Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private Object executeAndSpecialize(CharSequence arg0Value, String arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            int oldState_0 = (state_0 & 0b111);
            try {
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                        String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                        if ((exclude) == 0 /* is-not-exclude getCached(String, String, String, String, AssumedValue<Object>) */) {
                            int count0_ = 0;
                            GetCachedData s0_ = this.getCached_cache;
                            if ((state_0 & 0b1) != 0 /* is-state_0 getCached(String, String, String, String, AssumedValue<Object>) */) {
                                while (s0_ != null) {
                                    if ((CompileRegexNode.stringEquals(arg0Value_, s0_.cachedPattern_)) && (CompileRegexNode.stringEquals(arg1Value, s0_.cachedFlags_))) {
                                        break;
                                    }
                                    s0_ = s0_.next_;
                                    count0_++;
                                }
                            }
                            if (s0_ == null) {
                                {
                                    String cachedPattern__ = (arg0Value_);
                                    if ((CompileRegexNode.stringEquals(arg0Value_, cachedPattern__))) {
                                        String cachedFlags__ = (arg1Value);
                                        if ((CompileRegexNode.stringEquals(arg1Value, cachedFlags__)) && count0_ < (JSConfig.MaxCompiledRegexCacheLength)) {
                                            s0_ = new GetCachedData(getCached_cache);
                                            s0_.cachedPattern_ = cachedPattern__;
                                            s0_.cachedFlags_ = cachedFlags__;
                                            s0_.cachedCompiledRegex_ = (createAssumedValue());
                                            MemoryFence.storeStore();
                                            this.getCached_cache = s0_;
                                            state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getCached(String, String, String, String, AssumedValue<Object>) */;
                                        }
                                    }
                                }
                            } else {
                                state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getCached(String, String, String, String, AssumedValue<Object>) */;
                            }
                            if (s0_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return getCached(arg0Value_, arg1Value, s0_.cachedPattern_, s0_.cachedFlags_, s0_.cachedCompiledRegex_);
                            }
                        }
                        if ((!(JSConfig.TrimCompiledRegexCache))) {
                            state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCompileNoTrimCache(String, String) */;
                            lock.unlock();
                            hasLock = false;
                            return doCompileNoTrimCache(arg0Value_, arg1Value);
                        }
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude getCached(String, String, String, String, AssumedValue<Object>) */;
                        this.getCached_cache = null;
                        state_0 = state_0 & 0xfffffffe /* remove-state_0 getCached(String, String, String, String, AssumedValue<Object>) */;
                        state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doCompile(String, String) */;
                        lock.unlock();
                        hasLock = false;
                        return doCompile(arg0Value_, arg1Value);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            } finally {
                if (oldState_0 != 0) {
                    checkForPolymorphicSpecialize(oldState_0);
                }
            }
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    private void checkForPolymorphicSpecialize(int oldState_0) {
        if (((oldState_0 & 0b100) == 0 && (this.state_0_ & 0b100) != 0)) {
            this.reportPolymorphicSpecialize();
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
                GetCachedData s0_ = this.getCached_cache;
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
        s[0] = "getCached";
        if ((state_0 & 0b1) != 0 /* is-state_0 getCached(String, String, String, String, AssumedValue<Object>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GetCachedData s0_ = this.getCached_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedPattern_, s0_.cachedFlags_, s0_.cachedCompiledRegex_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude getCached(String, String, String, String, AssumedValue<Object>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doCompileNoTrimCache";
        if ((state_0 & 0b10) != 0 /* is-state_0 doCompileNoTrimCache(String, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doCompile";
        if ((state_0 & 0b100) != 0 /* is-state_0 doCompile(String, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static CompileRegexNode create(JSContext context) {
        return new CompileRegexNodeGen(context);
    }

    @GeneratedBy(CompileRegexNode.class)
    private static final class GetCachedData {

        @CompilationFinal GetCachedData next_;
        @CompilationFinal String cachedPattern_;
        @CompilationFinal String cachedFlags_;
        @CompilationFinal AssumedValue<Object> cachedCompiledRegex_;

        GetCachedData(GetCachedData next_) {
            this.next_ = next_;
        }

    }
}
