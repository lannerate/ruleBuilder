package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;

class aw
  implements ChildAcceptor
{
  aw(RuleProject paramRuleProject)
  {
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof RuleGroup)) || ((paramObject instanceof RuleProject));
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IRulePackage)) || ((paramObject instanceof TestCaseLib)) || ((paramObject instanceof Envionment));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.aw
 * JD-Core Version:    0.6.0
 */