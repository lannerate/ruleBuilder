package com.flagleader.repository.lang.c;

import com.flagleader.db.Sheet;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;

public final class v extends a
  implements g
{
  public static final String b = "sheet";

  public v(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "sheet";
  }

  public boolean a(String paramString)
  {
    return false;
  }

  public boolean p()
  {
    return true;
  }

  public boolean D()
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
    if (paramg.D())
      return true;
    if (paramg.F())
      return true;
    if (paramg.p())
      try
      {
        Class localClass = getClass().getClassLoader().loadClass(this.a.d(paramg));
        if ((Sheet.class.isAssignableFrom(localClass)) || (localClass.isAssignableFrom(Sheet.class)))
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
 * Qualified Name:     com.flagleader.repository.lang.c.v
 * JD-Core Version:    0.6.0
 */