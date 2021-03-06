package com.flagleader.builder.e.g;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.FunctionLibrary;
import com.flagleader.repository.tree.InterfaceContainer;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;

class d
  implements ChildAcceptor
{
  d(c paramc)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof SheetTable)) || ((paramObject instanceof FunctionLibrary)) || ((paramObject instanceof TreeValueNode)) || ((paramObject instanceof ValueLibrary)) || ((paramObject instanceof VariableLibrary)) || ((paramObject instanceof InterfaceContainer)) || ((paramObject instanceof SoapService)) || ((paramObject instanceof ClassContainer)) || ((paramObject instanceof XmlNode));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.g.d
 * JD-Core Version:    0.6.0
 */