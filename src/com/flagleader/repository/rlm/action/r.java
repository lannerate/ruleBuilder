package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rlm.lang.IStatementContainerToken;

class r
  implements ChildAcceptor
{
  r(MultiActionToken paramMultiActionToken)
  {
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof IStatementContainerToken;
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof ExeExpressionToken;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.r
 * JD-Core Version:    0.6.0
 */