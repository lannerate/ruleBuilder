package com.flagleader.repository.e;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.u;
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
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.lang.IAssignToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IOperatorToken;
import com.flagleader.repository.rlm.lang.IStatementContainerToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
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
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.MappingFunction;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.AbstractRuleSet;
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
import com.flagleader.repository.tree.ITreeNode;
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
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import com.flagleader.util.prefs.Messages;
import com.flagleader.util.prefs.Preferences;
import com.flagleader.util.prefs.PropertyBundle;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class m
  implements RepositoryVisitor
{
  protected PrintWriter p;
  private boolean a;
  private boolean b;
  private int c;
  private int d;
  public static final String q = FileUtil.newline;

  public m()
  {
    this.a = false;
    this.b = true;
    this.c = 0;
    this.d = 4;
  }

  public m(PrintWriter paramPrintWriter)
  {
    this.p = paramPrintWriter;
    this.a = false;
    this.b = true;
    this.c = 0;
    this.d = 4;
  }

  public m(PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    this.p = paramPrintWriter;
    this.a = paramBoolean;
    this.b = true;
    this.c = 0;
    this.d = 4;
  }

  public String b(IElement paramIElement)
  {
    StringWriter localStringWriter = new StringWriter();
    this.p = new PrintWriter(localStringWriter);
    c(paramIElement);
    return localStringWriter.toString();
  }

  protected void b(int paramInt)
  {
    this.c += paramInt;
  }

  protected void c(int paramInt)
  {
    this.c -= paramInt;
  }

  public void i()
  {
    this.p.close();
  }

  public void j()
  {
    this.p.flush();
  }

  private int a()
  {
    return this.c * this.d;
  }

  protected int k()
  {
    return this.d;
  }

  protected void l()
  {
    a(a());
  }

  protected void a(int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
      b(' ');
  }

  private boolean a(IElement paramIElement)
  {
    return paramIElement != null;
  }

  private void d()
  {
    c();
  }

  protected void b(char paramChar)
  {
    this.p.print(paramChar);
  }

  protected void d(String paramString)
  {
    this.p.print(paramString);
  }

  public void a(Writer paramWriter, IElement paramIElement)
  {
    if ((paramWriter instanceof PrintWriter))
      this.p = ((PrintWriter)paramWriter);
    else
      this.p = new PrintWriter(paramWriter);
    c(paramIElement);
    this.p = null;
  }

  public void c(IElement paramIElement)
  {
    b();
    if (paramIElement != null)
      paramIElement.acceptVisitor(this);
    j();
  }

  protected void d(IElement paramIElement)
  {
    if (!a(paramIElement))
      return;
    paramIElement.acceptVisitor(this);
    if (h())
      j();
  }

  protected void e(IElement paramIElement)
  {
    if (!a(paramIElement))
    {
      if (e())
        d();
      return;
    }
    l();
    paramIElement.acceptVisitor(this);
    c();
    if (h())
      j();
  }

  protected void f(IElement paramIElement)
  {
    Iterator localIterator = paramIElement.getChildrenIterator();
    if ((paramIElement instanceof IMultiEditen))
      localIterator = ((IMultiEditen)paramIElement).getMultiToken();
    while (localIterator.hasNext())
      d((IElement)localIterator.next());
  }

  protected void c()
  {
    this.p.print(q);
  }

  protected void c(char paramChar)
  {
    this.p.print(paramChar);
    c();
  }

  protected void e(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, q);
    while (localStringTokenizer.hasMoreTokens())
    {
      String str = localStringTokenizer.nextToken().trim();
      l();
      this.p.print(str);
      c();
    }
  }

  protected void b(String paramString1, String paramString2)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, q);
    while (localStringTokenizer.hasMoreTokens())
    {
      String str = localStringTokenizer.nextToken().trim();
      l();
      this.p.print(paramString2 + str);
      c();
    }
  }

  protected void b()
  {
    this.c = 0;
  }

  private void d(int paramInt)
  {
    this.d = paramInt;
  }

  private boolean e()
  {
    return this.b;
  }

  private void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public Object visitActionToken(StatementContainerToken paramStatementContainerToken)
  {
    if (a(paramStatementContainerToken.getStatement()))
      d(paramStatementContainerToken.getStatement());
    return null;
  }

  public Object visitBusinessObjectAttribute(BusinessObjectAttribute paramBusinessObjectAttribute)
  {
    a(paramBusinessObjectAttribute);
    return null;
  }

  public Object visitBusinessObjectMethod(BusinessObjectMethod paramBusinessObjectMethod)
  {
    a(paramBusinessObjectMethod);
    return null;
  }

  protected void a(ITreeNode paramITreeNode)
  {
    e(paramITreeNode.getDisplayName());
    c();
    b(1);
    f(paramITreeNode);
    c(1);
  }

  protected void a(IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    d("\t");
    d(paramIBusinessObjectEditen.getValueName());
    d("\t\t");
    d(paramIBusinessObjectEditen.getValueType());
    d("\t\t");
    d(paramIBusinessObjectEditen.getDisplayName());
    c();
  }

  public Object visitBusinessObjectClass(BusinessObjectClass paramBusinessObjectClass)
  {
    a(paramBusinessObjectClass);
    b(1);
    f(paramBusinessObjectClass);
    c(1);
    return null;
  }

  private String a(String paramString)
  {
    PropertyBundle localPropertyBundle = Messages.getMessages().getPropertyBundle("repository");
    if ((paramString == null) || (paramString.length() == 0))
      return "";
    if (paramString.charAt(0) == '&')
      return Preferences.getString(localPropertyBundle, paramString.substring(1) + ".edit", paramString.substring(1));
    return Preferences.getString(localPropertyBundle, paramString, paramString);
  }

  private boolean h()
  {
    return this.a;
  }

  private void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public Object visitConstantToken(ConstantToken paramConstantToken)
  {
    d("\"");
    d(paramConstantToken.getValue());
    d("\"");
    return null;
  }

  public Object visitJavaStatementToken(JavaStatementToken paramJavaStatementToken)
  {
    String str = StringUtil.replace(q, "\\n", paramJavaStatementToken.getValue());
    return "java:" + str;
  }

  public Object visitFieldToken(FieldToken paramFieldToken)
  {
    return visitMemberToken(paramFieldToken);
  }

  public Object visitJudgeToken(JudgeToken paramJudgeToken)
  {
    d(paramJudgeToken.getDisplayName());
    return null;
  }

  private int b(String paramString)
  {
    return paramString.getBytes().length;
  }

  public Object visitMethodToken(MethodToken paramMethodToken)
  {
    return visitMemberToken(paramMethodToken);
  }

  public Object visitModifyToken(ModifyToken paramModifyToken)
  {
    return null;
  }

  public Object visitClassLibrary(ClassContainer paramClassContainer)
  {
    e(paramClassContainer.getDisplayName());
    c();
    b(1);
    f(paramClassContainer);
    c(1);
    return null;
  }

  public Object visitInterfaceContainer(InterfaceContainer paramInterfaceContainer)
  {
    e(paramInterfaceContainer.getDisplayName());
    c();
    b(1);
    f(paramInterfaceContainer);
    c(1);
    return null;
  }

  public Object visitRule(Rule paramRule)
  {
    e(paramRule.getDisplayName());
    e(paramRule.getRuleElementToken());
    return null;
  }

  public Object visitExpressionRule(ExpressionRule paramExpressionRule)
  {
    e(paramExpressionRule.getDisplayName());
    b(1);
    e(paramExpressionRule.getExpression());
    c(1);
    return null;
  }

  public Object visitDecisionRule(DecisionRule paramDecisionRule)
  {
    List localList1 = paramDecisionRule.getFirstConditions().getConditionList();
    List localList2 = paramDecisionRule.getSecondConditions().getConditionList();
    int[] arrayOfInt = new int[localList1.size() + 1];
    if (paramDecisionRule.getMemberElement() != null)
      arrayOfInt[0] = b(paramDecisionRule.getMemberElement().getDisplayName());
    for (int i = 0; i < localList2.size(); i++)
    {
      if (b(localList2.get(i).toString()) <= arrayOfInt[0])
        continue;
      arrayOfInt[0] = b(localList2.get(i).toString());
    }
    for (i = 0; i < localList1.size(); i++)
      arrayOfInt[(i + 1)] = b(localList1.get(i).toString());
    g();
    if (paramDecisionRule.getMemberElement() == null)
      a("", arrayOfInt[0]);
    else
      a(paramDecisionRule.getMemberElement().getDisplayName(), arrayOfInt[0]);
    for (i = 0; i < localList1.size(); i++)
      a(localList1.get(i).toString(), arrayOfInt[(i + 1)]);
    f();
    if (localList2.size() == 0)
    {
      g();
      a("", arrayOfInt[0]);
      for (i = 0; i < localList1.size(); i++)
        if (paramDecisionRule.getDecisionValue(i, 0) != null)
          a(paramDecisionRule.getDecisionValue(i, 0).getDisplayName(), arrayOfInt[(i + 1)]);
        else
          a("", arrayOfInt[(i + 1)]);
      f();
    }
    else
    {
      for (i = 0; i < localList2.size(); i++)
      {
        g();
        a(localList2.get(i).toString(), arrayOfInt[0]);
        for (int j = 0; j < localList1.size(); j++)
          if (paramDecisionRule.getDecisionValue(j, i) != null)
            a(paramDecisionRule.getDecisionValue(j, i).getDisplayName(), arrayOfInt[(j + 1)]);
          else
            a("", arrayOfInt[(j + 1)]);
        f();
      }
    }
    return null;
  }

  public Object visitDecisionMultiRule(DecisionMultiRule paramDecisionMultiRule)
  {
    if (!paramDecisionMultiRule.isActived())
      e("if ( true ) return M_RETURN_DEFAULT;");
    int[] arrayOfInt = new int[paramDecisionMultiRule.getConditionNum()];
    for (int i = 0; i < paramDecisionMultiRule.getConditionNum(); i++)
      arrayOfInt[i] = 0;
    do
    {
      i = 0;
      ArrayList localArrayList = new ArrayList(paramDecisionMultiRule.getConditionNum());
      while (i < paramDecisionMultiRule.getConditionNum())
      {
        IMultiConditionToken localIMultiConditionToken = paramDecisionMultiRule.getConditions(i + 1);
        localArrayList.add(localIMultiConditionToken.getCondition(arrayOfInt[i]));
        i++;
      }
      l();
      d(a("tv_if"));
      if (paramDecisionMultiRule.getConditions(1).getCondition(arrayOfInt[0]) != null)
        paramDecisionMultiRule.getConditions(1).getCondition(arrayOfInt[0]).acceptVisitor(this);
      for (int j = 2; j <= paramDecisionMultiRule.getConditionNum(); j++)
      {
        d(" " + a("tv_and"));
        if (paramDecisionMultiRule.getConditions(j) == null)
          continue;
        IConditionToken localIConditionToken = paramDecisionMultiRule.getConditions(j).getCondition(arrayOfInt[(j - 1)]);
        if (localIConditionToken == null)
          continue;
        localIConditionToken.acceptVisitor(this);
      }
      d(" " + a("tv_then") + " ");
      for (i = 0; i < paramDecisionMultiRule.getValueNum(); i++)
      {
        if (paramDecisionMultiRule.getDecisionElement(i + 1) == null)
          continue;
        IBusinessObject localIBusinessObject = paramDecisionMultiRule.getDecisionElement(i + 1).getMemberElement();
        if ((paramDecisionMultiRule.getDecisionValue(localArrayList, localIBusinessObject) == null) || (paramDecisionMultiRule.getDecisionValue(localArrayList, localIBusinessObject).getValue().length() <= 0))
          continue;
        d(localIBusinessObject.getDisplayName());
        d(" " + a("EqualsTo.edit") + " ");
        d(paramDecisionMultiRule.getDecisionValue(localArrayList, localIBusinessObject).getValue());
      }
      c();
      arrayOfInt = paramDecisionMultiRule.getNextDecision(arrayOfInt);
    }
    while (arrayOfInt != null);
    return null;
  }

  protected void b(List paramList, DecisionRelateRule paramDecisionRelateRule, int paramInt)
  {
    if (paramList.size() < paramDecisionRelateRule.getConditionNum())
    {
      List localList = paramDecisionRelateRule.getNextConditions((IConditionToken)paramList.get(paramList.size() - 1), paramList.size());
      if (localList.size() == 0)
      {
        a(paramList, paramDecisionRelateRule, paramInt);
      }
      else
      {
        if ((paramDecisionRelateRule.getValueNum() == 0) && (!paramDecisionRelateRule.getDecisionAction(paramList).isEmpty()))
          a(paramList, paramDecisionRelateRule, paramInt);
        for (int i = 0; i < localList.size(); i++)
        {
          ArrayList localArrayList = new ArrayList(paramList.size() + 1);
          localArrayList.addAll(paramList);
          localArrayList.add(localList.get(i));
          b(localArrayList, paramDecisionRelateRule, paramInt);
        }
      }
    }
    else
    {
      a(paramList, paramDecisionRelateRule, paramInt);
    }
  }

  protected void a(List paramList, DecisionRelateRule paramDecisionRelateRule, int paramInt)
  {
    int i = 0;
    Object localObject;
    for (int j = 0; j < paramDecisionRelateRule.getValueNum(); j++)
    {
      if (paramDecisionRelateRule.getDecisionElement(j + 1) == null)
        continue;
      localObject = paramDecisionRelateRule.getDecisionElement(j + 1).getMemberElement();
      if ((paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject) == null) || (paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject).getValue().length() <= 0))
        continue;
      i = 1;
      break;
    }
    if (i != 0)
    {
      l();
      d(a("tv_if"));
      ((IConditionToken)paramList.get(0)).acceptVisitor(this);
      for (j = 2; (j <= paramDecisionRelateRule.getConditionNum()) && (j <= paramList.size()); j++)
      {
        d(" " + a("tv_and"));
        ((IConditionToken)paramList.get(j - 1)).acceptVisitor(this);
      }
      d(" " + a("tv_then") + " ");
      for (j = 0; j < paramDecisionRelateRule.getValueNum(); j++)
      {
        if (paramDecisionRelateRule.getDecisionElement(j + 1) == null)
          continue;
        localObject = paramDecisionRelateRule.getDecisionElement(j + 1).getMemberElement();
        if ((paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject) == null) || (paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject).getValue().length() <= 0))
          continue;
        d(((IBusinessObject)localObject).getDisplayName());
        d(" " + a("EqualsTo.edit") + " ");
        d(paramDecisionRelateRule.getDecisionValue(paramList, (IBusinessObject)localObject).getValue());
      }
      DecisionRelateAction localDecisionRelateAction = paramDecisionRelateRule.getDecisionAction(paramList);
      if (!localDecisionRelateAction.isEmpty())
      {
        localObject = localDecisionRelateAction.getThenActions().getActions();
        while (((Iterator)localObject).hasNext())
          ((IStatementContainerToken)((Iterator)localObject).next()).acceptVisitor(this);
      }
      c();
    }
  }

  public Object visitDecisionRelateRule(DecisionRelateRule paramDecisionRelateRule)
  {
    b(1);
    List localList = paramDecisionRelateRule.getConditions().getConditionList();
    for (int i = 0; i < localList.size(); i++)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localList.get(i));
      b(localArrayList, paramDecisionRelateRule, i);
    }
    c(1);
    return null;
  }

  public Object visitDecisionRelateCondition(DecisionRelateCondition paramDecisionRelateCondition)
  {
    return null;
  }

  protected void g()
  {
  }

  protected void f()
  {
    c();
  }

  protected void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      a(paramInt);
    }
    else
    {
      d(paramString);
      a(paramInt - b(paramString));
    }
    d("\t");
  }

  public Object visitDecisionValue(DecisionValue paramDecisionValue)
  {
    paramDecisionValue.getAssignValue().acceptVisitor(this);
    return null;
  }

  public Object visitDecisionElement(DecisionElement paramDecisionElement)
  {
    return null;
  }

  public Object visitDecisionElementValue(DecisionElementValue paramDecisionElementValue)
  {
    paramDecisionElementValue.getAssignValue().acceptVisitor(this);
    return null;
  }

  public Object visitRuleToken(RuleToken paramRuleToken)
  {
    c();
    b(1);
    if ((paramRuleToken.getRule().isSupportEnter()) && (paramRuleToken.hasEnterCondition()))
    {
      e(a("tv_init"));
      b(1);
      paramRuleToken.getEnterCondition().acceptVisitor(this);
      c(1);
    }
    if ((paramRuleToken.getRule().isSupportInit()) && (paramRuleToken.getInitActions().getActions().hasNext()))
    {
      e(a("tv_init"));
      b(1);
      localIterator1 = paramRuleToken.getInitActions().getActions();
      while (localIterator1.hasNext())
        e((IElement)localIterator1.next());
      c(1);
    }
    Iterator localIterator1 = paramRuleToken.getWhenCondition().getConditions();
    if (localIterator1.hasNext())
    {
      e(a("tv_if"));
      b(1);
      while (localIterator1.hasNext())
        e((IElement)localIterator1.next());
      c(1);
      e(a("tv_then"));
    }
    b(1);
    Iterator localIterator2 = paramRuleToken.getThenActions().getActions();
    while (localIterator2.hasNext())
      e((IElement)localIterator2.next());
    c(1);
    List localList = paramRuleToken.getElseIfTokens();
    for (int i = 0; i < localList.size(); i++)
      ((ElseIfRuleToken)localList.get(i)).acceptVisitor(this);
    if ((paramRuleToken.getRule().isSupportElse()) && (paramRuleToken.getElseActions().getActions().hasNext()))
    {
      e(a("tv_else"));
      b(1);
      localIterator2 = paramRuleToken.getElseActions().getActions();
      while (localIterator2.hasNext())
        e((IElement)localIterator2.next());
      c(1);
    }
    if ((paramRuleToken.getRule().isSupportCatch()) && (paramRuleToken.getCatchActions().getActions().hasNext()))
    {
      e(a("catch_exception"));
      b(1);
      localIterator2 = paramRuleToken.getCatchActions().getActions();
      while (localIterator2.hasNext())
        e((IElement)localIterator2.next());
      c(1);
    }
    c(1);
    return null;
  }

  public Object visitElseIfRuleToken(ElseIfRuleToken paramElseIfRuleToken)
  {
    Iterator localIterator1 = paramElseIfRuleToken.getWhenCondition().getConditions();
    if (localIterator1.hasNext())
    {
      e(a("tv_elseif"));
      b(1);
      while (localIterator1.hasNext())
        e((IElement)localIterator1.next());
      c(1);
      e(a("tv_then"));
    }
    b(1);
    Iterator localIterator2 = paramElseIfRuleToken.getThenActions().getActions();
    while (localIterator2.hasNext())
      e((IElement)localIterator2.next());
    c(1);
    return null;
  }

  public Object visitRulePackage(RulePackage paramRulePackage)
  {
    a(paramRulePackage);
    return null;
  }

  public Object visitRuleSet(RuleSet paramRuleSet)
  {
    e(paramRuleSet.getDisplayName());
    e(paramRuleSet.getRuleSetToken());
    b(1);
    Iterator localIterator = paramRuleSet.getRuleAndSets();
    while (localIterator.hasNext())
      d((IElement)localIterator.next());
    c(1);
    return null;
  }

  public Object visitValueToken(ValueToken paramValueToken)
  {
    if ((paramValueToken.getParent() instanceof MemberToken))
      d("{");
    for (int i = 0; i < paramValueToken.getLeftParenthesisNumber(); i++)
      d("(");
    d(paramValueToken.getValueElement());
    for (i = 0; i < paramValueToken.getRightParenthesisNumber(); i++)
      d(")");
    if ((paramValueToken.getOperator() != null) && (!paramValueToken.getOperator().isNoOperator()))
    {
      d(paramValueToken.getOperator());
      d(paramValueToken.getNextValue());
    }
    if ((paramValueToken.getParent() instanceof MemberToken))
      d("}");
    return null;
  }

  public Object visitMemberToken(MemberToken paramMemberToken)
  {
    Iterator localIterator = paramMemberToken.getMultiToken();
    while (localIterator.hasNext())
      d((IElement)localIterator.next());
    return null;
  }

  public Object visitSheetFieldsSelectToken(SheetFieldsSelectToken paramSheetFieldsSelectToken)
  {
    d(paramSheetFieldsSelectToken.getDisplayName());
    return null;
  }

  public Object visitSheetFunctionsSelectToken(SheetFunctionsSelectToken paramSheetFunctionsSelectToken)
  {
    d(paramSheetFunctionsSelectToken.getDisplayName());
    return null;
  }

  public Object visitSheetFunction(SheetFunction paramSheetFunction)
  {
    d(paramSheetFunction.toString());
    return null;
  }

  public Object visitSheetWhere(SheetWhere paramSheetWhere)
  {
    d(paramSheetWhere.getValue());
    return null;
  }

  public Object visitSheetWheresSelectToken(SheetWheresSelectToken paramSheetWheresSelectToken)
  {
    d(paramSheetWheresSelectToken.getDisplayName());
    return null;
  }

  public Object visitSheetFieldSelectToken(SheetFieldSelectToken paramSheetFieldSelectToken)
  {
    d(paramSheetFieldSelectToken.getDisplayName());
    return null;
  }

  public Object visitSheetAndFieldsSelectToken(SheetAndFieldsSelectToken paramSheetAndFieldsSelectToken)
  {
    d(paramSheetAndFieldsSelectToken.getDisplayName());
    return null;
  }

  public Object visitSheetAndWheresSelectToken(SheetAndWheresSelectToken paramSheetAndWheresSelectToken)
  {
    d(paramSheetAndWheresSelectToken.getDisplayName());
    return null;
  }

  public Object visitSheetFieldMapping(SheetFieldMapping paramSheetFieldMapping)
  {
    d(paramSheetFieldMapping.toString());
    return null;
  }

  public Object visitConditionToken(ConditionToken paramConditionToken)
  {
    if (!paramConditionToken.isFirstCondition())
    {
      a(1);
      d(paramConditionToken.getLogicalOperator());
    }
    a(1);
    for (int i = 0; i < paramConditionToken.getLeftParenthesisNumber(); i++)
      d("(");
    if (paramConditionToken.getNextTests().hasNext())
      d("(");
    d(paramConditionToken.getFirstValue());
    d(paramConditionToken.getCompareOperator());
    d(paramConditionToken.getComparedValue());
    for (i = 0; i < paramConditionToken.getRightParenthesisNumber(); i++)
      d(")");
    Iterator localIterator = paramConditionToken.getNextTests();
    while (localIterator.hasNext())
    {
      IConditionToken localIConditionToken = (IConditionToken)localIterator.next();
      if (!localIConditionToken.isFirstCondition())
        d(localIConditionToken.getLogicalOperator());
      for (int j = 0; j < localIConditionToken.getLeftParenthesisNumber(); j++)
        d("(");
      d(localIConditionToken.getFirstValue());
      d(localIConditionToken.getCompareOperator());
      d(localIConditionToken.getComparedValue());
      for (j = 0; j < localIConditionToken.getRightParenthesisNumber(); j++)
        d(")");
    }
    if (paramConditionToken.getNextTests().hasNext())
      d(")");
    return null;
  }

  public Object visitConstantSelectToken(ConstantSelectToken paramConstantSelectToken)
  {
    if (paramConstantSelectToken.getConstantMember() != null)
      d(paramConstantSelectToken.getConstantMember().getValue());
    else
      d(paramConstantSelectToken.getDisplayName());
    return null;
  }

  public Object visitAssignToken(AssignToken paramAssignToken)
  {
    d(paramAssignToken.getFirstValue());
    if (paramAssignToken.getAssign() != null)
      paramAssignToken.getAssign().acceptVisitor(this);
    d(paramAssignToken.getComparedValue());
    return null;
  }

  public Object visitNewToken(NewToken paramNewToken)
  {
    d(paramNewToken.getHint() + paramNewToken.getDisplayName());
    return null;
  }

  public Object visitReturnToken(ReturnToken paramReturnToken)
  {
    d(paramReturnToken.getDisplayName());
    return null;
  }

  public Object visitExeRuleToken(ExeRuleToken paramExeRuleToken)
  {
    d(paramExeRuleToken.toString());
    return null;
  }

  public Object visitThrowToken(ThrowToken paramThrowToken)
  {
    d(paramThrowToken.getHint());
    d(paramThrowToken.getErrorValue());
    return null;
  }

  public Object visitDebugToken(DebugToken paramDebugToken)
  {
    d(paramDebugToken.getHint());
    d(paramDebugToken.getErrorValue());
    return null;
  }

  public Object visitClassToken(ClassToken paramClassToken)
  {
    d(paramClassToken.getDisplayName());
    return null;
  }

  public Object visitFunctionMember(FunctionMember paramFunctionMember)
  {
    d("\t");
    d(paramFunctionMember.getFunctionName());
    d("\t\t");
    d(paramFunctionMember.getValueType());
    d("\t\t");
    d(paramFunctionMember.getDisplayName());
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

  public Object visitTestObjectInfo(TestObjectInfo paramTestObjectInfo)
  {
    return null;
  }

  public Object visitTestCaseLib(TestCaseLib paramTestCaseLib)
  {
    return null;
  }

  public Object visitConstantEnum(ConstantEnum paramConstantEnum)
  {
    a(paramConstantEnum);
    return null;
  }

  public Object visitCustomFunction(CustomFunction paramCustomFunction)
  {
    a(paramCustomFunction);
    return null;
  }

  public Object visitEnumLibrary(EnumLibrary paramEnumLibrary)
  {
    a(paramEnumLibrary);
    return null;
  }

  public Object visitEnvionment(Envionment paramEnvionment)
  {
    a(paramEnvionment);
    return null;
  }

  public Object visitFunctionLibrary(FunctionLibrary paramFunctionLibrary)
  {
    a(paramFunctionLibrary);
    return null;
  }

  public Object visitGotoRuleToken(GotoRuleToken paramGotoRuleToken)
  {
    d(paramGotoRuleToken.getHint() + paramGotoRuleToken.getDisplayName());
    return null;
  }

  public Object visitMappingFunction(MappingFunction paramMappingFunction)
  {
    a(paramMappingFunction);
    b(1);
    f(paramMappingFunction);
    c(1);
    return null;
  }

  public Object visitMappingVariable(MappingVariable paramMappingVariable)
  {
    a(paramMappingVariable);
    b(1);
    f(paramMappingVariable);
    c(1);
    return null;
  }

  public Object visitMemberSelect(MemberToken.MemberSelector paramMemberSelector)
  {
    d(paramMemberSelector.getDisplayName());
    return null;
  }

  public Object visitTempVariable(TempVariable paramTempVariable)
  {
    a(paramTempVariable);
    b(1);
    f(paramTempVariable);
    c(1);
    return null;
  }

  public Object visitValueLibrary(ValueLibrary paramValueLibrary)
  {
    a(paramValueLibrary);
    return null;
  }

  public Object visitVariableLibrary(VariableLibrary paramVariableLibrary)
  {
    a(paramVariableLibrary);
    return null;
  }

  public Object visitStaticText(StaticTextToken paramStaticTextToken)
  {
    d(paramStaticTextToken.getDisplayName());
    return null;
  }

  public Object visitElementTextToken(ElementTextToken paramElementTextToken)
  {
    d(paramElementTextToken.getDisplayName());
    return null;
  }

  public Object visitSubFunction(AbstractSubFunction paramAbstractSubFunction)
  {
    a(paramAbstractSubFunction);
    return null;
  }

  public Object visitGlobalFunction(GlobalFunction paramGlobalFunction)
  {
    a(paramGlobalFunction);
    return null;
  }

  public Object visitSubVariable(AbstractSubVariable paramAbstractSubVariable)
  {
    a(paramAbstractSubVariable);
    return null;
  }

  public Object visitMultiActionToken(MultiActionToken paramMultiActionToken)
  {
    Iterator localIterator = paramMultiActionToken.getActions();
    while (localIterator.hasNext())
      e((IElement)localIterator.next());
    return null;
  }

  public Object visitMultiConditionToken(MultiConditionToken paramMultiConditionToken)
  {
    Iterator localIterator = paramMultiConditionToken.getConditions();
    if (localIterator.hasNext())
      while (localIterator.hasNext())
        e((IElement)localIterator.next());
    return null;
  }

  public Object visitRuleSetToken(RuleSetToken paramRuleSetToken)
  {
    if (paramRuleSetToken.getRuleSet().isInitTestType())
    {
      if (paramRuleSetToken.getInitActions().getActions().hasNext())
      {
        e(u.a("init.text"));
        b(1);
        paramRuleSetToken.getInitActions().acceptVisitor(this);
        c(1);
      }
      if (paramRuleSetToken.getTestConditions().getConditions().hasNext())
      {
        e(u.a("condition.text"));
        b(1);
        paramRuleSetToken.getTestConditions().acceptVisitor(this);
        c(1);
      }
    }
    else if (paramRuleSetToken.getRuleSet().isTestType())
    {
      if (paramRuleSetToken.getTestConditions().getConditions().hasNext())
      {
        e(u.a("condition.text"));
        b(1);
        paramRuleSetToken.getTestConditions().acceptVisitor(this);
        c(1);
      }
    }
    else if (paramRuleSetToken.getRuleSet().isForType())
    {
      if (paramRuleSetToken.getInitActions().getActions().hasNext())
      {
        e(u.a("init.text"));
        b(1);
        paramRuleSetToken.getInitActions().acceptVisitor(this);
        c(1);
      }
      if (paramRuleSetToken.getTestConditions().getConditions().hasNext())
      {
        e(u.a("test.text"));
        b(1);
        paramRuleSetToken.getTestConditions().acceptVisitor(this);
        c(1);
      }
      if (paramRuleSetToken.getBlockActions().getActions().hasNext())
      {
        d(u.a("block.text"));
        b(1);
        paramRuleSetToken.getBlockActions().acceptVisitor(this);
        c(1);
      }
    }
    if ((paramRuleSetToken.getRuleSet().isFirst()) && (paramRuleSetToken.getFirstActions().getActions().hasNext()))
    {
      d(u.a("first.text"));
      b(1);
      paramRuleSetToken.getBlockActions().acceptVisitor(this);
      c(1);
    }
    if ((paramRuleSetToken.getRuleSet().isSupportCatch()) && (paramRuleSetToken.getCatchActions().getActions().hasNext()))
    {
      e(a("catch_exception"));
      b(1);
      Iterator localIterator = paramRuleSetToken.getCatchActions().getActions();
      while (localIterator.hasNext())
        e((IElement)localIterator.next());
      c(1);
    }
    return null;
  }

  public Object visitDBModel(DBModel paramDBModel)
  {
    a(paramDBModel);
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

  public Object visitParameterModel(ParameterModel paramParameterModel)
  {
    return null;
  }

  public Object visitProcedureModel(ProcedureModel paramProcedureModel)
  {
    return null;
  }

  public Object visitViewModel(ViewModel paramViewModel)
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
    if (paramRuleMirror.getMemberElement() != null)
      paramRuleMirror.getMemberElement().acceptVisitor(this);
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
    d(paramExcuteRuleToken.toString());
    return null;
  }

  public Object visitLogRecordToken(LogRecordToken paramLogRecordToken)
  {
    d(paramLogRecordToken.toString());
    return null;
  }

  public Object visitAjaxPage(AjaxPage paramAjaxPage)
  {
    return null;
  }

  public Object visitSheetDynamicSelectToken(SheetDynamicSelectToken paramSheetDynamicSelectToken)
  {
    d(paramSheetDynamicSelectToken.getDisplayName());
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
    a(paramBOContainerGroup);
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
    d(paramAbstractPackageField.toString());
    return null;
  }

  public Object visitSheetFentanMapping(SheetFentanMapping paramSheetFentanMapping)
  {
    d(paramSheetFentanMapping.getDisplayName());
    return null;
  }

  public Object visitSheetFentanSelectToken(SheetFentanSelectToken paramSheetFentanSelectToken)
  {
    d(paramSheetFentanSelectToken.getDisplayName());
    return null;
  }

  public Object visitRuleEnterToken(RuleEnterToken paramRuleEnterToken)
  {
    Iterator localIterator = paramRuleEnterToken.getWhenCondition().getConditions();
    if (localIterator.hasNext())
    {
      e(a("condition.text"));
      b(1);
      while (localIterator.hasNext())
        e((IElement)localIterator.next());
      c(1);
    }
    return null;
  }

  public Object visitDecisionRelateAction(DecisionRelateAction paramDecisionRelateAction)
  {
    return null;
  }

  public Object visitExeExpressionToken(ExeExpressionToken paramExeExpressionToken)
  {
    d(paramExeExpressionToken.toString());
    return null;
  }

  public Object visitExeDecisionToken(ExeDecisionToken paramExeDecisionToken)
  {
    d(paramExeDecisionToken.toString());
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
    d(paramRulePoolValue.getDisplayName());
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
    if (paramForEachConditionToken.getReturnType() == 0)
    {
      d(u.a("foreachadd1.edit"));
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d(u.a("foreachadd2.edit"));
      paramForEachConditionToken.getRuleVersionToken("first").acceptVisitor(this);
      d(u.a("foreachadd3.edit"));
      paramForEachConditionToken.getRuleVersionToken("last").acceptVisitor(this);
    }
    else if (paramForEachConditionToken.getReturnType() == 1)
    {
      d(u.a("foreachminus1.edit"));
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d(u.a("foreachminus2.edit"));
      paramForEachConditionToken.getRuleVersionToken("first").acceptVisitor(this);
      d(u.a("foreachminus3.edit"));
      paramForEachConditionToken.getRuleVersionToken("last").acceptVisitor(this);
    }
    else if (paramForEachConditionToken.getReturnType() == 2)
    {
      d(u.a("foreacharray1.edit"));
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d(u.a("foreacharray2.edit"));
      paramForEachConditionToken.getRuleVersionToken("array").acceptVisitor(this);
    }
    else if (paramForEachConditionToken.getReturnType() == 3)
    {
      d(u.a("foreachlist1.edit"));
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d(u.a("foreachlist2.edit"));
      paramForEachConditionToken.getRuleVersionToken("list").acceptVisitor(this);
    }
    else if (paramForEachConditionToken.getReturnType() == 3)
    {
      d(u.a("foreachmap1.edit"));
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
      d(u.a("foreachmap2.edit"));
      paramForEachConditionToken.getSecondToken().acceptVisitor(this);
      d(u.a("foreachmap3.edit"));
      paramForEachConditionToken.getRuleVersionToken("map").acceptVisitor(this);
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.m
 * JD-Core Version:    0.6.0
 */