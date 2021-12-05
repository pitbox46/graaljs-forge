// CheckStyle: start generated
package com.oracle.truffle.js.nodes.module;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode;
import com.oracle.truffle.js.runtime.objects.ExportResolution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ReadImportBindingNode.class)
public final class ReadImportBindingNodeGen extends ReadImportBindingNode implements Introspection.Provider {

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private CachedData cached_cache;

    private ReadImportBindingNodeGen(JavaScriptNode resolutionNode) {
        super(resolutionNode);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object resolutionNodeValue_ = super.resolutionNode.execute(frameValue);
        if ((state_0 & 0b11) != 0 /* is-state_0 doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) || doUncached(ExportResolution) */ && resolutionNodeValue_ instanceof ExportResolution) {
            ExportResolution resolutionNodeValue__ = (ExportResolution) resolutionNodeValue_;
            if ((state_0 & 0b1) != 0 /* is-state_0 doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */) {
                CachedData s0_ = this.cached_cache;
                if (s0_ != null) {
                    if ((s0_.frameDescriptor_ == resolutionNodeValue__.getModule().getFrameDescriptor()) && (s0_.bindingName_.equals(resolutionNodeValue__.getBindingName()))) {
                        return ReadImportBindingNode.doCached(resolutionNodeValue__, s0_.frameDescriptor_, s0_.bindingName_, s0_.readFrameSlot_);
                    }
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(ExportResolution) */) {
                return doUncached(resolutionNodeValue__);
            }
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 doNamespace(DynamicObject) */ && JSTypes.isDynamicObject(resolutionNodeValue_)) {
            DynamicObject resolutionNodeValue__ = (DynamicObject) resolutionNodeValue_;
            if ((JSGuards.isJSModuleNamespace(resolutionNodeValue__))) {
                return ReadImportBindingNode.doNamespace(resolutionNodeValue__);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(resolutionNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object resolutionNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (resolutionNodeValue instanceof ExportResolution) {
                ExportResolution resolutionNodeValue_ = (ExportResolution) resolutionNodeValue;
                if ((exclude) == 0 /* is-not-exclude doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */) {
                    CachedData s0_ = this.cached_cache;
                    boolean Cached_duplicateFound_ = false;
                    if ((state_0 & 0b1) != 0 /* is-state_0 doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */) {
                        if ((s0_.frameDescriptor_ == resolutionNodeValue_.getModule().getFrameDescriptor()) && (s0_.bindingName_.equals(resolutionNodeValue_.getBindingName()))) {
                            Cached_duplicateFound_ = true;
                        }
                    }
                    if (!Cached_duplicateFound_) {
                        {
                            FrameDescriptor frameDescriptor__ = (resolutionNodeValue_.getModule().getFrameDescriptor());
                            if ((frameDescriptor__ == resolutionNodeValue_.getModule().getFrameDescriptor())) {
                                String bindingName__ = (resolutionNodeValue_.getBindingName());
                                if ((bindingName__.equals(resolutionNodeValue_.getBindingName())) && ((state_0 & 0b1)) == 0 /* is-not-state_0 doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */) {
                                    s0_ = super.insert(new CachedData());
                                    s0_.frameDescriptor_ = frameDescriptor__;
                                    s0_.bindingName_ = bindingName__;
                                    s0_.readFrameSlot_ = s0_.insertAccessor((JSReadFrameSlotNode.create(frameDescriptor__.findFrameSlot(bindingName__))));
                                    MemoryFence.storeStore();
                                    this.cached_cache = s0_;
                                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */;
                                    Cached_duplicateFound_ = true;
                                }
                            }
                        }
                    }
                    if (Cached_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return ReadImportBindingNode.doCached(resolutionNodeValue_, s0_.frameDescriptor_, s0_.bindingName_, s0_.readFrameSlot_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-exclude doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */;
                this.cached_cache = null;
                state_0 = state_0 & 0xfffffffe /* remove-state_0 doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doUncached(ExportResolution) */;
                lock.unlock();
                hasLock = false;
                return doUncached(resolutionNodeValue_);
            }
            if (JSTypes.isDynamicObject(resolutionNodeValue)) {
                DynamicObject resolutionNodeValue_ = (DynamicObject) resolutionNodeValue;
                if ((JSGuards.isJSModuleNamespace(resolutionNodeValue_))) {
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 doNamespace(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return ReadImportBindingNode.doNamespace(resolutionNodeValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.resolutionNode}, resolutionNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
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
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state_0 = this.state_0_;
        int exclude = this.exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state_0 & 0b1) != 0 /* is-state_0 doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s0_ = this.cached_cache;
            if (s0_ != null) {
                cached.add(Arrays.asList(s0_.frameDescriptor_, s0_.bindingName_, s0_.readFrameSlot_));
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-exclude doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state_0 & 0b10) != 0 /* is-state_0 doUncached(ExportResolution) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doNamespace";
        if ((state_0 & 0b100) != 0 /* is-state_0 doNamespace(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static ReadImportBindingNode create(JavaScriptNode resolutionNode) {
        return new ReadImportBindingNodeGen(resolutionNode);
    }

    @GeneratedBy(ReadImportBindingNode.class)
    private static final class CachedData extends Node {

        @CompilationFinal FrameDescriptor frameDescriptor_;
        @CompilationFinal String bindingName_;
        @Child JSReadFrameSlotNode readFrameSlot_;

        CachedData() {
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
