package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.b.g;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;

public class p extends g
{
  public static final int a = 1024;
  public static final int V = 2048;
  public static final int W = 4096;
  private int X = 0;

  public p(e parame)
  {
    super(parame);
  }

  public p(e parame, int paramInt)
  {
    super(parame, paramInt);
    this.X = 1024;
  }

  protected Rectangle c(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    Color localColor1 = (this.X & 0x800) != 0 ? v : t;
    Color localColor2 = (this.X & 0x1000) != 0 ? v : t;
    return a(paramGC, paramRectangle, localColor1, localColor2);
  }

  public int h()
  {
    return this.X;
  }

  public void c(int paramInt)
  {
    this.X = paramInt;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.p
 * JD-Core Version:    0.6.0
 */