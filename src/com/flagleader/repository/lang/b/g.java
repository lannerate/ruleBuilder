package com.flagleader.repository.lang.b;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.lang.TypeMethod;

class g
  implements Acceptor
{
  g(f paramf, com.flagleader.repository.lang.g paramg)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof TypeMethod)) && (this.b.b(((TypeMethod)paramObject).getTypeName()));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.g
 * JD-Core Version:    0.6.0
 */