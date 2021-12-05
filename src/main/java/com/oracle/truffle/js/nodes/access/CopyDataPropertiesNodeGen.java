// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.helper.ListGetNode;
import com.oracle.truffle.js.builtins.helper.ListSizeNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(CopyDataPropertiesNode.class)
@SuppressWarnings("unused")
public final class CopyDataPropertiesNodeGen extends CopyDataPropertiesNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private CopyDataPropertiesData copyDataProperties_cache;
    @Child private CopyDataPropertiesForeign0Data copyDataPropertiesForeign0_cache;
    @Child private CopyDataPropertiesForeign1Data copyDataPropertiesForeign1_cache;

    private CopyDataPropertiesNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    protected Object executeImpl(Object arg0Value, Object arg1Value, Object[] arg2Value, boolean arg3Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 doNullOrUndefined(DynamicObject, Object, Object[], boolean) || copyDataProperties(DynamicObject, DynamicObject, Object[], boolean, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) || copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) || copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state_0 & 0b1) != 0 /* is-state_0 doNullOrUndefined(DynamicObject, Object, Object[], boolean) */) {
                if ((JSGuards.isNullOrUndefined(arg1Value))) {
                    return CopyDataPropertiesNode.doNullOrUndefined(arg0Value_, arg1Value, arg2Value, arg3Value);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 copyDataProperties(DynamicObject, DynamicObject, Object[], boolean, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */ && JSTypes.isDynamicObject(arg1Value)) {
                DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                CopyDataPropertiesData s1_ = this.copyDataProperties_cache;
                if (s1_ != null) {
                    if ((JSGuards.isJSObject(arg1Value_))) {
                        return CopyDataPropertiesNode.copyDataProperties(arg0Value_, arg1Value_, arg2Value, arg3Value, s1_.getNode_, s1_.getOwnProperty_, s1_.listSize_, s1_.listGet_, s1_.classProfile_);
                    }
                }
            }
            if ((state_0 & 0b1100) != 0 /* is-state_0 copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) || copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */) {
                if ((state_0 & 0b100) != 0 /* is-state_0 copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */) {
                    CopyDataPropertiesForeign0Data s2_ = this.copyDataPropertiesForeign0_cache;
                    while (s2_ != null) {
                        if ((s2_.objInterop_.accepts(arg1Value)) && (!(JSGuards.isJSDynamicObject(arg1Value)))) {
                            return copyDataPropertiesForeign(arg0Value_, arg1Value, arg2Value, arg3Value, s2_.objInterop_, s2_.iteratorInterop_, s2_.arrayInterop_, s2_.stringInterop_, s2_.importValue_, s2_.toString_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */) {
                    CopyDataPropertiesForeign1Data s3_ = this.copyDataPropertiesForeign1_cache;
                    if (s3_ != null) {
                        if ((!(JSGuards.isJSDynamicObject(arg1Value)))) {
                            return this.copyDataPropertiesForeign1Boundary(state_0, s3_, arg0Value_, arg1Value, arg2Value, arg3Value);
                        }
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object copyDataPropertiesForeign1Boundary(int state_0, CopyDataPropertiesForeign1Data s3_, DynamicObject arg0Value_, Object arg1Value, Object[] arg2Value, boolean arg3Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary objInterop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                return copyDataPropertiesForeign(arg0Value_, arg1Value, arg2Value, arg3Value, objInterop__, s3_.iteratorInterop_, s3_.arrayInterop_, s3_.stringInterop_, s3_.importValue_, s3_.toString_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private DynamicObject executeAndSpecialize(Object arg0Value, Object arg1Value, Object[] arg2Value, boolean arg3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isNullOrUndefined(arg1Value))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNullOrUndefined(DynamicObject, Object, Object[], boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return CopyDataPropertiesNode.doNullOrUndefined(arg0Value_, arg1Value, arg2Value, arg3Value);
                }
                if (JSTypes.isDynamicObject(arg1Value)) {
                    DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                    if ((JSGuards.isJSObject(arg1Value_))) {
                        CopyDataPropertiesData s1_ = super.insert(new CopyDataPropertiesData());
                        s1_.getNode_ = s1_.insertAccessor((ReadElementNode.create(context)));
                        s1_.getOwnProperty_ = s1_.insertAccessor((JSGetOwnPropertyNode.create(false)));
                        s1_.listSize_ = s1_.insertAccessor((ListSizeNode.create()));
                        s1_.listGet_ = s1_.insertAccessor((ListGetNode.create()));
                        s1_.classProfile_ = (JSClassProfile.create());
                        MemoryFence.storeStore();
                        this.copyDataProperties_cache = s1_;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 copyDataProperties(DynamicObject, DynamicObject, Object[], boolean, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return CopyDataPropertiesNode.copyDataProperties(arg0Value_, arg1Value_, arg2Value, arg3Value, s1_.getNode_, s1_.getOwnProperty_, s1_.listSize_, s1_.listGet_, s1_.classProfile_);
                    }
                }
                if ((exclude) == 0 /* is-not-exclude copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */) {
                    int count2_ = 0;
                    CopyDataPropertiesForeign0Data s2_ = this.copyDataPropertiesForeign0_cache;
                    if ((state_0 & 0b100) != 0 /* is-state_0 copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */) {
                        while (s2_ != null) {
                            if ((s2_.objInterop_.accepts(arg1Value)) && (!(JSGuards.isJSDynamicObject(arg1Value)))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        if ((!(JSGuards.isJSDynamicObject(arg1Value))) && count2_ < (JSConfig.InteropLibraryLimit)) {
                            // assert (s2_.objInterop_.accepts(arg1Value));
                            s2_ = super.insert(new CopyDataPropertiesForeign0Data(copyDataPropertiesForeign0_cache));
                            s2_.objInterop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                            s2_.iteratorInterop_ = s2_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                            s2_.arrayInterop_ = s2_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                            s2_.stringInterop_ = s2_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                            s2_.importValue_ = s2_.insertAccessor((ImportValueNode.create()));
                            s2_.toString_ = s2_.insertAccessor((JSToStringNode.create()));
                            MemoryFence.storeStore();
                            this.copyDataPropertiesForeign0_cache = s2_;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return copyDataPropertiesForeign(arg0Value_, arg1Value, arg2Value, arg3Value, s2_.objInterop_, s2_.iteratorInterop_, s2_.arrayInterop_, s2_.stringInterop_, s2_.importValue_, s2_.toString_);
                    }
                }
                {
                    InteropLibrary objInterop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((!(JSGuards.isJSDynamicObject(arg1Value)))) {
                                CopyDataPropertiesForeign1Data s3_ = super.insert(new CopyDataPropertiesForeign1Data());
                                objInterop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s3_.iteratorInterop_ = s3_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                s3_.arrayInterop_ = s3_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                s3_.stringInterop_ = s3_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                                s3_.importValue_ = s3_.insertAccessor((ImportValueNode.create()));
                                s3_.toString_ = s3_.insertAccessor((JSToStringNode.create()));
                                MemoryFence.storeStore();
                                this.copyDataPropertiesForeign1_cache = s3_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */;
                                this.copyDataPropertiesForeign0_cache = null;
                                state_0 = state_0 & 0xfffffffb /* remove-state_0 copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */;
                                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */;
                                lock.unlock();
                                hasLock = false;
                                return copyDataPropertiesForeign(arg0Value_, arg1Value, arg2Value, arg3Value, objInterop__, s3_.iteratorInterop_, s3_.arrayInterop_, s3_.stringInterop_, s3_.importValue_, s3_.toString_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value);
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
                CopyDataPropertiesForeign0Data s2_ = this.copyDataPropertiesForeign0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
        s[0] = "doNullOrUndefined";
        if ((state_0 & 0b1) != 0 /* is-state_0 doNullOrUndefined(DynamicObject, Object, Object[], boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "copyDataProperties";
        if ((state_0 & 0b10) != 0 /* is-state_0 copyDataProperties(DynamicObject, DynamicObject, Object[], boolean, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CopyDataPropertiesData s1_ = this.copyDataProperties_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.getNode_, s1_.getOwnProperty_, s1_.listSize_, s1_.listGet_, s1_.classProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "copyDataPropertiesForeign";
        if ((state_0 & 0b100) != 0 /* is-state_0 copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CopyDataPropertiesForeign0Data s2_ = this.copyDataPropertiesForeign0_cache;
            while (s2_ != null) {
                cached.add(Arrays.asList(s2_.objInterop_, s2_.iteratorInterop_, s2_.arrayInterop_, s2_.stringInterop_, s2_.importValue_, s2_.toString_));
                s2_ = s2_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "copyDataPropertiesForeign";
        if ((state_0 & 0b1000) != 0 /* is-state_0 copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode, JSToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CopyDataPropertiesForeign1Data s3_ = this.copyDataPropertiesForeign1_cache;
            if (s3_ != null) {
                cached.add(Arrays.asList(s3_.iteratorInterop_, s3_.arrayInterop_, s3_.stringInterop_, s3_.importValue_, s3_.toString_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static CopyDataPropertiesNode create(JSContext context) {
        return new CopyDataPropertiesNodeGen(context);
    }

    @GeneratedBy(CopyDataPropertiesNode.class)
    private static final class CopyDataPropertiesData extends Node {

        @Child ReadElementNode getNode_;
        @Child JSGetOwnPropertyNode getOwnProperty_;
        @Child ListSizeNode listSize_;
        @Child ListGetNode listGet_;
        @CompilationFinal JSClassProfile classProfile_;

        CopyDataPropertiesData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(CopyDataPropertiesNode.class)
    private static final class CopyDataPropertiesForeign0Data extends Node {

        @Child CopyDataPropertiesForeign0Data next_;
        @Child InteropLibrary objInterop_;
        @Child InteropLibrary iteratorInterop_;
        @Child InteropLibrary arrayInterop_;
        @Child InteropLibrary stringInterop_;
        @Child ImportValueNode importValue_;
        @Child JSToStringNode toString_;

        CopyDataPropertiesForeign0Data(CopyDataPropertiesForeign0Data next_) {
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
    @GeneratedBy(CopyDataPropertiesNode.class)
    private static final class CopyDataPropertiesForeign1Data extends Node {

        @Child InteropLibrary iteratorInterop_;
        @Child InteropLibrary arrayInterop_;
        @Child InteropLibrary stringInterop_;
        @Child ImportValueNode importValue_;
        @Child JSToStringNode toString_;

        CopyDataPropertiesForeign1Data() {
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
