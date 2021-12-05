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
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.JSProxyHasPropertyNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InNode.class)
public final class InNodeGen extends InNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private JSProxyHasPropertyNode proxy_proxyHasPropertyNode_;

    private InNodeGen(JSContext context, JavaScriptNode left, JavaScriptNode right) {
        super(context, left, right);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b111111111) != 0 /* is-state_0 doObject(Object, DynamicObject) || doProxy(Object, DynamicObject, JSProxyHasPropertyNode) || doForeign(Object, Object) || doNullOrUndefined(Object, Object) || doSymbol(Object, Symbol) || doString(Object, String) || doSafeInteger(Object, SafeInteger) || doBigInt(Object, BigInt) || doNotTruffleObject(Object, Object) */) {
            if ((state_0 & 0b11) != 0 /* is-state_0 doObject(Object, DynamicObject) || doProxy(Object, DynamicObject, JSProxyHasPropertyNode) */ && JSTypes.isDynamicObject(rightNodeValue_)) {
                DynamicObject rightNodeValue__ = (DynamicObject) rightNodeValue_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doObject(Object, DynamicObject) */) {
                    if ((JSGuards.isJSObject(rightNodeValue__)) && (!(JSGuards.isJSProxy(rightNodeValue__)))) {
                        return doObject(leftNodeValue_, rightNodeValue__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doProxy(Object, DynamicObject, JSProxyHasPropertyNode) */) {
                    if ((JSGuards.isJSProxy(rightNodeValue__))) {
                        return doProxy(leftNodeValue_, rightNodeValue__, this.proxy_proxyHasPropertyNode_);
                    }
                }
            }
            if ((state_0 & 0b1100) != 0 /* is-state_0 doForeign(Object, Object) || doNullOrUndefined(Object, Object) */) {
                if ((state_0 & 0b100) != 0 /* is-state_0 doForeign(Object, Object) */) {
                    if ((JSGuards.isForeignObject(rightNodeValue_))) {
                        return doForeign(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doNullOrUndefined(Object, Object) */) {
                    if ((JSGuards.isNullOrUndefined(rightNodeValue_))) {
                        return InNode.doNullOrUndefined(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doSymbol(Object, Symbol) */ && rightNodeValue_ instanceof Symbol) {
                Symbol rightNodeValue__ = (Symbol) rightNodeValue_;
                return InNode.doSymbol(leftNodeValue_, rightNodeValue__);
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doString(Object, String) */ && JSTypesGen.isImplicitString((state_0 & 0b111000000000) >>> 9 /* extract-implicit-state_0 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0b111000000000) >>> 9 /* extract-implicit-state_0 1:String */, rightNodeValue_);
                return InNode.doString(leftNodeValue_, rightNodeValue__);
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doSafeInteger(Object, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
                SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
                return InNode.doSafeInteger(leftNodeValue_, rightNodeValue__);
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt(Object, BigInt) */ && rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return InNode.doBigInt(leftNodeValue_, rightNodeValue__);
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doNotTruffleObject(Object, Object) */) {
                if ((!(JSGuards.isTruffleObject(rightNodeValue_)))) {
                    return InNode.doNotTruffleObject(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111111000) != 0 /* is-state_0 doNullOrUndefined(Object, Object) || doSymbol(Object, Symbol) || doString(Object, String) || doSafeInteger(Object, SafeInteger) || doBigInt(Object, BigInt) || doNotTruffleObject(Object, Object) */) {
            return JSTypesGen.expectBoolean(execute(frameValue));
        }
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state_0 & 0b111) != 0 /* is-state_0 doObject(Object, DynamicObject) || doProxy(Object, DynamicObject, JSProxyHasPropertyNode) || doForeign(Object, Object) */) {
            if ((state_0 & 0b11) != 0 /* is-state_0 doObject(Object, DynamicObject) || doProxy(Object, DynamicObject, JSProxyHasPropertyNode) */ && JSTypes.isDynamicObject(rightNodeValue_)) {
                DynamicObject rightNodeValue__ = (DynamicObject) rightNodeValue_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doObject(Object, DynamicObject) */) {
                    if ((JSGuards.isJSObject(rightNodeValue__)) && (!(JSGuards.isJSProxy(rightNodeValue__)))) {
                        return doObject(leftNodeValue_, rightNodeValue__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doProxy(Object, DynamicObject, JSProxyHasPropertyNode) */) {
                    if ((JSGuards.isJSProxy(rightNodeValue__))) {
                        return doProxy(leftNodeValue_, rightNodeValue__, this.proxy_proxyHasPropertyNode_);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doForeign(Object, Object) */) {
                if ((JSGuards.isForeignObject(rightNodeValue_))) {
                    return doForeign(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectBoolean(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b111111000) == 0 /* only-active doObject(Object, DynamicObject) && doProxy(Object, DynamicObject, JSProxyHasPropertyNode) && doForeign(Object, Object) */ && ((state_0 & 0b111111111) != 0  /* is-not doObject(Object, DynamicObject) && doProxy(Object, DynamicObject, JSProxyHasPropertyNode) && doForeign(Object, Object) && doNullOrUndefined(Object, Object) && doSymbol(Object, Symbol) && doString(Object, String) && doSafeInteger(Object, SafeInteger) && doBigInt(Object, BigInt) && doNotTruffleObject(Object, Object) */)) {
                executeBoolean(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Object leftNodeValue, Object rightNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(rightNodeValue)) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                if ((JSGuards.isJSObject(rightNodeValue_)) && (!(JSGuards.isJSProxy(rightNodeValue_)))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doObject(Object, DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doObject(leftNodeValue, rightNodeValue_);
                }
                if ((JSGuards.isJSProxy(rightNodeValue_))) {
                    this.proxy_proxyHasPropertyNode_ = super.insert((JSProxyHasPropertyNode.create(context)));
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doProxy(Object, DynamicObject, JSProxyHasPropertyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doProxy(leftNodeValue, rightNodeValue_, this.proxy_proxyHasPropertyNode_);
                }
            }
            if ((JSGuards.isForeignObject(rightNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doForeign(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return doForeign(leftNodeValue, rightNodeValue);
            }
            if ((JSGuards.isNullOrUndefined(rightNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doNullOrUndefined(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return InNode.doNullOrUndefined(leftNodeValue, rightNodeValue);
            }
            if (rightNodeValue instanceof Symbol) {
                Symbol rightNodeValue_ = (Symbol) rightNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doSymbol(Object, Symbol) */;
                lock.unlock();
                hasLock = false;
                return InNode.doSymbol(leftNodeValue, rightNodeValue_);
            }
            {
                int stringCast1;
                if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                    String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                    state_0 = (state_0 | (stringCast1 << 9) /* set-implicit-state_0 1:String */);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doString(Object, String) */;
                    lock.unlock();
                    hasLock = false;
                    return InNode.doString(leftNodeValue, rightNodeValue_);
                }
            }
            if (rightNodeValue instanceof SafeInteger) {
                SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doSafeInteger(Object, SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return InNode.doSafeInteger(leftNodeValue, rightNodeValue_);
            }
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doBigInt(Object, BigInt) */;
                lock.unlock();
                hasLock = false;
                return InNode.doBigInt(leftNodeValue, rightNodeValue_);
            }
            if ((!(JSGuards.isTruffleObject(rightNodeValue)))) {
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doNotTruffleObject(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return InNode.doNotTruffleObject(leftNodeValue, rightNodeValue);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.leftNode, super.rightNode}, leftNodeValue, rightNodeValue);
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
        s[0] = "doObject";
        if ((state_0 & 0b1) != 0 /* is-state_0 doObject(Object, DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doProxy";
        if ((state_0 & 0b10) != 0 /* is-state_0 doProxy(Object, DynamicObject, JSProxyHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.proxy_proxyHasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doForeign";
        if ((state_0 & 0b100) != 0 /* is-state_0 doForeign(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doNullOrUndefined";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doNullOrUndefined(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doSymbol(Object, Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doString(Object, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doSafeInteger(Object, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doBigInt(Object, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doNotTruffleObject";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doNotTruffleObject(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        return Provider.create(data);
    }

    public static InNode create(JSContext context, JavaScriptNode left, JavaScriptNode right) {
        return new InNodeGen(context, left, right);
    }

}
