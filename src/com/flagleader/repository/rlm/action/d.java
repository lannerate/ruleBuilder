package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;

class d
  implements ChildAcceptor
{
  d(AbstractSelectRuleToken paramAbstractSelectRuleToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof MappingVariable)) && (((MappingVariable)paramObject).getInout() > 0))
      return true;
    if (((paramObject instanceof SheetTable)) || ((paramObject instanceof SheetMap)))
      return true;
    return ((paramObject instanceof XmlNode)) || ((paramObject instanceof TreeValueNode));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof ValueLibrary)) || ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof Envionment)) || ((paramObject instanceof DBModel));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.d
 * JD-Core Version:    0.6.0
 */