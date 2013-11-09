package com.flagleader.repository.lang.c;

import com.flagleader.excel.IExcelBook;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;

public final class j extends a
  implements g
{
  public static final String b = "excel";

  public j(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "excel";
  }

  public boolean a(String paramString)
  {
    return false;
  }

  public boolean p()
  {
    return true;
  }

  public boolean C()
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
    if (paramg.C())
      return true;
    if (paramg.F())
      return true;
    if (paramg.p())
      try
      {
        Class localClass = getClass().getClassLoader().loadClass(this.a.d(paramg));
        if ((IExcelBook.class.isAssignableFrom(localClass)) || (localClass.isAssignableFrom(IExcelBook.class)))
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
 * Qualified Name:     com.flagleader.repository.lang.c.j
 * JD-Core Version:    0.6.0
 */