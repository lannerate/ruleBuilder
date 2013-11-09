package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.MappingVariable;

class G
  implements ChildAcceptor
{
  G(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen.isEditVisible()) && ((localIBusinessObjectEditen instanceof MappingVariable)))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof ValueLibrary;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.G
 * JD-Core Version:    0.6.0
 */