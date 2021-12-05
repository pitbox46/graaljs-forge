// CheckStyle: start generated
package com.oracle.truffle.host;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.TriState;
import com.oracle.truffle.host.HostFunction.IsIdenticalOrUndefined;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HostFunction.class)
@SuppressWarnings("unused")
final class HostFunctionGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(HostFunction.class, new InteropLibraryExports());
    }

    private HostFunctionGen() {
    }

    @GeneratedBy(HostFunction.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, HostFunction.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof HostFunction;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof HostFunction;
            return new Cached();
        }

        @GeneratedBy(HostFunction.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_0_;
            @Child private HostExecuteNode executeNode__execute_execute_;

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof HostFunction) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof HostFunction;
            }

            @Override
            protected TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostFunction arg0Value = ((HostFunction) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) != 0 /* is-state_0 doHostObject(HostFunction, HostFunction) || doOther(HostFunction, Object) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doHostObject(HostFunction, HostFunction) */ && arg1Value instanceof HostFunction) {
                        HostFunction arg1Value_ = (HostFunction) arg1Value;
                        return IsIdenticalOrUndefined.doHostObject(arg0Value, arg1Value_);
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doOther(HostFunction, Object) */) {
                        if (isIdenticalOrUndefinedFallbackGuard_(state_0, arg0Value, arg1Value)) {
                            return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isIdenticalOrUndefinedAndSpecialize(arg0Value, arg1Value);
            }

            private TriState isIdenticalOrUndefinedAndSpecialize(HostFunction arg0Value, Object arg1Value) {
                int state_0 = this.state_0_;
                if (arg1Value instanceof HostFunction) {
                    HostFunction arg1Value_ = (HostFunction) arg1Value;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doHostObject(HostFunction, HostFunction) */;
                    return IsIdenticalOrUndefined.doHostObject(arg0Value, arg1Value_);
                }
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doOther(HostFunction, Object) */;
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
            public boolean isExecutable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostFunction) receiver)).isExecutable();
            }

            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                HostFunction arg0Value = ((HostFunction) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100) != 0 /* is-state_0 execute(HostFunction, Object[], HostExecuteNode) */) {
                    return arg0Value.execute(arg1Value, this.executeNode__execute_execute_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object executeNode_AndSpecialize(HostFunction arg0Value, Object[] arg1Value) throws UnsupportedTypeException, ArityException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.executeNode__execute_execute_ = super.insert((HostExecuteNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 execute(HostFunction, Object[], HostExecuteNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.execute(arg1Value, this.executeNode__execute_execute_);
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
                return (((HostFunction) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostFunction) receiver)).getLanguage();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((HostFunction) receiver)).toDisplayString(allowSideEffects);
            }

            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return HostFunction.identityHashCode((((HostFunction) receiver)));
            }

            private static boolean isIdenticalOrUndefinedFallbackGuard_(int state_0, HostFunction arg0Value, Object arg1Value) {
                if (((state_0 & 0b1)) == 0 /* is-not-state_0 doHostObject(HostFunction, HostFunction) */ && arg1Value instanceof HostFunction) {
                    return false;
                }
                return true;
            }

        }
        @GeneratedBy(HostFunction.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof HostFunction) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof HostFunction;
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
                HostFunction arg0Value = ((HostFunction) arg0Value_);
                if (arg1Value instanceof HostFunction) {
                    HostFunction arg1Value_ = (HostFunction) arg1Value;
                    return IsIdenticalOrUndefined.doHostObject(arg0Value, arg1Value_);
                }
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isExecutable(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostFunction) receiver) .isExecutable();
            }

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                HostFunction arg0Value = ((HostFunction) arg0Value_);
                return arg0Value.execute(arg1Value, (HostExecuteNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostFunction) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostFunction) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((HostFunction) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return HostFunction.identityHashCode(((HostFunction) receiver) );
            }

        }
    }
}
