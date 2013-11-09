package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.SheetMap;

class s
  implements ChildAcceptor
{
  s(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof SheetMap;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof Envionment)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.s
 * JD-Core Version:    0.6.0
 */