// CheckStyle: start generated
package com.oracle.truffle.js.builtins.intl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.intl.SegmentIteratorPrototypeBuiltins.SegmentIteratorNextNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.intl.CreateSegmentDataObjectNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.intl.JSSegmentIteratorObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SegmentIteratorPrototypeBuiltins.class)
public final class SegmentIteratorPrototypeBuiltinsFactory {

    @GeneratedBy(SegmentIteratorNextNode.class)
    public static final class SegmentIteratorNextNodeGen extends SegmentIteratorNextNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private CreateSegmentDataObjectNode segmentIterator_createNextValueNode_;

        private SegmentIteratorNextNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doSegmentIterator(VirtualFrame, JSSegmentIteratorObject, CreateSegmentDataObjectNode) */ && arguments0Value_ instanceof JSSegmentIteratorObject) {
                JSSegmentIteratorObject arguments0Value__ = (JSSegmentIteratorObject) arguments0Value_;
                return doSegmentIterator(frameValue, arguments0Value__, this.segmentIterator_createNextValueNode_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doIncompatibleReceiver(Object) */) {
                if ((!(JSGuards.isJSSegmentIterator(arguments0Value_)))) {
                    return doIncompatibleReceiver(arguments0Value_);
                }
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
                if (arguments0Value instanceof JSSegmentIteratorObject) {
                    JSSegmentIteratorObject arguments0Value_ = (JSSegmentIteratorObject) arguments0Value;
                    this.segmentIterator_createNextValueNode_ = super.insert((CreateSegmentDataObjectNode.create(getContext())));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doSegmentIterator(VirtualFrame, JSSegmentIteratorObject, CreateSegmentDataObjectNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doSegmentIterator(frameValue, arguments0Value_, this.segmentIterator_createNextValueNode_);
                }
                if ((!(JSGuards.isJSSegmentIterator(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doIncompatibleReceiver(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doIncompatibleReceiver(arguments0Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "doSegmentIterator";
            if ((state_0 & 0b1) != 0 /* is-state_0 doSegmentIterator(VirtualFrame, JSSegmentIteratorObject, CreateSegmentDataObjectNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.segmentIterator_createNextValueNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doIncompatibleReceiver";
            if ((state_0 & 0b10) != 0 /* is-state_0 doIncompatibleReceiver(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static SegmentIteratorNextNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new SegmentIteratorNextNodeGen(context, builtin, arguments);
        }

    }
}
