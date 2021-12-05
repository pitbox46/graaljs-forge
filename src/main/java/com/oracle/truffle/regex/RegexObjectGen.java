// CheckStyle: start generated
package com.oracle.truffle.regex;

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
import com.oracle.truffle.regex.RegexObject.InvokeCacheNode;
import com.oracle.truffle.regex.RegexObject.IsMemberInvocable;
import com.oracle.truffle.regex.RegexObjectFactory.InvokeCacheNodeGen;
import com.oracle.truffle.regex.runtime.nodes.ToLongNode;
import com.oracle.truffle.regex.runtime.nodes.ToLongNodeGen;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RegexObject.class)
final class RegexObjectGen {

    static  {
        LibraryExport.register(RegexObject.class, new InteropLibraryExports());
    }

    private RegexObjectGen() {
    }

    @GeneratedBy(RegexObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, RegexObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof RegexObject;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof RegexObject;
            return new Cached(receiver);
        }

        @GeneratedBy(RegexObject.class)
        private static final class Cached extends AbstractConstantKeysObjectGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @CompilationFinal private IsMemberInvocableCacheIdentityData isMemberInvocable_cacheIdentity_cache;
            @CompilationFinal private IsMemberInvocableCacheEqualsData isMemberInvocable_cacheEquals_cache;
            @Child private ToLongNode invokeMemberNode__invokeMember_toLongNode_;
            @Child private InvokeCacheNode invokeMemberNode__invokeMember_invokeCache_;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @ExplodeLoop
            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                RegexObject arg0Value = ((RegexObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b111) != 0 /* is-state_0 cacheIdentity(RegexObject, String, String, boolean) || cacheEquals(RegexObject, String, String, boolean) || isInvocable(RegexObject, String) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 cacheIdentity(RegexObject, String, String, boolean) */) {
                        IsMemberInvocableCacheIdentityData s0_ = this.isMemberInvocable_cacheIdentity_cache;
                        while (s0_ != null) {
                            if ((arg1Value == s0_.cachedSymbol_)) {
                                assert (s0_.result_);
                                return IsMemberInvocable.cacheIdentity(arg0Value, arg1Value, s0_.cachedSymbol_, s0_.result_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 cacheEquals(RegexObject, String, String, boolean) */) {
                        IsMemberInvocableCacheEqualsData s1_ = this.isMemberInvocable_cacheEquals_cache;
                        while (s1_ != null) {
                            if ((arg1Value.equals(s1_.cachedSymbol_))) {
                                assert (s1_.result_);
                                return IsMemberInvocable.cacheEquals(arg0Value, arg1Value, s1_.cachedSymbol_, s1_.result_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 isInvocable(RegexObject, String) */) {
                        return IsMemberInvocable.isInvocable(arg0Value, arg1Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInvocableAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInvocableAndSpecialize(RegexObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if (((exclude & 0b1)) == 0 /* is-not-exclude cacheIdentity(RegexObject, String, String, boolean) */) {
                        int count0_ = 0;
                        IsMemberInvocableCacheIdentityData s0_ = this.isMemberInvocable_cacheIdentity_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 cacheIdentity(RegexObject, String, String, boolean) */) {
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
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 cacheIdentity(RegexObject, String, String, boolean) */;
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberInvocable.cacheIdentity(arg0Value, arg1Value, s0_.cachedSymbol_, s0_.result_);
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-exclude cacheEquals(RegexObject, String, String, boolean) */) {
                        int count1_ = 0;
                        IsMemberInvocableCacheEqualsData s1_ = this.isMemberInvocable_cacheEquals_cache;
                        if ((state_0 & 0b10) != 0 /* is-state_0 cacheEquals(RegexObject, String, String, boolean) */) {
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
                                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude cacheIdentity(RegexObject, String, String, boolean) */;
                                    this.isMemberInvocable_cacheIdentity_cache = null;
                                    state_0 = state_0 & 0xfffffffe /* remove-state_0 cacheIdentity(RegexObject, String, String, boolean) */;
                                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 cacheEquals(RegexObject, String, String, boolean) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberInvocable.cacheEquals(arg0Value, arg1Value, s1_.cachedSymbol_, s1_.result_);
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b11 /* add-exclude cacheIdentity(RegexObject, String, String, boolean), cacheEquals(RegexObject, String, String, boolean) */;
                    this.isMemberInvocable_cacheIdentity_cache = null;
                    this.isMemberInvocable_cacheEquals_cache = null;
                    state_0 = state_0 & 0xfffffffc /* remove-state_0 cacheIdentity(RegexObject, String, String, boolean), cacheEquals(RegexObject, String, String, boolean) */;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 isInvocable(RegexObject, String) */;
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
            public NodeCost getCost() {
                int state_0 = this.state_0_;
                if ((state_0 & 0b111) == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
                        IsMemberInvocableCacheIdentityData s0_ = this.isMemberInvocable_cacheIdentity_cache;
                        IsMemberInvocableCacheEqualsData s1_ = this.isMemberInvocable_cacheEquals_cache;
                        if ((s0_ == null || s0_.next_ == null) && (s1_ == null || s1_.next_ == null)) {
                            return NodeCost.MONOMORPHIC;
                        }
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                RegexObject arg0Value = ((RegexObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 invokeMember(RegexObject, String, Object[], ToLongNode, InvokeCacheNode) */) {
                    return arg0Value.invokeMember(arg1Value, arg2Value, this.invokeMemberNode__invokeMember_toLongNode_, this.invokeMemberNode__invokeMember_invokeCache_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return invokeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object invokeMemberNode_AndSpecialize(RegexObject arg0Value, String arg1Value, Object[] arg2Value) throws UnknownIdentifierException, ArityException, UnsupportedTypeException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.invokeMemberNode__invokeMember_toLongNode_ = super.insert((ToLongNode.create()));
                    this.invokeMemberNode__invokeMember_invokeCache_ = super.insert((InvokeCacheNodeGen.create()));
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 invokeMember(RegexObject, String, Object[], ToLongNode, InvokeCacheNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.invokeMember(arg1Value, arg2Value, this.invokeMemberNode__invokeMember_toLongNode_, this.invokeMemberNode__invokeMember_invokeCache_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @GeneratedBy(RegexObject.class)
            private static final class IsMemberInvocableCacheIdentityData {

                @CompilationFinal IsMemberInvocableCacheIdentityData next_;
                @CompilationFinal String cachedSymbol_;
                @CompilationFinal boolean result_;

                IsMemberInvocableCacheIdentityData(IsMemberInvocableCacheIdentityData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(RegexObject.class)
            private static final class IsMemberInvocableCacheEqualsData {

                @CompilationFinal IsMemberInvocableCacheEqualsData next_;
                @CompilationFinal String cachedSymbol_;
                @CompilationFinal boolean result_;

                IsMemberInvocableCacheEqualsData(IsMemberInvocableCacheEqualsData next_) {
                    this.next_ = next_;
                }

            }
        }
        @GeneratedBy(RegexObject.class)
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
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                RegexObject arg0Value = ((RegexObject) arg0Value_);
                return IsMemberInvocable.isInvocable(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnknownIdentifierException, ArityException, UnsupportedTypeException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                RegexObject arg0Value = ((RegexObject) arg0Value_);
                return arg0Value.invokeMember(arg1Value, arg2Value, (ToLongNodeGen.getUncached()), (InvokeCacheNodeGen.getUncached()));
            }

        }
    }
}
