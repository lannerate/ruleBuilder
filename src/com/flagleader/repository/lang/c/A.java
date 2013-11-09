package com.flagleader.repository.lang.c;

import com.flagleader.engine.Property;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.util.DateUtil;
import java.text.ParseException;
import java.util.Date;

public final class A extends a
  implements g
{
  public static final String b = "time";

  public A(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "time";
  }

  public boolean a(String paramString)
  {
    try
    {
      DateUtil.formatTime(paramString);
      return true;
    }
    catch (ParseException localParseException)
    {
    }
    return false;
  }

  public boolean p()
  {
    return true;
  }

  public boolean G()
  {
    return true;
  }

  public boolean w()
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
    if (paramg.G())
      return true;
    if (paramg.F())
      return true;
    if ((p()) && (paramg.p()))
      try
      {
        Class localClass = getClass().getClassLoader().loadClass(this.a.d(paramg));
        if ((Date.class.isAssignableFrom(localClass)) || (localClass.isAssignableFrom(Date.class)))
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
    try
    {
      return Property.getInstance().parseTime(paramString);
    }
    catch (ParseException localParseException)
    {
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.A
 * JD-Core Version:    0.6.0
 */