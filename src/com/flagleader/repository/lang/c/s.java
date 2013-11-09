package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.util.NumberUtil;

public final class s extends a
  implements g
{
  public static final String b = "long";

  public s(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "long";
  }

  public boolean a(String paramString)
  {
    try
    {
      Long.parseLong(NumberUtil.parseNumber(paramString, false));
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

  public boolean h()
  {
    return true;
  }

  public boolean a(g paramg)
  {
    return paramg.b();
  }

  public boolean b(g paramg)
  {
    return (paramg.k()) || (paramg.g()) || (paramg.h());
  }

  public Object f(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return new Long(0L);
    return Long.valueOf(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.s
 * JD-Core Version:    0.6.0
 */