package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.tree.BOContainerGroup;

class m
  implements ChildAcceptor
{
  m(FunctionMapToken paramFunctionMapToken, String paramString)
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
      else if (((localIBusinessObjectEditen instanceof ISubFunction)) && (!(((ISubFunction)localIBusinessObjectEditen).getRootMember() instanceof BOContainerGroup)) && ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b))))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof SheetMap)) || ((paramObject instanceof TableFunction)) || ((paramObject instanceof ISubFunction));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.m
 * JD-Core Version:    0.6.0
 */