// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.TriState;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import com.oracle.truffle.js.runtime.builtins.JSArrayBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ArrayElementInfoNode.class)
public final class ArrayElementInfoNodeGen extends ArrayElementInfoNode implements Introspection.Provider {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedData cached_cache;

    private ArrayElementInfoNodeGen() {
    }

    @ExplodeLoop
    @Override
    public TriState execute(JSArrayBase arg0Value, long arg1Value, int arg2Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doCached(JSArrayBase, long, int, ScriptArray) || doUncached(JSArrayBase, long, int) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(JSArrayBase, long, int, ScriptArray) */) {
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    if ((s0_.arrayType_.isInstance(arg0Value.getArrayType()))) {
                        return ArrayElementInfoNode.doCached(arg0Value, arg1Value, arg2Value, s0_.arrayType_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(JSArrayBase, long, int) */) {
                return ArrayElementInfoNode.doUncached(arg0Value, arg1Value, arg2Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private TriState executeAndSpecialize(JSArrayBase arg0Value, long arg1Value, int arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude doCached(JSArrayBase, long, int, ScriptArray) */) {
                int count0_ = 0;
                CachedData s0_ = this.cached_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(JSArrayBase, long, int, ScriptArray) */) {
                    while (s0_ != null) {
                        if ((s0_.arrayType_.isInstance(arg0Value.getArrayType()))) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    {
                        ScriptArray arrayType__ = (arg0Value.getArrayType());
                        if ((arrayType__.isInstance(arg0Value.getArrayType())) && count0_ < (5)) {
                            s0_ = new CachedData(cached_cache);
                            s0_.arrayType_ = arrayType__;
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(JSArrayBase, long, int, ScriptArray) */;
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return ArrayElementInfoNode.doCached(arg0Value, arg1Value, arg2Value, s0_.arrayType_);
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(JSArrayBase, long, int, ScriptArray) */;
            this.cached_cache = null;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(JSArrayBase, long, int, ScriptArray) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(JSArrayBase, long, int) */;
            lock.unlock();
            hasLock = false;
            return ArrayElementInfoNode.doUncached(arg0Value, arg1Value, arg2Value);
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(JSArrayBase, long, int, ScriptArray) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s0_ = this.cached_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.arrayType_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doCached(JSArrayBase, long, int, ScriptArray) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(JSArrayBase, long, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static ArrayElementInfoNode create() {
        return new ArrayElementInfoNodeGen();
    }

    public static ArrayElementInfoNode getUncached() {
        return ArrayElementInfoNodeGen.UNCACHED;
    }

    @GeneratedBy(ArrayElementInfoNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal ScriptArray arrayType_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(ArrayElementInfoNode.class)
    private static final class Uncached extends ArrayElementInfoNode {

        @TruffleBoundary
        @Override
        public TriState execute(JSArrayBase arg0Value, long arg1Value, int arg2Value) {
            return ArrayElementInfoNode.doUncached(arg0Value, arg1Value, arg2Value);
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
}
