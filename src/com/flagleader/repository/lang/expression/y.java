package com.flagleader.repository.lang.expression;

public class y extends a
  implements f
{
  private String e;
  private String f;
  private int g = 0;
  private int h = 0;

  public y(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    e(paramString);
  }

  private void e(String paramString)
  {
    this.e = paramString;
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    for (int i = 0; i < StatementSystem.k.length; i++)
    {
      if (!localStringBuffer.toString().endsWith(StatementSystem.k[i]))
        continue;
      localStringBuffer = new StringBuffer(localStringBuffer.substring(0, localStringBuffer.length() - StatementSystem.k[i].length()));
      this.f = StatementSystem.k[i];
    }
    while ((d(localStringBuffer.toString())) || (c(localStringBuffer.toString())))
      if (d(localStringBuffer.toString()))
      {
        this.g += 1;
        localStringBuffer.deleteCharAt(0);
      }
      else
      {
        if (!c(localStringBuffer.toString()))
          continue;
        if (b(localStringBuffer.toString()))
          break;
        this.h += 1;
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
    this.e = localStringBuffer.toString().trim();
  }

  public void f()
  {
    if (this.f != null)
      this.e += this.f;
    this.f = null;
  }

  public String b()
  {
    return this.e;
  }

  public String c()
  {
    return this.f;
  }

  public String toString()
  {
    if (this.f != null)
      return this.e + this.f;
    return this.e;
  }

  public int d()
  {
    return this.g;
  }

  public int e()
  {
    return this.h;
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.y
 * JD-Core Version:    0.6.0
 */