package com.flagleader.builder.widget;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.ScrollBar;

class A extends Layout
{
  boolean a = false;
  static final int b = 64;
  static final int c = 64;

  A(w paramw)
  {
  }

  protected Point computeSize(Composite paramComposite, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    w localw = (w)paramComposite;
    if (localw.a == null)
    {
      int i = paramInt1 != -1 ? paramInt1 : 64;
      int j = paramInt2 != -1 ? paramInt2 : 64;
      return new Point(i, j);
    }
    Point localPoint = localw.a.computeSize(paramInt1, paramInt2, paramBoolean);
    if (localw.g)
    {
      ScrollBar localScrollBar1 = localw.getHorizontalBar();
      ScrollBar localScrollBar2 = localw.getVerticalBar();
      if (localScrollBar1 != null)
        localPoint.y += localScrollBar1.getSize().y;
      if (localScrollBar2 != null)
        localPoint.x += localScrollBar2.getSize().x;
    }
    return localPoint;
  }

  protected boolean flushCache(Control paramControl)
  {
    return true;
  }

  protected void layout(Composite paramComposite, boolean paramBoolean)
  {
    if (this.a)
      return;
    w localw = (w)paramComposite;
    if (localw.a == null)
      return;
    this.a = true;
    Rectangle localRectangle1 = localw.a.getBounds();
    ScrollBar localScrollBar1 = localw.getHorizontalBar();
    ScrollBar localScrollBar2 = localw.getVerticalBar();
    if (!localw.g)
    {
      boolean bool1 = localw.a(localRectangle1, false);
      boolean bool2 = localw.b(localRectangle1, bool1);
      if ((!bool1) && (bool2))
        bool1 = localw.a(localRectangle1, bool2);
      if (localScrollBar1 != null)
        localScrollBar1.setVisible(bool1);
      if (localScrollBar2 != null)
        localScrollBar2.setVisible(bool2);
    }
    Rectangle localRectangle2 = localw.getClientArea();
    if (localw.e)
      localRectangle1.width = Math.max(localw.d, localRectangle2.width);
    if (localw.f)
      localRectangle1.height = Math.max(localw.c, localRectangle2.height);
    int i;
    int j;
    if (localScrollBar1 != null)
    {
      localScrollBar1.setMaximum(localRectangle1.width);
      localScrollBar1.setThumb(Math.min(localRectangle1.width, localRectangle2.width));
      localScrollBar1.setIncrement(10);
      localScrollBar1.setPageIncrement(Math.min(localRectangle1.width, localRectangle2.width) / 2);
      i = localRectangle1.width - localRectangle2.width;
      j = localScrollBar1.getSelection();
      if (j >= i)
      {
        if (i <= 0)
        {
          j = 0;
          localScrollBar1.setSelection(0);
        }
        localRectangle1.x = (-j);
      }
    }
    if (localScrollBar2 != null)
    {
      localScrollBar2.setMaximum(localRectangle1.height);
      localScrollBar2.setThumb(Math.min(localRectangle1.height, localRectangle2.height));
      localScrollBar2.setIncrement(20);
      localScrollBar2.setPageIncrement(Math.min(localRectangle1.height, localRectangle2.height) / 2);
      i = localRectangle1.height - localRectangle2.height;
      j = localScrollBar2.getSelection();
      if (j >= i)
      {
        if (i <= 0)
        {
          j = 0;
          localScrollBar2.setSelection(0);
        }
        localRectangle1.y = (-j);
      }
    }
    localw.a.setBounds(localRectangle1);
    this.a = false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.A
 * JD-Core Version:    0.6.0
 */