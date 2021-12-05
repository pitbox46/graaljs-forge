// CheckStyle: start generated
package com.oracle.truffle.regex.tregex.nodes.input;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InputRegionMatchesNode.class)
public final class InputRegionMatchesNodeGen extends InputRegionMatchesNode {

    @CompilationFinal private volatile int state_0_;
    @Child private InputLengthNode truffleObjBytes_lengthNode_;
    @Child private InputReadNode truffleObjBytes_charAtNode_;
    @Child private InputLengthNode truffleObjBytesMask_lengthNode_;
    @Child private InputReadNode truffleObjBytesMask_charAtNode_;
    @Child private InputLengthNode truffleObjString_lengthNode_;
    @Child private InputReadNode truffleObjString_charAtNode_;
    @Child private InputLengthNode truffleObjStringMask_lengthNode_;
    @Child private InputReadNode truffleObjStringMask_charAtNode_;
    @Child private TruffleObjTruffleObjData truffleObjTruffleObj_cache;

    private InputRegionMatchesNodeGen() {
    }

    @Override
    public boolean execute(Object arg0Value, int arg1Value, Object arg2Value, int arg3Value, int arg4Value, Object arg5Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doBytes(byte[], int, byte[], int, int, Object) || doBytesMask(byte[], int, byte[], int, int, byte[]) || doString(String, int, String, int, int, Object) || doJavaStringMask(String, int, String, int, int, String) || doTruffleObjBytes(Object, int, byte[], int, int, Object, InputLengthNode, InputReadNode) || doTruffleObjBytesMask(Object, int, byte[], int, int, byte[], InputLengthNode, InputReadNode) || doTruffleObjString(Object, int, String, int, int, Object, InputLengthNode, InputReadNode) || doTruffleObjStringMask(Object, int, String, int, int, String, InputLengthNode, InputReadNode) || doTruffleObjTruffleObj(Object, int, Object, int, int, Object, InputLengthNode, InputReadNode, InputLengthNode, InputReadNode) */) {
            if ((state_0 & 0b11) != 0 /* is-state_0 doBytes(byte[], int, byte[], int, int, Object) || doBytesMask(byte[], int, byte[], int, int, byte[]) */ && arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                if (arg2Value instanceof byte[]) {
                    byte[] arg2Value_ = (byte[]) arg2Value;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doBytes(byte[], int, byte[], int, int, Object) */) {
                        if ((arg5Value == null)) {
                            return doBytes(arg0Value_, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doBytesMask(byte[], int, byte[], int, int, byte[]) */ && arg5Value instanceof byte[]) {
                        byte[] arg5Value_ = (byte[]) arg5Value;
                        if ((arg5Value_ != null)) {
                            return doBytesMask(arg0Value_, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value_);
                        }
                    }
                }
            }
            if ((state_0 & 0b1100) != 0 /* is-state_0 doString(String, int, String, int, int, Object) || doJavaStringMask(String, int, String, int, int, String) */ && arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                if (arg2Value instanceof String) {
                    String arg2Value_ = (String) arg2Value;
                    if ((state_0 & 0b100) != 0 /* is-state_0 doString(String, int, String, int, int, Object) */) {
                        if ((arg5Value == null)) {
                            return doString(arg0Value_, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doJavaStringMask(String, int, String, int, int, String) */ && arg5Value instanceof String) {
                        String arg5Value_ = (String) arg5Value;
                        if ((arg5Value_ != null)) {
                            return doJavaStringMask(arg0Value_, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value_);
                        }
                    }
                }
            }
            if ((state_0 & 0b111110000) != 0 /* is-state_0 doTruffleObjBytes(Object, int, byte[], int, int, Object, InputLengthNode, InputReadNode) || doTruffleObjBytesMask(Object, int, byte[], int, int, byte[], InputLengthNode, InputReadNode) || doTruffleObjString(Object, int, String, int, int, Object, InputLengthNode, InputReadNode) || doTruffleObjStringMask(Object, int, String, int, int, String, InputLengthNode, InputReadNode) || doTruffleObjTruffleObj(Object, int, Object, int, int, Object, InputLengthNode, InputReadNode, InputLengthNode, InputReadNode) */) {
                if ((state_0 & 0b110000) != 0 /* is-state_0 doTruffleObjBytes(Object, int, byte[], int, int, Object, InputLengthNode, InputReadNode) || doTruffleObjBytesMask(Object, int, byte[], int, int, byte[], InputLengthNode, InputReadNode) */ && arg2Value instanceof byte[]) {
                    byte[] arg2Value_ = (byte[]) arg2Value;
                    if ((state_0 & 0b10000) != 0 /* is-state_0 doTruffleObjBytes(Object, int, byte[], int, int, Object, InputLengthNode, InputReadNode) */) {
                        if ((InputRegionMatchesNode.neitherByteArrayNorString(arg0Value)) && (arg5Value == null)) {
                            return doTruffleObjBytes(arg0Value, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value, this.truffleObjBytes_lengthNode_, this.truffleObjBytes_charAtNode_);
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 doTruffleObjBytesMask(Object, int, byte[], int, int, byte[], InputLengthNode, InputReadNode) */ && arg5Value instanceof byte[]) {
                        byte[] arg5Value_ = (byte[]) arg5Value;
                        if ((InputRegionMatchesNode.neitherByteArrayNorString(arg0Value)) && (arg5Value_ != null)) {
                            return doTruffleObjBytesMask(arg0Value, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value_, this.truffleObjBytesMask_lengthNode_, this.truffleObjBytesMask_charAtNode_);
                        }
                    }
                }
                if ((state_0 & 0b11000000) != 0 /* is-state_0 doTruffleObjString(Object, int, String, int, int, Object, InputLengthNode, InputReadNode) || doTruffleObjStringMask(Object, int, String, int, int, String, InputLengthNode, InputReadNode) */ && arg2Value instanceof String) {
                    String arg2Value_ = (String) arg2Value;
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 doTruffleObjString(Object, int, String, int, int, Object, InputLengthNode, InputReadNode) */) {
                        if ((InputRegionMatchesNode.neitherByteArrayNorString(arg0Value)) && (arg5Value == null)) {
                            return doTruffleObjString(arg0Value, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value, this.truffleObjString_lengthNode_, this.truffleObjString_charAtNode_);
                        }
                    }
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 doTruffleObjStringMask(Object, int, String, int, int, String, InputLengthNode, InputReadNode) */ && arg5Value instanceof String) {
                        String arg5Value_ = (String) arg5Value;
                        if ((InputRegionMatchesNode.neitherByteArrayNorString(arg0Value)) && (arg5Value_ != null)) {
                            return doTruffleObjStringMask(arg0Value, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value_, this.truffleObjStringMask_lengthNode_, this.truffleObjStringMask_charAtNode_);
                        }
                    }
                }
                if ((state_0 & 0b100000000) != 0 /* is-state_0 doTruffleObjTruffleObj(Object, int, Object, int, int, Object, InputLengthNode, InputReadNode, InputLengthNode, InputReadNode) */) {
                    TruffleObjTruffleObjData s8_ = this.truffleObjTruffleObj_cache;
                    if (s8_ != null) {
                        if ((InputRegionMatchesNode.neitherByteArrayNorString(arg0Value)) && (InputRegionMatchesNode.neitherByteArrayNorString(arg2Value)) && (arg5Value == null)) {
                            return doTruffleObjTruffleObj(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, s8_.lengthNode1_, s8_.charAtNode1_, s8_.lengthNode2_, s8_.charAtNode2_);
                        }
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value);
    }

    private boolean executeAndSpecialize(Object arg0Value, int arg1Value, Object arg2Value, int arg3Value, int arg4Value, Object arg5Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                if (arg2Value instanceof byte[]) {
                    byte[] arg2Value_ = (byte[]) arg2Value;
                    if ((arg5Value == null)) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBytes(byte[], int, byte[], int, int, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doBytes(arg0Value_, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value);
                    }
                    if (arg5Value instanceof byte[]) {
                        byte[] arg5Value_ = (byte[]) arg5Value;
                        if ((arg5Value_ != null)) {
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doBytesMask(byte[], int, byte[], int, int, byte[]) */;
                            lock.unlock();
                            hasLock = false;
                            return doBytesMask(arg0Value_, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value_);
                        }
                    }
                }
            }
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                if (arg2Value instanceof String) {
                    String arg2Value_ = (String) arg2Value;
                    if ((arg5Value == null)) {
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doString(String, int, String, int, int, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doString(arg0Value_, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value);
                    }
                    if (arg5Value instanceof String) {
                        String arg5Value_ = (String) arg5Value;
                        if ((arg5Value_ != null)) {
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doJavaStringMask(String, int, String, int, int, String) */;
                            lock.unlock();
                            hasLock = false;
                            return doJavaStringMask(arg0Value_, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value_);
                        }
                    }
                }
            }
            if (arg2Value instanceof byte[]) {
                byte[] arg2Value_ = (byte[]) arg2Value;
                if ((InputRegionMatchesNode.neitherByteArrayNorString(arg0Value)) && (arg5Value == null)) {
                    this.truffleObjBytes_lengthNode_ = super.insert((InputLengthNode.create()));
                    this.truffleObjBytes_charAtNode_ = super.insert((InputReadNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doTruffleObjBytes(Object, int, byte[], int, int, Object, InputLengthNode, InputReadNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doTruffleObjBytes(arg0Value, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value, this.truffleObjBytes_lengthNode_, this.truffleObjBytes_charAtNode_);
                }
                if (arg5Value instanceof byte[]) {
                    byte[] arg5Value_ = (byte[]) arg5Value;
                    if ((InputRegionMatchesNode.neitherByteArrayNorString(arg0Value)) && (arg5Value_ != null)) {
                        this.truffleObjBytesMask_lengthNode_ = super.insert((InputLengthNode.create()));
                        this.truffleObjBytesMask_charAtNode_ = super.insert((InputReadNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doTruffleObjBytesMask(Object, int, byte[], int, int, byte[], InputLengthNode, InputReadNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doTruffleObjBytesMask(arg0Value, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value_, this.truffleObjBytesMask_lengthNode_, this.truffleObjBytesMask_charAtNode_);
                    }
                }
            }
            if (arg2Value instanceof String) {
                String arg2Value_ = (String) arg2Value;
                if ((InputRegionMatchesNode.neitherByteArrayNorString(arg0Value)) && (arg5Value == null)) {
                    this.truffleObjString_lengthNode_ = super.insert((InputLengthNode.create()));
                    this.truffleObjString_charAtNode_ = super.insert((InputReadNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doTruffleObjString(Object, int, String, int, int, Object, InputLengthNode, InputReadNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doTruffleObjString(arg0Value, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value, this.truffleObjString_lengthNode_, this.truffleObjString_charAtNode_);
                }
                if (arg5Value instanceof String) {
                    String arg5Value_ = (String) arg5Value;
                    if ((InputRegionMatchesNode.neitherByteArrayNorString(arg0Value)) && (arg5Value_ != null)) {
                        this.truffleObjStringMask_lengthNode_ = super.insert((InputLengthNode.create()));
                        this.truffleObjStringMask_charAtNode_ = super.insert((InputReadNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doTruffleObjStringMask(Object, int, String, int, int, String, InputLengthNode, InputReadNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doTruffleObjStringMask(arg0Value, arg1Value, arg2Value_, arg3Value, arg4Value, arg5Value_, this.truffleObjStringMask_lengthNode_, this.truffleObjStringMask_charAtNode_);
                    }
                }
            }
            if ((InputRegionMatchesNode.neitherByteArrayNorString(arg0Value)) && (InputRegionMatchesNode.neitherByteArrayNorString(arg2Value)) && (arg5Value == null)) {
                TruffleObjTruffleObjData s8_ = super.insert(new TruffleObjTruffleObjData());
                s8_.lengthNode1_ = s8_.insertAccessor((InputLengthNode.create()));
                s8_.charAtNode1_ = s8_.insertAccessor((InputReadNode.create()));
                s8_.lengthNode2_ = s8_.insertAccessor((InputLengthNode.create()));
                s8_.charAtNode2_ = s8_.insertAccessor((InputReadNode.create()));
                MemoryFence.storeStore();
                this.truffleObjTruffleObj_cache = s8_;
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doTruffleObjTruffleObj(Object, int, Object, int, int, Object, InputLengthNode, InputReadNode, InputLengthNode, InputReadNode) */;
                lock.unlock();
                hasLock = false;
                return doTruffleObjTruffleObj(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, s8_.lengthNode1_, s8_.charAtNode1_, s8_.lengthNode2_, s8_.charAtNode2_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value);
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

    public static InputRegionMatchesNode create() {
        return new InputRegionMatchesNodeGen();
    }

    @GeneratedBy(InputRegionMatchesNode.class)
    private static final class TruffleObjTruffleObjData extends Node {

        @Child InputLengthNode lengthNode1_;
        @Child InputReadNode charAtNode1_;
        @Child InputLengthNode lengthNode2_;
        @Child InputReadNode charAtNode2_;

        TruffleObjTruffleObjData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
}
