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
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToNumberNode.class)
public final class JSToNumberNodeGen extends JSToNumberNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private JSToPrimitiveNode jSObject_toPrimitiveNode_;
    @Child private JSToPrimitiveNode foreignObject_toPrimitiveNode_;

    private JSToNumberNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return JSToNumberNode.doInteger(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return JSToNumberNode.doBoolean(arg0Value_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000000000) >>> 11 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000000000) >>> 11 /* extract-implicit-state_0 0:double */, arg0Value);
            return JSToNumberNode.doDouble(arg0Value_);
        }
        if ((state_0 & 0b11000) != 0 /* is-state_0 doNull(Object) || doUndefined(Object) */) {
            if ((state_0 & 0b1000) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(arg0Value))) {
                    return JSToNumberNode.doNull(arg0Value);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return JSToNumberNode.doUndefined(arg0Value);
                }
            }
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doString(String) */ && JSTypesGen.isImplicitString((state_0 & 0x38000) >>> 15 /* extract-implicit-state_0 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state_0 & 0x38000) >>> 15 /* extract-implicit-state_0 0:String */, arg0Value);
            return doString(arg0Value_);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doJSObject(DynamicObject, JSToPrimitiveNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSObject(arg0Value_))) {
                return doJSObject(arg0Value_, this.jSObject_toPrimitiveNode_);
            }
        }
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state_0 & 0b11000000000) != 0 /* is-state_0 doForeignObject(Object, JSToPrimitiveNode) || doJavaObject(Object) */) {
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doForeignObject(Object, JSToPrimitiveNode) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return doForeignObject(arg0Value, this.foreignObject_toPrimitiveNode_);
                }
            }
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doJavaObject(Object) */) {
                if ((JSGuards.isJavaNumber(arg0Value))) {
                    return JSToNumberNode.doJavaObject(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInteger(int) */;
                lock.unlock();
                hasLock = false;
                return JSToNumberNode.doInteger(arg0Value_);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return JSToNumberNode.doBoolean(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state_0 = (state_0 | (doubleCast0 << 11) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return JSToNumberNode.doDouble(arg0Value_);
                }
            }
            if ((JSGuards.isJSNull(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return JSToNumberNode.doNull(arg0Value);
            }
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return JSToNumberNode.doUndefined(arg0Value);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    state_0 = (state_0 | (stringCast0 << 15) /* set-implicit-state_0 0:String */);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_);
                }
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSObject(arg0Value_))) {
                    this.jSObject_toPrimitiveNode_ = super.insert((JSToPrimitiveNode.createHintNumber()));
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doJSObject(DynamicObject, JSToPrimitiveNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(arg0Value_, this.jSObject_toPrimitiveNode_);
                }
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(arg0Value_);
            }
            if ((JSGuards.isForeignObject(arg0Value))) {
                this.foreignObject_toPrimitiveNode_ = super.insert((JSToPrimitiveNode.createHintNumber()));
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doForeignObject(Object, JSToPrimitiveNode) */;
                lock.unlock();
                hasLock = false;
                return doForeignObject(arg0Value, this.foreignObject_toPrimitiveNode_);
            }
            if ((JSGuards.isJavaNumber(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doJavaObject(Object) */;
                lock.unlock();
                hasLock = false;
                return JSToNumberNode.doJavaObject(arg0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b11111111111) & ((state_0 & 0b11111111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[12];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state_0 & 0b10) != 0 /* is-state_0 doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doNull";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doString(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doJSObject(DynamicObject, JSToPrimitiveNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSObject_toPrimitiveNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doForeignObject(Object, JSToPrimitiveNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.foreignObject_toPrimitiveNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doJavaObject";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doJavaObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        return Provider.create(data);
    }

    public static JSToNumberNode create() {
        return new JSToNumberNodeGen();
    }

    @GeneratedBy(JSToNumberUnaryNode.class)
    public static final class JSToNumberUnaryNodeGen extends JSToNumberUnaryNode implements Introspection.Provider {

        private JSToNumberUnaryNodeGen(JavaScriptNode operand) {
            super(operand);
        }

        @Override
        public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
            return doDefault(operandNodeValue);
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object operandNodeValue_ = super.operandNode.execute(frameValue);
            return doDefault(operandNodeValue_);
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
            s[0] = "doDefault";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSToNumberUnaryNode create(JavaScriptNode operand) {
            return new JSToNumberUnaryNodeGen(operand);
        }

    }
}
