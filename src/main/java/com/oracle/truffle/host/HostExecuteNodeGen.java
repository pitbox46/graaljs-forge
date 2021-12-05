// CheckStyle: start generated
package com.oracle.truffle.host;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.host.HostContext.ToGuestValueNode;
import com.oracle.truffle.host.HostContextFactory.ToGuestValueNodeGen;
import com.oracle.truffle.host.HostMethodDesc.OverloadedMethod;
import com.oracle.truffle.host.HostMethodDesc.SingleMethod;
import com.oracle.truffle.host.HostMethodDesc.SingleMethod.MHBase;
import com.oracle.truffle.host.HostMethodDesc.SingleMethod.ReflectBase;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HostExecuteNode.class)
final class HostExecuteNodeGen extends HostExecuteNode {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private HostToTypeNode toHost;
    @Child private ToGuestValueNode toGuest;
    @CompilationFinal private ConditionProfile varArgsProfile;
    @Child private HostMethodProfileNode hostMethodProfile;
    @CompilationFinal private BranchProfile errorBranch;
    @CompilationFinal private BranchProfile seenScope;
    @CompilationFinal private GuestToHostCodeCache cache;
    @Child private FixedData fixed_cache;
    @Child private VarArgsData varArgs_cache;
    @Child private OverloadedCachedData overloadedCached_cache;

    private HostExecuteNodeGen() {
    }

    @ExplodeLoop
    @Override
    public Object execute(HostMethodDesc arg0Value, Object arg1Value, Object[] arg2Value, HostContext arg3Value) throws UnsupportedTypeException, ArityException {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doFixed(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode[], ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) || doVarArgs(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode, ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, boolean, GuestToHostCodeCache) || doSingleUncached(SingleMethod, Object, Object[], HostContext, HostToTypeNode, ToGuestValueNode, ConditionProfile, HostMethodProfileNode, BranchProfile, BranchProfile, GuestToHostCodeCache) || doOverloadedCached(OverloadedMethod, Object, Object[], HostContext, OverloadedMethod, HostToTypeNode, ToGuestValueNode, InteropLibrary, TypeCheckNode[], SingleMethod, boolean, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) || doOverloadedUncached(OverloadedMethod, Object, Object[], HostContext, HostToTypeNode, ToGuestValueNode, ConditionProfile, HostMethodProfileNode, BranchProfile, BranchProfile, GuestToHostCodeCache) */) {
            if ((state_0 & 0b111) != 0 /* is-state_0 doFixed(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode[], ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) || doVarArgs(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode, ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, boolean, GuestToHostCodeCache) || doSingleUncached(SingleMethod, Object, Object[], HostContext, HostToTypeNode, ToGuestValueNode, ConditionProfile, HostMethodProfileNode, BranchProfile, BranchProfile, GuestToHostCodeCache) */ && arg0Value instanceof SingleMethod) {
                SingleMethod arg0Value_ = (SingleMethod) arg0Value;
                if ((state_0 & 0b1) != 0 /* is-state_0 doFixed(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode[], ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) */ && (!(arg0Value_.isVarArgs()))) {
                    FixedData s0_ = this.fixed_cache;
                    while (s0_ != null) {
                        if ((arg0Value_ == s0_.cachedMethod_)) {
                            return doFixed(arg0Value_, arg1Value, arg2Value, arg3Value, s0_.cachedMethod_, s0_.toJavaNodes_, s0_.toGuest_, s0_.receiverProfile_, s0_.errorBranch_, s0_.seenDynamicScope_, s0_.cache_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doVarArgs(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode, ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, boolean, GuestToHostCodeCache) */ && (arg0Value_.isVarArgs())) {
                    VarArgsData s1_ = this.varArgs_cache;
                    while (s1_ != null) {
                        if ((arg0Value_ == s1_.cachedMethod_)) {
                            return doVarArgs(arg0Value_, arg1Value, arg2Value, arg3Value, s1_.cachedMethod_, s1_.toJavaNode_, s1_.toGuest_, s1_.receiverProfile_, s1_.errorBranch_, s1_.seenDynamicScope_, s1_.asVarArgs_, s1_.cache_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doSingleUncached(SingleMethod, Object, Object[], HostContext, HostToTypeNode, ToGuestValueNode, ConditionProfile, HostMethodProfileNode, BranchProfile, BranchProfile, GuestToHostCodeCache) */) {
                    return HostExecuteNode.doSingleUncached(arg0Value_, arg1Value, arg2Value, arg3Value, this.toHost, this.toGuest, this.varArgsProfile, this.hostMethodProfile, this.errorBranch, this.seenScope, this.cache);
                }
            }
            if ((state_0 & 0b11000) != 0 /* is-state_0 doOverloadedCached(OverloadedMethod, Object, Object[], HostContext, OverloadedMethod, HostToTypeNode, ToGuestValueNode, InteropLibrary, TypeCheckNode[], SingleMethod, boolean, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) || doOverloadedUncached(OverloadedMethod, Object, Object[], HostContext, HostToTypeNode, ToGuestValueNode, ConditionProfile, HostMethodProfileNode, BranchProfile, BranchProfile, GuestToHostCodeCache) */ && arg0Value instanceof OverloadedMethod) {
                OverloadedMethod arg0Value_ = (OverloadedMethod) arg0Value;
                if ((state_0 & 0b1000) != 0 /* is-state_0 doOverloadedCached(OverloadedMethod, Object, Object[], HostContext, OverloadedMethod, HostToTypeNode, ToGuestValueNode, InteropLibrary, TypeCheckNode[], SingleMethod, boolean, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) */) {
                    OverloadedCachedData s3_ = this.overloadedCached_cache;
                    while (s3_ != null) {
                        if ((arg0Value_ == s3_.cachedMethod_) && (HostExecuteNode.checkArgTypes(arg2Value, s3_.cachedArgTypes_, s3_.interop_, arg3Value, s3_.asVarArgs_))) {
                            return doOverloadedCached(arg0Value_, arg1Value, arg2Value, arg3Value, s3_.cachedMethod_, s3_.toJavaNode_, s3_.toGuest_, s3_.interop_, s3_.cachedArgTypes_, s3_.overload_, s3_.asVarArgs_, s3_.receiverProfile_, s3_.errorBranch_, s3_.seenVariableScope_, s3_.cache_);
                        }
                        s3_ = s3_.next_;
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doOverloadedUncached(OverloadedMethod, Object, Object[], HostContext, HostToTypeNode, ToGuestValueNode, ConditionProfile, HostMethodProfileNode, BranchProfile, BranchProfile, GuestToHostCodeCache) */) {
                    return doOverloadedUncached(arg0Value_, arg1Value, arg2Value, arg3Value, this.toHost, this.toGuest, this.varArgsProfile, this.hostMethodProfile, this.errorBranch, this.seenScope, this.cache);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
    }

    private Object executeAndSpecialize(HostMethodDesc arg0Value, Object arg1Value, Object[] arg2Value, HostContext arg3Value) throws ArityException, UnsupportedTypeException {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            int oldState_0 = state_0;
            int oldExclude = exclude;
            int oldCacheCount = countCaches();
            try {
                if (arg0Value instanceof SingleMethod) {
                    SingleMethod arg0Value_ = (SingleMethod) arg0Value;
                    if (((exclude & 0b1)) == 0 /* is-not-exclude doFixed(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode[], ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) */ && (!(arg0Value_.isVarArgs()))) {
                        int count0_ = 0;
                        FixedData s0_ = this.fixed_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doFixed(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode[], ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) */) {
                            while (s0_ != null) {
                                if ((arg0Value_ == s0_.cachedMethod_)) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (arg0Value_ == s0_.cachedMethod_);
                            if (count0_ < (HostExecuteNode.LIMIT)) {
                                s0_ = super.insert(new FixedData(fixed_cache));
                                s0_.cachedMethod_ = (arg0Value_);
                                s0_.toJavaNodes_ = s0_.insertAccessor((HostExecuteNode.createToHost(arg0Value_.getParameterCount())));
                                s0_.toGuest_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.receiverProfile_ = (ValueProfile.createClassProfile());
                                s0_.errorBranch_ = (BranchProfile.create());
                                s0_.seenDynamicScope_ = (BranchProfile.create());
                                s0_.cache_ = (arg3Value.getGuestToHostCache());
                                MemoryFence.storeStore();
                                this.fixed_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doFixed(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode[], ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doFixed(arg0Value_, arg1Value, arg2Value, arg3Value, s0_.cachedMethod_, s0_.toJavaNodes_, s0_.toGuest_, s0_.receiverProfile_, s0_.errorBranch_, s0_.seenDynamicScope_, s0_.cache_);
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-exclude doVarArgs(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode, ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, boolean, GuestToHostCodeCache) */ && (arg0Value_.isVarArgs())) {
                        int count1_ = 0;
                        VarArgsData s1_ = this.varArgs_cache;
                        if ((state_0 & 0b10) != 0 /* is-state_0 doVarArgs(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode, ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, boolean, GuestToHostCodeCache) */) {
                            while (s1_ != null) {
                                if ((arg0Value_ == s1_.cachedMethod_)) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            // assert (arg0Value_ == s1_.cachedMethod_);
                            if (count1_ < (HostExecuteNode.LIMIT)) {
                                s1_ = super.insert(new VarArgsData(varArgs_cache));
                                s1_.cachedMethod_ = (arg0Value_);
                                s1_.toJavaNode_ = s1_.insertAccessor((HostToTypeNodeGen.create()));
                                s1_.toGuest_ = s1_.insertAccessor((ToGuestValueNodeGen.create()));
                                s1_.receiverProfile_ = (ValueProfile.createClassProfile());
                                s1_.errorBranch_ = (BranchProfile.create());
                                s1_.seenDynamicScope_ = (BranchProfile.create());
                                s1_.asVarArgs_ = (HostExecuteNode.asVarArgs(arg2Value, s1_.cachedMethod_, arg3Value));
                                s1_.cache_ = (arg3Value.getGuestToHostCache());
                                MemoryFence.storeStore();
                                this.varArgs_cache = s1_;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doVarArgs(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode, ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, boolean, GuestToHostCodeCache) */;
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doVarArgs(arg0Value_, arg1Value, arg2Value, arg3Value, s1_.cachedMethod_, s1_.toJavaNode_, s1_.toGuest_, s1_.receiverProfile_, s1_.errorBranch_, s1_.seenDynamicScope_, s1_.asVarArgs_, s1_.cache_);
                        }
                    }
                    this.toHost = super.insert(this.toHost == null ? ((HostToTypeNodeGen.create())) : this.toHost);
                    this.toGuest = super.insert(this.toGuest == null ? ((ToGuestValueNodeGen.create())) : this.toGuest);
                    this.varArgsProfile = this.varArgsProfile == null ? ((ConditionProfile.create())) : this.varArgsProfile;
                    this.hostMethodProfile = super.insert(this.hostMethodProfile == null ? ((HostMethodProfileNodeGen.create())) : this.hostMethodProfile);
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.seenScope = this.seenScope == null ? ((BranchProfile.create())) : this.seenScope;
                    this.cache = this.cache == null ? ((arg3Value.getGuestToHostCache())) : this.cache;
                    this.exclude_ = exclude = exclude | 0b11 /* add-exclude doFixed(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode[], ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache), doVarArgs(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode, ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, boolean, GuestToHostCodeCache) */;
                    this.fixed_cache = null;
                    this.varArgs_cache = null;
                    state_0 = state_0 & 0xfffffffc /* remove-state_0 doFixed(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode[], ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache), doVarArgs(SingleMethod, Object, Object[], HostContext, SingleMethod, HostToTypeNode, ToGuestValueNode, ValueProfile, BranchProfile, BranchProfile, boolean, GuestToHostCodeCache) */;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doSingleUncached(SingleMethod, Object, Object[], HostContext, HostToTypeNode, ToGuestValueNode, ConditionProfile, HostMethodProfileNode, BranchProfile, BranchProfile, GuestToHostCodeCache) */;
                    lock.unlock();
                    hasLock = false;
                    return HostExecuteNode.doSingleUncached(arg0Value_, arg1Value, arg2Value, arg3Value, this.toHost, this.toGuest, this.varArgsProfile, this.hostMethodProfile, this.errorBranch, this.seenScope, this.cache);
                }
                if (arg0Value instanceof OverloadedMethod) {
                    OverloadedMethod arg0Value_ = (OverloadedMethod) arg0Value;
                    if (((exclude & 0b100)) == 0 /* is-not-exclude doOverloadedCached(OverloadedMethod, Object, Object[], HostContext, OverloadedMethod, HostToTypeNode, ToGuestValueNode, InteropLibrary, TypeCheckNode[], SingleMethod, boolean, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) */) {
                        int count3_ = 0;
                        OverloadedCachedData s3_ = this.overloadedCached_cache;
                        if ((state_0 & 0b1000) != 0 /* is-state_0 doOverloadedCached(OverloadedMethod, Object, Object[], HostContext, OverloadedMethod, HostToTypeNode, ToGuestValueNode, InteropLibrary, TypeCheckNode[], SingleMethod, boolean, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) */) {
                            while (s3_ != null) {
                                if ((arg0Value_ == s3_.cachedMethod_) && (HostExecuteNode.checkArgTypes(arg2Value, s3_.cachedArgTypes_, s3_.interop_, arg3Value, s3_.asVarArgs_))) {
                                    break;
                                }
                                s3_ = s3_.next_;
                                count3_++;
                            }
                        }
                        if (s3_ == null) {
                            {
                                InteropLibrary interop__ = super.insert((INTEROP_LIBRARY_.createDispatched(HostExecuteNode.LIMIT)));
                                TypeCheckNode[] cachedArgTypes__ = super.insert((HostExecuteNode.createArgTypesArray(arg2Value)));
                                SingleMethod overload__ = (selectOverload(arg0Value_, arg2Value, arg3Value, cachedArgTypes__));
                                boolean asVarArgs__ = (HostExecuteNode.asVarArgs(arg2Value, overload__, arg3Value));
                                // assert (arg0Value_ == s3_.cachedMethod_);
                                if ((HostExecuteNode.checkArgTypes(arg2Value, cachedArgTypes__, interop__, arg3Value, asVarArgs__)) && count3_ < (HostExecuteNode.LIMIT)) {
                                    s3_ = super.insert(new OverloadedCachedData(overloadedCached_cache));
                                    s3_.cachedMethod_ = (arg0Value_);
                                    s3_.toJavaNode_ = s3_.insertAccessor((HostToTypeNodeGen.create()));
                                    s3_.toGuest_ = s3_.insertAccessor((ToGuestValueNodeGen.create()));
                                    s3_.interop_ = s3_.insertAccessor(interop__);
                                    s3_.cachedArgTypes_ = s3_.insertAccessor(cachedArgTypes__);
                                    s3_.overload_ = overload__;
                                    s3_.asVarArgs_ = asVarArgs__;
                                    s3_.receiverProfile_ = (ValueProfile.createClassProfile());
                                    s3_.errorBranch_ = (BranchProfile.create());
                                    s3_.seenVariableScope_ = (BranchProfile.create());
                                    s3_.cache_ = (arg3Value.getGuestToHostCache());
                                    MemoryFence.storeStore();
                                    this.overloadedCached_cache = s3_;
                                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doOverloadedCached(OverloadedMethod, Object, Object[], HostContext, OverloadedMethod, HostToTypeNode, ToGuestValueNode, InteropLibrary, TypeCheckNode[], SingleMethod, boolean, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) */;
                                }
                            }
                        }
                        if (s3_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doOverloadedCached(arg0Value_, arg1Value, arg2Value, arg3Value, s3_.cachedMethod_, s3_.toJavaNode_, s3_.toGuest_, s3_.interop_, s3_.cachedArgTypes_, s3_.overload_, s3_.asVarArgs_, s3_.receiverProfile_, s3_.errorBranch_, s3_.seenVariableScope_, s3_.cache_);
                        }
                    }
                    this.toHost = super.insert(this.toHost == null ? ((HostToTypeNodeGen.create())) : this.toHost);
                    this.toGuest = super.insert(this.toGuest == null ? ((ToGuestValueNodeGen.create())) : this.toGuest);
                    this.varArgsProfile = this.varArgsProfile == null ? ((ConditionProfile.create())) : this.varArgsProfile;
                    this.hostMethodProfile = super.insert(this.hostMethodProfile == null ? ((HostMethodProfileNodeGen.create())) : this.hostMethodProfile);
                    this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                    this.seenScope = this.seenScope == null ? ((BranchProfile.create())) : this.seenScope;
                    this.cache = this.cache == null ? ((arg3Value.getGuestToHostCache())) : this.cache;
                    this.exclude_ = exclude = exclude | 0b100 /* add-exclude doOverloadedCached(OverloadedMethod, Object, Object[], HostContext, OverloadedMethod, HostToTypeNode, ToGuestValueNode, InteropLibrary, TypeCheckNode[], SingleMethod, boolean, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) */;
                    this.overloadedCached_cache = null;
                    state_0 = state_0 & 0xfffffff7 /* remove-state_0 doOverloadedCached(OverloadedMethod, Object, Object[], HostContext, OverloadedMethod, HostToTypeNode, ToGuestValueNode, InteropLibrary, TypeCheckNode[], SingleMethod, boolean, ValueProfile, BranchProfile, BranchProfile, GuestToHostCodeCache) */;
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doOverloadedUncached(OverloadedMethod, Object, Object[], HostContext, HostToTypeNode, ToGuestValueNode, ConditionProfile, HostMethodProfileNode, BranchProfile, BranchProfile, GuestToHostCodeCache) */;
                    lock.unlock();
                    hasLock = false;
                    return doOverloadedUncached(arg0Value_, arg1Value, arg2Value, arg3Value, this.toHost, this.toGuest, this.varArgsProfile, this.hostMethodProfile, this.errorBranch, this.seenScope, this.cache);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value);
            } finally {
                if (oldState_0 != 0 || oldExclude != 0) {
                    checkForPolymorphicSpecialize(oldState_0, oldExclude, oldCacheCount);
                }
            }
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    private void checkForPolymorphicSpecialize(int oldState_0, int oldExclude, int oldCacheCount) {
        int newState_0 = this.state_0_;
        int newExclude = this.exclude_;
        if (((oldState_0 ^ newState_0) != 0) || (oldExclude ^ newExclude) != 0 || oldCacheCount < countCaches()) {
            this.reportPolymorphicSpecialize();
        }
    }

    private int countCaches() {
        int cacheCount = 0;
        FixedData s0_ = this.fixed_cache;
        while (s0_ != null) {
            cacheCount++;
            s0_= s0_.next_;
        }
        VarArgsData s1_ = this.varArgs_cache;
        while (s1_ != null) {
            cacheCount++;
            s1_= s1_.next_;
        }
        OverloadedCachedData s3_ = this.overloadedCached_cache;
        while (s3_ != null) {
            cacheCount++;
            s3_= s3_.next_;
        }
        return cacheCount;
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if (state_0 == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                FixedData s0_ = this.fixed_cache;
                VarArgsData s1_ = this.varArgs_cache;
                OverloadedCachedData s3_ = this.overloadedCached_cache;
                if ((s0_ == null || s0_.next_ == null) && (s1_ == null || s1_.next_ == null) && (s3_ == null || s3_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static HostExecuteNode create() {
        return new HostExecuteNodeGen();
    }

    public static HostExecuteNode getUncached() {
        return HostExecuteNodeGen.UNCACHED;
    }

    @GeneratedBy(HostExecuteNode.class)
    private static final class FixedData extends Node {

        @Child FixedData next_;
        @CompilationFinal SingleMethod cachedMethod_;
        @Children HostToTypeNode[] toJavaNodes_;
        @Child ToGuestValueNode toGuest_;
        @CompilationFinal ValueProfile receiverProfile_;
        @CompilationFinal BranchProfile errorBranch_;
        @CompilationFinal BranchProfile seenDynamicScope_;
        @CompilationFinal GuestToHostCodeCache cache_;

        FixedData(FixedData next_) {
            this.next_ = next_;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T[] insertAccessor(T[] node) {
            return super.insert(node);
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(HostExecuteNode.class)
    private static final class VarArgsData extends Node {

        @Child VarArgsData next_;
        @CompilationFinal SingleMethod cachedMethod_;
        @Child HostToTypeNode toJavaNode_;
        @Child ToGuestValueNode toGuest_;
        @CompilationFinal ValueProfile receiverProfile_;
        @CompilationFinal BranchProfile errorBranch_;
        @CompilationFinal BranchProfile seenDynamicScope_;
        @CompilationFinal boolean asVarArgs_;
        @CompilationFinal GuestToHostCodeCache cache_;

        VarArgsData(VarArgsData next_) {
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
    @GeneratedBy(HostExecuteNode.class)
    private static final class OverloadedCachedData extends Node {

        @Child OverloadedCachedData next_;
        @CompilationFinal OverloadedMethod cachedMethod_;
        @Child HostToTypeNode toJavaNode_;
        @Child ToGuestValueNode toGuest_;
        @Child InteropLibrary interop_;
        @Children TypeCheckNode[] cachedArgTypes_;
        @CompilationFinal SingleMethod overload_;
        @CompilationFinal boolean asVarArgs_;
        @CompilationFinal ValueProfile receiverProfile_;
        @CompilationFinal BranchProfile errorBranch_;
        @CompilationFinal BranchProfile seenVariableScope_;
        @CompilationFinal GuestToHostCodeCache cache_;

        OverloadedCachedData(OverloadedCachedData next_) {
            this.next_ = next_;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T[] insertAccessor(T[] node) {
            return super.insert(node);
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(HostExecuteNode.class)
    private static final class Uncached extends HostExecuteNode {

        @TruffleBoundary
        @Override
        public Object execute(HostMethodDesc arg0Value, Object arg1Value, Object[] arg2Value, HostContext arg3Value) throws UnsupportedTypeException, ArityException {
            if (arg0Value instanceof SingleMethod) {
                SingleMethod arg0Value_ = (SingleMethod) arg0Value;
                return HostExecuteNode.doSingleUncached(arg0Value_, arg1Value, arg2Value, arg3Value, (HostToTypeNodeGen.getUncached()), (ToGuestValueNodeGen.getUncached()), (ConditionProfile.getUncached()), (HostMethodProfileNodeGen.getUncached()), (BranchProfile.getUncached()), (BranchProfile.getUncached()), (arg3Value.getGuestToHostCache()));
            }
            if (arg0Value instanceof OverloadedMethod) {
                OverloadedMethod arg0Value_ = (OverloadedMethod) arg0Value;
                return doOverloadedUncached(arg0Value_, arg1Value, arg2Value, arg3Value, (HostToTypeNodeGen.getUncached()), (ToGuestValueNodeGen.getUncached()), (ConditionProfile.getUncached()), (HostMethodProfileNodeGen.getUncached()), (BranchProfile.getUncached()), (BranchProfile.getUncached()), (arg3Value.getGuestToHostCache()));
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value);
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
    @GeneratedBy(HostMethodProfileNode.class)
    static final class HostMethodProfileNodeGen extends HostMethodProfileNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private int state_0_;
        @CompilationFinal private int exclude_;

        private HostMethodProfileNodeGen() {
        }

        @Override
        public SingleMethod execute(SingleMethod arg0Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 mono(MHBase) */ && arg0Value instanceof MHBase) {
                MHBase arg0Value_ = (MHBase) arg0Value;
                return HostMethodProfileNode.mono(arg0Value_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 mono(ReflectBase) */ && arg0Value instanceof ReflectBase) {
                ReflectBase arg0Value_ = (ReflectBase) arg0Value;
                return HostMethodProfileNode.mono(arg0Value_);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 poly(SingleMethod) */) {
                return HostMethodProfileNode.poly(arg0Value);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private SingleMethod executeAndSpecialize(SingleMethod arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (((exclude & 0b1)) == 0 /* is-not-exclude mono(MHBase) */ && arg0Value instanceof MHBase) {
                    MHBase arg0Value_ = (MHBase) arg0Value;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 mono(MHBase) */;
                    lock.unlock();
                    hasLock = false;
                    return HostMethodProfileNode.mono(arg0Value_);
                }
                if (((exclude & 0b10)) == 0 /* is-not-exclude mono(ReflectBase) */ && arg0Value instanceof ReflectBase) {
                    ReflectBase arg0Value_ = (ReflectBase) arg0Value;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 mono(ReflectBase) */;
                    lock.unlock();
                    hasLock = false;
                    return HostMethodProfileNode.mono(arg0Value_);
                }
                this.exclude_ = exclude = exclude | 0b11 /* add-exclude mono(MHBase), mono(ReflectBase) */;
                state_0 = state_0 & 0xfffffffc /* remove-state_0 mono(MHBase), mono(ReflectBase) */;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 poly(SingleMethod) */;
                lock.unlock();
                hasLock = false;
                return HostMethodProfileNode.poly(arg0Value);
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
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static HostMethodProfileNode create() {
            return new HostMethodProfileNodeGen();
        }

        public static HostMethodProfileNode getUncached() {
            return HostMethodProfileNodeGen.UNCACHED;
        }

        @GeneratedBy(HostMethodProfileNode.class)
        private static final class Uncached extends HostMethodProfileNode {

            @TruffleBoundary
            @Override
            public SingleMethod execute(SingleMethod arg0Value) {
                return HostMethodProfileNode.poly(arg0Value);
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
}
