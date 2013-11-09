package com.flagleader.repository.e;

import com.flagleader.repository.RepositoryVisitor;
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
import java.util.Observable;

public abstract class a extends Observable
  implements RepositoryVisitor
{
  public Object visitActionToken(StatementContainerToken paramStatementContainerToken)
  {
    return null;
  }

  public Object visitAssignToken(AssignToken paramAssignToken)
  {
    return null;
  }

  public Object visitBusinessObjectAttribute(BusinessObjectAttribute paramBusinessObjectAttribute)
  {
    return null;
  }

  public Object visitBusinessObjectClass(BusinessObjectClass paramBusinessObjectClass)
  {
    return null;
  }

  public Object visitBusinessObjectMethod(BusinessObjectMethod paramBusinessObjectMethod)
  {
    return null;
  }

  public Object visitClassLibrary(ClassContainer paramClassContainer)
  {
    return null;
  }

  public Object visitClassToken(ClassToken paramClassToken)
  {
    return null;
  }

  public Object visitConditionToken(ConditionToken paramConditionToken)
  {
    return null;
  }

  public Object visitConstantEnum(ConstantEnum paramConstantEnum)
  {
    return null;
  }

  public Object visitConstantSelectToken(ConstantSelectToken paramConstantSelectToken)
  {
    return null;
  }

  public Object visitConstantToken(ConstantToken paramConstantToken)
  {
    return null;
  }

  public Object visitJavaStatementToken(JavaStatementToken paramJavaStatementToken)
  {
    return null;
  }

  public Object visitCustomFunction(CustomFunction paramCustomFunction)
  {
    return null;
  }

  public Object visitEnumLibrary(EnumLibrary paramEnumLibrary)
  {
    return null;
  }

  public Object visitEnvionment(Envionment paramEnvionment)
  {
    return null;
  }

  public Object visitFieldToken(FieldToken paramFieldToken)
  {
    return null;
  }

  public Object visitFunctionLibrary(FunctionLibrary paramFunctionLibrary)
  {
    return null;
  }

  public Object visitFunctionMember(FunctionMember paramFunctionMember)
  {
    return null;
  }

  public Object visitGotoRuleToken(GotoRuleToken paramGotoRuleToken)
  {
    return null;
  }

  public Object visitJudgeToken(JudgeToken paramJudgeToken)
  {
    return null;
  }

  public Object visitMappingFunction(MappingFunction paramMappingFunction)
  {
    return null;
  }

  public Object visitMappingVariable(MappingVariable paramMappingVariable)
  {
    return null;
  }

  public Object visitMemberSelect(MemberToken.MemberSelector paramMemberSelector)
  {
    return null;
  }

  public Object visitMemberToken(MemberToken paramMemberToken)
  {
    return null;
  }

  public Object visitSheetFieldsSelectToken(SheetFieldsSelectToken paramSheetFieldsSelectToken)
  {
    return null;
  }

  public Object visitSheetFunctionsSelectToken(SheetFunctionsSelectToken paramSheetFunctionsSelectToken)
  {
    return null;
  }

  public Object visitMethodToken(MethodToken paramMethodToken)
  {
    return null;
  }

  public Object visitModifyToken(ModifyToken paramModifyToken)
  {
    return null;
  }

  public Object visitNewToken(NewToken paramNewToken)
  {
    return null;
  }

  public Object visitReturnToken(ReturnToken paramReturnToken)
  {
    return null;
  }

  public Object visitRule(Rule paramRule)
  {
    return null;
  }

  public Object visitDecisionRule(DecisionRule paramDecisionRule)
  {
    return null;
  }

  public Object visitDecisionElement(DecisionElement paramDecisionElement)
  {
    return null;
  }

  public Object visitDecisionElementValue(DecisionElementValue paramDecisionElementValue)
  {
    return null;
  }

  public Object visitDecisionMultiRule(DecisionMultiRule paramDecisionMultiRule)
  {
    return null;
  }

  public Object visitExpressionRule(ExpressionRule paramExpressionRule)
  {
    return null;
  }

  public Object visitDecisionRelateCondition(DecisionRelateCondition paramDecisionRelateCondition)
  {
    return null;
  }

  public Object visitDecisionRelateRule(DecisionRelateRule paramDecisionRelateRule)
  {
    return null;
  }

  public Object visitDecisionValue(DecisionValue paramDecisionValue)
  {
    return null;
  }

  public Object visitRuleToken(RuleToken paramRuleToken)
  {
    return null;
  }

  public Object visitElseIfRuleToken(ElseIfRuleToken paramElseIfRuleToken)
  {
    return null;
  }

  public Object visitRulePackage(RulePackage paramRulePackage)
  {
    return null;
  }

  public Object visitRuleSet(RuleSet paramRuleSet)
  {
    return null;
  }

  public Object visitExeRuleToken(ExeRuleToken paramExeRuleToken)
  {
    return null;
  }

  public Object visitTempVariable(TempVariable paramTempVariable)
  {
    return null;
  }

  public Object visitTestCase(TestCase paramTestCase)
  {
    return null;
  }

  public Object visitExportModel(ExportModel paramExportModel)
  {
    return null;
  }

  public Object visitTestCaseLib(TestCaseLib paramTestCaseLib)
  {
    return null;
  }

  public Object visitTestObjectInfo(TestObjectInfo paramTestObjectInfo)
  {
    return null;
  }

  public Object visitThrowToken(ThrowToken paramThrowToken)
  {
    return null;
  }

  public Object visitDebugToken(DebugToken paramDebugToken)
  {
    return null;
  }

  public Object visitValueLibrary(ValueLibrary paramValueLibrary)
  {
    return null;
  }

  public Object visitValueToken(ValueToken paramValueToken)
  {
    return null;
  }

  public Object visitVariableLibrary(VariableLibrary paramVariableLibrary)
  {
    return null;
  }

  public Object visitStaticText(StaticTextToken paramStaticTextToken)
  {
    return null;
  }

  public Object visitElementTextToken(ElementTextToken paramElementTextToken)
  {
    return null;
  }

  public Object visitSubFunction(AbstractSubFunction paramAbstractSubFunction)
  {
    return null;
  }

  public Object visitGlobalFunction(GlobalFunction paramGlobalFunction)
  {
    return null;
  }

  public Object visitSubVariable(AbstractSubVariable paramAbstractSubVariable)
  {
    return null;
  }

  public Object visitMultiActionToken(MultiActionToken paramMultiActionToken)
  {
    return null;
  }

  public Object visitMultiConditionToken(MultiConditionToken paramMultiConditionToken)
  {
    return null;
  }

  public Object visitRuleSetToken(RuleSetToken paramRuleSetToken)
  {
    return null;
  }

  public Object visitDBModel(DBModel paramDBModel)
  {
    return null;
  }

  public Object visitFieldModel(FieldModel paramFieldModel)
  {
    return null;
  }

  public Object visitFKModel(FKModel paramFKModel)
  {
    return null;
  }

  public Object visitIndexModel(IndexModel paramIndexModel)
  {
    return null;
  }

  public Object visitSelectTable(SelectTable paramSelectTable)
  {
    return null;
  }

  public Object visitCustomSql(CustomSql paramCustomSql)
  {
    return null;
  }

  public Object visitTableModel(TableModel paramTableModel)
  {
    return null;
  }

  public Object visitViewModel(ViewModel paramViewModel)
  {
    return null;
  }

  public Object visitParameterModel(ParameterModel paramParameterModel)
  {
    return null;
  }

  public Object visitProcedureModel(ProcedureModel paramProcedureModel)
  {
    return null;
  }

  public Object visitPageFieldModel(PageFieldModel paramPageFieldModel)
  {
    return null;
  }

  public Object visitPageElementModel(PageElementModel paramPageElementModel)
  {
    return null;
  }

  public Object visitXmlAttribute(XmlAttribute paramXmlAttribute)
  {
    return null;
  }

  public Object visitXmlNode(XmlNode paramXmlNode)
  {
    return null;
  }

  public Object visitRuleFlowActivitie(RuleFlowActivitie paramRuleFlowActivitie)
  {
    return null;
  }

  public Object visitRuleFlowTransition(RuleFlowTransition paramRuleFlowTransition)
  {
    return null;
  }

  public Object visitRuleSetFlow(RuleSetFlow paramRuleSetFlow)
  {
    return null;
  }

  public Object visitRuleTreeFlow(RuleTreeFlow paramRuleTreeFlow)
  {
    return null;
  }

  public Object visitRuleMirror(RuleMirror paramRuleMirror)
  {
    return null;
  }

  public Object visitEnumTable(EnumTable paramEnumTable)
  {
    return null;
  }

  public Object visitPackageHistory(PackageHistory paramPackageHistory)
  {
    return null;
  }

  public Object visitRuleHistory(RuleHistory paramRuleHistory)
  {
    return null;
  }

  public Object visitSheetFieldModel(SheetFieldModel paramSheetFieldModel)
  {
    return null;
  }

  public Object visitMapValue(MapValue paramMapValue)
  {
    return null;
  }

  public Object visitSheetTable(SheetTable paramSheetTable)
  {
    return null;
  }

  public Object visitSheetFunction(SheetFunction paramSheetFunction)
  {
    return null;
  }

  public Object visitSheetWhere(SheetWhere paramSheetWhere)
  {
    return null;
  }

  public Object visitSheetWheresSelectToken(SheetWheresSelectToken paramSheetWheresSelectToken)
  {
    return null;
  }

  public Object visitSheetAndFieldsSelectToken(SheetAndFieldsSelectToken paramSheetAndFieldsSelectToken)
  {
    return null;
  }

  public Object visitSheetFieldMapping(SheetFieldMapping paramSheetFieldMapping)
  {
    return null;
  }

  public Object visitSheetAndWheresSelectToken(SheetAndWheresSelectToken paramSheetAndWheresSelectToken)
  {
    return null;
  }

  public Object visitSheetFieldSelectToken(SheetFieldSelectToken paramSheetFieldSelectToken)
  {
    return null;
  }

  public Object visitExcelBookModel(ExcelBookModel paramExcelBookModel)
  {
    return null;
  }

  public Object visitExcelRowModel(ExcelRowModel paramExcelRowModel)
  {
    return null;
  }

  public Object visitExcelCellModel(ExcelCellModel paramExcelCellModel)
  {
    return null;
  }

  public Object visitExcelColModel(ExcelColModel paramExcelColModel)
  {
    return null;
  }

  public Object visitExcelSheetModel(ExcelSheetModel paramExcelSheetModel)
  {
    return null;
  }

  public Object visitExcelTableSheetModel(ExcelTableSheetModel paramExcelTableSheetModel)
  {
    return null;
  }

  public Object visitExcelXYSheetModel(ExcelXYSheetModel paramExcelXYSheetModel)
  {
    return null;
  }

  public Object visitSoapParameter(SoapParameter paramSoapParameter)
  {
    return null;
  }

  public Object visitSoapService(SoapService paramSoapService)
  {
    return null;
  }

  public Object visitExcuteRuleToken(ExcuteRuleToken paramExcuteRuleToken)
  {
    return null;
  }

  public Object visitLogRecordToken(LogRecordToken paramLogRecordToken)
  {
    return null;
  }

  public Object visitAjaxPage(AjaxPage paramAjaxPage)
  {
    return null;
  }

  public Object visitSheetDynamicSelectToken(SheetDynamicSelectToken paramSheetDynamicSelectToken)
  {
    return null;
  }

  public Object visitTreeAttribute(TreeAttribute paramTreeAttribute)
  {
    return null;
  }

  public Object visitTreeNode(TreeValueNode paramTreeValueNode)
  {
    return null;
  }

  public Object visitBOContainerGroup(BOContainerGroup paramBOContainerGroup)
  {
    return null;
  }

  public Object visitSheetMap(SheetMap paramSheetMap)
  {
    return null;
  }

  public Object visitSelectRulePackageToken(SelectRulePackageToken paramSelectRulePackageToken)
  {
    return null;
  }

  public Object visitPackageField(AbstractPackageField paramAbstractPackageField)
  {
    return null;
  }

  public Object visitSheetFentanMapping(SheetFentanMapping paramSheetFentanMapping)
  {
    return null;
  }

  public Object visitSheetFentanSelectToken(SheetFentanSelectToken paramSheetFentanSelectToken)
  {
    return null;
  }

  public Object visitRuleEnterToken(RuleEnterToken paramRuleEnterToken)
  {
    return null;
  }

  public Object visitInterfaceContainer(InterfaceContainer paramInterfaceContainer)
  {
    return null;
  }

  public Object visitDecisionRelateAction(DecisionRelateAction paramDecisionRelateAction)
  {
    return null;
  }

  public Object visitExeExpressionToken(ExeExpressionToken paramExeExpressionToken)
  {
    return null;
  }

  public Object visitExeDecisionToken(ExeDecisionToken paramExeDecisionToken)
  {
    return null;
  }

  public Object visitRulePoolFlow(RulePoolFlow paramRulePoolFlow)
  {
    return null;
  }

  public Object visitRulePoolNode(RulePoolNode paramRulePoolNode)
  {
    return null;
  }

  public Object visitRulePoolValue(RulePoolValue paramRulePoolValue)
  {
    return null;
  }

  public Object visitContainer(IRuleContainer paramIRuleContainer)
  {
    return null;
  }

  public Object visitSelector(ISelectorEditen paramISelectorEditen)
  {
    return null;
  }

  public Object visitCheckRuleInfo(CheckRuleInfo paramCheckRuleInfo)
  {
    return null;
  }

  public Object visitForEachConditionToken(ForEachConditionToken paramForEachConditionToken)
  {
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.a
 * JD-Core Version:    0.6.0
 */