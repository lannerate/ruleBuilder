package org.agilemore.agilegrid;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public abstract class a
  implements ak
{
  protected e b;
  private Control a;
  protected G c;

  public a(e parame)
  {
    this(parame, false);
  }

  public a(e parame, boolean paramBoolean)
  {
    this.b = parame;
    if (paramBoolean)
      a(parame);
  }

  public abstract J a(int paramInt1, int paramInt2);

  public abstract boolean b(int paramInt1, int paramInt2);

  public e a()
  {
    return this.b;
  }

  public void a(J paramJ, G paramG)
  {
    Object localObject = c(paramG.c, paramG.d);
    paramJ.c(localObject);
  }

  public void b(J paramJ, G paramG)
  {
    if (paramJ.y())
    {
      Object localObject = paramJ.m();
      b(paramG.c, paramG.d, localObject);
    }
  }

  public abstract Object c(int paramInt1, int paramInt2);

  public abstract void b(int paramInt1, int paramInt2, Object paramObject);

  protected void a(G paramG)
  {
    if (!b(paramG))
    {
      if ((this.a != null) && (!this.a.isDisposed()))
      {
        this.a.dispose();
        this.a = null;
      }
      return;
    }
    if ((this.a == null) || (this.a.isDisposed()))
    {
      this.a = a(this.b);
      if (this.a == null)
        return;
      this.a.setVisible(false);
    }
    Rectangle localRectangle = this.b.d(paramG.c, paramG.d);
    Point localPoint = this.a.getSize();
    localRectangle.x = (localRectangle.x + localRectangle.width - localPoint.x - 1);
    localRectangle.y += 1;
    G localG = this.b.A();
    if ((localG.equals(paramG)) || (((this.b.getStyle() & 0x8000000) == 134217728) && (localG.c == paramG.c)))
      this.a.setBackground(an.z);
    else
      this.a.setBackground(an.t);
    this.a.setLocation(localRectangle.x, localRectangle.y);
    this.a.setVisible(true);
  }

  protected void a(e parame)
  {
    b localb = new b(this, parame);
    parame.addListener(12, localb);
    parame.addListener(1, localb);
    parame.addListener(3, localb);
    parame.addListener(8, localb);
    parame.addListener(5, localb);
    parame.addListener(32, localb);
    parame.addListener(7, localb);
  }

  protected abstract Composite a(Composite paramComposite);

  protected abstract boolean b(G paramG);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a
 * JD-Core Version:    0.6.0
 */