// CheckStyle: start generated
package com.oracle.truffle.host;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.host.HostContext.ToGuestValueNode;
import com.oracle.truffle.host.HostContextFactory.ToGuestValueNodeGen;
import com.oracle.truffle.host.HostObject.ArrayGet;
import com.oracle.truffle.host.HostObject.ArraySet;
import com.oracle.truffle.host.HostObject.ContainsKeyNode;
import com.oracle.truffle.host.HostObject.IsArrayNode;
import com.oracle.truffle.host.HostObject.IsBufferNode;
import com.oracle.truffle.host.HostObject.IsIterableNode;
import com.oracle.truffle.host.HostObject.IsIteratorNode;
import com.oracle.truffle.host.HostObject.IsListNode;
import com.oracle.truffle.host.HostObject.IsMapEntryNode;
import com.oracle.truffle.host.HostObject.IsMapNode;
import com.oracle.truffle.host.HostObject.LookupConstructorNode;
import com.oracle.truffle.host.HostObject.LookupFieldNode;
import com.oracle.truffle.host.HostObject.LookupFunctionalMethodNode;
import com.oracle.truffle.host.HostObject.LookupInnerClassNode;
import com.oracle.truffle.host.HostObject.LookupMethodNode;
import com.oracle.truffle.host.HostObject.ReadFieldNode;
import com.oracle.truffle.host.HostObject.WriteFieldNode;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HostObject.class)
final class HostObjectFactory {

    @GeneratedBy(ArraySet.class)
    static final class ArraySetNodeGen extends ArraySet {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private int state_0_;

        private ArraySetNodeGen() {
        }

        @Override
        protected void execute(Object arg0Value, int arg1Value, Object arg2Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doBoolean(boolean[], int, boolean) || doByte(byte[], int, byte) || doShort(short[], int, short) || doChar(char[], int, char) || doInt(int[], int, int) || doLong(long[], int, long) || doFloat(float[], int, float) || doDouble(double[], int, double) || doObject(Object[], int, Object) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean[], int, boolean) */ && arg0Value instanceof boolean[]) {
                    boolean[] arg0Value_ = (boolean[]) arg0Value;
                    if (arg2Value instanceof Boolean) {
                        boolean arg2Value_ = (boolean) arg2Value;
                        ArraySet.doBoolean(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doByte(byte[], int, byte) */ && arg0Value instanceof byte[]) {
                    byte[] arg0Value_ = (byte[]) arg0Value;
                    if (arg2Value instanceof Byte) {
                        byte arg2Value_ = (byte) arg2Value;
                        ArraySet.doByte(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doShort(short[], int, short) */ && arg0Value instanceof short[]) {
                    short[] arg0Value_ = (short[]) arg0Value;
                    if (arg2Value instanceof Short) {
                        short arg2Value_ = (short) arg2Value;
                        ArraySet.doShort(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doChar(char[], int, char) */ && arg0Value instanceof char[]) {
                    char[] arg0Value_ = (char[]) arg0Value;
                    if (arg2Value instanceof Character) {
                        char arg2Value_ = (char) arg2Value;
                        ArraySet.doChar(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doInt(int[], int, int) */ && arg0Value instanceof int[]) {
                    int[] arg0Value_ = (int[]) arg0Value;
                    if (arg2Value instanceof Integer) {
                        int arg2Value_ = (int) arg2Value;
                        ArraySet.doInt(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 doLong(long[], int, long) */ && arg0Value instanceof long[]) {
                    long[] arg0Value_ = (long[]) arg0Value;
                    if (arg2Value instanceof Long) {
                        long arg2Value_ = (long) arg2Value;
                        ArraySet.doLong(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 doFloat(float[], int, float) */ && arg0Value instanceof float[]) {
                    float[] arg0Value_ = (float[]) arg0Value;
                    if (arg2Value instanceof Float) {
                        float arg2Value_ = (float) arg2Value;
                        ArraySet.doFloat(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if ((state_0 & 0b10000000) != 0 /* is-state_0 doDouble(double[], int, double) */ && arg0Value instanceof double[]) {
                    double[] arg0Value_ = (double[]) arg0Value;
                    if (arg2Value instanceof Double) {
                        double arg2Value_ = (double) arg2Value;
                        ArraySet.doDouble(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if ((state_0 & 0b100000000) != 0 /* is-state_0 doObject(Object[], int, Object) */ && arg0Value instanceof Object[]) {
                    Object[] arg0Value_ = (Object[]) arg0Value;
                    ArraySet.doObject(arg0Value_, arg1Value, arg2Value);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arg0Value, arg1Value, arg2Value);
            return;
        }

        private void executeAndSpecialize(Object arg0Value, int arg1Value, Object arg2Value) {
            int state_0 = this.state_0_;
            if (arg0Value instanceof boolean[]) {
                boolean[] arg0Value_ = (boolean[]) arg0Value;
                if (arg2Value instanceof Boolean) {
                    boolean arg2Value_ = (boolean) arg2Value;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBoolean(boolean[], int, boolean) */;
                    ArraySet.doBoolean(arg0Value_, arg1Value, arg2Value_);
                    return;
                }
            }
            if (arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                if (arg2Value instanceof Byte) {
                    byte arg2Value_ = (byte) arg2Value;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doByte(byte[], int, byte) */;
                    ArraySet.doByte(arg0Value_, arg1Value, arg2Value_);
                    return;
                }
            }
            if (arg0Value instanceof short[]) {
                short[] arg0Value_ = (short[]) arg0Value;
                if (arg2Value instanceof Short) {
                    short arg2Value_ = (short) arg2Value;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doShort(short[], int, short) */;
                    ArraySet.doShort(arg0Value_, arg1Value, arg2Value_);
                    return;
                }
            }
            if (arg0Value instanceof char[]) {
                char[] arg0Value_ = (char[]) arg0Value;
                if (arg2Value instanceof Character) {
                    char arg2Value_ = (char) arg2Value;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doChar(char[], int, char) */;
                    ArraySet.doChar(arg0Value_, arg1Value, arg2Value_);
                    return;
                }
            }
            if (arg0Value instanceof int[]) {
                int[] arg0Value_ = (int[]) arg0Value;
                if (arg2Value instanceof Integer) {
                    int arg2Value_ = (int) arg2Value;
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doInt(int[], int, int) */;
                    ArraySet.doInt(arg0Value_, arg1Value, arg2Value_);
                    return;
                }
            }
            if (arg0Value instanceof long[]) {
                long[] arg0Value_ = (long[]) arg0Value;
                if (arg2Value instanceof Long) {
                    long arg2Value_ = (long) arg2Value;
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doLong(long[], int, long) */;
                    ArraySet.doLong(arg0Value_, arg1Value, arg2Value_);
                    return;
                }
            }
            if (arg0Value instanceof float[]) {
                float[] arg0Value_ = (float[]) arg0Value;
                if (arg2Value instanceof Float) {
                    float arg2Value_ = (float) arg2Value;
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doFloat(float[], int, float) */;
                    ArraySet.doFloat(arg0Value_, arg1Value, arg2Value_);
                    return;
                }
            }
            if (arg0Value instanceof double[]) {
                double[] arg0Value_ = (double[]) arg0Value;
                if (arg2Value instanceof Double) {
                    double arg2Value_ = (double) arg2Value;
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doDouble(double[], int, double) */;
                    ArraySet.doDouble(arg0Value_, arg1Value, arg2Value_);
                    return;
                }
            }
            if (arg0Value instanceof Object[]) {
                Object[] arg0Value_ = (Object[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doObject(Object[], int, Object) */;
                ArraySet.doObject(arg0Value_, arg1Value, arg2Value);
                return;
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
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

        public static ArraySet create() {
            return new ArraySetNodeGen();
        }

        public static ArraySet getUncached() {
            return ArraySetNodeGen.UNCACHED;
        }

        @GeneratedBy(ArraySet.class)
        private static final class Uncached extends ArraySet {

            @TruffleBoundary
            @Override
            protected void execute(Object arg0Value, int arg1Value, Object arg2Value) {
                if (arg0Value instanceof boolean[]) {
                    boolean[] arg0Value_ = (boolean[]) arg0Value;
                    if (arg2Value instanceof Boolean) {
                        boolean arg2Value_ = (boolean) arg2Value;
                        ArraySet.doBoolean(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if (arg0Value instanceof byte[]) {
                    byte[] arg0Value_ = (byte[]) arg0Value;
                    if (arg2Value instanceof Byte) {
                        byte arg2Value_ = (byte) arg2Value;
                        ArraySet.doByte(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if (arg0Value instanceof short[]) {
                    short[] arg0Value_ = (short[]) arg0Value;
                    if (arg2Value instanceof Short) {
                        short arg2Value_ = (short) arg2Value;
                        ArraySet.doShort(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if (arg0Value instanceof char[]) {
                    char[] arg0Value_ = (char[]) arg0Value;
                    if (arg2Value instanceof Character) {
                        char arg2Value_ = (char) arg2Value;
                        ArraySet.doChar(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if (arg0Value instanceof int[]) {
                    int[] arg0Value_ = (int[]) arg0Value;
                    if (arg2Value instanceof Integer) {
                        int arg2Value_ = (int) arg2Value;
                        ArraySet.doInt(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if (arg0Value instanceof long[]) {
                    long[] arg0Value_ = (long[]) arg0Value;
                    if (arg2Value instanceof Long) {
                        long arg2Value_ = (long) arg2Value;
                        ArraySet.doLong(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if (arg0Value instanceof float[]) {
                    float[] arg0Value_ = (float[]) arg0Value;
                    if (arg2Value instanceof Float) {
                        float arg2Value_ = (float) arg2Value;
                        ArraySet.doFloat(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if (arg0Value instanceof double[]) {
                    double[] arg0Value_ = (double[]) arg0Value;
                    if (arg2Value instanceof Double) {
                        double arg2Value_ = (double) arg2Value;
                        ArraySet.doDouble(arg0Value_, arg1Value, arg2Value_);
                        return;
                    }
                }
                if (arg0Value instanceof Object[]) {
                    Object[] arg0Value_ = (Object[]) arg0Value;
                    ArraySet.doObject(arg0Value_, arg1Value, arg2Value);
                    return;
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
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
    @GeneratedBy(ArrayGet.class)
    static final class ArrayGetNodeGen extends ArrayGet {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private int state_0_;

        private ArrayGetNodeGen() {
        }

        @Override
        protected Object execute(Object arg0Value, int arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doBoolean(boolean[], int) || doByte(byte[], int) || doShort(short[], int) || doChar(char[], int) || doInt(int[], int) || doLong(long[], int) || doFloat(float[], int) || doDouble(double[], int) || doObject(Object[], int) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doBoolean(boolean[], int) */ && arg0Value instanceof boolean[]) {
                    boolean[] arg0Value_ = (boolean[]) arg0Value;
                    return ArrayGet.doBoolean(arg0Value_, arg1Value);
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doByte(byte[], int) */ && arg0Value instanceof byte[]) {
                    byte[] arg0Value_ = (byte[]) arg0Value;
                    return ArrayGet.doByte(arg0Value_, arg1Value);
                }
                if ((state_0 & 0b100) != 0 /* is-state_0 doShort(short[], int) */ && arg0Value instanceof short[]) {
                    short[] arg0Value_ = (short[]) arg0Value;
                    return ArrayGet.doShort(arg0Value_, arg1Value);
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 doChar(char[], int) */ && arg0Value instanceof char[]) {
                    char[] arg0Value_ = (char[]) arg0Value;
                    return ArrayGet.doChar(arg0Value_, arg1Value);
                }
                if ((state_0 & 0b10000) != 0 /* is-state_0 doInt(int[], int) */ && arg0Value instanceof int[]) {
                    int[] arg0Value_ = (int[]) arg0Value;
                    return ArrayGet.doInt(arg0Value_, arg1Value);
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 doLong(long[], int) */ && arg0Value instanceof long[]) {
                    long[] arg0Value_ = (long[]) arg0Value;
                    return ArrayGet.doLong(arg0Value_, arg1Value);
                }
                if ((state_0 & 0b1000000) != 0 /* is-state_0 doFloat(float[], int) */ && arg0Value instanceof float[]) {
                    float[] arg0Value_ = (float[]) arg0Value;
                    return ArrayGet.doFloat(arg0Value_, arg1Value);
                }
                if ((state_0 & 0b10000000) != 0 /* is-state_0 doDouble(double[], int) */ && arg0Value instanceof double[]) {
                    double[] arg0Value_ = (double[]) arg0Value;
                    return ArrayGet.doDouble(arg0Value_, arg1Value);
                }
                if ((state_0 & 0b100000000) != 0 /* is-state_0 doObject(Object[], int) */ && arg0Value instanceof Object[]) {
                    Object[] arg0Value_ = (Object[]) arg0Value;
                    return ArrayGet.doObject(arg0Value_, arg1Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private Object executeAndSpecialize(Object arg0Value, int arg1Value) {
            int state_0 = this.state_0_;
            if (arg0Value instanceof boolean[]) {
                boolean[] arg0Value_ = (boolean[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doBoolean(boolean[], int) */;
                return ArrayGet.doBoolean(arg0Value_, arg1Value);
            }
            if (arg0Value instanceof byte[]) {
                byte[] arg0Value_ = (byte[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doByte(byte[], int) */;
                return ArrayGet.doByte(arg0Value_, arg1Value);
            }
            if (arg0Value instanceof short[]) {
                short[] arg0Value_ = (short[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doShort(short[], int) */;
                return ArrayGet.doShort(arg0Value_, arg1Value);
            }
            if (arg0Value instanceof char[]) {
                char[] arg0Value_ = (char[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doChar(char[], int) */;
                return ArrayGet.doChar(arg0Value_, arg1Value);
            }
            if (arg0Value instanceof int[]) {
                int[] arg0Value_ = (int[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doInt(int[], int) */;
                return ArrayGet.doInt(arg0Value_, arg1Value);
            }
            if (arg0Value instanceof long[]) {
                long[] arg0Value_ = (long[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doLong(long[], int) */;
                return ArrayGet.doLong(arg0Value_, arg1Value);
            }
            if (arg0Value instanceof float[]) {
                float[] arg0Value_ = (float[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 doFloat(float[], int) */;
                return ArrayGet.doFloat(arg0Value_, arg1Value);
            }
            if (arg0Value instanceof double[]) {
                double[] arg0Value_ = (double[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 doDouble(double[], int) */;
                return ArrayGet.doDouble(arg0Value_, arg1Value);
            }
            if (arg0Value instanceof Object[]) {
                Object[] arg0Value_ = (Object[]) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 doObject(Object[], int) */;
                return ArrayGet.doObject(arg0Value_, arg1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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

        public static ArrayGet create() {
            return new ArrayGetNodeGen();
        }

        public static ArrayGet getUncached() {
            return ArrayGetNodeGen.UNCACHED;
        }

        @GeneratedBy(ArrayGet.class)
        private static final class Uncached extends ArrayGet {

            @TruffleBoundary
            @Override
            protected Object execute(Object arg0Value, int arg1Value) {
                if (arg0Value instanceof boolean[]) {
                    boolean[] arg0Value_ = (boolean[]) arg0Value;
                    return ArrayGet.doBoolean(arg0Value_, arg1Value);
                }
                if (arg0Value instanceof byte[]) {
                    byte[] arg0Value_ = (byte[]) arg0Value;
                    return ArrayGet.doByte(arg0Value_, arg1Value);
                }
                if (arg0Value instanceof short[]) {
                    short[] arg0Value_ = (short[]) arg0Value;
                    return ArrayGet.doShort(arg0Value_, arg1Value);
                }
                if (arg0Value instanceof char[]) {
                    char[] arg0Value_ = (char[]) arg0Value;
                    return ArrayGet.doChar(arg0Value_, arg1Value);
                }
                if (arg0Value instanceof int[]) {
                    int[] arg0Value_ = (int[]) arg0Value;
                    return ArrayGet.doInt(arg0Value_, arg1Value);
                }
                if (arg0Value instanceof long[]) {
                    long[] arg0Value_ = (long[]) arg0Value;
                    return ArrayGet.doLong(arg0Value_, arg1Value);
                }
                if (arg0Value instanceof float[]) {
                    float[] arg0Value_ = (float[]) arg0Value;
                    return ArrayGet.doFloat(arg0Value_, arg1Value);
                }
                if (arg0Value instanceof double[]) {
                    double[] arg0Value_ = (double[]) arg0Value;
                    return ArrayGet.doDouble(arg0Value_, arg1Value);
                }
                if (arg0Value instanceof Object[]) {
                    Object[] arg0Value_ = (Object[]) arg0Value;
                    return ArrayGet.doObject(arg0Value_, arg1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
    @GeneratedBy(LookupConstructorNode.class)
    static final class LookupConstructorNodeGen extends LookupConstructorNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private LookupConstructorNodeGen() {
        }

        @ExplodeLoop
        @Override
        public HostMethodDesc execute(HostObject arg0Value, Class<?> arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(HostObject, Class<>, Class<>, HostMethodDesc) || doUncached(HostObject, Class<>) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostObject, Class<>, Class<>, HostMethodDesc) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((arg1Value == s0_.cachedClazz_)) {
                            return doCached(arg0Value, arg1Value, s0_.cachedClazz_, s0_.cachedMethod_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(HostObject, Class<>) */) {
                    return doUncached(arg0Value, arg1Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private HostMethodDesc executeAndSpecialize(HostObject arg0Value, Class<?> arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(HostObject, Class<>, Class<>, HostMethodDesc) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostObject, Class<>, Class<>, HostMethodDesc) */) {
                        while (s0_ != null) {
                            if ((arg1Value == s0_.cachedClazz_)) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        // assert (arg1Value == s0_.cachedClazz_);
                        if (count0_ < (LookupConstructorNode.LIMIT)) {
                            s0_ = new CachedData(cached_cache);
                            s0_.cachedClazz_ = (arg1Value);
                            s0_.cachedMethod_ = (doUncached(arg0Value, arg1Value));
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(HostObject, Class<>, Class<>, HostMethodDesc) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value, arg1Value, s0_.cachedClazz_, s0_.cachedMethod_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(HostObject, Class<>, Class<>, HostMethodDesc) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(HostObject, Class<>, Class<>, HostMethodDesc) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(HostObject, Class<>) */;
                lock.unlock();
                hasLock = false;
                return doUncached(arg0Value, arg1Value);
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

        public static LookupConstructorNode create() {
            return new LookupConstructorNodeGen();
        }

        public static LookupConstructorNode getUncached() {
            return LookupConstructorNodeGen.UNCACHED;
        }

        @GeneratedBy(LookupConstructorNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal Class<?> cachedClazz_;
            @CompilationFinal HostMethodDesc cachedMethod_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
        @GeneratedBy(LookupConstructorNode.class)
        private static final class Uncached extends LookupConstructorNode {

            @TruffleBoundary
            @Override
            public HostMethodDesc execute(HostObject arg0Value, Class<?> arg1Value) {
                return doUncached(arg0Value, arg1Value);
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
    @GeneratedBy(LookupFieldNode.class)
    static final class LookupFieldNodeGen extends LookupFieldNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private LookupFieldNodeGen() {
        }

        @ExplodeLoop
        @Override
        public HostFieldDesc execute(HostObject arg0Value, Class<?> arg1Value, String arg2Value, boolean arg3Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostFieldDesc) || doUncached(HostObject, Class<>, String, boolean) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostFieldDesc) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((arg3Value == s0_.cachedStatic_) && (arg1Value == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg2Value))) {
                            return doCached(arg0Value, arg1Value, arg2Value, arg3Value, s0_.cachedStatic_, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedField_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(HostObject, Class<>, String, boolean) */) {
                    return doUncached(arg0Value, arg1Value, arg2Value, arg3Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
        }

        private HostFieldDesc executeAndSpecialize(HostObject arg0Value, Class<?> arg1Value, String arg2Value, boolean arg3Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostFieldDesc) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostFieldDesc) */) {
                        while (s0_ != null) {
                            if ((arg3Value == s0_.cachedStatic_) && (arg1Value == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg2Value))) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        // assert (arg3Value == s0_.cachedStatic_);
                        // assert (arg1Value == s0_.cachedClazz_);
                        // assert (s0_.cachedName_.equals(arg2Value));
                        if (count0_ < (LookupFieldNode.LIMIT)) {
                            s0_ = new CachedData(cached_cache);
                            s0_.cachedStatic_ = (arg3Value);
                            s0_.cachedClazz_ = (arg1Value);
                            s0_.cachedName_ = (arg2Value);
                            s0_.cachedField_ = (doUncached(arg0Value, arg1Value, arg2Value, arg3Value));
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostFieldDesc) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value, arg1Value, arg2Value, arg3Value, s0_.cachedStatic_, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedField_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostFieldDesc) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostFieldDesc) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(HostObject, Class<>, String, boolean) */;
                lock.unlock();
                hasLock = false;
                return doUncached(arg0Value, arg1Value, arg2Value, arg3Value);
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

        public static LookupFieldNode create() {
            return new LookupFieldNodeGen();
        }

        public static LookupFieldNode getUncached() {
            return LookupFieldNodeGen.UNCACHED;
        }

        @GeneratedBy(LookupFieldNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal boolean cachedStatic_;
            @CompilationFinal Class<?> cachedClazz_;
            @CompilationFinal String cachedName_;
            @CompilationFinal HostFieldDesc cachedField_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
        @GeneratedBy(LookupFieldNode.class)
        private static final class Uncached extends LookupFieldNode {

            @TruffleBoundary
            @Override
            public HostFieldDesc execute(HostObject arg0Value, Class<?> arg1Value, String arg2Value, boolean arg3Value) {
                return doUncached(arg0Value, arg1Value, arg2Value, arg3Value);
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
    @GeneratedBy(LookupFunctionalMethodNode.class)
    static final class LookupFunctionalMethodNodeGen extends LookupFunctionalMethodNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private LookupFunctionalMethodNodeGen() {
        }

        @ExplodeLoop
        @Override
        public HostMethodDesc execute(HostObject arg0Value, Class<?> arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(HostObject, Class<>, Class<>, HostMethodDesc) || doUncached(HostObject, Class<>) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostObject, Class<>, Class<>, HostMethodDesc) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((arg1Value == s0_.cachedClazz_)) {
                            return doCached(arg0Value, arg1Value, s0_.cachedClazz_, s0_.cachedMethod_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(HostObject, Class<>) */) {
                    return LookupFunctionalMethodNode.doUncached(arg0Value, arg1Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private HostMethodDesc executeAndSpecialize(HostObject arg0Value, Class<?> arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(HostObject, Class<>, Class<>, HostMethodDesc) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostObject, Class<>, Class<>, HostMethodDesc) */) {
                        while (s0_ != null) {
                            if ((arg1Value == s0_.cachedClazz_)) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        // assert (arg1Value == s0_.cachedClazz_);
                        if (count0_ < (LookupFunctionalMethodNode.LIMIT)) {
                            s0_ = new CachedData(cached_cache);
                            s0_.cachedClazz_ = (arg1Value);
                            s0_.cachedMethod_ = (LookupFunctionalMethodNode.doUncached(arg0Value, arg1Value));
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(HostObject, Class<>, Class<>, HostMethodDesc) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value, arg1Value, s0_.cachedClazz_, s0_.cachedMethod_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(HostObject, Class<>, Class<>, HostMethodDesc) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(HostObject, Class<>, Class<>, HostMethodDesc) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(HostObject, Class<>) */;
                lock.unlock();
                hasLock = false;
                return LookupFunctionalMethodNode.doUncached(arg0Value, arg1Value);
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

        public static LookupFunctionalMethodNode create() {
            return new LookupFunctionalMethodNodeGen();
        }

        public static LookupFunctionalMethodNode getUncached() {
            return LookupFunctionalMethodNodeGen.UNCACHED;
        }

        @GeneratedBy(LookupFunctionalMethodNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal Class<?> cachedClazz_;
            @CompilationFinal HostMethodDesc cachedMethod_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
        @GeneratedBy(LookupFunctionalMethodNode.class)
        private static final class Uncached extends LookupFunctionalMethodNode {

            @TruffleBoundary
            @Override
            public HostMethodDesc execute(HostObject arg0Value, Class<?> arg1Value) {
                return LookupFunctionalMethodNode.doUncached(arg0Value, arg1Value);
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
    @GeneratedBy(LookupInnerClassNode.class)
    static final class LookupInnerClassNodeGen extends LookupInnerClassNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private LookupInnerClassNodeGen() {
        }

        @ExplodeLoop
        @Override
        public Class<?> execute(Class<?> arg0Value, String arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(Class<>, String, Class<>, String, Class<>) || doUncached(Class<>, String) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(Class<>, String, Class<>, String, Class<>) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((arg0Value == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg1Value))) {
                            return doCached(arg0Value, arg1Value, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedInnerClass_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(Class<>, String) */) {
                    return doUncached(arg0Value, arg1Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private Class<?> executeAndSpecialize(Class<?> arg0Value, String arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(Class<>, String, Class<>, String, Class<>) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(Class<>, String, Class<>, String, Class<>) */) {
                        while (s0_ != null) {
                            if ((arg0Value == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg1Value))) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        // assert (arg0Value == s0_.cachedClazz_);
                        // assert (s0_.cachedName_.equals(arg1Value));
                        if (count0_ < (LookupInnerClassNode.LIMIT)) {
                            s0_ = new CachedData(cached_cache);
                            s0_.cachedClazz_ = (arg0Value);
                            s0_.cachedName_ = (arg1Value);
                            s0_.cachedInnerClass_ = (doUncached(arg0Value, arg1Value));
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(Class<>, String, Class<>, String, Class<>) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value, arg1Value, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedInnerClass_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(Class<>, String, Class<>, String, Class<>) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(Class<>, String, Class<>, String, Class<>) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(Class<>, String) */;
                lock.unlock();
                hasLock = false;
                return doUncached(arg0Value, arg1Value);
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

        public static LookupInnerClassNode create() {
            return new LookupInnerClassNodeGen();
        }

        public static LookupInnerClassNode getUncached() {
            return LookupInnerClassNodeGen.UNCACHED;
        }

        @GeneratedBy(LookupInnerClassNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal Class<?> cachedClazz_;
            @CompilationFinal String cachedName_;
            @CompilationFinal Class<?> cachedInnerClass_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
        @GeneratedBy(LookupInnerClassNode.class)
        private static final class Uncached extends LookupInnerClassNode {

            @TruffleBoundary
            @Override
            public Class<?> execute(Class<?> arg0Value, String arg1Value) {
                return doUncached(arg0Value, arg1Value);
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
    @GeneratedBy(LookupMethodNode.class)
    static final class LookupMethodNodeGen extends LookupMethodNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private LookupMethodNodeGen() {
        }

        @ExplodeLoop
        @Override
        public HostMethodDesc execute(HostObject arg0Value, Class<?> arg1Value, String arg2Value, boolean arg3Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostMethodDesc) || doUncached(HostObject, Class<>, String, boolean) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostMethodDesc) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((arg3Value == s0_.cachedStatic_) && (arg1Value == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg2Value))) {
                            return doCached(arg0Value, arg1Value, arg2Value, arg3Value, s0_.cachedStatic_, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedMethod_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(HostObject, Class<>, String, boolean) */) {
                    return doUncached(arg0Value, arg1Value, arg2Value, arg3Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
        }

        private HostMethodDesc executeAndSpecialize(HostObject arg0Value, Class<?> arg1Value, String arg2Value, boolean arg3Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostMethodDesc) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostMethodDesc) */) {
                        while (s0_ != null) {
                            if ((arg3Value == s0_.cachedStatic_) && (arg1Value == s0_.cachedClazz_) && (s0_.cachedName_.equals(arg2Value))) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        // assert (arg3Value == s0_.cachedStatic_);
                        // assert (arg1Value == s0_.cachedClazz_);
                        // assert (s0_.cachedName_.equals(arg2Value));
                        if (count0_ < (LookupMethodNode.LIMIT)) {
                            s0_ = new CachedData(cached_cache);
                            s0_.cachedStatic_ = (arg3Value);
                            s0_.cachedClazz_ = (arg1Value);
                            s0_.cachedName_ = (arg2Value);
                            s0_.cachedMethod_ = (doUncached(arg0Value, arg1Value, arg2Value, arg3Value));
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostMethodDesc) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value, arg1Value, arg2Value, arg3Value, s0_.cachedStatic_, s0_.cachedClazz_, s0_.cachedName_, s0_.cachedMethod_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostMethodDesc) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(HostObject, Class<>, String, boolean, boolean, Class<>, String, HostMethodDesc) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(HostObject, Class<>, String, boolean) */;
                lock.unlock();
                hasLock = false;
                return doUncached(arg0Value, arg1Value, arg2Value, arg3Value);
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

        public static LookupMethodNode create() {
            return new LookupMethodNodeGen();
        }

        public static LookupMethodNode getUncached() {
            return LookupMethodNodeGen.UNCACHED;
        }

        @GeneratedBy(LookupMethodNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal boolean cachedStatic_;
            @CompilationFinal Class<?> cachedClazz_;
            @CompilationFinal String cachedName_;
            @CompilationFinal HostMethodDesc cachedMethod_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
        @GeneratedBy(LookupMethodNode.class)
        private static final class Uncached extends LookupMethodNode {

            @TruffleBoundary
            @Override
            public HostMethodDesc execute(HostObject arg0Value, Class<?> arg1Value, String arg2Value, boolean arg3Value) {
                return doUncached(arg0Value, arg1Value, arg2Value, arg3Value);
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
    @GeneratedBy(ReadFieldNode.class)
    static final class ReadFieldNodeGen extends ReadFieldNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private CachedData cached_cache;
        @Child private ToGuestValueNode uncached_toGuest_;

        private ReadFieldNodeGen() {
        }

        @ExplodeLoop
        @Override
        public Object execute(HostFieldDesc arg0Value, HostObject arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(HostFieldDesc, HostObject, HostFieldDesc, ToGuestValueNode) || doUncached(HostFieldDesc, HostObject, ToGuestValueNode) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostFieldDesc, HostObject, HostFieldDesc, ToGuestValueNode) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((arg0Value == s0_.cachedField_)) {
                            return ReadFieldNode.doCached(arg0Value, arg1Value, s0_.cachedField_, s0_.toGuest_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(HostFieldDesc, HostObject, ToGuestValueNode) */) {
                    return ReadFieldNode.doUncached(arg0Value, arg1Value, this.uncached_toGuest_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private Object executeAndSpecialize(HostFieldDesc arg0Value, HostObject arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(HostFieldDesc, HostObject, HostFieldDesc, ToGuestValueNode) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostFieldDesc, HostObject, HostFieldDesc, ToGuestValueNode) */) {
                        while (s0_ != null) {
                            if ((arg0Value == s0_.cachedField_)) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        // assert (arg0Value == s0_.cachedField_);
                        if (count0_ < (ReadFieldNode.LIMIT)) {
                            s0_ = super.insert(new CachedData(cached_cache));
                            s0_.cachedField_ = (arg0Value);
                            s0_.toGuest_ = s0_.insertAccessor((ToGuestValueNodeGen.create()));
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(HostFieldDesc, HostObject, HostFieldDesc, ToGuestValueNode) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return ReadFieldNode.doCached(arg0Value, arg1Value, s0_.cachedField_, s0_.toGuest_);
                    }
                }
                this.uncached_toGuest_ = super.insert((ToGuestValueNodeGen.create()));
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(HostFieldDesc, HostObject, HostFieldDesc, ToGuestValueNode) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(HostFieldDesc, HostObject, HostFieldDesc, ToGuestValueNode) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(HostFieldDesc, HostObject, ToGuestValueNode) */;
                lock.unlock();
                hasLock = false;
                return ReadFieldNode.doUncached(arg0Value, arg1Value, this.uncached_toGuest_);
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

        public static ReadFieldNode create() {
            return new ReadFieldNodeGen();
        }

        public static ReadFieldNode getUncached() {
            return ReadFieldNodeGen.UNCACHED;
        }

        @GeneratedBy(ReadFieldNode.class)
        private static final class CachedData extends Node {

            @Child CachedData next_;
            @CompilationFinal HostFieldDesc cachedField_;
            @Child ToGuestValueNode toGuest_;

            CachedData(CachedData next_) {
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
        @GeneratedBy(ReadFieldNode.class)
        private static final class Uncached extends ReadFieldNode {

            @TruffleBoundary
            @Override
            public Object execute(HostFieldDesc arg0Value, HostObject arg1Value) {
                return ReadFieldNode.doUncached(arg0Value, arg1Value, (ToGuestValueNodeGen.getUncached()));
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
    @GeneratedBy(WriteFieldNode.class)
    static final class WriteFieldNodeGen extends WriteFieldNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private CachedData cached_cache;
        @Child private HostToTypeNode uncached_toHost_;

        private WriteFieldNodeGen() {
        }

        @ExplodeLoop
        @Override
        public void execute(HostFieldDesc arg0Value, HostObject arg1Value, Object arg2Value) throws UnsupportedTypeException, UnknownIdentifierException {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doCached(HostFieldDesc, HostObject, Object, HostFieldDesc, HostToTypeNode, BranchProfile) || doUncached(HostFieldDesc, HostObject, Object, HostToTypeNode) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostFieldDesc, HostObject, Object, HostFieldDesc, HostToTypeNode, BranchProfile) */) {
                    CachedData s0_ = this.cached_cache;
                    while (s0_ != null) {
                        if ((arg0Value == s0_.cachedField_)) {
                            WriteFieldNode.doCached(arg0Value, arg1Value, arg2Value, s0_.cachedField_, s0_.toHost_, s0_.error_);
                            return;
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(HostFieldDesc, HostObject, Object, HostToTypeNode) */) {
                    WriteFieldNode.doUncached(arg0Value, arg1Value, arg2Value, this.uncached_toHost_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arg0Value, arg1Value, arg2Value);
            return;
        }

        private void executeAndSpecialize(HostFieldDesc arg0Value, HostObject arg1Value, Object arg2Value) throws UnsupportedTypeException, UnknownIdentifierException {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if ((exclude) == 0 /* is-not-exclude doCached(HostFieldDesc, HostObject, Object, HostFieldDesc, HostToTypeNode, BranchProfile) */) {
                    int count0_ = 0;
                    CachedData s0_ = this.cached_cache;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(HostFieldDesc, HostObject, Object, HostFieldDesc, HostToTypeNode, BranchProfile) */) {
                        while (s0_ != null) {
                            if ((arg0Value == s0_.cachedField_)) {
                                break;
                            }
                            s0_ = s0_.next_;
                            count0_++;
                        }
                    }
                    if (s0_ == null) {
                        // assert (arg0Value == s0_.cachedField_);
                        if (count0_ < (WriteFieldNode.LIMIT)) {
                            s0_ = super.insert(new CachedData(cached_cache));
                            s0_.cachedField_ = (arg0Value);
                            s0_.toHost_ = s0_.insertAccessor((HostToTypeNodeGen.create()));
                            s0_.error_ = (BranchProfile.create());
                            MemoryFence.storeStore();
                            this.cached_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(HostFieldDesc, HostObject, Object, HostFieldDesc, HostToTypeNode, BranchProfile) */;
                        }
                    }
                    if (s0_ != null) {
                        lock.unlock();
                        hasLock = false;
                        WriteFieldNode.doCached(arg0Value, arg1Value, arg2Value, s0_.cachedField_, s0_.toHost_, s0_.error_);
                        return;
                    }
                }
                this.uncached_toHost_ = super.insert((HostToTypeNodeGen.create()));
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(HostFieldDesc, HostObject, Object, HostFieldDesc, HostToTypeNode, BranchProfile) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(HostFieldDesc, HostObject, Object, HostFieldDesc, HostToTypeNode, BranchProfile) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(HostFieldDesc, HostObject, Object, HostToTypeNode) */;
                lock.unlock();
                hasLock = false;
                WriteFieldNode.doUncached(arg0Value, arg1Value, arg2Value, this.uncached_toHost_);
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

        public static WriteFieldNode create() {
            return new WriteFieldNodeGen();
        }

        public static WriteFieldNode getUncached() {
            return WriteFieldNodeGen.UNCACHED;
        }

        @GeneratedBy(WriteFieldNode.class)
        private static final class CachedData extends Node {

            @Child CachedData next_;
            @CompilationFinal HostFieldDesc cachedField_;
            @Child HostToTypeNode toHost_;
            @CompilationFinal BranchProfile error_;

            CachedData(CachedData next_) {
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
        @GeneratedBy(WriteFieldNode.class)
        private static final class Uncached extends WriteFieldNode {

            @TruffleBoundary
            @Override
            public void execute(HostFieldDesc arg0Value, HostObject arg1Value, Object arg2Value) throws UnsupportedTypeException, UnknownIdentifierException {
                WriteFieldNode.doUncached(arg0Value, arg1Value, arg2Value, (HostToTypeNodeGen.getUncached()));
                return;
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
    @GeneratedBy(IsListNode.class)
    static final class IsListNodeGen extends IsListNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private boolean default_isListAccess_;

        private IsListNodeGen() {
        }

        @Override
        public boolean execute(HostObject arg0Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doNull(HostObject) || doDefault(HostObject, boolean) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doNull(HostObject) */) {
                    if ((arg0Value.obj == null)) {
                        return doNull(arg0Value);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doDefault(HostObject, boolean) */) {
                    if ((arg0Value.obj != null)) {
                        return doDefault(arg0Value, this.default_isListAccess_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private boolean executeAndSpecialize(HostObject arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if ((arg0Value.obj == null)) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNull(HostObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    this.default_isListAccess_ = (arg0Value.getHostClassCache().isListAccess());
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDefault(HostObject, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doDefault(arg0Value, this.default_isListAccess_);
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

        public static IsListNode create() {
            return new IsListNodeGen();
        }

        public static IsListNode getUncached() {
            return IsListNodeGen.UNCACHED;
        }

        @GeneratedBy(IsListNode.class)
        private static final class Uncached extends IsListNode {

            @TruffleBoundary
            @Override
            public boolean execute(HostObject arg0Value) {
                if ((arg0Value.obj == null)) {
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    return doDefault(arg0Value, (arg0Value.getHostClassCache().isListAccess()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
    @GeneratedBy(IsArrayNode.class)
    static final class IsArrayNodeGen extends IsArrayNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private boolean default_isArrayAccess_;

        private IsArrayNodeGen() {
        }

        @Override
        public boolean execute(HostObject arg0Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doNull(HostObject) || doDefault(HostObject, boolean) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doNull(HostObject) */) {
                    if ((arg0Value.obj == null)) {
                        return doNull(arg0Value);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doDefault(HostObject, boolean) */) {
                    if ((arg0Value.obj != null)) {
                        return doDefault(arg0Value, this.default_isArrayAccess_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private boolean executeAndSpecialize(HostObject arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if ((arg0Value.obj == null)) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNull(HostObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    this.default_isArrayAccess_ = (arg0Value.getHostClassCache().isArrayAccess());
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDefault(HostObject, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doDefault(arg0Value, this.default_isArrayAccess_);
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

        public static IsArrayNode create() {
            return new IsArrayNodeGen();
        }

        public static IsArrayNode getUncached() {
            return IsArrayNodeGen.UNCACHED;
        }

        @GeneratedBy(IsArrayNode.class)
        private static final class Uncached extends IsArrayNode {

            @TruffleBoundary
            @Override
            public boolean execute(HostObject arg0Value) {
                if ((arg0Value.obj == null)) {
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    return doDefault(arg0Value, (arg0Value.getHostClassCache().isArrayAccess()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
    @GeneratedBy(IsBufferNode.class)
    static final class IsBufferNodeGen extends IsBufferNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private boolean default_isBufferAccess_;

        private IsBufferNodeGen() {
        }

        @Override
        public boolean execute(HostObject arg0Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doNull(HostObject) || doDefault(HostObject, boolean) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doNull(HostObject) */) {
                    if ((arg0Value.obj == null)) {
                        return doNull(arg0Value);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doDefault(HostObject, boolean) */) {
                    if ((arg0Value.obj != null)) {
                        return doDefault(arg0Value, this.default_isBufferAccess_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private boolean executeAndSpecialize(HostObject arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if ((arg0Value.obj == null)) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNull(HostObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    this.default_isBufferAccess_ = (arg0Value.getHostClassCache().isBufferAccess());
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDefault(HostObject, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doDefault(arg0Value, this.default_isBufferAccess_);
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

        public static IsBufferNode create() {
            return new IsBufferNodeGen();
        }

        public static IsBufferNode getUncached() {
            return IsBufferNodeGen.UNCACHED;
        }

        @GeneratedBy(IsBufferNode.class)
        private static final class Uncached extends IsBufferNode {

            @TruffleBoundary
            @Override
            public boolean execute(HostObject arg0Value) {
                if ((arg0Value.obj == null)) {
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    return doDefault(arg0Value, (arg0Value.getHostClassCache().isBufferAccess()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
    @GeneratedBy(IsIterableNode.class)
    static final class IsIterableNodeGen extends IsIterableNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private boolean default_isIterableAccess_;

        private IsIterableNodeGen() {
        }

        @Override
        public boolean execute(HostObject arg0Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doNull(HostObject) || doDefault(HostObject, boolean) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doNull(HostObject) */) {
                    if ((arg0Value.obj == null)) {
                        return doNull(arg0Value);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doDefault(HostObject, boolean) */) {
                    if ((arg0Value.obj != null)) {
                        return doDefault(arg0Value, this.default_isIterableAccess_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private boolean executeAndSpecialize(HostObject arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if ((arg0Value.obj == null)) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNull(HostObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    this.default_isIterableAccess_ = (arg0Value.getHostClassCache().isIterableAccess());
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDefault(HostObject, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doDefault(arg0Value, this.default_isIterableAccess_);
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

        public static IsIterableNode create() {
            return new IsIterableNodeGen();
        }

        public static IsIterableNode getUncached() {
            return IsIterableNodeGen.UNCACHED;
        }

        @GeneratedBy(IsIterableNode.class)
        private static final class Uncached extends IsIterableNode {

            @TruffleBoundary
            @Override
            public boolean execute(HostObject arg0Value) {
                if ((arg0Value.obj == null)) {
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    return doDefault(arg0Value, (arg0Value.getHostClassCache().isIterableAccess()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
    @GeneratedBy(IsIteratorNode.class)
    static final class IsIteratorNodeGen extends IsIteratorNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private boolean default_isIteratorAccess_;

        private IsIteratorNodeGen() {
        }

        @Override
        public boolean execute(HostObject arg0Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doNull(HostObject) || doDefault(HostObject, boolean) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doNull(HostObject) */) {
                    if ((arg0Value.obj == null)) {
                        return doNull(arg0Value);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doDefault(HostObject, boolean) */) {
                    if ((arg0Value.obj != null)) {
                        return doDefault(arg0Value, this.default_isIteratorAccess_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private boolean executeAndSpecialize(HostObject arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if ((arg0Value.obj == null)) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNull(HostObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    this.default_isIteratorAccess_ = (arg0Value.getHostClassCache().isIteratorAccess());
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDefault(HostObject, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doDefault(arg0Value, this.default_isIteratorAccess_);
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

        public static IsIteratorNode create() {
            return new IsIteratorNodeGen();
        }

        public static IsIteratorNode getUncached() {
            return IsIteratorNodeGen.UNCACHED;
        }

        @GeneratedBy(IsIteratorNode.class)
        private static final class Uncached extends IsIteratorNode {

            @TruffleBoundary
            @Override
            public boolean execute(HostObject arg0Value) {
                if ((arg0Value.obj == null)) {
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    return doDefault(arg0Value, (arg0Value.getHostClassCache().isIteratorAccess()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
    @GeneratedBy(IsMapNode.class)
    static final class IsMapNodeGen extends IsMapNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private boolean default_isMapAccess_;

        private IsMapNodeGen() {
        }

        @Override
        public boolean execute(HostObject arg0Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doNull(HostObject) || doDefault(HostObject, boolean) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doNull(HostObject) */) {
                    if ((arg0Value.obj == null)) {
                        return doNull(arg0Value);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doDefault(HostObject, boolean) */) {
                    if ((arg0Value.obj != null)) {
                        return doDefault(arg0Value, this.default_isMapAccess_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private boolean executeAndSpecialize(HostObject arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if ((arg0Value.obj == null)) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNull(HostObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    this.default_isMapAccess_ = (arg0Value.getHostClassCache().isMapAccess());
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDefault(HostObject, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doDefault(arg0Value, this.default_isMapAccess_);
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

        public static IsMapNode create() {
            return new IsMapNodeGen();
        }

        public static IsMapNode getUncached() {
            return IsMapNodeGen.UNCACHED;
        }

        @GeneratedBy(IsMapNode.class)
        private static final class Uncached extends IsMapNode {

            @TruffleBoundary
            @Override
            public boolean execute(HostObject arg0Value) {
                if ((arg0Value.obj == null)) {
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    return doDefault(arg0Value, (arg0Value.getHostClassCache().isMapAccess()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
    @GeneratedBy(ContainsKeyNode.class)
    static final class ContainsKeyNodeGen extends ContainsKeyNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @Child private IsMapNode isMap;
        @Child private HostToTypeNode map_toHost_;
        @CompilationFinal private BranchProfile map_error_;

        private ContainsKeyNodeGen() {
        }

        @Override
        public boolean execute(HostObject arg0Value, Object arg1Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doMap(HostObject, Object, IsMapNode, HostToTypeNode, BranchProfile) || doNotMap(HostObject, Object, IsMapNode) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doMap(HostObject, Object, IsMapNode, HostToTypeNode, BranchProfile) */) {
                    if ((this.isMap.execute(arg0Value))) {
                        return ContainsKeyNode.doMap(arg0Value, arg1Value, this.isMap, this.map_toHost_, this.map_error_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doNotMap(HostObject, Object, IsMapNode) */) {
                    if ((!(this.isMap.execute(arg0Value)))) {
                        return ContainsKeyNode.doNotMap(arg0Value, arg1Value, this.isMap);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private boolean executeAndSpecialize(HostObject arg0Value, Object arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                boolean Map_duplicateFound_ = false;
                if ((state_0 & 0b1) != 0 /* is-state_0 doMap(HostObject, Object, IsMapNode, HostToTypeNode, BranchProfile) */) {
                    if ((this.isMap.execute(arg0Value))) {
                        Map_duplicateFound_ = true;
                    }
                }
                if (!Map_duplicateFound_) {
                    {
                        IsMapNode map_isMap__ = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                        if ((map_isMap__.execute(arg0Value)) && ((state_0 & 0b1)) == 0 /* is-not-state_0 doMap(HostObject, Object, IsMapNode, HostToTypeNode, BranchProfile) */) {
                            if (this.isMap == null) {
                                IsMapNode map_isMap___check = super.insert(map_isMap__);
                                if (map_isMap___check == null) {
                                    throw new AssertionError("Specialization 'doMap(HostObject, Object, IsMapNode, HostToTypeNode, BranchProfile)' contains a shared cache with name 'isMap' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                }
                                this.isMap = map_isMap___check;
                            }
                            this.map_toHost_ = super.insert((HostToTypeNodeGen.create()));
                            this.map_error_ = (BranchProfile.create());
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doMap(HostObject, Object, IsMapNode, HostToTypeNode, BranchProfile) */;
                            Map_duplicateFound_ = true;
                        }
                    }
                }
                if (Map_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return ContainsKeyNode.doMap(arg0Value, arg1Value, this.isMap, this.map_toHost_, this.map_error_);
                }
                boolean NotMap_duplicateFound_ = false;
                if ((state_0 & 0b10) != 0 /* is-state_0 doNotMap(HostObject, Object, IsMapNode) */) {
                    if ((!(this.isMap.execute(arg0Value)))) {
                        NotMap_duplicateFound_ = true;
                    }
                }
                if (!NotMap_duplicateFound_) {
                    {
                        IsMapNode notMap_isMap__ = super.insert(this.isMap == null ? ((IsMapNodeGen.create())) : this.isMap);
                        if ((!(notMap_isMap__.execute(arg0Value))) && ((state_0 & 0b10)) == 0 /* is-not-state_0 doNotMap(HostObject, Object, IsMapNode) */) {
                            if (this.isMap == null) {
                                IsMapNode notMap_isMap___check = super.insert(notMap_isMap__);
                                if (notMap_isMap___check == null) {
                                    throw new AssertionError("Specialization 'doNotMap(HostObject, Object, IsMapNode)' contains a shared cache with name 'isMap' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                }
                                this.isMap = notMap_isMap___check;
                            }
                            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doNotMap(HostObject, Object, IsMapNode) */;
                            NotMap_duplicateFound_ = true;
                        }
                    }
                }
                if (NotMap_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return ContainsKeyNode.doNotMap(arg0Value, arg1Value, this.isMap);
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
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static ContainsKeyNode create() {
            return new ContainsKeyNodeGen();
        }

        public static ContainsKeyNode getUncached() {
            return ContainsKeyNodeGen.UNCACHED;
        }

        @GeneratedBy(ContainsKeyNode.class)
        private static final class Uncached extends ContainsKeyNode {

            @TruffleBoundary
            @Override
            public boolean execute(HostObject arg0Value, Object arg1Value) {
                if (((IsMapNodeGen.getUncached()).execute(arg0Value))) {
                    return ContainsKeyNode.doMap(arg0Value, arg1Value, (IsMapNodeGen.getUncached()), (HostToTypeNodeGen.getUncached()), (BranchProfile.getUncached()));
                }
                if ((!((IsMapNodeGen.getUncached()).execute(arg0Value)))) {
                    return ContainsKeyNode.doNotMap(arg0Value, arg1Value, (IsMapNodeGen.getUncached()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
    @GeneratedBy(IsMapEntryNode.class)
    static final class IsMapEntryNodeGen extends IsMapEntryNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private boolean default_isMapAccess_;

        private IsMapEntryNodeGen() {
        }

        @Override
        public boolean execute(HostObject arg0Value) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 doNull(HostObject) || doDefault(HostObject, boolean) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 doNull(HostObject) */) {
                    if ((arg0Value.obj == null)) {
                        return doNull(arg0Value);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doDefault(HostObject, boolean) */) {
                    if ((arg0Value.obj != null)) {
                        return doDefault(arg0Value, this.default_isMapAccess_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private boolean executeAndSpecialize(HostObject arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if ((arg0Value.obj == null)) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doNull(HostObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    this.default_isMapAccess_ = (arg0Value.getHostClassCache().isMapAccess());
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doDefault(HostObject, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doDefault(arg0Value, this.default_isMapAccess_);
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

        public static IsMapEntryNode create() {
            return new IsMapEntryNodeGen();
        }

        public static IsMapEntryNode getUncached() {
            return IsMapEntryNodeGen.UNCACHED;
        }

        @GeneratedBy(IsMapEntryNode.class)
        private static final class Uncached extends IsMapEntryNode {

            @TruffleBoundary
            @Override
            public boolean execute(HostObject arg0Value) {
                if ((arg0Value.obj == null)) {
                    return doNull(arg0Value);
                }
                if ((arg0Value.obj != null)) {
                    return doDefault(arg0Value, (arg0Value.getHostClassCache().isMapAccess()));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
}
