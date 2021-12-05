// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
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

@GeneratedBy(JSWriteCurrentFrameSlotNode.class)
final class JSWriteCurrentFrameSlotNodeGen extends JSWriteCurrentFrameSlotNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;

    private JSWriteCurrentFrameSlotNodeGen(FrameSlot frameSlot, JavaScriptNode rhsNode, FrameDescriptor frameDescriptor) {
        super(frameSlot, rhsNode, frameDescriptor);
    }

    @Override
    Object executeEvaluated(VirtualFrame frameValue, Object rhsNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(VirtualFrame, boolean) */ && rhsNodeValue instanceof Boolean) {
            boolean rhsNodeValue_ = (boolean) rhsNodeValue;
            if ((isBooleanKind(frameValue))) {
                return doBoolean(frameValue, rhsNodeValue_);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(VirtualFrame, int, FrameSlotKind) */ && rhsNodeValue instanceof Integer) {
            int rhsNodeValue_ = (int) rhsNodeValue;
            {
                FrameSlotKind integer_kind__ = (frameDescriptor.getFrameSlotKind(frameSlot));
                if ((isIntegerKind(frameValue, integer_kind__) || isLongKind(frameValue, integer_kind__) || isDoubleKind(frameValue, integer_kind__))) {
                    return doInteger(frameValue, rhsNodeValue_, integer_kind__);
                }
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doSafeInteger(VirtualFrame, SafeInteger) */ && rhsNodeValue instanceof SafeInteger) {
            SafeInteger rhsNodeValue_ = (SafeInteger) rhsNodeValue;
            if ((isLongKind(frameValue))) {
                return doSafeInteger(frameValue, rhsNodeValue_);
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(VirtualFrame, long) */ && rhsNodeValue instanceof Long) {
            long rhsNodeValue_ = (long) rhsNodeValue;
            return doLong(frameValue, rhsNodeValue_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(VirtualFrame, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, rhsNodeValue)) {
            double rhsNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, rhsNodeValue);
            if ((isDoubleKind(frameValue))) {
                return doDouble(frameValue, rhsNodeValue_);
            }
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(VirtualFrame, Object) */) {
            return doObject(frameValue, rhsNodeValue);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, rhsNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111110) == 0 /* only-active doBoolean(VirtualFrame, boolean) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
            return execute_boolean0(state_0, frameValue);
        } else if ((state_0 & 0b111101) == 0 /* only-active doInteger(VirtualFrame, int, FrameSlotKind) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
            return execute_int1(state_0, frameValue);
        } else if ((state_0 & 0b110111) == 0 /* only-active doLong(VirtualFrame, long) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
            return execute_long2(state_0, frameValue);
        } else if ((state_0 & 0b101111) == 0 /* only-active doDouble(VirtualFrame, double) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
            return execute_double3(state_0, frameValue);
        } else {
            return execute_generic4(state_0, frameValue);
        }
    }

    private Object execute_boolean0(int state_0, VirtualFrame frameValue) {
        boolean rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(frameValue, ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doBoolean(VirtualFrame, boolean) */;
        if ((isBooleanKind(frameValue))) {
            return doBoolean(frameValue, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, rhsNodeValue_);
    }

    private Object execute_int1(int state_0, VirtualFrame frameValue) {
        int rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(frameValue, ex.getResult());
        }
        assert (state_0 & 0b10) != 0 /* is-state_0 doInteger(VirtualFrame, int, FrameSlotKind) */;
        {
            FrameSlotKind integer_kind__ = (frameDescriptor.getFrameSlotKind(frameSlot));
            if ((isIntegerKind(frameValue, integer_kind__) || isLongKind(frameValue, integer_kind__) || isDoubleKind(frameValue, integer_kind__))) {
                return doInteger(frameValue, rhsNodeValue_, integer_kind__);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, rhsNodeValue_);
    }

    private Object execute_long2(int state_0, VirtualFrame frameValue) {
        long rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(frameValue, ex.getResult());
        }
        assert (state_0 & 0b1000) != 0 /* is-state_0 doLong(VirtualFrame, long) */;
        return doLong(frameValue, rhsNodeValue_);
    }

    private Object execute_double3(int state_0, VirtualFrame frameValue) {
        int rhsNodeValue_int = 0;
        long rhsNodeValue_long = 0L;
        double rhsNodeValue_;
        try {
            if ((state_0 & 0b1110000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
                rhsNodeValue_long = super.rhsNode.executeLong(frameValue);
                rhsNodeValue_ = JSTypes.longToDouble(rhsNodeValue_long);
            } else if ((state_0 & 0b1101000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
                rhsNodeValue_int = super.rhsNode.executeInt(frameValue);
                rhsNodeValue_ = JSTypes.intToDouble(rhsNodeValue_int);
            } else if ((state_0 & 0b1011000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
                rhsNodeValue_ = super.rhsNode.executeDouble(frameValue);
            } else {
                Object rhsNodeValue__ = super.rhsNode.execute(frameValue);
                rhsNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, rhsNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(frameValue, ex.getResult());
        }
        assert (state_0 & 0b10000) != 0 /* is-state_0 doDouble(VirtualFrame, double) */;
        if ((isDoubleKind(frameValue))) {
            return doDouble(frameValue, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, ((state_0 & 0b1110000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) ? (Object) rhsNodeValue_long : ((state_0 & 0b1101000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) ? (Object) rhsNodeValue_int : (Object) rhsNodeValue_)));
    }

    private Object execute_generic4(int state_0, VirtualFrame frameValue) {
        Object rhsNodeValue_ = super.rhsNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(VirtualFrame, boolean) */ && rhsNodeValue_ instanceof Boolean) {
            boolean rhsNodeValue__ = (boolean) rhsNodeValue_;
            if ((isBooleanKind(frameValue))) {
                return doBoolean(frameValue, rhsNodeValue__);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(VirtualFrame, int, FrameSlotKind) */ && rhsNodeValue_ instanceof Integer) {
            int rhsNodeValue__ = (int) rhsNodeValue_;
            {
                FrameSlotKind integer_kind__ = (frameDescriptor.getFrameSlotKind(frameSlot));
                if ((isIntegerKind(frameValue, integer_kind__) || isLongKind(frameValue, integer_kind__) || isDoubleKind(frameValue, integer_kind__))) {
                    return doInteger(frameValue, rhsNodeValue__, integer_kind__);
                }
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doSafeInteger(VirtualFrame, SafeInteger) */ && rhsNodeValue_ instanceof SafeInteger) {
            SafeInteger rhsNodeValue__ = (SafeInteger) rhsNodeValue_;
            if ((isLongKind(frameValue))) {
                return doSafeInteger(frameValue, rhsNodeValue__);
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(VirtualFrame, long) */ && rhsNodeValue_ instanceof Long) {
            long rhsNodeValue__ = (long) rhsNodeValue_;
            return doLong(frameValue, rhsNodeValue__);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(VirtualFrame, double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, rhsNodeValue_)) {
            double rhsNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, rhsNodeValue_);
            if ((isDoubleKind(frameValue))) {
                return doDouble(frameValue, rhsNodeValue__);
            }
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(VirtualFrame, Object) */) {
            return doObject(frameValue, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, rhsNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(VirtualFrame, Object) */) {
            return JSTypesGen.expectBoolean(execute(frameValue));
        }
        boolean rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectBoolean(executeAndSpecialize(frameValue, ex.getResult()));
        }
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(VirtualFrame, boolean) */) {
            if ((isBooleanKind(frameValue))) {
                return doBoolean(frameValue, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectBoolean(executeAndSpecialize(frameValue, rhsNodeValue_));
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(VirtualFrame, Object) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        int rhsNodeValue_int = 0;
        long rhsNodeValue_long = 0L;
        double rhsNodeValue_;
        try {
            if ((state_0 & 0b1110000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
                rhsNodeValue_long = super.rhsNode.executeLong(frameValue);
                rhsNodeValue_ = JSTypes.longToDouble(rhsNodeValue_long);
            } else if ((state_0 & 0b1101000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
                rhsNodeValue_int = super.rhsNode.executeInt(frameValue);
                rhsNodeValue_ = JSTypes.intToDouble(rhsNodeValue_int);
            } else if ((state_0 & 0b1011000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
                rhsNodeValue_ = super.rhsNode.executeDouble(frameValue);
            } else {
                Object rhsNodeValue__ = super.rhsNode.execute(frameValue);
                rhsNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, rhsNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(frameValue, ex.getResult()));
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(VirtualFrame, double) */) {
            if ((isDoubleKind(frameValue))) {
                return doDouble(frameValue, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(frameValue, ((state_0 & 0b1110000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) ? (Object) rhsNodeValue_long : ((state_0 & 0b1101000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) ? (Object) rhsNodeValue_int : (Object) rhsNodeValue_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(VirtualFrame, Object) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        int rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(frameValue, ex.getResult()));
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(VirtualFrame, int, FrameSlotKind) */) {
            {
                FrameSlotKind integer_kind__ = (frameDescriptor.getFrameSlotKind(frameSlot));
                if ((isIntegerKind(frameValue, integer_kind__) || isLongKind(frameValue, integer_kind__) || isDoubleKind(frameValue, integer_kind__))) {
                    return doInteger(frameValue, rhsNodeValue_, integer_kind__);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(frameValue, rhsNodeValue_));
    }

    @Override
    public long executeLong(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(VirtualFrame, Object) */) {
            return JSTypesGen.expectLong(execute(frameValue));
        }
        long rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectLong(executeAndSpecialize(frameValue, ex.getResult()));
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(VirtualFrame, long) */) {
            return doLong(frameValue, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectLong(executeAndSpecialize(frameValue, rhsNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b110111) == 0 /* only-active doLong(VirtualFrame, long) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
                executeLong(frameValue);
                return;
            } else if ((state_0 & 0b111101) == 0 /* only-active doInteger(VirtualFrame, int, FrameSlotKind) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b101111) == 0 /* only-active doDouble(VirtualFrame, double) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
                executeDouble(frameValue);
                return;
            } else if ((state_0 & 0b111110) == 0 /* only-active doBoolean(VirtualFrame, boolean) */ && ((state_0 & 0b111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInteger(VirtualFrame, int, FrameSlotKind) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */)) {
                executeBoolean(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(VirtualFrame frameValue, Object rhsNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (((exclude & 0b1)) == 0 /* is-not-exclude doBoolean(VirtualFrame, boolean) */ && rhsNodeValue instanceof Boolean) {
                boolean rhsNodeValue_ = (boolean) rhsNodeValue;
                if ((isBooleanKind(frameValue))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBoolean(VirtualFrame, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doBoolean(frameValue, rhsNodeValue_);
                }
            }
            {
                FrameSlotKind integer_kind__ = null;
                if (((exclude & 0b10)) == 0 /* is-not-exclude doInteger(VirtualFrame, int, FrameSlotKind) */ && rhsNodeValue instanceof Integer) {
                    int rhsNodeValue_ = (int) rhsNodeValue;
                    {
                        integer_kind__ = (frameDescriptor.getFrameSlotKind(frameSlot));
                        if ((isIntegerKind(frameValue, integer_kind__) || isLongKind(frameValue, integer_kind__) || isDoubleKind(frameValue, integer_kind__))) {
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doInteger(VirtualFrame, int, FrameSlotKind) */;
                            lock.unlock();
                            hasLock = false;
                            return doInteger(frameValue, rhsNodeValue_, integer_kind__);
                        }
                    }
                }
            }
            if (((exclude & 0b100)) == 0 /* is-not-exclude doSafeInteger(VirtualFrame, SafeInteger) */ && rhsNodeValue instanceof SafeInteger) {
                SafeInteger rhsNodeValue_ = (SafeInteger) rhsNodeValue;
                if ((isLongKind(frameValue))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doSafeInteger(VirtualFrame, SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(frameValue, rhsNodeValue_);
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-exclude doLong(VirtualFrame, long) */ && rhsNodeValue instanceof Long) {
                long rhsNodeValue_ = (long) rhsNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doLong(VirtualFrame, long) */;
                lock.unlock();
                hasLock = false;
                return doLong(frameValue, rhsNodeValue_);
            }
            if (((exclude & 0b10000)) == 0 /* is-not-exclude doDouble(VirtualFrame, double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(rhsNodeValue)) != 0) {
                    double rhsNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, rhsNodeValue);
                    if ((isDoubleKind(frameValue))) {
                        this.exclude_ = exclude = exclude | 0b110 /* add-exclude doInteger(VirtualFrame, int, FrameSlotKind), doSafeInteger(VirtualFrame, SafeInteger) */;
                        state_0 = state_0 & 0xfffffff9 /* remove-state_0 doInteger(VirtualFrame, int, FrameSlotKind), doSafeInteger(VirtualFrame, SafeInteger) */;
                        state_0 = (state_0 | (doubleCast0 << 6) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doDouble(VirtualFrame, double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(frameValue, rhsNodeValue_);
                    }
                }
            }
            this.exclude_ = exclude = exclude | 0b11111 /* add-exclude doBoolean(VirtualFrame, boolean), doInteger(VirtualFrame, int, FrameSlotKind), doSafeInteger(VirtualFrame, SafeInteger), doLong(VirtualFrame, long), doDouble(VirtualFrame, double) */;
            state_0 = state_0 & 0xffffffe0 /* remove-state_0 doBoolean(VirtualFrame, boolean), doInteger(VirtualFrame, int, FrameSlotKind), doSafeInteger(VirtualFrame, SafeInteger), doLong(VirtualFrame, long), doDouble(VirtualFrame, double) */;
            this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doObject(VirtualFrame, Object) */;
            lock.unlock();
            hasLock = false;
            return doObject(frameValue, rhsNodeValue);
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
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(VirtualFrame, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doBoolean(VirtualFrame, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state_0 & 0b10) != 0 /* is-state_0 doInteger(VirtualFrame, int, FrameSlotKind) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doInteger(VirtualFrame, int, FrameSlotKind) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b100) != 0 /* is-state_0 doSafeInteger(VirtualFrame, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-exclude doSafeInteger(VirtualFrame, SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLong(VirtualFrame, long) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doLong(VirtualFrame, long) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDouble(VirtualFrame, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-exclude doDouble(VirtualFrame, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doObject(VirtualFrame, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        return Provider.create(data);
    }

    public static JSWriteCurrentFrameSlotNode create(FrameSlot frameSlot, JavaScriptNode rhsNode, FrameDescriptor frameDescriptor) {
        return new JSWriteCurrentFrameSlotNodeGen(frameSlot, rhsNode, frameDescriptor);
    }

}
