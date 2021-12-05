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
import com.oracle.truffle.js.builtins.intl.SegmentsPrototypeBuiltins.SegmentsContainingNode;
import com.oracle.truffle.js.builtins.intl.SegmentsPrototypeBuiltins.SegmentsIteratorNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToIntegerAsIntNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.intl.CreateSegmentDataObjectNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.intl.JSSegmentsObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SegmentsPrototypeBuiltins.class)
public final class SegmentsPrototypeBuiltinsFactory {

    @GeneratedBy(SegmentsContainingNode.class)
    public static final class SegmentsContainingNodeGen extends SegmentsContainingNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToIntegerAsIntNode segments_toIntegerNode_;
        @Child private CreateSegmentDataObjectNode segments_createResultNode_;

        private SegmentsContainingNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doSegments(JSSegmentsObject, Object, JSToIntegerAsIntNode, CreateSegmentDataObjectNode) */ && arguments0Value_ instanceof JSSegmentsObject) {
                JSSegmentsObject arguments0Value__ = (JSSegmentsObject) arguments0Value_;
                return doSegments(arguments0Value__, arguments1Value_, this.segments_toIntegerNode_, this.segments_createResultNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doSegments(JSSegmentsObject, Object, JSToIntegerAsIntNode, CreateSegmentDataObjectNode) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object, Object) */) {
                if ((!(JSGuards.isJSSegments(arguments0Value_)))) {
                    doOther(arguments0Value_, arguments1Value_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_, arguments1Value_);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arguments0Value instanceof JSSegmentsObject) {
                    JSSegmentsObject arguments0Value_ = (JSSegmentsObject) arguments0Value;
                    this.segments_toIntegerNode_ = super.insert((JSToIntegerAsIntNode.create()));
                    this.segments_createResultNode_ = super.insert((CreateSegmentDataObjectNode.create(getContext())));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doSegments(JSSegmentsObject, Object, JSToIntegerAsIntNode, CreateSegmentDataObjectNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doSegments(arguments0Value_, arguments1Value, this.segments_toIntegerNode_, this.segments_createResultNode_);
                }
                if ((!(JSGuards.isJSSegments(arguments0Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doOther(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    doOther(arguments0Value, arguments1Value);
                    return null;
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "doSegments";
            if ((state_0 & 0b1) != 0 /* is-state_0 doSegments(JSSegmentsObject, Object, JSToIntegerAsIntNode, CreateSegmentDataObjectNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.segments_toIntegerNode_, this.segments_createResultNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doOther";
            if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static SegmentsContainingNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new SegmentsContainingNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(SegmentsIteratorNode.class)
    public static final class SegmentsIteratorNodeGen extends SegmentsIteratorNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private SegmentsIteratorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doSegments(JSSegmentsObject) */ && arguments0Value_ instanceof JSSegmentsObject) {
                JSSegmentsObject arguments0Value__ = (JSSegmentsObject) arguments0Value_;
                return doSegments(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doSegments(JSSegmentsObject) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object) */) {
                if ((!(JSGuards.isJSSegments(arguments0Value_)))) {
                    doOther(arguments0Value_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof JSSegmentsObject) {
                JSSegmentsObject arguments0Value_ = (JSSegmentsObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doSegments(JSSegmentsObject) */;
                return doSegments(arguments0Value_);
            }
            if ((!(JSGuards.isJSSegments(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doOther(Object) */;
                doOther(arguments0Value);
                return null;
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "doSegments";
            if ((state_0 & 0b1) != 0 /* is-state_0 doSegments(JSSegmentsObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doOther";
            if ((state_0 & 0b10) != 0 /* is-state_0 doOther(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static SegmentsIteratorNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new SegmentsIteratorNodeGen(context, builtin, arguments);
        }

    }
}
