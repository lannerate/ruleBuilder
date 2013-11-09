package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.tree.BOContainerGroup;

class n
  implements ChildAcceptor
{
  n(FunctionSheetToken paramFunctionSheetToken, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof IBusinessObjectEditen)) && (((IBusinessObjectEditen)paramObject).isEditVisible()))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof TableFunction))
      {
        if ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof ISubFunction)) && (!(((ISubFunction)localIBusinessObjectEditen).getRootMember() instanceof DBModel)) && ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b))))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof SheetTable)) || ((paramObject instanceof TableFunction)) || ((paramObject instanceof ISubFunction));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.n
 * JD-Core Version:    0.6.0
 */