package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rlm.condition.DecisionMultiConditionToken;
import com.flagleader.repository.rlm.lang.IConditionToken;

class m
  implements ChildAcceptor
{
  m(DecisionRelateRule paramDecisionRelateRule)
  {
  }

  public boolean accept(Object paramObject)
  {
    return (paramObject instanceof IConditionToken);
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof DecisionMultiConditionToken;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.m
 * JD-Core Version:    0.6.0
 */