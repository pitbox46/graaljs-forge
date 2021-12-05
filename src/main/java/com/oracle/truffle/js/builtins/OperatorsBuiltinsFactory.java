// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.builtins.OperatorsBuiltins.ConstructOperatorSetNode;
import com.oracle.truffle.js.builtins.OperatorsBuiltins.CreateOverloadedOperatorsObjectNode;
import com.oracle.truffle.js.builtins.OperatorsBuiltins.OperatorsNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSOverloadedOperatorsObject;
import com.oracle.truffle.js.runtime.objects.JSObject;
import com.oracle.truffle.js.runtime.objects.OperatorSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(OperatorsBuiltins.class)
public final class OperatorsBuiltinsFactory {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @GeneratedBy(OperatorsNode.class)
    public static final class OperatorsNodeGen extends OperatorsNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private OperatorsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 doOperators(VirtualFrame, Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return doOperators(frameValue, arguments0Value_, arguments1Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value, Object arguments1Value) {
            int state_0 = this.state_0_;
            if (arguments1Value instanceof Object[]) {
                Object[] arguments1Value_ = (Object[]) arguments1Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doOperators(VirtualFrame, Object, Object[]) */;
                return doOperators(frameValue, arguments0Value, arguments1Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doOperators";
            if (state_0 != 0 /* is-state_0 doOperators(VirtualFrame, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static OperatorsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new OperatorsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(CreateOverloadedOperatorsObjectNode.class)
    public static final class CreateOverloadedOperatorsObjectNodeGen extends CreateOverloadedOperatorsObjectNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private CachedProtoData cachedProto_cache;
        @Child private DynamicObjectLibrary createWithProto_setProtoNode_;
        @CompilationFinal private Shape createWithProto_cachedShape_;
        @CompilationFinal private Shape createDefaultProto_cachedShape_;

        private CreateOverloadedOperatorsObjectNodeGen(JSContext context, OperatorSet operatorSet) {
            super(context, operatorSet);
        }

        @ExplodeLoop
        @Override
        protected JSOverloadedOperatorsObject execute(Object arg0Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doCachedProto(Object, Object, Shape) */) {
                assert (!(getContext().isMultiContext()));
                CachedProtoData s0_ = this.cachedProto_cache;
                while (s0_ != null) {
                    if ((arg0Value == s0_.cachedPrototype_)) {
                        assert (JSGuards.isJSObject(s0_.cachedPrototype_));
                        return doCachedProto(arg0Value, s0_.cachedPrototype_, s0_.cachedShape_);
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 createWithProto(JSObject, DynamicObjectLibrary, Shape) */ && arg0Value instanceof JSObject) {
                JSObject arg0Value_ = (JSObject) arg0Value;
                return createWithProto(arg0Value_, this.createWithProto_setProtoNode_, this.createWithProto_cachedShape_);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 createDefaultProto(Object, Shape) */) {
                if ((!(JSGuards.isJSObject(arg0Value)))) {
                    return createDefaultProto(arg0Value, this.createDefaultProto_cachedShape_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private JSOverloadedOperatorsObject executeAndSpecialize(Object arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if ((!(getContext().isMultiContext()))) {
                    int count0_ = 0;
                    CachedProtoData s0_ = this.cachedProto_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCachedProto(Object, Object, Shape) */) {
                        while (s0_ != null) {
                            if ((arg0Value == s0_.cachedPrototype_)) {
                                assert (JSGuards.isJSObject(s0_.cachedPrototype_));
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        {
                            Object cachedPrototype__ = (arg0Value);
                            // assert (arg0Value == s0_.cachedPrototype_);
                            if ((JSGuards.isJSObject(cachedPrototype__)) && count0_ < (getContext().getPropertyCacheLimit())) {
                                s0_ = new CachedProtoData(cachedProto_cache);
                                s0_.cachedPrototype_ = cachedPrototype__;
                                s0_.cachedShape_ = (getProtoChildShape(arg0Value));
                                MemoryFence.storeStore();
                                this.cachedProto_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCachedProto(Object, Object, Shape) */;
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCachedProto(arg0Value, s0_.cachedPrototype_, s0_.cachedShape_);
                    }
                }
                if (arg0Value instanceof JSObject) {
                    JSObject arg0Value_ = (JSObject) arg0Value;
                    this.createWithProto_setProtoNode_ = super.insert((DYNAMIC_OBJECT_LIBRARY_.createDispatched(3)));
                    this.createWithProto_cachedShape_ = (getShapeWithoutProto());
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 createWithProto(JSObject, DynamicObjectLibrary, Shape) */;
                    lock.unlock();
                    hasLock = false;
                    return createWithProto(arg0Value_, this.createWithProto_setProtoNode_, this.createWithProto_cachedShape_);
                }
                if ((!(JSGuards.isJSObject(arg0Value)))) {
                    this.createDefaultProto_cachedShape_ = (getShapeWithDefaultProto(getRealm()));
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 createDefaultProto(Object, Shape) */;
                    lock.unlock();
                    hasLock = false;
                    return createDefaultProto(arg0Value, this.createDefaultProto_cachedShape_);
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
                    CachedProtoData s0_ = this.cachedProto_cache;
                    if ((s0_ == null || s0_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doCachedProto";
            if ((state_0 & 0b1) != 0 /* is-state_0 doCachedProto(Object, Object, Shape) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedProtoData s0_ = this.cachedProto_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.cachedPrototype_, s0_.cachedShape_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "createWithProto";
            if ((state_0 & 0b10) != 0 /* is-state_0 createWithProto(JSObject, DynamicObjectLibrary, Shape) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.createWithProto_setProtoNode_, this.createWithProto_cachedShape_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "createDefaultProto";
            if ((state_0 & 0b100) != 0 /* is-state_0 createDefaultProto(Object, Shape) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.createDefaultProto_cachedShape_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static CreateOverloadedOperatorsObjectNode create(JSContext context, OperatorSet operatorSet) {
            return new CreateOverloadedOperatorsObjectNodeGen(context, operatorSet);
        }

        @GeneratedBy(CreateOverloadedOperatorsObjectNode.class)
        private static final class CachedProtoData {

            @CompilationFinal CachedProtoData next_;
            @CompilationFinal Object cachedPrototype_;
            @CompilationFinal Shape cachedShape_;

            CachedProtoData(CachedProtoData next_) {
                this.next_ = next_;
            }

        }
    }
    @GeneratedBy(ConstructOperatorSetNode.class)
    public static final class ConstructOperatorSetNodeGen extends ConstructOperatorSetNode implements Introspection.Provider {

        private ConstructOperatorSetNodeGen(JSContext context) {
            super(context);
        }

        @Override
        public OperatorSet execute(Object arg0Value, Object[] arg1Value) {
            return construct(arg0Value, arg1Value);
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "construct";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructOperatorSetNode create(JSContext context) {
            return new ConstructOperatorSetNodeGen(context);
        }

    }
}
