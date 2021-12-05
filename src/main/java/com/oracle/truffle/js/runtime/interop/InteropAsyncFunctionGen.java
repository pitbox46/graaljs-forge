// CheckStyle: start generated
package com.oracle.truffle.js.runtime.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.FinalBitSet;
import com.oracle.truffle.api.utilities.TriState;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import com.oracle.truffle.js.nodes.interop.JSInteropExecuteNode;
import com.oracle.truffle.js.nodes.interop.JSInteropExecuteNodeGen;
import com.oracle.truffle.js.nodes.promise.UnwrapPromiseNode;
import com.oracle.truffle.js.runtime.JSConfig;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InteropAsyncFunction.class)
final class InteropAsyncFunctionGen {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);
    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(InteropAsyncFunction.class, new InteropLibraryExports());
    }

    private InteropAsyncFunctionGen() {
    }

    @GeneratedBy(InteropAsyncFunction.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        static final FinalBitSet ENABLED_MESSAGES = createMessageBitSet(INTEROP_LIBRARY_, "isIdenticalOrUndefined", "identityHashCode", "isExecutable", "execute");

        private InteropLibraryExports() {
            super(InteropLibrary.class, InteropAsyncFunction.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof InteropAsyncFunction;
            InteropLibrary uncached = createDelegate(INTEROP_LIBRARY_, new Uncached());
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof InteropAsyncFunction;
            return createDelegate(INTEROP_LIBRARY_, new Cached(receiver));
        }

        @GeneratedBy(InteropAsyncFunction.class)
        private static final class Cached extends InteropLibrary implements DelegateExport {

            @Child private InteropLibrary receiverFunctionInteropLibrary_;
            @CompilationFinal private volatile int state_0_;
            @Child private InteropLibrary isIdenticalOrUndefinedNode__isIdenticalOrUndefined_thisLib_;
            @Child private InteropLibrary isIdenticalOrUndefinedNode__isIdenticalOrUndefined_otherLib_;
            @Child private JSInteropExecuteNode executeNode__execute_callNode_;
            @Child private ExportValueNode executeNode__execute_exportNode_;
            @Child private UnwrapPromiseNode executeNode__execute_unwrapPromise_;

            protected Cached(Object receiver) {
                InteropAsyncFunction castReceiver = ((InteropAsyncFunction) receiver) ;
                this.receiverFunctionInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((castReceiver.function)));
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return ((InteropAsyncFunction) receiver_).function;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate) {
                return this.receiverFunctionInteropLibrary_;
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof InteropAsyncFunction) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof InteropAsyncFunction)) {
                    return false;
                } else if (!this.receiverFunctionInteropLibrary_.accepts((((InteropAsyncFunction) receiver).function))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            protected TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                assert arg0Value_ instanceof InteropAsyncFunction : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                InteropAsyncFunction arg0Value = ((InteropAsyncFunction) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) != 0 /* is-state_0 isIdenticalOrUndefined(InteropFunction, Object, InteropLibrary, InteropLibrary) */) {
                    return arg0Value.isIdenticalOrUndefined(arg1Value, this.isIdenticalOrUndefinedNode__isIdenticalOrUndefined_thisLib_, this.isIdenticalOrUndefinedNode__isIdenticalOrUndefined_otherLib_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isIdenticalOrUndefinedNode_AndSpecialize(arg0Value, arg1Value);
            }

            private TriState isIdenticalOrUndefinedNode_AndSpecialize(InteropFunction arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.isIdenticalOrUndefinedNode__isIdenticalOrUndefined_thisLib_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.isIdenticalOrUndefinedNode__isIdenticalOrUndefined_otherLib_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 isIdenticalOrUndefined(InteropFunction, Object, InteropLibrary, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isIdenticalOrUndefined(arg1Value, this.isIdenticalOrUndefinedNode__isIdenticalOrUndefined_thisLib_, this.isIdenticalOrUndefinedNode__isIdenticalOrUndefined_otherLib_);
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
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof InteropAsyncFunction : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((InteropAsyncFunction) receiver)).identityHashCode();
            }

            @Override
            public boolean isExecutable(Object receiver) {
                assert receiver instanceof InteropAsyncFunction : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((InteropAsyncFunction) receiver)).isExecutable();
            }

            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert arg0Value_ instanceof InteropAsyncFunction : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                InteropAsyncFunction arg0Value = ((InteropAsyncFunction) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10) != 0 /* is-state_0 execute(InteropAsyncFunction, Object[], InteropLibrary, JSInteropExecuteNode, ExportValueNode, UnwrapPromiseNode) */) {
                    {
                        InteropLibrary executeNode__execute_self__ = (((InteropLibrary) this.getParent()));
                        return arg0Value.execute(arg1Value, executeNode__execute_self__, this.executeNode__execute_callNode_, this.executeNode__execute_exportNode_, this.executeNode__execute_unwrapPromise_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object executeNode_AndSpecialize(InteropAsyncFunction arg0Value, Object[] arg1Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary executeNode__execute_self__ = null;
                        executeNode__execute_self__ = (((InteropLibrary) this.getParent()));
                        this.executeNode__execute_callNode_ = super.insert((JSInteropExecuteNodeGen.create()));
                        this.executeNode__execute_exportNode_ = super.insert((ExportValueNode.create()));
                        this.executeNode__execute_unwrapPromise_ = super.insert((UnwrapPromiseNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 execute(InteropAsyncFunction, Object[], InteropLibrary, JSInteropExecuteNode, ExportValueNode, UnwrapPromiseNode) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.execute(arg1Value, executeNode__execute_self__, this.executeNode__execute_callNode_, this.executeNode__execute_exportNode_, this.executeNode__execute_unwrapPromise_);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(InteropAsyncFunction.class)
        private static final class Uncached extends InteropLibrary implements DelegateExport {

            protected Uncached() {
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return (((InteropAsyncFunction) receiver_)).function;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate_) {
                return INTEROP_LIBRARY_.getUncached(delegate_);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof InteropAsyncFunction) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof InteropAsyncFunction;
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
                InteropFunction arg0Value = ((InteropFunction) arg0Value_);
                return arg0Value.isIdenticalOrUndefined(arg1Value, (INTEROP_LIBRARY_.getUncached()), (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                // declared: false
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InteropFunction) receiver) .identityHashCode();
            }

            @TruffleBoundary
            @Override
            public boolean isExecutable(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InteropAsyncFunction) receiver) .isExecutable();
            }

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                InteropAsyncFunction arg0Value = ((InteropAsyncFunction) arg0Value_);
                return arg0Value.execute(arg1Value, (((InteropLibrary) this.getParent())), (JSInteropExecuteNodeGen.getUncached()), (ExportValueNode.getUncached()), (UnwrapPromiseNode.getUncached()));
            }

        }
    }
}
