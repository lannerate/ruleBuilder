package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;

class aD
  implements ChildAcceptor
{
  aD(TestCaseLib paramTestCaseLib)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IRuleSet)) && (((IRuleSet)paramObject).needCheckSubRule());
  }

  public boolean hasChildren(Object paramObject)
  {
    return (paramObject instanceof IRuleSet);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.aD
 * JD-Core Version:    0.6.0
 */