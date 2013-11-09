package com.flagleader.a.b;

import com.flagleader.a.B;
import com.flagleader.util.collection.IIterator;

final class y
  implements IIterator
{
  B a;

  public boolean hasNext()
  {
    return this.a != null;
  }

  public Object next()
  {
    if (this.a != null)
    {
      B localB = this.a;
      this.a = this.a.o();
      return localB;
    }
    return null;
  }

  y(B paramB)
  {
    this.a = paramB.o();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.y
 * JD-Core Version:    0.6.0
 */