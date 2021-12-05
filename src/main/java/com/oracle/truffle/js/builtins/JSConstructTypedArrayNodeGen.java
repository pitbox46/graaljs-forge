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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.GetMethodNode;
import com.oracle.truffle.js.nodes.access.IsJSObjectNode;
import com.oracle.truffle.js.nodes.access.IteratorStepNode;
import com.oracle.truffle.js.nodes.access.IteratorValueNode;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.nodes.access.WriteElementNode;
import com.oracle.truffle.js.nodes.array.JSGetLengthNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.array.TypedArray;
import com.oracle.truffle.js.runtime.array.TypedArrayFactory;
import com.oracle.truffle.js.runtime.builtins.JSAbstractBuffer;
import com.oracle.truffle.js.runtime.builtins.JSArrayBuffer;
import com.oracle.truffle.js.runtime.builtins.JSObjectFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSConstructTypedArrayNode.class)
@SuppressWarnings("unused")
public final class JSConstructTypedArrayNodeGen extends JSConstructTypedArrayNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @Child private JavaScriptNode arguments0_;
    @Child private JavaScriptNode arguments1_;
    @Child private JavaScriptNode arguments2_;
    @Child private JavaScriptNode arguments3_;
    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile lengthIsUndefined;
    @Child private InteropLibrary interopArrayBuffer_interop_;
    @Child private ObjectData object_cache;
    @Child private ForeignObject0Data foreignObject0_cache;
    @Child private ForeignObject1Data foreignObject1_cache;

    private JSConstructTypedArrayNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        super(context, builtin);
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
        if ((state_0 & 0b111110111111) == 0 /* only-active doIntLength(DynamicObject, int, Object, Object) */ && (state_0 != 0  /* is-not doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) && doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) && doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) && doInteropArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile, InteropLibrary) && doArrayBufferView(DynamicObject, DynamicObject, Object, Object) && doEmpty(DynamicObject, DynamicObject, Object, Object) && doIntLength(DynamicObject, int, Object, Object) && doLength(DynamicObject, Object, Object, Object) && doObject(DynamicObject, DynamicObject, Object, Object, GetMethodNode, ConditionProfile, WriteElementNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, JSGetLengthNode, ReadElementNode, PropertyGetNode, BranchProfile) && doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) && doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) && doUndefinedNewTarget(Object, Object, Object, Object) */)) {
            return execute_int0(state_0, frameValue);
        } else {
            return execute_generic1(state_0, frameValue);
        }
    }

    private Object execute_int0(int state_0, VirtualFrame frameValue) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        int arguments1Value_;
        try {
            arguments1Value_ = this.arguments1_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object arguments2Value = this.arguments2_.execute(frameValue);
            Object arguments3Value = this.arguments3_.execute(frameValue);
            return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value, arguments3Value);
        }
        Object arguments2Value_ = this.arguments2_.execute(frameValue);
        Object arguments3Value_ = this.arguments3_.execute(frameValue);
        assert (state_0 & 0b1000000) != 0 /* is-state_0 doIntLength(DynamicObject, int, Object, Object) */;
        if (JSTypes.isDynamicObject(arguments0Value_)) {
            DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
            if ((!(JSGuards.isUndefined(arguments0Value__))) && (arguments1Value_ >= 0)) {
                return doIntLength(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object foreignObject1Boundary(int state_0, ForeignObject1Data s10_, DynamicObject arguments0Value__, Object arguments1Value_, Object arguments2Value_, Object arguments3Value_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(arguments1Value_));
                return doForeignObject(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, interop__, s10_.writeOwnNode_, s10_.importValue_, s10_.lengthIsUndefined_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    private Object execute_generic1(int state_0, VirtualFrame frameValue) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        Object arguments1Value_ = this.arguments1_.execute(frameValue);
        Object arguments2Value_ = this.arguments2_.execute(frameValue);
        Object arguments3Value_ = this.arguments3_.execute(frameValue);
        if (state_0 != 0 /* is-state_0 doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doInteropArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile, InteropLibrary) || doArrayBufferView(DynamicObject, DynamicObject, Object, Object) || doEmpty(DynamicObject, DynamicObject, Object, Object) || doIntLength(DynamicObject, int, Object, Object) || doLength(DynamicObject, Object, Object, Object) || doObject(DynamicObject, DynamicObject, Object, Object, GetMethodNode, ConditionProfile, WriteElementNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, JSGetLengthNode, ReadElementNode, PropertyGetNode, BranchProfile) || doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) || doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) || doUndefinedNewTarget(Object, Object, Object, Object) */) {
            if ((state_0 & 0b11111111111) != 0 /* is-state_0 doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doInteropArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile, InteropLibrary) || doArrayBufferView(DynamicObject, DynamicObject, Object, Object) || doEmpty(DynamicObject, DynamicObject, Object, Object) || doIntLength(DynamicObject, int, Object, Object) || doLength(DynamicObject, Object, Object, Object) || doObject(DynamicObject, DynamicObject, Object, Object, GetMethodNode, ConditionProfile, WriteElementNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, JSGetLengthNode, ReadElementNode, PropertyGetNode, BranchProfile) || doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) || doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state_0 & 0b111111) != 0 /* is-state_0 doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doInteropArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile, InteropLibrary) || doArrayBufferView(DynamicObject, DynamicObject, Object, Object) || doEmpty(DynamicObject, DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */) {
                        if ((!(JSGuards.isUndefined(arguments0Value__))) && (JSArrayBuffer.isJSHeapArrayBuffer(arguments1Value__))) {
                            return doArrayBuffer(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_, this.lengthIsUndefined);
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */) {
                        if ((!(JSGuards.isUndefined(arguments0Value__))) && (JSArrayBuffer.isJSDirectArrayBuffer(arguments1Value__))) {
                            return doDirectArrayBuffer(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_, this.lengthIsUndefined);
                        }
                    }
                    if ((state_0 & 0b100) != 0 /* is-state_0 doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */) {
                        if ((!(JSGuards.isUndefined(arguments0Value__))) && (JSGuards.isJSSharedArrayBuffer(arguments1Value__))) {
                            return doSharedArrayBuffer(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_, this.lengthIsUndefined);
                        }
                    }
                    if ((state_0 & 0b1000) != 0 /* is-state_0 doInteropArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile, InteropLibrary) */) {
                        if ((!(JSGuards.isUndefined(arguments0Value__))) && (JSArrayBuffer.isJSInteropArrayBuffer(arguments1Value__))) {
                            return doInteropArrayBuffer(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_, this.lengthIsUndefined, this.interopArrayBuffer_interop_);
                        }
                    }
                    if ((state_0 & 0b10000) != 0 /* is-state_0 doArrayBufferView(DynamicObject, DynamicObject, Object, Object) */) {
                        if ((!(JSGuards.isUndefined(arguments0Value__))) && (JSGuards.isJSArrayBufferView(arguments1Value__))) {
                            return doArrayBufferView(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_);
                        }
                    }
                    if ((state_0 & 0b100000) != 0 /* is-state_0 doEmpty(DynamicObject, DynamicObject, Object, Object) */) {
                        if ((!(JSGuards.isUndefined(arguments0Value__))) && (JSGuards.isUndefined(arguments1Value__))) {
                            return doEmpty(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_);
                        }
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 doIntLength(DynamicObject, int, Object, Object) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((!(JSGuards.isUndefined(arguments0Value__))) && (arguments1Value__ >= 0)) {
                        return doIntLength(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state_0 & 0b10000000) != 0 /* is-state_0 doLength(DynamicObject, Object, Object, Object) */) {
                    if ((!(JSGuards.isUndefined(arguments0Value__))) && (!(JSGuards.isJSObject(arguments1Value_))) && (!(JSRuntime.isForeignObject(arguments1Value_)))) {
                        return doLength(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state_0 & 0b100000000) != 0 /* is-state_0 doObject(DynamicObject, DynamicObject, Object, Object, GetMethodNode, ConditionProfile, WriteElementNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, JSGetLengthNode, ReadElementNode, PropertyGetNode, BranchProfile) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    ObjectData s8_ = this.object_cache;
                    if (s8_ != null) {
                        if ((!(JSGuards.isUndefined(arguments0Value__))) && (JSGuards.isJSObject(arguments1Value__)) && (!(JSAbstractBuffer.isJSAbstractBuffer(arguments1Value__))) && (!(JSGuards.isJSArrayBufferView(arguments1Value__)))) {
                            return doObject(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_, s8_.getIteratorMethodNode_, s8_.isIterableProfile_, s8_.writeOwnNode_, s8_.iteratorCallNode_, s8_.isObjectNode_, s8_.iteratorStepNode_, s8_.getIteratorValueNode_, s8_.getLengthNode_, s8_.readNode_, s8_.getNextMethodNode_, s8_.growProfile_);
                        }
                    }
                }
                if ((state_0 & 0b11000000000) != 0 /* is-state_0 doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) || doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */) {
                    if ((state_0 & 0b1000000000) != 0 /* is-state_0 doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */) {
                        ForeignObject0Data s9_ = this.foreignObject0_cache;
                        while (s9_ != null) {
                            if ((s9_.interop_.accepts(arguments1Value_)) && (!(JSGuards.isUndefined(arguments0Value__))) && (JSRuntime.isForeignObject(arguments1Value_))) {
                                return doForeignObject(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, s9_.interop_, s9_.writeOwnNode_, s9_.importValue_, s9_.lengthIsUndefined_);
                            }
                            s9_ = s9_.next_;
                        }
                    }
                    if ((state_0 & 0b10000000000) != 0 /* is-state_0 doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */) {
                        ForeignObject1Data s10_ = this.foreignObject1_cache;
                        if (s10_ != null) {
                            if ((!(JSGuards.isUndefined(arguments0Value__))) && (JSRuntime.isForeignObject(arguments1Value_))) {
                                return this.foreignObject1Boundary(state_0, s10_, arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                            }
                        }
                    }
                }
            }
            if ((state_0 & 0b100000000000) != 0 /* is-state_0 doUndefinedNewTarget(Object, Object, Object, Object) */) {
                if ((JSGuards.isUndefined(arguments0Value_))) {
                    return doUndefinedNewTarget(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
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
            int exclude = this.exclude_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if ((!(JSGuards.isUndefined(arguments0Value_))) && (JSArrayBuffer.isJSHeapArrayBuffer(arguments1Value_))) {
                        this.lengthIsUndefined = this.lengthIsUndefined == null ? ((ConditionProfile.createBinaryProfile())) : this.lengthIsUndefined;
                        this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doArrayBuffer(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value, this.lengthIsUndefined);
                    }
                    if ((!(JSGuards.isUndefined(arguments0Value_))) && (JSArrayBuffer.isJSDirectArrayBuffer(arguments1Value_))) {
                        this.lengthIsUndefined = this.lengthIsUndefined == null ? ((ConditionProfile.createBinaryProfile())) : this.lengthIsUndefined;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doDirectArrayBuffer(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value, this.lengthIsUndefined);
                    }
                    if ((!(JSGuards.isUndefined(arguments0Value_))) && (JSGuards.isJSSharedArrayBuffer(arguments1Value_))) {
                        this.lengthIsUndefined = this.lengthIsUndefined == null ? ((ConditionProfile.createBinaryProfile())) : this.lengthIsUndefined;
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doSharedArrayBuffer(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value, this.lengthIsUndefined);
                    }
                    if ((!(JSGuards.isUndefined(arguments0Value_))) && (JSArrayBuffer.isJSInteropArrayBuffer(arguments1Value_))) {
                        this.lengthIsUndefined = this.lengthIsUndefined == null ? ((ConditionProfile.createBinaryProfile())) : this.lengthIsUndefined;
                        this.interopArrayBuffer_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doInteropArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return doInteropArrayBuffer(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value, this.lengthIsUndefined, this.interopArrayBuffer_interop_);
                    }
                    if ((!(JSGuards.isUndefined(arguments0Value_))) && (JSGuards.isJSArrayBufferView(arguments1Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doArrayBufferView(DynamicObject, DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doArrayBufferView(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value);
                    }
                    if ((!(JSGuards.isUndefined(arguments0Value_))) && (JSGuards.isUndefined(arguments1Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doEmpty(DynamicObject, DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doEmpty(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value);
                    }
                }
                if (((exclude & 0b1)) == 0 /* is-not-exclude doIntLength(DynamicObject, int, Object, Object) */ && arguments1Value instanceof Integer) {
                    int arguments1Value_ = (int) arguments1Value;
                    if ((!(JSGuards.isUndefined(arguments0Value_))) && (arguments1Value_ >= 0)) {
                        this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doIntLength(DynamicObject, int, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doIntLength(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value);
                    }
                }
                if ((!(JSGuards.isUndefined(arguments0Value_))) && (!(JSGuards.isJSObject(arguments1Value))) && (!(JSRuntime.isForeignObject(arguments1Value)))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doIntLength(DynamicObject, int, Object, Object) */;
                    state_0 = state_0 & 0xffffffbf /* remove-state_0 doIntLength(DynamicObject, int, Object, Object) */;
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doLength(DynamicObject, Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doLength(arguments0Value_, arguments1Value, arguments2Value, arguments3Value);
                }
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if ((!(JSGuards.isUndefined(arguments0Value_))) && (JSGuards.isJSObject(arguments1Value_)) && (!(JSAbstractBuffer.isJSAbstractBuffer(arguments1Value_))) && (!(JSGuards.isJSArrayBufferView(arguments1Value_)))) {
                        ObjectData s8_ = super.insert(new ObjectData());
                        s8_.getIteratorMethodNode_ = s8_.insertAccessor((createGetIteratorMethod()));
                        s8_.isIterableProfile_ = (ConditionProfile.createBinaryProfile());
                        s8_.writeOwnNode_ = s8_.insertAccessor((createWriteOwn()));
                        s8_.iteratorCallNode_ = s8_.insertAccessor((JSFunctionCallNode.createCall()));
                        s8_.isObjectNode_ = s8_.insertAccessor((IsJSObjectNode.create()));
                        s8_.iteratorStepNode_ = s8_.insertAccessor((IteratorStepNode.create(getContext())));
                        s8_.getIteratorValueNode_ = s8_.insertAccessor((IteratorValueNode.create(getContext())));
                        s8_.getLengthNode_ = s8_.insertAccessor((createGetLength()));
                        s8_.readNode_ = s8_.insertAccessor((ReadElementNode.create(getContext())));
                        s8_.getNextMethodNode_ = s8_.insertAccessor((PropertyGetNode.create(JSRuntime.NEXT, getContext())));
                        s8_.growProfile_ = (BranchProfile.create());
                        MemoryFence.storeStore();
                        this.object_cache = s8_;
                        this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doObject(DynamicObject, DynamicObject, Object, Object, GetMethodNode, ConditionProfile, WriteElementNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, JSGetLengthNode, ReadElementNode, PropertyGetNode, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doObject(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value, s8_.getIteratorMethodNode_, s8_.isIterableProfile_, s8_.writeOwnNode_, s8_.iteratorCallNode_, s8_.isObjectNode_, s8_.iteratorStepNode_, s8_.getIteratorValueNode_, s8_.getLengthNode_, s8_.readNode_, s8_.getNextMethodNode_, s8_.growProfile_);
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-exclude doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */) {
                    int count9_ = 0;
                    ForeignObject0Data s9_ = this.foreignObject0_cache;
                    if ((state_0 & 0b1000000000) != 0 /* is-state_0 doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */) {
                        while (s9_ != null) {
                            if ((s9_.interop_.accepts(arguments1Value)) && (!(JSGuards.isUndefined(arguments0Value_))) && (JSRuntime.isForeignObject(arguments1Value))) {
                                break;
                            }
                            s9_ = s9_.next_;
                            count9_++;
                        }
                    }
                    if (s9_ == null) {
                        if ((!(JSGuards.isUndefined(arguments0Value_))) && (JSRuntime.isForeignObject(arguments1Value)) && count9_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s9_.interop_.accepts(arguments1Value));
                            s9_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                            s9_.interop_ = s9_.insertAccessor((INTEROP_LIBRARY_.create(arguments1Value)));
                            s9_.writeOwnNode_ = s9_.insertAccessor((createWriteOwn()));
                            s9_.importValue_ = s9_.insertAccessor((ImportValueNode.create()));
                            s9_.lengthIsUndefined_ = (ConditionProfile.createBinaryProfile());
                            MemoryFence.storeStore();
                            this.foreignObject0_cache = s9_;
                            this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */;
                        }
                    }
                    if (s9_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doForeignObject(arguments0Value_, arguments1Value, arguments2Value, arguments3Value, s9_.interop_, s9_.writeOwnNode_, s9_.importValue_, s9_.lengthIsUndefined_);
                    }
                }
                {
                    InteropLibrary interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((!(JSGuards.isUndefined(arguments0Value_))) && (JSRuntime.isForeignObject(arguments1Value))) {
                                ForeignObject1Data s10_ = super.insert(new ForeignObject1Data());
                                interop__ = (INTEROP_LIBRARY_.getUncached(arguments1Value));
                                s10_.writeOwnNode_ = s10_.insertAccessor((createWriteOwn()));
                                s10_.importValue_ = s10_.insertAccessor((ImportValueNode.create()));
                                s10_.lengthIsUndefined_ = (ConditionProfile.createBinaryProfile());
                                MemoryFence.storeStore();
                                this.foreignObject1_cache = s10_;
                                this.exclude_ = exclude = exclude | 0b10 /* add-exclude doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */;
                                this.foreignObject0_cache = null;
                                state_0 = state_0 & 0xfffffdff /* remove-state_0 doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */;
                                this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return doForeignObject(arguments0Value_, arguments1Value, arguments2Value, arguments3Value, interop__, s10_.writeOwnNode_, s10_.importValue_, s10_.lengthIsUndefined_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
            }
            if ((JSGuards.isUndefined(arguments0Value))) {
                this.state_0_ = state_0 = state_0 | 0b100000000000 /* add-state_0 doUndefinedNewTarget(Object, Object, Object, Object) */;
                lock.unlock();
                hasLock = false;
                return doUndefinedNewTarget(arguments0Value, arguments1Value, arguments2Value, arguments3Value);
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
                ForeignObject0Data s9_ = this.foreignObject0_cache;
                if ((s9_ == null || s9_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[13];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doArrayBuffer";
        if ((state_0 & 0b1) != 0 /* is-state_0 doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.lengthIsUndefined));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDirectArrayBuffer";
        if ((state_0 & 0b10) != 0 /* is-state_0 doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.lengthIsUndefined));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSharedArrayBuffer";
        if ((state_0 & 0b100) != 0 /* is-state_0 doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.lengthIsUndefined));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doInteropArrayBuffer";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doInteropArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.lengthIsUndefined, this.interopArrayBuffer_interop_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doArrayBufferView";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doArrayBufferView(DynamicObject, DynamicObject, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doEmpty";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doEmpty(DynamicObject, DynamicObject, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doIntLength";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 doIntLength(DynamicObject, int, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-exclude doIntLength(DynamicObject, int, Object, Object) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doLength";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 doLength(DynamicObject, Object, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 doObject(DynamicObject, DynamicObject, Object, Object, GetMethodNode, ConditionProfile, WriteElementNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, JSGetLengthNode, ReadElementNode, PropertyGetNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ObjectData s8_ = this.object_cache;
            if (s8_ != null) {
                cached.add(Arrays.asList(s8_.getIteratorMethodNode_, s8_.isIterableProfile_, s8_.writeOwnNode_, s8_.iteratorCallNode_, s8_.isObjectNode_, s8_.iteratorStepNode_, s8_.getIteratorValueNode_, s8_.getLengthNode_, s8_.readNode_, s8_.getNextMethodNode_, s8_.growProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s9_ = this.foreignObject0_cache;
            while (s9_ != null) {
                cached.add(Arrays.asList(s9_.interop_, s9_.writeOwnNode_, s9_.importValue_, s9_.lengthIsUndefined_));
                s9_ = s9_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state_0 & 0b10000000000) != 0 /* is-state_0 doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject1Data s10_ = this.foreignObject1_cache;
            if (s10_ != null) {
                cached.add(Arrays.asList(s10_.writeOwnNode_, s10_.importValue_, s10_.lengthIsUndefined_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doUndefinedNewTarget";
        if ((state_0 & 0b100000000000) != 0 /* is-state_0 doUndefinedNewTarget(Object, Object, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        return Provider.create(data);
    }

    public static JSConstructTypedArrayNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new JSConstructTypedArrayNodeGen(context, builtin, arguments);
    }

    @GeneratedBy(JSConstructTypedArrayNode.class)
    private static final class ObjectData extends Node {

        @Child GetMethodNode getIteratorMethodNode_;
        @CompilationFinal ConditionProfile isIterableProfile_;
        @Child WriteElementNode writeOwnNode_;
        @Child JSFunctionCallNode iteratorCallNode_;
        @Child IsJSObjectNode isObjectNode_;
        @Child IteratorStepNode iteratorStepNode_;
        @Child IteratorValueNode getIteratorValueNode_;
        @Child JSGetLengthNode getLengthNode_;
        @Child ReadElementNode readNode_;
        @Child PropertyGetNode getNextMethodNode_;
        @CompilationFinal BranchProfile growProfile_;

        ObjectData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSConstructTypedArrayNode.class)
    private static final class ForeignObject0Data extends Node {

        @Child ForeignObject0Data next_;
        @Child InteropLibrary interop_;
        @Child WriteElementNode writeOwnNode_;
        @Child ImportValueNode importValue_;
        @CompilationFinal ConditionProfile lengthIsUndefined_;

        ForeignObject0Data(ForeignObject0Data next_) {
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
    @GeneratedBy(JSConstructTypedArrayNode.class)
    private static final class ForeignObject1Data extends Node {

        @Child WriteElementNode writeOwnNode_;
        @Child ImportValueNode importValue_;
        @CompilationFinal ConditionProfile lengthIsUndefined_;

        ForeignObject1Data() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(IntegerIndexedObjectCreateNode.class)
    static final class IntegerIndexedObjectCreateNodeGen extends IntegerIndexedObjectCreateNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private DynamicObject cachedProto_cachedProto_;
        @CompilationFinal private JSObjectFactory cachedProto_objectFactory_;

        private IntegerIndexedObjectCreateNodeGen(JSContext context, TypedArrayFactory factory) {
            super(context, factory);
        }

        @Override
        DynamicObject execute(DynamicObject arg0Value, TypedArray arg1Value, int arg2Value, int arg3Value, DynamicObject arg4Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doDefaultProto(DynamicObject, TypedArray, int, int, DynamicObject) || doMultiContext(DynamicObject, TypedArray, int, int, DynamicObject) || doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) || doUncachedProto(DynamicObject, TypedArray, int, int, DynamicObject) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doDefaultProto(DynamicObject, TypedArray, int, int, DynamicObject) */) {
                    if ((isDefaultPrototype(arg4Value))) {
                        return doDefaultProto(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doMultiContext(DynamicObject, TypedArray, int, int, DynamicObject) */) {
                    if ((!(isDefaultPrototype(arg4Value)))) {
                        assert (context.isMultiContext());
                        return doMultiContext(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */) {
                    if ((!(isDefaultPrototype(arg4Value)))) {
                        assert (!(context.isMultiContext()));
                        if ((arg4Value == this.cachedProto_cachedProto_)) {
                            return doCachedProto(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, this.cachedProto_cachedProto_, this.cachedProto_objectFactory_);
                        }
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doUncachedProto(DynamicObject, TypedArray, int, int, DynamicObject) */) {
                    if ((!(isDefaultPrototype(arg4Value)))) {
                        assert (!(context.isMultiContext()));
                        return doUncachedProto(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
        }

        private DynamicObject executeAndSpecialize(DynamicObject arg0Value, TypedArray arg1Value, int arg2Value, int arg3Value, DynamicObject arg4Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((isDefaultPrototype(arg4Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doDefaultProto(DynamicObject, TypedArray, int, int, DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doDefaultProto(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
                }
                if ((!(isDefaultPrototype(arg4Value))) && (context.isMultiContext())) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doMultiContext(DynamicObject, TypedArray, int, int, DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doMultiContext(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
                }
                if ((exclude) == 0 /* is-not-exclude doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */) {
                    boolean CachedProto_duplicateFound_ = false;
                    if ((state_0 & 0b100) != 0 /* is-state_0 doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */) {
                        if ((!(isDefaultPrototype(arg4Value)))) {
                            assert (!(context.isMultiContext()));
                            if ((arg4Value == this.cachedProto_cachedProto_)) {
                                CachedProto_duplicateFound_ = true;
                            }
                        }
                    }
                    if (!CachedProto_duplicateFound_) {
                        if ((!(isDefaultPrototype(arg4Value))) && (!(context.isMultiContext()))) {
                            // assert (arg4Value == this.cachedProto_cachedProto_);
                            if (((state_0 & 0b100)) == 0 /* is-not-state_0 doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */) {
                                this.cachedProto_cachedProto_ = (arg4Value);
                                this.cachedProto_objectFactory_ = (makeObjectFactory(this.cachedProto_cachedProto_));
                                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */;
                                CachedProto_duplicateFound_ = true;
                            }
                        }
                    }
                    if (CachedProto_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return doCachedProto(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, this.cachedProto_cachedProto_, this.cachedProto_objectFactory_);
                    }
                }
                if ((!(isDefaultPrototype(arg4Value))) && (!(context.isMultiContext()))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */;
                    state_0 = state_0 & 0xfffffffb /* remove-state_0 doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doUncachedProto(DynamicObject, TypedArray, int, int, DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doUncachedProto(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
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
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "doDefaultProto";
            if ((state_0 & 0b1) != 0 /* is-state_0 doDefaultProto(DynamicObject, TypedArray, int, int, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doMultiContext";
            if ((state_0 & 0b10) != 0 /* is-state_0 doMultiContext(DynamicObject, TypedArray, int, int, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doCachedProto";
            if ((state_0 & 0b100) != 0 /* is-state_0 doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.cachedProto_cachedProto_, this.cachedProto_objectFactory_));
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doUncachedProto";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doUncachedProto(DynamicObject, TypedArray, int, int, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static IntegerIndexedObjectCreateNode create(JSContext context, TypedArrayFactory factory) {
            return new IntegerIndexedObjectCreateNodeGen(context, factory);
        }

    }
}
