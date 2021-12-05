// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNodeGen;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSInteropGetIteratorNode.class)
public final class JSInteropGetIteratorNodeGen extends JSInteropGetIteratorNode implements Introspection.Provider {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private volatile int state_0_;
    @Child private DefaultData default_cache;

    private JSInteropGetIteratorNodeGen() {
    }

    @Override
    protected Object execute(JSObject arg0Value, JavaScriptLanguage arg1Value, boolean arg2Value) throws UnsupportedMessageException {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doDefault(JSObject, JavaScriptLanguage, boolean, PropertyGetNode, IsCallableNode, JSFunctionCallNode, PropertyGetNode, BranchProfile) */) {
            DefaultData s0_ = this.default_cache;
            if (s0_ != null) {
                return doDefault(arg0Value, arg1Value, arg2Value, s0_.iteratorPropertyGetNode_, s0_.isCallableNode_, s0_.callNode_, s0_.nextPropertyGetNode_, s0_.exceptionBranch_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private Object executeAndSpecialize(JSObject arg0Value, JavaScriptLanguage arg1Value, boolean arg2Value) throws UnsupportedMessageException {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            DefaultData s0_ = super.insert(new DefaultData());
            s0_.iteratorPropertyGetNode_ = s0_.insertAccessor((PropertyGetNode.create(Symbol.SYMBOL_ITERATOR, arg1Value.getJSContext())));
            s0_.isCallableNode_ = s0_.insertAccessor((IsCallableNode.create()));
            s0_.callNode_ = s0_.insertAccessor((JSFunctionCallNode.createCall()));
            s0_.nextPropertyGetNode_ = s0_.insertAccessor((PropertyGetNode.create(JSRuntime.NEXT, arg1Value.getJSContext())));
            s0_.exceptionBranch_ = (BranchProfile.create());
            MemoryFence.storeStore();
            this.default_cache = s0_;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doDefault(JSObject, JavaScriptLanguage, boolean, PropertyGetNode, IsCallableNode, JSFunctionCallNode, PropertyGetNode, BranchProfile) */;
            lock.unlock();
            hasLock = false;
            return doDefault(arg0Value, arg1Value, arg2Value, s0_.iteratorPropertyGetNode_, s0_.isCallableNode_, s0_.callNode_, s0_.nextPropertyGetNode_, s0_.exceptionBranch_);
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
        s[0] = "doDefault";
        if (state_0 != 0 /* is-state_0 doDefault(JSObject, JavaScriptLanguage, boolean, PropertyGetNode, IsCallableNode, JSFunctionCallNode, PropertyGetNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            DefaultData s0_ = this.default_cache;
            if (s0_ != null) {
                cached.add(Arrays.asList(s0_.iteratorPropertyGetNode_, s0_.isCallableNode_, s0_.callNode_, s0_.nextPropertyGetNode_, s0_.exceptionBranch_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static JSInteropGetIteratorNode create() {
        return new JSInteropGetIteratorNodeGen();
    }

    public static JSInteropGetIteratorNode getUncached() {
        return JSInteropGetIteratorNodeGen.UNCACHED;
    }

    @GeneratedBy(JSInteropGetIteratorNode.class)
    private static final class DefaultData extends Node {

        @Child PropertyGetNode iteratorPropertyGetNode_;
        @Child IsCallableNode isCallableNode_;
        @Child JSFunctionCallNode callNode_;
        @Child PropertyGetNode nextPropertyGetNode_;
        @CompilationFinal BranchProfile exceptionBranch_;

        DefaultData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSInteropGetIteratorNode.class)
    private static final class Uncached extends JSInteropGetIteratorNode {

        @TruffleBoundary
        @Override
        protected Object execute(JSObject arg0Value, JavaScriptLanguage arg1Value, boolean arg2Value) throws UnsupportedMessageException {
            return doDefault(arg0Value, arg1Value, arg2Value, (JSInteropCallNode.getUncachedProperty()), (IsCallableNodeGen.getUncached()), (JSFunctionCallNode.getUncachedCall()), (JSInteropCallNode.getUncachedProperty()), (BranchProfile.getUncached()));
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
}
