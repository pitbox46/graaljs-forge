// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import com.oracle.truffle.js.runtime.objects.JSShape;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsExtensibleNode.class)
public final class IsExtensibleNodeGen extends IsExtensibleNode implements Introspection.Provider {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile resultProfile;
    @CompilationFinal private Shape cachedShape_cachedShape_;
    @CompilationFinal private boolean cachedShape_result_;
    @CompilationFinal private JSClass cachedJSClass_cachedJSClass_;

    private IsExtensibleNodeGen() {
    }

    @Override
    public boolean executeBoolean(DynamicObject arg0Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doCachedShape(DynamicObject, Shape, boolean) || doCachedJSClass(DynamicObject, JSClass, ConditionProfile) || doUncached(DynamicObject, ConditionProfile) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doCachedShape(DynamicObject, Shape, boolean) */) {
                assert (JSShape.getJSClass(this.cachedShape_cachedShape_).usesOrdinaryIsExtensible());
                if ((this.cachedShape_cachedShape_.check(arg0Value))) {
                    return IsExtensibleNode.doCachedShape(arg0Value, this.cachedShape_cachedShape_, this.cachedShape_result_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */) {
                assert (this.cachedJSClass_cachedJSClass_.usesOrdinaryIsExtensible());
                if ((this.cachedJSClass_cachedJSClass_.isInstance(arg0Value))) {
                    return IsExtensibleNode.doCachedJSClass(arg0Value, this.cachedJSClass_cachedJSClass_, this.resultProfile);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doUncached(DynamicObject, ConditionProfile) */) {
                return IsExtensibleNode.doUncached(arg0Value, this.resultProfile);
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
            if (((exclude & 0b1)) == 0 /* is-not-exclude doCachedShape(DynamicObject, Shape, boolean) */) {
                boolean CachedShape_duplicateFound_ = false;
                if ((state_0 & 0b1) != 0 /* is-state_0 doCachedShape(DynamicObject, Shape, boolean) */) {
                    assert (JSShape.getJSClass(this.cachedShape_cachedShape_).usesOrdinaryIsExtensible());
                    if ((this.cachedShape_cachedShape_.check(arg0Value))) {
                        CachedShape_duplicateFound_ = true;
                    }
                }
                if (!CachedShape_duplicateFound_) {
                    {
                        Shape cachedShape_cachedShape__ = (arg0Value.getShape());
                        if ((JSShape.getJSClass(cachedShape_cachedShape__).usesOrdinaryIsExtensible()) && (cachedShape_cachedShape__.check(arg0Value)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 doCachedShape(DynamicObject, Shape, boolean) */) {
                            this.cachedShape_cachedShape_ = cachedShape_cachedShape__;
                            this.cachedShape_result_ = (JSShape.isExtensible(cachedShape_cachedShape__));
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCachedShape(DynamicObject, Shape, boolean) */;
                            CachedShape_duplicateFound_ = true;
                        }
                    }
                }
                if (CachedShape_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return IsExtensibleNode.doCachedShape(arg0Value, this.cachedShape_cachedShape_, this.cachedShape_result_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */) {
                boolean CachedJSClass_duplicateFound_ = false;
                if ((state_0 & 0b10) != 0 /* is-state_0 doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */) {
                    assert (this.cachedJSClass_cachedJSClass_.usesOrdinaryIsExtensible());
                    if ((this.cachedJSClass_cachedJSClass_.isInstance(arg0Value))) {
                        CachedJSClass_duplicateFound_ = true;
                    }
                }
                if (!CachedJSClass_duplicateFound_) {
                    {
                        JSClass cachedJSClass_cachedJSClass__ = (JSGuards.getJSClassChecked(arg0Value));
                        if ((cachedJSClass_cachedJSClass__.usesOrdinaryIsExtensible()) && (cachedJSClass_cachedJSClass__.isInstance(arg0Value)) && ((state_0 & 0b10)) == 0 /* is-not-state_0 doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */) {
                            this.cachedJSClass_cachedJSClass_ = cachedJSClass_cachedJSClass__;
                            this.resultProfile = this.resultProfile == null ? ((ConditionProfile.createBinaryProfile())) : this.resultProfile;
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCachedShape(DynamicObject, Shape, boolean) */;
                            state_0 = state_0 & 0xfffffffe /* remove-state_0 doCachedShape(DynamicObject, Shape, boolean) */;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */;
                            CachedJSClass_duplicateFound_ = true;
                        }
                    }
                }
                if (CachedJSClass_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return IsExtensibleNode.doCachedJSClass(arg0Value, this.cachedJSClass_cachedJSClass_, this.resultProfile);
                }
            }
            this.resultProfile = this.resultProfile == null ? ((ConditionProfile.createBinaryProfile())) : this.resultProfile;
            this.exclude_ = exclude = exclude | 0b11 /* add-exclude doCachedShape(DynamicObject, Shape, boolean), doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */;
            state_0 = state_0 & 0xfffffffc /* remove-state_0 doCachedShape(DynamicObject, Shape, boolean), doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */;
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doUncached(DynamicObject, ConditionProfile) */;
            lock.unlock();
            hasLock = false;
            return IsExtensibleNode.doUncached(arg0Value, this.resultProfile);
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
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doCachedShape";
        if ((state_0 & 0b1) != 0 /* is-state_0 doCachedShape(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cachedShape_cachedShape_, this.cachedShape_result_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doCachedShape(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doCachedJSClass";
        if ((state_0 & 0b10) != 0 /* is-state_0 doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cachedJSClass_cachedJSClass_, this.resultProfile));
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state_0 & 0b100) != 0 /* is-state_0 doUncached(DynamicObject, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.resultProfile));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static IsExtensibleNode create() {
        return new IsExtensibleNodeGen();
    }

    public static IsExtensibleNode getUncached() {
        return IsExtensibleNodeGen.UNCACHED;
    }

    @GeneratedBy(IsExtensibleNode.class)
    private static final class Uncached extends IsExtensibleNode {

        @TruffleBoundary
        @Override
        public boolean executeBoolean(DynamicObject arg0Value) {
            return IsExtensibleNode.doUncached(arg0Value, (ConditionProfile.getUncached()));
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
