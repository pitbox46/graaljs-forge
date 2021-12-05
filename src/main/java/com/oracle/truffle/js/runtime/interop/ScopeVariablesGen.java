// CheckStyle: start generated
package com.oracle.truffle.js.runtime.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.WriteNode;
import com.oracle.truffle.js.runtime.interop.ScopeVariables.IsMemberModifiable;
import com.oracle.truffle.js.runtime.interop.ScopeVariables.IsMemberReadable;
import com.oracle.truffle.js.runtime.interop.ScopeVariables.ReadMember;
import com.oracle.truffle.js.runtime.interop.ScopeVariables.ResolvedSlot;
import com.oracle.truffle.js.runtime.interop.ScopeVariables.WriteMember;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ScopeVariables.class)
final class ScopeVariablesGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(ScopeVariables.class, new InteropLibraryExports());
    }

    private ScopeVariablesGen() {
    }

    @GeneratedBy(ScopeVariables.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, ScopeVariables.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof ScopeVariables;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof ScopeVariables;
            return new Cached(receiver);
        }

        @GeneratedBy(ScopeVariables.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @CompilationFinal private IsMemberReadableCachedData isMemberReadable_cached_cache;
            @CompilationFinal private IsMemberModifiableCachedData isMemberModifiable_cached_cache;
            @Child private ReadMemberCachedData readMember_cached_cache;
            @Child private WriteMemberCachedData writeMember_cached_cache;
            @CompilationFinal private Node acceptsNode__accepts_cachedNode_;
            @CompilationFinal private boolean acceptsNode__accepts_cachedNodeEnter_;

            protected Cached(Object receiver) {
                ScopeVariables castReceiver = ((ScopeVariables) receiver) ;
                this.acceptsNode__accepts_cachedNode_ = (castReceiver.blockOrRoot);
                this.acceptsNode__accepts_cachedNodeEnter_ = (castReceiver.nodeEnter);
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof ScopeVariables) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof ScopeVariables && accepts_(receiver);
            }

            @ExplodeLoop
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                ScopeVariables arg0Value = ((ScopeVariables) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b111) != 0 /* is-state_0 doReadThis(ScopeVariables, String) || doCached(ScopeVariables, String, String, boolean) || doGeneric(ScopeVariables, String) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doReadThis(ScopeVariables, String) */) {
                        if ((ScopeVariables.RECEIVER_MEMBER.equals(arg1Value))) {
                            return IsMemberReadable.doReadThis(arg0Value, arg1Value);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doCached(ScopeVariables, String, String, boolean) */) {
                        IsMemberReadableCachedData s1_ = this.isMemberReadable_cached_cache;
                        while (s1_ != null) {
                            if ((s1_.cachedMember_.equals(arg1Value))) {
                                assert (!(ScopeVariables.RECEIVER_MEMBER.equals(s1_.cachedMember_)));
                                return IsMemberReadable.doCached(arg0Value, arg1Value, s1_.cachedMember_, s1_.cachedResult_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doGeneric(ScopeVariables, String) */) {
                        if ((!(ScopeVariables.RECEIVER_MEMBER.equals(arg1Value)))) {
                            return IsMemberReadable.doGeneric(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberReadableAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberReadableAndSpecialize(ScopeVariables arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if ((ScopeVariables.RECEIVER_MEMBER.equals(arg1Value))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doReadThis(ScopeVariables, String) */;
                        lock.unlock();
                        hasLock = false;
                        return IsMemberReadable.doReadThis(arg0Value, arg1Value);
                    }
                    if (((exclude & 0b1)) == 0 /* is-not-exclude doCached(ScopeVariables, String, String, boolean) */) {
                        int count1_ = 0;
                        IsMemberReadableCachedData s1_ = this.isMemberReadable_cached_cache;
                        if ((state_0 & 0b10) != 0 /* is-state_0 doCached(ScopeVariables, String, String, boolean) */) {
                            while (s1_ != null) {
                                if ((s1_.cachedMember_.equals(arg1Value))) {
                                    assert (!(ScopeVariables.RECEIVER_MEMBER.equals(s1_.cachedMember_)));
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                String cachedMember__ = (arg1Value);
                                // assert (s1_.cachedMember_.equals(arg1Value));
                                if ((!(ScopeVariables.RECEIVER_MEMBER.equals(cachedMember__))) && count1_ < (ScopeVariables.LIMIT)) {
                                    s1_ = new IsMemberReadableCachedData(isMemberReadable_cached_cache);
                                    s1_.cachedMember_ = cachedMember__;
                                    s1_.cachedResult_ = (IsMemberReadable.doGeneric(arg0Value, arg1Value));
                                    MemoryFence.storeStore();
                                    this.isMemberReadable_cached_cache = s1_;
                                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doCached(ScopeVariables, String, String, boolean) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberReadable.doCached(arg0Value, arg1Value, s1_.cachedMember_, s1_.cachedResult_);
                        }
                    }
                    if ((!(ScopeVariables.RECEIVER_MEMBER.equals(arg1Value)))) {
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(ScopeVariables, String, String, boolean) */;
                        this.isMemberReadable_cached_cache = null;
                        state_0 = state_0 & 0xfffffffd /* remove-state_0 doCached(ScopeVariables, String, String, boolean) */;
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doGeneric(ScopeVariables, String) */;
                        lock.unlock();
                        hasLock = false;
                        return IsMemberReadable.doGeneric(arg0Value, arg1Value);
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
                if ((state_0 & 0b111) == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
                        IsMemberReadableCachedData s1_ = this.isMemberReadable_cached_cache;
                        if ((s1_ == null || s1_.next_ == null)) {
                            return NodeCost.MONOMORPHIC;
                        }
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            @ExplodeLoop
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                ScopeVariables arg0Value = ((ScopeVariables) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b111000) != 0 /* is-state_0 doReadThis(ScopeVariables, String) || doCached(ScopeVariables, String, String, boolean) || doGeneric(ScopeVariables, String) */) {
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doReadThis(ScopeVariables, String) */) {
                        if ((ScopeVariables.RECEIVER_MEMBER.equals(arg1Value))) {
                            return IsMemberModifiable.doReadThis(arg0Value, arg1Value);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 doCached(ScopeVariables, String, String, boolean) */) {
                        IsMemberModifiableCachedData s1_ = this.isMemberModifiable_cached_cache;
                        while (s1_ != null) {
                            if ((s1_.cachedMember_.equals(arg1Value))) {
                                assert (!(ScopeVariables.RECEIVER_MEMBER.equals(s1_.cachedMember_)));
                                return IsMemberModifiable.doCached(arg0Value, arg1Value, s1_.cachedMember_, s1_.cachedResult_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 doGeneric(ScopeVariables, String) */) {
                        if ((!(ScopeVariables.RECEIVER_MEMBER.equals(arg1Value)))) {
                            return IsMemberModifiable.doGeneric(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberModifiableAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberModifiableAndSpecialize(ScopeVariables arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if ((ScopeVariables.RECEIVER_MEMBER.equals(arg1Value))) {
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doReadThis(ScopeVariables, String) */;
                        lock.unlock();
                        hasLock = false;
                        return IsMemberModifiable.doReadThis(arg0Value, arg1Value);
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-exclude doCached(ScopeVariables, String, String, boolean) */) {
                        int count1_ = 0;
                        IsMemberModifiableCachedData s1_ = this.isMemberModifiable_cached_cache;
                        if ((state_0 & 0b10000) != 0 /* is-state_0 doCached(ScopeVariables, String, String, boolean) */) {
                            while (s1_ != null) {
                                if ((s1_.cachedMember_.equals(arg1Value))) {
                                    assert (!(ScopeVariables.RECEIVER_MEMBER.equals(s1_.cachedMember_)));
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                String cachedMember__ = (arg1Value);
                                // assert (s1_.cachedMember_.equals(arg1Value));
                                if ((!(ScopeVariables.RECEIVER_MEMBER.equals(cachedMember__))) && count1_ < (ScopeVariables.LIMIT)) {
                                    s1_ = new IsMemberModifiableCachedData(isMemberModifiable_cached_cache);
                                    s1_.cachedMember_ = cachedMember__;
                                    s1_.cachedResult_ = (IsMemberModifiable.doGeneric(arg0Value, arg1Value));
                                    MemoryFence.storeStore();
                                    this.isMemberModifiable_cached_cache = s1_;
                                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doCached(ScopeVariables, String, String, boolean) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberModifiable.doCached(arg0Value, arg1Value, s1_.cachedMember_, s1_.cachedResult_);
                        }
                    }
                    if ((!(ScopeVariables.RECEIVER_MEMBER.equals(arg1Value)))) {
                        this.exclude_ = exclude = exclude | 0b10 /* add-exclude doCached(ScopeVariables, String, String, boolean) */;
                        this.isMemberModifiable_cached_cache = null;
                        state_0 = state_0 & 0xffffffef /* remove-state_0 doCached(ScopeVariables, String, String, boolean) */;
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doGeneric(ScopeVariables, String) */;
                        lock.unlock();
                        hasLock = false;
                        return IsMemberModifiable.doGeneric(arg0Value, arg1Value);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @ExplodeLoop
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                ScopeVariables arg0Value = ((ScopeVariables) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b111000000) != 0 /* is-state_0 doReadThis(ScopeVariables, String) || doCached(ScopeVariables, String, String, ResolvedSlot, JavaScriptNode) || doGeneric(ScopeVariables, String) */) {
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 doReadThis(ScopeVariables, String) */) {
                        if ((ScopeVariables.RECEIVER_MEMBER.equals(arg1Value))) {
                            return ReadMember.doReadThis(arg0Value, arg1Value);
                        }
                    }
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 doCached(ScopeVariables, String, String, ResolvedSlot, JavaScriptNode) */) {
                        ReadMemberCachedData s1_ = this.readMember_cached_cache;
                        while (s1_ != null) {
                            if ((s1_.cachedMember_.equals(arg1Value))) {
                                assert (!(ScopeVariables.RECEIVER_MEMBER.equals(s1_.cachedMember_)));
                                return ReadMember.doCached(arg0Value, arg1Value, s1_.cachedMember_, s1_.resolvedSlot_, s1_.readNode_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100000000) != 0 /* is-state_0 doGeneric(ScopeVariables, String) */) {
                        if ((!(ScopeVariables.RECEIVER_MEMBER.equals(arg1Value)))) {
                            return ReadMember.doGeneric(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberAndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberAndSpecialize(ScopeVariables arg0Value, String arg1Value) throws UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if ((ScopeVariables.RECEIVER_MEMBER.equals(arg1Value))) {
                        this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doReadThis(ScopeVariables, String) */;
                        lock.unlock();
                        hasLock = false;
                        return ReadMember.doReadThis(arg0Value, arg1Value);
                    }
                    if (((exclude & 0b100)) == 0 /* is-not-exclude doCached(ScopeVariables, String, String, ResolvedSlot, JavaScriptNode) */) {
                        int count1_ = 0;
                        ReadMemberCachedData s1_ = this.readMember_cached_cache;
                        if ((state_0 & 0b10000000) != 0 /* is-state_0 doCached(ScopeVariables, String, String, ResolvedSlot, JavaScriptNode) */) {
                            while (s1_ != null) {
                                if ((s1_.cachedMember_.equals(arg1Value))) {
                                    assert (!(ScopeVariables.RECEIVER_MEMBER.equals(s1_.cachedMember_)));
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                String cachedMember__ = (arg1Value);
                                // assert (s1_.cachedMember_.equals(arg1Value));
                                if ((!(ScopeVariables.RECEIVER_MEMBER.equals(cachedMember__))) && count1_ < (ScopeVariables.LIMIT)) {
                                    s1_ = super.insert(new ReadMemberCachedData(readMember_cached_cache));
                                    s1_.cachedMember_ = cachedMember__;
                                    s1_.resolvedSlot_ = (ScopeVariables.findSlot(arg1Value, arg0Value));
                                    s1_.readNode_ = s1_.insertAccessor((ScopeVariables.findReadNode(s1_.resolvedSlot_)));
                                    MemoryFence.storeStore();
                                    this.readMember_cached_cache = s1_;
                                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doCached(ScopeVariables, String, String, ResolvedSlot, JavaScriptNode) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return ReadMember.doCached(arg0Value, arg1Value, s1_.cachedMember_, s1_.resolvedSlot_, s1_.readNode_);
                        }
                    }
                    if ((!(ScopeVariables.RECEIVER_MEMBER.equals(arg1Value)))) {
                        this.exclude_ = exclude = exclude | 0b100 /* add-exclude doCached(ScopeVariables, String, String, ResolvedSlot, JavaScriptNode) */;
                        this.readMember_cached_cache = null;
                        state_0 = state_0 & 0xffffff7f /* remove-state_0 doCached(ScopeVariables, String, String, ResolvedSlot, JavaScriptNode) */;
                        this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doGeneric(ScopeVariables, String) */;
                        lock.unlock();
                        hasLock = false;
                        return ReadMember.doGeneric(arg0Value, arg1Value);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @ExplodeLoop
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                ScopeVariables arg0Value = ((ScopeVariables) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b111000000000) != 0 /* is-state_0 doWriteThis(ScopeVariables, String, Object) || doCached(ScopeVariables, String, Object, String, ResolvedSlot, WriteNode) || doGeneric(ScopeVariables, String, Object) */) {
                    if ((state_0 & 0b1000000000) != 0 /* is-state_0 doWriteThis(ScopeVariables, String, Object) */) {
                        if ((ScopeVariables.RECEIVER_MEMBER.equals(arg1Value))) {
                            WriteMember.doWriteThis(arg0Value, arg1Value, arg2Value);
                            return;
                        }
                    }
                    if ((state_0 & 0b10000000000) != 0 /* is-state_0 doCached(ScopeVariables, String, Object, String, ResolvedSlot, WriteNode) */) {
                        WriteMemberCachedData s1_ = this.writeMember_cached_cache;
                        while (s1_ != null) {
                            if ((s1_.cachedMember_.equals(arg1Value))) {
                                assert (!(ScopeVariables.RECEIVER_MEMBER.equals(s1_.cachedMember_)));
                                WriteMember.doCached(arg0Value, arg1Value, arg2Value, s1_.cachedMember_, s1_.resolvedSlot_, s1_.writeNode_);
                                return;
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state_0 & 0b100000000000) != 0 /* is-state_0 doGeneric(ScopeVariables, String, Object) */) {
                        if ((!(ScopeVariables.RECEIVER_MEMBER.equals(arg1Value)))) {
                            WriteMember.doGeneric(arg0Value, arg1Value, arg2Value);
                            return;
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeMemberAndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeMemberAndSpecialize(ScopeVariables arg0Value, String arg1Value, Object arg2Value) throws UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if ((ScopeVariables.RECEIVER_MEMBER.equals(arg1Value))) {
                        this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doWriteThis(ScopeVariables, String, Object) */;
                        lock.unlock();
                        hasLock = false;
                        WriteMember.doWriteThis(arg0Value, arg1Value, arg2Value);
                        return;
                    }
                    if (((exclude & 0b1000)) == 0 /* is-not-exclude doCached(ScopeVariables, String, Object, String, ResolvedSlot, WriteNode) */) {
                        int count1_ = 0;
                        WriteMemberCachedData s1_ = this.writeMember_cached_cache;
                        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doCached(ScopeVariables, String, Object, String, ResolvedSlot, WriteNode) */) {
                            while (s1_ != null) {
                                if ((s1_.cachedMember_.equals(arg1Value))) {
                                    assert (!(ScopeVariables.RECEIVER_MEMBER.equals(s1_.cachedMember_)));
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                String cachedMember__ = (arg1Value);
                                // assert (s1_.cachedMember_.equals(arg1Value));
                                if ((!(ScopeVariables.RECEIVER_MEMBER.equals(cachedMember__))) && count1_ < (ScopeVariables.LIMIT)) {
                                    s1_ = super.insert(new WriteMemberCachedData(writeMember_cached_cache));
                                    s1_.cachedMember_ = cachedMember__;
                                    s1_.resolvedSlot_ = (ScopeVariables.findSlot(arg1Value, arg0Value));
                                    WriteNode writeNode___ = (ScopeVariables.findWriteNode(s1_.resolvedSlot_));
                                    if (writeNode___ instanceof Node) {
                                        s1_.insertAccessor((Node) writeNode___);
                                    }
                                    s1_.writeNode_ = writeNode___;
                                    MemoryFence.storeStore();
                                    this.writeMember_cached_cache = s1_;
                                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doCached(ScopeVariables, String, Object, String, ResolvedSlot, WriteNode) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            WriteMember.doCached(arg0Value, arg1Value, arg2Value, s1_.cachedMember_, s1_.resolvedSlot_, s1_.writeNode_);
                            return;
                        }
                    }
                    if ((!(ScopeVariables.RECEIVER_MEMBER.equals(arg1Value)))) {
                        this.exclude_ = exclude = exclude | 0b1000 /* add-exclude doCached(ScopeVariables, String, Object, String, ResolvedSlot, WriteNode) */;
                        this.writeMember_cached_cache = null;
                        state_0 = state_0 & 0xfffffbff /* remove-state_0 doCached(ScopeVariables, String, Object, String, ResolvedSlot, WriteNode) */;
                        this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doGeneric(ScopeVariables, String, Object) */;
                        lock.unlock();
                        hasLock = false;
                        WriteMember.doGeneric(arg0Value, arg1Value, arg2Value);
                        return;
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            private boolean accepts_(Object arg0Value_) {
                ScopeVariables arg0Value = ((ScopeVariables) arg0Value_);
                return arg0Value.accepts(this.acceptsNode__accepts_cachedNode_, this.acceptsNode__accepts_cachedNodeEnter_);
            }

            @Override
            public boolean isScope(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((ScopeVariables) receiver)).isScope();
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((ScopeVariables) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((ScopeVariables) receiver)).getLanguage();
            }

            @Override
            public boolean hasScopeParent(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((ScopeVariables) receiver)).hasScopeParent();
            }

            @Override
            public Object getScopeParent(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((ScopeVariables) receiver)).getScopeParent();
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((ScopeVariables) receiver)).hasMembers();
            }

            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((ScopeVariables) receiver)).getMembers(includeInternal);
            }

            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((ScopeVariables) receiver)).isMemberInsertable(member);
            }

            @Override
            public boolean hasSourceLocation(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((ScopeVariables) receiver)).hasSourceLocation();
            }

            @Override
            public SourceSection getSourceLocation(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((ScopeVariables) receiver)).getSourceLocation();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((ScopeVariables) receiver)).toDisplayString(allowSideEffects);
            }

            @GeneratedBy(ScopeVariables.class)
            private static final class IsMemberReadableCachedData {

                @CompilationFinal IsMemberReadableCachedData next_;
                @CompilationFinal String cachedMember_;
                @CompilationFinal boolean cachedResult_;

                IsMemberReadableCachedData(IsMemberReadableCachedData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(ScopeVariables.class)
            private static final class IsMemberModifiableCachedData {

                @CompilationFinal IsMemberModifiableCachedData next_;
                @CompilationFinal String cachedMember_;
                @CompilationFinal boolean cachedResult_;

                IsMemberModifiableCachedData(IsMemberModifiableCachedData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(ScopeVariables.class)
            private static final class ReadMemberCachedData extends Node {

                @Child ReadMemberCachedData next_;
                @CompilationFinal String cachedMember_;
                @CompilationFinal ResolvedSlot resolvedSlot_;
                @Child JavaScriptNode readNode_;

                ReadMemberCachedData(ReadMemberCachedData next_) {
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
            @GeneratedBy(ScopeVariables.class)
            private static final class WriteMemberCachedData extends Node {

                @Child WriteMemberCachedData next_;
                @CompilationFinal String cachedMember_;
                @CompilationFinal ResolvedSlot resolvedSlot_;
                @Child WriteNode writeNode_;

                WriteMemberCachedData(WriteMemberCachedData next_) {
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
        @GeneratedBy(ScopeVariables.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof ScopeVariables) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof ScopeVariables && accepts_(receiver);
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
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                ScopeVariables arg0Value = ((ScopeVariables) arg0Value_);
                if ((ScopeVariables.RECEIVER_MEMBER.equals(arg1Value))) {
                    return IsMemberReadable.doReadThis(arg0Value, arg1Value);
                }
                if ((!(ScopeVariables.RECEIVER_MEMBER.equals(arg1Value)))) {
                    return IsMemberReadable.doGeneric(arg0Value, arg1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                ScopeVariables arg0Value = ((ScopeVariables) arg0Value_);
                if ((ScopeVariables.RECEIVER_MEMBER.equals(arg1Value))) {
                    return IsMemberModifiable.doReadThis(arg0Value, arg1Value);
                }
                if ((!(ScopeVariables.RECEIVER_MEMBER.equals(arg1Value)))) {
                    return IsMemberModifiable.doGeneric(arg0Value, arg1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                ScopeVariables arg0Value = ((ScopeVariables) arg0Value_);
                if ((ScopeVariables.RECEIVER_MEMBER.equals(arg1Value))) {
                    return ReadMember.doReadThis(arg0Value, arg1Value);
                }
                if ((!(ScopeVariables.RECEIVER_MEMBER.equals(arg1Value)))) {
                    return ReadMember.doGeneric(arg0Value, arg1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                ScopeVariables arg0Value = ((ScopeVariables) arg0Value_);
                if ((ScopeVariables.RECEIVER_MEMBER.equals(arg1Value))) {
                    WriteMember.doWriteThis(arg0Value, arg1Value, arg2Value);
                    return;
                }
                if ((!(ScopeVariables.RECEIVER_MEMBER.equals(arg1Value)))) {
                    WriteMember.doGeneric(arg0Value, arg1Value, arg2Value);
                    return;
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
            }

            @TruffleBoundary
            @Override
            public boolean isScope(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ScopeVariables) receiver) .isScope();
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ScopeVariables) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ScopeVariables) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public boolean hasScopeParent(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ScopeVariables) receiver) .hasScopeParent();
            }

            @TruffleBoundary
            @Override
            public Object getScopeParent(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ScopeVariables) receiver) .getScopeParent();
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ScopeVariables) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ScopeVariables) receiver) .getMembers(includeInternal);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ScopeVariables) receiver) .isMemberInsertable(member);
            }

            @TruffleBoundary
            @Override
            public boolean hasSourceLocation(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ScopeVariables) receiver) .hasSourceLocation();
            }

            @TruffleBoundary
            @Override
            public SourceSection getSourceLocation(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ScopeVariables) receiver) .getSourceLocation();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ScopeVariables) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            private static boolean accepts_(Object arg0Value_) {
                ScopeVariables arg0Value = ((ScopeVariables) arg0Value_);
                return arg0Value.accepts((arg0Value.blockOrRoot), (arg0Value.nodeEnter));
            }

        }
    }
}
