package com.flagleader.manager;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.RulePackage;

class s
  implements ChildAcceptor
{
  s(r paramr)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof RulePackage;
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof IRuleGroup;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.s
 * JD-Core Version:    0.6.0
 */