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
package com.oracle.truffle.js.nodes.binary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.unary.JSIsNullOrUndefinedNode;

import java.util.Set;

@NodeInfo(shortName = "??")
public class JSNullishCoalescingNode extends JSLogicalNode {

    @Child private JSIsNullOrUndefinedNode isNullOrUndefinedNode;

    public JSNullishCoalescingNode(JavaScriptNode left, JavaScriptNode right) {
        super(left, right, false);
    }

    public static JSNullishCoalescingNode create(JavaScriptNode left, JavaScriptNode right) {
        return new JSNullishCoalescingNode(left, right);
    }

    @Override
    public boolean isResultAlwaysOfType(Class<?> clazz) {
        return getLeft().isResultAlwaysOfType(clazz) && getRight().isResultAlwaysOfType(clazz);
    }

    @Override
    protected JavaScriptNode copyUninitialized(Set<Class<? extends Tag>> materializedTags) {
        return new JSNullishCoalescingNode(cloneUninitialized(getLeft(), materializedTags), cloneUninitialized(getRight(), materializedTags));
    }

    @Override
    protected boolean useLeftValue(Object leftValue) {
        if (isNullOrUndefinedNode == null) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            isNullOrUndefinedNode = insert(JSIsNullOrUndefinedNode.create());
        }
        return !isNullOrUndefinedNode.executeBoolean(leftValue);
    }
}
