package com.flagleader.manager;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.export.IPage;

class d
  implements Acceptor
{
  d(a parama)
  {
  }

  public boolean accept(Object paramObject)
  {
    return (paramObject instanceof IPage);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.d
 * JD-Core Version:    0.6.0
 */