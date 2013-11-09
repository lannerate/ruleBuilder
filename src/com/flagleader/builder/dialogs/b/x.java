package com.flagleader.builder.dialogs.b;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.tree.BOContainerGroup;

class x
  implements ChildAcceptor
{
  x(w paramw)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof IBOAndContainer;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.x
 * JD-Core Version:    0.6.0
 */