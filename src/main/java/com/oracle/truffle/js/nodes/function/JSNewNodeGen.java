// CheckStyle: start generated
package com.oracle.truffle.js.nodes.function;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSNewNode.class)
public final class JSNewNodeGen extends JSNewNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @Child private JSFunctionCallNode callNew;
    @Child private NewForeignObjectData newForeignObject_cache;

    private JSNewNodeGen(JSContext context, JavaScriptNode targetNode, AbstractFunctionArgumentsNode arguments) {
        super(context, targetNode, arguments);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object targetNodeValue_ = super.targetNode.execute(frameValue);
        if ((state_0 & 0b1111) != 0 /* is-state_0 doNewReturnThis(VirtualFrame, DynamicObject, JSFunctionCallNode) || doNewJSProxy(VirtualFrame, DynamicObject, JSFunctionCallNode) || doJSAdapter(VirtualFrame, DynamicObject) || createClassNotFoundError(VirtualFrame, DynamicObject) */ && JSTypes.isDynamicObject(targetNodeValue_)) {
            DynamicObject targetNodeValue__ = (DynamicObject) targetNodeValue_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doNewReturnThis(VirtualFrame, DynamicObject, JSFunctionCallNode) */) {
                if ((JSGuards.isJSFunction(targetNodeValue__))) {
                    return doNewReturnThis(frameValue, targetNodeValue__, this.callNew);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doNewJSProxy(VirtualFrame, DynamicObject, JSFunctionCallNode) */) {
                if ((JSGuards.isJSProxy(targetNodeValue__))) {
                    return doNewJSProxy(frameValue, targetNodeValue__, this.callNew);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doJSAdapter(VirtualFrame, DynamicObject) */) {
                if ((JSGuards.isJSAdapter(targetNodeValue__))) {
                    return doJSAdapter(frameValue, targetNodeValue__);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 createClassNotFoundError(VirtualFrame, DynamicObject) */) {
                if ((JSGuards.isJavaPackage(targetNodeValue__))) {
                    return createClassNotFoundError(frameValue, targetNodeValue__);
                }
            }
        }
        if ((state_0 & 0b110000) != 0 /* is-state_0 doNewForeignObject(VirtualFrame, Object, InteropLibrary, ExportValueNode, ImportValueNode, ConditionProfile, ConditionProfile) || createFunctionTypeError(VirtualFrame, Object) */) {
            if ((state_0 & 0b10000) != 0 /* is-state_0 doNewForeignObject(VirtualFrame, Object, InteropLibrary, ExportValueNode, ImportValueNode, ConditionProfile, ConditionProfile) */) {
                NewForeignObjectData s4_ = this.newForeignObject_cache;
                if (s4_ != null) {
                    if ((JSGuards.isForeignObject(targetNodeValue_))) {
                        return doNewForeignObject(frameValue, targetNodeValue_, s4_.interop_, s4_.convert_, s4_.toJSType_, s4_.isHostClassProf_, s4_.isAbstractProf_);
                    }
                }
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 createFunctionTypeError(VirtualFrame, Object) */) {
                if ((!(JSGuards.isJSFunction(targetNodeValue_))) && (!(JSGuards.isJSAdapter(targetNodeValue_))) && (!(JSGuards.isJSProxy(targetNodeValue_))) && (!(JSGuards.isJavaPackage(targetNodeValue_))) && (!(JSGuards.isForeignObject(targetNodeValue_)))) {
                    return createFunctionTypeError(frameValue, targetNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, targetNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(VirtualFrame frameValue, Object targetNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(targetNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSFunction(targetNodeValue_))) {
                    this.callNew = super.insert(this.callNew == null ? ((JSFunctionCallNode.createNew())) : this.callNew);
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNewReturnThis(VirtualFrame, DynamicObject, JSFunctionCallNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doNewReturnThis(frameValue, targetNodeValue_, this.callNew);
                }
                if ((JSGuards.isJSProxy(targetNodeValue_))) {
                    this.callNew = super.insert(this.callNew == null ? ((JSFunctionCallNode.createNew())) : this.callNew);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doNewJSProxy(VirtualFrame, DynamicObject, JSFunctionCallNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doNewJSProxy(frameValue, targetNodeValue_, this.callNew);
                }
                if ((JSGuards.isJSAdapter(targetNodeValue_))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doJSAdapter(VirtualFrame, DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSAdapter(frameValue, targetNodeValue_);
                }
                if ((JSGuards.isJavaPackage(targetNodeValue_))) {
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 createClassNotFoundError(VirtualFrame, DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return createClassNotFoundError(frameValue, targetNodeValue_);
                }
            }
            if ((JSGuards.isForeignObject(targetNodeValue))) {
                NewForeignObjectData s4_ = super.insert(new NewForeignObjectData());
                s4_.interop_ = s4_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                s4_.convert_ = s4_.insertAccessor((ExportValueNode.create()));
                s4_.toJSType_ = s4_.insertAccessor((ImportValueNode.create()));
                s4_.isHostClassProf_ = (ConditionProfile.createBinaryProfile());
                s4_.isAbstractProf_ = (ConditionProfile.createBinaryProfile());
                MemoryFence.storeStore();
                this.newForeignObject_cache = s4_;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doNewForeignObject(VirtualFrame, Object, InteropLibrary, ExportValueNode, ImportValueNode, ConditionProfile, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doNewForeignObject(frameValue, targetNodeValue, s4_.interop_, s4_.convert_, s4_.toJSType_, s4_.isHostClassProf_, s4_.isAbstractProf_);
            }
            if ((!(JSGuards.isJSFunction(targetNodeValue))) && (!(JSGuards.isJSAdapter(targetNodeValue))) && (!(JSGuards.isJSProxy(targetNodeValue))) && (!(JSGuards.isJavaPackage(targetNodeValue))) && (!(JSGuards.isForeignObject(targetNodeValue)))) {
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 createFunctionTypeError(VirtualFrame, Object) */;
                lock.unlock();
                hasLock = false;
                return createFunctionTypeError(frameValue, targetNodeValue);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.targetNode}, targetNodeValue);
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
        Object[] data = new Object[7];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        s = new Object[3];
        s[0] = "doNewReturnThis";
        if ((state_0 & 0b1) != 0 /* is-state_0 doNewReturnThis(VirtualFrame, DynamicObject, JSFunctionCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.callNew));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doNewJSProxy";
        if ((state_0 & 0b10) != 0 /* is-state_0 doNewJSProxy(VirtualFrame, DynamicObject, JSFunctionCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.callNew));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doJSAdapter";
        if ((state_0 & 0b100) != 0 /* is-state_0 doJSAdapter(VirtualFrame, DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "createClassNotFoundError";
        if ((state_0 & 0b1000) != 0 /* is-state_0 createClassNotFoundError(VirtualFrame, DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doNewForeignObject";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doNewForeignObject(VirtualFrame, Object, InteropLibrary, ExportValueNode, ImportValueNode, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            NewForeignObjectData s4_ = this.newForeignObject_cache;
            if (s4_ != null) {
                cached.add(Arrays.asList(s4_.interop_, s4_.convert_, s4_.toJSType_, s4_.isHostClassProf_, s4_.isAbstractProf_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "createFunctionTypeError";
        if ((state_0 & 0b100000) != 0 /* is-state_0 createFunctionTypeError(VirtualFrame, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        return Provider.create(data);
    }

    public static JSNewNode create(JSContext context, JavaScriptNode targetNode, AbstractFunctionArgumentsNode arguments) {
        return new JSNewNodeGen(context, targetNode, arguments);
    }

    @GeneratedBy(JSNewNode.class)
    private static final class NewForeignObjectData extends Node {

        @Child InteropLibrary interop_;
        @Child ExportValueNode convert_;
        @Child ImportValueNode toJSType_;
        @CompilationFinal ConditionProfile isHostClassProf_;
        @CompilationFinal ConditionProfile isAbstractProf_;

        NewForeignObjectData() {
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
