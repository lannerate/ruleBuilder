package com.flagleader.repository.d;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.RulePackage;

class F
  implements ChildAcceptor
{
  F(A paramA)
  {
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof IRuleGroup;
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof RulePackage;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.F
 * JD-Core Version:    0.6.0
 */