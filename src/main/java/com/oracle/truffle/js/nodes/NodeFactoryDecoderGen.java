package com.oracle.truffle.js.nodes;

@com.oracle.truffle.api.dsl.GeneratedBy(com.oracle.truffle.js.nodes.NodeFactory.class)
public class NodeFactoryDecoderGen implements com.oracle.truffle.js.codec.NodeDecoder<com.oracle.truffle.js.nodes.NodeFactory> {
private NodeFactoryDecoderGen() {
}

public static NodeFactoryDecoderGen create() {
return new NodeFactoryDecoderGen();
}

private static final Class<?>[] CLASSES = {int.class, com.oracle.truffle.js.nodes.NodeFactory.UnaryOperation.class, com.oracle.truffle.js.nodes.NodeFactory.BinaryOperation.class, com.oracle.truffle.js.runtime.JSErrorType.class, com.oracle.truffle.js.nodes.JavaScriptNode.class, com.oracle.truffle.api.frame.FrameSlot.class, com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode.class};

@Override
public Class<?>[] getClasses() {
return CLASSES;
}

@Override
@SuppressWarnings("unchecked")
public Object decodeNode(DecoderState decoder, com.oracle.truffle.js.nodes.NodeFactory nodeFactory) {
switch (decoder.getUInt()) {
case 0:
return nodeFactory.createUnary((com.oracle.truffle.js.nodes.NodeFactory.UnaryOperation)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 1:
return nodeFactory.createLocalVarInc((com.oracle.truffle.js.nodes.NodeFactory.UnaryOperation)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.access.ScopeFrameNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameDescriptor)decoder.getObject());
case 2:
return nodeFactory.createToNumericOperand((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 3:
return nodeFactory.createDual((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 4:
return nodeFactory.createBinary((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.NodeFactory.BinaryOperation)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 5:
return nodeFactory.createTypeofIdentical((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (java.lang.String)decoder.getObject());
case 6:
return nodeFactory.createLogicalOr((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 7:
return nodeFactory.createNotUndefinedOr((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 8:
return nodeFactory.createConstant(decoder.getObject());
case 9:
return nodeFactory.createConstantBoolean((boolean)decoder.getObject());
case 10:
return nodeFactory.createConstantInteger((int)decoder.getObject());
case 11:
return nodeFactory.createConstantSafeInteger((long)decoder.getObject());
case 12:
return nodeFactory.createConstantNumericUnit();
case 13:
return nodeFactory.createConstantDouble((double)decoder.getObject());
case 14:
return nodeFactory.createConstantString((java.lang.String)decoder.getObject());
case 15:
return nodeFactory.createConstantUndefined();
case 16:
return nodeFactory.createConstantNull();
case 17:
return nodeFactory.createIf((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 18:
return nodeFactory.createSwitch((com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject(), (int[])decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 19:
return nodeFactory.createWhileDo((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 20:
return nodeFactory.createDoWhile((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 21:
return nodeFactory.createDesugaredFor((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 22:
return nodeFactory.createDesugaredForOf((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 23:
return nodeFactory.createDesugaredForIn((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 24:
return nodeFactory.createDesugaredForAwaitOf((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 25:
return nodeFactory.createFor((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameDescriptor)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject());
case 26:
return nodeFactory.createIterationScope((com.oracle.truffle.api.frame.FrameDescriptor)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject());
case 27:
return nodeFactory.createBreak((com.oracle.truffle.js.nodes.control.BreakTarget)decoder.getObject());
case 28:
return nodeFactory.createContinue((com.oracle.truffle.js.nodes.control.ContinueTarget)decoder.getObject());
case 29:
return nodeFactory.createLabel((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.control.BreakTarget)decoder.getObject());
case 30:
return nodeFactory.createEmpty();
case 31:
return nodeFactory.createVoidBlock((com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 32:
return nodeFactory.createExprBlock((com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 33:
return nodeFactory.createReturnTarget((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 34:
return nodeFactory.createFrameReturnTarget((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 35:
return nodeFactory.createContinueTarget((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.control.ContinueTarget)decoder.getObject());
case 36:
return nodeFactory.createDirectBreakTarget((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 37:
return nodeFactory.createDebugger();
case 38:
return nodeFactory.createLocal((com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot[])decoder.getObject());
case 39:
return nodeFactory.createReadFrameSlot((com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (com.oracle.truffle.js.nodes.access.ScopeFrameNode)decoder.getObject());
case 40:
return nodeFactory.createReadFrameSlot((com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (com.oracle.truffle.js.nodes.access.ScopeFrameNode)decoder.getObject(), (boolean)decoder.getObject());
case 41:
return nodeFactory.createReadCurrentFrameSlot((com.oracle.truffle.api.frame.FrameSlot)decoder.getObject());
case 42:
return nodeFactory.createWriteFrameSlot((com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (com.oracle.truffle.js.nodes.access.ScopeFrameNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameDescriptor)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 43:
return nodeFactory.createWriteFrameSlot((com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (com.oracle.truffle.js.nodes.access.ScopeFrameNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameDescriptor)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject());
case 44:
return nodeFactory.createWriteCurrentFrameSlot((com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (com.oracle.truffle.api.frame.FrameDescriptor)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 45:
return nodeFactory.createScopeFrame((int)decoder.getObject(), (int)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot[])decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject());
case 46:
return nodeFactory.createReadLexicalGlobal((java.lang.String)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.runtime.JSContext)decoder.getObject());
case 47:
return nodeFactory.createGlobalScope((com.oracle.truffle.js.runtime.JSContext)decoder.getObject());
case 48:
return nodeFactory.createGlobalScopeTDZCheck((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (java.lang.String)decoder.getObject(), (boolean)decoder.getObject());
case 49:
return nodeFactory.createGlobalVarWrapper((java.lang.String)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSTargetableNode)decoder.getObject());
case 50:
return nodeFactory.createThrow((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 51:
return nodeFactory.createTryCatch((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.function.BlockScopeNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 52:
return nodeFactory.createTryFinally((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 53:
return nodeFactory.createFunctionCall((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 54:
return nodeFactory.createFunctionCallWithNewTarget((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 55:
return nodeFactory.createNew((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 56:
return nodeFactory.createAccessThis();
case 57:
return nodeFactory.createAccessCallee((int)decoder.getObject());
case 58:
return nodeFactory.createAccessLexicalThis();
case 59:
return nodeFactory.createAccessArgument((int)decoder.getObject());
case 60:
return nodeFactory.createAccessVarArgs((int)decoder.getObject());
case 61:
return nodeFactory.createAccessRestArgument((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject());
case 62:
return nodeFactory.createAccessNewTarget();
case 63:
return nodeFactory.createAccessFrameArgument((int)decoder.getObject(), (int)decoder.getObject());
case 64:
return nodeFactory.createAccessHomeObject((com.oracle.truffle.js.runtime.JSContext)decoder.getObject());
case 65:
return nodeFactory.createReadElementNode((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 66:
return nodeFactory.createWriteElementNode((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (boolean)decoder.getObject());
case 67:
return nodeFactory.createCompoundWriteElementNode((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (boolean)decoder.getObject());
case 68:
return nodeFactory.createReadProperty((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (java.lang.String)decoder.getObject());
case 69:
return nodeFactory.createReadProperty((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (java.lang.String)decoder.getObject(), (boolean)decoder.getObject());
case 70:
return nodeFactory.createWriteProperty((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (boolean)decoder.getObject());
case 71:
return nodeFactory.createWriteProperty((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (java.lang.String)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject());
case 72:
return nodeFactory.createWriteConstantVariable((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject());
case 73:
return nodeFactory.createReadGlobalProperty((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (java.lang.String)decoder.getObject());
case 74:
return nodeFactory.createDeleteProperty((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.runtime.JSContext)decoder.getObject());
case 75:
return nodeFactory.createFunctionRootNode((com.oracle.truffle.js.nodes.function.AbstractBodyNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameDescriptor)decoder.getObject(), (com.oracle.truffle.js.runtime.builtins.JSFunctionData)decoder.getObject(), (com.oracle.truffle.api.source.SourceSection)decoder.getObject(), (java.lang.String)decoder.getObject());
case 76:
return nodeFactory.createConstructorRootNode((com.oracle.truffle.js.runtime.builtins.JSFunctionData)decoder.getObject(), (com.oracle.truffle.api.CallTarget)decoder.getObject(), (boolean)decoder.getObject());
case 77:
return nodeFactory.createFunctionBody((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 78:
return nodeFactory.createFunctionExpression((com.oracle.truffle.js.runtime.builtins.JSFunctionData)decoder.getObject(), (com.oracle.truffle.js.nodes.function.FunctionRootNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject());
case 79:
return nodeFactory.createFunctionExpressionLexicalThis((com.oracle.truffle.js.runtime.builtins.JSFunctionData)decoder.getObject(), (com.oracle.truffle.js.nodes.function.FunctionRootNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 80:
return nodeFactory.createPrepareThisBinding((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 81:
return nodeFactory.createGlobalObject();
case 82:
return nodeFactory.createArgumentsObjectNode((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (boolean)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject());
case 83:
return nodeFactory.createThrowError((com.oracle.truffle.js.runtime.JSErrorType)decoder.getObject(), (java.lang.String)decoder.getObject());
case 84:
return nodeFactory.createObjectLiteral((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (java.util.ArrayList<com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode>)decoder.getObject());
case 85:
return nodeFactory.createArrayLiteral((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 86:
return nodeFactory.createArrayLiteralWithSpread((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject());
case 87:
return nodeFactory.createAccessorMember((java.lang.String)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 88:
return nodeFactory.createDataMember((java.lang.String)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject());
case 89:
return nodeFactory.createProtoMember((java.lang.String)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 90:
return nodeFactory.createComputedDataMember((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject());
case 91:
return nodeFactory.createComputedAccessorMember((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 92:
return nodeFactory.createSpreadObjectMember((boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 93:
return nodeFactory.createStaticBlockMember((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 94:
return nodeFactory.createClassDefinition((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode[])decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (java.lang.String)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject());
case 95:
return nodeFactory.createMakeMethod((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 96:
return nodeFactory.createSpreadArgument((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 97:
return nodeFactory.createSpreadArray((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 98:
return nodeFactory.createReturn((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 99:
return nodeFactory.createFrameReturn((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 100:
return nodeFactory.createTerminalPositionReturn((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 101:
return nodeFactory.createFunctionData((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (int)decoder.getObject(), (java.lang.String)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject());
case 102:
return nodeFactory.createAwait((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject());
case 103:
return nodeFactory.createYield((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.control.ReturnNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 104:
return nodeFactory.createAsyncGeneratorYield((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.control.ReturnNode)decoder.getObject());
case 105:
return nodeFactory.createAsyncGeneratorYieldStar((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.control.ReturnNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.WriteNode)decoder.getObject());
case 106:
return nodeFactory.createAsyncFunctionBody((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 107:
return nodeFactory.createGeneratorBody((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject());
case 108:
return nodeFactory.createAsyncGeneratorBody((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject());
case 109:
return nodeFactory.createGeneratorWrapper((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.WriteNode)decoder.getObject());
case 110:
return nodeFactory.createGeneratorVoidBlock((com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.WriteNode)decoder.getObject());
case 111:
return nodeFactory.createGeneratorExprBlock((com.oracle.truffle.js.nodes.JavaScriptNode[])decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.WriteNode)decoder.getObject());
case 112:
return nodeFactory.createBlockScope((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (com.oracle.truffle.api.frame.FrameDescriptor)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject(), (boolean)decoder.getObject(), (boolean)decoder.getObject());
case 113:
return nodeFactory.createTemplateObject((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 114:
return nodeFactory.createToString((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 115:
return nodeFactory.createRegExpLiteral((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (java.lang.String)decoder.getObject(), (java.lang.String)decoder.getObject());
case 116:
return nodeFactory.createGetIterator((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 117:
return nodeFactory.createGetAsyncIterator((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 118:
return nodeFactory.createEnumerate((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject());
case 119:
return nodeFactory.createIteratorNext((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 120:
return nodeFactory.createIteratorComplete((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 121:
return nodeFactory.createIteratorGetNextValue((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject());
case 122:
return nodeFactory.createIteratorSetDone((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 123:
return nodeFactory.createAsyncIteratorNext((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject());
case 124:
return nodeFactory.createIteratorValue((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 125:
return nodeFactory.createAsyncIteratorCloseWrapper((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)decoder.getObject());
case 126:
return nodeFactory.createIteratorCloseIfNotDone((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 127:
return nodeFactory.createIteratorToArray((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 128:
return nodeFactory.createGetPrototype((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 129:
return nodeFactory.createSuperPropertyReference((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 130:
return nodeFactory.createTargetableWrapper((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 131:
return nodeFactory.createWith((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 132:
return nodeFactory.createWithVarWrapper((java.lang.String)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSTargetableNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 133:
return nodeFactory.createWithTarget((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (java.lang.String)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 134:
return nodeFactory.createNewTargetConstruct((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.api.CallTarget)decoder.getObject());
case 135:
return nodeFactory.createNewTargetCall((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.api.CallTarget)decoder.getObject());
case 136:
return nodeFactory.createDropNewTarget((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.api.CallTarget)decoder.getObject());
case 137:
return nodeFactory.createConstructorRequiresNewRoot((com.oracle.truffle.js.runtime.builtins.JSFunctionData)decoder.getObject(), (com.oracle.truffle.api.source.SourceSection)decoder.getObject());
case 138:
return nodeFactory.createDerivedConstructorResult((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 139:
return nodeFactory.createDerivedConstructorThis((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 140:
return nodeFactory.createRequireObjectCoercible((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 141:
return nodeFactory.createFrameDescriptor();
case 142:
return nodeFactory.createBlockFrameDescriptor();
case 143:
return nodeFactory.createDeclareGlobalVariable((java.lang.String)decoder.getObject(), (boolean)decoder.getObject());
case 144:
return nodeFactory.createDeclareGlobalFunction((java.lang.String)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 145:
return nodeFactory.createDeclareGlobalLexicalVariable((java.lang.String)decoder.getObject(), (boolean)decoder.getObject());
case 146:
return nodeFactory.createGlobalDeclarationInstantiation((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (java.util.List<com.oracle.truffle.js.nodes.access.DeclareGlobalNode>)decoder.getObject());
case 147:
return nodeFactory.copy((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 148:
return nodeFactory.createToObject((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 149:
return nodeFactory.createToObjectFromWith((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject());
case 150:
return nodeFactory.createAccessArgumentsArrayDirectly((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (int)decoder.getObject(), (int)decoder.getObject());
case 151:
return nodeFactory.createCallApplyArguments((com.oracle.truffle.js.nodes.function.JSFunctionCallNode)decoder.getObject());
case 152:
return nodeFactory.createGuardDisconnectedArgumentRead((int)decoder.getObject(), (com.oracle.truffle.js.nodes.access.ReadElementNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject());
case 153:
return nodeFactory.createGuardDisconnectedArgumentWrite((int)decoder.getObject(), (com.oracle.truffle.js.nodes.access.WriteElementNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.api.frame.FrameSlot)decoder.getObject());
case 154:
return nodeFactory.createModuleBody((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 155:
return nodeFactory.createModuleYield();
case 156:
return nodeFactory.createTopLevelAsyncModuleBody((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 157:
return nodeFactory.createImportMeta((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 158:
return nodeFactory.createResolveStarImport((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.js.parser.ir.Module.ModuleRequest)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 159:
return nodeFactory.createResolveNamedImport((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.js.parser.ir.Module.ModuleRequest)decoder.getObject(), (java.lang.String)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 160:
return nodeFactory.createReadImportBinding((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 161:
return nodeFactory.createImportCall((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 162:
return nodeFactory.createImportCall((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 163:
return nodeFactory.createRestObject((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 164:
return nodeFactory.createInitializeInstanceElements((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 165:
return nodeFactory.createNewPrivateName((java.lang.String)decoder.getObject());
case 166:
return nodeFactory.createPrivateFieldGet((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 167:
return nodeFactory.createPrivateFieldSet((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 168:
return nodeFactory.createPrivateFieldMember((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 169:
return nodeFactory.createPrivateMethodMember((boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 170:
return nodeFactory.createPrivateAccessorMember((boolean)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)decoder.getObject());
case 171:
return nodeFactory.createPrivateBrandCheck((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 172:
return nodeFactory.createGetPrivateBrand((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 173:
return nodeFactory.createToPropertyKey((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 174:
return nodeFactory.createOptionalChain((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 175:
return nodeFactory.createOptionalChainShortCircuit((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 176:
return nodeFactory.createNamedEvaluation((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 177:
return nodeFactory.copyIfWithCondition((com.oracle.truffle.js.nodes.control.IfNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 178:
return nodeFactory.createDebugScope((com.oracle.truffle.js.runtime.JSContext)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
case 179:
return nodeFactory.createDebugVarWrapper((java.lang.String)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.access.JSTargetableNode)decoder.getObject());
case 180:
return nodeFactory.createInternalSlotId((java.lang.String)decoder.getObject(), (int)decoder.getObject());
case 181:
return nodeFactory.createPrivateFieldIn((com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject(), (com.oracle.truffle.js.nodes.JavaScriptNode)decoder.getObject());
default:
throw new IllegalArgumentException("unknown node id");
}
}

@Override
public int getMethodIdFromSignature(String signature) {
return EncoderSupport.getMethodIdFromSignature(signature);
}

private static class EncoderSupport {
static int getMethodIdFromSignature(String signature) {
switch (signature) {
case "createUnary(com.oracle.truffle.js.nodes.NodeFactory.UnaryOperation,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 0;
case "createLocalVarInc(com.oracle.truffle.js.nodes.NodeFactory.UnaryOperation,com.oracle.truffle.api.frame.FrameSlot,boolean,com.oracle.truffle.js.nodes.access.ScopeFrameNode,com.oracle.truffle.api.frame.FrameDescriptor)com.oracle.truffle.js.nodes.JavaScriptNode":
return 1;
case "createToNumericOperand(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 2;
case "createDual(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 3;
case "createBinary(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.NodeFactory.BinaryOperation,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 4;
case "createTypeofIdentical(com.oracle.truffle.js.nodes.JavaScriptNode,java.lang.String)com.oracle.truffle.js.nodes.JavaScriptNode":
return 5;
case "createLogicalOr(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 6;
case "createNotUndefinedOr(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 7;
case "createConstant(java.lang.Object)com.oracle.truffle.js.nodes.JavaScriptNode":
return 8;
case "createConstantBoolean(boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 9;
case "createConstantInteger(int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 10;
case "createConstantSafeInteger(long)com.oracle.truffle.js.nodes.JavaScriptNode":
return 11;
case "createConstantNumericUnit()com.oracle.truffle.js.nodes.JavaScriptNode":
return 12;
case "createConstantDouble(double)com.oracle.truffle.js.nodes.JavaScriptNode":
return 13;
case "createConstantString(java.lang.String)com.oracle.truffle.js.nodes.JavaScriptNode":
return 14;
case "createConstantUndefined()com.oracle.truffle.js.nodes.JavaScriptNode":
return 15;
case "createConstantNull()com.oracle.truffle.js.nodes.JavaScriptNode":
return 16;
case "createIf(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.IfNode":
return 17;
case "createSwitch(com.oracle.truffle.js.nodes.JavaScriptNode[],int[],com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.control.SwitchNode":
return 18;
case "createWhileDo(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 19;
case "createDoWhile(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 20;
case "createDesugaredFor(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 21;
case "createDesugaredForOf(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 22;
case "createDesugaredForIn(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 23;
case "createDesugaredForAwaitOf(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 24;
case "createFor(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.api.frame.FrameDescriptor,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.api.frame.FrameSlot)com.oracle.truffle.js.nodes.control.StatementNode":
return 25;
case "createIterationScope(com.oracle.truffle.api.frame.FrameDescriptor,com.oracle.truffle.api.frame.FrameSlot)com.oracle.truffle.js.nodes.function.IterationScopeNode":
return 26;
case "createBreak(com.oracle.truffle.js.nodes.control.BreakTarget)com.oracle.truffle.js.nodes.control.BreakNode":
return 27;
case "createContinue(com.oracle.truffle.js.nodes.control.ContinueTarget)com.oracle.truffle.js.nodes.control.ContinueNode":
return 28;
case "createLabel(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.control.BreakTarget)com.oracle.truffle.js.nodes.control.LabelNode":
return 29;
case "createEmpty()com.oracle.truffle.js.nodes.JavaScriptNode":
return 30;
case "createVoidBlock(com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 31;
case "createExprBlock(com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 32;
case "createReturnTarget(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.ReturnTargetNode":
return 33;
case "createFrameReturnTarget(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.ReturnTargetNode":
return 34;
case "createContinueTarget(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.control.ContinueTarget)com.oracle.truffle.js.nodes.control.ContinueTargetNode":
return 35;
case "createDirectBreakTarget(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.DirectBreakTargetNode":
return 36;
case "createDebugger()com.oracle.truffle.js.nodes.JavaScriptNode":
return 37;
case "createLocal(com.oracle.truffle.api.frame.FrameSlot,int,int,com.oracle.truffle.api.frame.FrameSlot[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 38;
case "createReadFrameSlot(com.oracle.truffle.api.frame.FrameSlot,com.oracle.truffle.js.nodes.access.ScopeFrameNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 39;
case "createReadFrameSlot(com.oracle.truffle.api.frame.FrameSlot,com.oracle.truffle.js.nodes.access.ScopeFrameNode,boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 40;
case "createReadCurrentFrameSlot(com.oracle.truffle.api.frame.FrameSlot)com.oracle.truffle.js.nodes.JavaScriptNode":
return 41;
case "createWriteFrameSlot(com.oracle.truffle.api.frame.FrameSlot,com.oracle.truffle.js.nodes.access.ScopeFrameNode,com.oracle.truffle.api.frame.FrameDescriptor,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode":
return 42;
case "createWriteFrameSlot(com.oracle.truffle.api.frame.FrameSlot,com.oracle.truffle.js.nodes.access.ScopeFrameNode,com.oracle.truffle.api.frame.FrameDescriptor,com.oracle.truffle.js.nodes.JavaScriptNode,boolean)com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode":
return 43;
case "createWriteCurrentFrameSlot(com.oracle.truffle.api.frame.FrameSlot,com.oracle.truffle.api.frame.FrameDescriptor,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode":
return 44;
case "createScopeFrame(int,int,com.oracle.truffle.api.frame.FrameSlot[],com.oracle.truffle.api.frame.FrameSlot)com.oracle.truffle.js.nodes.access.ScopeFrameNode":
return 45;
case "createReadLexicalGlobal(java.lang.String,boolean,com.oracle.truffle.js.runtime.JSContext)com.oracle.truffle.js.nodes.JavaScriptNode":
return 46;
case "createGlobalScope(com.oracle.truffle.js.runtime.JSContext)com.oracle.truffle.js.nodes.JavaScriptNode":
return 47;
case "createGlobalScopeTDZCheck(com.oracle.truffle.js.runtime.JSContext,java.lang.String,boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 48;
case "createGlobalVarWrapper(java.lang.String,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSTargetableNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 49;
case "createThrow(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 50;
case "createTryCatch(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.function.BlockScopeNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 51;
case "createTryFinally(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 52;
case "createFunctionCall(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 53;
case "createFunctionCallWithNewTarget(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 54;
case "createNew(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 55;
case "createAccessThis()com.oracle.truffle.js.nodes.JavaScriptNode":
return 56;
case "createAccessCallee(int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 57;
case "createAccessLexicalThis()com.oracle.truffle.js.nodes.JavaScriptNode":
return 58;
case "createAccessArgument(int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 59;
case "createAccessVarArgs(int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 60;
case "createAccessRestArgument(com.oracle.truffle.js.runtime.JSContext,int,int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 61;
case "createAccessNewTarget()com.oracle.truffle.js.nodes.JavaScriptNode":
return 62;
case "createAccessFrameArgument(int,int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 63;
case "createAccessHomeObject(com.oracle.truffle.js.runtime.JSContext)com.oracle.truffle.js.nodes.JavaScriptNode":
return 64;
case "createReadElementNode(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.ReadElementNode":
return 65;
case "createWriteElementNode(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.runtime.JSContext,boolean)com.oracle.truffle.js.nodes.access.WriteElementNode":
return 66;
case "createCompoundWriteElementNode(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,com.oracle.truffle.js.runtime.JSContext,boolean)com.oracle.truffle.js.nodes.access.WriteElementNode":
return 67;
case "createReadProperty(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,java.lang.String)com.oracle.truffle.js.nodes.access.JSTargetableNode":
return 68;
case "createReadProperty(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,java.lang.String,boolean)com.oracle.truffle.js.nodes.access.JSTargetableNode":
return 69;
case "createWriteProperty(com.oracle.truffle.js.nodes.JavaScriptNode,java.lang.Object,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.runtime.JSContext,boolean)com.oracle.truffle.js.nodes.access.WritePropertyNode":
return 70;
case "createWriteProperty(com.oracle.truffle.js.nodes.JavaScriptNode,java.lang.String,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.runtime.JSContext,boolean,boolean,boolean)com.oracle.truffle.js.nodes.access.WritePropertyNode":
return 71;
case "createWriteConstantVariable(com.oracle.truffle.js.nodes.JavaScriptNode,boolean)com.oracle.truffle.js.nodes.access.ConstantVariableWriteNode":
return 72;
case "createReadGlobalProperty(com.oracle.truffle.js.runtime.JSContext,java.lang.String)com.oracle.truffle.js.nodes.access.JSTargetableNode":
return 73;
case "createDeleteProperty(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,boolean,com.oracle.truffle.js.runtime.JSContext)com.oracle.truffle.js.nodes.access.JSTargetableNode":
return 74;
case "createFunctionRootNode(com.oracle.truffle.js.nodes.function.AbstractBodyNode,com.oracle.truffle.api.frame.FrameDescriptor,com.oracle.truffle.js.runtime.builtins.JSFunctionData,com.oracle.truffle.api.source.SourceSection,java.lang.String)com.oracle.truffle.js.nodes.function.FunctionRootNode":
return 75;
case "createConstructorRootNode(com.oracle.truffle.js.runtime.builtins.JSFunctionData,com.oracle.truffle.api.CallTarget,boolean)com.oracle.truffle.js.nodes.function.ConstructorRootNode":
return 76;
case "createFunctionBody(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.function.FunctionBodyNode":
return 77;
case "createFunctionExpression(com.oracle.truffle.js.runtime.builtins.JSFunctionData,com.oracle.truffle.js.nodes.function.FunctionRootNode,com.oracle.truffle.api.frame.FrameSlot)com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode":
return 78;
case "createFunctionExpressionLexicalThis(com.oracle.truffle.js.runtime.builtins.JSFunctionData,com.oracle.truffle.js.nodes.function.FunctionRootNode,com.oracle.truffle.api.frame.FrameSlot,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode":
return 79;
case "createPrepareThisBinding(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 80;
case "createGlobalObject()com.oracle.truffle.js.nodes.JavaScriptNode":
return 81;
case "createArgumentsObjectNode(com.oracle.truffle.js.runtime.JSContext,boolean,int,int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 82;
case "createThrowError(com.oracle.truffle.js.runtime.JSErrorType,java.lang.String)com.oracle.truffle.js.nodes.JavaScriptNode":
return 83;
case "createObjectLiteral(com.oracle.truffle.js.runtime.JSContext,java.util.ArrayList)com.oracle.truffle.js.nodes.JavaScriptNode":
return 84;
case "createArrayLiteral(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 85;
case "createArrayLiteralWithSpread(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode[])com.oracle.truffle.js.nodes.JavaScriptNode":
return 86;
case "createAccessorMember(java.lang.String,boolean,boolean,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 87;
case "createDataMember(java.lang.String,boolean,boolean,com.oracle.truffle.js.nodes.JavaScriptNode,boolean)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 88;
case "createProtoMember(java.lang.String,boolean,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 89;
case "createComputedDataMember(com.oracle.truffle.js.nodes.JavaScriptNode,boolean,boolean,com.oracle.truffle.js.nodes.JavaScriptNode,boolean,boolean)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 90;
case "createComputedAccessorMember(com.oracle.truffle.js.nodes.JavaScriptNode,boolean,boolean,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 91;
case "createSpreadObjectMember(boolean,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 92;
case "createStaticBlockMember(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 93;
case "createClassDefinition(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.function.JSFunctionExpressionNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode[],com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,java.lang.String,int,int,boolean,com.oracle.truffle.api.frame.FrameSlot)com.oracle.truffle.js.nodes.JavaScriptNode":
return 94;
case "createMakeMethod(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 95;
case "createSpreadArgument(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 96;
case "createSpreadArray(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 97;
case "createReturn(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.ReturnNode":
return 98;
case "createFrameReturn(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.ReturnNode":
return 99;
case "createTerminalPositionReturn(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.ReturnNode":
return 100;
case "createFunctionData(com.oracle.truffle.js.runtime.JSContext,int,java.lang.String,boolean,boolean,boolean,boolean,boolean,boolean,boolean,boolean,boolean,boolean)com.oracle.truffle.js.runtime.builtins.JSFunctionData":
return 101;
case "createAwait(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 102;
case "createYield(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,boolean,com.oracle.truffle.js.nodes.control.ReturnNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 103;
case "createAsyncGeneratorYield(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.control.ReturnNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 104;
case "createAsyncGeneratorYieldStar(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.control.ReturnNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.WriteNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 105;
case "createAsyncFunctionBody(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 106;
case "createGeneratorBody(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 107;
case "createAsyncGeneratorBody(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 108;
case "createGeneratorWrapper(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.WriteNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 109;
case "createGeneratorVoidBlock(com.oracle.truffle.js.nodes.JavaScriptNode[],com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.WriteNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 110;
case "createGeneratorExprBlock(com.oracle.truffle.js.nodes.JavaScriptNode[],com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.WriteNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 111;
case "createBlockScope(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.api.frame.FrameSlot,com.oracle.truffle.api.frame.FrameDescriptor,com.oracle.truffle.api.frame.FrameSlot,boolean,boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 112;
case "createTemplateObject(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 113;
case "createToString(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 114;
case "createRegExpLiteral(com.oracle.truffle.js.runtime.JSContext,java.lang.String,java.lang.String)com.oracle.truffle.js.nodes.JavaScriptNode":
return 115;
case "createGetIterator(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 116;
case "createGetAsyncIterator(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 117;
case "createEnumerate(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 118;
case "createIteratorNext(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 119;
case "createIteratorComplete(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 120;
case "createIteratorGetNextValue(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 121;
case "createIteratorSetDone(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 122;
case "createAsyncIteratorNext(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 123;
case "createIteratorValue(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 124;
case "createAsyncIteratorCloseWrapper(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode,com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 125;
case "createIteratorCloseIfNotDone(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 126;
case "createIteratorToArray(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.IteratorToArrayNode":
return 127;
case "createGetPrototype(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 128;
case "createSuperPropertyReference(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.JSTargetableNode":
return 129;
case "createTargetableWrapper(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.JSTargetableNode":
return 130;
case "createWith(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 131;
case "createWithVarWrapper(java.lang.String,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSTargetableNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 132;
case "createWithTarget(com.oracle.truffle.js.runtime.JSContext,java.lang.String,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 133;
case "createNewTargetConstruct(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.api.CallTarget)com.oracle.truffle.js.runtime.JavaScriptRootNode":
return 134;
case "createNewTargetCall(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.api.CallTarget)com.oracle.truffle.js.runtime.JavaScriptRootNode":
return 135;
case "createDropNewTarget(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.api.CallTarget)com.oracle.truffle.js.runtime.JavaScriptRootNode":
return 136;
case "createConstructorRequiresNewRoot(com.oracle.truffle.js.runtime.builtins.JSFunctionData,com.oracle.truffle.api.source.SourceSection)com.oracle.truffle.js.runtime.JavaScriptRootNode":
return 137;
case "createDerivedConstructorResult(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 138;
case "createDerivedConstructorThis(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 139;
case "createRequireObjectCoercible(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 140;
case "createFrameDescriptor()com.oracle.truffle.api.frame.FrameDescriptor":
return 141;
case "createBlockFrameDescriptor()com.oracle.truffle.api.frame.FrameDescriptor":
return 142;
case "createDeclareGlobalVariable(java.lang.String,boolean)com.oracle.truffle.js.nodes.access.DeclareGlobalNode":
return 143;
case "createDeclareGlobalFunction(java.lang.String,boolean,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.access.DeclareGlobalNode":
return 144;
case "createDeclareGlobalLexicalVariable(java.lang.String,boolean)com.oracle.truffle.js.nodes.access.DeclareGlobalNode":
return 145;
case "createGlobalDeclarationInstantiation(com.oracle.truffle.js.runtime.JSContext,java.util.List)com.oracle.truffle.js.nodes.JavaScriptNode":
return 146;
case "copy(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 147;
case "createToObject(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 148;
case "createToObjectFromWith(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,boolean)com.oracle.truffle.js.nodes.JavaScriptNode":
return 149;
case "createAccessArgumentsArrayDirectly(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,int,int)com.oracle.truffle.js.nodes.JavaScriptNode":
return 150;
case "createCallApplyArguments(com.oracle.truffle.js.nodes.function.JSFunctionCallNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 151;
case "createGuardDisconnectedArgumentRead(int,com.oracle.truffle.js.nodes.access.ReadElementNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.api.frame.FrameSlot)com.oracle.truffle.js.nodes.JavaScriptNode":
return 152;
case "createGuardDisconnectedArgumentWrite(int,com.oracle.truffle.js.nodes.access.WriteElementNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.api.frame.FrameSlot)com.oracle.truffle.js.nodes.JavaScriptNode":
return 153;
case "createModuleBody(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 154;
case "createModuleYield()com.oracle.truffle.js.nodes.JavaScriptNode":
return 155;
case "createTopLevelAsyncModuleBody(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 156;
case "createImportMeta(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 157;
case "createResolveStarImport(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.js.parser.ir.Module.ModuleRequest,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 158;
case "createResolveNamedImport(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.js.parser.ir.Module.ModuleRequest,java.lang.String,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 159;
case "createReadImportBinding(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 160;
case "createImportCall(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 161;
case "createImportCall(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 162;
case "createRestObject(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 163;
case "createInitializeInstanceElements(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 164;
case "createNewPrivateName(java.lang.String)com.oracle.truffle.js.nodes.JavaScriptNode":
return 165;
case "createPrivateFieldGet(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 166;
case "createPrivateFieldSet(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 167;
case "createPrivateFieldMember(com.oracle.truffle.js.nodes.JavaScriptNode,boolean,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 168;
case "createPrivateMethodMember(boolean,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 169;
case "createPrivateAccessorMember(boolean,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSWriteFrameSlotNode)com.oracle.truffle.js.nodes.access.ObjectLiteralNode.ObjectLiteralMemberNode":
return 170;
case "createPrivateBrandCheck(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 171;
case "createGetPrivateBrand(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 172;
case "createToPropertyKey(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 173;
case "createOptionalChain(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 174;
case "createOptionalChainShortCircuit(com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 175;
case "createNamedEvaluation(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 176;
case "copyIfWithCondition(com.oracle.truffle.js.nodes.control.IfNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.control.IfNode":
return 177;
case "createDebugScope(com.oracle.truffle.js.runtime.JSContext,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 178;
case "createDebugVarWrapper(java.lang.String,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.access.JSTargetableNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 179;
case "createInternalSlotId(java.lang.String,int)com.oracle.truffle.js.runtime.util.InternalSlotId":
return 180;
case "createPrivateFieldIn(com.oracle.truffle.js.nodes.JavaScriptNode,com.oracle.truffle.js.nodes.JavaScriptNode)com.oracle.truffle.js.nodes.JavaScriptNode":
return 181;
default:
throw new IllegalArgumentException("unknown method: " + signature);
}
}
}

@Override
public int getChecksum() {
return 954883760;
}
}
