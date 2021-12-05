// CheckStyle: start generated
package com.oracle.truffle.js.runtime.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ExceptionType;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.TriState;
import com.oracle.truffle.js.nodes.interop.JSInteropGetIteratorNode;
import com.oracle.truffle.js.nodes.interop.KeyInfoNode;
import com.oracle.truffle.js.runtime.GraalJSException;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.builtins.JSErrorObject.IsIdenticalOrUndefined;
import com.oracle.truffle.js.runtime.objects.JSDynamicObject;
import com.oracle.truffle.js.runtime.objects.JSNonProxyObjectGen;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSErrorObject.class)
@SuppressWarnings("unused")
final class JSErrorObjectGen {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(JSErrorObject.class, new InteropLibraryExports());
    }

    private JSErrorObjectGen() {
    }

    @GeneratedBy(JSErrorObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, JSErrorObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JSErrorObject;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JSErrorObject;
            return new Cached(receiver);
        }

        @GeneratedBy(JSErrorObject.class)
        private static final class Cached extends JSNonProxyObjectGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @Child private KeyInfoNode keyInfo;
            @Child private JSInteropGetIteratorNode getIterator;
            @Child private InteropLibrary getExceptionTypeNode__getExceptionType_exceptions_;
            @Child private InteropLibrary isExceptionIncompleteSourceNode__isExceptionIncompleteSource_exceptions_;
            @Child private InteropLibrary hasExceptionMessageNode__hasExceptionMessage_exceptions_;
            @Child private InteropLibrary getExceptionMessageNode__getExceptionMessage_exceptions_;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @Override
            protected TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSErrorObject arg0Value = ((JSErrorObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b111) != 0 /* is-state_0 doError(JSErrorObject, JSDynamicObject) || doException(JSErrorObject, GraalJSException) || doOther(JSErrorObject, Object) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doError(JSErrorObject, JSDynamicObject) */ && arg1Value instanceof JSDynamicObject) {
                        JSDynamicObject arg1Value_ = (JSDynamicObject) arg1Value;
                        return IsIdenticalOrUndefined.doError(arg0Value, arg1Value_);
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doException(JSErrorObject, GraalJSException) */ && arg1Value instanceof GraalJSException) {
                        GraalJSException arg1Value_ = (GraalJSException) arg1Value;
                        return IsIdenticalOrUndefined.doException(arg0Value, arg1Value_);
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doOther(JSErrorObject, Object) */) {
                        if (isIdenticalOrUndefinedFallbackGuard_(state_0, arg0Value, arg1Value)) {
                            return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isIdenticalOrUndefinedAndSpecialize(arg0Value, arg1Value);
            }

            private TriState isIdenticalOrUndefinedAndSpecialize(JSErrorObject arg0Value, Object arg1Value) {
                int state_0 = this.state_0_;
                if (arg1Value instanceof JSDynamicObject) {
                    JSDynamicObject arg1Value_ = (JSDynamicObject) arg1Value;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doError(JSErrorObject, JSDynamicObject) */;
                    return IsIdenticalOrUndefined.doError(arg0Value, arg1Value_);
                }
                if (arg1Value instanceof GraalJSException) {
                    GraalJSException arg1Value_ = (GraalJSException) arg1Value;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doException(JSErrorObject, GraalJSException) */;
                    return IsIdenticalOrUndefined.doException(arg0Value, arg1Value_);
                }
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doOther(JSErrorObject, Object) */;
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
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
            public boolean isException(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSErrorObject) receiver)).isException();
            }

            @Override
            public RuntimeException throwException(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSErrorObject) receiver)).throwException();
            }

            @Override
            public ExceptionType getExceptionType(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSErrorObject arg0Value = ((JSErrorObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 getExceptionType(JSErrorObject, InteropLibrary) */) {
                    return arg0Value.getExceptionType(this.getExceptionTypeNode__getExceptionType_exceptions_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getExceptionTypeNode_AndSpecialize(arg0Value);
            }

            private ExceptionType getExceptionTypeNode_AndSpecialize(JSErrorObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.getExceptionTypeNode__getExceptionType_exceptions_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 getExceptionType(JSErrorObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getExceptionType(this.getExceptionTypeNode__getExceptionType_exceptions_);
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
                JSErrorObject arg0Value = ((JSErrorObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000) != 0 /* is-state_0 isExceptionIncompleteSource(JSErrorObject, InteropLibrary) */) {
                    return arg0Value.isExceptionIncompleteSource(this.isExceptionIncompleteSourceNode__isExceptionIncompleteSource_exceptions_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isExceptionIncompleteSourceNode_AndSpecialize(arg0Value);
            }

            private boolean isExceptionIncompleteSourceNode_AndSpecialize(JSErrorObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.isExceptionIncompleteSourceNode__isExceptionIncompleteSource_exceptions_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 isExceptionIncompleteSource(JSErrorObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isExceptionIncompleteSource(this.isExceptionIncompleteSourceNode__isExceptionIncompleteSource_exceptions_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasExceptionMessage(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSErrorObject arg0Value = ((JSErrorObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 hasExceptionMessage(JSErrorObject, InteropLibrary) */) {
                    return arg0Value.hasExceptionMessage(this.hasExceptionMessageNode__hasExceptionMessage_exceptions_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasExceptionMessageNode_AndSpecialize(arg0Value);
            }

            private boolean hasExceptionMessageNode_AndSpecialize(JSErrorObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.hasExceptionMessageNode__hasExceptionMessage_exceptions_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 hasExceptionMessage(JSErrorObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasExceptionMessage(this.hasExceptionMessageNode__hasExceptionMessage_exceptions_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object getExceptionMessage(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSErrorObject arg0Value = ((JSErrorObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000) != 0 /* is-state_0 getExceptionMessage(JSErrorObject, InteropLibrary) */) {
                    return arg0Value.getExceptionMessage(this.getExceptionMessageNode__getExceptionMessage_exceptions_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getExceptionMessageNode_AndSpecialize(arg0Value);
            }

            private Object getExceptionMessageNode_AndSpecialize(JSErrorObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.getExceptionMessageNode__getExceptionMessage_exceptions_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 getExceptionMessage(JSErrorObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getExceptionMessage(this.getExceptionMessageNode__getExceptionMessage_exceptions_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            private static boolean isIdenticalOrUndefinedFallbackGuard_(int state_0, JSErrorObject arg0Value, Object arg1Value) {
                if (((state_0 & 0b1)) == 0 /* is-not-state_0 doError(JSErrorObject, JSDynamicObject) */ && arg1Value instanceof JSDynamicObject) {
                    return false;
                }
                if (((state_0 & 0b10)) == 0 /* is-not-state_0 doException(JSErrorObject, GraalJSException) */ && arg1Value instanceof GraalJSException) {
                    return false;
                }
                return true;
            }

        }
        @GeneratedBy(JSErrorObject.class)
        private static final class Uncached extends JSNonProxyObjectGen.InteropLibraryExports.Uncached {

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
            public TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSErrorObject arg0Value = ((JSErrorObject) arg0Value_);
                if (arg1Value instanceof JSDynamicObject) {
                    JSDynamicObject arg1Value_ = (JSDynamicObject) arg1Value;
                    return IsIdenticalOrUndefined.doError(arg0Value, arg1Value_);
                }
                if (arg1Value instanceof GraalJSException) {
                    GraalJSException arg1Value_ = (GraalJSException) arg1Value;
                    return IsIdenticalOrUndefined.doException(arg0Value, arg1Value_);
                }
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isException(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSErrorObject) receiver) .isException();
            }

            @TruffleBoundary
            @Override
            public RuntimeException throwException(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSErrorObject) receiver) .throwException();
            }

            @TruffleBoundary
            @Override
            public ExceptionType getExceptionType(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSErrorObject arg0Value = ((JSErrorObject) arg0Value_);
                return arg0Value.getExceptionType((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isExceptionIncompleteSource(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSErrorObject arg0Value = ((JSErrorObject) arg0Value_);
                return arg0Value.isExceptionIncompleteSource((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasExceptionMessage(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSErrorObject arg0Value = ((JSErrorObject) arg0Value_);
                return arg0Value.hasExceptionMessage((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object getExceptionMessage(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSErrorObject arg0Value = ((JSErrorObject) arg0Value_);
                return arg0Value.getExceptionMessage((INTEROP_LIBRARY_.getUncached()));
            }

        }
    }
}
