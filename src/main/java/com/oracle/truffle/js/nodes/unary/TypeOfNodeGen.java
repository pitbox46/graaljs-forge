// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(TypeOfNode.class)
@SuppressWarnings("unused")
public final class TypeOfNodeGen extends TypeOfNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private TypeOfNode jSProxy_typeofNode_;
    @CompilationFinal private BranchProfile jSProxy_revokedProxyBranch_;
    @Child private TruffleObject0Data truffleObject0_cache;

    private TypeOfNodeGen(JavaScriptNode operand) {
        super(operand);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doString(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x1c000) >>> 14 /* extract-implicit-state_0 0:CharSequence */, operandNodeValue)) {
            CharSequence operandNodeValue_ = JSTypesGen.asImplicitCharSequence((state_0 & 0x1c000) >>> 14 /* extract-implicit-state_0 0:CharSequence */, operandNodeValue);
            return doString(operandNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doInt(operandNodeValue_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x1e0000) >>> 17 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0x1e0000) >>> 17 /* extract-implicit-state_0 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            return doBoolean(operandNodeValue_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return doBigInt(operandNodeValue_);
        }
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doNull(Object) || doUndefined(Object) */) {
            if ((state_0 & 0b100000) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue))) {
                    return doNull(operandNodeValue);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue))) {
                    return doUndefined(operandNodeValue);
                }
            }
        }
        if ((state_0 & 0b1110000000) != 0 /* is-state_0 doJSFunction(DynamicObject) || doJSObjectOnly(DynamicObject) || doJSProxy(DynamicObject, TypeOfNode, BranchProfile) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doJSFunction(DynamicObject) */) {
                if ((JSGuards.isJSFunction(operandNodeValue_))) {
                    return doJSFunction(operandNodeValue_);
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSObjectOnly(DynamicObject) */) {
                if ((JSGuards.isJSDynamicObject(operandNodeValue_)) && (!(JSGuards.isJSFunction(operandNodeValue_))) && (!(JSGuards.isUndefined(operandNodeValue_))) && (!(JSGuards.isJSProxy(operandNodeValue_)))) {
                    return doJSObjectOnly(operandNodeValue_);
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSProxy(DynamicObject, TypeOfNode, BranchProfile) */) {
                if ((JSGuards.isJSProxy(operandNodeValue_))) {
                    return doJSProxy(operandNodeValue_, this.jSProxy_typeofNode_, this.jSProxy_revokedProxyBranch_);
                }
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return doSymbol(operandNodeValue_);
        }
        if ((state_0 & 0b11100000000000) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) || doTruffleObject(Object, InteropLibrary) || doJavaObject(Object) */) {
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
                TruffleObject0Data s11_ = this.truffleObject0_cache;
                while (s11_ != null) {
                    if ((s11_.interop_.accepts(operandNodeValue)) && (JSRuntime.isForeignObject(operandNodeValue))) {
                        return doTruffleObject(operandNodeValue, s11_.interop_);
                    }
                    s11_ = s11_.next_;
                }
            }
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
                if ((JSRuntime.isForeignObject(operandNodeValue))) {
                    return this.truffleObject1Boundary(state_0, operandNodeValue);
                }
            }
            if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doJavaObject(Object) */) {
                if (fallbackGuard_(state_0, operandNodeValue)) {
                    return doJavaObject(operandNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object truffleObject1Boundary(int state_0, Object operandNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                return doTruffleObject(operandNodeValue, truffleObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public String executeString(Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doString(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x1c000) >>> 14 /* extract-implicit-state_0 0:CharSequence */, operandNodeValue)) {
            CharSequence operandNodeValue_ = JSTypesGen.asImplicitCharSequence((state_0 & 0x1c000) >>> 14 /* extract-implicit-state_0 0:CharSequence */, operandNodeValue);
            return doString(operandNodeValue_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doInt(operandNodeValue_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x1e0000) >>> 17 /* extract-implicit-state_0 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state_0 & 0x1e0000) >>> 17 /* extract-implicit-state_0 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            return doBoolean(operandNodeValue_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return doBigInt(operandNodeValue_);
        }
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doNull(Object) || doUndefined(Object) */) {
            if ((state_0 & 0b100000) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue))) {
                    return doNull(operandNodeValue);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue))) {
                    return doUndefined(operandNodeValue);
                }
            }
        }
        if ((state_0 & 0b1110000000) != 0 /* is-state_0 doJSFunction(DynamicObject) || doJSObjectOnly(DynamicObject) || doJSProxy(DynamicObject, TypeOfNode, BranchProfile) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doJSFunction(DynamicObject) */) {
                if ((JSGuards.isJSFunction(operandNodeValue_))) {
                    return doJSFunction(operandNodeValue_);
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSObjectOnly(DynamicObject) */) {
                if ((JSGuards.isJSDynamicObject(operandNodeValue_)) && (!(JSGuards.isJSFunction(operandNodeValue_))) && (!(JSGuards.isUndefined(operandNodeValue_))) && (!(JSGuards.isJSProxy(operandNodeValue_)))) {
                    return doJSObjectOnly(operandNodeValue_);
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSProxy(DynamicObject, TypeOfNode, BranchProfile) */) {
                if ((JSGuards.isJSProxy(operandNodeValue_))) {
                    return doJSProxy(operandNodeValue_, this.jSProxy_typeofNode_, this.jSProxy_revokedProxyBranch_);
                }
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return doSymbol(operandNodeValue_);
        }
        if ((state_0 & 0b11100000000000) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) || doTruffleObject(Object, InteropLibrary) || doJavaObject(Object) */) {
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
                TruffleObject0Data s11_ = this.truffleObject0_cache;
                while (s11_ != null) {
                    if ((s11_.interop_.accepts(operandNodeValue)) && (JSRuntime.isForeignObject(operandNodeValue))) {
                        return doTruffleObject(operandNodeValue, s11_.interop_);
                    }
                    s11_ = s11_.next_;
                }
            }
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
                if ((JSRuntime.isForeignObject(operandNodeValue))) {
                    return this.truffleObject1Boundary0(state_0, operandNodeValue);
                }
            }
            if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doJavaObject(Object) */) {
                if (fallbackGuard_(state_0, operandNodeValue)) {
                    return doJavaObject(operandNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private String truffleObject1Boundary0(int state_0, Object operandNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                return doTruffleObject(operandNodeValue, truffleObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11111111111101) == 0 /* only-active doInt(int) */ && ((state_0 & 0b11111111111111) != 0  /* is-not doString(CharSequence) && doInt(int) && doDouble(double) && doBoolean(boolean) && doBigInt(BigInt) && doNull(Object) && doUndefined(Object) && doJSFunction(DynamicObject) && doJSObjectOnly(DynamicObject) && doJSProxy(DynamicObject, TypeOfNode, BranchProfile) && doSymbol(Symbol) && doTruffleObject(Object, InteropLibrary) && doTruffleObject(Object, InteropLibrary) && doJavaObject(Object) */)) {
            return execute_int0(state_0, frameValue);
        } else if ((state_0 & 0b11111111111011) == 0 /* only-active doDouble(double) */ && ((state_0 & 0b11111111111111) != 0  /* is-not doString(CharSequence) && doInt(int) && doDouble(double) && doBoolean(boolean) && doBigInt(BigInt) && doNull(Object) && doUndefined(Object) && doJSFunction(DynamicObject) && doJSObjectOnly(DynamicObject) && doJSProxy(DynamicObject, TypeOfNode, BranchProfile) && doSymbol(Symbol) && doTruffleObject(Object, InteropLibrary) && doTruffleObject(Object, InteropLibrary) && doJavaObject(Object) */)) {
            return execute_double1(state_0, frameValue);
        } else if ((state_0 & 0b11111111110111) == 0 /* only-active doBoolean(boolean) */ && ((state_0 & 0b11111111111111) != 0  /* is-not doString(CharSequence) && doInt(int) && doDouble(double) && doBoolean(boolean) && doBigInt(BigInt) && doNull(Object) && doUndefined(Object) && doJSFunction(DynamicObject) && doJSObjectOnly(DynamicObject) && doJSProxy(DynamicObject, TypeOfNode, BranchProfile) && doSymbol(Symbol) && doTruffleObject(Object, InteropLibrary) && doTruffleObject(Object, InteropLibrary) && doJavaObject(Object) */)) {
            return execute_boolean2(state_0, frameValue);
        } else {
            return execute_generic3(state_0, frameValue);
        }
    }

    private Object execute_int0(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b10) != 0 /* is-state_0 doInt(int) */;
        return doInt(operandNodeValue_);
    }

    private Object execute_double1(int state_0, VirtualFrame frameValue) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state_0 & 0x1c0000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111111111111) != 0  /* is-not doString(CharSequence) && doInt(int) && doDouble(double) && doBoolean(boolean) && doBigInt(BigInt) && doNull(Object) && doUndefined(Object) && doJSFunction(DynamicObject) && doJSObjectOnly(DynamicObject) && doJSProxy(DynamicObject, TypeOfNode, BranchProfile) && doSymbol(Symbol) && doTruffleObject(Object, InteropLibrary) && doTruffleObject(Object, InteropLibrary) && doJavaObject(Object) */)) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state_0 & 0x1a0000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111111111111) != 0  /* is-not doString(CharSequence) && doInt(int) && doDouble(double) && doBoolean(boolean) && doBigInt(BigInt) && doNull(Object) && doUndefined(Object) && doJSFunction(DynamicObject) && doJSObjectOnly(DynamicObject) && doJSProxy(DynamicObject, TypeOfNode, BranchProfile) && doSymbol(Symbol) && doTruffleObject(Object, InteropLibrary) && doTruffleObject(Object, InteropLibrary) && doJavaObject(Object) */)) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state_0 & 0x160000) == 0 /* only-active 0:double */ && ((state_0 & 0b11111111111111) != 0  /* is-not doString(CharSequence) && doInt(int) && doDouble(double) && doBoolean(boolean) && doBigInt(BigInt) && doNull(Object) && doUndefined(Object) && doJSFunction(DynamicObject) && doJSObjectOnly(DynamicObject) && doJSProxy(DynamicObject, TypeOfNode, BranchProfile) && doSymbol(Symbol) && doTruffleObject(Object, InteropLibrary) && doTruffleObject(Object, InteropLibrary) && doJavaObject(Object) */)) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state_0 & 0x1e0000) >>> 17 /* extract-implicit-state_0 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b100) != 0 /* is-state_0 doDouble(double) */;
        return doDouble(operandNodeValue_);
    }

    private Object execute_boolean2(int state_0, VirtualFrame frameValue) {
        boolean operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state_0 & 0b1000) != 0 /* is-state_0 doBoolean(boolean) */;
        return doBoolean(operandNodeValue_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object truffleObject1Boundary1(int state_0, Object operandNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue_));
                return doTruffleObject(operandNodeValue_, truffleObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    private Object execute_generic3(int state_0, VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 doString(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x1c000) >>> 14 /* extract-implicit-state_0 0:CharSequence */, operandNodeValue_)) {
            CharSequence operandNodeValue__ = JSTypesGen.asImplicitCharSequence((state_0 & 0x1c000) >>> 14 /* extract-implicit-state_0 0:CharSequence */, operandNodeValue_);
            return doString(operandNodeValue__);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            return doInt(operandNodeValue__);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0x1e0000) >>> 17 /* extract-implicit-state_0 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state_0 & 0x1e0000) >>> 17 /* extract-implicit-state_0 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doBoolean(boolean) */ && operandNodeValue_ instanceof Boolean) {
            boolean operandNodeValue__ = (boolean) operandNodeValue_;
            return doBoolean(operandNodeValue__);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return doBigInt(operandNodeValue__);
        }
        if ((state_0 & 0b1100000) != 0 /* is-state_0 doNull(Object) || doUndefined(Object) */) {
            if ((state_0 & 0b100000) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue_))) {
                    return doNull(operandNodeValue_);
                }
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue_))) {
                    return doUndefined(operandNodeValue_);
                }
            }
        }
        if ((state_0 & 0b1110000000) != 0 /* is-state_0 doJSFunction(DynamicObject) || doJSObjectOnly(DynamicObject) || doJSProxy(DynamicObject, TypeOfNode, BranchProfile) */ && JSTypes.isDynamicObject(operandNodeValue_)) {
            DynamicObject operandNodeValue__ = (DynamicObject) operandNodeValue_;
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doJSFunction(DynamicObject) */) {
                if ((JSGuards.isJSFunction(operandNodeValue__))) {
                    return doJSFunction(operandNodeValue__);
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSObjectOnly(DynamicObject) */) {
                if ((JSGuards.isJSDynamicObject(operandNodeValue__)) && (!(JSGuards.isJSFunction(operandNodeValue__))) && (!(JSGuards.isUndefined(operandNodeValue__))) && (!(JSGuards.isJSProxy(operandNodeValue__)))) {
                    return doJSObjectOnly(operandNodeValue__);
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSProxy(DynamicObject, TypeOfNode, BranchProfile) */) {
                if ((JSGuards.isJSProxy(operandNodeValue__))) {
                    return doJSProxy(operandNodeValue__, this.jSProxy_typeofNode_, this.jSProxy_revokedProxyBranch_);
                }
            }
        }
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue_ instanceof Symbol) {
            Symbol operandNodeValue__ = (Symbol) operandNodeValue_;
            return doSymbol(operandNodeValue__);
        }
        if ((state_0 & 0b11100000000000) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) || doTruffleObject(Object, InteropLibrary) || doJavaObject(Object) */) {
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
                TruffleObject0Data s11_ = this.truffleObject0_cache;
                while (s11_ != null) {
                    if ((s11_.interop_.accepts(operandNodeValue_)) && (JSRuntime.isForeignObject(operandNodeValue_))) {
                        return doTruffleObject(operandNodeValue_, s11_.interop_);
                    }
                    s11_ = s11_.next_;
                }
            }
            if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
                if ((JSRuntime.isForeignObject(operandNodeValue_))) {
                    return this.truffleObject1Boundary1(state_0, operandNodeValue_);
                }
            }
            if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doJavaObject(Object) */) {
                if (fallbackGuard_(state_0, operandNodeValue_)) {
                    return doJavaObject(operandNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private String executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(operandNodeValue)) != 0) {
                    CharSequence operandNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, operandNodeValue);
                    state_0 = (state_0 | (charSequenceCast0 << 14) /* set-implicit-state_0 0:CharSequence */);
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doString(CharSequence) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(operandNodeValue_);
                }
            }
            if (operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doInt(int) */;
                lock.unlock();
                hasLock = false;
                return doInt(operandNodeValue_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    state_0 = (state_0 | (doubleCast0 << 17) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(operandNodeValue_);
                }
            }
            if (operandNodeValue instanceof Boolean) {
                boolean operandNodeValue_ = (boolean) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return doBoolean(operandNodeValue_);
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(operandNodeValue_);
            }
            if ((JSGuards.isJSNull(operandNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return doNull(operandNodeValue);
            }
            if ((JSGuards.isUndefined(operandNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return doUndefined(operandNodeValue);
            }
            if (JSTypes.isDynamicObject(operandNodeValue)) {
                DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
                if ((JSGuards.isJSFunction(operandNodeValue_))) {
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doJSFunction(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSFunction(operandNodeValue_);
                }
                if ((JSGuards.isJSDynamicObject(operandNodeValue_)) && (!(JSGuards.isJSFunction(operandNodeValue_))) && (!(JSGuards.isUndefined(operandNodeValue_))) && (!(JSGuards.isJSProxy(operandNodeValue_)))) {
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doJSObjectOnly(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObjectOnly(operandNodeValue_);
                }
                if ((JSGuards.isJSProxy(operandNodeValue_))) {
                    this.jSProxy_typeofNode_ = super.insert((TypeOfNode.create()));
                    this.jSProxy_revokedProxyBranch_ = (BranchProfile.create());
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doJSProxy(DynamicObject, TypeOfNode, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSProxy(operandNodeValue_, this.jSProxy_typeofNode_, this.jSProxy_revokedProxyBranch_);
                }
            }
            if (operandNodeValue instanceof Symbol) {
                Symbol operandNodeValue_ = (Symbol) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(operandNodeValue_);
            }
            if ((exclude) == 0 /* is-not-exclude doTruffleObject(Object, InteropLibrary) */) {
                int count11_ = 0;
                TruffleObject0Data s11_ = this.truffleObject0_cache;
                if ((state_0 & 0b100000000000) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
                    while (s11_ != null) {
                        if ((s11_.interop_.accepts(operandNodeValue)) && (JSRuntime.isForeignObject(operandNodeValue))) {
                            break;
                        }
                        s11_ = s11_.next_;
                        count11_++;
                    }
                }
                if (s11_ == null) {
                    if ((JSRuntime.isForeignObject(operandNodeValue)) && count11_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s11_.interop_.accepts(operandNodeValue));
                        s11_ = super.insert(new TruffleObject0Data(truffleObject0_cache));
                        s11_.interop_ = s11_.insertAccessor((INTEROP_LIBRARY_.create(operandNodeValue)));
                        MemoryFence.storeStore();
                        this.truffleObject0_cache = s11_;
                        this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doTruffleObject(Object, InteropLibrary) */;
                    }
                }
                if (s11_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doTruffleObject(operandNodeValue, s11_.interop_);
                }
            }
            {
                InteropLibrary truffleObject1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSRuntime.isForeignObject(operandNodeValue))) {
                            truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doTruffleObject(Object, InteropLibrary) */;
                            this.truffleObject0_cache = null;
                            state_0 = state_0 & 0xfffff7ff /* remove-state_0 doTruffleObject(Object, InteropLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doTruffleObject(Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return doTruffleObject(operandNodeValue, truffleObject1_interop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 doJavaObject(Object) */;
            lock.unlock();
            hasLock = false;
            return doJavaObject(operandNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11111111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b11111111111111) & ((state_0 & 0b11111111111111) - 1)) == 0 /* is-single-state_0  */) {
                TruffleObject0Data s11_ = this.truffleObject0_cache;
                if ((s11_ == null || s11_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[15];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b1) != 0 /* is-state_0 doString(CharSequence) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state_0 & 0b10) != 0 /* is-state_0 doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state_0 & 0b100) != 0 /* is-state_0 doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doNull";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doJSFunction";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doJSFunction(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doJSObjectOnly";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSObjectOnly(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doJSProxy";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSProxy(DynamicObject, TypeOfNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSProxy_typeofNode_, this.jSProxy_revokedProxyBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doTruffleObject";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            TruffleObject0Data s11_ = this.truffleObject0_cache;
            while (s11_ != null) {
                cached.add(Arrays.asList(s11_.interop_));
                s11_ = s11_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doTruffleObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doTruffleObject";
        if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doTruffleObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doJavaObject";
        if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doJavaObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state_0, Object operandNodeValue) {
        if (JSTypesGen.isImplicitCharSequence(operandNodeValue)) {
            return false;
        }
        if (JSTypesGen.isImplicitDouble(operandNodeValue)) {
            return false;
        }
        if (((state_0 & 0b1000)) == 0 /* is-not-state_0 doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            return false;
        }
        if (((state_0 & 0b10000)) == 0 /* is-not-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            return false;
        }
        if (((state_0 & 0b100000)) == 0 /* is-not-state_0 doNull(Object) */ && (JSGuards.isJSNull(operandNodeValue))) {
            return false;
        }
        if (((state_0 & 0b1000000)) == 0 /* is-not-state_0 doUndefined(Object) */ && (JSGuards.isUndefined(operandNodeValue))) {
            return false;
        }
        if (JSTypes.isDynamicObject(operandNodeValue)) {
            {
                DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
                if ((JSGuards.isJSFunction(operandNodeValue_))) {
                    return false;
                }
            }
            {
                DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
                if ((JSGuards.isJSDynamicObject(operandNodeValue_)) && (!(JSGuards.isJSFunction(operandNodeValue_))) && (!(JSGuards.isUndefined(operandNodeValue_))) && (!(JSGuards.isJSProxy(operandNodeValue_)))) {
                    return false;
                }
            }
            {
                DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
                if ((JSGuards.isJSProxy(operandNodeValue_))) {
                    return false;
                }
            }
        }
        if (((state_0 & 0b10000000000)) == 0 /* is-not-state_0 doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            return false;
        }
        if (((state_0 & 0b1000000000000)) == 0 /* is-not-state_0 doTruffleObject(Object, InteropLibrary) */ && (JSRuntime.isForeignObject(operandNodeValue))) {
            return false;
        }
        return true;
    }

    public static TypeOfNode create(JavaScriptNode operand) {
        return new TypeOfNodeGen(operand);
    }

    @GeneratedBy(TypeOfNode.class)
    private static final class TruffleObject0Data extends Node {

        @Child TruffleObject0Data next_;
        @Child InteropLibrary interop_;

        TruffleObject0Data(TruffleObject0Data next_) {
            this.next_ = next_;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
}
