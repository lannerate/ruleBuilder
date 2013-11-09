package com.flagleader.engine;

public class c
{
  public String a;
  public String b;
  public String c;

  public c(MultiExpression paramMultiExpression, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof c))
      return (this.a.equals(((c)paramObject).a)) && (this.b.equals(((c)paramObject).b)) && (this.c.equals(((c)paramObject).c));
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.engine.c
 * JD-Core Version:    0.6.0
 */