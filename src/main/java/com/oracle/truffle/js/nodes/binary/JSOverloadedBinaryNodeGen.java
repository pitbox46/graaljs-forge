// CheckStyle: start generated
package com.oracle.truffle.js.nodes.binary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.nodes.cast.JSToOperandNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.cast.JSToPrimitiveNode.Hint;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;
import com.oracle.truffle.js.runtime.objects.OperatorSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSOverloadedBinaryNode.class)
public final class JSOverloadedBinaryNodeGen extends JSOverloadedBinaryNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private ToOperandGenericData toOperandGeneric_cache;
    @Child private ToOperandAdditionData toOperandAddition_cache;
    @Child private ToNumericOperandData toNumericOperand_cache;

    private JSOverloadedBinaryNodeGen(String overloadedOperatorName, boolean numeric, Hint hint, boolean leftToRight) {
        super(overloadedOperatorName, numeric, hint, leftToRight);
    }

    @Override
    public Object execute(Object arg0Value, Object arg1Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doToOperandGeneric(Object, Object, JSToOperandNode, JSToOperandNode, DispatchBinaryOperatorNode) || doToOperandAddition(Object, Object, JSToOperandNode, JSToOperandNode, DispatchBinaryOperatorNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode) || doToNumericOperand(Object, Object, JSToNumericNode, JSToNumericNode, DispatchBinaryOperatorNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doToOperandGeneric(Object, Object, JSToOperandNode, JSToOperandNode, DispatchBinaryOperatorNode) */) {
                ToOperandGenericData s0_ = this.toOperandGeneric_cache;
                if (s0_ != null) {
                    assert (!(isNumeric()));
                    assert (!(isAddition()));
                    return doToOperandGeneric(arg0Value, arg1Value, s0_.toOperandLeftNode_, s0_.toOperandRightNode_, s0_.dispatchBinaryOperatorNode_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doToOperandAddition(Object, Object, JSToOperandNode, JSToOperandNode, DispatchBinaryOperatorNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode) */) {
                ToOperandAdditionData s1_ = this.toOperandAddition_cache;
                if (s1_ != null) {
                    assert (!(isNumeric()));
                    assert (isAddition());
                    return doToOperandAddition(arg0Value, arg1Value, s1_.toOperandLeftNode_, s1_.toOperandRightNode_, s1_.dispatchBinaryOperatorNode_, s1_.toStringLeftNode_, s1_.toStringRightNode_, s1_.leftStringProfile_, s1_.rightStringProfile_, s1_.addNode_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doToNumericOperand(Object, Object, JSToNumericNode, JSToNumericNode, DispatchBinaryOperatorNode) */) {
                ToNumericOperandData s2_ = this.toNumericOperand_cache;
                if (s2_ != null) {
                    assert (isNumeric());
                    return doToNumericOperand(arg0Value, arg1Value, s2_.toNumericOperandLeftNode_, s2_.toNumericOperandRightNode_, s2_.dispatchBinaryOperatorNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private Object executeAndSpecialize(Object arg0Value, Object arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if ((!(isNumeric())) && (!(isAddition()))) {
                ToOperandGenericData s0_ = super.insert(new ToOperandGenericData());
                s0_.toOperandLeftNode_ = s0_.insertAccessor((JSToOperandNode.create(getHint(), !(isEquality()))));
                s0_.toOperandRightNode_ = s0_.insertAccessor((JSToOperandNode.create(getHint(), !(isEquality()))));
                s0_.dispatchBinaryOperatorNode_ = s0_.insertAccessor((DispatchBinaryOperatorNode.create(getOverloadedOperatorName())));
                MemoryFence.storeStore();
                this.toOperandGeneric_cache = s0_;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doToOperandGeneric(Object, Object, JSToOperandNode, JSToOperandNode, DispatchBinaryOperatorNode) */;
                lock.unlock();
                hasLock = false;
                return doToOperandGeneric(arg0Value, arg1Value, s0_.toOperandLeftNode_, s0_.toOperandRightNode_, s0_.dispatchBinaryOperatorNode_);
            }
            if ((!(isNumeric())) && (isAddition())) {
                ToOperandAdditionData s1_ = super.insert(new ToOperandAdditionData());
                s1_.toOperandLeftNode_ = s1_.insertAccessor((JSToOperandNode.create(getHint())));
                s1_.toOperandRightNode_ = s1_.insertAccessor((JSToOperandNode.create(getHint())));
                s1_.dispatchBinaryOperatorNode_ = s1_.insertAccessor((DispatchBinaryOperatorNode.create(getOverloadedOperatorName())));
                s1_.toStringLeftNode_ = s1_.insertAccessor((JSToStringNode.create()));
                s1_.toStringRightNode_ = s1_.insertAccessor((JSToStringNode.create()));
                s1_.leftStringProfile_ = (ConditionProfile.createBinaryProfile());
                s1_.rightStringProfile_ = (ConditionProfile.createBinaryProfile());
                s1_.addNode_ = s1_.insertAccessor((JSAddNode.createUnoptimized()));
                MemoryFence.storeStore();
                this.toOperandAddition_cache = s1_;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doToOperandAddition(Object, Object, JSToOperandNode, JSToOperandNode, DispatchBinaryOperatorNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode) */;
                lock.unlock();
                hasLock = false;
                return doToOperandAddition(arg0Value, arg1Value, s1_.toOperandLeftNode_, s1_.toOperandRightNode_, s1_.dispatchBinaryOperatorNode_, s1_.toStringLeftNode_, s1_.toStringRightNode_, s1_.leftStringProfile_, s1_.rightStringProfile_, s1_.addNode_);
            }
            if ((isNumeric())) {
                ToNumericOperandData s2_ = super.insert(new ToNumericOperandData());
                s2_.toNumericOperandLeftNode_ = s2_.insertAccessor((JSToNumericNode.create(true)));
                s2_.toNumericOperandRightNode_ = s2_.insertAccessor((JSToNumericNode.create(true)));
                s2_.dispatchBinaryOperatorNode_ = s2_.insertAccessor((DispatchBinaryOperatorNode.create(getOverloadedOperatorName())));
                MemoryFence.storeStore();
                this.toNumericOperand_cache = s2_;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doToNumericOperand(Object, Object, JSToNumericNode, JSToNumericNode, DispatchBinaryOperatorNode) */;
                lock.unlock();
                hasLock = false;
                return doToNumericOperand(arg0Value, arg1Value, s2_.toNumericOperandLeftNode_, s2_.toNumericOperandRightNode_, s2_.dispatchBinaryOperatorNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
        s = new Object[3];
        s[0] = "doToOperandGeneric";
        if ((state_0 & 0b1) != 0 /* is-state_0 doToOperandGeneric(Object, Object, JSToOperandNode, JSToOperandNode, DispatchBinaryOperatorNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ToOperandGenericData s0_ = this.toOperandGeneric_cache;
            if (s0_ != null) {
                cached.add(Arrays.asList(s0_.toOperandLeftNode_, s0_.toOperandRightNode_, s0_.dispatchBinaryOperatorNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doToOperandAddition";
        if ((state_0 & 0b10) != 0 /* is-state_0 doToOperandAddition(Object, Object, JSToOperandNode, JSToOperandNode, DispatchBinaryOperatorNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ToOperandAdditionData s1_ = this.toOperandAddition_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.toOperandLeftNode_, s1_.toOperandRightNode_, s1_.dispatchBinaryOperatorNode_, s1_.toStringLeftNode_, s1_.toStringRightNode_, s1_.leftStringProfile_, s1_.rightStringProfile_, s1_.addNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doToNumericOperand";
        if ((state_0 & 0b100) != 0 /* is-state_0 doToNumericOperand(Object, Object, JSToNumericNode, JSToNumericNode, DispatchBinaryOperatorNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ToNumericOperandData s2_ = this.toNumericOperand_cache;
            if (s2_ != null) {
                cached.add(Arrays.asList(s2_.toNumericOperandLeftNode_, s2_.toNumericOperandRightNode_, s2_.dispatchBinaryOperatorNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static JSOverloadedBinaryNode create(String overloadedOperatorName, boolean numeric, Hint hint, boolean leftToRight) {
        return new JSOverloadedBinaryNodeGen(overloadedOperatorName, numeric, hint, leftToRight);
    }

    @GeneratedBy(JSOverloadedBinaryNode.class)
    private static final class ToOperandGenericData extends Node {

        @Child JSToOperandNode toOperandLeftNode_;
        @Child JSToOperandNode toOperandRightNode_;
        @Child DispatchBinaryOperatorNode dispatchBinaryOperatorNode_;

        ToOperandGenericData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSOverloadedBinaryNode.class)
    private static final class ToOperandAdditionData extends Node {

        @Child JSToOperandNode toOperandLeftNode_;
        @Child JSToOperandNode toOperandRightNode_;
        @Child DispatchBinaryOperatorNode dispatchBinaryOperatorNode_;
        @Child JSToStringNode toStringLeftNode_;
        @Child JSToStringNode toStringRightNode_;
        @CompilationFinal ConditionProfile leftStringProfile_;
        @CompilationFinal ConditionProfile rightStringProfile_;
        @Child JSAddNode addNode_;

        ToOperandAdditionData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSOverloadedBinaryNode.class)
    private static final class ToNumericOperandData extends Node {

        @Child JSToNumericNode toNumericOperandLeftNode_;
        @Child JSToNumericNode toNumericOperandRightNode_;
        @Child DispatchBinaryOperatorNode dispatchBinaryOperatorNode_;

        ToNumericOperandData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(DispatchBinaryOperatorNode.class)
    public static final class DispatchBinaryOperatorNodeGen extends DispatchBinaryOperatorNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private OverloadedOverloadedData overloadedOverloaded_cache;
        @Child private OverloadedNumberData overloadedNumber_cache;
        @Child private OverloadedBigIntData overloadedBigInt_cache;
        @Child private OverloadedStringData overloadedString_cache;
        @Child private NumberOverloadedData numberOverloaded_cache;
        @Child private BigIntOverloadedData bigIntOverloaded_cache;
        @Child private StringOverloadedData stringOverloaded_cache;
        @Child private JSFunctionCallNode generic_callNode_;

        private DispatchBinaryOperatorNodeGen(String overloadedOperatorName) {
            super(overloadedOperatorName);
        }

        @ExplodeLoop
        @Override
        protected Object execute(Object arg0Value, Object arg1Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b11111) != 0 /* is-state_0 doOverloadedOverloaded(JSOverloadedOperatorsObject, JSOverloadedOperatorsObject, int, int, Object, JSFunctionCallNode) || doOverloadedNumber(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) || doOverloadedBigInt(JSOverloadedOperatorsObject, BigInt, int, Object, JSFunctionCallNode) || doOverloadedString(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) || doOverloadedNullish(JSOverloadedOperatorsObject, Object) */ && arg0Value instanceof JSOverloadedOperatorsObject) {
                JSOverloadedOperatorsObject arg0Value_ = (JSOverloadedOperatorsObject) arg0Value;
                if ((state_0 & 0b1) != 0 /* is-state_0 doOverloadedOverloaded(JSOverloadedOperatorsObject, JSOverloadedOperatorsObject, int, int, Object, JSFunctionCallNode) */ && arg1Value instanceof JSOverloadedOperatorsObject) {
                    JSOverloadedOperatorsObject arg1Value_ = (JSOverloadedOperatorsObject) arg1Value;
                    OverloadedOverloadedData s0_ = this.overloadedOverloaded_cache;
                    while (s0_ != null) {
                        if ((arg0Value_.matchesOperatorCounter(s0_.leftOperatorCounter_)) && (arg1Value_.matchesOperatorCounter(s0_.rightOperatorCounter_))) {
                            return doOverloadedOverloaded(arg0Value_, arg1Value_, s0_.leftOperatorCounter_, s0_.rightOperatorCounter_, s0_.operatorImplementation_, s0_.callNode_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doOverloadedNumber(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) */) {
                    OverloadedNumberData s1_ = this.overloadedNumber_cache;
                    while (s1_ != null) {
                        if ((arg0Value_.matchesOperatorCounter(s1_.leftOperatorCounter_)) && (JSGuards.isNumber(arg1Value))) {
                            return doOverloadedNumber(arg0Value_, arg1Value, s1_.leftOperatorCounter_, s1_.operatorImplementation_, s1_.callNode_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doOverloadedBigInt(JSOverloadedOperatorsObject, BigInt, int, Object, JSFunctionCallNode) */ && arg1Value instanceof BigInt) {
                    BigInt arg1Value_ = (BigInt) arg1Value;
                    OverloadedBigIntData s2_ = this.overloadedBigInt_cache;
                    while (s2_ != null) {
                        if ((arg0Value_.matchesOperatorCounter(s2_.leftOperatorCounter_))) {
                            return doOverloadedBigInt(arg0Value_, arg1Value_, s2_.leftOperatorCounter_, s2_.operatorImplementation_, s2_.callNode_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b11000) != 0 /* is-state_0 doOverloadedString(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) || doOverloadedNullish(JSOverloadedOperatorsObject, Object) */) {
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doOverloadedString(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) */) {
                        OverloadedStringData s3_ = this.overloadedString_cache;
                        while (s3_ != null) {
                            if ((arg0Value_.matchesOperatorCounter(s3_.leftOperatorCounter_)) && (JSGuards.isString(arg1Value))) {
                                assert (!(isAddition()));
                                return doOverloadedString(arg0Value_, arg1Value, s3_.leftOperatorCounter_, s3_.operatorImplementation_, s3_.callNode_);
                            }
                            s3_ = s3_.next_;
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 doOverloadedNullish(JSOverloadedOperatorsObject, Object) */) {
                        if ((JSGuards.isNullOrUndefined(arg1Value))) {
                            return doOverloadedNullish(arg0Value_, arg1Value);
                        }
                    }
                }
            }
            if ((state_0 & 0b111100000) != 0 /* is-state_0 doNumberOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) || doBigIntOverloaded(BigInt, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) || doStringOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) || doNullishOverloaded(Object, JSOverloadedOperatorsObject) */ && arg1Value instanceof JSOverloadedOperatorsObject) {
                JSOverloadedOperatorsObject arg1Value_ = (JSOverloadedOperatorsObject) arg1Value;
                if ((state_0 & 0b100000) != 0 /* is-state_0 doNumberOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                    NumberOverloadedData s5_ = this.numberOverloaded_cache;
                    while (s5_ != null) {
                        if ((arg1Value_.matchesOperatorCounter(s5_.rightOperatorCounter_)) && (JSGuards.isNumber(arg0Value))) {
                            return doNumberOverloaded(arg0Value, arg1Value_, s5_.rightOperatorCounter_, s5_.operatorImplementation_, s5_.callNode_);
                        }
                        s5_ = s5_.next_;
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigIntOverloaded(BigInt, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */ && arg0Value instanceof BigInt) {
                    BigInt arg0Value_ = (BigInt) arg0Value;
                    BigIntOverloadedData s6_ = this.bigIntOverloaded_cache;
                    while (s6_ != null) {
                        if ((arg1Value_.matchesOperatorCounter(s6_.rightOperatorCounter_))) {
                            return doBigIntOverloaded(arg0Value_, arg1Value_, s6_.rightOperatorCounter_, s6_.operatorImplementation_, s6_.callNode_);
                        }
                        s6_ = s6_.next_;
                    }
                }
                if ((state_0 & 0b110000000) != 0 /* is-state_0 doStringOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) || doNullishOverloaded(Object, JSOverloadedOperatorsObject) */) {
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 doStringOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                        StringOverloadedData s7_ = this.stringOverloaded_cache;
                        while (s7_ != null) {
                            if ((arg1Value_.matchesOperatorCounter(s7_.rightOperatorCounter_)) && (JSGuards.isString(arg0Value))) {
                                assert (!(isAddition()));
                                return doStringOverloaded(arg0Value, arg1Value_, s7_.rightOperatorCounter_, s7_.operatorImplementation_, s7_.callNode_);
                            }
                            s7_ = s7_.next_;
                        }
                    }
                    if ((state_0 & 0b100000000) != 0 /* is-state_0 doNullishOverloaded(Object, JSOverloadedOperatorsObject) */) {
                        if ((JSGuards.isNullOrUndefined(arg0Value))) {
                            return doNullishOverloaded(arg0Value, arg1Value_);
                        }
                    }
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGeneric(Object, Object, JSFunctionCallNode) */) {
                return doGeneric(arg0Value, arg1Value, this.generic_callNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private Object executeAndSpecialize(Object arg0Value, Object arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                int oldState_0 = state_0;
                try {
                    if (arg0Value instanceof JSOverloadedOperatorsObject) {
                        JSOverloadedOperatorsObject arg0Value_ = (JSOverloadedOperatorsObject) arg0Value;
                        if (((exclude & 0b1)) == 0 /* is-not-exclude doOverloadedOverloaded(JSOverloadedOperatorsObject, JSOverloadedOperatorsObject, int, int, Object, JSFunctionCallNode) */ && arg1Value instanceof JSOverloadedOperatorsObject) {
                            JSOverloadedOperatorsObject arg1Value_ = (JSOverloadedOperatorsObject) arg1Value;
                            int count0_ = 0;
                            OverloadedOverloadedData s0_ = this.overloadedOverloaded_cache;
                            if ((state_0 & 0b1) != 0 /* is-state_0 doOverloadedOverloaded(JSOverloadedOperatorsObject, JSOverloadedOperatorsObject, int, int, Object, JSFunctionCallNode) */) {
                                while (s0_ != null) {
                                    if ((arg0Value_.matchesOperatorCounter(s0_.leftOperatorCounter_)) && (arg1Value_.matchesOperatorCounter(s0_.rightOperatorCounter_))) {
                                        break;
                                    }
                                    s0_ = s0_.next_;
                                    count0_++;
                                }
                            }
                            if (s0_ == null) {
                                {
                                    int leftOperatorCounter__ = (arg0Value_.getOperatorCounter());
                                    if ((arg0Value_.matchesOperatorCounter(leftOperatorCounter__))) {
                                        int rightOperatorCounter__ = (arg1Value_.getOperatorCounter());
                                        if ((arg1Value_.matchesOperatorCounter(rightOperatorCounter__)) && count0_ < (3)) {
                                            s0_ = super.insert(new OverloadedOverloadedData(overloadedOverloaded_cache));
                                            s0_.leftOperatorCounter_ = leftOperatorCounter__;
                                            s0_.rightOperatorCounter_ = rightOperatorCounter__;
                                            s0_.operatorImplementation_ = (OperatorSet.getOperatorImplementation(arg0Value_, arg1Value_, getOverloadedOperatorName()));
                                            s0_.callNode_ = s0_.insertAccessor((JSFunctionCallNode.createCall()));
                                            MemoryFence.storeStore();
                                            this.overloadedOverloaded_cache = s0_;
                                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doOverloadedOverloaded(JSOverloadedOperatorsObject, JSOverloadedOperatorsObject, int, int, Object, JSFunctionCallNode) */;
                                        }
                                    }
                                }
                            }
                            if (s0_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return doOverloadedOverloaded(arg0Value_, arg1Value_, s0_.leftOperatorCounter_, s0_.rightOperatorCounter_, s0_.operatorImplementation_, s0_.callNode_);
                            }
                        }
                        if (((exclude & 0b10)) == 0 /* is-not-exclude doOverloadedNumber(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) */) {
                            int count1_ = 0;
                            OverloadedNumberData s1_ = this.overloadedNumber_cache;
                            if ((state_0 & 0b10) != 0 /* is-state_0 doOverloadedNumber(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) */) {
                                while (s1_ != null) {
                                    if ((arg0Value_.matchesOperatorCounter(s1_.leftOperatorCounter_)) && (JSGuards.isNumber(arg1Value))) {
                                        break;
                                    }
                                    s1_ = s1_.next_;
                                    count1_++;
                                }
                            }
                            if (s1_ == null) {
                                {
                                    int leftOperatorCounter__1 = (arg0Value_.getOperatorCounter());
                                    if ((arg0Value_.matchesOperatorCounter(leftOperatorCounter__1)) && (JSGuards.isNumber(arg1Value)) && count1_ < (3)) {
                                        s1_ = super.insert(new OverloadedNumberData(overloadedNumber_cache));
                                        s1_.leftOperatorCounter_ = leftOperatorCounter__1;
                                        s1_.operatorImplementation_ = (OperatorSet.getOperatorImplementation(arg0Value_, arg1Value, getOverloadedOperatorName()));
                                        s1_.callNode_ = s1_.insertAccessor((JSFunctionCallNode.createCall()));
                                        MemoryFence.storeStore();
                                        this.overloadedNumber_cache = s1_;
                                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doOverloadedNumber(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) */;
                                    }
                                }
                            }
                            if (s1_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return doOverloadedNumber(arg0Value_, arg1Value, s1_.leftOperatorCounter_, s1_.operatorImplementation_, s1_.callNode_);
                            }
                        }
                        if (((exclude & 0b100)) == 0 /* is-not-exclude doOverloadedBigInt(JSOverloadedOperatorsObject, BigInt, int, Object, JSFunctionCallNode) */ && arg1Value instanceof BigInt) {
                            BigInt arg1Value_ = (BigInt) arg1Value;
                            int count2_ = 0;
                            OverloadedBigIntData s2_ = this.overloadedBigInt_cache;
                            if ((state_0 & 0b100) != 0 /* is-state_0 doOverloadedBigInt(JSOverloadedOperatorsObject, BigInt, int, Object, JSFunctionCallNode) */) {
                                while (s2_ != null) {
                                    if ((arg0Value_.matchesOperatorCounter(s2_.leftOperatorCounter_))) {
                                        break;
                                    }
                                    s2_ = s2_.next_;
                                    count2_++;
                                }
                            }
                            if (s2_ == null) {
                                {
                                    int leftOperatorCounter__2 = (arg0Value_.getOperatorCounter());
                                    if ((arg0Value_.matchesOperatorCounter(leftOperatorCounter__2)) && count2_ < (3)) {
                                        s2_ = super.insert(new OverloadedBigIntData(overloadedBigInt_cache));
                                        s2_.leftOperatorCounter_ = leftOperatorCounter__2;
                                        s2_.operatorImplementation_ = (OperatorSet.getOperatorImplementation(arg0Value_, arg1Value_, getOverloadedOperatorName()));
                                        s2_.callNode_ = s2_.insertAccessor((JSFunctionCallNode.createCall()));
                                        MemoryFence.storeStore();
                                        this.overloadedBigInt_cache = s2_;
                                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doOverloadedBigInt(JSOverloadedOperatorsObject, BigInt, int, Object, JSFunctionCallNode) */;
                                    }
                                }
                            }
                            if (s2_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return doOverloadedBigInt(arg0Value_, arg1Value_, s2_.leftOperatorCounter_, s2_.operatorImplementation_, s2_.callNode_);
                            }
                        }
                        if (((exclude & 0b1000)) == 0 /* is-not-exclude doOverloadedString(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) */) {
                            int count3_ = 0;
                            OverloadedStringData s3_ = this.overloadedString_cache;
                            if ((state_0 & 0b1000) != 0 /* is-state_0 doOverloadedString(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) */) {
                                while (s3_ != null) {
                                    if ((arg0Value_.matchesOperatorCounter(s3_.leftOperatorCounter_)) && (JSGuards.isString(arg1Value))) {
                                        assert (!(isAddition()));
                                        break;
                                    }
                                    s3_ = s3_.next_;
                                    count3_++;
                                }
                            }
                            if (s3_ == null) {
                                {
                                    int leftOperatorCounter__3 = (arg0Value_.getOperatorCounter());
                                    if ((arg0Value_.matchesOperatorCounter(leftOperatorCounter__3)) && (JSGuards.isString(arg1Value)) && (!(isAddition())) && count3_ < (3)) {
                                        s3_ = super.insert(new OverloadedStringData(overloadedString_cache));
                                        s3_.leftOperatorCounter_ = leftOperatorCounter__3;
                                        s3_.operatorImplementation_ = (OperatorSet.getOperatorImplementation(arg0Value_, arg1Value, getOverloadedOperatorName()));
                                        s3_.callNode_ = s3_.insertAccessor((JSFunctionCallNode.createCall()));
                                        MemoryFence.storeStore();
                                        this.overloadedString_cache = s3_;
                                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doOverloadedString(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) */;
                                    }
                                }
                            }
                            if (s3_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return doOverloadedString(arg0Value_, arg1Value, s3_.leftOperatorCounter_, s3_.operatorImplementation_, s3_.callNode_);
                            }
                        }
                        if ((JSGuards.isNullOrUndefined(arg1Value))) {
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doOverloadedNullish(JSOverloadedOperatorsObject, Object) */;
                            lock.unlock();
                            hasLock = false;
                            return doOverloadedNullish(arg0Value_, arg1Value);
                        }
                    }
                    if (arg1Value instanceof JSOverloadedOperatorsObject) {
                        JSOverloadedOperatorsObject arg1Value_ = (JSOverloadedOperatorsObject) arg1Value;
                        if (((exclude & 0b10000)) == 0 /* is-not-exclude doNumberOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                            int count5_ = 0;
                            NumberOverloadedData s5_ = this.numberOverloaded_cache;
                            if ((state_0 & 0b100000) != 0 /* is-state_0 doNumberOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                                while (s5_ != null) {
                                    if ((arg1Value_.matchesOperatorCounter(s5_.rightOperatorCounter_)) && (JSGuards.isNumber(arg0Value))) {
                                        break;
                                    }
                                    s5_ = s5_.next_;
                                    count5_++;
                                }
                            }
                            if (s5_ == null) {
                                {
                                    int rightOperatorCounter__1 = (arg1Value_.getOperatorCounter());
                                    if ((arg1Value_.matchesOperatorCounter(rightOperatorCounter__1)) && (JSGuards.isNumber(arg0Value)) && count5_ < (3)) {
                                        s5_ = super.insert(new NumberOverloadedData(numberOverloaded_cache));
                                        s5_.rightOperatorCounter_ = rightOperatorCounter__1;
                                        s5_.operatorImplementation_ = (OperatorSet.getOperatorImplementation(arg0Value, arg1Value_, getOverloadedOperatorName()));
                                        s5_.callNode_ = s5_.insertAccessor((JSFunctionCallNode.createCall()));
                                        MemoryFence.storeStore();
                                        this.numberOverloaded_cache = s5_;
                                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doNumberOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */;
                                    }
                                }
                            }
                            if (s5_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return doNumberOverloaded(arg0Value, arg1Value_, s5_.rightOperatorCounter_, s5_.operatorImplementation_, s5_.callNode_);
                            }
                        }
                        if (((exclude & 0b100000)) == 0 /* is-not-exclude doBigIntOverloaded(BigInt, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */ && arg0Value instanceof BigInt) {
                            BigInt arg0Value_ = (BigInt) arg0Value;
                            int count6_ = 0;
                            BigIntOverloadedData s6_ = this.bigIntOverloaded_cache;
                            if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigIntOverloaded(BigInt, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                                while (s6_ != null) {
                                    if ((arg1Value_.matchesOperatorCounter(s6_.rightOperatorCounter_))) {
                                        break;
                                    }
                                    s6_ = s6_.next_;
                                    count6_++;
                                }
                            }
                            if (s6_ == null) {
                                {
                                    int rightOperatorCounter__2 = (arg1Value_.getOperatorCounter());
                                    if ((arg1Value_.matchesOperatorCounter(rightOperatorCounter__2)) && count6_ < (3)) {
                                        s6_ = super.insert(new BigIntOverloadedData(bigIntOverloaded_cache));
                                        s6_.rightOperatorCounter_ = rightOperatorCounter__2;
                                        s6_.operatorImplementation_ = (OperatorSet.getOperatorImplementation(arg0Value_, arg1Value_, getOverloadedOperatorName()));
                                        s6_.callNode_ = s6_.insertAccessor((JSFunctionCallNode.createCall()));
                                        MemoryFence.storeStore();
                                        this.bigIntOverloaded_cache = s6_;
                                        this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doBigIntOverloaded(BigInt, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */;
                                    }
                                }
                            }
                            if (s6_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return doBigIntOverloaded(arg0Value_, arg1Value_, s6_.rightOperatorCounter_, s6_.operatorImplementation_, s6_.callNode_);
                            }
                        }
                        if (((exclude & 0b1000000)) == 0 /* is-not-exclude doStringOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                            int count7_ = 0;
                            StringOverloadedData s7_ = this.stringOverloaded_cache;
                            if ((state_0 & 0b10000000) != 0 /* is-state_0 doStringOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                                while (s7_ != null) {
                                    if ((arg1Value_.matchesOperatorCounter(s7_.rightOperatorCounter_)) && (JSGuards.isString(arg0Value))) {
                                        assert (!(isAddition()));
                                        break;
                                    }
                                    s7_ = s7_.next_;
                                    count7_++;
                                }
                            }
                            if (s7_ == null) {
                                {
                                    int rightOperatorCounter__3 = (arg1Value_.getOperatorCounter());
                                    if ((arg1Value_.matchesOperatorCounter(rightOperatorCounter__3)) && (JSGuards.isString(arg0Value)) && (!(isAddition())) && count7_ < (3)) {
                                        s7_ = super.insert(new StringOverloadedData(stringOverloaded_cache));
                                        s7_.rightOperatorCounter_ = rightOperatorCounter__3;
                                        s7_.operatorImplementation_ = (OperatorSet.getOperatorImplementation(arg0Value, arg1Value_, getOverloadedOperatorName()));
                                        s7_.callNode_ = s7_.insertAccessor((JSFunctionCallNode.createCall()));
                                        MemoryFence.storeStore();
                                        this.stringOverloaded_cache = s7_;
                                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doStringOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */;
                                    }
                                }
                            }
                            if (s7_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return doStringOverloaded(arg0Value, arg1Value_, s7_.rightOperatorCounter_, s7_.operatorImplementation_, s7_.callNode_);
                            }
                        }
                        if ((JSGuards.isNullOrUndefined(arg0Value))) {
                            this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doNullishOverloaded(Object, JSOverloadedOperatorsObject) */;
                            lock.unlock();
                            hasLock = false;
                            return doNullishOverloaded(arg0Value, arg1Value_);
                        }
                    }
                    this.generic_callNode_ = super.insert((JSFunctionCallNode.createCall()));
                    this.exclude_ = exclude = exclude | 0b1111111 /* add-exclude doOverloadedOverloaded(JSOverloadedOperatorsObject, JSOverloadedOperatorsObject, int, int, Object, JSFunctionCallNode), doOverloadedNumber(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode), doOverloadedBigInt(JSOverloadedOperatorsObject, BigInt, int, Object, JSFunctionCallNode), doOverloadedString(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode), doNumberOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode), doBigIntOverloaded(BigInt, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode), doStringOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */;
                    this.overloadedOverloaded_cache = null;
                    this.overloadedNumber_cache = null;
                    this.overloadedBigInt_cache = null;
                    this.overloadedString_cache = null;
                    this.numberOverloaded_cache = null;
                    this.bigIntOverloaded_cache = null;
                    this.stringOverloaded_cache = null;
                    state_0 = state_0 & 0xffffff10 /* remove-state_0 doOverloadedOverloaded(JSOverloadedOperatorsObject, JSOverloadedOperatorsObject, int, int, Object, JSFunctionCallNode), doOverloadedNumber(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode), doOverloadedBigInt(JSOverloadedOperatorsObject, BigInt, int, Object, JSFunctionCallNode), doOverloadedString(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode), doNumberOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode), doBigIntOverloaded(BigInt, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode), doStringOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */;
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doGeneric(Object, Object, JSFunctionCallNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doGeneric(arg0Value, arg1Value, this.generic_callNode_);
                } finally {
                    if (oldState_0 != 0) {
                        checkForPolymorphicSpecialize(oldState_0);
                    }
                }
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        private void checkForPolymorphicSpecialize(int oldState_0) {
            if (((oldState_0 & 0b1000000000) == 0 && (this.state_0_ & 0b1000000000) != 0)) {
                this.reportPolymorphicSpecialize();
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if (state_0 == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                    OverloadedOverloadedData s0_ = this.overloadedOverloaded_cache;
                    OverloadedNumberData s1_ = this.overloadedNumber_cache;
                    OverloadedBigIntData s2_ = this.overloadedBigInt_cache;
                    OverloadedStringData s3_ = this.overloadedString_cache;
                    NumberOverloadedData s5_ = this.numberOverloaded_cache;
                    BigIntOverloadedData s6_ = this.bigIntOverloaded_cache;
                    StringOverloadedData s7_ = this.stringOverloaded_cache;
                    if ((s0_ == null || s0_.next_ == null) && (s1_ == null || s1_.next_ == null) && (s2_ == null || s2_.next_ == null) && (s3_ == null || s3_.next_ == null) && (s5_ == null || s5_.next_ == null) && (s6_ == null || s6_.next_ == null) && (s7_ == null || s7_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[11];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "doOverloadedOverloaded";
            if ((state_0 & 0b1) != 0 /* is-state_0 doOverloadedOverloaded(JSOverloadedOperatorsObject, JSOverloadedOperatorsObject, int, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                OverloadedOverloadedData s0_ = this.overloadedOverloaded_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.leftOperatorCounter_, s0_.rightOperatorCounter_, s0_.operatorImplementation_, s0_.callNode_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b1) != 0 /* is-exclude doOverloadedOverloaded(JSOverloadedOperatorsObject, JSOverloadedOperatorsObject, int, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doOverloadedNumber";
            if ((state_0 & 0b10) != 0 /* is-state_0 doOverloadedNumber(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                OverloadedNumberData s1_ = this.overloadedNumber_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.leftOperatorCounter_, s1_.operatorImplementation_, s1_.callNode_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b10) != 0 /* is-exclude doOverloadedNumber(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doOverloadedBigInt";
            if ((state_0 & 0b100) != 0 /* is-state_0 doOverloadedBigInt(JSOverloadedOperatorsObject, BigInt, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                OverloadedBigIntData s2_ = this.overloadedBigInt_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.leftOperatorCounter_, s2_.operatorImplementation_, s2_.callNode_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b100) != 0 /* is-exclude doOverloadedBigInt(JSOverloadedOperatorsObject, BigInt, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doOverloadedString";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doOverloadedString(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                OverloadedStringData s3_ = this.overloadedString_cache;
                while (s3_ != null) {
                    cached.add(Arrays.asList(s3_.leftOperatorCounter_, s3_.operatorImplementation_, s3_.callNode_));
                    s3_ = s3_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b1000) != 0 /* is-exclude doOverloadedString(JSOverloadedOperatorsObject, Object, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "doOverloadedNullish";
            if ((state_0 & 0b10000) != 0 /* is-state_0 doOverloadedNullish(JSOverloadedOperatorsObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "doNumberOverloaded";
            if ((state_0 & 0b100000) != 0 /* is-state_0 doNumberOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                NumberOverloadedData s5_ = this.numberOverloaded_cache;
                while (s5_ != null) {
                    cached.add(Arrays.asList(s5_.rightOperatorCounter_, s5_.operatorImplementation_, s5_.callNode_));
                    s5_ = s5_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b10000) != 0 /* is-exclude doNumberOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "doBigIntOverloaded";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigIntOverloaded(BigInt, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                BigIntOverloadedData s6_ = this.bigIntOverloaded_cache;
                while (s6_ != null) {
                    cached.add(Arrays.asList(s6_.rightOperatorCounter_, s6_.operatorImplementation_, s6_.callNode_));
                    s6_ = s6_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b100000) != 0 /* is-exclude doBigIntOverloaded(BigInt, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "doStringOverloaded";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doStringOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                StringOverloadedData s7_ = this.stringOverloaded_cache;
                while (s7_ != null) {
                    cached.add(Arrays.asList(s7_.rightOperatorCounter_, s7_.operatorImplementation_, s7_.callNode_));
                    s7_ = s7_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b1000000) != 0 /* is-exclude doStringOverloaded(Object, JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "doNullishOverloaded";
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doNullishOverloaded(Object, JSOverloadedOperatorsObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            s = new Object[3];
            s[0] = "doGeneric";
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGeneric(Object, Object, JSFunctionCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.generic_callNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[10] = s;
            return Provider.create(data);
        }

        public static DispatchBinaryOperatorNode create(String overloadedOperatorName) {
            return new DispatchBinaryOperatorNodeGen(overloadedOperatorName);
        }

        @GeneratedBy(DispatchBinaryOperatorNode.class)
        private static final class OverloadedOverloadedData extends Node {

            @Child OverloadedOverloadedData next_;
            @CompilationFinal int leftOperatorCounter_;
            @CompilationFinal int rightOperatorCounter_;
            @CompilationFinal Object operatorImplementation_;
            @Child JSFunctionCallNode callNode_;

            OverloadedOverloadedData(OverloadedOverloadedData next_) {
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
        @GeneratedBy(DispatchBinaryOperatorNode.class)
        private static final class OverloadedNumberData extends Node {

            @Child OverloadedNumberData next_;
            @CompilationFinal int leftOperatorCounter_;
            @CompilationFinal Object operatorImplementation_;
            @Child JSFunctionCallNode callNode_;

            OverloadedNumberData(OverloadedNumberData next_) {
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
        @GeneratedBy(DispatchBinaryOperatorNode.class)
        private static final class OverloadedBigIntData extends Node {

            @Child OverloadedBigIntData next_;
            @CompilationFinal int leftOperatorCounter_;
            @CompilationFinal Object operatorImplementation_;
            @Child JSFunctionCallNode callNode_;

            OverloadedBigIntData(OverloadedBigIntData next_) {
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
        @GeneratedBy(DispatchBinaryOperatorNode.class)
        private static final class OverloadedStringData extends Node {

            @Child OverloadedStringData next_;
            @CompilationFinal int leftOperatorCounter_;
            @CompilationFinal Object operatorImplementation_;
            @Child JSFunctionCallNode callNode_;

            OverloadedStringData(OverloadedStringData next_) {
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
        @GeneratedBy(DispatchBinaryOperatorNode.class)
        private static final class NumberOverloadedData extends Node {

            @Child NumberOverloadedData next_;
            @CompilationFinal int rightOperatorCounter_;
            @CompilationFinal Object operatorImplementation_;
            @Child JSFunctionCallNode callNode_;

            NumberOverloadedData(NumberOverloadedData next_) {
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
        @GeneratedBy(DispatchBinaryOperatorNode.class)
        private static final class BigIntOverloadedData extends Node {

            @Child BigIntOverloadedData next_;
            @CompilationFinal int rightOperatorCounter_;
            @CompilationFinal Object operatorImplementation_;
            @Child JSFunctionCallNode callNode_;

            BigIntOverloadedData(BigIntOverloadedData next_) {
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
        @GeneratedBy(DispatchBinaryOperatorNode.class)
        private static final class StringOverloadedData extends Node {

            @Child StringOverloadedData next_;
            @CompilationFinal int rightOperatorCounter_;
            @CompilationFinal Object operatorImplementation_;
            @Child JSFunctionCallNode callNode_;

            StringOverloadedData(StringOverloadedData next_) {
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
    }
}
