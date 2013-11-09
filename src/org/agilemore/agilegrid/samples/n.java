package org.agilemore.agilegrid.samples;

import java.io.InputStream;
import org.agilemore.agilegrid.b.a;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public class n extends a
{
  public n(e parame)
  {
    super(parame);
  }

  protected void e(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    Object localObject = this.U.v(paramInt1, paramInt2);
    Image localImage = a(this.U.getDisplay(), localObject.toString());
    if (localImage != null)
    {
      Rectangle localRectangle = localImage.getBounds();
      paramGC.drawImage(localImage, localRectangle.x, localRectangle.y, localRectangle.width, localRectangle.height, paramRectangle.x, paramRectangle.y, paramRectangle.width, paramRectangle.height);
      localImage.dispose();
    }
  }

  private Image a(Display paramDisplay, String paramString)
  {
    try
    {
      Image localImage = null;
      InputStream localInputStream = n.class.getResourceAsStream(paramString);
      if (localInputStream != null)
      {
        localImage = new Image(paramDisplay, localInputStream);
        localInputStream.close();
      }
      return localImage;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.n
 * JD-Core Version:    0.6.0
 */