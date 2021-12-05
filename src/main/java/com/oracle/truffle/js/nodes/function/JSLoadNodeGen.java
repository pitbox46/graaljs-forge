// CheckStyle: start generated
package com.oracle.truffle.js.nodes.function;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRealm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSLoadNode.class)
public final class JSLoadNodeGen extends JSLoadNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private ImportValueNode importValue;
    @CompilationFinal private Source cachedLoad_cachedSource_;
    @Child private DirectCallNode cachedLoad_callNode_;
    @Child private IndirectCallNode uncachedLoad_callNode_;

    private JSLoadNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public Object executeLoad(Source arg0Value, JSRealm arg1Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) || uncachedLoad(Source, JSRealm, ImportValueNode, IndirectCallNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */) {
                assert (this.cachedLoad_cachedSource_.isCached());
                if ((JSLoadNode.equals(arg0Value, this.cachedLoad_cachedSource_))) {
                    return JSLoadNode.cachedLoad(arg0Value, arg1Value, this.importValue, this.cachedLoad_cachedSource_, this.cachedLoad_callNode_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 uncachedLoad(Source, JSRealm, ImportValueNode, IndirectCallNode) */) {
                return JSLoadNode.uncachedLoad(arg0Value, arg1Value, this.importValue, this.uncachedLoad_callNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private Object executeAndSpecialize(Source arg0Value, JSRealm arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */) {
                boolean CachedLoad_duplicateFound_ = false;
                if ((state_0 & 0b1) != 0 /* is-state_0 cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */) {
                    assert (this.cachedLoad_cachedSource_.isCached());
                    if ((JSLoadNode.equals(arg0Value, this.cachedLoad_cachedSource_))) {
                        CachedLoad_duplicateFound_ = true;
                    }
                }
                if (!CachedLoad_duplicateFound_) {
                    {
                        Source cachedLoad_cachedSource__ = (arg0Value);
                        if ((cachedLoad_cachedSource__.isCached()) && (JSLoadNode.equals(arg0Value, cachedLoad_cachedSource__)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */) {
                            this.importValue = super.insert(this.importValue == null ? ((ImportValueNode.create())) : this.importValue);
                            this.cachedLoad_cachedSource_ = cachedLoad_cachedSource__;
                            this.cachedLoad_callNode_ = super.insert((DirectCallNode.create(JSLoadNode.loadScript(arg0Value, arg1Value))));
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */;
                            CachedLoad_duplicateFound_ = true;
                        }
                    }
                }
                if (CachedLoad_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return JSLoadNode.cachedLoad(arg0Value, arg1Value, this.importValue, this.cachedLoad_cachedSource_, this.cachedLoad_callNode_);
                }
            }
            this.importValue = super.insert(this.importValue == null ? ((ImportValueNode.create())) : this.importValue);
            this.uncachedLoad_callNode_ = super.insert((IndirectCallNode.create()));
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 uncachedLoad(Source, JSRealm, ImportValueNode, IndirectCallNode) */;
            lock.unlock();
            hasLock = false;
            return JSLoadNode.uncachedLoad(arg0Value, arg1Value, this.importValue, this.uncachedLoad_callNode_);
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
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "cachedLoad";
        if ((state_0 & 0b1) != 0 /* is-state_0 cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.importValue, this.cachedLoad_cachedSource_, this.cachedLoad_callNode_));
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "uncachedLoad";
        if ((state_0 & 0b10) != 0 /* is-state_0 uncachedLoad(Source, JSRealm, ImportValueNode, IndirectCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.importValue, this.uncachedLoad_callNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSLoadNode create(JSContext context) {
        return new JSLoadNodeGen(context);
    }

}
