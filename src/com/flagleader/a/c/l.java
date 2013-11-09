package com.flagleader.a.c;

import com.flagleader.util.collection.IIterator;
import java.util.Stack;

public abstract class l
  implements IIterator
{
  private boolean a = false;
  private IIterator b = null;
  private Stack c = null;

  protected abstract IIterator a();

  protected abstract IIterator a(Object paramObject);

  public final boolean hasNext()
  {
    b();
    return (this.b != null) && (this.b.hasNext());
  }

  private final void b()
  {
    if (!this.a)
    {
      this.a = true;
      this.b = a();
    }
  }

  public final Object next()
  {
    b();
    Object localObject = (this.b == null) || (!this.b.hasNext()) ? null : this.b.next();
    if (localObject != null)
    {
      IIterator localIIterator = a(localObject);
      if ((localIIterator != null) && (localIIterator.hasNext()))
      {
        if (this.c == null)
          this.c = new Stack();
        this.c.push(this.b);
        this.b = localIIterator;
      }
      else
      {
        do
          this.b = ((IIterator)this.c.pop());
        while ((!this.b.hasNext()) && (this.c != null) && (!this.c.isEmpty()));
      }
    }
    return localObject;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.c.l
 * JD-Core Version:    0.6.0
 */