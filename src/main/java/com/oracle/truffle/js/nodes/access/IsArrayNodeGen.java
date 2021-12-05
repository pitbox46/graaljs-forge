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
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.runtime.builtins.JSArgumentsObject;
import com.oracle.truffle.js.runtime.builtins.JSArrayObject;
import com.oracle.truffle.js.runtime.builtins.JSTypedArrayObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsArrayNode.class)
public final class IsArrayNodeGen extends IsArrayNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private JSFastArrayShapeData jSFastArrayShape_cache;
    @CompilationFinal private Class<?> otherCached_cachedClass_;

    private IsArrayNodeGen(Kind kind) {
        super(kind);
    }

    @ExplodeLoop
    @Override
    public boolean execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) != 0 /* is-state_0 doJSArray(JSArrayObject) || doJSFastArrayShape(JSArrayObject, Shape, boolean) || doJSFastArray(JSArrayObject) */ && arg0Value instanceof JSArrayObject) {
            JSArrayObject arg0Value_ = (JSArrayObject) arg0Value;
            if ((state_0 & 0b1) != 0 /* is-state_0 doJSArray(JSArrayObject) */) {
                assert (kind == Kind.Array || kind == Kind.AnyArray);
                return doJSArray(arg0Value_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doJSFastArrayShape(JSArrayObject, Shape, boolean) */) {
                assert (kind == Kind.FastArray || kind == Kind.FastOrTypedArray);
                JSFastArrayShapeData s1_ = this.jSFastArrayShape_cache;
                while (s1_ != null) {
                    if ((arg0Value_.getShape() == s1_.cachedShape_)) {
                        return doJSFastArrayShape(arg0Value_, s1_.cachedShape_, s1_.cachedResult_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doJSFastArray(JSArrayObject) */) {
                assert (kind == Kind.FastArray || kind == Kind.FastOrTypedArray);
                return doJSFastArray(arg0Value_);
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doJSTypedArray(JSTypedArrayObject) */ && arg0Value instanceof JSTypedArrayObject) {
            JSTypedArrayObject arg0Value_ = (JSTypedArrayObject) arg0Value;
            assert (kind == Kind.AnyArray || kind == Kind.FastOrTypedArray);
            return doJSTypedArray(arg0Value_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doJSArgumentsObject(JSArgumentsObject) */ && arg0Value instanceof JSArgumentsObject) {
            JSArgumentsObject arg0Value_ = (JSArgumentsObject) arg0Value;
            assert (kind == Kind.AnyArray || kind == Kind.FastOrTypedArray);
            if ((JSGuards.isJSArgumentsObject(arg0Value_))) {
                return doJSArgumentsObject(arg0Value_);
            }
        }
        if ((state_0 & 0b111100000) != 0 /* is-state_0 doJSObjectPrototype(Object) || doNotJSArray(Object) || doOtherCached(Object, Class<>) || doOther(Object) */) {
            if ((state_0 & 0b100000) != 0 /* is-state_0 doJSObjectPrototype(Object) */) {
                assert (kind == Kind.AnyArray);
                if ((JSGuards.isJSObjectPrototype(arg0Value))) {
                    return doJSObjectPrototype(arg0Value);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doNotJSArray(Object) */) {
                assert (kind == Kind.Array || kind == Kind.FastArray);
                if ((!(JSGuards.isJSArray(arg0Value)))) {
                    return doNotJSArray(arg0Value);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doOtherCached(Object, Class<>) */) {
                if ((this.otherCached_cachedClass_.isInstance(arg0Value))) {
                    return doOtherCached(arg0Value, this.otherCached_cachedClass_);
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doOther(Object) */) {
                return doOther(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private boolean executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (arg0Value instanceof JSArrayObject) {
                JSArrayObject arg0Value_ = (JSArrayObject) arg0Value;
                if (((exclude & 0b1)) == 0 /* is-not-exclude doJSArray(JSArrayObject) */) {
                    if ((kind == Kind.Array || kind == Kind.AnyArray)) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doJSArray(JSArrayObject) */;
                        lock.unlock();
                        hasLock = false;
                        return doJSArray(arg0Value_);
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-exclude doJSFastArrayShape(JSArrayObject, Shape, boolean) */ && (kind == Kind.FastArray || kind == Kind.FastOrTypedArray)) {
                    int count1_ = 0;
                    JSFastArrayShapeData s1_ = this.jSFastArrayShape_cache;
                    if ((state_0 & 0b10) != 0 /* is-state_0 doJSFastArrayShape(JSArrayObject, Shape, boolean) */) {
                        while (s1_ != null) {
                            if ((arg0Value_.getShape() == s1_.cachedShape_)) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            Shape cachedShape__ = (arg0Value_.getShape());
                            if ((arg0Value_.getShape() == cachedShape__) && count1_ < (IsArrayNode.MAX_SHAPE_COUNT)) {
                                s1_ = new JSFastArrayShapeData(jSFastArrayShape_cache);
                                s1_.cachedShape_ = cachedShape__;
                                s1_.cachedResult_ = (isArray(arg0Value_));
                                MemoryFence.storeStore();
                                this.jSFastArrayShape_cache = s1_;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doJSFastArrayShape(JSArrayObject, Shape, boolean) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doJSFastArrayShape(arg0Value_, s1_.cachedShape_, s1_.cachedResult_);
                    }
                }
                if (((exclude & 0b100)) == 0 /* is-not-exclude doJSFastArray(JSArrayObject) */) {
                    if ((kind == Kind.FastArray || kind == Kind.FastOrTypedArray)) {
                        this.exclude_ = exclude = exclude | 0b10 /* add-exclude doJSFastArrayShape(JSArrayObject, Shape, boolean) */;
                        this.jSFastArrayShape_cache = null;
                        state_0 = state_0 & 0xfffffffd /* remove-state_0 doJSFastArrayShape(JSArrayObject, Shape, boolean) */;
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doJSFastArray(JSArrayObject) */;
                        lock.unlock();
                        hasLock = false;
                        return doJSFastArray(arg0Value_);
                    }
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-exclude doJSTypedArray(JSTypedArrayObject) */ && arg0Value instanceof JSTypedArrayObject) {
                JSTypedArrayObject arg0Value_ = (JSTypedArrayObject) arg0Value;
                if ((kind == Kind.AnyArray || kind == Kind.FastOrTypedArray)) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doJSTypedArray(JSTypedArrayObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSTypedArray(arg0Value_);
                }
            }
            if (((exclude & 0b10000)) == 0 /* is-not-exclude doJSArgumentsObject(JSArgumentsObject) */ && arg0Value instanceof JSArgumentsObject) {
                JSArgumentsObject arg0Value_ = (JSArgumentsObject) arg0Value;
                if ((kind == Kind.AnyArray || kind == Kind.FastOrTypedArray) && (JSGuards.isJSArgumentsObject(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doJSArgumentsObject(JSArgumentsObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSArgumentsObject(arg0Value_);
                }
            }
            if (((exclude & 0b100000)) == 0 /* is-not-exclude doJSObjectPrototype(Object) */) {
                if ((kind == Kind.AnyArray) && (JSGuards.isJSObjectPrototype(arg0Value))) {
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doJSObjectPrototype(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObjectPrototype(arg0Value);
                }
            }
            if ((kind == Kind.Array || kind == Kind.FastArray) && (!(JSGuards.isJSArray(arg0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doNotJSArray(Object) */;
                lock.unlock();
                hasLock = false;
                return doNotJSArray(arg0Value);
            }
            if (((exclude & 0b1000000)) == 0 /* is-not-exclude doOtherCached(Object, Class<>) */) {
                boolean OtherCached_duplicateFound_ = false;
                if ((state_0 & 0b10000000) != 0 /* is-state_0 doOtherCached(Object, Class<>) */) {
                    if ((this.otherCached_cachedClass_.isInstance(arg0Value))) {
                        OtherCached_duplicateFound_ = true;
                    }
                }
                if (!OtherCached_duplicateFound_) {
                    {
                        Class<?> otherCached_cachedClass__ = (arg0Value.getClass());
                        if ((otherCached_cachedClass__.isInstance(arg0Value)) && ((state_0 & 0b10000000)) == 0 /* is-not-state_0 doOtherCached(Object, Class<>) */) {
                            this.otherCached_cachedClass_ = otherCached_cachedClass__;
                            this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doOtherCached(Object, Class<>) */;
                            OtherCached_duplicateFound_ = true;
                        }
                    }
                }
                if (OtherCached_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return doOtherCached(arg0Value, this.otherCached_cachedClass_);
                }
            }
            this.exclude_ = exclude = exclude | 0b1111111 /* add-exclude doJSArray(JSArrayObject), doJSFastArrayShape(JSArrayObject, Shape, boolean), doJSFastArray(JSArrayObject), doJSTypedArray(JSTypedArrayObject), doJSArgumentsObject(JSArgumentsObject), doJSObjectPrototype(Object), doOtherCached(Object, Class<>) */;
            this.jSFastArrayShape_cache = null;
            state_0 = state_0 & 0xffffff40 /* remove-state_0 doJSArray(JSArrayObject), doJSFastArrayShape(JSArrayObject, Shape, boolean), doJSFastArray(JSArrayObject), doJSTypedArray(JSTypedArrayObject), doJSArgumentsObject(JSArgumentsObject), doJSObjectPrototype(Object), doOtherCached(Object, Class<>) */;
            this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doOther(Object) */;
            lock.unlock();
            hasLock = false;
            return doOther(arg0Value);
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
                JSFastArrayShapeData s1_ = this.jSFastArrayShape_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[10];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doJSArray";
        if ((state_0 & 0b1) != 0 /* is-state_0 doJSArray(JSArrayObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doJSArray(JSArrayObject) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doJSFastArrayShape";
        if ((state_0 & 0b10) != 0 /* is-state_0 doJSFastArrayShape(JSArrayObject, Shape, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            JSFastArrayShapeData s1_ = this.jSFastArrayShape_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedShape_, s1_.cachedResult_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doJSFastArrayShape(JSArrayObject, Shape, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doJSFastArray";
        if ((state_0 & 0b100) != 0 /* is-state_0 doJSFastArray(JSArrayObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-exclude doJSFastArray(JSArrayObject) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doJSTypedArray";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doJSTypedArray(JSTypedArrayObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doJSTypedArray(JSTypedArrayObject) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doJSArgumentsObject";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doJSArgumentsObject(JSArgumentsObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-exclude doJSArgumentsObject(JSArgumentsObject) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doJSObjectPrototype";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doJSObjectPrototype(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000) != 0 /* is-exclude doJSObjectPrototype(Object) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doNotJSArray";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doNotJSArray(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doOtherCached";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doOtherCached(Object, Class<>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.otherCached_cachedClass_));
            s[2] = cached;
        } else if ((exclude & 0b1000000) != 0 /* is-exclude doOtherCached(Object, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        return Provider.create(data);
    }

    public static IsArrayNode create(Kind kind) {
        return new IsArrayNodeGen(kind);
    }

    @GeneratedBy(IsArrayNode.class)
    private static final class JSFastArrayShapeData {

        @CompilationFinal JSFastArrayShapeData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean cachedResult_;

        JSFastArrayShapeData(JSFastArrayShapeData next_) {
            this.next_ = next_;
        }

    }
}
