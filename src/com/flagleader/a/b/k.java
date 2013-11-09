package com.flagleader.a.b;

import com.flagleader.a.B;
import com.flagleader.a.D;
import com.flagleader.a.c.a;
import com.flagleader.util.collection.IIterator;

class k extends a
{
  k(h paramh, B paramB)
  {
  }

  protected IIterator a()
  {
    return a(this.b);
  }

  protected IIterator a(Object paramObject)
  {
    B localB = (B)paramObject;
    D localD = localB.s();
    if (localD != null)
      return localD.a();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.k
 * JD-Core Version:    0.6.0
 */