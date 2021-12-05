// CheckStyle: start generated
package com.oracle.truffle.js.builtins.commonjs;

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
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(CommonJSRequireBuiltin.class)
public final class CommonJSRequireBuiltinNodeGen extends CommonJSRequireBuiltin implements Introspection.Provider {

    @Child private JavaScriptNode arguments0_;
    @Child private JavaScriptNode arguments1_;
    @CompilationFinal private int state_0_;

    private CommonJSRequireBuiltinNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if ((state_0 & 0b1) != 0 /* is-state_0 require(DynamicObject, String) */ && JSTypes.isDynamicObject(arguments0Value_)) {
            DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
            if (JSTypesGen.isImplicitString((state_0 & 0b1110) >>> 1 /* extract-implicit-state_0 1:String */, arguments1Value_)) {
                String arguments1Value__ = JSTypesGen.asImplicitString((state_0 & 0b1110) >>> 1 /* extract-implicit-state_0 1:String */, arguments1Value_);
                return require(arguments0Value__, arguments1Value__);
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
        int state_0 = this.state_0_;
        if (JSTypes.isDynamicObject(arguments0Value)) {
            DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
            int stringCast1;
            if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                state_0 = (state_0 | (stringCast1 << 1) /* set-implicit-state_0 1:String */);
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 require(DynamicObject, String) */;
                return require(arguments0Value_, arguments1Value_);
            }
        }
        throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) == 0) {
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
        s[0] = "require";
        if ((state_0 & 0b1) != 0 /* is-state_0 require(DynamicObject, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static CommonJSRequireBuiltin create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new CommonJSRequireBuiltinNodeGen(context, builtin, arguments);
    }

}
