package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;

class ai
  implements ChildAcceptor
{
  ai(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof SheetTable;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof Envionment)) || ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof DBModel));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ai
 * JD-Core Version:    0.6.0
 */