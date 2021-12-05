// CheckStyle: start generated
package com.oracle.truffle.host;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import java.lang.reflect.Type;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HostToTypeNode.class)
final class HostToTypeNodeGen extends HostToTypeNode {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private CachedData cached_cache;

    private HostToTypeNodeGen() {
    }

    @ExplodeLoop
    @Override
    public Object execute(HostContext arg0Value, Object arg1Value, Class<?> arg2Value, Type arg3Value, boolean arg4Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doCached(HostContext, Object, Class<>, Type, boolean, InteropLibrary, Class<>, boolean, boolean, HostTargetMappingNode, BranchProfile) || doGeneric(HostContext, Object, Class<>, Type, boolean) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostContext, Object, Class<>, Type, boolean, InteropLibrary, Class<>, boolean, boolean, HostTargetMappingNode, BranchProfile) */) {
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    if ((s0_.interop_.accepts(arg1Value)) && (arg2Value == s0_.cachedTargetType_)) {
                        return doCached(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, s0_.interop_, s0_.cachedTargetType_, s0_.primitiveTarget_, s0_.allowsImplementation_, s0_.targetMapping_, s0_.error_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doGeneric(HostContext, Object, Class<>, Type, boolean) */) {
                return HostToTypeNode.doGeneric(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
    }

    private Object executeAndSpecialize(HostContext arg0Value, Object arg1Value, Class<?> arg2Value, Type arg3Value, boolean arg4Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude doCached(HostContext, Object, Class<>, Type, boolean, InteropLibrary, Class<>, boolean, boolean, HostTargetMappingNode, BranchProfile) */) {
                int count0_ = 0;
                CachedData s0_ = this.cached_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostContext, Object, Class<>, Type, boolean, InteropLibrary, Class<>, boolean, boolean, HostTargetMappingNode, BranchProfile) */) {
                    while (s0_ != null) {
                        if ((s0_.interop_.accepts(arg1Value)) && (arg2Value == s0_.cachedTargetType_)) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    // assert (s0_.interop_.accepts(arg1Value));
                    // assert (arg2Value == s0_.cachedTargetType_);
                    if (count0_ < (HostToTypeNode.LIMIT)) {
                        s0_ = super.insert(new CachedData(cached_cache));
                        s0_.interop_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                        s0_.cachedTargetType_ = (arg2Value);
                        s0_.primitiveTarget_ = (HostToTypeNode.isPrimitiveTarget(s0_.cachedTargetType_));
                        s0_.allowsImplementation_ = (HostToTypeNode.allowsImplementation(arg0Value, arg2Value));
                        s0_.targetMapping_ = s0_.insertAccessor((HostTargetMappingNode.create()));
                        s0_.error_ = (BranchProfile.create());
                        MemoryFence.storeStore();
                        this.cached_cache = s0_;
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(HostContext, Object, Class<>, Type, boolean, InteropLibrary, Class<>, boolean, boolean, HostTargetMappingNode, BranchProfile) */;
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doCached(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, s0_.interop_, s0_.cachedTargetType_, s0_.primitiveTarget_, s0_.allowsImplementation_, s0_.targetMapping_, s0_.error_);
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(HostContext, Object, Class<>, Type, boolean, InteropLibrary, Class<>, boolean, boolean, HostTargetMappingNode, BranchProfile) */;
            this.cached_cache = null;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(HostContext, Object, Class<>, Type, boolean, InteropLibrary, Class<>, boolean, boolean, HostTargetMappingNode, BranchProfile) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doGeneric(HostContext, Object, Class<>, Type, boolean) */;
            lock.unlock();
            hasLock = false;
            return HostToTypeNode.doGeneric(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
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
                CachedData s0_ = this.cached_cache;
                if ((s0_ == null || s0_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static HostToTypeNode create() {
        return new HostToTypeNodeGen();
    }

    public static HostToTypeNode getUncached() {
        return HostToTypeNodeGen.UNCACHED;
    }

    @GeneratedBy(HostToTypeNode.class)
    private static final class CachedData extends Node {

        @Child CachedData next_;
        @Child InteropLibrary interop_;
        @CompilationFinal Class<?> cachedTargetType_;
        @CompilationFinal boolean primitiveTarget_;
        @CompilationFinal boolean allowsImplementation_;
        @Child HostTargetMappingNode targetMapping_;
        @CompilationFinal BranchProfile error_;

        CachedData(CachedData next_) {
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
    @GeneratedBy(HostToTypeNode.class)
    private static final class Uncached extends HostToTypeNode {

        @TruffleBoundary
        @Override
        public Object execute(HostContext arg0Value, Object arg1Value, Class<?> arg2Value, Type arg3Value, boolean arg4Value) {
            return HostToTypeNode.doGeneric(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
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
