package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.xml.TreeValue;

public final class B extends a
  implements g
{
  public static final String b = "tree";

  public B(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "tree";
  }

  public boolean a(String paramString)
  {
    return false;
  }

  public boolean p()
  {
    return true;
  }

  public boolean B()
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
    if (paramg.B())
      return true;
    if (paramg.F())
      return true;
    if (paramg.p())
      try
      {
        Class localClass = getClass().getClassLoader().loadClass(this.a.d(paramg));
        if ((TreeValue.class.isAssignableFrom(localClass)) || (localClass.isAssignableFrom(TreeValue.class)))
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
 * Qualified Name:     com.flagleader.repository.lang.c.B
 * JD-Core Version:    0.6.0
 */