package com.flagleader.repository.d;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.RulePackage;

class D
  implements ChildAcceptor
{
  D(A paramA)
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
 * Qualified Name:     com.flagleader.repository.d.D
 * JD-Core Version:    0.6.0
 */