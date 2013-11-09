package com.flagleader.a.a;

import com.flagleader.util.exception.UnsupportOperationException;
import java.util.Vector;

public class c extends a
  implements o
{
  private Vector a = new Vector();

  public c()
  {
  }

  public c(o paramo1, o paramo2)
  {
    e(paramo1);
    e(paramo2);
  }

  public c(o paramo1, o paramo2, o paramo3)
  {
    e(paramo1);
    e(paramo2);
    e(paramo3);
  }

  public c(o[] paramArrayOfo)
  {
    for (int i = 0; i < paramArrayOfo.length; i++)
      e(paramArrayOfo[i]);
  }

  public c g(Object paramObject)
  {
    if (paramObject != null)
    {
      e locale = new e();
      locale.a(paramObject);
      e(locale);
    }
    return this;
  }

  public c e(o paramo)
  {
    if (paramo != null)
      this.a.addElement(paramo);
    return this;
  }

  public void b()
  {
  }

  public Object a(int paramInt)
  {
    if (paramInt >= 0)
      for (int i = 0; i < this.a.size(); i++)
      {
        o localo = (o)this.a.elementAt(i);
        if (localo == null)
          continue;
        if (paramInt < localo.f())
          return localo.a(paramInt);
        paramInt -= localo.f();
      }
    return null;
  }

  public o d(int paramInt)
  {
    return (paramInt < 0) || (paramInt >= this.a.size()) ? null : (o)this.a.elementAt(paramInt);
  }

  public boolean d()
  {
    return false;
  }

  public int f()
  {
    int i = 0;
    for (int j = 0; j < this.a.size(); j++)
    {
      o localo = (o)this.a.elementAt(j);
      if (localo == null)
        continue;
      i += localo.f();
    }
    return i;
  }

  protected void c(int paramInt, Object paramObject)
  {
    throw new UnsupportOperationException();
  }

  protected Object c(int paramInt)
  {
    throw new UnsupportOperationException();
  }

  protected Object d(int paramInt, Object paramObject)
  {
    throw new UnsupportOperationException();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.a.c
 * JD-Core Version:    0.6.0
 */