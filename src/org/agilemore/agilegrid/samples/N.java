package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.e;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

class N extends p
{
  N(M paramM, e parame)
  {
    super(parame);
  }

  protected void e(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    if (!this.U.n(paramInt1, paramInt2))
    {
      paramGC.setBackground(K.getSystemColor(22));
      paramGC.fillRectangle(paramRectangle);
    }
    else
    {
      super.e(paramGC, paramRectangle, paramInt1, paramInt2);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.N
 * JD-Core Version:    0.6.0
 */