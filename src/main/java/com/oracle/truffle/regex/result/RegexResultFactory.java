// CheckStyle: start generated
package com.oracle.truffle.regex.result;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.regex.result.RegexResult.InvokeCacheNode;
import com.oracle.truffle.regex.result.RegexResult.RegexResultGetEndNode;
import com.oracle.truffle.regex.result.RegexResult.RegexResultGetStartNode;
import com.oracle.truffle.regex.runtime.nodes.DispatchNode;
import com.oracle.truffle.regex.runtime.nodes.DispatchNodeGen;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RegexResult.class)
public final class RegexResultFactory {

    @GeneratedBy(InvokeCacheNode.class)
    static final class InvokeCacheNodeGen extends InvokeCacheNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private GetStartIdentityData getStartIdentity_cache;
        @Child private GetStartEqualsData getStartEquals_cache;
        @Child private GetEndIdentityData getEndIdentity_cache;
        @Child private GetEndEqualsData getEndEquals_cache;
        @Child private RegexResultGetStartNode invokeGeneric_getStartNode_;
        @Child private RegexResultGetEndNode invokeGeneric_getEndNode_;

        private InvokeCacheNodeGen() {
        }

        @ExplodeLoop
        @Override
        Object execute(RegexResult arg0Value, String arg1Value, int arg2Value) throws UnknownIdentifierException {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 getStartIdentity(RegexResult, String, int, String, RegexResultGetStartNode) || getStartEquals(RegexResult, String, int, String, RegexResultGetStartNode) || getEndIdentity(RegexResult, String, int, String, RegexResultGetEndNode) || getEndEquals(RegexResult, String, int, String, RegexResultGetEndNode) || invokeGeneric(RegexResult, String, int, RegexResultGetStartNode, RegexResultGetEndNode) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 getStartIdentity(RegexResult, String, int, String, RegexResultGetStartNode) */) {
                    GetStartIdentityData s0_ = this.getStartIdentity_cache;
                    while (s0_ != null) {
                        if ((arg1Value == s0_.cachedSymbol_)) {
                            assert (s0_.cachedSymbol_.equals(RegexResult.PROP_GET_START));
                            return getStartIdentity(arg0Value, arg1Value, arg2Value, s0_.cachedSymbol_, s0_.getStartNode_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 getStartEquals(RegexResult, String, int, String, RegexResultGetStartNode) */) {
                    GetStartEqualsData s1_ = this.getStartEquals_cache;
                    while (s1_ != null) {
                        if ((arg1Value.equals(s1_.cachedSymbol_))) {
                            assert (s1_.cachedSymbol_.equals(RegexResult.PROP_GET_START));
                            return getStartEquals(arg0Value, arg1Value, arg2Value, s1_.cachedSymbol_, s1_.getStartNode_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 getEndIdentity(RegexResult, String, int, String, RegexResultGetEndNode) */) {
                    GetEndIdentityData s2_ = this.getEndIdentity_cache;
                    while (s2_ != null) {
                        if ((arg1Value == s2_.cachedSymbol_)) {
                            assert (s2_.cachedSymbol_.equals(RegexResult.PROP_GET_END));
                            return getEndIdentity(arg0Value, arg1Value, arg2Value, s2_.cachedSymbol_, s2_.getEndNode_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 getEndEquals(RegexResult, String, int, String, RegexResultGetEndNode) */) {
                    GetEndEqualsData s3_ = this.getEndEquals_cache;
                    while (s3_ != null) {
                        if ((arg1Value.equals(s3_.cachedSymbol_))) {
                            assert (s3_.cachedSymbol_.equals(RegexResult.PROP_GET_END));
                            return getEndEquals(arg0Value, arg1Value, arg2Value, s3_.cachedSymbol_, s3_.getEndNode_);
                        }
                        s3_ = s3_.next_;
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 invokeGeneric(RegexResult, String, int, RegexResultGetStartNode, RegexResultGetEndNode) */) {
                    return InvokeCacheNode.invokeGeneric(arg0Value, arg1Value, arg2Value, this.invokeGeneric_getStartNode_, this.invokeGeneric_getEndNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private Object executeAndSpecialize(RegexResult arg0Value, String arg1Value, int arg2Value) throws UnknownIdentifierException {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                int oldState_0 = state_0;
                try {
                    if (((exclude & 0b1)) == 0 /* is-not-exclude getStartIdentity(RegexResult, String, int, String, RegexResultGetStartNode) */) {
                        int count0_ = 0;
                        GetStartIdentityData s0_ = this.getStartIdentity_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 getStartIdentity(RegexResult, String, int, String, RegexResultGetStartNode) */) {
                            while (s0_ != null) {
                                if ((arg1Value == s0_.cachedSymbol_)) {
                                    assert (s0_.cachedSymbol_.equals(RegexResult.PROP_GET_START));
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                String cachedSymbol__ = (arg1Value);
                                // assert (arg1Value == s0_.cachedSymbol_);
                                if ((cachedSymbol__.equals(RegexResult.PROP_GET_START)) && count0_ < (2)) {
                                    s0_ = super.insert(new GetStartIdentityData(getStartIdentity_cache));
                                    s0_.cachedSymbol_ = cachedSymbol__;
                                    s0_.getStartNode_ = s0_.insertAccessor((RegexResultGetStartNode.create()));
                                    MemoryFence.storeStore();
                                    this.getStartIdentity_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getStartIdentity(RegexResult, String, int, String, RegexResultGetStartNode) */;
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return getStartIdentity(arg0Value, arg1Value, arg2Value, s0_.cachedSymbol_, s0_.getStartNode_);
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-exclude getStartEquals(RegexResult, String, int, String, RegexResultGetStartNode) */) {
                        int count1_ = 0;
                        GetStartEqualsData s1_ = this.getStartEquals_cache;
                        if ((state_0 & 0b10) != 0 /* is-state_0 getStartEquals(RegexResult, String, int, String, RegexResultGetStartNode) */) {
                            while (s1_ != null) {
                                if ((arg1Value.equals(s1_.cachedSymbol_))) {
                                    assert (s1_.cachedSymbol_.equals(RegexResult.PROP_GET_START));
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                String cachedSymbol__1 = (arg1Value);
                                // assert (arg1Value.equals(s1_.cachedSymbol_));
                                if ((cachedSymbol__1.equals(RegexResult.PROP_GET_START)) && count1_ < (2)) {
                                    s1_ = super.insert(new GetStartEqualsData(getStartEquals_cache));
                                    s1_.cachedSymbol_ = cachedSymbol__1;
                                    s1_.getStartNode_ = s1_.insertAccessor((RegexResultGetStartNode.create()));
                                    MemoryFence.storeStore();
                                    this.getStartEquals_cache = s1_;
                                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude getStartIdentity(RegexResult, String, int, String, RegexResultGetStartNode) */;
                                    this.getStartIdentity_cache = null;
                                    state_0 = state_0 & 0xfffffffe /* remove-state_0 getStartIdentity(RegexResult, String, int, String, RegexResultGetStartNode) */;
                                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getStartEquals(RegexResult, String, int, String, RegexResultGetStartNode) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return getStartEquals(arg0Value, arg1Value, arg2Value, s1_.cachedSymbol_, s1_.getStartNode_);
                        }
                    }
                    if (((exclude & 0b100)) == 0 /* is-not-exclude getEndIdentity(RegexResult, String, int, String, RegexResultGetEndNode) */) {
                        int count2_ = 0;
                        GetEndIdentityData s2_ = this.getEndIdentity_cache;
                        if ((state_0 & 0b100) != 0 /* is-state_0 getEndIdentity(RegexResult, String, int, String, RegexResultGetEndNode) */) {
                            while (s2_ != null) {
                                if ((arg1Value == s2_.cachedSymbol_)) {
                                    assert (s2_.cachedSymbol_.equals(RegexResult.PROP_GET_END));
                                    break;
                                }
                                s2_ = s2_.next_;
                                count2_++;
                            }
                        }
                        if (s2_ == null) {
                            {
                                String cachedSymbol__2 = (arg1Value);
                                // assert (arg1Value == s2_.cachedSymbol_);
                                if ((cachedSymbol__2.equals(RegexResult.PROP_GET_END)) && count2_ < (2)) {
                                    s2_ = super.insert(new GetEndIdentityData(getEndIdentity_cache));
                                    s2_.cachedSymbol_ = cachedSymbol__2;
                                    s2_.getEndNode_ = s2_.insertAccessor((RegexResultGetEndNodeGen.create()));
                                    MemoryFence.storeStore();
                                    this.getEndIdentity_cache = s2_;
                                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 getEndIdentity(RegexResult, String, int, String, RegexResultGetEndNode) */;
                                }
                            }
                        }
                        if (s2_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return getEndIdentity(arg0Value, arg1Value, arg2Value, s2_.cachedSymbol_, s2_.getEndNode_);
                        }
                    }
                    if (((exclude & 0b1000)) == 0 /* is-not-exclude getEndEquals(RegexResult, String, int, String, RegexResultGetEndNode) */) {
                        int count3_ = 0;
                        GetEndEqualsData s3_ = this.getEndEquals_cache;
                        if ((state_0 & 0b1000) != 0 /* is-state_0 getEndEquals(RegexResult, String, int, String, RegexResultGetEndNode) */) {
                            while (s3_ != null) {
                                if ((arg1Value.equals(s3_.cachedSymbol_))) {
                                    assert (s3_.cachedSymbol_.equals(RegexResult.PROP_GET_END));
                                    break;
                                }
                                s3_ = s3_.next_;
                                count3_++;
                            }
                        }
                        if (s3_ == null) {
                            {
                                String cachedSymbol__3 = (arg1Value);
                                // assert (arg1Value.equals(s3_.cachedSymbol_));
                                if ((cachedSymbol__3.equals(RegexResult.PROP_GET_END)) && count3_ < (2)) {
                                    s3_ = super.insert(new GetEndEqualsData(getEndEquals_cache));
                                    s3_.cachedSymbol_ = cachedSymbol__3;
                                    s3_.getEndNode_ = s3_.insertAccessor((RegexResultGetEndNodeGen.create()));
                                    MemoryFence.storeStore();
                                    this.getEndEquals_cache = s3_;
                                    this.exclude_ = exclude = exclude | 0b100 /* add-exclude getEndIdentity(RegexResult, String, int, String, RegexResultGetEndNode) */;
                                    this.getEndIdentity_cache = null;
                                    state_0 = state_0 & 0xfffffffb /* remove-state_0 getEndIdentity(RegexResult, String, int, String, RegexResultGetEndNode) */;
                                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 getEndEquals(RegexResult, String, int, String, RegexResultGetEndNode) */;
                                }
                            }
                        }
                        if (s3_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return getEndEquals(arg0Value, arg1Value, arg2Value, s3_.cachedSymbol_, s3_.getEndNode_);
                        }
                    }
                    this.invokeGeneric_getStartNode_ = super.insert((RegexResultGetStartNode.create()));
                    this.invokeGeneric_getEndNode_ = super.insert((RegexResultGetEndNodeGen.create()));
                    this.exclude_ = exclude = exclude | 0b1111 /* add-exclude getStartIdentity(RegexResult, String, int, String, RegexResultGetStartNode), getStartEquals(RegexResult, String, int, String, RegexResultGetStartNode), getEndIdentity(RegexResult, String, int, String, RegexResultGetEndNode), getEndEquals(RegexResult, String, int, String, RegexResultGetEndNode) */;
                    this.getStartIdentity_cache = null;
                    this.getStartEquals_cache = null;
                    this.getEndIdentity_cache = null;
                    this.getEndEquals_cache = null;
                    state_0 = state_0 & 0xfffffff0 /* remove-state_0 getStartIdentity(RegexResult, String, int, String, RegexResultGetStartNode), getStartEquals(RegexResult, String, int, String, RegexResultGetStartNode), getEndIdentity(RegexResult, String, int, String, RegexResultGetEndNode), getEndEquals(RegexResult, String, int, String, RegexResultGetEndNode) */;
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 invokeGeneric(RegexResult, String, int, RegexResultGetStartNode, RegexResultGetEndNode) */;
                    lock.unlock();
                    hasLock = false;
                    return InvokeCacheNode.invokeGeneric(arg0Value, arg1Value, arg2Value, this.invokeGeneric_getStartNode_, this.invokeGeneric_getEndNode_);
                } finally {
                    if (oldState_0 != 0) {
                        checkForPolymorphicSpecialize(oldState_0);
                    }
                }
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        private void checkForPolymorphicSpecialize(int oldState_0) {
            if (((oldState_0 & 0b10000) == 0 && (this.state_0_ & 0b10000) != 0)) {
                this.reportPolymorphicSpecialize();
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if (state_0 == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                    GetStartIdentityData s0_ = this.getStartIdentity_cache;
                    GetStartEqualsData s1_ = this.getStartEquals_cache;
                    GetEndIdentityData s2_ = this.getEndIdentity_cache;
                    GetEndEqualsData s3_ = this.getEndEquals_cache;
                    if ((s0_ == null || s0_.next_ == null) && (s1_ == null || s1_.next_ == null) && (s2_ == null || s2_.next_ == null) && (s3_ == null || s3_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static InvokeCacheNode create() {
            return new InvokeCacheNodeGen();
        }

        public static InvokeCacheNode getUncached() {
            return InvokeCacheNodeGen.UNCACHED;
        }

        @GeneratedBy(InvokeCacheNode.class)
        private static final class GetStartIdentityData extends Node {

            @Child GetStartIdentityData next_;
            @CompilationFinal String cachedSymbol_;
            @Child RegexResultGetStartNode getStartNode_;

            GetStartIdentityData(GetStartIdentityData next_) {
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
        @GeneratedBy(InvokeCacheNode.class)
        private static final class GetStartEqualsData extends Node {

            @Child GetStartEqualsData next_;
            @CompilationFinal String cachedSymbol_;
            @Child RegexResultGetStartNode getStartNode_;

            GetStartEqualsData(GetStartEqualsData next_) {
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
        @GeneratedBy(InvokeCacheNode.class)
        private static final class GetEndIdentityData extends Node {

            @Child GetEndIdentityData next_;
            @CompilationFinal String cachedSymbol_;
            @Child RegexResultGetEndNode getEndNode_;

            GetEndIdentityData(GetEndIdentityData next_) {
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
        @GeneratedBy(InvokeCacheNode.class)
        private static final class GetEndEqualsData extends Node {

            @Child GetEndEqualsData next_;
            @CompilationFinal String cachedSymbol_;
            @Child RegexResultGetEndNode getEndNode_;

            GetEndEqualsData(GetEndEqualsData next_) {
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
        @GeneratedBy(InvokeCacheNode.class)
        private static final class Uncached extends InvokeCacheNode {

            @TruffleBoundary
            @Override
            Object execute(RegexResult arg0Value, String arg1Value, int arg2Value) throws UnknownIdentifierException {
                return InvokeCacheNode.invokeGeneric(arg0Value, arg1Value, arg2Value, (RegexResultGetStartNodeGen.getUncached()), (RegexResultGetEndNodeGen.getUncached()));
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
    @GeneratedBy(RegexResultGetEndNode.class)
    static final class RegexResultGetEndNodeGen extends RegexResultGetEndNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private ConditionProfile lazyProfile_;
        @Child private DispatchNode getIndicesCall_;

        private RegexResultGetEndNodeGen() {
        }

        @Override
        int execute(Object arg0Value, int arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doResult(RegexResult, int, ConditionProfile, DispatchNode) */ && arg0Value instanceof RegexResult) {
                RegexResult arg0Value_ = (RegexResult) arg0Value;
                return RegexResultGetEndNode.doResult(arg0Value_, arg1Value, this.lazyProfile_, this.getIndicesCall_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private int executeAndSpecialize(Object arg0Value, int arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arg0Value instanceof RegexResult) {
                    RegexResult arg0Value_ = (RegexResult) arg0Value;
                    this.lazyProfile_ = (ConditionProfile.create());
                    this.getIndicesCall_ = super.insert((DispatchNodeGen.create()));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doResult(RegexResult, int, ConditionProfile, DispatchNode) */;
                    lock.unlock();
                    hasLock = false;
                    return RegexResultGetEndNode.doResult(arg0Value_, arg1Value, this.lazyProfile_, this.getIndicesCall_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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

        public static RegexResultGetEndNode create() {
            return new RegexResultGetEndNodeGen();
        }

        public static RegexResultGetEndNode getUncached() {
            return RegexResultGetEndNodeGen.UNCACHED;
        }

        @GeneratedBy(RegexResultGetEndNode.class)
        private static final class Uncached extends RegexResultGetEndNode {

            @TruffleBoundary
            @Override
            int execute(Object arg0Value, int arg1Value) {
                if (arg0Value instanceof RegexResult) {
                    RegexResult arg0Value_ = (RegexResult) arg0Value;
                    return RegexResultGetEndNode.doResult(arg0Value_, arg1Value, (ConditionProfile.getUncached()), (DispatchNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
    @GeneratedBy(RegexResultGetStartNode.class)
    public static final class RegexResultGetStartNodeGen extends RegexResultGetStartNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private ConditionProfile lazyProfile_;
        @Child private DispatchNode getIndicesCall_;

        private RegexResultGetStartNodeGen() {
        }

        @Override
        public int execute(Object arg0Value, int arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doResult(RegexResult, int, ConditionProfile, DispatchNode) */ && arg0Value instanceof RegexResult) {
                RegexResult arg0Value_ = (RegexResult) arg0Value;
                return RegexResultGetStartNode.doResult(arg0Value_, arg1Value, this.lazyProfile_, this.getIndicesCall_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private int executeAndSpecialize(Object arg0Value, int arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arg0Value instanceof RegexResult) {
                    RegexResult arg0Value_ = (RegexResult) arg0Value;
                    this.lazyProfile_ = (ConditionProfile.create());
                    this.getIndicesCall_ = super.insert((DispatchNodeGen.create()));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doResult(RegexResult, int, ConditionProfile, DispatchNode) */;
                    lock.unlock();
                    hasLock = false;
                    return RegexResultGetStartNode.doResult(arg0Value_, arg1Value, this.lazyProfile_, this.getIndicesCall_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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

        public static RegexResultGetStartNode create() {
            return new RegexResultGetStartNodeGen();
        }

        public static RegexResultGetStartNode getUncached() {
            return RegexResultGetStartNodeGen.UNCACHED;
        }

        @GeneratedBy(RegexResultGetStartNode.class)
        private static final class Uncached extends RegexResultGetStartNode {

            @TruffleBoundary
            @Override
            public int execute(Object arg0Value, int arg1Value) {
                if (arg0Value instanceof RegexResult) {
                    RegexResult arg0Value_ = (RegexResult) arg0Value;
                    return RegexResultGetStartNode.doResult(arg0Value_, arg1Value, (ConditionProfile.getUncached()), (DispatchNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
