// CheckStyle: start generated
package com.oracle.truffle.polyglot;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.api.utilities.FinalBitSet;

@GeneratedBy(DefaultLanguageView.class)
final class DefaultLanguageViewGen {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);
    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(DefaultLanguageView.class, new InteropLibraryExports());
    }

    private DefaultLanguageViewGen() {
    }

    @GeneratedBy(DefaultLanguageView.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        static final FinalBitSet ENABLED_MESSAGES = createMessageBitSet(INTEROP_LIBRARY_, "hasSourceLocation", "getSourceLocation", "hasLanguage", "toDisplayString", "getLanguage", "hasMetaObject", "getMetaObject");
        private static final Uncached UNCACHED = new Uncached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, DefaultLanguageView.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof DefaultLanguageView<?>;
            InteropLibrary uncached = createDelegate(INTEROP_LIBRARY_, InteropLibraryExports.UNCACHED);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof DefaultLanguageView<?>;
            return createDelegate(INTEROP_LIBRARY_, new Cached(receiver));
        }

        @GeneratedBy(DefaultLanguageView.class)
        private static final class Cached extends InteropLibrary implements DelegateExport {

            @Child private InteropLibrary receiverDelegateInteropLibrary_;

            protected Cached(Object receiver) {
                DefaultLanguageView<?> castReceiver = ((DefaultLanguageView<?>) receiver) ;
                this.receiverDelegateInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((castReceiver.delegate)));
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return ((DefaultLanguageView<?>) receiver_).delegate;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate) {
                return this.receiverDelegateInteropLibrary_;
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof DefaultLanguageView<?>) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof DefaultLanguageView<?>)) {
                    return false;
                } else if (!this.receiverDelegateInteropLibrary_.accepts((((DefaultLanguageView<?>) receiver).delegate))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean hasSourceLocation(Object arg0Value_) {
                assert arg0Value_ instanceof DefaultLanguageView<?> : "Invalid library usage. Library does not accept given receiver.";
                DefaultLanguageView<?> arg0Value = ((DefaultLanguageView<?>) arg0Value_);
                {
                    InteropLibrary hasSourceLocationNode__hasSourceLocation_delegateLib__ = this.receiverDelegateInteropLibrary_;
                    return arg0Value.hasSourceLocation(hasSourceLocationNode__hasSourceLocation_delegateLib__);
                }
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MONOMORPHIC;
            }

            @Override
            public SourceSection getSourceLocation(Object arg0Value_) throws UnsupportedMessageException {
                assert arg0Value_ instanceof DefaultLanguageView<?> : "Invalid library usage. Library does not accept given receiver.";
                DefaultLanguageView<?> arg0Value = ((DefaultLanguageView<?>) arg0Value_);
                {
                    InteropLibrary getSourceLocationNode__getSourceLocation_delegateLib__ = this.receiverDelegateInteropLibrary_;
                    return arg0Value.getSourceLocation(getSourceLocationNode__getSourceLocation_delegateLib__);
                }
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert receiver instanceof DefaultLanguageView<?> : "Invalid library usage. Library does not accept given receiver.";
                return (((DefaultLanguageView<?>) receiver)).hasLanguage();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert receiver instanceof DefaultLanguageView<?> : "Invalid library usage. Library does not accept given receiver.";
                return (((DefaultLanguageView<?>) receiver)).toDisplayString(allowSideEffects);
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof DefaultLanguageView<?> : "Invalid library usage. Library does not accept given receiver.";
                return (((DefaultLanguageView<?>) receiver)).getLanguage();
            }

            @Override
            public boolean hasMetaObject(Object receiver) {
                assert receiver instanceof DefaultLanguageView<?> : "Invalid library usage. Library does not accept given receiver.";
                return (((DefaultLanguageView<?>) receiver)).hasMetaObject();
            }

            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof DefaultLanguageView<?> : "Invalid library usage. Library does not accept given receiver.";
                return (((DefaultLanguageView<?>) receiver)).getMetaObject();
            }

        }
        @GeneratedBy(DefaultLanguageView.class)
        private static final class Uncached extends InteropLibrary implements DelegateExport {

            protected Uncached() {
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return (((DefaultLanguageView<?>) receiver_)).delegate;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate_) {
                return INTEROP_LIBRARY_.getUncached(delegate_);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof DefaultLanguageView<?>) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof DefaultLanguageView<?>;
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
            public boolean hasSourceLocation(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DefaultLanguageView<?> arg0Value = ((DefaultLanguageView<?>) arg0Value_);
                return arg0Value.hasSourceLocation(INTEROP_LIBRARY_.getUncached((arg0Value.delegate)));
            }

            @TruffleBoundary
            @Override
            public SourceSection getSourceLocation(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DefaultLanguageView<?> arg0Value = ((DefaultLanguageView<?>) arg0Value_);
                return arg0Value.getSourceLocation(INTEROP_LIBRARY_.getUncached((arg0Value.delegate)));
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((DefaultLanguageView<?>) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((DefaultLanguageView<?>) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((DefaultLanguageView<?>) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public boolean hasMetaObject(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((DefaultLanguageView<?>) receiver) .hasMetaObject();
            }

            @TruffleBoundary
            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((DefaultLanguageView<?>) receiver) .getMetaObject();
            }

        }
    }
}
