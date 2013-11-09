package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;

public final class e extends a
  implements g
{
  public static final String b = "char";

  public e(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "char";
  }

  public boolean a(String paramString)
  {
    return paramString.length() == 1;
  }

  public boolean d()
  {
    return true;
  }

  public Object f(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return null;
    return new Character(paramString.charAt(0));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.e
 * JD-Core Version:    0.6.0
 */