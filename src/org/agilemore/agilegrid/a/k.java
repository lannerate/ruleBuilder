package org.agilemore.agilegrid.a;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

class k extends Layout
{
  private k(g paramg)
  {
  }

  public void layout(Composite paramComposite, boolean paramBoolean)
  {
    Rectangle localRectangle = paramComposite.getClientArea();
    Point localPoint = g.a(this.a).computeSize(-1, -1, paramBoolean);
    if (g.b(this.a) != null)
      g.b(this.a).setBounds(0, 0, localRectangle.width - localPoint.x, localRectangle.height);
    g.a(this.a).setBounds(localRectangle.width - localPoint.x, 0, localPoint.x, localRectangle.height);
  }

  public Point computeSize(Composite paramComposite, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 != -1) && (paramInt2 != -1))
      return new Point(paramInt1, paramInt2);
    Point localPoint1 = g.b(this.a).computeSize(-1, -1, paramBoolean);
    Point localPoint2 = g.a(this.a).computeSize(-1, -1, paramBoolean);
    Point localPoint3 = new Point(localPoint2.x, Math.max(localPoint1.y, localPoint2.y));
    return localPoint3;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.k
 * JD-Core Version:    0.6.0
 */