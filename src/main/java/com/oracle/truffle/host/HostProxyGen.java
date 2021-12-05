// CheckStyle: start generated
package com.oracle.truffle.host;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.StopIterationException;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnknownKeyException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.TriState;
import com.oracle.truffle.host.HostProxy.IsIdenticalOrUndefined;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HostProxy.class)
@SuppressWarnings("unused")
final class HostProxyGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(HostProxy.class, new InteropLibraryExports());
    }

    private HostProxyGen() {
    }

    @GeneratedBy(HostProxy.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, HostProxy.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof HostProxy;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof HostProxy;
            return new Cached();
        }

        @GeneratedBy(HostProxy.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int state_1_;
            @CompilationFinal private GuestToHostCodeCache cache;
            @Child private InteropLibrary executables;

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof HostProxy) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof HostProxy;
            }

            @Override
            protected TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) != 0 /* is-state_0 doHostObject(HostProxy, HostProxy) || doOther(HostProxy, Object) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doHostObject(HostProxy, HostProxy) */ && arg1Value instanceof HostProxy) {
                        HostProxy arg1Value_ = (HostProxy) arg1Value;
                        return IsIdenticalOrUndefined.doHostObject(arg0Value, arg1Value_);
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doOther(HostProxy, Object) */) {
                        if (isIdenticalOrUndefinedFallbackGuard_(state_0, arg0Value, arg1Value)) {
                            return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isIdenticalOrUndefinedAndSpecialize(arg0Value, arg1Value);
            }

            private TriState isIdenticalOrUndefinedAndSpecialize(HostProxy arg0Value, Object arg1Value) {
                int state_0 = this.state_0_;
                if (arg1Value instanceof HostProxy) {
                    HostProxy arg1Value_ = (HostProxy) arg1Value;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doHostObject(HostProxy, HostProxy) */;
                    return IsIdenticalOrUndefined.doHostObject(arg0Value, arg1Value_);
                }
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doOther(HostProxy, Object) */;
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
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
            public boolean isInstantiable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).isInstantiable();
            }

            @Override
            public Object instantiate(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100) != 0 /* is-state_0 instantiate(HostProxy, Object[], InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary instantiateNode__instantiate_library__ = (this);
                        return arg0Value.instantiate(arg1Value, instantiateNode__instantiate_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return instantiateNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object instantiateNode_AndSpecialize(HostProxy arg0Value, Object[] arg1Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary instantiateNode__instantiate_library__ = null;
                        instantiateNode__instantiate_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 instantiate(HostProxy, Object[], InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.instantiate(arg1Value, instantiateNode__instantiate_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isExecutable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).isExecutable();
            }

            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 execute(HostProxy, Object[], InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary executeNode__execute_library__ = (this);
                        return arg0Value.execute(arg1Value, executeNode__execute_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object executeNode_AndSpecialize(HostProxy arg0Value, Object[] arg1Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary executeNode__execute_library__ = null;
                        executeNode__execute_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 execute(HostProxy, Object[], InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.execute(arg1Value, executeNode__execute_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isPointer(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).isPointer();
            }

            @Override
            public long asPointer(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000) != 0 /* is-state_0 asPointer(HostProxy, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary asPointerNode__asPointer_library__ = (this);
                        return arg0Value.asPointer(asPointerNode__asPointer_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asPointerNode_AndSpecialize(arg0Value);
            }

            private long asPointerNode_AndSpecialize(HostProxy arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary asPointerNode__asPointer_library__ = null;
                        asPointerNode__asPointer_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 asPointer(HostProxy, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asPointer(asPointerNode__asPointer_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).hasArrayElements();
            }

            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 readArrayElement(HostProxy, long, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary readArrayElementNode__readArrayElement_library__ = (this);
                        return arg0Value.readArrayElement(arg1Value, readArrayElementNode__readArrayElement_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readArrayElementNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readArrayElementNode_AndSpecialize(HostProxy arg0Value, long arg1Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary readArrayElementNode__readArrayElement_library__ = null;
                        readArrayElementNode__readArrayElement_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 readArrayElement(HostProxy, long, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.readArrayElement(arg1Value, readArrayElementNode__readArrayElement_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeArrayElement(Object arg0Value_, long arg1Value, Object arg2Value) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000) != 0 /* is-state_0 writeArrayElement(HostProxy, long, Object, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary writeArrayElementNode__writeArrayElement_library__ = (this);
                        arg0Value.writeArrayElement(arg1Value, arg2Value, writeArrayElementNode__writeArrayElement_library__, this.cache);
                        return;
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeArrayElementNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeArrayElementNode_AndSpecialize(HostProxy arg0Value, long arg1Value, Object arg2Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary writeArrayElementNode__writeArrayElement_library__ = null;
                        writeArrayElementNode__writeArrayElement_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 writeArrayElement(HostProxy, long, Object, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        arg0Value.writeArrayElement(arg1Value, arg2Value, writeArrayElementNode__writeArrayElement_library__, this.cache);
                        return;
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void removeArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000) != 0 /* is-state_0 removeArrayElement(HostProxy, long, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary removeArrayElementNode__removeArrayElement_library__ = (this);
                        arg0Value.removeArrayElement(arg1Value, removeArrayElementNode__removeArrayElement_library__, this.cache);
                        return;
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                removeArrayElementNode_AndSpecialize(arg0Value, arg1Value);
                return;
            }

            private void removeArrayElementNode_AndSpecialize(HostProxy arg0Value, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary removeArrayElementNode__removeArrayElement_library__ = null;
                        removeArrayElementNode__removeArrayElement_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 removeArrayElement(HostProxy, long, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        arg0Value.removeArrayElement(arg1Value, removeArrayElementNode__removeArrayElement_library__, this.cache);
                        return;
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public long getArraySize(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000) != 0 /* is-state_0 getArraySize(HostProxy, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary getArraySizeNode__getArraySize_library__ = (this);
                        return arg0Value.getArraySize(getArraySizeNode__getArraySize_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getArraySizeNode_AndSpecialize(arg0Value);
            }

            private long getArraySizeNode_AndSpecialize(HostProxy arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary getArraySizeNode__getArraySize_library__ = null;
                        getArraySizeNode__getArraySize_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 getArraySize(HostProxy, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.getArraySize(getArraySizeNode__getArraySize_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 isArrayElementExisting(HostProxy, long, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isArrayElementExistingNode__isArrayElementExisting_library__ = (this);
                        return arg0Value.isArrayElementExisting(arg1Value, isArrayElementExistingNode__isArrayElementExisting_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementExistingNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementExistingNode_AndSpecialize(HostProxy arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary isArrayElementExistingNode__isArrayElementExisting_library__ = null;
                        isArrayElementExistingNode__isArrayElementExisting_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 isArrayElementExisting(HostProxy, long, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.isArrayElementExisting(arg1Value, isArrayElementExistingNode__isArrayElementExisting_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementModifiable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 isArrayElementExisting(HostProxy, long, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isArrayElementExistingNode__isArrayElementExisting_library__ = (this);
                        return arg0Value.isArrayElementExisting(arg1Value, isArrayElementExistingNode__isArrayElementExisting_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementExistingNode_AndSpecialize(arg0Value, arg1Value);
            }

            @Override
            public boolean isArrayElementRemovable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 isArrayElementExisting(HostProxy, long, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isArrayElementExistingNode__isArrayElementExisting_library__ = (this);
                        return arg0Value.isArrayElementExisting(arg1Value, isArrayElementExistingNode__isArrayElementExisting_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementExistingNode_AndSpecialize(arg0Value, arg1Value);
            }

            @Override
            public boolean isArrayElementInsertable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000000) != 0 /* is-state_0 isArrayElementInsertable(HostProxy, long, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isArrayElementInsertableNode__isArrayElementInsertable_library__ = (this);
                        return arg0Value.isArrayElementInsertable(arg1Value, isArrayElementInsertableNode__isArrayElementInsertable_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementInsertableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementInsertableNode_AndSpecialize(HostProxy arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary isArrayElementInsertableNode__isArrayElementInsertable_library__ = null;
                        isArrayElementInsertableNode__isArrayElementInsertable_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 isArrayElementInsertable(HostProxy, long, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.isArrayElementInsertable(arg1Value, isArrayElementInsertableNode__isArrayElementInsertable_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).hasMembers();
            }

            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000000) != 0 /* is-state_0 getMembers(HostProxy, boolean, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary getMembersNode__getMembers_library__ = (this);
                        return arg0Value.getMembers(arg1Value, getMembersNode__getMembers_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getMembersNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object getMembersNode_AndSpecialize(HostProxy arg0Value, boolean arg1Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary getMembersNode__getMembers_library__ = null;
                        getMembersNode__getMembers_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 getMembers(HostProxy, boolean, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.getMembers(arg1Value, getMembersNode__getMembers_library__, this.cache);
                    }
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
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000000) != 0 /* is-state_0 readMember(HostProxy, String, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary readMemberNode__readMember_library__ = (this);
                        return arg0Value.readMember(arg1Value, readMemberNode__readMember_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberNode_AndSpecialize(HostProxy arg0Value, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary readMemberNode__readMember_library__ = null;
                        readMemberNode__readMember_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 readMember(HostProxy, String, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.readMember(arg1Value, readMemberNode__readMember_library__, this.cache);
                    }
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
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000000000) != 0 /* is-state_0 writeMember(HostProxy, String, Object, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary writeMemberNode__writeMember_library__ = (this);
                        arg0Value.writeMember(arg1Value, arg2Value, writeMemberNode__writeMember_library__, this.cache);
                        return;
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeMemberNode_AndSpecialize(HostProxy arg0Value, String arg1Value, Object arg2Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary writeMemberNode__writeMember_library__ = null;
                        writeMemberNode__writeMember_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 writeMember(HostProxy, String, Object, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        arg0Value.writeMember(arg1Value, arg2Value, writeMemberNode__writeMember_library__, this.cache);
                        return;
                    }
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
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000000000) != 0 /* is-state_0 invokeMember(HostProxy, String, Object[], InteropLibrary, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary invokeMemberNode__invokeMember_library__ = (this);
                        return arg0Value.invokeMember(arg1Value, arg2Value, invokeMemberNode__invokeMember_library__, this.executables, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return invokeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object invokeMemberNode_AndSpecialize(HostProxy arg0Value, String arg1Value, Object[] arg2Value) throws UnsupportedMessageException, UnsupportedTypeException, ArityException, UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary invokeMemberNode__invokeMember_library__ = null;
                        invokeMemberNode__invokeMember_library__ = (this);
                        this.executables = super.insert(this.executables == null ? ((INTEROP_LIBRARY_.createDispatched(HostProxy.LIMIT))) : this.executables);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b100000000000000 /* add-state_0 invokeMember(HostProxy, String, Object[], InteropLibrary, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.invokeMember(arg1Value, arg2Value, invokeMemberNode__invokeMember_library__, this.executables, this.cache);
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
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 isMemberInvocable(HostProxy, String, InteropLibrary, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isMemberInvocableNode__isMemberInvocable_library__ = (this);
                        return arg0Value.isMemberInvocable(arg1Value, isMemberInvocableNode__isMemberInvocable_library__, this.executables, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInvocableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInvocableNode_AndSpecialize(HostProxy arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary isMemberInvocableNode__isMemberInvocable_library__ = null;
                        isMemberInvocableNode__isMemberInvocable_library__ = (this);
                        this.executables = super.insert(this.executables == null ? ((INTEROP_LIBRARY_.createDispatched(HostProxy.LIMIT))) : this.executables);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0b1000000000000000 /* add-state_0 isMemberInvocable(HostProxy, String, InteropLibrary, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.isMemberInvocable(arg1Value, isMemberInvocableNode__isMemberInvocable_library__, this.executables, this.cache);
                    }
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
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x10000) != 0 /* is-state_0 removeMember(HostProxy, String, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary removeMemberNode__removeMember_library__ = (this);
                        arg0Value.removeMember(arg1Value, removeMemberNode__removeMember_library__, this.cache);
                        return;
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                removeMemberNode_AndSpecialize(arg0Value, arg1Value);
                return;
            }

            private void removeMemberNode_AndSpecialize(HostProxy arg0Value, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary removeMemberNode__removeMember_library__ = null;
                        removeMemberNode__removeMember_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x10000 /* add-state_0 removeMember(HostProxy, String, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        arg0Value.removeMember(arg1Value, removeMemberNode__removeMember_library__, this.cache);
                        return;
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
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x20000) != 0 /* is-state_0 isMemberExisting(HostProxy, String, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isMemberExistingNode__isMemberExisting_library__ = (this);
                        return arg0Value.isMemberExisting(arg1Value, isMemberExistingNode__isMemberExisting_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberExistingNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberExistingNode_AndSpecialize(HostProxy arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary isMemberExistingNode__isMemberExisting_library__ = null;
                        isMemberExistingNode__isMemberExisting_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x20000 /* add-state_0 isMemberExisting(HostProxy, String, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.isMemberExisting(arg1Value, isMemberExistingNode__isMemberExisting_library__, this.cache);
                    }
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
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x20000) != 0 /* is-state_0 isMemberExisting(HostProxy, String, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isMemberExistingNode__isMemberExisting_library__ = (this);
                        return arg0Value.isMemberExisting(arg1Value, isMemberExistingNode__isMemberExisting_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberExistingNode_AndSpecialize(arg0Value, arg1Value);
            }

            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x20000) != 0 /* is-state_0 isMemberExisting(HostProxy, String, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isMemberExistingNode__isMemberExisting_library__ = (this);
                        return arg0Value.isMemberExisting(arg1Value, isMemberExistingNode__isMemberExisting_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberExistingNode_AndSpecialize(arg0Value, arg1Value);
            }

            @Override
            public boolean isMemberInsertable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x40000) != 0 /* is-state_0 isMemberInsertable(HostProxy, String, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isMemberInsertableNode__isMemberInsertable_library__ = (this);
                        return arg0Value.isMemberInsertable(arg1Value, isMemberInsertableNode__isMemberInsertable_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInsertableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInsertableNode_AndSpecialize(HostProxy arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary isMemberInsertableNode__isMemberInsertable_library__ = null;
                        isMemberInsertableNode__isMemberInsertable_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x40000 /* add-state_0 isMemberInsertable(HostProxy, String, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.isMemberInsertable(arg1Value, isMemberInsertableNode__isMemberInsertable_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isDate(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).isDate();
            }

            @Override
            public boolean isTime(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).isTime();
            }

            @Override
            public boolean isTimeZone(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).isTimeZone();
            }

            @Override
            public ZoneId asTimeZone(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x80000) != 0 /* is-state_0 asTimeZone(HostProxy, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary asTimeZoneNode__asTimeZone_library__ = (this);
                        return arg0Value.asTimeZone(asTimeZoneNode__asTimeZone_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asTimeZoneNode_AndSpecialize(arg0Value);
            }

            private ZoneId asTimeZoneNode_AndSpecialize(HostProxy arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary asTimeZoneNode__asTimeZone_library__ = null;
                        asTimeZoneNode__asTimeZone_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x80000 /* add-state_0 asTimeZone(HostProxy, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asTimeZone(asTimeZoneNode__asTimeZone_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public LocalDate asDate(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x100000) != 0 /* is-state_0 asDate(HostProxy, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary asDateNode__asDate_library__ = (this);
                        return arg0Value.asDate(asDateNode__asDate_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asDateNode_AndSpecialize(arg0Value);
            }

            private LocalDate asDateNode_AndSpecialize(HostProxy arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary asDateNode__asDate_library__ = null;
                        asDateNode__asDate_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x100000 /* add-state_0 asDate(HostProxy, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asDate(asDateNode__asDate_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public LocalTime asTime(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x200000) != 0 /* is-state_0 asTime(HostProxy, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary asTimeNode__asTime_library__ = (this);
                        return arg0Value.asTime(asTimeNode__asTime_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asTimeNode_AndSpecialize(arg0Value);
            }

            private LocalTime asTimeNode_AndSpecialize(HostProxy arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary asTimeNode__asTime_library__ = null;
                        asTimeNode__asTime_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x200000 /* add-state_0 asTime(HostProxy, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asTime(asTimeNode__asTime_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Instant asInstant(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x400000) != 0 /* is-state_0 asInstant(HostProxy, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary asInstantNode__asInstant_library__ = (this);
                        return arg0Value.asInstant(asInstantNode__asInstant_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asInstantNode_AndSpecialize(arg0Value);
            }

            private Instant asInstantNode_AndSpecialize(HostProxy arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary asInstantNode__asInstant_library__ = null;
                        asInstantNode__asInstant_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x400000 /* add-state_0 asInstant(HostProxy, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asInstant(asInstantNode__asInstant_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isDuration(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).isDuration();
            }

            @Override
            public Duration asDuration(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x800000) != 0 /* is-state_0 asDuration(HostProxy, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary asDurationNode__asDuration_library__ = (this);
                        return arg0Value.asDuration(asDurationNode__asDuration_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asDurationNode_AndSpecialize(arg0Value);
            }

            private Duration asDurationNode_AndSpecialize(HostProxy arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary asDurationNode__asDuration_library__ = null;
                        asDurationNode__asDuration_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x800000 /* add-state_0 asDuration(HostProxy, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asDuration(asDurationNode__asDuration_library__, this.cache);
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
                return (((HostProxy) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).getLanguage();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).toDisplayString(allowSideEffects);
            }

            @Override
            public boolean hasMetaObject(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).hasMetaObject();
            }

            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).getMetaObject();
            }

            @Override
            public boolean hasIterator(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).hasIterator();
            }

            @Override
            public Object getIterator(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x1000000) != 0 /* is-state_0 getIterator(HostProxy, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary getIteratorNode__getIterator_library__ = (this);
                        return arg0Value.getIterator(getIteratorNode__getIterator_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getIteratorNode_AndSpecialize(arg0Value);
            }

            private Object getIteratorNode_AndSpecialize(HostProxy arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary getIteratorNode__getIterator_library__ = null;
                        getIteratorNode__getIterator_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x1000000 /* add-state_0 getIterator(HostProxy, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.getIterator(getIteratorNode__getIterator_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isIterator(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).isIterator();
            }

            @Override
            public boolean hasIteratorNextElement(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x2000000) != 0 /* is-state_0 hasIteratorNextElement(HostProxy, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary hasIteratorNextElementNode__hasIteratorNextElement_library__ = (this);
                        return arg0Value.hasIteratorNextElement(hasIteratorNextElementNode__hasIteratorNextElement_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasIteratorNextElementNode_AndSpecialize(arg0Value);
            }

            private boolean hasIteratorNextElementNode_AndSpecialize(HostProxy arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary hasIteratorNextElementNode__hasIteratorNextElement_library__ = null;
                        hasIteratorNextElementNode__hasIteratorNextElement_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x2000000 /* add-state_0 hasIteratorNextElement(HostProxy, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.hasIteratorNextElement(hasIteratorNextElementNode__hasIteratorNextElement_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object getIteratorNextElement(Object arg0Value_) throws UnsupportedMessageException, StopIterationException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x4000000) != 0 /* is-state_0 getIteratorNextElement(HostProxy, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary getIteratorNextElementNode__getIteratorNextElement_library__ = (this);
                        return arg0Value.getIteratorNextElement(getIteratorNextElementNode__getIteratorNextElement_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getIteratorNextElementNode_AndSpecialize(arg0Value);
            }

            private Object getIteratorNextElementNode_AndSpecialize(HostProxy arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary getIteratorNextElementNode__getIteratorNextElement_library__ = null;
                        getIteratorNextElementNode__getIteratorNextElement_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x4000000 /* add-state_0 getIteratorNextElement(HostProxy, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.getIteratorNextElement(getIteratorNextElementNode__getIteratorNextElement_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasHashEntries(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostProxy) receiver)).hasHashEntries();
            }

            @Override
            public long getHashSize(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x8000000) != 0 /* is-state_0 getHashSize(HostProxy, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary getHashSizeNode__getHashSize_library__ = (this);
                        return arg0Value.getHashSize(getHashSizeNode__getHashSize_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getHashSizeNode_AndSpecialize(arg0Value);
            }

            private long getHashSizeNode_AndSpecialize(HostProxy arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary getHashSizeNode__getHashSize_library__ = null;
                        getHashSizeNode__getHashSize_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x8000000 /* add-state_0 getHashSize(HostProxy, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.getHashSize(getHashSizeNode__getHashSize_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isHashEntryReadable(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x10000000) != 0 /* is-state_0 isHashValueExisting(HostProxy, Object, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isHashValueExistingNode__isHashValueExisting_library__ = (this);
                        return arg0Value.isHashValueExisting(arg1Value, isHashValueExistingNode__isHashValueExisting_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isHashValueExistingNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isHashValueExistingNode_AndSpecialize(HostProxy arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary isHashValueExistingNode__isHashValueExisting_library__ = null;
                        isHashValueExistingNode__isHashValueExisting_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x10000000 /* add-state_0 isHashValueExisting(HostProxy, Object, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.isHashValueExisting(arg1Value, isHashValueExistingNode__isHashValueExisting_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isHashEntryModifiable(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x10000000) != 0 /* is-state_0 isHashValueExisting(HostProxy, Object, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isHashValueExistingNode__isHashValueExisting_library__ = (this);
                        return arg0Value.isHashValueExisting(arg1Value, isHashValueExistingNode__isHashValueExisting_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isHashValueExistingNode_AndSpecialize(arg0Value, arg1Value);
            }

            @Override
            public boolean isHashEntryRemovable(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x10000000) != 0 /* is-state_0 isHashValueExisting(HostProxy, Object, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isHashValueExistingNode__isHashValueExisting_library__ = (this);
                        return arg0Value.isHashValueExisting(arg1Value, isHashValueExistingNode__isHashValueExisting_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isHashValueExistingNode_AndSpecialize(arg0Value, arg1Value);
            }

            @Override
            public Object readHashValue(Object arg0Value_, Object arg1Value) throws UnsupportedMessageException, UnknownKeyException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x20000000) != 0 /* is-state_0 readHashValue(HostProxy, Object, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary readHashValueNode__readHashValue_library__ = (this);
                        return arg0Value.readHashValue(arg1Value, readHashValueNode__readHashValue_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readHashValueNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readHashValueNode_AndSpecialize(HostProxy arg0Value, Object arg1Value) throws UnsupportedMessageException, UnknownKeyException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary readHashValueNode__readHashValue_library__ = null;
                        readHashValueNode__readHashValue_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x20000000 /* add-state_0 readHashValue(HostProxy, Object, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.readHashValue(arg1Value, readHashValueNode__readHashValue_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isHashEntryInsertable(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x40000000) != 0 /* is-state_0 isHashEntryInsertable(HostProxy, Object, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary isHashEntryInsertableNode__isHashEntryInsertable_library__ = (this);
                        return arg0Value.isHashEntryInsertable(arg1Value, isHashEntryInsertableNode__isHashEntryInsertable_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isHashEntryInsertableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isHashEntryInsertableNode_AndSpecialize(HostProxy arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary isHashEntryInsertableNode__isHashEntryInsertable_library__ = null;
                        isHashEntryInsertableNode__isHashEntryInsertable_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x40000000 /* add-state_0 isHashEntryInsertable(HostProxy, Object, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.isHashEntryInsertable(arg1Value, isHashEntryInsertableNode__isHashEntryInsertable_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeHashEntry(Object arg0Value_, Object arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownKeyException, UnsupportedTypeException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x80000000) != 0 /* is-state_0 writeHashEntry(HostProxy, Object, Object, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary writeHashEntryNode__writeHashEntry_library__ = (this);
                        arg0Value.writeHashEntry(arg1Value, arg2Value, writeHashEntryNode__writeHashEntry_library__, this.cache);
                        return;
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeHashEntryNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeHashEntryNode_AndSpecialize(HostProxy arg0Value, Object arg1Value, Object arg2Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary writeHashEntryNode__writeHashEntry_library__ = null;
                        writeHashEntryNode__writeHashEntry_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_0_ = state_0 = state_0 | 0x80000000 /* add-state_0 writeHashEntry(HostProxy, Object, Object, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        arg0Value.writeHashEntry(arg1Value, arg2Value, writeHashEntryNode__writeHashEntry_library__, this.cache);
                        return;
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void removeHashEntry(Object arg0Value_, Object arg1Value) throws UnsupportedMessageException, UnknownKeyException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0b1) != 0 /* is-state_1 removeHashEntry(HostProxy, Object, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary removeHashEntryNode__removeHashEntry_library__ = (this);
                        arg0Value.removeHashEntry(arg1Value, removeHashEntryNode__removeHashEntry_library__, this.cache);
                        return;
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                removeHashEntryNode_AndSpecialize(arg0Value, arg1Value);
                return;
            }

            private void removeHashEntryNode_AndSpecialize(HostProxy arg0Value, Object arg1Value) throws UnsupportedMessageException, UnknownKeyException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    {
                        InteropLibrary removeHashEntryNode__removeHashEntry_library__ = null;
                        removeHashEntryNode__removeHashEntry_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_1_ = state_1 = state_1 | 0b1 /* add-state_1 removeHashEntry(HostProxy, Object, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        arg0Value.removeHashEntry(arg1Value, removeHashEntryNode__removeHashEntry_library__, this.cache);
                        return;
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object getHashEntriesIterator(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0b10) != 0 /* is-state_1 getHashEntriesIterator(HostProxy, InteropLibrary, GuestToHostCodeCache) */) {
                    {
                        InteropLibrary getHashEntriesIteratorNode__getHashEntriesIterator_library__ = (this);
                        return arg0Value.getHashEntriesIterator(getHashEntriesIteratorNode__getHashEntriesIterator_library__, this.cache);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getHashEntriesIteratorNode_AndSpecialize(arg0Value);
            }

            private Object getHashEntriesIteratorNode_AndSpecialize(HostProxy arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    {
                        InteropLibrary getHashEntriesIteratorNode__getHashEntriesIterator_library__ = null;
                        getHashEntriesIteratorNode__getHashEntriesIterator_library__ = (this);
                        this.cache = this.cache == null ? ((arg0Value.context.getGuestToHostCache())) : this.cache;
                        this.state_1_ = state_1 = state_1 | 0b10 /* add-state_1 getHashEntriesIterator(HostProxy, InteropLibrary, GuestToHostCodeCache) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.getHashEntriesIterator(getHashEntriesIteratorNode__getHashEntriesIterator_library__, this.cache);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return HostProxy.identityHashCode((((HostProxy) receiver)));
            }

            private static boolean isIdenticalOrUndefinedFallbackGuard_(int state_0, HostProxy arg0Value, Object arg1Value) {
                if (((state_0 & 0b1)) == 0 /* is-not-state_0 doHostObject(HostProxy, HostProxy) */ && arg1Value instanceof HostProxy) {
                    return false;
                }
                return true;
            }

        }
        @GeneratedBy(HostProxy.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof HostProxy) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof HostProxy;
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
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                if (arg1Value instanceof HostProxy) {
                    HostProxy arg1Value_ = (HostProxy) arg1Value;
                    return IsIdenticalOrUndefined.doHostObject(arg0Value, arg1Value_);
                }
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isInstantiable(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .isInstantiable();
            }

            @TruffleBoundary
            @Override
            public Object instantiate(Object arg0Value_, Object... arg1Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.instantiate(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isExecutable(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .isExecutable();
            }

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.execute(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isPointer(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .isPointer();
            }

            @TruffleBoundary
            @Override
            public long asPointer(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.asPointer((this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean hasArrayElements(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .hasArrayElements();
            }

            @TruffleBoundary
            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.readArrayElement(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public void writeArrayElement(Object arg0Value_, long arg1Value, Object arg2Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                arg0Value.writeArrayElement(arg1Value, arg2Value, (this), (arg0Value.context.getGuestToHostCache()));
                return;
            }

            @TruffleBoundary
            @Override
            public void removeArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                arg0Value.removeArrayElement(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
                return;
            }

            @TruffleBoundary
            @Override
            public long getArraySize(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.getArraySize((this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isArrayElementExisting(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementModifiable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isArrayElementExisting(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementRemovable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isArrayElementExisting(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementInsertable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isArrayElementInsertable(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.getMembers(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.readMember(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                arg0Value.writeMember(arg1Value, arg2Value, (this), (arg0Value.context.getGuestToHostCache()));
                return;
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, UnsupportedTypeException, ArityException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.invokeMember(arg1Value, arg2Value, (this), (INTEROP_LIBRARY_.getUncached()), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isMemberInvocable(arg1Value, (this), (INTEROP_LIBRARY_.getUncached()), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public void removeMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                arg0Value.removeMember(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isMemberExisting(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isMemberExisting(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isMemberExisting(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isMemberInsertable(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isDate(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .isDate();
            }

            @TruffleBoundary
            @Override
            public boolean isTime(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .isTime();
            }

            @TruffleBoundary
            @Override
            public boolean isTimeZone(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .isTimeZone();
            }

            @TruffleBoundary
            @Override
            public ZoneId asTimeZone(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.asTimeZone((this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public LocalDate asDate(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.asDate((this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public LocalTime asTime(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.asTime((this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public Instant asInstant(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.asInstant((this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isDuration(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .isDuration();
            }

            @TruffleBoundary
            @Override
            public Duration asDuration(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.asDuration((this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public boolean hasMetaObject(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .hasMetaObject();
            }

            @TruffleBoundary
            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .getMetaObject();
            }

            @TruffleBoundary
            @Override
            public boolean hasIterator(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .hasIterator();
            }

            @TruffleBoundary
            @Override
            public Object getIterator(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.getIterator((this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isIterator(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .isIterator();
            }

            @TruffleBoundary
            @Override
            public boolean hasIteratorNextElement(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.hasIteratorNextElement((this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public Object getIteratorNextElement(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.getIteratorNextElement((this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean hasHashEntries(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostProxy) receiver) .hasHashEntries();
            }

            @TruffleBoundary
            @Override
            public long getHashSize(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.getHashSize((this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryReadable(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isHashValueExisting(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryModifiable(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isHashValueExisting(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryRemovable(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isHashValueExisting(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public Object readHashValue(Object arg0Value_, Object arg1Value) throws UnsupportedMessageException, UnknownKeyException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.readHashValue(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryInsertable(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.isHashEntryInsertable(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public void writeHashEntry(Object arg0Value_, Object arg1Value, Object arg2Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                arg0Value.writeHashEntry(arg1Value, arg2Value, (this), (arg0Value.context.getGuestToHostCache()));
                return;
            }

            @TruffleBoundary
            @Override
            public void removeHashEntry(Object arg0Value_, Object arg1Value) throws UnsupportedMessageException, UnknownKeyException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                arg0Value.removeHashEntry(arg1Value, (this), (arg0Value.context.getGuestToHostCache()));
                return;
            }

            @TruffleBoundary
            @Override
            public Object getHashEntriesIterator(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostProxy arg0Value = ((HostProxy) arg0Value_);
                return arg0Value.getHashEntriesIterator((this), (arg0Value.context.getGuestToHostCache()));
            }

            @TruffleBoundary
            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return HostProxy.identityHashCode(((HostProxy) receiver) );
            }

        }
    }
}
