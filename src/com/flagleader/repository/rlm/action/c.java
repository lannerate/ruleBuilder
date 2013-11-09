package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;

class c
  implements ChildAcceptor
{
  c(AbstractSelectRuleToken paramAbstractSelectRuleToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof IVariableObject))
      return true;
    if (((paramObject instanceof SheetTable)) || ((paramObject instanceof SheetMap)))
      return true;
    return ((paramObject instanceof XmlNode)) || ((paramObject instanceof TreeValueNode));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof ValueLibrary)) || ((paramObject instanceof VariableLibrary)) || ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof SheetTable)) || ((paramObject instanceof TreeValueNode)) || ((paramObject instanceof DBModel));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.c
 * JD-Core Version:    0.6.0
 */