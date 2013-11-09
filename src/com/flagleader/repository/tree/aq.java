package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;

class aq
  implements ChildAcceptor
{
  aq(RuleDBProject paramRuleDBProject)
  {
  }

  public boolean hasChildren(Object paramObject)
  {
    return (paramObject instanceof IRuleGroup);
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof IRulePackage;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.aq
 * JD-Core Version:    0.6.0
 */