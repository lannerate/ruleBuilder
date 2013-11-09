package com.flagleader.manager.c.d;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.xml.TreeValueNode;

class ax
  implements ChildAcceptor
{
  ax(aw paramaw)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof SheetTable))
      return true;
    if ((paramObject instanceof TreeValueNode))
      return !((TreeValueNode)paramObject).isSingleValue();
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof TreeValueNode));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.ax
 * JD-Core Version:    0.6.0
 */