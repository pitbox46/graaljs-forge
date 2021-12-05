// CheckStyle: start generated
package com.oracle.truffle.regex;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.regex.AbstractConstantKeysObject.IsMemberReadable;
import com.oracle.truffle.regex.AbstractConstantKeysObject.ReadMember;
import java.util.concurrent.locks.Lock;

@GeneratedBy(AbstractConstantKeysObject.class)
public final class AbstractConstantKeysObjectGen {

    static  {
        LibraryExport.register(AbstractConstantKeysObject.class, new InteropLibraryExports());
    }

    private AbstractConstantKeysObjectGen() {
    }

    @GeneratedBy(AbstractConstantKeysObject.class)
    public static class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, AbstractConstantKeysObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof AbstractConstantKeysObject;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof AbstractConstantKeysObject;
            return new Cached(receiver);
        }

        @GeneratedBy(AbstractConstantKeysObject.class)
        public static class Cached extends AbstractRegexObjectGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @CompilationFinal private IsMemberReadableCacheIdentityData isMemberReadable_cacheIdentity_cache;
            @CompilationFinal private IsMemberReadableCacheEqualsData isMemberReadable_cacheEquals_cache;
            @CompilationFinal private ReadMemberReadIdentityData readMember_readIdentity_cache;
            @CompilationFinal private ReadMemberReadEqualsData readMember_readEquals_cache;
            @CompilationFinal private ValueProfile readMember_read_classProfile_;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @ExplodeLoop
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                AbstractConstantKeysObject arg0Value = ((AbstractConstantKeysObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b111) != 0 /* is-state_0 cacheIdentity(AbstractConstantKeysObject, String, String, boolean) || cacheEquals(AbstractConstantKeysObject, String, String, boolean) || isReadable(AbstractConstantKeysObject, String) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 cacheIdentity(AbstractConstantKeysObject, String, String, boolean) */) {
                        IsMemberReadableCacheIdentityData s0_ = this.isMemberReadable_cacheIdentity_cache;
                        while (s0_ != null) {
                            if ((arg1Value == s0_.cachedSymbol_)) {
                                assert (s0_.result_);
                                return IsMemberReadable.cacheIdentity(arg0Value, arg1Value, s0_.cachedSymbol_, s0_.result_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 cacheEquals(AbstractConstantKeysObject, String, String, boolean) */) {
                        IsMemberReadableCacheEqualsData s1_ = this.isMemberReadable_cacheEquals_cache;
                        while (s1_ != null) {
                            if ((arg1Value.equals(s1_.cachedSymbol_))) {
                                assert (s1_.result_);
                                return IsMemberReadable.cacheEquals(arg0Value, arg1Value, s1_.cachedSymbol_, s1_.result_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 isReadable(AbstractConstantKeysObject, String) */) {
                        return IsMemberReadable.isReadable(arg0Value, arg1Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberReadableAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberReadableAndSpecialize(AbstractConstantKeysObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if (((exclude & 0b1)) == 0 /* is-not-exclude cacheIdentity(AbstractConstantKeysObject, String, String, boolean) */) {
                        int count0_ = 0;
                        IsMemberReadableCacheIdentityData s0_ = this.isMemberReadable_cacheIdentity_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 cacheIdentity(AbstractConstantKeysObject, String, String, boolean) */) {
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
                                if ((result__) && count0_ < (8)) {
                                    s0_ = new IsMemberReadableCacheIdentityData(isMemberReadable_cacheIdentity_cache);
                                    s0_.cachedSymbol_ = cachedSymbol__;
                                    s0_.result_ = result__;
                                    MemoryFence.storeStore();
                                    this.isMemberReadable_cacheIdentity_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 cacheIdentity(AbstractConstantKeysObject, String, String, boolean) */;
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberReadable.cacheIdentity(arg0Value, arg1Value, s0_.cachedSymbol_, s0_.result_);
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-exclude cacheEquals(AbstractConstantKeysObject, String, String, boolean) */) {
                        int count1_ = 0;
                        IsMemberReadableCacheEqualsData s1_ = this.isMemberReadable_cacheEquals_cache;
                        if ((state_0 & 0b10) != 0 /* is-state_0 cacheEquals(AbstractConstantKeysObject, String, String, boolean) */) {
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
                                if ((result__1) && count1_ < (8)) {
                                    s1_ = new IsMemberReadableCacheEqualsData(isMemberReadable_cacheEquals_cache);
                                    s1_.cachedSymbol_ = cachedSymbol__1;
                                    s1_.result_ = result__1;
                                    MemoryFence.storeStore();
                                    this.isMemberReadable_cacheEquals_cache = s1_;
                                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude cacheIdentity(AbstractConstantKeysObject, String, String, boolean) */;
                                    this.isMemberReadable_cacheIdentity_cache = null;
                                    state_0 = state_0 & 0xfffffffe /* remove-state_0 cacheIdentity(AbstractConstantKeysObject, String, String, boolean) */;
                                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 cacheEquals(AbstractConstantKeysObject, String, String, boolean) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberReadable.cacheEquals(arg0Value, arg1Value, s1_.cachedSymbol_, s1_.result_);
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b11 /* add-exclude cacheIdentity(AbstractConstantKeysObject, String, String, boolean), cacheEquals(AbstractConstantKeysObject, String, String, boolean) */;
                    this.isMemberReadable_cacheIdentity_cache = null;
                    this.isMemberReadable_cacheEquals_cache = null;
                    state_0 = state_0 & 0xfffffffc /* remove-state_0 cacheIdentity(AbstractConstantKeysObject, String, String, boolean), cacheEquals(AbstractConstantKeysObject, String, String, boolean) */;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 isReadable(AbstractConstantKeysObject, String) */;
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
                AbstractConstantKeysObject arg0Value = ((AbstractConstantKeysObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b111000) != 0 /* is-state_0 readIdentity(AbstractConstantKeysObject, String, String, ValueProfile) || readEquals(AbstractConstantKeysObject, String, String, ValueProfile) || read(AbstractConstantKeysObject, String, ValueProfile) */) {
                    if ((state_0 & 0b1000) != 0 /* is-state_0 readIdentity(AbstractConstantKeysObject, String, String, ValueProfile) */) {
                        ReadMemberReadIdentityData s0_ = this.readMember_readIdentity_cache;
                        while (s0_ != null) {
                            if ((arg1Value == s0_.cachedSymbol_)) {
                                return ReadMember.readIdentity(arg0Value, arg1Value, s0_.cachedSymbol_, s0_.classProfile_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 readEquals(AbstractConstantKeysObject, String, String, ValueProfile) */) {
                        ReadMemberReadEqualsData s1_ = this.readMember_readEquals_cache;
                        while (s1_ != null) {
                            if ((arg1Value.equals(s1_.cachedSymbol_))) {
                                return ReadMember.readEquals(arg0Value, arg1Value, s1_.cachedSymbol_, s1_.classProfile_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 read(AbstractConstantKeysObject, String, ValueProfile) */) {
                        return ReadMember.read(arg0Value, arg1Value, this.readMember_read_classProfile_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberAndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberAndSpecialize(AbstractConstantKeysObject arg0Value, String arg1Value) throws UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if (((exclude & 0b100)) == 0 /* is-not-exclude readIdentity(AbstractConstantKeysObject, String, String, ValueProfile) */) {
                        int count0_ = 0;
                        ReadMemberReadIdentityData s0_ = this.readMember_readIdentity_cache;
                        if ((state_0 & 0b1000) != 0 /* is-state_0 readIdentity(AbstractConstantKeysObject, String, String, ValueProfile) */) {
                            while (s0_ != null) {
                                if ((arg1Value == s0_.cachedSymbol_)) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (arg1Value == s0_.cachedSymbol_);
                            if (count0_ < (8)) {
                                s0_ = new ReadMemberReadIdentityData(readMember_readIdentity_cache);
                                s0_.cachedSymbol_ = (arg1Value);
                                s0_.classProfile_ = (ValueProfile.createClassProfile());
                                MemoryFence.storeStore();
                                this.readMember_readIdentity_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 readIdentity(AbstractConstantKeysObject, String, String, ValueProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return ReadMember.readIdentity(arg0Value, arg1Value, s0_.cachedSymbol_, s0_.classProfile_);
                        }
                    }
                    if (((exclude & 0b1000)) == 0 /* is-not-exclude readEquals(AbstractConstantKeysObject, String, String, ValueProfile) */) {
                        int count1_ = 0;
                        ReadMemberReadEqualsData s1_ = this.readMember_readEquals_cache;
                        if ((state_0 & 0b10000) != 0 /* is-state_0 readEquals(AbstractConstantKeysObject, String, String, ValueProfile) */) {
                            while (s1_ != null) {
                                if ((arg1Value.equals(s1_.cachedSymbol_))) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            // assert (arg1Value.equals(s1_.cachedSymbol_));
                            if (count1_ < (8)) {
                                s1_ = new ReadMemberReadEqualsData(readMember_readEquals_cache);
                                s1_.cachedSymbol_ = (arg1Value);
                                s1_.classProfile_ = (ValueProfile.createClassProfile());
                                MemoryFence.storeStore();
                                this.readMember_readEquals_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b100 /* add-exclude readIdentity(AbstractConstantKeysObject, String, String, ValueProfile) */;
                                this.readMember_readIdentity_cache = null;
                                state_0 = state_0 & 0xfffffff7 /* remove-state_0 readIdentity(AbstractConstantKeysObject, String, String, ValueProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 readEquals(AbstractConstantKeysObject, String, String, ValueProfile) */;
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return ReadMember.readEquals(arg0Value, arg1Value, s1_.cachedSymbol_, s1_.classProfile_);
                        }
                    }
                    this.readMember_read_classProfile_ = (ValueProfile.createClassProfile());
                    this.exclude_ = exclude = exclude | 0b1100 /* add-exclude readIdentity(AbstractConstantKeysObject, String, String, ValueProfile), readEquals(AbstractConstantKeysObject, String, String, ValueProfile) */;
                    this.readMember_readIdentity_cache = null;
                    this.readMember_readEquals_cache = null;
                    state_0 = state_0 & 0xffffffe7 /* remove-state_0 readIdentity(AbstractConstantKeysObject, String, String, ValueProfile), readEquals(AbstractConstantKeysObject, String, String, ValueProfile) */;
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 read(AbstractConstantKeysObject, String, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return ReadMember.read(arg0Value, arg1Value, this.readMember_read_classProfile_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((AbstractConstantKeysObject) receiver)).hasMembers();
            }

            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((AbstractConstantKeysObject) receiver)).getMembers(includeInternal);
            }

            @GeneratedBy(AbstractConstantKeysObject.class)
            private static final class IsMemberReadableCacheIdentityData {

                @CompilationFinal IsMemberReadableCacheIdentityData next_;
                @CompilationFinal String cachedSymbol_;
                @CompilationFinal boolean result_;

                IsMemberReadableCacheIdentityData(IsMemberReadableCacheIdentityData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(AbstractConstantKeysObject.class)
            private static final class IsMemberReadableCacheEqualsData {

                @CompilationFinal IsMemberReadableCacheEqualsData next_;
                @CompilationFinal String cachedSymbol_;
                @CompilationFinal boolean result_;

                IsMemberReadableCacheEqualsData(IsMemberReadableCacheEqualsData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(AbstractConstantKeysObject.class)
            private static final class ReadMemberReadIdentityData {

                @CompilationFinal ReadMemberReadIdentityData next_;
                @CompilationFinal String cachedSymbol_;
                @CompilationFinal ValueProfile classProfile_;

                ReadMemberReadIdentityData(ReadMemberReadIdentityData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(AbstractConstantKeysObject.class)
            private static final class ReadMemberReadEqualsData {

                @CompilationFinal ReadMemberReadEqualsData next_;
                @CompilationFinal String cachedSymbol_;
                @CompilationFinal ValueProfile classProfile_;

                ReadMemberReadEqualsData(ReadMemberReadEqualsData next_) {
                    this.next_ = next_;
                }

            }
        }
        @GeneratedBy(AbstractConstantKeysObject.class)
        public static class Uncached extends AbstractRegexObjectGen.InteropLibraryExports.Uncached {

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
                AbstractConstantKeysObject arg0Value = ((AbstractConstantKeysObject) arg0Value_);
                return IsMemberReadable.isReadable(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                AbstractConstantKeysObject arg0Value = ((AbstractConstantKeysObject) arg0Value_);
                return ReadMember.read(arg0Value, arg1Value, (ValueProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((AbstractConstantKeysObject) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((AbstractConstantKeysObject) receiver) .getMembers(includeInternal);
            }

        }
    }
}
