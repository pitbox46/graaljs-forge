// CheckStyle: start generated
package com.oracle.truffle.regex.runtime.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.nodes.NodeCost;

@GeneratedBy(ExpectByteArrayHostObjectNode.class)
public final class ExpectByteArrayHostObjectNodeGen extends ExpectByteArrayHostObjectNode {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private int state_0_;

    private ExpectByteArrayHostObjectNodeGen() {
    }

    @Override
    public byte[] execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doByteArray(byte[]) */ && arg0Value instanceof byte[]) {
            byte[] arg0Value_ = (byte[]) arg0Value;
            return ExpectByteArrayHostObjectNode.doByteArray(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doBoxed(Object) */) {
            return doBoxed(arg0Value);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private byte[] executeAndSpecialize(Object arg0Value) {
        int state_0 = this.state_0_;
        if (arg0Value instanceof byte[]) {
            byte[] arg0Value_ = (byte[]) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doByteArray(byte[]) */;
            return ExpectByteArrayHostObjectNode.doByteArray(arg0Value_);
        }
        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doBoxed(Object) */;
        return doBoxed(arg0Value);
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

    public static ExpectByteArrayHostObjectNode create() {
        return new ExpectByteArrayHostObjectNodeGen();
    }

    public static ExpectByteArrayHostObjectNode getUncached() {
        return ExpectByteArrayHostObjectNodeGen.UNCACHED;
    }

    @GeneratedBy(ExpectByteArrayHostObjectNode.class)
    private static final class Uncached extends ExpectByteArrayHostObjectNode {

        @TruffleBoundary
        @Override
        public byte[] execute(Object arg0Value) {
            if (arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                return ExpectByteArrayHostObjectNode.doByteArray(arg0Value_);
            }
            return doBoxed(arg0Value);
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
