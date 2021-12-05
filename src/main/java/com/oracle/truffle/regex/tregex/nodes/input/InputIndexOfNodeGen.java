// CheckStyle: start generated
package com.oracle.truffle.regex.tregex.nodes.input;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InputIndexOfNode.class)
public final class InputIndexOfNodeGen extends InputIndexOfNode {

    @CompilationFinal private volatile int state_0_;
    @Child private InputReadNode truffleObjBytes_charAtNode_;
    @Child private InputReadNode truffleObjChars_charAtNode_;

    private InputIndexOfNodeGen() {
    }

    @Override
    public int execute(Object arg0Value, int arg1Value, int arg2Value, Object arg3Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doBytes(byte[], int, int, byte[]) || doChars(String, int, int, char[]) || doTruffleObjBytes(Object, int, int, byte[], InputReadNode) || doTruffleObjChars(Object, int, int, char[], InputReadNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doBytes(byte[], int, int, byte[]) */ && arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                if (arg3Value instanceof byte[]) {
                    byte[] arg3Value_ = (byte[]) arg3Value;
                    return doBytes(arg0Value_, arg1Value, arg2Value, arg3Value_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doChars(String, int, int, char[]) */ && arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                if (arg3Value instanceof char[]) {
                    char[] arg3Value_ = (char[]) arg3Value;
                    return doChars(arg0Value_, arg1Value, arg2Value, arg3Value_);
                }
            }
            if ((state_0 & 0b1100) != 0 /* is-state_0 doTruffleObjBytes(Object, int, int, byte[], InputReadNode) || doTruffleObjChars(Object, int, int, char[], InputReadNode) */) {
                if ((state_0 & 0b100) != 0 /* is-state_0 doTruffleObjBytes(Object, int, int, byte[], InputReadNode) */ && arg3Value instanceof byte[]) {
                    byte[] arg3Value_ = (byte[]) arg3Value;
                    if ((InputIndexOfNode.neitherByteArrayNorString(arg0Value))) {
                        return doTruffleObjBytes(arg0Value, arg1Value, arg2Value, arg3Value_, this.truffleObjBytes_charAtNode_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doTruffleObjChars(Object, int, int, char[], InputReadNode) */ && arg3Value instanceof char[]) {
                    char[] arg3Value_ = (char[]) arg3Value;
                    if ((InputIndexOfNode.neitherByteArrayNorString(arg0Value))) {
                        return doTruffleObjChars(arg0Value, arg1Value, arg2Value, arg3Value_, this.truffleObjChars_charAtNode_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
    }

    private int executeAndSpecialize(Object arg0Value, int arg1Value, int arg2Value, Object arg3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                if (arg3Value instanceof byte[]) {
                    byte[] arg3Value_ = (byte[]) arg3Value;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBytes(byte[], int, int, byte[]) */;
                    lock.unlock();
                    hasLock = false;
                    return doBytes(arg0Value_, arg1Value, arg2Value, arg3Value_);
                }
            }
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                if (arg3Value instanceof char[]) {
                    char[] arg3Value_ = (char[]) arg3Value;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doChars(String, int, int, char[]) */;
                    lock.unlock();
                    hasLock = false;
                    return doChars(arg0Value_, arg1Value, arg2Value, arg3Value_);
                }
            }
            if (arg3Value instanceof byte[]) {
                byte[] arg3Value_ = (byte[]) arg3Value;
                if ((InputIndexOfNode.neitherByteArrayNorString(arg0Value))) {
                    this.truffleObjBytes_charAtNode_ = super.insert((InputReadNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doTruffleObjBytes(Object, int, int, byte[], InputReadNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doTruffleObjBytes(arg0Value, arg1Value, arg2Value, arg3Value_, this.truffleObjBytes_charAtNode_);
                }
            }
            if (arg3Value instanceof char[]) {
                char[] arg3Value_ = (char[]) arg3Value;
                if ((InputIndexOfNode.neitherByteArrayNorString(arg0Value))) {
                    this.truffleObjChars_charAtNode_ = super.insert((InputReadNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doTruffleObjChars(Object, int, int, char[], InputReadNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doTruffleObjChars(arg0Value, arg1Value, arg2Value, arg3Value_, this.truffleObjChars_charAtNode_);
                }
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

    public static InputIndexOfNode create() {
        return new InputIndexOfNodeGen();
    }

}
