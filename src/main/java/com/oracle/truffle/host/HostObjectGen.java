// CheckStyle: start generated
package com.oracle.truffle.host;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.ExceptionType;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.InvalidBufferOffsetException;
import com.oracle.truffle.api.interop.StopIterationException;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnknownKeyException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.api.utilities.TriState;
import com.oracle.truffle.host.HostContext.ToGuestValueNode;
import com.oracle.truffle.host.HostContextFactory.ToGuestValueNodeGen;
import com.oracle.truffle.host.HostObject.ArrayGet;
import com.oracle.truffle.host.HostObject.ArraySet;
import com.oracle.truffle.host.HostObject.ContainsKeyNode;
import com.oracle.truffle.host.HostObject.GetArraySize;
import com.oracle.truffle.host.HostObject.GetHashEntriesIterator;
import com.oracle.truffle.host.HostObject.GetHashSize;
import com.oracle.truffle.host.HostObject.GetIterator;
import com.oracle.truffle.host.HostObject.GetIteratorNextElement;
import com.oracle.truffle.host.HostObject.HasIteratorNextElement;
import com.oracle.truffle.host.HostObject.Instantiate;
import com.oracle.truffle.host.HostObject.IsArrayElementModifiable;
import com.oracle.truffle.host.HostObject.IsArrayElementReadable;
import com.oracle.truffle.host.HostObject.IsArrayElementRemovable;
import com.oracle.truffle.host.HostObject.IsArrayNode;
import com.oracle.truffle.host.HostObject.IsBufferNode;
import com.oracle.truffle.host.HostObject.IsIdenticalOrUndefined;
import com.oracle.truffle.host.HostObject.IsInstantiable;
import com.oracle.truffle.host.HostObject.IsIterableNode;
import com.oracle.truffle.host.HostObject.IsIteratorNode;
import com.oracle.truffle.host.HostObject.IsListNode;
import com.oracle.truffle.host.HostObject.IsMapEntryNode;
import com.oracle.truffle.host.HostObject.IsMapNode;
import com.oracle.truffle.host.HostObject.IsMemberInternal;
import com.oracle.truffle.host.HostObject.IsMemberInvocable;
import com.oracle.truffle.host.HostObject.IsMemberModifiable;
import com.oracle.truffle.host.HostObject.IsMemberReadable;
import com.oracle.truffle.host.HostObject.LookupConstructorNode;
import com.oracle.truffle.host.HostObject.LookupFieldNode;
import com.oracle.truffle.host.HostObject.LookupFunctionalMethodNode;
import com.oracle.truffle.host.HostObject.LookupInnerClassNode;
import com.oracle.truffle.host.HostObject.LookupMethodNode;
import com.oracle.truffle.host.HostObject.ReadArrayElement;
import com.oracle.truffle.host.HostObject.ReadFieldNode;
import com.oracle.truffle.host.HostObject.ReadHashValue;
import com.oracle.truffle.host.HostObject.RemoveArrayElement;
import com.oracle.truffle.host.HostObject.RemoveHashEntry;
import com.oracle.truffle.host.HostObject.WriteArrayElement;
import com.oracle.truffle.host.HostObject.WriteFieldNode;
import com.oracle.truffle.host.HostObject.WriteHashEntry;
import com.oracle.truffle.host.HostObjectFactory.ArrayGetNodeGen;
import com.oracle.truffle.host.HostObjectFactory.ArraySetNodeGen;
import com.oracle.truffle.host.HostObjectFactory.ContainsKeyNodeGen;
import com.oracle.truffle.host.HostObjectFactory.IsArrayNodeGen;
import com.oracle.truffle.host.HostObjectFactory.IsBufferNodeGen;
import com.oracle.truffle.host.HostObjectFactory.IsIterableNodeGen;
import com.oracle.truffle.host.HostObjectFactory.IsIteratorNodeGen;
import com.oracle.truffle.host.HostObjectFactory.IsListNodeGen;
import com.oracle.truffle.host.HostObjectFactory.IsMapEntryNodeGen;
import com.oracle.truffle.host.HostObjectFactory.IsMapNodeGen;
import com.oracle.truffle.host.HostObjectFactory.LookupConstructorNodeGen;
import com.oracle.truffle.host.HostObjectFactory.LookupFieldNodeGen;
import com.oracle.truffle.host.HostObjectFactory.LookupFunctionalMethodNodeGen;
import com.oracle.truffle.host.HostObjectFactory.LookupInnerClassNodeGen;
import com.oracle.truffle.host.HostObjectFactory.LookupMethodNodeGen;
import com.oracle.truffle.host.HostObjectFactory.ReadFieldNodeGen;
import com.oracle.truffle.host.HostObjectFactory.WriteFieldNodeGen;
import java.nio.ByteOrder;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HostObject.class)
@SuppressWarnings("unused")
final class HostObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(HostObject.class, new InteropLibraryExports());
    }

    private HostObjectGen() {
    }

    @GeneratedBy(HostObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, HostObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof HostObject;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof HostObject;
            return new Cached();
        }

        @GeneratedBy(HostObject.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int state_1_;
            @CompilationFinal private volatile int state_2_;
            @CompilationFinal private volatile int state_3_;
            @CompilationFinal private volatile int exclude_;
            @Child private IsArrayNode isArray;
            @Child private IsListNode isList;
            @CompilationFinal private BranchProfile error;
            @Child private IsMapEntryNode isMapEntry;
            @Child private HostToTypeNode toHost;
            @Child private ToGuestValueNode toGuest;
            @Child private LookupConstructorNode lookupConstructor;
            @Child private HostExecuteNode hostExecute;
            @Child private IsIterableNode isIterable;
            @Child private IsIteratorNode isIterator;
            @Child private IsMapNode isMap;
            @Child private LookupFieldNode lookupField;
            @Child private ReadFieldNode readField;
            @Child private LookupMethodNode lookupMethod;
            @Child private IsBufferNode isBuffer;
            @CompilationFinal private ValueProfile classProfile;
            @Child private LookupFunctionalMethodNode lookupFunctionalMethod;
            @Child private InteropLibrary numbers;
            @Child private ContainsKeyNode containsKey;
            @CompilationFinal private IsMemberReadableCachedData isMemberReadable_cached_cache;
            @CompilationFinal private IsMemberModifiableCachedData isMemberModifiable_cached_cache;
            @CompilationFinal private IsMemberInternalCachedData isMemberInternal_cached_cache;
            @CompilationFinal private IsMemberInvocableCachedData isMemberInvocable_cached_cache;
            @Child private ArraySet writeArrayElement_array_arraySet_;
            @Child private ArrayGet readArrayElement_array_arrayGet_;
            @Child private InteropLibrary instantiate_arrayCached_indexes_;
            @CompilationFinal private BranchProfile getIteratorNextElement_iterator_stopIteration_;
            @Child private LookupInnerClassNode readMemberNode__readMember_lookupInnerClass_;
            @Child private WriteFieldNode writeMemberNode__writeMember_writeField_;
            @Child private InteropLibrary invokeMemberNode__invokeMember_fieldValues_;

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof HostObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof HostObject;
            }

            @ExplodeLoop
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) != 0 /* is-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) || doUncached(HostObject, String) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */ && (arg0Value.isStaticClass())) {
                        IsMemberReadableCachedData s0_ = this.isMemberReadable_cached_cache;
                        while (s0_ != null) {
                            if ((arg0Value.isStaticClass() == s0_.cachedStatic_) && (arg0Value.getLookupClass() == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg1Value))) {
                                return IsMemberReadable.doCached(arg0Value, arg1Value, s0_.cachedStatic_, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedReadable_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(HostObject, String) */) {
                        return IsMemberReadable.doUncached(arg0Value, arg1Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberReadableAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberReadableAndSpecialize(HostObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if (((exclude & 0b1)) == 0 /* is-not-exclude doCached(HostObject, String, boolean, Class<>, String, boolean) */ && (arg0Value.isStaticClass())) {
                        int count0_ = 0;
                        IsMemberReadableCachedData s0_ = this.isMemberReadable_cached_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */) {
                            while (s0_ != null) {
                                if ((arg0Value.isStaticClass() == s0_.cachedStatic_) && (arg0Value.getLookupClass() == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                boolean cachedStatic__ = (arg0Value.isStaticClass());
                                if ((arg0Value.isStaticClass() == cachedStatic__)) {
                                    Class<?> cachedClazz__ = (arg0Value.getLookupClass());
                                    if ((arg0Value.getLookupClass() == cachedClazz__)) {
                                        // assert (s0_.cachedName_.equals(arg1Value));
                                        if (count0_ < (HostObject.LIMIT)) {
                                            s0_ = new IsMemberReadableCachedData(isMemberReadable_cached_cache);
                                            s0_.cachedStatic_ = cachedStatic__;
                                            s0_.cachedClazz_ = cachedClazz__;
                                            s0_.cachedName_ = (arg1Value);
                                            s0_.cachedReadable_ = (IsMemberReadable.doUncached(arg0Value, arg1Value));
                                            MemoryFence.storeStore();
                                            this.isMemberReadable_cached_cache = s0_;
                                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */;
                                        }
                                    }
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberReadable.doCached(arg0Value, arg1Value, s0_.cachedStatic_, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedReadable_);
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(HostObject, String, boolean, Class<>, String, boolean) */;
                    this.isMemberReadable_cached_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(HostObject, String) */;
                    lock.unlock();
                    hasLock = false;
                    return IsMemberReadable.doUncached(arg0Value, arg1Value);
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
                        IsMemberReadableCachedData s0_ = this.isMemberReadable_cached_cache;
                        if ((s0_ == null || s0_.next_ == null)) {
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1100) != 0 /* is-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) || doUncached(HostObject, String) */) {
                    if ((state_0 & 0b100) != 0 /* is-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */ && (arg0Value.isStaticClass())) {
                        IsMemberModifiableCachedData s0_ = this.isMemberModifiable_cached_cache;
                        while (s0_ != null) {
                            if ((arg0Value.isStaticClass() == s0_.cachedStatic_) && (arg0Value.getLookupClass() == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg1Value))) {
                                return IsMemberModifiable.doCached(arg0Value, arg1Value, s0_.cachedStatic_, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedModifiable_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doUncached(HostObject, String) */) {
                        return IsMemberModifiable.doUncached(arg0Value, arg1Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberModifiableAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberModifiableAndSpecialize(HostObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if (((exclude & 0b10)) == 0 /* is-not-exclude doCached(HostObject, String, boolean, Class<>, String, boolean) */ && (arg0Value.isStaticClass())) {
                        int count0_ = 0;
                        IsMemberModifiableCachedData s0_ = this.isMemberModifiable_cached_cache;
                        if ((state_0 & 0b100) != 0 /* is-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */) {
                            while (s0_ != null) {
                                if ((arg0Value.isStaticClass() == s0_.cachedStatic_) && (arg0Value.getLookupClass() == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                boolean cachedStatic__ = (arg0Value.isStaticClass());
                                if ((arg0Value.isStaticClass() == cachedStatic__)) {
                                    Class<?> cachedClazz__ = (arg0Value.getLookupClass());
                                    if ((arg0Value.getLookupClass() == cachedClazz__)) {
                                        // assert (s0_.cachedName_.equals(arg1Value));
                                        if (count0_ < (HostObject.LIMIT)) {
                                            s0_ = new IsMemberModifiableCachedData(isMemberModifiable_cached_cache);
                                            s0_.cachedStatic_ = cachedStatic__;
                                            s0_.cachedClazz_ = cachedClazz__;
                                            s0_.cachedName_ = (arg1Value);
                                            s0_.cachedModifiable_ = (IsMemberModifiable.doUncached(arg0Value, arg1Value));
                                            MemoryFence.storeStore();
                                            this.isMemberModifiable_cached_cache = s0_;
                                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */;
                                        }
                                    }
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberModifiable.doCached(arg0Value, arg1Value, s0_.cachedStatic_, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedModifiable_);
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b10 /* add-exclude doCached(HostObject, String, boolean, Class<>, String, boolean) */;
                    this.isMemberModifiable_cached_cache = null;
                    state_0 = state_0 & 0xfffffffb /* remove-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doUncached(HostObject, String) */;
                    lock.unlock();
                    hasLock = false;
                    return IsMemberModifiable.doUncached(arg0Value, arg1Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @ExplodeLoop
            @Override
            public boolean isMemberInternal(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b110000) != 0 /* is-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) || doUncached(HostObject, String) */) {
                    if ((state_0 & 0b10000) != 0 /* is-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */ && (arg0Value.isStaticClass())) {
                        IsMemberInternalCachedData s0_ = this.isMemberInternal_cached_cache;
                        while (s0_ != null) {
                            if ((arg0Value.isStaticClass() == s0_.cachedStatic_) && (arg0Value.getLookupClass() == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg1Value))) {
                                return IsMemberInternal.doCached(arg0Value, arg1Value, s0_.cachedStatic_, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedInternal_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 doUncached(HostObject, String) */) {
                        return IsMemberInternal.doUncached(arg0Value, arg1Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInternalAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInternalAndSpecialize(HostObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if (((exclude & 0b100)) == 0 /* is-not-exclude doCached(HostObject, String, boolean, Class<>, String, boolean) */ && (arg0Value.isStaticClass())) {
                        int count0_ = 0;
                        IsMemberInternalCachedData s0_ = this.isMemberInternal_cached_cache;
                        if ((state_0 & 0b10000) != 0 /* is-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */) {
                            while (s0_ != null) {
                                if ((arg0Value.isStaticClass() == s0_.cachedStatic_) && (arg0Value.getLookupClass() == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                boolean cachedStatic__ = (arg0Value.isStaticClass());
                                if ((arg0Value.isStaticClass() == cachedStatic__)) {
                                    Class<?> cachedClazz__ = (arg0Value.getLookupClass());
                                    if ((arg0Value.getLookupClass() == cachedClazz__)) {
                                        // assert (s0_.cachedName_.equals(arg1Value));
                                        if (count0_ < (HostObject.LIMIT)) {
                                            s0_ = new IsMemberInternalCachedData(isMemberInternal_cached_cache);
                                            s0_.cachedStatic_ = cachedStatic__;
                                            s0_.cachedClazz_ = cachedClazz__;
                                            s0_.cachedName_ = (arg1Value);
                                            s0_.cachedInternal_ = (IsMemberInternal.doUncached(arg0Value, arg1Value));
                                            MemoryFence.storeStore();
                                            this.isMemberInternal_cached_cache = s0_;
                                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */;
                                        }
                                    }
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberInternal.doCached(arg0Value, arg1Value, s0_.cachedStatic_, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedInternal_);
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b100 /* add-exclude doCached(HostObject, String, boolean, Class<>, String, boolean) */;
                    this.isMemberInternal_cached_cache = null;
                    state_0 = state_0 & 0xffffffef /* remove-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */;
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doUncached(HostObject, String) */;
                    lock.unlock();
                    hasLock = false;
                    return IsMemberInternal.doUncached(arg0Value, arg1Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @ExplodeLoop
            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b11000000) != 0 /* is-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) || doUncached(HostObject, String) */) {
                    if ((state_0 & 0b1000000) != 0 /* is-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */ && (arg0Value.isStaticClass())) {
                        IsMemberInvocableCachedData s0_ = this.isMemberInvocable_cached_cache;
                        while (s0_ != null) {
                            if ((arg0Value.isStaticClass() == s0_.cachedStatic_) && (arg0Value.getLookupClass() == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg1Value))) {
                                return IsMemberInvocable.doCached(arg0Value, arg1Value, s0_.cachedStatic_, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedInvokable_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10000000) != 0 /* is-state_0 doUncached(HostObject, String) */) {
                        return IsMemberInvocable.doUncached(arg0Value, arg1Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInvocableAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInvocableAndSpecialize(HostObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if (((exclude & 0b1000)) == 0 /* is-not-exclude doCached(HostObject, String, boolean, Class<>, String, boolean) */ && (arg0Value.isStaticClass())) {
                        int count0_ = 0;
                        IsMemberInvocableCachedData s0_ = this.isMemberInvocable_cached_cache;
                        if ((state_0 & 0b1000000) != 0 /* is-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */) {
                            while (s0_ != null) {
                                if ((arg0Value.isStaticClass() == s0_.cachedStatic_) && (arg0Value.getLookupClass() == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg1Value))) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                boolean cachedStatic__ = (arg0Value.isStaticClass());
                                if ((arg0Value.isStaticClass() == cachedStatic__)) {
                                    Class<?> cachedClazz__ = (arg0Value.getLookupClass());
                                    if ((arg0Value.getLookupClass() == cachedClazz__)) {
                                        // assert (s0_.cachedName_.equals(arg1Value));
                                        if (count0_ < (HostObject.LIMIT)) {
                                            s0_ = new IsMemberInvocableCachedData(isMemberInvocable_cached_cache);
                                            s0_.cachedStatic_ = cachedStatic__;
                                            s0_.cachedClazz_ = cachedClazz__;
                                            s0_.cachedName_ = (arg1Value);
                                            s0_.cachedInvokable_ = (IsMemberInvocable.doUncached(arg0Value, arg1Value));
                                            MemoryFence.storeStore();
                                            this.isMemberInvocable_cached_cache = s0_;
                                            this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */;
                                        }
                                    }
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMemberInvocable.doCached(arg0Value, arg1Value, s0_.cachedStatic_, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedInvokable_);
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b1000 /* add-exclude doCached(HostObject, String, boolean, Class<>, String, boolean) */;
                    this.isMemberInvocable_cached_cache = null;
                    state_0 = state_0 & 0xffffffbf /* remove-state_0 doCached(HostObject, String, boolean, Class<>, String, boolean) */;
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doUncached(HostObject, String) */;
                    lock.unlock();
                    hasLock = false;
                    return IsMemberInvocable.doUncached(arg0Value, arg1Value);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b111100000000) != 0 /* is-state_0 doArray(HostObject, long, IsArrayNode) || doList(HostObject, long, IsListNode, BranchProfile) || doMapEntry(HostObject, long, IsMapEntryNode) || doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                    if ((state_0 & 0b100000000) != 0 /* is-state_0 doArray(HostObject, long, IsArrayNode) */) {
                        if ((this.isArray.execute(arg0Value))) {
                            return IsArrayElementReadable.doArray(arg0Value, arg1Value, this.isArray);
                        }
                    }
                    if ((state_0 & 0b1000000000) != 0 /* is-state_0 doList(HostObject, long, IsListNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            return IsArrayElementReadable.doList(arg0Value, arg1Value, this.isList, this.error);
                        }
                    }
                    if ((state_0 & 0b10000000000) != 0 /* is-state_0 doMapEntry(HostObject, long, IsMapEntryNode) */) {
                        if ((this.isMapEntry.execute(arg0Value))) {
                            return IsArrayElementReadable.doMapEntry(arg0Value, arg1Value, this.isMapEntry);
                        }
                    }
                    if ((state_0 & 0b100000000000) != 0 /* is-state_0 doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                        if ((!(this.isList.execute(arg0Value))) && (!(this.isArray.execute(arg0Value))) && (!(this.isMapEntry.execute(arg0Value)))) {
                            return IsArrayElementReadable.doNotArrayOrList(arg0Value, arg1Value, this.isList, this.isArray, this.isMapEntry);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementReadableAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementReadableAndSpecialize(HostObject arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    boolean Array_duplicateFound_ = false;
                    if ((state_0 & 0b100000000) != 0 /* is-state_0 doArray(HostObject, long, IsArrayNode) */) {
                        if ((this.isArray.execute(arg0Value))) {
                            Array_duplicateFound_ = true;
                        }
                    }
                    if (!Array_duplicateFound_) {
                        {
                            IsArrayNode isArrayElementReadable_array_isArray__ = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                            if ((isArrayElementReadable_array_isArray__.execute(arg0Value)) && ((state_0 & 0b100000000)) == 0 /* is-not-state_0 doArray(HostObject, long, IsArrayNode) */) {
                                if (this.isArray == null) {
                                    IsArrayNode isArrayElementReadable_array_isArray___check = super.insert(isArrayElementReadable_array_isArray__);
                                    if (isArrayElementReadable_array_isArray___check == null) {
                                        throw new AssertionError("Specialization 'doArray(HostObject, long, IsArrayNode)' contains a shared cache with name 'isArray' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isArray = isArrayElementReadable_array_isArray___check;
                                }
                                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doArray(HostObject, long, IsArrayNode) */;
                                Array_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Array_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return IsArrayElementReadable.doArray(arg0Value, arg1Value, this.isArray);
                    }
                    boolean List_duplicateFound_ = false;
                    if ((state_0 & 0b1000000000) != 0 /* is-state_0 doList(HostObject, long, IsListNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            List_duplicateFound_ = true;
                        }
                    }
                    if (!List_duplicateFound_) {
                        {
                            IsListNode isArrayElementReadable_list_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                            if ((isArrayElementReadable_list_isList__.execute(arg0Value)) && ((state_0 & 0b1000000000)) == 0 /* is-not-state_0 doList(HostObject, long, IsListNode, BranchProfile) */) {
                                if (this.isList == null) {
                                    IsListNode isArrayElementReadable_list_isList___check = super.insert(isArrayElementReadable_list_isList__);
                                    if (isArrayElementReadable_list_isList___check == null) {
                                        throw new AssertionError("Specialization 'doList(HostObject, long, IsListNode, BranchProfile)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isList = isArrayElementReadable_list_isList___check;
                                }
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doList(HostObject, long, IsListNode, BranchProfile) */;
                                List_duplicateFound_ = true;
                            }
                        }
                    }
                    if (List_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return IsArrayElementReadable.doList(arg0Value, arg1Value, this.isList, this.error);
                    }
                    boolean MapEntry_duplicateFound_ = false;
                    if ((state_0 & 0b10000000000) != 0 /* is-state_0 doMapEntry(HostObject, long, IsMapEntryNode) */) {
                        if ((this.isMapEntry.execute(arg0Value))) {
                            MapEntry_duplicateFound_ = true;
                        }
                    }
                    if (!MapEntry_duplicateFound_) {
                        {
                            IsMapEntryNode isArrayElementReadable_mapEntry_isMapEntry__ = super.insert(this.isMapEntry == null ? ((IsMapEntryNodeGen.create())) : this.isMapEntry);
                            if ((isArrayElementReadable_mapEntry_isMapEntry__.execute(arg0Value)) && ((state_0 & 0b10000000000)) == 0 /* is-not-state_0 doMapEntry(HostObject, long, IsMapEntryNode) */) {
                                if (this.isMapEntry == null) {
                                    IsMapEntryNode isArrayElementReadable_mapEntry_isMapEntry___check = super.insert(isArrayElementReadable_mapEntry_isMapEntry__);
                                    if (isArrayElementReadable_mapEntry_isMapEntry___check == null) {
                                        throw new AssertionError("Specialization 'doMapEntry(HostObject, long, IsMapEntryNode)' contains a shared cache with name 'isMapEntry' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMapEntry = isArrayElementReadable_mapEntry_isMapEntry___check;
                                }
                                this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doMapEntry(HostObject, long, IsMapEntryNode) */;
                                MapEntry_duplicateFound_ = true;
                            }
                        }
                    }
                    if (MapEntry_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return IsArrayElementReadable.doMapEntry(arg0Value, arg1Value, this.isMapEntry);
                    }
                    boolean NotArrayOrList_duplicateFound_ = false;
                    if ((state_0 & 0b100000000000) != 0 /* is-state_0 doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                        if ((!(this.isList.execute(arg0Value))) && (!(this.isArray.execute(arg0Value))) && (!(this.isMapEntry.execute(arg0Value)))) {
                            NotArrayOrList_duplicateFound_ = true;
                        }
                    }
                    if (!NotArrayOrList_duplicateFound_) {
                        {
                            IsListNode isArrayElementReadable_notArrayOrList_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                            if ((!(isArrayElementReadable_notArrayOrList_isList__.execute(arg0Value)))) {
                                IsArrayNode isArrayElementReadable_notArrayOrList_isArray__ = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                                if ((!(isArrayElementReadable_notArrayOrList_isArray__.execute(arg0Value)))) {
                                    IsMapEntryNode isArrayElementReadable_notArrayOrList_isMapEntry__ = super.insert(this.isMapEntry == null ? ((IsMapEntryNodeGen.create())) : this.isMapEntry);
                                    if ((!(isArrayElementReadable_notArrayOrList_isMapEntry__.execute(arg0Value))) && ((state_0 & 0b100000000000)) == 0 /* is-not-state_0 doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                                        if (this.isList == null) {
                                            IsListNode isArrayElementReadable_notArrayOrList_isList___check = super.insert(isArrayElementReadable_notArrayOrList_isList__);
                                            if (isArrayElementReadable_notArrayOrList_isList___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isList = isArrayElementReadable_notArrayOrList_isList___check;
                                        }
                                        if (this.isArray == null) {
                                            IsArrayNode isArrayElementReadable_notArrayOrList_isArray___check = super.insert(isArrayElementReadable_notArrayOrList_isArray__);
                                            if (isArrayElementReadable_notArrayOrList_isArray___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode)' contains a shared cache with name 'isArray' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isArray = isArrayElementReadable_notArrayOrList_isArray___check;
                                        }
                                        if (this.isMapEntry == null) {
                                            IsMapEntryNode isArrayElementReadable_notArrayOrList_isMapEntry___check = super.insert(isArrayElementReadable_notArrayOrList_isMapEntry__);
                                            if (isArrayElementReadable_notArrayOrList_isMapEntry___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode)' contains a shared cache with name 'isMapEntry' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isMapEntry = isArrayElementReadable_notArrayOrList_isMapEntry___check;
                                        }
                                        this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode) */;
                                        NotArrayOrList_duplicateFound_ = true;
                                    }
                                }
                            }
                        }
                    }
                    if (NotArrayOrList_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return IsArrayElementReadable.doNotArrayOrList(arg0Value, arg1Value, this.isList, this.isArray, this.isMapEntry);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1111000000000000) != 0 /* is-state_0 doArray(HostObject, long, IsArrayNode) || doList(HostObject, long, IsListNode, BranchProfile) || doMapEntry(HostObject, long, IsMapEntryNode) || doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                    if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doArray(HostObject, long, IsArrayNode) */) {
                        if ((this.isArray.execute(arg0Value))) {
                            return IsArrayElementModifiable.doArray(arg0Value, arg1Value, this.isArray);
                        }
                    }
                    if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doList(HostObject, long, IsListNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            return IsArrayElementModifiable.doList(arg0Value, arg1Value, this.isList, this.error);
                        }
                    }
                    if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doMapEntry(HostObject, long, IsMapEntryNode) */) {
                        if ((this.isMapEntry.execute(arg0Value))) {
                            return IsArrayElementModifiable.doMapEntry(arg0Value, arg1Value, this.isMapEntry);
                        }
                    }
                    if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                        if ((!(this.isList.execute(arg0Value))) && (!(this.isArray.execute(arg0Value))) && (!(this.isMapEntry.execute(arg0Value)))) {
                            return IsArrayElementModifiable.doNotArrayOrList(arg0Value, arg1Value, this.isList, this.isArray, this.isMapEntry);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementModifiableAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementModifiableAndSpecialize(HostObject arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    boolean Array_duplicateFound_ = false;
                    if ((state_0 & 0b1000000000000) != 0 /* is-state_0 doArray(HostObject, long, IsArrayNode) */) {
                        if ((this.isArray.execute(arg0Value))) {
                            Array_duplicateFound_ = true;
                        }
                    }
                    if (!Array_duplicateFound_) {
                        {
                            IsArrayNode isArrayElementModifiable_array_isArray__ = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                            if ((isArrayElementModifiable_array_isArray__.execute(arg0Value)) && ((state_0 & 0b1000000000000)) == 0 /* is-not-state_0 doArray(HostObject, long, IsArrayNode) */) {
                                if (this.isArray == null) {
                                    IsArrayNode isArrayElementModifiable_array_isArray___check = super.insert(isArrayElementModifiable_array_isArray__);
                                    if (isArrayElementModifiable_array_isArray___check == null) {
                                        throw new AssertionError("Specialization 'doArray(HostObject, long, IsArrayNode)' contains a shared cache with name 'isArray' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isArray = isArrayElementModifiable_array_isArray___check;
                                }
                                this.state_0_ = state_0 = state_0 | 0b1000000000000 /* add-state_0 doArray(HostObject, long, IsArrayNode) */;
                                Array_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Array_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return IsArrayElementModifiable.doArray(arg0Value, arg1Value, this.isArray);
                    }
                    boolean List_duplicateFound_ = false;
                    if ((state_0 & 0b10000000000000) != 0 /* is-state_0 doList(HostObject, long, IsListNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            List_duplicateFound_ = true;
                        }
                    }
                    if (!List_duplicateFound_) {
                        {
                            IsListNode isArrayElementModifiable_list_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                            if ((isArrayElementModifiable_list_isList__.execute(arg0Value)) && ((state_0 & 0b10000000000000)) == 0 /* is-not-state_0 doList(HostObject, long, IsListNode, BranchProfile) */) {
                                if (this.isList == null) {
                                    IsListNode isArrayElementModifiable_list_isList___check = super.insert(isArrayElementModifiable_list_isList__);
                                    if (isArrayElementModifiable_list_isList___check == null) {
                                        throw new AssertionError("Specialization 'doList(HostObject, long, IsListNode, BranchProfile)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isList = isArrayElementModifiable_list_isList___check;
                                }
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_0_ = state_0 = state_0 | 0b10000000000000 /* add-state_0 doList(HostObject, long, IsListNode, BranchProfile) */;
                                List_duplicateFound_ = true;
                            }
                        }
                    }
                    if (List_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return IsArrayElementModifiable.doList(arg0Value, arg1Value, this.isList, this.error);
                    }
                    boolean MapEntry_duplicateFound_ = false;
                    if ((state_0 & 0b100000000000000) != 0 /* is-state_0 doMapEntry(HostObject, long, IsMapEntryNode) */) {
                        if ((this.isMapEntry.execute(arg0Value))) {
                            MapEntry_duplicateFound_ = true;
                        }
                    }
                    if (!MapEntry_duplicateFound_) {
                        {
                            IsMapEntryNode isArrayElementModifiable_mapEntry_isMapEntry__ = super.insert(this.isMapEntry == null ? ((IsMapEntryNodeGen.create())) : this.isMapEntry);
                            if ((isArrayElementModifiable_mapEntry_isMapEntry__.execute(arg0Value)) && ((state_0 & 0b100000000000000)) == 0 /* is-not-state_0 doMapEntry(HostObject, long, IsMapEntryNode) */) {
                                if (this.isMapEntry == null) {
                                    IsMapEntryNode isArrayElementModifiable_mapEntry_isMapEntry___check = super.insert(isArrayElementModifiable_mapEntry_isMapEntry__);
                                    if (isArrayElementModifiable_mapEntry_isMapEntry___check == null) {
                                        throw new AssertionError("Specialization 'doMapEntry(HostObject, long, IsMapEntryNode)' contains a shared cache with name 'isMapEntry' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMapEntry = isArrayElementModifiable_mapEntry_isMapEntry___check;
                                }
                                this.state_0_ = state_0 = state_0 | 0b100000000000000 /* add-state_0 doMapEntry(HostObject, long, IsMapEntryNode) */;
                                MapEntry_duplicateFound_ = true;
                            }
                        }
                    }
                    if (MapEntry_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return IsArrayElementModifiable.doMapEntry(arg0Value, arg1Value, this.isMapEntry);
                    }
                    boolean NotArrayOrList_duplicateFound_ = false;
                    if ((state_0 & 0b1000000000000000) != 0 /* is-state_0 doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                        if ((!(this.isList.execute(arg0Value))) && (!(this.isArray.execute(arg0Value))) && (!(this.isMapEntry.execute(arg0Value)))) {
                            NotArrayOrList_duplicateFound_ = true;
                        }
                    }
                    if (!NotArrayOrList_duplicateFound_) {
                        {
                            IsListNode isArrayElementModifiable_notArrayOrList_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                            if ((!(isArrayElementModifiable_notArrayOrList_isList__.execute(arg0Value)))) {
                                IsArrayNode isArrayElementModifiable_notArrayOrList_isArray__ = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                                if ((!(isArrayElementModifiable_notArrayOrList_isArray__.execute(arg0Value)))) {
                                    IsMapEntryNode isArrayElementModifiable_notArrayOrList_isMapEntry__ = super.insert(this.isMapEntry == null ? ((IsMapEntryNodeGen.create())) : this.isMapEntry);
                                    if ((!(isArrayElementModifiable_notArrayOrList_isMapEntry__.execute(arg0Value))) && ((state_0 & 0b1000000000000000)) == 0 /* is-not-state_0 doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                                        if (this.isList == null) {
                                            IsListNode isArrayElementModifiable_notArrayOrList_isList___check = super.insert(isArrayElementModifiable_notArrayOrList_isList__);
                                            if (isArrayElementModifiable_notArrayOrList_isList___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isList = isArrayElementModifiable_notArrayOrList_isList___check;
                                        }
                                        if (this.isArray == null) {
                                            IsArrayNode isArrayElementModifiable_notArrayOrList_isArray___check = super.insert(isArrayElementModifiable_notArrayOrList_isArray__);
                                            if (isArrayElementModifiable_notArrayOrList_isArray___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode)' contains a shared cache with name 'isArray' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isArray = isArrayElementModifiable_notArrayOrList_isArray___check;
                                        }
                                        if (this.isMapEntry == null) {
                                            IsMapEntryNode isArrayElementModifiable_notArrayOrList_isMapEntry___check = super.insert(isArrayElementModifiable_notArrayOrList_isMapEntry__);
                                            if (isArrayElementModifiable_notArrayOrList_isMapEntry___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode)' contains a shared cache with name 'isMapEntry' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isMapEntry = isArrayElementModifiable_notArrayOrList_isMapEntry___check;
                                        }
                                        this.state_0_ = state_0 = state_0 | 0b1000000000000000 /* add-state_0 doNotArrayOrList(HostObject, long, IsListNode, IsArrayNode, IsMapEntryNode) */;
                                        NotArrayOrList_duplicateFound_ = true;
                                    }
                                }
                            }
                        }
                    }
                    if (NotArrayOrList_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return IsArrayElementModifiable.doNotArrayOrList(arg0Value, arg1Value, this.isList, this.isArray, this.isMapEntry);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0xf0000) != 0 /* is-state_0 doArray(HostObject, long, Object, HostToTypeNode, IsArrayNode, ArraySet, BranchProfile) || doList(HostObject, long, Object, IsListNode, HostToTypeNode, BranchProfile) || doMapEntry(HostObject, long, Object, IsMapEntryNode, HostToTypeNode, BranchProfile) || doNotArrayOrList(HostObject, long, Object, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                    if ((state_0 & 0x10000) != 0 /* is-state_0 doArray(HostObject, long, Object, HostToTypeNode, IsArrayNode, ArraySet, BranchProfile) */) {
                        if ((this.isArray.execute(arg0Value))) {
                            WriteArrayElement.doArray(arg0Value, arg1Value, arg2Value, this.toHost, this.isArray, this.writeArrayElement_array_arraySet_, this.error);
                            return;
                        }
                    }
                    if ((state_0 & 0x20000) != 0 /* is-state_0 doList(HostObject, long, Object, IsListNode, HostToTypeNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            WriteArrayElement.doList(arg0Value, arg1Value, arg2Value, this.isList, this.toHost, this.error);
                            return;
                        }
                    }
                    if ((state_0 & 0x40000) != 0 /* is-state_0 doMapEntry(HostObject, long, Object, IsMapEntryNode, HostToTypeNode, BranchProfile) */) {
                        if ((this.isMapEntry.execute(arg0Value))) {
                            WriteArrayElement.doMapEntry(arg0Value, arg1Value, arg2Value, this.isMapEntry, this.toHost, this.error);
                            return;
                        }
                    }
                    if ((state_0 & 0x80000) != 0 /* is-state_0 doNotArrayOrList(HostObject, long, Object, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                        if ((!(this.isList.execute(arg0Value))) && (!(this.isArray.execute(arg0Value))) && (!(this.isMapEntry.execute(arg0Value)))) {
                            WriteArrayElement.doNotArrayOrList(arg0Value, arg1Value, arg2Value, this.isList, this.isArray, this.isMapEntry);
                            return;
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeArrayElementAndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeArrayElementAndSpecialize(HostObject arg0Value, long arg1Value, Object arg2Value) throws InvalidArrayIndexException, UnsupportedTypeException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    boolean Array_duplicateFound_ = false;
                    if ((state_0 & 0x10000) != 0 /* is-state_0 doArray(HostObject, long, Object, HostToTypeNode, IsArrayNode, ArraySet, BranchProfile) */) {
                        if ((this.isArray.execute(arg0Value))) {
                            Array_duplicateFound_ = true;
                        }
                    }
                    if (!Array_duplicateFound_) {
                        {
                            IsArrayNode writeArrayElement_array_isArray__ = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                            if ((writeArrayElement_array_isArray__.execute(arg0Value)) && ((state_0 & 0x10000)) == 0 /* is-not-state_0 doArray(HostObject, long, Object, HostToTypeNode, IsArrayNode, ArraySet, BranchProfile) */) {
                                this.toHost = super.insert(this.toHost == null ? ((HostToTypeNodeGen.create())) : this.toHost);
                                if (this.isArray == null) {
                                    IsArrayNode writeArrayElement_array_isArray___check = super.insert(writeArrayElement_array_isArray__);
                                    if (writeArrayElement_array_isArray___check == null) {
                                        throw new AssertionError("Specialization 'doArray(HostObject, long, Object, HostToTypeNode, IsArrayNode, ArraySet, BranchProfile)' contains a shared cache with name 'isArray' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isArray = writeArrayElement_array_isArray___check;
                                }
                                this.writeArrayElement_array_arraySet_ = super.insert((ArraySetNodeGen.create()));
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_0_ = state_0 = state_0 | 0x10000 /* add-state_0 doArray(HostObject, long, Object, HostToTypeNode, IsArrayNode, ArraySet, BranchProfile) */;
                                Array_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Array_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        WriteArrayElement.doArray(arg0Value, arg1Value, arg2Value, this.toHost, this.isArray, this.writeArrayElement_array_arraySet_, this.error);
                        return;
                    }
                    boolean List_duplicateFound_ = false;
                    if ((state_0 & 0x20000) != 0 /* is-state_0 doList(HostObject, long, Object, IsListNode, HostToTypeNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            List_duplicateFound_ = true;
                        }
                    }
                    if (!List_duplicateFound_) {
                        {
                            IsListNode writeArrayElement_list_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                            if ((writeArrayElement_list_isList__.execute(arg0Value)) && ((state_0 & 0x20000)) == 0 /* is-not-state_0 doList(HostObject, long, Object, IsListNode, HostToTypeNode, BranchProfile) */) {
                                if (this.isList == null) {
                                    IsListNode writeArrayElement_list_isList___check = super.insert(writeArrayElement_list_isList__);
                                    if (writeArrayElement_list_isList___check == null) {
                                        throw new AssertionError("Specialization 'doList(HostObject, long, Object, IsListNode, HostToTypeNode, BranchProfile)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isList = writeArrayElement_list_isList___check;
                                }
                                this.toHost = super.insert(this.toHost == null ? ((HostToTypeNodeGen.create())) : this.toHost);
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_0_ = state_0 = state_0 | 0x20000 /* add-state_0 doList(HostObject, long, Object, IsListNode, HostToTypeNode, BranchProfile) */;
                                List_duplicateFound_ = true;
                            }
                        }
                    }
                    if (List_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        WriteArrayElement.doList(arg0Value, arg1Value, arg2Value, this.isList, this.toHost, this.error);
                        return;
                    }
                    boolean MapEntry_duplicateFound_ = false;
                    if ((state_0 & 0x40000) != 0 /* is-state_0 doMapEntry(HostObject, long, Object, IsMapEntryNode, HostToTypeNode, BranchProfile) */) {
                        if ((this.isMapEntry.execute(arg0Value))) {
                            MapEntry_duplicateFound_ = true;
                        }
                    }
                    if (!MapEntry_duplicateFound_) {
                        {
                            IsMapEntryNode writeArrayElement_mapEntry_isMapEntry__ = super.insert(this.isMapEntry == null ? ((IsMapEntryNodeGen.create())) : this.isMapEntry);
                            if ((writeArrayElement_mapEntry_isMapEntry__.execute(arg0Value)) && ((state_0 & 0x40000)) == 0 /* is-not-state_0 doMapEntry(HostObject, long, Object, IsMapEntryNode, HostToTypeNode, BranchProfile) */) {
                                if (this.isMapEntry == null) {
                                    IsMapEntryNode writeArrayElement_mapEntry_isMapEntry___check = super.insert(writeArrayElement_mapEntry_isMapEntry__);
                                    if (writeArrayElement_mapEntry_isMapEntry___check == null) {
                                        throw new AssertionError("Specialization 'doMapEntry(HostObject, long, Object, IsMapEntryNode, HostToTypeNode, BranchProfile)' contains a shared cache with name 'isMapEntry' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMapEntry = writeArrayElement_mapEntry_isMapEntry___check;
                                }
                                this.toHost = super.insert(this.toHost == null ? ((HostToTypeNodeGen.create())) : this.toHost);
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_0_ = state_0 = state_0 | 0x40000 /* add-state_0 doMapEntry(HostObject, long, Object, IsMapEntryNode, HostToTypeNode, BranchProfile) */;
                                MapEntry_duplicateFound_ = true;
                            }
                        }
                    }
                    if (MapEntry_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        WriteArrayElement.doMapEntry(arg0Value, arg1Value, arg2Value, this.isMapEntry, this.toHost, this.error);
                        return;
                    }
                    boolean NotArrayOrList_duplicateFound_ = false;
                    if ((state_0 & 0x80000) != 0 /* is-state_0 doNotArrayOrList(HostObject, long, Object, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                        if ((!(this.isList.execute(arg0Value))) && (!(this.isArray.execute(arg0Value))) && (!(this.isMapEntry.execute(arg0Value)))) {
                            NotArrayOrList_duplicateFound_ = true;
                        }
                    }
                    if (!NotArrayOrList_duplicateFound_) {
                        {
                            IsListNode writeArrayElement_notArrayOrList_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                            if ((!(writeArrayElement_notArrayOrList_isList__.execute(arg0Value)))) {
                                IsArrayNode writeArrayElement_notArrayOrList_isArray__ = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                                if ((!(writeArrayElement_notArrayOrList_isArray__.execute(arg0Value)))) {
                                    IsMapEntryNode writeArrayElement_notArrayOrList_isMapEntry__ = super.insert(this.isMapEntry == null ? ((IsMapEntryNodeGen.create())) : this.isMapEntry);
                                    if ((!(writeArrayElement_notArrayOrList_isMapEntry__.execute(arg0Value))) && ((state_0 & 0x80000)) == 0 /* is-not-state_0 doNotArrayOrList(HostObject, long, Object, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                                        if (this.isList == null) {
                                            IsListNode writeArrayElement_notArrayOrList_isList___check = super.insert(writeArrayElement_notArrayOrList_isList__);
                                            if (writeArrayElement_notArrayOrList_isList___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, long, Object, IsListNode, IsArrayNode, IsMapEntryNode)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isList = writeArrayElement_notArrayOrList_isList___check;
                                        }
                                        if (this.isArray == null) {
                                            IsArrayNode writeArrayElement_notArrayOrList_isArray___check = super.insert(writeArrayElement_notArrayOrList_isArray__);
                                            if (writeArrayElement_notArrayOrList_isArray___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, long, Object, IsListNode, IsArrayNode, IsMapEntryNode)' contains a shared cache with name 'isArray' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isArray = writeArrayElement_notArrayOrList_isArray___check;
                                        }
                                        if (this.isMapEntry == null) {
                                            IsMapEntryNode writeArrayElement_notArrayOrList_isMapEntry___check = super.insert(writeArrayElement_notArrayOrList_isMapEntry__);
                                            if (writeArrayElement_notArrayOrList_isMapEntry___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, long, Object, IsListNode, IsArrayNode, IsMapEntryNode)' contains a shared cache with name 'isMapEntry' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isMapEntry = writeArrayElement_notArrayOrList_isMapEntry___check;
                                        }
                                        this.state_0_ = state_0 = state_0 | 0x80000 /* add-state_0 doNotArrayOrList(HostObject, long, Object, IsListNode, IsArrayNode, IsMapEntryNode) */;
                                        NotArrayOrList_duplicateFound_ = true;
                                    }
                                }
                            }
                        }
                    }
                    if (NotArrayOrList_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        WriteArrayElement.doNotArrayOrList(arg0Value, arg1Value, arg2Value, this.isList, this.isArray, this.isMapEntry);
                        return;
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementRemovable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0x300000) != 0 /* is-state_0 doList(HostObject, long, IsListNode, BranchProfile) || doOther(HostObject, long, IsListNode) */) {
                    if ((state_0 & 0x100000) != 0 /* is-state_0 doList(HostObject, long, IsListNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            return IsArrayElementRemovable.doList(arg0Value, arg1Value, this.isList, this.error);
                        }
                    }
                    if ((state_0 & 0x200000) != 0 /* is-state_0 doOther(HostObject, long, IsListNode) */) {
                        if ((!(this.isList.execute(arg0Value)))) {
                            return IsArrayElementRemovable.doOther(arg0Value, arg1Value, this.isList);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementRemovableAndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementRemovableAndSpecialize(HostObject arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    boolean List_duplicateFound_ = false;
                    if ((state_0 & 0x100000) != 0 /* is-state_0 doList(HostObject, long, IsListNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            List_duplicateFound_ = true;
                        }
                    }
                    if (!List_duplicateFound_) {
                        {
                            IsListNode isArrayElementRemovable_list_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                            if ((isArrayElementRemovable_list_isList__.execute(arg0Value)) && ((state_0 & 0x100000)) == 0 /* is-not-state_0 doList(HostObject, long, IsListNode, BranchProfile) */) {
                                if (this.isList == null) {
                                    IsListNode isArrayElementRemovable_list_isList___check = super.insert(isArrayElementRemovable_list_isList__);
                                    if (isArrayElementRemovable_list_isList___check == null) {
                                        throw new AssertionError("Specialization 'doList(HostObject, long, IsListNode, BranchProfile)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isList = isArrayElementRemovable_list_isList___check;
                                }
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_0_ = state_0 = state_0 | 0x100000 /* add-state_0 doList(HostObject, long, IsListNode, BranchProfile) */;
                                List_duplicateFound_ = true;
                            }
                        }
                    }
                    if (List_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return IsArrayElementRemovable.doList(arg0Value, arg1Value, this.isList, this.error);
                    }
                    boolean Other_duplicateFound_ = false;
                    if ((state_0 & 0x200000) != 0 /* is-state_0 doOther(HostObject, long, IsListNode) */) {
                        if ((!(this.isList.execute(arg0Value)))) {
                            Other_duplicateFound_ = true;
                        }
                    }
                    if (!Other_duplicateFound_) {
                        {
                            IsListNode isArrayElementRemovable_other_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                            if ((!(isArrayElementRemovable_other_isList__.execute(arg0Value))) && ((state_0 & 0x200000)) == 0 /* is-not-state_0 doOther(HostObject, long, IsListNode) */) {
                                if (this.isList == null) {
                                    IsListNode isArrayElementRemovable_other_isList___check = super.insert(isArrayElementRemovable_other_isList__);
                                    if (isArrayElementRemovable_other_isList___check == null) {
                                        throw new AssertionError("Specialization 'doOther(HostObject, long, IsListNode)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isList = isArrayElementRemovable_other_isList___check;
                                }
                                this.state_0_ = state_0 = state_0 | 0x200000 /* add-state_0 doOther(HostObject, long, IsListNode) */;
                                Other_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Other_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return IsArrayElementRemovable.doOther(arg0Value, arg1Value, this.isList);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0xc00000) != 0 /* is-state_0 doList(HostObject, long, IsListNode, BranchProfile) || doOther(HostObject, long, IsListNode) */) {
                    if ((state_0 & 0x400000) != 0 /* is-state_0 doList(HostObject, long, IsListNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            RemoveArrayElement.doList(arg0Value, arg1Value, this.isList, this.error);
                            return;
                        }
                    }
                    if ((state_0 & 0x800000) != 0 /* is-state_0 doOther(HostObject, long, IsListNode) */) {
                        if ((!(this.isList.execute(arg0Value)))) {
                            RemoveArrayElement.doOther(arg0Value, arg1Value, this.isList);
                            return;
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                removeArrayElementAndSpecialize(arg0Value, arg1Value);
                return;
            }

            private void removeArrayElementAndSpecialize(HostObject arg0Value, long arg1Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    boolean List_duplicateFound_ = false;
                    if ((state_0 & 0x400000) != 0 /* is-state_0 doList(HostObject, long, IsListNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            List_duplicateFound_ = true;
                        }
                    }
                    if (!List_duplicateFound_) {
                        {
                            IsListNode removeArrayElement_list_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                            if ((removeArrayElement_list_isList__.execute(arg0Value)) && ((state_0 & 0x400000)) == 0 /* is-not-state_0 doList(HostObject, long, IsListNode, BranchProfile) */) {
                                if (this.isList == null) {
                                    IsListNode removeArrayElement_list_isList___check = super.insert(removeArrayElement_list_isList__);
                                    if (removeArrayElement_list_isList___check == null) {
                                        throw new AssertionError("Specialization 'doList(HostObject, long, IsListNode, BranchProfile)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isList = removeArrayElement_list_isList___check;
                                }
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_0_ = state_0 = state_0 | 0x400000 /* add-state_0 doList(HostObject, long, IsListNode, BranchProfile) */;
                                List_duplicateFound_ = true;
                            }
                        }
                    }
                    if (List_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        RemoveArrayElement.doList(arg0Value, arg1Value, this.isList, this.error);
                        return;
                    }
                    boolean Other_duplicateFound_ = false;
                    if ((state_0 & 0x800000) != 0 /* is-state_0 doOther(HostObject, long, IsListNode) */) {
                        if ((!(this.isList.execute(arg0Value)))) {
                            Other_duplicateFound_ = true;
                        }
                    }
                    if (!Other_duplicateFound_) {
                        {
                            IsListNode removeArrayElement_other_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                            if ((!(removeArrayElement_other_isList__.execute(arg0Value))) && ((state_0 & 0x800000)) == 0 /* is-not-state_0 doOther(HostObject, long, IsListNode) */) {
                                if (this.isList == null) {
                                    IsListNode removeArrayElement_other_isList___check = super.insert(removeArrayElement_other_isList__);
                                    if (removeArrayElement_other_isList___check == null) {
                                        throw new AssertionError("Specialization 'doOther(HostObject, long, IsListNode)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isList = removeArrayElement_other_isList___check;
                                }
                                this.state_0_ = state_0 = state_0 | 0x800000 /* add-state_0 doOther(HostObject, long, IsListNode) */;
                                Other_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Other_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        RemoveArrayElement.doOther(arg0Value, arg1Value, this.isList);
                        return;
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0xf000000) != 0 /* is-state_0 doArray(HostObject, long, ArrayGet, IsArrayNode, ToGuestValueNode, BranchProfile) || doList(HostObject, long, IsListNode, ToGuestValueNode, BranchProfile) || doMapEntry(HostObject, long, IsMapEntryNode, ToGuestValueNode, BranchProfile) || doNotArrayOrList(HostObject, long, IsArrayNode, IsListNode, IsMapEntryNode) */) {
                    if ((state_0 & 0x1000000) != 0 /* is-state_0 doArray(HostObject, long, ArrayGet, IsArrayNode, ToGuestValueNode, BranchProfile) */) {
                        if ((this.isArray.execute(arg0Value))) {
                            return ReadArrayElement.doArray(arg0Value, arg1Value, this.readArrayElement_array_arrayGet_, this.isArray, this.toGuest, this.error);
                        }
                    }
                    if ((state_0 & 0x2000000) != 0 /* is-state_0 doList(HostObject, long, IsListNode, ToGuestValueNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            return ReadArrayElement.doList(arg0Value, arg1Value, this.isList, this.toGuest, this.error);
                        }
                    }
                    if ((state_0 & 0x4000000) != 0 /* is-state_0 doMapEntry(HostObject, long, IsMapEntryNode, ToGuestValueNode, BranchProfile) */) {
                        if ((this.isMapEntry.execute(arg0Value))) {
                            return ReadArrayElement.doMapEntry(arg0Value, arg1Value, this.isMapEntry, this.toGuest, this.error);
                        }
                    }
                    if ((state_0 & 0x8000000) != 0 /* is-state_0 doNotArrayOrList(HostObject, long, IsArrayNode, IsListNode, IsMapEntryNode) */) {
                        if ((!(this.isArray.execute(arg0Value))) && (!(this.isList.execute(arg0Value))) && (!(this.isMapEntry.execute(arg0Value)))) {
                            return ReadArrayElement.doNotArrayOrList(arg0Value, arg1Value, this.isArray, this.isList, this.isMapEntry);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readArrayElementAndSpecialize(arg0Value, arg1Value);
            }

            private Object readArrayElementAndSpecialize(HostObject arg0Value, long arg1Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    boolean Array_duplicateFound_ = false;
                    if ((state_0 & 0x1000000) != 0 /* is-state_0 doArray(HostObject, long, ArrayGet, IsArrayNode, ToGuestValueNode, BranchProfile) */) {
                        if ((this.isArray.execute(arg0Value))) {
                            Array_duplicateFound_ = true;
                        }
                    }
                    if (!Array_duplicateFound_) {
                        {
                            IsArrayNode readArrayElement_array_isArray__ = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                            if ((readArrayElement_array_isArray__.execute(arg0Value)) && ((state_0 & 0x1000000)) == 0 /* is-not-state_0 doArray(HostObject, long, ArrayGet, IsArrayNode, ToGuestValueNode, BranchProfile) */) {
                                this.readArrayElement_array_arrayGet_ = super.insert((ArrayGetNodeGen.create()));
                                if (this.isArray == null) {
                                    IsArrayNode readArrayElement_array_isArray___check = super.insert(readArrayElement_array_isArray__);
                                    if (readArrayElement_array_isArray___check == null) {
                                        throw new AssertionError("Specialization 'doArray(HostObject, long, ArrayGet, IsArrayNode, ToGuestValueNode, BranchProfile)' contains a shared cache with name 'isArray' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isArray = readArrayElement_array_isArray___check;
                                }
                                this.toGuest = super.insert(this.toGuest == null ? ((ToGuestValueNodeGen.create())) : this.toGuest);
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_0_ = state_0 = state_0 | 0x1000000 /* add-state_0 doArray(HostObject, long, ArrayGet, IsArrayNode, ToGuestValueNode, BranchProfile) */;
                                Array_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Array_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return ReadArrayElement.doArray(arg0Value, arg1Value, this.readArrayElement_array_arrayGet_, this.isArray, this.toGuest, this.error);
                    }
                    boolean List_duplicateFound_ = false;
                    if ((state_0 & 0x2000000) != 0 /* is-state_0 doList(HostObject, long, IsListNode, ToGuestValueNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            List_duplicateFound_ = true;
                        }
                    }
                    if (!List_duplicateFound_) {
                        {
                            IsListNode readArrayElement_list_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                            if ((readArrayElement_list_isList__.execute(arg0Value)) && ((state_0 & 0x2000000)) == 0 /* is-not-state_0 doList(HostObject, long, IsListNode, ToGuestValueNode, BranchProfile) */) {
                                if (this.isList == null) {
                                    IsListNode readArrayElement_list_isList___check = super.insert(readArrayElement_list_isList__);
                                    if (readArrayElement_list_isList___check == null) {
                                        throw new AssertionError("Specialization 'doList(HostObject, long, IsListNode, ToGuestValueNode, BranchProfile)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isList = readArrayElement_list_isList___check;
                                }
                                this.toGuest = super.insert(this.toGuest == null ? ((ToGuestValueNodeGen.create())) : this.toGuest);
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_0_ = state_0 = state_0 | 0x2000000 /* add-state_0 doList(HostObject, long, IsListNode, ToGuestValueNode, BranchProfile) */;
                                List_duplicateFound_ = true;
                            }
                        }
                    }
                    if (List_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return ReadArrayElement.doList(arg0Value, arg1Value, this.isList, this.toGuest, this.error);
                    }
                    boolean MapEntry_duplicateFound_ = false;
                    if ((state_0 & 0x4000000) != 0 /* is-state_0 doMapEntry(HostObject, long, IsMapEntryNode, ToGuestValueNode, BranchProfile) */) {
                        if ((this.isMapEntry.execute(arg0Value))) {
                            MapEntry_duplicateFound_ = true;
                        }
                    }
                    if (!MapEntry_duplicateFound_) {
                        {
                            IsMapEntryNode readArrayElement_mapEntry_isMapEntry__ = super.insert(this.isMapEntry == null ? ((IsMapEntryNodeGen.create())) : this.isMapEntry);
                            if ((readArrayElement_mapEntry_isMapEntry__.execute(arg0Value)) && ((state_0 & 0x4000000)) == 0 /* is-not-state_0 doMapEntry(HostObject, long, IsMapEntryNode, ToGuestValueNode, BranchProfile) */) {
                                if (this.isMapEntry == null) {
                                    IsMapEntryNode readArrayElement_mapEntry_isMapEntry___check = super.insert(readArrayElement_mapEntry_isMapEntry__);
                                    if (readArrayElement_mapEntry_isMapEntry___check == null) {
                                        throw new AssertionError("Specialization 'doMapEntry(HostObject, long, IsMapEntryNode, ToGuestValueNode, BranchProfile)' contains a shared cache with name 'isMapEntry' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMapEntry = readArrayElement_mapEntry_isMapEntry___check;
                                }
                                this.toGuest = super.insert(this.toGuest == null ? ((ToGuestValueNodeGen.create())) : this.toGuest);
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_0_ = state_0 = state_0 | 0x4000000 /* add-state_0 doMapEntry(HostObject, long, IsMapEntryNode, ToGuestValueNode, BranchProfile) */;
                                MapEntry_duplicateFound_ = true;
                            }
                        }
                    }
                    if (MapEntry_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return ReadArrayElement.doMapEntry(arg0Value, arg1Value, this.isMapEntry, this.toGuest, this.error);
                    }
                    boolean NotArrayOrList_duplicateFound_ = false;
                    if ((state_0 & 0x8000000) != 0 /* is-state_0 doNotArrayOrList(HostObject, long, IsArrayNode, IsListNode, IsMapEntryNode) */) {
                        if ((!(this.isArray.execute(arg0Value))) && (!(this.isList.execute(arg0Value))) && (!(this.isMapEntry.execute(arg0Value)))) {
                            NotArrayOrList_duplicateFound_ = true;
                        }
                    }
                    if (!NotArrayOrList_duplicateFound_) {
                        {
                            IsArrayNode readArrayElement_notArrayOrList_isArray__ = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                            if ((!(readArrayElement_notArrayOrList_isArray__.execute(arg0Value)))) {
                                IsListNode readArrayElement_notArrayOrList_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                                if ((!(readArrayElement_notArrayOrList_isList__.execute(arg0Value)))) {
                                    IsMapEntryNode readArrayElement_notArrayOrList_isMapEntry__ = super.insert(this.isMapEntry == null ? ((IsMapEntryNodeGen.create())) : this.isMapEntry);
                                    if ((!(readArrayElement_notArrayOrList_isMapEntry__.execute(arg0Value))) && ((state_0 & 0x8000000)) == 0 /* is-not-state_0 doNotArrayOrList(HostObject, long, IsArrayNode, IsListNode, IsMapEntryNode) */) {
                                        if (this.isArray == null) {
                                            IsArrayNode readArrayElement_notArrayOrList_isArray___check = super.insert(readArrayElement_notArrayOrList_isArray__);
                                            if (readArrayElement_notArrayOrList_isArray___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, long, IsArrayNode, IsListNode, IsMapEntryNode)' contains a shared cache with name 'isArray' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isArray = readArrayElement_notArrayOrList_isArray___check;
                                        }
                                        if (this.isList == null) {
                                            IsListNode readArrayElement_notArrayOrList_isList___check = super.insert(readArrayElement_notArrayOrList_isList__);
                                            if (readArrayElement_notArrayOrList_isList___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, long, IsArrayNode, IsListNode, IsMapEntryNode)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isList = readArrayElement_notArrayOrList_isList___check;
                                        }
                                        if (this.isMapEntry == null) {
                                            IsMapEntryNode readArrayElement_notArrayOrList_isMapEntry___check = super.insert(readArrayElement_notArrayOrList_isMapEntry__);
                                            if (readArrayElement_notArrayOrList_isMapEntry___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, long, IsArrayNode, IsListNode, IsMapEntryNode)' contains a shared cache with name 'isMapEntry' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isMapEntry = readArrayElement_notArrayOrList_isMapEntry___check;
                                        }
                                        this.state_0_ = state_0 = state_0 | 0x8000000 /* add-state_0 doNotArrayOrList(HostObject, long, IsArrayNode, IsListNode, IsMapEntryNode) */;
                                        NotArrayOrList_duplicateFound_ = true;
                                    }
                                }
                            }
                        }
                    }
                    if (NotArrayOrList_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return ReadArrayElement.doNotArrayOrList(arg0Value, arg1Value, this.isArray, this.isList, this.isMapEntry);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0xf0000000) != 0 /* is-state_0 doArray(HostObject, IsArrayNode) || doList(HostObject, IsListNode, BranchProfile) || doMapEntry(HostObject, IsMapEntryNode) || doNotArrayOrList(HostObject, IsArrayNode, IsListNode, IsMapEntryNode) */) {
                    if ((state_0 & 0x10000000) != 0 /* is-state_0 doArray(HostObject, IsArrayNode) */) {
                        if ((this.isArray.execute(arg0Value))) {
                            return GetArraySize.doArray(arg0Value, this.isArray);
                        }
                    }
                    if ((state_0 & 0x20000000) != 0 /* is-state_0 doList(HostObject, IsListNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            return GetArraySize.doList(arg0Value, this.isList, this.error);
                        }
                    }
                    if ((state_0 & 0x40000000) != 0 /* is-state_0 doMapEntry(HostObject, IsMapEntryNode) */) {
                        if ((this.isMapEntry.execute(arg0Value))) {
                            return GetArraySize.doMapEntry(arg0Value, this.isMapEntry);
                        }
                    }
                    if ((state_0 & 0x80000000) != 0 /* is-state_0 doNotArrayOrList(HostObject, IsArrayNode, IsListNode, IsMapEntryNode) */) {
                        if ((!(this.isArray.execute(arg0Value))) && (!(this.isList.execute(arg0Value))) && (!(this.isMapEntry.execute(arg0Value)))) {
                            return GetArraySize.doNotArrayOrList(arg0Value, this.isArray, this.isList, this.isMapEntry);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getArraySizeAndSpecialize(arg0Value);
            }

            private long getArraySizeAndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    boolean Array_duplicateFound_ = false;
                    if ((state_0 & 0x10000000) != 0 /* is-state_0 doArray(HostObject, IsArrayNode) */) {
                        if ((this.isArray.execute(arg0Value))) {
                            Array_duplicateFound_ = true;
                        }
                    }
                    if (!Array_duplicateFound_) {
                        {
                            IsArrayNode getArraySize_array_isArray__ = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                            if ((getArraySize_array_isArray__.execute(arg0Value)) && ((state_0 & 0x10000000)) == 0 /* is-not-state_0 doArray(HostObject, IsArrayNode) */) {
                                if (this.isArray == null) {
                                    IsArrayNode getArraySize_array_isArray___check = super.insert(getArraySize_array_isArray__);
                                    if (getArraySize_array_isArray___check == null) {
                                        throw new AssertionError("Specialization 'doArray(HostObject, IsArrayNode)' contains a shared cache with name 'isArray' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isArray = getArraySize_array_isArray___check;
                                }
                                this.state_0_ = state_0 = state_0 | 0x10000000 /* add-state_0 doArray(HostObject, IsArrayNode) */;
                                Array_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Array_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetArraySize.doArray(arg0Value, this.isArray);
                    }
                    boolean List_duplicateFound_ = false;
                    if ((state_0 & 0x20000000) != 0 /* is-state_0 doList(HostObject, IsListNode, BranchProfile) */) {
                        if ((this.isList.execute(arg0Value))) {
                            List_duplicateFound_ = true;
                        }
                    }
                    if (!List_duplicateFound_) {
                        {
                            IsListNode getArraySize_list_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                            if ((getArraySize_list_isList__.execute(arg0Value)) && ((state_0 & 0x20000000)) == 0 /* is-not-state_0 doList(HostObject, IsListNode, BranchProfile) */) {
                                if (this.isList == null) {
                                    IsListNode getArraySize_list_isList___check = super.insert(getArraySize_list_isList__);
                                    if (getArraySize_list_isList___check == null) {
                                        throw new AssertionError("Specialization 'doList(HostObject, IsListNode, BranchProfile)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isList = getArraySize_list_isList___check;
                                }
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_0_ = state_0 = state_0 | 0x20000000 /* add-state_0 doList(HostObject, IsListNode, BranchProfile) */;
                                List_duplicateFound_ = true;
                            }
                        }
                    }
                    if (List_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetArraySize.doList(arg0Value, this.isList, this.error);
                    }
                    boolean MapEntry_duplicateFound_ = false;
                    if ((state_0 & 0x40000000) != 0 /* is-state_0 doMapEntry(HostObject, IsMapEntryNode) */) {
                        if ((this.isMapEntry.execute(arg0Value))) {
                            MapEntry_duplicateFound_ = true;
                        }
                    }
                    if (!MapEntry_duplicateFound_) {
                        {
                            IsMapEntryNode getArraySize_mapEntry_isMapEntry__ = super.insert(this.isMapEntry == null ? ((IsMapEntryNodeGen.create())) : this.isMapEntry);
                            if ((getArraySize_mapEntry_isMapEntry__.execute(arg0Value)) && ((state_0 & 0x40000000)) == 0 /* is-not-state_0 doMapEntry(HostObject, IsMapEntryNode) */) {
                                if (this.isMapEntry == null) {
                                    IsMapEntryNode getArraySize_mapEntry_isMapEntry___check = super.insert(getArraySize_mapEntry_isMapEntry__);
                                    if (getArraySize_mapEntry_isMapEntry___check == null) {
                                        throw new AssertionError("Specialization 'doMapEntry(HostObject, IsMapEntryNode)' contains a shared cache with name 'isMapEntry' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMapEntry = getArraySize_mapEntry_isMapEntry___check;
                                }
                                this.state_0_ = state_0 = state_0 | 0x40000000 /* add-state_0 doMapEntry(HostObject, IsMapEntryNode) */;
                                MapEntry_duplicateFound_ = true;
                            }
                        }
                    }
                    if (MapEntry_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetArraySize.doMapEntry(arg0Value, this.isMapEntry);
                    }
                    boolean NotArrayOrList_duplicateFound_ = false;
                    if ((state_0 & 0x80000000) != 0 /* is-state_0 doNotArrayOrList(HostObject, IsArrayNode, IsListNode, IsMapEntryNode) */) {
                        if ((!(this.isArray.execute(arg0Value))) && (!(this.isList.execute(arg0Value))) && (!(this.isMapEntry.execute(arg0Value)))) {
                            NotArrayOrList_duplicateFound_ = true;
                        }
                    }
                    if (!NotArrayOrList_duplicateFound_) {
                        {
                            IsArrayNode getArraySize_notArrayOrList_isArray__ = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                            if ((!(getArraySize_notArrayOrList_isArray__.execute(arg0Value)))) {
                                IsListNode getArraySize_notArrayOrList_isList__ = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                                if ((!(getArraySize_notArrayOrList_isList__.execute(arg0Value)))) {
                                    IsMapEntryNode getArraySize_notArrayOrList_isMapEntry__ = super.insert(this.isMapEntry == null ? ((IsMapEntryNodeGen.create())) : this.isMapEntry);
                                    if ((!(getArraySize_notArrayOrList_isMapEntry__.execute(arg0Value))) && ((state_0 & 0x80000000)) == 0 /* is-not-state_0 doNotArrayOrList(HostObject, IsArrayNode, IsListNode, IsMapEntryNode) */) {
                                        if (this.isArray == null) {
                                            IsArrayNode getArraySize_notArrayOrList_isArray___check = super.insert(getArraySize_notArrayOrList_isArray__);
                                            if (getArraySize_notArrayOrList_isArray___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, IsArrayNode, IsListNode, IsMapEntryNode)' contains a shared cache with name 'isArray' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isArray = getArraySize_notArrayOrList_isArray___check;
                                        }
                                        if (this.isList == null) {
                                            IsListNode getArraySize_notArrayOrList_isList___check = super.insert(getArraySize_notArrayOrList_isList__);
                                            if (getArraySize_notArrayOrList_isList___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, IsArrayNode, IsListNode, IsMapEntryNode)' contains a shared cache with name 'isList' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isList = getArraySize_notArrayOrList_isList___check;
                                        }
                                        if (this.isMapEntry == null) {
                                            IsMapEntryNode getArraySize_notArrayOrList_isMapEntry___check = super.insert(getArraySize_notArrayOrList_isMapEntry__);
                                            if (getArraySize_notArrayOrList_isMapEntry___check == null) {
                                                throw new AssertionError("Specialization 'doNotArrayOrList(HostObject, IsArrayNode, IsListNode, IsMapEntryNode)' contains a shared cache with name 'isMapEntry' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                            }
                                            this.isMapEntry = getArraySize_notArrayOrList_isMapEntry___check;
                                        }
                                        this.state_0_ = state_0 = state_0 | 0x80000000 /* add-state_0 doNotArrayOrList(HostObject, IsArrayNode, IsListNode, IsMapEntryNode) */;
                                        NotArrayOrList_duplicateFound_ = true;
                                    }
                                }
                            }
                        }
                    }
                    if (NotArrayOrList_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetArraySize.doNotArrayOrList(arg0Value, this.isArray, this.isList, this.isMapEntry);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isInstantiable(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0b111) != 0 /* is-state_1 doUnsupported(HostObject) || doArrayCached(HostObject) || doObjectCached(HostObject, LookupConstructorNode) */) {
                    if ((state_1 & 0b1) != 0 /* is-state_1 doUnsupported(HostObject) */) {
                        if ((!(arg0Value.isClass()))) {
                            return IsInstantiable.doUnsupported(arg0Value);
                        }
                    }
                    if ((state_1 & 0b10) != 0 /* is-state_1 doArrayCached(HostObject) */) {
                        if ((arg0Value.isArrayClass())) {
                            return IsInstantiable.doArrayCached(arg0Value);
                        }
                    }
                    if ((state_1 & 0b100) != 0 /* is-state_1 doObjectCached(HostObject, LookupConstructorNode) */) {
                        if ((arg0Value.isDefaultClass())) {
                            return IsInstantiable.doObjectCached(arg0Value, this.lookupConstructor);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isInstantiableAndSpecialize(arg0Value);
            }

            private boolean isInstantiableAndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    if ((!(arg0Value.isClass()))) {
                        this.state_1_ = state_1 = state_1 | 0b1 /* add-state_1 doUnsupported(HostObject) */;
                        lock.unlock();
                        hasLock = false;
                        return IsInstantiable.doUnsupported(arg0Value);
                    }
                    if ((arg0Value.isArrayClass())) {
                        this.state_1_ = state_1 = state_1 | 0b10 /* add-state_1 doArrayCached(HostObject) */;
                        lock.unlock();
                        hasLock = false;
                        return IsInstantiable.doArrayCached(arg0Value);
                    }
                    if ((arg0Value.isDefaultClass())) {
                        this.lookupConstructor = super.insert(this.lookupConstructor == null ? ((LookupConstructorNodeGen.create())) : this.lookupConstructor);
                        this.state_1_ = state_1 = state_1 | 0b100 /* add-state_1 doObjectCached(HostObject, LookupConstructorNode) */;
                        lock.unlock();
                        hasLock = false;
                        return IsInstantiable.doObjectCached(arg0Value, this.lookupConstructor);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object instantiate(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0b111000) != 0 /* is-state_1 doUnsupported(HostObject, Object[]) || doArrayCached(HostObject, Object[], InteropLibrary, BranchProfile) || doObjectCached(HostObject, Object[], LookupConstructorNode, HostExecuteNode, BranchProfile) */) {
                    if ((state_1 & 0b1000) != 0 /* is-state_1 doUnsupported(HostObject, Object[]) */) {
                        if ((!(arg0Value.isClass()))) {
                            return Instantiate.doUnsupported(arg0Value, arg1Value);
                        }
                    }
                    if ((state_1 & 0b10000) != 0 /* is-state_1 doArrayCached(HostObject, Object[], InteropLibrary, BranchProfile) */) {
                        if ((arg0Value.isArrayClass())) {
                            return Instantiate.doArrayCached(arg0Value, arg1Value, this.instantiate_arrayCached_indexes_, this.error);
                        }
                    }
                    if ((state_1 & 0b100000) != 0 /* is-state_1 doObjectCached(HostObject, Object[], LookupConstructorNode, HostExecuteNode, BranchProfile) */) {
                        if ((arg0Value.isDefaultClass())) {
                            return Instantiate.doObjectCached(arg0Value, arg1Value, this.lookupConstructor, this.hostExecute, this.error);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return instantiateAndSpecialize(arg0Value, arg1Value);
            }

            private Object instantiateAndSpecialize(HostObject arg0Value, Object[] arg1Value) throws UnsupportedMessageException, UnsupportedTypeException, ArityException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    if ((!(arg0Value.isClass()))) {
                        this.state_1_ = state_1 = state_1 | 0b1000 /* add-state_1 doUnsupported(HostObject, Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return Instantiate.doUnsupported(arg0Value, arg1Value);
                    }
                    if ((arg0Value.isArrayClass())) {
                        this.instantiate_arrayCached_indexes_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                        this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                        this.state_1_ = state_1 = state_1 | 0b10000 /* add-state_1 doArrayCached(HostObject, Object[], InteropLibrary, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return Instantiate.doArrayCached(arg0Value, arg1Value, this.instantiate_arrayCached_indexes_, this.error);
                    }
                    if ((arg0Value.isDefaultClass())) {
                        this.lookupConstructor = super.insert(this.lookupConstructor == null ? ((LookupConstructorNodeGen.create())) : this.lookupConstructor);
                        this.hostExecute = super.insert(this.hostExecute == null ? ((HostExecuteNode.create())) : this.hostExecute);
                        this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                        this.state_1_ = state_1 = state_1 | 0b100000 /* add-state_1 doObjectCached(HostObject, Object[], LookupConstructorNode, HostExecuteNode, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return Instantiate.doObjectCached(arg0Value, arg1Value, this.lookupConstructor, this.hostExecute, this.error);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0b111000000) != 0 /* is-state_1 doArray(HostObject, IsArrayNode, ToGuestValueNode) || doIterable(HostObject, IsIterableNode, ToGuestValueNode, BranchProfile) || doNotArrayOrIterable(HostObject, IsArrayNode, IsIterableNode) */) {
                    if ((state_1 & 0b1000000) != 0 /* is-state_1 doArray(HostObject, IsArrayNode, ToGuestValueNode) */) {
                        if ((this.isArray.execute(arg0Value))) {
                            return GetIterator.doArray(arg0Value, this.isArray, this.toGuest);
                        }
                    }
                    if ((state_1 & 0b10000000) != 0 /* is-state_1 doIterable(HostObject, IsIterableNode, ToGuestValueNode, BranchProfile) */) {
                        if ((this.isIterable.execute(arg0Value))) {
                            return GetIterator.doIterable(arg0Value, this.isIterable, this.toGuest, this.error);
                        }
                    }
                    if ((state_1 & 0b100000000) != 0 /* is-state_1 doNotArrayOrIterable(HostObject, IsArrayNode, IsIterableNode) */) {
                        if ((!(this.isArray.execute(arg0Value))) && (!(this.isIterable.execute(arg0Value)))) {
                            return GetIterator.doNotArrayOrIterable(arg0Value, this.isArray, this.isIterable);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getIteratorAndSpecialize(arg0Value);
            }

            private Object getIteratorAndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    boolean Array_duplicateFound_ = false;
                    if ((state_1 & 0b1000000) != 0 /* is-state_1 doArray(HostObject, IsArrayNode, ToGuestValueNode) */) {
                        if ((this.isArray.execute(arg0Value))) {
                            Array_duplicateFound_ = true;
                        }
                    }
                    if (!Array_duplicateFound_) {
                        {
                            IsArrayNode getIterator_array_isArray__ = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                            if ((getIterator_array_isArray__.execute(arg0Value)) && ((state_1 & 0b1000000)) == 0 /* is-not-state_1 doArray(HostObject, IsArrayNode, ToGuestValueNode) */) {
                                if (this.isArray == null) {
                                    IsArrayNode getIterator_array_isArray___check = super.insert(getIterator_array_isArray__);
                                    if (getIterator_array_isArray___check == null) {
                                        throw new AssertionError("Specialization 'doArray(HostObject, IsArrayNode, ToGuestValueNode)' contains a shared cache with name 'isArray' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isArray = getIterator_array_isArray___check;
                                }
                                this.toGuest = super.insert(this.toGuest == null ? ((ToGuestValueNodeGen.create())) : this.toGuest);
                                this.state_1_ = state_1 = state_1 | 0b1000000 /* add-state_1 doArray(HostObject, IsArrayNode, ToGuestValueNode) */;
                                Array_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Array_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetIterator.doArray(arg0Value, this.isArray, this.toGuest);
                    }
                    boolean Iterable_duplicateFound_ = false;
                    if ((state_1 & 0b10000000) != 0 /* is-state_1 doIterable(HostObject, IsIterableNode, ToGuestValueNode, BranchProfile) */) {
                        if ((this.isIterable.execute(arg0Value))) {
                            Iterable_duplicateFound_ = true;
                        }
                    }
                    if (!Iterable_duplicateFound_) {
                        {
                            IsIterableNode getIterator_iterable_isIterable__ = super.insert(this.isIterable == null ? ((IsIterableNodeGen.create())) : this.isIterable);
                            if ((getIterator_iterable_isIterable__.execute(arg0Value)) && ((state_1 & 0b10000000)) == 0 /* is-not-state_1 doIterable(HostObject, IsIterableNode, ToGuestValueNode, BranchProfile) */) {
                                if (this.isIterable == null) {
                                    IsIterableNode getIterator_iterable_isIterable___check = super.insert(getIterator_iterable_isIterable__);
                                    if (getIterator_iterable_isIterable___check == null) {
                                        throw new AssertionError("Specialization 'doIterable(HostObject, IsIterableNode, ToGuestValueNode, BranchProfile)' contains a shared cache with name 'isIterable' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isIterable = getIterator_iterable_isIterable___check;
                                }
                                this.toGuest = super.insert(this.toGuest == null ? ((ToGuestValueNodeGen.create())) : this.toGuest);
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_1_ = state_1 = state_1 | 0b10000000 /* add-state_1 doIterable(HostObject, IsIterableNode, ToGuestValueNode, BranchProfile) */;
                                Iterable_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Iterable_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetIterator.doIterable(arg0Value, this.isIterable, this.toGuest, this.error);
                    }
                    boolean NotArrayOrIterable_duplicateFound_ = false;
                    if ((state_1 & 0b100000000) != 0 /* is-state_1 doNotArrayOrIterable(HostObject, IsArrayNode, IsIterableNode) */) {
                        if ((!(this.isArray.execute(arg0Value))) && (!(this.isIterable.execute(arg0Value)))) {
                            NotArrayOrIterable_duplicateFound_ = true;
                        }
                    }
                    if (!NotArrayOrIterable_duplicateFound_) {
                        {
                            IsArrayNode getIterator_notArrayOrIterable_isArray__ = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                            if ((!(getIterator_notArrayOrIterable_isArray__.execute(arg0Value)))) {
                                IsIterableNode getIterator_notArrayOrIterable_isIterable__ = super.insert(this.isIterable == null ? ((IsIterableNodeGen.create())) : this.isIterable);
                                if ((!(getIterator_notArrayOrIterable_isIterable__.execute(arg0Value))) && ((state_1 & 0b100000000)) == 0 /* is-not-state_1 doNotArrayOrIterable(HostObject, IsArrayNode, IsIterableNode) */) {
                                    if (this.isArray == null) {
                                        IsArrayNode getIterator_notArrayOrIterable_isArray___check = super.insert(getIterator_notArrayOrIterable_isArray__);
                                        if (getIterator_notArrayOrIterable_isArray___check == null) {
                                            throw new AssertionError("Specialization 'doNotArrayOrIterable(HostObject, IsArrayNode, IsIterableNode)' contains a shared cache with name 'isArray' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                        }
                                        this.isArray = getIterator_notArrayOrIterable_isArray___check;
                                    }
                                    if (this.isIterable == null) {
                                        IsIterableNode getIterator_notArrayOrIterable_isIterable___check = super.insert(getIterator_notArrayOrIterable_isIterable__);
                                        if (getIterator_notArrayOrIterable_isIterable___check == null) {
                                            throw new AssertionError("Specialization 'doNotArrayOrIterable(HostObject, IsArrayNode, IsIterableNode)' contains a shared cache with name 'isIterable' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                        }
                                        this.isIterable = getIterator_notArrayOrIterable_isIterable___check;
                                    }
                                    this.state_1_ = state_1 = state_1 | 0b100000000 /* add-state_1 doNotArrayOrIterable(HostObject, IsArrayNode, IsIterableNode) */;
                                    NotArrayOrIterable_duplicateFound_ = true;
                                }
                            }
                        }
                    }
                    if (NotArrayOrIterable_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetIterator.doNotArrayOrIterable(arg0Value, this.isArray, this.isIterable);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasIteratorNextElement(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0b11000000000) != 0 /* is-state_1 doIterator(HostObject, IsIteratorNode, BranchProfile) || doNotIterator(HostObject, IsIteratorNode) */) {
                    if ((state_1 & 0b1000000000) != 0 /* is-state_1 doIterator(HostObject, IsIteratorNode, BranchProfile) */) {
                        if ((this.isIterator.execute(arg0Value))) {
                            return HasIteratorNextElement.doIterator(arg0Value, this.isIterator, this.error);
                        }
                    }
                    if ((state_1 & 0b10000000000) != 0 /* is-state_1 doNotIterator(HostObject, IsIteratorNode) */) {
                        if ((!(this.isIterator.execute(arg0Value)))) {
                            return HasIteratorNextElement.doNotIterator(arg0Value, this.isIterator);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasIteratorNextElementAndSpecialize(arg0Value);
            }

            private boolean hasIteratorNextElementAndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    boolean Iterator_duplicateFound_ = false;
                    if ((state_1 & 0b1000000000) != 0 /* is-state_1 doIterator(HostObject, IsIteratorNode, BranchProfile) */) {
                        if ((this.isIterator.execute(arg0Value))) {
                            Iterator_duplicateFound_ = true;
                        }
                    }
                    if (!Iterator_duplicateFound_) {
                        {
                            IsIteratorNode hasIteratorNextElement_iterator_isIterator__ = super.insert(this.isIterator == null ? ((IsIteratorNodeGen.create())) : this.isIterator);
                            if ((hasIteratorNextElement_iterator_isIterator__.execute(arg0Value)) && ((state_1 & 0b1000000000)) == 0 /* is-not-state_1 doIterator(HostObject, IsIteratorNode, BranchProfile) */) {
                                if (this.isIterator == null) {
                                    IsIteratorNode hasIteratorNextElement_iterator_isIterator___check = super.insert(hasIteratorNextElement_iterator_isIterator__);
                                    if (hasIteratorNextElement_iterator_isIterator___check == null) {
                                        throw new AssertionError("Specialization 'doIterator(HostObject, IsIteratorNode, BranchProfile)' contains a shared cache with name 'isIterator' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isIterator = hasIteratorNextElement_iterator_isIterator___check;
                                }
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_1_ = state_1 = state_1 | 0b1000000000 /* add-state_1 doIterator(HostObject, IsIteratorNode, BranchProfile) */;
                                Iterator_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Iterator_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return HasIteratorNextElement.doIterator(arg0Value, this.isIterator, this.error);
                    }
                    boolean NotIterator_duplicateFound_ = false;
                    if ((state_1 & 0b10000000000) != 0 /* is-state_1 doNotIterator(HostObject, IsIteratorNode) */) {
                        if ((!(this.isIterator.execute(arg0Value)))) {
                            NotIterator_duplicateFound_ = true;
                        }
                    }
                    if (!NotIterator_duplicateFound_) {
                        {
                            IsIteratorNode hasIteratorNextElement_notIterator_isIterator__ = super.insert(this.isIterator == null ? ((IsIteratorNodeGen.create())) : this.isIterator);
                            if ((!(hasIteratorNextElement_notIterator_isIterator__.execute(arg0Value))) && ((state_1 & 0b10000000000)) == 0 /* is-not-state_1 doNotIterator(HostObject, IsIteratorNode) */) {
                                if (this.isIterator == null) {
                                    IsIteratorNode hasIteratorNextElement_notIterator_isIterator___check = super.insert(hasIteratorNextElement_notIterator_isIterator__);
                                    if (hasIteratorNextElement_notIterator_isIterator___check == null) {
                                        throw new AssertionError("Specialization 'doNotIterator(HostObject, IsIteratorNode)' contains a shared cache with name 'isIterator' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isIterator = hasIteratorNextElement_notIterator_isIterator___check;
                                }
                                this.state_1_ = state_1 = state_1 | 0b10000000000 /* add-state_1 doNotIterator(HostObject, IsIteratorNode) */;
                                NotIterator_duplicateFound_ = true;
                            }
                        }
                    }
                    if (NotIterator_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return HasIteratorNextElement.doNotIterator(arg0Value, this.isIterator);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0b1100000000000) != 0 /* is-state_1 doIterator(HostObject, IsIteratorNode, ToGuestValueNode, BranchProfile, BranchProfile) || doNotIterator(HostObject, IsIteratorNode) */) {
                    if ((state_1 & 0b100000000000) != 0 /* is-state_1 doIterator(HostObject, IsIteratorNode, ToGuestValueNode, BranchProfile, BranchProfile) */) {
                        if ((this.isIterator.execute(arg0Value))) {
                            return GetIteratorNextElement.doIterator(arg0Value, this.isIterator, this.toGuest, this.error, this.getIteratorNextElement_iterator_stopIteration_);
                        }
                    }
                    if ((state_1 & 0b1000000000000) != 0 /* is-state_1 doNotIterator(HostObject, IsIteratorNode) */) {
                        if ((!(this.isIterator.execute(arg0Value)))) {
                            return GetIteratorNextElement.doNotIterator(arg0Value, this.isIterator);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getIteratorNextElementAndSpecialize(arg0Value);
            }

            private Object getIteratorNextElementAndSpecialize(HostObject arg0Value) throws StopIterationException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    boolean Iterator_duplicateFound_ = false;
                    if ((state_1 & 0b100000000000) != 0 /* is-state_1 doIterator(HostObject, IsIteratorNode, ToGuestValueNode, BranchProfile, BranchProfile) */) {
                        if ((this.isIterator.execute(arg0Value))) {
                            Iterator_duplicateFound_ = true;
                        }
                    }
                    if (!Iterator_duplicateFound_) {
                        {
                            IsIteratorNode getIteratorNextElement_iterator_isIterator__ = super.insert(this.isIterator == null ? ((IsIteratorNodeGen.create())) : this.isIterator);
                            if ((getIteratorNextElement_iterator_isIterator__.execute(arg0Value)) && ((state_1 & 0b100000000000)) == 0 /* is-not-state_1 doIterator(HostObject, IsIteratorNode, ToGuestValueNode, BranchProfile, BranchProfile) */) {
                                if (this.isIterator == null) {
                                    IsIteratorNode getIteratorNextElement_iterator_isIterator___check = super.insert(getIteratorNextElement_iterator_isIterator__);
                                    if (getIteratorNextElement_iterator_isIterator___check == null) {
                                        throw new AssertionError("Specialization 'doIterator(HostObject, IsIteratorNode, ToGuestValueNode, BranchProfile, BranchProfile)' contains a shared cache with name 'isIterator' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isIterator = getIteratorNextElement_iterator_isIterator___check;
                                }
                                this.toGuest = super.insert(this.toGuest == null ? ((ToGuestValueNodeGen.create())) : this.toGuest);
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.getIteratorNextElement_iterator_stopIteration_ = (BranchProfile.create());
                                this.state_1_ = state_1 = state_1 | 0b100000000000 /* add-state_1 doIterator(HostObject, IsIteratorNode, ToGuestValueNode, BranchProfile, BranchProfile) */;
                                Iterator_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Iterator_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetIteratorNextElement.doIterator(arg0Value, this.isIterator, this.toGuest, this.error, this.getIteratorNextElement_iterator_stopIteration_);
                    }
                    boolean NotIterator_duplicateFound_ = false;
                    if ((state_1 & 0b1000000000000) != 0 /* is-state_1 doNotIterator(HostObject, IsIteratorNode) */) {
                        if ((!(this.isIterator.execute(arg0Value)))) {
                            NotIterator_duplicateFound_ = true;
                        }
                    }
                    if (!NotIterator_duplicateFound_) {
                        {
                            IsIteratorNode getIteratorNextElement_notIterator_isIterator__ = super.insert(this.isIterator == null ? ((IsIteratorNodeGen.create())) : this.isIterator);
                            if ((!(getIteratorNextElement_notIterator_isIterator__.execute(arg0Value))) && ((state_1 & 0b1000000000000)) == 0 /* is-not-state_1 doNotIterator(HostObject, IsIteratorNode) */) {
                                if (this.isIterator == null) {
                                    IsIteratorNode getIteratorNextElement_notIterator_isIterator___check = super.insert(getIteratorNextElement_notIterator_isIterator__);
                                    if (getIteratorNextElement_notIterator_isIterator___check == null) {
                                        throw new AssertionError("Specialization 'doNotIterator(HostObject, IsIteratorNode)' contains a shared cache with name 'isIterator' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isIterator = getIteratorNextElement_notIterator_isIterator___check;
                                }
                                this.state_1_ = state_1 = state_1 | 0b1000000000000 /* add-state_1 doNotIterator(HostObject, IsIteratorNode) */;
                                NotIterator_duplicateFound_ = true;
                            }
                        }
                    }
                    if (NotIterator_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetIteratorNextElement.doNotIterator(arg0Value, this.isIterator);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public long getHashSize(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0b110000000000000) != 0 /* is-state_1 doMap(HostObject, IsMapNode, BranchProfile) || doNotMap(HostObject, IsMapNode) */) {
                    if ((state_1 & 0b10000000000000) != 0 /* is-state_1 doMap(HostObject, IsMapNode, BranchProfile) */) {
                        if ((this.isMap.execute(arg0Value))) {
                            return GetHashSize.doMap(arg0Value, this.isMap, this.error);
                        }
                    }
                    if ((state_1 & 0b100000000000000) != 0 /* is-state_1 doNotMap(HostObject, IsMapNode) */) {
                        if ((!(this.isMap.execute(arg0Value)))) {
                            return GetHashSize.doNotMap(arg0Value, this.isMap);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getHashSizeAndSpecialize(arg0Value);
            }

            private long getHashSizeAndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    boolean Map_duplicateFound_ = false;
                    if ((state_1 & 0b10000000000000) != 0 /* is-state_1 doMap(HostObject, IsMapNode, BranchProfile) */) {
                        if ((this.isMap.execute(arg0Value))) {
                            Map_duplicateFound_ = true;
                        }
                    }
                    if (!Map_duplicateFound_) {
                        {
                            IsMapNode getHashSize_map_isMap__ = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                            if ((getHashSize_map_isMap__.execute(arg0Value)) && ((state_1 & 0b10000000000000)) == 0 /* is-not-state_1 doMap(HostObject, IsMapNode, BranchProfile) */) {
                                if (this.isMap == null) {
                                    IsMapNode getHashSize_map_isMap___check = super.insert(getHashSize_map_isMap__);
                                    if (getHashSize_map_isMap___check == null) {
                                        throw new AssertionError("Specialization 'doMap(HostObject, IsMapNode, BranchProfile)' contains a shared cache with name 'isMap' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMap = getHashSize_map_isMap___check;
                                }
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_1_ = state_1 = state_1 | 0b10000000000000 /* add-state_1 doMap(HostObject, IsMapNode, BranchProfile) */;
                                Map_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Map_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetHashSize.doMap(arg0Value, this.isMap, this.error);
                    }
                    boolean NotMap_duplicateFound_ = false;
                    if ((state_1 & 0b100000000000000) != 0 /* is-state_1 doNotMap(HostObject, IsMapNode) */) {
                        if ((!(this.isMap.execute(arg0Value)))) {
                            NotMap_duplicateFound_ = true;
                        }
                    }
                    if (!NotMap_duplicateFound_) {
                        {
                            IsMapNode getHashSize_notMap_isMap__ = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                            if ((!(getHashSize_notMap_isMap__.execute(arg0Value))) && ((state_1 & 0b100000000000000)) == 0 /* is-not-state_1 doNotMap(HostObject, IsMapNode) */) {
                                if (this.isMap == null) {
                                    IsMapNode getHashSize_notMap_isMap___check = super.insert(getHashSize_notMap_isMap__);
                                    if (getHashSize_notMap_isMap___check == null) {
                                        throw new AssertionError("Specialization 'doNotMap(HostObject, IsMapNode)' contains a shared cache with name 'isMap' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMap = getHashSize_notMap_isMap___check;
                                }
                                this.state_1_ = state_1 = state_1 | 0b100000000000000 /* add-state_1 doNotMap(HostObject, IsMapNode) */;
                                NotMap_duplicateFound_ = true;
                            }
                        }
                    }
                    if (NotMap_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetHashSize.doNotMap(arg0Value, this.isMap);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object readHashValue(Object arg0Value_, Object arg1Value) throws UnsupportedMessageException, UnknownKeyException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0x18000) != 0 /* is-state_1 doMap(HostObject, Object, IsMapNode, HostToTypeNode, ToGuestValueNode, BranchProfile) || doNotMap(HostObject, Object, IsMapNode) */) {
                    if ((state_1 & 0b1000000000000000) != 0 /* is-state_1 doMap(HostObject, Object, IsMapNode, HostToTypeNode, ToGuestValueNode, BranchProfile) */) {
                        if ((this.isMap.execute(arg0Value))) {
                            return ReadHashValue.doMap(arg0Value, arg1Value, this.isMap, this.toHost, this.toGuest, this.error);
                        }
                    }
                    if ((state_1 & 0x10000) != 0 /* is-state_1 doNotMap(HostObject, Object, IsMapNode) */) {
                        if ((!(this.isMap.execute(arg0Value)))) {
                            return ReadHashValue.doNotMap(arg0Value, arg1Value, this.isMap);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readHashValueAndSpecialize(arg0Value, arg1Value);
            }

            private Object readHashValueAndSpecialize(HostObject arg0Value, Object arg1Value) throws UnknownKeyException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    boolean Map_duplicateFound_ = false;
                    if ((state_1 & 0b1000000000000000) != 0 /* is-state_1 doMap(HostObject, Object, IsMapNode, HostToTypeNode, ToGuestValueNode, BranchProfile) */) {
                        if ((this.isMap.execute(arg0Value))) {
                            Map_duplicateFound_ = true;
                        }
                    }
                    if (!Map_duplicateFound_) {
                        {
                            IsMapNode readHashValue_map_isMap__ = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                            if ((readHashValue_map_isMap__.execute(arg0Value)) && ((state_1 & 0b1000000000000000)) == 0 /* is-not-state_1 doMap(HostObject, Object, IsMapNode, HostToTypeNode, ToGuestValueNode, BranchProfile) */) {
                                if (this.isMap == null) {
                                    IsMapNode readHashValue_map_isMap___check = super.insert(readHashValue_map_isMap__);
                                    if (readHashValue_map_isMap___check == null) {
                                        throw new AssertionError("Specialization 'doMap(HostObject, Object, IsMapNode, HostToTypeNode, ToGuestValueNode, BranchProfile)' contains a shared cache with name 'isMap' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMap = readHashValue_map_isMap___check;
                                }
                                this.toHost = super.insert(this.toHost == null ? ((HostToTypeNodeGen.create())) : this.toHost);
                                this.toGuest = super.insert(this.toGuest == null ? ((ToGuestValueNodeGen.create())) : this.toGuest);
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_1_ = state_1 = state_1 | 0b1000000000000000 /* add-state_1 doMap(HostObject, Object, IsMapNode, HostToTypeNode, ToGuestValueNode, BranchProfile) */;
                                Map_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Map_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return ReadHashValue.doMap(arg0Value, arg1Value, this.isMap, this.toHost, this.toGuest, this.error);
                    }
                    boolean NotMap_duplicateFound_ = false;
                    if ((state_1 & 0x10000) != 0 /* is-state_1 doNotMap(HostObject, Object, IsMapNode) */) {
                        if ((!(this.isMap.execute(arg0Value)))) {
                            NotMap_duplicateFound_ = true;
                        }
                    }
                    if (!NotMap_duplicateFound_) {
                        {
                            IsMapNode readHashValue_notMap_isMap__ = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                            if ((!(readHashValue_notMap_isMap__.execute(arg0Value))) && ((state_1 & 0x10000)) == 0 /* is-not-state_1 doNotMap(HostObject, Object, IsMapNode) */) {
                                if (this.isMap == null) {
                                    IsMapNode readHashValue_notMap_isMap___check = super.insert(readHashValue_notMap_isMap__);
                                    if (readHashValue_notMap_isMap___check == null) {
                                        throw new AssertionError("Specialization 'doNotMap(HostObject, Object, IsMapNode)' contains a shared cache with name 'isMap' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMap = readHashValue_notMap_isMap___check;
                                }
                                this.state_1_ = state_1 = state_1 | 0x10000 /* add-state_1 doNotMap(HostObject, Object, IsMapNode) */;
                                NotMap_duplicateFound_ = true;
                            }
                        }
                    }
                    if (NotMap_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return ReadHashValue.doNotMap(arg0Value, arg1Value, this.isMap);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0x60000) != 0 /* is-state_1 doMap(HostObject, Object, Object, IsMapNode, HostToTypeNode, BranchProfile) || doNotMap(HostObject, Object, Object, IsMapNode) */) {
                    if ((state_1 & 0x20000) != 0 /* is-state_1 doMap(HostObject, Object, Object, IsMapNode, HostToTypeNode, BranchProfile) */) {
                        if ((this.isMap.execute(arg0Value))) {
                            WriteHashEntry.doMap(arg0Value, arg1Value, arg2Value, this.isMap, this.toHost, this.error);
                            return;
                        }
                    }
                    if ((state_1 & 0x40000) != 0 /* is-state_1 doNotMap(HostObject, Object, Object, IsMapNode) */) {
                        if ((!(this.isMap.execute(arg0Value)))) {
                            WriteHashEntry.doNotMap(arg0Value, arg1Value, arg2Value, this.isMap);
                            return;
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeHashEntryAndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeHashEntryAndSpecialize(HostObject arg0Value, Object arg1Value, Object arg2Value) throws UnsupportedTypeException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    boolean Map_duplicateFound_ = false;
                    if ((state_1 & 0x20000) != 0 /* is-state_1 doMap(HostObject, Object, Object, IsMapNode, HostToTypeNode, BranchProfile) */) {
                        if ((this.isMap.execute(arg0Value))) {
                            Map_duplicateFound_ = true;
                        }
                    }
                    if (!Map_duplicateFound_) {
                        {
                            IsMapNode writeHashEntry_map_isMap__ = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                            if ((writeHashEntry_map_isMap__.execute(arg0Value)) && ((state_1 & 0x20000)) == 0 /* is-not-state_1 doMap(HostObject, Object, Object, IsMapNode, HostToTypeNode, BranchProfile) */) {
                                if (this.isMap == null) {
                                    IsMapNode writeHashEntry_map_isMap___check = super.insert(writeHashEntry_map_isMap__);
                                    if (writeHashEntry_map_isMap___check == null) {
                                        throw new AssertionError("Specialization 'doMap(HostObject, Object, Object, IsMapNode, HostToTypeNode, BranchProfile)' contains a shared cache with name 'isMap' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMap = writeHashEntry_map_isMap___check;
                                }
                                this.toHost = super.insert(this.toHost == null ? ((HostToTypeNodeGen.create())) : this.toHost);
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_1_ = state_1 = state_1 | 0x20000 /* add-state_1 doMap(HostObject, Object, Object, IsMapNode, HostToTypeNode, BranchProfile) */;
                                Map_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Map_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        WriteHashEntry.doMap(arg0Value, arg1Value, arg2Value, this.isMap, this.toHost, this.error);
                        return;
                    }
                    boolean NotMap_duplicateFound_ = false;
                    if ((state_1 & 0x40000) != 0 /* is-state_1 doNotMap(HostObject, Object, Object, IsMapNode) */) {
                        if ((!(this.isMap.execute(arg0Value)))) {
                            NotMap_duplicateFound_ = true;
                        }
                    }
                    if (!NotMap_duplicateFound_) {
                        {
                            IsMapNode writeHashEntry_notMap_isMap__ = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                            if ((!(writeHashEntry_notMap_isMap__.execute(arg0Value))) && ((state_1 & 0x40000)) == 0 /* is-not-state_1 doNotMap(HostObject, Object, Object, IsMapNode) */) {
                                if (this.isMap == null) {
                                    IsMapNode writeHashEntry_notMap_isMap___check = super.insert(writeHashEntry_notMap_isMap__);
                                    if (writeHashEntry_notMap_isMap___check == null) {
                                        throw new AssertionError("Specialization 'doNotMap(HostObject, Object, Object, IsMapNode)' contains a shared cache with name 'isMap' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMap = writeHashEntry_notMap_isMap___check;
                                }
                                this.state_1_ = state_1 = state_1 | 0x40000 /* add-state_1 doNotMap(HostObject, Object, Object, IsMapNode) */;
                                NotMap_duplicateFound_ = true;
                            }
                        }
                    }
                    if (NotMap_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        WriteHashEntry.doNotMap(arg0Value, arg1Value, arg2Value, this.isMap);
                        return;
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0x180000) != 0 /* is-state_1 doMap(HostObject, Object, IsMapNode, HostToTypeNode, BranchProfile) || doNotMap(HostObject, Object, IsMapNode) */) {
                    if ((state_1 & 0x80000) != 0 /* is-state_1 doMap(HostObject, Object, IsMapNode, HostToTypeNode, BranchProfile) */) {
                        if ((this.isMap.execute(arg0Value))) {
                            RemoveHashEntry.doMap(arg0Value, arg1Value, this.isMap, this.toHost, this.error);
                            return;
                        }
                    }
                    if ((state_1 & 0x100000) != 0 /* is-state_1 doNotMap(HostObject, Object, IsMapNode) */) {
                        if ((!(this.isMap.execute(arg0Value)))) {
                            RemoveHashEntry.doNotMap(arg0Value, arg1Value, this.isMap);
                            return;
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                removeHashEntryAndSpecialize(arg0Value, arg1Value);
                return;
            }

            private void removeHashEntryAndSpecialize(HostObject arg0Value, Object arg1Value) throws UnknownKeyException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    boolean Map_duplicateFound_ = false;
                    if ((state_1 & 0x80000) != 0 /* is-state_1 doMap(HostObject, Object, IsMapNode, HostToTypeNode, BranchProfile) */) {
                        if ((this.isMap.execute(arg0Value))) {
                            Map_duplicateFound_ = true;
                        }
                    }
                    if (!Map_duplicateFound_) {
                        {
                            IsMapNode removeHashEntry_map_isMap__ = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                            if ((removeHashEntry_map_isMap__.execute(arg0Value)) && ((state_1 & 0x80000)) == 0 /* is-not-state_1 doMap(HostObject, Object, IsMapNode, HostToTypeNode, BranchProfile) */) {
                                if (this.isMap == null) {
                                    IsMapNode removeHashEntry_map_isMap___check = super.insert(removeHashEntry_map_isMap__);
                                    if (removeHashEntry_map_isMap___check == null) {
                                        throw new AssertionError("Specialization 'doMap(HostObject, Object, IsMapNode, HostToTypeNode, BranchProfile)' contains a shared cache with name 'isMap' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMap = removeHashEntry_map_isMap___check;
                                }
                                this.toHost = super.insert(this.toHost == null ? ((HostToTypeNodeGen.create())) : this.toHost);
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_1_ = state_1 = state_1 | 0x80000 /* add-state_1 doMap(HostObject, Object, IsMapNode, HostToTypeNode, BranchProfile) */;
                                Map_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Map_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        RemoveHashEntry.doMap(arg0Value, arg1Value, this.isMap, this.toHost, this.error);
                        return;
                    }
                    boolean NotMap_duplicateFound_ = false;
                    if ((state_1 & 0x100000) != 0 /* is-state_1 doNotMap(HostObject, Object, IsMapNode) */) {
                        if ((!(this.isMap.execute(arg0Value)))) {
                            NotMap_duplicateFound_ = true;
                        }
                    }
                    if (!NotMap_duplicateFound_) {
                        {
                            IsMapNode removeHashEntry_notMap_isMap__ = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                            if ((!(removeHashEntry_notMap_isMap__.execute(arg0Value))) && ((state_1 & 0x100000)) == 0 /* is-not-state_1 doNotMap(HostObject, Object, IsMapNode) */) {
                                if (this.isMap == null) {
                                    IsMapNode removeHashEntry_notMap_isMap___check = super.insert(removeHashEntry_notMap_isMap__);
                                    if (removeHashEntry_notMap_isMap___check == null) {
                                        throw new AssertionError("Specialization 'doNotMap(HostObject, Object, IsMapNode)' contains a shared cache with name 'isMap' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMap = removeHashEntry_notMap_isMap___check;
                                }
                                this.state_1_ = state_1 = state_1 | 0x100000 /* add-state_1 doNotMap(HostObject, Object, IsMapNode) */;
                                NotMap_duplicateFound_ = true;
                            }
                        }
                    }
                    if (NotMap_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        RemoveHashEntry.doNotMap(arg0Value, arg1Value, this.isMap);
                        return;
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0x600000) != 0 /* is-state_1 doMap(HostObject, IsMapNode, ToGuestValueNode, BranchProfile) || doNotMap(HostObject, IsMapNode) */) {
                    if ((state_1 & 0x200000) != 0 /* is-state_1 doMap(HostObject, IsMapNode, ToGuestValueNode, BranchProfile) */) {
                        if ((this.isMap.execute(arg0Value))) {
                            return GetHashEntriesIterator.doMap(arg0Value, this.isMap, this.toGuest, this.error);
                        }
                    }
                    if ((state_1 & 0x400000) != 0 /* is-state_1 doNotMap(HostObject, IsMapNode) */) {
                        if ((!(this.isMap.execute(arg0Value)))) {
                            return GetHashEntriesIterator.doNotMap(arg0Value, this.isMap);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getHashEntriesIteratorAndSpecialize(arg0Value);
            }

            private Object getHashEntriesIteratorAndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    boolean Map_duplicateFound_ = false;
                    if ((state_1 & 0x200000) != 0 /* is-state_1 doMap(HostObject, IsMapNode, ToGuestValueNode, BranchProfile) */) {
                        if ((this.isMap.execute(arg0Value))) {
                            Map_duplicateFound_ = true;
                        }
                    }
                    if (!Map_duplicateFound_) {
                        {
                            IsMapNode getHashEntriesIterator_map_isMap__ = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                            if ((getHashEntriesIterator_map_isMap__.execute(arg0Value)) && ((state_1 & 0x200000)) == 0 /* is-not-state_1 doMap(HostObject, IsMapNode, ToGuestValueNode, BranchProfile) */) {
                                if (this.isMap == null) {
                                    IsMapNode getHashEntriesIterator_map_isMap___check = super.insert(getHashEntriesIterator_map_isMap__);
                                    if (getHashEntriesIterator_map_isMap___check == null) {
                                        throw new AssertionError("Specialization 'doMap(HostObject, IsMapNode, ToGuestValueNode, BranchProfile)' contains a shared cache with name 'isMap' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMap = getHashEntriesIterator_map_isMap___check;
                                }
                                this.toGuest = super.insert(this.toGuest == null ? ((ToGuestValueNodeGen.create())) : this.toGuest);
                                this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                                this.state_1_ = state_1 = state_1 | 0x200000 /* add-state_1 doMap(HostObject, IsMapNode, ToGuestValueNode, BranchProfile) */;
                                Map_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Map_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetHashEntriesIterator.doMap(arg0Value, this.isMap, this.toGuest, this.error);
                    }
                    boolean NotMap_duplicateFound_ = false;
                    if ((state_1 & 0x400000) != 0 /* is-state_1 doNotMap(HostObject, IsMapNode) */) {
                        if ((!(this.isMap.execute(arg0Value)))) {
                            NotMap_duplicateFound_ = true;
                        }
                    }
                    if (!NotMap_duplicateFound_) {
                        {
                            IsMapNode getHashEntriesIterator_notMap_isMap__ = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                            if ((!(getHashEntriesIterator_notMap_isMap__.execute(arg0Value))) && ((state_1 & 0x400000)) == 0 /* is-not-state_1 doNotMap(HostObject, IsMapNode) */) {
                                if (this.isMap == null) {
                                    IsMapNode getHashEntriesIterator_notMap_isMap___check = super.insert(getHashEntriesIterator_notMap_isMap__);
                                    if (getHashEntriesIterator_notMap_isMap___check == null) {
                                        throw new AssertionError("Specialization 'doNotMap(HostObject, IsMapNode)' contains a shared cache with name 'isMap' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                    }
                                    this.isMap = getHashEntriesIterator_notMap_isMap___check;
                                }
                                this.state_1_ = state_1 = state_1 | 0x400000 /* add-state_1 doNotMap(HostObject, IsMapNode) */;
                                NotMap_duplicateFound_ = true;
                            }
                        }
                    }
                    if (NotMap_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return GetHashEntriesIterator.doNotMap(arg0Value, this.isMap);
                    }
                    throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            protected TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0x1800000) != 0 /* is-state_1 doHostObject(HostObject, HostObject) || doOther(HostObject, Object) */) {
                    if ((state_1 & 0x800000) != 0 /* is-state_1 doHostObject(HostObject, HostObject) */ && arg1Value instanceof HostObject) {
                        HostObject arg1Value_ = (HostObject) arg1Value;
                        return IsIdenticalOrUndefined.doHostObject(arg0Value, arg1Value_);
                    }
                    if ((state_1 & 0x1000000) != 0 /* is-state_1 doOther(HostObject, Object) */) {
                        if (isIdenticalOrUndefinedFallbackGuard_(state_1, arg0Value, arg1Value)) {
                            return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isIdenticalOrUndefinedAndSpecialize(arg0Value, arg1Value);
            }

            private TriState isIdenticalOrUndefinedAndSpecialize(HostObject arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    if (arg1Value instanceof HostObject) {
                        HostObject arg1Value_ = (HostObject) arg1Value;
                        this.state_1_ = state_1 = state_1 | 0x800000 /* add-state_1 doHostObject(HostObject, HostObject) */;
                        lock.unlock();
                        hasLock = false;
                        return IsIdenticalOrUndefined.doHostObject(arg0Value, arg1Value_);
                    }
                    this.state_1_ = state_1 = state_1 | 0x1000000 /* add-state_1 doOther(HostObject, Object) */;
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
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).hasMembers();
            }

            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).getMembers(includeInternal);
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0x2000000) != 0 /* is-state_1 readMember(HostObject, String, LookupFieldNode, ReadFieldNode, LookupMethodNode, LookupInnerClassNode, BranchProfile) */) {
                    return arg0Value.readMember(arg1Value, this.lookupField, this.readField, this.lookupMethod, this.readMemberNode__readMember_lookupInnerClass_, this.error);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberNode_AndSpecialize(HostObject arg0Value, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    this.lookupField = super.insert(this.lookupField == null ? ((LookupFieldNodeGen.create())) : this.lookupField);
                    this.readField = super.insert(this.readField == null ? ((ReadFieldNodeGen.create())) : this.readField);
                    this.lookupMethod = super.insert(this.lookupMethod == null ? ((LookupMethodNodeGen.create())) : this.lookupMethod);
                    this.readMemberNode__readMember_lookupInnerClass_ = super.insert((LookupInnerClassNodeGen.create()));
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_1_ = state_1 = state_1 | 0x2000000 /* add-state_1 readMember(HostObject, String, LookupFieldNode, ReadFieldNode, LookupMethodNode, LookupInnerClassNode, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readMember(arg1Value, this.lookupField, this.readField, this.lookupMethod, this.readMemberNode__readMember_lookupInnerClass_, this.error);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).isMemberInsertable(member);
            }

            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0x4000000) != 0 /* is-state_1 writeMember(HostObject, String, Object, LookupFieldNode, WriteFieldNode, BranchProfile) */) {
                    arg0Value.writeMember(arg1Value, arg2Value, this.lookupField, this.writeMemberNode__writeMember_writeField_, this.error);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeMemberNode_AndSpecialize(HostObject arg0Value, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    this.lookupField = super.insert(this.lookupField == null ? ((LookupFieldNodeGen.create())) : this.lookupField);
                    this.writeMemberNode__writeMember_writeField_ = super.insert((WriteFieldNodeGen.create()));
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_1_ = state_1 = state_1 | 0x4000000 /* add-state_1 writeMember(HostObject, String, Object, LookupFieldNode, WriteFieldNode, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeMember(arg1Value, arg2Value, this.lookupField, this.writeMemberNode__writeMember_writeField_, this.error);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0x8000000) != 0 /* is-state_1 invokeMember(HostObject, String, Object[], LookupMethodNode, HostExecuteNode, LookupFieldNode, ReadFieldNode, InteropLibrary, BranchProfile) */) {
                    return arg0Value.invokeMember(arg1Value, arg2Value, this.lookupMethod, this.hostExecute, this.lookupField, this.readField, this.invokeMemberNode__invokeMember_fieldValues_, this.error);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return invokeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object invokeMemberNode_AndSpecialize(HostObject arg0Value, String arg1Value, Object[] arg2Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException, UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    this.lookupMethod = super.insert(this.lookupMethod == null ? ((LookupMethodNodeGen.create())) : this.lookupMethod);
                    this.hostExecute = super.insert(this.hostExecute == null ? ((HostExecuteNode.create())) : this.hostExecute);
                    this.lookupField = super.insert(this.lookupField == null ? ((LookupFieldNodeGen.create())) : this.lookupField);
                    this.readField = super.insert(this.readField == null ? ((ReadFieldNodeGen.create())) : this.readField);
                    this.invokeMemberNode__invokeMember_fieldValues_ = super.insert((INTEROP_LIBRARY_.createDispatched(5)));
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_1_ = state_1 = state_1 | 0x8000000 /* add-state_1 invokeMember(HostObject, String, Object[], LookupMethodNode, HostExecuteNode, LookupFieldNode, ReadFieldNode, InteropLibrary, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.invokeMember(arg1Value, arg2Value, this.lookupMethod, this.hostExecute, this.lookupField, this.readField, this.invokeMemberNode__invokeMember_fieldValues_, this.error);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementInsertable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0x10000000) != 0 /* is-state_1 isArrayElementInsertable(HostObject, long, IsListNode, BranchProfile) */) {
                    return arg0Value.isArrayElementInsertable(arg1Value, this.isList, this.error);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementInsertableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementInsertableNode_AndSpecialize(HostObject arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    this.isList = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_1_ = state_1 = state_1 | 0x10000000 /* add-state_1 isArrayElementInsertable(HostObject, long, IsListNode, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isArrayElementInsertable(arg1Value, this.isList, this.error);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasArrayElements(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0x20000000) != 0 /* is-state_1 hasArrayElements(HostObject, IsListNode, IsArrayNode, IsMapEntryNode) */) {
                    return arg0Value.hasArrayElements(this.isList, this.isArray, this.isMapEntry);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasArrayElementsNode_AndSpecialize(arg0Value);
            }

            private boolean hasArrayElementsNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    this.isList = super.insert(this.isList == null ? ((IsListNodeGen.create())) : this.isList);
                    this.isArray = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                    this.isMapEntry = super.insert(this.isMapEntry == null ? ((IsMapEntryNodeGen.create())) : this.isMapEntry);
                    this.state_1_ = state_1 = state_1 | 0x20000000 /* add-state_1 hasArrayElements(HostObject, IsListNode, IsArrayNode, IsMapEntryNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasArrayElements(this.isList, this.isArray, this.isMapEntry);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasBufferElements(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0x40000000) != 0 /* is-state_1 hasBufferElements(HostObject, IsBufferNode) */) {
                    return arg0Value.hasBufferElements(this.isBuffer);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasBufferElementsNode_AndSpecialize(arg0Value);
            }

            private boolean hasBufferElementsNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.state_1_ = state_1 = state_1 | 0x40000000 /* add-state_1 hasBufferElements(HostObject, IsBufferNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasBufferElements(this.isBuffer);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isBufferWritable(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_1 = this.state_1_;
                if ((state_1 & 0x80000000) != 0 /* is-state_1 isBufferWritable(HostObject, IsBufferNode, BranchProfile) */) {
                    return arg0Value.isBufferWritable(this.isBuffer, this.error);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isBufferWritableNode_AndSpecialize(arg0Value);
            }

            private boolean isBufferWritableNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_1 = this.state_1_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_1_ = state_1 = state_1 | 0x80000000 /* add-state_1 isBufferWritable(HostObject, IsBufferNode, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isBufferWritable(this.isBuffer, this.error);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public long getBufferSize(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b1) != 0 /* is-state_2 getBufferSize(HostObject, IsBufferNode, BranchProfile) */) {
                    return arg0Value.getBufferSize(this.isBuffer, this.error);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getBufferSizeNode_AndSpecialize(arg0Value);
            }

            private long getBufferSizeNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_2_ = state_2 = state_2 | 0b1 /* add-state_2 getBufferSize(HostObject, IsBufferNode, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getBufferSize(this.isBuffer, this.error);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public byte readBufferByte(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b10) != 0 /* is-state_2 readBufferByte(HostObject, long, IsBufferNode, BranchProfile, ValueProfile) */) {
                    return arg0Value.readBufferByte(arg1Value, this.isBuffer, this.error, this.classProfile);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readBufferByteNode_AndSpecialize(arg0Value, arg1Value);
            }

            private byte readBufferByteNode_AndSpecialize(HostObject arg0Value, long arg1Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b10 /* add-state_2 readBufferByte(HostObject, long, IsBufferNode, BranchProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readBufferByte(arg1Value, this.isBuffer, this.error, this.classProfile);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeBufferByte(Object arg0Value_, long arg1Value, byte arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b100) != 0 /* is-state_2 writeBufferByte(HostObject, long, byte, IsBufferNode, BranchProfile, ValueProfile) */) {
                    arg0Value.writeBufferByte(arg1Value, arg2Value, this.isBuffer, this.error, this.classProfile);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeBufferByteNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeBufferByteNode_AndSpecialize(HostObject arg0Value, long arg1Value, byte arg2Value) throws InvalidBufferOffsetException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b100 /* add-state_2 writeBufferByte(HostObject, long, byte, IsBufferNode, BranchProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeBufferByte(arg1Value, arg2Value, this.isBuffer, this.error, this.classProfile);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public short readBufferShort(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b1000) != 0 /* is-state_2 readBufferShort(HostObject, ByteOrder, long, IsBufferNode, BranchProfile, ValueProfile) */) {
                    return arg0Value.readBufferShort(arg1Value, arg2Value, this.isBuffer, this.error, this.classProfile);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readBufferShortNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private short readBufferShortNode_AndSpecialize(HostObject arg0Value, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b1000 /* add-state_2 readBufferShort(HostObject, ByteOrder, long, IsBufferNode, BranchProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readBufferShort(arg1Value, arg2Value, this.isBuffer, this.error, this.classProfile);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeBufferShort(Object arg0Value_, ByteOrder arg1Value, long arg2Value, short arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b10000) != 0 /* is-state_2 writeBufferShort(HostObject, ByteOrder, long, short, IsBufferNode, BranchProfile, ValueProfile) */) {
                    arg0Value.writeBufferShort(arg1Value, arg2Value, arg3Value, this.isBuffer, this.error, this.classProfile);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeBufferShortNode_AndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
                return;
            }

            private void writeBufferShortNode_AndSpecialize(HostObject arg0Value, ByteOrder arg1Value, long arg2Value, short arg3Value) throws InvalidBufferOffsetException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b10000 /* add-state_2 writeBufferShort(HostObject, ByteOrder, long, short, IsBufferNode, BranchProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeBufferShort(arg1Value, arg2Value, arg3Value, this.isBuffer, this.error, this.classProfile);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public int readBufferInt(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b100000) != 0 /* is-state_2 readBufferInt(HostObject, ByteOrder, long, IsBufferNode, BranchProfile, ValueProfile) */) {
                    return arg0Value.readBufferInt(arg1Value, arg2Value, this.isBuffer, this.error, this.classProfile);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readBufferIntNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private int readBufferIntNode_AndSpecialize(HostObject arg0Value, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b100000 /* add-state_2 readBufferInt(HostObject, ByteOrder, long, IsBufferNode, BranchProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readBufferInt(arg1Value, arg2Value, this.isBuffer, this.error, this.classProfile);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeBufferInt(Object arg0Value_, ByteOrder arg1Value, long arg2Value, int arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b1000000) != 0 /* is-state_2 writeBufferInt(HostObject, ByteOrder, long, int, IsBufferNode, BranchProfile, ValueProfile) */) {
                    arg0Value.writeBufferInt(arg1Value, arg2Value, arg3Value, this.isBuffer, this.error, this.classProfile);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeBufferIntNode_AndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
                return;
            }

            private void writeBufferIntNode_AndSpecialize(HostObject arg0Value, ByteOrder arg1Value, long arg2Value, int arg3Value) throws InvalidBufferOffsetException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b1000000 /* add-state_2 writeBufferInt(HostObject, ByteOrder, long, int, IsBufferNode, BranchProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeBufferInt(arg1Value, arg2Value, arg3Value, this.isBuffer, this.error, this.classProfile);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public long readBufferLong(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b10000000) != 0 /* is-state_2 readBufferLong(HostObject, ByteOrder, long, IsBufferNode, BranchProfile, ValueProfile) */) {
                    return arg0Value.readBufferLong(arg1Value, arg2Value, this.isBuffer, this.error, this.classProfile);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readBufferLongNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private long readBufferLongNode_AndSpecialize(HostObject arg0Value, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b10000000 /* add-state_2 readBufferLong(HostObject, ByteOrder, long, IsBufferNode, BranchProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readBufferLong(arg1Value, arg2Value, this.isBuffer, this.error, this.classProfile);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeBufferLong(Object arg0Value_, ByteOrder arg1Value, long arg2Value, long arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b100000000) != 0 /* is-state_2 writeBufferLong(HostObject, ByteOrder, long, long, IsBufferNode, BranchProfile, ValueProfile) */) {
                    arg0Value.writeBufferLong(arg1Value, arg2Value, arg3Value, this.isBuffer, this.error, this.classProfile);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeBufferLongNode_AndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
                return;
            }

            private void writeBufferLongNode_AndSpecialize(HostObject arg0Value, ByteOrder arg1Value, long arg2Value, long arg3Value) throws InvalidBufferOffsetException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b100000000 /* add-state_2 writeBufferLong(HostObject, ByteOrder, long, long, IsBufferNode, BranchProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeBufferLong(arg1Value, arg2Value, arg3Value, this.isBuffer, this.error, this.classProfile);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public float readBufferFloat(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b1000000000) != 0 /* is-state_2 readBufferFloat(HostObject, ByteOrder, long, IsBufferNode, BranchProfile, ValueProfile) */) {
                    return arg0Value.readBufferFloat(arg1Value, arg2Value, this.isBuffer, this.error, this.classProfile);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readBufferFloatNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private float readBufferFloatNode_AndSpecialize(HostObject arg0Value, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b1000000000 /* add-state_2 readBufferFloat(HostObject, ByteOrder, long, IsBufferNode, BranchProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readBufferFloat(arg1Value, arg2Value, this.isBuffer, this.error, this.classProfile);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeBufferFloat(Object arg0Value_, ByteOrder arg1Value, long arg2Value, float arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b10000000000) != 0 /* is-state_2 writeBufferFloat(HostObject, ByteOrder, long, float, IsBufferNode, BranchProfile, ValueProfile) */) {
                    arg0Value.writeBufferFloat(arg1Value, arg2Value, arg3Value, this.isBuffer, this.error, this.classProfile);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeBufferFloatNode_AndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
                return;
            }

            private void writeBufferFloatNode_AndSpecialize(HostObject arg0Value, ByteOrder arg1Value, long arg2Value, float arg3Value) throws InvalidBufferOffsetException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b10000000000 /* add-state_2 writeBufferFloat(HostObject, ByteOrder, long, float, IsBufferNode, BranchProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeBufferFloat(arg1Value, arg2Value, arg3Value, this.isBuffer, this.error, this.classProfile);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public double readBufferDouble(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b100000000000) != 0 /* is-state_2 readBufferDouble(HostObject, ByteOrder, long, IsBufferNode, BranchProfile, ValueProfile) */) {
                    return arg0Value.readBufferDouble(arg1Value, arg2Value, this.isBuffer, this.error, this.classProfile);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readBufferDoubleNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private double readBufferDoubleNode_AndSpecialize(HostObject arg0Value, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b100000000000 /* add-state_2 readBufferDouble(HostObject, ByteOrder, long, IsBufferNode, BranchProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readBufferDouble(arg1Value, arg2Value, this.isBuffer, this.error, this.classProfile);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeBufferDouble(Object arg0Value_, ByteOrder arg1Value, long arg2Value, double arg3Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b1000000000000) != 0 /* is-state_2 writeBufferDouble(HostObject, ByteOrder, long, double, IsBufferNode, BranchProfile, ValueProfile) */) {
                    arg0Value.writeBufferDouble(arg1Value, arg2Value, arg3Value, this.isBuffer, this.error, this.classProfile);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeBufferDoubleNode_AndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
                return;
            }

            private void writeBufferDoubleNode_AndSpecialize(HostObject arg0Value, ByteOrder arg1Value, long arg2Value, double arg3Value) throws InvalidBufferOffsetException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.isBuffer = super.insert(this.isBuffer == null ? ((IsBufferNodeGen.create())) : this.isBuffer);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b1000000000000 /* add-state_2 writeBufferDouble(HostObject, ByteOrder, long, double, IsBufferNode, BranchProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeBufferDouble(arg1Value, arg2Value, arg3Value, this.isBuffer, this.error, this.classProfile);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isNull(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).isNull();
            }

            @Override
            public boolean isExecutable(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b10000000000000) != 0 /* is-state_2 isExecutable(HostObject, LookupFunctionalMethodNode) */) {
                    return arg0Value.isExecutable(this.lookupFunctionalMethod);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isExecutableNode_AndSpecialize(arg0Value);
            }

            private boolean isExecutableNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.lookupFunctionalMethod = super.insert(this.lookupFunctionalMethod == null ? ((LookupFunctionalMethodNodeGen.create())) : this.lookupFunctionalMethod);
                    this.state_2_ = state_2 = state_2 | 0b10000000000000 /* add-state_2 isExecutable(HostObject, LookupFunctionalMethodNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isExecutable(this.lookupFunctionalMethod);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b100000000000000) != 0 /* is-state_2 execute(HostObject, Object[], HostExecuteNode, LookupFunctionalMethodNode, BranchProfile) */) {
                    return arg0Value.execute(arg1Value, this.hostExecute, this.lookupFunctionalMethod, this.error);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object executeNode_AndSpecialize(HostObject arg0Value, Object[] arg1Value) throws UnsupportedMessageException, UnsupportedTypeException, ArityException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.hostExecute = super.insert(this.hostExecute == null ? ((HostExecuteNode.create())) : this.hostExecute);
                    this.lookupFunctionalMethod = super.insert(this.lookupFunctionalMethod == null ? ((LookupFunctionalMethodNodeGen.create())) : this.lookupFunctionalMethod);
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_2_ = state_2 = state_2 | 0b100000000000000 /* add-state_2 execute(HostObject, Object[], HostExecuteNode, LookupFunctionalMethodNode, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.execute(arg1Value, this.hostExecute, this.lookupFunctionalMethod, this.error);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isNumber(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0b1000000000000000) != 0 /* is-state_2 isNumber(HostObject, ValueProfile) */) {
                    return arg0Value.isNumber(this.classProfile);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isNumberNode_AndSpecialize(arg0Value);
            }

            private boolean isNumberNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0b1000000000000000 /* add-state_2 isNumber(HostObject, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isNumber(this.classProfile);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean fitsInByte(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x10000) != 0 /* is-state_2 fitsInByte(HostObject, InteropLibrary, InteropLibrary) */) {
                    {
                        InteropLibrary fitsInByteNode__fitsInByte_thisLibrary__ = (this);
                        return arg0Value.fitsInByte(fitsInByteNode__fitsInByte_thisLibrary__, this.numbers);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInByteNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInByteNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary fitsInByteNode__fitsInByte_thisLibrary__ = null;
                        fitsInByteNode__fitsInByte_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.state_2_ = state_2 = state_2 | 0x10000 /* add-state_2 fitsInByte(HostObject, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.fitsInByte(fitsInByteNode__fitsInByte_thisLibrary__, this.numbers);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean fitsInShort(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x20000) != 0 /* is-state_2 fitsInShort(HostObject, InteropLibrary, InteropLibrary) */) {
                    {
                        InteropLibrary fitsInShortNode__fitsInShort_thisLibrary__ = (this);
                        return arg0Value.fitsInShort(fitsInShortNode__fitsInShort_thisLibrary__, this.numbers);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInShortNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInShortNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary fitsInShortNode__fitsInShort_thisLibrary__ = null;
                        fitsInShortNode__fitsInShort_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.state_2_ = state_2 = state_2 | 0x20000 /* add-state_2 fitsInShort(HostObject, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.fitsInShort(fitsInShortNode__fitsInShort_thisLibrary__, this.numbers);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean fitsInInt(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x40000) != 0 /* is-state_2 fitsInInt(HostObject, InteropLibrary, InteropLibrary) */) {
                    {
                        InteropLibrary fitsInIntNode__fitsInInt_thisLibrary__ = (this);
                        return arg0Value.fitsInInt(fitsInIntNode__fitsInInt_thisLibrary__, this.numbers);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInIntNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInIntNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary fitsInIntNode__fitsInInt_thisLibrary__ = null;
                        fitsInIntNode__fitsInInt_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.state_2_ = state_2 = state_2 | 0x40000 /* add-state_2 fitsInInt(HostObject, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.fitsInInt(fitsInIntNode__fitsInInt_thisLibrary__, this.numbers);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean fitsInLong(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x80000) != 0 /* is-state_2 fitsInLong(HostObject, InteropLibrary, InteropLibrary) */) {
                    {
                        InteropLibrary fitsInLongNode__fitsInLong_thisLibrary__ = (this);
                        return arg0Value.fitsInLong(fitsInLongNode__fitsInLong_thisLibrary__, this.numbers);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInLongNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInLongNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary fitsInLongNode__fitsInLong_thisLibrary__ = null;
                        fitsInLongNode__fitsInLong_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.state_2_ = state_2 = state_2 | 0x80000 /* add-state_2 fitsInLong(HostObject, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.fitsInLong(fitsInLongNode__fitsInLong_thisLibrary__, this.numbers);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean fitsInFloat(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x100000) != 0 /* is-state_2 fitsInFloat(HostObject, InteropLibrary, InteropLibrary) */) {
                    {
                        InteropLibrary fitsInFloatNode__fitsInFloat_thisLibrary__ = (this);
                        return arg0Value.fitsInFloat(fitsInFloatNode__fitsInFloat_thisLibrary__, this.numbers);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInFloatNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInFloatNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary fitsInFloatNode__fitsInFloat_thisLibrary__ = null;
                        fitsInFloatNode__fitsInFloat_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.state_2_ = state_2 = state_2 | 0x100000 /* add-state_2 fitsInFloat(HostObject, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.fitsInFloat(fitsInFloatNode__fitsInFloat_thisLibrary__, this.numbers);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean fitsInDouble(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x200000) != 0 /* is-state_2 fitsInDouble(HostObject, InteropLibrary, InteropLibrary) */) {
                    {
                        InteropLibrary fitsInDoubleNode__fitsInDouble_thisLibrary__ = (this);
                        return arg0Value.fitsInDouble(fitsInDoubleNode__fitsInDouble_thisLibrary__, this.numbers);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInDoubleNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInDoubleNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary fitsInDoubleNode__fitsInDouble_thisLibrary__ = null;
                        fitsInDoubleNode__fitsInDouble_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.state_2_ = state_2 = state_2 | 0x200000 /* add-state_2 fitsInDouble(HostObject, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.fitsInDouble(fitsInDoubleNode__fitsInDouble_thisLibrary__, this.numbers);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public byte asByte(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x400000) != 0 /* is-state_2 asByte(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    {
                        InteropLibrary asByteNode__asByte_thisLibrary__ = (this);
                        return arg0Value.asByte(asByteNode__asByte_thisLibrary__, this.numbers, this.error);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asByteNode_AndSpecialize(arg0Value);
            }

            private byte asByteNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary asByteNode__asByte_thisLibrary__ = null;
                        asByteNode__asByte_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                        this.state_2_ = state_2 = state_2 | 0x400000 /* add-state_2 asByte(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asByte(asByteNode__asByte_thisLibrary__, this.numbers, this.error);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public short asShort(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x800000) != 0 /* is-state_2 asShort(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    {
                        InteropLibrary asShortNode__asShort_thisLibrary__ = (this);
                        return arg0Value.asShort(asShortNode__asShort_thisLibrary__, this.numbers, this.error);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asShortNode_AndSpecialize(arg0Value);
            }

            private short asShortNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary asShortNode__asShort_thisLibrary__ = null;
                        asShortNode__asShort_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                        this.state_2_ = state_2 = state_2 | 0x800000 /* add-state_2 asShort(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asShort(asShortNode__asShort_thisLibrary__, this.numbers, this.error);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public int asInt(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x1000000) != 0 /* is-state_2 asInt(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    {
                        InteropLibrary asIntNode__asInt_thisLibrary__ = (this);
                        return arg0Value.asInt(asIntNode__asInt_thisLibrary__, this.numbers, this.error);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asIntNode_AndSpecialize(arg0Value);
            }

            private int asIntNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary asIntNode__asInt_thisLibrary__ = null;
                        asIntNode__asInt_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                        this.state_2_ = state_2 = state_2 | 0x1000000 /* add-state_2 asInt(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asInt(asIntNode__asInt_thisLibrary__, this.numbers, this.error);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public long asLong(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x2000000) != 0 /* is-state_2 asLong(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    {
                        InteropLibrary asLongNode__asLong_thisLibrary__ = (this);
                        return arg0Value.asLong(asLongNode__asLong_thisLibrary__, this.numbers, this.error);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asLongNode_AndSpecialize(arg0Value);
            }

            private long asLongNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary asLongNode__asLong_thisLibrary__ = null;
                        asLongNode__asLong_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                        this.state_2_ = state_2 = state_2 | 0x2000000 /* add-state_2 asLong(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asLong(asLongNode__asLong_thisLibrary__, this.numbers, this.error);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public float asFloat(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x4000000) != 0 /* is-state_2 asFloat(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    {
                        InteropLibrary asFloatNode__asFloat_thisLibrary__ = (this);
                        return arg0Value.asFloat(asFloatNode__asFloat_thisLibrary__, this.numbers, this.error);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asFloatNode_AndSpecialize(arg0Value);
            }

            private float asFloatNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary asFloatNode__asFloat_thisLibrary__ = null;
                        asFloatNode__asFloat_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                        this.state_2_ = state_2 = state_2 | 0x4000000 /* add-state_2 asFloat(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asFloat(asFloatNode__asFloat_thisLibrary__, this.numbers, this.error);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public double asDouble(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x8000000) != 0 /* is-state_2 asDouble(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    {
                        InteropLibrary asDoubleNode__asDouble_thisLibrary__ = (this);
                        return arg0Value.asDouble(asDoubleNode__asDouble_thisLibrary__, this.numbers, this.error);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asDoubleNode_AndSpecialize(arg0Value);
            }

            private double asDoubleNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary asDoubleNode__asDouble_thisLibrary__ = null;
                        asDoubleNode__asDouble_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                        this.state_2_ = state_2 = state_2 | 0x8000000 /* add-state_2 asDouble(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asDouble(asDoubleNode__asDouble_thisLibrary__, this.numbers, this.error);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isString(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x10000000) != 0 /* is-state_2 isString(HostObject, ValueProfile) */) {
                    return arg0Value.isString(this.classProfile);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isStringNode_AndSpecialize(arg0Value);
            }

            private boolean isStringNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.classProfile = this.classProfile == null ? ((ValueProfile.createClassProfile())) : this.classProfile;
                    this.state_2_ = state_2 = state_2 | 0x10000000 /* add-state_2 isString(HostObject, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isString(this.classProfile);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public String asString(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x20000000) != 0 /* is-state_2 asString(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    {
                        InteropLibrary asStringNode__asString_thisLibrary__ = (this);
                        return arg0Value.asString(asStringNode__asString_thisLibrary__, this.numbers, this.error);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asStringNode_AndSpecialize(arg0Value);
            }

            private String asStringNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    {
                        InteropLibrary asStringNode__asString_thisLibrary__ = null;
                        asStringNode__asString_thisLibrary__ = (this);
                        this.numbers = super.insert(this.numbers == null ? ((INTEROP_LIBRARY_.createDispatched(HostObject.LIMIT))) : this.numbers);
                        this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                        this.state_2_ = state_2 = state_2 | 0x20000000 /* add-state_2 asString(HostObject, InteropLibrary, InteropLibrary, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.asString(asStringNode__asString_thisLibrary__, this.numbers, this.error);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isBoolean(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).isBoolean();
            }

            @Override
            public boolean asBoolean(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x40000000) != 0 /* is-state_2 asBoolean(HostObject, BranchProfile) */) {
                    return arg0Value.asBoolean(this.error);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asBooleanNode_AndSpecialize(arg0Value);
            }

            private boolean asBooleanNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_2_ = state_2 = state_2 | 0x40000000 /* add-state_2 asBoolean(HostObject, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.asBoolean(this.error);
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
                return (((HostObject) receiver)).isDate();
            }

            @Override
            public LocalDate asDate(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).asDate();
            }

            @Override
            public boolean isTime(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).isTime();
            }

            @Override
            public LocalTime asTime(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).asTime();
            }

            @Override
            public boolean isTimeZone(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).isTimeZone();
            }

            @Override
            public ZoneId asTimeZone(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).asTimeZone();
            }

            @Override
            public Instant asInstant(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).asInstant();
            }

            @Override
            public boolean isDuration(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).isDuration();
            }

            @Override
            public Duration asDuration(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).asDuration();
            }

            @Override
            public boolean isException(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).isException();
            }

            @Override
            public ExceptionType getExceptionType(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_2 = this.state_2_;
                if ((state_2 & 0x80000000) != 0 /* is-state_2 getExceptionType(HostObject, BranchProfile) */) {
                    return arg0Value.getExceptionType(this.error);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getExceptionTypeNode_AndSpecialize(arg0Value);
            }

            private ExceptionType getExceptionTypeNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_2 = this.state_2_;
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_2_ = state_2 = state_2 | 0x80000000 /* add-state_2 getExceptionType(HostObject, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getExceptionType(this.error);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isExceptionIncompleteSource(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_3 = this.state_3_;
                if ((state_3 & 0b1) != 0 /* is-state_3 isExceptionIncompleteSource(HostObject, BranchProfile) */) {
                    return arg0Value.isExceptionIncompleteSource(this.error);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isExceptionIncompleteSourceNode_AndSpecialize(arg0Value);
            }

            private boolean isExceptionIncompleteSourceNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_3 = this.state_3_;
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_3_ = state_3 = state_3 | 0b1 /* add-state_3 isExceptionIncompleteSource(HostObject, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isExceptionIncompleteSource(this.error);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public int getExceptionExitStatus(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_3 = this.state_3_;
                if ((state_3 & 0b10) != 0 /* is-state_3 getExceptionExitStatus(HostObject, BranchProfile) */) {
                    return arg0Value.getExceptionExitStatus(this.error);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getExceptionExitStatusNode_AndSpecialize(arg0Value);
            }

            private int getExceptionExitStatusNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_3 = this.state_3_;
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_3_ = state_3 = state_3 | 0b10 /* add-state_3 getExceptionExitStatus(HostObject, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getExceptionExitStatus(this.error);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasExceptionMessage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).hasExceptionMessage();
            }

            @Override
            public Object getExceptionMessage(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_3 = this.state_3_;
                if ((state_3 & 0b100) != 0 /* is-state_3 getExceptionMessage(HostObject, BranchProfile) */) {
                    return arg0Value.getExceptionMessage(this.error);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getExceptionMessageNode_AndSpecialize(arg0Value);
            }

            private Object getExceptionMessageNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_3 = this.state_3_;
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_3_ = state_3 = state_3 | 0b100 /* add-state_3 getExceptionMessage(HostObject, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getExceptionMessage(this.error);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasExceptionCause(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).hasExceptionCause();
            }

            @Override
            public Object getExceptionCause(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).getExceptionCause();
            }

            @Override
            public boolean hasExceptionStackTrace(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).hasExceptionStackTrace();
            }

            @Override
            public Object getExceptionStackTrace(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).getExceptionStackTrace();
            }

            @Override
            public RuntimeException throwException(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_3 = this.state_3_;
                if ((state_3 & 0b1000) != 0 /* is-state_3 throwException(HostObject, BranchProfile) */) {
                    return arg0Value.throwException(this.error);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return throwExceptionNode_AndSpecialize(arg0Value);
            }

            private RuntimeException throwExceptionNode_AndSpecialize(HostObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_3 = this.state_3_;
                    this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                    this.state_3_ = state_3 = state_3 | 0b1000 /* add-state_3 throwException(HostObject, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.throwException(this.error);
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
                return (((HostObject) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).getLanguage();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).toDisplayString(allowSideEffects);
            }

            @Override
            public boolean hasIterator(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_3 = this.state_3_;
                if ((state_3 & 0b10000) != 0 /* is-state_3 hasIterator(HostObject, IsIterableNode, IsArrayNode) */) {
                    return arg0Value.hasIterator(this.isIterable, this.isArray);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasIteratorNode_AndSpecialize(arg0Value);
            }

            private boolean hasIteratorNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_3 = this.state_3_;
                    this.isIterable = super.insert(this.isIterable == null ? ((IsIterableNodeGen.create())) : this.isIterable);
                    this.isArray = super.insert(this.isArray == null ? ((IsArrayNodeGen.create())) : this.isArray);
                    this.state_3_ = state_3 = state_3 | 0b10000 /* add-state_3 hasIterator(HostObject, IsIterableNode, IsArrayNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasIterator(this.isIterable, this.isArray);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isIterator(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_3 = this.state_3_;
                if ((state_3 & 0b100000) != 0 /* is-state_3 isIterator(HostObject, IsIteratorNode) */) {
                    return arg0Value.isIterator(this.isIterator);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isIteratorNode_AndSpecialize(arg0Value);
            }

            private boolean isIteratorNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_3 = this.state_3_;
                    this.isIterator = super.insert(this.isIterator == null ? ((IsIteratorNodeGen.create())) : this.isIterator);
                    this.state_3_ = state_3 = state_3 | 0b100000 /* add-state_3 isIterator(HostObject, IsIteratorNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isIterator(this.isIterator);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasHashEntries(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_3 = this.state_3_;
                if ((state_3 & 0b1000000) != 0 /* is-state_3 hasHashEntries(HostObject, IsMapNode) */) {
                    return arg0Value.hasHashEntries(this.isMap);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasHashEntriesNode_AndSpecialize(arg0Value);
            }

            private boolean hasHashEntriesNode_AndSpecialize(HostObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_3 = this.state_3_;
                    this.isMap = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                    this.state_3_ = state_3 = state_3 | 0b1000000 /* add-state_3 hasHashEntries(HostObject, IsMapNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasHashEntries(this.isMap);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_3 = this.state_3_;
                if ((state_3 & 0b10000000) != 0 /* is-state_3 isHashEntryReadable(HostObject, Object, IsMapNode, ContainsKeyNode) */) {
                    return arg0Value.isHashEntryReadable(arg1Value, this.isMap, this.containsKey);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isHashEntryReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isHashEntryReadableNode_AndSpecialize(HostObject arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_3 = this.state_3_;
                    this.isMap = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                    this.containsKey = super.insert(this.containsKey == null ? ((ContainsKeyNodeGen.create())) : this.containsKey);
                    this.state_3_ = state_3 = state_3 | 0b10000000 /* add-state_3 isHashEntryReadable(HostObject, Object, IsMapNode, ContainsKeyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isHashEntryReadable(arg1Value, this.isMap, this.containsKey);
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_3 = this.state_3_;
                if ((state_3 & 0b10000000) != 0 /* is-state_3 isHashEntryReadable(HostObject, Object, IsMapNode, ContainsKeyNode) */) {
                    return arg0Value.isHashEntryReadable(arg1Value, this.isMap, this.containsKey);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isHashEntryReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            @Override
            public boolean isHashEntryRemovable(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_3 = this.state_3_;
                if ((state_3 & 0b10000000) != 0 /* is-state_3 isHashEntryReadable(HostObject, Object, IsMapNode, ContainsKeyNode) */) {
                    return arg0Value.isHashEntryReadable(arg1Value, this.isMap, this.containsKey);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isHashEntryReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            @Override
            public boolean isHashEntryInsertable(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_3 = this.state_3_;
                if ((state_3 & 0b100000000) != 0 /* is-state_3 isHashEntryInsertable(HostObject, Object, IsMapNode, ContainsKeyNode) */) {
                    return arg0Value.isHashEntryInsertable(arg1Value, this.isMap, this.containsKey);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isHashEntryInsertableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isHashEntryInsertableNode_AndSpecialize(HostObject arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_3 = this.state_3_;
                    this.isMap = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                    this.containsKey = super.insert(this.containsKey == null ? ((ContainsKeyNodeGen.create())) : this.containsKey);
                    this.state_3_ = state_3 = state_3 | 0b100000000 /* add-state_3 isHashEntryInsertable(HostObject, Object, IsMapNode, ContainsKeyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isHashEntryInsertable(arg1Value, this.isMap, this.containsKey);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasMetaObject(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).hasMetaObject();
            }

            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).getMetaObject();
            }

            @Override
            public boolean isMetaObject(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).isMetaObject();
            }

            @Override
            public Object getMetaQualifiedName(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).getMetaQualifiedName();
            }

            @Override
            public Object getMetaSimpleName(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostObject) receiver)).getMetaSimpleName();
            }

            @Override
            public boolean isMetaInstance(Object arg0Value_, Object arg1Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostObject arg0Value = ((HostObject) arg0Value_);
                int state_3 = this.state_3_;
                if ((state_3 & 0b1000000000) != 0 /* is-state_3 isMetaInstance(HostObject, Object, InteropLibrary, BranchProfile) */) {
                    {
                        InteropLibrary isMetaInstanceNode__isMetaInstance_library__ = (this);
                        return arg0Value.isMetaInstance(arg1Value, isMetaInstanceNode__isMetaInstance_library__, this.error);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMetaInstanceNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMetaInstanceNode_AndSpecialize(HostObject arg0Value, Object arg1Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_3 = this.state_3_;
                    {
                        InteropLibrary isMetaInstanceNode__isMetaInstance_library__ = null;
                        isMetaInstanceNode__isMetaInstance_library__ = (this);
                        this.error = this.error == null ? ((BranchProfile.create())) : this.error;
                        this.state_3_ = state_3 = state_3 | 0b1000000000 /* add-state_3 isMetaInstance(HostObject, Object, InteropLibrary, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.isMetaInstance(arg1Value, isMetaInstanceNode__isMetaInstance_library__, this.error);
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
                return HostObject.identityHashCode((((HostObject) receiver)));
            }

            private static boolean isIdenticalOrUndefinedFallbackGuard_(int state_1, HostObject arg0Value, Object arg1Value) {
                if (((state_1 & 0x800000)) == 0 /* is-not-state_1 doHostObject(HostObject, HostObject) */ && arg1Value instanceof HostObject) {
                    return false;
                }
                return true;
            }

            @GeneratedBy(HostObject.class)
            private static final class IsMemberReadableCachedData {

                @CompilationFinal IsMemberReadableCachedData next_;
                @CompilationFinal boolean cachedStatic_;
                @CompilationFinal Class<?> cachedClazz_;
                @CompilationFinal String cachedName_;
                @CompilationFinal boolean cachedReadable_;

                IsMemberReadableCachedData(IsMemberReadableCachedData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(HostObject.class)
            private static final class IsMemberModifiableCachedData {

                @CompilationFinal IsMemberModifiableCachedData next_;
                @CompilationFinal boolean cachedStatic_;
                @CompilationFinal Class<?> cachedClazz_;
                @CompilationFinal String cachedName_;
                @CompilationFinal boolean cachedModifiable_;

                IsMemberModifiableCachedData(IsMemberModifiableCachedData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(HostObject.class)
            private static final class IsMemberInternalCachedData {

                @CompilationFinal IsMemberInternalCachedData next_;
                @CompilationFinal boolean cachedStatic_;
                @CompilationFinal Class<?> cachedClazz_;
                @CompilationFinal String cachedName_;
                @CompilationFinal boolean cachedInternal_;

                IsMemberInternalCachedData(IsMemberInternalCachedData next_) {
                    this.next_ = next_;
                }

            }
            @GeneratedBy(HostObject.class)
            private static final class IsMemberInvocableCachedData {

                @CompilationFinal IsMemberInvocableCachedData next_;
                @CompilationFinal boolean cachedStatic_;
                @CompilationFinal Class<?> cachedClazz_;
                @CompilationFinal String cachedName_;
                @CompilationFinal boolean cachedInvokable_;

                IsMemberInvocableCachedData(IsMemberInvocableCachedData next_) {
                    this.next_ = next_;
                }

            }
        }
        @GeneratedBy(HostObject.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof HostObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof HostObject;
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
                HostObject arg0Value = ((HostObject) arg0Value_);
                return IsMemberReadable.doUncached(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return IsMemberModifiable.doUncached(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInternal(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return IsMemberInternal.doUncached(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return IsMemberInvocable.doUncached(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsArrayNodeGen.getUncached()).execute(arg0Value))) {
                    return IsArrayElementReadable.doArray(arg0Value, arg1Value, (IsArrayNodeGen.getUncached()));
                }
                if (((IsListNodeGen.getUncached()).execute(arg0Value))) {
                    return IsArrayElementReadable.doList(arg0Value, arg1Value, (IsListNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if (((IsMapEntryNodeGen.getUncached()).execute(arg0Value))) {
                    return IsArrayElementReadable.doMapEntry(arg0Value, arg1Value, (IsMapEntryNodeGen.getUncached()));
                }
                if ((!((IsListNodeGen.getUncached()).execute(arg0Value))) && (!((IsArrayNodeGen.getUncached()).execute(arg0Value))) && (!((IsMapEntryNodeGen.getUncached()).execute(arg0Value)))) {
                    return IsArrayElementReadable.doNotArrayOrList(arg0Value, arg1Value, (IsListNodeGen.getUncached()), (IsArrayNodeGen.getUncached()), (IsMapEntryNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementModifiable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsArrayNodeGen.getUncached()).execute(arg0Value))) {
                    return IsArrayElementModifiable.doArray(arg0Value, arg1Value, (IsArrayNodeGen.getUncached()));
                }
                if (((IsListNodeGen.getUncached()).execute(arg0Value))) {
                    return IsArrayElementModifiable.doList(arg0Value, arg1Value, (IsListNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if (((IsMapEntryNodeGen.getUncached()).execute(arg0Value))) {
                    return IsArrayElementModifiable.doMapEntry(arg0Value, arg1Value, (IsMapEntryNodeGen.getUncached()));
                }
                if ((!((IsListNodeGen.getUncached()).execute(arg0Value))) && (!((IsArrayNodeGen.getUncached()).execute(arg0Value))) && (!((IsMapEntryNodeGen.getUncached()).execute(arg0Value)))) {
                    return IsArrayElementModifiable.doNotArrayOrList(arg0Value, arg1Value, (IsListNodeGen.getUncached()), (IsArrayNodeGen.getUncached()), (IsMapEntryNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public void writeArrayElement(Object arg0Value_, long arg1Value, Object arg2Value) throws InvalidArrayIndexException, UnsupportedTypeException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsArrayNodeGen.getUncached()).execute(arg0Value))) {
                    WriteArrayElement.doArray(arg0Value, arg1Value, arg2Value, (HostToTypeNodeGen.getUncached()), (IsArrayNodeGen.getUncached()), (ArraySetNodeGen.getUncached()), (BranchProfile.getUncached()));
                    return;
                }
                if (((IsListNodeGen.getUncached()).execute(arg0Value))) {
                    WriteArrayElement.doList(arg0Value, arg1Value, arg2Value, (IsListNodeGen.getUncached()), (HostToTypeNodeGen.getUncached()), (BranchProfile.getUncached()));
                    return;
                }
                if (((IsMapEntryNodeGen.getUncached()).execute(arg0Value))) {
                    WriteArrayElement.doMapEntry(arg0Value, arg1Value, arg2Value, (IsMapEntryNodeGen.getUncached()), (HostToTypeNodeGen.getUncached()), (BranchProfile.getUncached()));
                    return;
                }
                if ((!((IsListNodeGen.getUncached()).execute(arg0Value))) && (!((IsArrayNodeGen.getUncached()).execute(arg0Value))) && (!((IsMapEntryNodeGen.getUncached()).execute(arg0Value)))) {
                    WriteArrayElement.doNotArrayOrList(arg0Value, arg1Value, arg2Value, (IsListNodeGen.getUncached()), (IsArrayNodeGen.getUncached()), (IsMapEntryNodeGen.getUncached()));
                    return;
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementRemovable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsListNodeGen.getUncached()).execute(arg0Value))) {
                    return IsArrayElementRemovable.doList(arg0Value, arg1Value, (IsListNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if ((!((IsListNodeGen.getUncached()).execute(arg0Value)))) {
                    return IsArrayElementRemovable.doOther(arg0Value, arg1Value, (IsListNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public void removeArrayElement(Object arg0Value_, long arg1Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsListNodeGen.getUncached()).execute(arg0Value))) {
                    RemoveArrayElement.doList(arg0Value, arg1Value, (IsListNodeGen.getUncached()), (BranchProfile.getUncached()));
                    return;
                }
                if ((!((IsListNodeGen.getUncached()).execute(arg0Value)))) {
                    RemoveArrayElement.doOther(arg0Value, arg1Value, (IsListNodeGen.getUncached()));
                    return;
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsArrayNodeGen.getUncached()).execute(arg0Value))) {
                    return ReadArrayElement.doArray(arg0Value, arg1Value, (ArrayGetNodeGen.getUncached()), (IsArrayNodeGen.getUncached()), (ToGuestValueNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if (((IsListNodeGen.getUncached()).execute(arg0Value))) {
                    return ReadArrayElement.doList(arg0Value, arg1Value, (IsListNodeGen.getUncached()), (ToGuestValueNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if (((IsMapEntryNodeGen.getUncached()).execute(arg0Value))) {
                    return ReadArrayElement.doMapEntry(arg0Value, arg1Value, (IsMapEntryNodeGen.getUncached()), (ToGuestValueNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if ((!((IsArrayNodeGen.getUncached()).execute(arg0Value))) && (!((IsListNodeGen.getUncached()).execute(arg0Value))) && (!((IsMapEntryNodeGen.getUncached()).execute(arg0Value)))) {
                    return ReadArrayElement.doNotArrayOrList(arg0Value, arg1Value, (IsArrayNodeGen.getUncached()), (IsListNodeGen.getUncached()), (IsMapEntryNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public long getArraySize(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsArrayNodeGen.getUncached()).execute(arg0Value))) {
                    return GetArraySize.doArray(arg0Value, (IsArrayNodeGen.getUncached()));
                }
                if (((IsListNodeGen.getUncached()).execute(arg0Value))) {
                    return GetArraySize.doList(arg0Value, (IsListNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if (((IsMapEntryNodeGen.getUncached()).execute(arg0Value))) {
                    return GetArraySize.doMapEntry(arg0Value, (IsMapEntryNodeGen.getUncached()));
                }
                if ((!((IsArrayNodeGen.getUncached()).execute(arg0Value))) && (!((IsListNodeGen.getUncached()).execute(arg0Value))) && (!((IsMapEntryNodeGen.getUncached()).execute(arg0Value)))) {
                    return GetArraySize.doNotArrayOrList(arg0Value, (IsArrayNodeGen.getUncached()), (IsListNodeGen.getUncached()), (IsMapEntryNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
            }

            @TruffleBoundary
            @Override
            public boolean isInstantiable(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if ((!(arg0Value.isClass()))) {
                    return IsInstantiable.doUnsupported(arg0Value);
                }
                if ((arg0Value.isArrayClass())) {
                    return IsInstantiable.doArrayCached(arg0Value);
                }
                if ((arg0Value.isDefaultClass())) {
                    return IsInstantiable.doObjectCached(arg0Value, (LookupConstructorNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
            }

            @TruffleBoundary
            @Override
            public Object instantiate(Object arg0Value_, Object... arg1Value) throws UnsupportedMessageException, UnsupportedTypeException, ArityException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if ((!(arg0Value.isClass()))) {
                    return Instantiate.doUnsupported(arg0Value, arg1Value);
                }
                if ((arg0Value.isArrayClass())) {
                    return Instantiate.doArrayCached(arg0Value, arg1Value, (INTEROP_LIBRARY_.getUncached()), (BranchProfile.getUncached()));
                }
                if ((arg0Value.isDefaultClass())) {
                    return Instantiate.doObjectCached(arg0Value, arg1Value, (LookupConstructorNodeGen.getUncached()), (HostExecuteNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public Object getIterator(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsArrayNodeGen.getUncached()).execute(arg0Value))) {
                    return GetIterator.doArray(arg0Value, (IsArrayNodeGen.getUncached()), (ToGuestValueNodeGen.getUncached()));
                }
                if (((IsIterableNodeGen.getUncached()).execute(arg0Value))) {
                    return GetIterator.doIterable(arg0Value, (IsIterableNodeGen.getUncached()), (ToGuestValueNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if ((!((IsArrayNodeGen.getUncached()).execute(arg0Value))) && (!((IsIterableNodeGen.getUncached()).execute(arg0Value)))) {
                    return GetIterator.doNotArrayOrIterable(arg0Value, (IsArrayNodeGen.getUncached()), (IsIterableNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
            }

            @TruffleBoundary
            @Override
            public boolean hasIteratorNextElement(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsIteratorNodeGen.getUncached()).execute(arg0Value))) {
                    return HasIteratorNextElement.doIterator(arg0Value, (IsIteratorNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if ((!((IsIteratorNodeGen.getUncached()).execute(arg0Value)))) {
                    return HasIteratorNextElement.doNotIterator(arg0Value, (IsIteratorNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
            }

            @TruffleBoundary
            @Override
            public Object getIteratorNextElement(Object arg0Value_) throws StopIterationException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsIteratorNodeGen.getUncached()).execute(arg0Value))) {
                    return GetIteratorNextElement.doIterator(arg0Value, (IsIteratorNodeGen.getUncached()), (ToGuestValueNodeGen.getUncached()), (BranchProfile.getUncached()), (BranchProfile.getUncached()));
                }
                if ((!((IsIteratorNodeGen.getUncached()).execute(arg0Value)))) {
                    return GetIteratorNextElement.doNotIterator(arg0Value, (IsIteratorNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
            }

            @TruffleBoundary
            @Override
            public long getHashSize(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsMapNodeGen.getUncached()).execute(arg0Value))) {
                    return GetHashSize.doMap(arg0Value, (IsMapNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if ((!((IsMapNodeGen.getUncached()).execute(arg0Value)))) {
                    return GetHashSize.doNotMap(arg0Value, (IsMapNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
            }

            @TruffleBoundary
            @Override
            public Object readHashValue(Object arg0Value_, Object arg1Value) throws UnknownKeyException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsMapNodeGen.getUncached()).execute(arg0Value))) {
                    return ReadHashValue.doMap(arg0Value, arg1Value, (IsMapNodeGen.getUncached()), (HostToTypeNodeGen.getUncached()), (ToGuestValueNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if ((!((IsMapNodeGen.getUncached()).execute(arg0Value)))) {
                    return ReadHashValue.doNotMap(arg0Value, arg1Value, (IsMapNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public void writeHashEntry(Object arg0Value_, Object arg1Value, Object arg2Value) throws UnsupportedTypeException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsMapNodeGen.getUncached()).execute(arg0Value))) {
                    WriteHashEntry.doMap(arg0Value, arg1Value, arg2Value, (IsMapNodeGen.getUncached()), (HostToTypeNodeGen.getUncached()), (BranchProfile.getUncached()));
                    return;
                }
                if ((!((IsMapNodeGen.getUncached()).execute(arg0Value)))) {
                    WriteHashEntry.doNotMap(arg0Value, arg1Value, arg2Value, (IsMapNodeGen.getUncached()));
                    return;
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
            }

            @TruffleBoundary
            @Override
            public void removeHashEntry(Object arg0Value_, Object arg1Value) throws UnknownKeyException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsMapNodeGen.getUncached()).execute(arg0Value))) {
                    RemoveHashEntry.doMap(arg0Value, arg1Value, (IsMapNodeGen.getUncached()), (HostToTypeNodeGen.getUncached()), (BranchProfile.getUncached()));
                    return;
                }
                if ((!((IsMapNodeGen.getUncached()).execute(arg0Value)))) {
                    RemoveHashEntry.doNotMap(arg0Value, arg1Value, (IsMapNodeGen.getUncached()));
                    return;
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public Object getHashEntriesIterator(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (((IsMapNodeGen.getUncached()).execute(arg0Value))) {
                    return GetHashEntriesIterator.doMap(arg0Value, (IsMapNodeGen.getUncached()), (ToGuestValueNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if ((!((IsMapNodeGen.getUncached()).execute(arg0Value)))) {
                    return GetHashEntriesIterator.doNotMap(arg0Value, (IsMapNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
            }

            @TruffleBoundary
            @Override
            public TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                if (arg1Value instanceof HostObject) {
                    HostObject arg1Value_ = (HostObject) arg1Value;
                    return IsIdenticalOrUndefined.doHostObject(arg0Value, arg1Value_);
                }
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .getMembers(includeInternal);
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.readMember(arg1Value, (LookupFieldNodeGen.getUncached()), (ReadFieldNodeGen.getUncached()), (LookupMethodNodeGen.getUncached()), (LookupInnerClassNodeGen.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .isMemberInsertable(member);
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                arg0Value.writeMember(arg1Value, arg2Value, (LookupFieldNodeGen.getUncached()), (WriteFieldNodeGen.getUncached()), (BranchProfile.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.invokeMember(arg1Value, arg2Value, (LookupMethodNodeGen.getUncached()), (HostExecuteNodeGen.getUncached()), (LookupFieldNodeGen.getUncached()), (ReadFieldNodeGen.getUncached()), (INTEROP_LIBRARY_.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementInsertable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.isArrayElementInsertable(arg1Value, (IsListNodeGen.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasArrayElements(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.hasArrayElements((IsListNodeGen.getUncached()), (IsArrayNodeGen.getUncached()), (IsMapEntryNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasBufferElements(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.hasBufferElements((IsBufferNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isBufferWritable(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.isBufferWritable((IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public long getBufferSize(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.getBufferSize((IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public byte readBufferByte(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.readBufferByte(arg1Value, (IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()), (ValueProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeBufferByte(Object arg0Value_, long arg1Value, byte arg2Value) throws InvalidBufferOffsetException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                arg0Value.writeBufferByte(arg1Value, arg2Value, (IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()), (ValueProfile.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public short readBufferShort(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.readBufferShort(arg1Value, arg2Value, (IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()), (ValueProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeBufferShort(Object arg0Value_, ByteOrder arg1Value, long arg2Value, short arg3Value) throws InvalidBufferOffsetException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                arg0Value.writeBufferShort(arg1Value, arg2Value, arg3Value, (IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()), (ValueProfile.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public int readBufferInt(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.readBufferInt(arg1Value, arg2Value, (IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()), (ValueProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeBufferInt(Object arg0Value_, ByteOrder arg1Value, long arg2Value, int arg3Value) throws InvalidBufferOffsetException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                arg0Value.writeBufferInt(arg1Value, arg2Value, arg3Value, (IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()), (ValueProfile.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public long readBufferLong(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.readBufferLong(arg1Value, arg2Value, (IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()), (ValueProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeBufferLong(Object arg0Value_, ByteOrder arg1Value, long arg2Value, long arg3Value) throws InvalidBufferOffsetException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                arg0Value.writeBufferLong(arg1Value, arg2Value, arg3Value, (IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()), (ValueProfile.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public float readBufferFloat(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.readBufferFloat(arg1Value, arg2Value, (IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()), (ValueProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeBufferFloat(Object arg0Value_, ByteOrder arg1Value, long arg2Value, float arg3Value) throws InvalidBufferOffsetException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                arg0Value.writeBufferFloat(arg1Value, arg2Value, arg3Value, (IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()), (ValueProfile.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public double readBufferDouble(Object arg0Value_, ByteOrder arg1Value, long arg2Value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.readBufferDouble(arg1Value, arg2Value, (IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()), (ValueProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeBufferDouble(Object arg0Value_, ByteOrder arg1Value, long arg2Value, double arg3Value) throws InvalidBufferOffsetException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                arg0Value.writeBufferDouble(arg1Value, arg2Value, arg3Value, (IsBufferNodeGen.getUncached()), (BranchProfile.getUncached()), (ValueProfile.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isNull(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .isNull();
            }

            @TruffleBoundary
            @Override
            public boolean isExecutable(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.isExecutable((LookupFunctionalMethodNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedMessageException, UnsupportedTypeException, ArityException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.execute(arg1Value, (HostExecuteNodeGen.getUncached()), (LookupFunctionalMethodNodeGen.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isNumber(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.isNumber((ValueProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInByte(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.fitsInByte((this), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInShort(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.fitsInShort((this), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInInt(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.fitsInInt((this), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInLong(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.fitsInLong((this), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInFloat(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.fitsInFloat((this), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInDouble(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.fitsInDouble((this), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public byte asByte(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.asByte((this), (INTEROP_LIBRARY_.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public short asShort(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.asShort((this), (INTEROP_LIBRARY_.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public int asInt(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.asInt((this), (INTEROP_LIBRARY_.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public long asLong(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.asLong((this), (INTEROP_LIBRARY_.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public float asFloat(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.asFloat((this), (INTEROP_LIBRARY_.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public double asDouble(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.asDouble((this), (INTEROP_LIBRARY_.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isString(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.isString((ValueProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public String asString(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.asString((this), (INTEROP_LIBRARY_.getUncached()), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isBoolean(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .isBoolean();
            }

            @TruffleBoundary
            @Override
            public boolean asBoolean(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.asBoolean((BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isDate(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .isDate();
            }

            @TruffleBoundary
            @Override
            public LocalDate asDate(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .asDate();
            }

            @TruffleBoundary
            @Override
            public boolean isTime(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .isTime();
            }

            @TruffleBoundary
            @Override
            public LocalTime asTime(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .asTime();
            }

            @TruffleBoundary
            @Override
            public boolean isTimeZone(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .isTimeZone();
            }

            @TruffleBoundary
            @Override
            public ZoneId asTimeZone(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .asTimeZone();
            }

            @TruffleBoundary
            @Override
            public Instant asInstant(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .asInstant();
            }

            @TruffleBoundary
            @Override
            public boolean isDuration(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .isDuration();
            }

            @TruffleBoundary
            @Override
            public Duration asDuration(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .asDuration();
            }

            @TruffleBoundary
            @Override
            public boolean isException(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .isException();
            }

            @TruffleBoundary
            @Override
            public ExceptionType getExceptionType(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.getExceptionType((BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isExceptionIncompleteSource(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.isExceptionIncompleteSource((BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public int getExceptionExitStatus(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.getExceptionExitStatus((BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasExceptionMessage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .hasExceptionMessage();
            }

            @TruffleBoundary
            @Override
            public Object getExceptionMessage(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.getExceptionMessage((BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasExceptionCause(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .hasExceptionCause();
            }

            @TruffleBoundary
            @Override
            public Object getExceptionCause(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .getExceptionCause();
            }

            @TruffleBoundary
            @Override
            public boolean hasExceptionStackTrace(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .hasExceptionStackTrace();
            }

            @TruffleBoundary
            @Override
            public Object getExceptionStackTrace(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .getExceptionStackTrace();
            }

            @TruffleBoundary
            @Override
            public RuntimeException throwException(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.throwException((BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public boolean hasIterator(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.hasIterator((IsIterableNodeGen.getUncached()), (IsArrayNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isIterator(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.isIterator((IsIteratorNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasHashEntries(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.hasHashEntries((IsMapNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryReadable(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.isHashEntryReadable(arg1Value, (IsMapNodeGen.getUncached()), (ContainsKeyNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryModifiable(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.isHashEntryReadable(arg1Value, (IsMapNodeGen.getUncached()), (ContainsKeyNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryRemovable(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.isHashEntryReadable(arg1Value, (IsMapNodeGen.getUncached()), (ContainsKeyNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryInsertable(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.isHashEntryInsertable(arg1Value, (IsMapNodeGen.getUncached()), (ContainsKeyNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMetaObject(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .hasMetaObject();
            }

            @TruffleBoundary
            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .getMetaObject();
            }

            @TruffleBoundary
            @Override
            public boolean isMetaObject(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .isMetaObject();
            }

            @TruffleBoundary
            @Override
            public Object getMetaQualifiedName(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .getMetaQualifiedName();
            }

            @TruffleBoundary
            @Override
            public Object getMetaSimpleName(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostObject) receiver) .getMetaSimpleName();
            }

            @TruffleBoundary
            @Override
            public boolean isMetaInstance(Object arg0Value_, Object arg1Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostObject arg0Value = ((HostObject) arg0Value_);
                return arg0Value.isMetaInstance(arg1Value, (this), (BranchProfile.getUncached()));
            }

            @TruffleBoundary
            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return HostObject.identityHashCode(((HostObject) receiver) );
            }

        }
    }
}
