package org.agilemore.agilegrid.a;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;

class c extends Layout
{
  private c(b paramb)
  {
  }

  public Point computeSize(Composite paramComposite, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 != -1) && (paramInt2 != -1))
      return new Point(paramInt1, paramInt2);
    Point localPoint1 = b.a(this.a).computeSize(-1, -1, paramBoolean);
    Point localPoint2 = b.b(this.a).computeSize(-1, -1, paramBoolean);
    return new Point(localPoint1.x + 6 + localPoint2.x, Math.max(localPoint1.y, localPoint2.y));
  }

  public void layout(Composite paramComposite, boolean paramBoolean)
  {
    Rectangle localRectangle = paramComposite.getClientArea();
    Point localPoint1 = b.a(this.a).computeSize(-1, -1, paramBoolean);
    Point localPoint2 = b.b(this.a).computeSize(-1, -1, paramBoolean);
    int i = (localRectangle.height - localPoint2.y) / 2;
    if (i < 0)
      i = 0;
    b.a(this.a).setBounds(-1, 0, localPoint1.x, localPoint1.y);
    b.b(this.a).setBounds(localPoint1.x + 6 - 1, i, localRectangle.width - localPoint1.x - 6, localRectangle.height);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.c
 * JD-Core Version:    0.6.0
 */