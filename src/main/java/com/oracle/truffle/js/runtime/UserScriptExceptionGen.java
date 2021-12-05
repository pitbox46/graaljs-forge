// CheckStyle: start generated
package com.oracle.truffle.js.runtime;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.ExceptionType;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.api.utilities.FinalBitSet;
import com.oracle.truffle.api.utilities.TriState;
import com.oracle.truffle.js.runtime.GraalJSException.IsIdenticalOrUndefined;
import com.oracle.truffle.js.runtime.objects.JSDynamicObject;
import java.util.concurrent.locks.Lock;

@GeneratedBy(UserScriptException.class)
final class UserScriptExceptionGen {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);
    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(UserScriptException.class, new InteropLibraryExports());
    }

    private UserScriptExceptionGen() {
    }

    @GeneratedBy(UserScriptException.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        static final FinalBitSet ENABLED_MESSAGES = createMessageBitSet(INTEROP_LIBRARY_, "isIdenticalOrUndefined", "hasSourceLocation", "getSourceLocation", "hasLanguage", "getLanguage", "toDisplayString", "identityHashCode", "isException", "throwException", "getExceptionType");

        private InteropLibraryExports() {
            super(InteropLibrary.class, UserScriptException.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof UserScriptException;
            InteropLibrary uncached = createDelegate(INTEROP_LIBRARY_, new Uncached());
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof UserScriptException;
            return createDelegate(INTEROP_LIBRARY_, new Cached(receiver));
        }

        @GeneratedBy(UserScriptException.class)
        private static final class Cached extends InteropLibrary implements DelegateExport {

            @Child private InteropLibrary receiverExceptionObjectInteropLibrary_;
            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private InteropLibrary thisLib;
            @Child private InteropLibrary otherLib;
            @Child private InteropLibrary identityHashCodeNode__identityHashCode_delegateLib_;

            protected Cached(Object receiver) {
                UserScriptException castReceiver = ((UserScriptException) receiver) ;
                this.receiverExceptionObjectInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((castReceiver.exceptionObject)));
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return ((UserScriptException) receiver_).exceptionObject;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate) {
                return this.receiverExceptionObjectInteropLibrary_;
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof UserScriptException) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof UserScriptException)) {
                    return false;
                } else if (!this.receiverExceptionObjectInteropLibrary_.accepts((((UserScriptException) receiver).exceptionObject))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            protected TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                assert arg0Value_ instanceof UserScriptException : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                UserScriptException arg0Value = ((UserScriptException) arg0Value_);
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
                assert receiver instanceof UserScriptException : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((UserScriptException) receiver)).hasSourceLocation();
            }

            @Override
            public SourceSection getSourceLocation(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof UserScriptException : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((UserScriptException) receiver)).getSourceLocationInterop();
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert receiver instanceof UserScriptException : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((UserScriptException) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof UserScriptException : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((UserScriptException) receiver)).getLanguage();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert receiver instanceof UserScriptException : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((UserScriptException) receiver)).toDisplayString(allowSideEffects);
            }

            @Override
            public int identityHashCode(Object arg0Value_) throws UnsupportedMessageException {
                assert arg0Value_ instanceof UserScriptException : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                UserScriptException arg0Value = ((UserScriptException) arg0Value_);
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

            @Override
            public boolean isException(Object receiver) {
                assert receiver instanceof UserScriptException : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((UserScriptException) receiver)).isException();
            }

            @Override
            public RuntimeException throwException(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof UserScriptException : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((UserScriptException) receiver)).throwException();
            }

            @Override
            public ExceptionType getExceptionType(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof UserScriptException : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((UserScriptException) receiver)).getExceptionType();
            }

        }
        @GeneratedBy(UserScriptException.class)
        private static final class Uncached extends InteropLibrary implements DelegateExport {

            protected Uncached() {
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return (((UserScriptException) receiver_)).exceptionObject;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate_) {
                return INTEROP_LIBRARY_.getUncached(delegate_);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof UserScriptException) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof UserScriptException;
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
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((GraalJSException) receiver) .hasSourceLocation();
            }

            @TruffleBoundary
            @Override
            public SourceSection getSourceLocation(Object receiver) throws UnsupportedMessageException {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((GraalJSException) receiver) .getSourceLocationInterop();
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((GraalJSException) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((GraalJSException) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((GraalJSException) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public int identityHashCode(Object arg0Value_) throws UnsupportedMessageException {
                // declared: false
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                GraalJSException arg0Value = ((GraalJSException) arg0Value_);
                return arg0Value.identityHashCode((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isException(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((UserScriptException) receiver) .isException();
            }

            @TruffleBoundary
            @Override
            public RuntimeException throwException(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((UserScriptException) receiver) .throwException();
            }

            @TruffleBoundary
            @Override
            public ExceptionType getExceptionType(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((UserScriptException) receiver) .getExceptionType();
            }

        }
    }
}
