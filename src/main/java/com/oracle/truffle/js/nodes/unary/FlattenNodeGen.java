// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(FlattenNode.class)
public final class FlattenNodeGen extends FlattenNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private ConditionProfile lazyString_flatten_;

    private FlattenNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doLazyString(JSLazyString, ConditionProfile) */ && arg0Value instanceof JSLazyString) {
            JSLazyString arg0Value_ = (JSLazyString) arg0Value;
            return FlattenNode.doLazyString(arg0Value_, this.lazyString_flatten_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            return FlattenNode.doSafeInteger(arg0Value_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doOther(Object) */) {
            if (fallbackGuard_(state_0, arg0Value)) {
                return FlattenNode.doOther(arg0Value);
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
            if (arg0Value instanceof JSLazyString) {
                JSLazyString arg0Value_ = (JSLazyString) arg0Value;
                this.lazyString_flatten_ = (ConditionProfile.createBinaryProfile());
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doLazyString(JSLazyString, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return FlattenNode.doLazyString(arg0Value_, this.lazyString_flatten_);
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doSafeInteger(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return FlattenNode.doSafeInteger(arg0Value_);
            }
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doOther(Object) */;
            lock.unlock();
            hasLock = false;
            return FlattenNode.doOther(arg0Value);
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
        s[0] = "doLazyString";
        if ((state_0 & 0b1) != 0 /* is-state_0 doLazyString(JSLazyString, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.lazyString_flatten_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state_0 & 0b100) != 0 /* is-state_0 doOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state_0, Object arg0Value) {
        if (((state_0 & 0b1)) == 0 /* is-not-state_0 doLazyString(JSLazyString, ConditionProfile) */ && arg0Value instanceof JSLazyString) {
            return false;
        }
        if (((state_0 & 0b10)) == 0 /* is-not-state_0 doSafeInteger(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            return false;
        }
        return true;
    }

    public static FlattenNode create() {
        return new FlattenNodeGen();
    }

}
