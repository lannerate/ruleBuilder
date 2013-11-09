package com.flagleader.a.b;

import com.flagleader.a.B;
import com.flagleader.a.E;
import com.flagleader.a.K;
import com.flagleader.a.c.x;
import com.flagleader.util.collection.IIterator;

class s extends x
{
  s(h paramh, IIterator paramIIterator, B paramB, E paramE, K paramK)
  {
    super(paramIIterator);
  }

  public IIterator a(Object paramObject)
  {
    if (paramObject == this.b)
      return ((B)paramObject).b(this.c, this.d);
    if ((paramObject instanceof B))
      return h.a(this.a, (B)paramObject, this.c, this.d);
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.s
 * JD-Core Version:    0.6.0
 */