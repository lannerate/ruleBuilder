package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;

class aC
  implements ChildAcceptor
{
  aC(TestCaseLib paramTestCaseLib)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IRulePackage)) && (((IRulePackage)paramObject).getExeRulePackageName().equals(TestCaseLib.access$0(this.a)));
  }

  public boolean hasChildren(Object paramObject)
  {
    return (paramObject instanceof IRuleGroup);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.aC
 * JD-Core Version:    0.6.0
 */