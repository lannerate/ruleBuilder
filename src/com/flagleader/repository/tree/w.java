package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;

class w
  implements ChildAcceptor
{
  w(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof SheetFieldModel)) && (((SheetFieldModel)paramObject).isEditVisible());
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof SheetTable)) || ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.w
 * JD-Core Version:    0.6.0
 */