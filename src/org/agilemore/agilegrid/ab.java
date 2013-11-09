package org.agilemore.agilegrid;

import java.util.Hashtable;

public class ab extends d
{
  private Hashtable a = new Hashtable();
  protected Hashtable e = new Hashtable();
  protected int f = 35;
  protected int g = 18;

  public ab(e parame)
  {
    super(parame);
  }

  public int f(int paramInt)
  {
    Integer localInteger = (Integer)this.e.get(new Integer(paramInt));
    if (localInteger == null)
    {
      int i = b(paramInt);
      if (i < 0)
        return 0;
      return i;
    }
    return localInteger.intValue();
  }

  protected void c(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0)
      paramInt2 = 0;
    this.e.put(new Integer(paramInt1), new Integer(paramInt2));
  }

  protected void e(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0)
      paramInt2 = 0;
    this.a.put(new Integer(paramInt1), new Integer(paramInt2));
  }

  public int e(int paramInt)
  {
    Integer localInteger = (Integer)this.a.get(new Integer(paramInt));
    if (localInteger == null)
    {
      if (paramInt == 0)
      {
        i = c(0);
        if (i > 2)
          return i;
      }
      int i = c(paramInt);
      if (i < 2)
        return 2;
      return i;
    }
    if (localInteger.intValue() < 2)
      return 2;
    return localInteger.intValue();
  }

  public int b(int paramInt)
  {
    return 80;
  }

  public int c(int paramInt)
  {
    return 18;
  }

  public int h()
  {
    return 0;
  }

  public int i()
  {
    return 0;
  }

  public int d()
  {
    return 0;
  }

  public boolean u(int paramInt)
  {
    return true;
  }

  public boolean v(int paramInt)
  {
    return true;
  }

  public int b()
  {
    return 4;
  }

  public int a()
  {
    return 6;
  }

  public int c()
  {
    return this.f;
  }

  public int e()
  {
    return this.g;
  }

  public boolean j()
  {
    return true;
  }

  public boolean k()
  {
    return true;
  }

  public String d(int paramInt)
  {
    return Integer.toString(paramInt);
  }

  public String a(int paramInt)
  {
    String str = "";
    while (paramInt >= 0)
    {
      str = (char)((char)(paramInt % 26) + 'A') + str;
      paramInt = paramInt / 26 - 1;
    }
    return str;
  }

  protected void h(int paramInt)
  {
  }

  protected void j(int paramInt)
  {
  }

  protected void l(int paramInt)
  {
  }

  protected void b(int paramInt, String paramString)
  {
  }

  protected void b(boolean paramBoolean)
  {
  }

  protected void n(int paramInt)
  {
    this.f = paramInt;
  }

  protected void p(int paramInt)
  {
  }

  protected void r(int paramInt)
  {
  }

  protected void b(int paramInt, boolean paramBoolean)
  {
  }

  protected void b(int paramInt1, int paramInt2, String paramString)
  {
  }

  protected void t(int paramInt)
  {
    this.g = paramInt;
  }

  protected void d(int paramInt, String paramString)
  {
  }

  protected void d(boolean paramBoolean)
  {
  }

  public String g(int paramInt1, int paramInt2)
  {
    return null;
  }

  public void c(int paramInt, boolean paramBoolean)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.ab
 * JD-Core Version:    0.6.0
 */