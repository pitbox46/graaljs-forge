// CheckStyle: start generated
package com.oracle.truffle.js.nodes.intl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.access.JSHasPropertyNode;
import com.oracle.truffle.js.nodes.array.JSGetLengthNode;
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.unary.TypeOfNode;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToCanonicalizedLocaleListNode.class)
public final class JSToCanonicalizedLocaleListNodeGen extends JSToCanonicalizedLocaleListNode implements Introspection.Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @Child private OtherTypeData otherType_cache;
    @Child private ForeignTypeData foreignType_cache;

    private JSToCanonicalizedLocaleListNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public String[] executeLanguageTags(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 doString(String) */ && JSTypesGen.isImplicitString((state_0 & 0b11100000) >>> 5 /* extract-implicit-state_0 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state_0 & 0b11100000) >>> 5 /* extract-implicit-state_0 0:String */, arg0Value);
            return doString(arg0Value_);
        }
        if ((state_0 & 0b110) != 0 /* is-state_0 doUndefined(DynamicObject) || doLocale(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state_0 & 0b10) != 0 /* is-state_0 doUndefined(DynamicObject) */) {
                if ((JSGuards.isUndefined(arg0Value_))) {
                    return doUndefined(arg0Value_);
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doLocale(DynamicObject) */) {
                if ((JSGuards.isJSLocale(arg0Value_))) {
                    return doLocale(arg0Value_);
                }
            }
        }
        if ((state_0 & 0b11000) != 0 /* is-state_0 doOtherType(Object, JSToObjectNode, JSGetLengthNode, JSHasPropertyNode, TypeOfNode, JSToStringNode) || doForeignType(Object, InteropLibrary, TypeOfNode, JSToStringNode) */) {
            if ((state_0 & 0b1000) != 0 /* is-state_0 doOtherType(Object, JSToObjectNode, JSGetLengthNode, JSHasPropertyNode, TypeOfNode, JSToStringNode) */) {
                OtherTypeData s3_ = this.otherType_cache;
                if (s3_ != null) {
                    if ((!(JSGuards.isForeignObject(arg0Value))) && (!(JSGuards.isString(arg0Value))) && (!(JSGuards.isUndefined(arg0Value))) && (!(JSGuards.isJSLocale(arg0Value)))) {
                        return doOtherType(arg0Value, s3_.toObjectNode_, s3_.getLengthNode_, s3_.hasPropertyNode_, s3_.typeOfNode_, s3_.toStringNode_);
                    }
                }
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doForeignType(Object, InteropLibrary, TypeOfNode, JSToStringNode) */) {
                ForeignTypeData s4_ = this.foreignType_cache;
                if (s4_ != null) {
                    if ((JSGuards.isForeignObject(arg0Value))) {
                        return doForeignType(arg0Value, s4_.interop_, s4_.typeOfNode_, s4_.toStringNode_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private String[] executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    state_0 = (state_0 | (stringCast0 << 5) /* set-implicit-state_0 0:String */);
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_);
                }
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isUndefined(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUndefined(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doUndefined(arg0Value_);
                }
                if ((JSGuards.isJSLocale(arg0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doLocale(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doLocale(arg0Value_);
                }
            }
            if ((!(JSGuards.isForeignObject(arg0Value))) && (!(JSGuards.isString(arg0Value))) && (!(JSGuards.isUndefined(arg0Value))) && (!(JSGuards.isJSLocale(arg0Value)))) {
                OtherTypeData s3_ = super.insert(new OtherTypeData());
                s3_.toObjectNode_ = s3_.insertAccessor((JSToObjectNode.createToObject(context)));
                s3_.getLengthNode_ = s3_.insertAccessor((JSGetLengthNode.create(context)));
                s3_.hasPropertyNode_ = s3_.insertAccessor((JSHasPropertyNode.create()));
                s3_.typeOfNode_ = s3_.insertAccessor((TypeOfNode.create()));
                s3_.toStringNode_ = s3_.insertAccessor((JSToStringNode.create()));
                MemoryFence.storeStore();
                this.otherType_cache = s3_;
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doOtherType(Object, JSToObjectNode, JSGetLengthNode, JSHasPropertyNode, TypeOfNode, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return doOtherType(arg0Value, s3_.toObjectNode_, s3_.getLengthNode_, s3_.hasPropertyNode_, s3_.typeOfNode_, s3_.toStringNode_);
            }
            if ((JSGuards.isForeignObject(arg0Value))) {
                ForeignTypeData s4_ = super.insert(new ForeignTypeData());
                s4_.interop_ = s4_.insertAccessor((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                s4_.typeOfNode_ = s4_.insertAccessor((TypeOfNode.create()));
                s4_.toStringNode_ = s4_.insertAccessor((JSToStringNode.create()));
                MemoryFence.storeStore();
                this.foreignType_cache = s4_;
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doForeignType(Object, InteropLibrary, TypeOfNode, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return doForeignType(arg0Value, s4_.interop_, s4_.typeOfNode_, s4_.toStringNode_);
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
        if ((state_0 & 0b11111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b11111) & ((state_0 & 0b11111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
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
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b1) != 0 /* is-state_0 doString(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state_0 & 0b10) != 0 /* is-state_0 doUndefined(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doLocale";
        if ((state_0 & 0b100) != 0 /* is-state_0 doLocale(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doOtherType";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doOtherType(Object, JSToObjectNode, JSGetLengthNode, JSHasPropertyNode, TypeOfNode, JSToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            OtherTypeData s3_ = this.otherType_cache;
            if (s3_ != null) {
                cached.add(Arrays.asList(s3_.toObjectNode_, s3_.getLengthNode_, s3_.hasPropertyNode_, s3_.typeOfNode_, s3_.toStringNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doForeignType";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doForeignType(Object, InteropLibrary, TypeOfNode, JSToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignTypeData s4_ = this.foreignType_cache;
            if (s4_ != null) {
                cached.add(Arrays.asList(s4_.interop_, s4_.typeOfNode_, s4_.toStringNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static JSToCanonicalizedLocaleListNode create(JSContext context) {
        return new JSToCanonicalizedLocaleListNodeGen(context);
    }

    @GeneratedBy(JSToCanonicalizedLocaleListNode.class)
    private static final class OtherTypeData extends Node {

        @Child JSToObjectNode toObjectNode_;
        @Child JSGetLengthNode getLengthNode_;
        @Child JSHasPropertyNode hasPropertyNode_;
        @Child TypeOfNode typeOfNode_;
        @Child JSToStringNode toStringNode_;

        OtherTypeData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSToCanonicalizedLocaleListNode.class)
    private static final class ForeignTypeData extends Node {

        @Child InteropLibrary interop_;
        @Child TypeOfNode typeOfNode_;
        @Child JSToStringNode toStringNode_;

        ForeignTypeData() {
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
