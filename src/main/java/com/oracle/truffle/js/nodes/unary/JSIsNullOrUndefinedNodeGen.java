// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSIsNullOrUndefinedNode.class)
@SuppressWarnings("unused")
public final class JSIsNullOrUndefinedNodeGen extends JSIsNullOrUndefinedNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private Class<?> jSObjectCached_cachedClass_;
    @Child private JSValueOrForeign0Data jSValueOrForeign0_cache;

    private JSIsNullOrUndefinedNodeGen(JavaScriptNode operand, boolean isUndefined, boolean isLeft) {
        super(operand, isUndefined, isLeft);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 doNull(Object) || doUndefined(Object) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doNull(operandNodeValue);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doUndefined(operandNodeValue);
                }
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return JSIsNullOrUndefinedNode.doSymbol(operandNodeValue_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLazyString(JSLazyString) */ && operandNodeValue instanceof JSLazyString) {
            JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
            return JSIsNullOrUndefinedNode.doLazyString(operandNodeValue_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            return JSIsNullOrUndefinedNode.doSafeInteger(operandNodeValue_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return JSIsNullOrUndefinedNode.doBigInt(operandNodeValue_);
        }
        if ((state_0 & 0b1111000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) || doJSObject(Object) || doJSValueOrForeign(Object, InteropLibrary) || doJSValueOrForeign(Object, InteropLibrary) */) {
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
                assert (this.jSObjectCached_cachedClass_ != null);
                if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doJSObjectCached(operandNodeValue, this.jSObjectCached_cachedClass_);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doJSObject(Object) */) {
                if ((JSGuards.isJSObject(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doJSObject(operandNodeValue);
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSValueOrForeign(Object, InteropLibrary) */) {
                JSValueOrForeign0Data s8_ = this.jSValueOrForeign0_cache;
                while (s8_ != null) {
                    if ((s8_.interop_.accepts(operandNodeValue)) && (!(JSGuards.isJSDynamicObject(operandNodeValue)))) {
                        return doJSValueOrForeign(operandNodeValue, s8_.interop_);
                    }
                    s8_ = s8_.next_;
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSValueOrForeign(Object, InteropLibrary) */) {
                if ((!(JSGuards.isJSDynamicObject(operandNodeValue)))) {
                    return this.jSValueOrForeign1Boundary(state_0, operandNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object jSValueOrForeign1Boundary(int state_0, Object operandNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary jSValueOrForeign1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                return doJSValueOrForeign(operandNodeValue, jSValueOrForeign1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object operandNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 doNull(Object) || doUndefined(Object) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doNull(operandNodeValue);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doUndefined(operandNodeValue);
                }
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return JSIsNullOrUndefinedNode.doSymbol(operandNodeValue_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLazyString(JSLazyString) */ && operandNodeValue instanceof JSLazyString) {
            JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
            return JSIsNullOrUndefinedNode.doLazyString(operandNodeValue_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            return JSIsNullOrUndefinedNode.doSafeInteger(operandNodeValue_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return JSIsNullOrUndefinedNode.doBigInt(operandNodeValue_);
        }
        if ((state_0 & 0b1111000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) || doJSObject(Object) || doJSValueOrForeign(Object, InteropLibrary) || doJSValueOrForeign(Object, InteropLibrary) */) {
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
                assert (this.jSObjectCached_cachedClass_ != null);
                if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doJSObjectCached(operandNodeValue, this.jSObjectCached_cachedClass_);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doJSObject(Object) */) {
                if ((JSGuards.isJSObject(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doJSObject(operandNodeValue);
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSValueOrForeign(Object, InteropLibrary) */) {
                JSValueOrForeign0Data s8_ = this.jSValueOrForeign0_cache;
                while (s8_ != null) {
                    if ((s8_.interop_.accepts(operandNodeValue)) && (!(JSGuards.isJSDynamicObject(operandNodeValue)))) {
                        return doJSValueOrForeign(operandNodeValue, s8_.interop_);
                    }
                    s8_ = s8_.next_;
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSValueOrForeign(Object, InteropLibrary) */) {
                if ((!(JSGuards.isJSDynamicObject(operandNodeValue)))) {
                    return this.jSValueOrForeign1Boundary0(state_0, operandNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private boolean jSValueOrForeign1Boundary0(int state_0, Object operandNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary jSValueOrForeign1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                return doJSValueOrForeign(operandNodeValue, jSValueOrForeign1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b11) != 0 /* is-state_0 doNull(Object) || doUndefined(Object) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doNull(operandNodeValue_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doUndefined(operandNodeValue_);
                }
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue_ instanceof Symbol) {
            Symbol operandNodeValue__ = (Symbol) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doSymbol(operandNodeValue__);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLazyString(JSLazyString) */ && operandNodeValue_ instanceof JSLazyString) {
            JSLazyString operandNodeValue__ = (JSLazyString) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doLazyString(operandNodeValue__);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doSafeInteger(operandNodeValue__);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doBigInt(operandNodeValue__);
        }
        if ((state_0 & 0b1111000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) || doJSObject(Object) || doJSValueOrForeign(Object, InteropLibrary) || doJSValueOrForeign(Object, InteropLibrary) */) {
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
                assert (this.jSObjectCached_cachedClass_ != null);
                if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doJSObjectCached(operandNodeValue_, this.jSObjectCached_cachedClass_);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doJSObject(Object) */) {
                if ((JSGuards.isJSObject(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doJSObject(operandNodeValue_);
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSValueOrForeign(Object, InteropLibrary) */) {
                JSValueOrForeign0Data s8_ = this.jSValueOrForeign0_cache;
                while (s8_ != null) {
                    if ((s8_.interop_.accepts(operandNodeValue_)) && (!(JSGuards.isJSDynamicObject(operandNodeValue_)))) {
                        return doJSValueOrForeign(operandNodeValue_, s8_.interop_);
                    }
                    s8_ = s8_.next_;
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSValueOrForeign(Object, InteropLibrary) */) {
                if ((!(JSGuards.isJSDynamicObject(operandNodeValue_)))) {
                    return this.jSValueOrForeign1Boundary1(state_0, operandNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object jSValueOrForeign1Boundary1(int state_0, Object operandNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary jSValueOrForeign1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue_));
                return doJSValueOrForeign(operandNodeValue_, jSValueOrForeign1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state_0 & 0b11) != 0 /* is-state_0 doNull(Object) || doUndefined(Object) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doNull(operandNodeValue_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doUndefined(operandNodeValue_);
                }
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doSymbol(Symbol) */ && operandNodeValue_ instanceof Symbol) {
            Symbol operandNodeValue__ = (Symbol) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doSymbol(operandNodeValue__);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLazyString(JSLazyString) */ && operandNodeValue_ instanceof JSLazyString) {
            JSLazyString operandNodeValue__ = (JSLazyString) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doLazyString(operandNodeValue__);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doSafeInteger(operandNodeValue__);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doBigInt(operandNodeValue__);
        }
        if ((state_0 & 0b1111000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) || doJSObject(Object) || doJSValueOrForeign(Object, InteropLibrary) || doJSValueOrForeign(Object, InteropLibrary) */) {
            if ((state_0 & 0b1000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
                assert (this.jSObjectCached_cachedClass_ != null);
                if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doJSObjectCached(operandNodeValue_, this.jSObjectCached_cachedClass_);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 doJSObject(Object) */) {
                if ((JSGuards.isJSObject(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doJSObject(operandNodeValue_);
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSValueOrForeign(Object, InteropLibrary) */) {
                JSValueOrForeign0Data s8_ = this.jSValueOrForeign0_cache;
                while (s8_ != null) {
                    if ((s8_.interop_.accepts(operandNodeValue_)) && (!(JSGuards.isJSDynamicObject(operandNodeValue_)))) {
                        return doJSValueOrForeign(operandNodeValue_, s8_.interop_);
                    }
                    s8_ = s8_.next_;
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSValueOrForeign(Object, InteropLibrary) */) {
                if ((!(JSGuards.isJSDynamicObject(operandNodeValue_)))) {
                    return this.jSValueOrForeign1Boundary2(state_0, operandNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private boolean jSValueOrForeign1Boundary2(int state_0, Object operandNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary jSValueOrForeign1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue_));
                return doJSValueOrForeign(operandNodeValue_, jSValueOrForeign1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
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
            int exclude = this.exclude_;
            if ((JSGuards.isJSNull(operandNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doNull(operandNodeValue);
            }
            if ((JSGuards.isUndefined(operandNodeValue))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doUndefined(operandNodeValue);
            }
            if (operandNodeValue instanceof Symbol) {
                Symbol operandNodeValue_ = (Symbol) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doSymbol(operandNodeValue_);
            }
            if (operandNodeValue instanceof JSLazyString) {
                JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doLazyString(JSLazyString) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doLazyString(operandNodeValue_);
            }
            if (operandNodeValue instanceof SafeInteger) {
                SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doSafeInteger(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doSafeInteger(operandNodeValue_);
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doBigInt(operandNodeValue_);
            }
            if (((exclude & 0b1)) == 0 /* is-not-exclude doJSObjectCached(Object, Class<>) */) {
                boolean JSObjectCached_duplicateFound_ = false;
                if ((state_0 & 0b1000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
                    assert (this.jSObjectCached_cachedClass_ != null);
                    if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue))) {
                        JSObjectCached_duplicateFound_ = true;
                    }
                }
                if (!JSObjectCached_duplicateFound_) {
                    {
                        Class<?> jSObjectCached_cachedClass__ = (JSGuards.getClassIfJSObject(operandNodeValue));
                        if ((jSObjectCached_cachedClass__ != null) && (jSObjectCached_cachedClass__.isInstance(operandNodeValue)) && ((state_0 & 0b1000000)) == 0 /* is-not-state_0 doJSObjectCached(Object, Class<>) */) {
                            this.jSObjectCached_cachedClass_ = jSObjectCached_cachedClass__;
                            this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doJSObjectCached(Object, Class<>) */;
                            JSObjectCached_duplicateFound_ = true;
                        }
                    }
                }
                if (JSObjectCached_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return JSIsNullOrUndefinedNode.doJSObjectCached(operandNodeValue, this.jSObjectCached_cachedClass_);
                }
            }
            if ((JSGuards.isJSObject(operandNodeValue))) {
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doJSObjectCached(Object, Class<>) */;
                state_0 = state_0 & 0xffffffbf /* remove-state_0 doJSObjectCached(Object, Class<>) */;
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doJSObject(Object) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doJSObject(operandNodeValue);
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude doJSValueOrForeign(Object, InteropLibrary) */) {
                int count8_ = 0;
                JSValueOrForeign0Data s8_ = this.jSValueOrForeign0_cache;
                if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSValueOrForeign(Object, InteropLibrary) */) {
                    while (s8_ != null) {
                        if ((s8_.interop_.accepts(operandNodeValue)) && (!(JSGuards.isJSDynamicObject(operandNodeValue)))) {
                            break;
                        }
                        s8_ = s8_.next_;
                        count8_++;
                    }
                }
                if (s8_ == null) {
                    if ((!(JSGuards.isJSDynamicObject(operandNodeValue))) && count8_ < (JSConfig.InteropLibraryLimit)) {
                        // assert (s8_.interop_.accepts(operandNodeValue));
                        s8_ = super.insert(new JSValueOrForeign0Data(jSValueOrForeign0_cache));
                        s8_.interop_ = s8_.insertAccessor((INTEROP_LIBRARY_.create(operandNodeValue)));
                        MemoryFence.storeStore();
                        this.jSValueOrForeign0_cache = s8_;
                        this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doJSValueOrForeign(Object, InteropLibrary) */;
                    }
                }
                if (s8_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doJSValueOrForeign(operandNodeValue, s8_.interop_);
                }
            }
            {
                InteropLibrary jSValueOrForeign1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((!(JSGuards.isJSDynamicObject(operandNodeValue)))) {
                            jSValueOrForeign1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                            this.exclude_ = exclude = exclude | 0b10 /* add-exclude doJSValueOrForeign(Object, InteropLibrary) */;
                            this.jSValueOrForeign0_cache = null;
                            state_0 = state_0 & 0xfffffeff /* remove-state_0 doJSValueOrForeign(Object, InteropLibrary) */;
                            this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doJSValueOrForeign(Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return doJSValueOrForeign(operandNodeValue, jSValueOrForeign1_interop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.operandNode}, operandNodeValue);
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
                JSValueOrForeign0Data s8_ = this.jSValueOrForeign0_cache;
                if ((s8_ == null || s8_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[11];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doNull";
        if ((state_0 & 0b1) != 0 /* is-state_0 doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state_0 & 0b10) != 0 /* is-state_0 doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state_0 & 0b100) != 0 /* is-state_0 doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doLazyString";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doLazyString(JSLazyString) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doJSObjectCached";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doJSObjectCached(Object, Class<>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSObjectCached_cachedClass_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude doJSObjectCached(Object, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doJSObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doJSValueOrForeign";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doJSValueOrForeign(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            JSValueOrForeign0Data s8_ = this.jSValueOrForeign0_cache;
            while (s8_ != null) {
                cached.add(Arrays.asList(s8_.interop_));
                s8_ = s8_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doJSValueOrForeign(Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doJSValueOrForeign";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doJSValueOrForeign(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        return Provider.create(data);
    }

    public static JSIsNullOrUndefinedNode create(JavaScriptNode operand, boolean isUndefined, boolean isLeft) {
        return new JSIsNullOrUndefinedNodeGen(operand, isUndefined, isLeft);
    }

    @GeneratedBy(JSIsNullOrUndefinedNode.class)
    private static final class JSValueOrForeign0Data extends Node {

        @Child JSValueOrForeign0Data next_;
        @Child InteropLibrary interop_;

        JSValueOrForeign0Data(JSValueOrForeign0Data next_) {
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
