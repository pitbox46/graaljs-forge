// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DeclareGlobalLexicalVariableNode.class)
public final class DeclareGlobalLexicalVariableNodeGen extends DeclareGlobalLexicalVariableNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private PropertySetNode cached_cache_;

    private DeclareGlobalLexicalVariableNodeGen(String varName, boolean isConst) {
        super(varName, isConst);
    }

    @Override
    protected void executeVoid(DynamicObject arg0Value, JSContext arg1Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doCached(DynamicObject, JSContext, PropertySetNode) || doUncached(DynamicObject, JSContext) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, JSContext, PropertySetNode) */) {
                if ((arg1Value.getPropertyCacheLimit() > 0)) {
                    doCached(arg0Value, arg1Value, this.cached_cache_);
                    return;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(DynamicObject, JSContext) */) {
                doUncached(arg0Value, arg1Value);
                return;
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(arg0Value, arg1Value);
        return;
    }

    private void executeAndSpecialize(DynamicObject arg0Value, JSContext arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude doCached(DynamicObject, JSContext, PropertySetNode) */) {
                if ((arg1Value.getPropertyCacheLimit() > 0)) {
                    this.cached_cache_ = super.insert((makeDefineOwnPropertyCache(arg1Value)));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, JSContext, PropertySetNode) */;
                    lock.unlock();
                    hasLock = false;
                    doCached(arg0Value, arg1Value, this.cached_cache_);
                    return;
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(DynamicObject, JSContext, PropertySetNode) */;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(DynamicObject, JSContext, PropertySetNode) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(DynamicObject, JSContext) */;
            lock.unlock();
            hasLock = false;
            doUncached(arg0Value, arg1Value);
            return;
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
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, JSContext, PropertySetNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cached_cache_));
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doCached(DynamicObject, JSContext, PropertySetNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(DynamicObject, JSContext) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static DeclareGlobalLexicalVariableNode create(String varName, boolean isConst) {
        return new DeclareGlobalLexicalVariableNodeGen(varName, isConst);
    }

}
