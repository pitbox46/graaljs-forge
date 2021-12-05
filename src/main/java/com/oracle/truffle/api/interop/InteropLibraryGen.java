// CheckStyle: start generated
package com.oracle.truffle.api.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary.Asserts;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.library.Message;
import com.oracle.truffle.api.library.ReflectionLibrary;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.api.utilities.FinalBitSet;
import com.oracle.truffle.api.utilities.TriState;
import java.nio.ByteOrder;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InteropLibrary.class)
final class InteropLibraryGen extends LibraryFactory<InteropLibrary> {

    private static final Class<InteropLibrary> LIBRARY_CLASS = InteropLibraryGen.lazyLibraryClass();
    private static final Message IS_NULL = new MessageImpl("isNull", 0, boolean.class, Object.class);
    private static final Message IS_BOOLEAN = new MessageImpl("isBoolean", 1, boolean.class, Object.class);
    private static final Message AS_BOOLEAN = new MessageImpl("asBoolean", 2, boolean.class, Object.class);
    private static final Message IS_EXECUTABLE = new MessageImpl("isExecutable", 3, boolean.class, Object.class);
    private static final Message EXECUTE = new MessageImpl("execute", 4, Object.class, Object.class, Object[].class);
    private static final Message HAS_EXECUTABLE_NAME = new MessageImpl("hasExecutableName", 5, boolean.class, Object.class);
    private static final Message GET_EXECUTABLE_NAME = new MessageImpl("getExecutableName", 6, Object.class, Object.class);
    private static final Message HAS_DECLARING_META_OBJECT = new MessageImpl("hasDeclaringMetaObject", 7, boolean.class, Object.class);
    private static final Message GET_DECLARING_META_OBJECT = new MessageImpl("getDeclaringMetaObject", 8, Object.class, Object.class);
    private static final Message IS_INSTANTIABLE = new MessageImpl("isInstantiable", 9, boolean.class, Object.class);
    private static final Message INSTANTIATE = new MessageImpl("instantiate", 10, Object.class, Object.class, Object[].class);
    private static final Message IS_STRING = new MessageImpl("isString", 11, boolean.class, Object.class);
    private static final Message AS_STRING = new MessageImpl("asString", 12, String.class, Object.class);
    private static final Message IS_NUMBER = new MessageImpl("isNumber", 13, boolean.class, Object.class);
    private static final Message FITS_IN_BYTE = new MessageImpl("fitsInByte", 14, boolean.class, Object.class);
    private static final Message FITS_IN_SHORT = new MessageImpl("fitsInShort", 15, boolean.class, Object.class);
    private static final Message FITS_IN_INT = new MessageImpl("fitsInInt", 16, boolean.class, Object.class);
    private static final Message FITS_IN_LONG = new MessageImpl("fitsInLong", 17, boolean.class, Object.class);
    private static final Message FITS_IN_FLOAT = new MessageImpl("fitsInFloat", 18, boolean.class, Object.class);
    private static final Message FITS_IN_DOUBLE = new MessageImpl("fitsInDouble", 19, boolean.class, Object.class);
    private static final Message AS_BYTE = new MessageImpl("asByte", 20, byte.class, Object.class);
    private static final Message AS_SHORT = new MessageImpl("asShort", 21, short.class, Object.class);
    private static final Message AS_INT = new MessageImpl("asInt", 22, int.class, Object.class);
    private static final Message AS_LONG = new MessageImpl("asLong", 23, long.class, Object.class);
    private static final Message AS_FLOAT = new MessageImpl("asFloat", 24, float.class, Object.class);
    private static final Message AS_DOUBLE = new MessageImpl("asDouble", 25, double.class, Object.class);
    private static final Message HAS_MEMBERS = new MessageImpl("hasMembers", 26, boolean.class, Object.class);
    private static final Message GET_MEMBERS = new MessageImpl("getMembers", 27, Object.class, Object.class, boolean.class);
    private static final Message IS_MEMBER_READABLE = new MessageImpl("isMemberReadable", 28, boolean.class, Object.class, String.class);
    private static final Message READ_MEMBER = new MessageImpl("readMember", 29, Object.class, Object.class, String.class);
    private static final Message IS_MEMBER_MODIFIABLE = new MessageImpl("isMemberModifiable", 30, boolean.class, Object.class, String.class);
    private static final Message IS_MEMBER_INSERTABLE = new MessageImpl("isMemberInsertable", 31, boolean.class, Object.class, String.class);
    private static final Message WRITE_MEMBER = new MessageImpl("writeMember", 32, void.class, Object.class, String.class, Object.class);
    private static final Message IS_MEMBER_REMOVABLE = new MessageImpl("isMemberRemovable", 33, boolean.class, Object.class, String.class);
    private static final Message REMOVE_MEMBER = new MessageImpl("removeMember", 34, void.class, Object.class, String.class);
    private static final Message IS_MEMBER_INVOCABLE = new MessageImpl("isMemberInvocable", 35, boolean.class, Object.class, String.class);
    private static final Message INVOKE_MEMBER = new MessageImpl("invokeMember", 36, Object.class, Object.class, String.class, Object[].class);
    private static final Message IS_MEMBER_INTERNAL = new MessageImpl("isMemberInternal", 37, boolean.class, Object.class, String.class);
    private static final Message HAS_MEMBER_READ_SIDE_EFFECTS = new MessageImpl("hasMemberReadSideEffects", 38, boolean.class, Object.class, String.class);
    private static final Message HAS_MEMBER_WRITE_SIDE_EFFECTS = new MessageImpl("hasMemberWriteSideEffects", 39, boolean.class, Object.class, String.class);
    private static final Message HAS_HASH_ENTRIES = new MessageImpl("hasHashEntries", 40, boolean.class, Object.class);
    private static final Message GET_HASH_SIZE = new MessageImpl("getHashSize", 41, long.class, Object.class);
    private static final Message IS_HASH_ENTRY_READABLE = new MessageImpl("isHashEntryReadable", 42, boolean.class, Object.class, Object.class);
    private static final Message READ_HASH_VALUE = new MessageImpl("readHashValue", 43, Object.class, Object.class, Object.class);
    private static final Message READ_HASH_VALUE_OR_DEFAULT = new MessageImpl("readHashValueOrDefault", 44, Object.class, Object.class, Object.class, Object.class);
    private static final Message IS_HASH_ENTRY_MODIFIABLE = new MessageImpl("isHashEntryModifiable", 45, boolean.class, Object.class, Object.class);
    private static final Message IS_HASH_ENTRY_INSERTABLE = new MessageImpl("isHashEntryInsertable", 46, boolean.class, Object.class, Object.class);
    private static final Message IS_HASH_ENTRY_WRITABLE = new MessageImpl("isHashEntryWritable", 47, boolean.class, Object.class, Object.class);
    private static final Message WRITE_HASH_ENTRY = new MessageImpl("writeHashEntry", 48, void.class, Object.class, Object.class, Object.class);
    private static final Message IS_HASH_ENTRY_REMOVABLE = new MessageImpl("isHashEntryRemovable", 49, boolean.class, Object.class, Object.class);
    private static final Message REMOVE_HASH_ENTRY = new MessageImpl("removeHashEntry", 50, void.class, Object.class, Object.class);
    private static final Message IS_HASH_ENTRY_EXISTING = new MessageImpl("isHashEntryExisting", 51, boolean.class, Object.class, Object.class);
    private static final Message GET_HASH_ENTRIES_ITERATOR = new MessageImpl("getHashEntriesIterator", 52, Object.class, Object.class);
    private static final Message GET_HASH_KEYS_ITERATOR = new MessageImpl("getHashKeysIterator", 53, Object.class, Object.class);
    private static final Message GET_HASH_VALUES_ITERATOR = new MessageImpl("getHashValuesIterator", 54, Object.class, Object.class);
    private static final Message HAS_ARRAY_ELEMENTS = new MessageImpl("hasArrayElements", 55, boolean.class, Object.class);
    private static final Message READ_ARRAY_ELEMENT = new MessageImpl("readArrayElement", 56, Object.class, Object.class, long.class);
    private static final Message GET_ARRAY_SIZE = new MessageImpl("getArraySize", 57, long.class, Object.class);
    private static final Message IS_ARRAY_ELEMENT_READABLE = new MessageImpl("isArrayElementReadable", 58, boolean.class, Object.class, long.class);
    private static final Message WRITE_ARRAY_ELEMENT = new MessageImpl("writeArrayElement", 59, void.class, Object.class, long.class, Object.class);
    private static final Message REMOVE_ARRAY_ELEMENT = new MessageImpl("removeArrayElement", 60, void.class, Object.class, long.class);
    private static final Message IS_ARRAY_ELEMENT_MODIFIABLE = new MessageImpl("isArrayElementModifiable", 61, boolean.class, Object.class, long.class);
    private static final Message IS_ARRAY_ELEMENT_INSERTABLE = new MessageImpl("isArrayElementInsertable", 62, boolean.class, Object.class, long.class);
    private static final Message IS_ARRAY_ELEMENT_REMOVABLE = new MessageImpl("isArrayElementRemovable", 63, boolean.class, Object.class, long.class);
    private static final Message HAS_BUFFER_ELEMENTS = new MessageImpl("hasBufferElements", 64, boolean.class, Object.class);
    private static final Message IS_BUFFER_WRITABLE = new MessageImpl("isBufferWritable", 65, boolean.class, Object.class);
    private static final Message GET_BUFFER_SIZE = new MessageImpl("getBufferSize", 66, long.class, Object.class);
    private static final Message READ_BUFFER_BYTE = new MessageImpl("readBufferByte", 67, byte.class, Object.class, long.class);
    private static final Message WRITE_BUFFER_BYTE = new MessageImpl("writeBufferByte", 68, void.class, Object.class, long.class, byte.class);
    private static final Message READ_BUFFER_SHORT = new MessageImpl("readBufferShort", 69, short.class, Object.class, ByteOrder.class, long.class);
    private static final Message WRITE_BUFFER_SHORT = new MessageImpl("writeBufferShort", 70, void.class, Object.class, ByteOrder.class, long.class, short.class);
    private static final Message READ_BUFFER_INT = new MessageImpl("readBufferInt", 71, int.class, Object.class, ByteOrder.class, long.class);
    private static final Message WRITE_BUFFER_INT = new MessageImpl("writeBufferInt", 72, void.class, Object.class, ByteOrder.class, long.class, int.class);
    private static final Message READ_BUFFER_LONG = new MessageImpl("readBufferLong", 73, long.class, Object.class, ByteOrder.class, long.class);
    private static final Message WRITE_BUFFER_LONG = new MessageImpl("writeBufferLong", 74, void.class, Object.class, ByteOrder.class, long.class, long.class);
    private static final Message READ_BUFFER_FLOAT = new MessageImpl("readBufferFloat", 75, float.class, Object.class, ByteOrder.class, long.class);
    private static final Message WRITE_BUFFER_FLOAT = new MessageImpl("writeBufferFloat", 76, void.class, Object.class, ByteOrder.class, long.class, float.class);
    private static final Message READ_BUFFER_DOUBLE = new MessageImpl("readBufferDouble", 77, double.class, Object.class, ByteOrder.class, long.class);
    private static final Message WRITE_BUFFER_DOUBLE = new MessageImpl("writeBufferDouble", 78, void.class, Object.class, ByteOrder.class, long.class, double.class);
    private static final Message IS_POINTER = new MessageImpl("isPointer", 79, boolean.class, Object.class);
    private static final Message AS_POINTER = new MessageImpl("asPointer", 80, long.class, Object.class);
    private static final Message TO_NATIVE = new MessageImpl("toNative", 81, void.class, Object.class);
    private static final Message AS_INSTANT = new MessageImpl("asInstant", 82, Instant.class, Object.class);
    private static final Message IS_TIME_ZONE = new MessageImpl("isTimeZone", 83, boolean.class, Object.class);
    private static final Message AS_TIME_ZONE = new MessageImpl("asTimeZone", 84, ZoneId.class, Object.class);
    private static final Message IS_DATE = new MessageImpl("isDate", 85, boolean.class, Object.class);
    private static final Message AS_DATE = new MessageImpl("asDate", 86, LocalDate.class, Object.class);
    private static final Message IS_TIME = new MessageImpl("isTime", 87, boolean.class, Object.class);
    private static final Message AS_TIME = new MessageImpl("asTime", 88, LocalTime.class, Object.class);
    private static final Message IS_DURATION = new MessageImpl("isDuration", 89, boolean.class, Object.class);
    private static final Message AS_DURATION = new MessageImpl("asDuration", 90, Duration.class, Object.class);
    private static final Message IS_EXCEPTION = new MessageImpl("isException", 91, boolean.class, Object.class);
    private static final Message THROW_EXCEPTION = new MessageImpl("throwException", 92, RuntimeException.class, Object.class);
    private static final Message GET_EXCEPTION_TYPE = new MessageImpl("getExceptionType", 93, ExceptionType.class, Object.class);
    private static final Message IS_EXCEPTION_INCOMPLETE_SOURCE = new MessageImpl("isExceptionIncompleteSource", 94, boolean.class, Object.class);
    private static final Message GET_EXCEPTION_EXIT_STATUS = new MessageImpl("getExceptionExitStatus", 95, int.class, Object.class);
    private static final Message HAS_EXCEPTION_CAUSE = new MessageImpl("hasExceptionCause", 96, boolean.class, Object.class);
    private static final Message GET_EXCEPTION_CAUSE = new MessageImpl("getExceptionCause", 97, Object.class, Object.class);
    private static final Message HAS_EXCEPTION_MESSAGE = new MessageImpl("hasExceptionMessage", 98, boolean.class, Object.class);
    private static final Message GET_EXCEPTION_MESSAGE = new MessageImpl("getExceptionMessage", 99, Object.class, Object.class);
    private static final Message HAS_EXCEPTION_STACK_TRACE = new MessageImpl("hasExceptionStackTrace", 100, boolean.class, Object.class);
    private static final Message GET_EXCEPTION_STACK_TRACE = new MessageImpl("getExceptionStackTrace", 101, Object.class, Object.class);
    private static final Message HAS_ITERATOR = new MessageImpl("hasIterator", 102, boolean.class, Object.class);
    private static final Message GET_ITERATOR = new MessageImpl("getIterator", 103, Object.class, Object.class);
    private static final Message IS_ITERATOR = new MessageImpl("isIterator", 104, boolean.class, Object.class);
    private static final Message HAS_ITERATOR_NEXT_ELEMENT = new MessageImpl("hasIteratorNextElement", 105, boolean.class, Object.class);
    private static final Message GET_ITERATOR_NEXT_ELEMENT = new MessageImpl("getIteratorNextElement", 106, Object.class, Object.class);
    private static final Message HAS_SOURCE_LOCATION = new MessageImpl("hasSourceLocation", 107, boolean.class, Object.class);
    private static final Message GET_SOURCE_LOCATION = new MessageImpl("getSourceLocation", 108, SourceSection.class, Object.class);
    private static final Message HAS_LANGUAGE = new MessageImpl("hasLanguage", 109, boolean.class, Object.class);
    private static final Message GET_LANGUAGE = new MessageImpl("getLanguage", 110, Class.class, Object.class);
    private static final Message HAS_META_OBJECT = new MessageImpl("hasMetaObject", 111, boolean.class, Object.class);
    private static final Message GET_META_OBJECT = new MessageImpl("getMetaObject", 112, Object.class, Object.class);
    private static final Message TO_DISPLAY_STRING = new MessageImpl("toDisplayString", 113, Object.class, Object.class, boolean.class);
    private static final Message IS_META_OBJECT = new MessageImpl("isMetaObject", 114, boolean.class, Object.class);
    private static final Message GET_META_QUALIFIED_NAME = new MessageImpl("getMetaQualifiedName", 115, Object.class, Object.class);
    private static final Message GET_META_SIMPLE_NAME = new MessageImpl("getMetaSimpleName", 116, Object.class, Object.class);
    private static final Message IS_META_INSTANCE = new MessageImpl("isMetaInstance", 117, boolean.class, Object.class, Object.class);
    private static final Message IS_IDENTICAL_OR_UNDEFINED = new MessageImpl("isIdenticalOrUndefined", 118, TriState.class, Object.class, Object.class);
    private static final Message IS_IDENTICAL = new MessageImpl("isIdentical", 119, boolean.class, Object.class, Object.class, InteropLibrary.class);
    private static final Message IDENTITY_HASH_CODE = new MessageImpl("identityHashCode", 120, int.class, Object.class);
    private static final Message IS_SCOPE = new MessageImpl("isScope", 121, boolean.class, Object.class);
    private static final Message HAS_SCOPE_PARENT = new MessageImpl("hasScopeParent", 122, boolean.class, Object.class);
    private static final Message GET_SCOPE_PARENT = new MessageImpl("getScopeParent", 123, Object.class, Object.class);
    private static final InteropLibraryGen INSTANCE = new InteropLibraryGen();
    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(InteropLibraryGen.LIBRARY_CLASS, new Default());
        LibraryFactory.register(InteropLibraryGen.LIBRARY_CLASS, INSTANCE);
    }

    private InteropLibraryGen() {
        super(InteropLibraryGen.LIBRARY_CLASS, Collections.unmodifiableList(Arrays.asList(InteropLibraryGen.IS_NULL, InteropLibraryGen.IS_BOOLEAN, InteropLibraryGen.AS_BOOLEAN, InteropLibraryGen.IS_EXECUTABLE, InteropLibraryGen.EXECUTE, InteropLibraryGen.HAS_EXECUTABLE_NAME, InteropLibraryGen.GET_EXECUTABLE_NAME, InteropLibraryGen.HAS_DECLARING_META_OBJECT, InteropLibraryGen.GET_DECLARING_META_OBJECT, InteropLibraryGen.IS_INSTANTIABLE, InteropLibraryGen.INSTANTIATE, InteropLibraryGen.IS_STRING, InteropLibraryGen.AS_STRING, InteropLibraryGen.IS_NUMBER, InteropLibraryGen.FITS_IN_BYTE, InteropLibraryGen.FITS_IN_SHORT, InteropLibraryGen.FITS_IN_INT, InteropLibraryGen.FITS_IN_LONG, InteropLibraryGen.FITS_IN_FLOAT, InteropLibraryGen.FITS_IN_DOUBLE, InteropLibraryGen.AS_BYTE, InteropLibraryGen.AS_SHORT, InteropLibraryGen.AS_INT, InteropLibraryGen.AS_LONG, InteropLibraryGen.AS_FLOAT, InteropLibraryGen.AS_DOUBLE, InteropLibraryGen.HAS_MEMBERS, InteropLibraryGen.GET_MEMBERS, InteropLibraryGen.IS_MEMBER_READABLE, InteropLibraryGen.READ_MEMBER, InteropLibraryGen.IS_MEMBER_MODIFIABLE, InteropLibraryGen.IS_MEMBER_INSERTABLE, InteropLibraryGen.WRITE_MEMBER, InteropLibraryGen.IS_MEMBER_REMOVABLE, InteropLibraryGen.REMOVE_MEMBER, InteropLibraryGen.IS_MEMBER_INVOCABLE, InteropLibraryGen.INVOKE_MEMBER, InteropLibraryGen.IS_MEMBER_INTERNAL, InteropLibraryGen.HAS_MEMBER_READ_SIDE_EFFECTS, InteropLibraryGen.HAS_MEMBER_WRITE_SIDE_EFFECTS, InteropLibraryGen.HAS_HASH_ENTRIES, InteropLibraryGen.GET_HASH_SIZE, InteropLibraryGen.IS_HASH_ENTRY_READABLE, InteropLibraryGen.READ_HASH_VALUE, InteropLibraryGen.READ_HASH_VALUE_OR_DEFAULT, InteropLibraryGen.IS_HASH_ENTRY_MODIFIABLE, InteropLibraryGen.IS_HASH_ENTRY_INSERTABLE, InteropLibraryGen.IS_HASH_ENTRY_WRITABLE, InteropLibraryGen.WRITE_HASH_ENTRY, InteropLibraryGen.IS_HASH_ENTRY_REMOVABLE, InteropLibraryGen.REMOVE_HASH_ENTRY, InteropLibraryGen.IS_HASH_ENTRY_EXISTING, InteropLibraryGen.GET_HASH_ENTRIES_ITERATOR, InteropLibraryGen.GET_HASH_KEYS_ITERATOR, InteropLibraryGen.GET_HASH_VALUES_ITERATOR, InteropLibraryGen.HAS_ARRAY_ELEMENTS, InteropLibraryGen.READ_ARRAY_ELEMENT, InteropLibraryGen.GET_ARRAY_SIZE, InteropLibraryGen.IS_ARRAY_ELEMENT_READABLE, InteropLibraryGen.WRITE_ARRAY_ELEMENT, InteropLibraryGen.REMOVE_ARRAY_ELEMENT, InteropLibraryGen.IS_ARRAY_ELEMENT_MODIFIABLE, InteropLibraryGen.IS_ARRAY_ELEMENT_INSERTABLE, InteropLibraryGen.IS_ARRAY_ELEMENT_REMOVABLE, InteropLibraryGen.HAS_BUFFER_ELEMENTS, InteropLibraryGen.IS_BUFFER_WRITABLE, InteropLibraryGen.GET_BUFFER_SIZE, InteropLibraryGen.READ_BUFFER_BYTE, InteropLibraryGen.WRITE_BUFFER_BYTE, InteropLibraryGen.READ_BUFFER_SHORT, InteropLibraryGen.WRITE_BUFFER_SHORT, InteropLibraryGen.READ_BUFFER_INT, InteropLibraryGen.WRITE_BUFFER_INT, InteropLibraryGen.READ_BUFFER_LONG, InteropLibraryGen.WRITE_BUFFER_LONG, InteropLibraryGen.READ_BUFFER_FLOAT, InteropLibraryGen.WRITE_BUFFER_FLOAT, InteropLibraryGen.READ_BUFFER_DOUBLE, InteropLibraryGen.WRITE_BUFFER_DOUBLE, InteropLibraryGen.IS_POINTER, InteropLibraryGen.AS_POINTER, InteropLibraryGen.TO_NATIVE, InteropLibraryGen.AS_INSTANT, InteropLibraryGen.IS_TIME_ZONE, InteropLibraryGen.AS_TIME_ZONE, InteropLibraryGen.IS_DATE, InteropLibraryGen.AS_DATE, InteropLibraryGen.IS_TIME, InteropLibraryGen.AS_TIME, InteropLibraryGen.IS_DURATION, InteropLibraryGen.AS_DURATION, InteropLibraryGen.IS_EXCEPTION, InteropLibraryGen.THROW_EXCEPTION, InteropLibraryGen.GET_EXCEPTION_TYPE, InteropLibraryGen.IS_EXCEPTION_INCOMPLETE_SOURCE, InteropLibraryGen.GET_EXCEPTION_EXIT_STATUS, InteropLibraryGen.HAS_EXCEPTION_CAUSE, InteropLibraryGen.GET_EXCEPTION_CAUSE, InteropLibraryGen.HAS_EXCEPTION_MESSAGE, InteropLibraryGen.GET_EXCEPTION_MESSAGE, InteropLibraryGen.HAS_EXCEPTION_STACK_TRACE, InteropLibraryGen.GET_EXCEPTION_STACK_TRACE, InteropLibraryGen.HAS_ITERATOR, InteropLibraryGen.GET_ITERATOR, InteropLibraryGen.IS_ITERATOR, InteropLibraryGen.HAS_ITERATOR_NEXT_ELEMENT, InteropLibraryGen.GET_ITERATOR_NEXT_ELEMENT, InteropLibraryGen.HAS_SOURCE_LOCATION, InteropLibraryGen.GET_SOURCE_LOCATION, InteropLibraryGen.HAS_LANGUAGE, InteropLibraryGen.GET_LANGUAGE, InteropLibraryGen.HAS_META_OBJECT, InteropLibraryGen.GET_META_OBJECT, InteropLibraryGen.TO_DISPLAY_STRING, InteropLibraryGen.IS_META_OBJECT, InteropLibraryGen.GET_META_QUALIFIED_NAME, InteropLibraryGen.GET_META_SIMPLE_NAME, InteropLibraryGen.IS_META_INSTANCE, InteropLibraryGen.IS_IDENTICAL_OR_UNDEFINED, InteropLibraryGen.IS_IDENTICAL, InteropLibraryGen.IDENTITY_HASH_CODE, InteropLibraryGen.IS_SCOPE, InteropLibraryGen.HAS_SCOPE_PARENT, InteropLibraryGen.GET_SCOPE_PARENT)));
    }

    @Override
    protected Class<?> getDefaultClass(Object receiver) {
        if (receiver instanceof Boolean) {
            return DefaultBooleanExports.class;
        } else if (receiver instanceof Integer) {
            return DefaultIntegerExports.class;
        } else if (receiver instanceof Byte) {
            return DefaultByteExports.class;
        } else if (receiver instanceof Short) {
            return DefaultShortExports.class;
        } else if (receiver instanceof Long) {
            return DefaultLongExports.class;
        } else if (receiver instanceof Float) {
            return DefaultFloatExports.class;
        } else if (receiver instanceof Double) {
            return DefaultDoubleExports.class;
        } else if (receiver instanceof Character) {
            return DefaultCharacterExports.class;
        } else if (receiver instanceof String) {
            return DefaultStringExports.class;
        } else {
            return InteropLibrary.class;
        }
    }

    @Override
    protected InteropLibrary createAssertions(InteropLibrary delegate) {
        return new Asserts(delegate);
    }

    @Override
    protected InteropLibrary createProxy(ReflectionLibrary library) {
        return new Proxy(library);
    }

    @Override
    protected FinalBitSet createMessageBitSet(Message... messages) {
        BitSet bitSet = new BitSet(2);
        for (Message message : messages) {
            bitSet.set(((MessageImpl) message).index);
        }
        return FinalBitSet.valueOf(bitSet);
    }

    @Override
    protected InteropLibrary createDelegate(InteropLibrary delegateLibrary) {
        return new Delegate(delegateLibrary);
    }

    @Override
    protected Object genericDispatch(Library originalLib, Object receiver, Message message, Object[] args, int offset) throws Exception {
        InteropLibrary lib = (InteropLibrary) originalLib;
        MessageImpl messageImpl = (MessageImpl) message;
        if (messageImpl.getParameterCount() - 1 != args.length - offset) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Invalid number of arguments.");
        }
        switch (messageImpl.index) {
            case 0 :
                return lib.isNull(receiver);
            case 1 :
                return lib.isBoolean(receiver);
            case 2 :
                return lib.asBoolean(receiver);
            case 3 :
                return lib.isExecutable(receiver);
            case 4 :
                return lib.execute(receiver, (Object[]) args[offset]);
            case 5 :
                return lib.hasExecutableName(receiver);
            case 6 :
                return lib.getExecutableName(receiver);
            case 7 :
                return lib.hasDeclaringMetaObject(receiver);
            case 8 :
                return lib.getDeclaringMetaObject(receiver);
            case 9 :
                return lib.isInstantiable(receiver);
            case 10 :
                return lib.instantiate(receiver, (Object[]) args[offset]);
            case 11 :
                return lib.isString(receiver);
            case 12 :
                return lib.asString(receiver);
            case 13 :
                return lib.isNumber(receiver);
            case 14 :
                return lib.fitsInByte(receiver);
            case 15 :
                return lib.fitsInShort(receiver);
            case 16 :
                return lib.fitsInInt(receiver);
            case 17 :
                return lib.fitsInLong(receiver);
            case 18 :
                return lib.fitsInFloat(receiver);
            case 19 :
                return lib.fitsInDouble(receiver);
            case 20 :
                return lib.asByte(receiver);
            case 21 :
                return lib.asShort(receiver);
            case 22 :
                return lib.asInt(receiver);
            case 23 :
                return lib.asLong(receiver);
            case 24 :
                return lib.asFloat(receiver);
            case 25 :
                return lib.asDouble(receiver);
            case 26 :
                return lib.hasMembers(receiver);
            case 27 :
                return lib.getMembers(receiver, (boolean) args[offset]);
            case 28 :
                return lib.isMemberReadable(receiver, (String) args[offset]);
            case 29 :
                return lib.readMember(receiver, (String) args[offset]);
            case 30 :
                return lib.isMemberModifiable(receiver, (String) args[offset]);
            case 31 :
                return lib.isMemberInsertable(receiver, (String) args[offset]);
            case 32 :
                lib.writeMember(receiver, (String) args[offset], args[offset + 1]);
                return null;
            case 33 :
                return lib.isMemberRemovable(receiver, (String) args[offset]);
            case 34 :
                lib.removeMember(receiver, (String) args[offset]);
                return null;
            case 35 :
                return lib.isMemberInvocable(receiver, (String) args[offset]);
            case 36 :
                return lib.invokeMember(receiver, (String) args[offset], (Object[]) args[offset + 1]);
            case 37 :
                return lib.isMemberInternal(receiver, (String) args[offset]);
            case 38 :
                return lib.hasMemberReadSideEffects(receiver, (String) args[offset]);
            case 39 :
                return lib.hasMemberWriteSideEffects(receiver, (String) args[offset]);
            case 40 :
                return lib.hasHashEntries(receiver);
            case 41 :
                return lib.getHashSize(receiver);
            case 42 :
                return lib.isHashEntryReadable(receiver, args[offset]);
            case 43 :
                return lib.readHashValue(receiver, args[offset]);
            case 44 :
                return lib.readHashValueOrDefault(receiver, args[offset], args[offset + 1]);
            case 45 :
                return lib.isHashEntryModifiable(receiver, args[offset]);
            case 46 :
                return lib.isHashEntryInsertable(receiver, args[offset]);
            case 47 :
                return lib.isHashEntryWritable(receiver, args[offset]);
            case 48 :
                lib.writeHashEntry(receiver, args[offset], args[offset + 1]);
                return null;
            case 49 :
                return lib.isHashEntryRemovable(receiver, args[offset]);
            case 50 :
                lib.removeHashEntry(receiver, args[offset]);
                return null;
            case 51 :
                return lib.isHashEntryExisting(receiver, args[offset]);
            case 52 :
                return lib.getHashEntriesIterator(receiver);
            case 53 :
                return lib.getHashKeysIterator(receiver);
            case 54 :
                return lib.getHashValuesIterator(receiver);
            case 55 :
                return lib.hasArrayElements(receiver);
            case 56 :
                return lib.readArrayElement(receiver, (long) args[offset]);
            case 57 :
                return lib.getArraySize(receiver);
            case 58 :
                return lib.isArrayElementReadable(receiver, (long) args[offset]);
            case 59 :
                lib.writeArrayElement(receiver, (long) args[offset], args[offset + 1]);
                return null;
            case 60 :
                lib.removeArrayElement(receiver, (long) args[offset]);
                return null;
            case 61 :
                return lib.isArrayElementModifiable(receiver, (long) args[offset]);
            case 62 :
                return lib.isArrayElementInsertable(receiver, (long) args[offset]);
            case 63 :
                return lib.isArrayElementRemovable(receiver, (long) args[offset]);
            case 64 :
                return lib.hasBufferElements(receiver);
            case 65 :
                return lib.isBufferWritable(receiver);
            case 66 :
                return lib.getBufferSize(receiver);
            case 67 :
                return lib.readBufferByte(receiver, (long) args[offset]);
            case 68 :
                lib.writeBufferByte(receiver, (long) args[offset], (byte) args[offset + 1]);
                return null;
            case 69 :
                return lib.readBufferShort(receiver, (ByteOrder) args[offset], (long) args[offset + 1]);
            case 70 :
                lib.writeBufferShort(receiver, (ByteOrder) args[offset], (long) args[offset + 1], (short) args[offset + 2]);
                return null;
            case 71 :
                return lib.readBufferInt(receiver, (ByteOrder) args[offset], (long) args[offset + 1]);
            case 72 :
                lib.writeBufferInt(receiver, (ByteOrder) args[offset], (long) args[offset + 1], (int) args[offset + 2]);
                return null;
            case 73 :
                return lib.readBufferLong(receiver, (ByteOrder) args[offset], (long) args[offset + 1]);
            case 74 :
                lib.writeBufferLong(receiver, (ByteOrder) args[offset], (long) args[offset + 1], (long) args[offset + 2]);
                return null;
            case 75 :
                return lib.readBufferFloat(receiver, (ByteOrder) args[offset], (long) args[offset + 1]);
            case 76 :
                lib.writeBufferFloat(receiver, (ByteOrder) args[offset], (long) args[offset + 1], (float) args[offset + 2]);
                return null;
            case 77 :
                return lib.readBufferDouble(receiver, (ByteOrder) args[offset], (long) args[offset + 1]);
            case 78 :
                lib.writeBufferDouble(receiver, (ByteOrder) args[offset], (long) args[offset + 1], (double) args[offset + 2]);
                return null;
            case 79 :
                return lib.isPointer(receiver);
            case 80 :
                return lib.asPointer(receiver);
            case 81 :
                lib.toNative(receiver);
                return null;
            case 82 :
                return lib.asInstant(receiver);
            case 83 :
                return lib.isTimeZone(receiver);
            case 84 :
                return lib.asTimeZone(receiver);
            case 85 :
                return lib.isDate(receiver);
            case 86 :
                return lib.asDate(receiver);
            case 87 :
                return lib.isTime(receiver);
            case 88 :
                return lib.asTime(receiver);
            case 89 :
                return lib.isDuration(receiver);
            case 90 :
                return lib.asDuration(receiver);
            case 91 :
                return lib.isException(receiver);
            case 92 :
                return lib.throwException(receiver);
            case 93 :
                return lib.getExceptionType(receiver);
            case 94 :
                return lib.isExceptionIncompleteSource(receiver);
            case 95 :
                return lib.getExceptionExitStatus(receiver);
            case 96 :
                return lib.hasExceptionCause(receiver);
            case 97 :
                return lib.getExceptionCause(receiver);
            case 98 :
                return lib.hasExceptionMessage(receiver);
            case 99 :
                return lib.getExceptionMessage(receiver);
            case 100 :
                return lib.hasExceptionStackTrace(receiver);
            case 101 :
                return lib.getExceptionStackTrace(receiver);
            case 102 :
                return lib.hasIterator(receiver);
            case 103 :
                return lib.getIterator(receiver);
            case 104 :
                return lib.isIterator(receiver);
            case 105 :
                return lib.hasIteratorNextElement(receiver);
            case 106 :
                return lib.getIteratorNextElement(receiver);
            case 107 :
                return lib.hasSourceLocation(receiver);
            case 108 :
                return lib.getSourceLocation(receiver);
            case 109 :
                return lib.hasLanguage(receiver);
            case 110 :
                return lib.getLanguage(receiver);
            case 111 :
                return lib.hasMetaObject(receiver);
            case 112 :
                return lib.getMetaObject(receiver);
            case 113 :
                return lib.toDisplayString(receiver, (boolean) args[offset]);
            case 114 :
                return lib.isMetaObject(receiver);
            case 115 :
                return lib.getMetaQualifiedName(receiver);
            case 116 :
                return lib.getMetaSimpleName(receiver);
            case 117 :
                return lib.isMetaInstance(receiver, args[offset]);
            case 118 :
                return lib.isIdenticalOrUndefined(receiver, args[offset]);
            case 119 :
                return lib.isIdentical(receiver, args[offset], (InteropLibrary) args[offset + 1]);
            case 120 :
                return lib.identityHashCode(receiver);
            case 121 :
                return lib.isScope(receiver);
            case 122 :
                return lib.hasScopeParent(receiver);
            case 123 :
                return lib.getScopeParent(receiver);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new AbstractMethodError(message.toString());
    }

    @Override
    protected InteropLibrary createDispatchImpl(int limit) {
        return new CachedDispatchFirst(null, null, limit);
    }

    @Override
    protected InteropLibrary createUncachedDispatch() {
        return new UncachedDispatch();
    }

    @SuppressWarnings("unchecked")
    private static Class<InteropLibrary> lazyLibraryClass() {
        try {
            return (Class<InteropLibrary>) Class.forName("com.oracle.truffle.api.interop.InteropLibrary", false, InteropLibraryGen.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw CompilerDirectives.shouldNotReachHere(e);
        }
    }

    @GeneratedBy(InteropLibrary.class)
    private static final class Default extends LibraryExport<InteropLibrary> {

        private Default() {
            super(InteropLibrary.class, Object.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            return new Cached(receiver);
        }

        @GeneratedBy(InteropLibrary.class)
        private static final class Cached extends InteropLibrary {

            @Child private DynamicDispatchLibrary dynamicDispatch_;
            private final Class<?> dynamicDispatchTarget_;

            protected Cached(Object receiver) {
                this.dynamicDispatch_ = insert(DYNAMIC_DISPATCH_LIBRARY_.create(receiver));
                this.dynamicDispatchTarget_ = DYNAMIC_DISPATCH_LIBRARY_.getUncached(receiver).dispatch(receiver);
            }

            @Override
            public boolean accepts(Object receiver) {
                return dynamicDispatch_.accepts(receiver) && dynamicDispatch_.dispatch(receiver) == dynamicDispatchTarget_;
            }

            @Override
            public boolean isNull(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isNull((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isBoolean(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isBoolean((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean asBoolean(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asBoolean((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isExecutable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isExecutable((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object execute(Object receiver, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.execute((dynamicDispatch_.cast(receiver)), arguments);
            }

            @Override
            public boolean hasExecutableName(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasExecutableName((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getExecutableName(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getExecutableName((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean hasDeclaringMetaObject(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasDeclaringMetaObject((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getDeclaringMetaObject(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getDeclaringMetaObject((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isInstantiable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isInstantiable((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object instantiate(Object receiver, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.instantiate((dynamicDispatch_.cast(receiver)), arguments);
            }

            @Override
            public boolean isString(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isString((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public String asString(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asString((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isNumber(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isNumber((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean fitsInByte(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.fitsInByte((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean fitsInShort(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.fitsInShort((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean fitsInInt(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.fitsInInt((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean fitsInLong(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.fitsInLong((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean fitsInFloat(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.fitsInFloat((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean fitsInDouble(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.fitsInDouble((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public byte asByte(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asByte((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public short asShort(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asShort((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public int asInt(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asInt((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public long asLong(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asLong((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public float asFloat(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asFloat((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public double asDouble(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asDouble((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasMembers((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getMembers((dynamicDispatch_.cast(receiver)), includeInternal);
            }

            @Override
            public boolean isMemberReadable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMemberReadable((dynamicDispatch_.cast(receiver)), member);
            }

            @Override
            public Object readMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readMember((dynamicDispatch_.cast(receiver)), member);
            }

            @Override
            public boolean isMemberModifiable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMemberModifiable((dynamicDispatch_.cast(receiver)), member);
            }

            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMemberInsertable((dynamicDispatch_.cast(receiver)), member);
            }

            @Override
            public void writeMember(Object receiver, String member, Object value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeMember((dynamicDispatch_.cast(receiver)), member, value);
                return;
            }

            @Override
            public boolean isMemberRemovable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMemberRemovable((dynamicDispatch_.cast(receiver)), member);
            }

            @Override
            public void removeMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.removeMember((dynamicDispatch_.cast(receiver)), member);
                return;
            }

            @Override
            public boolean isMemberInvocable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMemberInvocable((dynamicDispatch_.cast(receiver)), member);
            }

            @Override
            public Object invokeMember(Object receiver, String member, Object... arguments) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.invokeMember((dynamicDispatch_.cast(receiver)), member, arguments);
            }

            @Override
            public boolean isMemberInternal(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMemberInternal((dynamicDispatch_.cast(receiver)), member);
            }

            @Override
            public boolean hasMemberReadSideEffects(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasMemberReadSideEffects((dynamicDispatch_.cast(receiver)), member);
            }

            @Override
            public boolean hasMemberWriteSideEffects(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasMemberWriteSideEffects((dynamicDispatch_.cast(receiver)), member);
            }

            @Override
            public boolean hasHashEntries(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasHashEntries((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public long getHashSize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getHashSize((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isHashEntryReadable(Object receiver, Object key) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isHashEntryReadable((dynamicDispatch_.cast(receiver)), key);
            }

            @Override
            public Object readHashValue(Object receiver, Object key) throws UnsupportedMessageException, UnknownKeyException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readHashValue((dynamicDispatch_.cast(receiver)), key);
            }

            @Override
            public Object readHashValueOrDefault(Object receiver, Object key, Object defaultValue) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readHashValueOrDefault((dynamicDispatch_.cast(receiver)), key, defaultValue);
            }

            @Override
            public boolean isHashEntryModifiable(Object receiver, Object key) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isHashEntryModifiable((dynamicDispatch_.cast(receiver)), key);
            }

            @Override
            public boolean isHashEntryInsertable(Object receiver, Object key) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isHashEntryInsertable((dynamicDispatch_.cast(receiver)), key);
            }

            @Override
            public boolean isHashEntryWritable(Object receiver, Object key) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isHashEntryWritable((dynamicDispatch_.cast(receiver)), key);
            }

            @Override
            public void writeHashEntry(Object receiver, Object key, Object value) throws UnsupportedMessageException, UnknownKeyException, UnsupportedTypeException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeHashEntry((dynamicDispatch_.cast(receiver)), key, value);
                return;
            }

            @Override
            public boolean isHashEntryRemovable(Object receiver, Object key) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isHashEntryRemovable((dynamicDispatch_.cast(receiver)), key);
            }

            @Override
            public void removeHashEntry(Object receiver, Object key) throws UnsupportedMessageException, UnknownKeyException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.removeHashEntry((dynamicDispatch_.cast(receiver)), key);
                return;
            }

            @Override
            public boolean isHashEntryExisting(Object receiver, Object key) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isHashEntryExisting((dynamicDispatch_.cast(receiver)), key);
            }

            @Override
            public Object getHashEntriesIterator(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getHashEntriesIterator((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getHashKeysIterator(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getHashKeysIterator((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getHashValuesIterator(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getHashValuesIterator((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasArrayElements((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object readArrayElement(Object receiver, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readArrayElement((dynamicDispatch_.cast(receiver)), index);
            }

            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getArraySize((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isArrayElementReadable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isArrayElementReadable((dynamicDispatch_.cast(receiver)), index);
            }

            @Override
            public void writeArrayElement(Object receiver, long index, Object value) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeArrayElement((dynamicDispatch_.cast(receiver)), index, value);
                return;
            }

            @Override
            public void removeArrayElement(Object receiver, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.removeArrayElement((dynamicDispatch_.cast(receiver)), index);
                return;
            }

            @Override
            public boolean isArrayElementModifiable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isArrayElementModifiable((dynamicDispatch_.cast(receiver)), index);
            }

            @Override
            public boolean isArrayElementInsertable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isArrayElementInsertable((dynamicDispatch_.cast(receiver)), index);
            }

            @Override
            public boolean isArrayElementRemovable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isArrayElementRemovable((dynamicDispatch_.cast(receiver)), index);
            }

            @Override
            public boolean hasBufferElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasBufferElements((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isBufferWritable(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isBufferWritable((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public long getBufferSize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getBufferSize((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public byte readBufferByte(Object receiver, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readBufferByte((dynamicDispatch_.cast(receiver)), byteOffset);
            }

            @Override
            public void writeBufferByte(Object receiver, long byteOffset, byte value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeBufferByte((dynamicDispatch_.cast(receiver)), byteOffset, value);
                return;
            }

            @Override
            public short readBufferShort(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readBufferShort((dynamicDispatch_.cast(receiver)), order, byteOffset);
            }

            @Override
            public void writeBufferShort(Object receiver, ByteOrder order, long byteOffset, short value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeBufferShort((dynamicDispatch_.cast(receiver)), order, byteOffset, value);
                return;
            }

            @Override
            public int readBufferInt(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readBufferInt((dynamicDispatch_.cast(receiver)), order, byteOffset);
            }

            @Override
            public void writeBufferInt(Object receiver, ByteOrder order, long byteOffset, int value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeBufferInt((dynamicDispatch_.cast(receiver)), order, byteOffset, value);
                return;
            }

            @Override
            public long readBufferLong(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readBufferLong((dynamicDispatch_.cast(receiver)), order, byteOffset);
            }

            @Override
            public void writeBufferLong(Object receiver, ByteOrder order, long byteOffset, long value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeBufferLong((dynamicDispatch_.cast(receiver)), order, byteOffset, value);
                return;
            }

            @Override
            public float readBufferFloat(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readBufferFloat((dynamicDispatch_.cast(receiver)), order, byteOffset);
            }

            @Override
            public void writeBufferFloat(Object receiver, ByteOrder order, long byteOffset, float value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeBufferFloat((dynamicDispatch_.cast(receiver)), order, byteOffset, value);
                return;
            }

            @Override
            public double readBufferDouble(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readBufferDouble((dynamicDispatch_.cast(receiver)), order, byteOffset);
            }

            @Override
            public void writeBufferDouble(Object receiver, ByteOrder order, long byteOffset, double value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeBufferDouble((dynamicDispatch_.cast(receiver)), order, byteOffset, value);
                return;
            }

            @Override
            public boolean isPointer(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isPointer((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public long asPointer(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asPointer((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public void toNative(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.toNative((dynamicDispatch_.cast(receiver)));
                return;
            }

            @Override
            public Instant asInstant(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asInstant((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isTimeZone(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isTimeZone((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public ZoneId asTimeZone(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asTimeZone((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isDate(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isDate((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public LocalDate asDate(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asDate((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isTime(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isTime((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public LocalTime asTime(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asTime((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isDuration(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isDuration((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Duration asDuration(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asDuration((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isException(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isException((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public RuntimeException throwException(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.throwException((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public ExceptionType getExceptionType(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getExceptionType((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isExceptionIncompleteSource(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isExceptionIncompleteSource((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public int getExceptionExitStatus(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getExceptionExitStatus((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean hasExceptionCause(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasExceptionCause((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getExceptionCause(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getExceptionCause((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean hasExceptionMessage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasExceptionMessage((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getExceptionMessage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getExceptionMessage((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean hasExceptionStackTrace(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasExceptionStackTrace((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getExceptionStackTrace(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getExceptionStackTrace((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean hasIterator(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasIterator((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getIterator(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getIterator((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isIterator(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isIterator((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean hasIteratorNextElement(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasIteratorNextElement((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getIteratorNextElement(Object receiver) throws UnsupportedMessageException, StopIterationException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getIteratorNextElement((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean hasSourceLocation(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasSourceLocation((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public SourceSection getSourceLocation(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getSourceLocation((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasLanguage((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getLanguage((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean hasMetaObject(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasMetaObject((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getMetaObject((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.toDisplayString((dynamicDispatch_.cast(receiver)), allowSideEffects);
            }

            @Override
            public boolean isMetaObject(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMetaObject((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getMetaQualifiedName(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getMetaQualifiedName((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getMetaSimpleName(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getMetaSimpleName((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isMetaInstance(Object receiver, Object instance) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMetaInstance((dynamicDispatch_.cast(receiver)), instance);
            }

            @Override
            protected TriState isIdenticalOrUndefined(Object receiver, Object other) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isIdenticalOrUndefined((dynamicDispatch_.cast(receiver)), other);
            }

            @Override
            public boolean isIdentical(Object receiver, Object other, InteropLibrary otherInterop) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isIdentical((dynamicDispatch_.cast(receiver)), other, otherInterop);
            }

            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.identityHashCode((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isScope(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isScope((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean hasScopeParent(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasScopeParent((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public Object getScopeParent(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getScopeParent((dynamicDispatch_.cast(receiver)));
            }

        }
        @GeneratedBy(InteropLibrary.class)
        private static final class Uncached extends InteropLibrary {

            @Child private DynamicDispatchLibrary dynamicDispatch_;
            private final Class<?> dynamicDispatchTarget_;

            protected Uncached(Object receiver) {
                this.dynamicDispatch_ = DYNAMIC_DISPATCH_LIBRARY_.getUncached(receiver);
                this.dynamicDispatchTarget_ = dynamicDispatch_.dispatch(receiver);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                return dynamicDispatch_.accepts(receiver) && dynamicDispatch_.dispatch(receiver) == dynamicDispatchTarget_;
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
            public boolean isNull(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isNull(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isBoolean(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isBoolean(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean asBoolean(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asBoolean(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isExecutable(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isExecutable(receiver);
            }

            @TruffleBoundary
            @Override
            public Object execute(Object receiver, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.execute(receiver, arguments);
            }

            @TruffleBoundary
            @Override
            public boolean hasExecutableName(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasExecutableName(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getExecutableName(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getExecutableName(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasDeclaringMetaObject(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasDeclaringMetaObject(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getDeclaringMetaObject(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getDeclaringMetaObject(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isInstantiable(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isInstantiable(receiver);
            }

            @TruffleBoundary
            @Override
            public Object instantiate(Object receiver, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.instantiate(receiver, arguments);
            }

            @TruffleBoundary
            @Override
            public boolean isString(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isString(receiver);
            }

            @TruffleBoundary
            @Override
            public String asString(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asString(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isNumber(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isNumber(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean fitsInByte(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.fitsInByte(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean fitsInShort(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.fitsInShort(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean fitsInInt(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.fitsInInt(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean fitsInLong(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.fitsInLong(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean fitsInFloat(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.fitsInFloat(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean fitsInDouble(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.fitsInDouble(receiver);
            }

            @TruffleBoundary
            @Override
            public byte asByte(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asByte(receiver);
            }

            @TruffleBoundary
            @Override
            public short asShort(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asShort(receiver);
            }

            @TruffleBoundary
            @Override
            public int asInt(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asInt(receiver);
            }

            @TruffleBoundary
            @Override
            public long asLong(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asLong(receiver);
            }

            @TruffleBoundary
            @Override
            public float asFloat(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asFloat(receiver);
            }

            @TruffleBoundary
            @Override
            public double asDouble(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asDouble(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasMembers(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getMembers(receiver, includeInternal);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMemberReadable(receiver, member);
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readMember(receiver, member);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMemberModifiable(receiver, member);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMemberInsertable(receiver, member);
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object receiver, String member, Object value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeMember(receiver, member, value);
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isMemberRemovable(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMemberRemovable(receiver, member);
            }

            @TruffleBoundary
            @Override
            public void removeMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.removeMember(receiver, member);
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMemberInvocable(receiver, member);
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object receiver, String member, Object... arguments) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.invokeMember(receiver, member, arguments);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInternal(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMemberInternal(receiver, member);
            }

            @TruffleBoundary
            @Override
            public boolean hasMemberReadSideEffects(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasMemberReadSideEffects(receiver, member);
            }

            @TruffleBoundary
            @Override
            public boolean hasMemberWriteSideEffects(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasMemberWriteSideEffects(receiver, member);
            }

            @TruffleBoundary
            @Override
            public boolean hasHashEntries(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasHashEntries(receiver);
            }

            @TruffleBoundary
            @Override
            public long getHashSize(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getHashSize(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryReadable(Object receiver, Object key) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isHashEntryReadable(receiver, key);
            }

            @TruffleBoundary
            @Override
            public Object readHashValue(Object receiver, Object key) throws UnsupportedMessageException, UnknownKeyException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readHashValue(receiver, key);
            }

            @TruffleBoundary
            @Override
            public Object readHashValueOrDefault(Object receiver, Object key, Object defaultValue) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readHashValueOrDefault(receiver, key, defaultValue);
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryModifiable(Object receiver, Object key) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isHashEntryModifiable(receiver, key);
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryInsertable(Object receiver, Object key) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isHashEntryInsertable(receiver, key);
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryWritable(Object receiver, Object key) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isHashEntryWritable(receiver, key);
            }

            @TruffleBoundary
            @Override
            public void writeHashEntry(Object receiver, Object key, Object value) throws UnsupportedMessageException, UnknownKeyException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeHashEntry(receiver, key, value);
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryRemovable(Object receiver, Object key) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isHashEntryRemovable(receiver, key);
            }

            @TruffleBoundary
            @Override
            public void removeHashEntry(Object receiver, Object key) throws UnsupportedMessageException, UnknownKeyException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.removeHashEntry(receiver, key);
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isHashEntryExisting(Object receiver, Object key) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isHashEntryExisting(receiver, key);
            }

            @TruffleBoundary
            @Override
            public Object getHashEntriesIterator(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getHashEntriesIterator(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getHashKeysIterator(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getHashKeysIterator(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getHashValuesIterator(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getHashValuesIterator(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasArrayElements(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasArrayElements(receiver);
            }

            @TruffleBoundary
            @Override
            public Object readArrayElement(Object receiver, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readArrayElement(receiver, index);
            }

            @TruffleBoundary
            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getArraySize(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementReadable(Object receiver, long index) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isArrayElementReadable(receiver, index);
            }

            @TruffleBoundary
            @Override
            public void writeArrayElement(Object receiver, long index, Object value) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeArrayElement(receiver, index, value);
                return;
            }

            @TruffleBoundary
            @Override
            public void removeArrayElement(Object receiver, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.removeArrayElement(receiver, index);
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementModifiable(Object receiver, long index) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isArrayElementModifiable(receiver, index);
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementInsertable(Object receiver, long index) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isArrayElementInsertable(receiver, index);
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementRemovable(Object receiver, long index) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isArrayElementRemovable(receiver, index);
            }

            @TruffleBoundary
            @Override
            public boolean hasBufferElements(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasBufferElements(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isBufferWritable(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isBufferWritable(receiver);
            }

            @TruffleBoundary
            @Override
            public long getBufferSize(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getBufferSize(receiver);
            }

            @TruffleBoundary
            @Override
            public byte readBufferByte(Object receiver, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readBufferByte(receiver, byteOffset);
            }

            @TruffleBoundary
            @Override
            public void writeBufferByte(Object receiver, long byteOffset, byte value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeBufferByte(receiver, byteOffset, value);
                return;
            }

            @TruffleBoundary
            @Override
            public short readBufferShort(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readBufferShort(receiver, order, byteOffset);
            }

            @TruffleBoundary
            @Override
            public void writeBufferShort(Object receiver, ByteOrder order, long byteOffset, short value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeBufferShort(receiver, order, byteOffset, value);
                return;
            }

            @TruffleBoundary
            @Override
            public int readBufferInt(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readBufferInt(receiver, order, byteOffset);
            }

            @TruffleBoundary
            @Override
            public void writeBufferInt(Object receiver, ByteOrder order, long byteOffset, int value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeBufferInt(receiver, order, byteOffset, value);
                return;
            }

            @TruffleBoundary
            @Override
            public long readBufferLong(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readBufferLong(receiver, order, byteOffset);
            }

            @TruffleBoundary
            @Override
            public void writeBufferLong(Object receiver, ByteOrder order, long byteOffset, long value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeBufferLong(receiver, order, byteOffset, value);
                return;
            }

            @TruffleBoundary
            @Override
            public float readBufferFloat(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readBufferFloat(receiver, order, byteOffset);
            }

            @TruffleBoundary
            @Override
            public void writeBufferFloat(Object receiver, ByteOrder order, long byteOffset, float value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeBufferFloat(receiver, order, byteOffset, value);
                return;
            }

            @TruffleBoundary
            @Override
            public double readBufferDouble(Object receiver, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.readBufferDouble(receiver, order, byteOffset);
            }

            @TruffleBoundary
            @Override
            public void writeBufferDouble(Object receiver, ByteOrder order, long byteOffset, double value) throws UnsupportedMessageException, InvalidBufferOffsetException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.writeBufferDouble(receiver, order, byteOffset, value);
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isPointer(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isPointer(receiver);
            }

            @TruffleBoundary
            @Override
            public long asPointer(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asPointer(receiver);
            }

            @TruffleBoundary
            @Override
            public void toNative(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                super.toNative(receiver);
                return;
            }

            @TruffleBoundary
            @Override
            public Instant asInstant(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asInstant(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isTimeZone(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isTimeZone(receiver);
            }

            @TruffleBoundary
            @Override
            public ZoneId asTimeZone(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asTimeZone(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isDate(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isDate(receiver);
            }

            @TruffleBoundary
            @Override
            public LocalDate asDate(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asDate(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isTime(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isTime(receiver);
            }

            @TruffleBoundary
            @Override
            public LocalTime asTime(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asTime(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isDuration(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isDuration(receiver);
            }

            @TruffleBoundary
            @Override
            public Duration asDuration(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.asDuration(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isException(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isException(receiver);
            }

            @TruffleBoundary
            @Override
            public RuntimeException throwException(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.throwException(receiver);
            }

            @TruffleBoundary
            @Override
            public ExceptionType getExceptionType(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getExceptionType(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isExceptionIncompleteSource(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isExceptionIncompleteSource(receiver);
            }

            @TruffleBoundary
            @Override
            public int getExceptionExitStatus(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getExceptionExitStatus(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasExceptionCause(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasExceptionCause(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getExceptionCause(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getExceptionCause(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasExceptionMessage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasExceptionMessage(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getExceptionMessage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getExceptionMessage(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasExceptionStackTrace(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasExceptionStackTrace(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getExceptionStackTrace(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getExceptionStackTrace(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasIterator(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasIterator(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getIterator(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getIterator(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isIterator(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isIterator(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasIteratorNextElement(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasIteratorNextElement(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getIteratorNextElement(Object receiver) throws UnsupportedMessageException, StopIterationException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getIteratorNextElement(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasSourceLocation(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasSourceLocation(receiver);
            }

            @TruffleBoundary
            @Override
            public SourceSection getSourceLocation(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getSourceLocation(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasLanguage(receiver);
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getLanguage(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasMetaObject(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasMetaObject(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getMetaObject(receiver);
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.toDisplayString(receiver, allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public boolean isMetaObject(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMetaObject(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getMetaQualifiedName(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getMetaQualifiedName(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getMetaSimpleName(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getMetaSimpleName(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isMetaInstance(Object receiver, Object instance) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isMetaInstance(receiver, instance);
            }

            @TruffleBoundary
            @Override
            protected TriState isIdenticalOrUndefined(Object receiver, Object other) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isIdenticalOrUndefined(receiver, other);
            }

            @TruffleBoundary
            @Override
            public boolean isIdentical(Object receiver, Object other, InteropLibrary otherInterop) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isIdentical(receiver, other, otherInterop);
            }

            @TruffleBoundary
            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.identityHashCode(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean isScope(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isScope(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean hasScopeParent(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.hasScopeParent(receiver);
            }

            @TruffleBoundary
            @Override
            public Object getScopeParent(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.getScopeParent(receiver);
            }

        }
    }
    @GeneratedBy(InteropLibrary.class)
    private static class MessageImpl extends Message {

        final int index;

        MessageImpl(String name, int index, Class<?> returnType, Class<?>... parameters) {
            super(InteropLibraryGen.LIBRARY_CLASS, name, returnType, parameters);
            this.index = index;
        }

    }
    @GeneratedBy(InteropLibrary.class)
    private static final class Proxy extends InteropLibrary {

        @Child private ReflectionLibrary lib;

        Proxy(ReflectionLibrary lib) {
            this.lib = lib;
        }

        @Override
        public boolean isNull(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_NULL);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isBoolean(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_BOOLEAN);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean asBoolean(Object receiver_) throws UnsupportedMessageException {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.AS_BOOLEAN);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isExecutable(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_EXECUTABLE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object execute(Object receiver_, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.EXECUTE, (Object) arguments);
            } catch (UnsupportedTypeException | ArityException | UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasExecutableName(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_EXECUTABLE_NAME);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getExecutableName(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_EXECUTABLE_NAME);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasDeclaringMetaObject(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_DECLARING_META_OBJECT);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getDeclaringMetaObject(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_DECLARING_META_OBJECT);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isInstantiable(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_INSTANTIABLE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object instantiate(Object receiver_, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.INSTANTIATE, (Object) arguments);
            } catch (UnsupportedTypeException | ArityException | UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isString(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_STRING);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public String asString(Object receiver_) throws UnsupportedMessageException {
            try {
                return (String) lib.send(receiver_, InteropLibraryGen.AS_STRING);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isNumber(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_NUMBER);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean fitsInByte(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.FITS_IN_BYTE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean fitsInShort(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.FITS_IN_SHORT);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean fitsInInt(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.FITS_IN_INT);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean fitsInLong(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.FITS_IN_LONG);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean fitsInFloat(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.FITS_IN_FLOAT);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean fitsInDouble(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.FITS_IN_DOUBLE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public byte asByte(Object receiver_) throws UnsupportedMessageException {
            try {
                return (byte) lib.send(receiver_, InteropLibraryGen.AS_BYTE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public short asShort(Object receiver_) throws UnsupportedMessageException {
            try {
                return (short) lib.send(receiver_, InteropLibraryGen.AS_SHORT);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public int asInt(Object receiver_) throws UnsupportedMessageException {
            try {
                return (int) lib.send(receiver_, InteropLibraryGen.AS_INT);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public long asLong(Object receiver_) throws UnsupportedMessageException {
            try {
                return (long) lib.send(receiver_, InteropLibraryGen.AS_LONG);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public float asFloat(Object receiver_) throws UnsupportedMessageException {
            try {
                return (float) lib.send(receiver_, InteropLibraryGen.AS_FLOAT);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public double asDouble(Object receiver_) throws UnsupportedMessageException {
            try {
                return (double) lib.send(receiver_, InteropLibraryGen.AS_DOUBLE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasMembers(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_MEMBERS);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getMembers(Object receiver_, boolean includeInternal) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_MEMBERS, includeInternal);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isMemberReadable(Object receiver_, String member) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_MEMBER_READABLE, member);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object readMember(Object receiver_, String member) throws UnsupportedMessageException, UnknownIdentifierException {
            try {
                return lib.send(receiver_, InteropLibraryGen.READ_MEMBER, member);
            } catch (UnsupportedMessageException | UnknownIdentifierException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isMemberModifiable(Object receiver_, String member) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_MEMBER_MODIFIABLE, member);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isMemberInsertable(Object receiver_, String member) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_MEMBER_INSERTABLE, member);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void writeMember(Object receiver_, String member, Object value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
            try {
                lib.send(receiver_, InteropLibraryGen.WRITE_MEMBER, member, value);
                return;
            } catch (UnsupportedMessageException | UnknownIdentifierException | UnsupportedTypeException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isMemberRemovable(Object receiver_, String member) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_MEMBER_REMOVABLE, member);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void removeMember(Object receiver_, String member) throws UnsupportedMessageException, UnknownIdentifierException {
            try {
                lib.send(receiver_, InteropLibraryGen.REMOVE_MEMBER, member);
                return;
            } catch (UnsupportedMessageException | UnknownIdentifierException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isMemberInvocable(Object receiver_, String member) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_MEMBER_INVOCABLE, member);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object invokeMember(Object receiver_, String member, Object... arguments) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
            try {
                return lib.send(receiver_, InteropLibraryGen.INVOKE_MEMBER, member, arguments);
            } catch (UnsupportedMessageException | ArityException | UnknownIdentifierException | UnsupportedTypeException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isMemberInternal(Object receiver_, String member) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_MEMBER_INTERNAL, member);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasMemberReadSideEffects(Object receiver_, String member) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_MEMBER_READ_SIDE_EFFECTS, member);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasMemberWriteSideEffects(Object receiver_, String member) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_MEMBER_WRITE_SIDE_EFFECTS, member);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasHashEntries(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_HASH_ENTRIES);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public long getHashSize(Object receiver_) throws UnsupportedMessageException {
            try {
                return (long) lib.send(receiver_, InteropLibraryGen.GET_HASH_SIZE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isHashEntryReadable(Object receiver_, Object key) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_HASH_ENTRY_READABLE, key);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object readHashValue(Object receiver_, Object key) throws UnsupportedMessageException, UnknownKeyException {
            try {
                return lib.send(receiver_, InteropLibraryGen.READ_HASH_VALUE, key);
            } catch (UnsupportedMessageException | UnknownKeyException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object readHashValueOrDefault(Object receiver_, Object key, Object defaultValue) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.READ_HASH_VALUE_OR_DEFAULT, key, defaultValue);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isHashEntryModifiable(Object receiver_, Object key) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_HASH_ENTRY_MODIFIABLE, key);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isHashEntryInsertable(Object receiver_, Object key) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_HASH_ENTRY_INSERTABLE, key);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isHashEntryWritable(Object receiver_, Object key) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_HASH_ENTRY_WRITABLE, key);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void writeHashEntry(Object receiver_, Object key, Object value) throws UnsupportedMessageException, UnknownKeyException, UnsupportedTypeException {
            try {
                lib.send(receiver_, InteropLibraryGen.WRITE_HASH_ENTRY, key, value);
                return;
            } catch (UnsupportedMessageException | UnknownKeyException | UnsupportedTypeException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isHashEntryRemovable(Object receiver_, Object key) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_HASH_ENTRY_REMOVABLE, key);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void removeHashEntry(Object receiver_, Object key) throws UnsupportedMessageException, UnknownKeyException {
            try {
                lib.send(receiver_, InteropLibraryGen.REMOVE_HASH_ENTRY, key);
                return;
            } catch (UnsupportedMessageException | UnknownKeyException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isHashEntryExisting(Object receiver_, Object key) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_HASH_ENTRY_EXISTING, key);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getHashEntriesIterator(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_HASH_ENTRIES_ITERATOR);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getHashKeysIterator(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_HASH_KEYS_ITERATOR);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getHashValuesIterator(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_HASH_VALUES_ITERATOR);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasArrayElements(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_ARRAY_ELEMENTS);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object readArrayElement(Object receiver_, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
            try {
                return lib.send(receiver_, InteropLibraryGen.READ_ARRAY_ELEMENT, index);
            } catch (UnsupportedMessageException | InvalidArrayIndexException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public long getArraySize(Object receiver_) throws UnsupportedMessageException {
            try {
                return (long) lib.send(receiver_, InteropLibraryGen.GET_ARRAY_SIZE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isArrayElementReadable(Object receiver_, long index) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_ARRAY_ELEMENT_READABLE, index);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void writeArrayElement(Object receiver_, long index, Object value) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
            try {
                lib.send(receiver_, InteropLibraryGen.WRITE_ARRAY_ELEMENT, index, value);
                return;
            } catch (UnsupportedMessageException | UnsupportedTypeException | InvalidArrayIndexException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void removeArrayElement(Object receiver_, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
            try {
                lib.send(receiver_, InteropLibraryGen.REMOVE_ARRAY_ELEMENT, index);
                return;
            } catch (UnsupportedMessageException | InvalidArrayIndexException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isArrayElementModifiable(Object receiver_, long index) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_ARRAY_ELEMENT_MODIFIABLE, index);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isArrayElementInsertable(Object receiver_, long index) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_ARRAY_ELEMENT_INSERTABLE, index);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isArrayElementRemovable(Object receiver_, long index) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_ARRAY_ELEMENT_REMOVABLE, index);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasBufferElements(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_BUFFER_ELEMENTS);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isBufferWritable(Object receiver_) throws UnsupportedMessageException {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_BUFFER_WRITABLE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public long getBufferSize(Object receiver_) throws UnsupportedMessageException {
            try {
                return (long) lib.send(receiver_, InteropLibraryGen.GET_BUFFER_SIZE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public byte readBufferByte(Object receiver_, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            try {
                return (byte) lib.send(receiver_, InteropLibraryGen.READ_BUFFER_BYTE, byteOffset);
            } catch (UnsupportedMessageException | InvalidBufferOffsetException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void writeBufferByte(Object receiver_, long byteOffset, byte value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            try {
                lib.send(receiver_, InteropLibraryGen.WRITE_BUFFER_BYTE, byteOffset, value);
                return;
            } catch (UnsupportedMessageException | InvalidBufferOffsetException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public short readBufferShort(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            try {
                return (short) lib.send(receiver_, InteropLibraryGen.READ_BUFFER_SHORT, order, byteOffset);
            } catch (UnsupportedMessageException | InvalidBufferOffsetException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void writeBufferShort(Object receiver_, ByteOrder order, long byteOffset, short value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            try {
                lib.send(receiver_, InteropLibraryGen.WRITE_BUFFER_SHORT, order, byteOffset, value);
                return;
            } catch (UnsupportedMessageException | InvalidBufferOffsetException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public int readBufferInt(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            try {
                return (int) lib.send(receiver_, InteropLibraryGen.READ_BUFFER_INT, order, byteOffset);
            } catch (UnsupportedMessageException | InvalidBufferOffsetException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void writeBufferInt(Object receiver_, ByteOrder order, long byteOffset, int value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            try {
                lib.send(receiver_, InteropLibraryGen.WRITE_BUFFER_INT, order, byteOffset, value);
                return;
            } catch (UnsupportedMessageException | InvalidBufferOffsetException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public long readBufferLong(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            try {
                return (long) lib.send(receiver_, InteropLibraryGen.READ_BUFFER_LONG, order, byteOffset);
            } catch (UnsupportedMessageException | InvalidBufferOffsetException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void writeBufferLong(Object receiver_, ByteOrder order, long byteOffset, long value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            try {
                lib.send(receiver_, InteropLibraryGen.WRITE_BUFFER_LONG, order, byteOffset, value);
                return;
            } catch (UnsupportedMessageException | InvalidBufferOffsetException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public float readBufferFloat(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            try {
                return (float) lib.send(receiver_, InteropLibraryGen.READ_BUFFER_FLOAT, order, byteOffset);
            } catch (UnsupportedMessageException | InvalidBufferOffsetException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void writeBufferFloat(Object receiver_, ByteOrder order, long byteOffset, float value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            try {
                lib.send(receiver_, InteropLibraryGen.WRITE_BUFFER_FLOAT, order, byteOffset, value);
                return;
            } catch (UnsupportedMessageException | InvalidBufferOffsetException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public double readBufferDouble(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            try {
                return (double) lib.send(receiver_, InteropLibraryGen.READ_BUFFER_DOUBLE, order, byteOffset);
            } catch (UnsupportedMessageException | InvalidBufferOffsetException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void writeBufferDouble(Object receiver_, ByteOrder order, long byteOffset, double value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            try {
                lib.send(receiver_, InteropLibraryGen.WRITE_BUFFER_DOUBLE, order, byteOffset, value);
                return;
            } catch (UnsupportedMessageException | InvalidBufferOffsetException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isPointer(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_POINTER);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public long asPointer(Object receiver_) throws UnsupportedMessageException {
            try {
                return (long) lib.send(receiver_, InteropLibraryGen.AS_POINTER);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public void toNative(Object receiver_) {
            try {
                lib.send(receiver_, InteropLibraryGen.TO_NATIVE);
                return;
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Instant asInstant(Object receiver_) throws UnsupportedMessageException {
            try {
                return (Instant) lib.send(receiver_, InteropLibraryGen.AS_INSTANT);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isTimeZone(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_TIME_ZONE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public ZoneId asTimeZone(Object receiver_) throws UnsupportedMessageException {
            try {
                return (ZoneId) lib.send(receiver_, InteropLibraryGen.AS_TIME_ZONE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isDate(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_DATE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public LocalDate asDate(Object receiver_) throws UnsupportedMessageException {
            try {
                return (LocalDate) lib.send(receiver_, InteropLibraryGen.AS_DATE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isTime(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_TIME);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public LocalTime asTime(Object receiver_) throws UnsupportedMessageException {
            try {
                return (LocalTime) lib.send(receiver_, InteropLibraryGen.AS_TIME);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isDuration(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_DURATION);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Duration asDuration(Object receiver_) throws UnsupportedMessageException {
            try {
                return (Duration) lib.send(receiver_, InteropLibraryGen.AS_DURATION);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isException(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_EXCEPTION);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public RuntimeException throwException(Object receiver_) throws UnsupportedMessageException {
            try {
                return (RuntimeException) lib.send(receiver_, InteropLibraryGen.THROW_EXCEPTION);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public ExceptionType getExceptionType(Object receiver_) throws UnsupportedMessageException {
            try {
                return (ExceptionType) lib.send(receiver_, InteropLibraryGen.GET_EXCEPTION_TYPE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isExceptionIncompleteSource(Object receiver_) throws UnsupportedMessageException {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_EXCEPTION_INCOMPLETE_SOURCE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public int getExceptionExitStatus(Object receiver_) throws UnsupportedMessageException {
            try {
                return (int) lib.send(receiver_, InteropLibraryGen.GET_EXCEPTION_EXIT_STATUS);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasExceptionCause(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_EXCEPTION_CAUSE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getExceptionCause(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_EXCEPTION_CAUSE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasExceptionMessage(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_EXCEPTION_MESSAGE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getExceptionMessage(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_EXCEPTION_MESSAGE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasExceptionStackTrace(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_EXCEPTION_STACK_TRACE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getExceptionStackTrace(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_EXCEPTION_STACK_TRACE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasIterator(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_ITERATOR);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getIterator(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_ITERATOR);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isIterator(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_ITERATOR);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasIteratorNextElement(Object receiver_) throws UnsupportedMessageException {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_ITERATOR_NEXT_ELEMENT);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getIteratorNextElement(Object receiver_) throws UnsupportedMessageException, StopIterationException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_ITERATOR_NEXT_ELEMENT);
            } catch (UnsupportedMessageException | StopIterationException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasSourceLocation(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_SOURCE_LOCATION);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public SourceSection getSourceLocation(Object receiver_) throws UnsupportedMessageException {
            try {
                return (SourceSection) lib.send(receiver_, InteropLibraryGen.GET_SOURCE_LOCATION);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasLanguage(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_LANGUAGE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @SuppressWarnings("unchecked")
        @Override
        public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver_) throws UnsupportedMessageException {
            try {
                return (Class<? extends TruffleLanguage<?>>) lib.send(receiver_, InteropLibraryGen.GET_LANGUAGE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasMetaObject(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_META_OBJECT);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getMetaObject(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_META_OBJECT);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object toDisplayString(Object receiver_, boolean allowSideEffects) {
            try {
                return lib.send(receiver_, InteropLibraryGen.TO_DISPLAY_STRING, allowSideEffects);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isMetaObject(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_META_OBJECT);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getMetaQualifiedName(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_META_QUALIFIED_NAME);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getMetaSimpleName(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_META_SIMPLE_NAME);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isMetaInstance(Object receiver_, Object instance) throws UnsupportedMessageException {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_META_INSTANCE, instance);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        protected TriState isIdenticalOrUndefined(Object receiver_, Object other) {
            try {
                return (TriState) lib.send(receiver_, InteropLibraryGen.IS_IDENTICAL_OR_UNDEFINED, other);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isIdentical(Object receiver_, Object other, InteropLibrary otherInterop) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_IDENTICAL, other, otherInterop);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public int identityHashCode(Object receiver_) throws UnsupportedMessageException {
            try {
                return (int) lib.send(receiver_, InteropLibraryGen.IDENTITY_HASH_CODE);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean isScope(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.IS_SCOPE);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean hasScopeParent(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, InteropLibraryGen.HAS_SCOPE_PARENT);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public Object getScopeParent(Object receiver_) throws UnsupportedMessageException {
            try {
                return lib.send(receiver_, InteropLibraryGen.GET_SCOPE_PARENT);
            } catch (UnsupportedMessageException | RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                throw CompilerDirectives.shouldNotReachHere(e_);
            }
        }

        @Override
        public boolean accepts(Object receiver_) {
            return lib.accepts(receiver_);
        }

    }
    @GeneratedBy(InteropLibrary.class)
    private static final class Delegate extends InteropLibrary {

        @Child private InteropLibrary delegateLibrary;

        Delegate(InteropLibrary delegateLibrary) {
            this.delegateLibrary = delegateLibrary;
        }

        @Override
        public boolean isNull(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 0)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isNull(delegate);
            } else {
                return this.delegateLibrary.isNull(receiver_);
            }
        }

        @Override
        public boolean isBoolean(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 1)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isBoolean(delegate);
            } else {
                return this.delegateLibrary.isBoolean(receiver_);
            }
        }

        @Override
        public boolean asBoolean(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 2)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asBoolean(delegate);
            } else {
                return this.delegateLibrary.asBoolean(receiver_);
            }
        }

        @Override
        public boolean isExecutable(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 3)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isExecutable(delegate);
            } else {
                return this.delegateLibrary.isExecutable(receiver_);
            }
        }

        @Override
        public Object execute(Object receiver_, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 4)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).execute(delegate, arguments);
            } else {
                return this.delegateLibrary.execute(receiver_, arguments);
            }
        }

        @Override
        public boolean hasExecutableName(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 5)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasExecutableName(delegate);
            } else {
                return this.delegateLibrary.hasExecutableName(receiver_);
            }
        }

        @Override
        public Object getExecutableName(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 6)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getExecutableName(delegate);
            } else {
                return this.delegateLibrary.getExecutableName(receiver_);
            }
        }

        @Override
        public boolean hasDeclaringMetaObject(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 7)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasDeclaringMetaObject(delegate);
            } else {
                return this.delegateLibrary.hasDeclaringMetaObject(receiver_);
            }
        }

        @Override
        public Object getDeclaringMetaObject(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 8)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getDeclaringMetaObject(delegate);
            } else {
                return this.delegateLibrary.getDeclaringMetaObject(receiver_);
            }
        }

        @Override
        public boolean isInstantiable(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 9)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isInstantiable(delegate);
            } else {
                return this.delegateLibrary.isInstantiable(receiver_);
            }
        }

        @Override
        public Object instantiate(Object receiver_, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 10)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).instantiate(delegate, arguments);
            } else {
                return this.delegateLibrary.instantiate(receiver_, arguments);
            }
        }

        @Override
        public boolean isString(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 11)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isString(delegate);
            } else {
                return this.delegateLibrary.isString(receiver_);
            }
        }

        @Override
        public String asString(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 12)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asString(delegate);
            } else {
                return this.delegateLibrary.asString(receiver_);
            }
        }

        @Override
        public boolean isNumber(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 13)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isNumber(delegate);
            } else {
                return this.delegateLibrary.isNumber(receiver_);
            }
        }

        @Override
        public boolean fitsInByte(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 14)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).fitsInByte(delegate);
            } else {
                return this.delegateLibrary.fitsInByte(receiver_);
            }
        }

        @Override
        public boolean fitsInShort(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 15)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).fitsInShort(delegate);
            } else {
                return this.delegateLibrary.fitsInShort(receiver_);
            }
        }

        @Override
        public boolean fitsInInt(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 16)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).fitsInInt(delegate);
            } else {
                return this.delegateLibrary.fitsInInt(receiver_);
            }
        }

        @Override
        public boolean fitsInLong(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 17)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).fitsInLong(delegate);
            } else {
                return this.delegateLibrary.fitsInLong(receiver_);
            }
        }

        @Override
        public boolean fitsInFloat(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 18)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).fitsInFloat(delegate);
            } else {
                return this.delegateLibrary.fitsInFloat(receiver_);
            }
        }

        @Override
        public boolean fitsInDouble(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 19)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).fitsInDouble(delegate);
            } else {
                return this.delegateLibrary.fitsInDouble(receiver_);
            }
        }

        @Override
        public byte asByte(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 20)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asByte(delegate);
            } else {
                return this.delegateLibrary.asByte(receiver_);
            }
        }

        @Override
        public short asShort(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 21)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asShort(delegate);
            } else {
                return this.delegateLibrary.asShort(receiver_);
            }
        }

        @Override
        public int asInt(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 22)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asInt(delegate);
            } else {
                return this.delegateLibrary.asInt(receiver_);
            }
        }

        @Override
        public long asLong(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 23)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asLong(delegate);
            } else {
                return this.delegateLibrary.asLong(receiver_);
            }
        }

        @Override
        public float asFloat(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 24)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asFloat(delegate);
            } else {
                return this.delegateLibrary.asFloat(receiver_);
            }
        }

        @Override
        public double asDouble(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 25)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asDouble(delegate);
            } else {
                return this.delegateLibrary.asDouble(receiver_);
            }
        }

        @Override
        public boolean hasMembers(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 26)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasMembers(delegate);
            } else {
                return this.delegateLibrary.hasMembers(receiver_);
            }
        }

        @Override
        public Object getMembers(Object receiver_, boolean includeInternal) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 27)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getMembers(delegate, includeInternal);
            } else {
                return this.delegateLibrary.getMembers(receiver_, includeInternal);
            }
        }

        @Override
        public boolean isMemberReadable(Object receiver_, String member) {
            if (LibraryFactory.isDelegated(delegateLibrary, 28)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isMemberReadable(delegate, member);
            } else {
                return this.delegateLibrary.isMemberReadable(receiver_, member);
            }
        }

        @Override
        public Object readMember(Object receiver_, String member) throws UnsupportedMessageException, UnknownIdentifierException {
            if (LibraryFactory.isDelegated(delegateLibrary, 29)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).readMember(delegate, member);
            } else {
                return this.delegateLibrary.readMember(receiver_, member);
            }
        }

        @Override
        public boolean isMemberModifiable(Object receiver_, String member) {
            if (LibraryFactory.isDelegated(delegateLibrary, 30)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isMemberModifiable(delegate, member);
            } else {
                return this.delegateLibrary.isMemberModifiable(receiver_, member);
            }
        }

        @Override
        public boolean isMemberInsertable(Object receiver_, String member) {
            if (LibraryFactory.isDelegated(delegateLibrary, 31)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isMemberInsertable(delegate, member);
            } else {
                return this.delegateLibrary.isMemberInsertable(receiver_, member);
            }
        }

        @Override
        public void writeMember(Object receiver_, String member, Object value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
            if (LibraryFactory.isDelegated(delegateLibrary, 32)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).writeMember(delegate, member, value);
                return;
            } else {
                this.delegateLibrary.writeMember(receiver_, member, value);
                return;
            }
        }

        @Override
        public boolean isMemberRemovable(Object receiver_, String member) {
            if (LibraryFactory.isDelegated(delegateLibrary, 33)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isMemberRemovable(delegate, member);
            } else {
                return this.delegateLibrary.isMemberRemovable(receiver_, member);
            }
        }

        @Override
        public void removeMember(Object receiver_, String member) throws UnsupportedMessageException, UnknownIdentifierException {
            if (LibraryFactory.isDelegated(delegateLibrary, 34)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).removeMember(delegate, member);
                return;
            } else {
                this.delegateLibrary.removeMember(receiver_, member);
                return;
            }
        }

        @Override
        public boolean isMemberInvocable(Object receiver_, String member) {
            if (LibraryFactory.isDelegated(delegateLibrary, 35)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isMemberInvocable(delegate, member);
            } else {
                return this.delegateLibrary.isMemberInvocable(receiver_, member);
            }
        }

        @Override
        public Object invokeMember(Object receiver_, String member, Object... arguments) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
            if (LibraryFactory.isDelegated(delegateLibrary, 36)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).invokeMember(delegate, member, arguments);
            } else {
                return this.delegateLibrary.invokeMember(receiver_, member, arguments);
            }
        }

        @Override
        public boolean isMemberInternal(Object receiver_, String member) {
            if (LibraryFactory.isDelegated(delegateLibrary, 37)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isMemberInternal(delegate, member);
            } else {
                return this.delegateLibrary.isMemberInternal(receiver_, member);
            }
        }

        @Override
        public boolean hasMemberReadSideEffects(Object receiver_, String member) {
            if (LibraryFactory.isDelegated(delegateLibrary, 38)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasMemberReadSideEffects(delegate, member);
            } else {
                return this.delegateLibrary.hasMemberReadSideEffects(receiver_, member);
            }
        }

        @Override
        public boolean hasMemberWriteSideEffects(Object receiver_, String member) {
            if (LibraryFactory.isDelegated(delegateLibrary, 39)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasMemberWriteSideEffects(delegate, member);
            } else {
                return this.delegateLibrary.hasMemberWriteSideEffects(receiver_, member);
            }
        }

        @Override
        public boolean hasHashEntries(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 40)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasHashEntries(delegate);
            } else {
                return this.delegateLibrary.hasHashEntries(receiver_);
            }
        }

        @Override
        public long getHashSize(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 41)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getHashSize(delegate);
            } else {
                return this.delegateLibrary.getHashSize(receiver_);
            }
        }

        @Override
        public boolean isHashEntryReadable(Object receiver_, Object key) {
            if (LibraryFactory.isDelegated(delegateLibrary, 42)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isHashEntryReadable(delegate, key);
            } else {
                return this.delegateLibrary.isHashEntryReadable(receiver_, key);
            }
        }

        @Override
        public Object readHashValue(Object receiver_, Object key) throws UnsupportedMessageException, UnknownKeyException {
            if (LibraryFactory.isDelegated(delegateLibrary, 43)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).readHashValue(delegate, key);
            } else {
                return this.delegateLibrary.readHashValue(receiver_, key);
            }
        }

        @Override
        public Object readHashValueOrDefault(Object receiver_, Object key, Object defaultValue) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 44)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).readHashValueOrDefault(delegate, key, defaultValue);
            } else {
                return this.delegateLibrary.readHashValueOrDefault(receiver_, key, defaultValue);
            }
        }

        @Override
        public boolean isHashEntryModifiable(Object receiver_, Object key) {
            if (LibraryFactory.isDelegated(delegateLibrary, 45)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isHashEntryModifiable(delegate, key);
            } else {
                return this.delegateLibrary.isHashEntryModifiable(receiver_, key);
            }
        }

        @Override
        public boolean isHashEntryInsertable(Object receiver_, Object key) {
            if (LibraryFactory.isDelegated(delegateLibrary, 46)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isHashEntryInsertable(delegate, key);
            } else {
                return this.delegateLibrary.isHashEntryInsertable(receiver_, key);
            }
        }

        @Override
        public boolean isHashEntryWritable(Object receiver_, Object key) {
            if (LibraryFactory.isDelegated(delegateLibrary, 47)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isHashEntryWritable(delegate, key);
            } else {
                return this.delegateLibrary.isHashEntryWritable(receiver_, key);
            }
        }

        @Override
        public void writeHashEntry(Object receiver_, Object key, Object value) throws UnsupportedMessageException, UnknownKeyException, UnsupportedTypeException {
            if (LibraryFactory.isDelegated(delegateLibrary, 48)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).writeHashEntry(delegate, key, value);
                return;
            } else {
                this.delegateLibrary.writeHashEntry(receiver_, key, value);
                return;
            }
        }

        @Override
        public boolean isHashEntryRemovable(Object receiver_, Object key) {
            if (LibraryFactory.isDelegated(delegateLibrary, 49)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isHashEntryRemovable(delegate, key);
            } else {
                return this.delegateLibrary.isHashEntryRemovable(receiver_, key);
            }
        }

        @Override
        public void removeHashEntry(Object receiver_, Object key) throws UnsupportedMessageException, UnknownKeyException {
            if (LibraryFactory.isDelegated(delegateLibrary, 50)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).removeHashEntry(delegate, key);
                return;
            } else {
                this.delegateLibrary.removeHashEntry(receiver_, key);
                return;
            }
        }

        @Override
        public boolean isHashEntryExisting(Object receiver_, Object key) {
            if (LibraryFactory.isDelegated(delegateLibrary, 51)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isHashEntryExisting(delegate, key);
            } else {
                return this.delegateLibrary.isHashEntryExisting(receiver_, key);
            }
        }

        @Override
        public Object getHashEntriesIterator(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 52)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getHashEntriesIterator(delegate);
            } else {
                return this.delegateLibrary.getHashEntriesIterator(receiver_);
            }
        }

        @Override
        public Object getHashKeysIterator(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 53)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getHashKeysIterator(delegate);
            } else {
                return this.delegateLibrary.getHashKeysIterator(receiver_);
            }
        }

        @Override
        public Object getHashValuesIterator(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 54)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getHashValuesIterator(delegate);
            } else {
                return this.delegateLibrary.getHashValuesIterator(receiver_);
            }
        }

        @Override
        public boolean hasArrayElements(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 55)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasArrayElements(delegate);
            } else {
                return this.delegateLibrary.hasArrayElements(receiver_);
            }
        }

        @Override
        public Object readArrayElement(Object receiver_, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
            if (LibraryFactory.isDelegated(delegateLibrary, 56)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).readArrayElement(delegate, index);
            } else {
                return this.delegateLibrary.readArrayElement(receiver_, index);
            }
        }

        @Override
        public long getArraySize(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 57)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getArraySize(delegate);
            } else {
                return this.delegateLibrary.getArraySize(receiver_);
            }
        }

        @Override
        public boolean isArrayElementReadable(Object receiver_, long index) {
            if (LibraryFactory.isDelegated(delegateLibrary, 58)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isArrayElementReadable(delegate, index);
            } else {
                return this.delegateLibrary.isArrayElementReadable(receiver_, index);
            }
        }

        @Override
        public void writeArrayElement(Object receiver_, long index, Object value) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
            if (LibraryFactory.isDelegated(delegateLibrary, 59)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).writeArrayElement(delegate, index, value);
                return;
            } else {
                this.delegateLibrary.writeArrayElement(receiver_, index, value);
                return;
            }
        }

        @Override
        public void removeArrayElement(Object receiver_, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
            if (LibraryFactory.isDelegated(delegateLibrary, 60)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).removeArrayElement(delegate, index);
                return;
            } else {
                this.delegateLibrary.removeArrayElement(receiver_, index);
                return;
            }
        }

        @Override
        public boolean isArrayElementModifiable(Object receiver_, long index) {
            if (LibraryFactory.isDelegated(delegateLibrary, 61)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isArrayElementModifiable(delegate, index);
            } else {
                return this.delegateLibrary.isArrayElementModifiable(receiver_, index);
            }
        }

        @Override
        public boolean isArrayElementInsertable(Object receiver_, long index) {
            if (LibraryFactory.isDelegated(delegateLibrary, 62)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isArrayElementInsertable(delegate, index);
            } else {
                return this.delegateLibrary.isArrayElementInsertable(receiver_, index);
            }
        }

        @Override
        public boolean isArrayElementRemovable(Object receiver_, long index) {
            if (LibraryFactory.isDelegated(delegateLibrary, 63)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isArrayElementRemovable(delegate, index);
            } else {
                return this.delegateLibrary.isArrayElementRemovable(receiver_, index);
            }
        }

        @Override
        public boolean hasBufferElements(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 64)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasBufferElements(delegate);
            } else {
                return this.delegateLibrary.hasBufferElements(receiver_);
            }
        }

        @Override
        public boolean isBufferWritable(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 65)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isBufferWritable(delegate);
            } else {
                return this.delegateLibrary.isBufferWritable(receiver_);
            }
        }

        @Override
        public long getBufferSize(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 66)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getBufferSize(delegate);
            } else {
                return this.delegateLibrary.getBufferSize(receiver_);
            }
        }

        @Override
        public byte readBufferByte(Object receiver_, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            if (LibraryFactory.isDelegated(delegateLibrary, 67)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).readBufferByte(delegate, byteOffset);
            } else {
                return this.delegateLibrary.readBufferByte(receiver_, byteOffset);
            }
        }

        @Override
        public void writeBufferByte(Object receiver_, long byteOffset, byte value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            if (LibraryFactory.isDelegated(delegateLibrary, 68)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).writeBufferByte(delegate, byteOffset, value);
                return;
            } else {
                this.delegateLibrary.writeBufferByte(receiver_, byteOffset, value);
                return;
            }
        }

        @Override
        public short readBufferShort(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            if (LibraryFactory.isDelegated(delegateLibrary, 69)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).readBufferShort(delegate, order, byteOffset);
            } else {
                return this.delegateLibrary.readBufferShort(receiver_, order, byteOffset);
            }
        }

        @Override
        public void writeBufferShort(Object receiver_, ByteOrder order, long byteOffset, short value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            if (LibraryFactory.isDelegated(delegateLibrary, 70)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).writeBufferShort(delegate, order, byteOffset, value);
                return;
            } else {
                this.delegateLibrary.writeBufferShort(receiver_, order, byteOffset, value);
                return;
            }
        }

        @Override
        public int readBufferInt(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            if (LibraryFactory.isDelegated(delegateLibrary, 71)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).readBufferInt(delegate, order, byteOffset);
            } else {
                return this.delegateLibrary.readBufferInt(receiver_, order, byteOffset);
            }
        }

        @Override
        public void writeBufferInt(Object receiver_, ByteOrder order, long byteOffset, int value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            if (LibraryFactory.isDelegated(delegateLibrary, 72)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).writeBufferInt(delegate, order, byteOffset, value);
                return;
            } else {
                this.delegateLibrary.writeBufferInt(receiver_, order, byteOffset, value);
                return;
            }
        }

        @Override
        public long readBufferLong(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            if (LibraryFactory.isDelegated(delegateLibrary, 73)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).readBufferLong(delegate, order, byteOffset);
            } else {
                return this.delegateLibrary.readBufferLong(receiver_, order, byteOffset);
            }
        }

        @Override
        public void writeBufferLong(Object receiver_, ByteOrder order, long byteOffset, long value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            if (LibraryFactory.isDelegated(delegateLibrary, 74)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).writeBufferLong(delegate, order, byteOffset, value);
                return;
            } else {
                this.delegateLibrary.writeBufferLong(receiver_, order, byteOffset, value);
                return;
            }
        }

        @Override
        public float readBufferFloat(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            if (LibraryFactory.isDelegated(delegateLibrary, 75)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).readBufferFloat(delegate, order, byteOffset);
            } else {
                return this.delegateLibrary.readBufferFloat(receiver_, order, byteOffset);
            }
        }

        @Override
        public void writeBufferFloat(Object receiver_, ByteOrder order, long byteOffset, float value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            if (LibraryFactory.isDelegated(delegateLibrary, 76)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).writeBufferFloat(delegate, order, byteOffset, value);
                return;
            } else {
                this.delegateLibrary.writeBufferFloat(receiver_, order, byteOffset, value);
                return;
            }
        }

        @Override
        public double readBufferDouble(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            if (LibraryFactory.isDelegated(delegateLibrary, 77)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).readBufferDouble(delegate, order, byteOffset);
            } else {
                return this.delegateLibrary.readBufferDouble(receiver_, order, byteOffset);
            }
        }

        @Override
        public void writeBufferDouble(Object receiver_, ByteOrder order, long byteOffset, double value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            if (LibraryFactory.isDelegated(delegateLibrary, 78)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).writeBufferDouble(delegate, order, byteOffset, value);
                return;
            } else {
                this.delegateLibrary.writeBufferDouble(receiver_, order, byteOffset, value);
                return;
            }
        }

        @Override
        public boolean isPointer(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 79)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isPointer(delegate);
            } else {
                return this.delegateLibrary.isPointer(receiver_);
            }
        }

        @Override
        public long asPointer(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 80)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asPointer(delegate);
            } else {
                return this.delegateLibrary.asPointer(receiver_);
            }
        }

        @Override
        public void toNative(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 81)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).toNative(delegate);
                return;
            } else {
                this.delegateLibrary.toNative(receiver_);
                return;
            }
        }

        @Override
        public Instant asInstant(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 82)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asInstant(delegate);
            } else {
                return this.delegateLibrary.asInstant(receiver_);
            }
        }

        @Override
        public boolean isTimeZone(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 83)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isTimeZone(delegate);
            } else {
                return this.delegateLibrary.isTimeZone(receiver_);
            }
        }

        @Override
        public ZoneId asTimeZone(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 84)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asTimeZone(delegate);
            } else {
                return this.delegateLibrary.asTimeZone(receiver_);
            }
        }

        @Override
        public boolean isDate(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 85)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isDate(delegate);
            } else {
                return this.delegateLibrary.isDate(receiver_);
            }
        }

        @Override
        public LocalDate asDate(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 86)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asDate(delegate);
            } else {
                return this.delegateLibrary.asDate(receiver_);
            }
        }

        @Override
        public boolean isTime(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 87)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isTime(delegate);
            } else {
                return this.delegateLibrary.isTime(receiver_);
            }
        }

        @Override
        public LocalTime asTime(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 88)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asTime(delegate);
            } else {
                return this.delegateLibrary.asTime(receiver_);
            }
        }

        @Override
        public boolean isDuration(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 89)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isDuration(delegate);
            } else {
                return this.delegateLibrary.isDuration(receiver_);
            }
        }

        @Override
        public Duration asDuration(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 90)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).asDuration(delegate);
            } else {
                return this.delegateLibrary.asDuration(receiver_);
            }
        }

        @Override
        public boolean isException(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 91)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isException(delegate);
            } else {
                return this.delegateLibrary.isException(receiver_);
            }
        }

        @Override
        public RuntimeException throwException(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 92)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).throwException(delegate);
            } else {
                return this.delegateLibrary.throwException(receiver_);
            }
        }

        @Override
        public ExceptionType getExceptionType(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 93)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getExceptionType(delegate);
            } else {
                return this.delegateLibrary.getExceptionType(receiver_);
            }
        }

        @Override
        public boolean isExceptionIncompleteSource(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 94)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isExceptionIncompleteSource(delegate);
            } else {
                return this.delegateLibrary.isExceptionIncompleteSource(receiver_);
            }
        }

        @Override
        public int getExceptionExitStatus(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 95)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getExceptionExitStatus(delegate);
            } else {
                return this.delegateLibrary.getExceptionExitStatus(receiver_);
            }
        }

        @Override
        public boolean hasExceptionCause(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 96)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasExceptionCause(delegate);
            } else {
                return this.delegateLibrary.hasExceptionCause(receiver_);
            }
        }

        @Override
        public Object getExceptionCause(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 97)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getExceptionCause(delegate);
            } else {
                return this.delegateLibrary.getExceptionCause(receiver_);
            }
        }

        @Override
        public boolean hasExceptionMessage(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 98)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasExceptionMessage(delegate);
            } else {
                return this.delegateLibrary.hasExceptionMessage(receiver_);
            }
        }

        @Override
        public Object getExceptionMessage(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 99)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getExceptionMessage(delegate);
            } else {
                return this.delegateLibrary.getExceptionMessage(receiver_);
            }
        }

        @Override
        public boolean hasExceptionStackTrace(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 100)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasExceptionStackTrace(delegate);
            } else {
                return this.delegateLibrary.hasExceptionStackTrace(receiver_);
            }
        }

        @Override
        public Object getExceptionStackTrace(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 101)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getExceptionStackTrace(delegate);
            } else {
                return this.delegateLibrary.getExceptionStackTrace(receiver_);
            }
        }

        @Override
        public boolean hasIterator(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 102)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasIterator(delegate);
            } else {
                return this.delegateLibrary.hasIterator(receiver_);
            }
        }

        @Override
        public Object getIterator(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 103)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getIterator(delegate);
            } else {
                return this.delegateLibrary.getIterator(receiver_);
            }
        }

        @Override
        public boolean isIterator(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 104)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isIterator(delegate);
            } else {
                return this.delegateLibrary.isIterator(receiver_);
            }
        }

        @Override
        public boolean hasIteratorNextElement(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 105)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasIteratorNextElement(delegate);
            } else {
                return this.delegateLibrary.hasIteratorNextElement(receiver_);
            }
        }

        @Override
        public Object getIteratorNextElement(Object receiver_) throws UnsupportedMessageException, StopIterationException {
            if (LibraryFactory.isDelegated(delegateLibrary, 106)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getIteratorNextElement(delegate);
            } else {
                return this.delegateLibrary.getIteratorNextElement(receiver_);
            }
        }

        @Override
        public boolean hasSourceLocation(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 107)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasSourceLocation(delegate);
            } else {
                return this.delegateLibrary.hasSourceLocation(receiver_);
            }
        }

        @Override
        public SourceSection getSourceLocation(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 108)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getSourceLocation(delegate);
            } else {
                return this.delegateLibrary.getSourceLocation(receiver_);
            }
        }

        @Override
        public boolean hasLanguage(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 109)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasLanguage(delegate);
            } else {
                return this.delegateLibrary.hasLanguage(receiver_);
            }
        }

        @Override
        public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 110)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getLanguage(delegate);
            } else {
                return this.delegateLibrary.getLanguage(receiver_);
            }
        }

        @Override
        public boolean hasMetaObject(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 111)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasMetaObject(delegate);
            } else {
                return this.delegateLibrary.hasMetaObject(receiver_);
            }
        }

        @Override
        public Object getMetaObject(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 112)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getMetaObject(delegate);
            } else {
                return this.delegateLibrary.getMetaObject(receiver_);
            }
        }

        @Override
        public Object toDisplayString(Object receiver_, boolean allowSideEffects) {
            if (LibraryFactory.isDelegated(delegateLibrary, 113)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).toDisplayString(delegate, allowSideEffects);
            } else {
                return this.delegateLibrary.toDisplayString(receiver_, allowSideEffects);
            }
        }

        @Override
        public boolean isMetaObject(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 114)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isMetaObject(delegate);
            } else {
                return this.delegateLibrary.isMetaObject(receiver_);
            }
        }

        @Override
        public Object getMetaQualifiedName(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 115)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getMetaQualifiedName(delegate);
            } else {
                return this.delegateLibrary.getMetaQualifiedName(receiver_);
            }
        }

        @Override
        public Object getMetaSimpleName(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 116)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getMetaSimpleName(delegate);
            } else {
                return this.delegateLibrary.getMetaSimpleName(receiver_);
            }
        }

        @Override
        public boolean isMetaInstance(Object receiver_, Object instance) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 117)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isMetaInstance(delegate, instance);
            } else {
                return this.delegateLibrary.isMetaInstance(receiver_, instance);
            }
        }

        @Override
        protected TriState isIdenticalOrUndefined(Object receiver_, Object other) {
            if (LibraryFactory.isDelegated(delegateLibrary, 118)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isIdenticalOrUndefined(delegate, other);
            } else {
                return this.delegateLibrary.isIdenticalOrUndefined(receiver_, other);
            }
        }

        @Override
        public boolean isIdentical(Object receiver_, Object other, InteropLibrary otherInterop) {
            if (LibraryFactory.isDelegated(delegateLibrary, 119)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isIdentical(delegate, other, otherInterop);
            } else {
                return this.delegateLibrary.isIdentical(receiver_, other, otherInterop);
            }
        }

        @Override
        public int identityHashCode(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 120)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).identityHashCode(delegate);
            } else {
                return this.delegateLibrary.identityHashCode(receiver_);
            }
        }

        @Override
        public boolean isScope(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 121)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isScope(delegate);
            } else {
                return this.delegateLibrary.isScope(receiver_);
            }
        }

        @Override
        public boolean hasScopeParent(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 122)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).hasScopeParent(delegate);
            } else {
                return this.delegateLibrary.hasScopeParent(receiver_);
            }
        }

        @Override
        public Object getScopeParent(Object receiver_) throws UnsupportedMessageException {
            if (LibraryFactory.isDelegated(delegateLibrary, 123)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).getScopeParent(delegate);
            } else {
                return this.delegateLibrary.getScopeParent(receiver_);
            }
        }

        @Override
        public boolean accepts(Object receiver_) {
            return delegateLibrary.accepts(receiver_);
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        @Override
        public boolean isAdoptable() {
            return this.delegateLibrary.isAdoptable();
        }

    }
    @GeneratedBy(InteropLibrary.class)
    private static final class CachedToUncachedDispatch extends InteropLibrary {

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @TruffleBoundary
        @Override
        public boolean isNull(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isNull(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isBoolean(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isBoolean(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean asBoolean(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asBoolean(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isExecutable(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isExecutable(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object execute(Object receiver_, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).execute(receiver_, arguments);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasExecutableName(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasExecutableName(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getExecutableName(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getExecutableName(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasDeclaringMetaObject(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasDeclaringMetaObject(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getDeclaringMetaObject(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getDeclaringMetaObject(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isInstantiable(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isInstantiable(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object instantiate(Object receiver_, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).instantiate(receiver_, arguments);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isString(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isString(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public String asString(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asString(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isNumber(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isNumber(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean fitsInByte(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).fitsInByte(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean fitsInShort(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).fitsInShort(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean fitsInInt(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).fitsInInt(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean fitsInLong(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).fitsInLong(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean fitsInFloat(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).fitsInFloat(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean fitsInDouble(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).fitsInDouble(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public byte asByte(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asByte(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public short asShort(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asShort(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public int asInt(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asInt(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public long asLong(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asLong(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public float asFloat(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asFloat(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public double asDouble(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asDouble(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasMembers(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasMembers(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getMembers(Object receiver_, boolean includeInternal) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getMembers(receiver_, includeInternal);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isMemberReadable(Object receiver_, String member) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isMemberReadable(receiver_, member);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object readMember(Object receiver_, String member) throws UnsupportedMessageException, UnknownIdentifierException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).readMember(receiver_, member);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isMemberModifiable(Object receiver_, String member) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isMemberModifiable(receiver_, member);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isMemberInsertable(Object receiver_, String member) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isMemberInsertable(receiver_, member);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void writeMember(Object receiver_, String member, Object value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).writeMember(receiver_, member, value);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isMemberRemovable(Object receiver_, String member) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isMemberRemovable(receiver_, member);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void removeMember(Object receiver_, String member) throws UnsupportedMessageException, UnknownIdentifierException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).removeMember(receiver_, member);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isMemberInvocable(Object receiver_, String member) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isMemberInvocable(receiver_, member);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object invokeMember(Object receiver_, String member, Object... arguments) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).invokeMember(receiver_, member, arguments);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isMemberInternal(Object receiver_, String member) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isMemberInternal(receiver_, member);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasMemberReadSideEffects(Object receiver_, String member) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasMemberReadSideEffects(receiver_, member);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasMemberWriteSideEffects(Object receiver_, String member) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasMemberWriteSideEffects(receiver_, member);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasHashEntries(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasHashEntries(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public long getHashSize(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getHashSize(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isHashEntryReadable(Object receiver_, Object key) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isHashEntryReadable(receiver_, key);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object readHashValue(Object receiver_, Object key) throws UnsupportedMessageException, UnknownKeyException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).readHashValue(receiver_, key);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object readHashValueOrDefault(Object receiver_, Object key, Object defaultValue) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).readHashValueOrDefault(receiver_, key, defaultValue);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isHashEntryModifiable(Object receiver_, Object key) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isHashEntryModifiable(receiver_, key);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isHashEntryInsertable(Object receiver_, Object key) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isHashEntryInsertable(receiver_, key);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isHashEntryWritable(Object receiver_, Object key) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isHashEntryWritable(receiver_, key);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void writeHashEntry(Object receiver_, Object key, Object value) throws UnsupportedMessageException, UnknownKeyException, UnsupportedTypeException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).writeHashEntry(receiver_, key, value);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isHashEntryRemovable(Object receiver_, Object key) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isHashEntryRemovable(receiver_, key);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void removeHashEntry(Object receiver_, Object key) throws UnsupportedMessageException, UnknownKeyException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).removeHashEntry(receiver_, key);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isHashEntryExisting(Object receiver_, Object key) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isHashEntryExisting(receiver_, key);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getHashEntriesIterator(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getHashEntriesIterator(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getHashKeysIterator(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getHashKeysIterator(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getHashValuesIterator(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getHashValuesIterator(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasArrayElements(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasArrayElements(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object readArrayElement(Object receiver_, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).readArrayElement(receiver_, index);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public long getArraySize(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getArraySize(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isArrayElementReadable(Object receiver_, long index) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isArrayElementReadable(receiver_, index);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void writeArrayElement(Object receiver_, long index, Object value) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).writeArrayElement(receiver_, index, value);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void removeArrayElement(Object receiver_, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).removeArrayElement(receiver_, index);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isArrayElementModifiable(Object receiver_, long index) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isArrayElementModifiable(receiver_, index);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isArrayElementInsertable(Object receiver_, long index) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isArrayElementInsertable(receiver_, index);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isArrayElementRemovable(Object receiver_, long index) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isArrayElementRemovable(receiver_, index);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasBufferElements(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasBufferElements(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isBufferWritable(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isBufferWritable(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public long getBufferSize(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getBufferSize(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public byte readBufferByte(Object receiver_, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).readBufferByte(receiver_, byteOffset);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void writeBufferByte(Object receiver_, long byteOffset, byte value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).writeBufferByte(receiver_, byteOffset, value);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public short readBufferShort(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).readBufferShort(receiver_, order, byteOffset);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void writeBufferShort(Object receiver_, ByteOrder order, long byteOffset, short value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).writeBufferShort(receiver_, order, byteOffset, value);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public int readBufferInt(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).readBufferInt(receiver_, order, byteOffset);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void writeBufferInt(Object receiver_, ByteOrder order, long byteOffset, int value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).writeBufferInt(receiver_, order, byteOffset, value);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public long readBufferLong(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).readBufferLong(receiver_, order, byteOffset);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void writeBufferLong(Object receiver_, ByteOrder order, long byteOffset, long value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).writeBufferLong(receiver_, order, byteOffset, value);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public float readBufferFloat(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).readBufferFloat(receiver_, order, byteOffset);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void writeBufferFloat(Object receiver_, ByteOrder order, long byteOffset, float value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).writeBufferFloat(receiver_, order, byteOffset, value);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public double readBufferDouble(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).readBufferDouble(receiver_, order, byteOffset);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void writeBufferDouble(Object receiver_, ByteOrder order, long byteOffset, double value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).writeBufferDouble(receiver_, order, byteOffset, value);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isPointer(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isPointer(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public long asPointer(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asPointer(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public void toNative(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                INSTANCE.getUncached(receiver_).toNative(receiver_);
                return;
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Instant asInstant(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asInstant(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isTimeZone(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isTimeZone(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public ZoneId asTimeZone(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asTimeZone(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isDate(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isDate(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public LocalDate asDate(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asDate(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isTime(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isTime(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public LocalTime asTime(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asTime(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isDuration(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isDuration(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Duration asDuration(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).asDuration(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isException(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isException(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public RuntimeException throwException(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).throwException(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public ExceptionType getExceptionType(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getExceptionType(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isExceptionIncompleteSource(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isExceptionIncompleteSource(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public int getExceptionExitStatus(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getExceptionExitStatus(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasExceptionCause(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasExceptionCause(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getExceptionCause(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getExceptionCause(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasExceptionMessage(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasExceptionMessage(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getExceptionMessage(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getExceptionMessage(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasExceptionStackTrace(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasExceptionStackTrace(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getExceptionStackTrace(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getExceptionStackTrace(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasIterator(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasIterator(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getIterator(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getIterator(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isIterator(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isIterator(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasIteratorNextElement(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasIteratorNextElement(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getIteratorNextElement(Object receiver_) throws UnsupportedMessageException, StopIterationException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getIteratorNextElement(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasSourceLocation(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasSourceLocation(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public SourceSection getSourceLocation(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getSourceLocation(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasLanguage(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasLanguage(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getLanguage(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasMetaObject(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasMetaObject(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getMetaObject(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getMetaObject(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object toDisplayString(Object receiver_, boolean allowSideEffects) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).toDisplayString(receiver_, allowSideEffects);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isMetaObject(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isMetaObject(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getMetaQualifiedName(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getMetaQualifiedName(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getMetaSimpleName(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getMetaSimpleName(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isMetaInstance(Object receiver_, Object instance) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isMetaInstance(receiver_, instance);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        protected TriState isIdenticalOrUndefined(Object receiver_, Object other) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isIdenticalOrUndefined(receiver_, other);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isIdentical(Object receiver_, Object other, InteropLibrary otherInterop) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isIdentical(receiver_, other, otherInterop);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public int identityHashCode(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).identityHashCode(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean isScope(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isScope(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public boolean hasScopeParent(Object receiver_) {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).hasScopeParent(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public Object getScopeParent(Object receiver_) throws UnsupportedMessageException {
            assert assertAdopted();
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(getParent());
            try {
                return INSTANCE.getUncached(receiver_).getScopeParent(receiver_);
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

    }
    @GeneratedBy(InteropLibrary.class)
    private static final class UncachedDispatch extends InteropLibrary {

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @TruffleBoundary
        @Override
        public boolean isNull(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isNull(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isBoolean(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isBoolean(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean asBoolean(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asBoolean(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isExecutable(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isExecutable(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object execute(Object receiver_, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).execute(receiver_, arguments);
        }

        @TruffleBoundary
        @Override
        public boolean hasExecutableName(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasExecutableName(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getExecutableName(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getExecutableName(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean hasDeclaringMetaObject(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasDeclaringMetaObject(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getDeclaringMetaObject(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getDeclaringMetaObject(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isInstantiable(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isInstantiable(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object instantiate(Object receiver_, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).instantiate(receiver_, arguments);
        }

        @TruffleBoundary
        @Override
        public boolean isString(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isString(receiver_);
        }

        @TruffleBoundary
        @Override
        public String asString(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asString(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isNumber(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isNumber(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean fitsInByte(Object receiver_) {
            return INSTANCE.getUncached(receiver_).fitsInByte(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean fitsInShort(Object receiver_) {
            return INSTANCE.getUncached(receiver_).fitsInShort(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean fitsInInt(Object receiver_) {
            return INSTANCE.getUncached(receiver_).fitsInInt(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean fitsInLong(Object receiver_) {
            return INSTANCE.getUncached(receiver_).fitsInLong(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean fitsInFloat(Object receiver_) {
            return INSTANCE.getUncached(receiver_).fitsInFloat(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean fitsInDouble(Object receiver_) {
            return INSTANCE.getUncached(receiver_).fitsInDouble(receiver_);
        }

        @TruffleBoundary
        @Override
        public byte asByte(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asByte(receiver_);
        }

        @TruffleBoundary
        @Override
        public short asShort(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asShort(receiver_);
        }

        @TruffleBoundary
        @Override
        public int asInt(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asInt(receiver_);
        }

        @TruffleBoundary
        @Override
        public long asLong(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asLong(receiver_);
        }

        @TruffleBoundary
        @Override
        public float asFloat(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asFloat(receiver_);
        }

        @TruffleBoundary
        @Override
        public double asDouble(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asDouble(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean hasMembers(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasMembers(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getMembers(Object receiver_, boolean includeInternal) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getMembers(receiver_, includeInternal);
        }

        @TruffleBoundary
        @Override
        public boolean isMemberReadable(Object receiver_, String member) {
            return INSTANCE.getUncached(receiver_).isMemberReadable(receiver_, member);
        }

        @TruffleBoundary
        @Override
        public Object readMember(Object receiver_, String member) throws UnsupportedMessageException, UnknownIdentifierException {
            return INSTANCE.getUncached(receiver_).readMember(receiver_, member);
        }

        @TruffleBoundary
        @Override
        public boolean isMemberModifiable(Object receiver_, String member) {
            return INSTANCE.getUncached(receiver_).isMemberModifiable(receiver_, member);
        }

        @TruffleBoundary
        @Override
        public boolean isMemberInsertable(Object receiver_, String member) {
            return INSTANCE.getUncached(receiver_).isMemberInsertable(receiver_, member);
        }

        @TruffleBoundary
        @Override
        public void writeMember(Object receiver_, String member, Object value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
            INSTANCE.getUncached(receiver_).writeMember(receiver_, member, value);
            return;
        }

        @TruffleBoundary
        @Override
        public boolean isMemberRemovable(Object receiver_, String member) {
            return INSTANCE.getUncached(receiver_).isMemberRemovable(receiver_, member);
        }

        @TruffleBoundary
        @Override
        public void removeMember(Object receiver_, String member) throws UnsupportedMessageException, UnknownIdentifierException {
            INSTANCE.getUncached(receiver_).removeMember(receiver_, member);
            return;
        }

        @TruffleBoundary
        @Override
        public boolean isMemberInvocable(Object receiver_, String member) {
            return INSTANCE.getUncached(receiver_).isMemberInvocable(receiver_, member);
        }

        @TruffleBoundary
        @Override
        public Object invokeMember(Object receiver_, String member, Object... arguments) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
            return INSTANCE.getUncached(receiver_).invokeMember(receiver_, member, arguments);
        }

        @TruffleBoundary
        @Override
        public boolean isMemberInternal(Object receiver_, String member) {
            return INSTANCE.getUncached(receiver_).isMemberInternal(receiver_, member);
        }

        @TruffleBoundary
        @Override
        public boolean hasMemberReadSideEffects(Object receiver_, String member) {
            return INSTANCE.getUncached(receiver_).hasMemberReadSideEffects(receiver_, member);
        }

        @TruffleBoundary
        @Override
        public boolean hasMemberWriteSideEffects(Object receiver_, String member) {
            return INSTANCE.getUncached(receiver_).hasMemberWriteSideEffects(receiver_, member);
        }

        @TruffleBoundary
        @Override
        public boolean hasHashEntries(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasHashEntries(receiver_);
        }

        @TruffleBoundary
        @Override
        public long getHashSize(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getHashSize(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isHashEntryReadable(Object receiver_, Object key) {
            return INSTANCE.getUncached(receiver_).isHashEntryReadable(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public Object readHashValue(Object receiver_, Object key) throws UnsupportedMessageException, UnknownKeyException {
            return INSTANCE.getUncached(receiver_).readHashValue(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public Object readHashValueOrDefault(Object receiver_, Object key, Object defaultValue) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).readHashValueOrDefault(receiver_, key, defaultValue);
        }

        @TruffleBoundary
        @Override
        public boolean isHashEntryModifiable(Object receiver_, Object key) {
            return INSTANCE.getUncached(receiver_).isHashEntryModifiable(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public boolean isHashEntryInsertable(Object receiver_, Object key) {
            return INSTANCE.getUncached(receiver_).isHashEntryInsertable(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public boolean isHashEntryWritable(Object receiver_, Object key) {
            return INSTANCE.getUncached(receiver_).isHashEntryWritable(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public void writeHashEntry(Object receiver_, Object key, Object value) throws UnsupportedMessageException, UnknownKeyException, UnsupportedTypeException {
            INSTANCE.getUncached(receiver_).writeHashEntry(receiver_, key, value);
            return;
        }

        @TruffleBoundary
        @Override
        public boolean isHashEntryRemovable(Object receiver_, Object key) {
            return INSTANCE.getUncached(receiver_).isHashEntryRemovable(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public void removeHashEntry(Object receiver_, Object key) throws UnsupportedMessageException, UnknownKeyException {
            INSTANCE.getUncached(receiver_).removeHashEntry(receiver_, key);
            return;
        }

        @TruffleBoundary
        @Override
        public boolean isHashEntryExisting(Object receiver_, Object key) {
            return INSTANCE.getUncached(receiver_).isHashEntryExisting(receiver_, key);
        }

        @TruffleBoundary
        @Override
        public Object getHashEntriesIterator(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getHashEntriesIterator(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getHashKeysIterator(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getHashKeysIterator(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getHashValuesIterator(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getHashValuesIterator(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean hasArrayElements(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasArrayElements(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object readArrayElement(Object receiver_, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
            return INSTANCE.getUncached(receiver_).readArrayElement(receiver_, index);
        }

        @TruffleBoundary
        @Override
        public long getArraySize(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getArraySize(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isArrayElementReadable(Object receiver_, long index) {
            return INSTANCE.getUncached(receiver_).isArrayElementReadable(receiver_, index);
        }

        @TruffleBoundary
        @Override
        public void writeArrayElement(Object receiver_, long index, Object value) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
            INSTANCE.getUncached(receiver_).writeArrayElement(receiver_, index, value);
            return;
        }

        @TruffleBoundary
        @Override
        public void removeArrayElement(Object receiver_, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
            INSTANCE.getUncached(receiver_).removeArrayElement(receiver_, index);
            return;
        }

        @TruffleBoundary
        @Override
        public boolean isArrayElementModifiable(Object receiver_, long index) {
            return INSTANCE.getUncached(receiver_).isArrayElementModifiable(receiver_, index);
        }

        @TruffleBoundary
        @Override
        public boolean isArrayElementInsertable(Object receiver_, long index) {
            return INSTANCE.getUncached(receiver_).isArrayElementInsertable(receiver_, index);
        }

        @TruffleBoundary
        @Override
        public boolean isArrayElementRemovable(Object receiver_, long index) {
            return INSTANCE.getUncached(receiver_).isArrayElementRemovable(receiver_, index);
        }

        @TruffleBoundary
        @Override
        public boolean hasBufferElements(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasBufferElements(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isBufferWritable(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).isBufferWritable(receiver_);
        }

        @TruffleBoundary
        @Override
        public long getBufferSize(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getBufferSize(receiver_);
        }

        @TruffleBoundary
        @Override
        public byte readBufferByte(Object receiver_, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            return INSTANCE.getUncached(receiver_).readBufferByte(receiver_, byteOffset);
        }

        @TruffleBoundary
        @Override
        public void writeBufferByte(Object receiver_, long byteOffset, byte value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            INSTANCE.getUncached(receiver_).writeBufferByte(receiver_, byteOffset, value);
            return;
        }

        @TruffleBoundary
        @Override
        public short readBufferShort(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            return INSTANCE.getUncached(receiver_).readBufferShort(receiver_, order, byteOffset);
        }

        @TruffleBoundary
        @Override
        public void writeBufferShort(Object receiver_, ByteOrder order, long byteOffset, short value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            INSTANCE.getUncached(receiver_).writeBufferShort(receiver_, order, byteOffset, value);
            return;
        }

        @TruffleBoundary
        @Override
        public int readBufferInt(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            return INSTANCE.getUncached(receiver_).readBufferInt(receiver_, order, byteOffset);
        }

        @TruffleBoundary
        @Override
        public void writeBufferInt(Object receiver_, ByteOrder order, long byteOffset, int value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            INSTANCE.getUncached(receiver_).writeBufferInt(receiver_, order, byteOffset, value);
            return;
        }

        @TruffleBoundary
        @Override
        public long readBufferLong(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            return INSTANCE.getUncached(receiver_).readBufferLong(receiver_, order, byteOffset);
        }

        @TruffleBoundary
        @Override
        public void writeBufferLong(Object receiver_, ByteOrder order, long byteOffset, long value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            INSTANCE.getUncached(receiver_).writeBufferLong(receiver_, order, byteOffset, value);
            return;
        }

        @TruffleBoundary
        @Override
        public float readBufferFloat(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            return INSTANCE.getUncached(receiver_).readBufferFloat(receiver_, order, byteOffset);
        }

        @TruffleBoundary
        @Override
        public void writeBufferFloat(Object receiver_, ByteOrder order, long byteOffset, float value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            INSTANCE.getUncached(receiver_).writeBufferFloat(receiver_, order, byteOffset, value);
            return;
        }

        @TruffleBoundary
        @Override
        public double readBufferDouble(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            return INSTANCE.getUncached(receiver_).readBufferDouble(receiver_, order, byteOffset);
        }

        @TruffleBoundary
        @Override
        public void writeBufferDouble(Object receiver_, ByteOrder order, long byteOffset, double value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            INSTANCE.getUncached(receiver_).writeBufferDouble(receiver_, order, byteOffset, value);
            return;
        }

        @TruffleBoundary
        @Override
        public boolean isPointer(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isPointer(receiver_);
        }

        @TruffleBoundary
        @Override
        public long asPointer(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asPointer(receiver_);
        }

        @TruffleBoundary
        @Override
        public void toNative(Object receiver_) {
            INSTANCE.getUncached(receiver_).toNative(receiver_);
            return;
        }

        @TruffleBoundary
        @Override
        public Instant asInstant(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asInstant(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isTimeZone(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isTimeZone(receiver_);
        }

        @TruffleBoundary
        @Override
        public ZoneId asTimeZone(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asTimeZone(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isDate(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isDate(receiver_);
        }

        @TruffleBoundary
        @Override
        public LocalDate asDate(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asDate(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isTime(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isTime(receiver_);
        }

        @TruffleBoundary
        @Override
        public LocalTime asTime(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asTime(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isDuration(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isDuration(receiver_);
        }

        @TruffleBoundary
        @Override
        public Duration asDuration(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).asDuration(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isException(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isException(receiver_);
        }

        @TruffleBoundary
        @Override
        public RuntimeException throwException(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).throwException(receiver_);
        }

        @TruffleBoundary
        @Override
        public ExceptionType getExceptionType(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getExceptionType(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isExceptionIncompleteSource(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).isExceptionIncompleteSource(receiver_);
        }

        @TruffleBoundary
        @Override
        public int getExceptionExitStatus(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getExceptionExitStatus(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean hasExceptionCause(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasExceptionCause(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getExceptionCause(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getExceptionCause(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean hasExceptionMessage(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasExceptionMessage(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getExceptionMessage(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getExceptionMessage(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean hasExceptionStackTrace(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasExceptionStackTrace(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getExceptionStackTrace(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getExceptionStackTrace(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean hasIterator(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasIterator(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getIterator(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getIterator(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isIterator(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isIterator(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean hasIteratorNextElement(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).hasIteratorNextElement(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getIteratorNextElement(Object receiver_) throws UnsupportedMessageException, StopIterationException {
            return INSTANCE.getUncached(receiver_).getIteratorNextElement(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean hasSourceLocation(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasSourceLocation(receiver_);
        }

        @TruffleBoundary
        @Override
        public SourceSection getSourceLocation(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getSourceLocation(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean hasLanguage(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasLanguage(receiver_);
        }

        @TruffleBoundary
        @Override
        public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getLanguage(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean hasMetaObject(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasMetaObject(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getMetaObject(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getMetaObject(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object toDisplayString(Object receiver_, boolean allowSideEffects) {
            return INSTANCE.getUncached(receiver_).toDisplayString(receiver_, allowSideEffects);
        }

        @TruffleBoundary
        @Override
        public boolean isMetaObject(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isMetaObject(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getMetaQualifiedName(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getMetaQualifiedName(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getMetaSimpleName(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getMetaSimpleName(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isMetaInstance(Object receiver_, Object instance) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).isMetaInstance(receiver_, instance);
        }

        @TruffleBoundary
        @Override
        protected TriState isIdenticalOrUndefined(Object receiver_, Object other) {
            return INSTANCE.getUncached(receiver_).isIdenticalOrUndefined(receiver_, other);
        }

        @TruffleBoundary
        @Override
        public boolean isIdentical(Object receiver_, Object other, InteropLibrary otherInterop) {
            return INSTANCE.getUncached(receiver_).isIdentical(receiver_, other, otherInterop);
        }

        @TruffleBoundary
        @Override
        public int identityHashCode(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).identityHashCode(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean isScope(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isScope(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean hasScopeParent(Object receiver_) {
            return INSTANCE.getUncached(receiver_).hasScopeParent(receiver_);
        }

        @TruffleBoundary
        @Override
        public Object getScopeParent(Object receiver_) throws UnsupportedMessageException {
            return INSTANCE.getUncached(receiver_).getScopeParent(receiver_);
        }

        @TruffleBoundary
        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
    @GeneratedBy(InteropLibrary.class)
    private static final class CachedDispatchNext extends CachedDispatch {

        CachedDispatchNext(InteropLibrary library, CachedDispatch next) {
            super(library, next);
        }

        @Override
        int getLimit() {
            throw CompilerDirectives.shouldNotReachHere();
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

    }
    @GeneratedBy(InteropLibrary.class)
    private static final class CachedDispatchFirst extends CachedDispatch {

        private final int limit_;

        CachedDispatchFirst(InteropLibrary library, CachedDispatch next, int limit_) {
            super(library, next);
            this.limit_ = limit_;
        }

        @Override
        int getLimit() {
            return this.limit_;
        }

        @Override
        public NodeCost getCost() {
            if (this.library instanceof CachedToUncachedDispatch) {
                return NodeCost.MEGAMORPHIC;
            }
            CachedDispatch current = this;
            int count = 0;
            do {
                if (current.library != null) {
                    count++;
                }
                current = current.next;
            } while (current != null);
            return NodeCost.fromCount(count);
        }

    }
    @GeneratedBy(InteropLibrary.class)
    private abstract static class CachedDispatch extends InteropLibrary {

        @Child InteropLibrary library;
        @Child CachedDispatch next;

        CachedDispatch(InteropLibrary library, CachedDispatch next) {
            this.library = library;
            this.next = next;
        }

        abstract int getLimit();

        @ExplodeLoop
        @Override
        public boolean isNull(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isNull(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isBoolean(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isBoolean(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean asBoolean(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asBoolean(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isExecutable(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isExecutable(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object execute(Object receiver_, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.execute(receiver_, arguments);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasExecutableName(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasExecutableName(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getExecutableName(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getExecutableName(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasDeclaringMetaObject(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasDeclaringMetaObject(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getDeclaringMetaObject(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getDeclaringMetaObject(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isInstantiable(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isInstantiable(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object instantiate(Object receiver_, Object... arguments) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.instantiate(receiver_, arguments);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isString(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isString(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public String asString(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asString(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isNumber(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isNumber(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean fitsInByte(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.fitsInByte(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean fitsInShort(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.fitsInShort(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean fitsInInt(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.fitsInInt(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean fitsInLong(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.fitsInLong(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean fitsInFloat(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.fitsInFloat(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean fitsInDouble(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.fitsInDouble(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public byte asByte(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asByte(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public short asShort(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asShort(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public int asInt(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asInt(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public long asLong(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asLong(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public float asFloat(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asFloat(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public double asDouble(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asDouble(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasMembers(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasMembers(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getMembers(Object receiver_, boolean includeInternal) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getMembers(receiver_, includeInternal);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isMemberReadable(Object receiver_, String member) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isMemberReadable(receiver_, member);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object readMember(Object receiver_, String member) throws UnsupportedMessageException, UnknownIdentifierException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.readMember(receiver_, member);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isMemberModifiable(Object receiver_, String member) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isMemberModifiable(receiver_, member);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isMemberInsertable(Object receiver_, String member) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isMemberInsertable(receiver_, member);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void writeMember(Object receiver_, String member, Object value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.writeMember(receiver_, member, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isMemberRemovable(Object receiver_, String member) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isMemberRemovable(receiver_, member);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void removeMember(Object receiver_, String member) throws UnsupportedMessageException, UnknownIdentifierException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.removeMember(receiver_, member);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isMemberInvocable(Object receiver_, String member) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isMemberInvocable(receiver_, member);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object invokeMember(Object receiver_, String member, Object... arguments) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.invokeMember(receiver_, member, arguments);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isMemberInternal(Object receiver_, String member) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isMemberInternal(receiver_, member);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasMemberReadSideEffects(Object receiver_, String member) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasMemberReadSideEffects(receiver_, member);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasMemberWriteSideEffects(Object receiver_, String member) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasMemberWriteSideEffects(receiver_, member);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasHashEntries(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasHashEntries(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public long getHashSize(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getHashSize(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isHashEntryReadable(Object receiver_, Object key) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isHashEntryReadable(receiver_, key);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object readHashValue(Object receiver_, Object key) throws UnsupportedMessageException, UnknownKeyException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.readHashValue(receiver_, key);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object readHashValueOrDefault(Object receiver_, Object key, Object defaultValue) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.readHashValueOrDefault(receiver_, key, defaultValue);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isHashEntryModifiable(Object receiver_, Object key) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isHashEntryModifiable(receiver_, key);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isHashEntryInsertable(Object receiver_, Object key) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isHashEntryInsertable(receiver_, key);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isHashEntryWritable(Object receiver_, Object key) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isHashEntryWritable(receiver_, key);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void writeHashEntry(Object receiver_, Object key, Object value) throws UnsupportedMessageException, UnknownKeyException, UnsupportedTypeException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.writeHashEntry(receiver_, key, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isHashEntryRemovable(Object receiver_, Object key) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isHashEntryRemovable(receiver_, key);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void removeHashEntry(Object receiver_, Object key) throws UnsupportedMessageException, UnknownKeyException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.removeHashEntry(receiver_, key);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isHashEntryExisting(Object receiver_, Object key) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isHashEntryExisting(receiver_, key);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getHashEntriesIterator(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getHashEntriesIterator(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getHashKeysIterator(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getHashKeysIterator(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getHashValuesIterator(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getHashValuesIterator(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasArrayElements(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasArrayElements(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object readArrayElement(Object receiver_, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.readArrayElement(receiver_, index);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public long getArraySize(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getArraySize(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isArrayElementReadable(Object receiver_, long index) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isArrayElementReadable(receiver_, index);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void writeArrayElement(Object receiver_, long index, Object value) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.writeArrayElement(receiver_, index, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void removeArrayElement(Object receiver_, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.removeArrayElement(receiver_, index);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isArrayElementModifiable(Object receiver_, long index) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isArrayElementModifiable(receiver_, index);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isArrayElementInsertable(Object receiver_, long index) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isArrayElementInsertable(receiver_, index);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isArrayElementRemovable(Object receiver_, long index) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isArrayElementRemovable(receiver_, index);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasBufferElements(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasBufferElements(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isBufferWritable(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isBufferWritable(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public long getBufferSize(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getBufferSize(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public byte readBufferByte(Object receiver_, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.readBufferByte(receiver_, byteOffset);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void writeBufferByte(Object receiver_, long byteOffset, byte value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.writeBufferByte(receiver_, byteOffset, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public short readBufferShort(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.readBufferShort(receiver_, order, byteOffset);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void writeBufferShort(Object receiver_, ByteOrder order, long byteOffset, short value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.writeBufferShort(receiver_, order, byteOffset, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public int readBufferInt(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.readBufferInt(receiver_, order, byteOffset);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void writeBufferInt(Object receiver_, ByteOrder order, long byteOffset, int value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.writeBufferInt(receiver_, order, byteOffset, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public long readBufferLong(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.readBufferLong(receiver_, order, byteOffset);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void writeBufferLong(Object receiver_, ByteOrder order, long byteOffset, long value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.writeBufferLong(receiver_, order, byteOffset, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public float readBufferFloat(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.readBufferFloat(receiver_, order, byteOffset);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void writeBufferFloat(Object receiver_, ByteOrder order, long byteOffset, float value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.writeBufferFloat(receiver_, order, byteOffset, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public double readBufferDouble(Object receiver_, ByteOrder order, long byteOffset) throws UnsupportedMessageException, InvalidBufferOffsetException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.readBufferDouble(receiver_, order, byteOffset);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void writeBufferDouble(Object receiver_, ByteOrder order, long byteOffset, double value) throws UnsupportedMessageException, InvalidBufferOffsetException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.writeBufferDouble(receiver_, order, byteOffset, value);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isPointer(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isPointer(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public long asPointer(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asPointer(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public void toNative(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        thisLibrary.toNative(receiver_);
                        return;
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Instant asInstant(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asInstant(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isTimeZone(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isTimeZone(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public ZoneId asTimeZone(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asTimeZone(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isDate(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isDate(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public LocalDate asDate(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asDate(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isTime(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isTime(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public LocalTime asTime(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asTime(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isDuration(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isDuration(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Duration asDuration(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.asDuration(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isException(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isException(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public RuntimeException throwException(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.throwException(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public ExceptionType getExceptionType(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getExceptionType(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isExceptionIncompleteSource(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isExceptionIncompleteSource(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public int getExceptionExitStatus(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getExceptionExitStatus(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasExceptionCause(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasExceptionCause(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getExceptionCause(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getExceptionCause(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasExceptionMessage(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasExceptionMessage(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getExceptionMessage(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getExceptionMessage(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasExceptionStackTrace(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasExceptionStackTrace(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getExceptionStackTrace(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getExceptionStackTrace(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasIterator(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasIterator(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getIterator(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getIterator(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isIterator(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isIterator(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasIteratorNextElement(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasIteratorNextElement(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getIteratorNextElement(Object receiver_) throws UnsupportedMessageException, StopIterationException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getIteratorNextElement(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasSourceLocation(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasSourceLocation(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public SourceSection getSourceLocation(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getSourceLocation(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasLanguage(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasLanguage(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getLanguage(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasMetaObject(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasMetaObject(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getMetaObject(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getMetaObject(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object toDisplayString(Object receiver_, boolean allowSideEffects) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.toDisplayString(receiver_, allowSideEffects);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isMetaObject(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isMetaObject(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getMetaQualifiedName(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getMetaQualifiedName(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getMetaSimpleName(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getMetaSimpleName(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isMetaInstance(Object receiver_, Object instance) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isMetaInstance(receiver_, instance);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        protected TriState isIdenticalOrUndefined(Object receiver_, Object other) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isIdenticalOrUndefined(receiver_, other);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isIdentical(Object receiver_, Object other, InteropLibrary otherInterop) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isIdentical(receiver_, other, otherInterop);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public int identityHashCode(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.identityHashCode(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean isScope(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isScope(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public boolean hasScopeParent(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.hasScopeParent(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public Object getScopeParent(Object receiver_) throws UnsupportedMessageException {
            do {
                CachedDispatch current = this;
                do {
                    InteropLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.getScopeParent(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

        private void specialize(Object receiver_) {
            Lock lock = getLock();
            lock.lock();
            try {
                CachedDispatch current = this;
                InteropLibrary thisLibrary = current.library;
                if (thisLibrary == null) {
                    this.library = insert(INSTANCE.create(receiver_));
                } else {
                    int count = 0;
                    do {
                        InteropLibrary currentLibrary = current.library;
                        if (currentLibrary != null && currentLibrary.accepts(receiver_)) {
                            return;
                        }
                        count++;
                        current = current.next;
                    } while (current != null);
                    if (count >= getLimit()) {
                        this.library = insert(new CachedToUncachedDispatch());
                        this.next = null;
                    } else {
                        this.next = insert(new CachedDispatchNext(INSTANCE.create(receiver_), next));
                    }
                }
            } finally {
                lock.unlock();
            }
        }

    }
}
