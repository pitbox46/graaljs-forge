// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

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
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.array.ArrayLengthNode.ArrayLengthReadNode;
import com.oracle.truffle.js.nodes.array.ArrayLengthNode.SetArrayLengthNode;
import com.oracle.truffle.js.nodes.array.ArrayLengthNode.SetArrayLengthOrDeleteNode;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import com.oracle.truffle.js.runtime.array.ScriptArray.ProfileHolder;
import com.oracle.truffle.js.runtime.builtins.JSArrayBase;
import com.oracle.truffle.js.runtime.builtins.JSTypedArrayObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ArrayLengthNode.class)
public final class ArrayLengthNodeFactory {

    @GeneratedBy(ArrayLengthReadNode.class)
    public static final class ArrayLengthReadNodeGen extends ArrayLengthReadNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private ScriptArray intLength_arrayType_;

        private ArrayLengthReadNodeGen() {
        }

        @Override
        public Object executeObject(DynamicObject arg0Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doTypedArray(JSTypedArrayObject) */ && arg0Value instanceof JSTypedArrayObject) {
                JSTypedArrayObject arg0Value_ = (JSTypedArrayObject) arg0Value;
                return ArrayLengthReadNode.doTypedArray(arg0Value_);
            }
            if ((state_0 & 0b1110) != 0 /* is-state_0 doIntLength(JSArrayBase, ScriptArray) || doUncachedIntLength(JSArrayBase) || doUncachedLongLength(JSArrayBase) */ && arg0Value instanceof JSArrayBase) {
                JSArrayBase arg0Value_ = (JSArrayBase) arg0Value;
                if ((state_0 & 0b10) != 0 /* is-state_0 doIntLength(JSArrayBase, ScriptArray) */) {
                    if ((this.intLength_arrayType_.isInstance(arg0Value_.getArrayType()))) {
                        assert (ArrayLengthReadNode.isLengthAlwaysInt(this.intLength_arrayType_));
                        return ArrayLengthReadNode.doIntLength(arg0Value_, this.intLength_arrayType_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doUncachedIntLength(JSArrayBase) */) {
                    try {
                        return ArrayLengthReadNode.doUncachedIntLength(arg0Value_);
                    } catch (UnexpectedResultException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b10 /* add-exclude doUncachedIntLength(JSArrayBase) */;
                            this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 doUncachedIntLength(JSArrayBase) */;
                        } finally {
                            lock.unlock();
                        }
                        return ex.getResult();
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doUncachedLongLength(JSArrayBase) */) {
                    return ArrayLengthReadNode.doUncachedLongLength(arg0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        @Override
        public int executeInt(DynamicObject arg0Value) throws UnexpectedResultException {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doTypedArray(JSTypedArrayObject) */ && arg0Value instanceof JSTypedArrayObject) {
                JSTypedArrayObject arg0Value_ = (JSTypedArrayObject) arg0Value;
                return ArrayLengthReadNode.doTypedArray(arg0Value_);
            }
            if ((state_0 & 0b110) != 0 /* is-state_0 doIntLength(JSArrayBase, ScriptArray) || doUncachedIntLength(JSArrayBase) */ && arg0Value instanceof JSArrayBase) {
                JSArrayBase arg0Value_ = (JSArrayBase) arg0Value;
                if ((state_0 & 0b10) != 0 /* is-state_0 doIntLength(JSArrayBase, ScriptArray) */) {
                    if ((this.intLength_arrayType_.isInstance(arg0Value_.getArrayType()))) {
                        assert (ArrayLengthReadNode.isLengthAlwaysInt(this.intLength_arrayType_));
                        return ArrayLengthReadNode.doIntLength(arg0Value_, this.intLength_arrayType_);
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doUncachedIntLength(JSArrayBase) */) {
                    try {
                        return ArrayLengthReadNode.doUncachedIntLength(arg0Value_);
                    } catch (UnexpectedResultException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b10 /* add-exclude doUncachedIntLength(JSArrayBase) */;
                            this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 doUncachedIntLength(JSArrayBase) */;
                        } finally {
                            lock.unlock();
                        }
                        return JSTypesGen.expectInteger(ex.getResult());
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arg0Value));
        }

        private Object executeAndSpecialize(DynamicObject arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (arg0Value instanceof JSTypedArrayObject) {
                    JSTypedArrayObject arg0Value_ = (JSTypedArrayObject) arg0Value;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doTypedArray(JSTypedArrayObject) */;
                    lock.unlock();
                    hasLock = false;
                    return ArrayLengthReadNode.doTypedArray(arg0Value_);
                }
                if (arg0Value instanceof JSArrayBase) {
                    JSArrayBase arg0Value_ = (JSArrayBase) arg0Value;
                    if (((exclude & 0b1)) == 0 /* is-not-exclude doIntLength(JSArrayBase, ScriptArray) */) {
                        boolean IntLength_duplicateFound_ = false;
                        if ((state_0 & 0b10) != 0 /* is-state_0 doIntLength(JSArrayBase, ScriptArray) */) {
                            if ((this.intLength_arrayType_.isInstance(arg0Value_.getArrayType()))) {
                                assert (ArrayLengthReadNode.isLengthAlwaysInt(this.intLength_arrayType_));
                                IntLength_duplicateFound_ = true;
                            }
                        }
                        if (!IntLength_duplicateFound_) {
                            {
                                ScriptArray intLength_arrayType__ = (ArrayLengthNode.getArrayType(arg0Value_));
                                if ((intLength_arrayType__.isInstance(arg0Value_.getArrayType())) && (ArrayLengthReadNode.isLengthAlwaysInt(intLength_arrayType__)) && ((state_0 & 0b10)) == 0 /* is-not-state_0 doIntLength(JSArrayBase, ScriptArray) */) {
                                    this.intLength_arrayType_ = intLength_arrayType__;
                                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doIntLength(JSArrayBase, ScriptArray) */;
                                    IntLength_duplicateFound_ = true;
                                }
                            }
                        }
                        if (IntLength_duplicateFound_) {
                            lock.unlock();
                            hasLock = false;
                            return ArrayLengthReadNode.doIntLength(arg0Value_, this.intLength_arrayType_);
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-exclude doUncachedIntLength(JSArrayBase) */) {
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude doIntLength(JSArrayBase, ScriptArray) */;
                        state_0 = state_0 & 0xfffffffd /* remove-state_0 doIntLength(JSArrayBase, ScriptArray) */;
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doUncachedIntLength(JSArrayBase) */;
                        try {
                            lock.unlock();
                            hasLock = false;
                            return ArrayLengthReadNode.doUncachedIntLength(arg0Value_);
                        } catch (UnexpectedResultException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b10 /* add-exclude doUncachedIntLength(JSArrayBase) */;
                                this.state_0_ = this.state_0_ & 0xfffffffb /* remove-state_0 doUncachedIntLength(JSArrayBase) */;
                            } finally {
                                lock.unlock();
                            }
                            return ex.getResult();
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b11 /* add-exclude doIntLength(JSArrayBase, ScriptArray), doUncachedIntLength(JSArrayBase) */;
                    state_0 = state_0 & 0xfffffff9 /* remove-state_0 doIntLength(JSArrayBase, ScriptArray), doUncachedIntLength(JSArrayBase) */;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doUncachedLongLength(JSArrayBase) */;
                    lock.unlock();
                    hasLock = false;
                    return ArrayLengthReadNode.doUncachedLongLength(arg0Value_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
            s[0] = "doTypedArray";
            if ((state_0 & 0b1) != 0 /* is-state_0 doTypedArray(JSTypedArrayObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doIntLength";
            if ((state_0 & 0b10) != 0 /* is-state_0 doIntLength(JSArrayBase, ScriptArray) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.intLength_arrayType_));
                s[2] = cached;
            } else if ((exclude & 0b1) != 0 /* is-exclude doIntLength(JSArrayBase, ScriptArray) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doUncachedIntLength";
            if ((state_0 & 0b100) != 0 /* is-state_0 doUncachedIntLength(JSArrayBase) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b10) != 0 /* is-exclude doUncachedIntLength(JSArrayBase) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doUncachedLongLength";
            if ((state_0 & 0b1000) != 0 /* is-state_0 doUncachedLongLength(JSArrayBase) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ArrayLengthReadNode create() {
            return new ArrayLengthReadNodeGen();
        }

    }
    @GeneratedBy(SetArrayLengthNode.class)
    public static final class SetArrayLengthNodeGen extends SetArrayLengthNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;
        @CompilationFinal private ConditionProfile generic_sealedProfile_;
        @CompilationFinal private ProfileHolder generic_setLengthProfile_;

        private SetArrayLengthNodeGen(boolean strict) {
            super(strict);
        }

        @ExplodeLoop
        @Override
        public void executeVoid(DynamicObject arg0Value, int arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(DynamicObject, int, ScriptArray, ProfileHolder) || doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((s0_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                            doCached(arg0Value, arg1Value, s0_.arrayType_, s0_.setLengthProfile_);
                            return;
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */) {
                    doGeneric(arg0Value, arg1Value, this.generic_sealedProfile_, this.generic_setLengthProfile_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arg0Value, arg1Value);
            return;
        }

        private void executeAndSpecialize(DynamicObject arg0Value, int arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                        while (s0_ != null) {
                            if ((s0_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        {
                            ScriptArray arrayType__ = (ArrayLengthNode.getArrayType(arg0Value));
                            if ((arrayType__.isInstance(ArrayLengthNode.getArrayType(arg0Value))) && count0_ < (ArrayLengthNode.MAX_TYPE_COUNT)) {
                                s0_ = new CachedData(cached_cache);
                                s0_.arrayType_ = arrayType__;
                                s0_.setLengthProfile_ = (ScriptArray.createSetLengthProfile());
                                MemoryFence.storeStore();
                                this.cached_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, int, ScriptArray, ProfileHolder) */;
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        doCached(arg0Value, arg1Value, s0_.arrayType_, s0_.setLengthProfile_);
                        return;
                    }
                }
                this.generic_sealedProfile_ = (ConditionProfile.createBinaryProfile());
                this.generic_setLengthProfile_ = (ScriptArray.createSetLengthProfile());
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(DynamicObject, int, ScriptArray, ProfileHolder) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(DynamicObject, int, ScriptArray, ProfileHolder) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */;
                lock.unlock();
                hasLock = false;
                doGeneric(arg0Value, arg1Value, this.generic_sealedProfile_, this.generic_setLengthProfile_);
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.arrayType_, s0_.setLengthProfile_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doGeneric";
            if ((state_0 & 0b10) != 0 /* is-state_0 doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.generic_sealedProfile_, this.generic_setLengthProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static SetArrayLengthNode create(boolean strict) {
            return new SetArrayLengthNodeGen(strict);
        }

        @GeneratedBy(SetArrayLengthNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal ScriptArray arrayType_;
            @CompilationFinal ProfileHolder setLengthProfile_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
    @GeneratedBy(SetArrayLengthOrDeleteNode.class)
    public static final class SetArrayLengthOrDeleteNodeGen extends SetArrayLengthOrDeleteNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;
        @CompilationFinal private ConditionProfile generic_mustDeleteProfile_;
        @CompilationFinal private ProfileHolder generic_setLengthProfile_;

        private SetArrayLengthOrDeleteNodeGen(boolean strict) {
            super(strict);
        }

        @ExplodeLoop
        @Override
        public void executeVoid(DynamicObject arg0Value, int arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(DynamicObject, int, ScriptArray, ProfileHolder) || doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((s0_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                            doCached(arg0Value, arg1Value, s0_.arrayType_, s0_.setLengthProfile_);
                            return;
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */) {
                    doGeneric(arg0Value, arg1Value, this.generic_mustDeleteProfile_, this.generic_setLengthProfile_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arg0Value, arg1Value);
            return;
        }

        private void executeAndSpecialize(DynamicObject arg0Value, int arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                        while (s0_ != null) {
                            if ((s0_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        {
                            ScriptArray arrayType__ = (ArrayLengthNode.getArrayType(arg0Value));
                            if ((arrayType__.isInstance(ArrayLengthNode.getArrayType(arg0Value))) && count0_ < (ArrayLengthNode.MAX_TYPE_COUNT)) {
                                s0_ = new CachedData(cached_cache);
                                s0_.arrayType_ = arrayType__;
                                s0_.setLengthProfile_ = (ScriptArray.createSetLengthProfile());
                                MemoryFence.storeStore();
                                this.cached_cache = s0_;
                                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(DynamicObject, int, ScriptArray, ProfileHolder) */;
                            }
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        doCached(arg0Value, arg1Value, s0_.arrayType_, s0_.setLengthProfile_);
                        return;
                    }
                }
                this.generic_mustDeleteProfile_ = (ConditionProfile.createBinaryProfile());
                this.generic_setLengthProfile_ = (ScriptArray.createSetLengthProfile());
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(DynamicObject, int, ScriptArray, ProfileHolder) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(DynamicObject, int, ScriptArray, ProfileHolder) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */;
                lock.unlock();
                hasLock = false;
                doGeneric(arg0Value, arg1Value, this.generic_mustDeleteProfile_, this.generic_setLengthProfile_);
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
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s0_ = this.cached_cache;
                while (s0_ != null) {
                    cached.add(Arrays.asList(s0_.arrayType_, s0_.setLengthProfile_));
                    s0_ = s0_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doGeneric";
            if ((state_0 & 0b10) != 0 /* is-state_0 doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.generic_mustDeleteProfile_, this.generic_setLengthProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static SetArrayLengthOrDeleteNode create(boolean strict) {
            return new SetArrayLengthOrDeleteNodeGen(strict);
        }

        @GeneratedBy(SetArrayLengthOrDeleteNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal ScriptArray arrayType_;
            @CompilationFinal ProfileHolder setLengthProfile_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
}
