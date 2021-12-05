// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InitializeInstanceElementsNode.class)
public final class InitializeInstanceElementsNodeGen extends InitializeInstanceElementsNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @Child private PrivateFieldAddNode privateBrandAdd;
    @Children private DefineFieldNode[] withFields_fieldNodes_;

    private InitializeInstanceElementsNodeGen(JSContext context, JavaScriptNode targetNode, JavaScriptNode constructorNode) {
        super(context, targetNode, constructorNode);
    }

    @Override
    protected Object executeEvaluated(Object targetNodeValue, Object constructorNodeValue, Object[][] fieldsNodeValue, Object brandNodeValue) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 withFields(Object, Object, Object[][], Object, PrivateFieldAddNode, DefineFieldNode[]) || privateBrandAdd(Object, Object, Object, Object, PrivateFieldAddNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 withFields(Object, Object, Object[][], Object, PrivateFieldAddNode, DefineFieldNode[]) */) {
                return InitializeInstanceElementsNode.withFields(targetNodeValue, constructorNodeValue, fieldsNodeValue, brandNodeValue, this.privateBrandAdd, this.withFields_fieldNodes_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 privateBrandAdd(Object, Object, Object, Object, PrivateFieldAddNode) */) {
                return InitializeInstanceElementsNode.privateBrandAdd(targetNodeValue, constructorNodeValue, fieldsNodeValue, brandNodeValue, this.privateBrandAdd);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue, constructorNodeValue, fieldsNodeValue, brandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object targetNodeValue_ = super.targetNode.execute(frameValue);
        Object constructorNodeValue_ = super.constructorNode.execute(frameValue);
        Object fieldsNodeValue_ = super.fieldsNode.executeWithTarget(frameValue, constructorNodeValue_);
        Object brandNodeValue_ = super.brandNode.executeWithTarget(frameValue, constructorNodeValue_);
        if (state_0 != 0 /* is-state_0 withFields(Object, Object, Object[][], Object, PrivateFieldAddNode, DefineFieldNode[]) || privateBrandAdd(Object, Object, Object, Object, PrivateFieldAddNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 withFields(Object, Object, Object[][], Object, PrivateFieldAddNode, DefineFieldNode[]) */ && fieldsNodeValue_ instanceof Object[][]) {
                Object[][] fieldsNodeValue__ = (Object[][]) fieldsNodeValue_;
                return InitializeInstanceElementsNode.withFields(targetNodeValue_, constructorNodeValue_, fieldsNodeValue__, brandNodeValue_, this.privateBrandAdd, this.withFields_fieldNodes_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 privateBrandAdd(Object, Object, Object, Object, PrivateFieldAddNode) */) {
                return InitializeInstanceElementsNode.privateBrandAdd(targetNodeValue_, constructorNodeValue_, fieldsNodeValue_, brandNodeValue_, this.privateBrandAdd);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue_, constructorNodeValue_, fieldsNodeValue_, brandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object targetNodeValue, Object constructorNodeValue, Object fieldsNodeValue, Object brandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if (fieldsNodeValue instanceof Object[][]) {
                Object[][] fieldsNodeValue_ = (Object[][]) fieldsNodeValue;
                this.privateBrandAdd = super.insert(this.privateBrandAdd == null ? ((InitializeInstanceElementsNode.createBrandAddNode(brandNodeValue, context))) : this.privateBrandAdd);
                this.withFields_fieldNodes_ = super.insert((InitializeInstanceElementsNode.createFieldNodes(fieldsNodeValue_, context)));
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 withFields(Object, Object, Object[][], Object, PrivateFieldAddNode, DefineFieldNode[]) */;
                lock.unlock();
                hasLock = false;
                return InitializeInstanceElementsNode.withFields(targetNodeValue, constructorNodeValue, fieldsNodeValue_, brandNodeValue, this.privateBrandAdd, this.withFields_fieldNodes_);
            }
            this.privateBrandAdd = super.insert(this.privateBrandAdd == null ? ((InitializeInstanceElementsNode.createBrandAddNode(brandNodeValue, context))) : this.privateBrandAdd);
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 privateBrandAdd(Object, Object, Object, Object, PrivateFieldAddNode) */;
            lock.unlock();
            hasLock = false;
            return InitializeInstanceElementsNode.privateBrandAdd(targetNodeValue, constructorNodeValue, fieldsNodeValue, brandNodeValue, this.privateBrandAdd);
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
        s[0] = "withFields";
        if ((state_0 & 0b1) != 0 /* is-state_0 withFields(Object, Object, Object[][], Object, PrivateFieldAddNode, DefineFieldNode[]) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.privateBrandAdd, this.withFields_fieldNodes_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "privateBrandAdd";
        if ((state_0 & 0b10) != 0 /* is-state_0 privateBrandAdd(Object, Object, Object, Object, PrivateFieldAddNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.privateBrandAdd));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static InitializeInstanceElementsNode create(JSContext context, JavaScriptNode targetNode, JavaScriptNode constructorNode) {
        return new InitializeInstanceElementsNodeGen(context, targetNode, constructorNode);
    }

}
