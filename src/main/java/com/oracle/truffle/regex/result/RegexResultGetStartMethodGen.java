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
import com.oracle.truffle.regex.result.RegexResult.RegexResultGetStartMethod;
import com.oracle.truffle.regex.result.RegexResult.RegexResultGetStartNode;
import com.oracle.truffle.regex.result.RegexResultFactory.RegexResultGetStartNodeGen;
import com.oracle.truffle.regex.runtime.nodes.ToIntNode;
import com.oracle.truffle.regex.runtime.nodes.ToIntNodeGen;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RegexResultGetStartMethod.class)
final class RegexResultGetStartMethodGen {

    static  {
        LibraryExport.register(RegexResultGetStartMethod.class, new InteropLibraryExports());
    }

    private RegexResultGetStartMethodGen() {
    }

    @GeneratedBy(RegexResultGetStartMethod.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, RegexResultGetStartMethod.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof RegexResultGetStartMethod;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof RegexResultGetStartMethod;
            return new Cached(receiver);
        }

        @GeneratedBy(RegexResultGetStartMethod.class)
        private static final class Cached extends AbstractRegexObjectGen.InteropLibraryExports.Cached {

            @CompilationFinal private volatile int state_0_;
            @Child private ToIntNode toIntNode_;
            @Child private RegexResultGetStartNode getStartNode_;

            protected Cached(Object receiver) {
                super(receiver);
            }

            @Override
            public boolean isExecutable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((RegexResultGetStartMethod) receiver)).isExecutable();
            }

            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                RegexResultGetStartMethod arg0Value = ((RegexResultGetStartMethod) arg0Value_);
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 execute(RegexResultGetStartMethod, Object[], ToIntNode, RegexResultGetStartNode) */) {
                    return arg0Value.execute(arg1Value, this.toIntNode_, this.getStartNode_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value);
            }

            private int executeAndSpecialize(RegexResultGetStartMethod arg0Value, Object[] arg1Value) throws ArityException, UnsupportedTypeException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.toIntNode_ = super.insert((ToIntNode.create()));
                    this.getStartNode_ = super.insert((RegexResultGetStartNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 execute(RegexResultGetStartMethod, Object[], ToIntNode, RegexResultGetStartNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.execute(arg1Value, this.toIntNode_, this.getStartNode_);
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
        @GeneratedBy(RegexResultGetStartMethod.class)
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
                return ((RegexResultGetStartMethod) receiver) .isExecutable();
            }

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws ArityException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                RegexResultGetStartMethod arg0Value = ((RegexResultGetStartMethod) arg0Value_);
                return arg0Value.execute(arg1Value, (ToIntNodeGen.getUncached()), (RegexResultGetStartNodeGen.getUncached()));
            }

        }
    }
}
