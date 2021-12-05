// CheckStyle: start generated
package com.oracle.truffle.js.nodes.function;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.function.DefineMethodNode.FunctionCreateNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSFunctionData;
import com.oracle.truffle.js.runtime.builtins.JSFunctionFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DefineMethodNode.class)
public final class DefineMethodNodeFactory {

    @GeneratedBy(FunctionCreateNode.class)
    protected static final class FunctionCreateNodeGen extends FunctionCreateNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;
        @CompilationFinal private JSFunctionFactory multiContext_factory_;

        private FunctionCreateNodeGen(JSContext context, JSFunctionData functionData, FrameSlot blockScopeSlot) {
            super(context, functionData, blockScopeSlot);
        }

        @ExplodeLoop
        @Override
        public DynamicObject executeWithPrototype(VirtualFrame frameValue, Object arg0Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b111) != 0 /* is-state_0 doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) || doUncached(VirtualFrame, DynamicObject) || doMultiContext(VirtualFrame, DynamicObject, JSFunctionFactory) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */) {
                    assert (!(getContext().isMultiContext()));
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((arg0Value_ == s0_.cachedPrototype_)) {
                            assert (JSGuards.isJSObject(s0_.cachedPrototype_));
                            return doCached(frameValue, arg0Value_, s0_.cachedPrototype_, s0_.factory_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(VirtualFrame, DynamicObject) */) {
                    assert (!(getContext().isMultiContext()));
                    if ((JSGuards.isJSObject(arg0Value_))) {
                        return doUncached(frameValue, arg0Value_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doMultiContext(VirtualFrame, DynamicObject, JSFunctionFactory) */) {
                    assert (getContext().isMultiContext());
                    if ((JSGuards.isJSObject(arg0Value_))) {
                        return doMultiContext(frameValue, arg0Value_, this.multiContext_factory_);
                    }
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object) */) {
                if ((!(JSGuards.isJSObject(arg0Value)))) {
                    return doNonObject(arg0Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arg0Value);
        }

        private DynamicObject executeAndSpecialize(VirtualFrame frameValue, Object arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arg0Value)) {
                    DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                    if ((exclude) == 0 /* is-not-exclude doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */ && (!(getContext().isMultiContext()))) {
                        int count0_ = 0;
                        CachedData s0_ = this.cached_cache;
                        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */) {
                            while (s0_ != null) {
                                if ((arg0Value_ == s0_.cachedPrototype_)) {
                                    assert (JSGuards.isJSObject(s0_.cachedPrototype_));
                                    break;
                                }
                                s0_ = s0_.next_;
                                count0_++;
                            }
                        }
                        if (s0_ == null) {
                            {
                                DynamicObject cachedPrototype__ = (arg0Value_);
                                // assert (arg0Value_ == s0_.cachedPrototype_);
                                if ((JSGuards.isJSObject(cachedPrototype__)) && count0_ < (getContext().getPropertyCacheLimit())) {
                                    s0_ = new CachedData(cached_cache);
                                    s0_.cachedPrototype_ = cachedPrototype__;
                                    s0_.factory_ = (makeFactory(arg0Value_));
                                    MemoryFence.storeStore();
                                    this.cached_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */;
                                }
                            }
                        }
                        if (s0_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(frameValue, arg0Value_, s0_.cachedPrototype_, s0_.factory_);
                        }
                    }
                    if ((!(getContext().isMultiContext())) && (JSGuards.isJSObject(arg0Value_))) {
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */;
                        this.cached_cache = null;
                        state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(VirtualFrame, DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return doUncached(frameValue, arg0Value_);
                    }
                    if ((getContext().isMultiContext()) && (JSGuards.isJSObject(arg0Value_))) {
                        this.multiContext_factory_ = (makeFactoryMultiContext());
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doMultiContext(VirtualFrame, DynamicObject, JSFunctionFactory) */;
                        lock.unlock();
                        hasLock = false;
                        return doMultiContext(frameValue, arg0Value_, this.multiContext_factory_);
                    }
                }
                if ((!(JSGuards.isJSObject(arg0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doNonObject(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNonObject(arg0Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
                if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                    CachedData s0_ = this.cached_cache;
                    if ((s0_ == null || s0_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "doCached";
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.cachedPrototype_, s0_.factory_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doUncached";
            if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(VirtualFrame, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doMultiContext";
            if ((state_0 & 0b100) != 0 /* is-state_0 doMultiContext(VirtualFrame, DynamicObject, JSFunctionFactory) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.multiContext_factory_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNonObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doNonObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static FunctionCreateNode create(JSContext context, JSFunctionData functionData, FrameSlot blockScopeSlot) {
            return new FunctionCreateNodeGen(context, functionData, blockScopeSlot);
        }

        @GeneratedBy(FunctionCreateNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal DynamicObject cachedPrototype_;
            @CompilationFinal JSFunctionFactory factory_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
}
