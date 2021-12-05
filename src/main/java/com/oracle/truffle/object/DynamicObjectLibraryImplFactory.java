// CheckStyle: start generated
package com.oracle.truffle.object;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.object.DynamicObjectLibraryImpl.MakeSharedNode;
import com.oracle.truffle.object.DynamicObjectLibraryImpl.ResetShapeNode;
import com.oracle.truffle.object.DynamicObjectLibraryImpl.SetDynamicTypeNode;
import com.oracle.truffle.object.DynamicObjectLibraryImpl.SetFlagsNode;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DynamicObjectLibraryImpl.class)
final class DynamicObjectLibraryImplFactory {

    @GeneratedBy(SetFlagsNode.class)
    static final class SetFlagsNodeGen extends SetFlagsNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private SetFlagsNodeGen() {
        }

        @ExplodeLoop
        @Override
        boolean execute(DynamicObject arg0Value, Shape arg1Value, int arg2Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(DynamicObject, Shape, int, int, Shape) || doUncached(DynamicObject, Shape, int) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, int, int, Shape) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((arg2Value == s0_.newFlags_)) {
                            return SetFlagsNode.doCached(arg0Value, arg1Value, arg2Value, s0_.newFlags_, s0_.newShape_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(DynamicObject, Shape, int) */) {
                    return SetFlagsNode.doUncached(arg0Value, arg1Value, arg2Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private boolean executeAndSpecialize(DynamicObject arg0Value, Shape arg1Value, int arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(DynamicObject, Shape, int, int, Shape) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, int, int, Shape) */) {
                        while (s0_ != null) {
                            if ((arg2Value == s0_.newFlags_)) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        // assert (arg2Value == s0_.newFlags_);
                        if (count0_ < (3)) {
                            s0_ = new CachedData(cached_cache);
                            s0_.newFlags_ = (arg2Value);
                            s0_.newShape_ = (SetFlagsNode.shapeSetFlags(arg1Value, s0_.newFlags_));
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, Shape, int, int, Shape) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return SetFlagsNode.doCached(arg0Value, arg1Value, arg2Value, s0_.newFlags_, s0_.newShape_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(DynamicObject, Shape, int, int, Shape) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(DynamicObject, Shape, int, int, Shape) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(DynamicObject, Shape, int) */;
                lock.unlock();
                hasLock = false;
                return SetFlagsNode.doUncached(arg0Value, arg1Value, arg2Value);
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

        public static SetFlagsNode create() {
            return new SetFlagsNodeGen();
        }

        public static SetFlagsNode getUncached() {
            return SetFlagsNodeGen.UNCACHED;
        }

        @GeneratedBy(SetFlagsNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal int newFlags_;
            @CompilationFinal Shape newShape_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
        @GeneratedBy(SetFlagsNode.class)
        private static final class Uncached extends SetFlagsNode {

            @TruffleBoundary
            @Override
            boolean execute(DynamicObject arg0Value, Shape arg1Value, int arg2Value) {
                return SetFlagsNode.doUncached(arg0Value, arg1Value, arg2Value);
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
    @GeneratedBy(SetDynamicTypeNode.class)
    static final class SetDynamicTypeNodeGen extends SetDynamicTypeNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private SetDynamicTypeNodeGen() {
        }

        @ExplodeLoop
        @Override
        boolean execute(DynamicObject arg0Value, Shape arg1Value, Object arg2Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(DynamicObject, Shape, Object, Object, Shape) || doUncached(DynamicObject, Shape, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, Object, Object, Shape) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((arg2Value == s0_.newObjectType_)) {
                            return SetDynamicTypeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.newObjectType_, s0_.newShape_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(DynamicObject, Shape, Object) */) {
                    return SetDynamicTypeNode.doUncached(arg0Value, arg1Value, arg2Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private boolean executeAndSpecialize(DynamicObject arg0Value, Shape arg1Value, Object arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(DynamicObject, Shape, Object, Object, Shape) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Shape, Object, Object, Shape) */) {
                        while (s0_ != null) {
                            if ((arg2Value == s0_.newObjectType_)) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        // assert (arg2Value == s0_.newObjectType_);
                        if (count0_ < (3)) {
                            s0_ = new CachedData(cached_cache);
                            s0_.newObjectType_ = (arg2Value);
                            s0_.newShape_ = (SetDynamicTypeNode.shapeSetDynamicType(arg1Value, s0_.newObjectType_));
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, Shape, Object, Object, Shape) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return SetDynamicTypeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.newObjectType_, s0_.newShape_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(DynamicObject, Shape, Object, Object, Shape) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(DynamicObject, Shape, Object, Object, Shape) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(DynamicObject, Shape, Object) */;
                lock.unlock();
                hasLock = false;
                return SetDynamicTypeNode.doUncached(arg0Value, arg1Value, arg2Value);
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

        public static SetDynamicTypeNode create() {
            return new SetDynamicTypeNodeGen();
        }

        public static SetDynamicTypeNode getUncached() {
            return SetDynamicTypeNodeGen.UNCACHED;
        }

        @GeneratedBy(SetDynamicTypeNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal Object newObjectType_;
            @CompilationFinal Shape newShape_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
        @GeneratedBy(SetDynamicTypeNode.class)
        private static final class Uncached extends SetDynamicTypeNode {

            @TruffleBoundary
            @Override
            boolean execute(DynamicObject arg0Value, Shape arg1Value, Object arg2Value) {
                return SetDynamicTypeNode.doUncached(arg0Value, arg1Value, arg2Value);
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
    @GeneratedBy(MakeSharedNode.class)
    static final class MakeSharedNodeGen extends MakeSharedNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private Shape newShape_;

        private MakeSharedNodeGen() {
        }

        @Override
        void execute(DynamicObject arg0Value, Shape arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(DynamicObject, Shape, Shape) */) {
                MakeSharedNode.doCached(arg0Value, arg1Value, this.newShape_);
                return;
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arg0Value, arg1Value);
            return;
        }

        private void executeAndSpecialize(DynamicObject arg0Value, Shape arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                this.newShape_ = (arg1Value.makeSharedShape());
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, Shape, Shape) */;
                lock.unlock();
                hasLock = false;
                MakeSharedNode.doCached(arg0Value, arg1Value, this.newShape_);
                return;
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

        public static MakeSharedNode create() {
            return new MakeSharedNodeGen();
        }

        public static MakeSharedNode getUncached() {
            return MakeSharedNodeGen.UNCACHED;
        }

        @GeneratedBy(MakeSharedNode.class)
        private static final class Uncached extends MakeSharedNode {

            @TruffleBoundary
            @Override
            void execute(DynamicObject arg0Value, Shape arg1Value) {
                MakeSharedNode.doCached(arg0Value, arg1Value, (arg1Value.makeSharedShape()));
                return;
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
    @GeneratedBy(ResetShapeNode.class)
    static final class ResetShapeNodeGen extends ResetShapeNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private CachedData cached_cache;

        private ResetShapeNodeGen() {
        }

        @ExplodeLoop
        @Override
        boolean execute(DynamicObject arg0Value, Shape arg1Value, Shape arg2Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(DynamicObject, Shape, Shape, Shape) */) {
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    if ((arg2Value == s0_.cachedOtherShape_)) {
                        return ResetShapeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.cachedOtherShape_);
                    }
                    s0_ = s0_.next_;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private boolean executeAndSpecialize(DynamicObject arg0Value, Shape arg1Value, Shape arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int count0_ = 0;
                CachedData s0_ = this.cached_cache;
                if (state_0 != 0 /* is-state_0 doCached(DynamicObject, Shape, Shape, Shape) */) {
                    while (s0_ != null) {
                        if ((arg2Value == s0_.cachedOtherShape_)) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    {
                        Shape cachedOtherShape__ = (ResetShapeNode.verifyResetShape(arg1Value, arg2Value));
                        if ((arg2Value == cachedOtherShape__) && count0_ < (3)) {
                            s0_ = new CachedData(cached_cache);
                            s0_.cachedOtherShape_ = cachedOtherShape__;
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, Shape, Shape, Shape) */;
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return ResetShapeNode.doCached(arg0Value, arg1Value, arg2Value, s0_.cachedOtherShape_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
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

        public static ResetShapeNode create() {
            return new ResetShapeNodeGen();
        }

        public static ResetShapeNode getUncached() {
            return ResetShapeNodeGen.UNCACHED;
        }

        @GeneratedBy(ResetShapeNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal Shape cachedOtherShape_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
        @GeneratedBy(ResetShapeNode.class)
        private static final class Uncached extends ResetShapeNode {

            @TruffleBoundary
            @Override
            boolean execute(DynamicObject arg0Value, Shape arg1Value, Shape arg2Value) {
                if ((arg2Value == (ResetShapeNode.verifyResetShape(arg1Value, arg2Value)))) {
                    return ResetShapeNode.doCached(arg0Value, arg1Value, arg2Value, (ResetShapeNode.verifyResetShape(arg1Value, arg2Value)));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
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
