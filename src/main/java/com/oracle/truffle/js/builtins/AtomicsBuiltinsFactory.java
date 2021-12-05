// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.builtins.AtomicsBuiltins.AtomicBinaryOperator;
import com.oracle.truffle.js.builtins.AtomicsBuiltins.AtomicIntBinaryOperator;
import com.oracle.truffle.js.builtins.AtomicsBuiltins.AtomicsCompareExchangeNode;
import com.oracle.truffle.js.builtins.AtomicsBuiltins.AtomicsComputeNode;
import com.oracle.truffle.js.builtins.AtomicsBuiltins.AtomicsIsLockFreeNode;
import com.oracle.truffle.js.builtins.AtomicsBuiltins.AtomicsLoadNode;
import com.oracle.truffle.js.builtins.AtomicsBuiltins.AtomicsNotifyNode;
import com.oracle.truffle.js.builtins.AtomicsBuiltins.AtomicsOperationNode;
import com.oracle.truffle.js.builtins.AtomicsBuiltins.AtomicsStoreNode;
import com.oracle.truffle.js.builtins.AtomicsBuiltins.AtomicsWaitAsyncNode;
import com.oracle.truffle.js.builtins.AtomicsBuiltins.AtomicsWaitNode;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToIndexNode;
import com.oracle.truffle.js.nodes.cast.JSToInt32Node;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(AtomicsBuiltins.class)
public final class AtomicsBuiltinsFactory {

    @GeneratedBy(AtomicsCompareExchangeNode.class)
    public static final class AtomicsCompareExchangeNodeGen extends AtomicsCompareExchangeNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToIndexNode int32ArrayByteObjIdx_toIndexNode_;
        @Child private JSToIndexNode int32ArrayIntObjIdx_toIndexNode_;
        @Child private JSToIndexNode int32ArrayObjObjIdx_toIndexNode_;
        @Child private JSToIndexNode bigInt64ArrayObjObjIdx_toIndexNode_;
        @Child private JSToIndexNode bigUint64ArrayObjObjIdx_toIndexNode_;
        @Child private JSToIndexNode generic_toIndexNode_;
        @CompilationFinal private BranchProfile generic_notSharedArrayBuffer_;

        private AtomicsCompareExchangeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
            this.arguments3_ = arguments != null && 3 < arguments.length ? arguments[3] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b11111110110000) == 0 /* only-active doInt8ArrayByte(DynamicObject, int, int, int) && doUint8ArrayByte(DynamicObject, int, int, int) && doInt16ArrayByte(DynamicObject, int, int, int) && doUint16ArrayByte(DynamicObject, int, int, int) && doInt32ArrayInt(DynamicObject, int, int, int) */ && (state_0 != 0  /* is-not doInt8ArrayByte(DynamicObject, int, int, int) && doUint8ArrayByte(DynamicObject, int, int, int) && doInt16ArrayByte(DynamicObject, int, int, int) && doUint16ArrayByte(DynamicObject, int, int, int) && doUint32ArrayByte(DynamicObject, int, Object, Object) && doInt32ArrayByte(DynamicObject, int, byte, byte) && doInt32ArrayInt(DynamicObject, int, int, int) && doInt32ArrayObj(DynamicObject, int, Object, Object) && doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) && doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) && doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) && doBigUint64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, Object, JSToIndexNode, BranchProfile) */)) {
                return execute_int_int_int0(state_0, frameValue);
            } else if ((state_0 & 0b11110111111111) == 0 /* only-active doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) */ && (state_0 != 0  /* is-not doInt8ArrayByte(DynamicObject, int, int, int) && doUint8ArrayByte(DynamicObject, int, int, int) && doInt16ArrayByte(DynamicObject, int, int, int) && doUint16ArrayByte(DynamicObject, int, int, int) && doUint32ArrayByte(DynamicObject, int, Object, Object) && doInt32ArrayByte(DynamicObject, int, byte, byte) && doInt32ArrayInt(DynamicObject, int, int, int) && doInt32ArrayObj(DynamicObject, int, Object, Object) && doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) && doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) && doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) && doBigUint64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, Object, JSToIndexNode, BranchProfile) */)) {
                return execute_int_int1(state_0, frameValue);
            } else if ((state_0 & 0b11111100001111) == 0 /* only-active doUint32ArrayByte(DynamicObject, int, Object, Object) && doInt32ArrayByte(DynamicObject, int, byte, byte) && doInt32ArrayInt(DynamicObject, int, int, int) && doInt32ArrayObj(DynamicObject, int, Object, Object) */ && (state_0 != 0  /* is-not doInt8ArrayByte(DynamicObject, int, int, int) && doUint8ArrayByte(DynamicObject, int, int, int) && doInt16ArrayByte(DynamicObject, int, int, int) && doUint16ArrayByte(DynamicObject, int, int, int) && doUint32ArrayByte(DynamicObject, int, Object, Object) && doInt32ArrayByte(DynamicObject, int, byte, byte) && doInt32ArrayInt(DynamicObject, int, int, int) && doInt32ArrayObj(DynamicObject, int, Object, Object) && doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) && doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) && doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) && doBigUint64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, Object, JSToIndexNode, BranchProfile) */)) {
                return execute_int2(state_0, frameValue);
            } else {
                return execute_generic3(state_0, frameValue);
            }
        }

        private Object execute_int_int_int0(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                Object arguments3Value = this.arguments3_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value, arguments3Value);
            }
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments3Value = this.arguments3_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult(), arguments3Value);
            }
            int arguments3Value_;
            try {
                arguments3Value_ = this.arguments3_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, ex.getResult());
            }
            if ((state_0 & 0b1001111) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) || doUint8ArrayByte(DynamicObject, int, int, int) || doInt16ArrayByte(DynamicObject, int, int, int) || doUint16ArrayByte(DynamicObject, int, int, int) || doInt32ArrayInt(DynamicObject, int, int, int) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) */) {
                    if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt8ArrayByte(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayByte(DynamicObject, int, int, int) */) {
                    if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint8ArrayByte(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayByte(DynamicObject, int, int, int) */) {
                    if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt16ArrayByte(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayByte(DynamicObject, int, int, int) */) {
                    if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint16ArrayByte(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayInt(DynamicObject, int, int, int) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt32ArrayInt(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        private Object execute_int_int1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments3Value = this.arguments3_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult(), arguments3Value);
            }
            int arguments3Value_;
            try {
                arguments3Value_ = this.arguments3_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, ex.getResult());
            }
            assert (state_0 & 0b1000000000) != 0 /* is-state_0 doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                    return doInt32ArrayIntObjIdx(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, this.int32ArrayIntObjIdx_toIndexNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        private Object execute_int2(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                Object arguments3Value = this.arguments3_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value, arguments3Value);
            }
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if ((state_0 & 0b11110000) != 0 /* is-state_0 doUint32ArrayByte(DynamicObject, int, Object, Object) || doInt32ArrayByte(DynamicObject, int, byte, byte) || doInt32ArrayInt(DynamicObject, int, int, int) || doInt32ArrayObj(DynamicObject, int, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b10000) != 0 /* is-state_0 doUint32ArrayByte(DynamicObject, int, Object, Object) */) {
                    if ((AtomicsOperationNode.isUint32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint32ArrayByte(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 doInt32ArrayByte(DynamicObject, int, byte, byte) */ && arguments2Value_ instanceof Byte) {
                    byte arguments2Value__ = (byte) arguments2Value_;
                    if (arguments3Value_ instanceof Byte) {
                        byte arguments3Value__ = (byte) arguments3Value_;
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                            return doInt32ArrayByte(arguments0Value__, arguments1Value_, arguments2Value__, arguments3Value__);
                        }
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayInt(DynamicObject, int, int, int) */ && arguments2Value_ instanceof Integer) {
                    int arguments2Value__ = (int) arguments2Value_;
                    if (arguments3Value_ instanceof Integer) {
                        int arguments3Value__ = (int) arguments3Value_;
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                            return doInt32ArrayInt(arguments0Value__, arguments1Value_, arguments2Value__, arguments3Value__);
                        }
                    }
                }
                if ((state_0 & 0b10000000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, Object, Object) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt32ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        private Object execute_generic3(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if ((state_0 & 0b1111111111111) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) || doUint8ArrayByte(DynamicObject, int, int, int) || doInt16ArrayByte(DynamicObject, int, int, int) || doUint16ArrayByte(DynamicObject, int, int, int) || doUint32ArrayByte(DynamicObject, int, Object, Object) || doInt32ArrayByte(DynamicObject, int, byte, byte) || doInt32ArrayInt(DynamicObject, int, int, int) || doInt32ArrayObj(DynamicObject, int, Object, Object) || doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) || doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) || doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) || doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) || doBigUint64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b11111111) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) || doUint8ArrayByte(DynamicObject, int, int, int) || doInt16ArrayByte(DynamicObject, int, int, int) || doUint16ArrayByte(DynamicObject, int, int, int) || doUint32ArrayByte(DynamicObject, int, Object, Object) || doInt32ArrayByte(DynamicObject, int, byte, byte) || doInt32ArrayInt(DynamicObject, int, int, int) || doInt32ArrayObj(DynamicObject, int, Object, Object) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((state_0 & 0b1111) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) || doUint8ArrayByte(DynamicObject, int, int, int) || doInt16ArrayByte(DynamicObject, int, int, int) || doUint16ArrayByte(DynamicObject, int, int, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if (arguments3Value_ instanceof Integer) {
                            int arguments3Value__ = (int) arguments3Value_;
                            if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) */) {
                                if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                    return doInt8ArrayByte(arguments0Value__, arguments1Value__, arguments2Value__, arguments3Value__);
                                }
                            }
                            if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayByte(DynamicObject, int, int, int) */) {
                                if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                    return doUint8ArrayByte(arguments0Value__, arguments1Value__, arguments2Value__, arguments3Value__);
                                }
                            }
                            if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayByte(DynamicObject, int, int, int) */) {
                                if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                    return doInt16ArrayByte(arguments0Value__, arguments1Value__, arguments2Value__, arguments3Value__);
                                }
                            }
                            if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayByte(DynamicObject, int, int, int) */) {
                                if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                    return doUint16ArrayByte(arguments0Value__, arguments1Value__, arguments2Value__, arguments3Value__);
                                }
                            }
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 doUint32ArrayByte(DynamicObject, int, Object, Object) */) {
                        if ((AtomicsOperationNode.isUint32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doUint32ArrayByte(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_);
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 doInt32ArrayByte(DynamicObject, int, byte, byte) */ && arguments2Value_ instanceof Byte) {
                        byte arguments2Value__ = (byte) arguments2Value_;
                        if (arguments3Value_ instanceof Byte) {
                            byte arguments3Value__ = (byte) arguments3Value_;
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                return doInt32ArrayByte(arguments0Value__, arguments1Value__, arguments2Value__, arguments3Value__);
                            }
                        }
                    }
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayInt(DynamicObject, int, int, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if (arguments3Value_ instanceof Integer) {
                            int arguments3Value__ = (int) arguments3Value_;
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                return doInt32ArrayInt(arguments0Value__, arguments1Value__, arguments2Value__, arguments3Value__);
                            }
                        }
                    }
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, Object, Object) */) {
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt32ArrayObj(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_);
                        }
                    }
                }
                if ((state_0 & 0b1111100000000) != 0 /* is-state_0 doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) || doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) || doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) || doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) || doBigUint64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */) {
                    if ((state_0 & 0b100000000) != 0 /* is-state_0 doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) */ && arguments2Value_ instanceof Byte) {
                        byte arguments2Value__ = (byte) arguments2Value_;
                        if (arguments3Value_ instanceof Byte) {
                            byte arguments3Value__ = (byte) arguments3Value_;
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                                return doInt32ArrayByteObjIdx(arguments0Value__, arguments1Value_, arguments2Value__, arguments3Value__, this.int32ArrayByteObjIdx_toIndexNode_);
                            }
                        }
                    }
                    if ((state_0 & 0b1000000000) != 0 /* is-state_0 doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if (arguments3Value_ instanceof Integer) {
                            int arguments3Value__ = (int) arguments3Value_;
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                                return doInt32ArrayIntObjIdx(arguments0Value__, arguments1Value_, arguments2Value__, arguments3Value__, this.int32ArrayIntObjIdx_toIndexNode_);
                            }
                        }
                    }
                    if ((state_0 & 0b1110000000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) || doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) || doBigUint64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */) {
                        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */) {
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                                return doInt32ArrayObjObjIdx(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, this.int32ArrayObjObjIdx_toIndexNode_);
                            }
                        }
                        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */) {
                            if ((AtomicsOperationNode.isBigInt64SharedBufferView(arguments0Value__))) {
                                return doBigInt64ArrayObjObjIdx(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, this.bigInt64ArrayObjObjIdx_toIndexNode_);
                            }
                        }
                        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doBigUint64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */) {
                            if ((AtomicsOperationNode.isBigUint64SharedBufferView(arguments0Value__))) {
                                return doBigUint64ArrayObjObjIdx(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, this.bigUint64ArrayObjObjIdx_toIndexNode_);
                            }
                        }
                    }
                }
            }
            if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doGeneric(Object, Object, Object, Object, JSToIndexNode, BranchProfile) */) {
                return doGeneric(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_, this.generic_toIndexNode_, this.generic_notSharedArrayBuffer_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b10000000010000) != 0 /* is-state_0 doUint32ArrayByte(DynamicObject, int, Object, Object) || doGeneric(Object, Object, Object, Object, JSToIndexNode, BranchProfile) */) {
                return JSTypesGen.expectInteger(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b11110100000) == 0 /* only-active doInt8ArrayByte(DynamicObject, int, int, int) && doUint8ArrayByte(DynamicObject, int, int, int) && doInt16ArrayByte(DynamicObject, int, int, int) && doUint16ArrayByte(DynamicObject, int, int, int) && doInt32ArrayInt(DynamicObject, int, int, int) */ && ((state_0 & 0b11111101111) != 0  /* is-not doInt8ArrayByte(DynamicObject, int, int, int) && doUint8ArrayByte(DynamicObject, int, int, int) && doInt16ArrayByte(DynamicObject, int, int, int) && doUint16ArrayByte(DynamicObject, int, int, int) && doInt32ArrayByte(DynamicObject, int, byte, byte) && doInt32ArrayInt(DynamicObject, int, int, int) && doInt32ArrayObj(DynamicObject, int, Object, Object) && doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) && doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) && doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */)) {
                return executeInt_int_int_int4(state_0, frameValue, arguments0Value_);
            } else if ((state_0 & 0b10111101111) == 0 /* only-active doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) */ && ((state_0 & 0b11111101111) != 0  /* is-not doInt8ArrayByte(DynamicObject, int, int, int) && doUint8ArrayByte(DynamicObject, int, int, int) && doInt16ArrayByte(DynamicObject, int, int, int) && doUint16ArrayByte(DynamicObject, int, int, int) && doInt32ArrayByte(DynamicObject, int, byte, byte) && doInt32ArrayInt(DynamicObject, int, int, int) && doInt32ArrayObj(DynamicObject, int, Object, Object) && doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) && doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) && doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */)) {
                return executeInt_int_int5(state_0, frameValue, arguments0Value_);
            } else if ((state_0 & 0b11100001111) == 0 /* only-active doInt32ArrayByte(DynamicObject, int, byte, byte) && doInt32ArrayInt(DynamicObject, int, int, int) && doInt32ArrayObj(DynamicObject, int, Object, Object) */ && ((state_0 & 0b11111101111) != 0  /* is-not doInt8ArrayByte(DynamicObject, int, int, int) && doUint8ArrayByte(DynamicObject, int, int, int) && doInt16ArrayByte(DynamicObject, int, int, int) && doUint16ArrayByte(DynamicObject, int, int, int) && doInt32ArrayByte(DynamicObject, int, byte, byte) && doInt32ArrayInt(DynamicObject, int, int, int) && doInt32ArrayObj(DynamicObject, int, Object, Object) && doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) && doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) && doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */)) {
                return executeInt_int6(state_0, frameValue, arguments0Value_);
            } else {
                return executeInt_generic7(state_0, frameValue, arguments0Value_);
            }
        }

        private int executeInt_int_int_int4(int state_0, VirtualFrame frameValue, Object arguments0Value_) throws UnexpectedResultException {
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                Object arguments3Value = this.arguments3_.execute(frameValue);
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value, arguments3Value));
            }
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments3Value = this.arguments3_.execute(frameValue);
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult(), arguments3Value));
            }
            int arguments3Value_;
            try {
                arguments3Value_ = this.arguments3_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, ex.getResult()));
            }
            if ((state_0 & 0b1001111) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) || doUint8ArrayByte(DynamicObject, int, int, int) || doInt16ArrayByte(DynamicObject, int, int, int) || doUint16ArrayByte(DynamicObject, int, int, int) || doInt32ArrayInt(DynamicObject, int, int, int) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) */) {
                    if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt8ArrayByte(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayByte(DynamicObject, int, int, int) */) {
                    if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint8ArrayByte(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayByte(DynamicObject, int, int, int) */) {
                    if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt16ArrayByte(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayByte(DynamicObject, int, int, int) */) {
                    if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint16ArrayByte(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayInt(DynamicObject, int, int, int) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt32ArrayInt(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_));
        }

        private int executeInt_int_int5(int state_0, VirtualFrame frameValue, Object arguments0Value_) throws UnexpectedResultException {
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments3Value = this.arguments3_.execute(frameValue);
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult(), arguments3Value));
            }
            int arguments3Value_;
            try {
                arguments3Value_ = this.arguments3_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, ex.getResult()));
            }
            assert (state_0 & 0b1000000000) != 0 /* is-state_0 doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                    return doInt32ArrayIntObjIdx(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, this.int32ArrayIntObjIdx_toIndexNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_));
        }

        private int executeInt_int6(int state_0, VirtualFrame frameValue, Object arguments0Value_) throws UnexpectedResultException {
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                Object arguments3Value = this.arguments3_.execute(frameValue);
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value, arguments3Value));
            }
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if ((state_0 & 0b11100000) != 0 /* is-state_0 doInt32ArrayByte(DynamicObject, int, byte, byte) || doInt32ArrayInt(DynamicObject, int, int, int) || doInt32ArrayObj(DynamicObject, int, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 doInt32ArrayByte(DynamicObject, int, byte, byte) */ && arguments2Value_ instanceof Byte) {
                    byte arguments2Value__ = (byte) arguments2Value_;
                    if (arguments3Value_ instanceof Byte) {
                        byte arguments3Value__ = (byte) arguments3Value_;
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                            return doInt32ArrayByte(arguments0Value__, arguments1Value_, arguments2Value__, arguments3Value__);
                        }
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayInt(DynamicObject, int, int, int) */ && arguments2Value_ instanceof Integer) {
                    int arguments2Value__ = (int) arguments2Value_;
                    if (arguments3Value_ instanceof Integer) {
                        int arguments3Value__ = (int) arguments3Value_;
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                            return doInt32ArrayInt(arguments0Value__, arguments1Value_, arguments2Value__, arguments3Value__);
                        }
                    }
                }
                if ((state_0 & 0b10000000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, Object, Object) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt32ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_));
        }

        private int executeInt_generic7(int state_0, VirtualFrame frameValue, Object arguments0Value_) throws UnexpectedResultException {
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if ((state_0 & 0b11111101111) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) || doUint8ArrayByte(DynamicObject, int, int, int) || doInt16ArrayByte(DynamicObject, int, int, int) || doUint16ArrayByte(DynamicObject, int, int, int) || doInt32ArrayByte(DynamicObject, int, byte, byte) || doInt32ArrayInt(DynamicObject, int, int, int) || doInt32ArrayObj(DynamicObject, int, Object, Object) || doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) || doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) || doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b11101111) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) || doUint8ArrayByte(DynamicObject, int, int, int) || doInt16ArrayByte(DynamicObject, int, int, int) || doUint16ArrayByte(DynamicObject, int, int, int) || doInt32ArrayByte(DynamicObject, int, byte, byte) || doInt32ArrayInt(DynamicObject, int, int, int) || doInt32ArrayObj(DynamicObject, int, Object, Object) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((state_0 & 0b1111) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) || doUint8ArrayByte(DynamicObject, int, int, int) || doInt16ArrayByte(DynamicObject, int, int, int) || doUint16ArrayByte(DynamicObject, int, int, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if (arguments3Value_ instanceof Integer) {
                            int arguments3Value__ = (int) arguments3Value_;
                            if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) */) {
                                if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                    return doInt8ArrayByte(arguments0Value__, arguments1Value__, arguments2Value__, arguments3Value__);
                                }
                            }
                            if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayByte(DynamicObject, int, int, int) */) {
                                if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                    return doUint8ArrayByte(arguments0Value__, arguments1Value__, arguments2Value__, arguments3Value__);
                                }
                            }
                            if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayByte(DynamicObject, int, int, int) */) {
                                if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                    return doInt16ArrayByte(arguments0Value__, arguments1Value__, arguments2Value__, arguments3Value__);
                                }
                            }
                            if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayByte(DynamicObject, int, int, int) */) {
                                if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                    return doUint16ArrayByte(arguments0Value__, arguments1Value__, arguments2Value__, arguments3Value__);
                                }
                            }
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 doInt32ArrayByte(DynamicObject, int, byte, byte) */ && arguments2Value_ instanceof Byte) {
                        byte arguments2Value__ = (byte) arguments2Value_;
                        if (arguments3Value_ instanceof Byte) {
                            byte arguments3Value__ = (byte) arguments3Value_;
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                return doInt32ArrayByte(arguments0Value__, arguments1Value__, arguments2Value__, arguments3Value__);
                            }
                        }
                    }
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayInt(DynamicObject, int, int, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if (arguments3Value_ instanceof Integer) {
                            int arguments3Value__ = (int) arguments3Value_;
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                return doInt32ArrayInt(arguments0Value__, arguments1Value__, arguments2Value__, arguments3Value__);
                            }
                        }
                    }
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, Object, Object) */) {
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt32ArrayObj(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_);
                        }
                    }
                }
                if ((state_0 & 0b11100000000) != 0 /* is-state_0 doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) || doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) || doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */) {
                    if ((state_0 & 0b100000000) != 0 /* is-state_0 doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) */ && arguments2Value_ instanceof Byte) {
                        byte arguments2Value__ = (byte) arguments2Value_;
                        if (arguments3Value_ instanceof Byte) {
                            byte arguments3Value__ = (byte) arguments3Value_;
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                                return doInt32ArrayByteObjIdx(arguments0Value__, arguments1Value_, arguments2Value__, arguments3Value__, this.int32ArrayByteObjIdx_toIndexNode_);
                            }
                        }
                    }
                    if ((state_0 & 0b1000000000) != 0 /* is-state_0 doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if (arguments3Value_ instanceof Integer) {
                            int arguments3Value__ = (int) arguments3Value_;
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                                return doInt32ArrayIntObjIdx(arguments0Value__, arguments1Value_, arguments2Value__, arguments3Value__, this.int32ArrayIntObjIdx_toIndexNode_);
                            }
                        }
                    }
                    if ((state_0 & 0b10000000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */) {
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                            return doInt32ArrayObjObjIdx(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, this.int32ArrayObjObjIdx_toIndexNode_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b11100000010000) == 0 /* only-active doInt8ArrayByte(DynamicObject, int, int, int) && doUint8ArrayByte(DynamicObject, int, int, int) && doInt16ArrayByte(DynamicObject, int, int, int) && doUint16ArrayByte(DynamicObject, int, int, int) && doInt32ArrayByte(DynamicObject, int, byte, byte) && doInt32ArrayInt(DynamicObject, int, int, int) && doInt32ArrayObj(DynamicObject, int, Object, Object) && doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) && doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) && doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */ && (state_0 != 0  /* is-not doInt8ArrayByte(DynamicObject, int, int, int) && doUint8ArrayByte(DynamicObject, int, int, int) && doInt16ArrayByte(DynamicObject, int, int, int) && doUint16ArrayByte(DynamicObject, int, int, int) && doUint32ArrayByte(DynamicObject, int, Object, Object) && doInt32ArrayByte(DynamicObject, int, byte, byte) && doInt32ArrayInt(DynamicObject, int, int, int) && doInt32ArrayObj(DynamicObject, int, Object, Object) && doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) && doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) && doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) && doBigUint64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, Object, JSToIndexNode, BranchProfile) */)) {
                    executeInt(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value, Object arguments3Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        if (arguments2Value instanceof Integer) {
                            int arguments2Value_ = (int) arguments2Value;
                            if (arguments3Value instanceof Integer) {
                                int arguments3Value_ = (int) arguments3Value;
                                if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt8ArrayByte(DynamicObject, int, int, int) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doInt8ArrayByte(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
                                }
                                if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUint8ArrayByte(DynamicObject, int, int, int) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doUint8ArrayByte(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
                                }
                                if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doInt16ArrayByte(DynamicObject, int, int, int) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doInt16ArrayByte(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
                                }
                                if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doUint16ArrayByte(DynamicObject, int, int, int) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doUint16ArrayByte(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
                                }
                            }
                        }
                        if ((AtomicsOperationNode.isUint32SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doUint32ArrayByte(DynamicObject, int, Object, Object) */;
                            lock.unlock();
                            hasLock = false;
                            return doUint32ArrayByte(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value);
                        }
                        if (arguments2Value instanceof Byte) {
                            byte arguments2Value_ = (byte) arguments2Value;
                            if (arguments3Value instanceof Byte) {
                                byte arguments3Value_ = (byte) arguments3Value;
                                if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doInt32ArrayByte(DynamicObject, int, byte, byte) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doInt32ArrayByte(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
                                }
                            }
                        }
                        if (arguments2Value instanceof Integer) {
                            int arguments2Value_ = (int) arguments2Value;
                            if (arguments3Value instanceof Integer) {
                                int arguments3Value_ = (int) arguments3Value;
                                if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doInt32ArrayInt(DynamicObject, int, int, int) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doInt32ArrayInt(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
                                }
                            }
                        }
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doInt32ArrayObj(DynamicObject, int, Object, Object) */;
                            lock.unlock();
                            hasLock = false;
                            return doInt32ArrayObj(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value);
                        }
                    }
                    if (arguments2Value instanceof Byte) {
                        byte arguments2Value_ = (byte) arguments2Value;
                        if (arguments3Value instanceof Byte) {
                            byte arguments3Value_ = (byte) arguments3Value;
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_))) {
                                this.int32ArrayByteObjIdx_toIndexNode_ = super.insert((JSToIndexNode.create()));
                                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) */;
                                lock.unlock();
                                hasLock = false;
                                return doInt32ArrayByteObjIdx(arguments0Value_, arguments1Value, arguments2Value_, arguments3Value_, this.int32ArrayByteObjIdx_toIndexNode_);
                            }
                        }
                    }
                    if (arguments2Value instanceof Integer) {
                        int arguments2Value_ = (int) arguments2Value;
                        if (arguments3Value instanceof Integer) {
                            int arguments3Value_ = (int) arguments3Value;
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_))) {
                                this.int32ArrayIntObjIdx_toIndexNode_ = super.insert((JSToIndexNode.create()));
                                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) */;
                                lock.unlock();
                                hasLock = false;
                                return doInt32ArrayIntObjIdx(arguments0Value_, arguments1Value, arguments2Value_, arguments3Value_, this.int32ArrayIntObjIdx_toIndexNode_);
                            }
                        }
                    }
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_))) {
                        this.int32ArrayObjObjIdx_toIndexNode_ = super.insert((JSToIndexNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doInt32ArrayObjObjIdx(arguments0Value_, arguments1Value, arguments2Value, arguments3Value, this.int32ArrayObjObjIdx_toIndexNode_);
                    }
                    if ((AtomicsOperationNode.isBigInt64SharedBufferView(arguments0Value_))) {
                        this.bigInt64ArrayObjObjIdx_toIndexNode_ = super.insert((JSToIndexNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigInt64ArrayObjObjIdx(arguments0Value_, arguments1Value, arguments2Value, arguments3Value, this.bigInt64ArrayObjObjIdx_toIndexNode_);
                    }
                    if ((AtomicsOperationNode.isBigUint64SharedBufferView(arguments0Value_))) {
                        this.bigUint64ArrayObjObjIdx_toIndexNode_ = super.insert((JSToIndexNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doBigUint64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigUint64ArrayObjObjIdx(arguments0Value_, arguments1Value, arguments2Value, arguments3Value, this.bigUint64ArrayObjObjIdx_toIndexNode_);
                    }
                }
                this.generic_toIndexNode_ = super.insert((JSToIndexNode.create()));
                this.generic_notSharedArrayBuffer_ = (BranchProfile.create());
                this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 doGeneric(Object, Object, Object, Object, JSToIndexNode, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(arguments0Value, arguments1Value, arguments2Value, arguments3Value, this.generic_toIndexNode_, this.generic_notSharedArrayBuffer_);
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
            Object[] data = new Object[15];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doInt8ArrayByte";
            if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayByte(DynamicObject, int, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doUint8ArrayByte";
            if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayByte(DynamicObject, int, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doInt16ArrayByte";
            if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayByte(DynamicObject, int, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doUint16ArrayByte";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayByte(DynamicObject, int, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "doUint32ArrayByte";
            if ((state_0 & 0b10000) != 0 /* is-state_0 doUint32ArrayByte(DynamicObject, int, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayByte";
            if ((state_0 & 0b100000) != 0 /* is-state_0 doInt32ArrayByte(DynamicObject, int, byte, byte) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayInt";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayInt(DynamicObject, int, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayObj";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayByteObjIdx";
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doInt32ArrayByteObjIdx(DynamicObject, Object, byte, byte, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.int32ArrayByteObjIdx_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayIntObjIdx";
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doInt32ArrayIntObjIdx(DynamicObject, Object, int, int, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.int32ArrayIntObjIdx_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[10] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayObjObjIdx";
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.int32ArrayObjObjIdx_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[11] = s;
            s = new Object[3];
            s[0] = "doBigInt64ArrayObjObjIdx";
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.bigInt64ArrayObjObjIdx_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[12] = s;
            s = new Object[3];
            s[0] = "doBigUint64ArrayObjObjIdx";
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doBigUint64ArrayObjObjIdx(DynamicObject, Object, Object, Object, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.bigUint64ArrayObjObjIdx_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[13] = s;
            s = new Object[3];
            s[0] = "doGeneric";
            if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doGeneric(Object, Object, Object, Object, JSToIndexNode, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.generic_toIndexNode_, this.generic_notSharedArrayBuffer_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[14] = s;
            return Provider.create(data);
        }

        public static AtomicsCompareExchangeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new AtomicsCompareExchangeNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(AtomicsLoadNode.class)
    public static final class AtomicsLoadNodeGen extends AtomicsLoadNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToIndexNode int32ArrayObjObjIdx_toIndexNode_;
        @Child private JSToIndexNode generic_toIndexNode_;

        private AtomicsLoadNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object executeWithBufferAndIndex(VirtualFrame frameValue, Object arguments0Value, Object arguments1Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b111111111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) || doUint8ArrayObj(DynamicObject, int) || doInt16ArrayObj(DynamicObject, int) || doUint16ArrayObj(DynamicObject, int) || doInt32ArrayObj(DynamicObject, int) || doUint32ArrayObj(DynamicObject, int) || doBigInt64ArrayObj(DynamicObject, int) || doBigUint64ArrayObj(DynamicObject, int) || doInt32ArrayObjObjIdx(DynamicObject, Object, JSToIndexNode) */ && JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((state_0 & 0b11111111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) || doUint8ArrayObj(DynamicObject, int) || doInt16ArrayObj(DynamicObject, int) || doUint16ArrayObj(DynamicObject, int) || doInt32ArrayObj(DynamicObject, int) || doUint32ArrayObj(DynamicObject, int) || doBigInt64ArrayObj(DynamicObject, int) || doBigUint64ArrayObj(DynamicObject, int) */ && arguments1Value instanceof Integer) {
                    int arguments1Value_ = (int) arguments1Value;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            return doInt8ArrayObj(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            return doUint8ArrayObj(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            return doInt16ArrayObj(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            return doUint16ArrayObj(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            return doInt32ArrayObj(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 doUint32ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isUint32SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            return doUint32ArrayObj(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigInt64ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isBigInt64SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            return doBigInt64ArrayObj(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigUint64ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isBigUint64SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            return doBigUint64ArrayObj(arguments0Value_, arguments1Value_);
                        }
                    }
                }
                if ((state_0 & 0b100000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, JSToIndexNode) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_))) {
                        return doInt32ArrayObjObjIdx(arguments0Value_, arguments1Value, this.int32ArrayObjObjIdx_toIndexNode_);
                    }
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGeneric(Object, Object, JSToIndexNode) */) {
                return doGeneric(arguments0Value, arguments1Value, this.generic_toIndexNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value, arguments1Value);
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1100000000) == 0 /* only-active doInt8ArrayObj(DynamicObject, int) && doUint8ArrayObj(DynamicObject, int) && doInt16ArrayObj(DynamicObject, int) && doUint16ArrayObj(DynamicObject, int) && doInt32ArrayObj(DynamicObject, int) && doUint32ArrayObj(DynamicObject, int) && doBigInt64ArrayObj(DynamicObject, int) && doBigUint64ArrayObj(DynamicObject, int) */ && (state_0 != 0  /* is-not doInt8ArrayObj(DynamicObject, int) && doUint8ArrayObj(DynamicObject, int) && doInt16ArrayObj(DynamicObject, int) && doUint16ArrayObj(DynamicObject, int) && doInt32ArrayObj(DynamicObject, int) && doUint32ArrayObj(DynamicObject, int) && doBigInt64ArrayObj(DynamicObject, int) && doBigUint64ArrayObj(DynamicObject, int) && doInt32ArrayObjObjIdx(DynamicObject, Object, JSToIndexNode) && doGeneric(Object, Object, JSToIndexNode) */)) {
                return execute_int0(state_0, frameValue);
            } else {
                return execute_generic1(state_0, frameValue);
            }
        }

        private Object execute_int0(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, ex.getResult());
            }
            if ((state_0 & 0b11111111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) || doUint8ArrayObj(DynamicObject, int) || doInt16ArrayObj(DynamicObject, int) || doUint16ArrayObj(DynamicObject, int) || doInt32ArrayObj(DynamicObject, int) || doUint32ArrayObj(DynamicObject, int) || doBigInt64ArrayObj(DynamicObject, int) || doBigUint64ArrayObj(DynamicObject, int) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt8ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint8ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt16ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint16ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt32ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 doUint32ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isUint32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint32ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigInt64ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isBigInt64SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doBigInt64ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigUint64ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isBigUint64SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doBigUint64ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private Object execute_generic1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b111111111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) || doUint8ArrayObj(DynamicObject, int) || doInt16ArrayObj(DynamicObject, int) || doUint16ArrayObj(DynamicObject, int) || doInt32ArrayObj(DynamicObject, int) || doUint32ArrayObj(DynamicObject, int) || doBigInt64ArrayObj(DynamicObject, int) || doBigUint64ArrayObj(DynamicObject, int) || doInt32ArrayObjObjIdx(DynamicObject, Object, JSToIndexNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b11111111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) || doUint8ArrayObj(DynamicObject, int) || doInt16ArrayObj(DynamicObject, int) || doUint16ArrayObj(DynamicObject, int) || doInt32ArrayObj(DynamicObject, int) || doUint32ArrayObj(DynamicObject, int) || doBigInt64ArrayObj(DynamicObject, int) || doBigUint64ArrayObj(DynamicObject, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt8ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doUint8ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt16ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doUint16ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt32ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 doUint32ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isUint32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doUint32ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigInt64ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isBigInt64SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doBigInt64ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigUint64ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isBigUint64SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doBigUint64ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                }
                if ((state_0 & 0b100000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, JSToIndexNode) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                        return doInt32ArrayObjObjIdx(arguments0Value__, arguments1Value_, this.int32ArrayObjObjIdx_toIndexNode_);
                    }
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGeneric(Object, Object, JSToIndexNode) */) {
                return doGeneric(arguments0Value_, arguments1Value_, this.generic_toIndexNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGeneric(Object, Object, JSToIndexNode) */) {
                return JSTypesGen.expectInteger(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b100000000) == 0 /* only-active doInt8ArrayObj(DynamicObject, int) && doUint8ArrayObj(DynamicObject, int) && doInt16ArrayObj(DynamicObject, int) && doUint16ArrayObj(DynamicObject, int) && doInt32ArrayObj(DynamicObject, int) */ && ((state_0 & 0b100011111) != 0  /* is-not doInt8ArrayObj(DynamicObject, int) && doUint8ArrayObj(DynamicObject, int) && doInt16ArrayObj(DynamicObject, int) && doUint16ArrayObj(DynamicObject, int) && doInt32ArrayObj(DynamicObject, int) && doInt32ArrayObjObjIdx(DynamicObject, Object, JSToIndexNode) */)) {
                return executeInt_int2(state_0, frameValue, arguments0Value_);
            } else {
                return executeInt_generic3(state_0, frameValue, arguments0Value_);
            }
        }

        private int executeInt_int2(int state_0, VirtualFrame frameValue, Object arguments0Value_) throws UnexpectedResultException {
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, ex.getResult()));
            }
            if ((state_0 & 0b11111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) || doUint8ArrayObj(DynamicObject, int) || doInt16ArrayObj(DynamicObject, int) || doUint16ArrayObj(DynamicObject, int) || doInt32ArrayObj(DynamicObject, int) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt8ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint8ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt16ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint16ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt32ArrayObj(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        private int executeInt_generic3(int state_0, VirtualFrame frameValue, Object arguments0Value_) throws UnexpectedResultException {
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b100011111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) || doUint8ArrayObj(DynamicObject, int) || doInt16ArrayObj(DynamicObject, int) || doUint16ArrayObj(DynamicObject, int) || doInt32ArrayObj(DynamicObject, int) || doInt32ArrayObjObjIdx(DynamicObject, Object, JSToIndexNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b11111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) || doUint8ArrayObj(DynamicObject, int) || doInt16ArrayObj(DynamicObject, int) || doUint16ArrayObj(DynamicObject, int) || doInt32ArrayObj(DynamicObject, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt8ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doUint8ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt16ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doUint16ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int) */) {
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt32ArrayObj(arguments0Value__, arguments1Value__);
                        }
                    }
                }
                if ((state_0 & 0b100000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, JSToIndexNode) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                        return doInt32ArrayObjObjIdx(arguments0Value__, arguments1Value_, this.int32ArrayObjObjIdx_toIndexNode_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b1011100000) == 0 /* only-active doInt8ArrayObj(DynamicObject, int) && doUint8ArrayObj(DynamicObject, int) && doInt16ArrayObj(DynamicObject, int) && doUint16ArrayObj(DynamicObject, int) && doInt32ArrayObj(DynamicObject, int) && doInt32ArrayObjObjIdx(DynamicObject, Object, JSToIndexNode) */ && (state_0 != 0  /* is-not doInt8ArrayObj(DynamicObject, int) && doUint8ArrayObj(DynamicObject, int) && doInt16ArrayObj(DynamicObject, int) && doUint16ArrayObj(DynamicObject, int) && doInt32ArrayObj(DynamicObject, int) && doUint32ArrayObj(DynamicObject, int) && doBigInt64ArrayObj(DynamicObject, int) && doBigUint64ArrayObj(DynamicObject, int) && doInt32ArrayObjObjIdx(DynamicObject, Object, JSToIndexNode) && doGeneric(Object, Object, JSToIndexNode) */)) {
                    executeInt(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt8ArrayObj(DynamicObject, int) */;
                            lock.unlock();
                            hasLock = false;
                            return doInt8ArrayObj(arguments0Value_, arguments1Value_);
                        }
                        if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUint8ArrayObj(DynamicObject, int) */;
                            lock.unlock();
                            hasLock = false;
                            return doUint8ArrayObj(arguments0Value_, arguments1Value_);
                        }
                        if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doInt16ArrayObj(DynamicObject, int) */;
                            lock.unlock();
                            hasLock = false;
                            return doInt16ArrayObj(arguments0Value_, arguments1Value_);
                        }
                        if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doUint16ArrayObj(DynamicObject, int) */;
                            lock.unlock();
                            hasLock = false;
                            return doUint16ArrayObj(arguments0Value_, arguments1Value_);
                        }
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doInt32ArrayObj(DynamicObject, int) */;
                            lock.unlock();
                            hasLock = false;
                            return doInt32ArrayObj(arguments0Value_, arguments1Value_);
                        }
                        if ((AtomicsOperationNode.isUint32SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doUint32ArrayObj(DynamicObject, int) */;
                            lock.unlock();
                            hasLock = false;
                            return doUint32ArrayObj(arguments0Value_, arguments1Value_);
                        }
                        if ((AtomicsOperationNode.isBigInt64SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doBigInt64ArrayObj(DynamicObject, int) */;
                            lock.unlock();
                            hasLock = false;
                            return doBigInt64ArrayObj(arguments0Value_, arguments1Value_);
                        }
                        if ((AtomicsOperationNode.isBigUint64SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doBigUint64ArrayObj(DynamicObject, int) */;
                            lock.unlock();
                            hasLock = false;
                            return doBigUint64ArrayObj(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_))) {
                        this.int32ArrayObjObjIdx_toIndexNode_ = super.insert((JSToIndexNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, JSToIndexNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doInt32ArrayObjObjIdx(arguments0Value_, arguments1Value, this.int32ArrayObjObjIdx_toIndexNode_);
                    }
                }
                this.generic_toIndexNode_ = super.insert((JSToIndexNode.create()));
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doGeneric(Object, Object, JSToIndexNode) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(arguments0Value, arguments1Value, this.generic_toIndexNode_);
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
            Object[] data = new Object[11];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doInt8ArrayObj";
            if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doUint8ArrayObj";
            if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayObj(DynamicObject, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doInt16ArrayObj";
            if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doUint16ArrayObj";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayObj(DynamicObject, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayObj";
            if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "doUint32ArrayObj";
            if ((state_0 & 0b100000) != 0 /* is-state_0 doUint32ArrayObj(DynamicObject, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "doBigInt64ArrayObj";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigInt64ArrayObj(DynamicObject, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "doBigUint64ArrayObj";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigUint64ArrayObj(DynamicObject, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayObjObjIdx";
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.int32ArrayObjObjIdx_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            s = new Object[3];
            s[0] = "doGeneric";
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doGeneric(Object, Object, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.generic_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[10] = s;
            return Provider.create(data);
        }

        public static AtomicsLoadNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new AtomicsLoadNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(AtomicsStoreNode.class)
    public static final class AtomicsStoreNodeGen extends AtomicsStoreNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToIndexNode int32ArrayObjObjIdx_toIndexNode_;
        @Child private JSToIndexNode bigInt64ArrayObjObjIdx_toIndexNode_;
        @Child private JSToIndexNode generic_toIndexNode_;

        private AtomicsStoreNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b111101010) == 0 /* only-active doIntArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, int) */ && ((state_0 & 0b111111111) != 0  /* is-not doIntArrayObj(DynamicObject, int, int) && doIntArrayObj(DynamicObject, int, double) && doInt16ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, double) && doInt32ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, double) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, JSToIndexNode) */)) {
                return execute_int_int0(state_0, frameValue);
            } else if ((state_0 & 0b111010101) == 0 /* only-active doIntArrayObj(DynamicObject, int, double) && doInt16ArrayObj(DynamicObject, int, double) && doInt32ArrayObj(DynamicObject, int, double) */ && ((state_0 & 0b111111111) != 0  /* is-not doIntArrayObj(DynamicObject, int, int) && doIntArrayObj(DynamicObject, int, double) && doInt16ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, double) && doInt32ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, double) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, JSToIndexNode) */)) {
                return execute_int_double1(state_0, frameValue);
            } else if ((state_0 & 0b110111111) == 0 /* only-active doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */ && ((state_0 & 0b111111111) != 0  /* is-not doIntArrayObj(DynamicObject, int, int) && doIntArrayObj(DynamicObject, int, double) && doInt16ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, double) && doInt32ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, double) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, JSToIndexNode) */)) {
                return execute_int2(state_0, frameValue);
            } else {
                return execute_generic3(state_0, frameValue);
            }
        }

        private Object execute_int_int0(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value);
            }
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            if ((state_0 & 0b10101) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, int) || doInt16ArrayObj(DynamicObject, int, int) || doInt32ArrayObj(DynamicObject, int, int) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doIntArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt16ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt32ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_int_double1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value);
            }
            int arguments2Value_int = 0;
            long arguments2Value_long = 0L;
            double arguments2Value_;
            try {
                if ((state_0 & 0b1110000000000) == 0 /* only-active 2:double */ && ((state_0 & 0b111111111) != 0  /* is-not doIntArrayObj(DynamicObject, int, int) && doIntArrayObj(DynamicObject, int, double) && doInt16ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, double) && doInt32ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, double) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, JSToIndexNode) */)) {
                    arguments2Value_long = this.arguments2_.executeLong(frameValue);
                    arguments2Value_ = JSTypes.longToDouble(arguments2Value_long);
                } else if ((state_0 & 0b1101000000000) == 0 /* only-active 2:double */ && ((state_0 & 0b111111111) != 0  /* is-not doIntArrayObj(DynamicObject, int, int) && doIntArrayObj(DynamicObject, int, double) && doInt16ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, double) && doInt32ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, double) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, JSToIndexNode) */)) {
                    arguments2Value_int = this.arguments2_.executeInt(frameValue);
                    arguments2Value_ = JSTypes.intToDouble(arguments2Value_int);
                } else if ((state_0 & 0b1011000000000) == 0 /* only-active 2:double */ && ((state_0 & 0b111111111) != 0  /* is-not doIntArrayObj(DynamicObject, int, int) && doIntArrayObj(DynamicObject, int, double) && doInt16ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, double) && doInt32ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, double) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, JSToIndexNode) */)) {
                    arguments2Value_ = this.arguments2_.executeDouble(frameValue);
                } else {
                    Object arguments2Value__ = this.arguments2_.execute(frameValue);
                    arguments2Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 2:double */, arguments2Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            if ((state_0 & 0b101010) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, double) || doInt16ArrayObj(DynamicObject, int, double) || doInt32ArrayObj(DynamicObject, int, double) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b10) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, double) */) {
                    if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doIntArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int, double) */) {
                    if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt16ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, double) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt32ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, ((state_0 & 0b1110000000000) == 0 /* only-active 2:double */ && ((state_0 & 0b111111111) != 0  /* is-not doIntArrayObj(DynamicObject, int, int) && doIntArrayObj(DynamicObject, int, double) && doInt16ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, double) && doInt32ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, double) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, JSToIndexNode) */) ? (Object) arguments2Value_long : ((state_0 & 0b1101000000000) == 0 /* only-active 2:double */ && ((state_0 & 0b111111111) != 0  /* is-not doIntArrayObj(DynamicObject, int, int) && doIntArrayObj(DynamicObject, int, double) && doInt16ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, double) && doInt32ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, double) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, JSToIndexNode) */) ? (Object) arguments2Value_int : (Object) arguments2Value_)));
        }

        private Object execute_int2(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            assert (state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                    return doInt32ArrayObjObjIdx(arguments0Value__, arguments1Value_, arguments2Value_, this.int32ArrayObjObjIdx_toIndexNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic3(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state_0 & 0b11111111) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, int) || doIntArrayObj(DynamicObject, int, double) || doInt16ArrayObj(DynamicObject, int, int) || doInt16ArrayObj(DynamicObject, int, double) || doInt32ArrayObj(DynamicObject, int, int) || doInt32ArrayObj(DynamicObject, int, double) || doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) || doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b111111) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, int) || doIntArrayObj(DynamicObject, int, double) || doInt16ArrayObj(DynamicObject, int, int) || doInt16ArrayObj(DynamicObject, int, double) || doInt32ArrayObj(DynamicObject, int, int) || doInt32ArrayObj(DynamicObject, int, double) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doIntArrayObj(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 2:double */, arguments2Value_)) {
                        double arguments2Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 2:double */, arguments2Value_);
                        if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doIntArrayObj(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt16ArrayObj(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 2:double */, arguments2Value_)) {
                        double arguments2Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 2:double */, arguments2Value_);
                        if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt16ArrayObj(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt32ArrayObj(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 2:double */, arguments2Value_)) {
                        double arguments2Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000000) >>> 9 /* extract-implicit-state_0 2:double */, arguments2Value_);
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt32ArrayObj(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                }
                if ((state_0 & 0b11000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) || doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) */) {
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                            return doInt32ArrayObjObjIdx(arguments0Value__, arguments1Value_, arguments2Value__, this.int32ArrayObjObjIdx_toIndexNode_);
                        }
                    }
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) */) {
                        if ((AtomicsOperationNode.isBigInt64SharedBufferView(arguments0Value__) || AtomicsOperationNode.isBigUint64SharedBufferView(arguments0Value__))) {
                            return doBigInt64ArrayObjObjIdx(arguments0Value__, arguments1Value_, arguments2Value_, this.bigInt64ArrayObjObjIdx_toIndexNode_);
                        }
                    }
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doGeneric(Object, Object, Object, JSToIndexNode) */) {
                return doGeneric(arguments0Value_, arguments1Value_, arguments2Value_, this.generic_toIndexNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b111101110) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, double) || doInt16ArrayObj(DynamicObject, int, int) || doInt16ArrayObj(DynamicObject, int, double) || doInt32ArrayObj(DynamicObject, int, double) || doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) || doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) || doGeneric(Object, Object, Object, JSToIndexNode) */) {
                return JSTypesGen.expectInteger(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value));
            }
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult()));
            }
            if ((state_0 & 0b10001) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, int) || doInt32ArrayObj(DynamicObject, int, int) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doIntArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__) || AtomicsOperationNode.isUint32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt32ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b111101110) == 0 /* only-active doIntArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, int) */ && ((state_0 & 0b111111111) != 0  /* is-not doIntArrayObj(DynamicObject, int, int) && doIntArrayObj(DynamicObject, int, double) && doInt16ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, double) && doInt32ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, double) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, JSToIndexNode) */)) {
                    executeInt(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        if (arguments2Value instanceof Integer) {
                            int arguments2Value_ = (int) arguments2Value;
                            if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value_) || AtomicsOperationNode.isUint8SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doIntArrayObj(DynamicObject, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return doIntArrayObj(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                        }
                        {
                            int doubleCast2;
                            if ((doubleCast2 = JSTypesGen.specializeImplicitDouble(arguments2Value)) != 0) {
                                double arguments2Value_ = JSTypesGen.asImplicitDouble(doubleCast2, arguments2Value);
                                if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value_) || AtomicsOperationNode.isUint8SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                    state_0 = (state_0 | (doubleCast2 << 9) /* set-implicit-state_0 2:double */);
                                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doIntArrayObj(DynamicObject, int, double) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doIntArrayObj(arguments0Value_, arguments1Value_, arguments2Value_);
                                }
                            }
                        }
                        if (arguments2Value instanceof Integer) {
                            int arguments2Value_ = (int) arguments2Value;
                            if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value_) || AtomicsOperationNode.isUint16SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doInt16ArrayObj(DynamicObject, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return doInt16ArrayObj(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                        }
                        {
                            int doubleCast2;
                            if ((doubleCast2 = JSTypesGen.specializeImplicitDouble(arguments2Value)) != 0) {
                                double arguments2Value_ = JSTypesGen.asImplicitDouble(doubleCast2, arguments2Value);
                                if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value_) || AtomicsOperationNode.isUint16SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                    state_0 = (state_0 | (doubleCast2 << 9) /* set-implicit-state_0 2:double */);
                                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doInt16ArrayObj(DynamicObject, int, double) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doInt16ArrayObj(arguments0Value_, arguments1Value_, arguments2Value_);
                                }
                            }
                        }
                        if (arguments2Value instanceof Integer) {
                            int arguments2Value_ = (int) arguments2Value;
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_) || AtomicsOperationNode.isUint32SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doInt32ArrayObj(DynamicObject, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return doInt32ArrayObj(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                        }
                        {
                            int doubleCast2;
                            if ((doubleCast2 = JSTypesGen.specializeImplicitDouble(arguments2Value)) != 0) {
                                double arguments2Value_ = JSTypesGen.asImplicitDouble(doubleCast2, arguments2Value);
                                if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_) || AtomicsOperationNode.isUint32SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                    state_0 = (state_0 | (doubleCast2 << 9) /* set-implicit-state_0 2:double */);
                                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doInt32ArrayObj(DynamicObject, int, double) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doInt32ArrayObj(arguments0Value_, arguments1Value_, arguments2Value_);
                                }
                            }
                        }
                    }
                    if (arguments2Value instanceof Integer) {
                        int arguments2Value_ = (int) arguments2Value;
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_))) {
                            this.int32ArrayObjObjIdx_toIndexNode_ = super.insert((JSToIndexNode.create()));
                            this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */;
                            lock.unlock();
                            hasLock = false;
                            return doInt32ArrayObjObjIdx(arguments0Value_, arguments1Value, arguments2Value_, this.int32ArrayObjObjIdx_toIndexNode_);
                        }
                    }
                    if ((AtomicsOperationNode.isBigInt64SharedBufferView(arguments0Value_) || AtomicsOperationNode.isBigUint64SharedBufferView(arguments0Value_))) {
                        this.bigInt64ArrayObjObjIdx_toIndexNode_ = super.insert((JSToIndexNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigInt64ArrayObjObjIdx(arguments0Value_, arguments1Value, arguments2Value, this.bigInt64ArrayObjObjIdx_toIndexNode_);
                    }
                }
                this.generic_toIndexNode_ = super.insert((JSToIndexNode.create()));
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doGeneric(Object, Object, Object, JSToIndexNode) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(arguments0Value, arguments1Value, arguments2Value, this.generic_toIndexNode_);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b111111111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b111111111) & ((state_0 & 0b111111111) - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[10];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doIntArrayObj";
            if ((state_0 & 0b1) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doIntArrayObj";
            if ((state_0 & 0b10) != 0 /* is-state_0 doIntArrayObj(DynamicObject, int, double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doInt16ArrayObj";
            if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doInt16ArrayObj";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int, double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayObj";
            if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayObj";
            if ((state_0 & 0b100000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayObjObjIdx";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.int32ArrayObjObjIdx_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "doBigInt64ArrayObjObjIdx";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.bigInt64ArrayObjObjIdx_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "doGeneric";
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doGeneric(Object, Object, Object, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.generic_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            return Provider.create(data);
        }

        public static AtomicsStoreNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new AtomicsStoreNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(AtomicsComputeNode.class)
    public static final class AtomicsComputeNodeGen extends AtomicsComputeNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToIndexNode int32ArrayObjObjIdx_toIndexNode_;
        @Child private JSToIndexNode bigInt64ArrayObjObjIdx_toIndexNode_;
        @Child private JSToIndexNode generic_toIndexNode_;
        @CompilationFinal private BranchProfile generic_notSharedArrayBuffer_;

        private AtomicsComputeNodeGen(JSContext context, JSBuiltin builtin, AtomicIntBinaryOperator intOperator, AtomicBinaryOperator<BigInt> bigIntOperator, JavaScriptNode[] arguments) {
            super(context, builtin, intOperator, bigIntOperator);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b111000000) == 0 /* only-active doInt8ArrayObj(DynamicObject, int, int) && doUint8ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, int) && doUint16ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, int) && doUint32ArrayObj(DynamicObject, int, int) */ && (state_0 != 0  /* is-not doInt8ArrayObj(DynamicObject, int, int) && doUint8ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, int) && doUint16ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, int) && doUint32ArrayObj(DynamicObject, int, int) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, JSToIndexNode, BranchProfile) */)) {
                return execute_int_int0(state_0, frameValue);
            } else if ((state_0 & 0b110111111) == 0 /* only-active doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */ && (state_0 != 0  /* is-not doInt8ArrayObj(DynamicObject, int, int) && doUint8ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, int) && doUint16ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, int) && doUint32ArrayObj(DynamicObject, int, int) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, JSToIndexNode, BranchProfile) */)) {
                return execute_int1(state_0, frameValue);
            } else {
                return execute_generic2(state_0, frameValue);
            }
        }

        private Object execute_int_int0(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value);
            }
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            if ((state_0 & 0b111111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int, int) || doUint8ArrayObj(DynamicObject, int, int) || doInt16ArrayObj(DynamicObject, int, int) || doUint16ArrayObj(DynamicObject, int, int) || doInt32ArrayObj(DynamicObject, int, int) || doUint32ArrayObj(DynamicObject, int, int) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt8ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint8ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt16ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint16ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt32ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 doUint32ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isUint32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint32ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_int1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            assert (state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                    return doInt32ArrayObjObjIdx(arguments0Value__, arguments1Value_, arguments2Value_, this.int32ArrayObjObjIdx_toIndexNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic2(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state_0 & 0b11111111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int, int) || doUint8ArrayObj(DynamicObject, int, int) || doInt16ArrayObj(DynamicObject, int, int) || doUint16ArrayObj(DynamicObject, int, int) || doInt32ArrayObj(DynamicObject, int, int) || doUint32ArrayObj(DynamicObject, int, int) || doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) || doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1111111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int, int) || doUint8ArrayObj(DynamicObject, int, int) || doInt16ArrayObj(DynamicObject, int, int) || doUint16ArrayObj(DynamicObject, int, int) || doInt32ArrayObj(DynamicObject, int, int) || doUint32ArrayObj(DynamicObject, int, int) || doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */ && arguments2Value_ instanceof Integer) {
                    int arguments2Value__ = (int) arguments2Value_;
                    if ((state_0 & 0b111111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int, int) || doUint8ArrayObj(DynamicObject, int, int) || doInt16ArrayObj(DynamicObject, int, int) || doUint16ArrayObj(DynamicObject, int, int) || doInt32ArrayObj(DynamicObject, int, int) || doUint32ArrayObj(DynamicObject, int, int) */ && arguments1Value_ instanceof Integer) {
                        int arguments1Value__ = (int) arguments1Value_;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int, int) */) {
                            if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                return doInt8ArrayObj(arguments0Value__, arguments1Value__, arguments2Value__);
                            }
                        }
                        if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayObj(DynamicObject, int, int) */) {
                            if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                return doUint8ArrayObj(arguments0Value__, arguments1Value__, arguments2Value__);
                            }
                        }
                        if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int, int) */) {
                            if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                return doInt16ArrayObj(arguments0Value__, arguments1Value__, arguments2Value__);
                            }
                        }
                        if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayObj(DynamicObject, int, int) */) {
                            if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                return doUint16ArrayObj(arguments0Value__, arguments1Value__, arguments2Value__);
                            }
                        }
                        if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, int) */) {
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                return doInt32ArrayObj(arguments0Value__, arguments1Value__, arguments2Value__);
                            }
                        }
                        if ((state_0 & 0b100000) != 0 /* is-state_0 doUint32ArrayObj(DynamicObject, int, int) */) {
                            if ((AtomicsOperationNode.isUint32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                                return doUint32ArrayObj(arguments0Value__, arguments1Value__, arguments2Value__);
                            }
                        }
                    }
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */) {
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                            return doInt32ArrayObjObjIdx(arguments0Value__, arguments1Value_, arguments2Value__, this.int32ArrayObjObjIdx_toIndexNode_);
                        }
                    }
                }
                if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) */) {
                    if ((AtomicsOperationNode.isBigInt64SharedBufferView(arguments0Value__) || AtomicsOperationNode.isBigUint64SharedBufferView(arguments0Value__))) {
                        return doBigInt64ArrayObjObjIdx(arguments0Value__, arguments1Value_, arguments2Value_, this.bigInt64ArrayObjObjIdx_toIndexNode_);
                    }
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doGeneric(Object, Object, Object, JSToIndexNode, BranchProfile) */) {
                return doGeneric(arguments0Value_, arguments1Value_, arguments2Value_, this.generic_toIndexNode_, this.generic_notSharedArrayBuffer_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doGeneric(Object, Object, Object, JSToIndexNode, BranchProfile) */) {
                return JSTypesGen.expectInteger(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1000000) == 0 /* only-active doInt8ArrayObj(DynamicObject, int, int) && doUint8ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, int) && doUint16ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, int) */ && ((state_0 & 0b1011111) != 0  /* is-not doInt8ArrayObj(DynamicObject, int, int) && doUint8ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, int) && doUint16ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, int) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */)) {
                return executeInt_int_int3(state_0, frameValue, arguments0Value_);
            } else if ((state_0 & 0b11111) == 0 /* only-active doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */ && ((state_0 & 0b1011111) != 0  /* is-not doInt8ArrayObj(DynamicObject, int, int) && doUint8ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, int) && doUint16ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, int) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */)) {
                return executeInt_int4(state_0, frameValue, arguments0Value_);
            } else {
                return executeInt_generic5(state_0, frameValue, arguments0Value_);
            }
        }

        private int executeInt_int_int3(int state_0, VirtualFrame frameValue, Object arguments0Value_) throws UnexpectedResultException {
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value));
            }
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult()));
            }
            if ((state_0 & 0b11111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int, int) || doUint8ArrayObj(DynamicObject, int, int) || doInt16ArrayObj(DynamicObject, int, int) || doUint16ArrayObj(DynamicObject, int, int) || doInt32ArrayObj(DynamicObject, int, int) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt8ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint8ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt16ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doUint16ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, int) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value_))) {
                        return doInt32ArrayObj(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_));
        }

        private int executeInt_int4(int state_0, VirtualFrame frameValue, Object arguments0Value_) throws UnexpectedResultException {
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult()));
            }
            assert (state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                    return doInt32ArrayObjObjIdx(arguments0Value__, arguments1Value_, arguments2Value_, this.int32ArrayObjObjIdx_toIndexNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_));
        }

        private int executeInt_generic5(int state_0, VirtualFrame frameValue, Object arguments0Value_) throws UnexpectedResultException {
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult()));
            }
            if ((state_0 & 0b1011111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int, int) || doUint8ArrayObj(DynamicObject, int, int) || doInt16ArrayObj(DynamicObject, int, int) || doUint16ArrayObj(DynamicObject, int, int) || doInt32ArrayObj(DynamicObject, int, int) || doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b11111) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int, int) || doUint8ArrayObj(DynamicObject, int, int) || doInt16ArrayObj(DynamicObject, int, int) || doUint16ArrayObj(DynamicObject, int, int) || doInt32ArrayObj(DynamicObject, int, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int, int) */) {
                        if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt8ArrayObj(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayObj(DynamicObject, int, int) */) {
                        if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doUint8ArrayObj(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int, int) */) {
                        if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt16ArrayObj(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayObj(DynamicObject, int, int) */) {
                        if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doUint16ArrayObj(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, int) */) {
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__)) && (AtomicsOperationNode.inboundFast(arguments0Value__, arguments1Value__))) {
                            return doInt32ArrayObj(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */) {
                    if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value__))) {
                        return doInt32ArrayObjObjIdx(arguments0Value__, arguments1Value_, arguments2Value_, this.int32ArrayObjObjIdx_toIndexNode_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b110100000) == 0 /* only-active doInt8ArrayObj(DynamicObject, int, int) && doUint8ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, int) && doUint16ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, int) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */ && (state_0 != 0  /* is-not doInt8ArrayObj(DynamicObject, int, int) && doUint8ArrayObj(DynamicObject, int, int) && doInt16ArrayObj(DynamicObject, int, int) && doUint16ArrayObj(DynamicObject, int, int) && doInt32ArrayObj(DynamicObject, int, int) && doUint32ArrayObj(DynamicObject, int, int) && doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) && doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) && doGeneric(Object, Object, Object, JSToIndexNode, BranchProfile) */)) {
                    executeInt(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments2Value instanceof Integer) {
                        int arguments2Value_ = (int) arguments2Value;
                        if (arguments1Value instanceof Integer) {
                            int arguments1Value_ = (int) arguments1Value;
                            if ((AtomicsOperationNode.isInt8SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInt8ArrayObj(DynamicObject, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return doInt8ArrayObj(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                            if ((AtomicsOperationNode.isUint8SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUint8ArrayObj(DynamicObject, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return doUint8ArrayObj(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                            if ((AtomicsOperationNode.isInt16SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doInt16ArrayObj(DynamicObject, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return doInt16ArrayObj(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                            if ((AtomicsOperationNode.isUint16SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doUint16ArrayObj(DynamicObject, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return doUint16ArrayObj(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                            if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doInt32ArrayObj(DynamicObject, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return doInt32ArrayObj(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                            if ((AtomicsOperationNode.isUint32SharedBufferView(arguments0Value_)) && (AtomicsOperationNode.inboundFast(arguments0Value_, arguments1Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doUint32ArrayObj(DynamicObject, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return doUint32ArrayObj(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                        }
                        if ((AtomicsOperationNode.isInt32SharedBufferView(arguments0Value_))) {
                            this.int32ArrayObjObjIdx_toIndexNode_ = super.insert((JSToIndexNode.create()));
                            this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */;
                            lock.unlock();
                            hasLock = false;
                            return doInt32ArrayObjObjIdx(arguments0Value_, arguments1Value, arguments2Value_, this.int32ArrayObjObjIdx_toIndexNode_);
                        }
                    }
                    if ((AtomicsOperationNode.isBigInt64SharedBufferView(arguments0Value_) || AtomicsOperationNode.isBigUint64SharedBufferView(arguments0Value_))) {
                        this.bigInt64ArrayObjObjIdx_toIndexNode_ = super.insert((JSToIndexNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigInt64ArrayObjObjIdx(arguments0Value_, arguments1Value, arguments2Value, this.bigInt64ArrayObjObjIdx_toIndexNode_);
                    }
                }
                this.generic_toIndexNode_ = super.insert((JSToIndexNode.create()));
                this.generic_notSharedArrayBuffer_ = (BranchProfile.create());
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doGeneric(Object, Object, Object, JSToIndexNode, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(arguments0Value, arguments1Value, arguments2Value, this.generic_toIndexNode_, this.generic_notSharedArrayBuffer_);
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
            Object[] data = new Object[10];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doInt8ArrayObj";
            if ((state_0 & 0b1) != 0 /* is-state_0 doInt8ArrayObj(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doUint8ArrayObj";
            if ((state_0 & 0b10) != 0 /* is-state_0 doUint8ArrayObj(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doInt16ArrayObj";
            if ((state_0 & 0b100) != 0 /* is-state_0 doInt16ArrayObj(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doUint16ArrayObj";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doUint16ArrayObj(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayObj";
            if ((state_0 & 0b10000) != 0 /* is-state_0 doInt32ArrayObj(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "doUint32ArrayObj";
            if ((state_0 & 0b100000) != 0 /* is-state_0 doUint32ArrayObj(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "doInt32ArrayObjObjIdx";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doInt32ArrayObjObjIdx(DynamicObject, Object, int, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.int32ArrayObjObjIdx_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "doBigInt64ArrayObjObjIdx";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt64ArrayObjObjIdx(DynamicObject, Object, Object, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.bigInt64ArrayObjObjIdx_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "doGeneric";
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doGeneric(Object, Object, Object, JSToIndexNode, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.generic_toIndexNode_, this.generic_notSharedArrayBuffer_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            return Provider.create(data);
        }

        public static AtomicsComputeNode create(JSContext context, JSBuiltin builtin, AtomicIntBinaryOperator intOperator, AtomicBinaryOperator<BigInt> bigIntOperator, JavaScriptNode[] arguments) {
            return new AtomicsComputeNodeGen(context, builtin, intOperator, bigIntOperator, arguments);
        }

    }
    @GeneratedBy(AtomicsNotifyNode.class)
    public static final class AtomicsNotifyNodeGen extends AtomicsNotifyNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private GenericData generic_cache;

        private AtomicsNotifyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 doGeneric(Object, Object, Object, JSToIndexNode, JSToInt32Node, BranchProfile) */) {
                GenericData s0_ = this.generic_cache;
                if (s0_ != null) {
                    return doGeneric(arguments0Value_, arguments1Value_, arguments2Value_, s0_.toIndexNode_, s0_.toInt32Node_, s0_.notSharedArrayBuffer_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                GenericData s0_ = super.insert(new GenericData());
                s0_.toIndexNode_ = s0_.insertAccessor((JSToIndexNode.create()));
                s0_.toInt32Node_ = s0_.insertAccessor((JSToInt32Node.create()));
                s0_.notSharedArrayBuffer_ = (BranchProfile.create());
                MemoryFence.storeStore();
                this.generic_cache = s0_;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doGeneric(Object, Object, Object, JSToIndexNode, JSToInt32Node, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(arguments0Value, arguments1Value, arguments2Value, s0_.toIndexNode_, s0_.toInt32Node_, s0_.notSharedArrayBuffer_);
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
                return NodeCost.MONOMORPHIC;
            }
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doGeneric";
            if (state_0 != 0 /* is-state_0 doGeneric(Object, Object, Object, JSToIndexNode, JSToInt32Node, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                GenericData s0_ = this.generic_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.toIndexNode_, s0_.toInt32Node_, s0_.notSharedArrayBuffer_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static AtomicsNotifyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new AtomicsNotifyNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(AtomicsNotifyNode.class)
        private static final class GenericData extends Node {

            @Child JSToIndexNode toIndexNode_;
            @Child JSToInt32Node toInt32Node_;
            @CompilationFinal BranchProfile notSharedArrayBuffer_;

            GenericData() {
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
    @GeneratedBy(AtomicsWaitNode.class)
    public static final class AtomicsWaitNodeGen extends AtomicsWaitNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;

        private AtomicsWaitNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
            this.arguments3_ = arguments != null && 3 < arguments.length ? arguments[3] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            return doGeneric(frameValue, arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "doGeneric";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static AtomicsWaitNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new AtomicsWaitNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(AtomicsWaitAsyncNode.class)
    public static final class AtomicsWaitAsyncNodeGen extends AtomicsWaitAsyncNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;

        private AtomicsWaitAsyncNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
            this.arguments3_ = arguments != null && 3 < arguments.length ? arguments[3] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            return doGeneric(frameValue, arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "doGeneric";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static AtomicsWaitAsyncNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new AtomicsWaitAsyncNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(AtomicsIsLockFreeNode.class)
    public static final class AtomicsIsLockFreeNodeGen extends AtomicsIsLockFreeNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToInt32Node toInt32Node_;

        private AtomicsIsLockFreeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 doGeneric(Object, JSToInt32Node) */) {
                return doGeneric(arguments0Value_, this.toInt32Node_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                this.toInt32Node_ = super.insert((JSToInt32Node.create()));
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doGeneric(Object, JSToInt32Node) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(arguments0Value, this.toInt32Node_);
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
                return NodeCost.MONOMORPHIC;
            }
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doGeneric";
            if (state_0 != 0 /* is-state_0 doGeneric(Object, JSToInt32Node) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toInt32Node_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static AtomicsIsLockFreeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new AtomicsIsLockFreeNodeGen(context, builtin, arguments);
        }

    }
}
