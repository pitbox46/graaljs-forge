// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToIntegerAsIntNode.class)
public final class JSToIntegerAsIntNodeGen extends JSToIntegerAsIntNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private JSToIntegerAsIntNode string_nestedToIntegerNode_;
    @Child private JSStringToNumberNode string_stringToNumberNode_;

    private JSToIntegerAsIntNodeGen() {
    }

    @Override
    public int executeInt(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return JSToIntegerAsIntNode.doInteger(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return JSToIntegerAsIntNode.doBoolean(arg0Value_);
        }
        if ((state_0 & 0b1100) != 0 /* is-state_0 doSafeIntegerInt32Range(SafeInteger) || doSafeIntegerOther(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            if ((state_0 & 0b100) != 0 /* is-state_0 doSafeIntegerInt32Range(SafeInteger) */) {
                if ((JSGuards.isLongRepresentableAsInt32(arg0Value_.longValue()))) {
                    return JSToIntegerAsIntNode.doSafeIntegerInt32Range(arg0Value_);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeIntegerOther(SafeInteger) */) {
                if ((!(JSGuards.isLongRepresentableAsInt32(arg0Value_.longValue())))) {
                    return JSToIntegerAsIntNode.doSafeIntegerOther(arg0Value_);
                }
            }
        }
        if ((state_0 & 0b110000) != 0 /* is-state_0 doDoubleInt32Range(double) || doDoubleOther(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x1e000) >>> 13 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0x1e000) >>> 13 /* extract-implicit-state_0 0:double */, arg0Value);
            if ((state_0 & 0b10000) != 0 /* is-state_0 doDoubleInt32Range(double) */) {
                if ((JSToIntegerAsIntNode.inInt32Range(arg0Value_))) {
                    return JSToIntegerAsIntNode.doDoubleInt32Range(arg0Value_);
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doDoubleOther(double) */) {
                if ((!(JSToIntegerAsIntNode.inInt32Range(arg0Value_)))) {
                    return JSToIntegerAsIntNode.doDoubleOther(arg0Value_);
                }
            }
        }
        if ((state_0 & 0b11000000) != 0 /* is-state_0 doUndefined(Object) || doNull(Object) */) {
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return JSToIntegerAsIntNode.doUndefined(arg0Value);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(arg0Value))) {
                    return JSToIntegerAsIntNode.doNull(arg0Value);
                }
            }
        }
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doString(String, JSToIntegerAsIntNode, JSStringToNumberNode) */ && JSTypesGen.isImplicitString((state_0 & 0xe0000) >>> 17 /* extract-implicit-state_0 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state_0 & 0xe0000) >>> 17 /* extract-implicit-state_0 0:String */, arg0Value);
            return doString(arg0Value_, this.string_nestedToIntegerNode_, this.string_stringToNumberNode_);
        }
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doJSObject(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSObject(arg0Value_))) {
                return doJSObject(arg0Value_);
            }
        }
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doForeignObject(Object) */) {
            if ((JSGuards.isForeignObject(arg0Value))) {
                return doForeignObject(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private int executeAndSpecialize(Object arg0Value) {
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
                return JSToIntegerAsIntNode.doInteger(arg0Value_);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return JSToIntegerAsIntNode.doBoolean(arg0Value_);
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                if ((JSGuards.isLongRepresentableAsInt32(arg0Value_.longValue()))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doSafeIntegerInt32Range(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return JSToIntegerAsIntNode.doSafeIntegerInt32Range(arg0Value_);
                }
                if ((!(JSGuards.isLongRepresentableAsInt32(arg0Value_.longValue())))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doSafeIntegerOther(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return JSToIntegerAsIntNode.doSafeIntegerOther(arg0Value_);
                }
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    if ((JSToIntegerAsIntNode.inInt32Range(arg0Value_))) {
                        state_0 = (state_0 | (doubleCast0 << 13) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doDoubleInt32Range(double) */;
                        lock.unlock();
                        hasLock = false;
                        return JSToIntegerAsIntNode.doDoubleInt32Range(arg0Value_);
                    }
                    if ((!(JSToIntegerAsIntNode.inInt32Range(arg0Value_)))) {
                        state_0 = (state_0 | (doubleCast0 << 13) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doDoubleOther(double) */;
                        lock.unlock();
                        hasLock = false;
                        return JSToIntegerAsIntNode.doDoubleOther(arg0Value_);
                    }
                }
            }
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return JSToIntegerAsIntNode.doUndefined(arg0Value);
            }
            if ((JSGuards.isJSNull(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return JSToIntegerAsIntNode.doNull(arg0Value);
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(arg0Value_);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    this.string_nestedToIntegerNode_ = super.insert((JSToIntegerAsIntNode.create()));
                    this.string_stringToNumberNode_ = super.insert((JSStringToNumberNode.create()));
                    state_0 = (state_0 | (stringCast0 << 17) /* set-implicit-state_0 0:String */);
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doString(String, JSToIntegerAsIntNode, JSStringToNumberNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_, this.string_nestedToIntegerNode_, this.string_stringToNumberNode_);
                }
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSObject(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doJSObject(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(arg0Value_);
                }
            }
            if ((JSGuards.isForeignObject(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doForeignObject(Object) */;
                lock.unlock();
                hasLock = false;
                return doForeignObject(arg0Value);
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
        if ((state_0 & 0b1111111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111111111111) & ((state_0 & 0b1111111111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[14];
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
        s[0] = "doSafeIntegerInt32Range";
        if ((state_0 & 0b100) != 0 /* is-state_0 doSafeIntegerInt32Range(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doSafeIntegerOther";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeIntegerOther(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDoubleInt32Range";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doDoubleInt32Range(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doDoubleOther";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doDoubleOther(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doNull";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doString(String, JSToIntegerAsIntNode, JSStringToNumberNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.string_nestedToIntegerNode_, this.string_stringToNumberNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doJSObject(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doForeignObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        return Provider.create(data);
    }

    public static JSToIntegerAsIntNode create() {
        return new JSToIntegerAsIntNodeGen();
    }

}
