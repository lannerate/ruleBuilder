package com.flagleader.repository.e;

import com.flagleader.repository.IElement;
import com.flagleader.repository.d.H;
import com.flagleader.repository.d.d;
import com.flagleader.repository.d.m;
import com.flagleader.repository.d.u;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.e;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.excel.IExcelObject;
import com.flagleader.repository.export.PageFieldModel;
import com.flagleader.repository.flow.RulePoolValue;
import com.flagleader.repository.lang.expression.l;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.AbstractElementToken;
import com.flagleader.repository.rlm.ElseIfRuleToken;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.RuleEnterToken;
import com.flagleader.repository.rlm.RuleSetToken;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.AbstractPackageField;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.ExeRuleToken;
import com.flagleader.repository.rlm.action.GotoRuleToken;
import com.flagleader.repository.rlm.action.JavaStatementToken;
import com.flagleader.repository.rlm.action.MethodToken;
import com.flagleader.repository.rlm.action.PackageFieldGet;
import com.flagleader.repository.rlm.action.PackageFieldSet;
import com.flagleader.repository.rlm.action.ReturnToken;
import com.flagleader.repository.rlm.action.SelectRulePackageToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.ThrowToken;
import com.flagleader.repository.rlm.condition.ConditionToken;
import com.flagleader.repository.rlm.condition.ForEachConditionToken;
import com.flagleader.repository.rlm.condition.MultiConditionToken;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
import com.flagleader.repository.rlm.editen.ISheetSelectEditen;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IJudgeToken;
import com.flagleader.repository.rlm.lang.ILangToken;
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
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberPropertyToken;
import com.flagleader.repository.rlm.value.MemberToken;
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
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.FunctionMember;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.AbstractRuleSet;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateAction;
import com.flagleader.repository.tree.DecisionRelateCondition;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.DecisionValue;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.InterfaceContainer;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleMirror;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlAttribute;
import com.flagleader.repository.xml.XmlNode;
import com.flagleader.util.DateUtil;
import com.flagleader.util.ListUtil;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class h extends b
{
  private ArrayList a = new ArrayList();
  private boolean b = true;

  public e[] b(IElement paramIElement)
  {
    this.a.clear();
    paramIElement.acceptVisitor(this);
    return a();
  }

  public List c(IElement paramIElement)
  {
    this.a.clear();
    paramIElement.acceptVisitor(this);
    return this.a;
  }

  private boolean a(Envionment paramEnvionment, String paramString)
  {
    List localList = paramEnvionment.getAllVars();
    for (int i = 0; i < localList.size(); i++)
      if (localList.get(i).toString().equals(paramString))
        return true;
    return false;
  }

  public e[] a(ExportModel paramExportModel)
  {
    this.a.clear();
    List localList = paramExportModel.getPageFields();
    for (int i = 0; i < localList.size(); i++)
    {
      PageFieldModel localPageFieldModel = (PageFieldModel)localList.get(i);
      if (!a(paramExportModel.getEnvionment(), localPageFieldModel.getVariableName()))
      {
        a(a("pagefieldexits", new String[] { paramExportModel.getDisplayName(), localPageFieldModel.getDisplayName() + localPageFieldModel.getVariableName() }), paramExportModel, 3);
      }
      else
      {
        MappingVariable localMappingVariable = paramExportModel.getEnvionment().getValueLibrary().getVariable(localPageFieldModel.getVariableName());
        if ((localMappingVariable == null) || (localPageFieldModel.getValueType().equals(localMappingVariable.getValueType())))
          continue;
        a(a("pagefieldtype", new String[] { paramExportModel.getDisplayName(), localPageFieldModel.getDisplayName() + localPageFieldModel.getVariableName(), localPageFieldModel.getValueType(), localMappingVariable.getValueType() }), paramExportModel, 1);
      }
    }
    return a();
  }

  public d[] a()
  {
    d[] arrayOfd = new d[this.a.size()];
    for (int i = 0; i < this.a.size(); i++)
      arrayOfd[i] = ((d)this.a.get(i));
    return arrayOfd;
  }

  public List b()
  {
    return this.a;
  }

  private void a(d paramd)
  {
    this.a.add(paramd);
  }

  private void a(String paramString, IElement paramIElement, int paramInt)
  {
    d locald = new d(paramString, paramIElement, paramInt);
    a(locald);
  }

  public Object visitRule(Rule paramRule)
  {
    if (paramRule.getEnvionment() == null)
      if (paramRule.getMainPackage() != null)
        a(a("noEnvionment", new String[] { paramRule.getMainPackage().getDisplayName() }), paramRule, 0);
      else
        a(a("noEnvionment", new String[] { paramRule.getDisplayName() }), paramRule, 0);
    if (!paramRule.isActived())
      return null;
    Object localObject1;
    if (paramRule.getRuleElementToken() != null)
    {
      RuleToken localRuleToken = paramRule.getRuleElementToken();
      localRuleToken.getWhenCondition().acceptVisitor(this);
      localRuleToken.getThenActions().acceptVisitor(this);
      if ((paramRule.isSupportEnter()) && (localRuleToken.hasEnterCondition()))
        localRuleToken.getEnterCondition().acceptVisitor(this);
      if (paramRule.isSupportInit())
        localRuleToken.getInitActions().acceptVisitor(this);
      if (paramRule.isSupportElse())
        localRuleToken.getElseActions().acceptVisitor(this);
      if (paramRule.isSupportCatch())
        localRuleToken.getCatchActions().acceptVisitor(this);
      if (paramRule.getRuleElementToken().getElseIfTokens().size() > 0)
      {
        localObject1 = paramRule.getRuleElementToken().getElseIfTokens();
        for (int j = 0; j < ((List)localObject1).size(); j++)
          ((ElseIfRuleToken)((List)localObject1).get(j)).acceptVisitor(this);
      }
    }
    else
    {
      a(c("noRuleToken"), paramRule, 0);
    }
    if (a(paramRule))
      a(a("twoReturn", "there is two return in one action."), paramRule, 0);
    if (paramRule.isSupportCatch())
    {
      int i = 0;
      localObject1 = paramRule.getRuleElementToken().getCatchActions().getActions();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((((StatementContainerToken)localObject2).getStatement() != null) && ((((StatementContainerToken)localObject2).getStatement() instanceof ReturnToken)))
          i++;
        if ((((StatementContainerToken)localObject2).getStatement() == null) || (!(((StatementContainerToken)localObject2).getStatement() instanceof ThrowToken)))
          continue;
        i++;
      }
      if (((i == 1) && (paramRule.getExceptionType() != 3)) || (i > 1))
        a(a("twoCatchRuturn", "there is two return in one action."), paramRule, 0);
    }
    if ((paramRule.isSheetWhile()) && (paramRule.getWhileSheet() == null))
      a(a("whilenotexits", "there is two return in one action."), paramRule, 0);
    return null;
  }

  public Object visitRuleSetToken(RuleSetToken paramRuleSetToken)
  {
    if (paramRuleSetToken.getRuleSet().isTestType())
    {
      paramRuleSetToken.getTestConditions().acceptVisitor(this);
    }
    else if (paramRuleSetToken.getRuleSet().isInitTestType())
    {
      paramRuleSetToken.getInitActions().acceptVisitor(this);
      paramRuleSetToken.getTestConditions().acceptVisitor(this);
    }
    else if (paramRuleSetToken.getRuleSet().isForType())
    {
      if (paramRuleSetToken.getTestConditions().getChildrenCount() == 0)
        a(a("whileEmpty", "no condition in this while"), paramRuleSetToken, 2);
      super.visitRuleSetToken(paramRuleSetToken);
    }
    int i = 0;
    Iterator localIterator;
    Object localObject;
    if ((paramRuleSetToken.getRuleSet().isInitTestType()) || (paramRuleSetToken.getRuleSet().isForType()))
    {
      localIterator = paramRuleSetToken.getInitActions().getActions();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if ((((StatementContainerToken)localObject).getStatement() != null) && ((((StatementContainerToken)localObject).getStatement() instanceof ReturnToken)))
          i++;
        if ((((StatementContainerToken)localObject).getStatement() == null) || (!(((StatementContainerToken)localObject).getStatement() instanceof ThrowToken)))
          continue;
        i++;
      }
    }
    if (paramRuleSetToken.getRuleSet().isForType())
    {
      localIterator = paramRuleSetToken.getBlockActions().getActions();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if ((((StatementContainerToken)localObject).getStatement() != null) && ((((StatementContainerToken)localObject).getStatement() instanceof ReturnToken)))
          i++;
        if ((((StatementContainerToken)localObject).getStatement() == null) || (!(((StatementContainerToken)localObject).getStatement() instanceof ThrowToken)))
          continue;
        i++;
      }
    }
    if (paramRuleSetToken.getRuleSet().isFirst())
    {
      localIterator = paramRuleSetToken.getFirstActions().getActions();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if ((((StatementContainerToken)localObject).getStatement() != null) && ((((StatementContainerToken)localObject).getStatement() instanceof ReturnToken)))
          i++;
        if ((((StatementContainerToken)localObject).getStatement() == null) || (!(((StatementContainerToken)localObject).getStatement() instanceof ThrowToken)))
          continue;
        i++;
      }
    }
    if (paramRuleSetToken.getRuleSet().isSupportCatch())
      paramRuleSetToken.getCatchActions().acceptVisitor(this);
    if (i > 0)
      a(a("returnRuleSet", "there is two return in one action."), paramRuleSetToken, 0);
    return null;
  }

  public Object visitRuleSet(RuleSet paramRuleSet)
  {
    paramRuleSet.getRuleSetToken().acceptVisitor(this);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramRuleSet.getChildrenIterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if (!(localIElement instanceof RuleSetToken))
        localIElement.acceptVisitor(this);
      if (!(localIElement instanceof ITreeNode))
        continue;
      if (localHashMap.get(localIElement.getDisplayName()) == null)
      {
        localHashMap.put(localIElement.getDisplayName(), localIElement.getDisplayName());
      }
      else if (this.b)
      {
        localIElement.setDisplayName(paramRuleSet.getChildDefaultName(StringUtil.removeLastNumber(localIElement.getDisplayName())));
        localHashMap.put(localIElement.getDisplayName(), localIElement.getDisplayName());
      }
      else
      {
        a(a("samerulename", new String[] { localIElement.getDisplayName() }), paramRuleSet, 0);
      }
    }
    localHashMap.clear();
    return null;
  }

  public Object visitDecisionRule(DecisionRule paramDecisionRule)
  {
    paramDecisionRule.getFirstConditions().acceptVisitor(this);
    paramDecisionRule.getSecondConditions().acceptVisitor(this);
    List localList1 = paramDecisionRule.getDecisionValues();
    for (int i = 0; i < localList1.size(); i++)
    {
      if (paramDecisionRule.getMemberElement().getJavaType().e(((DecisionValue)localList1.get(i)).getValue()))
        continue;
      a(a("valueDecision", new String[] { paramDecisionRule.getDisplayName(), paramDecisionRule.getMemberElement().getValueType(), ((DecisionValue)localList1.get(i)).getValue() }), paramDecisionRule, 0);
    }
    List localList2 = paramDecisionRule.getChildrenList();
    for (int j = 0; j < localList2.size(); j++)
    {
      Object localObject = localList2.get(j);
      if ((localObject instanceof IMultiConditionToken))
      {
        ((IMultiConditionToken)localObject).acceptVisitor(this);
        a((IMultiConditionToken)localObject);
      }
      else if ((localObject instanceof DecisionRelateCondition))
      {
        if (((DecisionRelateCondition)localObject).getConditionPos() > paramDecisionRule.getConditionNum())
          continue;
        ((DecisionRelateCondition)localObject).acceptVisitor(this);
        a(((DecisionRelateCondition)localObject).getConditions());
      }
      else
      {
        if (!(localObject instanceof DecisionRelateAction))
          continue;
        ((DecisionRelateAction)localObject).acceptVisitor(this);
      }
    }
    return null;
  }

  public Object visitDecisionMultiRule(DecisionMultiRule paramDecisionMultiRule)
  {
    for (int i = 0; i < paramDecisionMultiRule.getValueNum(); i++)
    {
      if (paramDecisionMultiRule.getDecisionElement(i + 1) == null)
        continue;
      IBusinessObject localIBusinessObject = paramDecisionMultiRule.getDecisionElement(i + 1).getMemberElement();
      if (localIBusinessObject != null)
      {
        List localList = paramDecisionMultiRule.getDecisionValues(localIBusinessObject);
        for (int j = 0; j < localList.size(); j++)
        {
          if (((DecisionElementValue)localList.get(j)).getAssignValue() == null)
            continue;
          if (!((DecisionElementValue)localList.get(j)).getAssignValue().getJavaType().equals(localIBusinessObject.getJavaType()))
          {
            a(a("valueDecision", new String[] { localIBusinessObject.getValueType(), ((DecisionElementValue)localList.get(j)).getAssignValue().getJavaType().K() }), paramDecisionMultiRule, 0);
            return null;
          }
          ((DecisionElementValue)localList.get(j)).getAssignValue().acceptVisitor(this);
        }
      }
      else
      {
        a(a("decisionMemberExits", new String[] { paramDecisionMultiRule.getDisplayName() }), paramDecisionMultiRule, 1);
        return null;
      }
    }
    for (i = 0; i < paramDecisionMultiRule.getConditionNum(); i++)
    {
      paramDecisionMultiRule.getConditions(i + 1).acceptVisitor(this);
      if (paramDecisionMultiRule.getConditions(i + 1).getConditionList().size() == 0)
        a(a("emptydecisioncondition", new String[] { paramDecisionMultiRule.toString() }), paramDecisionMultiRule, 1);
      a(paramDecisionMultiRule.getConditions(i + 1));
    }
    return null;
  }

  public Object visitExpressionRule(ExpressionRule paramExpressionRule)
  {
    try
    {
      l locall = paramExpressionRule.getRules();
      List localList = locall.a(new ArrayList());
      for (int i = 0; i < localList.size(); i++)
        ((ILangToken)localList.get(i)).acceptVisitor(this);
    }
    catch (Exception localException)
    {
      a(a("expressionparseerror", new String[] { localException.getMessage() }), paramExpressionRule, 1);
    }
    return null;
  }

  private void a(IMultiConditionToken paramIMultiConditionToken)
  {
    List localList = paramIMultiConditionToken.getConditionList();
    for (int i = 0; i < localList.size(); i++)
    {
      IConditionToken localIConditionToken = (IConditionToken)localList.get(i);
      a(paramIMultiConditionToken, localIConditionToken, localIConditionToken);
    }
  }

  private void a(IMultiConditionToken paramIMultiConditionToken, IConditionToken paramIConditionToken1, IConditionToken paramIConditionToken2)
  {
    IValueContainerToken localIValueContainerToken = paramIConditionToken1.getComparedValue();
    Object localObject;
    if ((localIValueContainerToken != null) && (localIValueContainerToken.getValueElement() != null) && ((localIValueContainerToken.getValueElement() instanceof ConstantToken)) && (localIValueContainerToken.getValueElement() != null) && (((ConstantToken)localIValueContainerToken.getValueElement()).getValue().length() > 0))
    {
      localObject = paramIMultiConditionToken.getConditionList();
      for (int i = 0; i < ((List)localObject).size(); i++)
      {
        IConditionToken localIConditionToken = (IConditionToken)((List)localObject).get(i);
        if ((localIConditionToken.equals(paramIConditionToken2)) || ((paramIMultiConditionToken.getRoot() != null) && ((paramIMultiConditionToken.getRoot().getRuleTree() instanceof DecisionRelateRule)) && (((DecisionRelateRule)paramIMultiConditionToken.getRoot().getRuleTree()).getConditionNum() > 1)))
          continue;
        try
        {
          if (!a(localIConditionToken, paramIConditionToken1))
            continue;
          a(a("valueDecisionDuplicate", new String[] { paramIConditionToken1.toString(), localIConditionToken.toString() }), localIConditionToken.getRoot(), 2);
        }
        catch (Exception localException2)
        {
          a(a("valueException", new String[] { paramIConditionToken1.toString(), localIConditionToken.toString() }), localIConditionToken.getRoot(), 1);
        }
      }
    }
    if (paramIConditionToken1.getNextTests().hasNext())
    {
      localObject = (IConditionToken)paramIConditionToken1.getNextTests().next();
      if ((!((IConditionToken)localObject).getLogicalOperator().isNary()) && ((!(paramIMultiConditionToken.getRoot() instanceof DecisionRelateRule)) || (((DecisionRelateRule)paramIMultiConditionToken.getRoot()).getConditionNum() <= 1)))
        try
        {
          if ((!a((IConditionToken)localObject, paramIConditionToken1)) && ((paramIConditionToken1.getRoot() instanceof IRuleTree)) && (((IRuleTree)paramIConditionToken1.getRoot()).getMatchType() == 0))
            a(a("valueDecisionConflict", new String[] { paramIConditionToken1.toString(), localObject.toString() }), paramIConditionToken1.getRoot(), 2);
        }
        catch (Exception localException1)
        {
          a(a("valueException", new String[] { paramIConditionToken1.toString(), localObject.toString() }), paramIConditionToken1.getRoot(), 1);
        }
      a(paramIMultiConditionToken, (IConditionToken)paramIConditionToken1.getNextTests().next(), paramIConditionToken2);
    }
  }

  private boolean a(IConditionToken paramIConditionToken1, IConditionToken paramIConditionToken2)
  {
    if (paramIConditionToken1.getNextTests().hasNext())
    {
      IConditionToken localIConditionToken = (IConditionToken)paramIConditionToken1.getNextTests().next();
      if (localIConditionToken.getLogicalOperator().isNary())
        return (b(paramIConditionToken1, paramIConditionToken2)) || (a(localIConditionToken, paramIConditionToken2));
      return (b(paramIConditionToken1, paramIConditionToken2)) && (a(localIConditionToken, paramIConditionToken2));
    }
    return b(paramIConditionToken1, paramIConditionToken2);
  }

  private boolean b(IConditionToken paramIConditionToken1, IConditionToken paramIConditionToken2)
  {
    if ((paramIConditionToken2.getFirstValue() != null) && (paramIConditionToken1.getFirstValue() != null) && (paramIConditionToken2.getFirstValue().getDisplayName().equals(paramIConditionToken1.getFirstValue().getDisplayName())))
    {
      IValueContainerToken localIValueContainerToken = paramIConditionToken1.getComparedValue();
      if ((localIValueContainerToken != null) && (localIValueContainerToken.getValueElement() != null) && ((localIValueContainerToken.getValueElement() instanceof ConstantToken)))
      {
        String str = ((ConstantToken)localIValueContainerToken.getValueElement()).getValue();
        if (str != null)
        {
          ConstantToken localConstantToken = (ConstantToken)paramIConditionToken2.getComparedValue().getValueElement();
          if ((localConstantToken.getJavaType().b()) && (str.length() > 0))
          {
            if (a(localConstantToken.getValue(), str, paramIConditionToken1.getCompareOperator().getType(), paramIConditionToken2.getCompareOperator().getType()))
              return true;
          }
          else if (localConstantToken.getJavaType().m())
            if ((paramIConditionToken2.getRoot().getRuleTree().getMainPackage() != null) && (paramIConditionToken2.getRoot().getRuleTree().getMainPackage().isIgniorString()))
            {
              if (b(localConstantToken.getValue().toLowerCase(), str.toLowerCase(), paramIConditionToken2.getCompareOperator().getType(), paramIConditionToken2.getCompareOperator().getType()))
                return true;
            }
            else if (b(localConstantToken.getValue(), str, paramIConditionToken2.getCompareOperator().getType(), paramIConditionToken2.getCompareOperator().getType()))
              return true;
        }
      }
    }
    return false;
  }

  private boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramString1 = NumberUtil.parseNumber(paramString1, true);
    paramString2 = NumberUtil.parseNumber(paramString2, true);
    if (paramInt2 == 1)
      return false;
    if (paramInt1 == 0)
    {
      if (((paramInt2 == 0) || (paramInt2 == 5) || (paramInt2 == 3)) && (Double.parseDouble(paramString1) == Double.parseDouble(paramString2)))
        return true;
    }
    else if (paramInt1 == 5)
    {
      if ((paramInt2 == 0) || (paramInt2 == 5) || (paramInt2 == 3))
      {
        if (Double.parseDouble(paramString1) <= Double.parseDouble(paramString2))
          return true;
      }
      else if (Double.parseDouble(paramString1) < Double.parseDouble(paramString2))
        return true;
    }
    else if (paramInt1 == 4)
    {
      if (Double.parseDouble(paramString1) < Double.parseDouble(paramString2))
        return true;
    }
    else if (paramInt1 == 3)
    {
      if ((paramInt2 == 0) || (paramInt2 == 5) || (paramInt2 == 3))
      {
        if (Double.parseDouble(paramString1) >= Double.parseDouble(paramString2))
          return true;
      }
      else if (Double.parseDouble(paramString1) > Double.parseDouble(paramString2))
        return true;
    }
    else if ((paramInt1 == 2) && (Double.parseDouble(paramString1) > Double.parseDouble(paramString2)))
      return true;
    return false;
  }

  private boolean b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
      return false;
    if (paramInt1 == 0)
    {
      if (paramString1.equals(paramString2))
        return true;
    }
    else
    {
      if (paramInt1 == 1)
        return false;
      if (paramInt1 == 9)
      {
        if (paramString1.length() == 0)
          return true;
      }
      else if (paramInt1 == 5)
      {
        if (paramString1.endsWith(paramString2))
          return true;
      }
      else if (paramInt1 == 2)
      {
        if (paramString1.indexOf(paramString2) >= 0)
          return true;
      }
      else if (paramInt1 == 8)
      {
        if (paramString1.length() > 0)
          return true;
      }
      else if (paramInt1 == 3)
      {
        if (paramString1.indexOf(paramString2) < 0)
          return true;
      }
      else if (paramInt1 == 4)
      {
        if (paramString1.startsWith(paramString2))
          return true;
      }
      else
      {
        String[] arrayOfString;
        int i;
        if (paramInt1 == 10)
        {
          if (paramInt2 == 10)
          {
            if ((paramString1 == null) || (paramString2 == null))
              return false;
            arrayOfString = (String[])null;
            if (paramString1.indexOf("\n") >= 0)
              arrayOfString = paramString1.split("\n");
            else if (paramString1.indexOf(",") >= 0)
              arrayOfString = paramString1.split(",");
            if (arrayOfString != null)
              for (i = 0; i < arrayOfString.length; i++)
                if (ListUtil.checkExits(arrayOfString[i], paramString2))
                  return true;
          }
          else if (ListUtil.checkExits(paramString1, paramString2))
          {
            return true;
          }
        }
        else if (paramInt1 == 11)
          if (paramInt2 == 11)
          {
            if ((paramString1 == null) || (paramString2 == null))
              return false;
            arrayOfString = (String[])null;
            if (paramString1.indexOf("\n") >= 0)
              arrayOfString = paramString1.split("\n");
            else if (paramString1.indexOf(",") >= 0)
              arrayOfString = paramString1.split(",");
            if (arrayOfString != null)
              for (i = 0; i < arrayOfString.length; i++)
                if (ListUtil.checkExits(arrayOfString[i], paramString2))
                  return true;
          }
          else if (ListUtil.checkExits(paramString1, paramString2))
          {
            return true;
          }
      }
    }
    return false;
  }

  public Object visitDecisionRelateRule(DecisionRelateRule paramDecisionRelateRule)
  {
    Object localObject;
    for (int i = 0; i < paramDecisionRelateRule.getValueNum(); i++)
    {
      if (paramDecisionRelateRule.getDecisionElement(i + 1) == null)
        continue;
      IBusinessObject localIBusinessObject = paramDecisionRelateRule.getDecisionElement(i + 1).getMemberElement();
      if (localIBusinessObject != null)
      {
        localObject = paramDecisionRelateRule.getDecisionValues(localIBusinessObject);
        for (int k = 0; k < ((List)localObject).size(); k++)
        {
          if (((DecisionElementValue)((List)localObject).get(k)).getAssignValue() == null)
            continue;
          if (!((DecisionElementValue)((List)localObject).get(k)).getAssignValue().getJavaType().equals(localIBusinessObject.getJavaType()))
          {
            a(a("valueDecision", new String[] { localIBusinessObject.getValueType(), ((DecisionElementValue)((List)localObject).get(k)).getAssignValue().getJavaType().K() }), paramDecisionRelateRule, 0);
            return null;
          }
          ((DecisionElementValue)((List)localObject).get(k)).getAssignValue().acceptVisitor(this);
        }
      }
      else
      {
        a(a("decisionMemberExits", new String[] { paramDecisionRelateRule.getDisplayName() }), paramDecisionRelateRule, 1);
        return null;
      }
    }
    List localList = paramDecisionRelateRule.getChildrenList();
    for (int j = 0; j < localList.size(); j++)
    {
      localObject = localList.get(j);
      if ((localObject instanceof IMultiConditionToken))
      {
        ((IMultiConditionToken)localObject).acceptVisitor(this);
        a((IMultiConditionToken)localObject);
      }
      else if ((localObject instanceof DecisionRelateCondition))
      {
        if (((DecisionRelateCondition)localObject).getConditionPos() > paramDecisionRelateRule.getConditionNum())
          continue;
        ((DecisionRelateCondition)localObject).acceptVisitor(this);
        a(((DecisionRelateCondition)localObject).getConditions());
      }
      else
      {
        if (!(localObject instanceof DecisionRelateAction))
          continue;
        ((DecisionRelateAction)localObject).acceptVisitor(this);
      }
    }
    return null;
  }

  public Object visitDecisionRelateCondition(DecisionRelateCondition paramDecisionRelateCondition)
  {
    if (paramDecisionRelateCondition.isValid())
      return super.visitDecisionRelateCondition(paramDecisionRelateCondition);
    return null;
  }

  public Object visitDecisionElement(DecisionElement paramDecisionElement)
  {
    if (paramDecisionElement.getMemberElement() == null)
    {
      a(a("memberExits", new String[] { paramDecisionElement.getDisplayName() }), paramDecisionElement.getParent(), 1);
      return null;
    }
    return null;
  }

  public Object visitDecisionElementValue(DecisionElementValue paramDecisionElementValue)
  {
    return null;
  }

  public Object visitDecisionValue(DecisionValue paramDecisionValue)
  {
    return null;
  }

  public Object visitRuleToken(RuleToken paramRuleToken)
  {
    return super.visitRuleToken(paramRuleToken);
  }

  public Object visitElseIfRuleToken(ElseIfRuleToken paramElseIfRuleToken)
  {
    return super.visitElseIfRuleToken(paramElseIfRuleToken);
  }

  private boolean a(Rule paramRule)
  {
    int i = 0;
    int j = 0;
    Iterator localIterator = paramRule.getRuleElementToken().getThenActions().getActions();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((((StatementContainerToken)localObject).getStatement() != null) && ((((StatementContainerToken)localObject).getStatement() instanceof ReturnToken)))
        i++;
      if ((((StatementContainerToken)localObject).getStatement() == null) || (!(((StatementContainerToken)localObject).getStatement() instanceof ThrowToken)))
        continue;
      i++;
    }
    localIterator = paramRule.getRuleElementToken().getElseActions().getActions();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((((StatementContainerToken)localObject).getStatement() != null) && ((((StatementContainerToken)localObject).getStatement() instanceof ReturnToken)))
        j++;
      if ((((StatementContainerToken)localObject).getStatement() == null) || (!(((StatementContainerToken)localObject).getStatement() instanceof ThrowToken)))
        continue;
      j++;
    }
    return (i > 1) || (j > 1);
  }

  public Object visitValueToken(ValueToken paramValueToken)
  {
    if (!(paramValueToken.getParent() instanceof ValueToken))
      a(paramValueToken);
    for (Object localObject = paramValueToken; localObject != null; localObject = ((IValueContainerToken)localObject).getNextValue())
    {
      if (((IValueContainerToken)localObject).getValueElement() == null)
        a(a("valueEmpty", new String[] { paramValueToken.getSelector().getDisplayName() }), paramValueToken.getParentLine(), 0);
      else if (!((IValueContainerToken)localObject).getJavaType().a(((IValueContainerToken)localObject).getValueElement().getJavaType(), true))
        a(a("valueTypeAssign", new String[] { ((IValueContainerToken)localObject).getValueElement().getDisplayName(), paramValueToken.getValueType(), ((IValueContainerToken)localObject).getValueElement().getValueType() }), paramValueToken.getParentLine(), 1);
      if (((IValueContainerToken)localObject).checkOperator())
        continue;
      a(a("valueTypeAssign", new String[] { ((IValueContainerToken)localObject).getValueElement().getDisplayName(), paramValueToken.getValueType(), ((IValueContainerToken)localObject).getOperator().getName() }), paramValueToken.getParentLine(), 1);
    }
    b(paramValueToken);
    return super.visitValueToken(paramValueToken);
  }

  public Object visitMultiConditionToken(MultiConditionToken paramMultiConditionToken)
  {
    int i = 0;
    Iterator localIterator = paramMultiConditionToken.getConditions();
    while (localIterator.hasNext())
    {
      IConditionToken localIConditionToken = (IConditionToken)localIterator.next();
      i += localIConditionToken.getAllLeftParenthesisNumber();
      i -= localIConditionToken.getAllRightParenthesisNumber();
    }
    if (i != 0)
      a(a("parenthesisNumber", new String[] { paramMultiConditionToken.toString() }), paramMultiConditionToken.getParentLine(), 1);
    return super.visitMultiConditionToken(paramMultiConditionToken);
  }

  private void a(ValueToken paramValueToken)
  {
    int i = 0;
    Object localObject = paramValueToken;
    do
    {
      i += ((IValueContainerToken)localObject).getLeftParenthesisNumber();
      i -= ((IValueContainerToken)localObject).getRightParenthesisNumber();
      localObject = ((IValueContainerToken)localObject).getNextValue();
    }
    while (localObject != null);
    if (i != 0)
      a(a("parenthesisNumber", new String[] { paramValueToken.getValueElement() == null ? paramValueToken.getSelector().getDisplayName() : paramValueToken.getValueElement().getDisplayName() }), paramValueToken.getParentLine(), 1);
  }

  private void b(ValueToken paramValueToken)
  {
    Object localObject = paramValueToken;
    IValueContainerToken localIValueContainerToken2;
    for (IValueContainerToken localIValueContainerToken1 = paramValueToken.getNextValue(); (localObject != null) && (localIValueContainerToken1 != null); localIValueContainerToken1 = localIValueContainerToken2.getNextValue())
    {
      if (!a((IValueContainerToken)localObject, localIValueContainerToken1))
        a(a("valueMatch", new String[] { ((IValueContainerToken)localObject).getDisplayName(), ((IValueContainerToken)localObject).getValueType(), localIValueContainerToken1.getDisplayName(), localIValueContainerToken1.getValueType() }), paramValueToken.getParentLine(), 1);
      localIValueContainerToken2 = localIValueContainerToken1;
      localObject = localIValueContainerToken1;
    }
  }

  private boolean a(IValueContainerToken paramIValueContainerToken1, IValueContainerToken paramIValueContainerToken2)
  {
    if ((paramIValueContainerToken1 == null) || (paramIValueContainerToken2 == null))
      return false;
    if ((paramIValueContainerToken1.getValueElement() == null) || (paramIValueContainerToken2.getValueElement() == null))
      return false;
    if (paramIValueContainerToken1.getJavaType().a(paramIValueContainerToken2.getJavaType(), true))
      return true;
    if ((paramIValueContainerToken1.getValueElement().getJavaType().b()) && (paramIValueContainerToken2.getValueElement().getJavaType().b()))
      return true;
    return (paramIValueContainerToken1.getValueElement().getJavaType().v()) && (paramIValueContainerToken2.getValueElement().getJavaType().b());
  }

  public Object visitMethodToken(MethodToken paramMethodToken)
  {
    return visitMemberToken(paramMethodToken);
  }

  private String a(String paramString1, String paramString2)
  {
    return u.a(paramString1 + ".error", paramString2);
  }

  private String c(String paramString)
  {
    return u.a(paramString + ".error");
  }

  private String a(String paramString, Object[] paramArrayOfObject)
  {
    return u.a(paramString + ".error", paramArrayOfObject);
  }

  public Object visitMemberToken(MemberToken paramMemberToken)
  {
    IElement localIElement = paramMemberToken.getMemberElement();
    if (localIElement == null)
    {
      a(a("memberExits", new String[] { paramMemberToken.getDisplayName() }), paramMemberToken.getParentLine(), 1);
      return null;
    }
    if ((localIElement instanceof SheetFieldModel))
    {
      if (!paramMemberToken.acceptSheetField((SheetFieldModel)localIElement))
      {
        a(a("sheetFieldUnset", new String[] { paramMemberToken.getDisplayName(), localIElement.getParent().getDisplayName() }), paramMemberToken.getParentLine(), 1);
        return null;
      }
    }
    else if (((localIElement instanceof TableFunction)) && ((localIElement.getParent() instanceof SheetTable)) && (!paramMemberToken.canIncludeSheetField()))
    {
      List localList = paramMemberToken.getWhileSheets();
      for (int j = 0; (localList != null) && (j < localList.size()); j++)
      {
        if (!localIElement.getParent().equals(localList.get(j)))
          continue;
        a(a("tableFunctionUnset", new String[] { localIElement.getParent().getDisplayName(), paramMemberToken.getDisplayName() }), paramMemberToken.getParentLine(), 1);
        return null;
      }
    }
    if (!paramMemberToken.checkParams())
      a(a("methodParam", new String[] { paramMemberToken.getDisplayName() }), paramMemberToken.getParentLine(), 1);
    for (int i = 0; i < paramMemberToken.getValueTokens().size(); i++)
      if (paramMemberToken.getParamType(((ValueToken)paramMemberToken.getValueTokens().get(i)).getArgName()) == null)
        a(a("methodDisplay", new String[] { paramMemberToken.getDisplayName() }), paramMemberToken.getParentLine(), 1);
      else if (((ValueToken)paramMemberToken.getValueTokens().get(i)).getValueElement() == null)
        a(a("methodValueEmpty", new String[] { paramMemberToken.getDisplayName() }), paramMemberToken.getParentLine(), 1);
      else if (!paramMemberToken.getParamType(((ValueToken)paramMemberToken.getValueTokens().get(i)).getArgName()).a(((ValueToken)paramMemberToken.getValueTokens().get(i)).getValueElement().getJavaType(), true))
        a(a("paramValueMatch", new String[] { paramMemberToken.getDisplayName(), paramMemberToken.getParamType(((ValueToken)paramMemberToken.getValueTokens().get(i)).getArgName()).K(), ((ValueToken)paramMemberToken.getValueTokens().get(i)).getValueElement().getJavaType().K() }), paramMemberToken.getParentLine(), 1);
      else
        visitValueToken((ValueToken)paramMemberToken.getValueTokens().get(i));
    return null;
  }

  public Object visitSheetFieldSelectToken(SheetFieldSelectToken paramSheetFieldSelectToken)
  {
    if (paramSheetFieldSelectToken.getSelected() == null)
    {
      a(a("sheetFieldSelectExits", new String[] { paramSheetFieldSelectToken.getFieldUnique() }), paramSheetFieldSelectToken.getParentLine(), 1);
      return null;
    }
    return null;
  }

  public Object visitRulePoolValue(RulePoolValue paramRulePoolValue)
  {
    if (paramRulePoolValue.getSelected() == null)
    {
      a(a("sheetFieldSelectExits", new String[] { paramRulePoolValue.getFieldUnique() }), paramRulePoolValue.getParentLine(), 1);
      return null;
    }
    return null;
  }

  public Object visitSheetFieldsSelectToken(SheetFieldsSelectToken paramSheetFieldsSelectToken)
  {
    if (paramSheetFieldsSelectToken.getMemberElement() == null)
    {
      a(a("sheetExits", new String[] { paramSheetFieldsSelectToken.getUniqueName() }), paramSheetFieldsSelectToken.getParentLine(), 1);
      return null;
    }
    String[] arrayOfString1 = paramSheetFieldsSelectToken.getFieldUuids().split(",");
    String[] arrayOfString2 = paramSheetFieldsSelectToken.getFieldNames().split(",");
    if ((arrayOfString1.length != arrayOfString2.length) || (paramSheetFieldsSelectToken.getEnvionment() == null))
      throw new H("get selected fields error!");
    ArrayList localArrayList = new ArrayList(arrayOfString1.length);
    IBusinessObject localIBusinessObject1 = paramSheetFieldsSelectToken.getMemberElement();
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      if (arrayOfString1[i].length() <= 0)
        continue;
      IBusinessObject localIBusinessObject2 = null;
      List localList;
      int j;
      if ((localIBusinessObject1 != null) && ((localIBusinessObject1 instanceof SheetTable)))
      {
        localList = ((SheetTable)localIBusinessObject1).getFields();
        j = 0;
      }
      while (true)
        if (((IBusinessObject)localList.get(j)).getUuid().equals(arrayOfString1[i]))
        {
          localIBusinessObject2 = (IBusinessObject)localList.get(j);
        }
        else if (((IBusinessObject)localList.get(j)).getUuid().equals(arrayOfString2[i]))
        {
          localIBusinessObject2 = (IBusinessObject)localList.get(j);
        }
        else
        {
          j++;
          if (j < localList.size())
            continue;
          break;
          if ((localIBusinessObject1 == null) || (!(localIBusinessObject1.getParent() instanceof SheetTable)))
            break;
          localList = ((SheetTable)localIBusinessObject1.getParent()).getFields();
          for (j = 0; j < localList.size(); j++)
          {
            if (((IBusinessObject)localList.get(j)).getUuid().equals(arrayOfString1[i]))
            {
              localIBusinessObject2 = (IBusinessObject)localList.get(j);
              break;
            }
            if (!((IBusinessObject)localList.get(j)).getValueName().equals(arrayOfString2[i]))
              continue;
            localIBusinessObject2 = (IBusinessObject)localList.get(j);
            break;
          }
        }
      if (localIBusinessObject2 == null)
        localIBusinessObject2 = paramSheetFieldsSelectToken.getEnvionment().getBusinessObject(arrayOfString1[i], arrayOfString2[i]);
      if (localIBusinessObject2 != null)
        continue;
      a(a("sheetFieldSelectExits", new String[] { paramSheetFieldsSelectToken.getDisplayName(), arrayOfString2[i] }), paramSheetFieldsSelectToken.getParentLine(), 1);
      return null;
    }
    return null;
  }

  public Object visitSheetFunctionsSelectToken(SheetFunctionsSelectToken paramSheetFunctionsSelectToken)
  {
    if (paramSheetFunctionsSelectToken.getMemberElement() == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetFunctionsSelectToken.getUniqueName() }), paramSheetFunctionsSelectToken.getParentLine(), 1);
      return null;
    }
    Iterator localIterator = paramSheetFunctionsSelectToken.getSelectedGroupFields();
    if (localIterator != null)
      while (localIterator.hasNext())
      {
        SheetFieldsSelectToken localSheetFieldsSelectToken = (SheetFieldsSelectToken)localIterator.next();
        List localList = localSheetFieldsSelectToken.getSelectedElements();
        for (int i = 0; i < localList.size(); i++)
        {
          if (paramSheetFunctionsSelectToken.exitsSelectField((IBusinessObject)localList.get(i)))
            continue;
          a(a("sheetSumFieldExits", new String[] { ((IBusinessObject)localList.get(i)).getDisplayName() }), paramSheetFunctionsSelectToken.getParentLine(), 1);
          return null;
        }
      }
    return super.visitSheetFunctionsSelectToken(paramSheetFunctionsSelectToken);
  }

  public Object visitSheetFunction(SheetFunction paramSheetFunction)
  {
    if (paramSheetFunction.getField() == null)
    {
      a(a("sheetFunctionSelectExits", new String[] { paramSheetFunction.getFieldUnique() }), paramSheetFunction.getParentLine(), 1);
      return null;
    }
    if ((paramSheetFunction.getParent() instanceof SheetFunctionsSelectToken))
    {
      String[] arrayOfString = ((SheetFunctionsSelectToken)paramSheetFunction.getParent()).getAsNameSelects();
      for (int i = 0; i < arrayOfString.length; i++)
        if (arrayOfString[i].equals(paramSheetFunction.getAsName()))
          return null;
      a(a("asnameNotExits", new String[] { paramSheetFunction.getAsName() }), paramSheetFunction.getParentLine(), 1);
    }
    return null;
  }

  public Object visitSheetAndFieldsSelectToken(SheetAndFieldsSelectToken paramSheetAndFieldsSelectToken)
  {
    if (paramSheetAndFieldsSelectToken.getMemberElement() == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetAndFieldsSelectToken.getUniqueName() }), paramSheetAndFieldsSelectToken.getParentLine(), 1);
      return null;
    }
    if (paramSheetAndFieldsSelectToken.getSourceSheet() == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetAndFieldsSelectToken.getSheetUnique() }), paramSheetAndFieldsSelectToken.getParentLine(), 1);
      return null;
    }
    return super.visitSheetAndFieldsSelectToken(paramSheetAndFieldsSelectToken);
  }

  public Object visitSheetAndWheresSelectToken(SheetAndWheresSelectToken paramSheetAndWheresSelectToken)
  {
    if (paramSheetAndWheresSelectToken.getMemberElement() == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetAndWheresSelectToken.getUniqueName() }), paramSheetAndWheresSelectToken.getParentLine(), 1);
      return null;
    }
    if (paramSheetAndWheresSelectToken.getSourceSheet() == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetAndWheresSelectToken.getSheetUnique() }), paramSheetAndWheresSelectToken.getParentLine(), 1);
      return null;
    }
    return super.visitSheetAndWheresSelectToken(paramSheetAndWheresSelectToken);
  }

  public Object visitSheetFieldMapping(SheetFieldMapping paramSheetFieldMapping)
  {
    if (paramSheetFieldMapping.getField() == null)
    {
      a(a("sheetFieldSelectExits", new String[] { paramSheetFieldMapping.getFieldUnique() }), paramSheetFieldMapping.getParentLine(), 1);
      return null;
    }
    if (paramSheetFieldMapping.getMappingField() == null)
    {
      a(a("sheetFieldMappingSelectExits", new String[] { paramSheetFieldMapping.getMappingUnique() }), paramSheetFieldMapping.getParentLine(), 1);
      return null;
    }
    if (((paramSheetFieldMapping.getParent() instanceof ISheetSelectEditen)) && (((ISheetSelectEditen)paramSheetFieldMapping.getParent()).getSourceSheet() != null) && (!paramSheetFieldMapping.getMappingField().getParent().equals(((ISheetSelectEditen)paramSheetFieldMapping.getParent()).getSourceSheet())))
    {
      a(a("sheetFieldMappingParentExits", new String[] { paramSheetFieldMapping.getMappingField().getDisplayName(), String.valueOf(((ISheetSelectEditen)paramSheetFieldMapping.getParent()).getSourceSheet().getDisplayName()) }), paramSheetFieldMapping.getParentLine(), 1);
      return null;
    }
    if (!paramSheetFieldMapping.getField().getJavaType().a(paramSheetFieldMapping.getMappingField().getJavaType()))
    {
      a(a("sheetFieldMappingType", new String[] { paramSheetFieldMapping.getField().getDisplayName(), paramSheetFieldMapping.getMappingField().getDisplayName() }), paramSheetFieldMapping.getParentLine(), 1);
      return null;
    }
    return super.visitSheetFieldMapping(paramSheetFieldMapping);
  }

  public Object visitSheetWhere(SheetWhere paramSheetWhere)
  {
    if (paramSheetWhere.getField() == null)
    {
      a(a("sheetWhereSelectExits", new String[] { paramSheetWhere.getFieldUnique() }), paramSheetWhere.getParentLine(), 1);
      return null;
    }
    if (!paramSheetWhere.getField().getJavaType().a(paramSheetWhere.getField().getJavaType()))
    {
      a(a("sheetFieldMappingType", new String[] { paramSheetWhere.getField().getDisplayName(), paramSheetWhere.getField().getDisplayName() }), paramSheetWhere.getParentLine(), 1);
      return null;
    }
    return super.visitSheetWhere(paramSheetWhere);
  }

  public Object visitSheetWheresSelectToken(SheetWheresSelectToken paramSheetWheresSelectToken)
  {
    if (paramSheetWheresSelectToken.getMemberElement() == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetWheresSelectToken.getUniqueName() }), paramSheetWheresSelectToken.getParentLine(), 1);
      return null;
    }
    return super.visitSheetWheresSelectToken(paramSheetWheresSelectToken);
  }

  public Object visitRuleMirror(RuleMirror paramRuleMirror)
  {
    if (paramRuleMirror.getMemberElement() == null)
    {
      a(a("memberExits", new String[] { paramRuleMirror.getDisplayName() }), paramRuleMirror, 1);
      return null;
    }
    return null;
  }

  public Object visitConditionToken(ConditionToken paramConditionToken)
  {
    if (paramConditionToken.getFirstValue() == null)
      a(a("conditionEmpty", "no field Token"), paramConditionToken.getParentLine(), 0);
    else
      paramConditionToken.getFirstValue().acceptVisitor(this);
    if (paramConditionToken.getComparedValue() != null)
      paramConditionToken.getComparedValue().acceptVisitor(this);
    if (paramConditionToken.getCompareOperator() != null)
    {
      if (paramConditionToken.getCompareOperator().getType() == -1)
        a(a("judgeEmpty", "must input the judge type"), paramConditionToken, 1);
      if (!paramConditionToken.getCompareOperator().acceptType(paramConditionToken.getFirstValue().getJavaType()))
        a(a("judgeType", "value type is error"), paramConditionToken, 1);
      if (paramConditionToken.getComparedValue() != null)
      {
        if ((!paramConditionToken.getFirstValue().getJavaType().a(paramConditionToken.getComparedValue().getJavaType(), true)) && ((!paramConditionToken.getFirstValue().getJavaType().b()) || (!paramConditionToken.getComparedValue().getValueElement().getJavaType().b())))
          a(a("conditionValueType", new String[] { paramConditionToken.getFirstValue().getDisplayName(), paramConditionToken.getFirstValue().getValueType(), paramConditionToken.getComparedValue().getDisplayName(), paramConditionToken.getComparedValue().getValueType() }), paramConditionToken, 1);
        paramConditionToken.getComparedValue().acceptVisitor(this);
      }
      else if ((!paramConditionToken.getFirstValue().getJavaType().e()) && (!paramConditionToken.getFirstValue().getJavaType().m()) && (!paramConditionToken.getFirstValue().getJavaType().p()) && (!paramConditionToken.getFirstValue().getJavaType().z()))
      {
        a(a("conditionValueEmpty", "no value token "), paramConditionToken, 1);
      }
    }
    else
    {
      a(a("judgeEmpty", "no judge in the condition"), paramConditionToken, 1);
    }
    return null;
  }

  public Object visitConstantSelectToken(ConstantSelectToken paramConstantSelectToken)
  {
    if ((!paramConstantSelectToken.getDisplayName().equals(u.a("rulename.text"))) && (!paramConstantSelectToken.getDisplayName().equals(u.a("rulepackagename.text"))) && (!paramConstantSelectToken.getDisplayName().equals(u.a("rulepackagedisname.text"))) && (!paramConstantSelectToken.getDisplayName().equals(u.a("ruleversion.text"))) && (!paramConstantSelectToken.getDisplayName().equals(u.a("traceRules.text"))) && (!paramConstantSelectToken.getDisplayName().equals(u.a("loginuser.text"))) && (!paramConstantSelectToken.getDisplayName().equals(u.a("ruleinputparameter.text"))) && (!paramConstantSelectToken.getDisplayName().equals(u.a("ruleoutputparameter.text"))) && (!paramConstantSelectToken.getDisplayName().equals(u.a("ruleinoutparameter.text"))) && (!paramConstantSelectToken.getDisplayName().equals(u.a("rulein.text"))) && (!paramConstantSelectToken.getDisplayName().equals(u.a("ruleout.text"))) && (!paramConstantSelectToken.getDisplayName().equals(u.a("ruleinout.text"))) && (paramConstantSelectToken.getConstantMember() == null))
      a(a("constantEmpty", "the object is not exits in the BOM."), paramConstantSelectToken.getParentLine(), 1);
    return super.visitConstantSelectToken(paramConstantSelectToken);
  }

  public Object visitAssignToken(AssignToken paramAssignToken)
  {
    if (paramAssignToken.getFirstValue() == null)
    {
      a(a("assignEmpty", "no field Token"), paramAssignToken.getParentLine(), 0);
      return null;
    }
    paramAssignToken.getFirstValue().acceptVisitor(this);
    if (paramAssignToken.getComparedValue() != null)
    {
      if (!paramAssignToken.getFirstValue().getJavaType().a(paramAssignToken.getComparedValue().getJavaType(), true))
        a(a("assignMatch", new String[] { paramAssignToken.getFirstValue().getDisplayName(), paramAssignToken.getFirstValue().getValueType(), paramAssignToken.getComparedValue().getDisplayName(), paramAssignToken.getComparedValue().getValueType() }), paramAssignToken, 1);
      paramAssignToken.getComparedValue().acceptVisitor(this);
    }
    else
    {
      a(a("assignValue", "no value token "), paramAssignToken.getParentLine(), 1);
    }
    return null;
  }

  public Object visitNewToken(NewToken paramNewToken)
  {
    if (paramNewToken.getMemberElement() == null)
      a(a("newEmpty", "the object is not exits in the BOM."), paramNewToken.getParentLine(), 1);
    return super.visitNewToken(paramNewToken);
  }

  public Object visitReturnToken(ReturnToken paramReturnToken)
  {
    return null;
  }

  public Object visitExeRuleToken(ExeRuleToken paramExeRuleToken)
  {
    if (paramExeRuleToken.getRuleNameToken() == null)
    {
      a(a("ruleSetExist", "the rule set is not exits ."), paramExeRuleToken, 1);
      return null;
    }
    paramExeRuleToken.getRuleNameToken().acceptVisitor(this);
    return null;
  }

  public Object visitThrowToken(ThrowToken paramThrowToken)
  {
    paramThrowToken.getErrorValue().acceptVisitor(this);
    return null;
  }

  public Object visitClassToken(ClassToken paramClassToken)
  {
    if (paramClassToken.getMemberElement() == null)
      a(a("fieldExist", "the object is not exits in the BOM."), paramClassToken.getParentLine(), 1);
    return null;
  }

  public Object visitFunctionMember(FunctionMember paramFunctionMember)
  {
    try
    {
      paramFunctionMember.parse();
    }
    catch (m localm)
    {
      a(localm.getMessage(), paramFunctionMember.getCustomFunction(), 1);
    }
    return null;
  }

  public Object visitActionToken(StatementContainerToken paramStatementContainerToken)
  {
    if (paramStatementContainerToken.getStatement() == null)
      a(a("actionEmpty", "no action in the action container."), paramStatementContainerToken.getParentLine(), 2);
    return super.visitActionToken(paramStatementContainerToken);
  }

  public Object visitConstantToken(ConstantToken paramConstantToken)
  {
    if ((paramConstantToken.getValue().length() == 0) && (paramConstantToken.getJavaType().f()))
      a(a("constantInput", "value is empty."), paramConstantToken.getParentLine(), 1);
    else if ((paramConstantToken.getJavaType().b()) || (paramConstantToken.getJavaType().j()))
    {
      if (paramConstantToken.getValue().length() > 0)
        try
        {
          String str = paramConstantToken.getValue();
          if (paramConstantToken.getJavaType().c())
            str = NumberUtil.parseNumber(paramConstantToken.getValue(), true);
          else if (paramConstantToken.getJavaType().h())
            str = NumberUtil.parseNumber(paramConstantToken.getValue(), false);
          else if (paramConstantToken.getJavaType().i())
            str = NumberUtil.parseNumber(paramConstantToken.getValue(), true);
          else if (paramConstantToken.getJavaType().j())
            str = NumberUtil.parseNumber(paramConstantToken.getValue(), true);
          else
            str = NumberUtil.parseNumber(paramConstantToken.getValue(), false);
          for (int i = 0; i < str.length(); i++)
          {
            if (a(str.charAt(i)))
              continue;
            a(a("constantNumberType", new Object[] { paramConstantToken.getValue() }), paramConstantToken.getParentLine(), 1);
            break;
          }
        }
        catch (Exception localException1)
        {
          a(a("constantNumberType", new Object[] { paramConstantToken.getValue() }), paramConstantToken.getParentLine(), 1);
        }
    }
    else if (paramConstantToken.getValue().length() > 0)
      try
      {
        if (paramConstantToken.getJavaType().v())
          DateUtil.formatDate(paramConstantToken.getValue());
        else if (paramConstantToken.getJavaType().w())
          DateUtil.formatTime(paramConstantToken.getValue());
        else if (paramConstantToken.getJavaType().x())
          DateUtil.formatDatetime(paramConstantToken.getValue());
      }
      catch (Exception localException2)
      {
        a(a("constantDateType", "must input date ."), paramConstantToken.getParentLine(), 1);
      }
    return super.visitConstantToken(paramConstantToken);
  }

  private boolean a(char paramChar)
  {
    return (Character.isLetterOrDigit(paramChar)) || (paramChar == '/') || (paramChar == '%') || (paramChar == '*') || (paramChar == '+') || (paramChar == '-') || (paramChar == '.');
  }

  public Object visitJavaStatementToken(JavaStatementToken paramJavaStatementToken)
  {
    return null;
  }

  public Object visitFieldToken(FieldToken paramFieldToken)
  {
    return visitMemberToken(paramFieldToken);
  }

  public Object visitGotoRuleToken(GotoRuleToken paramGotoRuleToken)
  {
    if (paramGotoRuleToken.getMemberElement() == null)
      a(a("ruleSetExist", "the ruleSet is not exits ."), paramGotoRuleToken.getParentLine(), 1);
    return super.visitGotoRuleToken(paramGotoRuleToken);
  }

  public Object visitJudgeToken(JudgeToken paramJudgeToken)
  {
    if (paramJudgeToken.getType() == -1)
      a(a("judgeSelect", "the judge select is empty."), paramJudgeToken.getParentLine(), 1);
    return super.visitJudgeToken(paramJudgeToken);
  }

  private boolean d(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return false;
    if (!Character.isJavaIdentifierStart(paramString.charAt(0)))
      return false;
    for (int i = 1; i < paramString.length(); i++)
      if (!Character.isJavaIdentifierPart(paramString.charAt(i)))
        return false;
    return true;
  }

  public Object visitEnvionment(Envionment paramEnvionment)
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("dtcObjects", "dtcObjects");
    localHashMap1.put("class_objects", "class_objects");
    localHashMap1.put("out", "OutputStream");
    localHashMap1.put("ruleLog", "RuleLog");
    localHashMap1.put("rootRuleLog", "rootRuleLog");
    localHashMap1.put("snapShot", "snapShot");
    HashMap localHashMap2 = new HashMap();
    localHashMap2.putAll(localHashMap1);
    Iterator localIterator1 = paramEnvionment.getClassContainers();
    while (localIterator1.hasNext())
    {
      localObject1 = localIterator1.next();
      if (!(localObject1 instanceof ClassContainer))
        continue;
      localObject2 = ((ClassContainer)localObject1).getVarValue();
      if (!d((String)localObject2))
        a(a("varnameformat", new String[] { localObject2 }), (ClassContainer)localObject1, 1);
      if (localHashMap1.get(localObject2) != null)
        a(a("duplicate", new String[] { localObject2 }), (ClassContainer)localObject1, 1);
      localHashMap1.put(localObject2, localObject2);
    }
    localIterator1 = paramEnvionment.getInterfaceContainers();
    while (localIterator1.hasNext())
    {
      localObject1 = localIterator1.next();
      if (!(localObject1 instanceof InterfaceContainer))
        continue;
      localObject2 = ((InterfaceContainer)localObject1).getVarValue();
      if (!d((String)localObject2))
        a(a("varnameformat", new String[] { localObject2 }), (InterfaceContainer)localObject1, 1);
      if (localHashMap1.get(localObject2) != null)
        a(a("duplicate", new String[] { localObject2 }), (InterfaceContainer)localObject1, 1);
      localHashMap1.put(localObject2, localObject2);
    }
    localIterator1 = paramEnvionment.getValueLibrary().getChildrenIterator();
    while (localIterator1.hasNext())
    {
      localObject1 = localIterator1.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      localObject3 = ((IVariableObject)localObject2).getVarValue();
      if (!d((String)localObject3))
        a(a("varnameformat", new String[] { localObject3 }), (BusinessObjectClass)localObject1, 1);
      if (localHashMap1.get(localObject3) != null)
        a(a("duplicate", new String[] { localObject3 }), (IElement)localObject2, 1);
      localHashMap1.put(localObject3, localObject3);
      localObject3 = ((IVariableObject)localObject2).getValueName();
      if (localHashMap2.get(localObject3) != null)
        a(a("duplicate", new String[] { localObject3 }), (IElement)localObject2, 1);
      localHashMap2.put(localObject3, localObject3);
    }
    localIterator1 = paramEnvionment.getTempVariableLibrary().getChildrenIterator();
    while (localIterator1.hasNext())
    {
      localObject1 = localIterator1.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      localObject3 = ((IVariableObject)localObject2).getVarValue();
      if (!d((String)localObject3))
        a(a("varnameformat", new String[] { localObject3 }), (IElement)localObject2, 1);
      if (localHashMap1.get(localObject3) != null)
        a(a("duplicate", new String[] { localObject3 }), (IElement)localObject2, 1);
      localHashMap1.put(localObject3, localObject3);
      localObject3 = ((IVariableObject)localObject2).getValueName();
      if (localHashMap2.get(localObject3) != null)
        a(a("duplicate", new String[] { localObject3 }), (IElement)localObject2, 1);
      localHashMap2.put(localObject3, localObject3);
    }
    Object localObject1 = paramEnvionment.getEnvionment().getAcceptElements(new i(this));
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IBusinessObject)((Iterator)localObject1).next();
      localObject3 = ((IBusinessObject)localObject2).getVarValue();
      if (!d((String)localObject3))
        a(a("varnameformat", new String[] { localObject3 }), (IElement)localObject2, 1);
      if (localHashMap1.get(localObject3) != null)
        a(a("duplicate", new String[] { localObject3 }), (IElement)localObject2, 1);
      localHashMap1.put(localObject3, localObject3);
      localObject3 = ((IBusinessObject)localObject2).getValueName();
      if (localHashMap2.get(localObject3) != null)
        a(a("duplicate", new String[] { localObject3 }), (IElement)localObject2, 1);
      localHashMap2.put(localObject3, localObject3);
      ((IBusinessObject)localObject2).acceptVisitor(this);
    }
    Object localObject2 = paramEnvionment.getDBModels();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (DBModel)((Iterator)localObject2).next();
      localObject4 = ((DBModel)localObject3).getVarName();
      if (!d((String)localObject4))
        a(a("varnameformat", new String[] { localObject4 }), (IElement)localObject3, 1);
      if (localHashMap1.get(localObject4) != null)
        a(a("duplicate", new String[] { localObject4 }), (IElement)localObject3, 1);
      localObject4 = ((DBModel)localObject3).getValueName();
      if (localHashMap2.get(localObject4) != null)
        a(a("duplicate", new String[] { localObject4 }), (IElement)localObject3, 1);
      localObject5 = ((DBModel)localObject3).getTypeSuperChildren(IBOAndContainer.class);
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (IBOAndContainer)((Iterator)localObject5).next();
        localObject4 = ((IBOAndContainer)localObject6).getVarValue();
        if (!d((String)localObject4))
          a(a("varnameformat", new String[] { localObject4 }), (IElement)localObject6, 1);
        if (localHashMap1.get(localObject4) != null)
          a(a("duplicate", new String[] { localObject4 }), (IElement)localObject6, 1);
        localHashMap1.put(localObject4, localObject4);
        localObject4 = ((IBOAndContainer)localObject6).getValueName();
        if (localHashMap2.get(localObject4) != null)
          a(a("duplicate", new String[] { localObject4 }), (IElement)localObject6, 1);
        localHashMap2.put(localObject4, localObject4);
        ((IBOAndContainer)localObject6).acceptVisitor(this);
      }
    }
    localObject2 = paramEnvionment.getDBModels();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (DBModel)((Iterator)localObject2).next();
      localHashMap1.put(((DBModel)localObject3).getVarName(), ((DBModel)localObject3).getVarName());
      localHashMap2.put(((DBModel)localObject3).getValueName(), ((DBModel)localObject3).getValueName());
      ((DBModel)localObject3).acceptVisitor(this);
    }
    localObject2 = paramEnvionment.getExcelBookModels();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ExcelBookModel)((Iterator)localObject2).next();
      localObject4 = ((ExcelBookModel)localObject3).getVarValue();
      if (!d((String)localObject4))
        a(a("varnameformat", new String[] { localObject4 }), (IElement)localObject3, 1);
      if (localHashMap1.get(localObject4) != null)
        a(a("duplicate", new String[] { localObject4 }), (IElement)localObject3, 1);
      localHashMap1.put(((ExcelBookModel)localObject3).getVarValue(), ((ExcelBookModel)localObject3).getVarValue());
      localObject4 = ((ExcelBookModel)localObject3).getValueName();
      if (localHashMap2.get(localObject4) != null)
        a(a("duplicate", new String[] { localObject4 }), (IElement)localObject3, 1);
      localHashMap2.put(localObject4, localObject4);
      localObject5 = ((ExcelBookModel)localObject3).getTypeSuperChildren(IExcelObject.class);
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (IExcelObject)((Iterator)localObject5).next();
        localObject4 = ((IExcelObject)localObject6).getVarValue();
        if (!d((String)localObject4))
          a(a("varnameformat", new String[] { localObject4 }), (IElement)localObject6, 1);
        if (localHashMap1.get(localObject4) != null)
          a(a("duplicate", new String[] { localObject4 }), (IElement)localObject6, 1);
        localHashMap1.put(localObject4, localObject4);
        localObject4 = ((IExcelObject)localObject6).getValueName();
        if (localHashMap2.get(localObject4) != null)
          a(a("duplicate", new String[] { localObject4 }), (IElement)localObject6, 1);
        localHashMap2.put(localObject4, localObject4);
      }
    }
    Object localObject3 = paramEnvionment.getXmlNodes();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (XmlNode)((Iterator)localObject3).next();
      localObject5 = ((XmlNode)localObject4).getVarName();
      if (!d((String)localObject5))
        a(a("varnameformat", new String[] { localObject5 }), (IElement)localObject4, 1);
      if (localHashMap1.get(localObject5) != null)
        a(a("duplicate", new String[] { localObject5 }), (IElement)localObject4, 1);
      localHashMap1.put(localObject5, localObject5);
      localObject5 = ((XmlNode)localObject4).getValueName();
      if (localHashMap2.get(localObject5) != null)
        a(a("duplicate", new String[] { localObject5 }), (IElement)localObject4, 1);
      localHashMap2.put(localObject5, localObject5);
      ((XmlNode)localObject4).acceptVisitor(this);
    }
    Object localObject4 = paramEnvionment.getTreeNodes();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (TreeValueNode)((Iterator)localObject4).next();
      localObject6 = ((TreeValueNode)localObject5).getVarName();
      if (!d((String)localObject6))
        a(a("varnameformat", new String[] { localObject6 }), (IElement)localObject5, 1);
      if (localHashMap1.get(localObject6) != null)
        a(a("duplicate", new String[] { localObject6 }), (IElement)localObject5, 1);
      localHashMap1.put(localObject6, localObject6);
      localObject6 = ((TreeValueNode)localObject5).getValueName();
      if (localHashMap2.get(localObject6) != null)
        a(a("duplicate", new String[] { localObject6 }), (IElement)localObject5, 1);
      localHashMap2.put(localObject6, localObject6);
      ((TreeValueNode)localObject5).acceptVisitor(this);
    }
    Object localObject5 = paramEnvionment.getSoapServices();
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (SoapService)((Iterator)localObject5).next();
      localObject7 = ((SoapService)localObject6).getVarName();
      if (!d((String)localObject7))
        a(a("varnameformat", new String[] { localObject7 }), (IElement)localObject6, 1);
      if (localHashMap1.get(localObject7) != null)
        a(a("duplicate", new String[] { localObject7 }), (IElement)localObject6, 1);
      localHashMap1.put(localObject7, localObject7);
      localObject7 = ((SoapService)localObject6).getValueName();
      if (localHashMap2.get(localObject7) != null)
        a(a("duplicate", new String[] { localObject7 }), (IElement)localObject6, 1);
      localHashMap2.put(localObject7, localObject7);
    }
    Object localObject6 = paramEnvionment.getChildrenIterator();
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = ((Iterator)localObject6).next();
      if (!(localObject7 instanceof IRuleTree))
        continue;
      ((IRuleTree)localObject7).acceptVisitor(this);
    }
    Object localObject7 = new HashMap();
    Iterator localIterator2 = paramEnvionment.getChildrenIterator();
    while (localIterator2.hasNext())
    {
      IElement localIElement = (IElement)localIterator2.next();
      if (!(localIElement instanceof ITreeNode))
        continue;
      if (((HashMap)localObject7).get(localIElement.getDisplayName()) == null)
        ((HashMap)localObject7).put(localIElement.getDisplayName(), localIElement.getDisplayName());
      else
        a(a("samerulename", new String[] { localIElement.getDisplayName() }), paramEnvionment, 0);
    }
    ((HashMap)localObject7).clear();
    return null;
  }

  public Object visitSheetDynamicSelectToken(SheetDynamicSelectToken paramSheetDynamicSelectToken)
  {
    if (paramSheetDynamicSelectToken.getMemberElement() == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetDynamicSelectToken.getUniqueName() }), paramSheetDynamicSelectToken.getParentLine(), 1);
      return null;
    }
    if (paramSheetDynamicSelectToken.getSourceSheet() == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetDynamicSelectToken.getSheetUnique() }), paramSheetDynamicSelectToken.getParentLine(), 1);
      return null;
    }
    if (paramSheetDynamicSelectToken.getSheetField() == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetDynamicSelectToken.getSheetUnique() }), paramSheetDynamicSelectToken.getParentLine(), 1);
      return null;
    }
    if (paramSheetDynamicSelectToken.getSheetValue() == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetDynamicSelectToken.getSheetUnique() }), paramSheetDynamicSelectToken.getParentLine(), 1);
      return null;
    }
    return super.visitSheetDynamicSelectToken(paramSheetDynamicSelectToken);
  }

  public Object visitTreeAttribute(TreeAttribute paramTreeAttribute)
  {
    if (!b(paramTreeAttribute.getValueName()))
      a(a("varnameformat", new String[] { paramTreeAttribute.getValueName() }), paramTreeAttribute.getParent(), 1);
    if (!a(paramTreeAttribute.getDisplayName()))
      a(a("varnameformat", new String[] { paramTreeAttribute.getDisplayName() }), paramTreeAttribute.getParent(), 1);
    return super.visitTreeAttribute(paramTreeAttribute);
  }

  public Object visitTreeNode(TreeValueNode paramTreeValueNode)
  {
    if (!b(paramTreeValueNode.getValueName()))
      a(a("varnameformat", new String[] { paramTreeValueNode.getValueName() }), paramTreeValueNode, 1);
    if (!a(paramTreeValueNode.getDisplayName()))
      a(a("varnameformat", new String[] { paramTreeValueNode.getDisplayName() }), paramTreeValueNode, 1);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramTreeValueNode.getChildrenIterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if (!(localIElement instanceof ITreeNode))
        continue;
      if (localHashMap.get(localIElement.getDisplayName()) == null)
        localHashMap.put(localIElement.getDisplayName(), localIElement.getDisplayName());
      else
        a(a("samerulename", new String[] { localIElement.getDisplayName() }), paramTreeValueNode, 0);
    }
    localHashMap.clear();
    return super.visitTreeNode(paramTreeValueNode);
  }

  public Object visitXmlAttribute(XmlAttribute paramXmlAttribute)
  {
    if (!b(paramXmlAttribute.getValueName()))
      a(a("varnameformat", new String[] { paramXmlAttribute.getValueName() }), paramXmlAttribute.getParent(), 1);
    return super.visitXmlAttribute(paramXmlAttribute);
  }

  public Object visitXmlNode(XmlNode paramXmlNode)
  {
    if (!b(paramXmlNode.getValueName()))
      a(a("varnameformat", new String[] { paramXmlNode.getValueName() }), paramXmlNode, 1);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramXmlNode.getChildrenIterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if (!(localIElement instanceof ITreeNode))
        continue;
      if (localHashMap.get(localIElement.getDisplayName()) == null)
        localHashMap.put(localIElement.getDisplayName(), localIElement.getDisplayName());
      else
        a(a("samerulename", new String[] { localIElement.getDisplayName() }), paramXmlNode, 0);
    }
    localHashMap.clear();
    return super.visitXmlNode(paramXmlNode);
  }

  protected boolean a(String paramString)
  {
    for (int i = 0; i < paramString.length(); i++)
    {
      int j = paramString.charAt(i);
      switch (j)
      {
      case 34:
      case 44:
      case 46:
      case 58:
      case 59:
      case 92:
        return false;
      }
    }
    return true;
  }

  protected boolean b(String paramString)
  {
    for (int i = 0; i < paramString.length(); i++)
    {
      int j = paramString.charAt(i);
      switch (j)
      {
      case 32:
      case 34:
      case 37:
      case 38:
      case 40:
      case 41:
      case 44:
      case 46:
      case 47:
      case 58:
      case 59:
      case 60:
      case 62:
      case 63:
      case 91:
      case 92:
      case 93:
      case 12289:
      case 12290:
      case 65311:
        return false;
      }
    }
    return true;
  }

  private boolean a(IBusinessObject paramIBusinessObject, IElement paramIElement)
  {
    int i = 0;
    List localList1;
    List localList2;
    int j;
    if ((paramIBusinessObject instanceof TreeValueNode))
    {
      if ((paramIElement instanceof TreeValueNode))
      {
        localList1 = ((TreeValueNode)paramIBusinessObject).getFields();
        localList2 = ((TreeValueNode)paramIElement).getFields();
        if (localList1.size() != localList2.size())
          return false;
        for (j = 0; j < localList1.size(); j++)
          if (((localList1.get(j) instanceof TreeAttribute)) && ((!(localList2.get(j) instanceof TreeAttribute)) || (!((TreeAttribute)localList1.get(j)).getKey().equals(((TreeAttribute)localList2.get(j)).getKey()))))
            return false;
        localList1 = ((TreeValueNode)paramIBusinessObject).getAllNodes();
        localList2 = ((TreeValueNode)paramIElement).getAllNodes();
        if (localList1.size() != localList2.size())
          return false;
        for (j = 0; j < localList1.size(); j++)
        {
          if (!(localList1.get(j) instanceof TreeValueNode))
            continue;
          if ((localList2.get(j) instanceof TreeValueNode))
          {
            if (!a((TreeValueNode)localList1.get(j), (TreeValueNode)localList2.get(j)))
              return false;
          }
          else
            return false;
        }
      }
      else
      {
        return false;
      }
    }
    else if ((paramIBusinessObject instanceof SheetTable))
      if ((paramIElement instanceof SheetTable))
      {
        localList1 = ((SheetTable)paramIBusinessObject).getFields();
        localList2 = ((SheetTable)paramIElement).getFields();
        if (localList1.size() != localList2.size())
          return false;
        for (j = 0; j < localList1.size(); j++)
          if (((localList1.get(j) instanceof SheetFieldModel)) && ((!(localList2.get(j) instanceof SheetFieldModel)) || (!((SheetFieldModel)localList1.get(j)).getValueName().equals(((SheetFieldModel)localList2.get(j)).getValueName()))))
            return false;
      }
      else
      {
        return false;
      }
    return true;
  }

  public Object visitSelectRulePackageToken(SelectRulePackageToken paramSelectRulePackageToken)
  {
    if (paramSelectRulePackageToken.getExeRuleName().length() == 0)
    {
      a(a("ruleSetExist", "the rule set is not exits ."), paramSelectRulePackageToken, 1);
      return null;
    }
    IRuleClass localIRuleClass = paramSelectRulePackageToken.getSourceSheet();
    if (localIRuleClass != null)
    {
      List localList = paramSelectRulePackageToken.getCanSelectSourceFields();
      Iterator localIterator = paramSelectRulePackageToken.getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof AbstractPackageField))
          continue;
        AbstractPackageField localAbstractPackageField = (AbstractPackageField)localObject;
        IBusinessObject localIBusinessObject;
        if ((localAbstractPackageField.getNaryType().equalsIgnoreCase("com.flagleader.xml.TreeValue")) || (localAbstractPackageField.getNaryType().equalsIgnoreCase("com.flagleader.db.Sheet")))
        {
          i = 0;
          for (j = 0; j < localList.size(); j++)
          {
            localIBusinessObject = (IBusinessObject)localList.get(j);
            if ((!localIBusinessObject.getValueType().equals(localAbstractPackageField.getNaryType())) || (!localIBusinessObject.getDisplayName().equals(localAbstractPackageField.getDisplayName())))
              continue;
            if (!localIBusinessObject.getValueName().equals(localAbstractPackageField.getFuncName()))
            {
              localAbstractPackageField.setFuncName(localIBusinessObject.getValueName());
            }
            else if ((localAbstractPackageField instanceof PackageFieldGet))
            {
              if ((((PackageFieldGet)localAbstractPackageField).getAssignValue() != null) && ((((PackageFieldGet)localAbstractPackageField).getAssignValue().getValueElement() instanceof AbstractElementToken)) && (!a(localIBusinessObject, ((AbstractElementToken)((PackageFieldGet)localAbstractPackageField).getAssignValue().getValueElement()).getMemberElement())))
              {
                a(a("rulePackageTreeChanges", new String[] { paramSelectRulePackageToken.getShowRuleDisplay(), localAbstractPackageField.getDisplayName() }), paramSelectRulePackageToken, 1);
                return null;
              }
            }
            else if (((localAbstractPackageField instanceof PackageFieldSet)) && (((PackageFieldSet)localAbstractPackageField).getAssignValue() != null) && (!a(localIBusinessObject, ((PackageFieldSet)localAbstractPackageField).getAssignValue().getMemberElement())))
            {
              a(a("rulePackageTreeChanges", new String[] { paramSelectRulePackageToken.getShowRuleDisplay(), localAbstractPackageField.getDisplayName() }), paramSelectRulePackageToken, 1);
              return null;
            }
            i = 1;
            break;
          }
          if (i != 0)
            continue;
          a(a("rulePackageTreeExits", new String[] { paramSelectRulePackageToken.getShowRuleDisplay(), localAbstractPackageField.getDisplayName() }), paramSelectRulePackageToken, 1);
          return null;
        }
        int i = 0;
        for (int j = 0; j < localList.size(); j++)
        {
          localIBusinessObject = (IBusinessObject)localList.get(j);
          if ((!localIBusinessObject.getValueType().equals(localAbstractPackageField.getNaryType())) || (!localIBusinessObject.getValueName().equals(localAbstractPackageField.getFuncName())))
            continue;
          if (!localIBusinessObject.getDisplayName().equals(localAbstractPackageField.getDisplayName()))
            localAbstractPackageField.setDisplayName(localIBusinessObject.getDisplayName());
          i = 1;
          break;
        }
        if (i != 0)
          continue;
        a(a("rulePackageFieldExits", new String[] { paramSelectRulePackageToken.getShowRuleDisplay(), localAbstractPackageField.getFuncName(), localAbstractPackageField.getNaryType() }), paramSelectRulePackageToken, 1);
        return null;
      }
    }
    return super.visitSelectRulePackageToken(paramSelectRulePackageToken);
  }

  public Object visitPackageField(AbstractPackageField paramAbstractPackageField)
  {
    return super.visitPackageField(paramAbstractPackageField);
  }

  public Object visitDBModel(DBModel paramDBModel)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramDBModel.getChildrenIterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if (!(localIElement instanceof ITreeNode))
        continue;
      if (localHashMap.get(localIElement.getDisplayName()) == null)
        localHashMap.put(localIElement.getDisplayName(), localIElement.getDisplayName());
      else
        a(a("samerulename", new String[] { localIElement.getDisplayName() }), paramDBModel, 0);
    }
    localHashMap.clear();
    return null;
  }

  public Object visitRulePackage(RulePackage paramRulePackage)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramRulePackage.getChildrenIterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if (!(localIElement instanceof ITreeNode))
        continue;
      if (localHashMap.get(localIElement.getDisplayName()) == null)
        localHashMap.put(localIElement.getDisplayName(), localIElement.getDisplayName());
      else
        a(a("samerulename", new String[] { localIElement.getDisplayName() }), paramRulePackage, 0);
    }
    localHashMap.clear();
    return super.visitRulePackage(paramRulePackage);
  }

  public Object visitBOContainerGroup(BOContainerGroup paramBOContainerGroup)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBOContainerGroup.getChildrenIterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if (!(localIElement instanceof ITreeNode))
        continue;
      if (localHashMap.get(localIElement.getDisplayName()) == null)
        localHashMap.put(localIElement.getDisplayName(), localIElement.getDisplayName());
      else
        a(a("samerulename", new String[] { localIElement.getDisplayName() }), paramBOContainerGroup, 0);
    }
    localHashMap.clear();
    return null;
  }

  public Object visitSheetFentanSelectToken(SheetFentanSelectToken paramSheetFentanSelectToken)
  {
    if (paramSheetFentanSelectToken.getMemberElement() == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetFentanSelectToken.getUniqueName() }), paramSheetFentanSelectToken.getParentLine(), 1);
      return null;
    }
    if (paramSheetFentanSelectToken.getSourceSheet(true) == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetFentanSelectToken.getSheetUnique() }), paramSheetFentanSelectToken.getParentLine(), 1);
      return null;
    }
    if (paramSheetFentanSelectToken.getSourceSheet(false) == null)
    {
      a(a("sheetSelectExits", new String[] { paramSheetFentanSelectToken.getbSheetUnique() }), paramSheetFentanSelectToken.getParentLine(), 1);
      return null;
    }
    return super.visitSheetFentanSelectToken(paramSheetFentanSelectToken);
  }

  public Object visitSheetFentanMapping(SheetFentanMapping paramSheetFentanMapping)
  {
    if (paramSheetFentanMapping.getField() == null)
    {
      a(a("sheetFieldSelectExits", new String[] { paramSheetFentanMapping.getFieldUnique() }), paramSheetFentanMapping.getParentLine(), 1);
      return null;
    }
    if (paramSheetFentanMapping.getMappingField() == null)
    {
      a(a("sheetFieldMappingSelectExits", new String[] { paramSheetFentanMapping.getCfieldUnique() }), paramSheetFentanMapping.getParentLine(), 1);
      return null;
    }
    if (((paramSheetFentanMapping.getParent() instanceof ISheetFentanEditen)) && (((ISheetFentanEditen)paramSheetFentanMapping.getParent()).getSourceSheet(true) != null) && (!paramSheetFentanMapping.getField().getParent().equals(((ISheetFentanEditen)paramSheetFentanMapping.getParent()).getSourceSheet(true))))
    {
      a(a("sheetFieldMappingParentExits", new String[] { paramSheetFentanMapping.getField().getDisplayName(), String.valueOf(((ISheetFentanEditen)paramSheetFentanMapping.getParent()).getSourceSheet(true).getDisplayName()) }), paramSheetFentanMapping.getParentLine(), 1);
      return null;
    }
    if (((paramSheetFentanMapping.getParent() instanceof ISheetFentanEditen)) && (((ISheetFentanEditen)paramSheetFentanMapping.getParent()).getSourceSheet(false) != null) && (!paramSheetFentanMapping.getBField().getParent().equals(((ISheetFentanEditen)paramSheetFentanMapping.getParent()).getSourceSheet(false))))
    {
      a(a("sheetFieldMappingParentExits", new String[] { paramSheetFentanMapping.getBField().getDisplayName(), String.valueOf(((ISheetFentanEditen)paramSheetFentanMapping.getParent()).getSourceSheet(false).getDisplayName()) }), paramSheetFentanMapping.getParentLine(), 1);
      return null;
    }
    if (!paramSheetFentanMapping.getField().getJavaType().a(paramSheetFentanMapping.getMappingField().getJavaType()))
    {
      a(a("sheetFieldMappingType", new String[] { paramSheetFentanMapping.getField().getDisplayName(), paramSheetFentanMapping.getMappingField().getDisplayName() }), paramSheetFentanMapping.getParentLine(), 1);
      return null;
    }
    return super.visitSheetFentanMapping(paramSheetFentanMapping);
  }

  public Object visitSheetTable(SheetTable paramSheetTable)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator = paramSheetTable.getChildrenIterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if (!(localIElement instanceof SheetFieldModel))
        continue;
      if (localHashMap1.get(localIElement.getDisplayName()) == null)
        localHashMap1.put(localIElement.getDisplayName(), localIElement.getDisplayName());
      else
        a(a("samerulename", new String[] { localIElement.getDisplayName() }), paramSheetTable, 0);
      if (localHashMap2.get(((SheetFieldModel)localIElement).getFieldName()) == null)
        localHashMap2.put(((SheetFieldModel)localIElement).getFieldName(), ((SheetFieldModel)localIElement).getFieldName());
      else
        a(a("samerulename", new String[] { ((SheetFieldModel)localIElement).getFieldName() }), paramSheetTable, 0);
    }
    localHashMap1.clear();
    localHashMap2.clear();
    return super.visitSheetTable(paramSheetTable);
  }

  public Object visitMapValue(MapValue paramMapValue)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator = paramMapValue.getChildrenIterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if (!(localIElement instanceof MapValue))
        continue;
      if (localHashMap1.get(localIElement.getDisplayName()) == null)
        localHashMap1.put(localIElement.getDisplayName(), localIElement.getDisplayName());
      else
        a(a("samerulename", new String[] { localIElement.getDisplayName() }), paramMapValue, 0);
      if (localHashMap2.get(((MapValue)localIElement).getKey()) == null)
        localHashMap2.put(((MapValue)localIElement).getKey(), ((MapValue)localIElement).getKey());
      else
        a(a("samerulename", new String[] { ((MapValue)localIElement).getKey() }), paramMapValue, 0);
    }
    localHashMap1.clear();
    localHashMap2.clear();
    return super.visitMapValue(paramMapValue);
  }

  public Object visitRuleEnterToken(RuleEnterToken paramRuleEnterToken)
  {
    return super.visitRuleEnterToken(paramRuleEnterToken);
  }

  public Object visitDecisionRelateAction(DecisionRelateAction paramDecisionRelateAction)
  {
    if ((!paramDecisionRelateAction.isEmpty()) && (paramDecisionRelateAction.isValid()))
      return super.visitDecisionRelateAction(paramDecisionRelateAction);
    return null;
  }

  public Object visitExcelBookModel(ExcelBookModel paramExcelBookModel)
  {
    return super.visitExcelBookModel(paramExcelBookModel);
  }

  public Object visitForEachConditionToken(ForEachConditionToken paramForEachConditionToken)
  {
    if (paramForEachConditionToken.getFirstToken() == null)
      a(a("conditionEmpty", "no field Token"), paramForEachConditionToken, 0);
    else
      paramForEachConditionToken.getFirstToken().acceptVisitor(this);
    if (paramForEachConditionToken.getReturnType() == 0)
    {
      paramForEachConditionToken.getRuleVersionToken("first").acceptVisitor(this);
      paramForEachConditionToken.getRuleVersionToken("last").acceptVisitor(this);
    }
    else if (paramForEachConditionToken.getReturnType() == 1)
    {
      paramForEachConditionToken.getRuleVersionToken("first").acceptVisitor(this);
      paramForEachConditionToken.getRuleVersionToken("last").acceptVisitor(this);
    }
    else if (paramForEachConditionToken.getReturnType() == 2)
    {
      paramForEachConditionToken.getRuleVersionToken("array").acceptVisitor(this);
    }
    else if (paramForEachConditionToken.getReturnType() == 3)
    {
      paramForEachConditionToken.getRuleVersionToken("list").acceptVisitor(this);
    }
    else if (paramForEachConditionToken.getReturnType() == 3)
    {
      if (paramForEachConditionToken.getSecondToken() == null)
        a(a("conditionEmpty", "no field Token"), paramForEachConditionToken, 0);
      else
        paramForEachConditionToken.getSecondToken().acceptVisitor(this);
      paramForEachConditionToken.getRuleVersionToken("map").acceptVisitor(this);
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.h
 * JD-Core Version:    0.6.0
 */