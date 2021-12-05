// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsJSClassNode.class)
public final class IsJSClassNodeGen extends IsJSClassNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private IsInstanceShapeData isInstanceShape_cache;

    private IsJSClassNodeGen(JSClass jsclass, JavaScriptNode operand) {
        super(jsclass, operand);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 doIsInstanceShape(DynamicObject, Shape, boolean) || doIsInstanceObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            if ((state_0 & 0b1) != 0 /* is-state_0 doIsInstanceShape(DynamicObject, Shape, boolean) */) {
                IsInstanceShapeData s0_ = this.isInstanceShape_cache;
                while (s0_ != null) {
                    if ((s0_.cachedShape_.check(operandNodeValue_))) {
                        return IsJSClassNode.doIsInstanceShape(operandNodeValue_, s0_.cachedShape_, s0_.cachedResult_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doIsInstanceObject(DynamicObject) */) {
                return doIsInstanceObject(operandNodeValue_);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doIsInstance(Object) */) {
            return doIsInstance(operandNodeValue);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 doIsInstanceShape(DynamicObject, Shape, boolean) || doIsInstanceObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            if ((state_0 & 0b1) != 0 /* is-state_0 doIsInstanceShape(DynamicObject, Shape, boolean) */) {
                IsInstanceShapeData s0_ = this.isInstanceShape_cache;
                while (s0_ != null) {
                    if ((s0_.cachedShape_.check(operandNodeValue_))) {
                        return IsJSClassNode.doIsInstanceShape(operandNodeValue_, s0_.cachedShape_, s0_.cachedResult_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doIsInstanceObject(DynamicObject) */) {
                return doIsInstanceObject(operandNodeValue_);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doIsInstance(Object) */) {
            return doIsInstance(operandNodeValue);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b11) != 0 /* is-state_0 doIsInstanceShape(DynamicObject, Shape, boolean) || doIsInstanceObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue_)) {
            DynamicObject operandNodeValue__ = (DynamicObject) operandNodeValue_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doIsInstanceShape(DynamicObject, Shape, boolean) */) {
                IsInstanceShapeData s0_ = this.isInstanceShape_cache;
                while (s0_ != null) {
                    if ((s0_.cachedShape_.check(operandNodeValue__))) {
                        return IsJSClassNode.doIsInstanceShape(operandNodeValue__, s0_.cachedShape_, s0_.cachedResult_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doIsInstanceObject(DynamicObject) */) {
                return doIsInstanceObject(operandNodeValue__);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doIsInstance(Object) */) {
            return doIsInstance(operandNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b11) != 0 /* is-state_0 doIsInstanceShape(DynamicObject, Shape, boolean) || doIsInstanceObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue_)) {
            DynamicObject operandNodeValue__ = (DynamicObject) operandNodeValue_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doIsInstanceShape(DynamicObject, Shape, boolean) */) {
                IsInstanceShapeData s0_ = this.isInstanceShape_cache;
                while (s0_ != null) {
                    if ((s0_.cachedShape_.check(operandNodeValue__))) {
                        return IsJSClassNode.doIsInstanceShape(operandNodeValue__, s0_.cachedShape_, s0_.cachedResult_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doIsInstanceObject(DynamicObject) */) {
                return doIsInstanceObject(operandNodeValue__);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doIsInstance(Object) */) {
            return doIsInstance(operandNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    private boolean executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (JSTypes.isDynamicObject(operandNodeValue)) {
                DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
                if (((exclude & 0b1)) == 0 /* is-not-exclude doIsInstanceShape(DynamicObject, Shape, boolean) */) {
                    int count0_ = 0;
                    IsInstanceShapeData s0_ = this.isInstanceShape_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doIsInstanceShape(DynamicObject, Shape, boolean) */) {
                        while (s0_ != null) {
                            if ((s0_.cachedShape_.check(operandNodeValue_))) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        {
                            Shape cachedShape__ = (operandNodeValue_.getShape());
                            if ((cachedShape__.check(operandNodeValue_)) && count0_ < (IsJSClassNode.MAX_SHAPE_COUNT)) {
                                s0_ = new IsInstanceShapeData(isInstanceShape_cache);
                                s0_.cachedShape_ = cachedShape__;
                                s0_.cachedResult_ = (doIsInstance(operandNodeValue_));
                                MemoryFence.storeStore();
                                this.isInstanceShape_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doIsInstanceShape(DynamicObject, Shape, boolean) */;
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return IsJSClassNode.doIsInstanceShape(operandNodeValue_, s0_.cachedShape_, s0_.cachedResult_);
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-exclude doIsInstanceObject(DynamicObject) */) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doIsInstanceShape(DynamicObject, Shape, boolean) */;
                    this.isInstanceShape_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doIsInstanceShape(DynamicObject, Shape, boolean) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doIsInstanceObject(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doIsInstanceObject(operandNodeValue_);
                }
            }
            this.exclude_ = exclude = exclude | 0b11 /* add-exclude doIsInstanceShape(DynamicObject, Shape, boolean), doIsInstanceObject(DynamicObject) */;
            this.isInstanceShape_cache = null;
            state_0 = state_0 & 0xfffffffc /* remove-state_0 doIsInstanceShape(DynamicObject, Shape, boolean), doIsInstanceObject(DynamicObject) */;
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doIsInstance(Object) */;
            lock.unlock();
            hasLock = false;
            return doIsInstance(operandNodeValue);
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
                IsInstanceShapeData s0_ = this.isInstanceShape_cache;
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
        s[0] = "doIsInstanceShape";
        if ((state_0 & 0b1) != 0 /* is-state_0 doIsInstanceShape(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            IsInstanceShapeData s0_ = this.isInstanceShape_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedShape_, s0_.cachedResult_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doIsInstanceShape(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doIsInstanceObject";
        if ((state_0 & 0b10) != 0 /* is-state_0 doIsInstanceObject(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-exclude doIsInstanceObject(DynamicObject) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doIsInstance";
        if ((state_0 & 0b100) != 0 /* is-state_0 doIsInstance(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static IsJSClassNode create(JSClass jsclass, JavaScriptNode operand) {
        return new IsJSClassNodeGen(jsclass, operand);
    }

    @GeneratedBy(IsJSClassNode.class)
    private static final class IsInstanceShapeData {

        @CompilationFinal IsInstanceShapeData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean cachedResult_;

        IsInstanceShapeData(IsInstanceShapeData next_) {
            this.next_ = next_;
        }

    }
}
