// CheckStyle: start generated
package com.oracle.truffle.js.runtime.builtins;

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
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.FinalBitSet;
import com.oracle.truffle.api.utilities.TriState;
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
import com.oracle.truffle.js.runtime.objects.JSDynamicObject;
import com.oracle.truffle.js.runtime.objects.JSNonProxyObject;
import com.oracle.truffle.js.runtime.objects.JSObject;
import com.oracle.truffle.js.runtime.objects.JSDynamicObject.IsIdenticalOrUndefined;
import com.oracle.truffle.js.runtime.objects.JSObject.GetMembers;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSNumberObject.class)
@SuppressWarnings("unused")
final class JSNumberObjectGen {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);
    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(JSNumberObject.class, new InteropLibraryExports());
    }

    private JSNumberObjectGen() {
    }

    @GeneratedBy(JSNumberObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        static final FinalBitSet ENABLED_MESSAGES = createMessageBitSet(INTEROP_LIBRARY_, "isIdenticalOrUndefined", "identityHashCode", "getMembers", "hasMembers", "readMember", "isMemberReadable", "writeMember", "isMemberModifiable", "isMemberInsertable", "removeMember", "isMemberRemovable", "invokeMember", "isMemberInvocable", "hasMemberReadSideEffects", "hasMemberWriteSideEffects", "hasIterator", "getIterator", "hasLanguage", "getLanguage", "toDisplayString", "hasMetaObject", "getMetaObject");

        private InteropLibraryExports() {
            super(InteropLibrary.class, JSNumberObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JSNumberObject;
            InteropLibrary uncached = createDelegate(INTEROP_LIBRARY_, new Uncached());
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JSNumberObject;
            return createDelegate(INTEROP_LIBRARY_, new Cached(receiver));
        }

        @GeneratedBy(JSNumberObject.class)
        private static final class Cached extends InteropLibrary implements DelegateExport {

            @Child private InteropLibrary receiverNumberInteropLibrary_;
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
                JSNumberObject castReceiver = ((JSNumberObject) receiver) ;
                this.receiverNumberInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((castReceiver.number)));
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return ((JSNumberObject) receiver_).number;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate) {
                return this.receiverNumberInteropLibrary_;
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JSNumberObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof JSNumberObject)) {
                    return false;
                } else if (!this.receiverNumberInteropLibrary_.accepts((((JSNumberObject) receiver).number))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            protected TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) != 0 /* is-state_0 doHostObject(JSDynamicObject, JSDynamicObject) || doOther(JSDynamicObject, Object) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doHostObject(JSDynamicObject, JSDynamicObject) */ && arg1Value instanceof JSDynamicObject) {
                        JSDynamicObject arg1Value_ = (JSDynamicObject) arg1Value;
                        return IsIdenticalOrUndefined.doHostObject(arg0Value, arg1Value_);
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doOther(JSDynamicObject, Object) */) {
                        if (isIdenticalOrUndefinedFallbackGuard_(state_0, arg0Value, arg1Value)) {
                            return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isIdenticalOrUndefinedAndSpecialize(arg0Value, arg1Value);
            }

            private TriState isIdenticalOrUndefinedAndSpecialize(JSDynamicObject arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    if (arg1Value instanceof JSDynamicObject) {
                        JSDynamicObject arg1Value_ = (JSDynamicObject) arg1Value;
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doHostObject(JSDynamicObject, JSDynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return IsIdenticalOrUndefined.doHostObject(arg0Value, arg1Value_);
                    }
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doOther(JSDynamicObject, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
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
                        return NodeCost.MONOMORPHIC;
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).identityHashCode();
            }

            @ExplodeLoop
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1100) != 0 /* is-state_0 nonArrayCached(JSObject, boolean, JSClass) || nonArrayUncached(JSObject, boolean) */) {
                    if ((state_0 & 0b100) != 0 /* is-state_0 nonArrayCached(JSObject, boolean, JSClass) */) {
                        GetMembersNonArrayCachedData s0_ = this.getMembers_nonArrayCached_cache;
                        while (s0_ != null) {
                            assert (s0_.cachedJSClass_ != null);
                            if ((JSObject.getJSClass(arg0Value) == s0_.cachedJSClass_)) {
                                return GetMembers.nonArrayCached(arg0Value, arg1Value, s0_.cachedJSClass_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 nonArrayUncached(JSObject, boolean) */) {
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
                        if ((state_0 & 0b100) != 0 /* is-state_0 nonArrayCached(JSObject, boolean, JSClass) */) {
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
                                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 nonArrayCached(JSObject, boolean, JSClass) */;
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
                    state_0 = state_0 & 0xfffffffb /* remove-state_0 nonArrayCached(JSObject, boolean, JSClass) */;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 nonArrayUncached(JSObject, boolean) */;
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
            public boolean hasMembers(Object receiver) {
                assert receiver instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).hasMembers();
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000) != 0 /* is-state_0 readMember(JSObject, String, InteropLibrary, ReadElementNode, boolean, ExportValueNode) */) {
                    {
                        InteropLibrary readMemberNode__readMember_self__ = (((InteropLibrary) this.getParent()));
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
                        readMemberNode__readMember_self__ = (((InteropLibrary) this.getParent()));
                        this.readMemberNode__readMember_readNode_ = super.insert((ReadElementNode.create(JSObject.language(readMemberNode__readMember_self__).getJSContext())));
                        this.readMemberNode__readMember_bindMemberFunctions_ = (JSObject.language(readMemberNode__readMember_self__).bindMemberFunctions());
                        this.readMemberNode__readMember_exportNode_ = super.insert((ExportValueNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 readMember(JSObject, String, InteropLibrary, ReadElementNode, boolean, ExportValueNode) */;
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
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 isMemberReadable(JSObject, String, KeyInfoNode) */) {
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
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 isMemberReadable(JSObject, String, KeyInfoNode) */;
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
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000) != 0 /* is-state_0 writeMember(JSObject, String, Object, KeyInfoNode, ImportValueNode, WriteElementNode) */) {
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
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 writeMember(JSObject, String, Object, KeyInfoNode, ImportValueNode, WriteElementNode) */;
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
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000) != 0 /* is-state_0 isMemberModifiable(JSObject, String, KeyInfoNode) */) {
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
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 isMemberModifiable(JSObject, String, KeyInfoNode) */;
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
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000) != 0 /* is-state_0 isMemberInsertable(JSObject, String, KeyInfoNode) */) {
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
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 isMemberInsertable(JSObject, String, KeyInfoNode) */;
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
                assert receiver instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                (((JSNumberObject) receiver)).removeMember(member);
                return;
            }

            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 isMemberRemovable(JSObject, String, KeyInfoNode) */) {
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
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 isMemberRemovable(JSObject, String, KeyInfoNode) */;
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
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000000) != 0 /* is-state_0 invokeMember(JSObject, String, Object[], InteropLibrary, JSInteropInvokeNode, ExportValueNode) */) {
                    {
                        InteropLibrary invokeMemberNode__invokeMember_self__ = (((InteropLibrary) this.getParent()));
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
                        invokeMemberNode__invokeMember_self__ = (((InteropLibrary) this.getParent()));
                        this.invokeMemberNode__invokeMember_callNode_ = super.insert((JSInteropInvokeNode.create()));
                        this.invokeMemberNode__invokeMember_exportNode_ = super.insert((ExportValueNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 invokeMember(JSObject, String, Object[], InteropLibrary, JSInteropInvokeNode, ExportValueNode) */;
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
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000000) != 0 /* is-state_0 isMemberInvocable(JSObject, String, KeyInfoNode) */) {
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
                    this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 isMemberInvocable(JSObject, String, KeyInfoNode) */;
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
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000000) != 0 /* is-state_0 hasMemberReadSideEffects(JSObject, String, KeyInfoNode) */) {
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
                    this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 hasMemberReadSideEffects(JSObject, String, KeyInfoNode) */;
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
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000000000) != 0 /* is-state_0 hasMemberWriteSideEffects(JSObject, String, KeyInfoNode) */) {
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
                    this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 hasMemberWriteSideEffects(JSObject, String, KeyInfoNode) */;
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
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000000000) != 0 /* is-state_0 hasIterator(JSObject, InteropLibrary, JSInteropGetIteratorNode) */) {
                    {
                        InteropLibrary hasIteratorNode__hasIterator_self__ = (((InteropLibrary) this.getParent()));
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
                        hasIteratorNode__hasIterator_self__ = (((InteropLibrary) this.getParent()));
                        this.getIterator = super.insert(this.getIterator == null ? ((JSInteropGetIteratorNode.create())) : this.getIterator);
                        this.state_0_ = state_0 = state_0 | 0b100000000000000 /* add-state_0 hasIterator(JSObject, InteropLibrary, JSInteropGetIteratorNode) */;
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
                assert arg0Value_ instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 getIterator(JSObject, InteropLibrary, JSInteropGetIteratorNode) */) {
                    {
                        InteropLibrary getIteratorNode__getIterator_self__ = (((InteropLibrary) this.getParent()));
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
                        getIteratorNode__getIterator_self__ = (((InteropLibrary) this.getParent()));
                        this.getIterator = super.insert(this.getIterator == null ? ((JSInteropGetIteratorNode.create())) : this.getIterator);
                        this.state_0_ = state_0 = state_0 | 0b1000000000000000 /* add-state_0 getIterator(JSObject, InteropLibrary, JSInteropGetIteratorNode) */;
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
                assert receiver instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).getLanguage();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert receiver instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).toDisplayString(allowSideEffects);
            }

            @Override
            public boolean hasMetaObject(Object receiver) {
                assert receiver instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).hasMetaObject();
            }

            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof JSNumberObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).getMetaObject();
            }

            private static boolean isIdenticalOrUndefinedFallbackGuard_(int state_0, JSDynamicObject arg0Value, Object arg1Value) {
                if (((state_0 & 0b1)) == 0 /* is-not-state_0 doHostObject(JSDynamicObject, JSDynamicObject) */ && arg1Value instanceof JSDynamicObject) {
                    return false;
                }
                return true;
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
        @GeneratedBy(JSNumberObject.class)
        private static final class Uncached extends InteropLibrary implements DelegateExport {

            protected Uncached() {
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return (((JSNumberObject) receiver_)).number;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate_) {
                return INTEROP_LIBRARY_.getUncached(delegate_);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JSNumberObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof JSNumberObject;
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
            public TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSDynamicObject arg0Value = ((JSDynamicObject) arg0Value_);
                if (arg1Value instanceof JSDynamicObject) {
                    JSDynamicObject arg1Value_ = (JSDynamicObject) arg1Value;
                    return IsIdenticalOrUndefined.doHostObject(arg0Value, arg1Value_);
                }
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSDynamicObject) receiver) .identityHashCode();
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return GetMembers.nonArrayUncached(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSObject) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.readMember(arg1Value, (((InteropLibrary) this.getParent())), (JSObject.getUncachedRead()), (JSObject.language((((InteropLibrary) this.getParent()))).bindMemberFunctions()), (ExportValueNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberReadable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnknownIdentifierException, UnsupportedMessageException {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                arg0Value.writeMember(arg1Value, arg2Value, (KeyInfoNodeGen.getUncached()), (ImportValueNode.getUncached()), (JSObject.getUncachedWrite()));
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberModifiable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object arg0Value_, String arg1Value) {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberInsertable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void removeMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                ((JSObject) receiver) .removeMember(member);
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberRemovable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.invokeMember(arg1Value, arg2Value, (((InteropLibrary) this.getParent())), (JSInteropInvokeNodeGen.getUncached()), (ExportValueNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberInvocable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMemberReadSideEffects(Object arg0Value_, String arg1Value) {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.hasMemberReadSideEffects(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMemberWriteSideEffects(Object arg0Value_, String arg1Value) {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.hasMemberWriteSideEffects(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasIterator(Object arg0Value_) {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.hasIterator((((InteropLibrary) this.getParent())), (JSInteropGetIteratorNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object getIterator(Object arg0Value_) throws UnsupportedMessageException {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.getIterator((((InteropLibrary) this.getParent())), (JSInteropGetIteratorNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSObject) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSObject) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSObject) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public boolean hasMetaObject(Object receiver) {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSNonProxyObject) receiver) .hasMetaObject();
            }

            @TruffleBoundary
            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSNonProxyObject) receiver) .getMetaObject();
            }

        }
    }
}
