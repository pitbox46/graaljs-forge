// CheckStyle: start generated
package com.oracle.truffle.js.runtime.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DynamicScopeWrapper.class)
final class DynamicScopeWrapperGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    static  {
        LibraryExport.register(DynamicScopeWrapper.class, new InteropLibraryExports());
    }

    private DynamicScopeWrapperGen() {
    }

    @GeneratedBy(DynamicScopeWrapper.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, DynamicScopeWrapper.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof DynamicScopeWrapper;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof DynamicScopeWrapper;
            return new Cached(receiver);
        }

        @GeneratedBy(DynamicScopeWrapper.class)
        private static final class Cached extends InteropLibrary {

            @Child private DynamicObjectLibrary receiverScopeDynamicObjectLibrary_;
            @CompilationFinal private volatile int state_0_;
            @Child private ExportValueNode readMemberNode__readMember_exportValueNode_;

            protected Cached(Object receiver) {
                DynamicScopeWrapper castReceiver = ((DynamicScopeWrapper) receiver) ;
                this.receiverScopeDynamicObjectLibrary_ = super.insert(DYNAMIC_OBJECT_LIBRARY_.create((castReceiver.scope)));
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof DynamicScopeWrapper) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof DynamicScopeWrapper)) {
                    return false;
                } else if (!this.receiverScopeDynamicObjectLibrary_.accepts((((DynamicScopeWrapper) receiver).scope))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert receiver instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((DynamicScopeWrapper) receiver)).hasMembers();
            }

            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert arg0Value_ instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                {
                    DynamicObjectLibrary getMembersNode__getMembers_access__ = this.receiverScopeDynamicObjectLibrary_;
                    return arg0Value.getMembers(arg1Value, getMembersNode__getMembers_access__);
                }
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MONOMORPHIC;
            }

            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                {
                    DynamicObjectLibrary isMemberReadableNode__isMemberReadable_access__ = this.receiverScopeDynamicObjectLibrary_;
                    return arg0Value.isMemberReadable(arg1Value, isMemberReadableNode__isMemberReadable_access__);
                }
            }

            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                {
                    DynamicObjectLibrary isMemberModifiableNode__isMemberModifiable_access__ = this.receiverScopeDynamicObjectLibrary_;
                    return arg0Value.isMemberModifiable(arg1Value, isMemberModifiableNode__isMemberModifiable_access__);
                }
            }

            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                assert receiver instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((DynamicScopeWrapper) receiver)).isMemberInsertable(member);
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert arg0Value_ instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 readMember(DynamicScopeWrapper, String, DynamicObjectLibrary, ExportValueNode) */) {
                    {
                        DynamicObjectLibrary readMemberNode__readMember_access__ = this.receiverScopeDynamicObjectLibrary_;
                        return arg0Value.readMember(arg1Value, readMemberNode__readMember_access__, this.readMemberNode__readMember_exportValueNode_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberNode_AndSpecialize(DynamicScopeWrapper arg0Value, String arg1Value) throws UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        DynamicObjectLibrary readMemberNode__readMember_access__ = null;
                        readMemberNode__readMember_access__ = this.receiverScopeDynamicObjectLibrary_;
                        this.readMemberNode__readMember_exportValueNode_ = super.insert((ExportValueNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 readMember(DynamicScopeWrapper, String, DynamicObjectLibrary, ExportValueNode) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.readMember(arg1Value, readMemberNode__readMember_access__, this.readMemberNode__readMember_exportValueNode_);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                assert arg0Value_ instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                {
                    DynamicObjectLibrary writeMemberNode__writeMember_access__ = this.receiverScopeDynamicObjectLibrary_;
                    arg0Value.writeMember(arg1Value, arg2Value, writeMemberNode__writeMember_access__);
                    return;
                }
            }

        }
        @GeneratedBy(DynamicScopeWrapper.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof DynamicScopeWrapper) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof DynamicScopeWrapper;
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
                return ((DynamicScopeWrapper) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                return arg0Value.getMembers(arg1Value, DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value.scope)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                return arg0Value.isMemberReadable(arg1Value, DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value.scope)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                return arg0Value.isMemberModifiable(arg1Value, DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value.scope)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((DynamicScopeWrapper) receiver) .isMemberInsertable(member);
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                return arg0Value.readMember(arg1Value, DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value.scope)), (ExportValueNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                arg0Value.writeMember(arg1Value, arg2Value, DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value.scope)));
                return;
            }

        }
    }
}
