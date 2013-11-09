package com.flagleader.repository.tree;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.xml.TreeValueNode;

class ah
  implements Acceptor
{
  ah(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof TreeValueNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ah
 * JD-Core Version:    0.6.0
 */