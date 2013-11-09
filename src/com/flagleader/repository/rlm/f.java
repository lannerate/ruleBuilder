package com.flagleader.repository.rlm;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IStatementContainerToken;

class f
  implements ChildAcceptor
{
  f(RuleToken paramRuleToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof IStatementContainerToken;
  }

  public boolean hasChildren(Object paramObject)
  {
    return (((paramObject instanceof IMultiActionToken)) && (((IMultiActionToken)paramObject).getType() == 0)) || ((paramObject instanceof ElseIfRuleToken));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.f
 * JD-Core Version:    0.6.0
 */