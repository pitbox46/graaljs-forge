// CheckStyle: start generated
package com.oracle.truffle.js.nodes.intl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DefaultNumberOptionNode.class)
public final class DefaultNumberOptionNodeGen extends DefaultNumberOptionNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private JSToNumberNode getOption_toNumberNode_;
    @CompilationFinal private BranchProfile getOption_errorBranch_;

    private DefaultNumberOptionNodeGen() {
    }

    @Override
    public int executeInt(Object arg0Value, int arg1Value, int arg2Value, int arg3Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 getOption(Object, int, int, int, JSToNumberNode, BranchProfile) || getOptionFromUndefined(Object, int, int, int) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 getOption(Object, int, int, int, JSToNumberNode, BranchProfile) */) {
                if ((!(JSGuards.isUndefined(arg0Value)))) {
                    return getOption(arg0Value, arg1Value, arg2Value, arg3Value, this.getOption_toNumberNode_, this.getOption_errorBranch_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 getOptionFromUndefined(Object, int, int, int) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return getOptionFromUndefined(arg0Value, arg1Value, arg2Value, arg3Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
    }

    private int executeAndSpecialize(Object arg0Value, int arg1Value, int arg2Value, int arg3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if ((!(JSGuards.isUndefined(arg0Value)))) {
                this.getOption_toNumberNode_ = super.insert((JSToNumberNode.create()));
                this.getOption_errorBranch_ = (BranchProfile.create());
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getOption(Object, int, int, int, JSToNumberNode, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return getOption(arg0Value, arg1Value, arg2Value, arg3Value, this.getOption_toNumberNode_, this.getOption_errorBranch_);
            }
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getOptionFromUndefined(Object, int, int, int) */;
                lock.unlock();
                hasLock = false;
                return getOptionFromUndefined(arg0Value, arg1Value, arg2Value, arg3Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value);
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
        s = new Object[3];
        s[0] = "getOption";
        if ((state_0 & 0b1) != 0 /* is-state_0 getOption(Object, int, int, int, JSToNumberNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.getOption_toNumberNode_, this.getOption_errorBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "getOptionFromUndefined";
        if ((state_0 & 0b10) != 0 /* is-state_0 getOptionFromUndefined(Object, int, int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static DefaultNumberOptionNode create() {
        return new DefaultNumberOptionNodeGen();
    }

}
