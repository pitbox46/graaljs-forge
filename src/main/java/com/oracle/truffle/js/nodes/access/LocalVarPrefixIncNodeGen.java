// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.nodes.unary.JSOverloadedUnaryNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(LocalVarPrefixIncNode.class)
final class LocalVarPrefixIncNodeGen extends LocalVarPrefixIncNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private ObjectData object_cache;

    private LocalVarPrefixIncNodeGen(LocalVarOp op, FrameSlot frameSlot, boolean hasTemporalDeadZone, ScopeFrameNode scopeFrameNode, FrameDescriptor frameDescriptor) {
        super(op, frameSlot, hasTemporalDeadZone, scopeFrameNode, frameDescriptor);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        if (state_0 != 0 /* is-state_0 doBoolean(Frame) || doBooleanDouble(Frame) || doBooleanObject(Frame) || doInt(Frame) || doIntOverflow(Frame) || doIntOverflowObject(Frame) || doDouble(Frame) || doDoubleObject(Frame) || doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, JSOverloadedUnaryNode, JSToNumericNode, BranchProfile) || doSafeInteger(Frame) || doSafeIntegerToDouble(Frame) || doSafeIntegerToObject(Frame) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue_)) && (isIntegerKind(scopeFrameNodeValue_))) {
                    return doBoolean(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doBooleanDouble(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doBooleanDouble(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doBooleanObject(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue_))) {
                    return doBooleanObject(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doInt(Frame) */) {
                if ((isInt(scopeFrameNodeValue_)) && (isIntegerKind(scopeFrameNodeValue_))) {
                    try {
                        return doInt(scopeFrameNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-exclude doInt(Frame) */;
                            this.state_0_ = this.state_0_ & 0xfffffff7 /* remove-state_0 doInt(Frame) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(scopeFrameNodeValue_);
                    }
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doIntOverflow(Frame) */) {
                if ((isInt(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doIntOverflow(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doIntOverflowObject(Frame) */) {
                if ((isInt(scopeFrameNodeValue_))) {
                    return doIntOverflowObject(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doDouble(Frame) */) {
                if ((isDouble(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doDouble(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doDoubleObject(Frame) */) {
                if ((isDouble(scopeFrameNodeValue_))) {
                    return doDoubleObject(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, JSOverloadedUnaryNode, JSToNumericNode, BranchProfile) */) {
                ObjectData s8_ = this.object_cache;
                if (s8_ != null) {
                    if ((isObject(scopeFrameNodeValue_))) {
                        return doObject(scopeFrameNodeValue_, s8_.isNumberProfile_, s8_.isIntegerProfile_, s8_.isBigIntProfile_, s8_.isBoundaryProfile_, s8_.overloadedOperatorNode_, s8_.toNumericOperand_, s8_.deadBranch_);
                    }
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doSafeInteger(Frame) */) {
                if ((isLong(scopeFrameNodeValue_)) && (isLongKind(scopeFrameNodeValue_))) {
                    try {
                        return doSafeInteger(scopeFrameNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100000 /* add-exclude doSafeInteger(Frame) */;
                            this.state_0_ = this.state_0_ & 0xfffffdff /* remove-state_0 doSafeInteger(Frame) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(scopeFrameNodeValue_);
                    }
                }
            }
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSafeIntegerToDouble(Frame) */) {
                if ((isLong(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doSafeIntegerToDouble(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doSafeIntegerToObject(Frame) */) {
                if ((isLong(scopeFrameNodeValue_))) {
                    return doSafeIntegerToObject(scopeFrameNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, JSOverloadedUnaryNode, JSToNumericNode, BranchProfile) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        if ((state_0 & 0b110011110000) != 0 /* is-state_0 doIntOverflow(Frame) || doIntOverflowObject(Frame) || doDouble(Frame) || doDoubleObject(Frame) || doSafeIntegerToDouble(Frame) || doSafeIntegerToObject(Frame) */) {
            if ((state_0 & 0b10000) != 0 /* is-state_0 doIntOverflow(Frame) */) {
                if ((isInt(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doIntOverflow(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doIntOverflowObject(Frame) */) {
                if ((isInt(scopeFrameNodeValue_))) {
                    return doIntOverflowObject(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doDouble(Frame) */) {
                if ((isDouble(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doDouble(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doDoubleObject(Frame) */) {
                if ((isDouble(scopeFrameNodeValue_))) {
                    return doDoubleObject(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSafeIntegerToDouble(Frame) */) {
                if ((isLong(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doSafeIntegerToDouble(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doSafeIntegerToObject(Frame) */) {
                if ((isLong(scopeFrameNodeValue_))) {
                    return doSafeIntegerToObject(scopeFrameNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(scopeFrameNodeValue_));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, JSOverloadedUnaryNode, JSToNumericNode, BranchProfile) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        if ((state_0 & 0b1111) != 0 /* is-state_0 doBoolean(Frame) || doBooleanDouble(Frame) || doBooleanObject(Frame) || doInt(Frame) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue_)) && (isIntegerKind(scopeFrameNodeValue_))) {
                    return doBoolean(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doBooleanDouble(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doBooleanDouble(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doBooleanObject(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue_))) {
                    return doBooleanObject(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doInt(Frame) */) {
                if ((isInt(scopeFrameNodeValue_)) && (isIntegerKind(scopeFrameNodeValue_))) {
                    try {
                        return doInt(scopeFrameNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-exclude doInt(Frame) */;
                            this.state_0_ = this.state_0_ & 0xfffffff7 /* remove-state_0 doInt(Frame) */;
                        } finally {
                            lock.unlock();
                        }
                        return JSTypesGen.expectInteger(executeAndSpecialize(scopeFrameNodeValue_));
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(scopeFrameNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b111111110000) == 0 /* only-active doBoolean(Frame) && doBooleanDouble(Frame) && doBooleanObject(Frame) && doInt(Frame) */ && (state_0 != 0  /* is-not doBoolean(Frame) && doBooleanDouble(Frame) && doBooleanObject(Frame) && doInt(Frame) && doIntOverflow(Frame) && doIntOverflowObject(Frame) && doDouble(Frame) && doDoubleObject(Frame) && doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, JSOverloadedUnaryNode, JSToNumericNode, BranchProfile) && doSafeInteger(Frame) && doSafeIntegerToDouble(Frame) && doSafeIntegerToObject(Frame) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b1100001111) == 0 /* only-active doIntOverflow(Frame) && doIntOverflowObject(Frame) && doDouble(Frame) && doDoubleObject(Frame) && doSafeIntegerToDouble(Frame) && doSafeIntegerToObject(Frame) */ && (state_0 != 0  /* is-not doBoolean(Frame) && doBooleanDouble(Frame) && doBooleanObject(Frame) && doInt(Frame) && doIntOverflow(Frame) && doIntOverflowObject(Frame) && doDouble(Frame) && doDoubleObject(Frame) && doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, JSOverloadedUnaryNode, JSToNumericNode, BranchProfile) && doSafeInteger(Frame) && doSafeIntegerToDouble(Frame) && doSafeIntegerToObject(Frame) */)) {
                executeDouble(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Frame scopeFrameNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (((exclude & 0b1)) == 0 /* is-not-exclude doBoolean(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue)) && (isIntegerKind(scopeFrameNodeValue))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBoolean(Frame) */;
                    lock.unlock();
                    hasLock = false;
                    return doBoolean(scopeFrameNodeValue);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doBooleanDouble(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue)) && (isDoubleKind(scopeFrameNodeValue))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doBoolean(Frame) */;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doBoolean(Frame) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doBooleanDouble(Frame) */;
                    lock.unlock();
                    hasLock = false;
                    return doBooleanDouble(scopeFrameNodeValue);
                }
            }
            if ((isBoolean(scopeFrameNodeValue))) {
                this.exclude_ = exclude = exclude | 0b11 /* add-exclude doBoolean(Frame), doBooleanDouble(Frame) */;
                state_0 = state_0 & 0xfffffffc /* remove-state_0 doBoolean(Frame), doBooleanDouble(Frame) */;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doBooleanObject(Frame) */;
                lock.unlock();
                hasLock = false;
                return doBooleanObject(scopeFrameNodeValue);
            }
            if (((exclude & 0b100)) == 0 /* is-not-exclude doInt(Frame) */) {
                if ((isInt(scopeFrameNodeValue)) && (isIntegerKind(scopeFrameNodeValue))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doInt(Frame) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return doInt(scopeFrameNodeValue);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-exclude doInt(Frame) */;
                            this.state_0_ = this.state_0_ & 0xfffffff7 /* remove-state_0 doInt(Frame) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(scopeFrameNodeValue);
                    }
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-exclude doIntOverflow(Frame) */) {
                if ((isInt(scopeFrameNodeValue)) && (isDoubleKind(scopeFrameNodeValue))) {
                    this.exclude_ = exclude = exclude | 0b100 /* add-exclude doInt(Frame) */;
                    state_0 = state_0 & 0xfffffff7 /* remove-state_0 doInt(Frame) */;
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doIntOverflow(Frame) */;
                    lock.unlock();
                    hasLock = false;
                    return doIntOverflow(scopeFrameNodeValue);
                }
            }
            if ((isInt(scopeFrameNodeValue))) {
                this.exclude_ = exclude = exclude | 0b1100 /* add-exclude doInt(Frame), doIntOverflow(Frame) */;
                state_0 = state_0 & 0xffffffe7 /* remove-state_0 doInt(Frame), doIntOverflow(Frame) */;
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doIntOverflowObject(Frame) */;
                lock.unlock();
                hasLock = false;
                return doIntOverflowObject(scopeFrameNodeValue);
            }
            if (((exclude & 0b10000)) == 0 /* is-not-exclude doDouble(Frame) */) {
                if ((isDouble(scopeFrameNodeValue)) && (isDoubleKind(scopeFrameNodeValue))) {
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doDouble(Frame) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(scopeFrameNodeValue);
                }
            }
            if ((isDouble(scopeFrameNodeValue))) {
                this.exclude_ = exclude = exclude | 0b10000 /* add-exclude doDouble(Frame) */;
                state_0 = state_0 & 0xffffffbf /* remove-state_0 doDouble(Frame) */;
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doDoubleObject(Frame) */;
                lock.unlock();
                hasLock = false;
                return doDoubleObject(scopeFrameNodeValue);
            }
            if ((isObject(scopeFrameNodeValue))) {
                ObjectData s8_ = super.insert(new ObjectData());
                s8_.isNumberProfile_ = (ConditionProfile.createBinaryProfile());
                s8_.isIntegerProfile_ = (ConditionProfile.createBinaryProfile());
                s8_.isBigIntProfile_ = (ConditionProfile.createBinaryProfile());
                s8_.isBoundaryProfile_ = (ConditionProfile.createBinaryProfile());
                s8_.overloadedOperatorNode_ = s8_.insertAccessor((JSOverloadedUnaryNode.create(getOverloadedOperatorName())));
                s8_.toNumericOperand_ = s8_.insertAccessor((JSToNumericNode.createToNumericOperand()));
                s8_.deadBranch_ = (BranchProfile.create());
                MemoryFence.storeStore();
                this.object_cache = s8_;
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, JSOverloadedUnaryNode, JSToNumericNode, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doObject(scopeFrameNodeValue, s8_.isNumberProfile_, s8_.isIntegerProfile_, s8_.isBigIntProfile_, s8_.isBoundaryProfile_, s8_.overloadedOperatorNode_, s8_.toNumericOperand_, s8_.deadBranch_);
            }
            if (((exclude & 0b100000)) == 0 /* is-not-exclude doSafeInteger(Frame) */) {
                if ((isLong(scopeFrameNodeValue)) && (isLongKind(scopeFrameNodeValue))) {
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doSafeInteger(Frame) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return doSafeInteger(scopeFrameNodeValue);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100000 /* add-exclude doSafeInteger(Frame) */;
                            this.state_0_ = this.state_0_ & 0xfffffdff /* remove-state_0 doSafeInteger(Frame) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(scopeFrameNodeValue);
                    }
                }
            }
            if (((exclude & 0b1000000)) == 0 /* is-not-exclude doSafeIntegerToDouble(Frame) */) {
                if ((isLong(scopeFrameNodeValue)) && (isDoubleKind(scopeFrameNodeValue))) {
                    this.exclude_ = exclude = exclude | 0b100000 /* add-exclude doSafeInteger(Frame) */;
                    state_0 = state_0 & 0xfffffdff /* remove-state_0 doSafeInteger(Frame) */;
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doSafeIntegerToDouble(Frame) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeIntegerToDouble(scopeFrameNodeValue);
                }
            }
            if ((isLong(scopeFrameNodeValue))) {
                this.exclude_ = exclude = exclude | 0b1100000 /* add-exclude doSafeInteger(Frame), doSafeIntegerToDouble(Frame) */;
                state_0 = state_0 & 0xfffff9ff /* remove-state_0 doSafeInteger(Frame), doSafeIntegerToDouble(Frame) */;
                this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doSafeIntegerToObject(Frame) */;
                lock.unlock();
                hasLock = false;
                return doSafeIntegerToObject(scopeFrameNodeValue);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.scopeFrameNode}, scopeFrameNodeValue);
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
        Object[] data = new Object[13];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doBoolean(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doBooleanDouble";
        if ((state_0 & 0b10) != 0 /* is-state_0 doBooleanDouble(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-exclude doBooleanDouble(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doBooleanObject";
        if ((state_0 & 0b100) != 0 /* is-state_0 doBooleanObject(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doInt(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-exclude doInt(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doIntOverflow";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doIntOverflow(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doIntOverflow(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doIntOverflowObject";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doIntOverflowObject(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doDouble(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-exclude doDouble(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doDoubleObject";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doDoubleObject(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, JSOverloadedUnaryNode, JSToNumericNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ObjectData s8_ = this.object_cache;
            if (s8_ != null) {
                cached.add(Arrays.asList(s8_.isNumberProfile_, s8_.isIntegerProfile_, s8_.isBigIntProfile_, s8_.isBoundaryProfile_, s8_.overloadedOperatorNode_, s8_.toNumericOperand_, s8_.deadBranch_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doSafeInteger(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000) != 0 /* is-exclude doSafeInteger(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doSafeIntegerToDouble";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSafeIntegerToDouble(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000000) != 0 /* is-exclude doSafeIntegerToDouble(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doSafeIntegerToObject";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doSafeIntegerToObject(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        return Provider.create(data);
    }

    public static LocalVarPrefixIncNode create(LocalVarOp op, FrameSlot frameSlot, boolean hasTemporalDeadZone, ScopeFrameNode scopeFrameNode, FrameDescriptor frameDescriptor) {
        return new LocalVarPrefixIncNodeGen(op, frameSlot, hasTemporalDeadZone, scopeFrameNode, frameDescriptor);
    }

    @GeneratedBy(LocalVarPrefixIncNode.class)
    private static final class ObjectData extends Node {

        @CompilationFinal ConditionProfile isNumberProfile_;
        @CompilationFinal ConditionProfile isIntegerProfile_;
        @CompilationFinal ConditionProfile isBigIntProfile_;
        @CompilationFinal ConditionProfile isBoundaryProfile_;
        @Child JSOverloadedUnaryNode overloadedOperatorNode_;
        @Child JSToNumericNode toNumericOperand_;
        @CompilationFinal BranchProfile deadBranch_;

        ObjectData() {
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
