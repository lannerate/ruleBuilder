package com.flagleader.repository.lang.b;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.Envionment;

class n
  implements ChildAcceptor
{
  n(j paramj)
  {
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof Envionment)) || ((paramObject instanceof BOContainerGroup));
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof SheetMap;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.n
 * JD-Core Version:    0.6.0
 */