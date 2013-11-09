package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;

class as
  implements ChildAcceptor
{
  as(RuleGroup paramRuleGroup)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof RuleGroup)) || ((paramObject instanceof RulePackage)) || ((paramObject instanceof TestCaseLib));
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof RuleGroup;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.as
 * JD-Core Version:    0.6.0
 */