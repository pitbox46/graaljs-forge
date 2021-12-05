// CheckStyle: start generated
package com.oracle.truffle.js.runtime;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.api.utilities.TriState;
import com.oracle.truffle.js.runtime.GraalJSException.IsIdenticalOrUndefined;
import com.oracle.truffle.js.runtime.objects.JSDynamicObject;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GraalJSException.class)
public final class GraalJSExceptionGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(GraalJSException.class, new InteropLibraryExports());
    }

    private GraalJSExceptionGen() {
    }

    @GeneratedBy(GraalJSException.class)
    public static class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, GraalJSException.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof GraalJSException;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof GraalJSException;
            return new Cached(receiver);
        }

        @GeneratedBy(GraalJSException.class)
        public static class Cached extends InteropLibrary {

            private final Class<? extends GraalJSException> receiverClass_;
            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private InteropLibrary thisLib;
            @Child private InteropLibrary otherLib;
            @Child private InteropLibrary identityHashCodeNode__identityHashCode_delegateLib_;

            protected Cached(Object receiver) {
                GraalJSException castReceiver = ((GraalJSException) receiver) ;
                this.receiverClass_ = castReceiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            protected TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                GraalJSException arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b111) != 0 /* is-state_0 doException(GraalJSException, GraalJSException, InteropLibrary, InteropLibrary) || doJSObject(GraalJSException, JSDynamicObject) || doOther(GraalJSException, Object, InteropLibrary, InteropLibrary) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doException(GraalJSException, GraalJSException, InteropLibrary, InteropLibrary) */ && arg1Value instanceof GraalJSException) {
                        GraalJSException arg1Value_ = (GraalJSException) arg1Value;
                        return IsIdenticalOrUndefined.doException(arg0Value, arg1Value_, this.thisLib, this.otherLib);
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doJSObject(GraalJSException, JSDynamicObject) */ && arg1Value instanceof JSDynamicObject) {
                        JSDynamicObject arg1Value_ = (JSDynamicObject) arg1Value;
                        return IsIdenticalOrUndefined.doJSObject(arg0Value, arg1Value_);
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doOther(GraalJSException, Object, InteropLibrary, InteropLibrary) */) {
                        if ((!(IsIdenticalOrUndefined.isGraalJSException(arg1Value)))) {
                            return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value, this.thisLib, this.otherLib);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isIdenticalOrUndefinedAndSpecialize(arg0Value, arg1Value);
            }

            private TriState isIdenticalOrUndefinedAndSpecialize(GraalJSException arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if (arg1Value instanceof GraalJSException) {
                        GraalJSException arg1Value_ = (GraalJSException) arg1Value;
                        this.thisLib = super.insert(this.thisLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.thisLib);
                        this.otherLib = super.insert(this.otherLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.otherLib);
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doException(GraalJSException, GraalJSException, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return IsIdenticalOrUndefined.doException(arg0Value, arg1Value_, this.thisLib, this.otherLib);
                    }
                    if ((exclude) == 0 /* is-not-exclude doJSObject(GraalJSException, JSDynamicObject) */ && arg1Value instanceof JSDynamicObject) {
                        JSDynamicObject arg1Value_ = (JSDynamicObject) arg1Value;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doJSObject(GraalJSException, JSDynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return IsIdenticalOrUndefined.doJSObject(arg0Value, arg1Value_);
                    }
                    if ((!(IsIdenticalOrUndefined.isGraalJSException(arg1Value)))) {
                        this.thisLib = super.insert(this.thisLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.thisLib);
                        this.otherLib = super.insert(this.otherLib == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.otherLib);
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude doJSObject(GraalJSException, JSDynamicObject) */;
                        state_0 = state_0 & 0xfffffffd /* remove-state_0 doJSObject(GraalJSException, JSDynamicObject) */;
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doOther(GraalJSException, Object, InteropLibrary, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value, this.thisLib, this.otherLib);
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
                        return NodeCost.MONOMORPHIC;
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            @Override
            public boolean hasSourceLocation(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).hasSourceLocation();
            }

            @Override
            public SourceSection getSourceLocation(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).getSourceLocationInterop();
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).getLanguage();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).toDisplayString(allowSideEffects);
            }

            @Override
            public int identityHashCode(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                GraalJSException arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 identityHashCode(GraalJSException, InteropLibrary) */) {
                    return arg0Value.identityHashCode(this.identityHashCodeNode__identityHashCode_delegateLib_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return identityHashCodeNode_AndSpecialize(arg0Value);
            }

            private int identityHashCodeNode_AndSpecialize(GraalJSException arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.identityHashCodeNode__identityHashCode_delegateLib_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 identityHashCode(GraalJSException, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.identityHashCode(this.identityHashCodeNode__identityHashCode_delegateLib_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(GraalJSException.class)
        public static class Uncached extends InteropLibrary {

            private final Class<? extends GraalJSException> receiverClass_;

            protected Uncached(Object receiver) {
                this.receiverClass_ = ((GraalJSException) receiver).getClass();
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            public final boolean isAdoptable() {
                return false;
            }

            @Override
            public final NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                GraalJSException arg0Value = ((GraalJSException) arg0Value_);
                if (arg1Value instanceof GraalJSException) {
                    GraalJSException arg1Value_ = (GraalJSException) arg1Value;
                    return IsIdenticalOrUndefined.doException(arg0Value, arg1Value_, (INTEROP_LIBRARY_.getUncached()), (INTEROP_LIBRARY_.getUncached()));
                }
                if ((!(IsIdenticalOrUndefined.isGraalJSException(arg1Value)))) {
                    return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value, (INTEROP_LIBRARY_.getUncached()), (INTEROP_LIBRARY_.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean hasSourceLocation(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((GraalJSException) receiver) .hasSourceLocation();
            }

            @TruffleBoundary
            @Override
            public SourceSection getSourceLocation(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((GraalJSException) receiver) .getSourceLocationInterop();
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((GraalJSException) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((GraalJSException) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((GraalJSException) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public int identityHashCode(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                GraalJSException arg0Value = ((GraalJSException) arg0Value_);
                return arg0Value.identityHashCode((INTEROP_LIBRARY_.getUncached()));
            }

        }
    }
}
