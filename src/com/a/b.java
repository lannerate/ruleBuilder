package com.a;

import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

class b extends CompositeImageDescriptor
{
  b(Image paramImage1, int paramInt, Image paramImage2, Rectangle paramRectangle1, Rectangle paramRectangle2, Point paramPoint)
  {
  }

  protected void drawCompositeImage(int paramInt1, int paramInt2)
  {
    drawImage(this.a.getImageData(), 0, 0);
    if (this.b == 1)
      drawImage(this.c.getImageData(), 0, 0);
    else if (this.b == 2)
      drawImage(this.c.getImageData(), this.d.width - this.e.width - 1, 0);
    else if (this.b == 3)
      drawImage(this.c.getImageData(), 0, this.d.height - this.e.height - 1);
    else if (this.b == 4)
      drawImage(this.c.getImageData(), this.d.width - this.e.width - 1, this.d.height - this.e.height - 1);
  }

  protected Point getSize()
  {
    return this.f;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.a.b
 * JD-Core Version:    0.6.0
 */