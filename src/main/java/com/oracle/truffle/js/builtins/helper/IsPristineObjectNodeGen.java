// CheckStyle: start generated
package com.oracle.truffle.js.builtins.helper;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsPristineObjectNode.class)
public final class IsPristineObjectNodeGen extends IsPristineObjectNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedData cached_cache;
    @CompilationFinal(dimensions = 1) private Assumption[] dynamic_assumption0_;

    private IsPristineObjectNodeGen(JSClass jsClass, Shape initialPrototypeShape, Object... propertyKeys) {
        super(jsClass, initialPrototypeShape, propertyKeys);
    }

    @ExplodeLoop
    @Override
    public boolean execute(DynamicObject arg0Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean) || doDynamic(DynamicObject) || doAssumptionsInvalid(DynamicObject) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean) */) {
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    if (!Assumption.isValidAssumption(s0_.assumption0_)) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        removeCached_(s0_);
                        return executeAndSpecialize(arg0Value);
                    }
                    if ((s0_.cachedShape_.check(arg0Value))) {
                        return doCached(arg0Value, s0_.cachedShape_, s0_.isInstanceAndDoesNotOverwriteProps_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doDynamic(DynamicObject) */) {
                if (!Assumption.isValidAssumption(this.dynamic_assumption0_)) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    removeDynamic_();
                    return executeAndSpecialize(arg0Value);
                }
                return doDynamic(arg0Value);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doAssumptionsInvalid(DynamicObject) */) {
                return doAssumptionsInvalid(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private boolean executeAndSpecialize(DynamicObject arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude doCached(DynamicObject, Shape, boolean) */) {
                int count0_ = 0;
                CachedData s0_ = this.cached_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean) */) {
                    while (s0_ != null) {
                        if ((s0_.cachedShape_.check(arg0Value)) && (s0_.assumption0_ == null || Assumption.isValidAssumption(s0_.assumption0_))) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    {
                        Shape cachedShape__ = (arg0Value.getShape());
                        if ((cachedShape__.check(arg0Value))) {
                            Assumption[] assumption0 = (getPropertyFinalAssumptions());
                            if (Assumption.isValidAssumption(assumption0)) {
                                if (count0_ < (3)) {
                                    s0_ = new CachedData(cached_cache);
                                    s0_.cachedShape_ = cachedShape__;
                                    s0_.isInstanceAndDoesNotOverwriteProps_ = (isInstanceAndDoesNotOverwriteProps(cachedShape__));
                                    s0_.assumption0_ = assumption0;
                                    MemoryFence.storeStore();
                                    this.cached_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, Shape, boolean) */;
                                }
                            }
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doCached(arg0Value, s0_.cachedShape_, s0_.isInstanceAndDoesNotOverwriteProps_);
                }
            }
            {
                Assumption[] dynamic_assumption0 = (getPropertyFinalAssumptions());
                if (Assumption.isValidAssumption(dynamic_assumption0)) {
                    this.dynamic_assumption0_ = dynamic_assumption0;
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(DynamicObject, Shape, boolean) */;
                    this.cached_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(DynamicObject, Shape, boolean) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDynamic(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doDynamic(arg0Value);
                }
            }
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doAssumptionsInvalid(DynamicObject) */;
            lock.unlock();
            hasLock = false;
            return doAssumptionsInvalid(arg0Value);
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

    void removeCached_(Object s0_) {
        Lock lock = getLock();
        lock.lock();
        try {
            CachedData prev = null;
            CachedData cur = this.cached_cache;
            while (cur != null) {
                if (cur == s0_) {
                    if (prev == null) {
                        this.cached_cache = cur.next_;
                    } else {
                        prev.next_ = cur.next_;
                    }
                    break;
                }
                prev = cur;
                cur = cur.next_;
            }
            if (this.cached_cache == null) {
                this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 doCached(DynamicObject, Shape, boolean) */;
            }
        } finally {
            lock.unlock();
        }
    }

    void removeDynamic_() {
        Lock lock = getLock();
        lock.lock();
        try {
            this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 doDynamic(DynamicObject) */;
        } finally {
            lock.unlock();
        }
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s0_ = this.cached_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedShape_, s0_.isInstanceAndDoesNotOverwriteProps_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doCached(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDynamic";
        if ((state_0 & 0b10) != 0 /* is-state_0 doDynamic(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doAssumptionsInvalid";
        if ((state_0 & 0b100) != 0 /* is-state_0 doAssumptionsInvalid(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static IsPristineObjectNode create(JSClass jsClass, Shape initialPrototypeShape, Object... propertyKeys) {
        return new IsPristineObjectNodeGen(jsClass, initialPrototypeShape, propertyKeys);
    }

    @GeneratedBy(IsPristineObjectNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean isInstanceAndDoesNotOverwriteProps_;
        @CompilationFinal(dimensions = 1) Assumption[] assumption0_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
}
