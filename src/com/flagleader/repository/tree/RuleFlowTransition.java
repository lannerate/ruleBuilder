package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.AbstractRuleContainer;
import com.flagleader.repository.rlm.condition.DecisionMultiConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rom.CustomVariable;
import java.util.Iterator;
import java.util.List;

public class RuleFlowTransition extends AbstractRuleContainer
  implements IRuleContainer
{
  private String fromUuid = "";
  private String toUuid = "";

  public RuleFlowTransition(RuleFlowTransition paramRuleFlowTransition)
  {
    super(paramRuleFlowTransition);
    this.fromUuid = paramRuleFlowTransition.fromUuid;
    this.toUuid = paramRuleFlowTransition.toUuid;
    setUuid(paramRuleFlowTransition.getUuid());
  }

  public RuleFlowTransition(String paramString1, String paramString2)
  {
    this.fromUuid = paramString1;
    this.toUuid = paramString2;
  }

  public RuleFlowTransition()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRuleFlowTransition(this);
  }

  public IElement deepClone()
  {
    return new RuleFlowTransition(this);
  }

  public String getName()
  {
    return "RuleFlowTransition";
  }

  public String toString()
  {
    return getDisplayName();
  }

  public IMultiConditionToken getTestConditions()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof IMultiConditionToken))
        return (IMultiConditionToken)localList.get(i);
    DecisionMultiConditionToken localDecisionMultiConditionToken = new DecisionMultiConditionToken();
    super.addChildElement(localDecisionMultiConditionToken);
    return localDecisionMultiConditionToken;
  }

  public String getFromUuid()
  {
    return this.fromUuid;
  }

  public void setFromUuid(String paramString)
  {
    this.fromUuid = paramString;
  }

  public String getToUuid()
  {
    return this.toUuid;
  }

  public void setToUuid(String paramString)
  {
    this.toUuid = paramString;
  }

  public Envionment getEnvionment()
  {
    if (getMainPackage() != null)
      return getMainPackage().getEnvionment();
    return null;
  }

  public IRuleContainer getRoot()
  {
    return this;
  }

  public IRulePackage getMainPackage()
  {
    if ((getParent() != null) && ((getParent() instanceof RuleSetFlow)))
      return ((RuleSetFlow)getParent()).getMainPackage();
    if ((getParent() != null) && ((getParent() instanceof RuleTreeFlow)))
      return ((RuleTreeFlow)getParent()).getMainPackage();
    if ((getParent() != null) && ((getParent() instanceof IRulePackage)))
      return (IRulePackage)getParent();
    return null;
  }

  public IRuleFlow getRuleSetFlow()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleFlow)))
      return (IRuleFlow)getParent();
    return null;
  }

  public IPackageElement getRuleTree()
  {
    return getRuleSetFlow();
  }

  public boolean isEmpty()
  {
    return getTestConditions().getConditions().hasNext();
  }

  public boolean isVisible()
  {
    return false;
  }

  public void save()
  {
    if (getMainPackage() != null)
    {
      getMainPackage().save();
      getMainPackage().setModified(false);
    }
  }

  public boolean addVariableDebug(CustomVariable paramCustomVariable)
  {
    return false;
  }

  public boolean clearDebug()
  {
    return false;
  }

  public String getInfo()
  {
    if (getDisplayName().length() > 0)
      return getDisplayName();
    return getTestConditions().getText();
  }

  public boolean paste(IElement paramIElement)
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.RuleFlowTransition
 * JD-Core Version:    0.6.0
 */