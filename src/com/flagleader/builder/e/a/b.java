package com.flagleader.builder.e.a;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.InterfaceContainer;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;

class b
  implements ChildAcceptor
{
  b(a parama)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof SheetTable)) || ((paramObject instanceof TableModel)) || ((paramObject instanceof XmlNode)) || ((paramObject instanceof TreeValueNode)) || ((paramObject instanceof ValueLibrary)) || ((paramObject instanceof VariableLibrary)) || ((paramObject instanceof InterfaceContainer)) || ((paramObject instanceof SoapService)) || ((paramObject instanceof ClassContainer));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.a.b
 * JD-Core Version:    0.6.0
 */