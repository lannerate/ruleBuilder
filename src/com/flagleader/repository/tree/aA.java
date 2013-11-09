package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;

class aA
  implements ChildAcceptor
{
  aA(RuleTreeFlow paramRuleTreeFlow)
  {
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IRuleProject)) || ((paramObject instanceof IRulePackage)) || ((paramObject instanceof IRuleSet));
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IRuleTree)) || ((paramObject instanceof IRulePackage));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.aA
 * JD-Core Version:    0.6.0
 */