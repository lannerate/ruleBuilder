package com.flagleader.a.a;

public class d
  implements n
{
  private n b;
  static n a = null;

  public d()
  {
    this.b = c();
  }

  public d(n paramn)
  {
    this.b = paramn;
  }

  public d(o paramo)
  {
    this.b = new s(paramo);
  }

  public static n c()
  {
    if (a == null)
    {
      e locale = new e();
      a = new d(locale);
    }
    return a;
  }

  public final boolean a()
  {
    return this.b.a();
  }

  public Object b()
  {
    return this.b.b();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.a.d
 * JD-Core Version:    0.6.0
 */