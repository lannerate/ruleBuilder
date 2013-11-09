package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;

class az
  implements ChildAcceptor
{
  az(RuleRepository paramRuleRepository)
  {
  }

  public boolean accept(Object paramObject)
  {
    return (paramObject instanceof IRulePackage);
  }

  public boolean hasChildren(Object paramObject)
  {
    return (paramObject instanceof IRuleGroup);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.az
 * JD-Core Version:    0.6.0
 */