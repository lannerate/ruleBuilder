package com.flagleader.builder.actions.g;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;

class l
  implements ChildAcceptor
{
  l(j paramj)
  {
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IRuleGroup)) || ((paramObject instanceof IRulePackage));
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof IPage;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.l
 * JD-Core Version:    0.6.0
 */