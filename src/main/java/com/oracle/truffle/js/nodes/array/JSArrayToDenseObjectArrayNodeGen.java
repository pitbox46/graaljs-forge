// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

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
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSArrayToDenseObjectArrayNode.class)
public final class JSArrayToDenseObjectArrayNodeGen extends JSArrayToDenseObjectArrayNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private FromDenseArrayData fromDenseArray_cache;
    @Child private FromSparseArrayData fromSparseArray_cache;
    @Child private UncachedData uncached_cache;

    private JSArrayToDenseObjectArrayNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    public Object[] executeObjectArray(DynamicObject arg0Value, ScriptArray arg1Value, long arg2Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) || fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) || doUncached(DynamicObject, ScriptArray, long, JSArrayNextElementIndexNode, ReadElementNode, BranchProfile) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) */) {
                FromDenseArrayData s0_ = this.fromDenseArray_cache;
                while (s0_ != null) {
                    if ((s0_.cachedArrayType_.isInstance(arg1Value))) {
                        assert (!(s0_.cachedArrayType_.isHolesType()));
                        if ((!(s0_.cachedArrayType_.hasHoles(arg0Value))) && (s0_.cachedArrayType_.firstElementIndex(arg0Value) == 0)) {
                            return fromDenseArray(arg0Value, arg1Value, arg2Value, s0_.cachedArrayType_, s0_.readNode_);
                        }
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */) {
                FromSparseArrayData s1_ = this.fromSparseArray_cache;
                while (s1_ != null) {
                    if ((s1_.cachedArrayType_.isInstance(arg1Value)) && (s1_.cachedArrayType_.isHolesType() || s1_.cachedArrayType_.hasHoles(arg0Value))) {
                        return fromSparseArray(arg0Value, arg1Value, arg2Value, s1_.cachedArrayType_, s1_.nextElementIndexNode_, s1_.growProfile_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doUncached(DynamicObject, ScriptArray, long, JSArrayNextElementIndexNode, ReadElementNode, BranchProfile) */) {
                UncachedData s2_ = this.uncached_cache;
                if (s2_ != null) {
                    return doUncached(arg0Value, arg1Value, arg2Value, s2_.nextElementIndexNode_, s2_.readNode_, s2_.growProfile_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private Object[] executeAndSpecialize(DynamicObject arg0Value, ScriptArray arg1Value, long arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (((exclude & 0b1)) == 0 /* is-not-exclude fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) */) {
                int count0_ = 0;
                FromDenseArrayData s0_ = this.fromDenseArray_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) */) {
                    while (s0_ != null) {
                        if ((s0_.cachedArrayType_.isInstance(arg1Value))) {
                            assert (!(s0_.cachedArrayType_.isHolesType()));
                            if ((!(s0_.cachedArrayType_.hasHoles(arg0Value))) && (s0_.cachedArrayType_.firstElementIndex(arg0Value) == 0)) {
                                break;
                            }
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    {
                        ScriptArray cachedArrayType__ = (arg1Value);
                        if ((cachedArrayType__.isInstance(arg1Value)) && (!(cachedArrayType__.isHolesType())) && (!(cachedArrayType__.hasHoles(arg0Value))) && (cachedArrayType__.firstElementIndex(arg0Value) == 0) && count0_ < (5)) {
                            s0_ = super.insert(new FromDenseArrayData(fromDenseArray_cache));
                            s0_.cachedArrayType_ = cachedArrayType__;
                            s0_.readNode_ = s0_.insertAccessor((ReadElementNode.create(context)));
                            MemoryFence.storeStore();
                            this.fromDenseArray_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) */;
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return fromDenseArray(arg0Value, arg1Value, arg2Value, s0_.cachedArrayType_, s0_.readNode_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */) {
                int count1_ = 0;
                FromSparseArrayData s1_ = this.fromSparseArray_cache;
                if ((state_0 & 0b10) != 0 /* is-state_0 fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */) {
                    while (s1_ != null) {
                        if ((s1_.cachedArrayType_.isInstance(arg1Value)) && (s1_.cachedArrayType_.isHolesType() || s1_.cachedArrayType_.hasHoles(arg0Value))) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        ScriptArray cachedArrayType__1 = (arg1Value);
                        if ((cachedArrayType__1.isInstance(arg1Value)) && (cachedArrayType__1.isHolesType() || cachedArrayType__1.hasHoles(arg0Value)) && count1_ < (5)) {
                            s1_ = super.insert(new FromSparseArrayData(fromSparseArray_cache));
                            s1_.cachedArrayType_ = cachedArrayType__1;
                            s1_.nextElementIndexNode_ = s1_.insertAccessor((JSArrayNextElementIndexNode.create(context)));
                            s1_.growProfile_ = (BranchProfile.create());
                            MemoryFence.storeStore();
                            this.fromSparseArray_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return fromSparseArray(arg0Value, arg1Value, arg2Value, s1_.cachedArrayType_, s1_.nextElementIndexNode_, s1_.growProfile_);
                }
            }
            UncachedData s2_ = super.insert(new UncachedData());
            s2_.nextElementIndexNode_ = s2_.insertAccessor((JSArrayNextElementIndexNode.create(context)));
            s2_.readNode_ = s2_.insertAccessor((ReadElementNode.create(context)));
            s2_.growProfile_ = (BranchProfile.create());
            MemoryFence.storeStore();
            this.uncached_cache = s2_;
            this.exclude_ = exclude = exclude | 0b11 /* add-exclude fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode), fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */;
            this.fromDenseArray_cache = null;
            this.fromSparseArray_cache = null;
            state_0 = state_0 & 0xfffffffc /* remove-state_0 fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode), fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */;
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doUncached(DynamicObject, ScriptArray, long, JSArrayNextElementIndexNode, ReadElementNode, BranchProfile) */;
            lock.unlock();
            hasLock = false;
            return doUncached(arg0Value, arg1Value, arg2Value, s2_.nextElementIndexNode_, s2_.readNode_, s2_.growProfile_);
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
                FromDenseArrayData s0_ = this.fromDenseArray_cache;
                FromSparseArrayData s1_ = this.fromSparseArray_cache;
                if ((s0_ == null || s0_.next_ == null) && (s1_ == null || s1_.next_ == null)) {
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
        s[0] = "fromDenseArray";
        if ((state_0 & 0b1) != 0 /* is-state_0 fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            FromDenseArrayData s0_ = this.fromDenseArray_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedArrayType_, s0_.readNode_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "fromSparseArray";
        if ((state_0 & 0b10) != 0 /* is-state_0 fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            FromSparseArrayData s1_ = this.fromSparseArray_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedArrayType_, s1_.nextElementIndexNode_, s1_.growProfile_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state_0 & 0b100) != 0 /* is-state_0 doUncached(DynamicObject, ScriptArray, long, JSArrayNextElementIndexNode, ReadElementNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            UncachedData s2_ = this.uncached_cache;
            if (s2_ != null) {
                cached.add(Arrays.asList(s2_.nextElementIndexNode_, s2_.readNode_, s2_.growProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static JSArrayToDenseObjectArrayNode create(JSContext context) {
        return new JSArrayToDenseObjectArrayNodeGen(context);
    }

    @GeneratedBy(JSArrayToDenseObjectArrayNode.class)
    private static final class FromDenseArrayData extends Node {

        @Child FromDenseArrayData next_;
        @CompilationFinal ScriptArray cachedArrayType_;
        @Child ReadElementNode readNode_;

        FromDenseArrayData(FromDenseArrayData next_) {
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
    @GeneratedBy(JSArrayToDenseObjectArrayNode.class)
    private static final class FromSparseArrayData extends Node {

        @Child FromSparseArrayData next_;
        @CompilationFinal ScriptArray cachedArrayType_;
        @Child JSArrayNextElementIndexNode nextElementIndexNode_;
        @CompilationFinal BranchProfile growProfile_;

        FromSparseArrayData(FromSparseArrayData next_) {
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
    @GeneratedBy(JSArrayToDenseObjectArrayNode.class)
    private static final class UncachedData extends Node {

        @Child JSArrayNextElementIndexNode nextElementIndexNode_;
        @Child ReadElementNode readNode_;
        @CompilationFinal BranchProfile growProfile_;

        UncachedData() {
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
