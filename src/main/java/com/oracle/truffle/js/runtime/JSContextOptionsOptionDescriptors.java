// CheckStyle: start generated
package com.oracle.truffle.js.runtime;

import com.oracle.truffle.api.dsl.GeneratedBy;
import java.util.Arrays;
import java.util.Iterator;
import org.graalvm.options.OptionCategory;
import org.graalvm.options.OptionDescriptor;
import org.graalvm.options.OptionDescriptors;
import org.graalvm.options.OptionStability;

@GeneratedBy(JSContextOptions.class)
final class JSContextOptionsOptionDescriptors implements OptionDescriptors {

    @Override
    public OptionDescriptor get(String optionName) {
        switch (optionName) {
            case "js.agent-can-block" :
                return OptionDescriptor.newBuilder(JSContextOptions.AGENT_CAN_BLOCK, "js.agent-can-block").deprecated(false).help("Determines whether agents can block or not.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.annex-b" :
                return OptionDescriptor.newBuilder(JSContextOptions.ANNEX_B, "js.annex-b").deprecated(false).help("Enable ECMAScript Annex B features.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.async-stack-traces" :
                return OptionDescriptor.newBuilder(JSContextOptions.ASYNC_STACK_TRACES, "js.async-stack-traces").deprecated(false).help("Include async function frames in stack traces.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.atomics" :
                return OptionDescriptor.newBuilder(JSContextOptions.ATOMICS, "js.atomics").deprecated(false).help("Enable ES2017 Atomics.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.await-optimization" :
                return OptionDescriptor.newBuilder(JSContextOptions.AWAIT_OPTIMIZATION, "js.await-optimization").deprecated(false).help("Use PromiseResolve for Await.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.bigint" :
                return OptionDescriptor.newBuilder(JSContextOptions.BIGINT, "js.bigint").deprecated(false).help("Provide an implementation of the BigInt proposal.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.bind-member-functions" :
                return OptionDescriptor.newBuilder(JSContextOptions.BIND_MEMBER_FUNCTIONS, "js.bind-member-functions").deprecated(false).help("Bind functions returned by Value.getMember to the receiver object.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.class-fields" :
                return OptionDescriptor.newBuilder(JSContextOptions.CLASS_FIELDS, "js.class-fields").deprecated(false).help("Enable the class public and private fields proposal.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.commonjs-core-modules-replacements" :
                return OptionDescriptor.newBuilder(JSContextOptions.COMMONJS_CORE_MODULES_REPLACEMENTS, "js.commonjs-core-modules-replacements").deprecated(false).help("Npm packages used to replace global Node.js builtins. Syntax: name1:module1,name2:module2,...").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.commonjs-global-properties" :
                return OptionDescriptor.newBuilder(JSContextOptions.COMMONJS_REQUIRE_GLOBAL_PROPERTIES, "js.commonjs-global-properties").deprecated(false).help("Npm package used to populate Node.js global object.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.commonjs-require" :
                return OptionDescriptor.newBuilder(JSContextOptions.COMMONJS_REQUIRE, "js.commonjs-require").deprecated(false).help("Enable CommonJS require emulation.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.commonjs-require-cwd" :
                return OptionDescriptor.newBuilder(JSContextOptions.COMMONJS_REQUIRE_CWD, "js.commonjs-require-cwd").deprecated(false).help("CommonJS default current working directory.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.console" :
                return OptionDescriptor.newBuilder(JSContextOptions.CONSOLE, "js.console").deprecated(false).help("Provide 'console' global property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.const-as-var" :
                return OptionDescriptor.newBuilder(JSContextOptions.CONST_AS_VAR, "js.const-as-var").deprecated(false).help("Parse const declarations as a var (legacy compatibility option).").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.debug-builtin" :
                return OptionDescriptor.newBuilder(JSContextOptions.DEBUG_BUILTIN, "js.debug-builtin").deprecated(false).help("Provide a non-API Debug builtin. Behaviour will likely change. Don't depend on this in production code.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.debug-property-name" :
                return OptionDescriptor.newBuilder(JSContextOptions.DEBUG_PROPERTY_NAME, "js.debug-property-name").deprecated(false).help("The name used for the Graal.js debug builtin.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.direct-byte-buffer" :
                return OptionDescriptor.newBuilder(JSContextOptions.DIRECT_BYTE_BUFFER, "js.direct-byte-buffer").deprecated(false).help("Use direct (off-heap) byte buffer for typed arrays.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.disable-eval" :
                return OptionDescriptor.newBuilder(JSContextOptions.DISABLE_EVAL, "js.disable-eval").deprecated(false).help("User code is not allowed to parse code via e.g. eval().").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.disable-with" :
                return OptionDescriptor.newBuilder(JSContextOptions.DISABLE_WITH, "js.disable-with").deprecated(false).help("User code is not allowed to use the 'with' statement.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.ecmascript-version" :
                return OptionDescriptor.newBuilder(JSContextOptions.ECMASCRIPT_VERSION, "js.ecmascript-version").deprecated(false).help("ECMAScript Version.").category(OptionCategory.USER).stability(OptionStability.STABLE).build();
            case "js.error-cause" :
                return OptionDescriptor.newBuilder(JSContextOptions.ERROR_CAUSE, "js.error-cause").deprecated(false).help("Enable the error cause proposal. Allows an error to be chained with a cause using the optional options parameter.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.esm-eval-returns-exports" :
                return OptionDescriptor.newBuilder(JSContextOptions.ESM_EVAL_RETURNS_EXPORTS, "js.esm-eval-returns-exports").deprecated(false).help("Eval of an ES module through the polyglot API returns its exported symbols.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.experimental-foreign-object-prototype" :
                return OptionDescriptor.newBuilder(JSContextOptions.EXPERIMENTAL_FOREIGN_OBJECT_PROTOTYPE, "js.experimental-foreign-object-prototype").deprecated(true).deprecationMessage("").help("Non-JS objects have prototype (Object/Function/Array.prototype) set; deprecated old name.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.foreign-hash-properties" :
                return OptionDescriptor.newBuilder(JSContextOptions.FOREIGN_HASH_PROPERTIES, "js.foreign-hash-properties").deprecated(false).help("Allow getting/setting non-JS hash entries using the `[]` and `.` operators.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.foreign-object-prototype" :
                return OptionDescriptor.newBuilder(JSContextOptions.FOREIGN_OBJECT_PROTOTYPE, "js.foreign-object-prototype").deprecated(false).help("Non-JS objects have prototype (Object/Function/Array.prototype) set.").category(OptionCategory.EXPERT).stability(OptionStability.STABLE).build();
            case "js.function-arguments-limit" :
                return OptionDescriptor.newBuilder(JSContextOptions.FUNCTION_ARGUMENTS_LIMIT, "js.function-arguments-limit").deprecated(false).help("Maximum number of arguments for functions.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.function-cache-limit" :
                return OptionDescriptor.newBuilder(JSContextOptions.FUNCTION_CACHE_LIMIT, "js.function-cache-limit").deprecated(false).help("Maximum allowed size of a function cache.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.function-constructor-cache-size" :
                return OptionDescriptor.newBuilder(JSContextOptions.FUNCTION_CONSTRUCTOR_CACHE_SIZE, "js.function-constructor-cache-size").deprecated(false).help("Maximum size of the parsing cache used by the Function constructor to avoid re-parsing known sources.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.function-statement-error" :
                return OptionDescriptor.newBuilder(JSContextOptions.FUNCTION_STATEMENT_ERROR, "js.function-statement-error").deprecated(false).help("Treat hoistable function statements in blocks as an error (in ES5 mode).").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.global-arguments" :
                return OptionDescriptor.newBuilder(JSContextOptions.GLOBAL_ARGUMENTS, "js.global-arguments").deprecated(false).help("Provide 'arguments' global property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.global-property" :
                return OptionDescriptor.newBuilder(JSContextOptions.GLOBAL_PROPERTY, "js.global-property").deprecated(false).help("Provide 'global' global property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.graal-builtin" :
                return OptionDescriptor.newBuilder(JSContextOptions.GRAAL_BUILTIN, "js.graal-builtin").deprecated(false).help("Provide 'Graal' global property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.import-assertions" :
                return OptionDescriptor.newBuilder(JSContextOptions.IMPORT_ASSERTIONS, "js.import-assertions").deprecated(false).help("Enable import assertions").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.interop-complete-promises" :
                return OptionDescriptor.newBuilder(JSContextOptions.INTEROP_COMPLETE_PROMISES, "js.interop-complete-promises").deprecated(false).help("Resolve promises when crossing a polyglot language boundary.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.intl-402" :
                return OptionDescriptor.newBuilder(JSContextOptions.INTL_402, "js.intl-402").deprecated(false).help("Enable ECMAScript Internationalization API.").category(OptionCategory.USER).stability(OptionStability.STABLE).build();
            case "js.java-package-globals" :
                return OptionDescriptor.newBuilder(JSContextOptions.JAVA_PACKAGE_GLOBALS, "js.java-package-globals").deprecated(false).help("Provide Java package globals: Packages, java, javafx, javax, com, org, edu.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.json-modules" :
                return OptionDescriptor.newBuilder(JSContextOptions.JSON_MODULES, "js.json-modules").deprecated(false).help("Enable loading of json modules").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.lazy-translation" :
                return OptionDescriptor.newBuilder(JSContextOptions.LAZY_TRANSLATION, "js.lazy-translation").deprecated(false).help("Translate function bodies lazily.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.load" :
                return OptionDescriptor.newBuilder(JSContextOptions.LOAD, "js.load").deprecated(false).help("Provide 'load' global function.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.load-from-classpath" :
                return OptionDescriptor.newBuilder(JSContextOptions.LOAD_FROM_CLASSPATH, "js.load-from-classpath").deprecated(false).help("Allow 'load' to access 'classpath:' URLs. Do not use with untrusted code.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.load-from-url" :
                return OptionDescriptor.newBuilder(JSContextOptions.LOAD_FROM_URL, "js.load-from-url").deprecated(false).help("Allow 'load' to access URLs. Do not use with untrusted code.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.locale" :
                return OptionDescriptor.newBuilder(JSContextOptions.LOCALE, "js.locale").deprecated(false).help("Use a specific default locale for locale-sensitive operations.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.max-apply-argument-length" :
                return OptionDescriptor.newBuilder(JSContextOptions.MAX_APPLY_ARGUMENT_LENGTH, "js.max-apply-argument-length").deprecated(false).help("Maximum allowed number of arguments allowed in an apply function.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.max-prototype-chain-length" :
                return OptionDescriptor.newBuilder(JSContextOptions.MAX_PROTOTYPE_CHAIN_LENGTH, "js.max-prototype-chain-length").deprecated(false).help("Maximum allowed length of a prototype chain.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.max-typed-array-length" :
                return OptionDescriptor.newBuilder(JSContextOptions.MAX_TYPED_ARRAY_LENGTH, "js.max-typed-array-length").deprecated(false).help("Maximum allowed length for TypedArrays.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.mle-mode" :
                return OptionDescriptor.newBuilder(JSContextOptions.MLE_MODE, "js.mle-mode").deprecated(false).help("Provide a non-API MLE builtin. Behaviour will likely change. Don't depend on this in production code.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.nashorn-compat" :
                return OptionDescriptor.newBuilder(JSContextOptions.NASHORN_COMPATIBILITY_MODE, "js.nashorn-compat").deprecated(false).help("Provide compatibility with the OpenJDK Nashorn engine. Do not use with untrusted code.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.new-set-methods" :
                return OptionDescriptor.newBuilder(JSContextOptions.NEW_SET_METHODS, "js.new-set-methods").deprecated(false).help("Enable new Set methods.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.operator-overloading" :
                return OptionDescriptor.newBuilder(JSContextOptions.OPERATOR_OVERLOADING, "js.operator-overloading").deprecated(false).help("Enable operator overloading").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.parse-only" :
                return OptionDescriptor.newBuilder(JSContextOptions.PARSE_ONLY, "js.parse-only").deprecated(false).help("Only parse source code, do not run it.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.performance" :
                return OptionDescriptor.newBuilder(JSContextOptions.PERFORMANCE, "js.performance").deprecated(false).help("Provide 'performance' global property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.polyglot-builtin" :
                return OptionDescriptor.newBuilder(JSContextOptions.POLYGLOT_BUILTIN, "js.polyglot-builtin").deprecated(true).deprecationMessage("").help("Provide 'Polyglot' global property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.polyglot-evalfile" :
                return OptionDescriptor.newBuilder(JSContextOptions.POLYGLOT_EVALFILE, "js.polyglot-evalfile").deprecated(false).help("Provide 'Polyglot.evalFile' function.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.print" :
                return OptionDescriptor.newBuilder(JSContextOptions.PRINT, "js.print").deprecated(false).help("Provide 'print' global function.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.private-fields-in" :
                return OptionDescriptor.newBuilder(JSContextOptions.PRIVATE_FIELDS_IN, "js.private-fields-in").deprecated(false).help("Enable private field in in operator").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.profile-time" :
                return OptionDescriptor.newBuilder(JSContextOptions.PROFILE_TIME, "js.profile-time").deprecated(false).help("Enable time profiling.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.profile-time-print-cumulative" :
                return OptionDescriptor.newBuilder(JSContextOptions.PROFILE_TIME_PRINT_CUMULATIVE, "js.profile-time-print-cumulative").deprecated(false).help("Print cumulative time when time profiling is enabled.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.property-cache-limit" :
                return OptionDescriptor.newBuilder(JSContextOptions.PROPERTY_CACHE_LIMIT, "js.property-cache-limit").deprecated(false).help("Maximum allowed size of a property cache.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.regex-regression-test-mode" :
                return OptionDescriptor.newBuilder(JSContextOptions.REGEX_REGRESSION_TEST_MODE, "js.regex-regression-test-mode").deprecated(false).help("Test mode for TRegex.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.regex.always-eager" :
                return OptionDescriptor.newBuilder(JSContextOptions.REGEX_ALWAYS_EAGER, "js.regex.always-eager").deprecated(false).help("Always match capture groups eagerly.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.regex.dump-automata" :
                return OptionDescriptor.newBuilder(JSContextOptions.REGEX_DUMP_AUTOMATA, "js.regex.dump-automata").deprecated(false).help("Produce ASTs and automata in JSON, DOT (GraphViz) and LaTeX formats.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.regex.step-execution" :
                return OptionDescriptor.newBuilder(JSContextOptions.REGEX_STEP_EXECUTION, "js.regex.step-execution").deprecated(false).help("Trace the execution of automata in JSON files.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.regexp-match-indices" :
                return OptionDescriptor.newBuilder(JSContextOptions.REGEXP_MATCH_INDICES, "js.regexp-match-indices").deprecated(true).deprecationMessage("").help("Enable RegExp Match Indices property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.regexp-static-result" :
                return OptionDescriptor.newBuilder(JSContextOptions.REGEXP_STATIC_RESULT, "js.regexp-static-result").deprecated(false).help("Provide last RegExp match in RegExp global var, e.g. RegExp.$1.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.script-engine-global-scope-import" :
                return OptionDescriptor.newBuilder(JSContextOptions.SCRIPT_ENGINE_GLOBAL_SCOPE_IMPORT, "js.script-engine-global-scope-import").deprecated(true).deprecationMessage("").help("Enable ScriptEngine-specific global scope import function.").category(OptionCategory.INTERNAL).stability(OptionStability.STABLE).build();
            case "js.scripting" :
                return OptionDescriptor.newBuilder(JSContextOptions.SCRIPTING, "js.scripting").deprecated(false).help("Enable scripting features (Nashorn compatibility option).").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.shared-array-buffer" :
                return OptionDescriptor.newBuilder(JSContextOptions.SHARED_ARRAY_BUFFER, "js.shared-array-buffer").deprecated(false).help("Enable ES2017 SharedArrayBuffer.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.shebang" :
                return OptionDescriptor.newBuilder(JSContextOptions.SHEBANG, "js.shebang").deprecated(false).help("Allow parsing files starting with #!.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.shell" :
                return OptionDescriptor.newBuilder(JSContextOptions.SHELL, "js.shell").deprecated(false).help("Provide global functions for js shell.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.stack-trace-limit" :
                return OptionDescriptor.newBuilder(JSContextOptions.STACK_TRACE_LIMIT, "js.stack-trace-limit").deprecated(false).help("Number of stack frames to capture.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.strict" :
                return OptionDescriptor.newBuilder(JSContextOptions.STRICT, "js.strict").deprecated(false).help("Enforce strict mode.").category(OptionCategory.USER).stability(OptionStability.STABLE).build();
            case "js.string-length-limit" :
                return OptionDescriptor.newBuilder(JSContextOptions.STRING_LENGTH_LIMIT, "js.string-length-limit").deprecated(false).help("Maximum string length.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.syntax-extensions" :
                return OptionDescriptor.newBuilder(JSContextOptions.SYNTAX_EXTENSIONS, "js.syntax-extensions").deprecated(false).help("Enable Nashorn syntax extensions.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.test-clone-uninitialized" :
                return OptionDescriptor.newBuilder(JSContextOptions.TEST_CLONE_UNINITIALIZED, "js.test-clone-uninitialized").deprecated(false).help("Test uninitialized cloning.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.test262-mode" :
                return OptionDescriptor.newBuilder(JSContextOptions.TEST262_MODE, "js.test262-mode").deprecated(false).help("Expose global property $262 needed to run the Test262 harness.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.testV8-mode" :
                return OptionDescriptor.newBuilder(JSContextOptions.TESTV8_MODE, "js.testV8-mode").deprecated(false).help("Expose internals needed to run the TestV8 harness.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.timer-resolution" :
                return OptionDescriptor.newBuilder(JSContextOptions.TIMER_RESOLUTION, "js.timer-resolution").deprecated(false).help("Resolution of timers (performance.now() and Date built-ins) in nanoseconds. Fuzzy time is used when set to 0.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.timezone" :
                return OptionDescriptor.newBuilder(JSContextOptions.TIME_ZONE, "js.timezone").deprecated(false).help("Set custom time zone ID.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.top-level-await" :
                return OptionDescriptor.newBuilder(JSContextOptions.TOP_LEVEL_AWAIT, "js.top-level-await").deprecated(false).help("Enable top-level-await.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
            case "js.unhandled-rejections" :
                return OptionDescriptor.newBuilder(JSContextOptions.UNHANDLED_REJECTIONS, "js.unhandled-rejections").deprecated(false).help("Configure unhandled promise rejections tracking. Accepted values: 'none', unhandled rejections are not tracked. 'warn', a warning is printed to stderr when an unhandled rejection is detected. 'throw', an exception is thrown when an unhandled rejection is detected.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.use-utc-for-legacy-dates" :
                return OptionDescriptor.newBuilder(JSContextOptions.USE_UTC_FOR_LEGACY_DATES, "js.use-utc-for-legacy-dates").deprecated(false).help("Determines what time zone (UTC or local time zone) should be used when UTC offset is absent in a parsed date.").category(OptionCategory.EXPERT).stability(OptionStability.STABLE).build();
            case "js.v8-compat" :
                return OptionDescriptor.newBuilder(JSContextOptions.V8_COMPATIBILITY_MODE, "js.v8-compat").deprecated(false).help("Provide compatibility with the Google V8 engine.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.v8-legacy-const" :
                return OptionDescriptor.newBuilder(JSContextOptions.V8_LEGACY_CONST, "js.v8-legacy-const").deprecated(false).help("Emulate v8 behavior when trying to mutate const variables in non-strict mode.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.v8-realm-builtin" :
                return OptionDescriptor.newBuilder(JSContextOptions.V8_REALM_BUILTIN, "js.v8-realm-builtin").deprecated(false).help("Provide Realm builtin compatible with V8's d8 shell.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.validate-regexp-literals" :
                return OptionDescriptor.newBuilder(JSContextOptions.VALIDATE_REGEXP_LITERALS, "js.validate-regexp-literals").deprecated(false).help("Validate regexp literals at parse time.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build();
            case "js.wasm-bigint" :
                return OptionDescriptor.newBuilder(JSContextOptions.WASM_BIG_INT, "js.wasm-bigint").deprecated(false).help("Enable wasm i64 to javascript BigInt support").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build();
            case "js.webassembly" :
                return OptionDescriptor.newBuilder(JSContextOptions.WEBASSEMBLY, "js.webassembly").deprecated(false).help("Enable WebAssembly JavaScript API.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build();
        }
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        return Arrays.asList(
            OptionDescriptor.newBuilder(JSContextOptions.AGENT_CAN_BLOCK, "js.agent-can-block").deprecated(false).help("Determines whether agents can block or not.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.ANNEX_B, "js.annex-b").deprecated(false).help("Enable ECMAScript Annex B features.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.ASYNC_STACK_TRACES, "js.async-stack-traces").deprecated(false).help("Include async function frames in stack traces.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.ATOMICS, "js.atomics").deprecated(false).help("Enable ES2017 Atomics.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.AWAIT_OPTIMIZATION, "js.await-optimization").deprecated(false).help("Use PromiseResolve for Await.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.BIGINT, "js.bigint").deprecated(false).help("Provide an implementation of the BigInt proposal.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.BIND_MEMBER_FUNCTIONS, "js.bind-member-functions").deprecated(false).help("Bind functions returned by Value.getMember to the receiver object.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.CLASS_FIELDS, "js.class-fields").deprecated(false).help("Enable the class public and private fields proposal.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.COMMONJS_CORE_MODULES_REPLACEMENTS, "js.commonjs-core-modules-replacements").deprecated(false).help("Npm packages used to replace global Node.js builtins. Syntax: name1:module1,name2:module2,...").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.COMMONJS_REQUIRE_GLOBAL_PROPERTIES, "js.commonjs-global-properties").deprecated(false).help("Npm package used to populate Node.js global object.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.COMMONJS_REQUIRE, "js.commonjs-require").deprecated(false).help("Enable CommonJS require emulation.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.COMMONJS_REQUIRE_CWD, "js.commonjs-require-cwd").deprecated(false).help("CommonJS default current working directory.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.CONSOLE, "js.console").deprecated(false).help("Provide 'console' global property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.CONST_AS_VAR, "js.const-as-var").deprecated(false).help("Parse const declarations as a var (legacy compatibility option).").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.DEBUG_BUILTIN, "js.debug-builtin").deprecated(false).help("Provide a non-API Debug builtin. Behaviour will likely change. Don't depend on this in production code.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.DEBUG_PROPERTY_NAME, "js.debug-property-name").deprecated(false).help("The name used for the Graal.js debug builtin.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.DIRECT_BYTE_BUFFER, "js.direct-byte-buffer").deprecated(false).help("Use direct (off-heap) byte buffer for typed arrays.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.DISABLE_EVAL, "js.disable-eval").deprecated(false).help("User code is not allowed to parse code via e.g. eval().").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.DISABLE_WITH, "js.disable-with").deprecated(false).help("User code is not allowed to use the 'with' statement.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.ECMASCRIPT_VERSION, "js.ecmascript-version").deprecated(false).help("ECMAScript Version.").category(OptionCategory.USER).stability(OptionStability.STABLE).build(),
            OptionDescriptor.newBuilder(JSContextOptions.ERROR_CAUSE, "js.error-cause").deprecated(false).help("Enable the error cause proposal. Allows an error to be chained with a cause using the optional options parameter.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.ESM_EVAL_RETURNS_EXPORTS, "js.esm-eval-returns-exports").deprecated(false).help("Eval of an ES module through the polyglot API returns its exported symbols.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.EXPERIMENTAL_FOREIGN_OBJECT_PROTOTYPE, "js.experimental-foreign-object-prototype").deprecated(true).deprecationMessage("").help("Non-JS objects have prototype (Object/Function/Array.prototype) set; deprecated old name.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.FOREIGN_HASH_PROPERTIES, "js.foreign-hash-properties").deprecated(false).help("Allow getting/setting non-JS hash entries using the `[]` and `.` operators.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.FOREIGN_OBJECT_PROTOTYPE, "js.foreign-object-prototype").deprecated(false).help("Non-JS objects have prototype (Object/Function/Array.prototype) set.").category(OptionCategory.EXPERT).stability(OptionStability.STABLE).build(),
            OptionDescriptor.newBuilder(JSContextOptions.FUNCTION_ARGUMENTS_LIMIT, "js.function-arguments-limit").deprecated(false).help("Maximum number of arguments for functions.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.FUNCTION_CACHE_LIMIT, "js.function-cache-limit").deprecated(false).help("Maximum allowed size of a function cache.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.FUNCTION_CONSTRUCTOR_CACHE_SIZE, "js.function-constructor-cache-size").deprecated(false).help("Maximum size of the parsing cache used by the Function constructor to avoid re-parsing known sources.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.FUNCTION_STATEMENT_ERROR, "js.function-statement-error").deprecated(false).help("Treat hoistable function statements in blocks as an error (in ES5 mode).").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.GLOBAL_ARGUMENTS, "js.global-arguments").deprecated(false).help("Provide 'arguments' global property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.GLOBAL_PROPERTY, "js.global-property").deprecated(false).help("Provide 'global' global property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.GRAAL_BUILTIN, "js.graal-builtin").deprecated(false).help("Provide 'Graal' global property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.IMPORT_ASSERTIONS, "js.import-assertions").deprecated(false).help("Enable import assertions").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.INTEROP_COMPLETE_PROMISES, "js.interop-complete-promises").deprecated(false).help("Resolve promises when crossing a polyglot language boundary.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.INTL_402, "js.intl-402").deprecated(false).help("Enable ECMAScript Internationalization API.").category(OptionCategory.USER).stability(OptionStability.STABLE).build(),
            OptionDescriptor.newBuilder(JSContextOptions.JAVA_PACKAGE_GLOBALS, "js.java-package-globals").deprecated(false).help("Provide Java package globals: Packages, java, javafx, javax, com, org, edu.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.JSON_MODULES, "js.json-modules").deprecated(false).help("Enable loading of json modules").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.LAZY_TRANSLATION, "js.lazy-translation").deprecated(false).help("Translate function bodies lazily.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.LOAD, "js.load").deprecated(false).help("Provide 'load' global function.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.LOAD_FROM_CLASSPATH, "js.load-from-classpath").deprecated(false).help("Allow 'load' to access 'classpath:' URLs. Do not use with untrusted code.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.LOAD_FROM_URL, "js.load-from-url").deprecated(false).help("Allow 'load' to access URLs. Do not use with untrusted code.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.LOCALE, "js.locale").deprecated(false).help("Use a specific default locale for locale-sensitive operations.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.MAX_APPLY_ARGUMENT_LENGTH, "js.max-apply-argument-length").deprecated(false).help("Maximum allowed number of arguments allowed in an apply function.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.MAX_PROTOTYPE_CHAIN_LENGTH, "js.max-prototype-chain-length").deprecated(false).help("Maximum allowed length of a prototype chain.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.MAX_TYPED_ARRAY_LENGTH, "js.max-typed-array-length").deprecated(false).help("Maximum allowed length for TypedArrays.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.MLE_MODE, "js.mle-mode").deprecated(false).help("Provide a non-API MLE builtin. Behaviour will likely change. Don't depend on this in production code.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.NASHORN_COMPATIBILITY_MODE, "js.nashorn-compat").deprecated(false).help("Provide compatibility with the OpenJDK Nashorn engine. Do not use with untrusted code.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.NEW_SET_METHODS, "js.new-set-methods").deprecated(false).help("Enable new Set methods.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.OPERATOR_OVERLOADING, "js.operator-overloading").deprecated(false).help("Enable operator overloading").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.PARSE_ONLY, "js.parse-only").deprecated(false).help("Only parse source code, do not run it.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.PERFORMANCE, "js.performance").deprecated(false).help("Provide 'performance' global property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.POLYGLOT_BUILTIN, "js.polyglot-builtin").deprecated(true).deprecationMessage("").help("Provide 'Polyglot' global property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.POLYGLOT_EVALFILE, "js.polyglot-evalfile").deprecated(false).help("Provide 'Polyglot.evalFile' function.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.PRINT, "js.print").deprecated(false).help("Provide 'print' global function.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.PRIVATE_FIELDS_IN, "js.private-fields-in").deprecated(false).help("Enable private field in in operator").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.PROFILE_TIME, "js.profile-time").deprecated(false).help("Enable time profiling.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.PROFILE_TIME_PRINT_CUMULATIVE, "js.profile-time-print-cumulative").deprecated(false).help("Print cumulative time when time profiling is enabled.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.PROPERTY_CACHE_LIMIT, "js.property-cache-limit").deprecated(false).help("Maximum allowed size of a property cache.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.REGEX_REGRESSION_TEST_MODE, "js.regex-regression-test-mode").deprecated(false).help("Test mode for TRegex.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.REGEX_ALWAYS_EAGER, "js.regex.always-eager").deprecated(false).help("Always match capture groups eagerly.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.REGEX_DUMP_AUTOMATA, "js.regex.dump-automata").deprecated(false).help("Produce ASTs and automata in JSON, DOT (GraphViz) and LaTeX formats.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.REGEX_STEP_EXECUTION, "js.regex.step-execution").deprecated(false).help("Trace the execution of automata in JSON files.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.REGEXP_MATCH_INDICES, "js.regexp-match-indices").deprecated(true).deprecationMessage("").help("Enable RegExp Match Indices property.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.REGEXP_STATIC_RESULT, "js.regexp-static-result").deprecated(false).help("Provide last RegExp match in RegExp global var, e.g. RegExp.$1.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.SCRIPT_ENGINE_GLOBAL_SCOPE_IMPORT, "js.script-engine-global-scope-import").deprecated(true).deprecationMessage("").help("Enable ScriptEngine-specific global scope import function.").category(OptionCategory.INTERNAL).stability(OptionStability.STABLE).build(),
            OptionDescriptor.newBuilder(JSContextOptions.SCRIPTING, "js.scripting").deprecated(false).help("Enable scripting features (Nashorn compatibility option).").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.SHARED_ARRAY_BUFFER, "js.shared-array-buffer").deprecated(false).help("Enable ES2017 SharedArrayBuffer.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.SHEBANG, "js.shebang").deprecated(false).help("Allow parsing files starting with #!.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.SHELL, "js.shell").deprecated(false).help("Provide global functions for js shell.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.STACK_TRACE_LIMIT, "js.stack-trace-limit").deprecated(false).help("Number of stack frames to capture.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.STRICT, "js.strict").deprecated(false).help("Enforce strict mode.").category(OptionCategory.USER).stability(OptionStability.STABLE).build(),
            OptionDescriptor.newBuilder(JSContextOptions.STRING_LENGTH_LIMIT, "js.string-length-limit").deprecated(false).help("Maximum string length.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.SYNTAX_EXTENSIONS, "js.syntax-extensions").deprecated(false).help("Enable Nashorn syntax extensions.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.TEST_CLONE_UNINITIALIZED, "js.test-clone-uninitialized").deprecated(false).help("Test uninitialized cloning.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.TEST262_MODE, "js.test262-mode").deprecated(false).help("Expose global property $262 needed to run the Test262 harness.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.TESTV8_MODE, "js.testV8-mode").deprecated(false).help("Expose internals needed to run the TestV8 harness.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.TIMER_RESOLUTION, "js.timer-resolution").deprecated(false).help("Resolution of timers (performance.now() and Date built-ins) in nanoseconds. Fuzzy time is used when set to 0.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.TIME_ZONE, "js.timezone").deprecated(false).help("Set custom time zone ID.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.TOP_LEVEL_AWAIT, "js.top-level-await").deprecated(false).help("Enable top-level-await.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.UNHANDLED_REJECTIONS, "js.unhandled-rejections").deprecated(false).help("Configure unhandled promise rejections tracking. Accepted values: 'none', unhandled rejections are not tracked. 'warn', a warning is printed to stderr when an unhandled rejection is detected. 'throw', an exception is thrown when an unhandled rejection is detected.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.USE_UTC_FOR_LEGACY_DATES, "js.use-utc-for-legacy-dates").deprecated(false).help("Determines what time zone (UTC or local time zone) should be used when UTC offset is absent in a parsed date.").category(OptionCategory.EXPERT).stability(OptionStability.STABLE).build(),
            OptionDescriptor.newBuilder(JSContextOptions.V8_COMPATIBILITY_MODE, "js.v8-compat").deprecated(false).help("Provide compatibility with the Google V8 engine.").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.V8_LEGACY_CONST, "js.v8-legacy-const").deprecated(false).help("Emulate v8 behavior when trying to mutate const variables in non-strict mode.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.V8_REALM_BUILTIN, "js.v8-realm-builtin").deprecated(false).help("Provide Realm builtin compatible with V8's d8 shell.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.VALIDATE_REGEXP_LITERALS, "js.validate-regexp-literals").deprecated(false).help("Validate regexp literals at parse time.").category(OptionCategory.INTERNAL).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.WASM_BIG_INT, "js.wasm-bigint").deprecated(false).help("Enable wasm i64 to javascript BigInt support").category(OptionCategory.USER).stability(OptionStability.EXPERIMENTAL).build(),
            OptionDescriptor.newBuilder(JSContextOptions.WEBASSEMBLY, "js.webassembly").deprecated(false).help("Enable WebAssembly JavaScript API.").category(OptionCategory.EXPERT).stability(OptionStability.EXPERIMENTAL).build())
        .iterator();
    }

}
