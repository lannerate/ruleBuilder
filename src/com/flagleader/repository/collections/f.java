package com.flagleader.repository.collections;

import com.flagleader.repository.IElement;
import java.util.Iterator;

public class f
  implements Iterator
{
  h a = null;
  Object b = null;
  int c = 0;

  public f(h paramh)
  {
    this.a = paramh;
  }

  private void a()
  {
    while ((this.b == null) && (this.a != null) && (this.c < this.a.getChildrenCount()))
    {
      IElement localIElement = this.a.getElement(this.c++);
      if (!(localIElement instanceof IElement))
        continue;
      this.b = localIElement;
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
    this.a.removeElement(this.c);
    this.b = null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.collections.f
 * JD-Core Version:    0.6.0
 */