// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.PrimitiveValueProfile;
import com.oracle.truffle.js.builtins.ForInIteratorPrototypeBuiltins.ForInIteratorPrototypeNextNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ForInIteratorPrototypeBuiltins.class)
public final class ForInIteratorPrototypeBuiltinsFactory {

    @GeneratedBy(ForInIteratorPrototypeNextNode.class)
    public static final class ForInIteratorPrototypeNextNodeGen extends ForInIteratorPrototypeNextNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private PrimitiveValueProfile valuesProfile_;

        private ForInIteratorPrototypeNextNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 execute(VirtualFrame, Object, PrimitiveValueProfile) */) {
                return execute(frameValue, arguments0Value_, this.valuesProfile_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                this.valuesProfile_ = (PrimitiveValueProfile.createEqualityProfile());
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 execute(VirtualFrame, Object, PrimitiveValueProfile) */;
                lock.unlock();
                hasLock = false;
                return execute(frameValue, arguments0Value, this.valuesProfile_);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "execute";
            if (state_0 != 0 /* is-state_0 execute(VirtualFrame, Object, PrimitiveValueProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.valuesProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ForInIteratorPrototypeNextNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ForInIteratorPrototypeNextNodeGen(context, builtin, arguments);
        }

    }
}
