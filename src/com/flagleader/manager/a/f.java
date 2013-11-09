package com.flagleader.manager.a;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.export.IPage;

class f
  implements Acceptor
{
  f(e parame)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IPage)) && (((IPage)paramObject).isModified());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.f
 * JD-Core Version:    0.6.0
 */