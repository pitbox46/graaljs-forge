// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSProxyPropertySetNode.class)
public final class JSProxyPropertySetNodeGen extends JSProxyPropertySetNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private ConditionProfile hasTrap_;
    @CompilationFinal private JSClassProfile targetClassProfile_;

    private JSProxyPropertySetNodeGen(JSContext context, boolean isStrict) {
        super(context, isStrict);
    }

    @Override
    public boolean executeWithReceiverAndValue(Object arg0Value, Object arg1Value, Object arg2Value, Object arg3Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doGeneric(DynamicObject, Object, Object, Object, ConditionProfile, JSClassProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            return doGeneric(arg0Value_, arg1Value, arg2Value, arg3Value, this.hasTrap_, this.targetClassProfile_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
    }

    @Override
    public boolean executeWithReceiverAndValueInt(Object arg0Value, Object arg1Value, int arg2Value, Object arg3Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doGeneric(DynamicObject, Object, Object, Object, ConditionProfile, JSClassProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            return doGeneric(arg0Value_, arg1Value, arg2Value, arg3Value, this.hasTrap_, this.targetClassProfile_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
    }

    private boolean executeAndSpecialize(Object arg0Value, Object arg1Value, Object arg2Value, Object arg3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                this.hasTrap_ = (ConditionProfile.createBinaryProfile());
                this.targetClassProfile_ = (JSClassProfile.create());
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doGeneric(DynamicObject, Object, Object, Object, ConditionProfile, JSClassProfile) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(arg0Value_, arg1Value, arg2Value, arg3Value, this.hasTrap_, this.targetClassProfile_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
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
        if (state_0 != 0 /* is-state_0 doGeneric(DynamicObject, Object, Object, Object, ConditionProfile, JSClassProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.hasTrap_, this.targetClassProfile_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static JSProxyPropertySetNode create(JSContext context, boolean isStrict) {
        return new JSProxyPropertySetNodeGen(context, isStrict);
    }

}
