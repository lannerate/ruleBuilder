package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.ab;
import org.agilemore.agilegrid.e;

public class H extends ab
{
  public H(e parame)
  {
    super(parame);
  }

  public int a()
  {
    return 10000;
  }

  public int b()
  {
    return 10000;
  }

  public int b(int paramInt)
  {
    return 140;
  }

  public G a(int paramInt1, int paramInt2)
  {
    if (((paramInt2 == 2) || (paramInt2 == 3)) && (!f(paramInt1, paramInt2)))
    {
      int i = paramInt1;
      if ((paramInt1 - i()) % 2 == 1)
        i--;
      return new G(this.b, i, 2);
    }
    return new G(this.b, paramInt1, paramInt2);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.H
 * JD-Core Version:    0.6.0
 */