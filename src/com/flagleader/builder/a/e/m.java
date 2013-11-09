package com.flagleader.builder.a.e;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.ISelectObject;

class m
  implements Acceptor
{
  m(k paramk)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof CustomSql)) || ((paramObject instanceof ISelectObject));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.m
 * JD-Core Version:    0.6.0
 */