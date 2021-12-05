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
package com.oracle.truffle.js.runtime.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IllformedLocaleException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeMap;
import java.time.ZoneId;

import com.ibm.icu.text.CaseMap;
import com.ibm.icu.text.CaseMap.Lower;
import com.ibm.icu.text.CaseMap.Upper;
import com.ibm.icu.text.NumberingSystem;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.runtime.Errors;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRealm;
import com.oracle.truffle.js.runtime.builtins.JSOrdinary;
import com.oracle.truffle.js.runtime.objects.JSObject;

/**
 *
 * ECMA 402 Utilities.
 */
public final class IntlUtil {

    private IntlUtil() {
        // should not be constructed
    }

    public static final String _2_DIGIT = "2-digit";
    public static final String ACCENT = "accent";
    public static final String ACCOUNTING = "accounting";
    public static final String ALWAYS = "always";
    public static final String AUTO = "auto";
    public static final String BEST_FIT = "best fit";
    public static final String BASE = "base";
    public static final String BASE_NAME = "baseName";
    public static final String BASIC = "basic";
    public static final String BREAK_TYPE = "breakType";
    public static final String CALENDAR = "calendar";
    public static final String CARDINAL = "cardinal";
    public static final String CASE = "case";
    public static final String CASE_FIRST = "caseFirst";
    public static final String CODE = "code";
    public static final String COLLATION = "collation";
    public static final String COMPACT = "compact";
    public static final String COMPACT_DISPLAY = "compactDisplay";
    public static final String CONJUNCTION = "conjunction";
    public static final String CURRENCY = "currency";
    public static final String CURRENCY_DISPLAY = "currencyDisplay";
    public static final String CURRENCY_SIGN = "currencySign";
    public static final String DATE_STYLE = "dateStyle";
    public static final String DAY = "day";
    public static final String DAY_PERIOD = "dayPeriod";
    public static final String DEFAULT = "default";
    public static final String DECIMAL = "decimal";
    public static final String DISJUNCTION = "disjunction";
    public static final String ELEMENT = "element";
    public static final String ENGINEERING = "engineering";
    public static final String ERA = "era";
    public static final String EXCEPT_ZERO = "exceptZero";
    public static final String FALLBACK = "fallback";
    public static final String FALSE = "false";
    public static final String FORMAT_MATCHER = "formatMatcher";
    public static final String FRACTIONAL_SECOND_DIGITS = "fractionalSecondDigits";
    public static final String FULL = "full";
    public static final String GRANULARITY = "granularity";
    public static final String GRAPHEME = "grapheme";
    public static final String H11 = "h11";
    public static final String H12 = "h12";
    public static final String H23 = "h23";
    public static final String H24 = "h24";
    public static final String HOUR = "hour";
    public static final String HOUR_CYCLE = "hourCycle";
    public static final String HOUR12 = "hour12";
    public static final String INDEX = "index";
    public static final String INPUT = "input";
    public static final String IS_WORD_LIKE = "isWordLike";
    public static final String IGNORE_PUNCTUATION = "ignorePunctuation";
    public static final String LANGUAGE = "language";
    public static final String LITERAL = "literal";
    public static final String LOCALE = "locale";
    public static final String LOCALE_MATCHER = "localeMatcher";
    public static final String LONG = "long";
    public static final String LOOKUP = "lookup";
    public static final String LOOSE = "loose";
    public static final String LOWER = "lower";
    public static final String MAXIMUM_FRACTION_DIGITS = "maximumFractionDigits";
    public static final String MAXIMUM_SIGNIFICANT_DIGITS = "maximumSignificantDigits";
    public static final String MEDIUM = "medium";
    public static final String MINIMUM_FRACTION_DIGITS = "minimumFractionDigits";
    public static final String MINIMUM_INTEGER_DIGITS = "minimumIntegerDigits";
    public static final String MINIMUM_SIGNIFICANT_DIGITS = "minimumSignificantDigits";
    public static final String MINUTE = "minute";
    public static final String MONTH = "month";
    public static final String NAME = "name";
    public static final String NARROW = "narrow";
    public static final String NARROW_SYMBOL = "narrowSymbol";
    public static final String NEVER = "never";
    public static final String NONE = "none";
    public static final String NORMAL = "normal";
    public static final String NOTATION = "notation";
    public static final String NUMERIC = "numeric";
    public static final String NUMBERING_SYSTEM = "numberingSystem";
    public static final String OR = "or";
    public static final String OR_NARROW = "or-narrow";
    public static final String OR_SHORT = "or-short";
    public static final String ORDINAL = "ordinal";
    public static final String PERCENT = "percent";
    public static final String REGION = "region";
    public static final String SCIENTIFIC = "scientific";
    public static final String SCRIPT = "script";
    public static final String SEARCH = "search";
    public static final String SEP = "sep";
    public static final String SECOND = "second";
    public static final String SEGMENT = "segment";
    public static final String SENTENCE = "sentence";
    public static final String SENSITIVITY = "sensitivity";
    public static final String SHORT = "short";
    public static final String SIGN_DISPLAY = "signDisplay";
    public static final String SORT = "sort";
    public static final String STANDARD = "standard";
    public static final String STANDARD_NARROW = "standard-narrow";
    public static final String STANDARD_SHORT = "standard-short";
    public static final String STRICT = "strict";
    public static final String STYLE = "style";
    public static final String SYMBOL = "symbol";
    public static final String TERM = "term";
    public static final String TIME_STYLE = "timeStyle";
    public static final String TIME_ZONE = "timeZone";
    public static final String TIME_ZONE_NAME = "timeZoneName";
    public static final String TYPE = "type";
    public static final String UND = "und";
    public static final String UNIT = "unit";
    public static final String UNIT_DISPLAY = "unitDisplay";
    public static final String UNIT_NARROW = "unit-narrow";
    public static final String UNIT_SHORT = "unit-short";
    public static final String UPPER = "upper";
    public static final String USAGE = "usage";
    public static final String USE_GROUPING = "useGrouping";
    public static final String VALUE = "value";
    public static final String VARIANT = "variant";
    public static final String WORD = "word";
    public static final String WEEKDAY = "weekday";
    public static final String YEAR = "year";
    public static final String YEAR_NAME = "yearName";

    // https://tc39.es/ecma402/#table-sanctioned-simple-unit-identifiers
    private static final Set<String> SANCTIONED_SIMPLE_UNIT_IDENTIFIERS = new HashSet<>(Arrays.asList(new String[]{
                    "acre",
                    "bit",
                    "byte",
                    "celsius",
                    "centimeter",
                    "day",
                    "degree",
                    "fahrenheit",
                    "fluid-ounce",
                    "foot",
                    "gallon",
                    "gigabit",
                    "gigabyte",
                    "gram",
                    "hectare",
                    "hour",
                    "inch",
                    "kilobit",
                    "kilobyte",
                    "kilogram",
                    "kilometer",
                    "liter",
                    "megabit",
                    "megabyte",
                    "meter",
                    "mile",
                    "mile-scandinavian",
                    "milliliter",
                    "millimeter",
                    "millisecond",
                    "minute",
                    "month",
                    "ounce",
                    "percent",
                    "petabyte",
                    "pound",
                    "second",
                    "stone",
                    "terabit",
                    "terabyte",
                    "week",
                    "yard",
                    "year"
    }));

    public static Locale selectedLocale(JSContext ctx, String[] locales) {
        // We don't distinguish BestFitMatcher and LookupMatcher i.e.
        // the implementation dependent BestFitMatcher is implemented as LookupMatcher
        return lookupMatcher(ctx, locales);
    }

    public static Locale bestAvailableLocale(JSContext context, Locale locale) {
        Locale candidate = locale;
        while (true) {
            if (isAvailableLocale(context, candidate)) {
                return candidate;
            }
            String candidateLanguageTag = candidate.toLanguageTag();
            int pos = candidateLanguageTag.lastIndexOf('-');
            if (pos == -1) {
                return null;
            } else {
                if (pos >= 2 && candidateLanguageTag.charAt(pos - 2) == '-') {
                    pos -= 2;
                }
                candidateLanguageTag = candidateLanguageTag.substring(0, pos);
                candidate = Locale.forLanguageTag(candidateLanguageTag);
            }
        }
    }

    @TruffleBoundary
    public static Locale lookupMatcher(JSContext ctx, String[] requestedLocales) {
        for (String locale : requestedLocales) {
            Locale requestedLocale = Locale.forLanguageTag(locale);
            Locale noExtensionsLocale = requestedLocale.stripExtensions();
            Locale availableLocale = bestAvailableLocale(ctx, noExtensionsLocale);
            if (availableLocale != null) {
                String unicodeExtension = requestedLocale.getExtension('u');
                if (unicodeExtension != null) {
                    availableLocale = new Locale.Builder().setLocale(availableLocale).setExtension('u', unicodeExtension).build();
                }
                return availableLocale;
            }
        }
        return ctx.getLocale();
    }

    @TruffleBoundary
    public static List<Object> supportedLocales(JSContext ctx, String[] requestedLocales, @SuppressWarnings("unused") String matcher) {
        List<Object> result = new ArrayList<>();
        for (String locale : requestedLocales) {
            Locale noExtensionsLocale = Locale.forLanguageTag(locale).stripExtensions();
            Locale availableLocale = bestAvailableLocale(ctx, noExtensionsLocale);
            if (availableLocale != null) {
                result.add(locale);
            }
        }
        return result;
    }

    private static boolean isAvailableLocale(JSContext ctx, Locale locale) {
        // default locale might be missing in the available locale list
        return getAvailableLocales().contains(locale) || ctx.getLocale().equals(locale);
    }

    private static final LazyValue<Set<Locale>> AVAILABLE_LOCALES = new LazyValue<>(IntlUtil::initAvailableLocales);

    private static Set<Locale> getAvailableLocales() {
        return AVAILABLE_LOCALES.get();
    }

    private static Set<Locale> initAvailableLocales() {
        Set<Locale> result = new HashSet<>();

        try {
            for (ULocale ul : ULocale.getAvailableLocales()) {
                result.add(ul.toLocale());
                if (!ul.getScript().isEmpty()) {
                    // Add also a version without the script subtag
                    result.add(new Locale(ul.getLanguage(), ul.getCountry()));
                }
            }
        } catch (MissingResourceException e) {
            throw Errors.createICU4JDataError(e);
        }

        return result;
    }

    public static boolean isValidNumberingSystem(String numberingSystem) {
        return Arrays.asList(NumberingSystem.getAvailableNames()).contains(numberingSystem);
    }

    public static String defaultNumberingSystemName(JSContext context, Locale locale) {
        if (context.isOptionV8CompatibilityMode() && "ar".equals(locale.toLanguageTag())) {
            // https://chromium.googlesource.com/chromium/deps/icu/+/6cca29a092eef02178e13b7461fe8fbf3021d04b
            // V8 is using a patched version of ICU (where the default numbering system for "ar"
            // locale is "latn")
            return "latn";
        }
        return NumberingSystem.getInstance(locale).getName();
    }

    public static void validateUnicodeLocaleIdentifierType(String type, BranchProfile errorBranch) {
        if (!UTS35Validator.isStructurallyValidType(type)) {
            errorBranch.enter();
            throw Errors.createRangeErrorFormat("Invalid option: %s", null, type);
        }
    }

    @TruffleBoundary
    public static String normalizeUnicodeLocaleIdentifierType(String type) {
        return type.toLowerCase();
    }

    @TruffleBoundary
    public static Locale withoutUnicodeExtension(Locale originalLocale, String key) {
        if (!originalLocale.getUnicodeLocaleKeys().contains(key)) {
            return originalLocale;
        } else {
            String value = originalLocale.getUnicodeLocaleType(key);
            String originalTag = originalLocale.toLanguageTag();
            String toRemove = "-u-" + key + "-" + value;
            String strippedTag = originalTag.replace(toRemove, "");
            return new Locale(strippedTag);
        }
    }

    public static boolean isWellFormedCurrencyCode(String currency) {
        return currency.length() == 3 && UTS35Validator.isAlpha(currency.charAt(0)) && UTS35Validator.isAlpha(currency.charAt(1)) && UTS35Validator.isAlpha(currency.charAt(2));
    }

    public static void ensureIsWellFormedCurrencyCode(String currency) {
        if (!isWellFormedCurrencyCode(currency)) {
            throw Errors.createRangeErrorCurrencyNotWellFormed(currency);
        }
    }

    public static void ensureIsStructurallyValidLanguageSubtag(String region) {
        if (!UTS35Validator.isStructurallyValidLanguageSubtag(region)) {
            throw Errors.createRangeErrorInvalidLanguage(region);
        }
    }

    public static void ensureIsStructurallyValidRegionSubtag(String region) {
        if (!UTS35Validator.isStructurallyValidRegionSubtag(region)) {
            throw Errors.createRangeErrorInvalidRegion(region);
        }
    }

    public static void ensureIsStructurallyValidScriptSubtag(String script) {
        if (!UTS35Validator.isStructurallyValidScriptSubtag(script)) {
            throw Errors.createRangeErrorInvalidScript(script);
        }
    }

    @TruffleBoundary
    public static void ensureIsStructurallyValidLanguageTag(String languageTag) {
        try {
            new Locale.Builder().setLanguageTag(languageTag).build();
        } catch (IllformedLocaleException e) {
            throw Errors.createRangeError(e.getMessage());
        }
    }

    // Placeholders used to work around incorrect modifications of local extensions
    // performed by ULocale.Builder
    private static final String YES_PLACEHOLDER = "yes31415";
    private static final String TRUE_PLACEHOLDER = "true2718";

    @TruffleBoundary
    // https://tc39.github.io/ecma402/#sec-canonicalizelanguagetag
    public static String validateAndCanonicalizeLanguageTag(String languageTag) {
        try {
            // We cannot use (U)Locale class to check whether the tag is well-formed.
            // Locale class allows wider range of tags (irregular grandfathered tags,
            // extlang subtags, private use only tags etc.)
            if (!UTS35Validator.isWellFormedUnicodeBCP47LocaleIdentifier(languageTag)) {
                throw Errors.createRangeErrorFormat("Language tag is not well-formed: %s", null, languageTag);
            }

            ULocale locale = ULocale.createCanonical(ULocale.getName(languageTag));
            ULocale.Builder builder = new ULocale.Builder().setLocale(locale);

            String variant = locale.getVariant();
            if (variant.indexOf('_') != -1 || variant.indexOf('-') != -1) {
                String[] variants = variant.split("[_-]");
                if (new HashSet<>(Arrays.asList(variants)).size() != variants.length) {
                    throw Errors.createRangeErrorFormat("Language tag with duplicate variants: %s", null, languageTag);
                }
                // Canonicalization is supposed to sort variants but (U)Locale fails to do so.
                Arrays.sort(variants);
                StringBuilder sb = new StringBuilder(variants[0]);
                for (int i = 1; i < variants.length; i++) {
                    sb.append('-').append(variants[i]);
                }
                builder.setVariant(sb.toString());
            }

            Set<Character> extensions = locale.getExtensionKeys();
            if (!extensions.isEmpty()) {
                // Singletons are case-insensitive.
                String tag = languageTag.toLowerCase();
                int privateExtIdx = extensions.contains('x') ? tag.indexOf("-x-") : tag.length();
                for (Character ext : extensions) {
                    if (ext != 'x') {
                        String extDelimiter = "-" + ext + "-";
                        int idx = tag.indexOf(extDelimiter);
                        int idx2 = tag.indexOf(extDelimiter, idx + 1);
                        if (idx2 != -1 && idx2 < privateExtIdx) {
                            throw Errors.createRangeErrorFormat("Language tag with duplicate singletons: %s", null, languageTag);
                        }
                    }
                }

                Locale loc = new Locale.Builder().setLanguageTag(languageTag).build();
                for (String key : loc.getUnicodeLocaleKeys()) {
                    String type = loc.getUnicodeLocaleType(key);
                    if ("yes".equals(type)) {
                        if (!("kb".equals(key) || "kc".equals(key) || "kh".equals(key) || "kk".equals(key) || "kn".equals(key))) {
                            type = YES_PLACEHOLDER;
                        }
                    }
                    if ("rg".equals(key) || "sd".equals(key)) {
                        type = normalizeRGType(type);
                    }
                    builder.setUnicodeLocaleKeyword(key, type);
                }

                // Validate and canonicalize the transformed extension.
                // We cannot start with locale.getExtension('t') here. locale is
                // canonicalized and ICU started (ICU-21406) to remove duplicate
                // variants during canonicalization. Unfortunately, we have
                // to detect the duplicates because ECMAScript specification
                // refuses such locales as invalid explicitly =>
                // we start with a non-canonicalized locale here.
                String transformedExt = new ULocale(languageTag).getExtension('t');
                if (transformedExt != null) {
                    builder.setExtension('t', normalizeTransformedExtension(transformedExt));
                }
            }
            String result = maybeAppendMissingLanguageSubTag(builder.build().toLanguageTag());
            return result.replaceAll("-" + YES_PLACEHOLDER, "-yes").replaceAll("-" + TRUE_PLACEHOLDER, "-true");
        } catch (IllformedLocaleException e) {
            throw Errors.createRangeError(e.getMessage());
        }
    }

    public static String normalizeCAType(String type) {
        // (Preferred) aliases from
        // https://github.com/unicode-org/cldr/blob/master/common/bcp47/calendar.xml
        if ("gregorian".equals(type)) {
            return "gregory";
        } else if ("ethiopic-amete-alem".equals(type)) {
            return "ethioaa";
        } else if ("islamicc".equals(type)) {
            return "islamic-civil";
        }
        return type;
    }

    private static String normalizeRGType(String type) {
        if ("cn11".equals(type)) {
            return "cnbj";
        } else if ("cz10a".equals(type)) {
            return "cz110";
        } else if ("fra".equals(type) || "frg".equals(type)) {
            return "frges";
        } else if ("lud".equals(type)) {
            return "lucl";
        } else if ("no23".equals(type)) {
            return "no50";
        }
        return type;
    }

    private static String normalizeTransformedExtension(String extension) {
        // Parse transformed extension
        String tlang = null;
        Map<String, String> fields = new TreeMap<>();
        boolean seenDash = true;
        String lastKey = null;
        int lastValueStart = -1;
        for (int i = 0; i < extension.length() - 1; i++) {
            if (seenDash && UTS35Validator.isAlpha(extension.charAt(i)) && UTS35Validator.isDigit(extension.charAt(i + 1)) && (i + 2 == extension.length() || extension.charAt(i + 2) == '-')) {
                if (lastKey == null) {
                    tlang = extension.substring(0, Math.max(0, i - 1));
                } else {
                    fields.put(lastKey, extension.substring(lastValueStart, i - 1));
                }
                lastKey = extension.substring(i, i + 2);
                lastValueStart = i + 3;
            }
            seenDash = (extension.charAt(i) == '-');
        }
        if (tlang == null) {
            tlang = extension;
        }
        if (lastKey != null) {
            fields.put(lastKey, extension.substring(lastValueStart));
        }

        StringBuilder normalized = new StringBuilder();

        // Canonicalize tlang
        if (!tlang.isEmpty()) {
            tlang = validateAndCanonicalizeLanguageTag(tlang);
            normalized.append(tlang);
        }

        // Canonicalize fields
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            if (normalized.length() != 0) {
                normalized.append('-');
            }
            String value = entry.getValue();
            if ("names".equalsIgnoreCase(value)) {
                value = "prprname";
            }
            if ("true".equals(value)) {
                value = TRUE_PLACEHOLDER;
            }
            normalized.append(entry.getKey()).append('-').append(value);
        }

        return normalized.toString();
    }

    public static String maybeAppendMissingLanguageSubTag(String tag) {
        // (U)Locale.Builder.build() tends to strip und- prefix even
        // in cases where it results in an invalid (private use only) language tag.
        return tag.startsWith("x-") ? ("und-" + tag) : tag;
    }

    @TruffleBoundary
    // https://tc39.github.io/ecma402/#sec-case-sensitivity-and-case-mapping
    public static String toUpperCase(String in) {
        StringBuilder result = new StringBuilder(in.length());
        for (int i = 0; i < in.length(); i++) {
            int c = in.codePointAt(i);
            if (c >= 'a' && c <= 'z') {
                result.append((char) (c - 32));
            } else {
                result.append((char) c);
            }
        }
        return result.toString();
    }

    @TruffleBoundary
    public static String toLowerCase(JSContext ctx, String s, String[] locales) {
        Locale strippedLocale = selectedLocaleStripped(ctx, locales);
        StringBuilder result = new StringBuilder();
        Lower tr = CaseMap.toLower();
        tr.apply(strippedLocale, s, result, null);
        return result.toString();
    }

    @TruffleBoundary
    public static String toUpperCase(JSContext ctx, String s, String[] locales) {
        Locale strippedLocale = selectedLocaleStripped(ctx, locales);
        StringBuilder result = new StringBuilder();
        Upper tr = CaseMap.toUpper();
        tr.apply(strippedLocale, s, result, null);
        return result.toString();
    }

    @TruffleBoundary
    public static Locale selectedLocaleStripped(JSContext ctx, String[] locales) {
        return IntlUtil.selectedLocale(ctx, locales).stripExtensions();
    }

    public static DynamicObject makePart(JSContext context, JSRealm realm, String type, String value) {
        return makePart(context, realm, type, value, null);
    }

    public static DynamicObject makePart(JSContext context, JSRealm realm, String type, String value, String unit) {
        DynamicObject p = JSOrdinary.create(context, realm);
        JSObject.set(p, TYPE, type);
        JSObject.set(p, VALUE, value);
        if (unit != null) {
            JSObject.set(p, UNIT, unit);
        }
        return p;
    }

    @TruffleBoundary
    private static boolean isSanctionedSimpleUnitIdentifier(String unitIdentifier) {
        return SANCTIONED_SIMPLE_UNIT_IDENTIFIERS.contains(unitIdentifier);
    }

    @TruffleBoundary
    private static boolean isWellFormedUnitIdentifier(String unitIdentifier) {
        if (isSanctionedSimpleUnitIdentifier(unitIdentifier)) {
            return true;
        }
        String per = "-per-";
        int index = unitIdentifier.indexOf(per);
        if (index == -1) {
            return false;
        }
        String numerator = unitIdentifier.substring(0, index);
        String denominator = unitIdentifier.substring(index + per.length());
        return isSanctionedSimpleUnitIdentifier(numerator) && isSanctionedSimpleUnitIdentifier(denominator);
    }

    public static void ensureIsWellFormedUnitIdentifier(String unitIdentifier) {
        if (!isWellFormedUnitIdentifier(unitIdentifier)) {
            throw Errors.createRangeErrorInvalidUnitIdentifier(unitIdentifier);
        }
    }

    @TruffleBoundary
    public static TimeZone getICUTimeZone(String tzId) {
        assert tzId != null;
        return TimeZone.getTimeZone(tzId);
    }

    @TruffleBoundary
    public static TimeZone getICUTimeZone(ZoneId zoneId) {
        return getICUTimeZone(toICUTimeZoneId(zoneId));
    }

    private static String toICUTimeZoneId(ZoneId zoneId) {
        String tzid = zoneId.getId();
        char c = tzid.charAt(0);
        if (c == '+' || c == '-') {
            tzid = "GMT" + tzid;
        } else if (c == 'Z' && tzid.length() == 1) {
            tzid = "UTC";
        } else if (tzid.startsWith("UTC")) {
            tzid = "GMT" + tzid.substring(3);
        } else if (tzid.startsWith("UT")) {
            tzid = "GMT" + tzid.substring(2);
        }
        return tzid;
    }

}
