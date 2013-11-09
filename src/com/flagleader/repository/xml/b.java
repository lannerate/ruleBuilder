package com.flagleader.repository.xml;

import com.flagleader.repository.collections.Acceptor;

class b
  implements Acceptor
{
  b(TreeValueNode paramTreeValueNode)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof TreeValueNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.xml.b
 * JD-Core Version:    0.6.0
 */