package com.flagleader.repository.lang.b;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.Envionment;

class q
  implements ChildAcceptor
{
  q(j paramj)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof SheetTable)) && ((((SheetTable)paramObject).getDBModel() == null) || (((SheetTable)paramObject).getTableFunction("loadFromSql") == null) || (((SheetTable)paramObject).getSqlSelect().length() <= 0));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof Envionment)) || ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof DBModel));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.q
 * JD-Core Version:    0.6.0
 */