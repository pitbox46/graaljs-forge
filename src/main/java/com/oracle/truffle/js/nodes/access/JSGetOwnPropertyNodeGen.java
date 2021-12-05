// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.Property;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.cast.ToArrayIndexNode;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import com.oracle.truffle.js.runtime.objects.PropertyDescriptor;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSGetOwnPropertyNode.class)
public final class JSGetOwnPropertyNodeGen extends JSGetOwnPropertyNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private UsesOrdinaryGetOwnPropertyNode usesOrdinaryGetOwnProperty;
    @Child private ArrayData array_cache;
    @CompilationFinal private ConditionProfile getOwnPropertyString_stringCaseProfile_;
    @CompilationFinal private CachedOrdinaryData cachedOrdinary_cache;
    @CompilationFinal private JSClassProfile generic_jsclassProfile_;

    private JSGetOwnPropertyNodeGen(boolean needValue, boolean needEnumerability, boolean needConfigurability, boolean needWritability, boolean allowCaching) {
        super(needValue, needEnumerability, needConfigurability, needWritability, allowCaching);
    }

    @ExplodeLoop
    @Override
    public PropertyDescriptor execute(DynamicObject arg0Value, Object arg1Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 array(DynamicObject, Object, ToArrayIndexNode, BranchProfile, ValueProfile) || getOwnPropertyString(DynamicObject, Object, ConditionProfile) || cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) || uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode) || generic(DynamicObject, Object, JSClassProfile, UsesOrdinaryGetOwnPropertyNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 array(DynamicObject, Object, ToArrayIndexNode, BranchProfile, ValueProfile) */) {
                ArrayData s0_ = this.array_cache;
                if (s0_ != null) {
                    if ((JSGuards.isJSArray(arg0Value))) {
                        return array(arg0Value, arg1Value, s0_.toArrayIndexNode_, s0_.noSuchElementBranch_, s0_.typeProfile_);
                    }
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 getOwnPropertyString(DynamicObject, Object, ConditionProfile) */) {
                if ((JSGuards.isJSString(arg0Value))) {
                    return getOwnPropertyString(arg0Value, arg1Value, this.getOwnPropertyString_stringCaseProfile_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */) {
                assert (allowCaching);
                CachedOrdinaryData s2_ = this.cachedOrdinary_cache;
                while (s2_ != null) {
                    if (!Assumption.isValidAssumption(s2_.assumption0_)) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        removeCachedOrdinary_(s2_);
                        return executeAndSpecialize(arg0Value, arg1Value);
                    }
                    assert (s2_.cachedJSClass_ != null);
                    if ((s2_.cachedJSClass_.isInstance(arg0Value)) && (JSRuntime.propertyKeyEquals(s2_.cachedPropertyKey_, arg1Value)) && (s2_.cachedShape_ == arg0Value.getShape())) {
                        return cachedOrdinary(arg0Value, arg1Value, s2_.cachedJSClass_, s2_.cachedShape_, s2_.cachedPropertyKey_, s2_.cachedProperty_);
                    }
                    s2_ = s2_.next_;
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode) */) {
                if ((this.usesOrdinaryGetOwnProperty.execute(arg0Value))) {
                    return uncachedOrdinary(arg0Value, arg1Value, this.usesOrdinaryGetOwnProperty);
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 generic(DynamicObject, Object, JSClassProfile, UsesOrdinaryGetOwnPropertyNode) */) {
                if ((!(this.usesOrdinaryGetOwnProperty.execute(arg0Value))) && (!(JSGuards.isJSArray(arg0Value))) && (!(JSGuards.isJSString(arg0Value)))) {
                    return JSGetOwnPropertyNode.generic(arg0Value, arg1Value, this.generic_jsclassProfile_, this.usesOrdinaryGetOwnProperty);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private PropertyDescriptor executeAndSpecialize(DynamicObject arg0Value, Object arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((JSGuards.isJSArray(arg0Value))) {
                ArrayData s0_ = super.insert(new ArrayData());
                s0_.toArrayIndexNode_ = s0_.insertAccessor((ToArrayIndexNode.create()));
                s0_.noSuchElementBranch_ = (BranchProfile.create());
                s0_.typeProfile_ = (ValueProfile.createIdentityProfile());
                MemoryFence.storeStore();
                this.array_cache = s0_;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 array(DynamicObject, Object, ToArrayIndexNode, BranchProfile, ValueProfile) */;
                lock.unlock();
                hasLock = false;
                return array(arg0Value, arg1Value, s0_.toArrayIndexNode_, s0_.noSuchElementBranch_, s0_.typeProfile_);
            }
            if ((JSGuards.isJSString(arg0Value))) {
                this.getOwnPropertyString_stringCaseProfile_ = (ConditionProfile.createBinaryProfile());
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getOwnPropertyString(DynamicObject, Object, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return getOwnPropertyString(arg0Value, arg1Value, this.getOwnPropertyString_stringCaseProfile_);
            }
            if ((exclude) == 0 /* is-not-exclude cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */ && (allowCaching)) {
                int count2_ = 0;
                CachedOrdinaryData s2_ = this.cachedOrdinary_cache;
                if ((state_0 & 0b100) != 0 /* is-state_0 cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */) {
                    while (s2_ != null) {
                        assert (s2_.cachedJSClass_ != null);
                        if ((s2_.cachedJSClass_.isInstance(arg0Value)) && (JSRuntime.propertyKeyEquals(s2_.cachedPropertyKey_, arg1Value)) && (s2_.cachedShape_ == arg0Value.getShape()) && (s2_.assumption0_ == null || Assumption.isValidAssumption(s2_.assumption0_))) {
                            break;
                        }
                        s2_ = s2_.next_;
                        count2_++;
                    }
                }
                if (s2_ == null) {
                    {
                        JSClass cachedJSClass__ = (JSGetOwnPropertyNode.getJSClassIfOrdinary(arg0Value));
                        if ((cachedJSClass__ != null) && (cachedJSClass__.isInstance(arg0Value))) {
                            Object cachedPropertyKey__ = (arg1Value);
                            if ((JSRuntime.propertyKeyEquals(cachedPropertyKey__, arg1Value))) {
                                Shape cachedShape__ = (arg0Value.getShape());
                                if ((cachedShape__ == arg0Value.getShape())) {
                                    Assumption assumption0 = (cachedShape__.getValidAssumption());
                                    if (Assumption.isValidAssumption(assumption0)) {
                                        if (count2_ < (3)) {
                                            s2_ = new CachedOrdinaryData(cachedOrdinary_cache);
                                            s2_.cachedJSClass_ = cachedJSClass__;
                                            s2_.cachedShape_ = cachedShape__;
                                            s2_.cachedPropertyKey_ = cachedPropertyKey__;
                                            s2_.cachedProperty_ = (cachedShape__.getProperty(arg1Value));
                                            s2_.assumption0_ = assumption0;
                                            MemoryFence.storeStore();
                                            this.cachedOrdinary_cache = s2_;
                                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (s2_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return cachedOrdinary(arg0Value, arg1Value, s2_.cachedJSClass_, s2_.cachedShape_, s2_.cachedPropertyKey_, s2_.cachedProperty_);
                }
            }
            boolean UncachedOrdinary_duplicateFound_ = false;
            if ((state_0 & 0b1000) != 0 /* is-state_0 uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode) */) {
                if ((this.usesOrdinaryGetOwnProperty.execute(arg0Value))) {
                    UncachedOrdinary_duplicateFound_ = true;
                }
            }
            if (!UncachedOrdinary_duplicateFound_) {
                {
                    UsesOrdinaryGetOwnPropertyNode uncachedOrdinary_usesOrdinaryGetOwnProperty__ = super.insert(this.usesOrdinaryGetOwnProperty == null ? ((UsesOrdinaryGetOwnPropertyNode.create())) : this.usesOrdinaryGetOwnProperty);
                    if ((uncachedOrdinary_usesOrdinaryGetOwnProperty__.execute(arg0Value)) && ((state_0 & 0b1000)) == 0 /* is-not-state_0 uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode) */) {
                        if (this.usesOrdinaryGetOwnProperty == null) {
                            UsesOrdinaryGetOwnPropertyNode uncachedOrdinary_usesOrdinaryGetOwnProperty___check = super.insert(uncachedOrdinary_usesOrdinaryGetOwnProperty__);
                            if (uncachedOrdinary_usesOrdinaryGetOwnProperty___check == null) {
                                throw new AssertionError("Specialization 'uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode)' contains a shared cache with name 'usesOrdinaryGetOwnProperty' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.usesOrdinaryGetOwnProperty = uncachedOrdinary_usesOrdinaryGetOwnProperty___check;
                        }
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */;
                        this.cachedOrdinary_cache = null;
                        state_0 = state_0 & 0xfffffffb /* remove-state_0 cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */;
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode) */;
                        UncachedOrdinary_duplicateFound_ = true;
                    }
                }
            }
            if (UncachedOrdinary_duplicateFound_) {
                lock.unlock();
                hasLock = false;
                return uncachedOrdinary(arg0Value, arg1Value, this.usesOrdinaryGetOwnProperty);
            }
            boolean Generic_duplicateFound_ = false;
            if ((state_0 & 0b10000) != 0 /* is-state_0 generic(DynamicObject, Object, JSClassProfile, UsesOrdinaryGetOwnPropertyNode) */) {
                if ((!(this.usesOrdinaryGetOwnProperty.execute(arg0Value))) && (!(JSGuards.isJSArray(arg0Value))) && (!(JSGuards.isJSString(arg0Value)))) {
                    Generic_duplicateFound_ = true;
                }
            }
            if (!Generic_duplicateFound_) {
                {
                    UsesOrdinaryGetOwnPropertyNode generic_usesOrdinaryGetOwnProperty__ = super.insert(this.usesOrdinaryGetOwnProperty == null ? ((UsesOrdinaryGetOwnPropertyNode.create())) : this.usesOrdinaryGetOwnProperty);
                    if ((!(generic_usesOrdinaryGetOwnProperty__.execute(arg0Value))) && (!(JSGuards.isJSArray(arg0Value))) && (!(JSGuards.isJSString(arg0Value))) && ((state_0 & 0b10000)) == 0 /* is-not-state_0 generic(DynamicObject, Object, JSClassProfile, UsesOrdinaryGetOwnPropertyNode) */) {
                        this.generic_jsclassProfile_ = (JSClassProfile.create());
                        if (this.usesOrdinaryGetOwnProperty == null) {
                            UsesOrdinaryGetOwnPropertyNode generic_usesOrdinaryGetOwnProperty___check = super.insert(generic_usesOrdinaryGetOwnProperty__);
                            if (generic_usesOrdinaryGetOwnProperty___check == null) {
                                throw new AssertionError("Specialization 'generic(DynamicObject, Object, JSClassProfile, UsesOrdinaryGetOwnPropertyNode)' contains a shared cache with name 'usesOrdinaryGetOwnProperty' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.usesOrdinaryGetOwnProperty = generic_usesOrdinaryGetOwnProperty___check;
                        }
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 generic(DynamicObject, Object, JSClassProfile, UsesOrdinaryGetOwnPropertyNode) */;
                        Generic_duplicateFound_ = true;
                    }
                }
            }
            if (Generic_duplicateFound_) {
                lock.unlock();
                hasLock = false;
                return JSGetOwnPropertyNode.generic(arg0Value, arg1Value, this.generic_jsclassProfile_, this.usesOrdinaryGetOwnProperty);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                CachedOrdinaryData s2_ = this.cachedOrdinary_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    void removeCachedOrdinary_(Object s2_) {
        Lock lock = getLock();
        lock.lock();
        try {
            CachedOrdinaryData prev = null;
            CachedOrdinaryData cur = this.cachedOrdinary_cache;
            while (cur != null) {
                if (cur == s2_) {
                    if (prev == null) {
                        this.cachedOrdinary_cache = cur.next_;
                    } else {
                        prev.next_ = cur.next_;
                    }
                    break;
                }
                prev = cur;
                cur = cur.next_;
            }
            if (this.cachedOrdinary_cache == null) {
                this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "array";
        if ((state_0 & 0b1) != 0 /* is-state_0 array(DynamicObject, Object, ToArrayIndexNode, BranchProfile, ValueProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ArrayData s0_ = this.array_cache;
            if (s0_ != null) {
                cached.add(Arrays.asList(s0_.toArrayIndexNode_, s0_.noSuchElementBranch_, s0_.typeProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "getOwnPropertyString";
        if ((state_0 & 0b10) != 0 /* is-state_0 getOwnPropertyString(DynamicObject, Object, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.getOwnPropertyString_stringCaseProfile_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "cachedOrdinary";
        if ((state_0 & 0b100) != 0 /* is-state_0 cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedOrdinaryData s2_ = this.cachedOrdinary_cache;
            while (s2_ != null) {
                cached.add(Arrays.asList(s2_.cachedJSClass_, s2_.cachedShape_, s2_.cachedPropertyKey_, s2_.cachedProperty_));
                s2_ = s2_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "uncachedOrdinary";
        if ((state_0 & 0b1000) != 0 /* is-state_0 uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.usesOrdinaryGetOwnProperty));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "generic";
        if ((state_0 & 0b10000) != 0 /* is-state_0 generic(DynamicObject, Object, JSClassProfile, UsesOrdinaryGetOwnPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.generic_jsclassProfile_, this.usesOrdinaryGetOwnProperty));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static JSGetOwnPropertyNode create(boolean needValue, boolean needEnumerability, boolean needConfigurability, boolean needWritability, boolean allowCaching) {
        return new JSGetOwnPropertyNodeGen(needValue, needEnumerability, needConfigurability, needWritability, allowCaching);
    }

    @GeneratedBy(JSGetOwnPropertyNode.class)
    private static final class ArrayData extends Node {

        @Child ToArrayIndexNode toArrayIndexNode_;
        @CompilationFinal BranchProfile noSuchElementBranch_;
        @CompilationFinal ValueProfile typeProfile_;

        ArrayData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSGetOwnPropertyNode.class)
    private static final class CachedOrdinaryData {

        @CompilationFinal CachedOrdinaryData next_;
        @CompilationFinal JSClass cachedJSClass_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal Object cachedPropertyKey_;
        @CompilationFinal Property cachedProperty_;
        @CompilationFinal Assumption assumption0_;

        CachedOrdinaryData(CachedOrdinaryData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(UsesOrdinaryGetOwnPropertyNode.class)
    public static final class UsesOrdinaryGetOwnPropertyNodeGen extends UsesOrdinaryGetOwnPropertyNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private UsesOrdinaryGetOwnPropertyNodeGen() {
        }

        @ExplodeLoop
        @Override
        public boolean execute(JSClass arg0Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(JSClass, JSClass) || doObjectPrototype(JSClass) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(JSClass, JSClass) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((arg0Value == s0_.cachedJSClass_)) {
                            return UsesOrdinaryGetOwnPropertyNode.doCached(arg0Value, s0_.cachedJSClass_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doObjectPrototype(JSClass) */) {
                    return UsesOrdinaryGetOwnPropertyNode.doObjectPrototype(arg0Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private boolean executeAndSpecialize(JSClass arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(JSClass, JSClass) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(JSClass, JSClass) */) {
                        while (s0_ != null) {
                            if ((arg0Value == s0_.cachedJSClass_)) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        // assert (arg0Value == s0_.cachedJSClass_);
                        if (count0_ < (7)) {
                            s0_ = new CachedData(cached_cache);
                            s0_.cachedJSClass_ = (arg0Value);
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(JSClass, JSClass) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return UsesOrdinaryGetOwnPropertyNode.doCached(arg0Value, s0_.cachedJSClass_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(JSClass, JSClass) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(JSClass, JSClass) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doObjectPrototype(JSClass) */;
                lock.unlock();
                hasLock = false;
                return UsesOrdinaryGetOwnPropertyNode.doObjectPrototype(arg0Value);
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
                    CachedData s0_ = this.cached_cache;
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
            s[0] = "doCached";
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(JSClass, JSClass) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.cachedJSClass_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doCached(JSClass, JSClass) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doObjectPrototype";
            if ((state_0 & 0b10) != 0 /* is-state_0 doObjectPrototype(JSClass) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static UsesOrdinaryGetOwnPropertyNode create() {
            return new UsesOrdinaryGetOwnPropertyNodeGen();
        }

        @GeneratedBy(UsesOrdinaryGetOwnPropertyNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal JSClass cachedJSClass_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
    @GeneratedBy(GetPropertyProxyValueNode.class)
    public static final class GetPropertyProxyValueNodeGen extends GetPropertyProxyValueNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private GetPropertyProxyValueNodeGen() {
        }

        @ExplodeLoop
        @Override
        public Object execute(DynamicObject arg0Value, Object arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(DynamicObject, Object, Class<>) || doUncached(DynamicObject, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Object, Class<>) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((arg1Value.getClass() == s0_.cachedClass_)) {
                            return GetPropertyProxyValueNode.doCached(arg0Value, arg1Value, s0_.cachedClass_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(DynamicObject, Object) */) {
                    return GetPropertyProxyValueNode.doUncached(arg0Value, arg1Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private Object executeAndSpecialize(DynamicObject arg0Value, Object arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(DynamicObject, Object, Class<>) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Object, Class<>) */) {
                        while (s0_ != null) {
                            if ((arg1Value.getClass() == s0_.cachedClass_)) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        {
                            Class<?> cachedClass__ = (arg1Value.getClass());
                            if ((arg1Value.getClass() == cachedClass__) && count0_ < (5)) {
                                s0_ = new CachedData(cached_cache);
                                s0_.cachedClass_ = cachedClass__;
                                MemoryFence.storeStore();
                                this.cached_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, Object, Class<>) */;
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return GetPropertyProxyValueNode.doCached(arg0Value, arg1Value, s0_.cachedClass_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(DynamicObject, Object, Class<>) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(DynamicObject, Object, Class<>) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(DynamicObject, Object) */;
                lock.unlock();
                hasLock = false;
                return GetPropertyProxyValueNode.doUncached(arg0Value, arg1Value);
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
                    CachedData s0_ = this.cached_cache;
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
            s[0] = "doCached";
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, Object, Class<>) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.cachedClass_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doCached(DynamicObject, Object, Class<>) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doUncached";
            if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static GetPropertyProxyValueNode create() {
            return new GetPropertyProxyValueNodeGen();
        }

        @GeneratedBy(GetPropertyProxyValueNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal Class<?> cachedClass_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
}
