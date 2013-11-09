package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.xml.TreeValueNode;

class O
  implements ChildAcceptor
{
  O(Envionment paramEnvionment, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof SheetTable))
      return ((IWhileObject)paramObject).getUniqueName().equals(this.b);
    if (((paramObject instanceof TreeValueNode)) && (!((TreeValueNode)paramObject).isSingleValue()))
      return ((IWhileObject)paramObject).getUniqueName().equals(this.b);
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof IWhileObject));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.O
 * JD-Core Version:    0.6.0
 */