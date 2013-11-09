package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;

class E
  implements ChildAcceptor
{
  E(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof MappingVariable)) && (((MappingVariable)paramObject).getInout() > 0))
      return true;
    if ((paramObject instanceof BusinessObjectClass))
      return true;
    return ((paramObject instanceof XmlNode)) || ((paramObject instanceof TreeValueNode)) || ((paramObject instanceof SheetTable));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof ValueLibrary)) || (((paramObject instanceof ClassContainer)) && (((ClassContainer)paramObject).isLoadContext())) || ((paramObject instanceof Envionment)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.E
 * JD-Core Version:    0.6.0
 */