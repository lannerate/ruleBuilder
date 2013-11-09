package com.flagleader.a.a;

import com.flagleader.util.exception.UnsupportOperationException;
import java.io.Serializable;

public final class f
  implements h, Serializable
{
  private Object[] a;

  public void a(int paramInt, Object paramObject)
  {
    throw new UnsupportOperationException();
  }

  public void a()
  {
    throw new UnsupportOperationException();
  }

  public Object a(int paramInt)
  {
    return this.a[paramInt];
  }

  public void b(int paramInt)
  {
    throw new UnsupportOperationException();
  }

  public void b(int paramInt, Object paramObject)
  {
    this.a[paramInt] = paramObject;
  }

  public int b()
  {
    return this.a.length;
  }

  public void c()
  {
    throw new UnsupportOperationException();
  }

  public f(Object[] paramArrayOfObject)
  {
    this.a = paramArrayOfObject;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.a.f
 * JD-Core Version:    0.6.0
 */