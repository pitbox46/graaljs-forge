// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.builtins.NumberFunctionBuiltins.JSNumberIsFiniteNode;
import com.oracle.truffle.js.builtins.NumberFunctionBuiltins.JSNumberIsIntegerNode;
import com.oracle.truffle.js.builtins.NumberFunctionBuiltins.JSNumberIsNaNNode;
import com.oracle.truffle.js.builtins.NumberFunctionBuiltins.JSNumberIsSafeIntegerNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;

@GeneratedBy(NumberFunctionBuiltins.class)
public final class NumberFunctionBuiltinsFactory {

    @GeneratedBy(JSNumberIsNaNNode.class)
    public static final class JSNumberIsNaNNodeGen extends JSNumberIsNaNNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private JSNumberIsNaNNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) == 0 /* only-active isNaNDouble(double) */ && ((state_0 & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */)) {
                return execute_double0(state_0, frameValue);
            } else {
                return execute_generic1(state_0, frameValue);
            }
        }

        private Object execute_double0(int state_0, VirtualFrame frameValue) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state_0 & 0b111000) == 0 /* only-active 0:double */ && ((state_0 & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */)) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state_0 & 0b110100) == 0 /* only-active 0:double */ && ((state_0 & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */)) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state_0 & 0b101100) == 0 /* only-active 0:double */ && ((state_0 & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */)) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100) >>> 2 /* extract-implicit-state_0 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 isNaNDouble(double) */;
            return isNaNDouble(arguments0Value_);
        }

        private Object execute_generic1(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 isNaNNotDouble(Object) */) {
                if ((!(isDouble(arguments0Value_)))) {
                    return isNaNNotDouble(arguments0Value_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isNaNDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100) >>> 2 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b111100) >>> 2 /* extract-implicit-state_0 0:double */, arguments0Value_);
                return isNaNDouble(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1) == 0 /* only-active isNaNDouble(double) */ && ((state_0 & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */)) {
                return executeBoolean_double2(state_0, frameValue);
            } else {
                return executeBoolean_generic3(state_0, frameValue);
            }
        }

        private boolean executeBoolean_double2(int state_0, VirtualFrame frameValue) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state_0 & 0b111000) == 0 /* only-active 0:double */ && ((state_0 & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */)) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state_0 & 0b110100) == 0 /* only-active 0:double */ && ((state_0 & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */)) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state_0 & 0b101100) == 0 /* only-active 0:double */ && ((state_0 & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */)) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b111100) >>> 2 /* extract-implicit-state_0 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 isNaNDouble(double) */;
            return isNaNDouble(arguments0Value_);
        }

        private boolean executeBoolean_generic3(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 isNaNNotDouble(Object) */) {
                if ((!(isDouble(arguments0Value_)))) {
                    return isNaNNotDouble(arguments0Value_);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isNaNDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b111100) >>> 2 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b111100) >>> 2 /* extract-implicit-state_0 0:double */, arguments0Value_);
                return isNaNDouble(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if ((!(isDouble(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 isNaNNotDouble(Object) */;
                return isNaNNotDouble(arguments0Value);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    state_0 = (state_0 | (doubleCast0 << 2) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 isNaNDouble(double) */;
                    return isNaNDouble(arguments0Value_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b11) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b11) & ((state_0 & 0b11) - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "isNaNNotDouble";
            if ((state_0 & 0b1) != 0 /* is-state_0 isNaNNotDouble(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isNaNDouble";
            if ((state_0 & 0b10) != 0 /* is-state_0 isNaNDouble(double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSNumberIsNaNNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberIsNaNNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSNumberIsFiniteNode.class)
    public static final class JSNumberIsFiniteNodeGen extends JSNumberIsFiniteNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private JSNumberIsFiniteNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b110) == 0 /* only-active isFinite(int) */ && ((state_0 & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */)) {
                return execute_int0(state_0, frameValue);
            } else if ((state_0 & 0b101) == 0 /* only-active isFinite(double) */ && ((state_0 & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */)) {
                return execute_double1(state_0, frameValue);
            } else {
                return execute_generic2(state_0, frameValue);
            }
        }

        private Object execute_int0(int state_0, VirtualFrame frameValue) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b1) != 0 /* is-state_0 isFinite(int) */;
            return isFinite(arguments0Value_);
        }

        private Object execute_double1(int state_0, VirtualFrame frameValue) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state_0 & 0b1110000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */)) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state_0 & 0b1101000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */)) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state_0 & 0b1011000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */)) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 isFinite(double) */;
            return isFinite(arguments0Value_);
        }

        private Object execute_generic2(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 isFinite(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return isFinite(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isFinite(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value_);
                return isFinite(arguments0Value__);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 isFinite(Object) */) {
                if ((!(JSGuards.isNumber(arguments0Value_)))) {
                    return isFinite(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b110) == 0 /* only-active isFinite(int) */ && ((state_0 & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */)) {
                return executeBoolean_int3(state_0, frameValue);
            } else if ((state_0 & 0b101) == 0 /* only-active isFinite(double) */ && ((state_0 & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */)) {
                return executeBoolean_double4(state_0, frameValue);
            } else {
                return executeBoolean_generic5(state_0, frameValue);
            }
        }

        private boolean executeBoolean_int3(int state_0, VirtualFrame frameValue) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b1) != 0 /* is-state_0 isFinite(int) */;
            return isFinite(arguments0Value_);
        }

        private boolean executeBoolean_double4(int state_0, VirtualFrame frameValue) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state_0 & 0b1110000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */)) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state_0 & 0b1101000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */)) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state_0 & 0b1011000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */)) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 isFinite(double) */;
            return isFinite(arguments0Value_);
        }

        private boolean executeBoolean_generic5(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 isFinite(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return isFinite(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isFinite(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value_);
                return isFinite(arguments0Value__);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 isFinite(Object) */) {
                if ((!(JSGuards.isNumber(arguments0Value_)))) {
                    return isFinite(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof Integer) {
                int arguments0Value_ = (int) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 isFinite(int) */;
                return isFinite(arguments0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    state_0 = (state_0 | (doubleCast0 << 3) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 isFinite(double) */;
                    return isFinite(arguments0Value_);
                }
            }
            if ((!(JSGuards.isNumber(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 isFinite(Object) */;
                return isFinite(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "isFinite";
            if ((state_0 & 0b1) != 0 /* is-state_0 isFinite(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isFinite";
            if ((state_0 & 0b10) != 0 /* is-state_0 isFinite(double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "isFinite";
            if ((state_0 & 0b100) != 0 /* is-state_0 isFinite(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSNumberIsFiniteNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberIsFiniteNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSNumberIsIntegerNode.class)
    public static final class JSNumberIsIntegerNodeGen extends JSNumberIsIntegerNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private JSNumberIsIntegerNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1110) == 0 /* only-active isInteger(int) */ && ((state_0 & 0b1111) != 0  /* is-not isInteger(int) && isInteger(SafeInteger) && isInteger(double) && isInteger(Object) */)) {
                return execute_int0(state_0, frameValue);
            } else if ((state_0 & 0b1011) == 0 /* only-active isInteger(double) */ && ((state_0 & 0b1111) != 0  /* is-not isInteger(int) && isInteger(SafeInteger) && isInteger(double) && isInteger(Object) */)) {
                return execute_double1(state_0, frameValue);
            } else {
                return execute_generic2(state_0, frameValue);
            }
        }

        private Object execute_int0(int state_0, VirtualFrame frameValue) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b1) != 0 /* is-state_0 isInteger(int) */;
            return JSNumberIsIntegerNode.isInteger(arguments0Value_);
        }

        private Object execute_double1(int state_0, VirtualFrame frameValue) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInteger(int) && isInteger(SafeInteger) && isInteger(double) && isInteger(Object) */)) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInteger(int) && isInteger(SafeInteger) && isInteger(double) && isInteger(Object) */)) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state_0 & 0b10110000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInteger(int) && isInteger(SafeInteger) && isInteger(double) && isInteger(Object) */)) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b100) != 0 /* is-state_0 isInteger(double) */;
            return JSNumberIsIntegerNode.isInteger(arguments0Value_);
        }

        private Object execute_generic2(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 isInteger(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return JSNumberIsIntegerNode.isInteger(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isInteger(SafeInteger) */ && arguments0Value_ instanceof SafeInteger) {
                SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                return JSNumberIsIntegerNode.isInteger(arguments0Value__);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 isInteger(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_);
                return JSNumberIsIntegerNode.isInteger(arguments0Value__);
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 isInteger(Object) */) {
                if ((!(JSGuards.isNumber(arguments0Value_)))) {
                    return JSNumberIsIntegerNode.isInteger(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1110) == 0 /* only-active isInteger(int) */ && ((state_0 & 0b1111) != 0  /* is-not isInteger(int) && isInteger(SafeInteger) && isInteger(double) && isInteger(Object) */)) {
                return executeBoolean_int3(state_0, frameValue);
            } else if ((state_0 & 0b1011) == 0 /* only-active isInteger(double) */ && ((state_0 & 0b1111) != 0  /* is-not isInteger(int) && isInteger(SafeInteger) && isInteger(double) && isInteger(Object) */)) {
                return executeBoolean_double4(state_0, frameValue);
            } else {
                return executeBoolean_generic5(state_0, frameValue);
            }
        }

        private boolean executeBoolean_int3(int state_0, VirtualFrame frameValue) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b1) != 0 /* is-state_0 isInteger(int) */;
            return JSNumberIsIntegerNode.isInteger(arguments0Value_);
        }

        private boolean executeBoolean_double4(int state_0, VirtualFrame frameValue) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state_0 & 0b11100000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInteger(int) && isInteger(SafeInteger) && isInteger(double) && isInteger(Object) */)) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state_0 & 0b11010000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInteger(int) && isInteger(SafeInteger) && isInteger(double) && isInteger(Object) */)) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state_0 & 0b10110000) == 0 /* only-active 0:double */ && ((state_0 & 0b1111) != 0  /* is-not isInteger(int) && isInteger(SafeInteger) && isInteger(double) && isInteger(Object) */)) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b100) != 0 /* is-state_0 isInteger(double) */;
            return JSNumberIsIntegerNode.isInteger(arguments0Value_);
        }

        private boolean executeBoolean_generic5(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 isInteger(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return JSNumberIsIntegerNode.isInteger(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isInteger(SafeInteger) */ && arguments0Value_ instanceof SafeInteger) {
                SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                return JSNumberIsIntegerNode.isInteger(arguments0Value__);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 isInteger(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b11110000) >>> 4 /* extract-implicit-state_0 0:double */, arguments0Value_);
                return JSNumberIsIntegerNode.isInteger(arguments0Value__);
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 isInteger(Object) */) {
                if ((!(JSGuards.isNumber(arguments0Value_)))) {
                    return JSNumberIsIntegerNode.isInteger(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof Integer) {
                int arguments0Value_ = (int) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 isInteger(int) */;
                return JSNumberIsIntegerNode.isInteger(arguments0Value_);
            }
            if (arguments0Value instanceof SafeInteger) {
                SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 isInteger(SafeInteger) */;
                return JSNumberIsIntegerNode.isInteger(arguments0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    state_0 = (state_0 | (doubleCast0 << 4) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 isInteger(double) */;
                    return JSNumberIsIntegerNode.isInteger(arguments0Value_);
                }
            }
            if ((!(JSGuards.isNumber(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 isInteger(Object) */;
                return JSNumberIsIntegerNode.isInteger(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b1111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b1111) & ((state_0 & 0b1111) - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "isInteger";
            if ((state_0 & 0b1) != 0 /* is-state_0 isInteger(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isInteger";
            if ((state_0 & 0b10) != 0 /* is-state_0 isInteger(SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "isInteger";
            if ((state_0 & 0b100) != 0 /* is-state_0 isInteger(double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "isInteger";
            if ((state_0 & 0b1000) != 0 /* is-state_0 isInteger(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSNumberIsIntegerNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberIsIntegerNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSNumberIsSafeIntegerNode.class)
    public static final class JSNumberIsSafeIntegerNodeGen extends JSNumberIsSafeIntegerNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private JSNumberIsSafeIntegerNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b110) == 0 /* only-active isSafeIntegerInt(int) */ && ((state_0 & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */)) {
                return execute_int0(state_0, frameValue);
            } else if ((state_0 & 0b101) == 0 /* only-active isSafeIntegerDouble(double) */ && ((state_0 & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */)) {
                return execute_double1(state_0, frameValue);
            } else {
                return execute_generic2(state_0, frameValue);
            }
        }

        private Object execute_int0(int state_0, VirtualFrame frameValue) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b1) != 0 /* is-state_0 isSafeIntegerInt(int) */;
            return isSafeIntegerInt(arguments0Value_);
        }

        private Object execute_double1(int state_0, VirtualFrame frameValue) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state_0 & 0b1110000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */)) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state_0 & 0b1101000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */)) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state_0 & 0b1011000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */)) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 isSafeIntegerDouble(double) */;
            return isSafeIntegerDouble(arguments0Value_);
        }

        private Object execute_generic2(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 isSafeIntegerInt(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return isSafeIntegerInt(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isSafeIntegerDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value_);
                return isSafeIntegerDouble(arguments0Value__);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 isSafeIntegerNotANumber(Object) */) {
                if ((!(JSGuards.isNumber(arguments0Value_)))) {
                    return isSafeIntegerNotANumber(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if ((state_0 & 0b110) == 0 /* only-active isSafeIntegerInt(int) */ && ((state_0 & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */)) {
                return executeBoolean_int3(state_0, frameValue);
            } else if ((state_0 & 0b101) == 0 /* only-active isSafeIntegerDouble(double) */ && ((state_0 & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */)) {
                return executeBoolean_double4(state_0, frameValue);
            } else {
                return executeBoolean_generic5(state_0, frameValue);
            }
        }

        private boolean executeBoolean_int3(int state_0, VirtualFrame frameValue) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b1) != 0 /* is-state_0 isSafeIntegerInt(int) */;
            return isSafeIntegerInt(arguments0Value_);
        }

        private boolean executeBoolean_double4(int state_0, VirtualFrame frameValue) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state_0 & 0b1110000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */)) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state_0 & 0b1101000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */)) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state_0 & 0b1011000) == 0 /* only-active 0:double */ && ((state_0 & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */)) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state_0 & 0b10) != 0 /* is-state_0 isSafeIntegerDouble(double) */;
            return isSafeIntegerDouble(arguments0Value_);
        }

        private boolean executeBoolean_generic5(int state_0, VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 isSafeIntegerInt(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return isSafeIntegerInt(arguments0Value__);
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 isSafeIntegerDouble(double) */ && JSTypesGen.isImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state_0 & 0b1111000) >>> 3 /* extract-implicit-state_0 0:double */, arguments0Value_);
                return isSafeIntegerDouble(arguments0Value__);
            }
            if ((state_0 & 0b100) != 0 /* is-state_0 isSafeIntegerNotANumber(Object) */) {
                if ((!(JSGuards.isNumber(arguments0Value_)))) {
                    return isSafeIntegerNotANumber(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof Integer) {
                int arguments0Value_ = (int) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 isSafeIntegerInt(int) */;
                return isSafeIntegerInt(arguments0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    state_0 = (state_0 | (doubleCast0 << 3) /* set-implicit-state_0 0:double */);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 isSafeIntegerDouble(double) */;
                    return isSafeIntegerDouble(arguments0Value_);
                }
            }
            if ((!(JSGuards.isNumber(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 isSafeIntegerNotANumber(Object) */;
                return isSafeIntegerNotANumber(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if ((state_0 & 0b111) == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if (((state_0 & 0b111) & ((state_0 & 0b111) - 1)) == 0 /* is-single-state_0  */) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state_0 = this.state_0_;
            s = new Object[3];
            s[0] = "isSafeIntegerInt";
            if ((state_0 & 0b1) != 0 /* is-state_0 isSafeIntegerInt(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isSafeIntegerDouble";
            if ((state_0 & 0b10) != 0 /* is-state_0 isSafeIntegerDouble(double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "isSafeIntegerNotANumber";
            if ((state_0 & 0b100) != 0 /* is-state_0 isSafeIntegerNotANumber(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSNumberIsSafeIntegerNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberIsSafeIntegerNodeGen(context, builtin, arguments);
        }

    }
}
