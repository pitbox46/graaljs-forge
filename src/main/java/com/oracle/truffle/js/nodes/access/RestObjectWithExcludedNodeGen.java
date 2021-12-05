// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RestObjectWithExcludedNode.class)
final class RestObjectWithExcludedNodeGen extends RestObjectWithExcludedNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private JSToObjectNode other_toObjectNode_;

    private RestObjectWithExcludedNodeGen(JSContext context, JavaScriptNode targetNode, JavaScriptNode sourceNode, JavaScriptNode excludedNode) {
        super(context, targetNode, sourceNode, excludedNode);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object targetNodeValue_ = super.targetNode.execute(frameValue);
        Object sourceNodeValue_ = super.sourceNode.execute(frameValue);
        Object excludedNodeValue_ = super.excludedNode.execute(frameValue);
        if (state_0 != 0 /* is-state_0 doNullOrUndefined(DynamicObject, Object, Object[]) || copyDataProperties(DynamicObject, DynamicObject, Object[]) || doOther(DynamicObject, Object, Object[], JSToObjectNode) */ && JSTypes.isDynamicObject(targetNodeValue_)) {
            DynamicObject targetNodeValue__ = (DynamicObject) targetNodeValue_;
            if (excludedNodeValue_ instanceof Object[]) {
                Object[] excludedNodeValue__ = (Object[]) excludedNodeValue_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doNullOrUndefined(DynamicObject, Object, Object[]) */) {
                    if ((JSGuards.isNullOrUndefined(sourceNodeValue_))) {
                        return RestObjectWithExcludedNode.doNullOrUndefined(targetNodeValue__, sourceNodeValue_, excludedNodeValue__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 copyDataProperties(DynamicObject, DynamicObject, Object[]) */ && JSTypes.isDynamicObject(sourceNodeValue_)) {
                    DynamicObject sourceNodeValue__ = (DynamicObject) sourceNodeValue_;
                    if ((JSGuards.isJSObject(sourceNodeValue__))) {
                        return copyDataProperties(targetNodeValue__, sourceNodeValue__, excludedNodeValue__);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doOther(DynamicObject, Object, Object[], JSToObjectNode) */) {
                    if ((!(JSGuards.isJSDynamicObject(sourceNodeValue_)))) {
                        return doOther(targetNodeValue__, sourceNodeValue_, excludedNodeValue__, this.other_toObjectNode_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue_, sourceNodeValue_, excludedNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object targetNodeValue, Object sourceNodeValue, Object excludedNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(targetNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if (excludedNodeValue instanceof Object[]) {
                    Object[] excludedNodeValue_ = (Object[]) excludedNodeValue;
                    if ((JSGuards.isNullOrUndefined(sourceNodeValue))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNullOrUndefined(DynamicObject, Object, Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return RestObjectWithExcludedNode.doNullOrUndefined(targetNodeValue_, sourceNodeValue, excludedNodeValue_);
                    }
                    if (JSTypes.isDynamicObject(sourceNodeValue)) {
                        DynamicObject sourceNodeValue_ = (DynamicObject) sourceNodeValue;
                        if ((JSGuards.isJSObject(sourceNodeValue_))) {
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 copyDataProperties(DynamicObject, DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return copyDataProperties(targetNodeValue_, sourceNodeValue_, excludedNodeValue_);
                        }
                    }
                    if ((!(JSGuards.isJSDynamicObject(sourceNodeValue)))) {
                        this.other_toObjectNode_ = super.insert((JSToObjectNode.createToObjectNoCheck(context)));
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doOther(DynamicObject, Object, Object[], JSToObjectNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doOther(targetNodeValue_, sourceNodeValue, excludedNodeValue_, this.other_toObjectNode_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.targetNode, super.sourceNode, super.excludedNode}, targetNodeValue, sourceNodeValue, excludedNodeValue);
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
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doNullOrUndefined";
        if ((state_0 & 0b1) != 0 /* is-state_0 doNullOrUndefined(DynamicObject, Object, Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "copyDataProperties";
        if ((state_0 & 0b10) != 0 /* is-state_0 copyDataProperties(DynamicObject, DynamicObject, Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state_0 & 0b100) != 0 /* is-state_0 doOther(DynamicObject, Object, Object[], JSToObjectNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.other_toObjectNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static RestObjectWithExcludedNode create(JSContext context, JavaScriptNode targetNode, JavaScriptNode sourceNode, JavaScriptNode excludedNode) {
        return new RestObjectWithExcludedNodeGen(context, targetNode, sourceNode, excludedNode);
    }

}
