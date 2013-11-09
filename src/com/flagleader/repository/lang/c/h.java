package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.util.StringUtil;
import java.math.BigDecimal;

public final class h extends a
  implements g
{
  public static final String b = "decimal";

  public h(com.flagleader.repository.lang.h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "decimal";
  }

  public boolean a(String paramString)
  {
    if (StringUtil.isEmpty(paramString))
      return true;
    try
    {
      new BigDecimal(paramString);
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean j()
  {
    return true;
  }

  public boolean p()
  {
    return true;
  }

  public boolean Q()
  {
    return true;
  }

  private boolean R()
  {
    return true;
  }

  public boolean a(g paramg)
  {
    if (equals(paramg))
      return true;
    if (paramg.j())
      return true;
    if (paramg.F())
      return true;
    if (paramg.p())
      try
      {
        Class localClass = getClass().getClassLoader().loadClass(this.a.d(paramg));
        if ((BigDecimal.class.isAssignableFrom(localClass)) || (localClass.isAssignableFrom(BigDecimal.class)))
          return true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        return false;
      }
    return false;
  }

  public Object f(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return new BigDecimal(0);
    return new BigDecimal(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.h
 * JD-Core Version:    0.6.0
 */