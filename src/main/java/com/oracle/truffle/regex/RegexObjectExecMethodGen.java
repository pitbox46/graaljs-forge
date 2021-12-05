// CheckStyle: start generated
package com.oracle.truffle.regex;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.memory.MemoryFence;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.regex.RegexObject.ExecCompiledRegexNode;
import com.oracle.truffle.regex.RegexObject.RegexObjectExecMethod;
import com.oracle.truffle.regex.RegexObjectFactory.ExecCompiledRegexNodeGen;
import com.oracle.truffle.regex.runtime.nodes.ExpectStringOrTruffleObjectNode;
import com.oracle.truffle.regex.runtime.nodes.ExpectStringOrTruffleObjectNodeGen;
import com.oracle.truffle.regex.runtime.nodes.ToLongNode;
import com.oracle.truffle.regex.runtime.nodes.ToLongNodeGen;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RegexObjectExecMethod.class)
final class RegexObjectExecMethodGen {

    static  {
        LibraryExport.register(RegexObjectExecMethod.class, new InteropLibraryExports());
    }

    private RegexObjectExecMethodGen() {
    }

    @GeneratedBy(RegexObjectExecMethod.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, RegexObjectExecMethod.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof RegexObjectExecMethod;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof RegexObjectExecMethod;
            return new Cached(receiver);
        }

        @GeneratedBy(RegexObjectExecMethod.class)
        private static final class Cached extends AbstractRegexObjectGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @Child private ExecuteData execute_cache;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @Override
            public boolean isExecutable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((RegexObjectExecMethod) receiver)).isExecutable();
            }

            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                RegexObjectExecMethod arg0Value = ((RegexObjectExecMethod) arg0Value_);
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 execute(RegexObjectExecMethod, Object[], ExpectStringOrTruffleObjectNode, ToLongNode, ExecCompiledRegexNode) */) {
                    ExecuteData s0_ = this.execute_cache;
                    if (s0_ != null) {
                        return arg0Value.execute(arg1Value, s0_.expectStringOrTruffleObjectNode_, s0_.toLongNode_, s0_.execNode_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value);
            }

            private Object executeAndSpecialize(RegexObjectExecMethod arg0Value, Object[] arg1Value) throws ArityException, UnsupportedTypeException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    ExecuteData s0_ = super.insert(new ExecuteData());
                    s0_.expectStringOrTruffleObjectNode_ = s0_.insertAccessor((ExpectStringOrTruffleObjectNode.create()));
                    s0_.toLongNode_ = s0_.insertAccessor((ToLongNode.create()));
                    s0_.execNode_ = s0_.insertAccessor((ExecCompiledRegexNodeGen.create()));
                    MemoryFence.storeStore();
                    this.execute_cache = s0_;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 execute(RegexObjectExecMethod, Object[], ExpectStringOrTruffleObjectNode, ToLongNode, ExecCompiledRegexNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.execute(arg1Value, s0_.expectStringOrTruffleObjectNode_, s0_.toLongNode_, s0_.execNode_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public NodeCost getCost() {
                int state_0 = this.state_0_;
                if (state_0 == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    return NodeCost.MONOMORPHIC;
                }
            }

            @GeneratedBy(RegexObjectExecMethod.class)
            private static final class ExecuteData extends Node {

                @Child ExpectStringOrTruffleObjectNode expectStringOrTruffleObjectNode_;
                @Child ToLongNode toLongNode_;
                @Child ExecCompiledRegexNode execNode_;

                ExecuteData() {
                }

                @Override
                public NodeCost getCost() {
                    return NodeCost.NONE;
                }

                <T extends Node> T insertAccessor(T node) {
                    return super.insert(node);
                }

            }
        }
        @GeneratedBy(RegexObjectExecMethod.class)
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
            public boolean isExecutable(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((RegexObjectExecMethod) receiver) .isExecutable();
            }

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws ArityException, UnsupportedTypeException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                RegexObjectExecMethod arg0Value = ((RegexObjectExecMethod) arg0Value_);
                return arg0Value.execute(arg1Value, (ExpectStringOrTruffleObjectNodeGen.getUncached()), (ToLongNodeGen.getUncached()), (ExecCompiledRegexNodeGen.getUncached()));
            }

        }
    }
}
