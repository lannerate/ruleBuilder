package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IStatementToken;

class p
  implements ChildAcceptor
{
  p(DecisionRule paramDecisionRule, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IConditionToken)) && (((IConditionToken)paramObject).getUuid().equals(this.b));
  }

  public boolean hasChildren(Object paramObject)
  {
    return (!(paramObject instanceof IConditionToken)) && (!(paramObject instanceof IStatementToken));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.p
 * JD-Core Version:    0.6.0
 */