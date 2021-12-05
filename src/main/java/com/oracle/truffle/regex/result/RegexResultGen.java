// CheckStyle: start generated
package com.oracle.truffle.regex.result;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.regex.AbstractConstantKeysObjectGen;
import com.oracle.truffle.regex.result.RegexResult.InvokeCacheNode;
import com.oracle.truffle.regex.result.RegexResult.IsMemberInvocable;
import com.oracle.truffle.regex.result.RegexResult.IsMemberReadable;
import com.oracle.truffle.regex.result.RegexResult.ReadMember;
import com.oracle.truffle.regex.result.RegexResultFactory.InvokeCacheNodeGen;
import com.oracle.truffle.regex.runtime.nodes.ToIntNode;
import com.oracle.truffle.regex.runtime.nodes.ToIntNodeGen;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RegexResult.class)
final class RegexResultGen {

    static  {
        LibraryExport.register(RegexResult.class, new InteropLibraryExports());
    }

    private RegexResultGen() {
    }

    @GeneratedBy(RegexResult.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, RegexResult.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof RegexResult;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof RegexResult;
            return new Cached(receiver);
        }

        @GeneratedBy(RegexResult.class)
        private static final class Cached extends AbstractConstantKeysObjectGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @CompilationFinal private IsMemberReadableCacheIdentityData isMemberReadable_cacheIdentity_cache;
            @CompilationFinal private IsMemberReadableCacheEqualsData isMemberReadable_cacheEquals_cache;
            @CompilationFinal private ReadMemberIsMatchIdentityData readMember_isMatchIdentity_cache;
            @CompilationFinal private ReadMemberIsMatchEqualsData readMember_isMatchEquals_cache;
            @CompilationFinal private ReadMemberGetStartIdentityData readMember_getStartIdentity_cache;
            @CompilationFinal private ReadMemberGetStartEqualsData readMember_getStartEquals_cache;
            @CompilationFinal private ReadMemberGetEndIdentityData readMember_getEndIdentity_cache;
            @CompilationFinal private ReadMemberGetEndEqualsData readMember_getEndEquals_cache;
            @CompilationFinal private IsMemberInvocableCacheIdentityData isMemberInvocable_cacheIdentity_cache;
            @CompilationFinal private IsMemberInvocableCacheEqualsData isMemberInvocable_cacheEquals_cache;
            @Child private ToIntNode invokeMemberNode__invokeMember_toIntNode_;
            @Child private InvokeCacheNode invokeMemberNode__invokeMember_invokeCache_;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @ExplodeLoop
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                RegexResult arg0Value = ((RegexResult) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b111) != 0 /* is-state_0 cacheIdentity(RegexResult, String, String, boolean) || cacheEquals(RegexResult, String, String, boolean) || isReadable(RegexResult, String) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 cacheIdentity(RegexResult, String, String, boolean) */) {
                        IsMemberReadableCacheIdentityData s0_ = this.isMemberReadable_cacheIdentity_cache;
                        while (s0_ != null) {
                            if ((arg1Value == s0_.cachedSymbol_)) {
                                assert (s0_.result_);
                                return IsMemberReadable.cacheIdentity(arg0Value, arg1Value, s0_.cachedSymbol_, s0_.result_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 cacheEquals(RegexResult, String, String, boolean) */) {
                        IsMemberReadableCacheEqualsData s1_ = this.isMemberReadable_cacheEquals_cache;
                        while (s1_ != null) {
                            if ((arg1Value.equals(s1_.cachedSymbol_))) {
                                assert (s1_.result_);
                                return IsMemberReadable.cacheEquals(arg0Value, arg1Value, s1_.cachedSymbol_, s1_.result_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 isReadable(RegexResult, String) */) {
                        return IsMemberReadable.isReadable(arg0Value, arg1Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberReadableAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberReadableAndSpecialize(RegexResult arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if (((exclude & 0b1)) == 0 /* is-not-exclude cacheIdentity(RegexResult, String, String, boolean) */) {
                        int count0_ = 0;
                        IsMemberReadableCacheIdentityData s0_ = this.isMemberReadable_cacheIdentity_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 cacheIdentity(RegexResult, String, String, boolean) */) {
                            while (s0_ != null) {
                                if ((arg1Value == s0_.cachedSymbol_)) {
                                    assert (s0_.result_);
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                String cachedSymbol__ = (arg1Value);
                                boolean result__ = (IsMemberReadable.isReadable(arg0Value, cachedSymbol__));
                                // assert (arg1Value == s0_.cachedSymbol_);
                                if ((result__) && count0_ < (3)) {
                                    s0_ = new IsMemberReadableCacheIdentityData(isMemberReadable_cacheIdentity_cache);
                                    s0_.cachedSymbol_ = cachedSymbol__;
                                    s0_.result_ = result__;
                                    MemoryFence.storeStore();
                                    this.isMemberReadable_cacheIdentity_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 cacheIdentity(RegexResult, String, String, boolean) */;
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberReadable.cacheIdentity(arg0Value, arg1Value, s0_.cachedSymbol_, s0_.result_);
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-exclude cacheEquals(RegexResult, String, String, boolean) */) {
                        int count1_ = 0;
                        IsMemberReadableCacheEqualsData s1_ = this.isMemberReadable_cacheEquals_cache;
                        if ((state_0 & 0b10) != 0 /* is-state_0 cacheEquals(RegexResult, String, String, boolean) */) {
                            while (s1_ != null) {
                                if ((arg1Value.equals(s1_.cachedSymbol_))) {
                                    assert (s1_.result_);
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                String cachedSymbol__1 = (arg1Value);
                                boolean result__1 = (IsMemberReadable.isReadable(arg0Value, cachedSymbol__1));
                                // assert (arg1Value.equals(s1_.cachedSymbol_));
                                if ((result__1) && count1_ < (3)) {
                                    s1_ = new IsMemberReadableCacheEqualsData(isMemberReadable_cacheEquals_cache);
                                    s1_.cachedSymbol_ = cachedSymbol__1;
                                    s1_.result_ = result__1;
                                    MemoryFence.storeStore();
                                    this.isMemberReadable_cacheEquals_cache = s1_;
                                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude cacheIdentity(RegexResult, String, String, boolean) */;
                                    this.isMemberReadable_cacheIdentity_cache = null;
                                    state_0 = state_0 & 0xfffffffe /* remove-state_0 cacheIdentity(RegexResult, String, String, boolean) */;
                                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 cacheEquals(RegexResult, String, String, boolean) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberReadable.cacheEquals(arg0Value, arg1Value, s1_.cachedSymbol_, s1_.result_);
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b11 /* add-exclude cacheIdentity(RegexResult, String, String, boolean), cacheEquals(RegexResult, String, String, boolean) */;
                    this.isMemberReadable_cacheIdentity_cache = null;
                    this.isMemberReadable_cacheEquals_cache = null;
                    state_0 = state_0 & 0xfffffffc /* remove-state_0 cacheIdentity(RegexResult, String, String, boolean), cacheEquals(RegexResult, String, String, boolean) */;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 isReadable(RegexResult, String) */;
                    lock.unlock();
                    hasLock = false;
                    return IsMemberReadable.isReadable(arg0Value, arg1Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public NodeCost getCost() {
                int state_0 = this.state_0_;
                if ((state_0 & 0b111) == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
                        IsMemberReadableCacheIdentityData s0_ = this.isMemberReadable_cacheIdentity_cache;
                        IsMemberReadableCacheEqualsData s1_ = this.isMemberReadable_cacheEquals_cache;
                        if ((s0_ == null || s0_.next_ == null) && (s1_ == null || s1_.next_ == null)) {
                            return NodeCost.MONOMORPHIC;
                        }
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            @ExplodeLoop
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                RegexResult arg0Value = ((RegexResult) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1111111000) != 0 /* is-state_0 isMatchIdentity(RegexResult, String, String) || isMatchEquals(RegexResult, String, String) || getStartIdentity(RegexResult, String, String) || getStartEquals(RegexResult, String, String) || getEndIdentity(RegexResult, String, String) || getEndEquals(RegexResult, String, String) || readGeneric(RegexResult, String) */) {
                    if ((state_0 & 0b1000) != 0 /* is-state_0 isMatchIdentity(RegexResult, String, String) */) {
                        ReadMemberIsMatchIdentityData s0_ = this.readMember_isMatchIdentity_cache;
                        while (s0_ != null) {
                            if ((arg1Value == s0_.cachedSymbol_)) {
                                assert (s0_.cachedSymbol_.equals(RegexResult.PROP_IS_MATCH));
                                return ReadMember.isMatchIdentity(arg0Value, arg1Value, s0_.cachedSymbol_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 isMatchEquals(RegexResult, String, String) */) {
                        ReadMemberIsMatchEqualsData s1_ = this.readMember_isMatchEquals_cache;
                        while (s1_ != null) {
                            if ((arg1Value.equals(s1_.cachedSymbol_))) {
                                assert (s1_.cachedSymbol_.equals(RegexResult.PROP_IS_MATCH));
                                return ReadMember.isMatchEquals(arg0Value, arg1Value, s1_.cachedSymbol_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 getStartIdentity(RegexResult, String, String) */) {
                        ReadMemberGetStartIdentityData s2_ = this.readMember_getStartIdentity_cache;
                        while (s2_ != null) {
                            if ((arg1Value == s2_.cachedSymbol_)) {
                                assert (s2_.cachedSymbol_.equals(RegexResult.PROP_GET_START));
                                return ReadMember.getStartIdentity(arg0Value, arg1Value, s2_.cachedSymbol_);
                            }
                            s2_ = s2_.next_;
                        }
                    }
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 getStartEquals(RegexResult, String, String) */) {
                        ReadMemberGetStartEqualsData s3_ = this.readMember_getStartEquals_cache;
                        while (s3_ != null) {
                            if ((arg1Value.equals(s3_.cachedSymbol_))) {
                                assert (s3_.cachedSymbol_.equals(RegexResult.PROP_GET_START));
                                return ReadMember.getStartEquals(arg0Value, arg1Value, s3_.cachedSymbol_);
                            }
                            s3_ = s3_.next_;
                        }
                    }
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 getEndIdentity(RegexResult, String, String) */) {
                        ReadMemberGetEndIdentityData s4_ = this.readMember_getEndIdentity_cache;
                        while (s4_ != null) {
                            if ((arg1Value == s4_.cachedSymbol_)) {
                                assert (s4_.cachedSymbol_.equals(RegexResult.PROP_GET_END));
                                return ReadMember.getEndIdentity(arg0Value, arg1Value, s4_.cachedSymbol_);
                            }
                            s4_ = s4_.next_;
                        }
                    }
                    if ((state_0 & 0b100000000) != 0 /* is-state_0 getEndEquals(RegexResult, String, String) */) {
                        ReadMemberGetEndEqualsData s5_ = this.readMember_getEndEquals_cache;
                        while (s5_ != null) {
                            if ((arg1Value.equals(s5_.cachedSymbol_))) {
                                assert (s5_.cachedSymbol_.equals(RegexResult.PROP_GET_END));
                                return ReadMember.getEndEquals(arg0Value, arg1Value, s5_.cachedSymbol_);
                            }
                            s5_ = s5_.next_;
                        }
                    }
                    if ((state_0 & 0b1000000000) != 0 /* is-state_0 readGeneric(RegexResult, String) */) {
                        return ReadMember.readGeneric(arg0Value, arg1Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberAndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberAndSpecialize(RegexResult arg0Value, String arg1Value) throws UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    int oldState_0 = (state_0 & 0b1111111000);
                    try {
                        if (((exclude & 0b100)) == 0 /* is-not-exclude isMatchIdentity(RegexResult, String, String) */) {
                            int count0_ = 0;
                            ReadMemberIsMatchIdentityData s0_ = this.readMember_isMatchIdentity_cache;
                            if ((state_0 & 0b1000) != 0 /* is-state_0 isMatchIdentity(RegexResult, String, String) */) {
                                while (s0_ != null) {
                                    if ((arg1Value == s0_.cachedSymbol_)) {
                                        assert (s0_.cachedSymbol_.equals(RegexResult.PROP_IS_MATCH));
                                        break;
                                    }
                                    s0_ = s0_.next_;
                                    count0_++;
                                }
                            }
                            if (s0_ == null) {
                                {
                                    String cachedSymbol__ = (arg1Value);
                                    // assert (arg1Value == s0_.cachedSymbol_);
                                    if ((cachedSymbol__.equals(RegexResult.PROP_IS_MATCH)) && count0_ < (2)) {
                                        s0_ = new ReadMemberIsMatchIdentityData(readMember_isMatchIdentity_cache);
                                        s0_.cachedSymbol_ = cachedSymbol__;
                                        MemoryFence.storeStore();
                                        this.readMember_isMatchIdentity_cache = s0_;
                                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 isMatchIdentity(RegexResult, String, String) */;
                                    }
                                }
                            }
                            if (s0_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return ReadMember.isMatchIdentity(arg0Value, arg1Value, s0_.cachedSymbol_);
                            }
                        }
                        if (((exclude & 0b1000)) == 0 /* is-not-exclude isMatchEquals(RegexResult, String, String) */) {
                            int count1_ = 0;
                            ReadMemberIsMatchEqualsData s1_ = this.readMember_isMatchEquals_cache;
                            if ((state_0 & 0b10000) != 0 /* is-state_0 isMatchEquals(RegexResult, String, String) */) {
                                while (s1_ != null) {
                                    if ((arg1Value.equals(s1_.cachedSymbol_))) {
                                        assert (s1_.cachedSymbol_.equals(RegexResult.PROP_IS_MATCH));
                                        break;
                                    }
                                    s1_ = s1_.next_;
                                    count1_++;
                                }
                            }
                            if (s1_ == null) {
                                {
                                    String cachedSymbol__1 = (arg1Value);
                                    // assert (arg1Value.equals(s1_.cachedSymbol_));
                                    if ((cachedSymbol__1.equals(RegexResult.PROP_IS_MATCH)) && count1_ < (2)) {
                                        s1_ = new ReadMemberIsMatchEqualsData(readMember_isMatchEquals_cache);
                                        s1_.cachedSymbol_ = cachedSymbol__1;
                                        MemoryFence.storeStore();
                                        this.readMember_isMatchEquals_cache = s1_;
                                        this.exclude_ = exclude = exclude | 0b100 /* add-exclude isMatchIdentity(RegexResult, String, String) */;
                                        this.readMember_isMatchIdentity_cache = null;
                                        state_0 = state_0 & 0xfffffff7 /* remove-state_0 isMatchIdentity(RegexResult, String, String) */;
                                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 isMatchEquals(RegexResult, String, String) */;
                                    }
                                }
                            }
                            if (s1_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return ReadMember.isMatchEquals(arg0Value, arg1Value, s1_.cachedSymbol_);
                            }
                        }
                        if (((exclude & 0b10000)) == 0 /* is-not-exclude getStartIdentity(RegexResult, String, String) */) {
                            int count2_ = 0;
                            ReadMemberGetStartIdentityData s2_ = this.readMember_getStartIdentity_cache;
                            if ((state_0 & 0b100000) != 0 /* is-state_0 getStartIdentity(RegexResult, String, String) */) {
                                while (s2_ != null) {
                                    if ((arg1Value == s2_.cachedSymbol_)) {
                                        assert (s2_.cachedSymbol_.equals(RegexResult.PROP_GET_START));
                                        break;
                                    }
                                    s2_ = s2_.next_;
                                    count2_++;
                                }
                            }
                            if (s2_ == null) {
                                {
                                    String cachedSymbol__2 = (arg1Value);
                                    // assert (arg1Value == s2_.cachedSymbol_);
                                    if ((cachedSymbol__2.equals(RegexResult.PROP_GET_START)) && count2_ < (2)) {
                                        s2_ = new ReadMemberGetStartIdentityData(readMember_getStartIdentity_cache);
                                        s2_.cachedSymbol_ = cachedSymbol__2;
                                        MemoryFence.storeStore();
                                        this.readMember_getStartIdentity_cache = s2_;
                                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 getStartIdentity(RegexResult, String, String) */;
                                    }
                                }
                            }
                            if (s2_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return ReadMember.getStartIdentity(arg0Value, arg1Value, s2_.cachedSymbol_);
                            }
                        }
                        if (((exclude & 0b100000)) == 0 /* is-not-exclude getStartEquals(RegexResult, String, String) */) {
                            int count3_ = 0;
                            ReadMemberGetStartEqualsData s3_ = this.readMember_getStartEquals_cache;
                            if ((state_0 & 0b1000000) != 0 /* is-state_0 getStartEquals(RegexResult, String, String) */) {
                                while (s3_ != null) {
                                    if ((arg1Value.equals(s3_.cachedSymbol_))) {
                                        assert (s3_.cachedSymbol_.equals(RegexResult.PROP_GET_START));
                                        break;
                                    }
                                    s3_ = s3_.next_;
                                    count3_++;
                                }
                            }
                            if (s3_ == null) {
                                {
                                    String cachedSymbol__3 = (arg1Value);
                                    // assert (arg1Value.equals(s3_.cachedSymbol_));
                                    if ((cachedSymbol__3.equals(RegexResult.PROP_GET_START)) && count3_ < (2)) {
                                        s3_ = new ReadMemberGetStartEqualsData(readMember_getStartEquals_cache);
                                        s3_.cachedSymbol_ = cachedSymbol__3;
                                        MemoryFence.storeStore();
                                        this.readMember_getStartEquals_cache = s3_;
                                        this.exclude_ = exclude = exclude | 0b10000 /* add-exclude getStartIdentity(RegexResult, String, String) */;
                                        this.readMember_getStartIdentity_cache = null;
                                        state_0 = state_0 & 0xffffffdf /* remove-state_0 getStartIdentity(RegexResult, String, String) */;
                                        this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 getStartEquals(RegexResult, String, String) */;
                                    }
                                }
                            }
                            if (s3_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return ReadMember.getStartEquals(arg0Value, arg1Value, s3_.cachedSymbol_);
                            }
                        }
                        if (((exclude & 0b1000000)) == 0 /* is-not-exclude getEndIdentity(RegexResult, String, String) */) {
                            int count4_ = 0;
                            ReadMemberGetEndIdentityData s4_ = this.readMember_getEndIdentity_cache;
                            if ((state_0 & 0b10000000) != 0 /* is-state_0 getEndIdentity(RegexResult, String, String) */) {
                                while (s4_ != null) {
                                    if ((arg1Value == s4_.cachedSymbol_)) {
                                        assert (s4_.cachedSymbol_.equals(RegexResult.PROP_GET_END));
                                        break;
                                    }
                                    s4_ = s4_.next_;
                                    count4_++;
                                }
                            }
                            if (s4_ == null) {
                                {
                                    String cachedSymbol__4 = (arg1Value);
                                    // assert (arg1Value == s4_.cachedSymbol_);
                                    if ((cachedSymbol__4.equals(RegexResult.PROP_GET_END)) && count4_ < (2)) {
                                        s4_ = new ReadMemberGetEndIdentityData(readMember_getEndIdentity_cache);
                                        s4_.cachedSymbol_ = cachedSymbol__4;
                                        MemoryFence.storeStore();
                                        this.readMember_getEndIdentity_cache = s4_;
                                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 getEndIdentity(RegexResult, String, String) */;
                                    }
                                }
                            }
                            if (s4_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return ReadMember.getEndIdentity(arg0Value, arg1Value, s4_.cachedSymbol_);
                            }
                        }
                        if (((exclude & 0b10000000)) == 0 /* is-not-exclude getEndEquals(RegexResult, String, String) */) {
                            int count5_ = 0;
                            ReadMemberGetEndEqualsData s5_ = this.readMember_getEndEquals_cache;
                            if ((state_0 & 0b100000000) != 0 /* is-state_0 getEndEquals(RegexResult, String, String) */) {
                                while (s5_ != null) {
                                    if ((arg1Value.equals(s5_.cachedSymbol_))) {
                                        assert (s5_.cachedSymbol_.equals(RegexResult.PROP_GET_END));
                                        break;
                                    }
                                    s5_ = s5_.next_;
                                    count5_++;
                                }
                            }
                            if (s5_ == null) {
                                {
                                    String cachedSymbol__5 = (arg1Value);
                                    // assert (arg1Value.equals(s5_.cachedSymbol_));
                                    if ((cachedSymbol__5.equals(RegexResult.PROP_GET_END)) && count5_ < (2)) {
                                        s5_ = new ReadMemberGetEndEqualsData(readMember_getEndEquals_cache);
                                        s5_.cachedSymbol_ = cachedSymbol__5;
                                        MemoryFence.storeStore();
                                        this.readMember_getEndEquals_cache = s5_;
                                        this.exclude_ = exclude = exclude | 0b1000000 /* add-exclude getEndIdentity(RegexResult, String, String) */;
                                        this.readMember_getEndIdentity_cache = null;
                                        state_0 = state_0 & 0xffffff7f /* remove-state_0 getEndIdentity(RegexResult, String, String) */;
                                        this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 getEndEquals(RegexResult, String, String) */;
                                    }
                                }
                            }
                            if (s5_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return ReadMember.getEndEquals(arg0Value, arg1Value, s5_.cachedSymbol_);
                            }
                        }
                        this.exclude_ = exclude = exclude | 0b11111100 /* add-exclude isMatchIdentity(RegexResult, String, String), isMatchEquals(RegexResult, String, String), getStartIdentity(RegexResult, String, String), getStartEquals(RegexResult, String, String), getEndIdentity(RegexResult, String, String), getEndEquals(RegexResult, String, String) */;
                        this.readMember_isMatchIdentity_cache = null;
                        this.readMember_isMatchEquals_cache = null;
                        this.readMember_getStartIdentity_cache = null;
                        this.readMember_getStartEquals_cache = null;
                        this.readMember_getEndIdentity_cache = null;
                        this.readMember_getEndEquals_cache = null;
                        state_0 = state_0 & 0xfffffe07 /* remove-state_0 isMatchIdentity(RegexResult, String, String), isMatchEquals(RegexResult, String, String), getStartIdentity(RegexResult, String, String), getStartEquals(RegexResult, String, String), getEndIdentity(RegexResult, String, String), getEndEquals(RegexResult, String, String) */;
                        this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 readGeneric(RegexResult, String) */;
                        lock.unlock();
                        hasLock = false;
                        return ReadMember.readGeneric(arg0Value, arg1Value);
                    } finally {
                        if (oldState_0 != 0) {
                            readMember_checkForPolymorphicSpecialize(oldState_0);
                        }
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            private void readMember_checkForPolymorphicSpecialize(int oldState_0) {
                if (((oldState_0 & 0b1000000000) == 0 && (this.state_0_ & 0b1000000000) != 0)) {
                    this.reportPolymorphicSpecialize();
                }
            }

            @ExplodeLoop
            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                RegexResult arg0Value = ((RegexResult) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1110000000000) != 0 /* is-state_0 cacheIdentity(RegexResult, String, String, boolean) || cacheEquals(RegexResult, String, String, boolean) || isInvocable(RegexResult, String) */) {
                    if ((state_0 & 0b10000000000) != 0 /* is-state_0 cacheIdentity(RegexResult, String, String, boolean) */) {
                        IsMemberInvocableCacheIdentityData s0_ = this.isMemberInvocable_cacheIdentity_cache;
                        while (s0_ != null) {
                            if ((arg1Value == s0_.cachedSymbol_)) {
                                assert (s0_.result_);
                                return IsMemberInvocable.cacheIdentity(arg0Value, arg1Value, s0_.cachedSymbol_, s0_.result_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b100000000000) != 0 /* is-state_0 cacheEquals(RegexResult, String, String, boolean) */) {
                        IsMemberInvocableCacheEqualsData s1_ = this.isMemberInvocable_cacheEquals_cache;
                        while (s1_ != null) {
                            if ((arg1Value.equals(s1_.cachedSymbol_))) {
                                assert (s1_.result_);
                                return IsMemberInvocable.cacheEquals(arg0Value, arg1Value, s1_.cachedSymbol_, s1_.result_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b1000000000000) != 0 /* is-state_0 isInvocable(RegexResult, String) */) {
                        return IsMemberInvocable.isInvocable(arg0Value, arg1Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInvocableAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInvocableAndSpecialize(RegexResult arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if (((exclude & 0b100000000)) == 0 /* is-not-exclude cacheIdentity(RegexResult, String, String, boolean) */) {
                        int count0_ = 0;
                        IsMemberInvocableCacheIdentityData s0_ = this.isMemberInvocable_cacheIdentity_cache;
                        if ((state_0 & 0b10000000000) != 0 /* is-state_0 cacheIdentity(RegexResult, String, String, boolean) */) {
                            while (s0_ != null) {
                                if ((arg1Value == s0_.cachedSymbol_)) {
                                    assert (s0_.result_);
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                String cachedSymbol__ = (arg1Value);
                                boolean result__ = (IsMemberInvocable.isInvocable(arg0Value, cachedSymbol__));
                                // assert (arg1Value == s0_.cachedSymbol_);
                                if ((result__) && count0_ < (2)) {
                                    s0_ = new IsMemberInvocableCacheIdentityData(isMemberInvocable_cacheIdentity_cache);
                                    s0_.cachedSymbol_ = cachedSymbol__;
                                    s0_.result_ = result__;
                                    MemoryFence.storeStore();
                                    this.isMemberInvocable_cacheIdentity_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 cacheIdentity(RegexResult, String, String, boolean) */;
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberInvocable.cacheIdentity(arg0Value, arg1Value, s0_.cachedSymbol_, s0_.result_);
                        }
                    }
                    if (((exclude & 0b1000000000)) == 0 /* is-not-exclude cacheEquals(RegexResult, String, String, boolean) */) {
                        int count1_ = 0;
                        IsMemberInvocableCacheEqualsData s1_ = this.isMemberInvocable_cacheEquals_cache;
                        if ((state_0 & 0b100000000000) != 0 /* is-state_0 cacheEquals(RegexResult, String, String, boolean) */) {
                            while (s1_ != null) {
                                if ((arg1Value.equals(s1_.cachedSymbol_))) {
                                    assert (s1_.result_);
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                String cachedSymbol__1 = (arg1Value);
                                boolean result__1 = (IsMemberInvocable.isInvocable(arg0Value, cachedSymbol__1));
                                // assert (arg1Value.equals(s1_.cachedSymbol_));
                                if ((result__1) && count1_ < (2)) {
                                    s1_ = new IsMemberInvocableCacheEqualsData(isMemberInvocable_cacheEquals_cache);
                                    s1_.cachedSymbol_ = cachedSymbol__1;
                                    s1_.result_ = result__1;
                                    MemoryFence.storeStore();
                                    this.isMemberInvocable_cacheEquals_cache = s1_;
                                    this.exclude_ = exclude = exclude | 0b100000000 /* add-exclude cacheIdentity(RegexResult, String, String, boolean) */;
                                    this.isMemberInvocable_cacheIdentity_cache = null;
                                    state_0 = state_0 & 0xfffffbff /* remove-state_0 cacheIdentity(RegexResult, String, String, boolean) */;
                                    this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 cacheEquals(RegexResult, String, String, boolean) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberInvocable.cacheEquals(arg0Value, arg1Value, s1_.cachedSymbol_, s1_.result_);
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b1100000000 /* add-exclude cacheIdentity(RegexResult, String, String, boolean), cacheEquals(RegexResult, String, String, boolean) */;
                    this.isMemberInvocable_cacheIdentity_cache = null;
                    this.isMemberInvocable_cacheEquals_cache = null;
                    state_0 = state_0 & 0xfffff3ff /* remove-state_0 cacheIdentity(RegexResult, String, String, boolean), cacheEquals(RegexResult, String, String, boolean) */;
                    this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 isInvocable(RegexResult, String) */;
                    lock.unlock();
                    hasLock = false;
                    return IsMemberInvocable.isInvocable(arg0Value, arg1Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((RegexResult) receiver)).getMembers(includeInternal);
            }

            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                RegexResult arg0Value = ((RegexResult) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000000000) != 0 /* is-state_0 invokeMember(RegexResult, String, Object[], ToIntNode, InvokeCacheNode) */) {
                    return arg0Value.invokeMember(arg1Value, arg2Value, this.invokeMemberNode__invokeMember_toIntNode_, this.invokeMemberNode__invokeMember_invokeCache_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return invokeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object invokeMemberNode_AndSpecialize(RegexResult arg0Value, String arg1Value, Object[] arg2Value) throws UnknownIdentifierException, ArityException, UnsupportedTypeException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.invokeMemberNode__invokeMember_toIntNode_ = super.insert((ToIntNode.create()));
                    this.invokeMemberNode__invokeMember_invokeCache_ = super.insert((InvokeCacheNodeGen.create()));
                    this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 invokeMember(RegexResult, String, Object[], ToIntNode, InvokeCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.invokeMember(arg1Value, arg2Value, this.invokeMemberNode__invokeMember_toIntNode_, this.invokeMemberNode__invokeMember_invokeCache_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((RegexResult) receiver)).toDisplayString(allowSideEffects);
            }

            @GeneratedBy(RegexResult.class)
            private static final class IsMemberReadableCacheIdentityData {

                @CompilationFinal IsMemberReadableCacheIdentityData next_;
                @CompilationFinal String cachedSymbol_;
                @CompilationFinal boolean result_;

                IsMemberReadableCacheIdentityData(IsMemberReadableCacheIdentityData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(RegexResult.class)
            private static final class IsMemberReadableCacheEqualsData {

                @CompilationFinal IsMemberReadableCacheEqualsData next_;
                @CompilationFinal String cachedSymbol_;
                @CompilationFinal boolean result_;

                IsMemberReadableCacheEqualsData(IsMemberReadableCacheEqualsData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(RegexResult.class)
            private static final class ReadMemberIsMatchIdentityData {

                @CompilationFinal ReadMemberIsMatchIdentityData next_;
                @CompilationFinal String cachedSymbol_;

                ReadMemberIsMatchIdentityData(ReadMemberIsMatchIdentityData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(RegexResult.class)
            private static final class ReadMemberIsMatchEqualsData {

                @CompilationFinal ReadMemberIsMatchEqualsData next_;
                @CompilationFinal String cachedSymbol_;

                ReadMemberIsMatchEqualsData(ReadMemberIsMatchEqualsData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(RegexResult.class)
            private static final class ReadMemberGetStartIdentityData {

                @CompilationFinal ReadMemberGetStartIdentityData next_;
                @CompilationFinal String cachedSymbol_;

                ReadMemberGetStartIdentityData(ReadMemberGetStartIdentityData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(RegexResult.class)
            private static final class ReadMemberGetStartEqualsData {

                @CompilationFinal ReadMemberGetStartEqualsData next_;
                @CompilationFinal String cachedSymbol_;

                ReadMemberGetStartEqualsData(ReadMemberGetStartEqualsData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(RegexResult.class)
            private static final class ReadMemberGetEndIdentityData {

                @CompilationFinal ReadMemberGetEndIdentityData next_;
                @CompilationFinal String cachedSymbol_;

                ReadMemberGetEndIdentityData(ReadMemberGetEndIdentityData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(RegexResult.class)
            private static final class ReadMemberGetEndEqualsData {

                @CompilationFinal ReadMemberGetEndEqualsData next_;
                @CompilationFinal String cachedSymbol_;

                ReadMemberGetEndEqualsData(ReadMemberGetEndEqualsData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(RegexResult.class)
            private static final class IsMemberInvocableCacheIdentityData {

                @CompilationFinal IsMemberInvocableCacheIdentityData next_;
                @CompilationFinal String cachedSymbol_;
                @CompilationFinal boolean result_;

                IsMemberInvocableCacheIdentityData(IsMemberInvocableCacheIdentityData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(RegexResult.class)
            private static final class IsMemberInvocableCacheEqualsData {

                @CompilationFinal IsMemberInvocableCacheEqualsData next_;
                @CompilationFinal String cachedSymbol_;
                @CompilationFinal boolean result_;

                IsMemberInvocableCacheEqualsData(IsMemberInvocableCacheEqualsData next_) {
                    this.next_ = next_;
                }

            }
        }
        @GeneratedBy(RegexResult.class)
        private static final class Uncached extends AbstractConstantKeysObjectGen.InteropLibraryExports.Uncached {

            protected Uncached(Object receiver) {
                super(receiver);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                return super.accepts(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                RegexResult arg0Value = ((RegexResult) arg0Value_);
                return IsMemberReadable.isReadable(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                RegexResult arg0Value = ((RegexResult) arg0Value_);
                return ReadMember.readGeneric(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                RegexResult arg0Value = ((RegexResult) arg0Value_);
                return IsMemberInvocable.isInvocable(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((RegexResult) receiver) .getMembers(includeInternal);
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnknownIdentifierException, ArityException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                RegexResult arg0Value = ((RegexResult) arg0Value_);
                return arg0Value.invokeMember(arg1Value, arg2Value, (ToIntNodeGen.getUncached()), (InvokeCacheNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((RegexResult) receiver) .toDisplayString(allowSideEffects);
            }

        }
    }
}
