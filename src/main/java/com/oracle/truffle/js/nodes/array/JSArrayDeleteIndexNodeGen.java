// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSArrayDeleteIndexNode.class)
public final class JSArrayDeleteIndexNodeGen extends JSArrayDeleteIndexNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedData cached_cache;

    private JSArrayDeleteIndexNodeGen(JSContext context, boolean strict) {
        super(context, strict);
    }

    @ExplodeLoop
    @Override
    public boolean execute(DynamicObject arg0Value, ScriptArray arg1Value, long arg2Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doCached(DynamicObject, ScriptArray, long, ScriptArray) || doUncached(DynamicObject, ScriptArray, long) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, ScriptArray, long, ScriptArray) */) {
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    if ((s0_.cachedArrayType_.isInstance(arg1Value))) {
                        return doCached(arg0Value, arg1Value, arg2Value, s0_.cachedArrayType_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(DynamicObject, ScriptArray, long) */) {
                return doUncached(arg0Value, arg1Value, arg2Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private boolean executeAndSpecialize(DynamicObject arg0Value, ScriptArray arg1Value, long arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude doCached(DynamicObject, ScriptArray, long, ScriptArray) */) {
                int count0_ = 0;
                CachedData s0_ = this.cached_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, ScriptArray, long, ScriptArray) */) {
                    while (s0_ != null) {
                        if ((s0_.cachedArrayType_.isInstance(arg1Value))) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    {
                        ScriptArray cachedArrayType__ = (arg1Value);
                        if ((cachedArrayType__.isInstance(arg1Value)) && count0_ < (5)) {
                            s0_ = new CachedData(cached_cache);
                            s0_.cachedArrayType_ = cachedArrayType__;
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, ScriptArray, long, ScriptArray) */;
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doCached(arg0Value, arg1Value, arg2Value, s0_.cachedArrayType_);
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(DynamicObject, ScriptArray, long, ScriptArray) */;
            this.cached_cache = null;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(DynamicObject, ScriptArray, long, ScriptArray) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(DynamicObject, ScriptArray, long) */;
            lock.unlock();
            hasLock = false;
            return doUncached(arg0Value, arg1Value, arg2Value);
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
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, ScriptArray, long, ScriptArray) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s0_ = this.cached_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedArrayType_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doCached(DynamicObject, ScriptArray, long, ScriptArray) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(DynamicObject, ScriptArray, long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSArrayDeleteIndexNode create(JSContext context, boolean strict) {
        return new JSArrayDeleteIndexNodeGen(context, strict);
    }

    @GeneratedBy(JSArrayDeleteIndexNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal ScriptArray cachedArrayType_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
}
