package com.flagleader.a;

import com.flagleader.util.collection.DynamicIterator;
import com.flagleader.util.collection.IIterator;
import com.flagleader.util.collection.IList;

public class l extends DynamicIterator
  implements T
{
  public final S d()
  {
    return (S)next();
  }

  public final S e(String paramString)
  {
    for (S localS = d(); localS != null; localS = d())
    {
      String str = localS.L();
      if ((str != null) && (str.equals(paramString)))
        return localS;
    }
    return null;
  }

  public final S f(String paramString)
  {
    for (S localS = d(); localS != null; localS = d())
    {
      String str = localS.H();
      if ((str != null) && (str.equals(paramString)))
        return localS;
    }
    return null;
  }

  public l()
  {
  }

  public l(IIterator paramIIterator)
  {
    super(paramIIterator);
  }

  public l(IList paramIList)
  {
    super(paramIList);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.l
 * JD-Core Version:    0.6.0
 */