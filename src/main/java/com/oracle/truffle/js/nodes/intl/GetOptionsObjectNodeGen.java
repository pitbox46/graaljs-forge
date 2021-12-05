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
import com.oracle.truffle.js.nodes.access.IsObjectNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.objects.JSObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GetOptionsObjectNode.class)
public final class GetOptionsObjectNodeGen extends GetOptionsObjectNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private IsObjectNode fromOther_isObjectNode_;
    @CompilationFinal private BranchProfile fromOther_errorBranch_;

    private GetOptionsObjectNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 fromUndefined(Object) */) {
            if ((JSGuards.isUndefined(arg0Value))) {
                return fromUndefined(arg0Value);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 fromJSObject(JSObject) */ && arg0Value instanceof JSObject) {
            JSObject arg0Value_ = (JSObject) arg0Value;
            return fromJSObject(arg0Value_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 fromOther(Object, IsObjectNode, BranchProfile) */) {
            if ((!(JSGuards.isUndefined(arg0Value)))) {
                return fromOther(arg0Value, this.fromOther_isObjectNode_, this.fromOther_errorBranch_);
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
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 fromUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return fromUndefined(arg0Value);
            }
            if ((exclude) == 0 /* is-not-exclude fromJSObject(JSObject) */ && arg0Value instanceof JSObject) {
                JSObject arg0Value_ = (JSObject) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 fromJSObject(JSObject) */;
                lock.unlock();
                hasLock = false;
                return fromJSObject(arg0Value_);
            }
            if ((!(JSGuards.isUndefined(arg0Value)))) {
                this.fromOther_isObjectNode_ = super.insert((IsObjectNode.create()));
                this.fromOther_errorBranch_ = (BranchProfile.create());
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude fromJSObject(JSObject) */;
                state_0 = state_0 & 0xfffffffd /* remove-state_0 fromJSObject(JSObject) */;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 fromOther(Object, IsObjectNode, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return fromOther(arg0Value, this.fromOther_isObjectNode_, this.fromOther_errorBranch_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "fromUndefined";
        if ((state_0 & 0b1) != 0 /* is-state_0 fromUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "fromJSObject";
        if ((state_0 & 0b10) != 0 /* is-state_0 fromJSObject(JSObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else if (exclude != 0 /* is-exclude fromJSObject(JSObject) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "fromOther";
        if ((state_0 & 0b100) != 0 /* is-state_0 fromOther(Object, IsObjectNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.fromOther_isObjectNode_, this.fromOther_errorBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static GetOptionsObjectNode create(JSContext context) {
        return new GetOptionsObjectNodeGen(context);
    }

}
