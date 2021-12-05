// CheckStyle: start generated
package com.oracle.truffle.js.runtime.builtins.wasm;

import com.oracle.truffle.api.CompilerDirectives;
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
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.wasm.ToJSValueNode;
import com.oracle.truffle.js.nodes.wasm.ToJSValueNodeGen;
import com.oracle.truffle.js.nodes.wasm.ToWebAssemblyValueNode;
import java.util.concurrent.locks.Lock;

@GeneratedBy(WebAssemblyHostFunction.class)
public final class WebAssemblyHostFunctionGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(WebAssemblyHostFunction.class, new InteropLibraryExports());
    }

    private WebAssemblyHostFunctionGen() {
    }

    @GeneratedBy(WebAssemblyHostFunction.class)
    public static class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, WebAssemblyHostFunction.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof WebAssemblyHostFunction;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof WebAssemblyHostFunction;
            return new Cached(receiver);
        }

        @GeneratedBy(WebAssemblyHostFunction.class)
        public static class Cached extends InteropLibrary {

            private final Class<? extends WebAssemblyHostFunction> receiverClass_;
            @CompilationFinal private volatile int state_0_;
            @Child private ExecuteData execute_cache;

            protected Cached(Object receiver) {
                WebAssemblyHostFunction castReceiver = ((WebAssemblyHostFunction) receiver) ;
                this.receiverClass_ = castReceiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            public boolean isExecutable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return WebAssemblyHostFunction.isExecutable((CompilerDirectives.castExact(receiver, receiverClass_)));
            }

            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                WebAssemblyHostFunction arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 execute(WebAssemblyHostFunction, Object[], ToWebAssemblyValueNode, ToJSValueNode, JSFunctionCallNode, BranchProfile, InteropLibrary) */) {
                    ExecuteData s0_ = this.execute_cache;
                    if (s0_ != null) {
                        {
                            InteropLibrary self__ = (this);
                            return arg0Value.execute(arg1Value, s0_.toWebAssemblyValueNode_, s0_.toJSValueNode_, s0_.callNode_, s0_.errorBranch_, self__);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value);
            }

            private Object executeAndSpecialize(WebAssemblyHostFunction arg0Value, Object[] arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        InteropLibrary self__ = null;
                        ExecuteData s0_ = super.insert(new ExecuteData());
                        s0_.toWebAssemblyValueNode_ = s0_.insertAccessor((ToWebAssemblyValueNode.create()));
                        s0_.toJSValueNode_ = s0_.insertAccessor((ToJSValueNode.create()));
                        s0_.callNode_ = s0_.insertAccessor((JSFunctionCallNode.createCall()));
                        s0_.errorBranch_ = (BranchProfile.create());
                        self__ = (this);
                        MemoryFence.storeStore();
                        this.execute_cache = s0_;
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 execute(WebAssemblyHostFunction, Object[], ToWebAssemblyValueNode, ToJSValueNode, JSFunctionCallNode, BranchProfile, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.execute(arg1Value, s0_.toWebAssemblyValueNode_, s0_.toJSValueNode_, s0_.callNode_, s0_.errorBranch_, self__);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public NodeCost getCost() {
                int state_0 = this.state_0_;
                if (state_0 == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    return NodeCost.MONOMORPHIC;
                }
            }

            @GeneratedBy(WebAssemblyHostFunction.class)
            private static final class ExecuteData extends Node {

                @Child ToWebAssemblyValueNode toWebAssemblyValueNode_;
                @Child ToJSValueNode toJSValueNode_;
                @Child JSFunctionCallNode callNode_;
                @CompilationFinal BranchProfile errorBranch_;

                ExecuteData() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

                <T extends Node> T insertAccessor(T node) {
                    return super.insert(node);
                }

            }
        }
        @GeneratedBy(WebAssemblyHostFunction.class)
        public static class Uncached extends InteropLibrary {

            private final Class<? extends WebAssemblyHostFunction> receiverClass_;

            protected Uncached(Object receiver) {
                this.receiverClass_ = ((WebAssemblyHostFunction) receiver).getClass();
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
            public boolean isExecutable(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return WebAssemblyHostFunction.isExecutable(((WebAssemblyHostFunction) receiver) );
            }

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                WebAssemblyHostFunction arg0Value = ((WebAssemblyHostFunction) arg0Value_);
                return arg0Value.execute(arg1Value, (ToWebAssemblyValueNode.getUncached()), (ToJSValueNodeGen.getUncached()), (JSFunctionCallNode.getUncachedCall()), (BranchProfile.getUncached()), (this));
            }

        }
    }
}
