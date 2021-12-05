package com.oracle.truffle.js.nodes;

@com.oracle.truffle.api.dsl.GeneratedBy(com.oracle.truffle.js.nodes.NodeFactory.class)
public class NodeFactoryProxyGen extends com.oracle.truffle.js.nodes.NodeFactory {
private final java.lang.reflect.InvocationHandler handler;
private NodeFactoryProxyGen(java.lang.reflect.InvocationHandler handler) {
this.handler = handler;
}

public static com.oracle.truffle.js.nodes.NodeFactory create(java.lang.reflect.InvocationHandler handler) {
return new NodeFactoryProxyGen(handler);
}

private final java.lang.reflect.Method methods[] = new java.lang.reflect.Method[182];

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createUnary (com.oracle.truffle.js.nodes.NodeFactory.UnaryOperation arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[0];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createUnary", com.oracle.truffle.js.nodes.NodeFactory.UnaryOperation.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[0] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createLocalVarInc (com.oracle.truffle.js.nodes.NodeFactory.UnaryOperation arg0, com.oracle.truffle.api.frame.FrameSlot arg1, boolean arg2, com.oracle.truffle.js.nodes.access.ScopeFrameNode arg3, com.oracle.truffle.api.frame.FrameDescriptor arg4) {
java.lang.reflect.Method method = methods[1];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createLocalVarInc", com.oracle.truffle.js.nodes.NodeFactory.UnaryOperation.class, com.oracle.truffle.api.frame.FrameSlot.class, boolean.class, com.oracle.truffle.js.nodes.access.ScopeFrameNode.class, com.oracle.truffle.api.frame.FrameDescriptor.class);
methods[1] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createToNumericOperand (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[2];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createToNumericOperand", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[2] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createDual (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[3];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDual", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[3] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createBinary (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.NodeFactory.BinaryOperation arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3) {
java.lang.reflect.Method method = methods[4];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createBinary", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.NodeFactory.BinaryOperation.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[4] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createTypeofIdentical (com.oracle.truffle.js.nodes.JavaScriptNode arg0, java.lang.String arg1) {
java.lang.reflect.Method method = methods[5];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createTypeofIdentical", com.oracle.truffle.js.nodes.JavaScriptNode.class, java.lang.String.class);
methods[5] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createLogicalOr (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[6];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createLogicalOr", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[6] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createNotUndefinedOr (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[7];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createNotUndefinedOr", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[7] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createConstant (java.lang.Object arg0) {
java.lang.reflect.Method method = methods[8];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createConstant", java.lang.Object.class);
methods[8] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createConstantBoolean (boolean arg0) {
java.lang.reflect.Method method = methods[9];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createConstantBoolean", boolean.class);
methods[9] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createConstantInteger (int arg0) {
java.lang.reflect.Method method = methods[10];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createConstantInteger", int.class);
methods[10] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createConstantSafeInteger (long arg0) {
java.lang.reflect.Method method = methods[11];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createConstantSafeInteger", long.class);
methods[11] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createConstantNumericUnit () {
java.lang.reflect.Method method = methods[12];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createConstantNumericUnit");
methods[12] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createConstantDouble (double arg0) {
java.lang.reflect.Method method = methods[13];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createConstantDouble", double.class);
methods[13] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createConstantString (java.lang.String arg0) {
java.lang.reflect.Method method = methods[14];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createConstantString", java.lang.String.class);
methods[14] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createConstantUndefined () {
java.lang.reflect.Method method = methods[15];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createConstantUndefined");
methods[15] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createConstantNull () {
java.lang.reflect.Method method = methods[16];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createConstantNull");
methods[16] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.IfNode createIf (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[17];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createIf", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[17] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.control.IfNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.SwitchNode createSwitch (com.oracle.truffle.js.nodes.JavaScriptNode[] arg0, int[] arg1, com.oracle.truffle.js.nodes.JavaScriptNode[] arg2) {
java.lang.reflect.Method method = methods[18];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createSwitch", com.oracle.truffle.js.nodes.JavaScriptNode[].class, int[].class, com.oracle.truffle.js.nodes.JavaScriptNode[].class);
methods[18] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.control.SwitchNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createWhileDo (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[19];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createWhileDo", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[19] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createDoWhile (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[20];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDoWhile", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[20] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createDesugaredFor (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[21];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDesugaredFor", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[21] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createDesugaredForOf (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[22];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDesugaredForOf", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[22] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createDesugaredForIn (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[23];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDesugaredForIn", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[23] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createDesugaredForAwaitOf (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[24];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDesugaredForAwaitOf", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[24] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.StatementNode createFor (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.api.frame.FrameDescriptor arg3, com.oracle.truffle.js.nodes.JavaScriptNode arg4, com.oracle.truffle.js.nodes.JavaScriptNode arg5, com.oracle.truffle.api.frame.FrameSlot arg6) {
java.lang.reflect.Method method = methods[25];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createFor", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.api.frame.FrameDescriptor.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.api.frame.FrameSlot.class);
methods[25] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4, arg5, arg6};
try {
return (com.oracle.truffle.js.nodes.control.StatementNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.function.IterationScopeNode createIterationScope (com.oracle.truffle.api.frame.FrameDescriptor arg0, com.oracle.truffle.api.frame.FrameSlot arg1) {
java.lang.reflect.Method method = methods[26];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createIterationScope", com.oracle.truffle.api.frame.FrameDescriptor.class, com.oracle.truffle.api.frame.FrameSlot.class);
methods[26] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.function.IterationScopeNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.BreakNode createBreak (com.oracle.truffle.js.nodes.control.BreakTarget arg0) {
java.lang.reflect.Method method = methods[27];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createBreak", com.oracle.truffle.js.nodes.control.BreakTarget.class);
methods[27] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.control.BreakNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.ContinueNode createContinue (com.oracle.truffle.js.nodes.control.ContinueTarget arg0) {
java.lang.reflect.Method method = methods[28];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createContinue", com.oracle.truffle.js.nodes.control.ContinueTarget.class);
methods[28] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.control.ContinueNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.LabelNode createLabel (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.control.BreakTarget arg1) {
java.lang.reflect.Method method = methods[29];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createLabel", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.control.BreakTarget.class);
methods[29] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.control.LabelNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createEmpty () {
java.lang.reflect.Method method = methods[30];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createEmpty");
methods[30] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createVoidBlock (com.oracle.truffle.js.nodes.JavaScriptNode... arg0) {
java.lang.reflect.Method method = methods[31];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createVoidBlock", com.oracle.truffle.js.nodes.JavaScriptNode[].class);
methods[31] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createExprBlock (com.oracle.truffle.js.nodes.JavaScriptNode... arg0) {
java.lang.reflect.Method method = methods[32];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createExprBlock", com.oracle.truffle.js.nodes.JavaScriptNode[].class);
methods[32] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.ReturnTargetNode createReturnTarget (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[33];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createReturnTarget", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[33] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.control.ReturnTargetNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.ReturnTargetNode createFrameReturnTarget (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[34];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createFrameReturnTarget", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[34] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.control.ReturnTargetNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.ContinueTargetNode createContinueTarget (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.control.ContinueTarget arg1) {
java.lang.reflect.Method method = methods[35];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createContinueTarget", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.control.ContinueTarget.class);
methods[35] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.control.ContinueTargetNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.DirectBreakTargetNode createDirectBreakTarget (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[36];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDirectBreakTarget", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[36] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.control.DirectBreakTargetNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createDebugger () {
java.lang.reflect.Method method = methods[37];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDebugger");
methods[37] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createLocal (com.oracle.truffle.api.frame.FrameSlot arg0, int arg1, int arg2, com.oracle.truffle.api.frame.FrameSlot[] arg3) {
java.lang.reflect.Method method = methods[38];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createLocal", com.oracle.truffle.api.frame.FrameSlot.class, int.class, int.class, com.oracle.truffle.api.frame.FrameSlot[].class);
methods[38] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createReadFrameSlot (com.oracle.truffle.api.frame.FrameSlot arg0, com.oracle.truffle.js.nodes.access.ScopeFrameNode arg1) {
java.lang.reflect.Method method = methods[39];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createReadFrameSlot", com.oracle.truffle.api.frame.FrameSlot.class, com.oracle.truffle.js.nodes.access.ScopeFrameNode.class);
methods[39] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createReadFrameSlot (com.oracle.truffle.api.frame.FrameSlot arg0, com.oracle.truffle.js.nodes.access.ScopeFrameNode arg1, boolean arg2) {
java.lang.reflect.Method method = methods[40];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createReadFrameSlot", com.oracle.truffle.api.frame.FrameSlot.class, com.oracle.truffle.js.nodes.access.ScopeFrameNode.class, boolean.class);
methods[40] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createReadCurrentFrameSlot (com.oracle.truffle.api.frame.FrameSlot arg0) {
java.lang.reflect.Method method = methods[41];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createReadCurrentFrameSlot", com.oracle.truffle.api.frame.FrameSlot.class);
methods[41] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode createWriteFrameSlot (com.oracle.truffle.api.frame.FrameSlot arg0, com.oracle.truffle.js.nodes.access.ScopeFrameNode arg1, com.oracle.truffle.api.frame.FrameDescriptor arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3) {
java.lang.reflect.Method method = methods[42];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createWriteFrameSlot", com.oracle.truffle.api.frame.FrameSlot.class, com.oracle.truffle.js.nodes.access.ScopeFrameNode.class, com.oracle.truffle.api.frame.FrameDescriptor.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[42] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode createWriteFrameSlot (com.oracle.truffle.api.frame.FrameSlot arg0, com.oracle.truffle.js.nodes.access.ScopeFrameNode arg1, com.oracle.truffle.api.frame.FrameDescriptor arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3, boolean arg4) {
java.lang.reflect.Method method = methods[43];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createWriteFrameSlot", com.oracle.truffle.api.frame.FrameSlot.class, com.oracle.truffle.js.nodes.access.ScopeFrameNode.class, com.oracle.truffle.api.frame.FrameDescriptor.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, boolean.class);
methods[43] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode createWriteCurrentFrameSlot (com.oracle.truffle.api.frame.FrameSlot arg0, com.oracle.truffle.api.frame.FrameDescriptor arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[44];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createWriteCurrentFrameSlot", com.oracle.truffle.api.frame.FrameSlot.class, com.oracle.truffle.api.frame.FrameDescriptor.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[44] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ScopeFrameNode createScopeFrame (int arg0, int arg1, com.oracle.truffle.api.frame.FrameSlot[] arg2, com.oracle.truffle.api.frame.FrameSlot arg3) {
java.lang.reflect.Method method = methods[45];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createScopeFrame", int.class, int.class, com.oracle.truffle.api.frame.FrameSlot[].class, com.oracle.truffle.api.frame.FrameSlot.class);
methods[45] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.access.ScopeFrameNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createReadLexicalGlobal (java.lang.String arg0, boolean arg1, com.oracle.truffle.js.runtime.JSContext arg2) {
java.lang.reflect.Method method = methods[46];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createReadLexicalGlobal", java.lang.String.class, boolean.class, com.oracle.truffle.js.runtime.JSContext.class);
methods[46] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGlobalScope (com.oracle.truffle.js.runtime.JSContext arg0) {
java.lang.reflect.Method method = methods[47];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGlobalScope", com.oracle.truffle.js.runtime.JSContext.class);
methods[47] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGlobalScopeTDZCheck (com.oracle.truffle.js.runtime.JSContext arg0, java.lang.String arg1, boolean arg2) {
java.lang.reflect.Method method = methods[48];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGlobalScopeTDZCheck", com.oracle.truffle.js.runtime.JSContext.class, java.lang.String.class, boolean.class);
methods[48] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGlobalVarWrapper (java.lang.String arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.nodes.access.JSTargetableNode arg3) {
java.lang.reflect.Method method = methods[49];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGlobalVarWrapper", java.lang.String.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSTargetableNode.class);
methods[49] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createThrow (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[50];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createThrow", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[50] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createTryCatch (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3, com.oracle.truffle.js.nodes.function.BlockScopeNode arg4, com.oracle.truffle.js.nodes.JavaScriptNode arg5, com.oracle.truffle.js.nodes.JavaScriptNode arg6) {
java.lang.reflect.Method method = methods[51];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createTryCatch", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.function.BlockScopeNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[51] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4, arg5, arg6};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createTryFinally (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[52];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createTryFinally", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[52] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createFunctionCall (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode[] arg2) {
java.lang.reflect.Method method = methods[53];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createFunctionCall", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode[].class);
methods[53] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createFunctionCallWithNewTarget (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode[] arg2) {
java.lang.reflect.Method method = methods[54];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createFunctionCallWithNewTarget", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode[].class);
methods[54] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createNew (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode[] arg2) {
java.lang.reflect.Method method = methods[55];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createNew", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode[].class);
methods[55] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAccessThis () {
java.lang.reflect.Method method = methods[56];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAccessThis");
methods[56] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAccessCallee (int arg0) {
java.lang.reflect.Method method = methods[57];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAccessCallee", int.class);
methods[57] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAccessLexicalThis () {
java.lang.reflect.Method method = methods[58];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAccessLexicalThis");
methods[58] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAccessArgument (int arg0) {
java.lang.reflect.Method method = methods[59];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAccessArgument", int.class);
methods[59] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAccessVarArgs (int arg0) {
java.lang.reflect.Method method = methods[60];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAccessVarArgs", int.class);
methods[60] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAccessRestArgument (com.oracle.truffle.js.runtime.JSContext arg0, int arg1, int arg2) {
java.lang.reflect.Method method = methods[61];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAccessRestArgument", com.oracle.truffle.js.runtime.JSContext.class, int.class, int.class);
methods[61] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAccessNewTarget () {
java.lang.reflect.Method method = methods[62];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAccessNewTarget");
methods[62] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAccessFrameArgument (int arg0, int arg1) {
java.lang.reflect.Method method = methods[63];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAccessFrameArgument", int.class, int.class);
methods[63] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAccessHomeObject (com.oracle.truffle.js.runtime.JSContext arg0) {
java.lang.reflect.Method method = methods[64];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAccessHomeObject", com.oracle.truffle.js.runtime.JSContext.class);
methods[64] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ReadElementNode createReadElementNode (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[65];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createReadElementNode", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[65] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.access.ReadElementNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.WriteElementNode createWriteElementNode (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.runtime.JSContext arg3, boolean arg4) {
java.lang.reflect.Method method = methods[66];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createWriteElementNode", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.runtime.JSContext.class, boolean.class);
methods[66] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.access.WriteElementNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.WriteElementNode createCompoundWriteElementNode (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg3, com.oracle.truffle.js.runtime.JSContext arg4, boolean arg5) {
java.lang.reflect.Method method = methods[67];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createCompoundWriteElementNode", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class, com.oracle.truffle.js.runtime.JSContext.class, boolean.class);
methods[67] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4, arg5};
try {
return (com.oracle.truffle.js.nodes.access.WriteElementNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.JSTargetableNode createReadProperty (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, java.lang.String arg2) {
java.lang.reflect.Method method = methods[68];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createReadProperty", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, java.lang.String.class);
methods[68] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.access.JSTargetableNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.JSTargetableNode createReadProperty (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, java.lang.String arg2, boolean arg3) {
java.lang.reflect.Method method = methods[69];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createReadProperty", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, java.lang.String.class, boolean.class);
methods[69] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.access.JSTargetableNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.WritePropertyNode createWriteProperty (com.oracle.truffle.js.nodes.JavaScriptNode arg0, java.lang.Object arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.runtime.JSContext arg3, boolean arg4) {
java.lang.reflect.Method method = methods[70];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createWriteProperty", com.oracle.truffle.js.nodes.JavaScriptNode.class, java.lang.Object.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.runtime.JSContext.class, boolean.class);
methods[70] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.access.WritePropertyNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.WritePropertyNode createWriteProperty (com.oracle.truffle.js.nodes.JavaScriptNode arg0, java.lang.String arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.runtime.JSContext arg3, boolean arg4, boolean arg5, boolean arg6) {
java.lang.reflect.Method method = methods[71];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createWriteProperty", com.oracle.truffle.js.nodes.JavaScriptNode.class, java.lang.String.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.runtime.JSContext.class, boolean.class, boolean.class, boolean.class);
methods[71] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4, arg5, arg6};
try {
return (com.oracle.truffle.js.nodes.access.WritePropertyNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ConstantVariableWriteNode createWriteConstantVariable (com.oracle.truffle.js.nodes.JavaScriptNode arg0, boolean arg1) {
java.lang.reflect.Method method = methods[72];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createWriteConstantVariable", com.oracle.truffle.js.nodes.JavaScriptNode.class, boolean.class);
methods[72] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.access.ConstantVariableWriteNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.JSTargetableNode createReadGlobalProperty (com.oracle.truffle.js.runtime.JSContext arg0, java.lang.String arg1) {
java.lang.reflect.Method method = methods[73];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createReadGlobalProperty", com.oracle.truffle.js.runtime.JSContext.class, java.lang.String.class);
methods[73] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.access.JSTargetableNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.JSTargetableNode createDeleteProperty (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, boolean arg2, com.oracle.truffle.js.runtime.JSContext arg3) {
java.lang.reflect.Method method = methods[74];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDeleteProperty", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, boolean.class, com.oracle.truffle.js.runtime.JSContext.class);
methods[74] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.access.JSTargetableNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.function.FunctionRootNode createFunctionRootNode (com.oracle.truffle.js.nodes.function.AbstractBodyNode arg0, com.oracle.truffle.api.frame.FrameDescriptor arg1, com.oracle.truffle.js.runtime.builtins.JSFunctionData arg2, com.oracle.truffle.api.source.SourceSection arg3, java.lang.String arg4) {
java.lang.reflect.Method method = methods[75];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createFunctionRootNode", com.oracle.truffle.js.nodes.function.AbstractBodyNode.class, com.oracle.truffle.api.frame.FrameDescriptor.class, com.oracle.truffle.js.runtime.builtins.JSFunctionData.class, com.oracle.truffle.api.source.SourceSection.class, java.lang.String.class);
methods[75] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.function.FunctionRootNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.function.ConstructorRootNode createConstructorRootNode (com.oracle.truffle.js.runtime.builtins.JSFunctionData arg0, com.oracle.truffle.api.CallTarget arg1, boolean arg2) {
java.lang.reflect.Method method = methods[76];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createConstructorRootNode", com.oracle.truffle.js.runtime.builtins.JSFunctionData.class, com.oracle.truffle.api.CallTarget.class, boolean.class);
methods[76] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.function.ConstructorRootNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.function.FunctionBodyNode createFunctionBody (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[77];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createFunctionBody", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[77] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.function.FunctionBodyNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode createFunctionExpression (com.oracle.truffle.js.runtime.builtins.JSFunctionData arg0, com.oracle.truffle.js.nodes.function.FunctionRootNode arg1, com.oracle.truffle.api.frame.FrameSlot arg2) {
java.lang.reflect.Method method = methods[78];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createFunctionExpression", com.oracle.truffle.js.runtime.builtins.JSFunctionData.class, com.oracle.truffle.js.nodes.function.FunctionRootNode.class, com.oracle.truffle.api.frame.FrameSlot.class);
methods[78] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode createFunctionExpressionLexicalThis (com.oracle.truffle.js.runtime.builtins.JSFunctionData arg0, com.oracle.truffle.js.nodes.function.FunctionRootNode arg1, com.oracle.truffle.api.frame.FrameSlot arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3) {
java.lang.reflect.Method method = methods[79];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createFunctionExpressionLexicalThis", com.oracle.truffle.js.runtime.builtins.JSFunctionData.class, com.oracle.truffle.js.nodes.function.FunctionRootNode.class, com.oracle.truffle.api.frame.FrameSlot.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[79] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createPrepareThisBinding (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[80];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createPrepareThisBinding", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[80] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGlobalObject () {
java.lang.reflect.Method method = methods[81];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGlobalObject");
methods[81] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createArgumentsObjectNode (com.oracle.truffle.js.runtime.JSContext arg0, boolean arg1, int arg2, int arg3) {
java.lang.reflect.Method method = methods[82];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createArgumentsObjectNode", com.oracle.truffle.js.runtime.JSContext.class, boolean.class, int.class, int.class);
methods[82] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createThrowError (com.oracle.truffle.js.runtime.JSErrorType arg0, java.lang.String arg1) {
java.lang.reflect.Method method = methods[83];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createThrowError", com.oracle.truffle.js.runtime.JSErrorType.class, java.lang.String.class);
methods[83] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createObjectLiteral (com.oracle.truffle.js.runtime.JSContext arg0, java.util.ArrayList<com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode> arg1) {
java.lang.reflect.Method method = methods[84];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createObjectLiteral", com.oracle.truffle.js.runtime.JSContext.class, java.util.ArrayList.class);
methods[84] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createArrayLiteral (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode[] arg1) {
java.lang.reflect.Method method = methods[85];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createArrayLiteral", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode[].class);
methods[85] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createArrayLiteralWithSpread (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode[] arg1) {
java.lang.reflect.Method method = methods[86];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createArrayLiteralWithSpread", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode[].class);
methods[86] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode createAccessorMember (java.lang.String arg0, boolean arg1, boolean arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3, com.oracle.truffle.js.nodes.JavaScriptNode arg4) {
java.lang.reflect.Method method = methods[87];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAccessorMember", java.lang.String.class, boolean.class, boolean.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[87] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode createDataMember (java.lang.String arg0, boolean arg1, boolean arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3, boolean arg4) {
java.lang.reflect.Method method = methods[88];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDataMember", java.lang.String.class, boolean.class, boolean.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, boolean.class);
methods[88] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode createProtoMember (java.lang.String arg0, boolean arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[89];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createProtoMember", java.lang.String.class, boolean.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[89] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode createComputedDataMember (com.oracle.truffle.js.nodes.JavaScriptNode arg0, boolean arg1, boolean arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3, boolean arg4, boolean arg5) {
java.lang.reflect.Method method = methods[90];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createComputedDataMember", com.oracle.truffle.js.nodes.JavaScriptNode.class, boolean.class, boolean.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, boolean.class, boolean.class);
methods[90] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4, arg5};
try {
return (com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode createComputedAccessorMember (com.oracle.truffle.js.nodes.JavaScriptNode arg0, boolean arg1, boolean arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3, com.oracle.truffle.js.nodes.JavaScriptNode arg4) {
java.lang.reflect.Method method = methods[91];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createComputedAccessorMember", com.oracle.truffle.js.nodes.JavaScriptNode.class, boolean.class, boolean.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[91] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode createSpreadObjectMember (boolean arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[92];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createSpreadObjectMember", boolean.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[92] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode createStaticBlockMember (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[93];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createStaticBlockMember", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[93] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createClassDefinition (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode[] arg3, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg4, java.lang.String arg5, int arg6, int arg7, boolean arg8, com.oracle.truffle.api.frame.FrameSlot arg9) {
java.lang.reflect.Method method = methods[94];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createClassDefinition", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode[].class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class, java.lang.String.class, int.class, int.class, boolean.class, com.oracle.truffle.api.frame.FrameSlot.class);
methods[94] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createMakeMethod (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[95];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createMakeMethod", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[95] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createSpreadArgument (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[96];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createSpreadArgument", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[96] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createSpreadArray (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[97];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createSpreadArray", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[97] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.ReturnNode createReturn (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[98];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createReturn", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[98] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.control.ReturnNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.ReturnNode createFrameReturn (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[99];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createFrameReturn", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[99] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.control.ReturnNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.ReturnNode createTerminalPositionReturn (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[100];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createTerminalPositionReturn", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[100] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.control.ReturnNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.runtime.builtins.JSFunctionData createFunctionData (com.oracle.truffle.js.runtime.JSContext arg0, int arg1, java.lang.String arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7, boolean arg8, boolean arg9, boolean arg10, boolean arg11, boolean arg12) {
java.lang.reflect.Method method = methods[101];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createFunctionData", com.oracle.truffle.js.runtime.JSContext.class, int.class, java.lang.String.class, boolean.class, boolean.class, boolean.class, boolean.class, boolean.class, boolean.class, boolean.class, boolean.class, boolean.class, boolean.class);
methods[101] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12};
try {
return (com.oracle.truffle.js.runtime.builtins.JSFunctionData) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAwait (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg2, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg3) {
java.lang.reflect.Method method = methods[102];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAwait", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class);
methods[102] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createYield (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, boolean arg3, com.oracle.truffle.js.nodes.control.ReturnNode arg4, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg5) {
java.lang.reflect.Method method = methods[103];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createYield", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, boolean.class, com.oracle.truffle.js.nodes.control.ReturnNode.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class);
methods[103] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4, arg5};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAsyncGeneratorYield (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg2, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg3, com.oracle.truffle.js.nodes.control.ReturnNode arg4) {
java.lang.reflect.Method method = methods[104];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAsyncGeneratorYield", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class, com.oracle.truffle.js.nodes.control.ReturnNode.class);
methods[104] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAsyncGeneratorYieldStar (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg2, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg3, com.oracle.truffle.js.nodes.control.ReturnNode arg4, com.oracle.truffle.js.nodes.JavaScriptNode arg5, com.oracle.truffle.js.nodes.access.WriteNode arg6) {
java.lang.reflect.Method method = methods[105];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAsyncGeneratorYieldStar", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class, com.oracle.truffle.js.nodes.control.ReturnNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.WriteNode.class);
methods[105] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4, arg5, arg6};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAsyncFunctionBody (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg2, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg3, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg4) {
java.lang.reflect.Method method = methods[106];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAsyncFunctionBody", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class);
methods[106] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGeneratorBody (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg2, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg3) {
java.lang.reflect.Method method = methods[107];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGeneratorBody", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class);
methods[107] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAsyncGeneratorBody (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg2, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg3, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg4, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg5) {
java.lang.reflect.Method method = methods[108];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAsyncGeneratorBody", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class);
methods[108] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4, arg5};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGeneratorWrapper (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.WriteNode arg2) {
java.lang.reflect.Method method = methods[109];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGeneratorWrapper", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.WriteNode.class);
methods[109] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGeneratorVoidBlock (com.oracle.truffle.js.nodes.JavaScriptNode[] arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.WriteNode arg2) {
java.lang.reflect.Method method = methods[110];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGeneratorVoidBlock", com.oracle.truffle.js.nodes.JavaScriptNode[].class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.WriteNode.class);
methods[110] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGeneratorExprBlock (com.oracle.truffle.js.nodes.JavaScriptNode[] arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.WriteNode arg2) {
java.lang.reflect.Method method = methods[111];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGeneratorExprBlock", com.oracle.truffle.js.nodes.JavaScriptNode[].class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.WriteNode.class);
methods[111] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createBlockScope (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.api.frame.FrameSlot arg1, com.oracle.truffle.api.frame.FrameDescriptor arg2, com.oracle.truffle.api.frame.FrameSlot arg3, boolean arg4, boolean arg5) {
java.lang.reflect.Method method = methods[112];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createBlockScope", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.api.frame.FrameSlot.class, com.oracle.truffle.api.frame.FrameDescriptor.class, com.oracle.truffle.api.frame.FrameSlot.class, boolean.class, boolean.class);
methods[112] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4, arg5};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createTemplateObject (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[113];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createTemplateObject", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[113] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createToString (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[114];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createToString", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[114] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createRegExpLiteral (com.oracle.truffle.js.runtime.JSContext arg0, java.lang.String arg1, java.lang.String arg2) {
java.lang.reflect.Method method = methods[115];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createRegExpLiteral", com.oracle.truffle.js.runtime.JSContext.class, java.lang.String.class, java.lang.String.class);
methods[115] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGetIterator (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[116];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGetIterator", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[116] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGetAsyncIterator (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[117];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGetAsyncIterator", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[117] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createEnumerate (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, boolean arg2) {
java.lang.reflect.Method method = methods[118];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createEnumerate", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, boolean.class);
methods[118] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createIteratorNext (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[119];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createIteratorNext", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[119] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createIteratorComplete (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[120];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createIteratorComplete", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[120] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createIteratorGetNextValue (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, boolean arg3) {
java.lang.reflect.Method method = methods[121];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createIteratorGetNextValue", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, boolean.class);
methods[121] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createIteratorSetDone (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[122];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createIteratorSetDone", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[122] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAsyncIteratorNext (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg2, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg3) {
java.lang.reflect.Method method = methods[123];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAsyncIteratorNext", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class);
methods[123] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createIteratorValue (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[124];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createIteratorValue", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[124] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAsyncIteratorCloseWrapper (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg3, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode arg4) {
java.lang.reflect.Method method = methods[125];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAsyncIteratorCloseWrapper", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class, com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode.class);
methods[125] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createIteratorCloseIfNotDone (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[126];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createIteratorCloseIfNotDone", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[126] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.IteratorToArrayNode createIteratorToArray (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[127];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createIteratorToArray", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[127] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.access.IteratorToArrayNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGetPrototype (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[128];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGetPrototype", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[128] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.JSTargetableNode createSuperPropertyReference (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[129];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createSuperPropertyReference", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[129] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.access.JSTargetableNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.JSTargetableNode createTargetableWrapper (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[130];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createTargetableWrapper", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[130] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.access.JSTargetableNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createWith (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[131];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createWith", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[131] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createWithVarWrapper (java.lang.String arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.JSTargetableNode arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3) {
java.lang.reflect.Method method = methods[132];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createWithVarWrapper", java.lang.String.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSTargetableNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[132] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createWithTarget (com.oracle.truffle.js.runtime.JSContext arg0, java.lang.String arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[133];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createWithTarget", com.oracle.truffle.js.runtime.JSContext.class, java.lang.String.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[133] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.runtime.JavaScriptRootNode createNewTargetConstruct (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.api.CallTarget arg1) {
java.lang.reflect.Method method = methods[134];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createNewTargetConstruct", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.api.CallTarget.class);
methods[134] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.runtime.JavaScriptRootNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.runtime.JavaScriptRootNode createNewTargetCall (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.api.CallTarget arg1) {
java.lang.reflect.Method method = methods[135];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createNewTargetCall", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.api.CallTarget.class);
methods[135] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.runtime.JavaScriptRootNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.runtime.JavaScriptRootNode createDropNewTarget (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.api.CallTarget arg1) {
java.lang.reflect.Method method = methods[136];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDropNewTarget", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.api.CallTarget.class);
methods[136] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.runtime.JavaScriptRootNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.runtime.JavaScriptRootNode createConstructorRequiresNewRoot (com.oracle.truffle.js.runtime.builtins.JSFunctionData arg0, com.oracle.truffle.api.source.SourceSection arg1) {
java.lang.reflect.Method method = methods[137];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createConstructorRequiresNewRoot", com.oracle.truffle.js.runtime.builtins.JSFunctionData.class, com.oracle.truffle.api.source.SourceSection.class);
methods[137] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.runtime.JavaScriptRootNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createDerivedConstructorResult (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[138];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDerivedConstructorResult", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[138] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createDerivedConstructorThis (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[139];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDerivedConstructorThis", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[139] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createRequireObjectCoercible (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[140];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createRequireObjectCoercible", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[140] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.api.frame.FrameDescriptor createFrameDescriptor () {
java.lang.reflect.Method method = methods[141];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createFrameDescriptor");
methods[141] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{};
try {
return (com.oracle.truffle.api.frame.FrameDescriptor) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.api.frame.FrameDescriptor createBlockFrameDescriptor () {
java.lang.reflect.Method method = methods[142];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createBlockFrameDescriptor");
methods[142] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{};
try {
return (com.oracle.truffle.api.frame.FrameDescriptor) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.DeclareGlobalNode createDeclareGlobalVariable (java.lang.String arg0, boolean arg1) {
java.lang.reflect.Method method = methods[143];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDeclareGlobalVariable", java.lang.String.class, boolean.class);
methods[143] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.access.DeclareGlobalNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.DeclareGlobalNode createDeclareGlobalFunction (java.lang.String arg0, boolean arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[144];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDeclareGlobalFunction", java.lang.String.class, boolean.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[144] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.access.DeclareGlobalNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.DeclareGlobalNode createDeclareGlobalLexicalVariable (java.lang.String arg0, boolean arg1) {
java.lang.reflect.Method method = methods[145];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDeclareGlobalLexicalVariable", java.lang.String.class, boolean.class);
methods[145] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.access.DeclareGlobalNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGlobalDeclarationInstantiation (com.oracle.truffle.js.runtime.JSContext arg0, java.util.List<com.oracle.truffle.js.nodes.access.DeclareGlobalNode> arg1) {
java.lang.reflect.Method method = methods[146];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGlobalDeclarationInstantiation", com.oracle.truffle.js.runtime.JSContext.class, java.util.List.class);
methods[146] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode copy (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[147];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("copy", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[147] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createToObject (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[148];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createToObject", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[148] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createToObjectFromWith (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, boolean arg2) {
java.lang.reflect.Method method = methods[149];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createToObjectFromWith", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, boolean.class);
methods[149] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createAccessArgumentsArrayDirectly (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, int arg2, int arg3) {
java.lang.reflect.Method method = methods[150];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createAccessArgumentsArrayDirectly", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, int.class, int.class);
methods[150] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createCallApplyArguments (com.oracle.truffle.js.nodes.function.JSFunctionCallNode arg0) {
java.lang.reflect.Method method = methods[151];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createCallApplyArguments", com.oracle.truffle.js.nodes.function.JSFunctionCallNode.class);
methods[151] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGuardDisconnectedArgumentRead (int arg0, com.oracle.truffle.js.nodes.access.ReadElementNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.api.frame.FrameSlot arg3) {
java.lang.reflect.Method method = methods[152];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGuardDisconnectedArgumentRead", int.class, com.oracle.truffle.js.nodes.access.ReadElementNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.api.frame.FrameSlot.class);
methods[152] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGuardDisconnectedArgumentWrite (int arg0, com.oracle.truffle.js.nodes.access.WriteElementNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3, com.oracle.truffle.api.frame.FrameSlot arg4) {
java.lang.reflect.Method method = methods[153];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGuardDisconnectedArgumentWrite", int.class, com.oracle.truffle.js.nodes.access.WriteElementNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.api.frame.FrameSlot.class);
methods[153] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createModuleBody (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[154];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createModuleBody", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[154] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createModuleYield () {
java.lang.reflect.Method method = methods[155];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createModuleYield");
methods[155] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createTopLevelAsyncModuleBody (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg2, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg3) {
java.lang.reflect.Method method = methods[156];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createTopLevelAsyncModuleBody", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class);
methods[156] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createImportMeta (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[157];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createImportMeta", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[157] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createResolveStarImport (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.js.parser.ir.Module.ModuleRequest arg2, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg3) {
java.lang.reflect.Method method = methods[158];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createResolveStarImport", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.js.parser.ir.Module.ModuleRequest.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class);
methods[158] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createResolveNamedImport (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.js.parser.ir.Module.ModuleRequest arg2, java.lang.String arg3, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg4) {
java.lang.reflect.Method method = methods[159];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createResolveNamedImport", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.js.parser.ir.Module.ModuleRequest.class, java.lang.String.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class);
methods[159] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3, arg4};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createReadImportBinding (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[160];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createReadImportBinding", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[160] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createImportCall (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[161];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createImportCall", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[161] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createImportCall (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3) {
java.lang.reflect.Method method = methods[162];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createImportCall", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[162] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createRestObject (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[163];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createRestObject", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[163] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createInitializeInstanceElements (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[164];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createInitializeInstanceElements", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[164] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createNewPrivateName (java.lang.String arg0) {
java.lang.reflect.Method method = methods[165];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createNewPrivateName", java.lang.String.class);
methods[165] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createPrivateFieldGet (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2) {
java.lang.reflect.Method method = methods[166];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createPrivateFieldGet", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[166] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createPrivateFieldSet (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.nodes.JavaScriptNode arg3) {
java.lang.reflect.Method method = methods[167];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createPrivateFieldSet", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[167] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode createPrivateFieldMember (com.oracle.truffle.js.nodes.JavaScriptNode arg0, boolean arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg3) {
java.lang.reflect.Method method = methods[168];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createPrivateFieldMember", com.oracle.truffle.js.nodes.JavaScriptNode.class, boolean.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class);
methods[168] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode createPrivateMethodMember (boolean arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg2) {
java.lang.reflect.Method method = methods[169];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createPrivateMethodMember", boolean.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class);
methods[169] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2};
try {
return (com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode createPrivateAccessorMember (boolean arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode arg3) {
java.lang.reflect.Method method = methods[170];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createPrivateAccessorMember", boolean.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode.class);
methods[170] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createPrivateBrandCheck (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[171];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createPrivateBrandCheck", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[171] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createGetPrivateBrand (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[172];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createGetPrivateBrand", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[172] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createToPropertyKey (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[173];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createToPropertyKey", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[173] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createOptionalChain (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[174];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createOptionalChain", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[174] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createOptionalChainShortCircuit (com.oracle.truffle.js.nodes.JavaScriptNode arg0) {
java.lang.reflect.Method method = methods[175];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createOptionalChainShortCircuit", com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[175] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createNamedEvaluation (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[176];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createNamedEvaluation", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[176] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.control.IfNode copyIfWithCondition (com.oracle.truffle.js.nodes.control.IfNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[177];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("copyIfWithCondition", com.oracle.truffle.js.nodes.control.IfNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[177] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.control.IfNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createDebugScope (com.oracle.truffle.js.runtime.JSContext arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[178];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDebugScope", com.oracle.truffle.js.runtime.JSContext.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[178] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createDebugVarWrapper (java.lang.String arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1, com.oracle.truffle.js.nodes.JavaScriptNode arg2, com.oracle.truffle.js.nodes.access.JSTargetableNode arg3) {
java.lang.reflect.Method method = methods[179];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createDebugVarWrapper", java.lang.String.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.access.JSTargetableNode.class);
methods[179] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1, arg2, arg3};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.runtime.util.InternalSlotId createInternalSlotId (java.lang.String arg0, int arg1) {
java.lang.reflect.Method method = methods[180];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createInternalSlotId", java.lang.String.class, int.class);
methods[180] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.runtime.util.InternalSlotId) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}

@Override
public com.oracle.truffle.js.nodes.JavaScriptNode createPrivateFieldIn (com.oracle.truffle.js.nodes.JavaScriptNode arg0, com.oracle.truffle.js.nodes.JavaScriptNode arg1) {
java.lang.reflect.Method method = methods[181];
if (method == null) {
try {
method = com.oracle.truffle.js.nodes.NodeFactory.class.getMethod("createPrivateFieldIn", com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.js.nodes.JavaScriptNode.class);
methods[181] = method;
} catch (NoSuchMethodException e) {
throw new AssertionError(e);
}
}
Object[] args = new Object[]{arg0, arg1};
try {
return (com.oracle.truffle.js.nodes.JavaScriptNode) handler.invoke(this, method, args);
} catch (RuntimeException | Error e) {
throw e;
} catch (Throwable e) {
throw new RuntimeException(e);
}
}
}
