// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSTypesGen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToUInt16Node.class)
public final class JSToUInt16NodeGen extends JSToUInt16Node implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private BranchProfile double_needPositiveInfinityBranch_;
    @Child private JSToNumberNode generic_toNumberNode_;

    private JSToUInt16NodeGen() {
    }

    @Override
    public int executeInt(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return doInt(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double, BranchProfile) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arg0Value);
            return doDouble(arg0Value_, this.double_needPositiveInfinityBranch_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doGeneric(Object, JSToNumberNode) */) {
            return doGeneric(arg0Value, this.generic_toNumberNode_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private int executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt(int) */;
                lock.unlock();
                hasLock = false;
                return doInt(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    this.double_needPositiveInfinityBranch_ = (BranchProfile.create());
                    state_0 = (state_0 | (doubleCast0 << 3) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDouble(double, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(arg0Value_, this.double_needPositiveInfinityBranch_);
                }
            }
            this.generic_toNumberNode_ = super.insert((JSToNumberNode.create()));
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doGeneric(Object, JSToNumberNode) */;
            lock.unlock();
            hasLock = false;
            return doGeneric(arg0Value, this.generic_toNumberNode_);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
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
        s[0] = "doInt";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b10) != 0 /* is-state_0 doDouble(double, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.double_needPositiveInfinityBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state_0 & 0b100) != 0 /* is-state_0 doGeneric(Object, JSToNumberNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.generic_toNumberNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static JSToUInt16Node create() {
        return new JSToUInt16NodeGen();
    }

}
