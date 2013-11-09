package com.flagleader.engine;

public class b
{
  public String a;
  public String b;
  public String c;

  public b(MultiExpression paramMultiExpression, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof b))
      return (this.a.equals(((b)paramObject).a)) && (this.b.equals(((b)paramObject).b)) && (this.c.equals(((b)paramObject).c));
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.engine.b
 * JD-Core Version:    0.6.0
 */