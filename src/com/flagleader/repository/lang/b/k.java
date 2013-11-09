package com.flagleader.repository.lang.b;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.Envionment;

class k
  implements ChildAcceptor
{
  k(j paramj)
  {
  }

  public boolean accept(Object paramObject)
  {
    return (paramObject instanceof SheetTable);
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof Envionment)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.k
 * JD-Core Version:    0.6.0
 */