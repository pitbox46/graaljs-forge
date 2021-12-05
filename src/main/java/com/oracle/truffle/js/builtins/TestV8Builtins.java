/*
 * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oracle.truffle.js.builtins;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.DebugBuiltinsFactory.DebugClassNameNodeGen;
import com.oracle.truffle.js.builtins.DebugBuiltinsFactory.DebugClassNodeGen;
import com.oracle.truffle.js.builtins.DebugBuiltinsFactory.DebugContinueInInterpreterNodeGen;
import com.oracle.truffle.js.builtins.DebugBuiltinsFactory.DebugStringCompareNodeGen;
import com.oracle.truffle.js.builtins.DebugBuiltinsFactory.DebugTypedArrayDetachBufferNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8AtomicsNumUnresolvedAsyncPromisesForTestingNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8AtomicsNumWaitersForTestingNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8ConstructDoubleNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8CreateAsyncFromSyncIteratorNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8DoublePartNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8EnqueueJobNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8ReferenceEqualNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8RunMicrotasksNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8SetAllowAtomicsWaitNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8SetTimeoutNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8ToLengthNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8ToNameNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8ToNumberNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8ToPrimitiveNodeGen;
import com.oracle.truffle.js.builtins.TestV8BuiltinsFactory.TestV8ToStringNodeGen;
import com.oracle.truffle.js.builtins.helper.GCNodeGen;
import com.oracle.truffle.js.builtins.helper.SharedMemorySync;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.access.PropertySetNode;
import com.oracle.truffle.js.nodes.cast.JSToBooleanNode;
import com.oracle.truffle.js.nodes.cast.JSToIndexNode;
import com.oracle.truffle.js.nodes.cast.JSToLengthNode;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.nodes.cast.JSToPrimitiveNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSBuiltinNode;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.JSAgent;
import com.oracle.truffle.js.runtime.JSAgentWaiterList.JSAgentWaiterListEntry;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSException;
import com.oracle.truffle.js.runtime.JSRealm;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.builtins.BuiltinEnum;
import com.oracle.truffle.js.runtime.builtins.JSArrayBufferView;
import com.oracle.truffle.js.runtime.builtins.JSFunction;
import com.oracle.truffle.js.runtime.builtins.JSOrdinary;
import com.oracle.truffle.js.runtime.builtins.JSSharedArrayBuffer;
import com.oracle.truffle.js.runtime.builtins.JSTestV8;
import com.oracle.truffle.js.runtime.objects.IteratorRecord;
import com.oracle.truffle.js.runtime.objects.Undefined;

/**
 * Contains builtins to support special behavior used by TestV8.
 */
public final class TestV8Builtins extends JSBuiltinsContainer.SwitchEnum<TestV8Builtins.TestV8> {

    public static final JSBuiltinsContainer BUILTINS = new TestV8Builtins();

    protected TestV8Builtins() {
        super(JSTestV8.CLASS_NAME, TestV8.class);
    }

    public enum TestV8 implements BuiltinEnum<TestV8> {
        class_(1),
        className(1),
        createAsyncFromSyncIterator(1),
        runMicrotasks(0),
        enqueueJob(1),
        setTimeout(1),
        stringCompare(2),
        typedArrayDetachBuffer(1),

        constructDouble(2),
        doubleHi(1),
        doubleLo(1),
        deoptimize(0),
        gc(0),
        referenceEqual(2),
        toLength(1),
        toStringConv(1),
        toName(1),
        toNumber(1),
        toPrimitive(1),
        toPrimitiveString(1),
        toPrimitiveNumber(1),

        atomicsNumWaitersForTesting(2),
        atomicsNumUnresolvedAsyncPromisesForTesting(2),
        setAllowAtomicsWait(1);

        private final int length;

        TestV8(int length) {
            this.length = length;
        }

        @Override
        public int getLength() {
            return length;
        }
    }

    @Override
    protected Object createNode(JSContext context, JSBuiltin builtin, boolean construct, boolean newTarget, TestV8 builtinEnum) {
        switch (builtinEnum) {
            case class_:
                return DebugClassNodeGen.create(context, builtin, true, args().fixedArgs(1).createArgumentNodes(context));
            case className:
                return DebugClassNameNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
            case createAsyncFromSyncIterator:
                return TestV8CreateAsyncFromSyncIteratorNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
            case runMicrotasks:
                return TestV8RunMicrotasksNodeGen.create(context, builtin, args().createArgumentNodes(context));
            case enqueueJob:
                return TestV8EnqueueJobNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
            case setTimeout:
                return TestV8SetTimeoutNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
            case stringCompare:
                return DebugStringCompareNodeGen.create(context, builtin, args().fixedArgs(2).createArgumentNodes(context));
            case typedArrayDetachBuffer:
                return DebugTypedArrayDetachBufferNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));

            case constructDouble:
                return TestV8ConstructDoubleNodeGen.create(context, builtin, args().fixedArgs(2).createArgumentNodes(context));
            case doubleHi:
                return TestV8DoublePartNodeGen.create(context, builtin, true, args().fixedArgs(1).createArgumentNodes(context));
            case doubleLo:
                return TestV8DoublePartNodeGen.create(context, builtin, false, args().fixedArgs(1).createArgumentNodes(context));
            case deoptimize:
                return DebugContinueInInterpreterNodeGen.create(context, builtin, true, args().createArgumentNodes(context));
            case gc:
                return GCNodeGen.create(context, builtin, args().createArgumentNodes(context));
            case referenceEqual:
                return TestV8ReferenceEqualNodeGen.create(context, builtin, args().fixedArgs(2).createArgumentNodes(context));
            case toStringConv:
                return TestV8ToStringNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
            case toName:
                return TestV8ToNameNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
            case toPrimitive:
                return TestV8ToPrimitiveNodeGen.create(context, builtin, JSToPrimitiveNode.Hint.None, args().fixedArgs(1).createArgumentNodes(context));
            case toPrimitiveString:
                return TestV8ToPrimitiveNodeGen.create(context, builtin, JSToPrimitiveNode.Hint.String, args().fixedArgs(1).createArgumentNodes(context));
            case toPrimitiveNumber:
                return TestV8ToPrimitiveNodeGen.create(context, builtin, JSToPrimitiveNode.Hint.Number, args().fixedArgs(1).createArgumentNodes(context));
            case toNumber:
                return TestV8ToNumberNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
            case toLength:
                return TestV8ToLengthNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
            case atomicsNumWaitersForTesting:
                return TestV8AtomicsNumWaitersForTestingNodeGen.create(context, builtin, args().fixedArgs(2).createArgumentNodes(context));
            case atomicsNumUnresolvedAsyncPromisesForTesting:
                return TestV8AtomicsNumUnresolvedAsyncPromisesForTestingNodeGen.create(context, builtin, args().fixedArgs(2).createArgumentNodes(context));
            case setAllowAtomicsWait:
                return TestV8SetAllowAtomicsWaitNodeGen.create(context, builtin, args().fixedArgs(1).createArgumentNodes(context));
        }
        return null;
    }

    /**
     * Constructs a double from two 32bit ints. Used by V8ConstructDouble (v8mockup.js).
     */
    public abstract static class TestV8ConstructDoubleNode extends JSBuiltinNode {

        public TestV8ConstructDoubleNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @TruffleBoundary
        @Specialization
        protected double constructDouble(Object hiObj, Object loObj) {
            long hi = JSRuntime.toUInt32(hiObj);
            long lo = JSRuntime.toUInt32(loObj);
            return Double.longBitsToDouble((hi << 32) | lo);
        }
    }

    /**
     * Gets the upper (hi) or lower (lo) 32 bits of a double. Used by V8DoubleHi, V8DoubleLo
     * (v8mockup.js).
     */
    public abstract static class TestV8DoublePartNode extends JSBuiltinNode {
        private final boolean upper;

        public TestV8DoublePartNode(JSContext context, JSBuiltin builtin, boolean upper) {
            super(context, builtin);
            this.upper = upper;
        }

        @Specialization
        protected int doublePart(Object value) {
            long bits = Double.doubleToRawLongBits((double) value);
            return upper ? (int) (bits >>> 32L) : (int) (bits & 0xFFFF_FFFFL);
        }
    }

    /**
     * Calls [[ToString]], used by v8mockup.js.
     */
    public abstract static class TestV8ToStringNode extends JSBuiltinNode {
        @Child private JSToStringNode toStringNode;

        public TestV8ToStringNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
            toStringNode = JSToStringNode.create();
        }

        @Specialization
        protected String toStringConv(Object obj) {
            return toStringNode.executeString(obj);
        }
    }

    /**
     * Calls [[ToNumber]], used by v8mockup.js.
     */
    public abstract static class TestV8ToNumberNode extends JSBuiltinNode {
        @Child private JSToNumberNode toNumberNode;

        public TestV8ToNumberNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
            toNumberNode = JSToNumberNode.create();
        }

        @Specialization
        protected Number toNumberOp(Object obj) {
            return toNumberNode.executeNumber(obj);
        }
    }

    /**
     * Calls [[ToPrimitive]], used by v8mockup.js .
     */
    public abstract static class TestV8ToPrimitiveNode extends JSBuiltinNode {
        @Child private JSToPrimitiveNode toPrimitiveNode;

        public TestV8ToPrimitiveNode(JSContext context, JSBuiltin builtin, JSToPrimitiveNode.Hint hint) {
            super(context, builtin);
            toPrimitiveNode = JSToPrimitiveNode.create(hint);
        }

        @Specialization
        protected Object toPrimitive(Object obj) {
            return toPrimitiveNode.execute(obj);
        }
    }

    /**
     * Calls [[ToName]], used by v8mockup.js.
     */
    public abstract static class TestV8ToNameNode extends JSBuiltinNode {
        @Child private JSToStringNode toStringNode;

        public TestV8ToNameNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
            toStringNode = JSToStringNode.create();
        }

        @Specialization
        protected Object toName(Object obj) {
            if (obj instanceof Symbol) {
                return obj;
            } else {
                return toStringNode.executeString(obj);
            }
        }
    }

    /**
     * Executes all pending jobs, used by v8mockup.js.
     */
    public abstract static class TestV8RunMicrotasksNode extends JSBuiltinNode {

        public TestV8RunMicrotasksNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization
        protected Object runMicrotasks() {
            getContext().processAllPendingPromiseJobs(getRealm());
            return Undefined.instance;
        }
    }

    public abstract static class TestV8EnqueueJobNode extends JSBuiltinNode {

        public TestV8EnqueueJobNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization
        protected Object enqueueJob(Object function) {
            if (JSFunction.isJSFunction(function)) {
                getContext().promiseEnqueueJob(getRealm(), (DynamicObject) function);
            }
            return 0;
        }
    }

    /**
     * Calls CreateAsyncFromSyncIterator, used by v8mockup.js.
     */
    public abstract static class TestV8CreateAsyncFromSyncIterator extends JSBuiltinNode {
        @Child private PropertySetNode setState;
        @Child private PropertyGetNode getNextMethodNode;

        public TestV8CreateAsyncFromSyncIterator(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
            this.setState = PropertySetNode.createSetHidden(JSFunction.ASYNC_FROM_SYNC_ITERATOR_KEY, context);
            this.getNextMethodNode = PropertyGetNode.create(JSRuntime.NEXT, context);
        }

        @Specialization(guards = "isJSObject(syncIterator)")
        protected Object createAsyncFromSyncIterator(DynamicObject syncIterator) {
            JSContext context = getContext();
            DynamicObject obj = JSOrdinary.create(context, context.getAsyncFromSyncIteratorFactory(), getRealm());
            IteratorRecord syncIteratorRecord = IteratorRecord.create(syncIterator, getNextMethodNode.getValue(syncIterator), false);
            setState.setValue(obj, syncIteratorRecord);
            return obj;
        }

        @Specialization(guards = "!isJSObject(syncIterator)")
        protected Object notObject(Object syncIterator) {
            throw Errors.createTypeErrorNotAnObject(syncIterator, this);
        }
    }

    /**
     * Calls [[ToLength]].
     */
    public abstract static class TestV8ToLengthNode extends JSBuiltinNode {
        @Child private JSToLengthNode toLengthNode;

        public TestV8ToLengthNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
            toLengthNode = JSToLengthNode.create();
        }

        @Specialization
        protected Object toLengthOp(Object obj) {
            long value = toLengthNode.executeLong(obj);
            double d = value;
            if (JSRuntime.doubleIsRepresentableAsInt(d)) {
                return (int) d;
            } else {
                return d;
            }
        }

        @Override
        protected JavaScriptNode copyUninitialized(Set<Class<? extends Tag>> materializedTags) {
            return TestV8ToLengthNodeGen.create(getContext(), getBuiltin(), cloneUninitialized(getArguments(), materializedTags));
        }
    }

    public abstract static class TestV8ReferenceEqualNode extends JSBuiltinNode {

        public TestV8ReferenceEqualNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization
        protected boolean referenceEqual(Object arg1, Object arg2) {
            return arg1 == arg2;
        }
    }

    public abstract static class TestV8SetTimeoutNode extends JSBuiltinNode {

        public TestV8SetTimeoutNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization
        @TruffleBoundary
        @SuppressWarnings("unchecked")
        protected Object setTimeout(Object callback) {
            assert JSRuntime.isCallable(callback);
            JSRealm realm = getRealm();
            List<Object> embedderData = (List<Object>) realm.getEmbedderData();
            if (embedderData == null) {
                embedderData = new ArrayList<>();
                realm.setEmbedderData(embedderData);
            }
            embedderData.add(callback);
            return Undefined.instance;
        }
    }

    public abstract static class TestV8AtomicsBaseNode extends JSBuiltinNode {
        public TestV8AtomicsBaseNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        protected DynamicObject ensureSharedArray(Object maybeTarget) {
            if (JSArrayBufferView.isJSArrayBufferView(maybeTarget)) {
                DynamicObject buffer = JSArrayBufferView.getArrayBuffer((DynamicObject) maybeTarget);
                if (JSSharedArrayBuffer.isJSSharedArrayBuffer(buffer)) {
                    return (DynamicObject) maybeTarget;
                }
            }
            throw createTypeErrorNotSharedArray();
        }

        @TruffleBoundary
        protected final JSException createTypeErrorNotSharedArray() {
            return Errors.createTypeError("Cannot execute on non-shared array.", this);
        }

        @TruffleBoundary
        protected static final JSException createRangeErrorSharedArray(Object idx) {
            return Errors.createRangeError("Range error with index : " + idx);
        }

        protected static int validateAtomicAccess(DynamicObject target, long convertedIndex, Object originalIndex) {
            int length = JSArrayBufferView.typedArrayGetLength(target);
            assert convertedIndex >= 0;
            if (convertedIndex >= length) {
                throw createRangeErrorSharedArray(originalIndex);
            }
            return (int) convertedIndex;
        }

    }

    public abstract static class TestV8AtomicsNumWaitersForTestingNode extends TestV8AtomicsBaseNode {

        public TestV8AtomicsNumWaitersForTestingNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization
        protected Object numWaiters(Object maybeTarget, Object index,
                        @Cached("create()") JSToIndexNode toIndexNode) {
            DynamicObject target = ensureSharedArray(maybeTarget);
            int i = validateAtomicAccess(target, toIndexNode.executeLong(index), index);
            JSAgent agent = getRealm().getAgent();
            JSAgentWaiterListEntry wl = SharedMemorySync.getWaiterList(getContext(), agent, target, i);
            return wl.size();
        }

    }

    public abstract static class TestV8AtomicsNumUnresolvedAsyncPromisesForTestingNode extends TestV8AtomicsBaseNode {

        public TestV8AtomicsNumUnresolvedAsyncPromisesForTestingNode(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
        }

        @Specialization
        protected Object numUnresolvedAsyncPromises(Object maybeTarget, Object index,
                        @Cached("create()") JSToIndexNode toIndexNode) {
            DynamicObject target = ensureSharedArray(maybeTarget);
            int i = validateAtomicAccess(target, toIndexNode.executeLong(index), index);
            JSAgent agent = getRealm().getAgent();
            JSAgentWaiterListEntry wl = SharedMemorySync.getWaiterList(getContext(), agent, target, i);
            return agent.getAsyncWaitersToBeResolved(wl);
        }
    }

    public abstract static class TestV8SetAllowAtomicsWait extends JSBuiltinNode {
        @Child JSToBooleanNode toBooleanNode;

        public TestV8SetAllowAtomicsWait(JSContext context, JSBuiltin builtin) {
            super(context, builtin);
            this.toBooleanNode = JSToBooleanNode.create();
        }

        @Specialization
        protected Object setAllowAtomicsWait(Object allow) {
            getRealm().getAgent().setCanBlock(toBooleanNode.executeBoolean(allow));
            return Undefined.instance;
        }

    }

}
