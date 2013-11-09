package com.flagleader.a.c;

import com.flagleader.util.collection.IIterator;
import java.util.Enumeration;

public class k
  implements Enumeration
{
  private IIterator a;

  public k(IIterator paramIIterator)
  {
    this.a = paramIIterator;
  }

  public final boolean hasMoreElements()
  {
    return this.a.hasNext();
  }

  public final Object nextElement()
  {
    return this.a.next();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.c.k
 * JD-Core Version:    0.6.0
 */