// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.array.TypedArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ArrayBufferViewGetByteLengthNode.class)
public final class ArrayBufferViewGetByteLengthNodeGen extends ArrayBufferViewGetByteLengthNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private GetByteLengthData getByteLength_cache;

    private ArrayBufferViewGetByteLengthNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    public int executeInt(DynamicObject arg0Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 getByteLengthDetached(DynamicObject) || getByteLength(DynamicObject, TypedArray) || getByteLengthOverLimit(DynamicObject) || getByteLengthNoObj(DynamicObject) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 getByteLengthDetached(DynamicObject) */) {
                if ((JSGuards.isJSArrayBufferView(arg0Value)) && (hasDetachedBuffer(arg0Value))) {
                    return getByteLengthDetached(arg0Value);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 getByteLength(DynamicObject, TypedArray) */ && (JSGuards.isJSArrayBufferView(arg0Value)) && (!(hasDetachedBuffer(arg0Value)))) {
                GetByteLengthData s1_ = this.getByteLength_cache;
                while (s1_ != null) {
                    if ((s1_.cachedArray_ == ArrayBufferViewGetByteLengthNode.getArrayType(arg0Value))) {
                        return getByteLength(arg0Value, s1_.cachedArray_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 getByteLengthOverLimit(DynamicObject) */) {
                if ((JSGuards.isJSArrayBufferView(arg0Value)) && (!(hasDetachedBuffer(arg0Value)))) {
                    return getByteLengthOverLimit(arg0Value);
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 getByteLengthNoObj(DynamicObject) */) {
                if ((!(JSGuards.isJSArrayBufferView(arg0Value)))) {
                    return getByteLengthNoObj(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private int executeAndSpecialize(DynamicObject arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((JSGuards.isJSArrayBufferView(arg0Value)) && (hasDetachedBuffer(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getByteLengthDetached(DynamicObject) */;
                lock.unlock();
                hasLock = false;
                return getByteLengthDetached(arg0Value);
            }
            if ((exclude) == 0 /* is-not-exclude getByteLength(DynamicObject, TypedArray) */ && (JSGuards.isJSArrayBufferView(arg0Value)) && (!(hasDetachedBuffer(arg0Value)))) {
                int count1_ = 0;
                GetByteLengthData s1_ = this.getByteLength_cache;
                if ((state_0 & 0b10) != 0 /* is-state_0 getByteLength(DynamicObject, TypedArray) */) {
                    while (s1_ != null) {
                        if ((s1_.cachedArray_ == ArrayBufferViewGetByteLengthNode.getArrayType(arg0Value))) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        TypedArray cachedArray__ = (ArrayBufferViewGetByteLengthNode.getArrayType(arg0Value));
                        if ((cachedArray__ == ArrayBufferViewGetByteLengthNode.getArrayType(arg0Value)) && count1_ < (3)) {
                            s1_ = new GetByteLengthData(getByteLength_cache);
                            s1_.cachedArray_ = cachedArray__;
                            MemoryFence.storeStore();
                            this.getByteLength_cache = s1_;
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getByteLength(DynamicObject, TypedArray) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return getByteLength(arg0Value, s1_.cachedArray_);
                }
            }
            if ((JSGuards.isJSArrayBufferView(arg0Value)) && (!(hasDetachedBuffer(arg0Value)))) {
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude getByteLength(DynamicObject, TypedArray) */;
                this.getByteLength_cache = null;
                state_0 = state_0 & 0xfffffffd /* remove-state_0 getByteLength(DynamicObject, TypedArray) */;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 getByteLengthOverLimit(DynamicObject) */;
                lock.unlock();
                hasLock = false;
                return getByteLengthOverLimit(arg0Value);
            }
            if ((!(JSGuards.isJSArrayBufferView(arg0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 getByteLengthNoObj(DynamicObject) */;
                lock.unlock();
                hasLock = false;
                return getByteLengthNoObj(arg0Value);
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
                GetByteLengthData s1_ = this.getByteLength_cache;
                if ((s1_ == null || s1_.next_ == null)) {
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
        s[0] = "getByteLengthDetached";
        if ((state_0 & 0b1) != 0 /* is-state_0 getByteLengthDetached(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "getByteLength";
        if ((state_0 & 0b10) != 0 /* is-state_0 getByteLength(DynamicObject, TypedArray) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GetByteLengthData s1_ = this.getByteLength_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedArray_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude getByteLength(DynamicObject, TypedArray) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "getByteLengthOverLimit";
        if ((state_0 & 0b100) != 0 /* is-state_0 getByteLengthOverLimit(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "getByteLengthNoObj";
        if ((state_0 & 0b1000) != 0 /* is-state_0 getByteLengthNoObj(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static ArrayBufferViewGetByteLengthNode create(JSContext context) {
        return new ArrayBufferViewGetByteLengthNodeGen(context);
    }

    @GeneratedBy(ArrayBufferViewGetByteLengthNode.class)
    private static final class GetByteLengthData {

        @CompilationFinal GetByteLengthData next_;
        @CompilationFinal TypedArray cachedArray_;

        GetByteLengthData(GetByteLengthData next_) {
            this.next_ = next_;
        }

    }
}
