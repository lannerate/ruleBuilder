package com.flagleader.manager.e;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.BOContainerGroup;

class P
  implements ChildAcceptor
{
  P(N paramN)
  {
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup));
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof SheetTable;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.P
 * JD-Core Version:    0.6.0
 */