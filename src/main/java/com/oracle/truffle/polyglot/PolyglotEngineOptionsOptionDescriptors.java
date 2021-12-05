// CheckStyle: start generated
package com.oracle.truffle.polyglot;

import com.oracle.truffle.api.dsl.GeneratedBy;
import java.util.Arrays;
import java.util.Iterator;
import org.graalvm.options.OptionCategory;
import org.graalvm.options.OptionDescriptor;
import org.graalvm.options.OptionDescriptors;
import org.graalvm.options.OptionStability;

@GeneratedBy(PolyglotEngineOptions.class)
final class PolyglotEngineOptionsOptionDescriptors implements OptionDescriptors {

    @Override
    public OptionDescriptor get(String optionName) {
        switch (optionName) {
            case "engine.InstrumentExceptionsAreThrown" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.InstrumentExceptionsAreThrown, "engine.InstrumentExceptionsAreThrown").deprecated(false).help("Propagates exceptions thrown by instruments.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "engine.PreinitializeContexts" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.PreinitializeContexts, "engine.PreinitializeContexts").deprecated(true).deprecationMessage("").help("Preinitialize language contexts for given languages.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "engine.RelaxStaticObjectSafetyChecks" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.RelaxStaticObjectSafetyChecks, "engine.RelaxStaticObjectSafetyChecks").deprecated(false).help("On property accesses, the Static Object Model does not perform shape checks and uses unsafe casts").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "engine.SafepointALot" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.SafepointALot, "engine.SafepointALot").deprecated(false).help("Repeadly submits thread local actions and collects statistics about safepoint intervals in the process. Prints event and interval statistics when the context is closed for each thread. This option significantly slows down execution and is therefore intended for testing purposes only.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "engine.ShowInternalStackFrames" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.ShowInternalStackFrames, "engine.ShowInternalStackFrames").deprecated(false).help("Show internal frames specific to the language implementation in stack traces.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "engine.SpecializationStatistics" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.SpecializationStatistics, "engine.SpecializationStatistics").deprecated(false).help("Enables specialization statistics for nodes generated with Truffle DSL and prints the result on exit. In order for this flag to be functional -Atruffle.dsl.GenerateSpecializationStatistics=true needs to be set at build time.Enabling this flag and the compiler option has major implications on the performance and footprint of the interpreter.Do not use in production environments.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "engine.StaticObjectStorageStrategy" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.StaticObjectStorageStrategy, "engine.StaticObjectStorageStrategy").deprecated(false).help("Set the storage strategy used by the Static Object Model. Accepted values are: ['default', 'array-based', 'field-based']").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "engine.TraceStackTraceInterval" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.TraceStackTraceInterval, "engine.TraceStackTraceInterval").deprecated(false).help("Prints the stack trace for all threads for a time interval. By default 0, which disables the output.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "engine.TraceThreadLocalActions" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.TraceThreadLocalActions, "engine.TraceThreadLocalActions").deprecated(false).help("Traces thread local events and when they are processed on the individual threads.Prints messages with the [engine] [tl] prefix. ").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "engine.TriggerUncaughtExceptionHandlerForCancel" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.TriggerUncaughtExceptionHandlerForCancel, "engine.TriggerUncaughtExceptionHandlerForCancel").deprecated(false).help("Propagates cancel execution exception into UncaughtExceptionHandler. For testing purposes only.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "engine.UseConservativeContextReferences" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.UseConservativeContextReferences, "engine.UseConservativeContextReferences").deprecated(false).help("Enables conservative context references. This allows invalid sharing between contexts. For testing purposes only.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "engine.UsePreInitializedContext" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.UsePreInitializedContext, "engine.UsePreInitializedContext").deprecated(false).help("Use pre-initialized context when it's available.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "engine.WarnInterpreterOnly" :
                return OptionDescriptor.newBuilder(PolyglotEngineOptions.WarnInterpreterOnly, "engine.WarnInterpreterOnly").deprecated(false).help("Print warning when the engine is using a default Truffle runtime.").category(OptionCategory.USER).stability(OptionStability.STABLE).build();
        }
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        return Arrays.asList(
            OptionDescriptor.newBuilder(PolyglotEngineOptions.InstrumentExceptionsAreThrown, "engine.InstrumentExceptionsAreThrown").deprecated(false).help("Propagates exceptions thrown by instruments.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(PolyglotEngineOptions.PreinitializeContexts, "engine.PreinitializeContexts").deprecated(true).deprecationMessage("").help("Preinitialize language contexts for given languages.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(PolyglotEngineOptions.RelaxStaticObjectSafetyChecks, "engine.RelaxStaticObjectSafetyChecks").deprecated(false).help("On property accesses, the Static Object Model does not perform shape checks and uses unsafe casts").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(PolyglotEngineOptions.SafepointALot, "engine.SafepointALot").deprecated(false).help("Repeadly submits thread local actions and collects statistics about safepoint intervals in the process. Prints event and interval statistics when the context is closed for each thread. This option significantly slows down execution and is therefore intended for testing purposes only.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(PolyglotEngineOptions.ShowInternalStackFrames, "engine.ShowInternalStackFrames").deprecated(false).help("Show internal frames specific to the language implementation in stack traces.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(PolyglotEngineOptions.SpecializationStatistics, "engine.SpecializationStatistics").deprecated(false).help("Enables specialization statistics for nodes generated with Truffle DSL and prints the result on exit. In order for this flag to be functional -Atruffle.dsl.GenerateSpecializationStatistics=true needs to be set at build time.Enabling this flag and the compiler option has major implications on the performance and footprint of the interpreter.Do not use in production environments.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(PolyglotEngineOptions.StaticObjectStorageStrategy, "engine.StaticObjectStorageStrategy").deprecated(false).help("Set the storage strategy used by the Static Object Model. Accepted values are: ['default', 'array-based', 'field-based']").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(PolyglotEngineOptions.TraceStackTraceInterval, "engine.TraceStackTraceInterval").deprecated(false).help("Prints the stack trace for all threads for a time interval. By default 0, which disables the output.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(PolyglotEngineOptions.TraceThreadLocalActions, "engine.TraceThreadLocalActions").deprecated(false).help("Traces thread local events and when they are processed on the individual threads.Prints messages with the [engine] [tl] prefix. ").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(PolyglotEngineOptions.TriggerUncaughtExceptionHandlerForCancel, "engine.TriggerUncaughtExceptionHandlerForCancel").deprecated(false).help("Propagates cancel execution exception into UncaughtExceptionHandler. For testing purposes only.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(PolyglotEngineOptions.UseConservativeContextReferences, "engine.UseConservativeContextReferences").deprecated(false).help("Enables conservative context references. This allows invalid sharing between contexts. For testing purposes only.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(PolyglotEngineOptions.UsePreInitializedContext, "engine.UsePreInitializedContext").deprecated(false).help("Use pre-initialized context when it's available.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(PolyglotEngineOptions.WarnInterpreterOnly, "engine.WarnInterpreterOnly").deprecated(false).help("Print warning when the engine is using a default Truffle runtime.").category(OptionCategory.USER).stability(OptionStability.STABLE).build())
        .iterator();
    }

}
