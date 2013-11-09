package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;

public final class d extends a
  implements g
{
  public static final String b = "byte";

  public d(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "byte";
  }

  public boolean a(String paramString)
  {
    try
    {
      Byte.parseByte(paramString);
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean f()
  {
    return true;
  }

  public Object f(String paramString)
  {
    if (paramString == null)
      return null;
    return Byte.valueOf(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.d
 * JD-Core Version:    0.6.0
 */