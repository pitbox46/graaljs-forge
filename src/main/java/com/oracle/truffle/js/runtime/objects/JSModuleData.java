/*
 * Copyright (c) 2021, 2021, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.js.runtime.objects;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.oracle.js.parser.ir.Module;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.js.runtime.builtins.JSFunctionData;

/**
 * ES module data that can be shared across contexts.
 */
public final class JSModuleData extends ScriptOrModule {

    /** Module parse node. */
    private final Module module;

    private final JSFunctionData functionData;
    private final FrameDescriptor frameDescriptor;

    /**
     * Cache of imported module sources to keep alive sources referenced by this module in order to
     * prevent premature code cache GC of this module's dependencies.
     */
    private final Map<String, Source> importSourceCache = new ConcurrentHashMap<>();

    public JSModuleData(Module module, Source source, JSFunctionData functionData, FrameDescriptor frameDescriptor) {
        super(functionData.getContext(), source);
        this.module = module;
        this.functionData = functionData;
        this.frameDescriptor = frameDescriptor;
    }

    public Module getModule() {
        return module;
    }

    public JSFunctionData getFunctionData() {
        return functionData;
    }

    public FrameDescriptor getFrameDescriptor() {
        return frameDescriptor;
    }

    public boolean isTopLevelAsync() {
        return functionData.isAsync();
    }

    /**
     * Keep a link from the referencing module to the imported module's Source, so that the latter
     * is kept alive for the lifetime of the former.
     */
    public void rememberImportedModuleSource(String moduleSpecifier, Source moduleSource) {
        // Note: the source might change, so we only remember the last source.
        importSourceCache.put(moduleSpecifier, moduleSource);
    }

}
