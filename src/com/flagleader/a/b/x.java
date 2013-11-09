package com.flagleader.a.b;

import com.flagleader.a.B;
import com.flagleader.a.C;
import com.flagleader.a.D;
import com.flagleader.a.c.a;
import com.flagleader.util.collection.DynamicIterator;
import com.flagleader.util.collection.IIterator;

class x extends a
{
  private C a;

  protected IIterator a()
  {
    return this.a;
  }

  protected IIterator a(Object paramObject)
  {
    B localB = (B)paramObject;
    D localD = localB.r();
    if (localD != null)
      return localD.iterator();
    return DynamicIterator.EmptyIterator();
  }

  x(C paramC)
  {
    this.a = paramC;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.x
 * JD-Core Version:    0.6.0
 */