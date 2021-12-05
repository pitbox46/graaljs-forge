// CheckStyle: start generated
package com.oracle.truffle.regex.util;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.regex.AbstractRegexObjectGen;

@GeneratedBy(TruffleNull.class)
final class TruffleNullGen {

    static  {
        LibraryExport.register(TruffleNull.class, new InteropLibraryExports());
    }

    private TruffleNullGen() {
    }

    @GeneratedBy(TruffleNull.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, TruffleNull.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof TruffleNull;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof TruffleNull;
            return new Cached(receiver);
        }

        @GeneratedBy(TruffleNull.class)
        private static final class Cached extends AbstractRegexObjectGen.InteropLibraryExports.Cached {

            protected Cached(Object receiver) {
                super(receiver);
            }

            @Override
            public boolean isNull(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((TruffleNull) receiver)).isNull();
            }

        }
        @GeneratedBy(TruffleNull.class)
        private static final class Uncached extends AbstractRegexObjectGen.InteropLibraryExports.Uncached {

            protected Uncached(Object receiver) {
                super(receiver);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                return super.accepts(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isNull(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TruffleNull) receiver) .isNull();
            }

        }
    }
}
