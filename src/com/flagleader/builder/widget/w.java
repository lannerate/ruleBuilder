package com.flagleader.builder.widget;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;

public class w extends Composite
{
  Control a;
  Listener b;
  int c = 0;
  int d = 0;
  boolean e = false;
  boolean f = false;
  boolean g = false;

  public w(Composite paramComposite, int paramInt)
  {
    super(paramComposite, a(paramInt));
    super.setLayout(new A(this));
    ScrollBar localScrollBar1 = getHorizontalBar();
    if (localScrollBar1 != null)
      localScrollBar1.addListener(13, new x(this));
    ScrollBar localScrollBar2 = getVerticalBar();
    if (localScrollBar2 != null)
      localScrollBar2.addListener(13, new y(this));
    this.b = new z(this);
  }

  static int a(int paramInt)
  {
    int i = 100666112;
    return paramInt & i;
  }

  public boolean a()
  {
    return this.g;
  }

  public Control b()
  {
    return this.a;
  }

  void c()
  {
    if (this.a == null)
      return;
    Point localPoint = this.a.getLocation();
    ScrollBar localScrollBar = getHorizontalBar();
    int i = localScrollBar.getSelection();
    this.a.setLocation(-i, localPoint.y);
  }

  boolean a(Rectangle paramRectangle, boolean paramBoolean)
  {
    ScrollBar localScrollBar1 = getHorizontalBar();
    if (localScrollBar1 == null)
      return false;
    Rectangle localRectangle = getBounds();
    int i = getBorderWidth();
    localRectangle.width -= 2 * i;
    ScrollBar localScrollBar2 = getVerticalBar();
    if ((paramBoolean) && (localScrollBar2 != null))
      localRectangle.width -= localScrollBar2.getSize().x;
    if ((!this.e) && (paramRectangle.width > localRectangle.width))
      return true;
    return (this.e) && (this.d > localRectangle.width);
  }

  boolean b(Rectangle paramRectangle, boolean paramBoolean)
  {
    ScrollBar localScrollBar1 = getVerticalBar();
    if (localScrollBar1 == null)
      return false;
    Rectangle localRectangle = getBounds();
    int i = getBorderWidth();
    localRectangle.height -= 2 * i;
    ScrollBar localScrollBar2 = getHorizontalBar();
    if ((paramBoolean) && (localScrollBar2 != null))
      localRectangle.height -= localScrollBar2.getSize().y;
    if ((!this.f) && (paramRectangle.height > localRectangle.height))
      return true;
    return (this.f) && (this.c > localRectangle.height);
  }

  public Point d()
  {
    checkWidget();
    if (this.a == null)
      return new Point(0, 0);
    Point localPoint = this.a.getLocation();
    return new Point(-localPoint.x, -localPoint.y);
  }

  public void a(Point paramPoint)
  {
    a(paramPoint.x, paramPoint.y);
  }

  public void a(int paramInt1, int paramInt2)
  {
    checkWidget();
    if (this.a == null)
      return;
    ScrollBar localScrollBar1 = getHorizontalBar();
    if (localScrollBar1 != null)
    {
      localScrollBar1.setSelection(paramInt1);
      paramInt1 = -localScrollBar1.getSelection();
    }
    else
    {
      paramInt1 = 0;
    }
    ScrollBar localScrollBar2 = getVerticalBar();
    if (localScrollBar2 != null)
    {
      localScrollBar2.setSelection(paramInt2);
      paramInt2 = -localScrollBar2.getSelection();
    }
    else
    {
      paramInt2 = 0;
    }
    this.a.setLocation(paramInt1, paramInt2);
  }

  public void a(boolean paramBoolean)
  {
    checkWidget();
    if (paramBoolean == this.g)
      return;
    this.g = paramBoolean;
    ScrollBar localScrollBar1 = getHorizontalBar();
    if ((localScrollBar1 != null) && (this.g))
      localScrollBar1.setVisible(true);
    ScrollBar localScrollBar2 = getVerticalBar();
    if ((localScrollBar2 != null) && (this.g))
      localScrollBar2.setVisible(true);
    layout(false);
  }

  public void a(Control paramControl)
  {
    checkWidget();
    if ((this.a != null) && (!this.a.isDisposed()))
    {
      this.a.removeListener(11, this.b);
      this.a.setBounds(new Rectangle(-200, -200, 0, 0));
    }
    this.a = paramControl;
    ScrollBar localScrollBar1 = getVerticalBar();
    ScrollBar localScrollBar2 = getHorizontalBar();
    if (this.a != null)
    {
      if (localScrollBar1 != null)
      {
        localScrollBar1.setMaximum(0);
        localScrollBar1.setThumb(0);
        localScrollBar1.setSelection(0);
      }
      if (localScrollBar2 != null)
      {
        localScrollBar2.setMaximum(0);
        localScrollBar2.setThumb(0);
        localScrollBar2.setSelection(0);
      }
      paramControl.setLocation(0, 0);
      layout(false);
      this.a.addListener(11, this.b);
    }
    else
    {
      if (localScrollBar2 != null)
        localScrollBar2.setVisible(this.g);
      if (localScrollBar1 != null)
        localScrollBar1.setVisible(this.g);
    }
  }

  public void b(boolean paramBoolean)
  {
    checkWidget();
    if (paramBoolean == this.e)
      return;
    this.e = paramBoolean;
    layout(false);
  }

  public void c(boolean paramBoolean)
  {
    checkWidget();
    if (paramBoolean == this.f)
      return;
    this.f = paramBoolean;
    layout(false);
  }

  public void setLayout(Layout paramLayout)
  {
    checkWidget();
  }

  public void b(int paramInt)
  {
    b(this.d, paramInt);
  }

  public void b(Point paramPoint)
  {
    if (paramPoint == null)
      b(0, 0);
    else
      b(paramPoint.x, paramPoint.y);
  }

  public void b(int paramInt1, int paramInt2)
  {
    checkWidget();
    if ((paramInt1 == this.d) && (paramInt2 == this.c))
      return;
    this.d = Math.max(0, paramInt1);
    this.c = Math.max(0, paramInt2);
    layout(false);
  }

  public void c(int paramInt)
  {
    b(paramInt, this.c);
  }

  void e()
  {
    if (this.a == null)
      return;
    Point localPoint = this.a.getLocation();
    ScrollBar localScrollBar = getVerticalBar();
    int i = localScrollBar.getSelection();
    this.a.setLocation(localPoint.x, -i);
  }

  public Point f()
  {
    if (this.a != null)
      return this.a.getLocation();
    return new Point(0, 0);
  }

  public void c(Point paramPoint)
  {
    if (b(this.a.getBounds(), false))
    {
      this.a.setLocation(paramPoint);
      ScrollBar localScrollBar = getVerticalBar();
      localScrollBar.setSelection(-paramPoint.y);
    }
  }

  public int g()
  {
    ScrollBar localScrollBar = getVerticalBar();
    return localScrollBar.getSelection();
  }

  public void d(int paramInt)
  {
    ScrollBar localScrollBar = getVerticalBar();
    localScrollBar.setSelection(paramInt);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.w
 * JD-Core Version:    0.6.0
 */