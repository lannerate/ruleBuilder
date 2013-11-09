package com.flagleader.repository.e;

import com.flagleader.repository.IElement;
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
import com.flagleader.repository.db.SheetValue;
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
import com.flagleader.repository.rlm.action.PackCatchActionToken;
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
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.AdvancedProperty;
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
import com.flagleader.repository.tree.IEnvionment;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleTree;
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
import com.flagleader.xml.XmlWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

public class e extends XmlWriter
  implements RepositoryVisitor
{
  public static final String a = "displayName";
  public static final String b = "loadedClass";
  public static final String c = "dir";
  public static final String d = "className";
  public static final String e = "visible";
  public static final String f = "valueType";
  public static final String g = "modifyTime";
  public static final String h = "elementUuid";
  public static final String i = "uniqueName";
  public static final String j = "uuid";

  public e(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public e(Writer paramWriter)
  {
    super(paramWriter);
  }

  public e(File paramFile)
  {
    super(paramFile);
  }

  public static void a(RulePackage paramRulePackage, File paramFile)
  {
    File localFile = new File(paramFile.getParent(), paramFile.getName() + ".lck");
    e locale = new e(localFile);
    locale.a(paramRulePackage);
    locale.close();
    if (paramFile.exists())
      paramFile.delete();
    localFile.renameTo(paramFile);
  }

  public void a(IRulePackage paramIRulePackage)
  {
    printHeader();
    if (paramIRulePackage != null)
      paramIRulePackage.acceptVisitor(this);
    flush();
  }

  public static void a(IEnvionment paramIEnvionment, File paramFile)
  {
    File localFile = new File(paramFile.getParent(), paramFile.getName() + ".lck");
    e locale = new e(localFile);
    locale.a(paramIEnvionment);
    locale.close();
    if (paramFile.exists())
      paramFile.delete();
    localFile.renameTo(paramFile);
  }

  public void a(IEnvionment paramIEnvionment)
  {
    printHeader();
    if (paramIEnvionment != null)
      paramIEnvionment.acceptVisitor(this);
    flush();
  }

  public void a(TestCaseLib paramTestCaseLib)
  {
    printHeader();
    if (paramTestCaseLib != null)
      paramTestCaseLib.acceptVisitor(this);
    flush();
  }

  public static void a(IRuleTree paramIRuleTree, File paramFile)
  {
    File localFile = new File(paramFile.getParent(), paramFile.getName() + ".lck");
    e locale = new e(localFile);
    locale.a(paramIRuleTree);
    locale.close();
    if (paramFile.exists())
      paramFile.delete();
    localFile.renameTo(paramFile);
  }

  public void a(IRuleTree paramIRuleTree)
  {
    printHeader();
    String[] arrayOfString = { "displayName", paramIRuleTree.getDisplayName(), "packageName", "6" };
    openMarkerLn("RuleTemplate", arrayOfString);
    paramIRuleTree.acceptVisitor(this);
    closeMarkerLn("RuleTemplate");
    flush();
  }

  public static String b(IRulePackage paramIRulePackage)
  {
    StringWriter localStringWriter = new StringWriter();
    e locale = new e(new PrintWriter(localStringWriter));
    locale.a(paramIRulePackage);
    return localStringWriter.toString();
  }

  public static String b(IRuleTree paramIRuleTree)
  {
    StringWriter localStringWriter = new StringWriter();
    e locale = new e(new PrintWriter(localStringWriter));
    locale.a(paramIRuleTree);
    return localStringWriter.toString();
  }

  public static String a(Rule paramRule)
  {
    StringWriter localStringWriter = new StringWriter();
    e locale = new e(new PrintWriter(localStringWriter));
    locale.visitRule(paramRule);
    locale.flush();
    return localStringWriter.toString();
  }

  protected void a(IElement paramIElement)
  {
    Iterator localIterator = paramIElement.getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject == null) || (!(localObject instanceof IElement)))
        continue;
      ((IElement)localObject).acceptVisitor(this);
    }
  }

  public Object visitClassLibrary(ClassContainer paramClassContainer)
  {
    String[] arrayOfString = { "displayName", paramClassContainer.getDisplayName(), "uuid", paramClassContainer.getUuid(), "modifyTime", paramClassContainer.getModifyTime(), "multiType", paramClassContainer.getMultiType(), "loadType", paramClassContainer.getLoadType(), "nodeName", paramClassContainer.getNodeName() };
    openMarkerLn(paramClassContainer.getName(), arrayOfString);
    a(paramClassContainer);
    closeMarkerLn(paramClassContainer.getName());
    return null;
  }

  public Object visitInterfaceContainer(InterfaceContainer paramInterfaceContainer)
  {
    String[] arrayOfString = { "displayName", paramInterfaceContainer.getDisplayName(), "uuid", paramInterfaceContainer.getUuid(), "modifyTime", paramInterfaceContainer.getModifyTime(), "interfaceName", paramInterfaceContainer.getInterfaceName(), "initStatement", paramInterfaceContainer.getInitStatement(), "nodeName", paramInterfaceContainer.getNodeName() };
    openMarkerLn(paramInterfaceContainer.getName(), arrayOfString);
    a(paramInterfaceContainer);
    closeMarkerLn(paramInterfaceContainer.getName());
    return null;
  }

  public Object visitRule(Rule paramRule)
  {
    String[] arrayOfString = { "displayName", paramRule.getDisplayName(), "uuid", paramRule.getUuid(), "exceptionType", Integer.toString(paramRule.getExceptionType()), "actived", Boolean.toString(paramRule.isActived()), "errorMsg", paramRule.getErrorMsg(), "supportElse", String.valueOf(paramRule.isSupportElse()), "supportCatch", String.valueOf(paramRule.isSupportCatch()), "supportInit", String.valueOf(paramRule.isSupportInit()), "startTime", paramRule.getStartTime(), "endTime", paramRule.getEndTime(), "createTime", paramRule.getCreateTime(), "modifyTime", paramRule.getModifyTime(), "modifyUser", paramRule.getModifyUser(), "vml", paramRule.getVml(), "logtype", paramRule.getLogtype(), "sheetWhile", paramRule.isActiveSheetWhile(), "sheetUuid", paramRule.getSheetUuid(), "sheetName", paramRule.getSheetName(), "sheetOther", paramRule.getSheetOther(), "dataShap", paramRule.getDataShap(), "restartType", paramRule.getRestartType(), "vmlFlowType", paramRule.getVmlFlowType(), "supportEnter", paramRule.isSupportEnter(), "editTable", paramRule.isEditTable(), "syn", Boolean.toString(paramRule.isSyn()) };
    openMarkerLn(paramRule.getName(), arrayOfString);
    a(paramRule.getPropertiesList());
    a(paramRule);
    a(paramRule.getDocument());
    closeMarkerLn(paramRule.getName());
    return null;
  }

  public Object visitPackageHistory(PackageHistory paramPackageHistory)
  {
    String[] arrayOfString = { "visible", String.valueOf(paramPackageHistory.isVisible()) };
    openMarkerLn(paramPackageHistory.getName(), arrayOfString);
    a(paramPackageHistory);
    closeMarkerLn(paramPackageHistory.getName());
    return null;
  }

  public Object visitRuleHistory(RuleHistory paramRuleHistory)
  {
    String[] arrayOfString = { "displayName", paramRuleHistory.getDisplayName(), "uuid", paramRuleHistory.getUuid() };
    openMarkerLn(paramRuleHistory.getName(), arrayOfString);
    a(paramRuleHistory);
    closeMarkerLn(paramRuleHistory.getName());
    return null;
  }

  public Object visitDecisionRule(DecisionRule paramDecisionRule)
  {
    String[] arrayOfString = { "displayName", paramDecisionRule.getDisplayName(), "uuid", paramDecisionRule.getUuid(), "actived", paramDecisionRule.isActived(), "startTime", paramDecisionRule.getStartTime(), "endTime", paramDecisionRule.getEndTime(), "createTime", paramDecisionRule.getCreateTime(), "modifyTime", paramDecisionRule.getModifyTime(), "elementUuid", paramDecisionRule.getElementUuid(), "uniqueName", paramDecisionRule.getUniqueName(), "modifyUser", paramDecisionRule.getModifyUser(), "vml", paramDecisionRule.getVml(), "logtype", paramDecisionRule.getLogtype(), "sheetWhile", paramDecisionRule.isActiveSheetWhile(), "sheetUuid", paramDecisionRule.getSheetUuid(), "sheetName", paramDecisionRule.getSheetName(), "sheetOther", paramDecisionRule.getSheetOther(), "dataShap", paramDecisionRule.getDataShap(), "restartType", paramDecisionRule.getRestartType(), "matchType", paramDecisionRule.getMatchType(), "vmlFlowType", paramDecisionRule.getVmlFlowType(), "conditionNum", paramDecisionRule.getConditionNum(), "syn", Boolean.toString(paramDecisionRule.isSyn()) };
    openMarkerLn(paramDecisionRule.getName(), arrayOfString);
    a(paramDecisionRule.getPropertiesList());
    a(paramDecisionRule);
    a(paramDecisionRule.getDocument());
    closeMarkerLn(paramDecisionRule.getName());
    return null;
  }

  public Object visitDecisionValue(DecisionValue paramDecisionValue)
  {
    String[] arrayOfString = { "displayName", paramDecisionValue.getDisplayName(), "x", paramDecisionValue.getX(), "y", paramDecisionValue.getY(), "elementUuid", paramDecisionValue.getElementUuid(), "uniqueName", paramDecisionValue.getUniqueName(), "conditionUuids", paramDecisionValue.getConditionUuids() };
    openMarkerLn(paramDecisionValue.getName(), arrayOfString);
    a(paramDecisionValue);
    closeMarkerLn(paramDecisionValue.getName());
    return null;
  }

  public Object visitDecisionElement(DecisionElement paramDecisionElement)
  {
    String[] arrayOfString = { "elementUuid", paramDecisionElement.getElementUuid(), "uniqueName", paramDecisionElement.getUniqueName(), "pos", paramDecisionElement.getPos() };
    openMarkerLn(paramDecisionElement.getName(), arrayOfString);
    a(paramDecisionElement);
    closeMarkerLn(paramDecisionElement.getName());
    return null;
  }

  public Object visitDecisionElementValue(DecisionElementValue paramDecisionElementValue)
  {
    if (paramDecisionElementValue.isValid())
    {
      String[] arrayOfString = { "uuid", paramDecisionElementValue.getUuid(), "displayName", paramDecisionElementValue.getDisplayName(), "elementUuid", paramDecisionElementValue.getElementUuid(), "uniqueName", paramDecisionElementValue.getUniqueName(), "conditionUuids", paramDecisionElementValue.getConditionUuids() };
      openMarkerLn(paramDecisionElementValue.getName(), arrayOfString);
      a(paramDecisionElementValue);
      closeMarkerLn(paramDecisionElementValue.getName());
    }
    return null;
  }

  public Object visitDecisionRelateCondition(DecisionRelateCondition paramDecisionRelateCondition)
  {
    if (paramDecisionRelateCondition.isValid())
    {
      String[] arrayOfString = { "uuid", paramDecisionRelateCondition.getUuid(), "displayName", paramDecisionRelateCondition.getDisplayName(), "conditionUuids", paramDecisionRelateCondition.getConditionUuids(), "conditionPos", paramDecisionRelateCondition.getConditionPos() };
      openMarkerLn(paramDecisionRelateCondition.getName(), arrayOfString);
      a(paramDecisionRelateCondition);
      closeMarkerLn(paramDecisionRelateCondition.getName());
    }
    return null;
  }

  public Object visitDecisionMultiRule(DecisionMultiRule paramDecisionMultiRule)
  {
    String[] arrayOfString = { "displayName", paramDecisionMultiRule.getDisplayName(), "uuid", paramDecisionMultiRule.getUuid(), "actived", paramDecisionMultiRule.isActived(), "startTime", paramDecisionMultiRule.getStartTime(), "endTime", paramDecisionMultiRule.getEndTime(), "createTime", paramDecisionMultiRule.getCreateTime(), "modifyTime", paramDecisionMultiRule.getModifyTime(), "conditionNum", paramDecisionMultiRule.getConditionNum(), "valueNum", paramDecisionMultiRule.getValueNum(), "modifyUser", paramDecisionMultiRule.getModifyUser(), "vml", paramDecisionMultiRule.getVml(), "logtype", paramDecisionMultiRule.getLogtype(), "sheetWhile", paramDecisionMultiRule.isActiveSheetWhile(), "sheetUuid", paramDecisionMultiRule.getSheetUuid(), "sheetName", paramDecisionMultiRule.getSheetName(), "sheetOther", paramDecisionMultiRule.getSheetOther(), "dataShap", paramDecisionMultiRule.getDataShap(), "restartType", paramDecisionMultiRule.getRestartType(), "matchType", paramDecisionMultiRule.getMatchType(), "vmlFlowType", paramDecisionMultiRule.getVmlFlowType(), "syn", Boolean.toString(paramDecisionMultiRule.isSyn()) };
    openMarkerLn(paramDecisionMultiRule.getName(), arrayOfString);
    a(paramDecisionMultiRule.getPropertiesList());
    a(paramDecisionMultiRule);
    a(paramDecisionMultiRule.getDocument());
    closeMarkerLn(paramDecisionMultiRule.getName());
    return null;
  }

  public Object visitExpressionRule(ExpressionRule paramExpressionRule)
  {
    String[] arrayOfString = { "displayName", paramExpressionRule.getDisplayName(), "uuid", paramExpressionRule.getUuid(), "actived", paramExpressionRule.isActived(), "startTime", paramExpressionRule.getStartTime(), "endTime", paramExpressionRule.getEndTime(), "createTime", paramExpressionRule.getCreateTime(), "modifyTime", paramExpressionRule.getModifyTime(), "modifyUser", paramExpressionRule.getModifyUser(), "vml", paramExpressionRule.getVml(), "logtype", paramExpressionRule.getLogtype(), "sheetWhile", paramExpressionRule.isActiveSheetWhile(), "sheetUuid", paramExpressionRule.getSheetUuid(), "sheetName", paramExpressionRule.getSheetName(), "sheetOther", paramExpressionRule.getSheetOther(), "dataShap", paramExpressionRule.getDataShap(), "restartType", paramExpressionRule.getRestartType(), "matchType", paramExpressionRule.getMatchType(), "vmlFlowType", paramExpressionRule.getVmlFlowType(), "errorMsg", paramExpressionRule.getErrorMsg(), "expression", paramExpressionRule.getExpression(), "exceptionType", Integer.toString(paramExpressionRule.getExceptionType()), "syn", Boolean.toString(paramExpressionRule.isSyn()) };
    openMarkerLn(paramExpressionRule.getName(), arrayOfString);
    a(paramExpressionRule);
    a(paramExpressionRule.getDocument());
    closeMarkerLn(paramExpressionRule.getName());
    return null;
  }

  public Object visitDecisionRelateRule(DecisionRelateRule paramDecisionRelateRule)
  {
    String[] arrayOfString = { "displayName", paramDecisionRelateRule.getDisplayName(), "uuid", paramDecisionRelateRule.getUuid(), "actived", paramDecisionRelateRule.isActived(), "startTime", paramDecisionRelateRule.getStartTime(), "endTime", paramDecisionRelateRule.getEndTime(), "createTime", paramDecisionRelateRule.getCreateTime(), "modifyTime", paramDecisionRelateRule.getModifyTime(), "conditionNum", paramDecisionRelateRule.getConditionNum(), "valueNum", paramDecisionRelateRule.getValueNum(), "modifyUser", paramDecisionRelateRule.getModifyUser(), "vml", paramDecisionRelateRule.getVml(), "logtype", paramDecisionRelateRule.getLogtype(), "sheetWhile", paramDecisionRelateRule.isActiveSheetWhile(), "sheetUuid", paramDecisionRelateRule.getSheetUuid(), "sheetName", paramDecisionRelateRule.getSheetName(), "sheetOther", paramDecisionRelateRule.getSheetOther(), "dataShap", paramDecisionRelateRule.getDataShap(), "restartType", paramDecisionRelateRule.getRestartType(), "matchType", paramDecisionRelateRule.getMatchType(), "vmlFlowType", paramDecisionRelateRule.getVmlFlowType(), "syn", Boolean.toString(paramDecisionRelateRule.isSyn()) };
    openMarkerLn(paramDecisionRelateRule.getName(), arrayOfString);
    a(paramDecisionRelateRule.getPropertiesList());
    a(paramDecisionRelateRule);
    a(paramDecisionRelateRule.getDocument());
    closeMarkerLn(paramDecisionRelateRule.getName());
    return null;
  }

  public Object visitRulePackage(RulePackage paramRulePackage)
  {
    String[] arrayOfString = { "displayName", paramRulePackage.getDisplayName(), "uuid", paramRulePackage.getUuid(), "packageName", paramRulePackage.getPackageName(), "exportDir", paramRulePackage.getExportDir(), "fileName", paramRulePackage.getFileName(), "startTime", paramRulePackage.getStartTime(), "endTime", paramRulePackage.getEndTime(), "createTime", paramRulePackage.getCreateTime(), "modifyTime", paramRulePackage.getModifyTime(), "locked", paramRulePackage.getLocked(), "checkType", paramRulePackage.getCheckType(), "version", paramRulePackage.getVersion(), "mainVersion", paramRulePackage.getMainVersion(), "projver", paramRulePackage.getProjver(), "modifyUser", paramRulePackage.getModifyUser(), "stringignore", paramRulePackage.getStringignore(), "stringinit", paramRulePackage.getStringinit(), "datenulltype", paramRulePackage.getDatenulltype(), "rulesid", paramRulePackage.getRulesid(), "dbRules", paramRulePackage.isDbRules(), "edittype", paramRulePackage.getEdittype(), "logType", paramRulePackage.getLogType(), "ruleEditLevel", paramRulePackage.getRuleEditLevel(), "dblog", paramRulePackage.getDblog(), "fileVersion", paramRulePackage.getFileVersion(), "logTimes", paramRulePackage.getLogTimes(), "vmlFlowType", paramRulePackage.getVmlFlowType(), "templateType", paramRulePackage.getTemplateType(), "webrole", String.valueOf(paramRulePackage.getWebrole()), "document", paramRulePackage.getDocument(), "checktype", String.valueOf(paramRulePackage.getChecktype()) };
    openMarkerLn(paramRulePackage.getName(), arrayOfString);
    a(paramRulePackage.getPropertiesList());
    a(paramRulePackage);
    closeMarkerLn(paramRulePackage.getName());
    return null;
  }

  public Object visitRuleSet(RuleSet paramRuleSet)
  {
    String[] arrayOfString = { "displayName", paramRuleSet.getDisplayName(), "uuid", paramRuleSet.getUuid(), "editType", String.valueOf(paramRuleSet.getEditType()), "startTime", paramRuleSet.getStartTime(), "endTime", paramRuleSet.getEndTime(), "createTime", paramRuleSet.getCreateTime(), "modifyTime", paramRuleSet.getModifyTime(), "actived", Boolean.toString(paramRuleSet.isActived()), "modifyUser", paramRuleSet.getModifyUser(), "vml", paramRuleSet.getVml(), "logtype", paramRuleSet.getLogtype(), "sheetWhile", paramRuleSet.isActiveSheetWhile(), "sheetUuid", paramRuleSet.getSheetUuid(), "sheetName", paramRuleSet.getSheetName(), "sheetOther", paramRuleSet.getSheetOther(), "dataShap", paramRuleSet.getDataShap(), "vmlFlowType", paramRuleSet.getVmlFlowType(), "restartType", paramRuleSet.getRestartType(), "first", paramRuleSet.isFirst(), "supportCatch", String.valueOf(paramRuleSet.isSupportCatch()), "editTable", paramRuleSet.isEditTable(), "exceptionType", Integer.toString(paramRuleSet.getExceptionType()), "errorMsg", paramRuleSet.getErrorMsg(), "syn", Boolean.toString(paramRuleSet.isSyn()), "checktype", String.valueOf(paramRuleSet.getChecktype()) };
    openMarkerLn(paramRuleSet.getName(), arrayOfString);
    a(paramRuleSet.getPropertiesList());
    a(paramRuleSet);
    a(paramRuleSet.getDocument());
    closeMarkerLn(paramRuleSet.getName());
    return null;
  }

  public Object visitBusinessObjectClass(BusinessObjectClass paramBusinessObjectClass)
  {
    String[] arrayOfString = { "displayName", paramBusinessObjectClass.getDisplayName(), "uuid", paramBusinessObjectClass.getUuid(), "visible", paramBusinessObjectClass.isVisible() ? "true" : "false", "className", paramBusinessObjectClass.getClassName(), "valueType", paramBusinessObjectClass.getValueType(), "dir", paramBusinessObjectClass.getDir(), "groupName", paramBusinessObjectClass.getGroupName(), "shortClassName", paramBusinessObjectClass.getShortClassName() };
    openMarkerLn(paramBusinessObjectClass.getName(), arrayOfString);
    a(paramBusinessObjectClass);
    closeMarkerLn(paramBusinessObjectClass.getName());
    return null;
  }

  public Object visitRuleToken(RuleToken paramRuleToken)
  {
    String[] arrayOfString = { "uuid", paramRuleToken.getUuid() };
    openMarkerLn(paramRuleToken.getName(), arrayOfString);
    a(paramRuleToken);
    closeMarkerLn(paramRuleToken.getName());
    return null;
  }

  public Object visitElseIfRuleToken(ElseIfRuleToken paramElseIfRuleToken)
  {
    String[] arrayOfString = { "uuid", paramElseIfRuleToken.getUuid() };
    openMarkerLn(paramElseIfRuleToken.getName(), arrayOfString);
    a(paramElseIfRuleToken);
    closeMarkerLn(paramElseIfRuleToken.getName());
    return null;
  }

  public Object visitActionToken(StatementContainerToken paramStatementContainerToken)
  {
    openMarkerLn(paramStatementContainerToken.getName());
    a(paramStatementContainerToken);
    closeMarkerLn(paramStatementContainerToken.getName());
    return null;
  }

  public Object visitConditionToken(ConditionToken paramConditionToken)
  {
    String[] arrayOfString = { "uuid", paramConditionToken.getUuid(), "leftParenthesisNumber", Integer.toString(paramConditionToken.getLeftParenthesisNumber()), "rightParenthesisNumber", Integer.toString(paramConditionToken.getRightParenthesisNumber()), "opeType", String.valueOf(paramConditionToken.getOpeType()) };
    openMarkerLn(paramConditionToken.getName(), arrayOfString);
    a(paramConditionToken);
    closeMarkerLn(paramConditionToken.getName());
    return null;
  }

  public Object visitConstantToken(ConstantToken paramConstantToken)
  {
    String[] arrayOfString = { "valueType", paramConstantToken.getValueType(), "value", paramConstantToken.getValue() };
    openMarkerLn(paramConstantToken.getName(), arrayOfString);
    a(paramConstantToken);
    closeMarkerLn(paramConstantToken.getName());
    return null;
  }

  public Object visitJavaStatementToken(JavaStatementToken paramJavaStatementToken)
  {
    String[] arrayOfString = { "value", paramJavaStatementToken.getValue() };
    openMarkerLn(paramJavaStatementToken.getName(), arrayOfString);
    a(paramJavaStatementToken);
    closeMarkerLn(paramJavaStatementToken.getName());
    return null;
  }

  public Object visitFieldToken(FieldToken paramFieldToken)
  {
    String[] arrayOfString = { "elementUuid", paramFieldToken.getElementUuid(), "uniqueName", paramFieldToken.getUniqueName(), "valueType", paramFieldToken.getValueType(), "displayName", paramFieldToken.getDisplayName() };
    openMarkerLn(paramFieldToken.getName(), arrayOfString);
    a(paramFieldToken);
    closeMarkerLn(paramFieldToken.getName());
    return null;
  }

  public Object visitModifyToken(ModifyToken paramModifyToken)
  {
    return null;
  }

  public Object visitJudgeToken(JudgeToken paramJudgeToken)
  {
    String[] arrayOfString = { "type", Integer.toString(paramJudgeToken.getType()) };
    openMarkerLn(paramJudgeToken.getName(), arrayOfString);
    a(paramJudgeToken);
    closeMarkerLn(paramJudgeToken.getName());
    return null;
  }

  public Object visitValueToken(ValueToken paramValueToken)
  {
    String[] arrayOfString = { "valueType", paramValueToken.getValueType(), "displayName", paramValueToken.getDisplayName(), "argName", paramValueToken.getArgName(), "leftParenthesisNumber", Integer.toString(paramValueToken.getLeftParenthesisNumber()), "rightParenthesisNumber", Integer.toString(paramValueToken.getRightParenthesisNumber()) };
    openMarkerLn(paramValueToken.getName(), arrayOfString);
    a(paramValueToken);
    closeMarkerLn(paramValueToken.getName());
    return null;
  }

  public Object visitMethodToken(MethodToken paramMethodToken)
  {
    String[] arrayOfString = { "elementUuid", paramMethodToken.getElementUuid(), "uniqueName", paramMethodToken.getUniqueName(), "valueType", paramMethodToken.getValueType(), "displayName", paramMethodToken.getDisplayName() };
    openMarkerLn(paramMethodToken.getName(), arrayOfString);
    a(paramMethodToken);
    closeMarkerLn(paramMethodToken.getName());
    return null;
  }

  public Object visitBusinessObjectAttribute(BusinessObjectAttribute paramBusinessObjectAttribute)
  {
    String[] arrayOfString = { "displayName", paramBusinessObjectAttribute.getDisplayName(), "uuid", paramBusinessObjectAttribute.getUuid(), "memberName", paramBusinessObjectAttribute.getMemberName(), "visible", paramBusinessObjectAttribute.isVisible() ? "true" : "false", "valueType", paramBusinessObjectAttribute.getValueType(), "groupName", paramBusinessObjectAttribute.getGroupName(), "shortMemberName", paramBusinessObjectAttribute.getShortMemberName() };
    openMarkerLn(paramBusinessObjectAttribute.getName(), arrayOfString);
    a(paramBusinessObjectAttribute);
    closeMarkerLn(paramBusinessObjectAttribute.getName());
    return null;
  }

  private void a(MethodParam paramMethodParam)
  {
    String[] arrayOfString = { "typeName", paramMethodParam.getTypeName(), "paramName", paramMethodParam.getParamName(), "defaultValue", paramMethodParam.getDefaultValue() };
    openCloseMarkerLn("MethodParam", arrayOfString);
  }

  public Object visitBusinessObjectMethod(BusinessObjectMethod paramBusinessObjectMethod)
  {
    String[] arrayOfString = { "displayName", paramBusinessObjectMethod.getDisplayName(), "uuid", paramBusinessObjectMethod.getUuid(), "memberName", paramBusinessObjectMethod.getMemberName(), "visible", paramBusinessObjectMethod.isVisible() ? "true" : "false", "valueType", paramBusinessObjectMethod.getValueType(), "groupName", paramBusinessObjectMethod.getGroupName(), "shortMemberName", paramBusinessObjectMethod.getShortMemberName() };
    openMarkerLn(paramBusinessObjectMethod.getName(), arrayOfString);
    Iterator localIterator = paramBusinessObjectMethod.getParams().iterator();
    while (localIterator.hasNext())
      a((MethodParam)localIterator.next());
    a(paramBusinessObjectMethod);
    closeMarkerLn(paramBusinessObjectMethod.getName());
    return null;
  }

  public Object visitMemberToken(MemberToken paramMemberToken)
  {
    String[] arrayOfString = { "elementUuid", paramMemberToken.getElementUuid(), "uniqueName", paramMemberToken.getUniqueName(), "valueType", paramMemberToken.getValueType(), "displayName", paramMemberToken.getDisplayName() };
    openMarkerLn(paramMemberToken.getName(), arrayOfString);
    a(paramMemberToken);
    closeMarkerLn(paramMemberToken.getName());
    return null;
  }

  public Object visitSheetFieldsSelectToken(SheetFieldsSelectToken paramSheetFieldsSelectToken)
  {
    String[] arrayOfString = { "elementUuid", paramSheetFieldsSelectToken.getElementUuid(), "uniqueName", paramSheetFieldsSelectToken.getUniqueName(), "valueType", paramSheetFieldsSelectToken.getValueType(), "displayName", paramSheetFieldsSelectToken.getDisplayName(), "fieldUuids", paramSheetFieldsSelectToken.getFieldUuids(), "fieldNames", paramSheetFieldsSelectToken.getFieldNames() };
    openMarkerLn(paramSheetFieldsSelectToken.getName(), arrayOfString);
    a(paramSheetFieldsSelectToken);
    closeMarkerLn(paramSheetFieldsSelectToken.getName());
    return null;
  }

  public Object visitSheetFunctionsSelectToken(SheetFunctionsSelectToken paramSheetFunctionsSelectToken)
  {
    String[] arrayOfString = { "elementUuid", paramSheetFunctionsSelectToken.getElementUuid(), "uniqueName", paramSheetFunctionsSelectToken.getUniqueName(), "valueType", paramSheetFunctionsSelectToken.getValueType(), "displayName", paramSheetFunctionsSelectToken.getDisplayName() };
    openMarkerLn(paramSheetFunctionsSelectToken.getName(), arrayOfString);
    a(paramSheetFunctionsSelectToken);
    closeMarkerLn(paramSheetFunctionsSelectToken.getName());
    return null;
  }

  public Object visitSheetFunction(SheetFunction paramSheetFunction)
  {
    String[] arrayOfString = { "funcName", paramSheetFunction.getFuncName(), "fieldUuid", paramSheetFunction.getFieldUuid(), "fieldUnique", paramSheetFunction.getFieldUnique(), "asName", paramSheetFunction.getAsName(), "displayName", paramSheetFunction.getDisplayName() };
    openMarkerLn(paramSheetFunction.getName(), arrayOfString);
    a(paramSheetFunction);
    closeMarkerLn(paramSheetFunction.getName());
    return null;
  }

  public Object visitSheetWhere(SheetWhere paramSheetWhere)
  {
    String[] arrayOfString = { "funcName", paramSheetWhere.getFuncName(), "fieldUuid", paramSheetWhere.getFieldUuid(), "fieldUnique", paramSheetWhere.getFieldUnique(), "displayName", paramSheetWhere.getDisplayName(), "naryType", paramSheetWhere.getNaryType() };
    openMarkerLn(paramSheetWhere.getName(), arrayOfString);
    a(paramSheetWhere);
    closeMarkerLn(paramSheetWhere.getName());
    return null;
  }

  public Object visitSheetWheresSelectToken(SheetWheresSelectToken paramSheetWheresSelectToken)
  {
    String[] arrayOfString = { "elementUuid", paramSheetWheresSelectToken.getElementUuid(), "uniqueName", paramSheetWheresSelectToken.getUniqueName(), "valueType", paramSheetWheresSelectToken.getValueType(), "displayName", paramSheetWheresSelectToken.getDisplayName() };
    openMarkerLn(paramSheetWheresSelectToken.getName(), arrayOfString);
    a(paramSheetWheresSelectToken);
    closeMarkerLn(paramSheetWheresSelectToken.getName());
    return null;
  }

  public Object visitSheetFieldSelectToken(SheetFieldSelectToken paramSheetFieldSelectToken)
  {
    String[] arrayOfString = { "valueType", paramSheetFieldSelectToken.getValueType(), "fieldUuid", paramSheetFieldSelectToken.getFieldUuid(), "fieldUnique", paramSheetFieldSelectToken.getFieldUnique() };
    openMarkerLn(paramSheetFieldSelectToken.getName(), arrayOfString);
    a(paramSheetFieldSelectToken);
    closeMarkerLn(paramSheetFieldSelectToken.getName());
    return null;
  }

  public Object visitRulePoolValue(RulePoolValue paramRulePoolValue)
  {
    String[] arrayOfString = { "valueType", paramRulePoolValue.getValueType(), "fieldUuid", paramRulePoolValue.getFieldUuid(), "fieldUnique", paramRulePoolValue.getFieldUnique() };
    openMarkerLn(paramRulePoolValue.getName(), arrayOfString);
    a(paramRulePoolValue);
    closeMarkerLn(paramRulePoolValue.getName());
    return null;
  }

  public Object visitSheetAndFieldsSelectToken(SheetAndFieldsSelectToken paramSheetAndFieldsSelectToken)
  {
    String[] arrayOfString = { "elementUuid", paramSheetAndFieldsSelectToken.getElementUuid(), "uniqueName", paramSheetAndFieldsSelectToken.getUniqueName(), "valueType", paramSheetAndFieldsSelectToken.getValueType(), "sheetUuid", paramSheetAndFieldsSelectToken.getSheetUuid(), "sheetUnique", paramSheetAndFieldsSelectToken.getSheetUnique() };
    openMarkerLn(paramSheetAndFieldsSelectToken.getName(), arrayOfString);
    a(paramSheetAndFieldsSelectToken);
    closeMarkerLn(paramSheetAndFieldsSelectToken.getName());
    return null;
  }

  public Object visitSheetAndWheresSelectToken(SheetAndWheresSelectToken paramSheetAndWheresSelectToken)
  {
    String[] arrayOfString = { "elementUuid", paramSheetAndWheresSelectToken.getElementUuid(), "uniqueName", paramSheetAndWheresSelectToken.getUniqueName(), "valueType", paramSheetAndWheresSelectToken.getValueType(), "sheetUuid", paramSheetAndWheresSelectToken.getSheetUuid(), "sheetUnique", paramSheetAndWheresSelectToken.getSheetUnique() };
    openMarkerLn(paramSheetAndWheresSelectToken.getName(), arrayOfString);
    a(paramSheetAndWheresSelectToken);
    closeMarkerLn(paramSheetAndWheresSelectToken.getName());
    return null;
  }

  public Object visitSheetFieldMapping(SheetFieldMapping paramSheetFieldMapping)
  {
    String[] arrayOfString = { "mappingUuid", paramSheetFieldMapping.getMappingUuid(), "mappingUnique", paramSheetFieldMapping.getMappingUnique(), "fieldUuid", paramSheetFieldMapping.getFieldUuid(), "fieldUnique", paramSheetFieldMapping.getFieldUnique(), "mappingType", paramSheetFieldMapping.getMappingType() };
    openMarkerLn(paramSheetFieldMapping.getName(), arrayOfString);
    a(paramSheetFieldMapping);
    closeMarkerLn(paramSheetFieldMapping.getName());
    return null;
  }

  public Object visitConstantSelectToken(ConstantSelectToken paramConstantSelectToken)
  {
    String[] arrayOfString = { "elementUuid", paramConstantSelectToken.getElementUuid(), "uniqueName", paramConstantSelectToken.getUniqueName(), "valueType", paramConstantSelectToken.getValueType(), "displayName", paramConstantSelectToken.getDisplayName() };
    openMarkerLn(paramConstantSelectToken.getName(), arrayOfString);
    a(paramConstantSelectToken);
    closeMarkerLn(paramConstantSelectToken.getName());
    return null;
  }

  public Object visitAssignToken(AssignToken paramAssignToken)
  {
    openMarkerLn(paramAssignToken.getName());
    a(paramAssignToken);
    closeMarkerLn(paramAssignToken.getName());
    return null;
  }

  public Object visitNewToken(NewToken paramNewToken)
  {
    String[] arrayOfString = { "elementUuid", paramNewToken.getElementUuid(), "uniqueName", paramNewToken.getUniqueName(), "valueType", paramNewToken.getValueType(), "displayName", paramNewToken.getDisplayName() };
    openMarkerLn(paramNewToken.getName(), arrayOfString);
    a(paramNewToken);
    closeMarkerLn(paramNewToken.getName());
    return null;
  }

  public Object visitReturnToken(ReturnToken paramReturnToken)
  {
    String[] arrayOfString = { "returnType", String.valueOf(paramReturnToken.getReturnType()), "displayName", paramReturnToken.getDisplayName() };
    openMarkerLn(paramReturnToken.getName(), arrayOfString);
    a(paramReturnToken);
    closeMarkerLn(paramReturnToken.getName());
    return null;
  }

  public Object visitExeRuleToken(ExeRuleToken paramExeRuleToken)
  {
    String[] arrayOfString = { "returnType", String.valueOf(paramExeRuleToken.getReturnType()), "displayName", paramExeRuleToken.getDisplayName() };
    openMarkerLn(paramExeRuleToken.getName(), arrayOfString);
    a(paramExeRuleToken);
    closeMarkerLn(paramExeRuleToken.getName());
    return null;
  }

  public Object visitThrowToken(ThrowToken paramThrowToken)
  {
    String[] arrayOfString = { "displayName", paramThrowToken.getDisplayName() };
    openMarkerLn(paramThrowToken.getName(), arrayOfString);
    a(paramThrowToken);
    closeMarkerLn(paramThrowToken.getName());
    return null;
  }

  public Object visitDebugToken(DebugToken paramDebugToken)
  {
    String[] arrayOfString = { "displayName", paramDebugToken.getDisplayName() };
    openMarkerLn(paramDebugToken.getName(), arrayOfString);
    a(paramDebugToken);
    closeMarkerLn(paramDebugToken.getName());
    return null;
  }

  public Object visitClassToken(ClassToken paramClassToken)
  {
    String[] arrayOfString = { "elementUuid", paramClassToken.getElementUuid(), "uniqueName", paramClassToken.getUniqueName(), "valueType", paramClassToken.getValueType(), "displayName", paramClassToken.getDisplayName() };
    openMarkerLn(paramClassToken.getName(), arrayOfString);
    a(paramClassToken);
    closeMarkerLn(paramClassToken.getName());
    return null;
  }

  public Object visitFunctionMember(FunctionMember paramFunctionMember)
  {
    String[] arrayOfString = { "uuid", paramFunctionMember.getUuid(), "displayName", paramFunctionMember.getDisplayName(), "visible", paramFunctionMember.isVisible() ? "true" : "false" };
    openMarkerLn(paramFunctionMember.getName(), arrayOfString);
    openMarkerLn("txt");
    print(toXml(paramFunctionMember.getFunction()));
    closeMarkerLn("txt");
    closeMarkerLn(paramFunctionMember.getName());
    return null;
  }

  public Object visitTestCase(TestCase paramTestCase)
  {
    String[] arrayOfString = { "displayName", paramTestCase.getDisplayName(), "uuid", paramTestCase.getUuid(), "modifyTime", paramTestCase.getModifyTime() };
    openMarkerLn(paramTestCase.getName(), arrayOfString);
    a(paramTestCase);
    a(paramTestCase.getDocument());
    closeMarkerLn(paramTestCase.getName());
    return null;
  }

  public Object visitExportModel(ExportModel paramExportModel)
  {
    String[] arrayOfString = { "displayName", paramExportModel.getDisplayName(), "uuid", paramExportModel.getUuid(), "exportFile", paramExportModel.getExportFile(), "importFile", paramExportModel.getImportFile(), "value", paramExportModel.getValue(), "title", paramExportModel.getTitle(), "modifyTime", paramExportModel.getModifyTime() };
    openMarkerLn(paramExportModel.getName(), arrayOfString);
    openMarkerLn("modelStr");
    print(toXml(paramExportModel.getModelStr()));
    closeMarkerLn("modelStr");
    a(paramExportModel.getAdvanceProperties());
    a(paramExportModel);
    a(paramExportModel.getDocument());
    closeMarkerLn(paramExportModel.getName());
    return null;
  }

  public Object visitAjaxPage(AjaxPage paramAjaxPage)
  {
    String[] arrayOfString = { "displayName", paramAjaxPage.getDisplayName(), "uuid", paramAjaxPage.getUuid(), "exportFile", paramAjaxPage.getExportFile(), "importFile", paramAjaxPage.getImportFile(), "title", paramAjaxPage.getTitle(), "prefreName", paramAjaxPage.getPrefreName(), "modifyTime", paramAjaxPage.getModifyTime() };
    openMarkerLn(paramAjaxPage.getName(), arrayOfString);
    a(paramAjaxPage.getAdvanceProperties());
    a(paramAjaxPage);
    a(paramAjaxPage.getDocument());
    closeMarkerLn(paramAjaxPage.getName());
    return null;
  }

  public Object visitTestObjectInfo(TestObjectInfo paramTestObjectInfo)
  {
    String[] arrayOfString = { "className", paramTestObjectInfo.getClassName(), "attributeName", paramTestObjectInfo.getAttributeName(), "type", paramTestObjectInfo.getType(), "displayName", paramTestObjectInfo.getDisplayName(), "initialValue", paramTestObjectInfo.getInitialValue(), "expectValue", paramTestObjectInfo.getExpectValue() };
    openMarkerLn(paramTestObjectInfo.getName(), arrayOfString);
    closeMarkerLn(paramTestObjectInfo.getName());
    return null;
  }

  public Object visitTestCaseLib(TestCaseLib paramTestCaseLib)
  {
    String[] arrayOfString = { "displayName", paramTestCaseLib.getDisplayName(), "uuid", paramTestCaseLib.getUuid(), "modifyTime", paramTestCaseLib.getModifyTime(), "excelFile", paramTestCaseLib.getExcelFile(), "initValues", paramTestCaseLib.getInitValues(), "willValues", paramTestCaseLib.getWillValues(), "ruleSetName", paramTestCaseLib.getRuleSetName() };
    openMarkerLn(paramTestCaseLib.getName(), arrayOfString);
    a(paramTestCaseLib);
    a(paramTestCaseLib.getDocument());
    closeMarkerLn(paramTestCaseLib.getName());
    return null;
  }

  public Object visitConstantEnum(ConstantEnum paramConstantEnum)
  {
    String[] arrayOfString = { "displayName", paramConstantEnum.getDisplayName(), "uuid", paramConstantEnum.getUuid(), "value", paramConstantEnum.getValue(), "visible", paramConstantEnum.isVisible() ? "true" : "false", "groupName", paramConstantEnum.getGroupName(), "valueType", paramConstantEnum.getValueType() };
    openMarkerLn(paramConstantEnum.getName(), arrayOfString);
    a(paramConstantEnum);
    closeMarkerLn(paramConstantEnum.getName());
    return null;
  }

  public Object visitCustomFunction(CustomFunction paramCustomFunction)
  {
    String[] arrayOfString = { "displayName", paramCustomFunction.getDisplayName(), "uuid", paramCustomFunction.getUuid(), "modifyTime", paramCustomFunction.getModifyTime() };
    openMarkerLn(paramCustomFunction.getName(), arrayOfString);
    a(paramCustomFunction);
    closeMarkerLn(paramCustomFunction.getName());
    return null;
  }

  public Object visitEnumLibrary(EnumLibrary paramEnumLibrary)
  {
    String[] arrayOfString = { "displayName", paramEnumLibrary.getDisplayName(), "modifyTime", paramEnumLibrary.getModifyTime(), "uuid", paramEnumLibrary.getUuid() };
    openMarkerLn(paramEnumLibrary.getName(), arrayOfString);
    a(paramEnumLibrary);
    a(paramEnumLibrary.getDocument());
    closeMarkerLn(paramEnumLibrary.getName());
    return null;
  }

  public Object visitEnvionment(Envionment paramEnvionment)
  {
    String[] arrayOfString = { "displayName", paramEnvionment.getDisplayName(), "uuid", paramEnvionment.getUuid(), "modifyTime", paramEnvionment.getModifyTime(), "functionNum", String.valueOf(paramEnvionment.getFunctionNum()) };
    openMarkerLn(paramEnvionment.getName(), arrayOfString);
    for (int k = 0; k < paramEnvionment.getClassDirs().length; k++)
    {
      openMarkerLn("classDir");
      print(toXml(paramEnvionment.getClassDirs()[k]));
      closeMarkerLn("classDir");
    }
    a(paramEnvionment);
    a(paramEnvionment.getDocument());
    closeMarkerLn(paramEnvionment.getName());
    return null;
  }

  public Object visitFunctionLibrary(FunctionLibrary paramFunctionLibrary)
  {
    String[] arrayOfString = { "displayName", paramFunctionLibrary.getDisplayName(), "modifyTime", paramFunctionLibrary.getModifyTime(), "uuid", paramFunctionLibrary.getUuid() };
    openMarkerLn(paramFunctionLibrary.getName(), arrayOfString);
    a(paramFunctionLibrary);
    a(paramFunctionLibrary.getDocument());
    closeMarkerLn(paramFunctionLibrary.getName());
    return null;
  }

  public Object visitGotoRuleToken(GotoRuleToken paramGotoRuleToken)
  {
    String[] arrayOfString = { "elementUuid", paramGotoRuleToken.getElementUuid(), "uniqueName", paramGotoRuleToken.getUniqueName(), "displayName", paramGotoRuleToken.getDisplayName() };
    openMarkerLn(paramGotoRuleToken.getName(), arrayOfString);
    a(paramGotoRuleToken);
    closeMarkerLn(paramGotoRuleToken.getName());
    return null;
  }

  public Object visitMappingFunction(MappingFunction paramMappingFunction)
  {
    String[] arrayOfString = { "displayName", paramMappingFunction.getDisplayName(), "uuid", paramMappingFunction.getUuid(), "functionName", paramMappingFunction.getFunctionName(), "visible", paramMappingFunction.isVisible() ? "true" : "false", "valueType", paramMappingFunction.getValueType(), "groupName", paramMappingFunction.getGroupName() };
    openMarkerLn(paramMappingFunction.getName(), arrayOfString);
    Iterator localIterator = paramMappingFunction.getParams().iterator();
    while (localIterator.hasNext())
      a((MethodParam)localIterator.next());
    a(paramMappingFunction);
    closeMarkerLn(paramMappingFunction.getName());
    return null;
  }

  public Object visitMappingVariable(MappingVariable paramMappingVariable)
  {
    String[] arrayOfString = { "displayName", paramMappingVariable.getDisplayName(), "uuid", paramMappingVariable.getUuid(), "variableName", paramMappingVariable.getVariableName(), "visible", paramMappingVariable.isVisible() ? "true" : "false", "groupName", paramMappingVariable.getGroupName(), "valueType", paramMappingVariable.getValueType(), "inout", paramMappingVariable.getInout(), "loged", paramMappingVariable.isLoged(), "webhidden", String.valueOf(paramMappingVariable.isWebhidden()) };
    openMarkerLn(paramMappingVariable.getName(), arrayOfString);
    a(paramMappingVariable);
    closeMarkerLn(paramMappingVariable.getName());
    return null;
  }

  public Object visitMemberSelect(MemberToken.MemberSelector paramMemberSelector)
  {
    return null;
  }

  public Object visitTempVariable(TempVariable paramTempVariable)
  {
    String[] arrayOfString = { "displayName", paramTempVariable.getDisplayName(), "uuid", paramTempVariable.getUuid(), "variableName", paramTempVariable.getVariableName(), "visible", paramTempVariable.isVisible() ? "true" : "false", "groupName", paramTempVariable.getGroupName(), "valueType", paramTempVariable.getValueType(), "loged", paramTempVariable.isLoged() };
    openMarkerLn(paramTempVariable.getName(), arrayOfString);
    a(paramTempVariable);
    closeMarkerLn(paramTempVariable.getName());
    return null;
  }

  public Object visitValueLibrary(ValueLibrary paramValueLibrary)
  {
    String[] arrayOfString = { "displayName", paramValueLibrary.getDisplayName(), "modifyTime", paramValueLibrary.getModifyTime(), "uuid", paramValueLibrary.getUuid() };
    openMarkerLn(paramValueLibrary.getName(), arrayOfString);
    a(paramValueLibrary);
    a(paramValueLibrary.getDocument());
    closeMarkerLn(paramValueLibrary.getName());
    return null;
  }

  public Object visitVariableLibrary(VariableLibrary paramVariableLibrary)
  {
    String[] arrayOfString = { "displayName", paramVariableLibrary.getDisplayName(), "modifyTime", paramVariableLibrary.getModifyTime(), "uuid", paramVariableLibrary.getUuid() };
    openMarkerLn(paramVariableLibrary.getName(), arrayOfString);
    a(paramVariableLibrary);
    a(paramVariableLibrary.getDocument());
    closeMarkerLn(paramVariableLibrary.getName());
    return null;
  }

  public Object visitStaticText(StaticTextToken paramStaticTextToken)
  {
    String[] arrayOfString = { "displayName", paramStaticTextToken.getDisplayName(), "colorType", paramStaticTextToken.getColorType() };
    openMarkerLn(paramStaticTextToken.getName(), arrayOfString);
    a(paramStaticTextToken);
    closeMarkerLn(paramStaticTextToken.getName());
    return null;
  }

  public Object visitElementTextToken(ElementTextToken paramElementTextToken)
  {
    String[] arrayOfString = { "displayName", paramElementTextToken.getDisplayName(), "colorType", paramElementTextToken.getColorType(), "pos", paramElementTextToken.getPos(), "elementUuid", paramElementTextToken.getElementUuid(), "uniqueName", paramElementTextToken.getUniqueName() };
    openMarkerLn(paramElementTextToken.getName(), arrayOfString);
    a(paramElementTextToken);
    closeMarkerLn(paramElementTextToken.getName());
    return null;
  }

  public Object visitSubFunction(AbstractSubFunction paramAbstractSubFunction)
  {
    String[] arrayOfString = { "displayName", paramAbstractSubFunction.getDisplayName(), "uuid", paramAbstractSubFunction.getUuid(), "valueName", paramAbstractSubFunction.getValueName(), "visible", paramAbstractSubFunction.isVisible() ? "true" : "false", "valueType", paramAbstractSubFunction.getValueType(), "variableName", paramAbstractSubFunction.getVariableName(), "varPre", paramAbstractSubFunction.getVarPre(), "groupName", paramAbstractSubFunction.getGroupName() };
    openMarkerLn(paramAbstractSubFunction.getName(), arrayOfString);
    Iterator localIterator = paramAbstractSubFunction.getParams().iterator();
    while (localIterator.hasNext())
      a((MethodParam)localIterator.next());
    a(paramAbstractSubFunction);
    closeMarkerLn(paramAbstractSubFunction.getName());
    return null;
  }

  public Object visitGlobalFunction(GlobalFunction paramGlobalFunction)
  {
    String[] arrayOfString = { "displayName", paramGlobalFunction.getDisplayName(), "uuid", paramGlobalFunction.getUuid(), "valueName", paramGlobalFunction.getValueName(), "visible", paramGlobalFunction.isVisible() ? "true" : "false", "valueType", paramGlobalFunction.getValueType(), "variableName", paramGlobalFunction.getVariableName(), "groupName", paramGlobalFunction.getGroupName() };
    openMarkerLn(paramGlobalFunction.getName(), arrayOfString);
    Iterator localIterator = paramGlobalFunction.getParams().iterator();
    while (localIterator.hasNext())
      a((MethodParam)localIterator.next());
    a(paramGlobalFunction);
    closeMarkerLn(paramGlobalFunction.getName());
    return null;
  }

  public Object visitSubVariable(AbstractSubVariable paramAbstractSubVariable)
  {
    String[] arrayOfString = { "displayName", paramAbstractSubVariable.getDisplayName(), "uuid", paramAbstractSubVariable.getUuid(), "valueName", paramAbstractSubVariable.getValueName(), "visible", paramAbstractSubVariable.isVisible() ? "true" : "false", "valueType", paramAbstractSubVariable.getValueType(), "variableName", paramAbstractSubVariable.getVariableName(), "varPre", paramAbstractSubVariable.getVarPre(), "groupName", paramAbstractSubVariable.getGroupName() };
    openMarkerLn(paramAbstractSubVariable.getName(), arrayOfString);
    Iterator localIterator = paramAbstractSubVariable.getParams().iterator();
    while (localIterator.hasNext())
      a((MethodParam)localIterator.next());
    a(paramAbstractSubVariable);
    closeMarkerLn(paramAbstractSubVariable.getName());
    return null;
  }

  public Object visitMultiActionToken(MultiActionToken paramMultiActionToken)
  {
    if (((paramMultiActionToken instanceof PackCatchActionToken)) && (((PackCatchActionToken)paramMultiActionToken).isEmpty()))
      return null;
    String[] arrayOfString = { "uuid", paramMultiActionToken.getUuid(), "type", paramMultiActionToken.getType() };
    openMarkerLn(paramMultiActionToken.getName(), arrayOfString);
    a(paramMultiActionToken);
    closeMarkerLn(paramMultiActionToken.getName());
    return null;
  }

  public Object visitMultiConditionToken(MultiConditionToken paramMultiConditionToken)
  {
    String[] arrayOfString = { "uuid", paramMultiConditionToken.getUuid(), "type", paramMultiConditionToken.getType() };
    openMarkerLn(paramMultiConditionToken.getName(), arrayOfString);
    a(paramMultiConditionToken);
    closeMarkerLn(paramMultiConditionToken.getName());
    return null;
  }

  public Object visitRuleSetToken(RuleSetToken paramRuleSetToken)
  {
    String[] arrayOfString = { "uuid", paramRuleSetToken.getUuid() };
    openMarkerLn(paramRuleSetToken.getName(), arrayOfString);
    a(paramRuleSetToken);
    closeMarkerLn(paramRuleSetToken.getName());
    return null;
  }

  public Object visitDBModel(DBModel paramDBModel)
  {
    String[] arrayOfString = { "displayName", paramDBModel.getDisplayName(), "uuid", paramDBModel.getUuid(), "url", paramDBModel.getUrl(), "driver", paramDBModel.getDriver(), "userName", paramDBModel.getUserName(), "encryptedPasswd", paramDBModel.getEncryptedPasswd(), "datasourceName", paramDBModel.getDatasourceName(), "catalogName", paramDBModel.getCatalogName(), "schemaName", paramDBModel.getSchemaName(), "connType", String.valueOf(paramDBModel.getConnType()), "varName", paramDBModel.getVarName(), "modifyTime", paramDBModel.getModifyTime(), "dbFilePath", paramDBModel.getDbFilePath(), "vml", paramDBModel.getVml(), "transationlevel", paramDBModel.getTransationlevel() };
    openMarkerLn(paramDBModel.getName(), arrayOfString);
    a(paramDBModel);
    a(paramDBModel.getDocument());
    closeMarkerLn(paramDBModel.getName());
    return null;
  }

  public Object visitFieldModel(FieldModel paramFieldModel)
  {
    String[] arrayOfString = { "displayName", paramFieldModel.getDisplayName(), "uuid", paramFieldModel.getUuid(), "fieldName", paramFieldModel.getFieldName(), "fieldType", paramFieldModel.getFieldType(), "valueType", paramFieldModel.getValueType(), "classType", paramFieldModel.getClassType(), "len", paramFieldModel.getLen(), "unNull", paramFieldModel.isUnNull() ? "true" : "false", "readOnly", paramFieldModel.isReadOnly() ? "true" : "false", "autoIncrement", paramFieldModel.isAutoIncrement() ? "true" : "false", "searchable", paramFieldModel.isSearchable() ? "true" : "false", "caseSensitive", paramFieldModel.isCaseSensitive() ? "true" : "false", "currency", paramFieldModel.isCurrency() ? "true" : "false", "signed", paramFieldModel.isSigned() ? "true" : "false", "primaryKey", paramFieldModel.isPrimaryKey() ? "true" : "false", "friendKey", paramFieldModel.isFriendKey() ? "true" : "false", "iType", paramFieldModel.getIType(), "defaultType", paramFieldModel.getDefaultType() };
    openMarkerLn(paramFieldModel.getName(), arrayOfString);
    a(paramFieldModel.getAdvanceProperties());
    a(paramFieldModel);
    a(paramFieldModel.getDocument());
    closeMarkerLn(paramFieldModel.getName());
    return null;
  }

  public Object visitSheetFieldModel(SheetFieldModel paramSheetFieldModel)
  {
    String[] arrayOfString = { "displayName", paramSheetFieldModel.getDisplayName(), "fieldName", paramSheetFieldModel.getFieldName(), "uuid", paramSheetFieldModel.getUuid(), "visible", paramSheetFieldModel.isVisible() ? "true" : "false", "valueType", paramSheetFieldModel.getValueType(), "groupName", paramSheetFieldModel.getGroupName(), "loged", paramSheetFieldModel.isLoged() };
    openMarkerLn(paramSheetFieldModel.getName(), arrayOfString);
    a(paramSheetFieldModel);
    closeMarkerLn(paramSheetFieldModel.getName());
    return null;
  }

  public Object visitMapValue(MapValue paramMapValue)
  {
    String[] arrayOfString = { "displayName", paramMapValue.getDisplayName(), "key", paramMapValue.getKey(), "uuid", paramMapValue.getUuid(), "visible", paramMapValue.isVisible() ? "true" : "false", "valueType", paramMapValue.getValueType(), "groupName", paramMapValue.getGroupName(), "value", paramMapValue.getValue(), "loged", paramMapValue.isLoged() };
    openMarkerLn(paramMapValue.getName(), arrayOfString);
    a(paramMapValue);
    closeMarkerLn(paramMapValue.getName());
    return null;
  }

  public Object visitPageFieldModel(PageFieldModel paramPageFieldModel)
  {
    String[] arrayOfString = { "displayName", paramPageFieldModel.getDisplayName(), "variableName", paramPageFieldModel.getVariableName(), "valueType", paramPageFieldModel.getValueType(), "nullType", paramPageFieldModel.getNullType(), "len", paramPageFieldModel.getLen(), "inputType", paramPageFieldModel.getInputType(), "resultType", paramPageFieldModel.getResultType(), "statType", paramPageFieldModel.getStatType(), "defaultValue", paramPageFieldModel.getDefaultValue(), "inputValueType", paramPageFieldModel.getInputValueType(), "showValue", paramPageFieldModel.getShowValue(), "valueFrom", paramPageFieldModel.getValueFrom() };
    openMarkerLn(paramPageFieldModel.getName(), arrayOfString);
    a(paramPageFieldModel.getAdvanceProperties());
    a(paramPageFieldModel);
    closeMarkerLn(paramPageFieldModel.getName());
    return null;
  }

  public Object visitPageElementModel(PageElementModel paramPageElementModel)
  {
    String[] arrayOfString = { "displayName", paramPageElementModel.getDisplayName(), "elementName", paramPageElementModel.getElementName(), "elementType", paramPageElementModel.getElementType() };
    openMarkerLn(paramPageElementModel.getName(), arrayOfString);
    a(paramPageElementModel.getAdvanceProperties());
    a(paramPageElementModel);
    closeMarkerLn(paramPageElementModel.getName());
    return null;
  }

  private void a(AdvancedProperty[] paramArrayOfAdvancedProperty)
  {
    for (int k = 0; k < paramArrayOfAdvancedProperty.length; k++)
    {
      String[] arrayOfString = { "key", paramArrayOfAdvancedProperty[k].getKey(), "property", paramArrayOfAdvancedProperty[k].getProperty() };
      openCloseMarkerLn("advancedProperty", arrayOfString);
    }
  }

  private void a(List paramList)
  {
    for (int k = 0; k < paramList.size(); k++)
    {
      String[] arrayOfString = { "key", ((AdvancedProperty)paramList.get(k)).getKey(), "property", ((AdvancedProperty)paramList.get(k)).getProperty() };
      openCloseMarkerLn("advancedProperty", arrayOfString);
    }
  }

  private void b(List paramList)
  {
    for (int k = 0; k < paramList.size(); k++)
    {
      String[] arrayOfString = { "value", ((SheetValue)paramList.get(k)).getValue() };
      openCloseMarkerLn("SheetValue", arrayOfString);
    }
  }

  private void c(List paramList)
  {
    for (int k = 0; k < paramList.size(); k++)
    {
      String[] arrayOfString = { "value", ((MapValue)paramList.get(k)).getValue(), "key", ((MapValue)paramList.get(k)).getKey() };
      openCloseMarkerLn("MapValue", arrayOfString);
    }
  }

  private void a(String paramString)
  {
    openMarkerLn("doc");
    print(toXml(paramString));
    closeMarkerLn("doc");
  }

  public Object visitFKModel(FKModel paramFKModel)
  {
    String[] arrayOfString = { "displayName", paramFKModel.getDisplayName(), "pkTableName", paramFKModel.getPkTableName(), "pkType", paramFKModel.getPkType(), "FKTableName", paramFKModel.getFKTableName(), "fkType", paramFKModel.getFkType(), "FKName", paramFKModel.getFKName(), "PKName", paramFKModel.getPKName(), "defaultValue", paramFKModel.getDefaultValue(), "updateRule", paramFKModel.getUpdateRule(), "deleteRule", paramFKModel.getDeleteRule() };
    openMarkerLn(paramFKModel.getName(), arrayOfString);
    a(paramFKModel.getKeys());
    a(paramFKModel);
    closeMarkerLn(paramFKModel.getName());
    return null;
  }

  public Object visitIndexModel(IndexModel paramIndexModel)
  {
    String[] arrayOfString = { "displayName", paramIndexModel.getDisplayName(), "indexName", paramIndexModel.getIndexName(), "unique", paramIndexModel.isUnique() ? "true" : "false" };
    openMarkerLn(paramIndexModel.getName(), arrayOfString);
    a(paramIndexModel);
    closeMarkerLn(paramIndexModel.getName());
    return null;
  }

  public Object visitSelectTable(SelectTable paramSelectTable)
  {
    String[] arrayOfString = { "uuid", paramSelectTable.getUuid(), "displayName", paramSelectTable.getDisplayName(), "sqlSelect", paramSelectTable.getSqlSelect(), "englishName", paramSelectTable.getEnglishName(), "resultType", String.valueOf(paramSelectTable.getResultType()), "afterCommit", String.valueOf(paramSelectTable.isAfterCommit()), "modifyTime", paramSelectTable.getModifyTime(), "vml", paramSelectTable.getVml() };
    openMarkerLn(paramSelectTable.getName(), arrayOfString);
    a(paramSelectTable);
    a(paramSelectTable.getDocument());
    closeMarkerLn(paramSelectTable.getName());
    return null;
  }

  public Object visitSheetTable(SheetTable paramSheetTable)
  {
    String[] arrayOfString = { "uuid", paramSheetTable.getUuid(), "displayName", paramSheetTable.getDisplayName(), "sqlSelect", paramSheetTable.getSqlSelect(), "englishName", paramSheetTable.getEnglishName(), "modifyTime", paramSheetTable.getModifyTime(), "vml", paramSheetTable.getVml(), "excelFile", paramSheetTable.getExcelFile(), "testFile", paramSheetTable.getTestFile(), "saveValue", paramSheetTable.isSaveValue(), "linkList", paramSheetTable.isLinkList(), "fromResource", paramSheetTable.isFromResource(), "matchFields", paramSheetTable.getMatchFields(), "nullDefault", paramSheetTable.getNullDefault(), "shareType", paramSheetTable.getShareType(), "fromDB", paramSheetTable.isFromDB(), "sqlScript", paramSheetTable.getSqlScript(), "updateinternal", paramSheetTable.getUpdateinternal(), "inout", paramSheetTable.getInout() };
    openMarkerLn(paramSheetTable.getName(), arrayOfString);
    if (paramSheetTable.isSaveValue())
      b(paramSheetTable.getSheetValues());
    a(paramSheetTable);
    a(paramSheetTable.getDocument());
    closeMarkerLn(paramSheetTable.getName());
    return null;
  }

  public Object visitExcelBookModel(ExcelBookModel paramExcelBookModel)
  {
    String[] arrayOfString = { "uuid", paramExcelBookModel.getUuid(), "displayName", paramExcelBookModel.getDisplayName(), "bookName", paramExcelBookModel.getBookName(), "xlsFile", paramExcelBookModel.getXlsFile(), "modifyTime", paramExcelBookModel.getModifyTime(), "vml", paramExcelBookModel.getVml(), "modelFile", paramExcelBookModel.getModelFile() };
    openMarkerLn(paramExcelBookModel.getName(), arrayOfString);
    a(paramExcelBookModel);
    a(paramExcelBookModel.getDocument());
    closeMarkerLn(paramExcelBookModel.getName());
    return null;
  }

  public Object visitExcelRowModel(ExcelRowModel paramExcelRowModel)
  {
    String[] arrayOfString = { "uuid", paramExcelRowModel.getUuid(), "displayName", paramExcelRowModel.getDisplayName(), "fieldPos", String.valueOf(paramExcelRowModel.getFieldPos()), "valueType", paramExcelRowModel.getValueType(), "visible", paramExcelRowModel.isVisible() ? "true" : "false", "groupName", paramExcelRowModel.getGroupName() };
    openMarkerLn(paramExcelRowModel.getName(), arrayOfString);
    a(paramExcelRowModel);
    closeMarkerLn(paramExcelRowModel.getName());
    return null;
  }

  public Object visitExcelCellModel(ExcelCellModel paramExcelCellModel)
  {
    String[] arrayOfString = { "uuid", paramExcelCellModel.getUuid(), "displayName", paramExcelCellModel.getDisplayName(), "fieldPos", String.valueOf(paramExcelCellModel.getFieldPos()), "valueType", paramExcelCellModel.getValueType(), "visible", paramExcelCellModel.isVisible() ? "true" : "false", "groupName", paramExcelCellModel.getGroupName() };
    openMarkerLn(paramExcelCellModel.getName(), arrayOfString);
    a(paramExcelCellModel);
    closeMarkerLn(paramExcelCellModel.getName());
    return null;
  }

  public Object visitExcelColModel(ExcelColModel paramExcelColModel)
  {
    String[] arrayOfString = { "uuid", paramExcelColModel.getUuid(), "displayName", paramExcelColModel.getDisplayName(), "fieldPos", String.valueOf(paramExcelColModel.getFieldPos()), "valueType", paramExcelColModel.getValueType(), "visible", paramExcelColModel.isVisible() ? "true" : "false", "groupName", paramExcelColModel.getGroupName() };
    openMarkerLn(paramExcelColModel.getName(), arrayOfString);
    a(paramExcelColModel);
    closeMarkerLn(paramExcelColModel.getName());
    return null;
  }

  public Object visitExcelSheetModel(ExcelSheetModel paramExcelSheetModel)
  {
    String[] arrayOfString = { "uuid", paramExcelSheetModel.getUuid(), "displayName", paramExcelSheetModel.getDisplayName(), "sheetName", paramExcelSheetModel.getSheetName(), "sheetReg", paramExcelSheetModel.getSheetReg(), "modelName", paramExcelSheetModel.getModelName(), "modifyTime", paramExcelSheetModel.getModifyTime(), "vml", paramExcelSheetModel.getVml(), "showBorder", String.valueOf(paramExcelSheetModel.isShowBorder()), "mergeValue", String.valueOf(paramExcelSheetModel.isMergeValue()) };
    openMarkerLn(paramExcelSheetModel.getName(), arrayOfString);
    a(paramExcelSheetModel);
    a(paramExcelSheetModel.getDocument());
    closeMarkerLn(paramExcelSheetModel.getName());
    return null;
  }

  public Object visitExcelTableSheetModel(ExcelTableSheetModel paramExcelTableSheetModel)
  {
    String[] arrayOfString = { "uuid", paramExcelTableSheetModel.getUuid(), "displayName", paramExcelTableSheetModel.getDisplayName(), "sheetName", paramExcelTableSheetModel.getSheetName(), "sheetReg", paramExcelTableSheetModel.getSheetReg(), "modelName", paramExcelTableSheetModel.getModelName(), "modifyTime", paramExcelTableSheetModel.getModifyTime(), "vml", paramExcelTableSheetModel.getVml(), "colNameLine", String.valueOf(paramExcelTableSheetModel.getColNameLine()), "startRowLine", String.valueOf(paramExcelTableSheetModel.getStartRowLine()), "startCol", String.valueOf(paramExcelTableSheetModel.getStartCol()), "rowAmountLine", String.valueOf(paramExcelTableSheetModel.getRowAmountLine()), "acceptEmpty", String.valueOf(paramExcelTableSheetModel.getAcceptEmpty()), "mergeSame", String.valueOf(paramExcelTableSheetModel.isMergeSame()), "showBorder", String.valueOf(paramExcelTableSheetModel.isShowBorder()), "mergeValue", String.valueOf(paramExcelTableSheetModel.isMergeValue()) };
    openMarkerLn(paramExcelTableSheetModel.getName(), arrayOfString);
    a(paramExcelTableSheetModel);
    a(paramExcelTableSheetModel.getDocument());
    closeMarkerLn(paramExcelTableSheetModel.getName());
    return null;
  }

  public Object visitExcelXYSheetModel(ExcelXYSheetModel paramExcelXYSheetModel)
  {
    String[] arrayOfString = { "uuid", paramExcelXYSheetModel.getUuid(), "displayName", paramExcelXYSheetModel.getDisplayName(), "sheetName", paramExcelXYSheetModel.getSheetName(), "sheetReg", paramExcelXYSheetModel.getSheetReg(), "modelName", paramExcelXYSheetModel.getModelName(), "modifyTime", paramExcelXYSheetModel.getModifyTime(), "vml", paramExcelXYSheetModel.getVml(), "colNameLine", String.valueOf(paramExcelXYSheetModel.getColNameLine()), "startRowLine", String.valueOf(paramExcelXYSheetModel.getStartRowLine()), "startCol", String.valueOf(paramExcelXYSheetModel.getStartCol()), "rowNameLine", String.valueOf(paramExcelXYSheetModel.getRowNameLine()), "colAmountLine", String.valueOf(paramExcelXYSheetModel.getColAmountLine()), "rowAmountLine", String.valueOf(paramExcelXYSheetModel.getRowAmountLine()), "rowType", String.valueOf(paramExcelXYSheetModel.getRowType()), "colType", String.valueOf(paramExcelXYSheetModel.getColType()), "cellType", String.valueOf(paramExcelXYSheetModel.getCellType()), "emptycol", String.valueOf(paramExcelXYSheetModel.getEmptycol()), "changedType", String.valueOf(paramExcelXYSheetModel.getChangedType()), "showBorder", String.valueOf(paramExcelXYSheetModel.isShowBorder()), "mergeValue", String.valueOf(paramExcelXYSheetModel.isMergeValue()) };
    openMarkerLn(paramExcelXYSheetModel.getName(), arrayOfString);
    a(paramExcelXYSheetModel);
    a(paramExcelXYSheetModel.getDocument());
    closeMarkerLn(paramExcelXYSheetModel.getName());
    return null;
  }

  public Object visitEnumTable(EnumTable paramEnumTable)
  {
    String[] arrayOfString = { "uuid", paramEnumTable.getUuid(), "displayName", paramEnumTable.getDisplayName(), "sqlSelect", paramEnumTable.getSqlSelect(), "enumType", paramEnumTable.getEnumType(), "modifyTime", paramEnumTable.getModifyTime(), "vml", paramEnumTable.getVml() };
    openMarkerLn(paramEnumTable.getName(), arrayOfString);
    a(paramEnumTable);
    a(paramEnumTable.getDocument());
    closeMarkerLn(paramEnumTable.getName());
    return null;
  }

  public Object visitCustomSql(CustomSql paramCustomSql)
  {
    String[] arrayOfString = { "uuid", paramCustomSql.getUuid(), "displayName", paramCustomSql.getDisplayName(), "sqlCustom", paramCustomSql.getSqlCustom(), "valueType", paramCustomSql.getValueType(), "modifyTime", paramCustomSql.getModifyTime(), "vml", paramCustomSql.getVml() };
    openMarkerLn(paramCustomSql.getName(), arrayOfString);
    a(paramCustomSql);
    a(paramCustomSql.getDocument());
    closeMarkerLn(paramCustomSql.getName());
    return null;
  }

  public Object visitParameterModel(ParameterModel paramParameterModel)
  {
    String[] arrayOfString = { "displayName", paramParameterModel.getDisplayName(), "fieldType", paramParameterModel.getFieldType(), "valueType", paramParameterModel.getValueType(), "classType", paramParameterModel.getClassType(), "signed", paramParameterModel.isSigned() ? "true" : "false", "iType", paramParameterModel.getIType(), "pos", paramParameterModel.getPos(), "modetype", paramParameterModel.getModetype() };
    openMarkerLn(paramParameterModel.getName(), arrayOfString);
    a(paramParameterModel.getAdvanceProperties());
    a(paramParameterModel);
    closeMarkerLn(paramParameterModel.getName());
    return null;
  }

  public Object visitProcedureModel(ProcedureModel paramProcedureModel)
  {
    String[] arrayOfString = { "uuid", paramProcedureModel.getUuid(), "displayName", paramProcedureModel.getDisplayName(), "sqlSelect", paramProcedureModel.getSqlSelect(), "englishName", paramProcedureModel.getEnglishName(), "resultType", String.valueOf(paramProcedureModel.getResultType()), "modifyTime", paramProcedureModel.getModifyTime() };
    openMarkerLn(paramProcedureModel.getName(), arrayOfString);
    a(paramProcedureModel);
    a(paramProcedureModel.getDocument());
    closeMarkerLn(paramProcedureModel.getName());
    return null;
  }

  public Object visitTableModel(TableModel paramTableModel)
  {
    String[] arrayOfString = { "uuid", paramTableModel.getUuid(), "displayName", paramTableModel.getDisplayName(), "tableName", paramTableModel.getTableName(), "shortTableName", paramTableModel.getShortTableName(), "varName", paramTableModel.getVarName(), "accessType", String.valueOf(paramTableModel.getAccessType()), "resultType", String.valueOf(paramTableModel.getResultType()), "modifyTime", paramTableModel.getModifyTime(), "vml", paramTableModel.getVml() };
    openMarkerLn(paramTableModel.getName(), arrayOfString);
    a(paramTableModel);
    a(paramTableModel.getDocument());
    closeMarkerLn(paramTableModel.getName());
    return null;
  }

  public Object visitViewModel(ViewModel paramViewModel)
  {
    String[] arrayOfString = { "uuid", paramViewModel.getUuid(), "displayName", paramViewModel.getDisplayName(), "tableName", paramViewModel.getTableName(), "shortTableName", paramViewModel.getShortTableName(), "varName", paramViewModel.getVarName(), "accessMode", String.valueOf(paramViewModel.isAccessMode()), "resultType", String.valueOf(paramViewModel.getResultType()), "modifyTime", paramViewModel.getModifyTime(), "vml", paramViewModel.getVml() };
    openMarkerLn(paramViewModel.getName(), arrayOfString);
    a(paramViewModel);
    a(paramViewModel.getDocument());
    closeMarkerLn(paramViewModel.getName());
    return null;
  }

  public Object visitXmlAttribute(XmlAttribute paramXmlAttribute)
  {
    String[] arrayOfString = { "displayName", paramXmlAttribute.getDisplayName(), "key", paramXmlAttribute.getKey(), "valueType", paramXmlAttribute.getValueType(), "uuid", paramXmlAttribute.getUuid(), "visible", paramXmlAttribute.isVisible() ? "true" : "false", "groupName", paramXmlAttribute.getGroupName(), "loged", paramXmlAttribute.isLoged() };
    openMarkerLn(paramXmlAttribute.getName(), arrayOfString);
    a(paramXmlAttribute);
    closeMarkerLn(paramXmlAttribute.getName());
    return null;
  }

  public Object visitXmlNode(XmlNode paramXmlNode)
  {
    String[] arrayOfString = { "displayName", paramXmlNode.getDisplayName(), "uuid", paramXmlNode.getUuid(), "nodeName", paramXmlNode.getNodeName(), "resourceName", paramXmlNode.getResourceName(), "loadType", paramXmlNode.getLoadType(), "encoding", paramXmlNode.getEncoding(), "multiType", paramXmlNode.getMultiType(), "modifyTime", paramXmlNode.getModifyTime() };
    openMarkerLn(paramXmlNode.getName(), arrayOfString);
    a(paramXmlNode);
    a(paramXmlNode.getDocument());
    closeMarkerLn(paramXmlNode.getName());
    return null;
  }

  public Object visitRuleFlowActivitie(RuleFlowActivitie paramRuleFlowActivitie)
  {
    String[] arrayOfString = { "displayName", paramRuleFlowActivitie.getDisplayName(), "ruleUuid", paramRuleFlowActivitie.getRuleUuid(), "state", paramRuleFlowActivitie.getState(), "x", paramRuleFlowActivitie.getX(), "y", paramRuleFlowActivitie.getY(), "uuid", paramRuleFlowActivitie.getUuid(), "width", paramRuleFlowActivitie.getWidth(), "height", paramRuleFlowActivitie.getHeight(), "exeRuleName", paramRuleFlowActivitie.getExeRuleName(), "exeRuleDisplay", paramRuleFlowActivitie.getExeRuleDisplay(), "flowUuid", paramRuleFlowActivitie.getFlowUuid() };
    openMarkerLn(paramRuleFlowActivitie.getName(), arrayOfString);
    a(paramRuleFlowActivitie);
    closeMarkerLn(paramRuleFlowActivitie.getName());
    return null;
  }

  public Object visitRuleFlowTransition(RuleFlowTransition paramRuleFlowTransition)
  {
    String[] arrayOfString = { "displayName", paramRuleFlowTransition.getDisplayName(), "fromUuid", paramRuleFlowTransition.getFromUuid(), "toUuid", paramRuleFlowTransition.getToUuid(), "uuid", paramRuleFlowTransition.getUuid() };
    openMarkerLn(paramRuleFlowTransition.getName(), arrayOfString);
    a(paramRuleFlowTransition);
    closeMarkerLn(paramRuleFlowTransition.getName());
    return null;
  }

  public Object visitRuleSetFlow(RuleSetFlow paramRuleSetFlow)
  {
    String[] arrayOfString = { "displayName", paramRuleSetFlow.getDisplayName(), "uuid", paramRuleSetFlow.getUuid(), "editType", String.valueOf(paramRuleSetFlow.getEditType()), "startTime", paramRuleSetFlow.getStartTime(), "endTime", paramRuleSetFlow.getEndTime(), "createTime", paramRuleSetFlow.getCreateTime(), "actived", Boolean.toString(paramRuleSetFlow.isActived()), "modifyTime", paramRuleSetFlow.getModifyTime(), "modifyUser", paramRuleSetFlow.getModifyUser(), "vml", paramRuleSetFlow.getVml(), "logtype", paramRuleSetFlow.getLogtype(), "restartType", paramRuleSetFlow.getRestartType(), "vmlFlowType", paramRuleSetFlow.getVmlFlowType(), "sheetWhile", paramRuleSetFlow.isActiveSheetWhile(), "sheetUuid", paramRuleSetFlow.getSheetUuid(), "sheetName", paramRuleSetFlow.getSheetName(), "sheetOther", paramRuleSetFlow.getSheetOther(), "dataShap", paramRuleSetFlow.getDataShap(), "first", paramRuleSetFlow.isFirst(), "supportCatch", String.valueOf(paramRuleSetFlow.isSupportCatch()), "exceptionType", Integer.toString(paramRuleSetFlow.getExceptionType()), "errorMsg", paramRuleSetFlow.getErrorMsg(), "syn", Boolean.toString(paramRuleSetFlow.isSyn()) };
    openMarkerLn(paramRuleSetFlow.getName(), arrayOfString);
    a(paramRuleSetFlow.getPropertiesList());
    a(paramRuleSetFlow);
    a(paramRuleSetFlow.getDocument());
    closeMarkerLn(paramRuleSetFlow.getName());
    return null;
  }

  public Object visitRuleTreeFlow(RuleTreeFlow paramRuleTreeFlow)
  {
    String[] arrayOfString = { "displayName", paramRuleTreeFlow.getDisplayName(), "uuid", paramRuleTreeFlow.getUuid(), "editType", String.valueOf(paramRuleTreeFlow.getEditType()), "startTime", paramRuleTreeFlow.getStartTime(), "endTime", paramRuleTreeFlow.getEndTime(), "createTime", paramRuleTreeFlow.getCreateTime(), "actived", Boolean.toString(paramRuleTreeFlow.isActived()), "modifyTime", paramRuleTreeFlow.getModifyTime(), "modifyUser", paramRuleTreeFlow.getModifyUser(), "vml", paramRuleTreeFlow.getVml(), "logtype", paramRuleTreeFlow.getLogtype(), "restartType", paramRuleTreeFlow.getRestartType(), "vmlFlowType", paramRuleTreeFlow.getVmlFlowType(), "sheetWhile", paramRuleTreeFlow.isActiveSheetWhile(), "sheetUuid", paramRuleTreeFlow.getSheetUuid(), "sheetName", paramRuleTreeFlow.getSheetName(), "sheetOther", paramRuleTreeFlow.getSheetOther(), "dataShap", paramRuleTreeFlow.getDataShap(), "first", paramRuleTreeFlow.isFirst(), "supportCatch", String.valueOf(paramRuleTreeFlow.isSupportCatch()), "exceptionType", Integer.toString(paramRuleTreeFlow.getExceptionType()), "errorMsg", paramRuleTreeFlow.getErrorMsg(), "syn", Boolean.toString(paramRuleTreeFlow.isSyn()) };
    openMarkerLn(paramRuleTreeFlow.getName(), arrayOfString);
    a(paramRuleTreeFlow.getPropertiesList());
    a(paramRuleTreeFlow);
    a(paramRuleTreeFlow.getDocument());
    closeMarkerLn(paramRuleTreeFlow.getName());
    return null;
  }

  public Object visitRuleMirror(RuleMirror paramRuleMirror)
  {
    String[] arrayOfString = { "displayName", paramRuleMirror.getDisplayName(), "uuid", paramRuleMirror.getUuid(), "elementUuid", paramRuleMirror.getElementUuid(), "vmlFlowType", paramRuleMirror.getVmlFlowType(), "vml", paramRuleMirror.getVml() };
    openMarkerLn(paramRuleMirror.getName(), arrayOfString);
    a(paramRuleMirror);
    a(paramRuleMirror.getDocument());
    closeMarkerLn(paramRuleMirror.getName());
    return null;
  }

  public Object visitSoapParameter(SoapParameter paramSoapParameter)
  {
    String[] arrayOfString = { "displayName", paramSoapParameter.getDisplayName(), "key", paramSoapParameter.getKey(), "valueType", paramSoapParameter.getValueType(), "retType", paramSoapParameter.getRetType(), "uuid", paramSoapParameter.getUuid(), "visible", paramSoapParameter.isVisible() ? "true" : "false", "groupName", paramSoapParameter.getGroupName() };
    openMarkerLn(paramSoapParameter.getName(), arrayOfString);
    a(paramSoapParameter);
    closeMarkerLn(paramSoapParameter.getName());
    return null;
  }

  public Object visitSoapService(SoapService paramSoapService)
  {
    String[] arrayOfString = { "displayName", paramSoapService.getDisplayName(), "uuid", paramSoapService.getUuid(), "nodeName", paramSoapService.getNodeName(), "resultType", paramSoapService.getResultType(), "endpointURL", paramSoapService.getEndpointURL(), "serviceNS", paramSoapService.getServiceNS(), "serviceName", paramSoapService.getServiceName(), "portName", paramSoapService.getPortName(), "operationName", paramSoapService.getOperationName(), "actionUrl", paramSoapService.getActionUrl(), "soapVersion", paramSoapService.getSoapVersion(), "paramNS", paramSoapService.getParamNS(), "modifyTime", paramSoapService.getModifyTime() };
    openMarkerLn(paramSoapService.getName(), arrayOfString);
    a(paramSoapService);
    a(paramSoapService.getDocument());
    closeMarkerLn(paramSoapService.getName());
    return null;
  }

  public Object visitExcuteRuleToken(ExcuteRuleToken paramExcuteRuleToken)
  {
    String[] arrayOfString = { "returnType", String.valueOf(paramExcuteRuleToken.getReturnType()), "displayName", paramExcuteRuleToken.getDisplayName() };
    openMarkerLn(paramExcuteRuleToken.getName(), arrayOfString);
    a(paramExcuteRuleToken);
    closeMarkerLn(paramExcuteRuleToken.getName());
    return null;
  }

  public Object visitLogRecordToken(LogRecordToken paramLogRecordToken)
  {
    String[] arrayOfString = { "returnType", String.valueOf(paramLogRecordToken.getReturnType()), "displayName", paramLogRecordToken.getDisplayName() };
    openMarkerLn(paramLogRecordToken.getName(), arrayOfString);
    a(paramLogRecordToken);
    closeMarkerLn(paramLogRecordToken.getName());
    return null;
  }

  public Object visitSheetDynamicSelectToken(SheetDynamicSelectToken paramSheetDynamicSelectToken)
  {
    String[] arrayOfString = { "elementUuid", paramSheetDynamicSelectToken.getElementUuid(), "uniqueName", paramSheetDynamicSelectToken.getUniqueName(), "valueType", paramSheetDynamicSelectToken.getValueType(), "sheetUuid", paramSheetDynamicSelectToken.getSheetUuid(), "sheetUnique", paramSheetDynamicSelectToken.getSheetUnique(), "fieldUuid", paramSheetDynamicSelectToken.getFieldUuid(), "fieldUnique", paramSheetDynamicSelectToken.getFieldUnique(), "valueUuid", paramSheetDynamicSelectToken.getValueUuid(), "valueUnique", paramSheetDynamicSelectToken.getValueUnique() };
    openMarkerLn(paramSheetDynamicSelectToken.getName(), arrayOfString);
    a(paramSheetDynamicSelectToken);
    closeMarkerLn(paramSheetDynamicSelectToken.getName());
    return null;
  }

  public Object visitTreeAttribute(TreeAttribute paramTreeAttribute)
  {
    String[] arrayOfString = { "displayName", paramTreeAttribute.getDisplayName(), "key", paramTreeAttribute.getKey(), "valueType", paramTreeAttribute.getValueType(), "uuid", paramTreeAttribute.getUuid(), "visible", paramTreeAttribute.isVisible() ? "true" : "false", "groupName", paramTreeAttribute.getGroupName(), "locate", String.valueOf(paramTreeAttribute.getLocate()), "loged", paramTreeAttribute.isLoged() };
    openMarkerLn(paramTreeAttribute.getName(), arrayOfString);
    a(paramTreeAttribute);
    closeMarkerLn(paramTreeAttribute.getName());
    return null;
  }

  public Object visitTreeNode(TreeValueNode paramTreeValueNode)
  {
    String[] arrayOfString = { "displayName", paramTreeValueNode.getDisplayName(), "uuid", paramTreeValueNode.getUuid(), "nodeName", paramTreeValueNode.getNodeName(), "resourceName", paramTreeValueNode.getResourceName(), "loadType", paramTreeValueNode.getLoadType(), "encoding", paramTreeValueNode.getEncoding(), "multiType", paramTreeValueNode.getMultiType(), "shareType", paramTreeValueNode.getShareType(), "modifyTime", paramTreeValueNode.getModifyTime(), "inout", paramTreeValueNode.getInout() };
    openMarkerLn(paramTreeValueNode.getName(), arrayOfString);
    a(paramTreeValueNode);
    a(paramTreeValueNode.getDocument());
    closeMarkerLn(paramTreeValueNode.getName());
    return null;
  }

  public Object visitBOContainerGroup(BOContainerGroup paramBOContainerGroup)
  {
    String[] arrayOfString = { "displayName", paramBOContainerGroup.getDisplayName(), "uuid", paramBOContainerGroup.getUuid(), "modifyTime", paramBOContainerGroup.getModifyTime() };
    openMarkerLn(paramBOContainerGroup.getName(), arrayOfString);
    a(paramBOContainerGroup);
    closeMarkerLn(paramBOContainerGroup.getName());
    return null;
  }

  public Object visitSheetMap(SheetMap paramSheetMap)
  {
    String[] arrayOfString = { "uuid", paramSheetMap.getUuid(), "displayName", paramSheetMap.getDisplayName(), "englishName", paramSheetMap.getEnglishName(), "modifyTime", paramSheetMap.getModifyTime(), "vml", paramSheetMap.getVml(), "fromResource", paramSheetMap.isFromResource(), "keyType", paramSheetMap.getKeyType(), "keyValueType", paramSheetMap.getKeyValueType(), "implementType", String.valueOf(paramSheetMap.getImplementType()), "inout", paramSheetMap.getInout() };
    openMarkerLn(paramSheetMap.getName(), arrayOfString);
    a(paramSheetMap);
    a(paramSheetMap.getDocument());
    closeMarkerLn(paramSheetMap.getName());
    return null;
  }

  public Object visitSelectRulePackageToken(SelectRulePackageToken paramSelectRulePackageToken)
  {
    String[] arrayOfString = { "exeRuleName", paramSelectRulePackageToken.getExeRuleName(), "exeRuleDisplay", paramSelectRulePackageToken.getExeRuleDisplay() };
    openMarkerLn(paramSelectRulePackageToken.getName(), arrayOfString);
    a(paramSelectRulePackageToken);
    closeMarkerLn(paramSelectRulePackageToken.getName());
    return null;
  }

  public Object visitPackageField(AbstractPackageField paramAbstractPackageField)
  {
    String[] arrayOfString = { "funcName", paramAbstractPackageField.getFuncName(), "displayName", paramAbstractPackageField.getDisplayName(), "naryType", paramAbstractPackageField.getNaryType() };
    openMarkerLn(paramAbstractPackageField.getName(), arrayOfString);
    a(paramAbstractPackageField);
    closeMarkerLn(paramAbstractPackageField.getName());
    return null;
  }

  public Object visitSheetFentanMapping(SheetFentanMapping paramSheetFentanMapping)
  {
    String[] arrayOfString = { "cfieldUuid", paramSheetFentanMapping.getCfieldUuid(), "cfieldUnique", paramSheetFentanMapping.getCfieldUnique(), "fieldUuid", paramSheetFentanMapping.getFieldUuid(), "fieldUnique", paramSheetFentanMapping.getFieldUnique(), "bfieldUuid", paramSheetFentanMapping.getBfieldUuid(), "bfieldUnique", paramSheetFentanMapping.getBfieldUnique(), "mappingType", paramSheetFentanMapping.getMappingType() };
    openMarkerLn(paramSheetFentanMapping.getName(), arrayOfString);
    a(paramSheetFentanMapping);
    closeMarkerLn(paramSheetFentanMapping.getName());
    return null;
  }

  public Object visitSheetFentanSelectToken(SheetFentanSelectToken paramSheetFentanSelectToken)
  {
    String[] arrayOfString = { "elementUuid", paramSheetFentanSelectToken.getElementUuid(), "uniqueName", paramSheetFentanSelectToken.getUniqueName(), "valueType", paramSheetFentanSelectToken.getValueType(), "sheetUuid", paramSheetFentanSelectToken.getSheetUuid(), "sheetUnique", paramSheetFentanSelectToken.getSheetUnique(), "bSheetUuid", paramSheetFentanSelectToken.getbSheetUuid(), "bSheetUnique", paramSheetFentanSelectToken.getbSheetUnique(), "afentanUuid", paramSheetFentanSelectToken.getAfentanUuid(), "afentanUnique", paramSheetFentanSelectToken.getAfentanUnique(), "cfentanUuid", paramSheetFentanSelectToken.getCfentanUuid(), "cfentanUnique", paramSheetFentanSelectToken.getCfentanUnique(), "byingziUuid", paramSheetFentanSelectToken.getByingziUuid(), "byingziUnique", paramSheetFentanSelectToken.getByingziUnique(), "cyingziUuid", paramSheetFentanSelectToken.getCyingziUuid(), "cyingziUnique", paramSheetFentanSelectToken.getCyingziUnique() };
    openMarkerLn(paramSheetFentanSelectToken.getName(), arrayOfString);
    a(paramSheetFentanSelectToken);
    closeMarkerLn(paramSheetFentanSelectToken.getName());
    return null;
  }

  public Object visitRuleEnterToken(RuleEnterToken paramRuleEnterToken)
  {
    String[] arrayOfString = { "uuid", paramRuleEnterToken.getUuid() };
    openMarkerLn(paramRuleEnterToken.getName(), arrayOfString);
    a(paramRuleEnterToken);
    closeMarkerLn(paramRuleEnterToken.getName());
    return null;
  }

  public Object visitDecisionRelateAction(DecisionRelateAction paramDecisionRelateAction)
  {
    if ((!paramDecisionRelateAction.isEmpty()) && (paramDecisionRelateAction.isValid()))
    {
      String[] arrayOfString = { "uuid", paramDecisionRelateAction.getUuid(), "displayName", paramDecisionRelateAction.getDisplayName(), "conditionUuids", paramDecisionRelateAction.getConditionUuids() };
      openMarkerLn(paramDecisionRelateAction.getName(), arrayOfString);
      a(paramDecisionRelateAction);
      closeMarkerLn(paramDecisionRelateAction.getName());
    }
    return null;
  }

  public Object visitExeExpressionToken(ExeExpressionToken paramExeExpressionToken)
  {
    String[] arrayOfString = { "uuid", paramExeExpressionToken.getUuid(), "returnType", String.valueOf(paramExeExpressionToken.getReturnType()), "displayName", paramExeExpressionToken.getDisplayName() };
    openMarkerLn(paramExeExpressionToken.getName(), arrayOfString);
    a(paramExeExpressionToken);
    closeMarkerLn(paramExeExpressionToken.getName());
    return null;
  }

  public Object visitExeDecisionToken(ExeDecisionToken paramExeDecisionToken)
  {
    String[] arrayOfString = { "uuid", paramExeDecisionToken.getUuid(), "returnType", String.valueOf(paramExeDecisionToken.getReturnType()), "displayName", paramExeDecisionToken.getDisplayName() };
    openMarkerLn(paramExeDecisionToken.getName(), arrayOfString);
    a(paramExeDecisionToken);
    closeMarkerLn(paramExeDecisionToken.getName());
    return null;
  }

  public Object visitRulePoolFlow(RulePoolFlow paramRulePoolFlow)
  {
    String[] arrayOfString = { "displayName", paramRulePoolFlow.getDisplayName(), "uuid", paramRulePoolFlow.getUuid(), "editType", String.valueOf(paramRulePoolFlow.getEditType()), "startTime", paramRulePoolFlow.getStartTime(), "endTime", paramRulePoolFlow.getEndTime(), "createTime", paramRulePoolFlow.getCreateTime(), "actived", Boolean.toString(paramRulePoolFlow.isActived()), "modifyTime", paramRulePoolFlow.getModifyTime(), "modifyUser", paramRulePoolFlow.getModifyUser(), "vml", paramRulePoolFlow.getVml(), "logtype", paramRulePoolFlow.getLogtype(), "restartType", paramRulePoolFlow.getRestartType(), "vmlFlowType", paramRulePoolFlow.getVmlFlowType(), "sheetWhile", paramRulePoolFlow.isActiveSheetWhile(), "sheetUuid", paramRulePoolFlow.getSheetUuid(), "sheetName", paramRulePoolFlow.getSheetName(), "sheetOther", paramRulePoolFlow.getSheetOther(), "dataShap", paramRulePoolFlow.getDataShap(), "first", paramRulePoolFlow.isFirst(), "supportCatch", String.valueOf(paramRulePoolFlow.isSupportCatch()), "exceptionType", Integer.toString(paramRulePoolFlow.getExceptionType()), "errorMsg", paramRulePoolFlow.getErrorMsg(), "syn", Boolean.toString(paramRulePoolFlow.isSyn()) };
    openMarkerLn(paramRulePoolFlow.getName(), arrayOfString);
    a(paramRulePoolFlow.getPropertiesList());
    a(paramRulePoolFlow);
    a(paramRulePoolFlow.getDocument());
    closeMarkerLn(paramRulePoolFlow.getName());
    return null;
  }

  public Object visitRulePoolNode(RulePoolNode paramRulePoolNode)
  {
    String[] arrayOfString = { "displayName", paramRulePoolNode.getDisplayName(), "ruleUuid", paramRulePoolNode.getRuleUuid(), "state", paramRulePoolNode.getState(), "x", paramRulePoolNode.getX(), "y", paramRulePoolNode.getY(), "uuid", paramRulePoolNode.getUuid(), "width", paramRulePoolNode.getWidth(), "height", paramRulePoolNode.getHeight(), "exeRuleName", paramRulePoolNode.getExeRuleName(), "exeRuleDisplay", paramRulePoolNode.getExeRuleDisplay(), "flowUuid", paramRulePoolNode.getFlowUuid() };
    openMarkerLn(paramRulePoolNode.getName(), arrayOfString);
    a(paramRulePoolNode);
    closeMarkerLn(paramRulePoolNode.getName());
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
    String[] arrayOfString = { "displayName", paramCheckRuleInfo.getDisplayName(), "uuid", paramCheckRuleInfo.getUuid(), "excelFile", paramCheckRuleInfo.getExcelFile(), "initValues", paramCheckRuleInfo.getInitValues(), "willValues", paramCheckRuleInfo.getWillValues() };
    openMarkerLn(paramCheckRuleInfo.getName(), arrayOfString);
    a(paramCheckRuleInfo);
    closeMarkerLn(paramCheckRuleInfo.getName());
    return null;
  }

  public Object visitForEachConditionToken(ForEachConditionToken paramForEachConditionToken)
  {
    String[] arrayOfString = { "returnType", String.valueOf(paramForEachConditionToken.getReturnType()), "displayName", paramForEachConditionToken.getDisplayName() };
    openMarkerLn(paramForEachConditionToken.getName(), arrayOfString);
    a(paramForEachConditionToken);
    closeMarkerLn(paramForEachConditionToken.getName());
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.e
 * JD-Core Version:    0.6.0
 */