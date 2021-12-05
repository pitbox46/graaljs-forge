// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

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
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.array.ArrayLengthNode.ArrayLengthReadNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSArrayObject;
import com.oracle.truffle.js.runtime.objects.JSDynamicObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSGetLengthNode.class)
@SuppressWarnings("unused")
public final class JSGetLengthNodeGen extends JSGetLengthNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private ArrayLengthReadNode getArrayLengthInt_arrayLengthReadNode_;
    @Child private ArrayLengthReadNode getArrayLength_arrayLengthReadNode_;
    @Child private PropertyGetNode getNonArrayLength_getLengthPropertyNode_;
    @Child private GetLengthForeign0Data getLengthForeign0_cache;
    @Child private ImportValueNode getLengthForeign1_importValueNode_;

    private JSGetLengthNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b11) != 0 /* is-state_0 getArrayLengthInt(JSArrayObject, ArrayLengthReadNode) || getArrayLength(JSArrayObject, ArrayLengthReadNode) */ && arg0Value instanceof JSArrayObject) {
            JSArrayObject arg0Value_ = (JSArrayObject) arg0Value;
            if ((state_0 & 0b1) != 0 /* is-state_0 getArrayLengthInt(JSArrayObject, ArrayLengthReadNode) */) {
                try {
                    return getArrayLengthInt(arg0Value_, this.getArrayLengthInt_arrayLengthReadNode_);
                } catch (UnexpectedResultException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-exclude getArrayLengthInt(JSArrayObject, ArrayLengthReadNode) */;
                        this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 getArrayLengthInt(JSArrayObject, ArrayLengthReadNode) */;
                    } finally {
                        lock.unlock();
                    }
                    return ex.getResult();
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 getArrayLength(JSArrayObject, ArrayLengthReadNode) */) {
                return getArrayLength(arg0Value_, this.getArrayLength_arrayLengthReadNode_);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 getNonArrayLength(JSDynamicObject, PropertyGetNode) */ && arg0Value instanceof JSDynamicObject) {
            JSDynamicObject arg0Value_ = (JSDynamicObject) arg0Value;
            if ((!(JSGuards.isJSArray(arg0Value_)))) {
                return getNonArrayLength(arg0Value_, this.getNonArrayLength_getLengthPropertyNode_);
            }
        }
        if ((state_0 & 0b11000) != 0 /* is-state_0 getLengthForeign(Object, InteropLibrary, ImportValueNode) || getLengthForeign(Object, InteropLibrary, ImportValueNode) */) {
            if ((state_0 & 0b1000) != 0 /* is-state_0 getLengthForeign(Object, InteropLibrary, ImportValueNode) */) {
                GetLengthForeign0Data s3_ = this.getLengthForeign0_cache;
                while (s3_ != null) {
                    if ((s3_.interop_.accepts(arg0Value)) && (!(JSGuards.isJSDynamicObject(arg0Value)))) {
                        return getLengthForeign(arg0Value, s3_.interop_, s3_.importValueNode_);
                    }
                    s3_ = s3_.next_;
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 getLengthForeign(Object, InteropLibrary, ImportValueNode) */) {
                if ((!(JSGuards.isJSDynamicObject(arg0Value)))) {
                    return this.getLengthForeign1Boundary(state_0, arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object getLengthForeign1Boundary(int state_0, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary getLengthForeign1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return getLengthForeign(arg0Value, getLengthForeign1_interop__, this.getLengthForeign1_importValueNode_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (arg0Value instanceof JSArrayObject) {
                JSArrayObject arg0Value_ = (JSArrayObject) arg0Value;
                if (((exclude & 0b1)) == 0 /* is-not-exclude getArrayLengthInt(JSArrayObject, ArrayLengthReadNode) */) {
                    this.getArrayLengthInt_arrayLengthReadNode_ = super.insert((ArrayLengthReadNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 getArrayLengthInt(JSArrayObject, ArrayLengthReadNode) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return getArrayLengthInt(arg0Value_, this.getArrayLengthInt_arrayLengthReadNode_);
                    } catch (UnexpectedResultException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b1 /* add-exclude getArrayLengthInt(JSArrayObject, ArrayLengthReadNode) */;
                            this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 getArrayLengthInt(JSArrayObject, ArrayLengthReadNode) */;
                        } finally {
                            lock.unlock();
                        }
                        return ex.getResult();
                    }
                }
                this.getArrayLength_arrayLengthReadNode_ = super.insert((ArrayLengthReadNode.create()));
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude getArrayLengthInt(JSArrayObject, ArrayLengthReadNode) */;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 getArrayLengthInt(JSArrayObject, ArrayLengthReadNode) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getArrayLength(JSArrayObject, ArrayLengthReadNode) */;
                lock.unlock();
                hasLock = false;
                return getArrayLength(arg0Value_, this.getArrayLength_arrayLengthReadNode_);
            }
            if (arg0Value instanceof JSDynamicObject) {
                JSDynamicObject arg0Value_ = (JSDynamicObject) arg0Value;
                if ((!(JSGuards.isJSArray(arg0Value_)))) {
                    this.getNonArrayLength_getLengthPropertyNode_ = super.insert((createLengthProperty()));
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 getNonArrayLength(JSDynamicObject, PropertyGetNode) */;
                    lock.unlock();
                    hasLock = false;
                    return getNonArrayLength(arg0Value_, this.getNonArrayLength_getLengthPropertyNode_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude getLengthForeign(Object, InteropLibrary, ImportValueNode) */) {
                int count3_ = 0;
                GetLengthForeign0Data s3_ = this.getLengthForeign0_cache;
                if ((state_0 & 0b1000) != 0 /* is-state_0 getLengthForeign(Object, InteropLibrary, ImportValueNode) */) {
                    while (s3_ != null) {
                        if ((s3_.interop_.accepts(arg0Value)) && (!(JSGuards.isJSDynamicObject(arg0Value)))) {
                            break;
                        }
                        s3_ = s3_.next_;
                        count3_++;
                    }
                }
                if (s3_ == null) {
                    if ((!(JSGuards.isJSDynamicObject(arg0Value))) && count3_ < (3)) {
                        // assert (s3_.interop_.accepts(arg0Value));
                        s3_ = super.insert(new GetLengthForeign0Data(getLengthForeign0_cache));
                        s3_.interop_ = s3_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        s3_.importValueNode_ = s3_.insertAccessor((ImportValueNode.create()));
                        MemoryFence.storeStore();
                        this.getLengthForeign0_cache = s3_;
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 getLengthForeign(Object, InteropLibrary, ImportValueNode) */;
                    }
                }
                if (s3_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return getLengthForeign(arg0Value, s3_.interop_, s3_.importValueNode_);
                }
            }
            {
                InteropLibrary getLengthForeign1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((!(JSGuards.isJSDynamicObject(arg0Value)))) {
                            getLengthForeign1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            this.getLengthForeign1_importValueNode_ = super.insert((ImportValueNode.create()));
                            this.exclude_ = exclude = exclude | 0b10 /* add-exclude getLengthForeign(Object, InteropLibrary, ImportValueNode) */;
                            this.getLengthForeign0_cache = null;
                            state_0 = state_0 & 0xfffffff7 /* remove-state_0 getLengthForeign(Object, InteropLibrary, ImportValueNode) */;
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 getLengthForeign(Object, InteropLibrary, ImportValueNode) */;
                            lock.unlock();
                            hasLock = false;
                            return getLengthForeign(arg0Value, getLengthForeign1_interop__, this.getLengthForeign1_importValueNode_);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
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
                GetLengthForeign0Data s3_ = this.getLengthForeign0_cache;
                if ((s3_ == null || s3_.next_ == null)) {
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
        s[0] = "getArrayLengthInt";
        if ((state_0 & 0b1) != 0 /* is-state_0 getArrayLengthInt(JSArrayObject, ArrayLengthReadNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.getArrayLengthInt_arrayLengthReadNode_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude getArrayLengthInt(JSArrayObject, ArrayLengthReadNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "getArrayLength";
        if ((state_0 & 0b10) != 0 /* is-state_0 getArrayLength(JSArrayObject, ArrayLengthReadNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.getArrayLength_arrayLengthReadNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "getNonArrayLength";
        if ((state_0 & 0b100) != 0 /* is-state_0 getNonArrayLength(JSDynamicObject, PropertyGetNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.getNonArrayLength_getLengthPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "getLengthForeign";
        if ((state_0 & 0b1000) != 0 /* is-state_0 getLengthForeign(Object, InteropLibrary, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GetLengthForeign0Data s3_ = this.getLengthForeign0_cache;
            while (s3_ != null) {
                cached.add(Arrays.asList(s3_.interop_, s3_.importValueNode_));
                s3_ = s3_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude getLengthForeign(Object, InteropLibrary, ImportValueNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "getLengthForeign";
        if ((state_0 & 0b10000) != 0 /* is-state_0 getLengthForeign(Object, InteropLibrary, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.getLengthForeign1_importValueNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static JSGetLengthNode create(JSContext context) {
        return new JSGetLengthNodeGen(context);
    }

    @GeneratedBy(JSGetLengthNode.class)
    private static final class GetLengthForeign0Data extends Node {

        @Child GetLengthForeign0Data next_;
        @Child InteropLibrary interop_;
        @Child ImportValueNode importValueNode_;

        GetLengthForeign0Data(GetLengthForeign0Data next_) {
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
