package com.flagleader.a.b;

import com.flagleader.a.B;
import com.flagleader.a.R;
import com.flagleader.a.c.x;
import com.flagleader.util.collection.DynamicIterator;
import com.flagleader.util.collection.IIterator;

class m extends x
{
  m(IIterator paramIIterator)
  {
    super(paramIIterator);
  }

  public IIterator a(Object paramObject)
  {
    if ((paramObject instanceof B))
    {
      B localB = (B)paramObject;
      return localB.q() == null ? DynamicIterator.EmptyIterator() : localB.q().c();
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.m
 * JD-Core Version:    0.6.0
 */