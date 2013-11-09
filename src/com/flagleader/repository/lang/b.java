package com.flagleader.repository.lang;

import com.flagleader.repository.lang.b.e;
import com.flagleader.util.exception.UnsupportOperationException;
import java.util.HashMap;

public abstract class b
{
  private static HashMap a = new HashMap();
  private static b b = new e();

  public static b a()
  {
    return b;
  }

  public static b a(String paramString)
  {
    if (paramString.equalsIgnoreCase("java"))
      return b;
    Object localObject = (b)a.get(paramString);
    if (localObject == null)
    {
      if (paramString.equalsIgnoreCase("c#"))
        localObject = new com.flagleader.repository.lang.a.a();
      else
        throw new UnsupportOperationException();
      a.put(paramString, localObject);
      b = (b)localObject;
    }
    return (b)localObject;
  }

  public abstract h b();

  public abstract a c();

  public abstract d d();

  public abstract c e();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b
 * JD-Core Version:    0.6.0
 */