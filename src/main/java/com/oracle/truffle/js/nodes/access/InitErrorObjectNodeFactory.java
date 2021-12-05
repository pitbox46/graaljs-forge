// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.js.nodes.access.InitErrorObjectNode.DefineStackPropertyNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InitErrorObjectNode.class)
@SuppressWarnings("unused")
public final class InitErrorObjectNodeFactory {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @GeneratedBy(DefineStackPropertyNode.class)
    public static final class DefineStackPropertyNodeGen extends DefineStackPropertyNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private Cached0Data cached0_cache;

        private DefineStackPropertyNodeGen() {
        }

        @ExplodeLoop
        @Override
        void execute(DynamicObject arg0Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(DynamicObject, DynamicObjectLibrary) || doCached(DynamicObject, DynamicObjectLibrary) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, DynamicObjectLibrary) */) {
                    Cached0Data s0_ = this.cached0_cache;
                    while (s0_ != null) {
                        if ((s0_.objectLibrary_.accepts(arg0Value))) {
                            doCached(arg0Value, s0_.objectLibrary_);
                            return;
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doCached(DynamicObject, DynamicObjectLibrary) */) {
                    this.cached1Boundary(state_0, arg0Value);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arg0Value);
            return;
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private void cached1Boundary(int state_0, DynamicObject arg0Value) {
            {
                DynamicObjectLibrary cached1_objectLibrary__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(arg0Value));
                doCached(arg0Value, cached1_objectLibrary__);
                return;
            }
        }

        private void executeAndSpecialize(DynamicObject arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(DynamicObject, DynamicObjectLibrary) */) {
                    int count0_ = 0;
                    Cached0Data s0_ = this.cached0_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, DynamicObjectLibrary) */) {
                        while (s0_ != null) {
                            if ((s0_.objectLibrary_.accepts(arg0Value))) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        // assert (s0_.objectLibrary_.accepts(arg0Value));
                        if (count0_ < (3)) {
                            s0_ = super.insert(new Cached0Data(cached0_cache));
                            s0_.objectLibrary_ = s0_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.create(arg0Value)));
                            MemoryFence.storeStore();
                            this.cached0_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, DynamicObjectLibrary) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        doCached(arg0Value, s0_.objectLibrary_);
                        return;
                    }
                }
                {
                    DynamicObjectLibrary cached1_objectLibrary__ = null;
                    cached1_objectLibrary__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(arg0Value));
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(DynamicObject, DynamicObjectLibrary) */;
                    this.cached0_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(DynamicObject, DynamicObjectLibrary) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(DynamicObject, DynamicObjectLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    doCached(arg0Value, cached1_objectLibrary__);
                    return;
                }
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
                    Cached0Data s0_ = this.cached0_cache;
                    if ((s0_ == null || s0_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "doCached";
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, DynamicObjectLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                Cached0Data s0_ = this.cached0_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.objectLibrary_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doCached(DynamicObject, DynamicObjectLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doCached";
            if ((state_0 & 0b10) != 0 /* is-state_0 doCached(DynamicObject, DynamicObjectLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static DefineStackPropertyNode create() {
            return new DefineStackPropertyNodeGen();
        }

        @GeneratedBy(DefineStackPropertyNode.class)
        private static final class Cached0Data extends Node {

            @Child Cached0Data next_;
            @Child DynamicObjectLibrary objectLibrary_;

            Cached0Data(Cached0Data next_) {
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
