package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.BOContainerGroup;

class w
  implements ChildAcceptor
{
  w(SheetDynamicSelectToken paramSheetDynamicSelectToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (SheetDynamicSelectToken.access$0(this.a))
      return paramObject instanceof ISelectObject;
    if (paramObject.equals(this.a.getRootSheetElement()))
      return false;
    return paramObject instanceof SheetTable;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.w
 * JD-Core Version:    0.6.0
 */