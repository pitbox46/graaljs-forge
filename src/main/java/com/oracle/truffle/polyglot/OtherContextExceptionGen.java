// CheckStyle: start generated
package com.oracle.truffle.polyglot;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.library.Message;
import com.oracle.truffle.api.library.ReflectionLibrary;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.polyglot.OtherContextGuestObject.OtherContextException;
import com.oracle.truffle.polyglot.OtherContextGuestObject.OtherContextException.Send;
import java.util.concurrent.locks.Lock;

@GeneratedBy(OtherContextException.class)
final class OtherContextExceptionGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<ReflectionLibrary> REFLECTION_LIBRARY_ = LibraryFactory.resolve(ReflectionLibrary.class);

    static  {
        LibraryExport.register(OtherContextException.class, new ReflectionLibraryExports());
    }

    private OtherContextExceptionGen() {
    }

    @GeneratedBy(OtherContextException.class)
    static class ReflectionLibraryExports extends LibraryExport<ReflectionLibrary> {

        private ReflectionLibraryExports() {
            super(ReflectionLibrary.class, OtherContextException.class, false, false, 0);
        }

        @Override
        protected ReflectionLibrary createUncached(Object receiver) {
            assert receiver instanceof OtherContextException;
            ReflectionLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected ReflectionLibrary createCached(Object receiver) {
            assert receiver instanceof OtherContextException;
            return new Cached(receiver);
        }

        @GeneratedBy(OtherContextException.class)
        static class Cached extends ReflectionLibrary {

            private final Class<? extends OtherContextException> receiverClass_;
            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private CachedData cached_cache;

            protected Cached(Object receiver) {
                OtherContextException castReceiver = ((OtherContextException) receiver) ;
                this.receiverClass_ = castReceiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            public Object send(Object arg0Value_, Message arg1Value, Object... arg2Value) throws Exception {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                OtherContextException arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(OtherContextException, Message, Object[], ReflectionLibrary, PolyglotEngineImpl, ReflectionLibrary, BranchProfile, BranchProfile) || doSlowPath(OtherContextException, Message, Object[]) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(OtherContextException, Message, Object[], ReflectionLibrary, PolyglotEngineImpl, ReflectionLibrary, BranchProfile, BranchProfile) */) {
                        CachedData s0_ = this.cached_cache;
                        if (s0_ != null) {
                            {
                                ReflectionLibrary receiverLibrary__ = (this);
                                if ((OtherContextGuestObject.canCache(s0_.cachedEngine_, arg0Value.receiverContext, arg0Value.delegateContext))) {
                                    return Send.doCached(arg0Value, arg1Value, arg2Value, receiverLibrary__, s0_.cachedEngine_, s0_.delegateLibrary_, s0_.seenOther_, s0_.seenError_);
                                }
                            }
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doSlowPath(OtherContextException, Message, Object[]) */) {
                        return Send.doSlowPath(arg0Value, arg1Value, arg2Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object executeAndSpecialize(OtherContextException arg0Value, Message arg1Value, Object[] arg2Value) throws Exception {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    {
                        ReflectionLibrary receiverLibrary__ = null;
                        if ((exclude) == 0 /* is-not-exclude doCached(OtherContextException, Message, Object[], ReflectionLibrary, PolyglotEngineImpl, ReflectionLibrary, BranchProfile, BranchProfile) */) {
                            CachedData s0_ = this.cached_cache;
                            boolean Cached_duplicateFound_ = false;
                            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(OtherContextException, Message, Object[], ReflectionLibrary, PolyglotEngineImpl, ReflectionLibrary, BranchProfile, BranchProfile) */) {
                                {
                                    receiverLibrary__ = (this);
                                    if ((OtherContextGuestObject.canCache(s0_.cachedEngine_, arg0Value.receiverContext, arg0Value.delegateContext))) {
                                        Cached_duplicateFound_ = true;
                                    }
                                }
                            }
                            if (!Cached_duplicateFound_) {
                                {
                                    receiverLibrary__ = (this);
                                    PolyglotEngineImpl cachedEngine__ = (OtherContextGuestObject.getCachedEngine(receiverLibrary__));
                                    if ((OtherContextGuestObject.canCache(cachedEngine__, arg0Value.receiverContext, arg0Value.delegateContext)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 doCached(OtherContextException, Message, Object[], ReflectionLibrary, PolyglotEngineImpl, ReflectionLibrary, BranchProfile, BranchProfile) */) {
                                        s0_ = super.insert(new CachedData());
                                        s0_.cachedEngine_ = cachedEngine__;
                                        s0_.delegateLibrary_ = s0_.insertAccessor((REFLECTION_LIBRARY_.createDispatched(OtherContextGuestObject.CACHE_LIMIT)));
                                        s0_.seenOther_ = (BranchProfile.create());
                                        s0_.seenError_ = (BranchProfile.create());
                                        MemoryFence.storeStore();
                                        this.cached_cache = s0_;
                                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(OtherContextException, Message, Object[], ReflectionLibrary, PolyglotEngineImpl, ReflectionLibrary, BranchProfile, BranchProfile) */;
                                        Cached_duplicateFound_ = true;
                                    }
                                }
                            }
                            if (Cached_duplicateFound_) {
                                lock.unlock();
                                hasLock = false;
                                return Send.doCached(arg0Value, arg1Value, arg2Value, receiverLibrary__, s0_.cachedEngine_, s0_.delegateLibrary_, s0_.seenOther_, s0_.seenError_);
                            }
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(OtherContextException, Message, Object[], ReflectionLibrary, PolyglotEngineImpl, ReflectionLibrary, BranchProfile, BranchProfile) */;
                    this.cached_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(OtherContextException, Message, Object[], ReflectionLibrary, PolyglotEngineImpl, ReflectionLibrary, BranchProfile, BranchProfile) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doSlowPath(OtherContextException, Message, Object[]) */;
                    lock.unlock();
                    hasLock = false;
                    return Send.doSlowPath(arg0Value, arg1Value, arg2Value);
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

            @GeneratedBy(OtherContextException.class)
            private static final class CachedData extends Node {

                @CompilationFinal PolyglotEngineImpl cachedEngine_;
                @Child ReflectionLibrary delegateLibrary_;
                @CompilationFinal BranchProfile seenOther_;
                @CompilationFinal BranchProfile seenError_;

                CachedData() {
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
        @GeneratedBy(OtherContextException.class)
        static class Uncached extends ReflectionLibrary {

            private final Class<? extends OtherContextException> receiverClass_;

            protected Uncached(Object receiver) {
                this.receiverClass_ = ((OtherContextException) receiver).getClass();
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            public final boolean isAdoptable() {
                return false;
            }

            @Override
            public final NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public Object send(Object arg0Value_, Message arg1Value, Object... arg2Value) throws Exception {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                OtherContextException arg0Value = ((OtherContextException) arg0Value_);
                return Send.doSlowPath(arg0Value, arg1Value, arg2Value);
            }

        }
    }
}
