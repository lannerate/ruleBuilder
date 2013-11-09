package com.flagleader.repository.lang.c;

import com.flagleader.engine.Property;
import com.flagleader.repository.lang.h;
import com.flagleader.util.DateUtil;
import java.text.ParseException;
import java.util.Date;

public final class g extends a
  implements com.flagleader.repository.lang.g
{
  public static final String b = "date";

  public g(h paramh)
  {
    super(paramh);
  }

  public String K()
  {
    return "date";
  }

  public boolean a(String paramString)
  {
    try
    {
      DateUtil.formatDate(paramString);
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

  public boolean v()
  {
    return true;
  }

  public boolean G()
  {
    return true;
  }

  private boolean R()
  {
    return true;
  }

  public boolean Q()
  {
    return true;
  }

  public boolean a(com.flagleader.repository.lang.g paramg)
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
      return Property.getInstance().parseDate(paramString);
    }
    catch (ParseException localParseException)
    {
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.g
 * JD-Core Version:    0.6.0
 */