package com.flagleader.repository.tree;

import com.flagleader.repository.collections.Acceptor;

class ae
  implements Acceptor
{
  ae(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof ClassContainer;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ae
 * JD-Core Version:    0.6.0
 */