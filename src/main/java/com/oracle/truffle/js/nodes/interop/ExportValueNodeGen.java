// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.builtins.JSFunction;
import com.oracle.truffle.js.runtime.builtins.JSFunctionObject;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ExportValueNode.class)
public final class ExportValueNodeGen extends ExportValueNode implements Introspection.Provider {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private int state_0_;
    @CompilationFinal private int exclude_;

    private ExportValueNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value, Object arg1Value, boolean arg2Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1111111111111111) != 0 /* is-state_0 doFunctionNoBind(JSFunctionObject, Object, boolean) || doFunctionUndefinedThis(JSFunctionObject, Object, boolean) || doBindUnboundFunction(JSFunctionObject, Object, boolean) || doBoundFunction(JSFunctionObject, Object, boolean) || doAsyncFunction(JSFunctionObject, Object, boolean) || doSafeInteger(SafeInteger, Object, boolean) || doObject(DynamicObject, Object, boolean) || doInt(int, Object, boolean) || doLong(long, Object, boolean) || doFloat(float, Object, boolean) || doDouble(double, Object, boolean) || doBoolean(boolean, Object, boolean) || doBigInt(BigInt, Object, boolean) || doString(String, Object, boolean) || doTruffleObject(TruffleObject, Object, boolean) || doOther(Object, Object, boolean) */) {
            if ((state_0 & 0b11111) != 0 /* is-state_0 doFunctionNoBind(JSFunctionObject, Object, boolean) || doFunctionUndefinedThis(JSFunctionObject, Object, boolean) || doBindUnboundFunction(JSFunctionObject, Object, boolean) || doBoundFunction(JSFunctionObject, Object, boolean) || doAsyncFunction(JSFunctionObject, Object, boolean) */ && arg0Value instanceof JSFunctionObject) {
                JSFunctionObject arg0Value_ = (JSFunctionObject) arg0Value;
                if ((state_0 & 0b1) != 0 /* is-state_0 doFunctionNoBind(JSFunctionObject, Object, boolean) */) {
                    if ((!(arg2Value)) && (!(isInteropCompletePromises()) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                        return ExportValueNode.doFunctionNoBind(arg0Value_, arg1Value, arg2Value);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doFunctionUndefinedThis(JSFunctionObject, Object, boolean) */) {
                    if ((arg2Value) && (JSGuards.isUndefined(arg1Value)) && (!(isInteropCompletePromises()) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                        return ExportValueNode.doFunctionUndefinedThis(arg0Value_, arg1Value, arg2Value);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doBindUnboundFunction(JSFunctionObject, Object, boolean) */) {
                    if ((arg2Value) && (!(JSGuards.isUndefined(arg1Value))) && (!(JSGuards.isBoundJSFunction(arg0Value_))) && (!(isInteropCompletePromises()) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                        return ExportValueNode.doBindUnboundFunction(arg0Value_, arg1Value, arg2Value);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doBoundFunction(JSFunctionObject, Object, boolean) */) {
                    if ((arg2Value) && (JSGuards.isBoundJSFunction(arg0Value_)) && (!(isInteropCompletePromises()) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                        return ExportValueNode.doBoundFunction(arg0Value_, arg1Value, arg2Value);
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doAsyncFunction(JSFunctionObject, Object, boolean) */) {
                    assert (isInteropCompletePromises());
                    if ((JSFunction.isAsyncFunction(arg0Value_))) {
                        return ExportValueNode.doAsyncFunction(arg0Value_, arg1Value, arg2Value);
                    }
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doSafeInteger(SafeInteger, Object, boolean) */ && arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                return ExportValueNode.doSafeInteger(arg0Value_, arg1Value, arg2Value);
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doObject(DynamicObject, Object, boolean) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((!(JSGuards.isJSFunction(arg0Value_)))) {
                    return ExportValueNode.doObject(arg0Value_, arg1Value, arg2Value);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doInt(int, Object, boolean) */ && arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                return ExportValueNode.doInt(arg0Value_, arg1Value, arg2Value);
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doLong(long, Object, boolean) */ && arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                return ExportValueNode.doLong(arg0Value_, arg1Value, arg2Value);
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doFloat(float, Object, boolean) */ && arg0Value instanceof Float) {
                float arg0Value_ = (float) arg0Value;
                return ExportValueNode.doFloat(arg0Value_, arg1Value, arg2Value);
            }
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doDouble(double, Object, boolean) */ && JSTypesGen.isImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, arg0Value)) {
                double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0xf0000) >>> 16 /* extract-implicit-state_0 0:double */, arg0Value);
                return ExportValueNode.doDouble(arg0Value_, arg1Value, arg2Value);
            }
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doBoolean(boolean, Object, boolean) */ && arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                return ExportValueNode.doBoolean(arg0Value_, arg1Value, arg2Value);
            }
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doBigInt(BigInt, Object, boolean) */ && arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                return ExportValueNode.doBigInt(arg0Value_, arg1Value, arg2Value);
            }
            if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doString(String, Object, boolean) */ && JSTypesGen.isImplicitString((state_0 & 0x700000) >>> 20 /* extract-implicit-state_0 0:String */, arg0Value)) {
                String arg0Value_ = JSTypesGen.asImplicitString((state_0 & 0x700000) >>> 20 /* extract-implicit-state_0 0:String */, arg0Value);
                return ExportValueNode.doString(arg0Value_, arg1Value, arg2Value);
            }
            if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doTruffleObject(TruffleObject, Object, boolean) */ && arg0Value instanceof TruffleObject) {
                TruffleObject arg0Value_ = (TruffleObject) arg0Value;
                if ((!(JSGuards.isJSFunction(arg0Value_)))) {
                    return ExportValueNode.doTruffleObject(arg0Value_, arg1Value, arg2Value);
                }
            }
            if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doOther(Object, Object, boolean) */) {
                if ((!(JSGuards.isTruffleObject(arg1Value))) && (!(JSGuards.isString(arg1Value))) && (!(JSGuards.isBoolean(arg1Value))) && (!(JSGuards.isNumberDouble(arg1Value))) && (!(JSGuards.isNumberLong(arg1Value))) && (!(JSGuards.isNumberInteger(arg1Value)))) {
                    return ExportValueNode.doOther(arg0Value, arg1Value, arg2Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private Object executeAndSpecialize(Object arg0Value, Object arg1Value, boolean arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (arg0Value instanceof JSFunctionObject) {
                JSFunctionObject arg0Value_ = (JSFunctionObject) arg0Value;
                if ((!(arg2Value)) && (!(isInteropCompletePromises()) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doFunctionNoBind(JSFunctionObject, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doFunctionNoBind(arg0Value_, arg1Value, arg2Value);
                }
                if ((arg2Value) && (JSGuards.isUndefined(arg1Value)) && (!(isInteropCompletePromises()) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doFunctionUndefinedThis(JSFunctionObject, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doFunctionUndefinedThis(arg0Value_, arg1Value, arg2Value);
                }
                if ((arg2Value) && (!(JSGuards.isUndefined(arg1Value))) && (!(JSGuards.isBoundJSFunction(arg0Value_))) && (!(isInteropCompletePromises()) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doBindUnboundFunction(JSFunctionObject, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doBindUnboundFunction(arg0Value_, arg1Value, arg2Value);
                }
                if ((arg2Value) && (JSGuards.isBoundJSFunction(arg0Value_)) && (!(isInteropCompletePromises()) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doBoundFunction(JSFunctionObject, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doBoundFunction(arg0Value_, arg1Value, arg2Value);
                }
                if ((isInteropCompletePromises()) && (JSFunction.isAsyncFunction(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doAsyncFunction(JSFunctionObject, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doAsyncFunction(arg0Value_, arg1Value, arg2Value);
                }
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doSafeInteger(SafeInteger, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doSafeInteger(arg0Value_, arg1Value, arg2Value);
            }
            if ((exclude) == 0 /* is-not-exclude doObject(DynamicObject, Object, boolean) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((!(JSGuards.isJSFunction(arg0Value_)))) {
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doObject(DynamicObject, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doObject(arg0Value_, arg1Value, arg2Value);
                }
            }
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doInt(int, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doInt(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doLong(long, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doLong(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof Float) {
                float arg0Value_ = (float) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doFloat(float, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doFloat(arg0Value_, arg1Value, arg2Value);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state_0 = (state_0 | (doubleCast0 << 16) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doDouble(double, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doDouble(arg0Value_, arg1Value, arg2Value);
                }
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doBoolean(boolean, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doBoolean(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doBigInt(BigInt, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doBigInt(arg0Value_, arg1Value, arg2Value);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    state_0 = (state_0 | (stringCast0 << 20) /* set-implicit-state_0 0:String */);
                    this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 doString(String, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doString(arg0Value_, arg1Value, arg2Value);
                }
            }
            if (arg0Value instanceof TruffleObject) {
                TruffleObject arg0Value_ = (TruffleObject) arg0Value;
                if ((!(JSGuards.isJSFunction(arg0Value_)))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doObject(DynamicObject, Object, boolean) */;
                    state_0 = state_0 & 0xffffffbf /* remove-state_0 doObject(DynamicObject, Object, boolean) */;
                    this.state_0_ = state_0 = state_0 | 0b100000000000000 /* add-state_0 doTruffleObject(TruffleObject, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doTruffleObject(arg0Value_, arg1Value, arg2Value);
                }
            }
            if ((!(JSGuards.isTruffleObject(arg1Value))) && (!(JSGuards.isString(arg1Value))) && (!(JSGuards.isBoolean(arg1Value))) && (!(JSGuards.isNumberDouble(arg1Value))) && (!(JSGuards.isNumberLong(arg1Value))) && (!(JSGuards.isNumberInteger(arg1Value)))) {
                this.state_0_ = state_0 = state_0 | 0b1000000000000000 /* add-state_0 doOther(Object, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doOther(arg0Value, arg1Value, arg2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1111111111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111111111111111) & ((state_0 & 0b1111111111111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[17];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doFunctionNoBind";
        if ((state_0 & 0b1) != 0 /* is-state_0 doFunctionNoBind(JSFunctionObject, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doFunctionUndefinedThis";
        if ((state_0 & 0b10) != 0 /* is-state_0 doFunctionUndefinedThis(JSFunctionObject, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doBindUnboundFunction";
        if ((state_0 & 0b100) != 0 /* is-state_0 doBindUnboundFunction(JSFunctionObject, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBoundFunction";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doBoundFunction(JSFunctionObject, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doAsyncFunction";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doAsyncFunction(JSFunctionObject, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doSafeInteger(SafeInteger, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doObject(DynamicObject, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else if (exclude != 0 /* is-exclude doObject(DynamicObject, Object, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doInt(int, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doLong(long, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doFloat";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doFloat(float, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doDouble(double, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doBoolean(boolean, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doBigInt(BigInt, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doString(String, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        s = new Object[3];
        s[0] = "doTruffleObject";
        if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doTruffleObject(TruffleObject, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[15] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doOther(Object, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[16] = s;
        return Provider.create(data);
    }

    public static ExportValueNode create() {
        return new ExportValueNodeGen();
    }

    public static ExportValueNode getUncached() {
        return ExportValueNodeGen.UNCACHED;
    }

    @GeneratedBy(ExportValueNode.class)
    private static final class Uncached extends ExportValueNode {

        @TruffleBoundary
        @Override
        public Object execute(Object arg0Value, Object arg1Value, boolean arg2Value) {
            if (arg0Value instanceof JSFunctionObject) {
                JSFunctionObject arg0Value_ = (JSFunctionObject) arg0Value;
                if ((!(arg2Value)) && (!(isInteropCompletePromises()) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                    return ExportValueNode.doFunctionNoBind(arg0Value_, arg1Value, arg2Value);
                }
                if ((arg2Value) && (JSGuards.isUndefined(arg1Value)) && (!(isInteropCompletePromises()) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                    return ExportValueNode.doFunctionUndefinedThis(arg0Value_, arg1Value, arg2Value);
                }
                if ((arg2Value) && (!(JSGuards.isUndefined(arg1Value))) && (!(JSGuards.isBoundJSFunction(arg0Value_))) && (!(isInteropCompletePromises()) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                    return ExportValueNode.doBindUnboundFunction(arg0Value_, arg1Value, arg2Value);
                }
                if ((arg2Value) && (JSGuards.isBoundJSFunction(arg0Value_)) && (!(isInteropCompletePromises()) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                    return ExportValueNode.doBoundFunction(arg0Value_, arg1Value, arg2Value);
                }
                if ((isInteropCompletePromises()) && (JSFunction.isAsyncFunction(arg0Value_))) {
                    return ExportValueNode.doAsyncFunction(arg0Value_, arg1Value, arg2Value);
                }
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                return ExportValueNode.doSafeInteger(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                return ExportValueNode.doInt(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                return ExportValueNode.doLong(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof Float) {
                float arg0Value_ = (float) arg0Value;
                return ExportValueNode.doFloat(arg0Value_, arg1Value, arg2Value);
            }
            if (JSTypesGen.isImplicitDouble(arg0Value)) {
                double arg0Value_ = JSTypesGen.asImplicitDouble(arg0Value);
                return ExportValueNode.doDouble(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                return ExportValueNode.doBoolean(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                return ExportValueNode.doBigInt(arg0Value_, arg1Value, arg2Value);
            }
            if (JSTypesGen.isImplicitString(arg0Value)) {
                String arg0Value_ = JSTypesGen.asImplicitString(arg0Value);
                return ExportValueNode.doString(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof TruffleObject) {
                TruffleObject arg0Value_ = (TruffleObject) arg0Value;
                if ((!(JSGuards.isJSFunction(arg0Value_)))) {
                    return ExportValueNode.doTruffleObject(arg0Value_, arg1Value, arg2Value);
                }
            }
            if ((!(JSGuards.isTruffleObject(arg1Value))) && (!(JSGuards.isString(arg1Value))) && (!(JSGuards.isBoolean(arg1Value))) && (!(JSGuards.isNumberDouble(arg1Value))) && (!(JSGuards.isNumberLong(arg1Value))) && (!(JSGuards.isNumberInteger(arg1Value)))) {
                return ExportValueNode.doOther(arg0Value, arg1Value, arg2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
}
