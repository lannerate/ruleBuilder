package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rom.IBusinessObject;

class ad
  implements ChildAcceptor
{
  ad(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof IBusinessObject;
  }

  public boolean hasChildren(Object paramObject)
  {
    return !(paramObject instanceof IRuleTree);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ad
 * JD-Core Version:    0.6.0
 */