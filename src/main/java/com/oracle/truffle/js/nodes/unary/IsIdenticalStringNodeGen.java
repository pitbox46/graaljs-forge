// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsIdenticalStringNode.class)
public final class IsIdenticalStringNodeGen extends IsIdenticalStringNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private ConditionProfile lazyString_flatten_;
    @CompilationFinal private ConditionProfile lazyString_len_;

    private IsIdenticalStringNodeGen(String string, JavaScriptNode operand, boolean leftConstant) {
        super(string, operand, leftConstant);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doLazyString(JSLazyString, ConditionProfile, ConditionProfile) */ && operandNodeValue instanceof JSLazyString) {
            JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
            return doLazyString(operandNodeValue_, this.lazyString_flatten_, this.lazyString_len_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doString(String) */ && JSTypesGen.isImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, operandNodeValue)) {
            String operandNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, operandNodeValue);
            return doString(operandNodeValue_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doOther(Object) */) {
            if (fallbackGuard_(operandNodeValue)) {
                return doOther(operandNodeValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doLazyString(JSLazyString, ConditionProfile, ConditionProfile) */ && operandNodeValue_ instanceof JSLazyString) {
            JSLazyString operandNodeValue__ = (JSLazyString) operandNodeValue_;
            return doLazyString(operandNodeValue__, this.lazyString_flatten_, this.lazyString_len_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doString(String) */ && JSTypesGen.isImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, operandNodeValue_)) {
            String operandNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, operandNodeValue_);
            return doString(operandNodeValue__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doOther(Object) */) {
            if (fallbackGuard_(operandNodeValue_)) {
                return doOther(operandNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doLazyString(JSLazyString, ConditionProfile, ConditionProfile) */ && operandNodeValue_ instanceof JSLazyString) {
            JSLazyString operandNodeValue__ = (JSLazyString) operandNodeValue_;
            return doLazyString(operandNodeValue__, this.lazyString_flatten_, this.lazyString_len_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doString(String) */ && JSTypesGen.isImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, operandNodeValue_)) {
            String operandNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0b111000) >>> 3 /* extract-implicit-state_0 0:String */, operandNodeValue_);
            return doString(operandNodeValue__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doOther(Object) */) {
            if (fallbackGuard_(operandNodeValue_)) {
                return doOther(operandNodeValue_);
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
            if (operandNodeValue instanceof JSLazyString) {
                JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
                this.lazyString_flatten_ = (ConditionProfile.createBinaryProfile());
                this.lazyString_len_ = (ConditionProfile.createBinaryProfile());
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doLazyString(JSLazyString, ConditionProfile, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doLazyString(operandNodeValue_, this.lazyString_flatten_, this.lazyString_len_);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(operandNodeValue)) != 0) {
                    String operandNodeValue_ = JSTypesGen.asImplicitString(stringCast0, operandNodeValue);
                    state_0 = (state_0 | (stringCast0 << 3) /* set-implicit-state_0 0:String */);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(operandNodeValue_);
                }
            }
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doOther(Object) */;
            lock.unlock();
            hasLock = false;
            return doOther(operandNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doLazyString";
        if ((state_0 & 0b1) != 0 /* is-state_0 doLazyString(JSLazyString, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.lazyString_flatten_, this.lazyString_len_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b10) != 0 /* is-state_0 doString(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state_0 & 0b100) != 0 /* is-state_0 doOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(Object operandNodeValue) {
        if (JSTypesGen.isImplicitString(operandNodeValue)) {
            return false;
        }
        return true;
    }

    public static IsIdenticalStringNode create(String string, JavaScriptNode operand, boolean leftConstant) {
        return new IsIdenticalStringNodeGen(string, operand, leftConstant);
    }

}
