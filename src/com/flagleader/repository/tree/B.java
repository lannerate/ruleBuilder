package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;

class B
  implements ChildAcceptor
{
  B(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen.isEditVisible()) && ((localIBusinessObjectEditen instanceof IVariableObject)))
      {
        g localg = localIBusinessObjectEditen.getJavaType();
        if ((localg.m()) || (localg.e()) || (localg.b()) || (localg.v()) || (localg.x()) || (localg.w()) || (localg.j()))
          return true;
      }
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof ValueLibrary)) || ((paramObject instanceof VariableLibrary));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.B
 * JD-Core Version:    0.6.0
 */