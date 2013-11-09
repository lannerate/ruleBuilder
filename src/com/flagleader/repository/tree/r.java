package com.flagleader.repository.tree;

import com.flagleader.repository.collections.Acceptor;

class r
  implements Acceptor
{
  r(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof CustomFunction;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.r
 * JD-Core Version:    0.6.0
 */