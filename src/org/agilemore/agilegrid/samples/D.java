package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.V;
import org.agilemore.agilegrid.e;

public class D extends V
{
  public D(e parame, int paramInt1, int paramInt2)
  {
    super(parame, paramInt1, paramInt2);
  }

  public int a(Object paramObject1, Object paramObject2, int paramInt1, int paramInt2)
  {
    String str1 = (String)paramObject1;
    int j;
    int i;
    try
    {
      j = str1.indexOf(' ');
      if (j > 0)
        i = Integer.parseInt(str1.substring(0, j));
      else
        return -1;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      return 1;
    }
    String str2 = (String)paramObject2;
    int k;
    try
    {
      j = str2.indexOf(' ');
      if (j > 0)
        k = Integer.parseInt(str2.substring(0, j));
      else
        return -1;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      return -1;
    }
    if (i < k)
      return -1;
    if (i > k)
      return 1;
    return 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.D
 * JD-Core Version:    0.6.0
 */