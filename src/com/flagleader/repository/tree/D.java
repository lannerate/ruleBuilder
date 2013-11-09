package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;

class D
  implements ChildAcceptor
{
  D(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof IVariableObject)) && (((IVariableObject)paramObject).canSetLoged()))
      return ((IVariableObject)paramObject).isLoged();
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof ValueLibrary)) || ((paramObject instanceof VariableLibrary)) || ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof SheetTable)) || ((paramObject instanceof TreeValueNode)) || ((paramObject instanceof XmlNode));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.D
 * JD-Core Version:    0.6.0
 */