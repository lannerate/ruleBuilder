package com.flagleader.repository.collections;

import java.util.Iterator;

public class k
  implements Iterator
{
  Iterator a = null;
  Iterator b = null;

  public k(Iterator paramIterator1, Iterator paramIterator2)
  {
    this.a = paramIterator1;
    this.b = paramIterator2;
  }

  public boolean hasNext()
  {
    if (this.a.hasNext())
      return true;
    return this.b.hasNext();
  }

  public Object next()
  {
    if (this.a.hasNext())
      return this.a.next();
    if (this.b.hasNext())
      return this.b.next();
    return null;
  }

  public void remove()
  {
    if (this.a.hasNext())
      this.a.remove();
    if (this.b.hasNext())
      this.b.remove();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.collections.k
 * JD-Core Version:    0.6.0
 */