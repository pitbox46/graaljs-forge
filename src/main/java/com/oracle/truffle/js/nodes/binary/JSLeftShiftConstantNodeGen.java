// CheckStyle: start generated
package com.oracle.truffle.js.nodes.binary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToInt32Node;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSLeftShiftConstantNode.class)
public final class JSLeftShiftConstantNodeGen extends JSLeftShiftConstantNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSToInt32Node double_leftInt32Node_;
    @Child private JSOverloadedBinaryNode overloaded_overloadedOperatorNode_;
    @Child private JSToNumericNode generic_leftToNumericNode_;
    @Child private JSLeftShiftConstantNode generic_innerShiftNode_;

    private JSLeftShiftConstantNodeGen(JavaScriptNode operand, int shiftValue) {
        super(operand, shiftValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doInteger(operandNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            return doSafeInteger(operandNodeValue_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_, this.double_leftInt32Node_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */ && operandNodeValue instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject operandNodeValue_ = (JSOverloadedOperatorsObject) operandNodeValue;
            return doOverloaded(operandNodeValue_, this.overloaded_overloadedOperatorNode_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */) {
            if ((!(JSGuards.hasOverloadedOperators(operandNodeValue)))) {
                return doGeneric(operandNodeValue, this.generic_leftToNumericNode_, this.generic_innerShiftNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b110110) == 0 /* only-active doInteger(int) */ && ((state_0 & 0b110111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */)) {
            return execute_int0(state_0, frameValue);
        } else if ((state_0 & 0b110011) == 0 /* only-active doDouble(double, JSToInt32Node) */ && ((state_0 & 0b110111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */)) {
            return execute_double1(state_0, frameValue);
        } else {
            return execute_generic2(state_0, frameValue);
        }
    }

    private Object execute_int0(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */;
        return doInteger(operandNodeValue_);
    }

    private Object execute_double1(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0b1110000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0b1101000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0b1011000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */;
        return doDouble(operandNodeValue_, this.double_leftInt32Node_);
    }

    private Object execute_generic2(int state_0, VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            return doInteger(operandNodeValue__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            return doSafeInteger(operandNodeValue__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__, this.double_leftInt32Node_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */ && operandNodeValue_ instanceof JSOverloadedOperatorsObject) {
            JSOverloadedOperatorsObject operandNodeValue__ = (JSOverloadedOperatorsObject) operandNodeValue_;
            return doOverloaded(operandNodeValue__, this.overloaded_overloadedOperatorNode_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */) {
            if ((!(JSGuards.hasOverloadedOperators(operandNodeValue_)))) {
                return doGeneric(operandNodeValue_, this.generic_leftToNumericNode_, this.generic_innerShiftNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b110000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) || doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        if ((state_0 & 0b110) == 0 /* only-active doInteger(int) */ && ((state_0 & 0b111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) */)) {
            return executeInt_int3(state_0, frameValue);
        } else if ((state_0 & 0b11) == 0 /* only-active doDouble(double, JSToInt32Node) */ && ((state_0 & 0b111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) */)) {
            return executeInt_double4(state_0, frameValue);
        } else {
            return executeInt_generic5(state_0, frameValue);
        }
    }

    private int executeInt_int3(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */;
        return doInteger(operandNodeValue_);
    }

    private int executeInt_double4(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0b1110000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0b1101000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0b1011000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */;
        return doDouble(operandNodeValue_, this.double_leftInt32Node_);
    }

    private int executeInt_generic5(int state_0, VirtualFrame frameValue) throws UnexpectedResultException {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            return doInteger(operandNodeValue__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            return doSafeInteger(operandNodeValue__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__, this.double_leftInt32Node_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(operandNodeValue_));
    }

    @Override
    public int executeInt(Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b110000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) || doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */) {
            return (int) execute(null, operandNodeValue);
        }
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doInteger(operandNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            return doSafeInteger(operandNodeValue_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000) >>> 6 /* extract-implicit-state_0 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_, this.double_leftInt32Node_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return (int) executeAndSpecialize(operandNodeValue);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b111000) == 0 /* only-active doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) */ && ((state_0 & 0b111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doBigInt(BigInt) && doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) && doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b110111) != 0 /* is-state_0 doInteger(int) || doSafeInteger(SafeInteger) || doDouble(double, JSToInt32Node) || doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) || doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */) {
                execute(frameValue);
                return;
            }
        } catch (UnexpectedResultException ex) {
            return;
        }
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            doBigInt(operandNodeValue__);
            return;
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(operandNodeValue_);
        return;
    }

    private Object executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (((exclude & 0b1)) == 0 /* is-not-exclude doInteger(int) */ && operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInteger(int) */;
                lock.unlock();
                hasLock = false;
                return doInteger(operandNodeValue_);
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
                SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doSafeInteger(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return doSafeInteger(operandNodeValue_);
            }
            if (((exclude & 0b100)) == 0 /* is-not-exclude doDouble(double, JSToInt32Node) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    this.double_leftInt32Node_ = super.insert((JSToInt32Node.create()));
                    state_0 = (state_0 | (doubleCast0 << 6) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doDouble(double, JSToInt32Node) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(operandNodeValue_, this.double_leftInt32Node_);
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-exclude doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                doBigInt(operandNodeValue_);
                return null;
            }
            if (operandNodeValue instanceof JSOverloadedOperatorsObject) {
                JSOverloadedOperatorsObject operandNodeValue_ = (JSOverloadedOperatorsObject) operandNodeValue;
                this.overloaded_overloadedOperatorNode_ = super.insert((JSOverloadedBinaryNode.createNumeric(getOverloadedOperatorName())));
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */;
                lock.unlock();
                hasLock = false;
                return doOverloaded(operandNodeValue_, this.overloaded_overloadedOperatorNode_);
            }
            if ((!(JSGuards.hasOverloadedOperators(operandNodeValue)))) {
                this.generic_leftToNumericNode_ = super.insert((JSToNumericNode.create()));
                this.generic_innerShiftNode_ = super.insert((makeCopy()));
                this.exclude_ = exclude = exclude | 0b1111 /* add-exclude doInteger(int), doSafeInteger(SafeInteger), doDouble(double, JSToInt32Node), doBigInt(BigInt) */;
                state_0 = state_0 & 0xfffffff0 /* remove-state_0 doInteger(int), doSafeInteger(SafeInteger), doDouble(double, JSToInt32Node), doBigInt(BigInt) */;
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(operandNodeValue, this.generic_leftToNumericNode_, this.generic_innerShiftNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.operandNode}, operandNodeValue);
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
        s[0] = "doInteger";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doInteger(int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b10) != 0 /* is-state_0 doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-exclude doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double, JSToInt32Node) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.double_leftInt32Node_));
            s[2] = cached;
        } else if ((exclude & 0b100) != 0 /* is-exclude doDouble(double, JSToInt32Node) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-exclude doBigInt(BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doOverloaded";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doOverloaded(JSOverloadedOperatorsObject, JSOverloadedBinaryNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.overloaded_overloadedOperatorNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doGeneric(Object, JSToNumericNode, JSLeftShiftConstantNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.generic_leftToNumericNode_, this.generic_innerShiftNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        return Provider.create(data);
    }

    public static JSLeftShiftConstantNode create(JavaScriptNode operand, int shiftValue) {
        return new JSLeftShiftConstantNodeGen(operand, shiftValue);
    }

}
