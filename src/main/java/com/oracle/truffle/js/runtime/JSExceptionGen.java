// CheckStyle: start generated
package com.oracle.truffle.js.runtime;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.ExceptionType;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSException.class)
final class JSExceptionGen {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(JSException.class, new InteropLibraryExports());
    }

    private JSExceptionGen() {
    }

    @GeneratedBy(JSException.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, JSException.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JSException;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JSException;
            return new Cached(receiver);
        }

        @GeneratedBy(JSException.class)
        private static final class Cached extends GraalJSExceptionGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @Child private InteropLibrary thisLib;
            @Child private InteropLibrary otherLib;
            @Child private InteropLibrary delegateLib;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @Override
            public ExceptionType getExceptionType(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSException) receiver)).getExceptionType();
            }

            @Override
            public boolean isExceptionIncompleteSource(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSException) receiver)).isExceptionIncompleteSource();
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSException) receiver)).hasMembers();
            }

            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) != 0 /* is-state_0 getMembers(JSException, boolean, InteropLibrary) */) {
                    return arg0Value.getMembers(arg1Value, this.delegateLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getMembersNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object getMembersNode_AndSpecialize(JSException arg0Value, boolean arg1Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getMembers(JSException, boolean, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getMembers(arg1Value, this.delegateLib);
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
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10) != 0 /* is-state_0 isMemberReadable(JSException, String, InteropLibrary) */) {
                    return arg0Value.isMemberReadable(arg1Value, this.delegateLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberReadableNode_AndSpecialize(JSException arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 isMemberReadable(JSException, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberReadable(arg1Value, this.delegateLib);
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
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100) != 0 /* is-state_0 isMemberModifiable(JSException, String, InteropLibrary) */) {
                    return arg0Value.isMemberModifiable(arg1Value, this.delegateLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberModifiableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberModifiableNode_AndSpecialize(JSException arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 isMemberModifiable(JSException, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberModifiable(arg1Value, this.delegateLib);
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
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 isMemberInsertable(JSException, String, InteropLibrary) */) {
                    return arg0Value.isMemberInsertable(arg1Value, this.delegateLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInsertableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInsertableNode_AndSpecialize(JSException arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 isMemberInsertable(JSException, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberInsertable(arg1Value, this.delegateLib);
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
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000) != 0 /* is-state_0 isMemberRemovable(JSException, String, InteropLibrary) */) {
                    return arg0Value.isMemberRemovable(arg1Value, this.delegateLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberRemovableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberRemovableNode_AndSpecialize(JSException arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 isMemberRemovable(JSException, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberRemovable(arg1Value, this.delegateLib);
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
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 isMemberInvocable(JSException, String, InteropLibrary) */) {
                    return arg0Value.isMemberInvocable(arg1Value, this.delegateLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInvocableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInvocableNode_AndSpecialize(JSException arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 isMemberInvocable(JSException, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberInvocable(arg1Value, this.delegateLib);
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
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000) != 0 /* is-state_0 hasMemberReadSideEffects(JSException, String, InteropLibrary) */) {
                    return arg0Value.hasMemberReadSideEffects(arg1Value, this.delegateLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasMemberReadSideEffectsNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean hasMemberReadSideEffectsNode_AndSpecialize(JSException arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 hasMemberReadSideEffects(JSException, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasMemberReadSideEffects(arg1Value, this.delegateLib);
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
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000) != 0 /* is-state_0 hasMemberWriteSideEffects(JSException, String, InteropLibrary) */) {
                    return arg0Value.hasMemberWriteSideEffects(arg1Value, this.delegateLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasMemberWriteSideEffectsNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean hasMemberWriteSideEffectsNode_AndSpecialize(JSException arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 hasMemberWriteSideEffects(JSException, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasMemberWriteSideEffects(arg1Value, this.delegateLib);
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
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000) != 0 /* is-state_0 readMember(JSException, String, InteropLibrary) */) {
                    return arg0Value.readMember(arg1Value, this.delegateLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberNode_AndSpecialize(JSException arg0Value, String arg1Value) throws UnknownIdentifierException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 readMember(JSException, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readMember(arg1Value, this.delegateLib);
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
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 writeMember(JSException, String, Object, InteropLibrary) */) {
                    arg0Value.writeMember(arg1Value, arg2Value, this.delegateLib);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeMemberNode_AndSpecialize(JSException arg0Value, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 writeMember(JSException, String, Object, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeMember(arg1Value, arg2Value, this.delegateLib);
                    return;
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
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000000) != 0 /* is-state_0 removeMember(JSException, String, InteropLibrary) */) {
                    arg0Value.removeMember(arg1Value, this.delegateLib);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                removeMemberNode_AndSpecialize(arg0Value, arg1Value);
                return;
            }

            private void removeMemberNode_AndSpecialize(JSException arg0Value, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 removeMember(JSException, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.removeMember(arg1Value, this.delegateLib);
                    return;
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
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000000) != 0 /* is-state_0 invokeMember(JSException, String, Object[], InteropLibrary) */) {
                    return arg0Value.invokeMember(arg1Value, arg2Value, this.delegateLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return invokeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object invokeMemberNode_AndSpecialize(JSException arg0Value, String arg1Value, Object[] arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, ArityException, UnsupportedTypeException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 invokeMember(JSException, String, Object[], InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.invokeMember(arg1Value, arg2Value, this.delegateLib);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasMetaObject(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000000) != 0 /* is-state_0 hasMetaObject(JSException, InteropLibrary) */) {
                    return arg0Value.hasMetaObject(this.delegateLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasMetaObjectNode_AndSpecialize(arg0Value);
            }

            private boolean hasMetaObjectNode_AndSpecialize(JSException arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 hasMetaObject(JSException, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasMetaObject(this.delegateLib);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object getMetaObject(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSException arg0Value = ((JSException) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000000000) != 0 /* is-state_0 getMetaObject(JSException, InteropLibrary) */) {
                    return arg0Value.getMetaObject(this.delegateLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getMetaObjectNode_AndSpecialize(arg0Value);
            }

            private Object getMetaObjectNode_AndSpecialize(JSException arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.delegateLib = super.insert(this.delegateLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.delegateLib);
                    this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 getMetaObject(JSException, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getMetaObject(this.delegateLib);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(JSException.class)
        private static final class Uncached extends GraalJSExceptionGen.InteropLibraryExports.Uncached {

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
            public ExceptionType getExceptionType(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSException) receiver) .getExceptionType();
            }

            @TruffleBoundary
            @Override
            public boolean isExceptionIncompleteSource(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSException) receiver) .isExceptionIncompleteSource();
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSException) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                return arg0Value.getMembers(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                return arg0Value.isMemberReadable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                return arg0Value.isMemberModifiable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                return arg0Value.isMemberInsertable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                return arg0Value.isMemberRemovable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                return arg0Value.isMemberInvocable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMemberReadSideEffects(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                return arg0Value.hasMemberReadSideEffects(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMemberWriteSideEffects(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                return arg0Value.hasMemberWriteSideEffects(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                return arg0Value.readMember(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                arg0Value.writeMember(arg1Value, arg2Value, (INTEROP_LIBRARY_.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public void removeMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                arg0Value.removeMember(arg1Value, (INTEROP_LIBRARY_.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, ArityException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                return arg0Value.invokeMember(arg1Value, arg2Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMetaObject(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                return arg0Value.hasMetaObject((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object getMetaObject(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSException arg0Value = ((JSException) arg0Value_);
                return arg0Value.getMetaObject((INTEROP_LIBRARY_.getUncached()));
            }

        }
    }
}
