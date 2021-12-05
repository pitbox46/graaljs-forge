// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JSTypesGen;

@GeneratedBy(JSReadScopeFrameSlotNode.class)
final class JSReadScopeFrameSlotNodeGen extends JSReadScopeFrameSlotNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private JSReadScopeFrameSlotNodeGen(FrameSlot slot, ScopeFrameNode scopeFrameNode) {
        super(slot, scopeFrameNode);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        if (state_0 != 0 /* is-state_0 doBoolean(Frame) || doInt(Frame) || doDouble(Frame) || doObject(Frame) || doSafeInteger(Frame) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(Frame) */) {
                if ((scopeFrameNodeValue_.isBoolean(frameSlot))) {
                    return doBoolean(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doInt(Frame) */) {
                if ((scopeFrameNodeValue_.isInt(frameSlot))) {
                    return doInt(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(Frame) */) {
                if ((scopeFrameNodeValue_.isDouble(frameSlot) || scopeFrameNodeValue_.isInt(frameSlot))) {
                    return doDouble(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doObject(Frame) */) {
                if ((scopeFrameNodeValue_.isObject(frameSlot))) {
                    assert (!(hasTemporalDeadZone()));
                    return doObject(scopeFrameNodeValue_);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doSafeInteger(Frame) */) {
                if ((scopeFrameNodeValue_.isLong(frameSlot))) {
                    return doSafeInteger(scopeFrameNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1000) != 0 /* is-state_0 doObject(Frame) */) {
            return JSTypesGen.expectBoolean(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(Frame) */) {
            if ((scopeFrameNodeValue_.isBoolean(frameSlot))) {
                return doBoolean(scopeFrameNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectBoolean(executeAndSpecialize(scopeFrameNodeValue_));
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1000) != 0 /* is-state_0 doObject(Frame) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(Frame) */) {
            if ((scopeFrameNodeValue_.isDouble(frameSlot) || scopeFrameNodeValue_.isInt(frameSlot))) {
                return doDouble(scopeFrameNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(scopeFrameNodeValue_));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1000) != 0 /* is-state_0 doObject(Frame) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(Frame) */) {
            if ((scopeFrameNodeValue_.isInt(frameSlot))) {
                return doInt(scopeFrameNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(scopeFrameNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b11101) == 0 /* only-active doInt(Frame) */ && (state_0 != 0  /* is-not doBoolean(Frame) && doInt(Frame) && doDouble(Frame) && doObject(Frame) && doSafeInteger(Frame) */)) {
                executeInt(frameValue);
                return;
            } else if ((state_0 & 0b11011) == 0 /* only-active doDouble(Frame) */ && (state_0 != 0  /* is-not doBoolean(Frame) && doInt(Frame) && doDouble(Frame) && doObject(Frame) && doSafeInteger(Frame) */)) {
                executeDouble(frameValue);
                return;
            } else if ((state_0 & 0b11110) == 0 /* only-active doBoolean(Frame) */ && (state_0 != 0  /* is-not doBoolean(Frame) && doInt(Frame) && doDouble(Frame) && doObject(Frame) && doSafeInteger(Frame) */)) {
                executeBoolean(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Frame scopeFrameNodeValue) {
        int state_0 = this.state_0_;
        if ((scopeFrameNodeValue.isBoolean(frameSlot))) {
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBoolean(Frame) */;
            return doBoolean(scopeFrameNodeValue);
        }
        if ((scopeFrameNodeValue.isInt(frameSlot))) {
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doInt(Frame) */;
            return doInt(scopeFrameNodeValue);
        }
        if ((scopeFrameNodeValue.isDouble(frameSlot) || scopeFrameNodeValue.isInt(frameSlot))) {
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doDouble(Frame) */;
            return doDouble(scopeFrameNodeValue);
        }
        if ((scopeFrameNodeValue.isObject(frameSlot)) && (!(hasTemporalDeadZone()))) {
            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doObject(Frame) */;
            return doObject(scopeFrameNodeValue);
        }
        if ((scopeFrameNodeValue.isLong(frameSlot))) {
            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doSafeInteger(Frame) */;
            return doSafeInteger(scopeFrameNodeValue);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {super.scopeFrameNode}, scopeFrameNodeValue);
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
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doObject(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doSafeInteger(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static JSReadScopeFrameSlotNode create(FrameSlot slot, ScopeFrameNode scopeFrameNode) {
        return new JSReadScopeFrameSlotNodeGen(slot, scopeFrameNode);
    }

}
