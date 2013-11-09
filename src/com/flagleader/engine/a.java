package com.flagleader.engine;

import java.util.List;

public class a
{
  public String a;
  public String b;
  public List c;

  public a(MultiExpression paramMultiExpression, String paramString1, String paramString2, List paramList)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramList;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof a))
      return (this.a.equals(((a)paramObject).a)) && (this.b.equals(((a)paramObject).b)) && (this.c.equals(((a)paramObject).c));
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.engine.a
 * JD-Core Version:    0.6.0
 */