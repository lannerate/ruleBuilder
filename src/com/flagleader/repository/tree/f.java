package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.xml.TreeValueNode;

class f
  implements ChildAcceptor
{
  f(AbstractRuleTree paramAbstractRuleTree)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof SheetTable))
      return ((SheetTable)paramObject).getUuid().equals(AbstractRuleTree.access$0(this.a));
    if (((paramObject instanceof TreeValueNode)) && (!((TreeValueNode)paramObject).isSingleValue()))
      return ((TreeValueNode)paramObject).getUuid().equals(AbstractRuleTree.access$0(this.a));
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof TreeValueNode));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.f
 * JD-Core Version:    0.6.0
 */