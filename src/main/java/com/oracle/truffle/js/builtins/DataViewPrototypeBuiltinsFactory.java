// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.js.builtins.DataViewPrototypeBuiltins.DataViewGetNode;
import com.oracle.truffle.js.builtins.DataViewPrototypeBuiltins.DataViewSetNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToIndexNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSDataView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DataViewPrototypeBuiltins.class)
public final class DataViewPrototypeBuiltinsFactory {

    @GeneratedBy(DataViewGetNode.class)
    public static final class DataViewGetNodeGen extends DataViewGetNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private DataViewData dataView_cache;

        private DataViewGetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 doDataView(Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile, ValueProfile) || doIncompatibleReceiver(Object, Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doDataView(Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile, ValueProfile) */) {
                    DataViewData s0_ = this.dataView_cache;
                    if (s0_ != null) {
                        if ((JSDataView.isJSDataView(arguments0Value_))) {
                            return doDataView(arguments0Value_, arguments1Value_, arguments2Value_, s0_.toIndexNode_, s0_.errorBranch_, s0_.bufferTypeProfile_, s0_.arrayTypeProfile_);
                        }
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doIncompatibleReceiver(Object, Object, Object) */) {
                    if ((!(JSDataView.isJSDataView(arguments0Value_)))) {
                        return doIncompatibleReceiver(arguments0Value_, arguments1Value_, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if ((JSDataView.isJSDataView(arguments0Value))) {
                    DataViewData s0_ = super.insert(new DataViewData());
                    s0_.toIndexNode_ = s0_.insertAccessor((JSToIndexNode.create()));
                    s0_.errorBranch_ = (BranchProfile.create());
                    s0_.bufferTypeProfile_ = (ValueProfile.createClassProfile());
                    s0_.arrayTypeProfile_ = (ValueProfile.createClassProfile());
                    MemoryFence.storeStore();
                    this.dataView_cache = s0_;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doDataView(Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doDataView(arguments0Value, arguments1Value, arguments2Value, s0_.toIndexNode_, s0_.errorBranch_, s0_.bufferTypeProfile_, s0_.arrayTypeProfile_);
                }
                if ((!(JSDataView.isJSDataView(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doIncompatibleReceiver(Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doIncompatibleReceiver(arguments0Value, arguments1Value, arguments2Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doDataView";
            if ((state_0 & 0b1) != 0 /* is-state_0 doDataView(Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile, ValueProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                DataViewData s0_ = this.dataView_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.toIndexNode_, s0_.errorBranch_, s0_.bufferTypeProfile_, s0_.arrayTypeProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doIncompatibleReceiver";
            if ((state_0 & 0b10) != 0 /* is-state_0 doIncompatibleReceiver(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static DataViewGetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DataViewGetNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(DataViewGetNode.class)
        private static final class DataViewData extends Node {

            @Child JSToIndexNode toIndexNode_;
            @CompilationFinal BranchProfile errorBranch_;
            @CompilationFinal ValueProfile bufferTypeProfile_;
            @CompilationFinal ValueProfile arrayTypeProfile_;

            DataViewData() {
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
    @GeneratedBy(DataViewSetNode.class)
    public static final class DataViewSetNodeGen extends DataViewSetNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;
        @CompilationFinal private volatile int state_0_;
        @Child private DataViewData dataView_cache;

        private DataViewSetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
            this.arguments3_ = arguments != null && 3 < arguments.length ? arguments[3] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 doDataView(Object, Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile, ValueProfile) || doIncompatibleReceiver(Object, Object, Object, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doDataView(Object, Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile, ValueProfile) */) {
                    DataViewData s0_ = this.dataView_cache;
                    if (s0_ != null) {
                        if ((JSDataView.isJSDataView(arguments0Value_))) {
                            return doDataView(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_, s0_.toIndexNode_, s0_.errorBranch_, s0_.bufferTypeProfile_, s0_.arrayTypeProfile_);
                        }
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doIncompatibleReceiver(Object, Object, Object, Object) */) {
                    if ((!(JSDataView.isJSDataView(arguments0Value_)))) {
                        return doIncompatibleReceiver(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value, Object arguments3Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if ((JSDataView.isJSDataView(arguments0Value))) {
                    DataViewData s0_ = super.insert(new DataViewData());
                    s0_.toIndexNode_ = s0_.insertAccessor((JSToIndexNode.create()));
                    s0_.errorBranch_ = (BranchProfile.create());
                    s0_.bufferTypeProfile_ = (ValueProfile.createClassProfile());
                    s0_.arrayTypeProfile_ = (ValueProfile.createClassProfile());
                    MemoryFence.storeStore();
                    this.dataView_cache = s0_;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doDataView(Object, Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doDataView(arguments0Value, arguments1Value, arguments2Value, arguments3Value, s0_.toIndexNode_, s0_.errorBranch_, s0_.bufferTypeProfile_, s0_.arrayTypeProfile_);
                }
                if ((!(JSDataView.isJSDataView(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doIncompatibleReceiver(Object, Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doIncompatibleReceiver(arguments0Value, arguments1Value, arguments2Value, arguments3Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_}, arguments0Value, arguments1Value, arguments2Value, arguments3Value);
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
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "doDataView";
            if ((state_0 & 0b1) != 0 /* is-state_0 doDataView(Object, Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile, ValueProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                DataViewData s0_ = this.dataView_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.toIndexNode_, s0_.errorBranch_, s0_.bufferTypeProfile_, s0_.arrayTypeProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doIncompatibleReceiver";
            if ((state_0 & 0b10) != 0 /* is-state_0 doIncompatibleReceiver(Object, Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static DataViewSetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DataViewSetNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(DataViewSetNode.class)
        private static final class DataViewData extends Node {

            @Child JSToIndexNode toIndexNode_;
            @CompilationFinal BranchProfile errorBranch_;
            @CompilationFinal ValueProfile bufferTypeProfile_;
            @CompilationFinal ValueProfile arrayTypeProfile_;

            DataViewData() {
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
}
