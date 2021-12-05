// CheckStyle: start generated
package com.oracle.truffle.js.nodes.function;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(EvalNode.class)
public final class EvalNodeGen extends EvalNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @Child private JSFunctionCallNode evalOverridden_redirectCall_;

    private EvalNodeGen(JSContext context, JavaScriptNode function, JavaScriptNode[] args, JavaScriptNode thisObject, Object env, FrameSlot blockScopeSlot) {
        super(context, function, args, thisObject, env, blockScopeSlot);
    }

    private EvalNodeGen(JSContext context, JavaScriptNode functionNode, AbstractFunctionArgumentsNode arguments, DirectEvalNode directEvalNode) {
        super(context, functionNode, arguments, directEvalNode);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object functionNodeValue_ = super.functionNode.execute(frameValue);
        if (state_0 != 0 /* is-state_0 evalNotOverridden(VirtualFrame, Object) || evalOverridden(VirtualFrame, Object, JSFunctionCallNode) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 evalNotOverridden(VirtualFrame, Object) */) {
                if ((!(isEvalOverridden(functionNodeValue_)))) {
                    return evalNotOverridden(frameValue, functionNodeValue_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 evalOverridden(VirtualFrame, Object, JSFunctionCallNode) */) {
                if ((isEvalOverridden(functionNodeValue_))) {
                    return evalOverridden(frameValue, functionNodeValue_, this.evalOverridden_redirectCall_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, functionNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(VirtualFrame frameValue, Object functionNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if ((!(isEvalOverridden(functionNodeValue)))) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 evalNotOverridden(VirtualFrame, Object) */;
                lock.unlock();
                hasLock = false;
                return evalNotOverridden(frameValue, functionNodeValue);
            }
            if ((isEvalOverridden(functionNodeValue))) {
                this.evalOverridden_redirectCall_ = super.insert((JSFunctionCallNode.createCall()));
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 evalOverridden(VirtualFrame, Object, JSFunctionCallNode) */;
                lock.unlock();
                hasLock = false;
                return evalOverridden(frameValue, functionNodeValue, this.evalOverridden_redirectCall_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.functionNode}, functionNodeValue);
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
        s[0] = "evalNotOverridden";
        if ((state_0 & 0b1) != 0 /* is-state_0 evalNotOverridden(VirtualFrame, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "evalOverridden";
        if ((state_0 & 0b10) != 0 /* is-state_0 evalOverridden(VirtualFrame, Object, JSFunctionCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.evalOverridden_redirectCall_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static EvalNode create(JSContext context, JavaScriptNode function, JavaScriptNode[] args, JavaScriptNode thisObject, Object env, FrameSlot blockScopeSlot) {
        return new EvalNodeGen(context, function, args, thisObject, env, blockScopeSlot);
    }

    public static EvalNode create(JSContext context, JavaScriptNode functionNode, AbstractFunctionArgumentsNode arguments, DirectEvalNode directEvalNode) {
        return new EvalNodeGen(context, functionNode, arguments, directEvalNode);
    }

    @GeneratedBy(DirectEvalNode.class)
    protected static final class DirectEvalNodeGen extends DirectEvalNode implements Introspection.Provider {

        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private DirectEvalForeignObject0Data directEvalForeignObject0_cache;

        private DirectEvalNodeGen(JSContext context, JavaScriptNode thisNode, Object currEnv, FrameSlot blockScopeSlot) {
            super(context, thisNode, currEnv, blockScopeSlot);
        }

        @ExplodeLoop
        @Override
        public Object executeWithSource(VirtualFrame frameValue, Object arg0Value) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) != 0 /* is-state_0 directEvalInt(int) */ && arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                return directEvalInt(arg0Value_);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 directEvalSafeInteger(SafeInteger) */ && arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                return directEvalSafeInteger(arg0Value_);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 directEvalLong(long) */ && arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                return directEvalLong(arg0Value_);
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 directEvalDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100000000000) >>> 11 /* extract-implicit-state_0 0:double */, arg0Value)) {
                double arg0Value_ = JSTypesGen.asImplicitDouble((state_0 & 0b111100000000000) >>> 11 /* extract-implicit-state_0 0:double */, arg0Value);
                return directEvalDouble(arg0Value_);
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 directEvalBoolean(boolean) */ && arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                return directEvalBoolean(arg0Value_);
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 directEvalSymbol(Symbol) */ && arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                return directEvalSymbol(arg0Value_);
            }
            if ((state_0 & 0b1000000) != 0 /* is-state_0 directEvalBigInt(BigInt) */ && arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                return directEvalBigInt(arg0Value_);
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 directEvalJSType(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                    return directEvalJSType(arg0Value_);
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 directEvalCharSequence(VirtualFrame, CharSequence) */ && JSTypesGen.isImplicitCharSequence((state_0 & 0x38000) >>> 15 /* extract-implicit-state_0 0:CharSequence */, arg0Value)) {
                CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence((state_0 & 0x38000) >>> 15 /* extract-implicit-state_0 0:CharSequence */, arg0Value);
                return directEvalCharSequence(frameValue, arg0Value_);
            }
            if ((state_0 & 0b11000000000) != 0 /* is-state_0 directEvalForeignObject(VirtualFrame, Object, InteropLibrary) || directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                    DirectEvalForeignObject0Data s9_ = this.directEvalForeignObject0_cache;
                    while (s9_ != null) {
                        if ((s9_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                            return directEvalForeignObject(frameValue, arg0Value, s9_.interop_);
                        }
                        s9_ = s9_.next_;
                    }
                }
                if ((state_0 & 0b10000000000) != 0 /* is-state_0 directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arg0Value))) {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            {
                                InteropLibrary directEvalForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached());
                                return directEvalForeignObject(frameValue, arg0Value, directEvalForeignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arg0Value);
        }

        private Object executeAndSpecialize(VirtualFrame frameValue, Object arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (arg0Value instanceof Integer) {
                    int arg0Value_ = (int) arg0Value;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 directEvalInt(int) */;
                    lock.unlock();
                    hasLock = false;
                    return directEvalInt(arg0Value_);
                }
                if (arg0Value instanceof SafeInteger) {
                    SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 directEvalSafeInteger(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return directEvalSafeInteger(arg0Value_);
                }
                if (arg0Value instanceof Long) {
                    long arg0Value_ = (long) arg0Value;
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 directEvalLong(long) */;
                    lock.unlock();
                    hasLock = false;
                    return directEvalLong(arg0Value_);
                }
                {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                        double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                        state_0 = (state_0 | (doubleCast0 << 11) /* set-implicit-state_0 0:double */);
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 directEvalDouble(double) */;
                        lock.unlock();
                        hasLock = false;
                        return directEvalDouble(arg0Value_);
                    }
                }
                if (arg0Value instanceof Boolean) {
                    boolean arg0Value_ = (boolean) arg0Value;
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 directEvalBoolean(boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return directEvalBoolean(arg0Value_);
                }
                if (arg0Value instanceof Symbol) {
                    Symbol arg0Value_ = (Symbol) arg0Value;
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 directEvalSymbol(Symbol) */;
                    lock.unlock();
                    hasLock = false;
                    return directEvalSymbol(arg0Value_);
                }
                if (arg0Value instanceof BigInt) {
                    BigInt arg0Value_ = (BigInt) arg0Value;
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 directEvalBigInt(BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return directEvalBigInt(arg0Value_);
                }
                if (JSTypes.isDynamicObject(arg0Value)) {
                    DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                    if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 directEvalJSType(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return directEvalJSType(arg0Value_);
                    }
                }
                {
                    int charSequenceCast0;
                    if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(arg0Value)) != 0) {
                        CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, arg0Value);
                        state_0 = (state_0 | (charSequenceCast0 << 15) /* set-implicit-state_0 0:CharSequence */);
                        this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 directEvalCharSequence(VirtualFrame, CharSequence) */;
                        lock.unlock();
                        hasLock = false;
                        return directEvalCharSequence(frameValue, arg0Value_);
                    }
                }
                if ((exclude) == 0 /* is-not-exclude directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                    int count9_ = 0;
                    DirectEvalForeignObject0Data s9_ = this.directEvalForeignObject0_cache;
                    if ((state_0 & 0b1000000000) != 0 /* is-state_0 directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                        while (s9_ != null) {
                            if ((s9_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                                break;
                            }
                            s9_ = s9_.next_;
                            count9_++;
                        }
                    }
                    if (s9_ == null) {
                        if ((JSGuards.isForeignObject(arg0Value)) && count9_ < (3)) {
                            // assert (s9_.interop_.accepts(arg0Value));
                            s9_ = super.insert(new DirectEvalForeignObject0Data(directEvalForeignObject0_cache));
                            s9_.interop_ = s9_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                            MemoryFence.storeStore();
                            this.directEvalForeignObject0_cache = s9_;
                            this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */;
                        }
                    }
                    if (s9_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return directEvalForeignObject(frameValue, arg0Value, s9_.interop_);
                    }
                }
                {
                    InteropLibrary directEvalForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arg0Value))) {
                                directEvalForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */;
                                this.directEvalForeignObject0_cache = null;
                                state_0 = state_0 & 0xfffffdff /* remove-state_0 directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10000000000 /* add-state_0 directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return directEvalForeignObject(frameValue, arg0Value, directEvalForeignObject1_interop__);
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
            if ((state_0 & 0b11111111111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b11111111111) & ((state_0 & 0b11111111111) - 1)) == 0 /* is-single-state_0  */) {
                    DirectEvalForeignObject0Data s9_ = this.directEvalForeignObject0_cache;
                    if ((s9_ == null || s9_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[12];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            s = new Object[3];
            s[0] = "directEvalInt";
            if ((state_0 & 0b1) != 0 /* is-state_0 directEvalInt(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "directEvalSafeInteger";
            if ((state_0 & 0b10) != 0 /* is-state_0 directEvalSafeInteger(SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "directEvalLong";
            if ((state_0 & 0b100) != 0 /* is-state_0 directEvalLong(long) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "directEvalDouble";
            if ((state_0 & 0b1000) != 0 /* is-state_0 directEvalDouble(double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "directEvalBoolean";
            if ((state_0 & 0b10000) != 0 /* is-state_0 directEvalBoolean(boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "directEvalSymbol";
            if ((state_0 & 0b100000) != 0 /* is-state_0 directEvalSymbol(Symbol) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "directEvalBigInt";
            if ((state_0 & 0b1000000) != 0 /* is-state_0 directEvalBigInt(BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "directEvalJSType";
            if ((state_0 & 0b10000000) != 0 /* is-state_0 directEvalJSType(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "directEvalCharSequence";
            if ((state_0 & 0b100000000) != 0 /* is-state_0 directEvalCharSequence(VirtualFrame, CharSequence) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            s = new Object[3];
            s[0] = "directEvalForeignObject";
            if ((state_0 & 0b1000000000) != 0 /* is-state_0 directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                DirectEvalForeignObject0Data s9_ = this.directEvalForeignObject0_cache;
                while (s9_ != null) {
                    cached.add(Arrays.asList(s9_.interop_));
                    s9_ = s9_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-exclude directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[10] = s;
            s = new Object[3];
            s[0] = "directEvalForeignObject";
            if ((state_0 & 0b10000000000) != 0 /* is-state_0 directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[11] = s;
            return Provider.create(data);
        }

        public static DirectEvalNode create(JSContext context, JavaScriptNode thisNode, Object currEnv, FrameSlot blockScopeSlot) {
            return new DirectEvalNodeGen(context, thisNode, currEnv, blockScopeSlot);
        }

        @GeneratedBy(DirectEvalNode.class)
        private static final class DirectEvalForeignObject0Data extends Node {

            @Child DirectEvalForeignObject0Data next_;
            @Child InteropLibrary interop_;

            DirectEvalForeignObject0Data(DirectEvalForeignObject0Data next_) {
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
