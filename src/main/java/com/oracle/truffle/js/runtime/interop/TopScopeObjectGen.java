// CheckStyle: start generated
package com.oracle.truffle.js.runtime.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
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
import com.oracle.truffle.js.runtime.JSConfig;
import java.util.concurrent.locks.Lock;

@GeneratedBy(TopScopeObject.class)
final class TopScopeObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(TopScopeObject.class, new InteropLibraryExports());
    }

    private TopScopeObjectGen() {
    }

    @GeneratedBy(TopScopeObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, TopScopeObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof TopScopeObject;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof TopScopeObject;
            return new Cached();
        }

        @GeneratedBy(TopScopeObject.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_0_;
            @Child private InteropLibrary interop;

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof TopScopeObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof TopScopeObject;
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((TopScopeObject) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((TopScopeObject) receiver)).getLanguage();
            }

            @Override
            public boolean isScope(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((TopScopeObject) receiver)).isScope();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((TopScopeObject) receiver)).toDisplayString(allowSideEffects);
            }

            @Override
            public boolean hasScopeParent(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((TopScopeObject) receiver)).hasScopeParent();
            }

            @Override
            public Object getScopeParent(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((TopScopeObject) receiver)).getScopeParent();
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((TopScopeObject) receiver)).hasMembers();
            }

            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) != 0 /* is-state_0 getMembers(TopScopeObject, boolean, InteropLibrary) */) {
                    return arg0Value.getMembers(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getMembersNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object getMembersNode_AndSpecialize(TopScopeObject arg0Value, boolean arg1Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getMembers(TopScopeObject, boolean, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getMembers(arg1Value, this.interop);
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
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10) != 0 /* is-state_0 isMemberReadable(TopScopeObject, String, InteropLibrary) */) {
                    return arg0Value.isMemberReadable(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberReadableNode_AndSpecialize(TopScopeObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 isMemberReadable(TopScopeObject, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberReadable(arg1Value, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100) != 0 /* is-state_0 readMember(TopScopeObject, String, InteropLibrary) */) {
                    return arg0Value.readMember(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberNode_AndSpecialize(TopScopeObject arg0Value, String arg1Value) throws UnknownIdentifierException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 readMember(TopScopeObject, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readMember(arg1Value, this.interop);
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
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 isMemberModifiable(TopScopeObject, String, InteropLibrary) */) {
                    return arg0Value.isMemberModifiable(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberModifiableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberModifiableNode_AndSpecialize(TopScopeObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 isMemberModifiable(TopScopeObject, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberModifiable(arg1Value, this.interop);
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
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000) != 0 /* is-state_0 isMemberInsertable(TopScopeObject, String, InteropLibrary) */) {
                    return arg0Value.isMemberInsertable(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInsertableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInsertableNode_AndSpecialize(TopScopeObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 isMemberInsertable(TopScopeObject, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberInsertable(arg1Value, this.interop);
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
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 hasMemberReadSideEffects(TopScopeObject, String, InteropLibrary) */) {
                    return arg0Value.hasMemberReadSideEffects(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasMemberReadSideEffectsNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean hasMemberReadSideEffectsNode_AndSpecialize(TopScopeObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 hasMemberReadSideEffects(TopScopeObject, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasMemberReadSideEffects(arg1Value, this.interop);
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
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000) != 0 /* is-state_0 hasMemberWriteSideEffects(TopScopeObject, String, InteropLibrary) */) {
                    return arg0Value.hasMemberWriteSideEffects(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasMemberWriteSideEffectsNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean hasMemberWriteSideEffectsNode_AndSpecialize(TopScopeObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 hasMemberWriteSideEffects(TopScopeObject, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasMemberWriteSideEffects(arg1Value, this.interop);
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
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000) != 0 /* is-state_0 writeMember(TopScopeObject, String, Object, InteropLibrary) */) {
                    arg0Value.writeMember(arg1Value, arg2Value, this.interop);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeMemberNode_AndSpecialize(TopScopeObject arg0Value, String arg1Value, Object arg2Value) throws UnknownIdentifierException, UnsupportedMessageException, UnsupportedTypeException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 writeMember(TopScopeObject, String, Object, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeMember(arg1Value, arg2Value, this.interop);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000) != 0 /* is-state_0 isMemberRemovable(TopScopeObject, String, InteropLibrary) */) {
                    return arg0Value.isMemberRemovable(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberRemovableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberRemovableNode_AndSpecialize(TopScopeObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 isMemberRemovable(TopScopeObject, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberRemovable(arg1Value, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void removeMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 removeMember(TopScopeObject, String, InteropLibrary) */) {
                    arg0Value.removeMember(arg1Value, this.interop);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                removeMemberNode_AndSpecialize(arg0Value, arg1Value);
                return;
            }

            private void removeMemberNode_AndSpecialize(TopScopeObject arg0Value, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 removeMember(TopScopeObject, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.removeMember(arg1Value, this.interop);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(TopScopeObject.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof TopScopeObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof TopScopeObject;
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
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TopScopeObject) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TopScopeObject) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public boolean isScope(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TopScopeObject) receiver) .isScope();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TopScopeObject) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public boolean hasScopeParent(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TopScopeObject) receiver) .hasScopeParent();
            }

            @TruffleBoundary
            @Override
            public Object getScopeParent(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TopScopeObject) receiver) .getScopeParent();
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TopScopeObject) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                return arg0Value.getMembers(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                return arg0Value.isMemberReadable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                return arg0Value.readMember(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                return arg0Value.isMemberModifiable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                return arg0Value.isMemberInsertable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMemberReadSideEffects(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                return arg0Value.hasMemberReadSideEffects(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMemberWriteSideEffects(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                return arg0Value.hasMemberWriteSideEffects(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnknownIdentifierException, UnsupportedMessageException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                arg0Value.writeMember(arg1Value, arg2Value, (INTEROP_LIBRARY_.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                return arg0Value.isMemberRemovable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void removeMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                TopScopeObject arg0Value = ((TopScopeObject) arg0Value_);
                arg0Value.removeMember(arg1Value, (INTEROP_LIBRARY_.getUncached()));
                return;
            }

        }
    }
}
