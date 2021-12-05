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
package com.oracle.truffle.js.nodes.function;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameUtil;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode;
import com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode;
import com.oracle.truffle.js.nodes.access.ScopeFrameNode;
import com.oracle.truffle.js.runtime.JSFrameUtil;

import java.util.Set;

public abstract class IterationScopeNode extends JavaScriptNode {

    public static IterationScopeNode create(FrameDescriptor frameDescriptor, JSReadFrameSlotNode[] reads, JSWriteFrameSlotNode[] writes, FrameSlot blockScopeSlot) {
        return new FrameIterationScopeNode(frameDescriptor, reads, writes, blockScopeSlot);
    }

    @Override
    public abstract VirtualFrame execute(VirtualFrame frame);

    public abstract void executeCopy(VirtualFrame toFrame, VirtualFrame fromFrame);

    public abstract void exitScope(VirtualFrame frame, VirtualFrame prevFrame);

    public static final class FrameIterationScopeNode extends IterationScopeNode {
        private final FrameDescriptor frameDescriptor;
        @Children private final JSReadFrameSlotNode[] reads;
        @Children private final JSWriteFrameSlotNode[] writes;
        private final FrameSlot blockScopeSlot;

        public FrameIterationScopeNode(FrameDescriptor frameDescriptor, JSReadFrameSlotNode[] reads, JSWriteFrameSlotNode[] writes, FrameSlot blockScopeSlot) {
            this.frameDescriptor = frameDescriptor;
            this.reads = reads;
            this.writes = writes;
            this.blockScopeSlot = blockScopeSlot;
            assert reads.length == writes.length;
        }

        @Override
        public VirtualFrame execute(VirtualFrame frame) {
            VirtualFrame prevFrame = JSFrameUtil.castMaterializedFrame(FrameUtil.getObjectSafe(frame, blockScopeSlot));
            VirtualFrame nextFrame = Truffle.getRuntime().createVirtualFrame(frame.getArguments(), frameDescriptor).materialize();
            writes[0].executeWithFrame(nextFrame, reads[0].execute(prevFrame)); // copy parent slot
            copySlots(nextFrame, prevFrame);
            frame.setObject(blockScopeSlot, nextFrame);
            return prevFrame;
        }

        @Override
        public void executeCopy(VirtualFrame frame, VirtualFrame prevFrame) {
            VirtualFrame nextFrame = JSFrameUtil.castMaterializedFrame(FrameUtil.getObjectSafe(frame, blockScopeSlot));
            // no need to copy effectively final parent frame slot
            assert FrameUtil.getObjectSafe(nextFrame, nextFrame.getFrameDescriptor().findFrameSlot(ScopeFrameNode.PARENT_SCOPE_IDENTIFIER)) == FrameUtil.getObjectSafe(prevFrame,
                            prevFrame.getFrameDescriptor().findFrameSlot(ScopeFrameNode.PARENT_SCOPE_IDENTIFIER));
            copySlots(prevFrame, nextFrame);
            exitScope(frame, prevFrame);
        }

        @Override
        public void exitScope(VirtualFrame frame, VirtualFrame prevFrame) {
            frame.setObject(blockScopeSlot, prevFrame);
        }

        @ExplodeLoop
        private void copySlots(VirtualFrame nextFrame, VirtualFrame frame) {
            for (int i = 1; i < reads.length; i++) {
                writes[i].executeWithFrame(nextFrame, reads[i].execute(frame));
            }
        }

        public FrameDescriptor getFrameDescriptor() {
            return frameDescriptor;
        }

        @Override
        protected JavaScriptNode copyUninitialized(Set<Class<? extends Tag>> materializedTags) {
            return new FrameIterationScopeNode(frameDescriptor, cloneUninitialized(reads, materializedTags), cloneUninitialized(writes, materializedTags), blockScopeSlot);
        }
    }
}
