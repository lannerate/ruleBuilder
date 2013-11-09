package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import java.util.Map;

public final class t extends a
  implements g
{
  public static final String b = "map";

  public t(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "map";
  }

  public boolean a(String paramString)
  {
    return false;
  }

  public boolean p()
  {
    return true;
  }

  public boolean o()
  {
    return true;
  }

  public boolean Q()
  {
    return true;
  }

  public boolean O()
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
    if (paramg.o())
      return true;
    if (paramg.F())
      return true;
    if (paramg.p())
      try
      {
        Class localClass = getClass().getClassLoader().loadClass(this.a.d(paramg));
        if ((Map.class.isAssignableFrom(localClass)) || (localClass.isAssignableFrom(Map.class)))
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
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.t
 * JD-Core Version:    0.6.0
 */