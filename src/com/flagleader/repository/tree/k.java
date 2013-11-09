package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IStatementToken;

class k
  implements ChildAcceptor
{
  k(DecisionMultiRule paramDecisionMultiRule, String paramString)
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
 * Qualified Name:     com.flagleader.repository.tree.k
 * JD-Core Version:    0.6.0
 */