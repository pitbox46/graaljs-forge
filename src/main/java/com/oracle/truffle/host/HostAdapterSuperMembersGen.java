// CheckStyle: start generated
package com.oracle.truffle.host;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.host.HostAdapterSuperMembers.NameCache;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HostAdapterSuperMembers.class)
final class HostAdapterSuperMembersGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(HostAdapterSuperMembers.class, new InteropLibraryExports());
    }

    private HostAdapterSuperMembersGen() {
    }

    @GeneratedBy(HostAdapterSuperMembers.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, HostAdapterSuperMembers.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof HostAdapterSuperMembers;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof HostAdapterSuperMembers;
            return new Cached(receiver);
        }

        @GeneratedBy(HostAdapterSuperMembers.class)
        private static final class Cached extends InteropLibrary {

            @Child private InteropLibrary receiverAdapterInteropLibrary_;
            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private NameCache cache;

            protected Cached(Object receiver) {
                HostAdapterSuperMembers castReceiver = ((HostAdapterSuperMembers) receiver) ;
                this.receiverAdapterInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((castReceiver.adapter)));
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof HostAdapterSuperMembers) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof HostAdapterSuperMembers)) {
                    return false;
                } else if (!this.receiverAdapterInteropLibrary_.accepts((((HostAdapterSuperMembers) receiver).adapter))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert receiver instanceof HostAdapterSuperMembers : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostAdapterSuperMembers) receiver)).hasMembers();
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert arg0Value_ instanceof HostAdapterSuperMembers : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostAdapterSuperMembers arg0Value = ((HostAdapterSuperMembers) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) != 0 /* is-state_0 readMember(HostAdapterSuperMembers, String, NameCache, InteropLibrary) */) {
                    {
                        InteropLibrary readMemberNode__readMember_interop__ = this.receiverAdapterInteropLibrary_;
                        return arg0Value.readMember(arg1Value, this.cache, readMemberNode__readMember_interop__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberNode_AndSpecialize(HostAdapterSuperMembers arg0Value, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary readMemberNode__readMember_interop__ = null;
                        this.cache = this.cache == null ? ((NameCache.create())) : this.cache;
                        readMemberNode__readMember_interop__ = this.receiverAdapterInteropLibrary_;
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 readMember(HostAdapterSuperMembers, String, NameCache, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.readMember(arg1Value, this.cache, readMemberNode__readMember_interop__);
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
                if ((state_0 & 0b1) == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    return NodeCost.MONOMORPHIC;
                }
            }

            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                assert arg0Value_ instanceof HostAdapterSuperMembers : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostAdapterSuperMembers arg0Value = ((HostAdapterSuperMembers) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10) != 0 /* is-state_0 invokeMember(HostAdapterSuperMembers, String, Object[], NameCache, InteropLibrary) */) {
                    {
                        InteropLibrary invokeMemberNode__invokeMember_interop__ = this.receiverAdapterInteropLibrary_;
                        return arg0Value.invokeMember(arg1Value, arg2Value, this.cache, invokeMemberNode__invokeMember_interop__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return invokeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object invokeMemberNode_AndSpecialize(HostAdapterSuperMembers arg0Value, String arg1Value, Object[] arg2Value) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary invokeMemberNode__invokeMember_interop__ = null;
                        this.cache = this.cache == null ? ((NameCache.create())) : this.cache;
                        invokeMemberNode__invokeMember_interop__ = this.receiverAdapterInteropLibrary_;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 invokeMember(HostAdapterSuperMembers, String, Object[], NameCache, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.invokeMember(arg1Value, arg2Value, this.cache, invokeMemberNode__invokeMember_interop__);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof HostAdapterSuperMembers : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostAdapterSuperMembers arg0Value = ((HostAdapterSuperMembers) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100) != 0 /* is-state_0 isMemberReadable(HostAdapterSuperMembers, String, NameCache, InteropLibrary) */) {
                    {
                        InteropLibrary isMemberReadableNode__isMemberReadable_interop__ = this.receiverAdapterInteropLibrary_;
                        return arg0Value.isMemberReadable(arg1Value, this.cache, isMemberReadableNode__isMemberReadable_interop__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberReadableNode_AndSpecialize(HostAdapterSuperMembers arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary isMemberReadableNode__isMemberReadable_interop__ = null;
                        this.cache = this.cache == null ? ((NameCache.create())) : this.cache;
                        isMemberReadableNode__isMemberReadable_interop__ = this.receiverAdapterInteropLibrary_;
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 isMemberReadable(HostAdapterSuperMembers, String, NameCache, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.isMemberReadable(arg1Value, this.cache, isMemberReadableNode__isMemberReadable_interop__);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof HostAdapterSuperMembers : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostAdapterSuperMembers arg0Value = ((HostAdapterSuperMembers) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 isMemberInvocable(HostAdapterSuperMembers, String, NameCache, InteropLibrary) */) {
                    {
                        InteropLibrary isMemberInvocableNode__isMemberInvocable_interop__ = this.receiverAdapterInteropLibrary_;
                        return arg0Value.isMemberInvocable(arg1Value, this.cache, isMemberInvocableNode__isMemberInvocable_interop__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInvocableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInvocableNode_AndSpecialize(HostAdapterSuperMembers arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary isMemberInvocableNode__isMemberInvocable_interop__ = null;
                        this.cache = this.cache == null ? ((NameCache.create())) : this.cache;
                        isMemberInvocableNode__isMemberInvocable_interop__ = this.receiverAdapterInteropLibrary_;
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 isMemberInvocable(HostAdapterSuperMembers, String, NameCache, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.isMemberInvocable(arg1Value, this.cache, isMemberInvocableNode__isMemberInvocable_interop__);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert receiver instanceof HostAdapterSuperMembers : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostAdapterSuperMembers) receiver)).getMembers(includeInternal);
            }

        }
        @GeneratedBy(HostAdapterSuperMembers.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof HostAdapterSuperMembers) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof HostAdapterSuperMembers;
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
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostAdapterSuperMembers) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostAdapterSuperMembers arg0Value = ((HostAdapterSuperMembers) arg0Value_);
                return arg0Value.readMember(arg1Value, (NameCache.getUncached()), INTEROP_LIBRARY_.getUncached((arg0Value.adapter)));
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostAdapterSuperMembers arg0Value = ((HostAdapterSuperMembers) arg0Value_);
                return arg0Value.invokeMember(arg1Value, arg2Value, (NameCache.getUncached()), INTEROP_LIBRARY_.getUncached((arg0Value.adapter)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostAdapterSuperMembers arg0Value = ((HostAdapterSuperMembers) arg0Value_);
                return arg0Value.isMemberReadable(arg1Value, (NameCache.getUncached()), INTEROP_LIBRARY_.getUncached((arg0Value.adapter)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostAdapterSuperMembers arg0Value = ((HostAdapterSuperMembers) arg0Value_);
                return arg0Value.isMemberInvocable(arg1Value, (NameCache.getUncached()), INTEROP_LIBRARY_.getUncached((arg0Value.adapter)));
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostAdapterSuperMembers) receiver) .getMembers(includeInternal);
            }

        }
    }
}
