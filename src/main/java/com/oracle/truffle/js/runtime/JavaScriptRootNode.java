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
package com.oracle.truffle.js.runtime;

import java.util.List;

import com.oracle.truffle.api.TruffleStackTraceElement;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.js.lang.JavaScriptLanguage;

public abstract class JavaScriptRootNode extends RootNode {
    private static final FrameDescriptor SHARED_EMPTY_FRAMEDESCRIPTOR = new FrameDescriptor();
    private final SourceSection sourceSection;

    protected JavaScriptRootNode() {
        this(null, null, null);
    }

    protected JavaScriptRootNode(JavaScriptLanguage lang, SourceSection sourceSection, FrameDescriptor frameDescriptor) {
        super(lang, substituteNullWithSharedEmptyFrameDescriptor(frameDescriptor));
        this.sourceSection = sourceSection;
    }

    private static FrameDescriptor substituteNullWithSharedEmptyFrameDescriptor(FrameDescriptor frameDescriptor) {
        return frameDescriptor == null ? SHARED_EMPTY_FRAMEDESCRIPTOR : frameDescriptor;
    }

    @Override
    public SourceSection getSourceSection() {
        return sourceSection;
    }

    @Override
    public boolean isInternal() {
        SourceSection sc = getSourceSection();
        if (sc != null) {
            return sc.getSource().isInternal();
        }
        return false;
    }

    /**
     * Is this a regular JS function with standard arguments, to be included in stack traces.
     */
    public boolean isFunction() {
        return false;
    }

    /**
     * Is this a root node for the resumption of a suspended function.
     */
    public boolean isResumption() {
        return false;
    }

    @Override
    public boolean isCaptureFramesForTrace() {
        return isFunction() || isResumption();
    }

    @Override
    protected boolean countsTowardsStackTraceLimit() {
        return false;
    }

    public static List<TruffleStackTraceElement> findAsynchronousFrames(JavaScriptRootNode rootNode, Frame frame) {
        return rootNode.findAsynchronousFrames(frame);
    }

    protected final JSRealm getRealm() {
        return JSRealm.get(this);
    }

    @SuppressWarnings("all")
    protected final JavaScriptLanguage getLanguage() {
        return JavaScriptLanguage.get(this);
    }

}
