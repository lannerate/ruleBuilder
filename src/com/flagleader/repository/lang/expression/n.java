package com.flagleader.repository.lang.expression;

import java.util.ArrayList;
import java.util.List;

public class n extends a
{
  protected ArrayList e = new ArrayList();

  public n(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    e(paramString);
  }

  public List a(List paramList)
  {
    if (paramList == null)
      paramList = new ArrayList();
    for (int i = 0; i < this.e.size(); i++)
      if ((this.e.get(i) instanceof m))
      {
        ((m)this.e.get(i)).a(paramList);
      }
      else
      {
        if (!(this.e.get(i) instanceof n))
          continue;
        ((n)this.e.get(i)).a(paramList);
      }
    return paramList;
  }

  private void e(String paramString)
  {
    if (paramString.startsWith("\n"))
      paramString = paramString.substring(1);
    int i = 0;
    for (int j = a(paramString, i + StatementSystem.o[0].length()); j > 0; j = a(paramString, i + StatementSystem.o[2].length()))
    {
      a(new m(this.a, paramString.substring(i, j)));
      i = j;
    }
    if (i == 0)
      j = b(paramString, i + StatementSystem.o[0].length());
    else
      j = b(paramString, i);
    if (j > 0)
    {
      a(new m(this.a, paramString.substring(i, j)));
      i = j;
    }
    if (i < paramString.length() - 1)
      a(new m(this.a, paramString.substring(i)));
  }

  private int a(String paramString, int paramInt)
  {
    int i = 1;
    int j = paramInt;
    for (int k = StatementSystem.b(paramString, j); k > 0; k = StatementSystem.b(paramString, j))
    {
      if (StatementSystem.a(paramString.substring(paramInt, k), StatementSystem.o[0]) == StatementSystem.a(paramString.substring(paramInt, k), StatementSystem.o[4]))
        return k;
      i++;
      j = k + StatementSystem.o[2].length();
    }
    if (k > 0)
      return k;
    return -1;
  }

  private int b(String paramString, int paramInt)
  {
    int i = 1;
    int j = paramInt;
    for (int k = StatementSystem.c(paramString, j); k > 0; k = StatementSystem.c(paramString, j))
    {
      if (StatementSystem.a(paramString.substring(paramInt, k), StatementSystem.o[0]) == StatementSystem.a(paramString.substring(paramInt, k), StatementSystem.o[4]))
        return k;
      i++;
      j = k + StatementSystem.o[3].length();
    }
    if (k > 0)
      return k;
    return -1;
  }

  protected void a(a parama)
  {
    this.e.add(parama);
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }

  public ArrayList b()
  {
    return this.e;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.n
 * JD-Core Version:    0.6.0
 */