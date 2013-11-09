package com.flagleader.repository.rlm;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.rlm.action.ExcuteRuleToken;
import com.flagleader.repository.rlm.action.ExeDecisionToken;
import com.flagleader.repository.rlm.action.ExeExpressionToken;
import com.flagleader.repository.rlm.action.ExeRuleToken;

class c
  implements Acceptor
{
  c(AbstractRuleObject paramAbstractRuleObject)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof ExcuteRuleToken)) || ((paramObject instanceof ExeRuleToken)) || ((paramObject instanceof ExeExpressionToken)) || ((paramObject instanceof ExeDecisionToken));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.c
 * JD-Core Version:    0.6.0
 */