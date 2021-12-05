// CheckStyle: start generated
package com.oracle.truffle.polyglot;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.polyglot.PolyglotObjectProxyHandler.ProxyInvokeNode;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PolyglotObjectProxyHandler.class)
@SuppressWarnings("unused")
final class PolyglotObjectProxyHandlerFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(ProxyInvokeNode.class)
    static final class ProxyInvokeNodeGen extends ProxyInvokeNode {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private CachedMethod0Data cachedMethod0_cache;
        @Child private CachedMethod1Data cachedMethod1_cache;

        private ProxyInvokeNodeGen() {
        }

        @ExplodeLoop
        @Override
        public Object execute(PolyglotLanguageContext arg0Value, Object arg1Value, Method arg2Value, Object[] arg3Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCachedMethod(PolyglotLanguageContext, Object, Method, Object[], Method, String, Class<>, Type, InteropLibrary, InteropLibrary, ConditionProfile, PolyglotToHostNode, BranchProfile) || doCachedMethod(PolyglotLanguageContext, Object, Method, Object[], Method, String, Class<>, Type, InteropLibrary, InteropLibrary, ConditionProfile, PolyglotToHostNode, BranchProfile) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCachedMethod(PolyglotLanguageContext, Object, Method, Object[], Method, String, Class<>, Type, InteropLibrary, InteropLibrary, ConditionProfile, PolyglotToHostNode, BranchProfile) */) {
                    CachedMethod0Data s0_ = this.cachedMethod0_cache;
                    while (s0_ != null) {
                        if ((s0_.receivers_.accepts(arg1Value)) && (s0_.cachedMethod_ == arg2Value)) {
                            return doCachedMethod(arg0Value, arg1Value, arg2Value, arg3Value, s0_.cachedMethod_, s0_.name_, s0_.returnClass_, s0_.returnType_, s0_.receivers_, s0_.members_, s0_.branchProfile_, s0_.toHost_, s0_.error_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doCachedMethod(PolyglotLanguageContext, Object, Method, Object[], Method, String, Class<>, Type, InteropLibrary, InteropLibrary, ConditionProfile, PolyglotToHostNode, BranchProfile) */) {
                    CachedMethod1Data s1_ = this.cachedMethod1_cache;
                    while (s1_ != null) {
                        if ((s1_.cachedMethod_ == arg2Value)) {
                            return this.cachedMethod1Boundary(state_0, s1_, arg0Value, arg1Value, arg2Value, arg3Value);
                        }
                        s1_ = s1_.next_;
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object cachedMethod1Boundary(int state_0, CachedMethod1Data s1_, PolyglotLanguageContext arg0Value, Object arg1Value, Method arg2Value, Object[] arg3Value) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary receivers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                    return doCachedMethod(arg0Value, arg1Value, arg2Value, arg3Value, s1_.cachedMethod_, s1_.name_, s1_.returnClass_, s1_.returnType_, receivers__, s1_.members_, s1_.branchProfile_, s1_.toHost_, s1_.error_);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        private Object executeAndSpecialize(PolyglotLanguageContext arg0Value, Object arg1Value, Method arg2Value, Object[] arg3Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCachedMethod(PolyglotLanguageContext, Object, Method, Object[], Method, String, Class<>, Type, InteropLibrary, InteropLibrary, ConditionProfile, PolyglotToHostNode, BranchProfile) */) {
                    int count0_ = 0;
                    CachedMethod0Data s0_ = this.cachedMethod0_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCachedMethod(PolyglotLanguageContext, Object, Method, Object[], Method, String, Class<>, Type, InteropLibrary, InteropLibrary, ConditionProfile, PolyglotToHostNode, BranchProfile) */) {
                        while (s0_ != null) {
                            if ((s0_.receivers_.accepts(arg1Value)) && (s0_.cachedMethod_ == arg2Value)) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        // assert (s0_.receivers_.accepts(arg1Value));
                        // assert (s0_.cachedMethod_ == arg2Value);
                        if (count0_ < (ProxyInvokeNode.LIMIT)) {
                            s0_ = super.insert(new CachedMethod0Data(cachedMethod0_cache));
                            s0_.cachedMethod_ = (arg2Value);
                            s0_.name_ = (arg2Value.getName());
                            s0_.returnClass_ = (ProxyInvokeNode.getMethodReturnType(arg2Value));
                            s0_.returnType_ = (ProxyInvokeNode.getMethodGenericReturnType(arg2Value));
                            s0_.receivers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                            s0_.members_ = s0_.insertAccessor((INTEROP_LIBRARY_.createDispatched(ProxyInvokeNode.LIMIT)));
                            s0_.branchProfile_ = (ConditionProfile.create());
                            s0_.toHost_ = s0_.insertAccessor((PolyglotToHostNodeGen.create()));
                            s0_.error_ = (BranchProfile.create());
                            MemoryFence.storeStore();
                            this.cachedMethod0_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCachedMethod(PolyglotLanguageContext, Object, Method, Object[], Method, String, Class<>, Type, InteropLibrary, InteropLibrary, ConditionProfile, PolyglotToHostNode, BranchProfile) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCachedMethod(arg0Value, arg1Value, arg2Value, arg3Value, s0_.cachedMethod_, s0_.name_, s0_.returnClass_, s0_.returnType_, s0_.receivers_, s0_.members_, s0_.branchProfile_, s0_.toHost_, s0_.error_);
                    }
                }
                {
                    InteropLibrary receivers__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            int count1_ = 0;
                            CachedMethod1Data s1_ = this.cachedMethod1_cache;
                            if ((state_0 & 0b10) != 0 /* is-state_0 doCachedMethod(PolyglotLanguageContext, Object, Method, Object[], Method, String, Class<>, Type, InteropLibrary, InteropLibrary, ConditionProfile, PolyglotToHostNode, BranchProfile) */) {
                                while (s1_ != null) {
                                    if ((s1_.cachedMethod_ == arg2Value)) {
                                        receivers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                        break;
                                    }
                                    s1_ = s1_.next_;
                                    count1_++;
                                }
                            }
                            if (s1_ == null) {
                                // assert (s1_.cachedMethod_ == arg2Value);
                                if (count1_ < (ProxyInvokeNode.LIMIT)) {
                                    s1_ = super.insert(new CachedMethod1Data(cachedMethod1_cache));
                                    s1_.cachedMethod_ = (arg2Value);
                                    s1_.name_ = (arg2Value.getName());
                                    s1_.returnClass_ = (ProxyInvokeNode.getMethodReturnType(arg2Value));
                                    s1_.returnType_ = (ProxyInvokeNode.getMethodGenericReturnType(arg2Value));
                                    receivers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                    s1_.members_ = s1_.insertAccessor((INTEROP_LIBRARY_.createDispatched(ProxyInvokeNode.LIMIT)));
                                    s1_.branchProfile_ = (ConditionProfile.create());
                                    s1_.toHost_ = s1_.insertAccessor((PolyglotToHostNodeGen.create()));
                                    s1_.error_ = (BranchProfile.create());
                                    MemoryFence.storeStore();
                                    this.cachedMethod1_cache = s1_;
                                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCachedMethod(PolyglotLanguageContext, Object, Method, Object[], Method, String, Class<>, Type, InteropLibrary, InteropLibrary, ConditionProfile, PolyglotToHostNode, BranchProfile) */;
                                    this.cachedMethod0_cache = null;
                                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doCachedMethod(PolyglotLanguageContext, Object, Method, Object[], Method, String, Class<>, Type, InteropLibrary, InteropLibrary, ConditionProfile, PolyglotToHostNode, BranchProfile) */;
                                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCachedMethod(PolyglotLanguageContext, Object, Method, Object[], Method, String, Class<>, Type, InteropLibrary, InteropLibrary, ConditionProfile, PolyglotToHostNode, BranchProfile) */;
                                }
                            }
                            if (s1_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return doCachedMethod(arg0Value, arg1Value, arg2Value, arg3Value, s1_.cachedMethod_, s1_.name_, s1_.returnClass_, s1_.returnType_, receivers__, s1_.members_, s1_.branchProfile_, s1_.toHost_, s1_.error_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value);
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
                    CachedMethod0Data s0_ = this.cachedMethod0_cache;
                    CachedMethod1Data s1_ = this.cachedMethod1_cache;
                    if ((s0_ == null || s0_.next_ == null) && (s1_ == null || s1_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static ProxyInvokeNode create() {
            return new ProxyInvokeNodeGen();
        }

        @GeneratedBy(ProxyInvokeNode.class)
        private static final class CachedMethod0Data extends Node {

            @Child CachedMethod0Data next_;
            @CompilationFinal Method cachedMethod_;
            @CompilationFinal String name_;
            @CompilationFinal Class<?> returnClass_;
            @CompilationFinal Type returnType_;
            @Child InteropLibrary receivers_;
            @Child InteropLibrary members_;
            @CompilationFinal ConditionProfile branchProfile_;
            @Child PolyglotToHostNode toHost_;
            @CompilationFinal BranchProfile error_;

            CachedMethod0Data(CachedMethod0Data next_) {
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
        @GeneratedBy(ProxyInvokeNode.class)
        private static final class CachedMethod1Data extends Node {

            @Child CachedMethod1Data next_;
            @CompilationFinal Method cachedMethod_;
            @CompilationFinal String name_;
            @CompilationFinal Class<?> returnClass_;
            @CompilationFinal Type returnType_;
            @Child InteropLibrary members_;
            @CompilationFinal ConditionProfile branchProfile_;
            @Child PolyglotToHostNode toHost_;
            @CompilationFinal BranchProfile error_;

            CachedMethod1Data(CachedMethod1Data next_) {
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
}
