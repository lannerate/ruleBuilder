package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.e;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public class J extends p
{
  public J(e parame)
  {
    super(parame);
  }

  protected void e(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 6) && (paramInt1 <= 23) && (paramInt2 == 17))
    {
      String str = (String)this.U.v(paramInt1, paramInt2);
      if ("normal".equals(str))
        paramGC.setBackground(K.getSystemColor(5));
      else if ("warning".equals(str))
        paramGC.setBackground(K.getSystemColor(7));
      else if ("delay".equals(str))
        paramGC.setBackground(K.getSystemColor(3));
      else
        paramGC.setBackground(K.getSystemColor(15));
      int i = 14;
      int j = 14;
      int k = paramRectangle.x + (paramRectangle.width - i) / 2;
      int m = paramRectangle.y + (paramRectangle.height - j) / 2;
      paramGC.fillOval(k, m, i, j);
    }
    else
    {
      super.e(paramGC, paramRectangle, paramInt1, paramInt2);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.J
 * JD-Core Version:    0.6.0
 */