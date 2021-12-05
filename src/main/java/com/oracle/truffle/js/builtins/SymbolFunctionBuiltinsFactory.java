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
import com.oracle.truffle.js.builtins.SymbolFunctionBuiltins.SymbolForNode;
import com.oracle.truffle.js.builtins.SymbolFunctionBuiltins.SymbolKeyForNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.Symbol;

@GeneratedBy(SymbolFunctionBuiltins.class)
public final class SymbolFunctionBuiltinsFactory {

    @GeneratedBy(SymbolForNode.class)
    public static final class SymbolForNodeGen extends SymbolForNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;

        private SymbolForNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return symbolFor(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "symbolFor";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static SymbolForNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new SymbolForNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(SymbolKeyForNode.class)
    public static final class SymbolKeyForNodeGen extends SymbolKeyForNode implements Introspection.Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_0_;

        private SymbolKeyForNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state_0 & 0b1) != 0 /* is-state_0 symbolKeyFor(Symbol) */ && arguments0Value_ instanceof Symbol) {
                Symbol arguments0Value__ = (Symbol) arguments0Value_;
                if ((JSGuards.isSymbol(arguments0Value__))) {
                    return symbolKeyFor(arguments0Value__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is-state_0 valueOf(Object) */) {
                if ((!(JSGuards.isSymbol(arguments0Value_)))) {
                    return SymbolKeyForNode.valueOf(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof Symbol) {
                Symbol arguments0Value_ = (Symbol) arguments0Value;
                if ((JSGuards.isSymbol(arguments0Value_))) {
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 symbolKeyFor(Symbol) */;
                    return symbolKeyFor(arguments0Value_);
                }
            }
            if ((!(JSGuards.isSymbol(arguments0Value)))) {
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 valueOf(Object) */;
                return SymbolKeyForNode.valueOf(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if (state_0 == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
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
            s[0] = "symbolKeyFor";
            if ((state_0 & 0b1) != 0 /* is-state_0 symbolKeyFor(Symbol) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "valueOf";
            if ((state_0 & 0b10) != 0 /* is-state_0 valueOf(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static SymbolKeyForNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new SymbolKeyForNodeGen(context, builtin, arguments);
        }

    }
}
