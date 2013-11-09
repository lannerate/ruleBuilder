package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.xml.XmlNode;

class T
  implements Acceptor
{
  T(XmlFunctionToken paramXmlFunctionToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof XmlNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.T
 * JD-Core Version:    0.6.0
 */