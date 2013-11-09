package org.agilemore.agilegrid.b;

import org.agilemore.agilegrid.aq;
import org.agilemore.agilegrid.au;
import org.agilemore.agilegrid.ax;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class e extends c
{
  public static final Image a = ax.a(e.class, "/icons/arrow_down.gif");
  public static final Image V = ax.a(e.class, "/icons/arrow_up.gif");
  public static final Color W = ax.a(22);

  public e(org.agilemore.agilegrid.e parame, int paramInt)
  {
    super(parame, paramInt);
    this.L |= 0;
    a(55);
    d(W);
  }

  protected void a(int paramInt1, int paramInt2)
  {
    if (this.U.j(paramInt1, paramInt2))
    {
      if ((this.L & 0x10) != 0)
        this.N = A;
      if ((this.L & 0x20) != 0)
      {
        this.O = y;
        this.N = x;
      }
    }
  }

  protected void e(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    String str = "";
    au localau = this.U.w();
    if ((paramInt1 == -1) && (paramInt2 >= 0) && (paramInt2 < localau.b()))
      str = localau.a(paramInt2);
    else if ((paramInt2 == -1) && (paramInt1 >= 0) && (paramInt1 < localau.a()))
      str = localau.d(paramInt1);
    else if ((paramInt1 == -1) && (paramInt2 == -1))
      str = "";
    if ((this.L & 0x200) != 0)
    {
      a(paramGC, paramRectangle, str, null, this.O, this.N);
    }
    else
    {
      int i = a();
      a(paramGC, str, i, null, i, paramRectangle.x + 3, paramRectangle.y + 2, paramRectangle.width - 6, paramRectangle.height - 4);
    }
    a(paramGC, paramRectangle, paramInt1, paramInt2, str);
  }

  protected void a(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2, Object paramObject)
  {
    au localau = this.U.w();
    aq localaq = localau.f();
    if (((this.L & 0x8) != 0) && (localaq != null) && (localaq.c() == paramInt2) && (paramInt1 == -1))
    {
      Image localImage = null;
      int i = localaq.b();
      if (i == 1)
        localImage = V;
      else if (i == 2)
        localImage = a;
      if (localImage != null)
      {
        int j = 0;
        int k = 0;
        Rectangle localRectangle = localImage.getBounds();
        j = paramRectangle.x + paramRectangle.width - 1 - localRectangle.width;
        k = paramRectangle.y + paramRectangle.height - 1 - localRectangle.height;
        if ((j >= paramRectangle.x) && (k >= paramRectangle.y))
          paramGC.drawImage(localImage, j, k);
      }
    }
  }

  public int a(GC paramGC, int paramInt1, int paramInt2)
  {
    String str1 = null;
    au localau = this.U.w();
    if ((paramInt1 == -1) && (paramInt2 >= 0))
      str1 = localau.a(paramInt2);
    else if ((paramInt1 >= 0) && (paramInt2 == -1))
      str1 = localau.d(paramInt1);
    if (str1 == null)
      return 0;
    a(paramGC);
    int i = 0;
    if ((this.L & 0x200) != 0)
    {
      String str2 = a(paramGC, str1, localau.e(paramInt1) - 6);
      i = a(paramGC, str2).y;
      i += 6;
    }
    else
    {
      i = a(paramGC, str1).x;
      i += 8;
    }
    b(paramGC);
    return i;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.b.e
 * JD-Core Version:    0.6.0
 */