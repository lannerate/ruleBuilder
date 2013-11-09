package org.agilemore.agilegrid.b;

import org.agilemore.agilegrid.e;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public class c extends a
{
  public c(e parame)
  {
    super(parame);
  }

  public c(e parame, int paramInt)
  {
    super(parame, paramInt);
  }

  protected Rectangle c(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    Color localColor1 = v;
    Color localColor2 = v;
    if (this.U.j(paramInt1, paramInt2))
    {
      if ((this.L & 0x10) != 0)
      {
        localColor1 = s;
        localColor2 = s;
      }
      if ((this.L & 0x20) != 0)
      {
        localColor1 = x;
        localColor2 = x;
      }
    }
    boolean bool = this.U.k(paramInt1, paramInt2);
    if ((this.L & 0x4) != 0)
    {
      if (bool)
      {
        Color localColor3 = K.getSystemColor(16);
        paramGC.setForeground(localColor3);
        paramGC.drawRectangle(paramRectangle.x, paramRectangle.y, paramRectangle.width, 1);
        paramGC.drawRectangle(paramRectangle.x, paramRectangle.y, 1, paramRectangle.height);
        paramRectangle.x += 1;
        paramRectangle.y += 1;
        paramRectangle.width -= 1;
        paramRectangle.height -= 1;
        return paramRectangle;
      }
      paramRectangle = a(paramGC, paramRectangle, localColor1, localColor2);
    }
    else
    {
      a(paramGC, paramRectangle, "", (bool) && ((this.L & 0x40) != 0));
      paramRectangle.x += 2;
      paramRectangle.y += 2;
      paramRectangle.width -= 4;
      paramRectangle.height -= 4;
    }
    return paramRectangle;
  }

  protected void a(GC paramGC, Rectangle paramRectangle, String paramString, boolean paramBoolean)
  {
    paramRectangle.height += 1;
    paramRectangle.width += 1;
    paramGC.setForeground(K.getSystemColor(24));
    if (paramBoolean)
      b(paramGC, paramString, a(), null, a(), paramRectangle);
    else
      a(paramGC, paramString, a(), null, a(), paramRectangle);
  }

  public void a(GC paramGC, String paramString, int paramInt1, Image paramImage, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Color paramColor)
  {
    a(paramGC, paramString, paramInt1, paramImage, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramColor, K.getSystemColor(20), K.getSystemColor(18), K.getSystemColor(17), 2, 2);
  }

  public void a(GC paramGC, String paramString, int paramInt1, Image paramImage, int paramInt2, Rectangle paramRectangle, int paramInt3, int paramInt4)
  {
    a(paramGC, paramString, paramInt1, paramImage, paramInt2, paramRectangle.x, paramRectangle.y, paramRectangle.width, paramRectangle.height, K.getSystemColor(22), K.getSystemColor(20), K.getSystemColor(18), K.getSystemColor(17), paramInt3, paramInt4);
  }

  public void a(GC paramGC, String paramString, int paramInt1, Image paramImage, int paramInt2, Rectangle paramRectangle)
  {
    a(paramGC, paramString, paramInt1, paramImage, paramInt2, paramRectangle.x, paramRectangle.y, paramRectangle.width, paramRectangle.height, K.getSystemColor(22), K.getSystemColor(20), K.getSystemColor(18), K.getSystemColor(17), 2, 2);
  }

  protected void a(GC paramGC, String paramString, int paramInt1, Image paramImage, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4, int paramInt7, int paramInt8)
  {
    Color localColor1 = paramGC.getForeground();
    Color localColor2 = paramGC.getBackground();
    Rectangle localRectangle = paramGC.getClipping();
    localRectangle.height += 1;
    localRectangle.width += 1;
    paramGC.setClipping(localRectangle);
    try
    {
      paramGC.setBackground(paramColor1);
      paramGC.setForeground(paramColor2);
      paramGC.drawLine(paramInt3, paramInt4, paramInt3, paramInt4 + paramInt6 - 1);
      paramGC.drawLine(paramInt3, paramInt4, paramInt3 + paramInt5 - 2, paramInt4);
      paramGC.setForeground(paramColor4);
      paramGC.drawLine(paramInt3 + paramInt5 - 1, paramInt4, paramInt3 + paramInt5 - 1, paramInt4 + paramInt6 - 1);
      paramGC.drawLine(paramInt3, paramInt4 + paramInt6 - 1, paramInt3 + paramInt5 - 1, paramInt4 + paramInt6 - 1);
      paramGC.setForeground(paramColor3);
      paramGC.drawLine(paramInt3 + paramInt5 - 2, paramInt4 + 1, paramInt3 + paramInt5 - 2, paramInt4 + paramInt6 - 2);
      paramGC.drawLine(paramInt3 + 1, paramInt4 + paramInt6 - 2, paramInt3 + paramInt5 - 2, paramInt4 + paramInt6 - 2);
      paramGC.fillRectangle(paramInt3 + 1, paramInt4 + 1, paramInt5 - 3, paramInt6 - 3);
      paramGC.setForeground(localColor1);
      a(paramGC, paramString, paramInt1, paramImage, paramInt2, paramInt3 + 1 + paramInt7, paramInt4 + 1 + paramInt8, paramInt5 - 3 - paramInt7, paramInt6 - 3 - paramInt8);
    }
    finally
    {
      paramGC.setForeground(localColor1);
      paramGC.setBackground(localColor2);
    }
  }

  public void b(GC paramGC, String paramString, int paramInt1, Image paramImage, int paramInt2, Rectangle paramRectangle)
  {
    a(paramGC, paramString, paramInt1, paramImage, paramInt2, paramRectangle.x, paramRectangle.y, paramRectangle.width, paramRectangle.height, K.getSystemColor(22), K.getSystemColor(18), 2, 2);
  }

  protected void a(GC paramGC, String paramString, int paramInt1, Image paramImage, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Color paramColor1, Color paramColor2, int paramInt7, int paramInt8)
  {
    Color localColor1 = paramGC.getForeground();
    Color localColor2 = paramGC.getBackground();
    try
    {
      paramGC.setBackground(paramColor1);
      paramGC.setForeground(paramColor2);
      Rectangle localRectangle = paramGC.getClipping();
      localRectangle.height += 1;
      localRectangle.width += 1;
      paramGC.setClipping(localRectangle);
      paramGC.drawRectangle(paramInt3, paramInt4, paramInt5 - 1, paramInt6 - 1);
      paramGC.fillRectangle(paramInt3 + 1, paramInt4 + 1, paramInt5 - 2, paramInt6 - 2);
      paramGC.setForeground(localColor1);
      a(paramGC, paramString, paramInt1, paramImage, paramInt2, paramInt3 + 2 + paramInt7, paramInt4 + 2 + paramInt8, paramInt5 - 3 - paramInt7, paramInt6 - 3 - paramInt8);
    }
    finally
    {
      paramGC.setForeground(localColor1);
      paramGC.setBackground(localColor2);
    }
  }

  protected void c(GC paramGC, String paramString, int paramInt1, Image paramImage, int paramInt2, Rectangle paramRectangle)
  {
    paramGC.setForeground(K.getSystemColor(2));
    paramGC.drawLine(paramRectangle.x, paramRectangle.y, paramRectangle.x + paramRectangle.width - 2, paramRectangle.y);
    paramGC.drawLine(paramRectangle.x, paramRectangle.y, paramRectangle.x, paramRectangle.y + paramRectangle.height - 2);
    paramGC.setForeground(K.getSystemColor(1));
    paramGC.drawLine(paramRectangle.x + paramRectangle.width - 1, paramRectangle.y, paramRectangle.x + paramRectangle.width - 1, paramRectangle.y + paramRectangle.height - 1);
    paramGC.drawLine(paramRectangle.x, paramRectangle.y + paramRectangle.height - 1, paramRectangle.x + paramRectangle.width - 1, paramRectangle.y + paramRectangle.height - 1);
    paramGC.setForeground(K.getSystemColor(22));
    paramGC.drawLine(paramRectangle.x + 1, paramRectangle.y + paramRectangle.height - 2, paramRectangle.x + paramRectangle.width - 2, paramRectangle.y + paramRectangle.height - 2);
    paramGC.drawLine(paramRectangle.x + paramRectangle.width - 2, paramRectangle.y + paramRectangle.height - 2, paramRectangle.x + paramRectangle.width - 2, paramRectangle.y + 1);
    paramGC.setForeground(K.getSystemColor(21));
    paramGC.setBackground(K.getSystemColor(22));
    paramGC.fillRectangle(paramRectangle.x + 2, paramRectangle.y + 2, paramRectangle.width - 4, 1);
    paramGC.fillRectangle(paramRectangle.x + 1, paramRectangle.y + 2, 2, paramRectangle.height - 4);
    paramGC.setBackground(K.getSystemColor(22));
    a(paramGC, paramString, paramInt1, paramImage, paramInt2, paramRectangle.x + 2 + 1, paramRectangle.y + 2 + 1, paramRectangle.width - 4, paramRectangle.height - 3 - 1);
  }

  protected void a(GC paramGC, String paramString, int paramInt1, Image paramImage, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Color paramColor1, Color paramColor2, Color paramColor3, int paramInt7, int paramInt8)
  {
    Color localColor1 = paramGC.getForeground();
    Color localColor2 = paramGC.getBackground();
    try
    {
      paramGC.setForeground(paramColor2);
      paramGC.drawLine(paramInt3, paramInt4, paramInt3 + paramInt5 - 1, paramInt4);
      paramGC.drawLine(paramInt3, paramInt4, paramInt3, paramInt4 + paramInt6);
      paramGC.setForeground(paramColor3);
      paramGC.drawLine(paramInt3 + paramInt5, paramInt4, paramInt3 + paramInt5, paramInt4 + paramInt6);
      paramGC.drawLine(paramInt3 + 1, paramInt4 + paramInt6, paramInt3 + paramInt5, paramInt4 + paramInt6);
      paramGC.setBackground(paramColor1);
      paramGC.fillRectangle(paramInt3 + 1, paramInt4 + 1, paramInt7, paramInt6 - 1);
      paramGC.fillRectangle(paramInt3 + 1, paramInt4 + 1, paramInt5 - 1, paramInt8);
      paramGC.setBackground(paramColor1);
      paramGC.setForeground(localColor1);
      a(paramGC, paramString, paramInt1, paramImage, paramInt2, paramInt3 + 1 + paramInt7, paramInt4 + 1 + paramInt8, paramInt5 - 1 - paramInt7, paramInt6 - 1 - paramInt8);
    }
    finally
    {
      paramGC.setForeground(localColor1);
      paramGC.setBackground(localColor2);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.b.c
 * JD-Core Version:    0.6.0
 */