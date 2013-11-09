package com.flagleader.manager.a.a;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.ISelectObject;

class b
  implements Acceptor
{
  b(a parama)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof CustomSql)) || ((paramObject instanceof ISelectObject));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.a.b
 * JD-Core Version:    0.6.0
 */