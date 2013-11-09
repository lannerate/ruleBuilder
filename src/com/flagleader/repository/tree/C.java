package com.flagleader.repository.tree;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.db.DBModel;

class C
  implements Acceptor
{
  C(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof DBModel;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.C
 * JD-Core Version:    0.6.0
 */