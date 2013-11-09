package com.flagleader.repository.tree;

import java.util.List;

public abstract interface IRuleFlow extends IRuleTree
{
  public abstract List getNextTransitions(String paramString);

  public abstract Object getFlowElement(String paramString);

  public abstract boolean removeFlowElements(String paramString);

  public abstract IRuleClass getRuleObject(RuleFlowActivitie paramRuleFlowActivitie);

  public abstract List getStartTransitions();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IRuleFlow
 * JD-Core Version:    0.6.0
 */