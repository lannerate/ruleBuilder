package com.flagleader.a.c;

import com.flagleader.a.K;
import com.flagleader.a.S;
import com.flagleader.a.T;
import com.flagleader.util.collection.IIterator;

class o
  implements IIterator
{
  Object a = null;

  o(T paramT, K paramK)
  {
  }

  private void a()
  {
    while ((this.a == null) && (this.b != null) && (this.b.hasNext()))
    {
      S localS = this.b.d();
      if (!n.a(this.c, localS))
        continue;
      this.a = localS;
    }
  }

  public boolean hasNext()
  {
    a();
    return this.a != null;
  }

  public Object next()
  {
    a();
    Object localObject = this.a;
    this.a = null;
    return localObject;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.c.o
 * JD-Core Version:    0.6.0
 */