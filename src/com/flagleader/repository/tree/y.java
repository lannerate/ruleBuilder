package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.xml.XmlAttribute;
import com.flagleader.repository.xml.XmlNode;

class y
  implements ChildAcceptor
{
  y(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof XmlAttribute)) && (((XmlAttribute)paramObject).isEditVisible());
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof XmlNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.y
 * JD-Core Version:    0.6.0
 */