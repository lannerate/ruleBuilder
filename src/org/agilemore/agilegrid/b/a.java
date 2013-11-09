package org.agilemore.agilegrid.b;

import java.util.HashMap;
import java.util.Map;
import org.agilemore.agilegrid.an;
import org.agilemore.agilegrid.au;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public abstract class a
  implements an
{
  protected static final Display K = Display.getCurrent();
  protected int L = 0;
  protected int M = 49;
  protected Color N;
  protected Color O;
  protected Color P;
  protected Color Q;
  protected Font R = null;
  protected Font S = null;
  protected Font T;
  protected e U = null;
  private static GC a;
  private static Map V = new HashMap();

  public a(e parame)
  {
    this(parame, 148);
  }

  public a(e parame, int paramInt)
  {
    this.U = parame;
    this.L |= paramInt;
  }

  public void b(int paramInt)
  {
    this.L = paramInt;
  }

  public int g()
  {
    return this.L;
  }

  public void a(int paramInt)
  {
    this.M = paramInt;
  }

  public int a()
  {
    return this.M;
  }

  public void a(Color paramColor)
  {
    this.O = paramColor;
  }

  public void b(Color paramColor)
  {
    this.P = paramColor;
  }

  public Color b()
  {
    if (this.P == null)
      this.P = s;
    return this.P;
  }

  public void c(Color paramColor)
  {
    this.N = paramColor;
  }

  public void d(Color paramColor)
  {
    this.Q = paramColor;
  }

  public Color c()
  {
    if (this.Q == null)
      this.Q = t;
    return this.Q;
  }

  public Color d()
  {
    return this.O != null ? this.O : this.P;
  }

  public Color e()
  {
    return this.N != null ? this.N : this.Q;
  }

  public void a(Font paramFont)
  {
    this.T = paramFont;
  }

  public Font f()
  {
    return this.T;
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      this.L |= 128;
    else
      this.L &= -129;
  }

  public int a(GC paramGC, int paramInt1, int paramInt2)
  {
    Object localObject = this.U.v(paramInt1, paramInt2);
    if (localObject == null)
      return 0;
    a(paramGC);
    int i = 0;
    if ((this.L & 0x200) != 0)
    {
      au localau = this.U.w();
      String str = a(paramGC, localObject.toString(), localau.e(paramInt1) - 6);
      i = a(paramGC, str).y;
      i += 6;
    }
    else
    {
      i = a(paramGC, localObject.toString()).x;
      i += 8;
    }
    b(paramGC);
    return i;
  }

  public void a(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    a(paramGC);
    b(paramGC, paramRectangle, paramInt1, paramInt2);
    Rectangle localRectangle = c(paramGC, paramRectangle, paramInt1, paramInt2);
    d(paramGC, localRectangle, paramInt1, paramInt2);
    if (((this.L & 0x80) != 0) && (this.U.w().g(paramInt1, paramInt2) != null))
      b(paramGC, paramRectangle);
    if ((this.U.l(paramInt1, paramInt2)) && (!this.U.d()))
      paramGC.drawFocus(paramRectangle.x, paramRectangle.y, paramRectangle.width, paramRectangle.height);
    b(paramGC);
  }

  protected void b(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    Color localColor1 = u;
    Color localColor2 = u;
    if ((this.L & 0x20) != 0)
    {
      localColor1 = x;
      localColor2 = x;
    }
    if ((this.U.getStyle() & 0x80000000) == -2147483648)
    {
      localColor1 = t;
      localColor2 = t;
    }
    a(paramGC, paramRectangle, localColor1, localColor2);
  }

  protected Rectangle c(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    return paramRectangle;
  }

  protected Rectangle a(GC paramGC, Rectangle paramRectangle, Color paramColor1, Color paramColor2)
  {
    int i = this.U.B();
    paramGC.setBackground(paramColor2);
    paramGC.fillRectangle(paramRectangle.x, paramRectangle.y + paramRectangle.height, paramRectangle.width + i, i);
    paramGC.setBackground(paramColor1);
    paramGC.fillRectangle(paramRectangle.x + paramRectangle.width, paramRectangle.y, i, paramRectangle.height);
    return paramRectangle;
  }

  protected void a(GC paramGC)
  {
    this.R = paramGC.getFont();
    if (this.T == null)
      this.T = K.getSystemFont();
    if (((this.L & 0x1) != 0) || ((this.L & 0x2) != 0))
    {
      FontData[] arrayOfFontData = this.T.getFontData();
      int i = 0;
      if ((this.L & 0x1) != 0)
        i |= 1;
      if ((this.L & 0x2) != 0)
        i |= 2;
      for (int j = 0; j < arrayOfFontData.length; j++)
        arrayOfFontData[j].setStyle(i);
      this.S = new Font(K, arrayOfFontData);
      paramGC.setFont(this.S);
    }
    else
    {
      paramGC.setFont(this.T);
    }
  }

  protected void b(GC paramGC)
  {
    if (this.S != null)
    {
      this.S.dispose();
      this.S = null;
    }
    paramGC.setFont(this.R);
  }

  protected void d(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    this.O = b();
    this.N = c();
    a(paramInt1, paramInt2);
    a(paramGC, paramRectangle);
    e(paramGC, paramRectangle, paramInt1, paramInt2);
  }

  protected void e(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    Object localObject = this.U.v(paramInt1, paramInt2);
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

  protected void a(int paramInt1, int paramInt2)
  {
  }

  protected void a(GC paramGC, Rectangle paramRectangle)
  {
    paramGC.setForeground(this.O);
    paramGC.setBackground(this.N);
    paramGC.fillRectangle(paramRectangle);
  }

  protected void a(GC paramGC, String paramString, int paramInt1, Image paramImage, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Point localPoint1 = a(paramGC, paramString);
    Object localObject;
    Point localPoint2;
    if (paramImage != null)
    {
      localObject = paramImage.getBounds();
      localPoint2 = new Point(((Rectangle)localObject).width, ((Rectangle)localObject).height);
    }
    else
    {
      localPoint2 = new Point(0, 0);
    }
    if ((paramImage == null) && ((paramInt1 & 0xF) == 7))
    {
      localObject = a(paramGC, paramString);
      int j = (paramInt5 - ((Point)localObject).x) / 2;
      if (j > 0)
        a(paramGC, paramString, paramInt1, paramInt3 + j, paramInt4, paramInt5, paramInt6);
      else
        a(paramGC, paramString, paramInt1, paramInt3, paramInt4, paramInt5, paramInt6);
      return;
    }
    int i;
    if (((paramString == null) || (paramString.length() == 0)) && ((paramInt2 & 0xF) == 7))
    {
      i = (paramInt5 - localPoint2.x) / 2;
      a(paramGC, paramImage, paramInt2, paramInt3 + i, paramInt4, paramInt6);
      return;
    }
    if ((paramInt1 & 0xF) == 1)
    {
      switch (paramInt2 & 0xF)
      {
      case 0:
        localPoint1.x = a(paramGC, paramString, paramInt1, paramInt3, paramInt4, paramInt5, paramInt6);
        break;
      case 1:
        localPoint1.x = a(paramGC, paramString, paramInt1, paramInt3 + localPoint2.x, paramInt4, paramInt5 - localPoint2.x, paramInt6);
        a(paramGC, paramImage, paramInt2, paramInt3, paramInt4, paramInt6);
        break;
      case 4:
        localPoint1.x = a(paramGC, paramString, paramInt1, paramInt3, paramInt4, paramInt5 - localPoint2.x, paramInt6);
        a(paramGC, paramImage, paramInt2, paramInt3 + paramInt5 - localPoint2.x, paramInt4, paramInt6);
        break;
      case 5:
        localPoint1.x = a(paramGC, paramString, paramInt1, paramInt3, paramInt4, paramInt5 - localPoint2.x, paramInt6);
        a(paramGC, paramImage, paramInt2, paramInt3 + localPoint1.x, paramInt4, paramInt6);
        break;
      case 6:
        localPoint1.x = a(paramGC, paramString, paramInt1, paramInt3, paramInt4, paramInt5 - localPoint2.x, paramInt6);
        i = (paramInt5 - localPoint1.x - localPoint2.x) / 2;
        a(paramGC, paramImage, paramInt2, paramInt3 + localPoint1.x + i, paramInt4, paramInt6);
        break;
      case 2:
      case 3:
      default:
        throw new SWTException("Unknown alignment for text: " + (paramInt2 & 0xF));
      }
      return;
    }
    if ((paramInt1 & 0xF) == 4)
      switch (paramInt2 & 0xF)
      {
      case 0:
        localPoint1.x = a(paramGC, paramString, paramInt1, paramInt3, -1000, paramInt5, paramInt6);
        a(paramGC, paramString, paramInt1, paramInt3 + paramInt5 - localPoint1.x, paramInt4, paramInt5, paramInt6);
        break;
      case 1:
        localPoint1.x = a(paramGC, paramString, paramInt1, paramInt3, -1000, paramInt5 - localPoint2.x, paramInt6);
        a(paramGC, paramString, paramInt1, paramInt3 + paramInt5 - localPoint1.x, paramInt4, paramInt5 - localPoint2.x, paramInt6);
        a(paramGC, paramImage, paramInt2, paramInt3, paramInt4, paramInt6);
        break;
      case 2:
        localPoint1.x = a(paramGC, paramString, paramInt1, paramInt3, -1000, paramInt5 - localPoint2.x, paramInt6);
        a(paramGC, paramString, paramInt1, paramInt3 + paramInt5 - localPoint1.x, paramInt4, paramInt5 - localPoint2.x, paramInt6);
        a(paramGC, paramImage, paramInt2, paramInt3 + paramInt5 - (localPoint1.x + localPoint2.x), paramInt4, paramInt6);
        break;
      case 3:
        localPoint1.x = a(paramGC, paramString, paramInt1, paramInt3, -1000, paramInt5 - localPoint2.x, paramInt6);
        a(paramGC, paramString, paramInt1, paramInt3 + paramInt5 - localPoint1.x, paramInt4, paramInt5 - localPoint2.x, paramInt6);
        i = (paramInt5 - localPoint1.x - localPoint2.x) / 2;
        a(paramGC, paramImage, paramInt2, paramInt3 + i, paramInt4, paramInt6);
        break;
      case 4:
        localPoint1.x = a(paramGC, paramString, paramInt1, paramInt3, -1000, paramInt5 - localPoint2.x, paramInt6);
        a(paramGC, paramString, paramInt1, paramInt3 + paramInt5 - (localPoint1.x + localPoint2.x), paramInt4, paramInt5 - localPoint2.x, paramInt6);
        a(paramGC, paramImage, paramInt2, paramInt3 + paramInt5 - localPoint2.x, paramInt4, paramInt6);
        break;
      default:
        throw new SWTException("Unknown alignment for text: " + (paramInt2 & 0xF));
      }
    throw new SWTException("Unknown alignment for text: " + (paramInt1 & 0xF));
  }

  protected void a(GC paramGC, Rectangle paramRectangle, String paramString, Image paramImage, Color paramColor1, Color paramColor2)
  {
    if (paramRectangle.height <= 0)
      paramRectangle.height = 1;
    if (paramRectangle.width <= 0)
      paramRectangle.width = 1;
    Image localImage1 = new Image(K, paramRectangle.height, paramRectangle.width);
    GC localGC = new GC(localImage1);
    a(localGC);
    localGC.setForeground(paramColor1);
    localGC.setBackground(paramColor2);
    localGC.fillRectangle(localImage1.getBounds());
    int i = h();
    a(localGC, paramString, i, paramImage, i, 3, 3, paramRectangle.height - 6, paramRectangle.width - 6);
    localGC.dispose();
    Image localImage2 = a(localImage1);
    localImage1.dispose();
    paramGC.setForeground(paramColor1);
    paramGC.setBackground(paramColor2);
    paramGC.drawImage(localImage2, paramRectangle.x, paramRectangle.y);
    localImage1.dispose();
    localImage2.dispose();
  }

  private int h()
  {
    int i = a();
    int j = 0;
    if ((i & 0xF) == 7)
      j = 48;
    else if ((i & 0xF) == 4)
      j = 16;
    else
      j = 32;
    if ((i & 0xF0) == 48)
      j |= 7;
    else if ((i & 0xF0) == 16)
      j |= 4;
    else
      j |= 1;
    j |= 0xF00 & i;
    return j;
  }

  protected Image a(Image paramImage)
  {
    Rectangle localRectangle = paramImage.getBounds();
    ImageData localImageData1 = paramImage.getImageData();
    ImageData localImageData2 = new ImageData(localImageData1.height, localImageData1.width, localImageData1.depth, localImageData1.palette);
    for (int i = 0; i < localRectangle.width; i++)
      for (int j = 0; j < localRectangle.height; j++)
        localImageData2.setPixel(localImageData1.height - j - 1, i, localImageData1.getPixel(i, j));
    return new Image(K, localImageData2);
  }

  protected void b(GC paramGC, Rectangle paramRectangle)
  {
    paramGC.setBackground(w);
    paramGC.fillPolygon(new int[] { paramRectangle.x + paramRectangle.width - 4, paramRectangle.y, paramRectangle.x + paramRectangle.width, paramRectangle.y, paramRectangle.x + paramRectangle.width, paramRectangle.y + 4 });
  }

  public int a(GC paramGC, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramString == null)
      paramString = "";
    if ((paramInt1 & 0xF00) == 2304)
    {
      paramString = a(paramGC, paramString, paramInt4);
      paramString = b(paramGC, paramString, paramInt5);
    }
    Rectangle localRectangle1 = paramGC.getClipping();
    Rectangle localRectangle2 = new Rectangle(paramInt2, paramInt3, paramInt4, paramInt5);
    localRectangle2.intersect(localRectangle1);
    paramGC.setClipping(localRectangle2);
    Point localPoint = a(paramGC, paramString);
    if ((paramInt1 & 0xF0) == 16)
    {
      paramGC.drawText(paramString, paramInt2, paramInt3);
    }
    else if ((paramInt1 & 0xF0) == 32)
    {
      paramGC.drawText(paramString, paramInt2, paramInt3 + paramInt5 - localPoint.y);
    }
    else if ((paramInt1 & 0xF0) == 48)
    {
      int i = (paramInt5 - localPoint.y) / 2;
      paramGC.drawText(paramString, paramInt2, paramInt3 + i);
    }
    else
    {
      paramGC.drawText(paramString, paramInt2, paramInt3);
    }
    paramGC.setClipping(localRectangle1);
    return localPoint.x;
  }

  protected String a(GC paramGC, String paramString, int paramInt)
  {
    Point localPoint1 = a(paramGC, paramString);
    if (localPoint1.x > paramInt)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      String[] arrayOfString = paramString.split("\n");
      int i = paramInt / paramGC.getFontMetrics().getAverageCharWidth();
      if (i < 3)
        return paramString;
      for (int j = 0; j < arrayOfString.length; j++)
      {
        int k = 0;
        while (k < arrayOfString[j].length())
        {
          String str = arrayOfString[j].substring(k, Math.min(k + i, arrayOfString[j].length()));
          for (Point localPoint2 = a(paramGC, str); (str.length() > 0) && (localPoint2.x >= paramInt); localPoint2 = a(paramGC, str))
            str = str.substring(0, Math.max(str.length() - 1, 0));
          localStringBuffer.append(str);
          k += str.length();
          localStringBuffer.append('\n');
        }
      }
      return localStringBuffer.substring(0, Math.max(localStringBuffer.length() - 1, 0));
    }
    return paramString;
  }

  protected String b(GC paramGC, String paramString, int paramInt)
  {
    String[] arrayOfString = paramString.split("\n");
    int i = paramInt / paramGC.getFontMetrics().getHeight();
    if (i < 1)
      i = 1;
    if (arrayOfString.length <= i)
      return paramString;
    StringBuffer localStringBuffer = new StringBuffer();
    for (int j = 0; j < i; j++)
    {
      localStringBuffer.append(arrayOfString[j]);
      localStringBuffer.append('\n');
    }
    return localStringBuffer.substring(0, Math.max(localStringBuffer.length() - 1, 0));
  }

  protected void a(GC paramGC, Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramImage == null)
      return;
    Rectangle localRectangle = paramImage.getBounds();
    Point localPoint = new Point(localRectangle.width, localRectangle.height);
    if ((paramInt1 & 0xF0) == 16)
    {
      paramGC.drawImage(paramImage, paramInt2, paramInt3);
      return;
    }
    if ((paramInt1 & 0xF0) == 32)
    {
      paramGC.drawImage(paramImage, paramInt2, paramInt3 + paramInt4 - localPoint.y);
      return;
    }
    if ((paramInt1 & 0xF0) == 48)
    {
      int i = (paramInt4 - localPoint.y) / 2;
      paramGC.drawImage(paramImage, paramInt2, paramInt3 + i);
      return;
    }
    throw new SWTException("Unknown alignment for image: " + (paramInt1 & 0xF0));
  }

  protected void a(GC paramGC, Image paramImage, int paramInt1, int paramInt2, int paramInt3)
  {
    Rectangle localRectangle = paramImage.getBounds();
    Point localPoint = new Point(localRectangle.width, localRectangle.height);
    ImageData localImageData = new ImageData(localPoint.x, localPoint.y, 24, new PaletteData(255, 255, 255));
    localImageData.alpha = paramInt3;
    Image localImage = new Image(K, localImageData);
    GC localGC = new GC(localImage);
    localGC.drawImage(paramImage, 0, 0);
    paramGC.drawImage(localImage, paramInt1, paramInt2);
    localGC.dispose();
    localImage.dispose();
  }

  public static synchronized Point a(GC paramGC, String paramString)
  {
    if (a != paramGC)
    {
      V.clear();
      a = paramGC;
    }
    Point localPoint = (Point)V.get(paramString);
    if (localPoint == null)
    {
      if (paramString == null)
        return new Point(0, 0);
      localPoint = paramGC.textExtent(paramString);
      V.put(paramString, localPoint);
    }
    return new Point(localPoint.x, localPoint.y);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.b.a
 * JD-Core Version:    0.6.0
 */