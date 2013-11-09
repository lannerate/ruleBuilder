package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.util.NumberUtil;

public final class i extends a
  implements g
{
  public static final String b = "double";

  public i(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "double";
  }

  public boolean a(String paramString)
  {
    try
    {
      Double.parseDouble(NumberUtil.parseNumber(paramString, true));
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

  public boolean i()
  {
    return true;
  }

  public boolean a(g paramg)
  {
    return paramg.b();
  }

  public boolean b(g paramg)
  {
    return (paramg.c()) || (paramg.h()) || (paramg.k()) || (paramg.g()) || (paramg.i());
  }

  public Object f(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return new Double(0.0D);
    return Double.valueOf(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.i
 * JD-Core Version:    0.6.0
 */