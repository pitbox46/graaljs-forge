// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JavaScriptNode;

@GeneratedBy(IsIdenticalBooleanNode.class)
public final class IsIdenticalBooleanNodeGen extends IsIdenticalBooleanNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private IsIdenticalBooleanNodeGen(JavaScriptNode operand, boolean bool, boolean leftConstant) {
        super(operand, bool, leftConstant);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            return doBoolean(operandNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object) */) {
            if (fallbackGuard_(state_0, operandNodeValue)) {
                return doOther(operandNodeValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b10) == 0 /* only-active doBoolean(boolean) */ && (state_0 != 0  /* is-not doBoolean(boolean) && doOther(Object) */)) {
            return execute_boolean0(state_0, frameValue);
        } else {
            return execute_generic1(state_0, frameValue);
        }
    }

    private Object execute_boolean0(int state_0, VirtualFrame frameValue) {
        boolean operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean) */;
        return doBoolean(operandNodeValue_);
    }

    private Object execute_generic1(int state_0, VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue_ instanceof Boolean) {
            boolean operandNodeValue__ = (boolean) operandNodeValue_;
            return doBoolean(operandNodeValue__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object) */) {
            if (fallbackGuard_(state_0, operandNodeValue_)) {
                return doOther(operandNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b10) == 0 /* only-active doBoolean(boolean) */ && (state_0 != 0  /* is-not doBoolean(boolean) && doOther(Object) */)) {
            return executeBoolean_boolean2(state_0, frameValue);
        } else {
            return executeBoolean_generic3(state_0, frameValue);
        }
    }

    private boolean executeBoolean_boolean2(int state_0, VirtualFrame frameValue) {
        boolean operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean) */;
        return doBoolean(operandNodeValue_);
    }

    private boolean executeBoolean_generic3(int state_0, VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue_ instanceof Boolean) {
            boolean operandNodeValue__ = (boolean) operandNodeValue_;
            return doBoolean(operandNodeValue__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object) */) {
            if (fallbackGuard_(state_0, operandNodeValue_)) {
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
        int state_0 = this.state_0_;
        if (operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBoolean(boolean) */;
            return doBoolean(operandNodeValue_);
        }
        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doOther(Object) */;
        return doOther(operandNodeValue);
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
        s[0] = "doBoolean";
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state_0, Object operandNodeValue) {
        if (((state_0 & 0b1)) == 0 /* is-not-state_0 doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            return false;
        }
        return true;
    }

    public static IsIdenticalBooleanNode create(JavaScriptNode operand, boolean bool, boolean leftConstant) {
        return new IsIdenticalBooleanNodeGen(operand, bool, leftConstant);
    }

}
