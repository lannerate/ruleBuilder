package com.flagleader.repository.xml;

import com.flagleader.repository.collections.Acceptor;

class a
  implements Acceptor
{
  a(TreeValueNode paramTreeValueNode)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof TreeAttribute;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.xml.a
 * JD-Core Version:    0.6.0
 */