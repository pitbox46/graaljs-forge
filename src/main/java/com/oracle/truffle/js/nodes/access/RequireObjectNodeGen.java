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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RequireObjectNode.class)
public final class RequireObjectNodeGen extends RequireObjectNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ObjectShapeData objectShape_cache;

    private RequireObjectNodeGen(JavaScriptNode operand) {
        super(operand);
    }

    @ExplodeLoop
    @Override
    public Object execute(Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doObjectShape(DynamicObject, Shape, boolean) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            ObjectShapeData s0_ = this.objectShape_cache;
            while (s0_ != null) {
                if ((s0_.cachedShape_.check(operandNodeValue_))) {
                    return RequireObjectNode.doObjectShape(operandNodeValue_, s0_.cachedShape_, s0_.cachedResult_);
                }
                s0_ = s0_.next_;
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doObject(Object) */) {
            return RequireObjectNode.doObject(operandNodeValue);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doObjectShape(DynamicObject, Shape, boolean) */ && JSTypes.isDynamicObject(operandNodeValue_)) {
            DynamicObject operandNodeValue__ = (DynamicObject) operandNodeValue_;
            ObjectShapeData s0_ = this.objectShape_cache;
            while (s0_ != null) {
                if ((s0_.cachedShape_.check(operandNodeValue__))) {
                    return RequireObjectNode.doObjectShape(operandNodeValue__, s0_.cachedShape_, s0_.cachedResult_);
                }
                s0_ = s0_.next_;
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doObject(Object) */) {
            return RequireObjectNode.doObject(operandNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude doObjectShape(DynamicObject, Shape, boolean) */ && JSTypes.isDynamicObject(operandNodeValue)) {
                DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
                int count0_ = 0;
                ObjectShapeData s0_ = this.objectShape_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 doObjectShape(DynamicObject, Shape, boolean) */) {
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
                        if ((cachedShape__.check(operandNodeValue_)) && count0_ < (RequireObjectNode.MAX_SHAPE_COUNT)) {
                            s0_ = new ObjectShapeData(objectShape_cache);
                            s0_.cachedShape_ = cachedShape__;
                            s0_.cachedResult_ = (JSGuards.isJSObject(operandNodeValue_));
                            MemoryFence.storeStore();
                            this.objectShape_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doObjectShape(DynamicObject, Shape, boolean) */;
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return RequireObjectNode.doObjectShape(operandNodeValue_, s0_.cachedShape_, s0_.cachedResult_);
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doObjectShape(DynamicObject, Shape, boolean) */;
            this.objectShape_cache = null;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 doObjectShape(DynamicObject, Shape, boolean) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doObject(Object) */;
            lock.unlock();
            hasLock = false;
            return RequireObjectNode.doObject(operandNodeValue);
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
                ObjectShapeData s0_ = this.objectShape_cache;
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
        s[0] = "doObjectShape";
        if ((state_0 & 0b1) != 0 /* is-state_0 doObjectShape(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ObjectShapeData s0_ = this.objectShape_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.cachedShape_, s0_.cachedResult_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doObjectShape(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b10) != 0 /* is-state_0 doObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static RequireObjectNode create(JavaScriptNode operand) {
        return new RequireObjectNodeGen(operand);
    }

    @GeneratedBy(RequireObjectNode.class)
    private static final class ObjectShapeData {

        @CompilationFinal ObjectShapeData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean cachedResult_;

        ObjectShapeData(ObjectShapeData next_) {
            this.next_ = next_;
        }

    }
}
