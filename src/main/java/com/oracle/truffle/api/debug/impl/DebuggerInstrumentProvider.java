// CheckStyle: start generated
package com.oracle.truffle.api.debug.impl;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Provider;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import java.util.Arrays;
import java.util.Collection;

@GeneratedBy(DebuggerInstrument.class)
@Registration(id = "debugger", name = "Debugger")
public final class DebuggerInstrumentProvider implements Provider {

    @Override
    public String getInstrumentClassName() {
        return "com.oracle.truffle.api.debug.impl.DebuggerInstrument";
    }

    @Override
    public TruffleInstrument create() {
        return new DebuggerInstrument();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Arrays.asList("com.oracle.truffle.api.debug.Debugger");
    }

}
