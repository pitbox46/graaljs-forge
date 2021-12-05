/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.js.nodes.control;

import java.util.Set;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.InstrumentableNode;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.nodes.LoopNode;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RepeatingNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.JSConstantNode;
import com.oracle.truffle.js.nodes.instrumentation.JSTaggedExecutionNode;
import com.oracle.truffle.js.nodes.instrumentation.JSTags;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.ControlFlowBlockTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.ControlFlowBranchTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.ControlFlowRootTag;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.objects.Undefined;

/**
 * 12.6.2 The while Statement.
 */
@NodeInfo(shortName = "while")
public final class WhileNode extends StatementNode {

    @Child private LoopNode loop;

    private final ControlFlowRootTag.Type loopType;

    private WhileNode(RepeatingNode repeatingNode, ControlFlowRootTag.Type type) {
        this.loop = Truffle.getRuntime().createLoopNode(repeatingNode);
        this.loopType = type;
    }

    private static JavaScriptNode createWhileDo(JavaScriptNode condition, JavaScriptNode body, ControlFlowRootTag.Type type) {
        if (condition instanceof JSConstantNode && !JSRuntime.toBoolean(((JSConstantNode) condition).getValue())) {
            return new EmptyNode();
        }
        JavaScriptNode nonVoidBody = body instanceof DiscardResultNode ? ((DiscardResultNode) body).getOperand() : body;
        return new WhileNode(new WhileDoRepeatingNode(condition, nonVoidBody), type);
    }

    public static JavaScriptNode createWhileDo(JavaScriptNode condition, JavaScriptNode body) {
        return createWhileDo(condition, body, ControlFlowRootTag.Type.WhileIteration);
    }

    public static JavaScriptNode createDesugaredFor(JavaScriptNode condition, JavaScriptNode body) {
        return createWhileDo(condition, body, ControlFlowRootTag.Type.ForIteration);
    }

    public static JavaScriptNode createDesugaredForOf(JavaScriptNode condition, JavaScriptNode body) {
        return createWhileDo(condition, body, ControlFlowRootTag.Type.ForOfIteration);
    }

    public static JavaScriptNode createDesugaredForIn(JavaScriptNode condition, JavaScriptNode body) {
        return createWhileDo(condition, body, ControlFlowRootTag.Type.ForInIteration);
    }

    public static JavaScriptNode createDesugaredForAwaitOf(JavaScriptNode condition, JavaScriptNode body) {
        return createWhileDo(condition, body, ControlFlowRootTag.Type.ForAwaitOfIteration);
    }

    public static JavaScriptNode createDoWhile(JavaScriptNode condition, JavaScriptNode body) {
        if (condition instanceof JSConstantNode && !JSRuntime.toBoolean(((JSConstantNode) condition).getValue())) {
            // do {} while (0); happens 336 times in Mandreel
            return body;
        }
        JavaScriptNode nonVoidBody = body instanceof DiscardResultNode ? ((DiscardResultNode) body).getOperand() : body;
        return new WhileNode(new DoWhileRepeatingNode(condition, nonVoidBody), ControlFlowRootTag.Type.DoWhileIteration);
    }

    @Override
    public boolean hasTag(Class<? extends Tag> tag) {
        if (tag == ControlFlowRootTag.class) {
            return true;
        }
        return super.hasTag(tag);
    }

    @Override
    public Object getNodeObject() {
        return JSTags.createNodeObjectDescriptor("type", loopType.name());
    }

    @Override
    public InstrumentableNode materializeInstrumentableNodes(Set<Class<? extends Tag>> materializedTags) {
        if (hasMaterializationTag(materializedTags) && AbstractRepeatingNode.materializationNeeded(loop.getRepeatingNode())) {
            // The repeating node should not have a wrapper, because it has no source section
            if (loop.getRepeatingNode() instanceof AbstractRepeatingNode) {
                AbstractRepeatingNode repeatingNode = (AbstractRepeatingNode) loop.getRepeatingNode();
                JavaScriptNode bodyNode = JSTaggedExecutionNode.createFor(repeatingNode.bodyNode, ControlFlowBlockTag.class, materializedTags);
                JavaScriptNode conditionNode = JSTaggedExecutionNode.createForInput(repeatingNode.conditionNode, ControlFlowBranchTag.class,
                                JSTags.createNodeObjectDescriptor("type", ControlFlowBranchTag.Type.Condition.name()), materializedTags);
                if (bodyNode == repeatingNode.bodyNode && conditionNode == repeatingNode.conditionNode) {
                    return this;
                }
                if (bodyNode == repeatingNode.bodyNode) {
                    bodyNode = cloneUninitialized(repeatingNode.bodyNode, materializedTags);
                }
                if (conditionNode == repeatingNode.conditionNode) {
                    conditionNode = cloneUninitialized(repeatingNode.conditionNode, materializedTags);
                }
                transferSourceSection(this, bodyNode);
                WhileNode materialized;
                if (repeatingNode instanceof DoWhileRepeatingNode) {
                    materialized = new WhileNode(new DoWhileRepeatingNode(conditionNode, bodyNode), loopType);
                } else {
                    assert repeatingNode instanceof WhileDoRepeatingNode;
                    materialized = new WhileNode(new WhileDoRepeatingNode(conditionNode, bodyNode), loopType);
                }
                transferSourceSectionAndTags(this, materialized);
                return materialized;
            }
        }
        return this;
    }

    private static boolean hasMaterializationTag(Set<Class<? extends Tag>> materializedTags) {
        return materializedTags.contains(ControlFlowRootTag.class) || materializedTags.contains(ControlFlowBlockTag.class) ||
                        materializedTags.contains(ControlFlowBranchTag.class);
    }

    @Override
    protected JavaScriptNode copyUninitialized(Set<Class<? extends Tag>> materializedTags) {
        return new WhileNode((RepeatingNode) cloneUninitialized((JavaScriptNode) loop.getRepeatingNode(), materializedTags), loopType);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        loop.execute(frame);
        return EMPTY;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        loop.execute(frame);
    }

    @Override
    public boolean isResultAlwaysOfType(Class<?> clazz) {
        assert EMPTY == Undefined.instance;
        return clazz == Undefined.class;
    }

    /** do {body} while(condition). */
    private static final class DoWhileRepeatingNode extends AbstractRepeatingNode {

        DoWhileRepeatingNode(JavaScriptNode condition, JavaScriptNode body) {
            super(condition, body);
        }

        @Override
        public boolean executeRepeating(VirtualFrame frame) {
            executeBody(frame);
            return executeCondition(frame);

        }

        @Override
        public Object resume(VirtualFrame frame) {
            int index = getStateAsIntAndReset(frame);
            if (index == 0) {
                executeBody(frame);
            }
            try {
                return executeCondition(frame);
            } catch (YieldException e) {
                setState(frame, 1);
                throw e;
            }
        }

        @Override
        protected JavaScriptNode copyUninitialized(Set<Class<? extends Tag>> materializedTags) {
            return new DoWhileRepeatingNode(cloneUninitialized(conditionNode, materializedTags), cloneUninitialized(bodyNode, materializedTags));
        }
    }

    /** while(condition) {body}. */
    private static final class WhileDoRepeatingNode extends AbstractRepeatingNode {

        WhileDoRepeatingNode(JavaScriptNode condition, JavaScriptNode body) {
            super(condition, body);
        }

        @Override
        public boolean executeRepeating(VirtualFrame frame) {
            if (executeCondition(frame)) {
                executeBody(frame);
                return true;
            }
            return false;
        }

        @Override
        public Object resume(VirtualFrame frame) {
            int index = getStateAsIntAndReset(frame);
            if (index != 0 || executeCondition(frame)) {
                try {
                    executeBody(frame);
                } catch (YieldException e) {
                    setState(frame, 1);
                    throw e;
                }
                return true;
            }
            return false;
        }

        @Override
        protected JavaScriptNode copyUninitialized(Set<Class<? extends Tag>> materializedTags) {
            return new WhileDoRepeatingNode(cloneUninitialized(conditionNode, materializedTags), cloneUninitialized(bodyNode, materializedTags));
        }
    }
}
