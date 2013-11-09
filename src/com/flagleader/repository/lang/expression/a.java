package com.flagleader.repository.lang.expression;

import com.flagleader.util.StringUtil;

public abstract class a
  implements e
{
  protected StatementSystem a;
  protected String b;
  public static String[] c = { "(", "（" };
  public static String[] d = { ")", "）" };

  public a(StatementSystem paramStatementSystem, String paramString)
  {
    this.a = paramStatementSystem;
    this.b = paramString;
  }

  public boolean b_()
  {
    if (StringUtil.isEmpty(this.b.trim()))
      return true;
    for (int i = 0; i < this.b.length(); i++)
      if (!Character.isWhitespace(this.b.charAt(i)))
        return false;
    return true;
  }

  protected static boolean a(String paramString)
  {
    for (int i = 0; i < d.length; i++)
      if (paramString.indexOf(d[i]) >= 0)
        return true;
    return false;
  }

  protected static boolean b(String paramString)
  {
    for (int i = 0; i < c.length; i++)
      if (paramString.indexOf(c[i]) >= 0)
        return true;
    return false;
  }

  protected static boolean c(String paramString)
  {
    for (int i = 0; i < d.length; i++)
      if (paramString.endsWith(d[i]))
        return true;
    return false;
  }

  protected static boolean d(String paramString)
  {
    for (int i = 0; i < c.length; i++)
      if (paramString.startsWith(c[i]))
        return true;
    return false;
  }

  public String toString()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.a
 * JD-Core Version:    0.6.0
 */