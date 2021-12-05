// CheckStyle: start generated
package com.oracle.truffle.js.nodes.control;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.IsArrayNode;
import com.oracle.truffle.js.nodes.array.JSArrayDeleteIndexNode;
import com.oracle.truffle.js.nodes.cast.JSToPropertyKeyNode;
import com.oracle.truffle.js.nodes.cast.ToArrayIndexNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSDynamicObject;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DeletePropertyNode.class)
public final class DeletePropertyNodeGen extends DeletePropertyNode implements Introspection.Provider {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSToPropertyKeyNode toPropertyKey;
    @Child private ToArrayIndexNode toArrayIndex;
    @Child private InteropLibrary interop;
    @Child private DynamicObjectLibrary jSOrdinaryObject_dynamicObjectLib_;
    @Child private IsArrayNode jSObject_isArrayNode_;
    @CompilationFinal private ConditionProfile jSObject_arrayProfile_;
    @Child private ToArrayIndexNode jSObject_toArrayIndexNode_;
    @CompilationFinal private ConditionProfile jSObject_arrayIndexProfile_;
    @Child private JSArrayDeleteIndexNode jSObject_deleteArrayIndexNode_;
    @CompilationFinal private JSClassProfile jSObject_jsclassProfile_;

    private DeletePropertyNodeGen(boolean strict, JSContext context, JavaScriptNode targetNode, JavaScriptNode propertyNode) {
        super(strict, context, targetNode, propertyNode);
    }

    @Override
    public boolean executeEvaluated(Object targetNodeValue, Object propertyNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111111) != 0 /* is-state_0 doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) || doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) || doSymbol(Symbol, Object, JSToPropertyKeyNode) || doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) || doBigInt(BigInt, Object, JSToPropertyKeyNode) || doString(String, Object, ToArrayIndexNode) */) {
            if ((state_0 & 0b11) != 0 /* is-state_0 doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) || doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */ && targetNodeValue instanceof JSDynamicObject) {
                JSDynamicObject targetNodeValue_ = (JSDynamicObject) targetNodeValue;
                if ((state_0 & 0b1) != 0 /* is-state_0 doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) */) {
                    if ((JSGuards.isJSOrdinaryObject(targetNodeValue_))) {
                        return doJSOrdinaryObject(targetNodeValue_, propertyNodeValue, this.toPropertyKey, this.jSOrdinaryObject_dynamicObjectLib_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */) {
                    if ((!(JSGuards.isJSOrdinaryObject(targetNodeValue_)))) {
                        return doJSObject(targetNodeValue_, propertyNodeValue, this.jSObject_isArrayNode_, this.jSObject_arrayProfile_, this.jSObject_toArrayIndexNode_, this.jSObject_arrayIndexProfile_, this.jSObject_deleteArrayIndexNode_, this.jSObject_jsclassProfile_, this.toPropertyKey);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doSymbol(Symbol, Object, JSToPropertyKeyNode) */ && targetNodeValue instanceof Symbol) {
                Symbol targetNodeValue_ = (Symbol) targetNodeValue;
                return DeletePropertyNode.doSymbol(targetNodeValue_, propertyNodeValue, this.toPropertyKey);
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) */ && targetNodeValue instanceof SafeInteger) {
                SafeInteger targetNodeValue_ = (SafeInteger) targetNodeValue;
                return DeletePropertyNode.doSafeInteger(targetNodeValue_, propertyNodeValue, this.toPropertyKey);
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doBigInt(BigInt, Object, JSToPropertyKeyNode) */ && targetNodeValue instanceof BigInt) {
                BigInt targetNodeValue_ = (BigInt) targetNodeValue;
                return DeletePropertyNode.doBigInt(targetNodeValue_, propertyNodeValue, this.toPropertyKey);
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doString(String, Object, ToArrayIndexNode) */ && JSTypesGen.isImplicitString((state_0 & 0b1110000000000) >>> 10 /* extract-implicit-state_0 0:String */, targetNodeValue)) {
                String targetNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0b1110000000000) >>> 10 /* extract-implicit-state_0 0:String */, targetNodeValue);
                return doString(targetNodeValue_, propertyNodeValue, this.toArrayIndex);
            }
        }
        if ((state_0 & 0b1111000000) != 0 /* is-state_0 member(Object, String, InteropLibrary) || arrayElementInt(Object, int, InteropLibrary) || foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) || doOther(Object, Object, JSToPropertyKeyNode) */) {
            if ((state_0 & 0b1000000) != 0 /* is-state_0 member(Object, String, InteropLibrary) */ && JSTypesGen.isImplicitString((state_0 & 0b1110000000000000) >>> 13 /* extract-implicit-state_0 1:String */, propertyNodeValue)) {
                String propertyNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0b1110000000000000) >>> 13 /* extract-implicit-state_0 1:String */, propertyNodeValue);
                if ((JSGuards.isForeignObject(targetNodeValue)) && (!(this.interop.hasArrayElements(targetNodeValue)))) {
                    return member(targetNodeValue, propertyNodeValue_, this.interop);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 arrayElementInt(Object, int, InteropLibrary) */ && propertyNodeValue instanceof Integer) {
                int propertyNodeValue_ = (int) propertyNodeValue;
                if ((JSGuards.isForeignObject(targetNodeValue)) && (this.interop.hasArrayElements(targetNodeValue))) {
                    return arrayElementInt(targetNodeValue, propertyNodeValue_, this.interop);
                }
            }
            if ((state_0 & 0b1100000000) != 0 /* is-state_0 foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) || doOther(Object, Object, JSToPropertyKeyNode) */) {
                if ((state_0 & 0b100000000) != 0 /* is-state_0 foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) */) {
                    if ((JSGuards.isForeignObject(targetNodeValue))) {
                        return foreignObject(targetNodeValue, propertyNodeValue, this.interop, this.toArrayIndex, this.toPropertyKey);
                    }
                }
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 doOther(Object, Object, JSToPropertyKeyNode) */) {
                    if ((!(JSGuards.isTruffleObject(targetNodeValue))) && (!(JSGuards.isString(targetNodeValue)))) {
                        return doOther(targetNodeValue, propertyNodeValue, this.toPropertyKey);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue, propertyNodeValue);
    }

    @Override
    public Object executeWithTarget(VirtualFrame frameValue, Object targetNodeValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1101111111) == 0 /* only-active arrayElementInt(Object, int, InteropLibrary) */ && ((state_0 & 0b1111111111) != 0  /* is-not doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) && doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) && doSymbol(Symbol, Object, JSToPropertyKeyNode) && doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) && doBigInt(BigInt, Object, JSToPropertyKeyNode) && doString(String, Object, ToArrayIndexNode) && member(Object, String, InteropLibrary) && arrayElementInt(Object, int, InteropLibrary) && foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) && doOther(Object, Object, JSToPropertyKeyNode) */)) {
            return executeWithTarget_int0(state_0, frameValue, targetNodeValue);
        } else {
            return executeWithTarget_generic1(state_0, frameValue, targetNodeValue);
        }
    }

    private Object executeWithTarget_int0(int state_0, VirtualFrame frameValue, Object targetNodeValue) {
        int propertyNodeValue_;
        try {
            propertyNodeValue_ = super.propertyNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(targetNodeValue, ex.getResult());
        }
        assert (state_0 & 0b10000000) != 0 /* is-state_0 arrayElementInt(Object, int, InteropLibrary) */;
        if ((JSGuards.isForeignObject(targetNodeValue)) && (this.interop.hasArrayElements(targetNodeValue))) {
            return arrayElementInt(targetNodeValue, propertyNodeValue_, this.interop);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue, propertyNodeValue_);
    }

    private Object executeWithTarget_generic1(int state_0, VirtualFrame frameValue, Object targetNodeValue) {
        Object propertyNodeValue_ = super.propertyNode.execute(frameValue);
        if ((state_0 & 0b111111) != 0 /* is-state_0 doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) || doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) || doSymbol(Symbol, Object, JSToPropertyKeyNode) || doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) || doBigInt(BigInt, Object, JSToPropertyKeyNode) || doString(String, Object, ToArrayIndexNode) */) {
            if ((state_0 & 0b11) != 0 /* is-state_0 doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) || doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */ && targetNodeValue instanceof JSDynamicObject) {
                JSDynamicObject targetNodeValue_ = (JSDynamicObject) targetNodeValue;
                if ((state_0 & 0b1) != 0 /* is-state_0 doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) */) {
                    if ((JSGuards.isJSOrdinaryObject(targetNodeValue_))) {
                        return doJSOrdinaryObject(targetNodeValue_, propertyNodeValue_, this.toPropertyKey, this.jSOrdinaryObject_dynamicObjectLib_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */) {
                    if ((!(JSGuards.isJSOrdinaryObject(targetNodeValue_)))) {
                        return doJSObject(targetNodeValue_, propertyNodeValue_, this.jSObject_isArrayNode_, this.jSObject_arrayProfile_, this.jSObject_toArrayIndexNode_, this.jSObject_arrayIndexProfile_, this.jSObject_deleteArrayIndexNode_, this.jSObject_jsclassProfile_, this.toPropertyKey);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doSymbol(Symbol, Object, JSToPropertyKeyNode) */ && targetNodeValue instanceof Symbol) {
                Symbol targetNodeValue_ = (Symbol) targetNodeValue;
                return DeletePropertyNode.doSymbol(targetNodeValue_, propertyNodeValue_, this.toPropertyKey);
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) */ && targetNodeValue instanceof SafeInteger) {
                SafeInteger targetNodeValue_ = (SafeInteger) targetNodeValue;
                return DeletePropertyNode.doSafeInteger(targetNodeValue_, propertyNodeValue_, this.toPropertyKey);
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doBigInt(BigInt, Object, JSToPropertyKeyNode) */ && targetNodeValue instanceof BigInt) {
                BigInt targetNodeValue_ = (BigInt) targetNodeValue;
                return DeletePropertyNode.doBigInt(targetNodeValue_, propertyNodeValue_, this.toPropertyKey);
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doString(String, Object, ToArrayIndexNode) */ && JSTypesGen.isImplicitString((state_0 & 0b1110000000000) >>> 10 /* extract-implicit-state_0 0:String */, targetNodeValue)) {
                String targetNodeValue_ = JSTypesGen.asImplicitString((state_0 & 0b1110000000000) >>> 10 /* extract-implicit-state_0 0:String */, targetNodeValue);
                return doString(targetNodeValue_, propertyNodeValue_, this.toArrayIndex);
            }
        }
        if ((state_0 & 0b1111000000) != 0 /* is-state_0 member(Object, String, InteropLibrary) || arrayElementInt(Object, int, InteropLibrary) || foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) || doOther(Object, Object, JSToPropertyKeyNode) */) {
            if ((state_0 & 0b1000000) != 0 /* is-state_0 member(Object, String, InteropLibrary) */ && JSTypesGen.isImplicitString((state_0 & 0b1110000000000000) >>> 13 /* extract-implicit-state_0 1:String */, propertyNodeValue_)) {
                String propertyNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0b1110000000000000) >>> 13 /* extract-implicit-state_0 1:String */, propertyNodeValue_);
                if ((JSGuards.isForeignObject(targetNodeValue)) && (!(this.interop.hasArrayElements(targetNodeValue)))) {
                    return member(targetNodeValue, propertyNodeValue__, this.interop);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 arrayElementInt(Object, int, InteropLibrary) */ && propertyNodeValue_ instanceof Integer) {
                int propertyNodeValue__ = (int) propertyNodeValue_;
                if ((JSGuards.isForeignObject(targetNodeValue)) && (this.interop.hasArrayElements(targetNodeValue))) {
                    return arrayElementInt(targetNodeValue, propertyNodeValue__, this.interop);
                }
            }
            if ((state_0 & 0b1100000000) != 0 /* is-state_0 foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) || doOther(Object, Object, JSToPropertyKeyNode) */) {
                if ((state_0 & 0b100000000) != 0 /* is-state_0 foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) */) {
                    if ((JSGuards.isForeignObject(targetNodeValue))) {
                        return foreignObject(targetNodeValue, propertyNodeValue_, this.interop, this.toArrayIndex, this.toPropertyKey);
                    }
                }
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 doOther(Object, Object, JSToPropertyKeyNode) */) {
                    if ((!(JSGuards.isTruffleObject(targetNodeValue))) && (!(JSGuards.isString(targetNodeValue)))) {
                        return doOther(targetNodeValue, propertyNodeValue_, this.toPropertyKey);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue, propertyNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1101111111) == 0 /* only-active arrayElementInt(Object, int, InteropLibrary) */ && ((state_0 & 0b1111111111) != 0  /* is-not doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) && doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) && doSymbol(Symbol, Object, JSToPropertyKeyNode) && doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) && doBigInt(BigInt, Object, JSToPropertyKeyNode) && doString(String, Object, ToArrayIndexNode) && member(Object, String, InteropLibrary) && arrayElementInt(Object, int, InteropLibrary) && foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) && doOther(Object, Object, JSToPropertyKeyNode) */)) {
            return executeBoolean_int2(state_0, frameValue);
        } else {
            return executeBoolean_generic3(state_0, frameValue);
        }
    }

    private boolean executeBoolean_int2(int state_0, VirtualFrame frameValue) {
        Object targetNodeValue_ = super.targetNode.execute(frameValue);
        int propertyNodeValue_;
        try {
            propertyNodeValue_ = super.propertyNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(targetNodeValue_, ex.getResult());
        }
        assert (state_0 & 0b10000000) != 0 /* is-state_0 arrayElementInt(Object, int, InteropLibrary) */;
        if ((JSGuards.isForeignObject(targetNodeValue_)) && (this.interop.hasArrayElements(targetNodeValue_))) {
            return arrayElementInt(targetNodeValue_, propertyNodeValue_, this.interop);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue_, propertyNodeValue_);
    }

    private boolean executeBoolean_generic3(int state_0, VirtualFrame frameValue) {
        Object targetNodeValue_ = super.targetNode.execute(frameValue);
        Object propertyNodeValue_ = super.propertyNode.execute(frameValue);
        if ((state_0 & 0b111111) != 0 /* is-state_0 doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) || doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) || doSymbol(Symbol, Object, JSToPropertyKeyNode) || doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) || doBigInt(BigInt, Object, JSToPropertyKeyNode) || doString(String, Object, ToArrayIndexNode) */) {
            if ((state_0 & 0b11) != 0 /* is-state_0 doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) || doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */ && targetNodeValue_ instanceof JSDynamicObject) {
                JSDynamicObject targetNodeValue__ = (JSDynamicObject) targetNodeValue_;
                if ((state_0 & 0b1) != 0 /* is-state_0 doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) */) {
                    if ((JSGuards.isJSOrdinaryObject(targetNodeValue__))) {
                        return doJSOrdinaryObject(targetNodeValue__, propertyNodeValue_, this.toPropertyKey, this.jSOrdinaryObject_dynamicObjectLib_);
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */) {
                    if ((!(JSGuards.isJSOrdinaryObject(targetNodeValue__)))) {
                        return doJSObject(targetNodeValue__, propertyNodeValue_, this.jSObject_isArrayNode_, this.jSObject_arrayProfile_, this.jSObject_toArrayIndexNode_, this.jSObject_arrayIndexProfile_, this.jSObject_deleteArrayIndexNode_, this.jSObject_jsclassProfile_, this.toPropertyKey);
                    }
                }
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 doSymbol(Symbol, Object, JSToPropertyKeyNode) */ && targetNodeValue_ instanceof Symbol) {
                Symbol targetNodeValue__ = (Symbol) targetNodeValue_;
                return DeletePropertyNode.doSymbol(targetNodeValue__, propertyNodeValue_, this.toPropertyKey);
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) */ && targetNodeValue_ instanceof SafeInteger) {
                SafeInteger targetNodeValue__ = (SafeInteger) targetNodeValue_;
                return DeletePropertyNode.doSafeInteger(targetNodeValue__, propertyNodeValue_, this.toPropertyKey);
            }
            if ((state_0 & 0b10000) != 0 /* is-state_0 doBigInt(BigInt, Object, JSToPropertyKeyNode) */ && targetNodeValue_ instanceof BigInt) {
                BigInt targetNodeValue__ = (BigInt) targetNodeValue_;
                return DeletePropertyNode.doBigInt(targetNodeValue__, propertyNodeValue_, this.toPropertyKey);
            }
            if ((state_0 & 0b100000) != 0 /* is-state_0 doString(String, Object, ToArrayIndexNode) */ && JSTypesGen.isImplicitString((state_0 & 0b1110000000000) >>> 10 /* extract-implicit-state_0 0:String */, targetNodeValue_)) {
                String targetNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0b1110000000000) >>> 10 /* extract-implicit-state_0 0:String */, targetNodeValue_);
                return doString(targetNodeValue__, propertyNodeValue_, this.toArrayIndex);
            }
        }
        if ((state_0 & 0b1111000000) != 0 /* is-state_0 member(Object, String, InteropLibrary) || arrayElementInt(Object, int, InteropLibrary) || foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) || doOther(Object, Object, JSToPropertyKeyNode) */) {
            if ((state_0 & 0b1000000) != 0 /* is-state_0 member(Object, String, InteropLibrary) */ && JSTypesGen.isImplicitString((state_0 & 0b1110000000000000) >>> 13 /* extract-implicit-state_0 1:String */, propertyNodeValue_)) {
                String propertyNodeValue__ = JSTypesGen.asImplicitString((state_0 & 0b1110000000000000) >>> 13 /* extract-implicit-state_0 1:String */, propertyNodeValue_);
                if ((JSGuards.isForeignObject(targetNodeValue_)) && (!(this.interop.hasArrayElements(targetNodeValue_)))) {
                    return member(targetNodeValue_, propertyNodeValue__, this.interop);
                }
            }
            if ((state_0 & 0b10000000) != 0 /* is-state_0 arrayElementInt(Object, int, InteropLibrary) */ && propertyNodeValue_ instanceof Integer) {
                int propertyNodeValue__ = (int) propertyNodeValue_;
                if ((JSGuards.isForeignObject(targetNodeValue_)) && (this.interop.hasArrayElements(targetNodeValue_))) {
                    return arrayElementInt(targetNodeValue_, propertyNodeValue__, this.interop);
                }
            }
            if ((state_0 & 0b1100000000) != 0 /* is-state_0 foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) || doOther(Object, Object, JSToPropertyKeyNode) */) {
                if ((state_0 & 0b100000000) != 0 /* is-state_0 foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) */) {
                    if ((JSGuards.isForeignObject(targetNodeValue_))) {
                        return foreignObject(targetNodeValue_, propertyNodeValue_, this.interop, this.toArrayIndex, this.toPropertyKey);
                    }
                }
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 doOther(Object, Object, JSToPropertyKeyNode) */) {
                    if ((!(JSGuards.isTruffleObject(targetNodeValue_))) && (!(JSGuards.isString(targetNodeValue_)))) {
                        return doOther(targetNodeValue_, propertyNodeValue_, this.toPropertyKey);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue_, propertyNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    private boolean executeAndSpecialize(Object targetNodeValue, Object propertyNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (targetNodeValue instanceof JSDynamicObject) {
                JSDynamicObject targetNodeValue_ = (JSDynamicObject) targetNodeValue;
                if ((JSGuards.isJSOrdinaryObject(targetNodeValue_))) {
                    this.toPropertyKey = super.insert(this.toPropertyKey == null ? ((JSToPropertyKeyNode.create())) : this.toPropertyKey);
                    this.jSOrdinaryObject_dynamicObjectLib_ = super.insert((DYNAMIC_OBJECT_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit)));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSOrdinaryObject(targetNodeValue_, propertyNodeValue, this.toPropertyKey, this.jSOrdinaryObject_dynamicObjectLib_);
                }
                if ((!(JSGuards.isJSOrdinaryObject(targetNodeValue_)))) {
                    this.jSObject_isArrayNode_ = super.insert((IsArrayNode.createIsFastArray()));
                    this.jSObject_arrayProfile_ = (ConditionProfile.createBinaryProfile());
                    this.jSObject_toArrayIndexNode_ = super.insert((ToArrayIndexNode.create()));
                    this.jSObject_arrayIndexProfile_ = (ConditionProfile.createBinaryProfile());
                    this.jSObject_deleteArrayIndexNode_ = super.insert((JSArrayDeleteIndexNode.create(context, strict)));
                    this.jSObject_jsclassProfile_ = (JSClassProfile.create());
                    this.toPropertyKey = super.insert(this.toPropertyKey == null ? ((JSToPropertyKeyNode.create())) : this.toPropertyKey);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(targetNodeValue_, propertyNodeValue, this.jSObject_isArrayNode_, this.jSObject_arrayProfile_, this.jSObject_toArrayIndexNode_, this.jSObject_arrayIndexProfile_, this.jSObject_deleteArrayIndexNode_, this.jSObject_jsclassProfile_, this.toPropertyKey);
                }
            }
            if (targetNodeValue instanceof Symbol) {
                Symbol targetNodeValue_ = (Symbol) targetNodeValue;
                this.toPropertyKey = super.insert(this.toPropertyKey == null ? ((JSToPropertyKeyNode.create())) : this.toPropertyKey);
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doSymbol(Symbol, Object, JSToPropertyKeyNode) */;
                lock.unlock();
                hasLock = false;
                return DeletePropertyNode.doSymbol(targetNodeValue_, propertyNodeValue, this.toPropertyKey);
            }
            if (targetNodeValue instanceof SafeInteger) {
                SafeInteger targetNodeValue_ = (SafeInteger) targetNodeValue;
                this.toPropertyKey = super.insert(this.toPropertyKey == null ? ((JSToPropertyKeyNode.create())) : this.toPropertyKey);
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) */;
                lock.unlock();
                hasLock = false;
                return DeletePropertyNode.doSafeInteger(targetNodeValue_, propertyNodeValue, this.toPropertyKey);
            }
            if (targetNodeValue instanceof BigInt) {
                BigInt targetNodeValue_ = (BigInt) targetNodeValue;
                this.toPropertyKey = super.insert(this.toPropertyKey == null ? ((JSToPropertyKeyNode.create())) : this.toPropertyKey);
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 doBigInt(BigInt, Object, JSToPropertyKeyNode) */;
                lock.unlock();
                hasLock = false;
                return DeletePropertyNode.doBigInt(targetNodeValue_, propertyNodeValue, this.toPropertyKey);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(targetNodeValue)) != 0) {
                    String targetNodeValue_ = JSTypesGen.asImplicitString(stringCast0, targetNodeValue);
                    this.toArrayIndex = super.insert(this.toArrayIndex == null ? ((ToArrayIndexNode.create())) : this.toArrayIndex);
                    state_0 = (state_0 | (stringCast0 << 10) /* set-implicit-state_0 0:String */);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 doString(String, Object, ToArrayIndexNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(targetNodeValue_, propertyNodeValue, this.toArrayIndex);
                }
            }
            if (((exclude & 0b1)) == 0 /* is-not-exclude member(Object, String, InteropLibrary) */) {
                int stringCast1;
                if ((stringCast1 = JSTypesGen.specializeImplicitString(propertyNodeValue)) != 0) {
                    String propertyNodeValue_ = JSTypesGen.asImplicitString(stringCast1, propertyNodeValue);
                    if ((JSGuards.isForeignObject(targetNodeValue))) {
                        InteropLibrary member_interop__ = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                        if ((!(member_interop__.hasArrayElements(targetNodeValue)))) {
                            if (this.interop == null) {
                                InteropLibrary member_interop___check = super.insert(member_interop__);
                                if (member_interop___check == null) {
                                    throw new AssertionError("Specialization 'member(Object, String, InteropLibrary)' contains a shared cache with name 'interop' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                                }
                                this.interop = member_interop___check;
                            }
                            state_0 = (state_0 | (stringCast1 << 13) /* set-implicit-state_0 1:String */);
                            this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 member(Object, String, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return member(targetNodeValue, propertyNodeValue_, member_interop__);
                        }
                    }
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-exclude arrayElementInt(Object, int, InteropLibrary) */ && propertyNodeValue instanceof Integer) {
                int propertyNodeValue_ = (int) propertyNodeValue;
                if ((JSGuards.isForeignObject(targetNodeValue))) {
                    InteropLibrary arrayElementInt_interop__ = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                    if ((arrayElementInt_interop__.hasArrayElements(targetNodeValue))) {
                        if (this.interop == null) {
                            InteropLibrary arrayElementInt_interop___check = super.insert(arrayElementInt_interop__);
                            if (arrayElementInt_interop___check == null) {
                                throw new AssertionError("Specialization 'arrayElementInt(Object, int, InteropLibrary)' contains a shared cache with name 'interop' that returned a null value for the cached initializer. Null values are not supported for shared cached initializers because null is reserved for the uninitialized state.");
                            }
                            this.interop = arrayElementInt_interop___check;
                        }
                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 arrayElementInt(Object, int, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arrayElementInt(targetNodeValue, propertyNodeValue_, arrayElementInt_interop__);
                    }
                }
            }
            if ((JSGuards.isForeignObject(targetNodeValue))) {
                this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(JSConfig.InteropLibraryLimit))) : this.interop);
                this.toArrayIndex = super.insert(this.toArrayIndex == null ? ((ToArrayIndexNode.create())) : this.toArrayIndex);
                this.toPropertyKey = super.insert(this.toPropertyKey == null ? ((JSToPropertyKeyNode.create())) : this.toPropertyKey);
                this.exclude_ = exclude = exclude | 0b11 /* add-exclude member(Object, String, InteropLibrary), arrayElementInt(Object, int, InteropLibrary) */;
                state_0 = state_0 & 0xffffff3f /* remove-state_0 member(Object, String, InteropLibrary), arrayElementInt(Object, int, InteropLibrary) */;
                this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) */;
                lock.unlock();
                hasLock = false;
                return foreignObject(targetNodeValue, propertyNodeValue, this.interop, this.toArrayIndex, this.toPropertyKey);
            }
            if ((!(JSGuards.isTruffleObject(targetNodeValue))) && (!(JSGuards.isString(targetNodeValue)))) {
                this.toPropertyKey = super.insert(this.toPropertyKey == null ? ((JSToPropertyKeyNode.create())) : this.toPropertyKey);
                this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 doOther(Object, Object, JSToPropertyKeyNode) */;
                lock.unlock();
                hasLock = false;
                return doOther(targetNodeValue, propertyNodeValue, this.toPropertyKey);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.targetNode, super.propertyNode}, targetNodeValue, propertyNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111111111) & ((state_0 & 0b1111111111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[11];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doJSOrdinaryObject";
        if ((state_0 & 0b1) != 0 /* is-state_0 doJSOrdinaryObject(JSDynamicObject, Object, JSToPropertyKeyNode, DynamicObjectLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toPropertyKey, this.jSOrdinaryObject_dynamicObjectLib_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state_0 & 0b10) != 0 /* is-state_0 doJSObject(JSDynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSObject_isArrayNode_, this.jSObject_arrayProfile_, this.jSObject_toArrayIndexNode_, this.jSObject_arrayIndexProfile_, this.jSObject_deleteArrayIndexNode_, this.jSObject_jsclassProfile_, this.toPropertyKey));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state_0 & 0b100) != 0 /* is-state_0 doSymbol(Symbol, Object, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toPropertyKey));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state_0 & 0b1000) != 0 /* is-state_0 doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toPropertyKey));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state_0 & 0b10000) != 0 /* is-state_0 doBigInt(BigInt, Object, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toPropertyKey));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state_0 & 0b100000) != 0 /* is-state_0 doString(String, Object, ToArrayIndexNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toArrayIndex));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "member";
        if ((state_0 & 0b1000000) != 0 /* is-state_0 member(Object, String, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.interop));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-exclude member(Object, String, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "arrayElementInt";
        if ((state_0 & 0b10000000) != 0 /* is-state_0 arrayElementInt(Object, int, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.interop));
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-exclude arrayElementInt(Object, int, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "foreignObject";
        if ((state_0 & 0b100000000) != 0 /* is-state_0 foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.interop, this.toArrayIndex, this.toPropertyKey));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state_0 & 0b1000000000) != 0 /* is-state_0 doOther(Object, Object, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toPropertyKey));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        return Provider.create(data);
    }

    public static DeletePropertyNode create(boolean strict, JSContext context, JavaScriptNode targetNode, JavaScriptNode propertyNode) {
        return new DeletePropertyNodeGen(strict, context, targetNode, propertyNode);
    }

}
