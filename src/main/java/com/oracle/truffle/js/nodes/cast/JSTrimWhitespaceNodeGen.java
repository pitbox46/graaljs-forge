// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

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

@GeneratedBy(JSTrimWhitespaceNode.class)
public final class JSTrimWhitespaceNodeGen extends JSTrimWhitespaceNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private StringData string_cache;

    private JSTrimWhitespaceNodeGen() {
    }

    @Override
    public String executeString(String arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111) != 0 /* is-state_0 doStringZero(String) || doStringNoWhitespace(String) || doString(String, BranchProfile, BranchProfile, ConditionProfile) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 doStringZero(String) */) {
                if ((arg0Value.length() == 0)) {
                    return doStringZero(arg0Value);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doStringNoWhitespace(String) */) {
                if ((arg0Value.length() > 0) && (!(startsOrEndsWithWhitespace(arg0Value)))) {
                    return doStringNoWhitespace(arg0Value);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doString(String, BranchProfile, BranchProfile, ConditionProfile) */) {
                StringData s2_ = this.string_cache;
                if (s2_ != null) {
                    if ((arg0Value.length() > 0) && (startsOrEndsWithWhitespace(arg0Value))) {
                        return doString(arg0Value, s2_.needFirstBranch_, s2_.needLastBranch_, s2_.needSubstring_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private String executeAndSpecialize(String arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            if ((arg0Value.length() == 0)) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doStringZero(String) */;
                lock.unlock();
                hasLock = false;
                return doStringZero(arg0Value);
            }
            if ((arg0Value.length() > 0) && (!(startsOrEndsWithWhitespace(arg0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doStringNoWhitespace(String) */;
                lock.unlock();
                hasLock = false;
                return doStringNoWhitespace(arg0Value);
            }
            if ((arg0Value.length() > 0) && (startsOrEndsWithWhitespace(arg0Value))) {
                StringData s2_ = new StringData();
                s2_.needFirstBranch_ = (BranchProfile.create());
                s2_.needLastBranch_ = (BranchProfile.create());
                s2_.needSubstring_ = (ConditionProfile.createBinaryProfile());
                MemoryFence.storeStore();
                this.string_cache = s2_;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doString(String, BranchProfile, BranchProfile, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doString(arg0Value, s2_.needFirstBranch_, s2_.needLastBranch_, s2_.needSubstring_);
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
        s[0] = "doStringZero";
        if ((state_0 & 0b1) != 0 /* is-state_0 doStringZero(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doStringNoWhitespace";
        if ((state_0 & 0b10) != 0 /* is-state_0 doStringNoWhitespace(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b100) != 0 /* is-state_0 doString(String, BranchProfile, BranchProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            StringData s2_ = this.string_cache;
            if (s2_ != null) {
                cached.add(Arrays.asList(s2_.needFirstBranch_, s2_.needLastBranch_, s2_.needSubstring_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static JSTrimWhitespaceNode create() {
        return new JSTrimWhitespaceNodeGen();
    }

    @GeneratedBy(JSTrimWhitespaceNode.class)
    private static final class StringData {

        @CompilationFinal BranchProfile needFirstBranch_;
        @CompilationFinal BranchProfile needLastBranch_;
        @CompilationFinal ConditionProfile needSubstring_;

        StringData() {
        }

    }
}
