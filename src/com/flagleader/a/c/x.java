package com.flagleader.a.c;

import com.flagleader.util.collection.IIterator;
import java.util.Stack;

public abstract class x
  implements IIterator
{
  private Stack a = new Stack();
  private IIterator b;
  private Object c = null;

  public x(IIterator paramIIterator)
  {
    this.b = paramIIterator;
  }

  public abstract IIterator a(Object paramObject);

  public boolean hasNext()
  {
    while ((this.c == null) && ((this.b != null) || (!this.a.empty())))
      if ((this.b != null) && (this.b.hasNext()))
      {
        Object localObject = this.b.next();
        IIterator localIIterator = a(localObject);
        if (localIIterator != null)
        {
          this.a.push(this.b);
          this.b = localIIterator;
        }
        else
        {
          this.c = localObject;
        }
      }
      else if (this.a.size() > 0)
      {
        this.b = ((IIterator)this.a.pop());
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.c.x
 * JD-Core Version:    0.6.0
 */