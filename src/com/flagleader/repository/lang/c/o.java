package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import java.util.ArrayList;
import java.util.List;

public final class o extends a
  implements g
{
  public static final String b = "list<int>";

  public o(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "list<int>";
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

  public boolean Q()
  {
    return true;
  }

  private boolean R()
  {
    return true;
  }

  public g J()
  {
    return this.a.a("int");
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
    String[] arrayOfString = paramString.split(",");
    ArrayList localArrayList = new ArrayList(arrayOfString.length);
    for (int i = 0; i < arrayOfString.length; i++)
      localArrayList.add(J().f(arrayOfString[i]));
    return localArrayList;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.o
 * JD-Core Version:    0.6.0
 */