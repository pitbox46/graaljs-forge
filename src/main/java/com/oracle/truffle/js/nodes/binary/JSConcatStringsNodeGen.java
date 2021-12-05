// CheckStyle: start generated
package com.oracle.truffle.js.nodes.binary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSConcatStringsNode.class)
public final class JSConcatStringsNodeGen extends JSConcatStringsNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private ConcatData concat_cache;

    private JSConcatStringsNodeGen(int stringLengthLimit) {
        super(stringLengthLimit);
    }

    @Override
    public CharSequence executeCharSequence(CharSequence arg0Value, CharSequence arg1Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) != 0 /* is-state_0 doLeftEmpty(CharSequence, CharSequence) || doRightEmpty(CharSequence, CharSequence) || doConcat(CharSequence, CharSequence, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, BranchProfile) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doLeftEmpty(CharSequence, CharSequence) */) {
                if ((JSConcatStringsNode.isEmptyString(arg0Value))) {
                    return JSConcatStringsNode.doLeftEmpty(arg0Value, arg1Value);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doRightEmpty(CharSequence, CharSequence) */) {
                if ((JSConcatStringsNode.isEmptyString(arg1Value))) {
                    return JSConcatStringsNode.doRightEmpty(arg0Value, arg1Value);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doConcat(CharSequence, CharSequence, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, BranchProfile) */) {
                ConcatData s2_ = this.concat_cache;
                if (s2_ != null) {
                    if ((!(JSConcatStringsNode.isEmptyString(arg0Value))) && (!(JSConcatStringsNode.isEmptyString(arg1Value)))) {
                        return doConcat(arg0Value, arg1Value, s2_.leftIsString_, s2_.leftIsLazyString_, s2_.leftIsFlat_, s2_.rightIsString_, s2_.rightIsLazyString_, s2_.rightIsFlat_, s2_.stringLength_, s2_.shortStringAppend_, s2_.errorBranch_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private CharSequence executeAndSpecialize(CharSequence arg0Value, CharSequence arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if ((JSConcatStringsNode.isEmptyString(arg0Value))) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doLeftEmpty(CharSequence, CharSequence) */;
                lock.unlock();
                hasLock = false;
                return JSConcatStringsNode.doLeftEmpty(arg0Value, arg1Value);
            }
            if ((JSConcatStringsNode.isEmptyString(arg1Value))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doRightEmpty(CharSequence, CharSequence) */;
                lock.unlock();
                hasLock = false;
                return JSConcatStringsNode.doRightEmpty(arg0Value, arg1Value);
            }
            if ((!(JSConcatStringsNode.isEmptyString(arg0Value))) && (!(JSConcatStringsNode.isEmptyString(arg1Value)))) {
                ConcatData s2_ = new ConcatData();
                s2_.leftIsString_ = (ConditionProfile.createBinaryProfile());
                s2_.leftIsLazyString_ = (ConditionProfile.createBinaryProfile());
                s2_.leftIsFlat_ = (ConditionProfile.createBinaryProfile());
                s2_.rightIsString_ = (ConditionProfile.createBinaryProfile());
                s2_.rightIsLazyString_ = (ConditionProfile.createBinaryProfile());
                s2_.rightIsFlat_ = (ConditionProfile.createBinaryProfile());
                s2_.stringLength_ = (ConditionProfile.createBinaryProfile());
                s2_.shortStringAppend_ = (ConditionProfile.createBinaryProfile());
                s2_.errorBranch_ = (BranchProfile.create());
                MemoryFence.storeStore();
                this.concat_cache = s2_;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doConcat(CharSequence, CharSequence, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doConcat(arg0Value, arg1Value, s2_.leftIsString_, s2_.leftIsLazyString_, s2_.leftIsFlat_, s2_.rightIsString_, s2_.rightIsLazyString_, s2_.rightIsFlat_, s2_.stringLength_, s2_.shortStringAppend_, s2_.errorBranch_);
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
        if ((state_0 & 0b111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
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
        s[0] = "doLeftEmpty";
        if ((state_0 & 0b1) != 0 /* is-state_0 doLeftEmpty(CharSequence, CharSequence) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doRightEmpty";
        if ((state_0 & 0b10) != 0 /* is-state_0 doRightEmpty(CharSequence, CharSequence) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doConcat";
        if ((state_0 & 0b100) != 0 /* is-state_0 doConcat(CharSequence, CharSequence, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ConcatData s2_ = this.concat_cache;
            if (s2_ != null) {
                cached.add(Arrays.asList(s2_.leftIsString_, s2_.leftIsLazyString_, s2_.leftIsFlat_, s2_.rightIsString_, s2_.rightIsLazyString_, s2_.rightIsFlat_, s2_.stringLength_, s2_.shortStringAppend_, s2_.errorBranch_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static JSConcatStringsNode create(int stringLengthLimit) {
        return new JSConcatStringsNodeGen(stringLengthLimit);
    }

    @GeneratedBy(JSConcatStringsNode.class)
    private static final class ConcatData {

        @CompilationFinal ConditionProfile leftIsString_;
        @CompilationFinal ConditionProfile leftIsLazyString_;
        @CompilationFinal ConditionProfile leftIsFlat_;
        @CompilationFinal ConditionProfile rightIsString_;
        @CompilationFinal ConditionProfile rightIsLazyString_;
        @CompilationFinal ConditionProfile rightIsFlat_;
        @CompilationFinal ConditionProfile stringLength_;
        @CompilationFinal ConditionProfile shortStringAppend_;
        @CompilationFinal BranchProfile errorBranch_;

        ConcatData() {
        }

    }
}
