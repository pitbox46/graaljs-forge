// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSWriteScopeFrameSlotNode.class)
final class JSWriteScopeFrameSlotNodeGen extends JSWriteScopeFrameSlotNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;

    private JSWriteScopeFrameSlotNodeGen(FrameSlot frameSlot, ScopeFrameNode scopeFrameNode, JavaScriptNode rhsNode, FrameDescriptor frameDescriptor) {
        super(frameSlot, scopeFrameNode, rhsNode, frameDescriptor);
    }

    @Override
    Object executeEvaluated(VirtualFrame frameValue, Frame scopeFrameNodeValue, Object rhsNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111111) != 0 /* is-state_0 doBoolean(Frame, boolean) || doInteger(Frame, int, FrameSlotKind) || doSafeInteger(Frame, SafeInteger) || doLong(Frame, long) || doDouble(Frame, double) || doObject(Frame, Object) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(Frame, boolean) */ && rhsNodeValue instanceof Boolean) {
                boolean rhsNodeValue_ = (boolean) rhsNodeValue;
                if ((isBooleanKind(scopeFrameNodeValue))) {
                    return doBoolean(scopeFrameNodeValue, rhsNodeValue_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(Frame, int, FrameSlotKind) */ && rhsNodeValue instanceof Integer) {
                int rhsNodeValue_ = (int) rhsNodeValue;
                {
                    FrameSlotKind integer_kind__ = (frameDescriptor.getFrameSlotKind(frameSlot));
                    if ((isIntegerKind(scopeFrameNodeValue, integer_kind__) || isLongKind(scopeFrameNodeValue, integer_kind__) || isDoubleKind(scopeFrameNodeValue, integer_kind__))) {
                        return doInteger(scopeFrameNodeValue, rhsNodeValue_, integer_kind__);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doSafeInteger(Frame, SafeInteger) */ && rhsNodeValue instanceof SafeInteger) {
                SafeInteger rhsNodeValue_ = (SafeInteger) rhsNodeValue;
                if ((isLongKind(scopeFrameNodeValue))) {
                    return doSafeInteger(scopeFrameNodeValue, rhsNodeValue_);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(Frame, long) */ && rhsNodeValue instanceof Long) {
                long rhsNodeValue_ = (long) rhsNodeValue;
                return doLong(scopeFrameNodeValue, rhsNodeValue_);
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(Frame, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rhsNodeValue)) {
                double rhsNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rhsNodeValue);
                if ((isDoubleKind(scopeFrameNodeValue))) {
                    return doDouble(scopeFrameNodeValue, rhsNodeValue_);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(Frame, Object) */) {
                return doObject(scopeFrameNodeValue, rhsNodeValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue, rhsNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        if ((state_0 & 0b111110) == 0 /* only-active doBoolean(Frame, boolean) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
            return execute_boolean0(state_0, frameValue, scopeFrameNodeValue_);
        } else if ((state_0 & 0b111101) == 0 /* only-active doInteger(Frame, int, FrameSlotKind) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
            return execute_int1(state_0, frameValue, scopeFrameNodeValue_);
        } else if ((state_0 & 0b110111) == 0 /* only-active doLong(Frame, long) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
            return execute_long2(state_0, frameValue, scopeFrameNodeValue_);
        } else if ((state_0 & 0b101111) == 0 /* only-active doDouble(Frame, double) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
            return execute_double3(state_0, frameValue, scopeFrameNodeValue_);
        } else {
            return execute_generic4(state_0, frameValue, scopeFrameNodeValue_);
        }
    }

    private Object execute_boolean0(int state_0, VirtualFrame frameValue, Frame scopeFrameNodeValue_) {
        boolean rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(scopeFrameNodeValue_, ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doBoolean(Frame, boolean) */;
        if ((isBooleanKind(scopeFrameNodeValue_))) {
            return doBoolean(scopeFrameNodeValue_, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_);
    }

    private Object execute_int1(int state_0, VirtualFrame frameValue, Frame scopeFrameNodeValue_) {
        int rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(scopeFrameNodeValue_, ex.getResult());
        }
        assert (state_0 & 0b10) != 0 /* is-state_0 doInteger(Frame, int, FrameSlotKind) */;
        {
            FrameSlotKind integer_kind__ = (frameDescriptor.getFrameSlotKind(frameSlot));
            if ((isIntegerKind(scopeFrameNodeValue_, integer_kind__) || isLongKind(scopeFrameNodeValue_, integer_kind__) || isDoubleKind(scopeFrameNodeValue_, integer_kind__))) {
                return doInteger(scopeFrameNodeValue_, rhsNodeValue_, integer_kind__);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_);
    }

    private Object execute_long2(int state_0, VirtualFrame frameValue, Frame scopeFrameNodeValue_) {
        long rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(scopeFrameNodeValue_, ex.getResult());
        }
        assert (state_0 & 0b1000) != 0 /* is-state_0 doLong(Frame, long) */;
        return doLong(scopeFrameNodeValue_, rhsNodeValue_);
    }

    private Object execute_double3(int state_0, VirtualFrame frameValue, Frame scopeFrameNodeValue_) {
        int rhsNodeValue_int = 0;
        long rhsNodeValue_long = 0L;
        double rhsNodeValue_;
        try {
            if ((state_0 & 0b1110000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
                rhsNodeValue_long = super.rhsNode.executeLong(frameValue);
                rhsNodeValue_ = JSTypes.longToDouble(rhsNodeValue_long);
            } else if ((state_0 & 0b1101000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
                rhsNodeValue_int = super.rhsNode.executeInt(frameValue);
                rhsNodeValue_ = JSTypes.intToDouble(rhsNodeValue_int);
            } else if ((state_0 & 0b1011000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
                rhsNodeValue_ = super.rhsNode.executeDouble(frameValue);
            } else {
                Object rhsNodeValue__ = super.rhsNode.execute(frameValue);
                rhsNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rhsNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(scopeFrameNodeValue_, ex.getResult());
        }
        assert (state_0 & 0b10000) != 0 /* is-state_0 doDouble(Frame, double) */;
        if ((isDoubleKind(scopeFrameNodeValue_))) {
            return doDouble(scopeFrameNodeValue_, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue_, ((state_0 & 0b1110000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) ? (Object) rhsNodeValue_long : ((state_0 & 0b1101000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) ? (Object) rhsNodeValue_int : (Object) rhsNodeValue_)));
    }

    private Object execute_generic4(int state_0, VirtualFrame frameValue, Frame scopeFrameNodeValue_) {
        Object rhsNodeValue_ = super.rhsNode.execute(frameValue);
        if ((state_0 & 0b111111) != 0 /* is-state_0 doBoolean(Frame, boolean) || doInteger(Frame, int, FrameSlotKind) || doSafeInteger(Frame, SafeInteger) || doLong(Frame, long) || doDouble(Frame, double) || doObject(Frame, Object) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(Frame, boolean) */ && rhsNodeValue_ instanceof Boolean) {
                boolean rhsNodeValue__ = (boolean) rhsNodeValue_;
                if ((isBooleanKind(scopeFrameNodeValue_))) {
                    return doBoolean(scopeFrameNodeValue_, rhsNodeValue__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(Frame, int, FrameSlotKind) */ && rhsNodeValue_ instanceof Integer) {
                int rhsNodeValue__ = (int) rhsNodeValue_;
                {
                    FrameSlotKind integer_kind__ = (frameDescriptor.getFrameSlotKind(frameSlot));
                    if ((isIntegerKind(scopeFrameNodeValue_, integer_kind__) || isLongKind(scopeFrameNodeValue_, integer_kind__) || isDoubleKind(scopeFrameNodeValue_, integer_kind__))) {
                        return doInteger(scopeFrameNodeValue_, rhsNodeValue__, integer_kind__);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doSafeInteger(Frame, SafeInteger) */ && rhsNodeValue_ instanceof SafeInteger) {
                SafeInteger rhsNodeValue__ = (SafeInteger) rhsNodeValue_;
                if ((isLongKind(scopeFrameNodeValue_))) {
                    return doSafeInteger(scopeFrameNodeValue_, rhsNodeValue__);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(Frame, long) */ && rhsNodeValue_ instanceof Long) {
                long rhsNodeValue__ = (long) rhsNodeValue_;
                return doLong(scopeFrameNodeValue_, rhsNodeValue__);
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(Frame, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rhsNodeValue_)) {
                double rhsNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rhsNodeValue_);
                if ((isDoubleKind(scopeFrameNodeValue_))) {
                    return doDouble(scopeFrameNodeValue_, rhsNodeValue__);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(Frame, Object) */) {
                return doObject(scopeFrameNodeValue_, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(Frame, Object) */) {
            return JSTypesGen.expectBoolean(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        boolean rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectBoolean(executeAndSpecialize(scopeFrameNodeValue_, ex.getResult()));
        }
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(Frame, boolean) */) {
            if ((isBooleanKind(scopeFrameNodeValue_))) {
                return doBoolean(scopeFrameNodeValue_, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectBoolean(executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_));
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(Frame, Object) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        int rhsNodeValue_int = 0;
        long rhsNodeValue_long = 0L;
        double rhsNodeValue_;
        try {
            if ((state_0 & 0b1110000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
                rhsNodeValue_long = super.rhsNode.executeLong(frameValue);
                rhsNodeValue_ = JSTypes.longToDouble(rhsNodeValue_long);
            } else if ((state_0 & 0b1101000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
                rhsNodeValue_int = super.rhsNode.executeInt(frameValue);
                rhsNodeValue_ = JSTypes.intToDouble(rhsNodeValue_int);
            } else if ((state_0 & 0b1011000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
                rhsNodeValue_ = super.rhsNode.executeDouble(frameValue);
            } else {
                Object rhsNodeValue__ = super.rhsNode.execute(frameValue);
                rhsNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 1:double */, rhsNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(scopeFrameNodeValue_, ex.getResult()));
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(Frame, double) */) {
            if ((isDoubleKind(scopeFrameNodeValue_))) {
                return doDouble(scopeFrameNodeValue_, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(scopeFrameNodeValue_, ((state_0 & 0b1110000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) ? (Object) rhsNodeValue_long : ((state_0 & 0b1101000000) == 0 /* only-active 1:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) ? (Object) rhsNodeValue_int : (Object) rhsNodeValue_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(Frame, Object) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        int rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(scopeFrameNodeValue_, ex.getResult()));
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(Frame, int, FrameSlotKind) */) {
            {
                FrameSlotKind integer_kind__ = (frameDescriptor.getFrameSlotKind(frameSlot));
                if ((isIntegerKind(scopeFrameNodeValue_, integer_kind__) || isLongKind(scopeFrameNodeValue_, integer_kind__) || isDoubleKind(scopeFrameNodeValue_, integer_kind__))) {
                    return doInteger(scopeFrameNodeValue_, rhsNodeValue_, integer_kind__);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_));
    }

    @Override
    public long executeLong(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(Frame, Object) */) {
            return JSTypesGen.expectLong(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        long rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectLong(executeAndSpecialize(scopeFrameNodeValue_, ex.getResult()));
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(Frame, long) */) {
            return doLong(scopeFrameNodeValue_, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectLong(executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b110111) == 0 /* only-active doLong(Frame, long) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
                executeLong(frameValue);
                return;
            } else if ((state_0 & 0b111101) == 0 /* only-active doInteger(Frame, int, FrameSlotKind) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b101111) == 0 /* only-active doDouble(Frame, double) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
                executeDouble(frameValue);
                return;
            } else if ((state_0 & 0b111110) == 0 /* only-active doBoolean(Frame, boolean) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(Frame, boolean) && doInteger(Frame, int, FrameSlotKind) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */)) {
                executeBoolean(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Frame scopeFrameNodeValue, Object rhsNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (((exclude & 0b1)) == 0 /* is-not-exclude doBoolean(Frame, boolean) */ && rhsNodeValue instanceof Boolean) {
                boolean rhsNodeValue_ = (boolean) rhsNodeValue;
                if ((isBooleanKind(scopeFrameNodeValue))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBoolean(Frame, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doBoolean(scopeFrameNodeValue, rhsNodeValue_);
                }
            }
            {
                FrameSlotKind integer_kind__ = null;
                if (((exclude & 0b10)) == 0 /* is-not-exclude doInteger(Frame, int, FrameSlotKind) */ && rhsNodeValue instanceof Integer) {
                    int rhsNodeValue_ = (int) rhsNodeValue;
                    {
                        integer_kind__ = (frameDescriptor.getFrameSlotKind(frameSlot));
                        if ((isIntegerKind(scopeFrameNodeValue, integer_kind__) || isLongKind(scopeFrameNodeValue, integer_kind__) || isDoubleKind(scopeFrameNodeValue, integer_kind__))) {
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doInteger(Frame, int, FrameSlotKind) */;
                            lock.unlock();
                            hasLock = false;
                            return doInteger(scopeFrameNodeValue, rhsNodeValue_, integer_kind__);
                        }
                    }
                }
            }
            if (((exclude & 0b100)) == 0 /* is-not-exclude doSafeInteger(Frame, SafeInteger) */ && rhsNodeValue instanceof SafeInteger) {
                SafeInteger rhsNodeValue_ = (SafeInteger) rhsNodeValue;
                if ((isLongKind(scopeFrameNodeValue))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doSafeInteger(Frame, SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(scopeFrameNodeValue, rhsNodeValue_);
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-exclude doLong(Frame, long) */ && rhsNodeValue instanceof Long) {
                long rhsNodeValue_ = (long) rhsNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doLong(Frame, long) */;
                lock.unlock();
                hasLock = false;
                return doLong(scopeFrameNodeValue, rhsNodeValue_);
            }
            if (((exclude & 0b10000)) == 0 /* is-not-exclude doDouble(Frame, double) */) {
                int doubleCast1;
                if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rhsNodeValue)) != 0) {
                    double rhsNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rhsNodeValue);
                    if ((isDoubleKind(scopeFrameNodeValue))) {
                        this.exclude_ = exclude = exclude | 0b110 /* add-exclude doInteger(Frame, int, FrameSlotKind), doSafeInteger(Frame, SafeInteger) */;
                        state_0 = state_0 & 0xfffffff9 /* remove-state_0 doInteger(Frame, int, FrameSlotKind), doSafeInteger(Frame, SafeInteger) */;
                        state_0 = (state_0 | (doubleCast1 << 6) /* set-implicit-state_0 1:double */);
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doDouble(Frame, double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(scopeFrameNodeValue, rhsNodeValue_);
                    }
                }
            }
            this.exclude_ = exclude = exclude | 0b11111 /* add-exclude doBoolean(Frame, boolean), doInteger(Frame, int, FrameSlotKind), doSafeInteger(Frame, SafeInteger), doLong(Frame, long), doDouble(Frame, double) */;
            state_0 = state_0 & 0xffffffe0 /* remove-state_0 doBoolean(Frame, boolean), doInteger(Frame, int, FrameSlotKind), doSafeInteger(Frame, SafeInteger), doLong(Frame, long), doDouble(Frame, double) */;
            this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doObject(Frame, Object) */;
            lock.unlock();
            hasLock = false;
            return doObject(scopeFrameNodeValue, rhsNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b111111) & ((state_0 & 0b111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[7];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(Frame, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doBoolean(Frame, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(Frame, int, FrameSlotKind) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doInteger(Frame, int, FrameSlotKind) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b100) != 0 /* is-state_0 doSafeInteger(Frame, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-exclude doSafeInteger(Frame, SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(Frame, long) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doLong(Frame, long) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(Frame, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-exclude doDouble(Frame, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(Frame, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        return Provider.create(data);
    }

    public static JSWriteScopeFrameSlotNode create(FrameSlot frameSlot, ScopeFrameNode scopeFrameNode, JavaScriptNode rhsNode, FrameDescriptor frameDescriptor) {
        return new JSWriteScopeFrameSlotNodeGen(frameSlot, scopeFrameNode, rhsNode, frameDescriptor);
    }

}
