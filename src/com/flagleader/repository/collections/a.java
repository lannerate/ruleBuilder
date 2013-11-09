package com.flagleader.repository.collections;

import java.util.Iterator;

public class a
  implements Iterator
{
  Iterator a = null;
  Object b = null;
  Acceptor c = null;

  public a(Iterator paramIterator, Acceptor paramAcceptor)
  {
    this.a = paramIterator;
    this.c = paramAcceptor;
  }

  private void a()
  {
    while ((this.b == null) && (this.a != null) && (this.a.hasNext()))
    {
      Object localObject = this.a.next();
      if (!this.c.accept(localObject))
        continue;
      this.b = localObject;
    }
  }

  public boolean hasNext()
  {
    a();
    return this.b != null;
  }

  public Object next()
  {
    a();
    Object localObject = this.b;
    this.b = null;
    return localObject;
  }

  public void remove()
  {
    a();
    this.a.remove();
    this.b = null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.collections.a
 * JD-Core Version:    0.6.0
 */