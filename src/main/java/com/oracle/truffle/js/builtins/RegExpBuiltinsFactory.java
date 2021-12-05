// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.builtins.RegExpBuiltins.GetStaticRegExpResultNode;
import com.oracle.truffle.js.builtins.RegExpBuiltins.JSRegExpStaticResultGetGroupNode;
import com.oracle.truffle.js.builtins.RegExpBuiltins.JSRegExpStaticResultGetInputNode;
import com.oracle.truffle.js.builtins.RegExpBuiltins.JSRegExpStaticResultLastParenNode;
import com.oracle.truffle.js.builtins.RegExpBuiltins.JSRegExpStaticResultLeftContextNode;
import com.oracle.truffle.js.builtins.RegExpBuiltins.JSRegExpStaticResultMultilineNode;
import com.oracle.truffle.js.builtins.RegExpBuiltins.JSRegExpStaticResultRightContextNode;
import com.oracle.truffle.js.builtins.RegExpBuiltins.JSRegExpStaticResultSetInputNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.util.TRegexUtil.TRegexResultAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RegExpBuiltins.class)
@SuppressWarnings("unused")
public final class RegExpBuiltinsFactory {

    @GeneratedBy(GetStaticRegExpResultNode.class)
    static final class GetStaticRegExpResultNodeGen extends GetStaticRegExpResultNode implements Introspection.Provider {

        private GetStaticRegExpResultNodeGen(JSContext context) {
            super(context);
        }

        @Override
        Object execute() {
            return get();
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
            s[0] = "get";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static GetStaticRegExpResultNode create(JSContext context) {
            return new GetStaticRegExpResultNodeGen(context);
        }

    }
    @GeneratedBy(JSRegExpStaticResultGetInputNode.class)
    static final class JSRegExpStaticResultGetInputNodeGen extends JSRegExpStaticResultGetInputNode implements Introspection.Provider {

        private JSRegExpStaticResultGetInputNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return getInputProp(frameValue);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
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
            s[0] = "getInputProp";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSRegExpStaticResultGetInputNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpStaticResultGetInputNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpStaticResultSetInputNode.class)
    static final class JSRegExpStaticResultSetInputNodeGen extends JSRegExpStaticResultSetInputNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private JSRegExpStaticResultSetInputNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return setInputProp(frameValue, arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
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
            s[0] = "setInputProp";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSRegExpStaticResultSetInputNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpStaticResultSetInputNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpStaticResultMultilineNode.class)
    static final class JSRegExpStaticResultMultilineNodeGen extends JSRegExpStaticResultMultilineNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private Assumption getMultilineLazy_assumption0_;
        @Child private GetStaticRegExpResultNode getMultilineEager_getResultNode_;
        @Child private TRegexResultAccessor getMultilineEager_resultAccessor_;

        private JSRegExpStaticResultMultilineNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 getMultilineLazyNashorn() */) {
                assert (getContext().isOptionNashornCompatibilityMode());
                return getMultilineLazyNashorn();
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 getMultilineLazy() */) {
                if (!Assumption.isValidAssumption(this.getMultilineLazy_assumption0_)) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    removeGetMultilineLazy_();
                    return executeAndSpecialize();
                }
                assert (!(getContext().isOptionNashornCompatibilityMode()));
                return getMultilineLazy();
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 getMultilineEager(GetStaticRegExpResultNode, TRegexResultAccessor) */) {
                return getMultilineEager(this.getMultilineEager_getResultNode_, this.getMultilineEager_resultAccessor_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize();
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 getMultilineLazyNashorn() */) {
                assert (getContext().isOptionNashornCompatibilityMode());
                return getMultilineLazyNashorn();
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 getMultilineLazy() */) {
                if (!Assumption.isValidAssumption(this.getMultilineLazy_assumption0_)) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    removeGetMultilineLazy_();
                    return executeAndSpecialize();
                }
                assert (!(getContext().isOptionNashornCompatibilityMode()));
                return getMultilineLazy();
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 getMultilineEager(GetStaticRegExpResultNode, TRegexResultAccessor) */) {
                return getMultilineEager(this.getMultilineEager_getResultNode_, this.getMultilineEager_resultAccessor_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize() {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if ((getContext().isOptionNashornCompatibilityMode())) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getMultilineLazyNashorn() */;
                    lock.unlock();
                    hasLock = false;
                    return getMultilineLazyNashorn();
                }
                if ((!(getContext().isOptionNashornCompatibilityMode()))) {
                    Assumption getMultilineLazy_assumption0 = (getStaticResultUnusedAssumption());
                    if (Assumption.isValidAssumption(getMultilineLazy_assumption0)) {
                        this.getMultilineLazy_assumption0_ = getMultilineLazy_assumption0;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getMultilineLazy() */;
                        lock.unlock();
                        hasLock = false;
                        return getMultilineLazy();
                    }
                }
                this.getMultilineEager_getResultNode_ = super.insert((createGetResultNode()));
                this.getMultilineEager_resultAccessor_ = super.insert((TRegexResultAccessor.create()));
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 getMultilineEager(GetStaticRegExpResultNode, TRegexResultAccessor) */;
                lock.unlock();
                hasLock = false;
                return getMultilineEager(this.getMultilineEager_getResultNode_, this.getMultilineEager_resultAccessor_);
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

        void removeGetMultilineLazy_() {
            Lock lock = getLock();
            lock.lock();
            try {
                this.state_0_ = this.state_0_ & 0xfffffffd /* remove-state_0 getMultilineLazy() */;
            } finally {
                lock.unlock();
            }
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "getMultilineLazyNashorn";
            if ((state_0 & 0b1) != 0 /* is-state_0 getMultilineLazyNashorn() */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "getMultilineLazy";
            if ((state_0 & 0b10) != 0 /* is-state_0 getMultilineLazy() */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "getMultilineEager";
            if ((state_0 & 0b100) != 0 /* is-state_0 getMultilineEager(GetStaticRegExpResultNode, TRegexResultAccessor) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.getMultilineEager_getResultNode_, this.getMultilineEager_resultAccessor_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSRegExpStaticResultMultilineNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpStaticResultMultilineNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpStaticResultGetGroupNode.class)
    static final class JSRegExpStaticResultGetGroupNodeGen extends JSRegExpStaticResultGetGroupNode implements Introspection.Provider {

        private JSRegExpStaticResultGetGroupNodeGen(JSContext context, JSBuiltin builtin, int groupNumber, JavaScriptNode[] arguments) {
            super(context, builtin, groupNumber);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return getGroup(frameValue);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
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
            s[0] = "getGroup";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSRegExpStaticResultGetGroupNode create(JSContext context, JSBuiltin builtin, int groupNumber, JavaScriptNode[] arguments) {
            return new JSRegExpStaticResultGetGroupNodeGen(context, builtin, groupNumber, arguments);
        }

    }
    @GeneratedBy(JSRegExpStaticResultLastParenNode.class)
    static final class JSRegExpStaticResultLastParenNodeGen extends JSRegExpStaticResultLastParenNode implements Introspection.Provider {

        private JSRegExpStaticResultLastParenNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return lastParen(frameValue);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
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
            s[0] = "lastParen";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSRegExpStaticResultLastParenNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpStaticResultLastParenNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpStaticResultLeftContextNode.class)
    static final class JSRegExpStaticResultLeftContextNodeGen extends JSRegExpStaticResultLeftContextNode implements Introspection.Provider {

        private JSRegExpStaticResultLeftContextNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return leftContext(frameValue);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
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
            s[0] = "leftContext";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSRegExpStaticResultLeftContextNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpStaticResultLeftContextNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpStaticResultRightContextNode.class)
    static final class JSRegExpStaticResultRightContextNodeGen extends JSRegExpStaticResultRightContextNode implements Introspection.Provider {

        private JSRegExpStaticResultRightContextNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return rightContext(frameValue);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
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
            s[0] = "rightContext";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSRegExpStaticResultRightContextNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpStaticResultRightContextNodeGen(context, builtin, arguments);
        }

    }
}
