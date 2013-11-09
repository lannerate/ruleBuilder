package org.agilemore.agilegrid;

import java.util.Comparator;

class t
  implements Comparator
{
  t(r paramr)
  {
  }

  public int a(G paramG1, G paramG2)
  {
    if (paramG1.c < paramG2.c)
      return -1;
    if (paramG1.c > paramG2.c)
      return 1;
    if (paramG1.d < paramG2.d)
      return -1;
    if (paramG1.d > paramG2.d)
      return 1;
    return 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.t
 * JD-Core Version:    0.6.0
 */