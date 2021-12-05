// CheckStyle: start generated
package com.oracle.truffle.js.nodes.intl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SupportedLocalesOfNode.class)
public final class SupportedLocalesOfNodeGen extends SupportedLocalesOfNode implements Introspection.Provider {

    @Child private JavaScriptNode arguments0_;
    @Child private JavaScriptNode arguments1_;
    @CompilationFinal private volatile int state_0_;
    @Child private JSToObjectNode getSupportedLocalesWithOptions_toObjectNode_;
    @Child private GetStringOptionNode getSupportedLocalesWithOptions_getMatcherNode_;

    private SupportedLocalesOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        super(context, builtin);
        this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
    }

    @Override
    public JavaScriptNode[] getArguments() {
        return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        Object arguments1Value_ = this.arguments1_.execute(frameValue);
        if (state_0 != 0 /* is-state_0 getSupportedLocales(Object, Object) || getSupportedLocalesWithOptions(Object, Object, JSToObjectNode, GetStringOptionNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 getSupportedLocales(Object, Object) */) {
                if ((JSGuards.isUndefined(arguments1Value_))) {
                    return getSupportedLocales(arguments0Value_, arguments1Value_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 getSupportedLocalesWithOptions(Object, Object, JSToObjectNode, GetStringOptionNode) */) {
                if ((!(JSGuards.isUndefined(arguments1Value_)))) {
                    return getSupportedLocalesWithOptions(arguments0Value_, arguments1Value_, this.getSupportedLocalesWithOptions_toObjectNode_, this.getSupportedLocalesWithOptions_getMatcherNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_, arguments1Value_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if ((JSGuards.isUndefined(arguments1Value))) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getSupportedLocales(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return getSupportedLocales(arguments0Value, arguments1Value);
            }
            if ((!(JSGuards.isUndefined(arguments1Value)))) {
                this.getSupportedLocalesWithOptions_toObjectNode_ = super.insert((JSToObjectNode.createToObject(getContext())));
                this.getSupportedLocalesWithOptions_getMatcherNode_ = super.insert((SupportedLocalesOfNode.createMatcherGetter(getContext())));
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getSupportedLocalesWithOptions(Object, Object, JSToObjectNode, GetStringOptionNode) */;
                lock.unlock();
                hasLock = false;
                return getSupportedLocalesWithOptions(arguments0Value, arguments1Value, this.getSupportedLocalesWithOptions_toObjectNode_, this.getSupportedLocalesWithOptions_getMatcherNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if (state_0 == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "getSupportedLocales";
        if ((state_0 & 0b1) != 0 /* is-state_0 getSupportedLocales(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "getSupportedLocalesWithOptions";
        if ((state_0 & 0b10) != 0 /* is-state_0 getSupportedLocalesWithOptions(Object, Object, JSToObjectNode, GetStringOptionNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.getSupportedLocalesWithOptions_toObjectNode_, this.getSupportedLocalesWithOptions_getMatcherNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static SupportedLocalesOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new SupportedLocalesOfNodeGen(context, builtin, arguments);
    }

}
