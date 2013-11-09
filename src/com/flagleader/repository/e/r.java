package com.flagleader.repository.e;

import com.flagleader.repository.IElement;
import com.flagleader.repository.d.u;
import com.flagleader.repository.flow.RulePoolValue;
import com.flagleader.repository.rlm.AbstractRuleContainer;
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
import com.flagleader.repository.rlm.action.GotoRuleToken;
import com.flagleader.repository.rlm.action.JavaStatementToken;
import com.flagleader.repository.rlm.action.MethodToken;
import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.action.PackageFieldGet;
import com.flagleader.repository.rlm.action.PackageFieldSet;
import com.flagleader.repository.rlm.action.ReturnToken;
import com.flagleader.repository.rlm.action.SelectRulePackageToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.condition.ConditionToken;
import com.flagleader.repository.rlm.condition.ForEachConditionToken;
import com.flagleader.repository.rlm.condition.MultiConditionToken;
import com.flagleader.repository.rlm.editen.IEditen;
import com.flagleader.repository.rlm.editen.IModifierEditen;
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.editen.ISheetAndFieldEditen;
import com.flagleader.repository.rlm.editen.ISheetAndWhereEditen;
import com.flagleader.repository.rlm.editen.ISheetDynamicEditen;
import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
import com.flagleader.repository.rlm.editen.ISheetFieldEditen;
import com.flagleader.repository.rlm.editen.ISheetFieldsSelectEditen;
import com.flagleader.repository.rlm.editen.ISheetFunctionEditen;
import com.flagleader.repository.rlm.editen.ISheetWhereEditen;
import com.flagleader.repository.rlm.editen.IStaticEditen;
import com.flagleader.repository.rlm.editen.ITextEditen;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.ClassToken;
import com.flagleader.repository.rlm.value.ConstantSelectToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberPropertyToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.MemberToken.MemberSelector;
import com.flagleader.repository.rlm.value.NewToken;
import com.flagleader.repository.rlm.value.SheetAndFieldsSelectToken;
import com.flagleader.repository.rlm.value.SheetAndWheresSelectToken;
import com.flagleader.repository.rlm.value.SheetDynamicSelectToken;
import com.flagleader.repository.rlm.value.SheetFentanSelectToken;
import com.flagleader.repository.rlm.value.SheetFieldSelectToken;
import com.flagleader.repository.rlm.value.SheetFieldsSelectToken;
import com.flagleader.repository.rlm.value.SheetFunctionsSelectToken;
import com.flagleader.repository.rlm.value.SheetWhere;
import com.flagleader.repository.rlm.value.SheetWheresSelectToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.tree.AbstractRuleSet;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateAction;
import com.flagleader.repository.tree.DecisionRelateCondition;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.DecisionValue;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleFlowTransition;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleSet;
import java.util.Iterator;
import java.util.List;

public abstract class r extends a
{
  protected boolean k = false;

  public Object visitMultiActionToken(MultiActionToken paramMultiActionToken)
  {
    Iterator localIterator = paramMultiActionToken.getMultiLine();
    while (localIterator.hasNext())
    {
      IEditen localIEditen = (IEditen)localIterator.next();
      b(localIEditen);
      localIEditen.acceptVisitor(this);
      a(localIEditen);
      c(paramMultiActionToken);
    }
    a(paramMultiActionToken);
    return null;
  }

  public Object visitMultiConditionToken(MultiConditionToken paramMultiConditionToken)
  {
    Iterator localIterator = paramMultiConditionToken.getMultiLine();
    while (localIterator.hasNext())
    {
      IEditen localIEditen = (IEditen)localIterator.next();
      b(localIEditen);
      localIEditen.acceptVisitor(this);
      a(localIEditen);
      c(paramMultiConditionToken);
    }
    a(paramMultiConditionToken);
    return null;
  }

  public Object visitRuleSetToken(RuleSetToken paramRuleSetToken)
  {
    paramRuleSetToken.initUndoable();
    if (paramRuleSetToken.getRuleSet().isInitTestType())
    {
      b(u.a("init.text"));
      paramRuleSetToken.getInitActions().acceptVisitor(this);
      b(u.a("condition.text"));
      paramRuleSetToken.getTestConditions().acceptVisitor(this);
    }
    else if (paramRuleSetToken.getRuleSet().isTestType())
    {
      b(u.a("condition.text"));
      paramRuleSetToken.getTestConditions().acceptVisitor(this);
    }
    else if (paramRuleSetToken.getRuleSet().isForType())
    {
      b(u.a("init.text"));
      paramRuleSetToken.getInitActions().acceptVisitor(this);
      b(u.a("test.text"));
      paramRuleSetToken.getTestConditions().acceptVisitor(this);
      b(u.a("block.text"));
      paramRuleSetToken.getBlockActions().acceptVisitor(this);
    }
    if (paramRuleSetToken.getRuleSet().isFirst())
    {
      b(u.a("first.text"));
      paramRuleSetToken.getFirstActions().acceptVisitor(this);
    }
    else if (paramRuleSetToken.getRuleSet().isForEachType())
    {
      b(u.a("test.text"));
      b(paramRuleSetToken.getForEachConditionToken());
      paramRuleSetToken.getForEachConditionToken().acceptVisitor(this);
      c(paramRuleSetToken.getForEachConditionToken());
    }
    if (paramRuleSetToken.getRuleSet().isSupportCatch())
    {
      b(u.a("catch_exception", "catch exception"));
      paramRuleSetToken.getCatchActions().acceptVisitor(this);
    }
    return null;
  }

  public Object visitActionToken(StatementContainerToken paramStatementContainerToken)
  {
    a(paramStatementContainerToken);
    a(paramStatementContainerToken);
    return super.visitActionToken(paramStatementContainerToken);
  }

  public Object visitAssignToken(AssignToken paramAssignToken)
  {
    a(paramAssignToken);
    return super.visitAssignToken(paramAssignToken);
  }

  public Object visitClassToken(ClassToken paramClassToken)
  {
    a(paramClassToken);
    return super.visitClassToken(paramClassToken);
  }

  public Object visitConditionToken(ConditionToken paramConditionToken)
  {
    a(paramConditionToken);
    a(paramConditionToken);
    return super.visitConditionToken(paramConditionToken);
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

  public Object visitFieldToken(FieldToken paramFieldToken)
  {
    a(paramFieldToken);
    return super.visitFieldToken(paramFieldToken);
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

  public Object visitSheetFieldSelectToken(SheetFieldSelectToken paramSheetFieldSelectToken)
  {
    a(paramSheetFieldSelectToken);
    return super.visitSheetFieldSelectToken(paramSheetFieldSelectToken);
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

  public Object visitSheetWheresSelectToken(SheetWheresSelectToken paramSheetWheresSelectToken)
  {
    a(paramSheetWheresSelectToken);
    return super.visitSheetWheresSelectToken(paramSheetWheresSelectToken);
  }

  public Object visitSheetAndFieldsSelectToken(SheetAndFieldsSelectToken paramSheetAndFieldsSelectToken)
  {
    a(paramSheetAndFieldsSelectToken);
    return super.visitSheetAndFieldsSelectToken(paramSheetAndFieldsSelectToken);
  }

  public Object visitSheetAndWheresSelectToken(SheetAndWheresSelectToken paramSheetAndWheresSelectToken)
  {
    a(paramSheetAndWheresSelectToken);
    return super.visitSheetAndWheresSelectToken(paramSheetAndWheresSelectToken);
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

  public Object visitRuleToken(RuleToken paramRuleToken)
  {
    if (paramRuleToken.getRule().isSupportEnter())
      paramRuleToken.getEnterCondition().acceptVisitor(this);
    if (paramRuleToken.getRule().isSupportInit())
    {
      b(u.a("init.text", "Init"));
      paramRuleToken.getInitActions().acceptVisitor(this);
    }
    if (paramRuleToken == null)
      return null;
    b(u.a("tv_if", "if"));
    paramRuleToken.getWhenCondition().acceptVisitor(this);
    b(u.a("tv_then", "then"));
    paramRuleToken.getThenActions().acceptVisitor(this);
    List localList = paramRuleToken.getElseIfTokens();
    for (int i = 0; i < localList.size(); i++)
      ((ElseIfRuleToken)localList.get(i)).acceptVisitor(this);
    if (paramRuleToken.getRule().isSupportElse())
    {
      b(u.a("tv_else", "else"));
      paramRuleToken.getElseActions().acceptVisitor(this);
    }
    if (paramRuleToken.getRule().isSupportCatch())
    {
      b(u.a("catch_exception", "catch exception"));
      paramRuleToken.getCatchActions().acceptVisitor(this);
    }
    return super.visitRuleToken(paramRuleToken);
  }

  public Object visitElseIfRuleToken(ElseIfRuleToken paramElseIfRuleToken)
  {
    if (paramElseIfRuleToken == null)
      return null;
    b(u.a("tv_elseif", "else if"));
    paramElseIfRuleToken.getWhenCondition().acceptVisitor(this);
    b(u.a("tv_then", "then"));
    paramElseIfRuleToken.getThenActions().acceptVisitor(this);
    return super.visitElseIfRuleToken(paramElseIfRuleToken);
  }

  public Object visitValueToken(ValueToken paramValueToken)
  {
    a(paramValueToken);
    return super.visitValueToken(paramValueToken);
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

  protected abstract void b(String paramString);

  protected void a(IMultiEditen paramIMultiEditen)
  {
    Iterator localIterator = paramIMultiEditen.getMultiToken();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof ISelectorEditen))
      {
        a((ISelectorEditen)localObject);
      }
      else if ((localObject instanceof IStaticEditen))
      {
        a((IStaticEditen)localObject);
      }
      else if ((localObject instanceof ITextEditen))
      {
        a((ITextEditen)localObject);
      }
      else if ((localObject instanceof IMultiEditen))
      {
        a((IMultiEditen)localObject);
      }
      else if ((localObject instanceof IModifierEditen))
      {
        a((IModifierEditen)localObject);
      }
      else if ((localObject instanceof ISheetFieldsSelectEditen))
      {
        a((ISheetFieldsSelectEditen)localObject);
      }
      else if ((localObject instanceof ISheetFunctionEditen))
      {
        a((ISheetFunctionEditen)localObject);
      }
      else if ((localObject instanceof ISheetWhereEditen))
      {
        a((ISheetWhereEditen)localObject);
      }
      else if ((localObject instanceof ISheetAndFieldEditen))
      {
        a((ISheetAndFieldEditen)localObject);
      }
      else if ((localObject instanceof ISheetDynamicEditen))
      {
        a((ISheetDynamicEditen)localObject);
      }
      else if ((localObject instanceof ISheetAndWhereEditen))
      {
        a((ISheetAndWhereEditen)localObject);
      }
      else if ((localObject instanceof ISheetFieldEditen))
      {
        a((ISheetFieldEditen)localObject);
      }
      else if ((localObject instanceof ISelectRulePackageEditen))
      {
        a((ISelectRulePackageEditen)localObject);
      }
      else
      {
        if (!(localObject instanceof ISheetFentanEditen))
          continue;
        a((ISheetFentanEditen)localObject);
      }
    }
  }

  protected abstract void a(ISheetFentanEditen paramISheetFentanEditen);

  protected abstract void a(ISheetFieldEditen paramISheetFieldEditen);

  protected abstract void a(ISheetAndWhereEditen paramISheetAndWhereEditen);

  protected abstract void a(ISelectRulePackageEditen paramISelectRulePackageEditen);

  protected abstract void a(ISheetAndFieldEditen paramISheetAndFieldEditen);

  protected abstract void a(ISheetDynamicEditen paramISheetDynamicEditen);

  protected abstract void a(ISheetWhereEditen paramISheetWhereEditen);

  protected abstract void a(ISheetFunctionEditen paramISheetFunctionEditen);

  protected abstract void a(ISheetFieldsSelectEditen paramISheetFieldsSelectEditen);

  protected abstract void a(ISelectorEditen paramISelectorEditen);

  protected abstract void a(IStaticEditen paramIStaticEditen);

  protected abstract void a(ITextEditen paramITextEditen);

  protected abstract void a(IModifierEditen paramIModifierEditen);

  protected abstract void b(IEditen paramIEditen);

  protected abstract void a(IEditen paramIEditen);

  public Object visitRule(Rule paramRule)
  {
    paramRule.initUndoable();
    visitRuleToken(paramRule.getRuleElementToken());
    return null;
  }

  public Object visitRulePackage(RulePackage paramRulePackage)
  {
    return null;
  }

  public Object visitDecisionRule(DecisionRule paramDecisionRule)
  {
    b(u.a("col.text"));
    paramDecisionRule.getFirstConditions().acceptVisitor(this);
    b(u.a("row.text"));
    paramDecisionRule.getSecondConditions().acceptVisitor(this);
    return null;
  }

  public Object visitDecisionMultiRule(DecisionMultiRule paramDecisionMultiRule)
  {
    for (int i = 1; i <= paramDecisionMultiRule.getConditionNum(); i++)
    {
      b(u.a("decisioncondition.text") + i);
      paramDecisionMultiRule.getConditions(i).acceptVisitor(this);
    }
    return null;
  }

  public Object visitDecisionRelateCondition(DecisionRelateCondition paramDecisionRelateCondition)
  {
    b(u.a("decisioncondition.text"));
    paramDecisionRelateCondition.getConditions().acceptVisitor(this);
    return null;
  }

  public Object visitDecisionRelateRule(DecisionRelateRule paramDecisionRelateRule)
  {
    b(u.a("decisioncondition.text"));
    paramDecisionRelateRule.getConditions().acceptVisitor(this);
    return null;
  }

  public Object visitRuleSet(RuleSet paramRuleSet)
  {
    paramRuleSet.initUndoable();
    if (paramRuleSet.isInitTestType())
    {
      b(u.a("init.text"));
      paramRuleSet.getRuleSetToken().getInitActions().acceptVisitor(this);
      b(u.a("condition.text"));
      paramRuleSet.getRuleSetToken().getTestConditions().acceptVisitor(this);
    }
    else if (paramRuleSet.isTestType())
    {
      b(u.a("condition.text"));
      paramRuleSet.getRuleSetToken().getTestConditions().acceptVisitor(this);
    }
    else if (paramRuleSet.isForType())
    {
      b(u.a("init.text"));
      paramRuleSet.getRuleSetToken().getInitActions().acceptVisitor(this);
      b(u.a("test.text"));
      paramRuleSet.getRuleSetToken().getTestConditions().acceptVisitor(this);
      b(u.a("block.text"));
      paramRuleSet.getRuleSetToken().getBlockActions().acceptVisitor(this);
    }
    else if (paramRuleSet.isForEachType())
    {
      b(u.a("test.text"));
      b(paramRuleSet.getRuleSetToken().getForEachConditionToken());
      paramRuleSet.getRuleSetToken().getForEachConditionToken().acceptVisitor(this);
      c(paramRuleSet.getRuleSetToken().getForEachConditionToken());
    }
    if (paramRuleSet.isFirst())
    {
      b(u.a("first.text"));
      paramRuleSet.getRuleSetToken().getFirstActions().acceptVisitor(this);
    }
    return null;
  }

  public Object visitRuleFlowTransition(RuleFlowTransition paramRuleFlowTransition)
  {
    paramRuleFlowTransition.getTestConditions().acceptVisitor(this);
    return super.visitRuleFlowTransition(paramRuleFlowTransition);
  }

  public Object visitDecisionElementValue(DecisionElementValue paramDecisionElementValue)
  {
    int i = 0;
    if (!this.k)
    {
      b(paramDecisionElementValue);
      this.k = true;
      i = 1;
    }
    if (paramDecisionElementValue.getAssignValue() != null)
      paramDecisionElementValue.getAssignValue().acceptVisitor(this);
    a(paramDecisionElementValue);
    if (i != 0)
      c(paramDecisionElementValue);
    return null;
  }

  public Object visitSheetWhere(SheetWhere paramSheetWhere)
  {
    int i = 0;
    if (!this.k)
    {
      b(paramSheetWhere);
      this.k = true;
      i = 1;
    }
    if (paramSheetWhere.getAssignValue() != null)
      paramSheetWhere.getAssignValue().acceptVisitor(this);
    a(paramSheetWhere);
    if (i != 0)
      c(paramSheetWhere);
    return null;
  }

  public Object visitPackageField(AbstractPackageField paramAbstractPackageField)
  {
    int i = 0;
    if (!this.k)
    {
      b(paramAbstractPackageField);
      this.k = true;
      i = 1;
    }
    if ((paramAbstractPackageField instanceof PackageFieldGet))
    {
      if (((PackageFieldGet)paramAbstractPackageField).getAssignValue() != null)
        ((PackageFieldGet)paramAbstractPackageField).getAssignValue().acceptVisitor(this);
    }
    else if (((paramAbstractPackageField instanceof PackageFieldSet)) && (((PackageFieldSet)paramAbstractPackageField).getAssignValue() != null))
      ((PackageFieldSet)paramAbstractPackageField).getAssignValue().acceptVisitor(this);
    if (i != 0)
      c(paramAbstractPackageField);
    a(paramAbstractPackageField);
    return null;
  }

  public Object visitSheetDynamicSelectToken(SheetDynamicSelectToken paramSheetDynamicSelectToken)
  {
    a(paramSheetDynamicSelectToken);
    return super.visitSheetDynamicSelectToken(paramSheetDynamicSelectToken);
  }

  public Object visitSelectRulePackageToken(SelectRulePackageToken paramSelectRulePackageToken)
  {
    a(paramSelectRulePackageToken);
    return super.visitSelectRulePackageToken(paramSelectRulePackageToken);
  }

  public Object visitSheetFentanSelectToken(SheetFentanSelectToken paramSheetFentanSelectToken)
  {
    a(paramSheetFentanSelectToken);
    return super.visitSheetFentanSelectToken(paramSheetFentanSelectToken);
  }

  public Object visitRuleEnterToken(RuleEnterToken paramRuleEnterToken)
  {
    if (paramRuleEnterToken == null)
      return null;
    b(u.a("condition.text", "when"));
    paramRuleEnterToken.getWhenCondition().acceptVisitor(this);
    return super.visitRuleEnterToken(paramRuleEnterToken);
  }

  public Object visitDecisionValue(DecisionValue paramDecisionValue)
  {
    int i = 0;
    if (!this.k)
    {
      b(paramDecisionValue);
      this.k = true;
      i = 1;
    }
    if (paramDecisionValue.getAssignValue() != null)
      paramDecisionValue.getAssignValue().acceptVisitor(this);
    a(paramDecisionValue);
    if (i != 0)
      c(paramDecisionValue);
    return null;
  }

  public Object visitDecisionRelateAction(DecisionRelateAction paramDecisionRelateAction)
  {
    b(u.a("tv_then", "then"));
    paramDecisionRelateAction.getThenActions().acceptVisitor(this);
    return null;
  }

  protected void c(IEditen paramIEditen)
  {
  }

  public Object visitRulePoolValue(RulePoolValue paramRulePoolValue)
  {
    a(paramRulePoolValue);
    return super.visitRulePoolValue(paramRulePoolValue);
  }

  public Object visitContainer(IRuleContainer paramIRuleContainer)
  {
    if ((paramIRuleContainer instanceof AbstractRuleContainer))
    {
      int i = 0;
      if (!this.k)
      {
        b((AbstractRuleContainer)paramIRuleContainer);
        this.k = true;
        i = 1;
      }
      Iterator localIterator = paramIRuleContainer.getChildrenIterator();
      while (localIterator.hasNext())
        ((IElement)localIterator.next()).acceptVisitor(this);
      a((AbstractRuleContainer)paramIRuleContainer);
      if (i != 0)
        c((AbstractRuleContainer)paramIRuleContainer);
    }
    return super.visitContainer(paramIRuleContainer);
  }

  public Object visitSelector(ISelectorEditen paramISelectorEditen)
  {
    a(paramISelectorEditen);
    return super.visitSelector(paramISelectorEditen);
  }

  public Object visitForEachConditionToken(ForEachConditionToken paramForEachConditionToken)
  {
    a(paramForEachConditionToken);
    a(paramForEachConditionToken);
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.r
 * JD-Core Version:    0.6.0
 */