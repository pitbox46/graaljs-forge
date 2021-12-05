// CheckStyle: start generated
package com.oracle.truffle.api.library;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.library.ReflectionLibraryDefault.Send;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ReflectionLibraryDefault.class)
final class ReflectionLibraryDefaultGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(ReflectionLibraryDefault.class, new ReflectionLibraryExports());
    }

    private ReflectionLibraryDefaultGen() {
    }

    @GeneratedBy(ReflectionLibraryDefault.class)
    private static final class ReflectionLibraryExports extends LibraryExport<ReflectionLibrary> {

        private ReflectionLibraryExports() {
            super(ReflectionLibrary.class, Object.class, true, false, 0);
        }

        @Override
        protected ReflectionLibrary createUncached(Object receiver) {
            ReflectionLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected ReflectionLibrary createCached(Object receiver) {
            return new Cached(receiver);
        }

        @GeneratedBy(ReflectionLibraryDefault.class)
        private static final class Cached extends ReflectionLibrary {

            @Child private DynamicDispatchLibrary dynamicDispatch_;
            private final Class<?> dynamicDispatchTarget_;
            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private SendCachedData sendCached_cache;

            protected Cached(Object receiver) {
                this.dynamicDispatch_ = insert(DYNAMIC_DISPATCH_LIBRARY_.create(receiver));
                this.dynamicDispatchTarget_ = DYNAMIC_DISPATCH_LIBRARY_.getUncached(receiver).dispatch(receiver);
            }

            @Override
            public boolean accepts(Object receiver) {
                return dynamicDispatch_.accepts(receiver) && dynamicDispatch_.dispatch(receiver) == dynamicDispatchTarget_;
            }

            @ExplodeLoop
            @Override
            public Object send(Object arg0Value, Message arg1Value, Object... arg2Value) throws Exception {
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doSendCached(Object, Message, Object[], Message, Library) || doSendGeneric(Object, Message, Object[]) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doSendCached(Object, Message, Object[], Message, Library) */) {
                        SendCachedData s0_ = this.sendCached_cache;
                        while (s0_ != null) {
                            if ((arg1Value == s0_.cachedMessage_) && (s0_.cachedLibrary_.accepts(arg0Value))) {
                                return Send.doSendCached(arg0Value, arg1Value, arg2Value, s0_.cachedMessage_, s0_.cachedLibrary_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doSendGeneric(Object, Message, Object[]) */) {
                        return Send.doSendGeneric(arg0Value, arg1Value, arg2Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object executeAndSpecialize(Object arg0Value, Message arg1Value, Object[] arg2Value) throws Exception {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if ((exclude) == 0 /* is-not-exclude doSendCached(Object, Message, Object[], Message, Library) */) {
                        int count0_ = 0;
                        SendCachedData s0_ = this.sendCached_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doSendCached(Object, Message, Object[], Message, Library) */) {
                            while (s0_ != null) {
                                if ((arg1Value == s0_.cachedMessage_) && (s0_.cachedLibrary_.accepts(arg0Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                Library cachedLibrary__ = super.insert((Send.createLibrary(arg1Value, arg0Value)));
                                // assert (arg1Value == s0_.cachedMessage_);
                                if ((cachedLibrary__.accepts(arg0Value)) && count0_ < (ReflectionLibraryDefault.LIMIT)) {
                                    s0_ = super.insert(new SendCachedData(sendCached_cache));
                                    s0_.cachedMessage_ = (arg1Value);
                                    s0_.cachedLibrary_ = s0_.insertAccessor(cachedLibrary__);
                                    MemoryFence.storeStore();
                                    this.sendCached_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doSendCached(Object, Message, Object[], Message, Library) */;
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return Send.doSendCached(arg0Value, arg1Value, arg2Value, s0_.cachedMessage_, s0_.cachedLibrary_);
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doSendCached(Object, Message, Object[], Message, Library) */;
                    this.sendCached_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doSendCached(Object, Message, Object[], Message, Library) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doSendGeneric(Object, Message, Object[]) */;
                    lock.unlock();
                    hasLock = false;
                    return Send.doSendGeneric(arg0Value, arg1Value, arg2Value);
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
                        SendCachedData s0_ = this.sendCached_cache;
                        if ((s0_ == null || s0_.next_ == null)) {
                            return NodeCost.MONOMORPHIC;
                        }
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            @GeneratedBy(ReflectionLibraryDefault.class)
            private static final class SendCachedData extends Node {

                @Child SendCachedData next_;
                @CompilationFinal Message cachedMessage_;
                @Child Library cachedLibrary_;

                SendCachedData(SendCachedData next_) {
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
        @GeneratedBy(ReflectionLibraryDefault.class)
        private static final class Uncached extends ReflectionLibrary {

            @Child private DynamicDispatchLibrary dynamicDispatch_;
            private final Class<?> dynamicDispatchTarget_;

            protected Uncached(Object receiver) {
                this.dynamicDispatch_ = DYNAMIC_DISPATCH_LIBRARY_.getUncached(receiver);
                this.dynamicDispatchTarget_ = dynamicDispatch_.dispatch(receiver);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                return dynamicDispatch_.accepts(receiver) && dynamicDispatch_.dispatch(receiver) == dynamicDispatchTarget_;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public Object send(Object arg0Value, Message arg1Value, Object... arg2Value) throws Exception {
                // declared: true
                assert this.accepts(arg0Value) : "Invalid library usage. Library does not accept given receiver.";
                return Send.doSendGeneric(arg0Value, arg1Value, arg2Value);
            }

        }
    }
}
