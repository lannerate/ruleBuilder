package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IWhileObject;

class T
  implements ChildAcceptor
{
  T(Envionment paramEnvionment, String paramString, boolean paramBoolean)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen.isEditVisible()) && ((localIBusinessObjectEditen instanceof IFunctionObject)) && ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b))))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    if (this.c)
      return (!(paramObject instanceof IRuleTree)) && ((!(paramObject instanceof IWhileObject)) || (!((IWhileObject)paramObject).mustWhile())) && (!(paramObject instanceof ISelectObject)) && (!(paramObject instanceof SheetMap));
    return (!(paramObject instanceof IRuleTree)) && (!(paramObject instanceof SheetMap));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.T
 * JD-Core Version:    0.6.0
 */