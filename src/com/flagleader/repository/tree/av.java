package com.flagleader.repository.tree;

import com.flagleader.repository.collections.Acceptor;

class av
  implements Acceptor
{
  av(RuleProject paramRuleProject)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof IRuleTree;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.av
 * JD-Core Version:    0.6.0
 */