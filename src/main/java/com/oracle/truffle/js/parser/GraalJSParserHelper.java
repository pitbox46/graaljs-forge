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
package com.oracle.truffle.js.parser;

import java.io.PrintWriter;
import java.util.function.Function;

import com.oracle.js.parser.ErrorManager;
import com.oracle.js.parser.Lexer.LexerToken;
import com.oracle.js.parser.Lexer.RegexToken;
import com.oracle.js.parser.Parser;
import com.oracle.js.parser.ParserException;
import com.oracle.js.parser.ScriptEnvironment;
import com.oracle.js.parser.ScriptEnvironment.FunctionStatementBehavior;
import com.oracle.js.parser.Token;
import com.oracle.js.parser.TokenType;
import com.oracle.js.parser.ir.Expression;
import com.oracle.js.parser.ir.FunctionNode;
import com.oracle.js.parser.ir.Scope;
import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.js.parser.internal.ir.debug.JSONWriter;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSException;
import com.oracle.truffle.js.runtime.JSParserOptions;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.RegexCompilerInterface;

public final class GraalJSParserHelper {

    private static final String NEVER_PART_OF_COMPILATION_MESSAGE = "do not parse from compiled code";

    private GraalJSParserHelper() {
        // should not be constructed
    }

    public static FunctionNode parseScript(JSContext context, com.oracle.truffle.api.source.Source truffleSource, JSParserOptions parserOptions) {
        return parseScript(context, truffleSource, parserOptions, false, false, null, "", "");
    }

    public static FunctionNode parseScript(JSContext context, com.oracle.truffle.api.source.Source truffleSource, JSParserOptions parserOptions, boolean eval, boolean evalInFunction,
                    Scope evalScope, String prologue, String epilogue) {
        return parseSource(context, truffleSource, parserOptions, false, eval, evalInFunction, evalScope, prologue, epilogue, null);
    }

    public static FunctionNode parseScript(JSContext context, com.oracle.truffle.api.source.Source truffleSource, JSParserOptions parserOptions, boolean eval, boolean evalInFunction,
                    Scope evalScope, String prologue, String epilogue, String[] argumentNames) {
        return parseSource(context, truffleSource, parserOptions, false, eval, evalInFunction, evalScope, prologue, epilogue, argumentNames);
    }

    public static FunctionNode parseModule(JSContext context, com.oracle.truffle.api.source.Source truffleSource, JSParserOptions parserOptions) {
        return parseSource(context, truffleSource, parserOptions, true, false, false, null, "", "", null);
    }

    private static FunctionNode parseSource(JSContext context, com.oracle.truffle.api.source.Source truffleSource, JSParserOptions parserOptions,
                    boolean parseModule, boolean eval, boolean evalInFunction, Scope evalScope, String prologue, String epilogue, String[] argumentNames) {
        CompilerAsserts.neverPartOfCompilation(NEVER_PART_OF_COMPILATION_MESSAGE);
        CharSequence code;
        if (prologue.isEmpty() && epilogue.isEmpty()) {
            code = truffleSource.getCharacters();
        } else {
            StringBuilder all = new StringBuilder();
            all.append(prologue);
            all.append(truffleSource.getCharacters());
            all.append(epilogue);
            code = all;
        }
        com.oracle.js.parser.Source source = com.oracle.js.parser.Source.sourceFor(truffleSource.getName(), code, eval);

        ScriptEnvironment env = makeScriptEnvironment(parserOptions);
        ErrorManager errors;
        if (eval) {
            errors = new ErrorManager.ThrowErrorManager();
        } else {
            errors = new ErrorManager.StringBuilderErrorManager();
        }
        errors.setLimit(0);

        Parser parser = createParser(context, env, source, errors, parserOptions);

        FunctionNode parsed;
        if (parseModule) {
            parsed = parser.parseModule(":module");
        } else if (eval) {
            parsed = parser.parseEval(evalInFunction, evalScope);
        } else if (argumentNames != null) {
            parsed = parser.parseWithArguments(argumentNames);
        } else {
            parsed = parser.parse();
        }

        if (errors.hasErrors()) {
            throwErrors(truffleSource, errors);
        }
        return parsed;
    }

    public static Expression parseExpression(JSContext context, com.oracle.truffle.api.source.Source truffleSource, JSParserOptions parserOptions) {
        CompilerAsserts.neverPartOfCompilation(NEVER_PART_OF_COMPILATION_MESSAGE);
        CharSequence code = truffleSource.getCharacters();
        com.oracle.js.parser.Source source = com.oracle.js.parser.Source.sourceFor(truffleSource.getName(), code, true);

        ScriptEnvironment env = makeScriptEnvironment(parserOptions);
        ErrorManager errors = new ErrorManager.ThrowErrorManager();
        errors.setLimit(0);

        Parser parser = createParser(context, env, source, errors, parserOptions);
        Expression expression = parser.parseExpression();
        if (errors.hasErrors()) {
            throwErrors(truffleSource, errors);
        }

        return expression;
    }

    private static Parser createParser(JSContext context, ScriptEnvironment env, com.oracle.js.parser.Source source, ErrorManager errors, JSParserOptions parserOptions) {
        return new Parser(env, source, errors) {
            @Override
            protected void validateLexerToken(LexerToken lexerToken) {
                if (lexerToken instanceof RegexToken) {
                    final RegexToken regex = (RegexToken) lexerToken;
                    // validate regular expression
                    if (context.getContextOptions().isValidateRegExpLiterals()) {
                        try {
                            RegexCompilerInterface.validate(context, regex.getExpression(), regex.getOptions(), parserOptions.getEcmaScriptVersion());
                        } catch (JSException e) {
                            throw error(e.getRawMessage());
                        }
                    }
                }
            }

            @Override
            protected Function<Number, String> getNumberToStringConverter() {
                return JSRuntime::numberToString;
            }
        };
    }

    private static ScriptEnvironment makeScriptEnvironment(JSParserOptions parserOptions) {
        ScriptEnvironment.Builder builder = ScriptEnvironment.builder();
        builder.strict(parserOptions.isStrict());
        builder.ecmaScriptVersion(parserOptions.getEcmaScriptVersion());
        builder.emptyStatements(parserOptions.isEmptyStatements());
        builder.syntaxExtensions(parserOptions.isSyntaxExtensions());
        builder.scripting(parserOptions.isScripting());
        builder.shebang(parserOptions.isShebang());
        builder.constAsVar(parserOptions.isConstAsVar());
        builder.allowBigInt(parserOptions.isAllowBigInt());
        builder.annexB(parserOptions.isAnnexB());
        builder.classFields(parserOptions.isClassFields());
        builder.importAssertions(parserOptions.isImportAssertions());
        builder.privateFieldsIn(parserOptions.isPrivateFieldsIn());
        if (parserOptions.isFunctionStatementError()) {
            builder.functionStatementBehavior(FunctionStatementBehavior.ERROR);
        } else {
            builder.functionStatementBehavior(FunctionStatementBehavior.ACCEPT);
        }
        if (parserOptions.isDumpOnError()) {
            builder.dumpOnError(new PrintWriter(System.err, true));
        }
        return builder.build();
    }

    public static void checkFunctionSyntax(JSContext context, JSParserOptions parserOptions, String parameterList, String body, boolean generator, boolean async, String sourceName) {
        CompilerAsserts.neverPartOfCompilation(NEVER_PART_OF_COMPILATION_MESSAGE);
        ScriptEnvironment env = makeScriptEnvironment(parserOptions);
        ErrorManager errors = new com.oracle.js.parser.ErrorManager.ThrowErrorManager();
        Parser parser = createParser(context, env, com.oracle.js.parser.Source.sourceFor(sourceName, parameterList), errors, parserOptions);
        parser.parseFormalParameterList();
        parser = createParser(context, env, com.oracle.js.parser.Source.sourceFor(sourceName, body), errors, parserOptions);
        parser.parseFunctionBody(generator, async);
    }

    private static void throwErrors(com.oracle.truffle.api.source.Source source, ErrorManager errors) {
        ParserException parserException = errors.getParserException();
        SourceSection sourceLocation = null;
        boolean isIncompleteSource = false;
        if (parserException != null) {
            isIncompleteSource = parserException.isIncompleteSource();
            if (parserException.getPosition() >= 0) {
                // For EOL tokens, length is the line number
                int length = Token.descType(parserException.getToken()) == TokenType.EOL ? 0 : Token.descLength(parserException.getToken());
                sourceLocation = source.createSection(parserException.getPosition(), length);
            }
            if (parserException.getErrorType() == com.oracle.js.parser.JSErrorType.ReferenceError) {
                throw Errors.createReferenceError(parserException.getMessage(), sourceLocation);
            } else {
                assert parserException.getErrorType() == com.oracle.js.parser.JSErrorType.SyntaxError;
            }
        }
        throw Errors.createSyntaxError(((ErrorManager.StringBuilderErrorManager) errors).getOutput(), sourceLocation, isIncompleteSource);
    }

    public static String parseToJSON(String code, String name, boolean includeLoc, JSParserOptions parserOptions) {
        CompilerAsserts.neverPartOfCompilation(NEVER_PART_OF_COMPILATION_MESSAGE);
        ScriptEnvironment env = makeScriptEnvironment(parserOptions);
        try {
            return JSONWriter.parse(env, code, name, includeLoc);
        } catch (ParserException e) {
            throw Errors.createSyntaxError(e.getMessage());
        }
    }
}
