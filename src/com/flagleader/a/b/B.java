package com.flagleader.a.b;

import com.flagleader.a.ab;
import com.flagleader.a.af;

public class B extends C
  implements ab
{
  private char a;
  private com.flagleader.a.B b = null;
  private Class c;
  private Class d;

  B(g paramg, Class paramClass1, Class paramClass2)
  {
    this(paramg, paramClass1, paramClass2, '\000');
  }

  B(g paramg, Class paramClass1, Class paramClass2, char paramChar)
  {
    super(paramg);
    this.c = paramClass1;
    this.d = paramClass2;
    this.a = paramChar;
    paramg.a(this);
  }

  public af J()
  {
    return null;
  }

  public String K()
  {
    return this.c.getName();
  }

  public Class V()
  {
    return this.c;
  }

  public char p()
  {
    return this.a;
  }

  public String L()
  {
    return this.c.getName();
  }

  public com.flagleader.a.B d()
  {
    if (this.b == null)
      this.b = new D(ab(), this.d, this);
    return this.b;
  }

  public boolean e()
  {
    return this.c == Boolean.TYPE;
  }

  public boolean f()
  {
    return this.c == Byte.TYPE;
  }

  public boolean g()
  {
    return this.c == Character.TYPE;
  }

  public boolean h()
  {
    return this.c == Double.TYPE;
  }

  public boolean i()
  {
    return this.c == Float.TYPE;
  }

  public boolean j()
  {
    return this.c == Integer.TYPE;
  }

  public boolean k()
  {
    return this.c == Long.TYPE;
  }

  public boolean l()
  {
    return (f()) || (n()) || (j()) || (k()) || (i()) || (h());
  }

  public boolean m()
  {
    return false;
  }

  public boolean Z()
  {
    return true;
  }

  public boolean n()
  {
    return this.c == Short.TYPE;
  }

  public boolean o()
  {
    return this.c == Void.TYPE;
  }

  void a(com.flagleader.a.B paramB)
  {
    this.b = paramB;
  }

  public boolean a(ab paramab)
  {
    if (paramab.f())
      return (n()) || (j()) || (k()) || (i()) || (h());
    if (paramab.n())
      return (j()) || (k()) || (i()) || (h());
    if (paramab.g())
      return (j()) || (k()) || (i()) || (h());
    if (paramab.j())
      return (k()) || (i()) || (h());
    if (paramab.k())
      return (i()) || (h());
    if (paramab.i())
      return h();
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.B
 * JD-Core Version:    0.6.0
 */