// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToIndexNode.class)
public final class JSToIndexNodeGen extends JSToIndexNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private BranchProfile negativeIndexBranch;
    @CompilationFinal private BranchProfile double_tooLargeIndexBranch_;
    @Child private JSToNumberNode object_toNumberNode_;
    @Child private JSToIndexNode object_recursiveToIndexNode_;

    private JSToIndexNodeGen() {
    }

    @Override
    public long executeLong(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int, BranchProfile) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return doInt(arg0Value_, this.negativeIndexBranch);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger, BranchProfile) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            return doSafeInteger(arg0Value_, this.negativeIndexBranch);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, BranchProfile, BranchProfile) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000) >>> 5 /* extract-implicit-state_0 0:double */, arg0Value);
            return doDouble(arg0Value_, this.negativeIndexBranch, this.double_tooLargeIndexBranch_);
        }
        if ((state_0 & 0b11000) != 0 /* is-state_0 doUndefined(Object) || doObject(Object, JSToNumberNode, JSToIndexNode) */) {
            if ((state_0 & 0b1000) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return JSToIndexNode.doUndefined(arg0Value);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doObject(Object, JSToNumberNode, JSToIndexNode) */) {
                return JSToIndexNode.doObject(arg0Value, this.object_toNumberNode_, this.object_recursiveToIndexNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private long executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.negativeIndexBranch = this.negativeIndexBranch == null ? ((BranchProfile.create())) : this.negativeIndexBranch;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt(int, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doInt(arg0Value_, this.negativeIndexBranch);
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                this.negativeIndexBranch = this.negativeIndexBranch == null ? ((BranchProfile.create())) : this.negativeIndexBranch;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doSafeInteger(SafeInteger, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doSafeInteger(arg0Value_, this.negativeIndexBranch);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    this.negativeIndexBranch = this.negativeIndexBranch == null ? ((BranchProfile.create())) : this.negativeIndexBranch;
                    this.double_tooLargeIndexBranch_ = (BranchProfile.create());
                    state_0 = (state_0 | (doubleCast0 << 5) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doDouble(double, BranchProfile, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(arg0Value_, this.negativeIndexBranch, this.double_tooLargeIndexBranch_);
                }
            }
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return JSToIndexNode.doUndefined(arg0Value);
            }
            this.object_toNumberNode_ = super.insert((JSToNumberNode.create()));
            this.object_recursiveToIndexNode_ = super.insert((JSToIndexNode.create()));
            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doObject(Object, JSToNumberNode, JSToIndexNode) */;
            lock.unlock();
            hasLock = false;
            return JSToIndexNode.doObject(arg0Value, this.object_toNumberNode_, this.object_recursiveToIndexNode_);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b11111) & ((state_0 & 0b11111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.negativeIndexBranch));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.negativeIndexBranch));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, BranchProfile, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.negativeIndexBranch, this.double_tooLargeIndexBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doObject(Object, JSToNumberNode, JSToIndexNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.object_toNumberNode_, this.object_recursiveToIndexNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static JSToIndexNode create() {
        return new JSToIndexNodeGen();
    }

}
