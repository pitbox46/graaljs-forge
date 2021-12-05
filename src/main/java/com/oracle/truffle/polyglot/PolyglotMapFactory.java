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
import com.oracle.truffle.polyglot.PolyglotLanguageContext.ToGuestValueNode;
import com.oracle.truffle.polyglot.PolyglotLanguageContextFactory.ToGuestValueNodeGen;
import com.oracle.truffle.polyglot.PolyglotMap.Cache;
import com.oracle.truffle.polyglot.PolyglotMap.Cache.ContainsKeyNode;
import com.oracle.truffle.polyglot.PolyglotMap.Cache.EntrySet;
import com.oracle.truffle.polyglot.PolyglotMap.Cache.GetNode;
import com.oracle.truffle.polyglot.PolyglotMap.Cache.HashEntriesIteratorNode;
import com.oracle.truffle.polyglot.PolyglotMap.Cache.HashSizeNode;
import com.oracle.truffle.polyglot.PolyglotMap.Cache.PolyglotMapNode;
import com.oracle.truffle.polyglot.PolyglotMap.Cache.Put;
import com.oracle.truffle.polyglot.PolyglotMap.Cache.RemoveBoolean;
import com.oracle.truffle.polyglot.PolyglotMap.Cache.RemoveNode;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PolyglotMap.class)
@SuppressWarnings("unused")
final class PolyglotMapFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(Cache.class)
    static final class CacheFactory {

        @GeneratedBy(ContainsKeyNode.class)
        static final class ContainsKeyNodeGen extends ContainsKeyNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private ToGuestValueNode cached1_toGuest_;

            private ContainsKeyNodeGen(Cache cache) {
                super(cache);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.interop_.accepts(arg1Value))) {
                                return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toGuest_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */) {
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
                        InteropLibrary cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_toGuest_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */) {
                            while (s0_ != null) {
                                if ((s0_.interop_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.interop_.accepts(arg1Value));
                            if (count0_ < (PolyglotMapNode.LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.interop_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuest_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toGuest_);
                        }
                    }
                    {
                        InteropLibrary cached1_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toGuest_ = super.insert((ToGuestValueNodeGen.create()));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */;
                                lock.unlock();
                                hasLock = false;
                                return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_toGuest_);
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

            public static ContainsKeyNode create(Cache cache) {
                return new ContainsKeyNodeGen(cache);
            }

            @GeneratedBy(ContainsKeyNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary interop_;
                @Child ToGuestValueNode toGuest_;

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
        @GeneratedBy(EntrySet.class)
        static final class EntrySetNodeGen extends EntrySet {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private PolyglotToHostNode cached1_toHost_;
            @CompilationFinal private BranchProfile cached1_error_;

            private EntrySetNodeGen(Cache cache) {
                super(cache);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.interop_.accepts(arg1Value))) {
                                return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toHost_, s0_.error_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */) {
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
                        InteropLibrary cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_toHost_, this.cached1_error_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.interop_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.interop_.accepts(arg1Value));
                            if (count0_ < (PolyglotMapNode.LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.interop_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = s0_.insertAccessor((PolyglotToHostNodeGen.create()));
                                s0_.error_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toHost_, s0_.error_);
                        }
                    }
                    {
                        InteropLibrary cached1_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toHost_ = super.insert((PolyglotToHostNodeGen.create()));
                                this.cached1_error_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_toHost_, this.cached1_error_);
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

            public static EntrySet create(Cache cache) {
                return new EntrySetNodeGen(cache);
            }

            @GeneratedBy(EntrySet.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary interop_;
                @Child PolyglotToHostNode toHost_;
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
        @GeneratedBy(GetNode.class)
        static final class GetNodeGen extends GetNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private GetNodeGen(Cache cache) {
                super(cache);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, PolyglotToHostNode, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, PolyglotToHostNode, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, PolyglotToHostNode, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.interop_.accepts(arg1Value))) {
                                return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toGuest_, s0_.toHost_, s0_.error_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, PolyglotToHostNode, BranchProfile) */) {
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
                        InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return doCached(arg0Value, arg1Value, arg2Value, interop__, s1_.toGuest_, s1_.toHost_, s1_.error_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, PolyglotToHostNode, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, PolyglotToHostNode, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.interop_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.interop_.accepts(arg1Value));
                            if (count0_ < (PolyglotMapNode.LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.interop_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuest_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.toHost_ = s0_.insertAccessor((PolyglotToHostNodeGen.create()));
                                s0_.error_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, PolyglotToHostNode, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toGuest_, s0_.toHost_, s0_.error_);
                        }
                    }
                    {
                        InteropLibrary interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toGuest_ = s1_.insertAccessor((ToGuestValueNodeGen.create()));
                                s1_.toHost_ = s1_.insertAccessor((PolyglotToHostNodeGen.create()));
                                s1_.error_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, PolyglotToHostNode, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, PolyglotToHostNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, PolyglotToHostNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return doCached(arg0Value, arg1Value, arg2Value, interop__, s1_.toGuest_, s1_.toHost_, s1_.error_);
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

            public static GetNode create(Cache cache) {
                return new GetNodeGen(cache);
            }

            @GeneratedBy(GetNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary interop_;
                @Child ToGuestValueNode toGuest_;
                @Child PolyglotToHostNode toHost_;
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
            @GeneratedBy(GetNode.class)
            private static final class Cached1Data extends Node {

                @Child ToGuestValueNode toGuest_;
                @Child PolyglotToHostNode toHost_;
                @CompilationFinal BranchProfile error_;

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
        @GeneratedBy(Put.class)
        static final class PutNodeGen extends Put {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private ToGuestValueNode cached1_toGuest_;
            @CompilationFinal private BranchProfile cached1_error_;

            private PutNodeGen(Cache cache) {
                super(cache);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.interop_.accepts(arg1Value))) {
                                return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toGuest_, s0_.error_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
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
                        InteropLibrary cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_toGuest_, this.cached1_error_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.interop_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.interop_.accepts(arg1Value));
                            if (count0_ < (PolyglotMapNode.LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.interop_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuest_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.error_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toGuest_, s0_.error_);
                        }
                    }
                    {
                        InteropLibrary cached1_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toGuest_ = super.insert((ToGuestValueNodeGen.create()));
                                this.cached1_error_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_toGuest_, this.cached1_error_);
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

            public static Put create(Cache cache) {
                return new PutNodeGen(cache);
            }

            @GeneratedBy(Put.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary interop_;
                @Child ToGuestValueNode toGuest_;
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
        @GeneratedBy(RemoveNode.class)
        static final class RemoveNodeGen extends RemoveNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private ToGuestValueNode cached1_toGuest_;
            @CompilationFinal private BranchProfile cached1_error_;

            private RemoveNodeGen(Cache cache) {
                super(cache);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.interop_.accepts(arg1Value))) {
                                return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toGuest_, s0_.error_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
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
                        InteropLibrary cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_toGuest_, this.cached1_error_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.interop_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.interop_.accepts(arg1Value));
                            if (count0_ < (PolyglotMapNode.LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.interop_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuest_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.error_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toGuest_, s0_.error_);
                        }
                    }
                    {
                        InteropLibrary cached1_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toGuest_ = super.insert((ToGuestValueNodeGen.create()));
                                this.cached1_error_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_toGuest_, this.cached1_error_);
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

            public static RemoveNode create(Cache cache) {
                return new RemoveNodeGen(cache);
            }

            @GeneratedBy(RemoveNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary interop_;
                @Child ToGuestValueNode toGuest_;
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
        @GeneratedBy(RemoveBoolean.class)
        static final class RemoveBooleanNodeGen extends RemoveBoolean {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private ToGuestValueNode cached1_toGuest_;
            @CompilationFinal private BranchProfile cached1_error_;

            private RemoveBooleanNodeGen(Cache cache) {
                super(cache);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.interop_.accepts(arg1Value))) {
                                return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toGuest_, s0_.error_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
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
                        InteropLibrary cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_toGuest_, this.cached1_error_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.interop_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.interop_.accepts(arg1Value));
                            if (count0_ < (PolyglotMapNode.LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.interop_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuest_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.error_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toGuest_, s0_.error_);
                        }
                    }
                    {
                        InteropLibrary cached1_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toGuest_ = super.insert((ToGuestValueNodeGen.create()));
                                this.cached1_error_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_toGuest_, this.cached1_error_);
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

            public static RemoveBoolean create(Cache cache) {
                return new RemoveBooleanNodeGen(cache);
            }

            @GeneratedBy(RemoveBoolean.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary interop_;
                @Child ToGuestValueNode toGuest_;
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
        @GeneratedBy(HashEntriesIteratorNode.class)
        static final class HashEntriesIteratorNodeGen extends HashEntriesIteratorNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private PolyglotToHostNode cached1_toHost_;
            @CompilationFinal private BranchProfile cached1_error_;

            private HashEntriesIteratorNodeGen(Cache cache) {
                super(cache);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.interop_.accepts(arg1Value))) {
                                return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toHost_, s0_.error_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */) {
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
                        InteropLibrary cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_toHost_, this.cached1_error_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.interop_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.interop_.accepts(arg1Value));
                            if (count0_ < (PolyglotMapNode.LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.interop_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = s0_.insertAccessor((PolyglotToHostNodeGen.create()));
                                s0_.error_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.toHost_, s0_.error_);
                        }
                    }
                    {
                        InteropLibrary cached1_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toHost_ = super.insert((PolyglotToHostNodeGen.create()));
                                this.cached1_error_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, PolyglotToHostNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_toHost_, this.cached1_error_);
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

            public static HashEntriesIteratorNode create(Cache cache) {
                return new HashEntriesIteratorNodeGen(cache);
            }

            @GeneratedBy(HashEntriesIteratorNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary interop_;
                @Child PolyglotToHostNode toHost_;
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
        @GeneratedBy(HashSizeNode.class)
        static final class HashSizeNodeGen extends HashSizeNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_error_;

            private HashSizeNodeGen(Cache cache) {
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
                            if ((s0_.interop_.accepts(arg1Value))) {
                                return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.error_);
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
                        InteropLibrary cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_error_);
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
                                if ((s0_.interop_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.interop_.accepts(arg1Value));
                            if (count0_ < (PolyglotMapNode.LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.interop_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.error_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(arg0Value, arg1Value, arg2Value, s0_.interop_, s0_.error_);
                        }
                    }
                    {
                        InteropLibrary cached1_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_interop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_error_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return doCached(arg0Value, arg1Value, arg2Value, cached1_interop__, this.cached1_error_);
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

            public static HashSizeNode create(Cache cache) {
                return new HashSizeNodeGen(cache);
            }

            @GeneratedBy(HashSizeNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary interop_;
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
    }
}
