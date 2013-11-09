package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.xml.XmlFunction;
import com.flagleader.repository.xml.XmlNode;

class V
  implements ChildAcceptor
{
  V(XmlFunctionToken paramXmlFunctionToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    return this.a.acceptBusinessObject(paramObject);
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof XmlNode)) || ((paramObject instanceof XmlFunction)) || ((paramObject instanceof ISubFunction));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.V
 * JD-Core Version:    0.6.0
 */