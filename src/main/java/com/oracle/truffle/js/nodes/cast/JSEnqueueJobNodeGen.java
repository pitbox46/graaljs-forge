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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(JSEnqueueJobNode.class)
public final class JSEnqueueJobNodeGen extends JSEnqueueJobNode implements Introspection.Provider {

    @Child private JavaScriptNode function_;
    @CompilationFinal private int state_0_;

    private JSEnqueueJobNodeGen(JSContext context, JavaScriptNode function) {
        super(context);
        this.function_ = function;
    }

    @Override
    JavaScriptNode getFunction() {
        return this.function_;
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object functionValue_ = this.function_.execute(frameValue);
        if (state_0 != 0 /* is-state_0 doOther(Object) */) {
            if ((JSGuards.isJSFunction(functionValue_))) {
                return doOther(functionValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(functionValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object functionValue) {
        int state_0 = this.state_0_;
        if ((JSGuards.isJSFunction(functionValue))) {
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doOther(Object) */;
            return doOther(functionValue);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {this.function_}, functionValue);
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if (state_0 == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            return NodeCost.MONOMORPHIC;
        }
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[2];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doOther";
        if (state_0 != 0 /* is-state_0 doOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static JSEnqueueJobNode create(JSContext context, JavaScriptNode function) {
        return new JSEnqueueJobNodeGen(context, function);
    }

}
