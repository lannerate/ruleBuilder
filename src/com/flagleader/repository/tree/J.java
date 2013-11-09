package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.xml.TreeValueNode;

class J
  implements ChildAcceptor
{
  J(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if (((localIBusinessObjectEditen instanceof MappingVariable)) && ((((MappingVariable)localIBusinessObjectEditen).getInout() == 2) || (((MappingVariable)localIBusinessObjectEditen).getInout() == 3)))
        return true;
      if (((localIBusinessObjectEditen instanceof SheetTable)) && ((((SheetTable)localIBusinessObjectEditen).getInout() == 2) || (((SheetTable)localIBusinessObjectEditen).getInout() == 3)))
        return true;
      if (((localIBusinessObjectEditen instanceof SheetMap)) && ((((SheetMap)localIBusinessObjectEditen).getInout() == 2) || (((SheetMap)localIBusinessObjectEditen).getInout() == 3)))
        return true;
      if (((localIBusinessObjectEditen instanceof TreeValueNode)) && ((((TreeValueNode)localIBusinessObjectEditen).getInout() == 2) || (((TreeValueNode)localIBusinessObjectEditen).getInout() == 3)))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof ValueLibrary)) || ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.J
 * JD-Core Version:    0.6.0
 */