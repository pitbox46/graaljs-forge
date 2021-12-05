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
import com.oracle.truffle.js.nodes.CompileRegexNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSRegExpObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToRegExpNode.class)
public final class JSToRegExpNodeGen extends JSToRegExpNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private JSToStringNode createRegExp_toStringNode_;
    @Child private CompileRegexNode createRegExp_compileRegexNode_;

    private JSToRegExpNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public JSRegExpObject execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 returnRegExp(JSRegExpObject) */ && arg0Value instanceof JSRegExpObject) {
            JSRegExpObject arg0Value_ = (JSRegExpObject) arg0Value;
            return returnRegExp(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 createRegExp(Object, JSToStringNode, CompileRegexNode) */) {
            if ((!(JSGuards.isJSRegExp(arg0Value)))) {
                return createRegExp(arg0Value, this.createRegExp_toStringNode_, this.createRegExp_compileRegexNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private JSRegExpObject executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (arg0Value instanceof JSRegExpObject) {
                JSRegExpObject arg0Value_ = (JSRegExpObject) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 returnRegExp(JSRegExpObject) */;
                lock.unlock();
                hasLock = false;
                return returnRegExp(arg0Value_);
            }
            if ((!(JSGuards.isJSRegExp(arg0Value)))) {
                this.createRegExp_toStringNode_ = super.insert((JSToStringNode.createUndefinedToEmpty()));
                this.createRegExp_compileRegexNode_ = super.insert((CompileRegexNode.create(context)));
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 createRegExp(Object, JSToStringNode, CompileRegexNode) */;
                lock.unlock();
                hasLock = false;
                return createRegExp(arg0Value, this.createRegExp_toStringNode_, this.createRegExp_compileRegexNode_);
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
        s[0] = "returnRegExp";
        if ((state_0 & 0b1) != 0 /* is-state_0 returnRegExp(JSRegExpObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "createRegExp";
        if ((state_0 & 0b10) != 0 /* is-state_0 createRegExp(Object, JSToStringNode, CompileRegexNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.createRegExp_toStringNode_, this.createRegExp_compileRegexNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSToRegExpNode create(JSContext context) {
        return new JSToRegExpNodeGen(context);
    }

}
