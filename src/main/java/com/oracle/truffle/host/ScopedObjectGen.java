// CheckStyle: start generated
package com.oracle.truffle.host;

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
import com.oracle.truffle.host.HostMethodScope.ScopedObject;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ScopedObject.class)
final class ScopedObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<ReflectionLibrary> REFLECTION_LIBRARY_ = LibraryFactory.resolve(ReflectionLibrary.class);

    static  {
        LibraryExport.register(ScopedObject.class, new ReflectionLibraryExports());
    }

    private ScopedObjectGen() {
    }

    @GeneratedBy(ScopedObject.class)
    private static final class ReflectionLibraryExports extends LibraryExport<ReflectionLibrary> {

        private ReflectionLibraryExports() {
            super(ReflectionLibrary.class, ScopedObject.class, false, false, 0);
        }

        @Override
        protected ReflectionLibrary createUncached(Object receiver) {
            assert receiver instanceof ScopedObject;
            ReflectionLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected ReflectionLibrary createCached(Object receiver) {
            assert receiver instanceof ScopedObject;
            return new Cached();
        }

        @GeneratedBy(ScopedObject.class)
        private static final class Cached extends ReflectionLibrary {

            @CompilationFinal private volatile int state_0_;
            @Child private SendData send_cache;

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof ScopedObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof ScopedObject;
            }

            @Override
            public Object send(Object arg0Value_, Message arg1Value, Object... arg2Value) throws Exception {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
                ScopedObject arg0Value = ((ScopedObject) arg0Value_);
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 send(ScopedObject, Message, Object[], ReflectionLibrary, BranchProfile, BranchProfile) */) {
                    SendData s0_ = this.send_cache;
                    if (s0_ != null) {
                        return arg0Value.send(arg1Value, arg2Value, s0_.library_, s0_.seenError_, s0_.seenOther_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object executeAndSpecialize(ScopedObject arg0Value, Message arg1Value, Object[] arg2Value) throws Exception {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    SendData s0_ = super.insert(new SendData());
                    s0_.library_ = s0_.insertAccessor((REFLECTION_LIBRARY_.createDispatched(5)));
                    s0_.seenError_ = (BranchProfile.create());
                    s0_.seenOther_ = (BranchProfile.create());
                    MemoryFence.storeStore();
                    this.send_cache = s0_;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 send(ScopedObject, Message, Object[], ReflectionLibrary, BranchProfile, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.send(arg1Value, arg2Value, s0_.library_, s0_.seenError_, s0_.seenOther_);
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

            @GeneratedBy(ScopedObject.class)
            private static final class SendData extends Node {

                @Child ReflectionLibrary library_;
                @CompilationFinal BranchProfile seenError_;
                @CompilationFinal BranchProfile seenOther_;

                SendData() {
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
        @GeneratedBy(ScopedObject.class)
        private static final class Uncached extends ReflectionLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof ScopedObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof ScopedObject;
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
            public Object send(Object arg0Value_, Message arg1Value, Object... arg2Value) throws Exception {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                ScopedObject arg0Value = ((ScopedObject) arg0Value_);
                return arg0Value.send(arg1Value, arg2Value, (REFLECTION_LIBRARY_.getUncached()), (BranchProfile.getUncached()), (BranchProfile.getUncached()));
            }

        }
    }
}
