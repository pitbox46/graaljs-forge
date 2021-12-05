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
package com.oracle.truffle.js.nodes.control;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RepeatingNode;
import com.oracle.truffle.js.nodes.JSNodeUtil;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToBooleanUnaryNode;
import com.oracle.truffle.js.runtime.JSCancelledExecutionException;

abstract class AbstractRepeatingNode extends JavaScriptNode implements RepeatingNode, ResumableNode {

    @Child protected JavaScriptNode conditionNode;
    @Child protected JavaScriptNode bodyNode;

    AbstractRepeatingNode(JavaScriptNode condition, JavaScriptNode body) {
        this.conditionNode = JSToBooleanUnaryNode.create(condition);
        this.bodyNode = body;
    }

    protected final boolean executeCondition(VirtualFrame frame) {
        return StatementNode.executeConditionAsBoolean(frame, conditionNode);
    }

    protected final void executeBody(VirtualFrame frame) {
        bodyNode.executeVoid(frame);
        if (CompilerDirectives.inInterpreter()) {
            checkThreadInterrupted();
        }
    }

    private void checkThreadInterrupted() {
        CompilerAsserts.neverPartOfCompilation("do not check thread interruption from compiled code");
        if (Thread.interrupted()) {
            throw new JSCancelledExecutionException("Thread was interrupted.", this);
        }
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return executeRepeating(frame);
    }

    public static boolean materializationNeeded(RepeatingNode repeatingNode) {
        if (!(repeatingNode instanceof AbstractRepeatingNode)) {
            // Other repeating nodes e.g. Generators are not instrumentable yet.
            return false;
        }
        assert repeatingNode instanceof AbstractRepeatingNode;
        // If we are using tagged nodes, this node is already materialized.
        JavaScriptNode rnBodyNode = ((AbstractRepeatingNode) repeatingNode).bodyNode;
        return !JSNodeUtil.isTaggedNode(rnBodyNode);
    }

}
