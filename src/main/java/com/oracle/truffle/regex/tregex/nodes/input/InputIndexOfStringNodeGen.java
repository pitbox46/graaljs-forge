// CheckStyle: start generated
package com.oracle.truffle.regex.tregex.nodes.input;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InputIndexOfStringNode.class)
public final class InputIndexOfStringNodeGen extends InputIndexOfStringNode {

    @CompilationFinal private volatile int state_0_;
    @Child private InputLengthNode truffleObjBytes_lengthNode_;
    @Child private InputRegionMatchesNode truffleObjBytes_regionMatchesNode_;
    @Child private InputLengthNode truffleObjString_lengthNode_;
    @Child private InputRegionMatchesNode truffleObjString_regionMatchesNode_;

    private InputIndexOfStringNodeGen() {
    }

    @Override
    public int execute(Object arg0Value, int arg1Value, int arg2Value, Object arg3Value, Object arg4Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doBytes(byte[], int, int, byte[], Object) || doBytesMask(byte[], int, int, byte[], byte[]) || doString(String, int, int, String, Object) || doStringMask(String, int, int, String, String) || doTruffleObjBytes(Object, int, int, byte[], Object, InputLengthNode, InputRegionMatchesNode) || doTruffleObjString(Object, int, int, String, Object, InputLengthNode, InputRegionMatchesNode) */) {
            if ((state_0 & 0b11) != 0 /* is-state_0 doBytes(byte[], int, int, byte[], Object) || doBytesMask(byte[], int, int, byte[], byte[]) */ && arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                if (arg3Value instanceof byte[]) {
                    byte[] arg3Value_ = (byte[]) arg3Value;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doBytes(byte[], int, int, byte[], Object) */) {
                        if ((arg4Value == null)) {
                            return doBytes(arg0Value_, arg1Value, arg2Value, arg3Value_, arg4Value);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doBytesMask(byte[], int, int, byte[], byte[]) */ && arg4Value instanceof byte[]) {
                        byte[] arg4Value_ = (byte[]) arg4Value;
                        if ((arg4Value_ != null)) {
                            return doBytesMask(arg0Value_, arg1Value, arg2Value, arg3Value_, arg4Value_);
                        }
                    }
                }
            }
            if ((state_0 & 0b1100) != 0 /* is-state_0 doString(String, int, int, String, Object) || doStringMask(String, int, int, String, String) */ && arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                if (arg3Value instanceof String) {
                    String arg3Value_ = (String) arg3Value;
                    if ((state_0 & 0b100) != 0 /* is-state_0 doString(String, int, int, String, Object) */) {
                        if ((arg4Value == null)) {
                            return doString(arg0Value_, arg1Value, arg2Value, arg3Value_, arg4Value);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doStringMask(String, int, int, String, String) */ && arg4Value instanceof String) {
                        String arg4Value_ = (String) arg4Value;
                        if ((arg4Value_ != null)) {
                            return doStringMask(arg0Value_, arg1Value, arg2Value, arg3Value_, arg4Value_);
                        }
                    }
                }
            }
            if ((state_0 & 0b110000) != 0 /* is-state_0 doTruffleObjBytes(Object, int, int, byte[], Object, InputLengthNode, InputRegionMatchesNode) || doTruffleObjString(Object, int, int, String, Object, InputLengthNode, InputRegionMatchesNode) */) {
                if ((state_0 & 0b10000) != 0 /* is-state_0 doTruffleObjBytes(Object, int, int, byte[], Object, InputLengthNode, InputRegionMatchesNode) */ && arg3Value instanceof byte[]) {
                    byte[] arg3Value_ = (byte[]) arg3Value;
                    if ((InputIndexOfStringNode.neitherByteArrayNorString(arg0Value))) {
                        return doTruffleObjBytes(arg0Value, arg1Value, arg2Value, arg3Value_, arg4Value, this.truffleObjBytes_lengthNode_, this.truffleObjBytes_regionMatchesNode_);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 doTruffleObjString(Object, int, int, String, Object, InputLengthNode, InputRegionMatchesNode) */ && arg3Value instanceof String) {
                    String arg3Value_ = (String) arg3Value;
                    if ((InputIndexOfStringNode.neitherByteArrayNorString(arg0Value))) {
                        return doTruffleObjString(arg0Value, arg1Value, arg2Value, arg3Value_, arg4Value, this.truffleObjString_lengthNode_, this.truffleObjString_regionMatchesNode_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
    }

    private int executeAndSpecialize(Object arg0Value, int arg1Value, int arg2Value, Object arg3Value, Object arg4Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                if (arg3Value instanceof byte[]) {
                    byte[] arg3Value_ = (byte[]) arg3Value;
                    if ((arg4Value == null)) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBytes(byte[], int, int, byte[], Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doBytes(arg0Value_, arg1Value, arg2Value, arg3Value_, arg4Value);
                    }
                    if (arg4Value instanceof byte[]) {
                        byte[] arg4Value_ = (byte[]) arg4Value;
                        if ((arg4Value_ != null)) {
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doBytesMask(byte[], int, int, byte[], byte[]) */;
                            lock.unlock();
                            hasLock = false;
                            return doBytesMask(arg0Value_, arg1Value, arg2Value, arg3Value_, arg4Value_);
                        }
                    }
                }
            }
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                if (arg3Value instanceof String) {
                    String arg3Value_ = (String) arg3Value;
                    if ((arg4Value == null)) {
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doString(String, int, int, String, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doString(arg0Value_, arg1Value, arg2Value, arg3Value_, arg4Value);
                    }
                    if (arg4Value instanceof String) {
                        String arg4Value_ = (String) arg4Value;
                        if ((arg4Value_ != null)) {
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doStringMask(String, int, int, String, String) */;
                            lock.unlock();
                            hasLock = false;
                            return doStringMask(arg0Value_, arg1Value, arg2Value, arg3Value_, arg4Value_);
                        }
                    }
                }
            }
            if (arg3Value instanceof byte[]) {
                byte[] arg3Value_ = (byte[]) arg3Value;
                if ((InputIndexOfStringNode.neitherByteArrayNorString(arg0Value))) {
                    this.truffleObjBytes_lengthNode_ = super.insert((InputLengthNode.create()));
                    this.truffleObjBytes_regionMatchesNode_ = super.insert((InputRegionMatchesNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doTruffleObjBytes(Object, int, int, byte[], Object, InputLengthNode, InputRegionMatchesNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doTruffleObjBytes(arg0Value, arg1Value, arg2Value, arg3Value_, arg4Value, this.truffleObjBytes_lengthNode_, this.truffleObjBytes_regionMatchesNode_);
                }
            }
            if (arg3Value instanceof String) {
                String arg3Value_ = (String) arg3Value;
                if ((InputIndexOfStringNode.neitherByteArrayNorString(arg0Value))) {
                    this.truffleObjString_lengthNode_ = super.insert((InputLengthNode.create()));
                    this.truffleObjString_regionMatchesNode_ = super.insert((InputRegionMatchesNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doTruffleObjString(Object, int, int, String, Object, InputLengthNode, InputRegionMatchesNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doTruffleObjString(arg0Value, arg1Value, arg2Value, arg3Value_, arg4Value, this.truffleObjString_lengthNode_, this.truffleObjString_regionMatchesNode_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
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

    public static InputIndexOfStringNode create() {
        return new InputIndexOfStringNodeGen();
    }

}
