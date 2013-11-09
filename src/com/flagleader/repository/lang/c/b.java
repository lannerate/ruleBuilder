package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;

public final class b extends a
  implements g
{
  public static final String b = "byte[]";

  public b(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "byte[]";
  }

  public boolean n()
  {
    return true;
  }

  public boolean z()
  {
    return true;
  }

  public boolean a(String paramString)
  {
    return true;
  }

  public g J()
  {
    return this.a.a("byte");
  }

  public Object f(String paramString)
  {
    if (paramString == null)
      return null;
    return paramString.getBytes();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.b
 * JD-Core Version:    0.6.0
 */