package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.util.NumberUtil;

public final class l extends a
  implements g
{
  public static final String b = "float";

  public l(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "float";
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

  public boolean a(g paramg)
  {
    return paramg.b();
  }

  public boolean c()
  {
    return true;
  }

  public boolean b(g paramg)
  {
    return (paramg.h()) || (paramg.k()) || (paramg.g()) || (paramg.c());
  }

  public Object f(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return new Float(0.0F);
    return Float.valueOf(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.l
 * JD-Core Version:    0.6.0
 */