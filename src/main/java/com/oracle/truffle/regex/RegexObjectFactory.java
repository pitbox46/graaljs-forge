// CheckStyle: start generated
package com.oracle.truffle.regex;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.regex.RegexObject.ExecCompiledRegexNode;
import com.oracle.truffle.regex.RegexObject.InvokeCacheNode;
import com.oracle.truffle.regex.runtime.nodes.ExpectByteArrayHostObjectNode;
import com.oracle.truffle.regex.runtime.nodes.ExpectByteArrayHostObjectNodeGen;
import com.oracle.truffle.regex.runtime.nodes.ExpectStringOrTruffleObjectNode;
import com.oracle.truffle.regex.runtime.nodes.ExpectStringOrTruffleObjectNodeGen;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RegexObject.class)
public final class RegexObjectFactory {

    @GeneratedBy(InvokeCacheNode.class)
    static final class InvokeCacheNodeGen extends InvokeCacheNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ExecIdentityData execIdentity_cache;
        @Child private ExecEqualsData execEquals_cache;
        @Child private ExecBytesIdentityData execBytesIdentity_cache;
        @Child private ExecBytesEqualsData execBytesEquals_cache;
        @Child private InvokeGenericData invokeGeneric_cache;

        private InvokeCacheNodeGen() {
        }

        @ExplodeLoop
        @Override
        Object execute(String arg0Value, CallTarget arg1Value, Object arg2Value, int arg3Value) throws UnsupportedMessageException, ArityException, UnsupportedTypeException, UnknownIdentifierException {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 execIdentity(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode) || execEquals(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode) || execBytesIdentity(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) || execBytesEquals(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) || invokeGeneric(String, CallTarget, Object, int, ExpectStringOrTruffleObjectNode, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 execIdentity(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode) */) {
                    ExecIdentityData s0_ = this.execIdentity_cache;
                    while (s0_ != null) {
                        if ((arg0Value == s0_.cachedSymbol_)) {
                            assert (s0_.cachedSymbol_.equals(RegexObject.PROP_EXEC));
                            return execIdentity(arg0Value, arg1Value, arg2Value, arg3Value, s0_.cachedSymbol_, s0_.expectStringOrTruffleObjectNode_, s0_.execNode_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 execEquals(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode) */) {
                    ExecEqualsData s1_ = this.execEquals_cache;
                    while (s1_ != null) {
                        if ((arg0Value.equals(s1_.cachedSymbol_))) {
                            assert (s1_.cachedSymbol_.equals(RegexObject.PROP_EXEC));
                            return execEquals(arg0Value, arg1Value, arg2Value, arg3Value, s1_.cachedSymbol_, s1_.expectStringOrTruffleObjectNode_, s1_.execNode_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 execBytesIdentity(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */) {
                    ExecBytesIdentityData s2_ = this.execBytesIdentity_cache;
                    while (s2_ != null) {
                        if ((arg0Value == s2_.cachedSymbol_)) {
                            assert (s2_.cachedSymbol_.equals(RegexObject.PROP_EXEC_BYTES));
                            return execBytesIdentity(arg0Value, arg1Value, arg2Value, arg3Value, s2_.cachedSymbol_, s2_.expectByteArrayHostObjectNode_, s2_.execNode_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 execBytesEquals(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */) {
                    ExecBytesEqualsData s3_ = this.execBytesEquals_cache;
                    while (s3_ != null) {
                        if ((arg0Value.equals(s3_.cachedSymbol_))) {
                            assert (s3_.cachedSymbol_.equals(RegexObject.PROP_EXEC_BYTES));
                            return execBytesEquals(arg0Value, arg1Value, arg2Value, arg3Value, s3_.cachedSymbol_, s3_.expectByteArrayHostObjectNode_, s3_.execNode_);
                        }
                        s3_ = s3_.next_;
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 invokeGeneric(String, CallTarget, Object, int, ExpectStringOrTruffleObjectNode, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */) {
                    InvokeGenericData s4_ = this.invokeGeneric_cache;
                    if (s4_ != null) {
                        return InvokeCacheNode.invokeGeneric(arg0Value, arg1Value, arg2Value, arg3Value, s4_.expectStringOrTruffleObjectNode_, s4_.expectByteArrayHostObjectNode_, s4_.execNode_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
        }

        private Object executeAndSpecialize(String arg0Value, CallTarget arg1Value, Object arg2Value, int arg3Value) throws UnsupportedMessageException, ArityException, UnsupportedTypeException, UnknownIdentifierException {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                int oldState_0 = state_0;
                try {
                    if (((exclude & 0b1)) == 0 /* is-not-exclude execIdentity(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode) */) {
                        int count0_ = 0;
                        ExecIdentityData s0_ = this.execIdentity_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 execIdentity(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode) */) {
                            while (s0_ != null) {
                                if ((arg0Value == s0_.cachedSymbol_)) {
                                    assert (s0_.cachedSymbol_.equals(RegexObject.PROP_EXEC));
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                String cachedSymbol__ = (arg0Value);
                                // assert (arg0Value == s0_.cachedSymbol_);
                                if ((cachedSymbol__.equals(RegexObject.PROP_EXEC)) && count0_ < (2)) {
                                    s0_ = super.insert(new ExecIdentityData(execIdentity_cache));
                                    s0_.cachedSymbol_ = cachedSymbol__;
                                    s0_.expectStringOrTruffleObjectNode_ = s0_.insertAccessor((ExpectStringOrTruffleObjectNode.create()));
                                    s0_.execNode_ = s0_.insertAccessor((ExecCompiledRegexNodeGen.create()));
                                    MemoryFence.storeStore();
                                    this.execIdentity_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 execIdentity(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode) */;
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return execIdentity(arg0Value, arg1Value, arg2Value, arg3Value, s0_.cachedSymbol_, s0_.expectStringOrTruffleObjectNode_, s0_.execNode_);
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-exclude execEquals(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode) */) {
                        int count1_ = 0;
                        ExecEqualsData s1_ = this.execEquals_cache;
                        if ((state_0 & 0b10) != 0 /* is-state_0 execEquals(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode) */) {
                            while (s1_ != null) {
                                if ((arg0Value.equals(s1_.cachedSymbol_))) {
                                    assert (s1_.cachedSymbol_.equals(RegexObject.PROP_EXEC));
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                String cachedSymbol__1 = (arg0Value);
                                // assert (arg0Value.equals(s1_.cachedSymbol_));
                                if ((cachedSymbol__1.equals(RegexObject.PROP_EXEC)) && count1_ < (2)) {
                                    s1_ = super.insert(new ExecEqualsData(execEquals_cache));
                                    s1_.cachedSymbol_ = cachedSymbol__1;
                                    s1_.expectStringOrTruffleObjectNode_ = s1_.insertAccessor((ExpectStringOrTruffleObjectNode.create()));
                                    s1_.execNode_ = s1_.insertAccessor((ExecCompiledRegexNodeGen.create()));
                                    MemoryFence.storeStore();
                                    this.execEquals_cache = s1_;
                                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude execIdentity(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode) */;
                                    this.execIdentity_cache = null;
                                    state_0 = state_0 & 0xfffffffe /* remove-state_0 execIdentity(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode) */;
                                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 execEquals(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return execEquals(arg0Value, arg1Value, arg2Value, arg3Value, s1_.cachedSymbol_, s1_.expectStringOrTruffleObjectNode_, s1_.execNode_);
                        }
                    }
                    if (((exclude & 0b100)) == 0 /* is-not-exclude execBytesIdentity(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */) {
                        int count2_ = 0;
                        ExecBytesIdentityData s2_ = this.execBytesIdentity_cache;
                        if ((state_0 & 0b100) != 0 /* is-state_0 execBytesIdentity(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */) {
                            while (s2_ != null) {
                                if ((arg0Value == s2_.cachedSymbol_)) {
                                    assert (s2_.cachedSymbol_.equals(RegexObject.PROP_EXEC_BYTES));
                                    break;
                                }
                                s2_ = s2_.next_;
                                count2_++;
                            }
                        }
                        if (s2_ == null) {
                            {
                                String cachedSymbol__2 = (arg0Value);
                                // assert (arg0Value == s2_.cachedSymbol_);
                                if ((cachedSymbol__2.equals(RegexObject.PROP_EXEC_BYTES)) && count2_ < (2)) {
                                    s2_ = super.insert(new ExecBytesIdentityData(execBytesIdentity_cache));
                                    s2_.cachedSymbol_ = cachedSymbol__2;
                                    s2_.expectByteArrayHostObjectNode_ = s2_.insertAccessor((ExpectByteArrayHostObjectNodeGen.create()));
                                    s2_.execNode_ = s2_.insertAccessor((ExecCompiledRegexNodeGen.create()));
                                    MemoryFence.storeStore();
                                    this.execBytesIdentity_cache = s2_;
                                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 execBytesIdentity(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */;
                                }
                            }
                        }
                        if (s2_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return execBytesIdentity(arg0Value, arg1Value, arg2Value, arg3Value, s2_.cachedSymbol_, s2_.expectByteArrayHostObjectNode_, s2_.execNode_);
                        }
                    }
                    if (((exclude & 0b1000)) == 0 /* is-not-exclude execBytesEquals(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */) {
                        int count3_ = 0;
                        ExecBytesEqualsData s3_ = this.execBytesEquals_cache;
                        if ((state_0 & 0b1000) != 0 /* is-state_0 execBytesEquals(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */) {
                            while (s3_ != null) {
                                if ((arg0Value.equals(s3_.cachedSymbol_))) {
                                    assert (s3_.cachedSymbol_.equals(RegexObject.PROP_EXEC_BYTES));
                                    break;
                                }
                                s3_ = s3_.next_;
                                count3_++;
                            }
                        }
                        if (s3_ == null) {
                            {
                                String cachedSymbol__3 = (arg0Value);
                                // assert (arg0Value.equals(s3_.cachedSymbol_));
                                if ((cachedSymbol__3.equals(RegexObject.PROP_EXEC_BYTES)) && count3_ < (2)) {
                                    s3_ = super.insert(new ExecBytesEqualsData(execBytesEquals_cache));
                                    s3_.cachedSymbol_ = cachedSymbol__3;
                                    s3_.expectByteArrayHostObjectNode_ = s3_.insertAccessor((ExpectByteArrayHostObjectNodeGen.create()));
                                    s3_.execNode_ = s3_.insertAccessor((ExecCompiledRegexNodeGen.create()));
                                    MemoryFence.storeStore();
                                    this.execBytesEquals_cache = s3_;
                                    this.exclude_ = exclude = exclude | 0b100 /* add-exclude execBytesIdentity(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */;
                                    this.execBytesIdentity_cache = null;
                                    state_0 = state_0 & 0xfffffffb /* remove-state_0 execBytesIdentity(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */;
                                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 execBytesEquals(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */;
                                }
                            }
                        }
                        if (s3_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return execBytesEquals(arg0Value, arg1Value, arg2Value, arg3Value, s3_.cachedSymbol_, s3_.expectByteArrayHostObjectNode_, s3_.execNode_);
                        }
                    }
                    InvokeGenericData s4_ = super.insert(new InvokeGenericData());
                    s4_.expectStringOrTruffleObjectNode_ = s4_.insertAccessor((ExpectStringOrTruffleObjectNode.create()));
                    s4_.expectByteArrayHostObjectNode_ = s4_.insertAccessor((ExpectByteArrayHostObjectNodeGen.create()));
                    s4_.execNode_ = s4_.insertAccessor((ExecCompiledRegexNodeGen.create()));
                    MemoryFence.storeStore();
                    this.invokeGeneric_cache = s4_;
                    this.exclude_ = exclude = exclude | 0b1111 /* add-exclude execIdentity(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode), execEquals(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode), execBytesIdentity(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode), execBytesEquals(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */;
                    this.execIdentity_cache = null;
                    this.execEquals_cache = null;
                    this.execBytesIdentity_cache = null;
                    this.execBytesEquals_cache = null;
                    state_0 = state_0 & 0xfffffff0 /* remove-state_0 execIdentity(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode), execEquals(String, CallTarget, Object, int, String, ExpectStringOrTruffleObjectNode, ExecCompiledRegexNode), execBytesIdentity(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode), execBytesEquals(String, CallTarget, Object, int, String, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */;
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 invokeGeneric(String, CallTarget, Object, int, ExpectStringOrTruffleObjectNode, ExpectByteArrayHostObjectNode, ExecCompiledRegexNode) */;
                    lock.unlock();
                    hasLock = false;
                    return InvokeCacheNode.invokeGeneric(arg0Value, arg1Value, arg2Value, arg3Value, s4_.expectStringOrTruffleObjectNode_, s4_.expectByteArrayHostObjectNode_, s4_.execNode_);
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
                    ExecIdentityData s0_ = this.execIdentity_cache;
                    ExecEqualsData s1_ = this.execEquals_cache;
                    ExecBytesIdentityData s2_ = this.execBytesIdentity_cache;
                    ExecBytesEqualsData s3_ = this.execBytesEquals_cache;
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
        private static final class ExecIdentityData extends Node {

            @Child ExecIdentityData next_;
            @CompilationFinal String cachedSymbol_;
            @Child ExpectStringOrTruffleObjectNode expectStringOrTruffleObjectNode_;
            @Child ExecCompiledRegexNode execNode_;

            ExecIdentityData(ExecIdentityData next_) {
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
        private static final class ExecEqualsData extends Node {

            @Child ExecEqualsData next_;
            @CompilationFinal String cachedSymbol_;
            @Child ExpectStringOrTruffleObjectNode expectStringOrTruffleObjectNode_;
            @Child ExecCompiledRegexNode execNode_;

            ExecEqualsData(ExecEqualsData next_) {
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
        private static final class ExecBytesIdentityData extends Node {

            @Child ExecBytesIdentityData next_;
            @CompilationFinal String cachedSymbol_;
            @Child ExpectByteArrayHostObjectNode expectByteArrayHostObjectNode_;
            @Child ExecCompiledRegexNode execNode_;

            ExecBytesIdentityData(ExecBytesIdentityData next_) {
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
        private static final class ExecBytesEqualsData extends Node {

            @Child ExecBytesEqualsData next_;
            @CompilationFinal String cachedSymbol_;
            @Child ExpectByteArrayHostObjectNode expectByteArrayHostObjectNode_;
            @Child ExecCompiledRegexNode execNode_;

            ExecBytesEqualsData(ExecBytesEqualsData next_) {
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
        private static final class InvokeGenericData extends Node {

            @Child ExpectStringOrTruffleObjectNode expectStringOrTruffleObjectNode_;
            @Child ExpectByteArrayHostObjectNode expectByteArrayHostObjectNode_;
            @Child ExecCompiledRegexNode execNode_;

            InvokeGenericData() {
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
            Object execute(String arg0Value, CallTarget arg1Value, Object arg2Value, int arg3Value) throws UnsupportedMessageException, ArityException, UnsupportedTypeException, UnknownIdentifierException {
                return InvokeCacheNode.invokeGeneric(arg0Value, arg1Value, arg2Value, arg3Value, (ExpectStringOrTruffleObjectNodeGen.getUncached()), (ExpectByteArrayHostObjectNodeGen.getUncached()), (ExecCompiledRegexNodeGen.getUncached()));
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
    @GeneratedBy(ExecCompiledRegexNode.class)
    static final class ExecCompiledRegexNodeGen extends ExecCompiledRegexNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ExecuteDirectCallData executeDirectCall_cache;
        @Child private IndirectCallNode executeIndirectCall_indirectCallNode_;

        private ExecCompiledRegexNodeGen() {
        }

        @ExplodeLoop
        @Override
        Object execute(CallTarget arg0Value, Object arg1Value, int arg2Value) throws UnsupportedMessageException, ArityException, UnsupportedTypeException {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 executeDirectCall(CallTarget, Object, int, CallTarget, DirectCallNode) || executeIndirectCall(CallTarget, Object, int, IndirectCallNode) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 executeDirectCall(CallTarget, Object, int, CallTarget, DirectCallNode) */) {
                    ExecuteDirectCallData s0_ = this.executeDirectCall_cache;
                    while (s0_ != null) {
                        if ((arg0Value == s0_.cachedCallTarget_)) {
                            return ExecCompiledRegexNode.executeDirectCall(arg0Value, arg1Value, arg2Value, s0_.cachedCallTarget_, s0_.directCallNode_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 executeIndirectCall(CallTarget, Object, int, IndirectCallNode) */) {
                    return ExecCompiledRegexNode.executeIndirectCall(arg0Value, arg1Value, arg2Value, this.executeIndirectCall_indirectCallNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private Object executeAndSpecialize(CallTarget arg0Value, Object arg1Value, int arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                int oldState_0 = state_0;
                try {
                    if ((exclude) == 0 /* is-not-exclude executeDirectCall(CallTarget, Object, int, CallTarget, DirectCallNode) */) {
                        int count0_ = 0;
                        ExecuteDirectCallData s0_ = this.executeDirectCall_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 executeDirectCall(CallTarget, Object, int, CallTarget, DirectCallNode) */) {
                            while (s0_ != null) {
                                if ((arg0Value == s0_.cachedCallTarget_)) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            // assert (arg0Value == s0_.cachedCallTarget_);
                            if (count0_ < (4)) {
                                s0_ = super.insert(new ExecuteDirectCallData(executeDirectCall_cache));
                                s0_.cachedCallTarget_ = (arg0Value);
                                s0_.directCallNode_ = s0_.insertAccessor((DirectCallNode.create(s0_.cachedCallTarget_)));
                                MemoryFence.storeStore();
                                this.executeDirectCall_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 executeDirectCall(CallTarget, Object, int, CallTarget, DirectCallNode) */;
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return ExecCompiledRegexNode.executeDirectCall(arg0Value, arg1Value, arg2Value, s0_.cachedCallTarget_, s0_.directCallNode_);
                        }
                    }
                    this.executeIndirectCall_indirectCallNode_ = super.insert((IndirectCallNode.create()));
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude executeDirectCall(CallTarget, Object, int, CallTarget, DirectCallNode) */;
                    this.executeDirectCall_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 executeDirectCall(CallTarget, Object, int, CallTarget, DirectCallNode) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 executeIndirectCall(CallTarget, Object, int, IndirectCallNode) */;
                    lock.unlock();
                    hasLock = false;
                    return ExecCompiledRegexNode.executeIndirectCall(arg0Value, arg1Value, arg2Value, this.executeIndirectCall_indirectCallNode_);
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
            if (((oldState_0 & 0b10) == 0 && (this.state_0_ & 0b10) != 0)) {
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
                    ExecuteDirectCallData s0_ = this.executeDirectCall_cache;
                    if ((s0_ == null || s0_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static ExecCompiledRegexNode create() {
            return new ExecCompiledRegexNodeGen();
        }

        public static ExecCompiledRegexNode getUncached() {
            return ExecCompiledRegexNodeGen.UNCACHED;
        }

        @GeneratedBy(ExecCompiledRegexNode.class)
        private static final class ExecuteDirectCallData extends Node {

            @Child ExecuteDirectCallData next_;
            @CompilationFinal CallTarget cachedCallTarget_;
            @Child DirectCallNode directCallNode_;

            ExecuteDirectCallData(ExecuteDirectCallData next_) {
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
        @GeneratedBy(ExecCompiledRegexNode.class)
        private static final class Uncached extends ExecCompiledRegexNode {

            @TruffleBoundary
            @Override
            Object execute(CallTarget arg0Value, Object arg1Value, int arg2Value) throws UnsupportedMessageException, ArityException, UnsupportedTypeException {
                return ExecCompiledRegexNode.executeIndirectCall(arg0Value, arg1Value, arg2Value, (IndirectCallNode.getUncached()));
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
