package com.flagleader.repository.e;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.BOContainerGroup;

class i
  implements ChildAcceptor
{
  i(h paramh)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof SheetTable)) || ((paramObject instanceof SheetMap));
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof BOContainerGroup;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.i
 * JD-Core Version:    0.6.0
 */