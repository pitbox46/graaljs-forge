// CheckStyle: start generated
package com.oracle.truffle.regex;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleFile.FileTypeDetector;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;
import com.oracle.truffle.api.TruffleLanguage.Provider;
import com.oracle.truffle.api.TruffleLanguage.Registration;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags.RootTag;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@GeneratedBy(RegexLanguage.class)
@Registration(characterMimeTypes = {"application/tregex"}, contextPolicy = ContextPolicy.SHARED, id = "regex", interactive = false, internal = true, name = "REGEX", version = "0.1")
@ProvidedTags({RootTag.class})
public final class RegexLanguageProvider implements Provider {

    @Override
    public String getLanguageClassName() {
        return "com.oracle.truffle.regex.RegexLanguage";
    }

    @Override
    public TruffleLanguage<?> create() {
        return new RegexLanguage();
    }

    @Override
    public List<FileTypeDetector> createFileTypeDetectors() {
        return Collections.emptyList();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Collections.emptySet();
    }

}
