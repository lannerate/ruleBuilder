package com.flagleader.repository.collections;

import com.flagleader.repository.IElement;

public class b
{
  h a = null;
  Object b = null;
  int c = 0;

  public b(h paramh)
  {
    this.a = paramh;
  }

  private void d()
  {
    while ((this.b == null) && (this.a != null) && (this.c < this.a.getChildrenCount()))
    {
      IElement localIElement = this.a.getElement(this.c++);
      if (!(localIElement instanceof IElement))
        continue;
      this.b = localIElement;
    }
  }

  public boolean a()
  {
    d();
    return this.b != null;
  }

  public Object b()
  {
    d();
    Object localObject = this.b;
    this.b = null;
    return localObject;
  }

  public void c()
  {
    d();
    this.a.removeElement(this.c);
    this.b = null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.collections.b
 * JD-Core Version:    0.6.0
 */