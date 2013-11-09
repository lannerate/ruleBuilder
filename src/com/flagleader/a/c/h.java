package com.flagleader.a.c;

import com.flagleader.util.collection.IStringIterator;
import java.util.Enumeration;
import java.util.Hashtable;

class h
  implements IStringIterator
{
  private Enumeration b;

  h(g paramg)
  {
    this.b = (g.a(paramg) == null ? null : g.a(paramg).keys());
  }

  public boolean hasNext()
  {
    return (this.b != null) && (this.b.hasMoreElements());
  }

  public Object next()
  {
    return this.b == null ? null : this.b.nextElement();
  }

  public final String nextString()
  {
    return (String)next();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.c.h
 * JD-Core Version:    0.6.0
 */