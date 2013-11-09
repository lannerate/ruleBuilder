package com.flagleader.repository.lang.expression;

import java.util.ArrayList;

public class j extends a
{
  protected ArrayList e = new ArrayList();

  public j(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    String str = f(paramString);
    g(str);
  }

  private boolean e(String paramString)
  {
    for (int i = 0; i < StatementSystem.a.length; i++)
      if (paramString.startsWith(StatementSystem.a[i]))
        return true;
    return false;
  }

  private String f(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    for (int i = 0; i < StatementSystem.a.length; i++)
    {
      if (!paramString.startsWith(StatementSystem.a[i]))
        continue;
      localStringBuffer.replace(0, StatementSystem.a[i].length(), "");
      localStringBuffer = new StringBuffer(localStringBuffer.toString().trim());
      if ((localStringBuffer.toString().startsWith("(")) && (localStringBuffer.toString().endsWith(")")))
        return StatementSystem.a[i] + localStringBuffer.substring(1, localStringBuffer.length() - 1);
      if ((localStringBuffer.toString().startsWith("（")) && (localStringBuffer.toString().endsWith("）")))
        return StatementSystem.a[i] + localStringBuffer.substring(1, localStringBuffer.length() - 1);
    }
    if ((localStringBuffer.toString().startsWith("(")) && (localStringBuffer.toString().endsWith(")")))
      return localStringBuffer.substring(1, localStringBuffer.length() - 1);
    if ((localStringBuffer.toString().startsWith("（")) && (localStringBuffer.toString().endsWith("）")))
      return localStringBuffer.substring(1, localStringBuffer.length() - 1);
    return paramString;
  }

  private String a(String paramString, String[] paramArrayOfString)
  {
    int i = -1;
    String str = null;
    for (int j = 0; j < paramArrayOfString.length; j++)
    {
      int k = paramString.indexOf(paramArrayOfString[j]);
      if ((k < 0) || ((i != -1) && (k >= i)))
        continue;
      str = paramArrayOfString[j];
      i = k;
    }
    return str;
  }

  private void g(String paramString)
  {
    String str = a(paramString, StatementSystem.a);
    if (str != null)
    {
      int i = paramString.indexOf(str);
      if (i >= 0)
      {
        int j = 0;
        while (i >= 0)
        {
          if (i > 0)
            a(new w(this.a, paramString.substring(j, i).trim()));
          j = i;
          str = a(paramString.substring(j + str.length()), StatementSystem.a);
          if (str != null)
            i = paramString.indexOf(str, j + str.length());
          else
            i = -1;
        }
        a(new w(this.a, paramString.substring(j).trim()));
        return;
      }
    }
    a(new w(this.a, paramString.trim()));
  }

  public ArrayList b()
  {
    return this.e;
  }

  protected void a(w paramw)
  {
    this.e.add(paramw);
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < this.e.size(); i++)
      localStringBuffer.append(this.e.get(i));
    return localStringBuffer.toString();
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.j
 * JD-Core Version:    0.6.0
 */