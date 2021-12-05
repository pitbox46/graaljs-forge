// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToBigInt64Node.class)
public final class JSToBigInt64NodeGen extends JSToBigInt64Node implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private JSToBigIntNode object_toBigIntNode_;

    private JSToBigInt64NodeGen() {
    }

    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return JSToBigInt64Node.doInteger(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            return JSToBigInt64Node.doLong(arg0Value_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doObject(Object, JSToBigIntNode) */) {
            return JSToBigInt64Node.doObject(arg0Value, this.object_toBigIntNode_);
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
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInteger(int) */;
                lock.unlock();
                hasLock = false;
                return JSToBigInt64Node.doInteger(arg0Value_);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doLong(long) */;
                lock.unlock();
                hasLock = false;
                return JSToBigInt64Node.doLong(arg0Value_);
            }
            this.object_toBigIntNode_ = super.insert((JSToBigIntNode.create()));
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doObject(Object, JSToBigIntNode) */;
            lock.unlock();
            hasLock = false;
            return JSToBigInt64Node.doObject(arg0Value, this.object_toBigIntNode_);
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
        s[0] = "doInteger";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state_0 & 0b10) != 0 /* is-state_0 doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b100) != 0 /* is-state_0 doObject(Object, JSToBigIntNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.object_toBigIntNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static JSToBigInt64Node create() {
        return new JSToBigInt64NodeGen();
    }

}
