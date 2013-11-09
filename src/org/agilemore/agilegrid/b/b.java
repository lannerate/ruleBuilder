package org.agilemore.agilegrid.b;

import org.agilemore.agilegrid.e;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;

public class b extends a
{
  public b(e parame, int paramInt)
  {
    super(parame, paramInt);
  }

  public int a(GC paramGC, int paramInt1, int paramInt2)
  {
    return 20;
  }

  protected void a(int paramInt1, int paramInt2)
  {
    if (this.U.n(paramInt1, paramInt2))
      if ((this.L & 0x10) != 0)
        this.N = z;
      else if ((this.L & 0x20) != 0)
        this.N = x;
  }

  protected void a(GC paramGC, Rectangle paramRectangle)
  {
  }

  protected void e(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    Object localObject = this.U.v(paramInt1, paramInt2);
    a(paramGC, paramRectangle, localObject);
  }

  protected void a(GC paramGC, Rectangle paramRectangle, Object paramObject)
  {
    float f;
    if ((paramObject instanceof Float))
      f = ((Float)paramObject).floatValue();
    else if ((paramObject instanceof Double))
      f = ((Double)paramObject).floatValue();
    else if ((paramObject instanceof f))
      f = ((f)paramObject).a();
    else
      f = 1.0F;
    if (f > 1.0F)
      f = 1.0F;
    if (f < 0.0F)
      f = 0.0F;
    if ((this.L & 0x100) != 0)
      a(paramGC, paramRectangle, f, this.N, this.O);
    else
      b(paramGC, paramRectangle, f, this.N, this.O);
  }

  protected void a(GC paramGC, Rectangle paramRectangle, float paramFloat, Color paramColor1, Color paramColor2)
  {
    int i = Math.round(paramRectangle.width * paramFloat);
    paramGC.setForeground(paramColor1);
    paramGC.setBackground(paramColor2);
    paramGC.fillGradientRectangle(paramRectangle.x, paramRectangle.y, i, paramRectangle.height, false);
    paramGC.setBackground(t);
    paramGC.fillRectangle(paramRectangle.x + i, paramRectangle.y, paramRectangle.width - i, paramRectangle.height);
  }

  protected void b(GC paramGC, Rectangle paramRectangle, float paramFloat, Color paramColor1, Color paramColor2)
  {
    int i = Math.round(paramRectangle.width * paramFloat);
    paramGC.setBackground(paramColor2);
    paramGC.fillRectangle(paramRectangle.x, paramRectangle.y, i, paramRectangle.height);
    paramGC.setBackground(paramColor1);
    paramGC.fillRectangle(paramRectangle.x + i, paramRectangle.y, paramRectangle.width - i, paramRectangle.height);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.b.b
 * JD-Core Version:    0.6.0
 */