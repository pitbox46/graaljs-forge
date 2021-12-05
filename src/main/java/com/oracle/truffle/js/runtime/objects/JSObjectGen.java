// CheckStyle: start generated
package com.oracle.truffle.js.runtime.objects;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.nodes.access.WriteElementNode;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.nodes.interop.JSInteropGetIteratorNode;
import com.oracle.truffle.js.nodes.interop.JSInteropGetIteratorNodeGen;
import com.oracle.truffle.js.nodes.interop.JSInteropInvokeNode;
import com.oracle.truffle.js.nodes.interop.JSInteropInvokeNodeGen;
import com.oracle.truffle.js.nodes.interop.KeyInfoNode;
import com.oracle.truffle.js.nodes.interop.KeyInfoNodeGen;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import com.oracle.truffle.js.runtime.objects.JSObject.GetMembers;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSObject.class)
public final class JSObjectGen {

    static  {
        LibraryExport.register(JSObject.class, new InteropLibraryExports());
    }

    private JSObjectGen() {
    }

    @GeneratedBy(JSObject.class)
    public static class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, JSObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JSObject;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JSObject;
            return new Cached(receiver);
        }

        @GeneratedBy(JSObject.class)
        public static class Cached extends JSDynamicObjectGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private KeyInfoNode keyInfo;
            @Child private JSInteropGetIteratorNode getIterator;
            @CompilationFinal private GetMembersNonArrayCachedData getMembers_nonArrayCached_cache;
            @Child private ReadElementNode readMemberNode__readMember_readNode_;
            @CompilationFinal private boolean readMemberNode__readMember_bindMemberFunctions_;
            @Child private ExportValueNode readMemberNode__readMember_exportNode_;
            @Child private ImportValueNode writeMemberNode__writeMember_castValueNode_;
            @Child private WriteElementNode writeMemberNode__writeMember_writeNode_;
            @Child private JSInteropInvokeNode invokeMemberNode__invokeMember_callNode_;
            @Child private ExportValueNode invokeMemberNode__invokeMember_exportNode_;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @ExplodeLoop
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) != 0 /* is-state_0 nonArrayCached(JSObject, boolean, JSClass) || nonArrayUncached(JSObject, boolean) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 nonArrayCached(JSObject, boolean, JSClass) */) {
                        GetMembersNonArrayCachedData s0_ = this.getMembers_nonArrayCached_cache;
                        while (s0_ != null) {
                            assert (s0_.cachedJSClass_ != null);
                            if ((JSObject.getJSClass(arg0Value) == s0_.cachedJSClass_)) {
                                return GetMembers.nonArrayCached(arg0Value, arg1Value, s0_.cachedJSClass_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 nonArrayUncached(JSObject, boolean) */) {
                        return GetMembers.nonArrayUncached(arg0Value, arg1Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getMembersAndSpecialize(arg0Value, arg1Value);
            }

            private Object getMembersAndSpecialize(JSObject arg0Value, boolean arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if ((exclude) == 0 /* is-not-exclude nonArrayCached(JSObject, boolean, JSClass) */) {
                        int count0_ = 0;
                        GetMembersNonArrayCachedData s0_ = this.getMembers_nonArrayCached_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 nonArrayCached(JSObject, boolean, JSClass) */) {
                            while (s0_ != null) {
                                assert (s0_.cachedJSClass_ != null);
                                if ((JSObject.getJSClass(arg0Value) == s0_.cachedJSClass_)) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                JSClass cachedJSClass__ = (JSObject.getJSClass(arg0Value));
                                if ((cachedJSClass__ != null) && (JSObject.getJSClass(arg0Value) == cachedJSClass__) && count0_ < (3)) {
                                    s0_ = new GetMembersNonArrayCachedData(getMembers_nonArrayCached_cache);
                                    s0_.cachedJSClass_ = cachedJSClass__;
                                    MemoryFence.storeStore();
                                    this.getMembers_nonArrayCached_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 nonArrayCached(JSObject, boolean, JSClass) */;
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetMembers.nonArrayCached(arg0Value, arg1Value, s0_.cachedJSClass_);
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude nonArrayCached(JSObject, boolean, JSClass) */;
                    this.getMembers_nonArrayCached_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 nonArrayCached(JSObject, boolean, JSClass) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 nonArrayUncached(JSObject, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return GetMembers.nonArrayUncached(arg0Value, arg1Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public NodeCost getCost() {
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    if (((state_0 & 0b11) & ((state_0 & 0b11) - 1)) == 0 /* is-single-state_0  */) {
                        GetMembersNonArrayCachedData s0_ = this.getMembers_nonArrayCached_cache;
                        if ((s0_ == null || s0_.next_ == null)) {
                            return NodeCost.MONOMORPHIC;
                        }
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSObject) receiver)).hasMembers();
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100) != 0 /* is-state_0 readMember(JSObject, String, InteropLibrary, ReadElementNode, boolean, ExportValueNode) */) {
                    {
                        InteropLibrary readMemberNode__readMember_self__ = (this);
                        return arg0Value.readMember(arg1Value, readMemberNode__readMember_self__, this.readMemberNode__readMember_readNode_, this.readMemberNode__readMember_bindMemberFunctions_, this.readMemberNode__readMember_exportNode_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberNode_AndSpecialize(JSObject arg0Value, String arg1Value) throws UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary readMemberNode__readMember_self__ = null;
                        readMemberNode__readMember_self__ = (this);
                        this.readMemberNode__readMember_readNode_ = super.insert((ReadElementNode.create(JSObject.language(readMemberNode__readMember_self__).getJSContext())));
                        this.readMemberNode__readMember_bindMemberFunctions_ = (JSObject.language(readMemberNode__readMember_self__).bindMemberFunctions());
                        this.readMemberNode__readMember_exportNode_ = super.insert((ExportValueNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 readMember(JSObject, String, InteropLibrary, ReadElementNode, boolean, ExportValueNode) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.readMember(arg1Value, readMemberNode__readMember_self__, this.readMemberNode__readMember_readNode_, this.readMemberNode__readMember_bindMemberFunctions_, this.readMemberNode__readMember_exportNode_);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 isMemberReadable(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.isMemberReadable(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberReadableNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyInfo = super.insert(this.keyInfo == null ? ((KeyInfoNodeGen.create())) : this.keyInfo);
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 isMemberReadable(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberReadable(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000) != 0 /* is-state_0 writeMember(JSObject, String, Object, KeyInfoNode, ImportValueNode, WriteElementNode) */) {
                    arg0Value.writeMember(arg1Value, arg2Value, this.keyInfo, this.writeMemberNode__writeMember_castValueNode_, this.writeMemberNode__writeMember_writeNode_);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeMemberNode_AndSpecialize(JSObject arg0Value, String arg1Value, Object arg2Value) throws UnknownIdentifierException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyInfo = super.insert(this.keyInfo == null ? ((KeyInfoNodeGen.create())) : this.keyInfo);
                    this.writeMemberNode__writeMember_castValueNode_ = super.insert((ImportValueNode.create()));
                    this.writeMemberNode__writeMember_writeNode_ = super.insert((WriteElementNode.createCachedInterop()));
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 writeMember(JSObject, String, Object, KeyInfoNode, ImportValueNode, WriteElementNode) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeMember(arg1Value, arg2Value, this.keyInfo, this.writeMemberNode__writeMember_castValueNode_, this.writeMemberNode__writeMember_writeNode_);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 isMemberModifiable(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.isMemberModifiable(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberModifiableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberModifiableNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyInfo = super.insert(this.keyInfo == null ? ((KeyInfoNodeGen.create())) : this.keyInfo);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 isMemberModifiable(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberModifiable(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberInsertable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000) != 0 /* is-state_0 isMemberInsertable(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.isMemberInsertable(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInsertableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInsertableNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyInfo = super.insert(this.keyInfo == null ? ((KeyInfoNodeGen.create())) : this.keyInfo);
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 isMemberInsertable(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberInsertable(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void removeMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                (((JSObject) receiver)).removeMember(member);
                return;
            }

            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000) != 0 /* is-state_0 isMemberRemovable(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.isMemberRemovable(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberRemovableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberRemovableNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyInfo = super.insert(this.keyInfo == null ? ((KeyInfoNodeGen.create())) : this.keyInfo);
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 isMemberRemovable(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberRemovable(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000) != 0 /* is-state_0 invokeMember(JSObject, String, Object[], InteropLibrary, JSInteropInvokeNode, ExportValueNode) */) {
                    {
                        InteropLibrary invokeMemberNode__invokeMember_self__ = (this);
                        return arg0Value.invokeMember(arg1Value, arg2Value, invokeMemberNode__invokeMember_self__, this.invokeMemberNode__invokeMember_callNode_, this.invokeMemberNode__invokeMember_exportNode_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return invokeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object invokeMemberNode_AndSpecialize(JSObject arg0Value, String arg1Value, Object[] arg2Value) throws UnsupportedMessageException, UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary invokeMemberNode__invokeMember_self__ = null;
                        invokeMemberNode__invokeMember_self__ = (this);
                        this.invokeMemberNode__invokeMember_callNode_ = super.insert((JSInteropInvokeNode.create()));
                        this.invokeMemberNode__invokeMember_exportNode_ = super.insert((ExportValueNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 invokeMember(JSObject, String, Object[], InteropLibrary, JSInteropInvokeNode, ExportValueNode) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.invokeMember(arg1Value, arg2Value, invokeMemberNode__invokeMember_self__, this.invokeMemberNode__invokeMember_callNode_, this.invokeMemberNode__invokeMember_exportNode_);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 isMemberInvocable(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.isMemberInvocable(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInvocableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInvocableNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyInfo = super.insert(this.keyInfo == null ? ((KeyInfoNodeGen.create())) : this.keyInfo);
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 isMemberInvocable(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberInvocable(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasMemberReadSideEffects(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000000) != 0 /* is-state_0 hasMemberReadSideEffects(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.hasMemberReadSideEffects(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasMemberReadSideEffectsNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean hasMemberReadSideEffectsNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyInfo = super.insert(this.keyInfo == null ? ((KeyInfoNodeGen.create())) : this.keyInfo);
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 hasMemberReadSideEffects(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasMemberReadSideEffects(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasMemberWriteSideEffects(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000000) != 0 /* is-state_0 hasMemberWriteSideEffects(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.hasMemberWriteSideEffects(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasMemberWriteSideEffectsNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean hasMemberWriteSideEffectsNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.keyInfo = super.insert(this.keyInfo == null ? ((KeyInfoNodeGen.create())) : this.keyInfo);
                    this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 hasMemberWriteSideEffects(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasMemberWriteSideEffects(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasIterator(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000000) != 0 /* is-state_0 hasIterator(JSObject, InteropLibrary, JSInteropGetIteratorNode) */) {
                    {
                        InteropLibrary hasIteratorNode__hasIterator_self__ = (this);
                        return arg0Value.hasIterator(hasIteratorNode__hasIterator_self__, this.getIterator);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasIteratorNode_AndSpecialize(arg0Value);
            }

            private boolean hasIteratorNode_AndSpecialize(JSObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary hasIteratorNode__hasIterator_self__ = null;
                        hasIteratorNode__hasIterator_self__ = (this);
                        this.getIterator = super.insert(this.getIterator == null ? ((JSInteropGetIteratorNode.create())) : this.getIterator);
                        this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 hasIterator(JSObject, InteropLibrary, JSInteropGetIteratorNode) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.hasIterator(hasIteratorNode__hasIterator_self__, this.getIterator);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object getIterator(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSObject arg0Value = ((JSObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000000000) != 0 /* is-state_0 getIterator(JSObject, InteropLibrary, JSInteropGetIteratorNode) */) {
                    {
                        InteropLibrary getIteratorNode__getIterator_self__ = (this);
                        return arg0Value.getIterator(getIteratorNode__getIterator_self__, this.getIterator);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getIteratorNode_AndSpecialize(arg0Value);
            }

            private Object getIteratorNode_AndSpecialize(JSObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary getIteratorNode__getIterator_self__ = null;
                        getIteratorNode__getIterator_self__ = (this);
                        this.getIterator = super.insert(this.getIterator == null ? ((JSInteropGetIteratorNode.create())) : this.getIterator);
                        this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 getIterator(JSObject, InteropLibrary, JSInteropGetIteratorNode) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.getIterator(getIteratorNode__getIterator_self__, this.getIterator);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSObject) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSObject) receiver)).getLanguage();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSObject) receiver)).toDisplayString(allowSideEffects);
            }

            @GeneratedBy(JSObject.class)
            private static final class GetMembersNonArrayCachedData {

                @CompilationFinal GetMembersNonArrayCachedData next_;
                @CompilationFinal JSClass cachedJSClass_;

                GetMembersNonArrayCachedData(GetMembersNonArrayCachedData next_) {
                    this.next_ = next_;
                }

            }
        }
        @GeneratedBy(JSObject.class)
        public static class Uncached extends JSDynamicObjectGen.InteropLibraryExports.Uncached {

            protected Uncached(Object receiver) {
                super(receiver);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                return super.accepts(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return GetMembers.nonArrayUncached(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSObject) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.readMember(arg1Value, (this), (JSObject.getUncachedRead()), (JSObject.language((this)).bindMemberFunctions()), (ExportValueNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberReadable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnknownIdentifierException, UnsupportedMessageException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                arg0Value.writeMember(arg1Value, arg2Value, (KeyInfoNodeGen.getUncached()), (ImportValueNode.getUncached()), (JSObject.getUncachedWrite()));
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberModifiable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberInsertable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void removeMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                ((JSObject) receiver) .removeMember(member);
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberRemovable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, ArityException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.invokeMember(arg1Value, arg2Value, (this), (JSInteropInvokeNodeGen.getUncached()), (ExportValueNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberInvocable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMemberReadSideEffects(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.hasMemberReadSideEffects(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMemberWriteSideEffects(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.hasMemberWriteSideEffects(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasIterator(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.hasIterator((this), (JSInteropGetIteratorNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object getIterator(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.getIterator((this), (JSInteropGetIteratorNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSObject) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSObject) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSObject) receiver) .toDisplayString(allowSideEffects);
            }

        }
    }
}
