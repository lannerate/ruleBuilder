package com.flagleader.a;

import com.flagleader.util.collection.DynamicList;
import java.io.Serializable;

public class m extends DynamicList
  implements U, Serializable
{
  protected boolean check(Object paramObject)
  {
    return paramObject instanceof S;
  }

  public final S d(int paramInt)
  {
    return (S)get(paramInt);
  }

  public final S e(String paramString)
  {
    int i = size();
    for (int j = 0; j < i; j++)
    {
      S localS = d(j);
      String str = localS.L();
      if ((str != null) && (str.equals(paramString)))
        return localS;
    }
    return null;
  }

  public final S f(String paramString)
  {
    int i = 0;
    int j = size();
    while (i < j)
    {
      S localS = d(i);
      String str = localS.H();
      if (str == null)
        str = localS.L();
      if ((str != null) && (str.equals(paramString)))
        return localS;
      i++;
    }
    return null;
  }

  public final T d()
  {
    return new l(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.m
 * JD-Core Version:    0.6.0
 */