// CheckStyle: start generated
package com.oracle.truffle.js.lang;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleFile.FileTypeDetector;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;
import com.oracle.truffle.api.TruffleLanguage.Provider;
import com.oracle.truffle.api.TruffleLanguage.Registration;
import com.oracle.truffle.api.debug.DebuggerTags.AlwaysHalt;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags.CallTag;
import com.oracle.truffle.api.instrumentation.StandardTags.ExpressionTag;
import com.oracle.truffle.api.instrumentation.StandardTags.RootBodyTag;
import com.oracle.truffle.api.instrumentation.StandardTags.RootTag;
import com.oracle.truffle.api.instrumentation.StandardTags.StatementTag;
import com.oracle.truffle.api.instrumentation.StandardTags.TryBlockTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.BinaryOperationTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.BuiltinRootTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.ControlFlowBlockTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.ControlFlowBranchTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.ControlFlowRootTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.DeclareTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.EvalCallTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.FunctionCallTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.InputNodeTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.LiteralTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.ObjectAllocationTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.ReadElementTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.ReadPropertyTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.UnaryOperationTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.WriteElementTag;
import com.oracle.truffle.js.nodes.instrumentation.JSTags.WritePropertyTag;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@GeneratedBy(JavaScriptLanguage.class)
@Registration(characterMimeTypes = {"application/javascript", "text/javascript", "application/javascript+module", "application/json"}, contextPolicy = ContextPolicy.SHARED, defaultMimeType = "application/javascript", dependentLanguages = {"regex"}, id = "js", implementationName = "GraalVM JavaScript", name = "JavaScript")
@ProvidedTags({StatementTag.class, RootTag.class, RootBodyTag.class, ExpressionTag.class, CallTag.class, com.oracle.truffle.api.instrumentation.StandardTags.ReadVariableTag.class, com.oracle.truffle.api.instrumentation.StandardTags.WriteVariableTag.class, TryBlockTag.class, AlwaysHalt.class, ObjectAllocationTag.class, BinaryOperationTag.class, UnaryOperationTag.class, com.oracle.truffle.js.nodes.instrumentation.JSTags.WriteVariableTag.class, ReadElementTag.class, WriteElementTag.class, ReadPropertyTag.class, WritePropertyTag.class, com.oracle.truffle.js.nodes.instrumentation.JSTags.ReadVariableTag.class, LiteralTag.class, FunctionCallTag.class, BuiltinRootTag.class, EvalCallTag.class, ControlFlowRootTag.class, ControlFlowBlockTag.class, ControlFlowBranchTag.class, DeclareTag.class, InputNodeTag.class})
public final class JavaScriptLanguageProvider implements Provider {

    @Override
    public String getLanguageClassName() {
        return "com.oracle.truffle.js.lang.JavaScriptLanguage";
    }

    @Override
    public TruffleLanguage<?> create() {
        return new JavaScriptLanguage();
    }

    @Override
    public List<FileTypeDetector> createFileTypeDetectors() {
        return Arrays.asList(new JSFileTypeDetector());
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Collections.emptySet();
    }

}
