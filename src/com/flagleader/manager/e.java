package com.flagleader.manager;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;

class e
  implements ChildAcceptor
{
  e(a parama)
  {
  }

  public boolean accept(Object paramObject)
  {
    return (paramObject instanceof IRulePackage);
  }

  public boolean hasChildren(Object paramObject)
  {
    return (paramObject instanceof IRuleGroup);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e
 * JD-Core Version:    0.6.0
 */