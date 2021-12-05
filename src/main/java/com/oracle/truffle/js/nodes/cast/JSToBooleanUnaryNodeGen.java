// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

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
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToBooleanUnaryNode.class)
public final class JSToBooleanUnaryNodeGen extends JSToBooleanUnaryNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private JSToBooleanNode foreignObject_toBooleanNode_;

    private JSToBooleanUnaryNodeGen(JavaScriptNode operand) {
        super(operand);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            return JSToBooleanUnaryNode.doBoolean(operandNodeValue_);
        }
        if ((state_0 & 0b110) != 0 /* is-state_0 doNull(Object) || doUndefined(Object) */) {
            if ((state_0 & 0b10) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue))) {
                    return JSToBooleanUnaryNode.doNull(operandNodeValue);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue))) {
                    return JSToBooleanUnaryNode.doUndefined(operandNodeValue);
                }
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doInt(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return JSToBooleanUnaryNode.doInt(operandNodeValue_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doLong(long) */ && operandNodeValue instanceof Long) {
            long operandNodeValue_ = (long) operandNodeValue;
            return JSToBooleanUnaryNode.doLong(operandNodeValue_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000000000) >>> 12 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000000000) >>> 12 /* extract-implicit-state_0 0:double */, operandNodeValue);
            return JSToBooleanUnaryNode.doDouble(operandNodeValue_);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return JSToBooleanUnaryNode.doBigInt(operandNodeValue_);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doLazyString(JSLazyString) */ && operandNodeValue instanceof JSLazyString) {
            JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
            return JSToBooleanUnaryNode.doLazyString(operandNodeValue_);
        }
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doString(String) */ && JSTypesGen.isImplicitString((state_0 & 0x70000) >>> 16 /* extract-implicit-state_0 0:String */, operandNodeValue)) {
            String operandNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0x70000) >>> 16 /* extract-implicit-state_0 0:String */, operandNodeValue);
            return JSToBooleanUnaryNode.doString(operandNodeValue_);
        }
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doObject(Object) */) {
            if ((JSGuards.isJSObject(operandNodeValue))) {
                return JSToBooleanUnaryNode.doObject(operandNodeValue);
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return JSToBooleanUnaryNode.doSymbol(operandNodeValue_);
        }
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doForeignObject(Object, JSToBooleanNode) */) {
            if ((JSGuards.isForeignObject(operandNodeValue))) {
                return JSToBooleanUnaryNode.doForeignObject(operandNodeValue, this.foreignObject_toBooleanNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111111111110) == 0 /* only-active doBoolean(boolean) */ && ((state_0 & 0b111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(Object) && doSymbol(Symbol) && doForeignObject(Object, JSToBooleanNode) */)) {
            return executeBoolean_boolean0(state_0, frameValue);
        } else if ((state_0 & 0b111111110111) == 0 /* only-active doInt(int) */ && ((state_0 & 0b111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(Object) && doSymbol(Symbol) && doForeignObject(Object, JSToBooleanNode) */)) {
            return executeBoolean_int1(state_0, frameValue);
        } else if ((state_0 & 0b111111101111) == 0 /* only-active doLong(long) */ && ((state_0 & 0b111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(Object) && doSymbol(Symbol) && doForeignObject(Object, JSToBooleanNode) */)) {
            return executeBoolean_long2(state_0, frameValue);
        } else if ((state_0 & 0b111111011111) == 0 /* only-active doDouble(double) */ && ((state_0 & 0b111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(Object) && doSymbol(Symbol) && doForeignObject(Object, JSToBooleanNode) */)) {
            return executeBoolean_double3(state_0, frameValue);
        } else {
            return executeBoolean_generic4(state_0, frameValue);
        }
    }

    private boolean executeBoolean_boolean0(int state_0, VirtualFrame frameValue) {
        boolean operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean) */;
        return JSToBooleanUnaryNode.doBoolean(operandNodeValue_);
    }

    private boolean executeBoolean_int1(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1000) != 0 /* is-state_0 doInt(int) */;
        return JSToBooleanUnaryNode.doInt(operandNodeValue_);
    }

    private boolean executeBoolean_long2(int state_0, VirtualFrame frameValue) {
        long operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b10000) != 0 /* is-state_0 doLong(long) */;
        return JSToBooleanUnaryNode.doLong(operandNodeValue_);
    }

    private boolean executeBoolean_double3(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0b1110000000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(Object) && doSymbol(Symbol) && doForeignObject(Object, JSToBooleanNode) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0b1101000000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(Object) && doSymbol(Symbol) && doForeignObject(Object, JSToBooleanNode) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0b1011000000000000) == 0 /* only-active 0:double */ && ((state_0 & 0b111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(Object) && doSymbol(Symbol) && doForeignObject(Object, JSToBooleanNode) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000000000000) >>> 12 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b100000) != 0 /* is-state_0 doDouble(double) */;
        return JSToBooleanUnaryNode.doDouble(operandNodeValue_);
    }

    private boolean executeBoolean_generic4(int state_0, VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue_ instanceof Boolean) {
            boolean operandNodeValue__ = (boolean) operandNodeValue_;
            return JSToBooleanUnaryNode.doBoolean(operandNodeValue__);
        }
        if ((state_0 & 0b110) != 0 /* is-state_0 doNull(Object) || doUndefined(Object) */) {
            if ((state_0 & 0b10) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue_))) {
                    return JSToBooleanUnaryNode.doNull(operandNodeValue_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue_))) {
                    return JSToBooleanUnaryNode.doUndefined(operandNodeValue_);
                }
            }
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doInt(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            return JSToBooleanUnaryNode.doInt(operandNodeValue__);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doLong(long) */ && operandNodeValue_ instanceof Long) {
            long operandNodeValue__ = (long) operandNodeValue_;
            return JSToBooleanUnaryNode.doLong(operandNodeValue__);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000000000) >>> 12 /* extract-implicit-state_0 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000000000) >>> 12 /* extract-implicit-state_0 0:double */, operandNodeValue_);
            return JSToBooleanUnaryNode.doDouble(operandNodeValue__);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return JSToBooleanUnaryNode.doBigInt(operandNodeValue__);
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doLazyString(JSLazyString) */ && operandNodeValue_ instanceof JSLazyString) {
            JSLazyString operandNodeValue__ = (JSLazyString) operandNodeValue_;
            return JSToBooleanUnaryNode.doLazyString(operandNodeValue__);
        }
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doString(String) */ && JSTypesGen.isImplicitString((state_0 & 0x70000) >>> 16 /* extract-implicit-state_0 0:String */, operandNodeValue_)) {
            String operandNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0x70000) >>> 16 /* extract-implicit-state_0 0:String */, operandNodeValue_);
            return JSToBooleanUnaryNode.doString(operandNodeValue__);
        }
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doObject(Object) */) {
            if ((JSGuards.isJSObject(operandNodeValue_))) {
                return JSToBooleanUnaryNode.doObject(operandNodeValue_);
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue_ instanceof Symbol) {
            Symbol operandNodeValue__ = (Symbol) operandNodeValue_;
            return JSToBooleanUnaryNode.doSymbol(operandNodeValue__);
        }
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doForeignObject(Object, JSToBooleanNode) */) {
            if ((JSGuards.isForeignObject(operandNodeValue_))) {
                return JSToBooleanUnaryNode.doForeignObject(operandNodeValue_, this.foreignObject_toBooleanNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    private boolean executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (operandNodeValue instanceof Boolean) {
                boolean operandNodeValue_ = (boolean) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return JSToBooleanUnaryNode.doBoolean(operandNodeValue_);
            }
            if ((JSGuards.isJSNull(operandNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return JSToBooleanUnaryNode.doNull(operandNodeValue);
            }
            if ((JSGuards.isUndefined(operandNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return JSToBooleanUnaryNode.doUndefined(operandNodeValue);
            }
            if (operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doInt(int) */;
                lock.unlock();
                hasLock = false;
                return JSToBooleanUnaryNode.doInt(operandNodeValue_);
            }
            if (operandNodeValue instanceof Long) {
                long operandNodeValue_ = (long) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doLong(long) */;
                lock.unlock();
                hasLock = false;
                return JSToBooleanUnaryNode.doLong(operandNodeValue_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    state_0 = (state_0 | (doubleCast0 << 12) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return JSToBooleanUnaryNode.doDouble(operandNodeValue_);
                }
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return JSToBooleanUnaryNode.doBigInt(operandNodeValue_);
            }
            if (operandNodeValue instanceof JSLazyString) {
                JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doLazyString(JSLazyString) */;
                lock.unlock();
                hasLock = false;
                return JSToBooleanUnaryNode.doLazyString(operandNodeValue_);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(operandNodeValue)) != 0) {
                    String operandNodeValue_ = JSTypesGen.asImplicitString(stringCast0, operandNodeValue);
                    state_0 = (state_0 | (stringCast0 << 16) /* set-implicit-state_0 0:String */);
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return JSToBooleanUnaryNode.doString(operandNodeValue_);
                }
            }
            if ((JSGuards.isJSObject(operandNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doObject(Object) */;
                lock.unlock();
                hasLock = false;
                return JSToBooleanUnaryNode.doObject(operandNodeValue);
            }
            if (operandNodeValue instanceof Symbol) {
                Symbol operandNodeValue_ = (Symbol) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return JSToBooleanUnaryNode.doSymbol(operandNodeValue_);
            }
            if ((JSGuards.isForeignObject(operandNodeValue))) {
                this.foreignObject_toBooleanNode_ = super.insert((JSToBooleanNode.create()));
                this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doForeignObject(Object, JSToBooleanNode) */;
                lock.unlock();
                hasLock = false;
                return JSToBooleanUnaryNode.doForeignObject(operandNodeValue, this.foreignObject_toBooleanNode_);
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
        if ((state_0 & 0b111111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b111111111111) & ((state_0 & 0b111111111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[13];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doNull";
        if ((state_0 & 0b10) != 0 /* is-state_0 doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state_0 & 0b100) != 0 /* is-state_0 doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doLazyString";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doLazyString(JSLazyString) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doString(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doForeignObject(Object, JSToBooleanNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.foreignObject_toBooleanNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        return Provider.create(data);
    }

    public static JSToBooleanUnaryNode create(JavaScriptNode operand) {
        return new JSToBooleanUnaryNodeGen(operand);
    }

}
