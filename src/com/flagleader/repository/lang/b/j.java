package com.flagleader.repository.lang.b;

import com.flagleader.repository.IElement;
import com.flagleader.repository.d.u;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FKModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.ProcedureModel;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.SheetValue;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.excel.AbstractExcelFieldModel;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.excel.ExcelCellModel;
import com.flagleader.repository.excel.ExcelColModel;
import com.flagleader.repository.excel.ExcelRowModel;
import com.flagleader.repository.excel.ExcelSheetModel;
import com.flagleader.repository.excel.ExcelTableSheetModel;
import com.flagleader.repository.excel.ExcelXYSheetModel;
import com.flagleader.repository.excel.IExcelObject;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.flow.RulePoolNode;
import com.flagleader.repository.flow.RulePoolValue;
import com.flagleader.repository.lang.expression.b;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.ElementTextToken;
import com.flagleader.repository.rlm.ElseIfRuleToken;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.ModifyToken;
import com.flagleader.repository.rlm.RuleEnterToken;
import com.flagleader.repository.rlm.RuleSetToken;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.StaticTextToken;
import com.flagleader.repository.rlm.action.AssignJudgeToken;
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
import com.flagleader.repository.rlm.action.NumberAssignJudgeToken;
import com.flagleader.repository.rlm.action.PackCatchActionToken;
import com.flagleader.repository.rlm.action.PackageFieldGet;
import com.flagleader.repository.rlm.action.PackageFieldSet;
import com.flagleader.repository.rlm.action.ReturnToken;
import com.flagleader.repository.rlm.action.SelectRulePackageToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.StringAssignJudgeToken;
import com.flagleader.repository.rlm.action.ThrowToken;
import com.flagleader.repository.rlm.condition.BooleanJudgeToken;
import com.flagleader.repository.rlm.condition.ClassJudgeToken;
import com.flagleader.repository.rlm.condition.ConditionToken;
import com.flagleader.repository.rlm.condition.DateJudgeToken;
import com.flagleader.repository.rlm.condition.DecimalJudgeToken;
import com.flagleader.repository.rlm.condition.ForEachConditionToken;
import com.flagleader.repository.rlm.condition.LogicalJudgeToken;
import com.flagleader.repository.rlm.condition.MultiConditionToken;
import com.flagleader.repository.rlm.condition.NumberJudgeToken;
import com.flagleader.repository.rlm.condition.RuleLogConditionToken;
import com.flagleader.repository.rlm.condition.StringJudgeToken;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.lang.IAssignToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IJudgeToken;
import com.flagleader.repository.rlm.lang.ILogicalToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IOperatorToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rlm.lang.IVariableToken;
import com.flagleader.repository.rlm.value.ClassToken;
import com.flagleader.repository.rlm.value.ConstantSelectToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.DateOperatorToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberPropertyToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.MemberToken.MemberSelector;
import com.flagleader.repository.rlm.value.NewToken;
import com.flagleader.repository.rlm.value.NumberOperatorToken;
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
import com.flagleader.repository.rlm.value.StringOperatorToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.AbstractSubFunction;
import com.flagleader.repository.rom.AbstractSubVariable;
import com.flagleader.repository.rom.BusinessObjectAttribute;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.BusinessObjectMethod;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.CustomVariable;
import com.flagleader.repository.rom.FunctionMember;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IClassObject;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.rom.MappingFunction;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.AbstractRuleFlow;
import com.flagleader.repository.tree.AbstractRuleSet;
import com.flagleader.repository.tree.AbstractRuleTree;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.CustomFunction;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateAction;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.DecisionValue;
import com.flagleader.repository.tree.EnumLibrary;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.FunctionLibrary;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.IRuleFlow;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
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
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class j extends com.flagleader.repository.e.m
  implements com.flagleader.repository.lang.c
{
  protected boolean a = true;
  public static boolean b = false;
  protected boolean c = false;
  protected boolean d = true;
  protected RulePackage e = null;
  protected ITreeNode f = null;
  protected int g = 1;
  protected boolean h = false;
  protected boolean i = false;
  protected boolean j = false;
  protected HashMap k = new HashMap();
  protected String l = "true";
  protected List m = new ArrayList(0);
  protected List n = null;
  protected static h o = i.d();
  private HashMap r = new HashMap();

  private String b(ITreeNode paramITreeNode)
  {
    String str = (String)this.r.get(paramITreeNode);
    if (str == null)
    {
      str = paramITreeNode.toString();
      this.r.put(paramITreeNode, str);
    }
    return str;
  }

  public j()
  {
  }

  public j(PrintWriter paramPrintWriter)
  {
    super(paramPrintWriter);
  }

  protected void b(RulePackage paramRulePackage)
  {
    f("the class file is generated by RuleBuilder. Copyright 2008-2010 flagleader ,  All Rights Reserved.");
    if (paramRulePackage.isValidPackage())
      e("package " + paramRulePackage.getPackageName() + ";");
    e("import com.flagleader.engine.*;");
    e("import com.flagleader.sql.*;");
    e("import com.flagleader.db.*;");
    e("import com.flagleader.xml.*;");
    e("import com.flagleader.util.*;");
    e("import com.flagleader.excel.*;");
    e("import java.util.*;");
    c();
  }

  private void f(String paramString)
  {
    this.i = true;
    e("/**");
    b(paramString, " * ");
    e(" */");
    this.i = false;
  }

  private void g(String paramString)
  {
    if (e())
    {
      if (this.f != null)
        this.k.put(String.valueOf(this.g), this.f.getUuid());
      d("/* " + StringUtil.replace(q, "  ", paramString) + " */");
    }
  }

  public String a(IRuleTree paramIRuleTree)
  {
    StringWriter localStringWriter = new StringWriter();
    this.p = new PrintWriter(localStringWriter);
    b();
    if ((paramIRuleTree instanceof Rule))
      ((Rule)paramIRuleTree).getRuleElementToken().acceptVisitor(this);
    else if ((paramIRuleTree instanceof DecisionMultiRule))
      ((DecisionMultiRule)paramIRuleTree).acceptVisitor(this);
    else if ((paramIRuleTree instanceof ExpressionRule))
      a((ExpressionRule)paramIRuleTree);
    else if ((paramIRuleTree instanceof DecisionRelateRule))
      ((DecisionRelateRule)paramIRuleTree).acceptVisitor(this);
    else if ((paramIRuleTree instanceof DecisionRule))
      ((DecisionRule)paramIRuleTree).acceptVisitor(this);
    else if ((paramIRuleTree instanceof RuleSetFlow))
      ((RuleSetFlow)paramIRuleTree).acceptVisitor(this);
    else if ((paramIRuleTree instanceof RuleTreeFlow))
      ((RuleTreeFlow)paramIRuleTree).acceptVisitor(this);
    else if ((paramIRuleTree instanceof RulePoolFlow))
      ((RulePoolFlow)paramIRuleTree).acceptVisitor(this);
    else if ((paramIRuleTree instanceof RuleSet))
      ((RuleSet)paramIRuleTree).acceptVisitor(this);
    j();
    return localStringWriter.toString();
  }

  private void a(Object paramObject)
  {
    if ((paramObject instanceof RuleSet))
      visitRuleSet((RuleSet)paramObject);
    else if ((paramObject instanceof RuleSetFlow))
      visitRuleSetFlow((RuleSetFlow)paramObject);
    else if ((paramObject instanceof RuleTreeFlow))
      visitRuleTreeFlow((RuleTreeFlow)paramObject);
    else if ((paramObject instanceof RulePoolFlow))
      visitRulePoolFlow((RulePoolFlow)paramObject);
    else if ((paramObject instanceof Rule))
      d(((Rule)paramObject).getRuleElementToken());
    else if ((paramObject instanceof DecisionRule))
      visitDecisionRule((DecisionRule)paramObject);
    else if ((paramObject instanceof DecisionMultiRule))
      visitDecisionMultiRule((DecisionMultiRule)paramObject);
    else if ((paramObject instanceof ExpressionRule))
      a((ExpressionRule)paramObject);
    else if ((paramObject instanceof DecisionRelateRule))
      visitDecisionRelateRule((DecisionRelateRule)paramObject);
    else if (((paramObject instanceof RuleMirror)) && (((RuleMirror)paramObject).getMemberElement() != null))
      a(((RuleMirror)paramObject).getMemberElement());
  }

  public String a(RulePackage paramRulePackage)
  {
    StringWriter localStringWriter = new StringWriter();
    this.p = new PrintWriter(localStringWriter);
    b();
    if (paramRulePackage.getLogType() == 1)
      this.d = false;
    Iterator localIterator = paramRulePackage.getRuleAndSets();
    while (localIterator.hasNext())
      a(localIterator.next());
    j();
    return localStringWriter.toString();
  }

  public String a(RuleLogConditionToken paramRuleLogConditionToken)
  {
    StringWriter localStringWriter = new StringWriter();
    this.p = new PrintWriter(localStringWriter);
    b();
    Iterator localIterator = paramRuleLogConditionToken.getConditions();
    if (localIterator.hasNext())
      while (localIterator.hasNext())
        d((IElement)localIterator.next());
    else
      d("true");
    j();
    return localStringWriter.toString();
  }

  public String a(IElement paramIElement)
  {
    StringWriter localStringWriter = new StringWriter();
    this.p = new PrintWriter(localStringWriter);
    b();
    this.j = true;
    if (paramIElement != null)
      paramIElement.acceptVisitor(this);
    j();
    return localStringWriter.toString();
  }

  public void c(IElement paramIElement)
  {
    if (!(paramIElement instanceof RulePackage))
    {
      if ((paramIElement instanceof IRuleTree))
        this.e = ((RulePackage)((IRuleTree)paramIElement).getCompilePackage());
      else if ((paramIElement instanceof RulePackage))
        this.e = ((RulePackage)paramIElement);
      else
        return;
      b();
      b(this.e);
      this.l = new j().a(this.e.getLogCondition());
      this.m = this.e.getEnvionment().getAllTraceVariable();
      if (paramIElement != null)
        a(this.e, (ITreeNode)paramIElement);
      j();
    }
    else
    {
      b();
      this.j = true;
      if (((RulePackage)paramIElement).getLogType() == 1)
        this.d = false;
      b((RulePackage)paramIElement);
      this.l = new j().a(((RulePackage)paramIElement).getLogCondition());
      this.m = ((RulePackage)paramIElement).getEnvionment().getAllTraceVariable();
      if (paramIElement != null)
        paramIElement.acceptVisitor(this);
      j();
    }
  }

  protected void b()
  {
    this.g = 1;
    this.k.clear();
    super.b();
  }

  protected void c()
  {
    if ((this.i) && (this.f != null))
      this.k.put(String.valueOf(this.g++), this.f.getUuid());
    else
      this.g += 1;
    super.c();
  }

  private static String h(String paramString)
  {
    return paramString;
  }

  private static char d(char paramChar)
  {
    return paramChar;
  }

  protected String a(String paramString)
  {
    return StringUtil.gbEncoding(paramString);
  }

  protected String a(char paramChar)
  {
    return StringUtil.gbEncoding(paramChar);
  }

  protected String b(String paramString)
  {
    if (paramString.indexOf("\\") >= 0)
      paramString = StringUtil.replace("\\", "\\\\", paramString);
    if (paramString.indexOf("\"") >= 0)
      paramString = StringUtil.replace("\"", "\\\"", paramString);
    if (paramString.indexOf("\n") >= 0)
      paramString = StringUtil.replace("\n", "\\n", paramString);
    if (paramString.indexOf("\r") >= 0)
      paramString = StringUtil.replace("\r", "", paramString);
    return paramString;
  }

  private void a(IRuleTree paramIRuleTree, HashMap paramHashMap)
  {
    if ((e()) || (paramHashMap.isEmpty()))
      return;
    Iterator localIterator = paramHashMap.keySet().iterator();
    l();
    d("\tif (Property.getInstance().isDebug() && out != null ) out.println(\"" + b(paramIRuleTree) + " : \"");
    while (localIterator.hasNext())
    {
      IVariableObject localIVariableObject = (IVariableObject)localIterator.next();
      d("+\"");
      d(b(localIVariableObject.getShowDisplayName()));
      d(" - \"+");
      d(localIVariableObject.getVarSaveValue());
      d("+\" ; \"");
    }
    d(");");
    c();
  }

  private void a(IRuleSet paramIRuleSet, boolean paramBoolean)
  {
    if ((e()) || (!this.d))
      return;
    e("RuleLogList childRuleLog = null;");
    if (!paramBoolean)
      if (this.l.equals("true"))
        e("if (ruleLog != null ) {");
      else
        e("if (ruleLog != null && " + this.l + ") {");
    String str = b(paramIRuleSet.getInfo());
    e("childRuleLog = new RuleLogList(\"" + b(paramIRuleSet.toString()) + "\",\"" + str + "\");");
    e("if (ruleLog != null ) ruleLog.addLog(childRuleLog);");
    if (!paramBoolean)
      e("}");
  }

  private void a(String paramString, boolean paramBoolean)
  {
    if ((e()) || (!this.d))
      return;
    e("RuleLogList childRuleLog = null;");
    if (!paramBoolean)
      if (this.l.equals("true"))
        e("if (ruleLog != null ) {");
      else
        e("if (ruleLog != null  && " + this.l + ") {");
    e("childRuleLog = new RuleLogList(\"" + b(paramString) + "\");");
    e("if (ruleLog != null ) ruleLog.addLog(childRuleLog);");
    if (!paramBoolean)
      e("}");
  }

  private void i(String paramString)
  {
    if ((e()) || (!this.d))
      return;
    e("RuleLogList exelog = null;");
    if (this.l.equals("true"))
      e("if (childRuleLog != null ) {");
    else
      e("if (childRuleLog != null  && " + this.l + ") {");
    e("\texelog = new RuleLogList(\"" + b(paramString) + "\");");
    e("\tchildRuleLog.addLog(exelog);");
    e("\tdtcObjects.put(\"ruleLog\",exelog);");
    e("} else {");
    e("if (ruleLog != null && childRuleLog == null ) {");
    e("\tchildRuleLog = new RuleLogList(\"" + b(paramString) + "\");");
    e("\truleLog.addLog(childRuleLog); } ");
    e("\tdtcObjects.put(\"ruleLog\",childRuleLog);");
    e("}");
  }

  private void a(String paramString1, String paramString2)
  {
    if ((e()) || (!this.d))
      return;
    if (this.l.equals("true"))
      e("if (" + paramString2 + " != null ) {");
    else
      e("if (" + paramString2 + " != null && " + this.l + ") {");
    e("\t" + paramString2 + ".setRuleProcess(\"" + b(paramString1) + "\") ;");
    e("}");
  }

  private void a(String paramString1, String paramString2, List paramList)
  {
    if ((e()) || (!this.d))
      return;
    if (this.l.equals("true"))
      e("if (" + paramString2 + " != null ) {");
    else
      e("if (" + paramString2 + " != null && " + this.l + ") {");
    e("\t" + paramString2 + ".setRuleProcess(\"" + b(paramString1) + "\") ;");
    String str1 = "";
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      if ((!(paramList.get(i1) instanceof IVariableObject)) || ((paramList.get(i1) instanceof ISubVariable)))
        continue;
      str1 = str1 + "\"" + b(((IVariableObject)paramList.get(i1)).getShowDisplayName()) + "\",";
    }
    String str2 = "";
    for (int i2 = 0; i2 < paramList.size(); i2++)
    {
      if ((!(paramList.get(i2) instanceof IVariableObject)) || ((paramList.get(i2) instanceof ISubVariable)))
        continue;
      str2 = str2 + "StringUtil.stringValue(" + ((IVariableObject)paramList.get(i2)).getVarSaveValue() + "),";
    }
    if (str2.length() > 0)
    {
      e("try {");
      e("\t" + paramString2 + ".setFieldInits(new String[]{" + str1.substring(0, str1.length() - 1) + "},new String[]{" + str2.substring(0, str2.length() - 1) + "}) ;");
      e("} catch (Throwable ethrowable) {}");
    }
    e("}");
  }

  private void a(List paramList, String paramString)
  {
    if ((e()) || (!this.d) || (paramList == null) || (paramList.size() == 0))
      return;
    if (this.l.equals("true"))
      e("if (" + paramString + " != null ) {");
    else
      e("if (" + paramString + " != null && " + this.l + ") {");
    String str1 = "";
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      if ((!(paramList.get(i1) instanceof IVariableObject)) || ((paramList.get(i1) instanceof ISubVariable)))
        continue;
      str1 = str1 + "\"" + b(((IVariableObject)paramList.get(i1)).getShowDisplayName()) + "\",";
    }
    String str2 = "";
    for (int i2 = 0; i2 < paramList.size(); i2++)
    {
      if ((!(paramList.get(i2) instanceof IVariableObject)) || ((paramList.get(i2) instanceof ISubVariable)))
        continue;
      str2 = str2 + "StringUtil.stringValue(" + ((IVariableObject)paramList.get(i2)).getVarSaveValue() + "),";
    }
    if (str2.length() > 0)
    {
      e("try {");
      e("\t" + paramString + ".setFieldResults(new String[]{" + str1.substring(0, str1.length() - 1) + "},new String[]{" + str2.substring(0, str2.length() - 1) + "}) ;");
      e("} catch (Throwable ethrowable) {}");
    }
    e("}");
  }

  public Object visitActionToken(StatementContainerToken paramStatementContainerToken)
  {
    if ((paramStatementContainerToken == null) || (paramStatementContainerToken.getStatement() == null))
      return null;
    if (e())
    {
      g(paramStatementContainerToken.getText());
      c();
      l();
    }
    if ((!this.j) && (paramStatementContainerToken.canGetJavaCode()))
    {
      d(paramStatementContainerToken.getJavaCode());
      return null;
    }
    super.visitActionToken(paramStatementContainerToken);
    d(";");
    return null;
  }

  public Object visitAssignToken(AssignToken paramAssignToken)
  {
    if (paramAssignToken == null)
      return null;
    Object localObject;
    if (((paramAssignToken.getFirstValue() instanceof MemberToken)) && ((((MemberToken)paramAssignToken.getFirstValue()).getMemberElement() instanceof IPropertyObject)))
    {
      localObject = (IPropertyObject)((MemberToken)paramAssignToken.getFirstValue()).getMemberElement();
      d(((IPropertyObject)localObject).getSetMethodPreName());
      if (!paramAssignToken.getFirstValue().getJavaType().a())
        if (paramAssignToken.getFirstValue().getJavaType().b())
          d("(" + paramAssignToken.getFirstValue().getJavaType().K() + ")");
        else if (paramAssignToken.getFirstValue().getJavaType().r())
          d("(" + paramAssignToken.getFirstValue().getJavaType().L() + ")");
      IValueContainerToken localIValueContainerToken = paramAssignToken.getComparedValue();
      d(localIValueContainerToken);
      d(((IPropertyObject)localObject).getSetMethodSufName());
    }
    else
    {
      d(paramAssignToken.getFirstValue());
      if (paramAssignToken.getAssign() != null)
        paramAssignToken.getAssign().acceptVisitor(this);
      if (!paramAssignToken.getFirstValue().getJavaType().a())
        if (paramAssignToken.getFirstValue().getJavaType().b())
          d("(" + paramAssignToken.getFirstValue().getJavaType().K() + ")");
        else if (paramAssignToken.getFirstValue().getJavaType().r())
          d("(" + paramAssignToken.getFirstValue().getJavaType().L() + ")");
      localObject = paramAssignToken.getComparedValue();
      d((IElement)localObject);
    }
    return null;
  }

  public Object visitConditionToken(ConditionToken paramConditionToken)
  {
    if (paramConditionToken == null)
      return null;
    if ((!this.j) && (paramConditionToken.canGetJavaCode()))
    {
      d(paramConditionToken.getJavaCode());
      return null;
    }
    if (paramConditionToken != null)
    {
      if (!paramConditionToken.isFirstCondition())
        paramConditionToken.getLogicalOperator().acceptVisitor(this);
      for (int i1 = 0; i1 < paramConditionToken.getLeftParenthesisNumber(); i1++)
        d(" ( ");
      if (paramConditionToken.getNextTests().hasNext())
        d(" ( ");
      a(paramConditionToken);
      for (i1 = 0; i1 < paramConditionToken.getRightParenthesisNumber(); i1++)
        d(" ) ");
      Iterator localIterator = paramConditionToken.getNextTests();
      while (localIterator.hasNext())
      {
        IConditionToken localIConditionToken = (IConditionToken)localIterator.next();
        if (!localIConditionToken.isFirstCondition())
          localIConditionToken.getLogicalOperator().acceptVisitor(this);
        for (int i2 = 0; i2 < localIConditionToken.getLeftParenthesisNumber(); i2++)
          d(" ( ");
        a(localIConditionToken);
        for (i2 = 0; i2 < localIConditionToken.getRightParenthesisNumber(); i2++)
          d(" ) ");
      }
      if (paramConditionToken.getNextTests().hasNext())
        d(" ) ");
    }
    return null;
  }

  public Object visitMultiConditionToken(MultiConditionToken paramMultiConditionToken)
  {
    if (paramMultiConditionToken == null)
      return null;
    Iterator localIterator = paramMultiConditionToken.getConditions();
    while (localIterator.hasNext())
    {
      ConditionToken localConditionToken = (ConditionToken)localIterator.next();
      localConditionToken.acceptVisitor(this);
    }
    return null;
  }

  public Object visitConstantToken(ConstantToken paramConstantToken)
  {
    if (paramConstantToken == null)
      return null;
    String str1;
    int i1;
    if (paramConstantToken.getJavaType().m())
    {
      d("\"");
      str1 = paramConstantToken.getValue();
      for (i1 = 0; i1 < str1.length(); i1++)
        if (str1.charAt(i1) == '"')
          d("\\\"");
        else if (str1.charAt(i1) == '\\')
          b('\\');
        else
          d(a(str1.charAt(i1)));
      d("\"");
    }
    else if ((paramConstantToken.getValue() == null) || (paramConstantToken.getValue().length() == 0))
    {
      if (paramConstantToken.getJavaType().b())
        d("0");
      else if (paramConstantToken.getJavaType().e())
        d("false");
      else if (paramConstantToken.getJavaType().d())
        d("''");
      else if (paramConstantToken.getJavaType().s())
        d("new java.util.ArrayList()");
      else if (paramConstantToken.getJavaType().o())
        d("new java.util.HashMap()");
      else
        d("null");
    }
    else if (paramConstantToken.getJavaType().v())
    {
      d("DateUtil.formatDate(\"");
      d(paramConstantToken.getValue());
      d("\")");
    }
    else if (paramConstantToken.getJavaType().w())
    {
      d("DateUtil.formatTime(\"");
      d(paramConstantToken.getValue());
      d("\")");
    }
    else if (paramConstantToken.getJavaType().x())
    {
      d("DateUtil.formatDatetime(\"");
      d(paramConstantToken.getValue());
      d("\")");
    }
    else if (paramConstantToken.getJavaType().j())
    {
      d("new java.math.BigDecimal(\"");
      d(paramConstantToken.getValue());
      d("\")");
    }
    else if (paramConstantToken.getJavaType().b())
    {
      try
      {
        if (paramConstantToken.getJavaType().c())
        {
          d(NumberUtil.parseNumber(paramConstantToken.getValue(), true) + "f");
          break label962;
        }
        if (paramConstantToken.getJavaType().h())
        {
          d(NumberUtil.parseNumber(paramConstantToken.getValue(), false) + "L");
          break label962;
        }
        if (paramConstantToken.getJavaType().i())
        {
          str1 = NumberUtil.parseNumber(paramConstantToken.getValue(), true);
          if (str1.indexOf(".") >= 0)
          {
            d(str1);
            break label962;
          }
          if (str1.length() >= 10)
          {
            d(str1 + "L");
            break label962;
          }
          d(str1);
          break label962;
        }
        str1 = NumberUtil.parseNumber(paramConstantToken.getValue(), false);
        if (str1.indexOf(".") >= 0)
        {
          d(str1);
          break label962;
        }
        if (str1.length() >= 10)
        {
          d(str1 + "L");
          break label962;
        }
        d(str1);
      }
      catch (Throwable localThrowable)
      {
        d(paramConstantToken.getValue());
      }
    }
    else if (paramConstantToken.getJavaType().d())
    {
      d("'" + h(paramConstantToken.getValue()) + "'");
    }
    else if (paramConstantToken.getJavaType().e())
    {
      d(NumberUtil.formatBoolean(paramConstantToken.getValue()));
    }
    else if (paramConstantToken.getJavaType().n())
    {
      d("ListUtil.stringToArray(\"");
      d(paramConstantToken.getValue());
      d("\",\"" + paramConstantToken.getJavaType().J() + "\",\",\")");
    }
    else if (paramConstantToken.getJavaType().s())
    {
      d("ListUtil.stringToList(\"");
      d(paramConstantToken.getValue());
      d("\",\"" + paramConstantToken.getJavaType().J() + "\",\",\")");
    }
    else if (paramConstantToken.getJavaType().F())
    {
      d("\"");
      String str2 = paramConstantToken.getValue();
      for (i1 = 0; i1 < str2.length(); i1++)
        if (str2.charAt(i1) == '"')
          d("\\\"");
        else if (str2.charAt(i1) == '\\')
          b('\\');
        else
          d(a(str2.charAt(i1)));
      d("\"");
    }
    else
    {
      d(paramConstantToken.getValue());
    }
    label962: return null;
  }

  public Object visitFieldToken(FieldToken paramFieldToken)
  {
    if (paramFieldToken == null)
      return null;
    return visitMemberToken(paramFieldToken);
  }

  public Object visitJudgeToken(JudgeToken paramJudgeToken)
  {
    if (paramJudgeToken == null)
      return null;
    if ((paramJudgeToken instanceof StringOperatorToken))
      switch (paramJudgeToken.getType())
      {
      case 1:
        d("+");
      }
    else if ((paramJudgeToken instanceof StringAssignJudgeToken))
      switch (paramJudgeToken.getType())
      {
      case 0:
        d("=");
        break;
      case 1:
        d("+=");
      default:
        break;
      }
    else if ((paramJudgeToken instanceof NumberOperatorToken))
      switch (paramJudgeToken.getType())
      {
      case 1:
        d("+");
        break;
      case 2:
        d("-");
        break;
      case 3:
        d("*");
        break;
      case 4:
        d("/");
        break;
      case 5:
        d("%");
      default:
        break;
      }
    else if ((paramJudgeToken instanceof NumberJudgeToken))
      switch (paramJudgeToken.getType())
      {
      case 0:
        d("==");
        break;
      case 1:
        d("!=");
        break;
      case 2:
        d(">");
        break;
      case 3:
        d(">=");
        break;
      case 4:
        d("<");
        break;
      case 5:
        d("<=");
      default:
        break;
      }
    else if ((paramJudgeToken instanceof NumberAssignJudgeToken))
      switch (paramJudgeToken.getType())
      {
      case 0:
        d("=");
        break;
      case 1:
        d("+=");
        break;
      case 2:
        d("-=");
        break;
      case 3:
        d("*=");
        break;
      case 4:
        d("/=");
        break;
      case 5:
        d("%=");
      default:
        break;
      }
    else if ((paramJudgeToken instanceof LogicalJudgeToken))
      switch (paramJudgeToken.getType())
      {
      case 0:
        d(" || ");
        break;
      case 1:
        d(" && ");
      default:
        break;
      }
    else if ((paramJudgeToken instanceof AssignJudgeToken))
      switch (paramJudgeToken.getType())
      {
      case 0:
        d("=");
      }
    else
      d(paramJudgeToken.getRlmStr());
    return null;
  }

  public Object visitMemberToken(MemberToken paramMemberToken)
  {
    if (paramMemberToken == null)
      return null;
    IElement localIElement = paramMemberToken.getMemberElement();
    if (paramMemberToken.getParamCount() > 0)
    {
      String str1 = "";
      if (localIElement != null)
        str1 = ((IBusinessObject)localIElement).getVarValue();
      HashMap localHashMap = new HashMap();
      List localList = paramMemberToken.getValueTokens();
      for (int i1 = 0; i1 < localList.size(); i1++)
        localHashMap.put(((ValueToken)localList.get(i1)).getArgName(), localList.get(i1));
      i1 = str1.indexOf("{arg");
      int i2 = 0;
      if (i1 >= 0)
      {
        do
        {
          d(str1.substring(i2, i1));
          i2 = str1.indexOf("}", i1);
          if (i2 <= i1)
            break;
          String str2 = str1.substring(i1 + 1, i2).trim();
          if (localHashMap.get(str2.trim()) != null)
          {
            ValueToken localValueToken = (ValueToken)localHashMap.get(str2.trim());
            int i3 = 0;
            if ((!localValueToken.getJavaType().a()) && (localValueToken.getValueElement() != null) && (!localValueToken.getJavaType().b(localValueToken.getValueElement().getJavaType())))
            {
              d("(" + o.b(localValueToken.getJavaType()) + ")");
              i3 = 1;
            }
            else if ((!localValueToken.getJavaType().m()) && ((localValueToken.getValueElement() instanceof ConstantToken)) && (StringUtil.isEmpty(((ConstantToken)localValueToken.getValueElement()).getValue())))
            {
              d("(" + o.b(localValueToken.getJavaType()) + ")");
              i3 = 1;
            }
            else if ((!localValueToken.getJavaType().k()) && ((localValueToken.getValueElement() instanceof ConstantToken)))
            {
              d("(" + o.b(localValueToken.getJavaType()) + ")");
              i3 = 1;
            }
            else if ((!localValueToken.getJavaType().i()) && ((localValueToken.getValueElement() instanceof ConstantToken)) && (!NumberUtil.isParsedInteger(((ConstantToken)localValueToken.getValueElement()).getValue())))
            {
              d("(" + o.b(localValueToken.getJavaType()) + ")");
              i3 = 1;
            }
            if ((i3 != 0) && (localValueToken != null) && (localValueToken.getNextValue() != null))
              d("(");
            d(localValueToken);
            if ((i3 != 0) && (localValueToken != null) && (localValueToken.getNextValue() != null))
              d(")");
          }
          else
          {
            d(str2);
          }
          i1 = str1.indexOf("{arg", i2++);
        }
        while (i1 >= 0);
        d(str1.substring(i2));
      }
      else
      {
        d(str1);
      }
    }
    else if (localIElement != null)
    {
      d(((IBusinessObject)localIElement).getVarValue());
    }
    return null;
  }

  public Object visitJavaStatementToken(JavaStatementToken paramJavaStatementToken)
  {
    d(StringUtil.replace("\\n", "\n", paramJavaStatementToken.getValue()));
    return null;
  }

  public Object visitSheetFieldsSelectToken(SheetFieldsSelectToken paramSheetFieldsSelectToken)
  {
    d("\"" + paramSheetFieldsSelectToken.getFieldNames() + "\"");
    return null;
  }

  public Object visitSheetFunctionsSelectToken(SheetFunctionsSelectToken paramSheetFunctionsSelectToken)
  {
    List localList = paramSheetFunctionsSelectToken.getSelectedElements();
    d("\"");
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      SheetFunction localSheetFunction = (SheetFunction)localList.get(i1);
      if (localSheetFunction.getFuncName().length() > 0)
      {
        d(localSheetFunction.getFuncName());
        d("(");
      }
      IBusinessObject localIBusinessObject = paramSheetFunctionsSelectToken.getEnvionment().getBusinessObject(localSheetFunction.getFieldUuid(), localSheetFunction.getFieldUnique());
      if (localIBusinessObject != null)
        d(localIBusinessObject.getValueName());
      if (localSheetFunction.getFuncName().length() > 0)
        d(") ");
      if (localSheetFunction.getAsTargetName().length() > 0)
      {
        d(" as ");
        d(localSheetFunction.getAsTargetName());
      }
      if (localSheetFunction.getAsName().length() > 0)
      {
        d(" ");
        d(localSheetFunction.getAsName());
      }
      if (i1 == localList.size() - 1)
        continue;
      d(",");
    }
    d("\"");
    return null;
  }

  public Object visitSheetWhere(SheetWhere paramSheetWhere)
  {
    if (!paramSheetWhere.getAssignValue().getJavaType().a())
      d(paramSheetWhere.getTypeManager().g(paramSheetWhere.getAssignValue().getJavaType()));
    IValueToken localIValueToken = paramSheetWhere.getAssignValue().getValueElement();
    if ((localIValueToken != null) && ((localIValueToken instanceof ConstantToken)) && (localIValueToken.getDisplayName().startsWith("{")) && (localIValueToken.getDisplayName().endsWith("}")))
      d(localIValueToken.getDisplayName().substring(1, localIValueToken.getDisplayName().length() - 1));
    else
      paramSheetWhere.getAssignValue().acceptVisitor(this);
    if (!paramSheetWhere.getAssignValue().getJavaType().a())
      d(paramSheetWhere.getTypeManager().h(paramSheetWhere.getAssignValue().getJavaType()));
    return null;
  }

  public Object visitRulePoolValue(RulePoolValue paramRulePoolValue)
  {
    IBusinessObject localIBusinessObject = paramRulePoolValue.getSelected();
    d(localIBusinessObject.getVarValue());
    return null;
  }

  public Object visitSheetFieldSelectToken(SheetFieldSelectToken paramSheetFieldSelectToken)
  {
    IBusinessObject localIBusinessObject = paramSheetFieldSelectToken.getSelected();
    d(localIBusinessObject.getVarValue());
    return null;
  }

  public Object visitSheetAndFieldsSelectToken(SheetAndFieldsSelectToken paramSheetAndFieldsSelectToken)
  {
    IBusinessObject localIBusinessObject1 = paramSheetAndFieldsSelectToken.getSourceSheet();
    if (localIBusinessObject1 != null)
      d(localIBusinessObject1.getVarValue());
    d(",new String[]{");
    List localList1 = paramSheetAndFieldsSelectToken.getSelectedFields();
    SheetFieldMapping localSheetFieldMapping;
    Object localObject;
    for (int i1 = 0; i1 < localList1.size(); i1++)
    {
      localSheetFieldMapping = (SheetFieldMapping)localList1.get(i1);
      localObject = localSheetFieldMapping.getField();
      if (localObject != null)
      {
        d("\"");
        d(((IBusinessObject)localObject).getValueName());
        d("\"");
      }
      if (i1 == localList1.size() - 1)
        continue;
      d(" , ");
    }
    d("},new String[]{");
    for (i1 = 0; i1 < localList1.size(); i1++)
    {
      localSheetFieldMapping = (SheetFieldMapping)localList1.get(i1);
      localObject = localSheetFieldMapping.getMappingField();
      if (localObject != null)
      {
        d("\"");
        d(((IBusinessObject)localObject).getValueName());
        d("\"");
      }
      if (i1 == localList1.size() - 1)
        continue;
      d(" , ");
    }
    d("}");
    List localList2 = paramSheetAndFieldsSelectToken.getSelectedConditions();
    if (localList2.size() > 0)
    {
      d(",\"");
      for (int i2 = 0; i2 < localList2.size(); i2++)
      {
        localObject = (SheetWhere)localList2.get(i2);
        IBusinessObject localIBusinessObject2 = paramSheetAndFieldsSelectToken.getEnvionment().getBusinessObject(((SheetWhere)localObject).getFieldUuid(), ((SheetWhere)localObject).getFieldUnique());
        if (localIBusinessObject2 != null)
        {
          d(localIBusinessObject2.getValueName());
          d(" ");
        }
        if (((SheetWhere)localObject).getFuncName().length() > 0)
          d(((SheetWhere)localObject).getFuncName());
        if (((SheetWhere)localObject).getValue().length() > 0)
          d(" ? ");
        if (i2 == localList2.size() - 1)
          continue;
        d(" " + ((SheetWhere)localObject).getNaryType() + " ");
      }
      d("\",new Object[]{");
      for (i2 = 0; i2 < localList2.size(); i2++)
      {
        localObject = (SheetWhere)localList2.get(i2);
        ((SheetWhere)localObject).acceptVisitor(this);
        if (i2 == localList2.size() - 1)
          continue;
        d(" , ");
      }
      d("}");
    }
    return null;
  }

  public Object visitSheetAndWheresSelectToken(SheetAndWheresSelectToken paramSheetAndWheresSelectToken)
  {
    IBusinessObject localIBusinessObject1 = paramSheetAndWheresSelectToken.getSourceSheet();
    if (localIBusinessObject1 != null)
      d(localIBusinessObject1.getVarValue());
    d(",new String[]{");
    List localList1 = paramSheetAndWheresSelectToken.getSelectedFields();
    SheetFieldMapping localSheetFieldMapping;
    Object localObject;
    for (int i1 = 0; i1 < localList1.size(); i1++)
    {
      localSheetFieldMapping = (SheetFieldMapping)localList1.get(i1);
      localObject = localSheetFieldMapping.getField();
      if (localObject != null)
      {
        d("\"");
        d(((IBusinessObject)localObject).getValueName());
        d("\"");
      }
      if (i1 == localList1.size() - 1)
        continue;
      d(" , ");
    }
    d("},new String[]{");
    for (i1 = 0; i1 < localList1.size(); i1++)
    {
      localSheetFieldMapping = (SheetFieldMapping)localList1.get(i1);
      localObject = localSheetFieldMapping.getMappingField();
      if (localObject != null)
      {
        d("\"");
        d(((IBusinessObject)localObject).getValueName());
        d("\"");
      }
      if (i1 == localList1.size() - 1)
        continue;
      d(" , ");
    }
    d("}");
    d(",new String[]{");
    localList1 = paramSheetAndWheresSelectToken.getSelectedWheres();
    for (i1 = 0; i1 < localList1.size(); i1++)
    {
      localSheetFieldMapping = (SheetFieldMapping)localList1.get(i1);
      localObject = localSheetFieldMapping.getField();
      if (localObject != null)
      {
        d("\"");
        d(((IBusinessObject)localObject).getValueName());
        d("\"");
      }
      if (i1 == localList1.size() - 1)
        continue;
      d(" , ");
    }
    d("},new String[]{");
    for (i1 = 0; i1 < localList1.size(); i1++)
    {
      localSheetFieldMapping = (SheetFieldMapping)localList1.get(i1);
      localObject = localSheetFieldMapping.getMappingField();
      if (localObject != null)
      {
        d("\"");
        d(((IBusinessObject)localObject).getValueName());
        d("\"");
      }
      if (i1 == localList1.size() - 1)
        continue;
      d(" , ");
    }
    d("}");
    List localList2 = paramSheetAndWheresSelectToken.getSelectedConditions();
    if (localList2.size() > 0)
    {
      d(",\"");
      for (int i2 = 0; i2 < localList2.size(); i2++)
      {
        localObject = (SheetWhere)localList2.get(i2);
        IBusinessObject localIBusinessObject2 = paramSheetAndWheresSelectToken.getEnvionment().getBusinessObject(((SheetWhere)localObject).getFieldUuid(), ((SheetWhere)localObject).getFieldUnique());
        if (localIBusinessObject2 != null)
        {
          d(localIBusinessObject2.getValueName());
          d(" ");
        }
        if (((SheetWhere)localObject).getFuncName().length() > 0)
          d(((SheetWhere)localObject).getFuncName());
        if (((SheetWhere)localObject).getValue().length() > 0)
          d(" ? ");
        if (i2 == localList2.size() - 1)
          continue;
        d(" " + ((SheetWhere)localObject).getNaryType() + " ");
      }
      d("\",new Object[]{");
      for (i2 = 0; i2 < localList2.size(); i2++)
      {
        localObject = (SheetWhere)localList2.get(i2);
        ((SheetWhere)localObject).acceptVisitor(this);
        if (i2 == localList2.size() - 1)
          continue;
        d(" , ");
      }
      d("}");
    }
    return null;
  }

  public Object visitSheetFieldMapping(SheetFieldMapping paramSheetFieldMapping)
  {
    return null;
  }

  public Object visitSheetWheresSelectToken(SheetWheresSelectToken paramSheetWheresSelectToken)
  {
    List localList = paramSheetWheresSelectToken.getSelectedFields();
    d("\"");
    SheetWhere localSheetWhere;
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      localSheetWhere = (SheetWhere)localList.get(i1);
      IBusinessObject localIBusinessObject = paramSheetWheresSelectToken.getEnvionment().getBusinessObject(localSheetWhere.getFieldUuid(), localSheetWhere.getFieldUnique());
      if (localIBusinessObject != null)
      {
        d(localIBusinessObject.getValueName());
        d(" ");
      }
      if (localSheetWhere.getFuncName().length() > 0)
        d(localSheetWhere.getFuncName());
      if (localSheetWhere.getValue().length() > 0)
        d(" ? ");
      if (i1 == localList.size() - 1)
        continue;
      d(" " + localSheetWhere.getNaryType() + " ");
    }
    d("\",new Object[]{");
    for (i1 = 0; i1 < localList.size(); i1++)
    {
      localSheetWhere = (SheetWhere)localList.get(i1);
      localSheetWhere.acceptVisitor(this);
      if (i1 == localList.size() - 1)
        continue;
      d(" , ");
    }
    d("}");
    return null;
  }

  public Object visitMethodToken(MethodToken paramMethodToken)
  {
    return visitMemberToken(paramMethodToken);
  }

  public Object visitModifyToken(ModifyToken paramModifyToken)
  {
    return null;
  }

  public Object visitNewToken(NewToken paramNewToken)
  {
    if (paramNewToken == null)
      return null;
    IElement localIElement = paramNewToken.getMemberElement();
    if ((localIElement != null) && ((localIElement instanceof IClassObject)))
      d(" new " + ((IClassObject)localIElement).getClassName() + "()");
    return null;
  }

  public Object visitClassLibrary(ClassContainer paramClassContainer)
  {
    return null;
  }

  public Object visitReturnToken(ReturnToken paramReturnToken)
  {
    if (paramReturnToken == null)
      return null;
    if (paramReturnToken.getReturnType() == 0)
      d("if ( true ) return M_RETURN_CONTINUE ");
    else if (paramReturnToken.getReturnType() == 1)
      d("if ( true ) return M_RETURN_BREAK ");
    else if (paramReturnToken.getReturnType() == 2)
      d("if ( true ) return M_RETURN_EXIT ");
    else if (paramReturnToken.getReturnType() == 3)
      d("if ( true ) return M_RETURN_RESTART ");
    else
      d("if ( true ) return " + paramReturnToken.getReturnType());
    return null;
  }

  private void a(AbstractRuleTree paramAbstractRuleTree)
  {
    if (paramAbstractRuleTree.needWhile())
    {
      IWhileObject localIWhileObject = paramAbstractRuleTree.getWhileSheet();
      e(localIWhileObject.getVarValue() + ".beforeFirst() ;");
      e("while (" + localIWhileObject.getVarValue() + ".next() ) {");
    }
  }

  private void b(AbstractRuleTree paramAbstractRuleTree)
  {
    if (paramAbstractRuleTree.needWhile())
      e("}");
  }

  public Object visitRule(Rule paramRule)
  {
    c();
    this.f = paramRule;
    if (!paramRule.isActived())
    {
      e("if ( true ) return M_RETURN_DEFAULT;");
      return null;
    }
    e("try {");
    b(1);
    if (paramRule.getStartTime() != 0L)
      e("if ( getCurrentTime() < " + paramRule.getStartTime() + "L ) return M_RETURN_DEFAULT ;");
    if (paramRule.getEndTime() != 0L)
      e("if ( getCurrentTime() > " + paramRule.getEndTime() + "L ) return M_RETURN_DEFAULT ;");
    a(paramRule);
    b(1);
    d(paramRule.getRuleElementToken());
    c(1);
    b(paramRule);
    c(1);
    e("} catch (Exception e) {");
    if (paramRule.isSupportCatch())
    {
      b(1);
      Iterator localIterator = paramRule.getRuleElementToken().getCatchActions().getActions();
      while (localIterator.hasNext())
        e((IElement)localIterator.next());
      c(1);
    }
    e("if ( e instanceof RuleEngineException ) throw e ;");
    if (paramRule.getExceptionType() == 0)
      e("\tthrow e ;");
    else if (paramRule.getExceptionType() == 1)
    {
      if (paramRule.getErrorMsg().length() > 0)
        e(" throw new RuleEngineException(\"" + h(paramRule.getErrorMsg()) + "\",e);");
      else
        e(" throw new RuleEngineException(\"" + h(b(paramRule)) + "\",e);");
    }
    else if (paramRule.getExceptionType() == 2)
    {
      if (paramRule.getErrorMsg().length() > 0)
        e(" throw new RuleEngineException(\"" + h(paramRule.getErrorMsg()) + "\"+e.getLocalizedMessage(),e);");
      else
        e(" throw new RuleEngineException(\"" + h(b(paramRule)) + "\"+e.getLocalizedMessage(),e);");
    }
    else
      paramRule.getExceptionType();
    e("} catch (Throwable e1) {");
    if (paramRule.getErrorMsg().length() > 0)
      e(" throw new RuleEngineException(\"" + h(paramRule.getErrorMsg()) + "\",e1);");
    else
      e(" throw new RuleEngineException(\"" + h(b(paramRule)) + "\"+e1.getMessage(),e1);");
    e("}");
    return null;
  }

  protected void a(List paramList, DecisionRule paramDecisionRule, int paramInt, IConditionToken paramIConditionToken)
  {
    if (((paramIConditionToken.getCompareOperator() instanceof StringJudgeToken)) && (paramIConditionToken.getCompareOperator().getType() == 12))
    {
      e("else {");
    }
    else
    {
      l();
      if ((paramInt > 0) && (paramDecisionRule.getMatchType() == 1))
        d("else if ( ");
      else
        d("if ( ");
      paramIConditionToken.acceptVisitor(this);
      d(" ) {");
      c();
    }
    List localList = paramDecisionRule.getNextConditions((IConditionToken)paramList.get(paramList.size() - 1), paramList.size());
    if ((localList.size() == 0) || (paramList.size() >= paramDecisionRule.getConditionNum()))
      a(paramList, paramDecisionRule);
    else
      for (int i1 = 0; i1 < localList.size(); i1++)
      {
        ArrayList localArrayList = new ArrayList(paramList.size() + 1);
        localArrayList.addAll(paramList);
        localArrayList.add(localList.get(i1));
        b(1);
        a(localArrayList, paramDecisionRule, i1, (IConditionToken)localList.get(i1));
        c(1);
      }
    e("}");
  }

  private void a(List paramList, DecisionRule paramDecisionRule)
  {
    b(1);
    List localList = paramDecisionRule.getFirstConditions().getConditionList();
    Object localObject1;
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      localObject1 = (IConditionToken)localList.get(i1);
      if (((((IConditionToken)localObject1).getCompareOperator() instanceof StringJudgeToken)) && (((IConditionToken)localObject1).getCompareOperator().getType() == 12))
      {
        e("else {");
      }
      else
      {
        l();
        if ((i1 > 0) && (paramDecisionRule.getMatchType() == 1))
          d("else if ( ");
        else
          d("if ( ");
        ((IConditionToken)localObject1).acceptVisitor(this);
        d(" ) {");
        c();
      }
      if (paramDecisionRule.getMemberElement() != null)
      {
        if (!e())
        {
          localObject2 = ((IConditionToken)paramList.get(0)).getText();
          for (int i2 = 2; (i2 <= paramDecisionRule.getConditionNum()) && (i2 <= paramList.size()); i2++)
          {
            localObject2 = localObject2 + u.a("tv_and", "and");
            localObject2 = localObject2 + ((IConditionToken)paramList.get(i2 - 1)).getText();
          }
          localObject2 = localObject2 + ((IConditionToken)localObject1).getText();
          if ((paramDecisionRule.needLog()) && (!paramDecisionRule.needWhile()))
            a((String)localObject2, "childRuleLog", paramDecisionRule.getRelateVarNames());
        }
        Object localObject2 = paramDecisionRule.getMemberElement();
        if ((paramDecisionRule.getDecisionValue(paramList, (IConditionToken)localObject1) != null) && (paramDecisionRule.getDecisionValue(paramList, (IConditionToken)localObject1).getValue().length() > 0))
        {
          l();
          if ((localObject2 instanceof IPropertyObject))
          {
            IPropertyObject localIPropertyObject = (IPropertyObject)localObject2;
            d(localIPropertyObject.getSetMethodPreName());
            if (!((IBusinessObject)localObject2).getJavaType().a())
              if (((IBusinessObject)localObject2).getJavaType().b())
                d("(" + ((IBusinessObject)localObject2).getJavaType().K() + ")");
              else if (((IBusinessObject)localObject2).getJavaType().r())
                d("(" + ((IBusinessObject)localObject2).getJavaType().L() + ")");
            d(paramDecisionRule.getDecisionValue(paramList, (IConditionToken)localObject1).getAssignValue());
            d(localIPropertyObject.getSetMethodSufName());
          }
          else
          {
            d(((IBusinessObject)localObject2).getVarValue());
            d(" = ");
            if ((!((IBusinessObject)localObject2).getJavaType().a()) && (((IBusinessObject)localObject2).getJavaType().b()))
              d("(" + ((IBusinessObject)localObject2).getJavaType().K() + ")");
            paramDecisionRule.getDecisionValue(paramList, (IConditionToken)localObject1).getAssignValue().acceptVisitor(this);
          }
          d(";");
          c();
        }
      }
      e("}");
    }
    if ((!e()) && (paramDecisionRule.needLog()) && (!paramDecisionRule.needWhile()))
      a(paramDecisionRule.getAssignVarNames(), "childRuleLog");
    if ((!e()) && (this.m.size() > 0))
    {
      HashMap localHashMap = new HashMap();
      localObject1 = paramDecisionRule.getMemberElement();
      if (((localObject1 instanceof IVariableObject)) && (((IVariableObject)localObject1).isLoged()))
        localHashMap.put(localObject1, localObject1);
      a(paramDecisionRule, localHashMap);
    }
    if (!e())
      if (paramDecisionRule.getRestartType() == 1)
        e("if ( true) return  M_RETURN_RESTART;");
      else if (paramDecisionRule.getRestartType() == 2)
        e("if ( true) return  M_RETURN_CONTINUE;");
      else if (paramDecisionRule.getRestartType() == 3)
        e("if ( true) return  M_RETURN_BREAK;");
    c(1);
  }

  public Object visitDecisionRule(DecisionRule paramDecisionRule)
  {
    if (!paramDecisionRule.isActived())
      e("if ( true ) return M_RETURN_DEFAULT;");
    a(paramDecisionRule);
    b(1);
    this.f = paramDecisionRule;
    List localList = paramDecisionRule.getSecondConditions().getConditionList();
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localList.get(i1));
      a(localArrayList, paramDecisionRule, i1, (IConditionToken)localList.get(i1));
    }
    c(1);
    b(paramDecisionRule);
    return null;
  }

  public Object visitDecisionRelateRule(DecisionRelateRule paramDecisionRelateRule)
  {
    this.f = paramDecisionRelateRule;
    List localList = paramDecisionRelateRule.getConditions().getConditionList();
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localList.get(i1));
      if (paramDecisionRelateRule.getMatchType() == 1)
        a(localArrayList, paramDecisionRelateRule, i1, (IConditionToken)localList.get(i1));
      else
        b(localArrayList, paramDecisionRelateRule, i1);
    }
    return null;
  }

  protected void a(List paramList, DecisionRelateRule paramDecisionRelateRule, int paramInt, IConditionToken paramIConditionToken)
  {
    if (((paramIConditionToken.getCompareOperator() instanceof StringJudgeToken)) && (paramIConditionToken.getCompareOperator().getType() == 12))
    {
      e("else {");
    }
    else
    {
      l();
      if ((paramDecisionRelateRule.getMatchType() == 1) && (paramInt > 0))
        d("else if ( ");
      else
        d("if ( ");
      paramIConditionToken.acceptVisitor(this);
      d(" ) {");
      c();
    }
    List localList = paramDecisionRelateRule.getNextConditions((IConditionToken)paramList.get(paramList.size() - 1), paramList.size());
    if ((localList.size() == 0) || (paramList.size() >= paramDecisionRelateRule.getConditionNum()))
    {
      a(paramList, paramDecisionRelateRule);
    }
    else
    {
      if ((paramDecisionRelateRule.getValueNum() == 0) && (!paramDecisionRelateRule.getDecisionAction(paramList).isEmpty()))
        a(paramList, paramDecisionRelateRule);
      for (int i1 = 0; i1 < localList.size(); i1++)
      {
        ArrayList localArrayList = new ArrayList(paramList.size() + 1);
        localArrayList.addAll(paramList);
        localArrayList.add(localList.get(i1));
        b(1);
        a(localArrayList, paramDecisionRelateRule, i1, (IConditionToken)localList.get(i1));
        c(1);
      }
    }
    e("}");
  }

  private void a(List paramList, DecisionRelateRule paramDecisionRelateRule)
  {
    b(1);
    if (!e())
    {
      String str = ((IConditionToken)paramList.get(0)).getText();
      for (int i2 = 2; (i2 <= paramDecisionRelateRule.getConditionNum()) && (i2 <= paramList.size()); i2++)
      {
        str = str + u.a("tv_and", "and");
        str = str + ((IConditionToken)paramList.get(i2 - 1)).getText();
      }
      if ((paramDecisionRelateRule.needLog()) && (!paramDecisionRelateRule.needWhile()))
        a(str, "childRuleLog", paramDecisionRelateRule.getRelateVarNames());
    }
    Object localObject1;
    Object localObject2;
    for (int i1 = 0; i1 < paramDecisionRelateRule.getValueNum(); i1++)
    {
      if (paramDecisionRelateRule.getDecisionElement(i1 + 1) == null)
        continue;
      localObject1 = paramDecisionRelateRule.getDecisionElement(i1 + 1).getMemberElement();
      if ((paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject1) == null) || (paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject1).getValue().length() <= 0))
        continue;
      l();
      if ((localObject1 instanceof IPropertyObject))
      {
        localObject2 = (IPropertyObject)localObject1;
        d(((IPropertyObject)localObject2).getSetMethodPreName());
        if (!((IBusinessObject)localObject1).getJavaType().a())
          if (((IBusinessObject)localObject1).getJavaType().b())
            d("(" + ((IBusinessObject)localObject1).getJavaType().K() + ")");
          else if (((IBusinessObject)localObject1).getJavaType().r())
            d("(" + ((IBusinessObject)localObject1).getJavaType().L() + ")");
        d(paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject1).getAssignValue());
        d(((IPropertyObject)localObject2).getSetMethodSufName());
      }
      else
      {
        d(((IBusinessObject)localObject1).getVarValue());
        d(" = ");
        if ((!((IBusinessObject)localObject1).getJavaType().a()) && (((IBusinessObject)localObject1).getJavaType().b()))
          d("(" + ((IBusinessObject)localObject1).getJavaType().K() + ")");
        paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject1).getAssignValue().acceptVisitor(this);
      }
      d(";");
      c();
    }
    DecisionRelateAction localDecisionRelateAction = paramDecisionRelateRule.getDecisionAction(paramList);
    if (!localDecisionRelateAction.isEmpty())
      localDecisionRelateAction.getThenActions().acceptVisitor(this);
    if ((!e()) && (paramDecisionRelateRule.needLog()) && (!paramDecisionRelateRule.needWhile()))
      a(paramDecisionRelateRule.getAssignVarNames(), "childRuleLog");
    if ((!e()) && (this.m.size() > 0))
    {
      localObject1 = new HashMap();
      localObject2 = paramDecisionRelateRule.getDecisionElements();
      for (int i3 = 0; i3 < ((List)localObject2).size(); i3++)
      {
        IBusinessObject localIBusinessObject = ((DecisionElement)((List)localObject2).get(i3)).getMemberElement();
        if ((!(localIBusinessObject instanceof IVariableObject)) || (!((IVariableObject)localIBusinessObject).isLoged()))
          continue;
        ((HashMap)localObject1).put(localIBusinessObject, localIBusinessObject);
      }
      a(paramDecisionRelateRule, (HashMap)localObject1);
    }
    if (!e())
      if (paramDecisionRelateRule.getRestartType() == 1)
        e("if ( true) return  M_RETURN_RESTART;");
      else if (paramDecisionRelateRule.getRestartType() == 2)
        e("if ( true) return  M_RETURN_CONTINUE;");
      else if (paramDecisionRelateRule.getRestartType() == 3)
        e("if ( true) return  M_RETURN_BREAK;");
    c(1);
  }

  private void a(IConditionToken paramIConditionToken, List paramList)
  {
    if (paramIConditionToken == null)
      return;
    if (((paramIConditionToken.getCompareOperator() instanceof StringJudgeToken)) && (paramIConditionToken.getCompareOperator().getType() == 12))
    {
      d(" !( ");
      for (int i1 = 0; i1 < paramList.size(); i1++)
      {
        IConditionToken localIConditionToken = (IConditionToken)paramList.get(i1);
        if ((!(localIConditionToken.getCompareOperator() instanceof StringJudgeToken)) || (localIConditionToken.getCompareOperator().getType() != 12))
          localIConditionToken.acceptVisitor(this);
        if (i1 + 1 >= paramList.size())
          continue;
        localIConditionToken = (IConditionToken)paramList.get(i1 + 1);
        if (((localIConditionToken.getCompareOperator() instanceof StringJudgeToken)) && (localIConditionToken.getCompareOperator().getType() == 12))
          continue;
        d(" || ");
      }
      d(" ) ");
    }
    else
    {
      paramIConditionToken.acceptVisitor(this);
    }
  }

  private void a(DecisionMultiRule paramDecisionMultiRule, List paramList, int paramInt)
  {
    IMultiConditionToken localIMultiConditionToken = paramDecisionMultiRule.getConditions(paramInt + 1);
    if (paramInt > 0)
      b(1);
    for (int i1 = 0; i1 < localIMultiConditionToken.getConditionList().size(); i1++)
    {
      IConditionToken localIConditionToken = localIMultiConditionToken.getCondition(i1);
      paramList.add(localIConditionToken);
      if (((localIConditionToken.getCompareOperator() instanceof StringJudgeToken)) && (localIConditionToken.getCompareOperator().getType() == 12))
      {
        e("else {");
      }
      else
      {
        l();
        if ((paramDecisionMultiRule.getMatchType() == 1) && (i1 > 0))
          d("else if ( ");
        else
          d("if ( ");
        localIConditionToken.acceptVisitor(this);
        d(" ) {");
        c();
      }
      if (paramInt < paramDecisionMultiRule.getConditionNum() - 1)
        a(paramDecisionMultiRule, paramList, paramInt + 1);
      else
        a(paramList, paramDecisionMultiRule);
      paramList.remove(localIConditionToken);
      e("}");
    }
    if (paramInt > 0)
      c(1);
  }

  private void a(List paramList, DecisionMultiRule paramDecisionMultiRule)
  {
    b(1);
    int i1 = paramDecisionMultiRule.getConditionNum();
    Object localObject1;
    if (!e())
    {
      localObject1 = ((IConditionToken)paramList.get(0)).getText();
      for (int i2 = 2; (i2 <= paramDecisionMultiRule.getConditionNum()) && (i2 <= paramList.size()); i2++)
      {
        localObject1 = localObject1 + u.a("tv_and", "and");
        localObject1 = localObject1 + ((IConditionToken)paramList.get(i2 - 1)).getText();
      }
      if ((paramDecisionMultiRule.needLog()) && (!paramDecisionMultiRule.needWhile()))
        a((String)localObject1, "childRuleLog", paramDecisionMultiRule.getRelateVarNames());
    }
    Object localObject2;
    while (i1 < paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum())
    {
      if (paramDecisionMultiRule.getDecisionElement(i1 - paramDecisionMultiRule.getConditionNum() + 1) != null)
      {
        localObject1 = paramDecisionMultiRule.getDecisionElement(i1 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement();
        if ((paramDecisionMultiRule.getDecisionValue(paramList, (IBusinessObject)localObject1) != null) && (paramDecisionMultiRule.getDecisionValue(paramList, (IBusinessObject)localObject1).getValue().length() > 0))
        {
          l();
          if ((localObject1 instanceof IPropertyObject))
          {
            localObject2 = (IPropertyObject)localObject1;
            d(((IPropertyObject)localObject2).getSetMethodPreName());
            if (!((IBusinessObject)localObject1).getJavaType().a())
              if (((IBusinessObject)localObject1).getJavaType().b())
                d("(" + ((IBusinessObject)localObject1).getJavaType().K() + ")");
              else if (((IBusinessObject)localObject1).getJavaType().r())
                d("(" + ((IBusinessObject)localObject1).getJavaType().L() + ")");
            d(paramDecisionMultiRule.getDecisionValue(paramList, (IBusinessObject)localObject1).getAssignValue());
            d(((IPropertyObject)localObject2).getSetMethodSufName());
          }
          else
          {
            d(((IBusinessObject)localObject1).getVarValue());
            d(" = ");
            if ((!((IBusinessObject)localObject1).getJavaType().a()) && (((IBusinessObject)localObject1).getJavaType().b()))
              d("(" + ((IBusinessObject)localObject1).getJavaType().K() + ")");
            paramDecisionMultiRule.getDecisionValue(paramList, (IBusinessObject)localObject1).getAssignValue().acceptVisitor(this);
          }
          d(";");
          c();
        }
      }
      i1++;
    }
    if ((!e()) && (paramDecisionMultiRule.needLog()) && (!paramDecisionMultiRule.needWhile()))
      a(paramDecisionMultiRule.getAssignVarNames(), "childRuleLog");
    if ((!e()) && (this.m.size() > 0))
    {
      localObject1 = new HashMap();
      localObject2 = paramDecisionMultiRule.getDecisionElements();
      for (int i3 = 0; i3 < ((List)localObject2).size(); i3++)
      {
        IBusinessObject localIBusinessObject = ((DecisionElement)((List)localObject2).get(i3)).getMemberElement();
        if ((!(localIBusinessObject instanceof IVariableObject)) || (!((IVariableObject)localIBusinessObject).isLoged()))
          continue;
        ((HashMap)localObject1).put(localIBusinessObject, localIBusinessObject);
      }
      a(paramDecisionMultiRule, (HashMap)localObject1);
    }
    if (!e())
      if (paramDecisionMultiRule.getRestartType() == 1)
        e("if ( true) return  M_RETURN_RESTART;");
      else if (paramDecisionMultiRule.getRestartType() == 2)
        e("if ( true) return  M_RETURN_CONTINUE;");
      else if (paramDecisionMultiRule.getRestartType() == 3)
        e("if ( true) return  M_RETURN_BREAK;");
    paramDecisionMultiRule.isActiveSheetWhile();
    c(1);
  }

  public Object visitDecisionMultiRule(DecisionMultiRule paramDecisionMultiRule)
  {
    if (paramDecisionMultiRule.getMatchType() == 1)
    {
      localObject1 = new ArrayList(paramDecisionMultiRule.getConditionNum());
      a(paramDecisionMultiRule, (List)localObject1, 0);
      return null;
    }
    Object localObject1 = new int[paramDecisionMultiRule.getConditionNum()];
    for (int i1 = 0; i1 < paramDecisionMultiRule.getConditionNum(); i1++)
      localObject1[i1] = 0;
    i1 = 0;
    do
    {
      int i2 = 0;
      ArrayList localArrayList = new ArrayList(paramDecisionMultiRule.getConditionNum());
      while (i2 < paramDecisionMultiRule.getConditionNum())
      {
        IMultiConditionToken localIMultiConditionToken = paramDecisionMultiRule.getConditions(i2 + 1);
        localArrayList.add(localIMultiConditionToken.getCondition(localObject1[i2]));
        i2++;
      }
      int i3 = 0;
      while (i2 < paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum())
      {
        if (paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1) != null)
        {
          IBusinessObject localIBusinessObject1 = paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement();
          if ((paramDecisionMultiRule.getDecisionValue(localArrayList, localIBusinessObject1) != null) && (paramDecisionMultiRule.getDecisionValue(localArrayList, localIBusinessObject1).getValue().length() > 0))
          {
            i3 = 1;
            break;
          }
        }
        i2++;
      }
      if (i3 != 0)
      {
        l();
        if ((paramDecisionMultiRule.getMatchType() == 1) && (i1 > 0))
          d("else if ( ");
        else
          d("if ( ");
        a(paramDecisionMultiRule.getConditions(1).getCondition(localObject1[0]), paramDecisionMultiRule.getConditions(1).getConditionList());
        for (int i4 = 2; i4 <= paramDecisionMultiRule.getConditionNum(); i4++)
        {
          d(" && ");
          a(paramDecisionMultiRule.getConditions(i4).getCondition(localObject1[(i4 - 1)]), paramDecisionMultiRule.getConditions(i4).getConditionList());
        }
        d(" ) {");
        c();
        b(1);
        Object localObject2;
        if (!e())
        {
          localObject2 = paramDecisionMultiRule.getConditions(1).getCondition(localObject1[0]).getText();
          for (int i5 = 2; (i5 <= paramDecisionMultiRule.getConditionNum()) && (i5 <= localArrayList.size()); i5++)
          {
            localObject2 = localObject2 + u.a("tv_and", "and");
            localObject2 = localObject2 + paramDecisionMultiRule.getConditions(i5).getCondition(localObject1[(i5 - 1)]).getText();
          }
          if ((paramDecisionMultiRule.needLog()) && (!paramDecisionMultiRule.needWhile()))
            a((String)localObject2, "childRuleLog", paramDecisionMultiRule.getRelateVarNames());
        }
        Object localObject3;
        while (i2 < paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum())
        {
          if (paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1) != null)
          {
            localObject2 = paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement();
            if ((paramDecisionMultiRule.getDecisionValue(localArrayList, (IBusinessObject)localObject2) != null) && (paramDecisionMultiRule.getDecisionValue(localArrayList, (IBusinessObject)localObject2).getValue().length() > 0))
            {
              l();
              if ((localObject2 instanceof IPropertyObject))
              {
                localObject3 = (IPropertyObject)localObject2;
                d(((IPropertyObject)localObject3).getSetMethodPreName());
                if (!((IBusinessObject)localObject2).getJavaType().a())
                  if (((IBusinessObject)localObject2).getJavaType().b())
                    d("(" + ((IBusinessObject)localObject2).getJavaType().K() + ")");
                  else if (((IBusinessObject)localObject2).getJavaType().r())
                    d("(" + ((IBusinessObject)localObject2).getJavaType().L() + ")");
                d(paramDecisionMultiRule.getDecisionValue(localArrayList, (IBusinessObject)localObject2).getAssignValue());
                d(((IPropertyObject)localObject3).getSetMethodSufName());
              }
              else
              {
                d(((IBusinessObject)localObject2).getVarValue());
                d(" = ");
                if ((!((IBusinessObject)localObject2).getJavaType().a()) && (((IBusinessObject)localObject2).getJavaType().b()))
                  d("(" + ((IBusinessObject)localObject2).getJavaType().K() + ")");
                paramDecisionMultiRule.getDecisionValue(localArrayList, (IBusinessObject)localObject2).getAssignValue().acceptVisitor(this);
              }
              d(";");
              c();
            }
          }
          i2++;
        }
        if ((!e()) && (paramDecisionMultiRule.needLog()) && (!paramDecisionMultiRule.needWhile()))
          a(paramDecisionMultiRule.getAssignVarNames(), "childRuleLog");
        if ((!e()) && (this.m.size() > 0))
        {
          localObject2 = new HashMap();
          localObject3 = paramDecisionMultiRule.getDecisionElements();
          for (int i6 = 0; i6 < ((List)localObject3).size(); i6++)
          {
            IBusinessObject localIBusinessObject2 = ((DecisionElement)((List)localObject3).get(i6)).getMemberElement();
            if ((!(localIBusinessObject2 instanceof IVariableObject)) || (!((IVariableObject)localIBusinessObject2).isLoged()))
              continue;
            ((HashMap)localObject2).put(localIBusinessObject2, localIBusinessObject2);
          }
          a(paramDecisionMultiRule, (HashMap)localObject2);
        }
        if (!e())
          if (paramDecisionMultiRule.getRestartType() == 1)
            e("if ( true) return  M_RETURN_RESTART;");
          else if (paramDecisionMultiRule.getRestartType() == 2)
            e("if ( true) return  M_RETURN_CONTINUE;");
          else if (paramDecisionMultiRule.getRestartType() == 3)
            e("if ( true) return  M_RETURN_BREAK;");
        paramDecisionMultiRule.isActiveSheetWhile();
        c(1);
        e("}");
      }
      localObject1 = paramDecisionMultiRule.getNextDecision(localObject1);
      i1++;
    }
    while (localObject1 != null);
    return null;
  }

  public void a(ExpressionRule paramExpressionRule)
  {
    try
    {
      a(paramExpressionRule.getRules());
    }
    catch (Exception localException)
    {
      EngineLogger.getEngineLogger().error(localException.getLocalizedMessage(), localException);
    }
  }

  public Object visitExpressionRule(ExpressionRule paramExpressionRule)
  {
    c();
    this.f = paramExpressionRule;
    if (!paramExpressionRule.isActived())
    {
      e("if ( true ) return M_RETURN_DEFAULT;");
      return null;
    }
    e("try {");
    b(1);
    if (paramExpressionRule.getStartTime() != 0L)
      e("if ( getCurrentTime() < " + paramExpressionRule.getStartTime() + "L ) return M_RETURN_DEFAULT ;");
    if (paramExpressionRule.getEndTime() != 0L)
      e("if ( getCurrentTime() > " + paramExpressionRule.getEndTime() + "L ) return M_RETURN_DEFAULT ;");
    a(paramExpressionRule);
    b(1);
    a(paramExpressionRule);
    c(1);
    b(paramExpressionRule);
    c(1);
    e("} catch (Exception e) {");
    e("if ( e instanceof RuleEngineException ) throw e ;");
    if (paramExpressionRule.getExceptionType() == 0)
      e("\tthrow e ;");
    else if (paramExpressionRule.getExceptionType() == 1)
    {
      if (paramExpressionRule.getErrorMsg().length() > 0)
        e(" throw new RuleEngineException(\"" + h(paramExpressionRule.getErrorMsg()) + "\",e);");
      else
        e(" throw new RuleEngineException(\"" + h(b(paramExpressionRule)) + "\",e);");
    }
    else if (paramExpressionRule.getExceptionType() == 2)
    {
      if (paramExpressionRule.getErrorMsg().length() > 0)
        e(" throw new RuleEngineException(\"" + h(paramExpressionRule.getErrorMsg()) + "\"+e.getLocalizedMessage(),e);");
      else
        e(" throw new RuleEngineException(\"" + h(b(paramExpressionRule)) + "\"+e.getLocalizedMessage(),e);");
    }
    else
      paramExpressionRule.getExceptionType();
    e("} catch (Throwable e1) {");
    if (paramExpressionRule.getErrorMsg().length() > 0)
      e(" throw new RuleEngineException(\"" + h(paramExpressionRule.getErrorMsg()) + "\",e1);");
    else
      e(" throw new RuleEngineException(\"" + h(b(paramExpressionRule)) + "\"+e1.getMessage(),e1);");
    e("}");
    return null;
  }

  private void a(com.flagleader.repository.lang.expression.l paraml)
  {
    ArrayList localArrayList = paraml.b();
    for (int i1 = 0; i1 < localArrayList.size(); i1++)
      if ((localArrayList.get(i1) instanceof com.flagleader.repository.lang.expression.n))
      {
        a((com.flagleader.repository.lang.expression.n)localArrayList.get(i1));
      }
      else
      {
        if (!(localArrayList.get(i1) instanceof com.flagleader.repository.lang.expression.m))
          continue;
        a((com.flagleader.repository.lang.expression.m)localArrayList.get(i1));
      }
  }

  private void a(com.flagleader.repository.lang.expression.n paramn)
  {
    ArrayList localArrayList = paramn.b();
    for (int i1 = 0; i1 < localArrayList.size(); i1++)
      if ((localArrayList.get(i1) instanceof com.flagleader.repository.lang.expression.n))
      {
        a((com.flagleader.repository.lang.expression.n)localArrayList.get(i1));
      }
      else
      {
        if (!(localArrayList.get(i1) instanceof com.flagleader.repository.lang.expression.m))
          continue;
        a((com.flagleader.repository.lang.expression.m)localArrayList.get(i1));
      }
  }

  private void a(com.flagleader.repository.lang.expression.m paramm)
  {
    if ((paramm.b().equals("if")) || (paramm.b().equals("else if")))
    {
      d(paramm.b() + " ( ");
      if ((paramm.c() != null) && (!paramm.c().b_()))
        a(paramm.c());
      else
        d("true");
      d(" ) {");
      c();
    }
    else if (paramm.b().equals("else"))
    {
      e("else {");
    }
    if (paramm.d() != null)
      a(paramm.d());
    if (paramm.e() != null)
      a(paramm.e());
    if (!StringUtil.isEmpty(paramm.b()))
      e("}");
  }

  private void a(b paramb)
  {
    try
    {
      paramb.b().acceptVisitor(this);
    }
    catch (Exception localException)
    {
      EngineLogger.getEngineLogger().error(localException.getLocalizedMessage(), localException);
    }
  }

  private void a(com.flagleader.repository.lang.expression.c paramc)
  {
    try
    {
      paramc.b().acceptVisitor(this);
    }
    catch (Exception localException)
    {
      EngineLogger.getEngineLogger().error(localException.getLocalizedMessage(), localException);
    }
  }

  protected void a(List paramList, DecisionRelateRule paramDecisionRelateRule, int paramInt)
  {
    int i1 = 0;
    for (int i2 = 0; i2 < paramDecisionRelateRule.getValueNum(); i2++)
    {
      if (paramDecisionRelateRule.getDecisionElement(i2 + 1) == null)
        continue;
      IBusinessObject localIBusinessObject1 = paramDecisionRelateRule.getDecisionElement(i2 + 1).getMemberElement();
      if ((localIBusinessObject1 == null) || (paramDecisionRelateRule.getDecisionValue(paramList, localIBusinessObject1) == null) || (paramDecisionRelateRule.getDecisionValue(paramList, localIBusinessObject1).getValue().length() <= 0))
        continue;
      i1 = 1;
      break;
    }
    if (i1 != 0)
    {
      l();
      if ((paramDecisionRelateRule.getMatchType() == 1) && (paramInt > 0))
        d("else if ( ");
      else
        d("if ( ");
      a((IConditionToken)paramList.get(0), paramDecisionRelateRule.getConditions().getConditionList());
      for (i2 = 2; (i2 <= paramDecisionRelateRule.getConditionNum()) && (i2 <= paramList.size()); i2++)
      {
        d(" && ");
        a((IConditionToken)paramList.get(i2 - 1), paramDecisionRelateRule.getNextConditions((IConditionToken)paramList.get(i2 - 2), i2 - 1));
      }
      d(" ) {");
      c();
      b(1);
      if (!e())
      {
        String str = ((IConditionToken)paramList.get(0)).getText();
        for (int i4 = 2; (i4 <= paramDecisionRelateRule.getConditionNum()) && (i4 <= paramList.size()); i4++)
        {
          str = str + u.a("tv_and", "and");
          str = str + ((IConditionToken)paramList.get(i4 - 1)).getText();
        }
        if ((paramDecisionRelateRule.needLog()) && (!paramDecisionRelateRule.needWhile()))
          a(str, "childRuleLog", paramDecisionRelateRule.getRelateVarNames());
      }
      Object localObject;
      for (int i3 = 0; i3 < paramDecisionRelateRule.getValueNum(); i3++)
      {
        if (paramDecisionRelateRule.getDecisionElement(i3 + 1) == null)
          continue;
        localObject = paramDecisionRelateRule.getDecisionElement(i3 + 1).getMemberElement();
        if ((paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject) == null) || (paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject).getValue().length() <= 0))
          continue;
        l();
        if ((localObject instanceof IPropertyObject))
        {
          IPropertyObject localIPropertyObject = (IPropertyObject)localObject;
          d(localIPropertyObject.getSetMethodPreName());
          if (!((IBusinessObject)localObject).getJavaType().a())
            if (((IBusinessObject)localObject).getJavaType().b())
              d("(" + ((IBusinessObject)localObject).getJavaType().K() + ")");
            else if (((IBusinessObject)localObject).getJavaType().r())
              d("(" + ((IBusinessObject)localObject).getJavaType().L() + ")");
          d(paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject).getAssignValue());
          d(localIPropertyObject.getSetMethodSufName());
        }
        else
        {
          d(((IBusinessObject)localObject).getVarValue());
          d(" = ");
          if ((!((IBusinessObject)localObject).getJavaType().a()) && (((IBusinessObject)localObject).getJavaType().b()))
            d("(" + ((IBusinessObject)localObject).getJavaType().K() + ")");
          paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject).getAssignValue().acceptVisitor(this);
        }
        d(";");
        c();
      }
      if ((!e()) && (paramDecisionRelateRule.needLog()) && (!paramDecisionRelateRule.needWhile()))
        a(paramDecisionRelateRule.getAssignVarNames(), "childRuleLog");
      if ((!e()) && (this.m.size() > 0))
      {
        HashMap localHashMap = new HashMap();
        localObject = paramDecisionRelateRule.getDecisionElements();
        for (int i5 = 0; i5 < ((List)localObject).size(); i5++)
        {
          IBusinessObject localIBusinessObject2 = ((DecisionElement)((List)localObject).get(i5)).getMemberElement();
          if ((!(localIBusinessObject2 instanceof IVariableObject)) || (!((IVariableObject)localIBusinessObject2).isLoged()))
            continue;
          localHashMap.put(localIBusinessObject2, localIBusinessObject2);
        }
        a(paramDecisionRelateRule, localHashMap);
      }
      if (!e())
        if (paramDecisionRelateRule.getRestartType() == 1)
          e("if ( true) return  M_RETURN_RESTART;");
        else if (paramDecisionRelateRule.getRestartType() == 2)
          e("if ( true) return  M_RETURN_CONTINUE;");
        else if (paramDecisionRelateRule.getRestartType() == 3)
          e("if ( true) return  M_RETURN_BREAK;");
      c(1);
      e("}");
    }
  }

  public Object visitRuleToken(RuleToken paramRuleToken)
  {
    if (paramRuleToken == null)
      return null;
    this.f = paramRuleToken.getRule();
    int i1 = 0;
    int i2 = 0;
    if ((paramRuleToken.getRule().isSupportEnter()) && (paramRuleToken.hasEnterCondition()))
    {
      if (e())
      {
        g(paramRuleToken.getEnterCondition().getWhenCondition().getText());
        c();
      }
      l();
      d("if ( ");
      localIterator = paramRuleToken.getEnterCondition().getWhenCondition().getConditions();
      if (localIterator.hasNext())
        while (localIterator.hasNext())
          d((IElement)localIterator.next());
      else
        d("true");
      d(" ) {");
      c();
      b(1);
    }
    if (((paramRuleToken.getRule().isSupportInit()) && (paramRuleToken.hasInitAction())) || ((paramRuleToken.getRule().isSupportElse()) && (paramRuleToken.hasElseAction())) || ((paramRuleToken.hasThenOrElseifAction()) && (!e()) && (paramRuleToken.getRule().needLog()) && (!paramRuleToken.getRule().needWhile())))
    {
      a("", "childRuleLog", paramRuleToken.getRule().getRelateVarNames());
      i1 = 1;
    }
    Object localObject1;
    if ((paramRuleToken.getRule().isSupportInit()) && (paramRuleToken.hasInitAction()))
    {
      localIterator = paramRuleToken.getInitActions().getActions();
      while (localIterator.hasNext())
        e((IElement)localIterator.next());
      if (!paramRuleToken.getInitActions().hasTwoReturnToken())
      {
        if ((i1 != 0) && (!paramRuleToken.getRule().needWhile()))
          a(paramRuleToken.getInitActions().getAssignVarNames(), "childRuleLog");
        if ((!e()) && (this.m.size() > 0))
        {
          localObject1 = new HashMap();
          paramRuleToken.getInitActions().findAssignObject((Map)localObject1, true);
          a(paramRuleToken.getRule(), (HashMap)localObject1);
        }
      }
    }
    if ((paramRuleToken.hasCondition()) || (!e()))
    {
      if (e())
      {
        g(paramRuleToken.getWhenCondition().getText());
        c();
      }
      l();
      d("if ( ");
      localIterator = paramRuleToken.getWhenCondition().getConditions();
      if (localIterator.hasNext())
        while (localIterator.hasNext())
          d((IElement)localIterator.next());
      else
        d("true");
      d(" ) {");
      c();
      b(1);
    }
    this.h = true;
    if ((!e()) && (paramRuleToken.getRule().needLog()) && (!paramRuleToken.getRule().needWhile()))
    {
      if (i1 == 0)
        a(paramRuleToken.getWhenCondition().getText(), "childRuleLog", paramRuleToken.getRule().getRelateVarNames());
      else
        a(paramRuleToken.getWhenCondition().getText(), "childRuleLog");
      i1 = 1;
    }
    if ((!e()) && ((paramRuleToken.getRule().getParent() instanceof IRuleSet)) && (((IRuleSet)paramRuleToken.getRule().getParent()).needCheckSubRule()) && (!paramRuleToken.getRule().needWhile()))
      e("recordVisitRule(\"" + paramRuleToken.getRule().getParent().getDisplayName() + "\",\"" + paramRuleToken.getRule().getDisplayName() + "\");");
    Iterator localIterator = paramRuleToken.getThenActions().getActions();
    while (localIterator.hasNext())
    {
      localObject1 = (IElement)localIterator.next();
      e((IElement)localObject1);
    }
    if (!paramRuleToken.getThenActions().hasTwoReturnToken())
    {
      if ((i1 != 0) && (!paramRuleToken.getRule().needWhile()))
        a(paramRuleToken.getThenActions().getAssignVarNames(), "childRuleLog");
      if ((!e()) && (this.m.size() > 0))
      {
        localObject1 = new HashMap();
        paramRuleToken.getThenActions().findAssignObject((Map)localObject1, true);
        a(paramRuleToken.getRule(), (HashMap)localObject1);
      }
      if (!e())
        if (paramRuleToken.getRule().getRestartType() == 1)
          e("if ( true) return  M_RETURN_RESTART;");
        else if (paramRuleToken.getRule().getRestartType() == 2)
          e("if ( true) return  M_RETURN_CONTINUE;");
        else if (paramRuleToken.getRule().getRestartType() == 3)
          e("if ( true) return  M_RETURN_BREAK;");
    }
    this.h = false;
    if ((paramRuleToken.hasCondition()) || (!e()))
    {
      localObject1 = paramRuleToken.getElseIfTokens();
      for (int i3 = 0; i3 < ((List)localObject1).size(); i3++)
        ((ElseIfRuleToken)((List)localObject1).get(i3)).acceptVisitor(this);
      c(1);
      if ((paramRuleToken.getRule().isSupportElse()) && (paramRuleToken.hasElseAction()))
      {
        e("} else {");
        b(1);
        this.h = true;
        if ((!e()) && (paramRuleToken.getRule().needLog()) && (!paramRuleToken.getRule().needWhile()))
        {
          if (i1 == 0)
            a(paramRuleToken.getWhenCondition().getText() + u.a("tv_else", "else"), "childRuleLog", paramRuleToken.getRule().getRelateVarNames());
          else
            a(paramRuleToken.getWhenCondition().getText() + u.a("tv_else", "else"), "childRuleLog");
          i1 = 1;
        }
        if ((!e()) && ((paramRuleToken.getRule().getParent() instanceof IRuleSet)) && (((IRuleSet)paramRuleToken.getRule().getParent()).needCheckSubRule()) && (!paramRuleToken.getRule().needWhile()))
          e("recordVisitRule(\"" + paramRuleToken.getRule().getParent().getShowDisplayName() + "\",\"" + paramRuleToken.getRule().getDisplayName() + "\");");
        i2 = 0;
        localIterator = paramRuleToken.getElseActions().getActions();
        Object localObject2;
        while (localIterator.hasNext())
        {
          localObject2 = (IElement)localIterator.next();
          e((IElement)localObject2);
        }
        if (!paramRuleToken.getElseActions().hasTwoReturnToken())
        {
          if ((i1 != 0) && (!paramRuleToken.getRule().needWhile()))
            a(paramRuleToken.getElseActions().getAssignVarNames(), "childRuleLog");
          if ((!e()) && (this.m.size() > 0))
          {
            localObject2 = new HashMap();
            paramRuleToken.getElseActions().findAssignObject((Map)localObject2, true);
            a(paramRuleToken.getRule(), (HashMap)localObject2);
          }
          if (!e())
            if (paramRuleToken.getRule().getRestartType() == 1)
              e("if ( true) return  M_RETURN_RESTART;");
            else if (paramRuleToken.getRule().getRestartType() == 2)
              e("if ( true) return  M_RETURN_CONTINUE;");
            else if (paramRuleToken.getRule().getRestartType() == 3)
              e("if ( true) return  M_RETURN_BREAK;");
        }
        this.h = false;
        c(1);
      }
      e("}");
    }
    if ((paramRuleToken.getRule().isSupportEnter()) && (paramRuleToken.hasEnterCondition()))
    {
      c(1);
      e("}");
    }
    return null;
  }

  public Object visitElseIfRuleToken(ElseIfRuleToken paramElseIfRuleToken)
  {
    if ((paramElseIfRuleToken.hasCondition()) || (!e()))
    {
      c(1);
      if (e())
      {
        g(paramElseIfRuleToken.getWhenCondition().getText());
        c();
      }
      l();
      d("} else if ( ");
      localIterator = paramElseIfRuleToken.getWhenCondition().getConditions();
      if (localIterator.hasNext())
        while (localIterator.hasNext())
          d((IElement)localIterator.next());
      else
        d("true");
      d(" ) {");
      c();
      b(1);
    }
    this.h = true;
    if ((!e()) && (paramElseIfRuleToken.getRule().needLog()) && (!paramElseIfRuleToken.getRule().needWhile()))
      a(paramElseIfRuleToken.getWhenCondition().getText(), "childRuleLog", paramElseIfRuleToken.getRule().getRelateVarNames());
    if ((!e()) && ((paramElseIfRuleToken.getRule().getParent() instanceof IRuleSet)) && (((IRuleSet)paramElseIfRuleToken.getRule().getParent()).needCheckSubRule()) && (!paramElseIfRuleToken.getRule().needWhile()))
      e("recordVisitRule(\"" + paramElseIfRuleToken.getRule().getParent().getShowDisplayName() + "\",\"" + paramElseIfRuleToken.getRule().getDisplayName() + "\");");
    Iterator localIterator = paramElseIfRuleToken.getThenActions().getActions();
    int i1 = 0;
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (IElement)localIterator.next();
      e((IElement)localObject);
    }
    if (!paramElseIfRuleToken.getThenActions().hasTwoReturnToken())
    {
      if ((!e()) && (paramElseIfRuleToken.getRule().needLog()) && (!paramElseIfRuleToken.getRule().needWhile()))
        a(paramElseIfRuleToken.getThenActions().getAssignVarNames(), "childRuleLog");
      if ((!e()) && (this.m.size() > 0))
      {
        localObject = new HashMap();
        paramElseIfRuleToken.getThenActions().findAssignObject((Map)localObject, true);
        a(paramElseIfRuleToken.getRule(), (HashMap)localObject);
      }
      if (!e())
        if (paramElseIfRuleToken.getRule().getRestartType() == 1)
          e("if ( true) return  M_RETURN_RESTART;");
        else if (paramElseIfRuleToken.getRule().getRestartType() == 2)
          e("if ( true) return  M_RETURN_CONTINUE;");
        else if (paramElseIfRuleToken.getRule().getRestartType() == 3)
          e("if ( true) return  M_RETURN_BREAK;");
    }
    this.h = false;
    return null;
  }

  private void c(RulePackage paramRulePackage)
  {
    Iterator localIterator1 = paramRulePackage.getEnvionment().getClassContainers();
    while (localIterator1.hasNext())
    {
      localObject1 = localIterator1.next();
      if (!(localObject1 instanceof ClassContainer))
        continue;
      localObject2 = (ClassContainer)localObject1;
      e(((ClassContainer)localObject2).getValueType() + " " + ((ClassContainer)localObject2).getVarValue() + " ;" + "  //  " + ((ClassContainer)localObject2).getDisplayName());
    }
    localIterator1 = paramRulePackage.getEnvionment().getInterfaceContainers();
    while (localIterator1.hasNext())
    {
      localObject1 = localIterator1.next();
      if (!(localObject1 instanceof InterfaceContainer))
        continue;
      localObject2 = (InterfaceContainer)localObject1;
      e(((InterfaceContainer)localObject2).getValueType() + " " + ((InterfaceContainer)localObject2).getVarValue() + " ;" + "  //  " + ((InterfaceContainer)localObject2).getDisplayName());
    }
    localIterator1 = paramRulePackage.getEnvionment().getValueLibrary().getChildrenIterator();
    while (localIterator1.hasNext())
    {
      localObject1 = localIterator1.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      if (((IVariableObject)localObject2).getJavaType().m())
      {
        if (paramRulePackage.getStringinit() == RulePackage.STRINGEMPTY)
          e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = \"\" ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
        else
          e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
      }
      else if (((IVariableObject)localObject2).getJavaType().s())
      {
        if (((IVariableObject)localObject2).getJavaType().P())
          e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = new java.util.ArrayList(0) ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
        else
          e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = null ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
      }
      else if ((((IVariableObject)localObject2).getJavaType().n()) && (((IVariableObject)localObject2).getJavaType().I() > 0))
        e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = new " + o.c(((IVariableObject)localObject2).getJavaType()) + " ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
      else if (((IVariableObject)localObject2).getJavaType().o())
      {
        if (((IVariableObject)localObject2).getJavaType().O())
          e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = new java.util.HashMap(0) ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
        else
          e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = null ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
      }
      else if (((IVariableObject)localObject2).getJavaType().q())
        e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = null ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
      else
        e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
    }
    localIterator1 = paramRulePackage.getEnvionment().getTempVariableLibrary().getChildrenIterator();
    while (localIterator1.hasNext())
    {
      localObject1 = localIterator1.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      if (((IVariableObject)localObject2).getJavaType().m())
      {
        if (paramRulePackage.getStringinit() == RulePackage.STRINGEMPTY)
          e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = \"\" ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
        else
          e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
      }
      else if (((IVariableObject)localObject2).getJavaType().s())
      {
        if (((IVariableObject)localObject2).getJavaType().P())
          e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = new java.util.ArrayList(0) ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
        else
          e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = null ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
      }
      else if ((((IVariableObject)localObject2).getJavaType().n()) && (((IVariableObject)localObject2).getJavaType().I() > 0))
        e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = new " + o.c(((IVariableObject)localObject2).getJavaType()) + " ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
      else if (((IVariableObject)localObject2).getJavaType().o())
      {
        if (((IVariableObject)localObject2).getJavaType().O())
          e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = new java.util.HashMap(0) ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
        else
          e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = null ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
      }
      else if (((IVariableObject)localObject2).getJavaType().q())
        e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " = null ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
      else
        e(o.b(((IVariableObject)localObject2).getJavaType()) + " " + ((IVariableObject)localObject2).getVarValue() + " ;" + "  //  " + ((IVariableObject)localObject2).getDisplayName());
    }
    e("private RuleEngineWriter out = null ; ");
    if (!this.d)
      e("private RuleLogList childRuleLog = null ; ");
    e("private RuleLogList rootRuleLog = null ; ");
    e("private Map rootRuleCheckMap = null ; ");
    e("private java.util.List snapShot = null ; ");
    Object localObject1 = paramRulePackage.getEnvionment().getAcceptElements(new k(this));
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SheetTable)((Iterator)localObject1).next();
      e("private Sheet " + ((SheetTable)localObject2).getVarValue() + ";" + "  //  " + ((SheetTable)localObject2).getDisplayName());
    }
    Object localObject2 = paramRulePackage.getEnvionment().getAcceptElements(new l(this));
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (SheetMap)((Iterator)localObject2).next();
      e("private IKeyValue " + ((SheetMap)localObject3).getVarValue() + ";" + "  //  " + ((SheetMap)localObject3).getDisplayName());
    }
    Object localObject3 = paramRulePackage.getEnvionment().getDBModels();
    HashMap localHashMap = new HashMap();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (DBModel)((Iterator)localObject3).next();
      if (localHashMap.get(((DBModel)localObject4).getVarValue()) == null)
      {
        if ((((DBModel)localObject4).getConnType() == 2) || (((DBModel)localObject4).getConnType() == 3))
          e("private Database " + ((DBModel)localObject4).getVarValue() + ";");
        else
          e("private Database " + ((DBModel)localObject4).getVarValue() + ";");
        localHashMap.put(((DBModel)localObject4).getVarValue(), localObject4);
      }
      localIterator2 = ((DBModel)localObject4).getTypeSuperChildren(IBOAndContainer.class);
      while (localIterator2.hasNext())
      {
        localObject5 = (IBOAndContainer)localIterator2.next();
        if ((localObject5 instanceof TableModel))
        {
          e("private Table " + ((IBOAndContainer)localObject5).getVarValue() + ";" + "  //  " + ((IBOAndContainer)localObject5).getDisplayName());
        }
        else if ((localObject5 instanceof SelectTable))
        {
          e("private Select " + ((IBOAndContainer)localObject5).getVarValue() + ";" + "  //  " + ((IBOAndContainer)localObject5).getDisplayName());
        }
        else if ((localObject5 instanceof ProcedureModel))
        {
          e("private Procedure " + ((IBOAndContainer)localObject5).getVarValue() + ";" + "  //  " + ((IBOAndContainer)localObject5).getDisplayName());
        }
        else
        {
          if (!(localObject5 instanceof SheetTable))
            continue;
          e("private Sheet " + ((IBOAndContainer)localObject5).getVarValue() + ";" + "  //  " + ((IBOAndContainer)localObject5).getDisplayName());
        }
      }
    }
    localObject3 = paramRulePackage.getEnvionment().getExcelBookModels();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (ExcelBookModel)((Iterator)localObject3).next();
      e("private IExcelBook " + ((ExcelBookModel)localObject4).getVarValue() + ";");
      localIterator2 = ((ExcelBookModel)localObject4).getTypeSuperChildren(IExcelObject.class);
      while (localIterator2.hasNext())
      {
        localObject5 = (IExcelObject)localIterator2.next();
        if ((localObject5 instanceof ExcelXYSheetModel))
        {
          e("private IExcelXYSheet " + ((IExcelObject)localObject5).getVarValue() + ";" + "  //  " + ((IExcelObject)localObject5).getDisplayName());
        }
        else if ((localObject5 instanceof ExcelTableSheetModel))
        {
          e("private IExcelTableSheet " + ((IExcelObject)localObject5).getVarValue() + ";" + "  //  " + ((IExcelObject)localObject5).getDisplayName());
        }
        else
        {
          if (!(localObject5 instanceof ExcelSheetModel))
            continue;
          e("private IExcelSheet " + ((IExcelObject)localObject5).getVarValue() + ";" + "  //  " + ((IExcelObject)localObject5).getDisplayName());
        }
      }
    }
    Object localObject4 = paramRulePackage.getEnvionment().getXmlNodes();
    while (((Iterator)localObject4).hasNext())
      a((XmlNode)((Iterator)localObject4).next());
    Iterator localIterator2 = paramRulePackage.getEnvionment().getSoapServices();
    while (localIterator2.hasNext())
      e("private com.flagleader.soap.ISoap " + ((SoapService)localIterator2.next()).getVarValue() + " =null;");
    Object localObject5 = paramRulePackage.getEnvionment().getTreeNodes();
    while (((Iterator)localObject5).hasNext())
      e("private TreeValue " + ((TreeValueNode)((Iterator)localObject5).next()).getVarValue() + " =null;");
  }

  private void a(XmlNode paramXmlNode)
  {
    e("private Node " + paramXmlNode.getVarValue() + " =null;");
    Iterator localIterator = paramXmlNode.getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof XmlNode))
        continue;
      a((XmlNode)localObject);
    }
  }

  private void d(RulePackage paramRulePackage)
  {
    e("if ( dtcObjects.get(\"out\") != null && dtcObjects.get(\"out\") instanceof RuleEngineWriter ) {");
    e("\tout=(RuleEngineWriter)dtcObjects.get(\"out\") ;");
    e("} else if ( dtcObjects.get(\"out\") != null && dtcObjects.get(\"out\") instanceof java.io.OutputStream ) {");
    e("\tout=new RuleEngineWriter((java.io.OutputStream)dtcObjects.get(\"out\")) ;");
    e("} else if ( dtcObjects.get(\"out\") != null && dtcObjects.get(\"out\") instanceof java.io.Writer ) {");
    e("\tout=new RuleEngineWriter((java.io.Writer)dtcObjects.get(\"out\")) ;");
    e("}");
    e("if ( dtcObjects.get(\"ruleLog\") != null && dtcObjects.get(\"ruleLog\") instanceof RuleLogList && rootRuleLog == null ) {");
    e("\trootRuleLog=(RuleLogList)dtcObjects.get(\"ruleLog\") ;");
    e("\trootRuleLog.setRuleName(\"" + b(paramRulePackage.toString()) + "\");");
    e("}");
    e("if ( dtcObjects.get(\"ruleCheckMap\") != null && dtcObjects.get(\"ruleCheckMap\") instanceof Map && rootRuleCheckMap == null ) {");
    e("\trootRuleCheckMap=(Map)dtcObjects.get(\"ruleCheckMap\") ;");
    e("}");
    e("if ( dtcObjects.get(\"snapShot\") != null && dtcObjects.get(\"snapShot\") instanceof List && snapShot == null ) {");
    e("\tsnapShot=(List)dtcObjects.get(\"snapShot\") ;");
    e("}");
    Iterator localIterator = paramRulePackage.getEnvionment().getXmlNodes();
    while (localIterator.hasNext())
    {
      localObject1 = (XmlNode)localIterator.next();
      if (((XmlNode)localObject1).getLoadType() == 0)
      {
        e("if ( dtcObjects.get(\"" + ((XmlNode)localObject1).getValueName() + "\") != null && dtcObjects.get(\"" + ((XmlNode)localObject1).getValueName() + "\") instanceof String ) {");
        e(((XmlNode)localObject1).getVarValue() + " =XmlFactory.newIntance().loadNode(dtcObjects.get(\"" + ((XmlNode)localObject1).getValueName() + "\").toString(),\"" + ((XmlNode)localObject1).getNodeName() + "\");");
        e("} else if ( " + ((XmlNode)localObject1).getVarValue() + " == null ) {");
        e(((XmlNode)localObject1).getVarValue() + " =XmlFactory.newIntance().newNode(\"" + ((XmlNode)localObject1).getNodeName() + "\");");
        e("}");
      }
      else if (((XmlNode)localObject1).getLoadType() == 1)
      {
        e("if ( dtcObjects.get(\"" + ((XmlNode)localObject1).getValueName() + "\") != null && dtcObjects.get(\"" + ((XmlNode)localObject1).getValueName() + "\") instanceof Node ) {");
        e(((XmlNode)localObject1).getVarValue() + " =(Node)(dtcObjects.get(\"" + ((XmlNode)localObject1).getValueName() + "\"));");
        e("} else if ( " + ((XmlNode)localObject1).getVarValue() + "== null ) {");
        e(((XmlNode)localObject1).getVarValue() + " =XmlFactory.newIntance().newNode(\"" + ((XmlNode)localObject1).getNodeName() + "\");");
        e("}");
      }
      else if (((XmlNode)localObject1).getLoadType() == 2)
      {
        e(((XmlNode)localObject1).getVarValue() + " =XmlFactory.newIntance().loadFile(\"" + ((XmlNode)localObject1).getResourceName() + "\");");
      }
      else if (((XmlNode)localObject1).getLoadType() == 3)
      {
        e(" if ( " + ((XmlNode)localObject1).getVarValue() + "== null ) ");
        e(((XmlNode)localObject1).getVarValue() + " =XmlFactory.newIntance().newNode(\"" + ((XmlNode)localObject1).getNodeName() + "\");");
      }
      e(((XmlNode)localObject1).getVarValue() + ".setEncoding(\"" + ((XmlNode)localObject1).getEncoding() + "\");");
      b((XmlNode)localObject1);
    }
    Object localObject1 = paramRulePackage.getEnvionment().getTreeNodes();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TreeValueNode)((Iterator)localObject1).next();
      e("init" + ((TreeValueNode)localObject2).getUuid() + "();");
    }
    Object localObject2 = paramRulePackage.getEnvionment().getClassContainers();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (!(localObject3 instanceof ClassContainer))
        continue;
      localObject4 = (ClassContainer)localObject3;
      if (((ClassContainer)localObject4).isLoadContext())
        e("if ( class_objects == null ) class_objects= new ArrayList() ;");
      if (((ClassContainer)localObject4).isSingleValue())
        d(((ClassContainer)localObject4).getVarValue() + " = new SingleClassValue(" + ((ClassContainer)localObject4).getBusinessObjectClass().getClassName() + ".class");
      else
        d(((ClassContainer)localObject4).getVarValue() + " = new MultiClassValue(" + ((ClassContainer)localObject4).getBusinessObjectClass().getClassName() + ".class");
      if (((ClassContainer)localObject4).isLoadContext())
        d(",class_objects");
      else
        d(",null");
      if ((((ClassContainer)localObject4).getMultiType() == 1) || (((ClassContainer)localObject4).getMultiType() == 3))
        e(",true);");
      else
        e(",false);");
    }
    localObject2 = paramRulePackage.getEnvionment().getInterfaceContainers();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (!(localObject3 instanceof InterfaceContainer))
        continue;
      localObject4 = (InterfaceContainer)localObject3;
      e("if ( dtcObjects.get(\"" + ((InterfaceContainer)localObject4).getValueName() + "\") != null && dtcObjects.get(\"" + ((InterfaceContainer)localObject4).getValueName() + "\") instanceof " + ((InterfaceContainer)localObject4).getInterfaceName() + " ) ");
      e(((InterfaceContainer)localObject4).getVarValue() + " =(" + ((InterfaceContainer)localObject4).getInterfaceName() + ")(dtcObjects.get(\"" + ((InterfaceContainer)localObject4).getValueName() + "\"));");
      if (((InterfaceContainer)localObject4).getInitStatement().length() <= 0)
        continue;
      e("else " + ((InterfaceContainer)localObject4).getVarValue() + " = " + ((InterfaceContainer)localObject4).getInitStatement() + ";");
    }
    localObject2 = paramRulePackage.getEnvionment().getValueLibrary().getChildrenIterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (!(localObject3 instanceof IVariableObject))
        continue;
      localObject4 = (IVariableObject)localObject3;
      e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") != null ) ");
      b(1);
      if (((IVariableObject)localObject4).getJavaType().e())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof Boolean ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = ((Boolean)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\")).booleanValue();");
        c(1);
        e("else if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof Number ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = (((Number)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\")).doubleValue() != 0) ;");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = NumberUtil.parseBoolean(dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\").toString()) ;");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().d())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof Character ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = ((Character)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\")).charValue();");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\").toString().charAt(0);");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().g())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof Number ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = ((Number)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\")).shortValue();");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = NumberUtil.parseShort(dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\").toString());");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().k())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof Number ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = ((Number)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\")).intValue();");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = NumberUtil.parseInt(dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\").toString());");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().h())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof Number ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = ((Number)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\")).longValue();");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = NumberUtil.parseLong(dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\").toString());");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().c())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof Number ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = ((Number)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\")).floatValue();");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = NumberUtil.parseFloat(dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\").toString());");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().i())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof Number ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = ((Number)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\")).doubleValue();");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = NumberUtil.parseDouble(dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\").toString());");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().j())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof java.math.BigDecimal ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = (java.math.BigDecimal)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\");");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = new java.math.BigDecimal(dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\").toString());");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().f())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof Byte ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = ((Byte)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\")).byteValue();");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = new Byte(dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\").toString()).byteValue();");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().v())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof String ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = DateUtil.formatDate((String)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\"));");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = (" + o.d(((IVariableObject)localObject4).getJavaType()) + ")dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") ;");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().w())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof String ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = DateUtil.formatTime((String)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\"));");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = (" + o.d(((IVariableObject)localObject4).getJavaType()) + ")dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") ;");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().x())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof String ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = DateUtil.formatDatetime((String)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\"));");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = (" + o.d(((IVariableObject)localObject4).getJavaType()) + ")dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") ;");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().s())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof String ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = ListUtil.stringToList((String)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\"),\"" + ((IVariableObject)localObject4).getValueType() + "\");");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = (" + o.d(((IVariableObject)localObject4).getJavaType()) + ")dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") ;");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().q())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof String ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = new java.io.File((String)dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\"));");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = (" + o.d(((IVariableObject)localObject4).getJavaType()) + ")dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") ;");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().z())
      {
        e("if ( dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") instanceof byte[] ) ");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = (byte[])dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\");");
        c(1);
        e("else");
        b(1);
        e(((IVariableObject)localObject4).getVarValue() + " = (dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\").toString()).getBytes();");
        c(1);
      }
      else if (((IVariableObject)localObject4).getJavaType().m())
      {
        e(((IVariableObject)localObject4).getVarValue() + " = dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\").toString();");
      }
      else
      {
        e(((IVariableObject)localObject4).getVarValue() + " = (" + o.d(((IVariableObject)localObject4).getJavaType()) + ")dtcObjects.get(\"" + ((IVariableObject)localObject4).getVariableName() + "\") ;");
      }
      c(1);
    }
  }

  private void e(RulePackage paramRulePackage)
  {
    e("if (snapShot != null ) dtcObjects.put(\"snapShot\",snapShot);");
    Iterator localIterator = paramRulePackage.getEnvionment().getValueLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      if (((IVariableObject)localObject2).getJavaType().e())
        e("dtcObjects.put(\"" + ((IVariableObject)localObject2).getVariableName() + "\",new Boolean(" + ((IVariableObject)localObject2).getVarValue() + "));");
      else if (((IVariableObject)localObject2).getJavaType().d())
        e("dtcObjects.put(\"" + ((IVariableObject)localObject2).getVariableName() + "\",new Character(" + ((IVariableObject)localObject2).getVarValue() + "));");
      else if (((IVariableObject)localObject2).getJavaType().g())
        e("dtcObjects.put(\"" + ((IVariableObject)localObject2).getVariableName() + "\",new Short(" + ((IVariableObject)localObject2).getVarValue() + "));");
      else if (((IVariableObject)localObject2).getJavaType().k())
        e("dtcObjects.put(\"" + ((IVariableObject)localObject2).getVariableName() + "\",new Integer(" + ((IVariableObject)localObject2).getVarValue() + "));");
      else if (((IVariableObject)localObject2).getJavaType().h())
        e("dtcObjects.put(\"" + ((IVariableObject)localObject2).getVariableName() + "\",new Long(" + ((IVariableObject)localObject2).getVarValue() + "));");
      else if (((IVariableObject)localObject2).getJavaType().c())
        e("dtcObjects.put(\"" + ((IVariableObject)localObject2).getVariableName() + "\",new Float(" + ((IVariableObject)localObject2).getVarValue() + "));");
      else if (((IVariableObject)localObject2).getJavaType().i())
        e("dtcObjects.put(\"" + ((IVariableObject)localObject2).getVariableName() + "\",new Double(" + ((IVariableObject)localObject2).getVarValue() + "));");
      else if (((IVariableObject)localObject2).getJavaType().f())
        e("dtcObjects.put(\"" + ((IVariableObject)localObject2).getVariableName() + "\",new Byte(" + ((IVariableObject)localObject2).getVarValue() + "));");
      else
        e("dtcObjects.put(\"" + ((IVariableObject)localObject2).getVariableName() + "\"," + ((IVariableObject)localObject2).getVarValue() + ");");
    }
    Object localObject1 = paramRulePackage.getEnvionment().getDBModels();
    Object localObject2 = new HashMap();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (DBModel)((Iterator)localObject1).next();
      if (((HashMap)localObject2).get(((DBModel)localObject3).getVarValue()) != null)
        continue;
      e("dtcObjects.put(\"" + ((DBModel)localObject3).getValueName() + "\"," + ((DBModel)localObject3).getVarValue() + ");");
      ((HashMap)localObject2).put(((DBModel)localObject3).getVarValue(), localObject3);
    }
    localObject1 = paramRulePackage.getEnvionment().getExcelBookModels();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (ExcelBookModel)((Iterator)localObject1).next();
      e("dtcObjects.put(\"" + ((ExcelBookModel)localObject3).getValueName() + "\"," + ((ExcelBookModel)localObject3).getVarValue() + ");");
    }
    Object localObject3 = paramRulePackage.getEnvionment().getAcceptElements(new m(this));
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (SheetTable)((Iterator)localObject3).next();
      e("dtcObjects.put(\"" + ((SheetTable)localObject4).getValueName() + "\"," + ((SheetTable)localObject4).getVarValue() + ");");
    }
    Object localObject4 = paramRulePackage.getEnvionment().getAcceptElements(new n(this));
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (SheetMap)((Iterator)localObject4).next();
      e("dtcObjects.put(\"" + ((SheetMap)localObject5).getValueName() + "\"," + ((SheetMap)localObject5).getVarValue() + ".allData());");
    }
    Object localObject5 = paramRulePackage.getEnvionment().getXmlNodes();
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (XmlNode)((Iterator)localObject5).next();
      if (((XmlNode)localObject6).getLoadType() == 0)
      {
        e("dtcObjects.put(\"" + ((XmlNode)localObject6).getValueName() + "\"," + ((XmlNode)localObject6).getVarValue() + ".getContent());");
      }
      else if (((XmlNode)localObject6).getLoadType() == 1)
      {
        e("dtcObjects.put(\"" + ((XmlNode)localObject6).getValueName() + "\"," + ((XmlNode)localObject6).getVarValue() + ");");
      }
      else
      {
        if (((XmlNode)localObject6).getLoadType() != 2)
          continue;
        e(((XmlNode)localObject6).getVarValue() + ".save();");
      }
    }
    Object localObject6 = paramRulePackage.getEnvionment().getTreeNodes();
    Object localObject7;
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = (TreeValueNode)((Iterator)localObject6).next();
      e("dtcObjects.put(\"" + ((TreeValueNode)localObject7).getValueName() + "\"," + ((TreeValueNode)localObject7).getVarValue() + ");");
    }
    localObject6 = paramRulePackage.getEnvionment().getInterfaceContainers();
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = (InterfaceContainer)((Iterator)localObject6).next();
      e("dtcObjects.put(\"" + ((InterfaceContainer)localObject7).getValueName() + "\"," + ((InterfaceContainer)localObject7).getVarValue() + ");");
    }
  }

  private void b(XmlNode paramXmlNode)
  {
    Iterator localIterator = paramXmlNode.getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof XmlNode))
        continue;
      XmlNode localXmlNode = (XmlNode)localObject;
      if (localXmlNode.getMultiType() != 1)
        continue;
      e("if (" + paramXmlNode.getVarValue() + " != null ) " + localXmlNode.getVarValue() + " = " + paramXmlNode.getVarValue() + ".getNode(\"" + localXmlNode.getNodeName() + "\");");
      b(localXmlNode);
    }
  }

  private void f(RulePackage paramRulePackage)
  {
    Iterator localIterator = paramRulePackage.getEnvionment().getCustomFunction();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof CustomFunction))
        continue;
      FunctionMember localFunctionMember = ((CustomFunction)localObject).getFunctionMember();
      e(localFunctionMember.getFunction());
    }
  }

  private void c(XmlNode paramXmlNode)
  {
    Iterator localIterator = paramXmlNode.getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof XmlNode))
        continue;
      XmlNode localXmlNode = (XmlNode)localObject;
      e("if ( nodeName.equals(\"" + localXmlNode.getVarName() + "\") ) {");
      b(1);
      if ((localXmlNode.getMultiType() == 1) || (localXmlNode.getMultiType() == 0))
        e(localXmlNode.getVarValue() + " = " + paramXmlNode.getVarValue() + ".getNode(\"" + localXmlNode.getNodeName() + "\");");
      else
        e(localXmlNode.getVarValue() + " = " + paramXmlNode.getVarValue() + ".createChild(\"" + localXmlNode.getNodeName() + "\");");
      b(localXmlNode);
      e("return " + localXmlNode.getVarValue() + ";");
      c(1);
      e("}");
      c(localXmlNode);
    }
  }

  private void a(RulePoolFlow paramRulePoolFlow, List paramList, int paramInt)
  {
    this.f = paramRulePoolFlow;
    f(paramRulePoolFlow.getDisplayName());
    if (paramRulePoolFlow.isSyn())
      e("private synchronized int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    else
      e("private int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    b(1);
    if (paramRulePoolFlow.isRunBreak())
      e("int rt= M_RETURN_EXIT;");
    else
      e("int rt = M_RETURN_DEFAULT ;");
    if (!paramRulePoolFlow.isActived())
      e("if ( true ) return M_RETURN_DEFAULT;");
    e("try {");
    b(1);
    if (paramRulePoolFlow.getStartTime() != 0L)
      e("if ( getCurrentTime() < " + paramRulePoolFlow.getStartTime() + "L ) return M_RETURN_DEFAULT ;");
    if (paramRulePoolFlow.getEndTime() != 0L)
      e("if ( getCurrentTime() > " + paramRulePoolFlow.getEndTime() + "L ) return M_RETURN_DEFAULT ;");
    a(paramRulePoolFlow, paramList);
    c(1);
    e("} catch (Exception e) {");
    if (paramRulePoolFlow.isSupportCatch())
    {
      b(1);
      Iterator localIterator = paramRulePoolFlow.getRuleSetToken().getCatchActions().getActions();
      while (localIterator.hasNext())
        e((IElement)localIterator.next());
      c(1);
    }
    e("if ( e instanceof RuleEngineException ) throw e ;");
    if (paramRulePoolFlow.getExceptionType() == 0)
      e("\tthrow e ;");
    else if (paramRulePoolFlow.getExceptionType() == 1)
    {
      if (paramRulePoolFlow.getErrorMsg().length() > 0)
        e(" throw new RuleEngineException(\"" + h(paramRulePoolFlow.getErrorMsg()) + "\",e);");
      else
        e(" throw new RuleEngineException(\"" + h(b(paramRulePoolFlow)) + "\",e);");
    }
    else if (paramRulePoolFlow.getExceptionType() == 2)
    {
      if (paramRulePoolFlow.getErrorMsg().length() > 0)
        e(" throw new RuleEngineException(\"" + h(paramRulePoolFlow.getErrorMsg()) + "\"+e.getLocalizedMessage(),e);");
      else
        e(" throw new RuleEngineException(\"" + h(b(paramRulePoolFlow)) + "\"+e.getLocalizedMessage(),e);");
    }
    else
      paramRulePoolFlow.getExceptionType();
    e("} catch (Throwable e1) {");
    if (paramRulePoolFlow.getErrorMsg().length() > 0)
      e(" throw new RuleEngineException(\"" + h(paramRulePoolFlow.getErrorMsg()) + "\",e1);");
    else
      e(" throw new RuleEngineException(\"" + h(b(paramRulePoolFlow)) + "\"+e1.getMessage(),e1);");
    e("}");
    e("return rt;");
    c(1);
    e("}");
  }

  private void a(RulePoolFlow paramRulePoolFlow, List paramList)
  {
    if ((paramRulePoolFlow.isEmpty()) || (!paramRulePoolFlow.isActived()))
      return;
    this.f = paramRulePoolFlow;
    if ((paramRulePoolFlow.getStartTime() != 0L) && (paramRulePoolFlow.getEndTime() != 0L))
      e("if ( getCurrentTime() >= " + paramRulePoolFlow.getStartTime() + "L  &&  getCurrentTime() <= " + paramRulePoolFlow.getEndTime() + "L ) { ");
    else if (paramRulePoolFlow.getStartTime() != 0L)
      e("if ( getCurrentTime() >= " + paramRulePoolFlow.getStartTime() + "L ) {");
    else if (paramRulePoolFlow.getEndTime() != 0L)
      e("if ( getCurrentTime() <= " + paramRulePoolFlow.getEndTime() + "L ) {");
    if ((paramRulePoolFlow.getStartTime() != 0L) || (paramRulePoolFlow.getEndTime() != 0L))
      b(1);
    if ((!e()) && (paramRulePoolFlow.needLog()))
      a(paramRulePoolFlow, paramRulePoolFlow.isEnableDataSnap());
    if ((!e()) && (paramRulePoolFlow.noChildLog()))
      a(paramRulePoolFlow.getInfo(), "childRuleLog", paramRulePoolFlow.getRelateVarNames());
    a(paramRulePoolFlow);
    List localList1 = paramRulePoolFlow.getPoolValues();
    if (localList1.size() > 0)
    {
      e("RulePoolValues rulepoolvalues = new RulePoolValues();");
      l();
      d("while ( rulepoolvalues.changeValues(new Object[]{");
      for (int i1 = 0; i1 < localList1.size(); i1++)
      {
        if (i1 > 0)
          d(",");
        d("RulePoolValues.getObject(");
        ((RulePoolValue)localList1.get(i1)).acceptVisitor(this);
        d(")");
      }
      d("}) ) {");
      c();
    }
    List localList2 = paramRulePoolFlow.getPoolNodes();
    for (int i2 = 0; i2 < localList2.size(); i2++)
    {
      Object localObject1 = localList2.get(i2);
      if ((localObject1 == null) || (!(localObject1 instanceof RulePoolNode)))
        continue;
      RulePoolNode localRulePoolNode = (RulePoolNode)localObject1;
      if (localRulePoolNode.hasGetAndSet())
      {
        if (!e())
          e("if ( true ) {");
        d("RuleEngine engine = getEngineFactory().getRuleEngine() ;");
        c();
        List localList3 = localRulePoolNode.getSelectedFields();
        for (int i3 = 0; i3 < localList3.size(); i3++)
        {
          localObject2 = (PackageFieldGet)localList3.get(i3);
          l();
          d("engine.put(\"" + ((PackageFieldGet)localObject2).getFuncName() + "\", ");
          ((PackageFieldGet)localObject2).getAssignValue().acceptVisitor(this);
          d(") ;");
          c();
        }
        e("if ( class_objects != null ) engine.putObjects(class_objects) ;");
        e("if ( out != null ) engine.put(\"out\",out) ;");
        if ((!e()) && (this.d) && (paramRulePoolFlow.needLog()))
        {
          str = localRulePoolNode.getDisplayName();
          e("RuleLogList exelog = null;");
          if (this.l.equals("true"))
            e("if (childRuleLog != null ) {");
          else
            e("if (childRuleLog != null  && " + this.l + ") {");
          e("\texelog = new RuleLogList(\"" + b(str) + "\");");
          e("\tchildRuleLog.addLog(exelog);");
          e("\tengine.put(\"ruleLog\",exelog);");
          e("if (snapShot!=null) engine.put(\"snapShot\",snapShot);");
          localObject2 = localRulePoolNode.getExeRuleName();
          if ((((String)localObject2).startsWith("{")) && (((String)localObject2).endsWith("}")))
          {
            localObject3 = paramRulePoolFlow.getEnvionment().getBusinessDisName(((String)localObject2).substring(1, ((String)localObject2).length() - 1));
            if (localObject3 != null)
              e("\texelog.setRuleProcess(" + ((IBusinessObject)localObject3).getVarValue() + ") ;");
            else
              e("\texelog.setRuleProcess(\"" + b(localRulePoolNode.getExeRuleName()) + "\") ;");
          }
          else
          {
            e("\texelog.setRuleProcess(\"" + b(localRulePoolNode.getExeRuleName()) + "\") ;");
          }
          localObject3 = "";
          for (i4 = 0; i4 < localList3.size(); i4++)
            localObject3 = localObject3 + "\"" + b(((PackageFieldGet)localList3.get(i4)).getFuncName()) + "\",";
          if (((String)localObject3).length() > 0)
          {
            e("try {");
            d("\texelog.setFieldInits(new String[]{" + ((String)localObject3).substring(0, ((String)localObject3).length() - 1) + "},new String[]{");
            for (i4 = 0; i4 < localList3.size(); i4++)
            {
              d("StringUtil.stringValue(");
              ((PackageFieldGet)localList3.get(i4)).getAssignValue().acceptVisitor(this);
              d(")");
              if (i4 >= localList3.size() - 1)
                continue;
              d(",");
            }
            e("}) ;");
            e("} catch (Throwable ethrowable) {}");
          }
          e("} else {");
          e("if (ruleLog != null && childRuleLog == null ) {");
          e("\tchildRuleLog = new RuleLogList(\"" + b(str) + "\");");
          e("\truleLog.addLog(childRuleLog); } ");
          e("\tengine.put(\"ruleLog\",childRuleLog);");
          e("if (snapShot!=null) engine.put(\"snapShot\",snapShot);");
          e("}");
        }
        String str = localRulePoolNode.getExeRuleName();
        Object localObject2 = "\"" + localRulePoolNode.getExeRuleName() + "\"";
        if ((str.startsWith("{")) && (str.endsWith("}")))
        {
          localObject3 = paramRulePoolFlow.getEnvionment().getBusinessDisName(str.substring(1, str.length() - 1));
          if (localObject3 != null)
            localObject2 = ((IBusinessObject)localObject3).getVarValue();
        }
        e("engine.excute(" + (String)localObject2 + ") ;");
        Object localObject3 = localRulePoolNode.getSelectedWheres();
        for (int i4 = 0; i4 < ((List)localObject3).size(); i4++)
        {
          PackageFieldSet localPackageFieldSet = (PackageFieldSet)((List)localObject3).get(i4);
          IVariableObject localIVariableObject = localPackageFieldSet.getAssignValue().getVariableElement();
          if (localIVariableObject == null)
            continue;
          Object localObject4;
          if ((localIVariableObject instanceof IPropertyObject))
          {
            localObject4 = (IPropertyObject)localIVariableObject;
            l();
            d(((IPropertyObject)localObject4).getSetMethodPreName());
            g localg = localIVariableObject.getJavaType();
            if (localg.m())
              d("engine.getString(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else if (localg.e())
              d("engine.getBoolean(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else if (localg.d())
              d("engine.getChar(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else if (localg.g())
              d("engine.getShort(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else if (localg.k())
              d("engine.getInteger(\"" + localPackageFieldSet.getFuncName() + "\")");
            else if (localg.h())
              d("engine.getLong(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else if (localg.c())
              d("engine.getFloat(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else if (localg.i())
              d("engine.getDouble(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else
              d("(" + o.b(localg) + ")engine.get(\"" + localPackageFieldSet.getFuncName() + "\") ");
            d(((IPropertyObject)localObject4).getSetMethodSufName() + ";");
            c();
          }
          else
          {
            localPackageFieldSet.getAssignValue().acceptVisitor(this);
            d(" = ");
            localObject4 = localIVariableObject.getJavaType();
            if (((g)localObject4).m())
              d("engine.getString(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject4).e())
              d("engine.getBoolean(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject4).d())
              d("engine.getChar(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject4).g())
              d("engine.getShort(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject4).k())
              d("engine.getInteger(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject4).h())
              d("engine.getLong(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject4).c())
              d("engine.getFloat(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject4).i())
              d("engine.getDouble(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else
              d("(" + o.b((g)localObject4) + ")engine.get(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            c();
          }
        }
        if (e())
          continue;
        e("}");
      }
      else
      {
        if (localRulePoolNode.getRuleObject() == null)
          continue;
        a(localRulePoolNode.getRuleObject(), paramList, paramRulePoolFlow);
      }
    }
    if (localList1.size() > 0)
    {
      d("}");
      c();
    }
    c(paramRulePoolFlow);
    if ((!e()) && (paramRulePoolFlow.noChildLog()))
      a(paramRulePoolFlow.getRelateVarNames(), "childRuleLog");
    if ((paramRulePoolFlow.getStartTime() != 0L) || (paramRulePoolFlow.getEndTime() != 0L))
    {
      c(1);
      e("}");
    }
  }

  private void a(AbstractRuleFlow paramAbstractRuleFlow, List paramList, int paramInt)
  {
    this.f = paramAbstractRuleFlow;
    f(paramAbstractRuleFlow.getDisplayName());
    if (paramAbstractRuleFlow.isSyn())
      e("private synchronized int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    else
      e("private int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    b(1);
    if (paramAbstractRuleFlow.isRunBreak())
      e("int rt= M_RETURN_EXIT;");
    else
      e("int rt = M_RETURN_DEFAULT ;");
    if (!paramAbstractRuleFlow.isActived())
      e("if ( true ) return M_RETURN_DEFAULT;");
    e("try {");
    b(1);
    if (paramAbstractRuleFlow.getStartTime() != 0L)
      e("if ( getCurrentTime() < " + paramAbstractRuleFlow.getStartTime() + "L ) return M_RETURN_DEFAULT ;");
    if (paramAbstractRuleFlow.getEndTime() != 0L)
      e("if ( getCurrentTime() > " + paramAbstractRuleFlow.getEndTime() + "L ) return M_RETURN_DEFAULT ;");
    a(paramAbstractRuleFlow, paramList);
    c(1);
    e("} catch (Exception e) {");
    if (paramAbstractRuleFlow.isSupportCatch())
    {
      b(1);
      Iterator localIterator = paramAbstractRuleFlow.getRuleSetToken().getCatchActions().getActions();
      while (localIterator.hasNext())
        e((IElement)localIterator.next());
      c(1);
    }
    e("if ( e instanceof RuleEngineException ) throw e ;");
    if (paramAbstractRuleFlow.getExceptionType() == 0)
      e("\tthrow e ;");
    else if (paramAbstractRuleFlow.getExceptionType() == 1)
    {
      if (paramAbstractRuleFlow.getErrorMsg().length() > 0)
        e(" throw new RuleEngineException(\"" + h(paramAbstractRuleFlow.getErrorMsg()) + "\",e);");
      else
        e(" throw new RuleEngineException(\"" + h(b(paramAbstractRuleFlow)) + "\",e);");
    }
    else if (paramAbstractRuleFlow.getExceptionType() == 2)
    {
      if (paramAbstractRuleFlow.getErrorMsg().length() > 0)
        e(" throw new RuleEngineException(\"" + h(paramAbstractRuleFlow.getErrorMsg()) + "\"+e.getLocalizedMessage(),e);");
      else
        e(" throw new RuleEngineException(\"" + h(b(paramAbstractRuleFlow)) + "\"+e.getLocalizedMessage(),e);");
    }
    else
      paramAbstractRuleFlow.getExceptionType();
    e("} catch (Throwable e1) {");
    if (paramAbstractRuleFlow.getErrorMsg().length() > 0)
      e(" throw new RuleEngineException(\"" + h(paramAbstractRuleFlow.getErrorMsg()) + "\",e1);");
    else
      e(" throw new RuleEngineException(\"" + h(b(paramAbstractRuleFlow)) + "\"+e1.getMessage(),e1);");
    e("}");
    e("return rt;");
    c(1);
    e("}");
  }

  private void a(AbstractRuleFlow paramAbstractRuleFlow, List paramList)
  {
    if ((paramAbstractRuleFlow.isEmpty()) || (!paramAbstractRuleFlow.isActived()))
      return;
    this.f = paramAbstractRuleFlow;
    if ((paramAbstractRuleFlow.getStartTime() != 0L) && (paramAbstractRuleFlow.getEndTime() != 0L))
      e("if ( getCurrentTime() >= " + paramAbstractRuleFlow.getStartTime() + "L  &&  getCurrentTime() <= " + paramAbstractRuleFlow.getEndTime() + "L ) { ");
    else if (paramAbstractRuleFlow.getStartTime() != 0L)
      e("if ( getCurrentTime() >= " + paramAbstractRuleFlow.getStartTime() + "L ) {");
    else if (paramAbstractRuleFlow.getEndTime() != 0L)
      e("if ( getCurrentTime() <= " + paramAbstractRuleFlow.getEndTime() + "L ) {");
    if ((paramAbstractRuleFlow.getStartTime() != 0L) || (paramAbstractRuleFlow.getEndTime() != 0L))
      b(1);
    if ((!e()) && (paramAbstractRuleFlow.needLog()))
      a(paramAbstractRuleFlow, paramAbstractRuleFlow.isEnableDataSnap());
    if ((!e()) && (paramAbstractRuleFlow.noChildLog()))
      a(paramAbstractRuleFlow.getInfo(), "childRuleLog", paramAbstractRuleFlow.getRelateVarNames());
    a(paramAbstractRuleFlow);
    List localList = paramAbstractRuleFlow.getStartTransitions();
    for (int i1 = 0; i1 < localList.size(); i1++)
      a((RuleFlowTransition)localList.get(i1), paramAbstractRuleFlow, paramList, i1);
    c(paramAbstractRuleFlow);
    if ((!e()) && (paramAbstractRuleFlow.noChildLog()))
      a(paramAbstractRuleFlow.getRelateVarNames(), "childRuleLog");
    if ((paramAbstractRuleFlow.getStartTime() != 0L) || (paramAbstractRuleFlow.getEndTime() != 0L))
    {
      c(1);
      e("}");
    }
  }

  private void a(IRuleClass paramIRuleClass, List paramList, RulePoolFlow paramRulePoolFlow)
  {
    if ((paramList.indexOf(paramIRuleClass) < 0) && (!(paramIRuleClass instanceof RuleMirror)))
    {
      if (!e())
        e("if ( true ) {");
      if (this.e != null)
        e(this.e);
      if ((!e()) && (paramRulePoolFlow.needLog()))
        i(paramIRuleClass.getVisitExeName());
      l();
      d("getEngineFactory().getRuleEngine().excute(dtcObjects,class_objects,\"");
      d(paramIRuleClass.getVisitExeName());
      d("\");");
      c();
      if (this.e != null)
        d(this.e);
      if (!e())
        e("}");
    }
    else if ((paramIRuleClass instanceof RuleSet))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramRulePoolFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if ((paramIRuleClass instanceof AbstractRuleFlow))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramRulePoolFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if (((paramIRuleClass instanceof Rule)) && (!((Rule)paramIRuleClass).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramRulePoolFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if (((paramIRuleClass instanceof DecisionRule)) && (!((DecisionRule)paramIRuleClass).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramRulePoolFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if (((paramIRuleClass instanceof DecisionMultiRule)) && (!((DecisionMultiRule)paramIRuleClass).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramRulePoolFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if (((paramIRuleClass instanceof ExpressionRule)) && (!((ExpressionRule)paramIRuleClass).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramRulePoolFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if (((paramIRuleClass instanceof DecisionRelateRule)) && (!((DecisionRelateRule)paramIRuleClass).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramRulePoolFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if (((paramIRuleClass instanceof RuleMirror)) && ((((RuleMirror)paramIRuleClass).getMemberElement() instanceof IRuleClass)))
    {
      a((IRuleClass)((RuleMirror)paramIRuleClass).getMemberElement(), paramList, paramRulePoolFlow);
    }
  }

  private void a(IRuleClass paramIRuleClass, List paramList, AbstractRuleFlow paramAbstractRuleFlow)
  {
    if ((paramList.indexOf(paramIRuleClass) < 0) && (!(paramIRuleClass instanceof RuleMirror)))
    {
      if (this.e != null)
        e(this.e);
      if ((!e()) && (paramAbstractRuleFlow.needLog()))
        i(paramIRuleClass.getVisitExeName());
      l();
      d("getEngineFactory().getRuleEngine().excute(dtcObjects,class_objects,\"");
      d(paramIRuleClass.getVisitExeName());
      d("\");");
      c();
      if (this.e != null)
        d(this.e);
    }
    else if ((paramIRuleClass instanceof RuleSet))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramAbstractRuleFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if ((paramIRuleClass instanceof AbstractRuleFlow))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramAbstractRuleFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if (((paramIRuleClass instanceof Rule)) && (!((Rule)paramIRuleClass).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramAbstractRuleFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if (((paramIRuleClass instanceof DecisionRule)) && (!((DecisionRule)paramIRuleClass).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramAbstractRuleFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if (((paramIRuleClass instanceof DecisionMultiRule)) && (!((DecisionMultiRule)paramIRuleClass).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramAbstractRuleFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if (((paramIRuleClass instanceof ExpressionRule)) && (!((ExpressionRule)paramIRuleClass).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramAbstractRuleFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if (((paramIRuleClass instanceof DecisionRelateRule)) && (!((DecisionRelateRule)paramIRuleClass).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramIRuleClass) + "(childRuleLog) ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if (paramAbstractRuleFlow.isForType())
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      else
        e("if ( rt == M_RETURN_CONTINUE ) {rt=M_RETURN_DEFAULT;}");
      e("if ( rt == M_RETURN_BREAK ) {rt=M_RETURN_DEFAULT;}");
    }
    else if (((paramIRuleClass instanceof RuleMirror)) && ((((RuleMirror)paramIRuleClass).getMemberElement() instanceof IRuleClass)))
    {
      a((IRuleClass)((RuleMirror)paramIRuleClass).getMemberElement(), paramList, paramAbstractRuleFlow);
    }
  }

  private void a(RuleFlowTransition paramRuleFlowTransition, AbstractRuleFlow paramAbstractRuleFlow, List paramList, int paramInt)
  {
    Iterator localIterator = paramRuleFlowTransition.getTestConditions().getConditions();
    if (localIterator.hasNext())
    {
      localObject1 = (IConditionToken)localIterator.next();
      if (((((IConditionToken)localObject1).getCompareOperator() instanceof StringJudgeToken)) && (((IConditionToken)localObject1).getCompareOperator().getType() == 12))
      {
        e("else {");
      }
      else
      {
        l();
        if (paramInt > 0)
          d("else if ( ");
        else
          d("if ( ");
        ((IConditionToken)localObject1).acceptVisitor(this);
        d(" ) {");
        c();
      }
    }
    else
    {
      e("if ( true) { ");
    }
    b(1);
    Object localObject1 = paramAbstractRuleFlow.getFlowElement(paramRuleFlowTransition.getToUuid());
    if ((localObject1 != null) && ((localObject1 instanceof RuleFlowActivitie)))
    {
      localObject2 = (RuleFlowActivitie)localObject1;
      if (((RuleFlowActivitie)localObject2).hasGetAndSet())
      {
        if (!e())
          e("if ( true ) {");
        d("RuleEngine engine = getEngineFactory().getRuleEngine() ;");
        c();
        List localList = ((RuleFlowActivitie)localObject2).getSelectedFields();
        for (int i2 = 0; i2 < localList.size(); i2++)
        {
          localObject3 = (PackageFieldGet)localList.get(i2);
          l();
          d("engine.put(\"" + ((PackageFieldGet)localObject3).getFuncName() + "\", ");
          ((PackageFieldGet)localObject3).getAssignValue().acceptVisitor(this);
          d(") ;");
          c();
        }
        e("if ( class_objects != null ) engine.putObjects(class_objects) ;");
        e("if ( out != null ) engine.put(\"out\",out) ;");
        if ((!e()) && (this.d) && (paramAbstractRuleFlow.needLog()))
        {
          str = ((RuleFlowActivitie)localObject2).getDisplayName();
          e("RuleLogList exelog = null;");
          if (this.l.equals("true"))
            e("if (childRuleLog != null ) {");
          else
            e("if (childRuleLog != null  && " + this.l + ") {");
          e("\texelog = new RuleLogList(\"" + b(str) + "\");");
          e("\tchildRuleLog.addLog(exelog);");
          e("\tengine.put(\"ruleLog\",exelog);");
          e("if (snapShot!=null) engine.put(\"snapShot\",snapShot);");
          localObject3 = ((RuleFlowActivitie)localObject2).getExeRuleName();
          if ((((String)localObject3).startsWith("{")) && (((String)localObject3).endsWith("}")))
          {
            localObject4 = paramAbstractRuleFlow.getEnvionment().getBusinessDisName(((String)localObject3).substring(1, ((String)localObject3).length() - 1));
            if (localObject4 != null)
              e("\texelog.setRuleProcess(" + ((IBusinessObject)localObject4).getVarValue() + ") ;");
            else
              e("\texelog.setRuleProcess(\"" + b(((RuleFlowActivitie)localObject2).getExeRuleName()) + "\") ;");
          }
          else
          {
            e("\texelog.setRuleProcess(\"" + b(((RuleFlowActivitie)localObject2).getExeRuleName()) + "\") ;");
          }
          localObject4 = "";
          for (i3 = 0; i3 < localList.size(); i3++)
            localObject4 = localObject4 + "\"" + b(((PackageFieldGet)localList.get(i3)).getFuncName()) + "\",";
          if (((String)localObject4).length() > 0)
          {
            e("try {");
            d("\texelog.setFieldInits(new String[]{" + ((String)localObject4).substring(0, ((String)localObject4).length() - 1) + "},new String[]{");
            for (i3 = 0; i3 < localList.size(); i3++)
            {
              d("StringUtil.stringValue(");
              ((PackageFieldGet)localList.get(i3)).getAssignValue().acceptVisitor(this);
              d(")");
              if (i3 >= localList.size() - 1)
                continue;
              d(",");
            }
            e("}) ;");
            e("} catch (Throwable ethrowable) {}");
          }
          e("} else {");
          e("if (ruleLog != null && childRuleLog == null ) {");
          e("\tchildRuleLog = new RuleLogList(\"" + b(str) + "\");");
          e("\truleLog.addLog(childRuleLog); } ");
          e("\tengine.put(\"ruleLog\",childRuleLog);");
          e("if (snapShot!=null) engine.put(\"snapShot\",snapShot);");
          e("}");
        }
        String str = ((RuleFlowActivitie)localObject2).getExeRuleName();
        Object localObject3 = "\"" + ((RuleFlowActivitie)localObject2).getExeRuleName() + "\"";
        if ((str.startsWith("{")) && (str.endsWith("}")))
        {
          localObject4 = paramAbstractRuleFlow.getEnvionment().getBusinessDisName(str.substring(1, str.length() - 1));
          if (localObject4 != null)
            localObject3 = ((IBusinessObject)localObject4).getVarValue();
        }
        e("engine.excute(" + (String)localObject3 + ") ;");
        Object localObject4 = ((RuleFlowActivitie)localObject2).getSelectedWheres();
        for (int i3 = 0; i3 < ((List)localObject4).size(); i3++)
        {
          PackageFieldSet localPackageFieldSet = (PackageFieldSet)((List)localObject4).get(i3);
          IVariableObject localIVariableObject = localPackageFieldSet.getAssignValue().getVariableElement();
          if (localIVariableObject == null)
            continue;
          Object localObject5;
          if ((localIVariableObject instanceof IPropertyObject))
          {
            localObject5 = (IPropertyObject)localIVariableObject;
            l();
            d(((IPropertyObject)localObject5).getSetMethodPreName());
            g localg = localIVariableObject.getJavaType();
            if (localg.m())
              d("engine.getString(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else if (localg.e())
              d("engine.getBoolean(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else if (localg.d())
              d("engine.getChar(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else if (localg.g())
              d("engine.getShort(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else if (localg.k())
              d("engine.getInteger(\"" + localPackageFieldSet.getFuncName() + "\")");
            else if (localg.h())
              d("engine.getLong(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else if (localg.c())
              d("engine.getFloat(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else if (localg.i())
              d("engine.getDouble(\"" + localPackageFieldSet.getFuncName() + "\") ");
            else
              d("(" + o.b(localg) + ")engine.get(\"" + localPackageFieldSet.getFuncName() + "\") ");
            d(((IPropertyObject)localObject5).getSetMethodSufName() + ";");
            c();
          }
          else
          {
            localPackageFieldSet.getAssignValue().acceptVisitor(this);
            d(" = ");
            localObject5 = localIVariableObject.getJavaType();
            if (((g)localObject5).m())
              d("engine.getString(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject5).e())
              d("engine.getBoolean(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject5).d())
              d("engine.getChar(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject5).g())
              d("engine.getShort(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject5).k())
              d("engine.getInteger(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject5).h())
              d("engine.getLong(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject5).c())
              d("engine.getFloat(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else if (((g)localObject5).i())
              d("engine.getDouble(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            else
              d("(" + o.b((g)localObject5) + ")engine.get(\"" + localPackageFieldSet.getFuncName() + "\") ;");
            c();
          }
        }
        if (!e())
          e("}");
      }
      else if (((RuleFlowActivitie)localObject2).getRuleObject() != null)
      {
        a(((RuleFlowActivitie)localObject2).getRuleObject(), paramList, paramAbstractRuleFlow);
      }
    }
    Object localObject2 = paramAbstractRuleFlow.getNextTransitions(paramRuleFlowTransition.getToUuid());
    for (int i1 = 0; i1 < ((List)localObject2).size(); i1++)
      a((RuleFlowTransition)((List)localObject2).get(i1), paramAbstractRuleFlow, paramList, i1);
    c(1);
    e("}");
  }

  private void a(Object paramObject, List paramList, RuleSet paramRuleSet)
  {
    String str = "null";
    if ((!e()) && (paramRuleSet.needLog()))
      str = "childRuleLog";
    if ((paramObject instanceof RuleSet))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(" + str + ") ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if ((paramRuleSet.isForType()) || (paramRuleSet.isForEachType()))
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";");
        b(paramRuleSet);
        e("continue;}");
      }
      else
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";break;}");
      }
      e("if ( rt == M_RETURN_BREAK ) {rt=-2;break;}");
    }
    else if ((paramObject instanceof AbstractRuleFlow))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(" + str + ") ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if ((paramRuleSet.isForType()) || (paramRuleSet.isForEachType()))
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";");
        b(paramRuleSet);
        e("continue;}");
      }
      else
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";break;}");
      }
      e("if ( rt == M_RETURN_BREAK ) {rt=-2;break;}");
    }
    else if ((paramObject instanceof RulePoolFlow))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(" + str + ") ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if ((paramRuleSet.isForType()) || (paramRuleSet.isForEachType()))
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";");
        b(paramRuleSet);
        e("continue;}");
      }
      else
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";break;}");
      }
      e("if ( rt == M_RETURN_BREAK ) {rt=-2;break;}");
    }
    else if (((paramObject instanceof Rule)) && (!((Rule)paramObject).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(" + str + ") ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if ((paramRuleSet.isForType()) || (paramRuleSet.isForEachType()))
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";");
        b(paramRuleSet);
        e("continue;}");
      }
      else
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";break;}");
      }
      e("if ( rt == M_RETURN_BREAK ) {rt=-2;break;}");
    }
    else if (((paramObject instanceof DecisionRule)) && (!((DecisionRule)paramObject).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(" + str + ") ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if ((paramRuleSet.isForType()) || (paramRuleSet.isForEachType()))
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";");
        b(paramRuleSet);
        e("continue;}");
      }
      else
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";break;}");
      }
      e("if ( rt == M_RETURN_BREAK ) {rt=-2;break;}");
    }
    else if (((paramObject instanceof DecisionMultiRule)) && (!((DecisionMultiRule)paramObject).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(" + str + ") ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if ((paramRuleSet.isForType()) || (paramRuleSet.isForEachType()))
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";");
        b(paramRuleSet);
        e("continue;}");
      }
      else
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";break;}");
      }
      e("if ( rt == M_RETURN_BREAK ) {rt=-2;break;}");
    }
    else if (((paramObject instanceof ExpressionRule)) && (!((ExpressionRule)paramObject).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(" + str + ") ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if ((paramRuleSet.isForType()) || (paramRuleSet.isForEachType()))
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";");
        b(paramRuleSet);
        e("continue;}");
      }
      else
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";break;}");
      }
      e("if ( rt == M_RETURN_BREAK ) {rt=-2;break;}");
    }
    else if (((paramObject instanceof DecisionRelateRule)) && (!((DecisionRelateRule)paramObject).isEmpty()))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(" + str + ") ;");
      e("if ( rt >= M_RETURN_EXIT  ){ return rt ;}");
      if ((paramRuleSet.isForType()) || (paramRuleSet.isForEachType()))
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";");
        b(paramRuleSet);
        e("continue;}");
      }
      else
      {
        e("if ( rt == M_RETURN_CONTINUE ) {rt=" + d(paramRuleSet) + ";break;}");
      }
      e("if ( rt == M_RETURN_BREAK ) {rt=-2;break;}");
    }
    else if (((paramObject instanceof RuleMirror)) && (((RuleMirror)paramObject).getMemberElement() != null))
    {
      a(((RuleMirror)paramObject).getMemberElement(), paramList, paramRuleSet);
    }
  }

  private void a(RuleSet paramRuleSet, List paramList, int paramInt)
  {
    this.f = paramRuleSet;
    f(b(paramRuleSet));
    if (paramRuleSet.isSyn())
      e("private synchronized int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    else
      e("private int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    b(1);
    if (paramRuleSet.isRunBreak())
      e("int rt = M_RETURN_EXIT;");
    else
      e("int rt = M_RETURN_DEFAULT ;");
    if (!paramRuleSet.isActived())
      e("if ( true ) return M_RETURN_DEFAULT;");
    e("try {");
    b(1);
    if (paramRuleSet.getStartTime() != 0L)
      e("if ( getCurrentTime() < " + paramRuleSet.getStartTime() + "L ) return M_RETURN_DEFAULT ;");
    if (paramRuleSet.getEndTime() != 0L)
      e("if ( getCurrentTime() > " + paramRuleSet.getEndTime() + "L ) return M_RETURN_DEFAULT ;");
    a(paramRuleSet, paramList);
    c(1);
    e("} catch (Exception e) {");
    if (paramRuleSet.isSupportCatch())
    {
      b(1);
      Iterator localIterator = paramRuleSet.getRuleSetToken().getCatchActions().getActions();
      while (localIterator.hasNext())
        e((IElement)localIterator.next());
      c(1);
    }
    e("if ( e instanceof RuleEngineException ) throw e ;");
    if (paramRuleSet.getExceptionType() == 0)
      e("\tthrow e ;");
    else if (paramRuleSet.getExceptionType() == 1)
    {
      if (paramRuleSet.getErrorMsg().length() > 0)
        e(" throw new RuleEngineException(\"" + h(paramRuleSet.getErrorMsg()) + "\",e);");
      else
        e(" throw new RuleEngineException(\"" + h(b(paramRuleSet)) + "\",e);");
    }
    else if (paramRuleSet.getExceptionType() == 2)
    {
      if (paramRuleSet.getErrorMsg().length() > 0)
        e(" throw new RuleEngineException(\"" + h(paramRuleSet.getErrorMsg()) + "\"+e.getLocalizedMessage(),e);");
      else
        e(" throw new RuleEngineException(\"" + h(b(paramRuleSet)) + "\"+e.getLocalizedMessage(),e);");
    }
    else
      paramRuleSet.getExceptionType();
    e("} catch (Throwable e1) {");
    if (paramRuleSet.getErrorMsg().length() > 0)
      e(" throw new RuleEngineException(\"" + h(paramRuleSet.getErrorMsg()) + "\",e1);");
    else
      e(" throw new RuleEngineException(\"" + h(b(paramRuleSet)) + "\"+e1.getMessage(),e1);");
    e("}");
    e("return rt;");
    c(1);
    e("}");
  }

  private void a(AbstractRuleSet paramAbstractRuleSet)
  {
    a(paramAbstractRuleSet);
    Iterator localIterator;
    Object localObject;
    if ((paramAbstractRuleSet.isForType()) || (paramAbstractRuleSet.isInitTestType()))
    {
      l();
      localIterator = paramAbstractRuleSet.getRuleSetToken().getInitActions().getActions();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (!(localObject instanceof IElement))
          continue;
        ((IElement)localObject).acceptVisitor(this);
      }
      c();
    }
    l();
    if (!paramAbstractRuleSet.isForEachType())
    {
      d("while ( ");
      if (((paramAbstractRuleSet.isTestType()) || (paramAbstractRuleSet.isForType()) || (paramAbstractRuleSet.isInitTestType())) && (paramAbstractRuleSet.getRuleSetToken().getTestConditions().getConditions().hasNext()))
      {
        localIterator = paramAbstractRuleSet.getRuleSetToken().getTestConditions().getConditions();
        if (localIterator.hasNext())
          while (localIterator.hasNext())
            d((IElement)localIterator.next());
        else
          d("true");
      }
      else
      {
        d("true");
      }
      d(" ) {");
      c();
    }
    else
    {
      paramAbstractRuleSet.getRuleSetToken().getForEachConditionToken().acceptVisitor(this);
    }
    b(1);
    if (paramAbstractRuleSet.isFirst())
    {
      localIterator = paramAbstractRuleSet.getRuleSetToken().getFirstActions().getActions();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (!(localObject instanceof IElement))
          continue;
        e((IElement)localObject);
      }
    }
    if ((!e()) && ((paramAbstractRuleSet.getParent() instanceof IRuleSet)) && (((IRuleSet)paramAbstractRuleSet.getParent()).needCheckSubRule()) && (!paramAbstractRuleSet.needWhile()))
      e("recordVisitRule(\"" + paramAbstractRuleSet.getParent().getShowDisplayName() + "\",\"" + paramAbstractRuleSet.getDisplayName() + "\");");
  }

  private void b(AbstractRuleSet paramAbstractRuleSet)
  {
    if (paramAbstractRuleSet.isForType())
    {
      Iterator localIterator = paramAbstractRuleSet.getRuleSetToken().getBlockActions().getActions();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof IElement))
          continue;
        e((IElement)localObject);
      }
    }
  }

  private void c(AbstractRuleSet paramAbstractRuleSet)
  {
    if ((paramAbstractRuleSet.isEnableDataSnap()) && (!e()) && (paramAbstractRuleSet.needLog()))
      e("takeSnapShot(childRuleLog) ;");
    b(paramAbstractRuleSet);
    if (paramAbstractRuleSet.getRestartType() == 1)
      e("rt = M_RETURN_RESTART;");
    else if (paramAbstractRuleSet.getRestartType() == 2)
      e("rt =  M_RETURN_CONTINUE;");
    else if (paramAbstractRuleSet.getRestartType() == 3)
      e("rt =  M_RETURN_BREAK;");
    if ((!paramAbstractRuleSet.isForType()) && (!paramAbstractRuleSet.isForEachType()))
      e("break;");
    c(1);
    e("}");
    if ((!e()) && (this.m.size() > 0) && ((paramAbstractRuleSet.isTestType()) || (paramAbstractRuleSet.isForType()) || (paramAbstractRuleSet.isInitTestType()) || (paramAbstractRuleSet.isForEachType())))
    {
      HashMap localHashMap = new HashMap();
      paramAbstractRuleSet.getRuleSetToken().findAssignObject(localHashMap, true);
      a(paramAbstractRuleSet, localHashMap);
    }
    e("if ( rt == -2 ) {");
    e("rt =  " + d(paramAbstractRuleSet) + ";");
    if (paramAbstractRuleSet.needWhile())
      e("break ;");
    e("}");
    b(paramAbstractRuleSet);
  }

  private void a(RuleSet paramRuleSet, List paramList)
  {
    if ((paramRuleSet.isEmpty()) || (!paramRuleSet.isActived()))
      return;
    this.f = paramRuleSet;
    if ((paramRuleSet.getStartTime() != 0L) && (paramRuleSet.getEndTime() != 0L))
      e("if ( getCurrentTime() >= " + paramRuleSet.getStartTime() + "L  &&  getCurrentTime() <= " + paramRuleSet.getEndTime() + "L ) { ");
    else if (paramRuleSet.getStartTime() != 0L)
      e("if ( getCurrentTime() >= " + paramRuleSet.getStartTime() + "L ) {");
    else if (paramRuleSet.getEndTime() != 0L)
      e("if ( getCurrentTime() <= " + paramRuleSet.getEndTime() + "L ) {");
    if ((paramRuleSet.getStartTime() != 0L) || (paramRuleSet.getEndTime() != 0L))
      b(1);
    if ((!e()) && (paramRuleSet.needLog()))
    {
      a(paramRuleSet, paramRuleSet.isEnableDataSnap());
      a(paramRuleSet.getInfo(), "childRuleLog", paramRuleSet.getRelateVarNames());
    }
    a(paramRuleSet);
    Iterator localIterator = paramRuleSet.getChildrenIterator();
    while (localIterator.hasNext())
      a(localIterator.next(), paramList, paramRuleSet);
    c(paramRuleSet);
    if ((!e()) && (paramRuleSet.needLog()))
      a(paramRuleSet.getRelateVarNames(), "childRuleLog");
    if ((paramRuleSet.getStartTime() != 0L) || (paramRuleSet.getEndTime() != 0L))
    {
      c(1);
      e("}");
    }
  }

  private String d(AbstractRuleSet paramAbstractRuleSet)
  {
    if (paramAbstractRuleSet.getRestartType() == 1)
      return "M_RETURN_RESTART";
    if (paramAbstractRuleSet.getRestartType() == 2)
      return "M_RETURN_CONTINUE";
    if (paramAbstractRuleSet.getRestartType() == 3)
      return "M_RETURN_BREAK";
    return "M_RETURN_DEFAULT";
  }

  private int a(List paramList, Rule paramRule)
  {
    return paramList.indexOf(paramRule);
  }

  public Object visitRulePackage(RulePackage paramRulePackage)
  {
    return a(paramRulePackage, paramRulePackage);
  }

  private void g(RulePackage paramRulePackage)
  {
    d(paramRulePackage);
    e("initSheetTable();");
    e("initMap() ;");
    Iterator localIterator1 = paramRulePackage.getEnvionment().getDBModels();
    HashMap localHashMap = new HashMap();
    Object localObject1;
    Iterator localIterator2;
    Object localObject2;
    Object localObject3;
    String str1;
    Object localObject4;
    Object localObject5;
    while (localIterator1.hasNext())
    {
      localObject1 = (DBModel)localIterator1.next();
      if (localHashMap.get(((DBModel)localObject1).getVarValue()) == null)
      {
        e("if ( dtcObjects.get(\"" + ((DBModel)localObject1).getValueName() + "\") != null && dtcObjects.get(\"" + ((DBModel)localObject1).getValueName() + "\") instanceof java.sql.Connection ) ");
        e(((DBModel)localObject1).getVarValue() + " = DBFactory.newIntance().getDatabase(dtcObjects.get(\"" + ((DBModel)localObject1).getValueName() + "\"),\"" + ((DBModel)localObject1).getDatasourceName() + "\");");
        e("else if ( dtcObjects.get(\"" + ((DBModel)localObject1).getValueName() + "\") != null && dtcObjects.get(\"" + ((DBModel)localObject1).getValueName() + "\") instanceof com.flagleader.db.Database ) ");
        e(((DBModel)localObject1).getVarValue() + " = DBFactory.newIntance().getDatabase(dtcObjects.get(\"" + ((DBModel)localObject1).getValueName() + "\"),\"" + ((DBModel)localObject1).getDatasourceName() + "\");");
        e("else");
        e(((DBModel)localObject1).getVarValue() + " = DBFactory.newIntance().getDatabase(\"" + ((DBModel)localObject1).getDatasourceName() + "\");");
        if (((DBModel)localObject1).getConnType() == 1)
          e(((DBModel)localObject1).getVarValue() + ".setAutoCommit(true);");
        else if (((DBModel)localObject1).getConnType() == 0)
          e(((DBModel)localObject1).getVarValue() + ".setAutoCommit(false);");
        if (((DBModel)localObject1).getTransationlevel() > 0)
          e(((DBModel)localObject1).getVarValue() + ".setTransactionIsolation(" + ((DBModel)localObject1).getTransactionInfo() + ");");
        localHashMap.put(((DBModel)localObject1).getVarValue(), localObject1);
      }
      localIterator2 = ((DBModel)localObject1).getTypeSuperChildren(IBOAndContainer.class);
      while (localIterator2.hasNext())
      {
        localObject2 = (IBOAndContainer)localIterator2.next();
        int i5;
        if ((localObject2 instanceof TableModel))
        {
          localObject3 = (TableModel)localObject2;
          str1 = " new RuleField[]{";
          localObject4 = ((TableModel)localObject3).getFields();
          for (int i1 = 0; i1 < ((List)localObject4).size(); i1++)
          {
            str1 = str1 + "new RuleField(\"" + ((FieldModel)((List)localObject4).get(i1)).getFieldName().toLowerCase() + "\"";
            str1 = str1 + ",\"" + ((FieldModel)((List)localObject4).get(i1)).getDisplayName() + "\"";
            str1 = str1 + "," + ((FieldModel)((List)localObject4).get(i1)).isReadOnly();
            str1 = str1 + "," + ((FieldModel)((List)localObject4).get(i1)).isSearchable();
            str1 = str1 + "," + ((FieldModel)((List)localObject4).get(i1)).isPrimaryKey();
            str1 = str1 + "," + ((FieldModel)((List)localObject4).get(i1)).isFriendKey();
            str1 = str1 + "," + ((FieldModel)((List)localObject4).get(i1)).getIType();
            str1 = str1 + ")";
            if (i1 >= ((List)localObject4).size() - 1)
              continue;
            str1 = str1 + ",";
          }
          str1 = str1 + "}";
          localObject5 = " new RuleKey[]{";
          List localList1 = ((TableModel)localObject3).getFKModels();
          for (i5 = 0; i5 < localList1.size(); i5++)
          {
            localObject5 = localObject5 + "new RuleKey(";
            localObject5 = localObject5 + "\"" + ((FKModel)localList1.get(i5)).getPkTableName() + "\"";
            localObject5 = localObject5 + ",\"" + ((FKModel)localList1.get(i5)).getPkFieldNames() + "\"";
            localObject5 = localObject5 + ",\"" + ((FKModel)localList1.get(i5)).getFKTableName() + "\"";
            localObject5 = localObject5 + ",\"" + ((FKModel)localList1.get(i5)).getFkFieldNames() + "\"";
            localObject5 = localObject5 + "," + ((FKModel)localList1.get(i5)).getUpdateRule();
            localObject5 = localObject5 + "," + ((FKModel)localList1.get(i5)).getDeleteRule();
            localObject5 = localObject5 + ",\"" + ((FKModel)localList1.get(i5)).getDefaultValue() + "\"";
            localObject5 = localObject5 + ")";
            if (i5 >= localList1.size() - 1)
              continue;
            localObject5 = localObject5 + ",";
          }
          localObject5 = localObject5 + "}";
          e(((TableModel)localObject3).getVarValue() + " = " + ((DBModel)localObject1).getVarValue() + ".getTable(\"" + ((TableModel)localObject3).getTableName() + "\"," + str1 + "," + (String)localObject5 + ");");
          if (((TableModel)localObject3).getAccessType() == 2)
            e(((TableModel)localObject3).getVarValue() + ".setAccessType(" + ((TableModel)localObject3).getAccessType() + ");");
          else
            e(((TableModel)localObject3).getVarValue() + ".setAccessMode(" + ((TableModel)localObject3).isAccessMode() + ");");
          e(((TableModel)localObject3).getVarValue() + ".setResultType(" + ((TableModel)localObject3).getResultType() + ");");
        }
        else if ((localObject2 instanceof SelectTable))
        {
          localObject3 = (SelectTable)localObject2;
          str1 = " new String[]{";
          localObject4 = " new String[]{";
          localObject5 = ((SelectTable)localObject3).getFields();
          for (int i3 = 0; i3 < ((List)localObject5).size(); i3++)
          {
            str1 = str1 + "\"" + ((FieldModel)((List)localObject5).get(i3)).getFieldName().toLowerCase() + "\"";
            localObject4 = localObject4 + "\"" + ((FieldModel)((List)localObject5).get(i3)).getDisplayName() + "\"";
            if (i3 >= ((List)localObject5).size() - 1)
              continue;
            str1 = str1 + ",";
            localObject4 = localObject4 + ",";
          }
          str1 = str1 + "}";
          localObject4 = localObject4 + "}";
          e(((SelectTable)localObject3).getVarValue() + " = " + ((DBModel)localObject1).getVarValue() + ".getSelect(" + str1 + "," + (String)localObject4 + ");");
          if (!((SelectTable)localObject3).isAfterCommit())
            e(((SelectTable)localObject3).getVarValue() + ".setAfterCommit(" + ((SelectTable)localObject3).isAfterCommit() + ");");
          e(((SelectTable)localObject3).getVarValue() + ".setResultType(" + ((SelectTable)localObject3).getResultType() + ");");
        }
        else if (((localObject2 instanceof SheetTable)) && (((SheetTable)localObject2).getTableFunction("loadFromSql") != null) && (((SheetTable)localObject2).getSqlSelect().length() > 0))
        {
          localObject3 = (SheetTable)localObject2;
          str1 = " new String[]{";
          localObject4 = " new String[]{";
          localObject5 = " new String[]{";
          List localList2 = ((SheetTable)localObject3).getFields();
          for (i5 = 0; i5 < localList2.size(); i5++)
          {
            str1 = str1 + "\"" + ((SheetFieldModel)localList2.get(i5)).getFieldName() + "\"";
            localObject4 = localObject4 + "\"" + ((SheetFieldModel)localList2.get(i5)).getDisplayName() + "\"";
            localObject5 = localObject5 + "\"" + ((SheetFieldModel)localList2.get(i5)).getValueType() + "\"";
            if (i5 >= localList2.size() - 1)
              continue;
            str1 = str1 + ",";
            localObject4 = localObject4 + ",";
            localObject5 = localObject5 + ",";
          }
          str1 = str1 + "}";
          localObject4 = localObject4 + "}";
          localObject5 = localObject5 + "}";
          e(((SheetTable)localObject3).getVarValue() + " = " + ((DBModel)localObject1).getVarValue() + ".getSheet(" + str1 + "," + (String)localObject4 + "," + (String)localObject5 + ");");
          if (((SheetTable)localObject3).getNullDefault() != 0)
            e(((SheetTable)localObject3).getVarValue() + ".setNullDefault(" + ((SheetTable)localObject3).getNullDefault() + ");");
          if ((((SheetTable)localObject3).isSaveValue()) && (((SheetTable)localObject3).getSheetValues().size() > 0))
          {
            d(((SheetTable)localObject3).getVarValue() + ".loadDataFromString(ARRAY" + ((SheetTable)localObject3).getVarValue().toUpperCase() + "(),new String[]{");
            for (i5 = 0; i5 < ((SheetTable)localObject3).getFields().size(); i5++)
            {
              d("\"" + ((SheetFieldModel)((SheetTable)localObject3).getFields().get(i5)).getValueType() + "\"");
              if (i5 == ((SheetTable)localObject3).getFields().size() - 1)
                continue;
              d(",");
            }
            d("});");
            c();
          }
          else if (((SheetTable)localObject3).isFromResource())
          {
            String str2 = ((SheetTable)localObject3).getTestFile();
            if (StringUtil.isEmpty(str2))
              str2 = ((SheetTable)localObject3).getDisplayName();
            d(((SheetTable)localObject3).getVarValue() + ".loadFromResource(\"" + str2 + "\");");
            c();
          }
          else
          {
            e(" if ( dtcObjects.get(\"" + ((SheetTable)localObject3).getValueName() + "\") != null && dtcObjects.get(\"" + ((SheetTable)localObject3).getValueName() + "\") instanceof java.io.File ) {");
            e(((SheetTable)localObject3).getVarValue() + ".loadFromExcelFile((java.io.File)dtcObjects.get(\"" + ((SheetTable)localObject3).getValueName() + "\"));");
            e("}");
            e("else if ( dtcObjects.get(\"" + ((SheetTable)localObject3).getValueName() + "\") != null && dtcObjects.get(\"" + ((SheetTable)localObject3).getValueName() + "\") instanceof String ) {");
            e(((SheetTable)localObject3).getVarValue() + ".loadFromExcelFile(new java.io.File((String)dtcObjects.get(\"" + ((SheetTable)localObject3).getValueName() + "\")));");
            e("}");
            e("else if ( dtcObjects.get(\"" + ((SheetTable)localObject3).getValueName() + "\") != null && dtcObjects.get(\"" + ((SheetTable)localObject3).getValueName() + "\") instanceof List ) {");
            e(((SheetTable)localObject3).getVarValue() + ".loadFromList((List)dtcObjects.get(\"" + ((SheetTable)localObject3).getValueName() + "\"));");
            e("}");
          }
        }
        else
        {
          if (!(localObject2 instanceof ProcedureModel))
            continue;
          localObject3 = (ProcedureModel)localObject2;
          str1 = " new String[]{";
          localObject4 = " new String[]{";
          localObject5 = ((ProcedureModel)localObject3).getFields();
          for (int i4 = 0; i4 < ((List)localObject5).size(); i4++)
          {
            str1 = str1 + "\"" + ((FieldModel)((List)localObject5).get(i4)).getFieldName().toLowerCase() + "\"";
            localObject4 = localObject4 + "\"" + ((FieldModel)((List)localObject5).get(i4)).getDisplayName() + "\"";
            if (i4 >= ((List)localObject5).size() - 1)
              continue;
            str1 = str1 + ",";
            localObject4 = localObject4 + ",";
          }
          str1 = str1 + "}";
          localObject4 = localObject4 + "}";
          e(((ProcedureModel)localObject3).getVarValue() + " = " + ((DBModel)localObject1).getVarValue() + ".getProcedure(" + str1 + "," + (String)localObject4 + ");");
          e(((ProcedureModel)localObject3).getVarValue() + ".setResultType(" + ((ProcedureModel)localObject3).getResultType() + ");");
        }
      }
    }
    localIterator1 = paramRulePackage.getEnvionment().getExcelBookModels();
    while (localIterator1.hasNext())
    {
      localObject1 = (ExcelBookModel)localIterator1.next();
      e("if ( dtcObjects.get(\"" + ((ExcelBookModel)localObject1).getValueName() + "\") != null && dtcObjects.get(\"" + ((ExcelBookModel)localObject1).getValueName() + "\") instanceof IExcelBook ) {");
      e(((ExcelBookModel)localObject1).getVarValue() + " = (IExcelBook)dtcObjects.get(\"" + ((ExcelBookModel)localObject1).getValueName() + "\");");
      e("}");
      e("else {");
      e(((ExcelBookModel)localObject1).getVarValue() + " = ExcelFactory.newIntance().createBook();");
      if (((ExcelBookModel)localObject1).getModelFile().length() > 0)
        e(((ExcelBookModel)localObject1).getVarValue() + ".setModelFile(\"" + ((ExcelBookModel)localObject1).getModelFile() + "\");");
      e("  if ( dtcObjects.get(\"" + ((ExcelBookModel)localObject1).getValueName() + "\") != null && dtcObjects.get(\"" + ((ExcelBookModel)localObject1).getValueName() + "\") instanceof java.io.File ) {");
      e(((ExcelBookModel)localObject1).getVarValue() + ".loadFromFile((java.io.File)dtcObjects.get(\"" + ((ExcelBookModel)localObject1).getValueName() + "\"));");
      e("}");
      e("else if ( dtcObjects.get(\"" + ((ExcelBookModel)localObject1).getValueName() + "\") != null && dtcObjects.get(\"" + ((ExcelBookModel)localObject1).getValueName() + "\") instanceof String ) {");
      e(((ExcelBookModel)localObject1).getVarValue() + ".loadFromFile(new java.io.File((String)dtcObjects.get(\"" + ((ExcelBookModel)localObject1).getValueName() + "\")));");
      e("}");
      e("}");
      localIterator2 = ((ExcelBookModel)localObject1).getTypeSuperChildren(IExcelObject.class);
      while (localIterator2.hasNext())
      {
        localObject2 = (IExcelObject)localIterator2.next();
        if ((localObject2 instanceof ExcelXYSheetModel))
        {
          localObject3 = (ExcelXYSheetModel)localObject2;
          str1 = " new FieldInfo[]{";
          localObject4 = " new FieldInfo[]{";
          localObject5 = " new FieldInfo[]{";
          List localList3 = ((ExcelXYSheetModel)localObject3).getTypeSuperChildrenList(ExcelRowModel.class);
          for (int i6 = 0; i6 < localList3.size(); i6++)
          {
            str1 = str1 + a((ExcelRowModel)localList3.get(i6));
            if (i6 >= localList3.size() - 1)
              continue;
            str1 = str1 + ",";
          }
          localList3 = ((ExcelXYSheetModel)localObject3).getTypeSuperChildrenList(ExcelColModel.class);
          for (i6 = 0; i6 < localList3.size(); i6++)
          {
            localObject4 = localObject4 + a((ExcelColModel)localList3.get(i6));
            if (i6 >= localList3.size() - 1)
              continue;
            localObject4 = localObject4 + ",";
          }
          localList3 = ((ExcelXYSheetModel)localObject3).getTypeSuperChildrenList(ExcelCellModel.class);
          for (i6 = 0; i6 < localList3.size(); i6++)
          {
            localObject5 = localObject5 + a((ExcelCellModel)localList3.get(i6));
            if (i6 >= localList3.size() - 1)
              continue;
            localObject5 = localObject5 + ",";
          }
          str1 = str1 + "}";
          localObject4 = localObject4 + "}";
          localObject5 = localObject5 + "}";
          e(((ExcelXYSheetModel)localObject3).getVarValue() + " = ExcelFactory.newIntance().createXYSheet(" + ((ExcelBookModel)localObject1).getVarValue() + ",\"" + ((ExcelXYSheetModel)localObject3).getDisplayName() + "\",\"" + ((ExcelXYSheetModel)localObject3).getSheetReg() + "\"," + str1 + "," + (String)localObject4 + "," + (String)localObject5 + "," + (((ExcelXYSheetModel)localObject3).getColNameLine() - 1) + "," + (((ExcelXYSheetModel)localObject3).getStartRowLine() - 1) + "," + (((ExcelXYSheetModel)localObject3).getStartCol() - 1) + "," + (((ExcelXYSheetModel)localObject3).getRowNameLine() - 1) + "," + ((ExcelXYSheetModel)localObject3).getRowAmountLine() + ");");
          e(((ExcelXYSheetModel)localObject3).getVarValue() + ".setEmptycol(" + ((ExcelXYSheetModel)localObject3).getEmptycol() + ");");
          e(((ExcelXYSheetModel)localObject3).getVarValue() + ".setChangedType(" + ((ExcelXYSheetModel)localObject3).getChangedType() + ");");
          e(((ExcelXYSheetModel)localObject3).getVarValue() + ".setShowBorder(" + ((ExcelXYSheetModel)localObject3).isShowBorder() + ");");
          e(((ExcelXYSheetModel)localObject3).getVarValue() + ".setMergeValue(" + ((ExcelXYSheetModel)localObject3).isMergeValue() + ");");
        }
        else if ((localObject2 instanceof ExcelTableSheetModel))
        {
          localObject3 = (ExcelTableSheetModel)localObject2;
          str1 = " new FieldInfo[]{";
          localObject4 = ((ExcelTableSheetModel)localObject3).getTypeSuperChildrenList(ExcelRowModel.class);
          for (int i2 = 0; i2 < ((List)localObject4).size(); i2++)
          {
            str1 = str1 + a((ExcelRowModel)((List)localObject4).get(i2));
            if (i2 >= ((List)localObject4).size() - 1)
              continue;
            str1 = str1 + ",";
          }
          str1 = str1 + "}";
          e(((ExcelTableSheetModel)localObject3).getVarValue() + " = ExcelFactory.newIntance().createTableSheet(" + ((ExcelBookModel)localObject1).getVarValue() + ",\"" + ((ExcelTableSheetModel)localObject3).getDisplayName() + "\",\"" + ((ExcelTableSheetModel)localObject3).getSheetReg() + "\"," + str1 + "," + (((ExcelTableSheetModel)localObject3).getColNameLine() - 1) + "," + (((ExcelTableSheetModel)localObject3).getStartRowLine() - 1) + "," + (((ExcelTableSheetModel)localObject3).getStartCol() - 1) + "," + ((ExcelTableSheetModel)localObject3).getRowAmountLine() + ");");
          e(((ExcelTableSheetModel)localObject3).getVarValue() + ".setAcceptEmpty(" + ((ExcelTableSheetModel)localObject3).getAcceptEmpty() + ");");
          e(((ExcelTableSheetModel)localObject3).getVarValue() + ".setMergeSame(" + ((ExcelTableSheetModel)localObject3).isMergeSame() + ");");
          e(((ExcelTableSheetModel)localObject3).getVarValue() + ".setShowBorder(" + ((ExcelTableSheetModel)localObject3).isShowBorder() + ");");
          e(((ExcelTableSheetModel)localObject3).getVarValue() + ".setMergeValue(" + ((ExcelTableSheetModel)localObject3).isMergeValue() + ");");
        }
        else
        {
          if (!(localObject2 instanceof ExcelSheetModel))
            continue;
          localObject3 = (ExcelSheetModel)localObject2;
          e(((ExcelSheetModel)localObject3).getVarValue() + " = ExcelFactory.newIntance().createSheet(" + ((ExcelBookModel)localObject1).getVarValue() + ",\"" + ((ExcelSheetModel)localObject3).getDisplayName() + "\",\"" + ((ExcelSheetModel)localObject3).getSheetReg() + "\"" + ");");
          e(((ExcelSheetModel)localObject3).getVarValue() + ".setShowBorder(" + ((ExcelSheetModel)localObject3).isShowBorder() + ");");
          e(((ExcelSheetModel)localObject3).getVarValue() + ".setMergeValue(" + ((ExcelSheetModel)localObject3).isMergeValue() + ");");
        }
      }
    }
    e("int mr_i = M_RETURN_DEFAULT ;");
    e("try { ");
    b(1);
  }

  private void h(RulePackage paramRulePackage)
  {
    Iterator localIterator = paramRulePackage.getEnvionment().getDBModels();
    HashMap localHashMap = new HashMap();
    Object localObject;
    List localList;
    int i1;
    TableModel localTableModel;
    while (localIterator.hasNext())
    {
      localObject = (DBModel)localIterator.next();
      if (localHashMap.get(((DBModel)localObject).getVarValue()) != null)
        continue;
      if ((((DBModel)localObject).getConnType() == 0) || (((DBModel)localObject).getConnType() == 3))
        e(((DBModel)localObject).getVarValue() + ".commit();");
      localList = ((DBModel)localObject).getTables();
      for (i1 = 0; i1 < localList.size(); i1++)
      {
        localTableModel = (TableModel)localList.get(i1);
        if (localTableModel.isCloseMode())
          continue;
        e(localTableModel.getVarValue() + ".close();");
      }
      localHashMap.put(((DBModel)localObject).getVarValue(), localObject);
    }
    localIterator = paramRulePackage.getEnvionment().getDBModels();
    localHashMap.clear();
    while (localIterator.hasNext())
    {
      localObject = (DBModel)localIterator.next();
      if (localHashMap.get(((DBModel)localObject).getVarValue()) != null)
        continue;
      e(((DBModel)localObject).getVarValue() + ".freeConnection();");
      localHashMap.put(((DBModel)localObject).getVarValue(), localObject);
    }
    c(1);
    e("} catch ( Exception e) {");
    b(1);
    if (!paramRulePackage.getCatchActions().isEmpty())
    {
      b(1);
      localObject = paramRulePackage.getCatchActions().getActions();
      while (((Iterator)localObject).hasNext())
        e((IElement)((Iterator)localObject).next());
      c(1);
    }
    e("try { ");
    b(1);
    localIterator = paramRulePackage.getEnvionment().getDBModels();
    localHashMap.clear();
    while (localIterator.hasNext())
    {
      localObject = (DBModel)localIterator.next();
      if (localHashMap.get(((DBModel)localObject).getVarValue()) != null)
        continue;
      if ((((DBModel)localObject).getConnType() == 0) || (((DBModel)localObject).getConnType() == 3))
        e(((DBModel)localObject).getVarValue() + ".rollback();");
      localList = ((DBModel)localObject).getTables();
      for (i1 = 0; i1 < localList.size(); i1++)
      {
        localTableModel = (TableModel)localList.get(i1);
        if (localTableModel.isCloseMode())
          continue;
        e(localTableModel.getVarValue() + ".close();");
      }
      localHashMap.put(((DBModel)localObject).getVarValue(), localObject);
    }
    c(1);
    e("} catch ( Exception temp_ex1) {");
    e("} finally {");
    b(1);
    localIterator = paramRulePackage.getEnvionment().getDBModels();
    localHashMap.clear();
    while (localIterator.hasNext())
    {
      localObject = (DBModel)localIterator.next();
      if (localHashMap.get(((DBModel)localObject).getVarValue()) != null)
        continue;
      e(((DBModel)localObject).getVarValue() + ".freeConnection();");
      localHashMap.put(((DBModel)localObject).getVarValue(), localObject);
    }
    c(1);
    e("}");
    e("throw e;");
    c(1);
    e("} catch ( Throwable temp_ex) {");
    b(1);
    e("try { ");
    b(1);
    localIterator = paramRulePackage.getEnvionment().getDBModels();
    localHashMap.clear();
    while (localIterator.hasNext())
    {
      localObject = (DBModel)localIterator.next();
      if (localHashMap.get(((DBModel)localObject).getVarValue()) != null)
        continue;
      if ((((DBModel)localObject).getConnType() == 0) || (((DBModel)localObject).getConnType() == 3))
        e(((DBModel)localObject).getVarValue() + ".rollback();");
      localList = ((DBModel)localObject).getTables();
      for (i1 = 0; i1 < localList.size(); i1++)
      {
        localTableModel = (TableModel)localList.get(i1);
        if (localTableModel.isCloseMode())
          continue;
        e(localTableModel.getVarValue() + ".close();");
      }
      localHashMap.put(((DBModel)localObject).getVarValue(), localObject);
    }
    c(1);
    e("} catch ( Exception temp_ex1) {");
    e("} finally {");
    b(1);
    localIterator = paramRulePackage.getEnvionment().getDBModels();
    localHashMap.clear();
    while (localIterator.hasNext())
    {
      localObject = (DBModel)localIterator.next();
      if (localHashMap.get(((DBModel)localObject).getVarValue()) != null)
        continue;
      e(((DBModel)localObject).getVarValue() + ".freeConnection();");
      localHashMap.put(((DBModel)localObject).getVarValue(), localObject);
    }
    c(1);
    e("}");
    e("throw new RuleEngineException(MessageUtil.format(\"ruleException.info\",new String[]{\"" + h(this.f.getDisplayName()) + "\",temp_ex.getStackTrace()[0].toString()}),temp_ex);");
    c(1);
    e("} finally {");
    b(1);
    c(1);
    e("}");
    e(paramRulePackage);
    e("return mr_i;");
  }

  protected Object a(RulePackage paramRulePackage, ITreeNode paramITreeNode)
  {
    this.e = paramRulePackage;
    if (((paramITreeNode instanceof IRuleTree)) && ((((IRuleTree)paramITreeNode).isRunBreak()) || (((IRuleTree)paramITreeNode).getMainPackage() == null)))
      this.f = this.e;
    else
      this.f = paramITreeNode;
    String str1 = "J" + paramITreeNode.getUuid();
    if ((paramITreeNode instanceof RulePackage))
      str1 = paramRulePackage.getRuleClassName().trim();
    e("public final class " + str1 + " extends RuleContext {");
    b(1);
    f(this.f.getDisplayName());
    e("public " + str1 + "() { super() ; };");
    c();
    c(paramRulePackage);
    c();
    e("public int excuteRule()  throws Exception {");
    b(1);
    if (paramRulePackage.getStartTime() != 0L)
      e("if ( getCurrentTime() < " + paramRulePackage.getStartTime() + "L ) return M_RETURN_DEFAULT ;");
    if (paramRulePackage.getEndTime() != 0L)
      e("if ( getCurrentTime() > " + paramRulePackage.getEndTime() + "L ) return M_RETURN_DEFAULT ;");
    g(paramRulePackage);
    e("do { mr_i = excute() ; } while ( mr_i == M_RETURN_RESTART );");
    h(paramRulePackage);
    c(1);
    e("}");
    e("private int excute()  throws Exception {");
    b(1);
    Iterator localIterator1;
    if ((this.f instanceof IRuleSet))
    {
      localIterator1 = this.f.getAcceptElements(new o(this));
      this.n = new ArrayList();
      while (localIterator1.hasNext())
        this.n.add(localIterator1.next());
    }
    else if ((this.f instanceof IRule))
    {
      this.n = new ArrayList(1);
      this.n.add(this.f);
    }
    e("int rt = M_RETURN_DEFAULT ;");
    if ((this.f instanceof RulePackage))
    {
      localIterator1 = this.f.getChildrenIterator();
      while (localIterator1.hasNext())
        a(localIterator1.next(), this.n, this.f);
    }
    else
    {
      a(this.f, this.n, paramRulePackage);
    }
    e("return rt ;");
    c(1);
    e("}");
    f(paramRulePackage);
    for (int i1 = 0; i1 < this.n.size(); i1++)
      if ((this.n.get(i1) instanceof Rule))
      {
        a((Rule)this.n.get(i1), i1);
      }
      else if ((this.n.get(i1) instanceof DecisionRule))
      {
        a((DecisionRule)this.n.get(i1), i1);
      }
      else if ((this.n.get(i1) instanceof DecisionMultiRule))
      {
        a((DecisionMultiRule)this.n.get(i1), i1);
      }
      else if ((this.n.get(i1) instanceof ExpressionRule))
      {
        a((ExpressionRule)this.n.get(i1), i1);
      }
      else if ((this.n.get(i1) instanceof DecisionRelateRule))
      {
        a((DecisionRelateRule)this.n.get(i1), i1);
      }
      else if ((this.n.get(i1) instanceof RuleSet))
      {
        a((RuleSet)this.n.get(i1), this.n, i1);
      }
      else if ((this.n.get(i1) instanceof RuleSetFlow))
      {
        a((RuleSetFlow)this.n.get(i1), this.n, i1);
      }
      else if ((this.n.get(i1) instanceof RuleTreeFlow))
      {
        a((RuleTreeFlow)this.n.get(i1), this.n, i1);
      }
      else
      {
        if (!(this.n.get(i1) instanceof RulePoolFlow))
          continue;
        a((RulePoolFlow)this.n.get(i1), this.n, i1);
      }
    Iterator localIterator2 = paramRulePackage.getEnvionment().getAcceptElements(new p(this));
    while (localIterator2.hasNext())
    {
      SheetTable localSheetTable = (SheetTable)localIterator2.next();
      if ((!localSheetTable.isSaveValue()) || (localSheetTable.getSheetValues().size() <= 0))
        continue;
      d("private final static String[] ARRAY" + localSheetTable.getVarValue().toUpperCase() + "(){ return new String[]{");
      for (int i3 = 0; i3 < localSheetTable.getSheetValues().size(); i3++)
      {
        d("\"" + ((SheetValue)localSheetTable.getSheetValues().get(i3)).getParsedValue() + "\"");
        if (i3 == localSheetTable.getSheetValues().size() - 1)
          continue;
        d(",");
      }
      d("};}");
      c();
    }
    e("public RuleContext copy() {");
    e("    return new " + str1 + "();");
    e("}");
    e("public int excuteRule(String ruleName) throws Exception {");
    b(1);
    g(paramRulePackage);
    e(" if (ruleName == null || ruleName.length() == 0 ) {");
    e("do { mr_i =excute(); } while ( mr_i == M_RETURN_RESTART );");
    e("}");
    for (int i2 = 0; i2 < this.n.size(); i2++)
    {
      if (!(this.n.get(i2) instanceof IRuleTree))
        continue;
      localObject1 = (IRuleTree)this.n.get(i2);
      if (!((IRuleTree)localObject1).supportVisitRule())
        continue;
      e("else if (ruleName.equals(\"" + ((IRuleTree)localObject1).getVisitRuleName() + "\") ) {");
      e("do { mr_i = excuteRule" + i2 + "(rootRuleLog); } while ( mr_i == M_RETURN_RESTART );");
      e("}");
    }
    h(paramRulePackage);
    c(1);
    e("}");
    Object localObject4;
    if (paramRulePackage.getEnvionment().hasSetInOut())
    {
      e("protected String[] getInputNames() {");
      localIterator3 = paramRulePackage.getEnvionment().getInVariables();
      for (localObject1 = ""; localIterator3.hasNext(); localObject1 = localObject1 + "\"" + ((IBusinessObject)localObject2).getVarValue() + "\",")
        localObject2 = (IBusinessObject)localIterator3.next();
      if (((String)localObject1).length() > 0)
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
      e("\treturn new String[]{" + (String)localObject1 + "};");
      e("}");
      e("protected String[] getOutputNames() {");
      localIterator3 = paramRulePackage.getEnvionment().getOutVariables();
      for (localObject1 = ""; localIterator3.hasNext(); localObject1 = localObject1 + "\"" + ((IBusinessObject)localObject2).getVarValue() + "\",")
        localObject2 = (IBusinessObject)localIterator3.next();
      if (((String)localObject1).length() > 0)
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
      e("\treturn new String[]{" + (String)localObject1 + "};");
      e("}");
      e("public Map getValueTypes() {");
      e("Map valueTypes = new HashMap();");
      localIterator3 = paramRulePackage.getEnvionment().getAllInoutVariables();
      while (localIterator3.hasNext())
      {
        localObject2 = (IBusinessObject)localIterator3.next();
        e("valueTypes.put(\"" + ((IBusinessObject)localObject2).getVarValue() + "\",\"" + ((IBusinessObject)localObject2).getValueType() + "\");");
      }
      e("\treturn valueTypes;");
      e("}");
      e("public Map getValueDisplays() {");
      e("Map valueTypes = new HashMap();");
      localIterator3 = paramRulePackage.getEnvionment().getAllInoutVariables();
      while (localIterator3.hasNext())
      {
        localObject2 = (IBusinessObject)localIterator3.next();
        e("valueTypes.put(\"" + ((IBusinessObject)localObject2).getVarValue() + "\",\"" + ((IBusinessObject)localObject2).getDisplayName() + "\");");
      }
      e("\treturn valueTypes;");
      e("}");
      e("public Map getValueEnums(String varname) {");
      localIterator3 = paramRulePackage.getEnvionment().getAllInoutVariables();
      while (localIterator3.hasNext())
      {
        localObject2 = (IBusinessObject)localIterator3.next();
        localObject3 = paramRulePackage.getEnvionment().getEnums(((IBusinessObject)localObject2).getValueType(), ((IBusinessObject)localObject2).getDisplayName());
        if (!((Iterator)localObject3).hasNext())
          continue;
        e("if ( varname.equals(\"" + ((IBusinessObject)localObject2).getValueName() + "\") ) {");
        e("Map valueTypes = new LinkedHashMap();");
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ConstantEnum)((Iterator)localObject3).next();
          e("valueTypes.put(\"" + ((ConstantEnum)localObject4).getValueName() + "\",\"" + ((ConstantEnum)localObject4).getDisplayName() + "\");");
        }
        e("\treturn valueTypes;");
        e("}");
      }
      e("\treturn null;");
      e("}");
    }
    e("private Node initXmlNode(String nodeName) throws Exception {");
    b(1);
    Iterator localIterator3 = paramRulePackage.getEnvionment().getXmlNodes();
    while (localIterator3.hasNext())
    {
      localObject1 = (XmlNode)localIterator3.next();
      e("if ( nodeName.equals(\"" + ((XmlNode)localObject1).getVarName() + "\") ) {");
      b(1);
      e(((XmlNode)localObject1).getVarValue() + " =XmlFactory.newIntance().newNode(\"" + ((XmlNode)localObject1).getNodeName() + "\");");
      e(((XmlNode)localObject1).getVarValue() + ".setEncoding(\"" + ((XmlNode)localObject1).getEncoding() + "\");");
      b((XmlNode)localObject1);
      e("return " + ((XmlNode)localObject1).getVarValue() + ";");
      c(1);
      e("}");
      c((XmlNode)localObject1);
    }
    e("return null;");
    c(1);
    e("}");
    e("public void init() {");
    b(1);
    e("try {");
    Object localObject1 = paramRulePackage.getEnvionment().getTreeNodes();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TreeValueNode)((Iterator)localObject1).next();
      if ((!((TreeValueNode)localObject2).needInit()) || (b))
        continue;
      e("MemoryShare.getInstance().putInitObject(\"" + ((TreeValueNode)localObject2).getInitName() + "\",create" + ((TreeValueNode)localObject2).getUuid() + "(false));");
    }
    localIterator2 = paramRulePackage.getEnvionment().getSheetTables();
    while (localIterator2.hasNext())
    {
      localObject2 = (SheetTable)localIterator2.next();
      if ((!((SheetTable)localObject2).needInit()) || (b))
        continue;
      e("MemoryShare.getInstance().putInitObject(\"" + ((SheetTable)localObject2).getInitName() + "\",create" + ((SheetTable)localObject2).getUuid() + "(false));");
    }
    localIterator2 = paramRulePackage.getEnvionment().getSheetMaps();
    while (localIterator2.hasNext())
    {
      localObject2 = (SheetMap)localIterator2.next();
      if ((!((SheetMap)localObject2).needInit()) || (b))
        continue;
      e("MemoryShare.getInstance().putInitObject(\"" + ((SheetMap)localObject2).getInitName() + "\",create" + ((SheetMap)localObject2).getUuid() + "(false));");
    }
    e("} catch (Exception e) {}");
    c(1);
    e("}");
    e("public void destroy() {");
    b(1);
    e("try {");
    localObject1 = paramRulePackage.getEnvionment().getTreeNodes();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TreeValueNode)((Iterator)localObject1).next();
      if ((!((TreeValueNode)localObject2).needInit()) || (b))
        continue;
      e("MemoryShare.getInstance().removeInitObject(\"" + ((TreeValueNode)localObject2).getInitName() + "\");");
    }
    localIterator2 = paramRulePackage.getEnvionment().getSheetTables();
    while (localIterator2.hasNext())
    {
      localObject2 = (SheetTable)localIterator2.next();
      if ((!((SheetTable)localObject2).needInit()) || (b))
        continue;
      e("MemoryShare.getInstance().removeInitObject(\"" + ((SheetTable)localObject2).getInitName() + "\");");
    }
    localIterator2 = paramRulePackage.getEnvionment().getSheetMaps();
    while (localIterator2.hasNext())
    {
      localObject2 = (SheetMap)localIterator2.next();
      if ((!((SheetMap)localObject2).needInit()) || (b))
        continue;
      e("MemoryShare.getInstance().removeInitObject(\"" + ((SheetMap)localObject2).getInitName() + "\");");
    }
    e("} catch (Exception e) {}");
    c(1);
    e("}");
    localObject1 = paramRulePackage.getEnvionment().getTreeNodes();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TreeValueNode)((Iterator)localObject1).next();
      e("private TreeValue create" + ((TreeValueNode)localObject2).getUuid() + "(boolean inited) throws Exception {");
      b(1);
      if (((TreeValueNode)localObject2).needInit())
      {
        e("TreeValue sheet =  null ;");
        if (!b)
          e("if ( inited )  sheet =  MemoryShare.getInstance().getInitTree(\"" + ((TreeValueNode)localObject2).getInitName() + "\")  ;");
        e("if (sheet == null) {");
        if (((TreeValueNode)localObject2).isSingleValue())
          e("sheet = new SingleTreeValue(" + ((TreeValueNode)localObject2).getInfoString() + ");");
        else
          e("sheet = new MultiTreeValue(" + ((TreeValueNode)localObject2).getInfoString() + ");");
        e("}");
        e("return sheet ;");
      }
      else if (((TreeValueNode)localObject2).isSingleValue())
      {
        e("return new SingleTreeValue(" + ((TreeValueNode)localObject2).getInfoString() + ");");
      }
      else
      {
        e("return new MultiTreeValue(" + ((TreeValueNode)localObject2).getInfoString() + ");");
      }
      c(1);
      e("}");
      e("private void init" + ((TreeValueNode)localObject2).getUuid() + "() throws Exception {");
      b(1);
      a((TreeValueNode)localObject2);
      c(1);
      e("}");
    }
    localIterator2 = paramRulePackage.getEnvionment().getSheetTables();
    StringBuffer localStringBuffer1;
    Object localObject5;
    while (localIterator2.hasNext())
    {
      localObject2 = (SheetTable)localIterator2.next();
      if ((((SheetTable)localObject2).getDBModel() != null) && (((SheetTable)localObject2).getTableFunction("loadFromSql") != null) && (((SheetTable)localObject2).getSqlSelect().length() > 0))
        continue;
      e("private Sheet create" + ((SheetTable)localObject2).getUuid() + "(boolean inited) throws Exception {");
      b(1);
      if (((SheetTable)localObject2).needInit())
      {
        e("Sheet sheet = null ;");
        if (!b)
          e("if ( inited ) sheet =  MemoryShare.getInstance().getInitSheet(\"" + ((SheetTable)localObject2).getInitName() + "\");");
      }
      else
      {
        e("Sheet sheet = null;");
      }
      e("if (sheet == null) {");
      localObject3 = new StringBuffer(" new String[]{");
      localObject4 = new StringBuffer(" new String[]{");
      localStringBuffer1 = new StringBuffer(" new String[]{");
      localObject5 = ((SheetTable)localObject2).getFields();
      for (int i4 = 0; i4 < ((List)localObject5).size(); i4++)
      {
        ((StringBuffer)localObject3).append("\"").append(((SheetFieldModel)((List)localObject5).get(i4)).getFieldName()).append("\"");
        ((StringBuffer)localObject4).append("\"").append(((SheetFieldModel)((List)localObject5).get(i4)).getDisplayName()).append("\"");
        localStringBuffer1.append("\"").append(((SheetFieldModel)((List)localObject5).get(i4)).getValueType()).append("\"");
        if (i4 >= ((List)localObject5).size() - 1)
          continue;
        ((StringBuffer)localObject3).append(",");
        ((StringBuffer)localObject4).append(",");
        localStringBuffer1.append(",");
      }
      ((StringBuffer)localObject3).append("}");
      ((StringBuffer)localObject4).append("}");
      localStringBuffer1.append("}");
      if (((SheetTable)localObject2).isLinkList())
        e("sheet = new ListSheet(" + localObject3 + "," + localObject4 + "," + localStringBuffer1 + ");");
      else
        e("sheet = new ArraySheet(" + localObject3 + "," + localObject4 + "," + localStringBuffer1 + ");");
      if (((SheetTable)localObject2).getNullDefault() != 0)
        e("sheet.setNullDefault(" + ((SheetTable)localObject2).getNullDefault() + ");");
      if ((((SheetTable)localObject2).isSaveValue()) && (((SheetTable)localObject2).getSheetValues().size() > 0))
      {
        d("sheet.loadDataFromString(ARRAY" + ((SheetTable)localObject2).getVarValue().toUpperCase() + "(),new String[]{");
        for (i4 = 0; i4 < ((SheetTable)localObject2).getFields().size(); i4++)
        {
          d("\"" + ((SheetFieldModel)((SheetTable)localObject2).getFields().get(i4)).getValueType() + "\"");
          if (i4 == ((SheetTable)localObject2).getFields().size() - 1)
            continue;
          d(",");
        }
        d("});");
        c();
      }
      if (((SheetTable)localObject2).isFromResource())
      {
        String str2 = ((SheetTable)localObject2).getTestFile();
        if (StringUtil.isEmpty(str2))
          str2 = ((SheetTable)localObject2).getDisplayName();
        e("sheet.setResourceName(\"" + str2 + "\");");
        e("sheet.setUpdateinternal(" + ((SheetTable)localObject2).getUpdateinternal() + ");");
      }
      else if (((SheetTable)localObject2).isValidFromDB())
      {
        e("sheet.setDbName(\"" + ((SheetTable)localObject2).getDBModel().getDatasourceName() + "\");");
        e("sheet.setSqlScript(\"" + ((SheetTable)localObject2).getSqlScript() + "\");");
        e("sheet.setUpdateinternal(" + ((SheetTable)localObject2).getUpdateinternal() + ");");
      }
      e("}");
      e("return sheet ;");
      c(1);
      e("}");
    }
    localIterator2 = paramRulePackage.getEnvionment().getAcceptElements(new q(this));
    e("private void initSheetTable() throws Exception {");
    b(1);
    while (localIterator2.hasNext())
    {
      localObject2 = (SheetTable)localIterator2.next();
      if (((SheetTable)localObject2).getShareType() == 1)
      {
        if (!b)
          e(((SheetTable)localObject2).getVarValue() + " = MemoryShare.getInstance().getShareSheet(\"" + ((SheetTable)localObject2).getEnglishName() + "\");");
        e("if ( " + ((SheetTable)localObject2).getVarValue() + " == null ) {");
        a((SheetTable)localObject2);
        e("}");
      }
      else if (((SheetTable)localObject2).getShareType() == 2)
      {
        if (!b)
          e(((SheetTable)localObject2).getVarValue() + " = MemoryShare.getInstance().getCloneSheet(\"" + ((SheetTable)localObject2).getEnglishName() + "\");");
        e("if ( " + ((SheetTable)localObject2).getVarValue() + " == null ) {");
        a((SheetTable)localObject2);
        e("}");
      }
      else
      {
        a((SheetTable)localObject2);
      }
    }
    c(1);
    e("}");
    Object localObject2 = paramRulePackage.getEnvionment().getSheetMaps();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (SheetMap)((Iterator)localObject2).next();
      e("private IKeyValue create" + ((SheetMap)localObject3).getUuid() + "(boolean inited) throws Exception {");
      b(1);
      if (((SheetMap)localObject3).needInit())
      {
        e("IKeyValue sheet = null ;");
        if (!b)
          e("if ( inited) sheet =  MemoryShare.getInstance().getInitMap(\"" + ((SheetMap)localObject3).getInitName() + "\")  ;");
      }
      else
      {
        e("IKeyValue sheet = null ;");
      }
      e("if (sheet == null) {");
      localObject4 = new StringBuffer(" new String[]{");
      localStringBuffer1 = new StringBuffer(" new String[]{");
      localObject5 = ((SheetMap)localObject3).getFieldValueList();
      for (int i5 = 0; i5 < ((List)localObject5).size(); i5++)
      {
        ((StringBuffer)localObject4).append("\"").append(((MapValue)((List)localObject5).get(i5)).getParsedKey()).append("\"");
        localStringBuffer1.append("\"").append(((MapValue)((List)localObject5).get(i5)).getParsedValue()).append("\"");
        if (i5 >= ((List)localObject5).size() - 1)
          continue;
        ((StringBuffer)localObject4).append(",");
        localStringBuffer1.append(",");
      }
      ((StringBuffer)localObject4).append("}");
      localStringBuffer1.append("}");
      e("sheet = new KeyValue(\"" + ((SheetMap)localObject3).getDisplayName() + "\",\"" + ((SheetMap)localObject3).getKeyType() + "\",\"" + ((SheetMap)localObject3).getValueType() + "\");");
      if (((List)localObject5).size() > 0)
        e("sheet.loadDataFromString(" + localObject4 + "," + localStringBuffer1 + ");");
      e("}");
      e("return sheet ;");
      c(1);
      e("}");
    }
    e("private void initMap() throws Exception {");
    b(1);
    localObject2 = paramRulePackage.getEnvionment().getAcceptElements(new r(this));
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (SheetMap)((Iterator)localObject2).next();
      e("if ( dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\") != null && dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\") instanceof IKeyValue ) {");
      e(((SheetMap)localObject3).getVarValue() + " = (IKeyValue)dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\") ;");
      e("}");
      if (((SheetMap)localObject3).isFromResource())
      {
        e("else {");
        e(((SheetMap)localObject3).getVarValue() + " = create" + ((SheetMap)localObject3).getUuid() + "(true);");
        d(((SheetMap)localObject3).getVarValue() + ".loadFromResource(\"" + ((SheetMap)localObject3).getDisplayName() + "\");");
        c();
        e("}");
      }
      else
      {
        e("else {");
        e(((SheetMap)localObject3).getVarValue() + " = create" + ((SheetMap)localObject3).getUuid() + "(true);");
        e(" if ( dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\") != null && dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\") instanceof java.util.Map ) {");
        e(((SheetMap)localObject3).getVarValue() + ".linkData((java.util.Map)dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\"));");
        e("}");
        e(" else if ( dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\") != null && dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\") instanceof java.io.File ) {");
        e(((SheetMap)localObject3).getVarValue() + ".loadFromExcelFile((java.io.File)dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\"));");
        e("}");
        e("else if ( dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\") != null && dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\") instanceof String ) {");
        e(((SheetMap)localObject3).getVarValue() + ".loadFromExcelFile(new java.io.File((String)dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\")));");
        e("}");
        e("else if ( dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\") != null && dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\") instanceof List ) {");
        e(((SheetMap)localObject3).getVarValue() + ".loadFromList((List)dtcObjects.get(\"" + ((SheetMap)localObject3).getValueName() + "\"));");
        e("}");
        e("}");
      }
    }
    Object localObject3 = paramRulePackage.getEnvionment().getSoapServices();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (SoapService)((Iterator)localObject3).next();
      localStringBuffer1 = new StringBuffer(" new String[]{");
      localObject5 = new StringBuffer(" new String[]{");
      StringBuffer localStringBuffer2 = new StringBuffer(" new String[]{");
      StringBuffer localStringBuffer3 = new StringBuffer(" new int[]{");
      List localList = ((SoapService)localObject4).getAllAttributes();
      for (int i6 = 0; i6 < localList.size(); i6++)
      {
        localStringBuffer1.append("\"").append(((SoapParameter)localList.get(i6)).getValueName()).append("\"");
        ((StringBuffer)localObject5).append("\"").append(((SoapParameter)localList.get(i6)).getDisplayName()).append("\"");
        localStringBuffer2.append("\"").append(((SoapParameter)localList.get(i6)).getValueType()).append("\"");
        localStringBuffer3.append(((SoapParameter)localList.get(i6)).getRetType());
        if (i6 >= localList.size() - 1)
          continue;
        localStringBuffer1.append(",");
        ((StringBuffer)localObject5).append(",");
        localStringBuffer2.append(",");
        localStringBuffer3.append(",");
      }
      localStringBuffer1.append("}");
      ((StringBuffer)localObject5).append("}");
      localStringBuffer2.append("}");
      localStringBuffer3.append("}");
      e(((SoapService)localObject4).getVarValue() + " = com.flagleader.soap.SoapFactory.newIntance().getSoap(" + localStringBuffer1 + "," + localObject5 + "," + localStringBuffer2 + "," + localStringBuffer3 + ",\"" + ((SoapService)localObject4).getResultType() + "\",\"" + ((SoapService)localObject4).getEndpointURL() + "\",\"" + ((SoapService)localObject4).getServiceNS() + "\",\"" + ((SoapService)localObject4).getActionUrl() + "\",\"" + ((SoapService)localObject4).getPortName() + "\",\"" + ((SoapService)localObject4).getOperationName() + "\",\"" + ((SoapService)localObject4).getServiceName() + "\");");
      e(((SoapService)localObject4).getVarValue() + ".setSoapVersion(\"" + ((SoapService)localObject4).getSoapVersion() + "\");");
      if ((((SoapService)localObject4).getParamNS() == null) || (((SoapService)localObject4).getParamNS().length() <= 0))
        continue;
      e(((SoapService)localObject4).getVarValue() + ".setParamNS(\"" + ((SoapService)localObject4).getParamNS() + "\");");
    }
    c(1);
    e("}");
    if (paramRulePackage.getDblog() == 1)
    {
      e("public int getLogDBType() {");
      b(1);
      e("return " + paramRulePackage.getDblog() + " ; ");
      c(1);
      e("}");
    }
    if (paramRulePackage.getLogType() == 0)
    {
      e("public int getLogTraceType() {");
      b(1);
      e("return " + paramRulePackage.getLogType() + " ; ");
      c(1);
      e("}");
    }
    if (paramRulePackage.getLogTimes() == 1)
    {
      e("public int getLogTimeType() {");
      b(1);
      e("return " + paramRulePackage.getLogTimes() + " ; ");
      c(1);
      e("}");
    }
    e("public String getRuleName() {");
    b(1);
    e("return \"" + paramRulePackage.getExeRulePackageName() + "\" ; ");
    c(1);
    e("}");
    e("public String getRuleVersion() {");
    b(1);
    e("return \"" + paramRulePackage.getVersion() + "\" ; ");
    c(1);
    e("}");
    e("public String getDescription() {");
    b(1);
    e("return \"" + paramRulePackage.getDisplayName() + "\" ; ");
    c(1);
    e("}");
    e("public int getWebRole() {");
    b(1);
    e("return " + paramRulePackage.getWebrole() + " ; ");
    c(1);
    e("}");
    e("public void recordVisitRule(String ruleSetName,String ruleName) {");
    b(1);
    e("if (rootRuleCheckMap == null ) rootRuleCheckMap = new HashMap(); ");
    e("List rulesetlist = (List)rootRuleCheckMap.get(ruleSetName) ;");
    e("if ( rulesetlist == null ) {rulesetlist=new ArrayList();");
    e("rootRuleCheckMap.put(ruleSetName,rulesetlist);");
    e("}");
    e("rulesetlist.add(ruleName); ");
    c(1);
    e("}");
    e("private void takeSnapShot(RuleLogList ruleLog) {");
    b(1);
    e("if (snapShot == null || ruleLog == null ) return; ");
    e("snapShot.add(ruleLog) ;");
    c(1);
    e("}");
    c(1);
    e("}");
    return null;
  }

  private void a(TreeValueNode paramTreeValueNode)
  {
    e("if ( dtcObjects.get(\"" + paramTreeValueNode.getValueName() + "\") != null && dtcObjects.get(\"" + paramTreeValueNode.getValueName() + "\") instanceof TreeValue ) {");
    e(paramTreeValueNode.getVarValue() + " =(TreeValue)(dtcObjects.get(\"" + paramTreeValueNode.getValueName() + "\"));");
    e("} else if ( " + paramTreeValueNode.getVarValue() + "== null ) {");
    e(paramTreeValueNode.getVarValue() + " = create" + paramTreeValueNode.getUuid() + "(true) ;");
    e("}");
    e("if ( dtcObjects.get(\"" + paramTreeValueNode.getValueName() + "\") != null && dtcObjects.get(\"" + paramTreeValueNode.getValueName() + "\") instanceof String && !StringUtil.isEmpty((String)dtcObjects.get(\"" + paramTreeValueNode.getValueName() + "\")) ) ");
    e(paramTreeValueNode.getVarValue() + ".loadFromXml((String)dtcObjects.get(\"" + paramTreeValueNode.getValueName() + "\"));");
  }

  private void a(SheetTable paramSheetTable)
  {
    e("if ( dtcObjects.get(\"" + paramSheetTable.getValueName() + "\") != null && dtcObjects.get(\"" + paramSheetTable.getValueName() + "\") instanceof Sheet ) {");
    e(paramSheetTable.getVarValue() + " = (Sheet)dtcObjects.get(\"" + paramSheetTable.getValueName() + "\");");
    e("}");
    if (((paramSheetTable.isSaveValue()) && (paramSheetTable.getSheetValues().size() > 0)) || (paramSheetTable.isFromResource()) || (paramSheetTable.isValidFromDB()))
    {
      e("else {");
      e(paramSheetTable.getVarValue() + " = create" + paramSheetTable.getUuid() + "(true);");
      e("}");
    }
    else
    {
      e("else {");
      e(paramSheetTable.getVarValue() + " = create" + paramSheetTable.getUuid() + "(true);");
      e(" if ( dtcObjects.get(\"" + paramSheetTable.getValueName() + "\") != null && dtcObjects.get(\"" + paramSheetTable.getValueName() + "\") instanceof java.io.File ) {");
      e(paramSheetTable.getVarValue() + ".loadFromExcelFile((java.io.File)dtcObjects.get(\"" + paramSheetTable.getValueName() + "\"));");
      e("}");
      e("else if ( dtcObjects.get(\"" + paramSheetTable.getValueName() + "\") != null && dtcObjects.get(\"" + paramSheetTable.getValueName() + "\") instanceof String ) {");
      e(paramSheetTable.getVarValue() + ".loadFromExcelFile(new java.io.File((String)dtcObjects.get(\"" + paramSheetTable.getValueName() + "\")));");
      e("}");
      e("else if ( dtcObjects.get(\"" + paramSheetTable.getValueName() + "\") != null && dtcObjects.get(\"" + paramSheetTable.getValueName() + "\") instanceof List ) {");
      e(paramSheetTable.getVarValue() + ".loadFromList((List)dtcObjects.get(\"" + paramSheetTable.getValueName() + "\"));");
      e("}");
      e("}");
    }
  }

  private String a(AbstractExcelFieldModel paramAbstractExcelFieldModel)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("new FieldInfo(\"");
    localStringBuffer.append(paramAbstractExcelFieldModel.getDisplayName()).append("\",\"");
    localStringBuffer.append(paramAbstractExcelFieldModel.getValueType()).append("\",");
    localStringBuffer.append(paramAbstractExcelFieldModel.getFieldPos()).append(",");
    localStringBuffer.append(paramAbstractExcelFieldModel.getAmountType()).append(",");
    if (paramAbstractExcelFieldModel.hasChildField())
    {
      localStringBuffer.append("new FieldInfo[]{");
      List localList = paramAbstractExcelFieldModel.getTypeSuperChildrenList(AbstractExcelFieldModel.class);
      for (int i1 = 0; i1 < localList.size(); i1++)
      {
        localStringBuffer.append(a((AbstractExcelFieldModel)localList.get(i1)));
        if (i1 == localList.size() - 1)
          continue;
        localStringBuffer.append(",");
      }
      localStringBuffer.append("}");
    }
    else
    {
      localStringBuffer.append("null");
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }

  private void a(Object paramObject, List paramList, ITreeNode paramITreeNode)
  {
    if ((paramObject instanceof RuleSet))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(rootRuleLog) ;");
      e("if ( rt >= M_RETURN_CONTINUE  ){ return rt ;}");
    }
    else if ((paramObject instanceof RuleSetFlow))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(rootRuleLog) ;");
      e("if ( rt >= M_RETURN_CONTINUE  ){ return rt ;}");
    }
    else if ((paramObject instanceof RuleTreeFlow))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(rootRuleLog) ;");
      e("if ( rt >= M_RETURN_CONTINUE  ){ return rt ;}");
    }
    else if ((paramObject instanceof RulePoolFlow))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(rootRuleLog) ;");
      e("if ( rt >= M_RETURN_CONTINUE  ){ return rt ;}");
    }
    else if ((paramObject instanceof Rule))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(rootRuleLog) ;");
      e("if ( rt >= M_RETURN_CONTINUE  ){ return rt ;}");
    }
    else if ((paramObject instanceof DecisionRule))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(rootRuleLog) ;");
      e("if ( rt >= M_RETURN_CONTINUE  ){ return rt ;}");
    }
    else if ((paramObject instanceof DecisionMultiRule))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(rootRuleLog) ;");
      e("if ( rt >= M_RETURN_CONTINUE  ){ return rt ;}");
    }
    else if ((paramObject instanceof ExpressionRule))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(rootRuleLog) ;");
      e("if ( rt >= M_RETURN_CONTINUE  ){ return rt ;}");
    }
    else if ((paramObject instanceof DecisionRelateRule))
    {
      e("rt = excuteRule" + paramList.indexOf(paramObject) + "(rootRuleLog) ;");
      e("if ( rt >= M_RETURN_CONTINUE  ){ return rt ;}");
    }
    else if (((paramObject instanceof RuleMirror)) && (((RuleMirror)paramObject).getMemberElement() != null))
    {
      a(((RuleMirror)paramObject).getMemberElement(), paramList, paramITreeNode);
    }
  }

  public Object visitRuleFlowTransition(RuleFlowTransition paramRuleFlowTransition)
  {
    l();
    d("if (");
    Iterator localIterator = paramRuleFlowTransition.getTestConditions().getConditions();
    if (localIterator.hasNext())
      while (localIterator.hasNext())
        d((IElement)localIterator.next());
    else
      d("true");
    d(") {");
    c();
    b(1);
    Object localObject1 = null;
    if (paramRuleFlowTransition.getRuleSetFlow() != null)
      localObject1 = paramRuleFlowTransition.getRuleSetFlow().getFlowElement(paramRuleFlowTransition.getToUuid());
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof RuleFlowActivitie)))
    {
      localObject2 = (RuleFlowActivitie)localObject1;
      if (((RuleFlowActivitie)localObject2).getRuleObject() != null)
        a(((RuleFlowActivitie)localObject2).getRuleObject());
    }
    if (paramRuleFlowTransition.getRuleSetFlow() != null)
    {
      localObject2 = paramRuleFlowTransition.getRuleSetFlow().getNextTransitions(paramRuleFlowTransition.getToUuid());
      for (int i1 = 0; i1 < ((List)localObject2).size(); i1++)
        ((RuleFlowTransition)((List)localObject2).get(i1)).acceptVisitor(this);
    }
    c(1);
    e("}");
    return null;
  }

  public Object visitRuleSetFlow(RuleSetFlow paramRuleSetFlow)
  {
    if ((paramRuleSetFlow.isEmpty()) || (!paramRuleSetFlow.isActived()))
      return null;
    this.f = paramRuleSetFlow;
    f(paramRuleSetFlow.getDisplayName());
    if ((paramRuleSetFlow.getStartTime() != 0L) && (paramRuleSetFlow.getEndTime() != 0L))
      e("if ( getCurrentTime() >= " + paramRuleSetFlow.getStartTime() + "L  &&  getCurrentTime() <= " + paramRuleSetFlow.getEndTime() + "L ) { ");
    else if (paramRuleSetFlow.getStartTime() != 0L)
      e("if ( getCurrentTime() >= " + paramRuleSetFlow.getStartTime() + "L ) {");
    else if (paramRuleSetFlow.getEndTime() != 0L)
      e("if ( getCurrentTime() <= " + paramRuleSetFlow.getEndTime() + "L ) {");
    if ((paramRuleSetFlow.getStartTime() != 0L) || (paramRuleSetFlow.getEndTime() != 0L))
      b(1);
    List localList = paramRuleSetFlow.getNextTransitions(paramRuleSetFlow.getUuid());
    for (int i1 = 0; i1 < localList.size(); i1++)
      ((RuleFlowTransition)localList.get(i1)).acceptVisitor(this);
    if ((paramRuleSetFlow.getStartTime() != 0L) || (paramRuleSetFlow.getEndTime() != 0L))
    {
      c(1);
      e("}");
    }
    return null;
  }

  public Object visitRuleTreeFlow(RuleTreeFlow paramRuleTreeFlow)
  {
    if ((paramRuleTreeFlow.isEmpty()) || (!paramRuleTreeFlow.isActived()))
      return null;
    this.f = paramRuleTreeFlow;
    f(paramRuleTreeFlow.getDisplayName());
    if ((paramRuleTreeFlow.getStartTime() != 0L) && (paramRuleTreeFlow.getEndTime() != 0L))
      e("if ( getCurrentTime() >= " + paramRuleTreeFlow.getStartTime() + "L  &&  getCurrentTime() <= " + paramRuleTreeFlow.getEndTime() + "L ) { ");
    else if (paramRuleTreeFlow.getStartTime() != 0L)
      e("if ( getCurrentTime() >= " + paramRuleTreeFlow.getStartTime() + "L ) {");
    else if (paramRuleTreeFlow.getEndTime() != 0L)
      e("if ( getCurrentTime() <= " + paramRuleTreeFlow.getEndTime() + "L ) {");
    if ((paramRuleTreeFlow.getStartTime() != 0L) || (paramRuleTreeFlow.getEndTime() != 0L))
      b(1);
    List localList = paramRuleTreeFlow.getStartTransitions();
    for (int i1 = 0; i1 < localList.size(); i1++)
      ((RuleFlowTransition)localList.get(i1)).acceptVisitor(this);
    if ((paramRuleTreeFlow.getStartTime() != 0L) || (paramRuleTreeFlow.getEndTime() != 0L))
    {
      c(1);
      e("}");
    }
    return null;
  }

  public Object visitRuleSet(RuleSet paramRuleSet)
  {
    if (paramRuleSet != null)
    {
      this.f = paramRuleSet;
      if (!e())
      {
        e("try {");
        b(1);
        if (paramRuleSet.getStartTime() != 0L)
          e("if ( getCurrentTime() < " + paramRuleSet.getStartTime() + "L ) return M_RETURN_DEFAULT ;");
        if (paramRuleSet.getEndTime() != 0L)
          e("if ( getCurrentTime() > " + paramRuleSet.getEndTime() + "L ) return M_RETURN_DEFAULT ;");
      }
      Object localObject1;
      if ((paramRuleSet.isForType()) || (paramRuleSet.isInitTestType()))
      {
        l();
        localIterator = paramRuleSet.getRuleSetToken().getInitActions().getActions();
        while (localIterator.hasNext())
        {
          localObject1 = localIterator.next();
          if (!(localObject1 instanceof IElement))
            continue;
          ((IElement)localObject1).acceptVisitor(this);
          c();
        }
      }
      l();
      if (!paramRuleSet.isForEachType())
      {
        if (((paramRuleSet.isTestType()) || (paramRuleSet.isForType()) || (paramRuleSet.isInitTestType())) && (paramRuleSet.getRuleSetToken().getTestConditions().getConditions().hasNext()))
        {
          if ((paramRuleSet.isTestType()) || (paramRuleSet.isInitTestType()) || (paramRuleSet.getEditType() == 0))
          {
            if ((paramRuleSet.getPos() > 0) && (paramRuleSet.getRestartType() > 0))
              d("else ");
            d("if (");
          }
          else if (paramRuleSet.isForType())
          {
            d("while (");
          }
          localIterator = paramRuleSet.getRuleSetToken().getTestConditions().getConditions();
          if (localIterator.hasNext())
            while (localIterator.hasNext())
              d((IElement)localIterator.next());
          else
            d("true");
          d(") {");
          c();
          b(1);
        }
        else if ((paramRuleSet.getPos() > 0) && (paramRuleSet.getRestartType() > 0))
        {
          d("else {");
          c();
          b(1);
        }
      }
      else
      {
        paramRuleSet.getRuleSetToken().getForEachConditionToken().acceptVisitor(this);
        b(1);
      }
      if (paramRuleSet.isFirst())
      {
        localIterator = paramRuleSet.getRuleSetToken().getFirstActions().getActions();
        while (localIterator.hasNext())
        {
          localObject1 = localIterator.next();
          if (!(localObject1 instanceof IElement))
            continue;
          e((IElement)localObject1);
        }
      }
      Iterator localIterator = paramRuleSet.getRuleAndSets();
      while (localIterator.hasNext())
        a(localIterator.next());
      if (paramRuleSet.isForType())
      {
        localObject1 = paramRuleSet.getRuleSetToken().getBlockActions().getActions();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          if (!(localObject2 instanceof IElement))
            continue;
          e((IElement)localObject2);
        }
      }
      if (!paramRuleSet.isForEachType())
      {
        if (((paramRuleSet.isTestType()) || (paramRuleSet.isForType()) || (paramRuleSet.isInitTestType())) && (paramRuleSet.getRuleSetToken().getTestConditions().getConditions().hasNext()))
        {
          c(1);
          e("}");
        }
        else if ((paramRuleSet.getPos() > 0) && (paramRuleSet.getRestartType() > 0))
        {
          c(1);
          e("}");
        }
      }
      else
      {
        c(1);
        e("}");
      }
      if (!e())
      {
        c(1);
        e("} catch (Exception e) {");
        if (paramRuleSet.isSupportCatch())
        {
          b(1);
          localObject1 = paramRuleSet.getRuleSetToken().getCatchActions().getActions();
          while (((Iterator)localObject1).hasNext())
            e((IElement)((Iterator)localObject1).next());
          c(1);
        }
        e("if ( e instanceof RuleEngineException ) throw e ;");
        if (paramRuleSet.getExceptionType() == 0)
          e("\tthrow e ;");
        else if (paramRuleSet.getExceptionType() == 1)
        {
          if (paramRuleSet.getErrorMsg().length() > 0)
            e(" throw new RuleEngineException(\"" + h(paramRuleSet.getErrorMsg()) + "\",e);");
          else
            e(" throw new RuleEngineException(\"" + h(b(paramRuleSet)) + "\",e);");
        }
        else if (paramRuleSet.getExceptionType() == 2)
        {
          if (paramRuleSet.getErrorMsg().length() > 0)
            e(" throw new RuleEngineException(\"" + h(paramRuleSet.getErrorMsg()) + "\"+e.getLocalizedMessage(),e);");
          else
            e(" throw new RuleEngineException(\"" + h(b(paramRuleSet)) + "\"+e.getLocalizedMessage(),e);");
        }
        else
          paramRuleSet.getExceptionType();
        e("} catch (Throwable e1) {");
        if (paramRuleSet.getErrorMsg().length() > 0)
          e(" throw new RuleEngineException(\"" + h(paramRuleSet.getErrorMsg()) + "\",e1);");
        else
          e(" throw new RuleEngineException(\"" + h(b(paramRuleSet)) + "\"+e1.getMessage(),e1);");
        e("}");
      }
    }
    return null;
  }

  public Object visitRuleSetToken(RuleSetToken paramRuleSetToken)
  {
    return null;
  }

  private void a(Rule paramRule, int paramInt)
  {
    this.f = paramRule;
    f(b(paramRule));
    if (paramRule.isSyn())
      e("private synchronized int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    else
      e("private int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    b(1);
    if (!paramRule.isEmpty())
    {
      if (paramRule.needLog())
      {
        a(paramRule.toString(), paramRule.isEnableDataSnap());
        if (paramRule.needWhile())
          a("", "childRuleLog", paramRule.getRelateVarNames());
      }
      visitRule(paramRule);
      if ((paramRule.needLog()) && (paramRule.needWhile()))
        a(paramRule.getRelateVarNames(), "childRuleLog");
      if ((paramRule.isEnableDataSnap()) && (!e()) && (paramRule.needLog()))
        e("takeSnapShot(childRuleLog) ;");
    }
    if (paramRule.isRunBreak())
      e("return M_RETURN_EXIT;");
    else
      e("return M_RETURN_DEFAULT;");
    c(1);
    e("}");
  }

  private void a(DecisionRule paramDecisionRule, int paramInt)
  {
    f(b(paramDecisionRule));
    if (paramDecisionRule.isSyn())
      e("private synchronized int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    else
      e("private int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    b(1);
    if (!paramDecisionRule.isEmpty())
    {
      if (paramDecisionRule.needLog())
      {
        a(paramDecisionRule.toString(), paramDecisionRule.isEnableDataSnap());
        if (paramDecisionRule.needWhile())
          a("", "childRuleLog", paramDecisionRule.getRelateVarNames());
      }
      visitDecisionRule(paramDecisionRule);
      if ((paramDecisionRule.needLog()) && (paramDecisionRule.needWhile()))
        a(paramDecisionRule.getRelateVarNames(), "childRuleLog");
      if ((paramDecisionRule.isEnableDataSnap()) && (!e()) && (paramDecisionRule.needLog()))
        e("takeSnapShot(childRuleLog) ;");
    }
    if (paramDecisionRule.isRunBreak())
      e("return M_RETURN_EXIT;");
    else
      e("return M_RETURN_DEFAULT;");
    c(1);
    e("}");
  }

  private void a(DecisionMultiRule paramDecisionMultiRule, int paramInt)
  {
    f(b(paramDecisionMultiRule));
    if (paramDecisionMultiRule.isSyn())
      e("private synchronized int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    else
      e("private int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    b(1);
    if (!paramDecisionMultiRule.isEmpty())
    {
      if (paramDecisionMultiRule.needLog())
      {
        a(paramDecisionMultiRule.toString(), paramDecisionMultiRule.isEnableDataSnap());
        if (paramDecisionMultiRule.needWhile())
          a("", "childRuleLog", paramDecisionMultiRule.getRelateVarNames());
      }
      if (!paramDecisionMultiRule.isActived())
        e("if ( true ) return M_RETURN_DEFAULT;");
      a(paramDecisionMultiRule);
      b(1);
      visitDecisionMultiRule(paramDecisionMultiRule);
      c(1);
      b(paramDecisionMultiRule);
      if ((paramDecisionMultiRule.needLog()) && (paramDecisionMultiRule.needWhile()))
        a(paramDecisionMultiRule.getRelateVarNames(), "childRuleLog");
      if ((paramDecisionMultiRule.isEnableDataSnap()) && (!e()) && (paramDecisionMultiRule.needLog()))
        e("takeSnapShot(childRuleLog) ;");
    }
    if (paramDecisionMultiRule.isRunBreak())
      e("return M_RETURN_EXIT;");
    else
      e("return M_RETURN_DEFAULT;");
    c(1);
    e("}");
  }

  private void a(ExpressionRule paramExpressionRule, int paramInt)
  {
    this.f = paramExpressionRule;
    f(b(paramExpressionRule));
    if (paramExpressionRule.isSyn())
      e("private synchronized int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    else
      e("private int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    b(1);
    if (!paramExpressionRule.isEmpty())
    {
      if (paramExpressionRule.needLog())
      {
        a(paramExpressionRule.toString(), paramExpressionRule.isEnableDataSnap());
        if (paramExpressionRule.needWhile())
          a("", "childRuleLog", paramExpressionRule.getRelateVarNames());
      }
      visitExpressionRule(paramExpressionRule);
      if ((paramExpressionRule.needLog()) && (paramExpressionRule.needWhile()))
        a(paramExpressionRule.getRelateVarNames(), "childRuleLog");
      if ((paramExpressionRule.isEnableDataSnap()) && (!e()) && (paramExpressionRule.needLog()))
        e("takeSnapShot(childRuleLog) ;");
    }
    if (paramExpressionRule.isRunBreak())
      e("return M_RETURN_EXIT;");
    else
      e("return M_RETURN_DEFAULT;");
    c(1);
    e("}");
  }

  private void a(DecisionRelateRule paramDecisionRelateRule, int paramInt)
  {
    f(b(paramDecisionRelateRule));
    if (paramDecisionRelateRule.isSyn())
      e("private synchronized int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    else
      e("private int excuteRule" + paramInt + "(RuleLogList ruleLog) throws Exception {");
    b(1);
    if (!paramDecisionRelateRule.isEmpty())
    {
      if (paramDecisionRelateRule.needLog())
      {
        a(paramDecisionRelateRule.toString(), paramDecisionRelateRule.isEnableDataSnap());
        if (paramDecisionRelateRule.needWhile())
          a("", "childRuleLog", paramDecisionRelateRule.getRelateVarNames());
      }
      if (!paramDecisionRelateRule.isActived())
        e("if ( true ) return M_RETURN_DEFAULT;");
      a(paramDecisionRelateRule);
      b(1);
      visitDecisionRelateRule(paramDecisionRelateRule);
      c(1);
      b(paramDecisionRelateRule);
      if ((paramDecisionRelateRule.needLog()) && (paramDecisionRelateRule.needWhile()))
        a(paramDecisionRelateRule.getRelateVarNames(), "childRuleLog");
      if ((paramDecisionRelateRule.isEnableDataSnap()) && (!e()) && (paramDecisionRelateRule.needLog()))
        e("takeSnapShot(childRuleLog) ;");
    }
    if (paramDecisionRelateRule.isRunBreak())
      e("return M_RETURN_EXIT;");
    else
      e("return M_RETURN_DEFAULT;");
    c(1);
    e("}");
  }

  private boolean a(Rule paramRule)
  {
    int i1 = 0;
    int i2 = 0;
    Iterator localIterator = paramRule.getRuleElementToken().getThenActions().getActions();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((!(((StatementContainerToken)localObject).getStatement() instanceof ReturnToken)) && (!(((StatementContainerToken)localObject).getStatement() instanceof ThrowToken)))
        continue;
      i1 = 1;
    }
    localIterator = paramRule.getRuleElementToken().getElseActions().getActions();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((!(((StatementContainerToken)localObject).getStatement() instanceof ReturnToken)) && (!(((StatementContainerToken)localObject).getStatement() instanceof ThrowToken)))
        continue;
      i2 = 1;
    }
    return (i1 != 0) && (i2 != 0);
  }

  public Object visitExeRuleToken(ExeRuleToken paramExeRuleToken)
  {
    if ((paramExeRuleToken == null) || (paramExeRuleToken.getRuleNameToken() == null) || (paramExeRuleToken.getRuleNameToken().getExeRuleName().length() == 0))
      return null;
    if (!e())
      e("if ( true ) {");
    d("RuleEngine engine = RuleEngineFactory.newInstance().getRuleEngine() ;");
    c();
    List localList = paramExeRuleToken.getRuleNameToken().getSelectedFields();
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      localObject1 = (PackageFieldGet)localList.get(i1);
      l();
      d("engine.put(\"" + ((PackageFieldGet)localObject1).getFuncName() + "\", ");
      ((PackageFieldGet)localObject1).getAssignValue().acceptVisitor(this);
      d(") ;");
      c();
    }
    e("if ( class_objects != null ) engine.putObjects(class_objects) ;");
    e("if ( out != null ) engine.put(\"out\",out) ;");
    Object localObject2;
    int i2;
    if ((!e()) && (this.d) && (paramExeRuleToken.getReturnType() <= 1) && (paramExeRuleToken.getRoot() != null) && ((paramExeRuleToken.getRoot().getRuleTree() instanceof Rule)) && (((Rule)paramExeRuleToken.getRoot().getRuleTree()).needLog()))
    {
      str = paramExeRuleToken.getRuleNameToken().getDisplayName();
      e("RuleLogList exelog = null;");
      if (this.l.equals("true"))
        e("if (childRuleLog != null ) {");
      else
        e("if (childRuleLog != null  && " + this.l + ") {");
      e("\texelog = new RuleLogList(\"" + b(str) + "\");");
      e("\tchildRuleLog.addLog(exelog);");
      e("\tengine.put(\"ruleLog\",exelog);");
      e("if (snapShot!=null) engine.put(\"snapShot\",snapShot);");
      localObject1 = paramExeRuleToken.getRuleNameToken().getExeRuleName();
      if ((((String)localObject1).startsWith("{")) && (((String)localObject1).endsWith("}")))
      {
        localObject2 = paramExeRuleToken.getEnvionment().getBusinessDisName(((String)localObject1).substring(1, ((String)localObject1).length() - 1));
        if (localObject2 != null)
          e("\texelog.setRuleProcess(" + ((IBusinessObject)localObject2).getVarValue() + ") ;");
        else
          e("\texelog.setRuleProcess(\"" + b(paramExeRuleToken.getRuleNameToken().getExeRuleName()) + "\") ;");
      }
      else
      {
        e("\texelog.setRuleProcess(\"" + b(paramExeRuleToken.getRuleNameToken().getExeRuleName()) + "\") ;");
      }
      localObject2 = "";
      for (i2 = 0; i2 < localList.size(); i2++)
        localObject2 = localObject2 + "\"" + b(((PackageFieldGet)localList.get(i2)).getFuncName()) + "\",";
      if (((String)localObject2).length() > 0)
      {
        e("try {");
        d("\texelog.setFieldInits(new String[]{" + ((String)localObject2).substring(0, ((String)localObject2).length() - 1) + "},new String[]{");
        for (i2 = 0; i2 < localList.size(); i2++)
        {
          d("StringUtil.stringValue(");
          ((PackageFieldGet)localList.get(i2)).getAssignValue().acceptVisitor(this);
          d(")");
          if (i2 >= localList.size() - 1)
            continue;
          d(",");
        }
        e("}) ;");
        e("} catch (Throwable ethrowable) {}");
      }
      e("} else {");
      e("if (ruleLog != null && childRuleLog == null ) {");
      e("\tchildRuleLog = new RuleLogList(\"" + b(str) + "\");");
      e("\truleLog.addLog(childRuleLog); } ");
      e("\tengine.put(\"ruleLog\",childRuleLog);");
      e("if (snapShot!=null) engine.put(\"snapShot\",snapShot);");
      e("}");
    }
    String str = paramExeRuleToken.getRuleNameToken().getExeRuleName();
    Object localObject1 = "\"" + paramExeRuleToken.getRuleNameToken().getExeRuleName() + "\"";
    if ((str.startsWith("{")) && (str.endsWith("}")))
    {
      localObject2 = paramExeRuleToken.getEnvionment().getBusinessDisName(str.substring(1, str.length() - 1));
      if (localObject2 != null)
        localObject1 = ((IBusinessObject)localObject2).getVarValue();
    }
    if (paramExeRuleToken.getReturnType() == 0)
    {
      if ((this.e != null) && (this.e.getMainVersion().length() > 0))
        e("engine.excute(" + (String)localObject1 + ",\"" + this.e.getMainVersion() + "\") ;");
      else
        e("engine.excute(" + (String)localObject1 + ") ;");
    }
    else if (paramExeRuleToken.getReturnType() == 2)
    {
      if ((this.e != null) && (this.e.getMainVersion().length() > 0))
        e("engine.excuteSynchronized(" + (String)localObject1 + ",\"" + this.e.getMainVersion() + "\") ;");
      else
        e("engine.excuteSynchronized(" + (String)localObject1 + ") ;");
    }
    else if (paramExeRuleToken.getReturnType() == 3)
    {
      if ((this.e != null) && (this.e.getMainVersion().length() > 0))
        e("engine.excuteExistSynchronized(" + (String)localObject1 + ",\"" + this.e.getMainVersion() + "\") ;");
      else
        e("engine.excuteExistSynchronized(" + (String)localObject1 + ") ;");
    }
    else if ((this.e != null) && (this.e.getMainVersion().length() > 0))
      e("engine.excuteExits(" + (String)localObject1 + ",\"" + this.e.getMainVersion() + "\") ;");
    else
      e("engine.excuteExits(" + (String)localObject1 + ") ;");
    if ((paramExeRuleToken.getReturnType() == 1) || (paramExeRuleToken.getReturnType() == 0))
    {
      localObject2 = paramExeRuleToken.getRuleNameToken().getSelectedWheres();
      for (i2 = 0; i2 < ((List)localObject2).size(); i2++)
      {
        PackageFieldSet localPackageFieldSet = (PackageFieldSet)((List)localObject2).get(i2);
        IVariableObject localIVariableObject = localPackageFieldSet.getAssignValue().getVariableElement();
        if (localIVariableObject == null)
          continue;
        Object localObject3;
        if ((localIVariableObject instanceof IPropertyObject))
        {
          localObject3 = (IPropertyObject)localIVariableObject;
          l();
          d(((IPropertyObject)localObject3).getSetMethodPreName());
          g localg = localIVariableObject.getJavaType();
          if (localg.m())
            d("engine.getString(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else if (localg.e())
            d("engine.getBoolean(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else if (localg.d())
            d("engine.getChar(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else if (localg.g())
            d("engine.getShort(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else if (localg.k())
            d("engine.getInteger(\"" + localPackageFieldSet.getFuncName() + "\")");
          else if (localg.h())
            d("engine.getLong(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else if (localg.c())
            d("engine.getFloat(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else if (localg.i())
            d("engine.getDouble(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else
            d("(" + o.b(localg) + ")engine.get(\"" + localPackageFieldSet.getFuncName() + "\") ");
          d(((IPropertyObject)localObject3).getSetMethodSufName() + ";");
          c();
        }
        else
        {
          localPackageFieldSet.getAssignValue().acceptVisitor(this);
          d(" = ");
          localObject3 = localIVariableObject.getJavaType();
          if (((g)localObject3).m())
            d("engine.getString(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).e())
            d("engine.getBoolean(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).d())
            d("engine.getChar(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).g())
            d("engine.getShort(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).k())
            d("engine.getInteger(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).h())
            d("engine.getLong(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).c())
            d("engine.getFloat(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).i())
            d("engine.getDouble(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else
            d("(" + o.b((g)localObject3) + ")engine.get(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          c();
        }
      }
    }
    if (!e())
      e("}");
    d("//" + paramExeRuleToken.getRuleNameToken().getDisplayName());
    return null;
  }

  public Object visitExcuteRuleToken(ExcuteRuleToken paramExcuteRuleToken)
  {
    if ((paramExcuteRuleToken == null) || (paramExcuteRuleToken.getRuleNameToken().toString().length() == 0))
      return null;
    c();
    if (this.e != null)
      e(this.e);
    if ((!e()) && (paramExcuteRuleToken.getReturnType() <= 1) && ((paramExcuteRuleToken.getRuleNameToken().getValueElement() instanceof ConstantToken)) && (paramExcuteRuleToken.getRoot() != null) && ((paramExcuteRuleToken.getRoot().getRuleTree() instanceof Rule)) && (((Rule)paramExcuteRuleToken.getRoot().getRuleTree()).needLog()))
      i(paramExcuteRuleToken.getRuleNameToken().toString());
    l();
    if (paramExcuteRuleToken.getReturnType() == 0)
      d("getEngineFactory().getRuleEngine().excute(dtcObjects,class_objects,");
    else if (paramExcuteRuleToken.getReturnType() == 1)
      d("getEngineFactory().getRuleEngine().excuteExits(dtcObjects,class_objects,");
    else if (paramExcuteRuleToken.getReturnType() == 2)
      d("new RuleServerPoolFactory().getRuleService().execute(dtcObjects,");
    else if (paramExcuteRuleToken.getReturnType() == 3)
      d("new RuleSoapFactory().getRuleService().execute(dtcObjects,");
    d(paramExcuteRuleToken.getRuleNameToken());
    d(",");
    d(paramExcuteRuleToken.getRuleVersionToken());
    d(") ;");
    c();
    if (this.e != null)
      d(this.e);
    return null;
  }

  protected void a(IConditionToken paramIConditionToken)
  {
    if ((paramIConditionToken.getCompareOperator() instanceof StringJudgeToken))
    {
      String str = "";
      switch (paramIConditionToken.getCompareOperator().getType())
      {
      case 0:
        b(paramIConditionToken);
        break;
      case 1:
        d(paramIConditionToken);
        break;
      case 2:
        c(paramIConditionToken);
        break;
      case 3:
        e(paramIConditionToken);
        break;
      case 4:
        f(paramIConditionToken);
        break;
      case 5:
        h(paramIConditionToken);
        break;
      case 6:
        d(paramIConditionToken.getFirstValue());
        d(" != null ");
        break;
      case 7:
        d(paramIConditionToken.getFirstValue());
        d(" == null ");
        break;
      case 9:
        d("(");
        d(paramIConditionToken.getFirstValue());
        d(" == null || ");
        d(paramIConditionToken.getFirstValue());
        d(".length() == 0 ");
        d(")");
        break;
      case 8:
        d("(");
        d(paramIConditionToken.getFirstValue());
        d(" != null && ");
        d(paramIConditionToken.getFirstValue());
        d(".length() > 0 ");
        d(")");
        break;
      case 10:
        p(paramIConditionToken);
        break;
      case 11:
        q(paramIConditionToken);
        break;
      case 13:
        g(paramIConditionToken);
        break;
      case 14:
        i(paramIConditionToken);
        break;
      case 15:
        j(paramIConditionToken);
        break;
      case 16:
        k(paramIConditionToken);
        break;
      case 17:
        l(paramIConditionToken);
        break;
      case 19:
        o(paramIConditionToken);
        break;
      case 18:
        m(paramIConditionToken);
        break;
      case 20:
        n(paramIConditionToken);
      case 12:
      default:
        break;
      }
    }
    else if ((paramIConditionToken.getCompareOperator() instanceof ClassJudgeToken))
    {
      d(paramIConditionToken.getFirstValue());
      if (paramIConditionToken.getCompareOperator().getType() == 0)
        d(" != null ");
      else if (paramIConditionToken.getCompareOperator().getType() == 1)
        d(" == null ");
    }
    else if ((paramIConditionToken.getCompareOperator() instanceof BooleanJudgeToken))
    {
      d(paramIConditionToken.getFirstValue());
      if (paramIConditionToken.getCompareOperator().getType() == 1)
        d(" == false ");
    }
    else if ((paramIConditionToken.getCompareOperator() instanceof DateJudgeToken))
    {
      if (paramIConditionToken.getCompareOperator().getType() == 6)
      {
        d(paramIConditionToken.getFirstValue());
        d(" != null ");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 7)
      {
        d(paramIConditionToken.getFirstValue());
        d(" == null ");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 0)
      {
        if (paramIConditionToken.getFirstValue().getJavaType().v())
          d(" DateUtil.equalsDate(");
        else if (paramIConditionToken.getFirstValue().getJavaType().w())
          d(" DateUtil.equalsTime(");
        else
          d(" DateUtil.equalsDatetime(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + " )");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 1)
      {
        if (paramIConditionToken.getFirstValue().getJavaType().v())
          d(" !DateUtil.equalsDate(");
        else if (paramIConditionToken.getFirstValue().getJavaType().w())
          d(" !DateUtil.equalsTime(");
        else
          d(" !DateUtil.equalsDatetime(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + " )");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 5)
      {
        if (paramIConditionToken.getFirstValue().getJavaType().v())
          d(" DateUtil.lessEqualsThanDate(");
        else if (paramIConditionToken.getFirstValue().getJavaType().w())
          d(" DateUtil.lessEqualsThanTime(");
        else
          d(" DateUtil.lessEqualsThanDatetime(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + " )");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 4)
      {
        if (paramIConditionToken.getFirstValue().getJavaType().v())
          d(" DateUtil.lessThanDate(");
        else if (paramIConditionToken.getFirstValue().getJavaType().w())
          d(" DateUtil.lessThanTime(");
        else
          d(" DateUtil.lessThanDatetime(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + " )");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 3)
      {
        if (paramIConditionToken.getFirstValue().getJavaType().v())
          d(" DateUtil.moreEqualsThanDate(");
        else if (paramIConditionToken.getFirstValue().getJavaType().w())
          d(" DateUtil.moreEqualsThanTime(");
        else
          d(" DateUtil.moreEqualsThanDatetime(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + " )");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 2)
      {
        if (paramIConditionToken.getFirstValue().getJavaType().v())
          d(" DateUtil.moreThanDate(");
        else if (paramIConditionToken.getFirstValue().getJavaType().w())
          d(" DateUtil.moreThanTime(");
        else
          d(" DateUtil.moreThanDatetime(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + ")");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 8)
      {
        d(" DateUtil.equalsYear(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + ")");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 9)
      {
        d(" DateUtil.equalsQuarter(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + ")");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 10)
      {
        d(" DateUtil.equalsMonth(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + ")");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 11)
      {
        d(" DateUtil.equalsDate(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + ")");
      }
    }
    else if ((paramIConditionToken.getCompareOperator() instanceof DecimalJudgeToken))
    {
      if (paramIConditionToken.getCompareOperator().getType() == 6)
      {
        d(paramIConditionToken.getFirstValue());
        d(" != null ");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 7)
      {
        d(paramIConditionToken.getFirstValue());
        d(" == null ");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 0)
      {
        d(" DecimalUtil.equalsTo(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d(" )");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 1)
      {
        d(" !DecimalUtil.equalsTo(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d(" )");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 5)
      {
        d(" DecimalUtil.lessEqualsThan(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d(" )");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 4)
      {
        d(" DecimalUtil.lessThan(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d(" )");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 3)
      {
        d(" DecimalUtil.moreEqualsThan(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d(" )");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 2)
      {
        d(" DecimalUtil.moreThan(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d(")");
      }
    }
    else
    {
      d(paramIConditionToken.getFirstValue());
      d(paramIConditionToken.getCompareOperator());
      d(paramIConditionToken.getComparedValue());
    }
  }

  protected void a(IConditionToken paramIConditionToken, String paramString)
  {
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil." + paramString + "NoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") ");
    }
    else
    {
      d(" StringUtil." + paramString + "(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") ");
    }
  }

  protected void b(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil.equalsNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" StringUtil.equalsCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void c(IConditionToken paramIConditionToken)
  {
    d("( ");
    a(paramIConditionToken, "indexOf");
    d(")");
  }

  protected void d(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" !StringUtil.equalsNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" !StringUtil.equalsCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void e(IConditionToken paramIConditionToken)
  {
    d("( ");
    d(" !");
    a(paramIConditionToken, "indexOf");
    d(")");
  }

  protected void f(IConditionToken paramIConditionToken)
  {
    d("( ");
    a(paramIConditionToken, "startsWith");
    d(")");
  }

  protected void g(IConditionToken paramIConditionToken)
  {
    d("( ");
    d(" !");
    a(paramIConditionToken, "startsWith");
    d(")");
  }

  protected void h(IConditionToken paramIConditionToken)
  {
    d("( ");
    a(paramIConditionToken, "endsWith");
    d(")");
  }

  protected void i(IConditionToken paramIConditionToken)
  {
    d("( ");
    d(" !");
    a(paramIConditionToken, "endsWith");
    d(")");
  }

  protected void j(IConditionToken paramIConditionToken)
  {
    d("( ");
    d(paramIConditionToken.getFirstValue());
    d(" != null && ");
    d(paramIConditionToken.getComparedValue());
    d(" != null && ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil.equalsRegular(");
      d(paramIConditionToken.getFirstValue());
      d(".toLowerCase() , ");
      d(paramIConditionToken.getComparedValue());
      d(".toLowerCase()) )");
    }
    else
    {
      d(" StringUtil.equalsRegular(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void k(IConditionToken paramIConditionToken)
  {
    d("( ");
    d(" StringUtil.equalsNoCase(");
    d(paramIConditionToken.getFirstValue());
    d(" , ");
    d(paramIConditionToken.getComparedValue());
    d(") )");
  }

  protected void l(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil.equalsNoSpaceNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" StringUtil.equalsNoSpace(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void m(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil.equalsNoPunctNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" StringUtil.equalsNoPunct(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void n(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil.equalsLocalPunctNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" StringUtil.equalsLocalPunct(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void o(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil.equalsNoSpaceNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" StringUtil.equalsNoAscii(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void p(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" ListUtil.checkExitsNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" ListUtil.checkExits(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void q(IConditionToken paramIConditionToken)
  {
    d("( ");
    d(paramIConditionToken.getFirstValue());
    d(" == null || ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" !ListUtil.checkExitsNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" !ListUtil.checkExits(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  public Object visitThrowToken(ThrowToken paramThrowToken)
  {
    if (paramThrowToken == null)
      return null;
    d(" throw new RuleEngineException(");
    d(paramThrowToken.getErrorValue());
    d(")");
    return null;
  }

  public Object visitDebugToken(DebugToken paramDebugToken)
  {
    if (paramDebugToken == null)
      return null;
    d("if (Property.getInstance().isDebug() && out != null ) out.println(");
    d(paramDebugToken.getErrorValue());
    d(")");
    return null;
  }

  public Object visitConstantSelectToken(ConstantSelectToken paramConstantSelectToken)
  {
    if (paramConstantSelectToken == null)
      return null;
    if (paramConstantSelectToken.getDisplayName().equals(u.a("rulename.text")))
      d("\"" + h(paramConstantSelectToken.getRoot().getDisplayName()) + "\"");
    if (paramConstantSelectToken.getDisplayName().equals(u.a("rulepackagename.text")))
    {
      d("\"" + ((IRuleTree)paramConstantSelectToken.getRoot().getRuleTree()).getCompilePackage().getExeRulePackageName() + "\"");
    }
    else if (paramConstantSelectToken.getDisplayName().equals(u.a("rulepackagedisname.text")))
    {
      d("\"" + h(((IRuleTree)paramConstantSelectToken.getRoot().getRuleTree()).getCompilePackage().getDisplayName()) + "\"");
    }
    else if (paramConstantSelectToken.getDisplayName().equals(u.a("ruleversion.text")))
    {
      d("\"" + ((IRuleTree)paramConstantSelectToken.getRoot().getRuleTree()).getCompilePackage().getVersion() + "\"");
    }
    else if (paramConstantSelectToken.getDisplayName().equals(u.a("rulemainversion.text")))
    {
      d("\"" + ((IRuleTree)paramConstantSelectToken.getRoot().getRuleTree()).getCompilePackage().getMainVersion() + "\"");
    }
    else if (paramConstantSelectToken.getDisplayName().equals(u.a("loginuser.text")))
    {
      d("\"" + ((IRuleTree)paramConstantSelectToken.getRoot().getRuleTree()).getCompilePackage().getCurrentUser() + "\"");
    }
    else if (paramConstantSelectToken.getDisplayName().equals(u.a("ruleinputparameter.text")))
    {
      d("\"" + paramConstantSelectToken.getRoot().getRuleTree().getEnvionment().getInoutParameterString(1) + "\"");
    }
    else if (paramConstantSelectToken.getDisplayName().equals(u.a("ruleoutputparameter.text")))
    {
      d("\"" + paramConstantSelectToken.getRoot().getRuleTree().getEnvionment().getInoutParameterString(2) + "\"");
    }
    else if (paramConstantSelectToken.getDisplayName().equals(u.a("ruleinoutparameter.text")))
    {
      d("\"" + paramConstantSelectToken.getRoot().getRuleTree().getEnvionment().getInoutParameterString(3) + "\"");
    }
    else if (paramConstantSelectToken.getDisplayName().equals(u.a("rulein.text")))
    {
      d("\"" + paramConstantSelectToken.getRoot().getRuleTree().getEnvionment().getInoutString(1) + "\"");
    }
    else if (paramConstantSelectToken.getDisplayName().equals(u.a("ruleout.text")))
    {
      d("\"" + paramConstantSelectToken.getRoot().getRuleTree().getEnvionment().getInoutString(2) + "\"");
    }
    else if (paramConstantSelectToken.getDisplayName().equals(u.a("ruleinout.text")))
    {
      d("\"" + paramConstantSelectToken.getRoot().getRuleTree().getEnvionment().getInoutString(3) + "\"");
    }
    else if (paramConstantSelectToken.getDisplayName().equals(u.a("rulecondition.text")))
    {
      d("\"" + paramConstantSelectToken.getRoot().getRuleTree().getEnvionment().getInoutString(3) + "\"");
    }
    else
    {
      ConstantEnum localConstantEnum = paramConstantSelectToken.getConstantMember();
      if (localConstantEnum != null)
        d(localConstantEnum.getVarValue());
    }
    return null;
  }

  public Object visitValueToken(ValueToken paramValueToken)
  {
    if (paramValueToken == null)
      return null;
    if ((paramValueToken.getOperator() != null) && ((paramValueToken.getOperator() instanceof DateOperatorToken)) && (!paramValueToken.getOperator().isNoOperator()))
    {
      if (paramValueToken.getOperator().getType() == 2)
        d("DateUtil.dateMinus(");
      else
        d("DateUtil.dateAdd(");
      if (paramValueToken.getValueElement() != null)
      {
        d(o.a(paramValueToken.getValueElement().getJavaType(), paramValueToken.getJavaType()));
        d(paramValueToken.getValueElement());
        d(o.b(paramValueToken.getValueElement().getJavaType(), paramValueToken.getJavaType()));
      }
      d(",(");
      d(paramValueToken.getNextValue());
      d("))");
    }
    else if ((paramValueToken.getOperator() != null) && ((paramValueToken.getOperator() instanceof StringOperatorToken)) && (!paramValueToken.getOperator().isNoOperator()))
    {
      if (paramValueToken.getOperator().getType() == 1)
        d("StringUtil.add(");
      if (paramValueToken.getValueElement() != null)
      {
        d(o.a(paramValueToken.getValueElement().getJavaType(), paramValueToken.getJavaType()));
        d(paramValueToken.getValueElement());
        d(o.b(paramValueToken.getValueElement().getJavaType(), paramValueToken.getJavaType()));
      }
      if (paramValueToken.getOperator().getType() == 1)
      {
        d(",(");
        d(paramValueToken.getNextValue());
        d("))");
      }
      else if ((paramValueToken.getOperator() != null) && (!paramValueToken.getOperator().isNoOperator()))
      {
        d(paramValueToken.getOperator());
        d(paramValueToken.getNextValue());
      }
    }
    else if ((paramValueToken.getOperator() != null) && ((paramValueToken.getOperator() instanceof NumberOperatorToken)) && (paramValueToken.getJavaType().j()))
    {
      if (paramValueToken.getOperator().getType() == 1)
        d("DecimalUtil.add(");
      if (paramValueToken.getOperator().getType() == 2)
        d("DecimalUtil.sub(");
      if (paramValueToken.getOperator().getType() == 3)
        d("DecimalUtil.mul(");
      if (paramValueToken.getOperator().getType() == 4)
        d("DecimalUtil.div(");
      if (paramValueToken.getOperator().getType() == 5)
        d("DecimalUtil.mod(");
      if (paramValueToken.getValueElement() != null)
      {
        d(o.a(paramValueToken.getValueElement().getJavaType(), paramValueToken.getJavaType()));
        d(paramValueToken.getValueElement());
        d(o.b(paramValueToken.getValueElement().getJavaType(), paramValueToken.getJavaType()));
      }
      if (!paramValueToken.getOperator().isNoOperator())
      {
        d(",(");
        d(paramValueToken.getNextValue());
        d("))");
      }
      else if ((paramValueToken.getOperator() != null) && (!paramValueToken.getOperator().isNoOperator()))
      {
        d(paramValueToken.getOperator());
        d(paramValueToken.getNextValue());
      }
    }
    else
    {
      for (int i1 = 0; i1 < paramValueToken.getLeftParenthesisNumber(); i1++)
        d(" ( ");
      if (paramValueToken.getValueElement() != null)
      {
        if (!paramValueToken.getJavaType().a())
          d(o.a(paramValueToken.getValueElement().getJavaType(), paramValueToken.getJavaType()));
        d(paramValueToken.getValueElement());
        if (!paramValueToken.getJavaType().a())
          d(o.b(paramValueToken.getValueElement().getJavaType(), paramValueToken.getJavaType()));
      }
      for (i1 = 0; i1 < paramValueToken.getRightParenthesisNumber(); i1++)
        d(" ) ");
      if ((paramValueToken.getOperator() != null) && (!paramValueToken.getOperator().isNoOperator()))
      {
        d(paramValueToken.getOperator());
        d(paramValueToken.getNextValue());
      }
    }
    return null;
  }

  protected void c(String paramString)
  {
    this.k.put(String.valueOf(this.g), this.f.getUuid());
    d("/*");
    d(paramString);
    d("*/");
  }

  public Object visitClassToken(ClassToken paramClassToken)
  {
    if (paramClassToken == null)
      return null;
    d(paramClassToken.getClassMember().getVarValue());
    return null;
  }

  public Object visitFunctionMember(FunctionMember paramFunctionMember)
  {
    if (paramFunctionMember == null)
      return null;
    e(paramFunctionMember.getJavaFunction());
    return null;
  }

  public Object visitGotoRuleToken(GotoRuleToken paramGotoRuleToken)
  {
    if (paramGotoRuleToken == null)
      return null;
    IElement localIElement = paramGotoRuleToken.getMemberElement();
    if (localIElement == null)
      return null;
    String str = "null";
    if ((!e()) && ((localIElement instanceof IRuleTree)) && (((IRuleTree)localIElement).needLog()))
      str = "childRuleLog";
    if ((localIElement instanceof RuleSet))
      e(" excuteRule" + this.n.indexOf(localIElement) + "(" + str + ") ;");
    else if ((localIElement instanceof AbstractRuleFlow))
      e("excuteRule" + this.n.indexOf(localIElement) + "(" + str + ") ;");
    else if ((localIElement instanceof RulePoolFlow))
      e("excuteRule" + this.n.indexOf(localIElement) + "(" + str + ") ;");
    else if (((localIElement instanceof Rule)) && (!((Rule)localIElement).isEmpty()))
      e("excuteRule" + this.n.indexOf(localIElement) + "(" + str + ") ;");
    else if (((localIElement instanceof DecisionRule)) && (!((DecisionRule)localIElement).isEmpty()))
      e("excuteRule" + this.n.indexOf(localIElement) + "(" + str + ") ;");
    else if (((localIElement instanceof DecisionMultiRule)) && (!((DecisionMultiRule)localIElement).isEmpty()))
      e("excuteRule" + this.n.indexOf(localIElement) + "(" + str + ") ;");
    else if (((localIElement instanceof ExpressionRule)) && (!((ExpressionRule)localIElement).isEmpty()))
      e("excuteRule" + this.n.indexOf(localIElement) + "(" + str + ") ;");
    else if (((localIElement instanceof DecisionRelateRule)) && (!((DecisionRelateRule)localIElement).isEmpty()))
      e("excuteRule" + this.n.indexOf(localIElement) + "(" + str + ") ;");
    return null;
  }

  public Object visitMemberSelect(MemberToken.MemberSelector paramMemberSelector)
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

  public Object visitConstantEnum(ConstantEnum paramConstantEnum)
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

  public Object visitFunctionLibrary(FunctionLibrary paramFunctionLibrary)
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

  public Object visitStaticText(StaticTextToken paramStaticTextToken)
  {
    return null;
  }

  public Object visitElementTextToken(ElementTextToken paramElementTextToken)
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

  public Object visitTestCaseLib(TestCaseLib paramTestCaseLib)
  {
    return null;
  }

  public Object visitTestObjectInfo(TestObjectInfo paramTestObjectInfo)
  {
    return null;
  }

  public Object visitValueLibrary(ValueLibrary paramValueLibrary)
  {
    return null;
  }

  public Object visitVariableLibrary(VariableLibrary paramVariableLibrary)
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

  public boolean d()
  {
    return false;
  }

  public void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public Object visitTableModel(TableModel paramTableModel)
  {
    return null;
  }

  public Object visitSheetFieldModel(SheetFieldModel paramSheetFieldModel)
  {
    return null;
  }

  public Object visitSheetTable(SheetTable paramSheetTable)
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

  public boolean e()
  {
    return this.c;
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public HashMap a()
  {
    return this.k;
  }

  public Object visitLogRecordToken(LogRecordToken paramLogRecordToken)
  {
    if (paramLogRecordToken == null)
      return null;
    if (paramLogRecordToken.getReturnType() == 0)
      d("error(");
    else if (paramLogRecordToken.getReturnType() == 1)
      d("warning(");
    else if (paramLogRecordToken.getReturnType() == 2)
      d("info(");
    else if (paramLogRecordToken.getReturnType() == 3)
      d("debug(");
    d(paramLogRecordToken.getComparedValue());
    d(")");
    return null;
  }

  public Object visitSheetDynamicSelectToken(SheetDynamicSelectToken paramSheetDynamicSelectToken)
  {
    IBusinessObject localIBusinessObject1 = paramSheetDynamicSelectToken.getSourceSheet();
    if (localIBusinessObject1 != null)
      d(localIBusinessObject1.getVarValue());
    d(",new String[]{");
    List localList = paramSheetDynamicSelectToken.getSelectedFields();
    IBusinessObject localIBusinessObject3;
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      localObject = (SheetFieldMapping)localList.get(i1);
      localIBusinessObject3 = ((SheetFieldMapping)localObject).getField();
      if (localIBusinessObject3 != null)
      {
        d("\"");
        d(localIBusinessObject3.getValueName());
        d("\"");
      }
      if (i1 == localList.size() - 1)
        continue;
      d(" , ");
    }
    d("},new String[]{");
    for (i1 = 0; i1 < localList.size(); i1++)
    {
      localObject = (SheetFieldMapping)localList.get(i1);
      localIBusinessObject3 = ((SheetFieldMapping)localObject).getMappingField();
      if (localIBusinessObject3 != null)
      {
        d("\"");
        d(localIBusinessObject3.getValueName());
        d("\"");
      }
      if (i1 == localList.size() - 1)
        continue;
      d(" , ");
    }
    d("},\"");
    IBusinessObject localIBusinessObject2 = paramSheetDynamicSelectToken.getSheetField();
    if (localIBusinessObject2 != null)
      d(localIBusinessObject2.getValueName());
    d("\",\"");
    Object localObject = paramSheetDynamicSelectToken.getSheetValue();
    if (localObject != null)
      d(((IBusinessObject)localObject).getValueName());
    d("\"");
    return null;
  }

  public Object visitSheetFentanMapping(SheetFentanMapping paramSheetFentanMapping)
  {
    return null;
  }

  public Object visitSheetFentanSelectToken(SheetFentanSelectToken paramSheetFentanSelectToken)
  {
    String[][] arrayOfString; = { { "", "" }, { "", "" } };
    IBusinessObject localIBusinessObject1 = paramSheetFentanSelectToken.getSourceSheet(true);
    if (localIBusinessObject1 != null)
      d(localIBusinessObject1.getVarValue());
    IBusinessObject localIBusinessObject2 = paramSheetFentanSelectToken.getSourceSheet(false);
    if (localIBusinessObject1 != null)
      d("," + localIBusinessObject2.getVarValue());
    d(",new String[][]{");
    if (paramSheetFentanSelectToken.getAFentanField() != null)
    {
      d("new String[]{");
      d("\"");
      d(paramSheetFentanSelectToken.getAFentanField().getValueName());
      d("\"");
      d(",");
      d("\"");
      if (paramSheetFentanSelectToken.getCFentanField() != null)
        d(paramSheetFentanSelectToken.getCFentanField().getValueName());
      d("\"");
      d("}");
    }
    List localList1 = paramSheetFentanSelectToken.getSelectedFields(true);
    SheetFieldMapping localSheetFieldMapping;
    Object localObject;
    for (int i1 = 0; i1 < localList1.size(); i1++)
    {
      d(" , new String[]{");
      localSheetFieldMapping = (SheetFieldMapping)localList1.get(i1);
      d("\"");
      localObject = localSheetFieldMapping.getMappingField();
      if (localObject != null)
        d(((IBusinessObject)localObject).getValueName());
      d("\",\"");
      localObject = localSheetFieldMapping.getField();
      if (localObject != null)
        d(((IBusinessObject)localObject).getValueName());
      d("\"}");
    }
    d("},new String[][]{");
    if (paramSheetFentanSelectToken.getByingziField() != null)
    {
      d("new String[]{");
      d("\"");
      d(paramSheetFentanSelectToken.getByingziField().getValueName());
      d("\"");
      d(",");
      d("\"");
      if (paramSheetFentanSelectToken.getCyingziField() != null)
        d(paramSheetFentanSelectToken.getCyingziField().getValueName());
      d("\"");
      d("}");
    }
    localList1 = paramSheetFentanSelectToken.getSelectedFields(false);
    for (i1 = 0; i1 < localList1.size(); i1++)
    {
      d(" , new String[]{");
      localSheetFieldMapping = (SheetFieldMapping)localList1.get(i1);
      d("\"");
      localObject = localSheetFieldMapping.getMappingField();
      if (localObject != null)
        d(((IBusinessObject)localObject).getValueName());
      d("\",\"");
      localObject = localSheetFieldMapping.getField();
      if (localObject != null)
        d(((IBusinessObject)localObject).getValueName());
      d("\"}");
    }
    d("}");
    List localList2 = paramSheetFentanSelectToken.getSelectedConditions();
    d(",new String[][]{");
    for (int i2 = 0; i2 < localList2.size(); i2++)
    {
      localObject = (SheetFentanMapping)localList2.get(i2);
      d("new String[]{");
      d("\"");
      if (((SheetFentanMapping)localObject).getField() != null)
        d(((SheetFentanMapping)localObject).getField().getValueName());
      d("\",\"");
      if (((SheetFentanMapping)localObject).getBField() != null)
        d(((SheetFentanMapping)localObject).getBField().getValueName());
      d("\",\"");
      if (((SheetFentanMapping)localObject).getMappingField() != null)
        d(((SheetFentanMapping)localObject).getMappingField().getValueName());
      d("\"");
      d("}");
      if (i2 == localList2.size() - 1)
        continue;
      d(" , ");
    }
    d("}");
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

  public Object visitExeExpressionToken(ExeExpressionToken paramExeExpressionToken)
  {
    if ((paramExeExpressionToken == null) || (paramExeExpressionToken.getRuleVersionToken() == null) || (paramExeExpressionToken.getRuleVersionToken().getValueElement() == null))
      return null;
    if (!e())
      e("if ( true ) {");
    e("IExpression expression = ExpressionFactory.getInstance().createExpression() ;");
    Iterator localIterator = paramExeExpressionToken.getEnvionment().getAllExpressionVariable();
    while (localIterator.hasNext())
    {
      localObject1 = (CustomVariable)localIterator.next();
      l();
      d("expression.addVarDefine(\"" + ((CustomVariable)localObject1).getValueName() + "\",\"" + ((CustomVariable)localObject1).getValueType() + "\",\"" + ((CustomVariable)localObject1).getDisplayName() + "\"); ");
      c();
    }
    l();
    d("expression.addRuleDefine(");
    d(paramExeExpressionToken.getRuleVersionToken());
    d(") ;");
    c();
    l();
    if (paramExeExpressionToken.getReturnType() == 0)
      d("expression.deployExpression(");
    else if (paramExeExpressionToken.getReturnType() == 1)
      d("expression.deployExpression(");
    if (((paramExeExpressionToken.getRuleNameToken().getValueElement() instanceof ConstantToken)) && (((ConstantToken)paramExeExpressionToken.getRuleNameToken().getValueElement()).isEmpty()))
      d("\"" + paramExeExpressionToken.getUuid() + "\"");
    else
      d(paramExeExpressionToken.getRuleNameToken());
    d(") ;");
    c();
    d("RuleEngine engine = getEngineFactory().getRuleEngine() ;");
    c();
    localIterator = paramExeExpressionToken.getEnvionment().getAllExpressionVariable();
    while (localIterator.hasNext())
    {
      localObject1 = (CustomVariable)localIterator.next();
      l();
      d("engine.put(\"" + ((CustomVariable)localObject1).getValueName() + "\", ");
      d(((CustomVariable)localObject1).getVarValue());
      d(") ;");
      c();
    }
    e("if ( class_objects != null ) engine.putObjects(class_objects) ;");
    e("if ( out != null ) engine.put(\"out\",out) ;");
    Object localObject2;
    Object localObject3;
    if ((!e()) && (this.d) && (paramExeExpressionToken.getReturnType() <= 1) && (paramExeExpressionToken.getRoot() != null) && ((paramExeExpressionToken.getRoot().getRuleTree() instanceof Rule)) && (((Rule)paramExeExpressionToken.getRoot().getRuleTree()).needLog()))
    {
      localObject1 = paramExeExpressionToken.getRuleNameToken().toString();
      if (((paramExeExpressionToken.getRuleNameToken().getValueElement() instanceof ConstantToken)) && (((ConstantToken)paramExeExpressionToken.getRuleNameToken().getValueElement()).isEmpty()))
        localObject1 = paramExeExpressionToken.getUuid();
      e("RuleLogList exelog = null;");
      if (this.l.equals("true"))
        e("if (childRuleLog != null ) {");
      else
        e("if (childRuleLog != null  && " + this.l + ") {");
      e("\texelog = new RuleLogList(\"" + b((String)localObject1) + "\");");
      e("\tchildRuleLog.addLog(exelog);");
      e("\tengine.put(\"ruleLog\",exelog);");
      e("if (snapShot!=null) engine.put(\"snapShot\",snapShot);");
      localObject2 = paramExeExpressionToken.getRuleNameToken().getText();
      if ((((String)localObject2).startsWith("{")) && (((String)localObject2).endsWith("}")))
      {
        localObject3 = paramExeExpressionToken.getEnvionment().getBusinessDisName(((String)localObject2).substring(1, ((String)localObject2).length() - 1));
        if (localObject3 != null)
          e("\texelog.setRuleProcess(" + ((IBusinessObject)localObject3).getVarValue() + ") ;");
        else
          e("\texelog.setRuleProcess(\"" + b(paramExeExpressionToken.getRuleNameToken().getText()) + "\") ;");
      }
      else
      {
        e("\texelog.setRuleProcess(\"" + b(paramExeExpressionToken.getRuleNameToken().getText()) + "\") ;");
      }
      e("} else {");
      e("if (ruleLog != null && childRuleLog == null ) {");
      e("\tchildRuleLog = new RuleLogList(\"" + b((String)localObject1) + "\");");
      e("\truleLog.addLog(childRuleLog); } ");
      e("\tengine.put(\"ruleLog\",childRuleLog);");
      e("if (snapShot!=null) engine.put(\"snapShot\",snapShot);");
      e("}");
    }
    Object localObject1 = paramExeExpressionToken.getRuleNameToken().getText();
    if (((paramExeExpressionToken.getRuleNameToken().getValueElement() instanceof ConstantToken)) && (((ConstantToken)paramExeExpressionToken.getRuleNameToken().getValueElement()).isEmpty()))
      localObject1 = "\"" + paramExeExpressionToken.getUuid() + "\"";
    if (((String)localObject1).length() == 0)
      localObject1 = paramExeExpressionToken.getUuid();
    if ((this.e != null) && (this.e.getMainVersion().length() > 0))
      e("engine.excute(" + (String)localObject1 + ",\"" + this.e.getMainVersion() + "\") ;");
    else
      e("engine.excute(" + (String)localObject1 + ") ;");
    if ((paramExeExpressionToken.getReturnType() == 1) || (paramExeExpressionToken.getReturnType() == 0))
    {
      localIterator = paramExeExpressionToken.getEnvionment().getAllExpressionVariable();
      while (localIterator.hasNext())
      {
        localObject2 = (CustomVariable)localIterator.next();
        l();
        d(((CustomVariable)localObject2).getVarValue());
        d(" = ");
        localObject3 = ((CustomVariable)localObject2).getJavaType();
        if (((g)localObject3).e())
          d("engine.getBoolean(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else if (((g)localObject3).d())
          d("engine.getChar(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else if (((g)localObject3).g())
          d("engine.getShort(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else if (((g)localObject3).k())
          d("engine.getInteger(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else if (((g)localObject3).h())
          d("engine.getLong(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else if (((g)localObject3).c())
          d("engine.getFloat(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else if (((g)localObject3).i())
          d("engine.getDouble(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else
          d("(" + o.b((g)localObject3) + ")engine.get(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        c();
      }
    }
    if (!e())
      e("}");
    d("//" + paramExeExpressionToken.getRuleNameToken().getShowDisplayName());
    return null;
  }

  public Object visitExeDecisionToken(ExeDecisionToken paramExeDecisionToken)
  {
    if ((paramExeDecisionToken == null) || (paramExeDecisionToken.getRuleVersionToken() == null) || (paramExeDecisionToken.getRuleVersionToken().getValueElement() == null))
      return null;
    if (!e())
      e("if ( true ) {");
    e("IExpression expression = ExpressionFactory.getInstance().createExpression() ;");
    Iterator localIterator = paramExeDecisionToken.getEnvionment().getAllExpressionVariable();
    while (localIterator.hasNext())
    {
      localObject1 = (CustomVariable)localIterator.next();
      l();
      d("expression.addVarDefine(\"" + ((CustomVariable)localObject1).getValueName() + "\",\"" + ((CustomVariable)localObject1).getValueType() + "\",\"" + ((CustomVariable)localObject1).getDisplayName() + "\"); ");
      c();
    }
    l();
    d("expression.addDecisionDefine(");
    d(paramExeDecisionToken.getRuleNameToken());
    d(",");
    d(paramExeDecisionToken.getRuleVersionToken());
    d(") ;");
    c();
    l();
    if (paramExeDecisionToken.getReturnType() == 0)
    {
      d("expression.deployExpression(");
      d("\"" + paramExeDecisionToken.getUuid() + "\"");
      d(") ;");
    }
    else if (paramExeDecisionToken.getReturnType() == 1)
    {
      d("expression.redeployExpression(");
      d("\"" + paramExeDecisionToken.getUuid() + "\"");
      d(") ;");
    }
    c();
    d("RuleEngine engine = getEngineFactory().getRuleEngine() ;");
    c();
    localIterator = paramExeDecisionToken.getEnvionment().getAllExpressionVariable();
    while (localIterator.hasNext())
    {
      localObject1 = (CustomVariable)localIterator.next();
      l();
      d("engine.put(\"" + ((CustomVariable)localObject1).getValueName() + "\", ");
      d(((CustomVariable)localObject1).getVarValue());
      d(") ;");
      c();
    }
    e("if ( class_objects != null ) engine.putObjects(class_objects) ;");
    e("if ( out != null ) engine.put(\"out\",out) ;");
    Object localObject2;
    Object localObject3;
    if ((!e()) && (this.d) && (paramExeDecisionToken.getReturnType() <= 1) && (paramExeDecisionToken.getRoot() != null) && ((paramExeDecisionToken.getRoot().getRuleTree() instanceof Rule)) && (((Rule)paramExeDecisionToken.getRoot().getRuleTree()).needLog()))
    {
      localObject1 = paramExeDecisionToken.getUuid();
      e("RuleLogList exelog = null;");
      if (this.l.equals("true"))
        e("if (childRuleLog != null ) {");
      else
        e("if (childRuleLog != null  && " + this.l + ") {");
      e("\texelog = new RuleLogList(\"" + b((String)localObject1) + "\");");
      e("\tchildRuleLog.addLog(exelog);");
      e("\tengine.put(\"ruleLog\",exelog);");
      e("if (snapShot!=null) engine.put(\"snapShot\",snapShot);");
      localObject2 = paramExeDecisionToken.getRuleNameToken().getText();
      if ((((String)localObject2).startsWith("{")) && (((String)localObject2).endsWith("}")))
      {
        localObject3 = paramExeDecisionToken.getEnvionment().getBusinessDisName(((String)localObject2).substring(1, ((String)localObject2).length() - 1));
        if (localObject3 != null)
          e("\texelog.setRuleProcess(" + ((IBusinessObject)localObject3).getVarValue() + ") ;");
        else
          e("\texelog.setRuleProcess(\"" + b(paramExeDecisionToken.getRuleNameToken().getText()) + "\") ;");
      }
      else
      {
        e("\texelog.setRuleProcess(\"" + b(paramExeDecisionToken.getRuleNameToken().getText()) + "\") ;");
      }
      e("} else {");
      e("if (ruleLog != null && childRuleLog == null ) {");
      e("\tchildRuleLog = new RuleLogList(\"" + b((String)localObject1) + "\");");
      e("\truleLog.addLog(childRuleLog); } ");
      e("\tengine.put(\"ruleLog\",childRuleLog);");
      e("if (snapShot!=null) engine.put(\"snapShot\",snapShot);");
      e("}");
    }
    Object localObject1 = paramExeDecisionToken.getRuleNameToken().getText();
    localObject1 = "\"" + paramExeDecisionToken.getUuid() + "\"";
    if (((String)localObject1).length() == 0)
      localObject1 = paramExeDecisionToken.getUuid();
    if ((this.e != null) && (this.e.getMainVersion().length() > 0))
      e("engine.excute(" + (String)localObject1 + ",\"" + this.e.getMainVersion() + "\") ;");
    else
      e("engine.excute(" + (String)localObject1 + ") ;");
    if ((paramExeDecisionToken.getReturnType() == 1) || (paramExeDecisionToken.getReturnType() == 0))
    {
      localIterator = paramExeDecisionToken.getEnvionment().getAllExpressionVariable();
      while (localIterator.hasNext())
      {
        localObject2 = (CustomVariable)localIterator.next();
        l();
        d(((CustomVariable)localObject2).getVarValue());
        d(" = ");
        localObject3 = ((CustomVariable)localObject2).getJavaType();
        if (((g)localObject3).e())
          d("engine.getBoolean(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else if (((g)localObject3).d())
          d("engine.getChar(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else if (((g)localObject3).g())
          d("engine.getShort(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else if (((g)localObject3).k())
          d("engine.getInteger(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else if (((g)localObject3).h())
          d("engine.getLong(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else if (((g)localObject3).c())
          d("engine.getFloat(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else if (((g)localObject3).i())
          d("engine.getDouble(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        else
          d("(" + o.b((g)localObject3) + ")engine.get(\"" + ((CustomVariable)localObject2).getValueName() + "\") ;");
        c();
      }
    }
    if (!e())
      e("}");
    d("//" + paramExeDecisionToken.getRuleNameToken().getShowDisplayName());
    return null;
  }

  public Object visitRulePoolFlow(RulePoolFlow paramRulePoolFlow)
  {
    if ((paramRulePoolFlow.isEmpty()) || (!paramRulePoolFlow.isActived()))
      return null;
    this.f = paramRulePoolFlow;
    f(paramRulePoolFlow.getDisplayName());
    if ((paramRulePoolFlow.getStartTime() != 0L) && (paramRulePoolFlow.getEndTime() != 0L))
      e("if ( getCurrentTime() >= " + paramRulePoolFlow.getStartTime() + "L  &&  getCurrentTime() <= " + paramRulePoolFlow.getEndTime() + "L ) { ");
    else if (paramRulePoolFlow.getStartTime() != 0L)
      e("if ( getCurrentTime() >= " + paramRulePoolFlow.getStartTime() + "L ) {");
    else if (paramRulePoolFlow.getEndTime() != 0L)
      e("if ( getCurrentTime() <= " + paramRulePoolFlow.getEndTime() + "L ) {");
    if ((paramRulePoolFlow.getStartTime() != 0L) || (paramRulePoolFlow.getEndTime() != 0L))
      b(1);
    List localList = paramRulePoolFlow.getPoolNodes();
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      Object localObject = localList.get(i1);
      if ((localObject == null) || (!(localObject instanceof RulePoolNode)))
        continue;
      RulePoolNode localRulePoolNode = (RulePoolNode)localObject;
      if (localRulePoolNode.getRuleObject() == null)
        continue;
      a(localRulePoolNode.getRuleObject());
    }
    if ((paramRulePoolFlow.getStartTime() != 0L) || (paramRulePoolFlow.getEndTime() != 0L))
    {
      c(1);
      e("}");
    }
    return null;
  }

  public Object visitDecisionValue(DecisionValue paramDecisionValue)
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

  public Object visitContainer(IRuleContainer paramIRuleContainer)
  {
    return null;
  }

  public Object visitSelector(ISelectorEditen paramISelectorEditen)
  {
    return null;
  }

  public Object visitForEachConditionToken(ForEachConditionToken paramForEachConditionToken)
  {
    if (paramForEachConditionToken.getReturnType() == 0)
    {
      d("for (");
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d(" = ");
      paramForEachConditionToken.getRuleVersionToken("first").acceptVisitor(this);
      d(" ; ");
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d(" <= ");
      paramForEachConditionToken.getRuleVersionToken("last").acceptVisitor(this);
      d(" ; ");
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d("++ ");
      e(" ) { ");
    }
    else if (paramForEachConditionToken.getReturnType() == 1)
    {
      d("for (");
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d(" = ");
      paramForEachConditionToken.getRuleVersionToken("first").acceptVisitor(this);
      d(" ; ");
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d(" >= ");
      paramForEachConditionToken.getRuleVersionToken("last").acceptVisitor(this);
      d(" ; ");
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d("-- ");
      e(" ) { ");
    }
    else if (paramForEachConditionToken.getReturnType() == 2)
    {
      d("for ( int int_ruleset");
      d(" = 0 ");
      d(" ; int_ruleset");
      d(" < ");
      paramForEachConditionToken.getRuleVersionToken("array").acceptVisitor(this);
      d(".length ; int_ruleset");
      d("++ ");
      e(" ) { ");
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d(" = ");
      paramForEachConditionToken.getRuleVersionToken("array").acceptVisitor(this);
      d("[int_ruleset");
      d("];");
    }
    else if (paramForEachConditionToken.getReturnType() == 3)
    {
      d("for ( int int_ruleset ");
      d(" = 0 ");
      d(" ; int_ruleset");
      d(" < ");
      paramForEachConditionToken.getRuleVersionToken("array").acceptVisitor(this);
      d(".length ; int_ruleset");
      d("++ ");
      e(" ) { ");
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d(" = ");
      if (paramForEachConditionToken.getFirstToken().getJavaType().b())
        d("(" + paramForEachConditionToken.getFirstToken().getJavaType().K() + ")");
      else if (paramForEachConditionToken.getFirstToken().getJavaType().r())
        d("(" + paramForEachConditionToken.getFirstToken().getJavaType().L() + ")");
      paramForEachConditionToken.getRuleVersionToken("array").acceptVisitor(this);
      d(".get(int_ruleset");
      d(");");
    }
    else if (paramForEachConditionToken.getReturnType() == 3)
    {
      d("Iterator ite_ruleset = ");
      paramForEachConditionToken.getRuleVersionToken("map").acceptVisitor(this);
      e(".keySet().iterator();");
      e("while ( ite_ruleset.hasNext() ) {");
      e("Object key_ruleset = ite_ruleset.next();");
      d("Object value_ruleset = ");
      paramForEachConditionToken.getRuleVersionToken("map").acceptVisitor(this);
      e(".get(key_ruleset);");
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d(" = ");
      h localh = paramForEachConditionToken.getTypeManager();
      d(localh.a(paramForEachConditionToken.getFirstToken().getJavaType(), localh.a("object")));
      d("key_ruleset");
      d(localh.b(paramForEachConditionToken.getFirstToken().getJavaType(), localh.a("object")));
      d(";");
      paramForEachConditionToken.getSecondToken().acceptVisitor(this);
      d(" = ");
      localh = paramForEachConditionToken.getTypeManager();
      d(localh.a(paramForEachConditionToken.getSecondToken().getJavaType(), localh.a("object")));
      d("value_ruleset");
      d(localh.b(paramForEachConditionToken.getSecondToken().getJavaType(), localh.a("object")));
      d(";");
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.j
 * JD-Core Version:    0.6.0
 */