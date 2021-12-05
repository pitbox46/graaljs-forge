// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

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
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;
import com.oracle.truffle.js.runtime.objects.OperatorSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSOverloadedUnaryNode.class)
public final class JSOverloadedUnaryNodeGen extends JSOverloadedUnaryNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private CachedData cached_cache;
    @Child private JSFunctionCallNode generic_callNode_;

    private JSOverloadedUnaryNodeGen(String overloadedOperatorName) {
        super(overloadedOperatorName);
    }

    @ExplodeLoop
    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doCached(JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) || doGeneric(JSOverloadedOperatorsObject, JSFunctionCallNode) */ && arg0Value instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject arg0Value_ = (JSOverloadedOperatorsObject) arg0Value;
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    if ((arg0Value_.matchesOperatorCounter(s0_.operatorCounter_))) {
                        return doCached(arg0Value_, s0_.operatorCounter_, s0_.operatorImplementation_, s0_.callNode_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doGeneric(JSOverloadedOperatorsObject, JSFunctionCallNode) */) {
                return doGeneric(arg0Value_, this.generic_callNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object arg0Value) {
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
                    if ((exclude) == 0 /* is-not-exclude doCached(JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                        int count0_ = 0;
                        CachedData s0_ = this.cached_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
                            while (s0_ != null) {
                                if ((arg0Value_.matchesOperatorCounter(s0_.operatorCounter_))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                int operatorCounter__ = (arg0Value_.getOperatorCounter());
                                if ((arg0Value_.matchesOperatorCounter(operatorCounter__)) && count0_ < (3)) {
                                    s0_ = super.insert(new CachedData(cached_cache));
                                    s0_.operatorCounter_ = operatorCounter__;
                                    s0_.operatorImplementation_ = (OperatorSet.getOperatorImplementation(arg0Value_, getOverloadedOperatorName()));
                                    s0_.callNode_ = s0_.insertAccessor((JSFunctionCallNode.createCall()));
                                    MemoryFence.storeStore();
                                    this.cached_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */;
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(arg0Value_, s0_.operatorCounter_, s0_.operatorImplementation_, s0_.callNode_);
                        }
                    }
                    this.generic_callNode_ = super.insert((JSFunctionCallNode.createCall()));
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */;
                    this.cached_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doGeneric(JSOverloadedOperatorsObject, JSFunctionCallNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doGeneric(arg0Value_, this.generic_callNode_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
        if (((oldState_0 & 0b10) == 0 && (this.state_0_ & 0b10) != 0)) {
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s0_ = this.cached_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.operatorCounter_, s0_.operatorImplementation_, s0_.callNode_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doCached(JSOverloadedOperatorsObject, int, Object, JSFunctionCallNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state_0 & 0b10) != 0 /* is-state_0 doGeneric(JSOverloadedOperatorsObject, JSFunctionCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.generic_callNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSOverloadedUnaryNode create(String overloadedOperatorName) {
        return new JSOverloadedUnaryNodeGen(overloadedOperatorName);
    }

    @GeneratedBy(JSOverloadedUnaryNode.class)
    private static final class CachedData extends Node {

        @Child CachedData next_;
        @CompilationFinal int operatorCounter_;
        @CompilationFinal Object operatorImplementation_;
        @Child JSFunctionCallNode callNode_;

        CachedData(CachedData next_) {
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
