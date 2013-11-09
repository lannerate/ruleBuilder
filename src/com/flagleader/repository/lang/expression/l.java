package com.flagleader.repository.lang.expression;

import com.flagleader.repository.d.s;
import com.flagleader.repository.d.u;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class l extends a
{
  protected ArrayList e = new ArrayList();

  public l(StatementSystem paramStatementSystem, String paramString)
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
    this.b = StringUtil.replace("\r", "", this.b);
    String[] arrayOfString = this.b.trim().split("[\r\n]");
    if (paramString.startsWith("\n"))
      paramString = paramString.substring(1);
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < arrayOfString.length; i++)
      if (this.a.c(arrayOfString[i]))
        a(new A(this.a, arrayOfString[i]));
      else
        localStringBuffer.append(arrayOfString[i]).append("\n");
    paramString = localStringBuffer.toString();
    i = StatementSystem.d(paramString, 0);
    if (i >= 0)
    {
      if (i > 0)
        a(new m(this.a, paramString.substring(0, i)));
      int j = a(paramString, i);
      if (j < 0)
        throw new s(u.a("noendif.expression"));
      do
      {
        a(new n(this.a, paramString.substring(i, j)));
        i = StatementSystem.d(paramString, j);
        if (i >= 0)
        {
          if (i > 0)
            a(new m(this.a, paramString.substring(j, i)));
          j = a(paramString, i);
          if (j >= 0)
            continue;
          throw new s(u.a("noendif.expression"));
        }
        a(new m(this.a, paramString.substring(j)));
        break;
      }
      while (j > 0);
    }
    else
    {
      a(new m(this.a, paramString));
    }
  }

  protected void a(a parama)
  {
    this.e.add(parama);
  }

  private int a(String paramString, int paramInt)
  {
    int i = 1;
    int j = paramInt;
    for (int k = StatementSystem.a(paramString, j); k > 0; k = StatementSystem.a(paramString, j))
    {
      if (StatementSystem.i(paramString.substring(paramInt, k)) == i)
        return k + StatementSystem.o[4].length();
      i++;
      j = k + StatementSystem.o[4].length();
    }
    if (k > 0)
      return k + StatementSystem.o[4].length();
    return -1;
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
 * Qualified Name:     com.flagleader.repository.lang.expression.l
 * JD-Core Version:    0.6.0
 */