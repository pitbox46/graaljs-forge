// CheckStyle: start generated
package com.oracle.truffle.regex.tregex.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.ValueProfile;
import java.util.concurrent.locks.Lock;

@GeneratedBy(TRegexExecutorEntryNode.class)
public final class TRegexExecutorEntryNodeGen extends TRegexExecutorEntryNode {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private ValueProfile truffleObject_inputClassProfile_;

    private TRegexExecutorEntryNodeGen(TRegexExecutorNode executor) {
        super(executor);
    }

    @Override
    public Object execute(Object arg0Value, int arg1Value, int arg2Value, int arg3Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doByteArray(byte[], int, int, int) || doStringCompact(String, int, int, int) || doStringNonCompact(String, int, int, int) || doTruffleObject(Object, int, int, int, ValueProfile) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doByteArray(byte[], int, int, int) */ && arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                return doByteArray(arg0Value_, arg1Value, arg2Value, arg3Value);
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 doStringCompact(String, int, int, int) || doStringNonCompact(String, int, int, int) */ && arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                if ((state_0 & 0b10) != 0 /* is-state_0 doStringCompact(String, int, int, int) */) {
                    if ((TRegexExecutorEntryNode.isCompactString(arg0Value_))) {
                        return doStringCompact(arg0Value_, arg1Value, arg2Value, arg3Value);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doStringNonCompact(String, int, int, int) */) {
                    if ((!(TRegexExecutorEntryNode.isCompactString(arg0Value_)))) {
                        return doStringNonCompact(arg0Value_, arg1Value, arg2Value, arg3Value);
                    }
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doTruffleObject(Object, int, int, int, ValueProfile) */) {
                if ((TRegexExecutorEntryNode.neitherByteArrayNorString(arg0Value))) {
                    return doTruffleObject(arg0Value, arg1Value, arg2Value, arg3Value, this.truffleObject_inputClassProfile_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
    }

    private Object executeAndSpecialize(Object arg0Value, int arg1Value, int arg2Value, int arg3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doByteArray(byte[], int, int, int) */;
                lock.unlock();
                hasLock = false;
                return doByteArray(arg0Value_, arg1Value, arg2Value, arg3Value);
            }
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                if ((TRegexExecutorEntryNode.isCompactString(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doStringCompact(String, int, int, int) */;
                    lock.unlock();
                    hasLock = false;
                    return doStringCompact(arg0Value_, arg1Value, arg2Value, arg3Value);
                }
                if ((!(TRegexExecutorEntryNode.isCompactString(arg0Value_)))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doStringNonCompact(String, int, int, int) */;
                    lock.unlock();
                    hasLock = false;
                    return doStringNonCompact(arg0Value_, arg1Value, arg2Value, arg3Value);
                }
            }
            if ((TRegexExecutorEntryNode.neitherByteArrayNorString(arg0Value))) {
                this.truffleObject_inputClassProfile_ = (ValueProfile.createClassProfile());
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doTruffleObject(Object, int, int, int, ValueProfile) */;
                lock.unlock();
                hasLock = false;
                return doTruffleObject(arg0Value, arg1Value, arg2Value, arg3Value, this.truffleObject_inputClassProfile_);
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

    public static TRegexExecutorEntryNode create(TRegexExecutorNode executor) {
        return new TRegexExecutorEntryNodeGen(executor);
    }

}
