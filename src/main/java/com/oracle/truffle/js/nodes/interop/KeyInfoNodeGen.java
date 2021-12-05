// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.object.Property;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.access.GetPrototypeNode;
import com.oracle.truffle.js.nodes.access.GetPrototypeNodeGen;
import com.oracle.truffle.js.nodes.access.IsExtensibleNode;
import com.oracle.truffle.js.nodes.access.IsExtensibleNodeGen;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNodeGen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(KeyInfoNode.class)
public final class KeyInfoNodeGen extends KeyInfoNode implements Introspection.Provider {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private CachedOwnPropertyData cachedOwnProperty_cache;
    @Child private MemberData member_cache;

    private KeyInfoNodeGen() {
    }

    @ExplodeLoop
    @Override
    public boolean execute(DynamicObject arg0Value, String arg1Value, int arg2Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 cachedOwnProperty(DynamicObject, String, int, DynamicObjectLibrary, Property, IsCallableNode, BranchProfile) || member(DynamicObject, String, int, GetPrototypeNode, IsCallableNode, IsExtensibleNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 cachedOwnProperty(DynamicObject, String, int, DynamicObjectLibrary, Property, IsCallableNode, BranchProfile) */) {
                CachedOwnPropertyData s0_ = this.cachedOwnProperty_cache;
                while (s0_ != null) {
                    if ((s0_.objectLibrary_.accepts(arg0Value)) && (!(JSGuards.isJSProxy(arg0Value)))) {
                        Property property__ = (s0_.objectLibrary_.getProperty(arg0Value, arg1Value));
                        if ((property__ != null)) {
                            return KeyInfoNode.cachedOwnProperty(arg0Value, arg1Value, arg2Value, s0_.objectLibrary_, property__, s0_.isCallable_, s0_.proxyBranch_);
                        }
                    }
                    s0_ = s0_.next_;
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 member(DynamicObject, String, int, GetPrototypeNode, IsCallableNode, IsExtensibleNode) */) {
                MemberData s1_ = this.member_cache;
                if (s1_ != null) {
                    return KeyInfoNode.member(arg0Value, arg1Value, arg2Value, s1_.getPrototype_, s1_.isCallable_, s1_.isExtensible_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private boolean executeAndSpecialize(DynamicObject arg0Value, String arg1Value, int arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            {
                Property property__ = null;
                if ((exclude) == 0 /* is-not-exclude cachedOwnProperty(DynamicObject, String, int, DynamicObjectLibrary, Property, IsCallableNode, BranchProfile) */) {
                    int count0_ = 0;
                    CachedOwnPropertyData s0_ = this.cachedOwnProperty_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 cachedOwnProperty(DynamicObject, String, int, DynamicObjectLibrary, Property, IsCallableNode, BranchProfile) */) {
                        while (s0_ != null) {
                            if ((s0_.objectLibrary_.accepts(arg0Value)) && (!(JSGuards.isJSProxy(arg0Value)))) {
                                property__ = (s0_.objectLibrary_.getProperty(arg0Value, arg1Value));
                                if ((property__ != null)) {
                                    break;
                                }
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        if ((!(JSGuards.isJSProxy(arg0Value)))) {
                            // assert (s0_.objectLibrary_.accepts(arg0Value));
                            DynamicObjectLibrary objectLibrary__ = super.insert((DYNAMIC_OBJECT_LIBRARY_.create(arg0Value)));
                            property__ = (objectLibrary__.getProperty(arg0Value, arg1Value));
                            if ((property__ != null) && count0_ < (2)) {
                                s0_ = super.insert(new CachedOwnPropertyData(cachedOwnProperty_cache));
                                s0_.objectLibrary_ = s0_.insertAccessor(objectLibrary__);
                                s0_.isCallable_ = s0_.insertAccessor((IsCallableNode.create()));
                                s0_.proxyBranch_ = (BranchProfile.create());
                                MemoryFence.storeStore();
                                this.cachedOwnProperty_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 cachedOwnProperty(DynamicObject, String, int, DynamicObjectLibrary, Property, IsCallableNode, BranchProfile) */;
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return KeyInfoNode.cachedOwnProperty(arg0Value, arg1Value, arg2Value, s0_.objectLibrary_, property__, s0_.isCallable_, s0_.proxyBranch_);
                    }
                }
            }
            MemberData s1_ = super.insert(new MemberData());
            s1_.getPrototype_ = s1_.insertAccessor((GetPrototypeNode.create()));
            s1_.isCallable_ = s1_.insertAccessor((IsCallableNode.create()));
            s1_.isExtensible_ = s1_.insertAccessor((IsExtensibleNode.create()));
            MemoryFence.storeStore();
            this.member_cache = s1_;
            this.exclude_ = exclude = exclude | 0b1 /* add-exclude cachedOwnProperty(DynamicObject, String, int, DynamicObjectLibrary, Property, IsCallableNode, BranchProfile) */;
            this.cachedOwnProperty_cache = null;
            state_0 = state_0 & 0xfffffffe /* remove-state_0 cachedOwnProperty(DynamicObject, String, int, DynamicObjectLibrary, Property, IsCallableNode, BranchProfile) */;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 member(DynamicObject, String, int, GetPrototypeNode, IsCallableNode, IsExtensibleNode) */;
            lock.unlock();
            hasLock = false;
            return KeyInfoNode.member(arg0Value, arg1Value, arg2Value, s1_.getPrototype_, s1_.isCallable_, s1_.isExtensible_);
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
                CachedOwnPropertyData s0_ = this.cachedOwnProperty_cache;
                if ((s0_ == null || s0_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
        s[0] = "cachedOwnProperty";
        if ((state_0 & 0b1) != 0 /* is-state_0 cachedOwnProperty(DynamicObject, String, int, DynamicObjectLibrary, Property, IsCallableNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedOwnPropertyData s0_ = this.cachedOwnProperty_cache;
            while (s0_ != null) {
                cached.add(Arrays.asList(s0_.objectLibrary_, s0_.isCallable_, s0_.proxyBranch_));
                s0_ = s0_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude cachedOwnProperty(DynamicObject, String, int, DynamicObjectLibrary, Property, IsCallableNode, BranchProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "member";
        if ((state_0 & 0b10) != 0 /* is-state_0 member(DynamicObject, String, int, GetPrototypeNode, IsCallableNode, IsExtensibleNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            MemberData s1_ = this.member_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.getPrototype_, s1_.isCallable_, s1_.isExtensible_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static KeyInfoNode create() {
        return new KeyInfoNodeGen();
    }

    public static KeyInfoNode getUncached() {
        return KeyInfoNodeGen.UNCACHED;
    }

    @GeneratedBy(KeyInfoNode.class)
    private static final class CachedOwnPropertyData extends Node {

        @Child CachedOwnPropertyData next_;
        @Child DynamicObjectLibrary objectLibrary_;
        @Child IsCallableNode isCallable_;
        @CompilationFinal BranchProfile proxyBranch_;

        CachedOwnPropertyData(CachedOwnPropertyData next_) {
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
    @GeneratedBy(KeyInfoNode.class)
    private static final class MemberData extends Node {

        @Child GetPrototypeNode getPrototype_;
        @Child IsCallableNode isCallable_;
        @Child IsExtensibleNode isExtensible_;

        MemberData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(KeyInfoNode.class)
    private static final class Uncached extends KeyInfoNode {

        @TruffleBoundary
        @Override
        public boolean execute(DynamicObject arg0Value, String arg1Value, int arg2Value) {
            return KeyInfoNode.member(arg0Value, arg1Value, arg2Value, (GetPrototypeNodeGen.getUncached()), (IsCallableNodeGen.getUncached()), (IsExtensibleNodeGen.getUncached()));
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
