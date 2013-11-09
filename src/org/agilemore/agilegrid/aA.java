package org.agilemore.agilegrid;

import org.eclipse.swt.graphics.Rectangle;

public class aA extends ab
{
  private int a = 10000;

  public aA(e parame)
  {
    super(parame);
    l();
  }

  public void l()
  {
    int i = 1;
    for (int j = 0; j < b(); j++)
    {
      k = b(j);
      i += k;
    }
    for (j = 0; j < b(); j++)
      super.b(j, (int)(b(j) / i * this.a) - 1);
    j = 0;
    for (int k = 0; k < b(); k++)
      j += super.f(k);
    this.a = j;
  }

  public int f(int paramInt)
  {
    au localau = this.b.w();
    Rectangle localRectangle = this.b.getClientArea();
    int i = localRectangle.width - this.b.B() * (b() + 1);
    if (localau.j())
    {
      i -= localau.c();
      i -= this.b.B();
    }
    double d = super.f(paramInt) / this.a;
    if ((this.b != null) && (!this.b.isDisposed()))
      return (int)(i * d);
    return (int)Math.round(d * 100.0D);
  }

  public void b(int paramInt1, int paramInt2)
  {
    int i = this.b.getClientArea().width;
    double d = (paramInt2 + 1) / i;
    int j;
    if (paramInt1 == b() - 1)
    {
      j = super.f(paramInt1) + super.f(paramInt1 - 1);
      super.b(paramInt1, (int)(d * this.a));
      super.b(paramInt1 - 1, j - (int)(d * this.a));
    }
    else
    {
      j = super.f(paramInt1) + super.f(paramInt1 + 1);
      super.b(paramInt1, (int)(d * this.a));
      super.b(paramInt1 + 1, j - (int)(d * this.a));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.aA
 * JD-Core Version:    0.6.0
 */