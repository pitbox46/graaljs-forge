// CheckStyle: start generated
package com.oracle.truffle.polyglot;

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
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.TriState;
import com.oracle.truffle.polyglot.PolyglotParsedEval.Execute;
import com.oracle.truffle.polyglot.PolyglotParsedEval.IsIdenticalOrUndefined;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PolyglotParsedEval.class)
@SuppressWarnings("unused")
final class PolyglotParsedEvalGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(PolyglotParsedEval.class, new InteropLibraryExports());
    }

    private PolyglotParsedEvalGen() {
    }

    @GeneratedBy(PolyglotParsedEval.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, PolyglotParsedEval.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof PolyglotParsedEval;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof PolyglotParsedEval;
            return new Cached();
        }

        @GeneratedBy(PolyglotParsedEval.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private volatile int exclude_;
            @Child private ExecuteCachedData execute_cached_cache;
            @Child private IndirectCallNode execute_indirect_callNode_;

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof PolyglotParsedEval) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof PolyglotParsedEval;
            }

            @ExplodeLoop
            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                PolyglotParsedEval arg0Value = ((PolyglotParsedEval) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) != 0 /* is-state_0 doCached(PolyglotParsedEval, Object[], DirectCallNode) || doIndirect(PolyglotParsedEval, Object[], IndirectCallNode) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotParsedEval, Object[], DirectCallNode) */) {
                        ExecuteCachedData s0_ = this.execute_cached_cache;
                        while (s0_ != null) {
                            if ((arg0Value.target == s0_.callNode_.getCallTarget())) {
                                return Execute.doCached(arg0Value, arg1Value, s0_.callNode_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doIndirect(PolyglotParsedEval, Object[], IndirectCallNode) */) {
                        return Execute.doIndirect(arg0Value, arg1Value, this.execute_indirect_callNode_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value);
            }

            private Object executeAndSpecialize(PolyglotParsedEval arg0Value, Object[] arg1Value) throws ArityException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    int exclude = this.exclude_;
                    if ((exclude) == 0 /* is-not-exclude doCached(PolyglotParsedEval, Object[], DirectCallNode) */) {
                        int count0_ = 0;
                        ExecuteCachedData s0_ = this.execute_cached_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(PolyglotParsedEval, Object[], DirectCallNode) */) {
                            while (s0_ != null) {
                                if ((arg0Value.target == s0_.callNode_.getCallTarget())) {
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                DirectCallNode callNode__ = super.insert((DirectCallNode.create(arg0Value.target)));
                                if ((arg0Value.target == callNode__.getCallTarget()) && count0_ < (5)) {
                                    s0_ = super.insert(new ExecuteCachedData(execute_cached_cache));
                                    s0_.callNode_ = s0_.insertAccessor(callNode__);
                                    MemoryFence.storeStore();
                                    this.execute_cached_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotParsedEval, Object[], DirectCallNode) */;
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return Execute.doCached(arg0Value, arg1Value, s0_.callNode_);
                        }
                    }
                    this.execute_indirect_callNode_ = super.insert((IndirectCallNode.create()));
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(PolyglotParsedEval, Object[], DirectCallNode) */;
                    this.execute_cached_cache = null;
                    state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(PolyglotParsedEval, Object[], DirectCallNode) */;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doIndirect(PolyglotParsedEval, Object[], IndirectCallNode) */;
                    lock.unlock();
                    hasLock = false;
                    return Execute.doIndirect(arg0Value, arg1Value, this.execute_indirect_callNode_);
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
                        ExecuteCachedData s0_ = this.execute_cached_cache;
                        if ((s0_ == null || s0_.next_ == null)) {
                            return NodeCost.MONOMORPHIC;
                        }
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            @Override
            protected TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                PolyglotParsedEval arg0Value = ((PolyglotParsedEval) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1100) != 0 /* is-state_0 doDefault(PolyglotParsedEval, PolyglotParsedEval) || doOther(PolyglotParsedEval, Object) */) {
                    if ((state_0 & 0b100) != 0 /* is-state_0 doDefault(PolyglotParsedEval, PolyglotParsedEval) */ && arg1Value instanceof PolyglotParsedEval) {
                        PolyglotParsedEval arg1Value_ = (PolyglotParsedEval) arg1Value;
                        return IsIdenticalOrUndefined.doDefault(arg0Value, arg1Value_);
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doOther(PolyglotParsedEval, Object) */) {
                        if (isIdenticalOrUndefinedFallbackGuard_(state_0, arg0Value, arg1Value)) {
                            return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isIdenticalOrUndefinedAndSpecialize(arg0Value, arg1Value);
            }

            private TriState isIdenticalOrUndefinedAndSpecialize(PolyglotParsedEval arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    if (arg1Value instanceof PolyglotParsedEval) {
                        PolyglotParsedEval arg1Value_ = (PolyglotParsedEval) arg1Value;
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doDefault(PolyglotParsedEval, PolyglotParsedEval) */;
                        lock.unlock();
                        hasLock = false;
                        return IsIdenticalOrUndefined.doDefault(arg0Value, arg1Value_);
                    }
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doOther(PolyglotParsedEval, Object) */;
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
            public boolean isExecutable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return PolyglotParsedEval.isExecutable((((PolyglotParsedEval) receiver)));
            }

            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return PolyglotParsedEval.identityHashCode((((PolyglotParsedEval) receiver)));
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return PolyglotParsedEval.toDisplayString((((PolyglotParsedEval) receiver)), allowSideEffects);
            }

            private static boolean isIdenticalOrUndefinedFallbackGuard_(int state_0, PolyglotParsedEval arg0Value, Object arg1Value) {
                if (((state_0 & 0b100)) == 0 /* is-not-state_0 doDefault(PolyglotParsedEval, PolyglotParsedEval) */ && arg1Value instanceof PolyglotParsedEval) {
                    return false;
                }
                return true;
            }

            @GeneratedBy(PolyglotParsedEval.class)
            private static final class ExecuteCachedData extends Node {

                @Child ExecuteCachedData next_;
                @Child DirectCallNode callNode_;

                ExecuteCachedData(ExecuteCachedData next_) {
                    this.next_ = next_;
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
        @GeneratedBy(PolyglotParsedEval.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof PolyglotParsedEval) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof PolyglotParsedEval;
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
            public Object execute(Object arg0Value_, Object... arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                PolyglotParsedEval arg0Value = ((PolyglotParsedEval) arg0Value_);
                return Execute.doIndirect(arg0Value, arg1Value, (IndirectCallNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                PolyglotParsedEval arg0Value = ((PolyglotParsedEval) arg0Value_);
                if (arg1Value instanceof PolyglotParsedEval) {
                    PolyglotParsedEval arg1Value_ = (PolyglotParsedEval) arg1Value;
                    return IsIdenticalOrUndefined.doDefault(arg0Value, arg1Value_);
                }
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isExecutable(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return PolyglotParsedEval.isExecutable(((PolyglotParsedEval) receiver) );
            }

            @TruffleBoundary
            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return PolyglotParsedEval.identityHashCode(((PolyglotParsedEval) receiver) );
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return PolyglotParsedEval.toDisplayString(((PolyglotParsedEval) receiver) , allowSideEffects);
            }

        }
    }
}
