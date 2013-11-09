package org.agilemore.agilegrid.b;

import org.agilemore.agilegrid.e;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;

public class g extends a
{
  public g(e parame)
  {
    super(parame);
  }

  public g(e parame, int paramInt)
  {
    super(parame, paramInt);
  }

  protected void a(int paramInt1, int paramInt2)
  {
    if (this.U.n(paramInt1, paramInt2))
      this.N = z;
  }

  protected void e(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    Object localObject = this.U.v(paramInt1, paramInt2);
    if (localObject == null)
      return;
    if ((this.L & 0x200) != 0)
    {
      a(paramGC, paramRectangle, localObject.toString(), null, this.O, this.N);
    }
    else
    {
      int i = a();
      a(paramGC, localObject.toString(), i, null, i, paramRectangle.x + 3, paramRectangle.y + 2, paramRectangle.width - 6, paramRectangle.height - 4);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.b.g
 * JD-Core Version:    0.6.0
 */