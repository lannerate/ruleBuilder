package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.rom.IWhileObject;

class M
  implements ChildAcceptor
{
  M(Envionment paramEnvionment, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IWhileObject)) && (((IWhileObject)paramObject).getUuid().equals(this.b));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof IWhileObject));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.M
 * JD-Core Version:    0.6.0
 */