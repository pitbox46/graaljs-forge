// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import com.oracle.truffle.js.runtime.objects.JSObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HasOnlyShapePropertiesNode.class)
public final class HasOnlyShapePropertiesNodeGen extends HasOnlyShapePropertiesNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedData cached_cache;
    @CompilationFinal private JSContext objectPrototype_context_;

    private HasOnlyShapePropertiesNodeGen() {
    }

    @ExplodeLoop
    @Override
    public boolean execute(DynamicObject arg0Value, JSClass arg1Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doCached(DynamicObject, JSClass, JSClass) || doObjectPrototype(DynamicObject, JSClass, JSContext) || doUncached(DynamicObject, JSClass) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, JSClass, JSClass) */) {
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    if ((arg1Value == s0_.cachedJSClass_)) {
                        assert (!(HasOnlyShapePropertiesNode.isJSObjectPrototype(s0_.cachedJSClass_)));
                        return HasOnlyShapePropertiesNode.doCached(arg0Value, arg1Value, s0_.cachedJSClass_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doObjectPrototype(DynamicObject, JSClass, JSContext) */) {
                if ((HasOnlyShapePropertiesNode.isJSObjectPrototype(arg1Value))) {
                    return HasOnlyShapePropertiesNode.doObjectPrototype(arg0Value, arg1Value, this.objectPrototype_context_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doUncached(DynamicObject, JSClass) */) {
                return HasOnlyShapePropertiesNode.doUncached(arg0Value, arg1Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private boolean executeAndSpecialize(DynamicObject arg0Value, JSClass arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (((exclude & 0b1)) == 0 /* is-not-exclude doCached(DynamicObject, JSClass, JSClass) */) {
                int count0_ = 0;
                CachedData s0_ = this.cached_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, JSClass, JSClass) */) {
                    while (s0_ != null) {
                        if ((arg1Value == s0_.cachedJSClass_)) {
                            assert (!(HasOnlyShapePropertiesNode.isJSObjectPrototype(s0_.cachedJSClass_)));
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    {
                        JSClass cachedJSClass__ = (arg1Value);
                        // assert (arg1Value == s0_.cachedJSClass_);
                        if ((!(HasOnlyShapePropertiesNode.isJSObjectPrototype(cachedJSClass__))) && count0_ < (JSConfig.InteropLibraryLimit)) {
                            s0_ = new CachedData(cached_cache);
                            s0_.cachedJSClass_ = cachedJSClass__;
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, JSClass, JSClass) */;
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return HasOnlyShapePropertiesNode.doCached(arg0Value, arg1Value, s0_.cachedJSClass_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doObjectPrototype(DynamicObject, JSClass, JSContext) */) {
                if ((HasOnlyShapePropertiesNode.isJSObjectPrototype(arg1Value))) {
                    this.objectPrototype_context_ = (JSObject.getJSContext(arg0Value));
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doObjectPrototype(DynamicObject, JSClass, JSContext) */;
                    lock.unlock();
                    hasLock = false;
                    return HasOnlyShapePropertiesNode.doObjectPrototype(arg0Value, arg1Value, this.objectPrototype_context_);
                }
            }
            this.exclude_ = exclude = exclude | 0b11 /* add-exclude doCached(DynamicObject, JSClass, JSClass), doObjectPrototype(DynamicObject, JSClass, JSContext) */;
            this.cached_cache = null;
            state_0 = state_0 & 0xfffffffc /* remove-state_0 doCached(DynamicObject, JSClass, JSClass), doObjectPrototype(DynamicObject, JSClass, JSContext) */;
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doUncached(DynamicObject, JSClass) */;
            lock.unlock();
            hasLock = false;
            return HasOnlyShapePropertiesNode.doUncached(arg0Value, arg1Value);
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
        s[0] = "doCached";
        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, JSClass, JSClass) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s0_ = this.cached_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedJSClass_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doCached(DynamicObject, JSClass, JSClass) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doObjectPrototype";
        if ((state_0 & 0b10) != 0 /* is-state_0 doObjectPrototype(DynamicObject, JSClass, JSContext) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.objectPrototype_context_));
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doObjectPrototype(DynamicObject, JSClass, JSContext) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state_0 & 0b100) != 0 /* is-state_0 doUncached(DynamicObject, JSClass) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static HasOnlyShapePropertiesNode create() {
        return new HasOnlyShapePropertiesNodeGen();
    }

    @GeneratedBy(HasOnlyShapePropertiesNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal JSClass cachedJSClass_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
}
