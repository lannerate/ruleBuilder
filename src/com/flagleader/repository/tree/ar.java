package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;

class ar
  implements ChildAcceptor
{
  ar(RuleGroup paramRuleGroup)
  {
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IRuleGroup)) || ((paramObject instanceof IRuleProject));
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof IRulePackage;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ar
 * JD-Core Version:    0.6.0
 */