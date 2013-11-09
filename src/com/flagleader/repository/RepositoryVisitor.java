package com.flagleader.repository;

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
import com.flagleader.repository.tree.PackageHistory;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleFlowTransition;
import com.flagleader.repository.tree.RuleHistory;
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

public abstract interface RepositoryVisitor
{
  public abstract Object visitRulePackage(RulePackage paramRulePackage);

  public abstract Object visitRuleSet(RuleSet paramRuleSet);

  public abstract Object visitRule(Rule paramRule);

  public abstract Object visitDecisionRule(DecisionRule paramDecisionRule);

  public abstract Object visitDecisionValue(DecisionValue paramDecisionValue);

  public abstract Object visitEnvionment(Envionment paramEnvionment);

  public abstract Object visitClassLibrary(ClassContainer paramClassContainer);

  public abstract Object visitInterfaceContainer(InterfaceContainer paramInterfaceContainer);

  public abstract Object visitCustomFunction(CustomFunction paramCustomFunction);

  public abstract Object visitEnumLibrary(EnumLibrary paramEnumLibrary);

  public abstract Object visitFunctionLibrary(FunctionLibrary paramFunctionLibrary);

  public abstract Object visitValueLibrary(ValueLibrary paramValueLibrary);

  public abstract Object visitVariableLibrary(VariableLibrary paramVariableLibrary);

  public abstract Object visitTestCaseLib(TestCaseLib paramTestCaseLib);

  public abstract Object visitTestCase(TestCase paramTestCase);

  public abstract Object visitExportModel(ExportModel paramExportModel);

  public abstract Object visitTestObjectInfo(TestObjectInfo paramTestObjectInfo);

  public abstract Object visitBusinessObjectClass(BusinessObjectClass paramBusinessObjectClass);

  public abstract Object visitBusinessObjectMethod(BusinessObjectMethod paramBusinessObjectMethod);

  public abstract Object visitBusinessObjectAttribute(BusinessObjectAttribute paramBusinessObjectAttribute);

  public abstract Object visitConstantEnum(ConstantEnum paramConstantEnum);

  public abstract Object visitFunctionMember(FunctionMember paramFunctionMember);

  public abstract Object visitMappingVariable(MappingVariable paramMappingVariable);

  public abstract Object visitTempVariable(TempVariable paramTempVariable);

  public abstract Object visitSubFunction(AbstractSubFunction paramAbstractSubFunction);

  public abstract Object visitGlobalFunction(GlobalFunction paramGlobalFunction);

  public abstract Object visitSubVariable(AbstractSubVariable paramAbstractSubVariable);

  public abstract Object visitMappingFunction(MappingFunction paramMappingFunction);

  public abstract Object visitRuleToken(RuleToken paramRuleToken);

  public abstract Object visitRuleSetToken(RuleSetToken paramRuleSetToken);

  public abstract Object visitMultiActionToken(MultiActionToken paramMultiActionToken);

  public abstract Object visitMultiConditionToken(MultiConditionToken paramMultiConditionToken);

  public abstract Object visitActionToken(StatementContainerToken paramStatementContainerToken);

  public abstract Object visitConditionToken(ConditionToken paramConditionToken);

  public abstract Object visitModifyToken(ModifyToken paramModifyToken);

  public abstract Object visitMemberToken(MemberToken paramMemberToken);

  public abstract Object visitMemberSelect(MemberToken.MemberSelector paramMemberSelector);

  public abstract Object visitFieldToken(FieldToken paramFieldToken);

  public abstract Object visitMethodToken(MethodToken paramMethodToken);

  public abstract Object visitJudgeToken(JudgeToken paramJudgeToken);

  public abstract Object visitValueToken(ValueToken paramValueToken);

  public abstract Object visitConstantToken(ConstantToken paramConstantToken);

  public abstract Object visitJavaStatementToken(JavaStatementToken paramJavaStatementToken);

  public abstract Object visitNewToken(NewToken paramNewToken);

  public abstract Object visitConstantSelectToken(ConstantSelectToken paramConstantSelectToken);

  public abstract Object visitClassToken(ClassToken paramClassToken);

  public abstract Object visitAssignToken(AssignToken paramAssignToken);

  public abstract Object visitReturnToken(ReturnToken paramReturnToken);

  public abstract Object visitExeRuleToken(ExeRuleToken paramExeRuleToken);

  public abstract Object visitExeExpressionToken(ExeExpressionToken paramExeExpressionToken);

  public abstract Object visitExeDecisionToken(ExeDecisionToken paramExeDecisionToken);

  public abstract Object visitGotoRuleToken(GotoRuleToken paramGotoRuleToken);

  public abstract Object visitThrowToken(ThrowToken paramThrowToken);

  public abstract Object visitDebugToken(DebugToken paramDebugToken);

  public abstract Object visitLogRecordToken(LogRecordToken paramLogRecordToken);

  public abstract Object visitStaticText(StaticTextToken paramStaticTextToken);

  public abstract Object visitElementTextToken(ElementTextToken paramElementTextToken);

  public abstract Object visitDBModel(DBModel paramDBModel);

  public abstract Object visitTableModel(TableModel paramTableModel);

  public abstract Object visitViewModel(ViewModel paramViewModel);

  public abstract Object visitFieldModel(FieldModel paramFieldModel);

  public abstract Object visitPageFieldModel(PageFieldModel paramPageFieldModel);

  public abstract Object visitPageElementModel(PageElementModel paramPageElementModel);

  public abstract Object visitIndexModel(IndexModel paramIndexModel);

  public abstract Object visitFKModel(FKModel paramFKModel);

  public abstract Object visitSelectTable(SelectTable paramSelectTable);

  public abstract Object visitCustomSql(CustomSql paramCustomSql);

  public abstract Object visitParameterModel(ParameterModel paramParameterModel);

  public abstract Object visitProcedureModel(ProcedureModel paramProcedureModel);

  public abstract Object visitXmlNode(XmlNode paramXmlNode);

  public abstract Object visitXmlAttribute(XmlAttribute paramXmlAttribute);

  public abstract Object visitRuleFlowTransition(RuleFlowTransition paramRuleFlowTransition);

  public abstract Object visitRuleFlowActivitie(RuleFlowActivitie paramRuleFlowActivitie);

  public abstract Object visitRuleSetFlow(RuleSetFlow paramRuleSetFlow);

  public abstract Object visitRuleTreeFlow(RuleTreeFlow paramRuleTreeFlow);

  public abstract Object visitRulePoolFlow(RulePoolFlow paramRulePoolFlow);

  public abstract Object visitRulePoolNode(RulePoolNode paramRulePoolNode);

  public abstract Object visitDecisionElement(DecisionElement paramDecisionElement);

  public abstract Object visitDecisionElementValue(DecisionElementValue paramDecisionElementValue);

  public abstract Object visitDecisionMultiRule(DecisionMultiRule paramDecisionMultiRule);

  public abstract Object visitRuleMirror(RuleMirror paramRuleMirror);

  public abstract Object visitElseIfRuleToken(ElseIfRuleToken paramElseIfRuleToken);

  public abstract Object visitRuleEnterToken(RuleEnterToken paramRuleEnterToken);

  public abstract Object visitDecisionRelateRule(DecisionRelateRule paramDecisionRelateRule);

  public abstract Object visitDecisionRelateCondition(DecisionRelateCondition paramDecisionRelateCondition);

  public abstract Object visitDecisionRelateAction(DecisionRelateAction paramDecisionRelateAction);

  public abstract Object visitEnumTable(EnumTable paramEnumTable);

  public abstract Object visitRuleHistory(RuleHistory paramRuleHistory);

  public abstract Object visitPackageHistory(PackageHistory paramPackageHistory);

  public abstract Object visitSheetFieldModel(SheetFieldModel paramSheetFieldModel);

  public abstract Object visitSheetTable(SheetTable paramSheetTable);

  public abstract Object visitSheetFieldsSelectToken(SheetFieldsSelectToken paramSheetFieldsSelectToken);

  public abstract Object visitSheetFunctionsSelectToken(SheetFunctionsSelectToken paramSheetFunctionsSelectToken);

  public abstract Object visitSheetFunction(SheetFunction paramSheetFunction);

  public abstract Object visitSheetWheresSelectToken(SheetWheresSelectToken paramSheetWheresSelectToken);

  public abstract Object visitSheetWhere(SheetWhere paramSheetWhere);

  public abstract Object visitSheetAndFieldsSelectToken(SheetAndFieldsSelectToken paramSheetAndFieldsSelectToken);

  public abstract Object visitSheetDynamicSelectToken(SheetDynamicSelectToken paramSheetDynamicSelectToken);

  public abstract Object visitSheetFentanSelectToken(SheetFentanSelectToken paramSheetFentanSelectToken);

  public abstract Object visitSheetFentanMapping(SheetFentanMapping paramSheetFentanMapping);

  public abstract Object visitSheetFieldMapping(SheetFieldMapping paramSheetFieldMapping);

  public abstract Object visitSheetAndWheresSelectToken(SheetAndWheresSelectToken paramSheetAndWheresSelectToken);

  public abstract Object visitSheetFieldSelectToken(SheetFieldSelectToken paramSheetFieldSelectToken);

  public abstract Object visitExcelBookModel(ExcelBookModel paramExcelBookModel);

  public abstract Object visitExcelRowModel(ExcelRowModel paramExcelRowModel);

  public abstract Object visitExcelColModel(ExcelColModel paramExcelColModel);

  public abstract Object visitExcelCellModel(ExcelCellModel paramExcelCellModel);

  public abstract Object visitExcelSheetModel(ExcelSheetModel paramExcelSheetModel);

  public abstract Object visitExcelTableSheetModel(ExcelTableSheetModel paramExcelTableSheetModel);

  public abstract Object visitExcelXYSheetModel(ExcelXYSheetModel paramExcelXYSheetModel);

  public abstract Object visitSoapService(SoapService paramSoapService);

  public abstract Object visitSoapParameter(SoapParameter paramSoapParameter);

  public abstract Object visitExcuteRuleToken(ExcuteRuleToken paramExcuteRuleToken);

  public abstract Object visitAjaxPage(AjaxPage paramAjaxPage);

  public abstract Object visitTreeNode(TreeValueNode paramTreeValueNode);

  public abstract Object visitTreeAttribute(TreeAttribute paramTreeAttribute);

  public abstract Object visitBOContainerGroup(BOContainerGroup paramBOContainerGroup);

  public abstract Object visitSheetMap(SheetMap paramSheetMap);

  public abstract Object visitMapValue(MapValue paramMapValue);

  public abstract Object visitSelectRulePackageToken(SelectRulePackageToken paramSelectRulePackageToken);

  public abstract Object visitPackageField(AbstractPackageField paramAbstractPackageField);

  public abstract Object visitExpressionRule(ExpressionRule paramExpressionRule);

  public abstract Object visitRulePoolValue(RulePoolValue paramRulePoolValue);

  public abstract Object visitContainer(IRuleContainer paramIRuleContainer);

  public abstract Object visitSelector(ISelectorEditen paramISelectorEditen);

  public abstract Object visitCheckRuleInfo(CheckRuleInfo paramCheckRuleInfo);

  public abstract Object visitForEachConditionToken(ForEachConditionToken paramForEachConditionToken);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.RepositoryVisitor
 * JD-Core Version:    0.6.0
 */