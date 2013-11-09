package com.flagleader.repository.tree;

import com.flagleader.repository.collections.Acceptor;

class af
  implements Acceptor
{
  af(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof InterfaceContainer;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.af
 * JD-Core Version:    0.6.0
 */