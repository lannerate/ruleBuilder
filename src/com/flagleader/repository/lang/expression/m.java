package com.flagleader.repository.lang.expression;

import com.flagleader.repository.d.s;
import com.flagleader.repository.d.u;
import java.util.ArrayList;
import java.util.List;

public class m extends a
{
  private String e;
  private c f;
  private b g;
  private l h;

  public m(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    e(paramString);
  }

  public List a(List paramList)
  {
    if (paramList == null)
      paramList = new ArrayList();
    if (this.f != null)
      paramList.add(this.f.b());
    if (this.g != null)
      paramList.add(this.g.b());
    return paramList;
  }

  private void e(String paramString)
  {
    if (paramString.startsWith("\n"))
      paramString = paramString.substring(1);
    int i = 0;
    int j = StatementSystem.a(paramString, StatementSystem.o[0], i);
    int k = StatementSystem.a(paramString, StatementSystem.o[2], i);
    int m = StatementSystem.a(paramString, StatementSystem.o[3], i);
    int n;
    if (j > 0)
    {
      this.e = "if";
      n = StatementSystem.e(paramString, j);
      if (n < 0)
        throw new s(u.a("noendif.expression", new String[] { paramString }));
      this.f = new c(this.a, paramString.substring(j, n).trim());
      if (StatementSystem.d(paramString, n) > 0)
        this.h = new l(this.a, paramString.substring(n + StatementSystem.o[1].length() + 1));
      else
        this.g = new b(this.a, paramString.substring(n + StatementSystem.o[1].length() + 1));
    }
    else if (k > 0)
    {
      this.e = "else if";
      n = StatementSystem.e(paramString, k);
      if (n < 0)
        throw new s(u.a("noendif.expression", new String[] { paramString }));
      this.f = new c(this.a, paramString.substring(k, n).trim());
      if (StatementSystem.d(paramString, n) > 0)
        this.h = new l(this.a, paramString.substring(n + StatementSystem.o[1].length() + 1));
      else
        this.g = new b(this.a, paramString.substring(n + StatementSystem.o[1].length() + 1));
    }
    else if (m > 0)
    {
      this.e = "else";
      if (StatementSystem.d(paramString, i) > 0)
        this.h = new l(this.a, paramString.substring(i + StatementSystem.o[3].length() + 1));
      else
        this.g = new b(this.a, paramString.substring(i + StatementSystem.o[3].length() + 1));
    }
    else
    {
      this.e = "";
      if (StatementSystem.d(paramString, i) > 0)
        this.h = new l(this.a, paramString.substring(i));
      else
        this.g = new b(this.a, paramString.substring(i));
    }
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }

  public String b()
  {
    return this.e;
  }

  public c c()
  {
    return this.f;
  }

  public b d()
  {
    return this.g;
  }

  public l e()
  {
    return this.h;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.m
 * JD-Core Version:    0.6.0
 */