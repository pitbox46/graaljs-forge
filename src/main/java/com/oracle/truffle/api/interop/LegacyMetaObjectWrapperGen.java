// CheckStyle: start generated
package com.oracle.truffle.api.interop;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.library.ReflectionLibrary;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.FinalBitSet;

@GeneratedBy(LegacyMetaObjectWrapper.class)
final class LegacyMetaObjectWrapperGen {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);
    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<ReflectionLibrary> REFLECTION_LIBRARY_ = LibraryFactory.resolve(ReflectionLibrary.class);

    static  {
        LibraryExport.register(LegacyMetaObjectWrapper.class, new InteropLibraryExports(), new ReflectionLibraryExports());
    }

    private LegacyMetaObjectWrapperGen() {
    }

    @GeneratedBy(LegacyMetaObjectWrapper.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        static final FinalBitSet ENABLED_MESSAGES = createMessageBitSet(INTEROP_LIBRARY_, "isMetaObject", "hasMetaObject", "getMetaObject", "isMetaInstance", "getMetaSimpleName", "getMetaQualifiedName");
        private static final Uncached UNCACHED = new Uncached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, LegacyMetaObjectWrapper.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof LegacyMetaObjectWrapper;
            InteropLibrary uncached = createDelegate(INTEROP_LIBRARY_, InteropLibraryExports.UNCACHED);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof LegacyMetaObjectWrapper;
            return createDelegate(INTEROP_LIBRARY_, new Cached(receiver));
        }

        @GeneratedBy(LegacyMetaObjectWrapper.class)
        private static final class Cached extends InteropLibrary implements DelegateExport {

            @Child private InteropLibrary receiverDelegateInteropLibrary_;

            protected Cached(Object receiver) {
                LegacyMetaObjectWrapper castReceiver = ((LegacyMetaObjectWrapper) receiver) ;
                this.receiverDelegateInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((castReceiver.delegate)));
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return ((LegacyMetaObjectWrapper) receiver_).delegate;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate) {
                return this.receiverDelegateInteropLibrary_;
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof LegacyMetaObjectWrapper) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof LegacyMetaObjectWrapper)) {
                    return false;
                } else if (!this.receiverDelegateInteropLibrary_.accepts((((LegacyMetaObjectWrapper) receiver).delegate))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean isMetaObject(Object receiver) {
                assert receiver instanceof LegacyMetaObjectWrapper : "Invalid library usage. Library does not accept given receiver.";
                return (((LegacyMetaObjectWrapper) receiver)).isMetaObject();
            }

            @Override
            public boolean hasMetaObject(Object arg0Value_) {
                assert arg0Value_ instanceof LegacyMetaObjectWrapper : "Invalid library usage. Library does not accept given receiver.";
                LegacyMetaObjectWrapper arg0Value = ((LegacyMetaObjectWrapper) arg0Value_);
                {
                    InteropLibrary hasMetaObjectNode__hasMetaObject_library__ = this.receiverDelegateInteropLibrary_;
                    return arg0Value.hasMetaObject(hasMetaObjectNode__hasMetaObject_library__);
                }
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MONOMORPHIC;
            }

            @Override
            public Object getMetaObject(Object arg0Value_) throws UnsupportedMessageException {
                assert arg0Value_ instanceof LegacyMetaObjectWrapper : "Invalid library usage. Library does not accept given receiver.";
                LegacyMetaObjectWrapper arg0Value = ((LegacyMetaObjectWrapper) arg0Value_);
                {
                    InteropLibrary getMetaObjectNode__getMetaObject_library__ = this.receiverDelegateInteropLibrary_;
                    return arg0Value.getMetaObject(getMetaObjectNode__getMetaObject_library__);
                }
            }

            @Override
            public boolean isMetaInstance(Object receiver, Object instance) throws UnsupportedMessageException {
                assert receiver instanceof LegacyMetaObjectWrapper : "Invalid library usage. Library does not accept given receiver.";
                return (((LegacyMetaObjectWrapper) receiver)).isMetaInstance(instance);
            }

            @Override
            public Object getMetaSimpleName(Object arg0Value_) throws UnsupportedMessageException {
                assert arg0Value_ instanceof LegacyMetaObjectWrapper : "Invalid library usage. Library does not accept given receiver.";
                LegacyMetaObjectWrapper arg0Value = ((LegacyMetaObjectWrapper) arg0Value_);
                {
                    InteropLibrary getLegacyMetaNameNode__getLegacyMetaName_delegateInterop__ = this.receiverDelegateInteropLibrary_;
                    return arg0Value.getLegacyMetaName(getLegacyMetaNameNode__getLegacyMetaName_delegateInterop__);
                }
            }

            @Override
            public Object getMetaQualifiedName(Object arg0Value_) throws UnsupportedMessageException {
                assert arg0Value_ instanceof LegacyMetaObjectWrapper : "Invalid library usage. Library does not accept given receiver.";
                LegacyMetaObjectWrapper arg0Value = ((LegacyMetaObjectWrapper) arg0Value_);
                {
                    InteropLibrary getLegacyMetaNameNode__getLegacyMetaName_delegateInterop__ = this.receiverDelegateInteropLibrary_;
                    return arg0Value.getLegacyMetaName(getLegacyMetaNameNode__getLegacyMetaName_delegateInterop__);
                }
            }

        }
        @GeneratedBy(LegacyMetaObjectWrapper.class)
        private static final class Uncached extends InteropLibrary implements DelegateExport {

            protected Uncached() {
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return (((LegacyMetaObjectWrapper) receiver_)).delegate;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate_) {
                return INTEROP_LIBRARY_.getUncached(delegate_);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof LegacyMetaObjectWrapper) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof LegacyMetaObjectWrapper;
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
            public boolean isMetaObject(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((LegacyMetaObjectWrapper) receiver) .isMetaObject();
            }

            @TruffleBoundary
            @Override
            public boolean hasMetaObject(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                LegacyMetaObjectWrapper arg0Value = ((LegacyMetaObjectWrapper) arg0Value_);
                return arg0Value.hasMetaObject(INTEROP_LIBRARY_.getUncached((arg0Value.delegate)));
            }

            @TruffleBoundary
            @Override
            public Object getMetaObject(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                LegacyMetaObjectWrapper arg0Value = ((LegacyMetaObjectWrapper) arg0Value_);
                return arg0Value.getMetaObject(INTEROP_LIBRARY_.getUncached((arg0Value.delegate)));
            }

            @TruffleBoundary
            @Override
            public boolean isMetaInstance(Object receiver, Object instance) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((LegacyMetaObjectWrapper) receiver) .isMetaInstance(instance);
            }

            @TruffleBoundary
            @Override
            public Object getMetaSimpleName(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                LegacyMetaObjectWrapper arg0Value = ((LegacyMetaObjectWrapper) arg0Value_);
                return arg0Value.getLegacyMetaName(INTEROP_LIBRARY_.getUncached((arg0Value.delegate)));
            }

            @TruffleBoundary
            @Override
            public Object getMetaQualifiedName(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                LegacyMetaObjectWrapper arg0Value = ((LegacyMetaObjectWrapper) arg0Value_);
                return arg0Value.getLegacyMetaName(INTEROP_LIBRARY_.getUncached((arg0Value.delegate)));
            }

        }
    }
    @GeneratedBy(LegacyMetaObjectWrapper.class)
    private static final class ReflectionLibraryExports extends LibraryExport<ReflectionLibrary> {

        static final FinalBitSet ENABLED_MESSAGES = createMessageBitSet(REFLECTION_LIBRARY_);
        private static final Uncached UNCACHED = new Uncached();

        private ReflectionLibraryExports() {
            super(ReflectionLibrary.class, LegacyMetaObjectWrapper.class, false, false, 0);
        }

        @Override
        protected ReflectionLibrary createUncached(Object receiver) {
            assert receiver instanceof LegacyMetaObjectWrapper;
            ReflectionLibrary uncached = createDelegate(REFLECTION_LIBRARY_, ReflectionLibraryExports.UNCACHED);
            return uncached;
        }

        @Override
        protected ReflectionLibrary createCached(Object receiver) {
            assert receiver instanceof LegacyMetaObjectWrapper;
            return createDelegate(REFLECTION_LIBRARY_, new Cached(receiver));
        }

        @GeneratedBy(LegacyMetaObjectWrapper.class)
        private static final class Cached extends ReflectionLibrary implements DelegateExport {

            @Child private ReflectionLibrary receiverDelegateReflectionLibrary_;

            protected Cached(Object receiver) {
                LegacyMetaObjectWrapper castReceiver = ((LegacyMetaObjectWrapper) receiver) ;
                this.receiverDelegateReflectionLibrary_ = super.insert(REFLECTION_LIBRARY_.create((castReceiver.delegate)));
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return ((LegacyMetaObjectWrapper) receiver_).delegate;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate) {
                return this.receiverDelegateReflectionLibrary_;
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof LegacyMetaObjectWrapper) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof LegacyMetaObjectWrapper)) {
                    return false;
                } else if (!this.receiverDelegateReflectionLibrary_.accepts((((LegacyMetaObjectWrapper) receiver).delegate))) {
                    return false;
                } else {
                    return true;
                }
            }

        }
        @GeneratedBy(LegacyMetaObjectWrapper.class)
        private static final class Uncached extends ReflectionLibrary implements DelegateExport {

            protected Uncached() {
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return (((LegacyMetaObjectWrapper) receiver_)).delegate;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate_) {
                return REFLECTION_LIBRARY_.getUncached(delegate_);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof LegacyMetaObjectWrapper) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof LegacyMetaObjectWrapper;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

        }
    }
}
