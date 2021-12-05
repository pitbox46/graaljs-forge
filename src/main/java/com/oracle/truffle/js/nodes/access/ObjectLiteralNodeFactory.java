// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ComputedObjectLiteralDataMemberNode;
import com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ObjectLiteralNode.class)
public final class ObjectLiteralNodeFactory {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @GeneratedBy(ComputedObjectLiteralDataMemberNode.class)
    public static final class ComputedObjectLiteralDataMemberNodeGen extends ComputedObjectLiteralDataMemberNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private NoFieldNoFunctionDef0Data noFieldNoFunctionDef0_cache;

        private ComputedObjectLiteralDataMemberNodeGen(JavaScriptNode key, boolean isStatic, int attributes, JavaScriptNode valueNode, boolean isField, boolean isAnonymousFunctionDefinition) {
            super(key, isStatic, attributes, valueNode, isField, isAnonymousFunctionDefinition);
        }

        @ExplodeLoop
        @Override
        public void executeVoid(VirtualFrame frameValue, DynamicObject arg0Value, DynamicObject arg1Value, JSContext arg2Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) || doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) || doGeneric(VirtualFrame, DynamicObject, DynamicObject, JSContext) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) */) {
                    NoFieldNoFunctionDef0Data s0_ = this.noFieldNoFunctionDef0_cache;
                    while (s0_ != null) {
                        if ((s0_.dynamicObject_.accepts(arg0Value))) {
                            assert (!(isFieldOrStaticBlock));
                            assert (!(isAnonymousFunctionDefinition));
                            assert (setFunctionName == null);
                            assert (!(ObjectLiteralMemberNode.isMethodNode(valueNode)));
                            doNoFieldNoFunctionDef(frameValue, arg0Value, arg1Value, arg2Value, s0_.dynamicObject_);
                            return;
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) */) {
                    {
                        DynamicObjectLibrary noFieldNoFunctionDef1_dynamicObject__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached());
                        assert (!(isFieldOrStaticBlock));
                        assert (!(isAnonymousFunctionDefinition));
                        assert (setFunctionName == null);
                        assert (!(ObjectLiteralMemberNode.isMethodNode(valueNode)));
                        doNoFieldNoFunctionDef(frameValue, arg0Value, arg1Value, arg2Value, noFieldNoFunctionDef1_dynamicObject__);
                        return;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doGeneric(VirtualFrame, DynamicObject, DynamicObject, JSContext) */) {
                    doGeneric(frameValue, arg0Value, arg1Value, arg2Value);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(frameValue, arg0Value, arg1Value, arg2Value);
            return;
        }

        private void executeAndSpecialize(VirtualFrame frameValue, DynamicObject arg0Value, DynamicObject arg1Value, JSContext arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) */) {
                    int count0_ = 0;
                    NoFieldNoFunctionDef0Data s0_ = this.noFieldNoFunctionDef0_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) */) {
                        while (s0_ != null) {
                            if ((s0_.dynamicObject_.accepts(arg0Value))) {
                                assert (!(isFieldOrStaticBlock));
                                assert (!(isAnonymousFunctionDefinition));
                                assert (setFunctionName == null);
                                assert (!(ObjectLiteralMemberNode.isMethodNode(valueNode)));
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        if ((!(isFieldOrStaticBlock)) && (!(isAnonymousFunctionDefinition)) && (setFunctionName == null) && (!(ObjectLiteralMemberNode.isMethodNode(valueNode))) && count0_ < (3)) {
                            // assert (s0_.dynamicObject_.accepts(arg0Value));
                            s0_ = super.insert(new NoFieldNoFunctionDef0Data(noFieldNoFunctionDef0_cache));
                            s0_.dynamicObject_ = s0_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.create(arg0Value)));
                            MemoryFence.storeStore();
                            this.noFieldNoFunctionDef0_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        doNoFieldNoFunctionDef(frameValue, arg0Value, arg1Value, arg2Value, s0_.dynamicObject_);
                        return;
                    }
                }
                {
                    DynamicObjectLibrary noFieldNoFunctionDef1_dynamicObject__ = null;
                    if ((!(isFieldOrStaticBlock)) && (!(isAnonymousFunctionDefinition)) && (setFunctionName == null) && (!(ObjectLiteralMemberNode.isMethodNode(valueNode)))) {
                        noFieldNoFunctionDef1_dynamicObject__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached());
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) */;
                        this.noFieldNoFunctionDef0_cache = null;
                        state_0 = state_0 & 0xfffffffe /* remove-state_0 doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) */;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        doNoFieldNoFunctionDef(frameValue, arg0Value, arg1Value, arg2Value, noFieldNoFunctionDef1_dynamicObject__);
                        return;
                    }
                }
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doGeneric(VirtualFrame, DynamicObject, DynamicObject, JSContext) */;
                lock.unlock();
                hasLock = false;
                doGeneric(frameValue, arg0Value, arg1Value, arg2Value);
                return;
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
                    NoFieldNoFunctionDef0Data s0_ = this.noFieldNoFunctionDef0_cache;
                    if ((s0_ == null || s0_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
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
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "doNoFieldNoFunctionDef";
            if ((state_0 & 0b1) != 0 /* is-state_0 doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                NoFieldNoFunctionDef0Data s0_ = this.noFieldNoFunctionDef0_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.dynamicObject_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doNoFieldNoFunctionDef";
            if ((state_0 & 0b10) != 0 /* is-state_0 doNoFieldNoFunctionDef(VirtualFrame, DynamicObject, DynamicObject, JSContext, DynamicObjectLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doGeneric";
            if ((state_0 & 0b100) != 0 /* is-state_0 doGeneric(VirtualFrame, DynamicObject, DynamicObject, JSContext) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static ComputedObjectLiteralDataMemberNode create(JavaScriptNode key, boolean isStatic, int attributes, JavaScriptNode valueNode, boolean isField, boolean isAnonymousFunctionDefinition) {
            return new ComputedObjectLiteralDataMemberNodeGen(key, isStatic, attributes, valueNode, isField, isAnonymousFunctionDefinition);
        }

        @GeneratedBy(ComputedObjectLiteralDataMemberNode.class)
        private static final class NoFieldNoFunctionDef0Data extends Node {

            @Child NoFieldNoFunctionDef0Data next_;
            @Child DynamicObjectLibrary dynamicObject_;

            NoFieldNoFunctionDef0Data(NoFieldNoFunctionDef0Data next_) {
                this.next_ = next_;
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
