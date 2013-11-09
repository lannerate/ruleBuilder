package com.flagleader.repository.collections;

import com.flagleader.repository.IElement;
import java.util.Iterator;

public class e
  implements Iterator
{
  Iterator a = null;
  Object b = null;

  public e(Iterator paramIterator)
  {
    this.a = paramIterator;
  }

  private void a()
  {
    while ((this.b == null) && (this.a != null) && (this.a.hasNext()))
    {
      Object localObject = this.a.next();
      if (!(localObject instanceof IElement))
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
 * Qualified Name:     com.flagleader.repository.collections.e
 * JD-Core Version:    0.6.0
 */