package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.xml.XmlNode;

class p
  implements Acceptor
{
  p(MemberXmlToken paramMemberXmlToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof XmlNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.p
 * JD-Core Version:    0.6.0
 */