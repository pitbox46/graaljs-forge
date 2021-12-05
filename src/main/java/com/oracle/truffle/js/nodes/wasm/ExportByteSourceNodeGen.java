// CheckStyle: start generated
package com.oracle.truffle.js.nodes.wasm;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSArrayBufferObject;
import com.oracle.truffle.js.runtime.builtins.JSDataViewObject;
import com.oracle.truffle.js.runtime.builtins.JSTypedArrayObject;

@GeneratedBy(ExportByteSourceNode.class)
public final class ExportByteSourceNodeGen extends ExportByteSourceNode implements Introspection.Provider {

    @CompilationFinal private int state_0_;

    private ExportByteSourceNodeGen(JSContext context, String nonByteSourceMessage, String emptyByteSourceMessage) {
        super(context, nonByteSourceMessage, emptyByteSourceMessage);
    }

    @Override
    public Object execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 exportBuffer(JSArrayBufferObject) */ && arg0Value instanceof JSArrayBufferObject) {
            JSArrayBufferObject arg0Value_ = (JSArrayBufferObject) arg0Value;
            return exportBuffer(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 exportTypedArray(JSTypedArrayObject) */ && arg0Value instanceof JSTypedArrayObject) {
            JSTypedArrayObject arg0Value_ = (JSTypedArrayObject) arg0Value;
            return exportTypedArray(arg0Value_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 exportDataView(JSDataViewObject) */ && arg0Value instanceof JSDataViewObject) {
            JSDataViewObject arg0Value_ = (JSDataViewObject) arg0Value;
            return exportDataView(arg0Value_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 exportOther(Object) */) {
            if (fallbackGuard_(state_0, arg0Value)) {
                return exportOther(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object arg0Value) {
        int state_0 = this.state_0_;
        if (arg0Value instanceof JSArrayBufferObject) {
            JSArrayBufferObject arg0Value_ = (JSArrayBufferObject) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 exportBuffer(JSArrayBufferObject) */;
            return exportBuffer(arg0Value_);
        }
        if (arg0Value instanceof JSTypedArrayObject) {
            JSTypedArrayObject arg0Value_ = (JSTypedArrayObject) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 exportTypedArray(JSTypedArrayObject) */;
            return exportTypedArray(arg0Value_);
        }
        if (arg0Value instanceof JSDataViewObject) {
            JSDataViewObject arg0Value_ = (JSDataViewObject) arg0Value;
            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 exportDataView(JSDataViewObject) */;
            return exportDataView(arg0Value_);
        }
        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 exportOther(Object) */;
        return exportOther(arg0Value);
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
        s[0] = "exportBuffer";
        if ((state_0 & 0b1) != 0 /* is-state_0 exportBuffer(JSArrayBufferObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "exportTypedArray";
        if ((state_0 & 0b10) != 0 /* is-state_0 exportTypedArray(JSTypedArrayObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "exportDataView";
        if ((state_0 & 0b100) != 0 /* is-state_0 exportDataView(JSDataViewObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "exportOther";
        if ((state_0 & 0b1000) != 0 /* is-state_0 exportOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state_0, Object arg0Value) {
        if (((state_0 & 0b1)) == 0 /* is-not-state_0 exportBuffer(JSArrayBufferObject) */ && arg0Value instanceof JSArrayBufferObject) {
            return false;
        }
        if (((state_0 & 0b10)) == 0 /* is-not-state_0 exportTypedArray(JSTypedArrayObject) */ && arg0Value instanceof JSTypedArrayObject) {
            return false;
        }
        if (((state_0 & 0b100)) == 0 /* is-not-state_0 exportDataView(JSDataViewObject) */ && arg0Value instanceof JSDataViewObject) {
            return false;
        }
        return true;
    }

    public static ExportByteSourceNode create(JSContext context, String nonByteSourceMessage, String emptyByteSourceMessage) {
        return new ExportByteSourceNodeGen(context, nonByteSourceMessage, emptyByteSourceMessage);
    }

}
