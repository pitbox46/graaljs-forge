// CheckStyle: start generated
package com.oracle.truffle.polyglot;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.polyglot.PolyglotIterator.Cache;
import com.oracle.truffle.polyglot.PolyglotIterator.Cache.HasNextNode;
import com.oracle.truffle.polyglot.PolyglotIterator.Cache.NextNode;
import com.oracle.truffle.polyglot.PolyglotIterator.Cache.PolyglotIteratorNode;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PolyglotIterator.class)
@SuppressWarnings("unused")
final class PolyglotIteratorFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(Cache.class)
    static final class CacheFactory {

        @GeneratedBy(HasNextNode.class)
        static final class HasNextNodeGen extends HasNextNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_error_;

            private HasNextNodeGen(Cache cache) {
                super(cache);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.iterators_.accepts(arg1Value))) {
                                return doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_, s0_.error_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        return this.cached1Boundary(state_0, arg0Value, arg1Value, arg2Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            @SuppressWarnings("static-method")
            @TruffleBoundary
            private Object cached1Boundary(int state_0, PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                Node prev_ = encapsulating_.set(this);
                try {
                    {
                        InteropLibrary cached1_iterators__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return doCached(arg0Value, arg1Value, arg2Value, cached1_iterators__, this.cached1_error_);
                    }
                } finally {
                    encapsulating_.set(prev_);
                }
            }

            private Object executeAndSpecialize(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.iterators_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.iterators_.accepts(arg1Value));
                            if (count0_ < (PolyglotIteratorNode.LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.iterators_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.error_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_, s0_.error_);
                        }
                    }
                    {
                        InteropLibrary cached1_iterators__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_iterators__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_error_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return doCached(arg0Value, arg1Value, arg2Value, cached1_iterators__, this.cached1_error_);
                            } finally {
                                encapsulating_.set(prev_);
                            }
                        }
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

            public static HasNextNode create(Cache cache) {
                return new HasNextNodeGen(cache);
            }

            @GeneratedBy(HasNextNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary iterators_;
                @CompilationFinal BranchProfile error_;

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
        @GeneratedBy(NextNode.class)
        static final class NextNodeGen extends NextNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private NextNodeGen(Cache cache) {
                super(cache);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.iterators_.accepts(arg1Value))) {
                                return doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_, s0_.toHost_, s0_.error_, s0_.stop_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile, BranchProfile) */) {
                        Cached1Data s1_ = this.cached1_cache;
                        if (s1_ != null) {
                            return this.cached1Boundary(state_0, s1_, arg0Value, arg1Value, arg2Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            @SuppressWarnings("static-method")
            @TruffleBoundary
            private Object cached1Boundary(int state_0, Cached1Data s1_, PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                Node prev_ = encapsulating_.set(this);
                try {
                    {
                        InteropLibrary iterators__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return doCached(arg0Value, arg1Value, arg2Value, iterators__, s1_.toHost_, s1_.error_, s1_.stop_);
                    }
                } finally {
                    encapsulating_.set(prev_);
                }
            }

            private Object executeAndSpecialize(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.iterators_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.iterators_.accepts(arg1Value));
                            if (count0_ < (PolyglotIteratorNode.LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.iterators_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = s0_.insertAccessor((PolyglotToHostNodeGen.create()));
                                s0_.error_ = (BranchProfile.create());
                                s0_.stop_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_, s0_.toHost_, s0_.error_, s0_.stop_);
                        }
                    }
                    {
                        InteropLibrary iterators__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                iterators__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toHost_ = s1_.insertAccessor((PolyglotToHostNodeGen.create()));
                                s1_.error_ = (BranchProfile.create());
                                s1_.stop_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return doCached(arg0Value, arg1Value, arg2Value, iterators__, s1_.toHost_, s1_.error_, s1_.stop_);
                            } finally {
                                encapsulating_.set(prev_);
                            }
                        }
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

            public static NextNode create(Cache cache) {
                return new NextNodeGen(cache);
            }

            @GeneratedBy(NextNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary iterators_;
                @Child PolyglotToHostNode toHost_;
                @CompilationFinal BranchProfile error_;
                @CompilationFinal BranchProfile stop_;

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
            @GeneratedBy(NextNode.class)
            private static final class Cached1Data extends Node {

                @Child PolyglotToHostNode toHost_;
                @CompilationFinal BranchProfile error_;
                @CompilationFinal BranchProfile stop_;

                Cached1Data() {
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
}
