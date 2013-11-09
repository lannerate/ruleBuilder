package com.flagleader.repository.e;

import com.flagleader.repository.IElement;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.db.FKModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.IndexModel;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.ParameterModel;
import com.flagleader.repository.db.ProcedureModel;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.db.ViewModel;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.excel.ExcelCellModel;
import com.flagleader.repository.excel.ExcelColModel;
import com.flagleader.repository.excel.ExcelRowModel;
import com.flagleader.repository.excel.ExcelSheetModel;
import com.flagleader.repository.excel.ExcelTableSheetModel;
import com.flagleader.repository.excel.ExcelXYSheetModel;
import com.flagleader.repository.export.AjaxPage;
import com.flagleader.repository.export.PageElementModel;
import com.flagleader.repository.export.PageFieldModel;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.flow.RulePoolNode;
import com.flagleader.repository.flow.RulePoolValue;
import com.flagleader.repository.rlm.ElementTextToken;
import com.flagleader.repository.rlm.ElseIfRuleToken;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.ModifyToken;
import com.flagleader.repository.rlm.RuleEnterToken;
import com.flagleader.repository.rlm.RuleSetToken;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.StaticTextToken;
import com.flagleader.repository.rlm.action.AbstractPackageField;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.DebugToken;
import com.flagleader.repository.rlm.action.ExcuteRuleToken;
import com.flagleader.repository.rlm.action.ExeDecisionToken;
import com.flagleader.repository.rlm.action.ExeExpressionToken;
import com.flagleader.repository.rlm.action.ExeRuleToken;
import com.flagleader.repository.rlm.action.GotoRuleToken;
import com.flagleader.repository.rlm.action.JavaStatementToken;
import com.flagleader.repository.rlm.action.LogRecordToken;
import com.flagleader.repository.rlm.action.MethodToken;
import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.action.ReturnToken;
import com.flagleader.repository.rlm.action.SelectRulePackageToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.ThrowToken;
import com.flagleader.repository.rlm.condition.ConditionToken;
import com.flagleader.repository.rlm.condition.ForEachConditionToken;
import com.flagleader.repository.rlm.condition.MultiConditionToken;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.value.ClassToken;
import com.flagleader.repository.rlm.value.ConstantSelectToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.MemberToken.MemberSelector;
import com.flagleader.repository.rlm.value.NewToken;
import com.flagleader.repository.rlm.value.SheetAndFieldsSelectToken;
import com.flagleader.repository.rlm.value.SheetAndWheresSelectToken;
import com.flagleader.repository.rlm.value.SheetDynamicSelectToken;
import com.flagleader.repository.rlm.value.SheetFentanMapping;
import com.flagleader.repository.rlm.value.SheetFentanSelectToken;
import com.flagleader.repository.rlm.value.SheetFieldMapping;
import com.flagleader.repository.rlm.value.SheetFieldSelectToken;
import com.flagleader.repository.rlm.value.SheetFieldsSelectToken;
import com.flagleader.repository.rlm.value.SheetFunction;
import com.flagleader.repository.rlm.value.SheetFunctionsSelectToken;
import com.flagleader.repository.rlm.value.SheetWhere;
import com.flagleader.repository.rlm.value.SheetWheresSelectToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.AbstractSubFunction;
import com.flagleader.repository.rom.AbstractSubVariable;
import com.flagleader.repository.rom.BusinessObjectAttribute;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.BusinessObjectMethod;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.FunctionMember;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.MappingFunction;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.CheckRuleInfo;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.CustomFunction;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateAction;
import com.flagleader.repository.tree.DecisionRelateCondition;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.DecisionValue;
import com.flagleader.repository.tree.EnumLibrary;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.FunctionLibrary;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.InterfaceContainer;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleFlowTransition;
import com.flagleader.repository.tree.RuleMirror;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.RuleSetFlow;
import com.flagleader.repository.tree.RuleTreeFlow;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import com.flagleader.repository.tree.TestObjectInfo;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlAttribute;
import com.flagleader.repository.xml.XmlNode;
import java.util.Iterator;

public abstract class b extends a
{
  protected void a(IElement paramIElement)
  {
    Iterator localIterator = paramIElement.getChildrenIterator();
    while (localIterator.hasNext())
      ((IElement)localIterator.next()).acceptVisitor(this);
  }

  public Object visitActionToken(StatementContainerToken paramStatementContainerToken)
  {
    a(paramStatementContainerToken);
    return super.visitActionToken(paramStatementContainerToken);
  }

  public Object visitAssignToken(AssignToken paramAssignToken)
  {
    a(paramAssignToken);
    return super.visitAssignToken(paramAssignToken);
  }

  public Object visitBusinessObjectAttribute(BusinessObjectAttribute paramBusinessObjectAttribute)
  {
    a(paramBusinessObjectAttribute);
    return super.visitBusinessObjectAttribute(paramBusinessObjectAttribute);
  }

  public Object visitBusinessObjectClass(BusinessObjectClass paramBusinessObjectClass)
  {
    a(paramBusinessObjectClass);
    return super.visitBusinessObjectClass(paramBusinessObjectClass);
  }

  public Object visitBusinessObjectMethod(BusinessObjectMethod paramBusinessObjectMethod)
  {
    a(paramBusinessObjectMethod);
    return super.visitBusinessObjectMethod(paramBusinessObjectMethod);
  }

  public Object visitClassLibrary(ClassContainer paramClassContainer)
  {
    a(paramClassContainer);
    return super.visitClassLibrary(paramClassContainer);
  }

  public Object visitClassToken(ClassToken paramClassToken)
  {
    a(paramClassToken);
    return super.visitClassToken(paramClassToken);
  }

  public Object visitConditionToken(ConditionToken paramConditionToken)
  {
    a(paramConditionToken);
    return super.visitConditionToken(paramConditionToken);
  }

  public Object visitConstantEnum(ConstantEnum paramConstantEnum)
  {
    a(paramConstantEnum);
    return super.visitConstantEnum(paramConstantEnum);
  }

  public Object visitConstantSelectToken(ConstantSelectToken paramConstantSelectToken)
  {
    a(paramConstantSelectToken);
    return super.visitConstantSelectToken(paramConstantSelectToken);
  }

  public Object visitConstantToken(ConstantToken paramConstantToken)
  {
    a(paramConstantToken);
    return super.visitConstantToken(paramConstantToken);
  }

  public Object visitJavaStatementToken(JavaStatementToken paramJavaStatementToken)
  {
    a(paramJavaStatementToken);
    return super.visitJavaStatementToken(paramJavaStatementToken);
  }

  public Object visitCustomFunction(CustomFunction paramCustomFunction)
  {
    a(paramCustomFunction);
    return super.visitCustomFunction(paramCustomFunction);
  }

  public Object visitEnumLibrary(EnumLibrary paramEnumLibrary)
  {
    a(paramEnumLibrary);
    return super.visitEnumLibrary(paramEnumLibrary);
  }

  public Object visitEnvionment(Envionment paramEnvionment)
  {
    a(paramEnvionment);
    return super.visitEnvionment(paramEnvionment);
  }

  public Object visitFieldToken(FieldToken paramFieldToken)
  {
    a(paramFieldToken);
    return super.visitFieldToken(paramFieldToken);
  }

  public Object visitFunctionLibrary(FunctionLibrary paramFunctionLibrary)
  {
    a(paramFunctionLibrary);
    return super.visitFunctionLibrary(paramFunctionLibrary);
  }

  public Object visitFunctionMember(FunctionMember paramFunctionMember)
  {
    a(paramFunctionMember);
    return super.visitFunctionMember(paramFunctionMember);
  }

  public Object visitGotoRuleToken(GotoRuleToken paramGotoRuleToken)
  {
    a(paramGotoRuleToken);
    return super.visitGotoRuleToken(paramGotoRuleToken);
  }

  public Object visitJudgeToken(JudgeToken paramJudgeToken)
  {
    a(paramJudgeToken);
    return super.visitJudgeToken(paramJudgeToken);
  }

  public Object visitMappingFunction(MappingFunction paramMappingFunction)
  {
    a(paramMappingFunction);
    return super.visitMappingFunction(paramMappingFunction);
  }

  public Object visitMappingVariable(MappingVariable paramMappingVariable)
  {
    a(paramMappingVariable);
    return super.visitMappingVariable(paramMappingVariable);
  }

  public Object visitMemberSelect(MemberToken.MemberSelector paramMemberSelector)
  {
    a(paramMemberSelector);
    return super.visitMemberSelect(paramMemberSelector);
  }

  public Object visitMemberToken(MemberToken paramMemberToken)
  {
    a(paramMemberToken);
    return super.visitMemberToken(paramMemberToken);
  }

  public Object visitSheetFieldsSelectToken(SheetFieldsSelectToken paramSheetFieldsSelectToken)
  {
    a(paramSheetFieldsSelectToken);
    return super.visitSheetFieldsSelectToken(paramSheetFieldsSelectToken);
  }

  public Object visitSheetFunctionsSelectToken(SheetFunctionsSelectToken paramSheetFunctionsSelectToken)
  {
    a(paramSheetFunctionsSelectToken);
    return super.visitSheetFunctionsSelectToken(paramSheetFunctionsSelectToken);
  }

  public Object visitSheetFunction(SheetFunction paramSheetFunction)
  {
    a(paramSheetFunction);
    return super.visitSheetFunction(paramSheetFunction);
  }

  public Object visitMethodToken(MethodToken paramMethodToken)
  {
    a(paramMethodToken);
    return super.visitMethodToken(paramMethodToken);
  }

  public Object visitModifyToken(ModifyToken paramModifyToken)
  {
    a(paramModifyToken);
    return super.visitModifyToken(paramModifyToken);
  }

  public Object visitNewToken(NewToken paramNewToken)
  {
    a(paramNewToken);
    return super.visitNewToken(paramNewToken);
  }

  public Object visitReturnToken(ReturnToken paramReturnToken)
  {
    a(paramReturnToken);
    return super.visitReturnToken(paramReturnToken);
  }

  public Object visitRule(Rule paramRule)
  {
    a(paramRule);
    return super.visitRule(paramRule);
  }

  public Object visitDecisionRule(DecisionRule paramDecisionRule)
  {
    a(paramDecisionRule);
    return super.visitDecisionRule(paramDecisionRule);
  }

  public Object visitDecisionValue(DecisionValue paramDecisionValue)
  {
    a(paramDecisionValue);
    return super.visitDecisionValue(paramDecisionValue);
  }

  public Object visitDecisionElement(DecisionElement paramDecisionElement)
  {
    a(paramDecisionElement);
    return super.visitDecisionElement(paramDecisionElement);
  }

  public Object visitDecisionElementValue(DecisionElementValue paramDecisionElementValue)
  {
    a(paramDecisionElementValue);
    return super.visitDecisionElementValue(paramDecisionElementValue);
  }

  public Object visitDecisionMultiRule(DecisionMultiRule paramDecisionMultiRule)
  {
    a(paramDecisionMultiRule);
    return super.visitDecisionMultiRule(paramDecisionMultiRule);
  }

  public Object visitExpressionRule(ExpressionRule paramExpressionRule)
  {
    a(paramExpressionRule);
    return super.visitExpressionRule(paramExpressionRule);
  }

  public Object visitDecisionRelateCondition(DecisionRelateCondition paramDecisionRelateCondition)
  {
    a(paramDecisionRelateCondition);
    return super.visitDecisionRelateCondition(paramDecisionRelateCondition);
  }

  public Object visitDecisionRelateRule(DecisionRelateRule paramDecisionRelateRule)
  {
    a(paramDecisionRelateRule);
    return super.visitDecisionRelateRule(paramDecisionRelateRule);
  }

  public Object visitRuleToken(RuleToken paramRuleToken)
  {
    a(paramRuleToken);
    return super.visitRuleToken(paramRuleToken);
  }

  public Object visitElseIfRuleToken(ElseIfRuleToken paramElseIfRuleToken)
  {
    a(paramElseIfRuleToken);
    return super.visitElseIfRuleToken(paramElseIfRuleToken);
  }

  public Object visitRulePackage(RulePackage paramRulePackage)
  {
    a(paramRulePackage);
    return super.visitRulePackage(paramRulePackage);
  }

  public Object visitRuleSet(RuleSet paramRuleSet)
  {
    a(paramRuleSet);
    return super.visitRuleSet(paramRuleSet);
  }

  public Object visitExeRuleToken(ExeRuleToken paramExeRuleToken)
  {
    a(paramExeRuleToken);
    return super.visitExeRuleToken(paramExeRuleToken);
  }

  public Object visitTempVariable(TempVariable paramTempVariable)
  {
    a(paramTempVariable);
    return super.visitTempVariable(paramTempVariable);
  }

  public Object visitTestCase(TestCase paramTestCase)
  {
    a(paramTestCase);
    return super.visitTestCase(paramTestCase);
  }

  public Object visitExportModel(ExportModel paramExportModel)
  {
    a(paramExportModel);
    return super.visitExportModel(paramExportModel);
  }

  public Object visitAjaxPage(AjaxPage paramAjaxPage)
  {
    a(paramAjaxPage);
    return null;
  }

  public Object visitTestCaseLib(TestCaseLib paramTestCaseLib)
  {
    a(paramTestCaseLib);
    return super.visitTestCaseLib(paramTestCaseLib);
  }

  public Object visitTestObjectInfo(TestObjectInfo paramTestObjectInfo)
  {
    a(paramTestObjectInfo);
    return super.visitTestObjectInfo(paramTestObjectInfo);
  }

  public Object visitThrowToken(ThrowToken paramThrowToken)
  {
    a(paramThrowToken);
    return super.visitThrowToken(paramThrowToken);
  }

  public Object visitDebugToken(DebugToken paramDebugToken)
  {
    a(paramDebugToken);
    return super.visitDebugToken(paramDebugToken);
  }

  public Object visitValueLibrary(ValueLibrary paramValueLibrary)
  {
    a(paramValueLibrary);
    return super.visitValueLibrary(paramValueLibrary);
  }

  public Object visitValueToken(ValueToken paramValueToken)
  {
    a(paramValueToken);
    return super.visitValueToken(paramValueToken);
  }

  public Object visitVariableLibrary(VariableLibrary paramVariableLibrary)
  {
    a(paramVariableLibrary);
    return super.visitVariableLibrary(paramVariableLibrary);
  }

  public Object visitStaticText(StaticTextToken paramStaticTextToken)
  {
    a(paramStaticTextToken);
    return super.visitStaticText(paramStaticTextToken);
  }

  public Object visitElementTextToken(ElementTextToken paramElementTextToken)
  {
    a(paramElementTextToken);
    return super.visitElementTextToken(paramElementTextToken);
  }

  public Object visitSubFunction(AbstractSubFunction paramAbstractSubFunction)
  {
    a(paramAbstractSubFunction);
    return super.visitSubFunction(paramAbstractSubFunction);
  }

  public Object visitGlobalFunction(GlobalFunction paramGlobalFunction)
  {
    a(paramGlobalFunction);
    return super.visitGlobalFunction(paramGlobalFunction);
  }

  public Object visitSubVariable(AbstractSubVariable paramAbstractSubVariable)
  {
    a(paramAbstractSubVariable);
    return super.visitSubVariable(paramAbstractSubVariable);
  }

  public Object visitMultiActionToken(MultiActionToken paramMultiActionToken)
  {
    a(paramMultiActionToken);
    return super.visitMultiActionToken(paramMultiActionToken);
  }

  public Object visitMultiConditionToken(MultiConditionToken paramMultiConditionToken)
  {
    a(paramMultiConditionToken);
    return super.visitMultiConditionToken(paramMultiConditionToken);
  }

  public Object visitRuleSetToken(RuleSetToken paramRuleSetToken)
  {
    a(paramRuleSetToken);
    return super.visitRuleSetToken(paramRuleSetToken);
  }

  public Object visitDBModel(DBModel paramDBModel)
  {
    a(paramDBModel);
    return super.visitDBModel(paramDBModel);
  }

  public Object visitFieldModel(FieldModel paramFieldModel)
  {
    a(paramFieldModel);
    return super.visitFieldModel(paramFieldModel);
  }

  public Object visitFKModel(FKModel paramFKModel)
  {
    a(paramFKModel);
    return super.visitFKModel(paramFKModel);
  }

  public Object visitIndexModel(IndexModel paramIndexModel)
  {
    a(paramIndexModel);
    return super.visitIndexModel(paramIndexModel);
  }

  public Object visitSelectTable(SelectTable paramSelectTable)
  {
    a(paramSelectTable);
    return super.visitSelectTable(paramSelectTable);
  }

  public Object visitCustomSql(CustomSql paramCustomSql)
  {
    a(paramCustomSql);
    return super.visitCustomSql(paramCustomSql);
  }

  public Object visitParameterModel(ParameterModel paramParameterModel)
  {
    a(paramParameterModel);
    return super.visitParameterModel(paramParameterModel);
  }

  public Object visitProcedureModel(ProcedureModel paramProcedureModel)
  {
    a(paramProcedureModel);
    return super.visitProcedureModel(paramProcedureModel);
  }

  public Object visitTableModel(TableModel paramTableModel)
  {
    a(paramTableModel);
    return super.visitTableModel(paramTableModel);
  }

  public Object visitViewModel(ViewModel paramViewModel)
  {
    a(paramViewModel);
    return super.visitViewModel(paramViewModel);
  }

  public Object visitPageFieldModel(PageFieldModel paramPageFieldModel)
  {
    a(paramPageFieldModel);
    return super.visitPageFieldModel(paramPageFieldModel);
  }

  public Object visitPageElementModel(PageElementModel paramPageElementModel)
  {
    a(paramPageElementModel);
    return super.visitPageElementModel(paramPageElementModel);
  }

  public Object visitXmlAttribute(XmlAttribute paramXmlAttribute)
  {
    a(paramXmlAttribute);
    return super.visitXmlAttribute(paramXmlAttribute);
  }

  public Object visitXmlNode(XmlNode paramXmlNode)
  {
    a(paramXmlNode);
    return super.visitXmlNode(paramXmlNode);
  }

  public Object visitRuleFlowActivitie(RuleFlowActivitie paramRuleFlowActivitie)
  {
    a(paramRuleFlowActivitie);
    return super.visitRuleFlowActivitie(paramRuleFlowActivitie);
  }

  public Object visitRuleFlowTransition(RuleFlowTransition paramRuleFlowTransition)
  {
    a(paramRuleFlowTransition);
    return super.visitRuleFlowTransition(paramRuleFlowTransition);
  }

  public Object visitRuleSetFlow(RuleSetFlow paramRuleSetFlow)
  {
    a(paramRuleSetFlow);
    return super.visitRuleSetFlow(paramRuleSetFlow);
  }

  public Object visitRuleTreeFlow(RuleTreeFlow paramRuleTreeFlow)
  {
    a(paramRuleTreeFlow);
    return super.visitRuleTreeFlow(paramRuleTreeFlow);
  }

  public Object visitRuleMirror(RuleMirror paramRuleMirror)
  {
    a(paramRuleMirror);
    return super.visitRuleMirror(paramRuleMirror);
  }

  public Object visitEnumTable(EnumTable paramEnumTable)
  {
    a(paramEnumTable);
    return super.visitEnumTable(paramEnumTable);
  }

  public Object visitMapValue(MapValue paramMapValue)
  {
    a(paramMapValue);
    return super.visitMapValue(paramMapValue);
  }

  public Object visitSheetFieldModel(SheetFieldModel paramSheetFieldModel)
  {
    a(paramSheetFieldModel);
    return super.visitSheetFieldModel(paramSheetFieldModel);
  }

  public Object visitSheetTable(SheetTable paramSheetTable)
  {
    a(paramSheetTable);
    return super.visitSheetTable(paramSheetTable);
  }

  public Object visitSheetAndFieldsSelectToken(SheetAndFieldsSelectToken paramSheetAndFieldsSelectToken)
  {
    a(paramSheetAndFieldsSelectToken);
    return super.visitSheetAndFieldsSelectToken(paramSheetAndFieldsSelectToken);
  }

  public Object visitSheetFieldMapping(SheetFieldMapping paramSheetFieldMapping)
  {
    a(paramSheetFieldMapping);
    return super.visitSheetFieldMapping(paramSheetFieldMapping);
  }

  public Object visitSheetWhere(SheetWhere paramSheetWhere)
  {
    a(paramSheetWhere);
    return super.visitSheetWhere(paramSheetWhere);
  }

  public Object visitSheetWheresSelectToken(SheetWheresSelectToken paramSheetWheresSelectToken)
  {
    a(paramSheetWheresSelectToken);
    return super.visitSheetWheresSelectToken(paramSheetWheresSelectToken);
  }

  public Object visitSheetAndWheresSelectToken(SheetAndWheresSelectToken paramSheetAndWheresSelectToken)
  {
    a(paramSheetAndWheresSelectToken);
    return super.visitSheetAndWheresSelectToken(paramSheetAndWheresSelectToken);
  }

  public Object visitSheetFieldSelectToken(SheetFieldSelectToken paramSheetFieldSelectToken)
  {
    a(paramSheetFieldSelectToken);
    return super.visitSheetFieldSelectToken(paramSheetFieldSelectToken);
  }

  public Object visitExcelBookModel(ExcelBookModel paramExcelBookModel)
  {
    a(paramExcelBookModel);
    return super.visitExcelBookModel(paramExcelBookModel);
  }

  public Object visitExcelRowModel(ExcelRowModel paramExcelRowModel)
  {
    a(paramExcelRowModel);
    return super.visitExcelRowModel(paramExcelRowModel);
  }

  public Object visitExcelCellModel(ExcelCellModel paramExcelCellModel)
  {
    a(paramExcelCellModel);
    return super.visitExcelCellModel(paramExcelCellModel);
  }

  public Object visitExcelColModel(ExcelColModel paramExcelColModel)
  {
    a(paramExcelColModel);
    return super.visitExcelColModel(paramExcelColModel);
  }

  public Object visitExcelSheetModel(ExcelSheetModel paramExcelSheetModel)
  {
    a(paramExcelSheetModel);
    return super.visitExcelSheetModel(paramExcelSheetModel);
  }

  public Object visitExcelTableSheetModel(ExcelTableSheetModel paramExcelTableSheetModel)
  {
    a(paramExcelTableSheetModel);
    return super.visitExcelTableSheetModel(paramExcelTableSheetModel);
  }

  public Object visitExcelXYSheetModel(ExcelXYSheetModel paramExcelXYSheetModel)
  {
    a(paramExcelXYSheetModel);
    return super.visitExcelXYSheetModel(paramExcelXYSheetModel);
  }

  public Object visitSoapParameter(SoapParameter paramSoapParameter)
  {
    a(paramSoapParameter);
    return super.visitSoapParameter(paramSoapParameter);
  }

  public Object visitSoapService(SoapService paramSoapService)
  {
    a(paramSoapService);
    return super.visitSoapService(paramSoapService);
  }

  public Object visitExcuteRuleToken(ExcuteRuleToken paramExcuteRuleToken)
  {
    a(paramExcuteRuleToken);
    return super.visitExcuteRuleToken(paramExcuteRuleToken);
  }

  public Object visitLogRecordToken(LogRecordToken paramLogRecordToken)
  {
    a(paramLogRecordToken);
    return super.visitLogRecordToken(paramLogRecordToken);
  }

  public Object visitSheetDynamicSelectToken(SheetDynamicSelectToken paramSheetDynamicSelectToken)
  {
    a(paramSheetDynamicSelectToken);
    return super.visitSheetDynamicSelectToken(paramSheetDynamicSelectToken);
  }

  public Object visitTreeAttribute(TreeAttribute paramTreeAttribute)
  {
    a(paramTreeAttribute);
    return super.visitTreeAttribute(paramTreeAttribute);
  }

  public Object visitTreeNode(TreeValueNode paramTreeValueNode)
  {
    a(paramTreeValueNode);
    return super.visitTreeNode(paramTreeValueNode);
  }

  public Object visitBOContainerGroup(BOContainerGroup paramBOContainerGroup)
  {
    a(paramBOContainerGroup);
    return super.visitBOContainerGroup(paramBOContainerGroup);
  }

  public Object visitSheetMap(SheetMap paramSheetMap)
  {
    a(paramSheetMap);
    return super.visitSheetMap(paramSheetMap);
  }

  public Object visitSelectRulePackageToken(SelectRulePackageToken paramSelectRulePackageToken)
  {
    a(paramSelectRulePackageToken);
    return super.visitSelectRulePackageToken(paramSelectRulePackageToken);
  }

  public Object visitPackageField(AbstractPackageField paramAbstractPackageField)
  {
    a(paramAbstractPackageField);
    return super.visitPackageField(paramAbstractPackageField);
  }

  public Object visitSheetFentanMapping(SheetFentanMapping paramSheetFentanMapping)
  {
    a(paramSheetFentanMapping);
    return super.visitSheetFentanMapping(paramSheetFentanMapping);
  }

  public Object visitSheetFentanSelectToken(SheetFentanSelectToken paramSheetFentanSelectToken)
  {
    a(paramSheetFentanSelectToken);
    return super.visitSheetFentanSelectToken(paramSheetFentanSelectToken);
  }

  public Object visitRuleEnterToken(RuleEnterToken paramRuleEnterToken)
  {
    a(paramRuleEnterToken);
    return null;
  }

  public Object visitInterfaceContainer(InterfaceContainer paramInterfaceContainer)
  {
    a(paramInterfaceContainer);
    return super.visitInterfaceContainer(paramInterfaceContainer);
  }

  public Object visitDecisionRelateAction(DecisionRelateAction paramDecisionRelateAction)
  {
    a(paramDecisionRelateAction);
    return super.visitDecisionRelateAction(paramDecisionRelateAction);
  }

  public Object visitExeExpressionToken(ExeExpressionToken paramExeExpressionToken)
  {
    a(paramExeExpressionToken);
    return super.visitExeExpressionToken(paramExeExpressionToken);
  }

  public Object visitExeDecisionToken(ExeDecisionToken paramExeDecisionToken)
  {
    a(paramExeDecisionToken);
    return super.visitExeDecisionToken(paramExeDecisionToken);
  }

  public Object visitRulePoolFlow(RulePoolFlow paramRulePoolFlow)
  {
    a(paramRulePoolFlow);
    return super.visitRulePoolFlow(paramRulePoolFlow);
  }

  public Object visitRulePoolNode(RulePoolNode paramRulePoolNode)
  {
    a(paramRulePoolNode);
    return super.visitRulePoolNode(paramRulePoolNode);
  }

  public Object visitRulePoolValue(RulePoolValue paramRulePoolValue)
  {
    a(paramRulePoolValue);
    return super.visitRulePoolValue(paramRulePoolValue);
  }

  public Object visitContainer(IRuleContainer paramIRuleContainer)
  {
    a(paramIRuleContainer);
    return super.visitContainer(paramIRuleContainer);
  }

  public Object visitSelector(ISelectorEditen paramISelectorEditen)
  {
    a(paramISelectorEditen);
    return super.visitSelector(paramISelectorEditen);
  }

  public Object visitCheckRuleInfo(CheckRuleInfo paramCheckRuleInfo)
  {
    a(paramCheckRuleInfo);
    return super.visitCheckRuleInfo(paramCheckRuleInfo);
  }

  public Object visitForEachConditionToken(ForEachConditionToken paramForEachConditionToken)
  {
    a(paramForEachConditionToken);
    return super.visitForEachConditionToken(paramForEachConditionToken);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.b
 * JD-Core Version:    0.6.0
 */