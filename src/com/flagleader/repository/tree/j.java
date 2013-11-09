package com.flagleader.repository.tree;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.rlm.lang.IConditionToken;

class j
  implements Acceptor
{
  j(DecisionMultiRule paramDecisionMultiRule)
  {
  }

  public boolean accept(Object paramObject)
  {
    return (paramObject instanceof IConditionToken);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.j
 * JD-Core Version:    0.6.0
 */