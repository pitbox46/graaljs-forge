// CheckStyle: start generated
package com.oracle.truffle.regex.result;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.regex.AbstractRegexObjectGen;
import com.oracle.truffle.regex.result.RegexResult.RegexResultGetEndMethod;
import com.oracle.truffle.regex.result.RegexResult.RegexResultGetEndNode;
import com.oracle.truffle.regex.result.RegexResultFactory.RegexResultGetEndNodeGen;
import com.oracle.truffle.regex.runtime.nodes.ToIntNode;
import com.oracle.truffle.regex.runtime.nodes.ToIntNodeGen;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RegexResultGetEndMethod.class)
final class RegexResultGetEndMethodGen {

    static  {
        LibraryExport.register(RegexResultGetEndMethod.class, new InteropLibraryExports());
    }

    private RegexResultGetEndMethodGen() {
    }

    @GeneratedBy(RegexResultGetEndMethod.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, RegexResultGetEndMethod.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof RegexResultGetEndMethod;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof RegexResultGetEndMethod;
            return new Cached(receiver);
        }

        @GeneratedBy(RegexResultGetEndMethod.class)
        private static final class Cached extends AbstractRegexObjectGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @Child private ToIntNode toIntNode_;
            @Child private RegexResultGetEndNode getEndNode_;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @Override
            public boolean isExecutable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((RegexResultGetEndMethod) receiver)).isExecutable();
            }

            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                RegexResultGetEndMethod arg0Value = ((RegexResultGetEndMethod) arg0Value_);
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 execute(RegexResultGetEndMethod, Object[], ToIntNode, RegexResultGetEndNode) */) {
                    return arg0Value.execute(arg1Value, this.toIntNode_, this.getEndNode_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value);
            }

            private int executeAndSpecialize(RegexResultGetEndMethod arg0Value, Object[] arg1Value) throws ArityException, UnsupportedTypeException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.toIntNode_ = super.insert((ToIntNode.create()));
                    this.getEndNode_ = super.insert((RegexResultGetEndNodeGen.create()));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 execute(RegexResultGetEndMethod, Object[], ToIntNode, RegexResultGetEndNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.execute(arg1Value, this.toIntNode_, this.getEndNode_);
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

        }
        @GeneratedBy(RegexResultGetEndMethod.class)
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
                return ((RegexResultGetEndMethod) receiver) .isExecutable();
            }

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws ArityException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                RegexResultGetEndMethod arg0Value = ((RegexResultGetEndMethod) arg0Value_);
                return arg0Value.execute(arg1Value, (ToIntNodeGen.getUncached()), (RegexResultGetEndNodeGen.getUncached()));
            }

        }
    }
}
