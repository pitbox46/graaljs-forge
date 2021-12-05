// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.api.utilities.AssumedValue;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallBigIntNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallBooleanNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallCollatorNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallDateNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallDateTimeFormatNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallNumberFormatNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallNumberNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallRequiresNewNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallStringNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallSymbolNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallTypedArrayNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructAggregateErrorNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructArrayBufferNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructArrayNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructBigIntNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructBooleanNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructCollatorNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructDataViewNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructDateNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructDateTimeFormatNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructDisplayNamesNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructErrorNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructFinalizationRegistryNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructFunctionNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructJSAdapterNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructJSProxyNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructJavaImporterNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructListFormatNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructLocaleNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructMapNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructNumberFormatNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructNumberNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructObjectNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructPluralRulesNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructRegExpNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructRelativeTimeFormatNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructSegmenterNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructSetNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructStringNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructSymbolNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructWeakMapNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructWeakRefNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructWeakSetNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructWebAssemblyGlobalNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructWebAssemblyInstanceNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructWebAssemblyMemoryNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructWebAssemblyModuleNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructWebAssemblyTableNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CreateDynamicFunctionNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.LRUCache;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.PromiseConstructorNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.ScriptNode;
import com.oracle.truffle.js.nodes.access.GetMethodNode;
import com.oracle.truffle.js.nodes.access.IsJSObjectNode;
import com.oracle.truffle.js.nodes.access.IsObjectNode;
import com.oracle.truffle.js.nodes.access.IsRegExpNode;
import com.oracle.truffle.js.nodes.access.IteratorStepNode;
import com.oracle.truffle.js.nodes.access.IteratorValueNode;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.nodes.array.ArrayCreateNode;
import com.oracle.truffle.js.nodes.cast.JSNumberToBigIntNode;
import com.oracle.truffle.js.nodes.cast.JSNumericToNumberNode;
import com.oracle.truffle.js.nodes.cast.JSToBigIntNode;
import com.oracle.truffle.js.nodes.cast.JSToBooleanNode;
import com.oracle.truffle.js.nodes.cast.JSToIndexNode;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.cast.ToArrayLengthNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.builtins.JSAbstractBuffer;
import com.oracle.truffle.js.runtime.builtins.JSArrayBuffer;
import com.oracle.truffle.js.runtime.builtins.wasm.JSWebAssemblyModuleObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ConstructorBuiltins.class)
@SuppressWarnings("unused")
public final class ConstructorBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(ConstructArrayNode.class)
    public static final class ConstructArrayNodeGen extends ConstructArrayNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ConstructWithLengthData constructWithLength_cache;
        @Child private ConstructWithForeignArg0Data constructWithForeignArg0_cache;
        @Child private ConstructWithForeignArg1Data constructWithForeignArg1_cache;
        @CompilationFinal private ConstructArrayVarargsData constructArrayVarargs_cache;

        private ConstructArrayNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructArray0(DynamicObject, Object[]) || constructArrayWithIntLength(DynamicObject, Object[]) || constructWithLength(DynamicObject, Object[], ToArrayLengthNode, ArrayCreateNode, long) || constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) || constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) || constructArrayVarargs(DynamicObject, Object[], BranchProfile, BranchProfile, BranchProfile, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 constructArray0(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length == 0)) {
                            return constructArray0(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 constructArrayWithIntLength(DynamicObject, Object[]) */) {
                        if ((ConstructArrayNode.isOneIntegerArg(arguments1Value__))) {
                            return constructArrayWithIntLength(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 constructWithLength(DynamicObject, Object[], ToArrayLengthNode, ArrayCreateNode, long) */ && (arguments1Value__.length == 1)) {
                        ConstructWithLengthData s2_ = this.constructWithLength_cache;
                        while (s2_ != null) {
                            {
                                long len__ = (s2_.toArrayLengthNode_.executeLong(ConstructArrayNode.firstArg(arguments1Value__)));
                                if ((s2_.toArrayLengthNode_.isTypeNumber(len__))) {
                                    return constructWithLength(arguments0Value__, arguments1Value__, s2_.toArrayLengthNode_, s2_.arrayCreateNode_, len__);
                                }
                            }
                            s2_ = s2_.next_;
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                        ConstructWithForeignArg0Data s3_ = this.constructWithForeignArg0_cache;
                        while (s3_ != null) {
                            if ((s3_.interop_.accepts(ConstructArrayNode.firstArg(arguments1Value__))) && (ConstructArrayNode.isOneForeignArg(arguments1Value__))) {
                                return constructWithForeignArg(arguments0Value__, arguments1Value__, s3_.interop_, s3_.arrayCreateNode_, s3_.isNumber_, s3_.rangeErrorProfile_);
                            }
                            s3_ = s3_.next_;
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                        ConstructWithForeignArg1Data s4_ = this.constructWithForeignArg1_cache;
                        if (s4_ != null) {
                            if ((ConstructArrayNode.isOneForeignArg(arguments1Value__))) {
                                return this.constructWithForeignArg1Boundary(state_0, s4_, arguments0Value__, arguments1Value__);
                            }
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 constructArrayVarargs(DynamicObject, Object[], BranchProfile, BranchProfile, BranchProfile, ConditionProfile) */) {
                        ConstructArrayVarargsData s5_ = this.constructArrayVarargs_cache;
                        if (s5_ != null) {
                            if ((!(ConstructArrayNode.isOneNumberArg(arguments1Value__))) && (!(ConstructArrayNode.isOneForeignArg(arguments1Value__)))) {
                                return constructArrayVarargs(arguments0Value__, arguments1Value__, s5_.isIntegerCase_, s5_.isDoubleCase_, s5_.isObjectCase_, s5_.isLengthZero_);
                            }
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object constructWithForeignArg1Boundary(int state_0, ConstructWithForeignArg1Data s4_, DynamicObject arguments0Value__, Object[] arguments1Value__) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(ConstructArrayNode.firstArg(arguments1Value__)));
                    return constructWithForeignArg(arguments0Value__, arguments1Value__, interop__, s4_.arrayCreateNode_, s4_.isNumber_, s4_.rangeErrorProfile_);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Object[]) {
                        Object[] arguments1Value_ = (Object[]) arguments1Value;
                        if ((arguments1Value_.length == 0)) {
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructArray0(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructArray0(arguments0Value_, arguments1Value_);
                        }
                        if (((exclude & 0b1)) == 0 /* is-not-exclude constructArrayWithIntLength(DynamicObject, Object[]) */) {
                            if ((ConstructArrayNode.isOneIntegerArg(arguments1Value_))) {
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructArrayWithIntLength(DynamicObject, Object[]) */;
                                lock.unlock();
                                hasLock = false;
                                return constructArrayWithIntLength(arguments0Value_, arguments1Value_);
                            }
                        }
                        {
                            long len__ = 0L;
                            if ((arguments1Value_.length == 1)) {
                                int count2_ = 0;
                                ConstructWithLengthData s2_ = this.constructWithLength_cache;
                                if ((state_0 & 0b100) != 0 /* is-state_0 constructWithLength(DynamicObject, Object[], ToArrayLengthNode, ArrayCreateNode, long) */) {
                                    while (s2_ != null) {
                                        {
                                            len__ = (s2_.toArrayLengthNode_.executeLong(ConstructArrayNode.firstArg(arguments1Value_)));
                                            if ((s2_.toArrayLengthNode_.isTypeNumber(len__))) {
                                                break;
                                            }
                                        }
                                        s2_ = s2_.next_;
                                        count2_++;
                                    }
                                }
                                if (s2_ == null) {
                                    {
                                        ToArrayLengthNode toArrayLengthNode__ = super.insert((ToArrayLengthNode.create()));
                                        len__ = (toArrayLengthNode__.executeLong(ConstructArrayNode.firstArg(arguments1Value_)));
                                        if ((toArrayLengthNode__.isTypeNumber(len__)) && count2_ < (3)) {
                                            s2_ = super.insert(new ConstructWithLengthData(constructWithLength_cache));
                                            s2_.toArrayLengthNode_ = s2_.insertAccessor(toArrayLengthNode__);
                                            s2_.arrayCreateNode_ = s2_.insertAccessor((ArrayCreateNode.create(getContext())));
                                            MemoryFence.storeStore();
                                            this.constructWithLength_cache = s2_;
                                            this.exclude_ = exclude = exclude | 0b1 /* add-exclude constructArrayWithIntLength(DynamicObject, Object[]) */;
                                            state_0 = state_0 & 0xfffffffd /* remove-state_0 constructArrayWithIntLength(DynamicObject, Object[]) */;
                                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 constructWithLength(DynamicObject, Object[], ToArrayLengthNode, ArrayCreateNode, long) */;
                                        }
                                    }
                                }
                                if (s2_ != null) {
                                    lock.unlock();
                                    hasLock = false;
                                    return constructWithLength(arguments0Value_, arguments1Value_, s2_.toArrayLengthNode_, s2_.arrayCreateNode_, len__);
                                }
                            }
                        }
                        if (((exclude & 0b10)) == 0 /* is-not-exclude constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                            int count3_ = 0;
                            ConstructWithForeignArg0Data s3_ = this.constructWithForeignArg0_cache;
                            if ((state_0 & 0b1000) != 0 /* is-state_0 constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                                while (s3_ != null) {
                                    if ((s3_.interop_.accepts(ConstructArrayNode.firstArg(arguments1Value_))) && (ConstructArrayNode.isOneForeignArg(arguments1Value_))) {
                                        break;
                                    }
                                    s3_ = s3_.next_;
                                    count3_++;
                                }
                            }
                            if (s3_ == null) {
                                if ((ConstructArrayNode.isOneForeignArg(arguments1Value_)) && count3_ < (JSConfig.InteropLibraryLimit)) {
                                    // assert (s3_.interop_.accepts(ConstructArrayNode.firstArg(arguments1Value_)));
                                    s3_ = super.insert(new ConstructWithForeignArg0Data(constructWithForeignArg0_cache));
                                    s3_.interop_ = s3_.insertAccessor((INTEROP_LIBRARY_.create(ConstructArrayNode.firstArg(arguments1Value_))));
                                    s3_.arrayCreateNode_ = s3_.insertAccessor((ArrayCreateNode.create(getContext())));
                                    s3_.isNumber_ = (ConditionProfile.createBinaryProfile());
                                    s3_.rangeErrorProfile_ = (BranchProfile.create());
                                    MemoryFence.storeStore();
                                    this.constructWithForeignArg0_cache = s3_;
                                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */;
                                }
                            }
                            if (s3_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return constructWithForeignArg(arguments0Value_, arguments1Value_, s3_.interop_, s3_.arrayCreateNode_, s3_.isNumber_, s3_.rangeErrorProfile_);
                            }
                        }
                        {
                            InteropLibrary interop__ = null;
                            {
                                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                                Node prev_ = encapsulating_.set(this);
                                try {
                                    if ((ConstructArrayNode.isOneForeignArg(arguments1Value_))) {
                                        ConstructWithForeignArg1Data s4_ = super.insert(new ConstructWithForeignArg1Data());
                                        interop__ = (INTEROP_LIBRARY_.getUncached(ConstructArrayNode.firstArg(arguments1Value_)));
                                        s4_.arrayCreateNode_ = s4_.insertAccessor((ArrayCreateNode.create(getContext())));
                                        s4_.isNumber_ = (ConditionProfile.createBinaryProfile());
                                        s4_.rangeErrorProfile_ = (BranchProfile.create());
                                        MemoryFence.storeStore();
                                        this.constructWithForeignArg1_cache = s4_;
                                        this.exclude_ = exclude = exclude | 0b10 /* add-exclude constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */;
                                        this.constructWithForeignArg0_cache = null;
                                        state_0 = state_0 & 0xfffffff7 /* remove-state_0 constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */;
                                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */;
                                        lock.unlock();
                                        hasLock = false;
                                        return constructWithForeignArg(arguments0Value_, arguments1Value_, interop__, s4_.arrayCreateNode_, s4_.isNumber_, s4_.rangeErrorProfile_);
                                    }
                                } finally {
                                    encapsulating_.set(prev_);
                                }
                            }
                        }
                        if ((!(ConstructArrayNode.isOneNumberArg(arguments1Value_))) && (!(ConstructArrayNode.isOneForeignArg(arguments1Value_)))) {
                            ConstructArrayVarargsData s5_ = new ConstructArrayVarargsData();
                            s5_.isIntegerCase_ = (BranchProfile.create());
                            s5_.isDoubleCase_ = (BranchProfile.create());
                            s5_.isObjectCase_ = (BranchProfile.create());
                            s5_.isLengthZero_ = (ConditionProfile.createBinaryProfile());
                            MemoryFence.storeStore();
                            this.constructArrayVarargs_cache = s5_;
                            this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 constructArrayVarargs(DynamicObject, Object[], BranchProfile, BranchProfile, BranchProfile, ConditionProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return constructArrayVarargs(arguments0Value_, arguments1Value_, s5_.isIntegerCase_, s5_.isDoubleCase_, s5_.isObjectCase_, s5_.isLengthZero_);
                        }
                    }
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
                    ConstructWithLengthData s2_ = this.constructWithLength_cache;
                    ConstructWithForeignArg0Data s3_ = this.constructWithForeignArg0_cache;
                    if ((s2_ == null || s2_.next_ == null) && (s3_ == null || s3_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
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
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "constructArray0";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructArray0(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructArrayWithIntLength";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructArrayWithIntLength(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b1) != 0 /* is-exclude constructArrayWithIntLength(DynamicObject, Object[]) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "constructWithLength";
            if ((state_0 & 0b100) != 0 /* is-state_0 constructWithLength(DynamicObject, Object[], ToArrayLengthNode, ArrayCreateNode, long) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructWithLengthData s2_ = this.constructWithLength_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.toArrayLengthNode_, s2_.arrayCreateNode_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "constructWithForeignArg";
            if ((state_0 & 0b1000) != 0 /* is-state_0 constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructWithForeignArg0Data s3_ = this.constructWithForeignArg0_cache;
                while (s3_ != null) {
                    cached.add(Arrays.asList(s3_.interop_, s3_.arrayCreateNode_, s3_.isNumber_, s3_.rangeErrorProfile_));
                    s3_ = s3_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b10) != 0 /* is-exclude constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "constructWithForeignArg";
            if ((state_0 & 0b10000) != 0 /* is-state_0 constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructWithForeignArg1Data s4_ = this.constructWithForeignArg1_cache;
                if (s4_ != null) {
                    cached.add(Arrays.asList(s4_.arrayCreateNode_, s4_.isNumber_, s4_.rangeErrorProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "constructArrayVarargs";
            if ((state_0 & 0b100000) != 0 /* is-state_0 constructArrayVarargs(DynamicObject, Object[], BranchProfile, BranchProfile, BranchProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructArrayVarargsData s5_ = this.constructArrayVarargs_cache;
                if (s5_ != null) {
                    cached.add(Arrays.asList(s5_.isIntegerCase_, s5_.isDoubleCase_, s5_.isObjectCase_, s5_.isLengthZero_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            return Provider.create(data);
        }

        public static ConstructArrayNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructArrayNodeGen(context, builtin, isNewTargetCase, arguments);
        }

        @GeneratedBy(ConstructArrayNode.class)
        private static final class ConstructWithLengthData extends Node {

            @Child ConstructWithLengthData next_;
            @Child ToArrayLengthNode toArrayLengthNode_;
            @Child ArrayCreateNode arrayCreateNode_;

            ConstructWithLengthData(ConstructWithLengthData next_) {
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
        @GeneratedBy(ConstructArrayNode.class)
        private static final class ConstructWithForeignArg0Data extends Node {

            @Child ConstructWithForeignArg0Data next_;
            @Child InteropLibrary interop_;
            @Child ArrayCreateNode arrayCreateNode_;
            @CompilationFinal ConditionProfile isNumber_;
            @CompilationFinal BranchProfile rangeErrorProfile_;

            ConstructWithForeignArg0Data(ConstructWithForeignArg0Data next_) {
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
        @GeneratedBy(ConstructArrayNode.class)
        private static final class ConstructWithForeignArg1Data extends Node {

            @Child ArrayCreateNode arrayCreateNode_;
            @CompilationFinal ConditionProfile isNumber_;
            @CompilationFinal BranchProfile rangeErrorProfile_;

            ConstructWithForeignArg1Data() {
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
        @GeneratedBy(ConstructArrayNode.class)
        private static final class ConstructArrayVarargsData {

            @CompilationFinal BranchProfile isIntegerCase_;
            @CompilationFinal BranchProfile isDoubleCase_;
            @CompilationFinal BranchProfile isObjectCase_;
            @CompilationFinal ConditionProfile isLengthZero_;

            ConstructArrayVarargsData() {
            }

        }
    }
    @GeneratedBy(CallBooleanNode.class)
    public static final class CallBooleanNodeGen extends CallBooleanNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToBooleanNode toBoolean_;

        private CallBooleanNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 callBoolean(Object, JSToBooleanNode) */) {
                return callBoolean(arguments0Value_, this.toBoolean_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 callBoolean(Object, JSToBooleanNode) */) {
                return callBoolean(arguments0Value_, this.toBoolean_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                this.toBoolean_ = super.insert((JSToBooleanNode.create()));
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 callBoolean(Object, JSToBooleanNode) */;
                lock.unlock();
                hasLock = false;
                return callBoolean(arguments0Value, this.toBoolean_);
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
            s[0] = "callBoolean";
            if (state_0 != 0 /* is-state_0 callBoolean(Object, JSToBooleanNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toBoolean_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static CallBooleanNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallBooleanNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructBooleanNode.class)
    public static final class ConstructBooleanNodeGen extends ConstructBooleanNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToBooleanNode toBoolean_;

        private ConstructBooleanNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructBoolean(DynamicObject, Object, JSToBooleanNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructBoolean(arguments0Value__, arguments1Value_, this.toBoolean_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    this.toBoolean_ = super.insert((JSToBooleanNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructBoolean(DynamicObject, Object, JSToBooleanNode) */;
                    lock.unlock();
                    hasLock = false;
                    return constructBoolean(arguments0Value_, arguments1Value, this.toBoolean_);
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
            s[0] = "constructBoolean";
            if (state_0 != 0 /* is-state_0 constructBoolean(DynamicObject, Object, JSToBooleanNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toBoolean_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructBooleanNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructBooleanNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(CallDateNode.class)
    public static final class CallDateNodeGen extends CallDateNode implements Introspection.Provider {

        private CallDateNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return callDate();
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
            s[0] = "callDate";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static CallDateNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallDateNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructDateNode.class)
    public static final class ConstructDateNodeGen extends ConstructDateNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private ConditionProfile constructDateOne_isSpecialCase_;
        @Child private InteropLibrary constructDateOne_interop_;

        private ConstructDateNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructDateZero(DynamicObject, Object[]) || constructDateOne(DynamicObject, Object[], ConditionProfile, InteropLibrary) || constructDateMult(DynamicObject, Object[]) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 constructDateZero(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length == 0)) {
                            return constructDateZero(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 constructDateOne(DynamicObject, Object[], ConditionProfile, InteropLibrary) */) {
                        if ((arguments1Value__.length == 1)) {
                            return constructDateOne(arguments0Value__, arguments1Value__, this.constructDateOne_isSpecialCase_, this.constructDateOne_interop_);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 constructDateMult(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length >= 2)) {
                            return constructDateMult(arguments0Value__, arguments1Value__);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Object[]) {
                        Object[] arguments1Value_ = (Object[]) arguments1Value;
                        if ((arguments1Value_.length == 0)) {
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructDateZero(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructDateZero(arguments0Value_, arguments1Value_);
                        }
                        if ((arguments1Value_.length == 1)) {
                            this.constructDateOne_isSpecialCase_ = (ConditionProfile.createBinaryProfile());
                            this.constructDateOne_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructDateOne(DynamicObject, Object[], ConditionProfile, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return constructDateOne(arguments0Value_, arguments1Value_, this.constructDateOne_isSpecialCase_, this.constructDateOne_interop_);
                        }
                        if ((arguments1Value_.length >= 2)) {
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 constructDateMult(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructDateMult(arguments0Value_, arguments1Value_);
                        }
                    }
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "constructDateZero";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructDateZero(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructDateOne";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructDateOne(DynamicObject, Object[], ConditionProfile, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructDateOne_isSpecialCase_, this.constructDateOne_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "constructDateMult";
            if ((state_0 & 0b100) != 0 /* is-state_0 constructDateMult(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static ConstructDateNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructDateNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructRegExpNode.class)
    public static final class ConstructRegExpNodeGen extends ConstructRegExpNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private IsRegExpNode isRegExpNode_;

        private ConstructRegExpNodeGen(JSContext context, JSBuiltin builtin, boolean isCall, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isCall, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructRegExp(DynamicObject, Object, Object, IsRegExpNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructRegExp(arguments0Value__, arguments1Value_, arguments2Value_, this.isRegExpNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    this.isRegExpNode_ = super.insert((IsRegExpNode.create(getContext())));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructRegExp(DynamicObject, Object, Object, IsRegExpNode) */;
                    lock.unlock();
                    hasLock = false;
                    return constructRegExp(arguments0Value_, arguments1Value, arguments2Value, this.isRegExpNode_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructRegExp";
            if (state_0 != 0 /* is-state_0 constructRegExp(DynamicObject, Object, Object, IsRegExpNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isRegExpNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructRegExpNode create(JSContext context, JSBuiltin builtin, boolean isCall, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructRegExpNodeGen(context, builtin, isCall, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(CallStringNode.class)
    public static final class CallStringNodeGen extends CallStringNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToStringNode callStringGeneric_toStringNode_;

        private CallStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 callStringInt0(Object[]) || callStringGeneric(Object[], JSToStringNode) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 callStringInt0(Object[]) */) {
                    if ((arguments0Value__.length == 0)) {
                        return callStringInt0(arguments0Value__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 callStringGeneric(Object[], JSToStringNode) */) {
                    if ((arguments0Value__.length != 0)) {
                        return callStringGeneric(arguments0Value__, this.callStringGeneric_toStringNode_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arguments0Value instanceof Object[]) {
                    Object[] arguments0Value_ = (Object[]) arguments0Value;
                    if ((arguments0Value_.length == 0)) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 callStringInt0(Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return callStringInt0(arguments0Value_);
                    }
                    if ((arguments0Value_.length != 0)) {
                        this.callStringGeneric_toStringNode_ = super.insert((JSToStringNode.createSymbolToString()));
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 callStringGeneric(Object[], JSToStringNode) */;
                        lock.unlock();
                        hasLock = false;
                        return callStringGeneric(arguments0Value_, this.callStringGeneric_toStringNode_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "callStringInt0";
            if ((state_0 & 0b1) != 0 /* is-state_0 callStringInt0(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "callStringGeneric";
            if ((state_0 & 0b10) != 0 /* is-state_0 callStringGeneric(Object[], JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.callStringGeneric_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static CallStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructStringNode.class)
    public static final class ConstructStringNodeGen extends ConstructStringNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToStringNode constructString_toStringNode_;

        private ConstructStringNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructStringInt0(DynamicObject, Object[]) || constructString(DynamicObject, Object[], JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 constructStringInt0(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length == 0)) {
                            return constructStringInt0(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 constructString(DynamicObject, Object[], JSToStringNode) */) {
                        if ((arguments1Value__.length != 0)) {
                            return constructString(arguments0Value__, arguments1Value__, this.constructString_toStringNode_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Object[]) {
                        Object[] arguments1Value_ = (Object[]) arguments1Value;
                        if ((arguments1Value_.length == 0)) {
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructStringInt0(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructStringInt0(arguments0Value_, arguments1Value_);
                        }
                        if ((arguments1Value_.length != 0)) {
                            this.constructString_toStringNode_ = super.insert((JSToStringNode.create()));
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructString(DynamicObject, Object[], JSToStringNode) */;
                            lock.unlock();
                            hasLock = false;
                            return constructString(arguments0Value_, arguments1Value_, this.constructString_toStringNode_);
                        }
                    }
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
            s[0] = "constructStringInt0";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructStringInt0(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructString";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructString(DynamicObject, Object[], JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructString_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructStringNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructStringNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructWeakRefNode.class)
    public static final class ConstructWeakRefNodeGen extends ConstructWeakRefNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private ConstructWeakRefNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructWeakRef(DynamicObject, Object) || constructWeakRefNonObject(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 constructWeakRef(DynamicObject, Object) */) {
                    if ((JSGuards.isJSObject(arguments1Value_))) {
                        return constructWeakRef(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 constructWeakRefNonObject(DynamicObject, Object) */) {
                    if ((!(JSGuards.isJSObject(arguments1Value_)))) {
                        return constructWeakRefNonObject(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSObject(arguments1Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructWeakRef(DynamicObject, Object) */;
                    return constructWeakRef(arguments0Value_, arguments1Value);
                }
                if ((!(JSGuards.isJSObject(arguments1Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructWeakRefNonObject(DynamicObject, Object) */;
                    return constructWeakRefNonObject(arguments0Value_, arguments1Value);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "constructWeakRef";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructWeakRef(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructWeakRefNonObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructWeakRefNonObject(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructWeakRefNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructWeakRefNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructFinalizationRegistryNode.class)
    public static final class ConstructFinalizationRegistryNodeGen extends ConstructFinalizationRegistryNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private ConstructFinalizationRegistryNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructFinalizationRegistry(DynamicObject, Object) || constructFinalizationRegistryNonObject(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 constructFinalizationRegistry(DynamicObject, Object) */) {
                    if ((isCallableNode.executeBoolean(arguments1Value_))) {
                        return constructFinalizationRegistry(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 constructFinalizationRegistryNonObject(DynamicObject, Object) */) {
                    if ((!(isCallableNode.executeBoolean(arguments1Value_)))) {
                        return constructFinalizationRegistryNonObject(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((isCallableNode.executeBoolean(arguments1Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructFinalizationRegistry(DynamicObject, Object) */;
                    return constructFinalizationRegistry(arguments0Value_, arguments1Value);
                }
                if ((!(isCallableNode.executeBoolean(arguments1Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructFinalizationRegistryNonObject(DynamicObject, Object) */;
                    return constructFinalizationRegistryNonObject(arguments0Value_, arguments1Value);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "constructFinalizationRegistry";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructFinalizationRegistry(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructFinalizationRegistryNonObject";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructFinalizationRegistryNonObject(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructFinalizationRegistryNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructFinalizationRegistryNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(CallCollatorNode.class)
    public static final class CallCollatorNodeGen extends CallCollatorNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private CallCollatorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return callCollator(arguments0Value_, arguments1Value_);
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
            s[0] = "callCollator";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static CallCollatorNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallCollatorNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructCollatorNode.class)
    public static final class ConstructCollatorNodeGen extends ConstructCollatorNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructCollatorNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructCollator(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructCollator(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructCollator(DynamicObject, Object, Object) */;
                return constructCollator(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructCollator";
            if (state_0 != 0 /* is-state_0 constructCollator(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructCollatorNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructCollatorNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructListFormatNode.class)
    public static final class ConstructListFormatNodeGen extends ConstructListFormatNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructListFormatNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructListFormat(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructListFormat(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructListFormat(DynamicObject, Object, Object) */;
                return constructListFormat(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructListFormat";
            if (state_0 != 0 /* is-state_0 constructListFormat(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructListFormatNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructListFormatNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructRelativeTimeFormatNode.class)
    public static final class ConstructRelativeTimeFormatNodeGen extends ConstructRelativeTimeFormatNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructRelativeTimeFormatNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructRelativeTimeFormat(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructRelativeTimeFormat(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructRelativeTimeFormat(DynamicObject, Object, Object) */;
                return constructRelativeTimeFormat(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructRelativeTimeFormat";
            if (state_0 != 0 /* is-state_0 constructRelativeTimeFormat(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructRelativeTimeFormatNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructRelativeTimeFormatNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructSegmenterNode.class)
    public static final class ConstructSegmenterNodeGen extends ConstructSegmenterNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructSegmenterNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructSegmenter(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructSegmenter(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructSegmenter(DynamicObject, Object, Object) */;
                return constructSegmenter(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructSegmenter";
            if (state_0 != 0 /* is-state_0 constructSegmenter(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructSegmenterNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructSegmenterNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructDisplayNamesNode.class)
    public static final class ConstructDisplayNamesNodeGen extends ConstructDisplayNamesNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructDisplayNamesNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructDisplayNames(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructDisplayNames(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructDisplayNames(DynamicObject, Object, Object) */;
                return constructDisplayNames(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructDisplayNames";
            if (state_0 != 0 /* is-state_0 constructDisplayNames(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructDisplayNamesNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructDisplayNamesNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructLocaleNode.class)
    public static final class ConstructLocaleNodeGen extends ConstructLocaleNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructLocaleNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructLocale(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructLocale(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructLocale(DynamicObject, Object, Object) */;
                return constructLocale(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructLocale";
            if (state_0 != 0 /* is-state_0 constructLocale(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructLocaleNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructLocaleNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(CallNumberFormatNode.class)
    public static final class CallNumberFormatNodeGen extends CallNumberFormatNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private CallNumberFormatNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return callNumberFormat(arguments0Value_, arguments1Value_);
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
            s[0] = "callNumberFormat";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static CallNumberFormatNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallNumberFormatNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructNumberFormatNode.class)
    public static final class ConstructNumberFormatNodeGen extends ConstructNumberFormatNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructNumberFormatNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructNumberFormat(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructNumberFormat(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructNumberFormat(DynamicObject, Object, Object) */;
                return constructNumberFormat(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructNumberFormat";
            if (state_0 != 0 /* is-state_0 constructNumberFormat(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructNumberFormatNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructNumberFormatNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructPluralRulesNode.class)
    public static final class ConstructPluralRulesNodeGen extends ConstructPluralRulesNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructPluralRulesNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructPluralRules(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructPluralRules(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructPluralRules(DynamicObject, Object, Object) */;
                return constructPluralRules(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructPluralRules";
            if (state_0 != 0 /* is-state_0 constructPluralRules(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructPluralRulesNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructPluralRulesNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(CallDateTimeFormatNode.class)
    public static final class CallDateTimeFormatNodeGen extends CallDateTimeFormatNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private CallDateTimeFormatNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return callDateTimeFormat(arguments0Value_, arguments1Value_);
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
            s[0] = "callDateTimeFormat";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static CallDateTimeFormatNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallDateTimeFormatNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructDateTimeFormatNode.class)
    public static final class ConstructDateTimeFormatNodeGen extends ConstructDateTimeFormatNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructDateTimeFormatNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructDateTimeFormat(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructDateTimeFormat(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructDateTimeFormat(DynamicObject, Object, Object) */;
                return constructDateTimeFormat(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructDateTimeFormat";
            if (state_0 != 0 /* is-state_0 constructDateTimeFormat(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructDateTimeFormatNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructDateTimeFormatNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructObjectNode.class)
    public static final class ConstructObjectNodeGen extends ConstructObjectNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private ConstructObjectJSObject0Data constructObjectJSObject0_cache;
        @Child private JSToObjectNode constructObjectJSObject1_toObjectNode_;
        @CompilationFinal private ConditionProfile constructObjectJSObject1_isNull_;

        private ConstructObjectNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructObjectNewTarget(DynamicObject, Object[]) || constructObject0(DynamicObject, Object[]) || constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) || constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) || constructObjectNullOrUndefined(DynamicObject, Object[]) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 constructObjectNewTarget(DynamicObject, Object[]) */) {
                        assert (isNewTargetCase);
                        return constructObjectNewTarget(arguments0Value__, arguments1Value__);
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 constructObject0(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length == 0)) {
                            return constructObject0(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) */) {
                        ConstructObjectJSObject0Data s2_ = this.constructObjectJSObject0_cache;
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(ConstructObjectNode.firstArgument(arguments1Value__)))) {
                                assert (!(isNewTargetCase));
                                if ((arguments1Value__.length > 0) && (!(ConstructObjectNode.arg0NullOrUndefined(arguments1Value__)))) {
                                    return constructObjectJSObject(arguments0Value__, arguments1Value__, s2_.toObjectNode_, s2_.interop_, s2_.isNull_);
                                }
                            }
                            s2_ = s2_.next_;
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) */) {
                        assert (!(isNewTargetCase));
                        if ((arguments1Value__.length > 0) && (!(ConstructObjectNode.arg0NullOrUndefined(arguments1Value__)))) {
                            return this.constructObjectJSObject1Boundary(state_0, arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 constructObjectNullOrUndefined(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length > 0) && (ConstructObjectNode.arg0NullOrUndefined(arguments1Value__))) {
                            return constructObjectNullOrUndefined(arguments0Value__, arguments1Value__);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @SuppressWarnings("static-method")
        @TruffleBoundary
        private Object constructObjectJSObject1Boundary(int state_0, DynamicObject arguments0Value__, Object[] arguments1Value__) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary constructObjectJSObject1_interop__ = (INTEROP_LIBRARY_.getUncached(ConstructObjectNode.firstArgument(arguments1Value__)));
                    return constructObjectJSObject(arguments0Value__, arguments1Value__, this.constructObjectJSObject1_toObjectNode_, constructObjectJSObject1_interop__, this.constructObjectJSObject1_isNull_);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Object[]) {
                        Object[] arguments1Value_ = (Object[]) arguments1Value;
                        if ((isNewTargetCase)) {
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructObjectNewTarget(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructObjectNewTarget(arguments0Value_, arguments1Value_);
                        }
                        if ((arguments1Value_.length == 0)) {
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructObject0(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructObject0(arguments0Value_, arguments1Value_);
                        }
                        if ((exclude) == 0 /* is-not-exclude constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) */) {
                            int count2_ = 0;
                            ConstructObjectJSObject0Data s2_ = this.constructObjectJSObject0_cache;
                            if ((state_0 & 0b100) != 0 /* is-state_0 constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) */) {
                                while (s2_ != null) {
                                    if ((s2_.interop_.accepts(ConstructObjectNode.firstArgument(arguments1Value_)))) {
                                        assert (!(isNewTargetCase));
                                        if ((arguments1Value_.length > 0) && (!(ConstructObjectNode.arg0NullOrUndefined(arguments1Value_)))) {
                                            break;
                                        }
                                    }
                                    s2_ = s2_.next_;
                                    count2_++;
                                }
                            }
                            if (s2_ == null) {
                                if ((!(isNewTargetCase)) && (arguments1Value_.length > 0) && (!(ConstructObjectNode.arg0NullOrUndefined(arguments1Value_))) && count2_ < (JSConfig.InteropLibraryLimit)) {
                                    // assert (s2_.interop_.accepts(ConstructObjectNode.firstArgument(arguments1Value_)));
                                    s2_ = super.insert(new ConstructObjectJSObject0Data(constructObjectJSObject0_cache));
                                    s2_.toObjectNode_ = s2_.insertAccessor((JSToObjectNode.createToObject(getContext())));
                                    s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(ConstructObjectNode.firstArgument(arguments1Value_))));
                                    s2_.isNull_ = (ConditionProfile.createBinaryProfile());
                                    MemoryFence.storeStore();
                                    this.constructObjectJSObject0_cache = s2_;
                                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) */;
                                }
                            }
                            if (s2_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return constructObjectJSObject(arguments0Value_, arguments1Value_, s2_.toObjectNode_, s2_.interop_, s2_.isNull_);
                            }
                        }
                        {
                            InteropLibrary constructObjectJSObject1_interop__ = null;
                            {
                                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                                Node prev_ = encapsulating_.set(this);
                                try {
                                    if ((!(isNewTargetCase)) && (arguments1Value_.length > 0) && (!(ConstructObjectNode.arg0NullOrUndefined(arguments1Value_)))) {
                                        this.constructObjectJSObject1_toObjectNode_ = super.insert((JSToObjectNode.createToObject(getContext())));
                                        constructObjectJSObject1_interop__ = (INTEROP_LIBRARY_.getUncached(ConstructObjectNode.firstArgument(arguments1Value_)));
                                        this.constructObjectJSObject1_isNull_ = (ConditionProfile.createBinaryProfile());
                                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) */;
                                        this.constructObjectJSObject0_cache = null;
                                        state_0 = state_0 & 0xfffffffb /* remove-state_0 constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) */;
                                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) */;
                                        lock.unlock();
                                        hasLock = false;
                                        return constructObjectJSObject(arguments0Value_, arguments1Value_, this.constructObjectJSObject1_toObjectNode_, constructObjectJSObject1_interop__, this.constructObjectJSObject1_isNull_);
                                    }
                                } finally {
                                    encapsulating_.set(prev_);
                                }
                            }
                        }
                        if ((arguments1Value_.length > 0) && (ConstructObjectNode.arg0NullOrUndefined(arguments1Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 constructObjectNullOrUndefined(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructObjectNullOrUndefined(arguments0Value_, arguments1Value_);
                        }
                    }
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
                    ConstructObjectJSObject0Data s2_ = this.constructObjectJSObject0_cache;
                    if ((s2_ == null || s2_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[6];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "constructObjectNewTarget";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructObjectNewTarget(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructObject0";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructObject0(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "constructObjectJSObject";
            if ((state_0 & 0b100) != 0 /* is-state_0 constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructObjectJSObject0Data s2_ = this.constructObjectJSObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.toObjectNode_, s2_.interop_, s2_.isNull_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "constructObjectJSObject";
            if ((state_0 & 0b1000) != 0 /* is-state_0 constructObjectJSObject(DynamicObject, Object[], JSToObjectNode, InteropLibrary, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructObjectJSObject1_toObjectNode_, this.constructObjectJSObject1_isNull_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "constructObjectNullOrUndefined";
            if ((state_0 & 0b10000) != 0 /* is-state_0 constructObjectNullOrUndefined(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static ConstructObjectNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructObjectNodeGen(context, builtin, isNewTargetCase, arguments);
        }

        @GeneratedBy(ConstructObjectNode.class)
        private static final class ConstructObjectJSObject0Data extends Node {

            @Child ConstructObjectJSObject0Data next_;
            @Child JSToObjectNode toObjectNode_;
            @Child InteropLibrary interop_;
            @CompilationFinal ConditionProfile isNull_;

            ConstructObjectJSObject0Data(ConstructObjectJSObject0Data next_) {
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
    @GeneratedBy(CallNumberNode.class)
    public static final class CallNumberNodeGen extends CallNumberNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToNumericNode callNumber_toNumericNode_;
        @Child private JSNumericToNumberNode callNumber_toNumberFromNumericNode_;

        private CallNumberNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 callNumberZero(Object[]) || callNumber(Object[], JSToNumericNode, JSNumericToNumberNode) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 callNumberZero(Object[]) */) {
                    if ((arguments0Value__.length == 0)) {
                        return callNumberZero(arguments0Value__);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 callNumber(Object[], JSToNumericNode, JSNumericToNumberNode) */) {
                    if ((arguments0Value__.length > 0)) {
                        return callNumber(arguments0Value__, this.callNumber_toNumericNode_, this.callNumber_toNumberFromNumericNode_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b10) != 0 /* is-state_0 callNumber(Object[], JSToNumericNode, JSNumericToNumberNode) */) {
                return JSTypesGen.expectInteger(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 callNumberZero(Object[]) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                if ((arguments0Value__.length == 0)) {
                    return callNumberZero(arguments0Value__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            try {
                if ((state_0 & 0b10) == 0 /* only-active callNumberZero(Object[]) */ && (state_0 != 0  /* is-not callNumberZero(Object[]) && callNumber(Object[], JSToNumericNode, JSNumericToNumberNode) */)) {
                    executeInt(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arguments0Value instanceof Object[]) {
                    Object[] arguments0Value_ = (Object[]) arguments0Value;
                    if ((arguments0Value_.length == 0)) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 callNumberZero(Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return callNumberZero(arguments0Value_);
                    }
                    if ((arguments0Value_.length > 0)) {
                        this.callNumber_toNumericNode_ = super.insert((JSToNumericNode.create()));
                        this.callNumber_toNumberFromNumericNode_ = super.insert((JSNumericToNumberNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 callNumber(Object[], JSToNumericNode, JSNumericToNumberNode) */;
                        lock.unlock();
                        hasLock = false;
                        return callNumber(arguments0Value_, this.callNumber_toNumericNode_, this.callNumber_toNumberFromNumericNode_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "callNumberZero";
            if ((state_0 & 0b1) != 0 /* is-state_0 callNumberZero(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "callNumber";
            if ((state_0 & 0b10) != 0 /* is-state_0 callNumber(Object[], JSToNumericNode, JSNumericToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.callNumber_toNumericNode_, this.callNumber_toNumberFromNumericNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static CallNumberNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallNumberNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructNumberNode.class)
    public static final class ConstructNumberNodeGen extends ConstructNumberNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToNumericNode constructNumber_toNumericNode_;
        @Child private JSNumericToNumberNode constructNumber_toNumberFromNumericNode_;

        private ConstructNumberNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructNumberZero(DynamicObject, Object[]) || constructNumber(DynamicObject, Object[], JSToNumericNode, JSNumericToNumberNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 constructNumberZero(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length == 0)) {
                            return constructNumberZero(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 constructNumber(DynamicObject, Object[], JSToNumericNode, JSNumericToNumberNode) */) {
                        if ((arguments1Value__.length > 0)) {
                            return constructNumber(arguments0Value__, arguments1Value__, this.constructNumber_toNumericNode_, this.constructNumber_toNumberFromNumericNode_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Object[]) {
                        Object[] arguments1Value_ = (Object[]) arguments1Value;
                        if ((arguments1Value_.length == 0)) {
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructNumberZero(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructNumberZero(arguments0Value_, arguments1Value_);
                        }
                        if ((arguments1Value_.length > 0)) {
                            this.constructNumber_toNumericNode_ = super.insert((JSToNumericNode.create()));
                            this.constructNumber_toNumberFromNumericNode_ = super.insert((JSNumericToNumberNode.create()));
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructNumber(DynamicObject, Object[], JSToNumericNode, JSNumericToNumberNode) */;
                            lock.unlock();
                            hasLock = false;
                            return constructNumber(arguments0Value_, arguments1Value_, this.constructNumber_toNumericNode_, this.constructNumber_toNumberFromNumericNode_);
                        }
                    }
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
            s[0] = "constructNumberZero";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructNumberZero(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructNumber";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructNumber(DynamicObject, Object[], JSToNumericNode, JSNumericToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructNumber_toNumericNode_, this.constructNumber_toNumberFromNumericNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructNumberNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructNumberNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(CallBigIntNode.class)
    public static final class CallBigIntNodeGen extends CallBigIntNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSNumberToBigIntNode callBigInt_numberToBigIntNode_;
        @Child private JSToBigIntNode callBigInt_toBigIntNode_;

        private CallBigIntNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b10) != 0 /* is-state_0 callBigInt(Object[], JSNumberToBigIntNode, JSToBigIntNode) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                if ((arguments0Value__.length > 0)) {
                    return callBigInt(arguments0Value__, this.callBigInt_numberToBigIntNode_, this.callBigInt_toBigIntNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b10) != 0 /* is-state_0 callBigInt(Object[], JSNumberToBigIntNode, JSToBigIntNode) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 callBigIntZero(Object[]) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                if ((arguments0Value__.length == 0)) {
                    callBigIntZero(arguments0Value__);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arguments0Value instanceof Object[]) {
                    Object[] arguments0Value_ = (Object[]) arguments0Value;
                    if ((arguments0Value_.length == 0)) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 callBigIntZero(Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        callBigIntZero(arguments0Value_);
                        return null;
                    }
                    if ((arguments0Value_.length > 0)) {
                        this.callBigInt_numberToBigIntNode_ = super.insert((JSNumberToBigIntNode.create()));
                        this.callBigInt_toBigIntNode_ = super.insert((JSToBigIntNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 callBigInt(Object[], JSNumberToBigIntNode, JSToBigIntNode) */;
                        lock.unlock();
                        hasLock = false;
                        return callBigInt(arguments0Value_, this.callBigInt_numberToBigIntNode_, this.callBigInt_toBigIntNode_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "callBigIntZero";
            if ((state_0 & 0b1) != 0 /* is-state_0 callBigIntZero(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "callBigInt";
            if ((state_0 & 0b10) != 0 /* is-state_0 callBigInt(Object[], JSNumberToBigIntNode, JSToBigIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.callBigInt_numberToBigIntNode_, this.callBigInt_toBigIntNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static CallBigIntNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallBigIntNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructBigIntNode.class)
    public static final class ConstructBigIntNodeGen extends ConstructBigIntNode implements Introspection.Provider {

        private ConstructBigIntNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return ConstructBigIntNode.construct();
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
            s[0] = "construct";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructBigIntNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ConstructBigIntNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructFunctionNode.class)
    public static final class ConstructFunctionNodeGen extends ConstructFunctionNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private ConditionProfile hasArgsProfile_;
        @CompilationFinal private ConditionProfile hasParamsProfile_;

        private ConstructFunctionNodeGen(JSContext context, JSBuiltin builtin, boolean generatorFunction, boolean asyncFunction, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, generatorFunction, asyncFunction, isNewTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructFunction(DynamicObject, Object[], ConditionProfile, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    return constructFunction(arguments0Value__, arguments1Value__, this.hasArgsProfile_, this.hasParamsProfile_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Object[]) {
                        Object[] arguments1Value_ = (Object[]) arguments1Value;
                        this.hasArgsProfile_ = (ConditionProfile.createBinaryProfile());
                        this.hasParamsProfile_ = (ConditionProfile.createBinaryProfile());
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructFunction(DynamicObject, Object[], ConditionProfile, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return constructFunction(arguments0Value_, arguments1Value_, this.hasArgsProfile_, this.hasParamsProfile_);
                    }
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
            s[0] = "constructFunction";
            if (state_0 != 0 /* is-state_0 constructFunction(DynamicObject, Object[], ConditionProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.hasArgsProfile_, this.hasParamsProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructFunctionNode create(JSContext context, JSBuiltin builtin, boolean generatorFunction, boolean asyncFunction, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructFunctionNodeGen(context, builtin, generatorFunction, asyncFunction, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(CreateDynamicFunctionNode.class)
    static final class CreateDynamicFunctionNodeGen extends CreateDynamicFunctionNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;
        @CompilationFinal private LRUCache<CachedSourceKey, ScriptNode> uncached_cache_;
        @CompilationFinal private ConditionProfile uncached_cacheHit_;

        private CreateDynamicFunctionNodeGen(JSContext context, boolean generatorFunction, boolean asyncFunction) {
            super(context, generatorFunction, asyncFunction);
        }

        @Override
        protected DynamicObject executeFunction(String arg0Value, String arg1Value, String arg2Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b11) != 0 /* is-state_0 doCached(String, String, String, String, String, String, AssumedValue<ScriptNode>) || doUncached(String, String, String, LRUCache<CachedSourceKey, ScriptNode>, ConditionProfile) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(String, String, String, String, String, String, AssumedValue<ScriptNode>) */) {
                    CachedData s0_ = this.cached_cache;
                    if (s0_ != null) {
                        if ((CreateDynamicFunctionNode.equals(s0_.cachedParamList_, arg0Value)) && (CreateDynamicFunctionNode.equals(s0_.cachedBody_, arg1Value)) && (CreateDynamicFunctionNode.equals(s0_.cachedSourceName_, arg2Value))) {
                            return doCached(arg0Value, arg1Value, arg2Value, s0_.cachedParamList_, s0_.cachedBody_, s0_.cachedSourceName_, s0_.cachedParsedFunction_);
                        }
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(String, String, String, LRUCache<CachedSourceKey, ScriptNode>, ConditionProfile) */) {
                    return doUncached(arg0Value, arg1Value, arg2Value, this.uncached_cache_, this.uncached_cacheHit_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private DynamicObject executeAndSpecialize(String arg0Value, String arg1Value, String arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(String, String, String, String, String, String, AssumedValue<ScriptNode>) */) {
                    CachedData s0_ = this.cached_cache;
                    boolean Cached_duplicateFound_ = false;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(String, String, String, String, String, String, AssumedValue<ScriptNode>) */) {
                        if ((CreateDynamicFunctionNode.equals(s0_.cachedParamList_, arg0Value)) && (CreateDynamicFunctionNode.equals(s0_.cachedBody_, arg1Value)) && (CreateDynamicFunctionNode.equals(s0_.cachedSourceName_, arg2Value))) {
                            Cached_duplicateFound_ = true;
                        }
                    }
                    if (!Cached_duplicateFound_) {
                        {
                            String cachedParamList__ = (arg0Value);
                            if ((CreateDynamicFunctionNode.equals(cachedParamList__, arg0Value))) {
                                String cachedBody__ = (arg1Value);
                                if ((CreateDynamicFunctionNode.equals(cachedBody__, arg1Value))) {
                                    String cachedSourceName__ = (arg2Value);
                                    if ((CreateDynamicFunctionNode.equals(cachedSourceName__, arg2Value)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 doCached(String, String, String, String, String, String, AssumedValue<ScriptNode>) */) {
                                        s0_ = new CachedData();
                                        s0_.cachedParamList_ = cachedParamList__;
                                        s0_.cachedBody_ = cachedBody__;
                                        s0_.cachedSourceName_ = cachedSourceName__;
                                        s0_.cachedParsedFunction_ = (createAssumedValue());
                                        MemoryFence.storeStore();
                                        this.cached_cache = s0_;
                                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(String, String, String, String, String, String, AssumedValue<ScriptNode>) */;
                                        Cached_duplicateFound_ = true;
                                    }
                                }
                            }
                        }
                    }
                    if (Cached_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value, arg1Value, arg2Value, s0_.cachedParamList_, s0_.cachedBody_, s0_.cachedSourceName_, s0_.cachedParsedFunction_);
                    }
                }
                this.uncached_cache_ = (createCache());
                this.uncached_cacheHit_ = (ConditionProfile.createCountingProfile());
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(String, String, String, String, String, String, AssumedValue<ScriptNode>) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(String, String, String, String, String, String, AssumedValue<ScriptNode>) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(String, String, String, LRUCache<CachedSourceKey, ScriptNode>, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doUncached(arg0Value, arg1Value, arg2Value, this.uncached_cache_, this.uncached_cacheHit_);
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(String, String, String, String, String, String, AssumedValue<ScriptNode>) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s0_ = this.cached_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.cachedParamList_, s0_.cachedBody_, s0_.cachedSourceName_, s0_.cachedParsedFunction_));
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doCached(String, String, String, String, String, String, AssumedValue<ScriptNode>) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doUncached";
            if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(String, String, String, LRUCache<CachedSourceKey, ScriptNode>, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.uncached_cache_, this.uncached_cacheHit_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static CreateDynamicFunctionNode create(JSContext context, boolean generatorFunction, boolean asyncFunction) {
            return new CreateDynamicFunctionNodeGen(context, generatorFunction, asyncFunction);
        }

        @GeneratedBy(CreateDynamicFunctionNode.class)
        private static final class CachedData {

            @CompilationFinal String cachedParamList_;
            @CompilationFinal String cachedBody_;
            @CompilationFinal String cachedSourceName_;
            @CompilationFinal AssumedValue<ScriptNode> cachedParsedFunction_;

            CachedData() {
            }

        }
    }
    @GeneratedBy(CallTypedArrayNode.class)
    public static final class CallTypedArrayNodeGen extends CallTypedArrayNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private CallTypedArrayNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 callTypedArray(Object[]) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                return callTypedArray(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof Object[]) {
                Object[] arguments0Value_ = (Object[]) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 callTypedArray(Object[]) */;
                return callTypedArray(arguments0Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "callTypedArray";
            if (state_0 != 0 /* is-state_0 callTypedArray(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static CallTypedArrayNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallTypedArrayNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructArrayBufferNode.class)
    public static final class ConstructArrayBufferNodeGen extends ConstructArrayBufferNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private BranchProfile errorBranch;
        @Child private InteropLibrary bufferInterop;
        @Child private JSToIndexNode constructFromLength_toIndexNode_;

        private ConstructArrayBufferNodeGen(JSContext context, JSBuiltin builtin, boolean useShared, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, useShared, isNewTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructFromLength(DynamicObject, Object, JSToIndexNode, BranchProfile, InteropLibrary) || constructFromInteropBuffer(DynamicObject, Object, BranchProfile, InteropLibrary) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 constructFromLength(DynamicObject, Object, JSToIndexNode, BranchProfile, InteropLibrary) */) {
                    if ((!(this.bufferInterop.hasBufferElements(arguments1Value_)))) {
                        return constructFromLength(arguments0Value__, arguments1Value_, this.constructFromLength_toIndexNode_, this.errorBranch, this.bufferInterop);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 constructFromInteropBuffer(DynamicObject, Object, BranchProfile, InteropLibrary) */) {
                    if ((this.bufferInterop.hasBufferElements(arguments1Value_))) {
                        return constructFromInteropBuffer(arguments0Value__, arguments1Value_, this.errorBranch, this.bufferInterop);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    {
                        InteropLibrary constructFromLength_bufferInterop__ = super.insert(this.bufferInterop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.bufferInterop);
                        if ((!(constructFromLength_bufferInterop__.hasBufferElements(arguments1Value)))) {
                            this.constructFromLength_toIndexNode_ = super.insert((JSToIndexNode.create()));
                            this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                            if (this.bufferInterop == null) {
                                InteropLibrary constructFromLength_bufferInterop___check = super.insert(constructFromLength_bufferInterop__);
                                if (constructFromLength_bufferInterop___check == null) {
                                    throw new AssertionError("Specialization 'constructFromLength(DynamicObject, Object, JSToIndexNode, BranchProfile, InteropLibrary)' contains a shared cache with name 'bufferInterop' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                }
                                this.bufferInterop = constructFromLength_bufferInterop___check;
                            }
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructFromLength(DynamicObject, Object, JSToIndexNode, BranchProfile, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return constructFromLength(arguments0Value_, arguments1Value, this.constructFromLength_toIndexNode_, this.errorBranch, constructFromLength_bufferInterop__);
                        }
                    }
                    {
                        InteropLibrary constructFromInteropBuffer_bufferInterop__ = super.insert(this.bufferInterop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.bufferInterop);
                        if ((constructFromInteropBuffer_bufferInterop__.hasBufferElements(arguments1Value))) {
                            this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                            if (this.bufferInterop == null) {
                                InteropLibrary constructFromInteropBuffer_bufferInterop___check = super.insert(constructFromInteropBuffer_bufferInterop__);
                                if (constructFromInteropBuffer_bufferInterop___check == null) {
                                    throw new AssertionError("Specialization 'constructFromInteropBuffer(DynamicObject, Object, BranchProfile, InteropLibrary)' contains a shared cache with name 'bufferInterop' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                }
                                this.bufferInterop = constructFromInteropBuffer_bufferInterop___check;
                            }
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructFromInteropBuffer(DynamicObject, Object, BranchProfile, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return constructFromInteropBuffer(arguments0Value_, arguments1Value, this.errorBranch, constructFromInteropBuffer_bufferInterop__);
                        }
                    }
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
            s[0] = "constructFromLength";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructFromLength(DynamicObject, Object, JSToIndexNode, BranchProfile, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructFromLength_toIndexNode_, this.errorBranch, this.bufferInterop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructFromInteropBuffer";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructFromInteropBuffer(DynamicObject, Object, BranchProfile, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.errorBranch, this.bufferInterop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructArrayBufferNode create(JSContext context, JSBuiltin builtin, boolean useShared, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructArrayBufferNodeGen(context, builtin, useShared, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructErrorNode.class)
    public static final class ConstructErrorNodeGen extends ConstructErrorNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToStringNode constructError1_toStringNode_;

        private ConstructErrorNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state_0 & 0b11) != 0 /* is-state_0 constructError(DynamicObject, String, Object) || constructError(DynamicObject, Object, Object, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 constructError(DynamicObject, String, Object) */ && JSTypesGen.isImplicitString((state_0 & 0b11100) >>> 2 /* extract-implicit-state_0 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state_0 & 0b11100) >>> 2 /* extract-implicit-state_0 1:String */, arguments1Value_);
                    return constructError(arguments0Value__, arguments1Value__, arguments2Value_);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 constructError(DynamicObject, Object, Object, JSToStringNode) */) {
                    return constructError(arguments0Value__, arguments1Value_, arguments2Value_, this.constructError1_toStringNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            state_0 = (state_0 | (stringCast1 << 2) /* set-implicit-state_0 1:String */);
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructError(DynamicObject, String, Object) */;
                            lock.unlock();
                            hasLock = false;
                            return constructError(arguments0Value_, arguments1Value_, arguments2Value);
                        }
                    }
                    this.constructError1_toStringNode_ = super.insert((JSToStringNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructError(DynamicObject, Object, Object, JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return constructError(arguments0Value_, arguments1Value, arguments2Value, this.constructError1_toStringNode_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s = new Object[3];
            s[0] = "constructError";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructError(DynamicObject, String, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructError";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructError(DynamicObject, Object, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructError1_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructErrorNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructErrorNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructAggregateErrorNode.class)
    public static final class ConstructAggregateErrorNodeGen extends ConstructAggregateErrorNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;
        @CompilationFinal private volatile int state_0_;
        @Child private ConstructErrorData constructError_cache;

        private ConstructAggregateErrorNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
            this.arguments3_ = arguments != null && 3 < arguments.length ? arguments[3] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructError(DynamicObject, Object, Object, Object, JSToStringNode, GetMethodNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, PropertyGetNode, BranchProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                ConstructErrorData s0_ = this.constructError_cache;
                if (s0_ != null) {
                    return constructError(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, s0_.toStringNode_, s0_.getIteratorMethodNode_, s0_.iteratorCallNode_, s0_.isObjectNode_, s0_.iteratorStepNode_, s0_.getIteratorValueNode_, s0_.getNextMethodNode_, s0_.growProfile_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value, Object arguments3Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    ConstructErrorData s0_ = super.insert(new ConstructErrorData());
                    s0_.toStringNode_ = s0_.insertAccessor((JSToStringNode.create()));
                    s0_.getIteratorMethodNode_ = s0_.insertAccessor((createGetIteratorMethod()));
                    s0_.iteratorCallNode_ = s0_.insertAccessor((JSFunctionCallNode.createCall()));
                    s0_.isObjectNode_ = s0_.insertAccessor((IsJSObjectNode.create()));
                    s0_.iteratorStepNode_ = s0_.insertAccessor((IteratorStepNode.create(getContext())));
                    s0_.getIteratorValueNode_ = s0_.insertAccessor((IteratorValueNode.create(getContext())));
                    s0_.getNextMethodNode_ = s0_.insertAccessor((PropertyGetNode.create(JSRuntime.NEXT, getContext())));
                    s0_.growProfile_ = (BranchProfile.create());
                    MemoryFence.storeStore();
                    this.constructError_cache = s0_;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructError(DynamicObject, Object, Object, Object, JSToStringNode, GetMethodNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, PropertyGetNode, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return constructError(arguments0Value_, arguments1Value, arguments2Value, arguments3Value, s0_.toStringNode_, s0_.getIteratorMethodNode_, s0_.iteratorCallNode_, s0_.isObjectNode_, s0_.iteratorStepNode_, s0_.getIteratorValueNode_, s0_.getNextMethodNode_, s0_.growProfile_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_}, arguments0Value, arguments1Value, arguments2Value, arguments3Value);
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
            s[0] = "constructError";
            if (state_0 != 0 /* is-state_0 constructError(DynamicObject, Object, Object, Object, JSToStringNode, GetMethodNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, PropertyGetNode, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructErrorData s0_ = this.constructError_cache;
                if (s0_ != null) {
                    cached.add(Arrays.asList(s0_.toStringNode_, s0_.getIteratorMethodNode_, s0_.iteratorCallNode_, s0_.isObjectNode_, s0_.iteratorStepNode_, s0_.getIteratorValueNode_, s0_.getNextMethodNode_, s0_.growProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructAggregateErrorNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructAggregateErrorNodeGen(context, builtin, isNewTargetCase, arguments);
        }

        @GeneratedBy(ConstructAggregateErrorNode.class)
        private static final class ConstructErrorData extends Node {

            @Child JSToStringNode toStringNode_;
            @Child GetMethodNode getIteratorMethodNode_;
            @Child JSFunctionCallNode iteratorCallNode_;
            @Child IsJSObjectNode isObjectNode_;
            @Child IteratorStepNode iteratorStepNode_;
            @Child IteratorValueNode getIteratorValueNode_;
            @Child PropertyGetNode getNextMethodNode_;
            @CompilationFinal BranchProfile growProfile_;

            ConstructErrorData() {
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
    @GeneratedBy(ConstructDataViewNode.class)
    public static final class ConstructDataViewNodeGen extends ConstructDataViewNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private BranchProfile errorBranch;
        @CompilationFinal private ConditionProfile byteLengthCondition;
        @Child private JSToIndexNode offsetToIndexNode;
        @Child private JSToIndexNode lengthToIndexNode;
        @Child private InteropLibrary bufferInterop;

        private ConstructDataViewNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
            this.arguments3_ = arguments != null && 3 < arguments.length ? arguments[3] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 ofHeapArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) || ofDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) || ofInteropArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode, InteropLibrary) || ofInteropBuffer(DynamicObject, Object, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode, InteropLibrary) || error(DynamicObject, Object, Object, Object, InteropLibrary) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b111) != 0 /* is-state_0 ofHeapArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) || ofDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) || ofInteropArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode, InteropLibrary) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 ofHeapArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) */) {
                        if ((JSArrayBuffer.isJSHeapArrayBuffer(arguments1Value__))) {
                            return ofHeapArrayBuffer(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_, this.errorBranch, this.byteLengthCondition, this.offsetToIndexNode, this.lengthToIndexNode);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 ofDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) */) {
                        if ((JSArrayBuffer.isJSDirectOrSharedArrayBuffer(arguments1Value__))) {
                            return ofDirectArrayBuffer(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_, this.errorBranch, this.byteLengthCondition, this.offsetToIndexNode, this.lengthToIndexNode);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 ofInteropArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode, InteropLibrary) */) {
                        if ((JSArrayBuffer.isJSInteropArrayBuffer(arguments1Value__))) {
                            return ofInteropArrayBuffer(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_, this.errorBranch, this.byteLengthCondition, this.offsetToIndexNode, this.lengthToIndexNode, this.bufferInterop);
                        }
                    }
                }
                if ((state_0 & 0b11000) != 0 /* is-state_0 ofInteropBuffer(DynamicObject, Object, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode, InteropLibrary) || error(DynamicObject, Object, Object, Object, InteropLibrary) */) {
                    if ((state_0 & 0b1000) != 0 /* is-state_0 ofInteropBuffer(DynamicObject, Object, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode, InteropLibrary) */) {
                        if ((!(JSAbstractBuffer.isJSAbstractBuffer(arguments1Value_))) && (this.bufferInterop.hasBufferElements(arguments1Value_))) {
                            return ofInteropBuffer(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, this.errorBranch, this.byteLengthCondition, this.offsetToIndexNode, this.lengthToIndexNode, this.bufferInterop);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 error(DynamicObject, Object, Object, Object, InteropLibrary) */) {
                        if ((!(JSAbstractBuffer.isJSAbstractBuffer(arguments1Value_))) && (!(this.bufferInterop.hasBufferElements(arguments1Value_)))) {
                            return ConstructDataViewNode.error(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, this.bufferInterop);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value, Object arguments3Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (JSTypes.isDynamicObject(arguments1Value)) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSArrayBuffer.isJSHeapArrayBuffer(arguments1Value_))) {
                            this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                            this.byteLengthCondition = this.byteLengthCondition == null ? ((ConditionProfile.createBinaryProfile())) : this.byteLengthCondition;
                            this.offsetToIndexNode = super.insert(this.offsetToIndexNode == null ? ((JSToIndexNode.create())) : this.offsetToIndexNode);
                            this.lengthToIndexNode = super.insert(this.lengthToIndexNode == null ? ((JSToIndexNode.create())) : this.lengthToIndexNode);
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 ofHeapArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) */;
                            lock.unlock();
                            hasLock = false;
                            return ofHeapArrayBuffer(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value, this.errorBranch, this.byteLengthCondition, this.offsetToIndexNode, this.lengthToIndexNode);
                        }
                        if ((JSArrayBuffer.isJSDirectOrSharedArrayBuffer(arguments1Value_))) {
                            this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                            this.byteLengthCondition = this.byteLengthCondition == null ? ((ConditionProfile.createBinaryProfile())) : this.byteLengthCondition;
                            this.offsetToIndexNode = super.insert(this.offsetToIndexNode == null ? ((JSToIndexNode.create())) : this.offsetToIndexNode);
                            this.lengthToIndexNode = super.insert(this.lengthToIndexNode == null ? ((JSToIndexNode.create())) : this.lengthToIndexNode);
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 ofDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) */;
                            lock.unlock();
                            hasLock = false;
                            return ofDirectArrayBuffer(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value, this.errorBranch, this.byteLengthCondition, this.offsetToIndexNode, this.lengthToIndexNode);
                        }
                        if ((JSArrayBuffer.isJSInteropArrayBuffer(arguments1Value_))) {
                            this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                            this.byteLengthCondition = this.byteLengthCondition == null ? ((ConditionProfile.createBinaryProfile())) : this.byteLengthCondition;
                            this.offsetToIndexNode = super.insert(this.offsetToIndexNode == null ? ((JSToIndexNode.create())) : this.offsetToIndexNode);
                            this.lengthToIndexNode = super.insert(this.lengthToIndexNode == null ? ((JSToIndexNode.create())) : this.lengthToIndexNode);
                            this.bufferInterop = super.insert(this.bufferInterop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.bufferInterop);
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 ofInteropArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return ofInteropArrayBuffer(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value, this.errorBranch, this.byteLengthCondition, this.offsetToIndexNode, this.lengthToIndexNode, this.bufferInterop);
                        }
                    }
                    if ((!(JSAbstractBuffer.isJSAbstractBuffer(arguments1Value)))) {
                        InteropLibrary ofInteropBuffer_bufferInterop__ = super.insert(this.bufferInterop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.bufferInterop);
                        if ((ofInteropBuffer_bufferInterop__.hasBufferElements(arguments1Value))) {
                            this.errorBranch = this.errorBranch == null ? ((BranchProfile.create())) : this.errorBranch;
                            this.byteLengthCondition = this.byteLengthCondition == null ? ((ConditionProfile.createBinaryProfile())) : this.byteLengthCondition;
                            this.offsetToIndexNode = super.insert(this.offsetToIndexNode == null ? ((JSToIndexNode.create())) : this.offsetToIndexNode);
                            this.lengthToIndexNode = super.insert(this.lengthToIndexNode == null ? ((JSToIndexNode.create())) : this.lengthToIndexNode);
                            if (this.bufferInterop == null) {
                                InteropLibrary ofInteropBuffer_bufferInterop___check = super.insert(ofInteropBuffer_bufferInterop__);
                                if (ofInteropBuffer_bufferInterop___check == null) {
                                    throw new AssertionError("Specialization 'ofInteropBuffer(DynamicObject, Object, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode, InteropLibrary)' contains a shared cache with name 'bufferInterop' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                }
                                this.bufferInterop = ofInteropBuffer_bufferInterop___check;
                            }
                            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 ofInteropBuffer(DynamicObject, Object, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return ofInteropBuffer(arguments0Value_, arguments1Value, arguments2Value, arguments3Value, this.errorBranch, this.byteLengthCondition, this.offsetToIndexNode, this.lengthToIndexNode, ofInteropBuffer_bufferInterop__);
                        }
                    }
                    if ((!(JSAbstractBuffer.isJSAbstractBuffer(arguments1Value)))) {
                        InteropLibrary error_bufferInterop__ = super.insert(this.bufferInterop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.bufferInterop);
                        if ((!(error_bufferInterop__.hasBufferElements(arguments1Value)))) {
                            if (this.bufferInterop == null) {
                                InteropLibrary error_bufferInterop___check = super.insert(error_bufferInterop__);
                                if (error_bufferInterop___check == null) {
                                    throw new AssertionError("Specialization 'error(DynamicObject, Object, Object, Object, InteropLibrary)' contains a shared cache with name 'bufferInterop' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                }
                                this.bufferInterop = error_bufferInterop___check;
                            }
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 error(DynamicObject, Object, Object, Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return ConstructDataViewNode.error(arguments0Value_, arguments1Value, arguments2Value, arguments3Value, error_bufferInterop__);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_}, arguments0Value, arguments1Value, arguments2Value, arguments3Value);
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
            Object[] data = new Object[6];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "ofHeapArrayBuffer";
            if ((state_0 & 0b1) != 0 /* is-state_0 ofHeapArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.errorBranch, this.byteLengthCondition, this.offsetToIndexNode, this.lengthToIndexNode));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "ofDirectArrayBuffer";
            if ((state_0 & 0b10) != 0 /* is-state_0 ofDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.errorBranch, this.byteLengthCondition, this.offsetToIndexNode, this.lengthToIndexNode));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "ofInteropArrayBuffer";
            if ((state_0 & 0b100) != 0 /* is-state_0 ofInteropArrayBuffer(DynamicObject, DynamicObject, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.errorBranch, this.byteLengthCondition, this.offsetToIndexNode, this.lengthToIndexNode, this.bufferInterop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "ofInteropBuffer";
            if ((state_0 & 0b1000) != 0 /* is-state_0 ofInteropBuffer(DynamicObject, Object, Object, Object, BranchProfile, ConditionProfile, JSToIndexNode, JSToIndexNode, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.errorBranch, this.byteLengthCondition, this.offsetToIndexNode, this.lengthToIndexNode, this.bufferInterop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "error";
            if ((state_0 & 0b10000) != 0 /* is-state_0 error(DynamicObject, Object, Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.bufferInterop));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static ConstructDataViewNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructDataViewNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(CallRequiresNewNode.class)
    public static final class CallRequiresNewNodeGen extends CallRequiresNewNode implements Introspection.Provider {

        private CallRequiresNewNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return call();
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
            s[0] = "call";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static CallRequiresNewNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallRequiresNewNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructJSAdapterNode.class)
    public static final class ConstructJSAdapterNodeGen extends ConstructJSAdapterNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructJSAdapterNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state_0 & 0b111) != 0 /* is-state_0 constructJSAdapter(DynamicObject, Object, Object) || constructJSAdapter(DynamicObject, DynamicObject, Object) || constructJSAdapter(DynamicObject, DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b11) != 0 /* is-state_0 constructJSAdapter(DynamicObject, Object, Object) || constructJSAdapter(DynamicObject, DynamicObject, Object) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 constructJSAdapter(DynamicObject, Object, Object) */) {
                        if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_)) && (JSGuards.isUndefined(arguments2Value_))) {
                            return constructJSAdapter(arguments0Value__, arguments1Value_, arguments2Value_);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 constructJSAdapter(DynamicObject, DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                        DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                        if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__)) && (JSGuards.isUndefined(arguments2Value_))) {
                            return constructJSAdapter(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 constructJSAdapter(DynamicObject, DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if (JSTypes.isDynamicObject(arguments2Value_)) {
                        DynamicObject arguments2Value__ = (DynamicObject) arguments2Value_;
                        if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__)) && (JSGuards.isJSObject(arguments2Value__))) {
                            return constructJSAdapter(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 constructJSAdapter(Object, Object, Object) */) {
                if (fallbackGuard_(arguments0Value_, arguments1Value_, arguments2Value_)) {
                    return constructJSAdapter(arguments0Value_, arguments1Value_, arguments2Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value)) && (JSGuards.isUndefined(arguments2Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructJSAdapter(DynamicObject, Object, Object) */;
                    return constructJSAdapter(arguments0Value_, arguments1Value, arguments2Value);
                }
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_)) && (JSGuards.isUndefined(arguments2Value))) {
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructJSAdapter(DynamicObject, DynamicObject, Object) */;
                        return constructJSAdapter(arguments0Value_, arguments1Value_, arguments2Value);
                    }
                }
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if (JSTypes.isDynamicObject(arguments2Value)) {
                        DynamicObject arguments2Value_ = (DynamicObject) arguments2Value;
                        if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_)) && (JSGuards.isJSObject(arguments2Value_))) {
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 constructJSAdapter(DynamicObject, DynamicObject, DynamicObject) */;
                            return constructJSAdapter(arguments0Value_, arguments1Value_, arguments2Value_);
                        }
                    }
                }
            }
            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 constructJSAdapter(Object, Object, Object) */;
            return constructJSAdapter(arguments0Value, arguments1Value, arguments2Value);
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
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "constructJSAdapter";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructJSAdapter(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructJSAdapter";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructJSAdapter(DynamicObject, DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "constructJSAdapter";
            if ((state_0 & 0b100) != 0 /* is-state_0 constructJSAdapter(DynamicObject, DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "constructJSAdapter";
            if ((state_0 & 0b1000) != 0 /* is-state_0 constructJSAdapter(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value)) && (JSGuards.isUndefined(arguments2Value))) {
                        return false;
                    }
                }
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSGuards.isJSObject(arguments1Value_)) && (JSGuards.isUndefined(arguments2Value))) {
                            return false;
                        }
                    }
                }
                if (JSTypes.isDynamicObject(arguments1Value) && JSTypes.isDynamicObject(arguments2Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSGuards.isJSObject(arguments1Value_))) {
                            DynamicObject arguments2Value_ = (DynamicObject) arguments2Value;
                            if ((JSGuards.isJSObject(arguments2Value_))) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }

        public static ConstructJSAdapterNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ConstructJSAdapterNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructJSProxyNode.class)
    public static final class ConstructJSProxyNodeGen extends ConstructJSProxyNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructJSProxyNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public DynamicObject execute(DynamicObject arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 constructJSProxy(DynamicObject, Object, Object) */) {
                return constructJSProxy(arguments0Value, arguments1Value, arguments2Value);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value, arguments1Value, arguments2Value);
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructJSProxy(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructJSProxy(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructJSProxy(DynamicObject, Object, Object) */;
                return constructJSProxy(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructJSProxy";
            if (state_0 != 0 /* is-state_0 constructJSProxy(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructJSProxyNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructJSProxyNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructJavaImporterNode.class)
    public static final class ConstructJavaImporterNodeGen extends ConstructJavaImporterNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private ConstructJavaImporterNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 constructJavaImporter(Object[]) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                return constructJavaImporter(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof Object[]) {
                Object[] arguments0Value_ = (Object[]) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructJavaImporter(Object[]) */;
                return constructJavaImporter(arguments0Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "constructJavaImporter";
            if (state_0 != 0 /* is-state_0 constructJavaImporter(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructJavaImporterNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ConstructJavaImporterNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructMapNode.class)
    public static final class ConstructMapNodeGen extends ConstructMapNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private ConstructMapFromIterableData constructMapFromIterable_cache;

        private ConstructMapNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructEmptyMap(DynamicObject, Object) || constructMapFromIterable(DynamicObject, Object, ReadElementNode, IsObjectNode, IsCallableNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 constructEmptyMap(DynamicObject, Object) */) {
                    if ((JSGuards.isNullOrUndefined(arguments1Value_))) {
                        return constructEmptyMap(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 constructMapFromIterable(DynamicObject, Object, ReadElementNode, IsObjectNode, IsCallableNode) */) {
                    ConstructMapFromIterableData s1_ = this.constructMapFromIterable_cache;
                    if (s1_ != null) {
                        if ((!(JSGuards.isNullOrUndefined(arguments1Value_)))) {
                            return constructMapFromIterable(arguments0Value__, arguments1Value_, s1_.readElementNode_, s1_.isObjectNode_, s1_.isCallableNode_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isNullOrUndefined(arguments1Value))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructEmptyMap(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return constructEmptyMap(arguments0Value_, arguments1Value);
                    }
                    if ((!(JSGuards.isNullOrUndefined(arguments1Value)))) {
                        ConstructMapFromIterableData s1_ = super.insert(new ConstructMapFromIterableData());
                        s1_.readElementNode_ = s1_.insertAccessor((ReadElementNode.create(getContext())));
                        s1_.isObjectNode_ = s1_.insertAccessor((IsObjectNode.create()));
                        s1_.isCallableNode_ = s1_.insertAccessor((IsCallableNode.create()));
                        MemoryFence.storeStore();
                        this.constructMapFromIterable_cache = s1_;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructMapFromIterable(DynamicObject, Object, ReadElementNode, IsObjectNode, IsCallableNode) */;
                        lock.unlock();
                        hasLock = false;
                        return constructMapFromIterable(arguments0Value_, arguments1Value, s1_.readElementNode_, s1_.isObjectNode_, s1_.isCallableNode_);
                    }
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
            s[0] = "constructEmptyMap";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructEmptyMap(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructMapFromIterable";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructMapFromIterable(DynamicObject, Object, ReadElementNode, IsObjectNode, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructMapFromIterableData s1_ = this.constructMapFromIterable_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.readElementNode_, s1_.isObjectNode_, s1_.isCallableNode_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructMapNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructMapNodeGen(context, builtin, isNewTargetCase, arguments);
        }

        @GeneratedBy(ConstructMapNode.class)
        private static final class ConstructMapFromIterableData extends Node {

            @Child ReadElementNode readElementNode_;
            @Child IsObjectNode isObjectNode_;
            @Child IsCallableNode isCallableNode_;

            ConstructMapFromIterableData() {
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
    @GeneratedBy(ConstructSetNode.class)
    public static final class ConstructSetNodeGen extends ConstructSetNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private IsCallableNode constructSetFromIterable_isCallableNode_;

        private ConstructSetNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructEmptySet(DynamicObject, Object) || constructSetFromIterable(DynamicObject, Object, IsCallableNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 constructEmptySet(DynamicObject, Object) */) {
                    if ((JSGuards.isNullOrUndefined(arguments1Value_))) {
                        return constructEmptySet(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 constructSetFromIterable(DynamicObject, Object, IsCallableNode) */) {
                    if ((!(JSGuards.isNullOrUndefined(arguments1Value_)))) {
                        return constructSetFromIterable(arguments0Value__, arguments1Value_, this.constructSetFromIterable_isCallableNode_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isNullOrUndefined(arguments1Value))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructEmptySet(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return constructEmptySet(arguments0Value_, arguments1Value);
                    }
                    if ((!(JSGuards.isNullOrUndefined(arguments1Value)))) {
                        this.constructSetFromIterable_isCallableNode_ = super.insert((IsCallableNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructSetFromIterable(DynamicObject, Object, IsCallableNode) */;
                        lock.unlock();
                        hasLock = false;
                        return constructSetFromIterable(arguments0Value_, arguments1Value, this.constructSetFromIterable_isCallableNode_);
                    }
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
            s[0] = "constructEmptySet";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructEmptySet(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructSetFromIterable";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructSetFromIterable(DynamicObject, Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructSetFromIterable_isCallableNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructSetNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructSetNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructWeakSetNode.class)
    public static final class ConstructWeakSetNodeGen extends ConstructWeakSetNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private IsCallableNode constructSetFromIterable_isCallableNode_;

        private ConstructWeakSetNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructEmptySet(DynamicObject, Object) || constructSetFromIterable(DynamicObject, Object, IsCallableNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 constructEmptySet(DynamicObject, Object) */) {
                    if ((JSGuards.isNullOrUndefined(arguments1Value_))) {
                        return constructEmptySet(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 constructSetFromIterable(DynamicObject, Object, IsCallableNode) */) {
                    if ((!(JSGuards.isNullOrUndefined(arguments1Value_)))) {
                        return constructSetFromIterable(arguments0Value__, arguments1Value_, this.constructSetFromIterable_isCallableNode_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isNullOrUndefined(arguments1Value))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructEmptySet(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return constructEmptySet(arguments0Value_, arguments1Value);
                    }
                    if ((!(JSGuards.isNullOrUndefined(arguments1Value)))) {
                        this.constructSetFromIterable_isCallableNode_ = super.insert((IsCallableNode.create()));
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructSetFromIterable(DynamicObject, Object, IsCallableNode) */;
                        lock.unlock();
                        hasLock = false;
                        return constructSetFromIterable(arguments0Value_, arguments1Value, this.constructSetFromIterable_isCallableNode_);
                    }
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
            s[0] = "constructEmptySet";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructEmptySet(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructSetFromIterable";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructSetFromIterable(DynamicObject, Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructSetFromIterable_isCallableNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructWeakSetNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructWeakSetNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructWeakMapNode.class)
    public static final class ConstructWeakMapNodeGen extends ConstructWeakMapNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @Child private ConstructMapFromIterableData constructMapFromIterable_cache;

        private ConstructWeakMapNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructEmptyMap(DynamicObject, Object) || constructMapFromIterable(DynamicObject, Object, ReadElementNode, IsObjectNode, IsCallableNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 constructEmptyMap(DynamicObject, Object) */) {
                    if ((JSGuards.isNullOrUndefined(arguments1Value_))) {
                        return constructEmptyMap(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 constructMapFromIterable(DynamicObject, Object, ReadElementNode, IsObjectNode, IsCallableNode) */) {
                    ConstructMapFromIterableData s1_ = this.constructMapFromIterable_cache;
                    if (s1_ != null) {
                        if ((!(JSGuards.isNullOrUndefined(arguments1Value_)))) {
                            return constructMapFromIterable(arguments0Value__, arguments1Value_, s1_.readElementNode_, s1_.isObjectNode_, s1_.isCallableNode_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isNullOrUndefined(arguments1Value))) {
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructEmptyMap(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return constructEmptyMap(arguments0Value_, arguments1Value);
                    }
                    if ((!(JSGuards.isNullOrUndefined(arguments1Value)))) {
                        ConstructMapFromIterableData s1_ = super.insert(new ConstructMapFromIterableData());
                        s1_.readElementNode_ = s1_.insertAccessor((ReadElementNode.create(getContext())));
                        s1_.isObjectNode_ = s1_.insertAccessor((IsObjectNode.create()));
                        s1_.isCallableNode_ = s1_.insertAccessor((IsCallableNode.create()));
                        MemoryFence.storeStore();
                        this.constructMapFromIterable_cache = s1_;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructMapFromIterable(DynamicObject, Object, ReadElementNode, IsObjectNode, IsCallableNode) */;
                        lock.unlock();
                        hasLock = false;
                        return constructMapFromIterable(arguments0Value_, arguments1Value, s1_.readElementNode_, s1_.isObjectNode_, s1_.isCallableNode_);
                    }
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
            s[0] = "constructEmptyMap";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructEmptyMap(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructMapFromIterable";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructMapFromIterable(DynamicObject, Object, ReadElementNode, IsObjectNode, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructMapFromIterableData s1_ = this.constructMapFromIterable_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.readElementNode_, s1_.isObjectNode_, s1_.isCallableNode_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructWeakMapNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructWeakMapNodeGen(context, builtin, isNewTargetCase, arguments);
        }

        @GeneratedBy(ConstructWeakMapNode.class)
        private static final class ConstructMapFromIterableData extends Node {

            @Child ReadElementNode readElementNode_;
            @Child IsObjectNode isObjectNode_;
            @Child IsCallableNode isCallableNode_;

            ConstructMapFromIterableData() {
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
    @GeneratedBy(CallSymbolNode.class)
    public static final class CallSymbolNodeGen extends CallSymbolNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private JSToStringNode callSymbolGeneric_toStringNode_;

        private CallSymbolNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state_0 & 0b1) != 0 /* is-state_0 callSymbolString(String) */ && JSTypesGen.isImplicitString((state_0 & 0b11100) >>> 2 /* extract-implicit-state_0 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state_0 & 0b11100) >>> 2 /* extract-implicit-state_0 0:String */, arguments0Value_);
                return callSymbolString(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 callSymbolGeneric(Object, JSToStringNode) */) {
                if ((!(JSGuards.isString(arguments0Value_)))) {
                    return callSymbolGeneric(arguments0Value_, this.callSymbolGeneric_toStringNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Symbol executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        state_0 = (state_0 | (stringCast0 << 2) /* set-implicit-state_0 0:String */);
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 callSymbolString(String) */;
                        lock.unlock();
                        hasLock = false;
                        return callSymbolString(arguments0Value_);
                    }
                }
                if ((!(JSGuards.isString(arguments0Value)))) {
                    this.callSymbolGeneric_toStringNode_ = super.insert((JSToStringNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 callSymbolGeneric(Object, JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return callSymbolGeneric(arguments0Value, this.callSymbolGeneric_toStringNode_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s = new Object[3];
            s[0] = "callSymbolString";
            if ((state_0 & 0b1) != 0 /* is-state_0 callSymbolString(String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "callSymbolGeneric";
            if ((state_0 & 0b10) != 0 /* is-state_0 callSymbolGeneric(Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.callSymbolGeneric_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static CallSymbolNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallSymbolNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructSymbolNode.class)
    public static final class ConstructSymbolNodeGen extends ConstructSymbolNode implements Introspection.Provider {

        private ConstructSymbolNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return ConstructSymbolNode.construct();
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
            s[0] = "construct";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructSymbolNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ConstructSymbolNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PromiseConstructorNode.class)
    public static final class PromiseConstructorNodeGen extends PromiseConstructorNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private PromiseConstructorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state_0 != 0 /* is-state_0 construct(VirtualFrame, DynamicObject, Object) || notCallable(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 construct(VirtualFrame, DynamicObject, Object) */) {
                    if ((isCallable.executeBoolean(arguments1Value_))) {
                        return construct(frameValue, arguments0Value__, arguments1Value_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 notCallable(DynamicObject, Object) */) {
                    if ((!(isCallable.executeBoolean(arguments1Value_)))) {
                        return notCallable(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value, Object arguments1Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((isCallable.executeBoolean(arguments1Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 construct(VirtualFrame, DynamicObject, Object) */;
                    return construct(frameValue, arguments0Value_, arguments1Value);
                }
                if ((!(isCallable.executeBoolean(arguments1Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 notCallable(DynamicObject, Object) */;
                    return notCallable(arguments0Value_, arguments1Value);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "construct";
            if ((state_0 & 0b1) != 0 /* is-state_0 construct(VirtualFrame, DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "notCallable";
            if ((state_0 & 0b10) != 0 /* is-state_0 notCallable(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static PromiseConstructorNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PromiseConstructorNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructWebAssemblyModuleNode.class)
    public static final class ConstructWebAssemblyModuleNodeGen extends ConstructWebAssemblyModuleNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private ConstructWebAssemblyModuleNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructModule(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructModule(arguments0Value__, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructModule(DynamicObject, Object) */;
                return constructModule(arguments0Value_, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "constructModule";
            if (state_0 != 0 /* is-state_0 constructModule(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructWebAssemblyModuleNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructWebAssemblyModuleNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructWebAssemblyInstanceNode.class)
    public static final class ConstructWebAssemblyInstanceNodeGen extends ConstructWebAssemblyInstanceNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructWebAssemblyInstanceNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructInstanceFromModule(DynamicObject, JSWebAssemblyModuleObject, Object) || constructInstanceFromOther(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b1) != 0 /* is-state_0 constructInstanceFromModule(DynamicObject, JSWebAssemblyModuleObject, Object) */ && arguments1Value_ instanceof JSWebAssemblyModuleObject) {
                    JSWebAssemblyModuleObject arguments1Value__ = (JSWebAssemblyModuleObject) arguments1Value_;
                    return constructInstanceFromModule(arguments0Value__, arguments1Value__, arguments2Value_);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 constructInstanceFromOther(DynamicObject, Object, Object) */) {
                    if ((!(JSGuards.isJSWebAssemblyModule(arguments1Value_)))) {
                        return constructInstanceFromOther(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if (arguments1Value instanceof JSWebAssemblyModuleObject) {
                    JSWebAssemblyModuleObject arguments1Value_ = (JSWebAssemblyModuleObject) arguments1Value;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructInstanceFromModule(DynamicObject, JSWebAssemblyModuleObject, Object) */;
                    return constructInstanceFromModule(arguments0Value_, arguments1Value_, arguments2Value);
                }
                if ((!(JSGuards.isJSWebAssemblyModule(arguments1Value)))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 constructInstanceFromOther(DynamicObject, Object, Object) */;
                    return constructInstanceFromOther(arguments0Value_, arguments1Value, arguments2Value);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructInstanceFromModule";
            if ((state_0 & 0b1) != 0 /* is-state_0 constructInstanceFromModule(DynamicObject, JSWebAssemblyModuleObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructInstanceFromOther";
            if ((state_0 & 0b10) != 0 /* is-state_0 constructInstanceFromOther(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructWebAssemblyInstanceNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructWebAssemblyInstanceNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructWebAssemblyMemoryNode.class)
    public static final class ConstructWebAssemblyMemoryNodeGen extends ConstructWebAssemblyMemoryNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private ConstructWebAssemblyMemoryNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructMemory(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructMemory(arguments0Value__, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructMemory(DynamicObject, Object) */;
                return constructMemory(arguments0Value_, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "constructMemory";
            if (state_0 != 0 /* is-state_0 constructMemory(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructWebAssemblyMemoryNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructWebAssemblyMemoryNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructWebAssemblyTableNode.class)
    public static final class ConstructWebAssemblyTableNodeGen extends ConstructWebAssemblyTableNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_0_;

        private ConstructWebAssemblyTableNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
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
            if (state_0 != 0 /* is-state_0 constructTable(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructTable(arguments0Value__, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructTable(DynamicObject, Object) */;
                return constructTable(arguments0Value_, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "constructTable";
            if (state_0 != 0 /* is-state_0 constructTable(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructWebAssemblyTableNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructWebAssemblyTableNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructWebAssemblyGlobalNode.class)
    public static final class ConstructWebAssemblyGlobalNodeGen extends ConstructWebAssemblyGlobalNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_0_;

        private ConstructWebAssemblyGlobalNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state_0 != 0 /* is-state_0 constructGlobal(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructGlobal(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state_0 = this.state_0_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 constructGlobal(DynamicObject, Object, Object) */;
                return constructGlobal(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "constructGlobal";
            if (state_0 != 0 /* is-state_0 constructGlobal(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructWebAssemblyGlobalNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructWebAssemblyGlobalNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
}
