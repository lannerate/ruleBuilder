package org.agilemore.agilegrid.b;

import org.agilemore.agilegrid.ax;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;

public class d extends a
{
  public static final int a = -2147483648;
  public static final int V = 1073741824;
  public static final int W = 536870912;
  public static final Image X = ax.a(d.class, "/icons/checked.gif");
  public static final Image Y = ax.a(d.class, "/icons/unchecked.gif");
  public static final Image Z = ax.a(d.class, "/icons/checked_clicked.gif");
  public static final Image aa = ax.a(d.class, "/icons/unchecked_clicked.gif");
  public static final Color ab = ax.a(206, 206, 206);
  public static final Color ac = ax.a(90, 90, 57);
  public static final Color ad = ax.a(156, 156, 123);

  public d(e parame, int paramInt)
  {
    super(parame, paramInt);
  }

  public int a(GC paramGC, int paramInt1, int paramInt2)
  {
    return X.getBounds().x + 6;
  }

  protected void a(int paramInt1, int paramInt2)
  {
    if (this.U.n(paramInt1, paramInt2))
      if ((this.L & 0x10) != 0)
      {
        this.N = z;
      }
      else if ((this.L & 0x20) != 0)
      {
        this.O = y;
        this.N = x;
      }
  }

  protected void e(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    Object localObject = this.U.v(paramInt1, paramInt2);
    if (!(localObject instanceof Boolean))
      if (localObject.toString().equalsIgnoreCase("true"))
        localObject = new Boolean(true);
      else if (localObject.toString().equalsIgnoreCase("false"))
        localObject = new Boolean(false);
    if (!(localObject instanceof Boolean))
    {
      String str = "?";
      if ((this.L & 0x200) != 0)
      {
        a(paramGC, paramRectangle, str, null, this.O, this.N);
      }
      else
      {
        int i = a();
        a(paramGC, str, i, null, i, paramRectangle.x + 3, paramRectangle.y + 2, paramRectangle.width - 6, paramRectangle.height - 4);
      }
    }
    else
    {
      boolean bool1 = this.U.k(paramInt1, paramInt2);
      boolean bool2;
      if ((this.L & 0x80000000) != 0)
      {
        bool2 = ((Boolean)localObject).booleanValue();
        if (bool2)
        {
          if ((bool1) && ((this.L & 0x40) != 0))
            a(paramGC, paramRectangle, Z, this.N);
          else
            a(paramGC, paramRectangle, X, this.N);
        }
        else if ((bool1) && ((this.L & 0x40) != 0))
          a(paramGC, paramRectangle, aa, this.N);
        else
          a(paramGC, paramRectangle, Y, this.N);
      }
      else
      {
        bool2 = ((Boolean)localObject).booleanValue();
        if ((bool1) && ((this.L & 0x40) != 0))
          a(paramGC, paramRectangle, bool2, this.N, ab);
        else
          a(paramGC, paramRectangle, bool2, this.N, this.N);
      }
    }
  }

  protected void a(GC paramGC, Rectangle paramRectangle, Image paramImage, Color paramColor)
  {
    paramGC.setForeground(paramColor);
    paramGC.setBackground(paramColor);
    paramGC.fillRectangle(paramRectangle);
    a(paramGC, "", a(), paramImage, a(), paramRectangle.x + 3, paramRectangle.y, paramRectangle.width - 3, paramRectangle.height);
  }

  protected void a(GC paramGC, Rectangle paramRectangle, boolean paramBoolean, Color paramColor1, Color paramColor2)
  {
    Rectangle localRectangle = a(paramRectangle, X);
    paramGC.setForeground(ad);
    paramGC.drawLine(localRectangle.x, localRectangle.y, localRectangle.x + localRectangle.width, localRectangle.y);
    paramGC.drawLine(localRectangle.x, localRectangle.y, localRectangle.x, localRectangle.y + localRectangle.height);
    paramGC.setForeground(ac);
    paramGC.drawLine(localRectangle.x + localRectangle.width, localRectangle.y + 1, localRectangle.x + localRectangle.width, localRectangle.y + localRectangle.height - 1);
    paramGC.drawLine(localRectangle.x, localRectangle.y + localRectangle.height, localRectangle.x + localRectangle.width, localRectangle.y + localRectangle.height);
    if (!paramColor1.equals(paramColor2))
    {
      paramGC.setBackground(paramColor2);
      paramGC.fillRectangle(localRectangle.x + 1, localRectangle.y + 1, localRectangle.width - 1, localRectangle.height - 1);
    }
    if (paramBoolean)
      c(paramGC, localRectangle);
  }

  private void c(GC paramGC, Rectangle paramRectangle)
  {
    if ((this.L & 0x40000000) != 0)
    {
      paramGC.setForeground(ad);
      paramGC.drawLine(paramRectangle.x + 3, paramRectangle.y + 2, paramRectangle.x - 2 + paramRectangle.width, paramRectangle.y - 3 + paramRectangle.height);
      paramGC.drawLine(paramRectangle.x + 2, paramRectangle.y + 3, paramRectangle.x - 3 + paramRectangle.width, paramRectangle.y - 2 + paramRectangle.height);
      paramGC.drawLine(paramRectangle.x + 3, paramRectangle.y - 2 + paramRectangle.height, paramRectangle.x - 2 + paramRectangle.width, paramRectangle.y + 3);
      paramGC.drawLine(paramRectangle.x + 2, paramRectangle.y - 3 + paramRectangle.height, paramRectangle.x - 3 + paramRectangle.width, paramRectangle.y + 2);
      paramGC.setForeground(s);
      paramGC.drawLine(paramRectangle.x + 2, paramRectangle.y + 2, paramRectangle.x - 2 + paramRectangle.width, paramRectangle.y - 2 + paramRectangle.height);
      paramGC.drawLine(paramRectangle.x + 2, paramRectangle.y - 2 + paramRectangle.height, paramRectangle.x - 2 + paramRectangle.width, paramRectangle.y + 2);
    }
    else
    {
      paramGC.setForeground(d());
      paramGC.drawLine(paramRectangle.x + 2, paramRectangle.y + paramRectangle.height - 4, paramRectangle.x + 4, paramRectangle.y + paramRectangle.height - 2);
      paramGC.drawLine(paramRectangle.x + 2, paramRectangle.y + paramRectangle.height - 5, paramRectangle.x + 5, paramRectangle.y + paramRectangle.height - 3);
      paramGC.drawLine(paramRectangle.x + 2, paramRectangle.y + paramRectangle.height - 6, paramRectangle.x + 4, paramRectangle.y + paramRectangle.height - 4);
      for (int i = 1; i < 4; i++)
        paramGC.drawLine(paramRectangle.x + 2 + i, paramRectangle.y + paramRectangle.height - 3, paramRectangle.x + paramRectangle.width - 2, paramRectangle.y + 1 + i);
    }
  }

  protected Rectangle a(Rectangle paramRectangle, Image paramImage)
  {
    Rectangle localRectangle = paramImage.getBounds();
    localRectangle.x -= 2;
    localRectangle.y -= 2;
    localRectangle.height -= 4;
    localRectangle.width -= 4;
    if ((a() & 0x7) != 0)
      paramRectangle.x += (paramRectangle.width - localRectangle.width) / 2;
    else if ((a() & 0x4) != 0)
      localRectangle.x = (paramRectangle.x + paramRectangle.width - localRectangle.width - 2);
    else
      paramRectangle.x += 2;
    if ((a() & 0x30) != 0)
      paramRectangle.y += (paramRectangle.height - localRectangle.height) / 2;
    else if ((a() & 0x20) != 0)
      localRectangle.y = (paramRectangle.y + paramRectangle.height - localRectangle.height - 2);
    else
      paramRectangle.y += 2;
    return localRectangle;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.b.d
 * JD-Core Version:    0.6.0
 */