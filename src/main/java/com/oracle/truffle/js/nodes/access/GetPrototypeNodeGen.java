// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.Property;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GetPrototypeNode.class)
public final class GetPrototypeNodeGen extends GetPrototypeNode implements Introspection.Provider {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedShapeData cachedShape_cache;
    @CompilationFinal private JSClassProfile proxy_jsclassProfile_;

    private GetPrototypeNodeGen() {
    }

    @ExplodeLoop
    @Override
    public DynamicObject executeJSObject(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) != 0 /* is-state_0 doCachedShape(DynamicObject, Shape, Property) || doGeneric(DynamicObject) || doProxy(DynamicObject, JSClassProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state_0 & 0b1) != 0 /* is-state_0 doCachedShape(DynamicObject, Shape, Property) */) {
                CachedShapeData s0_ = this.cachedShape_cache;
                while (s0_ != null) {
                    if ((arg0Value_.getShape() == s0_.shape_)) {
                        assert (s0_.prototypeProperty_ != null);
                        return GetPrototypeNode.doCachedShape(arg0Value_, s0_.shape_, s0_.prototypeProperty_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doGeneric(DynamicObject) */) {
                if ((!(JSGuards.isJSProxy(arg0Value_)))) {
                    return GetPrototypeNode.doGeneric(arg0Value_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doProxy(DynamicObject, JSClassProfile) */) {
                if ((JSGuards.isJSProxy(arg0Value_))) {
                    return GetPrototypeNode.doProxy(arg0Value_, this.proxy_jsclassProfile_);
                }
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doNotObject(Object) */) {
            if ((!(JSGuards.isDynamicObject(arg0Value)))) {
                return GetPrototypeNode.doNotObject(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @ExplodeLoop
    @Override
    protected DynamicObject executeDynamicObject(DynamicObject arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) != 0 /* is-state_0 doCachedShape(DynamicObject, Shape, Property) || doGeneric(DynamicObject) || doProxy(DynamicObject, JSClassProfile) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doCachedShape(DynamicObject, Shape, Property) */) {
                CachedShapeData s0_ = this.cachedShape_cache;
                while (s0_ != null) {
                    if ((arg0Value.getShape() == s0_.shape_)) {
                        assert (s0_.prototypeProperty_ != null);
                        return GetPrototypeNode.doCachedShape(arg0Value, s0_.shape_, s0_.prototypeProperty_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doGeneric(DynamicObject) */) {
                if ((!(JSGuards.isJSProxy(arg0Value)))) {
                    return GetPrototypeNode.doGeneric(arg0Value);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doProxy(DynamicObject, JSClassProfile) */) {
                if ((JSGuards.isJSProxy(arg0Value))) {
                    return GetPrototypeNode.doProxy(arg0Value, this.proxy_jsclassProfile_);
                }
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doNotObject(Object) */) {
            if ((!(JSGuards.isDynamicObject(arg0Value)))) {
                return GetPrototypeNode.doNotObject(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private DynamicObject executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((exclude) == 0 /* is-not-exclude doCachedShape(DynamicObject, Shape, Property) */) {
                    int count0_ = 0;
                    CachedShapeData s0_ = this.cachedShape_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCachedShape(DynamicObject, Shape, Property) */) {
                        while (s0_ != null) {
                            if ((arg0Value_.getShape() == s0_.shape_)) {
                                assert (s0_.prototypeProperty_ != null);
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        {
                            Shape shape__ = (arg0Value_.getShape());
                            if ((arg0Value_.getShape() == shape__)) {
                                Property prototypeProperty__ = (GetPrototypeNode.getPrototypeProperty(shape__));
                                if ((prototypeProperty__ != null) && count0_ < (GetPrototypeNode.MAX_SHAPE_COUNT)) {
                                    s0_ = new CachedShapeData(cachedShape_cache);
                                    s0_.shape_ = shape__;
                                    s0_.prototypeProperty_ = prototypeProperty__;
                                    MemoryFence.storeStore();
                                    this.cachedShape_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCachedShape(DynamicObject, Shape, Property) */;
                                }
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return GetPrototypeNode.doCachedShape(arg0Value_, s0_.shape_, s0_.prototypeProperty_);
                    }
                }
                if ((!(JSGuards.isJSProxy(arg0Value_)))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCachedShape(DynamicObject, Shape, Property) */;
                    this.cachedShape_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doCachedShape(DynamicObject, Shape, Property) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doGeneric(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return GetPrototypeNode.doGeneric(arg0Value_);
                }
                if ((JSGuards.isJSProxy(arg0Value_))) {
                    this.proxy_jsclassProfile_ = (JSClassProfile.create());
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doProxy(DynamicObject, JSClassProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return GetPrototypeNode.doProxy(arg0Value_, this.proxy_jsclassProfile_);
                }
            }
            if ((!(JSGuards.isDynamicObject(arg0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doNotObject(Object) */;
                lock.unlock();
                hasLock = false;
                return GetPrototypeNode.doNotObject(arg0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
                CachedShapeData s0_ = this.cachedShape_cache;
                if ((s0_ == null || s0_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[5];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doCachedShape";
        if ((state_0 & 0b1) != 0 /* is-state_0 doCachedShape(DynamicObject, Shape, Property) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedShapeData s0_ = this.cachedShape_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.shape_, s0_.prototypeProperty_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doCachedShape(DynamicObject, Shape, Property) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state_0 & 0b10) != 0 /* is-state_0 doGeneric(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doProxy";
        if ((state_0 & 0b100) != 0 /* is-state_0 doProxy(DynamicObject, JSClassProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.proxy_jsclassProfile_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doNotObject";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doNotObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static GetPrototypeNode create() {
        return new GetPrototypeNodeGen();
    }

    public static GetPrototypeNode getUncached() {
        return GetPrototypeNodeGen.UNCACHED;
    }

    @GeneratedBy(GetPrototypeNode.class)
    private static final class CachedShapeData {

        @CompilationFinal CachedShapeData next_;
        @CompilationFinal Shape shape_;
        @CompilationFinal Property prototypeProperty_;

        CachedShapeData(CachedShapeData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(GetPrototypeNode.class)
    private static final class Uncached extends GetPrototypeNode {

        @TruffleBoundary
        @Override
        public DynamicObject executeJSObject(Object arg0Value) {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((!(JSGuards.isJSProxy(arg0Value_)))) {
                    return GetPrototypeNode.doGeneric(arg0Value_);
                }
                if ((JSGuards.isJSProxy(arg0Value_))) {
                    return GetPrototypeNode.doProxy(arg0Value_, (JSClassProfile.getUncached()));
                }
            }
            if ((!(JSGuards.isDynamicObject(arg0Value)))) {
                return GetPrototypeNode.doNotObject(arg0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
        }

        @TruffleBoundary
        @Override
        protected DynamicObject executeDynamicObject(DynamicObject arg0Value) {
            if ((!(JSGuards.isJSProxy(arg0Value)))) {
                return GetPrototypeNode.doGeneric(arg0Value);
            }
            if ((JSGuards.isJSProxy(arg0Value))) {
                return GetPrototypeNode.doProxy(arg0Value, (JSClassProfile.getUncached()));
            }
            if ((!(JSGuards.isDynamicObject(arg0Value)))) {
                return GetPrototypeNode.doNotObject(arg0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
