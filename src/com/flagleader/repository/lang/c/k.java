package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import java.io.File;

public final class k extends a
  implements g
{
  public static final String b = "file";

  public k(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "file";
  }

  public boolean a(String paramString)
  {
    return true;
  }

  public boolean p()
  {
    return true;
  }

  public boolean q()
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
    if (paramg.q())
      return true;
    if (paramg.F())
      return true;
    if (paramg.p())
      try
      {
        Class localClass = getClass().getClassLoader().loadClass(this.a.d(paramg));
        if ((File.class.isAssignableFrom(localClass)) || (localClass.isAssignableFrom(File.class)))
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
    return new File(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.k
 * JD-Core Version:    0.6.0
 */