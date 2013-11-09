package com.flagleader.repository.collections;

import java.util.Iterator;
import java.util.Stack;

public abstract class j
  implements Iterator
{
  private Stack a = new Stack();
  private Iterator b;
  private Object c = null;
  private ChildAcceptor d = null;

  public j(Iterator paramIterator, ChildAcceptor paramChildAcceptor)
  {
    this.b = paramIterator;
    this.d = paramChildAcceptor;
  }

  public abstract Iterator a(Object paramObject);

  public boolean hasNext()
  {
    while ((this.c == null) && ((this.b != null) || (!this.a.empty())))
      if ((this.b != null) && (this.b.hasNext()))
      {
        Object localObject = this.b.next();
        Iterator localIterator = null;
        if (this.d.accept(localObject))
          this.c = localObject;
        if (this.d.hasChildren(localObject))
          localIterator = a(localObject);
        if ((localIterator == null) || (!localIterator.hasNext()))
          continue;
        this.a.push(this.b);
        this.b = localIterator;
      }
      else if (this.a.size() > 0)
      {
        this.b = ((Iterator)this.a.pop());
      }
      else
      {
        this.b = null;
      }
    return this.c != null;
  }

  public Object next()
  {
    if ((this.c != null) || (hasNext()))
    {
      Object localObject = this.c;
      this.c = null;
      return localObject;
    }
    return null;
  }

  public void remove()
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.collections.j
 * JD-Core Version:    0.6.0
 */