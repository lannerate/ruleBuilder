package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;

public final class x extends a
  implements g
{
  public static final String b = "string[]";

  public x(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "string[]";
  }

  public boolean n()
  {
    return true;
  }

  public boolean H()
  {
    return true;
  }

  public boolean a(String paramString)
  {
    return false;
  }

  public g J()
  {
    return this.a.a("string");
  }

  public boolean a(g paramg)
  {
    if (equals(paramg))
      return true;
    if ((paramg.n()) && (J().m()))
      return true;
    return (paramg.n()) && (paramg.F());
  }

  public Object f(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return null;
    String[] arrayOfString = paramString.split(",");
    return arrayOfString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.x
 * JD-Core Version:    0.6.0
 */