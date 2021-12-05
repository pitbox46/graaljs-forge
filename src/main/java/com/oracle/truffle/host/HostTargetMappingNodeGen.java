// CheckStyle: start generated
package com.oracle.truffle.host;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.ConditionProfile;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HostTargetMappingNode.class)
final class HostTargetMappingNodeGen extends HostTargetMappingNode {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private CachedData cached_cache;

    private HostTargetMappingNodeGen() {
    }

    @Override
    Object execute(Object arg0Value, Class<?> arg1Value, HostContext arg2Value, InteropLibrary arg3Value, boolean arg4Value, int arg5Value, int arg6Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doCached(Object, Class<>, HostContext, InteropLibrary, boolean, int, int, HostTargetMapping[], SingleMappingNode[]) || doUncached(Object, Class<>, HostContext, InteropLibrary, boolean, int, int) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(Object, Class<>, HostContext, InteropLibrary, boolean, int, int, HostTargetMapping[], SingleMappingNode[]) */) {
                CachedData s0_ = this.cached_cache;
                if (s0_ != null) {
                    if ((arg1Value != null)) {
                        return doCached(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, arg6Value, s0_.mappings_, s0_.mappingNodes_);
                    }
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(Object, Class<>, HostContext, InteropLibrary, boolean, int, int) */) {
                return doUncached(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, arg6Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, arg6Value);
    }

    private Object executeAndSpecialize(Object arg0Value, Class<?> arg1Value, HostContext arg2Value, InteropLibrary arg3Value, boolean arg4Value, int arg5Value, int arg6Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude doCached(Object, Class<>, HostContext, InteropLibrary, boolean, int, int, HostTargetMapping[], SingleMappingNode[]) */) {
                if ((arg1Value != null)) {
                    CachedData s0_ = super.insert(new CachedData());
                    s0_.mappings_ = (HostTargetMappingNode.getMappings(arg2Value, arg1Value));
                    s0_.mappingNodes_ = s0_.insertAccessor((HostTargetMappingNode.createMappingNodes(s0_.mappings_)));
                    MemoryFence.storeStore();
                    this.cached_cache = s0_;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(Object, Class<>, HostContext, InteropLibrary, boolean, int, int, HostTargetMapping[], SingleMappingNode[]) */;
                    lock.unlock();
                    hasLock = false;
                    return doCached(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, arg6Value, s0_.mappings_, s0_.mappingNodes_);
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(Object, Class<>, HostContext, InteropLibrary, boolean, int, int, HostTargetMapping[], SingleMappingNode[]) */;
            this.cached_cache = null;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(Object, Class<>, HostContext, InteropLibrary, boolean, int, int, HostTargetMapping[], SingleMappingNode[]) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(Object, Class<>, HostContext, InteropLibrary, boolean, int, int) */;
            lock.unlock();
            hasLock = false;
            return doUncached(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, arg6Value);
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

    public static HostTargetMappingNode create() {
        return new HostTargetMappingNodeGen();
    }

    public static HostTargetMappingNode getUncached() {
        return HostTargetMappingNodeGen.UNCACHED;
    }

    @GeneratedBy(HostTargetMappingNode.class)
    private static final class CachedData extends Node {

        @CompilationFinal(dimensions = 1) HostTargetMapping[] mappings_;
        @Children SingleMappingNode[] mappingNodes_;

        CachedData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T[] insertAccessor(T[] node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(HostTargetMappingNode.class)
    private static final class Uncached extends HostTargetMappingNode {

        @TruffleBoundary
        @Override
        Object execute(Object arg0Value, Class<?> arg1Value, HostContext arg2Value, InteropLibrary arg3Value, boolean arg4Value, int arg5Value, int arg6Value) {
            return doUncached(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, arg6Value);
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
    @GeneratedBy(SingleMappingNode.class)
    static final class SingleMappingNodeGen extends SingleMappingNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @Child private DefaultData default_cache;

        private SingleMappingNodeGen() {
        }

        @Override
        Object execute(Object arg0Value, HostTargetMapping arg1Value, HostContext arg2Value, InteropLibrary arg3Value, boolean arg4Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doDefault(Object, HostTargetMapping, HostContext, InteropLibrary, boolean, ConditionProfile, boolean, HostToTypeNode) */) {
                DefaultData s0_ = this.default_cache;
                if (s0_ != null) {
                    return doDefault(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, s0_.acceptsProfile_, s0_.allowsImplementation_, s0_.toHostRecursive_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
        }

        private Object executeAndSpecialize(Object arg0Value, HostTargetMapping arg1Value, HostContext arg2Value, InteropLibrary arg3Value, boolean arg4Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                DefaultData s0_ = super.insert(new DefaultData());
                s0_.acceptsProfile_ = (ConditionProfile.create());
                s0_.allowsImplementation_ = (SingleMappingNode.allowsImplementation(arg2Value, arg1Value.sourceType));
                s0_.toHostRecursive_ = s0_.insertAccessor((HostToTypeNodeGen.create()));
                MemoryFence.storeStore();
                this.default_cache = s0_;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doDefault(Object, HostTargetMapping, HostContext, InteropLibrary, boolean, ConditionProfile, boolean, HostToTypeNode) */;
                lock.unlock();
                hasLock = false;
                return doDefault(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, s0_.acceptsProfile_, s0_.allowsImplementation_, s0_.toHostRecursive_);
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
                return NodeCost.MONOMORPHIC;
            }
        }

        public static SingleMappingNode create() {
            return new SingleMappingNodeGen();
        }

        public static SingleMappingNode getUncached() {
            return SingleMappingNodeGen.UNCACHED;
        }

        @GeneratedBy(SingleMappingNode.class)
        private static final class DefaultData extends Node {

            @CompilationFinal ConditionProfile acceptsProfile_;
            @CompilationFinal boolean allowsImplementation_;
            @Child HostToTypeNode toHostRecursive_;

            DefaultData() {
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
        @GeneratedBy(SingleMappingNode.class)
        private static final class Uncached extends SingleMappingNode {

            @TruffleBoundary
            @Override
            Object execute(Object arg0Value, HostTargetMapping arg1Value, HostContext arg2Value, InteropLibrary arg3Value, boolean arg4Value) {
                return doDefault(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, (ConditionProfile.getUncached()), (SingleMappingNode.allowsImplementation(arg2Value, arg1Value.sourceType)), (HostToTypeNodeGen.getUncached()));
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
