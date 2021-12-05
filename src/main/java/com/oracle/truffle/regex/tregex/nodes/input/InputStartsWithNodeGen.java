// CheckStyle: start generated
package com.oracle.truffle.regex.tregex.nodes.input;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InputStartsWithNode.class)
public final class InputStartsWithNodeGen extends InputStartsWithNode {

    @CompilationFinal private volatile int state_0_;
    @Child private InputLengthNode truffleObjBytes_lengthNode_;
    @Child private InputReadNode truffleObjBytes_charAtNode_;
    @Child private InputLengthNode truffleObjBytesMask_lengthNode_;
    @Child private InputReadNode truffleObjBytesMask_charAtNode_;
    @Child private InputLengthNode truffleObjString_lengthNode_;
    @Child private InputReadNode truffleObjString_charAtNode_;
    @Child private InputLengthNode truffleObjStringMask_lengthNode_;
    @Child private InputReadNode truffleObjStringMask_charAtNode_;

    private InputStartsWithNodeGen() {
    }

    @Override
    public boolean execute(Object arg0Value, Object arg1Value, Object arg2Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 doBytes(byte[], byte[], Object) || doBytesMask(byte[], byte[], byte[]) */ && arg0Value instanceof byte[]) {
            byte[] arg0Value_ = (byte[]) arg0Value;
            if (arg1Value instanceof byte[]) {
                byte[] arg1Value_ = (byte[]) arg1Value;
                if ((state_0 & 0b1) != 0 /* is-state_0 doBytes(byte[], byte[], Object) */) {
                    if ((arg2Value == null)) {
                        return doBytes(arg0Value_, arg1Value_, arg2Value);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doBytesMask(byte[], byte[], byte[]) */ && arg2Value instanceof byte[]) {
                    byte[] arg2Value_ = (byte[]) arg2Value;
                    if ((arg2Value_ != null)) {
                        return doBytesMask(arg0Value_, arg1Value_, arg2Value_);
                    }
                }
            }
        }
        if ((state_0 & 0b1100) != 0 /* is-state_0 doString(String, String, Object) || doStringMask(String, String, String) */ && arg0Value instanceof String) {
            String arg0Value_ = (String) arg0Value;
            if (arg1Value instanceof String) {
                String arg1Value_ = (String) arg1Value;
                if ((state_0 & 0b100) != 0 /* is-state_0 doString(String, String, Object) */) {
                    if ((arg2Value == null)) {
                        return doString(arg0Value_, arg1Value_, arg2Value);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doStringMask(String, String, String) */ && arg2Value instanceof String) {
                    String arg2Value_ = (String) arg2Value;
                    if ((arg2Value_ != null)) {
                        return doStringMask(arg0Value_, arg1Value_, arg2Value_);
                    }
                }
            }
        }
        if ((state_0 & 0b11110000) != 0 /* is-state_0 doTruffleObjBytes(Object, byte[], Object, InputLengthNode, InputReadNode) || doTruffleObjBytesMask(Object, byte[], byte[], InputLengthNode, InputReadNode) || doTruffleObjString(Object, String, Object, InputLengthNode, InputReadNode) || doTruffleObjStringMask(Object, String, String, InputLengthNode, InputReadNode) */) {
            if ((state_0 & 0b110000) != 0 /* is-state_0 doTruffleObjBytes(Object, byte[], Object, InputLengthNode, InputReadNode) || doTruffleObjBytesMask(Object, byte[], byte[], InputLengthNode, InputReadNode) */ && arg1Value instanceof byte[]) {
                byte[] arg1Value_ = (byte[]) arg1Value;
                if ((state_0 & 0b10000) != 0 /* is-state_0 doTruffleObjBytes(Object, byte[], Object, InputLengthNode, InputReadNode) */) {
                    if ((InputStartsWithNode.neitherByteArrayNorString(arg0Value)) && (arg2Value == null)) {
                        return doTruffleObjBytes(arg0Value, arg1Value_, arg2Value, this.truffleObjBytes_lengthNode_, this.truffleObjBytes_charAtNode_);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 doTruffleObjBytesMask(Object, byte[], byte[], InputLengthNode, InputReadNode) */ && arg2Value instanceof byte[]) {
                    byte[] arg2Value_ = (byte[]) arg2Value;
                    if ((InputStartsWithNode.neitherByteArrayNorString(arg0Value)) && (arg2Value_ != null)) {
                        return doTruffleObjBytesMask(arg0Value, arg1Value_, arg2Value_, this.truffleObjBytesMask_lengthNode_, this.truffleObjBytesMask_charAtNode_);
                    }
                }
            }
            if ((state_0 & 0b11000000) != 0 /* is-state_0 doTruffleObjString(Object, String, Object, InputLengthNode, InputReadNode) || doTruffleObjStringMask(Object, String, String, InputLengthNode, InputReadNode) */ && arg1Value instanceof String) {
                String arg1Value_ = (String) arg1Value;
                if ((state_0 & 0b1000000) != 0 /* is-state_0 doTruffleObjString(Object, String, Object, InputLengthNode, InputReadNode) */) {
                    if ((InputStartsWithNode.neitherByteArrayNorString(arg0Value)) && (arg2Value == null)) {
                        return doTruffleObjString(arg0Value, arg1Value_, arg2Value, this.truffleObjString_lengthNode_, this.truffleObjString_charAtNode_);
                    }
                }
                if ((state_0 & 0b10000000) != 0 /* is-state_0 doTruffleObjStringMask(Object, String, String, InputLengthNode, InputReadNode) */ && arg2Value instanceof String) {
                    String arg2Value_ = (String) arg2Value;
                    if ((InputStartsWithNode.neitherByteArrayNorString(arg0Value)) && (arg2Value_ != null)) {
                        return doTruffleObjStringMask(arg0Value, arg1Value_, arg2Value_, this.truffleObjStringMask_lengthNode_, this.truffleObjStringMask_charAtNode_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private boolean executeAndSpecialize(Object arg0Value, Object arg1Value, Object arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                if (arg1Value instanceof byte[]) {
                    byte[] arg1Value_ = (byte[]) arg1Value;
                    if ((arg2Value == null)) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBytes(byte[], byte[], Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doBytes(arg0Value_, arg1Value_, arg2Value);
                    }
                    if (arg2Value instanceof byte[]) {
                        byte[] arg2Value_ = (byte[]) arg2Value;
                        if ((arg2Value_ != null)) {
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doBytesMask(byte[], byte[], byte[]) */;
                            lock.unlock();
                            hasLock = false;
                            return doBytesMask(arg0Value_, arg1Value_, arg2Value_);
                        }
                    }
                }
            }
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                if (arg1Value instanceof String) {
                    String arg1Value_ = (String) arg1Value;
                    if ((arg2Value == null)) {
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doString(String, String, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doString(arg0Value_, arg1Value_, arg2Value);
                    }
                    if (arg2Value instanceof String) {
                        String arg2Value_ = (String) arg2Value;
                        if ((arg2Value_ != null)) {
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doStringMask(String, String, String) */;
                            lock.unlock();
                            hasLock = false;
                            return doStringMask(arg0Value_, arg1Value_, arg2Value_);
                        }
                    }
                }
            }
            if (arg1Value instanceof byte[]) {
                byte[] arg1Value_ = (byte[]) arg1Value;
                if ((InputStartsWithNode.neitherByteArrayNorString(arg0Value)) && (arg2Value == null)) {
                    this.truffleObjBytes_lengthNode_ = super.insert((InputLengthNode.create()));
                    this.truffleObjBytes_charAtNode_ = super.insert((InputReadNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doTruffleObjBytes(Object, byte[], Object, InputLengthNode, InputReadNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doTruffleObjBytes(arg0Value, arg1Value_, arg2Value, this.truffleObjBytes_lengthNode_, this.truffleObjBytes_charAtNode_);
                }
                if (arg2Value instanceof byte[]) {
                    byte[] arg2Value_ = (byte[]) arg2Value;
                    if ((InputStartsWithNode.neitherByteArrayNorString(arg0Value)) && (arg2Value_ != null)) {
                        this.truffleObjBytesMask_lengthNode_ = super.insert((InputLengthNode.create()));
                        this.truffleObjBytesMask_charAtNode_ = super.insert((InputReadNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doTruffleObjBytesMask(Object, byte[], byte[], InputLengthNode, InputReadNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doTruffleObjBytesMask(arg0Value, arg1Value_, arg2Value_, this.truffleObjBytesMask_lengthNode_, this.truffleObjBytesMask_charAtNode_);
                    }
                }
            }
            if (arg1Value instanceof String) {
                String arg1Value_ = (String) arg1Value;
                if ((InputStartsWithNode.neitherByteArrayNorString(arg0Value)) && (arg2Value == null)) {
                    this.truffleObjString_lengthNode_ = super.insert((InputLengthNode.create()));
                    this.truffleObjString_charAtNode_ = super.insert((InputReadNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doTruffleObjString(Object, String, Object, InputLengthNode, InputReadNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doTruffleObjString(arg0Value, arg1Value_, arg2Value, this.truffleObjString_lengthNode_, this.truffleObjString_charAtNode_);
                }
                if (arg2Value instanceof String) {
                    String arg2Value_ = (String) arg2Value;
                    if ((InputStartsWithNode.neitherByteArrayNorString(arg0Value)) && (arg2Value_ != null)) {
                        this.truffleObjStringMask_lengthNode_ = super.insert((InputLengthNode.create()));
                        this.truffleObjStringMask_charAtNode_ = super.insert((InputReadNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doTruffleObjStringMask(Object, String, String, InputLengthNode, InputReadNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doTruffleObjStringMask(arg0Value, arg1Value_, arg2Value_, this.truffleObjStringMask_lengthNode_, this.truffleObjStringMask_charAtNode_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
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

    public static InputStartsWithNode create() {
        return new InputStartsWithNodeGen();
    }

}
