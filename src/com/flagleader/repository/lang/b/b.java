package com.flagleader.repository.lang.b;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.lang.TypeMethod;
import com.flagleader.repository.lang.g;

class b
  implements Acceptor
{
  b(a parama, g paramg)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof TypeMethod)) && (this.b.b(((TypeMethod)paramObject).getTypeName()));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.b
 * JD-Core Version:    0.6.0
 */