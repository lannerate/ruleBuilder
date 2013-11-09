package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.util.NumberUtil;

public final class m extends a
  implements g
{
  public static final String b = "int";

  public m(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "int";
  }

  public boolean a(String paramString)
  {
    try
    {
      Integer.parseInt(NumberUtil.parseNumber(paramString, false));
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean b()
  {
    return true;
  }

  public boolean a(g paramg)
  {
    return paramg.b();
  }

  public boolean b(g paramg)
  {
    return (paramg.g()) || (paramg.k());
  }

  public boolean k()
  {
    return true;
  }

  public Object f(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return new Integer(0);
    return Integer.valueOf(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.m
 * JD-Core Version:    0.6.0
 */