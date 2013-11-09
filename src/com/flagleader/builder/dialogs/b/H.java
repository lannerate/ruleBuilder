package com.flagleader.builder.dialogs.b;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.BOContainerGroup;

class H
  implements ChildAcceptor
{
  H(G paramG)
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
 * Qualified Name:     com.flagleader.builder.dialogs.b.H
 * JD-Core Version:    0.6.0
 */