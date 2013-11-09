package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.J;
import org.agilemore.agilegrid.X;
import org.agilemore.agilegrid.a.a;
import org.agilemore.agilegrid.a.d;
import org.agilemore.agilegrid.e;

public class K extends X
{
  private String[] a = { "I", "C", "A", "N", "P" };

  public K(e parame)
  {
    super(parame);
  }

  public boolean b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramInt2 == 1))
      return false;
    if ((paramInt1 == 2) && (paramInt2 == 15))
      return false;
    return super.b(paramInt1, paramInt2);
  }

  public J a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 6) && (paramInt1 <= 23))
    {
      if (paramInt2 == 15)
        return new a(this.b);
      if (paramInt2 == 17)
        return new I(this.b);
      if ((paramInt2 >= 18) && (paramInt2 <= 36))
      {
        L localL = new L(this, this.b, 8);
        localL.a(this.a);
        return localL;
      }
    }
    return super.a(paramInt1, paramInt2);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.K
 * JD-Core Version:    0.6.0
 */