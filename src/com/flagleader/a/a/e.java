package com.flagleader.a.a;

import java.io.Serializable;
import java.util.Vector;

public class e extends a
  implements o, Serializable
{
  private h a = null;
  private boolean b = true;

  public void b()
  {
    if (this.a != null)
      this.a.a();
  }

  public void d(int paramInt)
  {
    if (this.a == null)
      this.a = new g(paramInt);
    else if ((this.a instanceof g))
      g.a((g)this.a, paramInt);
  }

  public Object a(int paramInt)
  {
    return (this.a == null) || (paramInt < 0) || (paramInt >= this.a.b()) ? null : this.a.a(paramInt);
  }

  public h g()
  {
    return this.a;
  }

  public boolean d()
  {
    return this.b;
  }

  public n e()
  {
    return new d(this);
  }

  public void e(o paramo)
  {
    this.a = new i(paramo);
  }

  public void a(h paramh)
  {
    this.a = paramh;
  }

  public void a(Vector paramVector)
  {
    this.a = new j(paramVector);
  }

  public void a(Object[] paramArrayOfObject)
  {
    this.a = new f(paramArrayOfObject);
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public final int f()
  {
    return this.a == null ? 0 : this.a.b();
  }

  public void h()
  {
    if (this.a != null)
      this.a.c();
  }

  protected void c(int paramInt, Object paramObject)
  {
    if (this.a == null)
      this.a = new g();
    this.a.a(paramInt, paramObject);
  }

  protected Object c(int paramInt)
  {
    Object localObject = null;
    if (this.a != null)
    {
      localObject = this.a.a(paramInt);
      this.a.b(paramInt);
    }
    return localObject;
  }

  protected Object d(int paramInt, Object paramObject)
  {
    Object localObject = null;
    if (this.a != null)
    {
      localObject = this.a.a(paramInt);
      this.a.b(paramInt, paramObject);
    }
    return localObject;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.a.e
 * JD-Core Version:    0.6.0
 */