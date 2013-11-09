package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.util.NumberUtil;

public final class c extends a
  implements g
{
  public static final String b = "boolean";

  public c(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "boolean";
  }

  public boolean e()
  {
    return true;
  }

  public boolean a(String paramString)
  {
    try
    {
      new Boolean(NumberUtil.formatBoolean(paramString)).booleanValue();
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public Object f(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return new Boolean(false);
    return Boolean.valueOf(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.c
 * JD-Core Version:    0.6.0
 */