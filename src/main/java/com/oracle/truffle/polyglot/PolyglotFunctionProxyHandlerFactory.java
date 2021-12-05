// CheckStyle: start generated
package com.oracle.truffle.polyglot;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.polyglot.PolyglotFunctionProxyHandler.FunctionProxyNode;
import com.oracle.truffle.polyglot.PolyglotObjectProxyHandler.ProxyInvokeNode;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PolyglotFunctionProxyHandler.class)
final class PolyglotFunctionProxyHandlerFactory {

    @GeneratedBy(FunctionProxyNode.class)
    static final class FunctionProxyNodeGen extends FunctionProxyNode {

        @CompilationFinal private volatile int state_0_;
        @Child private CachedData cached_cache;

        private FunctionProxyNodeGen(Class<?> receiverType, Method method) {
            super(receiverType, method);
        }

        @Override
        protected Object executeImpl(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(PolyglotLanguageContext, TruffleObject, Object[], Class<>, Type, PolyglotExecuteNode) */ && arg1Value instanceof TruffleObject) {
                TruffleObject arg1Value_ = (TruffleObject) arg1Value;
                CachedData s0_ = this.cached_cache;
                if (s0_ != null) {
                    return doCached(arg0Value, arg1Value_, arg2Value, s0_.returnClass_, s0_.returnType_, s0_.executeNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private Object executeAndSpecialize(PolyglotLanguageContext arg0Value, Object arg1Value, Object[] arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arg1Value instanceof TruffleObject) {
                    TruffleObject arg1Value_ = (TruffleObject) arg1Value;
                    CachedData s0_ = super.insert(new CachedData());
                    s0_.returnClass_ = (ProxyInvokeNode.getMethodReturnType(method));
                    s0_.returnType_ = (ProxyInvokeNode.getMethodGenericReturnType(method));
                    s0_.executeNode_ = s0_.insertAccessor((PolyglotExecuteNodeGen.create()));
                    MemoryFence.storeStore();
                    this.cached_cache = s0_;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(PolyglotLanguageContext, TruffleObject, Object[], Class<>, Type, PolyglotExecuteNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doCached(arg0Value, arg1Value_, arg2Value, s0_.returnClass_, s0_.returnType_, s0_.executeNode_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
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

        public static FunctionProxyNode create(Class<?> receiverType, Method method) {
            return new FunctionProxyNodeGen(receiverType, method);
        }

        @GeneratedBy(FunctionProxyNode.class)
        private static final class CachedData extends Node {

            @CompilationFinal Class<?> returnClass_;
            @CompilationFinal Type returnType_;
            @Child PolyglotExecuteNode executeNode_;

            CachedData() {
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
