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
import com.oracle.truffle.polyglot.PolyglotLanguageContext.ToGuestValuesNode;
import com.oracle.truffle.polyglot.PolyglotLanguageContext.ToHostValueNode;
import com.oracle.truffle.polyglot.PolyglotLanguageContextFactory.ToGuestValueNodeGen;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.AsDateNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.AsDurationNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.AsInstantNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.AsNativePointerNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.AsTimeNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.AsTimeZoneNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.CanExecuteNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.CanInstantiateNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.CanInvokeNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetArrayElementNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetArraySizeNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetBufferSizeNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetHashEntriesIteratorNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetHashKeysIteratorNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetHashSizeNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetHashValueNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetHashValueOrDefaultNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetHashValuesIteratorNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetIteratorNextElementNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetIteratorNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetMemberKeysNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetMemberNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetMetaQualifiedNameNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.GetMetaSimpleNameNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.HasArrayElementsNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.HasBufferElementsNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.HasHashEntriesNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.HasHashEntryNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.HasIteratorNextElementNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.HasIteratorNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.HasMemberNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.HasMembersNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.IsBufferWritableNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.IsDateNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.IsDurationNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.IsExceptionNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.IsIteratorNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.IsMetaInstanceNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.IsMetaObjectNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.IsNativePointerNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.IsNullNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.IsTimeNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.IsTimeZoneNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.NewInstanceNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.PutHashEntryNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.PutMemberNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.ReadBufferByteNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.ReadBufferDoubleNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.ReadBufferFloatNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.ReadBufferIntNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.ReadBufferLongNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.ReadBufferShortNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.RemoveArrayElementNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.RemoveHashEntryNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.RemoveMemberNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.SetArrayElementNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.ThrowExceptionNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.WriteBufferByteNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.WriteBufferDoubleNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.WriteBufferFloatNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.WriteBufferIntNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.WriteBufferLongNode;
import com.oracle.truffle.polyglot.PolyglotValueDispatch.InteropValue.WriteBufferShortNode;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PolyglotValueDispatch.class)
@SuppressWarnings("unused")
final class PolyglotValueDispatchFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(InteropValue.class)
    static final class InteropValueFactory {

        @GeneratedBy(IsDateNode.class)
        static final class IsDateNodeGen extends IsDateNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private IsDateNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return IsDateNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return IsDateNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsDateNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return IsDateNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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

            public static IsDateNode create(InteropValue interop) {
                return new IsDateNodeGen(interop);
            }

            @GeneratedBy(IsDateNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;

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
        @GeneratedBy(AsDateNode.class)
        static final class AsDateNodeGen extends AsDateNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private AsDateNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return AsDateNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_);
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return AsDateNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_);
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
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return AsDateNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return AsDateNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_);
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

            public static AsDateNode create(InteropValue interop) {
                return new AsDateNodeGen(interop);
            }

            @GeneratedBy(AsDateNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(IsTimeNode.class)
        static final class IsTimeNodeGen extends IsTimeNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private IsTimeNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return IsTimeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return IsTimeNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsTimeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return IsTimeNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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

            public static IsTimeNode create(InteropValue interop) {
                return new IsTimeNodeGen(interop);
            }

            @GeneratedBy(IsTimeNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;

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
        @GeneratedBy(AsTimeNode.class)
        static final class AsTimeNodeGen extends AsTimeNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private AsTimeNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return AsTimeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_);
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return AsTimeNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_);
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
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return AsTimeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return AsTimeNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_);
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

            public static AsTimeNode create(InteropValue interop) {
                return new AsTimeNodeGen(interop);
            }

            @GeneratedBy(AsTimeNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(IsTimeZoneNode.class)
        static final class IsTimeZoneNodeGen extends IsTimeZoneNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private IsTimeZoneNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return IsTimeZoneNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return IsTimeZoneNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsTimeZoneNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return IsTimeZoneNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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

            public static IsTimeZoneNode create(InteropValue interop) {
                return new IsTimeZoneNodeGen(interop);
            }

            @GeneratedBy(IsTimeZoneNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;

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
        @GeneratedBy(AsTimeZoneNode.class)
        static final class AsTimeZoneNodeGen extends AsTimeZoneNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private AsTimeZoneNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return AsTimeZoneNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_);
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return AsTimeZoneNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_);
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
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return AsTimeZoneNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return AsTimeZoneNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_);
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

            public static AsTimeZoneNode create(InteropValue interop) {
                return new AsTimeZoneNodeGen(interop);
            }

            @GeneratedBy(AsTimeZoneNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(IsDurationNode.class)
        static final class IsDurationNodeGen extends IsDurationNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private IsDurationNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return IsDurationNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return IsDurationNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsDurationNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return IsDurationNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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

            public static IsDurationNode create(InteropValue interop) {
                return new IsDurationNodeGen(interop);
            }

            @GeneratedBy(IsDurationNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;

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
        @GeneratedBy(AsDurationNode.class)
        static final class AsDurationNodeGen extends AsDurationNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private AsDurationNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return AsDurationNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_);
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return AsDurationNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_);
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
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return AsDurationNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return AsDurationNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_);
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

            public static AsDurationNode create(InteropValue interop) {
                return new AsDurationNodeGen(interop);
            }

            @GeneratedBy(AsDurationNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(AsInstantNode.class)
        static final class AsInstantNodeGen extends AsInstantNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private AsInstantNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return AsInstantNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_);
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return AsInstantNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_);
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
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return AsInstantNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return AsInstantNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_);
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

            public static AsInstantNode create(InteropValue interop) {
                return new AsInstantNodeGen(interop);
            }

            @GeneratedBy(AsInstantNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(IsNativePointerNode.class)
        static final class IsNativePointerNodeGen extends IsNativePointerNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private IsNativePointerNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.natives_.accepts(arg1Value))) {
                                return IsNativePointerNode.doCached(arg0Value, arg1Value, arg2Value, s0_.natives_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_natives__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return IsNativePointerNode.doCached(arg0Value, arg1Value, arg2Value, cached1_natives__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.natives_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.natives_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.natives_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsNativePointerNode.doCached(arg0Value, arg1Value, arg2Value, s0_.natives_);
                        }
                    }
                    {
                        InteropLibrary cached1_natives__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_natives__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return IsNativePointerNode.doCached(arg0Value, arg1Value, arg2Value, cached1_natives__);
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

            public static IsNativePointerNode create(InteropValue interop) {
                return new IsNativePointerNodeGen(interop);
            }

            @GeneratedBy(IsNativePointerNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary natives_;

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
        @GeneratedBy(AsNativePointerNode.class)
        static final class AsNativePointerNodeGen extends AsNativePointerNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private AsNativePointerNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.natives_.accepts(arg1Value))) {
                                return AsNativePointerNode.doCached(arg0Value, arg1Value, arg2Value, s0_.natives_, s0_.unsupported_);
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
                        InteropLibrary cached1_natives__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return AsNativePointerNode.doCached(arg0Value, arg1Value, arg2Value, cached1_natives__, this.cached1_unsupported_);
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
                                if ((s0_.natives_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.natives_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.natives_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return AsNativePointerNode.doCached(arg0Value, arg1Value, arg2Value, s0_.natives_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_natives__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_natives__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return AsNativePointerNode.doCached(arg0Value, arg1Value, arg2Value, cached1_natives__, this.cached1_unsupported_);
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

            public static AsNativePointerNode create(InteropValue interop) {
                return new AsNativePointerNodeGen(interop);
            }

            @GeneratedBy(AsNativePointerNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary natives_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(HasArrayElementsNode.class)
        static final class HasArrayElementsNodeGen extends HasArrayElementsNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private HasArrayElementsNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.arrays_.accepts(arg1Value))) {
                                return HasArrayElementsNode.doCached(arg0Value, arg1Value, arg2Value, s0_.arrays_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_arrays__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return HasArrayElementsNode.doCached(arg0Value, arg1Value, arg2Value, cached1_arrays__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.arrays_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.arrays_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.arrays_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return HasArrayElementsNode.doCached(arg0Value, arg1Value, arg2Value, s0_.arrays_);
                        }
                    }
                    {
                        InteropLibrary cached1_arrays__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_arrays__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return HasArrayElementsNode.doCached(arg0Value, arg1Value, arg2Value, cached1_arrays__);
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

            public static HasArrayElementsNode create(InteropValue interop) {
                return new HasArrayElementsNodeGen(interop);
            }

            @GeneratedBy(HasArrayElementsNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary arrays_;

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
        @GeneratedBy(GetMemberKeysNode.class)
        static final class GetMemberKeysNodeGen extends GetMemberKeysNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private ToHostValueNode cached1_toHost_;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private GetMemberKeysNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return GetMemberKeysNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.toHost_, s0_.unsupported_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetMemberKeysNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_toHost_, this.cached1_unsupported_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetMemberKeysNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.toHost_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toHost_ = (createToHost());
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetMemberKeysNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_toHost_, this.cached1_unsupported_);
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

            public static GetMemberKeysNode create(InteropValue interop) {
                return new GetMemberKeysNodeGen(interop);
            }

            @GeneratedBy(GetMemberKeysNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(GetArrayElementNode.class)
        static final class GetArrayElementNodeGen extends GetArrayElementNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private GetArrayElementNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.arrays_.accepts(arg1Value))) {
                                return GetArrayElementNode.doCached(arg0Value, arg1Value, arg2Value, s0_.arrays_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary arrays__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetArrayElementNode.doCached(arg0Value, arg1Value, arg2Value, arrays__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.arrays_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.arrays_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.arrays_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetArrayElementNode.doCached(arg0Value, arg1Value, arg2Value, s0_.arrays_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                        }
                    }
                    {
                        InteropLibrary arrays__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                arrays__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toHost_ = (createToHost());
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetArrayElementNode.doCached(arg0Value, arg1Value, arg2Value, arrays__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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

            public static GetArrayElementNode create(InteropValue interop) {
                return new GetArrayElementNodeGen(interop);
            }

            @GeneratedBy(GetArrayElementNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary arrays_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

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
            @GeneratedBy(GetArrayElementNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(SetArrayElementNode.class)
        static final class SetArrayElementNodeGen extends SetArrayElementNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private SetArrayElementNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.arrays_.accepts(arg1Value))) {
                                return SetArrayElementNode.doCached(arg0Value, arg1Value, arg2Value, s0_.arrays_, s0_.toGuestValue_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary arrays__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return SetArrayElementNode.doCached(arg0Value, arg1Value, arg2Value, arrays__, s1_.toGuestValue_, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.arrays_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.arrays_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.arrays_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuestValue_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.invalidIndex_ = (BranchProfile.create());
                                s0_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return SetArrayElementNode.doCached(arg0Value, arg1Value, arg2Value, s0_.arrays_, s0_.toGuestValue_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                        }
                    }
                    {
                        InteropLibrary arrays__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                arrays__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toGuestValue_ = s1_.insertAccessor((ToGuestValueNodeGen.create()));
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.invalidIndex_ = (BranchProfile.create());
                                s1_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return SetArrayElementNode.doCached(arg0Value, arg1Value, arg2Value, arrays__, s1_.toGuestValue_, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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

            public static SetArrayElementNode create(InteropValue interop) {
                return new SetArrayElementNodeGen(interop);
            }

            @GeneratedBy(SetArrayElementNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary arrays_;
                @Child ToGuestValueNode toGuestValue_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

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
            @GeneratedBy(SetArrayElementNode.class)
            private static final class Cached1Data extends Node {

                @Child ToGuestValueNode toGuestValue_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

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
        @GeneratedBy(RemoveArrayElementNode.class)
        static final class RemoveArrayElementNodeGen extends RemoveArrayElementNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;
            @CompilationFinal private BranchProfile cached1_invalidIndex_;

            private RemoveArrayElementNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.arrays_.accepts(arg1Value))) {
                                return RemoveArrayElementNode.doCached(arg0Value, arg1Value, arg2Value, s0_.arrays_, s0_.unsupported_, s0_.invalidIndex_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary cached1_arrays__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return RemoveArrayElementNode.doCached(arg0Value, arg1Value, arg2Value, cached1_arrays__, this.cached1_unsupported_, this.cached1_invalidIndex_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.arrays_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.arrays_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.arrays_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.invalidIndex_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return RemoveArrayElementNode.doCached(arg0Value, arg1Value, arg2Value, s0_.arrays_, s0_.unsupported_, s0_.invalidIndex_);
                        }
                    }
                    {
                        InteropLibrary cached1_arrays__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_arrays__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.cached1_invalidIndex_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return RemoveArrayElementNode.doCached(arg0Value, arg1Value, arg2Value, cached1_arrays__, this.cached1_unsupported_, this.cached1_invalidIndex_);
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

            public static RemoveArrayElementNode create(InteropValue interop) {
                return new RemoveArrayElementNodeGen(interop);
            }

            @GeneratedBy(RemoveArrayElementNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary arrays_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;

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
        @GeneratedBy(GetArraySizeNode.class)
        static final class GetArraySizeNodeGen extends GetArraySizeNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private GetArraySizeNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.arrays_.accepts(arg1Value))) {
                                return GetArraySizeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.arrays_, s0_.unsupported_);
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
                        InteropLibrary cached1_arrays__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetArraySizeNode.doCached(arg0Value, arg1Value, arg2Value, cached1_arrays__, this.cached1_unsupported_);
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
                                if ((s0_.arrays_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.arrays_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.arrays_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetArraySizeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.arrays_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_arrays__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_arrays__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetArraySizeNode.doCached(arg0Value, arg1Value, arg2Value, cached1_arrays__, this.cached1_unsupported_);
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

            public static GetArraySizeNode create(InteropValue interop) {
                return new GetArraySizeNodeGen(interop);
            }

            @GeneratedBy(GetArraySizeNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary arrays_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(HasBufferElementsNode.class)
        static final class HasBufferElementsNodeGen extends HasBufferElementsNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private HasBufferElementsNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return HasBufferElementsNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return HasBufferElementsNode.doCached(arg0Value, arg1Value, arg2Value, cached1_buffers__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return HasBufferElementsNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_);
                        }
                    }
                    {
                        InteropLibrary cached1_buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return HasBufferElementsNode.doCached(arg0Value, arg1Value, arg2Value, cached1_buffers__);
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

            public static HasBufferElementsNode create(InteropValue interop) {
                return new HasBufferElementsNodeGen(interop);
            }

            @GeneratedBy(HasBufferElementsNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;

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
        @GeneratedBy(IsBufferWritableNode.class)
        static final class IsBufferWritableNodeGen extends IsBufferWritableNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private IsBufferWritableNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return IsBufferWritableNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_);
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
                        InteropLibrary cached1_buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return IsBufferWritableNode.doCached(arg0Value, arg1Value, arg2Value, cached1_buffers__, this.cached1_unsupported_);
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
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsBufferWritableNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return IsBufferWritableNode.doCached(arg0Value, arg1Value, arg2Value, cached1_buffers__, this.cached1_unsupported_);
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

            public static IsBufferWritableNode create(InteropValue interop) {
                return new IsBufferWritableNodeGen(interop);
            }

            @GeneratedBy(IsBufferWritableNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(GetBufferSizeNode.class)
        static final class GetBufferSizeNodeGen extends GetBufferSizeNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private GetBufferSizeNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return GetBufferSizeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_);
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
                        InteropLibrary cached1_buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetBufferSizeNode.doCached(arg0Value, arg1Value, arg2Value, cached1_buffers__, this.cached1_unsupported_);
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
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetBufferSizeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetBufferSizeNode.doCached(arg0Value, arg1Value, arg2Value, cached1_buffers__, this.cached1_unsupported_);
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

            public static GetBufferSizeNode create(InteropValue interop) {
                return new GetBufferSizeNodeGen(interop);
            }

            @GeneratedBy(GetBufferSizeNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(ReadBufferByteNode.class)
        static final class ReadBufferByteNodeGen extends ReadBufferByteNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private ReadBufferByteNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return ReadBufferByteNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return ReadBufferByteNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return ReadBufferByteNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                        }
                    }
                    {
                        InteropLibrary buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toHost_ = (createToHost());
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return ReadBufferByteNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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

            public static ReadBufferByteNode create(InteropValue interop) {
                return new ReadBufferByteNodeGen(interop);
            }

            @GeneratedBy(ReadBufferByteNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

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
            @GeneratedBy(ReadBufferByteNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(WriteBufferByteNode.class)
        static final class WriteBufferByteNodeGen extends WriteBufferByteNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private WriteBufferByteNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return WriteBufferByteNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return WriteBufferByteNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.invalidIndex_ = (BranchProfile.create());
                                s0_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return WriteBufferByteNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                        }
                    }
                    {
                        InteropLibrary buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.invalidIndex_ = (BranchProfile.create());
                                s1_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return WriteBufferByteNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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

            public static WriteBufferByteNode create(InteropValue interop) {
                return new WriteBufferByteNodeGen(interop);
            }

            @GeneratedBy(WriteBufferByteNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

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
            @GeneratedBy(WriteBufferByteNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(ReadBufferShortNode.class)
        static final class ReadBufferShortNodeGen extends ReadBufferShortNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private ReadBufferShortNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return ReadBufferShortNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return ReadBufferShortNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return ReadBufferShortNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                        }
                    }
                    {
                        InteropLibrary buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toHost_ = (createToHost());
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return ReadBufferShortNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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

            public static ReadBufferShortNode create(InteropValue interop) {
                return new ReadBufferShortNodeGen(interop);
            }

            @GeneratedBy(ReadBufferShortNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

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
            @GeneratedBy(ReadBufferShortNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(WriteBufferShortNode.class)
        static final class WriteBufferShortNodeGen extends WriteBufferShortNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private WriteBufferShortNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return WriteBufferShortNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return WriteBufferShortNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.invalidIndex_ = (BranchProfile.create());
                                s0_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return WriteBufferShortNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                        }
                    }
                    {
                        InteropLibrary buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.invalidIndex_ = (BranchProfile.create());
                                s1_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return WriteBufferShortNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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

            public static WriteBufferShortNode create(InteropValue interop) {
                return new WriteBufferShortNodeGen(interop);
            }

            @GeneratedBy(WriteBufferShortNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

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
            @GeneratedBy(WriteBufferShortNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(ReadBufferIntNode.class)
        static final class ReadBufferIntNodeGen extends ReadBufferIntNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private ReadBufferIntNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return ReadBufferIntNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return ReadBufferIntNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return ReadBufferIntNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                        }
                    }
                    {
                        InteropLibrary buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toHost_ = (createToHost());
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return ReadBufferIntNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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

            public static ReadBufferIntNode create(InteropValue interop) {
                return new ReadBufferIntNodeGen(interop);
            }

            @GeneratedBy(ReadBufferIntNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

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
            @GeneratedBy(ReadBufferIntNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(WriteBufferIntNode.class)
        static final class WriteBufferIntNodeGen extends WriteBufferIntNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private WriteBufferIntNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return WriteBufferIntNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return WriteBufferIntNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.invalidIndex_ = (BranchProfile.create());
                                s0_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return WriteBufferIntNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                        }
                    }
                    {
                        InteropLibrary buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.invalidIndex_ = (BranchProfile.create());
                                s1_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return WriteBufferIntNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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

            public static WriteBufferIntNode create(InteropValue interop) {
                return new WriteBufferIntNodeGen(interop);
            }

            @GeneratedBy(WriteBufferIntNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

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
            @GeneratedBy(WriteBufferIntNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(ReadBufferLongNode.class)
        static final class ReadBufferLongNodeGen extends ReadBufferLongNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private ReadBufferLongNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return ReadBufferLongNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return ReadBufferLongNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return ReadBufferLongNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                        }
                    }
                    {
                        InteropLibrary buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toHost_ = (createToHost());
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return ReadBufferLongNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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

            public static ReadBufferLongNode create(InteropValue interop) {
                return new ReadBufferLongNodeGen(interop);
            }

            @GeneratedBy(ReadBufferLongNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

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
            @GeneratedBy(ReadBufferLongNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(WriteBufferLongNode.class)
        static final class WriteBufferLongNodeGen extends WriteBufferLongNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private WriteBufferLongNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return WriteBufferLongNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return WriteBufferLongNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.invalidIndex_ = (BranchProfile.create());
                                s0_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return WriteBufferLongNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                        }
                    }
                    {
                        InteropLibrary buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.invalidIndex_ = (BranchProfile.create());
                                s1_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return WriteBufferLongNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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

            public static WriteBufferLongNode create(InteropValue interop) {
                return new WriteBufferLongNodeGen(interop);
            }

            @GeneratedBy(WriteBufferLongNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

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
            @GeneratedBy(WriteBufferLongNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(ReadBufferFloatNode.class)
        static final class ReadBufferFloatNodeGen extends ReadBufferFloatNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private ReadBufferFloatNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return ReadBufferFloatNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return ReadBufferFloatNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return ReadBufferFloatNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                        }
                    }
                    {
                        InteropLibrary buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toHost_ = (createToHost());
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return ReadBufferFloatNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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

            public static ReadBufferFloatNode create(InteropValue interop) {
                return new ReadBufferFloatNodeGen(interop);
            }

            @GeneratedBy(ReadBufferFloatNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

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
            @GeneratedBy(ReadBufferFloatNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(WriteBufferFloatNode.class)
        static final class WriteBufferFloatNodeGen extends WriteBufferFloatNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private WriteBufferFloatNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return WriteBufferFloatNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return WriteBufferFloatNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.invalidIndex_ = (BranchProfile.create());
                                s0_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return WriteBufferFloatNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                        }
                    }
                    {
                        InteropLibrary buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.invalidIndex_ = (BranchProfile.create());
                                s1_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return WriteBufferFloatNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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

            public static WriteBufferFloatNode create(InteropValue interop) {
                return new WriteBufferFloatNodeGen(interop);
            }

            @GeneratedBy(WriteBufferFloatNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

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
            @GeneratedBy(WriteBufferFloatNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(ReadBufferDoubleNode.class)
        static final class ReadBufferDoubleNodeGen extends ReadBufferDoubleNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private ReadBufferDoubleNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return ReadBufferDoubleNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return ReadBufferDoubleNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return ReadBufferDoubleNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                        }
                    }
                    {
                        InteropLibrary buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toHost_ = (createToHost());
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return ReadBufferDoubleNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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

            public static ReadBufferDoubleNode create(InteropValue interop) {
                return new ReadBufferDoubleNodeGen(interop);
            }

            @GeneratedBy(ReadBufferDoubleNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

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
            @GeneratedBy(ReadBufferDoubleNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(WriteBufferDoubleNode.class)
        static final class WriteBufferDoubleNodeGen extends WriteBufferDoubleNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private WriteBufferDoubleNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.buffers_.accepts(arg1Value))) {
                                return WriteBufferDoubleNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return WriteBufferDoubleNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.buffers_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.buffers_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.buffers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.invalidIndex_ = (BranchProfile.create());
                                s0_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return WriteBufferDoubleNode.doCached(arg0Value, arg1Value, arg2Value, s0_.buffers_, s0_.unsupported_, s0_.invalidIndex_, s0_.invalidValue_);
                        }
                    }
                    {
                        InteropLibrary buffers__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                buffers__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.invalidIndex_ = (BranchProfile.create());
                                s1_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return WriteBufferDoubleNode.doCached(arg0Value, arg1Value, arg2Value, buffers__, s1_.unsupported_, s1_.invalidIndex_, s1_.invalidValue_);
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

            public static WriteBufferDoubleNode create(InteropValue interop) {
                return new WriteBufferDoubleNodeGen(interop);
            }

            @GeneratedBy(WriteBufferDoubleNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary buffers_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

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
            @GeneratedBy(WriteBufferDoubleNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidIndex_;
                @CompilationFinal BranchProfile invalidValue_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(GetMemberNode.class)
        static final class GetMemberNodeGen extends GetMemberNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private GetMemberNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return GetMemberNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetMemberNode.doCached(arg0Value, arg1Value, arg2Value, objects__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetMemberNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.toHost_, s0_.unsupported_, s0_.unknown_);
                        }
                    }
                    {
                        InteropLibrary objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toHost_ = (createToHost());
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetMemberNode.doCached(arg0Value, arg1Value, arg2Value, objects__, s1_.toHost_, s1_.unsupported_, s1_.unknown_);
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

            public static GetMemberNode create(InteropValue interop) {
                return new GetMemberNodeGen(interop);
            }

            @GeneratedBy(GetMemberNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

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
            @GeneratedBy(GetMemberNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(PutMemberNode.class)
        static final class PutMemberNodeGen extends PutMemberNode {

            @CompilationFinal private volatile int state_0_;
            @Child private CachedData cached_cache;

            private PutMemberNodeGen(InteropValue interop) {
                super(interop);
            }

            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                    CachedData s0_ = this.cached_cache;
                    if (s0_ != null) {
                        return PutMemberNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.toGuestValue_, s0_.unsupported_, s0_.invalidValue_, s0_.unknown_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object executeAndSpecialize(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    CachedData s0_ = super.insert(new CachedData());
                    s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.createDispatched(InteropNode.CACHE_LIMIT)));
                    s0_.toGuestValue_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                    s0_.unsupported_ = (BranchProfile.create());
                    s0_.invalidValue_ = (BranchProfile.create());
                    s0_.unknown_ = (BranchProfile.create());
                    MemoryFence.storeStore();
                    this.cached_cache = s0_;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return PutMemberNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.toGuestValue_, s0_.unsupported_, s0_.invalidValue_, s0_.unknown_);
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

            public static PutMemberNode create(InteropValue interop) {
                return new PutMemberNodeGen(interop);
            }

            @GeneratedBy(PutMemberNode.class)
            private static final class CachedData extends Node {

                @Child InteropLibrary objects_;
                @Child ToGuestValueNode toGuestValue_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidValue_;
                @CompilationFinal BranchProfile unknown_;

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
        @GeneratedBy(RemoveMemberNode.class)
        static final class RemoveMemberNodeGen extends RemoveMemberNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;
            @CompilationFinal private BranchProfile cached1_unknown_;

            private RemoveMemberNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return RemoveMemberNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_, s0_.unknown_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return RemoveMemberNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_, this.cached1_unknown_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.unknown_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return RemoveMemberNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_, s0_.unknown_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.cached1_unknown_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return RemoveMemberNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_, this.cached1_unknown_);
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

            public static RemoveMemberNode create(InteropValue interop) {
                return new RemoveMemberNodeGen(interop);
            }

            @GeneratedBy(RemoveMemberNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile unknown_;

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
        @GeneratedBy(IsNullNode.class)
        static final class IsNullNodeGen extends IsNullNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private IsNullNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.values_.accepts(arg1Value))) {
                                return IsNullNode.doCached(arg0Value, arg1Value, arg2Value, s0_.values_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_values__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return IsNullNode.doCached(arg0Value, arg1Value, arg2Value, cached1_values__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.values_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.values_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.values_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsNullNode.doCached(arg0Value, arg1Value, arg2Value, s0_.values_);
                        }
                    }
                    {
                        InteropLibrary cached1_values__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_values__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return IsNullNode.doCached(arg0Value, arg1Value, arg2Value, cached1_values__);
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

            public static IsNullNode create(InteropValue interop) {
                return new IsNullNodeGen(interop);
            }

            @GeneratedBy(IsNullNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary values_;

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
        @GeneratedBy(HasMembersNode.class)
        static final class HasMembersNodeGen extends HasMembersNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private HasMembersNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return HasMembersNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return HasMembersNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return HasMembersNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return HasMembersNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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

            public static HasMembersNode create(InteropValue interop) {
                return new HasMembersNodeGen(interop);
            }

            @GeneratedBy(HasMembersNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;

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
        @GeneratedBy(HasMemberNode.class)
        static final class HasMemberNodeGen extends HasMemberNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private HasMemberNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return HasMemberNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return HasMemberNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return HasMemberNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return HasMemberNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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

            public static HasMemberNode create(InteropValue interop) {
                return new HasMemberNodeGen(interop);
            }

            @GeneratedBy(HasMemberNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;

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
        @GeneratedBy(CanInvokeNode.class)
        static final class CanInvokeNodeGen extends CanInvokeNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private CanInvokeNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return CanInvokeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return CanInvokeNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return CanInvokeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return CanInvokeNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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

            public static CanInvokeNode create(InteropValue interop) {
                return new CanInvokeNodeGen(interop);
            }

            @GeneratedBy(CanInvokeNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;

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
        @GeneratedBy(CanExecuteNode.class)
        static final class CanExecuteNodeGen extends CanExecuteNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private CanExecuteNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.executables_.accepts(arg1Value))) {
                                return CanExecuteNode.doCached(arg0Value, arg1Value, arg2Value, s0_.executables_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_executables__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return CanExecuteNode.doCached(arg0Value, arg1Value, arg2Value, cached1_executables__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.executables_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.executables_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.executables_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return CanExecuteNode.doCached(arg0Value, arg1Value, arg2Value, s0_.executables_);
                        }
                    }
                    {
                        InteropLibrary cached1_executables__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_executables__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return CanExecuteNode.doCached(arg0Value, arg1Value, arg2Value, cached1_executables__);
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

            public static CanExecuteNode create(InteropValue interop) {
                return new CanExecuteNodeGen(interop);
            }

            @GeneratedBy(CanExecuteNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary executables_;

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
        @GeneratedBy(CanInstantiateNode.class)
        static final class CanInstantiateNodeGen extends CanInstantiateNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private CanInstantiateNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.instantiables_.accepts(arg1Value))) {
                                return CanInstantiateNode.doCached(arg0Value, arg1Value, arg2Value, s0_.instantiables_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_instantiables__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return CanInstantiateNode.doCached(arg0Value, arg1Value, arg2Value, cached1_instantiables__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.instantiables_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.instantiables_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.instantiables_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return CanInstantiateNode.doCached(arg0Value, arg1Value, arg2Value, s0_.instantiables_);
                        }
                    }
                    {
                        InteropLibrary cached1_instantiables__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_instantiables__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return CanInstantiateNode.doCached(arg0Value, arg1Value, arg2Value, cached1_instantiables__);
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

            public static CanInstantiateNode create(InteropValue interop) {
                return new CanInstantiateNodeGen(interop);
            }

            @GeneratedBy(CanInstantiateNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary instantiables_;

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
        @GeneratedBy(NewInstanceNode.class)
        static final class NewInstanceNodeGen extends NewInstanceNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private NewInstanceNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValuesNode, ToHostValueNode, BranchProfile, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValuesNode, ToHostValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValuesNode, ToHostValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.instantiables_.accepts(arg1Value))) {
                                return NewInstanceNode.doCached(arg0Value, arg1Value, arg2Value, s0_.instantiables_, s0_.toGuestValues_, s0_.toHostValue_, s0_.arity_, s0_.invalidArgument_, s0_.unsupported_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValuesNode, ToHostValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary instantiables__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return NewInstanceNode.doCached(arg0Value, arg1Value, arg2Value, instantiables__, s1_.toGuestValues_, s1_.toHostValue_, s1_.arity_, s1_.invalidArgument_, s1_.unsupported_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValuesNode, ToHostValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValuesNode, ToHostValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.instantiables_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.instantiables_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.instantiables_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuestValues_ = s0_.insertAccessor((ToGuestValuesNode.create()));
                                s0_.toHostValue_ = (createToHost());
                                s0_.arity_ = (BranchProfile.create());
                                s0_.invalidArgument_ = (BranchProfile.create());
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValuesNode, ToHostValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return NewInstanceNode.doCached(arg0Value, arg1Value, arg2Value, s0_.instantiables_, s0_.toGuestValues_, s0_.toHostValue_, s0_.arity_, s0_.invalidArgument_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary instantiables__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                instantiables__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toGuestValues_ = s1_.insertAccessor((ToGuestValuesNode.create()));
                                s1_.toHostValue_ = (createToHost());
                                s1_.arity_ = (BranchProfile.create());
                                s1_.invalidArgument_ = (BranchProfile.create());
                                s1_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValuesNode, ToHostValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValuesNode, ToHostValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValuesNode, ToHostValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return NewInstanceNode.doCached(arg0Value, arg1Value, arg2Value, instantiables__, s1_.toGuestValues_, s1_.toHostValue_, s1_.arity_, s1_.invalidArgument_, s1_.unsupported_);
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

            public static NewInstanceNode create(InteropValue interop) {
                return new NewInstanceNodeGen(interop);
            }

            @GeneratedBy(NewInstanceNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary instantiables_;
                @Child ToGuestValuesNode toGuestValues_;
                @CompilationFinal ToHostValueNode toHostValue_;
                @CompilationFinal BranchProfile arity_;
                @CompilationFinal BranchProfile invalidArgument_;
                @CompilationFinal BranchProfile unsupported_;

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
            @GeneratedBy(NewInstanceNode.class)
            private static final class Cached1Data extends Node {

                @Child ToGuestValuesNode toGuestValues_;
                @CompilationFinal ToHostValueNode toHostValue_;
                @CompilationFinal BranchProfile arity_;
                @CompilationFinal BranchProfile invalidArgument_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(IsExceptionNode.class)
        static final class IsExceptionNodeGen extends IsExceptionNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private IsExceptionNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return IsExceptionNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return IsExceptionNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsExceptionNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return IsExceptionNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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

            public static IsExceptionNode create(InteropValue interop) {
                return new IsExceptionNodeGen(interop);
            }

            @GeneratedBy(IsExceptionNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;

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
        @GeneratedBy(ThrowExceptionNode.class)
        static final class ThrowExceptionNodeGen extends ThrowExceptionNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private ThrowExceptionNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return ThrowExceptionNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_);
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return ThrowExceptionNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_);
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
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return ThrowExceptionNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return ThrowExceptionNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_unsupported_);
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

            public static ThrowExceptionNode create(InteropValue interop) {
                return new ThrowExceptionNodeGen(interop);
            }

            @GeneratedBy(ThrowExceptionNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(IsMetaObjectNode.class)
        static final class IsMetaObjectNodeGen extends IsMetaObjectNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private IsMetaObjectNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return IsMetaObjectNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return IsMetaObjectNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
                    }
                } finally {
                    encapsulating_.set(prev_);
                }
            }

            private boolean executeAndSpecialize(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMetaObjectNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return IsMetaObjectNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__);
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

            public static IsMetaObjectNode create(InteropValue interop) {
                return new IsMetaObjectNodeGen(interop);
            }

            @GeneratedBy(IsMetaObjectNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;

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
        @GeneratedBy(GetMetaQualifiedNameNode.class)
        static final class GetMetaQualifiedNameNodeGen extends GetMetaQualifiedNameNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private InteropLibrary cached1_toString_;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private GetMetaQualifiedNameNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return GetMetaQualifiedNameNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.toString_, s0_.unsupported_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetMetaQualifiedNameNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_toString_, this.cached1_unsupported_);
                    }
                } finally {
                    encapsulating_.set(prev_);
                }
            }

            private String executeAndSpecialize(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toString_ = s0_.insertAccessor((INTEROP_LIBRARY_.createDispatched(1)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetMetaQualifiedNameNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.toString_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toString_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetMetaQualifiedNameNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_toString_, this.cached1_unsupported_);
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

            public static GetMetaQualifiedNameNode create(InteropValue interop) {
                return new GetMetaQualifiedNameNodeGen(interop);
            }

            @GeneratedBy(GetMetaQualifiedNameNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;
                @Child InteropLibrary toString_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(GetMetaSimpleNameNode.class)
        static final class GetMetaSimpleNameNodeGen extends GetMetaSimpleNameNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private InteropLibrary cached1_toString_;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private GetMetaSimpleNameNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return GetMetaSimpleNameNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.toString_, s0_.unsupported_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */) {
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetMetaSimpleNameNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_toString_, this.cached1_unsupported_);
                    }
                } finally {
                    encapsulating_.set(prev_);
                }
            }

            private String executeAndSpecialize(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toString_ = s0_.insertAccessor((INTEROP_LIBRARY_.createDispatched(1)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetMetaSimpleNameNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.toString_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toString_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetMetaSimpleNameNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_toString_, this.cached1_unsupported_);
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

            public static GetMetaSimpleNameNode create(InteropValue interop) {
                return new GetMetaSimpleNameNodeGen(interop);
            }

            @GeneratedBy(GetMetaSimpleNameNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;
                @Child InteropLibrary toString_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(IsMetaInstanceNode.class)
        static final class IsMetaInstanceNodeGen extends IsMetaInstanceNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private ToGuestValueNode cached1_toGuest_;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private IsMetaInstanceNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.objects_.accepts(arg1Value))) {
                                return IsMetaInstanceNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.toGuest_, s0_.unsupported_);
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
                        InteropLibrary cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return IsMetaInstanceNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_toGuest_, this.cached1_unsupported_);
                    }
                } finally {
                    encapsulating_.set(prev_);
                }
            }

            private boolean executeAndSpecialize(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
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
                                if ((s0_.objects_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.objects_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.objects_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuest_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMetaInstanceNode.doCached(arg0Value, arg1Value, arg2Value, s0_.objects_, s0_.toGuest_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_objects__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_objects__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toGuest_ = super.insert((ToGuestValueNodeGen.create()));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return IsMetaInstanceNode.doCached(arg0Value, arg1Value, arg2Value, cached1_objects__, this.cached1_toGuest_, this.cached1_unsupported_);
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

            public static IsMetaInstanceNode create(InteropValue interop) {
                return new IsMetaInstanceNodeGen(interop);
            }

            @GeneratedBy(IsMetaInstanceNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary objects_;
                @Child ToGuestValueNode toGuest_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(HasIteratorNode.class)
        static final class HasIteratorNodeGen extends HasIteratorNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private HasIteratorNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.iterators_.accepts(arg1Value))) {
                                return HasIteratorNode.doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        return HasIteratorNode.doCached(arg0Value, arg1Value, arg2Value, cached1_iterators__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.iterators_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return HasIteratorNode.doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_);
                        }
                    }
                    {
                        InteropLibrary cached1_iterators__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_iterators__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return HasIteratorNode.doCached(arg0Value, arg1Value, arg2Value, cached1_iterators__);
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

            public static HasIteratorNode create(InteropValue interop) {
                return new HasIteratorNodeGen(interop);
            }

            @GeneratedBy(HasIteratorNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary iterators_;

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
        @GeneratedBy(GetIteratorNode.class)
        static final class GetIteratorNodeGen extends GetIteratorNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private ToHostValueNode cached1_toHost_;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private GetIteratorNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.iterators_.accepts(arg1Value))) {
                                return GetIteratorNode.doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_, s0_.toHost_, s0_.unsupported_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
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
                        return GetIteratorNode.doCached(arg0Value, arg1Value, arg2Value, cached1_iterators__, this.cached1_toHost_, this.cached1_unsupported_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
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
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.iterators_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetIteratorNode.doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_, s0_.toHost_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_iterators__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_iterators__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toHost_ = (createToHost());
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetIteratorNode.doCached(arg0Value, arg1Value, arg2Value, cached1_iterators__, this.cached1_toHost_, this.cached1_unsupported_);
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

            public static GetIteratorNode create(InteropValue interop) {
                return new GetIteratorNodeGen(interop);
            }

            @GeneratedBy(GetIteratorNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary iterators_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(IsIteratorNode.class)
        static final class IsIteratorNodeGen extends IsIteratorNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private IsIteratorNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.iterators_.accepts(arg1Value))) {
                                return IsIteratorNode.doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        return IsIteratorNode.doCached(arg0Value, arg1Value, arg2Value, cached1_iterators__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.iterators_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsIteratorNode.doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_);
                        }
                    }
                    {
                        InteropLibrary cached1_iterators__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_iterators__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return IsIteratorNode.doCached(arg0Value, arg1Value, arg2Value, cached1_iterators__);
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

            public static IsIteratorNode create(InteropValue interop) {
                return new IsIteratorNodeGen(interop);
            }

            @GeneratedBy(IsIteratorNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary iterators_;

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
        @GeneratedBy(HasIteratorNextElementNode.class)
        static final class HasIteratorNextElementNodeGen extends HasIteratorNextElementNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private HasIteratorNextElementNodeGen(InteropValue interop) {
                super(interop);
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
                                return HasIteratorNextElementNode.doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_, s0_.unsupported_);
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
                        return HasIteratorNextElementNode.doCached(arg0Value, arg1Value, arg2Value, cached1_iterators__, this.cached1_unsupported_);
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
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.iterators_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return HasIteratorNextElementNode.doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_iterators__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_iterators__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return HasIteratorNextElementNode.doCached(arg0Value, arg1Value, arg2Value, cached1_iterators__, this.cached1_unsupported_);
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

            public static HasIteratorNextElementNode create(InteropValue interop) {
                return new HasIteratorNextElementNodeGen(interop);
            }

            @GeneratedBy(HasIteratorNextElementNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary iterators_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(GetIteratorNextElementNode.class)
        static final class GetIteratorNextElementNodeGen extends GetIteratorNextElementNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private GetIteratorNextElementNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.iterators_.accepts(arg1Value))) {
                                return GetIteratorNextElementNode.doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_, s0_.toHost_, s0_.unsupported_, s0_.stop_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
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
                        return GetIteratorNextElementNode.doCached(arg0Value, arg1Value, arg2Value, iterators__, s1_.toHost_, s1_.unsupported_, s1_.stop_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */) {
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
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.iterators_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.stop_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetIteratorNextElementNode.doCached(arg0Value, arg1Value, arg2Value, s0_.iterators_, s0_.toHost_, s0_.unsupported_, s0_.stop_);
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
                                s1_.toHost_ = (createToHost());
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.stop_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetIteratorNextElementNode.doCached(arg0Value, arg1Value, arg2Value, iterators__, s1_.toHost_, s1_.unsupported_, s1_.stop_);
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

            public static GetIteratorNextElementNode create(InteropValue interop) {
                return new GetIteratorNextElementNodeGen(interop);
            }

            @GeneratedBy(GetIteratorNextElementNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary iterators_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
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
            @GeneratedBy(GetIteratorNextElementNode.class)
            private static final class Cached1Data extends Node {

                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile stop_;

                Cached1Data() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

            }
        }
        @GeneratedBy(HasHashEntriesNode.class)
        static final class HasHashEntriesNodeGen extends HasHashEntriesNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;

            private HasHashEntriesNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.hashes_.accepts(arg1Value))) {
                                return HasHashEntriesNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
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
                        InteropLibrary cached1_hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return HasHashEntriesNode.doCached(arg0Value, arg1Value, arg2Value, cached1_hashes__);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */) {
                            while (s0_ != null) {
                                if ((s0_.hashes_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.hashes_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.hashes_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return HasHashEntriesNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_);
                        }
                    }
                    {
                        InteropLibrary cached1_hashes__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return HasHashEntriesNode.doCached(arg0Value, arg1Value, arg2Value, cached1_hashes__);
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

            public static HasHashEntriesNode create(InteropValue interop) {
                return new HasHashEntriesNodeGen(interop);
            }

            @GeneratedBy(HasHashEntriesNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary hashes_;

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
        @GeneratedBy(GetHashSizeNode.class)
        static final class GetHashSizeNodeGen extends GetHashSizeNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private GetHashSizeNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.hashes_.accepts(arg1Value))) {
                                return GetHashSizeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.unsupported_);
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
                        InteropLibrary cached1_hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetHashSizeNode.doCached(arg0Value, arg1Value, arg2Value, cached1_hashes__, this.cached1_unsupported_);
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
                                if ((s0_.hashes_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.hashes_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.hashes_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetHashSizeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_hashes__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetHashSizeNode.doCached(arg0Value, arg1Value, arg2Value, cached1_hashes__, this.cached1_unsupported_);
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

            public static GetHashSizeNode create(InteropValue interop) {
                return new GetHashSizeNodeGen(interop);
            }

            @GeneratedBy(GetHashSizeNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary hashes_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(HasHashEntryNode.class)
        static final class HasHashEntryNodeGen extends HasHashEntryNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private ToGuestValueNode cached1_toGuestKey_;

            private HasHashEntryNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.hashes_.accepts(arg1Value))) {
                                return HasHashEntryNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toGuestKey_);
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
                        InteropLibrary cached1_hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return HasHashEntryNode.doCached(arg0Value, arg1Value, arg2Value, cached1_hashes__, this.cached1_toGuestKey_);
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
                                if ((s0_.hashes_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.hashes_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.hashes_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuestKey_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return HasHashEntryNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toGuestKey_);
                        }
                    }
                    {
                        InteropLibrary cached1_hashes__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toGuestKey_ = super.insert((ToGuestValueNodeGen.create()));
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode) */;
                                lock.unlock();
                                hasLock = false;
                                return HasHashEntryNode.doCached(arg0Value, arg1Value, arg2Value, cached1_hashes__, this.cached1_toGuestKey_);
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

            public static HasHashEntryNode create(InteropValue interop) {
                return new HasHashEntryNodeGen(interop);
            }

            @GeneratedBy(HasHashEntryNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary hashes_;
                @Child ToGuestValueNode toGuestKey_;

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
        @GeneratedBy(GetHashValueNode.class)
        static final class GetHashValueNodeGen extends GetHashValueNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private GetHashValueNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.hashes_.accepts(arg1Value))) {
                                return GetHashValueNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toGuestKey_, s0_.toHost_, s0_.unsupported_, s0_.invalidKey_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetHashValueNode.doCached(arg0Value, arg1Value, arg2Value, hashes__, s1_.toGuestKey_, s1_.toHost_, s1_.unsupported_, s1_.invalidKey_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.hashes_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.hashes_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.hashes_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuestKey_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.invalidKey_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetHashValueNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toGuestKey_, s0_.toHost_, s0_.unsupported_, s0_.invalidKey_);
                        }
                    }
                    {
                        InteropLibrary hashes__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toGuestKey_ = s1_.insertAccessor((ToGuestValueNodeGen.create()));
                                s1_.toHost_ = (createToHost());
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.invalidKey_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetHashValueNode.doCached(arg0Value, arg1Value, arg2Value, hashes__, s1_.toGuestKey_, s1_.toHost_, s1_.unsupported_, s1_.invalidKey_);
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

            public static GetHashValueNode create(InteropValue interop) {
                return new GetHashValueNodeGen(interop);
            }

            @GeneratedBy(GetHashValueNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary hashes_;
                @Child ToGuestValueNode toGuestKey_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidKey_;

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
            @GeneratedBy(GetHashValueNode.class)
            private static final class Cached1Data extends Node {

                @Child ToGuestValueNode toGuestKey_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidKey_;

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
        @GeneratedBy(GetHashValueOrDefaultNode.class)
        static final class GetHashValueOrDefaultNodeGen extends GetHashValueOrDefaultNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private GetHashValueOrDefaultNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.hashes_.accepts(arg1Value))) {
                                return GetHashValueOrDefaultNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toGuestKey_, s0_.toGuestDefaultValue_, s0_.toHost_, s0_.unsupported_, s0_.invalidKey_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetHashValueOrDefaultNode.doCached(arg0Value, arg1Value, arg2Value, hashes__, s1_.toGuestKey_, s1_.toGuestDefaultValue_, s1_.toHost_, s1_.unsupported_, s1_.invalidKey_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.hashes_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.hashes_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.hashes_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuestKey_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.toGuestDefaultValue_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.invalidKey_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetHashValueOrDefaultNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toGuestKey_, s0_.toGuestDefaultValue_, s0_.toHost_, s0_.unsupported_, s0_.invalidKey_);
                        }
                    }
                    {
                        InteropLibrary hashes__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toGuestKey_ = s1_.insertAccessor((ToGuestValueNodeGen.create()));
                                s1_.toGuestDefaultValue_ = s1_.insertAccessor((ToGuestValueNodeGen.create()));
                                s1_.toHost_ = (createToHost());
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.invalidKey_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, ToHostValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetHashValueOrDefaultNode.doCached(arg0Value, arg1Value, arg2Value, hashes__, s1_.toGuestKey_, s1_.toGuestDefaultValue_, s1_.toHost_, s1_.unsupported_, s1_.invalidKey_);
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

            public static GetHashValueOrDefaultNode create(InteropValue interop) {
                return new GetHashValueOrDefaultNodeGen(interop);
            }

            @GeneratedBy(GetHashValueOrDefaultNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary hashes_;
                @Child ToGuestValueNode toGuestKey_;
                @Child ToGuestValueNode toGuestDefaultValue_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidKey_;

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
            @GeneratedBy(GetHashValueOrDefaultNode.class)
            private static final class Cached1Data extends Node {

                @Child ToGuestValueNode toGuestKey_;
                @Child ToGuestValueNode toGuestDefaultValue_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidKey_;

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
        @GeneratedBy(PutHashEntryNode.class)
        static final class PutHashEntryNodeGen extends PutHashEntryNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private PutHashEntryNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.hashes_.accepts(arg1Value))) {
                                return PutHashEntryNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toGuestKey_, s0_.toGuestValue_, s0_.unsupported_, s0_.invalidKey_, s0_.invalidValue_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return PutHashEntryNode.doCached(arg0Value, arg1Value, arg2Value, hashes__, s1_.toGuestKey_, s1_.toGuestValue_, s1_.unsupported_, s1_.invalidKey_, s1_.invalidValue_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.hashes_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.hashes_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.hashes_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuestKey_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.toGuestValue_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.invalidKey_ = (BranchProfile.create());
                                s0_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return PutHashEntryNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toGuestKey_, s0_.toGuestValue_, s0_.unsupported_, s0_.invalidKey_, s0_.invalidValue_);
                        }
                    }
                    {
                        InteropLibrary hashes__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toGuestKey_ = s1_.insertAccessor((ToGuestValueNodeGen.create()));
                                s1_.toGuestValue_ = s1_.insertAccessor((ToGuestValueNodeGen.create()));
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.invalidKey_ = (BranchProfile.create());
                                s1_.invalidValue_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, ToGuestValueNode, BranchProfile, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return PutHashEntryNode.doCached(arg0Value, arg1Value, arg2Value, hashes__, s1_.toGuestKey_, s1_.toGuestValue_, s1_.unsupported_, s1_.invalidKey_, s1_.invalidValue_);
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

            public static PutHashEntryNode create(InteropValue interop) {
                return new PutHashEntryNodeGen(interop);
            }

            @GeneratedBy(PutHashEntryNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary hashes_;
                @Child ToGuestValueNode toGuestKey_;
                @Child ToGuestValueNode toGuestValue_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidKey_;
                @CompilationFinal BranchProfile invalidValue_;

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
            @GeneratedBy(PutHashEntryNode.class)
            private static final class Cached1Data extends Node {

                @Child ToGuestValueNode toGuestKey_;
                @Child ToGuestValueNode toGuestValue_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidKey_;
                @CompilationFinal BranchProfile invalidValue_;

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
        @GeneratedBy(RemoveHashEntryNode.class)
        static final class RemoveHashEntryNodeGen extends RemoveHashEntryNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @Child private Cached1Data cached1_cache;

            private RemoveHashEntryNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.hashes_.accepts(arg1Value))) {
                                return RemoveHashEntryNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toGuestKey_, s0_.unsupported_, s0_.invalidKey_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile) */) {
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
                        InteropLibrary hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return RemoveHashEntryNode.doCached(arg0Value, arg1Value, arg2Value, hashes__, s1_.toGuestKey_, s1_.unsupported_, s1_.invalidKey_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.hashes_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.hashes_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.hashes_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toGuestKey_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                                s0_.unsupported_ = (BranchProfile.create());
                                s0_.invalidKey_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return RemoveHashEntryNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toGuestKey_, s0_.unsupported_, s0_.invalidKey_);
                        }
                    }
                    {
                        InteropLibrary hashes__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                Cached1Data s1_ = super.insert(new Cached1Data());
                                hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s1_.toGuestKey_ = s1_.insertAccessor((ToGuestValueNodeGen.create()));
                                s1_.unsupported_ = (BranchProfile.create());
                                s1_.invalidKey_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached1_cache = s1_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToGuestValueNode, BranchProfile, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return RemoveHashEntryNode.doCached(arg0Value, arg1Value, arg2Value, hashes__, s1_.toGuestKey_, s1_.unsupported_, s1_.invalidKey_);
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

            public static RemoveHashEntryNode create(InteropValue interop) {
                return new RemoveHashEntryNodeGen(interop);
            }

            @GeneratedBy(RemoveHashEntryNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary hashes_;
                @Child ToGuestValueNode toGuestKey_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidKey_;

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
            @GeneratedBy(RemoveHashEntryNode.class)
            private static final class Cached1Data extends Node {

                @Child ToGuestValueNode toGuestKey_;
                @CompilationFinal BranchProfile unsupported_;
                @CompilationFinal BranchProfile invalidKey_;

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
        @GeneratedBy(GetHashEntriesIteratorNode.class)
        static final class GetHashEntriesIteratorNodeGen extends GetHashEntriesIteratorNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private ToHostValueNode cached1_toHost_;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private GetHashEntriesIteratorNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.hashes_.accepts(arg1Value))) {
                                return GetHashEntriesIteratorNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toHost_, s0_.unsupported_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
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
                        InteropLibrary cached1_hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetHashEntriesIteratorNode.doCached(arg0Value, arg1Value, arg2Value, cached1_hashes__, this.cached1_toHost_, this.cached1_unsupported_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.hashes_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.hashes_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.hashes_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetHashEntriesIteratorNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toHost_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_hashes__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toHost_ = (createToHost());
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetHashEntriesIteratorNode.doCached(arg0Value, arg1Value, arg2Value, cached1_hashes__, this.cached1_toHost_, this.cached1_unsupported_);
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

            public static GetHashEntriesIteratorNode create(InteropValue interop) {
                return new GetHashEntriesIteratorNodeGen(interop);
            }

            @GeneratedBy(GetHashEntriesIteratorNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary hashes_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(GetHashKeysIteratorNode.class)
        static final class GetHashKeysIteratorNodeGen extends GetHashKeysIteratorNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private ToHostValueNode cached1_toHost_;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private GetHashKeysIteratorNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.hashes_.accepts(arg1Value))) {
                                return GetHashKeysIteratorNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toHost_, s0_.unsupported_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
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
                        InteropLibrary cached1_hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetHashKeysIteratorNode.doCached(arg0Value, arg1Value, arg2Value, cached1_hashes__, this.cached1_toHost_, this.cached1_unsupported_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.hashes_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.hashes_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.hashes_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetHashKeysIteratorNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toHost_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_hashes__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toHost_ = (createToHost());
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetHashKeysIteratorNode.doCached(arg0Value, arg1Value, arg2Value, cached1_hashes__, this.cached1_toHost_, this.cached1_unsupported_);
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

            public static GetHashKeysIteratorNode create(InteropValue interop) {
                return new GetHashKeysIteratorNodeGen(interop);
            }

            @GeneratedBy(GetHashKeysIteratorNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary hashes_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;

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
        @GeneratedBy(GetHashValuesIteratorNode.class)
        static final class GetHashValuesIteratorNodeGen extends GetHashValuesIteratorNode {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private Cached0Data cached0_cache;
            @CompilationFinal private ToHostValueNode cached1_toHost_;
            @CompilationFinal private BranchProfile cached1_unsupported_;

            private GetHashValuesIteratorNodeGen(InteropValue interop) {
                super(interop);
            }

            @ExplodeLoop
            @Override
            protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) || doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                        Cached0Data s0_ = this.cached0_cache;
                        while (s0_ != null) {
                            if ((s0_.hashes_.accepts(arg1Value))) {
                                return GetHashValuesIteratorNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toHost_, s0_.unsupported_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
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
                        InteropLibrary cached1_hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                        return GetHashValuesIteratorNode.doCached(arg0Value, arg1Value, arg2Value, cached1_hashes__, this.cached1_toHost_, this.cached1_unsupported_);
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
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                        int count0_ = 0;
                        Cached0Data s0_ = this.cached0_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */) {
                            while (s0_ != null) {
                                if ((s0_.hashes_.accepts(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (s0_.hashes_.accepts(arg1Value));
                            if (count0_ < (InteropNode.CACHE_LIMIT)) {
                                s0_ = super.insert(new Cached0Data(cached0_cache));
                                s0_.hashes_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                s0_.toHost_ = (createToHost());
                                s0_.unsupported_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cached0_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetHashValuesIteratorNode.doCached(arg0Value, arg1Value, arg2Value, s0_.hashes_, s0_.toHost_, s0_.unsupported_);
                        }
                    }
                    {
                        InteropLibrary cached1_hashes__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                cached1_hashes__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.cached1_toHost_ = (createToHost());
                                this.cached1_unsupported_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                this.cached0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(PolyglotLanguageContext, Object, Object[], InteropLibrary, ToHostValueNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return GetHashValuesIteratorNode.doCached(arg0Value, arg1Value, arg2Value, cached1_hashes__, this.cached1_toHost_, this.cached1_unsupported_);
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

            public static GetHashValuesIteratorNode create(InteropValue interop) {
                return new GetHashValuesIteratorNodeGen(interop);
            }

            @GeneratedBy(GetHashValuesIteratorNode.class)
            private static final class Cached0Data extends Node {

                @Child Cached0Data next_;
                @Child InteropLibrary hashes_;
                @CompilationFinal ToHostValueNode toHost_;
                @CompilationFinal BranchProfile unsupported_;

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
