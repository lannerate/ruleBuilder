package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public final class p extends a
  implements g
{
  public static final String b = "list<list>";

  public p(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "list<list>";
  }

  public boolean a(String paramString)
  {
    return false;
  }

  public boolean p()
  {
    return true;
  }

  public boolean s()
  {
    return true;
  }

  public boolean t()
  {
    return true;
  }

  public boolean P()
  {
    return true;
  }

  public g J()
  {
    return this.a.a("list");
  }

  public boolean Q()
  {
    return true;
  }

  private boolean R()
  {
    return true;
  }

  public boolean u()
  {
    return true;
  }

  public boolean a(g paramg)
  {
    if (equals(paramg))
      return true;
    if ((paramg.s()) && (J().a(paramg.J())))
      return true;
    if (paramg.F())
      return true;
    if (paramg.p())
      try
      {
        Class localClass = getClass().getClassLoader().loadClass(this.a.d(paramg));
        if ((List.class.isAssignableFrom(localClass)) || (localClass.isAssignableFrom(List.class)))
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
      return null;
    String[] arrayOfString1 = paramString.split(";");
    ArrayList localArrayList1 = new ArrayList(arrayOfString1.length);
    for (int i = 0; (i < arrayOfString1.length) && (arrayOfString1[i].length() > 0); i++)
    {
      String[] arrayOfString2 = StringUtil.split(arrayOfString1[i], ",");
      ArrayList localArrayList2 = new ArrayList(arrayOfString2.length);
      for (int j = 0; j < arrayOfString2.length; j++)
        localArrayList2.add(arrayOfString2[j]);
      localArrayList1.add(localArrayList2);
    }
    return localArrayList1;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.p
 * JD-Core Version:    0.6.0
 */