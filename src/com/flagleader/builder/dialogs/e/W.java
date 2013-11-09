package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import com.flagleader.repository.xml.XmlNode;

class W
  implements ChildAcceptor
{
  W(V paramV)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof SheetTable)) || ((paramObject instanceof ValueLibrary)) || ((paramObject instanceof VariableLibrary)) || ((paramObject instanceof XmlNode));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.W
 * JD-Core Version:    0.6.0
 */