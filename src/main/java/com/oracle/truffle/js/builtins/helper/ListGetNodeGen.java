// CheckStyle: start generated
package com.oracle.truffle.js.builtins.helper;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.runtime.util.UnmodifiableArrayList;
import com.oracle.truffle.js.runtime.util.UnmodifiablePropertyKeyList;
import java.util.ArrayList;

@GeneratedBy(ListGetNode.class)
@SuppressWarnings("unused")
public final class ListGetNodeGen extends ListGetNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private ListGetNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value, int arg1Value) {
        int state_0 = this.state_0_;
        if (state_0 != 0 /* is-state_0 unmodifiableArrayList(UnmodifiableArrayList<>, int) || unmodifiablePropertyKeyList(UnmodifiablePropertyKeyList<>, int) || arrayList(ArrayList<>, int) || list(Object, int) */) {
            if ((state_0 & 0b1) != 0 /* is-state_0 unmodifiableArrayList(UnmodifiableArrayList<>, int) */ && arg0Value instanceof UnmodifiableArrayList<?>) {
                UnmodifiableArrayList<?> arg0Value_ = (UnmodifiableArrayList<?>) arg0Value;
                return ListGetNode.unmodifiableArrayList(arg0Value_, arg1Value);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 unmodifiablePropertyKeyList(UnmodifiablePropertyKeyList<>, int) */ && arg0Value instanceof UnmodifiablePropertyKeyList<?>) {
                UnmodifiablePropertyKeyList<?> arg0Value_ = (UnmodifiablePropertyKeyList<?>) arg0Value;
                return ListGetNode.unmodifiablePropertyKeyList(arg0Value_, arg1Value);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 arrayList(ArrayList<>, int) */ && arg0Value instanceof ArrayList<?>) {
                ArrayList<?> arg0Value_ = (ArrayList<?>) arg0Value;
                return ListGetNode.arrayList(arg0Value_, arg1Value);
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 list(Object, int) */) {
                if (fallbackGuard_(state_0, arg0Value, arg1Value)) {
                    return ListGetNode.list(arg0Value, arg1Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private Object executeAndSpecialize(Object arg0Value, int arg1Value) {
        int state_0 = this.state_0_;
        if (arg0Value instanceof UnmodifiableArrayList<?>) {
            UnmodifiableArrayList<?> arg0Value_ = (UnmodifiableArrayList<?>) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 unmodifiableArrayList(UnmodifiableArrayList<>, int) */;
            return ListGetNode.unmodifiableArrayList(arg0Value_, arg1Value);
        }
        if (arg0Value instanceof UnmodifiablePropertyKeyList<?>) {
            UnmodifiablePropertyKeyList<?> arg0Value_ = (UnmodifiablePropertyKeyList<?>) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 unmodifiablePropertyKeyList(UnmodifiablePropertyKeyList<>, int) */;
            return ListGetNode.unmodifiablePropertyKeyList(arg0Value_, arg1Value);
        }
        if (arg0Value instanceof ArrayList<?>) {
            ArrayList<?> arg0Value_ = (ArrayList<?>) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 arrayList(ArrayList<>, int) */;
            return ListGetNode.arrayList(arg0Value_, arg1Value);
        }
        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 list(Object, int) */;
        return ListGetNode.list(arg0Value, arg1Value);
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
        s = new Object[3];
        s[0] = "unmodifiableArrayList";
        if ((state_0 & 0b1) != 0 /* is-state_0 unmodifiableArrayList(UnmodifiableArrayList<>, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "unmodifiablePropertyKeyList";
        if ((state_0 & 0b10) != 0 /* is-state_0 unmodifiablePropertyKeyList(UnmodifiablePropertyKeyList<>, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "arrayList";
        if ((state_0 & 0b100) != 0 /* is-state_0 arrayList(ArrayList<>, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "list";
        if ((state_0 & 0b1000) != 0 /* is-state_0 list(Object, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state_0, Object arg0Value, int arg1Value) {
        if (((state_0 & 0b1)) == 0 /* is-not-state_0 unmodifiableArrayList(UnmodifiableArrayList<>, int) */ && arg0Value instanceof UnmodifiableArrayList<?>) {
            return false;
        }
        if (((state_0 & 0b10)) == 0 /* is-not-state_0 unmodifiablePropertyKeyList(UnmodifiablePropertyKeyList<>, int) */ && arg0Value instanceof UnmodifiablePropertyKeyList<?>) {
            return false;
        }
        if (((state_0 & 0b100)) == 0 /* is-not-state_0 arrayList(ArrayList<>, int) */ && arg0Value instanceof ArrayList<?>) {
            return false;
        }
        return true;
    }

    public static ListGetNode create() {
        return new ListGetNodeGen();
    }

}
