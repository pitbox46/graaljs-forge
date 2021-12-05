// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNodeGen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSInteropInvokeNode.class)
public final class JSInteropInvokeNodeGen extends JSInteropInvokeNode implements Introspection.Provider {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private IsCallableNode isCallable;
    @Child private JSFunctionCallNode call;
    @Child private ImportValueNode importValue;
    @CompilationFinal private String cached_cachedName_;
    @Child private PropertyGetNode cached_functionPropertyGetNode_;
    @Child private ReadElementNode uncached_readNode_;

    private JSInteropInvokeNodeGen() {
    }

    @Override
    public Object execute(DynamicObject arg0Value, String arg1Value, Object[] arg2Value) throws UnknownIdentifierException, UnsupportedMessageException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 doCached(DynamicObject, String, Object[], String, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) || doUncached(DynamicObject, String, Object[], ReadElementNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, String, Object[], String, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
                if ((this.cached_cachedName_.equals(arg1Value))) {
                    return doCached(arg0Value, arg1Value, arg2Value, this.cached_cachedName_, this.cached_functionPropertyGetNode_, this.isCallable, this.call, this.importValue);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(DynamicObject, String, Object[], ReadElementNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
                return doUncached(arg0Value, arg1Value, arg2Value, this.uncached_readNode_, this.isCallable, this.call, this.importValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private Object executeAndSpecialize(DynamicObject arg0Value, String arg1Value, Object[] arg2Value) throws UnknownIdentifierException, UnsupportedMessageException {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude doCached(DynamicObject, String, Object[], String, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
                boolean Cached_duplicateFound_ = false;
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, String, Object[], String, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
                    if ((this.cached_cachedName_.equals(arg1Value))) {
                        Cached_duplicateFound_ = true;
                    }
                }
                if (!Cached_duplicateFound_) {
                    // assert (this.cached_cachedName_.equals(arg1Value));
                    if (((state_0 & 0b1)) == 0 /* is-not-state_0 doCached(DynamicObject, String, Object[], String, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
                        this.cached_cachedName_ = (arg1Value);
                        this.cached_functionPropertyGetNode_ = super.insert((createGetProperty(this.cached_cachedName_)));
                        this.isCallable = super.insert(this.isCallable == null ? ((IsCallableNode.create())) : this.isCallable);
                        this.call = super.insert(this.call == null ? ((JSFunctionCallNode.createCall())) : this.call);
                        this.importValue = super.insert(this.importValue == null ? ((ImportValueNode.create())) : this.importValue);
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, String, Object[], String, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */;
                        Cached_duplicateFound_ = true;
                    }
                }
                if (Cached_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return doCached(arg0Value, arg1Value, arg2Value, this.cached_cachedName_, this.cached_functionPropertyGetNode_, this.isCallable, this.call, this.importValue);
                }
            }
            this.uncached_readNode_ = super.insert((ReadElementNode.create(getLanguage().getJSContext())));
            this.isCallable = super.insert(this.isCallable == null ? ((IsCallableNode.create())) : this.isCallable);
            this.call = super.insert(this.call == null ? ((JSFunctionCallNode.createCall())) : this.call);
            this.importValue = super.insert(this.importValue == null ? ((ImportValueNode.create())) : this.importValue);
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(DynamicObject, String, Object[], String, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(DynamicObject, String, Object[], String, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(DynamicObject, String, Object[], ReadElementNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */;
            lock.unlock();
            hasLock = false;
            return doUncached(arg0Value, arg1Value, arg2Value, this.uncached_readNode_, this.isCallable, this.call, this.importValue);
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
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, String, Object[], String, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cached_cachedName_, this.cached_functionPropertyGetNode_, this.isCallable, this.call, this.importValue));
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doCached(DynamicObject, String, Object[], String, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(DynamicObject, String, Object[], ReadElementNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.uncached_readNode_, this.isCallable, this.call, this.importValue));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSInteropInvokeNode create() {
        return new JSInteropInvokeNodeGen();
    }

    public static JSInteropInvokeNode getUncached() {
        return JSInteropInvokeNodeGen.UNCACHED;
    }

    @GeneratedBy(JSInteropInvokeNode.class)
    private static final class Uncached extends JSInteropInvokeNode {

        @TruffleBoundary
        @Override
        public Object execute(DynamicObject arg0Value, String arg1Value, Object[] arg2Value) throws UnknownIdentifierException, UnsupportedMessageException {
            return doUncached(arg0Value, arg1Value, arg2Value, (JSInteropInvokeNode.getUncachedRead()), (IsCallableNodeGen.getUncached()), (JSFunctionCallNode.getUncachedCall()), (ImportValueNode.getUncached()));
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
