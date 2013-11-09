package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;

class z
  implements ChildAcceptor
{
  z(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof TreeAttribute)) && (((TreeAttribute)paramObject).isEditVisible());
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof TreeValueNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.z
 * JD-Core Version:    0.6.0
 */