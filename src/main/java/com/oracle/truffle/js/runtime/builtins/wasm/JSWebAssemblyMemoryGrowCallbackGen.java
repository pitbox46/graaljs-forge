// CheckStyle: start generated
package com.oracle.truffle.js.runtime.builtins.wasm;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;

@GeneratedBy(JSWebAssemblyMemoryGrowCallback.class)
final class JSWebAssemblyMemoryGrowCallbackGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(JSWebAssemblyMemoryGrowCallback.class, new InteropLibraryExports());
    }

    private JSWebAssemblyMemoryGrowCallbackGen() {
    }

    @GeneratedBy(JSWebAssemblyMemoryGrowCallback.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private static final Uncached UNCACHED = new Uncached();
        private static final Cached CACHE = new Cached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, JSWebAssemblyMemoryGrowCallback.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JSWebAssemblyMemoryGrowCallback;
            InteropLibrary uncached = InteropLibraryExports.UNCACHED;
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JSWebAssemblyMemoryGrowCallback;
            return InteropLibraryExports.CACHE;
        }

        @GeneratedBy(JSWebAssemblyMemoryGrowCallback.class)
        private static final class Cached extends InteropLibrary {

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JSWebAssemblyMemoryGrowCallback) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof JSWebAssemblyMemoryGrowCallback;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public boolean isExecutable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((JSWebAssemblyMemoryGrowCallback) receiver)).isExecutable();
            }

            @Override
            public Object execute(Object receiver, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((JSWebAssemblyMemoryGrowCallback) receiver)).execute(arguments);
            }

        }
        @GeneratedBy(JSWebAssemblyMemoryGrowCallback.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JSWebAssemblyMemoryGrowCallback) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof JSWebAssemblyMemoryGrowCallback;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public boolean isExecutable(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSWebAssemblyMemoryGrowCallback) receiver) .isExecutable();
            }

            @TruffleBoundary
            @Override
            public Object execute(Object receiver, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSWebAssemblyMemoryGrowCallback) receiver) .execute(arguments);
            }

        }
    }
}
