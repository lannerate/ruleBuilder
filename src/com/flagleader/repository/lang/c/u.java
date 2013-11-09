package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;

public final class u extends a
  implements g
{
  public static final String b = "Object";

  public u(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "Object";
  }

  public boolean a(String paramString)
  {
    return true;
  }

  public boolean p()
  {
    return true;
  }

  public boolean F()
  {
    return true;
  }

  public boolean Q()
  {
    return true;
  }

  public boolean a(g paramg)
  {
    if (equals(paramg))
      return true;
    if (paramg.p())
      return true;
    return paramg.F();
  }

  public Object f(String paramString)
  {
    return paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.u
 * JD-Core Version:    0.6.0
 */