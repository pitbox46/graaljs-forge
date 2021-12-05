// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ToArrayIndexNode.class)
@SuppressWarnings("unused")
public final class ToArrayIndexNodeGen extends ToArrayIndexNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile convertFromString_startsWithDigitBranch_;
    @CompilationFinal private BranchProfile convertFromString_isArrayIndexBranch_;
    @Child private InteropArrayIndex0Data interopArrayIndex0_cache;
    @Child private NonArrayIndex0Data nonArrayIndex0_cache;
    @Child private JSToPropertyKeyNode nonArrayIndex1_toPropertyKey_;
    @Child private ToArrayIndexNode nonArrayIndex1_recursive_;

    private ToArrayIndexNodeGen(boolean convertToPropertyKey, boolean convertStringToIndex) {
        super(convertToPropertyKey, convertStringToIndex);
    }

    @ExplodeLoop
    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            if ((JSGuards.isIntArrayIndex(arg0Value_))) {
                return ToArrayIndexNode.doInteger(arg0Value_);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            if ((JSGuards.isLongArrayIndex(arg0Value_))) {
                return ToArrayIndexNode.doLong(arg0Value_);
            }
        }
        if ((state_0 & 0b1100) != 0 /* is-state_0 doDoubleAsIntIndex(double) || doDoubleAsUintIndex(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000000000) >>> 12 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000000000) >>> 12 /* extract-implicit-state_0 0:double */, arg0Value);
            if ((state_0 & 0b100) != 0 /* is-state_0 doDoubleAsIntIndex(double) */) {
                if ((ToArrayIndexNode.doubleIsIntIndex(arg0Value_))) {
                    return ToArrayIndexNode.doDoubleAsIntIndex(arg0Value_);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doDoubleAsUintIndex(double) */) {
                if ((ToArrayIndexNode.doubleIsUintIndex(arg0Value_))) {
                    return ToArrayIndexNode.doDoubleAsUintIndex(arg0Value_);
                }
            }
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return ToArrayIndexNode.doSymbol(arg0Value_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            if ((JSGuards.isBigIntArrayIndex(arg0Value_))) {
                return ToArrayIndexNode.doBigInt(arg0Value_);
            }
        }
        if ((state_0 & 0b11000000) != 0 /* is-state_0 convertFromString(String, ConditionProfile, BranchProfile) || convertFromStringNotInRange(String) */ && JSTypesGen.isImplicitString((state_0 & 0x70000) >>> 16 /* extract-implicit-state_0 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state_0 & 0x70000) >>> 16 /* extract-implicit-state_0 0:String */, arg0Value);
            if ((state_0 & 0b1000000) != 0 /* is-state_0 convertFromString(String, ConditionProfile, BranchProfile) */) {
                assert (convertStringToIndex);
                if ((JSRuntime.arrayIndexLengthInRange(arg0Value_))) {
                    return ToArrayIndexNode.convertFromString(arg0Value_, this.convertFromString_startsWithDigitBranch_, this.convertFromString_isArrayIndexBranch_);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 convertFromStringNotInRange(String) */) {
                if ((!(convertStringToIndex) || !(JSRuntime.arrayIndexLengthInRange(arg0Value_)))) {
                    return ToArrayIndexNode.convertFromStringNotInRange(arg0Value_);
                }
            }
        }
        if ((state_0 & 0b111100000000) != 0 /* is-state_0 doInteropArrayIndex(Object, InteropLibrary, long) || doInteropArrayIndex(Object, InteropLibrary, long) || doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) || doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doInteropArrayIndex(Object, InteropLibrary, long) */) {
                InteropArrayIndex0Data s8_ = this.interopArrayIndex0_cache;
                while (s8_ != null) {
                    if ((s8_.interop_.accepts(arg0Value)) && (ToArrayIndexNode.notArrayIndex(arg0Value))) {
                        long index__ = (ToArrayIndexNode.toArrayIndex(arg0Value, s8_.interop_));
                        if ((index__ >= 0)) {
                            return ToArrayIndexNode.doInteropArrayIndex(arg0Value, s8_.interop_, index__);
                        }
                    }
                    s8_ = s8_.next_;
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doInteropArrayIndex(Object, InteropLibrary, long) */) {
                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                Node prev_ = encapsulating_.set(this);
                try {
                    if ((ToArrayIndexNode.notArrayIndex(arg0Value))) {
                        InteropLibrary interopArrayIndex1_interop__ = (INTEROP_LIBRARY_.getUncached());
                        long interopArrayIndex1_index__ = (ToArrayIndexNode.toArrayIndex(arg0Value, interopArrayIndex1_interop__));
                        if ((interopArrayIndex1_index__ >= 0)) {
                            return this.interopArrayIndex1Boundary(state_0, arg0Value);
                        }
                    }
                } finally {
                    encapsulating_.set(prev_);
                }
            }
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */) {
                NonArrayIndex0Data s10_ = this.nonArrayIndex0_cache;
                while (s10_ != null) {
                    if ((s10_.interop_.accepts(arg0Value)) && (ToArrayIndexNode.notArrayIndex(arg0Value)) && (ToArrayIndexNode.toArrayIndex(arg0Value, s10_.interop_) < 0)) {
                        return doNonArrayIndex(arg0Value, s10_.interop_, s10_.toPropertyKey_, s10_.recursive_);
                    }
                    s10_ = s10_.next_;
                }
            }
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */) {
                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                Node prev_ = encapsulating_.set(this);
                try {
                    if ((ToArrayIndexNode.notArrayIndex(arg0Value))) {
                        InteropLibrary nonArrayIndex1_interop__ = (INTEROP_LIBRARY_.getUncached());
                        if ((ToArrayIndexNode.toArrayIndex(arg0Value, nonArrayIndex1_interop__) < 0)) {
                            return this.nonArrayIndex1Boundary(state_0, arg0Value);
                        }
                    }
                } finally {
                    encapsulating_.set(prev_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object interopArrayIndex1Boundary(int state_0, Object arg0Value) {
        {
            InteropLibrary interopArrayIndex1_interop__ = (INTEROP_LIBRARY_.getUncached());
            long interopArrayIndex1_index__ = (ToArrayIndexNode.toArrayIndex(arg0Value, interopArrayIndex1_interop__));
            return ToArrayIndexNode.doInteropArrayIndex(arg0Value, interopArrayIndex1_interop__, interopArrayIndex1_index__);
        }
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object nonArrayIndex1Boundary(int state_0, Object arg0Value) {
        {
            InteropLibrary nonArrayIndex1_interop__ = (INTEROP_LIBRARY_.getUncached());
            return doNonArrayIndex(arg0Value, nonArrayIndex1_interop__, this.nonArrayIndex1_toPropertyKey_, this.nonArrayIndex1_recursive_);
        }
    }

    @ExplodeLoop
    @Override
    public long executeLong(Object arg0Value) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b110011000000) != 0 /* is-state_0 convertFromString(String, ConditionProfile, BranchProfile) || convertFromStringNotInRange(String) || doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) || doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */) {
            return JSTypesGen.expectLong(execute(arg0Value));
        }
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            if ((JSGuards.isIntArrayIndex(arg0Value_))) {
                return ToArrayIndexNode.doInteger(arg0Value_);
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            if ((JSGuards.isLongArrayIndex(arg0Value_))) {
                return ToArrayIndexNode.doLong(arg0Value_);
            }
        }
        if ((state_0 & 0b1100) != 0 /* is-state_0 doDoubleAsIntIndex(double) || doDoubleAsUintIndex(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000000000000) >>> 12 /* extract-implicit-state_0 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000000000000) >>> 12 /* extract-implicit-state_0 0:double */, arg0Value);
            if ((state_0 & 0b100) != 0 /* is-state_0 doDoubleAsIntIndex(double) */) {
                if ((ToArrayIndexNode.doubleIsIntIndex(arg0Value_))) {
                    return ToArrayIndexNode.doDoubleAsIntIndex(arg0Value_);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doDoubleAsUintIndex(double) */) {
                if ((ToArrayIndexNode.doubleIsUintIndex(arg0Value_))) {
                    return ToArrayIndexNode.doDoubleAsUintIndex(arg0Value_);
                }
            }
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            if ((JSGuards.isBigIntArrayIndex(arg0Value_))) {
                return ToArrayIndexNode.doBigInt(arg0Value_);
            }
        }
        if ((state_0 & 0b1100000000) != 0 /* is-state_0 doInteropArrayIndex(Object, InteropLibrary, long) || doInteropArrayIndex(Object, InteropLibrary, long) */) {
            if ((state_0 & 0b100000000) != 0 /* is-state_0 doInteropArrayIndex(Object, InteropLibrary, long) */) {
                InteropArrayIndex0Data s8_ = this.interopArrayIndex0_cache;
                while (s8_ != null) {
                    if ((s8_.interop_.accepts(arg0Value)) && (ToArrayIndexNode.notArrayIndex(arg0Value))) {
                        long index__ = (ToArrayIndexNode.toArrayIndex(arg0Value, s8_.interop_));
                        if ((index__ >= 0)) {
                            return ToArrayIndexNode.doInteropArrayIndex(arg0Value, s8_.interop_, index__);
                        }
                    }
                    s8_ = s8_.next_;
                }
            }
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 doInteropArrayIndex(Object, InteropLibrary, long) */) {
                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                Node prev_ = encapsulating_.set(this);
                try {
                    if ((ToArrayIndexNode.notArrayIndex(arg0Value))) {
                        InteropLibrary interopArrayIndex1_interop__ = (INTEROP_LIBRARY_.getUncached());
                        long interopArrayIndex1_index__ = (ToArrayIndexNode.toArrayIndex(arg0Value, interopArrayIndex1_interop__));
                        if ((interopArrayIndex1_index__ >= 0)) {
                            return this.interopArrayIndex1Boundary0(state_0, arg0Value);
                        }
                    }
                } finally {
                    encapsulating_.set(prev_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectLong(executeAndSpecialize(arg0Value));
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private long interopArrayIndex1Boundary0(int state_0, Object arg0Value) throws UnexpectedResultException {
        {
            InteropLibrary interopArrayIndex1_interop__ = (INTEROP_LIBRARY_.getUncached());
            long interopArrayIndex1_index__ = (ToArrayIndexNode.toArrayIndex(arg0Value, interopArrayIndex1_interop__));
            return ToArrayIndexNode.doInteropArrayIndex(arg0Value, interopArrayIndex1_interop__, interopArrayIndex1_index__);
        }
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                if ((JSGuards.isIntArrayIndex(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doInteger(int) */;
                    lock.unlock();
                    hasLock = false;
                    return ToArrayIndexNode.doInteger(arg0Value_);
                }
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                if ((JSGuards.isLongArrayIndex(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doLong(long) */;
                    lock.unlock();
                    hasLock = false;
                    return ToArrayIndexNode.doLong(arg0Value_);
                }
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    if (((exclude & 0b1)) == 0 /* is-not-exclude doDoubleAsIntIndex(double) */) {
                        if ((ToArrayIndexNode.doubleIsIntIndex(arg0Value_))) {
                            state_0 = (state_0 | (doubleCast0 << 12) /* set-implicit-state_0 0:double */);
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doDoubleAsIntIndex(double) */;
                            lock.unlock();
                            hasLock = false;
                            return ToArrayIndexNode.doDoubleAsIntIndex(arg0Value_);
                        }
                    }
                    if ((ToArrayIndexNode.doubleIsUintIndex(arg0Value_))) {
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude doDoubleAsIntIndex(double) */;
                        state_0 = state_0 & 0xfffffffb /* remove-state_0 doDoubleAsIntIndex(double) */;
                        state_0 = (state_0 | (doubleCast0 << 12) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doDoubleAsUintIndex(double) */;
                        lock.unlock();
                        hasLock = false;
                        return ToArrayIndexNode.doDoubleAsUintIndex(arg0Value_);
                    }
                }
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return ToArrayIndexNode.doSymbol(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                if ((JSGuards.isBigIntArrayIndex(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doBigInt(BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return ToArrayIndexNode.doBigInt(arg0Value_);
                }
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    if ((convertStringToIndex) && (JSRuntime.arrayIndexLengthInRange(arg0Value_))) {
                        this.convertFromString_startsWithDigitBranch_ = (ConditionProfile.create());
                        this.convertFromString_isArrayIndexBranch_ = (BranchProfile.create());
                        state_0 = (state_0 | (stringCast0 << 16) /* set-implicit-state_0 0:String */);
                        this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 convertFromString(String, ConditionProfile, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return ToArrayIndexNode.convertFromString(arg0Value_, this.convertFromString_startsWithDigitBranch_, this.convertFromString_isArrayIndexBranch_);
                    }
                    if ((!(convertStringToIndex) || !(JSRuntime.arrayIndexLengthInRange(arg0Value_)))) {
                        state_0 = (state_0 | (stringCast0 << 16) /* set-implicit-state_0 0:String */);
                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 convertFromStringNotInRange(String) */;
                        lock.unlock();
                        hasLock = false;
                        return ToArrayIndexNode.convertFromStringNotInRange(arg0Value_);
                    }
                }
            }
            {
                long index__ = 0L;
                if (((exclude & 0b10)) == 0 /* is-not-exclude doInteropArrayIndex(Object, InteropLibrary, long) */) {
                    int count8_ = 0;
                    InteropArrayIndex0Data s8_ = this.interopArrayIndex0_cache;
                    if ((state_0 & 0b100000000) != 0 /* is-state_0 doInteropArrayIndex(Object, InteropLibrary, long) */) {
                        while (s8_ != null) {
                            if ((s8_.interop_.accepts(arg0Value)) && (ToArrayIndexNode.notArrayIndex(arg0Value))) {
                                index__ = (ToArrayIndexNode.toArrayIndex(arg0Value, s8_.interop_));
                                if ((index__ >= 0)) {
                                    break;
                                }
                            }
                            s8_ = s8_.next_;
                            count8_++;
                        }
                    }
                    if (s8_ == null) {
                        if ((ToArrayIndexNode.notArrayIndex(arg0Value))) {
                            // assert (s8_.interop_.accepts(arg0Value));
                            InteropLibrary interop__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                            index__ = (ToArrayIndexNode.toArrayIndex(arg0Value, interop__));
                            if ((index__ >= 0) && count8_ < (JSConfig.InteropLibraryLimit)) {
                                s8_ = super.insert(new InteropArrayIndex0Data(interopArrayIndex0_cache));
                                s8_.interop_ = s8_.insertAccessor(interop__);
                                MemoryFence.storeStore();
                                this.interopArrayIndex0_cache = s8_;
                                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doInteropArrayIndex(Object, InteropLibrary, long) */;
                            }
                        }
                    }
                    if (s8_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return ToArrayIndexNode.doInteropArrayIndex(arg0Value, s8_.interop_, index__);
                    }
                }
            }
            {
                long interopArrayIndex1_index__ = 0L;
                InteropLibrary interopArrayIndex1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((ToArrayIndexNode.notArrayIndex(arg0Value))) {
                            interopArrayIndex1_interop__ = (INTEROP_LIBRARY_.getUncached());
                            interopArrayIndex1_index__ = (ToArrayIndexNode.toArrayIndex(arg0Value, interopArrayIndex1_interop__));
                            if ((interopArrayIndex1_index__ >= 0)) {
                                this.exclude_ = exclude = exclude | 0b10 /* add-exclude doInteropArrayIndex(Object, InteropLibrary, long) */;
                                this.interopArrayIndex0_cache = null;
                                state_0 = state_0 & 0xfffffeff /* remove-state_0 doInteropArrayIndex(Object, InteropLibrary, long) */;
                                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doInteropArrayIndex(Object, InteropLibrary, long) */;
                                lock.unlock();
                                hasLock = false;
                                return ToArrayIndexNode.doInteropArrayIndex(arg0Value, interopArrayIndex1_interop__, interopArrayIndex1_index__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if (((exclude & 0b100)) == 0 /* is-not-exclude doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */) {
                int count10_ = 0;
                NonArrayIndex0Data s10_ = this.nonArrayIndex0_cache;
                if ((state_0 & 0b10000000000) != 0 /* is-state_0 doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */) {
                    while (s10_ != null) {
                        if ((s10_.interop_.accepts(arg0Value)) && (ToArrayIndexNode.notArrayIndex(arg0Value)) && (ToArrayIndexNode.toArrayIndex(arg0Value, s10_.interop_) < 0)) {
                            break;
                        }
                        s10_ = s10_.next_;
                        count10_++;
                    }
                }
                if (s10_ == null) {
                    if ((ToArrayIndexNode.notArrayIndex(arg0Value))) {
                        // assert (s10_.interop_.accepts(arg0Value));
                        InteropLibrary interop__1 = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                        if ((ToArrayIndexNode.toArrayIndex(arg0Value, interop__1) < 0) && count10_ < (JSConfig.InteropLibraryLimit)) {
                            s10_ = super.insert(new NonArrayIndex0Data(nonArrayIndex0_cache));
                            s10_.interop_ = s10_.insertAccessor(interop__1);
                            s10_.toPropertyKey_ = s10_.insertAccessor((JSToPropertyKeyNode.create()));
                            s10_.recursive_ = s10_.insertAccessor((ToArrayIndexNode.createNoToPropertyKey()));
                            MemoryFence.storeStore();
                            this.nonArrayIndex0_cache = s10_;
                            this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */;
                        }
                    }
                }
                if (s10_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doNonArrayIndex(arg0Value, s10_.interop_, s10_.toPropertyKey_, s10_.recursive_);
                }
            }
            {
                InteropLibrary nonArrayIndex1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((ToArrayIndexNode.notArrayIndex(arg0Value))) {
                            nonArrayIndex1_interop__ = (INTEROP_LIBRARY_.getUncached());
                            if ((ToArrayIndexNode.toArrayIndex(arg0Value, nonArrayIndex1_interop__) < 0)) {
                                this.nonArrayIndex1_toPropertyKey_ = super.insert((JSToPropertyKeyNode.create()));
                                this.nonArrayIndex1_recursive_ = super.insert((ToArrayIndexNode.createNoToPropertyKey()));
                                this.exclude_ = exclude = exclude | 0b100 /* add-exclude doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */;
                                this.nonArrayIndex0_cache = null;
                                state_0 = state_0 & 0xfffffbff /* remove-state_0 doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */;
                                this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */;
                                lock.unlock();
                                hasLock = false;
                                return doNonArrayIndex(arg0Value, nonArrayIndex1_interop__, this.nonArrayIndex1_toPropertyKey_, this.nonArrayIndex1_recursive_);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
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
        if ((state_0 & 0b111111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b111111111111) & ((state_0 & 0b111111111111) - 1)) == 0 /* is-single-state_0  */) {
                InteropArrayIndex0Data s8_ = this.interopArrayIndex0_cache;
                NonArrayIndex0Data s10_ = this.nonArrayIndex0_cache;
                if ((s8_ == null || s8_.next_ == null) && (s10_ == null || s10_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[13];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state_0 & 0b1) != 0 /* is-state_0 doInteger(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state_0 & 0b10) != 0 /* is-state_0 doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDoubleAsIntIndex";
        if ((state_0 & 0b100) != 0 /* is-state_0 doDoubleAsIntIndex(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doDoubleAsIntIndex(double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doDoubleAsUintIndex";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doDoubleAsUintIndex(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doSymbol(Symbol) */) {
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
        s[0] = "convertFromString";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 convertFromString(String, ConditionProfile, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.convertFromString_startsWithDigitBranch_, this.convertFromString_isArrayIndexBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "convertFromStringNotInRange";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 convertFromStringNotInRange(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doInteropArrayIndex";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doInteropArrayIndex(Object, InteropLibrary, long) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            InteropArrayIndex0Data s8_ = this.interopArrayIndex0_cache;
            while (s8_ != null) {
                cached.add(Arrays.asList(s8_.interop_));
                s8_ = s8_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doInteropArrayIndex(Object, InteropLibrary, long) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doInteropArrayIndex";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doInteropArrayIndex(Object, InteropLibrary, long) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doNonArrayIndex";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            NonArrayIndex0Data s10_ = this.nonArrayIndex0_cache;
            while (s10_ != null) {
                cached.add(Arrays.asList(s10_.interop_, s10_.toPropertyKey_, s10_.recursive_));
                s10_ = s10_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b100) != 0 /* is-exclude doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doNonArrayIndex";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doNonArrayIndex(Object, InteropLibrary, JSToPropertyKeyNode, ToArrayIndexNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.nonArrayIndex1_toPropertyKey_, this.nonArrayIndex1_recursive_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        return Provider.create(data);
    }

    public static ToArrayIndexNode create(boolean convertToPropertyKey, boolean convertStringToIndex) {
        return new ToArrayIndexNodeGen(convertToPropertyKey, convertStringToIndex);
    }

    @GeneratedBy(ToArrayIndexNode.class)
    private static final class InteropArrayIndex0Data extends Node {

        @Child InteropArrayIndex0Data next_;
        @Child InteropLibrary interop_;

        InteropArrayIndex0Data(InteropArrayIndex0Data next_) {
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
    @GeneratedBy(ToArrayIndexNode.class)
    private static final class NonArrayIndex0Data extends Node {

        @Child NonArrayIndex0Data next_;
        @Child InteropLibrary interop_;
        @Child JSToPropertyKeyNode toPropertyKey_;
        @Child ToArrayIndexNode recursive_;

        NonArrayIndex0Data(NonArrayIndex0Data next_) {
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
