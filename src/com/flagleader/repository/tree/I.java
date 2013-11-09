package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;

class I
  implements ChildAcceptor
{
  I(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof MappingVariable))
        return true;
      if ((localIBusinessObjectEditen instanceof SheetTable))
        return true;
      if ((localIBusinessObjectEditen instanceof SheetMap))
        return true;
      if ((localIBusinessObjectEditen instanceof TreeValueNode))
        return true;
      if ((localIBusinessObjectEditen instanceof XmlNode))
        return true;
      if ((localIBusinessObjectEditen instanceof ExcelBookModel))
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
 * Qualified Name:     com.flagleader.repository.tree.I
 * JD-Core Version:    0.6.0
 */