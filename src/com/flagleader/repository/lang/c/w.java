package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.util.NumberUtil;

public final class w extends a
  implements g
{
  public static final String b = "short";

  public w(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "short";
  }

  public boolean a(String paramString)
  {
    try
    {
      Short.parseShort(NumberUtil.parseNumber(paramString, false));
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

  public boolean g()
  {
    return true;
  }

  public boolean b(g paramg)
  {
    return paramg.g();
  }

  public boolean a(g paramg)
  {
    return paramg.b();
  }

  public Object f(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return new Short(0);
    return Short.valueOf(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.w
 * JD-Core Version:    0.6.0
 */