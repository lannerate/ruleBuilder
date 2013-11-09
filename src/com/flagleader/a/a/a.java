package com.flagleader.a.a;

import com.flagleader.util.exception.UnsupportOperationException;

public abstract class a
  implements o
{
  public void a(int paramInt, Object paramObject)
  {
    a();
    if (b(paramObject))
    {
      if ((paramInt < 0) || (paramInt > f()))
        throw new IndexOutOfBoundsException();
      c(paramInt, paramObject);
    }
    else
    {
      throw new IllegalArgumentException();
    }
  }

  public boolean a(Object paramObject)
  {
    a();
    if (b(paramObject))
      c(f(), paramObject);
    else
      throw new IllegalArgumentException();
    return true;
  }

  public boolean a(int paramInt, o paramo)
  {
    a();
    int i = paramo.f();
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      a(paramInt++, paramo.a(k));
      j++;
    }
    return j > 0;
  }

  public boolean a(o paramo)
  {
    return a(0, paramo);
  }

  protected boolean b(Object paramObject)
  {
    return paramObject != null;
  }

  protected final void a()
  {
    if (!d())
      throw new UnsupportOperationException();
  }

  public abstract void b();

  public boolean c(Object paramObject)
  {
    return d(paramObject) >= 0;
  }

  public boolean b(o paramo)
  {
    int i = paramo.f();
    for (int j = 0; j < i; j++)
      if (!c(paramo.a(j)))
        return false;
    return true;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof o))
    {
      o localo = (o)paramObject;
      int i = localo.f();
      if (f() == i)
      {
        for (int j = 0; j < i; j++)
          if (a(j) != localo.a(j))
            return false;
        return true;
      }
    }
    return false;
  }

  public abstract Object a(int paramInt);

  public int hashCode()
  {
    int i = 1;
    int j = f();
    for (int k = 0; k < j; k++)
    {
      Object localObject = a(k);
      i = 31 * i + (localObject != null ? localObject.hashCode() : 0);
    }
    return i;
  }

  public int d(Object paramObject)
  {
    int i = f();
    for (int j = 0; j < i; j++)
      if (a(j).equals(paramObject))
        return j;
    return -1;
  }

  public boolean c()
  {
    return f() == 0;
  }

  public abstract boolean d();

  public n e()
  {
    return new s(this);
  }

  public int e(Object paramObject)
  {
    int i = f();
    for (int j = i - 1; j >= 0; j--)
      if (a(j).equals(paramObject))
        return j;
    return -1;
  }

  public Object b(int paramInt)
  {
    a();
    if ((paramInt >= 0) && (paramInt < f()))
    {
      Object localObject = a(paramInt);
      c(paramInt);
      return localObject;
    }
    throw new IndexOutOfBoundsException();
  }

  public boolean f(Object paramObject)
  {
    a();
    int i = d(paramObject);
    if (i >= 0)
    {
      c(i);
      return true;
    }
    return false;
  }

  public boolean c(o paramo)
  {
    a();
    int i = 0;
    int j = paramo.f();
    for (int k = 0; k < j; k++)
    {
      if (!f(paramo.a(k)))
        continue;
      i = 1;
    }
    return i;
  }

  public boolean d(o paramo)
  {
    a();
    int i = 0;
    int j = f();
    for (int k = 0; k < j; k++)
    {
      Object localObject = a(k);
      if ((paramo.c(localObject)) || (localObject != b(k)))
        continue;
      i = 1;
    }
    return i;
  }

  public Object b(int paramInt, Object paramObject)
  {
    a();
    if (b(paramObject))
    {
      if ((paramInt < 0) || (paramInt >= f()))
        throw new IndexOutOfBoundsException();
      return d(paramInt, paramObject);
    }
    throw new IllegalArgumentException();
  }

  public abstract int f();

  protected abstract void c(int paramInt, Object paramObject);

  protected abstract Object c(int paramInt);

  protected abstract Object d(int paramInt, Object paramObject);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.a.a
 * JD-Core Version:    0.6.0
 */